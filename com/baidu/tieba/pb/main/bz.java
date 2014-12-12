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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class bz {
    private View.OnClickListener aEH;
    private View aff;
    private RelativeLayout apl;
    private NoNetworkView awR;
    private PbActivity bAW;
    private TextView bBA;
    private TextView bBB;
    private View bBF;
    private View bBH;
    private RelativeLayout bBI;
    private bi bBJ;
    private PbListView bBP;
    private View bBR;
    public final com.baidu.tieba.pb.main.b.a bBo;
    private View bBp;
    private ColumnLayout bBr;
    private TextView bBs;
    private TextView bBt;
    private HeadImageView bBu;
    private TextView bBv;
    private ImageView bBw;
    private UserIconBox bBx;
    private UserIconBox bBy;
    private ImageView bBz;
    private LinearLayout bCA;
    private ImageView bCB;
    private TextView bCC;
    private boolean bCE;
    private View bCI;
    private LiveBroadcastCard bCJ;
    private View bCK;
    private TextView bCL;
    private bg bCN;
    private PbEditor bCu;
    private com.baidu.tbadk.editortool.w bCv;
    private View bCw;
    private View bCx;
    private LinearLayout bCy;
    private TextView bCz;
    private View.OnClickListener bzE;
    bh bza;
    private BdListView mListView;
    private com.baidu.adp.widget.ListView.g wv;
    private View bBq = null;
    public FrsPraiseView bBC = null;
    private View bBD = null;
    private View bBE = null;
    private View bBG = null;
    private Dialog bBK = null;
    private Dialog beL = null;
    private com.baidu.tieba.pb.sub.l bBL = null;
    private View bBM = null;
    private EditText bBN = null;
    private com.baidu.tbadk.core.view.al bBO = null;
    private FrameLayout aEg = null;
    private View bBQ = null;
    private DialogInterface.OnClickListener bet = null;
    private AbsListView.OnScrollListener bBS = null;
    private com.baidu.tbadk.widget.richText.s ajW = null;
    private com.baidu.tbadk.core.view.ad aCN = null;
    private Dialog bBT = null;
    private Dialog bBU = null;
    private View bBV = null;
    private Button bBW = null;
    private Button bBX = null;
    private TextView bBY = null;
    private Dialog bBZ = null;
    private View bCa = null;
    private int bCb = 0;
    private RadioGroup Ag = null;
    private RadioButton bCc = null;
    private RadioButton bCd = null;
    private RadioButton bCe = null;
    private Button bCf = null;
    private Button bCg = null;
    private TextView bCh = null;
    private Dialog bCi = null;
    private View bCj = null;
    private RadioGroup bCk = null;
    private CompoundButton.OnCheckedChangeListener bCl = null;
    private Button bCm = null;
    private Button bCn = null;
    private String bCo = null;
    private da bCp = null;
    private Dialog bCq = null;
    private boolean bCr = false;
    private ScrollView bCs = null;
    private Button bCt = null;
    private boolean bCD = true;
    private LinearLayout bCF = null;
    private View bCG = null;
    private PbListView bCH = null;
    private boolean bzA = false;
    private boolean mIsFromCDN = true;
    private com.baidu.tieba.tbadkCore.bubble.y aFe = new ca(this);
    private final View.OnClickListener bCM = new cj(this);
    private View.OnLongClickListener bCO = null;
    private boolean bCP = false;
    private final List<TbImageView> bCQ = new ArrayList();
    private boolean bzz = true;
    private com.baidu.tieba.b.d bzD = new com.baidu.tieba.b.d(new ct(this));

    public NoNetworkView XG() {
        return this.awR;
    }

    public void XH() {
        this.bCD = true;
        if (this.bCu != null) {
            this.bCu.setVisibility(8);
        }
        if (this.bCx != null) {
            this.bCx.setVisibility(0);
            this.bCw.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.b.k XI() {
        int i;
        View childAt;
        if (this.mListView == null) {
            return null;
        }
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.mListView.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.mListView.getChildAt(i3 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.mListView.getHeaderViewsCount();
        int i7 = headerViewsCount >= 0 ? headerViewsCount : 0;
        if (this.bBJ.getItemViewType(i7) != 0) {
            i7++;
        }
        return (com.baidu.tieba.tbadkCore.b.k) this.bBJ.getItem(i7);
    }

    public bz(PbActivity pbActivity, View.OnClickListener onClickListener) {
        this.bAW = null;
        this.apl = null;
        this.mListView = null;
        this.bBp = null;
        this.bBr = null;
        this.bBs = null;
        this.bBt = null;
        this.bBu = null;
        this.bBv = null;
        this.bBw = null;
        this.bBx = null;
        this.bBy = null;
        this.bBz = null;
        this.bBA = null;
        this.bBB = null;
        this.bBF = null;
        this.bBH = null;
        this.bBJ = null;
        this.bBP = null;
        this.aff = null;
        this.aEH = null;
        this.bzE = null;
        this.bCw = null;
        this.bCx = null;
        this.bCy = null;
        this.bCz = null;
        this.bCA = null;
        this.bCB = null;
        this.bCC = null;
        this.bCK = null;
        this.bCL = null;
        this.bAW = pbActivity;
        this.aEH = onClickListener;
        this.apl = (RelativeLayout) com.baidu.adp.lib.g.b.ek().inflate(this.bAW.getPageContext().getPageActivity(), com.baidu.tieba.x.new_pb_activity, null);
        this.bAW.addContentView(this.apl, new FrameLayout.LayoutParams(-1, -1));
        this.bBI = (RelativeLayout) this.bAW.findViewById(com.baidu.tieba.w.title_wrapper);
        this.awR = (NoNetworkView) this.bAW.findViewById(com.baidu.tieba.w.view_no_network);
        this.mListView = (BdListView) this.bAW.findViewById(com.baidu.tieba.w.new_pb_list);
        View view = new View(this.bAW.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.bAW.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_editor_height)));
        this.mListView.addFooterView(view);
        this.bBo = new com.baidu.tieba.pb.main.b.a(pbActivity);
        this.bBo.YO().setOnTouchListener(new com.baidu.tieba.b.a(new cu(this)));
        this.bCx = this.bAW.findViewById(com.baidu.tieba.w.pb_editor_tool_comment);
        this.bCy = (LinearLayout) this.bAW.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_reply);
        this.bCA = (LinearLayout) this.bAW.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_praise);
        this.bCw = this.bAW.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_line);
        this.bCz = (TextView) this.bAW.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_reply_text);
        this.bCB = (ImageView) this.bAW.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_praise_icon);
        this.bCC = (TextView) this.bAW.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_praise_text);
        this.bCy.setOnClickListener(new cv(this));
        this.bCA.setOnClickListener(this.aEH);
        this.bCA.setOnTouchListener(this.bAW);
        Yp();
        this.bBp = com.baidu.adp.lib.g.b.ek().inflate(this.bAW.getPageContext().getPageActivity(), com.baidu.tieba.x.new_pb_header_item, null);
        this.bBr = (ColumnLayout) this.bBp.findViewById(com.baidu.tieba.w.pb_head_owner_root);
        this.bBr.setOnLongClickListener(this.bCO);
        this.bBr.setOnTouchListener(this.bzD);
        this.bBr.setVisibility(8);
        this.bBp.setOnTouchListener(this.bzD);
        this.bBs = (TextView) this.bBp.findViewById(com.baidu.tieba.w.pb_head_post_title);
        this.bBs.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.bBs.setVisibility(8);
        this.bCK = this.bBp.findViewById(com.baidu.tieba.w.pb_head_activity_join_number_container);
        this.bCK.setVisibility(8);
        this.bCL = (TextView) this.bBp.findViewById(com.baidu.tieba.w.pb_head_activity_join_number);
        this.bBt = (TextView) this.bBr.findViewById(com.baidu.tieba.w.pb_head_owner_info_user_name);
        this.bBu = (HeadImageView) this.bBr.findViewById(com.baidu.tieba.w.pb_head_owner_photo);
        if (!this.bzz) {
            this.bBu.setVisibility(8);
        }
        this.bBv = (TextView) this.bBr.findViewById(com.baidu.tieba.w.pb_head_owner_info_user_rank);
        this.bBw = (ImageView) this.bBr.findViewById(com.baidu.tieba.w.pb_head_owner_info_user_gender);
        this.bBx = (UserIconBox) this.bBr.findViewById(com.baidu.tieba.w.pb_head_owner_info_user_icon);
        this.bBy = (UserIconBox) this.bBr.findViewById(com.baidu.tieba.w.pb_head_owner_info_tshow_icon);
        this.bBz = (ImageView) this.bBr.findViewById(com.baidu.tieba.w.pb_head_owner_info_floor_owner);
        this.bBA = (TextView) this.bBr.findViewById(com.baidu.tieba.w.pb_head_owner_info_time);
        this.bBB = (TextView) this.bBp.findViewById(com.baidu.tieba.w.pb_head_reverse_hint);
        this.bBB.setOnClickListener(this.aEH);
        this.bBB.setVisibility(8);
        this.bBF = this.bBp.findViewById(com.baidu.tieba.w.new_pb_header_item_line_below_livepost);
        this.bBH = this.bBp.findViewById(com.baidu.tieba.w.new_pb_header_item_line_above_showpassed);
        this.bBp.setOnLongClickListener(new cw(this));
        XU();
        this.bBJ = new bi(this.bAW);
        this.bBJ.z(this.aEH);
        this.bBJ.a(this.bzD);
        this.bBJ.setOnImageClickListener(this.ajW);
        this.bzE = new cx(this);
        this.bBJ.y(this.bzE);
        this.mListView.setAdapter((ListAdapter) this.bBJ);
        this.mListView.addHeaderView(this.bBp);
        this.bBP = new PbListView(this.bAW.getPageContext().getPageActivity());
        this.aff = this.bBP.getView().findViewById(com.baidu.tieba.w.pb_more_view);
        if (this.aff != null) {
            this.aff.setOnClickListener(this.aEH);
            com.baidu.tbadk.core.util.ax.i(this.aff, com.baidu.tieba.v.pb_foot_more_trans_selector);
        }
        this.bBP.qy();
        this.bBP.cj(com.baidu.tieba.v.pb_foot_more_trans_selector);
        this.bBP.ck(com.baidu.tieba.v.pb_foot_more_trans_selector);
        this.bBR = this.bAW.findViewById(com.baidu.tieba.w.viewstub_progress);
    }

    public PbEditor Fh() {
        return this.bCu;
    }

    public void XJ() {
        if (this.bCu != null) {
            this.apl.removeView(this.bCu);
            this.bCu = null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void XK() {
        if (this.bAW != null) {
            this.bCu = new PbEditor(this.bAW.getPageContext().getPageActivity());
            this.bCu.setOrientation(1);
            this.bCu.setFrom(1);
            this.bCu.aI(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.apl.addView(this.bCu, layoutParams);
            this.bCu.b(this.bAW.getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
            XL();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void XL() {
        if (this.bCu != null) {
            this.bCu.a(this.bAW.getPageContext(), new cy(this));
        }
    }

    public void hw(String str) {
        if (this.bCz != null) {
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                this.bCz.setText(str);
            } else {
                this.bCz.setText(this.bAW.getPageContext().getString(com.baidu.tieba.z.reply));
            }
        }
    }

    public void z(String str, boolean z) {
        this.bCE = z;
        if (this.bCC != null) {
            this.bCC.setText(str);
            dP(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        }
    }

    private void dP(boolean z) {
        if (this.bCB != null) {
            if (this.bCE) {
                com.baidu.tbadk.core.util.ax.c(this.bCB, com.baidu.tieba.v.icon_hand_click);
            } else {
                com.baidu.tbadk.core.util.ax.c(this.bCB, com.baidu.tieba.v.icon_hand_normal);
            }
        }
    }

    public View XM() {
        return this.bCA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQ(boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
            } else {
                this.mListView.postDelayed(new cz(this, z), 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(View view) {
        boolean z;
        View view2;
        if (this.bBI != null && view != null) {
            if (this.bCD) {
                z = this.bCx.getVisibility() == 0;
            } else {
                z = this.bCu != null && this.bCu.getVisibility() == 0;
            }
            boolean z2 = this.bBI.getVisibility() == 0;
            if (z2) {
                View findViewById = this.bAW.findViewById(com.baidu.tieba.w.bg_above_list);
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.bBI.getHeight()));
                com.baidu.tieba.tbadkCore.a.a(this.bAW, this.bBI, com.baidu.tieba.q.top_fold_up, new cb(this, findViewById));
            } else {
                com.baidu.tieba.tbadkCore.a.a(this.bAW, this.bBI, com.baidu.tieba.q.top_fold_down, new cc(this));
            }
            if (this.bCD) {
                view2 = this.bCx;
            } else {
                view2 = this.bCu;
            }
            if (z) {
                if (z2) {
                    if (this.bCu != null) {
                        this.bCu.afG();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.bAW, view2, com.baidu.tieba.q.bottom_fold_down, new cd(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.bAW, view2, com.baidu.tieba.q.bottom_fold_up, new ce(this));
            }
        }
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.bCu == null) {
            return null;
        }
        return this.bCu.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.bCu != null) {
            this.bCu.setAudioData(voiceModel);
        }
    }

    public void Fq() {
        if (this.bCu != null) {
            this.bCu.Fq();
        }
    }

    public void XN() {
        if (this.bBL != null) {
            this.bBL.Yo();
        }
    }

    public com.baidu.tieba.pb.sub.l XO() {
        return this.bBL;
    }

    public void XP() {
        if (this.bBL != null) {
            this.bBL.Yp();
        }
    }

    public VoiceData.VoiceModel XQ() {
        if (this.bBL != null) {
            return this.bBL.getAudioData();
        }
        return null;
    }

    public void XR() {
        if (this.bBL != null) {
            this.bBL.Fq();
        }
    }

    public TextView XS() {
        if (this.bBL == null || !(this.bBL instanceof com.baidu.tieba.pb.sub.i)) {
            return null;
        }
        return ((com.baidu.tieba.pb.sub.i) this.bBL).Zr();
    }

    public bi XT() {
        return this.bBJ;
    }

    public void a(bh bhVar) {
        this.bza = bhVar;
    }

    private void a(com.baidu.tbadk.core.data.z zVar) {
        if (zVar != null && zVar.nP() != 0) {
            if (this.bCt == null) {
                this.bAW.getLayoutMode().h(((ViewStub) this.bBp.findViewById(com.baidu.tieba.w.live_talk_layout)).inflate());
                this.bCt = (Button) this.bBp.findViewById(com.baidu.tieba.w.pb_head_function_manage_go_to_live_post);
                this.bBE = this.bBp.findViewById(com.baidu.tieba.w.new_pb_header_item_line_above_livepost);
            }
            int nQ = zVar.nQ();
            String string = this.bAW.getPageContext().getString(com.baidu.tieba.z.go_to_live_post_prefix);
            if (nQ == 0) {
                string = String.valueOf(string) + this.bAW.getPageContext().getString(com.baidu.tieba.z.go_to_interview_post);
            } else if (nQ == 1) {
                string = String.valueOf(string) + this.bAW.getPageContext().getString(com.baidu.tieba.z.go_to_discuss_post);
            }
            this.bCt.setText(string);
            this.bCt.setVisibility(0);
            this.bCt.setOnClickListener(this.aEH);
            Yv();
        }
    }

    private void XU() {
        this.bCF = (LinearLayout) this.bBp.findViewById(com.baidu.tieba.w.btn_show_passed_pb);
        this.bCH = new PbListView(this.bAW.getPageContext().getPageActivity(), PbListView.IconType.ICON_UP_WARD);
        this.bCG = this.bCH.jx();
        this.bCH.setText(this.bAW.getResources().getString(com.baidu.tieba.z.btn_show_passed_pb));
        this.bCG.setOnClickListener(this.bCM);
        this.bCF.addView(this.bCG);
        this.bCF.requestLayout();
        this.bCF.invalidate();
        com.baidu.tbadk.core.util.ax.i(this.bCG, com.baidu.tieba.t.cp_bg_line_e);
        this.bCH.cj(com.baidu.tieba.t.cp_bg_line_e);
        this.bCH.ck(com.baidu.tieba.t.cp_bg_line_e);
        Yv();
    }

    public void N(View view) {
        if (this.bBT == null) {
            this.bBT = new Dialog(this.bAW.getPageContext().getPageActivity(), com.baidu.tieba.aa.common_alert_dialog);
            this.bBT.setCanceledOnTouchOutside(true);
            this.bBT.setCancelable(true);
            this.bBT.setContentView(com.baidu.adp.lib.g.b.ek().inflate(this.bAW.getPageContext().getPageActivity(), com.baidu.tieba.x.forum_manage_dialog, null));
            WindowManager.LayoutParams attributes = this.bBT.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.M(this.bAW.getPageContext().getPageActivity()) * 0.9d);
            this.bBT.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.bBT.findViewById(com.baidu.tieba.w.del_post_btn);
        Button button2 = (Button) this.bBT.findViewById(com.baidu.tieba.w.forbid_user_btn);
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if ("".equals(sparseArray.get(com.baidu.tieba.w.tag_del_post_id))) {
                button.setVisibility(8);
            } else {
                SparseArray sparseArray2 = (SparseArray) button.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    button.setTag(sparseArray2);
                }
                button.setVisibility(0);
                sparseArray2.put(com.baidu.tieba.w.tag_del_post_id, sparseArray.get(com.baidu.tieba.w.tag_del_post_id));
                sparseArray2.put(com.baidu.tieba.w.tag_del_post_type, sparseArray.get(com.baidu.tieba.w.tag_del_post_type));
                sparseArray2.put(com.baidu.tieba.w.tag_del_post_is_self, sparseArray.get(com.baidu.tieba.w.tag_del_post_is_self));
                sparseArray2.put(com.baidu.tieba.w.tag_manage_user_identity, sparseArray.get(com.baidu.tieba.w.tag_manage_user_identity));
                button.setOnClickListener(new cf(this));
            }
            if ("".equals(sparseArray.get(com.baidu.tieba.w.tag_forbid_user_name))) {
                button2.setVisibility(8);
            } else {
                SparseArray sparseArray3 = (SparseArray) button2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    button2.setTag(sparseArray3);
                }
                button2.setVisibility(0);
                sparseArray3.put(com.baidu.tieba.w.tag_forbid_user_name, sparseArray.get(com.baidu.tieba.w.tag_forbid_user_name));
                sparseArray3.put(com.baidu.tieba.w.tag_manage_user_identity, sparseArray.get(com.baidu.tieba.w.tag_manage_user_identity));
                button2.setOnClickListener(new cg(this));
            }
            com.baidu.adp.lib.g.k.a(this.bBT, this.bAW.getPageContext());
        }
    }

    public void a(bg bgVar) {
        this.bCN = bgVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        if (this.bBU == null) {
            this.bBU = new Dialog(this.bAW.getPageContext().getPageActivity(), com.baidu.tieba.aa.common_alert_dialog);
            this.bBU.setCanceledOnTouchOutside(true);
            this.bBU.setCancelable(true);
            this.bBV = com.baidu.adp.lib.g.b.ek().inflate(this.bAW.getPageContext().getPageActivity(), com.baidu.tieba.x.del_post, null);
            this.bBU.setContentView(this.bBV);
            WindowManager.LayoutParams attributes = this.bBU.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.M(this.bAW.getPageContext().getPageActivity()) * 0.9d);
            this.bBU.getWindow().setAttributes(attributes);
            this.bBW = (Button) this.bBV.findViewById(com.baidu.tieba.w.dialog_button_ok);
            this.bBW.setOnClickListener(this.aEH);
            this.bBX = (Button) this.bBV.findViewById(com.baidu.tieba.w.dialog_button_cancel);
            this.bBX.setOnClickListener(new ch(this));
            this.bBY = (TextView) this.bBV.findViewById(com.baidu.tieba.w.confirm_text);
        }
        SparseArray sparseArray = (SparseArray) this.bBW.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.bBW.setTag(sparseArray);
        }
        sparseArray.put(com.baidu.tieba.w.tag_del_post_id, str);
        sparseArray.put(com.baidu.tieba.w.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(com.baidu.tieba.w.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(com.baidu.tieba.w.tag_del_post_is_self, Boolean.valueOf(z));
        if (i == 0) {
            this.bBY.setText(com.baidu.tieba.z.del_thread_confirm);
        } else {
            this.bBY.setText(com.baidu.tieba.z.del_post_confirm);
        }
        com.baidu.adp.lib.g.k.a(this.bBU, this.bAW.getPageContext());
    }

    public void H(ArrayList<com.baidu.tbadk.core.data.j> arrayList) {
        if (this.bCi == null) {
            this.bCi = new Dialog(this.bAW.getPageContext().getPageActivity(), com.baidu.tieba.aa.common_alert_dialog);
            this.bCi.setCanceledOnTouchOutside(true);
            this.bCi.setCancelable(true);
            this.bCj = com.baidu.adp.lib.g.b.ek().inflate(this.bAW.getPageContext().getPageActivity(), com.baidu.tieba.x.commit_good, null);
            this.bCs = (ScrollView) this.bCj.findViewById(com.baidu.tieba.w.good_scroll);
            this.bCi.setContentView(this.bCj);
            WindowManager.LayoutParams attributes = this.bCi.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.M(this.bAW.getPageContext().getPageActivity()) * 0.9d);
            this.bCi.getWindow().setAttributes(attributes);
            this.bCl = new ci(this);
            this.bCk = (RadioGroup) this.bCj.findViewById(com.baidu.tieba.w.good_class_group);
            this.bCn = (Button) this.bCj.findViewById(com.baidu.tieba.w.dialog_button_cancel);
            this.bCn.setOnClickListener(new ck(this));
            this.bCm = (Button) this.bCj.findViewById(com.baidu.tieba.w.dialog_button_ok);
            this.bCm.setOnClickListener(this.aEH);
        }
        this.bCk.removeAllViews();
        RadioButton radioButton = (RadioButton) com.baidu.adp.lib.g.b.ek().inflate(this.bAW.getPageContext().getPageActivity(), com.baidu.tieba.x.good_class_radio_button, null);
        radioButton.setTag("0");
        radioButton.setText(this.bAW.getPageContext().getString(com.baidu.tieba.z.def_good_class));
        radioButton.setOnCheckedChangeListener(this.bCl);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(com.baidu.adp.lib.util.l.dip2px(this.bAW.getPageContext().getPageActivity(), 10.0f), com.baidu.adp.lib.util.l.dip2px(this.bAW.getPageContext().getPageActivity(), 5.0f), com.baidu.adp.lib.util.l.dip2px(this.bAW.getPageContext().getPageActivity(), 10.0f), com.baidu.adp.lib.util.l.dip2px(this.bAW.getPageContext().getPageActivity(), 5.0f));
        this.bCk.addView(radioButton, layoutParams);
        this.bCk.requestLayout();
        this.bCk.check(radioButton.getId());
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                RadioButton radioButton2 = (RadioButton) com.baidu.adp.lib.g.b.ek().inflate(this.bAW.getPageContext().getPageActivity(), com.baidu.tieba.x.good_class_radio_button, null);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).mM()));
                radioButton2.setText(arrayList.get(i2).mL());
                radioButton2.setOnCheckedChangeListener(this.bCl);
                this.bCk.addView(radioButton2, layoutParams);
                this.bCk.requestLayout();
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bCs.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.bAW.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.bAW.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.bAW.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.bCs.setLayoutParams(layoutParams2);
            this.bCs.removeAllViews();
            this.bCs.addView(this.bCk);
        }
        com.baidu.adp.lib.g.k.a(this.bCi, this.bAW.getPageContext());
    }

    public void XV() {
        this.bAW.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.bAW.hideProgressBar();
        if (z && z2) {
            this.bAW.showToast(this.bAW.getPageContext().getString(com.baidu.tieba.z.success));
        } else if (str != null && z2) {
            this.bAW.showToast(str);
        }
    }

    public void GN() {
        this.apl.removeView(this.aEg);
    }

    public void PR() {
        this.bBR.setVisibility(0);
    }

    public void PQ() {
        this.bBR.setVisibility(8);
    }

    public View XW() {
        if (this.bBV != null) {
            return this.bBV.findViewById(com.baidu.tieba.w.dialog_button_ok);
        }
        return null;
    }

    public View XX() {
        if (this.bCj != null) {
            return this.bCj.findViewById(com.baidu.tieba.w.dialog_button_ok);
        }
        return null;
    }

    public String XY() {
        return this.bCo;
    }

    public View XZ() {
        if (this.bBL != null) {
            return this.bBL.ZG();
        }
        return null;
    }

    public View getView() {
        return this.apl;
    }

    public void Ya() {
        View editText;
        if (this.bCu == null) {
            editText = this.bAW.getCurrentFocus();
        } else {
            editText = this.bCu.getEditText();
        }
        com.baidu.adp.lib.util.l.c(this.bAW.getPageContext().getPageActivity(), editText);
    }

    public void Fn() {
        if (this.bBL != null) {
            this.bBL.ZI();
        } else {
            this.bAW.showProgressBar();
        }
    }

    public void bD(boolean z) {
        if (this.bBL != null) {
            this.bBL.ZJ();
        } else {
            this.bAW.hideProgressBar();
        }
        YE();
        if (z) {
            if (this.bCu != null) {
                this.bCu.getEditText().setText("");
                this.bCu.afC();
                this.bCu.clearData();
            }
            if (this.bBL != null) {
                this.bBL.clearContent();
            }
        }
    }

    public void Yb() {
        this.bBP.startLoadData();
    }

    public void Yc() {
    }

    public void Yd() {
        this.bAW.hideProgressBar();
        this.bBP.qz();
        this.bCH.qz();
        this.mListView.jJ();
        Yv();
    }

    public void Ye() {
        this.mListView.jJ();
        this.bCF.setVisibility(8);
        Yv();
    }

    public void dR(boolean z) {
        if (!z) {
            if (this.bCu != null) {
                this.bCu.afE();
            }
        } else if (this.bBL != null) {
            this.bBL.hC(null);
        }
    }

    public void Yf() {
        if (Yj() && this.bBL != null) {
            this.bBL.Zz();
        }
    }

    public void Yg() {
        if (this.bBL == null) {
            this.bBL = new com.baidu.tieba.pb.sub.l(this.bAW, this.bCP, this.aEH, this.bzE, this.bAW.byP.bDe, this.bAW.byP.bDf, this.bAW.byP.bDg);
            this.bBL.setOnActionListener(this.bCv);
            this.bBL.setOnScrollListener(this.bBS);
            this.bBL.dI(this.bBJ.WY());
            this.bBL.dJ(this.bBJ.WZ());
            this.bBQ = this.bBL.getRootView();
            this.bBL.setOnImageClickListener(this.ajW);
            this.bBL.setOnEmotionClickListener(this.bAW.byP.bDh);
            this.bBL.setOnLongClickListener(this.bBJ.WX());
        }
        this.bBQ.setVisibility(0);
        this.bBL.ea(this.mIsFromCDN);
        this.bBL.Ya();
        this.apl.addView(this.bBQ);
        YH();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.bCv = wVar;
            if (this.bCu != null) {
                XL();
            }
            if (this.bBL != null) {
                this.bBL.setOnActionListener(wVar);
            }
        }
    }

    public void a(da daVar) {
        this.bCp = daVar;
    }

    public void a(boolean z, com.baidu.tieba.tbadkCore.b.o oVar, boolean z2, String str, String str2, View view, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        if (oVar != null && view != null) {
            TiebaStatic.eventStat(this.bAW.getPageContext().getPageActivity(), "pb_tosubpb", "pbclick", 1, new Object[0]);
            if (this.bBL == null) {
                this.bBL = new com.baidu.tieba.pb.sub.l(this.bAW, this.bCP, this.aEH, this.bzE, this.bAW.byP.bDe, this.bAW.byP.bDf, this.bAW.byP.bDg);
                this.bBL.setOnActionListener(this.bCv);
                this.bBL.setOnScrollListener(this.bBS);
                this.bBL.dI(this.bBJ.WY());
                this.bBL.dJ(this.bBJ.WZ());
                this.bBQ = this.bBL.getRootView();
                this.bBL.setOnImageClickListener(this.ajW);
                this.bBL.setOnEmotionClickListener(this.bAW.byP.bDh);
                this.bBL.setOnLongClickListener(this.bBJ.WX());
            }
            this.bBL.gZ(this.bBJ.getWidth());
            this.bBL.a(oVar, i);
            this.bBL.ea(this.mIsFromCDN);
            if (str2 != null && !str2.equals("")) {
                this.bBL.hE(str2);
            } else {
                this.bBL.setPosition(1);
            }
            int i2 = 0;
            if (this.bBI.getVisibility() == 0) {
                i2 = this.bBI.getHeight();
            }
            int top = view.getTop() + i2;
            int bottom = view.getBottom() + i2;
            if (!z) {
                this.bBL.ZC();
            }
            int height = ((view.getHeight() + this.bAW.getResources().getDimensionPixelSize(com.baidu.tieba.u.subpb_listitem_packup_min_height)) - this.bAW.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_list_item_border_bottom_margin_top)) - this.apl.getHeight();
            if (height > 0) {
                top += height;
            }
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, top, 0.0f);
            translateAnimation.setDuration(300L);
            this.bBQ.setAnimation(translateAnimation);
            try {
                this.apl.invalidate();
                this.apl.buildDrawingCache();
                bitmap = this.apl.getDrawingCache();
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
            this.bBQ.setVisibility(0);
            if (this.bBQ.getParent() == this.apl) {
                this.apl.removeView(this.bBQ);
            }
            this.apl.addView(this.bBQ, new RelativeLayout.LayoutParams(-1, -1));
            if (bitmap2 != null) {
                ImageView imageView = new ImageView(this.bAW.getPageContext().getPageActivity());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(10);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageBitmap(bitmap2);
                this.apl.addView(imageView);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -top);
                translateAnimation2.setDuration(300L);
                imageView.setAnimation(translateAnimation2);
                translateAnimation2.setAnimationListener(new cl(this, imageView));
                translateAnimation2.setInterpolator(accelerateInterpolator);
                translateAnimation2.start();
            }
            translateAnimation.setAnimationListener(new cn(this, oVar, z, str, str2));
            translateAnimation.setInterpolator(accelerateInterpolator);
            if (bitmap3 != null) {
                ImageView imageView2 = new ImageView(this.bAW.getPageContext().getPageActivity());
                imageView2.setImageBitmap(bitmap3);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(12);
                imageView2.setLayoutParams(layoutParams2);
                this.apl.addView(imageView2);
                TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, 0.0f, bitmap3 == null ? 0 : bitmap3.getHeight());
                translateAnimation3.setDuration(300L);
                imageView2.setAnimation(translateAnimation3);
                translateAnimation3.setAnimationListener(new cp(this, imageView2));
                translateAnimation3.setInterpolator(accelerateInterpolator);
                translateAnimation3.start();
            }
            translateAnimation.start();
        }
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.bCO = onLongClickListener;
        this.bBJ.setOnLongClickListener(onLongClickListener);
        if (this.bBL != null) {
            this.bBL.setOnLongClickListener(onLongClickListener);
        }
    }

    public void Yh() {
        if (Yj()) {
            this.bBL.ZD();
        }
    }

    public void Yi() {
        if (Yj() && (this.bBL instanceof com.baidu.tieba.pb.sub.i)) {
            ((com.baidu.tieba.pb.sub.i) this.bBL).Zu();
        }
    }

    public boolean Yj() {
        return (this.bBQ == null || this.bBQ.getVisibility() == 8) ? false : true;
    }

    public void Yk() {
        if (this.bBQ != null) {
            this.bBQ.setVisibility(8);
            this.apl.removeView(this.bBQ);
            this.bBL.Ir();
        }
        YE();
        YI();
    }

    public void Yl() {
        if (this.bBQ != null) {
            if (this.apl != null) {
                this.apl.removeView(this.bBQ);
            }
            this.bBQ = null;
        }
        if (this.bBL != null) {
            this.bBL.Ir();
            this.bBL = null;
        }
    }

    public void Ym() {
        if (this.bBL != null) {
            this.bBL.ZK();
            if (this.bBL instanceof com.baidu.tieba.pb.sub.i) {
                ((com.baidu.tieba.pb.sub.i) this.bBL).Zv();
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.b.o oVar, int i) {
        if (this.bBL != null) {
            this.bBL.ZK();
            this.bBL.gZ(this.bBJ.getWidth());
            this.bBL.a(oVar, i);
        }
    }

    public void Yn() {
        if (this.bBL == null) {
            this.bBL = new com.baidu.tieba.pb.sub.i(this.bAW, this.bCP, this.aEH, this.bzE, this.bAW.byP.bDe, this.bAW.byP.bDf, this.bAW.byP.bDg);
            this.bBL.setOnActionListener(this.bCv);
            this.bBL.setOnScrollListener(this.bBS);
            this.bBL.dI(this.bBJ.WY());
            this.bBL.dJ(this.bBJ.WZ());
            this.bBQ = this.bBL.getRootView();
            this.bBL.setOnImageClickListener(this.ajW);
            this.bBL.setOnEmotionClickListener(this.bAW.byP.bDh);
            this.bBL.setOnLongClickListener(this.bBJ.WX());
        }
        this.bBQ.setVisibility(0);
        this.bBL.Ya();
        this.apl.addView(this.bBQ);
        YH();
    }

    public void a(com.baidu.tieba.tbadkCore.b.o oVar, int i, String str, boolean z, boolean z2) {
        if (this.bBL != null && (this.bBL instanceof com.baidu.tieba.pb.sub.i)) {
            com.baidu.tieba.pb.sub.i iVar = (com.baidu.tieba.pb.sub.i) this.bBL;
            this.bBL.ZK();
            this.bBL.gZ(this.bBJ.getWidth());
            this.bBL.a(oVar, i);
            if (z2) {
                iVar.hB(str);
            }
            if (!z) {
                iVar.Zw();
            } else {
                iVar.Zx();
            }
        }
    }

    public void z(ArrayList<String> arrayList) {
        if (this.bCu != null) {
            this.bCu.z(arrayList);
        }
    }

    public void I(ArrayList<String> arrayList) {
        if (this.bBL != null) {
            this.bBL.z(arrayList);
        }
    }

    public void Yo() {
        this.bCP = true;
        if (this.bCu != null) {
            this.bCu.Yo();
        }
    }

    public void Yp() {
        this.bCP = false;
        if (this.bCu != null) {
            this.bCu.Yp();
        }
    }

    public void a(DialogInterface.OnClickListener onClickListener, boolean z, boolean z2) {
        if (this.bCq != null) {
            com.baidu.adp.lib.g.k.b(this.bCq, this.bAW.getPageContext());
            this.bCq = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.bAW.getPageContext().getPageActivity());
        builder.setTitle(com.baidu.tieba.z.operation);
        if (z2) {
            builder.setItems(new String[]{this.bAW.getPageContext().getString(com.baidu.tieba.z.copy)}, onClickListener);
        } else if (!z) {
            builder.setItems(new String[]{this.bAW.getPageContext().getString(com.baidu.tieba.z.copy), this.bAW.getPageContext().getString(com.baidu.tieba.z.mark)}, onClickListener);
        } else {
            builder.setItems(new String[]{this.bAW.getPageContext().getString(com.baidu.tieba.z.copy), this.bAW.getPageContext().getString(com.baidu.tieba.z.remove_mark)}, onClickListener);
        }
        this.bCq = builder.create();
        this.bCq.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.bCq, this.bAW.getPageContext());
    }

    public void setAudioFocusable(boolean z) {
        if (this.bCu != null) {
            this.bCu.setAudioFocusable(z);
        }
    }

    public void dS(boolean z) {
        if (this.bBL != null) {
            this.bBL.setAudioFocusable(z);
        }
    }

    public void j(Bitmap bitmap) {
        if (this.bCu != null) {
            this.bCu.j(bitmap);
            this.bCu.afB();
        }
    }

    public void Yq() {
        if (this.bCu != null) {
            this.bCu.j(null);
        }
    }

    public int Yr() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        com.baidu.adp.widget.ListView.k kVar = (com.baidu.adp.widget.ListView.k) this.mListView.getAdapter();
        if (kVar != null) {
            if (kVar.getItem(firstVisiblePosition) instanceof com.baidu.tieba.data.l) {
                firstVisiblePosition++;
            }
            int headersCount = (this.mListView.getAdapter() == null || !(this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.k)) ? 0 : ((com.baidu.adp.widget.ListView.k) this.mListView.getAdapter()).getHeadersCount();
            return firstVisiblePosition > headersCount ? firstVisiblePosition - headersCount : 0;
        }
        return firstVisiblePosition;
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.bBN.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public String Fo() {
        return this.bCu == null ? "" : this.bCu.getContent();
    }

    public void fx(String str) {
        if (this.bCu != null) {
            this.bCu.setContent(str);
        }
    }

    public String Ys() {
        if (this.bBL == null) {
            return null;
        }
        return this.bBL.ZH();
    }

    public String Yt() {
        if (this.bBL != null) {
            return this.bBL.ZE();
        }
        return null;
    }

    public String Yu() {
        if (this.bBL != null) {
            return this.bBL.ZA();
        }
        return null;
    }

    public void e(com.baidu.tieba.tbadkCore.b.i iVar) {
        this.bBJ.b(iVar);
        this.bBJ.notifyDataSetChanged();
        if (iVar == null) {
            hw("");
        } else {
            hw(com.baidu.tbadk.core.util.ba.p(iVar.agE().getReply_num()));
        }
        Yv();
    }

    public void f(com.baidu.tieba.tbadkCore.b.i iVar) {
        PraiseData praise;
        if (this.bBC == null) {
            this.bAW.getLayoutMode().h(((ViewStub) this.bBp.findViewById(com.baidu.tieba.w.praise_layout)).inflate());
            this.bBC = (FrsPraiseView) this.bBp.findViewById(com.baidu.tieba.w.pb_head_praise_view);
            this.bBC.setIsFromPb(true);
            this.bBG = this.bBp.findViewById(com.baidu.tieba.w.new_pb_header_item_line_above_praise);
            this.bBC.cm(TbadkCoreApplication.m255getInst().getSkinType());
        }
        if (this.bBC != null) {
            boolean Yv = Yv();
            if (iVar != null && iVar.agF() != null && iVar.agF().size() > 0) {
                com.baidu.tieba.tbadkCore.b.k kVar = iVar.agF().get(0);
                if ((!this.bzA || kVar.agT() != 1) && (praise = iVar.agE().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.bBC.setVisibility(0);
                    this.bBC.setIsFromPb(true);
                    this.bBC.a(praise, iVar.agE().getId(), praise.getPostId(), true);
                    this.bBG.setVisibility(0);
                    if (this.bBC.getVisibility() == 0) {
                        this.bBH.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.bBC.setVisibility(8);
            this.bBG.setVisibility(8);
            if (iVar != null && iVar.mY() != null && iVar.mY().mX() == 0 && this.bzA) {
                this.bBG.setVisibility(8);
                if (Yv) {
                    this.bBF.setVisibility(0);
                    return;
                } else {
                    this.bBF.setVisibility(8);
                    return;
                }
            }
            this.bBG.setVisibility(0);
            this.bBF.setVisibility(8);
        }
    }

    private com.baidu.tieba.tbadkCore.b.k a(com.baidu.tieba.tbadkCore.b.i iVar, boolean z, int i) {
        if (z) {
            if (iVar == null || iVar.agF() == null || iVar.agF().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.b.k kVar = iVar.agF().get(0);
            if (kVar.agT() != 1) {
                return g(iVar);
            }
            return kVar;
        }
        return g(iVar);
    }

    private com.baidu.tieba.tbadkCore.b.k g(com.baidu.tieba.tbadkCore.b.i iVar) {
        MetaData metaData;
        if (iVar == null || iVar.agE() == null || iVar.agE().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.b.k kVar = new com.baidu.tieba.tbadkCore.b.k();
        MetaData author = iVar.agE().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = iVar.agE().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        kVar.hO(1);
        kVar.setId(iVar.agE().nD());
        kVar.setTitle(iVar.agE().getTitle());
        kVar.setTime(iVar.agE().getCreateTime());
        kVar.a(metaData);
        return kVar;
    }

    private void b(com.baidu.tieba.tbadkCore.b.i iVar, boolean z, int i) {
        this.bBr.setVisibility(8);
        com.baidu.tieba.tbadkCore.b.k a = a(iVar, z, i);
        if (a != null) {
            if (z) {
                this.bBB.setVisibility(8);
            } else {
                this.bBB.setVisibility(0);
            }
            this.bBr.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.bBr.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.bBr.setTag(sparseArray);
            }
            sparseArray.put(com.baidu.tieba.w.tag_clip_board, a);
            sparseArray.put(com.baidu.tieba.w.tag_is_subpb, false);
            this.bBA.setText(com.baidu.tbadk.core.util.ba.n(a.getTime()));
            iVar.agE().nJ();
            this.bBs.setVisibility(0);
            this.bBs.setText(iVar.agE().getSpan_str());
            f(iVar);
            ArrayList<com.baidu.tbadk.core.data.b> ny = iVar.agE().ny();
            if (ny != null && ny.size() > 0) {
                this.bCL.setText(String.valueOf(ny.get(0).mt()));
                this.bCK.setVisibility(0);
            } else {
                this.bCK.setVisibility(8);
            }
            com.baidu.tbadk.core.util.ax.i(this.bCK, com.baidu.tieba.v.activity_join_num_bg);
            com.baidu.tbadk.core.util.ax.b(this.bCL, com.baidu.tieba.t.cp_link_tip_d, 1);
            boolean appResponseToIntentClass = TbadkCoreApplication.m255getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
            if (iVar.agE().getAnchorInfoData().getGroup_id() != 0 && appResponseToIntentClass) {
                if (this.bCI == null) {
                    BdLog.e("pb time   liveCardLayout new");
                    this.bCI = ((ViewStub) this.bBp.findViewById(com.baidu.tieba.w.live_card_layout)).inflate();
                    this.bAW.getLayoutMode().h(this.bCI);
                    this.bCJ = (LiveBroadcastCard) this.bBp.findViewById(com.baidu.tieba.w.item_card);
                }
                this.bCI.setVisibility(0);
                LiveCardData liveCardData = new LiveCardData();
                liveCardData.setPublisherId(iVar.agE().getAnchorInfoData().getAuthorId());
                liveCardData.setPublisherName(iVar.agE().getAnchorInfoData().getAuthorName());
                liveCardData.setPublisherPortrait(iVar.agE().getAnchorInfoData().getPublisherPortrait());
                liveCardData.setGroupId(iVar.agE().getAnchorInfoData().getGroup_id());
                liveCardData.setIntro(iVar.agE().getAnchorInfoData().getIntro());
                liveCardData.setLikers(iVar.agE().getAnchorInfoData().getLikers());
                liveCardData.setListeners(iVar.agE().getAnchorInfoData().getListeners());
                liveCardData.setName(iVar.agE().getAnchorInfoData().getName());
                liveCardData.setPortrait(iVar.agE().getAnchorInfoData().getPortrait());
                liveCardData.setStatus(iVar.agE().getAnchorInfoData().getStatus());
                liveCardData.setStartTime(iVar.agE().getAnchorInfoData().getStartTime());
                this.bCJ.setData(liveCardData);
                this.bCJ.setStatisticsKey("notice_pb_live");
            } else if (this.bCI != null) {
                this.bCI.setVisibility(8);
            }
            String userId = iVar.agE().getAuthor().getUserId();
            if (userId != null && !userId.equals("0") && userId.equals(a.getAuthor().getUserId())) {
                this.bBz.setVisibility(0);
            } else {
                this.bBz.setVisibility(8);
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.bBv.setVisibility(0);
                    this.bBv.setText(String.valueOf(level_id));
                    com.baidu.tbadk.core.util.ax.i((View) this.bBv, com.baidu.tbadk.core.util.d.bK(level_id));
                    i2 = 2;
                    this.bBv.setOnClickListener(null);
                } else {
                    this.bBv.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.bBv.setText((CharSequence) null);
                        com.baidu.tbadk.core.util.ax.i((View) this.bBv, com.baidu.tieba.v.pb_manager);
                        this.bBv.setOnClickListener(this.bAW.byP.bDf);
                    } else if (bawu_type.equals("assist")) {
                        this.bBv.setText((CharSequence) null);
                        com.baidu.tbadk.core.util.ax.i((View) this.bBv, com.baidu.tieba.v.pb_assist);
                        this.bBv.setOnClickListener(this.bAW.byP.bDf);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.ax.c(this.bBw, com.baidu.tieba.v.icon_pop_girl_square);
                    this.bBw.setVisibility(0);
                } else {
                    this.bBw.setVisibility(8);
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfo = a.getAuthor().getTShowInfo();
                if (this.bBx != null) {
                    this.bBx.setOnClickListener(this.bAW.byP.bDf);
                    this.bBx.a(iconInfo, i2, this.bAW.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_width), this.bAW.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_height), this.bAW.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_margin));
                }
                if (this.bBy != null) {
                    this.bBy.setOnClickListener(this.bAW.byP.bDg);
                    this.bBy.a(tShowInfo, 3, this.bAW.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_width), this.bAW.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_height), this.bAW.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_margin), true);
                }
                this.bBt.setText(a.getAuthor().getName_show());
                this.bBt.setTag(com.baidu.tieba.w.tag_user_id, a.getAuthor().getUserId());
                this.bBt.setTag(com.baidu.tieba.w.tag_user_name, a.getAuthor().getName_show());
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.ax.b(this.bBt, com.baidu.tieba.t.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ax.b(this.bBt, com.baidu.tieba.t.cp_cont_f, 1);
                }
                if (!this.bzz) {
                    this.bBu.setVisibility(8);
                }
                this.bBu.setUserId(a.getAuthor().getUserId());
                this.bBu.setUserName(a.getAuthor().getUserName());
                this.bBu.setImageDrawable(null);
                this.bBu.setTag(a.getAuthor().getUserId());
                this.bBt.setOnClickListener(this.bAW.byP.bDe);
                this.bBu.setOnClickListener(this.bAW.byP.bDe);
                this.bBu.d(a.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.b.i iVar, int i, int i2, boolean z, int i3) {
        Parcelable XA;
        Parcelable XA2;
        String sb;
        this.bzA = z;
        Yd();
        b(iVar, z, i);
        this.bBJ.dH(this.bzA);
        this.bBJ.b(iVar);
        this.bBJ.notifyDataSetChanged();
        this.bBo.hx(iVar.aej().getName());
        if (iVar.agE() != null) {
            hw(com.baidu.tbadk.core.util.ba.p(iVar.agE().getReply_num()));
            if (iVar.agE().getPraise() != null) {
                if (iVar.agE().getPraise().getNum() < 1) {
                    sb = this.bAW.getResources().getString(com.baidu.tieba.z.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(iVar.agE().getPraise().getNum())).toString();
                }
                z(sb, iVar.agE().getPraise().getIsLike() == 1);
            }
        }
        if (iVar.mY().mW() == 0 && !z) {
            this.mListView.setNextPage(null);
        } else {
            this.mListView.setNextPage(this.bBP);
            this.bCH.qz();
        }
        if (iVar.mY().mX() == 0 && z) {
            this.mListView.setPullRefresh(null);
            this.bCF.setVisibility(8);
        } else {
            if (this.bBO == null) {
                this.bBO = new com.baidu.tbadk.core.view.al(this.bAW.getPageContext().getPageActivity());
                this.bBO.jx();
                this.bBO.a(this.wv);
            }
            this.mListView.setPullRefresh(this.bBO);
            if (this.bBO != null) {
                this.bBO.cl(TbadkCoreApplication.m255getInst().getSkinType());
            }
            this.bCF.setVisibility(0);
            this.bCH.qz();
        }
        Yv();
        if (iVar.mY().mW() == 0) {
            this.bBP.setText(this.bAW.getResources().getString(com.baidu.tieba.z.no_more_to_load));
            h(iVar);
        } else {
            this.bBP.setText(this.bAW.getResources().getString(com.baidu.tieba.z.pb_load_more));
        }
        if (z) {
            this.bCH.setText(this.bAW.getResources().getString(com.baidu.tieba.z.btn_show_passed_pb));
        } else {
            this.bCH.setText(this.bAW.getResources().getString(com.baidu.tieba.z.btn_show_passed_pb_aftre));
        }
        if (iVar.agE() != null && iVar.agE().getAuthor() != null && iVar.agE().getAuthor().getType() == 0) {
            this.bBo.YP();
        }
        switch (i) {
            case 2:
                this.mListView.setSelection(i2);
                if (this.bBq != null) {
                    CompatibleUtile.scrollListViewBy(this.mListView, -this.bBq.getHeight(), 0);
                    return;
                }
                return;
            case 3:
                if (i3 == 1 && (XA2 = bv.Xz().XA()) != null) {
                    this.mListView.onRestoreInstanceState(XA2);
                    return;
                } else {
                    this.mListView.setSelection(0);
                    return;
                }
            case 4:
                if (z) {
                    this.mListView.setSelection(0);
                    return;
                } else if (iVar.agF() != null) {
                    if (iVar.mY() != null && iVar.mY().mX() != 0) {
                        this.mListView.setSelection(iVar.agF().size() + 1);
                        return;
                    } else {
                        this.mListView.setSelection(iVar.agF().size());
                        return;
                    }
                } else {
                    return;
                }
            case 5:
                this.mListView.setSelection(0);
                return;
            case 6:
                if (i3 == 1 && (XA = bv.Xz().XA()) != null) {
                    this.mListView.onRestoreInstanceState(XA);
                    return;
                } else if (z) {
                    this.mListView.setSelection(0);
                    return;
                } else if (iVar.agF() != null) {
                    if (iVar.mY() != null && iVar.mY().mX() != 0) {
                        this.mListView.setSelection(iVar.agF().size() + 1);
                        return;
                    } else {
                        this.mListView.setSelection(iVar.agF().size());
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void dT(boolean z) {
        this.bCr = z;
        this.bBo.dT(z);
    }

    public void qz() {
        if (this.bBP != null) {
            this.bBP.qz();
        }
        if (this.bCH != null) {
            this.bCH.qz();
        }
    }

    public void Gv() {
        this.mListView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Yv() {
        boolean z;
        boolean z2 = true;
        if (this.bBq != null && this.bBq.getVisibility() == 0) {
            if (this.bBD != null) {
                this.bBD.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.bBD != null) {
                this.bBD.setVisibility(8);
            }
            z = false;
        }
        if (this.bCt != null && this.bCt.getVisibility() == 0) {
            if (this.bBE != null) {
                this.bBE.setVisibility(0);
            }
        } else {
            if (this.bBE != null) {
                this.bBE.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.bBG == null || this.bBG.getVisibility() == 8) && z2 && this.bzA) {
            this.bBF.setVisibility(0);
        } else {
            this.bBF.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.tbadkCore.b.i iVar, boolean z, boolean z2) {
        if (iVar == null) {
            return false;
        }
        if (this.bBs != null) {
            if (iVar.agE().nA() == 0) {
                this.bBs.setVisibility(0);
                iVar.agE().nJ();
                this.bBs.setText(iVar.agE().getSpan_str());
            } else {
                this.bBs.setVisibility(8);
            }
        }
        if (z) {
            if (this.bCI != null) {
                this.bCI.findViewById(com.baidu.tieba.w.pb_head_live_blank).setVisibility(8);
            }
        } else if (this.bCI != null) {
            this.bCI.findViewById(com.baidu.tieba.w.pb_head_live_blank).setVisibility(0);
        }
        this.bzA = z;
        com.baidu.tbadk.core.data.w agE = iVar.agE();
        if (agE != null) {
            a(agE.nr());
        }
        if (iVar.agG() == 1) {
            Yw();
            Button button = (Button) this.bBp.findViewById(com.baidu.tieba.w.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.bBp.findViewById(com.baidu.tieba.w.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.bBp.findViewById(com.baidu.tieba.w.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.bBp.findViewById(com.baidu.tieba.w.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.aEH);
            button2.setOnClickListener(this.aEH);
            button3.setOnClickListener(this.aEH);
            button4.setOnClickListener(this.aEH);
            if (iVar.agE().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (iVar.agE().getIs_top() == 1) {
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

    private void Yw() {
        if (this.bBq == null) {
            this.bBq = ((ViewStub) this.bBp.findViewById(com.baidu.tieba.w.pb_header_function_manage)).inflate();
            this.bAW.getLayoutMode().h(this.bBq);
            this.bBD = this.bBp.findViewById(com.baidu.tieba.w.new_pb_header_item_line_above_manage);
            return;
        }
        this.bBq.setVisibility(0);
    }

    public void a(com.baidu.tieba.tbadkCore.b.i iVar, boolean z, boolean z2, int i) {
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (iVar != null) {
            a(iVar, z, z2);
            com.baidu.tieba.tbadkCore.b.k a = a(iVar, z, i);
            if (a != null) {
                if (iVar.agG() != 0 && a.getAuthor() != null) {
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
                    String userId3 = iVar.agE().getAuthor().getUserId();
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
                        sparseArray.put(com.baidu.tieba.w.tag_forbid_user_name, a.getAuthor().getUserName());
                    }
                    sparseArray.put(com.baidu.tieba.w.tag_del_post_id, a.getId());
                    sparseArray.put(com.baidu.tieba.w.tag_del_post_type, 0);
                    sparseArray.put(com.baidu.tieba.w.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray.put(com.baidu.tieba.w.tag_manage_user_identity, Integer.valueOf(iVar.agG()));
                    sparseArray.put(com.baidu.tieba.w.tag_should_manage_visible, true);
                    a(com.baidu.tieba.z.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(com.baidu.tieba.w.tag_del_post_id, a.getId());
                    sparseArray2.put(com.baidu.tieba.w.tag_del_post_type, 0);
                    sparseArray2.put(com.baidu.tieba.w.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(com.baidu.tieba.w.tag_manage_user_identity, Integer.valueOf(iVar.agG()));
                    sparseArray2.put(com.baidu.tieba.w.tag_should_manage_visible, false);
                    a(com.baidu.tieba.z.delete, sparseArray2);
                }
            }
            Yv();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        Yw();
        Button button = (Button) this.bBp.findViewById(com.baidu.tieba.w.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.aEH);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.aff;
    }

    public BdListView getListView() {
        return this.mListView;
    }

    public int Yx() {
        return com.baidu.tieba.w.richText;
    }

    public int EO() {
        return com.baidu.tieba.w.user_icon_box;
    }

    public Button Yy() {
        return (Button) this.bBp.findViewById(com.baidu.tieba.w.pb_head_function_manage_commit_good);
    }

    public Button Yz() {
        return (Button) this.bBp.findViewById(com.baidu.tieba.w.pb_head_function_manage_cancel_good);
    }

    public Button YA() {
        return (Button) this.bBp.findViewById(com.baidu.tieba.w.pb_head_function_manage_commit_top);
    }

    public Button YB() {
        return (Button) this.bBp.findViewById(com.baidu.tieba.w.pb_head_function_manage_cancel_top);
    }

    public View YC() {
        if (this.bBL == null) {
            return null;
        }
        return this.bBL.ZF();
    }

    public void c(com.baidu.adp.widget.ListView.ab abVar) {
        this.mListView.setOnSrollToBottomListener(abVar);
    }

    public void a(com.baidu.adp.widget.ListView.ae aeVar) {
        this.mListView.setOnSrollToTopListener(aeVar);
    }

    public void b(DialogInterface.OnClickListener onClickListener) {
        this.bet = onClickListener;
    }

    public void a(com.baidu.adp.widget.ListView.g gVar) {
        this.wv = gVar;
        if (this.bBO != null) {
            this.bBO.a(gVar);
        }
    }

    public void b(com.baidu.tbadk.core.data.p pVar) {
        if (pVar != null) {
            int mU = pVar.mU();
            int mS = pVar.mS();
            if (this.bBK == null) {
                this.bBK = new Dialog(this.bAW.getPageContext().getPageActivity(), com.baidu.tieba.aa.common_alert_dialog);
                this.bBK.setCanceledOnTouchOutside(true);
                this.bBK.setCancelable(true);
                this.bBM = com.baidu.adp.lib.g.b.ek().inflate(this.bAW.getPageContext().getPageActivity(), com.baidu.tieba.x.dialog_direct_pager, null);
                this.bBK.setContentView(this.bBM);
                WindowManager.LayoutParams attributes = this.bBK.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = com.baidu.adp.lib.util.l.dip2px(this.bAW.getPageContext().getPageActivity(), 54.0f);
                attributes.width = (int) (com.baidu.adp.lib.util.l.M(this.bAW.getPageContext().getPageActivity()) * 0.9d);
                this.bBK.getWindow().setAttributes(attributes);
                this.bBK.setOnKeyListener(new cr(this));
            }
            com.baidu.adp.lib.g.k.a(this.bBK, this.bAW.getPageContext());
            ((Button) this.bBM.findViewById(com.baidu.tieba.w.dialog_button_ok)).setOnClickListener(this.aEH);
            ((Button) this.bBM.findViewById(com.baidu.tieba.w.dialog_button_cancel)).setOnClickListener(this.aEH);
            this.bBN = (EditText) this.bBM.findViewById(com.baidu.tieba.w.input_page_number);
            this.bBN.setText("");
            this.bBN.setOnFocusChangeListener(new cs(this));
            TextView textView = (TextView) this.bBM.findViewById(com.baidu.tieba.w.current_page_number);
            if (mU <= 0) {
                mU = 1;
            }
            textView.setText(MessageFormat.format(this.bAW.getApplicationContext().getResources().getString(com.baidu.tieba.z.current_page), Integer.valueOf(mU), Integer.valueOf(mS <= 0 ? 1 : mS)));
            this.bAW.ShowSoftKeyPadDelay(this.bBN, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.bBS = onScrollListener;
    }

    public void showToast(String str) {
        this.bAW.showToast(str);
    }

    public boolean dU(boolean z) {
        if (this.bBL == null || !this.bBL.Zp()) {
            if (!z) {
                if (Yj()) {
                    Yk();
                    return true;
                } else if (this.bCu != null && this.bCu.afj()) {
                    this.bCu.afH();
                    return true;
                }
            } else if (Yj()) {
                Yk();
                return true;
            }
            return false;
        }
        return true;
    }

    public void YD() {
        if (this.bCQ != null) {
            while (this.bCQ.size() > 0) {
                TbImageView remove = this.bCQ.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        YD();
    }

    public void onDestroy() {
        this.bAW.hideProgressBar();
        if (this.awR != null && this.aCN != null) {
            this.awR.b(this.aCN);
        }
        YE();
        this.bBP.qz();
    }

    public void YE() {
        this.bBo.YQ();
        com.baidu.adp.lib.util.l.c(this.bAW.getPageContext().getPageActivity(), this.bBN);
        if (this.bCu != null) {
            this.bCu.afF();
        }
        if (this.bBK != null) {
            com.baidu.adp.lib.g.k.b(this.bBK, this.bAW.getPageContext());
        }
        if (this.bCq != null) {
            com.baidu.adp.lib.g.k.b(this.bCq, this.bAW.getPageContext());
        }
        if (this.bBL != null) {
            this.bBL.ZC();
        }
        YF();
    }

    public void dI(boolean z) {
        this.bBJ.dI(z);
        if (this.bBL != null) {
            this.bBL.dI(z);
        }
    }

    public void dJ(boolean z) {
        this.bzz = z;
        this.bBJ.dJ(z);
        if (this.bBL != null) {
            this.bBL.dJ(z);
        }
    }

    public void YF() {
        if (this.bBU != null) {
            com.baidu.adp.lib.g.k.b(this.bBU, this.bAW.getPageContext());
        }
        if (this.bBZ != null) {
            com.baidu.adp.lib.g.k.b(this.bBZ, this.bAW.getPageContext());
        }
        if (this.bCi != null) {
            com.baidu.adp.lib.g.k.b(this.bCi, this.bAW.getPageContext());
        }
        if (this.bBT != null) {
            com.baidu.adp.lib.g.k.b(this.bBT, this.bAW.getPageContext());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: com.baidu.tieba.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.bAW.getLayoutMode().ab(i == 1);
        this.bAW.getLayoutMode().h(this.apl);
        this.bAW.getLayoutMode().h(this.bBp);
        this.bAW.getLayoutMode().h(this.aff);
        this.bBo.mNavigationBar.onChangeSkinType(this.bAW.getPageContext(), i);
        dT(this.bCr);
        this.bBJ.notifyDataSetChanged();
        if (this.bBL != null) {
            this.bBL.onChangeSkinType(i);
            this.bAW.getLayoutMode().h(this.bBP.getView());
        }
        if (this.bBO != null) {
            this.bBO.cl(i);
        }
        if (this.bBP != null) {
            this.bBP.cl(i);
            com.baidu.tbadk.core.util.ax.i(this.aff, com.baidu.tieba.v.pb_foot_more_trans_selector);
            this.bBP.cj(com.baidu.tieba.v.pb_foot_more_trans_selector);
        }
        if (this.bCH != null) {
            this.bCH.cl(i);
            this.bCH.cj(com.baidu.tieba.t.cp_bg_line_e);
            com.baidu.tbadk.core.util.ax.i(this.bCG, com.baidu.tieba.t.cp_bg_line_e);
        }
        if (this.bCu != null) {
            this.bCu.b(this.bAW.getPageContext(), i);
        }
        if (this.bBC != null) {
            this.bBC.cm(i);
        }
        dP(i == 1);
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.ajW = sVar;
        this.bBJ.setOnImageClickListener(this.ajW);
        if (this.bBL != null) {
            this.bBL.setOnImageClickListener(this.ajW);
        }
    }

    public void f(com.baidu.tbadk.core.view.ad adVar) {
        this.aCN = adVar;
        if (this.awR != null) {
            this.awR.a(this.aCN);
        }
    }

    public void dV(boolean z) {
        this.bBJ.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public View YG() {
        if (this.bBL == null) {
            return null;
        }
        return this.bBL.ZL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YH() {
        if (this.bBo.mNavigationBar != null) {
            this.bBo.mNavigationBar.setVisibility(8);
        }
        if (this.mListView != null) {
            this.mListView.setVisibility(8);
        }
        if (this.bCu != null) {
            this.bCD = this.bCx.getVisibility() == 0;
            this.bCu.setVisibility(8);
            this.bCx.setVisibility(8);
            this.bCw.setVisibility(8);
        }
    }

    private void YI() {
        if (this.bBo.mNavigationBar != null) {
            this.bBo.mNavigationBar.setVisibility(0);
        }
        if (this.mListView != null) {
            this.mListView.setVisibility(0);
        }
        if (this.bCu != null) {
            int visibility = this.bBI != null ? this.bBI.getVisibility() : 0;
            if (visibility == 0) {
                if (this.bCD) {
                    this.bCx.setVisibility(visibility);
                    this.bCw.setVisibility(visibility);
                    return;
                }
                this.bCu.setVisibility(visibility);
                return;
            }
            this.bCD = this.bCx.getVisibility() == 0;
            this.bCu.setVisibility(visibility);
            this.bCx.setVisibility(visibility);
            this.bCw.setVisibility(visibility);
        }
    }

    public Button YJ() {
        return this.bCt;
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        if (this.bCu != null) {
            this.bCu.bUs.a(writeImagesInfo, z);
        }
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        if (this.bCu != null) {
            this.bCu.bUs.setBaobaoUris(writeImagesInfo);
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                this.bCu.afB();
            } else {
                this.bCu.afC();
            }
        }
    }

    public void h(com.baidu.tieba.tbadkCore.b.i iVar) {
        if (iVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.b.k> agF = iVar.agF();
            if (agF.size() == 1) {
                com.baidu.tieba.tbadkCore.b.k kVar = agF.get(0);
                if (kVar.agZ() < kVar.agS().size()) {
                    this.mListView.setNextPage(null);
                    return;
                } else {
                    this.mListView.setNextPage(this.bBP);
                    return;
                }
            }
            this.mListView.setNextPage(this.bBP);
        }
    }

    public boolean Fl() {
        if (this.bCu == null) {
            return false;
        }
        return this.bCu.Fl();
    }

    public boolean YK() {
        if (this.bBL == null) {
            return false;
        }
        return this.bBL.Fl();
    }

    public void YL() {
        if (com.baidu.tbadk.performanceLog.ac.zh().zi()) {
            int lastVisiblePosition = this.mListView.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.mListView.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(com.baidu.tieba.w.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.v perfLog = tbImageView.getPerfLog();
                                perfLog.dR(1001);
                                perfLog.agn = true;
                                perfLog.agm = this.bAW.aCy;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                    }
                                }
                                tbImageView.qu();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(com.baidu.tieba.w.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.v perfLog2 = headImageView.getPerfLog();
                        perfLog2.dR(1001);
                        perfLog2.agn = true;
                        perfLog2.agm = this.bAW.aCy;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                            }
                        }
                        headImageView.qu();
                    }
                }
            }
        }
    }

    public void YM() {
        if (this.bCx != null) {
            this.bCx.setVisibility(0);
            if (this.bCw != null) {
                this.bCw.setVisibility(0);
            }
        }
    }

    public void YN() {
        if (this.bCx != null) {
            this.bCx.setVisibility(8);
            if (this.bCw != null) {
                this.bCw.setVisibility(8);
            }
        }
    }
}
