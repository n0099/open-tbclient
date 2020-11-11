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
    public String kyF;
    public boolean kzq;
    public String kzr;
    public String postId;

    public a(EditorTools editorTools) {
        super(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.fpI.cXW() == null) {
            this.fpI.e(cXW());
        }
        if (this.fpI.cXW() != null) {
            this.fpI.setSpanGroupManager(this.mSpanGroupManager);
            this.fpI.cXW().setIsBJHPost(this.isBJH);
            this.fpI.cXW().setWriteImagesInfo(this.writeImagesInfo);
            this.fpI.xy(this.writeImagesInfo.size() > 0);
            WriteData cXW = this.fpI.cXW();
            if (this.fpH == null || !this.fpH.cin()) {
                z = false;
            }
            cXW.setHasLocationData(z);
            if (str == null) {
                this.fpI.cXW().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fpI.cXW().setVoice(this.mVoiceModel.getId());
                    this.fpI.cXW().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fpI.cXW().setVoice(null);
                    this.fpI.cXW().setVoiceDuringTime(-1);
                }
            } else {
                this.fpI.cXW().setVoice(null);
                this.fpI.cXW().setVoiceDuringTime(-1);
            }
            if (!this.fpI.dLp()) {
                this.eIc.showToast(R.string.write_img_limit);
                return;
            }
            if ((this.fpQ == null || !this.fpQ.bAb()) && !this.fpI.dLm()) {
            }
        }
    }

    public WriteData cXW() {
        WriteData writeData = new WriteData();
        if (this.fpL != null) {
            if (this.fpR && !this.kzq) {
                writeData.setCanNoForum(true);
                writeData.setVForumId(this.fpL.getId());
                writeData.setVForumName(this.fpL.getName());
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setCanNoForum(false);
                writeData.setVForumId("");
                writeData.setVForumName("");
                writeData.setForumId(this.fpL.getId());
                writeData.setForumName(this.fpL.getName());
            }
        }
        writeData.setThreadId(this.mThreadId);
        if (!this.kzq) {
            writeData.setType(1);
        } else {
            writeData.setType(2);
            writeData.setFloor(this.postId);
            writeData.setFloorNum(0);
            writeData.setReplyId(this.kzr);
            writeData.setRepostId(this.postId);
        }
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.kzq ? 1 : 0);
        pbEditorData.setContent(this.mPostContent);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.fpL != null) {
            threadData.setForumId(this.fpL.getId());
            threadData.setForumName(this.fpL.getName());
            threadData.setFirstDir(this.fpL.getFirst_class());
            threadData.setSecondDir(this.fpL.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.fpM);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eIc.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void DO(String str) {
        if (this.kzq) {
            x.b(this.postId, this);
        } else {
            x.a(str, this);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void DN(String str) {
        WriteData cXW = this.fpI.cXW();
        if (cXW == null) {
            WriteData writeData = new WriteData(this.kzq ? 2 : 1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
            cXW = writeData;
        }
        if (!at.isEmpty(this.kyF)) {
            cXW.setFromForumId(this.kyF);
        }
        cXW.setContent(this.mPostContent);
        cXW.setVoiceModel(this.mVoiceModel);
        if (this.kzq) {
            cXW.setReplyId(this.kzr);
            cXW.setThreadId(this.postId);
            x.g(this.postId, cXW);
            return;
        }
        x.f(str, cXW);
    }
}
