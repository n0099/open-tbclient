package com.baidu.tieba.pb.pb.main;

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
import com.baidu.tbadk.core.view.x;
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
public class cb {
    private com.baidu.tbadk.editortools.j Kz;
    private NoNetworkView aNK;
    private BdTypeListView aVN;
    private View.OnClickListener aXl;
    private x.a afl;
    private View axP;
    private RelativeLayout bYq;
    private com.baidu.tieba.pb.b.c cbW;
    private View.OnClickListener ccE;
    PbActivity.b ccc;
    private PbActivity ccs;
    private View ceI;
    public final com.baidu.tieba.pb.pb.main.b.a ceJ;
    private View ceK;
    private ColumnLayout ceM;
    private TextView ceN;
    private TextView ceO;
    private HeadImageView ceP;
    private ImageView ceQ;
    private ImageView ceR;
    private UserIconBox ceS;
    private UserIconBox ceT;
    private ImageView ceU;
    private TextView ceV;
    private TextView ceW;
    private View cfK;
    private TextView cfL;
    private TextView cfM;
    private TextView cfN;
    private boolean cfP;
    private View cfV;
    private LiveBroadcastCard cfW;
    private View cfX;
    private TextView cfY;
    private View cfa;
    private View cfc;
    private RelativeLayout cfd;
    private bd cfe;
    private PbListView cfj;
    private View cfl;
    private PbActivity.a cgc;
    private View ceL = null;
    public FrsPraiseView ceX = null;
    private View ceY = null;
    private View ceZ = null;
    private View cfb = null;
    private com.baidu.tbadk.core.dialog.a cff = null;
    private com.baidu.tbadk.core.dialog.c aXb = null;
    private View cfg = null;
    private EditText cfh = null;
    private com.baidu.tieba.pb.view.e cfi = null;
    private com.baidu.tieba.pb.view.b cfk = null;
    private c.b byp = null;
    private TbRichTextView.c aDG = null;
    private NoNetworkView.a aST = null;
    private Dialog cfm = null;
    private View cfn = null;
    private com.baidu.tbadk.core.dialog.a cfo = null;
    private Dialog cfp = null;
    private View cfq = null;
    private int cfr = 0;
    private RadioGroup MS = null;
    private RadioButton cfs = null;
    private RadioButton cft = null;
    private RadioButton cfu = null;
    private Button cfv = null;
    private Button cfw = null;
    private TextView cfx = null;
    private Dialog cfy = null;
    private View cfz = null;
    private RadioGroup cfA = null;
    private CompoundButton.OnCheckedChangeListener cfB = null;
    private TextView cfC = null;
    private TextView cfD = null;
    private String cfE = null;
    private com.baidu.tbadk.core.dialog.c cfF = null;
    private boolean cfG = false;
    private String mForumName = null;
    private ScrollView cfH = null;
    private boolean cfI = false;
    private Button cfJ = null;
    private boolean cfO = true;
    private LinearLayout cfQ = null;
    private TextView cfR = null;
    private TextView cfS = null;
    private View aEI = null;
    private com.baidu.tbadk.core.view.a cfT = null;
    private boolean ccB = false;
    private boolean cfU = false;
    private boolean mIsFromCDN = true;
    private boolean cfZ = true;
    private a.InterfaceC0071a cga = new cc(this);
    private final View.OnClickListener cgb = new cl(this);
    private View.OnLongClickListener cgd = null;
    private boolean cge = true;
    private final List<TbImageView> cgf = new ArrayList();
    private boolean ccA = true;

    public NoNetworkView aeo() {
        return this.aNK;
    }

    public void aep() {
        if (this.Kz != null) {
            this.Kz.hide();
        }
    }

    public void aeq() {
        this.cfO = true;
        if (this.Kz != null) {
            this.Kz.hide();
        }
        if (this.cfK != null) {
            if (this.cfI) {
                ez(false);
            } else {
                eA(false);
            }
        }
    }

    public void ez(boolean z) {
        if (this.cfK != null && this.cfL != null && this.cfM != null) {
            this.cfL.setText(i.h.draft_to_send);
            this.cfM.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.cfK.startAnimation(alphaAnimation);
            }
            this.cfK.setVisibility(0);
        }
    }

    public void eA(boolean z) {
        if (this.cfK != null && this.cfL != null && this.cfM != null) {
            this.cfL.setText(i.h.reply_floor_host);
            this.cfM.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.cfK.startAnimation(alphaAnimation);
            }
            this.cfK.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.i aer() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.aVN == null) {
            return null;
        }
        int firstVisiblePosition = this.aVN.getFirstVisiblePosition();
        int lastVisiblePosition = this.aVN.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.aVN.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.aVN.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.aVN.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.cfe.iA(headerViewsCount) != null && this.cfe.iA(headerViewsCount) != com.baidu.tieba.tbadkCore.data.i.cRf) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.i) this.cfe.aA(i2);
    }

    public cb(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.b.c cVar) {
        this.ccs = null;
        this.bYq = null;
        this.ceI = null;
        this.aVN = null;
        this.ceK = null;
        this.ceM = null;
        this.ceN = null;
        this.ceO = null;
        this.ceP = null;
        this.ceQ = null;
        this.ceR = null;
        this.ceS = null;
        this.ceT = null;
        this.ceU = null;
        this.ceV = null;
        this.ceW = null;
        this.cfa = null;
        this.cfc = null;
        this.cfe = null;
        this.cfj = null;
        this.axP = null;
        this.aXl = null;
        this.ccE = null;
        this.cfK = null;
        this.cfL = null;
        this.cfN = null;
        this.cfX = null;
        this.cfY = null;
        this.ccs = pbActivity;
        this.aXl = onClickListener;
        this.cbW = cVar;
        this.bYq = (RelativeLayout) LayoutInflater.from(this.ccs.getPageContext().getPageActivity()).inflate(i.g.new_pb_activity, (ViewGroup) null);
        this.ccs.addContentView(this.bYq, new FrameLayout.LayoutParams(-1, -1));
        this.ceI = this.ccs.findViewById(i.f.statebar_view);
        this.cfd = (RelativeLayout) this.ccs.findViewById(i.f.title_wrapper);
        this.aNK = (NoNetworkView) this.ccs.findViewById(i.f.view_no_network);
        this.aVN = (BdTypeListView) this.ccs.findViewById(i.f.new_pb_list);
        View view = new View(this.ccs.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.ccs.getResources().getDimensionPixelSize(i.d.pb_editor_height)));
        this.aVN.addFooterView(view);
        this.ceJ = new com.baidu.tieba.pb.pb.main.b.a(pbActivity);
        this.ceJ.aeV().setOnTouchListener(new com.baidu.tieba.pb.b.a(new co(this)));
        this.cfK = this.ccs.findViewById(i.f.pb_editor_tool_comment);
        this.cfL = (TextView) this.ccs.findViewById(i.f.pb_editor_tool_comment_reply_text);
        this.cfN = (TextView) this.ccs.findViewById(i.f.pb_editor_tool_comment_praise_icon);
        this.cfM = (TextView) this.ccs.findViewById(i.f.pb_editor_tool_comment_reply_count_text);
        this.cfL.setOnClickListener(new cp(this));
        this.cfN.setOnClickListener(this.aXl);
        this.cfN.setOnTouchListener(this.ccs);
        this.ceK = LayoutInflater.from(this.ccs.getPageContext().getPageActivity()).inflate(i.g.new_pb_header_item, (ViewGroup) null);
        this.ceM = (ColumnLayout) this.ceK.findViewById(i.f.pb_head_owner_root);
        this.ceM.setOnLongClickListener(this.cgd);
        this.ceM.setOnTouchListener(this.cbW);
        this.ceM.setVisibility(8);
        this.ceK.setOnTouchListener(this.cbW);
        this.ceN = (TextView) this.ceK.findViewById(i.f.pb_head_post_title);
        this.ceN.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.ceN.setVisibility(8);
        this.cfX = this.ceK.findViewById(i.f.pb_head_activity_join_number_container);
        this.cfX.setVisibility(8);
        this.cfY = (TextView) this.ceK.findViewById(i.f.pb_head_activity_join_number);
        this.ceO = (TextView) this.ceM.findViewById(i.f.pb_head_owner_info_user_name);
        this.ceP = (HeadImageView) this.ceM.findViewById(i.f.pb_head_owner_photo);
        if (!this.ccA) {
            this.ceP.setVisibility(8);
        }
        this.ceQ = (ImageView) this.ceM.findViewById(i.f.pb_head_owner_info_user_rank);
        this.ceR = (ImageView) this.ceM.findViewById(i.f.pb_head_owner_info_user_gender);
        this.ceS = (UserIconBox) this.ceM.findViewById(i.f.pb_head_owner_info_user_icon);
        this.ceT = (UserIconBox) this.ceM.findViewById(i.f.pb_head_owner_info_tshow_icon);
        this.ceU = (ImageView) this.ceM.findViewById(i.f.pb_head_owner_info_floor_owner);
        this.ceV = (TextView) this.ceM.findViewById(i.f.pb_head_owner_info_time);
        this.ceW = (TextView) this.ceK.findViewById(i.f.pb_head_reverse_hint);
        this.ceW.setOnClickListener(this.aXl);
        this.ceW.setVisibility(8);
        this.cfa = this.ceK.findViewById(i.f.new_pb_header_item_line_below_livepost);
        this.cfc = this.ceK.findViewById(i.f.new_pb_header_item_line_above_showpassed);
        this.ceK.setOnLongClickListener(new cq(this));
        aev();
        this.cfe = new bd(this.ccs, this.aVN);
        this.cfe.B(this.aXl);
        this.cfe.a(this.cbW);
        this.cfe.setOnImageClickListener(this.aDG);
        this.ccE = new cr(this);
        this.cfe.A(this.ccE);
        this.aVN.addHeaderView(this.ceK);
        this.cfj = new PbListView(this.ccs.getPageContext().getPageActivity());
        this.axP = this.cfj.getView().findViewById(i.f.pb_more_view);
        if (this.axP != null) {
            this.axP.setOnClickListener(this.aXl);
            com.baidu.tbadk.core.util.al.h(this.axP, i.e.pb_foot_more_trans_selector);
        }
        this.cfj.vF();
        this.cfj.cK(i.e.pb_foot_more_trans_selector);
        this.cfj.cL(i.e.pb_foot_more_trans_selector);
        this.cfl = this.ccs.findViewById(i.f.viewstub_progress);
    }

    public void eB(boolean z) {
        this.ceJ.eB(z);
        if (z && this.cfU) {
            this.cfj.setText(this.ccs.getResources().getString(i.h.click_load_more));
            this.aVN.setNextPage(this.cfj);
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Kz = jVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.bYq.addView(this.Kz, layoutParams);
        this.Kz.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.Kz.hide();
    }

    public void aes() {
        if (this.ccs != null && this.Kz != null) {
            this.Kz.ov();
        }
    }

    public void jv(String str) {
        if (this.cfM != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.cfM.setText(this.ccs.getPageContext().getResources().getString(i.h.pb_reply_count_text, str));
        }
    }

    public void B(String str, boolean z) {
        this.cfP = z;
        eC(TbadkCoreApplication.m411getInst().getSkinType() == 1);
    }

    private void eC(boolean z) {
        if (this.cfN != null) {
            if (this.cfP) {
                com.baidu.tbadk.core.util.al.h((View) this.cfN, i.e.pb_praise_already_click_selector);
            } else {
                com.baidu.tbadk.core.util.al.h((View) this.cfN, i.e.pb_praise_normal_click_selector);
            }
        }
    }

    public TextView aet() {
        return this.cfN;
    }

    public void eD(boolean z) {
        if (this.aVN != null) {
            if (!z) {
                this.aVN.setEnabled(z);
            } else {
                this.aVN.postDelayed(new cs(this, z), 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ceI.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.ceI.setLayoutParams(layoutParams);
            this.ceI.setVisibility(0);
            return;
        }
        this.ceI.setVisibility(8);
    }

    public void Z(View view) {
        boolean z;
        View view2;
        if (this.cfd != null && view != null) {
            if (this.cfO) {
                z = this.cfK.getVisibility() == 0;
            } else {
                z = this.Kz != null && this.Kz.getVisibility() == 0;
            }
            boolean z2 = this.cfd.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                View findViewById = this.ccs.findViewById(i.f.bg_above_list);
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.cfd.getHeight()));
                com.baidu.tieba.tbadkCore.a.a(this.ccs, this.cfd, i.a.top_fold_up, new ct(this, findViewById));
            } else {
                com.baidu.tieba.tbadkCore.a.a(this.ccs, this.cfd, i.a.top_fold_down, new cu(this));
            }
            if (this.cfO) {
                view2 = this.cfK;
            } else {
                view2 = this.Kz;
            }
            if (z) {
                if (z2) {
                    if (this.Kz != null) {
                        this.Kz.zr();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.ccs, view2, i.a.bottom_fold_down, new cd(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.ccs, view2, i.a.bottom_fold_up, new ce(this));
            }
        }
    }

    public bd aeu() {
        return this.cfe;
    }

    public void a(PbActivity.b bVar) {
        this.ccc = bVar;
    }

    private void a(com.baidu.tbadk.core.data.aa aaVar) {
        if (aaVar != null && aaVar.sO() != 0) {
            if (this.cfJ == null) {
                this.ccs.getLayoutMode().k(((ViewStub) this.ceK.findViewById(i.f.live_talk_layout)).inflate());
                this.cfJ = (Button) this.ceK.findViewById(i.f.pb_head_function_manage_go_to_live_post);
                this.ceZ = this.ceK.findViewById(i.f.new_pb_header_item_line_above_livepost);
            }
            int sP = aaVar.sP();
            String string = this.ccs.getPageContext().getString(i.h.go_to_live_post_prefix);
            if (sP == 0) {
                string = String.valueOf(string) + this.ccs.getPageContext().getString(i.h.go_to_interview_post);
            } else if (sP == 1) {
                string = String.valueOf(string) + this.ccs.getPageContext().getString(i.h.go_to_discuss_post);
            }
            this.cfJ.setText(string);
            this.cfJ.setVisibility(0);
            this.cfJ.setOnClickListener(this.aXl);
            aeG();
        }
    }

    private void aev() {
        this.cfQ = (LinearLayout) this.ceK.findViewById(i.f.btn_show_passed_pb);
        this.cfS = (TextView) this.ceK.findViewById(i.f.show_pre_page_view);
        this.cfR = (TextView) this.ceK.findViewById(i.f.go_back_top_view);
        this.aEI = this.ceK.findViewById(i.f.show_passed_divider);
        this.cfS.setOnClickListener(this.cgb);
        this.cfR.setOnClickListener(this.aXl);
        aeG();
    }

    public void aa(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.cfn == null) {
            this.cfn = LayoutInflater.from(this.ccs.getPageContext().getPageActivity()).inflate(i.g.forum_manage_dialog, (ViewGroup) null);
        }
        this.ccs.getLayoutMode().k(this.cfn);
        if (this.cfm == null) {
            this.cfm = new Dialog(this.ccs.getPageContext().getPageActivity(), i.C0057i.common_alert_dialog);
            this.cfm.setCanceledOnTouchOutside(true);
            this.cfm.setCancelable(true);
            this.cfm.setContentView(this.cfn);
            WindowManager.LayoutParams attributes = this.cfm.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.ccs.getPageContext().getPageActivity()) * 0.9d);
            this.cfm.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.cfm.findViewById(i.f.del_post_btn);
        TextView textView2 = (TextView) this.cfm.findViewById(i.f.forbid_user_btn);
        TextView textView3 = (TextView) this.cfm.findViewById(i.f.disable_reply_btn);
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
            textView.setOnClickListener(new cf(this));
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
            textView2.setOnClickListener(new cg(this));
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
            textView3.setOnClickListener(new ch(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.cfm, this.ccs.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.cgc = aVar;
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
        this.cfo = new com.baidu.tbadk.core.dialog.a(this.ccs.getActivity());
        this.cfo.bF(i3);
        this.cfo.x(sparseArray);
        this.cfo.a(i.h.dialog_ok, this.ccs);
        this.cfo.b(i.h.dialog_cancel, new ci(this));
        this.cfo.aj(true);
        this.cfo.b(this.ccs.getPageContext());
        this.cfo.sU();
    }

    public void Q(ArrayList<com.baidu.tbadk.core.data.k> arrayList) {
        if (this.cfz == null) {
            this.cfz = LayoutInflater.from(this.ccs.getPageContext().getPageActivity()).inflate(i.g.commit_good, (ViewGroup) null);
        }
        this.ccs.getLayoutMode().k(this.cfz);
        if (this.cfy == null) {
            this.cfy = new Dialog(this.ccs.getPageContext().getPageActivity(), i.C0057i.common_alert_dialog);
            this.cfy.setCanceledOnTouchOutside(true);
            this.cfy.setCancelable(true);
            this.cfH = (ScrollView) this.cfz.findViewById(i.f.good_scroll);
            this.cfy.setContentView(this.cfz);
            WindowManager.LayoutParams attributes = this.cfy.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.ccs.getPageContext().getPageActivity()) * 0.9d);
            this.cfy.getWindow().setAttributes(attributes);
            this.cfB = new cj(this);
            this.cfA = (RadioGroup) this.cfz.findViewById(i.f.good_class_group);
            this.cfD = (TextView) this.cfz.findViewById(i.f.dialog_button_cancel);
            this.cfD.setOnClickListener(new ck(this));
            this.cfC = (TextView) this.cfz.findViewById(i.f.dialog_button_ok);
            this.cfC.setOnClickListener(this.aXl);
        }
        this.cfA.removeAllViews();
        RadioButton radioButton = (RadioButton) LayoutInflater.from(this.ccs.getPageContext().getPageActivity()).inflate(i.g.good_class_radio_button, (ViewGroup) null);
        com.baidu.tbadk.core.util.al.h((View) radioButton, i.e.good_class_button_bg);
        com.baidu.tbadk.core.util.al.b(radioButton, i.c.text_white_selector_color, 3);
        radioButton.setTag("0");
        radioButton.setText(this.ccs.getPageContext().getString(i.h.def_good_class));
        radioButton.setOnCheckedChangeListener(this.cfB);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        int dip2px = com.baidu.adp.lib.util.k.dip2px(this.ccs.getPageContext().getPageActivity(), 10.0f);
        int dip2px2 = com.baidu.adp.lib.util.k.dip2px(this.ccs.getPageContext().getPageActivity(), 5.0f);
        layoutParams.setMargins(dip2px, dip2px2, dip2px, dip2px2);
        this.cfA.addView(radioButton, layoutParams);
        this.cfA.requestLayout();
        this.cfA.check(radioButton.getId());
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.ccs.getPageContext().getPageActivity()).inflate(i.g.good_class_radio_button, (ViewGroup) null);
                com.baidu.tbadk.core.util.al.h((View) radioButton2, i.e.good_class_button_bg);
                com.baidu.tbadk.core.util.al.b(radioButton2, i.c.text_white_selector_color, 3);
                radioButton2.setButtonDrawable(17170445);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).rJ()));
                radioButton2.setText(arrayList.get(i2).rI());
                radioButton2.setOnCheckedChangeListener(this.cfB);
                this.cfA.addView(radioButton2, layoutParams);
                this.cfA.requestLayout();
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.cfH.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.ccs.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.ccs.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.ccs.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.cfH.setLayoutParams(layoutParams2);
            this.cfH.removeAllViews();
            this.cfH.addView(this.cfA);
        }
        com.baidu.adp.lib.g.j.a(this.cfy, this.ccs.getPageContext());
    }

    public void aew() {
        this.ccs.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.ccs.hideProgressBar();
        if (z && z2) {
            this.ccs.showToast(this.ccs.getPageContext().getString(i.h.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.m411getInst().getResources().getString(i.h.neterror);
            }
            this.ccs.showToast(str);
        }
    }

    public void UN() {
        this.cfl.setVisibility(0);
    }

    public void UM() {
        this.cfl.setVisibility(8);
    }

    public View aex() {
        if (this.cfz != null) {
            return this.cfz.findViewById(i.f.dialog_button_ok);
        }
        return null;
    }

    public String aey() {
        return this.cfE;
    }

    public View getView() {
        return this.bYq;
    }

    public void aez() {
        com.baidu.adp.lib.util.k.c(this.ccs.getPageContext().getPageActivity(), this.ccs.getCurrentFocus());
    }

    public void aeA() {
        this.ccs.showProgressBar();
    }

    public void eF(boolean z) {
        this.ccs.hideProgressBar();
        aeO();
    }

    public void aeB() {
        this.cfj.startLoadData();
    }

    public void aeC() {
    }

    public void aeD() {
        this.ccs.hideProgressBar();
        this.cfj.vG();
        aeU();
        this.aVN.completePullRefresh();
        aeG();
    }

    public void aeE() {
        this.aVN.completePullRefresh();
        this.cfQ.setVisibility(8);
        aeG();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.cgd = onLongClickListener;
        this.cfe.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.cfF != null) {
            this.cfF.dismiss();
            this.cfF = null;
        }
        this.cfF = new com.baidu.tbadk.core.dialog.c(this.ccs.getPageContext().getPageActivity());
        this.cfF.bI(i.h.operation);
        if (z2) {
            this.cfF.a(new String[]{this.ccs.getPageContext().getString(i.h.copy)}, bVar);
        } else if (!z) {
            this.cfF.a(new String[]{this.ccs.getPageContext().getString(i.h.copy), this.ccs.getPageContext().getString(i.h.mark)}, bVar);
        } else {
            this.cfF.a(new String[]{this.ccs.getPageContext().getString(i.h.copy), this.ccs.getPageContext().getString(i.h.remove_mark)}, bVar);
        }
        this.cfF.d(this.ccs.getPageContext());
        this.cfF.sX();
    }

    public int aeF() {
        int firstVisiblePosition = this.aVN.getFirstVisiblePosition();
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.aVN.getAdapter();
        if (eVar != null) {
            if (eVar.getItem(firstVisiblePosition) instanceof com.baidu.tieba.pb.a.a) {
                firstVisiblePosition++;
            }
            int headersCount = (this.aVN.getAdapter() == null || !(this.aVN.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.aVN.getAdapter()).getHeadersCount();
            return firstVisiblePosition > headersCount ? firstVisiblePosition - headersCount : 0;
        }
        return firstVisiblePosition;
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.cfh.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void h(com.baidu.tieba.pb.a.b bVar) {
        this.cfe.b(bVar);
        this.cfe.notifyDataSetChanged();
        if (bVar == null) {
            jv("");
        } else {
            jv(com.baidu.tbadk.core.util.aq.o(bVar.acQ().getReply_num()));
        }
        aeG();
    }

    public void i(com.baidu.tieba.pb.a.b bVar) {
        PraiseData praise;
        if (this.ceX == null) {
            this.ccs.getLayoutMode().k(((ViewStub) this.ceK.findViewById(i.f.praise_layout)).inflate());
            this.ceX = (FrsPraiseView) this.ceK.findViewById(i.f.pb_head_praise_view);
            this.ceX.setIsFromPb(true);
            this.cfb = this.ceK.findViewById(i.f.new_pb_header_item_line_above_praise);
            this.ceX.cO(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.ceX != null) {
            boolean aeG = aeG();
            if (bVar != null && bVar.acR() != null && bVar.acR().size() > 0) {
                com.baidu.tieba.tbadkCore.data.i iVar = bVar.acR().get(0);
                if ((!this.ccB || iVar.auj() != 1) && (praise = bVar.acQ().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.ceX.setVisibility(0);
                    this.ceX.setIsFromPb(true);
                    this.ceX.a(praise, bVar.acQ().getId(), praise.getPostId(), true);
                    this.cfb.setVisibility(0);
                    if (this.ceX.getVisibility() == 0) {
                        this.cfc.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.ceX.setVisibility(8);
            this.cfb.setVisibility(8);
            if (bVar != null && bVar.getPage() != null && bVar.getPage().rR() == 0 && this.ccB) {
                this.cfb.setVisibility(8);
                if (aeG) {
                    this.cfa.setVisibility(0);
                    return;
                } else {
                    this.cfa.setVisibility(8);
                    return;
                }
            }
            this.cfb.setVisibility(0);
            this.cfa.setVisibility(8);
        }
    }

    private com.baidu.tieba.tbadkCore.data.i a(com.baidu.tieba.pb.a.b bVar, boolean z, int i) {
        if (z) {
            if (bVar == null || bVar.acR() == null || bVar.acR().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.i iVar = bVar.acR().get(0);
            if (iVar.auj() != 1) {
                return j(bVar);
            }
            return iVar;
        }
        return j(bVar);
    }

    private com.baidu.tieba.tbadkCore.data.i j(com.baidu.tieba.pb.a.b bVar) {
        MetaData metaData;
        if (bVar == null || bVar.acQ() == null || bVar.acQ().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.i iVar = new com.baidu.tieba.tbadkCore.data.i();
        MetaData author = bVar.acQ().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = bVar.acQ().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        iVar.kt(1);
        iVar.setId(bVar.acQ().sx());
        iVar.setTitle(bVar.acQ().getTitle());
        iVar.setTime(bVar.acQ().getCreateTime());
        iVar.setAuthor(metaData);
        return iVar;
    }

    private void b(com.baidu.tieba.pb.a.b bVar, boolean z, int i) {
        this.ceM.setVisibility(8);
        com.baidu.tieba.tbadkCore.data.i a = a(bVar, z, i);
        if (a != null) {
            if (z) {
                this.ceW.setVisibility(8);
            } else {
                this.ceW.setVisibility(0);
            }
            this.ceM.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.ceM.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.ceM.setTag(sparseArray);
            }
            sparseArray.put(i.f.tag_clip_board, a);
            sparseArray.put(i.f.tag_is_subpb, false);
            this.ceV.setText(com.baidu.tbadk.core.util.aq.m(a.getTime()));
            bVar.acQ().sF();
            this.ceN.setVisibility(0);
            this.ceN.setText(bVar.acQ().getSpan_str());
            i(bVar);
            ArrayList<com.baidu.tbadk.core.data.b> st = bVar.acQ().st();
            if (st != null && st.size() > 0) {
                this.cfY.setText(String.valueOf(st.get(0).rt()));
                this.cfX.setVisibility(0);
            } else {
                this.cfX.setVisibility(8);
            }
            com.baidu.tbadk.core.util.al.h(this.cfX, i.e.activity_join_num_bg);
            com.baidu.tbadk.core.util.al.b(this.cfY, i.c.cp_link_tip_d, 1);
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
            if (bVar != null && bVar.acQ() != null && bVar.acQ().getAnchorInfoData() != null) {
                if (bVar.acQ().getAnchorInfoData().getGroup_id() != 0 && appResponseToIntentClass) {
                    if (this.cfV == null) {
                        BdLog.e("pb time   liveCardLayout new");
                        this.cfV = ((ViewStub) this.ceK.findViewById(i.f.live_card_layout)).inflate();
                        this.ccs.getLayoutMode().k(this.cfV);
                        this.cfW = (LiveBroadcastCard) this.ceK.findViewById(i.f.item_card);
                    }
                    this.cfV.setVisibility(0);
                    LiveCardData liveCardData = new LiveCardData();
                    liveCardData.setPublisherId(bVar.acQ().getAnchorInfoData().getAuthorId());
                    liveCardData.setPublisherName(bVar.acQ().getAnchorInfoData().getAuthorName());
                    liveCardData.setPublisherPortrait(bVar.acQ().getAnchorInfoData().getPublisherPortrait());
                    liveCardData.setGroupId(bVar.acQ().getAnchorInfoData().getGroup_id());
                    liveCardData.setIntro(bVar.acQ().getAnchorInfoData().getIntro());
                    liveCardData.setLikers(bVar.acQ().getAnchorInfoData().getLikers());
                    liveCardData.setListeners(bVar.acQ().getAnchorInfoData().getListeners());
                    liveCardData.setName(bVar.acQ().getAnchorInfoData().getName());
                    liveCardData.setPortrait(bVar.acQ().getAnchorInfoData().getPortrait());
                    liveCardData.setStatus(bVar.acQ().getAnchorInfoData().getStatus());
                    liveCardData.setStartTime(bVar.acQ().getAnchorInfoData().getStartTime());
                    liveCardData.setIsVip(bVar.acQ().getAnchorInfoData().getIsVip());
                    this.cfW.setData(liveCardData);
                    this.cfW.setStatisticsKey("notice_pb_live");
                } else if (this.cfV != null) {
                    this.cfV.setVisibility(8);
                }
            }
            if (bVar != null && bVar.acQ() != null && bVar.acQ().getAuthor() != null) {
                String userId = bVar.acQ().getAuthor().getUserId();
                if (userId != null && !userId.equals("0") && userId.equals(a.getAuthor().getUserId())) {
                    this.ceU.setVisibility(0);
                } else {
                    this.ceU.setVisibility(8);
                }
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.ceQ.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.ceQ, com.baidu.tbadk.core.util.c.cf(level_id));
                    i2 = 2;
                    this.ceQ.setOnClickListener(null);
                } else {
                    this.ceQ.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.al.c(this.ceQ, i.e.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.al.c(this.ceQ, i.e.pb_assist);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.al.c(this.ceR, i.e.icon_pop_girl_square);
                    this.ceR.setVisibility(0);
                } else {
                    this.ceR.setVisibility(8);
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfo = a.getAuthor().getTShowInfo();
                if (this.ceS != null) {
                    this.ceS.setTag(i.f.tag_user_id, a.getAuthor().getUserId());
                    this.ceS.setOnClickListener(this.ccs.cbM.aXJ);
                    this.ceS.a(iconInfo, i2, this.ccs.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.ccs.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.ccs.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                }
                if (this.ceT != null) {
                    this.ceT.setOnClickListener(this.ccs.cbM.cgl);
                    this.ceT.a(tShowInfo, 3, this.ccs.getResources().getDimensionPixelSize(i.d.ds30), this.ccs.getResources().getDimensionPixelSize(i.d.big_icon_height), this.ccs.getResources().getDimensionPixelSize(i.d.big_icon_margin), true);
                }
                this.ceO.setText(a.getAuthor().getName_show());
                this.ceO.setTag(i.f.tag_user_id, a.getAuthor().getUserId());
                this.ceO.setTag(i.f.tag_user_name, a.getAuthor().getName_show());
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.al.b(this.ceO, i.c.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.b(this.ceO, i.c.cp_cont_f, 1);
                }
                if (!this.ccA) {
                    this.ceP.setVisibility(8);
                }
                this.ceP.setUserId(a.getAuthor().getUserId());
                this.ceP.setUserName(a.getAuthor().getUserName());
                this.ceP.setImageDrawable(null);
                this.ceP.setTag(a.getAuthor().getUserId());
                this.ceO.setOnClickListener(this.ccs.cbM.cgk);
                this.ceP.setOnClickListener(this.ccs.cbM.cgk);
                this.ceP.d(a.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.b bVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable aeh;
        Parcelable aeh2;
        String sb;
        if (bVar != null) {
            this.cfU = false;
            this.ccB = z;
            aeD();
            b(bVar, z, i);
            this.cfe.eq(this.ccB);
            this.cfe.b(bVar);
            this.cfe.notifyDataSetChanged();
            if (bVar.acP() != null) {
                this.mForumName = bVar.acP().getName();
            }
            this.ceJ.jx(this.mForumName);
            if (bVar.acQ() != null) {
                jv(com.baidu.tbadk.core.util.aq.o(bVar.acQ().getReply_num()));
                if (bVar.acQ().getPraise() != null) {
                    if (bVar.acQ().getPraise().getNum() < 1) {
                        sb = this.ccs.getResources().getString(i.h.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(bVar.acQ().getPraise().getNum())).toString();
                    }
                    B(sb, bVar.acQ().getPraise().getIsLike() == 1);
                }
            }
            if (bVar.getPage().rQ() == 0 && !z) {
                this.aVN.setNextPage(null);
            } else if (this.ccs.isLogin()) {
                this.aVN.setNextPage(this.cfj);
                aeU();
            } else if (bVar.getPage().rQ() == 1) {
                this.cfU = true;
                if (this.cfk == null) {
                    this.cfk = new com.baidu.tieba.pb.view.b(this.ccs.getPageContext());
                }
                this.aVN.setNextPage(this.cfk);
            }
            if (bVar.getPage().rR() == 0 && z) {
                this.aVN.setPullRefresh(null);
                this.cfQ.setVisibility(8);
            } else {
                if (this.cfi == null) {
                    this.cfi = new com.baidu.tieba.pb.view.e(this.ccs.getPageContext());
                    this.cfi.nn();
                    this.cfi.a(this.afl);
                }
                this.aVN.setPullRefresh(this.cfi);
                if (this.cfi != null) {
                    this.cfi.cM(TbadkCoreApplication.m411getInst().getSkinType());
                }
                this.cfQ.setVisibility(0);
                aeU();
            }
            aeG();
            if (bVar.getPage().rQ() == 0) {
                this.cfj.setText(this.ccs.getResources().getString(i.h.list_no_more));
                k(bVar);
            } else if (z2) {
                if (this.cge) {
                    vG();
                    if (bVar.getPage().rQ() != 0) {
                        this.cfj.setText(this.ccs.getResources().getString(i.h.pb_load_more));
                    }
                } else {
                    this.cfj.showLoading();
                }
            } else {
                this.cfj.showLoading();
            }
            if (z) {
                this.cfR.setVisibility(0);
                this.aEI.setVisibility(0);
                this.cfS.setText(this.ccs.getResources().getString(i.h.btn_show_passed_pb));
            } else {
                this.cfR.setVisibility(8);
                this.aEI.setVisibility(8);
                this.cfS.setText(this.ccs.getResources().getString(i.h.btn_show_passed_pb_aftre));
            }
            if (bVar.acQ() != null && bVar.acQ().getAuthor() != null && bVar.acQ().getAuthor().getType() == 0) {
                this.ceJ.aeW();
            }
            switch (i) {
                case 2:
                    this.aVN.setSelection(i2);
                    if (this.ceL != null) {
                        CompatibleUtile.scrollListViewBy(this.aVN, -this.ceL.getHeight(), 0);
                        return;
                    }
                    return;
                case 3:
                    if (i3 == 1 && (aeh2 = bw.aeg().aeh()) != null) {
                        this.aVN.onRestoreInstanceState(aeh2);
                        return;
                    } else {
                        this.aVN.setSelection(0);
                        return;
                    }
                case 4:
                    this.cge = false;
                    if (z) {
                        this.aVN.setSelection(0);
                        return;
                    } else if (bVar.acR() != null) {
                        if (bVar.getPage() != null && bVar.getPage().rR() != 0) {
                            this.aVN.setSelection(bVar.acR().size() + 1);
                            return;
                        } else {
                            this.aVN.setSelection(bVar.acR().size());
                            return;
                        }
                    } else {
                        return;
                    }
                case 5:
                    this.aVN.setSelection(0);
                    return;
                case 6:
                    if (i3 == 1 && (aeh = bw.aeg().aeh()) != null) {
                        this.aVN.onRestoreInstanceState(aeh);
                        return;
                    } else if (z) {
                        this.aVN.setSelection(0);
                        return;
                    } else if (bVar.acR() != null) {
                        if (bVar.getPage() != null && bVar.getPage().rR() != 0) {
                            this.aVN.setSelection(bVar.acR().size() + 1);
                            return;
                        } else {
                            this.aVN.setSelection(bVar.acR().size());
                            return;
                        }
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void eG(boolean z) {
        this.cfG = z;
        this.ceJ.eG(z);
    }

    public void vG() {
        if (this.cfj != null) {
            this.cfj.vG();
        }
        aeU();
    }

    public void LQ() {
        this.aVN.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aeG() {
        boolean z;
        boolean z2 = true;
        if (this.ceL != null && this.ceL.getVisibility() == 0) {
            if (this.ceY != null) {
                this.ceY.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.ceY != null) {
                this.ceY.setVisibility(8);
            }
            z = false;
        }
        if (this.cfJ != null && this.cfJ.getVisibility() == 0) {
            if (this.ceZ != null) {
                this.ceZ.setVisibility(0);
            }
        } else {
            if (this.ceZ != null) {
                this.ceZ.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.cfb == null || this.cfb.getVisibility() == 8) && z2 && this.ccB) {
            this.cfa.setVisibility(0);
        } else {
            this.cfa.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.pb.a.b bVar, boolean z, boolean z2) {
        if (bVar == null) {
            return false;
        }
        if (this.ceN != null) {
            if (bVar.acQ().sw() == 0) {
                this.ceN.setVisibility(0);
                bVar.acQ().sF();
                this.ceN.setText(bVar.acQ().getSpan_str());
            } else {
                this.ceN.setVisibility(8);
            }
        }
        if (z) {
            if (this.cfV != null) {
                this.cfV.findViewById(i.f.pb_head_live_blank).setVisibility(8);
            }
        } else if (this.cfV != null) {
            this.cfV.findViewById(i.f.pb_head_live_blank).setVisibility(0);
        }
        this.ccB = z;
        com.baidu.tbadk.core.data.x acQ = bVar.acQ();
        if (acQ != null) {
            a(acQ.sn());
        }
        if (bVar.acU() == 1) {
            aeH();
            Button button = (Button) this.ceK.findViewById(i.f.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.ceK.findViewById(i.f.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.ceK.findViewById(i.f.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.ceK.findViewById(i.f.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.aXl);
            button2.setOnClickListener(this.aXl);
            button3.setOnClickListener(this.aXl);
            button4.setOnClickListener(this.aXl);
            if (bVar.acQ().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (bVar.acQ().getIs_top() == 1) {
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

    private void aeH() {
        if (this.ceL == null) {
            this.ceL = ((ViewStub) this.ceK.findViewById(i.f.pb_header_function_manage)).inflate();
            this.ccs.getLayoutMode().k(this.ceL);
            this.ceY = this.ceK.findViewById(i.f.new_pb_header_item_line_above_manage);
            return;
        }
        this.ceL.setVisibility(0);
    }

    public void a(com.baidu.tieba.pb.a.b bVar, boolean z, boolean z2, int i) {
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (bVar != null) {
            a(bVar, z, z2);
            com.baidu.tieba.tbadkCore.data.i a = a(bVar, z, i);
            if (a != null) {
                if (bVar.acU() != 0 && a.getAuthor() != null) {
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
                    String userId3 = bVar.acQ().getAuthor().getUserId();
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
                    sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(bVar.acU()));
                    sparseArray.put(i.f.tag_should_manage_visible, true);
                    a(i.h.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(i.f.tag_del_post_id, a.getId());
                    sparseArray2.put(i.f.tag_del_post_type, 0);
                    sparseArray2.put(i.f.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(i.f.tag_manage_user_identity, Integer.valueOf(bVar.acU()));
                    sparseArray2.put(i.f.tag_should_manage_visible, false);
                    a(i.h.delete, sparseArray2);
                }
            }
            aeG();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        aeH();
        Button button = (Button) this.ceK.findViewById(i.f.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.aXl);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.axP;
    }

    public void jw(String str) {
        if (this.cfj != null && !StringUtils.isNull(str)) {
            this.cfj.setText(str);
        }
    }

    public BdListView getListView() {
        return this.aVN;
    }

    public int aeI() {
        return i.f.richText;
    }

    public int LX() {
        return i.f.user_icon_box;
    }

    public Button aeJ() {
        return (Button) this.ceK.findViewById(i.f.pb_head_function_manage_commit_good);
    }

    public Button aeK() {
        return (Button) this.ceK.findViewById(i.f.pb_head_function_manage_cancel_good);
    }

    public Button aeL() {
        return (Button) this.ceK.findViewById(i.f.pb_head_function_manage_commit_top);
    }

    public Button aeM() {
        return (Button) this.ceK.findViewById(i.f.pb_head_function_manage_cancel_top);
    }

    public void c(BdListView.e eVar) {
        this.aVN.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.h hVar) {
        this.aVN.setOnSrollToTopListener(hVar);
    }

    public void a(x.a aVar) {
        this.afl = aVar;
        if (this.cfi != null) {
            this.cfi.a(aVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.o oVar, a.b bVar) {
        if (oVar != null) {
            int rO = oVar.rO();
            int rM = oVar.rM();
            if (this.cff != null) {
                this.cff.sU();
            } else {
                this.cff = new com.baidu.tbadk.core.dialog.a(this.ccs.getPageContext().getPageActivity());
                this.cfg = LayoutInflater.from(this.ccs.getPageContext().getPageActivity()).inflate(i.g.dialog_direct_pager, (ViewGroup) null);
                this.cff.m(this.cfg);
                this.cff.a(i.h.dialog_ok, bVar);
                this.cff.b(i.h.dialog_cancel, new cm(this));
                this.cff.b(this.ccs.getPageContext()).sU();
            }
            this.cfh = (EditText) this.cfg.findViewById(i.f.input_page_number);
            this.cfh.setText("");
            this.cfh.setOnFocusChangeListener(new cn(this));
            TextView textView = (TextView) this.cfg.findViewById(i.f.current_page_number);
            if (rO <= 0) {
                rO = 1;
            }
            if (rM <= 0) {
                rM = 1;
            }
            textView.setText(MessageFormat.format(this.ccs.getApplicationContext().getResources().getString(i.h.current_page), Integer.valueOf(rO), Integer.valueOf(rM)));
            this.ccs.ShowSoftKeyPadDelay(this.cfh, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aVN.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.ccs.showToast(str);
    }

    public boolean eH(boolean z) {
        if (this.Kz == null || !this.Kz.AO()) {
            return false;
        }
        this.Kz.zr();
        return true;
    }

    public void aeN() {
        if (this.cgf != null) {
            while (this.cgf.size() > 0) {
                TbImageView remove = this.cgf.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aeN();
    }

    public void onDestroy() {
        this.ccs.hideProgressBar();
        if (this.aNK != null && this.aST != null) {
            this.aNK.b(this.aST);
        }
        aeO();
        this.cfj.vG();
    }

    public void aeO() {
        this.ceJ.qy();
        com.baidu.adp.lib.util.k.c(this.ccs.getPageContext().getPageActivity(), this.cfh);
        if (this.cfF != null) {
            this.cfF.dismiss();
        }
        aeP();
    }

    public void eo(boolean z) {
        this.cfe.eo(z);
    }

    public void ep(boolean z) {
        this.ccA = z;
        this.cfe.ep(z);
    }

    public void eI(boolean z) {
        this.cfI = z;
    }

    public void aeP() {
        if (this.cfo != null) {
            this.cfo.dismiss();
        }
        if (this.cfp != null) {
            com.baidu.adp.lib.g.j.b(this.cfp, this.ccs.getPageContext());
        }
        if (this.cfy != null) {
            com.baidu.adp.lib.g.j.b(this.cfy, this.ccs.getPageContext());
        }
        if (this.cfm != null) {
            com.baidu.adp.lib.g.j.b(this.cfm, this.ccs.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.ccs.getLayoutMode().ad(i == 1);
        this.ccs.getLayoutMode().k(this.bYq);
        this.ccs.getLayoutMode().k(this.ceK);
        this.ccs.getLayoutMode().k(this.axP);
        this.ceJ.mNavigationBar.onChangeSkinType(this.ccs.getPageContext(), i);
        if (this.cfg != null) {
            this.ccs.getLayoutMode().k(this.cfg);
        }
        eG(this.cfG);
        this.cfe.notifyDataSetChanged();
        if (this.cfi != null) {
            this.cfi.cM(i);
        }
        if (this.cfj != null) {
            this.cfj.cM(i);
            com.baidu.tbadk.core.util.al.h(this.axP, i.e.pb_foot_more_trans_selector);
            this.cfj.cK(i.e.pb_foot_more_trans_selector);
        }
        if (this.Kz != null) {
            this.Kz.onChangeSkinType(i);
        }
        if (this.ceX != null) {
            this.ceX.cO(i);
        }
        if (this.cfk != null) {
            this.cfk.cM(i);
        }
        eC(i == 1);
    }

    public void setOnImageClickListener(TbRichTextView.c cVar) {
        this.aDG = cVar;
        this.cfe.setOnImageClickListener(this.aDG);
    }

    public void g(NoNetworkView.a aVar) {
        this.aST = aVar;
        if (this.aNK != null) {
            this.aNK.a(this.aST);
        }
    }

    public void eJ(boolean z) {
        this.cfe.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aeQ() {
        return this.cfJ;
    }

    public void k(com.baidu.tieba.pb.a.b bVar) {
        if (bVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.i> acR = bVar.acR();
            if (acR.size() == 1) {
                com.baidu.tieba.tbadkCore.data.i iVar = acR.get(0);
                if (iVar.aup() < iVar.aui().size()) {
                    this.aVN.setNextPage(null);
                    return;
                } else {
                    this.aVN.setNextPage(this.cfj);
                    return;
                }
            }
            this.aVN.setNextPage(this.cfj);
        }
    }

    public void aeR() {
        if (com.baidu.tbadk.performanceLog.y.Eo().Ep()) {
            int lastVisiblePosition = this.aVN.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aVN.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(i.f.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.s perfLog = tbImageView.getPerfLog();
                                perfLog.ey(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                                perfLog.ayR = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView.vz();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(i.f.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.s perfLog2 = headImageView.getPerfLog();
                        perfLog2.ey(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                        perfLog2.ayR = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                            }
                        }
                        headImageView.vz();
                    }
                }
            }
        }
    }

    public void eK(boolean z) {
        if (this.cfK != null && this.cfK != null) {
            if (this.cfI) {
                ez(z);
            } else {
                eA(z);
            }
        }
    }

    public void aeS() {
        if (this.cfK != null) {
            this.cfK.setVisibility(8);
        }
    }

    public TextView aeT() {
        return this.cfR;
    }

    public void Yx() {
        if (this.cfT == null) {
            this.cfT = new com.baidu.tbadk.core.view.a(this.ccs.getPageContext());
        }
        this.cfT.av(true);
    }

    public void aeU() {
        if (this.cfT != null) {
            this.cfT.av(false);
        }
    }
}
