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
    private LocationModel aCA;
    private NewWriteModel aCB;
    private final NewWriteModel.d aCR = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.d.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? d.this.aCB.getWriteData() : writeData;
            if (z) {
                d.this.resetData();
            } else if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.xZ())) {
                writeData2.setVcodeMD5(qVar.getVcode_md5());
                writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                writeData2.setVcodeExtra(qVar.ya());
                if (com.baidu.tbadk.p.a.gT(qVar.xZ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(d.this.boM.getPageContext().getPageActivity(), 25017, writeData2, false, qVar.xZ())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(d.this.boM.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(d.this.boM.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (d.this.eNV != null) {
                d.this.eNV.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
            }
        }
    };
    private BaseActivity boM;
    private com.baidu.tbadk.editortools.pb.b dQa;
    private GetEmotionPidModel eMu;
    private NewWriteModel.d eNV;
    private EmotionImageData eNW;
    private PbModel eNX;
    private f eNY;

    public d(BaseActivity baseActivity) {
        this.boM = baseActivity;
        this.aCB = new NewWriteModel(baseActivity);
        this.aCA = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.eNW = emotionImageData;
            this.eNX = pbModel;
            this.eNY = fVar;
            if (!j.hh()) {
                this.boM.showToast(d.l.neterror);
            } else if (a(this.boM.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.eMu == null) {
                            this.eMu = new GetEmotionPidModel();
                        }
                        if (this.dQa != null) {
                            this.dQa.CW();
                        }
                        this.eMu.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.d.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    d.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (d.this.eNV != null) {
                                    d.this.eNV.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.dQa != null) {
                    this.dQa.CW();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.aCB.getWriteData() == null && pbModel != null) {
                this.aCB.setWriteData(pbModel.fJ(null));
            }
            if (this.aCB.getWriteData() != null) {
                if (fVar.aNb().sH()) {
                    this.aCB.getWriteData().setCanNoForum(true);
                    if (fVar.aMZ() != null) {
                        this.aCB.getWriteData().setVForumId(fVar.aMZ().getId());
                        this.aCB.getWriteData().setVForumName(fVar.aMZ().getName());
                    }
                } else {
                    this.aCB.getWriteData().setCanNoForum(false);
                    this.aCB.getWriteData().setVForumId("");
                    this.aCB.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aCB.getWriteData();
                if (this.aCA == null || !this.aCA.UW()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.aS(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aCB.getWriteData().setContent(str);
                } else {
                    this.aCB.getWriteData().setContent(pi(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aCB.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aCB.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aCB.b(this.aCR);
                if (!this.aCB.startPostWrite()) {
                }
            }
        }
    }

    private String pi(String str) {
        return "@" + str + " ";
    }

    public void b(com.baidu.tbadk.editortools.pb.b bVar) {
        this.dQa = bVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.eNV = dVar;
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
                    WriteData writeData = this.aCB != null ? this.aCB.getWriteData() : null;
                    resetData();
                    if (this.eNV != null) {
                        this.eNV.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.eNW, this.eNX, this.eNY);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.eMu != null) {
            this.eMu.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.eNW = null;
        this.eNY = null;
        this.eNX = null;
        if (this.aCB != null) {
            this.aCB.setWriteData(null);
        }
    }
}
