package com.baidu.tieba.pb.pb.main.emotion.model;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.w;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class a {
    private LocationModel aBD;
    private NewWriteModel aBE;
    private final NewWriteModel.d aBU = new b(this);
    private BaseActivity bhX;
    private com.baidu.tbadk.editortools.pb.b dAG;
    private NewWriteModel.d eFf;
    private GetEmotionPidModel eFg;
    private EmotionImageData eFh;
    private PbModel eFi;
    private f eFj;

    public a(BaseActivity baseActivity) {
        this.bhX = baseActivity;
        this.aBE = new NewWriteModel(baseActivity);
        this.aBD = new LocationModel(baseActivity);
    }

    public void a(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.eFh = emotionImageData;
            this.eFi = pbModel;
            this.eFj = fVar;
            if (!i.hj()) {
                this.bhX.showToast(w.l.neterror);
            } else if (a(this.bhX.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.eFg == null) {
                            this.eFg = new GetEmotionPidModel();
                        }
                        if (this.dAG != null) {
                            this.dAG.Dd();
                        }
                        this.eFg.a(emotionImageData.getPicUrl(), new c(this, emotionImageData, pbModel, fVar));
                        return;
                    }
                    return;
                }
                if (this.dAG != null) {
                    this.dAG.Dd();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.aBE.getWriteData() == null && pbModel != null) {
                this.aBE.setWriteData(pbModel.fI(null));
            }
            if (this.aBE.getWriteData() != null) {
                if (fVar.aMv().sC()) {
                    this.aBE.getWriteData().setCanNoForum(true);
                    if (fVar.aMt() != null) {
                        this.aBE.getWriteData().setVForumId(fVar.aMt().getId());
                        this.aBE.getWriteData().setVForumName(fVar.aMt().getName());
                    }
                } else {
                    this.aBE.getWriteData().setCanNoForum(false);
                    this.aBE.getWriteData().setVForumId("");
                    this.aBE.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aBE.getWriteData();
                if (this.aBD == null || !this.aBD.Sy()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(emotionImageData.getPicId()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getWidth()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(emotionImageData.getHeight()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                this.aBE.getWriteData().setContent("#(" + sb.toString() + t.aN(String.valueOf(sb.toString()) + "7S6wbXjEKL9N").toLowerCase() + ")");
                this.aBE.b(this.aBU);
                if (!this.aBE.startPostWrite()) {
                }
            }
        }
    }

    public void b(com.baidu.tbadk.editortools.pb.b bVar) {
        this.dAG = bVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.eFf = dVar;
    }

    private boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(w.l.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25017) {
                if (intent != null) {
                    WriteData writeData = this.aBE != null ? this.aBE.getWriteData() : null;
                    resetData();
                    if (this.eFf != null) {
                        this.eFf.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.eFh, this.eFi, this.eFj);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.eFg != null) {
            this.eFg.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.eFh = null;
        this.eFj = null;
        this.eFi = null;
        if (this.aBE != null) {
            this.aBE.setWriteData(null);
        }
    }
}
