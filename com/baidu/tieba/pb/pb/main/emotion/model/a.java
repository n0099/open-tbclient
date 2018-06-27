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
/* loaded from: classes2.dex */
public class a {
    private LocationModel aNO;
    private NewWriteModel aNP;
    private final NewWriteModel.d aOd = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.aNP.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.CB())) {
                writeData2.setVcodeMD5(tVar.getVcode_md5());
                writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                writeData2.setVcodeExtra(tVar.CC());
                if (com.baidu.tbadk.p.a.hQ(tVar.CB())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.bmt.getPageContext().getPageActivity(), 25017, writeData2, false, tVar.CB())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.bmt.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.bmt.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.fzK != null) {
                a.this.fzK.callback(z, postWriteCallBackData, tVar, writeData2, antiData);
            }
        }
    };
    private BaseActivity bmt;
    private GetEmotionPidModel fHC;
    private c fHY;
    private EmotionImageData fHZ;
    private PbModel fIa;
    private d fIb;
    private NewWriteModel.d fzK;

    public a(BaseActivity baseActivity) {
        this.bmt = baseActivity;
        this.aNP = new NewWriteModel(baseActivity);
        this.aNO = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.fHZ = emotionImageData;
            this.fIa = pbModel;
            this.fIb = dVar;
            if (!j.jD()) {
                this.bmt.showToast(d.k.neterror);
            } else if (a(this.bmt.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.fHC == null) {
                            this.fHC = new GetEmotionPidModel();
                        }
                        if (this.fHY != null) {
                            this.fHY.HW();
                        }
                        this.fHC.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.fzK != null) {
                                    a.this.fzK.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.fHY != null) {
                    this.fHY.HW();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, com.baidu.tieba.pb.data.d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.aNP.getWriteData() == null && pbModel != null) {
                this.aNP.setWriteData(pbModel.gL(null));
            }
            if (this.aNP.getWriteData() != null) {
                if (dVar.baV().wE()) {
                    this.aNP.getWriteData().setCanNoForum(true);
                    if (dVar.baT() != null) {
                        this.aNP.getWriteData().setVForumId(dVar.baT().getId());
                        this.aNP.getWriteData().setVForumName(dVar.baT().getName());
                    }
                } else {
                    this.aNP.getWriteData().setCanNoForum(false);
                    this.aNP.getWriteData().setVForumId("");
                    this.aNP.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aNP.getWriteData();
                if (this.aNO == null || !this.aNO.afw()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(",");
                sb.append(emotionImageData.getWidth()).append(",");
                sb.append(emotionImageData.getHeight()).append(",");
                String str = "#(" + sb.toString() + s.bl(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aNP.getWriteData().setContent(str);
                } else {
                    this.aNP.getWriteData().setContent(rC(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aNP.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aNP.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aNP.b(this.aOd);
                if (!this.aNP.startPostWrite()) {
                }
            }
        }
    }

    private String rC(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.fHY = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.fzK = dVar;
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
                    WriteData writeData = this.aNP != null ? this.aNP.getWriteData() : null;
                    resetData();
                    if (this.fzK != null) {
                        this.fzK.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.fHZ, this.fIa, this.fIb);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.fHC != null) {
            this.fHC.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fHZ = null;
        this.fIb = null;
        this.fIa = null;
        if (this.aNP != null) {
            this.aNP.setWriteData(null);
        }
    }
}
