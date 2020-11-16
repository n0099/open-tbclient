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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
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
import com.baidu.tieba.pb.pb.main.bb;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes20.dex */
public class c {
    private TbPageContext context;
    private String foT;
    private String kyU;
    private LinearLayout kzJ;
    private b kzK;
    private a kzL;
    private a kzM;
    private a kzN;
    ViewTreeObserver.OnGlobalLayoutListener kzO;
    ViewTreeObserver.OnGlobalLayoutListener kzP;
    private ImageUrlData kzQ;
    public bb kzS;
    private am kzT;
    private int replyPrivateFlag;
    private boolean kzR = false;
    private View.OnClickListener fpG = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(c.this.foT)) {
                l.showToast(c.this.context.getPageActivity(), c.this.foT);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b foX = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.image.a.c.2
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bzr() {
            if (c.this.kzQ == null) {
                return false;
            }
            if (c.this.kzS != null) {
                com.baidu.tieba.write.c dob = c.this.kzQ.isFirstPost ? c.this.kzS.dob() : c.this.kzS.doc();
                if (dob != null && dob.dSU()) {
                    c.this.context.showToast(dob.dSW());
                    if (c.this.kzL != null && (c.this.kzL.bzI() || c.this.kzL.bzJ())) {
                        c.this.kzL.a(false, c.this.kzS.doe());
                    }
                    if (c.this.kzQ.isFirstPost) {
                        c.this.kzS.vb(true);
                    } else {
                        c.this.kzS.vc(true);
                    }
                    return true;
                }
            }
            return !c.this.kzT.pq(c.this.replyPrivateFlag);
        }
    };
    private final NewWriteModel.d fpd = new NewWriteModel.d() { // from class: com.baidu.tieba.image.a.c.3
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                c.this.cXt();
                if (c.this.context != null && (c.this.context.getPageActivity() instanceof BaseActivity)) {
                    ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                    showReplyInPbEvent.writeData = postWriteCallBackData;
                    showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                    ((BaseActivity) c.this.context.getPageActivity()).publishEvent(showReplyInPbEvent);
                }
                if (postWriteCallBackData != null) {
                    TiebaStatic.log(new ar("c13970").dR("tid", postWriteCallBackData.getThreadId()).dR("fid", writeData.getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).ak("obj_type", writeData.getType()));
                }
            } else if (i == 220015) {
                c.this.context.showToast(str);
                if (c.this.kzL != null && (c.this.kzL.bzI() || c.this.kzL.bzJ())) {
                    c.this.kzL.a(false, postWriteCallBackData);
                    c.this.cXt();
                }
                if (c.this.kzQ.isFirstPost) {
                    c.this.kzS.h(postWriteCallBackData);
                } else {
                    c.this.kzS.i(postWriteCallBackData);
                }
            } else if (i == 238010) {
                if (!au.isEmpty(str)) {
                    c.this.context.showToast(str);
                } else {
                    c.this.context.showToast(R.string.message_privacy_fans_can_reply);
                }
                c.this.cXt();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (!au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(c.this.context.getPageActivity(), postWriteCallBackData.getErrorString(), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(c.this.context.getPageActivity(), c.this.context.getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.context.getPageActivity());
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.AJ(c.this.context.getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AJ(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new ar("c13746").ak("obj_locate", 1).ak("obj_type", 2));
                    }
                });
                aVar.b(c.this.context).bog();
                TiebaStatic.log(new ar("c13745").ak("obj_locate", 1).ak("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                c.this.aG(i, str);
                c.this.cXt();
            }
        }
    };

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        this.context = tbPageContext;
        this.kzJ = linearLayout;
        this.kzJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.a.c.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    c.this.cXt();
                    return true;
                }
                return true;
            }
        });
        this.kzJ.setVisibility(8);
        this.kzT = new am(tbPageContext);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.kzR = true;
        if (this.kzL != null) {
            if (i == 25035) {
                d(i2, intent);
                cXt();
                return;
            }
            this.kzL.onActivityResult(i, i2, intent);
        }
    }

    public void setFromForumId(String str) {
        this.kyU = str;
    }

    private void d(int i, Intent intent) {
        if (i == 0 && this.kzL != null) {
            this.kzL.byN().bxk();
        } else {
            cXt();
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
                        if (this.kzM != null) {
                            this.kzM.resetData();
                            this.kzM.setVoiceModel(pbEditorData.getVoiceModel());
                            this.kzM.b(writeData);
                            m rI = this.kzM.byN().rI(6);
                            if (rI != null && rI.fmx != null) {
                                rI.fmx.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kzM.a((String) null, (WriteData) null);
                                return;
                            }
                            return;
                        }
                        return;
                    case 1:
                        if (this.kzN != null) {
                            this.kzN.b(writeData);
                            this.kzN.setVoiceModel(pbEditorData.getVoiceModel());
                            m rI2 = this.kzN.byN().rI(6);
                            if (rI2 != null && rI2.fmx != null) {
                                rI2.fmx.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kzN.a((String) null, (WriteData) null);
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
    public void aG(int i, String str) {
        if (AntiHelper.bP(i, str)) {
            AntiHelper.a(this.context.getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.image.a.c.5
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ak("obj_locate", ay.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ak("obj_locate", ay.a.LOCATE_REPLY));
                }
            });
        } else if (i == 230277) {
            Ds(str);
        } else {
            this.context.showToast(str);
        }
    }

    private void Ds(String str) {
        if (str == null) {
            str = "";
        }
        if (this.context != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getPageActivity());
            aVar.AJ(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.image.a.c.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.context).bog();
        }
    }

    public void a(ImageUrlData imageUrlData, com.baidu.tieba.image.c cVar) {
        boolean z;
        h rF;
        JSONArray jSONArray;
        String str;
        if (imageUrlData != null && cVar != null) {
            if (this.kzK == null) {
                this.kzK = new b();
                this.kzK.ei(imageUrlData.forumName, imageUrlData.forumId);
            }
            if (imageUrlData.isFirstPost && this.kzM == null) {
                this.kzK.kzF = false;
                this.kzM = (a) this.kzK.ei(this.context.getPageActivity());
                this.kzO = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kzM.byN().fmH, new b.InterfaceC0590b() { // from class: com.baidu.tieba.image.a.c.7
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0590b
                    public void kh(boolean z2) {
                        if (!z2) {
                            c.this.kzM.byN().fmH.byQ();
                        } else {
                            c.this.kzM.byN().fmH.setVisibility(0);
                        }
                    }
                });
                z = true;
            } else if (imageUrlData.isFirstPost || this.kzN != null) {
                z = false;
            } else {
                this.kzK.kzF = true;
                this.kzN = (a) this.kzK.ei(this.context.getPageActivity());
                this.kzP = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kzN.byN().fmH, new b.InterfaceC0590b() { // from class: com.baidu.tieba.image.a.c.8
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0590b
                    public void kh(boolean z2) {
                        if (!z2) {
                            c.this.kzN.byN().fmH.byQ();
                        } else {
                            c.this.kzN.byN().fmH.setVisibility(0);
                        }
                    }
                });
                z = true;
            }
            this.kzL = imageUrlData.isFirstPost ? this.kzM : this.kzN;
            if (z) {
                this.kzL.a(this.context);
                this.kzL.a(this.fpd);
                this.kzL.a(this.foX);
                this.kzL.a(this.context, (Bundle) null);
                this.kzL.a(cVar.jpQ, (UserData) null);
                this.kzL.km(cVar.kyd);
                this.kzL.kyU = this.kyU;
                if (cVar.kyb == null) {
                    this.kzL.setThreadId(imageUrlData.threadId + "");
                } else {
                    this.kzL.a(cVar.kyb, imageUrlData.threadId + "", cVar.kyc);
                }
                if (imageUrlData.isFirstPost) {
                    this.kzL.bzy();
                }
                this.kzL.byN().fmG.setPadding(0, 0, 0, 0);
                this.kzL.byN().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                this.kzL.byN().onChangeSkinType(0);
            }
            if (this.kzQ == null || imageUrlData.postId != this.kzQ.postId) {
                if (this.kzQ != null) {
                    this.kzL.Dm(this.kzQ.threadId + "");
                }
                this.kzL.bzH();
                this.kzL.resetData();
                this.kzL.kzF = !imageUrlData.isFirstPost;
                this.kzL.postId = imageUrlData.postId + "";
                this.kzL.kzG = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && this.kzL.byN() != null) {
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
                        this.kzL.byN().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                    }
                    jSONArray = null;
                    if (jSONArray != null) {
                    }
                    str = "";
                    this.kzL.byN().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                }
                this.replyPrivateFlag = cVar.replyPrivateFlag;
                this.foT = cVar.foT;
                if (this.kzL.byN() != null && !StringUtils.isNull(this.foT) && (rF = this.kzL.byN().rF(6)) != null && !TextUtils.isEmpty(this.foT)) {
                    ((View) rF).setOnClickListener(this.fpG);
                }
                this.kzL.Dn(imageUrlData.threadId + "");
            }
            if (this.kzQ == null || this.kzQ.isFirstPost != imageUrlData.isFirstPost) {
                if (this.kzL.byN() != null) {
                    this.kzJ.removeAllViews();
                    this.kzJ.addView(this.kzL.byN());
                }
                if (this.kzS == null) {
                    this.kzS = new bb();
                }
                if (this.kzL.bzt() != null) {
                    this.kzS.e(this.kzL.bzt().getInputView());
                }
            }
            this.kzQ = imageUrlData;
        }
    }

    public void b(ImageUrlData imageUrlData, com.baidu.tieba.image.c cVar) {
        if (this.kzT != null && imageUrlData != null && cVar != null && this.kzT.pp(cVar.replyPrivateFlag)) {
            if (this.kzQ == null || this.kzQ.postId != imageUrlData.postId || this.kzL == null) {
                a(imageUrlData, cVar);
            }
            if (this.kzL != null) {
                if (this.kzL.bzI() || this.kzL.bzJ()) {
                    this.kzL.a(false, (PostWriteCallBackData) null);
                    return;
                }
                this.kzJ.setVisibility(0);
                if (this.kzL.byN() != null) {
                    this.kzL.byN().display();
                    this.kzL.byN().bxk();
                }
            }
        }
    }

    public void cXt() {
        if (this.kzL != null && this.kzL.byN() != null) {
            this.kzL.byN().hide();
        }
        l.hideSoftKeyPad(this.context.getPageActivity(), this.kzJ);
        this.kzJ.setVisibility(8);
    }

    public void onPause() {
        if (this.kzQ != null && this.kzL != null) {
            this.kzL.Dm(this.kzQ.threadId + "");
        }
    }

    public void onResume() {
        if (this.kzQ != null && this.kzL != null) {
            if (this.kzR) {
                this.kzR = false;
                return;
            }
            this.kzL.bzH();
            this.kzL.Dn(this.kzQ.threadId + "");
            this.kzL.byN().bxk();
        }
    }

    public void onDestroy() {
        if (this.kzT != null) {
            this.kzT.onDestroy();
        }
        if (this.kzO != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kzO);
        }
        if (this.kzP != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kzP);
        }
    }
}
