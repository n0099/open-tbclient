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
    private LocationModel fpH;
    private NewWriteModel fpI;
    private final NewWriteModel.d fpW = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteData cXW = writeData == null ? a.this.fpI.cXW() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cXW != null && ahVar != null && !TextUtils.isEmpty(ahVar.buV())) {
                cXW.setVcodeMD5(ahVar.getVcode_md5());
                cXW.setVcodeUrl(ahVar.getVcode_pic_url());
                cXW.setVcodeExtra(ahVar.buW());
                if (com.baidu.tbadk.t.a.EE(ahVar.buV())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.ilu.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cXW, false, ahVar.buV())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.ilu.getPageContext().getPageActivity(), cXW, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.ilu.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cXW, postWriteCallBackData.getAccessState())));
            }
            if (a.this.ltj != null) {
                a.this.ltj.callback(z, postWriteCallBackData, ahVar, cXW, antiData);
            }
        }
    };
    private BaseFragmentActivity ilu;
    private GetEmotionPidModel lET;
    private c lFr;
    private EmotionImageData lFs;
    private PbModel lFt;
    private f lFu;
    private NewWriteModel.d ltj;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.ilu = baseFragmentActivity;
        this.fpI = new NewWriteModel(baseFragmentActivity);
        this.fpH = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.lFs = emotionImageData;
            this.lFt = pbModel;
            this.lFu = fVar;
            if (!j.isNetWorkAvailable()) {
                this.ilu.showToast(R.string.neterror);
            } else if (a(this.ilu.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.lET == null) {
                            this.lET = new GetEmotionPidModel();
                        }
                        if (this.lFr != null) {
                            this.lFr.bAc();
                        }
                        this.lET.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.ltj != null) {
                                    a.this.ltj.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.lFr != null) {
                    this.lFr.bAc();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.fpI.cXW() == null && pbModel != null) {
                this.fpI.e(pbModel.DK(null));
            }
            if (this.fpI.cXW() != null) {
                if (fVar.dik().bnX()) {
                    this.fpI.cXW().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.fpI.cXW().setVForumId(fVar.getForum().getId());
                        this.fpI.cXW().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.fpI.cXW().setCanNoForum(false);
                    this.fpI.cXW().setVForumId("");
                    this.fpI.cXW().setVForumName("");
                }
                WriteData cXW = this.fpI.cXW();
                if (this.fpH == null || !this.fpH.cin()) {
                    z = false;
                }
                cXW.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.fpI.cXW().setContent(str);
                } else {
                    this.fpI.cXW().setContent(PY(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.fpI.cXW().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.fpI.cXW().setMemeText(emotionImageData.getMemeText());
                }
                this.fpI.b(this.fpW);
                if (!this.fpI.dLm()) {
                }
            }
        }
    }

    private String PY(String str) {
        return UgcConstant.AT_RULE_TAG + str + " ";
    }

    public void b(c cVar) {
        this.lFr = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.ltj = dVar;
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
                    WriteData cXW = this.fpI != null ? this.fpI.cXW() : null;
                    resetData();
                    if (this.ltj != null) {
                        this.ltj.callback(true, null, null, cXW, null);
                    }
                }
            } else if (i == 11042) {
                a(this.lFs, this.lFt, this.lFu);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.lET != null) {
            this.lET.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.lFs = null;
        this.lFu = null;
        this.lFt = null;
        if (this.fpI != null) {
            this.fpI.e((WriteData) null);
        }
    }
}
