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
    private String fbv;
    private String kgl;
    private LinearLayout kha;
    private b khb;
    private a khc;
    private a khd;
    private a khe;
    ViewTreeObserver.OnGlobalLayoutListener khf;
    ViewTreeObserver.OnGlobalLayoutListener khg;
    private ImageUrlData khh;
    public bb khj;
    private am khk;
    private int replyPrivateFlag;
    private boolean khi = false;
    private View.OnClickListener fch = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(c.this.fbv)) {
                l.showToast(c.this.context.getPageActivity(), c.this.fbv);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b fbz = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.image.a.c.2
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bvJ() {
            if (c.this.khh == null) {
                return false;
            }
            if (c.this.khj != null) {
                com.baidu.tieba.write.c diS = c.this.khh.isFirstPost ? c.this.khj.diS() : c.this.khj.diT();
                if (diS != null && diS.dNl()) {
                    c.this.context.showToast(diS.dNn());
                    if (c.this.khc != null && (c.this.khc.bwa() || c.this.khc.bwb())) {
                        c.this.khc.a(false, c.this.khj.diV());
                    }
                    if (c.this.khh.isFirstPost) {
                        c.this.khj.uy(true);
                    } else {
                        c.this.khj.uz(true);
                    }
                    return true;
                }
            }
            return !c.this.khk.oz(c.this.replyPrivateFlag);
        }
    };
    private final NewWriteModel.d fbF = new NewWriteModel.d() { // from class: com.baidu.tieba.image.a.c.3
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                c.this.cSp();
                if (c.this.context != null && (c.this.context.getPageActivity() instanceof BaseActivity)) {
                    ShowReplyInPbEvent showReplyInPbEvent = new ShowReplyInPbEvent();
                    showReplyInPbEvent.writeData = postWriteCallBackData;
                    showReplyInPbEvent.isSubPbReply = writeData.isSubFloor();
                    ((BaseActivity) c.this.context.getPageActivity()).publishEvent(showReplyInPbEvent);
                }
                if (postWriteCallBackData != null) {
                    TiebaStatic.log(new aq("c13970").dK("tid", postWriteCallBackData.getThreadId()).dK("fid", writeData.getForumId()).dK("uid", TbadkCoreApplication.getCurrentAccount()).aj("obj_type", writeData.getType()));
                }
            } else if (i == 220015) {
                c.this.context.showToast(str);
                if (c.this.khc != null && (c.this.khc.bwa() || c.this.khc.bwb())) {
                    c.this.khc.a(false, postWriteCallBackData);
                    c.this.cSp();
                }
                if (c.this.khh.isFirstPost) {
                    c.this.khj.h(postWriteCallBackData);
                } else {
                    c.this.khj.i(postWriteCallBackData);
                }
            } else if (i == 238010) {
                if (!at.isEmpty(str)) {
                    c.this.context.showToast(str);
                } else {
                    c.this.context.showToast(R.string.message_privacy_fans_can_reply);
                }
                c.this.cSp();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (!at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(c.this.context.getPageActivity(), postWriteCallBackData.getErrorString(), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(c.this.context.getPageActivity(), c.this.context.getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(c.this.context.getPageActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.AH(c.this.context.getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AH(postWriteCallBackData.getErrorString());
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
                aVar.b(c.this.context).bkJ();
                TiebaStatic.log(new aq("c13745").aj("obj_locate", 1).aj("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                c.this.aC(i, str);
                c.this.cSp();
            }
        }
    };

    public c(TbPageContext tbPageContext, LinearLayout linearLayout) {
        this.context = tbPageContext;
        this.kha = linearLayout;
        this.kha.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.a.c.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    c.this.cSp();
                    return true;
                }
                return true;
            }
        });
        this.kha.setVisibility(8);
        this.khk = new am(tbPageContext);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.khi = true;
        if (this.khc != null) {
            if (i == 25035) {
                d(i2, intent);
                cSp();
                return;
            }
            this.khc.onActivityResult(i, i2, intent);
        }
    }

    public void setFromForumId(String str) {
        this.kgl = str;
    }

    private void d(int i, Intent intent) {
        if (i == 0 && this.khc != null) {
            this.khc.bvf().btC();
        } else {
            cSp();
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
                        if (this.khd != null) {
                            this.khd.resetData();
                            this.khd.setVoiceModel(pbEditorData.getVoiceModel());
                            this.khd.b(writeData);
                            m qP = this.khd.bvf().qP(6);
                            if (qP != null && qP.eYZ != null) {
                                qP.eYZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.khd.a((String) null, (WriteData) null);
                                return;
                            }
                            return;
                        }
                        return;
                    case 1:
                        if (this.khe != null) {
                            this.khe.b(writeData);
                            this.khe.setVoiceModel(pbEditorData.getVoiceModel());
                            m qP2 = this.khe.bvf().qP(6);
                            if (qP2 != null && qP2.eYZ != null) {
                                qP2.eYZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            if (i == -1) {
                                this.khe.a((String) null, (WriteData) null);
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
    public void aC(int i, String str) {
        if (AntiHelper.bM(i, str)) {
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
            Dm(str);
        } else {
            this.context.showToast(str);
        }
    }

    private void Dm(String str) {
        if (str == null) {
            str = "";
        }
        if (this.context != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.context.getPageActivity());
            aVar.AH(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.image.a.c.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.context).bkJ();
        }
    }

    public void a(ImageUrlData imageUrlData, e eVar) {
        boolean z;
        h qM;
        JSONArray jSONArray;
        String str;
        if (imageUrlData != null && eVar != null) {
            if (this.khb == null) {
                this.khb = new b();
                this.khb.eb(imageUrlData.forumName, imageUrlData.forumId);
            }
            if (imageUrlData.isFirstPost && this.khd == null) {
                this.khb.kgW = false;
                this.khd = (a) this.khb.ei(this.context.getPageActivity());
                this.khf = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.khd.bvf().eZj, new b.InterfaceC0565b() { // from class: com.baidu.tieba.image.a.c.7
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0565b
                    public void jK(boolean z2) {
                        if (!z2) {
                            c.this.khd.bvf().eZj.bvi();
                        } else {
                            c.this.khd.bvf().eZj.setVisibility(0);
                        }
                    }
                });
                z = true;
            } else if (imageUrlData.isFirstPost || this.khe != null) {
                z = false;
            } else {
                this.khb.kgW = true;
                this.khe = (a) this.khb.ei(this.context.getPageActivity());
                this.khg = com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.khe.bvf().eZj, new b.InterfaceC0565b() { // from class: com.baidu.tieba.image.a.c.8
                    @Override // com.baidu.tbadk.editortools.noConflictPanel.b.b.InterfaceC0565b
                    public void jK(boolean z2) {
                        if (!z2) {
                            c.this.khe.bvf().eZj.bvi();
                        } else {
                            c.this.khe.bvf().eZj.setVisibility(0);
                        }
                    }
                });
                z = true;
            }
            this.khc = imageUrlData.isFirstPost ? this.khd : this.khe;
            if (z) {
                this.khc.a(this.context);
                this.khc.a(this.fbF);
                this.khc.a(this.fbz);
                this.khc.a(this.context, (Bundle) null);
                this.khc.a(eVar.iWP, (UserData) null);
                this.khc.jP(eVar.kfu);
                this.khc.kgl = this.kgl;
                if (eVar.kfs == null) {
                    this.khc.setThreadId(imageUrlData.threadId + "");
                } else {
                    this.khc.a(eVar.kfs, imageUrlData.threadId + "", eVar.kft);
                }
                if (imageUrlData.isFirstPost) {
                    this.khc.bvQ();
                }
                this.khc.bvf().eZi.setPadding(0, 0, 0, 0);
                this.khc.bvf().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                this.khc.bvf().onChangeSkinType(0);
            }
            if (this.khh == null || imageUrlData.postId != this.khh.postId) {
                if (this.khh != null) {
                    this.khc.Dg(this.khh.threadId + "");
                }
                this.khc.bvZ();
                this.khc.resetData();
                this.khc.kgW = !imageUrlData.isFirstPost;
                this.khc.postId = imageUrlData.postId + "";
                this.khc.kgX = imageUrlData.userId;
                if (!imageUrlData.isFirstPost && this.khc.bvf() != null) {
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
                        this.khc.bvf().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                    }
                    jSONArray = null;
                    if (jSONArray != null) {
                    }
                    str = "";
                    this.khc.bvf().b(new com.baidu.tbadk.editortools.a(45, 27, String.format(string, imageUrlData.userNameShow, str)));
                }
                this.replyPrivateFlag = eVar.replyPrivateFlag;
                this.fbv = eVar.fbv;
                if (this.khc.bvf() != null && !StringUtils.isNull(this.fbv) && (qM = this.khc.bvf().qM(6)) != null && !TextUtils.isEmpty(this.fbv)) {
                    ((View) qM).setOnClickListener(this.fch);
                }
                this.khc.Dh(imageUrlData.threadId + "");
            }
            if (this.khh == null || this.khh.isFirstPost != imageUrlData.isFirstPost) {
                if (this.khc.bvf() != null) {
                    this.kha.removeAllViews();
                    this.kha.addView(this.khc.bvf());
                }
                if (this.khj == null) {
                    this.khj = new bb();
                }
                if (this.khc.bvL() != null) {
                    this.khj.e(this.khc.bvL().getInputView());
                }
            }
            this.khh = imageUrlData;
        }
    }

    public void b(ImageUrlData imageUrlData, e eVar) {
        if (this.khk != null && imageUrlData != null && eVar != null && this.khk.oy(eVar.replyPrivateFlag)) {
            if (this.khh == null || this.khh.postId != imageUrlData.postId || this.khc == null) {
                a(imageUrlData, eVar);
            }
            if (this.khc != null) {
                if (this.khc.bwa() || this.khc.bwb()) {
                    this.khc.a(false, (PostWriteCallBackData) null);
                    return;
                }
                this.kha.setVisibility(0);
                if (this.khc.bvf() != null) {
                    this.khc.bvf().display();
                    this.khc.bvf().btC();
                }
            }
        }
    }

    public void cSp() {
        if (this.khc != null && this.khc.bvf() != null) {
            this.khc.bvf().hide();
        }
        l.hideSoftKeyPad(this.context.getPageActivity(), this.kha);
        this.kha.setVisibility(8);
    }

    public void onPause() {
        if (this.khh != null && this.khc != null) {
            this.khc.Dg(this.khh.threadId + "");
        }
    }

    public void onResume() {
        if (this.khh != null && this.khc != null) {
            if (this.khi) {
                this.khi = false;
                return;
            }
            this.khc.bvZ();
            this.khc.Dh(this.khh.threadId + "");
            this.khc.bvf().btC();
        }
    }

    public void onDestroy() {
        if (this.khk != null) {
            this.khk.onDestroy();
        }
        if (this.khf != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.khf);
        }
        if (this.khg != null) {
            com.baidu.tbadk.editortools.noConflictPanel.b.b.a(this.context.getPageActivity(), this.khg);
        }
    }
}
