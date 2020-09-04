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
/* loaded from: classes15.dex */
public class a extends e {
    public String jIK;
    public boolean jJx;
    public String jJy;
    public String postId;

    public a(EditorTools editorTools) {
        super(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.eMt.cLa() == null) {
            this.eMt.d(cLa());
        }
        if (this.eMt.cLa() != null) {
            this.eMt.setSpanGroupManager(this.mSpanGroupManager);
            this.eMt.cLa().setIsBJHPost(this.isBJH);
            this.eMt.cLa().setWriteImagesInfo(this.writeImagesInfo);
            this.eMt.wi(this.writeImagesInfo.size() > 0);
            WriteData cLa = this.eMt.cLa();
            if (this.eMs == null || !this.eMs.bXA()) {
                z = false;
            }
            cLa.setHasLocationData(z);
            if (str == null) {
                this.eMt.cLa().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.eMt.cLa().setVoice(this.mVoiceModel.getId());
                    this.eMt.cLa().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.eMt.cLa().setVoice(null);
                    this.eMt.cLa().setVoiceDuringTime(-1);
                }
            } else {
                this.eMt.cLa().setVoice(null);
                this.eMt.cLa().setVoiceDuringTime(-1);
            }
            if (!this.eMt.dya()) {
                this.efr.showToast(R.string.write_img_limit);
                return;
            }
            if ((this.eMB == null || !this.eMB.brV()) && !this.eMt.dxX()) {
            }
        }
    }

    public WriteData cLa() {
        WriteData writeData = new WriteData();
        if (this.eMw != null) {
            if (this.eMC && !this.jJx) {
                writeData.setCanNoForum(true);
                writeData.setVForumId(this.eMw.getId());
                writeData.setVForumName(this.eMw.getName());
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setCanNoForum(false);
                writeData.setVForumId("");
                writeData.setVForumName("");
                writeData.setForumId(this.eMw.getId());
                writeData.setForumName(this.eMw.getName());
            }
        }
        writeData.setThreadId(this.mThreadId);
        if (!this.jJx) {
            writeData.setType(1);
        } else {
            writeData.setType(2);
            writeData.setFloor(this.postId);
            writeData.setFloorNum(0);
            writeData.setReplyId(this.jJy);
            writeData.setRepostId(this.postId);
        }
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.jJx ? 1 : 0);
        pbEditorData.setContent(this.mPostContent);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.eMw != null) {
            threadData.setForumId(this.eMw.getId());
            threadData.setForumName(this.eMw.getName());
            threadData.setFirstDir(this.eMw.getFirst_class());
            threadData.setSecondDir(this.eMw.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.eMx);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.efr.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void BZ(String str) {
        if (this.jJx) {
            x.b(this.postId, this);
        } else {
            x.a(str, this);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void BY(String str) {
        WriteData cLa = this.eMt.cLa();
        if (cLa == null) {
            WriteData writeData = new WriteData(this.jJx ? 2 : 1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
            cLa = writeData;
        }
        if (!at.isEmpty(this.jIK)) {
            cLa.setFromForumId(this.jIK);
        }
        cLa.setContent(this.mPostContent);
        cLa.setVoiceModel(this.mVoiceModel);
        if (this.jJx) {
            cLa.setReplyId(this.jJy);
            cLa.setThreadId(this.postId);
            x.g(this.postId, cLa);
            return;
        }
        x.f(str, cLa);
    }
}
