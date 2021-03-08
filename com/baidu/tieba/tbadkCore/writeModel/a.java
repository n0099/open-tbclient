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
    private final NewWriteModel nDg;
    private boolean nDh;
    private BdUniqueId nDi;
    private String nDj;
    private String nDk;
    private String nDl;

    public static a dPl() {
        b.d("AsyncWriteHelper.getInstance()");
        return C0881a.nDm;
    }

    public boolean isAsyncWriting() {
        return this.nDh;
    }

    public void a(@NonNull TbPageContextSupport tbPageContextSupport) {
        b.d("AsyncWriteHelper.initWriteStatus()");
        this.nDg.h(tbPageContextSupport.getPageContext());
        this.nDg.f((WriteData) null);
        this.nDg.yD(false);
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        b.d("AsyncWriteHelper.setSpanGroupManager()");
        this.nDg.dPD();
        this.nDg.setSpanGroupManager(spanGroupManager);
    }

    public boolean dPm() {
        b.d("AsyncWriteHelper.startPostWrite()");
        this.nDg.dPD();
        this.nDh = this.nDg.dPA();
        return this.nDh;
    }

    public void dPn() {
        b.d("AsyncWriteHelper.onWriteActClose()");
        this.nDg.h((com.baidu.adp.base.f<?>) null);
        this.nDg.setSpanGroupManager(null);
    }

    public void cFK() {
        b.d("AsyncWriteHelper.cancelLoadData()");
        this.nDg.cancelLoadData();
    }

    public void yD(boolean z) {
        b.d("AsyncWriteHelper.setHasImage = " + z);
        this.nDg.yD(z);
    }

    public void f(WriteData writeData) {
        b.d("AsyncWriteHelper.setWriteData = " + (writeData == null ? "null" : writeData.toDraftString()));
        this.nDg.f(writeData);
    }

    public WriteData daL() {
        b.d("AsyncWriteHelper.getWriteData = " + (this.nDg.daL() == null ? "null" : this.nDg.daL().toDraftString()));
        return this.nDg.daL();
    }

    public boolean dPo() {
        b.d("AsyncWriteHelper.checkImageNum = " + this.nDg.dPo());
        return this.nDg.dPo();
    }

    public String dPp() {
        return this.nDj;
    }

    public void TY(String str) {
        this.nDj = str;
    }

    public String dPq() {
        return this.nDk;
    }

    public void TZ(String str) {
        this.nDk = str;
    }

    public String dPr() {
        return this.nDl;
    }

    public void Ua(String str) {
        this.nDl = str;
    }

    public BdUniqueId dPs() {
        return this.nDi;
    }

    public void F(BdUniqueId bdUniqueId) {
        this.nDi = bdUniqueId;
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
                cHb();
                dPt();
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
            this.nDh = false;
        }
    }

    private void cHb() {
        WriteData daL = daL();
        if (daL != null) {
            if (daL.getType() == 0 || daL.getType() == 9 || daL.getType() == 11) {
                if (daL.isEvaluate()) {
                    y.d(daL.getItem_id(), (WriteData) null);
                } else if (TextUtils.isEmpty(daL.getTopicId())) {
                    y.a(daL.getForumId(), daL, true);
                } else {
                    y.e(daL.getTopicId(), (WriteData) null);
                }
            } else if (daL.getType() == 1) {
                y.b(daL.getThreadId(), (WriteData) null);
            }
        }
    }

    private void dPt() {
        o.deleteFileOrDir(new File(com.baidu.tieba.video.c.nMR));
    }

    private void j(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    private a() {
        this.nDh = false;
        this.nDi = null;
        this.nDg = new NewWriteModel();
        this.nDg.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.tbadkCore.writeModel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0881a {
        private static final a nDm = new a();
    }
}
