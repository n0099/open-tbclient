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
/* loaded from: classes8.dex */
public class c {
    private TbPageContext context;
    private String fGe;
    private String kRG;
    private LinearLayout kSH;
    private b kSI;
    private a kSJ;
    private a kSK;
    private a kSL;
    ViewTreeObserver.OnGlobalLayoutListener kSM;
    ViewTreeObserver.OnGlobalLayoutListener kSN;
    private ImageUrlData kSO;
    public ar kSQ;
    private al kSR;
    private int mSkinType;
    private int replyPrivateFlag;
    private boolean kSP = false;
    private View.OnClickListener fGR = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(c.this.fGe)) {
                l.showToast(c.this.context.getPageActivity(), c.this.fGe);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b fGi = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.image.a.c.2
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bFm() {
            if (c.this.kSO == null) {
                return false;
            }
            if (c.this.kSQ != null) {
                com.baidu.tieba.write.c dti = c.this.kSO.isFirstPost ? c.this.kSQ.dti() : c.this.kSQ.dtj();
                if (dti != null && dti.dXS()) {
                    c.this.context.showToast(dti.dXU());
                    if (c.this.kSJ != null && (c.this.kSJ.bFD() || c.this.kSJ.bFE())) {
                        c.this.kSJ.a(false, c.this.kSQ.dtl());
                    }
                    if (c.this.kSO.isFirstPost) {
                        c.this.kSQ.vF(true);
                    } else {
                        c.this.kSQ.vG(true);
                    }
                    return true;
                }
            }
            return !c.this.kSR.qa(c.this.replyPrivateFlag);
        }
    };
    private final NewWriteModel.d fGo = new NewWriteModel.d() { // from class: com.baidu.tieba.image.a.c.3
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                c.this.dcp();
                if (c.this.context != null && (c.this.context.getPageActivity() instanceof BaseActivity)) {
                    ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                    showReplyInPbEvent.writeData = postWriteCallBackData;
                    showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                    ((BaseActivity) c.this.context.getPageActivity()).publishEvent(showReplyInPbEvent);
                }
                if (postWriteCallBackData != null) {
                    TiebaStatic.log(new aq("c13970").dX("tid", postWriteCallBackData.getThreadId()).dX("fid", writeData.getForumId()).dX("uid", TbadkCoreApplication.getCurrentAccount()).an("obj_type", writeData.getType()));
                }
            } else if (i == 220015) {
                c.this.context.showToast(str);
                if (c.this.kSJ != null && (c.this.kSJ.bFD() || c.this.kSJ.bFE())) {
                    c.this.kSJ.a(false, postWriteCallBackData);
                    c.this.dcp();
                }
                if (c.this.kSO.isFirstPost) {
                    c.this.kSQ.h(postWriteCallBackData);
                } else {
                    c.this.kSQ.i(postWriteCallBackData);
                }
            } else if (i == 238010) {
                if (!at.isEmpty(str)) {
                    c.this.context.showToast(str);
                } else {
                    c.this.context.showToast(R.string.message_privacy_fans_can_reply);
                }
                c.this.dcp();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (!at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(c.this.context.getPageActivity(), postWriteCallBackData.getErrorString(), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(c.this.context.getPageActivity(), c.this.context.getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.context.getPageActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Bp(c.this.context.getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bp(postWriteCallBackData.getErrorString());
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
                aVar.b(c.this.context).btX();
                TiebaStatic.log(new aq("c13745").an("obj_locate", 1).an("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                c.this.aI(i, str);
                c.this.dcp();
            }
        }
    };

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        this.context = tbPageContext;
        this.kSH = linearLayout;
        this.kSH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.a.c.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    c.this.dcp();
                    return true;
                }
                return true;
            }
        });
        this.kSH.setVisibility(8);
        this.kSR = new al(tbPageContext);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.kSP = true;
        if (this.kSJ != null) {
            if (i == 25035) {
                d(i2, intent);
                dcp();
                return;
            }
            this.kSJ.onActivityResult(i, i2, intent);
        }
    }

    public void setFromForumId(String str) {
        this.kRG = str;
    }

    private void d(int i, Intent intent) {
        if (i == 0 && this.kSJ != null) {
            this.kSJ.bEI().bDe();
        } else {
            dcp();
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
                        if (this.kSK != null) {
                            this.kSK.resetData();
                            this.kSK.setVoiceModel(pbEditorData.getVoiceModel());
                            this.kSK.c(writeData);
                            m sv = this.kSK.bEI().sv(6);
                            if (sv != null && sv.fDH != null) {
                                sv.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kSK.a((String) null, (WriteData) null);
                                return;
                            }
                            return;
                        }
                        return;
                    case 1:
                        if (this.kSL != null) {
                            this.kSL.c(writeData);
                            this.kSL.setVoiceModel(pbEditorData.getVoiceModel());
                            m sv2 = this.kSL.bEI().sv(6);
                            if (sv2 != null && sv2.fDH != null) {
                                sv2.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kSL.a((String) null, (WriteData) null);
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
    public void aI(int i, String str) {
        if (AntiHelper.bP(i, str)) {
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
            DX(str);
        } else {
            this.context.showToast(str);
        }
    }

    private void DX(String str) {
        if (str == null) {
            str = "";
        }
        if (this.context != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getPageActivity());
            aVar.Bp(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.image.a.c.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.context).btX();
        }
    }

    public void a(ImageUrlData imageUrlData, d dVar) {
        boolean z;
        h ss;
        JSONArray jSONArray;
        String str;
        if (imageUrlData != null && dVar != null) {
            if (this.kSI == null) {
                this.kSI = new b();
                this.kSI.ej(imageUrlData.forumName, imageUrlData.forumId);
            }
            if (imageUrlData.isFirstPost && this.kSK == null) {
                this.kSI.kSC = false;
                this.kSK = (a) this.kSI.fj(this.context.getPageActivity());
                this.kSM = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kSK.bEI().fDR, new b.InterfaceC0594b() { // from class: com.baidu.tieba.image.a.c.7
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0594b
                    public void kU(boolean z2) {
                        if (!z2) {
                            c.this.kSK.bEI().fDR.bEL();
                        } else {
                            c.this.kSK.bEI().fDR.setVisibility(0);
                        }
                    }
                });
                z = true;
            } else if (imageUrlData.isFirstPost || this.kSL != null) {
                z = false;
            } else {
                this.kSI.kSC = true;
                this.kSL = (a) this.kSI.fj(this.context.getPageActivity());
                this.kSN = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kSL.bEI().fDR, new b.InterfaceC0594b() { // from class: com.baidu.tieba.image.a.c.8
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0594b
                    public void kU(boolean z2) {
                        if (!z2) {
                            c.this.kSL.bEI().fDR.bEL();
                        } else {
                            c.this.kSL.bEI().fDR.setVisibility(0);
                        }
                    }
                });
                z = true;
            }
            this.kSJ = imageUrlData.isFirstPost ? this.kSK : this.kSL;
            if (z) {
                this.kSJ.a(this.context);
                this.kSJ.a(this.fGo);
                this.kSJ.a(this.fGi);
                this.kSJ.a(this.context, (Bundle) null);
                this.kSJ.a(dVar.jPU, (UserData) null);
                this.kSJ.kZ(dVar.kQM);
                this.kSJ.kRG = this.kRG;
                if (dVar.kQK == null) {
                    this.kSJ.setThreadId(imageUrlData.threadId + "");
                } else {
                    this.kSJ.a(dVar.kQK, imageUrlData.threadId + "", dVar.kQL);
                }
                if (imageUrlData.isFirstPost) {
                    this.kSJ.bFt();
                }
                this.kSJ.bEI().fDQ.setPadding(0, 0, 0, 0);
                this.kSJ.bEI().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                this.kSJ.bEI().onChangeSkinType(this.mSkinType);
            }
            if (this.kSO == null || imageUrlData.postId != this.kSO.postId) {
                if (this.kSO != null) {
                    this.kSJ.DR(this.kSO.threadId + "");
                }
                this.kSJ.bFC();
                this.kSJ.resetData();
                this.kSJ.kSC = !imageUrlData.isFirstPost;
                this.kSJ.postId = imageUrlData.postId + "";
                this.kSJ.kSD = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && this.kSJ.bEI() != null) {
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
                        this.kSJ.bEI().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                    }
                    jSONArray = null;
                    if (jSONArray != null) {
                    }
                    str = "";
                    this.kSJ.bEI().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                }
                this.replyPrivateFlag = dVar.replyPrivateFlag;
                this.fGe = dVar.fGe;
                if (this.kSJ.bEI() != null && !StringUtils.isNull(this.fGe) && (ss = this.kSJ.bEI().ss(6)) != null && !TextUtils.isEmpty(this.fGe)) {
                    ((View) ss).setOnClickListener(this.fGR);
                }
                this.kSJ.DS(imageUrlData.threadId + "");
            }
            if (this.kSO == null || this.kSO.isFirstPost != imageUrlData.isFirstPost) {
                if (this.kSJ.bEI() != null) {
                    this.kSH.removeAllViews();
                    this.kSH.addView(this.kSJ.bEI());
                }
                if (this.kSQ == null) {
                    this.kSQ = new ar();
                }
                if (this.kSJ.bFo() != null) {
                    this.kSQ.f(this.kSJ.bFo().getInputView());
                }
            }
            this.kSO = imageUrlData;
        }
    }

    public void b(ImageUrlData imageUrlData, d dVar) {
        if (this.kSR != null && imageUrlData != null && dVar != null && this.kSR.pZ(dVar.replyPrivateFlag)) {
            if (this.kSO == null || this.kSO.postId != imageUrlData.postId || this.kSJ == null) {
                a(imageUrlData, dVar);
            }
            if (this.kSJ != null) {
                if (this.kSJ.bFD() || this.kSJ.bFE()) {
                    this.kSJ.a(false, (PostWriteCallBackData) null);
                    return;
                }
                this.kSH.setVisibility(0);
                if (this.kSJ.bEI() != null) {
                    this.kSJ.bEI().rV();
                    this.kSJ.bEI().bDe();
                }
            }
        }
    }

    public void dcp() {
        if (this.kSJ != null && this.kSJ.bEI() != null) {
            this.kSJ.bEI().hide();
        }
        l.hideSoftKeyPad(this.context.getPageActivity(), this.kSH);
        this.kSH.setVisibility(8);
    }

    public void onPause() {
        if (this.kSO != null && this.kSJ != null) {
            this.kSJ.DR(this.kSO.threadId + "");
        }
    }

    public void onResume() {
        if (this.kSO != null && this.kSJ != null) {
            if (this.kSP) {
                this.kSP = false;
                return;
            }
            this.kSJ.bFC();
            this.kSJ.DS(this.kSO.threadId + "");
            this.kSJ.bEI().bDe();
        }
    }

    public void onDestroy() {
        if (this.kSR != null) {
            this.kSR.onDestroy();
        }
        if (this.kSM != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kSM);
        }
        if (this.kSN != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kSN);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kSJ != null) {
            this.kSJ.bEI().onChangeSkinType(i);
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }
}
