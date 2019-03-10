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
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes4.dex */
public class a {
    private BaseActivity cNd;
    private LocationModel ckd;
    private NewWriteModel cke;
    private final NewWriteModel.d cks = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.cke.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.agD())) {
                writeData2.setVcodeMD5(xVar.getVcode_md5());
                writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                writeData2.setVcodeExtra(xVar.agE());
                if (com.baidu.tbadk.u.a.pV(xVar.agD())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.cNd.getPageContext().getPageActivity(), 25017, writeData2, false, xVar.agD())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.cNd.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.cNd.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.hrq != null) {
                a.this.hrq.callback(z, postWriteCallBackData, xVar, writeData2, antiData);
            }
        }
    };
    private NewWriteModel.d hrq;
    private c hzC;
    private EmotionImageData hzD;
    private PbModel hzE;
    private d hzF;
    private GetEmotionPidModel hzg;

    public a(BaseActivity baseActivity) {
        this.cNd = baseActivity;
        this.cke = new NewWriteModel(baseActivity);
        this.ckd = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.hzD = emotionImageData;
            this.hzE = pbModel;
            this.hzF = dVar;
            if (!j.kY()) {
                this.cNd.showToast(d.j.neterror);
            } else if (a(this.cNd.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.hzg == null) {
                            this.hzg = new GetEmotionPidModel();
                        }
                        if (this.hzC != null) {
                            this.hzC.ams();
                        }
                        this.hzg.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.hrq != null) {
                                    a.this.hrq.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.hzC != null) {
                    this.hzC.ams();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, com.baidu.tieba.pb.data.d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.cke.getWriteData() == null && pbModel != null) {
                this.cke.setWriteData(pbModel.oN(null));
            }
            if (this.cke.getWriteData() != null) {
                if (dVar.bIa().aaj()) {
                    this.cke.getWriteData().setCanNoForum(true);
                    if (dVar.getForum() != null) {
                        this.cke.getWriteData().setVForumId(dVar.getForum().getId());
                        this.cke.getWriteData().setVForumName(dVar.getForum().getName());
                    }
                } else {
                    this.cke.getWriteData().setCanNoForum(false);
                    this.cke.getWriteData().setVForumId("");
                    this.cke.getWriteData().setVForumName("");
                }
                WriteData writeData = this.cke.getWriteData();
                if (this.ckd == null || !this.ckd.aNG()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.bC(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.cke.getWriteData().setContent(str);
                } else {
                    this.cke.getWriteData().setContent(Aj(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.cke.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.cke.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.cke.b(this.cks);
                if (!this.cke.startPostWrite()) {
                }
            }
        }
    }

    private String Aj(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.hzC = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.hrq = dVar;
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
                    WriteData writeData = this.cke != null ? this.cke.getWriteData() : null;
                    resetData();
                    if (this.hrq != null) {
                        this.hrq.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.hzD, this.hzE, this.hzF);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.hzg != null) {
            this.hzg.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.hzD = null;
        this.hzF = null;
        this.hzE = null;
        if (this.cke != null) {
            this.cke.setWriteData(null);
        }
    }
}
