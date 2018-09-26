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
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.editortools.pb.c;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.e;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class a {
    private LocationModel aRc;
    private NewWriteModel aRd;
    private final NewWriteModel.d aRr = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.aRd.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && vVar != null && !TextUtils.isEmpty(vVar.DE())) {
                writeData2.setVcodeMD5(vVar.getVcode_md5());
                writeData2.setVcodeUrl(vVar.getVcode_pic_url());
                writeData2.setVcodeExtra(vVar.DF());
                if (com.baidu.tbadk.q.a.il(vVar.DE())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.bsQ.getPageContext().getPageActivity(), 25017, writeData2, false, vVar.DE())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.bsQ.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.bsQ.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.fHy != null) {
                a.this.fHy.callback(z, postWriteCallBackData, vVar, writeData2, antiData);
            }
        }
    };
    private BaseActivity bsQ;
    private NewWriteModel.d fHy;
    private c fPM;
    private EmotionImageData fPN;
    private PbModel fPO;
    private d fPP;
    private GetEmotionPidModel fPq;

    public a(BaseActivity baseActivity) {
        this.bsQ = baseActivity;
        this.aRd = new NewWriteModel(baseActivity);
        this.aRc = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.fPN = emotionImageData;
            this.fPO = pbModel;
            this.fPP = dVar;
            if (!j.kK()) {
                this.bsQ.showToast(e.j.neterror);
            } else if (a(this.bsQ.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.fPq == null) {
                            this.fPq = new GetEmotionPidModel();
                        }
                        if (this.fPM != null) {
                            this.fPM.Jh();
                        }
                        this.fPq.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.fHy != null) {
                                    a.this.fHy.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.fPM != null) {
                    this.fPM.Jh();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.aRd.getWriteData() == null && pbModel != null) {
                this.aRd.setWriteData(pbModel.hd(null));
            }
            if (this.aRd.getWriteData() != null) {
                if (dVar.bbJ().xx()) {
                    this.aRd.getWriteData().setCanNoForum(true);
                    if (dVar.bbH() != null) {
                        this.aRd.getWriteData().setVForumId(dVar.bbH().getId());
                        this.aRd.getWriteData().setVForumName(dVar.bbH().getName());
                    }
                } else {
                    this.aRd.getWriteData().setCanNoForum(false);
                    this.aRd.getWriteData().setVForumId("");
                    this.aRd.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aRd.getWriteData();
                if (this.aRc == null || !this.aRc.ahE()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(",");
                sb.append(emotionImageData.getWidth()).append(",");
                sb.append(emotionImageData.getHeight()).append(",");
                String str = "#(" + sb.toString() + s.bD(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aRd.getWriteData().setContent(str);
                } else {
                    this.aRd.getWriteData().setContent(sg(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aRd.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aRd.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aRd.b(this.aRr);
                if (!this.aRd.startPostWrite()) {
                }
            }
        }
    }

    private String sg(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.fPM = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.fHy = dVar;
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
                    WriteData writeData = this.aRd != null ? this.aRd.getWriteData() : null;
                    resetData();
                    if (this.fHy != null) {
                        this.fHy.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.fPN, this.fPO, this.fPP);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.fPq != null) {
            this.fPq.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fPN = null;
        this.fPP = null;
        this.fPO = null;
        if (this.aRd != null) {
            this.aRd.setWriteData(null);
        }
    }
}
