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
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.dp;
import com.baidu.tieba.pb.pb.main.ev;
import com.baidu.tieba.pb.pb.main.ex;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ao {
    private static final int esY = TbadkCoreApplication.m9getInst().getListItemRule().yA();
    private BdListView Ik;
    private View bJq;
    private NoNetworkView bKq;
    private View.OnClickListener cpI;
    private RelativeLayout eeu;
    private dp eiX;
    private View enj;
    private com.baidu.tbadk.core.view.a eqv;
    private com.baidu.tieba.pb.data.j erT;
    private SubPbModel esE;
    private b esS;
    private View esZ;
    private ba eta;
    private NewSubPbActivity etb;
    private RelativeLayout etd;
    private TextView ete;
    private ThreadSkinView eto;
    private bb etp;
    private View ets;
    private ArrayList<PostData> etw;
    private String etx;
    private TextView ety;
    private ProgressBar mProgress;
    private int maxImageWidth;
    private com.baidu.tbadk.core.view.y mNoDataView = null;
    private TbRichTextView.e esJ = null;
    private View.OnClickListener Ry = null;
    private TbRichTextView.f esI = null;
    private NavigationBar mNavigationBar = null;
    private View aom = null;
    private TextView etf = null;
    private LinearLayout etg = null;
    private HeadImageView eth = null;
    private ClickableHeaderImageView enx = null;
    private TextView amq = null;
    private ImageView eti = null;
    private TextView etj = null;
    private TextView etk = null;
    private TextView ehD = null;
    private EllipsizeRichTextView etl = null;
    private TbImageView etm = null;
    private PlayVoiceBntNew btl = null;
    private TextView etn = null;
    private MorePopupWindow etq = null;
    private ev etr = null;
    private com.baidu.tbadk.core.dialog.c eqj = null;
    private Dialog epP = null;
    private com.baidu.tbadk.core.dialog.a epR = null;
    private boolean cAb = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener bGF = null;
    private NewSubPbActivity.a ett = null;
    private NewSubPbActivity.a etu = null;
    private ArrayList<IconData> ehj = null;
    private ArrayList<IconData> cVN = null;
    private com.baidu.tbadk.editortools.pb.n dlk = null;
    private String etv = null;
    private int aMD = 0;
    private PostData egv = null;
    private int etz = 0;
    private int etA = 2;
    private int etB = 0;
    private boolean esT = true;
    protected HashMap<Long, HashSet<String>> etC = new HashMap<>();
    protected final b.a etD = new ap(this);
    private View.OnClickListener ehk = new at(this);
    private com.baidu.tieba.pb.a.d ehl = new com.baidu.tieba.pb.a.d(new au(this));
    protected AdapterView.OnItemClickListener etE = new av(this);
    protected AdapterView.OnItemLongClickListener mOnItemLongClickListener = new aw(this);

    public ao(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.eeu = null;
        this.esZ = null;
        this.Ik = null;
        this.eta = null;
        this.etb = null;
        this.bKq = null;
        this.etd = null;
        this.ete = null;
        this.enj = null;
        this.etp = null;
        this.ets = null;
        this.cpI = null;
        this.mProgress = null;
        this.ety = null;
        this.etb = newSubPbActivity;
        this.cpI = onClickListener;
        this.eeu = (RelativeLayout) LayoutInflater.from(this.etb.getPageContext().getPageActivity()).inflate(w.j.new_sub_pb_layout, (ViewGroup) null);
        this.esZ = LayoutInflater.from(this.etb.getPageContext().getPageActivity()).inflate(w.j.new_sub_pb_head, (ViewGroup) null);
        this.ete = (TextView) this.eeu.findViewById(w.h.no_reply_list_view);
        this.ety = (TextView) this.eeu.findViewById(w.h.subpb_editor_tool_reply_text);
        this.ety.setOnClickListener(this.cpI);
        this.bKq = (NoNetworkView) this.eeu.findViewById(w.h.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.af(this.etb.getBaseContext()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds60);
        aOt();
        WS();
        this.etd = (RelativeLayout) this.eeu.findViewById(w.h.sub_pb_body_layout);
        this.Ik = (BdListView) this.eeu.findViewById(w.h.new_sub_pb_list);
        this.eto = (ThreadSkinView) LayoutInflater.from(this.etb.getPageContext().getPageActivity()).inflate(w.j.thread_skin_layout, (ViewGroup) null);
        this.Ik.addHeaderView(this.eto);
        this.Ik.addHeaderView(this.esZ);
        this.bJq = BdListViewHelper.a(this.etb.getActivity(), this.Ik, BdListViewHelper.HeadType.DEFAULT);
        this.eta = new ba(this.etb.getPageContext().getPageActivity());
        this.eta.I(this.ehk);
        this.eta.setIsFromCDN(this.mIsFromCDN);
        this.eta.iZ(true);
        this.Ik.setAdapter((ListAdapter) this.eta);
        this.etp = new bb(this.etb.getPageContext());
        this.ets = this.etp.getView();
        this.Ik.setNextPage(this.etp);
        this.etp.setOnClickListener(this.cpI);
        this.Ik.setOnItemClickListener(this.etE);
        this.Ik.setOnTouchListener(this.ehl);
        this.mProgress = (ProgressBar) this.eeu.findViewById(w.h.progress);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.esZ != null) {
            this.esZ.setVisibility(4);
        }
        if (this.etd != null) {
            this.etd.setVisibility(4);
        }
        this.enj = com.baidu.tbadk.ala.c.oa().h(this.etb.getActivity(), 4);
        if (this.enj != null) {
            this.enj.setVisibility(8);
            this.etg.addView(this.enj, 3);
        }
    }

    public ListView getListView() {
        return this.Ik;
    }

    public void WS() {
        this.etg = (LinearLayout) this.esZ.findViewById(w.h.subpb_head_user_info_root);
        this.etg.setOnClickListener(this.cpI);
        this.eth = (HeadImageView) this.esZ.findViewById(w.h.photo);
        this.eth.setRadius(com.baidu.adp.lib.util.k.g(this.etb.getActivity(), w.f.ds30));
        this.enx = (ClickableHeaderImageView) this.esZ.findViewById(w.h.god_user_photo);
        this.enx.setGodIconMargin(0);
        this.enx.setGodIconWidth(w.f.ds24);
        this.enx.setRadius(com.baidu.adp.lib.util.k.g(this.etb.getActivity(), w.f.ds30));
        this.amq = (TextView) this.esZ.findViewById(w.h.user_name);
        this.eti = (ImageView) this.esZ.findViewById(w.h.user_rank);
        this.etj = (TextView) this.esZ.findViewById(w.h.floor_owner);
        this.etf = (TextView) this.esZ.findViewById(w.h.see_subject);
        this.etf.setOnClickListener(this.cpI);
        this.etk = (TextView) this.esZ.findViewById(w.h.floor);
        this.ehD = (TextView) this.esZ.findViewById(w.h.time);
        this.etl = (EllipsizeRichTextView) this.esZ.findViewById(w.h.content_text);
        this.etl.setOnClickListener(this.cpI);
        com.baidu.tbadk.core.util.aq.i(this.etl, w.e.cp_cont_b);
        this.etl.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
        this.etl.setLineSpacing(0.0f, 1.25f);
        this.etm = (TbImageView) this.esZ.findViewById(w.h.sub_pb_image);
        this.etm.setOnClickListener(this.cpI);
        this.etn = (TextView) this.esZ.findViewById(w.h.advert);
        this.btl = (PlayVoiceBntNew) this.esZ.findViewById(w.h.voice_btn);
        this.esZ.setOnTouchListener(this.ehl);
        this.esZ.setOnClickListener(this.cpI);
    }

    public void iX(boolean z) {
        if (this.bJq != null && this.bJq.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bJq.getLayoutParams();
            if (z) {
                aOr();
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.etb.getPageContext().getPageActivity(), w.f.ds98);
            } else {
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.etb.getPageContext().getPageActivity(), w.f.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.bJq.setLayoutParams(layoutParams);
        }
    }

    private void aOr() {
        this.mNavigationBar.setmBackImageViewBg(w.g.subpb_navigationbar_close, w.g.subpb_navigationbar_close);
    }

    public View aOs() {
        return this.bJq;
    }

    public void aOt() {
        this.mNavigationBar = (NavigationBar) this.eeu.findViewById(w.h.view_navigation_bar);
        this.aom = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aom.getLayoutParams();
            int g = com.baidu.adp.lib.util.k.g(this.etb.getPageContext().getPageActivity(), w.f.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aom != null && (this.aom.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aom.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aom.setPadding(com.baidu.adp.lib.util.k.g(this.etb.getPageContext().getPageActivity(), w.f.ds32), this.aom.getPaddingTop(), this.aom.getPaddingRight(), this.aom.getPaddingBottom());
            this.aom.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(w.g.subpb_navigationbar_back, w.g.subpb_navigationbar_back);
    }

    public NavigationBar Kt() {
        return this.mNavigationBar;
    }

    public void ba(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.epP == null) {
            this.epP = new Dialog(this.etb.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.epP.setCanceledOnTouchOutside(true);
            this.epP.setCancelable(true);
            View inflate = LayoutInflater.from(this.etb.getPageContext().getPageActivity()).inflate(w.j.forum_manage_dialog, (ViewGroup) null);
            this.etb.getLayoutMode().t(inflate);
            this.epP.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.epP.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.af(this.etb.getPageContext().getPageActivity()) * 0.9d);
            this.epP.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.epP.findViewById(w.h.del_post_btn);
        TextView textView2 = (TextView) this.epP.findViewById(w.h.forbid_user_btn);
        TextView textView3 = (TextView) this.epP.findViewById(w.h.disable_reply_btn);
        if ("".equals(sparseArray.get(w.h.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(w.h.tag_del_post_id, sparseArray.get(w.h.tag_del_post_id));
            sparseArray2.put(w.h.tag_del_post_type, sparseArray.get(w.h.tag_del_post_type));
            sparseArray2.put(w.h.tag_del_post_is_self, sparseArray.get(w.h.tag_del_post_is_self));
            sparseArray2.put(w.h.tag_manage_user_identity, sparseArray.get(w.h.tag_manage_user_identity));
            textView.setOnClickListener(new ax(this));
        }
        if ("".equals(sparseArray.get(w.h.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(w.h.tag_forbid_user_name, sparseArray.get(w.h.tag_forbid_user_name));
            sparseArray3.put(w.h.tag_manage_user_identity, sparseArray.get(w.h.tag_manage_user_identity));
            sparseArray3.put(w.h.tag_forbid_user_post_id, sparseArray.get(w.h.tag_forbid_user_post_id));
            textView2.setOnClickListener(new ay(this));
        }
        if (!((sparseArray.get(w.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(w.h.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(w.l.un_mute);
            } else {
                textView3.setText(w.l.mute);
            }
            sparseArray4.put(w.h.tag_is_mem, sparseArray.get(w.h.tag_is_mem));
            sparseArray4.put(w.h.tag_user_mute_mute_userid, sparseArray.get(w.h.tag_user_mute_mute_userid));
            sparseArray4.put(w.h.tag_user_mute_mute_username, sparseArray.get(w.h.tag_user_mute_mute_username));
            sparseArray4.put(w.h.tag_user_mute_post_id, sparseArray.get(w.h.tag_user_mute_post_id));
            sparseArray4.put(w.h.tag_user_mute_thread_id, sparseArray.get(w.h.tag_user_mute_thread_id));
            textView3.setOnClickListener(new az(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.epP, this.etb.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(w.h.tag_del_post_id, str);
        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = w.l.del_post_confirm;
        if (i == 0) {
            i3 = w.l.del_thread_confirm;
        }
        this.epR = new com.baidu.tbadk.core.dialog.a(this.etb.getPageContext().getPageActivity());
        this.epR.bZ(i3);
        this.epR.A(sparseArray);
        this.epR.a(w.l.dialog_ok, new aq(this, sparseArray));
        this.epR.b(w.l.dialog_cancel, new ar(this));
        this.epR.av(true);
        this.epR.b(this.etb.getPageContext());
        this.epR.tQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iI(boolean z) {
        if (this.Ik != null) {
            if (!z) {
                this.Ik.setEnabled(z);
            } else {
                this.Ik.postDelayed(new as(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.eqj != null) {
            this.eqj.dismiss();
            this.eqj = null;
        }
        if (z) {
            string = this.etb.getResources().getString(w.l.remove_mark);
        } else {
            string = this.etb.getResources().getString(w.l.mark);
        }
        this.eqj = new com.baidu.tbadk.core.dialog.c(this.etb.getPageContext().getPageActivity());
        this.eqj.cc(w.l.operation);
        this.eqj.a(new String[]{this.etb.getResources().getString(w.l.copy), string}, bVar);
        this.eqj.d(this.etb.getPageContext());
        this.eqj.tT();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.ett = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.etu = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.etb.showToast(this.etb.getResources().getString(w.l.delete_success));
        } else if (str != null && z2) {
            this.etb.showToast(str);
        }
    }

    public void aZ(View view) {
        if (this.bJq != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bJq.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Ik != null) {
                    this.Ik.removeHeaderView(this.bJq);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.bJq.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.etb.getActivity(), w.f.ds98)));
            } else if (this.Ik != null) {
                this.Ik.addHeaderView(this.bJq, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.n nVar) {
        if (nVar != null && nVar.Dn() != null) {
            this.dlk = nVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eeu.addView(nVar.Dn(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.esS = bVar;
    }

    public void aOu() {
        if (this.Ik != null) {
            this.etB = this.Ik.getLastVisiblePosition();
        }
    }

    public void aOv() {
        if (this.esE != null) {
            if ((!aOy() && this.ets != null && this.ets.isShown()) || com.baidu.tbadk.core.util.x.q(this.etw)) {
                this.esE.jb(false);
            } else {
                this.esE.jb(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.esE = subPbModel;
    }

    public void aOw() {
        a(this.etb);
        this.Ik.setNextPage(this.etp);
    }

    public void k(PostData postData) {
        int i;
        if (postData != null) {
            postData.lj(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aOy() && this.ets != null && this.ets.isShown()) {
                i = (this.etB - this.etA) - 1;
            } else {
                i = this.etB - this.etA;
            }
            int p = com.baidu.tbadk.core.util.x.p(this.etw);
            if (i > p) {
                i = p;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(com.baidu.tbadk.core.util.x.a(this.etw, 0, i));
            com.baidu.tbadk.core.util.x.b(arrayList, postData2);
            com.baidu.tbadk.core.util.x.b(arrayList, postData);
            this.eta.setDatas(arrayList);
            this.eta.notifyDataSetChanged();
            this.Ik.smoothScrollToPosition(this.etB + 2);
            this.Ik.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Ik.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.Ik.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.eeu;
    }

    public void awH() {
        if (this.etq != null) {
            com.baidu.adp.lib.g.j.a(this.etq, this.etb.getPageContext().getPageActivity());
        }
        if (this.eqj != null) {
            this.eqj.dismiss();
        }
        if (this.epR != null) {
            this.epR.dismiss();
        }
        if (this.epP != null) {
            com.baidu.adp.lib.g.j.b(this.epP, this.etb.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.eiX != null) {
            this.eiX.dismiss();
        }
    }

    public void aOx() {
        this.Ik.setNextPage(this.etp);
        this.etp.xd();
    }

    public void ia(boolean z) {
        this.cAb = z;
    }

    public void setIsFromPb(boolean z) {
        this.esT = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.pb.data.j jVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (jVar != null) {
            if (this.esT && this.esZ != null) {
                this.eta.ja(true);
                this.esZ.setVisibility(8);
                this.Ik.removeHeaderView(this.esZ);
                this.etA = 1;
            }
            this.erT = jVar;
            this.eta.h(this.erT.Kn());
            if (this.esZ != null) {
                this.esZ.setVisibility(0);
            }
            if (this.etd != null) {
                this.etd.setVisibility(0);
            }
            if (jVar.aJV() != null) {
                this.etv = jVar.aJV().getId();
                this.aMD = jVar.aJV().bio();
                if (this.aMD > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.etb.getPageContext().getString(w.l.which_floor_reply), Integer.valueOf(this.aMD)));
                    this.ety.setText(String.format(this.etb.getPageContext().getString(w.l.reply_some_floor), Integer.valueOf(this.aMD)));
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.etb.aOq()) {
                    str = "PB";
                }
                if (jVar.aJV().sJ() != null) {
                    this.eto.a(this.etb.getPageContext(), jVar.aJV().sJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", jVar.aKb().getId(), jVar.aKb().getName(), jVar.Kn().getId(), str));
                } else {
                    this.eto.a(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.etp.xd();
                this.eta.setHasMoreData(true);
            } else {
                this.etp.xe();
                this.eta.setHasMoreData(false);
            }
            this.etw = jVar.aJZ();
            if (com.baidu.tbadk.core.util.x.q(this.etw)) {
                this.Ik.setNextPage(null);
                if (this.esT) {
                    this.ete.setVisibility(0);
                }
            } else {
                this.Ik.setNextPage(this.etp);
                if (this.esT) {
                    this.ete.setVisibility(8);
                }
            }
            if (this.etw == null || this.etw.size() <= esY) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.etw.size() - esY;
                ox(size);
                int firstVisiblePosition = this.Ik.getFirstVisiblePosition() - size;
                View childAt = this.Ik.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.eta.setDatas(this.etw);
            boolean z2 = false;
            if (jVar.Kn() != null && jVar.Kn().getAuthor() != null && (userId = jVar.Kn().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.eta.B(i, z2);
            this.eta.notifyDataSetChanged();
            a(jVar.aJV(), jVar.asR(), jVar.oe(), i, z);
            if (i4 > 0) {
                this.Ik.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void ox(int i) {
        if (this.etw != null) {
            if (this.etw.size() <= i) {
                this.etw.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.etw.iterator();
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

    public boolean aOy() {
        return this.eta.bAP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.esT) {
            this.egv = postData;
            if (!StringUtils.isNull(postData.biu())) {
                this.etm.setVisibility(0);
                this.etm.c(postData.biu(), 10, true);
            } else {
                this.etm.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.h biw = postData.biw();
            if (biw != null && biw.fvx) {
                this.etn.setVisibility(0);
            } else {
                this.etn.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.esZ.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.esZ.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.etk.setText((CharSequence) null);
            this.amq.setText((CharSequence) null);
            this.etj.setVisibility(8);
            if (!this.esT) {
                a(postData.getAuthor());
                if (z) {
                    this.etj.setVisibility(0);
                    com.baidu.tbadk.core.util.aq.i(this.etj, w.e.cp_link_tip_a);
                }
            }
            this.ehD.setText(com.baidu.tbadk.core.util.au.q(postData.getTime()));
            if (this.cAb) {
                int i2 = w.g.img_default_100;
            } else {
                int i3 = w.g.icon_click;
            }
            this.etk.setText(String.format(this.etb.getPageContext().getString(w.l.is_floor), Integer.valueOf(postData.bio())));
            postData.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.etl, postData.awl());
            if (StringUtils.isNull(postData.biu()) && !a && postData.Iw() != null) {
                this.btl.setVisibility(0);
                this.btl.setTag(postData.Iw());
                return;
            }
            this.btl.setVisibility(8);
        }
    }

    private void a(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            int gq = com.baidu.tbadk.util.u.gq(name_show);
            com.baidu.tbadk.core.util.aq.i(this.amq, w.e.cp_cont_c);
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aF(metaData.getSealPrefix()) + 2 : 0) + gq > 14) {
                name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.amq.setText(af(metaData.getSealPrefix(), name_show));
            } else {
                this.amq.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.enj != null) {
                if (metaData.getAlaUserData().anchor_live == 0 && metaData.getAlaUserData().enter_live == 0) {
                    this.enj.setVisibility(8);
                } else {
                    this.enj.setVisibility(0);
                    com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                    bVar.QP = metaData.getAlaUserData();
                    bVar.type = 4;
                    this.enj.setTag(bVar);
                }
            }
            this.etz = 0;
            this.etz = metaData.getLevel_id();
            if (this.etz > 0) {
                this.eti.setVisibility(0);
                com.baidu.tbadk.core.util.aq.c(this.eti, BitmapHelper.getSmallGradeResourceIdNew(this.etz));
                this.eti.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(this.etz)));
                this.eti.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.eti.setOnClickListener(null);
            } else {
                this.eti.setVisibility(8);
            }
            if (metaData.isGod()) {
                this.enx.setVisibility(0);
                this.eth.setVisibility(8);
                this.enx.setUserId(metaData.getUserId());
                this.enx.setUserName(metaData.getUserName());
                this.enx.c(metaData.getPortrait(), 28, false);
            } else {
                this.enx.setVisibility(8);
                this.eth.setVisibility(0);
                this.eth.setUserId(metaData.getUserId());
                this.eth.setUserName(metaData.getUserName());
                this.eth.setDefaultResource(w.g.transparent_bg);
                this.eth.setDefaultErrorResource(w.g.icon_default_avatar100);
                this.eth.c(metaData.getPortrait(), 28, false);
            }
            this.etg.setTag(w.h.tag_user_id, metaData.getUserId());
            this.etg.setTag(w.h.tag_user_name, metaData.getUserName());
            this.etg.setTag(w.h.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Io() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Io().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.Iv());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cc(true);
                        textView.setMovementMethod(com.baidu.tieba.view.g.bmm());
                        continue;
                    case 17:
                        String str = next.Iz().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.append("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.IE()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.Iv() == null || tbRichTextData.Iv().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.Iv());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.etb.getPageContext().getString(w.l.refresh_view_title_text), this.Ry));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.etb.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.etd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, w.g.pic_emotion07, com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds300), com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds480), com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds360)), dVar, a);
        }
        this.etd.setVisibility(0);
        this.Ik.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.dlk.Em();
        com.baidu.tbadk.core.util.aq.k(this.mNoDataView, w.e.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.etb.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void fV(int i) {
        a(NoDataViewFactory.d.E(i, w.l.refresh_view_title_text));
        if (this.esS != null) {
            this.esS.bb(this.eeu);
        }
        this.ety.setVisibility(8);
    }

    public void nM(String str) {
        a(NoDataViewFactory.d.ae(str, this.etb.getPageContext().getString(w.l.refresh_view_title_text)));
        if (this.esS != null) {
            this.esS.bb(this.eeu);
        }
        this.ety.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Ik.setVisibility(0);
            this.ety.setVisibility(0);
            this.eeu.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.Ry = onClickListener;
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
    public void a(PostData postData, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        boolean z7;
        if (postData != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                String userId2 = postData.getAuthor().getUserId();
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
            if (this.erT != null && this.erT.Kn() != null && this.erT.Kn().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.erT.Kn().getAuthor().getUserId();
                String userId4 = postData.getAuthor().getUserId();
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
                    userId = postData.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bio() != 1 ? 0 : 1;
                    if (ex.g(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                        sparseArray.put(w.h.tag_forbid_user_post_id, postData.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(w.h.tag_forbid_user_name, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(w.h.tag_del_post_is_self, true);
                        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(w.h.tag_del_post_id, postData.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(w.h.tag_del_post_is_self, false);
                        sparseArray.put(w.h.tag_del_post_type, 0);
                        sparseArray.put(w.h.tag_del_post_id, "");
                    }
                    sparseArray.put(w.h.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(w.h.tag_forbid_user_post_id, postData.getId());
                    if (!z6) {
                        sparseArray.put(w.h.tag_should_manage_visible, true);
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                    } else {
                        sparseArray.put(w.h.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(w.h.tag_user_mute_visible, true);
                        sparseArray.put(w.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.getAuthor() != null) {
                            sparseArray.put(w.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                            sparseArray.put(w.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                        }
                        if (this.erT.Kn() != null) {
                            sparseArray.put(w.h.tag_user_mute_thread_id, this.erT.Kn().getId());
                        }
                        sparseArray.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(w.h.tag_should_delete_visible, true);
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(w.h.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(w.h.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = postData.getAuthor().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bio() != 1) {
            }
            if (ex.g(postData)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(w.h.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(w.h.tag_forbid_user_post_id, postData.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void iY(boolean z) {
        if (this.eiX != null && this.eiX.aMf() != null) {
            if (z) {
                this.eiX.aMf().setText(w.l.remove_mark);
            } else {
                this.eiX.aMf().setText(w.l.mark);
            }
            this.eiX.refreshUI();
        }
    }

    public View aOz() {
        return this.ets;
    }

    public void onChangeSkinType(int i) {
        this.etb.getLayoutMode().aj(i == 1);
        this.etb.getLayoutMode().t(this.eeu);
        this.etb.getLayoutMode().t(this.esZ);
        this.mNavigationBar.onChangeSkinType(this.etb.getPageContext(), i);
        if (this.etf != null) {
            com.baidu.tbadk.core.util.aq.i(this.etf, w.e.goto_see_subject_color);
        }
        com.baidu.tbadk.core.util.aq.i(this.ete, w.e.cp_cont_d);
        this.bKq.onChangeSkinType(this.etb.getPageContext(), i);
        this.etb.getLayoutMode().t(this.ets);
        com.baidu.tbadk.core.util.aq.i(this.etl, w.e.cp_cont_b);
        this.etl.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
        if (this.dlk != null && this.dlk.Dn() != null) {
            this.dlk.Dn().onChangeSkinType(i);
        }
        this.etp.dk(i);
        this.btl.bac();
        com.baidu.tbadk.core.util.aq.i(this.ety, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.j(this.ety, w.g.pb_ecomm_comment_bg);
        com.baidu.tbadk.core.util.aq.i(this.etj, w.e.cp_link_tip_a);
        com.baidu.tbadk.core.util.aq.i(this.amq, w.e.cp_cont_c);
        if (this.etz > 0) {
            com.baidu.tbadk.core.util.aq.c(this.eti, BitmapHelper.getSmallGradeResourceIdNew(this.etz));
        }
        this.ety.setAlpha(0.95f);
        if (this.eta != null) {
            this.eta.notifyDataSetChanged();
        }
    }

    public void aOA() {
        this.mProgress.setVisibility(0);
    }

    public void aOB() {
        this.Ik.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.etp.xe();
    }

    public void Yg() {
        this.Ik.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.etp.Yg();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bGF = onLongClickListener;
        this.esZ.setOnLongClickListener(this.bGF);
    }

    public View aOC() {
        return this.esZ;
    }

    public TextView aOD() {
        return this.ety;
    }

    public void nN(String str) {
        int nO = this.eta.nO(str);
        if (nO > -1) {
            this.eta.oy(nO);
            if (nO > 2) {
                this.Ik.setSelection(nO - 2);
            } else {
                this.Ik.setSelection(nO);
            }
            this.Ik.invalidate();
        }
    }

    public View aOE() {
        return this.etf;
    }

    public View aOF() {
        return this.etm;
    }

    public MorePopupWindow aOG() {
        return this.etq;
    }

    public void auv() {
        if (this.eqv == null) {
            this.eqv = new com.baidu.tbadk.core.view.a(this.etb.getPageContext());
        }
        this.eqv.aK(true);
    }

    public void aIs() {
        if (this.eqv != null) {
            this.eqv.aK(false);
        }
    }

    public TextView aOH() {
        return this.etl;
    }

    public void setOnLinkImageClickListener(TbRichTextView.f fVar) {
        this.esI = fVar;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.esJ = eVar;
    }

    public dp aOI() {
        return this.eiX;
    }

    public void abD() {
    }

    public void abE() {
    }

    public void onActivityDestroy() {
    }

    public void aOJ() {
        if (this.etb.aOp()) {
        }
    }

    public View aOK() {
        return this.etg;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str, w.g.pic_smalldot_title));
            return com.baidu.tieba.card.at.a((Context) this.etb.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
