package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.media.TransportMediator;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
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
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.an;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.dq;
import com.baidu.tieba.pb.pb.main.ew;
import com.baidu.tieba.pb.pb.main.ex;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ao {
    private static final int eEv = TbadkCoreApplication.m9getInst().getListItemRule().xW();
    private BdListView Cj;
    private View bOE;
    private NoNetworkView bPG;
    private View.OnClickListener bpk;
    private ProgressBar cub;
    private com.baidu.tbadk.core.view.a eBW;
    private com.baidu.tieba.pb.data.n eDA;
    private TextView eEA;
    private ThreadSkinView eEK;
    private bb eEL;
    private View eEO;
    private ArrayList<com.baidu.tieba.tbadkCore.data.q> eES;
    private String eET;
    private TextView eEU;
    private bc eEb;
    private b eEp;
    private View eEw;
    private ba eEx;
    private NewSubPbActivity eEy;
    private RelativeLayout eEz;
    private RelativeLayout eqs;
    private dq euU;
    private int maxImageWidth;
    private com.baidu.tbadk.core.view.w mNoDataView = null;
    private TbRichTextView.e eEg = null;
    private View.OnClickListener MT = null;
    private TbRichTextView.f eEf = null;
    private NavigationBar mNavigationBar = null;
    private View ajQ = null;
    private TextView eEB = null;
    private LinearLayout eEC = null;
    private HeadImageView eED = null;
    private ClickableHeaderImageView ezk = null;
    private TextView ahV = null;
    private ImageView eEE = null;
    private TextView eEF = null;
    private TextView eEG = null;
    private TextView etD = null;
    private EllipsizeRichTextView eEH = null;
    private TbImageView eEI = null;
    private PlayVoiceBntNew bds = null;
    private TextView eEJ = null;
    private MorePopupWindow eEM = null;
    private ew eEN = null;
    private com.baidu.tbadk.core.dialog.c eBK = null;
    private Dialog eBr = null;
    private com.baidu.tbadk.core.dialog.a eBt = null;
    private boolean cNW = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener bLR = null;
    private NewSubPbActivity.a eEP = null;
    private NewSubPbActivity.a eEQ = null;
    private ArrayList<IconData> etk = null;
    private ArrayList<IconData> diU = null;
    private com.baidu.tbadk.editortools.e.p dAe = null;
    private String eER = null;
    private int aIK = 0;
    private com.baidu.tieba.tbadkCore.data.q esy = null;
    private int eEV = 0;
    private int eEW = 2;
    private int eEX = 0;
    private boolean eEq = true;
    protected HashMap<Long, HashSet<String>> eEY = new HashMap<>();
    protected final b.a eEZ = new ap(this);
    private View.OnClickListener etl = new at(this);
    private com.baidu.tieba.pb.a.d esT = new com.baidu.tieba.pb.a.d(new au(this));
    protected AdapterView.OnItemClickListener eFa = new av(this);
    protected AdapterView.OnItemLongClickListener BH = new aw(this);

    public ao(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.eqs = null;
        this.eEw = null;
        this.Cj = null;
        this.eEx = null;
        this.eEy = null;
        this.bPG = null;
        this.eEz = null;
        this.eEA = null;
        this.eEL = null;
        this.eEO = null;
        this.bpk = null;
        this.cub = null;
        this.eEU = null;
        this.eEy = newSubPbActivity;
        this.bpk = onClickListener;
        this.eqs = (RelativeLayout) LayoutInflater.from(this.eEy.getPageContext().getPageActivity()).inflate(r.h.new_sub_pb_layout, (ViewGroup) null);
        this.eEw = LayoutInflater.from(this.eEy.getPageContext().getPageActivity()).inflate(r.h.new_sub_pb_head, (ViewGroup) null);
        this.eEA = (TextView) this.eqs.findViewById(r.g.no_reply_list_view);
        this.eEU = (TextView) this.eqs.findViewById(r.g.subpb_editor_tool_reply_text);
        this.eEU.setOnClickListener(this.bpk);
        this.bPG = (NoNetworkView) this.eqs.findViewById(r.g.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.K(this.eEy.getBaseContext()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds60);
        aTg();
        ZO();
        this.eEz = (RelativeLayout) this.eqs.findViewById(r.g.sub_pb_body_layout);
        this.Cj = (BdListView) this.eqs.findViewById(r.g.new_sub_pb_list);
        this.eEK = (ThreadSkinView) LayoutInflater.from(this.eEy.getPageContext().getPageActivity()).inflate(r.h.thread_skin_layout, (ViewGroup) null);
        this.Cj.addHeaderView(this.eEK);
        this.Cj.addHeaderView(this.eEw);
        this.bOE = BdListViewHelper.a(this.eEy.getActivity(), this.Cj, BdListViewHelper.HeadType.DEFAULT);
        this.eEx = new ba(this.eEy.getPageContext().getPageActivity());
        this.eEx.J(this.etl);
        this.eEx.setIsFromCDN(this.mIsFromCDN);
        this.eEx.jh(true);
        this.Cj.setAdapter((ListAdapter) this.eEx);
        this.eEL = new bb(this.eEy.getPageContext());
        this.eEO = this.eEL.getView();
        this.Cj.setNextPage(this.eEL);
        this.eEL.setOnClickListener(this.bpk);
        this.Cj.setOnItemClickListener(this.eFa);
        this.Cj.setOnTouchListener(this.esT);
        this.cub = (ProgressBar) this.eqs.findViewById(r.g.progress);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.eEw != null) {
            this.eEw.setVisibility(4);
        }
        if (this.eEz != null) {
            this.eEz.setVisibility(4);
        }
    }

    public ListView getListView() {
        return this.Cj;
    }

    public void ZO() {
        this.eEC = (LinearLayout) this.eEw.findViewById(r.g.subpb_head_user_info_root);
        this.eEC.setOnClickListener(this.bpk);
        this.eED = (HeadImageView) this.eEw.findViewById(r.g.photo);
        this.eED.setRadius(com.baidu.adp.lib.util.k.e(this.eEy.getActivity(), r.e.ds30));
        this.ezk = (ClickableHeaderImageView) this.eEw.findViewById(r.g.god_user_photo);
        this.ezk.setGodIconMargin(0);
        this.ezk.setGodIconWidth(r.e.ds24);
        this.ezk.setRadius(com.baidu.adp.lib.util.k.e(this.eEy.getActivity(), r.e.ds30));
        this.ahV = (TextView) this.eEw.findViewById(r.g.user_name);
        this.eEE = (ImageView) this.eEw.findViewById(r.g.user_rank);
        this.eEF = (TextView) this.eEw.findViewById(r.g.floor_owner);
        this.eEB = (TextView) this.eEw.findViewById(r.g.see_subject);
        this.eEB.setOnClickListener(this.bpk);
        this.eEG = (TextView) this.eEw.findViewById(r.g.floor);
        this.etD = (TextView) this.eEw.findViewById(r.g.time);
        this.eEH = (EllipsizeRichTextView) this.eEw.findViewById(r.g.content_text);
        this.eEH.setOnClickListener(this.bpk);
        com.baidu.tbadk.core.util.at.j((View) this.eEH, r.d.cp_cont_b);
        this.eEH.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_link_tip_c));
        this.eEH.setLineSpacing(0.0f, 1.25f);
        this.eEI = (TbImageView) this.eEw.findViewById(r.g.sub_pb_image);
        this.eEI.setOnClickListener(this.bpk);
        this.eEJ = (TextView) this.eEw.findViewById(r.g.advert);
        this.bds = (PlayVoiceBntNew) this.eEw.findViewById(r.g.voice_btn);
        this.eEw.setOnTouchListener(this.esT);
        this.eEw.setOnClickListener(this.bpk);
    }

    public void jf(boolean z) {
        if (this.bOE != null && this.bOE.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bOE.getLayoutParams();
            if (z) {
                aTe();
                layoutParams.height = com.baidu.adp.lib.util.k.e(this.eEy.getPageContext().getPageActivity(), r.e.ds98);
            } else {
                layoutParams.height = com.baidu.adp.lib.util.k.e(this.eEy.getPageContext().getPageActivity(), r.e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.bOE.setLayoutParams(layoutParams);
        }
    }

    private void aTe() {
        this.mNavigationBar.setmBackImageViewBg(r.f.subpb_navigationbar_close, r.f.subpb_navigationbar_close);
    }

    public View aTf() {
        return this.bOE;
    }

    public void aTg() {
        this.mNavigationBar = (NavigationBar) this.eqs.findViewById(r.g.view_navigation_bar);
        this.ajQ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajQ.getLayoutParams();
            int e = com.baidu.adp.lib.util.k.e(this.eEy.getPageContext().getPageActivity(), r.e.ds30);
            layoutParams.height = e;
            layoutParams.width = e;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.ajQ != null && (this.ajQ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ajQ.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.ajQ.setPadding(com.baidu.adp.lib.util.k.e(this.eEy.getPageContext().getPageActivity(), r.e.ds32), this.ajQ.getPaddingTop(), this.ajQ.getPaddingRight(), this.ajQ.getPaddingBottom());
            this.ajQ.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(r.f.subpb_navigationbar_back, r.f.subpb_navigationbar_back);
    }

    public NavigationBar JF() {
        return this.mNavigationBar;
    }

    public void aX(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.eBr == null) {
            this.eBr = new Dialog(this.eEy.getPageContext().getPageActivity(), r.k.common_alert_dialog);
            this.eBr.setCanceledOnTouchOutside(true);
            this.eBr.setCancelable(true);
            View inflate = LayoutInflater.from(this.eEy.getPageContext().getPageActivity()).inflate(r.h.forum_manage_dialog, (ViewGroup) null);
            this.eEy.getLayoutMode().x(inflate);
            this.eBr.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.eBr.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.eEy.getPageContext().getPageActivity()) * 0.9d);
            this.eBr.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eBr.findViewById(r.g.del_post_btn);
        TextView textView2 = (TextView) this.eBr.findViewById(r.g.forbid_user_btn);
        TextView textView3 = (TextView) this.eBr.findViewById(r.g.disable_reply_btn);
        if ("".equals(sparseArray.get(r.g.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(r.g.tag_del_post_id, sparseArray.get(r.g.tag_del_post_id));
            sparseArray2.put(r.g.tag_del_post_type, sparseArray.get(r.g.tag_del_post_type));
            sparseArray2.put(r.g.tag_del_post_is_self, sparseArray.get(r.g.tag_del_post_is_self));
            sparseArray2.put(r.g.tag_manage_user_identity, sparseArray.get(r.g.tag_manage_user_identity));
            textView.setOnClickListener(new ax(this));
        }
        if ("".equals(sparseArray.get(r.g.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(r.g.tag_forbid_user_name, sparseArray.get(r.g.tag_forbid_user_name));
            sparseArray3.put(r.g.tag_manage_user_identity, sparseArray.get(r.g.tag_manage_user_identity));
            sparseArray3.put(r.g.tag_forbid_user_post_id, sparseArray.get(r.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new ay(this));
        }
        if (!((sparseArray.get(r.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(r.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(r.j.un_mute);
            } else {
                textView3.setText(r.j.mute);
            }
            sparseArray4.put(r.g.tag_is_mem, sparseArray.get(r.g.tag_is_mem));
            sparseArray4.put(r.g.tag_user_mute_mute_userid, sparseArray.get(r.g.tag_user_mute_mute_userid));
            sparseArray4.put(r.g.tag_user_mute_mute_username, sparseArray.get(r.g.tag_user_mute_mute_username));
            sparseArray4.put(r.g.tag_user_mute_post_id, sparseArray.get(r.g.tag_user_mute_post_id));
            sparseArray4.put(r.g.tag_user_mute_thread_id, sparseArray.get(r.g.tag_user_mute_thread_id));
            textView3.setOnClickListener(new az(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.eBr, this.eEy.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(r.g.tag_del_post_id, str);
        sparseArray.put(r.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(r.g.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = r.j.del_post_confirm;
        if (i == 0) {
            i3 = r.j.del_thread_confirm;
        }
        this.eBt = new com.baidu.tbadk.core.dialog.a(this.eEy.getPageContext().getPageActivity());
        this.eBt.ca(i3);
        this.eBt.A(sparseArray);
        this.eBt.a(r.j.dialog_ok, new aq(this, sparseArray));
        this.eBt.b(r.j.dialog_cancel, new ar(this));
        this.eBt.at(true);
        this.eBt.b(this.eEy.getPageContext());
        this.eBt.tq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS(boolean z) {
        if (this.Cj != null) {
            if (!z) {
                this.Cj.setEnabled(z);
            } else {
                this.Cj.postDelayed(new as(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.eBK != null) {
            this.eBK.dismiss();
            this.eBK = null;
        }
        if (z) {
            string = this.eEy.getResources().getString(r.j.remove_mark);
        } else {
            string = this.eEy.getResources().getString(r.j.mark);
        }
        this.eBK = new com.baidu.tbadk.core.dialog.c(this.eEy.getPageContext().getPageActivity());
        this.eBK.cd(r.j.operation);
        this.eBK.a(new String[]{this.eEy.getResources().getString(r.j.copy), string}, bVar);
        this.eBK.d(this.eEy.getPageContext());
        this.eBK.tt();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.eEP = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.eEQ = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.cub != null) {
            this.cub.setVisibility(8);
        }
        if (z && z2) {
            this.eEy.showToast(this.eEy.getResources().getString(r.j.cash_del_suc));
        } else if (str != null && z2) {
            this.eEy.showToast(str);
        }
    }

    public void aW(View view) {
        if (this.bOE != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bOE.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Cj != null) {
                    this.Cj.removeHeaderView(this.bOE);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.bOE.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.eEy.getActivity(), r.e.ds98)));
            } else if (this.Cj != null) {
                this.Cj.f(this.bOE, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.e.p pVar) {
        if (pVar != null && pVar.CO() != null) {
            this.dAe = pVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eqs.addView(pVar.CO(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.eEp = bVar;
    }

    public void aTh() {
        if (this.Cj != null) {
            this.eEX = this.Cj.getLastVisiblePosition();
        }
    }

    public void aTi() {
        if (this.eEb != null) {
            if ((!aTl() && this.eEO != null && this.eEO.isShown()) || com.baidu.tbadk.core.util.x.t(this.eES)) {
                this.eEb.jj(false);
            } else {
                this.eEb.jj(true);
            }
        }
    }

    public void a(bc bcVar) {
        this.eEb = bcVar;
    }

    public void aTj() {
        d(this.eEy);
        this.Cj.setNextPage(this.eEL);
    }

    public void k(com.baidu.tieba.tbadkCore.data.q qVar) {
        int i;
        if (qVar != null) {
            qVar.lm(true);
            com.baidu.tieba.tbadkCore.data.q qVar2 = new com.baidu.tieba.tbadkCore.data.q();
            qVar2.setPostType(49);
            if (!aTl() && this.eEO != null && this.eEO.isShown()) {
                i = (this.eEX - this.eEW) - 1;
            } else {
                i = this.eEX - this.eEW;
            }
            int s = com.baidu.tbadk.core.util.x.s(this.eES);
            if (i > s) {
                i = s;
            }
            ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList = new ArrayList<>(com.baidu.tbadk.core.util.x.a(this.eES, 0, i));
            com.baidu.tbadk.core.util.x.b(arrayList, qVar2);
            com.baidu.tbadk.core.util.x.b(arrayList, qVar);
            this.eEx.setDatas(arrayList);
            this.eEx.notifyDataSetChanged();
            this.Cj.smoothScrollToPosition(this.eEX + 2);
            this.Cj.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Cj.setOnScrollListener(onScrollListener);
    }

    public void d(BdListView.e eVar) {
        this.Cj.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.eqs;
    }

    public void aCY() {
        if (this.eEM != null) {
            com.baidu.adp.lib.h.j.a(this.eEM, this.eEy.getPageContext().getPageActivity());
        }
        if (this.eBK != null) {
            this.eBK.dismiss();
        }
        if (this.eBt != null) {
            this.eBt.dismiss();
        }
        if (this.eBr != null) {
            com.baidu.adp.lib.h.j.b(this.eBr, this.eEy.getPageContext());
        }
        if (this.cub != null) {
            this.cub.setVisibility(8);
        }
        if (this.euU != null) {
            this.euU.dismiss();
        }
    }

    public void aTk() {
        this.Cj.setNextPage(this.eEL);
        this.eEL.wF();
    }

    public void ij(boolean z) {
        this.cNW = z;
    }

    public void setIsFromPb(boolean z) {
        this.eEq = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v45, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.pb.data.n nVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (nVar != null) {
            if (this.eEq && this.eEw != null) {
                this.eEx.ji(true);
                this.eEw.setVisibility(8);
                this.Cj.removeHeaderView(this.eEw);
                this.eEW = 1;
            }
            this.eDA = nVar;
            this.eEx.c(this.eDA.Jz());
            if (this.eEw != null) {
                this.eEw.setVisibility(0);
            }
            if (this.eEz != null) {
                this.eEz.setVisibility(0);
            }
            if (nVar.aOG() != null) {
                this.eER = nVar.aOG().getId();
                this.aIK = nVar.aOG().bml();
                if (this.aIK > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.eEy.getPageContext().getString(r.j.which_floor_reply), Integer.valueOf(this.aIK)));
                    this.eEU.setText(String.format(this.eEy.getPageContext().getString(r.j.reply_some_floor), Integer.valueOf(this.aIK)));
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.eEy.aTd()) {
                    str = "PB";
                }
                if (nVar.aOG().si() != null) {
                    this.eEK.a(this.eEy.getPageContext(), nVar.aOG().si(), com.baidu.tieba.tbadkCore.d.a.b("PB", "c0132", nVar.aOM().getId(), nVar.aOM().getName(), nVar.Jz().getId(), str));
                } else {
                    this.eEK.a(null, null, null);
                }
            }
            if (nVar.hasMore()) {
                this.eEL.wF();
                this.eEx.setHasMoreData(true);
            } else {
                this.eEL.wG();
                this.eEx.setHasMoreData(false);
            }
            this.eES = nVar.aOK();
            if (com.baidu.tbadk.core.util.x.t(this.eES)) {
                this.Cj.setNextPage(null);
                this.eEA.setVisibility(0);
            } else {
                this.Cj.setNextPage(this.eEL);
                this.eEA.setVisibility(8);
            }
            if (this.eES == null || this.eES.size() <= eEv) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.eES.size() - eEv;
                oQ(size);
                int firstVisiblePosition = this.Cj.getFirstVisiblePosition() - size;
                View childAt = this.Cj.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.eEx.setDatas(this.eES);
            boolean z2 = false;
            if (nVar.Jz() != null && nVar.Jz().getAuthor() != null && (userId = nVar.Jz().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.eEx.P(i, z2);
            this.eEx.notifyDataSetChanged();
            a(nVar.aOG(), nVar.axY(), nVar.nz(), i, z);
            if (i4 > 0) {
                this.Cj.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void oQ(int i) {
        if (this.eES != null) {
            if (this.eES.size() <= i) {
                this.eES.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.q> it = this.eES.iterator();
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

    public boolean aTl() {
        return this.eEx.bhu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.tbadkCore.data.q qVar, boolean z, boolean z2, int i, boolean z3) {
        if (qVar != null && !this.eEq) {
            this.esy = qVar;
            if (!StringUtils.isNull(qVar.bmr())) {
                this.eEI.setVisibility(0);
                this.eEI.c(qVar.bmr(), 10, true);
            } else {
                this.eEI.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.i bmt = qVar.bmt();
            if (bmt != null && bmt.fBZ) {
                this.eEJ.setVisibility(0);
            } else {
                this.eEJ.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.eEw.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.eEw.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(r.g.tag_clip_board, qVar);
            sparseArray.put(r.g.tag_is_subpb, false);
            a(qVar, i, sparseArray);
            this.eEG.setText((CharSequence) null);
            this.ahV.setText((CharSequence) null);
            this.eEF.setVisibility(8);
            if (!this.eEq) {
                a(qVar.getAuthor());
                if (z) {
                    this.eEF.setVisibility(0);
                    com.baidu.tbadk.core.util.at.j((View) this.eEF, r.d.cp_link_tip_a);
                }
            }
            this.etD.setText(com.baidu.tbadk.core.util.ax.s(qVar.getTime()));
            if (this.cNW) {
                int i2 = r.f.img_default_100;
            } else {
                int i3 = r.f.icon_click;
            }
            this.eEG.setText(String.format(this.eEy.getPageContext().getString(r.j.is_floor), Integer.valueOf(qVar.bml())));
            qVar.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.eEH, qVar.aCE());
            if (StringUtils.isNull(qVar.bmr()) && !a && qVar.Ij() != null) {
                this.bds.setVisibility(0);
                this.bds.setTag(qVar.Ij());
                return;
            }
            this.bds.setVisibility(8);
        }
    }

    private void a(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            int gD = com.baidu.tbadk.util.u.gD(name_show);
            com.baidu.tbadk.core.util.at.j((View) this.ahV, r.d.cp_cont_c);
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aR(metaData.getSealPrefix()) + 2 : 0) + gD > 14) {
                name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.ahV.setText(ag(metaData.getSealPrefix(), name_show));
            } else {
                this.ahV.setText(name_show);
            }
            this.eEV = 0;
            this.eEV = metaData.getLevel_id();
            if (this.eEV > 0) {
                this.eEE.setVisibility(0);
                com.baidu.tbadk.core.util.at.c(this.eEE, BitmapHelper.getSmallGradeResourceIdNew(this.eEV));
                this.eEE.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(this.eEV)));
                this.eEE.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.eEE.setOnClickListener(null);
            } else {
                this.eEE.setVisibility(8);
            }
            if (metaData.isGod()) {
                this.ezk.setVisibility(0);
                this.eED.setVisibility(8);
                this.ezk.setUserId(metaData.getUserId());
                this.ezk.setUserName(metaData.getUserName());
                this.ezk.c(metaData.getPortrait(), 28, false);
            } else {
                this.ezk.setVisibility(8);
                this.eED.setVisibility(0);
                this.eED.setUserId(metaData.getUserId());
                this.eED.setUserName(metaData.getUserName());
                this.eED.setDefaultResource(r.f.transparent_bg);
                this.eED.setDefaultErrorResource(r.f.icon_default_avatar100);
                this.eED.c(metaData.getPortrait(), 28, false);
            }
            this.eEC.setTag(r.g.tag_user_id, metaData.getUserId());
            this.eEC.setTag(r.g.tag_user_name, metaData.getUserName());
        }
    }

    private boolean a(TextView textView, com.baidu.tbadk.widget.richText.a aVar) {
        if (textView == null || aVar == null || aVar.Ic() == null) {
            return false;
        }
        com.baidu.tbadk.widget.richText.c cVar = new com.baidu.tbadk.widget.richText.c(1);
        Iterator<com.baidu.tbadk.widget.richText.c> it = aVar.Ic().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        cVar.append(next.Ii());
                        continue;
                    case 17:
                        String str = next.Im().ayE.ayf;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            cVar.append("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                    case 18:
                        cVar.cc(true);
                        textView.setMovementMethod(com.baidu.tieba.view.g.bti());
                        continue;
                }
            }
        }
        if (!cVar.Is()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (cVar.Ii() == null || cVar.Ii().length() <= 0) {
                return false;
            }
            textView.setText(cVar.Ii());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eEy.getPageContext().getString(r.j.refresh_view_title_text), this.MT));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.eEy.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.eEz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, r.f.pic_emotion07, com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds300), com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds480), com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds360)), dVar, a);
        }
        this.eEz.setVisibility(0);
        this.Cj.setVisibility(8);
        this.cub.setVisibility(8);
        this.dAe.DS();
        com.baidu.tbadk.core.util.at.l(this.mNoDataView, r.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.eEy.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gt(int i) {
        a(NoDataViewFactory.d.x(i, r.j.refresh_view_title_text));
        if (this.eEp != null) {
            this.eEp.aY(this.eqs);
        }
    }

    public void pJ(String str) {
        a(NoDataViewFactory.d.af(str, this.eEy.getPageContext().getString(r.j.refresh_view_title_text)));
        if (this.eEp != null) {
            this.eEp.aY(this.eqs);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Cj.setVisibility(0);
            this.eqs.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.MT = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.tieba.tbadkCore.data.q qVar, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        boolean z7;
        if (qVar != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                String userId2 = qVar.getAuthor().getUserId();
                boolean z8 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z = true;
                    z2 = false;
                } else {
                    z2 = z8;
                    z = true;
                }
            } else {
                z = false;
                z2 = false;
            }
            if (this.eDA != null && this.eDA.Jz() != null && this.eDA.Jz().getAuthor() != null && qVar.getAuthor() != null) {
                String userId3 = this.eDA.Jz().getAuthor().getUserId();
                String userId4 = qVar.getAuthor().getUserId();
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
                    userId = qVar.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = qVar.bml() != 1 ? 0 : 1;
                    if (ex.h(qVar)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(r.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                        sparseArray.put(r.g.tag_forbid_user_post_id, qVar.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(r.g.tag_forbid_user_name, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(r.g.tag_del_post_is_self, true);
                        sparseArray.put(r.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(r.g.tag_del_post_id, qVar.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(r.g.tag_del_post_is_self, false);
                        sparseArray.put(r.g.tag_del_post_type, 0);
                        sparseArray.put(r.g.tag_del_post_id, "");
                    }
                    sparseArray.put(r.g.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(r.g.tag_forbid_user_post_id, qVar.getId());
                    if (!z6) {
                        sparseArray.put(r.g.tag_should_manage_visible, true);
                        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(r.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(r.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(r.g.tag_user_mute_visible, true);
                        sparseArray.put(r.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (qVar.getAuthor() != null) {
                            sparseArray.put(r.g.tag_user_mute_mute_userid, qVar.getAuthor().getUserId());
                            sparseArray.put(r.g.tag_user_mute_mute_username, qVar.getAuthor().getUserName());
                        }
                        if (this.eDA.Jz() != null) {
                            sparseArray.put(r.g.tag_user_mute_thread_id, this.eDA.Jz().getId());
                        }
                        sparseArray.put(r.g.tag_user_mute_post_id, qVar.getId());
                    } else {
                        sparseArray.put(r.g.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(r.g.tag_should_delete_visible, true);
                        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(r.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(r.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(r.g.tag_del_post_id, qVar.getId());
                        return;
                    }
                    sparseArray.put(r.g.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = qVar.getAuthor().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (qVar.bml() != 1) {
            }
            if (ex.h(qVar)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(r.g.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(r.g.tag_forbid_user_post_id, qVar.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void jg(boolean z) {
        if (this.euU != null && this.euU.aQN() != null) {
            if (z) {
                this.euU.aQN().setText(r.j.remove_mark);
            } else {
                this.euU.aQN().setText(r.j.mark);
            }
            this.euU.wj();
        }
    }

    public View aTm() {
        return this.eEO;
    }

    public void onChangeSkinType(int i) {
        this.eEy.getLayoutMode().ai(i == 1);
        this.eEy.getLayoutMode().x(this.eqs);
        this.eEy.getLayoutMode().x(this.eEw);
        this.mNavigationBar.onChangeSkinType(this.eEy.getPageContext(), i);
        if (this.eEB != null) {
            com.baidu.tbadk.core.util.at.j((View) this.eEB, r.d.goto_see_subject_color);
        }
        com.baidu.tbadk.core.util.at.j((View) this.eEA, r.d.cp_cont_d);
        this.bPG.onChangeSkinType(this.eEy.getPageContext(), i);
        this.eEy.getLayoutMode().x(this.eEO);
        com.baidu.tbadk.core.util.at.j((View) this.eEH, r.d.cp_cont_b);
        this.eEH.setLinkTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_link_tip_c));
        if (this.dAe != null && this.dAe.CO() != null) {
            this.dAe.CO().onChangeSkinType(i);
        }
        this.eEL.di(i);
        this.bds.aEg();
        com.baidu.tbadk.core.util.at.j((View) this.eEU, r.d.cp_cont_d);
        com.baidu.tbadk.core.util.at.k(this.eEU, r.f.pb_ecomm_comment_bg);
        com.baidu.tbadk.core.util.at.j((View) this.eEF, r.d.cp_link_tip_a);
        com.baidu.tbadk.core.util.at.j((View) this.ahV, r.d.cp_cont_c);
        if (this.eEV > 0) {
            com.baidu.tbadk.core.util.at.c(this.eEE, BitmapHelper.getSmallGradeResourceIdNew(this.eEV));
        }
        this.eEU.setAlpha(0.95f);
        if (this.eEx != null) {
            this.eEx.notifyDataSetChanged();
        }
    }

    public void aTn() {
        this.cub.setVisibility(0);
    }

    public void aTo() {
        this.Cj.setVisibility(0);
        this.cub.setVisibility(8);
        this.eEL.wG();
    }

    public void abd() {
        this.Cj.setVisibility(0);
        this.cub.setVisibility(8);
        this.eEL.abd();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bLR = onLongClickListener;
        this.eEw.setOnLongClickListener(this.bLR);
    }

    public View aTp() {
        return this.eEw;
    }

    public TextView aTq() {
        return this.eEU;
    }

    public void pK(String str) {
        int pL = this.eEx.pL(str);
        if (pL > -1) {
            this.eEx.oR(pL);
            if (pL > 2) {
                this.Cj.setSelection(pL - 2);
            } else {
                this.Cj.setSelection(pL);
            }
            this.Cj.invalidate();
        }
    }

    public View aTr() {
        return this.eEB;
    }

    public View aTs() {
        return this.eEI;
    }

    public MorePopupWindow aTt() {
        return this.eEM;
    }

    public void aAF() {
        if (this.eBW == null) {
            this.eBW = new com.baidu.tbadk.core.view.a(this.eEy.getPageContext());
        }
        this.eBW.aI(true);
    }

    public void aMZ() {
        if (this.eBW != null) {
            this.eBW.aI(false);
        }
    }

    public TextView aTu() {
        return this.eEH;
    }

    public void setOnLinkImageClickListener(TbRichTextView.f fVar) {
        this.eEf = fVar;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.eEg = eVar;
    }

    public dq aTv() {
        return this.euU;
    }

    public void aeM() {
    }

    public void aeN() {
    }

    public void onActivityDestroy() {
    }

    public void aTw() {
        if (this.eEy.Sp()) {
        }
    }

    public View aTx() {
        return this.eEC;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new an.a(str, r.f.pic_smalldot_title));
            return com.baidu.tieba.card.an.a((Context) this.eEy.getActivity(), str2, (ArrayList<an.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
