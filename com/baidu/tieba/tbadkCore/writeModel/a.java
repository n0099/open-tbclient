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
    private final NewWriteModel nBb;
    private boolean nBc;
    private BdUniqueId nBd;
    private String nBe;
    private String nBf;
    private String nBg;

    public static a dPc() {
        b.d("AsyncWriteHelper.getInstance()");
        return C0875a.nBh;
    }

    public boolean isAsyncWriting() {
        return this.nBc;
    }

    public void a(@NonNull TbPageContextSupport tbPageContextSupport) {
        b.d("AsyncWriteHelper.initWriteStatus()");
        this.nBb.h(tbPageContextSupport.getPageContext());
        this.nBb.f((WriteData) null);
        this.nBb.yE(false);
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        b.d("AsyncWriteHelper.setSpanGroupManager()");
        this.nBb.dPu();
        this.nBb.setSpanGroupManager(spanGroupManager);
    }

    public boolean dPd() {
        b.d("AsyncWriteHelper.startPostWrite()");
        this.nBb.dPu();
        this.nBc = this.nBb.dPr();
        return this.nBc;
    }

    public void dPe() {
        b.d("AsyncWriteHelper.onWriteActClose()");
        this.nBb.h((com.baidu.adp.base.f<?>) null);
        this.nBb.setSpanGroupManager(null);
    }

    public void cFE() {
        b.d("AsyncWriteHelper.cancelLoadData()");
        this.nBb.cancelLoadData();
    }

    public void yE(boolean z) {
        b.d("AsyncWriteHelper.setHasImage = " + z);
        this.nBb.yE(z);
    }

    public void f(WriteData writeData) {
        b.d("AsyncWriteHelper.setWriteData = " + (writeData == null ? "null" : writeData.toDraftString()));
        this.nBb.f(writeData);
    }

    public WriteData daC() {
        b.d("AsyncWriteHelper.getWriteData = " + (this.nBb.daC() == null ? "null" : this.nBb.daC().toDraftString()));
        return this.nBb.daC();
    }

    public boolean dPf() {
        b.d("AsyncWriteHelper.checkImageNum = " + this.nBb.dPf());
        return this.nBb.dPf();
    }

    public String dPg() {
        return this.nBe;
    }

    public void TR(String str) {
        this.nBe = str;
    }

    public String dPh() {
        return this.nBf;
    }

    public void TS(String str) {
        this.nBf = str;
    }

    public String dPi() {
        return this.nBg;
    }

    public void TT(String str) {
        this.nBg = str;
    }

    public BdUniqueId dPj() {
        return this.nBd;
    }

    public void E(BdUniqueId bdUniqueId) {
        this.nBd = bdUniqueId;
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
                cGV();
                dPk();
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
            this.nBc = false;
        }
    }

    private void cGV() {
        WriteData daC = daC();
        if (daC != null) {
            if (daC.getType() == 0 || daC.getType() == 9 || daC.getType() == 11) {
                if (daC.isEvaluate()) {
                    y.d(daC.getItem_id(), (WriteData) null);
                } else if (TextUtils.isEmpty(daC.getTopicId())) {
                    y.a(daC.getForumId(), daC, true);
                } else {
                    y.e(daC.getTopicId(), (WriteData) null);
                }
            } else if (daC.getType() == 1) {
                y.b(daC.getThreadId(), (WriteData) null);
            }
        }
    }

    private void dPk() {
        o.deleteFileOrDir(new File(com.baidu.tieba.video.c.nKM));
    }

    private void j(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    private a() {
        this.nBc = false;
        this.nBd = null;
        this.nBb = new NewWriteModel();
        this.nBb.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0875a {
        private static final a nBh = new a();
    }
}
