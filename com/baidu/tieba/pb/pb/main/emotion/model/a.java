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
import com.baidu.tbadk.coreExtra.data.ab;
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData) {
            WriteData daf = writeData == null ? a.this.emH.daf() : writeData;
            if (z) {
                a.this.resetData();
            } else if (daf != null && abVar != null && !TextUtils.isEmpty(abVar.aYm())) {
                daf.setVcodeMD5(abVar.getVcode_md5());
                daf.setVcodeUrl(abVar.getVcode_pic_url());
                daf.setVcodeExtra(abVar.aYn());
                if (com.baidu.tbadk.s.a.yX(abVar.aYm())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gRG.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, daf, false, abVar.aYm())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gRG.getPageContext().getPageActivity(), daf, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.gRG.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, daf, postWriteCallBackData.getAccessState())));
            }
            if (a.this.jLb != null) {
                a.this.jLb.callback(z, postWriteCallBackData, abVar, daf, antiData);
            }
        }
    };
    private BaseFragmentActivity gRG;
    private NewWriteModel.d jLb;
    private c jWA;
    private EmotionImageData jWB;
    private PbModel jWC;
    private e jWD;
    private GetEmotionPidModel jWc;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.gRG = baseFragmentActivity;
        this.emH = new NewWriteModel(baseFragmentActivity);
        this.emG = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final e eVar) {
        if (emotionImageData != null && eVar != null) {
            this.jWB = emotionImageData;
            this.jWC = pbModel;
            this.jWD = eVar;
            if (!j.isNetWorkAvailable()) {
                this.gRG.showToast(R.string.neterror);
            } else if (a(this.gRG.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.jWc == null) {
                            this.jWc = new GetEmotionPidModel();
                        }
                        if (this.jWA != null) {
                            this.jWA.bdv();
                        }
                        this.jWc.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, eVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.jLb != null) {
                                    a.this.jLb.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.jWA != null) {
                    this.jWA.bdv();
                }
                b(emotionImageData, pbModel, eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        boolean z = true;
        if (emotionImageData != null && eVar != null) {
            if (this.emH.daf() == null && pbModel != null) {
                this.emH.d(pbModel.yf(null));
            }
            if (this.emH.daf() != null) {
                if (eVar.cCy().aRV()) {
                    this.emH.daf().setCanNoForum(true);
                    if (eVar.getForum() != null) {
                        this.emH.daf().setVForumId(eVar.getForum().getId());
                        this.emH.daf().setVForumName(eVar.getForum().getName());
                    }
                } else {
                    this.emH.daf().setCanNoForum(false);
                    this.emH.daf().setVForumId("");
                    this.emH.daf().setVForumName("");
                }
                WriteData daf = this.emH.daf();
                if (this.emG == null || !this.emG.bHo()) {
                    z = false;
                }
                daf.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.emH.daf().setContent(str);
                } else {
                    this.emH.daf().setContent(JK(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.emH.daf().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.emH.daf().setMemeText(emotionImageData.getMemeText());
                }
                this.emH.b(this.emV);
                if (!this.emH.dfc()) {
                }
            }
        }
    }

    private String JK(String str) {
        return UgcConstant.AT_RULE_TAG + str + " ";
    }

    public void b(c cVar) {
        this.jWA = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.jLb = dVar;
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
                    WriteData daf = this.emH != null ? this.emH.daf() : null;
                    resetData();
                    if (this.jLb != null) {
                        this.jLb.callback(true, null, null, daf, null);
                    }
                }
            } else if (i == 11042) {
                a(this.jWB, this.jWC, this.jWD);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.jWc != null) {
            this.jWc.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.jWB = null;
        this.jWD = null;
        this.jWC = null;
        if (this.emH != null) {
            this.emH.d((WriteData) null);
        }
    }
}
