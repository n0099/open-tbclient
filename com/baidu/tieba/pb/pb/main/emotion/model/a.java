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
    private final NewWriteModel.d aEL = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.aEx.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.yJ())) {
                writeData2.setVcodeMD5(tVar.getVcode_md5());
                writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                writeData2.setVcodeExtra(tVar.yK());
                if (com.baidu.tbadk.p.a.hr(tVar.yJ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.bcK.getPageContext().getPageActivity(), 25017, writeData2, false, tVar.yJ())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.bcK.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.bcK.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.fko != null) {
                a.this.fko.callback(z, postWriteCallBackData, tVar, writeData2, antiData);
            }
        }
    };
    private LocationModel aEw;
    private NewWriteModel aEx;
    private BaseActivity bcK;
    private NewWriteModel.d fko;
    private c fsG;
    private EmotionImageData fsH;
    private PbModel fsI;
    private d fsJ;
    private GetEmotionPidModel fsk;

    public a(BaseActivity baseActivity) {
        this.bcK = baseActivity;
        this.aEx = new NewWriteModel(baseActivity);
        this.aEw = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.fsH = emotionImageData;
            this.fsI = pbModel;
            this.fsJ = dVar;
            if (!j.gP()) {
                this.bcK.showToast(d.k.neterror);
            } else if (a(this.bcK.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.fsk == null) {
                            this.fsk = new GetEmotionPidModel();
                        }
                        if (this.fsG != null) {
                            this.fsG.Eb();
                        }
                        this.fsk.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.fko != null) {
                                    a.this.fko.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.fsG != null) {
                    this.fsG.Eb();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, com.baidu.tieba.pb.data.d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.aEx.getWriteData() == null && pbModel != null) {
                this.aEx.setWriteData(pbModel.gi(null));
            }
            if (this.aEx.getWriteData() != null) {
                if (dVar.aVs().sX()) {
                    this.aEx.getWriteData().setCanNoForum(true);
                    if (dVar.aVq() != null) {
                        this.aEx.getWriteData().setVForumId(dVar.aVq().getId());
                        this.aEx.getWriteData().setVForumName(dVar.aVq().getName());
                    }
                } else {
                    this.aEx.getWriteData().setCanNoForum(false);
                    this.aEx.getWriteData().setVForumId("");
                    this.aEx.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aEx.getWriteData();
                if (this.aEw == null || !this.aEw.abq()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.aX(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aEx.getWriteData().setContent(str);
                } else {
                    this.aEx.getWriteData().setContent(qP(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aEx.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aEx.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aEx.b(this.aEL);
                if (!this.aEx.startPostWrite()) {
                }
            }
        }
    }

    private String qP(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.fsG = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.fko = dVar;
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
                    WriteData writeData = this.aEx != null ? this.aEx.getWriteData() : null;
                    resetData();
                    if (this.fko != null) {
                        this.fko.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.fsH, this.fsI, this.fsJ);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.fsk != null) {
            this.fsk.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fsH = null;
        this.fsJ = null;
        this.fsI = null;
        if (this.aEx != null) {
            this.aEx.setWriteData(null);
        }
    }
}
