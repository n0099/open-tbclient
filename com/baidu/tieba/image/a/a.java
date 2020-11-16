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
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes20.dex */
public class a extends e {
    public String kyU;
    public boolean kzF;
    public String kzG;
    public String postId;

    public a(EditorTools editorTools) {
        super(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.foP.cXs() == null) {
            this.foP.e(cXs());
        }
        if (this.foP.cXs() != null) {
            this.foP.setSpanGroupManager(this.mSpanGroupManager);
            this.foP.cXs().setIsBJHPost(this.isBJH);
            this.foP.cXs().setWriteImagesInfo(this.writeImagesInfo);
            this.foP.xF(this.writeImagesInfo.size() > 0);
            WriteData cXs = this.foP.cXs();
            if (this.foO == null || !this.foO.chG()) {
                z = false;
            }
            cXs.setHasLocationData(z);
            if (str == null) {
                this.foP.cXs().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.foP.cXs().setVoice(this.mVoiceModel.getId());
                    this.foP.cXs().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.foP.cXs().setVoice(null);
                    this.foP.cXs().setVoiceDuringTime(-1);
                }
            } else {
                this.foP.cXs().setVoice(null);
                this.foP.cXs().setVoiceDuringTime(-1);
            }
            if (!this.foP.dLo()) {
                this.eGu.showToast(R.string.write_img_limit);
                return;
            }
            if ((this.foX == null || !this.foX.bzr()) && !this.foP.dLl()) {
            }
        }
    }

    public WriteData cXs() {
        WriteData writeData = new WriteData();
        if (this.foS != null) {
            if (this.foY && !this.kzF) {
                writeData.setCanNoForum(true);
                writeData.setVForumId(this.foS.getId());
                writeData.setVForumName(this.foS.getName());
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setCanNoForum(false);
                writeData.setVForumId("");
                writeData.setVForumName("");
                writeData.setForumId(this.foS.getId());
                writeData.setForumName(this.foS.getName());
            }
        }
        writeData.setThreadId(this.mThreadId);
        if (!this.kzF) {
            writeData.setType(1);
        } else {
            writeData.setType(2);
            writeData.setFloor(this.postId);
            writeData.setFloorNum(0);
            writeData.setReplyId(this.kzG);
            writeData.setRepostId(this.postId);
        }
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.kzF ? 1 : 0);
        pbEditorData.setContent(this.mPostContent);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.foS != null) {
            threadData.setForumId(this.foS.getId());
            threadData.setForumName(this.foS.getName());
            threadData.setFirstDir(this.foS.getFirst_class());
            threadData.setSecondDir(this.foS.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.foT);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eGu.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void Dn(String str) {
        if (this.kzF) {
            x.b(this.postId, this);
        } else {
            x.a(str, this);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void Dm(String str) {
        WriteData cXs = this.foP.cXs();
        if (cXs == null) {
            WriteData writeData = new WriteData(this.kzF ? 2 : 1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
            cXs = writeData;
        }
        if (!au.isEmpty(this.kyU)) {
            cXs.setFromForumId(this.kyU);
        }
        cXs.setContent(this.mPostContent);
        cXs.setVoiceModel(this.mVoiceModel);
        if (this.kzF) {
            cXs.setReplyId(this.kzG);
            cXs.setThreadId(this.postId);
            x.g(this.postId, cXs);
            return;
        }
        x.f(str, cXs);
    }
}
