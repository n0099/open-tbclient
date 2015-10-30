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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bd;
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
    private com.baidu.adp.lib.e.b<ImageView> aBT;
    private com.baidu.adp.lib.e.b<TextView> aBU;
    private com.baidu.adp.lib.e.b<View> aBV;
    private com.baidu.adp.lib.e.b<LinearLayout> aBW;
    private View.OnClickListener aZw;
    private View.OnLongClickListener ajU;
    private com.baidu.tbadk.editortools.c.n caU;
    private c.b ciJ;
    private com.baidu.tbadk.baseEditMark.a cii;
    private ak cmt;
    private com.baidu.tieba.tbadkCore.g.a cmu;
    private t cmv;
    private AbsListView.OnScrollListener cmw;
    private ak.a cmx;
    private com.baidu.adp.base.g cmy;
    private VoiceManager mVoiceManager;
    private static final String clM = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String cib = "tbgametype";
    private com.baidu.tieba.usermute.i cil = null;
    private a.InterfaceC0039a ciB = null;
    private a cmz = null;
    private a cmA = null;
    private UserMuteAddAndDelModel<NewSubPbActivity> cik = null;
    private i.a ciz = new com.baidu.tieba.pb.pb.sub.a(this);
    private com.baidu.tbadk.editortools.c.b ash = new l(this);
    private a.d cmB = new m(this);
    private CustomMessageListener richTextIntentClickListener = new n(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QJ();
        aha();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        ahb();
    }

    public void initUI() {
        this.cmv = new t(this, this.aZw);
        addContentView(this.cmv.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.cmv.iW(com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity()));
        this.cmv.setOnScrollListener(this.cmw);
        this.cmv.d(this);
        this.cmv.ep(true);
        this.cmv.eq(com.baidu.tbadk.core.m.qU().qW());
        this.cmv.setOnLongClickListener(this.ajU);
        this.cmv.b(new o(this));
        this.cmv.a(this.cmz);
        this.cmv.b(this.cmA);
        if (this.cmt != null && this.cmt.agX() && !this.cmt.ahL()) {
            this.cmv.ahl().setVisibility(8);
        } else {
            this.cmv.ahl().setVisibility(0);
        }
    }

    public void initData(Bundle bundle) {
        this.cil = new com.baidu.tieba.usermute.i(getPageContext(), this.ciz);
        this.cik = new UserMuteAddAndDelModel<>(this);
        this.cmt = new ak(getPageContext());
        this.cmu = new com.baidu.tieba.tbadkCore.g.a(this);
        this.cmu.setLoadDataCallBack(this.cmy);
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        this.cii = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.cii != null) {
            this.cii.a(this.ciB);
        }
        if (bundle != null) {
            this.cmt.initWithBundle(bundle);
        } else {
            this.cmt.initWithIntent(getIntent());
        }
        this.cmt.a(this.cmx);
        if (this.cmt.agX()) {
            this.cmt.CP();
        } else {
            this.cmt.ahD();
        }
    }

    public void aha() {
        this.cmx = new p(this);
        this.ciB = new q(this);
        this.cmz = new r(this);
        this.cmA = new s(this);
        this.cmy = new b(this);
    }

    public void QJ() {
        this.aZw = new c(this);
        this.cmw = new d(this);
        this.ciJ = new e(this);
        this.ajU = new f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i, String str) {
        if (!this.cmt.ahx()) {
            if (com.baidu.adp.lib.util.k.jd()) {
                if (i == 4) {
                    this.cmv.jT(String.valueOf(str) + "(4)");
                    return;
                } else {
                    this.cmv.gh(i.h.no_data_text);
                    return;
                }
            }
            this.cmv.gh(i.h.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.caU = (com.baidu.tbadk.editortools.c.n) new com.baidu.tbadk.editortools.c.r().ak(getActivity());
        this.caU.b(this);
        this.caU.b(this.cmt);
        this.caU.b(this.cmB);
        this.caU.a(this.ash);
        this.caU.c(this);
        if (this.cmv != null) {
            this.cmv.e(this.caU);
        }
        if (this.caU != null && this.cmt != null) {
            this.caU.a(this.cmt.afd());
        }
    }

    public void ahb() {
        if (!TbadkCoreApplication.isLogin()) {
            this.caU.BJ();
        } else if (this.cmt.ahI()) {
            if (!StringUtils.isNull(this.cmt.ahF()) && !StringUtils.isNull(this.cmt.ahJ())) {
                new Handler().postDelayed(new g(this), 500L);
            } else {
                this.caU.fe(null);
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
                    this.cmv.ac(view);
                }
            } else if (booleanValue2) {
                this.cmv.a(((Integer) sparseArray.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray.get(i.f.tag_del_post_id), ((Integer) sparseArray.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(i.f.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.j.a(this.cmv.ahn(), getPageContext().getPageActivity());
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
        cVar.d(getPageContext()).sR();
    }

    public void d(SparseArray<Object> sparseArray) {
        String str;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!(sparseArray.get(i.f.tag_disable_reply_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(i.f.tag_disable_reply_mute_userid);
        }
        this.cmv.Zb();
        this.cil.a(com.baidu.adp.lib.g.b.c(currentAccount, 0L), com.baidu.adp.lib.g.b.c(str, 0L), sparseArray);
    }

    public void a(a.b bVar) {
        if (bVar != null) {
            this.cmv.a(0, bVar.An, bVar.dbb, true);
            if (bVar.An) {
                if (bVar.daZ == 1) {
                    finish();
                } else if (bVar.daZ == 2) {
                    this.cmt.jW(bVar.mPostId);
                    this.cmv.a(this.cmt.ahw(), this.cmt.aeO());
                }
                am amVar = new am();
                amVar.setData(bVar);
                amVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, amVar));
            }
        }
    }

    public void jI(String str) {
        if (!StringUtils.isNull(str) && this.cmt != null) {
            String threadID = this.cmt.getThreadID();
            String Bi = this.cmt.Bi();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(i.h.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Bi + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void c(com.baidu.tieba.tbadkCore.data.k kVar) {
        if (kVar != null) {
            boolean z = false;
            if (this.cmt.isMarked() && kVar.getId() != null && kVar.getId().equals(this.cmt.ahH())) {
                z = true;
            }
            MarkData d = this.cmt.d(kVar);
            if (d != null) {
                this.cmv.agI();
                if (this.cii != null) {
                    this.cii.a(d);
                    if (!z) {
                        this.cii.qj();
                    } else {
                        this.cii.qi();
                    }
                }
            }
        }
    }

    public void replyPost(View view) {
        if (this.cmv.ahn() == null || this.cmv.ahm() == null) {
            this.cmv.afh();
        }
        if (this.cmv.ahn().getIsIntercepted()) {
            this.cmv.ahn().setIsIntercepted(false);
            return;
        }
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.k kVar = sparseArray.get(i.f.tag_load_sub_data) instanceof com.baidu.tieba.tbadkCore.data.k ? (com.baidu.tieba.tbadkCore.data.k) sparseArray.get(i.f.tag_load_sub_data) : null;
            View view2 = sparseArray.get(i.f.tag_load_sub_view) instanceof View ? (View) sparseArray.get(i.f.tag_load_sub_view) : null;
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(i.f.tag_load_sub_data, kVar);
            sparseArray2.put(i.f.tag_load_sub_view, view2);
            this.cmv.ahm().agf().setTag(sparseArray2);
            SparseArray sparseArray3 = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.k kVar2 = sparseArray3.get(i.f.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.k ? (com.baidu.tieba.tbadkCore.data.k) sparseArray3.get(i.f.tag_clip_board) : null;
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(i.f.tag_clip_board, kVar2);
            sparseArray4.put(i.f.tag_is_subpb, false);
            this.cmv.ahm().afU().setTag(sparseArray4);
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
                this.cmv.ahm().agg().setTag(sparseArray6);
                if (!"".equals(sparseArray5.get(i.f.tag_forbid_user_name)) && !"".equals(sparseArray5.get(i.f.tag_del_post_id))) {
                    an.c(this.cmv.ahm().agg(), i.e.icon_pb_set_n);
                } else {
                    an.c(this.cmv.ahm().agg(), i.e.icon_pb_del_n);
                }
                this.cmv.ahm().agg().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray7 = new SparseArray();
                sparseArray7.put(i.f.tag_should_manage_visible, false);
                sparseArray7.put(i.f.tag_display_reply_visible, false);
                sparseArray7.put(i.f.tag_should_delete_visible, true);
                sparseArray7.put(i.f.tag_manage_user_identity, sparseArray5.get(i.f.tag_manage_user_identity));
                sparseArray7.put(i.f.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray7.put(i.f.tag_del_post_id, sparseArray5.get(i.f.tag_del_post_id));
                sparseArray7.put(i.f.tag_del_post_type, sparseArray5.get(i.f.tag_del_post_type));
                this.cmv.ahm().agg().setTag(sparseArray7);
                an.c(this.cmv.ahm().agg(), i.e.icon_pb_del_n);
                this.cmv.ahm().agg().setVisibility(0);
            } else {
                this.cmv.ahm().agg().setVisibility(8);
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
                this.cmv.ahm().agh().setTag(sparseArray9);
                this.cmv.ahm().agh().setVisibility(0);
                this.cmv.ahm().agg().setVisibility(8);
                an.c(this.cmv.ahm().agh(), i.e.icon_pb_gag);
            } else {
                boolean booleanValue6 = sparseArray8.get(i.f.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray8.get(i.f.tag_del_post_is_self)).booleanValue() : false;
                String str2 = sparseArray8.get(i.f.tag_forbid_user_post_id) instanceof String ? (String) sparseArray8.get(i.f.tag_forbid_user_post_id) : null;
                if (es(booleanValue6) & isLogin()) {
                    this.cmv.ahm().agh().setVisibility(0);
                    this.cmv.ahm().agh().setTag(str2);
                } else {
                    this.cmv.ahm().agh().setVisibility(8);
                }
            }
        }
        if (this.cmt.isMarked()) {
            this.cmv.ahm().afU().setText(i.h.marked);
            this.cmv.ahm().afU().setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.cmv.ahm().afU().setText(i.h.mark);
            this.cmv.ahm().afU().setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.cmv.ahm().eC(false);
        this.cmv.ahn().reLayoutWidth();
        if (view != null) {
            this.cmv.ahn().showWindowInLeftCenterOfHost(view, false);
        }
    }

    private boolean es(boolean z) {
        return (this.cmt == null || this.cmt.ahw() == null || z || this.cmt.aeO() != 0 || this.cmt.ahw().afe() == null || this.cmt.ahw().afe().getAuthor() == null || !this.mIsLogin || TextUtils.equals(this.cmt.ahw().afe().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.cmt != null) {
            this.cmt.saveToBundle(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.caU != null) {
            this.caU.onActivityResult(i, i2, intent);
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
        this.caU.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cil.onDestroy();
        this.cmt.cancelLoadData();
        this.cmt.destory();
        this.cmu.cancelLoadData();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
        this.cmv.agI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cmv.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View ahk = this.cmv.ahk();
        if (ahk == null || (findViewWithTag = ahk.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean jJ(String str) {
        Map<String, String> dr;
        if (!TextUtils.isEmpty(str) && (dr = az.dr(az.ds(str))) != null) {
            String str2 = dr.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return jJ(com.baidu.adp.lib.util.j.aS(str2));
            }
            String str3 = dr.get(cib);
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
                az.uT().b(getPageContext(), new String[]{str});
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
        if (this.aBU == null) {
            this.aBU = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aBU;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        if (this.aBT == null) {
            this.aBT = new com.baidu.adp.lib.e.b<>(new i(this), 8, 0);
        }
        return this.aBT;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        if (this.aBV == null) {
            this.aBV = new com.baidu.adp.lib.e.b<>(new j(this), 8, 0);
        }
        return this.aBV;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.aBW == null) {
            this.aBW = new com.baidu.adp.lib.e.b<>(new k(this), 15, 0);
        }
        return this.aBW;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cmv.ahg() && com.baidu.adp.lib.util.k.jd()) {
            this.cmt.CP();
        } else {
            this.cmv.ahj();
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
        this.cik.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jS(String str) {
        String string;
        if (!StringUtils.isNull(str) && bd.ah(getPageContext().getPageActivity())) {
            if (!StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.tr().getString("bubble_link", ""))) {
                com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), getResources().getString(i.h.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            }
        }
    }
}
