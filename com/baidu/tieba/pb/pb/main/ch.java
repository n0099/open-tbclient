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
    private NoNetworkView aFY;
    private BdTypeListView aMm;
    private View.OnClickListener aNV;
    private com.baidu.tbadk.core.view.aj aaa;
    private View apg;
    private RelativeLayout bHH;
    private com.baidu.tieba.pb.b.d bKH;
    bd bKM;
    private PbActivity bLa;
    private View.OnClickListener bLl;
    private View bNA;
    private View bNC;
    private RelativeLayout bND;
    private bh bNE;
    private PbListView bNJ;
    private View bNL;
    public final com.baidu.tieba.pb.pb.main.b.a bNj;
    private View bNk;
    private ColumnLayout bNm;
    private TextView bNn;
    private TextView bNo;
    private HeadImageView bNp;
    private ImageView bNq;
    private ImageView bNr;
    private UserIconBox bNs;
    private UserIconBox bNt;
    private ImageView bNu;
    private TextView bNv;
    private TextView bNw;
    private bc bOC;
    private PbEditor bOi;
    private com.baidu.tbadk.editortool.v bOj;
    private View bOk;
    private TextView bOl;
    private TextView bOm;
    private TextView bOn;
    private boolean bOp;
    private View bOv;
    private LiveBroadcastCard bOw;
    private View bOx;
    private TextView bOy;
    private View bNl = null;
    public FrsPraiseView bNx = null;
    private View bNy = null;
    private View bNz = null;
    private View bNB = null;
    private com.baidu.tbadk.core.dialog.a bNF = null;
    private com.baidu.tbadk.core.dialog.e aNH = null;
    private View bNG = null;
    private EditText bNH = null;
    private com.baidu.tieba.pb.view.d bNI = null;
    private com.baidu.tieba.pb.view.b bNK = null;
    private com.baidu.tbadk.core.dialog.h bjY = null;
    private com.baidu.tbadk.widget.richText.s auJ = null;
    private com.baidu.tbadk.core.view.ad aLP = null;
    private Dialog bNM = null;
    private com.baidu.tbadk.core.dialog.a bNN = null;
    private Dialog bNO = null;
    private View bNP = null;
    private int bNQ = 0;
    private RadioGroup MG = null;
    private RadioButton bNR = null;
    private RadioButton bNS = null;
    private RadioButton bNT = null;
    private Button bNU = null;
    private Button bNV = null;
    private TextView bNW = null;
    private Dialog bNX = null;
    private View bNY = null;
    private RadioGroup bNZ = null;
    private CompoundButton.OnCheckedChangeListener bOa = null;
    private Button bOb = null;
    private Button bOc = null;
    private String bOd = null;
    private com.baidu.tbadk.core.dialog.e bOe = null;
    private boolean bOf = false;
    private String mForumName = null;
    private ScrollView bOg = null;
    private Button bOh = null;
    private boolean bOo = true;
    private LinearLayout bOq = null;
    private TextView bOr = null;
    private TextView bOs = null;
    private View avI = null;
    private com.baidu.tbadk.core.view.b bOt = null;
    private boolean bLj = false;
    private boolean bOu = false;
    private boolean mIsFromCDN = true;
    private boolean bOz = true;
    private com.baidu.tieba.tbadkCore.c.h bOA = new ci(this);
    private final View.OnClickListener bOB = new cr(this);
    private View.OnLongClickListener bOD = null;
    private boolean bOE = false;
    private final List<TbImageView> bOF = new ArrayList();
    private boolean bLi = true;

    public NoNetworkView abT() {
        return this.aFY;
    }

    public void abU() {
        this.bOo = true;
        if (this.bOi != null) {
            this.bOi.setVisibility(8);
        }
        if (this.bOk != null) {
            this.bOk.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.j abV() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.aMm == null) {
            return null;
        }
        int firstVisiblePosition = this.aMm.getFirstVisiblePosition();
        int lastVisiblePosition = this.aMm.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.aMm.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.aMm.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.aMm.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.bNE.hy(headerViewsCount) != null && this.bNE.hy(headerViewsCount) != com.baidu.tieba.tbadkCore.data.j.csf) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.j) this.bNE.ay(i2);
    }

    public ch(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.b.d dVar) {
        this.bLa = null;
        this.bHH = null;
        this.aMm = null;
        this.bNk = null;
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
        this.bNw = null;
        this.bNA = null;
        this.bNC = null;
        this.bNE = null;
        this.bNJ = null;
        this.apg = null;
        this.aNV = null;
        this.bLl = null;
        this.bOk = null;
        this.bOl = null;
        this.bOn = null;
        this.bOx = null;
        this.bOy = null;
        this.bLa = pbActivity;
        this.aNV = onClickListener;
        this.bKH = dVar;
        this.bHH = (RelativeLayout) com.baidu.adp.lib.g.b.hr().inflate(this.bLa.getPageContext().getPageActivity(), com.baidu.tieba.r.new_pb_activity, null);
        this.bLa.addContentView(this.bHH, new FrameLayout.LayoutParams(-1, -1));
        this.bND = (RelativeLayout) this.bLa.findViewById(com.baidu.tieba.q.title_wrapper);
        this.aFY = (NoNetworkView) this.bLa.findViewById(com.baidu.tieba.q.view_no_network);
        this.aMm = (BdTypeListView) this.bLa.findViewById(com.baidu.tieba.q.new_pb_list);
        View view = new View(this.bLa.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.bLa.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_editor_height)));
        this.aMm.addFooterView(view);
        this.bNj = new com.baidu.tieba.pb.pb.main.b.a(pbActivity);
        this.bNj.acG().setOnTouchListener(new com.baidu.tieba.pb.b.a(new cu(this)));
        this.bOk = this.bLa.findViewById(com.baidu.tieba.q.pb_editor_tool_comment);
        this.bOl = (TextView) this.bLa.findViewById(com.baidu.tieba.q.pb_editor_tool_comment_reply_text);
        this.bOn = (TextView) this.bLa.findViewById(com.baidu.tieba.q.pb_editor_tool_comment_praise_icon);
        this.bOm = (TextView) this.bLa.findViewById(com.baidu.tieba.q.pb_editor_tool_comment_reply_count_text);
        this.bOl.setOnClickListener(new cv(this));
        this.bOn.setOnClickListener(this.aNV);
        this.bOn.setOnTouchListener(this.bLa);
        this.bNk = com.baidu.adp.lib.g.b.hr().inflate(this.bLa.getPageContext().getPageActivity(), com.baidu.tieba.r.new_pb_header_item, null);
        this.bNm = (ColumnLayout) this.bNk.findViewById(com.baidu.tieba.q.pb_head_owner_root);
        this.bNm.setOnLongClickListener(this.bOD);
        this.bNm.setOnTouchListener(this.bKH);
        this.bNm.setVisibility(8);
        this.bNk.setOnTouchListener(this.bKH);
        this.bNn = (TextView) this.bNk.findViewById(com.baidu.tieba.q.pb_head_post_title);
        this.bNn.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.bNn.setVisibility(8);
        this.bOx = this.bNk.findViewById(com.baidu.tieba.q.pb_head_activity_join_number_container);
        this.bOx.setVisibility(8);
        this.bOy = (TextView) this.bNk.findViewById(com.baidu.tieba.q.pb_head_activity_join_number);
        this.bNo = (TextView) this.bNm.findViewById(com.baidu.tieba.q.pb_head_owner_info_user_name);
        this.bNp = (HeadImageView) this.bNm.findViewById(com.baidu.tieba.q.pb_head_owner_photo);
        if (!this.bLi) {
            this.bNp.setVisibility(8);
        }
        this.bNq = (ImageView) this.bNm.findViewById(com.baidu.tieba.q.pb_head_owner_info_user_rank);
        this.bNr = (ImageView) this.bNm.findViewById(com.baidu.tieba.q.pb_head_owner_info_user_gender);
        this.bNs = (UserIconBox) this.bNm.findViewById(com.baidu.tieba.q.pb_head_owner_info_user_icon);
        this.bNt = (UserIconBox) this.bNm.findViewById(com.baidu.tieba.q.pb_head_owner_info_tshow_icon);
        this.bNu = (ImageView) this.bNm.findViewById(com.baidu.tieba.q.pb_head_owner_info_floor_owner);
        this.bNv = (TextView) this.bNm.findViewById(com.baidu.tieba.q.pb_head_owner_info_time);
        this.bNw = (TextView) this.bNk.findViewById(com.baidu.tieba.q.pb_head_reverse_hint);
        this.bNw.setOnClickListener(this.aNV);
        this.bNw.setVisibility(8);
        this.bNA = this.bNk.findViewById(com.baidu.tieba.q.new_pb_header_item_line_below_livepost);
        this.bNC = this.bNk.findViewById(com.baidu.tieba.q.new_pb_header_item_line_above_showpassed);
        this.bNk.setOnLongClickListener(new cw(this));
        acc();
        this.bNE = new bh(this.bLa, this.aMm);
        this.bNE.u(this.aNV);
        this.bNE.a(this.bKH);
        this.bNE.setOnImageClickListener(this.auJ);
        this.bLl = new cx(this);
        this.bNE.t(this.bLl);
        this.aMm.addHeaderView(this.bNk);
        this.bNJ = new PbListView(this.bLa.getPageContext().getPageActivity());
        this.apg = this.bNJ.getView().findViewById(com.baidu.tieba.q.pb_more_view);
        if (this.apg != null) {
            this.apg.setOnClickListener(this.aNV);
            com.baidu.tbadk.core.util.ay.i(this.apg, com.baidu.tieba.p.pb_foot_more_trans_selector);
        }
        this.bNJ.uw();
        this.bNJ.cw(com.baidu.tieba.p.pb_foot_more_trans_selector);
        this.bNJ.cx(com.baidu.tieba.p.pb_foot_more_trans_selector);
        this.bNL = this.bLa.findViewById(com.baidu.tieba.q.viewstub_progress);
    }

    public void ec(boolean z) {
        this.bNj.ec(z);
        if (z && this.bOu) {
            this.bNJ.setText(this.bLa.getResources().getString(com.baidu.tieba.t.click_load_more));
            this.aMm.setNextPage(this.bNJ);
        }
    }

    public PbEditor Kj() {
        return this.bOi;
    }

    public void abW() {
        if (this.bOi != null) {
            this.bHH.removeView(this.bOi);
            this.bOi = null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void abX() {
        if (this.bLa != null) {
            this.bOi = new PbEditor(this.bLa.getPageContext().getPageActivity());
            this.bOi.setOrientation(1);
            this.bOi.setFrom(1);
            this.bOi.aX(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bHH.addView(this.bOi, layoutParams);
            this.bOi.b(this.bLa.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            abY();
            if (this.bOi.cqP != null) {
                this.bOi.cqP.setAudioCanUse(acF());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void abY() {
        if (this.bOi != null) {
            this.bOi.a(this.bLa.getPageContext(), new cy(this));
        }
    }

    public void is(String str) {
        if (this.bOm != null) {
            if (TextUtils.isEmpty(str)) {
                str = GameInfoData.NOT_FROM_DETAIL;
            }
            this.bOm.setText(this.bLa.getPageContext().getResources().getString(com.baidu.tieba.t.pb_reply_count_text, str));
        }
    }

    public void z(String str, boolean z) {
        this.bOp = z;
        ed(TbadkCoreApplication.m411getInst().getSkinType() == 1);
    }

    private void ed(boolean z) {
        if (this.bOn != null) {
            if (this.bOp) {
                com.baidu.tbadk.core.util.ay.i((View) this.bOn, com.baidu.tieba.p.pb_praise_already_click_selector);
            } else {
                com.baidu.tbadk.core.util.ay.i((View) this.bOn, com.baidu.tieba.p.pb_praise_normal_click_selector);
            }
        }
    }

    public TextView abZ() {
        return this.bOn;
    }

    public void ee(boolean z) {
        if (this.aMm != null) {
            if (!z) {
                this.aMm.setEnabled(z);
            } else {
                this.aMm.postDelayed(new cz(this, z), 10L);
            }
        }
    }

    public void O(View view) {
        boolean z;
        View view2;
        if (this.bND != null && view != null) {
            if (this.bOo) {
                z = this.bOk.getVisibility() == 0;
            } else {
                z = this.bOi != null && this.bOi.getVisibility() == 0;
            }
            boolean z2 = this.bND.getVisibility() == 0;
            if (z2) {
                View findViewById = this.bLa.findViewById(com.baidu.tieba.q.bg_above_list);
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.bND.getHeight()));
                com.baidu.tieba.tbadkCore.a.a(this.bLa, this.bND, com.baidu.tieba.k.top_fold_up, new da(this, findViewById));
            } else {
                com.baidu.tieba.tbadkCore.a.a(this.bLa, this.bND, com.baidu.tieba.k.top_fold_down, new cj(this));
            }
            if (this.bOo) {
                view2 = this.bOk;
            } else {
                view2 = this.bOi;
            }
            if (z) {
                if (z2) {
                    if (this.bOi != null) {
                        this.bOi.anU();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.bLa, view2, com.baidu.tieba.k.bottom_fold_down, new ck(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.bLa, view2, com.baidu.tieba.k.bottom_fold_up, new cl(this));
            }
        }
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.bOi == null) {
            return null;
        }
        return this.bOi.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.bOi != null) {
            this.bOi.setAudioData(voiceModel);
        }
    }

    public void Ks() {
        if (this.bOi != null) {
            this.bOi.Ks();
        }
    }

    public void aca() {
        if (this.bOi != null) {
            this.bOi.aca();
        }
    }

    public bh acb() {
        return this.bNE;
    }

    public void a(bd bdVar) {
        this.bKM = bdVar;
    }

    private void a(com.baidu.tbadk.core.data.z zVar) {
        if (zVar != null && zVar.rF() != 0) {
            if (this.bOh == null) {
                this.bLa.getLayoutMode().j(((ViewStub) this.bNk.findViewById(com.baidu.tieba.q.live_talk_layout)).inflate());
                this.bOh = (Button) this.bNk.findViewById(com.baidu.tieba.q.pb_head_function_manage_go_to_live_post);
                this.bNz = this.bNk.findViewById(com.baidu.tieba.q.new_pb_header_item_line_above_livepost);
            }
            int rG = zVar.rG();
            String string = this.bLa.getPageContext().getString(com.baidu.tieba.t.go_to_live_post_prefix);
            if (rG == 0) {
                string = String.valueOf(string) + this.bLa.getPageContext().getString(com.baidu.tieba.t.go_to_interview_post);
            } else if (rG == 1) {
                string = String.valueOf(string) + this.bLa.getPageContext().getString(com.baidu.tieba.t.go_to_discuss_post);
            }
            this.bOh.setText(string);
            this.bOh.setVisibility(0);
            this.bOh.setOnClickListener(this.aNV);
            acp();
        }
    }

    private void acc() {
        this.bOq = (LinearLayout) this.bNk.findViewById(com.baidu.tieba.q.btn_show_passed_pb);
        this.bOs = (TextView) this.bNk.findViewById(com.baidu.tieba.q.show_pre_page_view);
        this.bOr = (TextView) this.bNk.findViewById(com.baidu.tieba.q.go_back_top_view);
        this.avI = this.bNk.findViewById(com.baidu.tieba.q.show_passed_divider);
        this.bOs.setOnClickListener(this.bOB);
        this.bOr.setOnClickListener(this.aNV);
        acp();
    }

    public void P(View view) {
        if (this.bNM == null) {
            this.bNM = new Dialog(this.bLa.getPageContext().getPageActivity(), com.baidu.tieba.u.common_alert_dialog);
            this.bNM.setCanceledOnTouchOutside(true);
            this.bNM.setCancelable(true);
            this.bNM.setContentView(com.baidu.adp.lib.g.b.hr().inflate(this.bLa.getPageContext().getPageActivity(), com.baidu.tieba.r.forum_manage_dialog, null));
            WindowManager.LayoutParams attributes = this.bNM.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.n.M(this.bLa.getPageContext().getPageActivity()) * 0.9d);
            this.bNM.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.bNM.findViewById(com.baidu.tieba.q.del_post_btn);
        Button button2 = (Button) this.bNM.findViewById(com.baidu.tieba.q.forbid_user_btn);
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
            com.baidu.adp.lib.g.k.a(this.bNM, this.bLa.getPageContext());
        }
    }

    public void a(bc bcVar) {
        this.bOC = bcVar;
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
        this.bNN = new com.baidu.tbadk.core.dialog.a(this.bLa.getActivity());
        this.bNN.bu(i3);
        this.bNN.v(sparseArray);
        this.bNN.a(com.baidu.tieba.t.dialog_ok, this.bLa);
        this.bNN.b(com.baidu.tieba.t.dialog_cancel, new co(this));
        this.bNN.ag(true);
        this.bNN.b(this.bLa.getPageContext());
        this.bNN.rL();
    }

    public void K(ArrayList<com.baidu.tbadk.core.data.l> arrayList) {
        if (this.bNX == null) {
            this.bNX = new Dialog(this.bLa.getPageContext().getPageActivity(), com.baidu.tieba.u.common_alert_dialog);
            this.bNX.setCanceledOnTouchOutside(true);
            this.bNX.setCancelable(true);
            this.bNY = com.baidu.adp.lib.g.b.hr().inflate(this.bLa.getPageContext().getPageActivity(), com.baidu.tieba.r.commit_good, null);
            this.bOg = (ScrollView) this.bNY.findViewById(com.baidu.tieba.q.good_scroll);
            this.bNX.setContentView(this.bNY);
            WindowManager.LayoutParams attributes = this.bNX.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.n.M(this.bLa.getPageContext().getPageActivity()) * 0.9d);
            this.bNX.getWindow().setAttributes(attributes);
            this.bOa = new cp(this);
            this.bNZ = (RadioGroup) this.bNY.findViewById(com.baidu.tieba.q.good_class_group);
            this.bOc = (Button) this.bNY.findViewById(com.baidu.tieba.q.dialog_button_cancel);
            this.bOc.setOnClickListener(new cq(this));
            this.bOb = (Button) this.bNY.findViewById(com.baidu.tieba.q.dialog_button_ok);
            this.bOb.setOnClickListener(this.aNV);
        }
        this.bNZ.removeAllViews();
        RadioButton radioButton = (RadioButton) com.baidu.adp.lib.g.b.hr().inflate(this.bLa.getPageContext().getPageActivity(), com.baidu.tieba.r.good_class_radio_button, null);
        radioButton.setTag(GameInfoData.NOT_FROM_DETAIL);
        radioButton.setText(this.bLa.getPageContext().getString(com.baidu.tieba.t.def_good_class));
        radioButton.setOnCheckedChangeListener(this.bOa);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        layoutParams.setMargins(com.baidu.adp.lib.util.n.dip2px(this.bLa.getPageContext().getPageActivity(), 10.0f), com.baidu.adp.lib.util.n.dip2px(this.bLa.getPageContext().getPageActivity(), 5.0f), com.baidu.adp.lib.util.n.dip2px(this.bLa.getPageContext().getPageActivity(), 10.0f), com.baidu.adp.lib.util.n.dip2px(this.bLa.getPageContext().getPageActivity(), 5.0f));
        this.bNZ.addView(radioButton, layoutParams);
        this.bNZ.requestLayout();
        this.bNZ.check(radioButton.getId());
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                RadioButton radioButton2 = (RadioButton) com.baidu.adp.lib.g.b.hr().inflate(this.bLa.getPageContext().getPageActivity(), com.baidu.tieba.r.good_class_radio_button, null);
                radioButton2.setTag(String.valueOf(arrayList.get(i2).qI()));
                radioButton2.setText(arrayList.get(i2).qH());
                radioButton2.setOnCheckedChangeListener(this.bOa);
                this.bNZ.addView(radioButton2, layoutParams);
                this.bNZ.requestLayout();
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bOg.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.n.dip2px(this.bLa.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.n.dip2px(this.bLa.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.n.dip2px(this.bLa.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.bOg.setLayoutParams(layoutParams2);
            this.bOg.removeAllViews();
            this.bOg.addView(this.bNZ);
        }
        com.baidu.adp.lib.g.k.a(this.bNX, this.bLa.getPageContext());
    }

    public void acd() {
        this.bLa.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.bLa.hideProgressBar();
        if (z && z2) {
            this.bLa.showToast(this.bLa.getPageContext().getString(com.baidu.tieba.t.success));
        } else if (str != null && z2) {
            this.bLa.showToast(str);
        }
    }

    public void Te() {
        this.bNL.setVisibility(0);
    }

    public void Td() {
        this.bNL.setVisibility(8);
    }

    public View ace() {
        if (this.bNY != null) {
            return this.bNY.findViewById(com.baidu.tieba.q.dialog_button_ok);
        }
        return null;
    }

    public String acf() {
        return this.bOd;
    }

    public View getView() {
        return this.bHH;
    }

    public void acg() {
        View editText;
        if (this.bOi == null) {
            editText = this.bLa.getCurrentFocus();
        } else {
            editText = this.bOi.getEditText();
        }
        com.baidu.adp.lib.util.n.c(this.bLa.getPageContext().getPageActivity(), editText);
    }

    public void Kp() {
        this.bLa.showProgressBar();
    }

    public void bT(boolean z) {
        this.bLa.hideProgressBar();
        acx();
        if (z && this.bOi != null) {
            this.bOi.getEditText().setText("");
            this.bOi.anQ();
            this.bOi.clearData();
        }
    }

    public void ach() {
        this.bNJ.startLoadData();
    }

    public void aci() {
    }

    public void acj() {
        this.bLa.hideProgressBar();
        this.bNJ.ux();
        acE();
        this.aMm.completePullRefresh();
        acp();
    }

    public void ack() {
        this.aMm.completePullRefresh();
        this.bOq.setVisibility(8);
        acp();
    }

    public void ef(boolean z) {
        if (!z && this.bOi != null) {
            this.bOi.anS();
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            this.bOj = vVar;
            if (this.bOi != null) {
                abY();
            }
        }
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.bOD = onLongClickListener;
        this.bNE.setOnLongClickListener(onLongClickListener);
    }

    public void u(ArrayList<String> arrayList) {
        if (this.bOi != null) {
            this.bOi.u(arrayList);
        }
    }

    public void acl() {
        this.bOE = true;
        if (this.bOi != null) {
            this.bOi.acl();
        }
    }

    public void acm() {
        this.bOE = false;
        if (this.bOi != null) {
            this.bOi.acm();
        }
    }

    public void a(com.baidu.tbadk.core.dialog.h hVar, boolean z, boolean z2) {
        if (this.bOe != null) {
            this.bOe.dismiss();
            this.bOe = null;
        }
        this.bOe = new com.baidu.tbadk.core.dialog.e(this.bLa.getPageContext().getPageActivity());
        this.bOe.bx(com.baidu.tieba.t.operation);
        if (z2) {
            this.bOe.a(new String[]{this.bLa.getPageContext().getString(com.baidu.tieba.t.copy)}, hVar);
        } else if (!z) {
            this.bOe.a(new String[]{this.bLa.getPageContext().getString(com.baidu.tieba.t.copy), this.bLa.getPageContext().getString(com.baidu.tieba.t.mark)}, hVar);
        } else {
            this.bOe.a(new String[]{this.bLa.getPageContext().getString(com.baidu.tieba.t.copy), this.bLa.getPageContext().getString(com.baidu.tieba.t.remove_mark)}, hVar);
        }
        this.bOe.d(this.bLa.getPageContext());
        this.bOe.rN();
    }

    public void k(Bitmap bitmap) {
        if (this.bOi != null) {
            this.bOi.k(bitmap);
            this.bOi.anP();
        }
    }

    public void acn() {
        if (this.bOi != null) {
            this.bOi.k(null);
        }
    }

    public int aco() {
        int firstVisiblePosition = this.aMm.getFirstVisiblePosition();
        com.baidu.adp.widget.ListView.g gVar = (com.baidu.adp.widget.ListView.g) this.aMm.getAdapter();
        if (gVar != null) {
            if (gVar.getItem(firstVisiblePosition) instanceof com.baidu.tieba.pb.a.a) {
                firstVisiblePosition++;
            }
            int headersCount = (this.aMm.getAdapter() == null || !(this.aMm.getAdapter() instanceof com.baidu.adp.widget.ListView.g)) ? 0 : ((com.baidu.adp.widget.ListView.g) this.aMm.getAdapter()).getHeadersCount();
            return firstVisiblePosition > headersCount ? firstVisiblePosition - headersCount : 0;
        }
        return firstVisiblePosition;
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.bNH.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public String Kq() {
        return this.bOi == null ? "" : this.bOi.getContent();
    }

    public void gj(String str) {
        if (this.bOi != null) {
            this.bOi.setContent(str);
        }
    }

    public void e(com.baidu.tieba.pb.a.b bVar) {
        this.bNE.b(bVar);
        this.bNE.notifyDataSetChanged();
        if (bVar == null) {
            is("");
        } else {
            is(com.baidu.tbadk.core.util.bb.q(bVar.aat().getReply_num()));
        }
        acp();
    }

    public void f(com.baidu.tieba.pb.a.b bVar) {
        PraiseData praise;
        if (this.bNx == null) {
            this.bLa.getLayoutMode().j(((ViewStub) this.bNk.findViewById(com.baidu.tieba.q.praise_layout)).inflate());
            this.bNx = (FrsPraiseView) this.bNk.findViewById(com.baidu.tieba.q.pb_head_praise_view);
            this.bNx.setIsFromPb(true);
            this.bNB = this.bNk.findViewById(com.baidu.tieba.q.new_pb_header_item_line_above_praise);
            this.bNx.cz(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.bNx != null) {
            boolean acp = acp();
            if (bVar != null && bVar.aau() != null && bVar.aau().size() > 0) {
                com.baidu.tieba.tbadkCore.data.j jVar = bVar.aau().get(0);
                if ((!this.bLj || jVar.aoC() != 1) && (praise = bVar.aat().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.bNx.setVisibility(0);
                    this.bNx.setIsFromPb(true);
                    this.bNx.a(praise, bVar.aat().getId(), praise.getPostId(), true);
                    this.bNB.setVisibility(0);
                    if (this.bNx.getVisibility() == 0) {
                        this.bNC.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.bNx.setVisibility(8);
            this.bNB.setVisibility(8);
            if (bVar != null && bVar.Zq() != null && bVar.Zq().qS() == 0 && this.bLj) {
                this.bNB.setVisibility(8);
                if (acp) {
                    this.bNA.setVisibility(0);
                    return;
                } else {
                    this.bNA.setVisibility(8);
                    return;
                }
            }
            this.bNB.setVisibility(0);
            this.bNA.setVisibility(8);
        }
    }

    private com.baidu.tieba.tbadkCore.data.j a(com.baidu.tieba.pb.a.b bVar, boolean z, int i) {
        if (z) {
            if (bVar == null || bVar.aau() == null || bVar.aau().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.j jVar = bVar.aau().get(0);
            if (jVar.aoC() != 1) {
                return g(bVar);
            }
            return jVar;
        }
        return g(bVar);
    }

    private com.baidu.tieba.tbadkCore.data.j g(com.baidu.tieba.pb.a.b bVar) {
        MetaData metaData;
        if (bVar == null || bVar.aat() == null || bVar.aat().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.j jVar = new com.baidu.tieba.tbadkCore.data.j();
        MetaData author = bVar.aat().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = bVar.aat().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        jVar.iQ(1);
        jVar.setId(bVar.aat().rs());
        jVar.setTitle(bVar.aat().getTitle());
        jVar.setTime(bVar.aat().getCreateTime());
        jVar.a(metaData);
        return jVar;
    }

    private void b(com.baidu.tieba.pb.a.b bVar, boolean z, int i) {
        this.bNm.setVisibility(8);
        com.baidu.tieba.tbadkCore.data.j a = a(bVar, z, i);
        if (a != null) {
            if (z) {
                this.bNw.setVisibility(8);
            } else {
                this.bNw.setVisibility(0);
            }
            this.bNm.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.bNm.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.bNm.setTag(sparseArray);
            }
            sparseArray.put(com.baidu.tieba.q.tag_clip_board, a);
            sparseArray.put(com.baidu.tieba.q.tag_is_subpb, false);
            this.bNv.setText(com.baidu.tbadk.core.util.bb.o(a.getTime()));
            bVar.aat().ry();
            this.bNn.setVisibility(0);
            this.bNn.setText(bVar.aat().getSpan_str());
            f(bVar);
            ArrayList<com.baidu.tbadk.core.data.b> rp = bVar.aat().rp();
            if (rp != null && rp.size() > 0) {
                this.bOy.setText(String.valueOf(rp.get(0).qt()));
                this.bOx.setVisibility(0);
            } else {
                this.bOx.setVisibility(8);
            }
            com.baidu.tbadk.core.util.ay.i(this.bOx, com.baidu.tieba.p.activity_join_num_bg);
            com.baidu.tbadk.core.util.ay.b(this.bOy, com.baidu.tieba.n.cp_link_tip_d, 1);
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
            if (bVar != null && bVar.aat() != null && bVar.aat().getAnchorInfoData() != null) {
                if (bVar.aat().getAnchorInfoData().getGroup_id() != 0 && appResponseToIntentClass) {
                    if (this.bOv == null) {
                        BdLog.e("pb time   liveCardLayout new");
                        this.bOv = ((ViewStub) this.bNk.findViewById(com.baidu.tieba.q.live_card_layout)).inflate();
                        this.bLa.getLayoutMode().j(this.bOv);
                        this.bOw = (LiveBroadcastCard) this.bNk.findViewById(com.baidu.tieba.q.item_card);
                    }
                    this.bOv.setVisibility(0);
                    LiveCardData liveCardData = new LiveCardData();
                    liveCardData.setPublisherId(bVar.aat().getAnchorInfoData().getAuthorId());
                    liveCardData.setPublisherName(bVar.aat().getAnchorInfoData().getAuthorName());
                    liveCardData.setPublisherPortrait(bVar.aat().getAnchorInfoData().getPublisherPortrait());
                    liveCardData.setGroupId(bVar.aat().getAnchorInfoData().getGroup_id());
                    liveCardData.setIntro(bVar.aat().getAnchorInfoData().getIntro());
                    liveCardData.setLikers(bVar.aat().getAnchorInfoData().getLikers());
                    liveCardData.setListeners(bVar.aat().getAnchorInfoData().getListeners());
                    liveCardData.setName(bVar.aat().getAnchorInfoData().getName());
                    liveCardData.setPortrait(bVar.aat().getAnchorInfoData().getPortrait());
                    liveCardData.setStatus(bVar.aat().getAnchorInfoData().getStatus());
                    liveCardData.setStartTime(bVar.aat().getAnchorInfoData().getStartTime());
                    liveCardData.setIsVip(bVar.aat().getAnchorInfoData().getIsVip());
                    this.bOw.setData(liveCardData);
                    this.bOw.setStatisticsKey("notice_pb_live");
                } else if (this.bOv != null) {
                    this.bOv.setVisibility(8);
                }
            }
            if (bVar != null && bVar.aat() != null && bVar.aat().getAuthor() != null) {
                String userId = bVar.aat().getAuthor().getUserId();
                if (userId != null && !userId.equals(GameInfoData.NOT_FROM_DETAIL) && userId.equals(a.getAuthor().getUserId())) {
                    this.bNu.setVisibility(0);
                } else {
                    this.bNu.setVisibility(8);
                }
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.bNq.setVisibility(0);
                    com.baidu.tbadk.core.util.ay.c(this.bNq, com.baidu.tbadk.core.util.c.bT(level_id));
                    i2 = 2;
                    this.bNq.setOnClickListener(null);
                } else {
                    this.bNq.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.ay.c(this.bNq, com.baidu.tieba.p.pb_manager);
                        this.bNq.setOnClickListener(this.bLa.bKB.bOL);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.ay.c(this.bNq, com.baidu.tieba.p.pb_assist);
                        this.bNq.setOnClickListener(this.bLa.bKB.bOL);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.ay.c(this.bNr, com.baidu.tieba.p.icon_pop_girl_square);
                    this.bNr.setVisibility(0);
                } else {
                    this.bNr.setVisibility(8);
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfo = a.getAuthor().getTShowInfo();
                if (this.bNs != null) {
                    this.bNs.setOnClickListener(this.bLa.bKB.bOL);
                    this.bNs.a(iconInfo, i2, this.bLa.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_width), this.bLa.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_height), this.bLa.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_margin));
                }
                if (this.bNt != null) {
                    this.bNt.setOnClickListener(this.bLa.bKB.bOM);
                    this.bNt.a(tShowInfo, 3, this.bLa.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_width), this.bLa.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_height), this.bLa.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_margin), true);
                }
                this.bNo.setText(a.getAuthor().getName_show());
                this.bNo.setTag(com.baidu.tieba.q.tag_user_id, a.getAuthor().getUserId());
                this.bNo.setTag(com.baidu.tieba.q.tag_user_name, a.getAuthor().getName_show());
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.ay.b(this.bNo, com.baidu.tieba.n.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.ay.b(this.bNo, com.baidu.tieba.n.cp_cont_f, 1);
                }
                if (!this.bLi) {
                    this.bNp.setVisibility(8);
                }
                this.bNp.setUserId(a.getAuthor().getUserId());
                this.bNp.setUserName(a.getAuthor().getUserName());
                this.bNp.setImageDrawable(null);
                this.bNp.setTag(a.getAuthor().getUserId());
                this.bNo.setOnClickListener(this.bLa.bKB.bOK);
                this.bNp.setOnClickListener(this.bLa.bKB.bOK);
                this.bNp.c(a.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.b bVar, int i, int i2, boolean z, int i3) {
        Parcelable abM;
        Parcelable abM2;
        String sb;
        if (bVar != null) {
            this.bOu = false;
            this.bLj = z;
            acj();
            b(bVar, z, i);
            this.bNE.dU(this.bLj);
            this.bNE.b(bVar);
            this.bNE.notifyDataSetChanged();
            if (bVar.aas() != null) {
                this.mForumName = bVar.aas().getName();
            }
            this.bNj.it(this.mForumName);
            if (bVar.aat() != null) {
                is(com.baidu.tbadk.core.util.bb.q(bVar.aat().getReply_num()));
                if (bVar.aat().getPraise() != null) {
                    if (bVar.aat().getPraise().getNum() < 1) {
                        sb = this.bLa.getResources().getString(com.baidu.tieba.t.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(bVar.aat().getPraise().getNum())).toString();
                    }
                    z(sb, bVar.aat().getPraise().getIsLike() == 1);
                }
            }
            if (bVar.Zq().qR() == 0 && !z) {
                this.aMm.setNextPage(null);
            } else if (this.bLa.isLogin()) {
                this.aMm.setNextPage(this.bNJ);
                acE();
            } else if (bVar.Zq().qR() == 1) {
                this.bOu = true;
                if (this.bNK == null) {
                    this.bNK = new com.baidu.tieba.pb.view.b(this.bLa.getPageContext());
                }
                this.aMm.setNextPage(this.bNK);
            }
            if (bVar.Zq().qS() == 0 && z) {
                this.aMm.setPullRefresh(null);
                this.bOq.setVisibility(8);
            } else {
                if (this.bNI == null) {
                    this.bNI = new com.baidu.tieba.pb.view.d(this.bLa.getPageContext());
                    this.bNI.ng();
                    this.bNI.a(this.aaa);
                }
                this.aMm.setPullRefresh(this.bNI);
                if (this.bNI != null) {
                    this.bNI.cy(TbadkCoreApplication.m411getInst().getSkinType());
                }
                this.bOq.setVisibility(0);
                acE();
            }
            acp();
            if (bVar.Zq().qR() == 0) {
                this.bNJ.setText(this.bLa.getResources().getString(com.baidu.tieba.t.list_no_more));
                h(bVar);
            } else {
                this.bNJ.setText(this.bLa.getResources().getString(com.baidu.tieba.t.pb_load_more));
            }
            if (z) {
                this.bOr.setVisibility(0);
                this.avI.setVisibility(0);
                this.bOs.setText(this.bLa.getResources().getString(com.baidu.tieba.t.btn_show_passed_pb));
            } else {
                this.bOr.setVisibility(8);
                this.avI.setVisibility(8);
                this.bOs.setText(this.bLa.getResources().getString(com.baidu.tieba.t.btn_show_passed_pb_aftre));
            }
            if (bVar.aat() != null && bVar.aat().getAuthor() != null && bVar.aat().getAuthor().getType() == 0) {
                this.bNj.acH();
            }
            switch (i) {
                case 2:
                    this.aMm.setSelection(i2);
                    if (this.bNl != null) {
                        CompatibleUtile.scrollListViewBy(this.aMm, -this.bNl.getHeight(), 0);
                        return;
                    }
                    return;
                case 3:
                    if (i3 == 1 && (abM2 = cb.abL().abM()) != null) {
                        this.aMm.onRestoreInstanceState(abM2);
                        return;
                    } else {
                        this.aMm.setSelection(0);
                        return;
                    }
                case 4:
                    if (z) {
                        this.aMm.setSelection(0);
                        return;
                    } else if (bVar.aau() != null) {
                        if (bVar.Zq() != null && bVar.Zq().qS() != 0) {
                            this.aMm.setSelection(bVar.aau().size() + 1);
                            return;
                        } else {
                            this.aMm.setSelection(bVar.aau().size());
                            return;
                        }
                    } else {
                        return;
                    }
                case 5:
                    this.aMm.setSelection(0);
                    return;
                case 6:
                    if (i3 == 1 && (abM = cb.abL().abM()) != null) {
                        this.aMm.onRestoreInstanceState(abM);
                        return;
                    } else if (z) {
                        this.aMm.setSelection(0);
                        return;
                    } else if (bVar.aau() != null) {
                        if (bVar.Zq() != null && bVar.Zq().qS() != 0) {
                            this.aMm.setSelection(bVar.aau().size() + 1);
                            return;
                        } else {
                            this.aMm.setSelection(bVar.aau().size());
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
        this.bOf = z;
        this.bNj.eg(z);
    }

    public void ux() {
        if (this.bNJ != null) {
            this.bNJ.ux();
        }
        acE();
    }

    public void Ln() {
        this.aMm.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean acp() {
        boolean z;
        boolean z2 = true;
        if (this.bNl != null && this.bNl.getVisibility() == 0) {
            if (this.bNy != null) {
                this.bNy.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.bNy != null) {
                this.bNy.setVisibility(8);
            }
            z = false;
        }
        if (this.bOh != null && this.bOh.getVisibility() == 0) {
            if (this.bNz != null) {
                this.bNz.setVisibility(0);
            }
        } else {
            if (this.bNz != null) {
                this.bNz.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.bNB == null || this.bNB.getVisibility() == 8) && z2 && this.bLj) {
            this.bNA.setVisibility(0);
        } else {
            this.bNA.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.pb.a.b bVar, boolean z, boolean z2) {
        if (bVar == null) {
            return false;
        }
        if (this.bNn != null) {
            if (bVar.aat().rr() == 0) {
                this.bNn.setVisibility(0);
                bVar.aat().ry();
                this.bNn.setText(bVar.aat().getSpan_str());
            } else {
                this.bNn.setVisibility(8);
            }
        }
        if (z) {
            if (this.bOv != null) {
                this.bOv.findViewById(com.baidu.tieba.q.pb_head_live_blank).setVisibility(8);
            }
        } else if (this.bOv != null) {
            this.bOv.findViewById(com.baidu.tieba.q.pb_head_live_blank).setVisibility(0);
        }
        this.bLj = z;
        com.baidu.tbadk.core.data.w aat = bVar.aat();
        if (aat != null) {
            a(aat.rj());
        }
        if (bVar.aaw() == 1) {
            acq();
            Button button = (Button) this.bNk.findViewById(com.baidu.tieba.q.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.bNk.findViewById(com.baidu.tieba.q.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.bNk.findViewById(com.baidu.tieba.q.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.bNk.findViewById(com.baidu.tieba.q.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.aNV);
            button2.setOnClickListener(this.aNV);
            button3.setOnClickListener(this.aNV);
            button4.setOnClickListener(this.aNV);
            if (bVar.aat().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (bVar.aat().getIs_top() == 1) {
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

    private void acq() {
        if (this.bNl == null) {
            this.bNl = ((ViewStub) this.bNk.findViewById(com.baidu.tieba.q.pb_header_function_manage)).inflate();
            this.bLa.getLayoutMode().j(this.bNl);
            this.bNy = this.bNk.findViewById(com.baidu.tieba.q.new_pb_header_item_line_above_manage);
            return;
        }
        this.bNl.setVisibility(0);
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
                if (bVar.aaw() != 0 && a.getAuthor() != null) {
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
                    String userId3 = bVar.aat().getAuthor().getUserId();
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
                    sparseArray.put(com.baidu.tieba.q.tag_manage_user_identity, Integer.valueOf(bVar.aaw()));
                    sparseArray.put(com.baidu.tieba.q.tag_should_manage_visible, true);
                    a(com.baidu.tieba.t.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(com.baidu.tieba.q.tag_del_post_id, a.getId());
                    sparseArray2.put(com.baidu.tieba.q.tag_del_post_type, 0);
                    sparseArray2.put(com.baidu.tieba.q.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(com.baidu.tieba.q.tag_manage_user_identity, Integer.valueOf(bVar.aaw()));
                    sparseArray2.put(com.baidu.tieba.q.tag_should_manage_visible, false);
                    a(com.baidu.tieba.t.delete, sparseArray2);
                }
            }
            acp();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        acq();
        Button button = (Button) this.bNk.findViewById(com.baidu.tieba.q.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.aNV);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.apg;
    }

    public BdListView getListView() {
        return this.aMm;
    }

    public int acr() {
        return com.baidu.tieba.q.richText;
    }

    public int Lu() {
        return com.baidu.tieba.q.user_icon_box;
    }

    public Button acs() {
        return (Button) this.bNk.findViewById(com.baidu.tieba.q.pb_head_function_manage_commit_good);
    }

    public Button act() {
        return (Button) this.bNk.findViewById(com.baidu.tieba.q.pb_head_function_manage_cancel_good);
    }

    public Button acu() {
        return (Button) this.bNk.findViewById(com.baidu.tieba.q.pb_head_function_manage_commit_top);
    }

    public Button acv() {
        return (Button) this.bNk.findViewById(com.baidu.tieba.q.pb_head_function_manage_cancel_top);
    }

    public void c(com.baidu.adp.widget.ListView.x xVar) {
        this.aMm.setOnSrollToBottomListener(xVar);
    }

    public void a(com.baidu.adp.widget.ListView.aa aaVar) {
        this.aMm.setOnSrollToTopListener(aaVar);
    }

    public void b(com.baidu.tbadk.core.dialog.h hVar) {
        this.bjY = hVar;
    }

    public void a(com.baidu.tbadk.core.view.aj ajVar) {
        this.aaa = ajVar;
        if (this.bNI != null) {
            this.bNI.a(ajVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.q qVar, com.baidu.tbadk.core.dialog.d dVar) {
        if (qVar != null) {
            int qP = qVar.qP();
            int qN = qVar.qN();
            if (this.bNF != null) {
                this.bNF.rL();
            } else {
                this.bNF = new com.baidu.tbadk.core.dialog.a(this.bLa.getPageContext().getPageActivity());
                this.bNG = com.baidu.adp.lib.g.b.hr().inflate(this.bLa.getPageContext().getPageActivity(), com.baidu.tieba.r.dialog_direct_pager, null);
                this.bNF.l(this.bNG);
                this.bNF.a(com.baidu.tieba.t.dialog_ok, dVar);
                this.bNF.b(com.baidu.tieba.t.dialog_cancel, new cs(this));
                this.bNF.b(this.bLa.getPageContext()).rL();
            }
            this.bNH = (EditText) this.bNG.findViewById(com.baidu.tieba.q.input_page_number);
            this.bNH.setText("");
            this.bNH.setOnFocusChangeListener(new ct(this));
            TextView textView = (TextView) this.bNG.findViewById(com.baidu.tieba.q.current_page_number);
            if (qP <= 0) {
                qP = 1;
            }
            if (qN <= 0) {
                qN = 1;
            }
            textView.setText(MessageFormat.format(this.bLa.getApplicationContext().getResources().getString(com.baidu.tieba.t.current_page), Integer.valueOf(qP), Integer.valueOf(qN)));
            this.bLa.ShowSoftKeyPadDelay(this.bNH, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aMm.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.bLa.showToast(str);
    }

    public boolean eh(boolean z) {
        if (this.bOi == null || !this.bOi.anx()) {
            return false;
        }
        this.bOi.anV();
        return true;
    }

    public void acw() {
        if (this.bOF != null) {
            while (this.bOF.size() > 0) {
                TbImageView remove = this.bOF.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        acw();
    }

    public void onDestroy() {
        this.bLa.hideProgressBar();
        if (this.aFY != null && this.aLP != null) {
            this.aFY.b(this.aLP);
        }
        acx();
        this.bNJ.ux();
    }

    public void acx() {
        this.bNj.pA();
        com.baidu.adp.lib.util.n.c(this.bLa.getPageContext().getPageActivity(), this.bNH);
        if (this.bOi != null) {
            this.bOi.anT();
        }
        if (this.bOe != null) {
            this.bOe.dismiss();
        }
        acy();
    }

    public void setIsShowImage(boolean z) {
        this.bNE.setIsShowImage(z);
    }

    public void dT(boolean z) {
        this.bLi = z;
        this.bNE.dT(z);
    }

    public void acy() {
        if (this.bNN != null) {
            this.bNN.dismiss();
        }
        if (this.bNO != null) {
            com.baidu.adp.lib.g.k.b(this.bNO, this.bLa.getPageContext());
        }
        if (this.bNX != null) {
            com.baidu.adp.lib.g.k.b(this.bNX, this.bLa.getPageContext());
        }
        if (this.bNM != null) {
            com.baidu.adp.lib.g.k.b(this.bNM, this.bLa.getPageContext());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.bLa.getLayoutMode().ab(i == 1);
        this.bLa.getLayoutMode().j(this.bHH);
        this.bLa.getLayoutMode().j(this.bNk);
        this.bLa.getLayoutMode().j(this.apg);
        this.bNj.mNavigationBar.onChangeSkinType(this.bLa.getPageContext(), i);
        if (this.bNG != null) {
            this.bLa.getLayoutMode().j(this.bNG);
        }
        eg(this.bOf);
        this.bNE.notifyDataSetChanged();
        if (this.bNI != null) {
            this.bNI.cy(i);
        }
        if (this.bNJ != null) {
            this.bNJ.cy(i);
            com.baidu.tbadk.core.util.ay.i(this.apg, com.baidu.tieba.p.pb_foot_more_trans_selector);
            this.bNJ.cw(com.baidu.tieba.p.pb_foot_more_trans_selector);
        }
        if (this.bOi != null) {
            this.bOi.b(this.bLa.getPageContext(), i);
        }
        if (this.bNx != null) {
            this.bNx.cz(i);
        }
        if (this.bNK != null) {
            this.bNK.cy(i);
        }
        ed(i == 1);
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.auJ = sVar;
        this.bNE.setOnImageClickListener(this.auJ);
    }

    public void f(com.baidu.tbadk.core.view.ad adVar) {
        this.aLP = adVar;
        if (this.aFY != null) {
            this.aFY.a(this.aLP);
        }
    }

    public void ei(boolean z) {
        this.bNE.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button acz() {
        return this.bOh;
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        if (this.bOi != null) {
            this.bOi.cqP.a(writeImagesInfo, z);
        }
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        if (this.bOi != null) {
            this.bOi.cqP.setBaobaoUris(writeImagesInfo);
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                this.bOi.anP();
            } else {
                this.bOi.anQ();
            }
        }
    }

    public void h(com.baidu.tieba.pb.a.b bVar) {
        if (bVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aau = bVar.aau();
            if (aau.size() == 1) {
                com.baidu.tieba.tbadkCore.data.j jVar = aau.get(0);
                if (jVar.aoI() < jVar.aoB().size()) {
                    this.aMm.setNextPage(null);
                    return;
                } else {
                    this.aMm.setNextPage(this.bNJ);
                    return;
                }
            }
            this.aMm.setNextPage(this.bNJ);
        }
    }

    public boolean Kn() {
        if (this.bOi == null) {
            return false;
        }
        return this.bOi.Kn();
    }

    public void acA() {
        if (com.baidu.tbadk.performanceLog.ah.DC().DD()) {
            int lastVisiblePosition = this.aMm.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aMm.getChildAt(i);
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

    public void acB() {
        if (this.bOk != null) {
            this.bOk.setVisibility(0);
        }
    }

    public void acC() {
        if (this.bOk != null) {
            this.bOk.setVisibility(8);
        }
    }

    public TextView acD() {
        return this.bOr;
    }

    public void WP() {
        if (this.bOt == null) {
            this.bOt = new com.baidu.tbadk.core.view.b(this.bLa.getPageContext());
        }
        this.bOt.ar(true);
    }

    public void acE() {
        if (this.bOt != null) {
            this.bOt.ar(false);
        }
    }

    public boolean acF() {
        return this.bOz;
    }

    public void setAudioCanUse(boolean z) {
        this.bOz = z;
        if (this.bOi != null && this.bOi.cqP != null) {
            this.bOi.cqP.setAudioCanUse(z);
        }
    }
}
