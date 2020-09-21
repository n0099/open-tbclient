package com.baidu.tieba.image.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes20.dex */
public class a extends e {
    public boolean jRX;
    public String jRY;
    public String jRm;
    public String postId;

    public a(EditorTools editorTools) {
        super(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.ePk.cOG() == null) {
            this.ePk.e(cOG());
        }
        if (this.ePk.cOG() != null) {
            this.ePk.setSpanGroupManager(this.mSpanGroupManager);
            this.ePk.cOG().setIsBJHPost(this.isBJH);
            this.ePk.cOG().setWriteImagesInfo(this.writeImagesInfo);
            this.ePk.wr(this.writeImagesInfo.size() > 0);
            WriteData cOG = this.ePk.cOG();
            if (this.ePj == null || !this.ePj.bZh()) {
                z = false;
            }
            cOG.setHasLocationData(z);
            if (str == null) {
                this.ePk.cOG().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.ePk.cOG().setVoice(this.mVoiceModel.getId());
                    this.ePk.cOG().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.ePk.cOG().setVoice(null);
                    this.ePk.cOG().setVoiceDuringTime(-1);
                }
            } else {
                this.ePk.cOG().setVoice(null);
                this.ePk.cOG().setVoiceDuringTime(-1);
            }
            if (!this.ePk.dBT()) {
                this.ehG.showToast(R.string.write_img_limit);
                return;
            }
            if ((this.ePs == null || !this.ePs.bsZ()) && !this.ePk.dBQ()) {
            }
        }
    }

    public WriteData cOG() {
        WriteData writeData = new WriteData();
        if (this.ePn != null) {
            if (this.ePt && !this.jRX) {
                writeData.setCanNoForum(true);
                writeData.setVForumId(this.ePn.getId());
                writeData.setVForumName(this.ePn.getName());
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setCanNoForum(false);
                writeData.setVForumId("");
                writeData.setVForumName("");
                writeData.setForumId(this.ePn.getId());
                writeData.setForumName(this.ePn.getName());
            }
        }
        writeData.setThreadId(this.mThreadId);
        if (!this.jRX) {
            writeData.setType(1);
        } else {
            writeData.setType(2);
            writeData.setFloor(this.postId);
            writeData.setFloorNum(0);
            writeData.setReplyId(this.jRY);
            writeData.setRepostId(this.postId);
        }
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.jRX ? 1 : 0);
        pbEditorData.setContent(this.mPostContent);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.ePn != null) {
            threadData.setForumId(this.ePn.getId());
            threadData.setForumName(this.ePn.getName());
            threadData.setFirstDir(this.ePn.getFirst_class());
            threadData.setSecondDir(this.ePn.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.ePo);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.ehG.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void Cv(String str) {
        if (this.jRX) {
            x.b(this.postId, this);
        } else {
            x.a(str, this);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void Cu(String str) {
        WriteData cOG = this.ePk.cOG();
        if (cOG == null) {
            WriteData writeData = new WriteData(this.jRX ? 2 : 1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
            cOG = writeData;
        }
        if (!at.isEmpty(this.jRm)) {
            cOG.setFromForumId(this.jRm);
        }
        cOG.setContent(this.mPostContent);
        cOG.setVoiceModel(this.mVoiceModel);
        if (this.jRX) {
            cOG.setReplyId(this.jRY);
            cOG.setThreadId(this.postId);
            x.g(this.postId, cOG);
            return;
        }
        x.f(str, cOG);
    }
}
