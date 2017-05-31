package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
import com.baidu.tieba.pb.pb.main.el;
import com.baidu.tieba.pb.pb.main.fq;
import com.baidu.tieba.pb.pb.main.fw;
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
    private static final int eyh = TbadkCoreApplication.m9getInst().getListItemRule().xH();
    private BdListView Ic;
    private View bQy;
    private NoNetworkView bRy;
    private com.baidu.tbadk.core.view.a bgw;
    private View.OnClickListener cvw;
    private RelativeLayout egQ;
    private el elZ;
    private com.baidu.tieba.pb.data.n ewW;
    private SubPbModel exN;
    private View eyB;
    private ArrayList<PostData> eyF;
    private String eyG;
    private TextView eyH;
    private b eyb;
    private View eyi;
    private ba eyj;
    private NewSubPbActivity eyk;
    private RelativeLayout eyl;
    private TextView eyn;
    private View eyr;
    private ThreadSkinView eyx;
    private bb eyy;
    private ProgressBar mProgress;
    private int maxImageWidth;
    private com.baidu.tbadk.core.view.y mNoDataView = null;
    private TbRichTextView.e exS = null;
    private View.OnClickListener QE = null;
    private TbRichTextView.f exR = null;
    private NavigationBar mNavigationBar = null;
    private View aob = null;
    private TextView eyo = null;
    private LinearLayout eyp = null;
    private HeadImageView eyq = null;
    private ClickableHeaderImageView etj = null;
    private TextView amy = null;
    private ImageView eys = null;
    private TextView esY = null;
    private TextView eyt = null;
    private TextView ekx = null;
    private EllipsizeRichTextView eyu = null;
    private TbImageView eyv = null;
    private PlayVoiceBntNew bBq = null;
    private TextView eyw = null;
    private MorePopupWindow eyz = null;
    private fq eyA = null;
    private com.baidu.tbadk.core.dialog.c etX = null;
    private Dialog etD = null;
    private com.baidu.tbadk.core.dialog.a etF = null;
    private boolean eka = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener ctr = null;
    private NewSubPbActivity.a eyC = null;
    private NewSubPbActivity.a eyD = null;
    private ArrayList<IconData> eke = null;
    private ArrayList<IconData> cXF = null;
    private com.baidu.tbadk.editortools.pb.n dnc = null;
    private String eyE = null;
    private int aMT = 0;
    private PostData ejm = null;
    private int eyI = 0;
    private int eyJ = 2;
    private int eyK = 0;
    private boolean eyc = true;
    protected HashMap<Long, HashSet<String>> eyL = new HashMap<>();
    protected final b.a eyM = new ap(this);
    private View.OnClickListener ekf = new at(this);
    private com.baidu.tieba.pb.a.d aOc = new com.baidu.tieba.pb.a.d(new au(this));
    protected AdapterView.OnItemClickListener eyN = new av(this);
    protected AdapterView.OnItemLongClickListener mOnItemLongClickListener = new aw(this);

    public ao(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.egQ = null;
        this.eyi = null;
        this.Ic = null;
        this.eyj = null;
        this.eyk = null;
        this.bRy = null;
        this.eyl = null;
        this.eyn = null;
        this.eyr = null;
        this.eyy = null;
        this.eyB = null;
        this.cvw = null;
        this.mProgress = null;
        this.eyH = null;
        this.eyk = newSubPbActivity;
        this.cvw = onClickListener;
        this.egQ = (RelativeLayout) LayoutInflater.from(this.eyk.getPageContext().getPageActivity()).inflate(w.j.new_sub_pb_layout, (ViewGroup) null);
        this.eyi = LayoutInflater.from(this.eyk.getPageContext().getPageActivity()).inflate(w.j.new_sub_pb_head, (ViewGroup) null);
        this.eyn = (TextView) this.egQ.findViewById(w.h.no_reply_list_view);
        this.eyH = (TextView) this.egQ.findViewById(w.h.subpb_editor_tool_reply_text);
        this.eyH.setOnClickListener(this.cvw);
        this.bRy = (NoNetworkView) this.egQ.findViewById(w.h.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.af(this.eyk.getBaseContext()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds60);
        aNT();
        aNQ();
        this.eyl = (RelativeLayout) this.egQ.findViewById(w.h.sub_pb_body_layout);
        this.Ic = (BdListView) this.egQ.findViewById(w.h.new_sub_pb_list);
        this.eyx = (ThreadSkinView) LayoutInflater.from(this.eyk.getPageContext().getPageActivity()).inflate(w.j.thread_skin_layout, (ViewGroup) null);
        this.Ic.addHeaderView(this.eyx);
        this.Ic.addHeaderView(this.eyi);
        this.bQy = BdListViewHelper.a(this.eyk.getActivity(), this.Ic, BdListViewHelper.HeadType.DEFAULT);
        this.eyj = new ba(this.eyk.getPageContext().getPageActivity());
        this.eyj.J(this.ekf);
        this.eyj.setIsFromCDN(this.mIsFromCDN);
        this.eyj.jg(true);
        this.Ic.setAdapter((ListAdapter) this.eyj);
        this.eyy = new bb(this.eyk.getPageContext());
        this.eyB = this.eyy.getView();
        this.Ic.setNextPage(this.eyy);
        this.eyy.setOnClickListener(this.cvw);
        this.Ic.setOnItemClickListener(this.eyN);
        this.Ic.setOnTouchListener(this.aOc);
        this.mProgress = (ProgressBar) this.egQ.findViewById(w.h.progress);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.eyi != null) {
            this.eyi.setVisibility(4);
        }
        if (this.eyl != null) {
            this.eyl.setVisibility(4);
        }
        this.eyr = com.baidu.tbadk.ala.b.nz().h(this.eyk.getActivity(), 4);
        if (this.eyr != null) {
            this.eyr.setVisibility(8);
            this.eyp.addView(this.eyr, 3);
        }
    }

    public ListView getListView() {
        return this.Ic;
    }

    public void aNQ() {
        this.eyp = (LinearLayout) this.eyi.findViewById(w.h.subpb_head_user_info_root);
        this.eyp.setOnClickListener(this.cvw);
        this.eyq = (HeadImageView) this.eyi.findViewById(w.h.photo);
        this.eyq.setRadius(com.baidu.adp.lib.util.k.g(this.eyk.getActivity(), w.f.ds30));
        this.eyq.setClickable(false);
        this.etj = (ClickableHeaderImageView) this.eyi.findViewById(w.h.god_user_photo);
        this.etj.setGodIconMargin(0);
        this.etj.setGodIconWidth(w.f.ds24);
        this.etj.setRadius(com.baidu.adp.lib.util.k.g(this.eyk.getActivity(), w.f.ds30));
        this.etj.setClickable(false);
        this.amy = (TextView) this.eyi.findViewById(w.h.user_name);
        this.eys = (ImageView) this.eyi.findViewById(w.h.user_rank);
        this.eys.setVisibility(8);
        this.esY = (TextView) this.eyi.findViewById(w.h.floor_owner);
        this.eyo = (TextView) this.eyi.findViewById(w.h.see_subject);
        this.eyo.setOnClickListener(this.cvw);
        this.eyt = (TextView) this.eyi.findViewById(w.h.floor);
        this.ekx = (TextView) this.eyi.findViewById(w.h.time);
        this.eyu = (EllipsizeRichTextView) this.eyi.findViewById(w.h.content_text);
        this.eyu.setOnClickListener(this.cvw);
        com.baidu.tbadk.core.util.aq.i(this.eyu, w.e.cp_cont_b);
        this.eyu.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
        this.eyu.setLineSpacing(0.0f, 1.25f);
        this.eyv = (TbImageView) this.eyi.findViewById(w.h.sub_pb_image);
        this.eyv.setOnClickListener(this.cvw);
        this.eyw = (TextView) this.eyi.findViewById(w.h.advert);
        this.bBq = (PlayVoiceBntNew) this.eyi.findViewById(w.h.voice_btn);
        this.eyi.setOnTouchListener(this.aOc);
        this.eyi.setOnClickListener(this.cvw);
    }

    public void jd(boolean z) {
        if (this.bQy != null && this.bQy.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bQy.getLayoutParams();
            if (z) {
                aNR();
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.eyk.getPageContext().getPageActivity(), w.f.ds98);
            } else {
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.eyk.getPageContext().getPageActivity(), w.f.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.bQy.setLayoutParams(layoutParams);
        }
    }

    private void aNR() {
        this.mNavigationBar.setmBackImageViewBg(w.g.subpb_navigationbar_close, w.g.subpb_navigationbar_close);
    }

    public View aNS() {
        return this.bQy;
    }

    public void aNT() {
        this.mNavigationBar = (NavigationBar) this.egQ.findViewById(w.h.view_navigation_bar);
        this.aob = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aob.getLayoutParams();
            int g = com.baidu.adp.lib.util.k.g(this.eyk.getPageContext().getPageActivity(), w.f.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aob != null && (this.aob.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aob.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aob.setPadding(com.baidu.adp.lib.util.k.g(this.eyk.getPageContext().getPageActivity(), w.f.ds32), this.aob.getPaddingTop(), this.aob.getPaddingRight(), this.aob.getPaddingBottom());
            this.aob.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(w.g.subpb_navigationbar_back, w.g.subpb_navigationbar_back);
    }

    public NavigationBar aaU() {
        return this.mNavigationBar;
    }

    public void aX(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.etD == null) {
            this.etD = new Dialog(this.eyk.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.etD.setCanceledOnTouchOutside(true);
            this.etD.setCancelable(true);
            View inflate = LayoutInflater.from(this.eyk.getPageContext().getPageActivity()).inflate(w.j.forum_manage_dialog, (ViewGroup) null);
            this.eyk.getLayoutMode().t(inflate);
            this.etD.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.etD.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.af(this.eyk.getPageContext().getPageActivity()) * 0.9d);
            this.etD.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.etD.findViewById(w.h.del_post_btn);
        TextView textView2 = (TextView) this.etD.findViewById(w.h.forbid_user_btn);
        TextView textView3 = (TextView) this.etD.findViewById(w.h.disable_reply_btn);
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
        com.baidu.adp.lib.g.j.a(this.etD, this.eyk.getPageContext());
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
        this.etF = new com.baidu.tbadk.core.dialog.a(this.eyk.getPageContext().getPageActivity());
        this.etF.bY(i3);
        this.etF.A(sparseArray);
        this.etF.a(w.l.dialog_ok, new aq(this, sparseArray));
        this.etF.b(w.l.dialog_cancel, new ar(this));
        this.etF.ar(true);
        this.etF.b(this.eyk.getPageContext());
        this.etF.tc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void je(boolean z) {
        if (this.Ic != null) {
            if (!z) {
                this.Ic.setEnabled(z);
            } else {
                this.Ic.postDelayed(new as(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.etX != null) {
            this.etX.dismiss();
            this.etX = null;
        }
        if (z) {
            string = this.eyk.getResources().getString(w.l.remove_mark);
        } else {
            string = this.eyk.getResources().getString(w.l.mark);
        }
        this.etX = new com.baidu.tbadk.core.dialog.c(this.eyk.getPageContext().getPageActivity());
        this.etX.cb(w.l.operation);
        this.etX.a(new String[]{this.eyk.getResources().getString(w.l.copy), string}, bVar);
        this.etX.d(this.eyk.getPageContext());
        this.etX.tf();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.eyC = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.eyD = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.eyk.showToast(this.eyk.getResources().getString(w.l.delete_success));
        } else if (str != null && z2) {
            this.eyk.showToast(str);
        }
    }

    public void ba(View view) {
        if (this.bQy != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bQy.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Ic != null) {
                    this.Ic.removeHeaderView(this.bQy);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.bQy.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.eyk.getActivity(), w.f.ds98)));
            } else if (this.Ic != null) {
                this.Ic.addHeaderView(this.bQy, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.n nVar) {
        if (nVar != null && nVar.Cm() != null) {
            this.dnc = nVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.egQ.addView(nVar.Cm(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.eyb = bVar;
    }

    public void aNU() {
        if (this.Ic != null) {
            this.eyK = this.Ic.getLastVisiblePosition();
        }
    }

    public void aNV() {
        if (this.exN != null) {
            if ((!aNY() && this.eyB != null && this.eyB.isShown()) || com.baidu.tbadk.core.util.x.r(this.eyF)) {
                this.exN.ji(false);
            } else {
                this.exN.ji(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.exN = subPbModel;
    }

    public void aNW() {
        a(this.eyk);
        this.Ic.setNextPage(this.eyy);
    }

    public void l(PostData postData) {
        int i;
        if (postData != null) {
            postData.ls(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aNY() && this.eyB != null && this.eyB.isShown()) {
                i = (this.eyK - this.eyJ) - 1;
            } else {
                i = this.eyK - this.eyJ;
            }
            int q = com.baidu.tbadk.core.util.x.q(this.eyF);
            if (i > q) {
                i = q;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(com.baidu.tbadk.core.util.x.a(this.eyF, 0, i));
            com.baidu.tbadk.core.util.x.b(arrayList, postData2);
            com.baidu.tbadk.core.util.x.b(arrayList, postData);
            this.eyj.setDatas(arrayList);
            this.eyj.notifyDataSetChanged();
            this.Ic.smoothScrollToPosition(this.eyK + 2);
            this.Ic.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Ic.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.Ic.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.egQ;
    }

    public void avy() {
        if (this.eyz != null) {
            com.baidu.adp.lib.g.j.a(this.eyz, this.eyk.getPageContext().getPageActivity());
        }
        if (this.etX != null) {
            this.etX.dismiss();
        }
        if (this.etF != null) {
            this.etF.dismiss();
        }
        if (this.etD != null) {
            com.baidu.adp.lib.g.j.b(this.etD, this.eyk.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.elZ != null) {
            this.elZ.dismiss();
        }
    }

    public void aNX() {
        this.Ic.setNextPage(this.eyy);
        this.eyy.wl();
    }

    public void hZ(boolean z) {
        this.eka = z;
    }

    public void setIsFromPb(boolean z) {
        this.eyc = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.pb.data.n nVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (nVar != null) {
            if (this.eyc && this.eyi != null) {
                this.eyj.jh(true);
                this.eyi.setVisibility(8);
                this.Ic.removeHeaderView(this.eyi);
                this.eyJ = 1;
            }
            this.ewW = nVar;
            this.eyj.N(this.ewW.LH());
            if (this.eyi != null) {
                this.eyi.setVisibility(0);
            }
            if (this.eyl != null) {
                this.eyl.setVisibility(0);
            }
            if (nVar.aJj() != null) {
                this.eyE = nVar.aJj().getId();
                this.aMT = nVar.aJj().big();
                if (this.aMT > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.eyk.getResources().getString(w.l.subpb_floor_reply_count), com.baidu.tbadk.core.util.au.x(nVar.getTotalCount())));
                    this.eyH.setText(w.l.add_floor_reply_tip);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.eyk.aNP()) {
                    str = "PB";
                }
                if (nVar.aJj().rP() != null) {
                    this.eyx.a(this.eyk.getPageContext(), nVar.aJj().rP(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", nVar.aJp().getId(), nVar.aJp().getName(), nVar.LH().getId(), str));
                } else {
                    this.eyx.a(null, null, null);
                }
            }
            if (nVar.hasMore()) {
                this.eyy.wl();
                this.eyj.setHasMoreData(true);
            } else {
                this.eyy.wm();
                this.eyj.setHasMoreData(false);
            }
            this.eyF = nVar.aJn();
            if (com.baidu.tbadk.core.util.x.r(this.eyF)) {
                this.Ic.setNextPage(null);
                if (this.eyc) {
                    this.eyn.setVisibility(0);
                }
            } else {
                this.Ic.setNextPage(this.eyy);
                if (this.eyc) {
                    this.eyn.setVisibility(8);
                }
            }
            if (this.eyF == null || this.eyF.size() <= eyh) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.eyF.size() - eyh;
                oR(size);
                int firstVisiblePosition = this.Ic.getFirstVisiblePosition() - size;
                View childAt = this.Ic.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.eyj.setDatas(this.eyF);
            boolean z2 = false;
            if (nVar.LH() != null && nVar.LH().getAuthor() != null && (userId = nVar.LH().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.eyj.A(i, z2);
            this.eyj.notifyDataSetChanged();
            a(nVar.aJj(), nVar.arL(), nVar.nD(), i, z);
            if (i4 > 0) {
                this.Ic.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void oR(int i) {
        if (this.eyF != null) {
            if (this.eyF.size() <= i) {
                this.eyF.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.eyF.iterator();
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

    public boolean aNY() {
        return this.eyj.bIW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eyc) {
            this.ejm = postData;
            if (!StringUtils.isNull(postData.bim())) {
                this.eyv.setVisibility(0);
                this.eyv.c(postData.bim(), 10, true);
            } else {
                this.eyv.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.h bio = postData.bio();
            if (bio != null && bio.fBJ) {
                this.eyw.setVisibility(0);
            } else {
                this.eyw.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.eyi.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.eyi.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.eyt.setText((CharSequence) null);
            this.amy.setText((CharSequence) null);
            this.esY.setVisibility(8);
            if (!this.eyc) {
                b(postData.getAuthor());
                if (z) {
                    this.esY.setVisibility(0);
                    com.baidu.tbadk.core.util.aq.i(this.esY, w.e.cp_link_tip_a);
                }
            }
            this.ekx.setText(com.baidu.tbadk.core.util.au.q(postData.getTime()));
            if (this.eka) {
                int i2 = w.g.img_default_100;
            } else {
                int i3 = w.g.icon_click;
            }
            this.eyt.setText(String.format(this.eyk.getPageContext().getString(w.l.is_floor), Integer.valueOf(postData.big())));
            postData.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.eyu, postData.avd());
            if (StringUtils.isNull(postData.bim()) && !a && postData.HF() != null) {
                this.bBq.setVisibility(0);
                this.bBq.setTag(postData.HF());
                return;
            }
            this.bBq.setVisibility(8);
        }
    }

    private void b(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            int gn = com.baidu.tbadk.util.x.gn(name_show);
            com.baidu.tbadk.core.util.aq.i(this.amy, w.e.cp_cont_c);
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aF(metaData.getSealPrefix()) + 2 : 0) + gn > 14) {
                name_show = String.valueOf(com.baidu.tbadk.util.x.d(name_show, 0, 14)) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.amy.setText(ae(metaData.getSealPrefix(), name_show));
            } else {
                this.amy.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.eyr != null) {
                if (metaData.getAlaUserData().anchor_live == 0 && metaData.getAlaUserData().enter_live == 0) {
                    this.eyr.setVisibility(8);
                } else {
                    this.eyr.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.PW = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.eyr.setTag(aVar);
                }
            }
            if (metaData.isGod()) {
                this.etj.setVisibility(0);
                this.eyq.setVisibility(8);
                this.etj.setUserId(metaData.getUserId());
                this.etj.setUserName(metaData.getUserName());
                this.etj.c(metaData.getPortrait(), 28, false);
            } else {
                this.etj.setVisibility(8);
                this.eyq.setVisibility(0);
                this.eyq.setUserId(metaData.getUserId());
                this.eyq.setUserName(metaData.getUserName());
                this.eyq.setDefaultResource(w.g.transparent_bg);
                this.eyq.setDefaultErrorResource(w.g.icon_default_avatar100);
                this.eyq.c(metaData.getPortrait(), 28, false);
            }
            this.eyp.setTag(w.h.tag_user_id, metaData.getUserId());
            this.eyp.setTag(w.h.tag_user_name, metaData.getUserName());
            this.eyp.setTag(w.h.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Hx() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Hx().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.HE());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cc(true);
                        textView.setMovementMethod(com.baidu.tieba.view.g.bmr());
                        continue;
                    case 17:
                        String str = next.HI().mGifInfo.mSharpText;
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
        if (!tbRichTextData.HN()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.HE() == null || tbRichTextData.HE().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.HE());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eyk.getPageContext().getString(w.l.refresh_view_title_text), this.QE));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.eyk.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.eyl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, w.g.pic_emotion07, com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds300), com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds480), com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds360)), dVar, a);
        }
        this.eyl.setVisibility(0);
        this.Ic.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.dnc.Dk();
        com.baidu.tbadk.core.util.aq.k(this.mNoDataView, w.e.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.eyk.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gc(int i) {
        a(NoDataViewFactory.d.B(i, w.l.refresh_view_title_text));
        if (this.eyb != null) {
            this.eyb.aY(this.egQ);
        }
        this.eyH.setVisibility(8);
    }

    public void oh(String str) {
        a(NoDataViewFactory.d.ad(str, this.eyk.getPageContext().getString(w.l.refresh_view_title_text)));
        if (this.eyb != null) {
            this.eyb.aY(this.egQ);
        }
        this.eyH.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Ic.setVisibility(0);
            this.eyH.setVisibility(0);
            this.egQ.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.QE = onClickListener;
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
            if (this.ewW != null && this.ewW.LH() != null && this.ewW.LH().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.ewW.LH().getAuthor().getUserId();
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
                    int i2 = postData.big() != 1 ? 0 : 1;
                    if (fw.i(postData)) {
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
                        if (this.ewW.LH() != null) {
                            sparseArray.put(w.h.tag_user_mute_thread_id, this.ewW.LH().getId());
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
            if (postData.big() != 1) {
            }
            if (fw.i(postData)) {
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

    public void jf(boolean z) {
        if (this.elZ != null && this.elZ.aLt() != null) {
            if (z) {
                this.elZ.aLt().setText(w.l.remove_mark);
            } else {
                this.elZ.aLt().setText(w.l.mark);
            }
            this.elZ.refreshUI();
        }
    }

    public View aNZ() {
        return this.eyB;
    }

    public void onChangeSkinType(int i) {
        this.eyk.getLayoutMode().ah(i == 1);
        this.eyk.getLayoutMode().t(this.egQ);
        this.eyk.getLayoutMode().t(this.eyi);
        this.mNavigationBar.onChangeSkinType(this.eyk.getPageContext(), i);
        if (this.eyo != null) {
            com.baidu.tbadk.core.util.aq.i(this.eyo, w.e.goto_see_subject_color);
        }
        com.baidu.tbadk.core.util.aq.i(this.eyn, w.e.cp_cont_d);
        this.bRy.onChangeSkinType(this.eyk.getPageContext(), i);
        this.eyk.getLayoutMode().t(this.eyB);
        com.baidu.tbadk.core.util.aq.i(this.eyu, w.e.cp_cont_b);
        this.eyu.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
        if (this.dnc != null && this.dnc.Cm() != null) {
            this.dnc.Cm().onChangeSkinType(i);
        }
        this.eyy.dj(i);
        this.bBq.aZV();
        com.baidu.tbadk.core.util.aq.i(this.eyH, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.j(this.eyH, w.g.pb_ecomm_comment_bg);
        com.baidu.tbadk.core.util.aq.i(this.esY, w.e.cp_link_tip_a);
        com.baidu.tbadk.core.util.aq.i(this.amy, w.e.cp_cont_c);
        this.eyH.setAlpha(0.95f);
        if (this.eyj != null) {
            this.eyj.notifyDataSetChanged();
        }
    }

    public void aOa() {
        this.mProgress.setVisibility(0);
    }

    public void aOb() {
        this.Ic.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eyy.wm();
    }

    public void Zb() {
        this.Ic.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eyy.Zb();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ctr = onLongClickListener;
        this.eyi.setOnLongClickListener(this.ctr);
    }

    public View aOc() {
        return this.eyi;
    }

    public TextView aOd() {
        return this.eyH;
    }

    public void oi(String str) {
        int oj = this.eyj.oj(str);
        if (oj > -1) {
            this.eyj.oS(oj);
            if (oj > 2) {
                this.Ic.setSelection(oj - 2);
            } else {
                this.Ic.setSelection(oj);
            }
            this.Ic.invalidate();
        }
    }

    public View aOe() {
        return this.eyo;
    }

    public View aOf() {
        return this.eyv;
    }

    public MorePopupWindow aOg() {
        return this.eyz;
    }

    public void Pd() {
        if (this.bgw == null) {
            this.bgw = new com.baidu.tbadk.core.view.a(this.eyk.getPageContext());
        }
        this.bgw.aH(true);
    }

    public void Pe() {
        if (this.bgw != null) {
            this.bgw.aH(false);
        }
    }

    public TextView aOh() {
        return this.eyu;
    }

    public void setOnLinkImageClickListener(TbRichTextView.f fVar) {
        this.exR = fVar;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.exS = eVar;
    }

    public el aOi() {
        return this.elZ;
    }

    public void abV() {
    }

    public void abW() {
    }

    public void onActivityDestroy() {
    }

    public void aOj() {
        if (this.eyk.aNO()) {
        }
    }

    public View aOk() {
        return this.eyp;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str, w.g.pic_smalldot_title));
            return com.baidu.tieba.card.at.a((Context) this.eyk.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
