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
    private String nvA;
    private String nvB;
    private String nvC;
    private final NewWriteModel nvx;
    private boolean nvy;
    private BdUniqueId nvz;

    public static a dQB() {
        b.d("AsyncWriteHelper.getInstance()");
        return C0887a.nvD;
    }

    public boolean isAsyncWriting() {
        return this.nvy;
    }

    public void a(@NonNull TbPageContextSupport tbPageContextSupport) {
        b.d("AsyncWriteHelper.initWriteStatus()");
        this.nvx.h(tbPageContextSupport.getPageContext());
        this.nvx.f((WriteData) null);
        this.nvx.yp(false);
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        b.d("AsyncWriteHelper.setSpanGroupManager()");
        this.nvx.dQT();
        this.nvx.setSpanGroupManager(spanGroupManager);
    }

    public boolean dQC() {
        b.d("AsyncWriteHelper.startPostWrite()");
        this.nvx.dQT();
        this.nvy = this.nvx.dQQ();
        return this.nvy;
    }

    public void dQD() {
        b.d("AsyncWriteHelper.onWriteActClose()");
        this.nvx.h((com.baidu.adp.base.f<?>) null);
        this.nvx.setSpanGroupManager(null);
    }

    public void cIc() {
        b.d("AsyncWriteHelper.cancelLoadData()");
        this.nvx.cancelLoadData();
    }

    public void yp(boolean z) {
        b.d("AsyncWriteHelper.setHasImage = " + z);
        this.nvx.yp(z);
    }

    public void f(WriteData writeData) {
        b.d("AsyncWriteHelper.setWriteData = " + (writeData == null ? "null" : writeData.toDraftString()));
        this.nvx.f(writeData);
    }

    public WriteData dcp() {
        b.d("AsyncWriteHelper.getWriteData = " + (this.nvx.dcp() == null ? "null" : this.nvx.dcp().toDraftString()));
        return this.nvx.dcp();
    }

    public boolean dQE() {
        b.d("AsyncWriteHelper.checkImageNum = " + this.nvx.dQE());
        return this.nvx.dQE();
    }

    public String dQF() {
        return this.nvA;
    }

    public void TP(String str) {
        this.nvA = str;
    }

    public String dQG() {
        return this.nvB;
    }

    public void TQ(String str) {
        this.nvB = str;
    }

    public String dQH() {
        return this.nvC;
    }

    public void TR(String str) {
        this.nvC = str;
    }

    public BdUniqueId dQI() {
        return this.nvz;
    }

    public void D(BdUniqueId bdUniqueId) {
        this.nvz = bdUniqueId;
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
                cJt();
                dQJ();
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
            this.nvy = false;
        }
    }

    private void cJt() {
        WriteData dcp = dcp();
        if (dcp != null) {
            if (dcp.getType() == 0 || dcp.getType() == 9 || dcp.getType() == 11) {
                if (dcp.isEvaluate()) {
                    y.d(dcp.getItem_id(), (WriteData) null);
                } else if (TextUtils.isEmpty(dcp.getTopicId())) {
                    y.c(dcp.getForumId(), (WriteData) null);
                } else {
                    y.e(dcp.getTopicId(), (WriteData) null);
                }
            } else if (dcp.getType() == 1) {
                y.b(dcp.getThreadId(), (WriteData) null);
            }
        }
    }

    private void dQJ() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nFg));
    }

    private void j(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    private a() {
        this.nvy = false;
        this.nvz = null;
        this.nvx = new NewWriteModel();
        this.nvx.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0887a {
        private static final a nvD = new a();
    }
}
