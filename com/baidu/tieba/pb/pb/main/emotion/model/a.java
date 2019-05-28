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
    private BaseActivity cVp;
    private final NewWriteModel.d csD = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.csp.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.alz())) {
                writeData2.setVcodeMD5(xVar.getVcode_md5());
                writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                writeData2.setVcodeExtra(xVar.alA());
                if (com.baidu.tbadk.v.a.rd(xVar.alz())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.cVp.getPageContext().getPageActivity(), 25017, writeData2, false, xVar.alz())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.cVp.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.cVp.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.hIE != null) {
                a.this.hIE.callback(z, postWriteCallBackData, xVar, writeData2, antiData);
            }
        }
    };
    private LocationModel cso;
    private NewWriteModel csp;
    private NewWriteModel.d hIE;
    private GetEmotionPidModel hQA;
    private c hQW;
    private EmotionImageData hQX;
    private PbModel hQY;
    private d hQZ;

    public a(BaseActivity baseActivity) {
        this.cVp = baseActivity;
        this.csp = new NewWriteModel(baseActivity);
        this.cso = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.hQX = emotionImageData;
            this.hQY = pbModel;
            this.hQZ = dVar;
            if (!j.jS()) {
                this.cVp.showToast(R.string.neterror);
            } else if (a(this.cVp.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.hQA == null) {
                            this.hQA = new GetEmotionPidModel();
                        }
                        if (this.hQW != null) {
                            this.hQW.arr();
                        }
                        this.hQA.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.hIE != null) {
                                    a.this.hIE.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.hQW != null) {
                    this.hQW.arr();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.csp.getWriteData() == null && pbModel != null) {
                this.csp.setWriteData(pbModel.pW(null));
            }
            if (this.csp.getWriteData() != null) {
                if (dVar.bPL().aeN()) {
                    this.csp.getWriteData().setCanNoForum(true);
                    if (dVar.getForum() != null) {
                        this.csp.getWriteData().setVForumId(dVar.getForum().getId());
                        this.csp.getWriteData().setVForumName(dVar.getForum().getName());
                    }
                } else {
                    this.csp.getWriteData().setCanNoForum(false);
                    this.csp.getWriteData().setVForumId("");
                    this.csp.getWriteData().setVForumName("");
                }
                WriteData writeData = this.csp.getWriteData();
                if (this.cso == null || !this.cso.aTH()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.bm(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.csp.getWriteData().setContent(str);
                } else {
                    this.csp.getWriteData().setContent(Bw(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.csp.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.csp.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.csp.b(this.csD);
                if (!this.csp.startPostWrite()) {
                }
            }
        }
    }

    private String Bw(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.hQW = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.hIE = dVar;
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
                    WriteData writeData = this.csp != null ? this.csp.getWriteData() : null;
                    resetData();
                    if (this.hIE != null) {
                        this.hIE.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.hQX, this.hQY, this.hQZ);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.hQA != null) {
            this.hQA.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.hQX = null;
        this.hQZ = null;
        this.hQY = null;
        if (this.csp != null) {
            this.csp.setWriteData(null);
        }
    }
}
