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
    private RelativeLayout aGb;
    private NoNetworkView aNx;
    private BdTypeListView aVy;
    private View.OnClickListener aXl;
    private x.a afb;
    private View awh;
    private View.OnClickListener cbJ;
    private com.baidu.tieba.pb.b.c cbb;
    PbActivity.b cbh;
    private PbActivity cbx;
    private View cdL;
    public final com.baidu.tieba.pb.pb.main.b.a cdM;
    private View cdN;
    private ColumnLayout cdP;
    private TextView cdQ;
    private TextView cdR;
    private HeadImageView cdS;
    private ImageView cdT;
    private ImageView cdU;
    private UserIconBox cdV;
    private UserIconBox cdW;
    private ImageView cdX;
    private TextView cdY;
    private TextView cdZ;
    private View ceN;
    private TextView ceO;
    private TextView ceP;
    private TextView ceQ;
    private boolean ceS;
    private View ceY;
    private LiveBroadcastCard ceZ;
    private View ced;
    private View cef;
    private RelativeLayout ceg;
    private bd ceh;
    private PbListView cem;
    private View ceo;
    private View cfa;
    private TextView cfb;
    private PbActivity.a cff;
    private View cdO = null;
    public FrsPraiseView cea = null;
    private View ceb = null;
    private View cec = null;
    private View cee = null;
    private com.baidu.tbadk.core.dialog.a cei = null;
    private com.baidu.tbadk.core.dialog.c aXb = null;
    private View cej = null;
    private EditText cek = null;
    private com.baidu.tieba.pb.view.f cel = null;
    private com.baidu.tieba.pb.view.b cen = null;
    private c.b bxI = null;
    private TbRichTextView.c aBY = null;
    private NoNetworkView.a aSF = null;
    private Dialog cep = null;
    private View ceq = null;
    private com.baidu.tbadk.core.dialog.a cer = null;
    private Dialog ces = null;
    private View cet = null;
    private int ceu = 0;
    private RadioGroup MU = null;
    private RadioButton cev = null;
    private RadioButton cew = null;
    private RadioButton cex = null;
    private Button cey = null;
    private Button cez = null;
    private TextView ceA = null;
    private Dialog ceB = null;
    private View ceC = null;
    private RadioGroup ceD = null;
    private CompoundButton.OnCheckedChangeListener ceE = null;
    private TextView ceF = null;
    private TextView ceG = null;
    private String ceH = null;
    private com.baidu.tbadk.core.dialog.c ceI = null;
    private boolean ceJ = false;
    private String mForumName = null;
    private ScrollView ceK = null;
    private boolean ceL = false;
    private Button ceM = null;
    private boolean ceR = true;
    private LinearLayout ceT = null;
    private TextView ceU = null;
    private TextView ceV = null;
    private View aDa = null;
    private com.baidu.tbadk.core.view.a ceW = null;
    private boolean cbG = false;
    private boolean ceX = false;
    private boolean mIsFromCDN = true;
    private boolean cfc = true;
    private a.InterfaceC0069a cfd = new cc(this);
    private final View.OnClickListener cfe = new cl(this);
    private View.OnLongClickListener cfg = null;
    private boolean cfh = true;
    private final List<TbImageView> cfi = new ArrayList();
    private boolean cbF = true;

    public NoNetworkView aea() {
        return this.aNx;
    }

    public void aeb() {
        if (this.Kz != null) {
            this.Kz.hide();
        }
    }

    public void aec() {
        this.ceR = true;
        if (this.Kz != null) {
            this.Kz.hide();
        }
        if (this.ceN != null) {
            if (this.ceL) {
                er(false);
            } else {
                es(false);
            }
        }
    }

    public void er(boolean z) {
        if (this.ceN != null && this.ceO != null && this.ceP != null) {
            this.ceO.setText(i.C0057i.draft_to_send);
            this.ceP.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.ceN.startAnimation(alphaAnimation);
            }
            this.ceN.setVisibility(0);
        }
    }

    public void es(boolean z) {
        if (this.ceN != null && this.ceO != null && this.ceP != null) {
            this.ceO.setText(i.C0057i.reply_floor_host);
            this.ceP.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.ceN.startAnimation(alphaAnimation);
            }
            this.ceN.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.i aed() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.aVy == null) {
            return null;
        }
        int firstVisiblePosition = this.aVy.getFirstVisiblePosition();
        int lastVisiblePosition = this.aVy.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.aVy.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.aVy.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.aVy.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.ceh.ip(headerViewsCount) != null && this.ceh.ip(headerViewsCount) != com.baidu.tieba.tbadkCore.data.i.cIF) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.i) this.ceh.aA(i2);
    }

    public cb(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.b.c cVar) {
        this.cbx = null;
        this.aGb = null;
        this.cdL = null;
        this.aVy = null;
        this.cdN = null;
        this.cdP = null;
        this.cdQ = null;
        this.cdR = null;
        this.cdS = null;
        this.cdT = null;
        this.cdU = null;
        this.cdV = null;
        this.cdW = null;
        this.cdX = null;
        this.cdY = null;
        this.cdZ = null;
        this.ced = null;
        this.cef = null;
        this.ceh = null;
        this.cem = null;
        this.awh = null;
        this.aXl = null;
        this.cbJ = null;
        this.ceN = null;
        this.ceO = null;
        this.ceQ = null;
        this.cfa = null;
        this.cfb = null;
        this.cbx = pbActivity;
        this.aXl = onClickListener;
        this.cbb = cVar;
        this.aGb = (RelativeLayout) LayoutInflater.from(this.cbx.getPageContext().getPageActivity()).inflate(i.g.new_pb_activity, (ViewGroup) null);
        this.cbx.addContentView(this.aGb, new FrameLayout.LayoutParams(-1, -1));
        this.cdL = this.cbx.findViewById(i.f.statebar_view);
        this.ceg = (RelativeLayout) this.cbx.findViewById(i.f.title_wrapper);
        this.aNx = (NoNetworkView) this.cbx.findViewById(i.f.view_no_network);
        this.aVy = (BdTypeListView) this.cbx.findViewById(i.f.new_pb_list);
        View view = new View(this.cbx.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.cbx.getResources().getDimensionPixelSize(i.d.pb_editor_height)));
        this.aVy.addFooterView(view);
        this.cdM = new com.baidu.tieba.pb.pb.main.b.a(pbActivity);
        this.cdM.aeH().setOnTouchListener(new com.baidu.tieba.pb.b.a(new co(this)));
        this.ceN = this.cbx.findViewById(i.f.pb_editor_tool_comment);
        this.ceO = (TextView) this.cbx.findViewById(i.f.pb_editor_tool_comment_reply_text);
        this.ceQ = (TextView) this.cbx.findViewById(i.f.pb_editor_tool_comment_praise_icon);
        this.ceP = (TextView) this.cbx.findViewById(i.f.pb_editor_tool_comment_reply_count_text);
        this.ceO.setOnClickListener(new cp(this));
        this.ceQ.setOnClickListener(this.aXl);
        this.ceQ.setOnTouchListener(this.cbx);
        this.cdN = LayoutInflater.from(this.cbx.getPageContext().getPageActivity()).inflate(i.g.new_pb_header_item, (ViewGroup) null);
        this.cdP = (ColumnLayout) this.cdN.findViewById(i.f.pb_head_owner_root);
        this.cdP.setOnLongClickListener(this.cfg);
        this.cdP.setOnTouchListener(this.cbb);
        this.cdP.setVisibility(8);
        this.cdN.setOnTouchListener(this.cbb);
        this.cdQ = (TextView) this.cdN.findViewById(i.f.pb_head_post_title);
        this.cdQ.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.cdQ.setVisibility(8);
        this.cfa = this.cdN.findViewById(i.f.pb_head_activity_join_number_container);
        this.cfa.setVisibility(8);
        this.cfb = (TextView) this.cdN.findViewById(i.f.pb_head_activity_join_number);
        this.cdR = (TextView) this.cdP.findViewById(i.f.pb_head_owner_info_user_name);
        this.cdS = (HeadImageView) this.cdP.findViewById(i.f.pb_head_owner_photo);
        if (!this.cbF) {
            this.cdS.setVisibility(8);
        }
        this.cdT = (ImageView) this.cdP.findViewById(i.f.pb_head_owner_info_user_rank);
        this.cdU = (ImageView) this.cdP.findViewById(i.f.pb_head_owner_info_user_gender);
        this.cdV = (UserIconBox) this.cdP.findViewById(i.f.pb_head_owner_info_user_icon);
        this.cdW = (UserIconBox) this.cdP.findViewById(i.f.pb_head_owner_info_tshow_icon);
        this.cdX = (ImageView) this.cdP.findViewById(i.f.pb_head_owner_info_floor_owner);
        this.cdY = (TextView) this.cdP.findViewById(i.f.pb_head_owner_info_time);
        this.cdZ = (TextView) this.cdN.findViewById(i.f.pb_head_reverse_hint);
        this.cdZ.setOnClickListener(this.aXl);
        this.cdZ.setVisibility(8);
        this.ced = this.cdN.findViewById(i.f.new_pb_header_item_line_below_livepost);
        this.cef = this.cdN.findViewById(i.f.new_pb_header_item_line_above_showpassed);
        this.cdN.setOnLongClickListener(new cq(this));
        aeh();
        this.ceh = new bd(this.cbx, this.aVy);
        this.ceh.C(this.aXl);
        this.ceh.a(this.cbb);
        this.ceh.setOnImageClickListener(this.aBY);
        this.cbJ = new cr(this);
        this.ceh.B(this.cbJ);
        this.aVy.addHeaderView(this.cdN);
        this.cem = new PbListView(this.cbx.getPageContext().getPageActivity());
        this.awh = this.cem.getView().findViewById(i.f.pb_more_view);
        if (this.awh != null) {
            this.awh.setOnClickListener(this.aXl);
            com.baidu.tbadk.core.util.al.i(this.awh, i.e.pb_foot_more_trans_selector);
        }
        this.cem.vA();
        this.cem.cE(i.e.pb_foot_more_trans_selector);
        this.cem.cF(i.e.pb_foot_more_trans_selector);
        this.ceo = this.cbx.findViewById(i.f.viewstub_progress);
    }

    public void et(boolean z) {
        this.cdM.et(z);
        if (z && this.ceX) {
            this.cem.setText(this.cbx.getResources().getString(i.C0057i.click_load_more));
            this.aVy.setNextPage(this.cem);
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Kz = jVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.aGb.addView(this.Kz, layoutParams);
        this.Kz.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.Kz.hide();
    }

    public void aee() {
        if (this.cbx != null && this.Kz != null) {
            this.Kz.oy();
        }
    }

    public void jn(String str) {
        if (this.ceP != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.ceP.setText(this.cbx.getPageContext().getResources().getString(i.C0057i.pb_reply_count_text, str));
        }
    }

    public void z(String str, boolean z) {
        this.ceS = z;
        eu(TbadkCoreApplication.m411getInst().getSkinType() == 1);
    }

    private void eu(boolean z) {
        if (this.ceQ != null) {
            if (this.ceS) {
                com.baidu.tbadk.core.util.al.i((View) this.ceQ, i.e.pb_praise_already_click_selector);
            } else {
                com.baidu.tbadk.core.util.al.i((View) this.ceQ, i.e.pb_praise_normal_click_selector);
            }
        }
    }

    public TextView aef() {
        return this.ceQ;
    }

    public void ev(boolean z) {
        if (this.aVy != null) {
            if (!z) {
                this.aVy.setEnabled(z);
            } else {
                this.aVy.postDelayed(new cs(this, z), 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ew(boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cdL.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.cdL.setLayoutParams(layoutParams);
            this.cdL.setVisibility(0);
            return;
        }
        this.cdL.setVisibility(8);
    }

    public void Z(View view) {
        boolean z;
        View view2;
        if (this.ceg != null && view != null) {
            if (this.ceR) {
                z = this.ceN.getVisibility() == 0;
            } else {
                z = this.Kz != null && this.Kz.getVisibility() == 0;
            }
            boolean z2 = this.ceg.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                View findViewById = this.cbx.findViewById(i.f.bg_above_list);
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.ceg.getHeight()));
                com.baidu.tieba.tbadkCore.a.a(this.cbx, this.ceg, i.a.top_fold_up, new ct(this, findViewById));
            } else {
                com.baidu.tieba.tbadkCore.a.a(this.cbx, this.ceg, i.a.top_fold_down, new cu(this));
            }
            if (this.ceR) {
                view2 = this.ceN;
            } else {
                view2 = this.Kz;
            }
            if (z) {
                if (z2) {
                    if (this.Kz != null) {
                        this.Kz.zk();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.cbx, view2, i.a.bottom_fold_down, new cd(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.cbx, view2, i.a.bottom_fold_up, new ce(this));
            }
        }
    }

    public bd aeg() {
        return this.ceh;
    }

    public void a(PbActivity.b bVar) {
        this.cbh = bVar;
    }

    private void a(com.baidu.tbadk.core.data.y yVar) {
        if (yVar != null && yVar.sJ() != 0) {
            if (this.ceM == null) {
                this.cbx.getLayoutMode().k(((ViewStub) this.cdN.findViewById(i.f.live_talk_layout)).inflate());
                this.ceM = (Button) this.cdN.findViewById(i.f.pb_head_function_manage_go_to_live_post);
                this.cec = this.cdN.findViewById(i.f.new_pb_header_item_line_above_livepost);
            }
            int sK = yVar.sK();
            String string = this.cbx.getPageContext().getString(i.C0057i.go_to_live_post_prefix);
            if (sK == 0) {
                string = String.valueOf(string) + this.cbx.getPageContext().getString(i.C0057i.go_to_interview_post);
            } else if (sK == 1) {
                string = String.valueOf(string) + this.cbx.getPageContext().getString(i.C0057i.go_to_discuss_post);
            }
            this.ceM.setText(string);
            this.ceM.setVisibility(0);
            this.ceM.setOnClickListener(this.aXl);
            aes();
        }
    }

    private void aeh() {
        this.ceT = (LinearLayout) this.cdN.findViewById(i.f.btn_show_passed_pb);
        this.ceV = (TextView) this.cdN.findViewById(i.f.show_pre_page_view);
        this.ceU = (TextView) this.cdN.findViewById(i.f.go_back_top_view);
        this.aDa = this.cdN.findViewById(i.f.show_passed_divider);
        this.ceV.setOnClickListener(this.cfe);
        this.ceU.setOnClickListener(this.aXl);
        aes();
    }

    public void aa(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.ceq == null) {
            this.ceq = LayoutInflater.from(this.cbx.getPageContext().getPageActivity()).inflate(i.g.forum_manage_dialog, (ViewGroup) null);
        }
        this.cbx.getLayoutMode().k(this.ceq);
        if (this.cep == null) {
            this.cep = new Dialog(this.cbx.getPageContext().getPageActivity(), i.j.common_alert_dialog);
            this.cep.setCanceledOnTouchOutside(true);
            this.cep.setCancelable(true);
            this.cep.setContentView(this.ceq);
            WindowManager.LayoutParams attributes = this.cep.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.cbx.getPageContext().getPageActivity()) * 0.9d);
            this.cep.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.cep.findViewById(i.f.del_post_btn);
        TextView textView2 = (TextView) this.cep.findViewById(i.f.forbid_user_btn);
        TextView textView3 = (TextView) this.cep.findViewById(i.f.disable_reply_btn);
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
                textView3.setText(i.C0057i.un_mute);
            } else {
                textView3.setText(i.C0057i.mute);
            }
            sparseArray4.put(i.f.tag_is_mem, sparseArray.get(i.f.tag_is_mem));
            sparseArray4.put(i.f.tag_disable_reply_mute_userid, sparseArray.get(i.f.tag_disable_reply_mute_userid));
            sparseArray4.put(i.f.tag_disable_reply_mute_username, sparseArray.get(i.f.tag_disable_reply_mute_username));
            sparseArray4.put(i.f.tag_disable_reply_post_id, sparseArray.get(i.f.tag_disable_reply_post_id));
            sparseArray4.put(i.f.tag_disable_reply_thread_id, sparseArray.get(i.f.tag_disable_reply_thread_id));
            textView3.setOnClickListener(new ch(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.cep, this.cbx.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.cff = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(i.f.tag_del_post_id, str);
        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = i.C0057i.del_post_confirm;
        if (i == 0) {
            i3 = i.C0057i.del_thread_confirm;
        }
        this.cer = new com.baidu.tbadk.core.dialog.a(this.cbx.getActivity());
        this.cer.bC(i3);
        this.cer.w(sparseArray);
        this.cer.a(i.C0057i.dialog_ok, this.cbx);
        this.cer.b(i.C0057i.dialog_cancel, new ci(this));
        this.cer.aj(true);
        this.cer.b(this.cbx.getPageContext());
        this.cer.sP();
    }

    public void Q(ArrayList<com.baidu.tbadk.core.data.k> arrayList) {
        if (this.ceC == null) {
            this.ceC = LayoutInflater.from(this.cbx.getPageContext().getPageActivity()).inflate(i.g.commit_good, (ViewGroup) null);
        }
        this.cbx.getLayoutMode().k(this.ceC);
        if (this.ceB == null) {
            this.ceB = new Dialog(this.cbx.getPageContext().getPageActivity(), i.j.common_alert_dialog);
            this.ceB.setCanceledOnTouchOutside(true);
            this.ceB.setCancelable(true);
            this.ceK = (ScrollView) this.ceC.findViewById(i.f.good_scroll);
            this.ceB.setContentView(this.ceC);
            WindowManager.LayoutParams attributes = this.ceB.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.cbx.getPageContext().getPageActivity()) * 0.9d);
            this.ceB.getWindow().setAttributes(attributes);
            this.ceE = new cj(this);
            this.ceD = (RadioGroup) this.ceC.findViewById(i.f.good_class_group);
            this.ceG = (TextView) this.ceC.findViewById(i.f.dialog_button_cancel);
            this.ceG.setOnClickListener(new ck(this));
            this.ceF = (TextView) this.ceC.findViewById(i.f.dialog_button_ok);
            this.ceF.setOnClickListener(this.aXl);
        }
        this.ceD.removeAllViews();
        RadioButton radioButton = (RadioButton) LayoutInflater.from(this.cbx.getPageContext().getPageActivity()).inflate(i.g.good_class_radio_button, (ViewGroup) null);
        com.baidu.tbadk.core.util.al.i((View) radioButton, i.e.good_class_button_bg);
        com.baidu.tbadk.core.util.al.b(radioButton, i.c.text_white_selector_color, 3);
        radioButton.setTag("0");
        radioButton.setText(this.cbx.getPageContext().getString(i.C0057i.def_good_class));
        radioButton.setOnCheckedChangeListener(this.ceE);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        int dip2px = com.baidu.adp.lib.util.k.dip2px(this.cbx.getPageContext().getPageActivity(), 10.0f);
        int dip2px2 = com.baidu.adp.lib.util.k.dip2px(this.cbx.getPageContext().getPageActivity(), 5.0f);
        layoutParams.setMargins(dip2px, dip2px2, dip2px, dip2px2);
        this.ceD.addView(radioButton, layoutParams);
        this.ceD.requestLayout();
        this.ceD.check(radioButton.getId());
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.cbx.getPageContext().getPageActivity()).inflate(i.g.good_class_radio_button, (ViewGroup) null);
                com.baidu.tbadk.core.util.al.i((View) radioButton2, i.e.good_class_button_bg);
                com.baidu.tbadk.core.util.al.b(radioButton2, i.c.text_white_selector_color, 3);
                radioButton2.setButtonDrawable(17170445);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).rK()));
                radioButton2.setText(arrayList.get(i2).rJ());
                radioButton2.setOnCheckedChangeListener(this.ceE);
                this.ceD.addView(radioButton2, layoutParams);
                this.ceD.requestLayout();
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.ceK.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.cbx.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.cbx.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.cbx.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.ceK.setLayoutParams(layoutParams2);
            this.ceK.removeAllViews();
            this.ceK.addView(this.ceD);
        }
        com.baidu.adp.lib.g.j.a(this.ceB, this.cbx.getPageContext());
    }

    public void aei() {
        this.cbx.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.cbx.hideProgressBar();
        if (z && z2) {
            this.cbx.showToast(this.cbx.getPageContext().getString(i.C0057i.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.m411getInst().getResources().getString(i.C0057i.neterror);
            }
            this.cbx.showToast(str);
        }
    }

    public void UL() {
        this.ceo.setVisibility(0);
    }

    public void UK() {
        this.ceo.setVisibility(8);
    }

    public View aej() {
        if (this.ceC != null) {
            return this.ceC.findViewById(i.f.dialog_button_ok);
        }
        return null;
    }

    public String aek() {
        return this.ceH;
    }

    public View getView() {
        return this.aGb;
    }

    public void ael() {
        com.baidu.adp.lib.util.k.c(this.cbx.getPageContext().getPageActivity(), this.cbx.getCurrentFocus());
    }

    public void aem() {
        this.cbx.showProgressBar();
    }

    public void ex(boolean z) {
        this.cbx.hideProgressBar();
        aeA();
    }

    public void aen() {
        this.cem.startLoadData();
    }

    public void aeo() {
    }

    public void aep() {
        this.cbx.hideProgressBar();
        this.cem.vB();
        aeG();
        this.aVy.completePullRefresh();
        aes();
    }

    public void aeq() {
        this.aVy.completePullRefresh();
        this.ceT.setVisibility(8);
        aes();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.cfg = onLongClickListener;
        this.ceh.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.ceI != null) {
            this.ceI.dismiss();
            this.ceI = null;
        }
        this.ceI = new com.baidu.tbadk.core.dialog.c(this.cbx.getPageContext().getPageActivity());
        this.ceI.bF(i.C0057i.operation);
        if (z2) {
            this.ceI.a(new String[]{this.cbx.getPageContext().getString(i.C0057i.copy)}, bVar);
        } else if (!z) {
            this.ceI.a(new String[]{this.cbx.getPageContext().getString(i.C0057i.copy), this.cbx.getPageContext().getString(i.C0057i.mark)}, bVar);
        } else {
            this.ceI.a(new String[]{this.cbx.getPageContext().getString(i.C0057i.copy), this.cbx.getPageContext().getString(i.C0057i.remove_mark)}, bVar);
        }
        this.ceI.d(this.cbx.getPageContext());
        this.ceI.sS();
    }

    public int aer() {
        int firstVisiblePosition = this.aVy.getFirstVisiblePosition();
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.aVy.getAdapter();
        if (eVar != null) {
            if (eVar.getItem(firstVisiblePosition) instanceof com.baidu.tieba.pb.a.a) {
                firstVisiblePosition++;
            }
            int headersCount = (this.aVy.getAdapter() == null || !(this.aVy.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.aVy.getAdapter()).getHeadersCount();
            return firstVisiblePosition > headersCount ? firstVisiblePosition - headersCount : 0;
        }
        return firstVisiblePosition;
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.cek.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void h(com.baidu.tieba.pb.a.b bVar) {
        this.ceh.b(bVar);
        this.ceh.notifyDataSetChanged();
        if (bVar == null) {
            jn("");
        } else {
            jn(com.baidu.tbadk.core.util.aq.o(bVar.acH().getReply_num()));
        }
        aes();
    }

    public void i(com.baidu.tieba.pb.a.b bVar) {
        PraiseData praise;
        if (this.cea == null) {
            this.cbx.getLayoutMode().k(((ViewStub) this.cdN.findViewById(i.f.praise_layout)).inflate());
            this.cea = (FrsPraiseView) this.cdN.findViewById(i.f.pb_head_praise_view);
            this.cea.setIsFromPb(true);
            this.cee = this.cdN.findViewById(i.f.new_pb_header_item_line_above_praise);
            this.cea.cI(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.cea != null) {
            boolean aes = aes();
            if (bVar != null && bVar.acI() != null && bVar.acI().size() > 0) {
                com.baidu.tieba.tbadkCore.data.i iVar = bVar.acI().get(0);
                if ((!this.cbG || iVar.apV() != 1) && (praise = bVar.acH().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.cea.setVisibility(0);
                    this.cea.setIsFromPb(true);
                    this.cea.a(praise, bVar.acH().getId(), praise.getPostId(), true);
                    this.cee.setVisibility(0);
                    if (this.cea.getVisibility() == 0) {
                        this.cef.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.cea.setVisibility(8);
            this.cee.setVisibility(8);
            if (bVar != null && bVar.getPage() != null && bVar.getPage().rU() == 0 && this.cbG) {
                this.cee.setVisibility(8);
                if (aes) {
                    this.ced.setVisibility(0);
                    return;
                } else {
                    this.ced.setVisibility(8);
                    return;
                }
            }
            this.cee.setVisibility(0);
            this.ced.setVisibility(8);
        }
    }

    private com.baidu.tieba.tbadkCore.data.i a(com.baidu.tieba.pb.a.b bVar, boolean z, int i) {
        if (z) {
            if (bVar == null || bVar.acI() == null || bVar.acI().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.i iVar = bVar.acI().get(0);
            if (iVar.apV() != 1) {
                return j(bVar);
            }
            return iVar;
        }
        return j(bVar);
    }

    private com.baidu.tieba.tbadkCore.data.i j(com.baidu.tieba.pb.a.b bVar) {
        MetaData metaData;
        if (bVar == null || bVar.acH() == null || bVar.acH().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.i iVar = new com.baidu.tieba.tbadkCore.data.i();
        MetaData author = bVar.acH().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = bVar.acH().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        iVar.jI(1);
        iVar.setId(bVar.acH().sv());
        iVar.setTitle(bVar.acH().getTitle());
        iVar.setTime(bVar.acH().getCreateTime());
        iVar.setAuthor(metaData);
        return iVar;
    }

    private void b(com.baidu.tieba.pb.a.b bVar, boolean z, int i) {
        this.cdP.setVisibility(8);
        com.baidu.tieba.tbadkCore.data.i a = a(bVar, z, i);
        if (a != null) {
            if (z) {
                this.cdZ.setVisibility(8);
            } else {
                this.cdZ.setVisibility(0);
            }
            this.cdP.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.cdP.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.cdP.setTag(sparseArray);
            }
            sparseArray.put(i.f.tag_clip_board, a);
            sparseArray.put(i.f.tag_is_subpb, false);
            this.cdY.setText(com.baidu.tbadk.core.util.aq.m(a.getTime()));
            bVar.acH().sC();
            this.cdQ.setVisibility(0);
            this.cdQ.setText(bVar.acH().getSpan_str());
            i(bVar);
            ArrayList<com.baidu.tbadk.core.data.b> ss = bVar.acH().ss();
            if (ss != null && ss.size() > 0) {
                this.cfb.setText(String.valueOf(ss.get(0).ru()));
                this.cfa.setVisibility(0);
            } else {
                this.cfa.setVisibility(8);
            }
            com.baidu.tbadk.core.util.al.i(this.cfa, i.e.activity_join_num_bg);
            com.baidu.tbadk.core.util.al.b(this.cfb, i.c.cp_link_tip_d, 1);
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
            if (bVar != null && bVar.acH() != null && bVar.acH().getAnchorInfoData() != null) {
                if (bVar.acH().getAnchorInfoData().getGroup_id() != 0 && appResponseToIntentClass) {
                    if (this.ceY == null) {
                        BdLog.e("pb time   liveCardLayout new");
                        this.ceY = ((ViewStub) this.cdN.findViewById(i.f.live_card_layout)).inflate();
                        this.cbx.getLayoutMode().k(this.ceY);
                        this.ceZ = (LiveBroadcastCard) this.cdN.findViewById(i.f.item_card);
                    }
                    this.ceY.setVisibility(0);
                    LiveCardData liveCardData = new LiveCardData();
                    liveCardData.setPublisherId(bVar.acH().getAnchorInfoData().getAuthorId());
                    liveCardData.setPublisherName(bVar.acH().getAnchorInfoData().getAuthorName());
                    liveCardData.setPublisherPortrait(bVar.acH().getAnchorInfoData().getPublisherPortrait());
                    liveCardData.setGroupId(bVar.acH().getAnchorInfoData().getGroup_id());
                    liveCardData.setIntro(bVar.acH().getAnchorInfoData().getIntro());
                    liveCardData.setLikers(bVar.acH().getAnchorInfoData().getLikers());
                    liveCardData.setListeners(bVar.acH().getAnchorInfoData().getListeners());
                    liveCardData.setName(bVar.acH().getAnchorInfoData().getName());
                    liveCardData.setPortrait(bVar.acH().getAnchorInfoData().getPortrait());
                    liveCardData.setStatus(bVar.acH().getAnchorInfoData().getStatus());
                    liveCardData.setStartTime(bVar.acH().getAnchorInfoData().getStartTime());
                    liveCardData.setIsVip(bVar.acH().getAnchorInfoData().getIsVip());
                    this.ceZ.setData(liveCardData);
                    this.ceZ.setStatisticsKey("notice_pb_live");
                } else if (this.ceY != null) {
                    this.ceY.setVisibility(8);
                }
            }
            if (bVar != null && bVar.acH() != null && bVar.acH().getAuthor() != null) {
                String userId = bVar.acH().getAuthor().getUserId();
                if (userId != null && !userId.equals("0") && userId.equals(a.getAuthor().getUserId())) {
                    this.cdX.setVisibility(0);
                } else {
                    this.cdX.setVisibility(8);
                }
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.cdT.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.cdT, com.baidu.tbadk.core.util.c.cb(level_id));
                    i2 = 2;
                    this.cdT.setOnClickListener(null);
                } else {
                    this.cdT.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.al.c(this.cdT, i.e.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.al.c(this.cdT, i.e.pb_assist);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.al.c(this.cdU, i.e.icon_pop_girl_square);
                    this.cdU.setVisibility(0);
                } else {
                    this.cdU.setVisibility(8);
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfo = a.getAuthor().getTShowInfo();
                if (this.cdV != null) {
                    this.cdV.setTag(i.f.tag_user_id, a.getAuthor().getUserId());
                    this.cdV.setOnClickListener(this.cbx.caR.aXO);
                    this.cdV.a(iconInfo, i2, this.cbx.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.cbx.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.cbx.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                }
                if (this.cdW != null) {
                    this.cdW.setOnClickListener(this.cbx.caR.cfo);
                    this.cdW.a(tShowInfo, 3, this.cbx.getResources().getDimensionPixelSize(i.d.ds30), this.cbx.getResources().getDimensionPixelSize(i.d.big_icon_height), this.cbx.getResources().getDimensionPixelSize(i.d.big_icon_margin), true);
                }
                this.cdR.setText(a.getAuthor().getName_show());
                this.cdR.setTag(i.f.tag_user_id, a.getAuthor().getUserId());
                this.cdR.setTag(i.f.tag_user_name, a.getAuthor().getName_show());
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.al.b(this.cdR, i.c.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.b(this.cdR, i.c.cp_cont_f, 1);
                }
                if (!this.cbF) {
                    this.cdS.setVisibility(8);
                }
                this.cdS.setUserId(a.getAuthor().getUserId());
                this.cdS.setUserName(a.getAuthor().getUserName());
                this.cdS.setImageDrawable(null);
                this.cdS.setTag(a.getAuthor().getUserId());
                this.cdR.setOnClickListener(this.cbx.caR.cfn);
                this.cdS.setOnClickListener(this.cbx.caR.cfn);
                this.cdS.d(a.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.b bVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable adT;
        Parcelable adT2;
        String sb;
        if (bVar != null) {
            this.ceX = false;
            this.cbG = z;
            aep();
            b(bVar, z, i);
            this.ceh.ej(this.cbG);
            this.ceh.b(bVar);
            this.ceh.notifyDataSetChanged();
            if (bVar.acG() != null) {
                this.mForumName = bVar.acG().getName();
            }
            this.cdM.jp(this.mForumName);
            if (bVar.acH() != null) {
                jn(com.baidu.tbadk.core.util.aq.o(bVar.acH().getReply_num()));
                if (bVar.acH().getPraise() != null) {
                    if (bVar.acH().getPraise().getNum() < 1) {
                        sb = this.cbx.getResources().getString(i.C0057i.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(bVar.acH().getPraise().getNum())).toString();
                    }
                    z(sb, bVar.acH().getPraise().getIsLike() == 1);
                }
            }
            if (bVar.getPage().rT() == 0 && !z) {
                this.aVy.setNextPage(null);
            } else if (this.cbx.isLogin()) {
                this.aVy.setNextPage(this.cem);
                aeG();
            } else if (bVar.getPage().rT() == 1) {
                this.ceX = true;
                if (this.cen == null) {
                    this.cen = new com.baidu.tieba.pb.view.b(this.cbx.getPageContext());
                }
                this.aVy.setNextPage(this.cen);
            }
            if (bVar.getPage().rU() == 0 && z) {
                this.aVy.setPullRefresh(null);
                this.ceT.setVisibility(8);
            } else {
                if (this.cel == null) {
                    this.cel = new com.baidu.tieba.pb.view.f(this.cbx.getPageContext());
                    this.cel.nq();
                    this.cel.a(this.afb);
                }
                this.aVy.setPullRefresh(this.cel);
                if (this.cel != null) {
                    this.cel.cG(TbadkCoreApplication.m411getInst().getSkinType());
                }
                this.ceT.setVisibility(0);
                aeG();
            }
            aes();
            if (bVar.getPage().rT() == 0) {
                this.cem.setText(this.cbx.getResources().getString(i.C0057i.list_no_more));
                k(bVar);
            } else if (z2) {
                if (this.cfh) {
                    vB();
                    if (bVar.getPage().rT() != 0) {
                        this.cem.setText(this.cbx.getResources().getString(i.C0057i.pb_load_more));
                    }
                } else {
                    this.cem.showLoading();
                }
            } else {
                this.cem.showLoading();
            }
            if (z) {
                this.ceU.setVisibility(0);
                this.aDa.setVisibility(0);
                this.ceV.setText(this.cbx.getResources().getString(i.C0057i.btn_show_passed_pb));
            } else {
                this.ceU.setVisibility(8);
                this.aDa.setVisibility(8);
                this.ceV.setText(this.cbx.getResources().getString(i.C0057i.btn_show_passed_pb_aftre));
            }
            if (bVar.acH() != null && bVar.acH().getAuthor() != null && bVar.acH().getAuthor().getType() == 0) {
                this.cdM.aeI();
            }
            switch (i) {
                case 2:
                    this.aVy.setSelection(i2);
                    if (this.cdO != null) {
                        CompatibleUtile.scrollListViewBy(this.aVy, -this.cdO.getHeight(), 0);
                        return;
                    }
                    return;
                case 3:
                    if (i3 == 1 && (adT2 = bw.adS().adT()) != null) {
                        this.aVy.onRestoreInstanceState(adT2);
                        return;
                    } else {
                        this.aVy.setSelection(0);
                        return;
                    }
                case 4:
                    this.cfh = false;
                    if (z) {
                        this.aVy.setSelection(0);
                        return;
                    } else if (bVar.acI() != null) {
                        if (bVar.getPage() != null && bVar.getPage().rU() != 0) {
                            this.aVy.setSelection(bVar.acI().size() + 1);
                            return;
                        } else {
                            this.aVy.setSelection(bVar.acI().size());
                            return;
                        }
                    } else {
                        return;
                    }
                case 5:
                    this.aVy.setSelection(0);
                    return;
                case 6:
                    if (i3 == 1 && (adT = bw.adS().adT()) != null) {
                        this.aVy.onRestoreInstanceState(adT);
                        return;
                    } else if (z) {
                        this.aVy.setSelection(0);
                        return;
                    } else if (bVar.acI() != null) {
                        if (bVar.getPage() != null && bVar.getPage().rU() != 0) {
                            this.aVy.setSelection(bVar.acI().size() + 1);
                            return;
                        } else {
                            this.aVy.setSelection(bVar.acI().size());
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

    public void ey(boolean z) {
        this.ceJ = z;
        this.cdM.ey(z);
    }

    public void vB() {
        if (this.cem != null) {
            this.cem.vB();
        }
        aeG();
    }

    public void LZ() {
        this.aVy.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aes() {
        boolean z;
        boolean z2 = true;
        if (this.cdO != null && this.cdO.getVisibility() == 0) {
            if (this.ceb != null) {
                this.ceb.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.ceb != null) {
                this.ceb.setVisibility(8);
            }
            z = false;
        }
        if (this.ceM != null && this.ceM.getVisibility() == 0) {
            if (this.cec != null) {
                this.cec.setVisibility(0);
            }
        } else {
            if (this.cec != null) {
                this.cec.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.cee == null || this.cee.getVisibility() == 8) && z2 && this.cbG) {
            this.ced.setVisibility(0);
        } else {
            this.ced.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.pb.a.b bVar, boolean z, boolean z2) {
        if (bVar == null) {
            return false;
        }
        if (this.cdQ != null) {
            if (bVar.acH().su() == 0) {
                this.cdQ.setVisibility(0);
                bVar.acH().sC();
                this.cdQ.setText(bVar.acH().getSpan_str());
            } else {
                this.cdQ.setVisibility(8);
            }
        }
        if (z) {
            if (this.ceY != null) {
                this.ceY.findViewById(i.f.pb_head_live_blank).setVisibility(8);
            }
        } else if (this.ceY != null) {
            this.ceY.findViewById(i.f.pb_head_live_blank).setVisibility(0);
        }
        this.cbG = z;
        com.baidu.tbadk.core.data.v acH = bVar.acH();
        if (acH != null) {
            a(acH.sm());
        }
        if (bVar.acK() == 1) {
            aet();
            Button button = (Button) this.cdN.findViewById(i.f.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.cdN.findViewById(i.f.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.cdN.findViewById(i.f.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.cdN.findViewById(i.f.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.aXl);
            button2.setOnClickListener(this.aXl);
            button3.setOnClickListener(this.aXl);
            button4.setOnClickListener(this.aXl);
            if (bVar.acH().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (bVar.acH().getIs_top() == 1) {
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

    private void aet() {
        if (this.cdO == null) {
            this.cdO = ((ViewStub) this.cdN.findViewById(i.f.pb_header_function_manage)).inflate();
            this.cbx.getLayoutMode().k(this.cdO);
            this.ceb = this.cdN.findViewById(i.f.new_pb_header_item_line_above_manage);
            return;
        }
        this.cdO.setVisibility(0);
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
                if (bVar.acK() != 0 && a.getAuthor() != null) {
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
                    String userId3 = bVar.acH().getAuthor().getUserId();
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
                    sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(bVar.acK()));
                    sparseArray.put(i.f.tag_should_manage_visible, true);
                    a(i.C0057i.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(i.f.tag_del_post_id, a.getId());
                    sparseArray2.put(i.f.tag_del_post_type, 0);
                    sparseArray2.put(i.f.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(i.f.tag_manage_user_identity, Integer.valueOf(bVar.acK()));
                    sparseArray2.put(i.f.tag_should_manage_visible, false);
                    a(i.C0057i.delete, sparseArray2);
                }
            }
            aes();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        aet();
        Button button = (Button) this.cdN.findViewById(i.f.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.aXl);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.awh;
    }

    public void jo(String str) {
        if (this.cem != null && !StringUtils.isNull(str)) {
            this.cem.setText(str);
        }
    }

    public BdListView getListView() {
        return this.aVy;
    }

    public int aeu() {
        return i.f.richText;
    }

    public int Mg() {
        return i.f.user_icon_box;
    }

    public Button aev() {
        return (Button) this.cdN.findViewById(i.f.pb_head_function_manage_commit_good);
    }

    public Button aew() {
        return (Button) this.cdN.findViewById(i.f.pb_head_function_manage_cancel_good);
    }

    public Button aex() {
        return (Button) this.cdN.findViewById(i.f.pb_head_function_manage_commit_top);
    }

    public Button aey() {
        return (Button) this.cdN.findViewById(i.f.pb_head_function_manage_cancel_top);
    }

    public void c(BdListView.e eVar) {
        this.aVy.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.h hVar) {
        this.aVy.setOnSrollToTopListener(hVar);
    }

    public void a(x.a aVar) {
        this.afb = aVar;
        if (this.cel != null) {
            this.cel.a(aVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.p pVar, a.b bVar) {
        if (pVar != null) {
            int rR = pVar.rR();
            int rP = pVar.rP();
            if (this.cei != null) {
                this.cei.sP();
            } else {
                this.cei = new com.baidu.tbadk.core.dialog.a(this.cbx.getPageContext().getPageActivity());
                this.cej = LayoutInflater.from(this.cbx.getPageContext().getPageActivity()).inflate(i.g.dialog_direct_pager, (ViewGroup) null);
                this.cei.m(this.cej);
                this.cei.a(i.C0057i.dialog_ok, bVar);
                this.cei.b(i.C0057i.dialog_cancel, new cm(this));
                this.cei.b(this.cbx.getPageContext()).sP();
            }
            this.cek = (EditText) this.cej.findViewById(i.f.input_page_number);
            this.cek.setText("");
            this.cek.setOnFocusChangeListener(new cn(this));
            TextView textView = (TextView) this.cej.findViewById(i.f.current_page_number);
            if (rR <= 0) {
                rR = 1;
            }
            if (rP <= 0) {
                rP = 1;
            }
            textView.setText(MessageFormat.format(this.cbx.getApplicationContext().getResources().getString(i.C0057i.current_page), Integer.valueOf(rR), Integer.valueOf(rP)));
            this.cbx.ShowSoftKeyPadDelay(this.cek, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aVy.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.cbx.showToast(str);
    }

    public boolean ez(boolean z) {
        if (this.Kz == null || !this.Kz.AB()) {
            return false;
        }
        this.Kz.zk();
        return true;
    }

    public void aez() {
        if (this.cfi != null) {
            while (this.cfi.size() > 0) {
                TbImageView remove = this.cfi.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        aez();
    }

    public void onDestroy() {
        this.cbx.hideProgressBar();
        if (this.aNx != null && this.aSF != null) {
            this.aNx.b(this.aSF);
        }
        aeA();
        this.cem.vB();
    }

    public void aeA() {
        this.cdM.qB();
        com.baidu.adp.lib.util.k.c(this.cbx.getPageContext().getPageActivity(), this.cek);
        if (this.ceI != null) {
            this.ceI.dismiss();
        }
        aeB();
    }

    public void eh(boolean z) {
        this.ceh.eh(z);
    }

    public void ei(boolean z) {
        this.cbF = z;
        this.ceh.ei(z);
    }

    public void eA(boolean z) {
        this.ceL = z;
    }

    public void aeB() {
        if (this.cer != null) {
            this.cer.dismiss();
        }
        if (this.ces != null) {
            com.baidu.adp.lib.g.j.b(this.ces, this.cbx.getPageContext());
        }
        if (this.ceB != null) {
            com.baidu.adp.lib.g.j.b(this.ceB, this.cbx.getPageContext());
        }
        if (this.cep != null) {
            com.baidu.adp.lib.g.j.b(this.cep, this.cbx.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.cbx.getLayoutMode().ad(i == 1);
        this.cbx.getLayoutMode().k(this.aGb);
        this.cbx.getLayoutMode().k(this.cdN);
        this.cbx.getLayoutMode().k(this.awh);
        this.cdM.mNavigationBar.onChangeSkinType(this.cbx.getPageContext(), i);
        if (this.cej != null) {
            this.cbx.getLayoutMode().k(this.cej);
        }
        ey(this.ceJ);
        this.ceh.notifyDataSetChanged();
        if (this.cel != null) {
            this.cel.cG(i);
        }
        if (this.cem != null) {
            this.cem.cG(i);
            com.baidu.tbadk.core.util.al.i(this.awh, i.e.pb_foot_more_trans_selector);
            this.cem.cE(i.e.pb_foot_more_trans_selector);
        }
        if (this.Kz != null) {
            this.Kz.onChangeSkinType(i);
        }
        if (this.cea != null) {
            this.cea.cI(i);
        }
        if (this.cen != null) {
            this.cen.cG(i);
        }
        eu(i == 1);
    }

    public void setOnImageClickListener(TbRichTextView.c cVar) {
        this.aBY = cVar;
        this.ceh.setOnImageClickListener(this.aBY);
    }

    public void g(NoNetworkView.a aVar) {
        this.aSF = aVar;
        if (this.aNx != null) {
            this.aNx.a(this.aSF);
        }
    }

    public void eB(boolean z) {
        this.ceh.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button aeC() {
        return this.ceM;
    }

    public void k(com.baidu.tieba.pb.a.b bVar) {
        if (bVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.i> acI = bVar.acI();
            if (acI.size() == 1) {
                com.baidu.tieba.tbadkCore.data.i iVar = acI.get(0);
                if (iVar.aqb() < iVar.apU().size()) {
                    this.aVy.setNextPage(null);
                    return;
                } else {
                    this.aVy.setNextPage(this.cem);
                    return;
                }
            }
            this.aVy.setNextPage(this.cem);
        }
    }

    public void aeD() {
        if (com.baidu.tbadk.performanceLog.y.Ee().Ef()) {
            int lastVisiblePosition = this.aVy.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aVy.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(i.f.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.s perfLog = tbImageView.getPerfLog();
                                perfLog.eq(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                                perfLog.axj = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView.vu();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(i.f.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.s perfLog2 = headImageView.getPerfLog();
                        perfLog2.eq(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                        perfLog2.axj = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                            }
                        }
                        headImageView.vu();
                    }
                }
            }
        }
    }

    public void eC(boolean z) {
        if (this.ceN != null && this.ceN != null) {
            if (this.ceL) {
                er(z);
            } else {
                es(z);
            }
        }
    }

    public void aeE() {
        if (this.ceN != null) {
            this.ceN.setVisibility(8);
        }
    }

    public TextView aeF() {
        return this.ceU;
    }

    public void Yv() {
        if (this.ceW == null) {
            this.ceW = new com.baidu.tbadk.core.view.a(this.cbx.getPageContext());
        }
        this.ceW.av(true);
    }

    public void aeG() {
        if (this.ceW != null) {
            this.ceW.av(false);
        }
    }
}
