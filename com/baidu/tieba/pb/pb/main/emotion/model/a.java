package com.baidu.tieba.pb.pb.main.emotion.model;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.s;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ag;
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
/* loaded from: classes16.dex */
public class a {
    private final NewWriteModel.d eMH = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            WriteData cLa = writeData == null ? a.this.eMt.cLa() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cLa != null && agVar != null && !TextUtils.isEmpty(agVar.bmY())) {
                cLa.setVcodeMD5(agVar.getVcode_md5());
                cLa.setVcodeUrl(agVar.getVcode_pic_url());
                cLa.setVcodeExtra(agVar.bmZ());
                if (com.baidu.tbadk.t.a.CP(agVar.bmY())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.hwW.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cLa, false, agVar.bmY())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.hwW.getPageContext().getPageActivity(), cLa, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.hwW.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cLa, postWriteCallBackData.getAccessState())));
            }
            if (a.this.kDa != null) {
                a.this.kDa.callback(z, postWriteCallBackData, agVar, cLa, antiData);
            }
        }
    };
    private LocationModel eMs;
    private NewWriteModel eMt;
    private BaseFragmentActivity hwW;
    private NewWriteModel.d kDa;
    private GetEmotionPidModel kOE;
    private c kPc;
    private EmotionImageData kPd;
    private PbModel kPe;
    private f kPf;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.hwW = baseFragmentActivity;
        this.eMt = new NewWriteModel(baseFragmentActivity);
        this.eMs = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.kPd = emotionImageData;
            this.kPe = pbModel;
            this.kPf = fVar;
            if (!j.isNetWorkAvailable()) {
                this.hwW.showToast(R.string.neterror);
            } else if (a(this.hwW.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.kOE == null) {
                            this.kOE = new GetEmotionPidModel();
                        }
                        if (this.kPc != null) {
                            this.kPc.brW();
                        }
                        this.kOE.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.kDa != null) {
                                    a.this.kDa.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.kPc != null) {
                    this.kPc.brW();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.eMt.cLa() == null && pbModel != null) {
                this.eMt.d(pbModel.BV(null));
            }
            if (this.eMt.cLa() != null) {
                if (fVar.cVm().bgb()) {
                    this.eMt.cLa().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.eMt.cLa().setVForumId(fVar.getForum().getId());
                        this.eMt.cLa().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.eMt.cLa().setCanNoForum(false);
                    this.eMt.cLa().setVForumId("");
                    this.eMt.cLa().setVForumName("");
                }
                WriteData cLa = this.eMt.cLa();
                if (this.eMs == null || !this.eMs.bXA()) {
                    z = false;
                }
                cLa.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.eMt.cLa().setContent(str);
                } else {
                    this.eMt.cLa().setContent(NT(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.eMt.cLa().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.eMt.cLa().setMemeText(emotionImageData.getMemeText());
                }
                this.eMt.b(this.eMH);
                if (!this.eMt.dxX()) {
                }
            }
        }
    }

    private String NT(String str) {
        return UgcConstant.AT_RULE_TAG + str + " ";
    }

    public void b(c cVar) {
        this.kPc = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.kDa = dVar;
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
                    WriteData cLa = this.eMt != null ? this.eMt.cLa() : null;
                    resetData();
                    if (this.kDa != null) {
                        this.kDa.callback(true, null, null, cLa, null);
                    }
                }
            } else if (i == 11042) {
                a(this.kPd, this.kPe, this.kPf);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.kOE != null) {
            this.kOE.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.kPd = null;
        this.kPf = null;
        this.kPe = null;
        if (this.eMt != null) {
            this.eMt.d((WriteData) null);
        }
    }
}
