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
/* loaded from: classes21.dex */
public class c {
    private TbPageContext context;
    private String fpM;
    private String kyF;
    ViewTreeObserver.OnGlobalLayoutListener kzA;
    private ImageUrlData kzB;
    public bb kzD;
    private am kzE;
    private LinearLayout kzu;
    private b kzv;
    private a kzw;
    private a kzx;
    private a kzy;
    ViewTreeObserver.OnGlobalLayoutListener kzz;
    private int replyPrivateFlag;
    private boolean kzC = false;
    private View.OnClickListener fqy = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(c.this.fpM)) {
                l.showToast(c.this.context.getPageActivity(), c.this.fpM);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b fpQ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.image.a.c.2
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bAb() {
            if (c.this.kzB == null) {
                return false;
            }
            if (c.this.kzD != null) {
                com.baidu.tieba.write.c doC = c.this.kzB.isFirstPost ? c.this.kzD.doC() : c.this.kzD.doD();
                if (doC != null && doC.dSV()) {
                    c.this.context.showToast(doC.dSX());
                    if (c.this.kzw != null && (c.this.kzw.bAs() || c.this.kzw.bAt())) {
                        c.this.kzw.a(false, c.this.kzD.doF());
                    }
                    if (c.this.kzB.isFirstPost) {
                        c.this.kzD.uY(true);
                    } else {
                        c.this.kzD.uZ(true);
                    }
                    return true;
                }
            }
            return !c.this.kzE.oU(c.this.replyPrivateFlag);
        }
    };
    private final NewWriteModel.d fpW = new NewWriteModel.d() { // from class: com.baidu.tieba.image.a.c.3
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                c.this.cXX();
                if (c.this.context != null && (c.this.context.getPageActivity() instanceof BaseActivity)) {
                    ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                    showReplyInPbEvent.writeData = postWriteCallBackData;
                    showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                    ((BaseActivity) c.this.context.getPageActivity()).publishEvent(showReplyInPbEvent);
                }
                if (postWriteCallBackData != null) {
                    TiebaStatic.log(new aq("c13970").dR("tid", postWriteCallBackData.getThreadId()).dR("fid", writeData.getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_type", writeData.getType()));
                }
            } else if (i == 220015) {
                c.this.context.showToast(str);
                if (c.this.kzw != null && (c.this.kzw.bAs() || c.this.kzw.bAt())) {
                    c.this.kzw.a(false, postWriteCallBackData);
                    c.this.cXX();
                }
                if (c.this.kzB.isFirstPost) {
                    c.this.kzD.h(postWriteCallBackData);
                } else {
                    c.this.kzD.i(postWriteCallBackData);
                }
            } else if (i == 238010) {
                if (!at.isEmpty(str)) {
                    c.this.context.showToast(str);
                } else {
                    c.this.context.showToast(R.string.message_privacy_fans_can_reply);
                }
                c.this.cXX();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (!at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(c.this.context.getPageActivity(), postWriteCallBackData.getErrorString(), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(c.this.context.getPageActivity(), c.this.context.getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.context.getPageActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Bo(c.this.context.getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bo(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new aq("c13746").al("obj_locate", 1).al("obj_type", 2));
                    }
                });
                aVar.b(c.this.context).bpc();
                TiebaStatic.log(new aq("c13745").al("obj_locate", 1).al("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                c.this.aI(i, str);
                c.this.cXX();
            }
        }
    };

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        this.context = tbPageContext;
        this.kzu = linearLayout;
        this.kzu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.a.c.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    c.this.cXX();
                    return true;
                }
                return true;
            }
        });
        this.kzu.setVisibility(8);
        this.kzE = new am(tbPageContext);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.kzC = true;
        if (this.kzw != null) {
            if (i == 25035) {
                d(i2, intent);
                cXX();
                return;
            }
            this.kzw.onActivityResult(i, i2, intent);
        }
    }

    public void setFromForumId(String str) {
        this.kyF = str;
    }

    private void d(int i, Intent intent) {
        if (i == 0 && this.kzw != null) {
            this.kzw.bzx().bxU();
        } else {
            cXX();
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
                        if (this.kzx != null) {
                            this.kzx.resetData();
                            this.kzx.setVoiceModel(pbEditorData.getVoiceModel());
                            this.kzx.b(writeData);
                            m rk = this.kzx.bzx().rk(6);
                            if (rk != null && rk.fnp != null) {
                                rk.fnp.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kzx.a((String) null, (WriteData) null);
                                return;
                            }
                            return;
                        }
                        return;
                    case 1:
                        if (this.kzy != null) {
                            this.kzy.b(writeData);
                            this.kzy.setVoiceModel(pbEditorData.getVoiceModel());
                            m rk2 = this.kzy.bzx().rk(6);
                            if (rk2 != null && rk2.fnp != null) {
                                rk2.fnp.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.kzy.a((String) null, (WriteData) null);
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
        if (AntiHelper.bR(i, str)) {
            AntiHelper.a(this.context.getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.image.a.c.5
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_REPLY));
                }
            });
        } else if (i == 230277) {
            DT(str);
        } else {
            this.context.showToast(str);
        }
    }

    private void DT(String str) {
        if (str == null) {
            str = "";
        }
        if (this.context != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getPageActivity());
            aVar.Bo(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.image.a.c.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.context).bpc();
        }
    }

    public void a(ImageUrlData imageUrlData, e eVar) {
        boolean z;
        h rh;
        JSONArray jSONArray;
        String str;
        if (imageUrlData != null && eVar != null) {
            if (this.kzv == null) {
                this.kzv = new b();
                this.kzv.ei(imageUrlData.forumName, imageUrlData.forumId);
            }
            if (imageUrlData.isFirstPost && this.kzx == null) {
                this.kzv.kzq = false;
                this.kzx = (a) this.kzv.ei(this.context.getPageActivity());
                this.kzz = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kzx.bzx().fnz, new b.InterfaceC0591b() { // from class: com.baidu.tieba.image.a.c.7
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0591b
                    public void kg(boolean z2) {
                        if (!z2) {
                            c.this.kzx.bzx().fnz.bzA();
                        } else {
                            c.this.kzx.bzx().fnz.setVisibility(0);
                        }
                    }
                });
                z = true;
            } else if (imageUrlData.isFirstPost || this.kzy != null) {
                z = false;
            } else {
                this.kzv.kzq = true;
                this.kzy = (a) this.kzv.ei(this.context.getPageActivity());
                this.kzA = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kzy.bzx().fnz, new b.InterfaceC0591b() { // from class: com.baidu.tieba.image.a.c.8
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0591b
                    public void kg(boolean z2) {
                        if (!z2) {
                            c.this.kzy.bzx().fnz.bzA();
                        } else {
                            c.this.kzy.bzx().fnz.setVisibility(0);
                        }
                    }
                });
                z = true;
            }
            this.kzw = imageUrlData.isFirstPost ? this.kzx : this.kzy;
            if (z) {
                this.kzw.a(this.context);
                this.kzw.a(this.fpW);
                this.kzw.a(this.fpQ);
                this.kzw.a(this.context, (Bundle) null);
                this.kzw.a(eVar.jpk, (UserData) null);
                this.kzw.kl(eVar.kxO);
                this.kzw.kyF = this.kyF;
                if (eVar.kxM == null) {
                    this.kzw.setThreadId(imageUrlData.threadId + "");
                } else {
                    this.kzw.a(eVar.kxM, imageUrlData.threadId + "", eVar.kxN);
                }
                if (imageUrlData.isFirstPost) {
                    this.kzw.bAi();
                }
                this.kzw.bzx().fny.setPadding(0, 0, 0, 0);
                this.kzw.bzx().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                this.kzw.bzx().onChangeSkinType(0);
            }
            if (this.kzB == null || imageUrlData.postId != this.kzB.postId) {
                if (this.kzB != null) {
                    this.kzw.DN(this.kzB.threadId + "");
                }
                this.kzw.bAr();
                this.kzw.resetData();
                this.kzw.kzq = !imageUrlData.isFirstPost;
                this.kzw.postId = imageUrlData.postId + "";
                this.kzw.kzr = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && this.kzw.bzx() != null) {
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
                        this.kzw.bzx().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                    }
                    jSONArray = null;
                    if (jSONArray != null) {
                    }
                    str = "";
                    this.kzw.bzx().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                }
                this.replyPrivateFlag = eVar.replyPrivateFlag;
                this.fpM = eVar.fpM;
                if (this.kzw.bzx() != null && !StringUtils.isNull(this.fpM) && (rh = this.kzw.bzx().rh(6)) != null && !TextUtils.isEmpty(this.fpM)) {
                    ((View) rh).setOnClickListener(this.fqy);
                }
                this.kzw.DO(imageUrlData.threadId + "");
            }
            if (this.kzB == null || this.kzB.isFirstPost != imageUrlData.isFirstPost) {
                if (this.kzw.bzx() != null) {
                    this.kzu.removeAllViews();
                    this.kzu.addView(this.kzw.bzx());
                }
                if (this.kzD == null) {
                    this.kzD = new bb();
                }
                if (this.kzw.bAd() != null) {
                    this.kzD.e(this.kzw.bAd().getInputView());
                }
            }
            this.kzB = imageUrlData;
        }
    }

    public void b(ImageUrlData imageUrlData, e eVar) {
        if (this.kzE != null && imageUrlData != null && eVar != null && this.kzE.oT(eVar.replyPrivateFlag)) {
            if (this.kzB == null || this.kzB.postId != imageUrlData.postId || this.kzw == null) {
                a(imageUrlData, eVar);
            }
            if (this.kzw != null) {
                if (this.kzw.bAs() || this.kzw.bAt()) {
                    this.kzw.a(false, (PostWriteCallBackData) null);
                    return;
                }
                this.kzu.setVisibility(0);
                if (this.kzw.bzx() != null) {
                    this.kzw.bzx().display();
                    this.kzw.bzx().bxU();
                }
            }
        }
    }

    public void cXX() {
        if (this.kzw != null && this.kzw.bzx() != null) {
            this.kzw.bzx().hide();
        }
        l.hideSoftKeyPad(this.context.getPageActivity(), this.kzu);
        this.kzu.setVisibility(8);
    }

    public void onPause() {
        if (this.kzB != null && this.kzw != null) {
            this.kzw.DN(this.kzB.threadId + "");
        }
    }

    public void onResume() {
        if (this.kzB != null && this.kzw != null) {
            if (this.kzC) {
                this.kzC = false;
                return;
            }
            this.kzw.bAr();
            this.kzw.DO(this.kzB.threadId + "");
            this.kzw.bzx().bxU();
        }
    }

    public void onDestroy() {
        if (this.kzE != null) {
            this.kzE.onDestroy();
        }
        if (this.kzz != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kzz);
        }
        if (this.kzA != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.kzA);
        }
    }
}
