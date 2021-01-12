package com.baidu.tieba.image.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes7.dex */
public class a extends e {
    public boolean kNX;
    public String kNY;
    public String kNb;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    public String postId;

    public a(EditorTools editorTools) {
        super(editorTools);
        editorTools.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.image.a.a.1
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof u) {
                    if (((u) aVar.data).bwd() == EmotionGroupType.BIG_EMOTION || ((u) aVar.data).bwd() == EmotionGroupType.USER_COLLECT) {
                        if (a.this.mPermissionJudgePolicy == null) {
                            a.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        a.this.mPermissionJudgePolicy.appendRequestPermission(a.this.eSJ.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgePolicy.startRequestPermission(a.this.eSJ.getPageActivity())) {
                            a.this.c((u) aVar.data);
                            a.this.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(String str, WriteData writeData) {
        boolean z = true;
        if (this.fBs.cYx() == null) {
            this.fBs.f(cYx());
        }
        if (this.fBs.cYx() != null) {
            this.fBs.setSpanGroupManager(this.mSpanGroupManager);
            this.fBs.cYx().setIsBJHPost(this.isBJH);
            this.fBs.cYx().setWriteImagesInfo(this.writeImagesInfo);
            this.fBs.yl(this.writeImagesInfo.size() > 0);
            WriteData cYx = this.fBs.cYx();
            if (this.fBr == null || !this.fBr.ckC()) {
                z = false;
            }
            cYx.setHasLocationData(z);
            if (str == null) {
                this.fBs.cYx().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fBs.cYx().setVoice(this.mVoiceModel.getId());
                    this.fBs.cYx().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fBs.cYx().setVoice(null);
                    this.fBs.cYx().setVoiceDuringTime(-1);
                }
            } else {
                this.fBs.cYx().setVoice(null);
                this.fBs.cYx().setVoiceDuringTime(-1);
            }
            if (!this.fBs.dMM()) {
                this.eSJ.showToast(R.string.write_img_limit);
                return;
            }
            if ((this.fBA == null || !this.fBA.bBt()) && !this.fBs.dMK()) {
            }
        }
    }

    public WriteData cYx() {
        WriteData writeData = new WriteData();
        if (this.fBv != null) {
            if (this.fBB && !this.kNX) {
                writeData.setCanNoForum(true);
                writeData.setVForumId(this.fBv.getId());
                writeData.setVForumName(this.fBv.getName());
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setCanNoForum(false);
                writeData.setVForumId("");
                writeData.setVForumName("");
                writeData.setForumId(this.fBv.getId());
                writeData.setForumName(this.fBv.getName());
            }
        }
        writeData.setThreadId(this.mThreadId);
        if (!this.kNX) {
            writeData.setType(1);
        } else {
            writeData.setType(2);
            writeData.setFloor(this.postId);
            writeData.setFloorNum(0);
            writeData.setReplyId(this.kNY);
            writeData.setRepostId(this.postId);
        }
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.kNX ? 1 : 0);
        pbEditorData.setContent(this.mPostContent);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.fBv != null) {
            threadData.setForumId(this.fBv.getId());
            threadData.setForumName(this.fBv.getName());
            threadData.setFirstDir(this.fBv.getFirst_class());
            threadData.setSecondDir(this.fBv.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.fBw);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eSJ.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void CG(String str) {
        if (this.kNX) {
            y.e(this.postId, this);
        } else {
            y.a(str, this);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void CF(String str) {
        WriteData cYx = this.fBs.cYx();
        if (cYx == null) {
            WriteData writeData = new WriteData(this.kNX ? 2 : 1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
            cYx = writeData;
        }
        if (!at.isEmpty(this.kNb)) {
            cYx.setFromForumId(this.kNb);
        }
        cYx.setContent(this.mPostContent);
        cYx.setVoiceModel(this.mVoiceModel);
        if (this.kNX) {
            cYx.setReplyId(this.kNY);
            cYx.setThreadId(this.postId);
            y.f(this.postId, cYx);
            return;
        }
        y.b(str, cYx);
    }
}
