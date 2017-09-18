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
    private final NewWriteModel.d aDB = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.d.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? d.this.aDk.getWriteData() : writeData;
            if (z) {
                d.this.resetData();
            } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.yA())) {
                writeData2.setVcodeMD5(qVar.getVcode_md5());
                writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                writeData2.setVcodeExtra(qVar.yB());
                if (com.baidu.tbadk.q.a.gX(qVar.yA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(d.this.bnc.getPageContext().getPageActivity(), 25017, writeData2, false, qVar.yA())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(d.this.bnc.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(d.this.bnc.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (d.this.eTT != null) {
                d.this.eTT.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
            }
        }
    };
    private LocationModel aDj;
    private NewWriteModel aDk;
    private BaseActivity bnc;
    private com.baidu.tbadk.editortools.pb.b dTU;
    private NewWriteModel.d eTT;
    private GetEmotionPidModel eTU;
    private EmotionImageData eTV;
    private PbModel eTW;
    private f eTX;

    public d(BaseActivity baseActivity) {
        this.bnc = baseActivity;
        this.aDk = new NewWriteModel(baseActivity);
        this.aDj = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.eTV = emotionImageData;
            this.eTW = pbModel;
            this.eTX = fVar;
            if (!i.hi()) {
                this.bnc.showToast(d.l.neterror);
            } else if (a(this.bnc.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.eTU == null) {
                            this.eTU = new GetEmotionPidModel();
                        }
                        if (this.dTU != null) {
                            this.dTU.Ds();
                        }
                        this.eTU.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.d.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    d.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (d.this.eTT != null) {
                                    d.this.eTT.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.dTU != null) {
                    this.dTU.Ds();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.aDk.getWriteData() == null && pbModel != null) {
                this.aDk.setWriteData(pbModel.fQ(null));
            }
            if (this.aDk.getWriteData() != null) {
                if (fVar.aPi().sN()) {
                    this.aDk.getWriteData().setCanNoForum(true);
                    if (fVar.aPg() != null) {
                        this.aDk.getWriteData().setVForumId(fVar.aPg().getId());
                        this.aDk.getWriteData().setVForumName(fVar.aPg().getName());
                    }
                } else {
                    this.aDk.getWriteData().setCanNoForum(false);
                    this.aDk.getWriteData().setVForumId("");
                    this.aDk.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aDk.getWriteData();
                if (this.aDj == null || !this.aDj.UC()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.aDk.getWriteData().setContent("#(" + sb.toString() + r.aS(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aDk.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aDk.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aDk.b(this.aDB);
                if (!this.aDk.startPostWrite()) {
                }
            }
        }
    }

    public void b(com.baidu.tbadk.editortools.pb.b bVar) {
        this.dTU = bVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.eTT = dVar;
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
                    WriteData writeData = this.aDk != null ? this.aDk.getWriteData() : null;
                    resetData();
                    if (this.eTT != null) {
                        this.eTT.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.eTV, this.eTW, this.eTX);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.eTU != null) {
            this.eTU.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.eTV = null;
        this.eTX = null;
        this.eTW = null;
        if (this.aDk != null) {
            this.aDk.setWriteData(null);
        }
    }
}
