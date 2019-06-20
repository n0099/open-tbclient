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
    private BaseActivity cVq;
    private final NewWriteModel.d csE = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.csq.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.alz())) {
                writeData2.setVcodeMD5(xVar.getVcode_md5());
                writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                writeData2.setVcodeExtra(xVar.alA());
                if (com.baidu.tbadk.v.a.rc(xVar.alz())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.cVq.getPageContext().getPageActivity(), 25017, writeData2, false, xVar.alz())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.cVq.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.cVq.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.hIF != null) {
                a.this.hIF.callback(z, postWriteCallBackData, xVar, writeData2, antiData);
            }
        }
    };
    private LocationModel csp;
    private NewWriteModel csq;
    private NewWriteModel.d hIF;
    private GetEmotionPidModel hQB;
    private c hQX;
    private EmotionImageData hQY;
    private PbModel hQZ;
    private d hRa;

    public a(BaseActivity baseActivity) {
        this.cVq = baseActivity;
        this.csq = new NewWriteModel(baseActivity);
        this.csp = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.hQY = emotionImageData;
            this.hQZ = pbModel;
            this.hRa = dVar;
            if (!j.jS()) {
                this.cVq.showToast(R.string.neterror);
            } else if (a(this.cVq.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.hQB == null) {
                            this.hQB = new GetEmotionPidModel();
                        }
                        if (this.hQX != null) {
                            this.hQX.arr();
                        }
                        this.hQB.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.hIF != null) {
                                    a.this.hIF.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.hQX != null) {
                    this.hQX.arr();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.csq.getWriteData() == null && pbModel != null) {
                this.csq.setWriteData(pbModel.pV(null));
            }
            if (this.csq.getWriteData() != null) {
                if (dVar.bPM().aeN()) {
                    this.csq.getWriteData().setCanNoForum(true);
                    if (dVar.getForum() != null) {
                        this.csq.getWriteData().setVForumId(dVar.getForum().getId());
                        this.csq.getWriteData().setVForumName(dVar.getForum().getName());
                    }
                } else {
                    this.csq.getWriteData().setCanNoForum(false);
                    this.csq.getWriteData().setVForumId("");
                    this.csq.getWriteData().setVForumName("");
                }
                WriteData writeData = this.csq.getWriteData();
                if (this.csp == null || !this.csp.aTH()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.bm(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.csq.getWriteData().setContent(str);
                } else {
                    this.csq.getWriteData().setContent(By(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.csq.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.csq.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.csq.b(this.csE);
                if (!this.csq.startPostWrite()) {
                }
            }
        }
    }

    private String By(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.hQX = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.hIF = dVar;
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
                    WriteData writeData = this.csq != null ? this.csq.getWriteData() : null;
                    resetData();
                    if (this.hIF != null) {
                        this.hIF.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.hQY, this.hQZ, this.hRa);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.hQB != null) {
            this.hQB.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.hQY = null;
        this.hRa = null;
        this.hQZ = null;
        if (this.csq != null) {
            this.csq.setWriteData(null);
        }
    }
}
