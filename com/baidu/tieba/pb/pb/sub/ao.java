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
import com.baidu.tieba.pb.pb.main.eu;
import com.baidu.tieba.pb.pb.main.fz;
import com.baidu.tieba.pb.pb.main.gf;
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
    private static final int eHF = TbadkCoreApplication.m9getInst().getListItemRule().xY();
    private BdListView Ib;
    private View bXv;
    private NoNetworkView bYU;
    private com.baidu.tbadk.core.view.a bjx;
    private View.OnClickListener cDj;
    private com.baidu.tieba.pb.data.n eGs;
    private View eHG;
    private ba eHH;
    private NewSubPbActivity eHI;
    private RelativeLayout eHJ;
    private TextView eHK;
    private View eHO;
    private ThreadSkinView eHU;
    private bb eHV;
    private View eHY;
    private SubPbModel eHl;
    private b eHz;
    private ArrayList<PostData> eIc;
    private String eId;
    private TextView eIe;
    private RelativeLayout epN;
    private eu euZ;
    private ProgressBar mProgress;
    private int maxImageWidth;
    private com.baidu.tbadk.core.view.y mNoDataView = null;
    private TbRichTextView.e eHq = null;
    private View.OnClickListener Qy = null;
    private TbRichTextView.f eHp = null;
    private NavigationBar mNavigationBar = null;
    private View apb = null;
    private TextView eHL = null;
    private LinearLayout eHM = null;
    private HeadImageView eHN = null;
    private ClickableHeaderImageView eCt = null;
    private TextView anw = null;
    private ImageView eHP = null;
    private TextView eCj = null;
    private TextView eHQ = null;
    private TextView etw = null;
    private EllipsizeRichTextView eHR = null;
    private TbImageView eHS = null;
    private PlayVoiceBntNew bCj = null;
    private TextView eHT = null;
    private MorePopupWindow eHW = null;
    private fz eHX = null;
    private com.baidu.tbadk.core.dialog.c eDh = null;
    private Dialog eCN = null;
    private com.baidu.tbadk.core.dialog.a eCP = null;
    private boolean esY = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener cBe = null;
    private NewSubPbActivity.a eHZ = null;
    private NewSubPbActivity.a eIa = null;
    private ArrayList<IconData> etd = null;
    private ArrayList<IconData> dfE = null;
    private com.baidu.tbadk.editortools.pb.n duY = null;
    private String eIb = null;
    private int aOj = 0;
    private PostData esk = null;
    private int eIf = 0;
    private int eIg = 2;
    private int eIh = 0;
    private boolean eHA = true;
    protected HashMap<Long, HashSet<String>> eIi = new HashMap<>();
    protected final b.a eIj = new ap(this);
    private View.OnClickListener ete = new at(this);
    private com.baidu.tieba.pb.a.d aPs = new com.baidu.tieba.pb.a.d(new au(this));
    protected AdapterView.OnItemClickListener eIk = new av(this);
    protected AdapterView.OnItemLongClickListener mOnItemLongClickListener = new aw(this);

    public ao(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.epN = null;
        this.eHG = null;
        this.Ib = null;
        this.eHH = null;
        this.eHI = null;
        this.bYU = null;
        this.eHJ = null;
        this.eHK = null;
        this.eHO = null;
        this.eHV = null;
        this.eHY = null;
        this.cDj = null;
        this.mProgress = null;
        this.eIe = null;
        this.eHI = newSubPbActivity;
        this.cDj = onClickListener;
        this.epN = (RelativeLayout) LayoutInflater.from(this.eHI.getPageContext().getPageActivity()).inflate(w.j.new_sub_pb_layout, (ViewGroup) null);
        this.eHG = LayoutInflater.from(this.eHI.getPageContext().getPageActivity()).inflate(w.j.new_sub_pb_head, (ViewGroup) null);
        this.eHK = (TextView) this.epN.findViewById(w.h.no_reply_list_view);
        this.eIe = (TextView) this.epN.findViewById(w.h.subpb_editor_tool_reply_text);
        this.eIe.setOnClickListener(this.cDj);
        this.bYU = (NoNetworkView) this.epN.findViewById(w.h.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.af(this.eHI.getBaseContext()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds60);
        aRS();
        aRP();
        this.eHJ = (RelativeLayout) this.epN.findViewById(w.h.sub_pb_body_layout);
        this.Ib = (BdListView) this.epN.findViewById(w.h.new_sub_pb_list);
        this.eHU = (ThreadSkinView) LayoutInflater.from(this.eHI.getPageContext().getPageActivity()).inflate(w.j.thread_skin_layout, (ViewGroup) null);
        this.Ib.addHeaderView(this.eHU);
        this.Ib.addHeaderView(this.eHG);
        this.bXv = BdListViewHelper.a(this.eHI.getActivity(), this.Ib, BdListViewHelper.HeadType.DEFAULT);
        this.eHH = new ba(this.eHI.getPageContext().getPageActivity());
        this.eHH.K(this.ete);
        this.eHH.setIsFromCDN(this.mIsFromCDN);
        this.eHH.jE(true);
        this.Ib.setAdapter((ListAdapter) this.eHH);
        this.eHV = new bb(this.eHI.getPageContext());
        this.eHY = this.eHV.getView();
        this.Ib.setNextPage(this.eHV);
        this.eHV.setOnClickListener(this.cDj);
        this.Ib.setOnItemClickListener(this.eIk);
        this.Ib.setOnTouchListener(this.aPs);
        this.mProgress = (ProgressBar) this.epN.findViewById(w.h.progress);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.eHG != null) {
            this.eHG.setVisibility(4);
        }
        if (this.eHJ != null) {
            this.eHJ.setVisibility(4);
        }
        this.eHO = com.baidu.tbadk.ala.b.nv().h(this.eHI.getActivity(), 4);
        if (this.eHO != null) {
            this.eHO.setVisibility(8);
            this.eHM.addView(this.eHO, 3);
        }
    }

    public ListView getListView() {
        return this.Ib;
    }

    public void aRP() {
        this.eHM = (LinearLayout) this.eHG.findViewById(w.h.subpb_head_user_info_root);
        this.eHM.setOnClickListener(this.cDj);
        this.eHN = (HeadImageView) this.eHG.findViewById(w.h.photo);
        this.eHN.setRadius(com.baidu.adp.lib.util.k.g(this.eHI.getActivity(), w.f.ds30));
        this.eHN.setClickable(false);
        this.eCt = (ClickableHeaderImageView) this.eHG.findViewById(w.h.god_user_photo);
        this.eCt.setGodIconMargin(0);
        this.eCt.setGodIconWidth(w.f.ds24);
        this.eCt.setRadius(com.baidu.adp.lib.util.k.g(this.eHI.getActivity(), w.f.ds30));
        this.eCt.setClickable(false);
        this.anw = (TextView) this.eHG.findViewById(w.h.user_name);
        this.eHP = (ImageView) this.eHG.findViewById(w.h.user_rank);
        this.eHP.setVisibility(8);
        this.eCj = (TextView) this.eHG.findViewById(w.h.floor_owner);
        this.eHL = (TextView) this.eHG.findViewById(w.h.see_subject);
        this.eHL.setOnClickListener(this.cDj);
        this.eHQ = (TextView) this.eHG.findViewById(w.h.floor);
        this.etw = (TextView) this.eHG.findViewById(w.h.time);
        this.eHR = (EllipsizeRichTextView) this.eHG.findViewById(w.h.content_text);
        this.eHR.setOnClickListener(this.cDj);
        com.baidu.tbadk.core.util.as.i(this.eHR, w.e.cp_cont_b);
        this.eHR.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_link_tip_c));
        this.eHR.setLineSpacing(0.0f, 1.25f);
        this.eHS = (TbImageView) this.eHG.findViewById(w.h.sub_pb_image);
        this.eHS.setOnClickListener(this.cDj);
        this.eHT = (TextView) this.eHG.findViewById(w.h.advert);
        this.bCj = (PlayVoiceBntNew) this.eHG.findViewById(w.h.voice_btn);
        this.eHG.setOnTouchListener(this.aPs);
        this.eHG.setOnClickListener(this.cDj);
    }

    public void jB(boolean z) {
        if (this.bXv != null && this.bXv.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bXv.getLayoutParams();
            if (z) {
                aRQ();
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.eHI.getPageContext().getPageActivity(), w.f.ds98);
            } else {
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.eHI.getPageContext().getPageActivity(), w.f.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.bXv.setLayoutParams(layoutParams);
        }
    }

    private void aRQ() {
        this.mNavigationBar.setmBackImageViewBg(w.g.subpb_navigationbar_close, w.g.subpb_navigationbar_close);
    }

    public View aRR() {
        return this.bXv;
    }

    public void aRS() {
        this.mNavigationBar = (NavigationBar) this.epN.findViewById(w.h.view_navigation_bar);
        this.apb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.apb.getLayoutParams();
            int g = com.baidu.adp.lib.util.k.g(this.eHI.getPageContext().getPageActivity(), w.f.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.apb != null && (this.apb.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.apb.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.apb.setPadding(com.baidu.adp.lib.util.k.g(this.eHI.getPageContext().getPageActivity(), w.f.ds32), this.apb.getPaddingTop(), this.apb.getPaddingRight(), this.apb.getPaddingBottom());
            this.apb.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(w.g.subpb_navigationbar_back, w.g.subpb_navigationbar_back);
    }

    public NavigationBar aeL() {
        return this.mNavigationBar;
    }

    public void ba(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.eCN == null) {
            this.eCN = new Dialog(this.eHI.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.eCN.setCanceledOnTouchOutside(true);
            this.eCN.setCancelable(true);
            View inflate = LayoutInflater.from(this.eHI.getPageContext().getPageActivity()).inflate(w.j.forum_manage_dialog, (ViewGroup) null);
            this.eHI.getLayoutMode().t(inflate);
            this.eCN.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.eCN.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.af(this.eHI.getPageContext().getPageActivity()) * 0.9d);
            this.eCN.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eCN.findViewById(w.h.del_post_btn);
        TextView textView2 = (TextView) this.eCN.findViewById(w.h.forbid_user_btn);
        TextView textView3 = (TextView) this.eCN.findViewById(w.h.disable_reply_btn);
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
        com.baidu.adp.lib.g.j.a(this.eCN, this.eHI.getPageContext());
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
        this.eCP = new com.baidu.tbadk.core.dialog.a(this.eHI.getPageContext().getPageActivity());
        this.eCP.bY(i3);
        this.eCP.A(sparseArray);
        this.eCP.a(w.l.dialog_ok, new aq(this, sparseArray));
        this.eCP.b(w.l.dialog_cancel, new ar(this));
        this.eCP.as(true);
        this.eCP.b(this.eHI.getPageContext());
        this.eCP.ta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jC(boolean z) {
        if (this.Ib != null) {
            if (!z) {
                this.Ib.setEnabled(z);
            } else {
                this.Ib.postDelayed(new as(this, z), 10L);
            }
        }
    }

    public void b(c.b bVar, boolean z) {
        String string;
        if (this.eDh != null) {
            this.eDh.dismiss();
            this.eDh = null;
        }
        if (z) {
            string = this.eHI.getResources().getString(w.l.remove_mark);
        } else {
            string = this.eHI.getResources().getString(w.l.mark);
        }
        this.eDh = new com.baidu.tbadk.core.dialog.c(this.eHI.getPageContext().getPageActivity());
        this.eDh.cb(w.l.operation);
        this.eDh.a(new String[]{this.eHI.getResources().getString(w.l.copy), string}, bVar);
        this.eDh.d(this.eHI.getPageContext());
        this.eDh.td();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.eHZ = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.eIa = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.eHI.showToast(this.eHI.getResources().getString(w.l.delete_success));
        } else if (str != null && z2) {
            this.eHI.showToast(str);
        }
    }

    public void bd(View view) {
        if (this.bXv != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bXv.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Ib != null) {
                    this.Ib.removeHeaderView(this.bXv);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.bXv.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.eHI.getActivity(), w.f.ds98)));
            } else if (this.Ib != null) {
                this.Ib.addHeaderView(this.bXv, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.n nVar) {
        if (nVar != null && nVar.CG() != null) {
            this.duY = nVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.epN.addView(nVar.CG(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.eHz = bVar;
    }

    public void aRT() {
        if (this.Ib != null) {
            this.eIh = this.Ib.getLastVisiblePosition();
        }
    }

    public void aRU() {
        if (this.eHl != null) {
            if ((!aRX() && this.eHY != null && this.eHY.isShown()) || com.baidu.tbadk.core.util.z.t(this.eIc)) {
                this.eHl.jG(false);
            } else {
                this.eHl.jG(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.eHl = subPbModel;
    }

    public void aRV() {
        a(this.eHI);
        this.Ib.setNextPage(this.eHV);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.lR(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aRX() && this.eHY != null && this.eHY.isShown()) {
                i = (this.eIh - this.eIg) - 1;
            } else {
                i = this.eIh - this.eIg;
            }
            int s = com.baidu.tbadk.core.util.z.s(this.eIc);
            if (i > s) {
                i = s;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(com.baidu.tbadk.core.util.z.a(this.eIc, 0, i));
            com.baidu.tbadk.core.util.z.b(arrayList, postData2);
            com.baidu.tbadk.core.util.z.b(arrayList, postData);
            this.eHH.setDatas(arrayList);
            this.eHH.notifyDataSetChanged();
            this.Ib.smoothScrollToPosition(this.eIh + 2);
            this.Ib.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Ib.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.Ib.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.epN;
    }

    public void azw() {
        if (this.eHW != null) {
            com.baidu.adp.lib.g.j.a(this.eHW, this.eHI.getPageContext().getPageActivity());
        }
        if (this.eDh != null) {
            this.eDh.dismiss();
        }
        if (this.eCP != null) {
            this.eCP.dismiss();
        }
        if (this.eCN != null) {
            com.baidu.adp.lib.g.j.b(this.eCN, this.eHI.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.euZ != null) {
            this.euZ.dismiss();
        }
    }

    public void aRW() {
        this.Ib.setNextPage(this.eHV);
        this.eHV.wD();
    }

    public void iv(boolean z) {
        this.esY = z;
    }

    public void setIsFromPb(boolean z) {
        this.eHA = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.pb.data.n nVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (nVar != null) {
            if (this.eHA && this.eHG != null) {
                this.eHH.jF(true);
                this.eHG.setVisibility(8);
                this.Ib.removeHeaderView(this.eHG);
                this.eIg = 1;
            }
            this.eGs = nVar;
            this.eHH.O(this.eGs.Mv());
            if (this.eHG != null) {
                this.eHG.setVisibility(0);
            }
            if (this.eHJ != null) {
                this.eHJ.setVisibility(0);
            }
            if (nVar.aNd() != null) {
                this.eIb = nVar.aNd().getId();
                this.aOj = nVar.aNd().bmu();
                if (this.aOj > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.eHI.getResources().getString(w.l.subpb_floor_reply_count), com.baidu.tbadk.core.util.aw.y(nVar.getTotalCount())));
                    this.eIe.setText(w.l.add_floor_reply_tip);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.eHI.aRO()) {
                    str = "PB";
                }
                if (nVar.aNd().rM() != null) {
                    this.eHU.a(this.eHI.getPageContext(), nVar.aNd().rM(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", nVar.aNj().getId(), nVar.aNj().getName(), nVar.Mv().getId(), str));
                } else {
                    this.eHU.a(null, null, null);
                }
            }
            if (nVar.hasMore()) {
                this.eHV.wD();
                this.eHH.setHasMoreData(true);
            } else {
                this.eHV.wE();
                this.eHH.setHasMoreData(false);
            }
            this.eIc = nVar.aNh();
            if (com.baidu.tbadk.core.util.z.t(this.eIc)) {
                this.Ib.setNextPage(null);
                if (this.eHA) {
                    this.eHK.setVisibility(0);
                }
            } else {
                this.Ib.setNextPage(this.eHV);
                if (this.eHA) {
                    this.eHK.setVisibility(8);
                }
            }
            if (this.eIc == null || this.eIc.size() <= eHF) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.eIc.size() - eHF;
                pk(size);
                int firstVisiblePosition = this.Ib.getFirstVisiblePosition() - size;
                View childAt = this.Ib.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.eHH.setDatas(this.eIc);
            boolean z2 = false;
            if (nVar.Mv() != null && nVar.Mv().getAuthor() != null && (userId = nVar.Mv().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.eHH.A(i, z2);
            this.eHH.notifyDataSetChanged();
            a(nVar.aNd(), nVar.avw(), nVar.nz(), i, z);
            if (i4 > 0) {
                this.Ib.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void pk(int i) {
        if (this.eIc != null) {
            if (this.eIc.size() <= i) {
                this.eIc.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.eIc.iterator();
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

    public boolean aRX() {
        return this.eHH.bJO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eHA) {
            this.esk = postData;
            if (!StringUtils.isNull(postData.bmA())) {
                this.eHS.setVisibility(0);
                this.eHS.c(postData.bmA(), 10, true);
            } else {
                this.eHS.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.h bmC = postData.bmC();
            if (bmC != null && bmC.fLN) {
                this.eHT.setVisibility(0);
            } else {
                this.eHT.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.eHG.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.eHG.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.eHQ.setText((CharSequence) null);
            this.anw.setText((CharSequence) null);
            this.eCj.setVisibility(8);
            if (!this.eHA) {
                b(postData.getAuthor());
                if (z) {
                    this.eCj.setVisibility(0);
                    com.baidu.tbadk.core.util.as.i(this.eCj, w.e.cp_link_tip_a);
                }
            }
            this.etw.setText(com.baidu.tbadk.core.util.aw.q(postData.getTime()));
            if (this.esY) {
                int i2 = w.g.img_default_100;
            } else {
                int i3 = w.g.icon_click;
            }
            this.eHQ.setText(String.format(this.eHI.getPageContext().getString(w.l.is_floor), Integer.valueOf(postData.bmu())));
            postData.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.eHR, postData.azb());
            if (StringUtils.isNull(postData.bmA()) && !a && postData.Ic() != null) {
                this.bCj.setVisibility(0);
                this.bCj.setTag(postData.Ic());
                return;
            }
            this.bCj.setVisibility(8);
        }
    }

    private void b(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aK(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.y.gI(name_show) > 14) {
                name_show = String.valueOf(com.baidu.tbadk.util.y.d(name_show, 0, 14)) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.anw.setText(ae(metaData.getSealPrefix(), name_show));
            } else {
                this.anw.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.eHO != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.eHO.setVisibility(8);
                } else {
                    this.eHO.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.PQ = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.eHO.setTag(aVar);
                }
            }
            if (metaData.isGod()) {
                this.eCt.setVisibility(0);
                this.eHN.setVisibility(8);
                this.eCt.setUserId(metaData.getUserId());
                this.eCt.setUserName(metaData.getUserName());
                this.eCt.c(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.as.i(this.anw, w.e.cp_cont_r);
            } else {
                this.eCt.setVisibility(8);
                this.eHN.setVisibility(0);
                this.eHN.setUserId(metaData.getUserId());
                this.eHN.setUserName(metaData.getUserName());
                this.eHN.setDefaultResource(w.g.transparent_bg);
                this.eHN.setDefaultErrorResource(w.g.icon_default_avatar100);
                this.eHN.c(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.as.i(this.anw, w.e.cp_cont_c);
            }
            this.eHM.setTag(w.h.tag_user_id, metaData.getUserId());
            this.eHM.setTag(w.h.tag_user_name, metaData.getUserName());
            this.eHM.setTag(w.h.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.HU() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.HU().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.Ib());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.ce(true);
                        textView.setMovementMethod(com.baidu.tieba.view.g.bqB());
                        continue;
                    case 17:
                        String str = next.If().mGifInfo.mSharpText;
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
        if (!tbRichTextData.Il()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.Ib() == null || tbRichTextData.Ib().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.Ib());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eHI.getPageContext().getString(w.l.refresh_view_title_text), this.Qy));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.eHI.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.eHJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, w.g.pic_emotion07, com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds300), com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds480), com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds360)), dVar, a);
        }
        this.eHJ.setVisibility(0);
        this.Ib.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.duY.DE();
        com.baidu.tbadk.core.util.as.k(this.mNoDataView, w.e.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.eHI.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void ge(int i) {
        a(NoDataViewFactory.d.B(i, w.l.refresh_view_title_text));
        if (this.eHz != null) {
            this.eHz.bb(this.epN);
        }
        this.eIe.setVisibility(8);
    }

    public void pb(String str) {
        a(NoDataViewFactory.d.ad(str, this.eHI.getPageContext().getString(w.l.refresh_view_title_text)));
        if (this.eHz != null) {
            this.eHz.bb(this.epN);
        }
        this.eIe.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Ib.setVisibility(0);
            this.eIe.setVisibility(0);
            this.epN.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.Qy = onClickListener;
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
            if (this.eGs != null && this.eGs.Mv() != null && this.eGs.Mv().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.eGs.Mv().getAuthor().getUserId();
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
                    int i2 = postData.bmu() != 1 ? 0 : 1;
                    if (gf.k(postData)) {
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
                        if (this.eGs.Mv() != null) {
                            sparseArray.put(w.h.tag_user_mute_thread_id, this.eGs.Mv().getId());
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
            if (postData.bmu() != 1) {
            }
            if (gf.k(postData)) {
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

    public void jD(boolean z) {
        if (this.euZ != null && this.euZ.aPr() != null) {
            if (z) {
                this.euZ.aPr().setText(w.l.remove_mark);
            } else {
                this.euZ.aPr().setText(w.l.mark);
            }
            this.euZ.refreshUI();
        }
    }

    public View aRY() {
        return this.eHY;
    }

    public void onChangeSkinType(int i) {
        this.eHI.getLayoutMode().ah(i == 1);
        this.eHI.getLayoutMode().t(this.epN);
        this.eHI.getLayoutMode().t(this.eHG);
        this.mNavigationBar.onChangeSkinType(this.eHI.getPageContext(), i);
        if (this.eHL != null) {
            com.baidu.tbadk.core.util.as.i(this.eHL, w.e.goto_see_subject_color);
        }
        com.baidu.tbadk.core.util.as.i(this.eHK, w.e.cp_cont_d);
        this.bYU.onChangeSkinType(this.eHI.getPageContext(), i);
        this.eHI.getLayoutMode().t(this.eHY);
        com.baidu.tbadk.core.util.as.i(this.eHR, w.e.cp_cont_b);
        this.eHR.setLinkTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_link_tip_c));
        if (this.duY != null && this.duY.CG() != null) {
            this.duY.CG().onChangeSkinType(i);
        }
        this.eHV.dl(i);
        this.bCj.bef();
        com.baidu.tbadk.core.util.as.i(this.eIe, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.as.j(this.eIe, w.g.pb_ecomm_comment_bg);
        com.baidu.tbadk.core.util.as.i(this.eCj, w.e.cp_link_tip_a);
        com.baidu.tbadk.core.util.as.i(this.anw, w.e.cp_cont_c);
        this.eIe.setAlpha(0.95f);
        if (this.eHH != null) {
            this.eHH.notifyDataSetChanged();
        }
    }

    public void aRZ() {
        this.mProgress.setVisibility(0);
    }

    public void aSa() {
        this.Ib.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eHV.wE();
    }

    public void acA() {
        this.Ib.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eHV.acA();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cBe = onLongClickListener;
        this.eHG.setOnLongClickListener(this.cBe);
    }

    public View aSb() {
        return this.eHG;
    }

    public TextView aSc() {
        return this.eIe;
    }

    public void pc(String str) {
        int pd = this.eHH.pd(str);
        if (pd > -1) {
            this.eHH.pl(pd);
            if (pd > 2) {
                this.Ib.setSelection(pd - 2);
            } else {
                this.Ib.setSelection(pd);
            }
            this.Ib.invalidate();
        }
    }

    public View aSd() {
        return this.eHL;
    }

    public View aSe() {
        return this.eHS;
    }

    public MorePopupWindow aSf() {
        return this.eHW;
    }

    public void Qx() {
        if (this.bjx == null) {
            this.bjx = new com.baidu.tbadk.core.view.a(this.eHI.getPageContext());
        }
        this.bjx.aI(true);
    }

    public void Qy() {
        if (this.bjx != null) {
            this.bjx.aI(false);
        }
    }

    public TextView aSg() {
        return this.eHR;
    }

    public void setOnLinkImageClickListener(TbRichTextView.f fVar) {
        this.eHp = fVar;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.eHq = eVar;
    }

    public eu aSh() {
        return this.euZ;
    }

    public void afM() {
    }

    public void afN() {
    }

    public void onActivityDestroy() {
    }

    public void aSi() {
        if (this.eHI.Yp()) {
        }
    }

    public View aSj() {
        return this.eHM;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str, w.g.pic_smalldot_title));
            return com.baidu.tieba.card.at.a((Context) this.eHI.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
