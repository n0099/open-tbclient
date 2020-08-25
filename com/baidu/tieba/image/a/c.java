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
    private String eMt;
    private String jIE;
    private ImageUrlData jJA;
    public bb jJC;
    private am jJD;
    private LinearLayout jJv;
    private b jJw;
    private a jJx;
    private a jJy;
    private a jJz;
    private int replyPrivateFlag;
    private boolean jJB = false;
    private View.OnClickListener eNf = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(c.this.eMt)) {
                l.showToast(c.this.context.getPageActivity(), c.this.eMt);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b eMx = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.image.a.c.2
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean brU() {
            if (c.this.jJA == null) {
                return false;
            }
            if (c.this.jJC != null) {
                com.baidu.tieba.write.c dbE = c.this.jJA.isFirstPost ? c.this.jJC.dbE() : c.this.jJC.dbF();
                if (dbE != null && dbE.dFw()) {
                    c.this.context.showToast(dbE.dFy());
                    if (c.this.jJx != null && (c.this.jJx.bsl() || c.this.jJx.bsm())) {
                        c.this.jJx.a(false, c.this.jJC.dbH());
                    }
                    if (c.this.jJA.isFirstPost) {
                        c.this.jJC.tI(true);
                    } else {
                        c.this.jJC.tJ(true);
                    }
                    return true;
                }
            }
            return !c.this.jJD.nQ(c.this.replyPrivateFlag);
        }
    };
    private final NewWriteModel.d eMD = new NewWriteModel.d() { // from class: com.baidu.tieba.image.a.c.3
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                c.this.cLa();
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
                if (c.this.jJx != null && (c.this.jJx.bsl() || c.this.jJx.bsm())) {
                    c.this.jJx.a(false, postWriteCallBackData);
                    c.this.cLa();
                }
                if (c.this.jJA.isFirstPost) {
                    c.this.jJC.g(postWriteCallBackData);
                } else {
                    c.this.jJC.h(postWriteCallBackData);
                }
            } else if (i == 238010) {
                if (!at.isEmpty(str)) {
                    c.this.context.showToast(str);
                } else {
                    c.this.context.showToast(R.string.message_privacy_fans_can_reply);
                }
                c.this.cLa();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (!at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(c.this.context.getPageActivity(), postWriteCallBackData.getErrorString(), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(c.this.context.getPageActivity(), c.this.context.getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.context.getPageActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.zz(c.this.context.getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zz(postWriteCallBackData.getErrorString());
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
                c.this.cLa();
            }
        }
    };

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        this.context = tbPageContext;
        this.jJv = linearLayout;
        this.jJv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.a.c.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    c.this.cLa();
                    return true;
                }
                return true;
            }
        });
        this.jJv.setVisibility(8);
        this.jJD = new am(tbPageContext);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.jJB = true;
        if (this.jJx != null) {
            if (i == 25035) {
                d(i2, intent);
                cLa();
                return;
            }
            this.jJx.onActivityResult(i, i2, intent);
        }
    }

    public void setFromForumId(String str) {
        this.jIE = str;
    }

    private void d(int i, Intent intent) {
        if (i == 0 && this.jJx != null) {
            this.jJx.brv().bpX();
        } else {
            cLa();
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
                        if (this.jJy != null) {
                            this.jJy.resetData();
                            this.jJy.setVoiceModel(pbEditorData.getVoiceModel());
                            this.jJy.b(writeData);
                            m qe = this.jJy.brv().qe(6);
                            if (qe != null && qe.eKx != null) {
                                qe.eKx.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.jJy.a((String) null, (WriteData) null);
                                return;
                            }
                            return;
                        }
                        return;
                    case 1:
                        if (this.jJz != null) {
                            this.jJz.b(writeData);
                            this.jJz.setVoiceModel(pbEditorData.getVoiceModel());
                            m qe2 = this.jJz.brv().qe(6);
                            if (qe2 != null && qe2.eKx != null) {
                                qe2.eKx.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.jJz.a((String) null, (WriteData) null);
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
        if (AntiHelper.bz(i, str)) {
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
            Cd(str);
        } else {
            this.context.showToast(str);
        }
    }

    private void Cd(String str) {
        if (str == null) {
            str = "";
        }
        if (this.context != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getPageActivity());
            aVar.zz(str);
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
            if (this.jJw == null) {
                this.jJw = new b();
                this.jJw.dS(imageUrlData.forumName, imageUrlData.forumId);
            }
            if (imageUrlData.isFirstPost && this.jJy == null) {
                this.jJw.jJr = false;
                this.jJy = (a) this.jJw.ec(this.context.getPageActivity());
                z = true;
            } else if (imageUrlData.isFirstPost || this.jJz != null) {
                z = false;
            } else {
                this.jJw.jJr = true;
                this.jJz = (a) this.jJw.ec(this.context.getPageActivity());
                z = true;
            }
            this.jJx = imageUrlData.isFirstPost ? this.jJy : this.jJz;
            if (z) {
                this.jJx.a(this.context);
                this.jJx.a(this.eMD);
                this.jJx.a(this.eMx);
                this.jJx.a(this.context, (Bundle) null);
                this.jJx.a(eVar.iAy, (UserData) null);
                this.jJx.jo(eVar.jHN);
                this.jJx.jIE = this.jIE;
                if (eVar.jHL == null) {
                    this.jJx.setThreadId(imageUrlData.threadId + "");
                } else {
                    this.jJx.a(eVar.jHL, imageUrlData.threadId + "", eVar.jHM);
                }
                if (imageUrlData.isFirstPost) {
                    this.jJx.bsb();
                }
                this.jJx.brv().eKG.setPadding(0, 0, 0, 0);
                this.jJx.brv().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                this.jJx.brv().onChangeSkinType(0);
            }
            if (this.jJA == null || imageUrlData.postId != this.jJA.postId) {
                if (this.jJA != null) {
                    this.jJx.BX(this.jJA.threadId + "");
                }
                this.jJx.bsk();
                this.jJx.resetData();
                this.jJx.jJr = !imageUrlData.isFirstPost;
                this.jJx.postId = imageUrlData.postId + "";
                this.jJx.jJs = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && this.jJx.brv() != null) {
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
                        this.jJx.brv().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                    }
                    jSONArray = null;
                    if (jSONArray != null) {
                    }
                    str = "";
                    this.jJx.brv().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                }
                this.replyPrivateFlag = eVar.replyPrivateFlag;
                this.eMt = eVar.eMt;
                if (this.jJx.brv() != null && !StringUtils.isNull(this.eMt) && (qb = this.jJx.brv().qb(6)) != null && !TextUtils.isEmpty(this.eMt)) {
                    ((View) qb).setOnClickListener(this.eNf);
                }
                this.jJx.BY(imageUrlData.threadId + "");
            }
            if (this.jJA == null || this.jJA.isFirstPost != imageUrlData.isFirstPost) {
                if (this.jJx.brv() != null) {
                    this.jJv.removeAllViews();
                    this.jJv.addView(this.jJx.brv());
                }
                if (this.jJC == null) {
                    this.jJC = new bb();
                }
                if (this.jJx.brW() != null) {
                    this.jJC.f(this.jJx.brW().getInputView());
                }
            }
            this.jJA = imageUrlData;
        }
    }

    public void b(ImageUrlData imageUrlData, e eVar) {
        if (this.jJD != null && imageUrlData != null && eVar != null && this.jJD.nP(eVar.replyPrivateFlag)) {
            if (this.jJA == null || this.jJA.postId != imageUrlData.postId || this.jJx == null) {
                a(imageUrlData, eVar);
            }
            if (this.jJx != null) {
                if (this.jJx.bsl() || this.jJx.bsm()) {
                    this.jJx.a(false, (PostWriteCallBackData) null);
                    return;
                }
                this.jJv.setVisibility(0);
                if (this.jJx.brv() != null) {
                    this.jJx.brv().display();
                    this.jJx.brv().bpX();
                }
            }
        }
    }

    public void cLa() {
        if (this.jJx != null && this.jJx.brv() != null) {
            this.jJx.brv().hide();
        }
        l.hideSoftKeyPad(this.context.getPageActivity(), this.jJv);
        this.jJv.setVisibility(8);
    }

    public void onPause() {
        if (this.jJA != null && this.jJx != null) {
            this.jJx.BX(this.jJA.threadId + "");
        }
    }

    public void onResume() {
        if (this.jJA != null && this.jJx != null) {
            if (this.jJB) {
                this.jJB = false;
                return;
            }
            this.jJx.bsk();
            this.jJx.BY(this.jJA.threadId + "");
            this.jJx.brv().bpX();
        }
    }

    public void onDestroy() {
        if (this.jJD != null) {
            this.jJD.onDestroy();
        }
    }
}
