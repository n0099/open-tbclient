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
import com.baidu.tieba.e;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes6.dex */
public class a {
    private BaseActivity bBV;
    private LocationModel baE;
    private NewWriteModel baF;
    private final NewWriteModel.d baT = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.baF.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.Hk())) {
                writeData2.setVcodeMD5(xVar.getVcode_md5());
                writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                writeData2.setVcodeExtra(xVar.Hl());
                if (com.baidu.tbadk.r.a.jj(xVar.Hk())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.bBV.getPageContext().getPageActivity(), 25017, writeData2, false, xVar.Hk())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.bBV.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.bBV.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.gbe != null) {
                a.this.gbe.callback(z, postWriteCallBackData, xVar, writeData2, antiData);
            }
        }
    };
    private NewWriteModel.d gbe;
    private EmotionImageData gjA;
    private PbModel gjB;
    private d gjC;
    private GetEmotionPidModel gjd;
    private c gjz;

    public a(BaseActivity baseActivity) {
        this.bBV = baseActivity;
        this.baF = new NewWriteModel(baseActivity);
        this.baE = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.gjA = emotionImageData;
            this.gjB = pbModel;
            this.gjC = dVar;
            if (!j.kV()) {
                this.bBV.showToast(e.j.neterror);
            } else if (a(this.bBV.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.gjd == null) {
                            this.gjd = new GetEmotionPidModel();
                        }
                        if (this.gjz != null) {
                            this.gjz.MN();
                        }
                        this.gjd.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.gbe != null) {
                                    a.this.gbe.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.gjz != null) {
                    this.gjz.MN();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.baF.getWriteData() == null && pbModel != null) {
                this.baF.setWriteData(pbModel.hZ(null));
            }
            if (this.baF.getWriteData() != null) {
                if (dVar.bhz().Be()) {
                    this.baF.getWriteData().setCanNoForum(true);
                    if (dVar.bhx() != null) {
                        this.baF.getWriteData().setVForumId(dVar.bhx().getId());
                        this.baF.getWriteData().setVForumName(dVar.bhx().getName());
                    }
                } else {
                    this.baF.getWriteData().setCanNoForum(false);
                    this.baF.getWriteData().setVForumId("");
                    this.baF.getWriteData().setVForumName("");
                }
                WriteData writeData = this.baF.getWriteData();
                if (this.baE == null || !this.baE.amL()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(",");
                sb.append(emotionImageData.getWidth()).append(",");
                sb.append(emotionImageData.getHeight()).append(",");
                String str = "#(" + sb.toString() + s.bC(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.baF.getWriteData().setContent(str);
                } else {
                    this.baF.getWriteData().setContent(tD(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.baF.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.baF.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.baF.b(this.baT);
                if (!this.baF.startPostWrite()) {
                }
            }
        }
    }

    private String tD(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.gjz = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.gbe = dVar;
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
                    WriteData writeData = this.baF != null ? this.baF.getWriteData() : null;
                    resetData();
                    if (this.gbe != null) {
                        this.gbe.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.gjA, this.gjB, this.gjC);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.gjd != null) {
            this.gjd.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.gjA = null;
        this.gjC = null;
        this.gjB = null;
        if (this.baF != null) {
            this.baF.setWriteData(null);
        }
    }
}
