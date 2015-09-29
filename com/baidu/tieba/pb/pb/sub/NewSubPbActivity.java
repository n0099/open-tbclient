package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.ak;
import com.baidu.tieba.tbadkCore.g.a;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.i;
import java.util.Map;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.i {
    private com.baidu.adp.lib.e.b<ImageView> aBI;
    private com.baidu.adp.lib.e.b<TextView> aBJ;
    private com.baidu.adp.lib.e.b<View> aBK;
    private com.baidu.adp.lib.e.b<LinearLayout> aBL;
    private View.OnClickListener aZl;
    private View.OnLongClickListener ajT;
    private com.baidu.tbadk.editortools.c.n caJ;
    private com.baidu.tbadk.baseEditMark.a chW;
    private c.b ciy;
    private ak cmi;
    private com.baidu.tieba.tbadkCore.g.a cmj;
    private t cmk;
    private AbsListView.OnScrollListener cml;
    private ak.a cmm;
    private com.baidu.adp.base.g cmn;
    private VoiceManager mVoiceManager;
    private static final String clB = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String chQ = "tbgametype";
    private com.baidu.tieba.usermute.i chZ = null;
    private a.InterfaceC0039a ciq = null;
    private a cmo = null;
    private a cmp = null;
    private UserMuteAddAndDelModel<NewSubPbActivity> chY = null;
    private i.a cio = new com.baidu.tieba.pb.pb.sub.a(this);
    private com.baidu.tbadk.editortools.c.b asg = new l(this);
    private a.d cmq = new m(this);
    private CustomMessageListener richTextIntentClickListener = new n(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QN();
        ahe();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        ahf();
    }

    public void initUI() {
        this.cmk = new t(this, this.aZl);
        addContentView(this.cmk.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.cmk.iW(com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity()));
        this.cmk.setOnScrollListener(this.cml);
        this.cmk.d(this);
        this.cmk.ep(true);
        this.cmk.eq(com.baidu.tbadk.core.m.qX().qZ());
        this.cmk.setOnLongClickListener(this.ajT);
        this.cmk.b(new o(this));
        this.cmk.a(this.cmo);
        this.cmk.b(this.cmp);
        if (this.cmi != null && this.cmi.ahb() && !this.cmi.ahP()) {
            this.cmk.ahp().setVisibility(8);
        } else {
            this.cmk.ahp().setVisibility(0);
        }
    }

    public void initData(Bundle bundle) {
        this.chZ = new com.baidu.tieba.usermute.i(getPageContext(), this.cio);
        this.chY = new UserMuteAddAndDelModel<>(this);
        this.cmi = new ak(getPageContext());
        this.cmj = new com.baidu.tieba.tbadkCore.g.a(this);
        this.cmj.setLoadDataCallBack(this.cmn);
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        this.chW = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.chW != null) {
            this.chW.a(this.ciq);
        }
        if (bundle != null) {
            this.cmi.initWithBundle(bundle);
        } else {
            this.cmi.initWithIntent(getIntent());
        }
        this.cmi.a(this.cmm);
        if (this.cmi.ahb()) {
            this.cmi.CS();
        } else {
            this.cmi.ahH();
        }
    }

    public void ahe() {
        this.cmm = new p(this);
        this.ciq = new q(this);
        this.cmo = new r(this);
        this.cmp = new s(this);
        this.cmn = new b(this);
    }

    public void QN() {
        this.aZl = new c(this);
        this.cml = new d(this);
        this.ciy = new e(this);
        this.ajT = new f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i, String str) {
        if (!this.cmi.ahB()) {
            if (com.baidu.adp.lib.util.k.jd()) {
                if (i == 4) {
                    this.cmk.jT(String.valueOf(str) + "(4)");
                    return;
                } else {
                    this.cmk.gh(i.h.no_data_text);
                    return;
                }
            }
            this.cmk.gh(i.h.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.caJ = (com.baidu.tbadk.editortools.c.n) new com.baidu.tbadk.editortools.c.r().ak(getActivity());
        this.caJ.b(this);
        this.caJ.b(this.cmi);
        this.caJ.b(this.cmq);
        this.caJ.a(this.asg);
        this.caJ.c(this);
        if (this.cmk != null) {
            this.cmk.e(this.caJ);
        }
        if (this.caJ != null && this.cmi != null) {
            this.caJ.a(this.cmi.afh());
        }
    }

    public void ahf() {
        if (!TbadkCoreApplication.isLogin()) {
            this.caJ.BM();
        } else if (this.cmi.ahM()) {
            if (!StringUtils.isNull(this.cmi.ahJ()) && !StringUtils.isNull(this.cmi.ahN())) {
                new Handler().postDelayed(new g(this), 500L);
            } else {
                this.caJ.fe(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(i.f.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.f.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(i.f.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.f.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(i.f.tag_from, 1);
                    d(sparseArray);
                } else {
                    this.cmk.ac(view);
                }
            } else if (booleanValue2) {
                this.cmk.a(((Integer) sparseArray.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray.get(i.f.tag_del_post_id), ((Integer) sparseArray.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(i.f.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.j.a(this.cmk.ahr(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String str;
        String[] strArr;
        if (!(sparseArray.get(i.f.tag_disable_reply_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(i.f.tag_disable_reply_mute_userid);
        }
        if (((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(i.h.delete);
            strArr2[1] = z ? getResources().getString(i.h.un_mute) : getResources().getString(i.h.mute);
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(i.h.delete)};
        }
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bI(i.h.operation);
        cVar.a(strArr, new h(this, sparseArray, z, str));
        cVar.d(getPageContext()).sU();
    }

    public void d(SparseArray<Object> sparseArray) {
        String str;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!(sparseArray.get(i.f.tag_disable_reply_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(i.f.tag_disable_reply_mute_userid);
        }
        this.cmk.Zf();
        this.chZ.a(com.baidu.adp.lib.g.b.c(currentAccount, 0L), com.baidu.adp.lib.g.b.c(str, 0L), sparseArray);
    }

    public void a(a.b bVar) {
        if (bVar != null) {
            this.cmk.a(0, bVar.An, bVar.daB, true);
            if (bVar.An) {
                if (bVar.daz == 1) {
                    finish();
                } else if (bVar.daz == 2) {
                    this.cmi.jW(bVar.mPostId);
                    this.cmk.a(this.cmi.ahA(), this.cmi.aeS());
                }
                am amVar = new am();
                amVar.setData(bVar);
                amVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, amVar));
            }
        }
    }

    public void jI(String str) {
        if (!StringUtils.isNull(str) && this.cmi != null) {
            String threadID = this.cmi.getThreadID();
            String Bl = this.cmi.Bl();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(i.h.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Bl + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void c(com.baidu.tieba.tbadkCore.data.k kVar) {
        if (kVar != null) {
            boolean z = false;
            if (this.cmi.isMarked() && kVar.getId() != null && kVar.getId().equals(this.cmi.ahL())) {
                z = true;
            }
            MarkData d = this.cmi.d(kVar);
            if (d != null) {
                this.cmk.agM();
                if (this.chW != null) {
                    this.chW.a(d);
                    if (!z) {
                        this.chW.qm();
                    } else {
                        this.chW.ql();
                    }
                }
            }
        }
    }

    public void replyPost(View view) {
        if (this.cmk.ahr() == null || this.cmk.ahq() == null) {
            this.cmk.afl();
        }
        if (this.cmk.ahr().getIsIntercepted()) {
            this.cmk.ahr().setIsIntercepted(false);
            return;
        }
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.k kVar = sparseArray.get(i.f.tag_load_sub_data) instanceof com.baidu.tieba.tbadkCore.data.k ? (com.baidu.tieba.tbadkCore.data.k) sparseArray.get(i.f.tag_load_sub_data) : null;
            View view2 = sparseArray.get(i.f.tag_load_sub_view) instanceof View ? (View) sparseArray.get(i.f.tag_load_sub_view) : null;
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(i.f.tag_load_sub_data, kVar);
            sparseArray2.put(i.f.tag_load_sub_view, view2);
            this.cmk.ahq().agj().setTag(sparseArray2);
            SparseArray sparseArray3 = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.k kVar2 = sparseArray3.get(i.f.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.k ? (com.baidu.tieba.tbadkCore.data.k) sparseArray3.get(i.f.tag_clip_board) : null;
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(i.f.tag_clip_board, kVar2);
            sparseArray4.put(i.f.tag_is_subpb, false);
            this.cmk.ahq().afY().setTag(sparseArray4);
            SparseArray sparseArray5 = (SparseArray) view.getTag();
            boolean booleanValue = sparseArray5.get(i.f.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(i.f.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray5.get(i.f.tag_display_reply_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(i.f.tag_display_reply_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray5.get(i.f.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(i.f.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray5.get(i.f.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray5.get(i.f.tag_del_post_is_self)).booleanValue() : false;
            if (sparseArray5.get(i.f.tag_forbid_user_post_id) instanceof String) {
                String str = (String) sparseArray5.get(i.f.tag_forbid_user_post_id);
            }
            if (booleanValue) {
                SparseArray sparseArray6 = new SparseArray();
                sparseArray6.put(i.f.tag_should_manage_visible, true);
                sparseArray6.put(i.f.tag_manage_user_identity, sparseArray5.get(i.f.tag_manage_user_identity));
                sparseArray6.put(i.f.tag_del_post_is_self, sparseArray5.get(i.f.tag_del_post_is_self));
                sparseArray6.put(i.f.tag_del_post_id, sparseArray5.get(i.f.tag_del_post_id));
                sparseArray6.put(i.f.tag_del_post_type, sparseArray5.get(i.f.tag_del_post_type));
                sparseArray6.put(i.f.tag_forbid_user_name, sparseArray5.get(i.f.tag_forbid_user_name));
                sparseArray6.put(i.f.tag_forbid_user_post_id, sparseArray5.get(i.f.tag_forbid_user_post_id));
                if (booleanValue2) {
                    sparseArray6.put(i.f.tag_display_reply_visible, true);
                    sparseArray6.put(i.f.tag_is_mem, sparseArray5.get(i.f.tag_is_mem));
                    sparseArray6.put(i.f.tag_disable_reply_mute_userid, sparseArray5.get(i.f.tag_disable_reply_mute_userid));
                    sparseArray6.put(i.f.tag_disable_reply_mute_username, sparseArray5.get(i.f.tag_disable_reply_mute_username));
                    sparseArray6.put(i.f.tag_disable_reply_post_id, sparseArray5.get(i.f.tag_disable_reply_post_id));
                    sparseArray6.put(i.f.tag_disable_reply_thread_id, sparseArray5.get(i.f.tag_disable_reply_thread_id));
                } else {
                    sparseArray6.put(i.f.tag_display_reply_visible, false);
                }
                if (booleanValue3) {
                    sparseArray6.put(i.f.tag_should_delete_visible, true);
                    sparseArray6.put(i.f.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                    sparseArray6.put(i.f.tag_del_post_id, sparseArray5.get(i.f.tag_del_post_id));
                    sparseArray6.put(i.f.tag_del_post_type, sparseArray5.get(i.f.tag_del_post_type));
                } else {
                    sparseArray6.put(i.f.tag_should_delete_visible, false);
                }
                this.cmk.ahq().agk().setTag(sparseArray6);
                if (!"".equals(sparseArray5.get(i.f.tag_forbid_user_name)) && !"".equals(sparseArray5.get(i.f.tag_del_post_id))) {
                    com.baidu.tbadk.core.util.am.c(this.cmk.ahq().agk(), i.e.icon_pb_set_n);
                } else {
                    com.baidu.tbadk.core.util.am.c(this.cmk.ahq().agk(), i.e.icon_pb_del_n);
                }
                this.cmk.ahq().agk().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray7 = new SparseArray();
                sparseArray7.put(i.f.tag_should_manage_visible, false);
                sparseArray7.put(i.f.tag_display_reply_visible, false);
                sparseArray7.put(i.f.tag_should_delete_visible, true);
                sparseArray7.put(i.f.tag_manage_user_identity, sparseArray5.get(i.f.tag_manage_user_identity));
                sparseArray7.put(i.f.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray7.put(i.f.tag_del_post_id, sparseArray5.get(i.f.tag_del_post_id));
                sparseArray7.put(i.f.tag_del_post_type, sparseArray5.get(i.f.tag_del_post_type));
                this.cmk.ahq().agk().setTag(sparseArray7);
                com.baidu.tbadk.core.util.am.c(this.cmk.ahq().agk(), i.e.icon_pb_del_n);
                this.cmk.ahq().agk().setVisibility(0);
            } else {
                this.cmk.ahq().agk().setVisibility(8);
            }
            SparseArray sparseArray8 = (SparseArray) view.getTag();
            boolean booleanValue5 = sparseArray8.get(i.f.tag_display_reply_visible) instanceof Boolean ? ((Boolean) sparseArray8.get(i.f.tag_display_reply_visible)).booleanValue() : false;
            if (!((Boolean) sparseArray8.get(i.f.tag_should_manage_visible)).booleanValue() && booleanValue5) {
                SparseArray sparseArray9 = new SparseArray();
                sparseArray9.put(i.f.tag_display_reply_visible, true);
                sparseArray9.put(i.f.tag_is_mem, sparseArray8.get(i.f.tag_is_mem));
                sparseArray9.put(i.f.tag_disable_reply_mute_userid, sparseArray8.get(i.f.tag_disable_reply_mute_userid));
                sparseArray9.put(i.f.tag_disable_reply_mute_username, sparseArray8.get(i.f.tag_disable_reply_mute_username));
                sparseArray9.put(i.f.tag_disable_reply_post_id, sparseArray8.get(i.f.tag_disable_reply_post_id));
                sparseArray9.put(i.f.tag_disable_reply_thread_id, sparseArray8.get(i.f.tag_disable_reply_thread_id));
                sparseArray9.put(i.f.tag_del_post_is_self, sparseArray8.get(i.f.tag_del_post_is_self));
                sparseArray9.put(i.f.tag_del_post_type, sparseArray8.get(i.f.tag_del_post_type));
                sparseArray9.put(i.f.tag_del_post_id, sparseArray8.get(i.f.tag_del_post_id));
                sparseArray9.put(i.f.tag_manage_user_identity, sparseArray8.get(i.f.tag_manage_user_identity));
                this.cmk.ahq().agl().setTag(sparseArray9);
                this.cmk.ahq().agl().setVisibility(0);
                this.cmk.ahq().agk().setVisibility(8);
                com.baidu.tbadk.core.util.am.c(this.cmk.ahq().agl(), i.e.icon_pb_gag);
            } else {
                boolean booleanValue6 = sparseArray8.get(i.f.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray8.get(i.f.tag_del_post_is_self)).booleanValue() : false;
                String str2 = sparseArray8.get(i.f.tag_forbid_user_post_id) instanceof String ? (String) sparseArray8.get(i.f.tag_forbid_user_post_id) : null;
                if (es(booleanValue6) & isLogin()) {
                    this.cmk.ahq().agl().setVisibility(0);
                    this.cmk.ahq().agl().setTag(str2);
                } else {
                    this.cmk.ahq().agl().setVisibility(8);
                }
            }
        }
        if (this.cmi.isMarked()) {
            this.cmk.ahq().afY().setText(i.h.marked);
            this.cmk.ahq().afY().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.cmk.ahq().afY().setText(i.h.mark);
            this.cmk.ahq().afY().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.cmk.ahq().eC(false);
        this.cmk.ahr().reLayoutWidth();
        if (view != null) {
            this.cmk.ahr().showWindowInLeftCenterOfHost(view, false);
        }
    }

    private boolean es(boolean z) {
        return (this.cmi == null || this.cmi.ahA() == null || z || this.cmi.aeS() != 0 || this.cmi.ahA().afi() == null || this.cmi.ahA().afi().getAuthor() == null || !this.mIsLogin || TextUtils.equals(this.cmi.ahA().afi().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.cmi != null) {
            this.cmi.saveToBundle(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.caJ != null) {
            this.caJ.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        registerListener(this.richTextIntentClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
        this.caJ.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.chZ.onDestroy();
        this.cmi.cancelLoadData();
        this.cmi.destory();
        this.cmj.cancelLoadData();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
        this.cmk.agM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cmk.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aho = this.cmk.aho();
        if (aho == null || (findViewWithTag = aho.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean jJ(String str) {
        Map<String, String> dq;
        if (!TextUtils.isEmpty(str) && (dq = ay.dq(ay.dr(str))) != null) {
            String str2 = dq.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return jJ(com.baidu.adp.lib.util.j.aS(str2));
            }
            String str3 = dq.get(chQ);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onLinkClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (jJ(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                ay.uV().b(getPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onVideoClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onSongClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onVideoP2PClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onPhoneClicked(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int getRichTextViewId() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<TextView> getTextViewPool() {
        if (this.aBJ == null) {
            this.aBJ = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aBJ;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        if (this.aBI == null) {
            this.aBI = new com.baidu.adp.lib.e.b<>(new i(this), 8, 0);
        }
        return this.aBI;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        if (this.aBK == null) {
            this.aBK = new com.baidu.adp.lib.e.b<>(new j(this), 8, 0);
        }
        return this.aBK;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.aBL == null) {
            this.aBL = new com.baidu.adp.lib.e.b<>(new k(this), 15, 0);
        }
        return this.aBL;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cmk.ahk() && com.baidu.adp.lib.util.k.jd()) {
            this.cmi.CS();
        } else {
            this.cmk.ahn();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (sparseArray.get(i.f.tag_disable_reply_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(i.f.tag_disable_reply_mute_username);
        }
        if (sparseArray.get(i.f.tag_disable_reply_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(i.f.tag_disable_reply_thread_id);
        }
        if (sparseArray.get(i.f.tag_disable_reply_post_id) instanceof String) {
            str4 = (String) sparseArray.get(i.f.tag_disable_reply_post_id);
        }
        this.chY.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jS(String str) {
        String string;
        if (!StringUtils.isNull(str) && bc.ah(getPageContext().getPageActivity())) {
            if (!StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.tu().getString("bubble_link", ""))) {
                com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), getResources().getString(i.h.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            }
        }
    }
}
