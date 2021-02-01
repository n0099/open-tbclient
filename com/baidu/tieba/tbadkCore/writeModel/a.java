package com.baidu.tieba.tbadkCore.writeModel;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.y;
import java.io.File;
/* loaded from: classes.dex */
public class a implements NewWriteModel.d {
    private final NewWriteModel nAB;
    private boolean nAC;
    private BdUniqueId nAD;
    private String nAE;
    private String nAF;
    private String nAG;

    public static a dOU() {
        b.d("AsyncWriteHelper.getInstance()");
        return C0873a.nAH;
    }

    public boolean isAsyncWriting() {
        return this.nAC;
    }

    public void a(@NonNull TbPageContextSupport tbPageContextSupport) {
        b.d("AsyncWriteHelper.initWriteStatus()");
        this.nAB.h(tbPageContextSupport.getPageContext());
        this.nAB.f((WriteData) null);
        this.nAB.yE(false);
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        b.d("AsyncWriteHelper.setSpanGroupManager()");
        this.nAB.dPm();
        this.nAB.setSpanGroupManager(spanGroupManager);
    }

    public boolean dOV() {
        b.d("AsyncWriteHelper.startPostWrite()");
        this.nAB.dPm();
        this.nAC = this.nAB.dPj();
        return this.nAC;
    }

    public void dOW() {
        b.d("AsyncWriteHelper.onWriteActClose()");
        this.nAB.h((com.baidu.adp.base.f<?>) null);
        this.nAB.setSpanGroupManager(null);
    }

    public void cFx() {
        b.d("AsyncWriteHelper.cancelLoadData()");
        this.nAB.cancelLoadData();
    }

    public void yE(boolean z) {
        b.d("AsyncWriteHelper.setHasImage = " + z);
        this.nAB.yE(z);
    }

    public void f(WriteData writeData) {
        b.d("AsyncWriteHelper.setWriteData = " + (writeData == null ? "null" : writeData.toDraftString()));
        this.nAB.f(writeData);
    }

    public WriteData dav() {
        b.d("AsyncWriteHelper.getWriteData = " + (this.nAB.dav() == null ? "null" : this.nAB.dav().toDraftString()));
        return this.nAB.dav();
    }

    public boolean dOX() {
        b.d("AsyncWriteHelper.checkImageNum = " + this.nAB.dOX());
        return this.nAB.dOX();
    }

    public String dOY() {
        return this.nAE;
    }

    public void TF(String str) {
        this.nAE = str;
    }

    public String dOZ() {
        return this.nAF;
    }

    public void TG(String str) {
        this.nAF = str;
    }

    public String dPa() {
        return this.nAG;
    }

    public void TH(String str) {
        this.nAG = str;
    }

    public BdUniqueId dPb() {
        return this.nAD;
    }

    public void E(BdUniqueId bdUniqueId) {
        this.nAD = bdUniqueId;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
        if (writeData != null) {
            if (z) {
                bi.a(writeData, 100).ju(true);
                if ((!au.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) || (writeData.getVideoInfo() != null && writeData.getVideoInfo().hasUpload())) {
                    c.k(postWriteCallBackData);
                } else {
                    c.b(postWriteCallBackData);
                }
                cGO();
                dPc();
                j(postWriteCallBackData);
                if (!au.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                    postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                    if (!au.isEmpty(writeData.getForumName())) {
                        postWriteCallBackData.mFrom = 2;
                    }
                }
                bi.a(writeData, 100).ju(false);
            } else {
                bi.a(writeData, 100).ju(false);
                c.a(postWriteCallBackData, ahVar, writeData, antiData);
            }
            this.nAC = false;
        }
    }

    private void cGO() {
        WriteData dav = dav();
        if (dav != null) {
            if (dav.getType() == 0 || dav.getType() == 9 || dav.getType() == 11) {
                if (dav.isEvaluate()) {
                    y.d(dav.getItem_id(), (WriteData) null);
                } else if (TextUtils.isEmpty(dav.getTopicId())) {
                    y.a(dav.getForumId(), dav, true);
                } else {
                    y.e(dav.getTopicId(), (WriteData) null);
                }
            } else if (dav.getType() == 1) {
                y.b(dav.getThreadId(), (WriteData) null);
            }
        }
    }

    private void dPc() {
        o.deleteFileOrDir(new File(com.baidu.tieba.video.c.nKm));
    }

    private void j(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    private a() {
        this.nAC = false;
        this.nAD = null;
        this.nAB = new NewWriteModel();
        this.nAB.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0873a {
        private static final a nAH = new a();
    }
}
