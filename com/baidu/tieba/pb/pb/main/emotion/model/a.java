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
    private LocationModel aNN;
    private NewWriteModel aNO;
    private final NewWriteModel.d aOc = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.aNO.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.Ct())) {
                writeData2.setVcodeMD5(tVar.getVcode_md5());
                writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                writeData2.setVcodeExtra(tVar.Cu());
                if (com.baidu.tbadk.q.a.hN(tVar.Ct())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.bmZ.getPageContext().getPageActivity(), 25017, writeData2, false, tVar.Ct())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.bmZ.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.bmZ.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.fzW != null) {
                a.this.fzW.callback(z, postWriteCallBackData, tVar, writeData2, antiData);
            }
        }
    };
    private BaseActivity bmZ;
    private GetEmotionPidModel fHR;
    private c fIn;
    private EmotionImageData fIo;
    private PbModel fIp;
    private d fIq;
    private NewWriteModel.d fzW;

    public a(BaseActivity baseActivity) {
        this.bmZ = baseActivity;
        this.aNO = new NewWriteModel(baseActivity);
        this.aNN = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.fIo = emotionImageData;
            this.fIp = pbModel;
            this.fIq = dVar;
            if (!j.jE()) {
                this.bmZ.showToast(d.j.neterror);
            } else if (a(this.bmZ.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.fHR == null) {
                            this.fHR = new GetEmotionPidModel();
                        }
                        if (this.fIn != null) {
                            this.fIn.HR();
                        }
                        this.fHR.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.fzW != null) {
                                    a.this.fzW.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.fIn != null) {
                    this.fIn.HR();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, com.baidu.tieba.pb.data.d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.aNO.getWriteData() == null && pbModel != null) {
                this.aNO.setWriteData(pbModel.gH(null));
            }
            if (this.aNO.getWriteData() != null) {
                if (dVar.aZn().wt()) {
                    this.aNO.getWriteData().setCanNoForum(true);
                    if (dVar.aZl() != null) {
                        this.aNO.getWriteData().setVForumId(dVar.aZl().getId());
                        this.aNO.getWriteData().setVForumName(dVar.aZl().getName());
                    }
                } else {
                    this.aNO.getWriteData().setCanNoForum(false);
                    this.aNO.getWriteData().setVForumId("");
                    this.aNO.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aNO.getWriteData();
                if (this.aNN == null || !this.aNN.afQ()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(",");
                sb.append(emotionImageData.getWidth()).append(",");
                sb.append(emotionImageData.getHeight()).append(",");
                String str = "#(" + sb.toString() + s.bm(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.aNO.getWriteData().setContent(str);
                } else {
                    this.aNO.getWriteData().setContent(rw(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.aNO.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.aNO.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.aNO.b(this.aOc);
                if (!this.aNO.startPostWrite()) {
                }
            }
        }
    }

    private String rw(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.fIn = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.fzW = dVar;
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
                    WriteData writeData = this.aNO != null ? this.aNO.getWriteData() : null;
                    resetData();
                    if (this.fzW != null) {
                        this.fzW.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.fIo, this.fIp, this.fIq);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.fHR != null) {
            this.fHR.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fIo = null;
        this.fIq = null;
        this.fIp = null;
        if (this.aNO != null) {
            this.aNO.setWriteData(null);
        }
    }
}
