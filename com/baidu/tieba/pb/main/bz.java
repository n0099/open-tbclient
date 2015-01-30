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
    private View.OnClickListener aFK;
    private View afC;
    private RelativeLayout arb;
    private NoNetworkView axR;
    bh bAK;
    private com.baidu.tieba.b.d bBn;
    private View.OnClickListener bBo;
    private PbActivity bCG;
    public final com.baidu.tieba.pb.main.b.a bCY;
    private View bCZ;
    private PbListView bDA;
    private View bDC;
    private ColumnLayout bDb;
    private TextView bDc;
    private TextView bDd;
    private HeadImageView bDe;
    private TextView bDf;
    private ImageView bDg;
    private UserIconBox bDh;
    private UserIconBox bDi;
    private ImageView bDj;
    private TextView bDk;
    private TextView bDl;
    private View bDp;
    private View bDr;
    private RelativeLayout bDs;
    private bi bDt;
    private PbEditor bEf;
    private com.baidu.tbadk.editortool.w bEg;
    private View bEh;
    private View bEi;
    private LinearLayout bEj;
    private TextView bEk;
    private LinearLayout bEl;
    private ImageView bEm;
    private TextView bEn;
    private boolean bEp;
    private View bEt;
    private LiveBroadcastCard bEu;
    private View bEv;
    private TextView bEw;
    private bg bEy;
    private BdListView mListView;
    private com.baidu.adp.widget.ListView.g wz;
    private View bDa = null;
    public FrsPraiseView bDm = null;
    private View bDn = null;
    private View bDo = null;
    private View bDq = null;
    private Dialog bDu = null;
    private Dialog bDv = null;
    private com.baidu.tieba.pb.sub.l bDw = null;
    private View bDx = null;
    private EditText bDy = null;
    private com.baidu.tbadk.core.view.am bDz = null;
    private FrameLayout aFi = null;
    private View bDB = null;
    private DialogInterface.OnClickListener bfO = null;
    private AbsListView.OnScrollListener bDD = null;
    private com.baidu.tbadk.widget.richText.s akz = null;
    private com.baidu.tbadk.core.view.ad aDO = null;
    private Dialog bDE = null;
    private Dialog bDF = null;
    private View bDG = null;
    private Button bDH = null;
    private Button bDI = null;
    private TextView bDJ = null;
    private Dialog bDK = null;
    private View bDL = null;
    private int bDM = 0;
    private RadioGroup Ag = null;
    private RadioButton bDN = null;
    private RadioButton bDO = null;
    private RadioButton bDP = null;
    private Button bDQ = null;
    private Button bDR = null;
    private TextView bDS = null;
    private Dialog bDT = null;
    private View bDU = null;
    private RadioGroup bDV = null;
    private CompoundButton.OnCheckedChangeListener bDW = null;
    private Button bDX = null;
    private Button bDY = null;
    private String bDZ = null;
    private cz bEa = null;
    private Dialog bEb = null;
    private boolean bEc = false;
    private ScrollView bEd = null;
    private Button bEe = null;
    private boolean bEo = true;
    private LinearLayout bEq = null;
    private View bEr = null;
    private PbListView bEs = null;
    private boolean bBk = false;
    private boolean mIsFromCDN = true;
    private com.baidu.tieba.tbadkCore.bubble.y aGh = new ca(this);
    private final View.OnClickListener bEx = new cj(this);
    private View.OnLongClickListener bEz = null;
    private boolean bEA = false;
    private final List<TbImageView> bEB = new ArrayList();
    private boolean bBj = true;

    public NoNetworkView Yl() {
        return this.axR;
    }

    public void Ym() {
        this.bEo = true;
        if (this.bEf != null) {
            this.bEf.setVisibility(8);
        }
        if (this.bEi != null) {
            this.bEi.setVisibility(0);
            this.bEh.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.b.k Yn() {
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
        if (this.bDt.getItemViewType(i7) != 0) {
            i7++;
        }
        return (com.baidu.tieba.tbadkCore.b.k) this.bDt.getItem(i7);
    }

    public bz(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.b.e eVar) {
        this.bCG = null;
        this.arb = null;
        this.mListView = null;
        this.bCZ = null;
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
        this.bDl = null;
        this.bDp = null;
        this.bDr = null;
        this.bDt = null;
        this.bDA = null;
        this.afC = null;
        this.aFK = null;
        this.bBo = null;
        this.bEh = null;
        this.bEi = null;
        this.bEj = null;
        this.bEk = null;
        this.bEl = null;
        this.bEm = null;
        this.bEn = null;
        this.bEv = null;
        this.bEw = null;
        this.bCG = pbActivity;
        this.aFK = onClickListener;
        this.bBn = new com.baidu.tieba.b.d(eVar);
        this.arb = (RelativeLayout) com.baidu.adp.lib.g.b.ei().inflate(this.bCG.getPageContext().getPageActivity(), com.baidu.tieba.x.new_pb_activity, null);
        this.bCG.addContentView(this.arb, new FrameLayout.LayoutParams(-1, -1));
        this.bDs = (RelativeLayout) this.bCG.findViewById(com.baidu.tieba.w.title_wrapper);
        this.axR = (NoNetworkView) this.bCG.findViewById(com.baidu.tieba.w.view_no_network);
        this.mListView = (BdListView) this.bCG.findViewById(com.baidu.tieba.w.new_pb_list);
        View view = new View(this.bCG.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.bCG.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_editor_height)));
        this.mListView.addFooterView(view);
        this.bCY = new com.baidu.tieba.pb.main.b.a(pbActivity);
        this.bCY.Zt().setOnTouchListener(new com.baidu.tieba.b.a(new cs(this)));
        this.bEi = this.bCG.findViewById(com.baidu.tieba.w.pb_editor_tool_comment);
        this.bEj = (LinearLayout) this.bCG.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_reply);
        this.bEl = (LinearLayout) this.bCG.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_praise);
        this.bEh = this.bCG.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_line);
        this.bEk = (TextView) this.bCG.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_reply_text);
        this.bEm = (ImageView) this.bCG.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_praise_icon);
        this.bEn = (TextView) this.bCG.findViewById(com.baidu.tieba.w.pb_editor_tool_comment_praise_text);
        this.bEj.setOnClickListener(new ct(this));
        this.bEl.setOnClickListener(this.aFK);
        this.bEl.setOnTouchListener(this.bCG);
        YU();
        this.bCZ = com.baidu.adp.lib.g.b.ei().inflate(this.bCG.getPageContext().getPageActivity(), com.baidu.tieba.x.new_pb_header_item, null);
        this.bDb = (ColumnLayout) this.bCZ.findViewById(com.baidu.tieba.w.pb_head_owner_root);
        this.bDb.setOnLongClickListener(this.bEz);
        this.bDb.setOnTouchListener(this.bBn);
        this.bDb.setVisibility(8);
        this.bCZ.setOnTouchListener(this.bBn);
        this.bDc = (TextView) this.bCZ.findViewById(com.baidu.tieba.w.pb_head_post_title);
        this.bDc.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.bDc.setVisibility(8);
        this.bEv = this.bCZ.findViewById(com.baidu.tieba.w.pb_head_activity_join_number_container);
        this.bEv.setVisibility(8);
        this.bEw = (TextView) this.bCZ.findViewById(com.baidu.tieba.w.pb_head_activity_join_number);
        this.bDd = (TextView) this.bDb.findViewById(com.baidu.tieba.w.pb_head_owner_info_user_name);
        this.bDe = (HeadImageView) this.bDb.findViewById(com.baidu.tieba.w.pb_head_owner_photo);
        if (!this.bBj) {
            this.bDe.setVisibility(8);
        }
        this.bDf = (TextView) this.bDb.findViewById(com.baidu.tieba.w.pb_head_owner_info_user_rank);
        this.bDg = (ImageView) this.bDb.findViewById(com.baidu.tieba.w.pb_head_owner_info_user_gender);
        this.bDh = (UserIconBox) this.bDb.findViewById(com.baidu.tieba.w.pb_head_owner_info_user_icon);
        this.bDi = (UserIconBox) this.bDb.findViewById(com.baidu.tieba.w.pb_head_owner_info_tshow_icon);
        this.bDj = (ImageView) this.bDb.findViewById(com.baidu.tieba.w.pb_head_owner_info_floor_owner);
        this.bDk = (TextView) this.bDb.findViewById(com.baidu.tieba.w.pb_head_owner_info_time);
        this.bDl = (TextView) this.bCZ.findViewById(com.baidu.tieba.w.pb_head_reverse_hint);
        this.bDl.setOnClickListener(this.aFK);
        this.bDl.setVisibility(8);
        this.bDp = this.bCZ.findViewById(com.baidu.tieba.w.new_pb_header_item_line_below_livepost);
        this.bDr = this.bCZ.findViewById(com.baidu.tieba.w.new_pb_header_item_line_above_showpassed);
        this.bCZ.setOnLongClickListener(new cu(this));
        Yz();
        this.bDt = new bi(this.bCG);
        this.bDt.A(this.aFK);
        this.bDt.a(this.bBn);
        this.bDt.setOnImageClickListener(this.akz);
        this.bBo = new cv(this);
        this.bDt.z(this.bBo);
        this.mListView.setAdapter((ListAdapter) this.bDt);
        this.mListView.addHeaderView(this.bCZ);
        this.bDA = new PbListView(this.bCG.getPageContext().getPageActivity());
        this.afC = this.bDA.getView().findViewById(com.baidu.tieba.w.pb_more_view);
        if (this.afC != null) {
            this.afC.setOnClickListener(this.aFK);
            com.baidu.tbadk.core.util.bc.i(this.afC, com.baidu.tieba.v.pb_foot_more_trans_selector);
        }
        this.bDA.qJ();
        this.bDA.cq(com.baidu.tieba.v.pb_foot_more_trans_selector);
        this.bDA.cr(com.baidu.tieba.v.pb_foot_more_trans_selector);
        this.bDC = this.bCG.findViewById(com.baidu.tieba.w.viewstub_progress);
    }

    public PbEditor FF() {
        return this.bEf;
    }

    public void Yo() {
        if (this.bEf != null) {
            this.arb.removeView(this.bEf);
            this.bEf = null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void Yp() {
        if (this.bCG != null) {
            this.bEf = new PbEditor(this.bCG.getPageContext().getPageActivity());
            this.bEf.setOrientation(1);
            this.bEf.setFrom(1);
            this.bEf.aK(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.arb.addView(this.bEf, layoutParams);
            this.bEf.b(this.bCG.getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
            Yq();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void Yq() {
        if (this.bEf != null) {
            this.bEf.a(this.bCG.getPageContext(), new cw(this));
        }
    }

    public void hD(String str) {
        if (this.bEk != null) {
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                this.bEk.setText(str);
            } else {
                this.bEk.setText(this.bCG.getPageContext().getString(com.baidu.tieba.z.reply));
            }
        }
    }

    public void d(long j, boolean z) {
        String p;
        this.bEp = z;
        if (j < 1) {
            p = this.bCG.getResources().getString(com.baidu.tieba.z.frs_item_praise_text);
        } else {
            p = com.baidu.tbadk.core.util.bf.p(j);
        }
        if (this.bEn != null) {
            this.bEn.setText(p);
            dV(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        }
    }

    private void dV(boolean z) {
        if (this.bEm != null) {
            if (this.bEp) {
                com.baidu.tbadk.core.util.bc.c(this.bEm, com.baidu.tieba.v.icon_hand_click);
            } else {
                com.baidu.tbadk.core.util.bc.c(this.bEm, com.baidu.tieba.v.icon_hand_normal);
            }
        }
    }

    public View Yr() {
        return this.bEl;
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
        if (this.bDs != null && view != null) {
            if (this.bEo) {
                z = this.bEi.getVisibility() == 0;
            } else {
                z = this.bEf != null && this.bEf.getVisibility() == 0;
            }
            boolean z2 = this.bDs.getVisibility() == 0;
            if (z2) {
                View findViewById = this.bCG.findViewById(com.baidu.tieba.w.bg_above_list);
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.bDs.getHeight()));
                com.baidu.tieba.tbadkCore.a.a(this.bCG, this.bDs, com.baidu.tieba.q.top_fold_up, new cy(this, findViewById));
            } else {
                com.baidu.tieba.tbadkCore.a.a(this.bCG, this.bDs, com.baidu.tieba.q.top_fold_down, new cb(this));
            }
            if (this.bEo) {
                view2 = this.bEi;
            } else {
                view2 = this.bEf;
            }
            if (z) {
                if (z2) {
                    if (this.bEf != null) {
                        this.bEf.agk();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.bCG, view2, com.baidu.tieba.q.bottom_fold_down, new cc(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.bCG, view2, com.baidu.tieba.q.bottom_fold_up, new cd(this));
            }
        }
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.bEf == null) {
            return null;
        }
        return this.bEf.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.bEf != null) {
            this.bEf.setAudioData(voiceModel);
        }
    }

    public void FO() {
        if (this.bEf != null) {
            this.bEf.FO();
        }
    }

    public void Ys() {
        if (this.bDw != null) {
            this.bDw.YT();
        }
    }

    public com.baidu.tieba.pb.sub.l Yt() {
        return this.bDw;
    }

    public void Yu() {
        if (this.bDw != null) {
            this.bDw.YU();
        }
    }

    public VoiceData.VoiceModel Yv() {
        if (this.bDw != null) {
            return this.bDw.getAudioData();
        }
        return null;
    }

    public void Yw() {
        if (this.bDw != null) {
            this.bDw.FO();
        }
    }

    public TextView Yx() {
        if (this.bDw == null || !(this.bDw instanceof com.baidu.tieba.pb.sub.i)) {
            return null;
        }
        return ((com.baidu.tieba.pb.sub.i) this.bDw).ZW();
    }

    public bi Yy() {
        return this.bDt;
    }

    public void a(bh bhVar) {
        this.bAK = bhVar;
    }

    private void a(com.baidu.tbadk.core.data.aa aaVar) {
        if (aaVar != null && aaVar.nS() != 0) {
            if (this.bEe == null) {
                this.bCG.getLayoutMode().h(((ViewStub) this.bCZ.findViewById(com.baidu.tieba.w.live_talk_layout)).inflate());
                this.bEe = (Button) this.bCZ.findViewById(com.baidu.tieba.w.pb_head_function_manage_go_to_live_post);
                this.bDo = this.bCZ.findViewById(com.baidu.tieba.w.new_pb_header_item_line_above_livepost);
            }
            int nT = aaVar.nT();
            String string = this.bCG.getPageContext().getString(com.baidu.tieba.z.go_to_live_post_prefix);
            if (nT == 0) {
                string = String.valueOf(string) + this.bCG.getPageContext().getString(com.baidu.tieba.z.go_to_interview_post);
            } else if (nT == 1) {
                string = String.valueOf(string) + this.bCG.getPageContext().getString(com.baidu.tieba.z.go_to_discuss_post);
            }
            this.bEe.setText(string);
            this.bEe.setVisibility(0);
            this.bEe.setOnClickListener(this.aFK);
            Za();
        }
    }

    private void Yz() {
        this.bEq = (LinearLayout) this.bCZ.findViewById(com.baidu.tieba.w.btn_show_passed_pb);
        this.bEs = new PbListView(this.bCG.getPageContext().getPageActivity(), PbListView.IconType.ICON_UP_WARD);
        this.bEr = this.bEs.jy();
        this.bEs.setText(this.bCG.getResources().getString(com.baidu.tieba.z.btn_show_passed_pb));
        this.bEr.setOnClickListener(this.bEx);
        this.bEq.addView(this.bEr);
        this.bEq.requestLayout();
        this.bEq.invalidate();
        com.baidu.tbadk.core.util.bc.i(this.bEr, com.baidu.tieba.t.cp_bg_line_e);
        this.bEs.cq(com.baidu.tieba.t.cp_bg_line_e);
        this.bEs.cr(com.baidu.tieba.t.cp_bg_line_e);
        Za();
    }

    public void P(View view) {
        if (this.bDE == null) {
            this.bDE = new Dialog(this.bCG.getPageContext().getPageActivity(), com.baidu.tieba.aa.common_alert_dialog);
            this.bDE.setCanceledOnTouchOutside(true);
            this.bDE.setCancelable(true);
            this.bDE.setContentView(com.baidu.adp.lib.g.b.ei().inflate(this.bCG.getPageContext().getPageActivity(), com.baidu.tieba.x.forum_manage_dialog, null));
            WindowManager.LayoutParams attributes = this.bDE.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.M(this.bCG.getPageContext().getPageActivity()) * 0.9d);
            this.bDE.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.bDE.findViewById(com.baidu.tieba.w.del_post_btn);
        Button button2 = (Button) this.bDE.findViewById(com.baidu.tieba.w.forbid_user_btn);
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
            com.baidu.adp.lib.g.k.a(this.bDE, this.bCG.getPageContext());
        }
    }

    public void a(bg bgVar) {
        this.bEy = bgVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        if (this.bDF == null) {
            this.bDF = new Dialog(this.bCG.getPageContext().getPageActivity(), com.baidu.tieba.aa.common_alert_dialog);
            this.bDF.setCanceledOnTouchOutside(true);
            this.bDF.setCancelable(true);
            this.bDG = com.baidu.adp.lib.g.b.ei().inflate(this.bCG.getPageContext().getPageActivity(), com.baidu.tieba.x.del_post, null);
            this.bDF.setContentView(this.bDG);
            WindowManager.LayoutParams attributes = this.bDF.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.M(this.bCG.getPageContext().getPageActivity()) * 0.9d);
            this.bDF.getWindow().setAttributes(attributes);
            this.bDH = (Button) this.bDG.findViewById(com.baidu.tieba.w.dialog_button_ok);
            this.bDH.setOnClickListener(this.aFK);
            this.bDI = (Button) this.bDG.findViewById(com.baidu.tieba.w.dialog_button_cancel);
            this.bDI.setOnClickListener(new cg(this));
            this.bDJ = (TextView) this.bDG.findViewById(com.baidu.tieba.w.confirm_text);
        }
        SparseArray sparseArray = (SparseArray) this.bDH.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.bDH.setTag(sparseArray);
        }
        sparseArray.put(com.baidu.tieba.w.tag_del_post_id, str);
        sparseArray.put(com.baidu.tieba.w.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(com.baidu.tieba.w.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(com.baidu.tieba.w.tag_del_post_is_self, Boolean.valueOf(z));
        if (i == 0) {
            this.bDJ.setText(com.baidu.tieba.z.del_thread_confirm);
        } else {
            this.bDJ.setText(com.baidu.tieba.z.del_post_confirm);
        }
        com.baidu.adp.lib.g.k.a(this.bDF, this.bCG.getPageContext());
    }

    public void I(ArrayList<com.baidu.tbadk.core.data.k> arrayList) {
        if (this.bDT == null) {
            this.bDT = new Dialog(this.bCG.getPageContext().getPageActivity(), com.baidu.tieba.aa.common_alert_dialog);
            this.bDT.setCanceledOnTouchOutside(true);
            this.bDT.setCancelable(true);
            this.bDU = com.baidu.adp.lib.g.b.ei().inflate(this.bCG.getPageContext().getPageActivity(), com.baidu.tieba.x.commit_good, null);
            this.bEd = (ScrollView) this.bDU.findViewById(com.baidu.tieba.w.good_scroll);
            this.bDT.setContentView(this.bDU);
            WindowManager.LayoutParams attributes = this.bDT.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.M(this.bCG.getPageContext().getPageActivity()) * 0.9d);
            this.bDT.getWindow().setAttributes(attributes);
            this.bDW = new ch(this);
            this.bDV = (RadioGroup) this.bDU.findViewById(com.baidu.tieba.w.good_class_group);
            this.bDY = (Button) this.bDU.findViewById(com.baidu.tieba.w.dialog_button_cancel);
            this.bDY.setOnClickListener(new ci(this));
            this.bDX = (Button) this.bDU.findViewById(com.baidu.tieba.w.dialog_button_ok);
            this.bDX.setOnClickListener(this.aFK);
        }
        this.bDV.removeAllViews();
        RadioButton radioButton = (RadioButton) com.baidu.adp.lib.g.b.ei().inflate(this.bCG.getPageContext().getPageActivity(), com.baidu.tieba.x.good_class_radio_button, null);
        radioButton.setTag("0");
        radioButton.setText(this.bCG.getPageContext().getString(com.baidu.tieba.z.def_good_class));
        radioButton.setOnCheckedChangeListener(this.bDW);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(com.baidu.adp.lib.util.l.dip2px(this.bCG.getPageContext().getPageActivity(), 10.0f), com.baidu.adp.lib.util.l.dip2px(this.bCG.getPageContext().getPageActivity(), 5.0f), com.baidu.adp.lib.util.l.dip2px(this.bCG.getPageContext().getPageActivity(), 10.0f), com.baidu.adp.lib.util.l.dip2px(this.bCG.getPageContext().getPageActivity(), 5.0f));
        this.bDV.addView(radioButton, layoutParams);
        this.bDV.requestLayout();
        this.bDV.check(radioButton.getId());
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                RadioButton radioButton2 = (RadioButton) com.baidu.adp.lib.g.b.ei().inflate(this.bCG.getPageContext().getPageActivity(), com.baidu.tieba.x.good_class_radio_button, null);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).mO()));
                radioButton2.setText(arrayList.get(i2).mN());
                radioButton2.setOnCheckedChangeListener(this.bDW);
                this.bDV.addView(radioButton2, layoutParams);
                this.bDV.requestLayout();
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bEd.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.bCG.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.bCG.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.bCG.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.bEd.setLayoutParams(layoutParams2);
            this.bEd.removeAllViews();
            this.bEd.addView(this.bDV);
        }
        com.baidu.adp.lib.g.k.a(this.bDT, this.bCG.getPageContext());
    }

    public void YA() {
        this.bCG.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.bCG.hideProgressBar();
        if (z && z2) {
            this.bCG.showToast(this.bCG.getPageContext().getString(com.baidu.tieba.z.success));
        } else if (str != null && z2) {
            this.bCG.showToast(str);
        }
    }

    public void Hk() {
        this.arb.removeView(this.aFi);
    }

    public void Qo() {
        this.bDC.setVisibility(0);
    }

    public void Qn() {
        this.bDC.setVisibility(8);
    }

    public View YB() {
        if (this.bDG != null) {
            return this.bDG.findViewById(com.baidu.tieba.w.dialog_button_ok);
        }
        return null;
    }

    public View YC() {
        if (this.bDU != null) {
            return this.bDU.findViewById(com.baidu.tieba.w.dialog_button_ok);
        }
        return null;
    }

    public String YD() {
        return this.bDZ;
    }

    public View YE() {
        if (this.bDw != null) {
            return this.bDw.aal();
        }
        return null;
    }

    public View getView() {
        return this.arb;
    }

    public void YF() {
        View editText;
        if (this.bEf == null) {
            editText = this.bCG.getCurrentFocus();
        } else {
            editText = this.bEf.getEditText();
        }
        com.baidu.adp.lib.util.l.c(this.bCG.getPageContext().getPageActivity(), editText);
    }

    public void FL() {
        if (this.bDw != null) {
            this.bDw.aan();
        } else {
            this.bCG.showProgressBar();
        }
    }

    public void bG(boolean z) {
        if (this.bDw != null) {
            this.bDw.aao();
        } else {
            this.bCG.hideProgressBar();
        }
        Zj();
        if (z) {
            if (this.bEf != null) {
                this.bEf.getEditText().setText("");
                this.bEf.agg();
                this.bEf.clearData();
            }
            if (this.bDw != null) {
                this.bDw.clearContent();
            }
        }
    }

    public void YG() {
        this.bDA.startLoadData();
    }

    public void YH() {
    }

    public void YI() {
        this.bCG.hideProgressBar();
        this.bDA.qK();
        this.bEs.qK();
        this.mListView.jI();
        Za();
    }

    public void YJ() {
        this.mListView.jI();
        this.bEq.setVisibility(8);
        Za();
    }

    public void dX(boolean z) {
        if (!z) {
            if (this.bEf != null) {
                this.bEf.agi();
            }
        } else if (this.bDw != null) {
            this.bDw.hJ(null);
        }
    }

    public void YK() {
        if (YO() && this.bDw != null) {
            this.bDw.aae();
        }
    }

    public void YL() {
        if (this.bDw == null) {
            this.bDw = new com.baidu.tieba.pb.sub.l(this.bCG, this.bEA, this.aFK, this.bBo, this.bCG.bAy.bEP, this.bCG.bAy.bEQ, this.bCG.bAy.bER);
            this.bDw.setOnActionListener(this.bEg);
            this.bDw.setOnScrollListener(this.bDD);
            this.bDw.dO(this.bDt.XD());
            this.bDw.dP(this.bDt.XE());
            this.bDB = this.bDw.getRootView();
            this.bDw.setOnImageClickListener(this.akz);
            this.bDw.setOnEmotionClickListener(this.bCG.bAy.bES);
            this.bDw.setOnLongClickListener(this.bDt.XC());
        }
        this.bDB.setVisibility(0);
        this.bDw.eg(this.mIsFromCDN);
        this.bDw.YF();
        this.arb.addView(this.bDB);
        Zm();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.bEg = wVar;
            if (this.bEf != null) {
                Yq();
            }
            if (this.bDw != null) {
                this.bDw.setOnActionListener(wVar);
            }
        }
    }

    public void a(cz czVar) {
        this.bEa = czVar;
    }

    public void a(boolean z, com.baidu.tieba.tbadkCore.b.o oVar, boolean z2, String str, String str2, View view, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        if (oVar != null && view != null) {
            TiebaStatic.eventStat(this.bCG.getPageContext().getPageActivity(), "pb_tosubpb", "pbclick", 1, new Object[0]);
            if (this.bDw == null) {
                this.bDw = new com.baidu.tieba.pb.sub.l(this.bCG, this.bEA, this.aFK, this.bBo, this.bCG.bAy.bEP, this.bCG.bAy.bEQ, this.bCG.bAy.bER);
                this.bDw.setOnActionListener(this.bEg);
                this.bDw.setOnScrollListener(this.bDD);
                this.bDw.dO(this.bDt.XD());
                this.bDw.dP(this.bDt.XE());
                this.bDB = this.bDw.getRootView();
                this.bDw.setOnImageClickListener(this.akz);
                this.bDw.setOnEmotionClickListener(this.bCG.bAy.bES);
                this.bDw.setOnLongClickListener(this.bDt.XC());
            }
            this.bDw.hi(this.bDt.getWidth());
            this.bDw.a(oVar, i);
            this.bDw.eg(this.mIsFromCDN);
            if (str2 != null && !str2.equals("")) {
                this.bDw.hL(str2);
            } else {
                this.bDw.setPosition(1);
            }
            int i2 = 0;
            if (this.bDs.getVisibility() == 0) {
                i2 = this.bDs.getHeight();
            }
            int top = view.getTop() + i2;
            int bottom = view.getBottom() + i2;
            if (!z) {
                this.bDw.aah();
            }
            int height = ((view.getHeight() + this.bCG.getResources().getDimensionPixelSize(com.baidu.tieba.u.subpb_listitem_packup_min_height)) - this.bCG.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_list_item_border_bottom_margin_top)) - this.arb.getHeight();
            if (height > 0) {
                top += height;
            }
            AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, top, 0.0f);
            translateAnimation.setDuration(300L);
            this.bDB.setAnimation(translateAnimation);
            try {
                this.arb.invalidate();
                this.arb.buildDrawingCache();
                bitmap = this.arb.getDrawingCache();
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
            this.bDB.setVisibility(0);
            if (this.bDB.getParent() == this.arb) {
                this.arb.removeView(this.bDB);
            }
            this.arb.addView(this.bDB, new RelativeLayout.LayoutParams(-1, -1));
            if (bitmap2 != null) {
                ImageView imageView = new ImageView(this.bCG.getPageContext().getPageActivity());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(10);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageBitmap(bitmap2);
                this.arb.addView(imageView);
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
                ImageView imageView2 = new ImageView(this.bCG.getPageContext().getPageActivity());
                imageView2.setImageBitmap(bitmap3);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(12);
                imageView2.setLayoutParams(layoutParams2);
                this.arb.addView(imageView2);
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
        this.bEz = onLongClickListener;
        this.bDt.setOnLongClickListener(onLongClickListener);
        if (this.bDw != null) {
            this.bDw.setOnLongClickListener(onLongClickListener);
        }
    }

    public void YM() {
        if (YO()) {
            this.bDw.aai();
        }
    }

    public void YN() {
        if (YO() && (this.bDw instanceof com.baidu.tieba.pb.sub.i)) {
            ((com.baidu.tieba.pb.sub.i) this.bDw).ZZ();
        }
    }

    public boolean YO() {
        return (this.bDB == null || this.bDB.getVisibility() == 8) ? false : true;
    }

    public void YP() {
        if (this.bDB != null) {
            this.bDB.setVisibility(8);
            this.arb.removeView(this.bDB);
            this.bDw.IP();
        }
        Zj();
        Zn();
    }

    public void YQ() {
        if (this.bDB != null) {
            if (this.arb != null) {
                this.arb.removeView(this.bDB);
            }
            this.bDB = null;
        }
        if (this.bDw != null) {
            this.bDw.IP();
            this.bDw = null;
        }
    }

    public void YR() {
        if (this.bDw != null) {
            this.bDw.aap();
            if (this.bDw instanceof com.baidu.tieba.pb.sub.i) {
                ((com.baidu.tieba.pb.sub.i) this.bDw).aaa();
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.b.o oVar, int i) {
        if (this.bDw != null) {
            this.bDw.aap();
            this.bDw.hi(this.bDt.getWidth());
            this.bDw.a(oVar, i);
        }
    }

    public void YS() {
        if (this.bDw == null) {
            this.bDw = new com.baidu.tieba.pb.sub.i(this.bCG, this.bEA, this.aFK, this.bBo, this.bCG.bAy.bEP, this.bCG.bAy.bEQ, this.bCG.bAy.bER);
            this.bDw.setOnActionListener(this.bEg);
            this.bDw.setOnScrollListener(this.bDD);
            this.bDw.dO(this.bDt.XD());
            this.bDw.dP(this.bDt.XE());
            this.bDB = this.bDw.getRootView();
            this.bDw.setOnImageClickListener(this.akz);
            this.bDw.setOnEmotionClickListener(this.bCG.bAy.bES);
            this.bDw.setOnLongClickListener(this.bDt.XC());
        }
        this.bDB.setVisibility(0);
        this.bDw.YF();
        this.arb.addView(this.bDB);
        Zm();
    }

    public void a(com.baidu.tieba.tbadkCore.b.o oVar, int i, String str, boolean z, boolean z2) {
        if (this.bDw != null && (this.bDw instanceof com.baidu.tieba.pb.sub.i)) {
            com.baidu.tieba.pb.sub.i iVar = (com.baidu.tieba.pb.sub.i) this.bDw;
            this.bDw.aap();
            this.bDw.hi(this.bDt.getWidth());
            this.bDw.a(oVar, i);
            if (z2) {
                iVar.hI(str);
            }
            if (!z) {
                iVar.aab();
            } else {
                iVar.aac();
            }
        }
    }

    public void A(ArrayList<String> arrayList) {
        if (this.bEf != null) {
            this.bEf.A(arrayList);
        }
    }

    public void J(ArrayList<String> arrayList) {
        if (this.bDw != null) {
            this.bDw.A(arrayList);
        }
    }

    public void YT() {
        this.bEA = true;
        if (this.bEf != null) {
            this.bEf.YT();
        }
    }

    public void YU() {
        this.bEA = false;
        if (this.bEf != null) {
            this.bEf.YU();
        }
    }

    public void a(DialogInterface.OnClickListener onClickListener, boolean z, boolean z2) {
        if (this.bEb != null) {
            com.baidu.adp.lib.g.k.b(this.bEb, this.bCG.getPageContext());
            this.bEb = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.bCG.getPageContext().getPageActivity());
        builder.setTitle(com.baidu.tieba.z.operation);
        if (z2) {
            builder.setItems(new String[]{this.bCG.getPageContext().getString(com.baidu.tieba.z.copy)}, onClickListener);
        } else if (!z) {
            builder.setItems(new String[]{this.bCG.getPageContext().getString(com.baidu.tieba.z.copy), this.bCG.getPageContext().getString(com.baidu.tieba.z.mark)}, onClickListener);
        } else {
            builder.setItems(new String[]{this.bCG.getPageContext().getString(com.baidu.tieba.z.copy), this.bCG.getPageContext().getString(com.baidu.tieba.z.remove_mark)}, onClickListener);
        }
        this.bEb = builder.create();
        this.bEb.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.bEb, this.bCG.getPageContext());
    }

    public void setAudioFocusable(boolean z) {
        if (this.bEf != null) {
            this.bEf.setAudioFocusable(z);
        }
    }

    public void dY(boolean z) {
        if (this.bDw != null) {
            this.bDw.setAudioFocusable(z);
        }
    }

    public void j(Bitmap bitmap) {
        if (this.bEf != null) {
            this.bEf.j(bitmap);
            this.bEf.agf();
        }
    }

    public void YV() {
        if (this.bEf != null) {
            this.bEf.j(null);
        }
    }

    public int YW() {
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
            return Integer.parseInt(this.bDy.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public String FM() {
        return this.bEf == null ? "" : this.bEf.getContent();
    }

    public void fC(String str) {
        if (this.bEf != null) {
            this.bEf.setContent(str);
        }
    }

    public String YX() {
        if (this.bDw == null) {
            return null;
        }
        return this.bDw.aam();
    }

    public String YY() {
        if (this.bDw != null) {
            return this.bDw.aaj();
        }
        return null;
    }

    public String YZ() {
        if (this.bDw != null) {
            return this.bDw.aaf();
        }
        return null;
    }

    public void e(com.baidu.tieba.tbadkCore.b.i iVar) {
        this.bDt.b(iVar);
        this.bDt.notifyDataSetChanged();
        if (iVar == null) {
            hD("");
        } else {
            hD(com.baidu.tbadk.core.util.bf.p(iVar.ahj().getReply_num()));
        }
        Za();
    }

    public void f(com.baidu.tieba.tbadkCore.b.i iVar) {
        PraiseData praise;
        if (this.bDm == null) {
            this.bCG.getLayoutMode().h(((ViewStub) this.bCZ.findViewById(com.baidu.tieba.w.praise_layout)).inflate());
            this.bDm = (FrsPraiseView) this.bCZ.findViewById(com.baidu.tieba.w.pb_head_praise_view);
            this.bDm.setIsFromPb(true);
            this.bDq = this.bCZ.findViewById(com.baidu.tieba.w.new_pb_header_item_line_above_praise);
            this.bDm.ct(TbadkCoreApplication.m255getInst().getSkinType());
        }
        if (this.bDm != null) {
            boolean Za = Za();
            if (iVar != null && iVar.ahk() != null && iVar.ahk().size() > 0) {
                com.baidu.tieba.tbadkCore.b.k kVar = iVar.ahk().get(0);
                if ((!this.bBk || kVar.ahy() != 1) && (praise = iVar.ahj().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.bDm.setVisibility(0);
                    this.bDm.setIsFromPb(true);
                    this.bDm.a(praise, iVar.ahj().getId(), praise.getPostId(), true);
                    this.bDq.setVisibility(0);
                    if (this.bDm.getVisibility() == 0) {
                        this.bDr.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.bDm.setVisibility(8);
            this.bDq.setVisibility(8);
            if (iVar != null && iVar.na() != null && iVar.na().mZ() == 0 && this.bBk) {
                this.bDq.setVisibility(8);
                if (Za) {
                    this.bDp.setVisibility(0);
                    return;
                } else {
                    this.bDp.setVisibility(8);
                    return;
                }
            }
            this.bDq.setVisibility(0);
            this.bDp.setVisibility(8);
        }
    }

    private com.baidu.tieba.tbadkCore.b.k a(com.baidu.tieba.tbadkCore.b.i iVar, boolean z, int i) {
        if (z) {
            if (iVar == null || iVar.ahk() == null || iVar.ahk().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.b.k kVar = iVar.ahk().get(0);
            if (kVar.ahy() != 1) {
                return g(iVar);
            }
            return kVar;
        }
        return g(iVar);
    }

    private com.baidu.tieba.tbadkCore.b.k g(com.baidu.tieba.tbadkCore.b.i iVar) {
        MetaData metaData;
        if (iVar == null || iVar.ahj() == null || iVar.ahj().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.b.k kVar = new com.baidu.tieba.tbadkCore.b.k();
        MetaData author = iVar.ahj().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = iVar.ahj().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        kVar.hX(1);
        kVar.setId(iVar.ahj().nF());
        kVar.setTitle(iVar.ahj().getTitle());
        kVar.setTime(iVar.ahj().getCreateTime());
        kVar.a(metaData);
        return kVar;
    }

    private void b(com.baidu.tieba.tbadkCore.b.i iVar, boolean z, int i) {
        this.bDb.setVisibility(8);
        com.baidu.tieba.tbadkCore.b.k a = a(iVar, z, i);
        if (a != null) {
            if (z) {
                this.bDl.setVisibility(8);
            } else {
                this.bDl.setVisibility(0);
            }
            this.bDb.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.bDb.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.bDb.setTag(sparseArray);
            }
            sparseArray.put(com.baidu.tieba.w.tag_clip_board, a);
            sparseArray.put(com.baidu.tieba.w.tag_is_subpb, false);
            this.bDk.setText(com.baidu.tbadk.core.util.bf.n(a.getTime()));
            iVar.ahj().nL();
            this.bDc.setVisibility(0);
            this.bDc.setText(iVar.ahj().getSpan_str());
            f(iVar);
            ArrayList<com.baidu.tbadk.core.data.b> nA = iVar.ahj().nA();
            if (nA != null && nA.size() > 0) {
                this.bEw.setText(String.valueOf(nA.get(0).mt()));
                this.bEv.setVisibility(0);
            } else {
                this.bEv.setVisibility(8);
            }
            com.baidu.tbadk.core.util.bc.i(this.bEv, com.baidu.tieba.v.activity_join_num_bg);
            com.baidu.tbadk.core.util.bc.b(this.bEw, com.baidu.tieba.t.cp_link_tip_d, 1);
            boolean appResponseToIntentClass = TbadkCoreApplication.m255getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
            if (iVar.ahj().getAnchorInfoData().getGroup_id() != 0 && appResponseToIntentClass) {
                if (this.bEt == null) {
                    BdLog.e("pb time   liveCardLayout new");
                    this.bEt = ((ViewStub) this.bCZ.findViewById(com.baidu.tieba.w.live_card_layout)).inflate();
                    this.bCG.getLayoutMode().h(this.bEt);
                    this.bEu = (LiveBroadcastCard) this.bCZ.findViewById(com.baidu.tieba.w.item_card);
                }
                this.bEt.setVisibility(0);
                LiveCardData liveCardData = new LiveCardData();
                liveCardData.setPublisherId(iVar.ahj().getAnchorInfoData().getAuthorId());
                liveCardData.setPublisherName(iVar.ahj().getAnchorInfoData().getAuthorName());
                liveCardData.setPublisherPortrait(iVar.ahj().getAnchorInfoData().getPublisherPortrait());
                liveCardData.setGroupId(iVar.ahj().getAnchorInfoData().getGroup_id());
                liveCardData.setIntro(iVar.ahj().getAnchorInfoData().getIntro());
                liveCardData.setLikers(iVar.ahj().getAnchorInfoData().getLikers());
                liveCardData.setListeners(iVar.ahj().getAnchorInfoData().getListeners());
                liveCardData.setName(iVar.ahj().getAnchorInfoData().getName());
                liveCardData.setPortrait(iVar.ahj().getAnchorInfoData().getPortrait());
                liveCardData.setStatus(iVar.ahj().getAnchorInfoData().getStatus());
                liveCardData.setStartTime(iVar.ahj().getAnchorInfoData().getStartTime());
                this.bEu.setData(liveCardData);
                this.bEu.setStatisticsKey("notice_pb_live");
            } else if (this.bEt != null) {
                this.bEt.setVisibility(8);
            }
            String userId = iVar.ahj().getAuthor().getUserId();
            if (userId != null && !userId.equals("0") && userId.equals(a.getAuthor().getUserId())) {
                this.bDj.setVisibility(0);
            } else {
                this.bDj.setVisibility(8);
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.bDf.setVisibility(0);
                    this.bDf.setText(String.valueOf(level_id));
                    com.baidu.tbadk.core.util.bc.i((View) this.bDf, com.baidu.tbadk.core.util.d.bP(level_id));
                    i2 = 2;
                    this.bDf.setOnClickListener(null);
                } else {
                    this.bDf.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.bDf.setText((CharSequence) null);
                        com.baidu.tbadk.core.util.bc.i((View) this.bDf, com.baidu.tieba.v.pb_manager);
                        this.bDf.setOnClickListener(this.bCG.bAy.bEQ);
                    } else if (bawu_type.equals("assist")) {
                        this.bDf.setText((CharSequence) null);
                        com.baidu.tbadk.core.util.bc.i((View) this.bDf, com.baidu.tieba.v.pb_assist);
                        this.bDf.setOnClickListener(this.bCG.bAy.bEQ);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.bc.c(this.bDg, com.baidu.tieba.v.icon_pop_girl_square);
                    this.bDg.setVisibility(0);
                } else {
                    this.bDg.setVisibility(8);
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfo = a.getAuthor().getTShowInfo();
                if (this.bDh != null) {
                    this.bDh.setOnClickListener(this.bCG.bAy.bEQ);
                    this.bDh.a(iconInfo, i2, this.bCG.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_width), this.bCG.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_height), this.bCG.getResources().getDimensionPixelSize(com.baidu.tieba.u.pb_icon_margin));
                }
                if (this.bDi != null) {
                    this.bDi.setOnClickListener(this.bCG.bAy.bER);
                    this.bDi.a(tShowInfo, 3, this.bCG.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_width), this.bCG.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_height), this.bCG.getResources().getDimensionPixelSize(com.baidu.tieba.u.big_icon_margin), true);
                }
                this.bDd.setText(a.getAuthor().getName_show());
                this.bDd.setTag(com.baidu.tieba.w.tag_user_id, a.getAuthor().getUserId());
                this.bDd.setTag(com.baidu.tieba.w.tag_user_name, a.getAuthor().getName_show());
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.bc.b(this.bDd, com.baidu.tieba.t.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.bc.b(this.bDd, com.baidu.tieba.t.cp_cont_f, 1);
                }
                if (!this.bBj) {
                    this.bDe.setVisibility(8);
                }
                this.bDe.setUserId(a.getAuthor().getUserId());
                this.bDe.setUserName(a.getAuthor().getUserName());
                this.bDe.setImageDrawable(null);
                this.bDe.setTag(a.getAuthor().getUserId());
                this.bDd.setOnClickListener(this.bCG.bAy.bEP);
                this.bDe.setOnClickListener(this.bCG.bAy.bEP);
                this.bDe.d(a.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.b.i iVar, int i, int i2, boolean z, int i3) {
        Parcelable Yf;
        Parcelable Yf2;
        this.bBk = z;
        YI();
        b(iVar, z, i);
        this.bDt.dN(this.bBk);
        this.bDt.b(iVar);
        this.bDt.notifyDataSetChanged();
        this.bCY.hE(iVar.aeN().getName());
        if (iVar.ahj() != null) {
            hD(com.baidu.tbadk.core.util.bf.p(iVar.ahj().getReply_num()));
            if (iVar.ahj().getPraise() != null) {
                d(iVar.ahj().getPraise().getNum(), iVar.ahj().getPraise().getIsLike() == 1);
            }
        }
        if (iVar.na().mY() == 0 && !z) {
            this.mListView.setNextPage(null);
        } else {
            this.mListView.setNextPage(this.bDA);
            this.bEs.qK();
        }
        if (iVar.na().mZ() == 0 && z) {
            this.mListView.setPullRefresh(null);
            this.bEq.setVisibility(8);
        } else {
            if (this.bDz == null) {
                this.bDz = new com.baidu.tbadk.core.view.am(this.bCG.getPageContext());
                this.bDz.jy();
                this.bDz.a(this.wz);
            }
            this.mListView.setPullRefresh(this.bDz);
            if (this.bDz != null) {
                this.bDz.cs(TbadkCoreApplication.m255getInst().getSkinType());
            }
            this.bEq.setVisibility(0);
            this.bEs.qK();
        }
        Za();
        if (iVar.na().mY() == 0) {
            this.bDA.setText(this.bCG.getResources().getString(com.baidu.tieba.z.no_more_to_load));
            h(iVar);
        } else {
            this.bDA.setText(this.bCG.getResources().getString(com.baidu.tieba.z.pb_load_more));
        }
        if (z) {
            this.bEs.setText(this.bCG.getResources().getString(com.baidu.tieba.z.btn_show_passed_pb));
        } else {
            this.bEs.setText(this.bCG.getResources().getString(com.baidu.tieba.z.btn_show_passed_pb_aftre));
        }
        if (iVar.ahj() != null && iVar.ahj().getAuthor() != null && iVar.ahj().getAuthor().getType() == 0) {
            this.bCY.Zu();
        }
        switch (i) {
            case 2:
                this.mListView.setSelection(i2);
                if (this.bDa != null) {
                    CompatibleUtile.scrollListViewBy(this.mListView, -this.bDa.getHeight(), 0);
                    return;
                }
                return;
            case 3:
                if (i3 == 1 && (Yf2 = bv.Ye().Yf()) != null) {
                    this.mListView.onRestoreInstanceState(Yf2);
                    return;
                } else {
                    this.mListView.setSelection(0);
                    return;
                }
            case 4:
                if (z) {
                    this.mListView.setSelection(0);
                    return;
                } else if (iVar.ahk() != null) {
                    if (iVar.na() != null && iVar.na().mZ() != 0) {
                        this.mListView.setSelection(iVar.ahk().size() + 1);
                        return;
                    } else {
                        this.mListView.setSelection(iVar.ahk().size());
                        return;
                    }
                } else {
                    return;
                }
            case 5:
                this.mListView.setSelection(0);
                return;
            case 6:
                if (i3 == 1 && (Yf = bv.Ye().Yf()) != null) {
                    this.mListView.onRestoreInstanceState(Yf);
                    return;
                } else if (z) {
                    this.mListView.setSelection(0);
                    return;
                } else if (iVar.ahk() != null) {
                    if (iVar.na() != null && iVar.na().mZ() != 0) {
                        this.mListView.setSelection(iVar.ahk().size() + 1);
                        return;
                    } else {
                        this.mListView.setSelection(iVar.ahk().size());
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
        this.bEc = z;
        this.bCY.dZ(z);
    }

    public void qK() {
        if (this.bDA != null) {
            this.bDA.qK();
        }
        if (this.bEs != null) {
            this.bEs.qK();
        }
    }

    public void GS() {
        this.mListView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Za() {
        boolean z;
        boolean z2 = true;
        if (this.bDa != null && this.bDa.getVisibility() == 0) {
            if (this.bDn != null) {
                this.bDn.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.bDn != null) {
                this.bDn.setVisibility(8);
            }
            z = false;
        }
        if (this.bEe != null && this.bEe.getVisibility() == 0) {
            if (this.bDo != null) {
                this.bDo.setVisibility(0);
            }
        } else {
            if (this.bDo != null) {
                this.bDo.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.bDq == null || this.bDq.getVisibility() == 8) && z2 && this.bBk) {
            this.bDp.setVisibility(0);
        } else {
            this.bDp.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.tbadkCore.b.i iVar, boolean z, boolean z2) {
        if (iVar == null) {
            return false;
        }
        if (this.bDc != null) {
            if (iVar.ahj().nC() == 0) {
                this.bDc.setVisibility(0);
                iVar.ahj().nL();
                this.bDc.setText(iVar.ahj().getSpan_str());
            } else {
                this.bDc.setVisibility(8);
            }
        }
        if (z) {
            if (this.bEt != null) {
                this.bEt.findViewById(com.baidu.tieba.w.pb_head_live_blank).setVisibility(8);
            }
        } else if (this.bEt != null) {
            this.bEt.findViewById(com.baidu.tieba.w.pb_head_live_blank).setVisibility(0);
        }
        this.bBk = z;
        com.baidu.tbadk.core.data.x ahj = iVar.ahj();
        if (ahj != null) {
            a(ahj.nt());
        }
        if (iVar.ahl() == 1) {
            Zb();
            Button button = (Button) this.bCZ.findViewById(com.baidu.tieba.w.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.bCZ.findViewById(com.baidu.tieba.w.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.bCZ.findViewById(com.baidu.tieba.w.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.bCZ.findViewById(com.baidu.tieba.w.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.aFK);
            button2.setOnClickListener(this.aFK);
            button3.setOnClickListener(this.aFK);
            button4.setOnClickListener(this.aFK);
            if (iVar.ahj().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (iVar.ahj().getIs_top() == 1) {
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

    private void Zb() {
        if (this.bDa == null) {
            this.bDa = ((ViewStub) this.bCZ.findViewById(com.baidu.tieba.w.pb_header_function_manage)).inflate();
            this.bCG.getLayoutMode().h(this.bDa);
            this.bDn = this.bCZ.findViewById(com.baidu.tieba.w.new_pb_header_item_line_above_manage);
            return;
        }
        this.bDa.setVisibility(0);
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
                if (iVar.ahl() != 0 && a.getAuthor() != null) {
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
                    String userId3 = iVar.ahj().getAuthor().getUserId();
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
                    sparseArray.put(com.baidu.tieba.w.tag_manage_user_identity, Integer.valueOf(iVar.ahl()));
                    sparseArray.put(com.baidu.tieba.w.tag_should_manage_visible, true);
                    a(com.baidu.tieba.z.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(com.baidu.tieba.w.tag_del_post_id, a.getId());
                    sparseArray2.put(com.baidu.tieba.w.tag_del_post_type, 0);
                    sparseArray2.put(com.baidu.tieba.w.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(com.baidu.tieba.w.tag_manage_user_identity, Integer.valueOf(iVar.ahl()));
                    sparseArray2.put(com.baidu.tieba.w.tag_should_manage_visible, false);
                    a(com.baidu.tieba.z.delete, sparseArray2);
                }
            }
            Za();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        Zb();
        Button button = (Button) this.bCZ.findViewById(com.baidu.tieba.w.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.aFK);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.afC;
    }

    public BdListView getListView() {
        return this.mListView;
    }

    public int Zc() {
        return com.baidu.tieba.w.richText;
    }

    public int Fn() {
        return com.baidu.tieba.w.user_icon_box;
    }

    public Button Zd() {
        return (Button) this.bCZ.findViewById(com.baidu.tieba.w.pb_head_function_manage_commit_good);
    }

    public Button Ze() {
        return (Button) this.bCZ.findViewById(com.baidu.tieba.w.pb_head_function_manage_cancel_good);
    }

    public Button Zf() {
        return (Button) this.bCZ.findViewById(com.baidu.tieba.w.pb_head_function_manage_commit_top);
    }

    public Button Zg() {
        return (Button) this.bCZ.findViewById(com.baidu.tieba.w.pb_head_function_manage_cancel_top);
    }

    public View Zh() {
        if (this.bDw == null) {
            return null;
        }
        return this.bDw.aak();
    }

    public void c(com.baidu.adp.widget.ListView.ab abVar) {
        this.mListView.setOnSrollToBottomListener(abVar);
    }

    public void a(com.baidu.adp.widget.ListView.ae aeVar) {
        this.mListView.setOnSrollToTopListener(aeVar);
    }

    public void c(DialogInterface.OnClickListener onClickListener) {
        this.bfO = onClickListener;
    }

    public void a(com.baidu.adp.widget.ListView.g gVar) {
        this.wz = gVar;
        if (this.bDz != null) {
            this.bDz.a(gVar);
        }
    }

    public void b(com.baidu.tbadk.core.data.q qVar) {
        if (qVar != null) {
            int mW = qVar.mW();
            int mU = qVar.mU();
            if (this.bDu == null) {
                this.bDu = new Dialog(this.bCG.getPageContext().getPageActivity(), com.baidu.tieba.aa.common_alert_dialog);
                this.bDu.setCanceledOnTouchOutside(true);
                this.bDu.setCancelable(true);
                this.bDx = com.baidu.adp.lib.g.b.ei().inflate(this.bCG.getPageContext().getPageActivity(), com.baidu.tieba.x.dialog_direct_pager, null);
                this.bDu.setContentView(this.bDx);
                WindowManager.LayoutParams attributes = this.bDu.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = com.baidu.adp.lib.util.l.dip2px(this.bCG.getPageContext().getPageActivity(), 54.0f);
                attributes.width = (int) (com.baidu.adp.lib.util.l.M(this.bCG.getPageContext().getPageActivity()) * 0.9d);
                this.bDu.getWindow().setAttributes(attributes);
                this.bDu.setOnKeyListener(new cq(this));
            }
            com.baidu.adp.lib.g.k.a(this.bDu, this.bCG.getPageContext());
            ((Button) this.bDx.findViewById(com.baidu.tieba.w.dialog_button_ok)).setOnClickListener(this.aFK);
            ((Button) this.bDx.findViewById(com.baidu.tieba.w.dialog_button_cancel)).setOnClickListener(this.aFK);
            this.bDy = (EditText) this.bDx.findViewById(com.baidu.tieba.w.input_page_number);
            this.bDy.setText("");
            this.bDy.setOnFocusChangeListener(new cr(this));
            TextView textView = (TextView) this.bDx.findViewById(com.baidu.tieba.w.current_page_number);
            if (mW <= 0) {
                mW = 1;
            }
            textView.setText(MessageFormat.format(this.bCG.getApplicationContext().getResources().getString(com.baidu.tieba.z.current_page), Integer.valueOf(mW), Integer.valueOf(mU <= 0 ? 1 : mU)));
            this.bCG.ShowSoftKeyPadDelay(this.bDy, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.bDD = onScrollListener;
    }

    public void showToast(String str) {
        this.bCG.showToast(str);
    }

    public boolean ea(boolean z) {
        if (this.bDw == null || !this.bDw.ZU()) {
            if (!z) {
                if (YO()) {
                    YP();
                    return true;
                } else if (this.bEf != null && this.bEf.afN()) {
                    this.bEf.agl();
                    return true;
                }
            } else if (YO()) {
                YP();
                return true;
            }
            return false;
        }
        return true;
    }

    public void Zi() {
        if (this.bEB != null) {
            while (this.bEB.size() > 0) {
                TbImageView remove = this.bEB.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        Zi();
    }

    public void onDestroy() {
        this.bCG.hideProgressBar();
        if (this.axR != null && this.aDO != null) {
            this.axR.b(this.aDO);
        }
        Zj();
        this.bDA.qK();
    }

    public void Zj() {
        this.bCY.Zv();
        com.baidu.adp.lib.util.l.c(this.bCG.getPageContext().getPageActivity(), this.bDy);
        if (this.bEf != null) {
            this.bEf.agj();
        }
        if (this.bDu != null) {
            com.baidu.adp.lib.g.k.b(this.bDu, this.bCG.getPageContext());
        }
        if (this.bEb != null) {
            com.baidu.adp.lib.g.k.b(this.bEb, this.bCG.getPageContext());
        }
        if (this.bDw != null) {
            this.bDw.aah();
        }
        Zk();
    }

    public void dO(boolean z) {
        this.bDt.dO(z);
        if (this.bDw != null) {
            this.bDw.dO(z);
        }
    }

    public void dP(boolean z) {
        this.bBj = z;
        this.bDt.dP(z);
        if (this.bDw != null) {
            this.bDw.dP(z);
        }
    }

    public void Zk() {
        if (this.bDF != null) {
            com.baidu.adp.lib.g.k.b(this.bDF, this.bCG.getPageContext());
        }
        if (this.bDK != null) {
            com.baidu.adp.lib.g.k.b(this.bDK, this.bCG.getPageContext());
        }
        if (this.bDT != null) {
            com.baidu.adp.lib.g.k.b(this.bDT, this.bCG.getPageContext());
        }
        if (this.bDE != null) {
            com.baidu.adp.lib.g.k.b(this.bDE, this.bCG.getPageContext());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: com.baidu.tieba.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.bCG.getLayoutMode().ab(i == 1);
        this.bCG.getLayoutMode().h(this.arb);
        this.bCG.getLayoutMode().h(this.bCZ);
        this.bCG.getLayoutMode().h(this.afC);
        this.bCY.mNavigationBar.onChangeSkinType(this.bCG.getPageContext(), i);
        dZ(this.bEc);
        this.bDt.notifyDataSetChanged();
        if (this.bDw != null) {
            this.bDw.onChangeSkinType(i);
            this.bCG.getLayoutMode().h(this.bDA.getView());
        }
        if (this.bDz != null) {
            this.bDz.cs(i);
        }
        if (this.bDA != null) {
            this.bDA.cs(i);
            com.baidu.tbadk.core.util.bc.i(this.afC, com.baidu.tieba.v.pb_foot_more_trans_selector);
            this.bDA.cq(com.baidu.tieba.v.pb_foot_more_trans_selector);
        }
        if (this.bEs != null) {
            this.bEs.cs(i);
            this.bEs.cq(com.baidu.tieba.t.cp_bg_line_e);
            com.baidu.tbadk.core.util.bc.i(this.bEr, com.baidu.tieba.t.cp_bg_line_e);
        }
        if (this.bEf != null) {
            this.bEf.b(this.bCG.getPageContext(), i);
        }
        if (this.bDm != null) {
            this.bDm.ct(i);
        }
        dV(i == 1);
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.akz = sVar;
        this.bDt.setOnImageClickListener(this.akz);
        if (this.bDw != null) {
            this.bDw.setOnImageClickListener(this.akz);
        }
    }

    public void f(com.baidu.tbadk.core.view.ad adVar) {
        this.aDO = adVar;
        if (this.axR != null) {
            this.axR.a(this.aDO);
        }
    }

    public void eb(boolean z) {
        this.bDt.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public View Zl() {
        if (this.bDw == null) {
            return null;
        }
        return this.bDw.aaq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zm() {
        if (this.bCY.mNavigationBar != null) {
            this.bCY.mNavigationBar.setVisibility(8);
        }
        if (this.mListView != null) {
            this.mListView.setVisibility(8);
        }
        if (this.bEf != null) {
            this.bEo = this.bEi.getVisibility() == 0;
            this.bEf.setVisibility(8);
            this.bEi.setVisibility(8);
            this.bEh.setVisibility(8);
        }
    }

    private void Zn() {
        if (this.bCY.mNavigationBar != null) {
            this.bCY.mNavigationBar.setVisibility(0);
        }
        if (this.mListView != null) {
            this.mListView.setVisibility(0);
        }
        if (this.bEf != null) {
            int visibility = this.bDs != null ? this.bDs.getVisibility() : 0;
            if (visibility == 0) {
                if (this.bEo) {
                    this.bEi.setVisibility(visibility);
                    this.bEh.setVisibility(visibility);
                    return;
                }
                this.bEf.setVisibility(visibility);
                return;
            }
            this.bEo = this.bEi.getVisibility() == 0;
            this.bEf.setVisibility(visibility);
            this.bEi.setVisibility(visibility);
            this.bEh.setVisibility(visibility);
        }
    }

    public Button Zo() {
        return this.bEe;
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        if (this.bEf != null) {
            this.bEf.bWk.a(writeImagesInfo, z);
        }
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        if (this.bEf != null) {
            this.bEf.bWk.setBaobaoUris(writeImagesInfo);
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                this.bEf.agf();
            } else {
                this.bEf.agg();
            }
        }
    }

    public void h(com.baidu.tieba.tbadkCore.b.i iVar) {
        if (iVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.b.k> ahk = iVar.ahk();
            if (ahk.size() == 1) {
                com.baidu.tieba.tbadkCore.b.k kVar = ahk.get(0);
                if (kVar.ahE() < kVar.ahx().size()) {
                    this.mListView.setNextPage(null);
                    return;
                } else {
                    this.mListView.setNextPage(this.bDA);
                    return;
                }
            }
            this.mListView.setNextPage(this.bDA);
        }
    }

    public boolean FJ() {
        if (this.bEf == null) {
            return false;
        }
        return this.bEf.FJ();
    }

    public boolean Zp() {
        if (this.bDw == null) {
            return false;
        }
        return this.bDw.FJ();
    }

    public void Zq() {
        if (com.baidu.tbadk.performanceLog.ac.zy().zz()) {
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
                                perfLog.agL = true;
                                perfLog.agK = this.bCG.aDz;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                    }
                                }
                                tbImageView.qF();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(com.baidu.tieba.w.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.v perfLog2 = headImageView.getPerfLog();
                        perfLog2.dX(1001);
                        perfLog2.agL = true;
                        perfLog2.agK = this.bCG.aDz;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                            }
                        }
                        headImageView.qF();
                    }
                }
            }
        }
    }

    public void Zr() {
        if (this.bEi != null) {
            this.bEi.setVisibility(0);
            if (this.bEh != null) {
                this.bEh.setVisibility(0);
            }
        }
    }

    public void Zs() {
        if (this.bEi != null) {
            this.bEi.setVisibility(8);
            if (this.bEh != null) {
                this.bEh.setVisibility(8);
            }
        }
    }
}
