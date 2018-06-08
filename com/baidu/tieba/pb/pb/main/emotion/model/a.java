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
/* loaded from: classes2.dex */
public class a {
    private LocationModel aMS;
    private NewWriteModel aMT;
    private final NewWriteModel.d aNh = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.aMT.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.Cj())) {
                writeData2.setVcodeMD5(tVar.getVcode_md5());
                writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                writeData2.setVcodeExtra(tVar.Ck());
                if (com.baidu.tbadk.p.a.hM(tVar.Cj())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.bkU.getPageContext().getPageActivity(), 25017, writeData2, false, tVar.Cj())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.bkU.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.bkU.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.fvJ != null) {
                a.this.fvJ.callback(z, postWriteCallBackData, tVar, writeData2, antiData);
            }
        }
    };
    private BaseActivity bkU;
    private GetEmotionPidModel fDB;
    private c fDX;
    private EmotionImageData fDY;
    private PbModel fDZ;
    private d fEa;
    private NewWriteModel.d fvJ;

    public a(BaseActivity baseActivity) {
        this.bkU = baseActivity;
        this.aMT = new NewWriteModel(baseActivity);
        this.aMS = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.fDY = emotionImageData;
            this.fDZ = pbModel;
            this.fEa = dVar;
            if (!j.jD()) {
                this.bkU.showToast(d.k.neterror);
            } else if (a(this.bkU.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.fDB == null) {
                            this.fDB = new GetEmotionPidModel();
                        }
                        if (this.fDX != null) {
                            this.fDX.HE();
                        }
                        this.fDB.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.fvJ != null) {
                                    a.this.fvJ.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.fDX != null) {
                    this.fDX.HE();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, com.baidu.tieba.pb.data.d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.aMT.getWriteData() == null && pbModel != null) {
                this.aMT.setWriteData(pbModel.gH(null));
            }
            if (this.aMT.getWriteData() != null) {
                if (dVar.bao().wu()) {
                    this.aMT.getWriteData().setCanNoForum(true);
                    if (dVar.bam() != null) {
                        this.aMT.getWriteData().setVForumId(dVar.bam().getId());
                        this.aMT.getWriteData().setVForumName(dVar.bam().getName());
                    }
                } else {
                    this.aMT.getWriteData().setCanNoForum(false);
                    this.aMT.getWriteData().setVForumId("");
                    this.aMT.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aMT.getWriteData();
                if (this.aMS == null || !this.aMS.aeO()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(",");
                sb.append(emotionImageData.getWidth()).append(",");
                sb.append(emotionImageData.getHeight()).append(",");
                String str = "#(" + sb.toString() + s.bj(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aMT.getWriteData().setContent(str);
                } else {
                    this.aMT.getWriteData().setContent(rD(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aMT.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aMT.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aMT.b(this.aNh);
                if (!this.aMT.startPostWrite()) {
                }
            }
        }
    }

    private String rD(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.fDX = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.fvJ = dVar;
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
                    WriteData writeData = this.aMT != null ? this.aMT.getWriteData() : null;
                    resetData();
                    if (this.fvJ != null) {
                        this.fvJ.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.fDY, this.fDZ, this.fEa);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.fDB != null) {
            this.fDB.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fDY = null;
        this.fEa = null;
        this.fDZ = null;
        if (this.aMT != null) {
            this.aMT.setWriteData(null);
        }
    }
}
