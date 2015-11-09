package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
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
import com.baidu.adp.framework.listener.CustomMessageListener;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.sendtool.SendView;
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
public class ct {
    private com.baidu.tbadk.editortools.j KB;
    private NoNetworkView aMY;
    private BdTypeListView aVo;
    private View.OnClickListener aWY;
    private p.a aeE;
    private View avd;
    private RelativeLayout ccO;
    private View.OnClickListener chY;
    private com.baidu.tieba.pb.b.c chs;
    PbActivity.b cjG;
    private PbActivity cjZ;
    private View clA;
    private ColumnLayout clC;
    private TextView clD;
    private TextView clE;
    private HeadImageView clF;
    private ImageView clG;
    private ImageView clH;
    private ImageView clI;
    private UserIconBox clJ;
    private UserIconBox clK;
    private ImageView clL;
    private TextView clM;
    private TextView clN;
    private View clR;
    private View clT;
    private RelativeLayout clU;
    private bp clV;
    private View clx;
    public final com.baidu.tieba.pb.pb.main.b.c cly;
    private List<com.baidu.tieba.pb.pb.main.b.a> clz;
    private View cmC;
    private TextView cmD;
    private TextView cmE;
    private TextView cmF;
    private boolean cmH;
    private View cmN;
    private LiveBroadcastCard cmO;
    private View cmP;
    private TextView cmQ;
    private PbActivity.a cmV;
    private PbListView cma;
    private View cmc;
    private View clB = null;
    public FrsPraiseView clO = null;
    private View clP = null;
    private View clQ = null;
    private View clS = null;
    private com.baidu.tbadk.core.dialog.a clW = null;
    private com.baidu.tbadk.core.dialog.c aWO = null;
    private View clX = null;
    private EditText clY = null;
    private com.baidu.tieba.pb.view.f clZ = null;
    private com.baidu.tieba.pb.view.b cmb = null;
    private c.b bBX = null;
    private TbRichTextView.d aBf = null;
    private NoNetworkView.a aSi = null;
    private Dialog cme = null;
    private View cmf = null;
    private com.baidu.tbadk.core.dialog.a cmg = null;
    private Dialog cmh = null;
    private View cmi = null;
    private int cmj = 0;
    private RadioGroup MT = null;
    private RadioButton cmk = null;
    private RadioButton cml = null;
    private RadioButton cmm = null;
    private Button cmn = null;
    private Button cmo = null;
    private TextView cmp = null;
    private Dialog cmq = null;
    private View cmr = null;
    private LinearLayout cms = null;
    private CompoundButton.OnCheckedChangeListener cmt = null;
    private TextView cmu = null;
    private TextView cmv = null;
    private String cmw = null;
    private com.baidu.tbadk.core.dialog.c cmx = null;
    private boolean cmy = false;
    private String mForumName = null;
    private ScrollView cmz = null;
    private boolean cmA = false;
    private Button cmB = null;
    private boolean cmG = true;
    private LinearLayout cmI = null;
    private TextView cmJ = null;
    private TextView cmK = null;
    private View aCS = null;
    private com.baidu.tbadk.core.view.a cmL = null;
    private boolean chq = false;
    private boolean cmM = false;
    private boolean mIsFromCDN = true;
    private boolean cmR = true;
    private a.InterfaceC0075a cmS = new cu(this);
    private CustomMessageListener cmT = new dd(this, CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL);
    private final View.OnClickListener cmU = new dh(this);
    private View.OnLongClickListener onLongClickListener = null;
    private boolean cmW = true;
    private final List<TbImageView> cmX = new ArrayList();
    private boolean chO = true;

    public NoNetworkView agN() {
        return this.aMY;
    }

    public void agO() {
        if (this.KB != null) {
            this.KB.hide();
        }
    }

    public void agP() {
        reset();
        this.cmG = true;
        if (this.KB != null) {
            this.KB.hide();
        }
        if (this.cmC != null) {
            if (this.cmA) {
                eH(false);
            } else {
                eI(false);
            }
        }
    }

    private void reset() {
        if (this.cjZ != null && this.cjZ.afG() != null && this.KB != null) {
            com.baidu.tbadk.editortools.c.b.AW().setStatus(0);
            com.baidu.tbadk.editortools.c.e afG = this.cjZ.afG();
            afG.Bu();
            if (afG.getWriteImagesInfo() != null) {
                afG.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            afG.ed(10);
            afG.eb(SendView.ALL);
            afG.ec(SendView.ALL);
            afG.eY(this.cjZ.getActivity().getString(i.h.pb_reply_hint));
            com.baidu.tbadk.editortools.p dS = this.KB.dS(22);
            com.baidu.tbadk.editortools.p dS2 = this.KB.dS(2);
            com.baidu.tbadk.editortools.p dS3 = this.KB.dS(5);
            if (dS2 != null) {
                dS2.ox();
            }
            if (dS3 != null) {
                dS3.ox();
            }
            if (dS != null) {
                dS.hide();
            }
            this.KB.invalidate();
        }
    }

    public boolean agQ() {
        return this.cmG;
    }

    public void eH(boolean z) {
        if (this.cmC != null && this.cmD != null && this.cmE != null) {
            this.cmD.setText(i.h.draft_to_send);
            this.cmE.setVisibility(8);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.cmC.startAnimation(alphaAnimation);
            }
            this.cmC.setVisibility(0);
        }
    }

    public void eI(boolean z) {
        if (this.cmC != null && this.cmD != null && this.cmE != null) {
            this.cmD.setText(i.h.reply_floor_host);
            this.cmE.setVisibility(0);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.cmC.startAnimation(alphaAnimation);
            }
            this.cmC.setVisibility(0);
        }
    }

    public com.baidu.tieba.tbadkCore.data.o agR() {
        int i;
        View childAt;
        int i2 = 0;
        if (this.aVo == null) {
            return null;
        }
        int firstVisiblePosition = this.aVo.getFirstVisiblePosition();
        int lastVisiblePosition = this.aVo.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.aVo.getChildCount();
            int i3 = 0;
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 - firstVisiblePosition < childCount && (childAt = this.aVo.getChildAt(i4 - firstVisiblePosition)) != null) {
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
        int headerViewsCount = i - this.aVo.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        if (this.clV.iZ(headerViewsCount) != null && this.clV.iZ(headerViewsCount) != com.baidu.tieba.tbadkCore.data.o.daM) {
            i2 = headerViewsCount + 1;
        }
        return (com.baidu.tieba.tbadkCore.data.o) this.clV.aA(i2);
    }

    public ct(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.b.c cVar) {
        this.cjZ = null;
        this.ccO = null;
        this.clx = null;
        this.aVo = null;
        this.clA = null;
        this.clC = null;
        this.clD = null;
        this.clE = null;
        this.clF = null;
        this.clG = null;
        this.clH = null;
        this.clI = null;
        this.clJ = null;
        this.clK = null;
        this.clL = null;
        this.clM = null;
        this.clN = null;
        this.clR = null;
        this.clT = null;
        this.clV = null;
        this.cma = null;
        this.avd = null;
        this.aWY = null;
        this.chY = null;
        this.cmC = null;
        this.cmD = null;
        this.cmF = null;
        this.cmP = null;
        this.cmQ = null;
        this.cjZ = pbActivity;
        this.aWY = onClickListener;
        this.chs = cVar;
        this.ccO = (RelativeLayout) LayoutInflater.from(this.cjZ.getPageContext().getPageActivity()).inflate(i.g.new_pb_activity, (ViewGroup) null);
        this.cjZ.addContentView(this.ccO, new FrameLayout.LayoutParams(-1, -1));
        this.clx = this.cjZ.findViewById(i.f.statebar_view);
        this.clU = (RelativeLayout) this.cjZ.findViewById(i.f.title_wrapper);
        this.aMY = (NoNetworkView) this.cjZ.findViewById(i.f.view_no_network);
        this.aVo = (BdTypeListView) this.cjZ.findViewById(i.f.new_pb_list);
        View view = new View(this.cjZ.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.cjZ.getResources().getDimensionPixelSize(i.d.pb_editor_height)));
        this.aVo.addFooterView(view);
        this.cly = new com.baidu.tieba.pb.pb.main.b.c(pbActivity);
        this.cly.ahw().setOnTouchListener(new com.baidu.tieba.pb.b.a(new di(this)));
        this.cmC = this.cjZ.findViewById(i.f.pb_editor_tool_comment);
        this.cmD = (TextView) this.cjZ.findViewById(i.f.pb_editor_tool_comment_reply_text);
        this.cmF = (TextView) this.cjZ.findViewById(i.f.pb_editor_tool_comment_praise_icon);
        this.cmE = (TextView) this.cjZ.findViewById(i.f.pb_editor_tool_comment_reply_count_text);
        this.cmD.setOnClickListener(new dj(this));
        this.cmF.setOnClickListener(this.aWY);
        this.cmF.setOnTouchListener(this.cjZ);
        this.clA = LayoutInflater.from(this.cjZ.getPageContext().getPageActivity()).inflate(i.g.new_pb_header_item, (ViewGroup) null);
        this.clC = (ColumnLayout) this.clA.findViewById(i.f.pb_head_owner_root);
        this.clC.setOnLongClickListener(this.onLongClickListener);
        this.clC.setOnTouchListener(this.chs);
        this.clC.setVisibility(8);
        this.clA.setOnTouchListener(this.chs);
        this.clD = (TextView) this.clA.findViewById(i.f.pb_head_post_title);
        this.clD.setTextSize(TbConfig.getContentSizeOfPostTitle());
        this.clD.setVisibility(8);
        this.cmP = this.clA.findViewById(i.f.pb_head_activity_join_number_container);
        this.cmP.setVisibility(8);
        this.cmQ = (TextView) this.clA.findViewById(i.f.pb_head_activity_join_number);
        this.clE = (TextView) this.clC.findViewById(i.f.pb_head_owner_info_user_name);
        this.clF = (HeadImageView) this.clC.findViewById(i.f.pb_head_owner_photo);
        if (!this.chO) {
            this.clF.setVisibility(8);
        }
        this.clG = (ImageView) this.clC.findViewById(i.f.pb_head_owner_info_user_rank);
        this.clH = (ImageView) this.clC.findViewById(i.f.pb_head_owner_info_user_gender);
        this.clI = (ImageView) this.clC.findViewById(i.f.pb_head_owner_info_user_bawu);
        this.clJ = (UserIconBox) this.clC.findViewById(i.f.pb_head_owner_info_user_icon);
        this.clK = (UserIconBox) this.clC.findViewById(i.f.pb_head_owner_info_tshow_icon);
        this.clL = (ImageView) this.clC.findViewById(i.f.pb_head_owner_info_floor_owner);
        this.clM = (TextView) this.clC.findViewById(i.f.pb_head_owner_info_time);
        this.clN = (TextView) this.clA.findViewById(i.f.pb_head_reverse_hint);
        this.clN.setOnClickListener(this.aWY);
        this.clN.setVisibility(8);
        this.clR = this.clA.findViewById(i.f.new_pb_header_item_line_below_livepost);
        this.clT = this.clA.findViewById(i.f.new_pb_header_item_line_above_showpassed);
        this.clA.setOnLongClickListener(new dk(this));
        agV();
        this.clV = new bp(this.cjZ, this.aVo);
        this.clV.C(this.aWY);
        this.clV.a(this.chs);
        this.clV.setOnImageClickListener(this.aBf);
        this.chY = new dl(this);
        this.clV.B(this.chY);
        this.aVo.addHeaderView(this.clA);
        this.cma = new PbListView(this.cjZ.getPageContext().getPageActivity());
        this.avd = this.cma.getView().findViewById(i.f.pb_more_view);
        if (this.avd != null) {
            this.avd.setOnClickListener(this.aWY);
            com.baidu.tbadk.core.util.an.i(this.avd, i.e.pb_foot_more_trans_selector);
        }
        this.cma.vy();
        this.cma.cL(i.e.pb_foot_more_trans_selector);
        this.cma.cM(i.e.pb_foot_more_trans_selector);
        this.cmc = this.cjZ.findViewById(i.f.viewstub_progress);
        this.cjZ.registerListener(this.cmT);
    }

    public void eJ(boolean z) {
        this.cly.eJ(z);
        if (z && this.cmM) {
            this.cma.setText(this.cjZ.getResources().getString(i.h.click_load_more));
            this.aVo.setNextPage(this.cma);
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.KB = jVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.ccO.addView(this.KB, layoutParams);
        this.KB.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.KB.hide();
    }

    public void agS() {
        if (this.cjZ != null && this.KB != null) {
            this.KB.ox();
        }
    }

    public void jS(String str) {
        if (this.cmE != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.cmE.setText(this.cjZ.getPageContext().getResources().getString(i.h.pb_reply_count_text, str));
        }
    }

    public void C(String str, boolean z) {
        this.cmH = z;
        eK(TbadkCoreApplication.m411getInst().getSkinType() == 1);
    }

    private void eK(boolean z) {
        if (this.cmF != null) {
            if (this.cmH) {
                com.baidu.tbadk.core.util.an.i((View) this.cmF, i.e.pb_praise_already_click_selector);
            } else {
                com.baidu.tbadk.core.util.an.i((View) this.cmF, i.e.pb_praise_normal_click_selector);
            }
        }
    }

    public TextView agT() {
        return this.cmF;
    }

    public void eL(boolean z) {
        if (this.aVo != null) {
            if (!z) {
                this.aVo.setEnabled(z);
            } else {
                this.aVo.postDelayed(new dm(this, z), 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(boolean z) {
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.clx.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.clx.setLayoutParams(layoutParams);
            this.clx.setVisibility(0);
            return;
        }
        this.clx.setVisibility(8);
    }

    public void aa(View view) {
        boolean z;
        View view2;
        if (this.clU != null && view != null) {
            if (this.cmG) {
                z = this.cmC.getVisibility() == 0;
            } else {
                z = this.KB != null && this.KB.getVisibility() == 0;
            }
            boolean z2 = this.clU.getVisibility() == 0;
            if (z2) {
                TiebaStatic.log("c10084");
                View findViewById = this.cjZ.findViewById(i.f.bg_above_list);
                findViewById.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.clU.getHeight()));
                com.baidu.tieba.tbadkCore.a.a(this.cjZ, this.clU, i.a.top_fold_up, new dn(this, findViewById));
            } else {
                com.baidu.tieba.tbadkCore.a.a(this.cjZ, this.clU, i.a.top_fold_down, new cv(this));
            }
            if (this.cmG) {
                view2 = this.cmC;
            } else {
                view2 = this.KB;
            }
            if (z) {
                if (z2) {
                    if (this.KB != null) {
                        this.KB.zc();
                    }
                    com.baidu.tieba.tbadkCore.a.a(this.cjZ, view2, i.a.bottom_fold_down, new cw(this));
                }
            } else if (!z2) {
                com.baidu.tieba.tbadkCore.a.a(this.cjZ, view2, i.a.bottom_fold_up, new cx(this));
            }
        }
    }

    public bp agU() {
        return this.clV;
    }

    public void a(PbActivity.b bVar) {
        this.cjG = bVar;
    }

    private void a(com.baidu.tbadk.core.data.z zVar) {
        if (zVar == null || zVar.sL() == 0) {
            if (this.cmB != null) {
                this.cmB.setVisibility(8);
            }
            if (this.clQ != null) {
                this.clQ.setVisibility(8);
                return;
            }
            return;
        }
        if (this.cmB == null) {
            this.cjZ.getLayoutMode().k(((ViewStub) this.clA.findViewById(i.f.live_talk_layout)).inflate());
            this.cmB = (Button) this.clA.findViewById(i.f.pb_head_function_manage_go_to_live_post);
            this.clQ = this.clA.findViewById(i.f.new_pb_header_item_line_above_livepost);
        }
        int sM = zVar.sM();
        String string = this.cjZ.getPageContext().getString(i.h.go_to_live_post_prefix);
        if (sM == 0) {
            string = String.valueOf(string) + this.cjZ.getPageContext().getString(i.h.go_to_interview_post);
        } else if (sM == 1) {
            string = String.valueOf(string) + this.cjZ.getPageContext().getString(i.h.go_to_discuss_post);
        }
        this.cmB.setText(string);
        this.cmB.setVisibility(0);
        this.cmB.setOnClickListener(this.aWY);
        ahg();
    }

    private void agV() {
        this.cmI = (LinearLayout) this.clA.findViewById(i.f.btn_show_passed_pb);
        this.cmK = (TextView) this.clA.findViewById(i.f.show_pre_page_view);
        this.cmJ = (TextView) this.clA.findViewById(i.f.go_back_top_view);
        this.aCS = this.clA.findViewById(i.f.show_passed_divider);
        this.cmK.setOnClickListener(this.cmU);
        this.cmJ.setOnClickListener(this.aWY);
        ahg();
    }

    public void ab(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.cmf == null) {
            this.cmf = LayoutInflater.from(this.cjZ.getPageContext().getPageActivity()).inflate(i.g.forum_manage_dialog, (ViewGroup) null);
        }
        this.cjZ.getLayoutMode().k(this.cmf);
        if (this.cme == null) {
            this.cme = new Dialog(this.cjZ.getPageContext().getPageActivity(), i.C0057i.common_alert_dialog);
            this.cme.setCanceledOnTouchOutside(true);
            this.cme.setCancelable(true);
            this.cme.setContentView(this.cmf);
            WindowManager.LayoutParams attributes = this.cme.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.cjZ.getPageContext().getPageActivity()) * 0.9d);
            this.cme.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.cme.findViewById(i.f.del_post_btn);
        TextView textView2 = (TextView) this.cme.findViewById(i.f.forbid_user_btn);
        TextView textView3 = (TextView) this.cme.findViewById(i.f.disable_reply_btn);
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
            textView.setOnClickListener(new cy(this));
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
            textView2.setOnClickListener(new cz(this));
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
                textView3.setText(i.h.un_mute);
            } else {
                textView3.setText(i.h.mute);
            }
            sparseArray4.put(i.f.tag_is_mem, sparseArray.get(i.f.tag_is_mem));
            sparseArray4.put(i.f.tag_disable_reply_mute_userid, sparseArray.get(i.f.tag_disable_reply_mute_userid));
            sparseArray4.put(i.f.tag_disable_reply_mute_username, sparseArray.get(i.f.tag_disable_reply_mute_username));
            sparseArray4.put(i.f.tag_disable_reply_post_id, sparseArray.get(i.f.tag_disable_reply_post_id));
            sparseArray4.put(i.f.tag_disable_reply_thread_id, sparseArray.get(i.f.tag_disable_reply_thread_id));
            textView3.setOnClickListener(new da(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.cme, this.cjZ.getPageContext());
    }

    public void a(PbActivity.a aVar) {
        this.cmV = aVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(i.f.tag_del_post_id, str);
        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = i.h.del_post_confirm;
        if (i == 0) {
            i3 = i.h.del_thread_confirm;
        }
        this.cmg = new com.baidu.tbadk.core.dialog.a(this.cjZ.getActivity());
        this.cmg.bF(i3);
        this.cmg.x(sparseArray);
        this.cmg.a(i.h.dialog_ok, this.cjZ);
        this.cmg.b(i.h.dialog_cancel, new db(this));
        this.cmg.aj(true);
        this.cmg.b(this.cjZ.getPageContext());
        this.cmg.sR();
    }

    public void R(ArrayList<com.baidu.tbadk.core.data.k> arrayList) {
        if (this.cmr == null) {
            this.cmr = LayoutInflater.from(this.cjZ.getPageContext().getPageActivity()).inflate(i.g.commit_good, (ViewGroup) null);
        }
        this.cjZ.getLayoutMode().k(this.cmr);
        if (this.cmq == null) {
            this.cmq = new Dialog(this.cjZ.getPageContext().getPageActivity(), i.C0057i.common_alert_dialog);
            this.cmq.setCanceledOnTouchOutside(true);
            this.cmq.setCancelable(true);
            this.cmz = (ScrollView) this.cmr.findViewById(i.f.good_scroll);
            this.cmq.setContentView(this.cmr);
            WindowManager.LayoutParams attributes = this.cmq.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.k.d(this.cjZ.getPageContext().getPageActivity(), i.d.ds540);
            this.cmq.getWindow().setAttributes(attributes);
            this.cmt = new dc(this);
            this.cms = (LinearLayout) this.cmr.findViewById(i.f.good_class_group);
            this.cmv = (TextView) this.cmr.findViewById(i.f.dialog_button_cancel);
            this.cmv.setOnClickListener(new de(this));
            this.cmu = (TextView) this.cmr.findViewById(i.f.dialog_button_ok);
            this.cmu.setOnClickListener(this.aWY);
        }
        this.cms.removeAllViews();
        this.clz = new ArrayList();
        com.baidu.tieba.pb.pb.main.b.a aW = aW("0", this.cjZ.getPageContext().getString(i.h.def_good_class));
        this.clz.add(aW);
        aW.setChecked(true);
        this.cms.addView(aW);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tieba.pb.pb.main.b.a aW2 = aW(String.valueOf(arrayList.get(i2).rD()), arrayList.get(i2).rC());
                this.clz.add(aW2);
                View view = new View(this.cjZ.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.d(this.cjZ.getPageContext().getPageActivity(), i.d.ds1));
                com.baidu.tbadk.core.util.an.j(view, i.c.cp_bg_line_a);
                view.setLayoutParams(layoutParams);
                this.cms.addView(view);
                this.cms.addView(aW2);
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.cmz.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.cjZ.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.cjZ.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.k.dip2px(this.cjZ.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.cmz.setLayoutParams(layoutParams2);
            this.cmz.removeAllViews();
            this.cmz.addView(this.cms);
        }
        com.baidu.adp.lib.g.j.a(this.cmq, this.cjZ.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.b.a aW(String str, String str2) {
        Activity pageActivity = this.cjZ.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.b.a aVar = new com.baidu.tieba.pb.pb.main.b.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.k.d(pageActivity, i.d.ds100));
        aVar.setOnCheckedChangeListener(this.cmt);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void agW() {
        this.cjZ.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.cjZ.hideProgressBar();
        if (z && z2) {
            this.cjZ.showToast(this.cjZ.getPageContext().getString(i.h.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.as.isEmpty(str)) {
                str = TbadkCoreApplication.m411getInst().getResources().getString(i.h.neterror);
            }
            this.cjZ.showToast(str);
        }
    }

    public void VN() {
        this.cmc.setVisibility(0);
    }

    public void VM() {
        this.cmc.setVisibility(8);
    }

    public View agX() {
        if (this.cmr != null) {
            return this.cmr.findViewById(i.f.dialog_button_ok);
        }
        return null;
    }

    public String agY() {
        return this.cmw;
    }

    public View getView() {
        return this.ccO;
    }

    public void agZ() {
        com.baidu.adp.lib.util.k.c(this.cjZ.getPageContext().getPageActivity(), this.cjZ.getCurrentFocus());
    }

    public void aha() {
        this.cjZ.showProgressBar();
    }

    public void eN(boolean z) {
        this.cjZ.hideProgressBar();
        aho();
    }

    public void ahb() {
        this.cma.startLoadData();
    }

    public void ahc() {
    }

    public void ahd() {
        this.cjZ.hideProgressBar();
        this.cma.vz();
        ahu();
        this.aVo.completePullRefresh();
        ahg();
    }

    public void ahe() {
        this.aVo.completePullRefresh();
        this.cmI.setVisibility(8);
        ahg();
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.clV.setOnLongClickListener(onLongClickListener);
    }

    public void a(c.b bVar, boolean z, boolean z2) {
        if (this.cmx != null) {
            this.cmx.dismiss();
            this.cmx = null;
        }
        this.cmx = new com.baidu.tbadk.core.dialog.c(this.cjZ.getPageContext().getPageActivity());
        this.cmx.bI(i.h.operation);
        if (z2) {
            this.cmx.a(new String[]{this.cjZ.getPageContext().getString(i.h.copy)}, bVar);
        } else if (!z) {
            this.cmx.a(new String[]{this.cjZ.getPageContext().getString(i.h.copy), this.cjZ.getPageContext().getString(i.h.mark)}, bVar);
        } else {
            this.cmx.a(new String[]{this.cjZ.getPageContext().getString(i.h.copy), this.cjZ.getPageContext().getString(i.h.remove_mark)}, bVar);
        }
        this.cmx.d(this.cjZ.getPageContext());
        this.cmx.sU();
    }

    public int ahf() {
        int firstVisiblePosition = this.aVo.getFirstVisiblePosition();
        com.baidu.adp.widget.ListView.e eVar = (com.baidu.adp.widget.ListView.e) this.aVo.getAdapter();
        if (eVar != null) {
            if (eVar.getItem(firstVisiblePosition) instanceof com.baidu.tieba.pb.a.b) {
                firstVisiblePosition++;
            }
            int headersCount = (this.aVo.getAdapter() == null || !(this.aVo.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : ((com.baidu.adp.widget.ListView.e) this.aVo.getAdapter()).getHeadersCount();
            return firstVisiblePosition > headersCount ? firstVisiblePosition - headersCount : 0;
        }
        return firstVisiblePosition;
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.clY.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void h(com.baidu.tieba.pb.a.c cVar) {
        this.clV.a(cVar);
        this.clV.notifyDataSetChanged();
        if (cVar == null) {
            jS("");
        } else {
            jS(com.baidu.tbadk.core.util.as.q(cVar.afh().getReply_num()));
        }
        ahg();
    }

    public void i(com.baidu.tieba.pb.a.c cVar) {
        PraiseData praise;
        if (this.clO == null) {
            this.cjZ.getLayoutMode().k(((ViewStub) this.clA.findViewById(i.f.praise_layout)).inflate());
            this.clO = (FrsPraiseView) this.clA.findViewById(i.f.pb_head_praise_view);
            this.clO.setIsFromPb(true);
            this.clS = this.clA.findViewById(i.f.new_pb_header_item_line_above_praise);
            this.clO.cP(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.clO != null) {
            boolean ahg = ahg();
            if (cVar != null && cVar.afi() != null && cVar.afi().size() > 0) {
                com.baidu.tieba.tbadkCore.data.o oVar = cVar.afi().get(0);
                if ((!this.chq || oVar.axt() != 1) && (praise = cVar.afh().getPraise()) != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    this.clO.setVisibility(0);
                    this.clO.setIsFromPb(true);
                    this.clO.a(praise, cVar.afh().getId(), praise.getPostId(), true);
                    this.clS.setVisibility(0);
                    if (this.clO.getVisibility() == 0) {
                        this.clT.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            this.clO.setVisibility(8);
            this.clS.setVisibility(8);
            if (cVar != null && cVar.getPage() != null && cVar.getPage().rL() == 0 && this.chq) {
                this.clS.setVisibility(8);
                if (ahg) {
                    this.clR.setVisibility(0);
                    return;
                } else {
                    this.clR.setVisibility(8);
                    return;
                }
            }
            this.clS.setVisibility(0);
            this.clR.setVisibility(8);
        }
    }

    private com.baidu.tieba.tbadkCore.data.o a(com.baidu.tieba.pb.a.c cVar, boolean z, int i) {
        if (z) {
            if (cVar == null || cVar.afi() == null || cVar.afi().size() <= 0) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.o oVar = cVar.afi().get(0);
            if (oVar.axt() != 1) {
                return j(cVar);
            }
            return oVar;
        }
        return j(cVar);
    }

    private com.baidu.tieba.tbadkCore.data.o j(com.baidu.tieba.pb.a.c cVar) {
        MetaData metaData;
        if (cVar == null || cVar.afh() == null || cVar.afh().getAuthor() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
        MetaData author = cVar.afh().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = cVar.afh().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        oVar.lk(1);
        oVar.setId(cVar.afh().ss());
        oVar.setTitle(cVar.afh().getTitle());
        oVar.setTime(cVar.afh().getCreateTime());
        oVar.setAuthor(metaData);
        return oVar;
    }

    private void b(com.baidu.tieba.pb.a.c cVar, boolean z, int i) {
        this.clC.setVisibility(8);
        com.baidu.tieba.tbadkCore.data.o a = a(cVar, z, i);
        if (a != null) {
            if (z) {
                this.clN.setVisibility(8);
            } else {
                this.clN.setVisibility(0);
            }
            this.clC.setVisibility(0);
            SparseArray sparseArray = (SparseArray) this.clC.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.clC.setTag(sparseArray);
            }
            sparseArray.put(i.f.tag_clip_board, a);
            sparseArray.put(i.f.tag_is_subpb, false);
            this.clM.setText(com.baidu.tbadk.core.util.as.m(a.getTime()));
            cVar.afh().sA();
            this.clD.setVisibility(0);
            this.clD.setText(cVar.afh().getSpan_str());
            i(cVar);
            ArrayList<com.baidu.tbadk.core.data.a> so = cVar.afh().so();
            if (so != null && so.size() > 0) {
                this.cmQ.setText(String.valueOf(so.get(0).rm()));
                this.cmP.setVisibility(0);
            } else {
                this.cmP.setVisibility(8);
            }
            com.baidu.tbadk.core.util.an.i(this.cmP, i.e.activity_join_num_bg);
            com.baidu.tbadk.core.util.an.b(this.cmQ, i.c.cp_link_tip_d, 1);
            boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class);
            if (cVar != null && cVar.afh() != null && cVar.afh().getAnchorInfoData() != null) {
                if (cVar.afh().getAnchorInfoData().getGroup_id() != 0 && appResponseToIntentClass) {
                    if (this.cmN == null) {
                        BdLog.e("pb time   liveCardLayout new");
                        this.cmN = ((ViewStub) this.clA.findViewById(i.f.live_card_layout)).inflate();
                        this.cjZ.getLayoutMode().k(this.cmN);
                        this.cmO = (LiveBroadcastCard) this.clA.findViewById(i.f.item_card);
                    }
                    this.cmN.setVisibility(0);
                    LiveCardData liveCardData = new LiveCardData();
                    liveCardData.setPublisherId(cVar.afh().getAnchorInfoData().getAuthorId());
                    liveCardData.setPublisherName(cVar.afh().getAnchorInfoData().getAuthorName());
                    liveCardData.setPublisherPortrait(cVar.afh().getAnchorInfoData().getPublisherPortrait());
                    liveCardData.setGroupId(cVar.afh().getAnchorInfoData().getGroup_id());
                    liveCardData.setIntro(cVar.afh().getAnchorInfoData().getIntro());
                    liveCardData.setLikers(cVar.afh().getAnchorInfoData().getLikers());
                    liveCardData.setListeners(cVar.afh().getAnchorInfoData().getListeners());
                    liveCardData.setName(cVar.afh().getAnchorInfoData().getName());
                    liveCardData.setPortrait(cVar.afh().getAnchorInfoData().getPortrait());
                    liveCardData.setStatus(cVar.afh().getAnchorInfoData().getStatus());
                    liveCardData.setStartTime(cVar.afh().getAnchorInfoData().getStartTime());
                    liveCardData.setIsVip(cVar.afh().getAnchorInfoData().getIsVip());
                    this.cmO.setData(liveCardData);
                    this.cmO.setStatisticsKey("notice_pb_live");
                } else if (this.cmN != null) {
                    this.cmN.setVisibility(8);
                }
            }
            if (cVar != null && cVar.afh() != null && cVar.afh().getAuthor() != null) {
                String userId = cVar.afh().getAuthor().getUserId();
                if (userId != null && !userId.equals("0") && userId.equals(a.getAuthor().getUserId())) {
                    this.clL.setVisibility(0);
                } else {
                    this.clL.setVisibility(8);
                }
            }
            if (a.getAuthor() != null) {
                int level_id = a.getAuthor().getLevel_id();
                int is_bawu = a.getAuthor().getIs_bawu();
                String bawu_type = a.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.clG.setVisibility(0);
                    com.baidu.tbadk.core.util.an.c(this.clG, com.baidu.tbadk.core.util.c.ch(level_id));
                    this.clG.setOnClickListener(null);
                } else {
                    this.clG.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.an.c(this.clI, i.e.pb_manager);
                        this.clG.setVisibility(8);
                        this.clI.setVisibility(0);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.an.c(this.clI, i.e.pb_assist);
                        this.clG.setVisibility(8);
                        this.clI.setVisibility(0);
                    }
                }
                if (a.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.an.c(this.clH, i.e.icon_pb_pop_girl);
                    this.clH.setVisibility(0);
                } else if (a.getAuthor().getGender() == 1) {
                    com.baidu.tbadk.core.util.an.c(this.clH, i.e.icon_pb_pop_boy);
                    this.clH.setVisibility(0);
                } else {
                    this.clH.setVisibility(8);
                }
                if (!StringUtils.isNull(a.getAuthor().getName_show()) && com.baidu.adp.lib.util.j.aR(a.getAuthor().getName_show()) > 14) {
                    i2 = 0;
                }
                ArrayList<IconData> iconInfo = a.getAuthor().getIconInfo();
                ArrayList<IconData> tShowInfo = a.getAuthor().getTShowInfo();
                if (this.clJ != null) {
                    this.clJ.setTag(i.f.tag_user_id, a.getAuthor().getUserId());
                    this.clJ.setOnClickListener(this.cjZ.cjp.aXx);
                    this.clJ.a(iconInfo, i2, this.cjZ.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.cjZ.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.cjZ.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                }
                if (this.clK != null) {
                    this.clK.setOnClickListener(this.cjZ.cjp.cnd);
                    this.clK.a(tShowInfo, 3, this.cjZ.getResources().getDimensionPixelSize(i.d.small_icon_width), this.cjZ.getResources().getDimensionPixelSize(i.d.small_icon_height), this.cjZ.getResources().getDimensionPixelSize(i.d.big_icon_margin), true);
                }
                this.clE.setText(a.getAuthor().getName_show());
                this.clE.setTag(i.f.tag_user_id, a.getAuthor().getUserId());
                this.clE.setTag(i.f.tag_user_name, a.getAuthor().getName_show());
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.an.b(this.clE, i.c.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.an.b(this.clE, i.c.cp_cont_f, 1);
                }
                if (!this.chO) {
                    this.clF.setVisibility(8);
                }
                this.clF.setUserId(a.getAuthor().getUserId());
                this.clF.setUserName(a.getAuthor().getUserName());
                this.clF.setImageDrawable(null);
                this.clF.setTag(a.getAuthor().getUserId());
                this.clE.setOnClickListener(this.cjZ.cjp.cnc);
                this.clF.setOnClickListener(this.cjZ.cjp.cnc);
                this.clF.d(a.getAuthor().getPortrait(), 28, false);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable agG;
        Parcelable agG2;
        String sb;
        if (cVar != null) {
            this.cmM = false;
            this.chq = z;
            ahd();
            b(cVar, z, i);
            this.clV.es(this.chq);
            this.clV.a(cVar);
            this.clV.notifyDataSetChanged();
            if (cVar.afg() != null) {
                this.mForumName = cVar.afg().getName();
            }
            this.cly.jU(this.mForumName);
            if (cVar.afh() != null) {
                jS(com.baidu.tbadk.core.util.as.q(cVar.afh().getReply_num()));
                if (cVar.afh().getPraise() != null) {
                    if (cVar.afh().getPraise().getNum() < 1) {
                        sb = this.cjZ.getResources().getString(i.h.frs_item_praise_text);
                    } else {
                        sb = new StringBuilder(String.valueOf(cVar.afh().getPraise().getNum())).toString();
                    }
                    C(sb, cVar.afh().getPraise().getIsLike() == 1);
                }
            }
            if (cVar.getPage().rK() == 0 && !z) {
                this.aVo.setNextPage(null);
            } else if (this.cjZ.isLogin()) {
                this.aVo.setNextPage(this.cma);
                ahu();
            } else if (cVar.getPage().rK() == 1) {
                this.cmM = true;
                if (this.cmb == null) {
                    this.cmb = new com.baidu.tieba.pb.view.b(this.cjZ.getPageContext());
                }
                this.aVo.setNextPage(this.cmb);
            }
            if (cVar.getPage().rL() == 0 && z) {
                this.aVo.setPullRefresh(null);
                this.cmI.setVisibility(8);
            } else {
                if (this.clZ == null) {
                    this.clZ = new com.baidu.tieba.pb.view.f(this.cjZ.getPageContext());
                    this.clZ.np();
                    this.clZ.a(this.aeE);
                }
                this.aVo.setPullRefresh(this.clZ);
                if (this.clZ != null) {
                    this.clZ.cN(TbadkCoreApplication.m411getInst().getSkinType());
                }
                this.cmI.setVisibility(0);
                ahu();
            }
            ahg();
            if (cVar.getPage().rK() == 0) {
                this.cma.setText(this.cjZ.getResources().getString(i.h.list_no_more));
                k(cVar);
            } else if (z2) {
                if (this.cmW) {
                    vz();
                    if (cVar.getPage().rK() != 0) {
                        this.cma.setText(this.cjZ.getResources().getString(i.h.pb_load_more));
                    }
                } else {
                    this.cma.showLoading();
                }
            } else {
                this.cma.showLoading();
            }
            if (z) {
                this.cmJ.setVisibility(0);
                this.aCS.setVisibility(0);
                this.cmK.setText(this.cjZ.getResources().getString(i.h.btn_show_passed_pb));
            } else {
                this.cmJ.setVisibility(8);
                this.aCS.setVisibility(8);
                this.cmK.setText(this.cjZ.getResources().getString(i.h.btn_show_passed_pb_aftre));
            }
            if (cVar.afh() != null && cVar.afh().getAuthor() != null && cVar.afh().getAuthor().getType() == 0) {
                this.cly.ahx();
            }
            switch (i) {
                case 2:
                    this.aVo.setSelection(i2);
                    if (this.clB != null) {
                        CompatibleUtile.scrollListViewBy(this.aVo, -this.clB.getHeight(), 0);
                        return;
                    }
                    return;
                case 3:
                    if (i3 == 1 && (agG2 = cm.agF().agG()) != null) {
                        this.aVo.onRestoreInstanceState(agG2);
                        return;
                    } else {
                        this.aVo.setSelection(0);
                        return;
                    }
                case 4:
                    this.cmW = false;
                    this.aVo.setSelection(0);
                    return;
                case 5:
                    this.aVo.setSelection(0);
                    return;
                case 6:
                    if (i3 == 1 && (agG = cm.agF().agG()) != null) {
                        this.aVo.onRestoreInstanceState(agG);
                        return;
                    } else {
                        this.aVo.setSelection(0);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void eO(boolean z) {
        this.cmy = z;
        this.cly.eO(z);
    }

    public void vz() {
        if (this.cma != null) {
            this.cma.vz();
        }
        ahu();
    }

    public void Mb() {
        this.aVo.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahg() {
        boolean z;
        boolean z2 = true;
        if (this.clB != null && this.clB.getVisibility() == 0) {
            if (this.clP != null) {
                this.clP.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.clP != null) {
                this.clP.setVisibility(8);
            }
            z = false;
        }
        if (this.cmB != null && this.cmB.getVisibility() == 0) {
            if (this.clQ != null) {
                this.clQ.setVisibility(0);
            }
        } else {
            if (this.clQ != null) {
                this.clQ.setVisibility(8);
            }
            z2 = z;
        }
        if ((this.clS == null || this.clS.getVisibility() == 8) && z2 && this.chq) {
            this.clR.setVisibility(0);
        } else {
            this.clR.setVisibility(8);
        }
        return z2;
    }

    public boolean a(com.baidu.tieba.pb.a.c cVar, boolean z, boolean z2) {
        if (cVar == null) {
            return false;
        }
        if (this.clD != null) {
            if (cVar.afh().sr() == 0) {
                this.clD.setVisibility(0);
                cVar.afh().sA();
                this.clD.setText(cVar.afh().getSpan_str());
            } else {
                this.clD.setVisibility(8);
            }
        }
        if (z) {
            if (this.cmN != null) {
                this.cmN.findViewById(i.f.pb_head_live_blank).setVisibility(8);
            }
        } else if (this.cmN != null) {
            this.cmN.findViewById(i.f.pb_head_live_blank).setVisibility(0);
        }
        this.chq = z;
        com.baidu.tbadk.core.data.w afh = cVar.afh();
        if (afh != null) {
            a(afh.si());
        }
        if (cVar.afl() == 1) {
            ahh();
            Button button = (Button) this.clA.findViewById(i.f.pb_head_function_manage_commit_top);
            Button button2 = (Button) this.clA.findViewById(i.f.pb_head_function_manage_cancel_top);
            Button button3 = (Button) this.clA.findViewById(i.f.pb_head_function_manage_commit_good);
            Button button4 = (Button) this.clA.findViewById(i.f.pb_head_function_manage_cancel_good);
            button.setOnClickListener(this.aWY);
            button2.setOnClickListener(this.aWY);
            button3.setOnClickListener(this.aWY);
            button4.setOnClickListener(this.aWY);
            if (cVar.afh().getIs_good() == 1) {
                button3.setVisibility(8);
                button4.setVisibility(0);
            } else {
                button3.setVisibility(0);
                button4.setVisibility(8);
            }
            if (cVar.afh().getIs_top() == 1) {
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

    private void ahh() {
        if (this.clB == null) {
            this.clB = ((ViewStub) this.clA.findViewById(i.f.pb_header_function_manage)).inflate();
            this.cjZ.getLayoutMode().k(this.clB);
            this.clP = this.clA.findViewById(i.f.new_pb_header_item_line_above_manage);
            return;
        }
        this.clB.setVisibility(0);
    }

    public void a(com.baidu.tieba.pb.a.c cVar, boolean z, boolean z2, int i) {
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        if (cVar != null) {
            a(cVar, z, z2);
            com.baidu.tieba.tbadkCore.data.o a = a(cVar, z, i);
            if (a != null) {
                if (cVar.afl() != 0 && a.getAuthor() != null) {
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
                    String userId3 = cVar.afh().getAuthor().getUserId();
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
                    sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(cVar.afl()));
                    sparseArray.put(i.f.tag_should_manage_visible, true);
                    a(i.h.manage, sparseArray);
                } else if (z4) {
                    SparseArray<Object> sparseArray2 = new SparseArray<>();
                    sparseArray2.put(i.f.tag_del_post_id, a.getId());
                    sparseArray2.put(i.f.tag_del_post_type, 0);
                    sparseArray2.put(i.f.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(i.f.tag_manage_user_identity, Integer.valueOf(cVar.afl()));
                    sparseArray2.put(i.f.tag_should_manage_visible, false);
                    a(i.h.delete, sparseArray2);
                }
            }
            ahg();
        }
    }

    private void a(int i, SparseArray<Object> sparseArray) {
        ahh();
        Button button = (Button) this.clA.findViewById(i.f.pb_head_function_manage_delormanage);
        button.setOnClickListener(this.aWY);
        button.setVisibility(0);
        button.setText(i);
        button.setTag(sparseArray);
    }

    public View getNextView() {
        return this.avd;
    }

    public void jT(String str) {
        if (this.cma != null && !StringUtils.isNull(str)) {
            this.cma.setText(str);
        }
    }

    public BdListView getListView() {
        return this.aVo;
    }

    public int ahi() {
        return i.f.richText;
    }

    public int Mi() {
        return i.f.user_icon_box;
    }

    public Button ahj() {
        return (Button) this.clA.findViewById(i.f.pb_head_function_manage_commit_good);
    }

    public Button ahk() {
        return (Button) this.clA.findViewById(i.f.pb_head_function_manage_cancel_good);
    }

    public Button ahl() {
        return (Button) this.clA.findViewById(i.f.pb_head_function_manage_commit_top);
    }

    public Button ahm() {
        return (Button) this.clA.findViewById(i.f.pb_head_function_manage_cancel_top);
    }

    public void c(BdListView.e eVar) {
        this.aVo.setOnSrollToBottomListener(eVar);
    }

    public void a(BdListView.h hVar) {
        this.aVo.setOnSrollToTopListener(hVar);
    }

    public void a(p.a aVar) {
        this.aeE = aVar;
        if (this.clZ != null) {
            this.clZ.a(aVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.o oVar, a.b bVar) {
        if (oVar != null) {
            int rI = oVar.rI();
            int rG = oVar.rG();
            if (this.clW != null) {
                this.clW.sR();
            } else {
                this.clW = new com.baidu.tbadk.core.dialog.a(this.cjZ.getPageContext().getPageActivity());
                this.clX = LayoutInflater.from(this.cjZ.getPageContext().getPageActivity()).inflate(i.g.dialog_direct_pager, (ViewGroup) null);
                this.clW.m(this.clX);
                this.clW.a(i.h.dialog_ok, bVar);
                this.clW.b(i.h.dialog_cancel, new df(this));
                this.clW.b(this.cjZ.getPageContext()).sR();
            }
            this.clY = (EditText) this.clX.findViewById(i.f.input_page_number);
            this.clY.setText("");
            this.clY.setOnFocusChangeListener(new dg(this));
            TextView textView = (TextView) this.clX.findViewById(i.f.current_page_number);
            if (rI <= 0) {
                rI = 1;
            }
            if (rG <= 0) {
                rG = 1;
            }
            textView.setText(MessageFormat.format(this.cjZ.getApplicationContext().getResources().getString(i.h.current_page), Integer.valueOf(rI), Integer.valueOf(rG)));
            this.cjZ.ShowSoftKeyPadDelay(this.clY, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aVo.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.cjZ.showToast(str);
    }

    public boolean eP(boolean z) {
        if (this.KB == null || !this.KB.AC()) {
            return false;
        }
        this.KB.zc();
        return true;
    }

    public void ahn() {
        if (this.cmX != null) {
            while (this.cmX.size() > 0) {
                TbImageView remove = this.cmX.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        ahn();
    }

    public void onDestroy() {
        this.cjZ.hideProgressBar();
        if (this.aMY != null && this.aSi != null) {
            this.aMY.b(this.aSi);
        }
        aho();
        this.cma.vz();
    }

    public void aho() {
        this.cly.qs();
        com.baidu.adp.lib.util.k.c(this.cjZ.getPageContext().getPageActivity(), this.clY);
        if (this.cmx != null) {
            this.cmx.dismiss();
        }
        ahp();
    }

    public void er(boolean z) {
        this.clV.er(z);
    }

    public void et(boolean z) {
        this.chO = z;
        this.clV.et(z);
    }

    public void eQ(boolean z) {
        this.cmA = z;
    }

    public void ahp() {
        if (this.cmg != null) {
            this.cmg.dismiss();
        }
        if (this.cmh != null) {
            com.baidu.adp.lib.g.j.b(this.cmh, this.cjZ.getPageContext());
        }
        if (this.cmq != null) {
            com.baidu.adp.lib.g.j.b(this.cmq, this.cjZ.getPageContext());
        }
        if (this.cme != null) {
            com.baidu.adp.lib.g.j.b(this.cme, this.cjZ.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        this.cjZ.getLayoutMode().ad(i == 1);
        this.cjZ.getLayoutMode().k(this.ccO);
        this.cjZ.getLayoutMode().k(this.clA);
        this.cjZ.getLayoutMode().k(this.avd);
        this.cly.mNavigationBar.onChangeSkinType(this.cjZ.getPageContext(), i);
        com.baidu.tbadk.core.util.an.a(this.cly.cnl, i.e.btn_more_selector_s, i.e.btn_more_selector);
        com.baidu.tbadk.core.util.an.a(this.cly.cnm, i.e.icon_floor_addition_selector, i.e.icon_floor_addition_selector);
        if (this.clX != null) {
            this.cjZ.getLayoutMode().k(this.clX);
        }
        eO(this.cmy);
        this.clV.notifyDataSetChanged();
        if (this.clZ != null) {
            this.clZ.cN(i);
        }
        if (this.cma != null) {
            this.cma.cN(i);
            com.baidu.tbadk.core.util.an.i(this.avd, i.e.pb_foot_more_trans_selector);
            this.cma.cL(i.e.pb_foot_more_trans_selector);
        }
        if (this.KB != null) {
            this.KB.onChangeSkinType(i);
        }
        if (this.clO != null) {
            this.clO.cP(i);
        }
        if (this.cmb != null) {
            this.cmb.cN(i);
        }
        if (this.clz != null && this.clz.size() > 0) {
            for (com.baidu.tieba.pb.pb.main.b.a aVar : this.clz) {
                aVar.ahv();
            }
        }
        eK(i == 1);
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aBf = dVar;
        this.clV.setOnImageClickListener(this.aBf);
    }

    public void g(NoNetworkView.a aVar) {
        this.aSi = aVar;
        if (this.aMY != null) {
            this.aMY.a(this.aSi);
        }
    }

    public void eR(boolean z) {
        this.clV.setIsFromCDN(z);
        this.mIsFromCDN = z;
    }

    public Button ahq() {
        return this.cmB;
    }

    public void k(com.baidu.tieba.pb.a.c cVar) {
        if (cVar != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.o> afi = cVar.afi();
            if (afi.size() == 1) {
                com.baidu.tieba.tbadkCore.data.o oVar = afi.get(0);
                if (oVar.axz() < oVar.axs().size()) {
                    this.aVo.setNextPage(null);
                    return;
                } else {
                    this.aVo.setNextPage(this.cma);
                    return;
                }
            }
            this.aVo.setNextPage(this.cma);
        }
    }

    public void ahr() {
        if (com.baidu.tbadk.performanceLog.y.DR().DS()) {
            int lastVisiblePosition = this.aVo.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aVo.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(i.f.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.s perfLog = tbImageView.getPerfLog();
                                perfLog.ex(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                                perfLog.awg = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView.vs();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(i.f.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.performanceLog.s perfLog2 = headImageView.getPerfLog();
                        perfLog2.ex(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                        perfLog2.awg = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                            }
                        }
                        headImageView.vs();
                    }
                }
            }
        }
    }

    public void eS(boolean z) {
        if (this.cmC != null && this.cmC != null) {
            if (this.cmA) {
                eH(z);
            } else {
                eI(z);
            }
        }
    }

    public void ahs() {
        if (this.cmC != null) {
            this.cmC.setVisibility(8);
        }
    }

    public TextView aht() {
        return this.cmJ;
    }

    public void Zw() {
        if (this.cmL == null) {
            this.cmL = new com.baidu.tbadk.core.view.a(this.cjZ.getPageContext());
        }
        this.cmL.av(true);
    }

    public void ahu() {
        if (this.cmL != null) {
            this.cmL.av(false);
        }
    }
}
