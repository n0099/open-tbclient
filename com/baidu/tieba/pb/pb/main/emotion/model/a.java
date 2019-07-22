package com.baidu.tieba.pb.pb.main.emotion.model;

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
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.editortools.pb.c;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes4.dex */
public class a {
    private BaseActivity cWM;
    private LocationModel ctC;
    private NewWriteModel ctD;
    private final NewWriteModel.d ctR = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.ctD.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.amE())) {
                writeData2.setVcodeMD5(xVar.getVcode_md5());
                writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                writeData2.setVcodeExtra(xVar.amF());
                if (com.baidu.tbadk.v.a.ru(xVar.amE())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.cWM.getPageContext().getPageActivity(), 25017, writeData2, false, xVar.amE())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.cWM.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.cWM.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.hOS != null) {
                a.this.hOS.callback(z, postWriteCallBackData, xVar, writeData2, antiData);
            }
        }
    };
    private NewWriteModel.d hOS;
    private GetEmotionPidModel hWO;
    private c hXk;
    private EmotionImageData hXl;
    private PbModel hXm;
    private d hXn;

    public a(BaseActivity baseActivity) {
        this.cWM = baseActivity;
        this.ctD = new NewWriteModel(baseActivity);
        this.ctC = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.hXl = emotionImageData;
            this.hXm = pbModel;
            this.hXn = dVar;
            if (!j.kc()) {
                this.cWM.showToast(R.string.neterror);
            } else if (a(this.cWM.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.hWO == null) {
                            this.hWO = new GetEmotionPidModel();
                        }
                        if (this.hXk != null) {
                            this.hXk.asx();
                        }
                        this.hWO.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.hOS != null) {
                                    a.this.hOS.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.hXk != null) {
                    this.hXk.asx();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.ctD.getWriteData() == null && pbModel != null) {
                this.ctD.setWriteData(pbModel.qm(null));
            }
            if (this.ctD.getWriteData() != null) {
                if (dVar.bSx().afP()) {
                    this.ctD.getWriteData().setCanNoForum(true);
                    if (dVar.getForum() != null) {
                        this.ctD.getWriteData().setVForumId(dVar.getForum().getId());
                        this.ctD.getWriteData().setVForumName(dVar.getForum().getName());
                    }
                } else {
                    this.ctD.getWriteData().setCanNoForum(false);
                    this.ctD.getWriteData().setVForumId("");
                    this.ctD.getWriteData().setVForumName("");
                }
                WriteData writeData = this.ctD.getWriteData();
                if (this.ctC == null || !this.ctC.aVA()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.bn(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.ctD.getWriteData().setContent(str);
                } else {
                    this.ctD.getWriteData().setContent(Ck(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.ctD.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.ctD.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.ctD.b(this.ctR);
                if (!this.ctD.startPostWrite()) {
                }
            }
        }
    }

    private String Ck(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.hXk = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.hOS = dVar;
    }

    private boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25017) {
                if (intent != null) {
                    WriteData writeData = this.ctD != null ? this.ctD.getWriteData() : null;
                    resetData();
                    if (this.hOS != null) {
                        this.hOS.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.hXl, this.hXm, this.hXn);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.hWO != null) {
            this.hWO.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.hXl = null;
        this.hXn = null;
        this.hXm = null;
        if (this.ctD != null) {
            this.ctD.setWriteData(null);
        }
    }
}
