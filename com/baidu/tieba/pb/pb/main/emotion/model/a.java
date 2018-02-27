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
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.editortools.pb.c;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class a {
    private BaseActivity bSC;
    private LocationModel btT;
    private NewWriteModel btU;
    private final NewWriteModel.d buj = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.btU.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.FW())) {
                writeData2.setVcodeMD5(tVar.getVcode_md5());
                writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                writeData2.setVcodeExtra(tVar.FX());
                if (com.baidu.tbadk.p.a.hx(tVar.FW())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.bSC.getPageContext().getPageActivity(), 25017, writeData2, false, tVar.FW())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.bSC.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.bSC.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.fOV != null) {
                a.this.fOV.callback(z, postWriteCallBackData, tVar, writeData2, antiData);
            }
        }
    };
    private NewWriteModel.d fOV;
    private GetEmotionPidModel fWK;
    private c fXg;
    private EmotionImageData fXh;
    private PbModel fXi;
    private d fXj;

    public a(BaseActivity baseActivity) {
        this.bSC = baseActivity;
        this.btU = new NewWriteModel(baseActivity);
        this.btT = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.fXh = emotionImageData;
            this.fXi = pbModel;
            this.fXj = dVar;
            if (!j.oJ()) {
                this.bSC.showToast(d.j.neterror);
            } else if (a(this.bSC.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.fWK == null) {
                            this.fWK = new GetEmotionPidModel();
                        }
                        if (this.fXg != null) {
                            this.fXg.Lz();
                        }
                        this.fWK.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.fOV != null) {
                                    a.this.fOV.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.fXg != null) {
                    this.fXg.Lz();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, com.baidu.tieba.pb.data.d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.btU.getWriteData() == null && pbModel != null) {
                this.btU.setWriteData(pbModel.gr(null));
            }
            if (this.btU.getWriteData() != null) {
                if (dVar.bat().Aw()) {
                    this.btU.getWriteData().setCanNoForum(true);
                    if (dVar.bar() != null) {
                        this.btU.getWriteData().setVForumId(dVar.bar().getId());
                        this.btU.getWriteData().setVForumName(dVar.bar().getName());
                    }
                } else {
                    this.btU.getWriteData().setCanNoForum(false);
                    this.btU.getWriteData().setVForumId("");
                    this.btU.getWriteData().setVForumName("");
                }
                WriteData writeData = this.btU.getWriteData();
                if (this.btT == null || !this.btT.ahh()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.ba(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.btU.getWriteData().setContent(str);
                } else {
                    this.btU.getWriteData().setContent(qG(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.btU.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.btU.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.btU.b(this.buj);
                if (!this.btU.startPostWrite()) {
                }
            }
        }
    }

    private String qG(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.fXg = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.fOV = dVar;
    }

    private boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25017) {
                if (intent != null) {
                    WriteData writeData = this.btU != null ? this.btU.getWriteData() : null;
                    resetData();
                    if (this.fOV != null) {
                        this.fOV.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.fXh, this.fXi, this.fXj);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.fWK != null) {
            this.fWK.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fXh = null;
        this.fXj = null;
        this.fXi = null;
        if (this.btU != null) {
            this.btU.setWriteData(null);
        }
    }
}
