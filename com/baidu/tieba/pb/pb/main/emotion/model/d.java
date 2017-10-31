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
    private LocationModel aCW;
    private NewWriteModel aCX;
    private final NewWriteModel.d aDo = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.d.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? d.this.aCX.getWriteData() : writeData;
            if (z) {
                d.this.resetData();
            } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.xZ())) {
                writeData2.setVcodeMD5(qVar.getVcode_md5());
                writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                writeData2.setVcodeExtra(qVar.ya());
                if (com.baidu.tbadk.q.a.ha(qVar.xZ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(d.this.brJ.getPageContext().getPageActivity(), 25017, writeData2, false, qVar.xZ())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(d.this.brJ.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(d.this.brJ.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (d.this.eNK != null) {
                d.this.eNK.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
            }
        }
    };
    private BaseActivity brJ;
    private com.baidu.tbadk.editortools.pb.c dXz;
    private NewWriteModel.d eNK;
    private GetEmotionPidModel eVa;
    private EmotionImageData eWB;
    private PbModel eWC;
    private f eWD;

    public d(BaseActivity baseActivity) {
        this.brJ = baseActivity;
        this.aCX = new NewWriteModel(baseActivity);
        this.aCW = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.eWB = emotionImageData;
            this.eWC = pbModel;
            this.eWD = fVar;
            if (!j.hh()) {
                this.brJ.showToast(d.j.neterror);
            } else if (a(this.brJ.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.eVa == null) {
                            this.eVa = new GetEmotionPidModel();
                        }
                        if (this.dXz != null) {
                            this.dXz.Df();
                        }
                        this.eVa.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.d.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    d.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (d.this.eNK != null) {
                                    d.this.eNK.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.dXz != null) {
                    this.dXz.Df();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.aCX.getWriteData() == null && pbModel != null) {
                this.aCX.setWriteData(pbModel.fP(null));
            }
            if (this.aCX.getWriteData() != null) {
                if (fVar.aPO().sH()) {
                    this.aCX.getWriteData().setCanNoForum(true);
                    if (fVar.aPM() != null) {
                        this.aCX.getWriteData().setVForumId(fVar.aPM().getId());
                        this.aCX.getWriteData().setVForumName(fVar.aPM().getName());
                    }
                } else {
                    this.aCX.getWriteData().setCanNoForum(false);
                    this.aCX.getWriteData().setVForumId("");
                    this.aCX.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aCX.getWriteData();
                if (this.aCW == null || !this.aCW.WK()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.aS(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aCX.getWriteData().setContent(str);
                } else {
                    this.aCX.getWriteData().setContent(pM(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aCX.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aCX.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aCX.b(this.aDo);
                if (!this.aCX.startPostWrite()) {
                }
            }
        }
    }

    private String pM(String str) {
        return "@" + str + " ";
    }

    public void b(com.baidu.tbadk.editortools.pb.c cVar) {
        this.dXz = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.eNK = dVar;
    }

    private boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25017) {
                if (intent != null) {
                    WriteData writeData = this.aCX != null ? this.aCX.getWriteData() : null;
                    resetData();
                    if (this.eNK != null) {
                        this.eNK.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.eWB, this.eWC, this.eWD);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.eVa != null) {
            this.eVa.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.eWB = null;
        this.eWD = null;
        this.eWC = null;
        if (this.aCX != null) {
            this.aCX.setWriteData(null);
        }
    }
}
