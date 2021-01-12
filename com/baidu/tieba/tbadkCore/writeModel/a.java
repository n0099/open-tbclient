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
    private final NewWriteModel nqR;
    private boolean nqS;
    private BdUniqueId nqT;
    private String nqU;
    private String nqV;
    private String nqW;

    public static a dMJ() {
        b.d("AsyncWriteHelper.getInstance()");
        return C0870a.nqX;
    }

    public boolean isAsyncWriting() {
        return this.nqS;
    }

    public void a(@NonNull TbPageContextSupport tbPageContextSupport) {
        b.d("AsyncWriteHelper.initWriteStatus()");
        this.nqR.h(tbPageContextSupport.getPageContext());
        this.nqR.f((WriteData) null);
        this.nqR.yl(false);
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        b.d("AsyncWriteHelper.setSpanGroupManager()");
        this.nqR.dNb();
        this.nqR.setSpanGroupManager(spanGroupManager);
    }

    public boolean dMK() {
        b.d("AsyncWriteHelper.startPostWrite()");
        this.nqR.dNb();
        this.nqS = this.nqR.dMY();
        return this.nqS;
    }

    public void dML() {
        b.d("AsyncWriteHelper.onWriteActClose()");
        this.nqR.h((com.baidu.adp.base.f<?>) null);
        this.nqR.setSpanGroupManager(null);
    }

    public void cEk() {
        b.d("AsyncWriteHelper.cancelLoadData()");
        this.nqR.cancelLoadData();
    }

    public void yl(boolean z) {
        b.d("AsyncWriteHelper.setHasImage = " + z);
        this.nqR.yl(z);
    }

    public void f(WriteData writeData) {
        b.d("AsyncWriteHelper.setWriteData = " + (writeData == null ? "null" : writeData.toDraftString()));
        this.nqR.f(writeData);
    }

    public WriteData cYx() {
        b.d("AsyncWriteHelper.getWriteData = " + (this.nqR.cYx() == null ? "null" : this.nqR.cYx().toDraftString()));
        return this.nqR.cYx();
    }

    public boolean dMM() {
        b.d("AsyncWriteHelper.checkImageNum = " + this.nqR.dMM());
        return this.nqR.dMM();
    }

    public String dMN() {
        return this.nqU;
    }

    public void SH(String str) {
        this.nqU = str;
    }

    public String dMO() {
        return this.nqV;
    }

    public void SI(String str) {
        this.nqV = str;
    }

    public String dMP() {
        return this.nqW;
    }

    public void SJ(String str) {
        this.nqW = str;
    }

    public BdUniqueId dMQ() {
        return this.nqT;
    }

    public void D(BdUniqueId bdUniqueId) {
        this.nqT = bdUniqueId;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
        if (writeData != null) {
            if (z) {
                bg.a(writeData, 100).js(true);
                if ((!at.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) || (writeData.getVideoInfo() != null && writeData.getVideoInfo().hasUpload())) {
                    c.k(postWriteCallBackData);
                } else {
                    c.b(postWriteCallBackData);
                }
                cFB();
                dMR();
                j(postWriteCallBackData);
                if (!at.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                    postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                    if (!at.isEmpty(writeData.getForumName())) {
                        postWriteCallBackData.mFrom = 2;
                    }
                }
                bg.a(writeData, 100).js(false);
            } else {
                bg.a(writeData, 100).js(false);
                c.a(postWriteCallBackData, ahVar, writeData, antiData);
            }
            this.nqS = false;
        }
    }

    private void cFB() {
        WriteData cYx = cYx();
        if (cYx != null) {
            if (cYx.getType() == 0 || cYx.getType() == 9 || cYx.getType() == 11) {
                if (cYx.isEvaluate()) {
                    y.d(cYx.getItem_id(), (WriteData) null);
                } else if (TextUtils.isEmpty(cYx.getTopicId())) {
                    y.c(cYx.getForumId(), (WriteData) null);
                } else {
                    y.e(cYx.getTopicId(), (WriteData) null);
                }
            } else if (cYx.getType() == 1) {
                y.b(cYx.getThreadId(), (WriteData) null);
            }
        }
    }

    private void dMR() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nAB));
    }

    private void j(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    private a() {
        this.nqS = false;
        this.nqT = null;
        this.nqR = new NewWriteModel();
        this.nqR.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0870a {
        private static final a nqX = new a();
    }
}
