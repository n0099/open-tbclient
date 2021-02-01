package com.baidu.tieba.image.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes8.dex */
public class a extends e {
    public String kVe;
    public boolean kWa;
    public String kWb;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    public String postId;

    public a(EditorTools editorTools) {
        super(editorTools);
        editorTools.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.image.a.a.1
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof u) {
                    if (((u) aVar.data).bwv() == EmotionGroupType.BIG_EMOTION || ((u) aVar.data).bwv() == EmotionGroupType.USER_COLLECT) {
                        if (a.this.mPermissionJudgePolicy == null) {
                            a.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        a.this.mPermissionJudgePolicy.appendRequestPermission(a.this.eUY.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgePolicy.startRequestPermission(a.this.eUY.getPageActivity())) {
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
        if (this.fDH.dav() == null) {
            this.fDH.f(dav());
        }
        if (this.fDH.dav() != null) {
            this.fDH.setSpanGroupManager(this.mSpanGroupManager);
            this.fDH.dav().setIsBJHPost(this.isBJH);
            this.fDH.dav().setWriteImagesInfo(this.writeImagesInfo);
            this.fDH.yE(this.writeImagesInfo.size() > 0);
            WriteData dav = this.fDH.dav();
            if (this.fDG == null || !this.fDG.clA()) {
                z = false;
            }
            dav.setHasLocationData(z);
            if (str == null) {
                this.fDH.dav().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fDH.dav().setVoice(this.mVoiceModel.getId());
                    this.fDH.dav().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fDH.dav().setVoice(null);
                    this.fDH.dav().setVoiceDuringTime(-1);
                }
            } else {
                this.fDH.dav().setVoice(null);
                this.fDH.dav().setVoiceDuringTime(-1);
            }
            if (!this.fDH.dOX()) {
                this.eUY.showToast(R.string.write_img_limit);
                return;
            }
            if ((this.fDP == null || !this.fDP.bBL()) && !this.fDH.dOV()) {
            }
        }
    }

    public WriteData dav() {
        WriteData writeData = new WriteData();
        if (this.fDK != null) {
            if (this.fDQ && !this.kWa) {
                writeData.setCanNoForum(true);
                writeData.setVForumId(this.fDK.getId());
                writeData.setVForumName(this.fDK.getName());
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setCanNoForum(false);
                writeData.setVForumId("");
                writeData.setVForumName("");
                writeData.setForumId(this.fDK.getId());
                writeData.setForumName(this.fDK.getName());
            }
        }
        writeData.setThreadId(this.mThreadId);
        if (!this.kWa) {
            writeData.setType(1);
        } else {
            writeData.setType(2);
            writeData.setFloor(this.postId);
            writeData.setFloorNum(0);
            writeData.setReplyId(this.kWb);
            writeData.setRepostId(this.postId);
        }
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.kWa ? 1 : 0);
        pbEditorData.setContent(this.mPostContent);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.fDK != null) {
            threadData.setForumId(this.fDK.getId());
            threadData.setForumName(this.fDK.getName());
            threadData.setFirstDir(this.fDK.getFirst_class());
            threadData.setSecondDir(this.fDK.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.fDL);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eUY.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void CX(String str) {
        if (this.kWa) {
            y.e(this.postId, this);
        } else {
            y.a(str, this);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void CW(String str) {
        WriteData dav = this.fDH.dav();
        if (dav == null) {
            WriteData writeData = new WriteData(this.kWa ? 2 : 1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
            dav = writeData;
        }
        if (!au.isEmpty(this.kVe)) {
            dav.setFromForumId(this.kVe);
        }
        dav.setContent(this.mPostContent);
        dav.setVoiceModel(this.mVoiceModel);
        if (this.kWa) {
            dav.setReplyId(this.kWb);
            dav.setThreadId(this.postId);
            y.f(this.postId, dav);
            return;
        }
        y.b(str, dav);
    }
}
