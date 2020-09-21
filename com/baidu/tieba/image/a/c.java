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
import com.baidu.tieba.image.e;
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
    private String ePo;
    private String jRm;
    private LinearLayout jSb;
    private b jSc;
    private a jSd;
    private a jSe;
    private a jSf;
    ViewTreeObserver.OnGlobalLayoutListener jSg;
    ViewTreeObserver.OnGlobalLayoutListener jSh;
    private ImageUrlData jSi;
    public bb jSk;
    private am jSl;
    private int replyPrivateFlag;
    private boolean jSj = false;
    private View.OnClickListener eQa = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(c.this.ePo)) {
                l.showToast(c.this.context.getPageActivity(), c.this.ePo);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b ePs = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.image.a.c.2
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bsZ() {
            if (c.this.jSi == null) {
                return false;
            }
            if (c.this.jSk != null) {
                com.baidu.tieba.write.c dfj = c.this.jSi.isFirstPost ? c.this.jSk.dfj() : c.this.jSk.dfk();
                if (dfj != null && dfj.dJz()) {
                    c.this.context.showToast(dfj.dJB());
                    if (c.this.jSd != null && (c.this.jSd.btq() || c.this.jSd.btr())) {
                        c.this.jSd.a(false, c.this.jSk.dfm());
                    }
                    if (c.this.jSi.isFirstPost) {
                        c.this.jSk.tR(true);
                    } else {
                        c.this.jSk.tS(true);
                    }
                    return true;
                }
            }
            return !c.this.jSl.oc(c.this.replyPrivateFlag);
        }
    };
    private final NewWriteModel.d ePy = new NewWriteModel.d() { // from class: com.baidu.tieba.image.a.c.3
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                c.this.cOH();
                if (c.this.context != null && (c.this.context.getPageActivity() instanceof BaseActivity)) {
                    ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                    showReplyInPbEvent.writeData = postWriteCallBackData;
                    showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                    ((BaseActivity) c.this.context.getPageActivity()).publishEvent(showReplyInPbEvent);
                }
                if (postWriteCallBackData != null) {
                    TiebaStatic.log(new aq("c13970").dF("tid", postWriteCallBackData.getThreadId()).dF("fid", writeData.getForumId()).dF("uid", TbadkCoreApplication.getCurrentAccount()).ai("obj_type", writeData.getType()));
                }
            } else if (i == 220015) {
                c.this.context.showToast(str);
                if (c.this.jSd != null && (c.this.jSd.btq() || c.this.jSd.btr())) {
                    c.this.jSd.a(false, postWriteCallBackData);
                    c.this.cOH();
                }
                if (c.this.jSi.isFirstPost) {
                    c.this.jSk.h(postWriteCallBackData);
                } else {
                    c.this.jSk.i(postWriteCallBackData);
                }
            } else if (i == 238010) {
                if (!at.isEmpty(str)) {
                    c.this.context.showToast(str);
                } else {
                    c.this.context.showToast(R.string.message_privacy_fans_can_reply);
                }
                c.this.cOH();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (!at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(c.this.context.getPageActivity(), postWriteCallBackData.getErrorString(), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(c.this.context.getPageActivity(), c.this.context.getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.context.getPageActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.zV(c.this.context.getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zV(postWriteCallBackData.getErrorString());
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
                aVar.b(c.this.context).bia();
                TiebaStatic.log(new aq("c13745").ai("obj_locate", 1).ai("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                c.this.ar(i, str);
                c.this.cOH();
            }
        }
    };

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        this.context = tbPageContext;
        this.jSb = linearLayout;
        this.jSb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.a.c.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    c.this.cOH();
                    return true;
                }
                return true;
            }
        });
        this.jSb.setVisibility(8);
        this.jSl = new am(tbPageContext);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.jSj = true;
        if (this.jSd != null) {
            if (i == 25035) {
                d(i2, intent);
                cOH();
                return;
            }
            this.jSd.onActivityResult(i, i2, intent);
        }
    }

    public void setFromForumId(String str) {
        this.jRm = str;
    }

    private void d(int i, Intent intent) {
        if (i == 0 && this.jSd != null) {
            this.jSd.bsv().bqS();
        } else {
            cOH();
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
                        if (this.jSe != null) {
                            this.jSe.resetData();
                            this.jSe.setVoiceModel(pbEditorData.getVoiceModel());
                            this.jSe.b(writeData);
                            m qr = this.jSe.bsv().qr(6);
                            if (qr != null && qr.eMS != null) {
                                qr.eMS.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.jSe.a((String) null, (WriteData) null);
                                return;
                            }
                            return;
                        }
                        return;
                    case 1:
                        if (this.jSf != null) {
                            this.jSf.b(writeData);
                            this.jSf.setVoiceModel(pbEditorData.getVoiceModel());
                            m qr2 = this.jSf.bsv().qr(6);
                            if (qr2 != null && qr2.eMS != null) {
                                qr2.eMS.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.jSf.a((String) null, (WriteData) null);
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
    public void ar(int i, String str) {
        if (AntiHelper.bC(i, str)) {
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
            CA(str);
        } else {
            this.context.showToast(str);
        }
    }

    private void CA(String str) {
        if (str == null) {
            str = "";
        }
        if (this.context != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getPageActivity());
            aVar.zV(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.image.a.c.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.context).bia();
        }
    }

    public void a(ImageUrlData imageUrlData, e eVar) {
        boolean z;
        h qo;
        JSONArray jSONArray;
        String str;
        if (imageUrlData != null && eVar != null) {
            if (this.jSc == null) {
                this.jSc = new b();
                this.jSc.dV(imageUrlData.forumName, imageUrlData.forumId);
            }
            if (imageUrlData.isFirstPost && this.jSe == null) {
                this.jSc.jRX = false;
                this.jSe = (a) this.jSc.eb(this.context.getPageActivity());
                this.jSg = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.jSe.bsv().eNc, new b.InterfaceC0548b() { // from class: com.baidu.tieba.image.a.c.7
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0548b
                    public void jm(boolean z2) {
                        if (!z2) {
                            c.this.jSe.bsv().eNc.bsy();
                        } else {
                            c.this.jSe.bsv().eNc.setVisibility(0);
                        }
                    }
                });
                z = true;
            } else if (imageUrlData.isFirstPost || this.jSf != null) {
                z = false;
            } else {
                this.jSc.jRX = true;
                this.jSf = (a) this.jSc.eb(this.context.getPageActivity());
                this.jSh = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.jSf.bsv().eNc, new b.InterfaceC0548b() { // from class: com.baidu.tieba.image.a.c.8
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0548b
                    public void jm(boolean z2) {
                        if (!z2) {
                            c.this.jSf.bsv().eNc.bsy();
                        } else {
                            c.this.jSf.bsv().eNc.setVisibility(0);
                        }
                    }
                });
                z = true;
            }
            this.jSd = imageUrlData.isFirstPost ? this.jSe : this.jSf;
            if (z) {
                this.jSd.a(this.context);
                this.jSd.a(this.ePy);
                this.jSd.a(this.ePs);
                this.jSd.a(this.context, (Bundle) null);
                this.jSd.a(eVar.iHZ, (UserData) null);
                this.jSd.jr(eVar.jQv);
                this.jSd.jRm = this.jRm;
                if (eVar.jQt == null) {
                    this.jSd.setThreadId(imageUrlData.threadId + "");
                } else {
                    this.jSd.a(eVar.jQt, imageUrlData.threadId + "", eVar.jQu);
                }
                if (imageUrlData.isFirstPost) {
                    this.jSd.btg();
                }
                this.jSd.bsv().eNb.setPadding(0, 0, 0, 0);
                this.jSd.bsv().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                this.jSd.bsv().onChangeSkinType(0);
            }
            if (this.jSi == null || imageUrlData.postId != this.jSi.postId) {
                if (this.jSi != null) {
                    this.jSd.Cu(this.jSi.threadId + "");
                }
                this.jSd.btp();
                this.jSd.resetData();
                this.jSd.jRX = !imageUrlData.isFirstPost;
                this.jSd.postId = imageUrlData.postId + "";
                this.jSd.jRY = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && this.jSd.bsv() != null) {
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
                        this.jSd.bsv().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                    }
                    jSONArray = null;
                    if (jSONArray != null) {
                    }
                    str = "";
                    this.jSd.bsv().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                }
                this.replyPrivateFlag = eVar.replyPrivateFlag;
                this.ePo = eVar.ePo;
                if (this.jSd.bsv() != null && !StringUtils.isNull(this.ePo) && (qo = this.jSd.bsv().qo(6)) != null && !TextUtils.isEmpty(this.ePo)) {
                    ((View) qo).setOnClickListener(this.eQa);
                }
                this.jSd.Cv(imageUrlData.threadId + "");
            }
            if (this.jSi == null || this.jSi.isFirstPost != imageUrlData.isFirstPost) {
                if (this.jSd.bsv() != null) {
                    this.jSb.removeAllViews();
                    this.jSb.addView(this.jSd.bsv());
                }
                if (this.jSk == null) {
                    this.jSk = new bb();
                }
                if (this.jSd.btb() != null) {
                    this.jSk.e(this.jSd.btb().getInputView());
                }
            }
            this.jSi = imageUrlData;
        }
    }

    public void b(ImageUrlData imageUrlData, e eVar) {
        if (this.jSl != null && imageUrlData != null && eVar != null && this.jSl.ob(eVar.replyPrivateFlag)) {
            if (this.jSi == null || this.jSi.postId != imageUrlData.postId || this.jSd == null) {
                a(imageUrlData, eVar);
            }
            if (this.jSd != null) {
                if (this.jSd.btq() || this.jSd.btr()) {
                    this.jSd.a(false, (PostWriteCallBackData) null);
                    return;
                }
                this.jSb.setVisibility(0);
                if (this.jSd.bsv() != null) {
                    this.jSd.bsv().display();
                    this.jSd.bsv().bqS();
                }
            }
        }
    }

    public void cOH() {
        if (this.jSd != null && this.jSd.bsv() != null) {
            this.jSd.bsv().hide();
        }
        l.hideSoftKeyPad(this.context.getPageActivity(), this.jSb);
        this.jSb.setVisibility(8);
    }

    public void onPause() {
        if (this.jSi != null && this.jSd != null) {
            this.jSd.Cu(this.jSi.threadId + "");
        }
    }

    public void onResume() {
        if (this.jSi != null && this.jSd != null) {
            if (this.jSj) {
                this.jSj = false;
                return;
            }
            this.jSd.btp();
            this.jSd.Cv(this.jSi.threadId + "");
            this.jSd.bsv().bqS();
        }
    }

    public void onDestroy() {
        if (this.jSl != null) {
            this.jSl.onDestroy();
        }
        if (this.jSg != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.jSg);
        }
        if (this.jSh != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.jSh);
        }
    }
}
