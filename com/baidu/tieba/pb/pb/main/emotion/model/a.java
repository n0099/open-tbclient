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
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes21.dex */
public class a {
    private LocationModel ePj;
    private NewWriteModel ePk;
    private final NewWriteModel.d ePy = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteData cOG = writeData == null ? a.this.ePk.cOG() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cOG != null && ahVar != null && !TextUtils.isEmpty(ahVar.bnS())) {
                cOG.setVcodeMD5(ahVar.getVcode_md5());
                cOG.setVcodeUrl(ahVar.getVcode_pic_url());
                cOG.setVcodeExtra(ahVar.bnT());
                if (com.baidu.tbadk.t.a.Dl(ahVar.bnS())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.hEa.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cOG, false, ahVar.bnS())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.hEa.getPageContext().getPageActivity(), cOG, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.hEa.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cOG, postWriteCallBackData.getAccessState())));
            }
            if (a.this.kLy != null) {
                a.this.kLy.callback(z, postWriteCallBackData, ahVar, cOG, antiData);
            }
        }
    };
    private BaseFragmentActivity hEa;
    private NewWriteModel.d kLy;
    private c kXE;
    private EmotionImageData kXF;
    private PbModel kXG;
    private f kXH;
    private GetEmotionPidModel kXg;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.hEa = baseFragmentActivity;
        this.ePk = new NewWriteModel(baseFragmentActivity);
        this.ePj = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.kXF = emotionImageData;
            this.kXG = pbModel;
            this.kXH = fVar;
            if (!j.isNetWorkAvailable()) {
                this.hEa.showToast(R.string.neterror);
            } else if (a(this.hEa.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.kXg == null) {
                            this.kXg = new GetEmotionPidModel();
                        }
                        if (this.kXE != null) {
                            this.kXE.bta();
                        }
                        this.kXg.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.kLy != null) {
                                    a.this.kLy.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.kXE != null) {
                    this.kXE.bta();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.ePk.cOG() == null && pbModel != null) {
                this.ePk.e(pbModel.Cr(null));
            }
            if (this.ePk.cOG() != null) {
                if (fVar.cYR().bgV()) {
                    this.ePk.cOG().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.ePk.cOG().setVForumId(fVar.getForum().getId());
                        this.ePk.cOG().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.ePk.cOG().setCanNoForum(false);
                    this.ePk.cOG().setVForumId("");
                    this.ePk.cOG().setVForumName("");
                }
                WriteData cOG = this.ePk.cOG();
                if (this.ePj == null || !this.ePj.bZh()) {
                    z = false;
                }
                cOG.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.ePk.cOG().setContent(str);
                } else {
                    this.ePk.cOG().setContent(Ou(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.ePk.cOG().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.ePk.cOG().setMemeText(emotionImageData.getMemeText());
                }
                this.ePk.b(this.ePy);
                if (!this.ePk.dBQ()) {
                }
            }
        }
    }

    private String Ou(String str) {
        return UgcConstant.AT_RULE_TAG + str + " ";
    }

    public void b(c cVar) {
        this.kXE = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.kLy = dVar;
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
                    WriteData cOG = this.ePk != null ? this.ePk.cOG() : null;
                    resetData();
                    if (this.kLy != null) {
                        this.kLy.callback(true, null, null, cOG, null);
                    }
                }
            } else if (i == 11042) {
                a(this.kXF, this.kXG, this.kXH);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.kXg != null) {
            this.kXg.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.kXF = null;
        this.kXH = null;
        this.kXG = null;
        if (this.ePk != null) {
            this.ePk.e((WriteData) null);
        }
    }
}
