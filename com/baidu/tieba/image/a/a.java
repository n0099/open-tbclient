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
    public boolean kMZ;
    public String kMo;
    public String kNa;
    public String postId;

    public a(EditorTools editorTools) {
        super(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.fwu.dcE() == null) {
            this.fwu.e(dcE());
        }
        if (this.fwu.dcE() != null) {
            this.fwu.setSpanGroupManager(this.mSpanGroupManager);
            this.fwu.dcE().setIsBJHPost(this.isBJH);
            this.fwu.dcE().setWriteImagesInfo(this.writeImagesInfo);
            this.fwu.yk(this.writeImagesInfo.size() > 0);
            WriteData dcE = this.fwu.dcE();
            if (this.fwt == null || !this.fwt.clC()) {
                z = false;
            }
            dcE.setHasLocationData(z);
            if (str == null) {
                this.fwu.dcE().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fwu.dcE().setVoice(this.mVoiceModel.getId());
                    this.fwu.dcE().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fwu.dcE().setVoice(null);
                    this.fwu.dcE().setVoiceDuringTime(-1);
                }
            } else {
                this.fwu.dcE().setVoice(null);
                this.fwu.dcE().setVoiceDuringTime(-1);
            }
            if (!this.fwu.dQH()) {
                this.eNx.showToast(R.string.write_img_limit);
                return;
            }
            if ((this.fwC == null || !this.fwC.bCR()) && !this.fwu.dQE()) {
            }
        }
    }

    public WriteData dcE() {
        WriteData writeData = new WriteData();
        if (this.fwx != null) {
            if (this.fwD && !this.kMZ) {
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
        if (!this.kMZ) {
            writeData.setType(1);
        } else {
            writeData.setType(2);
            writeData.setFloor(this.postId);
            writeData.setFloorNum(0);
            writeData.setReplyId(this.kNa);
            writeData.setRepostId(this.postId);
        }
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.kMZ ? 1 : 0);
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
        if (this.kMZ) {
            y.b(this.postId, this);
        } else {
            y.a(str, this);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void DU(String str) {
        WriteData dcE = this.fwu.dcE();
        if (dcE == null) {
            WriteData writeData = new WriteData(this.kMZ ? 2 : 1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
            dcE = writeData;
        }
        if (!au.isEmpty(this.kMo)) {
            dcE.setFromForumId(this.kMo);
        }
        dcE.setContent(this.mPostContent);
        dcE.setVoiceModel(this.mVoiceModel);
        if (this.kMZ) {
            dcE.setReplyId(this.kNa);
            dcE.setThreadId(this.postId);
            y.g(this.postId, dcE);
            return;
        }
        y.f(str, dcE);
    }
}
