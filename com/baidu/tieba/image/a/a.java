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
    public String jIE;
    public boolean jJr;
    public String jJs;
    public String postId;

    public a(EditorTools editorTools) {
        super(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.eMp.cKZ() == null) {
            this.eMp.d(cKZ());
        }
        if (this.eMp.cKZ() != null) {
            this.eMp.setSpanGroupManager(this.mSpanGroupManager);
            this.eMp.cKZ().setIsBJHPost(this.isBJH);
            this.eMp.cKZ().setWriteImagesInfo(this.writeImagesInfo);
            this.eMp.wg(this.writeImagesInfo.size() > 0);
            WriteData cKZ = this.eMp.cKZ();
            if (this.eMo == null || !this.eMo.bXz()) {
                z = false;
            }
            cKZ.setHasLocationData(z);
            if (str == null) {
                this.eMp.cKZ().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.eMp.cKZ().setVoice(this.mVoiceModel.getId());
                    this.eMp.cKZ().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.eMp.cKZ().setVoice(null);
                    this.eMp.cKZ().setVoiceDuringTime(-1);
                }
            } else {
                this.eMp.cKZ().setVoice(null);
                this.eMp.cKZ().setVoiceDuringTime(-1);
            }
            if (!this.eMp.dxV()) {
                this.efn.showToast(R.string.write_img_limit);
                return;
            }
            if ((this.eMx == null || !this.eMx.brU()) && !this.eMp.dxS()) {
            }
        }
    }

    public WriteData cKZ() {
        WriteData writeData = new WriteData();
        if (this.eMs != null) {
            if (this.eMy && !this.jJr) {
                writeData.setCanNoForum(true);
                writeData.setVForumId(this.eMs.getId());
                writeData.setVForumName(this.eMs.getName());
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setCanNoForum(false);
                writeData.setVForumId("");
                writeData.setVForumName("");
                writeData.setForumId(this.eMs.getId());
                writeData.setForumName(this.eMs.getName());
            }
        }
        writeData.setThreadId(this.mThreadId);
        if (!this.jJr) {
            writeData.setType(1);
        } else {
            writeData.setType(2);
            writeData.setFloor(this.postId);
            writeData.setFloorNum(0);
            writeData.setReplyId(this.jJs);
            writeData.setRepostId(this.postId);
        }
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.jJr ? 1 : 0);
        pbEditorData.setContent(this.mPostContent);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.eMs != null) {
            threadData.setForumId(this.eMs.getId());
            threadData.setForumName(this.eMs.getName());
            threadData.setFirstDir(this.eMs.getFirst_class());
            threadData.setSecondDir(this.eMs.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.eMt);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.efn.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void BY(String str) {
        if (this.jJr) {
            x.b(this.postId, this);
        } else {
            x.a(str, this);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void BX(String str) {
        WriteData cKZ = this.eMp.cKZ();
        if (cKZ == null) {
            WriteData writeData = new WriteData(this.jJr ? 2 : 1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
            cKZ = writeData;
        }
        if (!at.isEmpty(this.jIE)) {
            cKZ.setFromForumId(this.jIE);
        }
        cKZ.setContent(this.mPostContent);
        cKZ.setVoiceModel(this.mVoiceModel);
        if (this.jJr) {
            cKZ.setReplyId(this.jJs);
            cKZ.setThreadId(this.postId);
            x.g(this.postId, cKZ);
            return;
        }
        x.f(str, cKZ);
    }
}
