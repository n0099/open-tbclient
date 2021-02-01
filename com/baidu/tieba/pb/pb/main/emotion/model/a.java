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
    private LocationModel fDG;
    private NewWriteModel fDH;
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteData dav = writeData == null ? a.this.fDH.dav() : writeData;
            if (z) {
                a.this.resetData();
            } else if (dav != null && ahVar != null && !TextUtils.isEmpty(ahVar.bwE())) {
                dav.setVcodeMD5(ahVar.getVcode_md5());
                dav.setVcodeUrl(ahVar.getVcode_pic_url());
                dav.setVcodeExtra(ahVar.bwF());
                if (com.baidu.tbadk.t.a.Ea(ahVar.bwE())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.iKt.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, dav, false, ahVar.bwE())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.iKt.getPageContext().getPageActivity(), dav, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.iKt.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, dav, postWriteCallBackData.getAccessState())));
            }
            if (a.this.lQR != null) {
                a.this.lQR.callback(z, postWriteCallBackData, ahVar, dav, antiData);
            }
        }
    };
    private BaseFragmentActivity iKt;
    private NewWriteModel.d lQR;
    private GetEmotionPidModel mcQ;
    private c mdo;
    private EmotionImageData mdp;
    private PbModel mdq;
    private f mdr;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.iKt = baseFragmentActivity;
        this.fDH = new NewWriteModel(baseFragmentActivity);
        this.fDG = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.mdp = emotionImageData;
            this.mdq = pbModel;
            this.mdr = fVar;
            if (!j.isNetWorkAvailable()) {
                this.iKt.showToast(R.string.neterror);
            } else if (a(this.iKt.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.mcQ == null) {
                            this.mcQ = new GetEmotionPidModel();
                        }
                        if (this.mdo != null) {
                            this.mdo.bBM();
                        }
                        this.mcQ.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.lQR != null) {
                                    a.this.lQR.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.mdo != null) {
                    this.mdo.bBM();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.fDH.dav() == null && pbModel != null) {
                this.fDH.f(pbModel.CT(null));
            }
            if (this.fDH.dav() != null) {
                if (fVar.dkZ().bpp()) {
                    this.fDH.dav().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.fDH.dav().setVForumId(fVar.getForum().getId());
                        this.fDH.dav().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.fDH.dav().setCanNoForum(false);
                    this.fDH.dav().setVForumId("");
                    this.fDH.dav().setVForumName("");
                }
                WriteData dav = this.fDH.dav();
                if (this.fDG == null || !this.fDG.clA()) {
                    z = false;
                }
                dav.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(",");
                sb.append(emotionImageData.getWidth()).append(",");
                sb.append(emotionImageData.getHeight()).append(",");
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.fDH.dav().setContent(str);
                } else {
                    this.fDH.dav().setContent(PR(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.fDH.dav().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.fDH.dav().setMemeText(emotionImageData.getMemeText());
                }
                this.fDH.b(this.fDW);
                if (!this.fDH.dOV()) {
                }
            }
        }
    }

    private String PR(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.mdo = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.lQR = dVar;
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
                    WriteData dav = this.fDH != null ? this.fDH.dav() : null;
                    resetData();
                    if (this.lQR != null) {
                        this.lQR.callback(true, null, null, dav, null);
                    }
                }
            } else if (i == 11042) {
                a(this.mdp, this.mdq, this.mdr);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.mcQ != null) {
            this.mcQ.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.mdp = null;
        this.mdr = null;
        this.mdq = null;
        if (this.fDH != null) {
            this.fDH.f((WriteData) null);
        }
    }
}
