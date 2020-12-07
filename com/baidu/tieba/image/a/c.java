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
/* loaded from: classes21.dex */
public class c {
    private TbPageContext context;
    private String fwy;
    private String kMm;
    private LinearLayout kNb;
    private b kNc;
    private a kNd;
    private a kNe;
    private a kNf;
    ViewTreeObserver.OnGlobalLayoutListener kNg;
    ViewTreeObserver.OnGlobalLayoutListener kNh;
    private ImageUrlData kNi;
    public bb kNk;
    private am kNl;
    private int replyPrivateFlag;
    private boolean kNj = false;
    private View.OnClickListener fxl = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(c.this.fwy)) {
                l.showToast(c.this.context.getPageActivity(), c.this.fwy);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b fwC = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.image.a.c.2
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bCR() {
            if (c.this.kNi == null) {
                return false;
            }
            if (c.this.kNk != null) {
                com.baidu.tieba.write.c dts = c.this.kNi.isFirstPost ? c.this.kNk.dts() : c.this.kNk.dtt();
                if (dts != null && dts.dYo()) {
                    c.this.context.showToast(dts.dYq());
                    if (c.this.kNd != null && (c.this.kNd.bDi() || c.this.kNd.bDj())) {
                        c.this.kNd.a(false, c.this.kNk.dtv());
                    }
                    if (c.this.kNi.isFirstPost) {
                        c.this.kNk.vE(true);
                    } else {
                        c.this.kNk.vF(true);
                    }
                    return true;
                }
            }
            return !c.this.kNl.pQ(c.this.replyPrivateFlag);
        }
    };
    private final NewWriteModel.d fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.image.a.c.3
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                c.this.dcE();
                if (c.this.context != null && (c.this.context.getPageActivity() instanceof BaseActivity)) {
                    ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                    showReplyInPbEvent.writeData = postWriteCallBackData;
                    showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                    ((BaseActivity) c.this.context.getPageActivity()).publishEvent(showReplyInPbEvent);
                }
                if (postWriteCallBackData != null) {
                    TiebaStatic.log(new ar("c13970").dY("tid", postWriteCallBackData.getThreadId()).dY("fid", writeData.getForumId()).dY("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_type", writeData.getType()));
                }
            } else if (i == 220015) {
                c.this.context.showToast(str);
                if (c.this.kNd != null && (c.this.kNd.bDi() || c.this.kNd.bDj())) {
                    c.this.kNd.a(false, postWriteCallBackData);
                    c.this.dcE();
                }
                if (c.this.kNi.isFirstPost) {
                    c.this.kNk.h(postWriteCallBackData);
                } else {
                    c.this.kNk.i(postWriteCallBackData);
                }
            } else if (i == 238010) {
                if (!au.isEmpty(str)) {
                    c.this.context.showToast(str);
                } else {
                    c.this.context.showToast(R.string.message_privacy_fans_can_reply);
                }
                c.this.dcE();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (!au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(c.this.context.getPageActivity(), postWriteCallBackData.getErrorString(), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(c.this.context.getPageActivity(), c.this.context.getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.context.getPageActivity());
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Bq(c.this.context.getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bq(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new ar("c13746").al("obj_locate", 1).al("obj_type", 2));
                    }
                });
                aVar.b(c.this.context).brv();
                TiebaStatic.log(new ar("c13745").al("obj_locate", 1).al("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                c.this.aG(i, str);
                c.this.dcE();
            }
        }
    };

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        this.context = tbPageContext;
        this.kNb = linearLayout;
        this.kNb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.a.c.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    c.this.dcE();
                    return true;
                }
                return true;
            }
        });
        this.kNb.setVisibility(8);
        this.kNl = new am(tbPageContext);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.kNj = true;
        if (this.kNd != null) {
            if (i == 25035) {
                d(i2, intent);
                dcE();
                return;
            }
            this.kNd.onActivityResult(i, i2, intent);
        }
    }

    public void setFromForumId(String str) {
        this.kMm = str;
    }

    private void d(int i, Intent intent) {
        if (i == 0 && this.kNd != null) {
            this.kNd.bCn().bAK();
        } else {
            dcE();
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
                        if (this.kNe != null) {
                            this.kNe.resetData();
                            this.kNe.setVoiceModel(pbEditorData.getVoiceModel());
                            this.kNe.b(writeData);
                            m sj = this.kNe.bCn().sj(6);
                            if (sj != null && sj.fub != null) {
                                sj.fub.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kNe.a((String) null, (WriteData) null);
                                return;
                            }
                            return;
                        }
                        return;
                    case 1:
                        if (this.kNf != null) {
                            this.kNf.b(writeData);
                            this.kNf.setVoiceModel(pbEditorData.getVoiceModel());
                            m sj2 = this.kNf.bCn().sj(6);
                            if (sj2 != null && sj2.fub != null) {
                                sj2.fub.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kNf.a((String) null, (WriteData) null);
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
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_REPLY));
                }
            });
        } else if (i == 230277) {
            Ea(str);
        } else {
            this.context.showToast(str);
        }
    }

    private void Ea(String str) {
        if (str == null) {
            str = "";
        }
        if (this.context != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getPageActivity());
            aVar.Bq(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.image.a.c.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.context).brv();
        }
    }

    public void a(ImageUrlData imageUrlData, com.baidu.tieba.image.c cVar) {
        boolean z;
        h sg;
        JSONArray jSONArray;
        String str;
        if (imageUrlData != null && cVar != null) {
            if (this.kNc == null) {
                this.kNc = new b();
                this.kNc.ek(imageUrlData.forumName, imageUrlData.forumId);
            }
            if (imageUrlData.isFirstPost && this.kNe == null) {
                this.kNc.kMX = false;
                this.kNe = (a) this.kNc.eN(this.context.getPageActivity());
                this.kNg = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kNe.bCn().ful, new b.InterfaceC0603b() { // from class: com.baidu.tieba.image.a.c.7
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0603b
                    public void ky(boolean z2) {
                        if (!z2) {
                            c.this.kNe.bCn().ful.bCq();
                        } else {
                            c.this.kNe.bCn().ful.setVisibility(0);
                        }
                    }
                });
                z = true;
            } else if (imageUrlData.isFirstPost || this.kNf != null) {
                z = false;
            } else {
                this.kNc.kMX = true;
                this.kNf = (a) this.kNc.eN(this.context.getPageActivity());
                this.kNh = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kNf.bCn().ful, new b.InterfaceC0603b() { // from class: com.baidu.tieba.image.a.c.8
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0603b
                    public void ky(boolean z2) {
                        if (!z2) {
                            c.this.kNf.bCn().ful.bCq();
                        } else {
                            c.this.kNf.bCn().ful.setVisibility(0);
                        }
                    }
                });
                z = true;
            }
            this.kNd = imageUrlData.isFirstPost ? this.kNe : this.kNf;
            if (z) {
                this.kNd.a(this.context);
                this.kNd.a(this.fwI);
                this.kNd.a(this.fwC);
                this.kNd.a(this.context, (Bundle) null);
                this.kNd.a(cVar.jDq, (UserData) null);
                this.kNd.kD(cVar.kLv);
                this.kNd.kMm = this.kMm;
                if (cVar.kLt == null) {
                    this.kNd.setThreadId(imageUrlData.threadId + "");
                } else {
                    this.kNd.a(cVar.kLt, imageUrlData.threadId + "", cVar.kLu);
                }
                if (imageUrlData.isFirstPost) {
                    this.kNd.bCY();
                }
                this.kNd.bCn().fuk.setPadding(0, 0, 0, 0);
                this.kNd.bCn().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                this.kNd.bCn().onChangeSkinType(0);
            }
            if (this.kNi == null || imageUrlData.postId != this.kNi.postId) {
                if (this.kNi != null) {
                    this.kNd.DU(this.kNi.threadId + "");
                }
                this.kNd.bDh();
                this.kNd.resetData();
                this.kNd.kMX = !imageUrlData.isFirstPost;
                this.kNd.postId = imageUrlData.postId + "";
                this.kNd.kMY = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && this.kNd.bCn() != null) {
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
                        this.kNd.bCn().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                    }
                    jSONArray = null;
                    if (jSONArray != null) {
                    }
                    str = "";
                    this.kNd.bCn().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                }
                this.replyPrivateFlag = cVar.replyPrivateFlag;
                this.fwy = cVar.fwy;
                if (this.kNd.bCn() != null && !StringUtils.isNull(this.fwy) && (sg = this.kNd.bCn().sg(6)) != null && !TextUtils.isEmpty(this.fwy)) {
                    ((View) sg).setOnClickListener(this.fxl);
                }
                this.kNd.DV(imageUrlData.threadId + "");
            }
            if (this.kNi == null || this.kNi.isFirstPost != imageUrlData.isFirstPost) {
                if (this.kNd.bCn() != null) {
                    this.kNb.removeAllViews();
                    this.kNb.addView(this.kNd.bCn());
                }
                if (this.kNk == null) {
                    this.kNk = new bb();
                }
                if (this.kNd.bCT() != null) {
                    this.kNk.e(this.kNd.bCT().getInputView());
                }
            }
            this.kNi = imageUrlData;
        }
    }

    public void b(ImageUrlData imageUrlData, com.baidu.tieba.image.c cVar) {
        if (this.kNl != null && imageUrlData != null && cVar != null && this.kNl.pP(cVar.replyPrivateFlag)) {
            if (this.kNi == null || this.kNi.postId != imageUrlData.postId || this.kNd == null) {
                a(imageUrlData, cVar);
            }
            if (this.kNd != null) {
                if (this.kNd.bDi() || this.kNd.bDj()) {
                    this.kNd.a(false, (PostWriteCallBackData) null);
                    return;
                }
                this.kNb.setVisibility(0);
                if (this.kNd.bCn() != null) {
                    this.kNd.bCn().su();
                    this.kNd.bCn().bAK();
                }
            }
        }
    }

    public void dcE() {
        if (this.kNd != null && this.kNd.bCn() != null) {
            this.kNd.bCn().hide();
        }
        l.hideSoftKeyPad(this.context.getPageActivity(), this.kNb);
        this.kNb.setVisibility(8);
    }

    public void onPause() {
        if (this.kNi != null && this.kNd != null) {
            this.kNd.DU(this.kNi.threadId + "");
        }
    }

    public void onResume() {
        if (this.kNi != null && this.kNd != null) {
            if (this.kNj) {
                this.kNj = false;
                return;
            }
            this.kNd.bDh();
            this.kNd.DV(this.kNi.threadId + "");
            this.kNd.bCn().bAK();
        }
    }

    public void onDestroy() {
        if (this.kNl != null) {
            this.kNl.onDestroy();
        }
        if (this.kNg != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kNg);
        }
        if (this.kNh != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kNh);
        }
    }
}
