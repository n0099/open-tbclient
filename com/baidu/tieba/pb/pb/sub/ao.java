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
import com.baidu.tieba.card.ap;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.dj;
import com.baidu.tieba.pb.pb.main.ep;
import com.baidu.tieba.pb.pb.main.eq;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ao {
    private static final int eiv = TbadkCoreApplication.m9getInst().getListItemRule().xK();
    private BdListView Ck;
    private ProgressBar ban;
    private View buJ;
    private NoNetworkView bvK;
    private View.OnClickListener cjr;
    private RelativeLayout dUZ;
    private dj dZp;
    private com.baidu.tbadk.core.view.a egc;
    private com.baidu.tieba.pb.data.j ehB;
    private TextView eiA;
    private ThreadSkinView eiK;
    private bb eiL;
    private View eiO;
    private ArrayList<com.baidu.tieba.tbadkCore.data.q> eiS;
    private String eiT;
    private TextView eiU;
    private bc eib;
    private b eip;
    private View eiw;
    private ba eix;
    private NewSubPbActivity eiy;
    private RelativeLayout eiz;
    private int maxImageWidth;
    private com.baidu.tbadk.core.view.w mNoDataView = null;
    private TbRichTextView.e eig = null;
    private View.OnClickListener MQ = null;
    private TbRichTextView.f eif = null;
    private NavigationBar mNavigationBar = null;
    private View ajr = null;
    private TextView eiB = null;
    private LinearLayout eiC = null;
    private HeadImageView eiD = null;
    private ClickableHeaderImageView edv = null;
    private TextView ahw = null;
    private ImageView eiE = null;
    private TextView eiF = null;
    private TextView eiG = null;
    private TextView dXY = null;
    private EllipsizeRichTextView eiH = null;
    private TbImageView eiI = null;
    private PlayVoiceBntNew bcK = null;
    private TextView eiJ = null;
    private MorePopupWindow eiM = null;
    private ep eiN = null;
    private com.baidu.tbadk.core.dialog.c efQ = null;
    private Dialog efx = null;
    private com.baidu.tbadk.core.dialog.a efz = null;
    private boolean ctc = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener brV = null;
    private NewSubPbActivity.a eiP = null;
    private NewSubPbActivity.a eiQ = null;
    private ArrayList<IconData> dXF = null;
    private ArrayList<IconData> cNP = null;
    private com.baidu.tbadk.editortools.e.p ddg = null;
    private String eiR = null;
    private int aId = 0;
    private com.baidu.tieba.tbadkCore.data.q dWW = null;
    private int eiV = 0;
    private int eiW = 2;
    private int eiX = 0;
    private boolean eiq = true;
    protected HashMap<Long, HashSet<String>> eiY = new HashMap<>();
    protected final b.a eiZ = new ap(this);
    private View.OnClickListener dXG = new at(this);
    private com.baidu.tieba.pb.a.d dXp = new com.baidu.tieba.pb.a.d(new au(this));
    protected AdapterView.OnItemClickListener eja = new av(this);
    protected AdapterView.OnItemLongClickListener BI = new aw(this);

    public ao(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.dUZ = null;
        this.eiw = null;
        this.Ck = null;
        this.eix = null;
        this.eiy = null;
        this.bvK = null;
        this.eiz = null;
        this.eiA = null;
        this.eiL = null;
        this.eiO = null;
        this.cjr = null;
        this.ban = null;
        this.eiU = null;
        this.eiy = newSubPbActivity;
        this.cjr = onClickListener;
        this.dUZ = (RelativeLayout) LayoutInflater.from(this.eiy.getPageContext().getPageActivity()).inflate(r.h.new_sub_pb_layout, (ViewGroup) null);
        this.eiw = LayoutInflater.from(this.eiy.getPageContext().getPageActivity()).inflate(r.h.new_sub_pb_head, (ViewGroup) null);
        this.eiA = (TextView) this.dUZ.findViewById(r.g.no_reply_list_view);
        this.eiU = (TextView) this.dUZ.findViewById(r.g.subpb_editor_tool_reply_text);
        this.eiU.setOnClickListener(this.cjr);
        this.bvK = (NoNetworkView) this.dUZ.findViewById(r.g.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.I(this.eiy.getBaseContext()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds60);
        aMX();
        Ub();
        this.eiz = (RelativeLayout) this.dUZ.findViewById(r.g.sub_pb_body_layout);
        this.Ck = (BdListView) this.dUZ.findViewById(r.g.new_sub_pb_list);
        this.eiK = (ThreadSkinView) LayoutInflater.from(this.eiy.getPageContext().getPageActivity()).inflate(r.h.thread_skin_layout, (ViewGroup) null);
        this.Ck.addHeaderView(this.eiK);
        this.Ck.addHeaderView(this.eiw);
        this.buJ = BdListViewHelper.a(this.eiy.getActivity(), this.Ck, BdListViewHelper.HeadType.DEFAULT);
        this.eix = new ba(this.eiy.getPageContext().getPageActivity());
        this.eix.G(this.dXG);
        this.eix.setIsFromCDN(this.mIsFromCDN);
        this.eix.iS(true);
        this.Ck.setAdapter((ListAdapter) this.eix);
        this.eiL = new bb(this.eiy.getPageContext());
        this.eiO = this.eiL.getView();
        this.Ck.setNextPage(this.eiL);
        this.eiL.setOnClickListener(this.cjr);
        this.Ck.setOnItemClickListener(this.eja);
        this.Ck.setOnTouchListener(this.dXp);
        this.ban = (ProgressBar) this.dUZ.findViewById(r.g.progress);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.eiw != null) {
            this.eiw.setVisibility(4);
        }
        if (this.eiz != null) {
            this.eiz.setVisibility(4);
        }
    }

    public ListView getListView() {
        return this.Ck;
    }

    public void Ub() {
        this.eiC = (LinearLayout) this.eiw.findViewById(r.g.subpb_head_user_info_root);
        this.eiC.setOnClickListener(this.cjr);
        this.eiD = (HeadImageView) this.eiw.findViewById(r.g.photo);
        this.eiD.setRadius(com.baidu.adp.lib.util.k.e(this.eiy.getActivity(), r.e.ds30));
        this.edv = (ClickableHeaderImageView) this.eiw.findViewById(r.g.god_user_photo);
        this.edv.setGodIconMargin(0);
        this.edv.setGodIconWidth(r.e.ds24);
        this.edv.setRadius(com.baidu.adp.lib.util.k.e(this.eiy.getActivity(), r.e.ds30));
        this.ahw = (TextView) this.eiw.findViewById(r.g.user_name);
        this.eiE = (ImageView) this.eiw.findViewById(r.g.user_rank);
        this.eiF = (TextView) this.eiw.findViewById(r.g.floor_owner);
        this.eiB = (TextView) this.eiw.findViewById(r.g.see_subject);
        this.eiB.setOnClickListener(this.cjr);
        this.eiG = (TextView) this.eiw.findViewById(r.g.floor);
        this.dXY = (TextView) this.eiw.findViewById(r.g.time);
        this.eiH = (EllipsizeRichTextView) this.eiw.findViewById(r.g.content_text);
        this.eiH.setOnClickListener(this.cjr);
        com.baidu.tbadk.core.util.ar.j((View) this.eiH, r.d.cp_cont_b);
        this.eiH.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_link_tip_c));
        this.eiH.setLineSpacing(0.0f, 1.25f);
        this.eiI = (TbImageView) this.eiw.findViewById(r.g.sub_pb_image);
        this.eiI.setOnClickListener(this.cjr);
        this.eiJ = (TextView) this.eiw.findViewById(r.g.advert);
        this.bcK = (PlayVoiceBntNew) this.eiw.findViewById(r.g.voice_btn);
        this.eiw.setOnTouchListener(this.dXp);
        this.eiw.setOnClickListener(this.cjr);
    }

    public void iQ(boolean z) {
        if (this.buJ != null && this.buJ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.buJ.getLayoutParams();
            if (z) {
                aMV();
                layoutParams.height = com.baidu.adp.lib.util.k.e(this.eiy.getPageContext().getPageActivity(), r.e.ds98);
            } else {
                layoutParams.height = com.baidu.adp.lib.util.k.e(this.eiy.getPageContext().getPageActivity(), r.e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.buJ.setLayoutParams(layoutParams);
        }
    }

    private void aMV() {
        this.mNavigationBar.setmBackImageViewBg(r.f.subpb_navigationbar_close, r.f.subpb_navigationbar_close);
    }

    public View aMW() {
        return this.buJ;
    }

    public void aMX() {
        this.mNavigationBar = (NavigationBar) this.dUZ.findViewById(r.g.view_navigation_bar);
        this.ajr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajr.getLayoutParams();
            int e = com.baidu.adp.lib.util.k.e(this.eiy.getPageContext().getPageActivity(), r.e.ds30);
            layoutParams.height = e;
            layoutParams.width = e;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.ajr != null && (this.ajr.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ajr.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.ajr.setPadding(com.baidu.adp.lib.util.k.e(this.eiy.getPageContext().getPageActivity(), r.e.ds32), this.ajr.getPaddingTop(), this.ajr.getPaddingRight(), this.ajr.getPaddingBottom());
            this.ajr.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(r.f.subpb_navigationbar_back, r.f.subpb_navigationbar_back);
    }

    public NavigationBar Ja() {
        return this.mNavigationBar;
    }

    public void aW(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.efx == null) {
            this.efx = new Dialog(this.eiy.getPageContext().getPageActivity(), r.k.common_alert_dialog);
            this.efx.setCanceledOnTouchOutside(true);
            this.efx.setCancelable(true);
            View inflate = LayoutInflater.from(this.eiy.getPageContext().getPageActivity()).inflate(r.h.forum_manage_dialog, (ViewGroup) null);
            this.eiy.getLayoutMode().x(inflate);
            this.efx.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.efx.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.I(this.eiy.getPageContext().getPageActivity()) * 0.9d);
            this.efx.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.efx.findViewById(r.g.del_post_btn);
        TextView textView2 = (TextView) this.efx.findViewById(r.g.forbid_user_btn);
        TextView textView3 = (TextView) this.efx.findViewById(r.g.disable_reply_btn);
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
        com.baidu.adp.lib.h.j.a(this.efx, this.eiy.getPageContext());
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
        this.efz = new com.baidu.tbadk.core.dialog.a(this.eiy.getPageContext().getPageActivity());
        this.efz.cb(i3);
        this.efz.A(sparseArray);
        this.efz.a(r.j.dialog_ok, new aq(this, sparseArray));
        this.efz.b(r.j.dialog_cancel, new ar(this));
        this.efz.au(true);
        this.efz.b(this.eiy.getPageContext());
        this.efz.tb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iE(boolean z) {
        if (this.Ck != null) {
            if (!z) {
                this.Ck.setEnabled(z);
            } else {
                this.Ck.postDelayed(new as(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.efQ != null) {
            this.efQ.dismiss();
            this.efQ = null;
        }
        if (z) {
            string = this.eiy.getResources().getString(r.j.remove_mark);
        } else {
            string = this.eiy.getResources().getString(r.j.mark);
        }
        this.efQ = new com.baidu.tbadk.core.dialog.c(this.eiy.getPageContext().getPageActivity());
        this.efQ.ce(r.j.operation);
        this.efQ.a(new String[]{this.eiy.getResources().getString(r.j.copy), string}, bVar);
        this.efQ.d(this.eiy.getPageContext());
        this.efQ.te();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.eiP = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.eiQ = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.ban != null) {
            this.ban.setVisibility(8);
        }
        if (z && z2) {
            this.eiy.showToast(this.eiy.getResources().getString(r.j.delete_success));
        } else if (str != null && z2) {
            this.eiy.showToast(str);
        }
    }

    public void aV(View view) {
        if (this.buJ != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.buJ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Ck != null) {
                    this.Ck.removeHeaderView(this.buJ);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.buJ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.eiy.getActivity(), r.e.ds98)));
            } else if (this.Ck != null) {
                this.Ck.f(this.buJ, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.e.p pVar) {
        if (pVar != null && pVar.CB() != null) {
            this.ddg = pVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dUZ.addView(pVar.CB(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.eip = bVar;
    }

    public void aMY() {
        if (this.Ck != null) {
            this.eiX = this.Ck.getLastVisiblePosition();
        }
    }

    public void aMZ() {
        if (this.eib != null) {
            if ((!aNc() && this.eiO != null && this.eiO.isShown()) || com.baidu.tbadk.core.util.x.t(this.eiS)) {
                this.eib.iU(false);
            } else {
                this.eib.iU(true);
            }
        }
    }

    public void a(bc bcVar) {
        this.eib = bcVar;
    }

    public void aNa() {
        d(this.eiy);
        this.Ck.setNextPage(this.eiL);
    }

    public void k(com.baidu.tieba.tbadkCore.data.q qVar) {
        int i;
        if (qVar != null) {
            qVar.kW(true);
            com.baidu.tieba.tbadkCore.data.q qVar2 = new com.baidu.tieba.tbadkCore.data.q();
            qVar2.setPostType(49);
            if (!aNc() && this.eiO != null && this.eiO.isShown()) {
                i = (this.eiX - this.eiW) - 1;
            } else {
                i = this.eiX - this.eiW;
            }
            int s = com.baidu.tbadk.core.util.x.s(this.eiS);
            if (i > s) {
                i = s;
            }
            ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList = new ArrayList<>(com.baidu.tbadk.core.util.x.a(this.eiS, 0, i));
            com.baidu.tbadk.core.util.x.b(arrayList, qVar2);
            com.baidu.tbadk.core.util.x.b(arrayList, qVar);
            this.eix.setDatas(arrayList);
            this.eix.notifyDataSetChanged();
            this.Ck.smoothScrollToPosition(this.eiX + 2);
            this.Ck.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Ck.setOnScrollListener(onScrollListener);
    }

    public void d(BdListView.e eVar) {
        this.Ck.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.dUZ;
    }

    public void awl() {
        if (this.eiM != null) {
            com.baidu.adp.lib.h.j.a(this.eiM, this.eiy.getPageContext().getPageActivity());
        }
        if (this.efQ != null) {
            this.efQ.dismiss();
        }
        if (this.efz != null) {
            this.efz.dismiss();
        }
        if (this.efx != null) {
            com.baidu.adp.lib.h.j.b(this.efx, this.eiy.getPageContext());
        }
        if (this.ban != null) {
            this.ban.setVisibility(8);
        }
        if (this.dZp != null) {
            this.dZp.dismiss();
        }
    }

    public void aNb() {
        this.Ck.setNextPage(this.eiL);
        this.eiL.wp();
    }

    public void hX(boolean z) {
        this.ctc = z;
    }

    public void setIsFromPb(boolean z) {
        this.eiq = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.pb.data.j jVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (jVar != null) {
            if (this.eiq && this.eiw != null) {
                this.eix.iT(true);
                this.eiw.setVisibility(8);
                this.Ck.removeHeaderView(this.eiw);
                this.eiW = 1;
            }
            this.ehB = jVar;
            this.eix.h(this.ehB.IU());
            if (this.eiw != null) {
                this.eiw.setVisibility(0);
            }
            if (this.eiz != null) {
                this.eiz.setVisibility(0);
            }
            if (jVar.aIF() != null) {
                this.eiR = jVar.aIF().getId();
                this.aId = jVar.aIF().bga();
                if (this.aId > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.eiy.getPageContext().getString(r.j.which_floor_reply), Integer.valueOf(this.aId)));
                    this.eiU.setText(String.format(this.eiy.getPageContext().getString(r.j.reply_some_floor), Integer.valueOf(this.aId)));
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.eiy.aMU()) {
                    str = "PB";
                }
                if (jVar.aIF().rZ() != null) {
                    this.eiK.a(this.eiy.getPageContext(), jVar.aIF().rZ(), com.baidu.tieba.tbadkCore.d.a.b("PB", "c0132", jVar.aIL().getId(), jVar.aIL().getName(), jVar.IU().getId(), str));
                } else {
                    this.eiK.a(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.eiL.wp();
                this.eix.setHasMoreData(true);
            } else {
                this.eiL.wq();
                this.eix.setHasMoreData(false);
            }
            this.eiS = jVar.aIJ();
            if (com.baidu.tbadk.core.util.x.t(this.eiS)) {
                this.Ck.setNextPage(null);
                if (this.eiq) {
                    this.eiA.setVisibility(0);
                }
            } else {
                this.Ck.setNextPage(this.eiL);
                if (this.eiq) {
                    this.eiA.setVisibility(8);
                }
            }
            if (this.eiS == null || this.eiS.size() <= eiv) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.eiS.size() - eiv;
                nS(size);
                int firstVisiblePosition = this.Ck.getFirstVisiblePosition() - size;
                View childAt = this.Ck.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.eix.setDatas(this.eiS);
            boolean z2 = false;
            if (jVar.IU() != null && jVar.IU().getAuthor() != null && (userId = jVar.IU().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.eix.B(i, z2);
            this.eix.notifyDataSetChanged();
            a(jVar.aIF(), jVar.asx(), jVar.nz(), i, z);
            if (i4 > 0) {
                this.Ck.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void nS(int i) {
        if (this.eiS != null) {
            if (this.eiS.size() <= i) {
                this.eiS.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.q> it = this.eiS.iterator();
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

    public boolean aNc() {
        return this.eix.bgN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.tbadkCore.data.q qVar, boolean z, boolean z2, int i, boolean z3) {
        if (qVar != null && !this.eiq) {
            this.dWW = qVar;
            if (!StringUtils.isNull(qVar.bgg())) {
                this.eiI.setVisibility(0);
                this.eiI.c(qVar.bgg(), 10, true);
            } else {
                this.eiI.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.i bgi = qVar.bgi();
            if (bgi != null && bgi.fge) {
                this.eiJ.setVisibility(0);
            } else {
                this.eiJ.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.eiw.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.eiw.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(r.g.tag_clip_board, qVar);
            sparseArray.put(r.g.tag_is_subpb, false);
            a(qVar, i, sparseArray);
            this.eiG.setText((CharSequence) null);
            this.ahw.setText((CharSequence) null);
            this.eiF.setVisibility(8);
            if (!this.eiq) {
                a(qVar.getAuthor());
                if (z) {
                    this.eiF.setVisibility(0);
                    com.baidu.tbadk.core.util.ar.j((View) this.eiF, r.d.cp_link_tip_a);
                }
            }
            this.dXY.setText(com.baidu.tbadk.core.util.av.s(qVar.getTime()));
            if (this.ctc) {
                int i2 = r.f.img_default_100;
            } else {
                int i3 = r.f.icon_click;
            }
            this.eiG.setText(String.format(this.eiy.getPageContext().getString(r.j.is_floor), Integer.valueOf(qVar.bga())));
            qVar.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.eiH, qVar.avP());
            if (StringUtils.isNull(qVar.bgg()) && !a && qVar.HF() != null) {
                this.bcK.setVisibility(0);
                this.bcK.setTag(qVar.HF());
                return;
            }
            this.bcK.setVisibility(8);
        }
    }

    private void a(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            int gy = com.baidu.tbadk.util.u.gy(name_show);
            com.baidu.tbadk.core.util.ar.j((View) this.ahw, r.d.cp_cont_c);
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aR(metaData.getSealPrefix()) + 2 : 0) + gy > 14) {
                name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.ahw.setText(ag(metaData.getSealPrefix(), name_show));
            } else {
                this.ahw.setText(name_show);
            }
            this.eiV = 0;
            this.eiV = metaData.getLevel_id();
            if (this.eiV > 0) {
                this.eiE.setVisibility(0);
                com.baidu.tbadk.core.util.ar.c(this.eiE, BitmapHelper.getSmallGradeResourceIdNew(this.eiV));
                this.eiE.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(this.eiV)));
                this.eiE.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.eiE.setOnClickListener(null);
            } else {
                this.eiE.setVisibility(8);
            }
            if (metaData.isGod()) {
                this.edv.setVisibility(0);
                this.eiD.setVisibility(8);
                this.edv.setUserId(metaData.getUserId());
                this.edv.setUserName(metaData.getUserName());
                this.edv.c(metaData.getPortrait(), 28, false);
            } else {
                this.edv.setVisibility(8);
                this.eiD.setVisibility(0);
                this.eiD.setUserId(metaData.getUserId());
                this.eiD.setUserName(metaData.getUserName());
                this.eiD.setDefaultResource(r.f.transparent_bg);
                this.eiD.setDefaultErrorResource(r.f.icon_default_avatar100);
                this.eiD.c(metaData.getPortrait(), 28, false);
            }
            this.eiC.setTag(r.g.tag_user_id, metaData.getUserId());
            this.eiC.setTag(r.g.tag_user_name, metaData.getUserName());
        }
    }

    private boolean a(TextView textView, com.baidu.tbadk.widget.richText.a aVar) {
        if (textView == null || aVar == null || aVar.Hy() == null) {
            return false;
        }
        com.baidu.tbadk.widget.richText.c cVar = new com.baidu.tbadk.widget.richText.c(1);
        Iterator<com.baidu.tbadk.widget.richText.c> it = aVar.Hy().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        cVar.append(next.HE());
                        continue;
                    case 17:
                        String str = next.HI().ayb.axC;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            cVar.append("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                    case 18:
                        cVar.cb(true);
                        textView.setMovementMethod(com.baidu.tieba.view.g.bki());
                        continue;
                }
            }
        }
        if (!cVar.HN()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (cVar.HE() == null || cVar.HE().length() <= 0) {
                return false;
            }
            textView.setText(cVar.HE());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eiy.getPageContext().getString(r.j.refresh_view_title_text), this.MQ));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.eiy.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.eiz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, r.f.pic_emotion07, com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds300), com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds480), com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds360)), dVar, a);
        }
        this.eiz.setVisibility(0);
        this.Ck.setVisibility(8);
        this.ban.setVisibility(8);
        this.ddg.DA();
        com.baidu.tbadk.core.util.ar.l(this.mNoDataView, r.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.eiy.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    /* renamed from: if  reason: not valid java name */
    public void m23if(int i) {
        a(NoDataViewFactory.d.x(i, r.j.refresh_view_title_text));
        if (this.eip != null) {
            this.eip.aX(this.dUZ);
        }
        this.eiU.setVisibility(8);
    }

    public void ok(String str) {
        a(NoDataViewFactory.d.af(str, this.eiy.getPageContext().getString(r.j.refresh_view_title_text)));
        if (this.eip != null) {
            this.eip.aX(this.dUZ);
        }
        this.eiU.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Ck.setVisibility(0);
            this.eiU.setVisibility(0);
            this.dUZ.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.MQ = onClickListener;
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
            if (this.ehB != null && this.ehB.IU() != null && this.ehB.IU().getAuthor() != null && qVar.getAuthor() != null) {
                String userId3 = this.ehB.IU().getAuthor().getUserId();
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
                    int i2 = qVar.bga() != 1 ? 0 : 1;
                    if (eq.h(qVar)) {
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
                        if (this.ehB.IU() != null) {
                            sparseArray.put(r.g.tag_user_mute_thread_id, this.ehB.IU().getId());
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
            if (qVar.bga() != 1) {
            }
            if (eq.h(qVar)) {
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

    public void iR(boolean z) {
        if (this.dZp != null && this.dZp.aKM() != null) {
            if (z) {
                this.dZp.aKM().setText(r.j.remove_mark);
            } else {
                this.dZp.aKM().setText(r.j.mark);
            }
            this.dZp.vT();
        }
    }

    public View aNd() {
        return this.eiO;
    }

    public void onChangeSkinType(int i) {
        this.eiy.getLayoutMode().ai(i == 1);
        this.eiy.getLayoutMode().x(this.dUZ);
        this.eiy.getLayoutMode().x(this.eiw);
        this.mNavigationBar.onChangeSkinType(this.eiy.getPageContext(), i);
        if (this.eiB != null) {
            com.baidu.tbadk.core.util.ar.j((View) this.eiB, r.d.goto_see_subject_color);
        }
        com.baidu.tbadk.core.util.ar.j((View) this.eiA, r.d.cp_cont_d);
        this.bvK.onChangeSkinType(this.eiy.getPageContext(), i);
        this.eiy.getLayoutMode().x(this.eiO);
        com.baidu.tbadk.core.util.ar.j((View) this.eiH, r.d.cp_cont_b);
        this.eiH.setLinkTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_link_tip_c));
        if (this.ddg != null && this.ddg.CB() != null) {
            this.ddg.CB().onChangeSkinType(i);
        }
        this.eiL.dk(i);
        this.bcK.axx();
        com.baidu.tbadk.core.util.ar.j((View) this.eiU, r.d.cp_cont_d);
        com.baidu.tbadk.core.util.ar.k(this.eiU, r.f.pb_ecomm_comment_bg);
        com.baidu.tbadk.core.util.ar.j((View) this.eiF, r.d.cp_link_tip_a);
        com.baidu.tbadk.core.util.ar.j((View) this.ahw, r.d.cp_cont_c);
        if (this.eiV > 0) {
            com.baidu.tbadk.core.util.ar.c(this.eiE, BitmapHelper.getSmallGradeResourceIdNew(this.eiV));
        }
        this.eiU.setAlpha(0.95f);
        if (this.eix != null) {
            this.eix.notifyDataSetChanged();
        }
    }

    public void aNe() {
        this.ban.setVisibility(0);
    }

    public void aNf() {
        this.Ck.setVisibility(0);
        this.ban.setVisibility(8);
        this.eiL.wq();
    }

    public void Vq() {
        this.Ck.setVisibility(0);
        this.ban.setVisibility(8);
        this.eiL.Vq();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.brV = onLongClickListener;
        this.eiw.setOnLongClickListener(this.brV);
    }

    public View aNg() {
        return this.eiw;
    }

    public TextView aNh() {
        return this.eiU;
    }

    public void ol(String str) {
        int om = this.eix.om(str);
        if (om > -1) {
            this.eix.nT(om);
            if (om > 2) {
                this.Ck.setSelection(om - 2);
            } else {
                this.Ck.setSelection(om);
            }
            this.Ck.invalidate();
        }
    }

    public View aNi() {
        return this.eiB;
    }

    public View aNj() {
        return this.eiI;
    }

    public MorePopupWindow aNk() {
        return this.eiM;
    }

    public void aub() {
        if (this.egc == null) {
            this.egc = new com.baidu.tbadk.core.view.a(this.eiy.getPageContext());
        }
        this.egc.aJ(true);
    }

    public void aHa() {
        if (this.egc != null) {
            this.egc.aJ(false);
        }
    }

    public TextView aNl() {
        return this.eiH;
    }

    public void setOnLinkImageClickListener(TbRichTextView.f fVar) {
        this.eif = fVar;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.eig = eVar;
    }

    public dj aNm() {
        return this.dZp;
    }

    public void Zh() {
    }

    public void Zi() {
    }

    public void onActivityDestroy() {
    }

    public void aNn() {
        if (this.eiy.RO()) {
        }
    }

    public View aNo() {
        return this.eiC;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new ap.a(str, r.f.pic_smalldot_title));
            return com.baidu.tieba.card.ap.a((Context) this.eiy.getActivity(), str2, (ArrayList<ap.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
