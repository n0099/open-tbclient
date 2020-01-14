package com.baidu.tieba.pb.pb.main.emotion.model;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.s;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tbadk.editortools.pb.c;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class a {
    private LocationModel due;
    private NewWriteModel duf;
    private final NewWriteModel.d dut = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
            WriteData cGo = writeData == null ? a.this.duf.cGo() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cGo != null && zVar != null && !TextUtils.isEmpty(zVar.aHk())) {
                cGo.setVcodeMD5(zVar.getVcode_md5());
                cGo.setVcodeUrl(zVar.getVcode_pic_url());
                cGo.setVcodeExtra(zVar.aHl());
                if (com.baidu.tbadk.s.a.vG(zVar.aHk())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gpB.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cGo, false, zVar.aHk())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gpB.getPageContext().getPageActivity(), cGo, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.gpB.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cGo, postWriteCallBackData.getAccessState())));
            }
            if (a.this.iFu != null) {
                a.this.iFu.callback(z, postWriteCallBackData, zVar, cGo, antiData);
            }
        }
    };
    private BaseFragmentActivity gpB;
    private NewWriteModel.d iFu;
    private PbModel iQA;
    private f iQB;
    private GetEmotionPidModel iQa;
    private c iQy;
    private EmotionImageData iQz;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.gpB = baseFragmentActivity;
        this.duf = new NewWriteModel(baseFragmentActivity);
        this.due = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.iQz = emotionImageData;
            this.iQA = pbModel;
            this.iQB = fVar;
            if (!j.isNetWorkAvailable()) {
                this.gpB.showToast(R.string.neterror);
            } else if (a(this.gpB.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.iQa == null) {
                            this.iQa = new GetEmotionPidModel();
                        }
                        if (this.iQy != null) {
                            this.iQy.aMt();
                        }
                        this.iQa.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.iFu != null) {
                                    a.this.iFu.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.iQy != null) {
                    this.iQy.aMt();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.duf.cGo() == null && pbModel != null) {
                this.duf.d(pbModel.uR(null));
            }
            if (this.duf.cGo() != null) {
                if (fVar.ciS().aBr()) {
                    this.duf.cGo().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.duf.cGo().setVForumId(fVar.getForum().getId());
                        this.duf.cGo().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.duf.cGo().setCanNoForum(false);
                    this.duf.cGo().setVForumId("");
                    this.duf.cGo().setVForumName("");
                }
                WriteData cGo = this.duf.cGo();
                if (this.due == null || !this.due.bpD()) {
                    z = false;
                }
                cGo.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.duf.cGo().setContent(str);
                } else {
                    this.duf.cGo().setContent(FY(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.duf.cGo().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.duf.cGo().setMemeText(emotionImageData.getMemeText());
                }
                this.duf.b(this.dut);
                if (!this.duf.cKM()) {
                }
            }
        }
    }

    private String FY(String str) {
        return "@" + str + HanziToPinyin.Token.SEPARATOR;
    }

    public void b(c cVar) {
        this.iQy = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.iFu = dVar;
    }

    private boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25017) {
                if (intent != null) {
                    WriteData cGo = this.duf != null ? this.duf.cGo() : null;
                    resetData();
                    if (this.iFu != null) {
                        this.iFu.callback(true, null, null, cGo, null);
                    }
                }
            } else if (i == 11042) {
                a(this.iQz, this.iQA, this.iQB);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.iQa != null) {
            this.iQa.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.iQz = null;
        this.iQB = null;
        this.iQA = null;
        if (this.duf != null) {
            this.duf.d((WriteData) null);
        }
    }
}
