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
    private String fDL;
    private String kVs;
    private ImageUrlData kWA;
    public ar kWC;
    private am kWD;
    private LinearLayout kWt;
    private b kWu;
    private a kWv;
    private a kWw;
    private a kWx;
    ViewTreeObserver.OnGlobalLayoutListener kWy;
    ViewTreeObserver.OnGlobalLayoutListener kWz;
    private int mSkinType;
    private int replyPrivateFlag;
    private boolean kWB = false;
    private View.OnClickListener fEx = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(c.this.fDL)) {
                l.showToast(c.this.context.getPageActivity(), c.this.fDL);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b fDP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.image.a.c.2
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBL() {
            if (c.this.kWA == null) {
                return false;
            }
            if (c.this.kWC != null) {
                com.baidu.tieba.write.c drM = c.this.kWA.isFirstPost ? c.this.kWC.drM() : c.this.kWC.drN();
                if (drM != null && drM.dWx()) {
                    c.this.context.showToast(drM.dWz());
                    if (c.this.kWv != null && (c.this.kWv.bCc() || c.this.kWv.bCd())) {
                        c.this.kWv.a(false, c.this.kWC.drP());
                    }
                    if (c.this.kWA.isFirstPost) {
                        c.this.kWC.vQ(true);
                    } else {
                        c.this.kWC.vR(true);
                    }
                    return true;
                }
            }
            return !c.this.kWD.oy(c.this.replyPrivateFlag);
        }
    };
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.image.a.c.3
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                c.this.daD();
                if (c.this.context != null && (c.this.context.getPageActivity() instanceof BaseActivity)) {
                    ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                    showReplyInPbEvent.writeData = postWriteCallBackData;
                    showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                    ((BaseActivity) c.this.context.getPageActivity()).publishEvent(showReplyInPbEvent);
                }
                if (postWriteCallBackData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13970").dR("tid", postWriteCallBackData.getThreadId()).dR("fid", writeData.getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).ap("obj_type", writeData.getType()));
                }
            } else if (i == 220015) {
                c.this.context.showToast(str);
                if (c.this.kWv != null && (c.this.kWv.bCc() || c.this.kWv.bCd())) {
                    c.this.kWv.a(false, postWriteCallBackData);
                    c.this.daD();
                }
                if (c.this.kWA.isFirstPost) {
                    c.this.kWC.h(postWriteCallBackData);
                } else {
                    c.this.kWC.i(postWriteCallBackData);
                }
            } else if (i == 238010) {
                if (!au.isEmpty(str)) {
                    c.this.context.showToast(str);
                } else {
                    c.this.context.showToast(R.string.message_privacy_fans_can_reply);
                }
                c.this.daD();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (!au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(c.this.context.getPageActivity(), postWriteCallBackData.getErrorString(), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(c.this.context.getPageActivity(), c.this.context.getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.context.getPageActivity());
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Au(c.this.context.getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Au(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13746").ap("obj_locate", 1).ap("obj_type", 2));
                    }
                });
                aVar.b(c.this.context).bqx();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13745").ap("obj_locate", 1).ap("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                c.this.aN(i, str);
                c.this.daD();
            }
        }
    };

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        this.context = tbPageContext;
        this.kWt = linearLayout;
        this.kWt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.a.c.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    c.this.daD();
                    return true;
                }
                return true;
            }
        });
        this.kWt.setVisibility(8);
        this.kWD = new am(tbPageContext);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.kWB = true;
        if (this.kWv != null) {
            if (i == 25035) {
                d(i2, intent);
                daD();
                return;
            }
            this.kWv.onActivityResult(i, i2, intent);
        }
    }

    public void setFromForumId(String str) {
        this.kVs = str;
    }

    private void d(int i, Intent intent) {
        if (i == 0 && this.kWv != null) {
            this.kWv.bBh().bzD();
        } else {
            daD();
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
                        if (this.kWw != null) {
                            this.kWw.resetData();
                            this.kWw.setVoiceModel(pbEditorData.getVoiceModel());
                            this.kWw.c(writeData);
                            m qU = this.kWw.bBh().qU(6);
                            if (qU != null && qU.fBo != null) {
                                qU.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kWw.a((String) null, (WriteData) null);
                                return;
                            }
                            return;
                        }
                        return;
                    case 1:
                        if (this.kWx != null) {
                            this.kWx.c(writeData);
                            this.kWx.setVoiceModel(pbEditorData.getVoiceModel());
                            m qU2 = this.kWx.bBh().qU(6);
                            if (qU2 != null && qU2.fBo != null) {
                                qU2.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kWx.a((String) null, (WriteData) null);
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
    public void aN(int i, String str) {
        if (AntiHelper.bX(i, str)) {
            AntiHelper.a(this.context.getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.image.a.c.5
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_REPLY));
                }
            });
        } else if (i == 230277) {
            Da(str);
        } else {
            this.context.showToast(str);
        }
    }

    private void Da(String str) {
        if (str == null) {
            str = "";
        }
        if (this.context != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getPageActivity());
            aVar.Au(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.image.a.c.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.context).bqx();
        }
    }

    public void a(ImageUrlData imageUrlData, d dVar) {
        boolean z;
        h qR;
        JSONArray jSONArray;
        String str;
        if (imageUrlData != null && dVar != null) {
            if (this.kWu == null) {
                this.kWu = new b();
                this.kWu.eg(imageUrlData.forumName, imageUrlData.forumId);
            }
            if (imageUrlData.isFirstPost && this.kWw == null) {
                this.kWu.kWo = false;
                this.kWw = (a) this.kWu.fg(this.context.getPageActivity());
                this.kWy = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kWw.bBh().fBy, new b.InterfaceC0574b() { // from class: com.baidu.tieba.image.a.c.7
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0574b
                    public void kT(boolean z2) {
                        if (!z2) {
                            c.this.kWw.bBh().fBy.bBk();
                        } else {
                            c.this.kWw.bBh().fBy.setVisibility(0);
                        }
                    }
                });
                z = true;
            } else if (imageUrlData.isFirstPost || this.kWx != null) {
                z = false;
            } else {
                this.kWu.kWo = true;
                this.kWx = (a) this.kWu.fg(this.context.getPageActivity());
                this.kWz = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kWx.bBh().fBy, new b.InterfaceC0574b() { // from class: com.baidu.tieba.image.a.c.8
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0574b
                    public void kT(boolean z2) {
                        if (!z2) {
                            c.this.kWx.bBh().fBy.bBk();
                        } else {
                            c.this.kWx.bBh().fBy.setVisibility(0);
                        }
                    }
                });
                z = true;
            }
            this.kWv = imageUrlData.isFirstPost ? this.kWw : this.kWx;
            if (z) {
                this.kWv.a(this.context);
                this.kWv.a(this.fDW);
                this.kWv.a(this.fDP);
                this.kWv.a(this.context, (Bundle) null);
                this.kWv.a(dVar.jSz, (UserData) null);
                this.kWv.kY(dVar.kUy);
                this.kWv.bCg();
                this.kWv.kVs = this.kVs;
                if (dVar.kUw == null) {
                    this.kWv.setThreadId(imageUrlData.threadId + "");
                } else {
                    this.kWv.a(dVar.kUw, imageUrlData.threadId + "", dVar.kUx);
                }
                if (imageUrlData.isFirstPost) {
                    this.kWv.bBS();
                }
                this.kWv.bBh().fBx.setPadding(0, 0, 0, 0);
                this.kWv.bBh().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                this.kWv.bBh().onChangeSkinType(this.mSkinType);
            }
            if (this.kWA == null || imageUrlData.postId != this.kWA.postId) {
                if (this.kWA != null) {
                    this.kWv.CU(this.kWA.threadId + "");
                }
                this.kWv.bCb();
                this.kWv.resetData();
                this.kWv.kWo = !imageUrlData.isFirstPost;
                this.kWv.postId = imageUrlData.postId + "";
                this.kWv.kWp = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && this.kWv.bBh() != null) {
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
                        this.kWv.bBh().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                    }
                    jSONArray = null;
                    if (jSONArray != null) {
                    }
                    str = "";
                    this.kWv.bBh().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                }
                this.replyPrivateFlag = dVar.replyPrivateFlag;
                this.fDL = dVar.fDL;
                if (this.kWv.bBh() != null && !StringUtils.isNull(this.fDL) && (qR = this.kWv.bBh().qR(6)) != null && !TextUtils.isEmpty(this.fDL)) {
                    ((View) qR).setOnClickListener(this.fEx);
                }
                this.kWv.CV(imageUrlData.threadId + "");
            }
            if (this.kWA == null || this.kWA.isFirstPost != imageUrlData.isFirstPost) {
                if (this.kWv.bBh() != null) {
                    this.kWt.removeAllViews();
                    this.kWt.addView(this.kWv.bBh());
                }
                if (this.kWC == null) {
                    this.kWC = new ar();
                }
                if (this.kWv.bBN() != null) {
                    this.kWC.f(this.kWv.bBN().getInputView());
                }
            }
            this.kWA = imageUrlData;
        }
    }

    public void b(ImageUrlData imageUrlData, d dVar) {
        if (this.kWD != null && imageUrlData != null && dVar != null && this.kWD.ox(dVar.replyPrivateFlag)) {
            if (this.kWA == null || this.kWA.postId != imageUrlData.postId || this.kWv == null) {
                a(imageUrlData, dVar);
            }
            if (this.kWv != null) {
                if (this.kWv.bCc() || this.kWv.bCd()) {
                    this.kWv.a(false, (PostWriteCallBackData) null);
                    return;
                }
                this.kWt.setVisibility(0);
                if (this.kWv.bBh() != null) {
                    this.kWv.bBh().display();
                    this.kWv.bBh().bzD();
                }
            }
        }
    }

    public void daD() {
        if (this.kWv != null && this.kWv.bBh() != null) {
            this.kWv.bBh().hide();
        }
        l.hideSoftKeyPad(this.context.getPageActivity(), this.kWt);
        this.kWt.setVisibility(8);
    }

    public void onPause() {
        if (this.kWA != null && this.kWv != null) {
            this.kWv.CU(this.kWA.threadId + "");
        }
    }

    public void onResume() {
        if (this.kWA != null && this.kWv != null) {
            if (this.kWB) {
                this.kWB = false;
                return;
            }
            this.kWv.bCb();
            this.kWv.CV(this.kWA.threadId + "");
            this.kWv.bBh().bzD();
        }
    }

    public void onDestroy() {
        if (this.kWD != null) {
            this.kWD.onDestroy();
        }
        if (this.kWy != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kWy);
        }
        if (this.kWz != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kWz);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kWv != null) {
            this.kWv.bBh().onChangeSkinType(i);
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }
}
