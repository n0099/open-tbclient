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
    private BaseActivity cWT;
    private LocationModel ctJ;
    private NewWriteModel ctK;
    private final NewWriteModel.d ctY = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.ctK.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.amG())) {
                writeData2.setVcodeMD5(xVar.getVcode_md5());
                writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                writeData2.setVcodeExtra(xVar.amH());
                if (com.baidu.tbadk.v.a.ru(xVar.amG())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.cWT.getPageContext().getPageActivity(), 25017, writeData2, false, xVar.amG())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.cWT.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.cWT.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.hPN != null) {
                a.this.hPN.callback(z, postWriteCallBackData, xVar, writeData2, antiData);
            }
        }
    };
    private NewWriteModel.d hPN;
    private GetEmotionPidModel hXK;
    private c hYg;
    private EmotionImageData hYh;
    private PbModel hYi;
    private d hYj;

    public a(BaseActivity baseActivity) {
        this.cWT = baseActivity;
        this.ctK = new NewWriteModel(baseActivity);
        this.ctJ = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.hYh = emotionImageData;
            this.hYi = pbModel;
            this.hYj = dVar;
            if (!j.kc()) {
                this.cWT.showToast(R.string.neterror);
            } else if (a(this.cWT.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.hXK == null) {
                            this.hXK = new GetEmotionPidModel();
                        }
                        if (this.hYg != null) {
                            this.hYg.asz();
                        }
                        this.hXK.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.hPN != null) {
                                    a.this.hPN.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.hYg != null) {
                    this.hYg.asz();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.ctK.getWriteData() == null && pbModel != null) {
                this.ctK.setWriteData(pbModel.qm(null));
            }
            if (this.ctK.getWriteData() != null) {
                if (dVar.bSL().afQ()) {
                    this.ctK.getWriteData().setCanNoForum(true);
                    if (dVar.getForum() != null) {
                        this.ctK.getWriteData().setVForumId(dVar.getForum().getId());
                        this.ctK.getWriteData().setVForumName(dVar.getForum().getName());
                    }
                } else {
                    this.ctK.getWriteData().setCanNoForum(false);
                    this.ctK.getWriteData().setVForumId("");
                    this.ctK.getWriteData().setVForumName("");
                }
                WriteData writeData = this.ctK.getWriteData();
                if (this.ctJ == null || !this.ctJ.aVC()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.bn(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.ctK.getWriteData().setContent(str);
                } else {
                    this.ctK.getWriteData().setContent(Cl(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.ctK.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.ctK.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.ctK.b(this.ctY);
                if (!this.ctK.startPostWrite()) {
                }
            }
        }
    }

    private String Cl(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.hYg = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.hPN = dVar;
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
                    WriteData writeData = this.ctK != null ? this.ctK.getWriteData() : null;
                    resetData();
                    if (this.hPN != null) {
                        this.hPN.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.hYh, this.hYi, this.hYj);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.hXK != null) {
            this.hXK.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.hYh = null;
        this.hYj = null;
        this.hYi = null;
        if (this.ctK != null) {
            this.ctK.setWriteData(null);
        }
    }
}
