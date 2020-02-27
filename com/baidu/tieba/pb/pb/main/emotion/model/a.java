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
    private LocationModel dyk;
    private NewWriteModel dyl;
    private final NewWriteModel.d dyz = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteData cHS = writeData == null ? a.this.dyl.cHS() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cHS != null && aaVar != null && !TextUtils.isEmpty(aaVar.aJD())) {
                cHS.setVcodeMD5(aaVar.getVcode_md5());
                cHS.setVcodeUrl(aaVar.getVcode_pic_url());
                cHS.setVcodeExtra(aaVar.aJE());
                if (com.baidu.tbadk.s.a.wa(aaVar.aJD())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.grC.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cHS, false, aaVar.aJD())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.grC.getPageContext().getPageActivity(), cHS, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.grC.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cHS, postWriteCallBackData.getAccessState())));
            }
            if (a.this.iGY != null) {
                a.this.iGY.callback(z, postWriteCallBackData, aaVar, cHS, antiData);
            }
        }
    };
    private BaseFragmentActivity grC;
    private NewWriteModel.d iGY;
    private c iRT;
    private EmotionImageData iRU;
    private PbModel iRV;
    private e iRW;
    private GetEmotionPidModel iRv;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.grC = baseFragmentActivity;
        this.dyl = new NewWriteModel(baseFragmentActivity);
        this.dyk = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final e eVar) {
        if (emotionImageData != null && eVar != null) {
            this.iRU = emotionImageData;
            this.iRV = pbModel;
            this.iRW = eVar;
            if (!j.isNetWorkAvailable()) {
                this.grC.showToast(R.string.neterror);
            } else if (a(this.grC.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.iRv == null) {
                            this.iRv = new GetEmotionPidModel();
                        }
                        if (this.iRT != null) {
                            this.iRT.aOP();
                        }
                        this.iRv.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, eVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.iGY != null) {
                                    a.this.iGY.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.iRT != null) {
                    this.iRT.aOP();
                }
                b(emotionImageData, pbModel, eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        boolean z = true;
        if (emotionImageData != null && eVar != null) {
            if (this.dyl.cHS() == null && pbModel != null) {
                this.dyl.d(pbModel.vi(null));
            }
            if (this.dyl.cHS() != null) {
                if (eVar.cks().aDE()) {
                    this.dyl.cHS().setCanNoForum(true);
                    if (eVar.getForum() != null) {
                        this.dyl.cHS().setVForumId(eVar.getForum().getId());
                        this.dyl.cHS().setVForumName(eVar.getForum().getName());
                    }
                } else {
                    this.dyl.cHS().setCanNoForum(false);
                    this.dyl.cHS().setVForumId("");
                    this.dyl.cHS().setVForumName("");
                }
                WriteData cHS = this.dyl.cHS();
                if (this.dyk == null || !this.dyk.brj()) {
                    z = false;
                }
                cHS.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.dyl.cHS().setContent(str);
                } else {
                    this.dyl.cHS().setContent(Gn(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.dyl.cHS().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.dyl.cHS().setMemeText(emotionImageData.getMemeText());
                }
                this.dyl.b(this.dyz);
                if (!this.dyl.cMh()) {
                }
            }
        }
    }

    private String Gn(String str) {
        return "@" + str + HanziToPinyin.Token.SEPARATOR;
    }

    public void b(c cVar) {
        this.iRT = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.iGY = dVar;
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
                    WriteData cHS = this.dyl != null ? this.dyl.cHS() : null;
                    resetData();
                    if (this.iGY != null) {
                        this.iGY.callback(true, null, null, cHS, null);
                    }
                }
            } else if (i == 11042) {
                a(this.iRU, this.iRV, this.iRW);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.iRv != null) {
            this.iRv.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.iRU = null;
        this.iRW = null;
        this.iRV = null;
        if (this.dyl != null) {
            this.dyl.d((WriteData) null);
        }
    }
}
