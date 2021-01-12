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
/* loaded from: classes2.dex */
public class a {
    private final NewWriteModel.d fBH = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteData cYx = writeData == null ? a.this.fBs.cYx() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cYx != null && ahVar != null && !TextUtils.isEmpty(ahVar.bwm())) {
                cYx.setVcodeMD5(ahVar.getVcode_md5());
                cYx.setVcodeUrl(ahVar.getVcode_pic_url());
                cYx.setVcodeExtra(ahVar.bwn());
                if (com.baidu.tbadk.t.a.DE(ahVar.bwm())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.iEK.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cYx, false, ahVar.bwm())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.iEK.getPageContext().getPageActivity(), cYx, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.iEK.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cYx, postWriteCallBackData.getAccessState())));
            }
            if (a.this.lHX != null) {
                a.this.lHX.callback(z, postWriteCallBackData, ahVar, cYx, antiData);
            }
        }
    };
    private LocationModel fBr;
    private NewWriteModel fBs;
    private BaseFragmentActivity iEK;
    private NewWriteModel.d lHX;
    private GetEmotionPidModel lTM;
    private c lUk;
    private EmotionImageData lUl;
    private PbModel lUm;
    private f lUn;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.iEK = baseFragmentActivity;
        this.fBs = new NewWriteModel(baseFragmentActivity);
        this.fBr = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.lUl = emotionImageData;
            this.lUm = pbModel;
            this.lUn = fVar;
            if (!j.isNetWorkAvailable()) {
                this.iEK.showToast(R.string.neterror);
            } else if (a(this.iEK.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.lTM == null) {
                            this.lTM = new GetEmotionPidModel();
                        }
                        if (this.lUk != null) {
                            this.lUk.bBu();
                        }
                        this.lTM.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.lHX != null) {
                                    a.this.lHX.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.lUk != null) {
                    this.lUk.bBu();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.fBs.cYx() == null && pbModel != null) {
                this.fBs.f(pbModel.CC(null));
            }
            if (this.fBs.cYx() != null) {
                if (fVar.diN().boX()) {
                    this.fBs.cYx().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.fBs.cYx().setVForumId(fVar.getForum().getId());
                        this.fBs.cYx().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.fBs.cYx().setCanNoForum(false);
                    this.fBs.cYx().setVForumId("");
                    this.fBs.cYx().setVForumName("");
                }
                WriteData cYx = this.fBs.cYx();
                if (this.fBr == null || !this.fBr.ckC()) {
                    z = false;
                }
                cYx.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(",");
                sb.append(emotionImageData.getWidth()).append(",");
                sb.append(emotionImageData.getHeight()).append(",");
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.fBs.cYx().setContent(str);
                } else {
                    this.fBs.cYx().setContent(OZ(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.fBs.cYx().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.fBs.cYx().setMemeText(emotionImageData.getMemeText());
                }
                this.fBs.b(this.fBH);
                if (!this.fBs.dMK()) {
                }
            }
        }
    }

    private String OZ(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.lUk = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.lHX = dVar;
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
                    WriteData cYx = this.fBs != null ? this.fBs.cYx() : null;
                    resetData();
                    if (this.lHX != null) {
                        this.lHX.callback(true, null, null, cYx, null);
                    }
                }
            } else if (i == 11042) {
                a(this.lUl, this.lUm, this.lUn);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.lTM != null) {
            this.lTM.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.lUl = null;
        this.lUn = null;
        this.lUm = null;
        if (this.fBs != null) {
            this.fBs.f((WriteData) null);
        }
    }
}
