package com.baidu.tieba.pb.main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.frs.view.FrsPraiseView;
import com.baidu.tieba.view.PbListView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class bv {
    public static int jh = 80;
    private View.OnClickListener aCW;
    private RelativeLayout ahN;
    private NoNetworkView aty;
    private View auN;
    bg buX;
    private View.OnClickListener bvC;
    private PbActivity bwQ;
    private View bxA;
    private View bxC;
    private RelativeLayout bxD;
    private bh bxE;
    private PbListView bxK;
    public final com.baidu.tieba.pb.main.b.a bxj;
    private View bxk;
    private ColumnLayout bxm;
    private TextView bxn;
    private TextView bxo;
    private HeadImageView bxp;
    private TextView bxq;
    private ImageView bxr;
    private UserIconBox bxs;
    private UserIconBox bxt;
    private ImageView bxu;
    private TextView bxv;
    private TextView bxw;
    private View byB;
    private LiveBroadcastCard byC;
    private bf byE;
    private PbEditor byn;
    private com.baidu.tbadk.editortool.w byo;
    private View byp;
    private View byq;
    private LinearLayout byr;
    private TextView bys;
    private LinearLayout byt;
    private ImageView byu;
    private TextView byv;
    private boolean byx;
    private com.baidu.adp.widget.ListView.f uo;
    private BdListView vl;
    private View bxl = null;
    public FrsPraiseView bxx = null;
    private View bxy = null;
    private View bxz = null;
    private View bxB = null;
    private Dialog bxF = null;
    private Dialog baE = null;
    private com.baidu.tieba.pb.sub.l bxG = null;
    private View bxH = null;
    private EditText bxI = null;
    private com.baidu.tieba.view.z bxJ = null;
    private FrameLayout aCv = null;
    private View bxL = null;
    private DialogInterface.OnClickListener bal = null;
    private AbsListView.OnScrollListener bxM = null;
    private com.baidu.tbadk.widget.richText.s acf = null;
    private com.baidu.tbadk.core.view.u aBc = null;
    private Dialog bxN = null;
    private Dialog bxO = null;
    private View bxP = null;
    private Button bxQ = null;
    private Button bxR = null;
    private TextView bxS = null;
    private Dialog bxT = null;
    private View bxU = null;
    private int bxV = 0;
    private RadioGroup Oh = null;
    private RadioButton bxW = null;
    private RadioButton bxX = null;
    private RadioButton bxY = null;
    private Button bxZ = null;
    private Button bya = null;
    private TextView byb = null;
    private Dialog byc = null;
    private View byd = null;
    private RadioGroup bye = null;
    private CompoundButton.OnCheckedChangeListener byf = null;
    private Button byg = null;
    private Button byh = null;
    private String boQ = null;
    private cw byi = null;
    private Dialog byj = null;
    private boolean byk = false;
    private ScrollView byl = null;
    private Button bym = null;
    private boolean byw = true;
    private LinearLayout byy = null;
    private View byz = null;
    private PbListView byA = null;
    private boolean bvx = false;
    private boolean mIsFromCDN = true;
    private com.baidu.tieba.bubble.t aDr = new bw(this);
    private final View.OnClickListener byD = new cf(this);
    private View.OnLongClickListener byF = null;
    private boolean byG = false;
    private final List<TbImageView> byH = new ArrayList();
    private boolean bvw = true;
    private com.baidu.tieba.c.d bvB = new com.baidu.tieba.c.d(new cp(this));

    public NoNetworkView Xg() {
        return this.aty;
    }

    public void Xh() {
        this.byw = true;
        if (this.byn != null) {
            this.byn.setVisibility(8);
        }
        if (this.byq != null) {
            this.byq.setVisibility(0);
            this.byp.setVisibility(0);
        }
    }

    public com.baidu.tieba.data.ak Xi() {
        int i;
        View childAt;
        if (this.vl == null) {
            return null;
        }
        int firstVisiblePosition = this.vl.getFirstVisiblePosition();
        int lastVisiblePosition = this.vl.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.vl.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.vl.getChildAt(i3 - firstVisiblePosition)) != null) {
                    childAt.getGlobalVisibleRect(rect);
                    iArr[i3 - firstVisiblePosition] = rect.height();
                }
                i2 += iArr[i3 - firstVisiblePosition];
            }
            int i4 = i2 / 2;
            int i5 = 0;
            for (int i6 = 0; i6 < iArr.length; i6++) {
                i5 += iArr[i6];
                if (i5 > i4) {
                    i = i6 + firstVisiblePosition;
                    break;
                }
            }
        }
        i = firstVisiblePosition;
        int headerViewsCount = i - this.vl.getHeaderViewsCount();
        int i7 = headerViewsCount >= 0 ? headerViewsCount : 0;
        if (this.bxE.getItemViewType(i7) != 0) {
            i7++;
        }
        return (com.baidu.tieba.data.ak) this.bxE.getItem(i7);
    }

    public bv(PbActivity pbActivity, View.OnClickListener onClickListener) {
        this.bwQ = null;
        this.ahN = null;
        this.vl = null;
        this.bxk = null;
        this.bxm = null;
        this.bxn = null;
        this.bxo = null;
        this.bxp = null;
        this.bxq = null;
        this.bxr = null;
        this.bxs = null;
        this.bxt = null;
        this.bxu = null;
        this.bxv = null;
        this.bxw = null;
        this.bxA = null;
        this.bxC = null;
        this.bxE = null;
        this.bxK = null;
        this.auN = null;
        this.aCW = null;
        this.bvC = null;
        this.byp = null;
        this.byq = null;
        this.byr = null;
        this.bys = null;
        this.byt = null;
        this.byu = null;
        this.byv = null;
        this.bwQ = pbActivity;
        this.aCW = onClickListener;
        this.ahN = (RelativeLayout) com.baidu.adp.lib.g.b.ek().inflate(this.bwQ, com.baidu.tieba.w.new_pb_activity, null);
        this.bwQ.addContentView(this.ahN, new FrameLayout.LayoutParams(-1, -1));
        this.bxD = (RelativeLayout) this.bwQ.findViewById(com.baidu.tieba.v.title_wrapper);
        this.aty = (NoNetworkView) this.bwQ.findViewById(com.baidu.tieba.v.view_no_network);
        this.vl = (BdListView) this.bwQ.findViewById(com.baidu.tieba.v.new_pb_list);
        View view = new View(this.bwQ);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.bwQ.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_editor_height)));
        this.vl.addFooterView(view);
        this.bxj = new com.baidu.tieba.pb.main.b.a(pbActivity);
        this.bxj.Yn().setOnTouchListener(new com.baidu.tieba.c.a(new cq(this)));
        this.byq = this.bwQ.findViewById(com.baidu.tieba.v.pb_editor_tool_comment);
        this.byr = (LinearLayout) this.bwQ.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_reply);
        this.byt = (LinearLayout) this.bwQ.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_praise);
        this.byp = this.bwQ.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_line);
        this.bys = (TextView) this.bwQ.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_reply_text);
        this.byu = (ImageView) this.bwQ.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_praise_icon);
        this.byv = (TextView) this.bwQ.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_praise_text);
        this.byr.setOnClickListener(new cr(this));
        this.byt.setOnClickListener(this.aCW);
        this.byt.setOnTouchListener(this.bwQ);
        Bs();
        this.bxk = com.baidu.adp.lib.g.b.ek().inflate(this.bwQ, com.baidu.tieba.w.new_pb_header_item, null);
        this.bxm = (ColumnLayout) this.bxk.findViewById(com.baidu.tieba.v.pb_head_owner_root);
        this.bxm.setOnLongClickListener(this.byF);
        this.bxm.setOnTouchListener(this.bvB);
        this.bxm.setVisibility(8);
        this.bxk.setOnTouchListener(this.bvB);
        this.bxn = (TextView) this.bxk.findViewById(com.baidu.tieba.v.pb_head_post_title);
        this.bxn.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.bxn.setVisibility(8);
        this.bxo = (TextView) this.bxm.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_name);
        this.bxp = (HeadImageView) this.bxm.findViewById(com.baidu.tieba.v.pb_head_owner_photo);
        if (!this.bvw) {
            this.bxp.setVisibility(8);
        }
        this.bxq = (TextView) this.bxm.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_rank);
        this.bxr = (ImageView) this.bxm.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_gender);
        this.bxs = (UserIconBox) this.bxm.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_icon);
        this.bxt = (UserIconBox) this.bxm.findViewById(com.baidu.tieba.v.pb_head_owner_info_tshow_icon);
        this.bxu = (ImageView) this.bxm.findViewById(com.baidu.tieba.v.pb_head_owner_info_floor_owner);
        this.bxv = (TextView) this.bxm.findViewById(com.baidu.tieba.v.pb_head_owner_info_time);
        this.bxw = (TextView) this.bxk.findViewById(com.baidu.tieba.v.pb_head_reverse_hint);
        this.bxw.setOnClickListener(this.aCW);
        this.bxw.setVisibility(8);
        this.bxA = this.bxk.findViewById(com.baidu.tieba.v.new_pb_header_item_line_below_livepost);
        this.bxC = this.bxk.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_showpassed);
        this.bxk.setOnLongClickListener(new cs(this));
        Xu();
        this.bxE = new bh(this.bwQ);
        this.bxE.t(this.aCW);
        this.bxE.a(this.bvB);
        this.bxE.setOnImageClickListener(this.acf);
        this.bvC = new ct(this);
        this.bxE.s(this.bvC);
        this.vl.setAdapter((ListAdapter) this.bxE);
        this.vl.addHeaderView(this.bxk);
        this.bxK = new PbListView(this.bwQ);
        this.auN = this.bxK.getView().findViewById(com.baidu.tieba.v.pb_more_view);
        if (this.auN != null) {
            this.auN.setOnClickListener(this.aCW);
            com.baidu.tbadk.core.util.aw.h(this.auN, com.baidu.tieba.u.pb_foot_more_trans_selector);
        }
        this.bxK.aeR();
        this.bxK.hC(com.baidu.tieba.u.pb_foot_more_trans_selector);
        this.bxK.hD(com.baidu.tieba.u.pb_foot_more_trans_selector);
    }

    public PbEditor EO() {
        return this.byn;
    }

    public void Xj() {
        if (this.byn != null) {
            this.ahN.removeView(this.byn);
            this.byn = null;
        }
    }

    public void Xk() {
        if (this.bwQ != null) {
            this.byn = new PbEditor(this.bwQ);
            this.byn.setOrientation(1);
            this.byn.setFrom(1);
            this.byn.au(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ahN.addView(this.byn, layoutParams);
            this.byn.changeSkinType(TbadkApplication.m251getInst().getSkinType());
            Xl();
        }
    }

    public void Xl() {
        if (this.byn != null) {
            this.byn.setOnActionListener(new cu(this));
        }
    }

    public void gX(String str) {
        if (this.bys != null) {
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                this.bys.setText(str);
            } else {
                this.bys.setText(this.bwQ.getString(com.baidu.tieba.y.reply));
            }
        }
    }

    public void B(String str, boolean z) {
        this.byx = z;
        if (this.byv != null) {
            this.byv.setText(str);
            ee(TbadkApplication.m251getInst().getSkinType() == 1);
        }
    }

    private void ee(boolean z) {
        if (this.byu != null) {
            if (this.byx) {
                com.baidu.tbadk.core.util.aw.c(this.byu, com.baidu.tieba.u.icon_hand_click);
            } else {
                com.baidu.tbadk.core.util.aw.c(this.byu, com.baidu.tieba.u.icon_hand_normal);
            }
        }
    }

    public View Xm() {
        return this.byt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ef(boolean z) {
        if (this.vl != null) {
            if (!z) {
                this.vl.setEnabled(z);
            } else {
                this.vl.postDelayed(new cv(this, z), 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(View view) {
        boolean z;
        View view2;
        if (this.bxD != null && view != null) {
            if (this.byw) {
                z = this.byq.getVisibility() == 0;
            } else {
                z = this.byn != null && this.byn.getVisibility() == 0;
            }
            boolean z2 = this.bxD.getVisibility() == 0;
            if (z2) {
                com.baidu.tbadk.core.a.a(this.bwQ, this.bxD, com.baidu.tieba.p.top_fold_up, new bx(this));
            } else {
                com.baidu.tbadk.core.a.a(this.bwQ, this.bxD, com.baidu.tieba.p.top_fold_down, new by(this));
            }
            if (this.byw) {
                view2 = this.byq;
            } else {
                view2 = this.byn;
            }
            if (z) {
                if (z2) {
                    if (this.byn != null) {
                        this.byn.Cc();
                    }
                    com.baidu.tbadk.core.a.a(this.bwQ, view2, com.baidu.tieba.p.bottom_fold_down, new bz(this));
                }
            } else if (!z2) {
                com.baidu.tbadk.core.a.a(this.bwQ, view2, com.baidu.tieba.p.bottom_fold_up, new ca(this));
            }
        }
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.byn == null) {
            return null;
        }
        return this.byn.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.byn != null) {
            this.byn.setAudioData(voiceModel);
        }
    }

    public void BQ() {
        if (this.byn != null) {
            this.byn.BQ();
        }
    }

    public void Xn() {
        if (this.bxG != null) {
            this.bxG.Bt();
        }
    }

    public com.baidu.tieba.pb.sub.l Xo() {
        return this.bxG;
    }

    public void Xp() {
        if (this.bxG != null) {
            this.bxG.Bs();
        }
    }

    public VoiceData.VoiceModel Xq() {
        if (this.bxG != null) {
            return this.bxG.getAudioData();
        }
        return null;
    }

    public void Xr() {
        if (this.bxG != null) {
            this.bxG.BQ();
        }
    }

    public TextView Xs() {
        if (this.bxG == null || !(this.bxG instanceof com.baidu.tieba.pb.sub.i)) {
            return null;
        }
        return ((com.baidu.tieba.pb.sub.i) this.bxG).YU();
    }

    public bh Xt() {
        return this.bxE;
    }

    public void a(bg bgVar) {
        this.buX = bgVar;
    }

    private void a(com.baidu.tbadk.core.data.t tVar) {
        if (tVar != null && tVar.kP() != 0) {
            if (this.bym == null) {
                this.bwQ.getLayoutMode().h(((ViewStub) this.bxk.findViewById(com.baidu.tieba.v.live_talk_layout)).inflate());
                this.bym = (Button) this.bxk.findViewById(com.baidu.tieba.v.pb_head_function_manage_go_to_live_post);
                this.bxz = this.bxk.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_livepost);
            }
            int kQ = tVar.kQ();
            String string = this.bwQ.getString(com.baidu.tieba.y.go_to_live_post_prefix);
            if (kQ == 0) {
                string = String.valueOf(string) + this.bwQ.getString(com.baidu.tieba.y.go_to_interview_post);
            } else if (kQ == 1) {
                string = String.valueOf(string) + this.bwQ.getString(com.baidu.tieba.y.go_to_discuss_post);
            }
            this.bym.setText(string);
            this.bym.setVisibility(0);
            this.bym.setOnClickListener(this.aCW);
            XU();
        }
    }

    private void Xu() {
        this.byy = (LinearLayout) this.bxk.findViewById(com.baidu.tieba.v.btn_show_passed_pb);
        this.byA = new PbListView(this.bwQ, PbListView.IconType.ICON_UP_WARD);
        this.byz = this.byA.hA();
        this.byA.setText(this.bwQ.getResources().getString(com.baidu.tieba.y.btn_show_passed_pb));
        this.byz.setOnClickListener(this.byD);
        this.byy.addView(this.byz);
        this.byy.requestLayout();
        this.byy.invalidate();
        com.baidu.tbadk.core.util.aw.h(this.byz, com.baidu.tieba.s.cp_bg_line_e);
        this.byA.hC(com.baidu.tieba.s.cp_bg_line_e);
        this.byA.hD(com.baidu.tieba.s.cp_bg_line_e);
        XU();
    }

    public void W(View view) {
        if (this.bxN == null) {
            this.bxN = new Dialog(this.bwQ, com.baidu.tieba.z.common_alert_dialog);
            this.bxN.setCanceledOnTouchOutside(true);
            this.bxN.setCancelable(true);
            this.bxN.setContentView(com.baidu.adp.lib.g.b.ek().inflate(this.bwQ, com.baidu.tieba.w.forum_manage_dialog, null));
            WindowManager.LayoutParams attributes = this.bxN.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.m.n(this.bwQ) * 0.9d);
            this.bxN.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.bxN.findViewById(com.baidu.tieba.v.del_post_btn);
        Button button2 = (Button) this.bxN.findViewById(com.baidu.tieba.v.forbid_user_btn);
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if ("".equals(sparseArray.get(com.baidu.tieba.v.tag_del_post_id))) {
                button.setVisibility(8);
            } else {
                SparseArray sparseArray2 = (SparseArray) button.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    button.setTag(sparseArray2);
                }
                button.setVisibility(0);
                sparseArray2.put(com.baidu.tieba.v.tag_del_post_id, sparseArray.get(com.baidu.tieba.v.tag_del_post_id));
                sparseArray2.put(com.baidu.tieba.v.tag_del_post_type, sparseArray.get(com.baidu.tieba.v.tag_del_post_type));
                sparseArray2.put(com.baidu.tieba.v.tag_del_post_is_self, sparseArray.get(com.baidu.tieba.v.tag_del_post_is_self));
                sparseArray2.put(com.baidu.tieba.v.tag_manage_user_identity, sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity));
                button.setOnClickListener(new cb(this));
            }
            if ("".equals(sparseArray.get(com.baidu.tieba.v.tag_forbid_user_name))) {
                button2.setVisibility(8);
            } else {
                SparseArray sparseArray3 = (SparseArray) button2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    button2.setTag(sparseArray3);
                }
                button2.setVisibility(0);
                sparseArray3.put(com.baidu.tieba.v.tag_forbid_user_name, sparseArray.get(com.baidu.tieba.v.tag_forbid_user_name));
                sparseArray3.put(com.baidu.tieba.v.tag_manage_user_identity, sparseArray.get(com.baidu.tieba.v.tag_manage_user_identity));
                button2.setOnClickListener(new cc(this));
            }
            com.baidu.adp.lib.g.j.a(this.bxN, this.bwQ);
        }
    }

    public void a(bf bfVar) {
        this.byE = bfVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        if (this.bxO == null) {
            this.bxO = new Dialog(this.bwQ, com.baidu.tieba.z.common_alert_dialog);
            this.bxO.setCanceledOnTouchOutside(true);
            this.bxO.setCancelable(true);
            this.bxP = com.baidu.adp.lib.g.b.ek().inflate(this.bwQ, com.baidu.tieba.w.del_post, null);
            this.bxO.setContentView(this.bxP);
            WindowManager.LayoutParams attributes = this.bxO.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.m.n(this.bwQ) * 0.9d);
            this.bxO.getWindow().setAttributes(attributes);
            this.bxQ = (Button) this.bxP.findViewById(com.baidu.tieba.v.dialog_button_ok);
            this.bxQ.setOnClickListener(this.aCW);
            this.bxR = (Button) this.bxP.findViewById(com.baidu.tieba.v.dialog_button_cancel);
            this.bxR.setOnClickListener(new cd(this));
            this.bxS = (TextView) this.bxP.findViewById(com.baidu.tieba.v.confirm_text);
        }
        SparseArray sparseArray = (SparseArray) this.bxQ.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.bxQ.setTag(sparseArray);
        }
        sparseArray.put(com.baidu.tieba.v.tag_del_post_id, str);
        sparseArray.put(com.baidu.tieba.v.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z));
        if (i == 0) {
            this.bxS.setText(com.baidu.tieba.y.del_thread_confirm);
        } else {
            this.bxS.setText(com.baidu.tieba.y.del_post_confirm);
        }
        com.baidu.adp.lib.g.j.a(this.bxO, this.bwQ);
    }

    public void B(ArrayList<com.baidu.tbadk.core.data.h> arrayList) {
        if (this.byc == null) {
            this.byc = new Dialog(this.bwQ, com.baidu.tieba.z.common_alert_dialog);
            this.byc.setCanceledOnTouchOutside(true);
            this.byc.setCancelable(true);
            this.byd = com.baidu.adp.lib.g.b.ek().inflate(this.bwQ, com.baidu.tieba.w.commit_good, null);
            this.byl = (ScrollView) this.byd.findViewById(com.baidu.tieba.v.good_scroll);
            this.byc.setContentView(this.byd);
            WindowManager.LayoutParams attributes = this.byc.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.m.n(this.bwQ) * 0.9d);
            this.byc.getWindow().setAttributes(attributes);
            this.byf = new ce(this);
            this.bye = (RadioGroup) this.byd.findViewById(com.baidu.tieba.v.good_class_group);
            this.byh = (Button) this.byd.findViewById(com.baidu.tieba.v.dialog_button_cancel);
            this.byh.setOnClickListener(new cg(this));
            this.byg = (Button) this.byd.findViewById(com.baidu.tieba.v.dialog_button_ok);
            this.byg.setOnClickListener(this.aCW);
        }
        this.bye.removeAllViews();
        RadioButton radioButton = (RadioButton) com.baidu.adp.lib.g.b.ek().inflate(this.bwQ, com.baidu.tieba.w.good_class_radio_button, null);
        radioButton.setTag("0");
        radioButton.setText(this.bwQ.getString(com.baidu.tieba.y.def_good_class));
        radioButton.setOnCheckedChangeListener(this.byf);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(com.baidu.adp.lib.util.m.dip2px(this.bwQ, 10.0f), com.baidu.adp.lib.util.m.dip2px(this.bwQ, 5.0f), com.baidu.adp.lib.util.m.dip2px(this.bwQ, 10.0f), com.baidu.adp.lib.util.m.dip2px(this.bwQ, 5.0f));
        this.bye.addView(radioButton, layoutParams);
        this.bye.requestLayout();
        this.bye.check(radioButton.getId());
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                RadioButton radioButton2 = (RadioButton) com.baidu.adp.lib.g.b.ek().inflate(this.bwQ, com.baidu.tieba.w.good_class_radio_button, null);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).jX()));
                radioButton2.setText(arrayList.get(i2).jW());
                radioButton2.setOnCheckedChangeListener(this.byf);
                this.bye.addView(radioButton2, layoutParams);
                this.bye.requestLayout();
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.byl.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.m.dip2px(this.bwQ, 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.m.dip2px(this.bwQ, 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.m.dip2px(this.bwQ, 220.0f);
                    break;
            }
            this.byl.setLayoutParams(layoutParams2);
            this.byl.removeAllViews();
            this.byl.addView(this.bye);
        }
        com.baidu.adp.lib.g.j.a(this.byc, this.bwQ);
    }

    public void Xv() {
        this.bwQ.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.bwQ.hideProgressBar();
        if (z && z2) {
            this.bwQ.showToast(this.bwQ.getString(com.baidu.tieba.y.success));
        } else if (str != null && z2) {
            this.bwQ.showToast(str);
        }
    }

    public void GG() {
        this.ahN.removeView(this.aCv);
    }

    public View Xw() {
        if (this.bxP != null) {
            return this.bxP.findViewById(com.baidu.tieba.v.dialog_button_ok);
        }
        return null;
    }

    public View Xx() {
        if (this.byd != null) {
            return this.byd.findViewById(com.baidu.tieba.v.dialog_button_ok);
        }
        return null;
    }

    public String Xy() {
        return this.boQ;
    }

    public View Xz() {
        if (this.bxG != null) {
            return this.bxG.Zj();
        }
        return null;
    }

    public View getView() {
        return this.ahN;
    }

    public void XA() {
        View editText;
        if (this.byn == null) {
            editText = this.bwQ.getCurrentFocus();
        } else {
            editText = this.byn.getEditText();
        }
        com.baidu.adp.lib.util.m.b(this.bwQ, editText);
    }

    public void ET() {
        if (this.bxG != null) {
            this.bxG.Zl();
        } else {
            this.bwQ.showProgressBar();
        }
    }

    public void bQ(boolean z) {
        if (this.bxG != null) {
            this.bxG.Zm();
        } else {
            this.bwQ.hideProgressBar();
        }
        Yd();
        if (z) {
            if (this.byn != null) {
                this.byn.getEditText().setText("");
                this.byn.BY();
                this.byn.clearData();
            }
            if (this.bxG != null) {
                this.bxG.Zh();
            }
        }
    }

    public void XB() {
        this.bxK.YH();
    }

    public void XC() {
    }

    public void XD() {
        this.bwQ.hideProgressBar();
        this.bxK.XT();
        this.byA.XT();
        this.vl.hN();
        XU();
    }

    public void XE() {
        this.vl.hN();
        this.byy.setVisibility(8);
        XU();
    }

    public void eg(boolean z) {
        if (!z) {
            if (this.byn != null) {
                this.byn.Ca();
            }
        } else if (this.bxG != null) {
            this.bxG.hd(null);
        }
    }

    public void XF() {
        if (XJ() && this.bxG != null) {
            this.bxG.Cf();
        }
    }

    public void XG() {
        if (this.bxG == null) {
            this.bxG = new com.baidu.tieba.pb.sub.l(this.bwQ, this.byG, this.aCW, this.bvC, this.bwQ.buM.byU, this.bwQ.buM.byV, this.bwQ.buM.byW);
            this.bxG.setOnActionListener(this.byo);
            this.bxG.setOnScrollListener(this.bxM);
            this.bxG.dX(this.bxE.Wy());
            this.bxG.dY(this.bxE.Wz());
            this.bxL = this.bxG.getRootView();
            this.bxG.setOnImageClickListener(this.acf);
            this.bxG.setOnEmotionClickListener(this.bwQ.buM.byX);
            this.bxG.setOnLongClickListener(this.bxE.Wx());
        }
        this.bxL.setVisibility(0);
        this.bxG.ep(this.mIsFromCDN);
        this.bxG.XA();
        this.ahN.addView(this.bxL);
        Yg();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.byo = wVar;
            if (this.byn != null) {
                Xl();
            }
            if (this.bxG != null) {
                this.bxG.setOnActionListener(wVar);
            }
        }
    }

    public void a(cw cwVar) {
        this.byi = cwVar;
    }

    public void a(boolean z, com.baidu.tieba.data.ar arVar, boolean z2, String str, String str2, View view, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        if (arVar != null && view != null) {
            TiebaStatic.eventStat(this.bwQ, "pb_tosubpb", "pbclick", 1, new Object[0]);
            if (this.bxG == null) {
                this.bxG = new com.baidu.tieba.pb.sub.l(this.bwQ, this.byG, this.aCW, this.bvC, this.bwQ.buM.byU, this.bwQ.buM.byV, this.bwQ.buM.byW);
                this.bxG.setOnActionListener(this.byo);
                this.bxG.setOnScrollListener(this.bxM);
                this.bxG.dX(this.bxE.Wy());
                this.bxG.dY(this.bxE.Wz());
                this.bxL = this.bxG.getRootView();
                this.bxG.setOnImageClickListener(this.acf);
                this.bxG.setOnEmotionClickListener(this.bwQ.buM.byX);
                this.bxG.setOnLongClickListener(this.bxE.Wx());
            }
            this.bxG.gT(this.bxE.getWidth());
            this.bxG.a(arVar, i);
            this.bxG.ep(this.mIsFromCDN);
            if (str2 != null && !str2.equals("")) {
                this.bxG.hf(str2);
            } else {
                this.bxG.setPosition(1);
            }
            int i2 = 0;
            if (this.bxD.getVisibility() == 0) {
                i2 = this.bxD.getHeight();
            }
            int top = view.getTop() + i2;
            int bottom = view.getBottom() + i2;
            if (!z) {
                this.bxG.Zd();
            }
            int height = ((view.getHeight() + this.bwQ.getResources().getDimensionPixelSize(com.baidu.tieba.t.subpb_listitem_packup_min_height)) - this.bwQ.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_list_item_border_bottom_margin_top)) - this.ahN.getHeight();
            if (height > 0) {
                top += height;
            }
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, top, 0.0f);
            translateAnimation.setDuration(300L);
            this.bxL.setAnimation(translateAnimation);
            try {
                this.ahN.invalidate();
                this.ahN.buildDrawingCache();
                bitmap = this.ahN.getDrawingCache();
            } catch (Throwable th) {
                BdLog.detailException(th);
                bitmap = null;
            }
            Bitmap bitmap4 = null;
            if (bitmap == null) {
                bitmap2 = null;
                bitmap3 = null;
            } else {
                if (bottom > 0 && bottom < bitmap.getHeight()) {
                    try {
                        bitmap4 = Bitmap.createBitmap(bitmap, 0, bottom, bitmap.getWidth(), bitmap.getHeight() - bottom);
                    } catch (Throwable th2) {
                        bitmap4 = null;
                    }
                }
                if (top < i2) {
                    top = i2;
                }
                if (top <= 0 || top >= bitmap.getHeight()) {
                    bitmap2 = null;
                    bitmap3 = bitmap4;
                } else {
                    try {
                        bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), top);
                        bitmap3 = bitmap4;
                    } catch (Throwable th3) {
                        bitmap2 = null;
                        bitmap3 = bitmap4;
                    }
                }
            }
            this.bxL.setVisibility(0);
            if (this.bxL.getParent() == this.ahN) {
                this.ahN.removeView(this.bxL);
            }
            this.ahN.addView(this.bxL, new RelativeLayout.LayoutParams(-1, -1));
            if (bitmap2 != null) {
                ImageView imageView = new ImageView(this.bwQ);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(10);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageBitmap(bitmap2);
                this.ahN.addView(imageView);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -top);
                translateAnimation2.setDuration(300L);
                imageView.setAnimation(translateAnimation2);
                translateAnimation2.setAnimationListener(new ch(this, imageView));
                translateAnimation2.setInterpolator(accelerateInterpolator);
                translateAnimation2.start();
            }
            translateAnimation.setAnimationListener(new cj(this, arVar, z, str, str2));
            translateAnimation.setInterpolator(accelerateInterpolator);
            if (bitmap3 != null) {
                ImageView imageView2 = new ImageView(this.bwQ);
                imageView2.setImageBitmap(bitmap3);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(12);
                imageView2.setLayoutParams(layoutParams2);
                this.ahN.addView(imageView2);
                TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, 0.0f, bitmap3 == null ? 0 : bitmap3.getHeight());
                translateAnimation3.setDuration(300L);
                imageView2.setAnimation(translateAnimation3);
                translateAnimation3.setAnimationListener(new cl(this, imageView2));
                translateAnimation3.setInterpolator(accelerateInterpolator);
                translateAnimation3.start();
            }
            translateAnimation.start();
        }
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.byF = onLongClickListener;
        this.bxE.setOnLongClickListener(onLongClickListener);
        if (this.bxG != null) {
            this.bxG.setOnLongClickListener(onLongClickListener);
        }
    }

    public void XH() {
        if (XJ()) {
            this.bxG.Ze();
        }
    }

    public void XI() {
        if (XJ() && (this.bxG instanceof com.baidu.tieba.pb.sub.i)) {
            ((com.baidu.tieba.pb.sub.i) this.bxG).YX();
        }
    }

    public boolean XJ() {
        return (this.bxL == null || this.bxL.getVisibility() == 8) ? false : true;
    }

    public void XK() {
        if (this.bxL != null) {
            this.bxL.setVisibility(8);
            this.ahN.removeView(this.bxL);
            this.bxG.Zf();
        }
        Yd();
        Yh();
    }

    public void XL() {
        if (this.bxL != null) {
            if (this.ahN != null) {
                this.ahN.removeView(this.bxL);
            }
            this.bxL = null;
        }
        if (this.bxG != null) {
            this.bxG.Zf();
            this.bxG = null;
        }
    }

    public void XM() {
        if (this.bxG != null) {
            this.bxG.Zn();
            if (this.bxG instanceof com.baidu.tieba.pb.sub.i) {
                ((com.baidu.tieba.pb.sub.i) this.bxG).YY();
            }
        }
    }

    public void a(com.baidu.tieba.data.ar arVar, int i) {
        if (this.bxG != null) {
            this.bxG.Zn();
            this.bxG.gT(this.bxE.getWidth());
            this.bxG.a(arVar, i);
        }
    }

    public void XN() {
        if (this.bxG == null) {
            this.bxG = new com.baidu.tieba.pb.sub.i(this.bwQ, this.byG, this.aCW, this.bvC, this.bwQ.buM.byU, this.bwQ.buM.byV, this.bwQ.buM.byW);
            this.bxG.setOnActionListener(this.byo);
            this.bxG.setOnScrollListener(this.bxM);
            this.bxG.dX(this.bxE.Wy());
            this.bxG.dY(this.bxE.Wz());
            this.bxL = this.bxG.getRootView();
            this.bxG.setOnImageClickListener(this.acf);
            this.bxG.setOnEmotionClickListener(this.bwQ.buM.byX);
            this.bxG.setOnLongClickListener(this.bxE.Wx());
        }
        this.bxL.setVisibility(0);
        this.bxG.XA();
        this.ahN.addView(this.bxL);
        Yg();
    }

    public void a(com.baidu.tieba.data.ar arVar, int i, String str, boolean z, boolean z2) {
        if (this.bxG != null && (this.bxG instanceof com.baidu.tieba.pb.sub.i)) {
            com.baidu.tieba.pb.sub.i iVar = (com.baidu.tieba.pb.sub.i) this.bxG;
            this.bxG.Zn();
            this.bxG.gT(this.bxE.getWidth());
            this.bxG.a(arVar, i);
            if (z2) {
                iVar.hc(str);
            }
            if (!z) {
                iVar.YZ();
            } else {
                iVar.Za();
            }
        }
    }

    public void o(ArrayList<String> arrayList) {
        if (this.byn != null) {
            this.byn.o(arrayList);
        }
    }

    public void C(ArrayList<String> arrayList) {
        if (this.bxG != null) {
            this.bxG.o(arrayList);
        }
    }

    public void Bt() {
        this.byG = true;
        if (this.byn != null) {
            this.byn.Bt();
        }
    }

    public void Bs() {
        this.byG = false;
        if (this.byn != null) {
            this.byn.Bs();
        }
    }

    public void a(DialogInterface.OnClickListener onClickListener, boolean z, boolean z2) {
        if (this.byj != null) {
            com.baidu.adp.lib.g.j.b(this.byj, this.bwQ);
            this.byj = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.bwQ);
        builder.setTitle(com.baidu.tieba.y.operation);
        if (z2) {
            builder.setItems(new String[]{this.bwQ.getString(com.baidu.tieba.y.copy)}, onClickListener);
        } else if (!z) {
            builder.setItems(new String[]{this.bwQ.getString(com.baidu.tieba.y.copy), this.bwQ.getString(com.baidu.tieba.y.mark)}, onClickListener);
        } else {
            builder.setItems(new String[]{this.bwQ.getString(com.baidu.tieba.y.copy), this.bwQ.getString(com.baidu.tieba.y.remove_mark)}, onClickListener);
        }
        this.byj = builder.create();
        this.byj.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.j.a(this.byj, this.bwQ);
    }

    public void setAudioFocusable(boolean z) {
        if (this.byn != null) {
            this.byn.setAudioFocusable(z);
        }
    }

    public void eh(boolean z) {
        if (this.bxG != null) {
            this.bxG.setAudioFocusable(z);
        }
    }

    public void h(Bitmap bitmap) {
        if (this.byn != null) {
            this.byn.h(bitmap);
            this.byn.BX();
        }
    }

    public void XO() {
        if (this.byn != null) {
            this.byn.h(null);
        }
    }

    public int XP() {
        int firstVisiblePosition = this.vl.getFirstVisiblePosition();
        com.baidu.adp.widget.ListView.j jVar = (com.baidu.adp.widget.ListView.j) this.vl.getAdapter();
        if (jVar != null) {
            if (jVar.getItem(firstVisiblePosition) instanceof com.baidu.tieba.data.ag) {
                firstVisiblePosition++;
            }
            int headersCount = (this.vl.getAdapter() == null || !(this.vl.getAdapter() instanceof com.baidu.adp.widget.ListView.j)) ? 0 : ((com.baidu.adp.widget.ListView.j) this.vl.getAdapter()).getHeadersCount();
            return firstVisiblePosition > headersCount ? firstVisiblePosition - headersCount : 0;
        }
        return firstVisiblePosition;
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.bxI.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public String EU() {
        return this.byn == null ? "" : this.byn.getContent();
    }

    public void fc(String str) {
        if (this.byn != null) {
            this.byn.setContent(str);
        }
    }

    public String XQ() {
        if (this.bxG == null) {
            return null;
        }
        return this.bxG.Zk();
    }

    public String XR() {
        if (this.bxG != null) {
            return this.bxG.Zg();
        }
        return null;
    }

    public String XS() {
        if (this.bxG != null) {
            return this.bxG.Zb();
        }
        return null;
    }

    public void e(com.baidu.tieba.data.ah ahVar) {
        this.bxE.b(ahVar);
        this.bxE.notifyDataSetChanged();
        if (ahVar == null) {
            gX("");
        } else {
            gX(new StringBuilder(String.valueOf(ahVar.zK().getReply_num())).toString());
        }
        XU();
    }

    public void f(com.baidu.tieba.data.ah ahVar) {
        PraiseData praise;
        if (this.bxx == null) {
            this.bwQ.getLayoutMode().h(((ViewStub) this.bxk.findViewById(com.baidu.tieba.v.praise_layout)).inflate());
            this.bxx = (FrsPraiseView) this.bxk.findViewById(com.baidu.tieba.v.pb_head_praise_view);
            this.bxx.setIsFromPb(true);
            this.bxB = this.bxk.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_praise);
            this.bxx.bN(TbadkApplication.m251getInst().getSkinType());
        }
        if (this.bxx != null) {
            boolean XU = XU();
            if (ahVar != null && ahVar.zL() != null && ahVar.zL().size() > 0) {
                com.baidu.tieba.data.ak akVar = ahVar.zL().get(0);
                if ((!this.bvx || akVar.Ae() != 1) && (praise = ahVar.zK().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.bxx.setVisibility(0);
                    this.bxx.setIsFromPb(true);
                    this.bxx.a(praise, ahVar.zK().getId(), praise.getPostId(), true);
                    this.bxB.setVisibility(0);
                    if (this.bxx.getVisibility() == 0) {
                        this.bxC.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.bxx.setVisibility(8);
            this.bxB.setVisibility(8);
            if (ahVar != null && ahVar.zM() != null && ahVar.zM().ki() == 0 && this.bvx) {
                this.bxB.setVisibility(8);
                if (XU) {
                    this.bxA.setVisibility(0);
                    return;
                } else {
                    this.bxA.setVisibility(8);
                    return;
                }
            }
            this.bxB.setVisibility(0);
            this.bxA.setVisibility(8);
        }
    }

    private com.baidu.tieba.data.ak a(com.baidu.tieba.data.ah ahVar, boolean z, int i) {
        if (z) {
            if (ahVar == null || ahVar.zL() == null || ahVar.zL().size() <= 0) {
                return null;
            }
            com.baidu.tieba.data.ak akVar = ahVar.zL().get(0);
            if (akVar.Ae() != 1) {
                return g(ahVar);
            }
            return akVar;
        }
        return g(ahVar);
    }

    private com.baidu.tieba.data.ak g(com.baidu.tieba.data.ah ahVar) {
        MetaData metaData;
        if (ahVar == null || ahVar.zK() == null || ahVar.zK().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.data.ak akVar = new com.baidu.tieba.data.ak();
        MetaData author = ahVar.zK().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = ahVar.zK().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        akVar.eg(1);
        akVar.setId(ahVar.zK().kG());
        akVar.setTitle(ahVar.zK().getTitle());
        akVar.setTime(ahVar.zK().getCreateTime());
        akVar.a(metaData);
        return akVar;
    }

    private void b(com.baidu.tieba.data.ah ahVar, boolean z, int i) {
        this.bxm.setVisibility(8);
        com.baidu.tieba.data.ak a = a(ahVar, z, i);
        if (a != null) {
            if (z) {
                this.bxw.setVisibility(8);
            } else {
                this.bxw.setVisibility(0);
            }
            this.bxm.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.bxm.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.bxm.setTag(sparseArray);
            }
            sparseArray.put(com.baidu.tieba.v.tag_clip_board, a);
            sparseArray.put(com.baidu.tieba.v.tag_is_subpb, false);
            this.bxv.setText(com.baidu.tbadk.core.util.ay.j(a.getTime()));
            ahVar.zK().parser_title();
            this.bxn.setVisibility(0);
            this.bxn.setText(ahVar.zK().getSpan_str());
            f(ahVar);
            if (ahVar.zK().getAnchorInfoData().getGroup_id() != 0) {
                if (this.byB == null) {
                    BdLog.e("pb time   liveCardLayout new");
                    this.byB = ((ViewStub) this.bxk.findViewById(com.baidu.tieba.v.live_card_layout)).inflate();
                    this.bwQ.getLayoutMode().h(this.byB);
                    this.byC = (LiveBroadcastCard) this.bxk.findViewById(com.baidu.tieba.v.item_card);
                }
                this.byB.setVisibility(0);
                LiveCardData liveCardData = new LiveCardData();
                liveCardData.setPublisherId(ahVar.zK().getAnchorInfoData().getAuthorId());
                liveCardData.setPublisherName(ahVar.zK().getAnchorInfoData().getAuthorName());
                liveCardData.setPublisherPortrait(ahVar.zK().getAnchorInfoData().getPublisherPortrait());
                liveCardData.setGroupId(ahVar.zK().getAnchorInfoData().getGroup_id());
                liveCardData.setIntro(ahVar.zK().getAnchorInfoData().getIntro());
                liveCardData.setLikers(ahVar.zK().getAnchorInfoData().getLikers());
                liveCardData.setListeners(ahVar.zK().getAnchorInfoData().getListeners());
                liveCardData.setName(ahVar.zK().getAnchorInfoData().getName());
                liveCardData.setPortrait(ahVar.zK().getAnchorInfoData().getPortrait());
                liveCardData.setStatus(ahVar.zK().getAnchorInfoData().getStatus());
                liveCardData.setStartTime(ahVar.zK().getAnchorInfoData().getStartTime());
                this.byC.setData(liveCardData);
                this.byC.setStatisticsKey("notice_pb_live");
            } else if (this.byB != null) {
                this.byB.setVisibility(8);
            }
            String userId = ahVar.zK().getAuthor().getUserId();
            if (userId != null && !userId.equals("0") && userId.equals(a.getAuthor().getUserId())) {
                this.bxu.setVisibility(0);
            } else {
                this.bxu.setVisibility(8);
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.bxq.setVisibility(0);
                    this.bxq.setText(String.valueOf(level_id));
                    com.baidu.tbadk.core.util.aw.h((View) this.bxq, com.baidu.tbadk.core.util.d.bn(level_id));
                    i2 = 2;
                    this.bxq.setOnClickListener(null);
                } else {
                    this.bxq.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.bxq.setText((CharSequence) null);
                        com.baidu.tbadk.core.util.aw.h((View) this.bxq, com.baidu.tieba.u.pb_manager);
                        this.bxq.setOnClickListener(this.bwQ.buM.byV);
                    } else if (bawu_type.equals("assist")) {
                        this.bxq.setText((CharSequence) null);
                        com.baidu.tbadk.core.util.aw.h((View) this.bxq, com.baidu.tieba.u.pb_assist);
                        this.bxq.setOnClickListener(this.bwQ.buM.byV);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.aw.c(this.bxr, com.baidu.tieba.u.icon_pop_girl_square);
                    this.bxr.setVisibility(0);
                } else {
                    this.bxr.setVisibility(8);
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfo = a.getAuthor().getTShowInfo();
                if (this.bxs != null) {
                    this.bxs.setOnClickListener(this.bwQ.buM.byV);
                    this.bxs.a(iconInfo, i2, this.bwQ.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_width), this.bwQ.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_height), this.bwQ.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_margin));
                }
                if (this.bxt != null) {
                    this.bxt.setOnClickListener(this.bwQ.buM.byW);
                    this.bxt.a(tShowInfo, 3, this.bwQ.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.bwQ.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.bwQ.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                }
                this.bxo.setText(a.getAuthor().getName_show());
                this.bxo.setTag(a.getAuthor().getUserId());
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.aw.b(this.bxo, com.baidu.tieba.s.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aw.b(this.bxo, com.baidu.tieba.s.cp_cont_f, 1);
                }
                if (!this.bvw) {
                    this.bxp.setVisibility(8);
                }
                this.bxp.setUserId(a.getAuthor().getUserId());
                this.bxp.setImageDrawable(null);
                this.bxp.setTag(a.getAuthor().getUserId());
                this.bxo.setOnClickListener(this.bwQ.buM.byU);
                this.bxp.setOnClickListener(this.bwQ.buM.byU);
                this.bxp.c(a.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void a(com.baidu.tieba.data.ah ahVar, int i, int i2, boolean z, int i3) {
        Parcelable Xa;
        Parcelable Xa2;
        String sb;
        this.bvx = z;
        XD();
        b(ahVar, z, i);
        this.bxE.dW(this.bvx);
        this.bxE.b(ahVar);
        this.bxE.notifyDataSetChanged();
        this.bxj.gY(ahVar.zJ().getName());
        if (ahVar.zK() != null) {
            gX(new StringBuilder(String.valueOf(ahVar.zK().getReply_num())).toString());
            if (ahVar.zK().getPraise() != null) {
                if (ahVar.zK().getPraise().getNum() < 1) {
                    sb = this.bwQ.getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(ahVar.zK().getPraise().getNum())).toString();
                }
                B(sb, ahVar.zK().getPraise().getIsLike() == 1);
            }
        }
        if (ahVar.zM().kh() == 0 && !z) {
            this.vl.setNextPage(null);
        } else {
            this.vl.setNextPage(this.bxK);
            this.byA.XT();
        }
        if (ahVar.zM().ki() == 0 && z) {
            this.vl.setPullRefresh(null);
            this.byy.setVisibility(8);
        } else {
            if (this.bxJ == null) {
                this.bxJ = new com.baidu.tieba.view.z(this.bwQ);
                this.bxJ.hA();
                this.bxJ.a(this.uo);
            }
            this.vl.setPullRefresh(this.bxJ);
            if (this.bxJ != null) {
                this.bxJ.bM(TbadkApplication.m251getInst().getSkinType());
            }
            this.byy.setVisibility(0);
            this.byA.XT();
        }
        XU();
        if (ahVar.zM().kh() == 0) {
            this.bxK.setText(this.bwQ.getResources().getString(com.baidu.tieba.y.no_more_to_load));
            h(ahVar);
        } else {
            this.bxK.setText(this.bwQ.getResources().getString(com.baidu.tieba.y.pb_load_more));
        }
        if (z) {
            this.byA.setText(this.bwQ.getResources().getString(com.baidu.tieba.y.btn_show_passed_pb));
        } else {
            this.byA.setText(this.bwQ.getResources().getString(com.baidu.tieba.y.btn_show_passed_pb_aftre));
        }
        if (ahVar.zK() != null && ahVar.zK().getAuthor() != null && ahVar.zK().getAuthor().getType() == 0) {
            this.bxj.Yo();
        }
        switch (i) {
            case 2:
                this.vl.setSelection(i2);
                if (this.bxl != null) {
                    CompatibleUtile.scrollListViewBy(this.vl, -this.bxl.getHeight(), 0);
                    return;
                }
                return;
            case 3:
                if (i3 == 1 && (Xa2 = bs.WZ().Xa()) != null) {
                    this.vl.onRestoreInstanceState(Xa2);
                    return;
                } else {
                    this.vl.setSelection(0);
                    return;
                }
            case 4:
                if (z) {
                    this.vl.setSelection(0);
                    return;
                } else if (ahVar.zL() != null) {
                    if (ahVar.zM() != null && ahVar.zM().ki() != 0) {
                        this.vl.setSelection(ahVar.zL().size() + 1);
                        return;
                    } else {
                        this.vl.setSelection(ahVar.zL().size());
                        return;
                    }
                } else {
                    return;
                }
            case 5:
                this.vl.setSelection(0);
                return;
            case 6:
                if (i3 == 1 && (Xa = bs.WZ().Xa()) != null) {
                    this.vl.onRestoreInstanceState(Xa);
                    return;
                } else if (z) {
                    this.vl.setSelection(0);
                    return;
                } else if (ahVar.zL() != null) {
                    if (ahVar.zM() != null && ahVar.zM().ki() != 0) {
                        this.vl.setSelection(ahVar.zL().size() + 1);
                        return;
                    } else {
                        this.vl.setSelection(ahVar.zL().size());
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void ei(boolean z) {
        this.byk = z;
        this.bxj.ei(z);
    }

    public void XT() {
        if (this.bxK != null) {
            this.bxK.XT();
        }
        if (this.byA != null) {
            this.byA.XT();
        }
    }

    public void Go() {
        this.vl.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean XU() {
        boolean z;
        boolean z2 = true;
        if (this.bxl != null && this.bxl.getVisibility() == 0) {
            if (this.bxy != null) {
                this.bxy.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.bxy != null) {
                this.bxy.setVisibility(8);
            }
            z = false;
        }
        if (this.bym != null && this.bym.getVisibility() == 0) {
            if (this.bxz != null) {
                this.bxz.setVisibility(0);
            }
        } else {
            if (this.bxz != null) {
                this.bxz.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.bxB == null || this.bxB.getVisibility() == 8) && z2 && this.bvx) {
            this.bxA.setVisibility(0);
        } else {
            this.bxA.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.data.ah ahVar, boolean z, boolean z2) {
        if (ahVar == null) {
            return false;
        }
        if (this.bxn != null) {
            if (ahVar.zK().kF() == 0) {
                this.bxn.setVisibility(0);
                ahVar.zK().parser_title();
                this.bxn.setText(ahVar.zK().getSpan_str());
            } else {
                this.bxn.setVisibility(8);
            }
        }
        if (z) {
            if (this.byB != null) {
                this.byB.findViewById(com.baidu.tieba.v.pb_head_live_blank).setVisibility(8);
            }
        } else if (this.byB != null) {
            this.byB.findViewById(com.baidu.tieba.v.pb_head_live_blank).setVisibility(0);
        }
        this.bvx = z;
        com.baidu.tbadk.core.data.q zK = ahVar.zK();
        if (zK != null) {
            a(zK.kx());
        }
        if (ahVar.zQ() == 1) {
            XV();
            Button button = (Button) this.bxk.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.bxk.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.bxk.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.bxk.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.aCW);
            button2.setOnClickListener(this.aCW);
            button3.setOnClickListener(this.aCW);
            button4.setOnClickListener(this.aCW);
            if (ahVar.zK().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (ahVar.zK().getIs_top() == 1) {
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

    private void XV() {
        if (this.bxl == null) {
            this.bxl = ((ViewStub) this.bxk.findViewById(com.baidu.tieba.v.pb_header_function_manage)).inflate();
            this.bwQ.getLayoutMode().h(this.bxl);
            this.bxy = this.bxk.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_manage);
            return;
        }
        this.bxl.setVisibility(0);
    }

    public void a(com.baidu.tieba.data.ah ahVar, boolean z, boolean z2, int i) {
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (ahVar != null) {
            a(ahVar, z, z2);
            com.baidu.tieba.data.ak a = a(ahVar, z, i);
            if (a != null) {
                if (ahVar.zQ() != 0 && a.getAuthor() != null) {
                    String userId2 = a.getAuthor().getUserId();
                    boolean z6 = userId2 == null || !userId2.equals(TbadkApplication.getCurrentAccount());
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
                    String userId3 = ahVar.zK().getAuthor().getUserId();
                    if (userId3 != null && userId3.equals(TbadkApplication.getCurrentAccount())) {
                        z3 = false;
                        z4 = true;
                        z5 = false;
                    } else if (a.getAuthor() == null || (userId = a.getAuthor().getUserId()) == null || !userId.equals(TbadkApplication.getCurrentAccount())) {
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
                        sparseArray.put(com.baidu.tieba.v.tag_forbid_user_name, a.getAuthor().getUserName());
                    }
                    sparseArray.put(com.baidu.tieba.v.tag_del_post_id, a.getId());
                    sparseArray.put(com.baidu.tieba.v.tag_del_post_type, 0);
                    sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(ahVar.zQ()));
                    sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, true);
                    a(com.baidu.tieba.y.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(com.baidu.tieba.v.tag_del_post_id, a.getId());
                    sparseArray2.put(com.baidu.tieba.v.tag_del_post_type, 0);
                    sparseArray2.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(ahVar.zQ()));
                    sparseArray2.put(com.baidu.tieba.v.tag_should_manage_visible, false);
                    a(com.baidu.tieba.y.delete, sparseArray2);
                }
            }
            XU();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        XV();
        Button button = (Button) this.bxk.findViewById(com.baidu.tieba.v.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.aCW);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.auN;
    }

    public BdListView ud() {
        return this.vl;
    }

    public int XW() {
        return com.baidu.tieba.v.richText;
    }

    public int Eu() {
        return com.baidu.tieba.v.user_icon_box;
    }

    public Button XX() {
        return (Button) this.bxk.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_good);
    }

    public Button XY() {
        return (Button) this.bxk.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_good);
    }

    public Button XZ() {
        return (Button) this.bxk.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_top);
    }

    public Button Ya() {
        return (Button) this.bxk.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_top);
    }

    public View Yb() {
        if (this.bxG == null) {
            return null;
        }
        return this.bxG.Zi();
    }

    public void c(com.baidu.adp.widget.ListView.aa aaVar) {
        this.vl.setOnSrollToBottomListener(aaVar);
    }

    public void a(com.baidu.adp.widget.ListView.ad adVar) {
        this.vl.setOnSrollToTopListener(adVar);
    }

    public void e(DialogInterface.OnClickListener onClickListener) {
        this.bal = onClickListener;
    }

    public void a(com.baidu.adp.widget.ListView.f fVar) {
        this.uo = fVar;
        if (this.bxJ != null) {
            this.bxJ.a(fVar);
        }
    }

    public void b(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            int kf = mVar.kf();
            int kc = mVar.kc();
            if (this.bxF == null) {
                this.bxF = new Dialog(this.bwQ, com.baidu.tieba.z.common_alert_dialog);
                this.bxF.setCanceledOnTouchOutside(true);
                this.bxF.setCancelable(true);
                this.bxH = com.baidu.adp.lib.g.b.ek().inflate(this.bwQ, com.baidu.tieba.w.dialog_direct_pager, null);
                this.bxF.setContentView(this.bxH);
                WindowManager.LayoutParams attributes = this.bxF.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = com.baidu.adp.lib.util.m.dip2px(this.bwQ, 54.0f);
                attributes.width = (int) (com.baidu.adp.lib.util.m.n(this.bwQ) * 0.9d);
                this.bxF.getWindow().setAttributes(attributes);
                this.bxF.setOnKeyListener(new cn(this));
            }
            com.baidu.adp.lib.g.j.a(this.bxF, this.bwQ);
            ((Button) this.bxH.findViewById(com.baidu.tieba.v.dialog_button_ok)).setOnClickListener(this.aCW);
            ((Button) this.bxH.findViewById(com.baidu.tieba.v.dialog_button_cancel)).setOnClickListener(this.aCW);
            this.bxI = (EditText) this.bxH.findViewById(com.baidu.tieba.v.input_page_number);
            this.bxI.setText("");
            this.bxI.setOnFocusChangeListener(new co(this));
            TextView textView = (TextView) this.bxH.findViewById(com.baidu.tieba.v.current_page_number);
            if (kf <= 0) {
                kf = 1;
            }
            textView.setText(MessageFormat.format(this.bwQ.getApplicationContext().getResources().getString(com.baidu.tieba.y.current_page), Integer.valueOf(kf), Integer.valueOf(kc <= 0 ? 1 : kc)));
            this.bwQ.ShowSoftKeyPadDelay(this.bxI, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.vl.setOnScrollListener(onScrollListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.bxM = onScrollListener;
    }

    public void showToast(String str) {
        this.bwQ.showToast(str);
    }

    public boolean ej(boolean z) {
        if (this.bxG == null || !this.bxG.YS()) {
            if (!z) {
                if (XJ()) {
                    XK();
                    return true;
                } else if (this.byn != null && this.byn.BB()) {
                    this.byn.Cd();
                    return true;
                }
            } else if (XJ()) {
                XK();
                return true;
            }
            return false;
        }
        return true;
    }

    public void Yc() {
        if (this.byH != null) {
            while (this.byH.size() > 0) {
                TbImageView remove = this.byH.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        Yc();
    }

    public void onDestroy() {
        this.bwQ.hideProgressBar();
        if (this.aty != null && this.aBc != null) {
            this.aty.b(this.aBc);
        }
        Yd();
        this.bxK.XT();
    }

    public void Yd() {
        this.bxj.Yp();
        com.baidu.adp.lib.util.m.b(this.bwQ, this.bxI);
        if (this.byn != null) {
            this.byn.Cb();
        }
        if (this.bxF != null) {
            com.baidu.adp.lib.g.j.b(this.bxF, this.bwQ);
        }
        if (this.byj != null) {
            com.baidu.adp.lib.g.j.b(this.byj, this.bwQ);
        }
        if (this.bxG != null) {
            this.bxG.Zd();
        }
        Ye();
    }

    public void dX(boolean z) {
        this.bxE.dX(z);
        if (this.bxG != null) {
            this.bxG.dX(z);
        }
    }

    public void dY(boolean z) {
        this.bvw = z;
        this.bxE.dY(z);
        if (this.bxG != null) {
            this.bxG.dY(z);
        }
    }

    public void Ye() {
        if (this.bxO != null) {
            com.baidu.adp.lib.g.j.b(this.bxO, this.bwQ);
        }
        if (this.bxT != null) {
            com.baidu.adp.lib.g.j.b(this.bxT, this.bwQ);
        }
        if (this.byc != null) {
            com.baidu.adp.lib.g.j.b(this.byc, this.bwQ);
        }
        if (this.bxN != null) {
            com.baidu.adp.lib.g.j.b(this.bxN, this.bwQ);
        }
    }

    public void onChangeSkinType(int i) {
        this.bwQ.getLayoutMode().L(i == 1);
        this.bwQ.getLayoutMode().h(this.ahN);
        this.bwQ.getLayoutMode().h(this.bxk);
        this.bwQ.getLayoutMode().h(this.auN);
        this.bxj.mNavigationBar.onChangeSkinType(i);
        ei(this.byk);
        this.bxE.notifyDataSetChanged();
        if (this.bxG != null) {
            this.bxG.onChangeSkinType(i);
            this.bwQ.getLayoutMode().h(this.bxK.getView());
        }
        if (this.bxJ != null) {
            this.bxJ.bM(i);
        }
        if (this.bxK != null) {
            this.bxK.bM(i);
            com.baidu.tbadk.core.util.aw.h(this.auN, com.baidu.tieba.u.pb_foot_more_trans_selector);
            this.bxK.hC(com.baidu.tieba.u.pb_foot_more_trans_selector);
        }
        if (this.byA != null) {
            this.byA.bM(i);
            this.byA.hC(com.baidu.tieba.s.cp_bg_line_e);
            com.baidu.tbadk.core.util.aw.h(this.byz, com.baidu.tieba.s.cp_bg_line_e);
        }
        if (this.byn != null) {
            this.byn.changeSkinType(i);
        }
        if (this.bxx != null) {
            this.bxx.bN(i);
        }
        ee(i == 1);
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.acf = sVar;
        this.bxE.setOnImageClickListener(this.acf);
        if (this.bxG != null) {
            this.bxG.setOnImageClickListener(this.acf);
        }
    }

    public void f(com.baidu.tbadk.core.view.u uVar) {
        this.aBc = uVar;
        if (this.aty != null) {
            this.aty.a(this.aBc);
        }
    }

    public void ek(boolean z) {
        this.bxE.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public View Yf() {
        if (this.bxG == null) {
            return null;
        }
        return this.bxG.Zo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yg() {
        if (this.bxj.mNavigationBar != null) {
            this.bxj.mNavigationBar.setVisibility(8);
        }
        if (this.vl != null) {
            this.vl.setVisibility(8);
        }
        if (this.byn != null) {
            this.byw = this.byq.getVisibility() == 0;
            this.byn.setVisibility(8);
            this.byq.setVisibility(8);
            this.byp.setVisibility(8);
        }
    }

    private void Yh() {
        if (this.bxj.mNavigationBar != null) {
            this.bxj.mNavigationBar.setVisibility(0);
        }
        if (this.vl != null) {
            this.vl.setVisibility(0);
        }
        if (this.byn != null) {
            int visibility = this.bxD != null ? this.bxD.getVisibility() : 0;
            if (visibility == 0) {
                if (this.byw) {
                    this.byq.setVisibility(visibility);
                    this.byp.setVisibility(visibility);
                    return;
                }
                this.byn.setVisibility(visibility);
                return;
            }
            this.byw = this.byq.getVisibility() == 0;
            this.byn.setVisibility(visibility);
            this.byq.setVisibility(visibility);
            this.byp.setVisibility(visibility);
        }
    }

    public Button Yi() {
        return this.bym;
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        if (this.byn != null) {
            this.byn.are.a(writeImagesInfo, z);
        }
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        if (this.byn != null) {
            this.byn.are.setBaobaoUris(writeImagesInfo);
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                this.byn.BX();
            } else {
                this.byn.BY();
            }
        }
    }

    public void h(com.baidu.tieba.data.ah ahVar) {
        if (ahVar != null) {
            ArrayList<com.baidu.tieba.data.ak> zL = ahVar.zL();
            if (zL.size() == 1) {
                com.baidu.tieba.data.ak akVar = zL.get(0);
                if (akVar.Ak() < akVar.Ad().size()) {
                    this.vl.setNextPage(null);
                    return;
                } else {
                    this.vl.setNextPage(this.bxK);
                    return;
                }
            }
            this.vl.setNextPage(this.bxK);
        }
    }

    public boolean Ch() {
        if (this.byn == null) {
            return false;
        }
        return this.byn.Ch();
    }

    public boolean Yj() {
        if (this.bxG == null) {
            return false;
        }
        return this.bxG.Ch();
    }

    public void Yk() {
        if (com.baidu.tbadk.performanceLog.v.uN().uO()) {
            int lastVisiblePosition = this.vl.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.vl.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(com.baidu.tieba.v.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.o perfLog = tbImageView.getPerfLog();
                                perfLog.dm(1001);
                                perfLog.YU = true;
                                perfLog.YT = this.bwQ.buE;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.m.o(TbadkApplication.m251getInst())) {
                                    }
                                }
                                tbImageView.nt();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(com.baidu.tieba.v.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.o perfLog2 = headImageView.getPerfLog();
                        perfLog2.dm(1001);
                        perfLog2.YU = true;
                        perfLog2.YT = this.bwQ.buE;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.m.o(TbadkApplication.m251getInst())) {
                            }
                        }
                        headImageView.nt();
                    }
                }
            }
        }
    }

    public void Yl() {
        if (this.byq != null) {
            this.byq.setVisibility(0);
            if (this.byp != null) {
                this.byp.setVisibility(0);
            }
        }
    }

    public void Ym() {
        if (this.byq != null) {
            this.byq.setVisibility(8);
            if (this.byp != null) {
                this.byp.setVisibility(8);
            }
        }
    }
}
