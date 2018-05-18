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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.al;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.c;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class b implements KeyboardEventLayout.a {
    private static final int fvd = TbadkCoreApplication.getInst().getListItemRule().yD();
    private BdListView FH;
    private RelativeLayout bEy;
    private View cOP;
    private NoNetworkView cUE;
    private com.baidu.tbadk.core.view.a czv;
    private TextView dlE;
    private TextView dlF;
    private x ffY;
    private k ftI;
    private SubPbModel fuJ;
    private a fuX;
    private ArrayList<PostData> fvA;
    private String fvB;
    private RelativeLayout fvC;
    private ImageView fvD;
    private ImageView fvE;
    private View fve;
    private c fvf;
    private NewSubPbActivity fvg;
    private RelativeLayout fvh;
    private View fvl;
    private ThreadSkinView fvs;
    private d fvt;
    private View fvw;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private TbRichTextView.h fuO = null;
    private View.OnClickListener Tp = null;
    private TbRichTextView.i fuN = null;
    private NavigationBar mNavigationBar = null;
    private View asg = null;
    private TextView fvi = null;
    private LinearLayout fvj = null;
    private HeadImageView fvk = null;
    private ClickableHeaderImageView fpz = null;
    private TextView aqm = null;
    private ImageView fvm = null;
    private TextView fpq = null;
    private TextView fvn = null;
    private TextView fvo = null;
    private EllipsizeRichTextView fvp = null;
    private TbImageView fvq = null;
    private PlayVoiceBntNew cqb = null;
    private TextView fvr = null;
    private MorePopupWindow fvu = null;
    private al fvv = null;
    private com.baidu.tbadk.core.dialog.b fqi = null;
    private Dialog fpX = null;
    private com.baidu.tbadk.core.dialog.a fpZ = null;
    private boolean fih = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener azQ = null;
    private NewSubPbActivity.a fvx = null;
    private NewSubPbActivity.a fvy = null;
    private g epj = null;
    private String fvz = null;
    private int aVC = 0;
    private PostData fdT = null;
    private int fvF = 0;
    private int fvG = 2;
    private int fvH = 0;
    private boolean aDk = true;
    private View.OnClickListener fip = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            if (view2 != null && (sparseArray = (SparseArray) view2.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.aeW() || !com.baidu.tieba.c.a.b(b.this.fvg.getBaseContext(), b.this.fvg.getThreadId(), b.this.fvg.getPostId(), b.this.fvg.aVE())) {
                        if (booleanValue2) {
                            sparseArray.put(d.g.tag_from, 1);
                            b.this.fvg.b(sparseArray);
                            return;
                        }
                        b.this.be(view2);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    b.this.fvg.b(sparseArray);
                } else if (booleanValue3) {
                    b.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aWy = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.b.2
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view2, MotionEvent motionEvent) {
            b.this.fO(false);
            b.this.av(view2);
            b.this.fO(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view2, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view2, MotionEvent motionEvent) {
            return true;
        }
    });
    protected AdapterView.OnItemClickListener fvI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.9
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            if (az.aK(b.this.fvg.getPageContext().getPageActivity())) {
                if (b.this.fvg.epb == null || b.this.fuJ == null || b.this.fuJ.aWk() == null || b.this.fvg.epb.cK(b.this.fuJ.aWk().replyPrivateFlag)) {
                    if (b.this.fuX != null) {
                        b.this.fuX.asY();
                    }
                    b.this.bbu();
                    if (view2 == null || !(view2.getTag() instanceof c.a)) {
                        PostData postData = (PostData) v.c(b.this.fvA, i);
                        if (postData == null) {
                            b.this.fvB = null;
                        } else {
                            b.this.fvB = postData.getId();
                        }
                        SparseArray sparseArray = (SparseArray) view2.getTag();
                        if (sparseArray != null) {
                            String str = (String) sparseArray.get(d.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                            if (str != null) {
                                b.this.epj.setReplyId(str2);
                                b.this.epj.gx(str);
                            }
                        }
                        b.this.bbv();
                        return;
                    }
                    b.this.bbw();
                    b.this.fuJ.bbR();
                }
            }
        }
    };

    public b(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.bEy = null;
        this.fve = null;
        this.FH = null;
        this.fvf = null;
        this.fvg = null;
        this.cUE = null;
        this.fvh = null;
        this.dlF = null;
        this.fvl = null;
        this.fvt = null;
        this.fvw = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dlE = null;
        this.fvC = null;
        this.fvD = null;
        this.fvE = null;
        this.fvg = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.bEy = (RelativeLayout) LayoutInflater.from(this.fvg.getPageContext().getPageActivity()).inflate(d.i.new_sub_pb_layout, (ViewGroup) null);
        this.fve = LayoutInflater.from(this.fvg.getPageContext().getPageActivity()).inflate(d.i.new_sub_pb_head, (ViewGroup) null);
        this.dlF = (TextView) this.bEy.findViewById(d.g.no_reply_list_view);
        this.fvC = (RelativeLayout) this.bEy.findViewById(d.g.subpb_editor_tool_comment);
        this.dlE = (TextView) this.bEy.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dlE.setOnClickListener(this.mCommonClickListener);
        this.fvD = (ImageView) this.bEy.findViewById(d.g.subpb_editor_tool_more_img);
        this.fvE = (ImageView) this.bEy.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.fvE.setOnClickListener(this.mCommonClickListener);
        this.fvD.setOnClickListener(this.mCommonClickListener);
        this.cUE = (NoNetworkView) this.bEy.findViewById(d.g.view_no_network);
        atg();
        bbt();
        this.fvh = (RelativeLayout) this.bEy.findViewById(d.g.sub_pb_body_layout);
        this.FH = (BdListView) this.bEy.findViewById(d.g.new_sub_pb_list);
        this.fvs = (ThreadSkinView) LayoutInflater.from(this.fvg.getPageContext().getPageActivity()).inflate(d.i.thread_skin_layout, (ViewGroup) null);
        this.FH.addHeaderView(this.fvs);
        this.FH.addHeaderView(this.fve);
        this.cOP = BdListViewHelper.a(this.fvg.getActivity(), this.FH, BdListViewHelper.HeadType.DEFAULT);
        this.fvf = new c(this.fvg.getPageContext().getPageActivity());
        this.fvf.I(this.fip);
        this.fvf.setIsFromCDN(this.mIsFromCDN);
        this.fvf.kI(true);
        this.FH.setAdapter((ListAdapter) this.fvf);
        this.fvt = new d(this.fvg.getPageContext());
        this.fvw = this.fvt.getView();
        this.FH.setNextPage(this.fvt);
        this.fvt.setOnClickListener(this.mCommonClickListener);
        this.FH.setOnItemClickListener(this.fvI);
        this.FH.setOnTouchListener(this.aWy);
        this.mProgress = (ProgressBar) this.bEy.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fve != null) {
            this.fve.setVisibility(4);
        }
        if (this.fvh != null) {
            this.fvh.setVisibility(4);
        }
        this.fvl = com.baidu.tbadk.ala.b.or().f(this.fvg.getActivity(), 4);
        if (this.fvl != null) {
            this.fvl.setVisibility(8);
            this.fvj.addView(this.fvl, 3);
        }
    }

    public ListView getListView() {
        return this.FH;
    }

    public void bbt() {
        this.fvj = (LinearLayout) this.fve.findViewById(d.g.subpb_head_user_info_root);
        this.fvj.setOnClickListener(this.mCommonClickListener);
        this.fvk = (HeadImageView) this.fve.findViewById(d.g.photo);
        this.fvk.setRadius(l.e(this.fvg.getActivity(), d.e.ds30));
        this.fvk.setClickable(false);
        this.fpz = (ClickableHeaderImageView) this.fve.findViewById(d.g.god_user_photo);
        this.fpz.setGodIconMargin(0);
        this.fpz.setGodIconWidth(d.e.ds24);
        this.fpz.setRadius(l.e(this.fvg.getActivity(), d.e.ds30));
        this.fpz.setClickable(false);
        this.aqm = (TextView) this.fve.findViewById(d.g.user_name);
        this.fvm = (ImageView) this.fve.findViewById(d.g.user_rank);
        this.fvm.setVisibility(8);
        this.fpq = (TextView) this.fve.findViewById(d.g.floor_owner);
        this.fvi = (TextView) this.fve.findViewById(d.g.see_subject);
        this.fvi.setOnClickListener(this.mCommonClickListener);
        this.fvn = (TextView) this.fve.findViewById(d.g.floor);
        this.fvo = (TextView) this.fve.findViewById(d.g.time);
        this.fvp = (EllipsizeRichTextView) this.fve.findViewById(d.g.content_text);
        this.fvp.setOnClickListener(this.mCommonClickListener);
        ak.h(this.fvp, d.C0126d.cp_cont_b);
        this.fvp.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
        this.fvp.setLineSpacing(0.0f, 1.25f);
        this.fvq = (TbImageView) this.fve.findViewById(d.g.sub_pb_image);
        this.fvq.setOnClickListener(this.mCommonClickListener);
        this.fvr = (TextView) this.fve.findViewById(d.g.advert);
        this.cqb = (PlayVoiceBntNew) this.fve.findViewById(d.g.voice_btn);
        this.fve.setOnTouchListener(this.aWy);
        this.fve.setOnClickListener(this.mCommonClickListener);
    }

    public void fQ(boolean z) {
        if (this.cOP != null && this.cOP.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cOP.getLayoutParams();
            if (z) {
                atk();
                layoutParams.height = l.e(this.fvg.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.e(this.fvg.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.cOP.setLayoutParams(layoutParams);
        }
    }

    private void atk() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View atl() {
        return this.cOP;
    }

    public void atg() {
        int e = l.e(this.fvg.getPageContext().getPageActivity(), d.e.ds88);
        int e2 = l.e(this.fvg.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.bEy.findViewById(d.g.view_navigation_bar);
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.asg.getLayoutParams();
            layoutParams.height = e;
            layoutParams.width = e;
            layoutParams.leftMargin = e2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.asg != null && (this.asg.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.asg.getLayoutParams();
            layoutParams2.width = e;
            layoutParams2.height = e;
            this.asg.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar Rd() {
        return this.mNavigationBar;
    }

    public void be(View view2) {
        SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fpX == null) {
            this.fpX = new Dialog(this.fvg.getPageContext().getPageActivity(), d.l.common_alert_dialog);
            this.fpX.setCanceledOnTouchOutside(true);
            this.fpX.setCancelable(true);
            View inflate = LayoutInflater.from(this.fvg.getPageContext().getPageActivity()).inflate(d.i.forum_manage_dialog, (ViewGroup) null);
            this.fvg.getLayoutMode().u(inflate);
            this.fpX.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fpX.getWindow().getAttributes();
            attributes.width = (int) (l.af(this.fvg.getPageContext().getPageActivity()) * 0.9d);
            this.fpX.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fpX.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fpX.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fpX.findViewById(d.g.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fpX != null && (b.this.fpX instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fpX, b.this.fvg.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view2.getTag();
                    if (sparseArray3 != null) {
                        b.this.a(((Integer) sparseArray3.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray3.get(d.g.tag_del_post_id), ((Integer) sparseArray3.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(d.g.tag_del_post_is_self)).booleanValue());
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
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fpX != null && (b.this.fpX instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fpX, b.this.fvg.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view2.getTag();
                    if (sparseArray4 != null && b.this.fvx != null) {
                        b.this.fvx.f(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id)});
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
                textView3.setText(d.k.un_mute);
            } else {
                textView3.setText(d.k.mute);
            }
            sparseArray4.put(d.g.tag_is_mem, sparseArray.get(d.g.tag_is_mem));
            sparseArray4.put(d.g.tag_user_mute_mute_userid, sparseArray.get(d.g.tag_user_mute_mute_userid));
            sparseArray4.put(d.g.tag_user_mute_mute_username, sparseArray.get(d.g.tag_user_mute_mute_username));
            sparseArray4.put(d.g.tag_user_mute_post_id, sparseArray.get(d.g.tag_user_mute_post_id));
            sparseArray4.put(d.g.tag_user_mute_thread_id, sparseArray.get(d.g.tag_user_mute_thread_id));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fpX != null && (b.this.fpX instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(b.this.fpX, b.this.fvg.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view2.getTag();
                    if (sparseArray5 != null) {
                        b.this.fvg.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fpX, this.fvg.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        final SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_del_post_id, str);
        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = d.k.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = d.k.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = d.k.report_thread_confirm;
            } else {
                i3 = d.k.del_thread_confirm;
            }
        }
        this.fpZ = new com.baidu.tbadk.core.dialog.a(this.fvg.getPageContext().getPageActivity());
        this.fpZ.ca(i3);
        this.fpZ.z(sparseArray);
        this.fpZ.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (b.this.fvy != null) {
                    b.this.fvy.f(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fpZ.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.b.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fpZ.ar(true);
        this.fpZ.b(this.fvg.getPageContext());
        this.fpZ.tC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fO(final boolean z) {
        if (this.FH != null) {
            if (!z) {
                this.FH.setEnabled(z);
            } else {
                this.FH.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.FH.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0086b interfaceC0086b, boolean z) {
        String string;
        if (this.fqi != null) {
            this.fqi.dismiss();
            this.fqi = null;
        }
        if (z) {
            string = this.fvg.getResources().getString(d.k.remove_mark);
        } else {
            string = this.fvg.getResources().getString(d.k.mark);
        }
        this.fqi = new com.baidu.tbadk.core.dialog.b(this.fvg.getPageContext().getPageActivity());
        this.fqi.cd(d.k.operation);
        this.fqi.a(new String[]{this.fvg.getResources().getString(d.k.copy), string}, interfaceC0086b);
        this.fqi.d(this.fvg.getPageContext());
        this.fqi.tF();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.fvx = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.fvy = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fvg.showToast(this.fvg.getResources().getString(d.k.delete_success));
        } else if (str != null && z2) {
            this.fvg.showToast(str);
        }
    }

    public void av(View view2) {
        if (this.cOP != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cOP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.FH != null) {
                    this.FH.removeHeaderView(this.cOP);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cOP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.e(this.fvg.getActivity(), d.e.ds98)));
            } else if (this.FH != null) {
                this.FH.addHeaderView(this.cOP, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(g gVar) {
        if (gVar != null && gVar.DD() != null) {
            this.epj = gVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bEy.addView(gVar.DD(), layoutParams);
        }
    }

    public void e(a aVar) {
        this.fuX = aVar;
    }

    public void bbu() {
        if (this.FH != null) {
            this.fvH = this.FH.getLastVisiblePosition();
        }
    }

    public void bbv() {
        if (this.fuJ != null) {
            if ((!bby() && this.fvw != null && this.fvw.isShown()) || v.w(this.fvA)) {
                this.fuJ.kL(false);
            } else {
                this.fuJ.kL(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fuJ = subPbModel;
    }

    public void bbw() {
        a(this.fvg);
        this.FH.setNextPage(this.fvt);
    }

    public void m(PostData postData) {
        int i;
        if (postData != null) {
            postData.mq(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bby() && this.fvw != null && this.fvw.isShown()) {
                i = (this.fvH - this.fvG) - 1;
            } else {
                i = this.fvH - this.fvG;
            }
            int v = v.v(this.fvA);
            if (i > v) {
                i = v;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(v.a(this.fvA, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.fvf.setDatas(arrayList);
            this.fvf.notifyDataSetChanged();
            this.FH.smoothScrollToPosition(this.fvH + 2);
            this.FH.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.FH.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.FH.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.bEy;
    }

    public void bar() {
        if (this.fvu != null) {
            com.baidu.adp.lib.g.g.a(this.fvu, this.fvg.getPageContext().getPageActivity());
        }
        if (this.fqi != null) {
            this.fqi.dismiss();
        }
        if (this.fpZ != null) {
            this.fpZ.dismiss();
        }
        if (this.fpX != null) {
            com.baidu.adp.lib.g.g.b(this.fpX, this.fvg.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.ffY != null) {
            this.ffY.dismiss();
        }
    }

    public void bbx() {
        this.FH.setNextPage(this.fvt);
        this.fvt.wQ();
    }

    public void jr(boolean z) {
        this.fih = z;
    }

    public void setIsFromPb(boolean z) {
        this.aDk = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(k kVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (kVar != null) {
            if (this.aDk && this.fve != null) {
                this.fvf.kJ(true);
                this.fve.setVisibility(8);
                this.FH.removeHeaderView(this.fve);
                this.fvG = 1;
            }
            this.ftI = kVar;
            this.fvf.T(this.ftI.Pb());
            if (this.fve != null) {
                this.fve.setVisibility(0);
            }
            if (this.fvh != null) {
                this.fvh.setVisibility(0);
            }
            if (kVar.aWc() != null) {
                this.fvz = kVar.aWc().getId();
                this.aVC = kVar.aWc().brX();
                if (this.aVC > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fvg.getResources().getString(d.k.subpb_floor_reply_count), an.z(kVar.getTotalCount())));
                    this.dlE.setText(d.k.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.fvg.bbs()) {
                    str = "PB";
                }
                if (kVar.aWc().sj() != null) {
                    this.fvs.setData(this.fvg.getPageContext(), kVar.aWc().sj(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", kVar.aWj().getId(), kVar.aWj().getName(), kVar.Pb().getId(), str));
                } else {
                    this.fvs.setData(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.fvt.wQ();
                this.fvf.setHasMoreData(true);
            } else {
                this.fvt.wR();
                this.fvf.setHasMoreData(false);
            }
            this.fvA = kVar.aWg();
            if (v.w(this.fvA)) {
                this.FH.setNextPage(null);
                if (this.aDk) {
                    this.dlF.setVisibility(0);
                }
            } else {
                this.FH.setNextPage(this.fvt);
                if (this.aDk) {
                    this.dlF.setVisibility(8);
                }
            }
            if (this.fvA == null || this.fvA.size() <= fvd) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.fvA.size() - fvd;
                qF(size);
                int firstVisiblePosition = this.FH.getFirstVisiblePosition() - size;
                View childAt = this.FH.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.fvf.setDatas(this.fvA);
            boolean z2 = false;
            if (kVar.Pb() != null && kVar.Pb().rP() != null && (userId = kVar.Pb().rP().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.fvf.B(i, z2);
            this.fvf.notifyDataSetChanged();
            a(kVar.aWc(), kVar.aGl(), kVar.oH(), i, z);
            if (i4 > 0) {
                this.FH.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void qF(int i) {
        if (this.fvA != null) {
            if (this.fvA.size() <= i) {
                this.fvA.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.fvA.iterator();
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

    public boolean bby() {
        return this.fvf.cyJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.aDk) {
            this.fdT = postData;
            if (!StringUtils.isNull(postData.bse())) {
                this.fvq.setVisibility(0);
                this.fvq.startLoad(postData.bse(), 10, true);
            } else {
                this.fvq.setVisibility(8);
            }
            h bsg = postData.bsg();
            if (bsg != null && bsg.gxe) {
                this.fvr.setVisibility(0);
            } else {
                this.fvr.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fve.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fve.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fvn.setText((CharSequence) null);
            this.aqm.setText((CharSequence) null);
            this.fpq.setVisibility(8);
            if (!this.aDk) {
                c(postData.rP());
                if (z) {
                    this.fpq.setVisibility(0);
                    ak.h(this.fpq, d.C0126d.cp_link_tip_a);
                }
            }
            this.fvo.setText(an.s(postData.getTime()));
            this.fvn.setText(String.format(this.fvg.getPageContext().getString(d.k.is_floor), Integer.valueOf(postData.brX())));
            postData.rP().getUserTbVipInfoData();
            boolean a = a(this.fvp, postData.brZ());
            if (StringUtils.isNull(postData.bse()) && !a && postData.JP() != null) {
                this.cqb.setVisibility(0);
                this.cqb.setTag(postData.JP());
                return;
            }
            this.cqb.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.k.aU(metaData.getSealPrefix()) + 2 : 0) + w.hl(name_show) > 14) {
                name_show = w.k(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.aqm.setText(ag(metaData.getSealPrefix(), name_show));
            } else {
                this.aqm.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.fvl != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fvl.setVisibility(8);
                } else {
                    this.fvl.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.Sa = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fvl.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fpz.setVisibility(0);
                this.fvk.setVisibility(8);
                this.fpz.setUserId(metaData.getUserId());
                this.fpz.setUserName(metaData.getUserName());
                this.fpz.startLoad(metaData.getPortrait(), 28, false);
                ak.h(this.aqm, d.C0126d.cp_cont_r);
            } else {
                this.fpz.setVisibility(8);
                this.fvk.setVisibility(0);
                this.fvk.setUserId(metaData.getUserId());
                this.fvk.setUserName(metaData.getUserName());
                this.fvk.setDefaultResource(d.f.transparent_bg);
                this.fvk.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.fvk.startLoad(metaData.getPortrait(), 28, false);
                ak.h(this.aqm, d.C0126d.cp_cont_c);
            }
            this.fvj.setTag(d.g.tag_user_id, metaData.getUserId());
            this.fvj.setTag(d.g.tag_user_name, metaData.getUserName());
            this.fvj.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.JH() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.JH().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.JO());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cf(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.bAb());
                        continue;
                    case 17:
                        String str = next.JS().mGifInfo.mSharpText;
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
        if (!tbRichTextData.JX()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.JO() == null || tbRichTextData.JO().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.JO());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fvg.getPageContext().getString(d.k.refresh_view_title_text), this.Tp));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fvg.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fvh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.e(pageActivity, d.e.ds250), l.e(pageActivity, d.e.ds480), l.e(pageActivity, d.e.ds360)), dVar, a);
        }
        this.fvh.setVisibility(0);
        this.FH.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.epj.Ey();
        ak.j(this.mNoDataView, d.C0126d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fvg.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void ii(int i) {
        b(NoDataViewFactory.d.C(i, d.k.refresh_view_title_text));
        if (this.fuX != null) {
            this.fuX.bh(this.bEy);
        }
        this.fvC.setVisibility(8);
    }

    public void lZ(String str) {
        b(NoDataViewFactory.d.af(str, this.fvg.getPageContext().getString(d.k.refresh_view_title_text)));
        if (this.fuX != null) {
            this.fuX.bh(this.bEy);
        }
        this.fvC.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.FH.setVisibility(0);
            this.fvC.setVisibility(0);
            this.bEy.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.Tp = onClickListener;
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
                String userId2 = postData.rP().getUserId();
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
            if (this.ftI != null && this.ftI.Pb() != null && this.ftI.Pb().rP() != null && postData.rP() != null) {
                String userId3 = this.ftI.Pb().rP().getUserId();
                String userId4 = postData.rP().getUserId();
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
                    userId = postData.rP().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.brX() != 1 ? 0 : 1;
                    if (ar.j(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rP().getUserName());
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
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rP().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rP() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.rP().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.rP().getUserName());
                        }
                        if (this.ftI.Pb() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.ftI.Pb().getId());
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
            userId = postData.rP().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.brX() != 1) {
            }
            if (ar.j(postData)) {
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

    public void kH(boolean z) {
        if (this.ffY != null && this.ffY.aYV() != null) {
            if (z) {
                this.ffY.aYV().setText(d.k.remove_mark);
            } else {
                this.ffY.aYV().setText(d.k.mark);
            }
            this.ffY.refreshUI();
        }
    }

    public View bbz() {
        return this.fvw;
    }

    public void onChangeSkinType(int i) {
        this.fvg.getLayoutMode().setNightMode(i == 1);
        this.fvg.getLayoutMode().u(this.bEy);
        this.fvg.getLayoutMode().u(this.fve);
        this.mNavigationBar.onChangeSkinType(this.fvg.getPageContext(), i);
        if (this.fvi != null) {
            ak.h(this.fvi, d.C0126d.goto_see_subject_color);
        }
        ak.h(this.dlF, d.C0126d.cp_cont_d);
        this.cUE.onChangeSkinType(this.fvg.getPageContext(), i);
        this.fvg.getLayoutMode().u(this.fvw);
        ak.h(this.fvp, d.C0126d.cp_cont_b);
        this.fvp.setLinkTextColor(ak.getColor(d.C0126d.cp_link_tip_c));
        if (this.epj != null && this.epj.DD() != null) {
            this.epj.DD().onChangeSkinType(i);
        }
        this.fvt.dw(i);
        this.cqb.aIS();
        ak.h(this.dlE, d.C0126d.cp_cont_e);
        ak.h(this.fpq, d.C0126d.cp_link_tip_a);
        ak.h(this.aqm, d.C0126d.cp_cont_c);
        this.dlE.setAlpha(0.95f);
        if (this.fvf != null) {
            this.fvf.notifyDataSetChanged();
        }
    }

    public void bbA() {
        this.mProgress.setVisibility(0);
    }

    public void bbB() {
        this.FH.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fvt.wR();
    }

    public void amK() {
        this.FH.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fvt.amK();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.azQ = onLongClickListener;
        this.fve.setOnLongClickListener(this.azQ);
    }

    public View bbC() {
        return this.fve;
    }

    public TextView atm() {
        return this.dlE;
    }

    public ImageView bbD() {
        return this.fvD;
    }

    public ImageView bbE() {
        return this.fvE;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void qG(int i) {
    }

    public void qR(String str) {
        int qS = this.fvf.qS(str);
        if (qS > -1) {
            this.fvf.qH(qS);
            if (qS > 2) {
                this.FH.setSelection(qS - 2);
            } else {
                this.FH.setSelection(qS);
            }
            this.FH.invalidate();
        }
    }

    public View bbF() {
        return this.fvi;
    }

    public View bbG() {
        return this.fvq;
    }

    public MorePopupWindow bbH() {
        return this.fvu;
    }

    public void showLoadingDialog() {
        if (this.czv == null) {
            this.czv = new com.baidu.tbadk.core.view.a(this.fvg.getPageContext());
        }
        this.czv.aI(true);
    }

    public void aav() {
        if (this.czv != null) {
            this.czv.aI(false);
        }
    }

    public TextView bbI() {
        return this.fvp;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.fuN = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fuO = hVar;
    }

    public x bbJ() {
        return this.ffY;
    }

    public void asa() {
    }

    public void asb() {
    }

    public void onActivityDestroy() {
    }

    public void bbK() {
        if (this.fvg.isPaused()) {
        }
    }

    public View bbL() {
        return this.fvj;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new o.a(str, d.f.pic_smalldot_title));
            return o.a((Context) this.fvg.getActivity(), str2, (ArrayList<o.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
