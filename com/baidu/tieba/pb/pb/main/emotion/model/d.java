package com.baidu.tieba.pb.pb.main.emotion.model;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.s;
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
    private final NewWriteModel.d aCE = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.d.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? d.this.aCo.getWriteData() : writeData;
            if (z) {
                d.this.resetData();
            } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.xS())) {
                writeData2.setVcodeMD5(qVar.getVcode_md5());
                writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                writeData2.setVcodeExtra(qVar.xT());
                if (com.baidu.tbadk.p.a.gS(qVar.xS())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(d.this.boA.getPageContext().getPageActivity(), 25017, writeData2, false, qVar.xS())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(d.this.boA.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(d.this.boA.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (d.this.eNH != null) {
                d.this.eNH.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
            }
        }
    };
    private LocationModel aCn;
    private NewWriteModel aCo;
    private BaseActivity boA;
    private com.baidu.tbadk.editortools.pb.b dPM;
    private GetEmotionPidModel eMg;
    private NewWriteModel.d eNH;
    private EmotionImageData eNI;
    private PbModel eNJ;
    private f eNK;

    public d(BaseActivity baseActivity) {
        this.boA = baseActivity;
        this.aCo = new NewWriteModel(baseActivity);
        this.aCn = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.eNI = emotionImageData;
            this.eNJ = pbModel;
            this.eNK = fVar;
            if (!j.hh()) {
                this.boA.showToast(d.l.neterror);
            } else if (a(this.boA.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.eMg == null) {
                            this.eMg = new GetEmotionPidModel();
                        }
                        if (this.dPM != null) {
                            this.dPM.CQ();
                        }
                        this.eMg.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.d.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    d.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (d.this.eNH != null) {
                                    d.this.eNH.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.dPM != null) {
                    this.dPM.CQ();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.aCo.getWriteData() == null && pbModel != null) {
                this.aCo.setWriteData(pbModel.fI(null));
            }
            if (this.aCo.getWriteData() != null) {
                if (fVar.aMW().sA()) {
                    this.aCo.getWriteData().setCanNoForum(true);
                    if (fVar.aMU() != null) {
                        this.aCo.getWriteData().setVForumId(fVar.aMU().getId());
                        this.aCo.getWriteData().setVForumName(fVar.aMU().getName());
                    }
                } else {
                    this.aCo.getWriteData().setCanNoForum(false);
                    this.aCo.getWriteData().setVForumId("");
                    this.aCo.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aCo.getWriteData();
                if (this.aCn == null || !this.aCn.US()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.aS(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aCo.getWriteData().setContent(str);
                } else {
                    this.aCo.getWriteData().setContent(ph(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aCo.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aCo.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aCo.b(this.aCE);
                if (!this.aCo.startPostWrite()) {
                }
            }
        }
    }

    private String ph(String str) {
        return "@" + str + " ";
    }

    public void b(com.baidu.tbadk.editortools.pb.b bVar) {
        this.dPM = bVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.eNH = dVar;
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
                    WriteData writeData = this.aCo != null ? this.aCo.getWriteData() : null;
                    resetData();
                    if (this.eNH != null) {
                        this.eNH.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.eNI, this.eNJ, this.eNK);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.eMg != null) {
            this.eMg.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.eNI = null;
        this.eNK = null;
        this.eNJ = null;
        if (this.aCo != null) {
            this.aCo.setWriteData(null);
        }
    }
}
