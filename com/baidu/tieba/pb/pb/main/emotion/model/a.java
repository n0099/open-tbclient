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
/* loaded from: classes6.dex */
public class a {
    private LocationModel aVD;
    private NewWriteModel aVE;
    private final NewWriteModel.d aVS = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.aVE.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && vVar != null && !TextUtils.isEmpty(vVar.FF())) {
                writeData2.setVcodeMD5(vVar.getVcode_md5());
                writeData2.setVcodeUrl(vVar.getVcode_pic_url());
                writeData2.setVcodeExtra(vVar.FG());
                if (com.baidu.tbadk.q.a.iy(vVar.FF())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.bwX.getPageContext().getPageActivity(), 25017, writeData2, false, vVar.FF())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.bwX.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.bwX.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.fOZ != null) {
                a.this.fOZ.callback(z, postWriteCallBackData, vVar, writeData2, antiData);
            }
        }
    };
    private BaseActivity bwX;
    private NewWriteModel.d fOZ;
    private GetEmotionPidModel fWQ;
    private c fXm;
    private EmotionImageData fXn;
    private PbModel fXo;
    private d fXp;

    public a(BaseActivity baseActivity) {
        this.bwX = baseActivity;
        this.aVE = new NewWriteModel(baseActivity);
        this.aVD = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.fXn = emotionImageData;
            this.fXo = pbModel;
            this.fXp = dVar;
            if (!j.kX()) {
                this.bwX.showToast(e.j.neterror);
            } else if (a(this.bwX.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.fWQ == null) {
                            this.fWQ = new GetEmotionPidModel();
                        }
                        if (this.fXm != null) {
                            this.fXm.Lf();
                        }
                        this.fWQ.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.fOZ != null) {
                                    a.this.fOZ.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.fXm != null) {
                    this.fXm.Lf();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.aVE.getWriteData() == null && pbModel != null) {
                this.aVE.setWriteData(pbModel.hr(null));
            }
            if (this.aVE.getWriteData() != null) {
                if (dVar.beV().zG()) {
                    this.aVE.getWriteData().setCanNoForum(true);
                    if (dVar.beT() != null) {
                        this.aVE.getWriteData().setVForumId(dVar.beT().getId());
                        this.aVE.getWriteData().setVForumName(dVar.beT().getName());
                    }
                } else {
                    this.aVE.getWriteData().setCanNoForum(false);
                    this.aVE.getWriteData().setVForumId("");
                    this.aVE.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aVE.getWriteData();
                if (this.aVD == null || !this.aVD.alj()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(",");
                sb.append(emotionImageData.getWidth()).append(",");
                sb.append(emotionImageData.getHeight()).append(",");
                String str = "#(" + sb.toString() + s.bC(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aVE.getWriteData().setContent(str);
                } else {
                    this.aVE.getWriteData().setContent(sH(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aVE.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aVE.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aVE.b(this.aVS);
                if (!this.aVE.startPostWrite()) {
                }
            }
        }
    }

    private String sH(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.fXm = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.fOZ = dVar;
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
                    WriteData writeData = this.aVE != null ? this.aVE.getWriteData() : null;
                    resetData();
                    if (this.fOZ != null) {
                        this.fOZ.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.fXn, this.fXo, this.fXp);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.fWQ != null) {
            this.fWQ.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fXn = null;
        this.fXp = null;
        this.fXo = null;
        if (this.aVE != null) {
            this.aVE.setWriteData(null);
        }
    }
}
