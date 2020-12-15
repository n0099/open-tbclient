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
    private String kMo;
    private LinearLayout kNd;
    private b kNe;
    private a kNf;
    private a kNg;
    private a kNh;
    ViewTreeObserver.OnGlobalLayoutListener kNi;
    ViewTreeObserver.OnGlobalLayoutListener kNj;
    private ImageUrlData kNk;
    public bb kNm;
    private am kNn;
    private int replyPrivateFlag;
    private boolean kNl = false;
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
            if (c.this.kNk == null) {
                return false;
            }
            if (c.this.kNm != null) {
                com.baidu.tieba.write.c dtt = c.this.kNk.isFirstPost ? c.this.kNm.dtt() : c.this.kNm.dtu();
                if (dtt != null && dtt.dYp()) {
                    c.this.context.showToast(dtt.dYr());
                    if (c.this.kNf != null && (c.this.kNf.bDi() || c.this.kNf.bDj())) {
                        c.this.kNf.a(false, c.this.kNm.dtw());
                    }
                    if (c.this.kNk.isFirstPost) {
                        c.this.kNm.vE(true);
                    } else {
                        c.this.kNm.vF(true);
                    }
                    return true;
                }
            }
            return !c.this.kNn.pQ(c.this.replyPrivateFlag);
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
                c.this.dcF();
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
                if (c.this.kNf != null && (c.this.kNf.bDi() || c.this.kNf.bDj())) {
                    c.this.kNf.a(false, postWriteCallBackData);
                    c.this.dcF();
                }
                if (c.this.kNk.isFirstPost) {
                    c.this.kNm.h(postWriteCallBackData);
                } else {
                    c.this.kNm.i(postWriteCallBackData);
                }
            } else if (i == 238010) {
                if (!au.isEmpty(str)) {
                    c.this.context.showToast(str);
                } else {
                    c.this.context.showToast(R.string.message_privacy_fans_can_reply);
                }
                c.this.dcF();
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
                c.this.dcF();
            }
        }
    };

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        this.context = tbPageContext;
        this.kNd = linearLayout;
        this.kNd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.a.c.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    c.this.dcF();
                    return true;
                }
                return true;
            }
        });
        this.kNd.setVisibility(8);
        this.kNn = new am(tbPageContext);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.kNl = true;
        if (this.kNf != null) {
            if (i == 25035) {
                d(i2, intent);
                dcF();
                return;
            }
            this.kNf.onActivityResult(i, i2, intent);
        }
    }

    public void setFromForumId(String str) {
        this.kMo = str;
    }

    private void d(int i, Intent intent) {
        if (i == 0 && this.kNf != null) {
            this.kNf.bCn().bAK();
        } else {
            dcF();
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
                        if (this.kNg != null) {
                            this.kNg.resetData();
                            this.kNg.setVoiceModel(pbEditorData.getVoiceModel());
                            this.kNg.b(writeData);
                            m sj = this.kNg.bCn().sj(6);
                            if (sj != null && sj.fub != null) {
                                sj.fub.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kNg.a((String) null, (WriteData) null);
                                return;
                            }
                            return;
                        }
                        return;
                    case 1:
                        if (this.kNh != null) {
                            this.kNh.b(writeData);
                            this.kNh.setVoiceModel(pbEditorData.getVoiceModel());
                            m sj2 = this.kNh.bCn().sj(6);
                            if (sj2 != null && sj2.fub != null) {
                                sj2.fub.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kNh.a((String) null, (WriteData) null);
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
            if (this.kNe == null) {
                this.kNe = new b();
                this.kNe.ek(imageUrlData.forumName, imageUrlData.forumId);
            }
            if (imageUrlData.isFirstPost && this.kNg == null) {
                this.kNe.kMZ = false;
                this.kNg = (a) this.kNe.eN(this.context.getPageActivity());
                this.kNi = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kNg.bCn().ful, new b.InterfaceC0603b() { // from class: com.baidu.tieba.image.a.c.7
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0603b
                    public void ky(boolean z2) {
                        if (!z2) {
                            c.this.kNg.bCn().ful.bCq();
                        } else {
                            c.this.kNg.bCn().ful.setVisibility(0);
                        }
                    }
                });
                z = true;
            } else if (imageUrlData.isFirstPost || this.kNh != null) {
                z = false;
            } else {
                this.kNe.kMZ = true;
                this.kNh = (a) this.kNe.eN(this.context.getPageActivity());
                this.kNj = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kNh.bCn().ful, new b.InterfaceC0603b() { // from class: com.baidu.tieba.image.a.c.8
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0603b
                    public void ky(boolean z2) {
                        if (!z2) {
                            c.this.kNh.bCn().ful.bCq();
                        } else {
                            c.this.kNh.bCn().ful.setVisibility(0);
                        }
                    }
                });
                z = true;
            }
            this.kNf = imageUrlData.isFirstPost ? this.kNg : this.kNh;
            if (z) {
                this.kNf.a(this.context);
                this.kNf.a(this.fwI);
                this.kNf.a(this.fwC);
                this.kNf.a(this.context, (Bundle) null);
                this.kNf.a(cVar.jDs, (UserData) null);
                this.kNf.kD(cVar.kLx);
                this.kNf.kMo = this.kMo;
                if (cVar.kLv == null) {
                    this.kNf.setThreadId(imageUrlData.threadId + "");
                } else {
                    this.kNf.a(cVar.kLv, imageUrlData.threadId + "", cVar.kLw);
                }
                if (imageUrlData.isFirstPost) {
                    this.kNf.bCY();
                }
                this.kNf.bCn().fuk.setPadding(0, 0, 0, 0);
                this.kNf.bCn().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                this.kNf.bCn().onChangeSkinType(0);
            }
            if (this.kNk == null || imageUrlData.postId != this.kNk.postId) {
                if (this.kNk != null) {
                    this.kNf.DU(this.kNk.threadId + "");
                }
                this.kNf.bDh();
                this.kNf.resetData();
                this.kNf.kMZ = !imageUrlData.isFirstPost;
                this.kNf.postId = imageUrlData.postId + "";
                this.kNf.kNa = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && this.kNf.bCn() != null) {
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
                        this.kNf.bCn().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                    }
                    jSONArray = null;
                    if (jSONArray != null) {
                    }
                    str = "";
                    this.kNf.bCn().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                }
                this.replyPrivateFlag = cVar.replyPrivateFlag;
                this.fwy = cVar.fwy;
                if (this.kNf.bCn() != null && !StringUtils.isNull(this.fwy) && (sg = this.kNf.bCn().sg(6)) != null && !TextUtils.isEmpty(this.fwy)) {
                    ((View) sg).setOnClickListener(this.fxl);
                }
                this.kNf.DV(imageUrlData.threadId + "");
            }
            if (this.kNk == null || this.kNk.isFirstPost != imageUrlData.isFirstPost) {
                if (this.kNf.bCn() != null) {
                    this.kNd.removeAllViews();
                    this.kNd.addView(this.kNf.bCn());
                }
                if (this.kNm == null) {
                    this.kNm = new bb();
                }
                if (this.kNf.bCT() != null) {
                    this.kNm.e(this.kNf.bCT().getInputView());
                }
            }
            this.kNk = imageUrlData;
        }
    }

    public void b(ImageUrlData imageUrlData, com.baidu.tieba.image.c cVar) {
        if (this.kNn != null && imageUrlData != null && cVar != null && this.kNn.pP(cVar.replyPrivateFlag)) {
            if (this.kNk == null || this.kNk.postId != imageUrlData.postId || this.kNf == null) {
                a(imageUrlData, cVar);
            }
            if (this.kNf != null) {
                if (this.kNf.bDi() || this.kNf.bDj()) {
                    this.kNf.a(false, (PostWriteCallBackData) null);
                    return;
                }
                this.kNd.setVisibility(0);
                if (this.kNf.bCn() != null) {
                    this.kNf.bCn().su();
                    this.kNf.bCn().bAK();
                }
            }
        }
    }

    public void dcF() {
        if (this.kNf != null && this.kNf.bCn() != null) {
            this.kNf.bCn().hide();
        }
        l.hideSoftKeyPad(this.context.getPageActivity(), this.kNd);
        this.kNd.setVisibility(8);
    }

    public void onPause() {
        if (this.kNk != null && this.kNf != null) {
            this.kNf.DU(this.kNk.threadId + "");
        }
    }

    public void onResume() {
        if (this.kNk != null && this.kNf != null) {
            if (this.kNl) {
                this.kNl = false;
                return;
            }
            this.kNf.bDh();
            this.kNf.DV(this.kNk.threadId + "");
            this.kNf.bCn().bAK();
        }
    }

    public void onDestroy() {
        if (this.kNn != null) {
            this.kNn.onDestroy();
        }
        if (this.kNi != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kNi);
        }
        if (this.kNj != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kNj);
        }
    }
}
