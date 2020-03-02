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
    private final NewWriteModel.d dyA = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteData cHU = writeData == null ? a.this.dym.cHU() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cHU != null && aaVar != null && !TextUtils.isEmpty(aaVar.aJF())) {
                cHU.setVcodeMD5(aaVar.getVcode_md5());
                cHU.setVcodeUrl(aaVar.getVcode_pic_url());
                cHU.setVcodeExtra(aaVar.aJG());
                if (com.baidu.tbadk.s.a.wa(aaVar.aJF())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.grE.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cHU, false, aaVar.aJF())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.grE.getPageContext().getPageActivity(), cHU, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.grE.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cHU, postWriteCallBackData.getAccessState())));
            }
            if (a.this.iHa != null) {
                a.this.iHa.callback(z, postWriteCallBackData, aaVar, cHU, antiData);
            }
        }
    };
    private LocationModel dyl;
    private NewWriteModel dym;
    private BaseFragmentActivity grE;
    private NewWriteModel.d iHa;
    private c iRV;
    private EmotionImageData iRW;
    private PbModel iRX;
    private e iRY;
    private GetEmotionPidModel iRx;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.grE = baseFragmentActivity;
        this.dym = new NewWriteModel(baseFragmentActivity);
        this.dyl = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final e eVar) {
        if (emotionImageData != null && eVar != null) {
            this.iRW = emotionImageData;
            this.iRX = pbModel;
            this.iRY = eVar;
            if (!j.isNetWorkAvailable()) {
                this.grE.showToast(R.string.neterror);
            } else if (a(this.grE.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.iRx == null) {
                            this.iRx = new GetEmotionPidModel();
                        }
                        if (this.iRV != null) {
                            this.iRV.aOR();
                        }
                        this.iRx.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, eVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.iHa != null) {
                                    a.this.iHa.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.iRV != null) {
                    this.iRV.aOR();
                }
                b(emotionImageData, pbModel, eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        boolean z = true;
        if (emotionImageData != null && eVar != null) {
            if (this.dym.cHU() == null && pbModel != null) {
                this.dym.d(pbModel.vi(null));
            }
            if (this.dym.cHU() != null) {
                if (eVar.cku().aDG()) {
                    this.dym.cHU().setCanNoForum(true);
                    if (eVar.getForum() != null) {
                        this.dym.cHU().setVForumId(eVar.getForum().getId());
                        this.dym.cHU().setVForumName(eVar.getForum().getName());
                    }
                } else {
                    this.dym.cHU().setCanNoForum(false);
                    this.dym.cHU().setVForumId("");
                    this.dym.cHU().setVForumName("");
                }
                WriteData cHU = this.dym.cHU();
                if (this.dyl == null || !this.dyl.brl()) {
                    z = false;
                }
                cHU.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.dym.cHU().setContent(str);
                } else {
                    this.dym.cHU().setContent(Gn(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.dym.cHU().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.dym.cHU().setMemeText(emotionImageData.getMemeText());
                }
                this.dym.b(this.dyA);
                if (!this.dym.cMj()) {
                }
            }
        }
    }

    private String Gn(String str) {
        return "@" + str + HanziToPinyin.Token.SEPARATOR;
    }

    public void b(c cVar) {
        this.iRV = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.iHa = dVar;
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
                    WriteData cHU = this.dym != null ? this.dym.cHU() : null;
                    resetData();
                    if (this.iHa != null) {
                        this.iHa.callback(true, null, null, cHU, null);
                    }
                }
            } else if (i == 11042) {
                a(this.iRW, this.iRX, this.iRY);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.iRx != null) {
            this.iRx.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.iRW = null;
        this.iRY = null;
        this.iRX = null;
        if (this.dym != null) {
            this.dym.d((WriteData) null);
        }
    }
}
