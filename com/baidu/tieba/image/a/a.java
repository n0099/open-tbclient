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
/* loaded from: classes8.dex */
public class a extends e {
    public String kRG;
    public boolean kSC;
    public String kSD;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    public String postId;

    public a(EditorTools editorTools) {
        super(editorTools);
        editorTools.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.image.a.a.1
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof u) {
                    if (((u) aVar.data).bzW() == EmotionGroupType.BIG_EMOTION || ((u) aVar.data).bzW() == EmotionGroupType.USER_COLLECT) {
                        if (a.this.mPermissionJudgePolicy == null) {
                            a.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        a.this.mPermissionJudgePolicy.appendRequestPermission(a.this.eXu.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgePolicy.startRequestPermission(a.this.eXu.getPageActivity())) {
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
        if (this.fGa.dco() == null) {
            this.fGa.f(dco());
        }
        if (this.fGa.dco() != null) {
            this.fGa.setSpanGroupManager(this.mSpanGroupManager);
            this.fGa.dco().setIsBJHPost(this.isBJH);
            this.fGa.dco().setWriteImagesInfo(this.writeImagesInfo);
            this.fGa.yp(this.writeImagesInfo.size() > 0);
            WriteData dco = this.fGa.dco();
            if (this.fFZ == null || !this.fFZ.cot()) {
                z = false;
            }
            dco.setHasLocationData(z);
            if (str == null) {
                this.fGa.dco().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fGa.dco().setVoice(this.mVoiceModel.getId());
                    this.fGa.dco().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fGa.dco().setVoice(null);
                    this.fGa.dco().setVoiceDuringTime(-1);
                }
            } else {
                this.fGa.dco().setVoice(null);
                this.fGa.dco().setVoiceDuringTime(-1);
            }
            if (!this.fGa.dQD()) {
                this.eXu.showToast(R.string.write_img_limit);
                return;
            }
            if ((this.fGi == null || !this.fGi.bFm()) && !this.fGa.dQB()) {
            }
        }
    }

    public WriteData dco() {
        WriteData writeData = new WriteData();
        if (this.fGd != null) {
            if (this.fGj && !this.kSC) {
                writeData.setCanNoForum(true);
                writeData.setVForumId(this.fGd.getId());
                writeData.setVForumName(this.fGd.getName());
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setCanNoForum(false);
                writeData.setVForumId("");
                writeData.setVForumName("");
                writeData.setForumId(this.fGd.getId());
                writeData.setForumName(this.fGd.getName());
            }
        }
        writeData.setThreadId(this.mThreadId);
        if (!this.kSC) {
            writeData.setType(1);
        } else {
            writeData.setType(2);
            writeData.setFloor(this.postId);
            writeData.setFloorNum(0);
            writeData.setReplyId(this.kSD);
            writeData.setRepostId(this.postId);
        }
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.kSC ? 1 : 0);
        pbEditorData.setContent(this.mPostContent);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.fGd != null) {
            threadData.setForumId(this.fGd.getId());
            threadData.setForumName(this.fGd.getName());
            threadData.setFirstDir(this.fGd.getFirst_class());
            threadData.setSecondDir(this.fGd.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.fGe);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eXu.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void DS(String str) {
        if (this.kSC) {
            y.e(this.postId, this);
        } else {
            y.a(str, this);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void DR(String str) {
        WriteData dco = this.fGa.dco();
        if (dco == null) {
            WriteData writeData = new WriteData(this.kSC ? 2 : 1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
            dco = writeData;
        }
        if (!at.isEmpty(this.kRG)) {
            dco.setFromForumId(this.kRG);
        }
        dco.setContent(this.mPostContent);
        dco.setVoiceModel(this.mVoiceModel);
        if (this.kSC) {
            dco.setReplyId(this.kSD);
            dco.setThreadId(this.postId);
            y.f(this.postId, dco);
            return;
        }
        y.b(str, dco);
    }
}
