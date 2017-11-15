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
import com.baidu.tbadk.coreExtra.data.r;
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
    private LocationModel aDe;
    private NewWriteModel aDf;
    private final NewWriteModel.d aDw = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.d.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? d.this.aDf.getWriteData() : writeData;
            if (z) {
                d.this.resetData();
            } else if (writeData2 != null && rVar != null && !TextUtils.isEmpty(rVar.yh())) {
                writeData2.setVcodeMD5(rVar.getVcode_md5());
                writeData2.setVcodeUrl(rVar.getVcode_pic_url());
                writeData2.setVcodeExtra(rVar.yi());
                if (com.baidu.tbadk.q.a.hb(rVar.yh())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(d.this.brT.getPageContext().getPageActivity(), 25017, writeData2, false, rVar.yh())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(d.this.brT.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(d.this.brT.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (d.this.eOe != null) {
                d.this.eOe.callback(z, postWriteCallBackData, rVar, writeData2, antiData);
            }
        }
    };
    private BaseActivity brT;
    private com.baidu.tbadk.editortools.pb.c dXD;
    private NewWriteModel.d eOe;
    private GetEmotionPidModel eVv;
    private EmotionImageData eWW;
    private PbModel eWX;
    private f eWY;

    public d(BaseActivity baseActivity) {
        this.brT = baseActivity;
        this.aDf = new NewWriteModel(baseActivity);
        this.aDe = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.eWW = emotionImageData;
            this.eWX = pbModel;
            this.eWY = fVar;
            if (!j.hh()) {
                this.brT.showToast(d.j.neterror);
            } else if (a(this.brT.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.eVv == null) {
                            this.eVv = new GetEmotionPidModel();
                        }
                        if (this.dXD != null) {
                            this.dXD.Dr();
                        }
                        this.eVv.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.d.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    d.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (d.this.eOe != null) {
                                    d.this.eOe.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.dXD != null) {
                    this.dXD.Dr();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.aDf.getWriteData() == null && pbModel != null) {
                this.aDf.setWriteData(pbModel.fQ(null));
            }
            if (this.aDf.getWriteData() != null) {
                if (fVar.aPW().sH()) {
                    this.aDf.getWriteData().setCanNoForum(true);
                    if (fVar.aPU() != null) {
                        this.aDf.getWriteData().setVForumId(fVar.aPU().getId());
                        this.aDf.getWriteData().setVForumName(fVar.aPU().getName());
                    }
                } else {
                    this.aDf.getWriteData().setCanNoForum(false);
                    this.aDf.getWriteData().setVForumId("");
                    this.aDf.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aDf.getWriteData();
                if (this.aDe == null || !this.aDe.WV()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.aS(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aDf.getWriteData().setContent(str);
                } else {
                    this.aDf.getWriteData().setContent(pQ(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aDf.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aDf.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aDf.b(this.aDw);
                if (!this.aDf.startPostWrite()) {
                }
            }
        }
    }

    private String pQ(String str) {
        return "@" + str + " ";
    }

    public void b(com.baidu.tbadk.editortools.pb.c cVar) {
        this.dXD = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.eOe = dVar;
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
                    WriteData writeData = this.aDf != null ? this.aDf.getWriteData() : null;
                    resetData();
                    if (this.eOe != null) {
                        this.eOe.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.eWW, this.eWX, this.eWY);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.eVv != null) {
            this.eVv.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.eWW = null;
        this.eWY = null;
        this.eWX = null;
        if (this.aDf != null) {
            this.aDf.setWriteData(null);
        }
    }
}
