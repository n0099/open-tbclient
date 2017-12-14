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
    private LocationModel aDD;
    private NewWriteModel aDE;
    private final NewWriteModel.d aDS = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.aDE.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && sVar != null && !TextUtils.isEmpty(sVar.yj())) {
                writeData2.setVcodeMD5(sVar.getVcode_md5());
                writeData2.setVcodeUrl(sVar.getVcode_pic_url());
                writeData2.setVcodeExtra(sVar.yk());
                if (com.baidu.tbadk.p.a.hc(sVar.yj())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.byB.getPageContext().getPageActivity(), 25017, writeData2, false, sVar.yj())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.byB.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.byB.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.eXj != null) {
                a.this.eXj.callback(z, postWriteCallBackData, sVar, writeData2, antiData);
            }
        }
    };
    private BaseActivity byB;
    private NewWriteModel.d eXj;
    private GetEmotionPidModel feQ;
    private c ffm;
    private EmotionImageData ffn;
    private PbModel ffo;
    private f ffp;

    public a(BaseActivity baseActivity) {
        this.byB = baseActivity;
        this.aDE = new NewWriteModel(baseActivity);
        this.aDD = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.ffn = emotionImageData;
            this.ffo = pbModel;
            this.ffp = fVar;
            if (!j.hh()) {
                this.byB.showToast(d.j.neterror);
            } else if (a(this.byB.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.feQ == null) {
                            this.feQ = new GetEmotionPidModel();
                        }
                        if (this.ffm != null) {
                            this.ffm.DB();
                        }
                        this.feQ.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.eXj != null) {
                                    a.this.eXj.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.ffm != null) {
                    this.ffm.DB();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.aDE.getWriteData() == null && pbModel != null) {
                this.aDE.setWriteData(pbModel.fS(null));
            }
            if (this.aDE.getWriteData() != null) {
                if (fVar.aRq().sI()) {
                    this.aDE.getWriteData().setCanNoForum(true);
                    if (fVar.aRo() != null) {
                        this.aDE.getWriteData().setVForumId(fVar.aRo().getId());
                        this.aDE.getWriteData().setVForumName(fVar.aRo().getName());
                    }
                } else {
                    this.aDE.getWriteData().setCanNoForum(false);
                    this.aDE.getWriteData().setVForumId("");
                    this.aDE.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aDE.getWriteData();
                if (this.aDD == null || !this.aDD.YJ()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + com.baidu.adp.lib.util.s.aS(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aDE.getWriteData().setContent(str);
                } else {
                    this.aDE.getWriteData().setContent(qd(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aDE.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aDE.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aDE.b(this.aDS);
                if (!this.aDE.startPostWrite()) {
                }
            }
        }
    }

    private String qd(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.ffm = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.eXj = dVar;
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
                    WriteData writeData = this.aDE != null ? this.aDE.getWriteData() : null;
                    resetData();
                    if (this.eXj != null) {
                        this.eXj.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.ffn, this.ffo, this.ffp);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.feQ != null) {
            this.feQ.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.ffn = null;
        this.ffp = null;
        this.ffo = null;
        if (this.aDE != null) {
            this.aDE.setWriteData(null);
        }
    }
}
