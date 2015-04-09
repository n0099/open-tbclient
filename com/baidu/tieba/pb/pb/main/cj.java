package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.location.BDLocationStatusCodes;
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
import com.baidu.tbadk.game.GameInfoData;
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
public class cj {
    private com.baidu.tbadk.core.view.ae YZ;
    private NoNetworkView aDW;
    private BdTypeListView aKe;
    private View.OnClickListener aLK;
    private View aod;
    private RelativeLayout bEL;
    bg bIA;
    private PbActivity bIT;
    private com.baidu.tieba.pb.b.d bIs;
    private View.OnClickListener bJe;
    private PbListView bLD;
    private View bLF;
    public final com.baidu.tieba.pb.pb.main.b.a bLc;
    private View bLd;
    private ColumnLayout bLf;
    private TextView bLg;
    private TextView bLh;
    private HeadImageView bLi;
    private ImageView bLj;
    private ImageView bLk;
    private UserIconBox bLl;
    private UserIconBox bLm;
    private ImageView bLn;
    private TextView bLo;
    private TextView bLp;
    private View bLt;
    private View bLv;
    private RelativeLayout bLw;
    private bk bLx;
    private PbEditor bMh;
    private com.baidu.tbadk.editortool.v bMi;
    private View bMj;
    private TextView bMk;
    private TextView bMl;
    private boolean bMn;
    private View bMr;
    private LiveBroadcastCard bMs;
    private View bMt;
    private TextView bMu;
    private bf bMy;
    private View bLe = null;
    public FrsPraiseView bLq = null;
    private View bLr = null;
    private View bLs = null;
    private View bLu = null;
    private Dialog bLy = null;
    private com.baidu.tbadk.core.dialog.e aLx = null;
    private com.baidu.tieba.pb.pb.sub.l bLz = null;
    private View bLA = null;
    private EditText bLB = null;
    private com.baidu.tieba.pb.view.c bLC = null;
    private View bLE = null;
    private com.baidu.tbadk.core.dialog.h bhr = null;
    private AbsListView.OnScrollListener bLG = null;
    private com.baidu.adp.widget.ListView.x bLH = null;
    private com.baidu.tbadk.widget.richText.s atd = null;
    private com.baidu.tbadk.core.view.y aJH = null;
    private Dialog bLI = null;
    private com.baidu.tbadk.core.dialog.a bLJ = null;
    private Dialog bLK = null;
    private View bLL = null;
    private int bLM = 0;
    private RadioGroup MK = null;
    private RadioButton bLN = null;
    private RadioButton bLO = null;
    private RadioButton bLP = null;
    private Button bLQ = null;
    private Button bLR = null;
    private TextView bLS = null;
    private Dialog bLT = null;
    private View bLU = null;
    private RadioGroup bLV = null;
    private CompoundButton.OnCheckedChangeListener bLW = null;
    private Button bLX = null;
    private Button bLY = null;
    private String bLZ = null;
    private dh bMa = null;
    private com.baidu.tbadk.core.dialog.e bMb = null;
    private boolean bMc = false;
    private String mForumName = null;
    private boolean bMd = false;
    private int bMe = 0;
    private ScrollView bMf = null;
    private Button bMg = null;
    private boolean bMm = true;
    private LinearLayout bMo = null;
    private View bMp = null;
    private PbListView bMq = null;
    private boolean bJc = false;
    private boolean mIsFromCDN = true;
    private com.baidu.tieba.tbadkCore.b.h bMv = new ck(this);
    public com.baidu.tieba.pb.pb.sub.v bMw = new ct(this);
    private final View.OnClickListener bMx = new da(this);
    private View.OnLongClickListener bMz = null;
    private boolean bMA = false;
    private final List<TbImageView> bMB = new ArrayList();
    private boolean bJb = true;

    public NoNetworkView aaE() {
        return this.aDW;
    }

    public void aaF() {
        this.bMm = true;
        if (this.bMh != null) {
            this.bMh.setVisibility(8);
        }
        if (this.bMj != null) {
            this.bMj.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.c.j aaG() {
        int i;
        View childAt;
        if (this.aKe == null) {
            return null;
        }
        int firstVisiblePosition = this.aKe.getFirstVisiblePosition();
        int lastVisiblePosition = this.aKe.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.aKe.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.aKe.getChildAt(i3 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.aKe.getHeaderViewsCount();
        int i7 = headerViewsCount >= 0 ? headerViewsCount : 0;
        if (this.bLx.hk(i7) != com.baidu.tieba.tbadkCore.c.j.cog) {
            i7++;
        }
        return (com.baidu.tieba.tbadkCore.c.j) this.bLx.aA(i7);
    }

    public cj(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.b.d dVar) {
        this.bIT = null;
        this.bEL = null;
        this.aKe = null;
        this.bLd = null;
        this.bLf = null;
        this.bLg = null;
        this.bLh = null;
        this.bLi = null;
        this.bLj = null;
        this.bLk = null;
        this.bLl = null;
        this.bLm = null;
        this.bLn = null;
        this.bLo = null;
        this.bLp = null;
        this.bLt = null;
        this.bLv = null;
        this.bLx = null;
        this.bLD = null;
        this.aod = null;
        this.aLK = null;
        this.bJe = null;
        this.bMj = null;
        this.bMk = null;
        this.bMl = null;
        this.bMt = null;
        this.bMu = null;
        this.bIT = pbActivity;
        this.aLK = onClickListener;
        this.bIs = dVar;
        this.bEL = (RelativeLayout) com.baidu.adp.lib.g.b.hH().inflate(this.bIT.getPageContext().getPageActivity(), com.baidu.tieba.w.new_pb_activity, null);
        this.bIT.addContentView(this.bEL, new FrameLayout.LayoutParams(-1, -1));
        this.bLw = (RelativeLayout) this.bIT.findViewById(com.baidu.tieba.v.title_wrapper);
        this.aDW = (NoNetworkView) this.bIT.findViewById(com.baidu.tieba.v.view_no_network);
        this.aKe = (BdTypeListView) this.bIT.findViewById(com.baidu.tieba.v.new_pb_list);
        View view = new View(this.bIT.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.bIT.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_editor_height)));
        this.aKe.addFooterView(view);
        this.bLc = new com.baidu.tieba.pb.pb.main.b.a(pbActivity);
        this.bLc.abN().setOnTouchListener(new com.baidu.tieba.pb.b.a(new db(this)));
        this.bMj = this.bIT.findViewById(com.baidu.tieba.v.pb_editor_tool_comment);
        this.bMk = (TextView) this.bIT.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_reply_text);
        this.bMl = (TextView) this.bIT.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_praise_icon);
        this.bMk.setOnClickListener(new dc(this));
        this.bMl.setOnClickListener(this.aLK);
        this.bMl.setOnTouchListener(this.bIT);
        abn();
        this.bLd = com.baidu.adp.lib.g.b.hH().inflate(this.bIT.getPageContext().getPageActivity(), com.baidu.tieba.w.new_pb_header_item, null);
        this.bLf = (ColumnLayout) this.bLd.findViewById(com.baidu.tieba.v.pb_head_owner_root);
        this.bLf.setOnLongClickListener(this.bMz);
        this.bLf.setOnTouchListener(this.bIs);
        this.bLf.setVisibility(8);
        this.bLd.setOnTouchListener(this.bIs);
        this.bLg = (TextView) this.bLd.findViewById(com.baidu.tieba.v.pb_head_post_title);
        this.bLg.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.bLg.setVisibility(8);
        this.bMt = this.bLd.findViewById(com.baidu.tieba.v.pb_head_activity_join_number_container);
        this.bMt.setVisibility(8);
        this.bMu = (TextView) this.bLd.findViewById(com.baidu.tieba.v.pb_head_activity_join_number);
        this.bLh = (TextView) this.bLf.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_name);
        this.bLi = (HeadImageView) this.bLf.findViewById(com.baidu.tieba.v.pb_head_owner_photo);
        if (!this.bJb) {
            this.bLi.setVisibility(8);
        }
        this.bLj = (ImageView) this.bLf.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_rank);
        this.bLk = (ImageView) this.bLf.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_gender);
        this.bLl = (UserIconBox) this.bLf.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_icon);
        this.bLm = (UserIconBox) this.bLf.findViewById(com.baidu.tieba.v.pb_head_owner_info_tshow_icon);
        this.bLn = (ImageView) this.bLf.findViewById(com.baidu.tieba.v.pb_head_owner_info_floor_owner);
        this.bLo = (TextView) this.bLf.findViewById(com.baidu.tieba.v.pb_head_owner_info_time);
        this.bLp = (TextView) this.bLd.findViewById(com.baidu.tieba.v.pb_head_reverse_hint);
        this.bLp.setOnClickListener(this.aLK);
        this.bLp.setVisibility(8);
        this.bLt = this.bLd.findViewById(com.baidu.tieba.v.new_pb_header_item_line_below_livepost);
        this.bLv = this.bLd.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_showpassed);
        this.bLd.setOnLongClickListener(new dd(this));
        aaS();
        this.bLx = new bk(this.bIT, this.aKe);
        this.bLx.v(this.aLK);
        this.bLx.a(this.bIs);
        this.bLx.setOnImageClickListener(this.atd);
        this.bJe = new de(this);
        this.bLx.u(this.bJe);
        this.aKe.addHeaderView(this.bLd);
        this.bLD = new PbListView(this.bIT.getPageContext().getPageActivity());
        this.aod = this.bLD.getView().findViewById(com.baidu.tieba.v.pb_more_view);
        if (this.aod != null) {
            this.aod.setOnClickListener(this.aLK);
            com.baidu.tbadk.core.util.ba.i(this.aod, com.baidu.tieba.u.pb_foot_more_trans_selector);
        }
        this.bLD.tN();
        this.bLD.cr(com.baidu.tieba.u.pb_foot_more_trans_selector);
        this.bLD.cs(com.baidu.tieba.u.pb_foot_more_trans_selector);
        this.bLF = this.bIT.findViewById(com.baidu.tieba.v.viewstub_progress);
    }

    public PbEditor Je() {
        return this.bMh;
    }

    public void aaH() {
        if (this.bMh != null) {
            this.bEL.removeView(this.bMh);
            this.bMh = null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void aaI() {
        if (this.bIT != null) {
            this.bMh = new PbEditor(this.bIT.getPageContext().getPageActivity());
            this.bMh.setOrientation(1);
            this.bMh.setFrom(1);
            this.bMh.aQ(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bEL.addView(this.bMh, layoutParams);
            this.bMh.b(this.bIT.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            aaJ();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void aaJ() {
        if (this.bMh != null) {
            this.bMh.a(this.bIT.getPageContext(), new df(this));
        }
    }

    public void hN(String str) {
    }

    public void z(String str, boolean z) {
        this.bMn = z;
        dQ(TbadkCoreApplication.m411getInst().getSkinType() == 1);
    }

    private void dQ(boolean z) {
        if (this.bMl != null) {
            if (this.bMn) {
                com.baidu.tbadk.core.util.ba.i((View) this.bMl, com.baidu.tieba.u.pb_praise_already_click_selector);
            } else {
                com.baidu.tbadk.core.util.ba.i((View) this.bMl, com.baidu.tieba.u.pb_praise_normal_click_selector);
            }
        }
    }

    public TextView aaK() {
        return this.bMl;
    }

    public void dR(boolean z) {
        if (this.aKe != null) {
            if (!z) {
                this.aKe.setEnabled(z);
            } else {
                this.aKe.postDelayed(new dg(this, z), 10L);
            }
        }
    }

    public void L(View view) {
        boolean z;
        View view2;
        if (this.bLw != null && view != null) {
            if (this.bMm) {
                z = this.bMj.getVisibility() == 0;
            } else {
                z = this.bMh != null && this.bMh.getVisibility() == 0;
            }
            boolean z2 = this.bLw.getVisibility() == 0;
            if (z2) {
                View findViewById = this.bIT.findViewById(com.baidu.tieba.v.bg_above_list);
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.bLw.getHeight()));
                com.baidu.tieba.tbadkCore.a.a(this.bIT, this.bLw, com.baidu.tieba.p.top_fold_up, new cl(this, findViewById));
            } else {
                com.baidu.tieba.tbadkCore.a.a(this.bIT, this.bLw, com.baidu.tieba.p.top_fold_down, new cm(this));
            }
            if (this.bMm) {
                view2 = this.bMj;
            } else {
                view2 = this.bMh;
            }
            if (z) {
                if (z2) {
                    if (this.bMh != null) {
                        this.bMh.amh();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.bIT, view2, com.baidu.tieba.p.bottom_fold_down, new cn(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.bIT, view2, com.baidu.tieba.p.bottom_fold_up, new co(this));
            }
        }
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.bMh == null) {
            return null;
        }
        return this.bMh.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.bMh != null) {
            this.bMh.setAudioData(voiceModel);
        }
    }

    public void Jn() {
        if (this.bMh != null) {
            this.bMh.Jn();
        }
    }

    public void aaL() {
        if (this.bLz != null) {
            this.bLz.abm();
        }
    }

    public com.baidu.tieba.pb.pb.sub.l aaM() {
        return this.bLz;
    }

    public void aaN() {
        if (this.bLz != null) {
            this.bLz.abn();
        }
    }

    public VoiceData.VoiceModel aaO() {
        if (this.bLz != null) {
            return this.bLz.getAudioData();
        }
        return null;
    }

    public void aaP() {
        if (this.bLz != null) {
            this.bLz.Jn();
        }
    }

    public TextView aaQ() {
        if (this.bLz == null || !(this.bLz instanceof com.baidu.tieba.pb.pb.sub.i)) {
            return null;
        }
        return ((com.baidu.tieba.pb.pb.sub.i) this.bLz).acq();
    }

    public bk aaR() {
        return this.bLx;
    }

    public void a(bg bgVar) {
        this.bIA = bgVar;
    }

    private void a(com.baidu.tbadk.core.data.z zVar) {
        if (zVar != null && zVar.qZ() != 0) {
            if (this.bMg == null) {
                this.bIT.getLayoutMode().h(((ViewStub) this.bLd.findViewById(com.baidu.tieba.v.live_talk_layout)).inflate());
                this.bMg = (Button) this.bLd.findViewById(com.baidu.tieba.v.pb_head_function_manage_go_to_live_post);
                this.bLs = this.bLd.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_livepost);
            }
            int ra = zVar.ra();
            String string = this.bIT.getPageContext().getString(com.baidu.tieba.y.go_to_live_post_prefix);
            if (ra == 0) {
                string = String.valueOf(string) + this.bIT.getPageContext().getString(com.baidu.tieba.y.go_to_interview_post);
            } else if (ra == 1) {
                string = String.valueOf(string) + this.bIT.getPageContext().getString(com.baidu.tieba.y.go_to_discuss_post);
            }
            this.bMg.setText(string);
            this.bMg.setVisibility(0);
            this.bMg.setOnClickListener(this.aLK);
            abt();
        }
    }

    private void aaS() {
        this.bMo = (LinearLayout) this.bLd.findViewById(com.baidu.tieba.v.btn_show_passed_pb);
        this.bMq = new PbListView(this.bIT.getPageContext().getPageActivity(), PbListView.IconType.ICON_UP_WARD);
        this.bMp = this.bMq.mN();
        this.bMq.setText(this.bIT.getResources().getString(com.baidu.tieba.y.btn_show_passed_pb));
        this.bMp.setOnClickListener(this.bMx);
        this.bMo.addView(this.bMp);
        this.bMo.requestLayout();
        this.bMo.invalidate();
        com.baidu.tbadk.core.util.ba.i(this.bMp, com.baidu.tieba.s.cp_bg_line_e);
        this.bMq.cr(com.baidu.tieba.s.cp_bg_line_e);
        this.bMq.cs(com.baidu.tieba.s.cp_bg_line_e);
        abt();
    }

    public void M(View view) {
        if (this.bLI == null) {
            this.bLI = new Dialog(this.bIT.getPageContext().getPageActivity(), com.baidu.tieba.z.common_alert_dialog);
            this.bLI.setCanceledOnTouchOutside(true);
            this.bLI.setCancelable(true);
            this.bLI.setContentView(com.baidu.adp.lib.g.b.hH().inflate(this.bIT.getPageContext().getPageActivity(), com.baidu.tieba.w.forum_manage_dialog, null));
            WindowManager.LayoutParams attributes = this.bLI.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.n.M(this.bIT.getPageContext().getPageActivity()) * 0.9d);
            this.bLI.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.bLI.findViewById(com.baidu.tieba.v.del_post_btn);
        Button button2 = (Button) this.bLI.findViewById(com.baidu.tieba.v.forbid_user_btn);
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
                button.setOnClickListener(new cp(this));
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
                sparseArray3.put(com.baidu.tieba.v.tag_forbid_user_post_id, sparseArray.get(com.baidu.tieba.v.tag_forbid_user_post_id));
                button2.setOnClickListener(new cq(this));
            }
            com.baidu.adp.lib.g.k.a(this.bLI, this.bIT.getPageContext());
        }
    }

    public void a(bf bfVar) {
        this.bMy = bfVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(com.baidu.tieba.v.tag_del_post_id, str);
        sparseArray.put(com.baidu.tieba.v.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = com.baidu.tieba.y.del_post_confirm;
        if (i == 0) {
            i3 = com.baidu.tieba.y.del_thread_confirm;
        }
        this.bLJ = new com.baidu.tbadk.core.dialog.a(this.bIT.getActivity());
        this.bLJ.bw(com.baidu.tieba.y.del_post_tip);
        this.bLJ.bx(i3);
        this.bLJ.v(sparseArray);
        this.bLJ.a(com.baidu.tieba.y.dialog_ok, this.bIT);
        this.bLJ.b(com.baidu.tieba.y.dialog_cancel, new cr(this));
        this.bLJ.ac(true);
        this.bLJ.b(this.bIT.getPageContext());
        this.bLJ.re();
    }

    public void N(ArrayList<com.baidu.tbadk.core.data.l> arrayList) {
        if (this.bLT == null) {
            this.bLT = new Dialog(this.bIT.getPageContext().getPageActivity(), com.baidu.tieba.z.common_alert_dialog);
            this.bLT.setCanceledOnTouchOutside(true);
            this.bLT.setCancelable(true);
            this.bLU = com.baidu.adp.lib.g.b.hH().inflate(this.bIT.getPageContext().getPageActivity(), com.baidu.tieba.w.commit_good, null);
            this.bMf = (ScrollView) this.bLU.findViewById(com.baidu.tieba.v.good_scroll);
            this.bLT.setContentView(this.bLU);
            WindowManager.LayoutParams attributes = this.bLT.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.n.M(this.bIT.getPageContext().getPageActivity()) * 0.9d);
            this.bLT.getWindow().setAttributes(attributes);
            this.bLW = new cs(this);
            this.bLV = (RadioGroup) this.bLU.findViewById(com.baidu.tieba.v.good_class_group);
            this.bLY = (Button) this.bLU.findViewById(com.baidu.tieba.v.dialog_button_cancel);
            this.bLY.setOnClickListener(new cu(this));
            this.bLX = (Button) this.bLU.findViewById(com.baidu.tieba.v.dialog_button_ok);
            this.bLX.setOnClickListener(this.aLK);
        }
        this.bLV.removeAllViews();
        RadioButton radioButton = (RadioButton) com.baidu.adp.lib.g.b.hH().inflate(this.bIT.getPageContext().getPageActivity(), com.baidu.tieba.w.good_class_radio_button, null);
        radioButton.setTag(GameInfoData.NOT_FROM_DETAIL);
        radioButton.setText(this.bIT.getPageContext().getString(com.baidu.tieba.y.def_good_class));
        radioButton.setOnCheckedChangeListener(this.bLW);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(com.baidu.adp.lib.util.n.dip2px(this.bIT.getPageContext().getPageActivity(), 10.0f), com.baidu.adp.lib.util.n.dip2px(this.bIT.getPageContext().getPageActivity(), 5.0f), com.baidu.adp.lib.util.n.dip2px(this.bIT.getPageContext().getPageActivity(), 10.0f), com.baidu.adp.lib.util.n.dip2px(this.bIT.getPageContext().getPageActivity(), 5.0f));
        this.bLV.addView(radioButton, layoutParams);
        this.bLV.requestLayout();
        this.bLV.check(radioButton.getId());
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                RadioButton radioButton2 = (RadioButton) com.baidu.adp.lib.g.b.hH().inflate(this.bIT.getPageContext().getPageActivity(), com.baidu.tieba.w.good_class_radio_button, null);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).qc()));
                radioButton2.setText(arrayList.get(i2).qb());
                radioButton2.setOnCheckedChangeListener(this.bLW);
                this.bLV.addView(radioButton2, layoutParams);
                this.bLV.requestLayout();
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bMf.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.n.dip2px(this.bIT.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.n.dip2px(this.bIT.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.n.dip2px(this.bIT.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.bMf.setLayoutParams(layoutParams2);
            this.bMf.removeAllViews();
            this.bMf.addView(this.bLV);
        }
        com.baidu.adp.lib.g.k.a(this.bLT, this.bIT.getPageContext());
    }

    public void aaT() {
        this.bIT.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.bIT.hideProgressBar();
        if (z && z2) {
            this.bIT.showToast(this.bIT.getPageContext().getString(com.baidu.tieba.y.success));
        } else if (str != null && z2) {
            this.bIT.showToast(str);
        }
    }

    public void RQ() {
        this.bLF.setVisibility(0);
    }

    public void RP() {
        this.bLF.setVisibility(8);
    }

    public View aaU() {
        if (this.bLU != null) {
            return this.bLU.findViewById(com.baidu.tieba.v.dialog_button_ok);
        }
        return null;
    }

    public String aaV() {
        return this.bLZ;
    }

    public View aaW() {
        if (this.bLz != null) {
            return this.bLz.acF();
        }
        return null;
    }

    public View getView() {
        return this.bEL;
    }

    public void aaX() {
        View editText;
        if (this.bMh == null) {
            editText = this.bIT.getCurrentFocus();
        } else {
            editText = this.bMh.getEditText();
        }
        com.baidu.adp.lib.util.n.c(this.bIT.getPageContext().getPageActivity(), editText);
    }

    public void Jk() {
        if (this.bLz != null) {
            this.bLz.acH();
        } else {
            this.bIT.showProgressBar();
        }
    }

    public void bK(boolean z) {
        if (this.bLz != null) {
            this.bLz.acI();
        } else {
            this.bIT.hideProgressBar();
        }
        abC();
        if (z) {
            if (this.bMh != null) {
                this.bMh.getEditText().setText("");
                this.bMh.amd();
                this.bMh.clearData();
            }
            if (this.bLz != null) {
                this.bLz.clearContent();
            }
        }
    }

    public void aaY() {
        this.bLD.startLoadData();
    }

    public void aaZ() {
    }

    public void aba() {
        this.bIT.hideProgressBar();
        this.bLD.tO();
        this.bMq.tO();
        this.aKe.mW();
        abt();
    }

    public void abb() {
        this.aKe.mW();
        this.bMo.setVisibility(8);
        abt();
    }

    public void dS(boolean z) {
        if (!z) {
            if (this.bMh != null) {
                this.bMh.amf();
            }
        } else if (this.bLz != null) {
            this.bLz.hT(null);
        }
    }

    public void abc() {
        if (abg() && this.bLz != null) {
            this.bLz.acy();
        }
    }

    public void abd() {
        if (this.bLz == null) {
            this.bLz = new com.baidu.tieba.pb.pb.sub.l(this.bIT, this.bMA, this.aLK, this.bJe, this.bIT.bIm.bML, this.bIT.bIm.bMM, this.bIT.bIm.bMN);
            this.bLz.setOnActionListener(this.bMi);
            this.bLz.setOnScrollListener(this.bLG);
            this.bLz.e(this.bLH);
            this.bLz.dH(this.bLx.ZT());
            this.bLz.dI(this.bLx.ZU());
            this.bLE = this.bLz.getRootView();
            this.bLz.setOnImageClickListener(this.atd);
            this.bLz.setOnEmotionClickListener(this.bIT.bIm.bMO);
            this.bLz.setOnLongClickListener(this.bLx.ZV());
        }
        this.bLE.setVisibility(0);
        this.bLz.eb(this.mIsFromCDN);
        this.bLz.aaX();
        this.bEL.addView(this.bLE);
        abG();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            this.bMi = vVar;
            if (this.bMh != null) {
                aaJ();
            }
            if (this.bLz != null) {
                this.bLz.setOnActionListener(vVar);
            }
        }
    }

    public void a(dh dhVar) {
        this.bMa = dhVar;
    }

    public void a(boolean z, com.baidu.tieba.pb.a.c cVar, boolean z2, String str, String str2, View view, int i) {
        if (cVar != null && view != null) {
            TiebaStatic.eventStat(this.bIT.getPageContext().getPageActivity(), "pb_tosubpb", "pbclick", 1, new Object[0]);
            if (this.bLz == null) {
                this.bLz = new com.baidu.tieba.pb.pb.sub.l(this.bIT, this.bMA, this.aLK, this.bJe, this.bIT.bIm.bML, this.bIT.bIm.bMM, this.bIT.bIm.bMN);
                this.bLz.setOnActionListener(this.bMi);
                this.bLz.setOnScrollListener(this.bLG);
                this.bLz.e(this.bLH);
                this.bLz.dH(this.bLx.ZT());
                this.bLz.dI(this.bLx.ZU());
                this.bLE = this.bLz.getRootView();
                this.bLz.setOnImageClickListener(this.atd);
                this.bLz.setOnEmotionClickListener(this.bIT.bIm.bMO);
                this.bLz.setOnLongClickListener(this.bLx.ZV());
            }
            this.bLz.hv(this.bLx.getWidth());
            this.bLz.a(cVar, i);
            this.bLz.eb(this.mIsFromCDN);
            this.bLz.a(this.bMw);
            if (cVar.Zj() != null) {
                this.bMe = cVar.Zj().amP();
            } else {
                this.bMe = 0;
            }
            if (str2 != null && !str2.equals("")) {
                this.bLz.hV(str2);
            } else {
                this.bLz.setPosition(1);
            }
            if (!z) {
                this.bLz.acB();
            }
            this.bLE.setVisibility(0);
            if (this.bLE.getParent() == this.bEL) {
                this.bEL.removeView(this.bLE);
            }
            abG();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, com.baidu.tieba.v.title_wrapper);
            this.bEL.addView(this.bLE, layoutParams);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.bIT.getPageContext().getPageActivity(), com.baidu.tieba.p.in_from_right);
            loadAnimation.setAnimationListener(new cv(this, cVar, z, str, str2));
            this.bLE.setAnimation(loadAnimation);
            loadAnimation.start();
        }
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.bMz = onLongClickListener;
        this.bLx.setOnLongClickListener(onLongClickListener);
        if (this.bLz != null) {
            this.bLz.setOnLongClickListener(onLongClickListener);
        }
    }

    public void abe() {
        if (abg()) {
            this.bLz.acC();
        }
    }

    public void abf() {
        if (abg() && (this.bLz instanceof com.baidu.tieba.pb.pb.sub.i)) {
            ((com.baidu.tieba.pb.pb.sub.i) this.bLz).act();
        }
    }

    public boolean abg() {
        return (this.bLE == null || this.bLE.getVisibility() == 8) ? false : true;
    }

    public void abh() {
        if (this.bLE != null) {
            this.bLE.setVisibility(8);
            this.bEL.removeView(this.bLE);
            this.bLz.MJ();
        }
        abC();
        abH();
    }

    public void abi() {
        if (this.bLE != null) {
            if (this.bEL != null) {
                this.bEL.removeView(this.bLE);
            }
            this.bLE = null;
        }
        if (this.bLz != null) {
            this.bLz.MJ();
            this.bLz = null;
        }
    }

    public void abj() {
        if (this.bLz != null) {
            this.bLz.acJ();
            if (this.bLz instanceof com.baidu.tieba.pb.pb.sub.i) {
                ((com.baidu.tieba.pb.pb.sub.i) this.bLz).acu();
            }
        }
    }

    public void abk() {
        if (this.bLz != null) {
            this.bLz.acJ();
        }
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i) {
        if (this.bLz != null) {
            this.bLz.acJ();
            this.bLz.hv(this.bLx.getWidth());
            this.bLz.a(cVar, i);
        }
    }

    public void abl() {
        if (this.bLz == null) {
            this.bLz = new com.baidu.tieba.pb.pb.sub.i(this.bIT, this.bMA, this.aLK, this.bJe, this.bIT.bIm.bML, this.bIT.bIm.bMM, this.bIT.bIm.bMN);
            this.bLz.setOnActionListener(this.bMi);
            this.bLz.setOnScrollListener(this.bLG);
            this.bLz.e(this.bLH);
            this.bLz.dH(this.bLx.ZT());
            this.bLz.dI(this.bLx.ZU());
            this.bLE = this.bLz.getRootView();
            this.bLz.setOnImageClickListener(this.atd);
            this.bLz.setOnEmotionClickListener(this.bIT.bIm.bMO);
            this.bLz.setOnLongClickListener(this.bLx.ZV());
        }
        this.bLE.setVisibility(0);
        this.bLz.aaX();
        this.bEL.addView(this.bLE);
        abG();
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i, String str, boolean z, boolean z2) {
        if (this.bLz != null && (this.bLz instanceof com.baidu.tieba.pb.pb.sub.i)) {
            com.baidu.tieba.pb.pb.sub.i iVar = (com.baidu.tieba.pb.pb.sub.i) this.bLz;
            this.bLz.acJ();
            this.bLz.hv(this.bLx.getWidth());
            this.bLz.a(cVar, i);
            if (z2) {
                iVar.hS(str);
            }
            if (!z) {
                iVar.acv();
            } else {
                iVar.acw();
            }
        }
    }

    public void v(ArrayList<String> arrayList) {
        if (this.bMh != null) {
            this.bMh.v(arrayList);
        }
    }

    public void O(ArrayList<String> arrayList) {
        if (this.bLz != null) {
            this.bLz.v(arrayList);
        }
    }

    public void abm() {
        this.bMA = true;
        if (this.bMh != null) {
            this.bMh.abm();
        }
    }

    public void abn() {
        this.bMA = false;
        if (this.bMh != null) {
            this.bMh.abn();
        }
    }

    public void a(com.baidu.tbadk.core.dialog.h hVar, boolean z, boolean z2) {
        if (this.bMb != null) {
            this.bMb.dismiss();
            this.bMb = null;
        }
        this.bMb = new com.baidu.tbadk.core.dialog.e(this.bIT.getPageContext().getPageActivity());
        this.bMb.by(com.baidu.tieba.y.operation);
        if (z2) {
            this.bMb.a(new String[]{this.bIT.getPageContext().getString(com.baidu.tieba.y.copy)}, hVar);
        } else if (!z) {
            this.bMb.a(new String[]{this.bIT.getPageContext().getString(com.baidu.tieba.y.copy), this.bIT.getPageContext().getString(com.baidu.tieba.y.mark)}, hVar);
        } else {
            this.bMb.a(new String[]{this.bIT.getPageContext().getString(com.baidu.tieba.y.copy), this.bIT.getPageContext().getString(com.baidu.tieba.y.remove_mark)}, hVar);
        }
        this.bMb.d(this.bIT.getPageContext());
        this.bMb.rg();
    }

    public void setAudioFocusable(boolean z) {
        if (this.bMh != null) {
            this.bMh.setAudioFocusable(z);
        }
    }

    public void dT(boolean z) {
        if (this.bLz != null) {
            this.bLz.setAudioFocusable(z);
        }
    }

    public void k(Bitmap bitmap) {
        if (this.bMh != null) {
            this.bMh.k(bitmap);
            this.bMh.amc();
        }
    }

    public void abo() {
        if (this.bMh != null) {
            this.bMh.k(null);
        }
    }

    public int abp() {
        int firstVisiblePosition = this.aKe.getFirstVisiblePosition();
        com.baidu.adp.widget.ListView.g gVar = (com.baidu.adp.widget.ListView.g) this.aKe.getAdapter();
        if (gVar != null) {
            if (gVar.getItem(firstVisiblePosition) instanceof com.baidu.tieba.pb.a.a) {
                firstVisiblePosition++;
            }
            int headersCount = (this.aKe.getAdapter() == null || !(this.aKe.getAdapter() instanceof com.baidu.adp.widget.ListView.g)) ? 0 : ((com.baidu.adp.widget.ListView.g) this.aKe.getAdapter()).getHeadersCount();
            return firstVisiblePosition > headersCount ? firstVisiblePosition - headersCount : 0;
        }
        return firstVisiblePosition;
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.bLB.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public String Jl() {
        return this.bMh == null ? "" : this.bMh.getContent();
    }

    public void fJ(String str) {
        if (this.bMh != null) {
            this.bMh.setContent(str);
        }
    }

    public String abq() {
        if (this.bLz == null) {
            return null;
        }
        return this.bLz.acG();
    }

    public String abr() {
        if (this.bLz != null) {
            return this.bLz.acD();
        }
        return null;
    }

    public String abs() {
        if (this.bLz != null) {
            return this.bLz.acz();
        }
        return null;
    }

    public void e(com.baidu.tieba.pb.a.b bVar) {
        this.bLx.b(bVar);
        this.bLx.notifyDataSetChanged();
        if (bVar == null) {
            hN("");
        } else {
            hN(com.baidu.tbadk.core.util.bd.p(bVar.Zb().getReply_num()));
        }
        abt();
    }

    public void f(com.baidu.tieba.pb.a.b bVar) {
        PraiseData praise;
        if (this.bLq == null) {
            this.bIT.getLayoutMode().h(((ViewStub) this.bLd.findViewById(com.baidu.tieba.v.praise_layout)).inflate());
            this.bLq = (FrsPraiseView) this.bLd.findViewById(com.baidu.tieba.v.pb_head_praise_view);
            this.bLq.setIsFromPb(true);
            this.bLu = this.bLd.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_praise);
            this.bLq.cu(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.bLq != null) {
            boolean abt = abt();
            if (bVar != null && bVar.Zc() != null && bVar.Zc().size() > 0) {
                com.baidu.tieba.tbadkCore.c.j jVar = bVar.Zc().get(0);
                if ((!this.bJc || jVar.amP() != 1) && (praise = bVar.Zb().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.bLq.setVisibility(0);
                    this.bLq.setIsFromPb(true);
                    this.bLq.a(praise, bVar.Zb().getId(), praise.getPostId(), true);
                    this.bLu.setVisibility(0);
                    if (this.bLq.getVisibility() == 0) {
                        this.bLv.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.bLq.setVisibility(8);
            this.bLu.setVisibility(8);
            if (bVar != null && bVar.XQ() != null && bVar.XQ().qm() == 0 && this.bJc) {
                this.bLu.setVisibility(8);
                if (abt) {
                    this.bLt.setVisibility(0);
                    return;
                } else {
                    this.bLt.setVisibility(8);
                    return;
                }
            }
            this.bLu.setVisibility(0);
            this.bLt.setVisibility(8);
        }
    }

    private com.baidu.tieba.tbadkCore.c.j a(com.baidu.tieba.pb.a.b bVar, boolean z, int i) {
        if (z) {
            if (bVar == null || bVar.Zc() == null || bVar.Zc().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.c.j jVar = bVar.Zc().get(0);
            if (jVar.amP() != 1) {
                return g(bVar);
            }
            return jVar;
        }
        return g(bVar);
    }

    private com.baidu.tieba.tbadkCore.c.j g(com.baidu.tieba.pb.a.b bVar) {
        MetaData metaData;
        if (bVar == null || bVar.Zb() == null || bVar.Zb().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.c.j jVar = new com.baidu.tieba.tbadkCore.c.j();
        MetaData author = bVar.Zb().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = bVar.Zb().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        jVar.iu(1);
        jVar.setId(bVar.Zb().qM());
        jVar.setTitle(bVar.Zb().getTitle());
        jVar.setTime(bVar.Zb().getCreateTime());
        jVar.a(metaData);
        return jVar;
    }

    private void b(com.baidu.tieba.pb.a.b bVar, boolean z, int i) {
        this.bLf.setVisibility(8);
        com.baidu.tieba.tbadkCore.c.j a = a(bVar, z, i);
        if (a != null) {
            if (z) {
                this.bLp.setVisibility(8);
            } else {
                this.bLp.setVisibility(0);
            }
            this.bLf.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.bLf.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.bLf.setTag(sparseArray);
            }
            sparseArray.put(com.baidu.tieba.v.tag_clip_board, a);
            sparseArray.put(com.baidu.tieba.v.tag_is_subpb, false);
            this.bLo.setText(com.baidu.tbadk.core.util.bd.n(a.getTime()));
            bVar.Zb().qS();
            this.bLg.setVisibility(0);
            this.bLg.setText(bVar.Zb().getSpan_str());
            f(bVar);
            ArrayList<com.baidu.tbadk.core.data.b> qJ = bVar.Zb().qJ();
            if (qJ != null && qJ.size() > 0) {
                this.bMu.setText(String.valueOf(qJ.get(0).pN()));
                this.bMt.setVisibility(0);
            } else {
                this.bMt.setVisibility(8);
            }
            com.baidu.tbadk.core.util.ba.i(this.bMt, com.baidu.tieba.u.activity_join_num_bg);
            com.baidu.tbadk.core.util.ba.b(this.bMu, com.baidu.tieba.s.cp_link_tip_d, 1);
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
            if (bVar.Zb().getAnchorInfoData().getGroup_id() != 0 && appResponseToIntentClass) {
                if (this.bMr == null) {
                    BdLog.e("pb time   liveCardLayout new");
                    this.bMr = ((ViewStub) this.bLd.findViewById(com.baidu.tieba.v.live_card_layout)).inflate();
                    this.bIT.getLayoutMode().h(this.bMr);
                    this.bMs = (LiveBroadcastCard) this.bLd.findViewById(com.baidu.tieba.v.item_card);
                }
                this.bMr.setVisibility(0);
                LiveCardData liveCardData = new LiveCardData();
                liveCardData.setPublisherId(bVar.Zb().getAnchorInfoData().getAuthorId());
                liveCardData.setPublisherName(bVar.Zb().getAnchorInfoData().getAuthorName());
                liveCardData.setPublisherPortrait(bVar.Zb().getAnchorInfoData().getPublisherPortrait());
                liveCardData.setGroupId(bVar.Zb().getAnchorInfoData().getGroup_id());
                liveCardData.setIntro(bVar.Zb().getAnchorInfoData().getIntro());
                liveCardData.setLikers(bVar.Zb().getAnchorInfoData().getLikers());
                liveCardData.setListeners(bVar.Zb().getAnchorInfoData().getListeners());
                liveCardData.setName(bVar.Zb().getAnchorInfoData().getName());
                liveCardData.setPortrait(bVar.Zb().getAnchorInfoData().getPortrait());
                liveCardData.setStatus(bVar.Zb().getAnchorInfoData().getStatus());
                liveCardData.setStartTime(bVar.Zb().getAnchorInfoData().getStartTime());
                this.bMs.setData(liveCardData);
                this.bMs.setStatisticsKey("notice_pb_live");
            } else if (this.bMr != null) {
                this.bMr.setVisibility(8);
            }
            String userId = bVar.Zb().getAuthor().getUserId();
            if (userId != null && !userId.equals(GameInfoData.NOT_FROM_DETAIL) && userId.equals(a.getAuthor().getUserId())) {
                this.bLn.setVisibility(0);
            } else {
                this.bLn.setVisibility(8);
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.bLj.setVisibility(0);
                    com.baidu.tbadk.core.util.ba.c(this.bLj, com.baidu.tbadk.core.util.c.bQ(level_id));
                    i2 = 2;
                    this.bLj.setOnClickListener(null);
                } else {
                    this.bLj.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.ba.c(this.bLj, com.baidu.tieba.u.pb_manager);
                        this.bLj.setOnClickListener(this.bIT.bIm.bMM);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.ba.c(this.bLj, com.baidu.tieba.u.pb_assist);
                        this.bLj.setOnClickListener(this.bIT.bIm.bMM);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.ba.c(this.bLk, com.baidu.tieba.u.icon_pop_girl_square);
                    this.bLk.setVisibility(0);
                } else {
                    this.bLk.setVisibility(8);
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfo = a.getAuthor().getTShowInfo();
                if (this.bLl != null) {
                    this.bLl.setOnClickListener(this.bIT.bIm.bMM);
                    this.bLl.a(iconInfo, i2, this.bIT.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_width), this.bIT.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_height), this.bIT.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_margin));
                }
                if (this.bLm != null) {
                    this.bLm.setOnClickListener(this.bIT.bIm.bMN);
                    this.bLm.a(tShowInfo, 3, this.bIT.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.bIT.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.bIT.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                }
                this.bLh.setText(a.getAuthor().getName_show());
                this.bLh.setTag(com.baidu.tieba.v.tag_user_id, a.getAuthor().getUserId());
                this.bLh.setTag(com.baidu.tieba.v.tag_user_name, a.getAuthor().getName_show());
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.ba.b(this.bLh, com.baidu.tieba.s.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ba.b(this.bLh, com.baidu.tieba.s.cp_cont_f, 1);
                }
                if (!this.bJb) {
                    this.bLi.setVisibility(8);
                }
                this.bLi.setUserId(a.getAuthor().getUserId());
                this.bLi.setUserName(a.getAuthor().getUserName());
                this.bLi.setImageDrawable(null);
                this.bLi.setTag(a.getAuthor().getUserId());
                this.bLh.setOnClickListener(this.bIT.bIm.bML);
                this.bLi.setOnClickListener(this.bIT.bIm.bML);
                this.bLi.c(a.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.b bVar, int i, int i2, boolean z, int i3) {
        Parcelable aax;
        Parcelable aax2;
        String sb;
        if (bVar != null) {
            this.bJc = z;
            aba();
            b(bVar, z, i);
            this.bLx.dJ(this.bJc);
            this.bLx.b(bVar);
            this.bLx.notifyDataSetChanged();
            if (bVar.Za() != null) {
                this.mForumName = bVar.Za().getName();
            }
            this.bLc.hO(this.mForumName);
            if (bVar.Zb() != null) {
                hN(com.baidu.tbadk.core.util.bd.p(bVar.Zb().getReply_num()));
                if (bVar.Zb().getPraise() != null) {
                    if (bVar.Zb().getPraise().getNum() < 1) {
                        sb = this.bIT.getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(bVar.Zb().getPraise().getNum())).toString();
                    }
                    z(sb, bVar.Zb().getPraise().getIsLike() == 1);
                }
            }
            if (bVar.XQ().ql() == 0 && !z) {
                this.aKe.setNextPage(null);
            } else {
                this.aKe.setNextPage(this.bLD);
                this.bMq.tO();
            }
            if (bVar.XQ().qm() == 0 && z) {
                this.aKe.setPullRefresh(null);
                this.bMo.setVisibility(8);
            } else {
                if (this.bLC == null) {
                    this.bLC = new com.baidu.tieba.pb.view.c(this.bIT.getPageContext());
                    this.bLC.mN();
                    this.bLC.a(this.YZ);
                }
                this.aKe.setPullRefresh(this.bLC);
                if (this.bLC != null) {
                    this.bLC.ct(TbadkCoreApplication.m411getInst().getSkinType());
                }
                this.bMo.setVisibility(0);
                this.bMq.tO();
            }
            abt();
            if (bVar.XQ().ql() == 0) {
                this.bLD.setText(this.bIT.getResources().getString(com.baidu.tieba.y.list_no_more));
                h(bVar);
            } else {
                this.bLD.setText(this.bIT.getResources().getString(com.baidu.tieba.y.pb_load_more));
            }
            if (z) {
                this.bMq.setText(this.bIT.getResources().getString(com.baidu.tieba.y.btn_show_passed_pb));
            } else {
                this.bMq.setText(this.bIT.getResources().getString(com.baidu.tieba.y.btn_show_passed_pb_aftre));
            }
            if (bVar.Zb() != null && bVar.Zb().getAuthor() != null && bVar.Zb().getAuthor().getType() == 0) {
                this.bLc.abO();
            }
            switch (i) {
                case 2:
                    this.aKe.setSelection(i2);
                    if (this.bLe != null) {
                        CompatibleUtile.scrollListViewBy(this.aKe, -this.bLe.getHeight(), 0);
                        return;
                    }
                    return;
                case 3:
                    if (i3 == 1 && (aax2 = ce.aaw().aax()) != null) {
                        this.aKe.onRestoreInstanceState(aax2);
                        return;
                    } else {
                        this.aKe.setSelection(0);
                        return;
                    }
                case 4:
                    if (z) {
                        this.aKe.setSelection(0);
                        return;
                    } else if (bVar.Zc() != null) {
                        if (bVar.XQ() != null && bVar.XQ().qm() != 0) {
                            this.aKe.setSelection(bVar.Zc().size() + 1);
                            return;
                        } else {
                            this.aKe.setSelection(bVar.Zc().size());
                            return;
                        }
                    } else {
                        return;
                    }
                case 5:
                    this.aKe.setSelection(0);
                    return;
                case 6:
                    if (i3 == 1 && (aax = ce.aaw().aax()) != null) {
                        this.aKe.onRestoreInstanceState(aax);
                        return;
                    } else if (z) {
                        this.aKe.setSelection(0);
                        return;
                    } else if (bVar.Zc() != null) {
                        if (bVar.XQ() != null && bVar.XQ().qm() != 0) {
                            this.aKe.setSelection(bVar.Zc().size() + 1);
                            return;
                        } else {
                            this.aKe.setSelection(bVar.Zc().size());
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

    public void dU(boolean z) {
        this.bMc = z;
        this.bLc.dU(z);
    }

    public void tO() {
        if (this.bLD != null) {
            this.bLD.tO();
        }
        if (this.bMq != null) {
            this.bMq.tO();
        }
    }

    public void Kh() {
        this.aKe.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abt() {
        boolean z;
        boolean z2 = true;
        if (this.bLe != null && this.bLe.getVisibility() == 0) {
            if (this.bLr != null) {
                this.bLr.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.bLr != null) {
                this.bLr.setVisibility(8);
            }
            z = false;
        }
        if (this.bMg != null && this.bMg.getVisibility() == 0) {
            if (this.bLs != null) {
                this.bLs.setVisibility(0);
            }
        } else {
            if (this.bLs != null) {
                this.bLs.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.bLu == null || this.bLu.getVisibility() == 8) && z2 && this.bJc) {
            this.bLt.setVisibility(0);
        } else {
            this.bLt.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.pb.a.b bVar, boolean z, boolean z2) {
        if (bVar == null) {
            return false;
        }
        if (this.bLg != null) {
            if (bVar.Zb().qL() == 0) {
                this.bLg.setVisibility(0);
                bVar.Zb().qS();
                this.bLg.setText(bVar.Zb().getSpan_str());
            } else {
                this.bLg.setVisibility(8);
            }
        }
        if (z) {
            if (this.bMr != null) {
                this.bMr.findViewById(com.baidu.tieba.v.pb_head_live_blank).setVisibility(8);
            }
        } else if (this.bMr != null) {
            this.bMr.findViewById(com.baidu.tieba.v.pb_head_live_blank).setVisibility(0);
        }
        this.bJc = z;
        com.baidu.tbadk.core.data.w Zb = bVar.Zb();
        if (Zb != null) {
            a(Zb.qD());
        }
        if (bVar.Ze() == 1) {
            abu();
            Button button = (Button) this.bLd.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.bLd.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.bLd.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.bLd.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.aLK);
            button2.setOnClickListener(this.aLK);
            button3.setOnClickListener(this.aLK);
            button4.setOnClickListener(this.aLK);
            if (bVar.Zb().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (bVar.Zb().getIs_top() == 1) {
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

    private void abu() {
        if (this.bLe == null) {
            this.bLe = ((ViewStub) this.bLd.findViewById(com.baidu.tieba.v.pb_header_function_manage)).inflate();
            this.bIT.getLayoutMode().h(this.bLe);
            this.bLr = this.bLd.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_manage);
            return;
        }
        this.bLe.setVisibility(0);
    }

    public void a(com.baidu.tieba.pb.a.b bVar, boolean z, boolean z2, int i) {
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (bVar != null) {
            a(bVar, z, z2);
            com.baidu.tieba.tbadkCore.c.j a = a(bVar, z, i);
            if (a != null) {
                if (bVar.Ze() != 0 && a.getAuthor() != null) {
                    String userId2 = a.getAuthor().getUserId();
                    boolean z6 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
                    if (userId2 == null || userId2.equals(GameInfoData.NOT_FROM_DETAIL) || userId2.length() == 0) {
                        z3 = false;
                        z4 = true;
                        z5 = false;
                    } else {
                        z4 = true;
                        z5 = z6;
                        z3 = false;
                    }
                } else {
                    String userId3 = bVar.Zb().getAuthor().getUserId();
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
                        sparseArray.put(com.baidu.tieba.v.tag_forbid_user_name, a.getAuthor().getUserName());
                        sparseArray.put(com.baidu.tieba.v.tag_forbid_user_post_id, a.getId());
                    }
                    sparseArray.put(com.baidu.tieba.v.tag_del_post_id, a.getId());
                    sparseArray.put(com.baidu.tieba.v.tag_del_post_type, 0);
                    sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(bVar.Ze()));
                    sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, true);
                    a(com.baidu.tieba.y.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(com.baidu.tieba.v.tag_del_post_id, a.getId());
                    sparseArray2.put(com.baidu.tieba.v.tag_del_post_type, 0);
                    sparseArray2.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(bVar.Ze()));
                    sparseArray2.put(com.baidu.tieba.v.tag_should_manage_visible, false);
                    a(com.baidu.tieba.y.delete, sparseArray2);
                }
            }
            abt();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        abu();
        Button button = (Button) this.bLd.findViewById(com.baidu.tieba.v.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.aLK);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.aod;
    }

    public BdListView getListView() {
        return this.aKe;
    }

    public int abv() {
        return com.baidu.tieba.v.richText;
    }

    public int Ko() {
        return com.baidu.tieba.v.user_icon_box;
    }

    public Button abw() {
        return (Button) this.bLd.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_good);
    }

    public Button abx() {
        return (Button) this.bLd.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_good);
    }

    public Button aby() {
        return (Button) this.bLd.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_top);
    }

    public Button abz() {
        return (Button) this.bLd.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_top);
    }

    public View abA() {
        if (this.bLz == null) {
            return null;
        }
        return this.bLz.acE();
    }

    public void c(com.baidu.adp.widget.ListView.x xVar) {
        this.aKe.setOnSrollToBottomListener(xVar);
    }

    public void a(com.baidu.adp.widget.ListView.aa aaVar) {
        this.aKe.setOnSrollToTopListener(aaVar);
    }

    public void b(com.baidu.tbadk.core.dialog.h hVar) {
        this.bhr = hVar;
    }

    public void a(com.baidu.tbadk.core.view.ae aeVar) {
        this.YZ = aeVar;
        if (this.bLC != null) {
            this.bLC.a(aeVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        if (qVar != null) {
            int qj = qVar.qj();
            int qh = qVar.qh();
            if (this.bLy == null) {
                this.bLy = new Dialog(this.bIT.getPageContext().getPageActivity(), com.baidu.tieba.z.common_alert_dialog);
                this.bLy.setCanceledOnTouchOutside(true);
                this.bLy.setCancelable(true);
                this.bLA = com.baidu.adp.lib.g.b.hH().inflate(this.bIT.getPageContext().getPageActivity(), com.baidu.tieba.w.dialog_direct_pager, null);
                this.bLy.setContentView(this.bLA);
                WindowManager.LayoutParams attributes = this.bLy.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = com.baidu.adp.lib.util.n.dip2px(this.bIT.getPageContext().getPageActivity(), 54.0f);
                attributes.width = (int) (com.baidu.adp.lib.util.n.M(this.bIT.getPageContext().getPageActivity()) * 0.9d);
                this.bLy.getWindow().setAttributes(attributes);
                this.bLy.setOnKeyListener(new cw(this));
                this.bLy.setOnDismissListener(new cx(this));
            }
            com.baidu.adp.lib.g.k.a(this.bLy, this.bIT.getPageContext());
            ((Button) this.bLA.findViewById(com.baidu.tieba.v.dialog_button_ok)).setOnClickListener(this.aLK);
            ((Button) this.bLA.findViewById(com.baidu.tieba.v.dialog_button_cancel)).setOnClickListener(this.aLK);
            this.bLB = (EditText) this.bLA.findViewById(com.baidu.tieba.v.input_page_number);
            this.bLB.setText("");
            this.bLB.setOnFocusChangeListener(new cz(this));
            TextView textView = (TextView) this.bLA.findViewById(com.baidu.tieba.v.current_page_number);
            if (qj <= 0) {
                qj = 1;
            }
            textView.setText(MessageFormat.format(this.bIT.getApplicationContext().getResources().getString(com.baidu.tieba.y.current_page), Integer.valueOf(qj), Integer.valueOf(qh <= 0 ? 1 : qh)));
            this.bIT.ShowSoftKeyPadDelay(this.bLB, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aKe.setOnScrollListener(onScrollListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.bLG = onScrollListener;
    }

    public void d(com.baidu.adp.widget.ListView.x xVar) {
        this.bLH = xVar;
    }

    public void showToast(String str) {
        this.bIT.showToast(str);
    }

    public boolean dV(boolean z) {
        if (this.bLz == null || !this.bLz.aco()) {
            if (!z) {
                if (abg()) {
                    abh();
                    return true;
                } else if (this.bMh != null && this.bMh.alK()) {
                    this.bMh.ami();
                    return true;
                }
            } else if (abg()) {
                abh();
                return true;
            }
            return false;
        }
        return true;
    }

    public void abB() {
        if (this.bMB != null) {
            while (this.bMB.size() > 0) {
                TbImageView remove = this.bMB.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        abB();
    }

    public void onDestroy() {
        this.bIT.hideProgressBar();
        if (this.aDW != null && this.aJH != null) {
            this.aDW.b(this.aJH);
        }
        abC();
        this.bLD.tO();
    }

    public void abC() {
        this.bLc.oW();
        com.baidu.adp.lib.util.n.c(this.bIT.getPageContext().getPageActivity(), this.bLB);
        if (this.bMh != null) {
            this.bMh.amg();
        }
        if (this.bLy != null) {
            com.baidu.adp.lib.g.k.b(this.bLy, this.bIT.getPageContext());
        }
        if (this.bMb != null) {
            this.bMb.dismiss();
        }
        if (this.bLz != null) {
            this.bLz.acB();
        }
        abE();
    }

    public void dH(boolean z) {
        this.bLx.dH(z);
        if (this.bLz != null) {
            this.bLz.dH(z);
        }
    }

    public void dI(boolean z) {
        this.bJb = z;
        this.bLx.dI(z);
        if (this.bLz != null) {
            this.bLz.dI(z);
        }
    }

    public boolean abD() {
        if (this.bLz != null) {
            return this.bLz.hasMore();
        }
        return false;
    }

    public void abE() {
        if (this.bLJ != null) {
            this.bLJ.dismiss();
        }
        if (this.bLK != null) {
            com.baidu.adp.lib.g.k.b(this.bLK, this.bIT.getPageContext());
        }
        if (this.bLT != null) {
            com.baidu.adp.lib.g.k.b(this.bLT, this.bIT.getPageContext());
        }
        if (this.bLI != null) {
            com.baidu.adp.lib.g.k.b(this.bLI, this.bIT.getPageContext());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.bIT.getLayoutMode().X(i == 1);
        this.bIT.getLayoutMode().h(this.bEL);
        this.bIT.getLayoutMode().h(this.bLd);
        this.bIT.getLayoutMode().h(this.aod);
        this.bLc.mNavigationBar.onChangeSkinType(this.bIT.getPageContext(), i);
        dU(this.bMc);
        this.bLx.notifyDataSetChanged();
        if (this.bLz != null) {
            this.bLz.onChangeSkinType(i);
            this.bIT.getLayoutMode().h(this.bLD.getView());
        }
        if (this.bLC != null) {
            this.bLC.ct(i);
        }
        if (this.bLD != null) {
            this.bLD.ct(i);
            com.baidu.tbadk.core.util.ba.i(this.aod, com.baidu.tieba.u.pb_foot_more_trans_selector);
            this.bLD.cr(com.baidu.tieba.u.pb_foot_more_trans_selector);
        }
        if (this.bMq != null) {
            this.bMq.ct(i);
            this.bMq.cr(com.baidu.tieba.s.cp_bg_line_e);
            com.baidu.tbadk.core.util.ba.i(this.bMp, com.baidu.tieba.s.cp_bg_line_e);
        }
        if (this.bMh != null) {
            this.bMh.b(this.bIT.getPageContext(), i);
        }
        if (this.bLq != null) {
            this.bLq.cu(i);
        }
        dQ(i == 1);
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.atd = sVar;
        this.bLx.setOnImageClickListener(this.atd);
        if (this.bLz != null) {
            this.bLz.setOnImageClickListener(this.atd);
        }
    }

    public void f(com.baidu.tbadk.core.view.y yVar) {
        this.aJH = yVar;
        if (this.aDW != null) {
            this.aDW.a(this.aJH);
        }
    }

    public void dW(boolean z) {
        this.bLx.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public View abF() {
        if (this.bLz == null) {
            return null;
        }
        return this.bLz.acK();
    }

    private void abG() {
        if (this.bLc.mNavigationBar != null) {
            this.bLc.bMQ.setText(String.format(this.bIT.getPageContext().getString(com.baidu.tieba.y.is_floor), Integer.valueOf(this.bMe)));
            this.bLc.bMQ.setVisibility(0);
            if (this.bLc.bMT.getVisibility() == 0) {
                this.bLc.bMT.setVisibility(4);
                this.bMd = true;
            } else {
                this.bMd = false;
            }
            this.bLc.bMR.setVisibility(4);
            this.bLc.bMS.setVisibility(4);
            this.bLc.mNavigationBar.setVisibility(0);
        }
        if (this.aKe != null) {
            this.aKe.setVisibility(8);
        }
        if (this.bMh != null) {
            this.bMm = this.bMj.getVisibility() == 0;
            this.bMh.setVisibility(8);
            this.bMj.setVisibility(8);
        }
        if (this.bIT != null) {
            this.bIT.setSwipeBackEnabled(false);
        }
    }

    private void abH() {
        if (this.bLc.mNavigationBar != null) {
            this.bLc.hO(this.mForumName);
            this.bLc.bMR.setVisibility(0);
            this.bLc.bMS.setVisibility(0);
            if (this.bMd) {
                this.bLc.bMT.setVisibility(0);
            } else {
                this.bLc.bMT.setVisibility(4);
            }
            this.bLc.mNavigationBar.setVisibility(0);
        }
        if (this.aKe != null) {
            this.aKe.setVisibility(0);
        }
        if (this.bMh != null) {
            int visibility = this.bLw != null ? this.bLw.getVisibility() : 0;
            if (visibility == 0) {
                if (this.bMm) {
                    this.bMj.setVisibility(visibility);
                } else {
                    this.bMh.setVisibility(visibility);
                }
            } else {
                this.bMm = this.bMj.getVisibility() == 0;
                this.bMh.setVisibility(visibility);
                this.bMj.setVisibility(visibility);
            }
        }
        if (this.bIT != null) {
            this.bIT.setSwipeBackEnabled(true);
        }
    }

    public Button abI() {
        return this.bMg;
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        if (this.bMh != null) {
            this.bMh.cmP.a(writeImagesInfo, z);
        }
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        if (this.bMh != null) {
            this.bMh.cmP.setBaobaoUris(writeImagesInfo);
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                this.bMh.amc();
            } else {
                this.bMh.amd();
            }
        }
    }

    public void h(com.baidu.tieba.pb.a.b bVar) {
        if (bVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.c.j> Zc = bVar.Zc();
            if (Zc.size() == 1) {
                com.baidu.tieba.tbadkCore.c.j jVar = Zc.get(0);
                if (jVar.amV() < jVar.amO().size()) {
                    this.aKe.setNextPage(null);
                    return;
                } else {
                    this.aKe.setNextPage(this.bLD);
                    return;
                }
            }
            this.aKe.setNextPage(this.bLD);
        }
    }

    public boolean Ji() {
        if (this.bMh == null) {
            return false;
        }
        return this.bMh.Ji();
    }

    public boolean abJ() {
        if (this.bLz == null) {
            return false;
        }
        return this.bLz.Ji();
    }

    public void abK() {
        if (com.baidu.tbadk.performanceLog.ah.CQ().CR()) {
            int lastVisiblePosition = this.aKe.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aKe.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(com.baidu.tieba.v.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.z perfLog = tbImageView.getPerfLog();
                                perfLog.eb(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                                perfLog.apu = true;
                                perfLog.apt = this.bIT.aJq;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView.tK();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(com.baidu.tieba.v.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.z perfLog2 = headImageView.getPerfLog();
                        perfLog2.eb(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                        perfLog2.apu = true;
                        perfLog2.apt = this.bIT.aJq;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                            }
                        }
                        headImageView.tK();
                    }
                }
            }
        }
    }

    public void abL() {
        if (this.bMj != null) {
            this.bMj.setVisibility(0);
        }
    }

    public void abM() {
        if (this.bMj != null) {
            this.bMj.setVisibility(8);
        }
    }
}
