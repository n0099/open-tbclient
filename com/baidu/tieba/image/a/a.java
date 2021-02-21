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
    public String kVs;
    public boolean kWo;
    public String kWp;
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
        if (this.fDH.daC() == null) {
            this.fDH.f(daC());
        }
        if (this.fDH.daC() != null) {
            this.fDH.setSpanGroupManager(this.mSpanGroupManager);
            this.fDH.daC().setIsBJHPost(this.isBJH);
            this.fDH.daC().setWriteImagesInfo(this.writeImagesInfo);
            this.fDH.yE(this.writeImagesInfo.size() > 0);
            WriteData daC = this.fDH.daC();
            if (this.fDG == null || !this.fDG.clH()) {
                z = false;
            }
            daC.setHasLocationData(z);
            if (str == null) {
                this.fDH.daC().setContent(this.mPostContent);
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fDH.daC().setVoice(this.mVoiceModel.getId());
                    this.fDH.daC().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fDH.daC().setVoice(null);
                    this.fDH.daC().setVoiceDuringTime(-1);
                }
            } else {
                this.fDH.daC().setVoice(null);
                this.fDH.daC().setVoiceDuringTime(-1);
            }
            if (!this.fDH.dPf()) {
                this.eUY.showToast(R.string.write_img_limit);
                return;
            }
            if ((this.fDP == null || !this.fDP.bBL()) && !this.fDH.dPd()) {
            }
        }
    }

    public WriteData daC() {
        WriteData writeData = new WriteData();
        if (this.fDK != null) {
            if (this.fDQ && !this.kWo) {
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
        if (!this.kWo) {
            writeData.setType(1);
        } else {
            writeData.setType(2);
            writeData.setFloor(this.postId);
            writeData.setFloorNum(0);
            writeData.setReplyId(this.kWp);
            writeData.setRepostId(this.postId);
        }
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(this.kWo ? 1 : 0);
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
    public void CV(String str) {
        if (this.kWo) {
            y.e(this.postId, this);
        } else {
            y.a(str, this);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.e
    public void CU(String str) {
        WriteData daC = this.fDH.daC();
        if (daC == null) {
            WriteData writeData = new WriteData(this.kWo ? 2 : 1);
            writeData.setThreadId(str);
            writeData.setWriteImagesInfo(this.writeImagesInfo);
            daC = writeData;
        }
        if (!au.isEmpty(this.kVs)) {
            daC.setFromForumId(this.kVs);
        }
        daC.setContent(this.mPostContent);
        daC.setVoiceModel(this.mVoiceModel);
        if (this.kWo) {
            daC.setReplyId(this.kWp);
            daC.setThreadId(this.postId);
            y.f(this.postId, daC);
            return;
        }
        y.b(str, daC);
    }
}
