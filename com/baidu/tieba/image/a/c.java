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
/* loaded from: classes7.dex */
public class c {
    private TbPageContext context;
    private String fFk;
    private String kXu;
    ViewTreeObserver.OnGlobalLayoutListener kYA;
    ViewTreeObserver.OnGlobalLayoutListener kYB;
    private ImageUrlData kYC;
    public ar kYE;
    private am kYF;
    private LinearLayout kYv;
    private b kYw;
    private a kYx;
    private a kYy;
    private a kYz;
    private int mSkinType;
    private int replyPrivateFlag;
    private boolean kYD = false;
    private View.OnClickListener fFW = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(c.this.fFk)) {
                l.showToast(c.this.context.getPageActivity(), c.this.fFk);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b fFo = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.image.a.c.2
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBO() {
            if (c.this.kYC == null) {
                return false;
            }
            if (c.this.kYE != null) {
                com.baidu.tieba.write.c drV = c.this.kYC.isFirstPost ? c.this.kYE.drV() : c.this.kYE.drW();
                if (drV != null && drV.dWF()) {
                    c.this.context.showToast(drV.dWH());
                    if (c.this.kYx != null && (c.this.kYx.bCf() || c.this.kYx.bCg())) {
                        c.this.kYx.a(false, c.this.kYE.drY());
                    }
                    if (c.this.kYC.isFirstPost) {
                        c.this.kYE.vQ(true);
                    } else {
                        c.this.kYE.vR(true);
                    }
                    return true;
                }
            }
            return !c.this.kYF.oz(c.this.replyPrivateFlag);
        }
    };
    private final NewWriteModel.d fFv = new NewWriteModel.d() { // from class: com.baidu.tieba.image.a.c.3
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                c.this.daM();
                if (c.this.context != null && (c.this.context.getPageActivity() instanceof BaseActivity)) {
                    ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                    showReplyInPbEvent.writeData = postWriteCallBackData;
                    showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                    ((BaseActivity) c.this.context.getPageActivity()).publishEvent(showReplyInPbEvent);
                }
                if (postWriteCallBackData != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13970").dR("tid", postWriteCallBackData.getThreadId()).dR("fid", writeData.getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).aq("obj_type", writeData.getType()));
                }
            } else if (i == 220015) {
                c.this.context.showToast(str);
                if (c.this.kYx != null && (c.this.kYx.bCf() || c.this.kYx.bCg())) {
                    c.this.kYx.a(false, postWriteCallBackData);
                    c.this.daM();
                }
                if (c.this.kYC.isFirstPost) {
                    c.this.kYE.h(postWriteCallBackData);
                } else {
                    c.this.kYE.i(postWriteCallBackData);
                }
            } else if (i == 238010) {
                if (!au.isEmpty(str)) {
                    c.this.context.showToast(str);
                } else {
                    c.this.context.showToast(R.string.message_privacy_fans_can_reply);
                }
                c.this.daM();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (!au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(c.this.context.getPageActivity(), postWriteCallBackData.getErrorString(), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(c.this.context.getPageActivity(), c.this.context.getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.context.getPageActivity());
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.AB(c.this.context.getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AB(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13746").aq("obj_locate", 1).aq("obj_type", 2));
                    }
                });
                aVar.b(c.this.context).bqz();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13745").aq("obj_locate", 1).aq("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                c.this.aN(i, str);
                c.this.daM();
            }
        }
    };

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        this.context = tbPageContext;
        this.kYv = linearLayout;
        this.kYv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.a.c.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    c.this.daM();
                    return true;
                }
                return true;
            }
        });
        this.kYv.setVisibility(8);
        this.kYF = new am(tbPageContext);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.kYD = true;
        if (this.kYx != null) {
            if (i == 25035) {
                d(i2, intent);
                daM();
                return;
            }
            this.kYx.onActivityResult(i, i2, intent);
        }
    }

    public void setFromForumId(String str) {
        this.kXu = str;
    }

    private void d(int i, Intent intent) {
        if (i == 0 && this.kYx != null) {
            this.kYx.bBk().bzG();
        } else {
            daM();
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
                        if (this.kYy != null) {
                            this.kYy.resetData();
                            this.kYy.setVoiceModel(pbEditorData.getVoiceModel());
                            this.kYy.c(writeData);
                            m qV = this.kYy.bBk().qV(6);
                            if (qV != null && qV.fCN != null) {
                                qV.fCN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kYy.a((String) null, (WriteData) null);
                                return;
                            }
                            return;
                        }
                        return;
                    case 1:
                        if (this.kYz != null) {
                            this.kYz.c(writeData);
                            this.kYz.setVoiceModel(pbEditorData.getVoiceModel());
                            m qV2 = this.kYz.bBk().qV(6);
                            if (qV2 != null && qV2.fCN != null) {
                                qV2.fCN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kYz.a((String) null, (WriteData) null);
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
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aq("obj_locate", ay.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aq("obj_locate", ay.a.LOCATE_REPLY));
                }
            });
        } else if (i == 230277) {
            Dh(str);
        } else {
            this.context.showToast(str);
        }
    }

    private void Dh(String str) {
        if (str == null) {
            str = "";
        }
        if (this.context != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getPageActivity());
            aVar.AB(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.image.a.c.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.context).bqz();
        }
    }

    public void a(ImageUrlData imageUrlData, d dVar) {
        boolean z;
        h qS;
        JSONArray jSONArray;
        String str;
        if (imageUrlData != null && dVar != null) {
            if (this.kYw == null) {
                this.kYw = new b();
                this.kYw.eg(imageUrlData.forumName, imageUrlData.forumId);
            }
            if (imageUrlData.isFirstPost && this.kYy == null) {
                this.kYw.kYq = false;
                this.kYy = (a) this.kYw.ff(this.context.getPageActivity());
                this.kYA = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kYy.bBk().fCX, new b.InterfaceC0580b() { // from class: com.baidu.tieba.image.a.c.7
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0580b
                    public void kT(boolean z2) {
                        if (!z2) {
                            c.this.kYy.bBk().fCX.bBn();
                        } else {
                            c.this.kYy.bBk().fCX.setVisibility(0);
                        }
                    }
                });
                z = true;
            } else if (imageUrlData.isFirstPost || this.kYz != null) {
                z = false;
            } else {
                this.kYw.kYq = true;
                this.kYz = (a) this.kYw.ff(this.context.getPageActivity());
                this.kYB = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kYz.bBk().fCX, new b.InterfaceC0580b() { // from class: com.baidu.tieba.image.a.c.8
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0580b
                    public void kT(boolean z2) {
                        if (!z2) {
                            c.this.kYz.bBk().fCX.bBn();
                        } else {
                            c.this.kYz.bBk().fCX.setVisibility(0);
                        }
                    }
                });
                z = true;
            }
            this.kYx = imageUrlData.isFirstPost ? this.kYy : this.kYz;
            if (z) {
                this.kYx.a(this.context);
                this.kYx.a(this.fFv);
                this.kYx.a(this.fFo);
                this.kYx.a(this.context, (Bundle) null);
                this.kYx.a(dVar.jUi, (UserData) null);
                this.kYx.kY(dVar.kWA);
                this.kYx.bCj();
                this.kYx.kXu = this.kXu;
                if (dVar.kWy == null) {
                    this.kYx.setThreadId(imageUrlData.threadId + "");
                } else {
                    this.kYx.a(dVar.kWy, imageUrlData.threadId + "", dVar.kWz);
                }
                if (imageUrlData.isFirstPost) {
                    this.kYx.bBV();
                }
                this.kYx.bBk().fCW.setPadding(0, 0, 0, 0);
                this.kYx.bBk().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                this.kYx.bBk().onChangeSkinType(this.mSkinType);
            }
            if (this.kYC == null || imageUrlData.postId != this.kYC.postId) {
                if (this.kYC != null) {
                    this.kYx.Db(this.kYC.threadId + "");
                }
                this.kYx.bCe();
                this.kYx.resetData();
                this.kYx.kYq = !imageUrlData.isFirstPost;
                this.kYx.postId = imageUrlData.postId + "";
                this.kYx.kYr = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && this.kYx.bBk() != null) {
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
                        this.kYx.bBk().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                    }
                    jSONArray = null;
                    if (jSONArray != null) {
                    }
                    str = "";
                    this.kYx.bBk().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                }
                this.replyPrivateFlag = dVar.replyPrivateFlag;
                this.fFk = dVar.fFk;
                if (this.kYx.bBk() != null && !StringUtils.isNull(this.fFk) && (qS = this.kYx.bBk().qS(6)) != null && !TextUtils.isEmpty(this.fFk)) {
                    ((View) qS).setOnClickListener(this.fFW);
                }
                this.kYx.Dc(imageUrlData.threadId + "");
            }
            if (this.kYC == null || this.kYC.isFirstPost != imageUrlData.isFirstPost) {
                if (this.kYx.bBk() != null) {
                    this.kYv.removeAllViews();
                    this.kYv.addView(this.kYx.bBk());
                }
                if (this.kYE == null) {
                    this.kYE = new ar();
                }
                if (this.kYx.bBQ() != null) {
                    this.kYE.f(this.kYx.bBQ().getInputView());
                }
            }
            this.kYC = imageUrlData;
        }
    }

    public void b(ImageUrlData imageUrlData, d dVar) {
        if (this.kYF != null && imageUrlData != null && dVar != null && this.kYF.oy(dVar.replyPrivateFlag)) {
            if (this.kYC == null || this.kYC.postId != imageUrlData.postId || this.kYx == null) {
                a(imageUrlData, dVar);
            }
            if (this.kYx != null) {
                if (this.kYx.bCf() || this.kYx.bCg()) {
                    this.kYx.a(false, (PostWriteCallBackData) null);
                    return;
                }
                this.kYv.setVisibility(0);
                if (this.kYx.bBk() != null) {
                    this.kYx.bBk().display();
                    this.kYx.bBk().bzG();
                }
            }
        }
    }

    public void daM() {
        if (this.kYx != null && this.kYx.bBk() != null) {
            this.kYx.bBk().hide();
        }
        l.hideSoftKeyPad(this.context.getPageActivity(), this.kYv);
        this.kYv.setVisibility(8);
    }

    public void onPause() {
        if (this.kYC != null && this.kYx != null) {
            this.kYx.Db(this.kYC.threadId + "");
        }
    }

    public void onResume() {
        if (this.kYC != null && this.kYx != null) {
            if (this.kYD) {
                this.kYD = false;
                return;
            }
            this.kYx.bCe();
            this.kYx.Dc(this.kYC.threadId + "");
            this.kYx.bBk().bzG();
        }
    }

    public void onDestroy() {
        if (this.kYF != null) {
            this.kYF.onDestroy();
        }
        if (this.kYA != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kYA);
        }
        if (this.kYB != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kYB);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kYx != null) {
            this.kYx.bBk().onChangeSkinType(i);
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }
}
