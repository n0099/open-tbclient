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
import com.baidu.tbadk.coreExtra.data.ad;
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
/* loaded from: classes16.dex */
public class a {
    private LocationModel eBP;
    private NewWriteModel eBQ;
    private final NewWriteModel.d eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            WriteData dhF = writeData == null ? a.this.eBQ.dhF() : writeData;
            if (z) {
                a.this.resetData();
            } else if (dhF != null && adVar != null && !TextUtils.isEmpty(adVar.beo())) {
                dhF.setVcodeMD5(adVar.getVcode_md5());
                dhF.setVcodeUrl(adVar.getVcode_pic_url());
                dhF.setVcodeExtra(adVar.bep());
                if (com.baidu.tbadk.t.a.Ay(adVar.beo())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.hjZ.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, dhF, false, adVar.beo())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.hjZ.getPageContext().getPageActivity(), dhF, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.hjZ.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, dhF, postWriteCallBackData.getAccessState())));
            }
            if (a.this.knC != null) {
                a.this.knC.callback(z, postWriteCallBackData, adVar, dhF, antiData);
            }
        }
    };
    private BaseFragmentActivity hjZ;
    private NewWriteModel.d knC;
    private GetEmotionPidModel kyS;
    private c kzq;
    private EmotionImageData kzr;
    private PbModel kzs;
    private f kzt;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.hjZ = baseFragmentActivity;
        this.eBQ = new NewWriteModel(baseFragmentActivity);
        this.eBP = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.kzr = emotionImageData;
            this.kzs = pbModel;
            this.kzt = fVar;
            if (!j.isNetWorkAvailable()) {
                this.hjZ.showToast(R.string.neterror);
            } else if (a(this.hjZ.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.kyS == null) {
                            this.kyS = new GetEmotionPidModel();
                        }
                        if (this.kzq != null) {
                            this.kzq.bjj();
                        }
                        this.kyS.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.knC != null) {
                                    a.this.knC.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.kzq != null) {
                    this.kzq.bjj();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.eBQ.dhF() == null && pbModel != null) {
                this.eBQ.d(pbModel.zE(null));
            }
            if (this.eBQ.dhF() != null) {
                if (fVar.cKx().aXI()) {
                    this.eBQ.dhF().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.eBQ.dhF().setVForumId(fVar.getForum().getId());
                        this.eBQ.dhF().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.eBQ.dhF().setCanNoForum(false);
                    this.eBQ.dhF().setVForumId("");
                    this.eBQ.dhF().setVForumName("");
                }
                WriteData dhF = this.eBQ.dhF();
                if (this.eBP == null || !this.eBP.bNz()) {
                    z = false;
                }
                dhF.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.eBQ.dhF().setContent(str);
                } else {
                    this.eBQ.dhF().setContent(KZ(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.eBQ.dhF().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.eBQ.dhF().setMemeText(emotionImageData.getMemeText());
                }
                this.eBQ.b(this.eCe);
                if (!this.eBQ.dmx()) {
                }
            }
        }
    }

    private String KZ(String str) {
        return UgcConstant.AT_RULE_TAG + str + " ";
    }

    public void b(c cVar) {
        this.kzq = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.knC = dVar;
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
                    WriteData dhF = this.eBQ != null ? this.eBQ.dhF() : null;
                    resetData();
                    if (this.knC != null) {
                        this.knC.callback(true, null, null, dhF, null);
                    }
                }
            } else if (i == 11042) {
                a(this.kzr, this.kzs, this.kzt);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.kyS != null) {
            this.kyS.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.kzr = null;
        this.kzt = null;
        this.kzs = null;
        if (this.eBQ != null) {
            this.eBQ.d((WriteData) null);
        }
    }
}
