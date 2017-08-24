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
    private LocationModel aDV;
    private NewWriteModel aDW;
    private final NewWriteModel.d aEn = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.d.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? d.this.aDW.getWriteData() : writeData;
            if (z) {
                d.this.resetData();
            } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.yx())) {
                writeData2.setVcodeMD5(qVar.getVcode_md5());
                writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                writeData2.setVcodeExtra(qVar.yy());
                if (com.baidu.tbadk.q.a.hb(qVar.yx())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(d.this.bmG.getPageContext().getPageActivity(), 25017, writeData2, false, qVar.yx())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(d.this.bmG.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(d.this.bmG.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (d.this.eUy != null) {
                d.this.eUy.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
            }
        }
    };
    private BaseActivity bmG;
    private com.baidu.tbadk.editortools.pb.b dMv;
    private EmotionImageData eUA;
    private PbModel eUB;
    private f eUC;
    private NewWriteModel.d eUy;
    private GetEmotionPidModel eUz;

    public d(BaseActivity baseActivity) {
        this.bmG = baseActivity;
        this.aDW = new NewWriteModel(baseActivity);
        this.aDV = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.eUA = emotionImageData;
            this.eUB = pbModel;
            this.eUC = fVar;
            if (!i.hr()) {
                this.bmG.showToast(d.l.neterror);
            } else if (a(this.bmG.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.eUz == null) {
                            this.eUz = new GetEmotionPidModel();
                        }
                        if (this.dMv != null) {
                            this.dMv.Dx();
                        }
                        this.eUz.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.d.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    d.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (d.this.eUy != null) {
                                    d.this.eUy.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.dMv != null) {
                    this.dMv.Dx();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.aDW.getWriteData() == null && pbModel != null) {
                this.aDW.setWriteData(pbModel.fW(null));
            }
            if (this.aDW.getWriteData() != null) {
                if (fVar.aPL().sS()) {
                    this.aDW.getWriteData().setCanNoForum(true);
                    if (fVar.aPJ() != null) {
                        this.aDW.getWriteData().setVForumId(fVar.aPJ().getId());
                        this.aDW.getWriteData().setVForumName(fVar.aPJ().getName());
                    }
                } else {
                    this.aDW.getWriteData().setCanNoForum(false);
                    this.aDW.getWriteData().setVForumId("");
                    this.aDW.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aDW.getWriteData();
                if (this.aDV == null || !this.aDV.TG()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.aDW.getWriteData().setContent("#(" + sb.toString() + r.aW(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")");
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aDW.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aDW.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aDW.b(this.aEn);
                if (!this.aDW.startPostWrite()) {
                }
            }
        }
    }

    public void b(com.baidu.tbadk.editortools.pb.b bVar) {
        this.dMv = bVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.eUy = dVar;
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
                    WriteData writeData = this.aDW != null ? this.aDW.getWriteData() : null;
                    resetData();
                    if (this.eUy != null) {
                        this.eUy.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.eUA, this.eUB, this.eUC);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.eUz != null) {
            this.eUz.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.eUA = null;
        this.eUC = null;
        this.eUB = null;
        if (this.aDW != null) {
            this.aDW.setWriteData(null);
        }
    }
}
