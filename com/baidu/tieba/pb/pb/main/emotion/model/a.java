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
/* loaded from: classes21.dex */
public class a {
    private LocationModel foO;
    private NewWriteModel foP;
    private final NewWriteModel.d fpd = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteData cXs = writeData == null ? a.this.foP.cXs() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cXs != null && ahVar != null && !TextUtils.isEmpty(ahVar.bul())) {
                cXs.setVcodeMD5(ahVar.getVcode_md5());
                cXs.setVcodeUrl(ahVar.getVcode_pic_url());
                cXs.setVcodeExtra(ahVar.bum());
                if (com.baidu.tbadk.t.a.Ef(ahVar.bul())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.imj.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cXs, false, ahVar.bul())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.imj.getPageContext().getPageActivity(), cXs, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.imj.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cXs, postWriteCallBackData.getAccessState())));
            }
            if (a.this.ltA != null) {
                a.this.ltA.callback(z, postWriteCallBackData, ahVar, cXs, antiData);
            }
        }
    };
    private BaseFragmentActivity imj;
    private c lFI;
    private EmotionImageData lFJ;
    private PbModel lFK;
    private f lFL;
    private GetEmotionPidModel lFk;
    private NewWriteModel.d ltA;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.imj = baseFragmentActivity;
        this.foP = new NewWriteModel(baseFragmentActivity);
        this.foO = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.lFJ = emotionImageData;
            this.lFK = pbModel;
            this.lFL = fVar;
            if (!j.isNetWorkAvailable()) {
                this.imj.showToast(R.string.neterror);
            } else if (a(this.imj.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.lFk == null) {
                            this.lFk = new GetEmotionPidModel();
                        }
                        if (this.lFI != null) {
                            this.lFI.bzs();
                        }
                        this.lFk.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.ltA != null) {
                                    a.this.ltA.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.lFI != null) {
                    this.lFI.bzs();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.foP.cXs() == null && pbModel != null) {
                this.foP.e(pbModel.Dj(null));
            }
            if (this.foP.cXs() != null) {
                if (fVar.dhH().bnb()) {
                    this.foP.cXs().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.foP.cXs().setVForumId(fVar.getForum().getId());
                        this.foP.cXs().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.foP.cXs().setCanNoForum(false);
                    this.foP.cXs().setVForumId("");
                    this.foP.cXs().setVForumName("");
                }
                WriteData cXs = this.foP.cXs();
                if (this.foO == null || !this.foO.chG()) {
                    z = false;
                }
                cXs.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.foP.cXs().setContent(str);
                } else {
                    this.foP.cXs().setContent(Pu(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.foP.cXs().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.foP.cXs().setMemeText(emotionImageData.getMemeText());
                }
                this.foP.b(this.fpd);
                if (!this.foP.dLl()) {
                }
            }
        }
    }

    private String Pu(String str) {
        return UgcConstant.AT_RULE_TAG + str + " ";
    }

    public void b(c cVar) {
        this.lFI = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.ltA = dVar;
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
                    WriteData cXs = this.foP != null ? this.foP.cXs() : null;
                    resetData();
                    if (this.ltA != null) {
                        this.ltA.callback(true, null, null, cXs, null);
                    }
                }
            } else if (i == 11042) {
                a(this.lFJ, this.lFK, this.lFL);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.lFk != null) {
            this.lFk.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.lFJ = null;
        this.lFL = null;
        this.lFK = null;
        if (this.foP != null) {
            this.foP.e((WriteData) null);
        }
    }
}
