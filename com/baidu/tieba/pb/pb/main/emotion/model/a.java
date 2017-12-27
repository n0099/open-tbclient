package com.baidu.tieba.pb.pb.main.emotion.model;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
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
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.editortools.pb.c;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class a {
    private LocationModel brA;
    private NewWriteModel brB;
    private final NewWriteModel.d brP = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.brB.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && sVar != null && !TextUtils.isEmpty(sVar.FI())) {
                writeData2.setVcodeMD5(sVar.getVcode_md5());
                writeData2.setVcodeUrl(sVar.getVcode_pic_url());
                writeData2.setVcodeExtra(sVar.FJ());
                if (com.baidu.tbadk.p.a.hf(sVar.FI())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.cmI.getPageContext().getPageActivity(), 25017, writeData2, false, sVar.FI())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.cmI.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.cmI.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.fKc != null) {
                a.this.fKc.callback(z, postWriteCallBackData, sVar, writeData2, antiData);
            }
        }
    };
    private BaseActivity cmI;
    private NewWriteModel.d fKc;
    private GetEmotionPidModel fRO;
    private c fSk;
    private EmotionImageData fSl;
    private PbModel fSm;
    private f fSn;

    public a(BaseActivity baseActivity) {
        this.cmI = baseActivity;
        this.brB = new NewWriteModel(baseActivity);
        this.brA = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.fSl = emotionImageData;
            this.fSm = pbModel;
            this.fSn = fVar;
            if (!j.oI()) {
                this.cmI.showToast(d.j.neterror);
            } else if (a(this.cmI.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.fRO == null) {
                            this.fRO = new GetEmotionPidModel();
                        }
                        if (this.fSk != null) {
                            this.fSk.Lc();
                        }
                        this.fRO.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.fKc != null) {
                                    a.this.fKc.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.fSk != null) {
                    this.fSk.Lc();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.brB.getWriteData() == null && pbModel != null) {
                this.brB.setWriteData(pbModel.fZ(null));
            }
            if (this.brB.getWriteData() != null) {
                if (fVar.aYA().Ak()) {
                    this.brB.getWriteData().setCanNoForum(true);
                    if (fVar.aYy() != null) {
                        this.brB.getWriteData().setVForumId(fVar.aYy().getId());
                        this.brB.getWriteData().setVForumName(fVar.aYy().getName());
                    }
                } else {
                    this.brB.getWriteData().setCanNoForum(false);
                    this.brB.getWriteData().setVForumId("");
                    this.brB.getWriteData().setVForumName("");
                }
                WriteData writeData = this.brB.getWriteData();
                if (this.brA == null || !this.brA.agr()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + com.baidu.adp.lib.util.s.ba(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.brB.getWriteData().setContent(str);
                } else {
                    this.brB.getWriteData().setContent(qo(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.brB.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.brB.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.brB.b(this.brP);
                if (!this.brB.startPostWrite()) {
                }
            }
        }
    }

    private String qo(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.fSk = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.fKc = dVar;
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
                    WriteData writeData = this.brB != null ? this.brB.getWriteData() : null;
                    resetData();
                    if (this.fKc != null) {
                        this.fKc.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.fSl, this.fSm, this.fSn);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.fRO != null) {
            this.fRO.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fSl = null;
        this.fSn = null;
        this.fSm = null;
        if (this.brB != null) {
            this.brB.setWriteData(null);
        }
    }
}
