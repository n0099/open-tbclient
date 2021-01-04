package com.baidu.tieba.tbadkCore.writeModel;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.y;
import java.io.File;
/* loaded from: classes.dex */
public class a implements NewWriteModel.d {
    private BdUniqueId nvA;
    private String nvB;
    private String nvC;
    private String nvD;
    private final NewWriteModel nvy;
    private boolean nvz;

    public static a dQA() {
        b.d("AsyncWriteHelper.getInstance()");
        return C0854a.nvE;
    }

    public boolean isAsyncWriting() {
        return this.nvz;
    }

    public void a(@NonNull TbPageContextSupport tbPageContextSupport) {
        b.d("AsyncWriteHelper.initWriteStatus()");
        this.nvy.h(tbPageContextSupport.getPageContext());
        this.nvy.f((WriteData) null);
        this.nvy.yp(false);
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        b.d("AsyncWriteHelper.setSpanGroupManager()");
        this.nvy.dQS();
        this.nvy.setSpanGroupManager(spanGroupManager);
    }

    public boolean dQB() {
        b.d("AsyncWriteHelper.startPostWrite()");
        this.nvy.dQS();
        this.nvz = this.nvy.dQP();
        return this.nvz;
    }

    public void dQC() {
        b.d("AsyncWriteHelper.onWriteActClose()");
        this.nvy.h((com.baidu.adp.base.f<?>) null);
        this.nvy.setSpanGroupManager(null);
    }

    public void cIb() {
        b.d("AsyncWriteHelper.cancelLoadData()");
        this.nvy.cancelLoadData();
    }

    public void yp(boolean z) {
        b.d("AsyncWriteHelper.setHasImage = " + z);
        this.nvy.yp(z);
    }

    public void f(WriteData writeData) {
        b.d("AsyncWriteHelper.setWriteData = " + (writeData == null ? "null" : writeData.toDraftString()));
        this.nvy.f(writeData);
    }

    public WriteData dco() {
        b.d("AsyncWriteHelper.getWriteData = " + (this.nvy.dco() == null ? "null" : this.nvy.dco().toDraftString()));
        return this.nvy.dco();
    }

    public boolean dQD() {
        b.d("AsyncWriteHelper.checkImageNum = " + this.nvy.dQD());
        return this.nvy.dQD();
    }

    public String dQE() {
        return this.nvB;
    }

    public void TQ(String str) {
        this.nvB = str;
    }

    public String dQF() {
        return this.nvC;
    }

    public void TR(String str) {
        this.nvC = str;
    }

    public String dQG() {
        return this.nvD;
    }

    public void TS(String str) {
        this.nvD = str;
    }

    public BdUniqueId dQH() {
        return this.nvA;
    }

    public void D(BdUniqueId bdUniqueId) {
        this.nvA = bdUniqueId;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
        if (writeData != null) {
            if (z) {
                bg.a(writeData, 100).jw(true);
                if ((!at.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) || (writeData.getVideoInfo() != null && writeData.getVideoInfo().hasUpload())) {
                    c.k(postWriteCallBackData);
                } else {
                    c.b(postWriteCallBackData);
                }
                cJs();
                dQI();
                j(postWriteCallBackData);
                if (!at.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                    postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                    if (!at.isEmpty(writeData.getForumName())) {
                        postWriteCallBackData.mFrom = 2;
                    }
                }
                bg.a(writeData, 100).jw(false);
            } else {
                bg.a(writeData, 100).jw(false);
                c.a(postWriteCallBackData, ahVar, writeData, antiData);
            }
            this.nvz = false;
        }
    }

    private void cJs() {
        WriteData dco = dco();
        if (dco != null) {
            if (dco.getType() == 0 || dco.getType() == 9 || dco.getType() == 11) {
                if (dco.isEvaluate()) {
                    y.d(dco.getItem_id(), (WriteData) null);
                } else if (TextUtils.isEmpty(dco.getTopicId())) {
                    y.c(dco.getForumId(), (WriteData) null);
                } else {
                    y.e(dco.getTopicId(), (WriteData) null);
                }
            } else if (dco.getType() == 1) {
                y.b(dco.getThreadId(), (WriteData) null);
            }
        }
    }

    private void dQI() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nFh));
    }

    private void j(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    private a() {
        this.nvz = false;
        this.nvA = null;
        this.nvy = new NewWriteModel();
        this.nvy.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0854a {
        private static final a nvE = new a();
    }
}
