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
/* loaded from: classes7.dex */
public class a extends e {
    public String kXu;
    public boolean kYq;
    public String kYr;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    public String postId;

    public a(EditorTools editorTools) {
        super(editorTools);
        editorTools.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.image.a.a.1
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof u) {
                    if (((u) aVar.data).bwy() == EmotionGroupType.BIG_EMOTION || ((u) aVar.data).bwy() == EmotionGroupType.USER_COLLECT) {
                        if (a.this.mPermissionJudgePolicy == null) {
                            a.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        a.this.mPermissionJudgePolicy.appendRequestPermission(a.this.eWx.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgePolicy.startRequestPermission(a.this.eWx.getPageActivity())) {
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
        if (this.fFg.daL() == null) {
            this.fFg.f(daL());
        }
        if (this.fFg.daL() != null) {
            this.fFg.setSpanGroupManager(this.mSpanGroupManager);
            this.fFg.daL().setIsBJHPost(this.isBJH);
            this.fFg.daL().setWriteImagesInfo(this.writeImagesInfo);
            this.fFg.yD(this.writeImagesInfo.size() > 0);
            WriteData daL = this.fFg.daL();
            if (this.fFf == null || !this.fFf.clN()) {
                z = false;
            }
            daL.setHasLocationData(z);
            if (str == null) {
                this.fFg.daL().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fFg.daL().setVoice(this.mVoiceModel.getId());
                    this.fFg.daL().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fFg.daL().setVoice(null);
                    this.fFg.daL().setVoiceDuringTime(-1);
                }
            } else {
                this.fFg.daL().setVoice(null);
                this.fFg.daL().setVoiceDuringTime(-1);
            }
            if (!this.fFg.dPo()) {
                this.eWx.showToast(R.string.write_img_limit);
                return;
            }
            if ((this.fFo == null || !this.fFo.bBO()) && !this.fFg.dPm()) {
            }
        }
    }

    public WriteData daL() {
        WriteData writeData = new WriteData();
        if (this.fFj != null) {
            if (this.fFp && !this.kYq) {
                writeData.setCanNoForum(true);
                writeData.setVForumId(this.fFj.getId());
                writeData.setVForumName(this.fFj.getName());
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setCanNoForum(false);
                writeData.setVForumId("");
                writeData.setVForumName("");
                writeData.setForumId(this.fFj.getId());
                writeData.setForumName(this.fFj.getName());
            }
        }
        writeData.setThreadId(this.mThreadId);
        if (!this.kYq) {
            writeData.setType(1);
        } else {
            writeData.setType(2);
            writeData.setFloor(this.postId);
            writeData.setFloorNum(0);
            writeData.setReplyId(this.kYr);
            writeData.setRepostId(this.postId);
        }
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.kYq ? 1 : 0);
        pbEditorData.setContent(this.mPostContent);
        pbEditorData.setWriteImagesInfo(this.writeImagesInfo);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
        if (this.fFj != null) {
            threadData.setForumId(this.fFj.getId());
            threadData.setForumName(this.fFj.getName());
            threadData.setFirstDir(this.fFj.getFirst_class());
            threadData.setSecondDir(this.fFj.getSecond_class());
        }
        threadData.setAuthorId(this.authorId);
        threadData.setAuthorName(this.authorName);
        threadData.setAuthorNameShow(this.authorNameShow);
        threadData.setPostId(this.postId);
        threadData.setThreadId(this.mThreadId);
        threadData.isBJH = this.isBJH;
        pbEditorData.setThreadData(threadData);
        pbEditorData.setDisableVoiceMessage(this.fFk);
        pbEditorData.setOpenVoiceRecordButton(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eWx.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void Dc(String str) {
        if (this.kYq) {
            y.e(this.postId, this);
        } else {
            y.a(str, this);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void Db(String str) {
        WriteData daL = this.fFg.daL();
        if (daL == null) {
            WriteData writeData = new WriteData(this.kYq ? 2 : 1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
            daL = writeData;
        }
        if (!au.isEmpty(this.kXu)) {
            daL.setFromForumId(this.kXu);
        }
        daL.setContent(this.mPostContent);
        daL.setVoiceModel(this.mVoiceModel);
        if (this.kYq) {
            daL.setReplyId(this.kYr);
            daL.setThreadId(this.postId);
            y.f(this.postId, daL);
            return;
        }
        y.b(str, daL);
    }
}
