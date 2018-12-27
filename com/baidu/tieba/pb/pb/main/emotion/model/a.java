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
    private LocationModel aZT;
    private NewWriteModel aZU;
    private BaseActivity bBi;
    private final NewWriteModel.d bai = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.aZU.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && wVar != null && !TextUtils.isEmpty(wVar.GW())) {
                writeData2.setVcodeMD5(wVar.getVcode_md5());
                writeData2.setVcodeUrl(wVar.getVcode_pic_url());
                writeData2.setVcodeExtra(wVar.GX());
                if (com.baidu.tbadk.r.a.iT(wVar.GW())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.bBi.getPageContext().getPageActivity(), 25017, writeData2, false, wVar.GW())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.bBi.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.bBi.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.gah != null) {
                a.this.gah.callback(z, postWriteCallBackData, wVar, writeData2, antiData);
            }
        }
    };
    private NewWriteModel.d gah;
    private GetEmotionPidModel ghZ;
    private c giw;
    private EmotionImageData gix;
    private PbModel giy;
    private d giz;

    public a(BaseActivity baseActivity) {
        this.bBi = baseActivity;
        this.aZU = new NewWriteModel(baseActivity);
        this.aZT = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.gix = emotionImageData;
            this.giy = pbModel;
            this.giz = dVar;
            if (!j.kV()) {
                this.bBi.showToast(e.j.neterror);
            } else if (a(this.bBi.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.ghZ == null) {
                            this.ghZ = new GetEmotionPidModel();
                        }
                        if (this.giw != null) {
                            this.giw.Mw();
                        }
                        this.ghZ.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.gah != null) {
                                    a.this.gah.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.giw != null) {
                    this.giw.Mw();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.aZU.getWriteData() == null && pbModel != null) {
                this.aZU.setWriteData(pbModel.hL(null));
            }
            if (this.aZU.getWriteData() != null) {
                if (dVar.bgV().AR()) {
                    this.aZU.getWriteData().setCanNoForum(true);
                    if (dVar.bgT() != null) {
                        this.aZU.getWriteData().setVForumId(dVar.bgT().getId());
                        this.aZU.getWriteData().setVForumName(dVar.bgT().getName());
                    }
                } else {
                    this.aZU.getWriteData().setCanNoForum(false);
                    this.aZU.getWriteData().setVForumId("");
                    this.aZU.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aZU.getWriteData();
                if (this.aZT == null || !this.aZT.amo()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(",");
                sb.append(emotionImageData.getWidth()).append(",");
                sb.append(emotionImageData.getHeight()).append(",");
                String str = "#(" + sb.toString() + s.bC(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aZU.getWriteData().setContent(str);
                } else {
                    this.aZU.getWriteData().setContent(tn(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aZU.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aZU.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aZU.b(this.bai);
                if (!this.aZU.startPostWrite()) {
                }
            }
        }
    }

    private String tn(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.giw = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.gah = dVar;
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
                    WriteData writeData = this.aZU != null ? this.aZU.getWriteData() : null;
                    resetData();
                    if (this.gah != null) {
                        this.gah.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.gix, this.giy, this.giz);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.ghZ != null) {
            this.ghZ.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.gix = null;
        this.giz = null;
        this.giy = null;
        if (this.aZU != null) {
            this.aZU.setWriteData(null);
        }
    }
}
