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
    private LocationModel fFZ;
    private NewWriteModel fGa;
    private final NewWriteModel.d fGo = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteData dco = writeData == null ? a.this.fGa.dco() : writeData;
            if (z) {
                a.this.resetData();
            } else if (dco != null && ahVar != null && !TextUtils.isEmpty(ahVar.bAf())) {
                dco.setVcodeMD5(ahVar.getVcode_md5());
                dco.setVcodeUrl(ahVar.getVcode_pic_url());
                dco.setVcodeExtra(ahVar.bAg());
                if (com.baidu.tbadk.t.a.EQ(ahVar.bAf())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.iJr.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, dco, false, ahVar.bAf())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.iJr.getPageContext().getPageActivity(), dco, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.iJr.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, dco, postWriteCallBackData.getAccessState())));
            }
            if (a.this.lMC != null) {
                a.this.lMC.callback(z, postWriteCallBackData, ahVar, dco, antiData);
            }
        }
    };
    private BaseFragmentActivity iJr;
    private NewWriteModel.d lMC;
    private c lYP;
    private EmotionImageData lYQ;
    private PbModel lYR;
    private f lYS;
    private GetEmotionPidModel lYr;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.iJr = baseFragmentActivity;
        this.fGa = new NewWriteModel(baseFragmentActivity);
        this.fFZ = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.lYQ = emotionImageData;
            this.lYR = pbModel;
            this.lYS = fVar;
            if (!j.isNetWorkAvailable()) {
                this.iJr.showToast(R.string.neterror);
            } else if (a(this.iJr.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.lYr == null) {
                            this.lYr = new GetEmotionPidModel();
                        }
                        if (this.lYP != null) {
                            this.lYP.bFn();
                        }
                        this.lYr.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.lMC != null) {
                                    a.this.lMC.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.lYP != null) {
                    this.lYP.bFn();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.fGa.dco() == null && pbModel != null) {
                this.fGa.f(pbModel.DO(null));
            }
            if (this.fGa.dco() != null) {
                if (fVar.dmE().bsQ()) {
                    this.fGa.dco().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.fGa.dco().setVForumId(fVar.getForum().getId());
                        this.fGa.dco().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.fGa.dco().setCanNoForum(false);
                    this.fGa.dco().setVForumId("");
                    this.fGa.dco().setVForumName("");
                }
                WriteData dco = this.fGa.dco();
                if (this.fFZ == null || !this.fFZ.cot()) {
                    z = false;
                }
                dco.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(",");
                sb.append(emotionImageData.getWidth()).append(",");
                sb.append(emotionImageData.getHeight()).append(",");
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.fGa.dco().setContent(str);
                } else {
                    this.fGa.dco().setContent(Qi(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.fGa.dco().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.fGa.dco().setMemeText(emotionImageData.getMemeText());
                }
                this.fGa.b(this.fGo);
                if (!this.fGa.dQB()) {
                }
            }
        }
    }

    private String Qi(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.lYP = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.lMC = dVar;
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
                    WriteData dco = this.fGa != null ? this.fGa.dco() : null;
                    resetData();
                    if (this.lMC != null) {
                        this.lMC.callback(true, null, null, dco, null);
                    }
                }
            } else if (i == 11042) {
                a(this.lYQ, this.lYR, this.lYS);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.lYr != null) {
            this.lYr.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.lYQ = null;
        this.lYS = null;
        this.lYR = null;
        if (this.fGa != null) {
            this.fGa.f((WriteData) null);
        }
    }
}
