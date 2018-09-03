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
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.pb.c;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.f;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class a {
    private LocationModel aNK;
    private NewWriteModel aNL;
    private final NewWriteModel.d aNZ = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, u uVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.aNL.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && uVar != null && !TextUtils.isEmpty(uVar.Cr())) {
                writeData2.setVcodeMD5(uVar.getVcode_md5());
                writeData2.setVcodeUrl(uVar.getVcode_pic_url());
                writeData2.setVcodeExtra(uVar.Cs());
                if (com.baidu.tbadk.q.a.hN(uVar.Cr())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.bnc.getPageContext().getPageActivity(), 25017, writeData2, false, uVar.Cr())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.bnc.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.bnc.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.fzP != null) {
                a.this.fzP.callback(z, postWriteCallBackData, uVar, writeData2, antiData);
            }
        }
    };
    private BaseActivity bnc;
    private GetEmotionPidModel fHK;
    private c fIg;
    private EmotionImageData fIh;
    private PbModel fIi;
    private d fIj;
    private NewWriteModel.d fzP;

    public a(BaseActivity baseActivity) {
        this.bnc = baseActivity;
        this.aNL = new NewWriteModel(baseActivity);
        this.aNK = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.fIh = emotionImageData;
            this.fIi = pbModel;
            this.fIj = dVar;
            if (!j.jE()) {
                this.bnc.showToast(f.j.neterror);
            } else if (a(this.bnc.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.fHK == null) {
                            this.fHK = new GetEmotionPidModel();
                        }
                        if (this.fIg != null) {
                            this.fIg.HR();
                        }
                        this.fHK.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.fzP != null) {
                                    a.this.fzP.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.fIg != null) {
                    this.fIg.HR();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.aNL.getWriteData() == null && pbModel != null) {
                this.aNL.setWriteData(pbModel.gH(null));
            }
            if (this.aNL.getWriteData() != null) {
                if (dVar.aZi().ws()) {
                    this.aNL.getWriteData().setCanNoForum(true);
                    if (dVar.aZg() != null) {
                        this.aNL.getWriteData().setVForumId(dVar.aZg().getId());
                        this.aNL.getWriteData().setVForumName(dVar.aZg().getName());
                    }
                } else {
                    this.aNL.getWriteData().setCanNoForum(false);
                    this.aNL.getWriteData().setVForumId("");
                    this.aNL.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aNL.getWriteData();
                if (this.aNK == null || !this.aNK.afS()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(",");
                sb.append(emotionImageData.getWidth()).append(",");
                sb.append(emotionImageData.getHeight()).append(",");
                String str = "#(" + sb.toString() + s.bm(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aNL.getWriteData().setContent(str);
                } else {
                    this.aNL.getWriteData().setContent(rz(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aNL.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aNL.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aNL.b(this.aNZ);
                if (!this.aNL.startPostWrite()) {
                }
            }
        }
    }

    private String rz(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.fIg = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.fzP = dVar;
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
                    WriteData writeData = this.aNL != null ? this.aNL.getWriteData() : null;
                    resetData();
                    if (this.fzP != null) {
                        this.fzP.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.fIh, this.fIi, this.fIj);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.fHK != null) {
            this.fHK.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fIh = null;
        this.fIj = null;
        this.fIi = null;
        if (this.aNL != null) {
            this.aNL.setWriteData(null);
        }
    }
}
