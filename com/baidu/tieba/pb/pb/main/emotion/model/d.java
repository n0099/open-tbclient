package com.baidu.tieba.pb.pb.main.emotion.model;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class d {
    private LocationModel aCD;
    private NewWriteModel aCE;
    private final NewWriteModel.d aCV = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.d.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? d.this.aCE.getWriteData() : writeData;
            if (z) {
                d.this.resetData();
            } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.yp())) {
                writeData2.setVcodeMD5(qVar.getVcode_md5());
                writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                writeData2.setVcodeExtra(qVar.yq());
                if (com.baidu.tbadk.q.a.gT(qVar.yp())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(d.this.bll.getPageContext().getPageActivity(), 25017, writeData2, false, qVar.yp())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(d.this.bll.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(d.this.bll.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (d.this.eRq != null) {
                d.this.eRq.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
            }
        }
    };
    private BaseActivity bll;
    private com.baidu.tbadk.editortools.pb.b dJi;
    private NewWriteModel.d eRq;
    private GetEmotionPidModel eRr;
    private EmotionImageData eRs;
    private PbModel eRt;
    private f eRu;

    public d(BaseActivity baseActivity) {
        this.bll = baseActivity;
        this.aCE = new NewWriteModel(baseActivity);
        this.aCD = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.eRs = emotionImageData;
            this.eRt = pbModel;
            this.eRu = fVar;
            if (!i.hh()) {
                this.bll.showToast(d.l.neterror);
            } else if (a(this.bll.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.eRr == null) {
                            this.eRr = new GetEmotionPidModel();
                        }
                        if (this.dJi != null) {
                            this.dJi.Dp();
                        }
                        this.eRr.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.d.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    d.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (d.this.eRq != null) {
                                    d.this.eRq.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.dJi != null) {
                    this.dJi.Dp();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.aCE.getWriteData() == null && pbModel != null) {
                this.aCE.setWriteData(pbModel.fM(null));
            }
            if (this.aCE.getWriteData() != null) {
                if (fVar.aOY().sH()) {
                    this.aCE.getWriteData().setCanNoForum(true);
                    if (fVar.aOW() != null) {
                        this.aCE.getWriteData().setVForumId(fVar.aOW().getId());
                        this.aCE.getWriteData().setVForumName(fVar.aOW().getName());
                    }
                } else {
                    this.aCE.getWriteData().setCanNoForum(false);
                    this.aCE.getWriteData().setVForumId("");
                    this.aCE.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aCE.getWriteData();
                if (this.aCD == null || !this.aCD.Th()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.aCE.getWriteData().setContent("#(" + sb.toString() + r.aP(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aCE.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aCE.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aCE.b(this.aCV);
                if (!this.aCE.startPostWrite()) {
                }
            }
        }
    }

    public void b(com.baidu.tbadk.editortools.pb.b bVar) {
        this.dJi = bVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.eRq = dVar;
    }

    private boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.l.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25017) {
                if (intent != null) {
                    WriteData writeData = this.aCE != null ? this.aCE.getWriteData() : null;
                    resetData();
                    if (this.eRq != null) {
                        this.eRq.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.eRs, this.eRt, this.eRu);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.eRr != null) {
            this.eRr.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.eRs = null;
        this.eRu = null;
        this.eRt = null;
        if (this.aCE != null) {
            this.aCE.setWriteData(null);
        }
    }
}
