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
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes4.dex */
public class a {
    private BaseActivity cNc;
    private LocationModel ckf;
    private NewWriteModel ckg;
    private final NewWriteModel.d cku = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.ckg.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && xVar != null && !TextUtils.isEmpty(xVar.agA())) {
                writeData2.setVcodeMD5(xVar.getVcode_md5());
                writeData2.setVcodeUrl(xVar.getVcode_pic_url());
                writeData2.setVcodeExtra(xVar.agB());
                if (com.baidu.tbadk.u.a.pU(xVar.agA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(a.this.cNc.getPageContext().getPageActivity(), 25017, writeData2, false, xVar.agA())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(a.this.cNc.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.cNc.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.hqW != null) {
                a.this.hqW.callback(z, postWriteCallBackData, xVar, writeData2, antiData);
            }
        }
    };
    private NewWriteModel.d hqW;
    private GetEmotionPidModel hyM;
    private c hzi;
    private EmotionImageData hzj;
    private PbModel hzk;
    private d hzl;

    public a(BaseActivity baseActivity) {
        this.cNc = baseActivity;
        this.ckg = new NewWriteModel(baseActivity);
        this.ckf = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.hzj = emotionImageData;
            this.hzk = pbModel;
            this.hzl = dVar;
            if (!j.kY()) {
                this.cNc.showToast(d.j.neterror);
            } else if (a(this.cNc.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.hyM == null) {
                            this.hyM = new GetEmotionPidModel();
                        }
                        if (this.hzi != null) {
                            this.hzi.amo();
                        }
                        this.hyM.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.hqW != null) {
                                    a.this.hqW.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.hzi != null) {
                    this.hzi.amo();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, com.baidu.tieba.pb.data.d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.ckg.getWriteData() == null && pbModel != null) {
                this.ckg.setWriteData(pbModel.oO(null));
            }
            if (this.ckg.getWriteData() != null) {
                if (dVar.bHW().aag()) {
                    this.ckg.getWriteData().setCanNoForum(true);
                    if (dVar.getForum() != null) {
                        this.ckg.getWriteData().setVForumId(dVar.getForum().getId());
                        this.ckg.getWriteData().setVForumName(dVar.getForum().getName());
                    }
                } else {
                    this.ckg.getWriteData().setCanNoForum(false);
                    this.ckg.getWriteData().setVForumId("");
                    this.ckg.getWriteData().setVForumName("");
                }
                WriteData writeData = this.ckg.getWriteData();
                if (this.ckf == null || !this.ckf.aNu()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.bC(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.ckg.getWriteData().setContent(str);
                } else {
                    this.ckg.getWriteData().setContent(Ag(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.ckg.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.ckg.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.ckg.b(this.cku);
                if (!this.ckg.startPostWrite()) {
                }
            }
        }
    }

    private String Ag(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.hzi = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.hqW = dVar;
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
                    WriteData writeData = this.ckg != null ? this.ckg.getWriteData() : null;
                    resetData();
                    if (this.hqW != null) {
                        this.hqW.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.hzj, this.hzk, this.hzl);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.hyM != null) {
            this.hyM.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.hzj = null;
        this.hzl = null;
        this.hzk = null;
        if (this.ckg != null) {
            this.ckg.setWriteData(null);
        }
    }
}
