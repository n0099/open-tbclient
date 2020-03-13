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
    private final NewWriteModel.d dyN = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteData cHV = writeData == null ? a.this.dyz.cHV() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cHV != null && aaVar != null && !TextUtils.isEmpty(aaVar.aJG())) {
                cHV.setVcodeMD5(aaVar.getVcode_md5());
                cHV.setVcodeUrl(aaVar.getVcode_pic_url());
                cHV.setVcodeExtra(aaVar.aJH());
                if (com.baidu.tbadk.s.a.wb(aaVar.aJG())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.grR.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cHV, false, aaVar.aJG())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.grR.getPageContext().getPageActivity(), cHV, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.grR.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cHV, postWriteCallBackData.getAccessState())));
            }
            if (a.this.iHm != null) {
                a.this.iHm.callback(z, postWriteCallBackData, aaVar, cHV, antiData);
            }
        }
    };
    private LocationModel dyy;
    private NewWriteModel dyz;
    private BaseFragmentActivity grR;
    private NewWriteModel.d iHm;
    private GetEmotionPidModel iRJ;
    private c iSh;
    private EmotionImageData iSi;
    private PbModel iSj;
    private e iSk;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.grR = baseFragmentActivity;
        this.dyz = new NewWriteModel(baseFragmentActivity);
        this.dyy = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final e eVar) {
        if (emotionImageData != null && eVar != null) {
            this.iSi = emotionImageData;
            this.iSj = pbModel;
            this.iSk = eVar;
            if (!j.isNetWorkAvailable()) {
                this.grR.showToast(R.string.neterror);
            } else if (a(this.grR.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.iRJ == null) {
                            this.iRJ = new GetEmotionPidModel();
                        }
                        if (this.iSh != null) {
                            this.iSh.aOS();
                        }
                        this.iRJ.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, eVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.iHm != null) {
                                    a.this.iHm.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.iSh != null) {
                    this.iSh.aOS();
                }
                b(emotionImageData, pbModel, eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, e eVar) {
        boolean z = true;
        if (emotionImageData != null && eVar != null) {
            if (this.dyz.cHV() == null && pbModel != null) {
                this.dyz.d(pbModel.vj(null));
            }
            if (this.dyz.cHV() != null) {
                if (eVar.ckv().aDG()) {
                    this.dyz.cHV().setCanNoForum(true);
                    if (eVar.getForum() != null) {
                        this.dyz.cHV().setVForumId(eVar.getForum().getId());
                        this.dyz.cHV().setVForumName(eVar.getForum().getName());
                    }
                } else {
                    this.dyz.cHV().setCanNoForum(false);
                    this.dyz.cHV().setVForumId("");
                    this.dyz.cHV().setVForumName("");
                }
                WriteData cHV = this.dyz.cHV();
                if (this.dyy == null || !this.dyy.brm()) {
                    z = false;
                }
                cHV.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.dyz.cHV().setContent(str);
                } else {
                    this.dyz.cHV().setContent(Go(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.dyz.cHV().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.dyz.cHV().setMemeText(emotionImageData.getMemeText());
                }
                this.dyz.b(this.dyN);
                if (!this.dyz.cMk()) {
                }
            }
        }
    }

    private String Go(String str) {
        return "@" + str + HanziToPinyin.Token.SEPARATOR;
    }

    public void b(c cVar) {
        this.iSh = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.iHm = dVar;
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
                    WriteData cHV = this.dyz != null ? this.dyz.cHV() : null;
                    resetData();
                    if (this.iHm != null) {
                        this.iHm.callback(true, null, null, cHV, null);
                    }
                }
            } else if (i == 11042) {
                a(this.iSi, this.iSj, this.iSk);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.iRJ != null) {
            this.iRJ.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.iSi = null;
        this.iSk = null;
        this.iSj = null;
        if (this.dyz != null) {
            this.dyz.d((WriteData) null);
        }
    }
}
