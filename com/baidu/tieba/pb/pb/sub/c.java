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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.al;
import com.baidu.tieba.pb.pb.main.aq;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class c {
    private static final int fgI = TbadkCoreApplication.getInst().getListItemRule().yc();
    private BdListView Hj;
    private NoNetworkView cDJ;
    private TextView cVX;
    private TextView cVY;
    private com.baidu.tbadk.core.view.a cjW;
    private View cyH;
    private RelativeLayout eMI;
    private y eSw;
    private m ffn;
    private b fgC;
    private View fgJ;
    private d fgK;
    private NewSubPbActivity fgL;
    private RelativeLayout fgM;
    private View fgQ;
    private ThreadSkinView fgW;
    private e fgX;
    private SubPbModel fgo;
    private View fha;
    private ArrayList<PostData> fhe;
    private String fhf;
    private RelativeLayout fhg;
    private ImageView fhh;
    private ImageView fhi;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private f mNoDataView = null;
    private TbRichTextView.f fgt = null;
    private View.OnClickListener So = null;
    private TbRichTextView.g fgs = null;
    private NavigationBar mNavigationBar = null;
    private View aqy = null;
    private TextView fgN = null;
    private LinearLayout fgO = null;
    private HeadImageView fgP = null;
    private ClickableHeaderImageView fbe = null;
    private TextView aoU = null;
    private ImageView fgR = null;
    private TextView faU = null;
    private TextView fgS = null;
    private TextView eQj = null;
    private EllipsizeRichTextView fgT = null;
    private TbImageView fgU = null;
    private PlayVoiceBntNew caI = null;
    private TextView fgV = null;
    private MorePopupWindow fgY = null;
    private al fgZ = null;
    private com.baidu.tbadk.core.dialog.b fbO = null;
    private Dialog fbC = null;
    private com.baidu.tbadk.core.dialog.a fbE = null;
    private boolean ePM = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener ayH = null;
    private NewSubPbActivity.a fhb = null;
    private NewSubPbActivity.a fhc = null;
    private h dZX = null;
    private String fhd = null;
    private int aUJ = 0;
    private PostData ePg = null;
    private int fhj = 0;
    private int fhk = 2;
    private int fhl = 0;
    private boolean aCl = true;
    private View.OnClickListener ePR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.abo() || !com.baidu.tieba.c.a.a(c.this.fgL.getBaseContext(), c.this.fgL.getThreadId(), c.this.fgL.getPostId(), c.this.fgL.aRs())) {
                        if (booleanValue2) {
                            sparseArray.put(d.g.tag_from, 1);
                            c.this.fgL.c(sparseArray);
                            return;
                        }
                        c.this.bi(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    c.this.fgL.c(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aVF = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.2
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            c.this.fu(false);
            c.this.aB(view);
            c.this.fu(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return true;
        }
    });
    protected AdapterView.OnItemClickListener fhm = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.9
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ax.aV(c.this.fgL.getPageContext().getPageActivity())) {
                if (c.this.fgC != null) {
                    c.this.fgC.aoU();
                }
                c.this.aXo();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) v.c(c.this.fhe, i);
                    if (postData == null) {
                        c.this.fhf = null;
                    } else {
                        c.this.fhf = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.g.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                        if (str != null) {
                            c.this.dZX.setReplyId(str2);
                            c.this.dZX.gh(str);
                        }
                    }
                    c.this.aXp();
                    return;
                }
                c.this.aXq();
                c.this.fgo.aXL();
            }
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.eMI = null;
        this.fgJ = null;
        this.Hj = null;
        this.fgK = null;
        this.fgL = null;
        this.cDJ = null;
        this.fgM = null;
        this.cVY = null;
        this.fgQ = null;
        this.fgX = null;
        this.fha = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.cVX = null;
        this.fhg = null;
        this.fhh = null;
        this.fhi = null;
        this.fgL = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.eMI = (RelativeLayout) LayoutInflater.from(this.fgL.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.fgJ = LayoutInflater.from(this.fgL.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.cVY = (TextView) this.eMI.findViewById(d.g.no_reply_list_view);
        this.fhg = (RelativeLayout) this.eMI.findViewById(d.g.subpb_editor_tool_comment);
        this.cVX = (TextView) this.eMI.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.cVX.setOnClickListener(this.mCommonClickListener);
        this.fhh = (ImageView) this.eMI.findViewById(d.g.subpb_editor_tool_more_img);
        this.fhi = (ImageView) this.eMI.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.fhi.setOnClickListener(this.mCommonClickListener);
        this.fhh.setOnClickListener(this.mCommonClickListener);
        this.cDJ = (NoNetworkView) this.eMI.findViewById(d.g.view_no_network);
        apc();
        aXn();
        this.fgM = (RelativeLayout) this.eMI.findViewById(d.g.sub_pb_body_layout);
        this.Hj = (BdListView) this.eMI.findViewById(d.g.new_sub_pb_list);
        this.fgW = (ThreadSkinView) LayoutInflater.from(this.fgL.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.Hj.addHeaderView(this.fgW);
        this.Hj.addHeaderView(this.fgJ);
        this.cyH = BdListViewHelper.a(this.fgL.getActivity(), this.Hj, BdListViewHelper.HeadType.DEFAULT);
        this.fgK = new d(this.fgL.getPageContext().getPageActivity());
        this.fgK.G(this.ePR);
        this.fgK.setIsFromCDN(this.mIsFromCDN);
        this.fgK.kn(true);
        this.Hj.setAdapter((ListAdapter) this.fgK);
        this.fgX = new e(this.fgL.getPageContext());
        this.fha = this.fgX.getView();
        this.Hj.setNextPage(this.fgX);
        this.fgX.setOnClickListener(this.mCommonClickListener);
        this.Hj.setOnItemClickListener(this.fhm);
        this.Hj.setOnTouchListener(this.aVF);
        this.mProgress = (ProgressBar) this.eMI.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fgJ != null) {
            this.fgJ.setVisibility(4);
        }
        if (this.fgM != null) {
            this.fgM.setVisibility(4);
        }
        this.fgQ = com.baidu.tbadk.ala.b.ny().g(this.fgL.getActivity(), 4);
        if (this.fgQ != null) {
            this.fgQ.setVisibility(8);
            this.fgO.addView(this.fgQ, 3);
        }
    }

    public ListView getListView() {
        return this.Hj;
    }

    public void aXn() {
        this.fgO = (LinearLayout) this.fgJ.findViewById(d.g.subpb_head_user_info_root);
        this.fgO.setOnClickListener(this.mCommonClickListener);
        this.fgP = (HeadImageView) this.fgJ.findViewById(d.g.photo);
        this.fgP.setRadius(l.f(this.fgL.getActivity(), d.e.ds30));
        this.fgP.setClickable(false);
        this.fbe = (ClickableHeaderImageView) this.fgJ.findViewById(d.g.god_user_photo);
        this.fbe.setGodIconMargin(0);
        this.fbe.setGodIconWidth(d.e.ds24);
        this.fbe.setRadius(l.f(this.fgL.getActivity(), d.e.ds30));
        this.fbe.setClickable(false);
        this.aoU = (TextView) this.fgJ.findViewById(d.g.user_name);
        this.fgR = (ImageView) this.fgJ.findViewById(d.g.user_rank);
        this.fgR.setVisibility(8);
        this.faU = (TextView) this.fgJ.findViewById(d.g.floor_owner);
        this.fgN = (TextView) this.fgJ.findViewById(d.g.see_subject);
        this.fgN.setOnClickListener(this.mCommonClickListener);
        this.fgS = (TextView) this.fgJ.findViewById(d.g.floor);
        this.eQj = (TextView) this.fgJ.findViewById(d.g.time);
        this.fgT = (EllipsizeRichTextView) this.fgJ.findViewById(d.g.content_text);
        this.fgT.setOnClickListener(this.mCommonClickListener);
        aj.i(this.fgT, d.C0082d.cp_cont_b);
        this.fgT.setLinkTextColor(aj.getColor(d.C0082d.cp_link_tip_c));
        this.fgT.setLineSpacing(0.0f, 1.25f);
        this.fgU = (TbImageView) this.fgJ.findViewById(d.g.sub_pb_image);
        this.fgU.setOnClickListener(this.mCommonClickListener);
        this.fgV = (TextView) this.fgJ.findViewById(d.g.advert);
        this.caI = (PlayVoiceBntNew) this.fgJ.findViewById(d.g.voice_btn);
        this.fgJ.setOnTouchListener(this.aVF);
        this.fgJ.setOnClickListener(this.mCommonClickListener);
    }

    public void fw(boolean z) {
        if (this.cyH != null && this.cyH.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cyH.getLayoutParams();
            if (z) {
                apg();
                layoutParams.height = l.f(this.fgL.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.f(this.fgL.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.cyH.setLayoutParams(layoutParams);
        }
    }

    private void apg() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View aph() {
        return this.cyH;
    }

    public void apc() {
        int f = l.f(this.fgL.getPageContext().getPageActivity(), d.e.ds88);
        int f2 = l.f(this.fgL.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.eMI.findViewById(d.g.view_navigation_bar);
        this.aqy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqy.getLayoutParams();
            layoutParams.height = f;
            layoutParams.width = f;
            layoutParams.leftMargin = f2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aqy != null && (this.aqy.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aqy.getLayoutParams();
            layoutParams2.width = f;
            layoutParams2.height = f;
            this.aqy.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar alu() {
        return this.mNavigationBar;
    }

    public void bi(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fbC == null) {
            this.fbC = new Dialog(this.fgL.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fbC.setCanceledOnTouchOutside(true);
            this.fbC.setCancelable(true);
            View inflate = LayoutInflater.from(this.fgL.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.fgL.getLayoutMode().t(inflate);
            this.fbC.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fbC.getWindow().getAttributes();
            attributes.width = (int) (l.ac(this.fgL.getPageContext().getPageActivity()) * 0.9d);
            this.fbC.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fbC.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fbC.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fbC.findViewById(d.g.disable_reply_btn);
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
                    if (c.this.fbC != null && (c.this.fbC instanceof Dialog)) {
                        g.b(c.this.fbC, c.this.fgL.getPageContext());
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
                    if (c.this.fbC != null && (c.this.fbC instanceof Dialog)) {
                        g.b(c.this.fbC, c.this.fgL.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.fhb != null) {
                        c.this.fhb.f(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id)});
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
                    if (c.this.fbC != null && (c.this.fbC instanceof Dialog)) {
                        g.b(c.this.fbC, c.this.fgL.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.fgL.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.fbC, this.fgL.getPageContext());
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
        this.fbE = new com.baidu.tbadk.core.dialog.a(this.fgL.getPageContext().getPageActivity());
        this.fbE.cd(i3);
        this.fbE.z(sparseArray);
        this.fbE.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.fhc != null) {
                    c.this.fhc.f(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fbE.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fbE.ao(true);
        this.fbE.b(this.fgL.getPageContext());
        this.fbE.tk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fu(final boolean z) {
        if (this.Hj != null) {
            if (!z) {
                this.Hj.setEnabled(z);
            } else {
                this.Hj.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.c.8
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.Hj.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0047b interfaceC0047b, boolean z) {
        String string;
        if (this.fbO != null) {
            this.fbO.dismiss();
            this.fbO = null;
        }
        if (z) {
            string = this.fgL.getResources().getString(d.j.remove_mark);
        } else {
            string = this.fgL.getResources().getString(d.j.mark);
        }
        this.fbO = new com.baidu.tbadk.core.dialog.b(this.fgL.getPageContext().getPageActivity());
        this.fbO.cg(d.j.operation);
        this.fbO.a(new String[]{this.fgL.getResources().getString(d.j.copy), string}, interfaceC0047b);
        this.fbO.d(this.fgL.getPageContext());
        this.fbO.to();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.fhb = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.fhc = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fgL.showToast(this.fgL.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.fgL.showToast(str);
        }
    }

    public void aB(View view) {
        if (this.cyH != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cyH.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Hj != null) {
                    this.Hj.removeHeaderView(this.cyH);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cyH.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(this.fgL.getActivity(), d.e.ds98)));
            } else if (this.Hj != null) {
                this.Hj.addHeaderView(this.cyH, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(h hVar) {
        if (hVar != null && hVar.Dd() != null) {
            this.dZX = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eMI.addView(hVar.Dd(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.fgC = bVar;
    }

    public void aXo() {
        if (this.Hj != null) {
            this.fhl = this.Hj.getLastVisiblePosition();
        }
    }

    public void aXp() {
        if (this.fgo != null) {
            if ((!aXs() && this.fha != null && this.fha.isShown()) || v.w(this.fhe)) {
                this.fgo.kq(false);
            } else {
                this.fgo.kq(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fgo = subPbModel;
    }

    public void aXq() {
        a(this.fgL);
        this.Hj.setNextPage(this.fgX);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.na(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aXs() && this.fha != null && this.fha.isShown()) {
                i = (this.fhl - this.fhk) - 1;
            } else {
                i = this.fhl - this.fhk;
            }
            int v = v.v(this.fhe);
            if (i > v) {
                i = v;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(v.a(this.fhe, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.fgK.setDatas(arrayList);
            this.fgK.notifyDataSetChanged();
            this.Hj.smoothScrollToPosition(this.fhl + 2);
            this.Hj.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Hj.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.Hj.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.eMI;
    }

    public void aWo() {
        if (this.fgY != null) {
            g.a(this.fgY, this.fgL.getPageContext().getPageActivity());
        }
        if (this.fbO != null) {
            this.fbO.dismiss();
        }
        if (this.fbE != null) {
            this.fbE.dismiss();
        }
        if (this.fbC != null) {
            g.b(this.fbC, this.fgL.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.eSw != null) {
            this.eSw.dismiss();
        }
    }

    public void aXr() {
        this.Hj.setNextPage(this.fgX);
        this.fgX.wx();
    }

    public void iX(boolean z) {
        this.ePM = z;
    }

    public void setIsFromPb(boolean z) {
        this.aCl = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(m mVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (mVar != null) {
            if (this.aCl && this.fgJ != null) {
                this.fgK.ko(true);
                this.fgJ.setVisibility(8);
                this.Hj.removeHeaderView(this.fgJ);
                this.fhk = 1;
            }
            this.ffn = mVar;
            this.fgK.P(this.ffn.Ox());
            if (this.fgJ != null) {
                this.fgJ.setVisibility(0);
            }
            if (this.fgM != null) {
                this.fgM.setVisibility(0);
            }
            if (mVar.aRT() != null) {
                this.fhd = mVar.aRT().getId();
                this.aUJ = mVar.aRT().bwo();
                if (this.aUJ > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fgL.getResources().getString(d.j.subpb_floor_reply_count), am.y(mVar.getTotalCount())));
                    this.cVX.setText(d.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.fgL.aXm()) {
                    str = "PB";
                }
                if (mVar.aRT().rT() != null) {
                    this.fgW.a(this.fgL.getPageContext(), mVar.aRT().rT(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", mVar.aSa().getId(), mVar.aSa().getName(), mVar.Ox().getId(), str));
                } else {
                    this.fgW.a(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.fgX.wx();
                this.fgK.setHasMoreData(true);
            } else {
                this.fgX.wy();
                this.fgK.setHasMoreData(false);
            }
            this.fhe = mVar.aRX();
            if (v.w(this.fhe)) {
                this.Hj.setNextPage(null);
                if (this.aCl) {
                    this.cVY.setVisibility(0);
                }
            } else {
                this.Hj.setNextPage(this.fgX);
                if (this.aCl) {
                    this.cVY.setVisibility(8);
                }
            }
            if (this.fhe == null || this.fhe.size() <= fgI) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.fhe.size() - fgI;
                qn(size);
                int firstVisiblePosition = this.Hj.getFirstVisiblePosition() - size;
                View childAt = this.Hj.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.fgK.setDatas(this.fhe);
            boolean z2 = false;
            if (mVar.Ox() != null && mVar.Ox().rx() != null && (userId = mVar.Ox().rx().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.fgK.y(i, z2);
            this.fgK.notifyDataSetChanged();
            a(mVar.aRT(), mVar.aCu(), mVar.nJ(), i, z);
            if (i4 > 0) {
                this.Hj.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void qn(int i) {
        if (this.fhe != null) {
            if (this.fhe.size() <= i) {
                this.fhe.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.fhe.iterator();
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

    public boolean aXs() {
        return this.fgK.cjq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aCl) {
            this.ePg = postData;
            if (!StringUtils.isNull(postData.bwv())) {
                this.fgU.setVisibility(0);
                this.fgU.startLoad(postData.bwv(), 10, true);
            } else {
                this.fgU.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.h bwx = postData.bwx();
            if (bwx != null && bwx.gyN) {
                this.fgV.setVisibility(0);
            } else {
                this.fgV.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fgJ.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fgJ.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fgS.setText((CharSequence) null);
            this.aoU.setText((CharSequence) null);
            this.faU.setVisibility(8);
            if (!this.aCl) {
                c(postData.rx());
                if (z) {
                    this.faU.setVisibility(0);
                    aj.i(this.faU, d.C0082d.cp_link_tip_a);
                }
            }
            this.eQj.setText(am.r(postData.getTime()));
            this.fgS.setText(String.format(this.fgL.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.bwo())));
            postData.rx().getUserTbVipInfoData();
            boolean a = a(this.fgT, postData.bwr());
            if (StringUtils.isNull(postData.bwv()) && !a && postData.Jy() != null) {
                this.caI.setVisibility(0);
                this.caI.setTag(postData.Jy());
                return;
            }
            this.caI.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.aP(metaData.getSealPrefix()) + 2 : 0) + w.gZ(name_show) > 14) {
                name_show = w.e(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.aoU.setText(ag(metaData.getSealPrefix(), name_show));
            } else {
                this.aoU.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.fgQ != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fgQ.setVisibility(8);
                } else {
                    this.fgQ.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Rd = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fgQ.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fbe.setVisibility(0);
                this.fgP.setVisibility(8);
                this.fbe.setUserId(metaData.getUserId());
                this.fbe.setUserName(metaData.getUserName());
                this.fbe.startLoad(metaData.getPortrait(), 28, false);
                aj.i(this.aoU, d.C0082d.cp_cont_r);
            } else {
                this.fbe.setVisibility(8);
                this.fgP.setVisibility(0);
                this.fgP.setUserId(metaData.getUserId());
                this.fgP.setUserName(metaData.getUserName());
                this.fgP.setDefaultResource(d.f.transparent_bg);
                this.fgP.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.fgP.startLoad(metaData.getPortrait(), 28, false);
                aj.i(this.aoU, d.C0082d.cp_cont_c);
            }
            this.fgO.setTag(d.g.tag_user_id, metaData.getUserId());
            this.fgO.setTag(d.g.tag_user_name, metaData.getUserName());
            this.fgO.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Jq() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Jq().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.Jx());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cg(true);
                        textView.setMovementMethod(com.baidu.tieba.view.d.bEa());
                        continue;
                    case 17:
                        String str = next.JB().mGifInfo.mSharpText;
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
        if (!tbRichTextData.JG()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.Jx() == null || tbRichTextData.Jx().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.Jx());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fgL.getPageContext().getString(d.j.refresh_view_title_text), this.So));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fgL.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fgM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.f(pageActivity, d.e.ds300), l.f(pageActivity, d.e.ds480), l.f(pageActivity, d.e.ds360)), dVar, a);
        }
        this.fgM.setVisibility(0);
        this.Hj.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.dZX.DZ();
        aj.k(this.mNoDataView, d.C0082d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fgL.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gV(int i) {
        b(NoDataViewFactory.d.C(i, d.j.refresh_view_title_text));
        if (this.fgC != null) {
            this.fgC.bl(this.eMI);
        }
        this.fhg.setVisibility(8);
    }

    public void lm(String str) {
        b(NoDataViewFactory.d.af(str, this.fgL.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.fgC != null) {
            this.fgC.bl(this.eMI);
        }
        this.fhg.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Hj.setVisibility(0);
            this.fhg.setVisibility(0);
            this.eMI.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.So = onClickListener;
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
                String userId2 = postData.rx().getUserId();
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
            if (this.ffn != null && this.ffn.Ox() != null && this.ffn.Ox().rx() != null && postData.rx() != null) {
                String userId3 = this.ffn.Ox().rx().getUserId();
                String userId4 = postData.rx().getUserId();
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
                    userId = postData.rx().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bwo() != 1 ? 0 : 1;
                    if (aq.k(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rx().getUserName());
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
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rx().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rx() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.rx().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.rx().getUserName());
                        }
                        if (this.ffn.Ox() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.ffn.Ox().getId());
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
            userId = postData.rx().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bwo() != 1) {
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

    public void km(boolean z) {
        if (this.eSw != null && this.eSw.aUR() != null) {
            if (z) {
                this.eSw.aUR().setText(d.j.remove_mark);
            } else {
                this.eSw.aUR().setText(d.j.mark);
            }
            this.eSw.refreshUI();
        }
    }

    public View aXt() {
        return this.fha;
    }

    public void onChangeSkinType(int i) {
        this.fgL.getLayoutMode().ag(i == 1);
        this.fgL.getLayoutMode().t(this.eMI);
        this.fgL.getLayoutMode().t(this.fgJ);
        this.mNavigationBar.onChangeSkinType(this.fgL.getPageContext(), i);
        if (this.fgN != null) {
            aj.i(this.fgN, d.C0082d.goto_see_subject_color);
        }
        aj.i(this.cVY, d.C0082d.cp_cont_d);
        this.cDJ.onChangeSkinType(this.fgL.getPageContext(), i);
        this.fgL.getLayoutMode().t(this.fha);
        aj.i(this.fgT, d.C0082d.cp_cont_b);
        this.fgT.setLinkTextColor(aj.getColor(d.C0082d.cp_link_tip_c));
        if (this.dZX != null && this.dZX.Dd() != null) {
            this.dZX.Dd().onChangeSkinType(i);
        }
        this.fgX.dz(i);
        this.caI.blz();
        aj.i(this.cVX, d.C0082d.cp_cont_e);
        aj.i(this.faU, d.C0082d.cp_link_tip_a);
        aj.i(this.aoU, d.C0082d.cp_cont_c);
        this.cVX.setAlpha(0.95f);
        if (this.fgK != null) {
            this.fgK.notifyDataSetChanged();
        }
    }

    public void aXu() {
        this.mProgress.setVisibility(0);
    }

    public void aXv() {
        this.Hj.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fgX.wy();
    }

    public void aiQ() {
        this.Hj.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fgX.aiQ();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayH = onLongClickListener;
        this.fgJ.setOnLongClickListener(this.ayH);
    }

    public View aXw() {
        return this.fgJ;
    }

    public TextView api() {
        return this.cVX;
    }

    public ImageView aXx() {
        return this.fhh;
    }

    public ImageView aXy() {
        return this.fhi;
    }

    public void qf(String str) {
        int qg = this.fgK.qg(str);
        if (qg > -1) {
            this.fgK.qo(qg);
            if (qg > 2) {
                this.Hj.setSelection(qg - 2);
            } else {
                this.Hj.setSelection(qg);
            }
            this.Hj.invalidate();
        }
    }

    public View aXz() {
        return this.fgN;
    }

    public View aXA() {
        return this.fgU;
    }

    public MorePopupWindow aXB() {
        return this.fgY;
    }

    public void showLoadingDialog() {
        if (this.cjW == null) {
            this.cjW = new com.baidu.tbadk.core.view.a(this.fgL.getPageContext());
        }
        this.cjW.aE(true);
    }

    public void XB() {
        if (this.cjW != null) {
            this.cjW.aE(false);
        }
    }

    public TextView aXC() {
        return this.fgT;
    }

    public void setOnLinkImageClickListener(TbRichTextView.g gVar) {
        this.fgs = gVar;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.fgt = fVar;
    }

    public y aXD() {
        return this.eSw;
    }

    public void anM() {
    }

    public void anN() {
    }

    public void onActivityDestroy() {
    }

    public void aXE() {
        if (this.fgL.aey()) {
        }
    }

    public View aXF() {
        return this.fgO;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.k.a((Context) this.fgL.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
