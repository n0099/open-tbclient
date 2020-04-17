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
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.editortools.pb.c;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes9.dex */
public class a {
    private final NewWriteModel.d dYH = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteData cSN = writeData == null ? a.this.dYt.cSN() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cSN != null && aaVar != null && !TextUtils.isEmpty(aaVar.aSh())) {
                cSN.setVcodeMD5(aaVar.getVcode_md5());
                cSN.setVcodeUrl(aaVar.getVcode_pic_url());
                cSN.setVcodeExtra(aaVar.aSi());
                if (com.baidu.tbadk.s.a.xo(aaVar.aSh())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gCG.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cSN, false, aaVar.aSh())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gCG.getPageContext().getPageActivity(), cSN, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.gCG.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cSN, postWriteCallBackData.getAccessState())));
            }
            if (a.this.jsU != null) {
                a.this.jsU.callback(z, postWriteCallBackData, aaVar, cSN, antiData);
            }
        }
    };
    private LocationModel dYs;
    private NewWriteModel dYt;
    private BaseFragmentActivity gCG;
    private c jDR;
    private EmotionImageData jDS;
    private PbModel jDT;
    private e jDU;
    private GetEmotionPidModel jDt;
    private NewWriteModel.d jsU;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.gCG = baseFragmentActivity;
        this.dYt = new NewWriteModel(baseFragmentActivity);
        this.dYs = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final e eVar) {
        if (emotionImageData != null && eVar != null) {
            this.jDS = emotionImageData;
            this.jDT = pbModel;
            this.jDU = eVar;
            if (!j.isNetWorkAvailable()) {
                this.gCG.showToast(R.string.neterror);
            } else if (a(this.gCG.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.jDt == null) {
                            this.jDt = new GetEmotionPidModel();
                        }
                        if (this.jDR != null) {
                            this.jDR.aXn();
                        }
                        this.jDt.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, eVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.jsU != null) {
                                    a.this.jsU.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.jDR != null) {
                    this.jDR.aXn();
                }
                b(emotionImageData, pbModel, eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        boolean z = true;
        if (emotionImageData != null && eVar != null) {
            if (this.dYt.cSN() == null && pbModel != null) {
                this.dYt.d(pbModel.ww(null));
            }
            if (this.dYt.cSN() != null) {
                if (eVar.cvu().aLY()) {
                    this.dYt.cSN().setCanNoForum(true);
                    if (eVar.getForum() != null) {
                        this.dYt.cSN().setVForumId(eVar.getForum().getId());
                        this.dYt.cSN().setVForumName(eVar.getForum().getName());
                    }
                } else {
                    this.dYt.cSN().setCanNoForum(false);
                    this.dYt.cSN().setVForumId("");
                    this.dYt.cSN().setVForumName("");
                }
                WriteData cSN = this.dYt.cSN();
                if (this.dYs == null || !this.dYs.bAU()) {
                    z = false;
                }
                cSN.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.dYt.cSN().setContent(str);
                } else {
                    this.dYt.cSN().setContent(HV(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.dYt.cSN().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.dYt.cSN().setMemeText(emotionImageData.getMemeText());
                }
                this.dYt.b(this.dYH);
                if (!this.dYt.cXB()) {
                }
            }
        }
    }

    private String HV(String str) {
        return UgcConstant.AT_RULE_TAG + str + " ";
    }

    public void b(c cVar) {
        this.jDR = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.jsU = dVar;
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
                    WriteData cSN = this.dYt != null ? this.dYt.cSN() : null;
                    resetData();
                    if (this.jsU != null) {
                        this.jsU.callback(true, null, null, cSN, null);
                    }
                }
            } else if (i == 11042) {
                a(this.jDS, this.jDT, this.jDU);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.jDt != null) {
            this.jDt.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.jDS = null;
        this.jDU = null;
        this.jDT = null;
        if (this.dYt != null) {
            this.dYt.d((WriteData) null);
        }
    }
}
