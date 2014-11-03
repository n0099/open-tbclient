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
    private View.OnClickListener aDg;
    private RelativeLayout ahW;
    private NoNetworkView atH;
    private View auW;
    private View.OnClickListener bvQ;
    bg bvl;
    private ColumnLayout bxA;
    private TextView bxB;
    private TextView bxC;
    private HeadImageView bxD;
    private TextView bxE;
    private ImageView bxF;
    private UserIconBox bxG;
    private UserIconBox bxH;
    private ImageView bxI;
    private TextView bxJ;
    private TextView bxK;
    private View bxO;
    private View bxQ;
    private RelativeLayout bxR;
    private bh bxS;
    private PbListView bxY;
    private PbActivity bxe;
    public final com.baidu.tieba.pb.main.b.a bxx;
    private View bxy;
    private PbEditor byB;
    private com.baidu.tbadk.editortool.w byC;
    private View byD;
    private View byE;
    private LinearLayout byF;
    private TextView byG;
    private LinearLayout byH;
    private ImageView byI;
    private TextView byJ;
    private boolean byL;
    private View byP;
    private LiveBroadcastCard byQ;
    private bf byS;
    private com.baidu.adp.widget.ListView.f uo;
    private BdListView vl;
    private View bxz = null;
    public FrsPraiseView bxL = null;
    private View bxM = null;
    private View bxN = null;
    private View bxP = null;
    private Dialog bxT = null;
    private Dialog baS = null;
    private com.baidu.tieba.pb.sub.l bxU = null;
    private View bxV = null;
    private EditText bxW = null;
    private com.baidu.tieba.view.z bxX = null;
    private FrameLayout aCF = null;
    private View bxZ = null;
    private DialogInterface.OnClickListener baA = null;
    private AbsListView.OnScrollListener bya = null;
    private com.baidu.tbadk.widget.richText.s ack = null;
    private com.baidu.tbadk.core.view.u aBm = null;
    private Dialog byb = null;
    private Dialog byc = null;
    private View byd = null;
    private Button bye = null;
    private Button byf = null;
    private TextView byg = null;
    private Dialog byh = null;
    private View byi = null;
    private int byj = 0;
    private RadioGroup Ol = null;
    private RadioButton byk = null;
    private RadioButton byl = null;
    private RadioButton bym = null;
    private Button byn = null;
    private Button byo = null;
    private TextView byp = null;
    private Dialog byq = null;
    private View byr = null;
    private RadioGroup bys = null;
    private CompoundButton.OnCheckedChangeListener byt = null;
    private Button byu = null;
    private Button byv = null;
    private String bpe = null;
    private cw byw = null;
    private Dialog byx = null;
    private boolean byy = false;
    private ScrollView byz = null;
    private Button byA = null;
    private boolean byK = true;
    private LinearLayout byM = null;
    private View byN = null;
    private PbListView byO = null;
    private boolean bvL = false;
    private boolean mIsFromCDN = true;
    private com.baidu.tieba.bubble.t aDB = new bw(this);
    private final View.OnClickListener byR = new cf(this);
    private View.OnLongClickListener byT = null;
    private boolean byU = false;
    private final List<TbImageView> byV = new ArrayList();
    private boolean bvK = true;
    private com.baidu.tieba.c.d bvP = new com.baidu.tieba.c.d(new cp(this));

    public NoNetworkView Xj() {
        return this.atH;
    }

    public void Xk() {
        this.byK = true;
        if (this.byB != null) {
            this.byB.setVisibility(8);
        }
        if (this.byE != null) {
            this.byE.setVisibility(0);
            this.byD.setVisibility(0);
        }
    }

    public com.baidu.tieba.data.ak Xl() {
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
        if (this.bxS.getItemViewType(i7) != 0) {
            i7++;
        }
        return (com.baidu.tieba.data.ak) this.bxS.getItem(i7);
    }

    public bv(PbActivity pbActivity, View.OnClickListener onClickListener) {
        this.bxe = null;
        this.ahW = null;
        this.vl = null;
        this.bxy = null;
        this.bxA = null;
        this.bxB = null;
        this.bxC = null;
        this.bxD = null;
        this.bxE = null;
        this.bxF = null;
        this.bxG = null;
        this.bxH = null;
        this.bxI = null;
        this.bxJ = null;
        this.bxK = null;
        this.bxO = null;
        this.bxQ = null;
        this.bxS = null;
        this.bxY = null;
        this.auW = null;
        this.aDg = null;
        this.bvQ = null;
        this.byD = null;
        this.byE = null;
        this.byF = null;
        this.byG = null;
        this.byH = null;
        this.byI = null;
        this.byJ = null;
        this.bxe = pbActivity;
        this.aDg = onClickListener;
        this.ahW = (RelativeLayout) com.baidu.adp.lib.g.b.ek().inflate(this.bxe, com.baidu.tieba.w.new_pb_activity, null);
        this.bxe.addContentView(this.ahW, new FrameLayout.LayoutParams(-1, -1));
        this.bxR = (RelativeLayout) this.bxe.findViewById(com.baidu.tieba.v.title_wrapper);
        this.atH = (NoNetworkView) this.bxe.findViewById(com.baidu.tieba.v.view_no_network);
        this.vl = (BdListView) this.bxe.findViewById(com.baidu.tieba.v.new_pb_list);
        View view = new View(this.bxe);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.bxe.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_editor_height)));
        this.vl.addFooterView(view);
        this.bxx = new com.baidu.tieba.pb.main.b.a(pbActivity);
        this.bxx.Yq().setOnTouchListener(new com.baidu.tieba.c.a(new cq(this)));
        this.byE = this.bxe.findViewById(com.baidu.tieba.v.pb_editor_tool_comment);
        this.byF = (LinearLayout) this.bxe.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_reply);
        this.byH = (LinearLayout) this.bxe.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_praise);
        this.byD = this.bxe.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_line);
        this.byG = (TextView) this.bxe.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_reply_text);
        this.byI = (ImageView) this.bxe.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_praise_icon);
        this.byJ = (TextView) this.bxe.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_praise_text);
        this.byF.setOnClickListener(new cr(this));
        this.byH.setOnClickListener(this.aDg);
        this.byH.setOnTouchListener(this.bxe);
        Bu();
        this.bxy = com.baidu.adp.lib.g.b.ek().inflate(this.bxe, com.baidu.tieba.w.new_pb_header_item, null);
        this.bxA = (ColumnLayout) this.bxy.findViewById(com.baidu.tieba.v.pb_head_owner_root);
        this.bxA.setOnLongClickListener(this.byT);
        this.bxA.setOnTouchListener(this.bvP);
        this.bxA.setVisibility(8);
        this.bxy.setOnTouchListener(this.bvP);
        this.bxB = (TextView) this.bxy.findViewById(com.baidu.tieba.v.pb_head_post_title);
        this.bxB.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.bxB.setVisibility(8);
        this.bxC = (TextView) this.bxA.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_name);
        this.bxD = (HeadImageView) this.bxA.findViewById(com.baidu.tieba.v.pb_head_owner_photo);
        if (!this.bvK) {
            this.bxD.setVisibility(8);
        }
        this.bxE = (TextView) this.bxA.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_rank);
        this.bxF = (ImageView) this.bxA.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_gender);
        this.bxG = (UserIconBox) this.bxA.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_icon);
        this.bxH = (UserIconBox) this.bxA.findViewById(com.baidu.tieba.v.pb_head_owner_info_tshow_icon);
        this.bxI = (ImageView) this.bxA.findViewById(com.baidu.tieba.v.pb_head_owner_info_floor_owner);
        this.bxJ = (TextView) this.bxA.findViewById(com.baidu.tieba.v.pb_head_owner_info_time);
        this.bxK = (TextView) this.bxy.findViewById(com.baidu.tieba.v.pb_head_reverse_hint);
        this.bxK.setOnClickListener(this.aDg);
        this.bxK.setVisibility(8);
        this.bxO = this.bxy.findViewById(com.baidu.tieba.v.new_pb_header_item_line_below_livepost);
        this.bxQ = this.bxy.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_showpassed);
        this.bxy.setOnLongClickListener(new cs(this));
        Xx();
        this.bxS = new bh(this.bxe);
        this.bxS.t(this.aDg);
        this.bxS.a(this.bvP);
        this.bxS.setOnImageClickListener(this.ack);
        this.bvQ = new ct(this);
        this.bxS.s(this.bvQ);
        this.vl.setAdapter((ListAdapter) this.bxS);
        this.vl.addHeaderView(this.bxy);
        this.bxY = new PbListView(this.bxe);
        this.auW = this.bxY.getView().findViewById(com.baidu.tieba.v.pb_more_view);
        if (this.auW != null) {
            this.auW.setOnClickListener(this.aDg);
            com.baidu.tbadk.core.util.aw.h(this.auW, com.baidu.tieba.u.pb_foot_more_trans_selector);
        }
        this.bxY.aeU();
        this.bxY.hC(com.baidu.tieba.u.pb_foot_more_trans_selector);
        this.bxY.hD(com.baidu.tieba.u.pb_foot_more_trans_selector);
    }

    public PbEditor EQ() {
        return this.byB;
    }

    public void Xm() {
        if (this.byB != null) {
            this.ahW.removeView(this.byB);
            this.byB = null;
        }
    }

    public void Xn() {
        if (this.bxe != null) {
            this.byB = new PbEditor(this.bxe);
            this.byB.setOrientation(1);
            this.byB.setFrom(1);
            this.byB.au(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ahW.addView(this.byB, layoutParams);
            this.byB.changeSkinType(TbadkApplication.m251getInst().getSkinType());
            Xo();
        }
    }

    public void Xo() {
        if (this.byB != null) {
            this.byB.setOnActionListener(new cu(this));
        }
    }

    public void gX(String str) {
        if (this.byG != null) {
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                this.byG.setText(str);
            } else {
                this.byG.setText(this.bxe.getString(com.baidu.tieba.y.reply));
            }
        }
    }

    public void B(String str, boolean z) {
        this.byL = z;
        if (this.byJ != null) {
            this.byJ.setText(str);
            ee(TbadkApplication.m251getInst().getSkinType() == 1);
        }
    }

    private void ee(boolean z) {
        if (this.byI != null) {
            if (this.byL) {
                com.baidu.tbadk.core.util.aw.c(this.byI, com.baidu.tieba.u.icon_hand_click);
            } else {
                com.baidu.tbadk.core.util.aw.c(this.byI, com.baidu.tieba.u.icon_hand_normal);
            }
        }
    }

    public View Xp() {
        return this.byH;
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
        if (this.bxR != null && view != null) {
            if (this.byK) {
                z = this.byE.getVisibility() == 0;
            } else {
                z = this.byB != null && this.byB.getVisibility() == 0;
            }
            boolean z2 = this.bxR.getVisibility() == 0;
            if (z2) {
                com.baidu.tbadk.core.a.a(this.bxe, this.bxR, com.baidu.tieba.p.top_fold_up, new bx(this));
            } else {
                com.baidu.tbadk.core.a.a(this.bxe, this.bxR, com.baidu.tieba.p.top_fold_down, new by(this));
            }
            if (this.byK) {
                view2 = this.byE;
            } else {
                view2 = this.byB;
            }
            if (z) {
                if (z2) {
                    if (this.byB != null) {
                        this.byB.Ce();
                    }
                    com.baidu.tbadk.core.a.a(this.bxe, view2, com.baidu.tieba.p.bottom_fold_down, new bz(this));
                }
            } else if (!z2) {
                com.baidu.tbadk.core.a.a(this.bxe, view2, com.baidu.tieba.p.bottom_fold_up, new ca(this));
            }
        }
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.byB == null) {
            return null;
        }
        return this.byB.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.byB != null) {
            this.byB.setAudioData(voiceModel);
        }
    }

    public void BS() {
        if (this.byB != null) {
            this.byB.BS();
        }
    }

    public void Xq() {
        if (this.bxU != null) {
            this.bxU.Bv();
        }
    }

    public com.baidu.tieba.pb.sub.l Xr() {
        return this.bxU;
    }

    public void Xs() {
        if (this.bxU != null) {
            this.bxU.Bu();
        }
    }

    public VoiceData.VoiceModel Xt() {
        if (this.bxU != null) {
            return this.bxU.getAudioData();
        }
        return null;
    }

    public void Xu() {
        if (this.bxU != null) {
            this.bxU.BS();
        }
    }

    public TextView Xv() {
        if (this.bxU == null || !(this.bxU instanceof com.baidu.tieba.pb.sub.i)) {
            return null;
        }
        return ((com.baidu.tieba.pb.sub.i) this.bxU).YX();
    }

    public bh Xw() {
        return this.bxS;
    }

    public void a(bg bgVar) {
        this.bvl = bgVar;
    }

    private void a(com.baidu.tbadk.core.data.t tVar) {
        if (tVar != null && tVar.kP() != 0) {
            if (this.byA == null) {
                this.bxe.getLayoutMode().h(((ViewStub) this.bxy.findViewById(com.baidu.tieba.v.live_talk_layout)).inflate());
                this.byA = (Button) this.bxy.findViewById(com.baidu.tieba.v.pb_head_function_manage_go_to_live_post);
                this.bxN = this.bxy.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_livepost);
            }
            int kQ = tVar.kQ();
            String string = this.bxe.getString(com.baidu.tieba.y.go_to_live_post_prefix);
            if (kQ == 0) {
                string = String.valueOf(string) + this.bxe.getString(com.baidu.tieba.y.go_to_interview_post);
            } else if (kQ == 1) {
                string = String.valueOf(string) + this.bxe.getString(com.baidu.tieba.y.go_to_discuss_post);
            }
            this.byA.setText(string);
            this.byA.setVisibility(0);
            this.byA.setOnClickListener(this.aDg);
            XX();
        }
    }

    private void Xx() {
        this.byM = (LinearLayout) this.bxy.findViewById(com.baidu.tieba.v.btn_show_passed_pb);
        this.byO = new PbListView(this.bxe, PbListView.IconType.ICON_UP_WARD);
        this.byN = this.byO.hA();
        this.byO.setText(this.bxe.getResources().getString(com.baidu.tieba.y.btn_show_passed_pb));
        this.byN.setOnClickListener(this.byR);
        this.byM.addView(this.byN);
        this.byM.requestLayout();
        this.byM.invalidate();
        com.baidu.tbadk.core.util.aw.h(this.byN, com.baidu.tieba.s.cp_bg_line_e);
        this.byO.hC(com.baidu.tieba.s.cp_bg_line_e);
        this.byO.hD(com.baidu.tieba.s.cp_bg_line_e);
        XX();
    }

    public void W(View view) {
        if (this.byb == null) {
            this.byb = new Dialog(this.bxe, com.baidu.tieba.z.common_alert_dialog);
            this.byb.setCanceledOnTouchOutside(true);
            this.byb.setCancelable(true);
            this.byb.setContentView(com.baidu.adp.lib.g.b.ek().inflate(this.bxe, com.baidu.tieba.w.forum_manage_dialog, null));
            WindowManager.LayoutParams attributes = this.byb.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.m.n(this.bxe) * 0.9d);
            this.byb.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.byb.findViewById(com.baidu.tieba.v.del_post_btn);
        Button button2 = (Button) this.byb.findViewById(com.baidu.tieba.v.forbid_user_btn);
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
            com.baidu.adp.lib.g.j.a(this.byb, this.bxe);
        }
    }

    public void a(bf bfVar) {
        this.byS = bfVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        if (this.byc == null) {
            this.byc = new Dialog(this.bxe, com.baidu.tieba.z.common_alert_dialog);
            this.byc.setCanceledOnTouchOutside(true);
            this.byc.setCancelable(true);
            this.byd = com.baidu.adp.lib.g.b.ek().inflate(this.bxe, com.baidu.tieba.w.del_post, null);
            this.byc.setContentView(this.byd);
            WindowManager.LayoutParams attributes = this.byc.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.m.n(this.bxe) * 0.9d);
            this.byc.getWindow().setAttributes(attributes);
            this.bye = (Button) this.byd.findViewById(com.baidu.tieba.v.dialog_button_ok);
            this.bye.setOnClickListener(this.aDg);
            this.byf = (Button) this.byd.findViewById(com.baidu.tieba.v.dialog_button_cancel);
            this.byf.setOnClickListener(new cd(this));
            this.byg = (TextView) this.byd.findViewById(com.baidu.tieba.v.confirm_text);
        }
        SparseArray sparseArray = (SparseArray) this.bye.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.bye.setTag(sparseArray);
        }
        sparseArray.put(com.baidu.tieba.v.tag_del_post_id, str);
        sparseArray.put(com.baidu.tieba.v.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z));
        if (i == 0) {
            this.byg.setText(com.baidu.tieba.y.del_thread_confirm);
        } else {
            this.byg.setText(com.baidu.tieba.y.del_post_confirm);
        }
        com.baidu.adp.lib.g.j.a(this.byc, this.bxe);
    }

    public void C(ArrayList<com.baidu.tbadk.core.data.h> arrayList) {
        if (this.byq == null) {
            this.byq = new Dialog(this.bxe, com.baidu.tieba.z.common_alert_dialog);
            this.byq.setCanceledOnTouchOutside(true);
            this.byq.setCancelable(true);
            this.byr = com.baidu.adp.lib.g.b.ek().inflate(this.bxe, com.baidu.tieba.w.commit_good, null);
            this.byz = (ScrollView) this.byr.findViewById(com.baidu.tieba.v.good_scroll);
            this.byq.setContentView(this.byr);
            WindowManager.LayoutParams attributes = this.byq.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.m.n(this.bxe) * 0.9d);
            this.byq.getWindow().setAttributes(attributes);
            this.byt = new ce(this);
            this.bys = (RadioGroup) this.byr.findViewById(com.baidu.tieba.v.good_class_group);
            this.byv = (Button) this.byr.findViewById(com.baidu.tieba.v.dialog_button_cancel);
            this.byv.setOnClickListener(new cg(this));
            this.byu = (Button) this.byr.findViewById(com.baidu.tieba.v.dialog_button_ok);
            this.byu.setOnClickListener(this.aDg);
        }
        this.bys.removeAllViews();
        RadioButton radioButton = (RadioButton) com.baidu.adp.lib.g.b.ek().inflate(this.bxe, com.baidu.tieba.w.good_class_radio_button, null);
        radioButton.setTag("0");
        radioButton.setText(this.bxe.getString(com.baidu.tieba.y.def_good_class));
        radioButton.setOnCheckedChangeListener(this.byt);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(com.baidu.adp.lib.util.m.dip2px(this.bxe, 10.0f), com.baidu.adp.lib.util.m.dip2px(this.bxe, 5.0f), com.baidu.adp.lib.util.m.dip2px(this.bxe, 10.0f), com.baidu.adp.lib.util.m.dip2px(this.bxe, 5.0f));
        this.bys.addView(radioButton, layoutParams);
        this.bys.requestLayout();
        this.bys.check(radioButton.getId());
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                RadioButton radioButton2 = (RadioButton) com.baidu.adp.lib.g.b.ek().inflate(this.bxe, com.baidu.tieba.w.good_class_radio_button, null);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).jX()));
                radioButton2.setText(arrayList.get(i2).jW());
                radioButton2.setOnCheckedChangeListener(this.byt);
                this.bys.addView(radioButton2, layoutParams);
                this.bys.requestLayout();
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.byz.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.m.dip2px(this.bxe, 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.m.dip2px(this.bxe, 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.m.dip2px(this.bxe, 220.0f);
                    break;
            }
            this.byz.setLayoutParams(layoutParams2);
            this.byz.removeAllViews();
            this.byz.addView(this.bys);
        }
        com.baidu.adp.lib.g.j.a(this.byq, this.bxe);
    }

    public void Xy() {
        this.bxe.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.bxe.hideProgressBar();
        if (z && z2) {
            this.bxe.showToast(this.bxe.getString(com.baidu.tieba.y.success));
        } else if (str != null && z2) {
            this.bxe.showToast(str);
        }
    }

    public void GI() {
        this.ahW.removeView(this.aCF);
    }

    public View Xz() {
        if (this.byd != null) {
            return this.byd.findViewById(com.baidu.tieba.v.dialog_button_ok);
        }
        return null;
    }

    public View XA() {
        if (this.byr != null) {
            return this.byr.findViewById(com.baidu.tieba.v.dialog_button_ok);
        }
        return null;
    }

    public String XB() {
        return this.bpe;
    }

    public View XC() {
        if (this.bxU != null) {
            return this.bxU.Zm();
        }
        return null;
    }

    public View getView() {
        return this.ahW;
    }

    public void XD() {
        View editText;
        if (this.byB == null) {
            editText = this.bxe.getCurrentFocus();
        } else {
            editText = this.byB.getEditText();
        }
        com.baidu.adp.lib.util.m.b(this.bxe, editText);
    }

    public void EV() {
        if (this.bxU != null) {
            this.bxU.Zo();
        } else {
            this.bxe.showProgressBar();
        }
    }

    public void bQ(boolean z) {
        if (this.bxU != null) {
            this.bxU.Zp();
        } else {
            this.bxe.hideProgressBar();
        }
        Yg();
        if (z) {
            if (this.byB != null) {
                this.byB.getEditText().setText("");
                this.byB.Ca();
                this.byB.clearData();
            }
            if (this.bxU != null) {
                this.bxU.Zk();
            }
        }
    }

    public void XE() {
        this.bxY.YK();
    }

    public void XF() {
    }

    public void XG() {
        this.bxe.hideProgressBar();
        this.bxY.XW();
        this.byO.XW();
        this.vl.hN();
        XX();
    }

    public void XH() {
        this.vl.hN();
        this.byM.setVisibility(8);
        XX();
    }

    public void eg(boolean z) {
        if (!z) {
            if (this.byB != null) {
                this.byB.Cc();
            }
        } else if (this.bxU != null) {
            this.bxU.hd(null);
        }
    }

    public void XI() {
        if (XM() && this.bxU != null) {
            this.bxU.Ch();
        }
    }

    public void XJ() {
        if (this.bxU == null) {
            this.bxU = new com.baidu.tieba.pb.sub.l(this.bxe, this.byU, this.aDg, this.bvQ, this.bxe.bva.bzi, this.bxe.bva.bzj, this.bxe.bva.bzk);
            this.bxU.setOnActionListener(this.byC);
            this.bxU.setOnScrollListener(this.bya);
            this.bxU.dX(this.bxS.WB());
            this.bxU.dY(this.bxS.WC());
            this.bxZ = this.bxU.getRootView();
            this.bxU.setOnImageClickListener(this.ack);
            this.bxU.setOnEmotionClickListener(this.bxe.bva.bzl);
            this.bxU.setOnLongClickListener(this.bxS.WA());
        }
        this.bxZ.setVisibility(0);
        this.bxU.ep(this.mIsFromCDN);
        this.bxU.XD();
        this.ahW.addView(this.bxZ);
        Yj();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.byC = wVar;
            if (this.byB != null) {
                Xo();
            }
            if (this.bxU != null) {
                this.bxU.setOnActionListener(wVar);
            }
        }
    }

    public void a(cw cwVar) {
        this.byw = cwVar;
    }

    public void a(boolean z, com.baidu.tieba.data.ar arVar, boolean z2, String str, String str2, View view, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        if (arVar != null && view != null) {
            TiebaStatic.eventStat(this.bxe, "pb_tosubpb", "pbclick", 1, new Object[0]);
            if (this.bxU == null) {
                this.bxU = new com.baidu.tieba.pb.sub.l(this.bxe, this.byU, this.aDg, this.bvQ, this.bxe.bva.bzi, this.bxe.bva.bzj, this.bxe.bva.bzk);
                this.bxU.setOnActionListener(this.byC);
                this.bxU.setOnScrollListener(this.bya);
                this.bxU.dX(this.bxS.WB());
                this.bxU.dY(this.bxS.WC());
                this.bxZ = this.bxU.getRootView();
                this.bxU.setOnImageClickListener(this.ack);
                this.bxU.setOnEmotionClickListener(this.bxe.bva.bzl);
                this.bxU.setOnLongClickListener(this.bxS.WA());
            }
            this.bxU.gT(this.bxS.getWidth());
            this.bxU.a(arVar, i);
            this.bxU.ep(this.mIsFromCDN);
            if (str2 != null && !str2.equals("")) {
                this.bxU.hf(str2);
            } else {
                this.bxU.setPosition(1);
            }
            int i2 = 0;
            if (this.bxR.getVisibility() == 0) {
                i2 = this.bxR.getHeight();
            }
            int top = view.getTop() + i2;
            int bottom = view.getBottom() + i2;
            if (!z) {
                this.bxU.Zg();
            }
            int height = ((view.getHeight() + this.bxe.getResources().getDimensionPixelSize(com.baidu.tieba.t.subpb_listitem_packup_min_height)) - this.bxe.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_list_item_border_bottom_margin_top)) - this.ahW.getHeight();
            if (height > 0) {
                top += height;
            }
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, top, 0.0f);
            translateAnimation.setDuration(300L);
            this.bxZ.setAnimation(translateAnimation);
            try {
                this.ahW.invalidate();
                this.ahW.buildDrawingCache();
                bitmap = this.ahW.getDrawingCache();
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
            this.bxZ.setVisibility(0);
            if (this.bxZ.getParent() == this.ahW) {
                this.ahW.removeView(this.bxZ);
            }
            this.ahW.addView(this.bxZ, new RelativeLayout.LayoutParams(-1, -1));
            if (bitmap2 != null) {
                ImageView imageView = new ImageView(this.bxe);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(10);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageBitmap(bitmap2);
                this.ahW.addView(imageView);
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
                ImageView imageView2 = new ImageView(this.bxe);
                imageView2.setImageBitmap(bitmap3);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(12);
                imageView2.setLayoutParams(layoutParams2);
                this.ahW.addView(imageView2);
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
        this.byT = onLongClickListener;
        this.bxS.setOnLongClickListener(onLongClickListener);
        if (this.bxU != null) {
            this.bxU.setOnLongClickListener(onLongClickListener);
        }
    }

    public void XK() {
        if (XM()) {
            this.bxU.Zh();
        }
    }

    public void XL() {
        if (XM() && (this.bxU instanceof com.baidu.tieba.pb.sub.i)) {
            ((com.baidu.tieba.pb.sub.i) this.bxU).Za();
        }
    }

    public boolean XM() {
        return (this.bxZ == null || this.bxZ.getVisibility() == 8) ? false : true;
    }

    public void XN() {
        if (this.bxZ != null) {
            this.bxZ.setVisibility(8);
            this.ahW.removeView(this.bxZ);
            this.bxU.Zi();
        }
        Yg();
        Yk();
    }

    public void XO() {
        if (this.bxZ != null) {
            if (this.ahW != null) {
                this.ahW.removeView(this.bxZ);
            }
            this.bxZ = null;
        }
        if (this.bxU != null) {
            this.bxU.Zi();
            this.bxU = null;
        }
    }

    public void XP() {
        if (this.bxU != null) {
            this.bxU.Zq();
            if (this.bxU instanceof com.baidu.tieba.pb.sub.i) {
                ((com.baidu.tieba.pb.sub.i) this.bxU).Zb();
            }
        }
    }

    public void a(com.baidu.tieba.data.ar arVar, int i) {
        if (this.bxU != null) {
            this.bxU.Zq();
            this.bxU.gT(this.bxS.getWidth());
            this.bxU.a(arVar, i);
        }
    }

    public void XQ() {
        if (this.bxU == null) {
            this.bxU = new com.baidu.tieba.pb.sub.i(this.bxe, this.byU, this.aDg, this.bvQ, this.bxe.bva.bzi, this.bxe.bva.bzj, this.bxe.bva.bzk);
            this.bxU.setOnActionListener(this.byC);
            this.bxU.setOnScrollListener(this.bya);
            this.bxU.dX(this.bxS.WB());
            this.bxU.dY(this.bxS.WC());
            this.bxZ = this.bxU.getRootView();
            this.bxU.setOnImageClickListener(this.ack);
            this.bxU.setOnEmotionClickListener(this.bxe.bva.bzl);
            this.bxU.setOnLongClickListener(this.bxS.WA());
        }
        this.bxZ.setVisibility(0);
        this.bxU.XD();
        this.ahW.addView(this.bxZ);
        Yj();
    }

    public void a(com.baidu.tieba.data.ar arVar, int i, String str, boolean z, boolean z2) {
        if (this.bxU != null && (this.bxU instanceof com.baidu.tieba.pb.sub.i)) {
            com.baidu.tieba.pb.sub.i iVar = (com.baidu.tieba.pb.sub.i) this.bxU;
            this.bxU.Zq();
            this.bxU.gT(this.bxS.getWidth());
            this.bxU.a(arVar, i);
            if (z2) {
                iVar.hc(str);
            }
            if (!z) {
                iVar.Zc();
            } else {
                iVar.Zd();
            }
        }
    }

    public void p(ArrayList<String> arrayList) {
        if (this.byB != null) {
            this.byB.p(arrayList);
        }
    }

    public void D(ArrayList<String> arrayList) {
        if (this.bxU != null) {
            this.bxU.p(arrayList);
        }
    }

    public void Bv() {
        this.byU = true;
        if (this.byB != null) {
            this.byB.Bv();
        }
    }

    public void Bu() {
        this.byU = false;
        if (this.byB != null) {
            this.byB.Bu();
        }
    }

    public void a(DialogInterface.OnClickListener onClickListener, boolean z, boolean z2) {
        if (this.byx != null) {
            com.baidu.adp.lib.g.j.b(this.byx, this.bxe);
            this.byx = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.bxe);
        builder.setTitle(com.baidu.tieba.y.operation);
        if (z2) {
            builder.setItems(new String[]{this.bxe.getString(com.baidu.tieba.y.copy)}, onClickListener);
        } else if (!z) {
            builder.setItems(new String[]{this.bxe.getString(com.baidu.tieba.y.copy), this.bxe.getString(com.baidu.tieba.y.mark)}, onClickListener);
        } else {
            builder.setItems(new String[]{this.bxe.getString(com.baidu.tieba.y.copy), this.bxe.getString(com.baidu.tieba.y.remove_mark)}, onClickListener);
        }
        this.byx = builder.create();
        this.byx.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.j.a(this.byx, this.bxe);
    }

    public void setAudioFocusable(boolean z) {
        if (this.byB != null) {
            this.byB.setAudioFocusable(z);
        }
    }

    public void eh(boolean z) {
        if (this.bxU != null) {
            this.bxU.setAudioFocusable(z);
        }
    }

    public void h(Bitmap bitmap) {
        if (this.byB != null) {
            this.byB.h(bitmap);
            this.byB.BZ();
        }
    }

    public void XR() {
        if (this.byB != null) {
            this.byB.h(null);
        }
    }

    public int XS() {
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
            return Integer.parseInt(this.bxW.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public String EW() {
        return this.byB == null ? "" : this.byB.getContent();
    }

    public void fc(String str) {
        if (this.byB != null) {
            this.byB.setContent(str);
        }
    }

    public String XT() {
        if (this.bxU == null) {
            return null;
        }
        return this.bxU.Zn();
    }

    public String XU() {
        if (this.bxU != null) {
            return this.bxU.Zj();
        }
        return null;
    }

    public String XV() {
        if (this.bxU != null) {
            return this.bxU.Ze();
        }
        return null;
    }

    public void e(com.baidu.tieba.data.ah ahVar) {
        this.bxS.b(ahVar);
        this.bxS.notifyDataSetChanged();
        if (ahVar == null) {
            gX("");
        } else {
            gX(new StringBuilder(String.valueOf(ahVar.zM().getReply_num())).toString());
        }
        XX();
    }

    public void f(com.baidu.tieba.data.ah ahVar) {
        PraiseData praise;
        if (this.bxL == null) {
            this.bxe.getLayoutMode().h(((ViewStub) this.bxy.findViewById(com.baidu.tieba.v.praise_layout)).inflate());
            this.bxL = (FrsPraiseView) this.bxy.findViewById(com.baidu.tieba.v.pb_head_praise_view);
            this.bxL.setIsFromPb(true);
            this.bxP = this.bxy.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_praise);
            this.bxL.bN(TbadkApplication.m251getInst().getSkinType());
        }
        if (this.bxL != null) {
            boolean XX = XX();
            if (ahVar != null && ahVar.zN() != null && ahVar.zN().size() > 0) {
                com.baidu.tieba.data.ak akVar = ahVar.zN().get(0);
                if ((!this.bvL || akVar.Ag() != 1) && (praise = ahVar.zM().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.bxL.setVisibility(0);
                    this.bxL.setIsFromPb(true);
                    this.bxL.a(praise, ahVar.zM().getId(), praise.getPostId(), true);
                    this.bxP.setVisibility(0);
                    if (this.bxL.getVisibility() == 0) {
                        this.bxQ.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.bxL.setVisibility(8);
            this.bxP.setVisibility(8);
            if (ahVar != null && ahVar.zO() != null && ahVar.zO().ki() == 0 && this.bvL) {
                this.bxP.setVisibility(8);
                if (XX) {
                    this.bxO.setVisibility(0);
                    return;
                } else {
                    this.bxO.setVisibility(8);
                    return;
                }
            }
            this.bxP.setVisibility(0);
            this.bxO.setVisibility(8);
        }
    }

    private com.baidu.tieba.data.ak a(com.baidu.tieba.data.ah ahVar, boolean z, int i) {
        if (z) {
            if (ahVar == null || ahVar.zN() == null || ahVar.zN().size() <= 0) {
                return null;
            }
            com.baidu.tieba.data.ak akVar = ahVar.zN().get(0);
            if (akVar.Ag() != 1) {
                return g(ahVar);
            }
            return akVar;
        }
        return g(ahVar);
    }

    private com.baidu.tieba.data.ak g(com.baidu.tieba.data.ah ahVar) {
        MetaData metaData;
        if (ahVar == null || ahVar.zM() == null || ahVar.zM().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.data.ak akVar = new com.baidu.tieba.data.ak();
        MetaData author = ahVar.zM().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = ahVar.zM().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        akVar.eg(1);
        akVar.setId(ahVar.zM().kG());
        akVar.setTitle(ahVar.zM().getTitle());
        akVar.setTime(ahVar.zM().getCreateTime());
        akVar.a(metaData);
        return akVar;
    }

    private void b(com.baidu.tieba.data.ah ahVar, boolean z, int i) {
        this.bxA.setVisibility(8);
        com.baidu.tieba.data.ak a = a(ahVar, z, i);
        if (a != null) {
            if (z) {
                this.bxK.setVisibility(8);
            } else {
                this.bxK.setVisibility(0);
            }
            this.bxA.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.bxA.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.bxA.setTag(sparseArray);
            }
            sparseArray.put(com.baidu.tieba.v.tag_clip_board, a);
            sparseArray.put(com.baidu.tieba.v.tag_is_subpb, false);
            this.bxJ.setText(com.baidu.tbadk.core.util.az.j(a.getTime()));
            ahVar.zM().parser_title();
            this.bxB.setVisibility(0);
            this.bxB.setText(ahVar.zM().getSpan_str());
            f(ahVar);
            if (ahVar.zM().getAnchorInfoData().getGroup_id() != 0) {
                if (this.byP == null) {
                    BdLog.e("pb time   liveCardLayout new");
                    this.byP = ((ViewStub) this.bxy.findViewById(com.baidu.tieba.v.live_card_layout)).inflate();
                    this.bxe.getLayoutMode().h(this.byP);
                    this.byQ = (LiveBroadcastCard) this.bxy.findViewById(com.baidu.tieba.v.item_card);
                }
                this.byP.setVisibility(0);
                LiveCardData liveCardData = new LiveCardData();
                liveCardData.setPublisherId(ahVar.zM().getAnchorInfoData().getAuthorId());
                liveCardData.setPublisherName(ahVar.zM().getAnchorInfoData().getAuthorName());
                liveCardData.setPublisherPortrait(ahVar.zM().getAnchorInfoData().getPublisherPortrait());
                liveCardData.setGroupId(ahVar.zM().getAnchorInfoData().getGroup_id());
                liveCardData.setIntro(ahVar.zM().getAnchorInfoData().getIntro());
                liveCardData.setLikers(ahVar.zM().getAnchorInfoData().getLikers());
                liveCardData.setListeners(ahVar.zM().getAnchorInfoData().getListeners());
                liveCardData.setName(ahVar.zM().getAnchorInfoData().getName());
                liveCardData.setPortrait(ahVar.zM().getAnchorInfoData().getPortrait());
                liveCardData.setStatus(ahVar.zM().getAnchorInfoData().getStatus());
                liveCardData.setStartTime(ahVar.zM().getAnchorInfoData().getStartTime());
                this.byQ.setData(liveCardData);
                this.byQ.setStatisticsKey("notice_pb_live");
            } else if (this.byP != null) {
                this.byP.setVisibility(8);
            }
            String userId = ahVar.zM().getAuthor().getUserId();
            if (userId != null && !userId.equals("0") && userId.equals(a.getAuthor().getUserId())) {
                this.bxI.setVisibility(0);
            } else {
                this.bxI.setVisibility(8);
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.bxE.setVisibility(0);
                    this.bxE.setText(String.valueOf(level_id));
                    com.baidu.tbadk.core.util.aw.h((View) this.bxE, com.baidu.tbadk.core.util.d.bn(level_id));
                    i2 = 2;
                    this.bxE.setOnClickListener(null);
                } else {
                    this.bxE.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.bxE.setText((CharSequence) null);
                        com.baidu.tbadk.core.util.aw.h((View) this.bxE, com.baidu.tieba.u.pb_manager);
                        this.bxE.setOnClickListener(this.bxe.bva.bzj);
                    } else if (bawu_type.equals("assist")) {
                        this.bxE.setText((CharSequence) null);
                        com.baidu.tbadk.core.util.aw.h((View) this.bxE, com.baidu.tieba.u.pb_assist);
                        this.bxE.setOnClickListener(this.bxe.bva.bzj);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.aw.c(this.bxF, com.baidu.tieba.u.icon_pop_girl_square);
                    this.bxF.setVisibility(0);
                } else {
                    this.bxF.setVisibility(8);
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfo = a.getAuthor().getTShowInfo();
                if (this.bxG != null) {
                    this.bxG.setOnClickListener(this.bxe.bva.bzj);
                    this.bxG.a(iconInfo, i2, this.bxe.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_width), this.bxe.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_height), this.bxe.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_margin));
                }
                if (this.bxH != null) {
                    this.bxH.setOnClickListener(this.bxe.bva.bzk);
                    this.bxH.a(tShowInfo, 3, this.bxe.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.bxe.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.bxe.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                }
                this.bxC.setText(a.getAuthor().getName_show());
                this.bxC.setTag(a.getAuthor().getUserId());
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.aw.b(this.bxC, com.baidu.tieba.s.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.aw.b(this.bxC, com.baidu.tieba.s.cp_cont_f, 1);
                }
                if (!this.bvK) {
                    this.bxD.setVisibility(8);
                }
                this.bxD.setUserId(a.getAuthor().getUserId());
                this.bxD.setImageDrawable(null);
                this.bxD.setTag(a.getAuthor().getUserId());
                this.bxC.setOnClickListener(this.bxe.bva.bzi);
                this.bxD.setOnClickListener(this.bxe.bva.bzi);
                this.bxD.c(a.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void a(com.baidu.tieba.data.ah ahVar, int i, int i2, boolean z, int i3) {
        Parcelable Xd;
        Parcelable Xd2;
        String sb;
        this.bvL = z;
        XG();
        b(ahVar, z, i);
        this.bxS.dW(this.bvL);
        this.bxS.b(ahVar);
        this.bxS.notifyDataSetChanged();
        this.bxx.gY(ahVar.zL().getName());
        if (ahVar.zM() != null) {
            gX(new StringBuilder(String.valueOf(ahVar.zM().getReply_num())).toString());
            if (ahVar.zM().getPraise() != null) {
                if (ahVar.zM().getPraise().getNum() < 1) {
                    sb = this.bxe.getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(ahVar.zM().getPraise().getNum())).toString();
                }
                B(sb, ahVar.zM().getPraise().getIsLike() == 1);
            }
        }
        if (ahVar.zO().kh() == 0 && !z) {
            this.vl.setNextPage(null);
        } else {
            this.vl.setNextPage(this.bxY);
            this.byO.XW();
        }
        if (ahVar.zO().ki() == 0 && z) {
            this.vl.setPullRefresh(null);
            this.byM.setVisibility(8);
        } else {
            if (this.bxX == null) {
                this.bxX = new com.baidu.tieba.view.z(this.bxe);
                this.bxX.hA();
                this.bxX.a(this.uo);
            }
            this.vl.setPullRefresh(this.bxX);
            if (this.bxX != null) {
                this.bxX.bM(TbadkApplication.m251getInst().getSkinType());
            }
            this.byM.setVisibility(0);
            this.byO.XW();
        }
        XX();
        if (ahVar.zO().kh() == 0) {
            if (z || this.bxS.getCount() > 0) {
                this.bxY.setText(this.bxe.getResources().getString(com.baidu.tieba.y.no_more_to_load));
                h(ahVar);
            }
        } else {
            this.bxY.setText(this.bxe.getResources().getString(com.baidu.tieba.y.pb_load_more));
        }
        if (z) {
            this.byO.setText(this.bxe.getResources().getString(com.baidu.tieba.y.btn_show_passed_pb));
        } else {
            this.byO.setText(this.bxe.getResources().getString(com.baidu.tieba.y.btn_show_passed_pb_aftre));
        }
        if (ahVar.zM() != null && ahVar.zM().getAuthor() != null && ahVar.zM().getAuthor().getType() == 0) {
            this.bxx.Yr();
        }
        switch (i) {
            case 2:
                this.vl.setSelection(i2);
                if (this.bxz != null) {
                    CompatibleUtile.scrollListViewBy(this.vl, -this.bxz.getHeight(), 0);
                    return;
                }
                return;
            case 3:
                if (i3 == 1 && (Xd2 = bs.Xc().Xd()) != null) {
                    this.vl.onRestoreInstanceState(Xd2);
                    return;
                } else {
                    this.vl.setSelection(0);
                    return;
                }
            case 4:
                if (z) {
                    this.vl.setSelection(0);
                    return;
                } else if (ahVar.zN() != null) {
                    if (ahVar.zO() != null && ahVar.zO().ki() != 0) {
                        this.vl.setSelection(ahVar.zN().size() + 1);
                        return;
                    } else {
                        this.vl.setSelection(ahVar.zN().size());
                        return;
                    }
                } else {
                    return;
                }
            case 5:
                this.vl.setSelection(0);
                return;
            case 6:
                if (i3 == 1 && (Xd = bs.Xc().Xd()) != null) {
                    this.vl.onRestoreInstanceState(Xd);
                    return;
                } else if (z) {
                    this.vl.setSelection(0);
                    return;
                } else if (ahVar.zN() != null) {
                    if (ahVar.zO() != null && ahVar.zO().ki() != 0) {
                        this.vl.setSelection(ahVar.zN().size() + 1);
                        return;
                    } else {
                        this.vl.setSelection(ahVar.zN().size());
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
        this.byy = z;
        this.bxx.ei(z);
    }

    public void XW() {
        if (this.bxY != null) {
            this.bxY.XW();
        }
        if (this.byO != null) {
            this.byO.XW();
        }
    }

    public void Gq() {
        this.vl.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean XX() {
        boolean z;
        boolean z2 = true;
        if (this.bxz != null && this.bxz.getVisibility() == 0) {
            if (this.bxM != null) {
                this.bxM.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.bxM != null) {
                this.bxM.setVisibility(8);
            }
            z = false;
        }
        if (this.byA != null && this.byA.getVisibility() == 0) {
            if (this.bxN != null) {
                this.bxN.setVisibility(0);
            }
        } else {
            if (this.bxN != null) {
                this.bxN.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.bxP == null || this.bxP.getVisibility() == 8) && z2 && this.bvL) {
            this.bxO.setVisibility(0);
        } else {
            this.bxO.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.data.ah ahVar, boolean z, boolean z2) {
        if (ahVar == null) {
            return false;
        }
        if (this.bxB != null) {
            if (ahVar.zM().kF() == 0) {
                this.bxB.setVisibility(0);
                ahVar.zM().parser_title();
                this.bxB.setText(ahVar.zM().getSpan_str());
            } else {
                this.bxB.setVisibility(8);
            }
        }
        if (z) {
            if (this.byP != null) {
                this.byP.findViewById(com.baidu.tieba.v.pb_head_live_blank).setVisibility(8);
            }
        } else if (this.byP != null) {
            this.byP.findViewById(com.baidu.tieba.v.pb_head_live_blank).setVisibility(0);
        }
        this.bvL = z;
        com.baidu.tbadk.core.data.q zM = ahVar.zM();
        if (zM != null) {
            a(zM.kx());
        }
        if (ahVar.zS() == 1) {
            XY();
            Button button = (Button) this.bxy.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.bxy.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.bxy.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.bxy.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.aDg);
            button2.setOnClickListener(this.aDg);
            button3.setOnClickListener(this.aDg);
            button4.setOnClickListener(this.aDg);
            if (ahVar.zM().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (ahVar.zM().getIs_top() == 1) {
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

    private void XY() {
        if (this.bxz == null) {
            this.bxz = ((ViewStub) this.bxy.findViewById(com.baidu.tieba.v.pb_header_function_manage)).inflate();
            this.bxe.getLayoutMode().h(this.bxz);
            this.bxM = this.bxy.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_manage);
            return;
        }
        this.bxz.setVisibility(0);
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
                if (ahVar.zS() != 0 && a.getAuthor() != null) {
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
                    String userId3 = ahVar.zM().getAuthor().getUserId();
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
                    sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(ahVar.zS()));
                    sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, true);
                    a(com.baidu.tieba.y.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(com.baidu.tieba.v.tag_del_post_id, a.getId());
                    sparseArray2.put(com.baidu.tieba.v.tag_del_post_type, 0);
                    sparseArray2.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(ahVar.zS()));
                    sparseArray2.put(com.baidu.tieba.v.tag_should_manage_visible, false);
                    a(com.baidu.tieba.y.delete, sparseArray2);
                }
            }
            XX();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        XY();
        Button button = (Button) this.bxy.findViewById(com.baidu.tieba.v.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.aDg);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.auW;
    }

    public BdListView uf() {
        return this.vl;
    }

    public int XZ() {
        return com.baidu.tieba.v.richText;
    }

    public int Ew() {
        return com.baidu.tieba.v.user_icon_box;
    }

    public Button Ya() {
        return (Button) this.bxy.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_good);
    }

    public Button Yb() {
        return (Button) this.bxy.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_good);
    }

    public Button Yc() {
        return (Button) this.bxy.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_top);
    }

    public Button Yd() {
        return (Button) this.bxy.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_top);
    }

    public View Ye() {
        if (this.bxU == null) {
            return null;
        }
        return this.bxU.Zl();
    }

    public void c(com.baidu.adp.widget.ListView.aa aaVar) {
        this.vl.setOnSrollToBottomListener(aaVar);
    }

    public void a(com.baidu.adp.widget.ListView.ad adVar) {
        this.vl.setOnSrollToTopListener(adVar);
    }

    public void e(DialogInterface.OnClickListener onClickListener) {
        this.baA = onClickListener;
    }

    public void a(com.baidu.adp.widget.ListView.f fVar) {
        this.uo = fVar;
        if (this.bxX != null) {
            this.bxX.a(fVar);
        }
    }

    public void b(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null) {
            int kf = mVar.kf();
            int kc = mVar.kc();
            if (this.bxT == null) {
                this.bxT = new Dialog(this.bxe, com.baidu.tieba.z.common_alert_dialog);
                this.bxT.setCanceledOnTouchOutside(true);
                this.bxT.setCancelable(true);
                this.bxV = com.baidu.adp.lib.g.b.ek().inflate(this.bxe, com.baidu.tieba.w.dialog_direct_pager, null);
                this.bxT.setContentView(this.bxV);
                WindowManager.LayoutParams attributes = this.bxT.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = com.baidu.adp.lib.util.m.dip2px(this.bxe, 54.0f);
                attributes.width = (int) (com.baidu.adp.lib.util.m.n(this.bxe) * 0.9d);
                this.bxT.getWindow().setAttributes(attributes);
                this.bxT.setOnKeyListener(new cn(this));
            }
            com.baidu.adp.lib.g.j.a(this.bxT, this.bxe);
            ((Button) this.bxV.findViewById(com.baidu.tieba.v.dialog_button_ok)).setOnClickListener(this.aDg);
            ((Button) this.bxV.findViewById(com.baidu.tieba.v.dialog_button_cancel)).setOnClickListener(this.aDg);
            this.bxW = (EditText) this.bxV.findViewById(com.baidu.tieba.v.input_page_number);
            this.bxW.setText("");
            this.bxW.setOnFocusChangeListener(new co(this));
            TextView textView = (TextView) this.bxV.findViewById(com.baidu.tieba.v.current_page_number);
            if (kf <= 0) {
                kf = 1;
            }
            textView.setText(MessageFormat.format(this.bxe.getApplicationContext().getResources().getString(com.baidu.tieba.y.current_page), Integer.valueOf(kf), Integer.valueOf(kc <= 0 ? 1 : kc)));
            this.bxe.ShowSoftKeyPadDelay(this.bxW, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.vl.setOnScrollListener(onScrollListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.bya = onScrollListener;
    }

    public void showToast(String str) {
        this.bxe.showToast(str);
    }

    public boolean ej(boolean z) {
        if (this.bxU == null || !this.bxU.YV()) {
            if (!z) {
                if (XM()) {
                    XN();
                    return true;
                } else if (this.byB != null && this.byB.BD()) {
                    this.byB.Cf();
                    return true;
                }
            } else if (XM()) {
                XN();
                return true;
            }
            return false;
        }
        return true;
    }

    public void Yf() {
        if (this.byV != null) {
            while (this.byV.size() > 0) {
                TbImageView remove = this.byV.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        Yf();
    }

    public void onDestroy() {
        this.bxe.hideProgressBar();
        if (this.atH != null && this.aBm != null) {
            this.atH.b(this.aBm);
        }
        Yg();
        this.bxY.XW();
    }

    public void Yg() {
        this.bxx.Ys();
        com.baidu.adp.lib.util.m.b(this.bxe, this.bxW);
        if (this.byB != null) {
            this.byB.Cd();
        }
        if (this.bxT != null) {
            com.baidu.adp.lib.g.j.b(this.bxT, this.bxe);
        }
        if (this.byx != null) {
            com.baidu.adp.lib.g.j.b(this.byx, this.bxe);
        }
        if (this.bxU != null) {
            this.bxU.Zg();
        }
        Yh();
    }

    public void dX(boolean z) {
        this.bxS.dX(z);
        if (this.bxU != null) {
            this.bxU.dX(z);
        }
    }

    public void dY(boolean z) {
        this.bvK = z;
        this.bxS.dY(z);
        if (this.bxU != null) {
            this.bxU.dY(z);
        }
    }

    public void Yh() {
        if (this.byc != null) {
            com.baidu.adp.lib.g.j.b(this.byc, this.bxe);
        }
        if (this.byh != null) {
            com.baidu.adp.lib.g.j.b(this.byh, this.bxe);
        }
        if (this.byq != null) {
            com.baidu.adp.lib.g.j.b(this.byq, this.bxe);
        }
        if (this.byb != null) {
            com.baidu.adp.lib.g.j.b(this.byb, this.bxe);
        }
    }

    public void onChangeSkinType(int i) {
        this.bxe.getLayoutMode().L(i == 1);
        this.bxe.getLayoutMode().h(this.ahW);
        this.bxe.getLayoutMode().h(this.bxy);
        this.bxe.getLayoutMode().h(this.auW);
        this.bxx.mNavigationBar.onChangeSkinType(i);
        ei(this.byy);
        this.bxS.notifyDataSetChanged();
        if (this.bxU != null) {
            this.bxU.onChangeSkinType(i);
            this.bxe.getLayoutMode().h(this.bxY.getView());
        }
        if (this.bxX != null) {
            this.bxX.bM(i);
        }
        if (this.bxY != null) {
            this.bxY.bM(i);
            com.baidu.tbadk.core.util.aw.h(this.auW, com.baidu.tieba.u.pb_foot_more_trans_selector);
            this.bxY.hC(com.baidu.tieba.u.pb_foot_more_trans_selector);
        }
        if (this.byO != null) {
            this.byO.bM(i);
            this.byO.hC(com.baidu.tieba.s.cp_bg_line_e);
            com.baidu.tbadk.core.util.aw.h(this.byN, com.baidu.tieba.s.cp_bg_line_e);
        }
        if (this.byB != null) {
            this.byB.changeSkinType(i);
        }
        if (this.bxL != null) {
            this.bxL.bN(i);
        }
        ee(i == 1);
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.ack = sVar;
        this.bxS.setOnImageClickListener(this.ack);
        if (this.bxU != null) {
            this.bxU.setOnImageClickListener(this.ack);
        }
    }

    public void f(com.baidu.tbadk.core.view.u uVar) {
        this.aBm = uVar;
        if (this.atH != null) {
            this.atH.a(this.aBm);
        }
    }

    public void ek(boolean z) {
        this.bxS.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public View Yi() {
        if (this.bxU == null) {
            return null;
        }
        return this.bxU.Zr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yj() {
        if (this.bxx.mNavigationBar != null) {
            this.bxx.mNavigationBar.setVisibility(8);
        }
        if (this.vl != null) {
            this.vl.setVisibility(8);
        }
        if (this.byB != null) {
            this.byK = this.byE.getVisibility() == 0;
            this.byB.setVisibility(8);
            this.byE.setVisibility(8);
            this.byD.setVisibility(8);
        }
    }

    private void Yk() {
        if (this.bxx.mNavigationBar != null) {
            this.bxx.mNavigationBar.setVisibility(0);
        }
        if (this.vl != null) {
            this.vl.setVisibility(0);
        }
        if (this.byB != null) {
            int visibility = this.bxR != null ? this.bxR.getVisibility() : 0;
            if (visibility == 0) {
                if (this.byK) {
                    this.byE.setVisibility(visibility);
                    this.byD.setVisibility(visibility);
                    return;
                }
                this.byB.setVisibility(visibility);
                return;
            }
            this.byK = this.byE.getVisibility() == 0;
            this.byB.setVisibility(visibility);
            this.byE.setVisibility(visibility);
            this.byD.setVisibility(visibility);
        }
    }

    public Button Yl() {
        return this.byA;
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        if (this.byB != null) {
            this.byB.arn.a(writeImagesInfo, z);
        }
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        if (this.byB != null) {
            this.byB.arn.setBaobaoUris(writeImagesInfo);
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                this.byB.BZ();
            } else {
                this.byB.Ca();
            }
        }
    }

    public void h(com.baidu.tieba.data.ah ahVar) {
        if (ahVar != null) {
            ArrayList<com.baidu.tieba.data.ak> zN = ahVar.zN();
            if (zN.size() == 1) {
                com.baidu.tieba.data.ak akVar = zN.get(0);
                if (akVar.Am() < akVar.Af().size()) {
                    this.vl.setNextPage(null);
                    return;
                } else {
                    this.vl.setNextPage(this.bxY);
                    return;
                }
            }
            this.vl.setNextPage(this.bxY);
        }
    }

    public boolean Cj() {
        if (this.byB == null) {
            return false;
        }
        return this.byB.Cj();
    }

    public boolean Ym() {
        if (this.bxU == null) {
            return false;
        }
        return this.bxU.Cj();
    }

    public void Yn() {
        if (com.baidu.tbadk.performanceLog.v.uP().uQ()) {
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
                                perfLog.YY = true;
                                perfLog.YX = this.bxe.buS;
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
                        perfLog2.YY = true;
                        perfLog2.YX = this.bxe.buS;
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

    public void Yo() {
        if (this.byE != null) {
            this.byE.setVisibility(0);
            if (this.byD != null) {
                this.byD.setVisibility(0);
            }
        }
    }

    public void Yp() {
        if (this.byE != null) {
            this.byE.setVisibility(8);
            if (this.byD != null) {
                this.byD.setVisibility(8);
            }
        }
    }
}
