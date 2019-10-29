package com.baidu.tieba.pb.pb.main.emotion.model;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.s;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.editortools.pb.c;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes4.dex */
public class a {
    private LocationModel cGP;
    private NewWriteModel cGQ;
    private final NewWriteModel.d cHf = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            WriteData clc = writeData == null ? a.this.cGQ.clc() : writeData;
            if (z) {
                a.this.resetData();
            } else if (clc != null && yVar != null && !TextUtils.isEmpty(yVar.apt())) {
                clc.setVcodeMD5(yVar.getVcode_md5());
                clc.setVcodeUrl(yVar.getVcode_pic_url());
                clc.setVcodeExtra(yVar.apu());
                if (com.baidu.tbadk.v.a.qv(yVar.apt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.mActivity.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, clc, false, yVar.apt())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.mActivity.getPageContext().getPageActivity(), clc, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.mActivity.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, clc, postWriteCallBackData.getAccessState())));
            }
            if (a.this.hQp != null) {
                a.this.hQp.callback(z, postWriteCallBackData, yVar, clc, antiData);
            }
        }
    };
    private NewWriteModel.d hQp;
    private c hYL;
    private EmotionImageData hYM;
    private PbModel hYN;
    private d hYO;
    private GetEmotionPidModel hYp;
    private BaseActivity mActivity;

    public a(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        this.cGQ = new NewWriteModel(baseActivity);
        this.cGP = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.hYM = emotionImageData;
            this.hYN = pbModel;
            this.hYO = dVar;
            if (!j.isNetWorkAvailable()) {
                this.mActivity.showToast(R.string.neterror);
            } else if (a(this.mActivity.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.hYp == null) {
                            this.hYp = new GetEmotionPidModel();
                        }
                        if (this.hYL != null) {
                            this.hYL.aux();
                        }
                        this.hYp.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.hQp != null) {
                                    a.this.hQp.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.hYL != null) {
                    this.hYL.aux();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.cGQ.clc() == null && pbModel != null) {
                this.cGQ.d(pbModel.pG(null));
            }
            if (this.cGQ.clc() != null) {
                if (dVar.bQz().ajX()) {
                    this.cGQ.clc().setCanNoForum(true);
                    if (dVar.getForum() != null) {
                        this.cGQ.clc().setVForumId(dVar.getForum().getId());
                        this.cGQ.clc().setVForumName(dVar.getForum().getName());
                    }
                } else {
                    this.cGQ.clc().setCanNoForum(false);
                    this.cGQ.clc().setVForumId("");
                    this.cGQ.clc().setVForumName("");
                }
                WriteData clc = this.cGQ.clc();
                if (this.cGP == null || !this.cGP.aWR()) {
                    z = false;
                }
                clc.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.cGQ.clc().setContent(str);
                } else {
                    this.cGQ.clc().setContent(Bd(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.cGQ.clc().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.cGQ.clc().setMemeText(emotionImageData.getMemeText());
                }
                this.cGQ.b(this.cHf);
                if (!this.cGQ.cpE()) {
                }
            }
        }
    }

    private String Bd(String str) {
        return "@" + str + HanziToPinyin.Token.SEPARATOR;
    }

    public void b(c cVar) {
        this.hYL = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.hQp = dVar;
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
                    WriteData clc = this.cGQ != null ? this.cGQ.clc() : null;
                    resetData();
                    if (this.hQp != null) {
                        this.hQp.callback(true, null, null, clc, null);
                    }
                }
            } else if (i == 11042) {
                a(this.hYM, this.hYN, this.hYO);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.hYp != null) {
            this.hYp.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.hYM = null;
        this.hYO = null;
        this.hYN = null;
        if (this.cGQ != null) {
            this.cGQ.d((WriteData) null);
        }
    }
}
