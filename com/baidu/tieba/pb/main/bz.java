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
    private View.OnClickListener aFH;
    private View afz;
    private RelativeLayout aqY;
    private NoNetworkView axO;
    bh bAJ;
    private com.baidu.tieba.b.d bBm;
    private View.OnClickListener bBn;
    private PbActivity bCF;
    public final com.baidu.tieba.pb.main.b.a bCX;
    private View bCY;
    private View bDB;
    private ColumnLayout bDa;
    private TextView bDb;
    private TextView bDc;
    private HeadImageView bDd;
    private TextView bDe;
    private ImageView bDf;
    private UserIconBox bDg;
    private UserIconBox bDh;
    private ImageView bDi;
    private TextView bDj;
    private TextView bDk;
    private View bDo;
    private View bDq;
    private RelativeLayout bDr;
    private bi bDs;
    private PbListView bDz;
    private PbEditor bEe;
    private com.baidu.tbadk.editortool.w bEf;
    private View bEg;
    private View bEh;
    private LinearLayout bEi;
    private TextView bEj;
    private LinearLayout bEk;
    private ImageView bEl;
    private TextView bEm;
    private boolean bEo;
    private View bEs;
    private LiveBroadcastCard bEt;
    private View bEu;
    private TextView bEv;
    private bg bEx;
    private BdListView mListView;
    private com.baidu.adp.widget.ListView.g ww;
    private View bCZ = null;
    public FrsPraiseView bDl = null;
    private View bDm = null;
    private View bDn = null;
    private View bDp = null;
    private Dialog bDt = null;
    private Dialog bDu = null;
    private com.baidu.tieba.pb.sub.l bDv = null;
    private View bDw = null;
    private EditText bDx = null;
    private com.baidu.tbadk.core.view.am bDy = null;
    private FrameLayout aFf = null;
    private View bDA = null;
    private DialogInterface.OnClickListener bfN = null;
    private AbsListView.OnScrollListener bDC = null;
    private com.baidu.tbadk.widget.richText.s akw = null;
    private com.baidu.tbadk.core.view.ad aDL = null;
    private Dialog bDD = null;
    private Dialog bDE = null;
    private View bDF = null;
    private Button bDG = null;
    private Button bDH = null;
    private TextView bDI = null;
    private Dialog bDJ = null;
    private View bDK = null;
    private int bDL = 0;
    private RadioGroup Ac = null;
    private RadioButton bDM = null;
    private RadioButton bDN = null;
    private RadioButton bDO = null;
    private Button bDP = null;
    private Button bDQ = null;
    private TextView bDR = null;
    private Dialog bDS = null;
    private View bDT = null;
    private RadioGroup bDU = null;
    private CompoundButton.OnCheckedChangeListener bDV = null;
    private Button bDW = null;
    private Button bDX = null;
    private String bDY = null;
    private cz bDZ = null;
    private Dialog bEa = null;
    private boolean bEb = false;
    private ScrollView bEc = null;
    private Button bEd = null;
    private boolean bEn = true;
    private LinearLayout bEp = null;
    private View bEq = null;
    private PbListView bEr = null;
    private boolean bBj = false;
    private boolean mIsFromCDN = true;
    private com.baidu.tieba.tbadkCore.bubble.y aGe = new ca(this);
    private final View.OnClickListener bEw = new cj(this);
    private View.OnLongClickListener bEy = null;
    private boolean bEz = false;
    private final List<TbImageView> bEA = new ArrayList();
    private boolean bBi = true;

    public NoNetworkView Yg() {
        return this.axO;
    }

    public void Yh() {
        this.bEn = true;
        if (this.bEe != null) {
            this.bEe.setVisibility(8);
        }
        if (this.bEh != null) {
            this.bEh.setVisibility(0);
            this.bEg.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.b.k Yi() {
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
        if (this.bDs.getItemViewType(i7) != 0) {
            i7++;
        }
        return (com.baidu.tieba.tbadkCore.b.k) this.bDs.getItem(i7);
    }

    public bz(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.b.e eVar) {
        this.bCF = null;
        this.aqY = null;
        this.mListView = null;
        this.bCY = null;
        this.bDa = null;
        this.bDb = null;
        this.bDc = null;
        this.bDd = null;
        this.bDe = null;
        this.bDf = null;
        this.bDg = null;
        this.bDh = null;
        this.bDi = null;
        this.bDj = null;
        this.bDk = null;
        this.bDo = null;
        this.bDq = null;
        this.bDs = null;
        this.bDz = null;
        this.afz = null;
        this.aFH = null;
        this.bBn = null;
        this.bEg = null;
        this.bEh = null;
        this.bEi = null;
        this.bEj = null;
        this.bEk = null;
        this.bEl = null;
        this.bEm = null;
        this.bEu = null;
        this.bEv = null;
        this.bCF = pbActivity;
        this.aFH = onClickListener;
        this.bBm = new com.baidu.tieba.b.d(eVar);
        this.aqY = (RelativeLayout) com.baidu.adp.lib.g.b.ei().inflate(this.bCF.getPageContext().getPageActivity(), com.baidu.tieba.x.new_pb_activity, null);
        this.bCF.addContentView(this.aqY, new FrameLayout.LayoutParams(-1, -1));
        this.bDr = (RelativeLayout) this.bCF.findViewById(com.baidu.tieba.w.title_wrapper);
        this.axO = (NoNetworkView) this.bCF.findViewById(com.baidu.tieba.w.view_no_network);
        this.mListView = (BdListView) this.bCF.findViewById(com.baidu.tieba.w.new_pb_list);
        View view = new View(this.bCF.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.bCF.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_editor_height)));
        this.mListView.addFooterView(view);
        this.bCX = new com.baidu.tieba.pb.main.b.a(pbActivity);
        this.bCX.Zo().setOnTouchListener(new com.baidu.tieba.b.a(new cs(this)));
        this.bEh = this.bCF.findViewById(com.baidu.tieba.w.pb_editor_tool_comment);
        this.bEi = (LinearLayout) this.bCF.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_reply);
        this.bEk = (LinearLayout) this.bCF.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_praise);
        this.bEg = this.bCF.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_line);
        this.bEj = (TextView) this.bCF.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_reply_text);
        this.bEl = (ImageView) this.bCF.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_praise_icon);
        this.bEm = (TextView) this.bCF.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_praise_text);
        this.bEi.setOnClickListener(new ct(this));
        this.bEk.setOnClickListener(this.aFH);
        this.bEk.setOnTouchListener(this.bCF);
        YP();
        this.bCY = com.baidu.adp.lib.g.b.ei().inflate(this.bCF.getPageContext().getPageActivity(), com.baidu.tieba.x.new_pb_header_item, null);
        this.bDa = (ColumnLayout) this.bCY.findViewById(com.baidu.tieba.w.pb_head_owner_root);
        this.bDa.setOnLongClickListener(this.bEy);
        this.bDa.setOnTouchListener(this.bBm);
        this.bDa.setVisibility(8);
        this.bCY.setOnTouchListener(this.bBm);
        this.bDb = (TextView) this.bCY.findViewById(com.baidu.tieba.w.pb_head_post_title);
        this.bDb.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.bDb.setVisibility(8);
        this.bEu = this.bCY.findViewById(com.baidu.tieba.w.pb_head_activity_join_number_container);
        this.bEu.setVisibility(8);
        this.bEv = (TextView) this.bCY.findViewById(com.baidu.tieba.w.pb_head_activity_join_number);
        this.bDc = (TextView) this.bDa.findViewById(com.baidu.tieba.w.pb_head_owner_info_user_name);
        this.bDd = (HeadImageView) this.bDa.findViewById(com.baidu.tieba.w.pb_head_owner_photo);
        if (!this.bBi) {
            this.bDd.setVisibility(8);
        }
        this.bDe = (TextView) this.bDa.findViewById(com.baidu.tieba.w.pb_head_owner_info_user_rank);
        this.bDf = (ImageView) this.bDa.findViewById(com.baidu.tieba.w.pb_head_owner_info_user_gender);
        this.bDg = (UserIconBox) this.bDa.findViewById(com.baidu.tieba.w.pb_head_owner_info_user_icon);
        this.bDh = (UserIconBox) this.bDa.findViewById(com.baidu.tieba.w.pb_head_owner_info_tshow_icon);
        this.bDi = (ImageView) this.bDa.findViewById(com.baidu.tieba.w.pb_head_owner_info_floor_owner);
        this.bDj = (TextView) this.bDa.findViewById(com.baidu.tieba.w.pb_head_owner_info_time);
        this.bDk = (TextView) this.bCY.findViewById(com.baidu.tieba.w.pb_head_reverse_hint);
        this.bDk.setOnClickListener(this.aFH);
        this.bDk.setVisibility(8);
        this.bDo = this.bCY.findViewById(com.baidu.tieba.w.new_pb_header_item_line_below_livepost);
        this.bDq = this.bCY.findViewById(com.baidu.tieba.w.new_pb_header_item_line_above_showpassed);
        this.bCY.setOnLongClickListener(new cu(this));
        Yu();
        this.bDs = new bi(this.bCF);
        this.bDs.A(this.aFH);
        this.bDs.a(this.bBm);
        this.bDs.setOnImageClickListener(this.akw);
        this.bBn = new cv(this);
        this.bDs.z(this.bBn);
        this.mListView.setAdapter((ListAdapter) this.bDs);
        this.mListView.addHeaderView(this.bCY);
        this.bDz = new PbListView(this.bCF.getPageContext().getPageActivity());
        this.afz = this.bDz.getView().findViewById(com.baidu.tieba.w.pb_more_view);
        if (this.afz != null) {
            this.afz.setOnClickListener(this.aFH);
            com.baidu.tbadk.core.util.bc.i(this.afz, com.baidu.tieba.v.pb_foot_more_trans_selector);
        }
        this.bDz.qD();
        this.bDz.cq(com.baidu.tieba.v.pb_foot_more_trans_selector);
        this.bDz.cr(com.baidu.tieba.v.pb_foot_more_trans_selector);
        this.bDB = this.bCF.findViewById(com.baidu.tieba.w.viewstub_progress);
    }

    public PbEditor Fz() {
        return this.bEe;
    }

    public void Yj() {
        if (this.bEe != null) {
            this.aqY.removeView(this.bEe);
            this.bEe = null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void Yk() {
        if (this.bCF != null) {
            this.bEe = new PbEditor(this.bCF.getPageContext().getPageActivity());
            this.bEe.setOrientation(1);
            this.bEe.setFrom(1);
            this.bEe.aK(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.aqY.addView(this.bEe, layoutParams);
            this.bEe.b(this.bCF.getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
            Yl();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void Yl() {
        if (this.bEe != null) {
            this.bEe.a(this.bCF.getPageContext(), new cw(this));
        }
    }

    public void hA(String str) {
        if (this.bEj != null) {
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                this.bEj.setText(str);
            } else {
                this.bEj.setText(this.bCF.getPageContext().getString(com.baidu.tieba.z.reply));
            }
        }
    }

    public void d(long j, boolean z) {
        String p;
        this.bEo = z;
        if (j < 1) {
            p = this.bCF.getResources().getString(com.baidu.tieba.z.frs_item_praise_text);
        } else {
            p = com.baidu.tbadk.core.util.bf.p(j);
        }
        if (this.bEm != null) {
            this.bEm.setText(p);
            dV(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        }
    }

    private void dV(boolean z) {
        if (this.bEl != null) {
            if (this.bEo) {
                com.baidu.tbadk.core.util.bc.c(this.bEl, com.baidu.tieba.v.icon_hand_click);
            } else {
                com.baidu.tbadk.core.util.bc.c(this.bEl, com.baidu.tieba.v.icon_hand_normal);
            }
        }
    }

    public View Ym() {
        return this.bEk;
    }

    public void dW(boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
            } else {
                this.mListView.postDelayed(new cx(this, z), 10L);
            }
        }
    }

    public void O(View view) {
        boolean z;
        View view2;
        if (this.bDr != null && view != null) {
            if (this.bEn) {
                z = this.bEh.getVisibility() == 0;
            } else {
                z = this.bEe != null && this.bEe.getVisibility() == 0;
            }
            boolean z2 = this.bDr.getVisibility() == 0;
            if (z2) {
                View findViewById = this.bCF.findViewById(com.baidu.tieba.w.bg_above_list);
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.bDr.getHeight()));
                com.baidu.tieba.tbadkCore.a.a(this.bCF, this.bDr, com.baidu.tieba.q.top_fold_up, new cy(this, findViewById));
            } else {
                com.baidu.tieba.tbadkCore.a.a(this.bCF, this.bDr, com.baidu.tieba.q.top_fold_down, new cb(this));
            }
            if (this.bEn) {
                view2 = this.bEh;
            } else {
                view2 = this.bEe;
            }
            if (z) {
                if (z2) {
                    if (this.bEe != null) {
                        this.bEe.agf();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.bCF, view2, com.baidu.tieba.q.bottom_fold_down, new cc(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.bCF, view2, com.baidu.tieba.q.bottom_fold_up, new cd(this));
            }
        }
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.bEe == null) {
            return null;
        }
        return this.bEe.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.bEe != null) {
            this.bEe.setAudioData(voiceModel);
        }
    }

    public void FI() {
        if (this.bEe != null) {
            this.bEe.FI();
        }
    }

    public void Yn() {
        if (this.bDv != null) {
            this.bDv.YO();
        }
    }

    public com.baidu.tieba.pb.sub.l Yo() {
        return this.bDv;
    }

    public void Yp() {
        if (this.bDv != null) {
            this.bDv.YP();
        }
    }

    public VoiceData.VoiceModel Yq() {
        if (this.bDv != null) {
            return this.bDv.getAudioData();
        }
        return null;
    }

    public void Yr() {
        if (this.bDv != null) {
            this.bDv.FI();
        }
    }

    public TextView Ys() {
        if (this.bDv == null || !(this.bDv instanceof com.baidu.tieba.pb.sub.i)) {
            return null;
        }
        return ((com.baidu.tieba.pb.sub.i) this.bDv).ZR();
    }

    public bi Yt() {
        return this.bDs;
    }

    public void a(bh bhVar) {
        this.bAJ = bhVar;
    }

    private void a(com.baidu.tbadk.core.data.aa aaVar) {
        if (aaVar != null && aaVar.nL() != 0) {
            if (this.bEd == null) {
                this.bCF.getLayoutMode().h(((ViewStub) this.bCY.findViewById(com.baidu.tieba.w.live_talk_layout)).inflate());
                this.bEd = (Button) this.bCY.findViewById(com.baidu.tieba.w.pb_head_function_manage_go_to_live_post);
                this.bDn = this.bCY.findViewById(com.baidu.tieba.w.new_pb_header_item_line_above_livepost);
            }
            int nM = aaVar.nM();
            String string = this.bCF.getPageContext().getString(com.baidu.tieba.z.go_to_live_post_prefix);
            if (nM == 0) {
                string = String.valueOf(string) + this.bCF.getPageContext().getString(com.baidu.tieba.z.go_to_interview_post);
            } else if (nM == 1) {
                string = String.valueOf(string) + this.bCF.getPageContext().getString(com.baidu.tieba.z.go_to_discuss_post);
            }
            this.bEd.setText(string);
            this.bEd.setVisibility(0);
            this.bEd.setOnClickListener(this.aFH);
            YV();
        }
    }

    private void Yu() {
        this.bEp = (LinearLayout) this.bCY.findViewById(com.baidu.tieba.w.btn_show_passed_pb);
        this.bEr = new PbListView(this.bCF.getPageContext().getPageActivity(), PbListView.IconType.ICON_UP_WARD);
        this.bEq = this.bEr.jr();
        this.bEr.setText(this.bCF.getResources().getString(com.baidu.tieba.z.btn_show_passed_pb));
        this.bEq.setOnClickListener(this.bEw);
        this.bEp.addView(this.bEq);
        this.bEp.requestLayout();
        this.bEp.invalidate();
        com.baidu.tbadk.core.util.bc.i(this.bEq, com.baidu.tieba.t.cp_bg_line_e);
        this.bEr.cq(com.baidu.tieba.t.cp_bg_line_e);
        this.bEr.cr(com.baidu.tieba.t.cp_bg_line_e);
        YV();
    }

    public void P(View view) {
        if (this.bDD == null) {
            this.bDD = new Dialog(this.bCF.getPageContext().getPageActivity(), com.baidu.tieba.aa.common_alert_dialog);
            this.bDD.setCanceledOnTouchOutside(true);
            this.bDD.setCancelable(true);
            this.bDD.setContentView(com.baidu.adp.lib.g.b.ei().inflate(this.bCF.getPageContext().getPageActivity(), com.baidu.tieba.x.forum_manage_dialog, null));
            WindowManager.LayoutParams attributes = this.bDD.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.M(this.bCF.getPageContext().getPageActivity()) * 0.9d);
            this.bDD.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.bDD.findViewById(com.baidu.tieba.w.del_post_btn);
        Button button2 = (Button) this.bDD.findViewById(com.baidu.tieba.w.forbid_user_btn);
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
                button.setOnClickListener(new ce(this));
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
                sparseArray3.put(com.baidu.tieba.w.tag_forbid_user_post_id, sparseArray.get(com.baidu.tieba.w.tag_forbid_user_post_id));
                button2.setOnClickListener(new cf(this));
            }
            com.baidu.adp.lib.g.k.a(this.bDD, this.bCF.getPageContext());
        }
    }

    public void a(bg bgVar) {
        this.bEx = bgVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        if (this.bDE == null) {
            this.bDE = new Dialog(this.bCF.getPageContext().getPageActivity(), com.baidu.tieba.aa.common_alert_dialog);
            this.bDE.setCanceledOnTouchOutside(true);
            this.bDE.setCancelable(true);
            this.bDF = com.baidu.adp.lib.g.b.ei().inflate(this.bCF.getPageContext().getPageActivity(), com.baidu.tieba.x.del_post, null);
            this.bDE.setContentView(this.bDF);
            WindowManager.LayoutParams attributes = this.bDE.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.M(this.bCF.getPageContext().getPageActivity()) * 0.9d);
            this.bDE.getWindow().setAttributes(attributes);
            this.bDG = (Button) this.bDF.findViewById(com.baidu.tieba.w.dialog_button_ok);
            this.bDG.setOnClickListener(this.aFH);
            this.bDH = (Button) this.bDF.findViewById(com.baidu.tieba.w.dialog_button_cancel);
            this.bDH.setOnClickListener(new cg(this));
            this.bDI = (TextView) this.bDF.findViewById(com.baidu.tieba.w.confirm_text);
        }
        SparseArray sparseArray = (SparseArray) this.bDG.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.bDG.setTag(sparseArray);
        }
        sparseArray.put(com.baidu.tieba.w.tag_del_post_id, str);
        sparseArray.put(com.baidu.tieba.w.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(com.baidu.tieba.w.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(com.baidu.tieba.w.tag_del_post_is_self, Boolean.valueOf(z));
        if (i == 0) {
            this.bDI.setText(com.baidu.tieba.z.del_thread_confirm);
        } else {
            this.bDI.setText(com.baidu.tieba.z.del_post_confirm);
        }
        com.baidu.adp.lib.g.k.a(this.bDE, this.bCF.getPageContext());
    }

    public void I(ArrayList<com.baidu.tbadk.core.data.k> arrayList) {
        if (this.bDS == null) {
            this.bDS = new Dialog(this.bCF.getPageContext().getPageActivity(), com.baidu.tieba.aa.common_alert_dialog);
            this.bDS.setCanceledOnTouchOutside(true);
            this.bDS.setCancelable(true);
            this.bDT = com.baidu.adp.lib.g.b.ei().inflate(this.bCF.getPageContext().getPageActivity(), com.baidu.tieba.x.commit_good, null);
            this.bEc = (ScrollView) this.bDT.findViewById(com.baidu.tieba.w.good_scroll);
            this.bDS.setContentView(this.bDT);
            WindowManager.LayoutParams attributes = this.bDS.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.M(this.bCF.getPageContext().getPageActivity()) * 0.9d);
            this.bDS.getWindow().setAttributes(attributes);
            this.bDV = new ch(this);
            this.bDU = (RadioGroup) this.bDT.findViewById(com.baidu.tieba.w.good_class_group);
            this.bDX = (Button) this.bDT.findViewById(com.baidu.tieba.w.dialog_button_cancel);
            this.bDX.setOnClickListener(new ci(this));
            this.bDW = (Button) this.bDT.findViewById(com.baidu.tieba.w.dialog_button_ok);
            this.bDW.setOnClickListener(this.aFH);
        }
        this.bDU.removeAllViews();
        RadioButton radioButton = (RadioButton) com.baidu.adp.lib.g.b.ei().inflate(this.bCF.getPageContext().getPageActivity(), com.baidu.tieba.x.good_class_radio_button, null);
        radioButton.setTag("0");
        radioButton.setText(this.bCF.getPageContext().getString(com.baidu.tieba.z.def_good_class));
        radioButton.setOnCheckedChangeListener(this.bDV);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(com.baidu.adp.lib.util.l.dip2px(this.bCF.getPageContext().getPageActivity(), 10.0f), com.baidu.adp.lib.util.l.dip2px(this.bCF.getPageContext().getPageActivity(), 5.0f), com.baidu.adp.lib.util.l.dip2px(this.bCF.getPageContext().getPageActivity(), 10.0f), com.baidu.adp.lib.util.l.dip2px(this.bCF.getPageContext().getPageActivity(), 5.0f));
        this.bDU.addView(radioButton, layoutParams);
        this.bDU.requestLayout();
        this.bDU.check(radioButton.getId());
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                RadioButton radioButton2 = (RadioButton) com.baidu.adp.lib.g.b.ei().inflate(this.bCF.getPageContext().getPageActivity(), com.baidu.tieba.x.good_class_radio_button, null);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).mH()));
                radioButton2.setText(arrayList.get(i2).mG());
                radioButton2.setOnCheckedChangeListener(this.bDV);
                this.bDU.addView(radioButton2, layoutParams);
                this.bDU.requestLayout();
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bEc.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.bCF.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.bCF.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.bCF.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.bEc.setLayoutParams(layoutParams2);
            this.bEc.removeAllViews();
            this.bEc.addView(this.bDU);
        }
        com.baidu.adp.lib.g.k.a(this.bDS, this.bCF.getPageContext());
    }

    public void Yv() {
        this.bCF.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.bCF.hideProgressBar();
        if (z && z2) {
            this.bCF.showToast(this.bCF.getPageContext().getString(com.baidu.tieba.z.success));
        } else if (str != null && z2) {
            this.bCF.showToast(str);
        }
    }

    public void He() {
        this.aqY.removeView(this.aFf);
    }

    public void Qj() {
        this.bDB.setVisibility(0);
    }

    public void Qi() {
        this.bDB.setVisibility(8);
    }

    public View Yw() {
        if (this.bDF != null) {
            return this.bDF.findViewById(com.baidu.tieba.w.dialog_button_ok);
        }
        return null;
    }

    public View Yx() {
        if (this.bDT != null) {
            return this.bDT.findViewById(com.baidu.tieba.w.dialog_button_ok);
        }
        return null;
    }

    public String Yy() {
        return this.bDY;
    }

    public View Yz() {
        if (this.bDv != null) {
            return this.bDv.aag();
        }
        return null;
    }

    public View getView() {
        return this.aqY;
    }

    public void YA() {
        View editText;
        if (this.bEe == null) {
            editText = this.bCF.getCurrentFocus();
        } else {
            editText = this.bEe.getEditText();
        }
        com.baidu.adp.lib.util.l.c(this.bCF.getPageContext().getPageActivity(), editText);
    }

    public void FF() {
        if (this.bDv != null) {
            this.bDv.aai();
        } else {
            this.bCF.showProgressBar();
        }
    }

    public void bG(boolean z) {
        if (this.bDv != null) {
            this.bDv.aaj();
        } else {
            this.bCF.hideProgressBar();
        }
        Ze();
        if (z) {
            if (this.bEe != null) {
                this.bEe.getEditText().setText("");
                this.bEe.agb();
                this.bEe.clearData();
            }
            if (this.bDv != null) {
                this.bDv.clearContent();
            }
        }
    }

    public void YB() {
        this.bDz.startLoadData();
    }

    public void YC() {
    }

    public void YD() {
        this.bCF.hideProgressBar();
        this.bDz.qE();
        this.bEr.qE();
        this.mListView.jB();
        YV();
    }

    public void YE() {
        this.mListView.jB();
        this.bEp.setVisibility(8);
        YV();
    }

    public void dX(boolean z) {
        if (!z) {
            if (this.bEe != null) {
                this.bEe.agd();
            }
        } else if (this.bDv != null) {
            this.bDv.hG(null);
        }
    }

    public void YF() {
        if (YJ() && this.bDv != null) {
            this.bDv.ZZ();
        }
    }

    public void YG() {
        if (this.bDv == null) {
            this.bDv = new com.baidu.tieba.pb.sub.l(this.bCF, this.bEz, this.aFH, this.bBn, this.bCF.bAx.bEO, this.bCF.bAx.bEP, this.bCF.bAx.bEQ);
            this.bDv.setOnActionListener(this.bEf);
            this.bDv.setOnScrollListener(this.bDC);
            this.bDv.dO(this.bDs.Xy());
            this.bDv.dP(this.bDs.Xz());
            this.bDA = this.bDv.getRootView();
            this.bDv.setOnImageClickListener(this.akw);
            this.bDv.setOnEmotionClickListener(this.bCF.bAx.bER);
            this.bDv.setOnLongClickListener(this.bDs.Xx());
        }
        this.bDA.setVisibility(0);
        this.bDv.eg(this.mIsFromCDN);
        this.bDv.YA();
        this.aqY.addView(this.bDA);
        Zh();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.bEf = wVar;
            if (this.bEe != null) {
                Yl();
            }
            if (this.bDv != null) {
                this.bDv.setOnActionListener(wVar);
            }
        }
    }

    public void a(cz czVar) {
        this.bDZ = czVar;
    }

    public void a(boolean z, com.baidu.tieba.tbadkCore.b.o oVar, boolean z2, String str, String str2, View view, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        if (oVar != null && view != null) {
            TiebaStatic.eventStat(this.bCF.getPageContext().getPageActivity(), "pb_tosubpb", "pbclick", 1, new Object[0]);
            if (this.bDv == null) {
                this.bDv = new com.baidu.tieba.pb.sub.l(this.bCF, this.bEz, this.aFH, this.bBn, this.bCF.bAx.bEO, this.bCF.bAx.bEP, this.bCF.bAx.bEQ);
                this.bDv.setOnActionListener(this.bEf);
                this.bDv.setOnScrollListener(this.bDC);
                this.bDv.dO(this.bDs.Xy());
                this.bDv.dP(this.bDs.Xz());
                this.bDA = this.bDv.getRootView();
                this.bDv.setOnImageClickListener(this.akw);
                this.bDv.setOnEmotionClickListener(this.bCF.bAx.bER);
                this.bDv.setOnLongClickListener(this.bDs.Xx());
            }
            this.bDv.hi(this.bDs.getWidth());
            this.bDv.a(oVar, i);
            this.bDv.eg(this.mIsFromCDN);
            if (str2 != null && !str2.equals("")) {
                this.bDv.hI(str2);
            } else {
                this.bDv.setPosition(1);
            }
            int i2 = 0;
            if (this.bDr.getVisibility() == 0) {
                i2 = this.bDr.getHeight();
            }
            int top = view.getTop() + i2;
            int bottom = view.getBottom() + i2;
            if (!z) {
                this.bDv.aac();
            }
            int height = ((view.getHeight() + this.bCF.getResources().getDimensionPixelSize(com.baidu.tieba.u.subpb_listitem_packup_min_height)) - this.bCF.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_list_item_border_bottom_margin_top)) - this.aqY.getHeight();
            if (height > 0) {
                top += height;
            }
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, top, 0.0f);
            translateAnimation.setDuration(300L);
            this.bDA.setAnimation(translateAnimation);
            try {
                this.aqY.invalidate();
                this.aqY.buildDrawingCache();
                bitmap = this.aqY.getDrawingCache();
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
            this.bDA.setVisibility(0);
            if (this.bDA.getParent() == this.aqY) {
                this.aqY.removeView(this.bDA);
            }
            this.aqY.addView(this.bDA, new RelativeLayout.LayoutParams(-1, -1));
            if (bitmap2 != null) {
                ImageView imageView = new ImageView(this.bCF.getPageContext().getPageActivity());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(10);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageBitmap(bitmap2);
                this.aqY.addView(imageView);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -top);
                translateAnimation2.setDuration(300L);
                imageView.setAnimation(translateAnimation2);
                translateAnimation2.setAnimationListener(new ck(this, imageView));
                translateAnimation2.setInterpolator(accelerateInterpolator);
                translateAnimation2.start();
            }
            translateAnimation.setAnimationListener(new cm(this, oVar, z, str, str2));
            translateAnimation.setInterpolator(accelerateInterpolator);
            if (bitmap3 != null) {
                ImageView imageView2 = new ImageView(this.bCF.getPageContext().getPageActivity());
                imageView2.setImageBitmap(bitmap3);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(12);
                imageView2.setLayoutParams(layoutParams2);
                this.aqY.addView(imageView2);
                TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, 0.0f, bitmap3 == null ? 0 : bitmap3.getHeight());
                translateAnimation3.setDuration(300L);
                imageView2.setAnimation(translateAnimation3);
                translateAnimation3.setAnimationListener(new co(this, imageView2));
                translateAnimation3.setInterpolator(accelerateInterpolator);
                translateAnimation3.start();
            }
            translateAnimation.start();
        }
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.bEy = onLongClickListener;
        this.bDs.setOnLongClickListener(onLongClickListener);
        if (this.bDv != null) {
            this.bDv.setOnLongClickListener(onLongClickListener);
        }
    }

    public void YH() {
        if (YJ()) {
            this.bDv.aad();
        }
    }

    public void YI() {
        if (YJ() && (this.bDv instanceof com.baidu.tieba.pb.sub.i)) {
            ((com.baidu.tieba.pb.sub.i) this.bDv).ZU();
        }
    }

    public boolean YJ() {
        return (this.bDA == null || this.bDA.getVisibility() == 8) ? false : true;
    }

    public void YK() {
        if (this.bDA != null) {
            this.bDA.setVisibility(8);
            this.aqY.removeView(this.bDA);
            this.bDv.IK();
        }
        Ze();
        Zi();
    }

    public void YL() {
        if (this.bDA != null) {
            if (this.aqY != null) {
                this.aqY.removeView(this.bDA);
            }
            this.bDA = null;
        }
        if (this.bDv != null) {
            this.bDv.IK();
            this.bDv = null;
        }
    }

    public void YM() {
        if (this.bDv != null) {
            this.bDv.aak();
            if (this.bDv instanceof com.baidu.tieba.pb.sub.i) {
                ((com.baidu.tieba.pb.sub.i) this.bDv).ZV();
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.b.o oVar, int i) {
        if (this.bDv != null) {
            this.bDv.aak();
            this.bDv.hi(this.bDs.getWidth());
            this.bDv.a(oVar, i);
        }
    }

    public void YN() {
        if (this.bDv == null) {
            this.bDv = new com.baidu.tieba.pb.sub.i(this.bCF, this.bEz, this.aFH, this.bBn, this.bCF.bAx.bEO, this.bCF.bAx.bEP, this.bCF.bAx.bEQ);
            this.bDv.setOnActionListener(this.bEf);
            this.bDv.setOnScrollListener(this.bDC);
            this.bDv.dO(this.bDs.Xy());
            this.bDv.dP(this.bDs.Xz());
            this.bDA = this.bDv.getRootView();
            this.bDv.setOnImageClickListener(this.akw);
            this.bDv.setOnEmotionClickListener(this.bCF.bAx.bER);
            this.bDv.setOnLongClickListener(this.bDs.Xx());
        }
        this.bDA.setVisibility(0);
        this.bDv.YA();
        this.aqY.addView(this.bDA);
        Zh();
    }

    public void a(com.baidu.tieba.tbadkCore.b.o oVar, int i, String str, boolean z, boolean z2) {
        if (this.bDv != null && (this.bDv instanceof com.baidu.tieba.pb.sub.i)) {
            com.baidu.tieba.pb.sub.i iVar = (com.baidu.tieba.pb.sub.i) this.bDv;
            this.bDv.aak();
            this.bDv.hi(this.bDs.getWidth());
            this.bDv.a(oVar, i);
            if (z2) {
                iVar.hF(str);
            }
            if (!z) {
                iVar.ZW();
            } else {
                iVar.ZX();
            }
        }
    }

    public void A(ArrayList<String> arrayList) {
        if (this.bEe != null) {
            this.bEe.A(arrayList);
        }
    }

    public void J(ArrayList<String> arrayList) {
        if (this.bDv != null) {
            this.bDv.A(arrayList);
        }
    }

    public void YO() {
        this.bEz = true;
        if (this.bEe != null) {
            this.bEe.YO();
        }
    }

    public void YP() {
        this.bEz = false;
        if (this.bEe != null) {
            this.bEe.YP();
        }
    }

    public void a(DialogInterface.OnClickListener onClickListener, boolean z, boolean z2) {
        if (this.bEa != null) {
            com.baidu.adp.lib.g.k.b(this.bEa, this.bCF.getPageContext());
            this.bEa = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.bCF.getPageContext().getPageActivity());
        builder.setTitle(com.baidu.tieba.z.operation);
        if (z2) {
            builder.setItems(new String[]{this.bCF.getPageContext().getString(com.baidu.tieba.z.copy)}, onClickListener);
        } else if (!z) {
            builder.setItems(new String[]{this.bCF.getPageContext().getString(com.baidu.tieba.z.copy), this.bCF.getPageContext().getString(com.baidu.tieba.z.mark)}, onClickListener);
        } else {
            builder.setItems(new String[]{this.bCF.getPageContext().getString(com.baidu.tieba.z.copy), this.bCF.getPageContext().getString(com.baidu.tieba.z.remove_mark)}, onClickListener);
        }
        this.bEa = builder.create();
        this.bEa.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.bEa, this.bCF.getPageContext());
    }

    public void setAudioFocusable(boolean z) {
        if (this.bEe != null) {
            this.bEe.setAudioFocusable(z);
        }
    }

    public void dY(boolean z) {
        if (this.bDv != null) {
            this.bDv.setAudioFocusable(z);
        }
    }

    public void j(Bitmap bitmap) {
        if (this.bEe != null) {
            this.bEe.j(bitmap);
            this.bEe.aga();
        }
    }

    public void YQ() {
        if (this.bEe != null) {
            this.bEe.j(null);
        }
    }

    public int YR() {
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
            return Integer.parseInt(this.bDx.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public String FG() {
        return this.bEe == null ? "" : this.bEe.getContent();
    }

    public void fz(String str) {
        if (this.bEe != null) {
            this.bEe.setContent(str);
        }
    }

    public String YS() {
        if (this.bDv == null) {
            return null;
        }
        return this.bDv.aah();
    }

    public String YT() {
        if (this.bDv != null) {
            return this.bDv.aae();
        }
        return null;
    }

    public String YU() {
        if (this.bDv != null) {
            return this.bDv.aaa();
        }
        return null;
    }

    public void e(com.baidu.tieba.tbadkCore.b.i iVar) {
        this.bDs.b(iVar);
        this.bDs.notifyDataSetChanged();
        if (iVar == null) {
            hA("");
        } else {
            hA(com.baidu.tbadk.core.util.bf.p(iVar.ahe().getReply_num()));
        }
        YV();
    }

    public void f(com.baidu.tieba.tbadkCore.b.i iVar) {
        PraiseData praise;
        if (this.bDl == null) {
            this.bCF.getLayoutMode().h(((ViewStub) this.bCY.findViewById(com.baidu.tieba.w.praise_layout)).inflate());
            this.bDl = (FrsPraiseView) this.bCY.findViewById(com.baidu.tieba.w.pb_head_praise_view);
            this.bDl.setIsFromPb(true);
            this.bDp = this.bCY.findViewById(com.baidu.tieba.w.new_pb_header_item_line_above_praise);
            this.bDl.ct(TbadkCoreApplication.m255getInst().getSkinType());
        }
        if (this.bDl != null) {
            boolean YV = YV();
            if (iVar != null && iVar.ahf() != null && iVar.ahf().size() > 0) {
                com.baidu.tieba.tbadkCore.b.k kVar = iVar.ahf().get(0);
                if ((!this.bBj || kVar.aht() != 1) && (praise = iVar.ahe().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.bDl.setVisibility(0);
                    this.bDl.setIsFromPb(true);
                    this.bDl.a(praise, iVar.ahe().getId(), praise.getPostId(), true);
                    this.bDp.setVisibility(0);
                    if (this.bDl.getVisibility() == 0) {
                        this.bDq.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.bDl.setVisibility(8);
            this.bDp.setVisibility(8);
            if (iVar != null && iVar.mT() != null && iVar.mT().mS() == 0 && this.bBj) {
                this.bDp.setVisibility(8);
                if (YV) {
                    this.bDo.setVisibility(0);
                    return;
                } else {
                    this.bDo.setVisibility(8);
                    return;
                }
            }
            this.bDp.setVisibility(0);
            this.bDo.setVisibility(8);
        }
    }

    private com.baidu.tieba.tbadkCore.b.k a(com.baidu.tieba.tbadkCore.b.i iVar, boolean z, int i) {
        if (z) {
            if (iVar == null || iVar.ahf() == null || iVar.ahf().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.b.k kVar = iVar.ahf().get(0);
            if (kVar.aht() != 1) {
                return g(iVar);
            }
            return kVar;
        }
        return g(iVar);
    }

    private com.baidu.tieba.tbadkCore.b.k g(com.baidu.tieba.tbadkCore.b.i iVar) {
        MetaData metaData;
        if (iVar == null || iVar.ahe() == null || iVar.ahe().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.b.k kVar = new com.baidu.tieba.tbadkCore.b.k();
        MetaData author = iVar.ahe().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = iVar.ahe().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        kVar.hX(1);
        kVar.setId(iVar.ahe().ny());
        kVar.setTitle(iVar.ahe().getTitle());
        kVar.setTime(iVar.ahe().getCreateTime());
        kVar.a(metaData);
        return kVar;
    }

    private void b(com.baidu.tieba.tbadkCore.b.i iVar, boolean z, int i) {
        this.bDa.setVisibility(8);
        com.baidu.tieba.tbadkCore.b.k a = a(iVar, z, i);
        if (a != null) {
            if (z) {
                this.bDk.setVisibility(8);
            } else {
                this.bDk.setVisibility(0);
            }
            this.bDa.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.bDa.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.bDa.setTag(sparseArray);
            }
            sparseArray.put(com.baidu.tieba.w.tag_clip_board, a);
            sparseArray.put(com.baidu.tieba.w.tag_is_subpb, false);
            this.bDj.setText(com.baidu.tbadk.core.util.bf.n(a.getTime()));
            iVar.ahe().nE();
            this.bDb.setVisibility(0);
            this.bDb.setText(iVar.ahe().getSpan_str());
            f(iVar);
            ArrayList<com.baidu.tbadk.core.data.b> nt = iVar.ahe().nt();
            if (nt != null && nt.size() > 0) {
                this.bEv.setText(String.valueOf(nt.get(0).mm()));
                this.bEu.setVisibility(0);
            } else {
                this.bEu.setVisibility(8);
            }
            com.baidu.tbadk.core.util.bc.i(this.bEu, com.baidu.tieba.v.activity_join_num_bg);
            com.baidu.tbadk.core.util.bc.b(this.bEv, com.baidu.tieba.t.cp_link_tip_d, 1);
            boolean appResponseToIntentClass = TbadkCoreApplication.m255getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
            if (iVar.ahe().getAnchorInfoData().getGroup_id() != 0 && appResponseToIntentClass) {
                if (this.bEs == null) {
                    BdLog.e("pb time   liveCardLayout new");
                    this.bEs = ((ViewStub) this.bCY.findViewById(com.baidu.tieba.w.live_card_layout)).inflate();
                    this.bCF.getLayoutMode().h(this.bEs);
                    this.bEt = (LiveBroadcastCard) this.bCY.findViewById(com.baidu.tieba.w.item_card);
                }
                this.bEs.setVisibility(0);
                LiveCardData liveCardData = new LiveCardData();
                liveCardData.setPublisherId(iVar.ahe().getAnchorInfoData().getAuthorId());
                liveCardData.setPublisherName(iVar.ahe().getAnchorInfoData().getAuthorName());
                liveCardData.setPublisherPortrait(iVar.ahe().getAnchorInfoData().getPublisherPortrait());
                liveCardData.setGroupId(iVar.ahe().getAnchorInfoData().getGroup_id());
                liveCardData.setIntro(iVar.ahe().getAnchorInfoData().getIntro());
                liveCardData.setLikers(iVar.ahe().getAnchorInfoData().getLikers());
                liveCardData.setListeners(iVar.ahe().getAnchorInfoData().getListeners());
                liveCardData.setName(iVar.ahe().getAnchorInfoData().getName());
                liveCardData.setPortrait(iVar.ahe().getAnchorInfoData().getPortrait());
                liveCardData.setStatus(iVar.ahe().getAnchorInfoData().getStatus());
                liveCardData.setStartTime(iVar.ahe().getAnchorInfoData().getStartTime());
                this.bEt.setData(liveCardData);
                this.bEt.setStatisticsKey("notice_pb_live");
            } else if (this.bEs != null) {
                this.bEs.setVisibility(8);
            }
            String userId = iVar.ahe().getAuthor().getUserId();
            if (userId != null && !userId.equals("0") && userId.equals(a.getAuthor().getUserId())) {
                this.bDi.setVisibility(0);
            } else {
                this.bDi.setVisibility(8);
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.bDe.setVisibility(0);
                    this.bDe.setText(String.valueOf(level_id));
                    com.baidu.tbadk.core.util.bc.i((View) this.bDe, com.baidu.tbadk.core.util.d.bP(level_id));
                    i2 = 2;
                    this.bDe.setOnClickListener(null);
                } else {
                    this.bDe.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.bDe.setText((CharSequence) null);
                        com.baidu.tbadk.core.util.bc.i((View) this.bDe, com.baidu.tieba.v.pb_manager);
                        this.bDe.setOnClickListener(this.bCF.bAx.bEP);
                    } else if (bawu_type.equals("assist")) {
                        this.bDe.setText((CharSequence) null);
                        com.baidu.tbadk.core.util.bc.i((View) this.bDe, com.baidu.tieba.v.pb_assist);
                        this.bDe.setOnClickListener(this.bCF.bAx.bEP);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.bc.c(this.bDf, com.baidu.tieba.v.icon_pop_girl_square);
                    this.bDf.setVisibility(0);
                } else {
                    this.bDf.setVisibility(8);
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfo = a.getAuthor().getTShowInfo();
                if (this.bDg != null) {
                    this.bDg.setOnClickListener(this.bCF.bAx.bEP);
                    this.bDg.a(iconInfo, i2, this.bCF.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_width), this.bCF.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_height), this.bCF.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_margin));
                }
                if (this.bDh != null) {
                    this.bDh.setOnClickListener(this.bCF.bAx.bEQ);
                    this.bDh.a(tShowInfo, 3, this.bCF.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_width), this.bCF.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_height), this.bCF.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_margin), true);
                }
                this.bDc.setText(a.getAuthor().getName_show());
                this.bDc.setTag(com.baidu.tieba.w.tag_user_id, a.getAuthor().getUserId());
                this.bDc.setTag(com.baidu.tieba.w.tag_user_name, a.getAuthor().getName_show());
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.bc.b(this.bDc, com.baidu.tieba.t.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.bc.b(this.bDc, com.baidu.tieba.t.cp_cont_f, 1);
                }
                if (!this.bBi) {
                    this.bDd.setVisibility(8);
                }
                this.bDd.setUserId(a.getAuthor().getUserId());
                this.bDd.setUserName(a.getAuthor().getUserName());
                this.bDd.setImageDrawable(null);
                this.bDd.setTag(a.getAuthor().getUserId());
                this.bDc.setOnClickListener(this.bCF.bAx.bEO);
                this.bDd.setOnClickListener(this.bCF.bAx.bEO);
                this.bDd.d(a.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.b.i iVar, int i, int i2, boolean z, int i3) {
        Parcelable Ya;
        Parcelable Ya2;
        this.bBj = z;
        YD();
        b(iVar, z, i);
        this.bDs.dN(this.bBj);
        this.bDs.b(iVar);
        this.bDs.notifyDataSetChanged();
        this.bCX.hB(iVar.aeI().getName());
        if (iVar.ahe() != null) {
            hA(com.baidu.tbadk.core.util.bf.p(iVar.ahe().getReply_num()));
            if (iVar.ahe().getPraise() != null) {
                d(iVar.ahe().getPraise().getNum(), iVar.ahe().getPraise().getIsLike() == 1);
            }
        }
        if (iVar.mT().mR() == 0 && !z) {
            this.mListView.setNextPage(null);
        } else {
            this.mListView.setNextPage(this.bDz);
            this.bEr.qE();
        }
        if (iVar.mT().mS() == 0 && z) {
            this.mListView.setPullRefresh(null);
            this.bEp.setVisibility(8);
        } else {
            if (this.bDy == null) {
                this.bDy = new com.baidu.tbadk.core.view.am(this.bCF.getPageContext());
                this.bDy.jr();
                this.bDy.a(this.ww);
            }
            this.mListView.setPullRefresh(this.bDy);
            if (this.bDy != null) {
                this.bDy.cs(TbadkCoreApplication.m255getInst().getSkinType());
            }
            this.bEp.setVisibility(0);
            this.bEr.qE();
        }
        YV();
        if (iVar.mT().mR() == 0) {
            this.bDz.setText(this.bCF.getResources().getString(com.baidu.tieba.z.no_more_to_load));
            h(iVar);
        } else {
            this.bDz.setText(this.bCF.getResources().getString(com.baidu.tieba.z.pb_load_more));
        }
        if (z) {
            this.bEr.setText(this.bCF.getResources().getString(com.baidu.tieba.z.btn_show_passed_pb));
        } else {
            this.bEr.setText(this.bCF.getResources().getString(com.baidu.tieba.z.btn_show_passed_pb_aftre));
        }
        if (iVar.ahe() != null && iVar.ahe().getAuthor() != null && iVar.ahe().getAuthor().getType() == 0) {
            this.bCX.Zp();
        }
        switch (i) {
            case 2:
                this.mListView.setSelection(i2);
                if (this.bCZ != null) {
                    CompatibleUtile.scrollListViewBy(this.mListView, -this.bCZ.getHeight(), 0);
                    return;
                }
                return;
            case 3:
                if (i3 == 1 && (Ya2 = bv.XZ().Ya()) != null) {
                    this.mListView.onRestoreInstanceState(Ya2);
                    return;
                } else {
                    this.mListView.setSelection(0);
                    return;
                }
            case 4:
                if (z) {
                    this.mListView.setSelection(0);
                    return;
                } else if (iVar.ahf() != null) {
                    if (iVar.mT() != null && iVar.mT().mS() != 0) {
                        this.mListView.setSelection(iVar.ahf().size() + 1);
                        return;
                    } else {
                        this.mListView.setSelection(iVar.ahf().size());
                        return;
                    }
                } else {
                    return;
                }
            case 5:
                this.mListView.setSelection(0);
                return;
            case 6:
                if (i3 == 1 && (Ya = bv.XZ().Ya()) != null) {
                    this.mListView.onRestoreInstanceState(Ya);
                    return;
                } else if (z) {
                    this.mListView.setSelection(0);
                    return;
                } else if (iVar.ahf() != null) {
                    if (iVar.mT() != null && iVar.mT().mS() != 0) {
                        this.mListView.setSelection(iVar.ahf().size() + 1);
                        return;
                    } else {
                        this.mListView.setSelection(iVar.ahf().size());
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void dZ(boolean z) {
        this.bEb = z;
        this.bCX.dZ(z);
    }

    public void qE() {
        if (this.bDz != null) {
            this.bDz.qE();
        }
        if (this.bEr != null) {
            this.bEr.qE();
        }
    }

    public void GM() {
        this.mListView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean YV() {
        boolean z;
        boolean z2 = true;
        if (this.bCZ != null && this.bCZ.getVisibility() == 0) {
            if (this.bDm != null) {
                this.bDm.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.bDm != null) {
                this.bDm.setVisibility(8);
            }
            z = false;
        }
        if (this.bEd != null && this.bEd.getVisibility() == 0) {
            if (this.bDn != null) {
                this.bDn.setVisibility(0);
            }
        } else {
            if (this.bDn != null) {
                this.bDn.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.bDp == null || this.bDp.getVisibility() == 8) && z2 && this.bBj) {
            this.bDo.setVisibility(0);
        } else {
            this.bDo.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.tbadkCore.b.i iVar, boolean z, boolean z2) {
        if (iVar == null) {
            return false;
        }
        if (this.bDb != null) {
            if (iVar.ahe().nv() == 0) {
                this.bDb.setVisibility(0);
                iVar.ahe().nE();
                this.bDb.setText(iVar.ahe().getSpan_str());
            } else {
                this.bDb.setVisibility(8);
            }
        }
        if (z) {
            if (this.bEs != null) {
                this.bEs.findViewById(com.baidu.tieba.w.pb_head_live_blank).setVisibility(8);
            }
        } else if (this.bEs != null) {
            this.bEs.findViewById(com.baidu.tieba.w.pb_head_live_blank).setVisibility(0);
        }
        this.bBj = z;
        com.baidu.tbadk.core.data.x ahe = iVar.ahe();
        if (ahe != null) {
            a(ahe.nm());
        }
        if (iVar.ahg() == 1) {
            YW();
            Button button = (Button) this.bCY.findViewById(com.baidu.tieba.w.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.bCY.findViewById(com.baidu.tieba.w.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.bCY.findViewById(com.baidu.tieba.w.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.bCY.findViewById(com.baidu.tieba.w.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.aFH);
            button2.setOnClickListener(this.aFH);
            button3.setOnClickListener(this.aFH);
            button4.setOnClickListener(this.aFH);
            if (iVar.ahe().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (iVar.ahe().getIs_top() == 1) {
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

    private void YW() {
        if (this.bCZ == null) {
            this.bCZ = ((ViewStub) this.bCY.findViewById(com.baidu.tieba.w.pb_header_function_manage)).inflate();
            this.bCF.getLayoutMode().h(this.bCZ);
            this.bDm = this.bCY.findViewById(com.baidu.tieba.w.new_pb_header_item_line_above_manage);
            return;
        }
        this.bCZ.setVisibility(0);
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
                if (iVar.ahg() != 0 && a.getAuthor() != null) {
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
                    String userId3 = iVar.ahe().getAuthor().getUserId();
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
                        sparseArray.put(com.baidu.tieba.w.tag_forbid_user_post_id, a.getId());
                    }
                    sparseArray.put(com.baidu.tieba.w.tag_del_post_id, a.getId());
                    sparseArray.put(com.baidu.tieba.w.tag_del_post_type, 0);
                    sparseArray.put(com.baidu.tieba.w.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray.put(com.baidu.tieba.w.tag_manage_user_identity, Integer.valueOf(iVar.ahg()));
                    sparseArray.put(com.baidu.tieba.w.tag_should_manage_visible, true);
                    a(com.baidu.tieba.z.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(com.baidu.tieba.w.tag_del_post_id, a.getId());
                    sparseArray2.put(com.baidu.tieba.w.tag_del_post_type, 0);
                    sparseArray2.put(com.baidu.tieba.w.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(com.baidu.tieba.w.tag_manage_user_identity, Integer.valueOf(iVar.ahg()));
                    sparseArray2.put(com.baidu.tieba.w.tag_should_manage_visible, false);
                    a(com.baidu.tieba.z.delete, sparseArray2);
                }
            }
            YV();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        YW();
        Button button = (Button) this.bCY.findViewById(com.baidu.tieba.w.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.aFH);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.afz;
    }

    public BdListView getListView() {
        return this.mListView;
    }

    public int YX() {
        return com.baidu.tieba.w.richText;
    }

    public int Fh() {
        return com.baidu.tieba.w.user_icon_box;
    }

    public Button YY() {
        return (Button) this.bCY.findViewById(com.baidu.tieba.w.pb_head_function_manage_commit_good);
    }

    public Button YZ() {
        return (Button) this.bCY.findViewById(com.baidu.tieba.w.pb_head_function_manage_cancel_good);
    }

    public Button Za() {
        return (Button) this.bCY.findViewById(com.baidu.tieba.w.pb_head_function_manage_commit_top);
    }

    public Button Zb() {
        return (Button) this.bCY.findViewById(com.baidu.tieba.w.pb_head_function_manage_cancel_top);
    }

    public View Zc() {
        if (this.bDv == null) {
            return null;
        }
        return this.bDv.aaf();
    }

    public void c(com.baidu.adp.widget.ListView.ab abVar) {
        this.mListView.setOnSrollToBottomListener(abVar);
    }

    public void a(com.baidu.adp.widget.ListView.ae aeVar) {
        this.mListView.setOnSrollToTopListener(aeVar);
    }

    public void c(DialogInterface.OnClickListener onClickListener) {
        this.bfN = onClickListener;
    }

    public void a(com.baidu.adp.widget.ListView.g gVar) {
        this.ww = gVar;
        if (this.bDy != null) {
            this.bDy.a(gVar);
        }
    }

    public void b(com.baidu.tbadk.core.data.q qVar) {
        if (qVar != null) {
            int mP = qVar.mP();
            int mN = qVar.mN();
            if (this.bDt == null) {
                this.bDt = new Dialog(this.bCF.getPageContext().getPageActivity(), com.baidu.tieba.aa.common_alert_dialog);
                this.bDt.setCanceledOnTouchOutside(true);
                this.bDt.setCancelable(true);
                this.bDw = com.baidu.adp.lib.g.b.ei().inflate(this.bCF.getPageContext().getPageActivity(), com.baidu.tieba.x.dialog_direct_pager, null);
                this.bDt.setContentView(this.bDw);
                WindowManager.LayoutParams attributes = this.bDt.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = com.baidu.adp.lib.util.l.dip2px(this.bCF.getPageContext().getPageActivity(), 54.0f);
                attributes.width = (int) (com.baidu.adp.lib.util.l.M(this.bCF.getPageContext().getPageActivity()) * 0.9d);
                this.bDt.getWindow().setAttributes(attributes);
                this.bDt.setOnKeyListener(new cq(this));
            }
            com.baidu.adp.lib.g.k.a(this.bDt, this.bCF.getPageContext());
            ((Button) this.bDw.findViewById(com.baidu.tieba.w.dialog_button_ok)).setOnClickListener(this.aFH);
            ((Button) this.bDw.findViewById(com.baidu.tieba.w.dialog_button_cancel)).setOnClickListener(this.aFH);
            this.bDx = (EditText) this.bDw.findViewById(com.baidu.tieba.w.input_page_number);
            this.bDx.setText("");
            this.bDx.setOnFocusChangeListener(new cr(this));
            TextView textView = (TextView) this.bDw.findViewById(com.baidu.tieba.w.current_page_number);
            if (mP <= 0) {
                mP = 1;
            }
            textView.setText(MessageFormat.format(this.bCF.getApplicationContext().getResources().getString(com.baidu.tieba.z.current_page), Integer.valueOf(mP), Integer.valueOf(mN <= 0 ? 1 : mN)));
            this.bCF.ShowSoftKeyPadDelay(this.bDx, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.bDC = onScrollListener;
    }

    public void showToast(String str) {
        this.bCF.showToast(str);
    }

    public boolean ea(boolean z) {
        if (this.bDv == null || !this.bDv.ZP()) {
            if (!z) {
                if (YJ()) {
                    YK();
                    return true;
                } else if (this.bEe != null && this.bEe.afI()) {
                    this.bEe.agg();
                    return true;
                }
            } else if (YJ()) {
                YK();
                return true;
            }
            return false;
        }
        return true;
    }

    public void Zd() {
        if (this.bEA != null) {
            while (this.bEA.size() > 0) {
                TbImageView remove = this.bEA.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        Zd();
    }

    public void onDestroy() {
        this.bCF.hideProgressBar();
        if (this.axO != null && this.aDL != null) {
            this.axO.b(this.aDL);
        }
        Ze();
        this.bDz.qE();
    }

    public void Ze() {
        this.bCX.Zq();
        com.baidu.adp.lib.util.l.c(this.bCF.getPageContext().getPageActivity(), this.bDx);
        if (this.bEe != null) {
            this.bEe.age();
        }
        if (this.bDt != null) {
            com.baidu.adp.lib.g.k.b(this.bDt, this.bCF.getPageContext());
        }
        if (this.bEa != null) {
            com.baidu.adp.lib.g.k.b(this.bEa, this.bCF.getPageContext());
        }
        if (this.bDv != null) {
            this.bDv.aac();
        }
        Zf();
    }

    public void dO(boolean z) {
        this.bDs.dO(z);
        if (this.bDv != null) {
            this.bDv.dO(z);
        }
    }

    public void dP(boolean z) {
        this.bBi = z;
        this.bDs.dP(z);
        if (this.bDv != null) {
            this.bDv.dP(z);
        }
    }

    public void Zf() {
        if (this.bDE != null) {
            com.baidu.adp.lib.g.k.b(this.bDE, this.bCF.getPageContext());
        }
        if (this.bDJ != null) {
            com.baidu.adp.lib.g.k.b(this.bDJ, this.bCF.getPageContext());
        }
        if (this.bDS != null) {
            com.baidu.adp.lib.g.k.b(this.bDS, this.bCF.getPageContext());
        }
        if (this.bDD != null) {
            com.baidu.adp.lib.g.k.b(this.bDD, this.bCF.getPageContext());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: com.baidu.tieba.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.bCF.getLayoutMode().ab(i == 1);
        this.bCF.getLayoutMode().h(this.aqY);
        this.bCF.getLayoutMode().h(this.bCY);
        this.bCF.getLayoutMode().h(this.afz);
        this.bCX.mNavigationBar.onChangeSkinType(this.bCF.getPageContext(), i);
        dZ(this.bEb);
        this.bDs.notifyDataSetChanged();
        if (this.bDv != null) {
            this.bDv.onChangeSkinType(i);
            this.bCF.getLayoutMode().h(this.bDz.getView());
        }
        if (this.bDy != null) {
            this.bDy.cs(i);
        }
        if (this.bDz != null) {
            this.bDz.cs(i);
            com.baidu.tbadk.core.util.bc.i(this.afz, com.baidu.tieba.v.pb_foot_more_trans_selector);
            this.bDz.cq(com.baidu.tieba.v.pb_foot_more_trans_selector);
        }
        if (this.bEr != null) {
            this.bEr.cs(i);
            this.bEr.cq(com.baidu.tieba.t.cp_bg_line_e);
            com.baidu.tbadk.core.util.bc.i(this.bEq, com.baidu.tieba.t.cp_bg_line_e);
        }
        if (this.bEe != null) {
            this.bEe.b(this.bCF.getPageContext(), i);
        }
        if (this.bDl != null) {
            this.bDl.ct(i);
        }
        dV(i == 1);
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.akw = sVar;
        this.bDs.setOnImageClickListener(this.akw);
        if (this.bDv != null) {
            this.bDv.setOnImageClickListener(this.akw);
        }
    }

    public void f(com.baidu.tbadk.core.view.ad adVar) {
        this.aDL = adVar;
        if (this.axO != null) {
            this.axO.a(this.aDL);
        }
    }

    public void eb(boolean z) {
        this.bDs.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public View Zg() {
        if (this.bDv == null) {
            return null;
        }
        return this.bDv.aal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zh() {
        if (this.bCX.mNavigationBar != null) {
            this.bCX.mNavigationBar.setVisibility(8);
        }
        if (this.mListView != null) {
            this.mListView.setVisibility(8);
        }
        if (this.bEe != null) {
            this.bEn = this.bEh.getVisibility() == 0;
            this.bEe.setVisibility(8);
            this.bEh.setVisibility(8);
            this.bEg.setVisibility(8);
        }
    }

    private void Zi() {
        if (this.bCX.mNavigationBar != null) {
            this.bCX.mNavigationBar.setVisibility(0);
        }
        if (this.mListView != null) {
            this.mListView.setVisibility(0);
        }
        if (this.bEe != null) {
            int visibility = this.bDr != null ? this.bDr.getVisibility() : 0;
            if (visibility == 0) {
                if (this.bEn) {
                    this.bEh.setVisibility(visibility);
                    this.bEg.setVisibility(visibility);
                    return;
                }
                this.bEe.setVisibility(visibility);
                return;
            }
            this.bEn = this.bEh.getVisibility() == 0;
            this.bEe.setVisibility(visibility);
            this.bEh.setVisibility(visibility);
            this.bEg.setVisibility(visibility);
        }
    }

    public Button Zj() {
        return this.bEd;
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        if (this.bEe != null) {
            this.bEe.bWj.a(writeImagesInfo, z);
        }
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        if (this.bEe != null) {
            this.bEe.bWj.setBaobaoUris(writeImagesInfo);
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                this.bEe.aga();
            } else {
                this.bEe.agb();
            }
        }
    }

    public void h(com.baidu.tieba.tbadkCore.b.i iVar) {
        if (iVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.b.k> ahf = iVar.ahf();
            if (ahf.size() == 1) {
                com.baidu.tieba.tbadkCore.b.k kVar = ahf.get(0);
                if (kVar.ahz() < kVar.ahs().size()) {
                    this.mListView.setNextPage(null);
                    return;
                } else {
                    this.mListView.setNextPage(this.bDz);
                    return;
                }
            }
            this.mListView.setNextPage(this.bDz);
        }
    }

    public boolean FD() {
        if (this.bEe == null) {
            return false;
        }
        return this.bEe.FD();
    }

    public boolean Zk() {
        if (this.bDv == null) {
            return false;
        }
        return this.bDv.FD();
    }

    public void Zl() {
        if (com.baidu.tbadk.performanceLog.ac.zs().zt()) {
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
                                perfLog.dX(1001);
                                perfLog.agI = true;
                                perfLog.agH = this.bCF.aDw;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                    }
                                }
                                tbImageView.qz();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(com.baidu.tieba.w.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.v perfLog2 = headImageView.getPerfLog();
                        perfLog2.dX(1001);
                        perfLog2.agI = true;
                        perfLog2.agH = this.bCF.aDw;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                            }
                        }
                        headImageView.qz();
                    }
                }
            }
        }
    }

    public void Zm() {
        if (this.bEh != null) {
            this.bEh.setVisibility(0);
            if (this.bEg != null) {
                this.bEg.setVisibility(0);
            }
        }
    }

    public void Zn() {
        if (this.bEh != null) {
            this.bEh.setVisibility(8);
            if (this.bEg != null) {
                this.bEg.setVisibility(8);
            }
        }
    }
}
