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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.ak;
import com.baidu.tieba.tbadkCore.h.a;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.i;
import java.util.Map;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.i {
    private com.baidu.adp.lib.e.b<ImageView> aBF;
    private com.baidu.adp.lib.e.b<TextView> aBG;
    private com.baidu.adp.lib.e.b<View> aBH;
    private com.baidu.adp.lib.e.b<LinearLayout> aBI;
    private View.OnClickListener aZc;
    private View.OnLongClickListener akJ;
    private com.baidu.tbadk.editortools.c.n bWp;
    private com.baidu.tbadk.baseEditMark.a caM;
    private c.b cbn;
    private ak cfP;
    private com.baidu.tieba.tbadkCore.h.a cfQ;
    private t cfR;
    private AbsListView.OnScrollListener cfS;
    private ak.a cfT;
    private com.baidu.adp.base.g cfU;
    private VoiceManager mVoiceManager;
    private static final String cfm = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String caG = "tbgametype";
    private com.baidu.tieba.usermute.i caP = null;
    private a.InterfaceC0039a cbf = null;
    private a cfV = null;
    private a cfW = null;
    private UserMuteAddAndDelModel<NewSubPbActivity> caO = null;
    private i.a cbd = new com.baidu.tieba.pb.pb.sub.a(this);
    private com.baidu.tbadk.editortools.c.b arZ = new l(this);
    private a.d cfX = new m(this);
    private CustomMessageListener richTextIntentClickListener = new n(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aeS();
        aeR();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        aeU();
    }

    public void initUI() {
        this.cfR = new t(this, this.aZc);
        addContentView(this.cfR.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.cfR.iA(com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity()));
        this.cfR.setOnScrollListener(this.cfS);
        this.cfR.d(this);
        this.cfR.eh(true);
        this.cfR.ei(com.baidu.tbadk.core.m.rd().rf());
        this.cfR.setOnLongClickListener(this.akJ);
        this.cfR.b(new o(this));
        this.cfR.a(this.cfV);
        this.cfR.b(this.cfW);
        if (this.cfP != null && this.cfP.aeO()) {
            this.cfR.afe().setVisibility(8);
        } else {
            this.cfR.afe().setVisibility(0);
        }
    }

    public void initData(Bundle bundle) {
        this.caP = new com.baidu.tieba.usermute.i(getPageContext(), this.cbd);
        this.caO = new UserMuteAddAndDelModel<>(this);
        this.cfP = new ak(getPageContext());
        this.cfQ = new com.baidu.tieba.tbadkCore.h.a(this);
        this.cfQ.setLoadDataCallBack(this.cfU);
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        this.caM = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.caM != null) {
            this.caM.a(this.cbf);
        }
        if (bundle != null) {
            this.cfP.initWithBundle(bundle);
        } else {
            this.cfP.initWithIntent(getIntent());
        }
        this.cfP.a(this.cfT);
        if (this.cfP.aeO()) {
            this.cfP.CV();
        } else {
            this.cfP.afu();
        }
    }

    public void aeR() {
        this.cfT = new p(this);
        this.cbf = new q(this);
        this.cfV = new r(this);
        this.cfW = new s(this);
        this.cfU = new b(this);
    }

    public void aeS() {
        this.aZc = new c(this);
        this.cfS = new d(this);
        this.cbn = new e(this);
        this.akJ = new f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeT() {
        if (!this.cfP.afp()) {
            if (com.baidu.adp.lib.util.k.jf()) {
                this.cfR.fT(i.C0057i.no_data_text);
            } else {
                this.cfR.fT(i.C0057i.recommend_pb_no_net_text);
            }
        }
    }

    private void initEditor() {
        this.bWp = (com.baidu.tbadk.editortools.c.n) new com.baidu.tbadk.editortools.c.r().al(getActivity());
        this.bWp.b(this);
        this.bWp.b(this.cfP);
        this.bWp.b(this.cfX);
        this.bWp.a(this.arZ);
        this.bWp.c(this);
        if (this.cfR != null) {
            this.cfR.e(this.bWp);
        }
        if (this.bWp != null && this.cfP != null) {
            this.bWp.a(this.cfP.acW());
        }
    }

    public void aeU() {
        if (!TbadkCoreApplication.isLogin()) {
            this.bWp.BL();
        } else if (this.cfP.afx()) {
            if (!StringUtils.isNull(this.cfP.afv()) && !StringUtils.isNull(this.cfP.afy())) {
                new Handler().postDelayed(new g(this), 500L);
            } else {
                this.bWp.eR(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(View view) {
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
                    this.cfR.aa(view);
                }
            } else if (booleanValue2) {
                this.cfR.a(((Integer) sparseArray.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray.get(i.f.tag_del_post_id), ((Integer) sparseArray.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(i.f.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.j.a(this.cfR.afg(), getPageContext().getPageActivity());
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
            strArr2[0] = getResources().getString(i.C0057i.delete);
            strArr2[1] = z ? getResources().getString(i.C0057i.un_mute) : getResources().getString(i.C0057i.mute);
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(i.C0057i.delete)};
        }
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bF(i.C0057i.operation);
        cVar.a(strArr, new h(this, sparseArray, z, str));
        cVar.d(getPageContext()).sS();
    }

    public void d(SparseArray<Object> sparseArray) {
        String str;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!(sparseArray.get(i.f.tag_disable_reply_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(i.f.tag_disable_reply_mute_userid);
        }
        this.cfR.Yv();
        this.caP.a(com.baidu.adp.lib.g.b.c(currentAccount, 0L), com.baidu.adp.lib.g.b.c(str, 0L), sparseArray);
    }

    public void a(a.b bVar) {
        if (bVar != null) {
            this.cfR.a(0, bVar.Ao, bVar.cKw, true);
            if (bVar.Ao) {
                if (bVar.cKu == 1) {
                    finish();
                } else if (bVar.cKu == 2) {
                    this.cfP.jt(bVar.mPostId);
                    this.cfR.a(this.cfP.afo(), this.cfP.acK());
                }
                am amVar = new am();
                amVar.setData(bVar);
                amVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, amVar));
            }
        }
    }

    public void jh(String str) {
        if (!StringUtils.isNull(str) && this.cfP != null) {
            String threadID = this.cfP.getThreadID();
            String Bl = this.cfP.Bl();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(i.C0057i.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Bl + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.i iVar) {
        if (iVar != null) {
            boolean z = false;
            if (this.cfP.isMarked() && iVar.getId() != null && iVar.getId().equals(this.cfP.afw())) {
                z = true;
            }
            MarkData c = this.cfP.c(iVar);
            if (c != null) {
                this.cfR.aeA();
                if (this.caM != null) {
                    this.caM.a(c);
                    if (!z) {
                        this.caM.qt();
                    } else {
                        this.caM.qs();
                    }
                }
            }
        }
    }

    public void replyPost(View view) {
        if (this.cfR.afg() == null || this.cfR.aff() == null) {
            this.cfR.ada();
        }
        if (this.cfR.afg().getIsIntercepted()) {
            this.cfR.afg().setIsIntercepted(false);
            return;
        }
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.i iVar = sparseArray.get(i.f.tag_load_sub_data) instanceof com.baidu.tieba.tbadkCore.data.i ? (com.baidu.tieba.tbadkCore.data.i) sparseArray.get(i.f.tag_load_sub_data) : null;
            View view2 = sparseArray.get(i.f.tag_load_sub_view) instanceof View ? (View) sparseArray.get(i.f.tag_load_sub_view) : null;
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(i.f.tag_load_sub_data, iVar);
            sparseArray2.put(i.f.tag_load_sub_view, view2);
            this.cfR.aff().adX().setTag(sparseArray2);
            SparseArray sparseArray3 = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.i iVar2 = sparseArray3.get(i.f.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.i ? (com.baidu.tieba.tbadkCore.data.i) sparseArray3.get(i.f.tag_clip_board) : null;
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(i.f.tag_clip_board, iVar2);
            sparseArray4.put(i.f.tag_is_subpb, false);
            this.cfR.aff().adM().setTag(sparseArray4);
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
                this.cfR.aff().adY().setTag(sparseArray6);
                if (!"".equals(sparseArray5.get(i.f.tag_forbid_user_name)) && !"".equals(sparseArray5.get(i.f.tag_del_post_id))) {
                    com.baidu.tbadk.core.util.al.c(this.cfR.aff().adY(), i.e.icon_pb_set_n);
                } else {
                    com.baidu.tbadk.core.util.al.c(this.cfR.aff().adY(), i.e.icon_pb_del_n);
                }
                this.cfR.aff().adY().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray7 = new SparseArray();
                sparseArray7.put(i.f.tag_should_manage_visible, false);
                sparseArray7.put(i.f.tag_display_reply_visible, false);
                sparseArray7.put(i.f.tag_should_delete_visible, true);
                sparseArray7.put(i.f.tag_manage_user_identity, sparseArray5.get(i.f.tag_manage_user_identity));
                sparseArray7.put(i.f.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray7.put(i.f.tag_del_post_id, sparseArray5.get(i.f.tag_del_post_id));
                sparseArray7.put(i.f.tag_del_post_type, sparseArray5.get(i.f.tag_del_post_type));
                this.cfR.aff().adY().setTag(sparseArray7);
                com.baidu.tbadk.core.util.al.c(this.cfR.aff().adY(), i.e.icon_pb_del_n);
                this.cfR.aff().adY().setVisibility(0);
            } else {
                this.cfR.aff().adY().setVisibility(8);
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
                this.cfR.aff().adZ().setTag(sparseArray9);
                this.cfR.aff().adZ().setVisibility(0);
                this.cfR.aff().adY().setVisibility(8);
                com.baidu.tbadk.core.util.al.c(this.cfR.aff().adZ(), i.e.icon_pb_gag);
            } else {
                boolean booleanValue6 = sparseArray8.get(i.f.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray8.get(i.f.tag_del_post_is_self)).booleanValue() : false;
                String str2 = sparseArray8.get(i.f.tag_forbid_user_post_id) instanceof String ? (String) sparseArray8.get(i.f.tag_forbid_user_post_id) : null;
                if (ed(booleanValue6) & isLogin()) {
                    this.cfR.aff().adZ().setVisibility(0);
                    this.cfR.aff().adZ().setTag(str2);
                } else {
                    this.cfR.aff().adZ().setVisibility(8);
                }
            }
        }
        if (this.cfP.isMarked()) {
            this.cfR.aff().adM().setText(i.C0057i.marked);
            this.cfR.aff().adM().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.cfR.aff().adM().setText(i.C0057i.mark);
            this.cfR.aff().adM().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.cfR.aff().ep(false);
        this.cfR.afg().reLayoutWidth();
        if (view != null) {
            this.cfR.afg().showWindowInLeftCenterOfHost(view, false);
        }
    }

    private boolean ed(boolean z) {
        return (this.cfP == null || this.cfP.afo() == null || z || this.cfP.acK() != 0 || this.cfP.afo().acX() == null || this.cfP.afo().acX().getAuthor() == null || !this.mIsLogin || TextUtils.equals(this.cfP.afo().acX().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.cfP != null) {
            this.cfP.saveToBundle(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.bWp != null) {
            this.bWp.onActivityResult(i, i2, intent);
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
        this.bWp.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.caP.onDestroy();
        this.cfP.cancelLoadData();
        this.cfP.destory();
        this.cfQ.cancelLoadData();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
        this.cfR.aeA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cfR.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View afd = this.cfR.afd();
        if (afd == null || (findViewWithTag = afd.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean ji(String str) {
        Map<String, String> df;
        if (!TextUtils.isEmpty(str) && (df = ax.df(ax.dg(str))) != null) {
            String str2 = df.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ji(com.baidu.adp.lib.util.j.aS(str2));
            }
            String str3 = df.get(caG);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onLinkClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ji(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                ax.uR().b(getPageContext(), new String[]{str});
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
        if (this.aBG == null) {
            this.aBG = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aBG;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        if (this.aBF == null) {
            this.aBF = new com.baidu.adp.lib.e.b<>(new i(this), 8, 0);
        }
        return this.aBF;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        if (this.aBH == null) {
            this.aBH = new com.baidu.adp.lib.e.b<>(new j(this), 8, 0);
        }
        return this.aBH;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.aBI == null) {
            this.aBI = new com.baidu.adp.lib.e.b<>(new k(this), 15, 0);
        }
        return this.aBI;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cfR.aeZ() && com.baidu.adp.lib.util.k.jf()) {
            this.cfP.CV();
        } else {
            this.cfR.afc();
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
        this.caO.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jq(String str) {
        String string;
        if (!StringUtils.isNull(str) && bb.ah(getPageContext().getPageActivity())) {
            if (!StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.ts().getString("bubble_link", ""))) {
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(i.C0057i.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            }
        }
    }
}
