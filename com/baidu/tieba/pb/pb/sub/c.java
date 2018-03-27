package com.baidu.tieba.pb.pb.sub;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.j;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.al;
import com.baidu.tieba.pb.pb.main.aq;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class c {
    private static final int fZT = TbadkCoreApplication.getInst().getListItemRule().FR();
    private BdListView auZ;
    private NoNetworkView dAO;
    private TextView dQm;
    private TextView dQn;
    private com.baidu.tbadk.core.view.b dgB;
    private View duX;
    private RelativeLayout fFP;
    private x fLp;
    private k fYy;
    private b fZN;
    private View fZU;
    private d fZV;
    private NewSubPbActivity fZW;
    private RelativeLayout fZX;
    private SubPbModel fZz;
    private View gab;
    private ThreadSkinView gah;
    private e gai;
    private View gal;
    private ArrayList<PostData> gap;
    private String gaq;
    private RelativeLayout gar;
    private ImageView gas;
    private ImageView gat;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private h mNoDataView = null;
    private TbRichTextView.h fZE = null;
    private View.OnClickListener aIb = null;
    private TbRichTextView.i fZD = null;
    private NavigationBar mNavigationBar = null;
    private View bgB = null;
    private TextView fZY = null;
    private LinearLayout fZZ = null;
    private HeadImageView gaa = null;
    private ClickableHeaderImageView fUp = null;
    private TextView beW = null;
    private ImageView gac = null;
    private TextView fUh = null;
    private TextView gad = null;
    private TextView fJp = null;
    private EllipsizeRichTextView gae = null;
    private TbImageView gaf = null;
    private PlayVoiceBntNew cWT = null;
    private TextView gag = null;
    private MorePopupWindow gaj = null;
    private al gak = null;
    private com.baidu.tbadk.core.dialog.b fUY = null;
    private Dialog fUN = null;
    private com.baidu.tbadk.core.dialog.a fUP = null;
    private boolean fIS = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener bpq = null;
    private NewSubPbActivity.a gam = null;
    private NewSubPbActivity.a gan = null;
    private com.baidu.tbadk.editortools.pb.h eTy = null;
    private String gao = null;
    private int bKM = 0;
    private PostData fIm = null;
    private int gau = 0;
    private int gav = 2;
    private int gaw = 0;
    private boolean bsJ = true;
    private View.OnClickListener fIX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.akM() || !com.baidu.tieba.c.a.b(c.this.fZW.getBaseContext(), c.this.fZW.getThreadId(), c.this.fZW.getPostId(), c.this.fZW.baG())) {
                        if (booleanValue2) {
                            sparseArray.put(d.g.tag_from, 1);
                            c.this.fZW.c(sparseArray);
                            return;
                        }
                        c.this.cy(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    c.this.fZW.c(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bLJ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.2
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            c.this.gi(false);
            c.this.bQ(view);
            c.this.gi(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean d(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean e(View view, MotionEvent motionEvent) {
            return true;
        }
    });
    protected AdapterView.OnItemClickListener gax = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.9
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ay.ba(c.this.fZW.getPageContext().getPageActivity())) {
                if (c.this.fZN != null) {
                    c.this.fZN.ayk();
                }
                c.this.bgv();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) v.f(c.this.gap, i);
                    if (postData == null) {
                        c.this.gaq = null;
                    } else {
                        c.this.gaq = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.g.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                        if (str != null) {
                            c.this.eTy.setReplyId(str2);
                            c.this.eTy.gG(str);
                        }
                    }
                    c.this.bgw();
                    return;
                }
                c.this.bgx();
                c.this.fZz.bgS();
            }
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.fFP = null;
        this.fZU = null;
        this.auZ = null;
        this.fZV = null;
        this.fZW = null;
        this.dAO = null;
        this.fZX = null;
        this.dQn = null;
        this.gab = null;
        this.gai = null;
        this.gal = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dQm = null;
        this.gar = null;
        this.gas = null;
        this.gat = null;
        this.fZW = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.fFP = (RelativeLayout) LayoutInflater.from(this.fZW.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.fZU = LayoutInflater.from(this.fZW.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.dQn = (TextView) this.fFP.findViewById(d.g.no_reply_list_view);
        this.gar = (RelativeLayout) this.fFP.findViewById(d.g.subpb_editor_tool_comment);
        this.dQm = (TextView) this.fFP.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dQm.setOnClickListener(this.mCommonClickListener);
        this.gas = (ImageView) this.fFP.findViewById(d.g.subpb_editor_tool_more_img);
        this.gat = (ImageView) this.fFP.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.gat.setOnClickListener(this.mCommonClickListener);
        this.gas.setOnClickListener(this.mCommonClickListener);
        this.dAO = (NoNetworkView) this.fFP.findViewById(d.g.view_no_network);
        ays();
        bgu();
        this.fZX = (RelativeLayout) this.fFP.findViewById(d.g.sub_pb_body_layout);
        this.auZ = (BdListView) this.fFP.findViewById(d.g.new_sub_pb_list);
        this.gah = (ThreadSkinView) LayoutInflater.from(this.fZW.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.auZ.addHeaderView(this.gah);
        this.auZ.addHeaderView(this.fZU);
        this.duX = BdListViewHelper.a(this.fZW.getActivity(), this.auZ, BdListViewHelper.HeadType.DEFAULT);
        this.fZV = new d(this.fZW.getPageContext().getPageActivity());
        this.fZV.H(this.fIX);
        this.fZV.setIsFromCDN(this.mIsFromCDN);
        this.fZV.lk(true);
        this.auZ.setAdapter((ListAdapter) this.fZV);
        this.gai = new e(this.fZW.getPageContext());
        this.gal = this.gai.getView();
        this.auZ.setNextPage(this.gai);
        this.gai.setOnClickListener(this.mCommonClickListener);
        this.auZ.setOnItemClickListener(this.gax);
        this.auZ.setOnTouchListener(this.bLJ);
        this.mProgress = (ProgressBar) this.fFP.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fZU != null) {
            this.fZU.setVisibility(4);
        }
        if (this.fZX != null) {
            this.fZX.setVisibility(4);
        }
        this.gab = com.baidu.tbadk.ala.b.vL().u(this.fZW.getActivity(), 4);
        if (this.gab != null) {
            this.gab.setVisibility(8);
            this.fZZ.addView(this.gab, 3);
        }
    }

    public ListView getListView() {
        return this.auZ;
    }

    public void bgu() {
        this.fZZ = (LinearLayout) this.fZU.findViewById(d.g.subpb_head_user_info_root);
        this.fZZ.setOnClickListener(this.mCommonClickListener);
        this.gaa = (HeadImageView) this.fZU.findViewById(d.g.photo);
        this.gaa.setRadius(l.t(this.fZW.getActivity(), d.e.ds30));
        this.gaa.setClickable(false);
        this.fUp = (ClickableHeaderImageView) this.fZU.findViewById(d.g.god_user_photo);
        this.fUp.setGodIconMargin(0);
        this.fUp.setGodIconWidth(d.e.ds24);
        this.fUp.setRadius(l.t(this.fZW.getActivity(), d.e.ds30));
        this.fUp.setClickable(false);
        this.beW = (TextView) this.fZU.findViewById(d.g.user_name);
        this.gac = (ImageView) this.fZU.findViewById(d.g.user_rank);
        this.gac.setVisibility(8);
        this.fUh = (TextView) this.fZU.findViewById(d.g.floor_owner);
        this.fZY = (TextView) this.fZU.findViewById(d.g.see_subject);
        this.fZY.setOnClickListener(this.mCommonClickListener);
        this.gad = (TextView) this.fZU.findViewById(d.g.floor);
        this.fJp = (TextView) this.fZU.findViewById(d.g.time);
        this.gae = (EllipsizeRichTextView) this.fZU.findViewById(d.g.content_text);
        this.gae.setOnClickListener(this.mCommonClickListener);
        aj.r(this.gae, d.C0141d.cp_cont_b);
        this.gae.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
        this.gae.setLineSpacing(0.0f, 1.25f);
        this.gaf = (TbImageView) this.fZU.findViewById(d.g.sub_pb_image);
        this.gaf.setOnClickListener(this.mCommonClickListener);
        this.gag = (TextView) this.fZU.findViewById(d.g.advert);
        this.cWT = (PlayVoiceBntNew) this.fZU.findViewById(d.g.voice_btn);
        this.fZU.setOnTouchListener(this.bLJ);
        this.fZU.setOnClickListener(this.mCommonClickListener);
    }

    public void gk(boolean z) {
        if (this.duX != null && this.duX.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.duX.getLayoutParams();
            if (z) {
                ayw();
                layoutParams.height = l.t(this.fZW.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.t(this.fZW.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.duX.setLayoutParams(layoutParams);
        }
    }

    private void ayw() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View ayx() {
        return this.duX;
    }

    public void ays() {
        int t = l.t(this.fZW.getPageContext().getPageActivity(), d.e.ds88);
        int t2 = l.t(this.fZW.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.fFP.findViewById(d.g.view_navigation_bar);
        this.bgB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bgB.getLayoutParams();
            layoutParams.height = t;
            layoutParams.width = t;
            layoutParams.leftMargin = t2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.bgB != null && (this.bgB.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bgB.getLayoutParams();
            layoutParams2.width = t;
            layoutParams2.height = t;
            this.bgB.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar avk() {
        return this.mNavigationBar;
    }

    public void cy(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fUN == null) {
            this.fUN = new Dialog(this.fZW.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fUN.setCanceledOnTouchOutside(true);
            this.fUN.setCancelable(true);
            View inflate = LayoutInflater.from(this.fZW.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.fZW.getLayoutMode().aM(inflate);
            this.fUN.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fUN.getWindow().getAttributes();
            attributes.width = (int) (l.ao(this.fZW.getPageContext().getPageActivity()) * 0.9d);
            this.fUN.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fUN.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fUN.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fUN.findViewById(d.g.disable_reply_btn);
        if ("".equals(sparseArray.get(d.g.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(d.g.tag_del_post_id, sparseArray.get(d.g.tag_del_post_id));
            sparseArray2.put(d.g.tag_del_post_type, sparseArray.get(d.g.tag_del_post_type));
            sparseArray2.put(d.g.tag_del_post_is_self, sparseArray.get(d.g.tag_del_post_is_self));
            sparseArray2.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.fUN != null && (c.this.fUN instanceof Dialog)) {
                        g.b(c.this.fUN, c.this.fZW.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        c.this.a(((Integer) sparseArray3.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray3.get(d.g.tag_del_post_id), ((Integer) sparseArray3.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.g.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(d.g.tag_forbid_user_name, sparseArray.get(d.g.tag_forbid_user_name));
            sparseArray3.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            sparseArray3.put(d.g.tag_forbid_user_post_id, sparseArray.get(d.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.fUN != null && (c.this.fUN instanceof Dialog)) {
                        g.b(c.this.fUN, c.this.fZW.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.gam != null) {
                        c.this.gam.ak(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id)});
                    }
                }
            });
        }
        if (!((sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(d.j.un_mute);
            } else {
                textView3.setText(d.j.mute);
            }
            sparseArray4.put(d.g.tag_is_mem, sparseArray.get(d.g.tag_is_mem));
            sparseArray4.put(d.g.tag_user_mute_mute_userid, sparseArray.get(d.g.tag_user_mute_mute_userid));
            sparseArray4.put(d.g.tag_user_mute_mute_username, sparseArray.get(d.g.tag_user_mute_mute_username));
            sparseArray4.put(d.g.tag_user_mute_post_id, sparseArray.get(d.g.tag_user_mute_post_id));
            sparseArray4.put(d.g.tag_user_mute_thread_id, sparseArray.get(d.g.tag_user_mute_thread_id));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.fUN != null && (c.this.fUN instanceof Dialog)) {
                        g.b(c.this.fUN, c.this.fZW.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.fZW.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.fUN, this.fZW.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        final SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_del_post_id, str);
        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = d.j.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = d.j.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = d.j.report_thread_confirm;
            } else {
                i3 = d.j.del_thread_confirm;
            }
        }
        this.fUP = new com.baidu.tbadk.core.dialog.a(this.fZW.getPageContext().getPageActivity());
        this.fUP.fb(i3);
        this.fUP.aE(sparseArray);
        this.fUP.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.gan != null) {
                    c.this.gan.ak(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fUP.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fUP.aZ(true);
        this.fUP.b(this.fZW.getPageContext());
        this.fUP.AV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi(final boolean z) {
        if (this.auZ != null) {
            if (!z) {
                this.auZ.setEnabled(z);
            } else {
                this.auZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.c.8
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.auZ.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0097b interfaceC0097b, boolean z) {
        String string;
        if (this.fUY != null) {
            this.fUY.dismiss();
            this.fUY = null;
        }
        if (z) {
            string = this.fZW.getResources().getString(d.j.remove_mark);
        } else {
            string = this.fZW.getResources().getString(d.j.mark);
        }
        this.fUY = new com.baidu.tbadk.core.dialog.b(this.fZW.getPageContext().getPageActivity());
        this.fUY.fe(d.j.operation);
        this.fUY.a(new String[]{this.fZW.getResources().getString(d.j.copy), string}, interfaceC0097b);
        this.fUY.d(this.fZW.getPageContext());
        this.fUY.AY();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.gam = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.gan = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fZW.showToast(this.fZW.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.fZW.showToast(str);
        }
    }

    public void bQ(View view) {
        if (this.duX != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.duX.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.auZ != null) {
                    this.auZ.removeHeaderView(this.duX);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.duX.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.t(this.fZW.getActivity(), d.e.ds98)));
            } else if (this.auZ != null) {
                this.auZ.addHeaderView(this.duX, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(com.baidu.tbadk.editortools.pb.h hVar) {
        if (hVar != null && hVar.Lc() != null) {
            this.eTy = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.fFP.addView(hVar.Lc(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.fZN = bVar;
    }

    public void bgv() {
        if (this.auZ != null) {
            this.gaw = this.auZ.getLastVisiblePosition();
        }
    }

    public void bgw() {
        if (this.fZz != null) {
            if ((!bgz() && this.gal != null && this.gal.isShown()) || v.E(this.gap)) {
                this.fZz.ln(false);
            } else {
                this.fZz.ln(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fZz = subPbModel;
    }

    public void bgx() {
        a(this.fZW);
        this.auZ.setNextPage(this.gai);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.mN(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bgz() && this.gal != null && this.gal.isShown()) {
                i = (this.gaw - this.gav) - 1;
            } else {
                i = this.gaw - this.gav;
            }
            int D = v.D(this.gap);
            if (i > D) {
                i = D;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(v.b(this.gap, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.fZV.setDatas(arrayList);
            this.fZV.notifyDataSetChanged();
            this.auZ.smoothScrollToPosition(this.gaw + 2);
            this.auZ.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.auZ.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.auZ.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.fFP;
    }

    public void bfv() {
        if (this.gaj != null) {
            g.a(this.gaj, this.fZW.getPageContext().getPageActivity());
        }
        if (this.fUY != null) {
            this.fUY.dismiss();
        }
        if (this.fUP != null) {
            this.fUP.dismiss();
        }
        if (this.fUN != null) {
            g.b(this.fUN, this.fZW.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fLp != null) {
            this.fLp.dismiss();
        }
    }

    public void bgy() {
        this.auZ.setNextPage(this.gai);
        this.gai.Eg();
    }

    public void jU(boolean z) {
        this.fIS = z;
    }

    public void setIsFromPb(boolean z) {
        this.bsJ = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(k kVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (kVar != null) {
            if (this.bsJ && this.fZU != null) {
                this.fZV.ll(true);
                this.fZU.setVisibility(8);
                this.auZ.removeHeaderView(this.fZU);
                this.gav = 1;
            }
            this.fYy = kVar;
            this.fZV.T(this.fYy.WE());
            if (this.fZU != null) {
                this.fZU.setVisibility(0);
            }
            if (this.fZX != null) {
                this.fZX.setVisibility(0);
            }
            if (kVar.bbd() != null) {
                this.gao = kVar.bbd().getId();
                this.bKM = kVar.bbd().bwY();
                if (this.bKM > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fZW.getResources().getString(d.j.subpb_floor_reply_count), am.H(kVar.getTotalCount())));
                    this.dQm.setText(d.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.fZW.bgt()) {
                    str = "PB";
                }
                if (kVar.bbd().zJ() != null) {
                    this.gah.a(this.fZW.getPageContext(), kVar.bbd().zJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", kVar.bbk().getId(), kVar.bbk().getName(), kVar.WE().getId(), str));
                } else {
                    this.gah.a(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.gai.Eg();
                this.fZV.setHasMoreData(true);
            } else {
                this.gai.Eh();
                this.fZV.setHasMoreData(false);
            }
            this.gap = kVar.bbh();
            if (v.E(this.gap)) {
                this.auZ.setNextPage(null);
                if (this.bsJ) {
                    this.dQn.setVisibility(0);
                }
            } else {
                this.auZ.setNextPage(this.gai);
                if (this.bsJ) {
                    this.dQn.setVisibility(8);
                }
            }
            if (this.gap == null || this.gap.size() <= fZT) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.gap.size() - fZT;
                tl(size);
                int firstVisiblePosition = this.auZ.getFirstVisiblePosition() - size;
                View childAt = this.auZ.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.fZV.setDatas(this.gap);
            boolean z2 = false;
            if (kVar.WE() != null && kVar.WE().zn() != null && (userId = kVar.WE().zn().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.fZV.P(i, z2);
            this.fZV.notifyDataSetChanged();
            a(kVar.bbd(), kVar.aLq(), kVar.vX(), i, z);
            if (i4 > 0) {
                this.auZ.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void tl(int i) {
        if (this.gap != null) {
            if (this.gap.size() <= i) {
                this.gap.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.gap.iterator();
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

    public boolean bgz() {
        return this.fZV.dfO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.bsJ) {
            this.fIm = postData;
            if (!StringUtils.isNull(postData.bxg())) {
                this.gaf.setVisibility(0);
                this.gaf.startLoad(postData.bxg(), 10, true);
            } else {
                this.gaf.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.h bxi = postData.bxi();
            if (bxi != null && bxi.haG) {
                this.gag.setVisibility(0);
            } else {
                this.gag.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fZU.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fZU.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.gad.setText((CharSequence) null);
            this.beW.setText((CharSequence) null);
            this.fUh.setVisibility(8);
            if (!this.bsJ) {
                c(postData.zn());
                if (z) {
                    this.fUh.setVisibility(0);
                    aj.r(this.fUh, d.C0141d.cp_link_tip_a);
                }
            }
            this.fJp.setText(am.z(postData.getTime()));
            this.gad.setText(String.format(this.fZW.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.bwY())));
            postData.zn().getUserTbVipInfoData();
            boolean a = a(this.gae, postData.bxb());
            if (StringUtils.isNull(postData.bxg()) && !a && postData.Rq() != null) {
                this.cWT.setVisibility(0);
                this.cWT.setTag(postData.Rq());
                return;
            }
            this.cWT.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.k.aX(metaData.getSealPrefix()) + 2 : 0) + w.hs(name_show) > 14) {
                name_show = w.j(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.beW.setText(af(metaData.getSealPrefix(), name_show));
            } else {
                this.beW.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.gab != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.gab.setVisibility(8);
                } else {
                    this.gab.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aGU = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.gab.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fUp.setVisibility(0);
                this.gaa.setVisibility(8);
                this.fUp.setUserId(metaData.getUserId());
                this.fUp.setUserName(metaData.getUserName());
                this.fUp.startLoad(metaData.getPortrait(), 28, false);
                aj.r(this.beW, d.C0141d.cp_cont_r);
            } else {
                this.fUp.setVisibility(8);
                this.gaa.setVisibility(0);
                this.gaa.setUserId(metaData.getUserId());
                this.gaa.setUserName(metaData.getUserName());
                this.gaa.setDefaultResource(d.f.transparent_bg);
                this.gaa.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.gaa.startLoad(metaData.getPortrait(), 28, false);
                aj.r(this.beW, d.C0141d.cp_cont_c);
            }
            this.fZZ.setTag(d.g.tag_user_id, metaData.getUserId());
            this.fZZ.setTag(d.g.tag_user_name, metaData.getUserName());
            this.fZZ.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Ri() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Ri().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.Rp());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cN(true);
                        textView.setMovementMethod(com.baidu.tieba.view.e.bEQ());
                        continue;
                    case 17:
                        String str = next.Rt().mGifInfo.mSharpText;
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
        if (!tbRichTextData.Ry()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.Rp() == null || tbRichTextData.Rp().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.Rp());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fZW.getPageContext().getString(d.j.refresh_view_title_text), this.aIb));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fZW.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fZX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.t(pageActivity, d.e.ds250), l.t(pageActivity, d.e.ds480), l.t(pageActivity, d.e.ds360)), dVar, a);
        }
        this.fZX.setVisibility(0);
        this.auZ.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.eTy.LX();
        aj.t(this.mNoDataView, d.C0141d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fZW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void lc(int i) {
        b(NoDataViewFactory.d.aC(i, d.j.refresh_view_title_text));
        if (this.fZN != null) {
            this.fZN.cB(this.fFP);
        }
        this.gar.setVisibility(8);
    }

    public void lS(String str) {
        b(NoDataViewFactory.d.ae(str, this.fZW.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.fZN != null) {
            this.fZN.cB(this.fFP);
        }
        this.gar.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.auZ.setVisibility(0);
            this.gar.setVisibility(0);
            this.fFP.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.aIb = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0202  */
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
                String userId2 = postData.zn().getUserId();
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
            if (this.fYy != null && this.fYy.WE() != null && this.fYy.WE().zn() != null && postData.zn() != null) {
                String userId3 = this.fYy.WE().zn().getUserId();
                String userId4 = postData.zn().getUserId();
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
                    userId = postData.zn().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bwY() != 1 ? 0 : 1;
                    if (aq.k(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.zn().getUserName());
                        sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(d.g.tag_forbid_user_name, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_del_post_is_self, true);
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(d.g.tag_del_post_is_self, false);
                        sparseArray.put(d.g.tag_del_post_type, 0);
                        sparseArray.put(d.g.tag_del_post_id, "");
                    }
                    sparseArray.put(d.g.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
                    if (!z6) {
                        sparseArray.put(d.g.tag_should_manage_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.zn().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.zn() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.zn().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.zn().getUserName());
                        }
                        if (this.fYy.WE() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fYy.WE().getId());
                        }
                        sparseArray.put(d.g.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(d.g.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(d.g.tag_should_delete_visible, true);
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(d.g.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(d.g.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = postData.zn().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bwY() != 1) {
            }
            if (aq.k(postData)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(d.g.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(d.g.tag_forbid_user_post_id, postData.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void lj(boolean z) {
        if (this.fLp != null && this.fLp.bdY() != null) {
            if (z) {
                this.fLp.bdY().setText(d.j.remove_mark);
            } else {
                this.fLp.bdY().setText(d.j.mark);
            }
            this.fLp.refreshUI();
        }
    }

    public View bgA() {
        return this.gal;
    }

    public void onChangeSkinType(int i) {
        this.fZW.getLayoutMode().aQ(i == 1);
        this.fZW.getLayoutMode().aM(this.fFP);
        this.fZW.getLayoutMode().aM(this.fZU);
        this.mNavigationBar.onChangeSkinType(this.fZW.getPageContext(), i);
        if (this.fZY != null) {
            aj.r(this.fZY, d.C0141d.goto_see_subject_color);
        }
        aj.r(this.dQn, d.C0141d.cp_cont_d);
        this.dAO.onChangeSkinType(this.fZW.getPageContext(), i);
        this.fZW.getLayoutMode().aM(this.gal);
        aj.r(this.gae, d.C0141d.cp_cont_b);
        this.gae.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
        if (this.eTy != null && this.eTy.Lc() != null) {
            this.eTy.Lc().onChangeSkinType(i);
        }
        this.gai.gx(i);
        this.cWT.aNR();
        aj.r(this.dQm, d.C0141d.cp_cont_e);
        aj.r(this.fUh, d.C0141d.cp_link_tip_a);
        aj.r(this.beW, d.C0141d.cp_cont_c);
        this.dQm.setAlpha(0.95f);
        if (this.fZV != null) {
            this.fZV.notifyDataSetChanged();
        }
    }

    public void bgB() {
        this.mProgress.setVisibility(0);
    }

    public void bgC() {
        this.auZ.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.gai.Eh();
    }

    public void asv() {
        this.auZ.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.gai.asv();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bpq = onLongClickListener;
        this.fZU.setOnLongClickListener(this.bpq);
    }

    public View bgD() {
        return this.fZU;
    }

    public TextView ayy() {
        return this.dQm;
    }

    public ImageView bgE() {
        return this.gas;
    }

    public ImageView bgF() {
        return this.gat;
    }

    public void qI(String str) {
        int qJ = this.fZV.qJ(str);
        if (qJ > -1) {
            this.fZV.tm(qJ);
            if (qJ > 2) {
                this.auZ.setSelection(qJ - 2);
            } else {
                this.auZ.setSelection(qJ);
            }
            this.auZ.invalidate();
        }
    }

    public View bgG() {
        return this.fZY;
    }

    public View bgH() {
        return this.gaf;
    }

    public MorePopupWindow bgI() {
        return this.gaj;
    }

    public void showLoadingDialog() {
        if (this.dgB == null) {
            this.dgB = new com.baidu.tbadk.core.view.b(this.fZW.getPageContext());
        }
        this.dgB.bq(true);
    }

    public void agg() {
        if (this.dgB != null) {
            this.dgB.bq(false);
        }
    }

    public TextView bgJ() {
        return this.gae;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.fZD = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fZE = hVar;
    }

    public x bgK() {
        return this.fLp;
    }

    public void axD() {
    }

    public void axE() {
    }

    public void onActivityDestroy() {
    }

    public void bgL() {
        if (this.fZW.isPaused()) {
        }
    }

    public View bgM() {
        return this.fZZ;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new j.a(str, d.f.pic_smalldot_title));
            return j.a((Context) this.fZW.getActivity(), str2, (ArrayList<j.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
