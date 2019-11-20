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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.y;
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
    private LocationModel cFY;
    private NewWriteModel cFZ;
    private final NewWriteModel.d cGo = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            WriteData cla = writeData == null ? a.this.cFZ.cla() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cla != null && yVar != null && !TextUtils.isEmpty(yVar.apr())) {
                cla.setVcodeMD5(yVar.getVcode_md5());
                cla.setVcodeUrl(yVar.getVcode_pic_url());
                cla.setVcodeExtra(yVar.aps());
                if (com.baidu.tbadk.v.a.qv(yVar.apr())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.mActivity.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cla, false, yVar.apr())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.mActivity.getPageContext().getPageActivity(), cla, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.mActivity.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cla, postWriteCallBackData.getAccessState())));
            }
            if (a.this.hPy != null) {
                a.this.hPy.callback(z, postWriteCallBackData, yVar, cla, antiData);
            }
        }
    };
    private NewWriteModel.d hPy;
    private c hXU;
    private EmotionImageData hXV;
    private PbModel hXW;
    private d hXX;
    private GetEmotionPidModel hXy;
    private BaseActivity mActivity;

    public a(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        this.cFZ = new NewWriteModel(baseActivity);
        this.cFY = new LocationModel(baseActivity);
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final d dVar) {
        if (emotionImageData != null && dVar != null) {
            this.hXV = emotionImageData;
            this.hXW = pbModel;
            this.hXX = dVar;
            if (!j.isNetWorkAvailable()) {
                this.mActivity.showToast(R.string.neterror);
            } else if (a(this.mActivity.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.hXy == null) {
                            this.hXy = new GetEmotionPidModel();
                        }
                        if (this.hXU != null) {
                            this.hXU.auv();
                        }
                        this.hXy.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, dVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.hPy != null) {
                                    a.this.hPy.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.hXU != null) {
                    this.hXU.auv();
                }
                b(emotionImageData, pbModel, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, d dVar) {
        boolean z = true;
        if (emotionImageData != null && dVar != null) {
            if (this.cFZ.cla() == null && pbModel != null) {
                this.cFZ.d(pbModel.pG(null));
            }
            if (this.cFZ.cla() != null) {
                if (dVar.bQx().ajV()) {
                    this.cFZ.cla().setCanNoForum(true);
                    if (dVar.getForum() != null) {
                        this.cFZ.cla().setVForumId(dVar.getForum().getId());
                        this.cFZ.cla().setVForumName(dVar.getForum().getName());
                    }
                } else {
                    this.cFZ.cla().setCanNoForum(false);
                    this.cFZ.cla().setVForumId("");
                    this.cFZ.cla().setVForumName("");
                }
                WriteData cla = this.cFZ.cla();
                if (this.cFY == null || !this.cFY.aWP()) {
                    z = false;
                }
                cla.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.cFZ.cla().setContent(str);
                } else {
                    this.cFZ.cla().setContent(Bd(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.cFZ.cla().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.cFZ.cla().setMemeText(emotionImageData.getMemeText());
                }
                this.cFZ.b(this.cGo);
                if (!this.cFZ.cpC()) {
                }
            }
        }
    }

    private String Bd(String str) {
        return "@" + str + HanziToPinyin.Token.SEPARATOR;
    }

    public void b(c cVar) {
        this.hXU = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.hPy = dVar;
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
                    WriteData cla = this.cFZ != null ? this.cFZ.cla() : null;
                    resetData();
                    if (this.hPy != null) {
                        this.hPy.callback(true, null, null, cla, null);
                    }
                }
            } else if (i == 11042) {
                a(this.hXV, this.hXW, this.hXX);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.hXy != null) {
            this.hXy.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.hXV = null;
        this.hXX = null;
        this.hXW = null;
        if (this.cFZ != null) {
            this.cFZ.d((WriteData) null);
        }
    }
}
