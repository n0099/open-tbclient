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
public class ci {
    private com.baidu.tbadk.core.view.ae YX;
    private NoNetworkView aDO;
    private BdTypeListView aJU;
    private View.OnClickListener aLA;
    private View anV;
    private RelativeLayout bEy;
    private PbActivity bIF;
    private View.OnClickListener bIQ;
    private com.baidu.tieba.pb.b.d bIf;
    bf bIm;
    public final com.baidu.tieba.pb.pb.main.b.a bKN;
    private View bKO;
    private ColumnLayout bKQ;
    private TextView bKR;
    private TextView bKS;
    private HeadImageView bKT;
    private ImageView bKU;
    private ImageView bKV;
    private UserIconBox bKW;
    private UserIconBox bKX;
    private ImageView bKY;
    private TextView bKZ;
    private PbEditor bLR;
    private com.baidu.tbadk.editortool.v bLS;
    private View bLT;
    private TextView bLU;
    private TextView bLV;
    private boolean bLX;
    private TextView bLa;
    private View bLe;
    private View bLg;
    private RelativeLayout bLh;
    private bj bLi;
    private PbListView bLo;
    private View bLq;
    private View bMb;
    private LiveBroadcastCard bMc;
    private View bMd;
    private TextView bMe;
    private be bMi;
    private View bKP = null;
    public FrsPraiseView bLb = null;
    private View bLc = null;
    private View bLd = null;
    private View bLf = null;
    private Dialog bLj = null;
    private com.baidu.tbadk.core.dialog.e aLn = null;
    private com.baidu.tieba.pb.pb.sub.l bLk = null;
    private View bLl = null;
    private EditText bLm = null;
    private com.baidu.tieba.pb.view.c bLn = null;
    private View bLp = null;
    private com.baidu.tbadk.core.dialog.h bhb = null;
    private AbsListView.OnScrollListener bLr = null;
    private com.baidu.tbadk.widget.richText.s asV = null;
    private com.baidu.tbadk.core.view.y aJx = null;
    private Dialog bLs = null;
    private com.baidu.tbadk.core.dialog.a bLt = null;
    private Dialog bLu = null;
    private View bLv = null;
    private int bLw = 0;
    private RadioGroup MI = null;
    private RadioButton bLx = null;
    private RadioButton bLy = null;
    private RadioButton bLz = null;
    private Button bLA = null;
    private Button bLB = null;
    private TextView bLC = null;
    private Dialog bLD = null;
    private View bLE = null;
    private RadioGroup bLF = null;
    private CompoundButton.OnCheckedChangeListener bLG = null;
    private Button bLH = null;
    private Button bLI = null;
    private String bLJ = null;
    private dg bLK = null;
    private com.baidu.tbadk.core.dialog.e bLL = null;
    private boolean bLM = false;
    private String mForumName = null;
    private boolean bLN = false;
    private int bLO = 0;
    private ScrollView bLP = null;
    private Button bLQ = null;
    private boolean bLW = true;
    private LinearLayout bLY = null;
    private View bLZ = null;
    private PbListView bMa = null;
    private boolean bIO = false;
    private boolean mIsFromCDN = true;
    private com.baidu.tieba.tbadkCore.b.h bMf = new cj(this);
    public com.baidu.tieba.pb.pb.sub.v bMg = new cs(this);
    private final View.OnClickListener bMh = new cz(this);
    private View.OnLongClickListener bMj = null;
    private boolean bMk = false;
    private final List<TbImageView> bMl = new ArrayList();
    private boolean bIN = true;

    public NoNetworkView aar() {
        return this.aDO;
    }

    public void aas() {
        this.bLW = true;
        if (this.bLR != null) {
            this.bLR.setVisibility(8);
        }
        if (this.bLT != null) {
            this.bLT.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.c.j aat() {
        int i;
        View childAt;
        if (this.aJU == null) {
            return null;
        }
        int firstVisiblePosition = this.aJU.getFirstVisiblePosition();
        int lastVisiblePosition = this.aJU.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.aJU.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.aJU.getChildAt(i3 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.aJU.getHeaderViewsCount();
        int i7 = headerViewsCount >= 0 ? headerViewsCount : 0;
        if (this.bLi.hi(i7) != com.baidu.tieba.tbadkCore.c.j.cnQ) {
            i7++;
        }
        return (com.baidu.tieba.tbadkCore.c.j) this.bLi.aA(i7);
    }

    public ci(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.b.d dVar) {
        this.bIF = null;
        this.bEy = null;
        this.aJU = null;
        this.bKO = null;
        this.bKQ = null;
        this.bKR = null;
        this.bKS = null;
        this.bKT = null;
        this.bKU = null;
        this.bKV = null;
        this.bKW = null;
        this.bKX = null;
        this.bKY = null;
        this.bKZ = null;
        this.bLa = null;
        this.bLe = null;
        this.bLg = null;
        this.bLi = null;
        this.bLo = null;
        this.anV = null;
        this.aLA = null;
        this.bIQ = null;
        this.bLT = null;
        this.bLU = null;
        this.bLV = null;
        this.bMd = null;
        this.bMe = null;
        this.bIF = pbActivity;
        this.aLA = onClickListener;
        this.bIf = dVar;
        this.bEy = (RelativeLayout) com.baidu.adp.lib.g.b.hH().inflate(this.bIF.getPageContext().getPageActivity(), com.baidu.tieba.w.new_pb_activity, null);
        this.bIF.addContentView(this.bEy, new FrameLayout.LayoutParams(-1, -1));
        this.bLh = (RelativeLayout) this.bIF.findViewById(com.baidu.tieba.v.title_wrapper);
        this.aDO = (NoNetworkView) this.bIF.findViewById(com.baidu.tieba.v.view_no_network);
        this.aJU = (BdTypeListView) this.bIF.findViewById(com.baidu.tieba.v.new_pb_list);
        View view = new View(this.bIF.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.bIF.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_editor_height)));
        this.aJU.addFooterView(view);
        this.bKN = new com.baidu.tieba.pb.pb.main.b.a(pbActivity);
        this.bKN.aby().setOnTouchListener(new com.baidu.tieba.pb.b.a(new da(this)));
        this.bLT = this.bIF.findViewById(com.baidu.tieba.v.pb_editor_tool_comment);
        this.bLU = (TextView) this.bIF.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_reply_text);
        this.bLV = (TextView) this.bIF.findViewById(com.baidu.tieba.v.pb_editor_tool_comment_praise_icon);
        this.bLU.setOnClickListener(new db(this));
        this.bLV.setOnClickListener(this.aLA);
        this.bLV.setOnTouchListener(this.bIF);
        aaZ();
        this.bKO = com.baidu.adp.lib.g.b.hH().inflate(this.bIF.getPageContext().getPageActivity(), com.baidu.tieba.w.new_pb_header_item, null);
        this.bKQ = (ColumnLayout) this.bKO.findViewById(com.baidu.tieba.v.pb_head_owner_root);
        this.bKQ.setOnLongClickListener(this.bMj);
        this.bKQ.setOnTouchListener(this.bIf);
        this.bKQ.setVisibility(8);
        this.bKO.setOnTouchListener(this.bIf);
        this.bKR = (TextView) this.bKO.findViewById(com.baidu.tieba.v.pb_head_post_title);
        this.bKR.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.bKR.setVisibility(8);
        this.bMd = this.bKO.findViewById(com.baidu.tieba.v.pb_head_activity_join_number_container);
        this.bMd.setVisibility(8);
        this.bMe = (TextView) this.bKO.findViewById(com.baidu.tieba.v.pb_head_activity_join_number);
        this.bKS = (TextView) this.bKQ.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_name);
        this.bKT = (HeadImageView) this.bKQ.findViewById(com.baidu.tieba.v.pb_head_owner_photo);
        if (!this.bIN) {
            this.bKT.setVisibility(8);
        }
        this.bKU = (ImageView) this.bKQ.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_rank);
        this.bKV = (ImageView) this.bKQ.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_gender);
        this.bKW = (UserIconBox) this.bKQ.findViewById(com.baidu.tieba.v.pb_head_owner_info_user_icon);
        this.bKX = (UserIconBox) this.bKQ.findViewById(com.baidu.tieba.v.pb_head_owner_info_tshow_icon);
        this.bKY = (ImageView) this.bKQ.findViewById(com.baidu.tieba.v.pb_head_owner_info_floor_owner);
        this.bKZ = (TextView) this.bKQ.findViewById(com.baidu.tieba.v.pb_head_owner_info_time);
        this.bLa = (TextView) this.bKO.findViewById(com.baidu.tieba.v.pb_head_reverse_hint);
        this.bLa.setOnClickListener(this.aLA);
        this.bLa.setVisibility(8);
        this.bLe = this.bKO.findViewById(com.baidu.tieba.v.new_pb_header_item_line_below_livepost);
        this.bLg = this.bKO.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_showpassed);
        this.bKO.setOnLongClickListener(new dc(this));
        aaF();
        this.bLi = new bj(this.bIF, this.aJU);
        this.bLi.u(this.aLA);
        this.bLi.a(this.bIf);
        this.bLi.setOnImageClickListener(this.asV);
        this.bIQ = new dd(this);
        this.bLi.t(this.bIQ);
        this.aJU.addHeaderView(this.bKO);
        this.bLo = new PbListView(this.bIF.getPageContext().getPageActivity());
        this.anV = this.bLo.getView().findViewById(com.baidu.tieba.v.pb_more_view);
        if (this.anV != null) {
            this.anV.setOnClickListener(this.aLA);
            com.baidu.tbadk.core.util.ba.i(this.anV, com.baidu.tieba.u.pb_foot_more_trans_selector);
        }
        this.bLo.tN();
        this.bLo.cr(com.baidu.tieba.u.pb_foot_more_trans_selector);
        this.bLo.cs(com.baidu.tieba.u.pb_foot_more_trans_selector);
        this.bLq = this.bIF.findViewById(com.baidu.tieba.v.viewstub_progress);
    }

    public PbEditor IY() {
        return this.bLR;
    }

    public void aau() {
        if (this.bLR != null) {
            this.bEy.removeView(this.bLR);
            this.bLR = null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void aav() {
        if (this.bIF != null) {
            this.bLR = new PbEditor(this.bIF.getPageContext().getPageActivity());
            this.bLR.setOrientation(1);
            this.bLR.setFrom(1);
            this.bLR.aQ(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bEy.addView(this.bLR, layoutParams);
            this.bLR.b(this.bIF.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            aaw();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void aaw() {
        if (this.bLR != null) {
            this.bLR.a(this.bIF.getPageContext(), new de(this));
        }
    }

    public void hK(String str) {
    }

    public void z(String str, boolean z) {
        this.bLX = z;
        dS(TbadkCoreApplication.m411getInst().getSkinType() == 1);
    }

    private void dS(boolean z) {
        if (this.bLV != null) {
            if (this.bLX) {
                com.baidu.tbadk.core.util.ba.i((View) this.bLV, com.baidu.tieba.u.pb_praise_already_click_selector);
            } else {
                com.baidu.tbadk.core.util.ba.i((View) this.bLV, com.baidu.tieba.u.pb_praise_normal_click_selector);
            }
        }
    }

    public TextView aax() {
        return this.bLV;
    }

    public void dT(boolean z) {
        if (this.aJU != null) {
            if (!z) {
                this.aJU.setEnabled(z);
            } else {
                this.aJU.postDelayed(new df(this, z), 10L);
            }
        }
    }

    public void L(View view) {
        boolean z;
        View view2;
        if (this.bLh != null && view != null) {
            if (this.bLW) {
                z = this.bLT.getVisibility() == 0;
            } else {
                z = this.bLR != null && this.bLR.getVisibility() == 0;
            }
            boolean z2 = this.bLh.getVisibility() == 0;
            if (z2) {
                View findViewById = this.bIF.findViewById(com.baidu.tieba.v.bg_above_list);
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.bLh.getHeight()));
                com.baidu.tieba.tbadkCore.a.a(this.bIF, this.bLh, com.baidu.tieba.p.top_fold_up, new ck(this, findViewById));
            } else {
                com.baidu.tieba.tbadkCore.a.a(this.bIF, this.bLh, com.baidu.tieba.p.top_fold_down, new cl(this));
            }
            if (this.bLW) {
                view2 = this.bLT;
            } else {
                view2 = this.bLR;
            }
            if (z) {
                if (z2) {
                    if (this.bLR != null) {
                        this.bLR.alS();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.bIF, view2, com.baidu.tieba.p.bottom_fold_down, new cm(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.bIF, view2, com.baidu.tieba.p.bottom_fold_up, new cn(this));
            }
        }
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.bLR == null) {
            return null;
        }
        return this.bLR.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.bLR != null) {
            this.bLR.setAudioData(voiceModel);
        }
    }

    public void Jh() {
        if (this.bLR != null) {
            this.bLR.Jh();
        }
    }

    public void aay() {
        if (this.bLk != null) {
            this.bLk.aaY();
        }
    }

    public com.baidu.tieba.pb.pb.sub.l aaz() {
        return this.bLk;
    }

    public void aaA() {
        if (this.bLk != null) {
            this.bLk.aaZ();
        }
    }

    public VoiceData.VoiceModel aaB() {
        if (this.bLk != null) {
            return this.bLk.getAudioData();
        }
        return null;
    }

    public void aaC() {
        if (this.bLk != null) {
            this.bLk.Jh();
        }
    }

    public TextView aaD() {
        if (this.bLk == null || !(this.bLk instanceof com.baidu.tieba.pb.pb.sub.i)) {
            return null;
        }
        return ((com.baidu.tieba.pb.pb.sub.i) this.bLk).acb();
    }

    public bj aaE() {
        return this.bLi;
    }

    public void a(bf bfVar) {
        this.bIm = bfVar;
    }

    private void a(com.baidu.tbadk.core.data.z zVar) {
        if (zVar != null && zVar.qZ() != 0) {
            if (this.bLQ == null) {
                this.bIF.getLayoutMode().h(((ViewStub) this.bKO.findViewById(com.baidu.tieba.v.live_talk_layout)).inflate());
                this.bLQ = (Button) this.bKO.findViewById(com.baidu.tieba.v.pb_head_function_manage_go_to_live_post);
                this.bLd = this.bKO.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_livepost);
            }
            int ra = zVar.ra();
            String string = this.bIF.getPageContext().getString(com.baidu.tieba.y.go_to_live_post_prefix);
            if (ra == 0) {
                string = String.valueOf(string) + this.bIF.getPageContext().getString(com.baidu.tieba.y.go_to_interview_post);
            } else if (ra == 1) {
                string = String.valueOf(string) + this.bIF.getPageContext().getString(com.baidu.tieba.y.go_to_discuss_post);
            }
            this.bLQ.setText(string);
            this.bLQ.setVisibility(0);
            this.bLQ.setOnClickListener(this.aLA);
            abf();
        }
    }

    private void aaF() {
        this.bLY = (LinearLayout) this.bKO.findViewById(com.baidu.tieba.v.btn_show_passed_pb);
        this.bMa = new PbListView(this.bIF.getPageContext().getPageActivity(), PbListView.IconType.ICON_UP_WARD);
        this.bLZ = this.bMa.mN();
        this.bMa.setText(this.bIF.getResources().getString(com.baidu.tieba.y.btn_show_passed_pb));
        this.bLZ.setOnClickListener(this.bMh);
        this.bLY.addView(this.bLZ);
        this.bLY.requestLayout();
        this.bLY.invalidate();
        com.baidu.tbadk.core.util.ba.i(this.bLZ, com.baidu.tieba.s.cp_bg_line_e);
        this.bMa.cr(com.baidu.tieba.s.cp_bg_line_e);
        this.bMa.cs(com.baidu.tieba.s.cp_bg_line_e);
        abf();
    }

    public void M(View view) {
        if (this.bLs == null) {
            this.bLs = new Dialog(this.bIF.getPageContext().getPageActivity(), com.baidu.tieba.z.common_alert_dialog);
            this.bLs.setCanceledOnTouchOutside(true);
            this.bLs.setCancelable(true);
            this.bLs.setContentView(com.baidu.adp.lib.g.b.hH().inflate(this.bIF.getPageContext().getPageActivity(), com.baidu.tieba.w.forum_manage_dialog, null));
            WindowManager.LayoutParams attributes = this.bLs.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.n.M(this.bIF.getPageContext().getPageActivity()) * 0.9d);
            this.bLs.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.bLs.findViewById(com.baidu.tieba.v.del_post_btn);
        Button button2 = (Button) this.bLs.findViewById(com.baidu.tieba.v.forbid_user_btn);
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
                button.setOnClickListener(new co(this));
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
                button2.setOnClickListener(new cp(this));
            }
            com.baidu.adp.lib.g.k.a(this.bLs, this.bIF.getPageContext());
        }
    }

    public void a(be beVar) {
        this.bMi = beVar;
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
        this.bLt = new com.baidu.tbadk.core.dialog.a(this.bIF.getActivity());
        this.bLt.bw(com.baidu.tieba.y.del_post_tip);
        this.bLt.bx(i3);
        this.bLt.v(sparseArray);
        this.bLt.a(com.baidu.tieba.y.dialog_ok, this.bIF);
        this.bLt.b(com.baidu.tieba.y.dialog_cancel, new cq(this));
        this.bLt.ac(true);
        this.bLt.b(this.bIF.getPageContext());
        this.bLt.re();
    }

    public void L(ArrayList<com.baidu.tbadk.core.data.l> arrayList) {
        if (this.bLD == null) {
            this.bLD = new Dialog(this.bIF.getPageContext().getPageActivity(), com.baidu.tieba.z.common_alert_dialog);
            this.bLD.setCanceledOnTouchOutside(true);
            this.bLD.setCancelable(true);
            this.bLE = com.baidu.adp.lib.g.b.hH().inflate(this.bIF.getPageContext().getPageActivity(), com.baidu.tieba.w.commit_good, null);
            this.bLP = (ScrollView) this.bLE.findViewById(com.baidu.tieba.v.good_scroll);
            this.bLD.setContentView(this.bLE);
            WindowManager.LayoutParams attributes = this.bLD.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.n.M(this.bIF.getPageContext().getPageActivity()) * 0.9d);
            this.bLD.getWindow().setAttributes(attributes);
            this.bLG = new cr(this);
            this.bLF = (RadioGroup) this.bLE.findViewById(com.baidu.tieba.v.good_class_group);
            this.bLI = (Button) this.bLE.findViewById(com.baidu.tieba.v.dialog_button_cancel);
            this.bLI.setOnClickListener(new ct(this));
            this.bLH = (Button) this.bLE.findViewById(com.baidu.tieba.v.dialog_button_ok);
            this.bLH.setOnClickListener(this.aLA);
        }
        this.bLF.removeAllViews();
        RadioButton radioButton = (RadioButton) com.baidu.adp.lib.g.b.hH().inflate(this.bIF.getPageContext().getPageActivity(), com.baidu.tieba.w.good_class_radio_button, null);
        radioButton.setTag(GameInfoData.NOT_FROM_DETAIL);
        radioButton.setText(this.bIF.getPageContext().getString(com.baidu.tieba.y.def_good_class));
        radioButton.setOnCheckedChangeListener(this.bLG);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(com.baidu.adp.lib.util.n.dip2px(this.bIF.getPageContext().getPageActivity(), 10.0f), com.baidu.adp.lib.util.n.dip2px(this.bIF.getPageContext().getPageActivity(), 5.0f), com.baidu.adp.lib.util.n.dip2px(this.bIF.getPageContext().getPageActivity(), 10.0f), com.baidu.adp.lib.util.n.dip2px(this.bIF.getPageContext().getPageActivity(), 5.0f));
        this.bLF.addView(radioButton, layoutParams);
        this.bLF.requestLayout();
        this.bLF.check(radioButton.getId());
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                RadioButton radioButton2 = (RadioButton) com.baidu.adp.lib.g.b.hH().inflate(this.bIF.getPageContext().getPageActivity(), com.baidu.tieba.w.good_class_radio_button, null);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).qc()));
                radioButton2.setText(arrayList.get(i2).qb());
                radioButton2.setOnCheckedChangeListener(this.bLG);
                this.bLF.addView(radioButton2, layoutParams);
                this.bLF.requestLayout();
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bLP.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.n.dip2px(this.bIF.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.n.dip2px(this.bIF.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.n.dip2px(this.bIF.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.bLP.setLayoutParams(layoutParams2);
            this.bLP.removeAllViews();
            this.bLP.addView(this.bLF);
        }
        com.baidu.adp.lib.g.k.a(this.bLD, this.bIF.getPageContext());
    }

    public void aaG() {
        this.bIF.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.bIF.hideProgressBar();
        if (z && z2) {
            this.bIF.showToast(this.bIF.getPageContext().getString(com.baidu.tieba.y.success));
        } else if (str != null && z2) {
            this.bIF.showToast(str);
        }
    }

    public void RD() {
        this.bLq.setVisibility(0);
    }

    public void RC() {
        this.bLq.setVisibility(8);
    }

    public View aaH() {
        if (this.bLE != null) {
            return this.bLE.findViewById(com.baidu.tieba.v.dialog_button_ok);
        }
        return null;
    }

    public String aaI() {
        return this.bLJ;
    }

    public View aaJ() {
        if (this.bLk != null) {
            return this.bLk.acq();
        }
        return null;
    }

    public View getView() {
        return this.bEy;
    }

    public void aaK() {
        View editText;
        if (this.bLR == null) {
            editText = this.bIF.getCurrentFocus();
        } else {
            editText = this.bLR.getEditText();
        }
        com.baidu.adp.lib.util.n.c(this.bIF.getPageContext().getPageActivity(), editText);
    }

    public void Je() {
        if (this.bLk != null) {
            this.bLk.acs();
        } else {
            this.bIF.showProgressBar();
        }
    }

    public void bK(boolean z) {
        if (this.bLk != null) {
            this.bLk.act();
        } else {
            this.bIF.hideProgressBar();
        }
        abo();
        if (z) {
            if (this.bLR != null) {
                this.bLR.getEditText().setText("");
                this.bLR.alO();
                this.bLR.clearData();
            }
            if (this.bLk != null) {
                this.bLk.clearContent();
            }
        }
    }

    public void aaL() {
        this.bLo.startLoadData();
    }

    public void aaM() {
    }

    public void aaN() {
        this.bIF.hideProgressBar();
        this.bLo.tO();
        this.bMa.tO();
        this.aJU.mW();
        abf();
    }

    public void aaO() {
        this.aJU.mW();
        this.bLY.setVisibility(8);
        abf();
    }

    public void dU(boolean z) {
        if (!z) {
            if (this.bLR != null) {
                this.bLR.alQ();
            }
        } else if (this.bLk != null) {
            this.bLk.hQ(null);
        }
    }

    public void aaP() {
        if (aaT() && this.bLk != null) {
            this.bLk.acj();
        }
    }

    public void aaQ() {
        if (this.bLk == null) {
            this.bLk = new com.baidu.tieba.pb.pb.sub.l(this.bIF, this.bMk, this.aLA, this.bIQ, this.bIF.bHZ.bMv, this.bIF.bHZ.bMw, this.bIF.bHZ.bMx);
            this.bLk.setOnActionListener(this.bLS);
            this.bLk.setOnScrollListener(this.bLr);
            this.bLk.dJ(this.bLi.ZG());
            this.bLk.dK(this.bLi.ZH());
            this.bLp = this.bLk.getRootView();
            this.bLk.setOnImageClickListener(this.asV);
            this.bLk.setOnEmotionClickListener(this.bIF.bHZ.bMy);
            this.bLk.setOnLongClickListener(this.bLi.ZI());
        }
        this.bLp.setVisibility(0);
        this.bLk.ed(this.mIsFromCDN);
        this.bLk.aaK();
        this.bEy.addView(this.bLp);
        abr();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            this.bLS = vVar;
            if (this.bLR != null) {
                aaw();
            }
            if (this.bLk != null) {
                this.bLk.setOnActionListener(vVar);
            }
        }
    }

    public void a(dg dgVar) {
        this.bLK = dgVar;
    }

    public void a(boolean z, com.baidu.tieba.pb.a.c cVar, boolean z2, String str, String str2, View view, int i) {
        if (cVar != null && view != null) {
            TiebaStatic.eventStat(this.bIF.getPageContext().getPageActivity(), "pb_tosubpb", "pbclick", 1, new Object[0]);
            if (this.bLk == null) {
                this.bLk = new com.baidu.tieba.pb.pb.sub.l(this.bIF, this.bMk, this.aLA, this.bIQ, this.bIF.bHZ.bMv, this.bIF.bHZ.bMw, this.bIF.bHZ.bMx);
                this.bLk.setOnActionListener(this.bLS);
                this.bLk.setOnScrollListener(this.bLr);
                this.bLk.dJ(this.bLi.ZG());
                this.bLk.dK(this.bLi.ZH());
                this.bLp = this.bLk.getRootView();
                this.bLk.setOnImageClickListener(this.asV);
                this.bLk.setOnEmotionClickListener(this.bIF.bHZ.bMy);
                this.bLk.setOnLongClickListener(this.bLi.ZI());
            }
            this.bLk.ht(this.bLi.getWidth());
            this.bLk.a(cVar, i);
            this.bLk.ed(this.mIsFromCDN);
            this.bLk.a(this.bMg);
            if (cVar.YX() != null) {
                this.bLO = cVar.YX().amA();
            } else {
                this.bLO = 0;
            }
            if (str2 != null && !str2.equals("")) {
                this.bLk.hS(str2);
            } else {
                this.bLk.setPosition(1);
            }
            if (!z) {
                this.bLk.acm();
            }
            this.bLp.setVisibility(0);
            if (this.bLp.getParent() == this.bEy) {
                this.bEy.removeView(this.bLp);
            }
            abr();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, com.baidu.tieba.v.title_wrapper);
            this.bEy.addView(this.bLp, layoutParams);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.bIF.getPageContext().getPageActivity(), com.baidu.tieba.p.in_from_right);
            loadAnimation.setAnimationListener(new cu(this, cVar, z, str, str2));
            this.bLp.setAnimation(loadAnimation);
            loadAnimation.start();
        }
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.bMj = onLongClickListener;
        this.bLi.setOnLongClickListener(onLongClickListener);
        if (this.bLk != null) {
            this.bLk.setOnLongClickListener(onLongClickListener);
        }
    }

    public void aaR() {
        if (aaT()) {
            this.bLk.acn();
        }
    }

    public void aaS() {
        if (aaT() && (this.bLk instanceof com.baidu.tieba.pb.pb.sub.i)) {
            ((com.baidu.tieba.pb.pb.sub.i) this.bLk).ace();
        }
    }

    public boolean aaT() {
        return (this.bLp == null || this.bLp.getVisibility() == 8) ? false : true;
    }

    public void aaU() {
        if (this.bLp != null) {
            this.bLp.setVisibility(8);
            this.bEy.removeView(this.bLp);
            this.bLk.Mw();
        }
        abo();
        abs();
    }

    public void aaV() {
        if (this.bLp != null) {
            if (this.bEy != null) {
                this.bEy.removeView(this.bLp);
            }
            this.bLp = null;
        }
        if (this.bLk != null) {
            this.bLk.Mw();
            this.bLk = null;
        }
    }

    public void aaW() {
        if (this.bLk != null) {
            this.bLk.acu();
            if (this.bLk instanceof com.baidu.tieba.pb.pb.sub.i) {
                ((com.baidu.tieba.pb.pb.sub.i) this.bLk).acf();
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i) {
        if (this.bLk != null) {
            this.bLk.acu();
            this.bLk.ht(this.bLi.getWidth());
            this.bLk.a(cVar, i);
        }
    }

    public void aaX() {
        if (this.bLk == null) {
            this.bLk = new com.baidu.tieba.pb.pb.sub.i(this.bIF, this.bMk, this.aLA, this.bIQ, this.bIF.bHZ.bMv, this.bIF.bHZ.bMw, this.bIF.bHZ.bMx);
            this.bLk.setOnActionListener(this.bLS);
            this.bLk.setOnScrollListener(this.bLr);
            this.bLk.dJ(this.bLi.ZG());
            this.bLk.dK(this.bLi.ZH());
            this.bLp = this.bLk.getRootView();
            this.bLk.setOnImageClickListener(this.asV);
            this.bLk.setOnEmotionClickListener(this.bIF.bHZ.bMy);
            this.bLk.setOnLongClickListener(this.bLi.ZI());
        }
        this.bLp.setVisibility(0);
        this.bLk.aaK();
        this.bEy.addView(this.bLp);
        abr();
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i, String str, boolean z, boolean z2) {
        if (this.bLk != null && (this.bLk instanceof com.baidu.tieba.pb.pb.sub.i)) {
            com.baidu.tieba.pb.pb.sub.i iVar = (com.baidu.tieba.pb.pb.sub.i) this.bLk;
            this.bLk.acu();
            this.bLk.ht(this.bLi.getWidth());
            this.bLk.a(cVar, i);
            if (z2) {
                iVar.hP(str);
            }
            if (!z) {
                iVar.acg();
            } else {
                iVar.ach();
            }
        }
    }

    public void v(ArrayList<String> arrayList) {
        if (this.bLR != null) {
            this.bLR.v(arrayList);
        }
    }

    public void M(ArrayList<String> arrayList) {
        if (this.bLk != null) {
            this.bLk.v(arrayList);
        }
    }

    public void aaY() {
        this.bMk = true;
        if (this.bLR != null) {
            this.bLR.aaY();
        }
    }

    public void aaZ() {
        this.bMk = false;
        if (this.bLR != null) {
            this.bLR.aaZ();
        }
    }

    public void a(com.baidu.tbadk.core.dialog.h hVar, boolean z, boolean z2) {
        if (this.bLL != null) {
            this.bLL.dismiss();
            this.bLL = null;
        }
        this.bLL = new com.baidu.tbadk.core.dialog.e(this.bIF.getPageContext().getPageActivity());
        this.bLL.by(com.baidu.tieba.y.operation);
        if (z2) {
            this.bLL.a(new String[]{this.bIF.getPageContext().getString(com.baidu.tieba.y.copy)}, hVar);
        } else if (!z) {
            this.bLL.a(new String[]{this.bIF.getPageContext().getString(com.baidu.tieba.y.copy), this.bIF.getPageContext().getString(com.baidu.tieba.y.mark)}, hVar);
        } else {
            this.bLL.a(new String[]{this.bIF.getPageContext().getString(com.baidu.tieba.y.copy), this.bIF.getPageContext().getString(com.baidu.tieba.y.remove_mark)}, hVar);
        }
        this.bLL.d(this.bIF.getPageContext());
        this.bLL.rg();
    }

    public void setAudioFocusable(boolean z) {
        if (this.bLR != null) {
            this.bLR.setAudioFocusable(z);
        }
    }

    public void dV(boolean z) {
        if (this.bLk != null) {
            this.bLk.setAudioFocusable(z);
        }
    }

    public void k(Bitmap bitmap) {
        if (this.bLR != null) {
            this.bLR.k(bitmap);
            this.bLR.alN();
        }
    }

    public void aba() {
        if (this.bLR != null) {
            this.bLR.k(null);
        }
    }

    public int abb() {
        int firstVisiblePosition = this.aJU.getFirstVisiblePosition();
        com.baidu.adp.widget.ListView.g gVar = (com.baidu.adp.widget.ListView.g) this.aJU.getAdapter();
        if (gVar != null) {
            if (gVar.getItem(firstVisiblePosition) instanceof com.baidu.tieba.pb.a.a) {
                firstVisiblePosition++;
            }
            int headersCount = (this.aJU.getAdapter() == null || !(this.aJU.getAdapter() instanceof com.baidu.adp.widget.ListView.g)) ? 0 : ((com.baidu.adp.widget.ListView.g) this.aJU.getAdapter()).getHeadersCount();
            return firstVisiblePosition > headersCount ? firstVisiblePosition - headersCount : 0;
        }
        return firstVisiblePosition;
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.bLm.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public String Jf() {
        return this.bLR == null ? "" : this.bLR.getContent();
    }

    public void fG(String str) {
        if (this.bLR != null) {
            this.bLR.setContent(str);
        }
    }

    public String abc() {
        if (this.bLk == null) {
            return null;
        }
        return this.bLk.acr();
    }

    public String abd() {
        if (this.bLk != null) {
            return this.bLk.aco();
        }
        return null;
    }

    public String abe() {
        if (this.bLk != null) {
            return this.bLk.ack();
        }
        return null;
    }

    public void e(com.baidu.tieba.pb.a.b bVar) {
        this.bLi.b(bVar);
        this.bLi.notifyDataSetChanged();
        if (bVar == null) {
            hK("");
        } else {
            hK(com.baidu.tbadk.core.util.bd.p(bVar.YP().getReply_num()));
        }
        abf();
    }

    public void f(com.baidu.tieba.pb.a.b bVar) {
        PraiseData praise;
        if (this.bLb == null) {
            this.bIF.getLayoutMode().h(((ViewStub) this.bKO.findViewById(com.baidu.tieba.v.praise_layout)).inflate());
            this.bLb = (FrsPraiseView) this.bKO.findViewById(com.baidu.tieba.v.pb_head_praise_view);
            this.bLb.setIsFromPb(true);
            this.bLf = this.bKO.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_praise);
            this.bLb.cu(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.bLb != null) {
            boolean abf = abf();
            if (bVar != null && bVar.YQ() != null && bVar.YQ().size() > 0) {
                com.baidu.tieba.tbadkCore.c.j jVar = bVar.YQ().get(0);
                if ((!this.bIO || jVar.amA() != 1) && (praise = bVar.YP().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.bLb.setVisibility(0);
                    this.bLb.setIsFromPb(true);
                    this.bLb.a(praise, bVar.YP().getId(), praise.getPostId(), true);
                    this.bLf.setVisibility(0);
                    if (this.bLb.getVisibility() == 0) {
                        this.bLg.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.bLb.setVisibility(8);
            this.bLf.setVisibility(8);
            if (bVar != null && bVar.XE() != null && bVar.XE().qm() == 0 && this.bIO) {
                this.bLf.setVisibility(8);
                if (abf) {
                    this.bLe.setVisibility(0);
                    return;
                } else {
                    this.bLe.setVisibility(8);
                    return;
                }
            }
            this.bLf.setVisibility(0);
            this.bLe.setVisibility(8);
        }
    }

    private com.baidu.tieba.tbadkCore.c.j a(com.baidu.tieba.pb.a.b bVar, boolean z, int i) {
        if (z) {
            if (bVar == null || bVar.YQ() == null || bVar.YQ().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.c.j jVar = bVar.YQ().get(0);
            if (jVar.amA() != 1) {
                return g(bVar);
            }
            return jVar;
        }
        return g(bVar);
    }

    private com.baidu.tieba.tbadkCore.c.j g(com.baidu.tieba.pb.a.b bVar) {
        MetaData metaData;
        if (bVar == null || bVar.YP() == null || bVar.YP().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.c.j jVar = new com.baidu.tieba.tbadkCore.c.j();
        MetaData author = bVar.YP().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = bVar.YP().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        jVar.ir(1);
        jVar.setId(bVar.YP().qM());
        jVar.setTitle(bVar.YP().getTitle());
        jVar.setTime(bVar.YP().getCreateTime());
        jVar.a(metaData);
        return jVar;
    }

    private void b(com.baidu.tieba.pb.a.b bVar, boolean z, int i) {
        this.bKQ.setVisibility(8);
        com.baidu.tieba.tbadkCore.c.j a = a(bVar, z, i);
        if (a != null) {
            if (z) {
                this.bLa.setVisibility(8);
            } else {
                this.bLa.setVisibility(0);
            }
            this.bKQ.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.bKQ.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.bKQ.setTag(sparseArray);
            }
            sparseArray.put(com.baidu.tieba.v.tag_clip_board, a);
            sparseArray.put(com.baidu.tieba.v.tag_is_subpb, false);
            this.bKZ.setText(com.baidu.tbadk.core.util.bd.n(a.getTime()));
            bVar.YP().qS();
            this.bKR.setVisibility(0);
            this.bKR.setText(bVar.YP().getSpan_str());
            f(bVar);
            ArrayList<com.baidu.tbadk.core.data.b> qJ = bVar.YP().qJ();
            if (qJ != null && qJ.size() > 0) {
                this.bMe.setText(String.valueOf(qJ.get(0).pN()));
                this.bMd.setVisibility(0);
            } else {
                this.bMd.setVisibility(8);
            }
            com.baidu.tbadk.core.util.ba.i(this.bMd, com.baidu.tieba.u.activity_join_num_bg);
            com.baidu.tbadk.core.util.ba.b(this.bMe, com.baidu.tieba.s.cp_link_tip_d, 1);
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
            if (bVar.YP().getAnchorInfoData().getGroup_id() != 0 && appResponseToIntentClass) {
                if (this.bMb == null) {
                    BdLog.e("pb time   liveCardLayout new");
                    this.bMb = ((ViewStub) this.bKO.findViewById(com.baidu.tieba.v.live_card_layout)).inflate();
                    this.bIF.getLayoutMode().h(this.bMb);
                    this.bMc = (LiveBroadcastCard) this.bKO.findViewById(com.baidu.tieba.v.item_card);
                }
                this.bMb.setVisibility(0);
                LiveCardData liveCardData = new LiveCardData();
                liveCardData.setPublisherId(bVar.YP().getAnchorInfoData().getAuthorId());
                liveCardData.setPublisherName(bVar.YP().getAnchorInfoData().getAuthorName());
                liveCardData.setPublisherPortrait(bVar.YP().getAnchorInfoData().getPublisherPortrait());
                liveCardData.setGroupId(bVar.YP().getAnchorInfoData().getGroup_id());
                liveCardData.setIntro(bVar.YP().getAnchorInfoData().getIntro());
                liveCardData.setLikers(bVar.YP().getAnchorInfoData().getLikers());
                liveCardData.setListeners(bVar.YP().getAnchorInfoData().getListeners());
                liveCardData.setName(bVar.YP().getAnchorInfoData().getName());
                liveCardData.setPortrait(bVar.YP().getAnchorInfoData().getPortrait());
                liveCardData.setStatus(bVar.YP().getAnchorInfoData().getStatus());
                liveCardData.setStartTime(bVar.YP().getAnchorInfoData().getStartTime());
                this.bMc.setData(liveCardData);
                this.bMc.setStatisticsKey("notice_pb_live");
            } else if (this.bMb != null) {
                this.bMb.setVisibility(8);
            }
            String userId = bVar.YP().getAuthor().getUserId();
            if (userId != null && !userId.equals(GameInfoData.NOT_FROM_DETAIL) && userId.equals(a.getAuthor().getUserId())) {
                this.bKY.setVisibility(0);
            } else {
                this.bKY.setVisibility(8);
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.bKU.setVisibility(0);
                    com.baidu.tbadk.core.util.ba.c(this.bKU, com.baidu.tbadk.core.util.c.bQ(level_id));
                    i2 = 2;
                    this.bKU.setOnClickListener(null);
                } else {
                    this.bKU.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.ba.c(this.bKU, com.baidu.tieba.u.pb_manager);
                        this.bKU.setOnClickListener(this.bIF.bHZ.bMw);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.ba.c(this.bKU, com.baidu.tieba.u.pb_assist);
                        this.bKU.setOnClickListener(this.bIF.bHZ.bMw);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.ba.c(this.bKV, com.baidu.tieba.u.icon_pop_girl_square);
                    this.bKV.setVisibility(0);
                } else {
                    this.bKV.setVisibility(8);
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfo = a.getAuthor().getTShowInfo();
                if (this.bKW != null) {
                    this.bKW.setOnClickListener(this.bIF.bHZ.bMw);
                    this.bKW.a(iconInfo, i2, this.bIF.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_width), this.bIF.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_height), this.bIF.getResources().getDimensionPixelSize(com.baidu.tieba.t.pb_icon_margin));
                }
                if (this.bKX != null) {
                    this.bKX.setOnClickListener(this.bIF.bHZ.bMx);
                    this.bKX.a(tShowInfo, 3, this.bIF.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.bIF.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.bIF.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                }
                this.bKS.setText(a.getAuthor().getName_show());
                this.bKS.setTag(com.baidu.tieba.v.tag_user_id, a.getAuthor().getUserId());
                this.bKS.setTag(com.baidu.tieba.v.tag_user_name, a.getAuthor().getName_show());
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.ba.b(this.bKS, com.baidu.tieba.s.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ba.b(this.bKS, com.baidu.tieba.s.cp_cont_f, 1);
                }
                if (!this.bIN) {
                    this.bKT.setVisibility(8);
                }
                this.bKT.setUserId(a.getAuthor().getUserId());
                this.bKT.setUserName(a.getAuthor().getUserName());
                this.bKT.setImageDrawable(null);
                this.bKT.setTag(a.getAuthor().getUserId());
                this.bKS.setOnClickListener(this.bIF.bHZ.bMv);
                this.bKT.setOnClickListener(this.bIF.bHZ.bMv);
                this.bKT.c(a.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.b bVar, int i, int i2, boolean z, int i3) {
        Parcelable aak;
        Parcelable aak2;
        String sb;
        if (bVar != null) {
            this.bIO = z;
            aaN();
            b(bVar, z, i);
            this.bLi.dL(this.bIO);
            this.bLi.b(bVar);
            this.bLi.notifyDataSetChanged();
            if (bVar.YO() != null) {
                this.mForumName = bVar.YO().getName();
            }
            this.bKN.hL(this.mForumName);
            if (bVar.YP() != null) {
                hK(com.baidu.tbadk.core.util.bd.p(bVar.YP().getReply_num()));
                if (bVar.YP().getPraise() != null) {
                    if (bVar.YP().getPraise().getNum() < 1) {
                        sb = this.bIF.getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(bVar.YP().getPraise().getNum())).toString();
                    }
                    z(sb, bVar.YP().getPraise().getIsLike() == 1);
                }
            }
            if (bVar.XE().ql() == 0 && !z) {
                this.aJU.setNextPage(null);
            } else {
                this.aJU.setNextPage(this.bLo);
                this.bMa.tO();
            }
            if (bVar.XE().qm() == 0 && z) {
                this.aJU.setPullRefresh(null);
                this.bLY.setVisibility(8);
            } else {
                if (this.bLn == null) {
                    this.bLn = new com.baidu.tieba.pb.view.c(this.bIF.getPageContext());
                    this.bLn.mN();
                    this.bLn.a(this.YX);
                }
                this.aJU.setPullRefresh(this.bLn);
                if (this.bLn != null) {
                    this.bLn.ct(TbadkCoreApplication.m411getInst().getSkinType());
                }
                this.bLY.setVisibility(0);
                this.bMa.tO();
            }
            abf();
            if (bVar.XE().ql() == 0) {
                this.bLo.setText(this.bIF.getResources().getString(com.baidu.tieba.y.no_more_to_load));
                h(bVar);
            } else {
                this.bLo.setText(this.bIF.getResources().getString(com.baidu.tieba.y.pb_load_more));
            }
            if (z) {
                this.bMa.setText(this.bIF.getResources().getString(com.baidu.tieba.y.btn_show_passed_pb));
            } else {
                this.bMa.setText(this.bIF.getResources().getString(com.baidu.tieba.y.btn_show_passed_pb_aftre));
            }
            if (bVar.YP() != null && bVar.YP().getAuthor() != null && bVar.YP().getAuthor().getType() == 0) {
                this.bKN.abz();
            }
            switch (i) {
                case 2:
                    this.aJU.setSelection(i2);
                    if (this.bKP != null) {
                        CompatibleUtile.scrollListViewBy(this.aJU, -this.bKP.getHeight(), 0);
                        return;
                    }
                    return;
                case 3:
                    if (i3 == 1 && (aak2 = cd.aaj().aak()) != null) {
                        this.aJU.onRestoreInstanceState(aak2);
                        return;
                    } else {
                        this.aJU.setSelection(0);
                        return;
                    }
                case 4:
                    if (z) {
                        this.aJU.setSelection(0);
                        return;
                    } else if (bVar.YQ() != null) {
                        if (bVar.XE() != null && bVar.XE().qm() != 0) {
                            this.aJU.setSelection(bVar.YQ().size() + 1);
                            return;
                        } else {
                            this.aJU.setSelection(bVar.YQ().size());
                            return;
                        }
                    } else {
                        return;
                    }
                case 5:
                    this.aJU.setSelection(0);
                    return;
                case 6:
                    if (i3 == 1 && (aak = cd.aaj().aak()) != null) {
                        this.aJU.onRestoreInstanceState(aak);
                        return;
                    } else if (z) {
                        this.aJU.setSelection(0);
                        return;
                    } else if (bVar.YQ() != null) {
                        if (bVar.XE() != null && bVar.XE().qm() != 0) {
                            this.aJU.setSelection(bVar.YQ().size() + 1);
                            return;
                        } else {
                            this.aJU.setSelection(bVar.YQ().size());
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

    public void dW(boolean z) {
        this.bLM = z;
        this.bKN.dW(z);
    }

    public void tO() {
        if (this.bLo != null) {
            this.bLo.tO();
        }
        if (this.bMa != null) {
            this.bMa.tO();
        }
    }

    public void Ka() {
        this.aJU.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abf() {
        boolean z;
        boolean z2 = true;
        if (this.bKP != null && this.bKP.getVisibility() == 0) {
            if (this.bLc != null) {
                this.bLc.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.bLc != null) {
                this.bLc.setVisibility(8);
            }
            z = false;
        }
        if (this.bLQ != null && this.bLQ.getVisibility() == 0) {
            if (this.bLd != null) {
                this.bLd.setVisibility(0);
            }
        } else {
            if (this.bLd != null) {
                this.bLd.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.bLf == null || this.bLf.getVisibility() == 8) && z2 && this.bIO) {
            this.bLe.setVisibility(0);
        } else {
            this.bLe.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.pb.a.b bVar, boolean z, boolean z2) {
        if (bVar == null) {
            return false;
        }
        if (this.bKR != null) {
            if (bVar.YP().qL() == 0) {
                this.bKR.setVisibility(0);
                bVar.YP().qS();
                this.bKR.setText(bVar.YP().getSpan_str());
            } else {
                this.bKR.setVisibility(8);
            }
        }
        if (z) {
            if (this.bMb != null) {
                this.bMb.findViewById(com.baidu.tieba.v.pb_head_live_blank).setVisibility(8);
            }
        } else if (this.bMb != null) {
            this.bMb.findViewById(com.baidu.tieba.v.pb_head_live_blank).setVisibility(0);
        }
        this.bIO = z;
        com.baidu.tbadk.core.data.w YP = bVar.YP();
        if (YP != null) {
            a(YP.qD());
        }
        if (bVar.YS() == 1) {
            abg();
            Button button = (Button) this.bKO.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.bKO.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.bKO.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.bKO.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.aLA);
            button2.setOnClickListener(this.aLA);
            button3.setOnClickListener(this.aLA);
            button4.setOnClickListener(this.aLA);
            if (bVar.YP().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (bVar.YP().getIs_top() == 1) {
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

    private void abg() {
        if (this.bKP == null) {
            this.bKP = ((ViewStub) this.bKO.findViewById(com.baidu.tieba.v.pb_header_function_manage)).inflate();
            this.bIF.getLayoutMode().h(this.bKP);
            this.bLc = this.bKO.findViewById(com.baidu.tieba.v.new_pb_header_item_line_above_manage);
            return;
        }
        this.bKP.setVisibility(0);
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
                if (bVar.YS() != 0 && a.getAuthor() != null) {
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
                    String userId3 = bVar.YP().getAuthor().getUserId();
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
                    sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(bVar.YS()));
                    sparseArray.put(com.baidu.tieba.v.tag_should_manage_visible, true);
                    a(com.baidu.tieba.y.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(com.baidu.tieba.v.tag_del_post_id, a.getId());
                    sparseArray2.put(com.baidu.tieba.v.tag_del_post_type, 0);
                    sparseArray2.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(bVar.YS()));
                    sparseArray2.put(com.baidu.tieba.v.tag_should_manage_visible, false);
                    a(com.baidu.tieba.y.delete, sparseArray2);
                }
            }
            abf();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        abg();
        Button button = (Button) this.bKO.findViewById(com.baidu.tieba.v.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.aLA);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.anV;
    }

    public BdListView getListView() {
        return this.aJU;
    }

    public int abh() {
        return com.baidu.tieba.v.richText;
    }

    public int Kh() {
        return com.baidu.tieba.v.user_icon_box;
    }

    public Button abi() {
        return (Button) this.bKO.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_good);
    }

    public Button abj() {
        return (Button) this.bKO.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_good);
    }

    public Button abk() {
        return (Button) this.bKO.findViewById(com.baidu.tieba.v.pb_head_function_manage_commit_top);
    }

    public Button abl() {
        return (Button) this.bKO.findViewById(com.baidu.tieba.v.pb_head_function_manage_cancel_top);
    }

    public View abm() {
        if (this.bLk == null) {
            return null;
        }
        return this.bLk.acp();
    }

    public void c(com.baidu.adp.widget.ListView.x xVar) {
        this.aJU.setOnSrollToBottomListener(xVar);
    }

    public void a(com.baidu.adp.widget.ListView.aa aaVar) {
        this.aJU.setOnSrollToTopListener(aaVar);
    }

    public void b(com.baidu.tbadk.core.dialog.h hVar) {
        this.bhb = hVar;
    }

    public void a(com.baidu.tbadk.core.view.ae aeVar) {
        this.YX = aeVar;
        if (this.bLn != null) {
            this.bLn.a(aeVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        if (qVar != null) {
            int qj = qVar.qj();
            int qh = qVar.qh();
            if (this.bLj == null) {
                this.bLj = new Dialog(this.bIF.getPageContext().getPageActivity(), com.baidu.tieba.z.common_alert_dialog);
                this.bLj.setCanceledOnTouchOutside(true);
                this.bLj.setCancelable(true);
                this.bLl = com.baidu.adp.lib.g.b.hH().inflate(this.bIF.getPageContext().getPageActivity(), com.baidu.tieba.w.dialog_direct_pager, null);
                this.bLj.setContentView(this.bLl);
                WindowManager.LayoutParams attributes = this.bLj.getWindow().getAttributes();
                attributes.gravity = 49;
                attributes.y = com.baidu.adp.lib.util.n.dip2px(this.bIF.getPageContext().getPageActivity(), 54.0f);
                attributes.width = (int) (com.baidu.adp.lib.util.n.M(this.bIF.getPageContext().getPageActivity()) * 0.9d);
                this.bLj.getWindow().setAttributes(attributes);
                this.bLj.setOnKeyListener(new cv(this));
                this.bLj.setOnDismissListener(new cw(this));
            }
            com.baidu.adp.lib.g.k.a(this.bLj, this.bIF.getPageContext());
            ((Button) this.bLl.findViewById(com.baidu.tieba.v.dialog_button_ok)).setOnClickListener(this.aLA);
            ((Button) this.bLl.findViewById(com.baidu.tieba.v.dialog_button_cancel)).setOnClickListener(this.aLA);
            this.bLm = (EditText) this.bLl.findViewById(com.baidu.tieba.v.input_page_number);
            this.bLm.setText("");
            this.bLm.setOnFocusChangeListener(new cy(this));
            TextView textView = (TextView) this.bLl.findViewById(com.baidu.tieba.v.current_page_number);
            if (qj <= 0) {
                qj = 1;
            }
            textView.setText(MessageFormat.format(this.bIF.getApplicationContext().getResources().getString(com.baidu.tieba.y.current_page), Integer.valueOf(qj), Integer.valueOf(qh <= 0 ? 1 : qh)));
            this.bIF.ShowSoftKeyPadDelay(this.bLm, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aJU.setOnScrollListener(onScrollListener);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.bLr = onScrollListener;
    }

    public void showToast(String str) {
        this.bIF.showToast(str);
    }

    public boolean dX(boolean z) {
        if (this.bLk == null || !this.bLk.abZ()) {
            if (!z) {
                if (aaT()) {
                    aaU();
                    return true;
                } else if (this.bLR != null && this.bLR.alv()) {
                    this.bLR.alT();
                    return true;
                }
            } else if (aaT()) {
                aaU();
                return true;
            }
            return false;
        }
        return true;
    }

    public void abn() {
        if (this.bMl != null) {
            while (this.bMl.size() > 0) {
                TbImageView remove = this.bMl.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        abn();
    }

    public void onDestroy() {
        this.bIF.hideProgressBar();
        if (this.aDO != null && this.aJx != null) {
            this.aDO.b(this.aJx);
        }
        abo();
        this.bLo.tO();
    }

    public void abo() {
        this.bKN.oW();
        com.baidu.adp.lib.util.n.c(this.bIF.getPageContext().getPageActivity(), this.bLm);
        if (this.bLR != null) {
            this.bLR.alR();
        }
        if (this.bLj != null) {
            com.baidu.adp.lib.g.k.b(this.bLj, this.bIF.getPageContext());
        }
        if (this.bLL != null) {
            this.bLL.dismiss();
        }
        if (this.bLk != null) {
            this.bLk.acm();
        }
        abp();
    }

    public void dJ(boolean z) {
        this.bLi.dJ(z);
        if (this.bLk != null) {
            this.bLk.dJ(z);
        }
    }

    public void dK(boolean z) {
        this.bIN = z;
        this.bLi.dK(z);
        if (this.bLk != null) {
            this.bLk.dK(z);
        }
    }

    public void abp() {
        if (this.bLt != null) {
            this.bLt.dismiss();
        }
        if (this.bLu != null) {
            com.baidu.adp.lib.g.k.b(this.bLu, this.bIF.getPageContext());
        }
        if (this.bLD != null) {
            com.baidu.adp.lib.g.k.b(this.bLD, this.bIF.getPageContext());
        }
        if (this.bLs != null) {
            com.baidu.adp.lib.g.k.b(this.bLs, this.bIF.getPageContext());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.bIF.getLayoutMode().X(i == 1);
        this.bIF.getLayoutMode().h(this.bEy);
        this.bIF.getLayoutMode().h(this.bKO);
        this.bIF.getLayoutMode().h(this.anV);
        this.bKN.mNavigationBar.onChangeSkinType(this.bIF.getPageContext(), i);
        dW(this.bLM);
        this.bLi.notifyDataSetChanged();
        if (this.bLk != null) {
            this.bLk.onChangeSkinType(i);
            this.bIF.getLayoutMode().h(this.bLo.getView());
        }
        if (this.bLn != null) {
            this.bLn.ct(i);
        }
        if (this.bLo != null) {
            this.bLo.ct(i);
            com.baidu.tbadk.core.util.ba.i(this.anV, com.baidu.tieba.u.pb_foot_more_trans_selector);
            this.bLo.cr(com.baidu.tieba.u.pb_foot_more_trans_selector);
        }
        if (this.bMa != null) {
            this.bMa.ct(i);
            this.bMa.cr(com.baidu.tieba.s.cp_bg_line_e);
            com.baidu.tbadk.core.util.ba.i(this.bLZ, com.baidu.tieba.s.cp_bg_line_e);
        }
        if (this.bLR != null) {
            this.bLR.b(this.bIF.getPageContext(), i);
        }
        if (this.bLb != null) {
            this.bLb.cu(i);
        }
        dS(i == 1);
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.asV = sVar;
        this.bLi.setOnImageClickListener(this.asV);
        if (this.bLk != null) {
            this.bLk.setOnImageClickListener(this.asV);
        }
    }

    public void f(com.baidu.tbadk.core.view.y yVar) {
        this.aJx = yVar;
        if (this.aDO != null) {
            this.aDO.a(this.aJx);
        }
    }

    public void dY(boolean z) {
        this.bLi.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public View abq() {
        if (this.bLk == null) {
            return null;
        }
        return this.bLk.acv();
    }

    private void abr() {
        if (this.bKN.mNavigationBar != null) {
            this.bKN.bMA.setText(String.format(this.bIF.getPageContext().getString(com.baidu.tieba.y.is_floor), Integer.valueOf(this.bLO)));
            this.bKN.bMA.setVisibility(0);
            if (this.bKN.bMD.getVisibility() == 0) {
                this.bKN.bMD.setVisibility(4);
                this.bLN = true;
            } else {
                this.bLN = false;
            }
            this.bKN.bMB.setVisibility(4);
            this.bKN.bMC.setVisibility(4);
            this.bKN.mNavigationBar.setVisibility(0);
        }
        if (this.aJU != null) {
            this.aJU.setVisibility(8);
        }
        if (this.bLR != null) {
            this.bLW = this.bLT.getVisibility() == 0;
            this.bLR.setVisibility(8);
            this.bLT.setVisibility(8);
        }
        if (this.bIF != null) {
            this.bIF.setSwipeBackEnabled(false);
        }
    }

    private void abs() {
        if (this.bKN.mNavigationBar != null) {
            this.bKN.hL(this.mForumName);
            this.bKN.bMB.setVisibility(0);
            this.bKN.bMC.setVisibility(0);
            if (this.bLN) {
                this.bKN.bMD.setVisibility(0);
            } else {
                this.bKN.bMD.setVisibility(4);
            }
            this.bKN.mNavigationBar.setVisibility(0);
        }
        if (this.aJU != null) {
            this.aJU.setVisibility(0);
        }
        if (this.bLR != null) {
            int visibility = this.bLh != null ? this.bLh.getVisibility() : 0;
            if (visibility == 0) {
                if (this.bLW) {
                    this.bLT.setVisibility(visibility);
                } else {
                    this.bLR.setVisibility(visibility);
                }
            } else {
                this.bLW = this.bLT.getVisibility() == 0;
                this.bLR.setVisibility(visibility);
                this.bLT.setVisibility(visibility);
            }
        }
        if (this.bIF != null) {
            this.bIF.setSwipeBackEnabled(true);
        }
    }

    public Button abt() {
        return this.bLQ;
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        if (this.bLR != null) {
            this.bLR.cmz.a(writeImagesInfo, z);
        }
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        if (this.bLR != null) {
            this.bLR.cmz.setBaobaoUris(writeImagesInfo);
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                this.bLR.alN();
            } else {
                this.bLR.alO();
            }
        }
    }

    public void h(com.baidu.tieba.pb.a.b bVar) {
        if (bVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.c.j> YQ = bVar.YQ();
            if (YQ.size() == 1) {
                com.baidu.tieba.tbadkCore.c.j jVar = YQ.get(0);
                if (jVar.amG() < jVar.amz().size()) {
                    this.aJU.setNextPage(null);
                    return;
                } else {
                    this.aJU.setNextPage(this.bLo);
                    return;
                }
            }
            this.aJU.setNextPage(this.bLo);
        }
    }

    public boolean Jc() {
        if (this.bLR == null) {
            return false;
        }
        return this.bLR.Jc();
    }

    public boolean abu() {
        if (this.bLk == null) {
            return false;
        }
        return this.bLk.Jc();
    }

    public void abv() {
        if (com.baidu.tbadk.performanceLog.ah.CK().CL()) {
            int lastVisiblePosition = this.aJU.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aJU.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(com.baidu.tieba.v.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.z perfLog = tbImageView.getPerfLog();
                                perfLog.eb(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                                perfLog.apl = true;
                                perfLog.apk = this.bIF.aJi;
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
                        perfLog2.apl = true;
                        perfLog2.apk = this.bIF.aJi;
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

    public void abw() {
        if (this.bLT != null) {
            this.bLT.setVisibility(0);
        }
    }

    public void abx() {
        if (this.bLT != null) {
            this.bLT.setVisibility(8);
        }
    }
}
