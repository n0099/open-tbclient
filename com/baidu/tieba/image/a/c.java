package com.baidu.tieba.image.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.h;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.editortools.noConflictPanel.b.b;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.image.d;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class c {
    private TbPageContext context;
    private String fBw;
    private String kNb;
    private LinearLayout kOc;
    private b kOd;
    private a kOe;
    private a kOf;
    private a kOg;
    ViewTreeObserver.OnGlobalLayoutListener kOh;
    ViewTreeObserver.OnGlobalLayoutListener kOi;
    private ImageUrlData kOj;
    public ar kOl;
    private al kOm;
    private int mSkinType;
    private int replyPrivateFlag;
    private boolean kOk = false;
    private View.OnClickListener fCk = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(c.this.fBw)) {
                l.showToast(c.this.context.getPageActivity(), c.this.fBw);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b fBA = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.image.a.c.2
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBt() {
            if (c.this.kOj == null) {
                return false;
            }
            if (c.this.kOl != null) {
                com.baidu.tieba.write.c dpr = c.this.kOj.isFirstPost ? c.this.kOl.dpr() : c.this.kOl.dps();
                if (dpr != null && dpr.dUb()) {
                    c.this.context.showToast(dpr.dUd());
                    if (c.this.kOe != null && (c.this.kOe.bBK() || c.this.kOe.bBL())) {
                        c.this.kOe.a(false, c.this.kOl.dpu());
                    }
                    if (c.this.kOj.isFirstPost) {
                        c.this.kOl.vB(true);
                    } else {
                        c.this.kOl.vC(true);
                    }
                    return true;
                }
            }
            return !c.this.kOm.ot(c.this.replyPrivateFlag);
        }
    };
    private final NewWriteModel.d fBH = new NewWriteModel.d() { // from class: com.baidu.tieba.image.a.c.3
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                c.this.cYy();
                if (c.this.context != null && (c.this.context.getPageActivity() instanceof BaseActivity)) {
                    ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                    showReplyInPbEvent.writeData = postWriteCallBackData;
                    showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                    ((BaseActivity) c.this.context.getPageActivity()).publishEvent(showReplyInPbEvent);
                }
                if (postWriteCallBackData != null) {
                    TiebaStatic.log(new aq("c13970").dW("tid", postWriteCallBackData.getThreadId()).dW("fid", writeData.getForumId()).dW("uid", TbadkCoreApplication.getCurrentAccount()).an("obj_type", writeData.getType()));
                }
            } else if (i == 220015) {
                c.this.context.showToast(str);
                if (c.this.kOe != null && (c.this.kOe.bBK() || c.this.kOe.bBL())) {
                    c.this.kOe.a(false, postWriteCallBackData);
                    c.this.cYy();
                }
                if (c.this.kOj.isFirstPost) {
                    c.this.kOl.h(postWriteCallBackData);
                } else {
                    c.this.kOl.i(postWriteCallBackData);
                }
            } else if (i == 238010) {
                if (!at.isEmpty(str)) {
                    c.this.context.showToast(str);
                } else {
                    c.this.context.showToast(R.string.message_privacy_fans_can_reply);
                }
                c.this.cYy();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (!at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(c.this.context.getPageActivity(), postWriteCallBackData.getErrorString(), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(c.this.context.getPageActivity(), c.this.context.getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.context.getPageActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Ad(c.this.context.getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Ad(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new aq("c13746").an("obj_locate", 1).an("obj_type", 2));
                    }
                });
                aVar.b(c.this.context).bqe();
                TiebaStatic.log(new aq("c13745").an("obj_locate", 1).an("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                c.this.aJ(i, str);
                c.this.cYy();
            }
        }
    };

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        this.context = tbPageContext;
        this.kOc = linearLayout;
        this.kOc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.a.c.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    c.this.cYy();
                    return true;
                }
                return true;
            }
        });
        this.kOc.setVisibility(8);
        this.kOm = new al(tbPageContext);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.kOk = true;
        if (this.kOe != null) {
            if (i == 25035) {
                d(i2, intent);
                cYy();
                return;
            }
            this.kOe.onActivityResult(i, i2, intent);
        }
    }

    public void setFromForumId(String str) {
        this.kNb = str;
    }

    private void d(int i, Intent intent) {
        if (i == 0 && this.kOe != null) {
            this.kOe.bAP().bzl();
        } else {
            cYy();
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
                        if (this.kOf != null) {
                            this.kOf.resetData();
                            this.kOf.setVoiceModel(pbEditorData.getVoiceModel());
                            this.kOf.c(writeData);
                            m qP = this.kOf.bAP().qP(6);
                            if (qP != null && qP.fyZ != null) {
                                qP.fyZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kOf.a((String) null, (WriteData) null);
                                return;
                            }
                            return;
                        }
                        return;
                    case 1:
                        if (this.kOg != null) {
                            this.kOg.c(writeData);
                            this.kOg.setVoiceModel(pbEditorData.getVoiceModel());
                            m qP2 = this.kOg.bAP().qP(6);
                            if (qP2 != null && qP2.fyZ != null) {
                                qP2.fyZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kOg.a((String) null, (WriteData) null);
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
    public void aJ(int i, String str) {
        if (AntiHelper.bQ(i, str)) {
            AntiHelper.a(this.context.getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.image.a.c.5
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_REPLY));
                }
            });
        } else if (i == 230277) {
            CL(str);
        } else {
            this.context.showToast(str);
        }
    }

    private void CL(String str) {
        if (str == null) {
            str = "";
        }
        if (this.context != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getPageActivity());
            aVar.Ad(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.image.a.c.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.context).bqe();
        }
    }

    public void a(ImageUrlData imageUrlData, d dVar) {
        boolean z;
        h qM;
        JSONArray jSONArray;
        String str;
        if (imageUrlData != null && dVar != null) {
            if (this.kOd == null) {
                this.kOd = new b();
                this.kOd.ei(imageUrlData.forumName, imageUrlData.forumId);
            }
            if (imageUrlData.isFirstPost && this.kOf == null) {
                this.kOd.kNX = false;
                this.kOf = (a) this.kOd.fh(this.context.getPageActivity());
                this.kOh = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kOf.bAP().fzj, new b.InterfaceC0577b() { // from class: com.baidu.tieba.image.a.c.7
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0577b
                    public void kQ(boolean z2) {
                        if (!z2) {
                            c.this.kOf.bAP().fzj.bAS();
                        } else {
                            c.this.kOf.bAP().fzj.setVisibility(0);
                        }
                    }
                });
                z = true;
            } else if (imageUrlData.isFirstPost || this.kOg != null) {
                z = false;
            } else {
                this.kOd.kNX = true;
                this.kOg = (a) this.kOd.fh(this.context.getPageActivity());
                this.kOi = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kOg.bAP().fzj, new b.InterfaceC0577b() { // from class: com.baidu.tieba.image.a.c.8
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0577b
                    public void kQ(boolean z2) {
                        if (!z2) {
                            c.this.kOg.bAP().fzj.bAS();
                        } else {
                            c.this.kOg.bAP().fzj.setVisibility(0);
                        }
                    }
                });
                z = true;
            }
            this.kOe = imageUrlData.isFirstPost ? this.kOf : this.kOg;
            if (z) {
                this.kOe.a(this.context);
                this.kOe.a(this.fBH);
                this.kOe.a(this.fBA);
                this.kOe.a(this.context, (Bundle) null);
                this.kOe.a(dVar.jLo, (UserData) null);
                this.kOe.kV(dVar.kMh);
                this.kOe.bBO();
                this.kOe.kNb = this.kNb;
                if (dVar.kMf == null) {
                    this.kOe.setThreadId(imageUrlData.threadId + "");
                } else {
                    this.kOe.a(dVar.kMf, imageUrlData.threadId + "", dVar.kMg);
                }
                if (imageUrlData.isFirstPost) {
                    this.kOe.bBA();
                }
                this.kOe.bAP().fzi.setPadding(0, 0, 0, 0);
                this.kOe.bAP().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                this.kOe.bAP().onChangeSkinType(this.mSkinType);
            }
            if (this.kOj == null || imageUrlData.postId != this.kOj.postId) {
                if (this.kOj != null) {
                    this.kOe.CF(this.kOj.threadId + "");
                }
                this.kOe.bBJ();
                this.kOe.resetData();
                this.kOe.kNX = !imageUrlData.isFirstPost;
                this.kOe.postId = imageUrlData.postId + "";
                this.kOe.kNY = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && this.kOe.bAP() != null) {
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
                        this.kOe.bAP().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                    }
                    jSONArray = null;
                    if (jSONArray != null) {
                    }
                    str = "";
                    this.kOe.bAP().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                }
                this.replyPrivateFlag = dVar.replyPrivateFlag;
                this.fBw = dVar.fBw;
                if (this.kOe.bAP() != null && !StringUtils.isNull(this.fBw) && (qM = this.kOe.bAP().qM(6)) != null && !TextUtils.isEmpty(this.fBw)) {
                    ((View) qM).setOnClickListener(this.fCk);
                }
                this.kOe.CG(imageUrlData.threadId + "");
            }
            if (this.kOj == null || this.kOj.isFirstPost != imageUrlData.isFirstPost) {
                if (this.kOe.bAP() != null) {
                    this.kOc.removeAllViews();
                    this.kOc.addView(this.kOe.bAP());
                }
                if (this.kOl == null) {
                    this.kOl = new ar();
                }
                if (this.kOe.bBv() != null) {
                    this.kOl.f(this.kOe.bBv().getInputView());
                }
            }
            this.kOj = imageUrlData;
        }
    }

    public void b(ImageUrlData imageUrlData, d dVar) {
        if (this.kOm != null && imageUrlData != null && dVar != null && this.kOm.os(dVar.replyPrivateFlag)) {
            if (this.kOj == null || this.kOj.postId != imageUrlData.postId || this.kOe == null) {
                a(imageUrlData, dVar);
            }
            if (this.kOe != null) {
                if (this.kOe.bBK() || this.kOe.bBL()) {
                    this.kOe.a(false, (PostWriteCallBackData) null);
                    return;
                }
                this.kOc.setVisibility(0);
                if (this.kOe.bAP() != null) {
                    this.kOe.bAP().rV();
                    this.kOe.bAP().bzl();
                }
            }
        }
    }

    public void cYy() {
        if (this.kOe != null && this.kOe.bAP() != null) {
            this.kOe.bAP().hide();
        }
        l.hideSoftKeyPad(this.context.getPageActivity(), this.kOc);
        this.kOc.setVisibility(8);
    }

    public void onPause() {
        if (this.kOj != null && this.kOe != null) {
            this.kOe.CF(this.kOj.threadId + "");
        }
    }

    public void onResume() {
        if (this.kOj != null && this.kOe != null) {
            if (this.kOk) {
                this.kOk = false;
                return;
            }
            this.kOe.bBJ();
            this.kOe.CG(this.kOj.threadId + "");
            this.kOe.bAP().bzl();
        }
    }

    public void onDestroy() {
        if (this.kOm != null) {
            this.kOm.onDestroy();
        }
        if (this.kOh != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kOh);
        }
        if (this.kOi != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kOi);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kOe != null) {
            this.kOe.bAP().onChangeSkinType(i);
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }
}
