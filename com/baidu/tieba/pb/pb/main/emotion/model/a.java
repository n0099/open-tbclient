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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.editortools.pb.c;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class a {
    private LocationModel brJ;
    private NewWriteModel brK;
    private final NewWriteModel.d brY = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            WriteData writeData2 = writeData == null ? a.this.brK.getWriteData() : writeData;
            if (z) {
                a.this.resetData();
            } else if (writeData2 != null && tVar != null && !TextUtils.isEmpty(tVar.Fz())) {
                writeData2.setVcodeMD5(tVar.getVcode_md5());
                writeData2.setVcodeUrl(tVar.getVcode_pic_url());
                writeData2.setVcodeExtra(tVar.FA());
                if (com.baidu.tbadk.p.a.hg(tVar.Fz())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.cmR.getPageContext().getPageActivity(), 25017, writeData2, false, tVar.Fz())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.cmR.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.cmR.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
            if (a.this.fLC != null) {
                a.this.fLC.callback(z, postWriteCallBackData, tVar, writeData2, antiData);
            }
        }
    };
    private BaseActivity cmR;
    private NewWriteModel.d fLC;
    private c fTK;
    private EmotionImageData fTL;
    private PbModel fTM;
    private f fTN;
    private GetEmotionPidModel fTo;

    public a(BaseActivity baseActivity) {
        this.cmR = baseActivity;
        this.brK = new NewWriteModel(baseActivity);
        this.brJ = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.fTL = emotionImageData;
            this.fTM = pbModel;
            this.fTN = fVar;
            if (!j.oI()) {
                this.cmR.showToast(d.j.neterror);
            } else if (a(this.cmR.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.fTo == null) {
                            this.fTo = new GetEmotionPidModel();
                        }
                        if (this.fTK != null) {
                            this.fTK.KR();
                        }
                        this.fTo.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.fLC != null) {
                                    a.this.fLC.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.fTK != null) {
                    this.fTK.KR();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.brK.getWriteData() == null && pbModel != null) {
                this.brK.setWriteData(pbModel.ga(null));
            }
            if (this.brK.getWriteData() != null) {
                if (fVar.aYG().Ac()) {
                    this.brK.getWriteData().setCanNoForum(true);
                    if (fVar.aYE() != null) {
                        this.brK.getWriteData().setVForumId(fVar.aYE().getId());
                        this.brK.getWriteData().setVForumName(fVar.aYE().getName());
                    }
                } else {
                    this.brK.getWriteData().setCanNoForum(false);
                    this.brK.getWriteData().setVForumId("");
                    this.brK.getWriteData().setVForumName("");
                }
                WriteData writeData = this.brK.getWriteData();
                if (this.brJ == null || !this.brJ.agf()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.ba(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.brK.getWriteData().setContent(str);
                } else {
                    this.brK.getWriteData().setContent(qq(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.brK.getWriteData().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.brK.getWriteData().setMemeText(emotionImageData.getMemeText());
                }
                this.brK.b(this.brY);
                if (!this.brK.startPostWrite()) {
                }
            }
        }
    }

    private String qq(String str) {
        return "@" + str + " ";
    }

    public void b(c cVar) {
        this.fTK = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.fLC = dVar;
    }

    private boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25017) {
                if (intent != null) {
                    WriteData writeData = this.brK != null ? this.brK.getWriteData() : null;
                    resetData();
                    if (this.fLC != null) {
                        this.fLC.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.fTL, this.fTM, this.fTN);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.fTo != null) {
            this.fTo.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fTL = null;
        this.fTN = null;
        this.fTM = null;
        if (this.brK != null) {
            this.brK.setWriteData(null);
        }
    }
}
