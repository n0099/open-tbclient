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
/* loaded from: classes2.dex */
public class a {
    private LocationModel fDG;
    private NewWriteModel fDH;
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteData daC = writeData == null ? a.this.fDH.daC() : writeData;
            if (z) {
                a.this.resetData();
            } else if (daC != null && ahVar != null && !TextUtils.isEmpty(ahVar.bwE())) {
                daC.setVcodeMD5(ahVar.getVcode_md5());
                daC.setVcodeUrl(ahVar.getVcode_pic_url());
                daC.setVcodeExtra(ahVar.bwF());
                if (com.baidu.tbadk.t.a.DY(ahVar.bwE())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.iKH.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, daC, false, ahVar.bwE())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.iKH.getPageContext().getPageActivity(), daC, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.iKH.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, daC, postWriteCallBackData.getAccessState())));
            }
            if (a.this.lRg != null) {
                a.this.lRg.callback(z, postWriteCallBackData, ahVar, daC, antiData);
            }
        }
    };
    private BaseFragmentActivity iKH;
    private NewWriteModel.d lRg;
    private c mdD;
    private EmotionImageData mdE;
    private PbModel mdF;
    private f mdG;
    private GetEmotionPidModel mdf;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.iKH = baseFragmentActivity;
        this.fDH = new NewWriteModel(baseFragmentActivity);
        this.fDG = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.mdE = emotionImageData;
            this.mdF = pbModel;
            this.mdG = fVar;
            if (!j.isNetWorkAvailable()) {
                this.iKH.showToast(R.string.neterror);
            } else if (a(this.iKH.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.mdf == null) {
                            this.mdf = new GetEmotionPidModel();
                        }
                        if (this.mdD != null) {
                            this.mdD.bBM();
                        }
                        this.mdf.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.lRg != null) {
                                    a.this.lRg.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.mdD != null) {
                    this.mdD.bBM();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.fDH.daC() == null && pbModel != null) {
                this.fDH.f(pbModel.CR(null));
            }
            if (this.fDH.daC() != null) {
                if (fVar.dlg().bpp()) {
                    this.fDH.daC().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.fDH.daC().setVForumId(fVar.getForum().getId());
                        this.fDH.daC().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.fDH.daC().setCanNoForum(false);
                    this.fDH.daC().setVForumId("");
                    this.fDH.daC().setVForumName("");
                }
                WriteData daC = this.fDH.daC();
                if (this.fDG == null || !this.fDG.clH()) {
                    z = false;
                }
                daC.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(",");
                sb.append(emotionImageData.getWidth()).append(",");
                sb.append(emotionImageData.getHeight()).append(",");
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.fDH.daC().setContent(str);
                } else {
                    this.fDH.daC().setContent(PS(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.fDH.daC().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.fDH.daC().setMemeText(emotionImageData.getMemeText());
                }
                this.fDH.b(this.fDW);
                if (!this.fDH.dPd()) {
                }
            }
        }
    }

    private String PS(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.mdD = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.lRg = dVar;
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
                    WriteData daC = this.fDH != null ? this.fDH.daC() : null;
                    resetData();
                    if (this.lRg != null) {
                        this.lRg.callback(true, null, null, daC, null);
                    }
                }
            } else if (i == 11042) {
                a(this.mdE, this.mdF, this.mdG);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.mdf != null) {
            this.mdf.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.mdE = null;
        this.mdG = null;
        this.mdF = null;
        if (this.fDH != null) {
            this.fDH.f((WriteData) null);
        }
    }
}
