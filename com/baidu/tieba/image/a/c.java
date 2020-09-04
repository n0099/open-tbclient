package com.baidu.tieba.image.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.h;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.image.e;
import com.baidu.tieba.pb.pb.main.bb;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes15.dex */
public class c {
    private TbPageContext context;
    private String eMx;
    private String jIK;
    private LinearLayout jJB;
    private b jJC;
    private a jJD;
    private a jJE;
    private a jJF;
    private ImageUrlData jJG;
    public bb jJI;
    private am jJJ;
    private int replyPrivateFlag;
    private boolean jJH = false;
    private View.OnClickListener eNj = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(c.this.eMx)) {
                l.showToast(c.this.context.getPageActivity(), c.this.eMx);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b eMB = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.image.a.c.2
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean brV() {
            if (c.this.jJG == null) {
                return false;
            }
            if (c.this.jJI != null) {
                com.baidu.tieba.write.c dbF = c.this.jJG.isFirstPost ? c.this.jJI.dbF() : c.this.jJI.dbG();
                if (dbF != null && dbF.dFF()) {
                    c.this.context.showToast(dbF.dFH());
                    if (c.this.jJD != null && (c.this.jJD.bsm() || c.this.jJD.bsn())) {
                        c.this.jJD.a(false, c.this.jJI.dbI());
                    }
                    if (c.this.jJG.isFirstPost) {
                        c.this.jJI.tK(true);
                    } else {
                        c.this.jJI.tL(true);
                    }
                    return true;
                }
            }
            return !c.this.jJJ.nQ(c.this.replyPrivateFlag);
        }
    };
    private final NewWriteModel.d eMH = new NewWriteModel.d() { // from class: com.baidu.tieba.image.a.c.3
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                c.this.cLb();
                if (c.this.context != null && (c.this.context.getPageActivity() instanceof BaseActivity)) {
                    ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                    showReplyInPbEvent.writeData = postWriteCallBackData;
                    showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                    ((BaseActivity) c.this.context.getPageActivity()).publishEvent(showReplyInPbEvent);
                }
                if (postWriteCallBackData != null) {
                    TiebaStatic.log(new aq("c13970").dD("tid", postWriteCallBackData.getThreadId()).dD("fid", writeData.getForumId()).dD("uid", TbadkCoreApplication.getCurrentAccount()).ai("obj_type", writeData.getType()));
                }
            } else if (i == 220015) {
                c.this.context.showToast(str);
                if (c.this.jJD != null && (c.this.jJD.bsm() || c.this.jJD.bsn())) {
                    c.this.jJD.a(false, postWriteCallBackData);
                    c.this.cLb();
                }
                if (c.this.jJG.isFirstPost) {
                    c.this.jJI.g(postWriteCallBackData);
                } else {
                    c.this.jJI.h(postWriteCallBackData);
                }
            } else if (i == 238010) {
                if (!at.isEmpty(str)) {
                    c.this.context.showToast(str);
                } else {
                    c.this.context.showToast(R.string.message_privacy_fans_can_reply);
                }
                c.this.cLb();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (!at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(c.this.context.getPageActivity(), postWriteCallBackData.getErrorString(), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(c.this.context.getPageActivity(), c.this.context.getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.context.getPageActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.zA(c.this.context.getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zA(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.image.a.c.3.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.image.a.c.3.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        c.this.context.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(c.this.context.getPageActivity(), 0, 26, 2)));
                        TiebaStatic.log(new aq("c13746").ai("obj_locate", 1).ai("obj_type", 2));
                    }
                });
                aVar.b(c.this.context).bhg();
                TiebaStatic.log(new aq("c13745").ai("obj_locate", 1).ai("obj_type", 2));
            } else if (agVar == null && i != 227001) {
                c.this.aq(i, str);
                c.this.cLb();
            }
        }
    };

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        this.context = tbPageContext;
        this.jJB = linearLayout;
        this.jJB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.a.c.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    c.this.cLb();
                    return true;
                }
                return true;
            }
        });
        this.jJB.setVisibility(8);
        this.jJJ = new am(tbPageContext);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.jJH = true;
        if (this.jJD != null) {
            if (i == 25035) {
                d(i2, intent);
                cLb();
                return;
            }
            this.jJD.onActivityResult(i, i2, intent);
        }
    }

    public void setFromForumId(String str) {
        this.jIK = str;
    }

    private void d(int i, Intent intent) {
        if (i == 0 && this.jJD != null) {
            this.jJD.brw().bpY();
        } else {
            cLb();
        }
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        if (this.jJE != null) {
                            this.jJE.resetData();
                            this.jJE.setVoiceModel(pbEditorData.getVoiceModel());
                            this.jJE.b(writeData);
                            m qe = this.jJE.brw().qe(6);
                            if (qe != null && qe.eKB != null) {
                                qe.eKB.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.jJE.a((String) null, (WriteData) null);
                                return;
                            }
                            return;
                        }
                        return;
                    case 1:
                        if (this.jJF != null) {
                            this.jJF.b(writeData);
                            this.jJF.setVoiceModel(pbEditorData.getVoiceModel());
                            m qe2 = this.jJF.brw().qe(6);
                            if (qe2 != null && qe2.eKB != null) {
                                qe2.eKB.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.jJF.a((String) null, (WriteData) null);
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(int i, String str) {
        if (AntiHelper.by(i, str)) {
            AntiHelper.a(this.context.getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.image.a.c.5
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_REPLY));
                }
            });
        } else if (i == 230277) {
            Ce(str);
        } else {
            this.context.showToast(str);
        }
    }

    private void Ce(String str) {
        if (str == null) {
            str = "";
        }
        if (this.context != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getPageActivity());
            aVar.zA(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.image.a.c.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.context).bhg();
        }
    }

    public void a(ImageUrlData imageUrlData, e eVar) {
        boolean z;
        h qb;
        JSONArray jSONArray;
        String str;
        if (imageUrlData != null && eVar != null) {
            if (this.jJC == null) {
                this.jJC = new b();
                this.jJC.dT(imageUrlData.forumName, imageUrlData.forumId);
            }
            if (imageUrlData.isFirstPost && this.jJE == null) {
                this.jJC.jJx = false;
                this.jJE = (a) this.jJC.ec(this.context.getPageActivity());
                z = true;
            } else if (imageUrlData.isFirstPost || this.jJF != null) {
                z = false;
            } else {
                this.jJC.jJx = true;
                this.jJF = (a) this.jJC.ec(this.context.getPageActivity());
                z = true;
            }
            this.jJD = imageUrlData.isFirstPost ? this.jJE : this.jJF;
            if (z) {
                this.jJD.a(this.context);
                this.jJD.a(this.eMH);
                this.jJD.a(this.eMB);
                this.jJD.a(this.context, (Bundle) null);
                this.jJD.a(eVar.iAE, (UserData) null);
                this.jJD.jq(eVar.jHT);
                this.jJD.jIK = this.jIK;
                if (eVar.jHR == null) {
                    this.jJD.setThreadId(imageUrlData.threadId + "");
                } else {
                    this.jJD.a(eVar.jHR, imageUrlData.threadId + "", eVar.jHS);
                }
                if (imageUrlData.isFirstPost) {
                    this.jJD.bsc();
                }
                this.jJD.brw().eKK.setPadding(0, 0, 0, 0);
                this.jJD.brw().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                this.jJD.brw().onChangeSkinType(0);
            }
            if (this.jJG == null || imageUrlData.postId != this.jJG.postId) {
                if (this.jJG != null) {
                    this.jJD.BY(this.jJG.threadId + "");
                }
                this.jJD.bsl();
                this.jJD.resetData();
                this.jJD.jJx = !imageUrlData.isFirstPost;
                this.jJD.postId = imageUrlData.postId + "";
                this.jJD.jJy = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && this.jJD.brw() != null) {
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title);
                    try {
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                        jSONArray = new JSONArray(imageUrlData.richTextArray);
                        if (jSONArray != null || jSONArray.length() <= 0) {
                            str = "";
                        } else {
                            str = TbRichTextView.a((Context) this.context.getPageActivity(), jSONArray, false).toString();
                        }
                        this.jJD.brw().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                    }
                    jSONArray = null;
                    if (jSONArray != null) {
                    }
                    str = "";
                    this.jJD.brw().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                }
                this.replyPrivateFlag = eVar.replyPrivateFlag;
                this.eMx = eVar.eMx;
                if (this.jJD.brw() != null && !StringUtils.isNull(this.eMx) && (qb = this.jJD.brw().qb(6)) != null && !TextUtils.isEmpty(this.eMx)) {
                    ((View) qb).setOnClickListener(this.eNj);
                }
                this.jJD.BZ(imageUrlData.threadId + "");
            }
            if (this.jJG == null || this.jJG.isFirstPost != imageUrlData.isFirstPost) {
                if (this.jJD.brw() != null) {
                    this.jJB.removeAllViews();
                    this.jJB.addView(this.jJD.brw());
                }
                if (this.jJI == null) {
                    this.jJI = new bb();
                }
                if (this.jJD.brX() != null) {
                    this.jJI.f(this.jJD.brX().getInputView());
                }
            }
            this.jJG = imageUrlData;
        }
    }

    public void b(ImageUrlData imageUrlData, e eVar) {
        if (this.jJJ != null && imageUrlData != null && eVar != null && this.jJJ.nP(eVar.replyPrivateFlag)) {
            if (this.jJG == null || this.jJG.postId != imageUrlData.postId || this.jJD == null) {
                a(imageUrlData, eVar);
            }
            if (this.jJD != null) {
                if (this.jJD.bsm() || this.jJD.bsn()) {
                    this.jJD.a(false, (PostWriteCallBackData) null);
                    return;
                }
                this.jJB.setVisibility(0);
                if (this.jJD.brw() != null) {
                    this.jJD.brw().display();
                    this.jJD.brw().bpY();
                }
            }
        }
    }

    public void cLb() {
        if (this.jJD != null && this.jJD.brw() != null) {
            this.jJD.brw().hide();
        }
        l.hideSoftKeyPad(this.context.getPageActivity(), this.jJB);
        this.jJB.setVisibility(8);
    }

    public void onPause() {
        if (this.jJG != null && this.jJD != null) {
            this.jJD.BY(this.jJG.threadId + "");
        }
    }

    public void onResume() {
        if (this.jJG != null && this.jJD != null) {
            if (this.jJH) {
                this.jJH = false;
                return;
            }
            this.jJD.bsl();
            this.jJD.BZ(this.jJG.threadId + "");
            this.jJD.brw().bpY();
        }
    }

    public void onDestroy() {
        if (this.jJJ != null) {
            this.jJJ.onDestroy();
        }
    }
}
