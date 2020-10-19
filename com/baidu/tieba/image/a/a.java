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
/* loaded from: classes21.dex */
public class a extends e {
    public boolean kgW;
    public String kgX;
    public String kgl;
    public String postId;

    public a(EditorTools editorTools) {
        super(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.fbr.cSo() == null) {
            this.fbr.e(cSo());
        }
        if (this.fbr.cSo() != null) {
            this.fbr.setSpanGroupManager(this.mSpanGroupManager);
            this.fbr.cSo().setIsBJHPost(this.isBJH);
            this.fbr.cSo().setWriteImagesInfo(this.writeImagesInfo);
            this.fbr.wY(this.writeImagesInfo.size() > 0);
            WriteData cSo = this.fbr.cSo();
            if (this.fbq == null || !this.fbq.ccF()) {
                z = false;
            }
            cSo.setHasLocationData(z);
            if (str == null) {
                this.fbr.cSo().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fbr.cSo().setVoice(this.mVoiceModel.getId());
                    this.fbr.cSo().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fbr.cSo().setVoice(null);
                    this.fbr.cSo().setVoiceDuringTime(-1);
                }
            } else {
                this.fbr.cSo().setVoice(null);
                this.fbr.cSo().setVoiceDuringTime(-1);
            }
            if (!this.fbr.dFF()) {
                this.etO.showToast(R.string.write_img_limit);
                return;
            }
            if ((this.fbz == null || !this.fbz.bvJ()) && !this.fbr.dFC()) {
            }
        }
    }

    public WriteData cSo() {
        WriteData writeData = new WriteData();
        if (this.fbu != null) {
            if (this.fbA && !this.kgW) {
                writeData.setCanNoForum(true);
                writeData.setVForumId(this.fbu.getId());
                writeData.setVForumName(this.fbu.getName());
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setCanNoForum(false);
                writeData.setVForumId("");
                writeData.setVForumName("");
                writeData.setForumId(this.fbu.getId());
                writeData.setForumName(this.fbu.getName());
            }
        }
        writeData.setThreadId(this.mThreadId);
        if (!this.kgW) {
            writeData.setType(1);
        } else {
            writeData.setType(2);
            writeData.setFloor(this.postId);
            writeData.setFloorNum(0);
            writeData.setReplyId(this.kgX);
            writeData.setRepostId(this.postId);
        }
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.kgW ? 1 : 0);
        pbEditorData.setContent(this.mPostContent);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.fbu != null) {
            threadData.setForumId(this.fbu.getId());
            threadData.setForumName(this.fbu.getName());
            threadData.setFirstDir(this.fbu.getFirst_class());
            threadData.setSecondDir(this.fbu.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.fbv);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.etO.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void Dh(String str) {
        if (this.kgW) {
            x.b(this.postId, this);
        } else {
            x.a(str, this);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void Dg(String str) {
        WriteData cSo = this.fbr.cSo();
        if (cSo == null) {
            WriteData writeData = new WriteData(this.kgW ? 2 : 1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
            cSo = writeData;
        }
        if (!at.isEmpty(this.kgl)) {
            cSo.setFromForumId(this.kgl);
        }
        cSo.setContent(this.mPostContent);
        cSo.setVoiceModel(this.mVoiceModel);
        if (this.kgW) {
            cSo.setReplyId(this.kgX);
            cSo.setThreadId(this.postId);
            x.g(this.postId, cSo);
            return;
        }
        x.f(str, cSo);
    }
}
