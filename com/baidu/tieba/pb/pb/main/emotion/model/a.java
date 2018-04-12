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
    private final NewWriteModel.d aEK = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.aEw.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.yK())) {
                writeData2.setVcodeMD5(tVar.getVcode_md5());
                writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                writeData2.setVcodeExtra(tVar.yL());
                if (com.baidu.tbadk.p.a.hq(tVar.yK())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.bcJ.getPageContext().getPageActivity(), 25017, writeData2, false, tVar.yK())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.bcJ.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.bcJ.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.fjk != null) {
                a.this.fjk.callback(z, postWriteCallBackData, tVar, writeData2, antiData);
            }
        }
    };
    private LocationModel aEv;
    private NewWriteModel aEw;
    private BaseActivity bcJ;
    private NewWriteModel.d fjk;
    private c frC;
    private EmotionImageData frD;
    private PbModel frE;
    private d frF;
    private GetEmotionPidModel frf;

    public a(BaseActivity baseActivity) {
        this.bcJ = baseActivity;
        this.aEw = new NewWriteModel(baseActivity);
        this.aEv = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.frD = emotionImageData;
            this.frE = pbModel;
            this.frF = dVar;
            if (!j.gP()) {
                this.bcJ.showToast(d.k.neterror);
            } else if (a(this.bcJ.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.frf == null) {
                            this.frf = new GetEmotionPidModel();
                        }
                        if (this.frC != null) {
                            this.frC.Ed();
                        }
                        this.frf.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.fjk != null) {
                                    a.this.fjk.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.frC != null) {
                    this.frC.Ed();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, com.baidu.tieba.pb.data.d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.aEw.getWriteData() == null && pbModel != null) {
                this.aEw.setWriteData(pbModel.gi(null));
            }
            if (this.aEw.getWriteData() != null) {
                if (dVar.aVs().sY()) {
                    this.aEw.getWriteData().setCanNoForum(true);
                    if (dVar.aVq() != null) {
                        this.aEw.getWriteData().setVForumId(dVar.aVq().getId());
                        this.aEw.getWriteData().setVForumName(dVar.aVq().getName());
                    }
                } else {
                    this.aEw.getWriteData().setCanNoForum(false);
                    this.aEw.getWriteData().setVForumId("");
                    this.aEw.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aEw.getWriteData();
                if (this.aEv == null || !this.aEv.abo()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.aX(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aEw.getWriteData().setContent(str);
                } else {
                    this.aEw.getWriteData().setContent(qM(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aEw.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aEw.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aEw.b(this.aEK);
                if (!this.aEw.startPostWrite()) {
                }
            }
        }
    }

    private String qM(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.frC = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.fjk = dVar;
    }

    private boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.k.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25017) {
                if (intent != null) {
                    WriteData writeData = this.aEw != null ? this.aEw.getWriteData() : null;
                    resetData();
                    if (this.fjk != null) {
                        this.fjk.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.frD, this.frE, this.frF);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.frf != null) {
            this.frf.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.frD = null;
        this.frF = null;
        this.frE = null;
        if (this.aEw != null) {
            this.aEw.setWriteData(null);
        }
    }
}
