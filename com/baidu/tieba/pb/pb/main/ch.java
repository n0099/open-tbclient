package com.baidu.tieba.pb.pb.main;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
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
public class ch {
    private NoNetworkView aFX;
    private BdTypeListView aMl;
    private View.OnClickListener aNU;
    private com.baidu.tbadk.core.view.aj aaa;
    private View apg;
    private RelativeLayout bHG;
    private com.baidu.tieba.pb.b.d bKG;
    bd bKL;
    private PbActivity bKZ;
    private View.OnClickListener bLk;
    private View bNB;
    private RelativeLayout bNC;
    private bh bND;
    private PbListView bNI;
    private View bNK;
    public final com.baidu.tieba.pb.pb.main.b.a bNi;
    private View bNj;
    private ColumnLayout bNl;
    private TextView bNm;
    private TextView bNn;
    private HeadImageView bNo;
    private ImageView bNp;
    private ImageView bNq;
    private UserIconBox bNr;
    private UserIconBox bNs;
    private ImageView bNt;
    private TextView bNu;
    private TextView bNv;
    private View bNz;
    private bc bOB;
    private PbEditor bOh;
    private com.baidu.tbadk.editortool.v bOi;
    private View bOj;
    private TextView bOk;
    private TextView bOl;
    private TextView bOm;
    private boolean bOo;
    private View bOu;
    private LiveBroadcastCard bOv;
    private View bOw;
    private TextView bOx;
    private View bNk = null;
    public FrsPraiseView bNw = null;
    private View bNx = null;
    private View bNy = null;
    private View bNA = null;
    private com.baidu.tbadk.core.dialog.a bNE = null;
    private com.baidu.tbadk.core.dialog.e aNG = null;
    private View bNF = null;
    private EditText bNG = null;
    private com.baidu.tieba.pb.view.d bNH = null;
    private com.baidu.tieba.pb.view.b bNJ = null;
    private com.baidu.tbadk.core.dialog.h bjX = null;
    private com.baidu.tbadk.widget.richText.s auJ = null;
    private com.baidu.tbadk.core.view.ad aLO = null;
    private Dialog bNL = null;
    private com.baidu.tbadk.core.dialog.a bNM = null;
    private Dialog bNN = null;
    private View bNO = null;
    private int bNP = 0;
    private RadioGroup MG = null;
    private RadioButton bNQ = null;
    private RadioButton bNR = null;
    private RadioButton bNS = null;
    private Button bNT = null;
    private Button bNU = null;
    private TextView bNV = null;
    private Dialog bNW = null;
    private View bNX = null;
    private RadioGroup bNY = null;
    private CompoundButton.OnCheckedChangeListener bNZ = null;
    private Button bOa = null;
    private Button bOb = null;
    private String bOc = null;
    private com.baidu.tbadk.core.dialog.e bOd = null;
    private boolean bOe = false;
    private String mForumName = null;
    private ScrollView bOf = null;
    private Button bOg = null;
    private boolean bOn = true;
    private LinearLayout bOp = null;
    private TextView bOq = null;
    private TextView bOr = null;
    private View avI = null;
    private com.baidu.tbadk.core.view.b bOs = null;
    private boolean bLi = false;
    private boolean bOt = false;
    private boolean mIsFromCDN = true;
    private boolean bOy = true;
    private com.baidu.tieba.tbadkCore.c.h bOz = new ci(this);
    private final View.OnClickListener bOA = new cr(this);
    private View.OnLongClickListener bOC = null;
    private boolean bOD = false;
    private final List<TbImageView> bOE = new ArrayList();
    private boolean bLh = true;

    public NoNetworkView abS() {
        return this.aFX;
    }

    public void abT() {
        this.bOn = true;
        if (this.bOh != null) {
            this.bOh.setVisibility(8);
        }
        if (this.bOj != null) {
            this.bOj.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.j abU() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.aMl == null) {
            return null;
        }
        int firstVisiblePosition = this.aMl.getFirstVisiblePosition();
        int lastVisiblePosition = this.aMl.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.aMl.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.aMl.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.aMl.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.bND.hy(headerViewsCount) != null && this.bND.hy(headerViewsCount) != com.baidu.tieba.tbadkCore.data.j.cse) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.j) this.bND.ay(i2);
    }

    public ch(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.b.d dVar) {
        this.bKZ = null;
        this.bHG = null;
        this.aMl = null;
        this.bNj = null;
        this.bNl = null;
        this.bNm = null;
        this.bNn = null;
        this.bNo = null;
        this.bNp = null;
        this.bNq = null;
        this.bNr = null;
        this.bNs = null;
        this.bNt = null;
        this.bNu = null;
        this.bNv = null;
        this.bNz = null;
        this.bNB = null;
        this.bND = null;
        this.bNI = null;
        this.apg = null;
        this.aNU = null;
        this.bLk = null;
        this.bOj = null;
        this.bOk = null;
        this.bOm = null;
        this.bOw = null;
        this.bOx = null;
        this.bKZ = pbActivity;
        this.aNU = onClickListener;
        this.bKG = dVar;
        this.bHG = (RelativeLayout) com.baidu.adp.lib.g.b.hr().inflate(this.bKZ.getPageContext().getPageActivity(), com.baidu.tieba.r.new_pb_activity, null);
        this.bKZ.addContentView(this.bHG, new FrameLayout.LayoutParams(-1, -1));
        this.bNC = (RelativeLayout) this.bKZ.findViewById(com.baidu.tieba.q.title_wrapper);
        this.aFX = (NoNetworkView) this.bKZ.findViewById(com.baidu.tieba.q.view_no_network);
        this.aMl = (BdTypeListView) this.bKZ.findViewById(com.baidu.tieba.q.new_pb_list);
        View view = new View(this.bKZ.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.bKZ.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_editor_height)));
        this.aMl.addFooterView(view);
        this.bNi = new com.baidu.tieba.pb.pb.main.b.a(pbActivity);
        this.bNi.acF().setOnTouchListener(new com.baidu.tieba.pb.b.a(new cu(this)));
        this.bOj = this.bKZ.findViewById(com.baidu.tieba.q.pb_editor_tool_comment);
        this.bOk = (TextView) this.bKZ.findViewById(com.baidu.tieba.q.pb_editor_tool_comment_reply_text);
        this.bOm = (TextView) this.bKZ.findViewById(com.baidu.tieba.q.pb_editor_tool_comment_praise_icon);
        this.bOl = (TextView) this.bKZ.findViewById(com.baidu.tieba.q.pb_editor_tool_comment_reply_count_text);
        this.bOk.setOnClickListener(new cv(this));
        this.bOm.setOnClickListener(this.aNU);
        this.bOm.setOnTouchListener(this.bKZ);
        this.bNj = com.baidu.adp.lib.g.b.hr().inflate(this.bKZ.getPageContext().getPageActivity(), com.baidu.tieba.r.new_pb_header_item, null);
        this.bNl = (ColumnLayout) this.bNj.findViewById(com.baidu.tieba.q.pb_head_owner_root);
        this.bNl.setOnLongClickListener(this.bOC);
        this.bNl.setOnTouchListener(this.bKG);
        this.bNl.setVisibility(8);
        this.bNj.setOnTouchListener(this.bKG);
        this.bNm = (TextView) this.bNj.findViewById(com.baidu.tieba.q.pb_head_post_title);
        this.bNm.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.bNm.setVisibility(8);
        this.bOw = this.bNj.findViewById(com.baidu.tieba.q.pb_head_activity_join_number_container);
        this.bOw.setVisibility(8);
        this.bOx = (TextView) this.bNj.findViewById(com.baidu.tieba.q.pb_head_activity_join_number);
        this.bNn = (TextView) this.bNl.findViewById(com.baidu.tieba.q.pb_head_owner_info_user_name);
        this.bNo = (HeadImageView) this.bNl.findViewById(com.baidu.tieba.q.pb_head_owner_photo);
        if (!this.bLh) {
            this.bNo.setVisibility(8);
        }
        this.bNp = (ImageView) this.bNl.findViewById(com.baidu.tieba.q.pb_head_owner_info_user_rank);
        this.bNq = (ImageView) this.bNl.findViewById(com.baidu.tieba.q.pb_head_owner_info_user_gender);
        this.bNr = (UserIconBox) this.bNl.findViewById(com.baidu.tieba.q.pb_head_owner_info_user_icon);
        this.bNs = (UserIconBox) this.bNl.findViewById(com.baidu.tieba.q.pb_head_owner_info_tshow_icon);
        this.bNt = (ImageView) this.bNl.findViewById(com.baidu.tieba.q.pb_head_owner_info_floor_owner);
        this.bNu = (TextView) this.bNl.findViewById(com.baidu.tieba.q.pb_head_owner_info_time);
        this.bNv = (TextView) this.bNj.findViewById(com.baidu.tieba.q.pb_head_reverse_hint);
        this.bNv.setOnClickListener(this.aNU);
        this.bNv.setVisibility(8);
        this.bNz = this.bNj.findViewById(com.baidu.tieba.q.new_pb_header_item_line_below_livepost);
        this.bNB = this.bNj.findViewById(com.baidu.tieba.q.new_pb_header_item_line_above_showpassed);
        this.bNj.setOnLongClickListener(new cw(this));
        acb();
        this.bND = new bh(this.bKZ, this.aMl);
        this.bND.u(this.aNU);
        this.bND.a(this.bKG);
        this.bND.setOnImageClickListener(this.auJ);
        this.bLk = new cx(this);
        this.bND.t(this.bLk);
        this.aMl.addHeaderView(this.bNj);
        this.bNI = new PbListView(this.bKZ.getPageContext().getPageActivity());
        this.apg = this.bNI.getView().findViewById(com.baidu.tieba.q.pb_more_view);
        if (this.apg != null) {
            this.apg.setOnClickListener(this.aNU);
            com.baidu.tbadk.core.util.ay.i(this.apg, com.baidu.tieba.p.pb_foot_more_trans_selector);
        }
        this.bNI.uw();
        this.bNI.cw(com.baidu.tieba.p.pb_foot_more_trans_selector);
        this.bNI.cx(com.baidu.tieba.p.pb_foot_more_trans_selector);
        this.bNK = this.bKZ.findViewById(com.baidu.tieba.q.viewstub_progress);
    }

    public void ec(boolean z) {
        this.bNi.ec(z);
        if (z && this.bOt) {
            this.bNI.setText(this.bKZ.getResources().getString(com.baidu.tieba.t.click_load_more));
            this.aMl.setNextPage(this.bNI);
        }
    }

    public PbEditor Ki() {
        return this.bOh;
    }

    public void abV() {
        if (this.bOh != null) {
            this.bHG.removeView(this.bOh);
            this.bOh = null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void abW() {
        if (this.bKZ != null) {
            this.bOh = new PbEditor(this.bKZ.getPageContext().getPageActivity());
            this.bOh.setOrientation(1);
            this.bOh.setFrom(1);
            this.bOh.aX(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bHG.addView(this.bOh, layoutParams);
            this.bOh.b(this.bKZ.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            abX();
            if (this.bOh.cqO != null) {
                this.bOh.cqO.setAudioCanUse(acE());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void abX() {
        if (this.bOh != null) {
            this.bOh.a(this.bKZ.getPageContext(), new cy(this));
        }
    }

    public void is(String str) {
        if (this.bOl != null) {
            if (TextUtils.isEmpty(str)) {
                str = GameInfoData.NOT_FROM_DETAIL;
            }
            this.bOl.setText(this.bKZ.getPageContext().getResources().getString(com.baidu.tieba.t.pb_reply_count_text, str));
        }
    }

    public void z(String str, boolean z) {
        this.bOo = z;
        ed(TbadkCoreApplication.m411getInst().getSkinType() == 1);
    }

    private void ed(boolean z) {
        if (this.bOm != null) {
            if (this.bOo) {
                com.baidu.tbadk.core.util.ay.i((View) this.bOm, com.baidu.tieba.p.pb_praise_already_click_selector);
            } else {
                com.baidu.tbadk.core.util.ay.i((View) this.bOm, com.baidu.tieba.p.pb_praise_normal_click_selector);
            }
        }
    }

    public TextView abY() {
        return this.bOm;
    }

    public void ee(boolean z) {
        if (this.aMl != null) {
            if (!z) {
                this.aMl.setEnabled(z);
            } else {
                this.aMl.postDelayed(new cz(this, z), 10L);
            }
        }
    }

    public void O(View view) {
        boolean z;
        View view2;
        if (this.bNC != null && view != null) {
            if (this.bOn) {
                z = this.bOj.getVisibility() == 0;
            } else {
                z = this.bOh != null && this.bOh.getVisibility() == 0;
            }
            boolean z2 = this.bNC.getVisibility() == 0;
            if (z2) {
                View findViewById = this.bKZ.findViewById(com.baidu.tieba.q.bg_above_list);
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.bNC.getHeight()));
                com.baidu.tieba.tbadkCore.a.a(this.bKZ, this.bNC, com.baidu.tieba.k.top_fold_up, new da(this, findViewById));
            } else {
                com.baidu.tieba.tbadkCore.a.a(this.bKZ, this.bNC, com.baidu.tieba.k.top_fold_down, new cj(this));
            }
            if (this.bOn) {
                view2 = this.bOj;
            } else {
                view2 = this.bOh;
            }
            if (z) {
                if (z2) {
                    if (this.bOh != null) {
                        this.bOh.anT();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.bKZ, view2, com.baidu.tieba.k.bottom_fold_down, new ck(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.bKZ, view2, com.baidu.tieba.k.bottom_fold_up, new cl(this));
            }
        }
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.bOh == null) {
            return null;
        }
        return this.bOh.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.bOh != null) {
            this.bOh.setAudioData(voiceModel);
        }
    }

    public void Kr() {
        if (this.bOh != null) {
            this.bOh.Kr();
        }
    }

    public void abZ() {
        if (this.bOh != null) {
            this.bOh.abZ();
        }
    }

    public bh aca() {
        return this.bND;
    }

    public void a(bd bdVar) {
        this.bKL = bdVar;
    }

    private void a(com.baidu.tbadk.core.data.z zVar) {
        if (zVar != null && zVar.rF() != 0) {
            if (this.bOg == null) {
                this.bKZ.getLayoutMode().j(((ViewStub) this.bNj.findViewById(com.baidu.tieba.q.live_talk_layout)).inflate());
                this.bOg = (Button) this.bNj.findViewById(com.baidu.tieba.q.pb_head_function_manage_go_to_live_post);
                this.bNy = this.bNj.findViewById(com.baidu.tieba.q.new_pb_header_item_line_above_livepost);
            }
            int rG = zVar.rG();
            String string = this.bKZ.getPageContext().getString(com.baidu.tieba.t.go_to_live_post_prefix);
            if (rG == 0) {
                string = String.valueOf(string) + this.bKZ.getPageContext().getString(com.baidu.tieba.t.go_to_interview_post);
            } else if (rG == 1) {
                string = String.valueOf(string) + this.bKZ.getPageContext().getString(com.baidu.tieba.t.go_to_discuss_post);
            }
            this.bOg.setText(string);
            this.bOg.setVisibility(0);
            this.bOg.setOnClickListener(this.aNU);
            aco();
        }
    }

    private void acb() {
        this.bOp = (LinearLayout) this.bNj.findViewById(com.baidu.tieba.q.btn_show_passed_pb);
        this.bOr = (TextView) this.bNj.findViewById(com.baidu.tieba.q.show_pre_page_view);
        this.bOq = (TextView) this.bNj.findViewById(com.baidu.tieba.q.go_back_top_view);
        this.avI = this.bNj.findViewById(com.baidu.tieba.q.show_passed_divider);
        this.bOr.setOnClickListener(this.bOA);
        this.bOq.setOnClickListener(this.aNU);
        aco();
    }

    public void P(View view) {
        if (this.bNL == null) {
            this.bNL = new Dialog(this.bKZ.getPageContext().getPageActivity(), com.baidu.tieba.u.common_alert_dialog);
            this.bNL.setCanceledOnTouchOutside(true);
            this.bNL.setCancelable(true);
            this.bNL.setContentView(com.baidu.adp.lib.g.b.hr().inflate(this.bKZ.getPageContext().getPageActivity(), com.baidu.tieba.r.forum_manage_dialog, null));
            WindowManager.LayoutParams attributes = this.bNL.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.n.M(this.bKZ.getPageContext().getPageActivity()) * 0.9d);
            this.bNL.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.bNL.findViewById(com.baidu.tieba.q.del_post_btn);
        Button button2 = (Button) this.bNL.findViewById(com.baidu.tieba.q.forbid_user_btn);
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if ("".equals(sparseArray.get(com.baidu.tieba.q.tag_del_post_id))) {
                button.setVisibility(8);
            } else {
                SparseArray sparseArray2 = (SparseArray) button.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    button.setTag(sparseArray2);
                }
                button.setVisibility(0);
                sparseArray2.put(com.baidu.tieba.q.tag_del_post_id, sparseArray.get(com.baidu.tieba.q.tag_del_post_id));
                sparseArray2.put(com.baidu.tieba.q.tag_del_post_type, sparseArray.get(com.baidu.tieba.q.tag_del_post_type));
                sparseArray2.put(com.baidu.tieba.q.tag_del_post_is_self, sparseArray.get(com.baidu.tieba.q.tag_del_post_is_self));
                sparseArray2.put(com.baidu.tieba.q.tag_manage_user_identity, sparseArray.get(com.baidu.tieba.q.tag_manage_user_identity));
                button.setOnClickListener(new cm(this));
            }
            if ("".equals(sparseArray.get(com.baidu.tieba.q.tag_forbid_user_name))) {
                button2.setVisibility(8);
            } else {
                SparseArray sparseArray3 = (SparseArray) button2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    button2.setTag(sparseArray3);
                }
                button2.setVisibility(0);
                sparseArray3.put(com.baidu.tieba.q.tag_forbid_user_name, sparseArray.get(com.baidu.tieba.q.tag_forbid_user_name));
                sparseArray3.put(com.baidu.tieba.q.tag_manage_user_identity, sparseArray.get(com.baidu.tieba.q.tag_manage_user_identity));
                sparseArray3.put(com.baidu.tieba.q.tag_forbid_user_post_id, sparseArray.get(com.baidu.tieba.q.tag_forbid_user_post_id));
                button2.setOnClickListener(new cn(this));
            }
            com.baidu.adp.lib.g.k.a(this.bNL, this.bKZ.getPageContext());
        }
    }

    public void a(bc bcVar) {
        this.bOB = bcVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(com.baidu.tieba.q.tag_del_post_id, str);
        sparseArray.put(com.baidu.tieba.q.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(com.baidu.tieba.q.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(com.baidu.tieba.q.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = com.baidu.tieba.t.del_post_confirm;
        if (i == 0) {
            i3 = com.baidu.tieba.t.del_thread_confirm;
        }
        this.bNM = new com.baidu.tbadk.core.dialog.a(this.bKZ.getActivity());
        this.bNM.bu(i3);
        this.bNM.v(sparseArray);
        this.bNM.a(com.baidu.tieba.t.dialog_ok, this.bKZ);
        this.bNM.b(com.baidu.tieba.t.dialog_cancel, new co(this));
        this.bNM.ag(true);
        this.bNM.b(this.bKZ.getPageContext());
        this.bNM.rL();
    }

    public void K(ArrayList<com.baidu.tbadk.core.data.l> arrayList) {
        if (this.bNW == null) {
            this.bNW = new Dialog(this.bKZ.getPageContext().getPageActivity(), com.baidu.tieba.u.common_alert_dialog);
            this.bNW.setCanceledOnTouchOutside(true);
            this.bNW.setCancelable(true);
            this.bNX = com.baidu.adp.lib.g.b.hr().inflate(this.bKZ.getPageContext().getPageActivity(), com.baidu.tieba.r.commit_good, null);
            this.bOf = (ScrollView) this.bNX.findViewById(com.baidu.tieba.q.good_scroll);
            this.bNW.setContentView(this.bNX);
            WindowManager.LayoutParams attributes = this.bNW.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.n.M(this.bKZ.getPageContext().getPageActivity()) * 0.9d);
            this.bNW.getWindow().setAttributes(attributes);
            this.bNZ = new cp(this);
            this.bNY = (RadioGroup) this.bNX.findViewById(com.baidu.tieba.q.good_class_group);
            this.bOb = (Button) this.bNX.findViewById(com.baidu.tieba.q.dialog_button_cancel);
            this.bOb.setOnClickListener(new cq(this));
            this.bOa = (Button) this.bNX.findViewById(com.baidu.tieba.q.dialog_button_ok);
            this.bOa.setOnClickListener(this.aNU);
        }
        this.bNY.removeAllViews();
        RadioButton radioButton = (RadioButton) com.baidu.adp.lib.g.b.hr().inflate(this.bKZ.getPageContext().getPageActivity(), com.baidu.tieba.r.good_class_radio_button, null);
        radioButton.setTag(GameInfoData.NOT_FROM_DETAIL);
        radioButton.setText(this.bKZ.getPageContext().getString(com.baidu.tieba.t.def_good_class));
        radioButton.setOnCheckedChangeListener(this.bNZ);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(com.baidu.adp.lib.util.n.dip2px(this.bKZ.getPageContext().getPageActivity(), 10.0f), com.baidu.adp.lib.util.n.dip2px(this.bKZ.getPageContext().getPageActivity(), 5.0f), com.baidu.adp.lib.util.n.dip2px(this.bKZ.getPageContext().getPageActivity(), 10.0f), com.baidu.adp.lib.util.n.dip2px(this.bKZ.getPageContext().getPageActivity(), 5.0f));
        this.bNY.addView(radioButton, layoutParams);
        this.bNY.requestLayout();
        this.bNY.check(radioButton.getId());
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                RadioButton radioButton2 = (RadioButton) com.baidu.adp.lib.g.b.hr().inflate(this.bKZ.getPageContext().getPageActivity(), com.baidu.tieba.r.good_class_radio_button, null);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).qI()));
                radioButton2.setText(arrayList.get(i2).qH());
                radioButton2.setOnCheckedChangeListener(this.bNZ);
                this.bNY.addView(radioButton2, layoutParams);
                this.bNY.requestLayout();
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bOf.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.n.dip2px(this.bKZ.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.n.dip2px(this.bKZ.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.n.dip2px(this.bKZ.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.bOf.setLayoutParams(layoutParams2);
            this.bOf.removeAllViews();
            this.bOf.addView(this.bNY);
        }
        com.baidu.adp.lib.g.k.a(this.bNW, this.bKZ.getPageContext());
    }

    public void acc() {
        this.bKZ.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.bKZ.hideProgressBar();
        if (z && z2) {
            this.bKZ.showToast(this.bKZ.getPageContext().getString(com.baidu.tieba.t.success));
        } else if (str != null && z2) {
            this.bKZ.showToast(str);
        }
    }

    public void Td() {
        this.bNK.setVisibility(0);
    }

    public void Tc() {
        this.bNK.setVisibility(8);
    }

    public View acd() {
        if (this.bNX != null) {
            return this.bNX.findViewById(com.baidu.tieba.q.dialog_button_ok);
        }
        return null;
    }

    public String ace() {
        return this.bOc;
    }

    public View getView() {
        return this.bHG;
    }

    public void acf() {
        View editText;
        if (this.bOh == null) {
            editText = this.bKZ.getCurrentFocus();
        } else {
            editText = this.bOh.getEditText();
        }
        com.baidu.adp.lib.util.n.c(this.bKZ.getPageContext().getPageActivity(), editText);
    }

    public void Ko() {
        this.bKZ.showProgressBar();
    }

    public void bT(boolean z) {
        this.bKZ.hideProgressBar();
        acw();
        if (z && this.bOh != null) {
            this.bOh.getEditText().setText("");
            this.bOh.anP();
            this.bOh.clearData();
        }
    }

    public void acg() {
        this.bNI.startLoadData();
    }

    public void ach() {
    }

    public void aci() {
        this.bKZ.hideProgressBar();
        this.bNI.ux();
        acD();
        this.aMl.completePullRefresh();
        aco();
    }

    public void acj() {
        this.aMl.completePullRefresh();
        this.bOp.setVisibility(8);
        aco();
    }

    public void ef(boolean z) {
        if (!z && this.bOh != null) {
            this.bOh.anR();
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            this.bOi = vVar;
            if (this.bOh != null) {
                abX();
            }
        }
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.bOC = onLongClickListener;
        this.bND.setOnLongClickListener(onLongClickListener);
    }

    public void u(ArrayList<String> arrayList) {
        if (this.bOh != null) {
            this.bOh.u(arrayList);
        }
    }

    public void ack() {
        this.bOD = true;
        if (this.bOh != null) {
            this.bOh.ack();
        }
    }

    public void acl() {
        this.bOD = false;
        if (this.bOh != null) {
            this.bOh.acl();
        }
    }

    public void a(com.baidu.tbadk.core.dialog.h hVar, boolean z, boolean z2) {
        if (this.bOd != null) {
            this.bOd.dismiss();
            this.bOd = null;
        }
        this.bOd = new com.baidu.tbadk.core.dialog.e(this.bKZ.getPageContext().getPageActivity());
        this.bOd.bx(com.baidu.tieba.t.operation);
        if (z2) {
            this.bOd.a(new String[]{this.bKZ.getPageContext().getString(com.baidu.tieba.t.copy)}, hVar);
        } else if (!z) {
            this.bOd.a(new String[]{this.bKZ.getPageContext().getString(com.baidu.tieba.t.copy), this.bKZ.getPageContext().getString(com.baidu.tieba.t.mark)}, hVar);
        } else {
            this.bOd.a(new String[]{this.bKZ.getPageContext().getString(com.baidu.tieba.t.copy), this.bKZ.getPageContext().getString(com.baidu.tieba.t.remove_mark)}, hVar);
        }
        this.bOd.d(this.bKZ.getPageContext());
        this.bOd.rN();
    }

    public void k(Bitmap bitmap) {
        if (this.bOh != null) {
            this.bOh.k(bitmap);
            this.bOh.anO();
        }
    }

    public void acm() {
        if (this.bOh != null) {
            this.bOh.k(null);
        }
    }

    public int acn() {
        int firstVisiblePosition = this.aMl.getFirstVisiblePosition();
        com.baidu.adp.widget.ListView.g gVar = (com.baidu.adp.widget.ListView.g) this.aMl.getAdapter();
        if (gVar != null) {
            if (gVar.getItem(firstVisiblePosition) instanceof com.baidu.tieba.pb.a.a) {
                firstVisiblePosition++;
            }
            int headersCount = (this.aMl.getAdapter() == null || !(this.aMl.getAdapter() instanceof com.baidu.adp.widget.ListView.g)) ? 0 : ((com.baidu.adp.widget.ListView.g) this.aMl.getAdapter()).getHeadersCount();
            return firstVisiblePosition > headersCount ? firstVisiblePosition - headersCount : 0;
        }
        return firstVisiblePosition;
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.bNG.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public String Kp() {
        return this.bOh == null ? "" : this.bOh.getContent();
    }

    public void gj(String str) {
        if (this.bOh != null) {
            this.bOh.setContent(str);
        }
    }

    public void e(com.baidu.tieba.pb.a.b bVar) {
        this.bND.b(bVar);
        this.bND.notifyDataSetChanged();
        if (bVar == null) {
            is("");
        } else {
            is(com.baidu.tbadk.core.util.bb.q(bVar.aas().getReply_num()));
        }
        aco();
    }

    public void f(com.baidu.tieba.pb.a.b bVar) {
        PraiseData praise;
        if (this.bNw == null) {
            this.bKZ.getLayoutMode().j(((ViewStub) this.bNj.findViewById(com.baidu.tieba.q.praise_layout)).inflate());
            this.bNw = (FrsPraiseView) this.bNj.findViewById(com.baidu.tieba.q.pb_head_praise_view);
            this.bNw.setIsFromPb(true);
            this.bNA = this.bNj.findViewById(com.baidu.tieba.q.new_pb_header_item_line_above_praise);
            this.bNw.cz(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.bNw != null) {
            boolean aco = aco();
            if (bVar != null && bVar.aat() != null && bVar.aat().size() > 0) {
                com.baidu.tieba.tbadkCore.data.j jVar = bVar.aat().get(0);
                if ((!this.bLi || jVar.aoB() != 1) && (praise = bVar.aas().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.bNw.setVisibility(0);
                    this.bNw.setIsFromPb(true);
                    this.bNw.a(praise, bVar.aas().getId(), praise.getPostId(), true);
                    this.bNA.setVisibility(0);
                    if (this.bNw.getVisibility() == 0) {
                        this.bNB.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.bNw.setVisibility(8);
            this.bNA.setVisibility(8);
            if (bVar != null && bVar.Zp() != null && bVar.Zp().qS() == 0 && this.bLi) {
                this.bNA.setVisibility(8);
                if (aco) {
                    this.bNz.setVisibility(0);
                    return;
                } else {
                    this.bNz.setVisibility(8);
                    return;
                }
            }
            this.bNA.setVisibility(0);
            this.bNz.setVisibility(8);
        }
    }

    private com.baidu.tieba.tbadkCore.data.j a(com.baidu.tieba.pb.a.b bVar, boolean z, int i) {
        if (z) {
            if (bVar == null || bVar.aat() == null || bVar.aat().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.j jVar = bVar.aat().get(0);
            if (jVar.aoB() != 1) {
                return g(bVar);
            }
            return jVar;
        }
        return g(bVar);
    }

    private com.baidu.tieba.tbadkCore.data.j g(com.baidu.tieba.pb.a.b bVar) {
        MetaData metaData;
        if (bVar == null || bVar.aas() == null || bVar.aas().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.j jVar = new com.baidu.tieba.tbadkCore.data.j();
        MetaData author = bVar.aas().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = bVar.aas().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        jVar.iQ(1);
        jVar.setId(bVar.aas().rs());
        jVar.setTitle(bVar.aas().getTitle());
        jVar.setTime(bVar.aas().getCreateTime());
        jVar.a(metaData);
        return jVar;
    }

    private void b(com.baidu.tieba.pb.a.b bVar, boolean z, int i) {
        this.bNl.setVisibility(8);
        com.baidu.tieba.tbadkCore.data.j a = a(bVar, z, i);
        if (a != null) {
            if (z) {
                this.bNv.setVisibility(8);
            } else {
                this.bNv.setVisibility(0);
            }
            this.bNl.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.bNl.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.bNl.setTag(sparseArray);
            }
            sparseArray.put(com.baidu.tieba.q.tag_clip_board, a);
            sparseArray.put(com.baidu.tieba.q.tag_is_subpb, false);
            this.bNu.setText(com.baidu.tbadk.core.util.bb.o(a.getTime()));
            bVar.aas().ry();
            this.bNm.setVisibility(0);
            this.bNm.setText(bVar.aas().getSpan_str());
            f(bVar);
            ArrayList<com.baidu.tbadk.core.data.b> rp = bVar.aas().rp();
            if (rp != null && rp.size() > 0) {
                this.bOx.setText(String.valueOf(rp.get(0).qt()));
                this.bOw.setVisibility(0);
            } else {
                this.bOw.setVisibility(8);
            }
            com.baidu.tbadk.core.util.ay.i(this.bOw, com.baidu.tieba.p.activity_join_num_bg);
            com.baidu.tbadk.core.util.ay.b(this.bOx, com.baidu.tieba.n.cp_link_tip_d, 1);
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
            if (bVar != null && bVar.aas() != null && bVar.aas().getAnchorInfoData() != null) {
                if (bVar.aas().getAnchorInfoData().getGroup_id() != 0 && appResponseToIntentClass) {
                    if (this.bOu == null) {
                        BdLog.e("pb time   liveCardLayout new");
                        this.bOu = ((ViewStub) this.bNj.findViewById(com.baidu.tieba.q.live_card_layout)).inflate();
                        this.bKZ.getLayoutMode().j(this.bOu);
                        this.bOv = (LiveBroadcastCard) this.bNj.findViewById(com.baidu.tieba.q.item_card);
                    }
                    this.bOu.setVisibility(0);
                    LiveCardData liveCardData = new LiveCardData();
                    liveCardData.setPublisherId(bVar.aas().getAnchorInfoData().getAuthorId());
                    liveCardData.setPublisherName(bVar.aas().getAnchorInfoData().getAuthorName());
                    liveCardData.setPublisherPortrait(bVar.aas().getAnchorInfoData().getPublisherPortrait());
                    liveCardData.setGroupId(bVar.aas().getAnchorInfoData().getGroup_id());
                    liveCardData.setIntro(bVar.aas().getAnchorInfoData().getIntro());
                    liveCardData.setLikers(bVar.aas().getAnchorInfoData().getLikers());
                    liveCardData.setListeners(bVar.aas().getAnchorInfoData().getListeners());
                    liveCardData.setName(bVar.aas().getAnchorInfoData().getName());
                    liveCardData.setPortrait(bVar.aas().getAnchorInfoData().getPortrait());
                    liveCardData.setStatus(bVar.aas().getAnchorInfoData().getStatus());
                    liveCardData.setStartTime(bVar.aas().getAnchorInfoData().getStartTime());
                    liveCardData.setIsVip(bVar.aas().getAnchorInfoData().getIsVip());
                    this.bOv.setData(liveCardData);
                    this.bOv.setStatisticsKey("notice_pb_live");
                } else if (this.bOu != null) {
                    this.bOu.setVisibility(8);
                }
            }
            if (bVar != null && bVar.aas() != null && bVar.aas().getAuthor() != null) {
                String userId = bVar.aas().getAuthor().getUserId();
                if (userId != null && !userId.equals(GameInfoData.NOT_FROM_DETAIL) && userId.equals(a.getAuthor().getUserId())) {
                    this.bNt.setVisibility(0);
                } else {
                    this.bNt.setVisibility(8);
                }
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.bNp.setVisibility(0);
                    com.baidu.tbadk.core.util.ay.c(this.bNp, com.baidu.tbadk.core.util.c.bT(level_id));
                    i2 = 2;
                    this.bNp.setOnClickListener(null);
                } else {
                    this.bNp.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.ay.c(this.bNp, com.baidu.tieba.p.pb_manager);
                        this.bNp.setOnClickListener(this.bKZ.bKA.bOK);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.ay.c(this.bNp, com.baidu.tieba.p.pb_assist);
                        this.bNp.setOnClickListener(this.bKZ.bKA.bOK);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.ay.c(this.bNq, com.baidu.tieba.p.icon_pop_girl_square);
                    this.bNq.setVisibility(0);
                } else {
                    this.bNq.setVisibility(8);
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfo = a.getAuthor().getTShowInfo();
                if (this.bNr != null) {
                    this.bNr.setOnClickListener(this.bKZ.bKA.bOK);
                    this.bNr.a(iconInfo, i2, this.bKZ.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_width), this.bKZ.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_height), this.bKZ.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_margin));
                }
                if (this.bNs != null) {
                    this.bNs.setOnClickListener(this.bKZ.bKA.bOL);
                    this.bNs.a(tShowInfo, 3, this.bKZ.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_width), this.bKZ.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_height), this.bKZ.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_margin), true);
                }
                this.bNn.setText(a.getAuthor().getName_show());
                this.bNn.setTag(com.baidu.tieba.q.tag_user_id, a.getAuthor().getUserId());
                this.bNn.setTag(com.baidu.tieba.q.tag_user_name, a.getAuthor().getName_show());
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.ay.b(this.bNn, com.baidu.tieba.n.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ay.b(this.bNn, com.baidu.tieba.n.cp_cont_f, 1);
                }
                if (!this.bLh) {
                    this.bNo.setVisibility(8);
                }
                this.bNo.setUserId(a.getAuthor().getUserId());
                this.bNo.setUserName(a.getAuthor().getUserName());
                this.bNo.setImageDrawable(null);
                this.bNo.setTag(a.getAuthor().getUserId());
                this.bNn.setOnClickListener(this.bKZ.bKA.bOJ);
                this.bNo.setOnClickListener(this.bKZ.bKA.bOJ);
                this.bNo.c(a.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.b bVar, int i, int i2, boolean z, int i3) {
        Parcelable abL;
        Parcelable abL2;
        String sb;
        if (bVar != null) {
            this.bOt = false;
            this.bLi = z;
            aci();
            b(bVar, z, i);
            this.bND.dU(this.bLi);
            this.bND.b(bVar);
            this.bND.notifyDataSetChanged();
            if (bVar.aar() != null) {
                this.mForumName = bVar.aar().getName();
            }
            this.bNi.it(this.mForumName);
            if (bVar.aas() != null) {
                is(com.baidu.tbadk.core.util.bb.q(bVar.aas().getReply_num()));
                if (bVar.aas().getPraise() != null) {
                    if (bVar.aas().getPraise().getNum() < 1) {
                        sb = this.bKZ.getResources().getString(com.baidu.tieba.t.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(bVar.aas().getPraise().getNum())).toString();
                    }
                    z(sb, bVar.aas().getPraise().getIsLike() == 1);
                }
            }
            if (bVar.Zp().qR() == 0 && !z) {
                this.aMl.setNextPage(null);
            } else if (this.bKZ.isLogin()) {
                this.aMl.setNextPage(this.bNI);
                acD();
            } else if (bVar.Zp().qR() == 1) {
                this.bOt = true;
                if (this.bNJ == null) {
                    this.bNJ = new com.baidu.tieba.pb.view.b(this.bKZ.getPageContext());
                }
                this.aMl.setNextPage(this.bNJ);
            }
            if (bVar.Zp().qS() == 0 && z) {
                this.aMl.setPullRefresh(null);
                this.bOp.setVisibility(8);
            } else {
                if (this.bNH == null) {
                    this.bNH = new com.baidu.tieba.pb.view.d(this.bKZ.getPageContext());
                    this.bNH.ng();
                    this.bNH.a(this.aaa);
                }
                this.aMl.setPullRefresh(this.bNH);
                if (this.bNH != null) {
                    this.bNH.cy(TbadkCoreApplication.m411getInst().getSkinType());
                }
                this.bOp.setVisibility(0);
                acD();
            }
            aco();
            if (bVar.Zp().qR() == 0) {
                this.bNI.setText(this.bKZ.getResources().getString(com.baidu.tieba.t.list_no_more));
                h(bVar);
            } else {
                this.bNI.setText(this.bKZ.getResources().getString(com.baidu.tieba.t.pb_load_more));
            }
            if (z) {
                this.bOq.setVisibility(0);
                this.avI.setVisibility(0);
                this.bOr.setText(this.bKZ.getResources().getString(com.baidu.tieba.t.btn_show_passed_pb));
            } else {
                this.bOq.setVisibility(8);
                this.avI.setVisibility(8);
                this.bOr.setText(this.bKZ.getResources().getString(com.baidu.tieba.t.btn_show_passed_pb_aftre));
            }
            if (bVar.aas() != null && bVar.aas().getAuthor() != null && bVar.aas().getAuthor().getType() == 0) {
                this.bNi.acG();
            }
            switch (i) {
                case 2:
                    this.aMl.setSelection(i2);
                    if (this.bNk != null) {
                        CompatibleUtile.scrollListViewBy(this.aMl, -this.bNk.getHeight(), 0);
                        return;
                    }
                    return;
                case 3:
                    if (i3 == 1 && (abL2 = cb.abK().abL()) != null) {
                        this.aMl.onRestoreInstanceState(abL2);
                        return;
                    } else {
                        this.aMl.setSelection(0);
                        return;
                    }
                case 4:
                    if (z) {
                        this.aMl.setSelection(0);
                        return;
                    } else if (bVar.aat() != null) {
                        if (bVar.Zp() != null && bVar.Zp().qS() != 0) {
                            this.aMl.setSelection(bVar.aat().size() + 1);
                            return;
                        } else {
                            this.aMl.setSelection(bVar.aat().size());
                            return;
                        }
                    } else {
                        return;
                    }
                case 5:
                    this.aMl.setSelection(0);
                    return;
                case 6:
                    if (i3 == 1 && (abL = cb.abK().abL()) != null) {
                        this.aMl.onRestoreInstanceState(abL);
                        return;
                    } else if (z) {
                        this.aMl.setSelection(0);
                        return;
                    } else if (bVar.aat() != null) {
                        if (bVar.Zp() != null && bVar.Zp().qS() != 0) {
                            this.aMl.setSelection(bVar.aat().size() + 1);
                            return;
                        } else {
                            this.aMl.setSelection(bVar.aat().size());
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

    public void eg(boolean z) {
        this.bOe = z;
        this.bNi.eg(z);
    }

    public void ux() {
        if (this.bNI != null) {
            this.bNI.ux();
        }
        acD();
    }

    public void Lm() {
        this.aMl.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aco() {
        boolean z;
        boolean z2 = true;
        if (this.bNk != null && this.bNk.getVisibility() == 0) {
            if (this.bNx != null) {
                this.bNx.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.bNx != null) {
                this.bNx.setVisibility(8);
            }
            z = false;
        }
        if (this.bOg != null && this.bOg.getVisibility() == 0) {
            if (this.bNy != null) {
                this.bNy.setVisibility(0);
            }
        } else {
            if (this.bNy != null) {
                this.bNy.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.bNA == null || this.bNA.getVisibility() == 8) && z2 && this.bLi) {
            this.bNz.setVisibility(0);
        } else {
            this.bNz.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.pb.a.b bVar, boolean z, boolean z2) {
        if (bVar == null) {
            return false;
        }
        if (this.bNm != null) {
            if (bVar.aas().rr() == 0) {
                this.bNm.setVisibility(0);
                bVar.aas().ry();
                this.bNm.setText(bVar.aas().getSpan_str());
            } else {
                this.bNm.setVisibility(8);
            }
        }
        if (z) {
            if (this.bOu != null) {
                this.bOu.findViewById(com.baidu.tieba.q.pb_head_live_blank).setVisibility(8);
            }
        } else if (this.bOu != null) {
            this.bOu.findViewById(com.baidu.tieba.q.pb_head_live_blank).setVisibility(0);
        }
        this.bLi = z;
        com.baidu.tbadk.core.data.w aas = bVar.aas();
        if (aas != null) {
            a(aas.rj());
        }
        if (bVar.aav() == 1) {
            acp();
            Button button = (Button) this.bNj.findViewById(com.baidu.tieba.q.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.bNj.findViewById(com.baidu.tieba.q.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.bNj.findViewById(com.baidu.tieba.q.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.bNj.findViewById(com.baidu.tieba.q.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.aNU);
            button2.setOnClickListener(this.aNU);
            button3.setOnClickListener(this.aNU);
            button4.setOnClickListener(this.aNU);
            if (bVar.aas().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (bVar.aas().getIs_top() == 1) {
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

    private void acp() {
        if (this.bNk == null) {
            this.bNk = ((ViewStub) this.bNj.findViewById(com.baidu.tieba.q.pb_header_function_manage)).inflate();
            this.bKZ.getLayoutMode().j(this.bNk);
            this.bNx = this.bNj.findViewById(com.baidu.tieba.q.new_pb_header_item_line_above_manage);
            return;
        }
        this.bNk.setVisibility(0);
    }

    public void a(com.baidu.tieba.pb.a.b bVar, boolean z, boolean z2, int i) {
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (bVar != null) {
            a(bVar, z, z2);
            com.baidu.tieba.tbadkCore.data.j a = a(bVar, z, i);
            if (a != null) {
                if (bVar.aav() != 0 && a.getAuthor() != null) {
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
                    String userId3 = bVar.aas().getAuthor().getUserId();
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
                        sparseArray.put(com.baidu.tieba.q.tag_forbid_user_name, a.getAuthor().getUserName());
                        sparseArray.put(com.baidu.tieba.q.tag_forbid_user_post_id, a.getId());
                    }
                    sparseArray.put(com.baidu.tieba.q.tag_del_post_id, a.getId());
                    sparseArray.put(com.baidu.tieba.q.tag_del_post_type, 0);
                    sparseArray.put(com.baidu.tieba.q.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray.put(com.baidu.tieba.q.tag_manage_user_identity, Integer.valueOf(bVar.aav()));
                    sparseArray.put(com.baidu.tieba.q.tag_should_manage_visible, true);
                    a(com.baidu.tieba.t.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(com.baidu.tieba.q.tag_del_post_id, a.getId());
                    sparseArray2.put(com.baidu.tieba.q.tag_del_post_type, 0);
                    sparseArray2.put(com.baidu.tieba.q.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(com.baidu.tieba.q.tag_manage_user_identity, Integer.valueOf(bVar.aav()));
                    sparseArray2.put(com.baidu.tieba.q.tag_should_manage_visible, false);
                    a(com.baidu.tieba.t.delete, sparseArray2);
                }
            }
            aco();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        acp();
        Button button = (Button) this.bNj.findViewById(com.baidu.tieba.q.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.aNU);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.apg;
    }

    public BdListView getListView() {
        return this.aMl;
    }

    public int acq() {
        return com.baidu.tieba.q.richText;
    }

    public int Lt() {
        return com.baidu.tieba.q.user_icon_box;
    }

    public Button acr() {
        return (Button) this.bNj.findViewById(com.baidu.tieba.q.pb_head_function_manage_commit_good);
    }

    public Button acs() {
        return (Button) this.bNj.findViewById(com.baidu.tieba.q.pb_head_function_manage_cancel_good);
    }

    public Button act() {
        return (Button) this.bNj.findViewById(com.baidu.tieba.q.pb_head_function_manage_commit_top);
    }

    public Button acu() {
        return (Button) this.bNj.findViewById(com.baidu.tieba.q.pb_head_function_manage_cancel_top);
    }

    public void c(com.baidu.adp.widget.ListView.x xVar) {
        this.aMl.setOnSrollToBottomListener(xVar);
    }

    public void a(com.baidu.adp.widget.ListView.aa aaVar) {
        this.aMl.setOnSrollToTopListener(aaVar);
    }

    public void b(com.baidu.tbadk.core.dialog.h hVar) {
        this.bjX = hVar;
    }

    public void a(com.baidu.tbadk.core.view.aj ajVar) {
        this.aaa = ajVar;
        if (this.bNH != null) {
            this.bNH.a(ajVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.q qVar, com.baidu.tbadk.core.dialog.d dVar) {
        if (qVar != null) {
            int qP = qVar.qP();
            int qN = qVar.qN();
            if (this.bNE != null) {
                this.bNE.rL();
            } else {
                this.bNE = new com.baidu.tbadk.core.dialog.a(this.bKZ.getPageContext().getPageActivity());
                this.bNF = com.baidu.adp.lib.g.b.hr().inflate(this.bKZ.getPageContext().getPageActivity(), com.baidu.tieba.r.dialog_direct_pager, null);
                this.bNE.l(this.bNF);
                this.bNE.a(com.baidu.tieba.t.dialog_ok, dVar);
                this.bNE.b(com.baidu.tieba.t.dialog_cancel, new cs(this));
                this.bNE.b(this.bKZ.getPageContext()).rL();
            }
            this.bNG = (EditText) this.bNF.findViewById(com.baidu.tieba.q.input_page_number);
            this.bNG.setText("");
            this.bNG.setOnFocusChangeListener(new ct(this));
            TextView textView = (TextView) this.bNF.findViewById(com.baidu.tieba.q.current_page_number);
            if (qP <= 0) {
                qP = 1;
            }
            if (qN <= 0) {
                qN = 1;
            }
            textView.setText(MessageFormat.format(this.bKZ.getApplicationContext().getResources().getString(com.baidu.tieba.t.current_page), Integer.valueOf(qP), Integer.valueOf(qN)));
            this.bKZ.ShowSoftKeyPadDelay(this.bNG, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aMl.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.bKZ.showToast(str);
    }

    public boolean eh(boolean z) {
        if (this.bOh == null || !this.bOh.anw()) {
            return false;
        }
        this.bOh.anU();
        return true;
    }

    public void acv() {
        if (this.bOE != null) {
            while (this.bOE.size() > 0) {
                TbImageView remove = this.bOE.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        acv();
    }

    public void onDestroy() {
        this.bKZ.hideProgressBar();
        if (this.aFX != null && this.aLO != null) {
            this.aFX.b(this.aLO);
        }
        acw();
        this.bNI.ux();
    }

    public void acw() {
        this.bNi.pA();
        com.baidu.adp.lib.util.n.c(this.bKZ.getPageContext().getPageActivity(), this.bNG);
        if (this.bOh != null) {
            this.bOh.anS();
        }
        if (this.bOd != null) {
            this.bOd.dismiss();
        }
        acx();
    }

    public void setIsShowImage(boolean z) {
        this.bND.setIsShowImage(z);
    }

    public void dT(boolean z) {
        this.bLh = z;
        this.bND.dT(z);
    }

    public void acx() {
        if (this.bNM != null) {
            this.bNM.dismiss();
        }
        if (this.bNN != null) {
            com.baidu.adp.lib.g.k.b(this.bNN, this.bKZ.getPageContext());
        }
        if (this.bNW != null) {
            com.baidu.adp.lib.g.k.b(this.bNW, this.bKZ.getPageContext());
        }
        if (this.bNL != null) {
            com.baidu.adp.lib.g.k.b(this.bNL, this.bKZ.getPageContext());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.bKZ.getLayoutMode().ab(i == 1);
        this.bKZ.getLayoutMode().j(this.bHG);
        this.bKZ.getLayoutMode().j(this.bNj);
        this.bKZ.getLayoutMode().j(this.apg);
        this.bNi.mNavigationBar.onChangeSkinType(this.bKZ.getPageContext(), i);
        if (this.bNF != null) {
            this.bKZ.getLayoutMode().j(this.bNF);
        }
        eg(this.bOe);
        this.bND.notifyDataSetChanged();
        if (this.bNH != null) {
            this.bNH.cy(i);
        }
        if (this.bNI != null) {
            this.bNI.cy(i);
            com.baidu.tbadk.core.util.ay.i(this.apg, com.baidu.tieba.p.pb_foot_more_trans_selector);
            this.bNI.cw(com.baidu.tieba.p.pb_foot_more_trans_selector);
        }
        if (this.bOh != null) {
            this.bOh.b(this.bKZ.getPageContext(), i);
        }
        if (this.bNw != null) {
            this.bNw.cz(i);
        }
        if (this.bNJ != null) {
            this.bNJ.cy(i);
        }
        ed(i == 1);
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.auJ = sVar;
        this.bND.setOnImageClickListener(this.auJ);
    }

    public void f(com.baidu.tbadk.core.view.ad adVar) {
        this.aLO = adVar;
        if (this.aFX != null) {
            this.aFX.a(this.aLO);
        }
    }

    public void ei(boolean z) {
        this.bND.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button acy() {
        return this.bOg;
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        if (this.bOh != null) {
            this.bOh.cqO.a(writeImagesInfo, z);
        }
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        if (this.bOh != null) {
            this.bOh.cqO.setBaobaoUris(writeImagesInfo);
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                this.bOh.anO();
            } else {
                this.bOh.anP();
            }
        }
    }

    public void h(com.baidu.tieba.pb.a.b bVar) {
        if (bVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aat = bVar.aat();
            if (aat.size() == 1) {
                com.baidu.tieba.tbadkCore.data.j jVar = aat.get(0);
                if (jVar.aoH() < jVar.aoA().size()) {
                    this.aMl.setNextPage(null);
                    return;
                } else {
                    this.aMl.setNextPage(this.bNI);
                    return;
                }
            }
            this.aMl.setNextPage(this.bNI);
        }
    }

    public boolean Km() {
        if (this.bOh == null) {
            return false;
        }
        return this.bOh.Km();
    }

    public void acz() {
        if (com.baidu.tbadk.performanceLog.ah.DB().DC()) {
            int lastVisiblePosition = this.aMl.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aMl.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(com.baidu.tieba.q.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.z perfLog = tbImageView.getPerfLog();
                                perfLog.el(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                                perfLog.aqw = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView.uq();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(com.baidu.tieba.q.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.z perfLog2 = headImageView.getPerfLog();
                        perfLog2.el(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                        perfLog2.aqw = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                            }
                        }
                        headImageView.uq();
                    }
                }
            }
        }
    }

    public void acA() {
        if (this.bOj != null) {
            this.bOj.setVisibility(0);
        }
    }

    public void acB() {
        if (this.bOj != null) {
            this.bOj.setVisibility(8);
        }
    }

    public TextView acC() {
        return this.bOq;
    }

    public void WO() {
        if (this.bOs == null) {
            this.bOs = new com.baidu.tbadk.core.view.b(this.bKZ.getPageContext());
        }
        this.bOs.ar(true);
    }

    public void acD() {
        if (this.bOs != null) {
            this.bOs.ar(false);
        }
    }

    public boolean acE() {
        return this.bOy;
    }

    public void setAudioCanUse(boolean z) {
        this.bOy = z;
        if (this.bOh != null && this.bOh.cqO != null) {
            this.bOh.cqO.setAudioCanUse(z);
        }
    }
}
