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
    private final NewWriteModel.d dYM = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteData cSL = writeData == null ? a.this.dYy.cSL() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cSL != null && aaVar != null && !TextUtils.isEmpty(aaVar.aSe())) {
                cSL.setVcodeMD5(aaVar.getVcode_md5());
                cSL.setVcodeUrl(aaVar.getVcode_pic_url());
                cSL.setVcodeExtra(aaVar.aSf());
                if (com.baidu.tbadk.s.a.xr(aaVar.aSe())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gCM.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cSL, false, aaVar.aSe())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gCM.getPageContext().getPageActivity(), cSL, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.gCM.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cSL, postWriteCallBackData.getAccessState())));
            }
            if (a.this.jsY != null) {
                a.this.jsY.callback(z, postWriteCallBackData, aaVar, cSL, antiData);
            }
        }
    };
    private LocationModel dYx;
    private NewWriteModel dYy;
    private BaseFragmentActivity gCM;
    private c jDV;
    private EmotionImageData jDW;
    private PbModel jDX;
    private e jDY;
    private GetEmotionPidModel jDx;
    private NewWriteModel.d jsY;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.gCM = baseFragmentActivity;
        this.dYy = new NewWriteModel(baseFragmentActivity);
        this.dYx = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final e eVar) {
        if (emotionImageData != null && eVar != null) {
            this.jDW = emotionImageData;
            this.jDX = pbModel;
            this.jDY = eVar;
            if (!j.isNetWorkAvailable()) {
                this.gCM.showToast(R.string.neterror);
            } else if (a(this.gCM.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.jDx == null) {
                            this.jDx = new GetEmotionPidModel();
                        }
                        if (this.jDV != null) {
                            this.jDV.aXl();
                        }
                        this.jDx.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, eVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.jsY != null) {
                                    a.this.jsY.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.jDV != null) {
                    this.jDV.aXl();
                }
                b(emotionImageData, pbModel, eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        boolean z = true;
        if (emotionImageData != null && eVar != null) {
            if (this.dYy.cSL() == null && pbModel != null) {
                this.dYy.d(pbModel.wz(null));
            }
            if (this.dYy.cSL() != null) {
                if (eVar.cvs().aLW()) {
                    this.dYy.cSL().setCanNoForum(true);
                    if (eVar.getForum() != null) {
                        this.dYy.cSL().setVForumId(eVar.getForum().getId());
                        this.dYy.cSL().setVForumName(eVar.getForum().getName());
                    }
                } else {
                    this.dYy.cSL().setCanNoForum(false);
                    this.dYy.cSL().setVForumId("");
                    this.dYy.cSL().setVForumName("");
                }
                WriteData cSL = this.dYy.cSL();
                if (this.dYx == null || !this.dYx.bAS()) {
                    z = false;
                }
                cSL.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.dYy.cSL().setContent(str);
                } else {
                    this.dYy.cSL().setContent(HY(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.dYy.cSL().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.dYy.cSL().setMemeText(emotionImageData.getMemeText());
                }
                this.dYy.b(this.dYM);
                if (!this.dYy.cXz()) {
                }
            }
        }
    }

    private String HY(String str) {
        return UgcConstant.AT_RULE_TAG + str + " ";
    }

    public void b(c cVar) {
        this.jDV = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.jsY = dVar;
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
                    WriteData cSL = this.dYy != null ? this.dYy.cSL() : null;
                    resetData();
                    if (this.jsY != null) {
                        this.jsY.callback(true, null, null, cSL, null);
                    }
                }
            } else if (i == 11042) {
                a(this.jDW, this.jDX, this.jDY);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.jDx != null) {
            this.jDx.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.jDW = null;
        this.jDY = null;
        this.jDX = null;
        if (this.dYy != null) {
            this.dYy.d((WriteData) null);
        }
    }
}
