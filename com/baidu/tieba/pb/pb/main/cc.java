package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Rect;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.c.a;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class cc {
    private com.baidu.tbadk.editortools.j KA;
    private NoNetworkView aMQ;
    private BdTypeListView aVg;
    private View.OnClickListener aWQ;
    private p.a aez;
    private View awp;
    private RelativeLayout ccn;
    private View.OnClickListener cgR;
    private com.baidu.tieba.pb.b.c cgS;
    PbActivity.b ciD;
    private PbActivity ciU;
    private TextView ckA;
    private View ckE;
    private View ckG;
    private RelativeLayout ckH;
    private bd ckI;
    private PbListView ckN;
    private View ckP;
    private View ckk;
    public final com.baidu.tieba.pb.pb.main.b.c ckl;
    private List<com.baidu.tieba.pb.pb.main.b.a> ckm;
    private View ckn;
    private ColumnLayout ckp;
    private TextView ckq;
    private TextView ckr;
    private HeadImageView cks;
    private ImageView ckt;
    private ImageView cku;
    private ImageView ckv;
    private UserIconBox ckw;
    private UserIconBox ckx;
    private ImageView cky;
    private TextView ckz;
    private LiveBroadcastCard clA;
    private View clB;
    private TextView clC;
    private PbActivity.a clG;
    private View clo;
    private TextView clp;
    private TextView clq;
    private TextView clr;
    private boolean clt;
    private View clz;
    private View cko = null;
    public FrsPraiseView ckB = null;
    private View ckC = null;
    private View ckD = null;
    private View ckF = null;
    private com.baidu.tbadk.core.dialog.a ckJ = null;
    private com.baidu.tbadk.core.dialog.c aWG = null;
    private View ckK = null;
    private EditText ckL = null;
    private com.baidu.tieba.pb.view.e ckM = null;
    private com.baidu.tieba.pb.view.b ckO = null;
    private c.b bBC = null;
    private TbRichTextView.c aCn = null;
    private NoNetworkView.a aSa = null;
    private Dialog ckQ = null;
    private View ckR = null;
    private com.baidu.tbadk.core.dialog.a ckS = null;
    private Dialog ckT = null;
    private View ckU = null;
    private int ckV = 0;
    private RadioGroup MS = null;
    private RadioButton ckW = null;
    private RadioButton ckX = null;
    private RadioButton ckY = null;
    private Button ckZ = null;
    private Button cla = null;
    private TextView clb = null;
    private Dialog clc = null;
    private View cld = null;
    private LinearLayout cle = null;
    private CompoundButton.OnCheckedChangeListener clf = null;
    private TextView clg = null;
    private TextView clh = null;
    private String cli = null;
    private com.baidu.tbadk.core.dialog.c clj = null;
    private boolean clk = false;
    private String mForumName = null;
    private ScrollView cll = null;
    private boolean clm = false;
    private Button cln = null;
    private boolean cls = true;
    private LinearLayout clu = null;
    private TextView clv = null;
    private TextView clw = null;
    private View aDY = null;
    private com.baidu.tbadk.core.view.a clx = null;
    private boolean cgM = false;
    private boolean cly = false;
    private boolean mIsFromCDN = true;
    private boolean clD = true;
    private a.InterfaceC0074a clE = new cd(this);
    private final View.OnClickListener clF = new cm(this);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean clH = true;
    private final List<TbImageView> clI = new ArrayList();
    private boolean cgL = true;

    public NoNetworkView agm() {
        return this.aMQ;
    }

    public void agn() {
        if (this.KA != null) {
            this.KA.hide();
        }
    }

    public void ago() {
        this.cls = true;
        if (this.KA != null) {
            this.KA.hide();
        }
        if (this.clo != null) {
            if (this.clm) {
                eE(false);
            } else {
                eF(false);
            }
        }
    }

    public void eE(boolean z) {
        if (this.clo != null && this.clp != null && this.clq != null) {
            this.clp.setText(i.h.draft_to_send);
            this.clq.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.clo.startAnimation(alphaAnimation);
            }
            this.clo.setVisibility(0);
        }
    }

    public void eF(boolean z) {
        if (this.clo != null && this.clp != null && this.clq != null) {
            this.clp.setText(i.h.reply_floor_host);
            this.clq.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.clo.startAnimation(alphaAnimation);
            }
            this.clo.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.k agp() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.aVg == null) {
            return null;
        }
        int firstVisiblePosition = this.aVg.getFirstVisiblePosition();
        int lastVisiblePosition = this.aVg.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.aVg.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.aVg.getChildAt(i4 - firstVisiblePosition)) != null) {
                    childAt.getGlobalVisibleRect(rect);
                    iArr[i4 - firstVisiblePosition] = rect.height();
                }
                i3 += iArr[i4 - firstVisiblePosition];
            }
            int i5 = i3 / 2;
            int i6 = 0;
            for (int i7 = 0; i7 < iArr.length; i7++) {
                i6 += iArr[i7];
                if (i6 > i5) {
                    i = i7 + firstVisiblePosition;
                    break;
                }
            }
        }
        i = firstVisiblePosition;
        int headerViewsCount = i - this.aVg.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.ckI.iK(headerViewsCount) != null && this.ckI.iK(headerViewsCount) != com.baidu.tieba.tbadkCore.data.k.cZf) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.k) this.ckI.aA(i2);
    }

    public cc(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.b.c cVar) {
        this.ciU = null;
        this.ccn = null;
        this.ckk = null;
        this.aVg = null;
        this.ckn = null;
        this.ckp = null;
        this.ckq = null;
        this.ckr = null;
        this.cks = null;
        this.ckt = null;
        this.cku = null;
        this.ckv = null;
        this.ckw = null;
        this.ckx = null;
        this.cky = null;
        this.ckz = null;
        this.ckA = null;
        this.ckE = null;
        this.ckG = null;
        this.ckI = null;
        this.ckN = null;
        this.awp = null;
        this.aWQ = null;
        this.cgR = null;
        this.clo = null;
        this.clp = null;
        this.clr = null;
        this.clB = null;
        this.clC = null;
        this.ciU = pbActivity;
        this.aWQ = onClickListener;
        this.cgS = cVar;
        this.ccn = (RelativeLayout) LayoutInflater.from(this.ciU.getPageContext().getPageActivity()).inflate(i.g.new_pb_activity, (ViewGroup) null);
        this.ciU.addContentView(this.ccn, new FrameLayout.LayoutParams(-1, -1));
        this.ckk = this.ciU.findViewById(i.f.statebar_view);
        this.ckH = (RelativeLayout) this.ciU.findViewById(i.f.title_wrapper);
        this.aMQ = (NoNetworkView) this.ciU.findViewById(i.f.view_no_network);
        this.aVg = (BdTypeListView) this.ciU.findViewById(i.f.new_pb_list);
        View view = new View(this.ciU.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.ciU.getResources().getDimensionPixelSize(i.d.pb_editor_height)));
        this.aVg.addFooterView(view);
        this.ckl = new com.baidu.tieba.pb.pb.main.b.c(pbActivity);
        this.ckl.agU().setOnTouchListener(new com.baidu.tieba.pb.b.a(new cp(this)));
        this.clo = this.ciU.findViewById(i.f.pb_editor_tool_comment);
        this.clp = (TextView) this.ciU.findViewById(i.f.pb_editor_tool_comment_reply_text);
        this.clr = (TextView) this.ciU.findViewById(i.f.pb_editor_tool_comment_praise_icon);
        this.clq = (TextView) this.ciU.findViewById(i.f.pb_editor_tool_comment_reply_count_text);
        this.clp.setOnClickListener(new cq(this));
        this.clr.setOnClickListener(this.aWQ);
        this.clr.setOnTouchListener(this.ciU);
        this.ckn = LayoutInflater.from(this.ciU.getPageContext().getPageActivity()).inflate(i.g.new_pb_header_item, (ViewGroup) null);
        this.ckp = (ColumnLayout) this.ckn.findViewById(i.f.pb_head_owner_root);
        this.ckp.setOnLongClickListener(this.onLongClickListener);
        this.ckp.setOnTouchListener(this.cgS);
        this.ckp.setVisibility(8);
        this.ckn.setOnTouchListener(this.cgS);
        this.ckq = (TextView) this.ckn.findViewById(i.f.pb_head_post_title);
        this.ckq.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.ckq.setVisibility(8);
        this.clB = this.ckn.findViewById(i.f.pb_head_activity_join_number_container);
        this.clB.setVisibility(8);
        this.clC = (TextView) this.ckn.findViewById(i.f.pb_head_activity_join_number);
        this.ckr = (TextView) this.ckp.findViewById(i.f.pb_head_owner_info_user_name);
        this.cks = (HeadImageView) this.ckp.findViewById(i.f.pb_head_owner_photo);
        if (!this.cgL) {
            this.cks.setVisibility(8);
        }
        this.ckt = (ImageView) this.ckp.findViewById(i.f.pb_head_owner_info_user_rank);
        this.cku = (ImageView) this.ckp.findViewById(i.f.pb_head_owner_info_user_gender);
        this.ckv = (ImageView) this.ckp.findViewById(i.f.pb_head_owner_info_user_bawu);
        this.ckw = (UserIconBox) this.ckp.findViewById(i.f.pb_head_owner_info_user_icon);
        this.ckx = (UserIconBox) this.ckp.findViewById(i.f.pb_head_owner_info_tshow_icon);
        this.cky = (ImageView) this.ckp.findViewById(i.f.pb_head_owner_info_floor_owner);
        this.ckz = (TextView) this.ckp.findViewById(i.f.pb_head_owner_info_time);
        this.ckA = (TextView) this.ckn.findViewById(i.f.pb_head_reverse_hint);
        this.ckA.setOnClickListener(this.aWQ);
        this.ckA.setVisibility(8);
        this.ckE = this.ckn.findViewById(i.f.new_pb_header_item_line_below_livepost);
        this.ckG = this.ckn.findViewById(i.f.new_pb_header_item_line_above_showpassed);
        this.ckn.setOnLongClickListener(new cr(this));
        agt();
        this.ckI = new bd(this.ciU, this.aVg);
        this.ckI.C(this.aWQ);
        this.ckI.a(this.cgS);
        this.ckI.setOnImageClickListener(this.aCn);
        this.cgR = new cs(this);
        this.ckI.B(this.cgR);
        this.aVg.addHeaderView(this.ckn);
        this.ckN = new PbListView(this.ciU.getPageContext().getPageActivity());
        this.awp = this.ckN.getView().findViewById(i.f.pb_more_view);
        if (this.awp != null) {
            this.awp.setOnClickListener(this.aWQ);
            com.baidu.tbadk.core.util.an.i(this.awp, i.e.pb_foot_more_trans_selector);
        }
        this.ckN.vx();
        this.ckN.cL(i.e.pb_foot_more_trans_selector);
        this.ckN.cM(i.e.pb_foot_more_trans_selector);
        this.ckP = this.ciU.findViewById(i.f.viewstub_progress);
    }

    public void eG(boolean z) {
        this.ckl.eG(z);
        if (z && this.cly) {
            this.ckN.setText(this.ciU.getResources().getString(i.h.click_load_more));
            this.aVg.setNextPage(this.ckN);
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.KA = jVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.ccn.addView(this.KA, layoutParams);
        this.KA.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.KA.hide();
    }

    public void agq() {
        if (this.ciU != null && this.KA != null) {
            this.KA.ow();
        }
    }

    public void jP(String str) {
        if (this.clq != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.clq.setText(this.ciU.getPageContext().getResources().getString(i.h.pb_reply_count_text, str));
        }
    }

    public void C(String str, boolean z) {
        this.clt = z;
        eH(TbadkCoreApplication.m411getInst().getSkinType() == 1);
    }

    private void eH(boolean z) {
        if (this.clr != null) {
            if (this.clt) {
                com.baidu.tbadk.core.util.an.i((View) this.clr, i.e.pb_praise_already_click_selector);
            } else {
                com.baidu.tbadk.core.util.an.i((View) this.clr, i.e.pb_praise_normal_click_selector);
            }
        }
    }

    public TextView agr() {
        return this.clr;
    }

    public void eI(boolean z) {
        if (this.aVg != null) {
            if (!z) {
                this.aVg.setEnabled(z);
            } else {
                this.aVg.postDelayed(new ct(this, z), 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ckk.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.ckk.setLayoutParams(layoutParams);
            this.ckk.setVisibility(0);
            return;
        }
        this.ckk.setVisibility(8);
    }

    public void ab(View view) {
        boolean z;
        View view2;
        if (this.ckH != null && view != null) {
            if (this.cls) {
                z = this.clo.getVisibility() == 0;
            } else {
                z = this.KA != null && this.KA.getVisibility() == 0;
            }
            boolean z2 = this.ckH.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                View findViewById = this.ciU.findViewById(i.f.bg_above_list);
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.ckH.getHeight()));
                com.baidu.tieba.tbadkCore.a.a(this.ciU, this.ckH, i.a.top_fold_up, new cu(this, findViewById));
            } else {
                com.baidu.tieba.tbadkCore.a.a(this.ciU, this.ckH, i.a.top_fold_down, new cv(this));
            }
            if (this.cls) {
                view2 = this.clo;
            } else {
                view2 = this.KA;
            }
            if (z) {
                if (z2) {
                    if (this.KA != null) {
                        this.KA.za();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.ciU, view2, i.a.bottom_fold_down, new ce(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.ciU, view2, i.a.bottom_fold_up, new cf(this));
            }
        }
    }

    public bd ags() {
        return this.ckI;
    }

    public void a(PbActivity.b bVar) {
        this.ciD = bVar;
    }

    private void a(com.baidu.tbadk.core.data.z zVar) {
        if (zVar == null || zVar.sL() == 0) {
            if (this.cln != null) {
                this.cln.setVisibility(8);
            }
            if (this.ckD != null) {
                this.ckD.setVisibility(8);
                return;
            }
            return;
        }
        if (this.cln == null) {
            this.ciU.getLayoutMode().k(((ViewStub) this.ckn.findViewById(i.f.live_talk_layout)).inflate());
            this.cln = (Button) this.ckn.findViewById(i.f.pb_head_function_manage_go_to_live_post);
            this.ckD = this.ckn.findViewById(i.f.new_pb_header_item_line_above_livepost);
        }
        int sM = zVar.sM();
        String string = this.ciU.getPageContext().getString(i.h.go_to_live_post_prefix);
        if (sM == 0) {
            string = String.valueOf(string) + this.ciU.getPageContext().getString(i.h.go_to_interview_post);
        } else if (sM == 1) {
            string = String.valueOf(string) + this.ciU.getPageContext().getString(i.h.go_to_discuss_post);
        }
        this.cln.setText(string);
        this.cln.setVisibility(0);
        this.cln.setOnClickListener(this.aWQ);
        agE();
    }

    private void agt() {
        this.clu = (LinearLayout) this.ckn.findViewById(i.f.btn_show_passed_pb);
        this.clw = (TextView) this.ckn.findViewById(i.f.show_pre_page_view);
        this.clv = (TextView) this.ckn.findViewById(i.f.go_back_top_view);
        this.aDY = this.ckn.findViewById(i.f.show_passed_divider);
        this.clw.setOnClickListener(this.clF);
        this.clv.setOnClickListener(this.aWQ);
        agE();
    }

    public void ac(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.ckR == null) {
            this.ckR = LayoutInflater.from(this.ciU.getPageContext().getPageActivity()).inflate(i.g.forum_manage_dialog, (ViewGroup) null);
        }
        this.ciU.getLayoutMode().k(this.ckR);
        if (this.ckQ == null) {
            this.ckQ = new Dialog(this.ciU.getPageContext().getPageActivity(), i.C0057i.common_alert_dialog);
            this.ckQ.setCanceledOnTouchOutside(true);
            this.ckQ.setCancelable(true);
            this.ckQ.setContentView(this.ckR);
            WindowManager.LayoutParams attributes = this.ckQ.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.ciU.getPageContext().getPageActivity()) * 0.9d);
            this.ckQ.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ckQ.findViewById(i.f.del_post_btn);
        TextView textView2 = (TextView) this.ckQ.findViewById(i.f.forbid_user_btn);
        TextView textView3 = (TextView) this.ckQ.findViewById(i.f.disable_reply_btn);
        if ("".equals(sparseArray.get(i.f.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(i.f.tag_del_post_id, sparseArray.get(i.f.tag_del_post_id));
            sparseArray2.put(i.f.tag_del_post_type, sparseArray.get(i.f.tag_del_post_type));
            sparseArray2.put(i.f.tag_del_post_is_self, sparseArray.get(i.f.tag_del_post_is_self));
            sparseArray2.put(i.f.tag_manage_user_identity, sparseArray.get(i.f.tag_manage_user_identity));
            textView.setOnClickListener(new cg(this));
        }
        if ("".equals(sparseArray.get(i.f.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(i.f.tag_forbid_user_name, sparseArray.get(i.f.tag_forbid_user_name));
            sparseArray3.put(i.f.tag_manage_user_identity, sparseArray.get(i.f.tag_manage_user_identity));
            sparseArray3.put(i.f.tag_forbid_user_post_id, sparseArray.get(i.f.tag_forbid_user_post_id));
            textView2.setOnClickListener(new ch(this));
        }
        if (!((sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean) && ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(i.h.un_mute);
            } else {
                textView3.setText(i.h.mute);
            }
            sparseArray4.put(i.f.tag_is_mem, sparseArray.get(i.f.tag_is_mem));
            sparseArray4.put(i.f.tag_disable_reply_mute_userid, sparseArray.get(i.f.tag_disable_reply_mute_userid));
            sparseArray4.put(i.f.tag_disable_reply_mute_username, sparseArray.get(i.f.tag_disable_reply_mute_username));
            sparseArray4.put(i.f.tag_disable_reply_post_id, sparseArray.get(i.f.tag_disable_reply_post_id));
            sparseArray4.put(i.f.tag_disable_reply_thread_id, sparseArray.get(i.f.tag_disable_reply_thread_id));
            textView3.setOnClickListener(new ci(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.ckQ, this.ciU.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.clG = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(i.f.tag_del_post_id, str);
        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = i.h.del_post_confirm;
        if (i == 0) {
            i3 = i.h.del_thread_confirm;
        }
        this.ckS = new com.baidu.tbadk.core.dialog.a(this.ciU.getActivity());
        this.ckS.bF(i3);
        this.ckS.x(sparseArray);
        this.ckS.a(i.h.dialog_ok, this.ciU);
        this.ckS.b(i.h.dialog_cancel, new cj(this));
        this.ckS.aj(true);
        this.ckS.b(this.ciU.getPageContext());
        this.ckS.sR();
    }

    public void R(ArrayList<com.baidu.tbadk.core.data.k> arrayList) {
        if (this.cld == null) {
            this.cld = LayoutInflater.from(this.ciU.getPageContext().getPageActivity()).inflate(i.g.commit_good, (ViewGroup) null);
        }
        this.ciU.getLayoutMode().k(this.cld);
        if (this.clc == null) {
            this.clc = new Dialog(this.ciU.getPageContext().getPageActivity(), i.C0057i.common_alert_dialog);
            this.clc.setCanceledOnTouchOutside(true);
            this.clc.setCancelable(true);
            this.cll = (ScrollView) this.cld.findViewById(i.f.good_scroll);
            this.clc.setContentView(this.cld);
            WindowManager.LayoutParams attributes = this.clc.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.d(this.ciU.getPageContext().getPageActivity(), i.d.ds540);
            this.clc.getWindow().setAttributes(attributes);
            this.clf = new ck(this);
            this.cle = (LinearLayout) this.cld.findViewById(i.f.good_class_group);
            this.clh = (TextView) this.cld.findViewById(i.f.dialog_button_cancel);
            this.clh.setOnClickListener(new cl(this));
            this.clg = (TextView) this.cld.findViewById(i.f.dialog_button_ok);
            this.clg.setOnClickListener(this.aWQ);
        }
        this.cle.removeAllViews();
        this.ckm = new ArrayList();
        com.baidu.tieba.pb.pb.main.b.a aX = aX("0", this.ciU.getPageContext().getString(i.h.def_good_class));
        this.ckm.add(aX);
        aX.setChecked(true);
        this.cle.addView(aX);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.b.a aX2 = aX(String.valueOf(arrayList.get(i2).rE()), arrayList.get(i2).rD());
                this.ckm.add(aX2);
                View view = new View(this.ciU.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.d(this.ciU.getPageContext().getPageActivity(), i.d.ds1));
                com.baidu.tbadk.core.util.an.j(view, i.c.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.cle.addView(view);
                this.cle.addView(aX2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.cll.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.ciU.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.ciU.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.ciU.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.cll.setLayoutParams(layoutParams2);
            this.cll.removeAllViews();
            this.cll.addView(this.cle);
        }
        com.baidu.adp.lib.g.j.a(this.clc, this.ciU.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.b.a aX(String str, String str2) {
        Activity pageActivity = this.ciU.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.b.a aVar = new com.baidu.tieba.pb.pb.main.b.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds100));
        aVar.setOnCheckedChangeListener(this.clf);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void agu() {
        this.ciU.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.ciU.hideProgressBar();
        if (z && z2) {
            this.ciU.showToast(this.ciU.getPageContext().getString(i.h.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.as.isEmpty(str)) {
                str = TbadkCoreApplication.m411getInst().getResources().getString(i.h.neterror);
            }
            this.ciU.showToast(str);
        }
    }

    public void Vw() {
        this.ckP.setVisibility(0);
    }

    public void Vv() {
        this.ckP.setVisibility(8);
    }

    public View agv() {
        if (this.cld != null) {
            return this.cld.findViewById(i.f.dialog_button_ok);
        }
        return null;
    }

    public String agw() {
        return this.cli;
    }

    public View getView() {
        return this.ccn;
    }

    public void agx() {
        com.baidu.adp.lib.util.k.c(this.ciU.getPageContext().getPageActivity(), this.ciU.getCurrentFocus());
    }

    public void agy() {
        this.ciU.showProgressBar();
    }

    public void eK(boolean z) {
        this.ciU.hideProgressBar();
        agM();
    }

    public void agz() {
        this.ckN.startLoadData();
    }

    public void agA() {
    }

    public void agB() {
        this.ciU.hideProgressBar();
        this.ckN.vy();
        agS();
        this.aVg.completePullRefresh();
        agE();
    }

    public void agC() {
        this.aVg.completePullRefresh();
        this.clu.setVisibility(8);
        agE();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.ckI.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.clj != null) {
            this.clj.dismiss();
            this.clj = null;
        }
        this.clj = new com.baidu.tbadk.core.dialog.c(this.ciU.getPageContext().getPageActivity());
        this.clj.bI(i.h.operation);
        if (z2) {
            this.clj.a(new String[]{this.ciU.getPageContext().getString(i.h.copy)}, bVar);
        } else if (!z) {
            this.clj.a(new String[]{this.ciU.getPageContext().getString(i.h.copy), this.ciU.getPageContext().getString(i.h.mark)}, bVar);
        } else {
            this.clj.a(new String[]{this.ciU.getPageContext().getString(i.h.copy), this.ciU.getPageContext().getString(i.h.remove_mark)}, bVar);
        }
        this.clj.d(this.ciU.getPageContext());
        this.clj.sU();
    }

    public int agD() {
        int firstVisiblePosition = this.aVg.getFirstVisiblePosition();
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.aVg.getAdapter();
        if (eVar != null) {
            if (eVar.getItem(firstVisiblePosition) instanceof com.baidu.tieba.pb.a.a) {
                firstVisiblePosition++;
            }
            int headersCount = (this.aVg.getAdapter() == null || !(this.aVg.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.aVg.getAdapter()).getHeadersCount();
            return firstVisiblePosition > headersCount ? firstVisiblePosition - headersCount : 0;
        }
        return firstVisiblePosition;
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.ckL.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void h(com.baidu.tieba.pb.a.b bVar) {
        this.ckI.a(bVar);
        this.ckI.notifyDataSetChanged();
        if (bVar == null) {
            jP("");
        } else {
            jP(com.baidu.tbadk.core.util.as.s(bVar.aeO().getReply_num()));
        }
        agE();
    }

    public void i(com.baidu.tieba.pb.a.b bVar) {
        PraiseData praise;
        if (this.ckB == null) {
            this.ciU.getLayoutMode().k(((ViewStub) this.ckn.findViewById(i.f.praise_layout)).inflate());
            this.ckB = (FrsPraiseView) this.ckn.findViewById(i.f.pb_head_praise_view);
            this.ckB.setIsFromPb(true);
            this.ckF = this.ckn.findViewById(i.f.new_pb_header_item_line_above_praise);
            this.ckB.cP(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.ckB != null) {
            boolean agE = agE();
            if (bVar != null && bVar.aeP() != null && bVar.aeP().size() > 0) {
                com.baidu.tieba.tbadkCore.data.k kVar = bVar.aeP().get(0);
                if ((!this.cgM || kVar.awI() != 1) && (praise = bVar.aeO().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.ckB.setVisibility(0);
                    this.ckB.setIsFromPb(true);
                    this.ckB.a(praise, bVar.aeO().getId(), praise.getPostId(), true);
                    this.ckF.setVisibility(0);
                    if (this.ckB.getVisibility() == 0) {
                        this.ckG.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.ckB.setVisibility(8);
            this.ckF.setVisibility(8);
            if (bVar != null && bVar.getPage() != null && bVar.getPage().rM() == 0 && this.cgM) {
                this.ckF.setVisibility(8);
                if (agE) {
                    this.ckE.setVisibility(0);
                    return;
                } else {
                    this.ckE.setVisibility(8);
                    return;
                }
            }
            this.ckF.setVisibility(0);
            this.ckE.setVisibility(8);
        }
    }

    private com.baidu.tieba.tbadkCore.data.k a(com.baidu.tieba.pb.a.b bVar, boolean z, int i) {
        if (z) {
            if (bVar == null || bVar.aeP() == null || bVar.aeP().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.k kVar = bVar.aeP().get(0);
            if (kVar.awI() != 1) {
                return j(bVar);
            }
            return kVar;
        }
        return j(bVar);
    }

    private com.baidu.tieba.tbadkCore.data.k j(com.baidu.tieba.pb.a.b bVar) {
        MetaData metaData;
        if (bVar == null || bVar.aeO() == null || bVar.aeO().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.k kVar = new com.baidu.tieba.tbadkCore.data.k();
        MetaData author = bVar.aeO().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = bVar.aeO().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        kVar.kW(1);
        kVar.setId(bVar.aeO().ss());
        kVar.setTitle(bVar.aeO().getTitle());
        kVar.setTime(bVar.aeO().getCreateTime());
        kVar.setAuthor(metaData);
        return kVar;
    }

    private void b(com.baidu.tieba.pb.a.b bVar, boolean z, int i) {
        this.ckp.setVisibility(8);
        com.baidu.tieba.tbadkCore.data.k a = a(bVar, z, i);
        if (a != null) {
            if (z) {
                this.ckA.setVisibility(8);
            } else {
                this.ckA.setVisibility(0);
            }
            this.ckp.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.ckp.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.ckp.setTag(sparseArray);
            }
            sparseArray.put(i.f.tag_clip_board, a);
            sparseArray.put(i.f.tag_is_subpb, false);
            this.ckz.setText(com.baidu.tbadk.core.util.as.o(a.getTime()));
            bVar.aeO().sA();
            this.ckq.setVisibility(0);
            this.ckq.setText(bVar.aeO().getSpan_str());
            i(bVar);
            ArrayList<com.baidu.tbadk.core.data.a> so = bVar.aeO().so();
            if (so != null && so.size() > 0) {
                this.clC.setText(String.valueOf(so.get(0).ro()));
                this.clB.setVisibility(0);
            } else {
                this.clB.setVisibility(8);
            }
            com.baidu.tbadk.core.util.an.i(this.clB, i.e.activity_join_num_bg);
            com.baidu.tbadk.core.util.an.b(this.clC, i.c.cp_link_tip_d, 1);
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
            if (bVar != null && bVar.aeO() != null && bVar.aeO().getAnchorInfoData() != null) {
                if (bVar.aeO().getAnchorInfoData().getGroup_id() != 0 && appResponseToIntentClass) {
                    if (this.clz == null) {
                        BdLog.e("pb time   liveCardLayout new");
                        this.clz = ((ViewStub) this.ckn.findViewById(i.f.live_card_layout)).inflate();
                        this.ciU.getLayoutMode().k(this.clz);
                        this.clA = (LiveBroadcastCard) this.ckn.findViewById(i.f.item_card);
                    }
                    this.clz.setVisibility(0);
                    LiveCardData liveCardData = new LiveCardData();
                    liveCardData.setPublisherId(bVar.aeO().getAnchorInfoData().getAuthorId());
                    liveCardData.setPublisherName(bVar.aeO().getAnchorInfoData().getAuthorName());
                    liveCardData.setPublisherPortrait(bVar.aeO().getAnchorInfoData().getPublisherPortrait());
                    liveCardData.setGroupId(bVar.aeO().getAnchorInfoData().getGroup_id());
                    liveCardData.setIntro(bVar.aeO().getAnchorInfoData().getIntro());
                    liveCardData.setLikers(bVar.aeO().getAnchorInfoData().getLikers());
                    liveCardData.setListeners(bVar.aeO().getAnchorInfoData().getListeners());
                    liveCardData.setName(bVar.aeO().getAnchorInfoData().getName());
                    liveCardData.setPortrait(bVar.aeO().getAnchorInfoData().getPortrait());
                    liveCardData.setStatus(bVar.aeO().getAnchorInfoData().getStatus());
                    liveCardData.setStartTime(bVar.aeO().getAnchorInfoData().getStartTime());
                    liveCardData.setIsVip(bVar.aeO().getAnchorInfoData().getIsVip());
                    this.clA.setData(liveCardData);
                    this.clA.setStatisticsKey("notice_pb_live");
                } else if (this.clz != null) {
                    this.clz.setVisibility(8);
                }
            }
            if (bVar != null && bVar.aeO() != null && bVar.aeO().getAuthor() != null) {
                String userId = bVar.aeO().getAuthor().getUserId();
                if (userId != null && !userId.equals("0") && userId.equals(a.getAuthor().getUserId())) {
                    this.cky.setVisibility(0);
                } else {
                    this.cky.setVisibility(8);
                }
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.ckt.setVisibility(0);
                    com.baidu.tbadk.core.util.an.c(this.ckt, com.baidu.tbadk.core.util.c.ch(level_id));
                    this.ckt.setOnClickListener(null);
                } else {
                    this.ckt.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.an.c(this.ckv, i.e.pb_manager);
                        this.ckt.setVisibility(8);
                        this.ckv.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.an.c(this.ckv, i.e.pb_assist);
                        this.ckt.setVisibility(8);
                        this.ckv.setVisibility(0);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.an.c(this.cku, i.e.icon_pb_pop_girl);
                    this.cku.setVisibility(0);
                } else if (a.getAuthor().getGender() == 1) {
                    com.baidu.tbadk.core.util.an.c(this.cku, i.e.icon_pb_pop_boy);
                    this.cku.setVisibility(0);
                } else {
                    this.cku.setVisibility(8);
                }
                if (!StringUtils.isNull(a.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aT(a.getAuthor().getName_show()) > 14) {
                    i2 = 0;
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfo = a.getAuthor().getTShowInfo();
                if (this.ckw != null) {
                    this.ckw.setTag(i.f.tag_user_id, a.getAuthor().getUserId());
                    this.ckw.setOnClickListener(this.ciU.cin.aXo);
                    this.ckw.a(iconInfo, i2, this.ciU.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.ciU.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.ciU.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                }
                if (this.ckx != null) {
                    this.ckx.setOnClickListener(this.ciU.cin.clO);
                    this.ckx.a(tShowInfo, 3, this.ciU.getResources().getDimensionPixelSize(i.d.small_icon_width), this.ciU.getResources().getDimensionPixelSize(i.d.small_icon_height), this.ciU.getResources().getDimensionPixelSize(i.d.big_icon_margin), true);
                }
                this.ckr.setText(a.getAuthor().getName_show());
                this.ckr.setTag(i.f.tag_user_id, a.getAuthor().getUserId());
                this.ckr.setTag(i.f.tag_user_name, a.getAuthor().getName_show());
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.an.b(this.ckr, i.c.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.an.b(this.ckr, i.c.cp_cont_f, 1);
                }
                if (!this.cgL) {
                    this.cks.setVisibility(8);
                }
                this.cks.setUserId(a.getAuthor().getUserId());
                this.cks.setUserName(a.getAuthor().getUserName());
                this.cks.setImageDrawable(null);
                this.cks.setTag(a.getAuthor().getUserId());
                this.ckr.setOnClickListener(this.ciU.cin.clN);
                this.cks.setOnClickListener(this.ciU.cin.clN);
                this.cks.d(a.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.b bVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable agf;
        Parcelable agf2;
        String sb;
        if (bVar != null) {
            this.cly = false;
            this.cgM = z;
            agB();
            b(bVar, z, i);
            this.ckI.er(this.cgM);
            this.ckI.a(bVar);
            this.ckI.notifyDataSetChanged();
            if (bVar.aeN() != null) {
                this.mForumName = bVar.aeN().getName();
            }
            this.ckl.jR(this.mForumName);
            if (bVar.aeO() != null) {
                jP(com.baidu.tbadk.core.util.as.s(bVar.aeO().getReply_num()));
                if (bVar.aeO().getPraise() != null) {
                    if (bVar.aeO().getPraise().getNum() < 1) {
                        sb = this.ciU.getResources().getString(i.h.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(bVar.aeO().getPraise().getNum())).toString();
                    }
                    C(sb, bVar.aeO().getPraise().getIsLike() == 1);
                }
            }
            if (bVar.getPage().rL() == 0 && !z) {
                this.aVg.setNextPage(null);
            } else if (this.ciU.isLogin()) {
                this.aVg.setNextPage(this.ckN);
                agS();
            } else if (bVar.getPage().rL() == 1) {
                this.cly = true;
                if (this.ckO == null) {
                    this.ckO = new com.baidu.tieba.pb.view.b(this.ciU.getPageContext());
                }
                this.aVg.setNextPage(this.ckO);
            }
            if (bVar.getPage().rM() == 0 && z) {
                this.aVg.setPullRefresh(null);
                this.clu.setVisibility(8);
            } else {
                if (this.ckM == null) {
                    this.ckM = new com.baidu.tieba.pb.view.e(this.ciU.getPageContext());
                    this.ckM.no();
                    this.ckM.a(this.aez);
                }
                this.aVg.setPullRefresh(this.ckM);
                if (this.ckM != null) {
                    this.ckM.cN(TbadkCoreApplication.m411getInst().getSkinType());
                }
                this.clu.setVisibility(0);
                agS();
            }
            agE();
            if (bVar.getPage().rL() == 0) {
                this.ckN.setText(this.ciU.getResources().getString(i.h.list_no_more));
                k(bVar);
            } else if (z2) {
                if (this.clH) {
                    vy();
                    if (bVar.getPage().rL() != 0) {
                        this.ckN.setText(this.ciU.getResources().getString(i.h.pb_load_more));
                    }
                } else {
                    this.ckN.showLoading();
                }
            } else {
                this.ckN.showLoading();
            }
            if (z) {
                this.clv.setVisibility(0);
                this.aDY.setVisibility(0);
                this.clw.setText(this.ciU.getResources().getString(i.h.btn_show_passed_pb));
            } else {
                this.clv.setVisibility(8);
                this.aDY.setVisibility(8);
                this.clw.setText(this.ciU.getResources().getString(i.h.btn_show_passed_pb_aftre));
            }
            if (bVar.aeO() != null && bVar.aeO().getAuthor() != null && bVar.aeO().getAuthor().getType() == 0) {
                this.ckl.agV();
            }
            switch (i) {
                case 2:
                    this.aVg.setSelection(i2);
                    if (this.cko != null) {
                        CompatibleUtile.scrollListViewBy(this.aVg, -this.cko.getHeight(), 0);
                        return;
                    }
                    return;
                case 3:
                    if (i3 == 1 && (agf2 = bx.age().agf()) != null) {
                        this.aVg.onRestoreInstanceState(agf2);
                        return;
                    } else {
                        this.aVg.setSelection(0);
                        return;
                    }
                case 4:
                    this.clH = false;
                    this.aVg.setSelection(0);
                    return;
                case 5:
                    this.aVg.setSelection(0);
                    return;
                case 6:
                    if (i3 == 1 && (agf = bx.age().agf()) != null) {
                        this.aVg.onRestoreInstanceState(agf);
                        return;
                    } else {
                        this.aVg.setSelection(0);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void eL(boolean z) {
        this.clk = z;
        this.ckl.eL(z);
    }

    public void vy() {
        if (this.ckN != null) {
            this.ckN.vy();
        }
        agS();
    }

    public void LP() {
        this.aVg.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agE() {
        boolean z;
        boolean z2 = true;
        if (this.cko != null && this.cko.getVisibility() == 0) {
            if (this.ckC != null) {
                this.ckC.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.ckC != null) {
                this.ckC.setVisibility(8);
            }
            z = false;
        }
        if (this.cln != null && this.cln.getVisibility() == 0) {
            if (this.ckD != null) {
                this.ckD.setVisibility(0);
            }
        } else {
            if (this.ckD != null) {
                this.ckD.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.ckF == null || this.ckF.getVisibility() == 8) && z2 && this.cgM) {
            this.ckE.setVisibility(0);
        } else {
            this.ckE.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.pb.a.b bVar, boolean z, boolean z2) {
        if (bVar == null) {
            return false;
        }
        if (this.ckq != null) {
            if (bVar.aeO().sr() == 0) {
                this.ckq.setVisibility(0);
                bVar.aeO().sA();
                this.ckq.setText(bVar.aeO().getSpan_str());
            } else {
                this.ckq.setVisibility(8);
            }
        }
        if (z) {
            if (this.clz != null) {
                this.clz.findViewById(i.f.pb_head_live_blank).setVisibility(8);
            }
        } else if (this.clz != null) {
            this.clz.findViewById(i.f.pb_head_live_blank).setVisibility(0);
        }
        this.cgM = z;
        com.baidu.tbadk.core.data.w aeO = bVar.aeO();
        if (aeO != null) {
            a(aeO.si());
        }
        if (bVar.aeS() == 1) {
            agF();
            Button button = (Button) this.ckn.findViewById(i.f.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.ckn.findViewById(i.f.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.ckn.findViewById(i.f.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.ckn.findViewById(i.f.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.aWQ);
            button2.setOnClickListener(this.aWQ);
            button3.setOnClickListener(this.aWQ);
            button4.setOnClickListener(this.aWQ);
            if (bVar.aeO().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (bVar.aeO().getIs_top() == 1) {
                button.setVisibility(8);
                button2.setVisibility(0);
            } else {
                button.setVisibility(0);
                button2.setVisibility(8);
            }
            return true;
        }
        return false;
    }

    private void agF() {
        if (this.cko == null) {
            this.cko = ((ViewStub) this.ckn.findViewById(i.f.pb_header_function_manage)).inflate();
            this.ciU.getLayoutMode().k(this.cko);
            this.ckC = this.ckn.findViewById(i.f.new_pb_header_item_line_above_manage);
            return;
        }
        this.cko.setVisibility(0);
    }

    public void a(com.baidu.tieba.pb.a.b bVar, boolean z, boolean z2, int i) {
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (bVar != null) {
            a(bVar, z, z2);
            com.baidu.tieba.tbadkCore.data.k a = a(bVar, z, i);
            if (a != null) {
                if (bVar.aeS() != 0 && a.getAuthor() != null) {
                    String userId2 = a.getAuthor().getUserId();
                    boolean z6 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
                    if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                        z3 = false;
                        z4 = true;
                        z5 = false;
                    } else {
                        z4 = true;
                        z5 = z6;
                        z3 = false;
                    }
                } else {
                    String userId3 = bVar.aeO().getAuthor().getUserId();
                    if (userId3 != null && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = false;
                        z4 = true;
                        z5 = false;
                    } else if (a.getAuthor() == null || (userId = a.getAuthor().getUserId()) == null || !userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = false;
                        z4 = false;
                        z5 = false;
                    } else {
                        z3 = true;
                        z4 = true;
                        z5 = false;
                    }
                }
                if (z4 && z5) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    if (a.getAuthor() != null) {
                        sparseArray.put(i.f.tag_forbid_user_name, a.getAuthor().getUserName());
                        sparseArray.put(i.f.tag_forbid_user_post_id, a.getId());
                    }
                    sparseArray.put(i.f.tag_del_post_id, a.getId());
                    sparseArray.put(i.f.tag_del_post_type, 0);
                    sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(bVar.aeS()));
                    sparseArray.put(i.f.tag_should_manage_visible, true);
                    a(i.h.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(i.f.tag_del_post_id, a.getId());
                    sparseArray2.put(i.f.tag_del_post_type, 0);
                    sparseArray2.put(i.f.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(i.f.tag_manage_user_identity, Integer.valueOf(bVar.aeS()));
                    sparseArray2.put(i.f.tag_should_manage_visible, false);
                    a(i.h.delete, sparseArray2);
                }
            }
            agE();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        agF();
        Button button = (Button) this.ckn.findViewById(i.f.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.aWQ);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.awp;
    }

    public void jQ(String str) {
        if (this.ckN != null && !StringUtils.isNull(str)) {
            this.ckN.setText(str);
        }
    }

    public BdListView getListView() {
        return this.aVg;
    }

    public int agG() {
        return i.f.richText;
    }

    public int LW() {
        return i.f.user_icon_box;
    }

    public Button agH() {
        return (Button) this.ckn.findViewById(i.f.pb_head_function_manage_commit_good);
    }

    public Button agI() {
        return (Button) this.ckn.findViewById(i.f.pb_head_function_manage_cancel_good);
    }

    public Button agJ() {
        return (Button) this.ckn.findViewById(i.f.pb_head_function_manage_commit_top);
    }

    public Button agK() {
        return (Button) this.ckn.findViewById(i.f.pb_head_function_manage_cancel_top);
    }

    public void c(BdListView.e eVar) {
        this.aVg.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.h hVar) {
        this.aVg.setOnSrollToTopListener(hVar);
    }

    public void a(p.a aVar) {
        this.aez = aVar;
        if (this.ckM != null) {
            this.ckM.a(aVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.o oVar, a.b bVar) {
        if (oVar != null) {
            int rJ = oVar.rJ();
            int rH = oVar.rH();
            if (this.ckJ != null) {
                this.ckJ.sR();
            } else {
                this.ckJ = new com.baidu.tbadk.core.dialog.a(this.ciU.getPageContext().getPageActivity());
                this.ckK = LayoutInflater.from(this.ciU.getPageContext().getPageActivity()).inflate(i.g.dialog_direct_pager, (ViewGroup) null);
                this.ckJ.m(this.ckK);
                this.ckJ.a(i.h.dialog_ok, bVar);
                this.ckJ.b(i.h.dialog_cancel, new cn(this));
                this.ckJ.b(this.ciU.getPageContext()).sR();
            }
            this.ckL = (EditText) this.ckK.findViewById(i.f.input_page_number);
            this.ckL.setText("");
            this.ckL.setOnFocusChangeListener(new co(this));
            TextView textView = (TextView) this.ckK.findViewById(i.f.current_page_number);
            if (rJ <= 0) {
                rJ = 1;
            }
            if (rH <= 0) {
                rH = 1;
            }
            textView.setText(MessageFormat.format(this.ciU.getApplicationContext().getResources().getString(i.h.current_page), Integer.valueOf(rJ), Integer.valueOf(rH)));
            this.ciU.ShowSoftKeyPadDelay(this.ckL, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aVg.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.ciU.showToast(str);
    }

    public boolean eM(boolean z) {
        if (this.KA == null || !this.KA.AA()) {
            return false;
        }
        this.KA.za();
        return true;
    }

    public void agL() {
        if (this.clI != null) {
            while (this.clI.size() > 0) {
                TbImageView remove = this.clI.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        agL();
    }

    public void onDestroy() {
        this.ciU.hideProgressBar();
        if (this.aMQ != null && this.aSa != null) {
            this.aMQ.b(this.aSa);
        }
        agM();
        this.ckN.vy();
    }

    public void agM() {
        this.ckl.qu();
        com.baidu.adp.lib.util.k.c(this.ciU.getPageContext().getPageActivity(), this.ckL);
        if (this.clj != null) {
            this.clj.dismiss();
        }
        agN();
    }

    public void ep(boolean z) {
        this.ckI.ep(z);
    }

    public void eq(boolean z) {
        this.cgL = z;
        this.ckI.eq(z);
    }

    public void eN(boolean z) {
        this.clm = z;
    }

    public void agN() {
        if (this.ckS != null) {
            this.ckS.dismiss();
        }
        if (this.ckT != null) {
            com.baidu.adp.lib.g.j.b(this.ckT, this.ciU.getPageContext());
        }
        if (this.clc != null) {
            com.baidu.adp.lib.g.j.b(this.clc, this.ciU.getPageContext());
        }
        if (this.ckQ != null) {
            com.baidu.adp.lib.g.j.b(this.ckQ, this.ciU.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.ciU.getLayoutMode().ad(i == 1);
        this.ciU.getLayoutMode().k(this.ccn);
        this.ciU.getLayoutMode().k(this.ckn);
        this.ciU.getLayoutMode().k(this.awp);
        this.ckl.mNavigationBar.onChangeSkinType(this.ciU.getPageContext(), i);
        com.baidu.tbadk.core.util.an.a(this.ckl.clW, i.e.btn_more_selector_s, i.e.btn_more_selector);
        com.baidu.tbadk.core.util.an.a(this.ckl.clX, i.e.icon_floor_addition_selector, i.e.icon_floor_addition_selector);
        if (this.ckK != null) {
            this.ciU.getLayoutMode().k(this.ckK);
        }
        eL(this.clk);
        this.ckI.notifyDataSetChanged();
        if (this.ckM != null) {
            this.ckM.cN(i);
        }
        if (this.ckN != null) {
            this.ckN.cN(i);
            com.baidu.tbadk.core.util.an.i(this.awp, i.e.pb_foot_more_trans_selector);
            this.ckN.cL(i.e.pb_foot_more_trans_selector);
        }
        if (this.KA != null) {
            this.KA.onChangeSkinType(i);
        }
        if (this.ckB != null) {
            this.ckB.cP(i);
        }
        if (this.ckO != null) {
            this.ckO.cN(i);
        }
        if (this.ckm != null && this.ckm.size() > 0) {
            for (com.baidu.tieba.pb.pb.main.b.a aVar : this.ckm) {
                aVar.agT();
            }
        }
        eH(i == 1);
    }

    public void setOnImageClickListener(TbRichTextView.c cVar) {
        this.aCn = cVar;
        this.ckI.setOnImageClickListener(this.aCn);
    }

    public void g(NoNetworkView.a aVar) {
        this.aSa = aVar;
        if (this.aMQ != null) {
            this.aMQ.a(this.aSa);
        }
    }

    public void eO(boolean z) {
        this.ckI.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button agO() {
        return this.cln;
    }

    public void k(com.baidu.tieba.pb.a.b bVar) {
        if (bVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = bVar.aeP();
            if (aeP.size() == 1) {
                com.baidu.tieba.tbadkCore.data.k kVar = aeP.get(0);
                if (kVar.awO() < kVar.awH().size()) {
                    this.aVg.setNextPage(null);
                    return;
                } else {
                    this.aVg.setNextPage(this.ckN);
                    return;
                }
            }
            this.aVg.setNextPage(this.ckN);
        }
    }

    public void agP() {
        if (com.baidu.tbadk.performanceLog.y.Eb().Ec()) {
            int lastVisiblePosition = this.aVg.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aVg.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(i.f.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.s perfLog = tbImageView.getPerfLog();
                                perfLog.ez(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                                perfLog.axr = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView.vr();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(i.f.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.s perfLog2 = headImageView.getPerfLog();
                        perfLog2.ez(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                        perfLog2.axr = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                            }
                        }
                        headImageView.vr();
                    }
                }
            }
        }
    }

    public void eP(boolean z) {
        if (this.clo != null && this.clo != null) {
            if (this.clm) {
                eE(z);
            } else {
                eF(z);
            }
        }
    }

    public void agQ() {
        if (this.clo != null) {
            this.clo.setVisibility(8);
        }
    }

    public TextView agR() {
        return this.clv;
    }

    public void Zf() {
        if (this.clx == null) {
            this.clx = new com.baidu.tbadk.core.view.a(this.ciU.getPageContext());
        }
        this.clx.av(true);
    }

    public void agS() {
        if (this.clx != null) {
            this.clx.av(false);
        }
    }
}
