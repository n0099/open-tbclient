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
    private final NewWriteModel.d eMD = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            WriteData cKZ = writeData == null ? a.this.eMp.cKZ() : writeData;
            if (z) {
                a.this.resetData();
            } else if (cKZ != null && agVar != null && !TextUtils.isEmpty(agVar.bmY())) {
                cKZ.setVcodeMD5(agVar.getVcode_md5());
                cKZ.setVcodeUrl(agVar.getVcode_pic_url());
                cKZ.setVcodeExtra(agVar.bmZ());
                if (com.baidu.tbadk.t.a.CO(agVar.bmY())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(a.this.hwQ.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cKZ, false, agVar.bmY())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(a.this.hwQ.getPageContext().getPageActivity(), cKZ, RequestResponseCode.REQUEST_VCODE_FROM_EMOTION)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.hwQ.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE_FROM_EMOTION, cKZ, postWriteCallBackData.getAccessState())));
            }
            if (a.this.kCT != null) {
                a.this.kCT.callback(z, postWriteCallBackData, agVar, cKZ, antiData);
            }
        }
    };
    private LocationModel eMo;
    private NewWriteModel eMp;
    private BaseFragmentActivity hwQ;
    private NewWriteModel.d kCT;
    private c kOV;
    private EmotionImageData kOW;
    private PbModel kOX;
    private f kOY;
    private GetEmotionPidModel kOx;

    public a(BaseFragmentActivity baseFragmentActivity) {
        this.hwQ = baseFragmentActivity;
        this.eMp = new NewWriteModel(baseFragmentActivity);
        this.eMo = new LocationModel(baseFragmentActivity.getPageContext());
    }

    public void a(final EmotionImageData emotionImageData, final PbModel pbModel, final f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.kOW = emotionImageData;
            this.kOX = pbModel;
            this.kOY = fVar;
            if (!j.isNetWorkAvailable()) {
                this.hwQ.showToast(R.string.neterror);
            } else if (a(this.hwQ.getPageContext(), RequestResponseCode.REQUEST_LOGIN_SEND_EMOTION)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.kOx == null) {
                            this.kOx = new GetEmotionPidModel();
                        }
                        if (this.kOV != null) {
                            this.kOV.brV();
                        }
                        this.kOx.a(emotionImageData.getPicUrl(), new GetEmotionPidModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.a.1
                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void a(com.baidu.tbadk.img.c cVar) {
                                if (cVar != null && !TextUtils.isEmpty(cVar.picId)) {
                                    emotionImageData.setPicId(cVar.picId);
                                    a.this.b(emotionImageData, pbModel, fVar);
                                }
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionPidModel.a
                            public void onFail(int i, String str) {
                                if (a.this.kCT != null) {
                                    a.this.kCT.callback(false, null, null, null, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.kOV != null) {
                    this.kOV.brV();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.eMp.cKZ() == null && pbModel != null) {
                this.eMp.d(pbModel.BU(null));
            }
            if (this.eMp.cKZ() != null) {
                if (fVar.cVl().bgb()) {
                    this.eMp.cKZ().setCanNoForum(true);
                    if (fVar.getForum() != null) {
                        this.eMp.cKZ().setVForumId(fVar.getForum().getId());
                        this.eMp.cKZ().setVForumName(fVar.getForum().getName());
                    }
                } else {
                    this.eMp.cKZ().setCanNoForum(false);
                    this.eMp.cKZ().setVForumId("");
                    this.eMp.cKZ().setVForumName("");
                }
                WriteData cKZ = this.eMp.cKZ();
                if (this.eMo == null || !this.eMo.bXz()) {
                    z = false;
                }
                cKZ.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String str = "#(" + sb.toString() + s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                if (StringUtils.isNull(emotionImageData.getAuthorNameShow())) {
                    this.eMp.cKZ().setContent(str);
                } else {
                    this.eMp.cKZ().setContent(NS(emotionImageData.getAuthorNameShow()) + str);
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeContSign())) {
                    this.eMp.cKZ().setMemeContSign(emotionImageData.getMemeContSign());
                }
                if (!TextUtils.isEmpty(emotionImageData.getMemeText())) {
                    this.eMp.cKZ().setMemeText(emotionImageData.getMemeText());
                }
                this.eMp.b(this.eMD);
                if (!this.eMp.dxS()) {
                }
            }
        }
    }

    private String NS(String str) {
        return UgcConstant.AT_RULE_TAG + str + " ";
    }

    public void b(c cVar) {
        this.kOV = cVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.kCT = dVar;
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
                    WriteData cKZ = this.eMp != null ? this.eMp.cKZ() : null;
                    resetData();
                    if (this.kCT != null) {
                        this.kCT.callback(true, null, null, cKZ, null);
                    }
                }
            } else if (i == 11042) {
                a(this.kOW, this.kOX, this.kOY);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.kOx != null) {
            this.kOx.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.kOW = null;
        this.kOY = null;
        this.kOX = null;
        if (this.eMp != null) {
            this.eMp.d((WriteData) null);
        }
    }
}
