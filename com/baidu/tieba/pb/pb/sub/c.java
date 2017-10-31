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
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.pb.pb.main.w;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class c {
    private static final int eZv = TbadkCoreApplication.getInst().getListItemRule().xT();
    private BdListView Hj;
    private TextView cMr;
    private TextView cMs;
    private com.baidu.tbadk.core.view.a cbh;
    private View cpD;
    private NoNetworkView cuk;
    private RelativeLayout eEF;
    private w eKy;
    private m eYb;
    private View eZD;
    private ThreadSkinView eZJ;
    private e eZK;
    private View eZN;
    private ArrayList<PostData> eZR;
    private String eZS;
    private RelativeLayout eZT;
    private ImageView eZU;
    private ImageView eZV;
    private SubPbModel eZa;
    private b eZo;
    private View eZw;
    private d eZx;
    private NewSubPbActivity eZy;
    private RelativeLayout eZz;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private f mNoDataView = null;
    private TbRichTextView.f eZf = null;
    private View.OnClickListener RF = null;
    private TbRichTextView.g eZe = null;
    private NavigationBar mNavigationBar = null;
    private View aqh = null;
    private TextView eZA = null;
    private LinearLayout eZB = null;
    private HeadImageView eZC = null;
    private ClickableHeaderImageView eSa = null;
    private TextView aoE = null;
    private ImageView eZE = null;
    private TextView eRQ = null;
    private TextView eZF = null;
    private TextView eIm = null;
    private EllipsizeRichTextView eZG = null;
    private TbImageView eZH = null;
    private PlayVoiceBntNew bSJ = null;
    private TextView eZI = null;
    private MorePopupWindow eZL = null;
    private aj eZM = null;
    private com.baidu.tbadk.core.dialog.b eSJ = null;
    private Dialog eSx = null;
    private com.baidu.tbadk.core.dialog.a eSz = null;
    private boolean eHP = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener axY = null;
    private NewSubPbActivity.a eZO = null;
    private NewSubPbActivity.a eZP = null;
    private com.baidu.tbadk.editortools.pb.f dSd = null;
    private String eZQ = null;
    private int aRC = 0;
    private PostData eHb = null;
    private int eZW = 0;
    private int eZX = 2;
    private int eZY = 0;
    private boolean eZp = true;
    private View.OnClickListener eHU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.Zt() || !com.baidu.tieba.c.a.a(c.this.eZy.getBaseContext(), c.this.eZy.getThreadId(), c.this.eZy.getPostId(), c.this.eZy.aPZ())) {
                        if (booleanValue2) {
                            sparseArray.put(d.g.tag_from, 1);
                            c.this.eZy.c(sparseArray);
                            return;
                        }
                        c.this.bn(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    c.this.eZy.c(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c aSw = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.2
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            c.this.eY(false);
            c.this.az(view);
            c.this.eY(true);
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
    protected AdapterView.OnItemClickListener eZZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.9
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ax.aT(c.this.eZy.getPageContext().getPageActivity())) {
                if (c.this.eZo != null) {
                    c.this.eZo.amM();
                }
                c.this.aWh();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) v.c(c.this.eZR, i);
                    if (postData == null) {
                        c.this.eZS = null;
                    } else {
                        c.this.eZS = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.g.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                        if (str != null) {
                            c.this.dSd.setReplyId(str2);
                            c.this.dSd.gd(str);
                        }
                    }
                    c.this.aWi();
                    return;
                }
                c.this.aWj();
                c.this.eZa.aWE();
            }
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.eEF = null;
        this.eZw = null;
        this.Hj = null;
        this.eZx = null;
        this.eZy = null;
        this.cuk = null;
        this.eZz = null;
        this.cMs = null;
        this.eZD = null;
        this.eZK = null;
        this.eZN = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.cMr = null;
        this.eZT = null;
        this.eZU = null;
        this.eZV = null;
        this.eZy = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.eEF = (RelativeLayout) LayoutInflater.from(this.eZy.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.eZw = LayoutInflater.from(this.eZy.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.cMs = (TextView) this.eEF.findViewById(d.g.no_reply_list_view);
        this.eZT = (RelativeLayout) this.eEF.findViewById(d.g.subpb_editor_tool_comment);
        this.cMr = (TextView) this.eEF.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.cMr.setOnClickListener(this.mCommonClickListener);
        this.eZU = (ImageView) this.eEF.findViewById(d.g.subpb_editor_tool_more_img);
        this.eZV = (ImageView) this.eEF.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.eZV.setOnClickListener(this.mCommonClickListener);
        this.eZU.setOnClickListener(this.mCommonClickListener);
        this.cuk = (NoNetworkView) this.eEF.findViewById(d.g.view_no_network);
        amU();
        aWg();
        this.eZz = (RelativeLayout) this.eEF.findViewById(d.g.sub_pb_body_layout);
        this.Hj = (BdListView) this.eEF.findViewById(d.g.new_sub_pb_list);
        this.eZJ = (ThreadSkinView) LayoutInflater.from(this.eZy.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.Hj.addHeaderView(this.eZJ);
        this.Hj.addHeaderView(this.eZw);
        this.cpD = BdListViewHelper.a(this.eZy.getActivity(), this.Hj, BdListViewHelper.HeadType.DEFAULT);
        this.eZx = new d(this.eZy.getPageContext().getPageActivity());
        this.eZx.F(this.eHU);
        this.eZx.setIsFromCDN(this.mIsFromCDN);
        this.eZx.jJ(true);
        this.Hj.setAdapter((ListAdapter) this.eZx);
        this.eZK = new e(this.eZy.getPageContext());
        this.eZN = this.eZK.getView();
        this.Hj.setNextPage(this.eZK);
        this.eZK.setOnClickListener(this.mCommonClickListener);
        this.Hj.setOnItemClickListener(this.eZZ);
        this.Hj.setOnTouchListener(this.aSw);
        this.mProgress = (ProgressBar) this.eEF.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eZw != null) {
            this.eZw.setVisibility(4);
        }
        if (this.eZz != null) {
            this.eZz.setVisibility(4);
        }
        this.eZD = com.baidu.tbadk.ala.b.nu().g(this.eZy.getActivity(), 4);
        if (this.eZD != null) {
            this.eZD.setVisibility(8);
            this.eZB.addView(this.eZD, 3);
        }
    }

    public ListView getListView() {
        return this.Hj;
    }

    public void aWg() {
        this.eZB = (LinearLayout) this.eZw.findViewById(d.g.subpb_head_user_info_root);
        this.eZB.setOnClickListener(this.mCommonClickListener);
        this.eZC = (HeadImageView) this.eZw.findViewById(d.g.photo);
        this.eZC.setRadius(l.f(this.eZy.getActivity(), d.e.ds30));
        this.eZC.setClickable(false);
        this.eSa = (ClickableHeaderImageView) this.eZw.findViewById(d.g.god_user_photo);
        this.eSa.setGodIconMargin(0);
        this.eSa.setGodIconWidth(d.e.ds24);
        this.eSa.setRadius(l.f(this.eZy.getActivity(), d.e.ds30));
        this.eSa.setClickable(false);
        this.aoE = (TextView) this.eZw.findViewById(d.g.user_name);
        this.eZE = (ImageView) this.eZw.findViewById(d.g.user_rank);
        this.eZE.setVisibility(8);
        this.eRQ = (TextView) this.eZw.findViewById(d.g.floor_owner);
        this.eZA = (TextView) this.eZw.findViewById(d.g.see_subject);
        this.eZA.setOnClickListener(this.mCommonClickListener);
        this.eZF = (TextView) this.eZw.findViewById(d.g.floor);
        this.eIm = (TextView) this.eZw.findViewById(d.g.time);
        this.eZG = (EllipsizeRichTextView) this.eZw.findViewById(d.g.content_text);
        this.eZG.setOnClickListener(this.mCommonClickListener);
        com.baidu.tbadk.core.util.aj.i(this.eZG, d.C0080d.cp_cont_b);
        this.eZG.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_link_tip_c));
        this.eZG.setLineSpacing(0.0f, 1.25f);
        this.eZH = (TbImageView) this.eZw.findViewById(d.g.sub_pb_image);
        this.eZH.setOnClickListener(this.mCommonClickListener);
        this.eZI = (TextView) this.eZw.findViewById(d.g.advert);
        this.bSJ = (PlayVoiceBntNew) this.eZw.findViewById(d.g.voice_btn);
        this.eZw.setOnTouchListener(this.aSw);
        this.eZw.setOnClickListener(this.mCommonClickListener);
    }

    public void fa(boolean z) {
        if (this.cpD != null && this.cpD.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cpD.getLayoutParams();
            if (z) {
                amY();
                layoutParams.height = l.f(this.eZy.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.f(this.eZy.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.cpD.setLayoutParams(layoutParams);
        }
    }

    private void amY() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View amZ() {
        return this.cpD;
    }

    public void amU() {
        int f = l.f(this.eZy.getPageContext().getPageActivity(), d.e.ds88);
        int f2 = l.f(this.eZy.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.eEF.findViewById(d.g.view_navigation_bar);
        this.aqh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqh.getLayoutParams();
            layoutParams.height = f;
            layoutParams.width = f;
            layoutParams.leftMargin = f2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aqh != null && (this.aqh.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aqh.getLayoutParams();
            layoutParams2.width = f;
            layoutParams2.height = f;
            this.aqh.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar ajm() {
        return this.mNavigationBar;
    }

    public void bn(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.eSx == null) {
            this.eSx = new Dialog(this.eZy.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.eSx.setCanceledOnTouchOutside(true);
            this.eSx.setCancelable(true);
            View inflate = LayoutInflater.from(this.eZy.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.eZy.getLayoutMode().t(inflate);
            this.eSx.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.eSx.getWindow().getAttributes();
            attributes.width = (int) (l.ac(this.eZy.getPageContext().getPageActivity()) * 0.9d);
            this.eSx.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eSx.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.eSx.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.eSx.findViewById(d.g.disable_reply_btn);
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
                    if (c.this.eSx != null && (c.this.eSx instanceof Dialog)) {
                        g.b(c.this.eSx, c.this.eZy.getPageContext());
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
                    if (c.this.eSx != null && (c.this.eSx instanceof Dialog)) {
                        g.b(c.this.eSx, c.this.eZy.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.eZO != null) {
                        c.this.eZO.f(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id)});
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
                    if (c.this.eSx != null && (c.this.eSx instanceof Dialog)) {
                        g.b(c.this.eSx, c.this.eZy.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.eZy.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.eSx, this.eZy.getPageContext());
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
        this.eSz = new com.baidu.tbadk.core.dialog.a(this.eZy.getPageContext().getPageActivity());
        this.eSz.cc(i3);
        this.eSz.z(sparseArray);
        this.eSz.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.eZP != null) {
                    c.this.eZP.f(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.eSz.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.eSz.ao(true);
        this.eSz.b(this.eZy.getPageContext());
        this.eSz.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(final boolean z) {
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
        if (this.eSJ != null) {
            this.eSJ.dismiss();
            this.eSJ = null;
        }
        if (z) {
            string = this.eZy.getResources().getString(d.j.remove_mark);
        } else {
            string = this.eZy.getResources().getString(d.j.mark);
        }
        this.eSJ = new com.baidu.tbadk.core.dialog.b(this.eZy.getPageContext().getPageActivity());
        this.eSJ.cf(d.j.operation);
        this.eSJ.a(new String[]{this.eZy.getResources().getString(d.j.copy), string}, interfaceC0047b);
        this.eSJ.d(this.eZy.getPageContext());
        this.eSJ.tl();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.eZO = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.eZP = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.eZy.showToast(this.eZy.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.eZy.showToast(str);
        }
    }

    public void az(View view) {
        if (this.cpD != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cpD.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Hj != null) {
                    this.Hj.removeHeaderView(this.cpD);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cpD.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(this.eZy.getActivity(), d.e.ds98)));
            } else if (this.Hj != null) {
                this.Hj.addHeaderView(this.cpD, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.f fVar) {
        if (fVar != null && fVar.CI() != null) {
            this.dSd = fVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eEF.addView(fVar.CI(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.eZo = bVar;
    }

    public void aWh() {
        if (this.Hj != null) {
            this.eZY = this.Hj.getLastVisiblePosition();
        }
    }

    public void aWi() {
        if (this.eZa != null) {
            if ((!aWl() && this.eZN != null && this.eZN.isShown()) || v.v(this.eZR)) {
                this.eZa.jM(false);
            } else {
                this.eZa.jM(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.eZa = subPbModel;
    }

    public void aWj() {
        a(this.eZy);
        this.Hj.setNextPage(this.eZK);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.mv(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aWl() && this.eZN != null && this.eZN.isShown()) {
                i = (this.eZY - this.eZX) - 1;
            } else {
                i = this.eZY - this.eZX;
            }
            int u = v.u(this.eZR);
            if (i > u) {
                i = u;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(v.a(this.eZR, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.eZx.setDatas(arrayList);
            this.eZx.notifyDataSetChanged();
            this.Hj.smoothScrollToPosition(this.eZY + 2);
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
        return this.eEF;
    }

    public void aEQ() {
        if (this.eZL != null) {
            g.a(this.eZL, this.eZy.getPageContext().getPageActivity());
        }
        if (this.eSJ != null) {
            this.eSJ.dismiss();
        }
        if (this.eSz != null) {
            this.eSz.dismiss();
        }
        if (this.eSx != null) {
            g.b(this.eSx, this.eZy.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.eKy != null) {
            this.eKy.dismiss();
        }
    }

    public void aWk() {
        this.Hj.setNextPage(this.eZK);
        this.eZK.wt();
    }

    public void iy(boolean z) {
        this.eHP = z;
    }

    public void setIsFromPb(boolean z) {
        this.eZp = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(m mVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (mVar != null) {
            if (this.eZp && this.eZw != null) {
                this.eZx.jK(true);
                this.eZw.setVisibility(8);
                this.Hj.removeHeaderView(this.eZw);
                this.eZX = 1;
            }
            this.eYb = mVar;
            this.eZx.M(this.eYb.Np());
            if (this.eZw != null) {
                this.eZw.setVisibility(0);
            }
            if (this.eZz != null) {
                this.eZz.setVisibility(0);
            }
            if (mVar.aQy() != null) {
                this.eZQ = mVar.aQy().getId();
                this.aRC = mVar.aQy().buu();
                if (this.aRC > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.eZy.getResources().getString(d.j.subpb_floor_reply_count), am.y(mVar.getTotalCount())));
                    this.cMr.setText(d.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.eZy.aWf()) {
                    str = "PB";
                }
                if (mVar.aQy().rP() != null) {
                    this.eZJ.a(this.eZy.getPageContext(), mVar.aQy().rP(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", mVar.aQF().getId(), mVar.aQF().getName(), mVar.Np().getId(), str));
                } else {
                    this.eZJ.a(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.eZK.wt();
                this.eZx.setHasMoreData(true);
            } else {
                this.eZK.wu();
                this.eZx.setHasMoreData(false);
            }
            this.eZR = mVar.aQC();
            if (v.v(this.eZR)) {
                this.Hj.setNextPage(null);
                if (this.eZp) {
                    this.cMs.setVisibility(0);
                }
            } else {
                this.Hj.setNextPage(this.eZK);
                if (this.eZp) {
                    this.cMs.setVisibility(8);
                }
            }
            if (this.eZR == null || this.eZR.size() <= eZv) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.eZR.size() - eZv;
                qb(size);
                int firstVisiblePosition = this.Hj.getFirstVisiblePosition() - size;
                View childAt = this.Hj.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.eZx.setDatas(this.eZR);
            boolean z2 = false;
            if (mVar.Np() != null && mVar.Np().rt() != null && (userId = mVar.Np().rt().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.eZx.y(i, z2);
            this.eZx.notifyDataSetChanged();
            a(mVar.aQy(), mVar.aAQ(), mVar.nC(), i, z);
            if (i4 > 0) {
                this.Hj.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void qb(int i) {
        if (this.eZR != null) {
            if (this.eZR.size() <= i) {
                this.eZR.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.eZR.iterator();
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

    public boolean aWl() {
        return this.eZx.caG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eZp) {
            this.eHb = postData;
            if (!StringUtils.isNull(postData.buA())) {
                this.eZH.setVisibility(0);
                this.eZH.startLoad(postData.buA(), 10, true);
            } else {
                this.eZH.setVisibility(8);
            }
            h buC = postData.buC();
            if (buC != null && buC.goS) {
                this.eZI.setVisibility(0);
            } else {
                this.eZI.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.eZw.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.eZw.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.eZF.setText((CharSequence) null);
            this.aoE.setText((CharSequence) null);
            this.eRQ.setVisibility(8);
            if (!this.eZp) {
                d(postData.rt());
                if (z) {
                    this.eRQ.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.i(this.eRQ, d.C0080d.cp_link_tip_a);
                }
            }
            this.eIm.setText(am.r(postData.getTime()));
            this.eZF.setText(String.format(this.eZy.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.buu())));
            postData.rt().getUserTbVipInfoData();
            boolean a = a(this.eZG, postData.aEt());
            if (StringUtils.isNull(postData.buA()) && !a && postData.IQ() != null) {
                this.bSJ.setVisibility(0);
                this.bSJ.setTag(postData.IQ());
                return;
            }
            this.bSJ.setVisibility(8);
        }
    }

    private void d(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.aP(metaData.getSealPrefix()) + 2 : 0) + com.baidu.tbadk.util.w.gV(name_show) > 14) {
                name_show = com.baidu.tbadk.util.w.e(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.aoE.setText(ag(metaData.getSealPrefix(), name_show));
            } else {
                this.aoE.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.eZD != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.eZD.setVisibility(8);
                } else {
                    this.eZD.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.QK = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.eZD.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.eSa.setVisibility(0);
                this.eZC.setVisibility(8);
                this.eSa.setUserId(metaData.getUserId());
                this.eSa.setUserName(metaData.getUserName());
                this.eSa.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.aj.i(this.aoE, d.C0080d.cp_cont_r);
            } else {
                this.eSa.setVisibility(8);
                this.eZC.setVisibility(0);
                this.eZC.setUserId(metaData.getUserId());
                this.eZC.setUserName(metaData.getUserName());
                this.eZC.setDefaultResource(d.f.transparent_bg);
                this.eZC.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.eZC.startLoad(metaData.getPortrait(), 28, false);
                com.baidu.tbadk.core.util.aj.i(this.aoE, d.C0080d.cp_cont_c);
            }
            this.eZB.setTag(d.g.tag_user_id, metaData.getUserId());
            this.eZB.setTag(d.g.tag_user_name, metaData.getUserName());
            this.eZB.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.II() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.II().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.IP());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cc(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.bBh());
                        continue;
                    case 17:
                        String str = next.IT().mGifInfo.mSharpText;
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
        if (!tbRichTextData.IY()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.IP() == null || tbRichTextData.IP().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.IP());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eZy.getPageContext().getString(d.j.refresh_view_title_text), this.RF));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.eZy.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.eZz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.f(pageActivity, d.e.ds300), l.f(pageActivity, d.e.ds480), l.f(pageActivity, d.e.ds360)), dVar, a);
        }
        this.eZz.setVisibility(0);
        this.Hj.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.dSd.DG();
        com.baidu.tbadk.core.util.aj.k(this.mNoDataView, d.C0080d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.eZy.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gD(int i) {
        b(NoDataViewFactory.d.D(i, d.j.refresh_view_title_text));
        if (this.eZo != null) {
            this.eZo.bq(this.eEF);
        }
        this.eZT.setVisibility(8);
    }

    public void lc(String str) {
        b(NoDataViewFactory.d.af(str, this.eZy.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.eZo != null) {
            this.eZo.bq(this.eEF);
        }
        this.eZT.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Hj.setVisibility(0);
            this.eZT.setVisibility(0);
            this.eEF.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.RF = onClickListener;
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
                String userId2 = postData.rt().getUserId();
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
            if (this.eYb != null && this.eYb.Np() != null && this.eYb.Np().rt() != null && postData.rt() != null) {
                String userId3 = this.eYb.Np().rt().getUserId();
                String userId4 = postData.rt().getUserId();
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
                    userId = postData.rt().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.buu() != 1 ? 0 : 1;
                    if (ao.k(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rt().getUserName());
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
                        sparseArray.put(d.g.tag_forbid_user_name, postData.rt().getUserName());
                    } else {
                        sparseArray.put(d.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(d.g.tag_user_mute_visible, true);
                        sparseArray.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.rt() != null) {
                            sparseArray.put(d.g.tag_user_mute_mute_userid, postData.rt().getUserId());
                            sparseArray.put(d.g.tag_user_mute_mute_username, postData.rt().getUserName());
                        }
                        if (this.eYb.Np() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.eYb.Np().getId());
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
            userId = postData.rt().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.buu() != 1) {
            }
            if (ao.k(postData)) {
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

    public void jI(boolean z) {
        if (this.eKy != null && this.eKy.aTk() != null) {
            if (z) {
                this.eKy.aTk().setText(d.j.remove_mark);
            } else {
                this.eKy.aTk().setText(d.j.mark);
            }
            this.eKy.refreshUI();
        }
    }

    public View aWm() {
        return this.eZN;
    }

    public void onChangeSkinType(int i) {
        this.eZy.getLayoutMode().ag(i == 1);
        this.eZy.getLayoutMode().t(this.eEF);
        this.eZy.getLayoutMode().t(this.eZw);
        this.mNavigationBar.onChangeSkinType(this.eZy.getPageContext(), i);
        if (this.eZA != null) {
            com.baidu.tbadk.core.util.aj.i(this.eZA, d.C0080d.goto_see_subject_color);
        }
        com.baidu.tbadk.core.util.aj.i(this.cMs, d.C0080d.cp_cont_d);
        this.cuk.onChangeSkinType(this.eZy.getPageContext(), i);
        this.eZy.getLayoutMode().t(this.eZN);
        com.baidu.tbadk.core.util.aj.i(this.eZG, d.C0080d.cp_cont_b);
        this.eZG.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_link_tip_c));
        if (this.dSd != null && this.dSd.CI() != null) {
            this.dSd.CI().onChangeSkinType(i);
        }
        this.eZK.dz(i);
        this.bSJ.bjo();
        com.baidu.tbadk.core.util.aj.i(this.cMr, d.C0080d.cp_cont_e);
        com.baidu.tbadk.core.util.aj.i(this.eRQ, d.C0080d.cp_link_tip_a);
        com.baidu.tbadk.core.util.aj.i(this.aoE, d.C0080d.cp_cont_c);
        this.cMr.setAlpha(0.95f);
        if (this.eZx != null) {
            this.eZx.notifyDataSetChanged();
        }
    }

    public void aWn() {
        this.mProgress.setVisibility(0);
    }

    public void aWo() {
        this.Hj.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eZK.wu();
    }

    public void agP() {
        this.Hj.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.eZK.agP();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axY = onLongClickListener;
        this.eZw.setOnLongClickListener(this.axY);
    }

    public View aWp() {
        return this.eZw;
    }

    public TextView ana() {
        return this.cMr;
    }

    public ImageView aWq() {
        return this.eZU;
    }

    public ImageView aWr() {
        return this.eZV;
    }

    public void pO(String str) {
        int pP = this.eZx.pP(str);
        if (pP > -1) {
            this.eZx.qc(pP);
            if (pP > 2) {
                this.Hj.setSelection(pP - 2);
            } else {
                this.Hj.setSelection(pP);
            }
            this.Hj.invalidate();
        }
    }

    public View aWs() {
        return this.eZA;
    }

    public View aWt() {
        return this.eZH;
    }

    public MorePopupWindow aWu() {
        return this.eZL;
    }

    public void showLoadingDialog() {
        if (this.cbh == null) {
            this.cbh = new com.baidu.tbadk.core.view.a(this.eZy.getPageContext());
        }
        this.cbh.aE(true);
    }

    public void VG() {
        if (this.cbh != null) {
            this.cbh.aE(false);
        }
    }

    public TextView aWv() {
        return this.eZG;
    }

    public void setOnLinkImageClickListener(TbRichTextView.g gVar) {
        this.eZe = gVar;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.eZf = fVar;
    }

    public w aWw() {
        return this.eKy;
    }

    public void alD() {
    }

    public void alE() {
    }

    public void onActivityDestroy() {
    }

    public void aWx() {
        if (this.eZy.acA()) {
        }
    }

    public View aWy() {
        return this.eZB;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, d.f.pic_smalldot_title));
            return com.baidu.tieba.card.m.a((Context) this.eZy.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
