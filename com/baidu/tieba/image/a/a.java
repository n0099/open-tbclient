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
    public String ksJ;
    public boolean ktu;
    public String ktv;
    public String postId;

    public a(EditorTools editorTools) {
        super(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.fjQ.cVv() == null) {
            this.fjQ.e(cVv());
        }
        if (this.fjQ.cVv() != null) {
            this.fjQ.setSpanGroupManager(this.mSpanGroupManager);
            this.fjQ.cVv().setIsBJHPost(this.isBJH);
            this.fjQ.cVv().setWriteImagesInfo(this.writeImagesInfo);
            this.fjQ.xp(this.writeImagesInfo.size() > 0);
            WriteData cVv = this.fjQ.cVv();
            if (this.fjP == null || !this.fjP.cfL()) {
                z = false;
            }
            cVv.setHasLocationData(z);
            if (str == null) {
                this.fjQ.cVv().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fjQ.cVv().setVoice(this.mVoiceModel.getId());
                    this.fjQ.cVv().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fjQ.cVv().setVoice(null);
                    this.fjQ.cVv().setVoiceDuringTime(-1);
                }
            } else {
                this.fjQ.cVv().setVoice(null);
                this.fjQ.cVv().setVoiceDuringTime(-1);
            }
            if (!this.fjQ.dIN()) {
                this.eCn.showToast(R.string.write_img_limit);
                return;
            }
            if ((this.fjY == null || !this.fjY.bxC()) && !this.fjQ.dIK()) {
            }
        }
    }

    public WriteData cVv() {
        WriteData writeData = new WriteData();
        if (this.fjT != null) {
            if (this.fjZ && !this.ktu) {
                writeData.setCanNoForum(true);
                writeData.setVForumId(this.fjT.getId());
                writeData.setVForumName(this.fjT.getName());
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setCanNoForum(false);
                writeData.setVForumId("");
                writeData.setVForumName("");
                writeData.setForumId(this.fjT.getId());
                writeData.setForumName(this.fjT.getName());
            }
        }
        writeData.setThreadId(this.mThreadId);
        if (!this.ktu) {
            writeData.setType(1);
        } else {
            writeData.setType(2);
            writeData.setFloor(this.postId);
            writeData.setFloorNum(0);
            writeData.setReplyId(this.ktv);
            writeData.setRepostId(this.postId);
        }
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.ktu ? 1 : 0);
        pbEditorData.setContent(this.mPostContent);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.fjT != null) {
            threadData.setForumId(this.fjT.getId());
            threadData.setForumName(this.fjT.getName());
            threadData.setFirstDir(this.fjT.getFirst_class());
            threadData.setSecondDir(this.fjT.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.fjU);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eCn.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void DA(String str) {
        if (this.ktu) {
            x.b(this.postId, this);
        } else {
            x.a(str, this);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void Dz(String str) {
        WriteData cVv = this.fjQ.cVv();
        if (cVv == null) {
            WriteData writeData = new WriteData(this.ktu ? 2 : 1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
            cVv = writeData;
        }
        if (!at.isEmpty(this.ksJ)) {
            cVv.setFromForumId(this.ksJ);
        }
        cVv.setContent(this.mPostContent);
        cVv.setVoiceModel(this.mVoiceModel);
        if (this.ktu) {
            cVv.setReplyId(this.ktv);
            cVv.setThreadId(this.postId);
            x.g(this.postId, cVv);
            return;
        }
        x.f(str, cVv);
    }
}
