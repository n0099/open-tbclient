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
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes9.dex */
public class a {
    private final NewWriteModel.d evL = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            WriteData dev = writeData == null ? a.this.evx.dev() : writeData;
            if (z) {
                a.this.resetData();
            } else if (dev != null && adVar != null && !TextUtils.isEmpty(adVar.bar())) {
                dev.setVcodeMD5(adVar.getVcode_md5());
                dev.setVcodeUrl(adVar.getVcode_pic_url());
                dev.setVcodeExtra(adVar.bas());
                if (com.baidu.tbadk.t.a.zq(adVar.bar())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.hep.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, dev, false, adVar.bar())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.hep.getPageContext().getPageActivity(), dev, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.hep.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, dev, postWriteCallBackData.getAccessState())));
            }
            if (a.this.keM != null) {
                a.this.keM.callback(z, postWriteCallBackData, adVar, dev, antiData);
            }
        }
    };
    private LocationModel evw;
    private NewWriteModel evx;
    private BaseFragmentActivity hep;
    private NewWriteModel.d keM;
    private GetEmotionPidModel kpS;
    private c kqq;
    private EmotionImageData kqr;
    private PbModel kqs;
    private e kqt;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.hep = baseFragmentActivity;
        this.evx = new NewWriteModel(baseFragmentActivity);
        this.evw = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final e eVar) {
        if (emotionImageData != null && eVar != null) {
            this.kqr = emotionImageData;
            this.kqs = pbModel;
            this.kqt = eVar;
            if (!j.isNetWorkAvailable()) {
                this.hep.showToast(R.string.neterror);
            } else if (a(this.hep.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.kpS == null) {
                            this.kpS = new GetEmotionPidModel();
                        }
                        if (this.kqq != null) {
                            this.kqq.bfz();
                        }
                        this.kpS.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, eVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.keM != null) {
                                    a.this.keM.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.kqq != null) {
                    this.kqq.bfz();
                }
                b(emotionImageData, pbModel, eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        boolean z = true;
        if (emotionImageData != null && eVar != null) {
            if (this.evx.dev() == null && pbModel != null) {
                this.evx.d(pbModel.yy(null));
            }
            if (this.evx.dev() != null) {
                if (eVar.cGN().aTM()) {
                    this.evx.dev().setCanNoForum(true);
                    if (eVar.getForum() != null) {
                        this.evx.dev().setVForumId(eVar.getForum().getId());
                        this.evx.dev().setVForumName(eVar.getForum().getName());
                    }
                } else {
                    this.evx.dev().setCanNoForum(false);
                    this.evx.dev().setVForumId("");
                    this.evx.dev().setVForumName("");
                }
                WriteData dev = this.evx.dev();
                if (this.evw == null || !this.evw.bKs()) {
                    z = false;
                }
                dev.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.evx.dev().setContent(str);
                } else {
                    this.evx.dev().setContent(Km(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.evx.dev().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.evx.dev().setMemeText(emotionImageData.getMemeText());
                }
                this.evx.b(this.evL);
                if (!this.evx.djn()) {
                }
            }
        }
    }

    private String Km(String str) {
        return UgcConstant.AT_RULE_TAG + str + " ";
    }

    public void b(c cVar) {
        this.kqq = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.keM = dVar;
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
                    WriteData dev = this.evx != null ? this.evx.dev() : null;
                    resetData();
                    if (this.keM != null) {
                        this.keM.callback(true, null, null, dev, null);
                    }
                }
            } else if (i == 11042) {
                a(this.kqr, this.kqs, this.kqt);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.kpS != null) {
            this.kpS.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.kqr = null;
        this.kqt = null;
        this.kqs = null;
        if (this.evx != null) {
            this.evx.d((WriteData) null);
        }
    }
}
