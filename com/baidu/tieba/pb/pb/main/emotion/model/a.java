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
import com.baidu.tbadk.coreExtra.data.t;
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
    private LocationModel brS;
    private NewWriteModel brT;
    private final NewWriteModel.d bsh = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.brT.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.FB())) {
                writeData2.setVcodeMD5(tVar.getVcode_md5());
                writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                writeData2.setVcodeExtra(tVar.FC());
                if (com.baidu.tbadk.p.a.ho(tVar.FB())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.cmZ.getPageContext().getPageActivity(), 25017, writeData2, false, tVar.FB())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.cmZ.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.cmZ.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.fLX != null) {
                a.this.fLX.callback(z, postWriteCallBackData, tVar, writeData2, antiData);
            }
        }
    };
    private BaseActivity cmZ;
    private NewWriteModel.d fLX;
    private GetEmotionPidModel fTJ;
    private c fUf;
    private EmotionImageData fUg;
    private PbModel fUh;
    private f fUi;

    public a(BaseActivity baseActivity) {
        this.cmZ = baseActivity;
        this.brT = new NewWriteModel(baseActivity);
        this.brS = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.fUg = emotionImageData;
            this.fUh = pbModel;
            this.fUi = fVar;
            if (!j.oJ()) {
                this.cmZ.showToast(d.j.neterror);
            } else if (a(this.cmZ.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.fTJ == null) {
                            this.fTJ = new GetEmotionPidModel();
                        }
                        if (this.fUf != null) {
                            this.fUf.KT();
                        }
                        this.fTJ.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.fLX != null) {
                                    a.this.fLX.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.fUf != null) {
                    this.fUf.KT();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.brT.getWriteData() == null && pbModel != null) {
                this.brT.setWriteData(pbModel.gi(null));
            }
            if (this.brT.getWriteData() != null) {
                if (fVar.aYL().Ad()) {
                    this.brT.getWriteData().setCanNoForum(true);
                    if (fVar.aYJ() != null) {
                        this.brT.getWriteData().setVForumId(fVar.aYJ().getId());
                        this.brT.getWriteData().setVForumName(fVar.aYJ().getName());
                    }
                } else {
                    this.brT.getWriteData().setCanNoForum(false);
                    this.brT.getWriteData().setVForumId("");
                    this.brT.getWriteData().setVForumName("");
                }
                WriteData writeData = this.brT.getWriteData();
                if (this.brS == null || !this.brS.agi()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.ba(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.brT.getWriteData().setContent(str);
                } else {
                    this.brT.getWriteData().setContent(qy(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.brT.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.brT.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.brT.b(this.bsh);
                if (!this.brT.startPostWrite()) {
                }
            }
        }
    }

    private String qy(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.fUf = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.fLX = dVar;
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
                    WriteData writeData = this.brT != null ? this.brT.getWriteData() : null;
                    resetData();
                    if (this.fLX != null) {
                        this.fLX.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.fUg, this.fUh, this.fUi);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.fTJ != null) {
            this.fTJ.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fUg = null;
        this.fUi = null;
        this.fUh = null;
        if (this.brT != null) {
            this.brT.setWriteData(null);
        }
    }
}
