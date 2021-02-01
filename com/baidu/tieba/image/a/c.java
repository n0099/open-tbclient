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
    private String kVe;
    private LinearLayout kWf;
    private b kWg;
    private a kWh;
    private a kWi;
    private a kWj;
    ViewTreeObserver.OnGlobalLayoutListener kWk;
    ViewTreeObserver.OnGlobalLayoutListener kWl;
    private ImageUrlData kWm;
    public ar kWo;
    private am kWp;
    private int mSkinType;
    private int replyPrivateFlag;
    private boolean kWn = false;
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
            if (c.this.kWm == null) {
                return false;
            }
            if (c.this.kWo != null) {
                com.baidu.tieba.write.c drF = c.this.kWm.isFirstPost ? c.this.kWo.drF() : c.this.kWo.drG();
                if (drF != null && drF.dWp()) {
                    c.this.context.showToast(drF.dWr());
                    if (c.this.kWh != null && (c.this.kWh.bCc() || c.this.kWh.bCd())) {
                        c.this.kWh.a(false, c.this.kWo.drI());
                    }
                    if (c.this.kWm.isFirstPost) {
                        c.this.kWo.vQ(true);
                    } else {
                        c.this.kWo.vR(true);
                    }
                    return true;
                }
            }
            return !c.this.kWp.oy(c.this.replyPrivateFlag);
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
                c.this.daw();
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
                if (c.this.kWh != null && (c.this.kWh.bCc() || c.this.kWh.bCd())) {
                    c.this.kWh.a(false, postWriteCallBackData);
                    c.this.daw();
                }
                if (c.this.kWm.isFirstPost) {
                    c.this.kWo.h(postWriteCallBackData);
                } else {
                    c.this.kWo.i(postWriteCallBackData);
                }
            } else if (i == 238010) {
                if (!au.isEmpty(str)) {
                    c.this.context.showToast(str);
                } else {
                    c.this.context.showToast(R.string.message_privacy_fans_can_reply);
                }
                c.this.daw();
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
                c.this.daw();
            }
        }
    };

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        this.context = tbPageContext;
        this.kWf = linearLayout;
        this.kWf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.a.c.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    c.this.daw();
                    return true;
                }
                return true;
            }
        });
        this.kWf.setVisibility(8);
        this.kWp = new am(tbPageContext);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.kWn = true;
        if (this.kWh != null) {
            if (i == 25035) {
                d(i2, intent);
                daw();
                return;
            }
            this.kWh.onActivityResult(i, i2, intent);
        }
    }

    public void setFromForumId(String str) {
        this.kVe = str;
    }

    private void d(int i, Intent intent) {
        if (i == 0 && this.kWh != null) {
            this.kWh.bBh().bzD();
        } else {
            daw();
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
                        if (this.kWi != null) {
                            this.kWi.resetData();
                            this.kWi.setVoiceModel(pbEditorData.getVoiceModel());
                            this.kWi.c(writeData);
                            m qU = this.kWi.bBh().qU(6);
                            if (qU != null && qU.fBo != null) {
                                qU.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kWi.a((String) null, (WriteData) null);
                                return;
                            }
                            return;
                        }
                        return;
                    case 1:
                        if (this.kWj != null) {
                            this.kWj.c(writeData);
                            this.kWj.setVoiceModel(pbEditorData.getVoiceModel());
                            m qU2 = this.kWj.bBh().qU(6);
                            if (qU2 != null && qU2.fBo != null) {
                                qU2.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kWj.a((String) null, (WriteData) null);
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
            Dc(str);
        } else {
            this.context.showToast(str);
        }
    }

    private void Dc(String str) {
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
            if (this.kWg == null) {
                this.kWg = new b();
                this.kWg.eg(imageUrlData.forumName, imageUrlData.forumId);
            }
            if (imageUrlData.isFirstPost && this.kWi == null) {
                this.kWg.kWa = false;
                this.kWi = (a) this.kWg.fg(this.context.getPageActivity());
                this.kWk = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kWi.bBh().fBy, new b.InterfaceC0574b() { // from class: com.baidu.tieba.image.a.c.7
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0574b
                    public void kT(boolean z2) {
                        if (!z2) {
                            c.this.kWi.bBh().fBy.bBk();
                        } else {
                            c.this.kWi.bBh().fBy.setVisibility(0);
                        }
                    }
                });
                z = true;
            } else if (imageUrlData.isFirstPost || this.kWj != null) {
                z = false;
            } else {
                this.kWg.kWa = true;
                this.kWj = (a) this.kWg.fg(this.context.getPageActivity());
                this.kWl = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kWj.bBh().fBy, new b.InterfaceC0574b() { // from class: com.baidu.tieba.image.a.c.8
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0574b
                    public void kT(boolean z2) {
                        if (!z2) {
                            c.this.kWj.bBh().fBy.bBk();
                        } else {
                            c.this.kWj.bBh().fBy.setVisibility(0);
                        }
                    }
                });
                z = true;
            }
            this.kWh = imageUrlData.isFirstPost ? this.kWi : this.kWj;
            if (z) {
                this.kWh.a(this.context);
                this.kWh.a(this.fDW);
                this.kWh.a(this.fDP);
                this.kWh.a(this.context, (Bundle) null);
                this.kWh.a(dVar.jSl, (UserData) null);
                this.kWh.kY(dVar.kUk);
                this.kWh.bCg();
                this.kWh.kVe = this.kVe;
                if (dVar.kUi == null) {
                    this.kWh.setThreadId(imageUrlData.threadId + "");
                } else {
                    this.kWh.a(dVar.kUi, imageUrlData.threadId + "", dVar.kUj);
                }
                if (imageUrlData.isFirstPost) {
                    this.kWh.bBS();
                }
                this.kWh.bBh().fBx.setPadding(0, 0, 0, 0);
                this.kWh.bBh().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                this.kWh.bBh().onChangeSkinType(this.mSkinType);
            }
            if (this.kWm == null || imageUrlData.postId != this.kWm.postId) {
                if (this.kWm != null) {
                    this.kWh.CW(this.kWm.threadId + "");
                }
                this.kWh.bCb();
                this.kWh.resetData();
                this.kWh.kWa = !imageUrlData.isFirstPost;
                this.kWh.postId = imageUrlData.postId + "";
                this.kWh.kWb = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && this.kWh.bBh() != null) {
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
                        this.kWh.bBh().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                    }
                    jSONArray = null;
                    if (jSONArray != null) {
                    }
                    str = "";
                    this.kWh.bBh().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                }
                this.replyPrivateFlag = dVar.replyPrivateFlag;
                this.fDL = dVar.fDL;
                if (this.kWh.bBh() != null && !StringUtils.isNull(this.fDL) && (qR = this.kWh.bBh().qR(6)) != null && !TextUtils.isEmpty(this.fDL)) {
                    ((View) qR).setOnClickListener(this.fEx);
                }
                this.kWh.CX(imageUrlData.threadId + "");
            }
            if (this.kWm == null || this.kWm.isFirstPost != imageUrlData.isFirstPost) {
                if (this.kWh.bBh() != null) {
                    this.kWf.removeAllViews();
                    this.kWf.addView(this.kWh.bBh());
                }
                if (this.kWo == null) {
                    this.kWo = new ar();
                }
                if (this.kWh.bBN() != null) {
                    this.kWo.f(this.kWh.bBN().getInputView());
                }
            }
            this.kWm = imageUrlData;
        }
    }

    public void b(ImageUrlData imageUrlData, d dVar) {
        if (this.kWp != null && imageUrlData != null && dVar != null && this.kWp.ox(dVar.replyPrivateFlag)) {
            if (this.kWm == null || this.kWm.postId != imageUrlData.postId || this.kWh == null) {
                a(imageUrlData, dVar);
            }
            if (this.kWh != null) {
                if (this.kWh.bCc() || this.kWh.bCd()) {
                    this.kWh.a(false, (PostWriteCallBackData) null);
                    return;
                }
                this.kWf.setVisibility(0);
                if (this.kWh.bBh() != null) {
                    this.kWh.bBh().display();
                    this.kWh.bBh().bzD();
                }
            }
        }
    }

    public void daw() {
        if (this.kWh != null && this.kWh.bBh() != null) {
            this.kWh.bBh().hide();
        }
        l.hideSoftKeyPad(this.context.getPageActivity(), this.kWf);
        this.kWf.setVisibility(8);
    }

    public void onPause() {
        if (this.kWm != null && this.kWh != null) {
            this.kWh.CW(this.kWm.threadId + "");
        }
    }

    public void onResume() {
        if (this.kWm != null && this.kWh != null) {
            if (this.kWn) {
                this.kWn = false;
                return;
            }
            this.kWh.bCb();
            this.kWh.CX(this.kWm.threadId + "");
            this.kWh.bBh().bzD();
        }
    }

    public void onDestroy() {
        if (this.kWp != null) {
            this.kWp.onDestroy();
        }
        if (this.kWk != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kWk);
        }
        if (this.kWl != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kWl);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kWh != null) {
            this.kWh.bBh().onChangeSkinType(i);
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }
}
