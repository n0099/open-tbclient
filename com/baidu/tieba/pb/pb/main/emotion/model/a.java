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
    private final NewWriteModel.d aDN = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.aDz.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && rVar != null && !TextUtils.isEmpty(rVar.yi())) {
                writeData2.setVcodeMD5(rVar.getVcode_md5());
                writeData2.setVcodeUrl(rVar.getVcode_pic_url());
                writeData2.setVcodeExtra(rVar.yj());
                if (com.baidu.tbadk.p.a.he(rVar.yi())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.byz.getPageContext().getPageActivity(), 25017, writeData2, false, rVar.yi())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.byz.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.byz.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.eWg != null) {
                a.this.eWg.callback(z, postWriteCallBackData, rVar, writeData2, antiData);
            }
        }
    };
    private LocationModel aDy;
    private NewWriteModel aDz;
    private BaseActivity byz;
    private NewWriteModel.d eWg;
    private GetEmotionPidModel fdP;
    private c fel;
    private EmotionImageData fem;
    private PbModel fen;
    private f feo;

    public a(BaseActivity baseActivity) {
        this.byz = baseActivity;
        this.aDz = new NewWriteModel(baseActivity);
        this.aDy = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.fem = emotionImageData;
            this.fen = pbModel;
            this.feo = fVar;
            if (!j.hh()) {
                this.byz.showToast(d.j.neterror);
            } else if (a(this.byz.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.fdP == null) {
                            this.fdP = new GetEmotionPidModel();
                        }
                        if (this.fel != null) {
                            this.fel.DA();
                        }
                        this.fdP.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.eWg != null) {
                                    a.this.eWg.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.fel != null) {
                    this.fel.DA();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.aDz.getWriteData() == null && pbModel != null) {
                this.aDz.setWriteData(pbModel.fT(null));
            }
            if (this.aDz.getWriteData() != null) {
                if (fVar.aRh().sK()) {
                    this.aDz.getWriteData().setCanNoForum(true);
                    if (fVar.aRf() != null) {
                        this.aDz.getWriteData().setVForumId(fVar.aRf().getId());
                        this.aDz.getWriteData().setVForumName(fVar.aRf().getName());
                    }
                } else {
                    this.aDz.getWriteData().setCanNoForum(false);
                    this.aDz.getWriteData().setVForumId("");
                    this.aDz.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aDz.getWriteData();
                if (this.aDy == null || !this.aDy.YI()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.aS(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aDz.getWriteData().setContent(str);
                } else {
                    this.aDz.getWriteData().setContent(qd(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aDz.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aDz.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aDz.b(this.aDN);
                if (!this.aDz.startPostWrite()) {
                }
            }
        }
    }

    private String qd(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.fel = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.eWg = dVar;
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
                    WriteData writeData = this.aDz != null ? this.aDz.getWriteData() : null;
                    resetData();
                    if (this.eWg != null) {
                        this.eWg.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.fem, this.fen, this.feo);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.fdP != null) {
            this.fdP.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fem = null;
        this.feo = null;
        this.fen = null;
        if (this.aDz != null) {
            this.aDz.setWriteData(null);
        }
    }
}
