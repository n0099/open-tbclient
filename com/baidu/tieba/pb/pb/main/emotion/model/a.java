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
/* loaded from: classes.dex */
public class a {
    private LocationModel aDG;
    private NewWriteModel aDH;
    private final NewWriteModel.d aDV = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.aDH.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && sVar != null && !TextUtils.isEmpty(sVar.yj())) {
                writeData2.setVcodeMD5(sVar.getVcode_md5());
                writeData2.setVcodeUrl(sVar.getVcode_pic_url());
                writeData2.setVcodeExtra(sVar.yk());
                if (com.baidu.tbadk.p.a.hc(sVar.yj())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.byF.getPageContext().getPageActivity(), 25017, writeData2, false, sVar.yj())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.byF.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.byF.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.eXo != null) {
                a.this.eXo.callback(z, postWriteCallBackData, sVar, writeData2, antiData);
            }
        }
    };
    private BaseActivity byF;
    private NewWriteModel.d eXo;
    private GetEmotionPidModel feV;
    private c ffr;
    private EmotionImageData ffs;
    private PbModel fft;
    private f ffu;

    public a(BaseActivity baseActivity) {
        this.byF = baseActivity;
        this.aDH = new NewWriteModel(baseActivity);
        this.aDG = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.ffs = emotionImageData;
            this.fft = pbModel;
            this.ffu = fVar;
            if (!j.hh()) {
                this.byF.showToast(d.j.neterror);
            } else if (a(this.byF.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.feV == null) {
                            this.feV = new GetEmotionPidModel();
                        }
                        if (this.ffr != null) {
                            this.ffr.DB();
                        }
                        this.feV.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.eXo != null) {
                                    a.this.eXo.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.ffr != null) {
                    this.ffr.DB();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.aDH.getWriteData() == null && pbModel != null) {
                this.aDH.setWriteData(pbModel.fS(null));
            }
            if (this.aDH.getWriteData() != null) {
                if (fVar.aRq().sI()) {
                    this.aDH.getWriteData().setCanNoForum(true);
                    if (fVar.aRo() != null) {
                        this.aDH.getWriteData().setVForumId(fVar.aRo().getId());
                        this.aDH.getWriteData().setVForumName(fVar.aRo().getName());
                    }
                } else {
                    this.aDH.getWriteData().setCanNoForum(false);
                    this.aDH.getWriteData().setVForumId("");
                    this.aDH.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aDH.getWriteData();
                if (this.aDG == null || !this.aDG.YJ()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + com.baidu.adp.lib.util.s.aS(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aDH.getWriteData().setContent(str);
                } else {
                    this.aDH.getWriteData().setContent(qd(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aDH.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aDH.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aDH.b(this.aDV);
                if (!this.aDH.startPostWrite()) {
                }
            }
        }
    }

    private String qd(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.ffr = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.eXo = dVar;
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
                    WriteData writeData = this.aDH != null ? this.aDH.getWriteData() : null;
                    resetData();
                    if (this.eXo != null) {
                        this.eXo.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.ffs, this.fft, this.ffu);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.feV != null) {
            this.feV.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.ffs = null;
        this.ffu = null;
        this.fft = null;
        if (this.aDH != null) {
            this.aDH.setWriteData(null);
        }
    }
}
