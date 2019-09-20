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
import com.baidu.tbadk.coreExtra.data.y;
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
    private BaseActivity cXM;
    private LocationModel cuG;
    private NewWriteModel cuH;
    private final NewWriteModel.d cuV = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.cuH.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && yVar != null && !TextUtils.isEmpty(yVar.amS())) {
                writeData2.setVcodeMD5(yVar.getVcode_md5());
                writeData2.setVcodeUrl(yVar.getVcode_pic_url());
                writeData2.setVcodeExtra(yVar.amT());
                if (com.baidu.tbadk.v.a.rF(yVar.amS())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.cXM.getPageContext().getPageActivity(), 25017, writeData2, false, yVar.amS())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.cXM.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.cXM.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.hRK != null) {
                a.this.hRK.callback(z, postWriteCallBackData, yVar, writeData2, antiData);
            }
        }
    };
    private NewWriteModel.d hRK;
    private GetEmotionPidModel hZH;
    private c iad;
    private EmotionImageData iae;
    private PbModel iaf;
    private d iag;

    public a(BaseActivity baseActivity) {
        this.cXM = baseActivity;
        this.cuH = new NewWriteModel(baseActivity);
        this.cuG = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.iae = emotionImageData;
            this.iaf = pbModel;
            this.iag = dVar;
            if (!j.kc()) {
                this.cXM.showToast(R.string.neterror);
            } else if (a(this.cXM.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.hZH == null) {
                            this.hZH = new GetEmotionPidModel();
                        }
                        if (this.iad != null) {
                            this.iad.asL();
                        }
                        this.hZH.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.hRK != null) {
                                    a.this.hRK.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.iad != null) {
                    this.iad.asL();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.cuH.getWriteData() == null && pbModel != null) {
                this.cuH.setWriteData(pbModel.qx(null));
            }
            if (this.cuH.getWriteData() != null) {
                if (dVar.bTy().afU()) {
                    this.cuH.getWriteData().setCanNoForum(true);
                    if (dVar.getForum() != null) {
                        this.cuH.getWriteData().setVForumId(dVar.getForum().getId());
                        this.cuH.getWriteData().setVForumName(dVar.getForum().getName());
                    }
                } else {
                    this.cuH.getWriteData().setCanNoForum(false);
                    this.cuH.getWriteData().setVForumId("");
                    this.cuH.getWriteData().setVForumName("");
                }
                WriteData writeData = this.cuH.getWriteData();
                if (this.cuG == null || !this.cuG.aWg()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.bn(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.cuH.getWriteData().setContent(str);
                } else {
                    this.cuH.getWriteData().setContent(CK(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.cuH.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.cuH.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.cuH.b(this.cuV);
                if (!this.cuH.startPostWrite()) {
                }
            }
        }
    }

    private String CK(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.iad = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.hRK = dVar;
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
                    WriteData writeData = this.cuH != null ? this.cuH.getWriteData() : null;
                    resetData();
                    if (this.hRK != null) {
                        this.hRK.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.iae, this.iaf, this.iag);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.hZH != null) {
            this.hZH.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.iae = null;
        this.iag = null;
        this.iaf = null;
        if (this.cuH != null) {
            this.cuH.setWriteData(null);
        }
    }
}
