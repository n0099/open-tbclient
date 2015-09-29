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
    private com.baidu.tbadk.editortools.j Kz;
    private NoNetworkView aMF;
    private BdTypeListView aUV;
    private View.OnClickListener aWF;
    private p.a aey;
    private View awo;
    private RelativeLayout ccc;
    private View.OnClickListener cgG;
    private com.baidu.tieba.pb.b.c cgH;
    private PbActivity ciJ;
    PbActivity.b cis;
    private View cjZ;
    private PbListView ckC;
    private View ckE;
    public final com.baidu.tieba.pb.pb.main.b.c cka;
    private List<com.baidu.tieba.pb.pb.main.b.a> ckb;
    private View ckc;
    private ColumnLayout cke;
    private TextView ckf;
    private TextView ckg;
    private HeadImageView ckh;
    private ImageView cki;
    private ImageView ckj;
    private ImageView ckk;
    private UserIconBox ckl;
    private UserIconBox ckm;
    private ImageView ckn;
    private TextView cko;
    private TextView ckp;
    private View ckt;
    private View ckv;
    private RelativeLayout ckw;
    private bd ckx;
    private View cld;
    private TextView cle;
    private TextView clf;
    private TextView clg;
    private boolean cli;
    private View clo;
    private LiveBroadcastCard clp;
    private View clq;
    private TextView clr;
    private PbActivity.a clv;
    private View ckd = null;
    public FrsPraiseView ckq = null;
    private View ckr = null;
    private View cks = null;
    private View cku = null;
    private com.baidu.tbadk.core.dialog.a cky = null;
    private com.baidu.tbadk.core.dialog.c aWv = null;
    private View ckz = null;
    private EditText ckA = null;
    private com.baidu.tieba.pb.view.e ckB = null;
    private com.baidu.tieba.pb.view.b ckD = null;
    private c.b bBr = null;
    private TbRichTextView.c aCc = null;
    private NoNetworkView.a aRP = null;
    private Dialog ckF = null;
    private View ckG = null;
    private com.baidu.tbadk.core.dialog.a ckH = null;
    private Dialog ckI = null;
    private View ckJ = null;
    private int ckK = 0;
    private RadioGroup MR = null;
    private RadioButton ckL = null;
    private RadioButton ckM = null;
    private RadioButton ckN = null;
    private Button ckO = null;
    private Button ckP = null;
    private TextView ckQ = null;
    private Dialog ckR = null;
    private View ckS = null;
    private LinearLayout ckT = null;
    private CompoundButton.OnCheckedChangeListener ckU = null;
    private TextView ckV = null;
    private TextView ckW = null;
    private String ckX = null;
    private com.baidu.tbadk.core.dialog.c ckY = null;
    private boolean ckZ = false;
    private String mForumName = null;
    private ScrollView cla = null;
    private boolean clb = false;
    private Button clc = null;
    private boolean clh = true;
    private LinearLayout clj = null;
    private TextView clk = null;
    private TextView cll = null;
    private View aDN = null;
    private com.baidu.tbadk.core.view.a clm = null;
    private boolean cgB = false;
    private boolean cln = false;
    private boolean mIsFromCDN = true;
    private boolean cls = true;
    private a.InterfaceC0074a clt = new cd(this);
    private final View.OnClickListener clu = new cm(this);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean clw = true;
    private final List<TbImageView> clx = new ArrayList();
    private boolean cgA = true;

    public NoNetworkView agm() {
        return this.aMF;
    }

    public void agn() {
        if (this.Kz != null) {
            this.Kz.hide();
        }
    }

    public void ago() {
        this.clh = true;
        if (this.Kz != null) {
            this.Kz.hide();
        }
        if (this.cld != null) {
            if (this.clb) {
                eE(false);
            } else {
                eF(false);
            }
        }
    }

    public void eE(boolean z) {
        if (this.cld != null && this.cle != null && this.clf != null) {
            this.cle.setText(i.h.draft_to_send);
            this.clf.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.cld.startAnimation(alphaAnimation);
            }
            this.cld.setVisibility(0);
        }
    }

    public void eF(boolean z) {
        if (this.cld != null && this.cle != null && this.clf != null) {
            this.cle.setText(i.h.reply_floor_host);
            this.clf.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.cld.startAnimation(alphaAnimation);
            }
            this.cld.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.k agp() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.aUV == null) {
            return null;
        }
        int firstVisiblePosition = this.aUV.getFirstVisiblePosition();
        int lastVisiblePosition = this.aUV.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.aUV.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.aUV.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.aUV.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.ckx.iK(headerViewsCount) != null && this.ckx.iK(headerViewsCount) != com.baidu.tieba.tbadkCore.data.k.cYF) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.k) this.ckx.aA(i2);
    }

    public cc(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.b.c cVar) {
        this.ciJ = null;
        this.ccc = null;
        this.cjZ = null;
        this.aUV = null;
        this.ckc = null;
        this.cke = null;
        this.ckf = null;
        this.ckg = null;
        this.ckh = null;
        this.cki = null;
        this.ckj = null;
        this.ckk = null;
        this.ckl = null;
        this.ckm = null;
        this.ckn = null;
        this.cko = null;
        this.ckp = null;
        this.ckt = null;
        this.ckv = null;
        this.ckx = null;
        this.ckC = null;
        this.awo = null;
        this.aWF = null;
        this.cgG = null;
        this.cld = null;
        this.cle = null;
        this.clg = null;
        this.clq = null;
        this.clr = null;
        this.ciJ = pbActivity;
        this.aWF = onClickListener;
        this.cgH = cVar;
        this.ccc = (RelativeLayout) LayoutInflater.from(this.ciJ.getPageContext().getPageActivity()).inflate(i.g.new_pb_activity, (ViewGroup) null);
        this.ciJ.addContentView(this.ccc, new FrameLayout.LayoutParams(-1, -1));
        this.cjZ = this.ciJ.findViewById(i.f.statebar_view);
        this.ckw = (RelativeLayout) this.ciJ.findViewById(i.f.title_wrapper);
        this.aMF = (NoNetworkView) this.ciJ.findViewById(i.f.view_no_network);
        this.aUV = (BdTypeListView) this.ciJ.findViewById(i.f.new_pb_list);
        View view = new View(this.ciJ.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.ciJ.getResources().getDimensionPixelSize(i.d.pb_editor_height)));
        this.aUV.addFooterView(view);
        this.cka = new com.baidu.tieba.pb.pb.main.b.c(pbActivity);
        this.cka.agU().setOnTouchListener(new com.baidu.tieba.pb.b.a(new cp(this)));
        this.cld = this.ciJ.findViewById(i.f.pb_editor_tool_comment);
        this.cle = (TextView) this.ciJ.findViewById(i.f.pb_editor_tool_comment_reply_text);
        this.clg = (TextView) this.ciJ.findViewById(i.f.pb_editor_tool_comment_praise_icon);
        this.clf = (TextView) this.ciJ.findViewById(i.f.pb_editor_tool_comment_reply_count_text);
        this.cle.setOnClickListener(new cq(this));
        this.clg.setOnClickListener(this.aWF);
        this.clg.setOnTouchListener(this.ciJ);
        this.ckc = LayoutInflater.from(this.ciJ.getPageContext().getPageActivity()).inflate(i.g.new_pb_header_item, (ViewGroup) null);
        this.cke = (ColumnLayout) this.ckc.findViewById(i.f.pb_head_owner_root);
        this.cke.setOnLongClickListener(this.onLongClickListener);
        this.cke.setOnTouchListener(this.cgH);
        this.cke.setVisibility(8);
        this.ckc.setOnTouchListener(this.cgH);
        this.ckf = (TextView) this.ckc.findViewById(i.f.pb_head_post_title);
        this.ckf.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.ckf.setVisibility(8);
        this.clq = this.ckc.findViewById(i.f.pb_head_activity_join_number_container);
        this.clq.setVisibility(8);
        this.clr = (TextView) this.ckc.findViewById(i.f.pb_head_activity_join_number);
        this.ckg = (TextView) this.cke.findViewById(i.f.pb_head_owner_info_user_name);
        this.ckh = (HeadImageView) this.cke.findViewById(i.f.pb_head_owner_photo);
        if (!this.cgA) {
            this.ckh.setVisibility(8);
        }
        this.cki = (ImageView) this.cke.findViewById(i.f.pb_head_owner_info_user_rank);
        this.ckj = (ImageView) this.cke.findViewById(i.f.pb_head_owner_info_user_gender);
        this.ckk = (ImageView) this.cke.findViewById(i.f.pb_head_owner_info_user_bawu);
        this.ckl = (UserIconBox) this.cke.findViewById(i.f.pb_head_owner_info_user_icon);
        this.ckm = (UserIconBox) this.cke.findViewById(i.f.pb_head_owner_info_tshow_icon);
        this.ckn = (ImageView) this.cke.findViewById(i.f.pb_head_owner_info_floor_owner);
        this.cko = (TextView) this.cke.findViewById(i.f.pb_head_owner_info_time);
        this.ckp = (TextView) this.ckc.findViewById(i.f.pb_head_reverse_hint);
        this.ckp.setOnClickListener(this.aWF);
        this.ckp.setVisibility(8);
        this.ckt = this.ckc.findViewById(i.f.new_pb_header_item_line_below_livepost);
        this.ckv = this.ckc.findViewById(i.f.new_pb_header_item_line_above_showpassed);
        this.ckc.setOnLongClickListener(new cr(this));
        agt();
        this.ckx = new bd(this.ciJ, this.aUV);
        this.ckx.C(this.aWF);
        this.ckx.a(this.cgH);
        this.ckx.setOnImageClickListener(this.aCc);
        this.cgG = new cs(this);
        this.ckx.B(this.cgG);
        this.aUV.addHeaderView(this.ckc);
        this.ckC = new PbListView(this.ciJ.getPageContext().getPageActivity());
        this.awo = this.ckC.getView().findViewById(i.f.pb_more_view);
        if (this.awo != null) {
            this.awo.setOnClickListener(this.aWF);
            com.baidu.tbadk.core.util.am.i(this.awo, i.e.pb_foot_more_trans_selector);
        }
        this.ckC.vx();
        this.ckC.cL(i.e.pb_foot_more_trans_selector);
        this.ckC.cM(i.e.pb_foot_more_trans_selector);
        this.ckE = this.ciJ.findViewById(i.f.viewstub_progress);
    }

    public void eG(boolean z) {
        this.cka.eG(z);
        if (z && this.cln) {
            this.ckC.setText(this.ciJ.getResources().getString(i.h.click_load_more));
            this.aUV.setNextPage(this.ckC);
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Kz = jVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.ccc.addView(this.Kz, layoutParams);
        this.Kz.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.Kz.hide();
    }

    public void agq() {
        if (this.ciJ != null && this.Kz != null) {
            this.Kz.ow();
        }
    }

    public void jP(String str) {
        if (this.clf != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.clf.setText(this.ciJ.getPageContext().getResources().getString(i.h.pb_reply_count_text, str));
        }
    }

    public void C(String str, boolean z) {
        this.cli = z;
        eH(TbadkCoreApplication.m411getInst().getSkinType() == 1);
    }

    private void eH(boolean z) {
        if (this.clg != null) {
            if (this.cli) {
                com.baidu.tbadk.core.util.am.i((View) this.clg, i.e.pb_praise_already_click_selector);
            } else {
                com.baidu.tbadk.core.util.am.i((View) this.clg, i.e.pb_praise_normal_click_selector);
            }
        }
    }

    public TextView agr() {
        return this.clg;
    }

    public void eI(boolean z) {
        if (this.aUV != null) {
            if (!z) {
                this.aUV.setEnabled(z);
            } else {
                this.aUV.postDelayed(new ct(this, z), 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cjZ.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.cjZ.setLayoutParams(layoutParams);
            this.cjZ.setVisibility(0);
            return;
        }
        this.cjZ.setVisibility(8);
    }

    public void ab(View view) {
        boolean z;
        View view2;
        if (this.ckw != null && view != null) {
            if (this.clh) {
                z = this.cld.getVisibility() == 0;
            } else {
                z = this.Kz != null && this.Kz.getVisibility() == 0;
            }
            boolean z2 = this.ckw.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                View findViewById = this.ciJ.findViewById(i.f.bg_above_list);
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.ckw.getHeight()));
                com.baidu.tieba.tbadkCore.a.a(this.ciJ, this.ckw, i.a.top_fold_up, new cu(this, findViewById));
            } else {
                com.baidu.tieba.tbadkCore.a.a(this.ciJ, this.ckw, i.a.top_fold_down, new cv(this));
            }
            if (this.clh) {
                view2 = this.cld;
            } else {
                view2 = this.Kz;
            }
            if (z) {
                if (z2) {
                    if (this.Kz != null) {
                        this.Kz.za();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.ciJ, view2, i.a.bottom_fold_down, new ce(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.ciJ, view2, i.a.bottom_fold_up, new cf(this));
            }
        }
    }

    public bd ags() {
        return this.ckx;
    }

    public void a(PbActivity.b bVar) {
        this.cis = bVar;
    }

    private void a(com.baidu.tbadk.core.data.y yVar) {
        if (yVar == null || yVar.sL() == 0) {
            if (this.clc != null) {
                this.clc.setVisibility(8);
            }
            if (this.cks != null) {
                this.cks.setVisibility(8);
                return;
            }
            return;
        }
        if (this.clc == null) {
            this.ciJ.getLayoutMode().k(((ViewStub) this.ckc.findViewById(i.f.live_talk_layout)).inflate());
            this.clc = (Button) this.ckc.findViewById(i.f.pb_head_function_manage_go_to_live_post);
            this.cks = this.ckc.findViewById(i.f.new_pb_header_item_line_above_livepost);
        }
        int sM = yVar.sM();
        String string = this.ciJ.getPageContext().getString(i.h.go_to_live_post_prefix);
        if (sM == 0) {
            string = String.valueOf(string) + this.ciJ.getPageContext().getString(i.h.go_to_interview_post);
        } else if (sM == 1) {
            string = String.valueOf(string) + this.ciJ.getPageContext().getString(i.h.go_to_discuss_post);
        }
        this.clc.setText(string);
        this.clc.setVisibility(0);
        this.clc.setOnClickListener(this.aWF);
        agE();
    }

    private void agt() {
        this.clj = (LinearLayout) this.ckc.findViewById(i.f.btn_show_passed_pb);
        this.cll = (TextView) this.ckc.findViewById(i.f.show_pre_page_view);
        this.clk = (TextView) this.ckc.findViewById(i.f.go_back_top_view);
        this.aDN = this.ckc.findViewById(i.f.show_passed_divider);
        this.cll.setOnClickListener(this.clu);
        this.clk.setOnClickListener(this.aWF);
        agE();
    }

    public void ac(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.ckG == null) {
            this.ckG = LayoutInflater.from(this.ciJ.getPageContext().getPageActivity()).inflate(i.g.forum_manage_dialog, (ViewGroup) null);
        }
        this.ciJ.getLayoutMode().k(this.ckG);
        if (this.ckF == null) {
            this.ckF = new Dialog(this.ciJ.getPageContext().getPageActivity(), i.C0057i.common_alert_dialog);
            this.ckF.setCanceledOnTouchOutside(true);
            this.ckF.setCancelable(true);
            this.ckF.setContentView(this.ckG);
            WindowManager.LayoutParams attributes = this.ckF.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.ciJ.getPageContext().getPageActivity()) * 0.9d);
            this.ckF.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.ckF.findViewById(i.f.del_post_btn);
        TextView textView2 = (TextView) this.ckF.findViewById(i.f.forbid_user_btn);
        TextView textView3 = (TextView) this.ckF.findViewById(i.f.disable_reply_btn);
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
        com.baidu.adp.lib.g.j.a(this.ckF, this.ciJ.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.clv = aVar;
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
        this.ckH = new com.baidu.tbadk.core.dialog.a(this.ciJ.getActivity());
        this.ckH.bF(i3);
        this.ckH.x(sparseArray);
        this.ckH.a(i.h.dialog_ok, this.ciJ);
        this.ckH.b(i.h.dialog_cancel, new cj(this));
        this.ckH.aj(true);
        this.ckH.b(this.ciJ.getPageContext());
        this.ckH.sR();
    }

    public void R(ArrayList<com.baidu.tbadk.core.data.j> arrayList) {
        if (this.ckS == null) {
            this.ckS = LayoutInflater.from(this.ciJ.getPageContext().getPageActivity()).inflate(i.g.commit_good, (ViewGroup) null);
        }
        this.ciJ.getLayoutMode().k(this.ckS);
        if (this.ckR == null) {
            this.ckR = new Dialog(this.ciJ.getPageContext().getPageActivity(), i.C0057i.common_alert_dialog);
            this.ckR.setCanceledOnTouchOutside(true);
            this.ckR.setCancelable(true);
            this.cla = (ScrollView) this.ckS.findViewById(i.f.good_scroll);
            this.ckR.setContentView(this.ckS);
            WindowManager.LayoutParams attributes = this.ckR.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.d(this.ciJ.getPageContext().getPageActivity(), i.d.ds540);
            this.ckR.getWindow().setAttributes(attributes);
            this.ckU = new ck(this);
            this.ckT = (LinearLayout) this.ckS.findViewById(i.f.good_class_group);
            this.ckW = (TextView) this.ckS.findViewById(i.f.dialog_button_cancel);
            this.ckW.setOnClickListener(new cl(this));
            this.ckV = (TextView) this.ckS.findViewById(i.f.dialog_button_ok);
            this.ckV.setOnClickListener(this.aWF);
        }
        this.ckT.removeAllViews();
        this.ckb = new ArrayList();
        com.baidu.tieba.pb.pb.main.b.a aX = aX("0", this.ciJ.getPageContext().getString(i.h.def_good_class));
        this.ckb.add(aX);
        aX.setChecked(true);
        this.ckT.addView(aX);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.b.a aX2 = aX(String.valueOf(arrayList.get(i2).rE()), arrayList.get(i2).rD());
                this.ckb.add(aX2);
                View view = new View(this.ciJ.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.d(this.ciJ.getPageContext().getPageActivity(), i.d.ds1));
                com.baidu.tbadk.core.util.am.j(view, i.c.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.ckT.addView(view);
                this.ckT.addView(aX2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.cla.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.ciJ.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.ciJ.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.ciJ.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.cla.setLayoutParams(layoutParams2);
            this.cla.removeAllViews();
            this.cla.addView(this.ckT);
        }
        com.baidu.adp.lib.g.j.a(this.ckR, this.ciJ.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.b.a aX(String str, String str2) {
        Activity pageActivity = this.ciJ.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.b.a aVar = new com.baidu.tieba.pb.pb.main.b.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds100));
        aVar.setOnCheckedChangeListener(this.ckU);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void agu() {
        this.ciJ.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.ciJ.hideProgressBar();
        if (z && z2) {
            this.ciJ.showToast(this.ciJ.getPageContext().getString(i.h.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ar.isEmpty(str)) {
                str = TbadkCoreApplication.m411getInst().getResources().getString(i.h.neterror);
            }
            this.ciJ.showToast(str);
        }
    }

    public void Vw() {
        this.ckE.setVisibility(0);
    }

    public void Vv() {
        this.ckE.setVisibility(8);
    }

    public View agv() {
        if (this.ckS != null) {
            return this.ckS.findViewById(i.f.dialog_button_ok);
        }
        return null;
    }

    public String agw() {
        return this.ckX;
    }

    public View getView() {
        return this.ccc;
    }

    public void agx() {
        com.baidu.adp.lib.util.k.c(this.ciJ.getPageContext().getPageActivity(), this.ciJ.getCurrentFocus());
    }

    public void agy() {
        this.ciJ.showProgressBar();
    }

    public void eK(boolean z) {
        this.ciJ.hideProgressBar();
        agM();
    }

    public void agz() {
        this.ckC.startLoadData();
    }

    public void agA() {
    }

    public void agB() {
        this.ciJ.hideProgressBar();
        this.ckC.vy();
        agS();
        this.aUV.completePullRefresh();
        agE();
    }

    public void agC() {
        this.aUV.completePullRefresh();
        this.clj.setVisibility(8);
        agE();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.ckx.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.ckY != null) {
            this.ckY.dismiss();
            this.ckY = null;
        }
        this.ckY = new com.baidu.tbadk.core.dialog.c(this.ciJ.getPageContext().getPageActivity());
        this.ckY.bI(i.h.operation);
        if (z2) {
            this.ckY.a(new String[]{this.ciJ.getPageContext().getString(i.h.copy)}, bVar);
        } else if (!z) {
            this.ckY.a(new String[]{this.ciJ.getPageContext().getString(i.h.copy), this.ciJ.getPageContext().getString(i.h.mark)}, bVar);
        } else {
            this.ckY.a(new String[]{this.ciJ.getPageContext().getString(i.h.copy), this.ciJ.getPageContext().getString(i.h.remove_mark)}, bVar);
        }
        this.ckY.d(this.ciJ.getPageContext());
        this.ckY.sU();
    }

    public int agD() {
        int firstVisiblePosition = this.aUV.getFirstVisiblePosition();
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.aUV.getAdapter();
        if (eVar != null) {
            if (eVar.getItem(firstVisiblePosition) instanceof com.baidu.tieba.pb.a.a) {
                firstVisiblePosition++;
            }
            int headersCount = (this.aUV.getAdapter() == null || !(this.aUV.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.aUV.getAdapter()).getHeadersCount();
            return firstVisiblePosition > headersCount ? firstVisiblePosition - headersCount : 0;
        }
        return firstVisiblePosition;
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.ckA.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void h(com.baidu.tieba.pb.a.b bVar) {
        this.ckx.a(bVar);
        this.ckx.notifyDataSetChanged();
        if (bVar == null) {
            jP("");
        } else {
            jP(com.baidu.tbadk.core.util.ar.s(bVar.aeO().getReply_num()));
        }
        agE();
    }

    public void i(com.baidu.tieba.pb.a.b bVar) {
        PraiseData praise;
        if (this.ckq == null) {
            this.ciJ.getLayoutMode().k(((ViewStub) this.ckc.findViewById(i.f.praise_layout)).inflate());
            this.ckq = (FrsPraiseView) this.ckc.findViewById(i.f.pb_head_praise_view);
            this.ckq.setIsFromPb(true);
            this.cku = this.ckc.findViewById(i.f.new_pb_header_item_line_above_praise);
            this.ckq.cP(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.ckq != null) {
            boolean agE = agE();
            if (bVar != null && bVar.aeP() != null && bVar.aeP().size() > 0) {
                com.baidu.tieba.tbadkCore.data.k kVar = bVar.aeP().get(0);
                if ((!this.cgB || kVar.awy() != 1) && (praise = bVar.aeO().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.ckq.setVisibility(0);
                    this.ckq.setIsFromPb(true);
                    this.ckq.a(praise, bVar.aeO().getId(), praise.getPostId(), true);
                    this.cku.setVisibility(0);
                    if (this.ckq.getVisibility() == 0) {
                        this.ckv.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.ckq.setVisibility(8);
            this.cku.setVisibility(8);
            if (bVar != null && bVar.getPage() != null && bVar.getPage().rM() == 0 && this.cgB) {
                this.cku.setVisibility(8);
                if (agE) {
                    this.ckt.setVisibility(0);
                    return;
                } else {
                    this.ckt.setVisibility(8);
                    return;
                }
            }
            this.cku.setVisibility(0);
            this.ckt.setVisibility(8);
        }
    }

    private com.baidu.tieba.tbadkCore.data.k a(com.baidu.tieba.pb.a.b bVar, boolean z, int i) {
        if (z) {
            if (bVar == null || bVar.aeP() == null || bVar.aeP().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.k kVar = bVar.aeP().get(0);
            if (kVar.awy() != 1) {
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
        kVar.kU(1);
        kVar.setId(bVar.aeO().ss());
        kVar.setTitle(bVar.aeO().getTitle());
        kVar.setTime(bVar.aeO().getCreateTime());
        kVar.setAuthor(metaData);
        return kVar;
    }

    private void b(com.baidu.tieba.pb.a.b bVar, boolean z, int i) {
        this.cke.setVisibility(8);
        com.baidu.tieba.tbadkCore.data.k a = a(bVar, z, i);
        if (a != null) {
            if (z) {
                this.ckp.setVisibility(8);
            } else {
                this.ckp.setVisibility(0);
            }
            this.cke.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.cke.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.cke.setTag(sparseArray);
            }
            sparseArray.put(i.f.tag_clip_board, a);
            sparseArray.put(i.f.tag_is_subpb, false);
            this.cko.setText(com.baidu.tbadk.core.util.ar.o(a.getTime()));
            bVar.aeO().sA();
            this.ckf.setVisibility(0);
            this.ckf.setText(bVar.aeO().getSpan_str());
            i(bVar);
            ArrayList<com.baidu.tbadk.core.data.a> so = bVar.aeO().so();
            if (so != null && so.size() > 0) {
                this.clr.setText(String.valueOf(so.get(0).ro()));
                this.clq.setVisibility(0);
            } else {
                this.clq.setVisibility(8);
            }
            com.baidu.tbadk.core.util.am.i(this.clq, i.e.activity_join_num_bg);
            com.baidu.tbadk.core.util.am.b(this.clr, i.c.cp_link_tip_d, 1);
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
            if (bVar != null && bVar.aeO() != null && bVar.aeO().getAnchorInfoData() != null) {
                if (bVar.aeO().getAnchorInfoData().getGroup_id() != 0 && appResponseToIntentClass) {
                    if (this.clo == null) {
                        BdLog.e("pb time   liveCardLayout new");
                        this.clo = ((ViewStub) this.ckc.findViewById(i.f.live_card_layout)).inflate();
                        this.ciJ.getLayoutMode().k(this.clo);
                        this.clp = (LiveBroadcastCard) this.ckc.findViewById(i.f.item_card);
                    }
                    this.clo.setVisibility(0);
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
                    this.clp.setData(liveCardData);
                    this.clp.setStatisticsKey("notice_pb_live");
                } else if (this.clo != null) {
                    this.clo.setVisibility(8);
                }
            }
            if (bVar != null && bVar.aeO() != null && bVar.aeO().getAuthor() != null) {
                String userId = bVar.aeO().getAuthor().getUserId();
                if (userId != null && !userId.equals("0") && userId.equals(a.getAuthor().getUserId())) {
                    this.ckn.setVisibility(0);
                } else {
                    this.ckn.setVisibility(8);
                }
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.cki.setVisibility(0);
                    com.baidu.tbadk.core.util.am.c(this.cki, com.baidu.tbadk.core.util.c.ch(level_id));
                    this.cki.setOnClickListener(null);
                } else {
                    this.cki.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.am.c(this.ckk, i.e.pb_manager);
                        this.cki.setVisibility(8);
                        this.ckk.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.am.c(this.ckk, i.e.pb_assist);
                        this.cki.setVisibility(8);
                        this.ckk.setVisibility(0);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.am.c(this.ckj, i.e.icon_pb_pop_girl);
                    this.ckj.setVisibility(0);
                } else if (a.getAuthor().getGender() == 1) {
                    com.baidu.tbadk.core.util.am.c(this.ckj, i.e.icon_pb_pop_boy);
                    this.ckj.setVisibility(0);
                } else {
                    this.ckj.setVisibility(8);
                }
                if (!StringUtils.isNull(a.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aT(a.getAuthor().getName_show()) > 14) {
                    i2 = 0;
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfo = a.getAuthor().getTShowInfo();
                if (this.ckl != null) {
                    this.ckl.setTag(i.f.tag_user_id, a.getAuthor().getUserId());
                    this.ckl.setOnClickListener(this.ciJ.cib.aXd);
                    this.ckl.a(iconInfo, i2, this.ciJ.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.ciJ.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.ciJ.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                }
                if (this.ckm != null) {
                    this.ckm.setOnClickListener(this.ciJ.cib.clD);
                    this.ckm.a(tShowInfo, 3, this.ciJ.getResources().getDimensionPixelSize(i.d.small_icon_width), this.ciJ.getResources().getDimensionPixelSize(i.d.small_icon_height), this.ciJ.getResources().getDimensionPixelSize(i.d.big_icon_margin), true);
                }
                this.ckg.setText(a.getAuthor().getName_show());
                this.ckg.setTag(i.f.tag_user_id, a.getAuthor().getUserId());
                this.ckg.setTag(i.f.tag_user_name, a.getAuthor().getName_show());
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.am.b(this.ckg, i.c.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.am.b(this.ckg, i.c.cp_cont_f, 1);
                }
                if (!this.cgA) {
                    this.ckh.setVisibility(8);
                }
                this.ckh.setUserId(a.getAuthor().getUserId());
                this.ckh.setUserName(a.getAuthor().getUserName());
                this.ckh.setImageDrawable(null);
                this.ckh.setTag(a.getAuthor().getUserId());
                this.ckg.setOnClickListener(this.ciJ.cib.clC);
                this.ckh.setOnClickListener(this.ciJ.cib.clC);
                this.ckh.d(a.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.b bVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable agf;
        Parcelable agf2;
        String sb;
        if (bVar != null) {
            this.cln = false;
            this.cgB = z;
            agB();
            b(bVar, z, i);
            this.ckx.er(this.cgB);
            this.ckx.a(bVar);
            this.ckx.notifyDataSetChanged();
            if (bVar.aeN() != null) {
                this.mForumName = bVar.aeN().getName();
            }
            this.cka.jR(this.mForumName);
            if (bVar.aeO() != null) {
                jP(com.baidu.tbadk.core.util.ar.s(bVar.aeO().getReply_num()));
                if (bVar.aeO().getPraise() != null) {
                    if (bVar.aeO().getPraise().getNum() < 1) {
                        sb = this.ciJ.getResources().getString(i.h.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(bVar.aeO().getPraise().getNum())).toString();
                    }
                    C(sb, bVar.aeO().getPraise().getIsLike() == 1);
                }
            }
            if (bVar.getPage().rL() == 0 && !z) {
                this.aUV.setNextPage(null);
            } else if (this.ciJ.isLogin()) {
                this.aUV.setNextPage(this.ckC);
                agS();
            } else if (bVar.getPage().rL() == 1) {
                this.cln = true;
                if (this.ckD == null) {
                    this.ckD = new com.baidu.tieba.pb.view.b(this.ciJ.getPageContext());
                }
                this.aUV.setNextPage(this.ckD);
            }
            if (bVar.getPage().rM() == 0 && z) {
                this.aUV.setPullRefresh(null);
                this.clj.setVisibility(8);
            } else {
                if (this.ckB == null) {
                    this.ckB = new com.baidu.tieba.pb.view.e(this.ciJ.getPageContext());
                    this.ckB.no();
                    this.ckB.a(this.aey);
                }
                this.aUV.setPullRefresh(this.ckB);
                if (this.ckB != null) {
                    this.ckB.cN(TbadkCoreApplication.m411getInst().getSkinType());
                }
                this.clj.setVisibility(0);
                agS();
            }
            agE();
            if (bVar.getPage().rL() == 0) {
                this.ckC.setText(this.ciJ.getResources().getString(i.h.list_no_more));
                k(bVar);
            } else if (z2) {
                if (this.clw) {
                    vy();
                    if (bVar.getPage().rL() != 0) {
                        this.ckC.setText(this.ciJ.getResources().getString(i.h.pb_load_more));
                    }
                } else {
                    this.ckC.showLoading();
                }
            } else {
                this.ckC.showLoading();
            }
            if (z) {
                this.clk.setVisibility(0);
                this.aDN.setVisibility(0);
                this.cll.setText(this.ciJ.getResources().getString(i.h.btn_show_passed_pb));
            } else {
                this.clk.setVisibility(8);
                this.aDN.setVisibility(8);
                this.cll.setText(this.ciJ.getResources().getString(i.h.btn_show_passed_pb_aftre));
            }
            if (bVar.aeO() != null && bVar.aeO().getAuthor() != null && bVar.aeO().getAuthor().getType() == 0) {
                this.cka.agV();
            }
            switch (i) {
                case 2:
                    this.aUV.setSelection(i2);
                    if (this.ckd != null) {
                        CompatibleUtile.scrollListViewBy(this.aUV, -this.ckd.getHeight(), 0);
                        return;
                    }
                    return;
                case 3:
                    if (i3 == 1 && (agf2 = bx.age().agf()) != null) {
                        this.aUV.onRestoreInstanceState(agf2);
                        return;
                    } else {
                        this.aUV.setSelection(0);
                        return;
                    }
                case 4:
                    this.clw = false;
                    this.aUV.setSelection(0);
                    return;
                case 5:
                    this.aUV.setSelection(0);
                    return;
                case 6:
                    if (i3 == 1 && (agf = bx.age().agf()) != null) {
                        this.aUV.onRestoreInstanceState(agf);
                        return;
                    } else {
                        this.aUV.setSelection(0);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void eL(boolean z) {
        this.ckZ = z;
        this.cka.eL(z);
    }

    public void vy() {
        if (this.ckC != null) {
            this.ckC.vy();
        }
        agS();
    }

    public void LP() {
        this.aUV.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agE() {
        boolean z;
        boolean z2 = true;
        if (this.ckd != null && this.ckd.getVisibility() == 0) {
            if (this.ckr != null) {
                this.ckr.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.ckr != null) {
                this.ckr.setVisibility(8);
            }
            z = false;
        }
        if (this.clc != null && this.clc.getVisibility() == 0) {
            if (this.cks != null) {
                this.cks.setVisibility(0);
            }
        } else {
            if (this.cks != null) {
                this.cks.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.cku == null || this.cku.getVisibility() == 8) && z2 && this.cgB) {
            this.ckt.setVisibility(0);
        } else {
            this.ckt.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.pb.a.b bVar, boolean z, boolean z2) {
        if (bVar == null) {
            return false;
        }
        if (this.ckf != null) {
            if (bVar.aeO().sr() == 0) {
                this.ckf.setVisibility(0);
                bVar.aeO().sA();
                this.ckf.setText(bVar.aeO().getSpan_str());
            } else {
                this.ckf.setVisibility(8);
            }
        }
        if (z) {
            if (this.clo != null) {
                this.clo.findViewById(i.f.pb_head_live_blank).setVisibility(8);
            }
        } else if (this.clo != null) {
            this.clo.findViewById(i.f.pb_head_live_blank).setVisibility(0);
        }
        this.cgB = z;
        com.baidu.tbadk.core.data.v aeO = bVar.aeO();
        if (aeO != null) {
            a(aeO.si());
        }
        if (bVar.aeS() == 1) {
            agF();
            Button button = (Button) this.ckc.findViewById(i.f.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.ckc.findViewById(i.f.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.ckc.findViewById(i.f.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.ckc.findViewById(i.f.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.aWF);
            button2.setOnClickListener(this.aWF);
            button3.setOnClickListener(this.aWF);
            button4.setOnClickListener(this.aWF);
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
        if (this.ckd == null) {
            this.ckd = ((ViewStub) this.ckc.findViewById(i.f.pb_header_function_manage)).inflate();
            this.ciJ.getLayoutMode().k(this.ckd);
            this.ckr = this.ckc.findViewById(i.f.new_pb_header_item_line_above_manage);
            return;
        }
        this.ckd.setVisibility(0);
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
        Button button = (Button) this.ckc.findViewById(i.f.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.aWF);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.awo;
    }

    public void jQ(String str) {
        if (this.ckC != null && !StringUtils.isNull(str)) {
            this.ckC.setText(str);
        }
    }

    public BdListView getListView() {
        return this.aUV;
    }

    public int agG() {
        return i.f.richText;
    }

    public int LW() {
        return i.f.user_icon_box;
    }

    public Button agH() {
        return (Button) this.ckc.findViewById(i.f.pb_head_function_manage_commit_good);
    }

    public Button agI() {
        return (Button) this.ckc.findViewById(i.f.pb_head_function_manage_cancel_good);
    }

    public Button agJ() {
        return (Button) this.ckc.findViewById(i.f.pb_head_function_manage_commit_top);
    }

    public Button agK() {
        return (Button) this.ckc.findViewById(i.f.pb_head_function_manage_cancel_top);
    }

    public void c(BdListView.e eVar) {
        this.aUV.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.h hVar) {
        this.aUV.setOnSrollToTopListener(hVar);
    }

    public void a(p.a aVar) {
        this.aey = aVar;
        if (this.ckB != null) {
            this.ckB.a(aVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.n nVar, a.b bVar) {
        if (nVar != null) {
            int rJ = nVar.rJ();
            int rH = nVar.rH();
            if (this.cky != null) {
                this.cky.sR();
            } else {
                this.cky = new com.baidu.tbadk.core.dialog.a(this.ciJ.getPageContext().getPageActivity());
                this.ckz = LayoutInflater.from(this.ciJ.getPageContext().getPageActivity()).inflate(i.g.dialog_direct_pager, (ViewGroup) null);
                this.cky.m(this.ckz);
                this.cky.a(i.h.dialog_ok, bVar);
                this.cky.b(i.h.dialog_cancel, new cn(this));
                this.cky.b(this.ciJ.getPageContext()).sR();
            }
            this.ckA = (EditText) this.ckz.findViewById(i.f.input_page_number);
            this.ckA.setText("");
            this.ckA.setOnFocusChangeListener(new co(this));
            TextView textView = (TextView) this.ckz.findViewById(i.f.current_page_number);
            if (rJ <= 0) {
                rJ = 1;
            }
            if (rH <= 0) {
                rH = 1;
            }
            textView.setText(MessageFormat.format(this.ciJ.getApplicationContext().getResources().getString(i.h.current_page), Integer.valueOf(rJ), Integer.valueOf(rH)));
            this.ciJ.ShowSoftKeyPadDelay(this.ckA, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aUV.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.ciJ.showToast(str);
    }

    public boolean eM(boolean z) {
        if (this.Kz == null || !this.Kz.AA()) {
            return false;
        }
        this.Kz.za();
        return true;
    }

    public void agL() {
        if (this.clx != null) {
            while (this.clx.size() > 0) {
                TbImageView remove = this.clx.remove(0);
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
        this.ciJ.hideProgressBar();
        if (this.aMF != null && this.aRP != null) {
            this.aMF.b(this.aRP);
        }
        agM();
        this.ckC.vy();
    }

    public void agM() {
        this.cka.qu();
        com.baidu.adp.lib.util.k.c(this.ciJ.getPageContext().getPageActivity(), this.ckA);
        if (this.ckY != null) {
            this.ckY.dismiss();
        }
        agN();
    }

    public void ep(boolean z) {
        this.ckx.ep(z);
    }

    public void eq(boolean z) {
        this.cgA = z;
        this.ckx.eq(z);
    }

    public void eN(boolean z) {
        this.clb = z;
    }

    public void agN() {
        if (this.ckH != null) {
            this.ckH.dismiss();
        }
        if (this.ckI != null) {
            com.baidu.adp.lib.g.j.b(this.ckI, this.ciJ.getPageContext());
        }
        if (this.ckR != null) {
            com.baidu.adp.lib.g.j.b(this.ckR, this.ciJ.getPageContext());
        }
        if (this.ckF != null) {
            com.baidu.adp.lib.g.j.b(this.ckF, this.ciJ.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.ciJ.getLayoutMode().ad(i == 1);
        this.ciJ.getLayoutMode().k(this.ccc);
        this.ciJ.getLayoutMode().k(this.ckc);
        this.ciJ.getLayoutMode().k(this.awo);
        this.cka.mNavigationBar.onChangeSkinType(this.ciJ.getPageContext(), i);
        com.baidu.tbadk.core.util.am.a(this.cka.clL, i.e.btn_more_selector_s, i.e.btn_more_selector);
        com.baidu.tbadk.core.util.am.a(this.cka.clM, i.e.icon_floor_addition_selector, i.e.icon_floor_addition_selector);
        if (this.ckz != null) {
            this.ciJ.getLayoutMode().k(this.ckz);
        }
        eL(this.ckZ);
        this.ckx.notifyDataSetChanged();
        if (this.ckB != null) {
            this.ckB.cN(i);
        }
        if (this.ckC != null) {
            this.ckC.cN(i);
            com.baidu.tbadk.core.util.am.i(this.awo, i.e.pb_foot_more_trans_selector);
            this.ckC.cL(i.e.pb_foot_more_trans_selector);
        }
        if (this.Kz != null) {
            this.Kz.onChangeSkinType(i);
        }
        if (this.ckq != null) {
            this.ckq.cP(i);
        }
        if (this.ckD != null) {
            this.ckD.cN(i);
        }
        if (this.ckb != null && this.ckb.size() > 0) {
            for (com.baidu.tieba.pb.pb.main.b.a aVar : this.ckb) {
                aVar.agT();
            }
        }
        eH(i == 1);
    }

    public void setOnImageClickListener(TbRichTextView.c cVar) {
        this.aCc = cVar;
        this.ckx.setOnImageClickListener(this.aCc);
    }

    public void g(NoNetworkView.a aVar) {
        this.aRP = aVar;
        if (this.aMF != null) {
            this.aMF.a(this.aRP);
        }
    }

    public void eO(boolean z) {
        this.ckx.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button agO() {
        return this.clc;
    }

    public void k(com.baidu.tieba.pb.a.b bVar) {
        if (bVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = bVar.aeP();
            if (aeP.size() == 1) {
                com.baidu.tieba.tbadkCore.data.k kVar = aeP.get(0);
                if (kVar.awE() < kVar.awx().size()) {
                    this.aUV.setNextPage(null);
                    return;
                } else {
                    this.aUV.setNextPage(this.ckC);
                    return;
                }
            }
            this.aUV.setNextPage(this.ckC);
        }
    }

    public void agP() {
        if (com.baidu.tbadk.performanceLog.y.Eb().Ec()) {
            int lastVisiblePosition = this.aUV.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aUV.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(i.f.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.s perfLog = tbImageView.getPerfLog();
                                perfLog.ez(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                                perfLog.axq = true;
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
                        perfLog2.axq = true;
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
        if (this.cld != null && this.cld != null) {
            if (this.clb) {
                eE(z);
            } else {
                eF(z);
            }
        }
    }

    public void agQ() {
        if (this.cld != null) {
            this.cld.setVisibility(8);
        }
    }

    public TextView agR() {
        return this.clk;
    }

    public void Zf() {
        if (this.clm == null) {
            this.clm = new com.baidu.tbadk.core.view.a(this.ciJ.getPageContext());
        }
        this.clm.av(true);
    }

    public void agS() {
        if (this.clm != null) {
            this.clm.av(false);
        }
    }
}
