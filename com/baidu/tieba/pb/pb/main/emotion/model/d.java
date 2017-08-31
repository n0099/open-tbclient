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
    private final NewWriteModel.d aDE = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.d.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? d.this.aDn.getWriteData() : writeData;
            if (z) {
                d.this.resetData();
            } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.yA())) {
                writeData2.setVcodeMD5(qVar.getVcode_md5());
                writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                writeData2.setVcodeExtra(qVar.yB());
                if (com.baidu.tbadk.q.a.gX(qVar.yA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(d.this.bnd.getPageContext().getPageActivity(), 25017, writeData2, false, qVar.yA())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(d.this.bnd.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(d.this.bnd.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (d.this.eSZ != null) {
                d.this.eSZ.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
            }
        }
    };
    private LocationModel aDm;
    private NewWriteModel aDn;
    private BaseActivity bnd;
    private com.baidu.tbadk.editortools.pb.b dTa;
    private NewWriteModel.d eSZ;
    private GetEmotionPidModel eTa;
    private EmotionImageData eTb;
    private PbModel eTc;
    private f eTd;

    public d(BaseActivity baseActivity) {
        this.bnd = baseActivity;
        this.aDn = new NewWriteModel(baseActivity);
        this.aDm = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.eTb = emotionImageData;
            this.eTc = pbModel;
            this.eTd = fVar;
            if (!i.hi()) {
                this.bnd.showToast(d.l.neterror);
            } else if (a(this.bnd.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.eTa == null) {
                            this.eTa = new GetEmotionPidModel();
                        }
                        if (this.dTa != null) {
                            this.dTa.Ds();
                        }
                        this.eTa.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.d.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    d.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (d.this.eSZ != null) {
                                    d.this.eSZ.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.dTa != null) {
                    this.dTa.Ds();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.aDn.getWriteData() == null && pbModel != null) {
                this.aDn.setWriteData(pbModel.fQ(null));
            }
            if (this.aDn.getWriteData() != null) {
                if (fVar.aOX().sN()) {
                    this.aDn.getWriteData().setCanNoForum(true);
                    if (fVar.aOV() != null) {
                        this.aDn.getWriteData().setVForumId(fVar.aOV().getId());
                        this.aDn.getWriteData().setVForumName(fVar.aOV().getName());
                    }
                } else {
                    this.aDn.getWriteData().setCanNoForum(false);
                    this.aDn.getWriteData().setVForumId("");
                    this.aDn.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aDn.getWriteData();
                if (this.aDm == null || !this.aDm.Us()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.aDn.getWriteData().setContent("#(" + sb.toString() + r.aS(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aDn.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aDn.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aDn.b(this.aDE);
                if (!this.aDn.startPostWrite()) {
                }
            }
        }
    }

    public void b(com.baidu.tbadk.editortools.pb.b bVar) {
        this.dTa = bVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.eSZ = dVar;
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
                    WriteData writeData = this.aDn != null ? this.aDn.getWriteData() : null;
                    resetData();
                    if (this.eSZ != null) {
                        this.eSZ.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.eTb, this.eTc, this.eTd);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.eTa != null) {
            this.eTa.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.eTb = null;
        this.eTd = null;
        this.eTc = null;
        if (this.aDn != null) {
            this.aDn.setWriteData(null);
        }
    }
}
