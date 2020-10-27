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
    private String fjU;
    private String ksJ;
    private a ktA;
    private a ktB;
    private a ktC;
    ViewTreeObserver.OnGlobalLayoutListener ktD;
    ViewTreeObserver.OnGlobalLayoutListener ktE;
    private ImageUrlData ktF;
    public bb ktH;
    private am ktI;
    private LinearLayout kty;
    private b ktz;
    private int replyPrivateFlag;
    private boolean ktG = false;
    private View.OnClickListener fkG = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(c.this.fjU)) {
                l.showToast(c.this.context.getPageActivity(), c.this.fjU);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b fjY = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.image.a.c.2
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bxC() {
            if (c.this.ktF == null) {
                return false;
            }
            if (c.this.ktH != null) {
                com.baidu.tieba.write.c dlZ = c.this.ktF.isFirstPost ? c.this.ktH.dlZ() : c.this.ktH.dma();
                if (dlZ != null && dlZ.dQt()) {
                    c.this.context.showToast(dlZ.dQv());
                    if (c.this.ktA != null && (c.this.ktA.bxT() || c.this.ktA.bxU())) {
                        c.this.ktA.a(false, c.this.ktH.dmc());
                    }
                    if (c.this.ktF.isFirstPost) {
                        c.this.ktH.uP(true);
                    } else {
                        c.this.ktH.uQ(true);
                    }
                    return true;
                }
            }
            return !c.this.ktI.oK(c.this.replyPrivateFlag);
        }
    };
    private final NewWriteModel.d fke = new NewWriteModel.d() { // from class: com.baidu.tieba.image.a.c.3
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                c.this.cVw();
                if (c.this.context != null && (c.this.context.getPageActivity() instanceof BaseActivity)) {
                    ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                    showReplyInPbEvent.writeData = postWriteCallBackData;
                    showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                    ((BaseActivity) c.this.context.getPageActivity()).publishEvent(showReplyInPbEvent);
                }
                if (postWriteCallBackData != null) {
                    TiebaStatic.log(new aq("c13970").dR("tid", postWriteCallBackData.getThreadId()).dR("fid", writeData.getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).aj("obj_type", writeData.getType()));
                }
            } else if (i == 220015) {
                c.this.context.showToast(str);
                if (c.this.ktA != null && (c.this.ktA.bxT() || c.this.ktA.bxU())) {
                    c.this.ktA.a(false, postWriteCallBackData);
                    c.this.cVw();
                }
                if (c.this.ktF.isFirstPost) {
                    c.this.ktH.h(postWriteCallBackData);
                } else {
                    c.this.ktH.i(postWriteCallBackData);
                }
            } else if (i == 238010) {
                if (!at.isEmpty(str)) {
                    c.this.context.showToast(str);
                } else {
                    c.this.context.showToast(R.string.message_privacy_fans_can_reply);
                }
                c.this.cVw();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (!at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(c.this.context.getPageActivity(), postWriteCallBackData.getErrorString(), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(c.this.context.getPageActivity(), c.this.context.getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.context.getPageActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Ba(c.this.context.getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Ba(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new aq("c13746").aj("obj_locate", 1).aj("obj_type", 2));
                    }
                });
                aVar.b(c.this.context).bmC();
                TiebaStatic.log(new aq("c13745").aj("obj_locate", 1).aj("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                c.this.aE(i, str);
                c.this.cVw();
            }
        }
    };

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        this.context = tbPageContext;
        this.kty = linearLayout;
        this.kty.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.a.c.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    c.this.cVw();
                    return true;
                }
                return true;
            }
        });
        this.kty.setVisibility(8);
        this.ktI = new am(tbPageContext);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.ktG = true;
        if (this.ktA != null) {
            if (i == 25035) {
                d(i2, intent);
                cVw();
                return;
            }
            this.ktA.onActivityResult(i, i2, intent);
        }
    }

    public void setFromForumId(String str) {
        this.ksJ = str;
    }

    private void d(int i, Intent intent) {
        if (i == 0 && this.ktA != null) {
            this.ktA.bwY().bvv();
        } else {
            cVw();
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
                        if (this.ktB != null) {
                            this.ktB.resetData();
                            this.ktB.setVoiceModel(pbEditorData.getVoiceModel());
                            this.ktB.b(writeData);
                            m ra = this.ktB.bwY().ra(6);
                            if (ra != null && ra.fhv != null) {
                                ra.fhv.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.ktB.a((String) null, (WriteData) null);
                                return;
                            }
                            return;
                        }
                        return;
                    case 1:
                        if (this.ktC != null) {
                            this.ktC.b(writeData);
                            this.ktC.setVoiceModel(pbEditorData.getVoiceModel());
                            m ra2 = this.ktC.bwY().ra(6);
                            if (ra2 != null && ra2.fhv != null) {
                                ra2.fhv.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.ktC.a((String) null, (WriteData) null);
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
    public void aE(int i, String str) {
        if (AntiHelper.bN(i, str)) {
            AntiHelper.a(this.context.getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.image.a.c.5
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_REPLY));
                }
            });
        } else if (i == 230277) {
            DF(str);
        } else {
            this.context.showToast(str);
        }
    }

    private void DF(String str) {
        if (str == null) {
            str = "";
        }
        if (this.context != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getPageActivity());
            aVar.Ba(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.image.a.c.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.context).bmC();
        }
    }

    public void a(ImageUrlData imageUrlData, e eVar) {
        boolean z;
        h qX;
        JSONArray jSONArray;
        String str;
        if (imageUrlData != null && eVar != null) {
            if (this.ktz == null) {
                this.ktz = new b();
                this.ktz.ei(imageUrlData.forumName, imageUrlData.forumId);
            }
            if (imageUrlData.isFirstPost && this.ktB == null) {
                this.ktz.ktu = false;
                this.ktB = (a) this.ktz.ei(this.context.getPageActivity());
                this.ktD = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.ktB.bwY().fhF, new b.InterfaceC0579b() { // from class: com.baidu.tieba.image.a.c.7
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0579b
                    public void jX(boolean z2) {
                        if (!z2) {
                            c.this.ktB.bwY().fhF.bxb();
                        } else {
                            c.this.ktB.bwY().fhF.setVisibility(0);
                        }
                    }
                });
                z = true;
            } else if (imageUrlData.isFirstPost || this.ktC != null) {
                z = false;
            } else {
                this.ktz.ktu = true;
                this.ktC = (a) this.ktz.ei(this.context.getPageActivity());
                this.ktE = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.ktC.bwY().fhF, new b.InterfaceC0579b() { // from class: com.baidu.tieba.image.a.c.8
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0579b
                    public void jX(boolean z2) {
                        if (!z2) {
                            c.this.ktC.bwY().fhF.bxb();
                        } else {
                            c.this.ktC.bwY().fhF.setVisibility(0);
                        }
                    }
                });
                z = true;
            }
            this.ktA = imageUrlData.isFirstPost ? this.ktB : this.ktC;
            if (z) {
                this.ktA.a(this.context);
                this.ktA.a(this.fke);
                this.ktA.a(this.fjY);
                this.ktA.a(this.context, (Bundle) null);
                this.ktA.a(eVar.jjm, (UserData) null);
                this.ktA.kc(eVar.krS);
                this.ktA.ksJ = this.ksJ;
                if (eVar.krQ == null) {
                    this.ktA.setThreadId(imageUrlData.threadId + "");
                } else {
                    this.ktA.a(eVar.krQ, imageUrlData.threadId + "", eVar.krR);
                }
                if (imageUrlData.isFirstPost) {
                    this.ktA.bxJ();
                }
                this.ktA.bwY().fhE.setPadding(0, 0, 0, 0);
                this.ktA.bwY().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                this.ktA.bwY().onChangeSkinType(0);
            }
            if (this.ktF == null || imageUrlData.postId != this.ktF.postId) {
                if (this.ktF != null) {
                    this.ktA.Dz(this.ktF.threadId + "");
                }
                this.ktA.bxS();
                this.ktA.resetData();
                this.ktA.ktu = !imageUrlData.isFirstPost;
                this.ktA.postId = imageUrlData.postId + "";
                this.ktA.ktv = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && this.ktA.bwY() != null) {
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
                        this.ktA.bwY().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                    }
                    jSONArray = null;
                    if (jSONArray != null) {
                    }
                    str = "";
                    this.ktA.bwY().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                }
                this.replyPrivateFlag = eVar.replyPrivateFlag;
                this.fjU = eVar.fjU;
                if (this.ktA.bwY() != null && !StringUtils.isNull(this.fjU) && (qX = this.ktA.bwY().qX(6)) != null && !TextUtils.isEmpty(this.fjU)) {
                    ((View) qX).setOnClickListener(this.fkG);
                }
                this.ktA.DA(imageUrlData.threadId + "");
            }
            if (this.ktF == null || this.ktF.isFirstPost != imageUrlData.isFirstPost) {
                if (this.ktA.bwY() != null) {
                    this.kty.removeAllViews();
                    this.kty.addView(this.ktA.bwY());
                }
                if (this.ktH == null) {
                    this.ktH = new bb();
                }
                if (this.ktA.bxE() != null) {
                    this.ktH.e(this.ktA.bxE().getInputView());
                }
            }
            this.ktF = imageUrlData;
        }
    }

    public void b(ImageUrlData imageUrlData, e eVar) {
        if (this.ktI != null && imageUrlData != null && eVar != null && this.ktI.oJ(eVar.replyPrivateFlag)) {
            if (this.ktF == null || this.ktF.postId != imageUrlData.postId || this.ktA == null) {
                a(imageUrlData, eVar);
            }
            if (this.ktA != null) {
                if (this.ktA.bxT() || this.ktA.bxU()) {
                    this.ktA.a(false, (PostWriteCallBackData) null);
                    return;
                }
                this.kty.setVisibility(0);
                if (this.ktA.bwY() != null) {
                    this.ktA.bwY().display();
                    this.ktA.bwY().bvv();
                }
            }
        }
    }

    public void cVw() {
        if (this.ktA != null && this.ktA.bwY() != null) {
            this.ktA.bwY().hide();
        }
        l.hideSoftKeyPad(this.context.getPageActivity(), this.kty);
        this.kty.setVisibility(8);
    }

    public void onPause() {
        if (this.ktF != null && this.ktA != null) {
            this.ktA.Dz(this.ktF.threadId + "");
        }
    }

    public void onResume() {
        if (this.ktF != null && this.ktA != null) {
            if (this.ktG) {
                this.ktG = false;
                return;
            }
            this.ktA.bxS();
            this.ktA.DA(this.ktF.threadId + "");
            this.ktA.bwY().bvv();
        }
    }

    public void onDestroy() {
        if (this.ktI != null) {
            this.ktI.onDestroy();
        }
        if (this.ktD != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.ktD);
        }
        if (this.ktE != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.ktE);
        }
    }
}
