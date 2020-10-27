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
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.editortools.pb.c;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes22.dex */
public class a {
    private LocationModel fjP;
    private NewWriteModel fjQ;
    private final NewWriteModel.d fke = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteData cVv = writeData == null ? a.this.fjQ.cVv() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cVv != null && ahVar != null && !TextUtils.isEmpty(ahVar.bsv())) {
                cVv.setVcodeMD5(ahVar.getVcode_md5());
                cVv.setVcodeUrl(ahVar.getVcode_pic_url());
                cVv.setVcodeExtra(ahVar.bsw());
                if (com.baidu.tbadk.t.a.Eq(ahVar.bsv())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.ifx.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cVv, false, ahVar.bsv())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.ifx.getPageContext().getPageActivity(), cVv, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.ifx.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cVv, postWriteCallBackData.getAccessState())));
            }
            if (a.this.lnj != null) {
                a.this.lnj.callback(z, postWriteCallBackData, ahVar, cVv, antiData);
            }
        }
    };
    private BaseFragmentActivity ifx;
    private NewWriteModel.d lnj;
    private GetEmotionPidModel lyX;
    private c lzv;
    private EmotionImageData lzw;
    private PbModel lzx;
    private f lzy;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.ifx = baseFragmentActivity;
        this.fjQ = new NewWriteModel(baseFragmentActivity);
        this.fjP = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.lzw = emotionImageData;
            this.lzx = pbModel;
            this.lzy = fVar;
            if (!j.isNetWorkAvailable()) {
                this.ifx.showToast(R.string.neterror);
            } else if (a(this.ifx.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.lyX == null) {
                            this.lyX = new GetEmotionPidModel();
                        }
                        if (this.lzv != null) {
                            this.lzv.bxD();
                        }
                        this.lyX.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.lnj != null) {
                                    a.this.lnj.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.lzv != null) {
                    this.lzv.bxD();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.fjQ.cVv() == null && pbModel != null) {
                this.fjQ.e(pbModel.Dw(null));
            }
            if (this.fjQ.cVv() != null) {
                if (fVar.dfI().blx()) {
                    this.fjQ.cVv().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.fjQ.cVv().setVForumId(fVar.getForum().getId());
                        this.fjQ.cVv().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.fjQ.cVv().setCanNoForum(false);
                    this.fjQ.cVv().setVForumId("");
                    this.fjQ.cVv().setVForumName("");
                }
                WriteData cVv = this.fjQ.cVv();
                if (this.fjP == null || !this.fjP.cfL()) {
                    z = false;
                }
                cVv.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.fjQ.cVv().setContent(str);
                } else {
                    this.fjQ.cVv().setContent(PH(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.fjQ.cVv().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.fjQ.cVv().setMemeText(emotionImageData.getMemeText());
                }
                this.fjQ.b(this.fke);
                if (!this.fjQ.dIK()) {
                }
            }
        }
    }

    private String PH(String str) {
        return UgcConstant.AT_RULE_TAG + str + " ";
    }

    public void b(c cVar) {
        this.lzv = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.lnj = dVar;
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
                    WriteData cVv = this.fjQ != null ? this.fjQ.cVv() : null;
                    resetData();
                    if (this.lnj != null) {
                        this.lnj.callback(true, null, null, cVv, null);
                    }
                }
            } else if (i == 11042) {
                a(this.lzw, this.lzx, this.lzy);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.lyX != null) {
            this.lyX.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.lzw = null;
        this.lzy = null;
        this.lzx = null;
        if (this.fjQ != null) {
            this.fjQ.e((WriteData) null);
        }
    }
}
