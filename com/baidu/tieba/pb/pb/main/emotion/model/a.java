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
    private LocationModel dyL;
    private NewWriteModel dyM;
    private final NewWriteModel.d dza = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteData cIp = writeData == null ? a.this.dyM.cIp() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cIp != null && aaVar != null && !TextUtils.isEmpty(aaVar.aJK())) {
                cIp.setVcodeMD5(aaVar.getVcode_md5());
                cIp.setVcodeUrl(aaVar.getVcode_pic_url());
                cIp.setVcodeExtra(aaVar.aJL());
                if (com.baidu.tbadk.s.a.wc(aaVar.aJK())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gsB.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cIp, false, aaVar.aJK())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gsB.getPageContext().getPageActivity(), cIp, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.gsB.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cIp, postWriteCallBackData.getAccessState())));
            }
            if (a.this.iIN != null) {
                a.this.iIN.callback(z, postWriteCallBackData, aaVar, cIp, antiData);
            }
        }
    };
    private BaseFragmentActivity gsB;
    private NewWriteModel.d iIN;
    private c iTI;
    private EmotionImageData iTJ;
    private PbModel iTK;
    private e iTL;
    private GetEmotionPidModel iTk;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.gsB = baseFragmentActivity;
        this.dyM = new NewWriteModel(baseFragmentActivity);
        this.dyL = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final e eVar) {
        if (emotionImageData != null && eVar != null) {
            this.iTJ = emotionImageData;
            this.iTK = pbModel;
            this.iTL = eVar;
            if (!j.isNetWorkAvailable()) {
                this.gsB.showToast(R.string.neterror);
            } else if (a(this.gsB.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.iTk == null) {
                            this.iTk = new GetEmotionPidModel();
                        }
                        if (this.iTI != null) {
                            this.iTI.aOW();
                        }
                        this.iTk.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, eVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.iIN != null) {
                                    a.this.iIN.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.iTI != null) {
                    this.iTI.aOW();
                }
                b(emotionImageData, pbModel, eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        boolean z = true;
        if (emotionImageData != null && eVar != null) {
            if (this.dyM.cIp() == null && pbModel != null) {
                this.dyM.d(pbModel.vj(null));
            }
            if (this.dyM.cIp() != null) {
                if (eVar.ckP().aDK()) {
                    this.dyM.cIp().setCanNoForum(true);
                    if (eVar.getForum() != null) {
                        this.dyM.cIp().setVForumId(eVar.getForum().getId());
                        this.dyM.cIp().setVForumName(eVar.getForum().getName());
                    }
                } else {
                    this.dyM.cIp().setCanNoForum(false);
                    this.dyM.cIp().setVForumId("");
                    this.dyM.cIp().setVForumName("");
                }
                WriteData cIp = this.dyM.cIp();
                if (this.dyL == null || !this.dyL.brr()) {
                    z = false;
                }
                cIp.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.dyM.cIp().setContent(str);
                } else {
                    this.dyM.cIp().setContent(Go(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.dyM.cIp().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.dyM.cIp().setMemeText(emotionImageData.getMemeText());
                }
                this.dyM.b(this.dza);
                if (!this.dyM.cME()) {
                }
            }
        }
    }

    private String Go(String str) {
        return "@" + str + HanziToPinyin.Token.SEPARATOR;
    }

    public void b(c cVar) {
        this.iTI = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.iIN = dVar;
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
                    WriteData cIp = this.dyM != null ? this.dyM.cIp() : null;
                    resetData();
                    if (this.iIN != null) {
                        this.iIN.callback(true, null, null, cIp, null);
                    }
                }
            } else if (i == 11042) {
                a(this.iTJ, this.iTK, this.iTL);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.iTk != null) {
            this.iTk.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.iTJ = null;
        this.iTL = null;
        this.iTK = null;
        if (this.dyM != null) {
            this.dyM.d((WriteData) null);
        }
    }
}
