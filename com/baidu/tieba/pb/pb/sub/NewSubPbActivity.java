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
    private com.baidu.adp.lib.e.b<ImageView> aDn;
    private com.baidu.adp.lib.e.b<TextView> aDo;
    private com.baidu.adp.lib.e.b<View> aDp;
    private com.baidu.adp.lib.e.b<LinearLayout> aDq;
    private View.OnClickListener aZv;
    private View.OnLongClickListener alb;
    private com.baidu.tbadk.editortools.c.n bWV;
    private com.baidu.tbadk.baseEditMark.a cbH;
    private c.b cci;
    private ak cgM;
    private com.baidu.tieba.tbadkCore.h.a cgN;
    private t cgO;
    private AbsListView.OnScrollListener cgP;
    private ak.a cgQ;
    private com.baidu.adp.base.g cgR;
    private VoiceManager mVoiceManager;
    private static final String cgj = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String cbB = "tbgametype";
    private com.baidu.tieba.usermute.i cbK = null;
    private a.InterfaceC0039a cca = null;
    private a cgS = null;
    private a cgT = null;
    private UserMuteAddAndDelModel<NewSubPbActivity> cbJ = null;
    private i.a cbY = new com.baidu.tieba.pb.pb.sub.a(this);
    private com.baidu.tbadk.editortools.c.b atJ = new l(this);
    private a.d cgU = new m(this);
    private CustomMessageListener richTextIntentClickListener = new n(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        afg();
        aff();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        afi();
    }

    public void initUI() {
        this.cgO = new t(this, this.aZv);
        addContentView(this.cgO.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.cgO.iM(com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity()));
        this.cgO.setOnScrollListener(this.cgP);
        this.cgO.d(this);
        this.cgO.eo(true);
        this.cgO.ep(com.baidu.tbadk.core.m.rb().rd());
        this.cgO.setOnLongClickListener(this.alb);
        this.cgO.b(new o(this));
        this.cgO.a(this.cgS);
        this.cgO.b(this.cgT);
        if (this.cgM != null && this.cgM.afc()) {
            this.cgO.afs().setVisibility(8);
        } else {
            this.cgO.afs().setVisibility(0);
        }
    }

    public void initData(Bundle bundle) {
        this.cbK = new com.baidu.tieba.usermute.i(getPageContext(), this.cbY);
        this.cbJ = new UserMuteAddAndDelModel<>(this);
        this.cgM = new ak(getPageContext());
        this.cgN = new com.baidu.tieba.tbadkCore.h.a(this);
        this.cgN.setLoadDataCallBack(this.cgR);
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        this.cbH = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.cbH != null) {
            this.cbH.a(this.cca);
        }
        if (bundle != null) {
            this.cgM.initWithBundle(bundle);
        } else {
            this.cgM.initWithIntent(getIntent());
        }
        this.cgM.a(this.cgQ);
        if (this.cgM.afc()) {
            this.cgM.Df();
        } else {
            this.cgM.afK();
        }
    }

    public void aff() {
        this.cgQ = new p(this);
        this.cca = new q(this);
        this.cgS = new r(this);
        this.cgT = new s(this);
        this.cgR = new b(this);
    }

    public void afg() {
        this.aZv = new c(this);
        this.cgP = new d(this);
        this.cci = new e(this);
        this.alb = new f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afh() {
        if (!this.cgM.afE()) {
            if (com.baidu.adp.lib.util.k.jc()) {
                this.cgO.gc(i.h.no_data_text);
            } else {
                this.cgO.gc(i.h.recommend_pb_no_net_text);
            }
        }
    }

    private void initEditor() {
        this.bWV = (com.baidu.tbadk.editortools.c.n) new com.baidu.tbadk.editortools.c.r().al(getActivity());
        this.bWV.b(this);
        this.bWV.b(this.cgM);
        this.bWV.b(this.cgU);
        this.bWV.a(this.atJ);
        this.bWV.c(this);
        if (this.cgO != null) {
            this.cgO.e(this.bWV);
        }
        if (this.bWV != null && this.cgM != null) {
            this.bWV.a(this.cgM.adj());
        }
    }

    public void afi() {
        if (!TbadkCoreApplication.isLogin()) {
            this.bWV.BZ();
        } else if (this.cgM.afO()) {
            if (!StringUtils.isNull(this.cgM.afM()) && !StringUtils.isNull(this.cgM.afP())) {
                new Handler().postDelayed(new g(this), 500L);
            } else {
                this.bWV.eZ(null);
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
                    this.cgO.aa(view);
                }
            } else if (booleanValue2) {
                this.cgO.a(((Integer) sparseArray.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray.get(i.f.tag_del_post_id), ((Integer) sparseArray.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(i.f.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.j.a(this.cgO.afu(), getPageContext().getPageActivity());
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
        cVar.d(getPageContext()).sX();
    }

    public void d(SparseArray<Object> sparseArray) {
        String str;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!(sparseArray.get(i.f.tag_disable_reply_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(i.f.tag_disable_reply_mute_userid);
        }
        this.cgO.Yx();
        this.cbK.a(com.baidu.adp.lib.g.b.c(currentAccount, 0L), com.baidu.adp.lib.g.b.c(str, 0L), sparseArray);
    }

    public void a(a.b bVar) {
        if (bVar != null) {
            this.cgO.a(0, bVar.Am, bVar.cSW, true);
            if (bVar.Am) {
                if (bVar.cSU == 1) {
                    finish();
                } else if (bVar.cSU == 2) {
                    this.cgM.jB(bVar.mPostId);
                    this.cgO.a(this.cgM.afD(), this.cgM.acU());
                }
                am amVar = new am();
                amVar.setData(bVar);
                amVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, amVar));
            }
        }
    }

    public void jp(String str) {
        if (!StringUtils.isNull(str) && this.cgM != null) {
            String threadID = this.cgM.getThreadID();
            String By = this.cgM.By();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(i.h.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + By + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.i iVar) {
        if (iVar != null) {
            boolean z = false;
            if (this.cgM.isMarked() && iVar.getId() != null && iVar.getId().equals(this.cgM.afN())) {
                z = true;
            }
            MarkData c = this.cgM.c(iVar);
            if (c != null) {
                this.cgO.aeO();
                if (this.cbH != null) {
                    this.cbH.a(c);
                    if (!z) {
                        this.cbH.qq();
                    } else {
                        this.cbH.qp();
                    }
                }
            }
        }
    }

    public void replyPost(View view) {
        if (this.cgO.afu() == null || this.cgO.aft() == null) {
            this.cgO.adn();
        }
        if (this.cgO.afu().getIsIntercepted()) {
            this.cgO.afu().setIsIntercepted(false);
            return;
        }
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.i iVar = sparseArray.get(i.f.tag_load_sub_data) instanceof com.baidu.tieba.tbadkCore.data.i ? (com.baidu.tieba.tbadkCore.data.i) sparseArray.get(i.f.tag_load_sub_data) : null;
            View view2 = sparseArray.get(i.f.tag_load_sub_view) instanceof View ? (View) sparseArray.get(i.f.tag_load_sub_view) : null;
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(i.f.tag_load_sub_data, iVar);
            sparseArray2.put(i.f.tag_load_sub_view, view2);
            this.cgO.aft().ael().setTag(sparseArray2);
            SparseArray sparseArray3 = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.i iVar2 = sparseArray3.get(i.f.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.i ? (com.baidu.tieba.tbadkCore.data.i) sparseArray3.get(i.f.tag_clip_board) : null;
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(i.f.tag_clip_board, iVar2);
            sparseArray4.put(i.f.tag_is_subpb, false);
            this.cgO.aft().aea().setTag(sparseArray4);
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
                this.cgO.aft().aem().setTag(sparseArray6);
                if (!"".equals(sparseArray5.get(i.f.tag_forbid_user_name)) && !"".equals(sparseArray5.get(i.f.tag_del_post_id))) {
                    com.baidu.tbadk.core.util.al.c(this.cgO.aft().aem(), i.e.icon_pb_set_n);
                } else {
                    com.baidu.tbadk.core.util.al.c(this.cgO.aft().aem(), i.e.icon_pb_del_n);
                }
                this.cgO.aft().aem().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray7 = new SparseArray();
                sparseArray7.put(i.f.tag_should_manage_visible, false);
                sparseArray7.put(i.f.tag_display_reply_visible, false);
                sparseArray7.put(i.f.tag_should_delete_visible, true);
                sparseArray7.put(i.f.tag_manage_user_identity, sparseArray5.get(i.f.tag_manage_user_identity));
                sparseArray7.put(i.f.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray7.put(i.f.tag_del_post_id, sparseArray5.get(i.f.tag_del_post_id));
                sparseArray7.put(i.f.tag_del_post_type, sparseArray5.get(i.f.tag_del_post_type));
                this.cgO.aft().aem().setTag(sparseArray7);
                com.baidu.tbadk.core.util.al.c(this.cgO.aft().aem(), i.e.icon_pb_del_n);
                this.cgO.aft().aem().setVisibility(0);
            } else {
                this.cgO.aft().aem().setVisibility(8);
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
                this.cgO.aft().aen().setTag(sparseArray9);
                this.cgO.aft().aen().setVisibility(0);
                this.cgO.aft().aem().setVisibility(8);
                com.baidu.tbadk.core.util.al.c(this.cgO.aft().aen(), i.e.icon_pb_gag);
            } else {
                boolean booleanValue6 = sparseArray8.get(i.f.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray8.get(i.f.tag_del_post_is_self)).booleanValue() : false;
                String str2 = sparseArray8.get(i.f.tag_forbid_user_post_id) instanceof String ? (String) sparseArray8.get(i.f.tag_forbid_user_post_id) : null;
                if (ek(booleanValue6) & isLogin()) {
                    this.cgO.aft().aen().setVisibility(0);
                    this.cgO.aft().aen().setTag(str2);
                } else {
                    this.cgO.aft().aen().setVisibility(8);
                }
            }
        }
        if (this.cgM.isMarked()) {
            this.cgO.aft().aea().setText(i.h.marked);
            this.cgO.aft().aea().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.cgO.aft().aea().setText(i.h.mark);
            this.cgO.aft().aea().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.cgO.aft().ex(false);
        this.cgO.afu().reLayoutWidth();
        if (view != null) {
            this.cgO.afu().showWindowInLeftCenterOfHost(view, false);
        }
    }

    private boolean ek(boolean z) {
        return (this.cgM == null || this.cgM.afD() == null || z || this.cgM.acU() != 0 || this.cgM.afD().adk() == null || this.cgM.afD().adk().getAuthor() == null || !this.mIsLogin || TextUtils.equals(this.cgM.afD().adk().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.cgM != null) {
            this.cgM.saveToBundle(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.bWV != null) {
            this.bWV.onActivityResult(i, i2, intent);
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
        this.bWV.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cbK.onDestroy();
        this.cgM.cancelLoadData();
        this.cgM.destory();
        this.cgN.cancelLoadData();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
        this.cgO.aeO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cgO.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View afr = this.cgO.afr();
        if (afr == null || (findViewWithTag = afr.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean jq(String str) {
        Map<String, String> dl;
        if (!TextUtils.isEmpty(str) && (dl = ax.dl(ax.dm(str))) != null) {
            String str2 = dl.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return jq(com.baidu.adp.lib.util.j.aS(str2));
            }
            String str3 = dl.get(cbB);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void onLinkClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (jq(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                ax.uX().b(getPageContext(), new String[]{str});
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
        if (this.aDo == null) {
            this.aDo = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aDo;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        if (this.aDn == null) {
            this.aDn = new com.baidu.adp.lib.e.b<>(new i(this), 8, 0);
        }
        return this.aDn;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        if (this.aDp == null) {
            this.aDp = new com.baidu.adp.lib.e.b<>(new j(this), 8, 0);
        }
        return this.aDp;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.aDq == null) {
            this.aDq = new com.baidu.adp.lib.e.b<>(new k(this), 15, 0);
        }
        return this.aDq;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cgO.afn() && com.baidu.adp.lib.util.k.jc()) {
            this.cgM.Df();
        } else {
            this.cgO.afq();
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
        this.cbJ.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jy(String str) {
        String string;
        if (!StringUtils.isNull(str) && bb.ah(getPageContext().getPageActivity())) {
            if (!StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.tx().getString("bubble_link", ""))) {
                com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), getResources().getString(i.h.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            }
        }
    }
}
