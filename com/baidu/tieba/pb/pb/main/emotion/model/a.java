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
    private LocationModel fFf;
    private NewWriteModel fFg;
    private final NewWriteModel.d fFv = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteData daL = writeData == null ? a.this.fFg.daL() : writeData;
            if (z) {
                a.this.resetData();
            } else if (daL != null && ahVar != null && !TextUtils.isEmpty(ahVar.bwH())) {
                daL.setVcodeMD5(ahVar.getVcode_md5());
                daL.setVcodeUrl(ahVar.getVcode_pic_url());
                daL.setVcodeExtra(ahVar.bwI());
                if (com.baidu.tbadk.t.a.Ef(ahVar.bwH())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.iMq.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, daL, false, ahVar.bwH())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.iMq.getPageContext().getPageActivity(), daL, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.iMq.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, daL, postWriteCallBackData.getAccessState())));
            }
            if (a.this.lTi != null) {
                a.this.lTi.callback(z, postWriteCallBackData, ahVar, daL, antiData);
            }
        }
    };
    private BaseFragmentActivity iMq;
    private NewWriteModel.d lTi;
    private c mfG;
    private EmotionImageData mfH;
    private PbModel mfI;
    private f mfJ;
    private GetEmotionPidModel mfi;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.iMq = baseFragmentActivity;
        this.fFg = new NewWriteModel(baseFragmentActivity);
        this.fFf = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.mfH = emotionImageData;
            this.mfI = pbModel;
            this.mfJ = fVar;
            if (!j.isNetWorkAvailable()) {
                this.iMq.showToast(R.string.neterror);
            } else if (a(this.iMq.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.mfi == null) {
                            this.mfi = new GetEmotionPidModel();
                        }
                        if (this.mfG != null) {
                            this.mfG.bBP();
                        }
                        this.mfi.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.lTi != null) {
                                    a.this.lTi.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.mfG != null) {
                    this.mfG.bBP();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.fFg.daL() == null && pbModel != null) {
                this.fFg.f(pbModel.CY(null));
            }
            if (this.fFg.daL() != null) {
                if (fVar.dlp().bpr()) {
                    this.fFg.daL().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.fFg.daL().setVForumId(fVar.getForum().getId());
                        this.fFg.daL().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.fFg.daL().setCanNoForum(false);
                    this.fFg.daL().setVForumId("");
                    this.fFg.daL().setVForumName("");
                }
                WriteData daL = this.fFg.daL();
                if (this.fFf == null || !this.fFf.clN()) {
                    z = false;
                }
                daL.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(",");
                sb.append(emotionImageData.getWidth()).append(",");
                sb.append(emotionImageData.getHeight()).append(",");
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.fFg.daL().setContent(str);
                } else {
                    this.fFg.daL().setContent(PY(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.fFg.daL().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.fFg.daL().setMemeText(emotionImageData.getMemeText());
                }
                this.fFg.b(this.fFv);
                if (!this.fFg.dPm()) {
                }
            }
        }
    }

    private String PY(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.mfG = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.lTi = dVar;
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
                    WriteData daL = this.fFg != null ? this.fFg.daL() : null;
                    resetData();
                    if (this.lTi != null) {
                        this.lTi.callback(true, null, null, daL, null);
                    }
                }
            } else if (i == 11042) {
                a(this.mfH, this.mfI, this.mfJ);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.mfi != null) {
            this.mfi.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.mfH = null;
        this.mfJ = null;
        this.mfI = null;
        if (this.fFg != null) {
            this.fFg.f((WriteData) null);
        }
    }
}
