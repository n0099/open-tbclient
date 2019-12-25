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
import com.baidu.tbadk.coreExtra.data.y;
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
/* loaded from: classes6.dex */
public class a {
    private LocationModel dtT;
    private NewWriteModel dtU;
    private final NewWriteModel.d dui = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            WriteData cFi = writeData == null ? a.this.dtU.cFi() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cFi != null && yVar != null && !TextUtils.isEmpty(yVar.aGQ())) {
                cFi.setVcodeMD5(yVar.getVcode_md5());
                cFi.setVcodeUrl(yVar.getVcode_pic_url());
                cFi.setVcodeExtra(yVar.aGR());
                if (com.baidu.tbadk.s.a.vB(yVar.aGQ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.gms.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cFi, false, yVar.aGQ())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.gms.getPageContext().getPageActivity(), cFi, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.gms.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cFi, postWriteCallBackData.getAccessState())));
            }
            if (a.this.iBQ != null) {
                a.this.iBQ.callback(z, postWriteCallBackData, yVar, cFi, antiData);
            }
        }
    };
    private BaseFragmentActivity gms;
    private NewWriteModel.d iBQ;
    private c iMU;
    private EmotionImageData iMV;
    private PbModel iMW;
    private f iMX;
    private GetEmotionPidModel iMw;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.gms = baseFragmentActivity;
        this.dtU = new NewWriteModel(baseFragmentActivity);
        this.dtT = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.iMV = emotionImageData;
            this.iMW = pbModel;
            this.iMX = fVar;
            if (!j.isNetWorkAvailable()) {
                this.gms.showToast(R.string.neterror);
            } else if (a(this.gms.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.iMw == null) {
                            this.iMw = new GetEmotionPidModel();
                        }
                        if (this.iMU != null) {
                            this.iMU.aMa();
                        }
                        this.iMw.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.iBQ != null) {
                                    a.this.iBQ.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.iMU != null) {
                    this.iMU.aMa();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.dtU.cFi() == null && pbModel != null) {
                this.dtU.d(pbModel.uM(null));
            }
            if (this.dtU.cFi() != null) {
                if (fVar.chK().aAY()) {
                    this.dtU.cFi().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.dtU.cFi().setVForumId(fVar.getForum().getId());
                        this.dtU.cFi().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.dtU.cFi().setCanNoForum(false);
                    this.dtU.cFi().setVForumId("");
                    this.dtU.cFi().setVForumName("");
                }
                WriteData cFi = this.dtU.cFi();
                if (this.dtT == null || !this.dtT.boD()) {
                    z = false;
                }
                cFi.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.dtU.cFi().setContent(str);
                } else {
                    this.dtU.cFi().setContent(FO(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.dtU.cFi().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.dtU.cFi().setMemeText(emotionImageData.getMemeText());
                }
                this.dtU.b(this.dui);
                if (!this.dtU.cJG()) {
                }
            }
        }
    }

    private String FO(String str) {
        return "@" + str + HanziToPinyin.Token.SEPARATOR;
    }

    public void b(c cVar) {
        this.iMU = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.iBQ = dVar;
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
                    WriteData cFi = this.dtU != null ? this.dtU.cFi() : null;
                    resetData();
                    if (this.iBQ != null) {
                        this.iBQ.callback(true, null, null, cFi, null);
                    }
                }
            } else if (i == 11042) {
                a(this.iMV, this.iMW, this.iMX);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.iMw != null) {
            this.iMw.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.iMV = null;
        this.iMX = null;
        this.iMW = null;
        if (this.dtU != null) {
            this.dtU.d((WriteData) null);
        }
    }
}
