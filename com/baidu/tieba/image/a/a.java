package com.baidu.tieba.image.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes21.dex */
public class a extends e {
    public boolean kMX;
    public String kMY;
    public String kMm;
    public String postId;

    public a(EditorTools editorTools) {
        super(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.fwu.dcD() == null) {
            this.fwu.e(dcD());
        }
        if (this.fwu.dcD() != null) {
            this.fwu.setSpanGroupManager(this.mSpanGroupManager);
            this.fwu.dcD().setIsBJHPost(this.isBJH);
            this.fwu.dcD().setWriteImagesInfo(this.writeImagesInfo);
            this.fwu.yk(this.writeImagesInfo.size() > 0);
            WriteData dcD = this.fwu.dcD();
            if (this.fwt == null || !this.fwt.clB()) {
                z = false;
            }
            dcD.setHasLocationData(z);
            if (str == null) {
                this.fwu.dcD().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fwu.dcD().setVoice(this.mVoiceModel.getId());
                    this.fwu.dcD().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fwu.dcD().setVoice(null);
                    this.fwu.dcD().setVoiceDuringTime(-1);
                }
            } else {
                this.fwu.dcD().setVoice(null);
                this.fwu.dcD().setVoiceDuringTime(-1);
            }
            if (!this.fwu.dQG()) {
                this.eNx.showToast(R.string.write_img_limit);
                return;
            }
            if ((this.fwC == null || !this.fwC.bCR()) && !this.fwu.dQD()) {
            }
        }
    }

    public WriteData dcD() {
        WriteData writeData = new WriteData();
        if (this.fwx != null) {
            if (this.fwD && !this.kMX) {
                writeData.setCanNoForum(true);
                writeData.setVForumId(this.fwx.getId());
                writeData.setVForumName(this.fwx.getName());
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setCanNoForum(false);
                writeData.setVForumId("");
                writeData.setVForumName("");
                writeData.setForumId(this.fwx.getId());
                writeData.setForumName(this.fwx.getName());
            }
        }
        writeData.setThreadId(this.mThreadId);
        if (!this.kMX) {
            writeData.setType(1);
        } else {
            writeData.setType(2);
            writeData.setFloor(this.postId);
            writeData.setFloorNum(0);
            writeData.setReplyId(this.kMY);
            writeData.setRepostId(this.postId);
        }
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.kMX ? 1 : 0);
        pbEditorData.setContent(this.mPostContent);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.fwx != null) {
            threadData.setForumId(this.fwx.getId());
            threadData.setForumName(this.fwx.getName());
            threadData.setFirstDir(this.fwx.getFirst_class());
            threadData.setSecondDir(this.fwx.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.fwy);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eNx.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void DV(String str) {
        if (this.kMX) {
            y.b(this.postId, this);
        } else {
            y.a(str, this);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void DU(String str) {
        WriteData dcD = this.fwu.dcD();
        if (dcD == null) {
            WriteData writeData = new WriteData(this.kMX ? 2 : 1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
            dcD = writeData;
        }
        if (!au.isEmpty(this.kMm)) {
            dcD.setFromForumId(this.kMm);
        }
        dcD.setContent(this.mPostContent);
        dcD.setVoiceModel(this.mVoiceModel);
        if (this.kMX) {
            dcD.setReplyId(this.kMY);
            dcD.setThreadId(this.postId);
            y.g(this.postId, dcD);
            return;
        }
        y.f(str, dcD);
    }
}
