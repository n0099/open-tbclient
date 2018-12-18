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
import com.baidu.tbadk.coreExtra.data.w;
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
    private LocationModel aZQ;
    private NewWriteModel aZR;
    private BaseActivity bBf;
    private final NewWriteModel.d baf = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.aZR.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && wVar != null && !TextUtils.isEmpty(wVar.GV())) {
                writeData2.setVcodeMD5(wVar.getVcode_md5());
                writeData2.setVcodeUrl(wVar.getVcode_pic_url());
                writeData2.setVcodeExtra(wVar.GW());
                if (com.baidu.tbadk.r.a.iS(wVar.GV())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.bBf.getPageContext().getPageActivity(), 25017, writeData2, false, wVar.GV())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.bBf.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.bBf.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.fXp != null) {
                a.this.fXp.callback(z, postWriteCallBackData, wVar, writeData2, antiData);
            }
        }
    };
    private NewWriteModel.d fXp;
    private c gfD;
    private EmotionImageData gfE;
    private PbModel gfF;
    private d gfG;
    private GetEmotionPidModel gfh;

    public a(BaseActivity baseActivity) {
        this.bBf = baseActivity;
        this.aZR = new NewWriteModel(baseActivity);
        this.aZQ = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.gfE = emotionImageData;
            this.gfF = pbModel;
            this.gfG = dVar;
            if (!j.kV()) {
                this.bBf.showToast(e.j.neterror);
            } else if (a(this.bBf.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.gfh == null) {
                            this.gfh = new GetEmotionPidModel();
                        }
                        if (this.gfD != null) {
                            this.gfD.Mv();
                        }
                        this.gfh.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.fXp != null) {
                                    a.this.fXp.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.gfD != null) {
                    this.gfD.Mv();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.aZR.getWriteData() == null && pbModel != null) {
                this.aZR.setWriteData(pbModel.hK(null));
            }
            if (this.aZR.getWriteData() != null) {
                if (dVar.bgj().AR()) {
                    this.aZR.getWriteData().setCanNoForum(true);
                    if (dVar.bgh() != null) {
                        this.aZR.getWriteData().setVForumId(dVar.bgh().getId());
                        this.aZR.getWriteData().setVForumName(dVar.bgh().getName());
                    }
                } else {
                    this.aZR.getWriteData().setCanNoForum(false);
                    this.aZR.getWriteData().setVForumId("");
                    this.aZR.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aZR.getWriteData();
                if (this.aZQ == null || !this.aZQ.alM()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(",");
                sb.append(emotionImageData.getWidth()).append(",");
                sb.append(emotionImageData.getHeight()).append(",");
                String str = "#(" + sb.toString() + s.bC(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aZR.getWriteData().setContent(str);
                } else {
                    this.aZR.getWriteData().setContent(tk(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aZR.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aZR.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aZR.b(this.baf);
                if (!this.aZR.startPostWrite()) {
                }
            }
        }
    }

    private String tk(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.gfD = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.fXp = dVar;
    }

    private boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25017) {
                if (intent != null) {
                    WriteData writeData = this.aZR != null ? this.aZR.getWriteData() : null;
                    resetData();
                    if (this.fXp != null) {
                        this.fXp.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.gfE, this.gfF, this.gfG);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.gfh != null) {
            this.gfh.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.gfE = null;
        this.gfG = null;
        this.gfF = null;
        if (this.aZR != null) {
            this.aZR.setWriteData(null);
        }
    }
}
