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
/* loaded from: classes22.dex */
public class a {
    private final NewWriteModel.d fbF = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteData cSo = writeData == null ? a.this.fbr.cSo() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cSo != null && ahVar != null && !TextUtils.isEmpty(ahVar.bqC())) {
                cSo.setVcodeMD5(ahVar.getVcode_md5());
                cSo.setVcodeUrl(ahVar.getVcode_pic_url());
                cSo.setVcodeExtra(ahVar.bqD());
                if (com.baidu.tbadk.t.a.DX(ahVar.bqC())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.hSW.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cSo, false, ahVar.bqC())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.hSW.getPageContext().getPageActivity(), cSo, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.hSW.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cSo, postWriteCallBackData.getAccessState())));
            }
            if (a.this.laK != null) {
                a.this.laK.callback(z, postWriteCallBackData, ahVar, cSo, antiData);
            }
        }
    };
    private LocationModel fbq;
    private NewWriteModel fbr;
    private BaseFragmentActivity hSW;
    private NewWriteModel.d laK;
    private c lmR;
    private EmotionImageData lmS;
    private PbModel lmT;
    private f lmU;
    private GetEmotionPidModel lmt;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.hSW = baseFragmentActivity;
        this.fbr = new NewWriteModel(baseFragmentActivity);
        this.fbq = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.lmS = emotionImageData;
            this.lmT = pbModel;
            this.lmU = fVar;
            if (!j.isNetWorkAvailable()) {
                this.hSW.showToast(R.string.neterror);
            } else if (a(this.hSW.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.lmt == null) {
                            this.lmt = new GetEmotionPidModel();
                        }
                        if (this.lmR != null) {
                            this.lmR.bvK();
                        }
                        this.lmt.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.laK != null) {
                                    a.this.laK.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.lmR != null) {
                    this.lmR.bvK();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.fbr.cSo() == null && pbModel != null) {
                this.fbr.e(pbModel.Dd(null));
            }
            if (this.fbr.cSo() != null) {
                if (fVar.dcA().bjE()) {
                    this.fbr.cSo().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.fbr.cSo().setVForumId(fVar.getForum().getId());
                        this.fbr.cSo().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.fbr.cSo().setCanNoForum(false);
                    this.fbr.cSo().setVForumId("");
                    this.fbr.cSo().setVForumName("");
                }
                WriteData cSo = this.fbr.cSo();
                if (this.fbq == null || !this.fbq.ccF()) {
                    z = false;
                }
                cSo.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.fbr.cSo().setContent(str);
                } else {
                    this.fbr.cSo().setContent(Pj(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.fbr.cSo().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.fbr.cSo().setMemeText(emotionImageData.getMemeText());
                }
                this.fbr.b(this.fbF);
                if (!this.fbr.dFC()) {
                }
            }
        }
    }

    private String Pj(String str) {
        return UgcConstant.AT_RULE_TAG + str + " ";
    }

    public void b(c cVar) {
        this.lmR = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.laK = dVar;
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
                    WriteData cSo = this.fbr != null ? this.fbr.cSo() : null;
                    resetData();
                    if (this.laK != null) {
                        this.laK.callback(true, null, null, cSo, null);
                    }
                }
            } else if (i == 11042) {
                a(this.lmS, this.lmT, this.lmU);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.lmt != null) {
            this.lmt.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.lmS = null;
        this.lmU = null;
        this.lmT = null;
        if (this.fbr != null) {
            this.fbr.e((WriteData) null);
        }
    }
}
