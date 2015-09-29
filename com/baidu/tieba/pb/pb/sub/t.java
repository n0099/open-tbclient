package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.ca;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t {
    private static final int cms = TbadkCoreApplication.m411getInst().getListItemRule().wm();
    private NoNetworkView aQP;
    private View.OnClickListener aZl;
    private RelativeLayout ceD;
    private com.baidu.tbadk.core.view.a clm;
    private aj cmB;
    private View cmC;
    private ArrayList<com.baidu.tieba.tbadkCore.data.k> cmI;
    private String cmJ;
    private com.baidu.tieba.pb.a.c cmK;
    private View cmt;
    private ai cmu;
    private NewSubPbActivity cmv;
    private RelativeLayout cmw;
    private BdListView mListView;
    private ProgressBar mProgress;
    private com.baidu.tbadk.core.view.m mNoDataView = null;
    private View.OnClickListener Sh = null;
    private NavigationBar mNavigationBar = null;
    private TextView cmx = null;
    private TextView WM = null;
    private HeadImageView cgY = null;
    private TextView aHN = null;
    private ImageView cgZ = null;
    private ImageView cha = null;
    private TextView cmy = null;
    private ImageView chc = null;
    private TextView bpA = null;
    private TbRichTextView che = null;
    private ImageView chd = null;
    private TextView cmz = null;
    private TextView cmA = null;
    private MorePopupWindow cif = null;
    private ca cig = null;
    private com.baidu.tbadk.core.dialog.c ckY = null;
    private UserIconBox bcC = null;
    private UserIconBox aSX = null;
    private Dialog ckF = null;
    private com.baidu.tbadk.core.dialog.a ckH = null;
    private boolean cgz = true;
    private boolean cgA = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cmD = null;
    private NewSubPbActivity.a cmE = null;
    private NewSubPbActivity.a cmF = null;
    private ArrayList<IconData> cgF = null;
    private ArrayList<IconData> aSF = null;
    private com.baidu.tbadk.editortools.c.n caJ = null;
    private String cmG = null;
    private int cmH = 0;
    private View.OnClickListener cgG = new u(this);
    private com.baidu.tieba.pb.b.c cgH = new com.baidu.tieba.pb.b.c(new aa(this));
    protected AdapterView.OnItemClickListener cmL = new ab(this);
    protected AdapterView.OnItemLongClickListener Hx = new ac(this);

    public t(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.ceD = null;
        this.cmt = null;
        this.mListView = null;
        this.cmu = null;
        this.cmv = null;
        this.aQP = null;
        this.cmw = null;
        this.cmB = null;
        this.cmC = null;
        this.aZl = null;
        this.mProgress = null;
        this.cmv = newSubPbActivity;
        this.aZl = onClickListener;
        this.ceD = (RelativeLayout) LayoutInflater.from(this.cmv.getPageContext().getPageActivity()).inflate(i.g.new_sub_pb_layout, (ViewGroup) null);
        this.cmt = LayoutInflater.from(this.cmv.getPageContext().getPageActivity()).inflate(i.g.new_sub_pb_head, (ViewGroup) null);
        this.aQP = (NoNetworkView) this.ceD.findViewById(i.f.view_no_network);
        ahh();
        HD();
        this.cmw = (RelativeLayout) this.ceD.findViewById(i.f.sub_pb_body_layout);
        this.mListView = (BdListView) this.ceD.findViewById(i.f.new_sub_pb_list);
        this.mListView.addHeaderView(this.cmt);
        this.cmu = new ai(this.cmv.getPageContext().getPageActivity());
        this.cmu.D(this.cgG);
        this.cmu.setIsFromCDN(this.mIsFromCDN);
        this.mListView.setAdapter((ListAdapter) this.cmu);
        this.cmB = new aj(this.cmv.getPageContext());
        this.cmC = this.cmB.getView();
        this.mListView.setNextPage(this.cmB);
        this.cmB.setOnClickListener(this.aZl);
        this.mListView.setOnItemClickListener(this.cmL);
        this.mListView.setOnItemLongClickListener(this.Hx);
        this.mListView.setOnTouchListener(this.cgH);
        this.mProgress = (ProgressBar) this.ceD.findViewById(i.f.progress);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.cmt != null) {
            this.cmt.setVisibility(4);
        }
        if (this.cmw != null) {
            this.cmw.setVisibility(4);
        }
    }

    public void HD() {
        this.cgY = (HeadImageView) this.cmt.findViewById(i.f.photo);
        this.cgY.setOnClickListener(this.aZl);
        this.aHN = (TextView) this.cmt.findViewById(i.f.user_name);
        this.cgZ = (ImageView) this.cmt.findViewById(i.f.user_rank);
        this.cha = (ImageView) this.cmt.findViewById(i.f.user_gender);
        this.chd = (ImageView) this.cmt.findViewById(i.f.reply);
        this.cmz = (TextView) this.cmt.findViewById(i.f.manage_btn);
        this.cmy = (TextView) this.cmt.findViewById(i.f.floor);
        this.chc = (ImageView) this.cmt.findViewById(i.f.floor_owner);
        this.bpA = (TextView) this.cmt.findViewById(i.f.time);
        this.bcC = (UserIconBox) this.cmt.findViewById(i.f.user_icon_box);
        this.aSX = (UserIconBox) this.cmt.findViewById(i.f.user_tshow_icon_box);
        this.che = (TbRichTextView) this.cmt.findViewById(i.f.richText);
        this.che.Fq();
        this.che.f(this.cgz, true);
        this.che.setIsFromCDN(this.mIsFromCDN);
        this.che.setImageViewStretch(true);
        this.che.setTextSize(TbConfig.getContentSize());
        this.che.setVoiceViewRes(i.g.voice_play_btn);
        this.cmt.setOnTouchListener(this.cgH);
        this.cmt.setOnClickListener(this.aZl);
        this.cmA = (TextView) this.cmt.findViewById(i.f.pb_item_tail_content);
        this.cmA.setOnClickListener(this.aZl);
    }

    public void ahh() {
        this.mNavigationBar = (NavigationBar) this.ceD.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.WM = this.mNavigationBar.setTitleText("");
        this.cmx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cmv.getResources().getString(i.h.view_subject), this.aZl);
        this.cmx.setVisibility(8);
    }

    public void afl() {
        this.cig = new ca(this.cmv.getPageContext(), this.aZl);
        this.cig.eD(TbadkCoreApplication.isLogin());
        this.cif = new MorePopupWindow(this.cmv.getPageContext().getPageActivity(), this.cig.getView(), this.cmv.getResources().getDrawable(i.e.bg_collect), null);
        this.cif.setTouchInterceptor(new ad(this));
        this.cif.onChangeSkinType(this.cmv, TbadkCoreApplication.m411getInst().getSkinType(), com.baidu.tbadk.core.util.am.getDrawable(i.e.bg_collect));
    }

    public void ac(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.ckF == null) {
            this.ckF = new Dialog(this.cmv.getPageContext().getPageActivity(), i.C0057i.common_alert_dialog);
            this.ckF.setCanceledOnTouchOutside(true);
            this.ckF.setCancelable(true);
            View inflate = LayoutInflater.from(this.cmv.getPageContext().getPageActivity()).inflate(i.g.forum_manage_dialog, (ViewGroup) null);
            this.cmv.getLayoutMode().k(inflate);
            this.ckF.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.ckF.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.cmv.getPageContext().getPageActivity()) * 0.9d);
            this.ckF.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ckF.findViewById(i.f.del_post_btn);
        TextView textView2 = (TextView) this.ckF.findViewById(i.f.forbid_user_btn);
        TextView textView3 = (TextView) this.ckF.findViewById(i.f.disable_reply_btn);
        if ("".equals(sparseArray.get(i.f.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(i.f.tag_del_post_id, sparseArray.get(i.f.tag_del_post_id));
            sparseArray2.put(i.f.tag_del_post_type, sparseArray.get(i.f.tag_del_post_type));
            sparseArray2.put(i.f.tag_del_post_is_self, sparseArray.get(i.f.tag_del_post_is_self));
            sparseArray2.put(i.f.tag_manage_user_identity, sparseArray.get(i.f.tag_manage_user_identity));
            textView.setOnClickListener(new ae(this));
        }
        if ("".equals(sparseArray.get(i.f.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(i.f.tag_forbid_user_name, sparseArray.get(i.f.tag_forbid_user_name));
            sparseArray3.put(i.f.tag_manage_user_identity, sparseArray.get(i.f.tag_manage_user_identity));
            sparseArray3.put(i.f.tag_forbid_user_post_id, sparseArray.get(i.f.tag_forbid_user_post_id));
            textView2.setOnClickListener(new af(this));
        }
        if (!((sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean) && ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(i.h.un_mute);
            } else {
                textView3.setText(i.h.mute);
            }
            sparseArray4.put(i.f.tag_is_mem, sparseArray.get(i.f.tag_is_mem));
            sparseArray4.put(i.f.tag_disable_reply_mute_userid, sparseArray.get(i.f.tag_disable_reply_mute_userid));
            sparseArray4.put(i.f.tag_disable_reply_mute_username, sparseArray.get(i.f.tag_disable_reply_mute_username));
            sparseArray4.put(i.f.tag_disable_reply_post_id, sparseArray.get(i.f.tag_disable_reply_post_id));
            sparseArray4.put(i.f.tag_disable_reply_thread_id, sparseArray.get(i.f.tag_disable_reply_thread_id));
            textView3.setOnClickListener(new ag(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.ckF, this.cmv.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(i.f.tag_del_post_id, str);
        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = i.h.del_post_confirm;
        if (i == 0) {
            i3 = i.h.del_thread_confirm;
        }
        this.ckH = new com.baidu.tbadk.core.dialog.a(this.cmv.getPageContext().getPageActivity());
        this.ckH.bF(i3);
        this.ckH.x(sparseArray);
        this.ckH.a(i.h.dialog_ok, new ah(this, sparseArray));
        this.ckH.b(i.h.dialog_cancel, new v(this));
        this.ckH.aj(true);
        this.ckH.b(this.cmv.getPageContext());
        this.ckH.sR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
            } else {
                this.mListView.postDelayed(new w(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.ckY != null) {
            this.ckY.dismiss();
            this.ckY = null;
        }
        if (z) {
            string = this.cmv.getResources().getString(i.h.remove_mark);
        } else {
            string = this.cmv.getResources().getString(i.h.mark);
        }
        this.ckY = new com.baidu.tbadk.core.dialog.c(this.cmv.getPageContext().getPageActivity());
        this.ckY.bI(i.h.operation);
        this.ckY.a(new String[]{this.cmv.getResources().getString(i.h.copy), string}, bVar);
        this.ckY.d(this.cmv.getPageContext());
        this.ckY.sU();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.cmE = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.cmF = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.cmv.showToast(this.cmv.getResources().getString(i.h.success));
        } else if (str != null && z2) {
            this.cmv.showToast(str);
        }
    }

    public void ab(View view) {
        if (this.mNavigationBar.getVisibility() == 0) {
            this.mNavigationBar.setVisibility(8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                bc.a((View) this.ceD, i.c.cp_link_tip_b, true);
                return;
            }
            return;
        }
        this.mNavigationBar.setVisibility(0);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            bc.r(this.ceD);
        }
    }

    public void e(com.baidu.tbadk.editortools.c.n nVar) {
        if (nVar != null && nVar.Ax() != null) {
            this.caJ = nVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ceD.addView(nVar.Ax(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int i, View view) {
        new Handler().postDelayed(new x(this, view, i), 300L);
    }

    public void eq(boolean z) {
        this.cgA = z;
        this.cmu.eq(z);
    }

    public void iW(int i) {
        this.che.setMaxImageWidth(i);
        this.che.setMaxImageHeight((int) (i * 1.618f));
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void d(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.ceD;
    }

    public void aY(String str, String str2) {
        this.cmJ = str2;
        new Handler().postDelayed(new y(this, str2, str), 200L);
    }

    public void agM() {
        if (this.cif != null) {
            com.baidu.adp.lib.g.j.a(this.cif, this.cmv.getPageContext().getPageActivity());
        }
        if (this.ckY != null) {
            this.ckY.dismiss();
        }
        if (this.ckH != null) {
            this.ckH.dismiss();
        }
        if (this.ckF != null) {
            com.baidu.adp.lib.g.j.b(this.ckF, this.cmv.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
    }

    public void ahi() {
        this.mListView.setNextPage(this.cmB);
        this.cmB.startLoadData();
    }

    public void ep(boolean z) {
        this.cgz = z;
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i) {
        int i2;
        int i3;
        int i4;
        String userId;
        boolean z = false;
        if (cVar != null) {
            this.cmK = cVar;
            this.cmu.e(this.cmK.afi());
            if (this.cmt != null) {
                this.cmt.setVisibility(0);
            }
            if (this.cmw != null) {
                this.cmw.setVisibility(0);
            }
            if (cVar.aeZ() != null) {
                this.cmG = cVar.aeZ().getId();
                this.cmH = cVar.aeZ().awy();
                if (this.cmH > 0) {
                    this.WM.setText(String.format(this.cmv.getPageContext().getString(i.h.is_floor), Integer.valueOf(this.cmH)));
                } else {
                    this.WM.setText((CharSequence) null);
                }
            }
            if (cVar.hasMore()) {
                this.cmB.startLoadData();
                this.cmu.setHasMoreData(true);
            } else {
                this.cmB.vy();
                this.cmu.setHasMoreData(false);
            }
            this.cmI = cVar.afd();
            if (this.cmI == null || this.cmI.size() == 0) {
                this.mListView.setNextPage(null);
            } else {
                this.mListView.setNextPage(this.cmB);
            }
            if (this.cmI == null || this.cmI.size() <= cms) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i4 = this.cmI.size() - cms;
                iX(i4);
                i3 = this.mListView.getFirstVisiblePosition() - i4;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
            }
            this.cmu.setDatas(this.cmI);
            if (cVar.afi() != null && cVar.afi().getAuthor() != null && (userId = cVar.afi().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            this.cmu.p(i, z);
            this.cmu.notifyDataSetChanged();
            a(cVar.aeZ(), cVar.WK(), cVar.qk(), i);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    public View ahj() {
        return this.chd;
    }

    private void iX(int i) {
        if (this.cmI != null) {
            if (this.cmI.size() <= i) {
                this.cmI.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.k> it = this.cmI.iterator();
            while (it.hasNext()) {
                it.next();
                i2++;
                it.remove();
                if (i2 >= i) {
                    return;
                }
            }
        }
    }

    public boolean ahk() {
        return this.cmu.cmT;
    }

    protected void a(com.baidu.tieba.tbadkCore.data.k kVar, boolean z, boolean z2, int i) {
        int i2;
        if (kVar != null) {
            this.cgY.setTag(null);
            this.cgY.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.cmt.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.cmt.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(i.f.tag_clip_board, kVar);
            sparseArray.put(i.f.tag_is_subpb, false);
            a(kVar, i, sparseArray);
            this.chd.setTag(sparseArray);
            if (!this.cgA) {
                this.cgY.setVisibility(8);
            }
            this.aHN.setOnClickListener(this.aZl);
            this.aHN.setText((CharSequence) null);
            this.chc.setVisibility(8);
            this.cmy.setText((CharSequence) null);
            this.chd.setOnClickListener(this.aZl);
            com.baidu.tbadk.core.util.am.b(this.bpA, i.c.pb_listitem_post_time, 1);
            this.bpA.setText(ar.o(kVar.getTime()));
            if (z) {
                this.chc.setVisibility(0);
                com.baidu.tbadk.core.util.am.c(this.chc, i.e.icon_floorhost);
            }
            if (this.cgz) {
                i2 = i.e.img_default_100;
            } else {
                i2 = i.e.icon_click;
            }
            this.che.setDefaultImageId(i2);
            this.cmy.setText(String.format(this.cmv.getPageContext().getString(i.h.is_floor), Integer.valueOf(kVar.awy())));
            String portrait = kVar.getAuthor().getPortrait();
            if (kVar.getAuthor() != null) {
                String name_show = kVar.getAuthor().getName_show();
                if (com.baidu.tbadk.util.n.fO(name_show) > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.n.e(name_show, 0, 14)) + "...";
                }
                this.aHN.setText(name_show);
                ArrayList<IconData> tShowInfo = kVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.am.b(this.aHN, i.c.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.b(this.aHN, i.c.cp_cont_f, 1);
                }
                int level_id = kVar.getAuthor().getLevel_id();
                int is_bawu = kVar.getAuthor().getIs_bawu();
                String bawu_type = kVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0) {
                    this.cgZ.setVisibility(0);
                    com.baidu.tbadk.core.util.am.c(this.cgZ, com.baidu.tbadk.core.util.c.ci(level_id));
                    this.cgZ.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.cgZ.setVisibility(8);
                }
                if (is_bawu != 0) {
                    this.cgZ.setOnClickListener(this.aZl);
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.am.c(this.cgZ, i.e.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.am.c(this.cgZ, i.e.pb_assist);
                    }
                }
                if (kVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.am.c(this.cha, i.e.icon_pb_pop_girl);
                    this.cha.setVisibility(0);
                } else if (kVar.getAuthor().getGender() == 1) {
                    com.baidu.tbadk.core.util.am.c(this.cha, i.e.icon_pb_pop_boy);
                    this.cha.setVisibility(0);
                } else {
                    this.cha.setVisibility(8);
                }
                this.cgF = kVar.getAuthor().getIconInfo();
                this.aSF = kVar.getAuthor().getTShowInfo();
                if (this.bcC != null) {
                    this.bcC.setOnClickListener(this.aZl);
                    this.bcC.a(this.cgF, i3, this.cmv.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.cmv.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.cmv.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                }
                if (this.aSX != null) {
                    this.aSX.setOnClickListener(this.aZl);
                    this.aSX.a(this.aSF, 2, this.cmv.getResources().getDimensionPixelSize(i.d.small_icon_width), this.cmv.getResources().getDimensionPixelSize(i.d.small_icon_height), this.cmv.getResources().getDimensionPixelSize(i.d.small_icon_margin), true);
                }
            }
            this.cgY.setUserId(kVar.getAuthor().getUserId());
            this.cgY.setUserName(kVar.getAuthor().getUserName());
            this.aHN.setTag(i.f.tag_user_id, kVar.getAuthor().getUserId());
            this.aHN.setTag(i.f.tag_user_name, kVar.getAuthor().getUserName());
            this.cgY.setDefaultResource(i.e.icon_default_avatar100);
            this.cgY.d(portrait, 28, false);
            this.che.setText(kVar.awz());
            this.cmz.setVisibility(8);
            if (!TextUtils.isEmpty(kVar.getBimg_url())) {
                this.che.setBackgroundDrawable(null);
                this.che.setTag(kVar.getBimg_url());
                this.che.setOnClickListener(this.aZl);
                this.che.setTextViewOnClickListener(this.aZl);
                this.che.setTextViewCheckSelection(false);
                com.baidu.adp.lib.f.c.ha().a(kVar.getBimg_url(), 19, new z(this), null);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.che.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                this.che.setPadding(0, 0, 0, 0);
                this.che.setLayoutParams(layoutParams);
                this.che.setBackgroundDrawable(null);
            }
            if (kVar != null) {
                com.baidu.tieba.pb.view.d.a(kVar.ahO(), this.cmA, true, false, false);
            }
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cmv.getPageContext().getString(i.h.refresh_view_title_text), this.Sh));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.cmv.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.cmw, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds140)), dVar, a, false);
        }
        this.cmw.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.caJ.BM();
        com.baidu.tbadk.core.util.am.j(this.mNoDataView, i.c.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.cmv.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gh(int i) {
        a(NoDataViewFactory.d.C(i, i.h.refresh_view_title_text));
    }

    public void jT(String str) {
        a(NoDataViewFactory.d.ag(str, this.cmv.getPageContext().getString(i.h.refresh_view_title_text)));
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.Sh = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.tieba.tbadkCore.data.k kVar, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        if (kVar != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                String userId2 = kVar.getAuthor().getUserId();
                boolean z7 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z = true;
                    z2 = false;
                } else {
                    z2 = z7;
                    z = true;
                }
            } else {
                z = false;
                z2 = false;
            }
            if (this.cmK != null && this.cmK.afi() != null && this.cmK.afi().getAuthor() != null && kVar.getAuthor() != null) {
                String userId3 = this.cmK.afi().getAuthor().getUserId();
                String userId4 = kVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = false;
                        z3 = true;
                        z4 = true;
                    } else {
                        z5 = true;
                        z3 = false;
                        z4 = true;
                    }
                    userId = kVar.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = kVar.awy() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_forbid_user_name, kVar.getAuthor().getUserName());
                        sparseArray.put(i.f.tag_forbid_user_post_id, kVar.getId());
                        z6 = true;
                    } else {
                        sparseArray.put(i.f.tag_forbid_user_name, "");
                        z6 = false;
                    }
                    if (!z4) {
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_del_post_is_self, true);
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(i.f.tag_del_post_id, kVar.getId());
                        z6 = true;
                    } else {
                        sparseArray.put(i.f.tag_del_post_is_self, false);
                        sparseArray.put(i.f.tag_del_post_type, 0);
                        sparseArray.put(i.f.tag_del_post_id, "");
                    }
                    sparseArray.put(i.f.tag_should_manage_visible, Boolean.valueOf(z6));
                    sparseArray.put(i.f.tag_forbid_user_post_id, kVar.getId());
                    if (!z2) {
                        sparseArray.put(i.f.tag_should_manage_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_forbid_user_name, kVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(i.f.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(i.f.tag_display_reply_visible, true);
                        sparseArray.put(i.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (kVar.getAuthor() != null) {
                            sparseArray.put(i.f.tag_disable_reply_mute_userid, kVar.getAuthor().getUserId());
                            sparseArray.put(i.f.tag_disable_reply_mute_username, kVar.getAuthor().getUserName());
                        }
                        if (this.cmK.afi() != null) {
                            sparseArray.put(i.f.tag_disable_reply_thread_id, this.cmK.afi().getId());
                        }
                        sparseArray.put(i.f.tag_disable_reply_post_id, kVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_display_reply_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(i.f.tag_should_delete_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(i.f.tag_del_post_id, kVar.getId());
                        return;
                    }
                    sparseArray.put(i.f.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = kVar.getAuthor().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (kVar.awy() != 1) {
            }
            if (!z2) {
            }
            if (!z4) {
            }
            sparseArray.put(i.f.tag_should_manage_visible, Boolean.valueOf(z6));
            sparseArray.put(i.f.tag_forbid_user_post_id, kVar.getId());
            if (!z2) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public View ahl() {
        return this.cmC;
    }

    public void onChangeSkinType(int i) {
        this.cmv.getLayoutMode().ad(i == 1);
        this.cmv.getLayoutMode().k(this.ceD);
        this.cmv.getLayoutMode().k(this.cmt);
        this.mNavigationBar.onChangeSkinType(this.cmv.getPageContext(), i);
        this.aQP.onChangeSkinType(this.cmv.getPageContext(), i);
        this.cmv.getLayoutMode().k(this.cmC);
        com.baidu.tbadk.core.util.am.c(this.chd, i.e.btn_pb_reply_selector);
        this.che.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.pb_listitem_content));
        this.che.setVideoImageId(i.e.pic_video);
        if (this.caJ != null && this.caJ.Ax() != null) {
            this.caJ.Ax().onChangeSkinType(i);
        }
    }

    public void ahm() {
        this.mProgress.setVisibility(0);
    }

    public void ahn() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.cmB.vy();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmD = onLongClickListener;
        this.cmt.setOnLongClickListener(this.cmD);
    }

    public View aho() {
        return this.cmt;
    }

    public void jU(String str) {
        int jV = this.cmu.jV(str);
        if (jV > -1) {
            this.mListView.setSelection(jV + 1);
            this.mListView.invalidate();
        }
    }

    public View ahp() {
        return this.cmx;
    }

    public ca ahq() {
        return this.cig;
    }

    public MorePopupWindow ahr() {
        return this.cif;
    }

    public HeadImageView ahs() {
        return this.cgY;
    }

    public TextView getUserNameView() {
        return this.aHN;
    }

    public UserIconBox aht() {
        return this.bcC;
    }

    public ImageView ahu() {
        return this.cgZ;
    }

    public UserIconBox ahv() {
        return this.aSX;
    }

    public void Zf() {
        if (this.clm == null) {
            this.clm = new com.baidu.tbadk.core.view.a(this.cmv.getPageContext());
        }
        this.clm.av(true);
    }

    public void agS() {
        if (this.clm != null) {
            this.clm.av(false);
        }
    }

    public TextView ahw() {
        return this.cmA;
    }

    public TbRichTextView ahx() {
        return this.che;
    }

    public TextView ahy() {
        if (this.che == null) {
            return null;
        }
        return this.che.getTextView();
    }
}
