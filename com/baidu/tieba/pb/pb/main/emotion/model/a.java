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
            WriteData dcD = writeData == null ? a.this.fwu.dcD() : writeData;
            if (z) {
                a.this.resetData();
            } else if (dcD != null && ahVar != null && !TextUtils.isEmpty(ahVar.bxL())) {
                dcD.setVcodeMD5(ahVar.getVcode_md5());
                dcD.setVcodeUrl(ahVar.getVcode_pic_url());
                dcD.setVcodeExtra(ahVar.bxM());
                if (com.baidu.tbadk.t.a.ES(ahVar.bxL())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.ixc.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, dcD, false, ahVar.bxL())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.ixc.getPageContext().getPageActivity(), dcD, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.ixc.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, dcD, postWriteCallBackData.getAccessState())));
            }
            if (a.this.lHl != null) {
                a.this.lHl.callback(z, postWriteCallBackData, ahVar, dcD, antiData);
            }
        }
    };
    private LocationModel fwt;
    private NewWriteModel fwu;
    private BaseFragmentActivity ixc;
    private NewWriteModel.d lHl;
    private c lTB;
    private EmotionImageData lTC;
    private PbModel lTD;
    private f lTE;
    private GetEmotionPidModel lTd;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.ixc = baseFragmentActivity;
        this.fwu = new NewWriteModel(baseFragmentActivity);
        this.fwt = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.lTC = emotionImageData;
            this.lTD = pbModel;
            this.lTE = fVar;
            if (!j.isNetWorkAvailable()) {
                this.ixc.showToast(R.string.neterror);
            } else if (a(this.ixc.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.lTd == null) {
                            this.lTd = new GetEmotionPidModel();
                        }
                        if (this.lTB != null) {
                            this.lTB.bCS();
                        }
                        this.lTd.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.lHl != null) {
                                    a.this.lHl.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.lTB != null) {
                    this.lTB.bCS();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.fwu.dcD() == null && pbModel != null) {
                this.fwu.e(pbModel.DR(null));
            }
            if (this.fwu.dcD() != null) {
                if (fVar.dmT().bqo()) {
                    this.fwu.dcD().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.fwu.dcD().setVForumId(fVar.getForum().getId());
                        this.fwu.dcD().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.fwu.dcD().setCanNoForum(false);
                    this.fwu.dcD().setVForumId("");
                    this.fwu.dcD().setVForumName("");
                }
                WriteData dcD = this.fwu.dcD();
                if (this.fwt == null || !this.fwt.clB()) {
                    z = false;
                }
                dcD.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(",");
                sb.append(emotionImageData.getWidth()).append(",");
                sb.append(emotionImageData.getHeight()).append(",");
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.fwu.dcD().setContent(str);
                } else {
                    this.fwu.dcD().setContent(QC(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.fwu.dcD().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.fwu.dcD().setMemeText(emotionImageData.getMemeText());
                }
                this.fwu.b(this.fwI);
                if (!this.fwu.dQD()) {
                }
            }
        }
    }

    private String QC(String str) {
        return UgcConstant.AT_RULE_TAG + str + " ";
    }

    public void b(c cVar) {
        this.lTB = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.lHl = dVar;
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
                    WriteData dcD = this.fwu != null ? this.fwu.dcD() : null;
                    resetData();
                    if (this.lHl != null) {
                        this.lHl.callback(true, null, null, dcD, null);
                    }
                }
            } else if (i == 11042) {
                a(this.lTC, this.lTD, this.lTE);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.lTd != null) {
            this.lTd.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.lTC = null;
        this.lTE = null;
        this.lTD = null;
        if (this.fwu != null) {
            this.fwu.e((WriteData) null);
        }
    }
}
