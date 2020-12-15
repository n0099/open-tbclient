package com.baidu.tieba.pb.pb.main.emotion.model;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.s;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.editortools.pb.c;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes22.dex */
public class a {
    private final NewWriteModel.d fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteData dcE = writeData == null ? a.this.fwu.dcE() : writeData;
            if (z) {
                a.this.resetData();
            } else if (dcE != null && ahVar != null && !TextUtils.isEmpty(ahVar.bxL())) {
                dcE.setVcodeMD5(ahVar.getVcode_md5());
                dcE.setVcodeUrl(ahVar.getVcode_pic_url());
                dcE.setVcodeExtra(ahVar.bxM());
                if (com.baidu.tbadk.t.a.ES(ahVar.bxL())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.ixe.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, dcE, false, ahVar.bxL())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.ixe.getPageContext().getPageActivity(), dcE, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.ixe.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, dcE, postWriteCallBackData.getAccessState())));
            }
            if (a.this.lHn != null) {
                a.this.lHn.callback(z, postWriteCallBackData, ahVar, dcE, antiData);
            }
        }
    };
    private LocationModel fwt;
    private NewWriteModel fwu;
    private BaseFragmentActivity ixe;
    private NewWriteModel.d lHn;
    private c lTD;
    private EmotionImageData lTE;
    private PbModel lTF;
    private f lTG;
    private GetEmotionPidModel lTf;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.ixe = baseFragmentActivity;
        this.fwu = new NewWriteModel(baseFragmentActivity);
        this.fwt = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.lTE = emotionImageData;
            this.lTF = pbModel;
            this.lTG = fVar;
            if (!j.isNetWorkAvailable()) {
                this.ixe.showToast(R.string.neterror);
            } else if (a(this.ixe.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.lTf == null) {
                            this.lTf = new GetEmotionPidModel();
                        }
                        if (this.lTD != null) {
                            this.lTD.bCS();
                        }
                        this.lTf.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.lHn != null) {
                                    a.this.lHn.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.lTD != null) {
                    this.lTD.bCS();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.fwu.dcE() == null && pbModel != null) {
                this.fwu.e(pbModel.DR(null));
            }
            if (this.fwu.dcE() != null) {
                if (fVar.dmU().bqo()) {
                    this.fwu.dcE().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.fwu.dcE().setVForumId(fVar.getForum().getId());
                        this.fwu.dcE().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.fwu.dcE().setCanNoForum(false);
                    this.fwu.dcE().setVForumId("");
                    this.fwu.dcE().setVForumName("");
                }
                WriteData dcE = this.fwu.dcE();
                if (this.fwt == null || !this.fwt.clC()) {
                    z = false;
                }
                dcE.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(",");
                sb.append(emotionImageData.getWidth()).append(",");
                sb.append(emotionImageData.getHeight()).append(",");
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.fwu.dcE().setContent(str);
                } else {
                    this.fwu.dcE().setContent(QC(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.fwu.dcE().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.fwu.dcE().setMemeText(emotionImageData.getMemeText());
                }
                this.fwu.b(this.fwI);
                if (!this.fwu.dQE()) {
                }
            }
        }
    }

    private String QC(String str) {
        return UgcConstant.AT_RULE_TAG + str + " ";
    }

    public void b(c cVar) {
        this.lTD = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.lHn = dVar;
    }

    private boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25017) {
                if (intent != null) {
                    WriteData dcE = this.fwu != null ? this.fwu.dcE() : null;
                    resetData();
                    if (this.lHn != null) {
                        this.lHn.callback(true, null, null, dcE, null);
                    }
                }
            } else if (i == 11042) {
                a(this.lTE, this.lTF, this.lTG);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.lTf != null) {
            this.lTf.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.lTE = null;
        this.lTG = null;
        this.lTF = null;
        if (this.fwu != null) {
            this.fwu.e((WriteData) null);
        }
    }
}
