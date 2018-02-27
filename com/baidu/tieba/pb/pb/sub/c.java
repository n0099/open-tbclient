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
    private static final int fZD = TbadkCoreApplication.getInst().getListItemRule().FQ();
    private BdListView auY;
    private NoNetworkView dAL;
    private TextView dQh;
    private TextView dQi;
    private com.baidu.tbadk.core.view.b dgy;
    private View duU;
    private RelativeLayout fFz;
    private x fKZ;
    private k fYi;
    private View fZE;
    private d fZF;
    private NewSubPbActivity fZG;
    private RelativeLayout fZH;
    private View fZL;
    private ThreadSkinView fZR;
    private e fZS;
    private View fZV;
    private ArrayList<PostData> fZZ;
    private SubPbModel fZj;
    private b fZx;
    private String gaa;
    private RelativeLayout gab;
    private ImageView gac;
    private ImageView gad;
    private View.OnClickListener mCommonClickListener;
    private ProgressBar mProgress;
    private h mNoDataView = null;
    private TbRichTextView.h fZo = null;
    private View.OnClickListener aIa = null;
    private TbRichTextView.i fZn = null;
    private NavigationBar mNavigationBar = null;
    private View bgy = null;
    private TextView fZI = null;
    private LinearLayout fZJ = null;
    private HeadImageView fZK = null;
    private ClickableHeaderImageView fTZ = null;
    private TextView beT = null;
    private ImageView fZM = null;
    private TextView fTR = null;
    private TextView fZN = null;
    private TextView fIZ = null;
    private EllipsizeRichTextView fZO = null;
    private TbImageView fZP = null;
    private PlayVoiceBntNew cWQ = null;
    private TextView fZQ = null;
    private MorePopupWindow fZT = null;
    private al fZU = null;
    private com.baidu.tbadk.core.dialog.b fUI = null;
    private Dialog fUx = null;
    private com.baidu.tbadk.core.dialog.a fUz = null;
    private boolean fIC = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener bpn = null;
    private NewSubPbActivity.a fZW = null;
    private NewSubPbActivity.a fZX = null;
    private com.baidu.tbadk.editortools.pb.h eTj = null;
    private String fZY = null;
    private int bKJ = 0;
    private PostData fHW = null;
    private int gae = 0;
    private int gaf = 2;
    private int gag = 0;
    private boolean bsG = true;
    private View.OnClickListener fIH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
                boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                if (booleanValue) {
                    if (!com.baidu.tieba.c.a.akL() || !com.baidu.tieba.c.a.b(c.this.fZG.getBaseContext(), c.this.fZG.getThreadId(), c.this.fZG.getPostId(), c.this.fZG.baF())) {
                        if (booleanValue2) {
                            sparseArray.put(d.g.tag_from, 1);
                            c.this.fZG.c(sparseArray);
                            return;
                        }
                        c.this.cy(view);
                    }
                } else if (booleanValue2) {
                    sparseArray.put(d.g.tag_from, 0);
                    c.this.fZG.c(sparseArray);
                } else if (booleanValue3) {
                    c.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    };
    private com.baidu.tieba.pb.a.c bLG = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.c.2
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            c.this.gh(false);
            c.this.bQ(view);
            c.this.gh(true);
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
    protected AdapterView.OnItemClickListener gah = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.c.9
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ay.ba(c.this.fZG.getPageContext().getPageActivity())) {
                if (c.this.fZx != null) {
                    c.this.fZx.ayi();
                }
                c.this.bgu();
                if (view == null || !(view.getTag() instanceof d.a)) {
                    PostData postData = (PostData) v.f(c.this.fZZ, i);
                    if (postData == null) {
                        c.this.gaa = null;
                    } else {
                        c.this.gaa = postData.getId();
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(d.g.tag_photo_username);
                        String str2 = (String) sparseArray.get(d.g.tag_photo_userid);
                        if (str != null) {
                            c.this.eTj.setReplyId(str2);
                            c.this.eTj.gG(str);
                        }
                    }
                    c.this.bgv();
                    return;
                }
                c.this.bgw();
                c.this.fZj.bgR();
            }
        }
    };

    public c(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.fFz = null;
        this.fZE = null;
        this.auY = null;
        this.fZF = null;
        this.fZG = null;
        this.dAL = null;
        this.fZH = null;
        this.dQi = null;
        this.fZL = null;
        this.fZS = null;
        this.fZV = null;
        this.mCommonClickListener = null;
        this.mProgress = null;
        this.dQh = null;
        this.gab = null;
        this.gac = null;
        this.gad = null;
        this.fZG = newSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.fFz = (RelativeLayout) LayoutInflater.from(this.fZG.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_layout, (ViewGroup) null);
        this.fZE = LayoutInflater.from(this.fZG.getPageContext().getPageActivity()).inflate(d.h.new_sub_pb_head, (ViewGroup) null);
        this.dQi = (TextView) this.fFz.findViewById(d.g.no_reply_list_view);
        this.gab = (RelativeLayout) this.fFz.findViewById(d.g.subpb_editor_tool_comment);
        this.dQh = (TextView) this.fFz.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dQh.setOnClickListener(this.mCommonClickListener);
        this.gac = (ImageView) this.fFz.findViewById(d.g.subpb_editor_tool_more_img);
        this.gad = (ImageView) this.fFz.findViewById(d.g.subpb_editor_tool_emotion_img);
        this.gad.setOnClickListener(this.mCommonClickListener);
        this.gac.setOnClickListener(this.mCommonClickListener);
        this.dAL = (NoNetworkView) this.fFz.findViewById(d.g.view_no_network);
        ayq();
        bgt();
        this.fZH = (RelativeLayout) this.fFz.findViewById(d.g.sub_pb_body_layout);
        this.auY = (BdListView) this.fFz.findViewById(d.g.new_sub_pb_list);
        this.fZR = (ThreadSkinView) LayoutInflater.from(this.fZG.getPageContext().getPageActivity()).inflate(d.h.thread_skin_layout, (ViewGroup) null);
        this.auY.addHeaderView(this.fZR);
        this.auY.addHeaderView(this.fZE);
        this.duU = BdListViewHelper.a(this.fZG.getActivity(), this.auY, BdListViewHelper.HeadType.DEFAULT);
        this.fZF = new d(this.fZG.getPageContext().getPageActivity());
        this.fZF.H(this.fIH);
        this.fZF.setIsFromCDN(this.mIsFromCDN);
        this.fZF.lf(true);
        this.auY.setAdapter((ListAdapter) this.fZF);
        this.fZS = new e(this.fZG.getPageContext());
        this.fZV = this.fZS.getView();
        this.auY.setNextPage(this.fZS);
        this.fZS.setOnClickListener(this.mCommonClickListener);
        this.auY.setOnItemClickListener(this.gah);
        this.auY.setOnTouchListener(this.bLG);
        this.mProgress = (ProgressBar) this.fFz.findViewById(d.g.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fZE != null) {
            this.fZE.setVisibility(4);
        }
        if (this.fZH != null) {
            this.fZH.setVisibility(4);
        }
        this.fZL = com.baidu.tbadk.ala.b.vL().u(this.fZG.getActivity(), 4);
        if (this.fZL != null) {
            this.fZL.setVisibility(8);
            this.fZJ.addView(this.fZL, 3);
        }
    }

    public ListView getListView() {
        return this.auY;
    }

    public void bgt() {
        this.fZJ = (LinearLayout) this.fZE.findViewById(d.g.subpb_head_user_info_root);
        this.fZJ.setOnClickListener(this.mCommonClickListener);
        this.fZK = (HeadImageView) this.fZE.findViewById(d.g.photo);
        this.fZK.setRadius(l.t(this.fZG.getActivity(), d.e.ds30));
        this.fZK.setClickable(false);
        this.fTZ = (ClickableHeaderImageView) this.fZE.findViewById(d.g.god_user_photo);
        this.fTZ.setGodIconMargin(0);
        this.fTZ.setGodIconWidth(d.e.ds24);
        this.fTZ.setRadius(l.t(this.fZG.getActivity(), d.e.ds30));
        this.fTZ.setClickable(false);
        this.beT = (TextView) this.fZE.findViewById(d.g.user_name);
        this.fZM = (ImageView) this.fZE.findViewById(d.g.user_rank);
        this.fZM.setVisibility(8);
        this.fTR = (TextView) this.fZE.findViewById(d.g.floor_owner);
        this.fZI = (TextView) this.fZE.findViewById(d.g.see_subject);
        this.fZI.setOnClickListener(this.mCommonClickListener);
        this.fZN = (TextView) this.fZE.findViewById(d.g.floor);
        this.fIZ = (TextView) this.fZE.findViewById(d.g.time);
        this.fZO = (EllipsizeRichTextView) this.fZE.findViewById(d.g.content_text);
        this.fZO.setOnClickListener(this.mCommonClickListener);
        aj.r(this.fZO, d.C0141d.cp_cont_b);
        this.fZO.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
        this.fZO.setLineSpacing(0.0f, 1.25f);
        this.fZP = (TbImageView) this.fZE.findViewById(d.g.sub_pb_image);
        this.fZP.setOnClickListener(this.mCommonClickListener);
        this.fZQ = (TextView) this.fZE.findViewById(d.g.advert);
        this.cWQ = (PlayVoiceBntNew) this.fZE.findViewById(d.g.voice_btn);
        this.fZE.setOnTouchListener(this.bLG);
        this.fZE.setOnClickListener(this.mCommonClickListener);
    }

    public void gj(boolean z) {
        if (this.duU != null && this.duU.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.duU.getLayoutParams();
            if (z) {
                ayu();
                layoutParams.height = l.t(this.fZG.getPageContext().getPageActivity(), d.e.ds88);
            } else {
                layoutParams.height = l.t(this.fZG.getPageContext().getPageActivity(), d.e.ds88) + UtilHelper.getLightStatusBarHeight();
            }
            this.duU.setLayoutParams(layoutParams);
        }
    }

    private void ayu() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public View ayv() {
        return this.duU;
    }

    public void ayq() {
        int t = l.t(this.fZG.getPageContext().getPageActivity(), d.e.ds88);
        int t2 = l.t(this.fZG.getPageContext().getPageActivity(), d.e.ds14);
        this.mNavigationBar = (NavigationBar) this.fFz.findViewById(d.g.view_navigation_bar);
        this.bgy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bgy.getLayoutParams();
            layoutParams.height = t;
            layoutParams.width = t;
            layoutParams.leftMargin = t2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.bgy != null && (this.bgy.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bgy.getLayoutParams();
            layoutParams2.width = t;
            layoutParams2.height = t;
            this.bgy.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
        this.mNavigationBar.showBottomLine();
    }

    public NavigationBar avj() {
        return this.mNavigationBar;
    }

    public void cy(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.fUx == null) {
            this.fUx = new Dialog(this.fZG.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fUx.setCanceledOnTouchOutside(true);
            this.fUx.setCancelable(true);
            View inflate = LayoutInflater.from(this.fZG.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
            this.fZG.getLayoutMode().aM(inflate);
            this.fUx.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.fUx.getWindow().getAttributes();
            attributes.width = (int) (l.ao(this.fZG.getPageContext().getPageActivity()) * 0.9d);
            this.fUx.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fUx.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fUx.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fUx.findViewById(d.g.disable_reply_btn);
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
                    if (c.this.fUx != null && (c.this.fUx instanceof Dialog)) {
                        g.b(c.this.fUx, c.this.fZG.getPageContext());
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
                    if (c.this.fUx != null && (c.this.fUx instanceof Dialog)) {
                        g.b(c.this.fUx, c.this.fZG.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && c.this.fZW != null) {
                        c.this.fZW.ak(new Object[]{sparseArray4.get(d.g.tag_manage_user_identity), sparseArray4.get(d.g.tag_forbid_user_name), sparseArray4.get(d.g.tag_forbid_user_post_id)});
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
                    if (c.this.fUx != null && (c.this.fUx instanceof Dialog)) {
                        g.b(c.this.fUx, c.this.fZG.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        c.this.fZG.a(z, (String) sparseArray5.get(d.g.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.fUx, this.fZG.getPageContext());
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
        this.fUz = new com.baidu.tbadk.core.dialog.a(this.fZG.getPageContext().getPageActivity());
        this.fUz.fb(i3);
        this.fUz.aE(sparseArray);
        this.fUz.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (c.this.fZX != null) {
                    c.this.fZX.ak(new Object[]{sparseArray.get(d.g.tag_del_post_id), sparseArray.get(d.g.tag_manage_user_identity), sparseArray.get(d.g.tag_del_post_is_self), sparseArray.get(d.g.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.fUz.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.c.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fUz.aZ(true);
        this.fUz.b(this.fZG.getPageContext());
        this.fUz.AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(final boolean z) {
        if (this.auY != null) {
            if (!z) {
                this.auY.setEnabled(z);
            } else {
                this.auY.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.c.8
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.auY.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void b(b.InterfaceC0097b interfaceC0097b, boolean z) {
        String string;
        if (this.fUI != null) {
            this.fUI.dismiss();
            this.fUI = null;
        }
        if (z) {
            string = this.fZG.getResources().getString(d.j.remove_mark);
        } else {
            string = this.fZG.getResources().getString(d.j.mark);
        }
        this.fUI = new com.baidu.tbadk.core.dialog.b(this.fZG.getPageContext().getPageActivity());
        this.fUI.fe(d.j.operation);
        this.fUI.a(new String[]{this.fZG.getResources().getString(d.j.copy), string}, interfaceC0097b);
        this.fUI.d(this.fZG.getPageContext());
        this.fUI.AX();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.fZW = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.fZX = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.fZG.showToast(this.fZG.getResources().getString(d.j.delete_success));
        } else if (str != null && z2) {
            this.fZG.showToast(str);
        }
    }

    public void bQ(View view) {
        if (this.duU != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.duU.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.auY != null) {
                    this.auY.removeHeaderView(this.duU);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.duU.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.t(this.fZG.getActivity(), d.e.ds98)));
            } else if (this.auY != null) {
                this.auY.addHeaderView(this.duU, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void g(com.baidu.tbadk.editortools.pb.h hVar) {
        if (hVar != null && hVar.Lb() != null) {
            this.eTj = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.fFz.addView(hVar.Lb(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.fZx = bVar;
    }

    public void bgu() {
        if (this.auY != null) {
            this.gag = this.auY.getLastVisiblePosition();
        }
    }

    public void bgv() {
        if (this.fZj != null) {
            if ((!bgy() && this.fZV != null && this.fZV.isShown()) || v.E(this.fZZ)) {
                this.fZj.li(false);
            } else {
                this.fZj.li(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.fZj = subPbModel;
    }

    public void bgw() {
        a(this.fZG);
        this.auY.setNextPage(this.fZS);
    }

    public void n(PostData postData) {
        int i;
        if (postData != null) {
            postData.mI(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!bgy() && this.fZV != null && this.fZV.isShown()) {
                i = (this.gag - this.gaf) - 1;
            } else {
                i = this.gag - this.gaf;
            }
            int D = v.D(this.fZZ);
            if (i > D) {
                i = D;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(v.b(this.fZZ, 0, i));
            v.b(arrayList, postData2);
            v.b(arrayList, postData);
            this.fZF.setDatas(arrayList);
            this.fZF.notifyDataSetChanged();
            this.auY.smoothScrollToPosition(this.gag + 2);
            this.auY.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.auY.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.auY.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.fFz;
    }

    public void bfu() {
        if (this.fZT != null) {
            g.a(this.fZT, this.fZG.getPageContext().getPageActivity());
        }
        if (this.fUI != null) {
            this.fUI.dismiss();
        }
        if (this.fUz != null) {
            this.fUz.dismiss();
        }
        if (this.fUx != null) {
            g.b(this.fUx, this.fZG.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.fKZ != null) {
            this.fKZ.dismiss();
        }
    }

    public void bgx() {
        this.auY.setNextPage(this.fZS);
        this.fZS.Ef();
    }

    public void jP(boolean z) {
        this.fIC = z;
    }

    public void setIsFromPb(boolean z) {
        this.bsG = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(k kVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (kVar != null) {
            if (this.bsG && this.fZE != null) {
                this.fZF.lg(true);
                this.fZE.setVisibility(8);
                this.auY.removeHeaderView(this.fZE);
                this.gaf = 1;
            }
            this.fYi = kVar;
            this.fZF.T(this.fYi.WD());
            if (this.fZE != null) {
                this.fZE.setVisibility(0);
            }
            if (this.fZH != null) {
                this.fZH.setVisibility(0);
            }
            if (kVar.bbc() != null) {
                this.fZY = kVar.bbc().getId();
                this.bKJ = kVar.bbc().bwT();
                if (this.bKJ > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.fZG.getResources().getString(d.j.subpb_floor_reply_count), am.H(kVar.getTotalCount())));
                    this.dQh.setText(d.j.say_your_point);
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.fZG.bgs()) {
                    str = "PB";
                }
                if (kVar.bbc().zJ() != null) {
                    this.fZR.a(this.fZG.getPageContext(), kVar.bbc().zJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", kVar.bbj().getId(), kVar.bbj().getName(), kVar.WD().getId(), str));
                } else {
                    this.fZR.a(null, null, null);
                }
            }
            if (kVar.hasMore()) {
                this.fZS.Ef();
                this.fZF.setHasMoreData(true);
            } else {
                this.fZS.Eg();
                this.fZF.setHasMoreData(false);
            }
            this.fZZ = kVar.bbg();
            if (v.E(this.fZZ)) {
                this.auY.setNextPage(null);
                if (this.bsG) {
                    this.dQi.setVisibility(0);
                }
            } else {
                this.auY.setNextPage(this.fZS);
                if (this.bsG) {
                    this.dQi.setVisibility(8);
                }
            }
            if (this.fZZ == null || this.fZZ.size() <= fZD) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.fZZ.size() - fZD;
                tl(size);
                int firstVisiblePosition = this.auY.getFirstVisiblePosition() - size;
                View childAt = this.auY.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.fZF.setDatas(this.fZZ);
            boolean z2 = false;
            if (kVar.WD() != null && kVar.WD().zn() != null && (userId = kVar.WD().zn().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.fZF.P(i, z2);
            this.fZF.notifyDataSetChanged();
            a(kVar.bbc(), kVar.aLp(), kVar.vX(), i, z);
            if (i4 > 0) {
                this.auY.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void tl(int i) {
        if (this.fZZ != null) {
            if (this.fZZ.size() <= i) {
                this.fZZ.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.fZZ.iterator();
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

    public boolean bgy() {
        return this.fZF.dfL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.bsG) {
            this.fHW = postData;
            if (!StringUtils.isNull(postData.bxb())) {
                this.fZP.setVisibility(0);
                this.fZP.startLoad(postData.bxb(), 10, true);
            } else {
                this.fZP.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.h bxd = postData.bxd();
            if (bxd != null && bxd.haj) {
                this.fZQ.setVisibility(0);
            } else {
                this.fZQ.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.fZE.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.fZE.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(d.g.tag_clip_board, postData);
            sparseArray.put(d.g.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.fZN.setText((CharSequence) null);
            this.beT.setText((CharSequence) null);
            this.fTR.setVisibility(8);
            if (!this.bsG) {
                c(postData.zn());
                if (z) {
                    this.fTR.setVisibility(0);
                    aj.r(this.fTR, d.C0141d.cp_link_tip_a);
                }
            }
            this.fIZ.setText(am.z(postData.getTime()));
            this.fZN.setText(String.format(this.fZG.getPageContext().getString(d.j.is_floor), Integer.valueOf(postData.bwT())));
            postData.zn().getUserTbVipInfoData();
            boolean a = a(this.fZO, postData.bwW());
            if (StringUtils.isNull(postData.bxb()) && !a && postData.Rp() != null) {
                this.cWQ.setVisibility(0);
                this.cWQ.setTag(postData.Rp());
                return;
            }
            this.cWQ.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.k.aX(metaData.getSealPrefix()) + 2 : 0) + w.hs(name_show) > 14) {
                name_show = w.j(name_show, 0, 14) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.beT.setText(af(metaData.getSealPrefix(), name_show));
            } else {
                this.beT.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.fZL != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.fZL.setVisibility(8);
                } else {
                    this.fZL.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.aGT = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.fZL.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.fTZ.setVisibility(0);
                this.fZK.setVisibility(8);
                this.fTZ.setUserId(metaData.getUserId());
                this.fTZ.setUserName(metaData.getUserName());
                this.fTZ.startLoad(metaData.getPortrait(), 28, false);
                aj.r(this.beT, d.C0141d.cp_cont_r);
            } else {
                this.fTZ.setVisibility(8);
                this.fZK.setVisibility(0);
                this.fZK.setUserId(metaData.getUserId());
                this.fZK.setUserName(metaData.getUserName());
                this.fZK.setDefaultResource(d.f.transparent_bg);
                this.fZK.setDefaultErrorResource(d.f.icon_default_avatar100);
                this.fZK.startLoad(metaData.getPortrait(), 28, false);
                aj.r(this.beT, d.C0141d.cp_cont_c);
            }
            this.fZJ.setTag(d.g.tag_user_id, metaData.getUserId());
            this.fZJ.setTag(d.g.tag_user_name, metaData.getUserName());
            this.fZJ.setTag(d.g.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Rh() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Rh().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.Ro());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cN(true);
                        textView.setMovementMethod(com.baidu.tieba.view.e.bEL());
                        continue;
                    case 17:
                        String str = next.Rs().mGifInfo.mSharpText;
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
        if (!tbRichTextData.Rx()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.Ro() == null || tbRichTextData.Ro().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.Ro());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.fZG.getPageContext().getString(d.j.refresh_view_title_text), this.aIa));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.fZG.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.fZH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, d.f.pic_emotion07, l.t(pageActivity, d.e.ds250), l.t(pageActivity, d.e.ds480), l.t(pageActivity, d.e.ds360)), dVar, a);
        }
        this.fZH.setVisibility(0);
        this.auY.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.eTj.LW();
        aj.t(this.mNoDataView, d.C0141d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.fZG.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void lc(int i) {
        b(NoDataViewFactory.d.aC(i, d.j.refresh_view_title_text));
        if (this.fZx != null) {
            this.fZx.cB(this.fFz);
        }
        this.gab.setVisibility(8);
    }

    public void lS(String str) {
        b(NoDataViewFactory.d.ae(str, this.fZG.getPageContext().getString(d.j.refresh_view_title_text)));
        if (this.fZx != null) {
            this.fZx.cB(this.fFz);
        }
        this.gab.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.auY.setVisibility(0);
            this.gab.setVisibility(0);
            this.fFz.setOnTouchListener(null);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.aIa = onClickListener;
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
            if (this.fYi != null && this.fYi.WD() != null && this.fYi.WD().zn() != null && postData.zn() != null) {
                String userId3 = this.fYi.WD().zn().getUserId();
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
                    int i2 = postData.bwT() != 1 ? 0 : 1;
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
                        if (this.fYi.WD() != null) {
                            sparseArray.put(d.g.tag_user_mute_thread_id, this.fYi.WD().getId());
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
            if (postData.bwT() != 1) {
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

    public void le(boolean z) {
        if (this.fKZ != null && this.fKZ.bdX() != null) {
            if (z) {
                this.fKZ.bdX().setText(d.j.remove_mark);
            } else {
                this.fKZ.bdX().setText(d.j.mark);
            }
            this.fKZ.refreshUI();
        }
    }

    public View bgz() {
        return this.fZV;
    }

    public void onChangeSkinType(int i) {
        this.fZG.getLayoutMode().aQ(i == 1);
        this.fZG.getLayoutMode().aM(this.fFz);
        this.fZG.getLayoutMode().aM(this.fZE);
        this.mNavigationBar.onChangeSkinType(this.fZG.getPageContext(), i);
        if (this.fZI != null) {
            aj.r(this.fZI, d.C0141d.goto_see_subject_color);
        }
        aj.r(this.dQi, d.C0141d.cp_cont_d);
        this.dAL.onChangeSkinType(this.fZG.getPageContext(), i);
        this.fZG.getLayoutMode().aM(this.fZV);
        aj.r(this.fZO, d.C0141d.cp_cont_b);
        this.fZO.setLinkTextColor(aj.getColor(d.C0141d.cp_link_tip_c));
        if (this.eTj != null && this.eTj.Lb() != null) {
            this.eTj.Lb().onChangeSkinType(i);
        }
        this.fZS.gx(i);
        this.cWQ.aNQ();
        aj.r(this.dQh, d.C0141d.cp_cont_e);
        aj.r(this.fTR, d.C0141d.cp_link_tip_a);
        aj.r(this.beT, d.C0141d.cp_cont_c);
        this.dQh.setAlpha(0.95f);
        if (this.fZF != null) {
            this.fZF.notifyDataSetChanged();
        }
    }

    public void bgA() {
        this.mProgress.setVisibility(0);
    }

    public void bgB() {
        this.auY.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fZS.Eg();
    }

    public void asu() {
        this.auY.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.fZS.asu();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bpn = onLongClickListener;
        this.fZE.setOnLongClickListener(this.bpn);
    }

    public View bgC() {
        return this.fZE;
    }

    public TextView ayw() {
        return this.dQh;
    }

    public ImageView bgD() {
        return this.gac;
    }

    public ImageView bgE() {
        return this.gad;
    }

    public void qI(String str) {
        int qJ = this.fZF.qJ(str);
        if (qJ > -1) {
            this.fZF.tm(qJ);
            if (qJ > 2) {
                this.auY.setSelection(qJ - 2);
            } else {
                this.auY.setSelection(qJ);
            }
            this.auY.invalidate();
        }
    }

    public View bgF() {
        return this.fZI;
    }

    public View bgG() {
        return this.fZP;
    }

    public MorePopupWindow bgH() {
        return this.fZT;
    }

    public void showLoadingDialog() {
        if (this.dgy == null) {
            this.dgy = new com.baidu.tbadk.core.view.b(this.fZG.getPageContext());
        }
        this.dgy.bq(true);
    }

    public void agf() {
        if (this.dgy != null) {
            this.dgy.bq(false);
        }
    }

    public TextView bgI() {
        return this.fZO;
    }

    public void setOnLinkImageClickListener(TbRichTextView.i iVar) {
        this.fZn = iVar;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.fZo = hVar;
    }

    public x bgJ() {
        return this.fKZ;
    }

    public void axB() {
    }

    public void axC() {
    }

    public void onActivityDestroy() {
    }

    public void bgK() {
        if (this.fZG.isPaused()) {
        }
    }

    public View bgL() {
        return this.fZJ;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new j.a(str, d.f.pic_smalldot_title));
            return j.a((Context) this.fZG.getActivity(), str2, (ArrayList<j.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
