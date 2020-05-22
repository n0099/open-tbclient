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
    private LocationModel emG;
    private NewWriteModel emH;
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteData cZP = writeData == null ? a.this.emH.cZP() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cZP != null && aaVar != null && !TextUtils.isEmpty(aaVar.aYl())) {
                cZP.setVcodeMD5(aaVar.getVcode_md5());
                cZP.setVcodeUrl(aaVar.getVcode_pic_url());
                cZP.setVcodeExtra(aaVar.aYm());
                if (com.baidu.tbadk.s.a.yX(aaVar.aYl())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gRv.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cZP, false, aaVar.aYl())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gRv.getPageContext().getPageActivity(), cZP, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.gRv.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cZP, postWriteCallBackData.getAccessState())));
            }
            if (a.this.jJV != null) {
                a.this.jJV.callback(z, postWriteCallBackData, aaVar, cZP, antiData);
            }
        }
    };
    private BaseFragmentActivity gRv;
    private NewWriteModel.d jJV;
    private GetEmotionPidModel jUW;
    private c jVu;
    private EmotionImageData jVv;
    private PbModel jVw;
    private e jVx;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.gRv = baseFragmentActivity;
        this.emH = new NewWriteModel(baseFragmentActivity);
        this.emG = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final e eVar) {
        if (emotionImageData != null && eVar != null) {
            this.jVv = emotionImageData;
            this.jVw = pbModel;
            this.jVx = eVar;
            if (!j.isNetWorkAvailable()) {
                this.gRv.showToast(R.string.neterror);
            } else if (a(this.gRv.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.jUW == null) {
                            this.jUW = new GetEmotionPidModel();
                        }
                        if (this.jVu != null) {
                            this.jVu.bdu();
                        }
                        this.jUW.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, eVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.jJV != null) {
                                    a.this.jJV.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.jVu != null) {
                    this.jVu.bdu();
                }
                b(emotionImageData, pbModel, eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        boolean z = true;
        if (emotionImageData != null && eVar != null) {
            if (this.emH.cZP() == null && pbModel != null) {
                this.emH.d(pbModel.yf(null));
            }
            if (this.emH.cZP() != null) {
                if (eVar.cCi().aRV()) {
                    this.emH.cZP().setCanNoForum(true);
                    if (eVar.getForum() != null) {
                        this.emH.cZP().setVForumId(eVar.getForum().getId());
                        this.emH.cZP().setVForumName(eVar.getForum().getName());
                    }
                } else {
                    this.emH.cZP().setCanNoForum(false);
                    this.emH.cZP().setVForumId("");
                    this.emH.cZP().setVForumName("");
                }
                WriteData cZP = this.emH.cZP();
                if (this.emG == null || !this.emG.bHm()) {
                    z = false;
                }
                cZP.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.emH.cZP().setContent(str);
                } else {
                    this.emH.cZP().setContent(JJ(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.emH.cZP().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.emH.cZP().setMemeText(emotionImageData.getMemeText());
                }
                this.emH.b(this.emV);
                if (!this.emH.deN()) {
                }
            }
        }
    }

    private String JJ(String str) {
        return UgcConstant.AT_RULE_TAG + str + " ";
    }

    public void b(c cVar) {
        this.jVu = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.jJV = dVar;
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
                    WriteData cZP = this.emH != null ? this.emH.cZP() : null;
                    resetData();
                    if (this.jJV != null) {
                        this.jJV.callback(true, null, null, cZP, null);
                    }
                }
            } else if (i == 11042) {
                a(this.jVv, this.jVw, this.jVx);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.jUW != null) {
            this.jUW.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.jVv = null;
        this.jVx = null;
        this.jVw = null;
        if (this.emH != null) {
            this.emH.d((WriteData) null);
        }
    }
}
