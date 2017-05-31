package com.baidu.tieba.pb.pb.main.emotion.model;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b {
    private LocationModel aAA;
    private NewWriteModel aAB;
    private final NewWriteModel.d aAR = new c(this);
    private BaseActivity bfa;
    private com.baidu.tbadk.editortools.pb.b drT;
    private NewWriteModel.d evS;
    private GetEmotionPidModel evT;
    private EmotionImageData evU;
    private PbModel evV;
    private com.baidu.tieba.pb.data.f evW;

    public b(BaseActivity baseActivity) {
        this.bfa = baseActivity;
        this.aAB = new NewWriteModel(baseActivity);
        this.aAA = new LocationModel(baseActivity);
    }

    public void a(EmotionImageData emotionImageData, PbModel pbModel, com.baidu.tieba.pb.data.f fVar) {
        if (emotionImageData != null && fVar != null) {
            this.evU = emotionImageData;
            this.evV = pbModel;
            this.evW = fVar;
            if (!i.hk()) {
                this.bfa.showToast(w.l.neterror);
            } else if (a(this.bfa.getPageContext(), 11042)) {
                if (TextUtils.isEmpty(emotionImageData.getPicId())) {
                    if (!TextUtils.isEmpty(emotionImageData.getPicUrl())) {
                        if (this.evT == null) {
                            this.evT = new GetEmotionPidModel();
                        }
                        if (this.drT != null) {
                            this.drT.CJ();
                        }
                        this.evT.a(emotionImageData.getPicUrl(), new d(this, emotionImageData, pbModel, fVar));
                        return;
                    }
                    return;
                }
                if (this.drT != null) {
                    this.drT.CJ();
                }
                b(emotionImageData, pbModel, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmotionImageData emotionImageData, PbModel pbModel, com.baidu.tieba.pb.data.f fVar) {
        boolean z = true;
        if (emotionImageData != null && fVar != null) {
            if (this.aAB.getWriteData() == null && pbModel != null) {
                this.aAB.setWriteData(pbModel.fo(null));
            }
            if (this.aAB.getWriteData() != null) {
                if (fVar.aIB().sE()) {
                    this.aAB.getWriteData().setCanNoForum(true);
                    if (fVar.aIz() != null) {
                        this.aAB.getWriteData().setVForumId(fVar.aIz().getId());
                        this.aAB.getWriteData().setVForumName(fVar.aIz().getName());
                    }
                } else {
                    this.aAB.getWriteData().setCanNoForum(false);
                    this.aAB.getWriteData().setVForumId("");
                    this.aAB.getWriteData().setVForumName("");
                }
                WriteData writeData = this.aAB.getWriteData();
                if (this.aAA == null || !this.aAA.QG()) {
                    z = false;
                }
                writeData.setHasLocationData(z);
                this.aAB.getWriteData().setContent("#(pic," + emotionImageData.getPicId() + "," + emotionImageData.getWidth() + "," + emotionImageData.getHeight() + ")");
                this.aAB.b(this.aAR);
                if (!this.aAB.startPostWrite()) {
                }
            }
        }
    }

    public void b(com.baidu.tbadk.editortools.pb.b bVar) {
        this.drT = bVar;
    }

    public void c(NewWriteModel.d dVar) {
        this.evS = dVar;
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
                    WriteData writeData = this.aAB != null ? this.aAB.getWriteData() : null;
                    resetData();
                    if (this.evS != null) {
                        this.evS.callback(true, null, null, writeData, null);
                    }
                }
            } else if (i == 11042) {
                a(this.evU, this.evV, this.evW);
            }
        }
    }

    public boolean cancelLoadData() {
        if (this.evT != null) {
            this.evT.cancelLoadData();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.evU = null;
        this.evW = null;
        this.evV = null;
        if (this.aAB != null) {
            this.aAB.setWriteData(null);
        }
    }
}
