package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.f;
import com.baidu.tieba.NEGFeedBack.i;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.a;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class ap {
    private EditorTools acR;
    private View bLj;
    private View bMM;
    private RelativeLayout bMd;
    private View fIC;
    private f.c fjz;
    private com.baidu.tieba.pb.a.c fvK;
    private NoNetworkView gyk;
    private boolean isLandscape;
    private List<CustomBlueCheckRadioButton> izH;
    private NavigationBarCoverTip jMu;
    private com.baidu.tieba.NEGFeedBack.f jRi;
    private boolean jgj;
    private View.OnClickListener jjj;
    private PbListView jot;
    private TextView kpu;
    private PbFragment lNm;
    private com.baidu.tieba.pb.data.f lOF;
    private View.OnClickListener lOs;
    private MaskView lQg;
    private com.baidu.tieba.pb.pb.main.a.d lQh;
    private PbFakeFloorModel lRd;
    PbFragment.c lSX;
    public int lYU;
    public final com.baidu.tieba.pb.pb.main.view.c lYW;
    public com.baidu.tieba.pb.pb.main.view.b lYX;
    private ViewStub lYY;
    private ViewStub lYZ;
    private View lZH;
    private View lZJ;
    private View lZK;
    private LinearLayout lZL;
    private HeadImageView lZM;
    private ImageView lZN;
    private ImageView lZO;
    private ImageView lZP;
    private com.baidu.tieba.pb.view.d lZQ;
    private TextView lZR;
    private TextView lZS;
    private int lZU;
    private int lZV;
    private PostData lZW;
    private ViewStub lZY;
    private PbInterviewStatusView lZZ;
    private PbLandscapeListView lZa;
    private PbThreadPostView lZb;
    private com.baidu.tieba.pb.pb.main.a.f lZc;
    private com.baidu.tieba.pb.pb.main.a.a lZd;
    private com.baidu.tieba.pb.pb.main.a.c lZe;
    private com.baidu.tieba.pb.pb.main.a.e lZf;
    private com.baidu.tieba.pb.pb.main.a.b lZg;
    private LinearLayout lZh;
    private TextView lZi;
    private TextView lZj;
    private ObservedChangeRelativeLayout lZk;
    private g lZl;
    private View lZr;
    public int mLastScrollY;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private int maC;
    private PbTopTipView maD;
    private PopupWindow maE;
    private TextView maF;
    private List<String> maG;
    private com.baidu.tieba.pb.pb.main.emotion.c maH;
    private com.baidu.tieba.pb.pb.godreply.a maI;
    private PbLandscapeListView.b maJ;
    private ae maL;
    private com.baidu.tieba.NEGFeedBack.i maM;
    private String maN;
    private long maO;
    private int maP;
    private com.baidu.tieba.pb.view.c maS;
    private boolean maU;
    private Runnable maY;
    private FrameLayout maa;
    private View mab;
    private View mad;
    private PbReplyTitleViewHolder mae;
    private PbEmotionBar maj;
    private int mas;
    private Runnable mat;
    private r mau;
    private al mav;
    private PbFragment.b mba;
    private TextView textView;
    private static final int maf = UtilHelper.getLightStatusBarHeight();
    public static int mal = 3;
    public static int mam = 0;
    public static int man = 3;
    public static int mao = 4;
    public static int maq = 5;
    public static int mar = 6;
    private static final int maQ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
    private static a.InterfaceC0872a maT = new a.InterfaceC0872a() { // from class: com.baidu.tieba.pb.pb.main.ap.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0872a
        public void onRefresh() {
        }
    };
    private int lYV = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a lZm = null;
    private com.baidu.tbadk.core.dialog.b jji = null;
    private View lZn = null;
    private EditText lZo = null;
    private com.baidu.tieba.pb.view.e lZp = null;
    private com.baidu.tieba.pb.view.a lZq = null;
    private b.InterfaceC0558b lZs = null;
    private TbRichTextView.i fUw = null;
    private NoNetworkView.a jdH = null;
    private com.baidu.tbadk.core.dialog.i lZt = null;
    private com.baidu.tbadk.core.dialog.a lZu = null;
    private Dialog lZv = null;
    private Dialog lZw = null;
    private View lZx = null;
    private LinearLayout lZy = null;
    private CompoundButton.OnCheckedChangeListener izI = null;
    private TextView lZz = null;
    private TextView lZA = null;
    private String lZB = null;
    private com.baidu.tbadk.core.dialog.i lRW = null;
    private com.baidu.tbadk.core.dialog.i lZC = null;
    private boolean lZD = false;
    private boolean lZE = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView lZF = null;
    private boolean lZG = false;
    private Button lZI = null;
    private boolean lZT = true;
    private com.baidu.tbadk.core.view.a iDU = null;
    private boolean lOk = false;
    private int mSkinType = 3;
    private boolean lZX = false;
    private int mag = 0;
    private boolean mah = true;
    public a mai = new a();
    private int mak = 0;
    private boolean maw = false;
    private int may = 0;
    private boolean maz = false;
    private boolean maA = false;
    private boolean maB = false;
    private boolean maK = false;
    private int maR = 0;
    private String maV = null;
    private CustomMessageListener maW = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.ap.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ap.this.maV = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ap.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ap.this.lZl != null) {
                ap.this.lZl.notifyDataSetChanged();
            }
        }
    };
    private Handler maX = new Handler();
    private CustomMessageListener maZ = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.ap.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ap.this.lZT = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean mbb = true;
    View.OnClickListener mbc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || ap.this.lOF == null || ap.this.lOF.dlg() == null || ap.this.lOF.dlg().bnQ() == null || ap.this.lOF.dlg().bnQ().getAlaInfo() == null || ap.this.lOF.dlg().bnQ().getAlaInfo().live_status != 1) {
                if (ap.this.maz) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11923").ap("obj_id", 2));
                }
                if (!ap.this.maz && ap.this.lOF != null && ap.this.lOF.dlg() != null && ap.this.lOF.dlg().bnQ() != null && ap.this.lOF.dlg().bnQ().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12151").ap("obj_locate", 1));
                }
                if (ap.this.lNm.doh() != null) {
                    ap.this.lNm.doh().lNy.iPT.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c11851");
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(arVar);
            if (ap.this.lOF.dlg().bnQ().getAlaInfo() == null || !ap.this.lOF.dlg().bnQ().getAlaInfo().isChushou) {
                if (ap.this.lOF.dlg().bnQ().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = ap.this.lOF.dlg().bnQ().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ap.this.lNm.doh(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            bf.bsV().b(ap.this.lNm.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + ap.this.lOF.dlg().bnQ().getAlaInfo().thirdRoomId + "&livetype=" + ap.this.lOF.dlg().bnQ().getAlaInfo().thirdLiveType});
        }
    };
    private boolean bje = false;
    String userId = null;
    private final List<TbImageView> mbd = new ArrayList();
    private boolean mbe = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int headerCount;
        public int lDo;
        public PbReplyTitleViewHolder mbs;
    }

    public void vy(boolean z) {
        this.maw = z;
        if (this.lZa != null) {
            this.may = this.lZa.getHeaderViewsCount();
        }
    }

    public void dqm() {
        if (this.lZa != null) {
            int headerViewsCount = this.lZa.getHeaderViewsCount() - this.may;
            final int firstVisiblePosition = (this.lZa.getFirstVisiblePosition() == 0 || this.lZa.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.lZa.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.lZa.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.mai.mbs = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.mai));
            final PbReplyTitleViewHolder pbReplyTitleViewHolder = this.mai.mbs;
            final int g = g(pbReplyTitleViewHolder);
            final int y = ((int) this.lZk.getY()) + this.lZk.getMeasuredHeight();
            final boolean z = this.mab.getVisibility() == 0;
            boolean z2 = this.lZk.getY() < 0.0f;
            if ((z && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.lZl.dmX() + this.lZa.getHeaderViewsCount()) {
                int measuredHeight = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.lYw.getMeasuredHeight() : 0;
                if (z2) {
                    this.lZa.setSelectionFromTop(this.lZl.dmX() + this.lZa.getHeaderViewsCount(), maf - measuredHeight);
                } else {
                    this.lZa.setSelectionFromTop(this.lZl.dmX() + this.lZa.getHeaderViewsCount(), this.lYW.dsp().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.lZa.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.maz && this.lZc != null) {
                this.lZa.setSelectionFromTop(this.lZl.dmX() + this.lZa.getHeaderViewsCount(), this.lZc.dsb());
            } else if (this.mType == 6) {
                this.lZa.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ap.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void onLayout() {
                        ViewGroup.LayoutParams layoutParams;
                        if (g >= 0 && g <= ap.this.bMd.getMeasuredHeight()) {
                            int g2 = ap.this.g(pbReplyTitleViewHolder);
                            int i = g2 - g;
                            if (z && i != 0 && g <= y) {
                                i = g2 - y;
                            }
                            if (ap.this.bMM != null && (layoutParams = ap.this.bMM.getLayoutParams()) != null) {
                                if (i == 0 || i > ap.this.bMd.getMeasuredHeight() || g2 >= ap.this.bMd.getMeasuredHeight()) {
                                    layoutParams.height = ap.this.mas;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ap.this.bMd.getMeasuredHeight()) {
                                    layoutParams.height = ap.this.mas;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    ap.this.lZa.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                ap.this.bMM.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (ap.this.bMM != null && ap.this.bMM.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = ap.this.bMM.getLayoutParams();
                                            layoutParams2.height = ap.this.mas;
                                            ap.this.bMM.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        ap.this.lZa.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView() == null) {
            return 0;
        }
        if (pbReplyTitleViewHolder.getView().getTop() != 0 || pbReplyTitleViewHolder.getView().isShown()) {
            return pbReplyTitleViewHolder.getView().getBottom();
        }
        return 0;
    }

    public NoNetworkView dqn() {
        return this.gyk;
    }

    public void dqo() {
        if (this.acR != null) {
            this.acR.hide();
            if (this.maH != null) {
                this.maH.dsd();
            }
        }
    }

    public PbFakeFloorModel dqp() {
        return this.lRd;
    }

    public r dqq() {
        return this.mau;
    }

    public com.baidu.tieba.pb.pb.main.a.f dqr() {
        return this.lZc;
    }

    public void dqs() {
        reset();
        dqo();
        this.mau.dnh();
        vK(false);
    }

    private void reset() {
        if (this.lNm != null && this.lNm.dnm() != null && this.acR != null) {
            com.baidu.tbadk.editortools.pb.a.bBK().setStatus(0);
            com.baidu.tbadk.editortools.pb.e dnm = this.lNm.dnm();
            dnm.bCf();
            dnm.bBu();
            if (dnm.getWriteImagesInfo() != null) {
                dnm.getWriteImagesInfo().setMaxImagesAllowed(dnm.isBJH ? 1 : 9);
            }
            dnm.re(SendView.ALL);
            dnm.rf(SendView.ALL);
            com.baidu.tbadk.editortools.h qR = this.acR.qR(23);
            com.baidu.tbadk.editortools.h qR2 = this.acR.qR(2);
            com.baidu.tbadk.editortools.h qR3 = this.acR.qR(5);
            if (qR2 != null) {
                qR2.display();
            }
            if (qR3 != null) {
                qR3.display();
            }
            if (qR != null) {
                qR.hide();
            }
            this.acR.invalidate();
        }
    }

    public boolean dqt() {
        return this.lZT;
    }

    public void vz(boolean z) {
        if (this.lZK != null && this.kpu != null) {
            this.kpu.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lZK.startAnimation(alphaAnimation);
            }
            this.lZJ.setVisibility(0);
            this.lZK.setVisibility(0);
            this.lZT = true;
            if (this.maj != null && !this.maI.isActive()) {
                this.maj.setVisibility(0);
                vE(true);
            }
        }
    }

    public void vA(boolean z) {
        if (this.lZK != null && this.kpu != null) {
            this.kpu.setText(dqu());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lZK.startAnimation(alphaAnimation);
            }
            this.lZJ.setVisibility(0);
            this.lZK.setVisibility(0);
            this.lZT = true;
            if (this.maj != null && !this.maI.isActive()) {
                this.maj.setVisibility(0);
                vE(true);
            }
        }
    }

    public String dqu() {
        if (!com.baidu.tbadk.core.util.au.isEmpty(this.maN)) {
            return this.maN;
        }
        if (this.lNm != null) {
            this.maN = TbadkCoreApplication.getInst().getResources().getString(ao.dqk());
        }
        return this.maN;
    }

    public PostData dqv() {
        int i = 0;
        if (this.lZa == null) {
            return null;
        }
        int dqw = dqw() - this.lZa.getHeaderViewsCount();
        if (dqw < 0) {
            dqw = 0;
        }
        if (this.lZl.FA(dqw) != null && this.lZl.FA(dqw) != PostData.nwX) {
            i = dqw + 1;
        }
        return this.lZl.getItem(i) instanceof PostData ? (PostData) this.lZl.getItem(i) : null;
    }

    public int dqw() {
        int i;
        View childAt;
        if (this.lZa == null) {
            return 0;
        }
        int firstVisiblePosition = this.lZa.getFirstVisiblePosition();
        int lastVisiblePosition = this.lZa.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.lZa.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.lZa.getChildAt(i3 - firstVisiblePosition)) != null) {
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
        if (i >= 0) {
            return i;
        }
        return 0;
    }

    public int dqx() {
        return this.lZa.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.lOF != null && this.lOF.dli() != null && !this.lOF.dli().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.lOF.dli().size() && (postData = this.lOF.dli().get(i)) != null && postData.bnQ() != null && !StringUtils.isNull(postData.bnQ().getUserId()); i++) {
                if (this.lOF.dli().get(i).bnQ().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.maI != null && this.maI.isActive()) {
                        vK(false);
                    }
                    if (this.maj != null) {
                        this.maj.vV(true);
                    }
                    this.maV = postData.bnQ().getName_show();
                    return;
                }
            }
        }
    }

    public ap(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.lNm = null;
        this.bMd = null;
        this.bLj = null;
        this.lZa = null;
        this.lZl = null;
        this.jot = null;
        this.fIC = null;
        this.jjj = null;
        this.lOs = null;
        this.lZK = null;
        this.kpu = null;
        this.lZY = null;
        this.maC = 0;
        this.maO = 0L;
        this.maO = System.currentTimeMillis();
        this.lNm = pbFragment;
        this.jjj = onClickListener;
        this.fvK = cVar;
        this.maC = com.baidu.adp.lib.util.l.getEquipmentWidth(this.lNm.getContext()) / 8;
        this.bMd = (RelativeLayout) LayoutInflater.from(this.lNm.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bMd.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.lZH = this.bMd.findViewById(R.id.bottom_shadow);
        this.jMu = (NavigationBarCoverTip) this.bMd.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.bLj = this.bMd.findViewById(R.id.statebar_view);
        this.lZk = (ObservedChangeRelativeLayout) this.bMd.findViewById(R.id.title_wrapper);
        this.gyk = (NoNetworkView) this.bMd.findViewById(R.id.view_no_network);
        this.lZa = (PbLandscapeListView) this.bMd.findViewById(R.id.new_pb_list);
        this.maa = (FrameLayout) this.bMd.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.lNm.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.lNm.getActivity(), R.dimen.ds88));
        this.lZa.addHeaderView(this.textView, 0);
        this.lZa.setTextViewAdded(true);
        this.mas = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bMM = new View(this.lNm.getPageContext().getPageActivity());
        this.bMM.setLayoutParams(new AbsListView.LayoutParams(-1, this.mas));
        this.bMM.setVisibility(4);
        this.lZa.addFooterView(this.bMM);
        this.lZa.setOnTouchListener(this.lNm.bST);
        this.lYW = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bMd);
        if (this.lNm.dnQ()) {
            this.lYY = (ViewStub) this.bMd.findViewById(R.id.manga_view_stub);
            this.lYY.setVisibility(0);
            this.lYX = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.lYX.show();
            this.lYW.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lNm.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.lYW.dsp().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0827a() { // from class: com.baidu.tieba.pb.pb.main.ap.27
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0827a
            public void dmj() {
                if (ap.this.lZa != null) {
                    if (ap.this.lZc != null) {
                        ap.this.lZc.dsa();
                    }
                    ap.this.lZa.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0827a
            public void dmk() {
                ap.this.lNm.cDc();
            }
        }));
        this.lZJ = this.bMd.findViewById(R.id.view_comment_top_line);
        this.lZK = this.bMd.findViewById(R.id.pb_editor_tool_comment);
        this.lZU = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lZV = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lZM = (HeadImageView) this.bMd.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lZM.setVisibility(0);
        this.lZM.setIsRound(true);
        this.lZM.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.lNm.getContext(), R.dimen.L_X01));
        this.lZM.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0401));
        this.lZM.setPlaceHolder(0);
        dqy();
        this.kpu = (TextView) this.bMd.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lZL = (LinearLayout) this.bMd.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lZL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(ap.this.lNm.getActivity(), "pb_huitie"))) {
                    ap.this.lNm.dny();
                    if (ap.this.lNm != null && ap.this.lNm.dmx() != null && ap.this.lNm.dmx().getPbData() != null && ap.this.lNm.dmx().getPbData().dlg() != null && ap.this.lNm.dmx().getPbData().dlg().bnQ() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13701").dR("tid", ap.this.lNm.dmx().doB()).dR("fid", ap.this.lNm.dmx().getPbData().getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", ap.this.lNm.dmx().lVc).dR("fid", ap.this.lNm.dmx().getPbData().getForumId()).ap("obj_locate", 1).dR("uid", ap.this.lNm.dmx().getPbData().dlg().bnQ().getUserId()));
                    }
                }
            }
        });
        this.lZN = (ImageView) this.bMd.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lQg = (MaskView) this.bMd.findViewById(R.id.mask_view);
        this.lZN.setOnClickListener(this.jjj);
        boolean booleanExtra = this.lNm.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lZO = (ImageView) this.bMd.findViewById(R.id.pb_editor_tool_collection);
        this.lZO.setOnClickListener(this.jjj);
        if (booleanExtra) {
            this.lZO.setVisibility(8);
        } else {
            this.lZO.setVisibility(0);
        }
        this.lZP = (ImageView) this.bMd.findViewById(R.id.pb_editor_tool_share);
        this.lZP.setOnClickListener(this.jjj);
        this.lZQ = new com.baidu.tieba.pb.view.d(this.lZP);
        this.lZQ.dvE();
        this.lZR = (TextView) this.bMd.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lZR.setVisibility(0);
        this.lZY = (ViewStub) this.bMd.findViewById(R.id.interview_status_stub);
        this.lZd = new com.baidu.tieba.pb.pb.main.a.a(this.lNm, cVar);
        this.lZf = new com.baidu.tieba.pb.pb.main.a.e(this.lNm, cVar, this.jjj);
        this.lZl = new g(this.lNm, this.lZa);
        this.lZl.H(this.jjj);
        this.lZl.setTbGestureDetector(this.fvK);
        this.lZl.setOnImageClickListener(this.fUw);
        this.lZl.setOnSwitchChangeListener(this.lNm.lSQ);
        this.lOs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            ap.this.lNm.f(sparseArray);
                            return;
                        }
                        ap.this.dL(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        ap.this.lNm.f(sparseArray);
                    } else if (booleanValue3) {
                        ap.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.lZl.U(this.lOs);
        dqD();
        dqE();
        this.lQh = new com.baidu.tieba.pb.pb.main.a.d(this.lNm);
        this.lQh.fvb = 2;
        this.lZe.b(this.lZa);
        this.lZf.b(this.lZa);
        this.lZd.b(this.lZa);
        this.jot = new PbListView(this.lNm.getPageContext().getPageActivity());
        this.fIC = this.jot.getView().findViewById(R.id.pb_more_view);
        if (this.fIC != null) {
            this.fIC.setOnClickListener(this.jjj);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.fIC, R.drawable.pb_foot_more_trans_selector);
        }
        this.jot.setLineVisible();
        this.jot.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.jot.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.lZr = this.bMd.findViewById(R.id.viewstub_progress);
        this.lNm.registerListener(this.maZ);
        this.lRd = new PbFakeFloorModel(this.lNm.getPageContext());
        this.mau = new r(this.lNm.getPageContext(), this.lRd, this.bMd);
        this.mau.V(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.dqs();
            }
        });
        this.mau.a(this.lNm.lSS);
        this.lRd.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ap.31
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                ap.this.lRd.u(postData);
                ap.this.lZl.notifyDataSetChanged();
                ap.this.mau.dnh();
                ap.this.acR.bzD();
                ap.this.vK(false);
            }
        });
        if (this.lNm.dmx() != null && !StringUtils.isNull(this.lNm.dmx().dpk())) {
            this.lNm.showToast(this.lNm.dmx().dpk());
        }
        this.mab = this.bMd.findViewById(R.id.pb_expand_blank_view);
        this.mad = this.bMd.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mad.getLayoutParams();
        if (this.lNm.dmx() != null && this.lNm.dmx().doE()) {
            this.mab.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.mad.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = maf;
            this.mad.setLayoutParams(layoutParams2);
        }
        this.mae = new PbReplyTitleViewHolder(this.lNm.getPageContext(), this.bMd.findViewById(R.id.pb_reply_expand_view));
        this.mae.w(pbFragment.lRL);
        this.mae.lYw.setVisibility(8);
        this.mae.W(this.jjj);
        this.mae.setOnSwitchChangeListener(this.lNm.lSQ);
        this.lNm.registerListener(this.mAccountChangedListener);
        this.lNm.registerListener(this.maW);
        dqz();
        vE(false);
        this.maS = new com.baidu.tieba.pb.view.c(this.lNm.getPageContext());
    }

    private void dqy() {
        if (this.lZM != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lZM.setImageResource(0);
            this.lZM.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.lZM.setImageResource(R.drawable.transparent_bg);
    }

    public void vB(boolean z) {
        this.lZH.setVisibility(z ? 0 : 8);
    }

    public void cSt() {
        if (!this.lNm.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").ap("obj_locate", 2).dR("fid", this.mForumId));
        } else if (this.lNm.dnA()) {
            com.baidu.tbadk.editortools.pb.e dnm = this.lNm.dnm();
            if (dnm != null && (dnm.bCc() || dnm.bCd())) {
                this.lNm.dnm().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.acR != null) {
                dqJ();
            }
            if (this.acR != null) {
                this.lZT = false;
                if (this.acR.qU(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.lNm.getPageContext(), (View) this.acR.qU(2).fBo, false, maT);
                }
            }
            drt();
        }
    }

    private void dqz() {
        this.maI = new com.baidu.tieba.pb.pb.godreply.a(this.lNm, this, (ViewStub) this.bMd.findViewById(R.id.more_god_reply_popup));
        this.maI.C(this.jjj);
        this.maI.U(this.lOs);
        this.maI.setOnImageClickListener(this.fUw);
        this.maI.C(this.jjj);
        this.maI.setTbGestureDetector(this.fvK);
    }

    public com.baidu.tieba.pb.pb.godreply.a dqA() {
        return this.maI;
    }

    public View dqB() {
        return this.mab;
    }

    public void dqC() {
        if (this.lZa != null) {
            this.lZe.c(this.lZa);
            this.lZf.c(this.lZa);
            this.lZg.c(this.lZa);
            this.lZd.c(this.lZa);
        }
    }

    private void dqD() {
        if (this.lZg == null) {
            this.lZg = new com.baidu.tieba.pb.pb.main.a.b(this.lNm, this.jjj);
        }
    }

    private void dqE() {
        if (this.lZe == null) {
            this.lZe = new com.baidu.tieba.pb.pb.main.a.c(this.lNm, this.fvK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqF() {
        if (this.lNm.dnQ()) {
            this.lYZ = (ViewStub) this.bMd.findViewById(R.id.manga_mention_controller_view_stub);
            this.lYZ.setVisibility(0);
            if (this.lZh == null) {
                this.lZh = (LinearLayout) this.bMd.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.lNm.getPageContext(), this.lZh);
            }
            if (this.lZi == null) {
                this.lZi = (TextView) this.lZh.findViewById(R.id.manga_prev_btn);
            }
            if (this.lZj == null) {
                this.lZj = (TextView) this.lZh.findViewById(R.id.manga_next_btn);
            }
            this.lZi.setOnClickListener(this.jjj);
            this.lZj.setOnClickListener(this.jjj);
        }
    }

    private void dqG() {
        if (this.lNm.dnQ()) {
            if (this.lNm.dnT() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lZi, R.color.CAM_X0110, 1);
            }
            if (this.lNm.dnU() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lZj, R.color.CAM_X0110, 1);
            }
        }
    }

    public void dqH() {
        if (this.lZh == null) {
            dqF();
        }
        this.lYZ.setVisibility(8);
        if (this.maX != null && this.maY != null) {
            this.maX.removeCallbacks(this.maY);
        }
    }

    public void dqI() {
        if (this.maX != null) {
            if (this.maY != null) {
                this.maX.removeCallbacks(this.maY);
            }
            this.maY = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ap.this.lZh == null) {
                        ap.this.dqF();
                    }
                    ap.this.lYZ.setVisibility(0);
                }
            };
            this.maX.postDelayed(this.maY, 2000L);
        }
    }

    public void vC(boolean z) {
        this.lYW.vC(z);
        if (z && this.lZX) {
            this.jot.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.lZa.setNextPage(this.jot);
            this.lYV = 2;
        }
        dqy();
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acR = editorTools;
        this.acR.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.dqs();
            }
        });
        this.acR.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.acR.getParent() == null) {
            this.bMd.addView(this.acR, layoutParams);
        }
        this.acR.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.acR.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.ap.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                    if (((com.baidu.tbadk.coreExtra.data.u) aVar.data).bwv() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.u) aVar.data).bwv() == EmotionGroupType.USER_COLLECT) {
                        if (ap.this.mPermissionJudgePolicy == null) {
                            ap.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        ap.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        ap.this.mPermissionJudgePolicy.appendRequestPermission(ap.this.lNm.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ap.this.mPermissionJudgePolicy.startRequestPermission(ap.this.lNm.getBaseFragmentActivity())) {
                            ap.this.lNm.dnm().c((com.baidu.tbadk.coreExtra.data.u) aVar.data);
                            ap.this.lNm.dnm().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dqo();
        this.lNm.dnm().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ap.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ap.this.acR != null && ap.this.acR.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ap.this.maH == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ap.this.acR.getId());
                            ap.this.maH = new com.baidu.tieba.pb.pb.main.emotion.c(ap.this.lNm.getPageContext(), ap.this.bMd, layoutParams2);
                            if (!com.baidu.tbadk.core.util.y.isEmpty(ap.this.maG)) {
                                ap.this.maH.setData(ap.this.maG);
                            }
                            ap.this.maH.c(ap.this.acR);
                        }
                        ap.this.maH.PP(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ap.this.lNm.kWC != null && ap.this.lNm.kWC.drM() != null) {
                    if (!ap.this.lNm.kWC.drM().dWy()) {
                        ap.this.lNm.kWC.vQ(false);
                    }
                    ap.this.lNm.kWC.drM().zu(false);
                }
            }
        });
    }

    public void dqJ() {
        if (this.lNm != null && this.acR != null) {
            this.acR.display();
            if (this.lNm.dnm() != null) {
                this.lNm.dnm().bBS();
            }
            drt();
        }
    }

    public void vD(boolean z) {
        if (this.lZa != null && this.textView != null && this.bLj != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bLj.setVisibility(0);
                } else {
                    this.bLj.setVisibility(8);
                    this.lZa.removeHeaderView(this.textView);
                    this.lZa.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = maf;
                    this.textView.setLayoutParams(layoutParams);
                }
                dra();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + vM(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            dra();
            drB();
        }
    }

    public g dqK() {
        return this.lZl;
    }

    public void a(PbFragment.c cVar) {
        this.lSX = cVar;
    }

    public void dL(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lNm.getContext());
        kVar.setTitleText(this.lNm.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.lZt.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 10:
                            ap.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 11:
                            if (ap.this.mba != null) {
                                ap.this.mba.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 12:
                            ap.this.lNm.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
            if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.lNm.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.lNm.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eVl.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !drA()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(11, this.lNm.getString(R.string.forbidden_person), kVar);
            gVar3.eVl.setTag(sparseArray3);
            arrayList.add(gVar3);
        }
        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            sparseArray4.put(R.id.tag_user_mute_msg, sparseArray.get(R.id.tag_user_mute_msg));
            if (z) {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.lNm.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.lNm.getString(R.string.mute), kVar);
            }
            gVar.eVl.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.k(com.baidu.tieba.pb.pb.main.d.a.fq(arrayList), true);
        this.lZt = new com.baidu.tbadk.core.dialog.i(this.lNm.getPageContext(), kVar);
        this.lZt.QE();
    }

    public void a(PbFragment.b bVar) {
        this.mba = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.lNm != null && aVar != null) {
            if (this.jRi == null && this.lZd != null) {
                this.jRi = new com.baidu.tieba.NEGFeedBack.f(this.lNm.getPageContext(), this.lZd.drW());
            }
            AntiData cBz = this.lNm.cBz();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBz != null && cBz.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBz.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            this.jRi.setDefaultReasonArray(new String[]{this.lNm.getString(R.string.delete_thread_reason_1), this.lNm.getString(R.string.delete_thread_reason_2), this.lNm.getString(R.string.delete_thread_reason_3), this.lNm.getString(R.string.delete_thread_reason_4), this.lNm.getString(R.string.delete_thread_reason_5)});
            this.jRi.setData(avVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jRi.Er(str);
            this.jRi.a(new f.b() { // from class: com.baidu.tieba.pb.pb.main.ap.9
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void W(JSONArray jSONArray) {
                    ap.this.lNm.a(aVar, jSONArray);
                }
            });
        }
    }

    private boolean dqL() {
        if (this.lNm == null || this.lNm.dmx().getPbData().getForum().getDeletedReasonInfo() == null) {
            return false;
        }
        return 1 == this.lNm.dmx().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i, com.baidu.tieba.NEGFeedBack.h hVar, UserData userData) {
        String str;
        if (this.lNm != null && aVar != null) {
            if (this.maM == null && this.lZd != null) {
                this.maM = new com.baidu.tieba.NEGFeedBack.i(this.lNm.getPageContext(), this.lZd.drW(), hVar, userData);
            }
            AntiData cBz = this.lNm.cBz();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBz != null && cBz.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBz.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            this.maM.setDefaultReasonArray(new String[]{this.lNm.getString(R.string.delete_thread_reason_1), this.lNm.getString(R.string.delete_thread_reason_2), this.lNm.getString(R.string.delete_thread_reason_3), this.lNm.getString(R.string.delete_thread_reason_4), this.lNm.getString(R.string.delete_thread_reason_5)});
            this.maM.setData(avVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.maM.Er(str);
            this.maM.a(new i.b() { // from class: com.baidu.tieba.pb.pb.main.ap.10
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void W(JSONArray jSONArray) {
                    ap.this.lNm.a(aVar, jSONArray);
                }
            });
        }
    }

    public void a(int i, String str, int i2, boolean z, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(mam, Integer.valueOf(man));
        int i3 = R.string.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = R.string.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = R.string.report_thread_confirm;
            } else {
                i3 = R.string.del_thread_confirm;
            }
        }
        this.lZu = new com.baidu.tbadk.core.dialog.a(this.lNm.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lZu.nx(i3);
        } else {
            this.lZu.setOnlyMessageShowCenter(false);
            this.lZu.Au(str2);
        }
        this.lZu.setYesButtonTag(sparseArray);
        this.lZu.a(R.string.dialog_ok, this.lNm);
        this.lZu.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lZu.jF(true);
        this.lZu.b(this.lNm.getPageContext());
        if (z) {
            this.lZu.bqx();
        } else if (dqL()) {
            com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(this.lNm.dmx().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.lNm.dmx().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.lNm.dmx().getPbData().dlP().has_forum_rule.intValue());
            hVar.eg(this.lNm.dmx().getPbData().getForum().getId(), this.lNm.dmx().getPbData().getForum().getName());
            hVar.setForumHeadUrl(this.lNm.dmx().getPbData().getForum().getImage_url());
            hVar.setUserLevel(this.lNm.dmx().getPbData().getForum().getUser_level());
            a(this.lZu, i, hVar, this.lNm.dmx().getPbData().getUserData());
        } else {
            a(this.lZu, i);
        }
    }

    public void aZ(ArrayList<com.baidu.tbadk.core.data.al> arrayList) {
        if (this.lZx == null) {
            this.lZx = LayoutInflater.from(this.lNm.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.lNm.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lZx);
        if (this.lZw == null) {
            this.lZw = new Dialog(this.lNm.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lZw.setCanceledOnTouchOutside(true);
            this.lZw.setCancelable(true);
            this.lZF = (ScrollView) this.lZx.findViewById(R.id.good_scroll);
            this.lZw.setContentView(this.lZx);
            WindowManager.LayoutParams attributes = this.lZw.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lZw.getWindow().setAttributes(attributes);
            this.izI = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ap.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ap.this.lZB = (String) compoundButton.getTag();
                        if (ap.this.izH != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : ap.this.izH) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && ap.this.lZB != null && !str.equals(ap.this.lZB)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lZy = (LinearLayout) this.lZx.findViewById(R.id.good_class_group);
            this.lZA = (TextView) this.lZx.findViewById(R.id.dialog_button_cancel);
            this.lZA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ap.this.lZw instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(ap.this.lZw, ap.this.lNm.getPageContext());
                    }
                }
            });
            this.lZz = (TextView) this.lZx.findViewById(R.id.dialog_button_ok);
            this.lZz.setOnClickListener(this.jjj);
        }
        this.lZy.removeAllViews();
        this.izH = new ArrayList();
        CustomBlueCheckRadioButton fU = fU("0", this.lNm.getPageContext().getString(R.string.thread_good_class));
        this.izH.add(fU);
        fU.setChecked(true);
        this.lZy.addView(fU);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.al alVar = arrayList.get(i2);
                if (alVar != null && !TextUtils.isEmpty(alVar.bmb()) && alVar.bmc() > 0) {
                    CustomBlueCheckRadioButton fU2 = fU(String.valueOf(alVar.bmc()), alVar.bmb());
                    this.izH.add(fU2);
                    View view = new View(this.lNm.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ap.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.lZy.addView(view);
                    this.lZy.addView(fU2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lZF.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lNm.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lNm.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lNm.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lZF.setLayoutParams(layoutParams2);
            this.lZF.removeAllViews();
            if (this.lZy != null && this.lZy.getParent() == null) {
                this.lZF.addView(this.lZy);
            }
        }
        com.baidu.adp.lib.f.g.a(this.lZw, this.lNm.getPageContext());
    }

    private CustomBlueCheckRadioButton fU(String str, String str2) {
        Activity pageActivity = this.lNm.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.izI);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void dqM() {
        this.lNm.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.lNm.hideProgressBar();
        if (z && z2) {
            this.lNm.showToast(this.lNm.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.lNm.showToast(str);
        }
    }

    public void dqN() {
        this.lZr.setVisibility(0);
    }

    public void dqO() {
        this.lZr.setVisibility(8);
    }

    public View dqP() {
        if (this.lZx != null) {
            return this.lZx.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String dqQ() {
        return this.lZB;
    }

    public View getView() {
        return this.bMd;
    }

    public void dqR() {
        if (this.lNm != null && this.lNm.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lNm.getPageContext().getPageActivity(), this.lNm.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.lNm.hideProgressBar();
        if (z) {
            drk();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            drl();
        } else {
            drk();
        }
    }

    public void dqS() {
        this.jot.setLineVisible();
        this.jot.startLoadData();
    }

    public void dqT() {
        this.lNm.hideProgressBar();
        endLoadData();
        this.lZa.completePullRefreshPostDelayed(0L);
        drf();
    }

    public void dqU() {
        this.lZa.completePullRefreshPostDelayed(0L);
        drf();
    }

    private void vE(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.lZf.b(onLongClickListener);
        this.lZl.setOnLongClickListener(onLongClickListener);
        if (this.maI != null) {
            this.maI.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0558b interfaceC0558b, boolean z, boolean z2) {
        if (this.lRW != null) {
            this.lRW.dismiss();
            this.lRW = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lNm.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lNm.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lNm.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lNm.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lNm.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.bw(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.lZC.dismiss();
                interfaceC0558b.a(null, i, view);
            }
        });
        this.lZC = new com.baidu.tbadk.core.dialog.i(this.lNm.getPageContext(), kVar);
        this.lZC.QE();
    }

    public void a(final b.InterfaceC0558b interfaceC0558b, boolean z) {
        if (this.lZC != null) {
            this.lZC.dismiss();
            this.lZC = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lNm.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.lOF != null && this.lOF.dlg() != null && !this.lOF.dlg().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lNm.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lNm.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bw(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.16
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.lZC.dismiss();
                interfaceC0558b.a(null, i, view);
            }
        });
        this.lZC = new com.baidu.tbadk.core.dialog.i(this.lNm.getPageContext(), kVar);
        this.lZC.QE();
    }

    public int dqV() {
        return Gb(this.lZa.getFirstVisiblePosition());
    }

    private int Gb(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.lZa.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.lZa.getAdapter() == null || !(this.lZa.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.lZa.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int dqW() {
        int lastVisiblePosition = this.lZa.getLastVisiblePosition();
        if (this.lZc != null) {
            if (lastVisiblePosition == this.lZa.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return Gb(lastVisiblePosition);
    }

    public void Gc(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.lZa != null) {
            if (this.lYW == null || this.lYW.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.lYW.mNavigationBar.getFixedNavHeight();
                if (this.lNm.dnG() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.mad != null && (layoutParams = (LinearLayout.LayoutParams) this.mad.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.mad.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.lZa.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.lZa.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.lZa.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.lZo.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.lZl.a(fVar, false);
        this.lZl.notifyDataSetChanged();
        drf();
        if (this.maI != null) {
            this.maI.bPa();
        }
        ArrayList<PostData> dli = fVar.dli();
        if (fVar.getPage().bmF() == 0 || dli == null || dli.size() < fVar.getPage().bmE()) {
            if (com.baidu.tbadk.core.util.y.getCount(dli) == 0 || (com.baidu.tbadk.core.util.y.getCount(dli) == 1 && dli.get(0) != null && dli.get(0).dNF() == 1)) {
                if (this.mai == null || this.mai.mbs == null || this.mai.mbs.getView() == null) {
                    i = 0;
                } else {
                    i = this.mai.mbs.getView().getTop() < 0 ? this.mai.mbs.getView().getHeight() : this.mai.mbs.getView().getBottom();
                }
                if (this.lNm.doa()) {
                    this.jot.at(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.jot.at(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().bmF() == 0) {
                    this.jot.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.jot.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.jot.bue();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.lZd != null) {
            this.lZd.e(fVar, this.lOk);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dlt() != null) {
            return fVar.dlt();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dli())) {
            Iterator<PostData> it = fVar.dli().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dNF() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dlp();
        }
        if (!r(postData)) {
            postData = a(fVar);
        }
        if (postData != null && postData.bnQ() != null && postData.bnQ().getUserTbVipInfoData() != null && postData.bnQ().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bnQ().getGodUserData().setIntro(postData.bnQ().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean r(PostData postData) {
        if (postData == null || postData.bnQ() == null) {
            return false;
        }
        MetaData bnQ = postData.bnQ();
        return (TextUtils.isEmpty(bnQ.getUserId()) && TextUtils.isEmpty(bnQ.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dlg() == null || fVar.dlg().bnQ() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bnQ = fVar.dlg().bnQ();
        String userId = bnQ.getUserId();
        HashMap<String, MetaData> userMap = fVar.dlg().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bnQ;
        }
        postData.JE(1);
        postData.setId(fVar.dlg().bog());
        postData.setTitle(fVar.dlg().getTitle());
        postData.setTime(fVar.dlg().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.dlg() != null) {
            if (this.lNm.dmp()) {
                if (fVar.dlf() != null) {
                    this.mForumName = fVar.dlf().getForumName();
                    this.mForumId = fVar.dlf().getForumId();
                }
                if (this.mForumName == null && this.lNm.dmx() != null && this.lNm.dmx().dmq() != null) {
                    this.mForumName = this.lNm.dmx().dmq();
                }
            }
            PostData b2 = b(fVar, z);
            a(b2, fVar);
            this.lZf.setVisibility(8);
            if (fVar.dlG()) {
                this.maz = true;
                this.lYW.wc(true);
                this.lYW.mNavigationBar.hideBottomLine();
                if (this.lZc == null) {
                    this.lZc = new com.baidu.tieba.pb.pb.main.a.f(this.lNm);
                }
                this.lZc.a(fVar, b2, this.lZa, this.lZf, this.maa, this.lYW, this.mForumName, this.maO);
                this.lZc.X(this.mbc);
                dra();
            } else {
                this.maz = false;
                this.lYW.wc(this.maz);
                if (this.lZc != null) {
                    this.lZc.c(this.lZa);
                }
            }
            if (this.lNm.dnp() != null) {
                this.lNm.dnp().vW(this.maz);
            }
            if (b2 != null) {
                this.lZW = b2;
                this.lZf.setVisibility(0);
                SparseArray<Object> drZ = this.lZf.drZ();
                drZ.put(R.id.tag_clip_board, b2);
                drZ.put(R.id.tag_is_subpb, false);
                this.lZg.a(fVar, this.lZa);
                this.lZe.C(fVar);
                this.lZd.e(fVar, this.lOk);
                this.lZd.B(fVar);
                this.lZf.a(this.mSkinType, this.lOF, b2, this.mbc);
                if (this.mae != null) {
                    if (fVar.dlJ()) {
                        this.mae.getView().setVisibility(8);
                    } else {
                        this.mae.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.o oVar = new com.baidu.tieba.pb.data.o(com.baidu.tieba.pb.data.o.lLF);
                        if (fVar.dlg() != null) {
                            oVar.lLH = fVar.dlg().bnH();
                        }
                        oVar.isNew = !this.lOk;
                        oVar.sortType = fVar.lKn;
                        oVar.lLJ = fVar.dlK();
                        oVar.lLK = this.lNm.doa();
                        oVar.lLL = fVar.lKm;
                        this.mae.a(oVar);
                    }
                }
                z(fVar);
                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ap.this.lZl != null && ap.this.lYW != null && ap.this.lYW.mfE != null && ap.this.lOF != null && ap.this.lOF.dlg() != null && !ap.this.lOF.dlg().bmv() && !ap.this.dre() && ap.this.lOF.getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(ap.this.lOF.getForum().getName())) {
                            if ((ap.this.lZl.dnb() == null || !ap.this.lZl.dnb().isShown()) && ap.this.lYW.mfE != null) {
                                ap.this.lYW.mfE.setVisibility(0);
                                if (ap.this.lNm != null && ap.this.lNm.dmx() != null) {
                                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13400");
                                    arVar.dR("tid", ap.this.lNm.dmx().doA());
                                    arVar.dR("fid", ap.this.lNm.dmx().getForumId());
                                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(arVar);
                                }
                            }
                        }
                    }
                });
                this.lQh.c(this.lZa);
                if (b2.nxK) {
                    this.lQh.setPostId(b2.getId());
                    this.lQh.a(this.lZa, this.lZa.getHeaderViewsCount() > 1 ? 1 : 0);
                }
                if (this.lZl != null && this.lZl.dna() != null) {
                    this.lZl.dna().vS(b2.nxK);
                }
                if (this.lZl != null) {
                    this.lZl.uT(b2.nxK);
                }
                this.lQg.setVisibility(b2.nxK ? 0 : 8);
            }
        }
    }

    public void vF(boolean z) {
        if (z) {
            dqX();
        } else {
            cwz();
        }
        this.mai.mbs = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.mai));
        a(this.mai.mbs, false);
    }

    public void dqX() {
        if (this.lYW != null && !this.maB) {
            this.lYW.dqX();
            this.maB = true;
        }
    }

    public void cwz() {
        if (this.lYW != null) {
            this.lYW.dsy();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.lZf.a(postData, fVar);
    }

    public void dqY() {
        if (this.lZc != null) {
            this.lZc.d(this.lZa);
        }
    }

    public boolean dqZ() {
        return this.bje;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aO(cb cbVar) {
        if (cbVar == null || cbVar.bnQ() == null) {
            return false;
        }
        PostData b2 = b(this.lOF, false);
        String str = "";
        if (b2 != null && b2.bnQ() != null) {
            str = b2.bnQ().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.lYW.dsv();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.lYW.KG(dVar.forumName);
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.f.b.toInt(dVar.source, 0)) {
                case 100:
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.self);
                    break;
                case 300:
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.bawu);
                    break;
                case 400:
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = dVar.lKe;
            this.lNm.showNetRefreshView(this.bMd, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        bf.bsV().b(ap.this.lNm.getPageContext(), new String[]{str2});
                        ap.this.lNm.finish();
                        return;
                    }
                    ap.this.lNm.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable dqa;
        Parcelable dqa2;
        if (fVar != null && this.lZa != null) {
            this.lOF = fVar;
            this.mType = i;
            if (fVar.dlg() != null) {
                this.mak = fVar.dlg().bnx();
                if (fVar.dlg().getAnchorLevel() != 0) {
                    this.bje = true;
                }
                this.lZE = aO(fVar.dlg());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.lZX = false;
            this.lOk = z;
            dqT();
            if (fVar.lKo != null && fVar.lKo.dlR()) {
                if (this.lZb == null) {
                    this.lZb = new PbThreadPostView(this.lNm.getContext());
                    this.lZa.addHeaderView(this.lZb, 1);
                    this.lZb.setData(fVar);
                    this.lZb.setChildOnClickLinstener(this.jjj);
                }
            } else if (this.lZb != null && this.lZa != null) {
                this.lZa.removeHeaderView(this.lZb);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.maL == null) {
                this.maL = new ae(this.lNm.getPageContext(), this.jMu);
            }
            this.maL.PF(fVar.dln());
            if (this.lNm.dnQ()) {
                if (this.lZp == null) {
                    this.lZp = new com.baidu.tieba.pb.view.e(this.lNm.getPageContext());
                    this.lZp.createView();
                    this.lZp.setListPullRefreshListener(this.fjz);
                }
                this.lZa.setPullRefresh(this.lZp);
                dra();
                if (this.lZp != null) {
                    this.lZp.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().bmG() == 0 && z) {
                this.lZa.setPullRefresh(null);
            } else {
                if (this.lZp == null) {
                    this.lZp = new com.baidu.tieba.pb.view.e(this.lNm.getPageContext());
                    this.lZp.createView();
                    this.lZp.setListPullRefreshListener(this.fjz);
                }
                this.lZa.setPullRefresh(this.lZp);
                dra();
                if (this.lZp != null) {
                    this.lZp.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                ckx();
            }
            drf();
            this.lZl.uK(this.lOk);
            this.lZl.uL(false);
            this.lZl.uP(i == 5);
            this.lZl.uQ(i == 6);
            this.lZl.uR(z2 && this.mbb && i != 2);
            this.lZl.a(fVar, false);
            this.lZl.notifyDataSetChanged();
            this.lZf.b(b(fVar, z), fVar.dlJ());
            if (fVar.dlg() != null && fVar.dlg().bnB() != null && this.lYU != -1) {
                fVar.dlg().bnB().setIsLike(this.lYU);
            }
            this.lZa.removeFooterView(this.bMM);
            this.lZa.addFooterView(this.bMM);
            if (TbadkCoreApplication.isLogin()) {
                this.lZa.setNextPage(this.jot);
                this.lYV = 2;
                ckx();
            } else {
                this.lZX = true;
                if (fVar.getPage().bmF() == 1) {
                    if (this.lZq == null) {
                        this.lZq = new com.baidu.tieba.pb.view.a(this.lNm, this.lNm);
                    }
                    this.lZa.setNextPage(this.lZq);
                } else {
                    this.lZa.setNextPage(this.jot);
                }
                this.lYV = 3;
            }
            ArrayList<PostData> dli = fVar.dli();
            if (fVar.getPage().bmF() == 0 || dli == null || dli.size() < fVar.getPage().bmE()) {
                if (com.baidu.tbadk.core.util.y.getCount(dli) == 0 || (com.baidu.tbadk.core.util.y.getCount(dli) == 1 && dli.get(0) != null && dli.get(0).dNF() == 1)) {
                    if (this.mai == null || this.mai.mbs == null || this.mai.mbs.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.mai.mbs.getView().getTop() < 0 ? this.mai.mbs.getView().getHeight() : this.mai.mbs.getView().getBottom();
                    }
                    if (this.lNm.doa()) {
                        this.jot.at(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.jot.at(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.lNm.dnp() != null && !this.lNm.dnp().dsj()) {
                        this.lNm.dnp().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().bmF() == 0) {
                        this.jot.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jot.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jot.bue();
                }
                if (fVar.getPage().bmF() == 0 || dli == null) {
                    drp();
                }
            } else {
                if (z2) {
                    if (this.mbb) {
                        endLoadData();
                        if (fVar.getPage().bmF() != 0) {
                            this.jot.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.jot.setLineVisible();
                        this.jot.showLoading();
                    }
                } else {
                    this.jot.setLineVisible();
                    this.jot.showLoading();
                }
                this.jot.bue();
            }
            switch (i) {
                case 2:
                    this.lZa.setSelection(i2 > 1 ? (((this.lZa.getData() == null && fVar.dli() == null) ? 0 : (this.lZa.getData().size() - fVar.dli().size()) + this.lZa.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (dqa2 = aj.dpZ().dqa()) != null && !(dqa2 instanceof RecyclerView.SavedState)) {
                        this.lZa.onRestoreInstanceState(dqa2);
                        if (com.baidu.tbadk.core.util.y.getCount(dli) > 1 && fVar.getPage().bmF() > 0) {
                            this.jot.endLoadData();
                            this.jot.setText(this.lNm.getString(R.string.pb_load_more_without_point));
                            this.jot.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.mbb = false;
                    break;
                case 5:
                    this.lZa.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (dqa = aj.dpZ().dqa()) != null && !(dqa instanceof RecyclerView.SavedState)) {
                        this.lZa.onRestoreInstanceState(dqa);
                        break;
                    } else {
                        this.lZa.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.lZc != null && this.lZc.getContainerView() != null) {
                            if (this.lNm.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.lZa.setSelectionFromTop((this.lZl.dmW() + this.lZa.getHeaderViewsCount()) - 1, this.lZc.dsb() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.lNm.getPageContext().getPageActivity()));
                            } else {
                                this.lZa.setSelectionFromTop((this.lZl.dmW() + this.lZa.getHeaderViewsCount()) - 1, this.lZc.dsb());
                            }
                        } else {
                            this.lZa.setSelection(this.lZl.dmW() + this.lZa.getHeaderViewsCount());
                        }
                    } else {
                        this.lZa.setSelection(i2 > 0 ? ((this.lZa.getData() == null && fVar.dli() == null) ? 0 : (this.lZa.getData().size() - fVar.dli().size()) + this.lZa.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.jot.endLoadData();
                    this.jot.setText(this.lNm.getString(R.string.pb_load_more_without_point));
                    this.jot.setLineGone();
                    break;
            }
            if (this.mak == mal && isHost()) {
                drw();
            }
            if (this.maw) {
                dqm();
                this.maw = false;
                if (i3 == 0) {
                    vy(true);
                }
            }
            if (fVar.lKk == 1 || fVar.lKl == 1) {
                if (this.maD == null) {
                    this.maD = new PbTopTipView(this.lNm.getContext());
                }
                if (fVar.lKl == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.lNm.getStType())) {
                    this.maD.setText(this.lNm.getString(R.string.pb_read_strategy_add_experience));
                    this.maD.a(this.bMd, this.mSkinType);
                } else if (fVar.lKk == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.lNm.getStType())) {
                    this.maD.setText(this.lNm.getString(R.string.pb_read_news_add_experience));
                    this.maD.a(this.bMd, this.mSkinType);
                }
            }
            this.lZa.removeFooterView(this.maS.getView());
            if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dlO()) && fVar.getPage().bmF() == 0) {
                this.lZa.removeFooterView(this.bMM);
                this.maS.GB(Math.max(this.lZK.getMeasuredHeight(), this.lZV / 2));
                this.lZa.addFooterView(this.maS.getView());
                this.maS.H(fVar);
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlg() != null) {
            x(fVar);
            if (fVar.bjZ()) {
                WebPManager.a(this.lZO, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lZO, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String Gd = Gd(fVar.dlg().bnH());
            if (this.lZR != null) {
                this.lZR.setText(Gd);
            }
            if (this.lZS != null) {
                this.lZS.setText(Gd);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dlg()));
        }
    }

    private String Gd(int i) {
        if (i == 0) {
            return this.lNm.getString(R.string.pb_comment_red_dot_no_reply);
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (i > 9990000) {
            return "· · ·";
        }
        if (i >= 1000000) {
            numberFormat.setMaximumFractionDigits(0);
            return numberFormat.format(i / 10000.0f) + "W";
        } else if (i >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i / 10000.0f) + "W";
        } else {
            return "" + i;
        }
    }

    private void dra() {
        if (this.lZc != null) {
            this.lZc.a(this.lZa, this.textView, this.mType);
        }
    }

    public void vG(boolean z) {
        this.lZD = z;
    }

    public void endLoadData() {
        if (this.jot != null) {
            this.jot.setLineGone();
            this.jot.endLoadData();
        }
        ckx();
    }

    public void bYo() {
        this.lZa.setVisibility(0);
    }

    public void drb() {
        if (this.lZa != null) {
            this.lZa.setVisibility(8);
        }
        if (this.lZa != null) {
            this.maa.setVisibility(8);
        }
        if (this.lYW != null && this.lYW.jxc != null) {
            this.lYW.jxc.setVisibility(8);
        }
    }

    public void drc() {
        if (this.lZa != null) {
            this.lZa.setVisibility(0);
        }
        if (this.maa != null) {
            this.maa.setVisibility(0);
        }
        if (this.lYW != null && this.lYW.jxc != null) {
            this.lYW.jxc.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.lZW != null && this.lZW.bnQ() != null && this.lYW != null) {
            this.maA = !this.maz;
            this.lYW.vY(this.maA);
            if (this.lNm.dnp() != null) {
                this.lNm.dnp().vX(this.maA);
            }
            drd();
            if (this.lNm != null && !this.lNm.dmp() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dlD())) {
                bx bxVar = fVar.dlD().get(0);
                if (bxVar != null) {
                    this.lYW.fV(bxVar.getForumName(), bxVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.lYW.fV(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.maA) {
                this.lZf.a(fVar, this.lZW, this.lZE);
                if (this.mad != null) {
                    this.mad.setVisibility(8);
                }
                if (this.maJ == null) {
                    this.maJ = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ap.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (ap.this.lNm != null && ap.this.lNm.isAdded()) {
                                if (i < 0 && f > ap.this.maC) {
                                    ap.this.drk();
                                    ap.this.drv();
                                }
                                ap.this.dqU();
                            }
                        }
                    };
                }
                this.lZa.setListViewDragListener(this.maJ);
                return;
            }
            if (this.mad != null) {
                this.mad.setVisibility(0);
            }
            this.lZf.a(fVar, this.lZW, this.lZE);
            this.maJ = null;
            this.lZa.setListViewDragListener(null);
        }
    }

    private void drd() {
        this.lZf.a(this.lOF, this.lZW, this.maA, this.maz);
    }

    public boolean dre() {
        return this.lOF == null || this.lOF.getForum() == null || "0".equals(this.lOF.getForum().getId()) || "me0407".equals(this.lOF.getForum().getName());
    }

    private boolean drf() {
        return this.lZd.vT(this.lOk);
    }

    private boolean w(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dlg() == null) {
            return false;
        }
        if (fVar.dlg().bnN() == 1 || fVar.dlg().getThreadType() == 33) {
            return true;
        }
        return !(fVar.dlg().bnP() == null || fVar.dlg().bnP().bqj() == 0) || fVar.dlg().bnL() == 1 || fVar.dlg().bnM() == 1 || fVar.dlg().boD() || fVar.dlg().boZ() || fVar.dlg().boS() || fVar.dlg().bob() != null || !com.baidu.tbadk.core.util.au.isEmpty(fVar.dlg().getCategory()) || fVar.dlg().bnT() || fVar.dlg().bnS();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.lZe != null) {
                if (fVar.dlg() != null && fVar.dlg().boe() == 0 && !fVar.dlg().bmv() && !this.maU) {
                    if (fVar.dlg() != null) {
                        cb dlg = fVar.dlg();
                        dlg.y(true, w(fVar));
                        dlg.nj(3);
                        dlg.Ah("2");
                    }
                    if (fVar.dlg().bmx()) {
                        this.lZf.c(this.lZa);
                        this.lZe.c(this.lZa);
                        this.lZe.b(this.lZa);
                        this.lZf.b(this.lZa);
                        this.lZf.G(this.lOF);
                        if (A(fVar)) {
                            this.lZe.c(this.lZa);
                        } else {
                            this.lZe.D(fVar);
                        }
                    } else {
                        this.lZf.G(this.lOF);
                        if (A(fVar)) {
                            this.lZe.c(this.lZa);
                        } else {
                            this.lZe.F(fVar);
                        }
                    }
                } else if (fVar.dlg().boe() == 1) {
                    if (fVar.dlg() != null) {
                        this.lZe.c(this.lZa);
                        this.lZf.G(this.lOF);
                    }
                } else {
                    this.lZe.c(this.lZa);
                    this.lZf.G(this.lOF);
                }
            }
            z(fVar);
            this.lOk = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            drf();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b2;
        com.baidu.tbadk.core.data.ad adVar;
        StringBuilder sb = null;
        if (fVar != null && (b2 = b(fVar, z)) != null) {
            String userId = b2.bnQ().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b2.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dlv()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b2.bnQ() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b2.bnQ().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b2.bnQ().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b2.bnQ().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b2.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b2.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dlv()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bx> dlD = fVar.dlD();
                if (com.baidu.tbadk.core.util.y.getCount(dlD) > 0) {
                    sb = new StringBuilder();
                    for (bx bxVar : dlD) {
                        if (bxVar != null && !StringUtils.isNull(bxVar.getForumName()) && (adVar = bxVar.ePM) != null && adVar.eNw && !adVar.eNx && (adVar.type == 1 || adVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bxVar.getForumName(), 12)).append(this.lNm.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.lNm.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View drg() {
        return this.fIC;
    }

    public boolean drh() {
        if (this.bMM == null || this.bMM.getParent() == null || this.jot.isLoading()) {
            return false;
        }
        int bottom = this.bMM.getBottom();
        Rect rect = new Rect();
        this.bMM.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void PH(String str) {
        if (this.jot != null) {
            this.jot.setText(str);
        }
    }

    public void PI(String str) {
        if (this.jot != null) {
            int i = 0;
            if (this.mai != null && this.mai.mbs != null && this.mai.mbs.getView() != null) {
                i = this.mai.mbs.getView().getTop() < 0 ? this.mai.mbs.getView().getHeight() : this.mai.mbs.getView().getBottom();
            }
            this.jot.at(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.lZa;
    }

    public int dri() {
        return R.id.richText;
    }

    public TextView dmH() {
        return this.lZf.dmH();
    }

    public void d(BdListView.e eVar) {
        this.lZa.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.fjz = cVar;
        if (this.lZp != null) {
            this.lZp.setListPullRefreshListener(cVar);
        }
    }

    public void a(az azVar, a.b bVar) {
        if (azVar != null) {
            int bmD = azVar.bmD();
            int bmA = azVar.bmA();
            if (this.lZm != null) {
                this.lZm.bqx();
            } else {
                this.lZm = new com.baidu.tbadk.core.dialog.a(this.lNm.getPageContext().getPageActivity());
                this.lZn = LayoutInflater.from(this.lNm.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.lZm.bn(this.lZn);
                this.lZm.a(R.string.dialog_ok, bVar);
                this.lZm.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ap.this.drk();
                        aVar.dismiss();
                    }
                });
                this.lZm.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ap.23
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ap.this.mat == null) {
                            ap.this.mat = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.23.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ap.this.lNm.HidenSoftKeyPad((InputMethodManager) ap.this.lNm.getBaseFragmentActivity().getSystemService("input_method"), ap.this.bMd);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.mA().postDelayed(ap.this.mat, 150L);
                    }
                });
                this.lZm.b(this.lNm.getPageContext()).bqx();
            }
            this.lZo = (EditText) this.lZn.findViewById(R.id.input_page_number);
            this.lZo.setText("");
            TextView textView = (TextView) this.lZn.findViewById(R.id.current_page_number);
            if (bmD <= 0) {
                bmD = 1;
            }
            if (bmA <= 0) {
                bmA = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(bmD), Integer.valueOf(bmA)));
            this.lNm.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.lZo, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.lZa.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.lNm.showToast(str);
    }

    public boolean vH(boolean z) {
        if (this.acR == null || !this.acR.bBl()) {
            return false;
        }
        this.acR.bzD();
        return true;
    }

    public void drj() {
        if (this.mbd != null) {
            while (this.mbd.size() > 0) {
                TbImageView remove = this.mbd.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        drj();
        this.lZl.FB(1);
        if (this.lZc != null) {
            this.lZc.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.lZl.FB(2);
        if (this.lZc != null) {
            this.lZc.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.lNm.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lNm.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.lZQ != null) {
            this.lZQ.onDestroy();
        }
        if (this.mav != null) {
            this.mav.destroy();
        }
        if (this.maL != null) {
            this.maL.onDestory();
        }
        if (this.maD != null) {
            this.maD.hide();
        }
        this.lNm.hideProgressBar();
        if (this.gyk != null && this.jdH != null) {
            this.gyk.b(this.jdH);
        }
        drk();
        endLoadData();
        if (this.mat != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mat);
        }
        if (this.lZZ != null) {
            this.lZZ.clearStatus();
        }
        this.maX = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.lZl.FB(3);
        if (this.bLj != null) {
            this.bLj.setBackgroundDrawable(null);
        }
        if (this.lZc != null) {
            this.lZc.destroy();
        }
        if (this.lZl != null) {
            this.lZl.onDestroy();
        }
        this.lZa.setOnLayoutListener(null);
        if (this.maH != null) {
            this.maH.cFE();
        }
        if (this.maj != null) {
            this.maj.onDestroy();
        }
        if (this.lZf != null) {
            this.lZf.onDestroy();
        }
    }

    public boolean Ge(int i) {
        if (this.lZc != null) {
            return this.lZc.Ge(i);
        }
        return false;
    }

    public void drk() {
        this.lYW.baM();
        if (this.lZf != null) {
            this.lZf.drk();
        }
        if (this.lNm != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lNm.getContext(), this.lZo);
        }
        dqo();
        if (this.lRW != null) {
            this.lRW.dismiss();
        }
        drm();
        if (this.lZm != null) {
            this.lZm.dismiss();
        }
        if (this.jji != null) {
            this.jji.dismiss();
        }
    }

    public void drl() {
        this.lYW.baM();
        if (this.lZf != null) {
            this.lZf.drk();
        }
        if (this.lRW != null) {
            this.lRW.dismiss();
        }
        drm();
        if (this.lZm != null) {
            this.lZm.dismiss();
        }
        if (this.jji != null) {
            this.jji.dismiss();
        }
    }

    public void fn(List<String> list) {
        this.maG = list;
        if (this.maH != null) {
            this.maH.setData(list);
        }
    }

    public void uJ(boolean z) {
        this.lZl.uJ(z);
    }

    public void vI(boolean z) {
        this.lZG = z;
    }

    public void drm() {
        if (this.lZu != null) {
            this.lZu.dismiss();
        }
        if (this.lZv != null) {
            com.baidu.adp.lib.f.g.b(this.lZv, this.lNm.getPageContext());
        }
        if (this.lZw != null) {
            com.baidu.adp.lib.f.g.b(this.lZw, this.lNm.getPageContext());
        }
        if (this.lZt != null) {
            this.lZt.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            d(this.lOF, this.lOk);
            b(this.lOF, this.lOk, this.mType, i);
            this.lNm.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.lNm.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bMd);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bMd, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lZH, R.color.CAM_X0203);
            if (this.lZc != null) {
                this.lZc.onChangeSkinType(i);
            }
            if (this.lZg != null) {
                this.lZg.onChangeSkinType(i);
            }
            if (this.lZd != null) {
                this.lZd.onChangeSkinType(i);
            }
            if (this.lZe != null) {
                this.lZe.onChangeSkinType(i);
            }
            if (this.lZf != null) {
                this.lZf.onChangeSkinType(i);
            }
            if (this.lQh != null) {
                this.lQh.onChangeSkinType();
            }
            if (this.lQg != null) {
                this.lQg.bzn();
            }
            if (this.jot != null) {
                this.jot.changeSkin(i);
            }
            if (this.fIC != null) {
                this.lNm.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fIC);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.fIC, R.drawable.pb_foot_more_trans_selector);
            }
            if (this.lZm != null) {
                this.lZm.c(this.lNm.getPageContext());
            }
            vG(this.lZD);
            this.lZl.notifyDataSetChanged();
            if (this.lZp != null) {
                this.lZp.changeSkin(i);
            }
            if (this.acR != null) {
                this.acR.onChangeSkinType(i);
            }
            if (this.lZq != null) {
                this.lZq.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.izH)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.izH) {
                    customBlueCheckRadioButton.btO();
                }
            }
            dqG();
            UtilHelper.setStatusBarBackground(this.bLj, i);
            UtilHelper.setStatusBarBackground(this.mad, i);
            if (this.lZh != null) {
                com.baidu.tbadk.r.a.a(this.lNm.getPageContext(), this.lZh);
            }
            if (this.mau != null) {
                this.mau.onChangeSkinType(i);
            }
            if (this.lYW != null) {
                if (this.lZc != null) {
                    this.lZc.Gf(i);
                } else {
                    this.lYW.onChangeSkinType(i);
                }
            }
            if (this.lZM != null) {
                this.lZM.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0401));
            }
            if (this.lZL != null) {
                this.lZL.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aL(com.baidu.adp.lib.util.l.getDimens(this.lNm.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0209)));
            }
            if (this.lOF != null && this.lOF.bjZ()) {
                WebPManager.a(this.lZO, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lZO, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.a(this.lZN, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            x(this.lOF);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lZK, R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lZJ, R.color.CAM_X0203);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.maF, R.color.cp_cont_n);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kpu, R.color.CAM_X0109);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lZS, R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lZR, R.color.CAM_X0107);
            com.baidu.tbadk.core.util.ap.d(this.lZR, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (this.maI != null) {
                this.maI.onChangeSkinType(i);
            }
            if (this.maj != null) {
                this.maj.onChangeSkinType();
            }
            if (this.lZb != null) {
                this.lZb.uu(i);
            }
            if (this.lZQ != null) {
                this.lZQ.onChangeSkinType();
            }
            if (this.maS != null) {
                this.maS.onChangeSkinType();
            }
        }
    }

    public void drn() {
        if (this.lZQ != null) {
            this.lZQ.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bd(fVar.dlg())) {
            if (this.lZQ != null) {
                this.lZQ.setEnable(false);
                this.lZQ.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.lZP.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.lZP.setLayoutParams(layoutParams);
            WebPManager.a(this.lZP, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.lZQ == null || !this.lZQ.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.lZP.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.lZP.setLayoutParams(layoutParams2);
            WebPManager.a(this.lZP, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fUw = iVar;
        this.lZl.setOnImageClickListener(this.fUw);
        this.maI.setOnImageClickListener(this.fUw);
    }

    public void g(NoNetworkView.a aVar) {
        this.jdH = aVar;
        if (this.gyk != null) {
            this.gyk.a(this.jdH);
        }
    }

    public void vJ(boolean z) {
        this.lZl.setIsFromCDN(z);
    }

    public Button dro() {
        return this.lZI;
    }

    public void drp() {
        if (this.lYV != 2) {
            this.lZa.setNextPage(this.jot);
            this.lYV = 2;
        }
    }

    public boolean drq() {
        return this.acR != null && this.acR.getVisibility() == 0;
    }

    public boolean drr() {
        return this.acR != null && this.acR.bBl();
    }

    public void drs() {
        if (this.acR != null) {
            this.acR.bzD();
        }
    }

    public void vK(boolean z) {
        if (this.lZK != null) {
            vI(this.lNm.dnm().bBV());
            if (this.lZG) {
                vz(z);
            } else {
                vA(z);
            }
        }
    }

    public void drt() {
        if (this.lZK != null) {
            this.lZJ.setVisibility(8);
            this.lZK.setVisibility(8);
            this.lZT = false;
            if (this.maj != null) {
                this.maj.setVisibility(8);
                vE(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.iDU == null) {
            this.iDU = new com.baidu.tbadk.core.view.a(this.lNm.getPageContext());
        }
        this.iDU.setDialogVisiable(true);
    }

    public void ckx() {
        if (this.iDU != null) {
            this.iDU.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.lZa.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.lZa.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lZc != null) {
            this.lZc.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.mLastScrollY = getScrollY();
            this.mai.mbs = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.mai));
            a(this.mai.mbs, true);
            drI();
        }
    }

    public void vL(boolean z) {
        if (this.lZc != null) {
            this.lZc.vL(z);
        }
    }

    private boolean b(AbsListView absListView, int i) {
        boolean z = true;
        if (absListView == null) {
            return false;
        }
        boolean z2 = i > 0;
        if (z2 || absListView.getChildCount() <= 0) {
            z = z2;
        } else if (absListView.getChildAt(0).getTop() >= absListView.getListPaddingTop()) {
            z = false;
        }
        return z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int i4 = 0;
        if (this.lZc != null) {
            this.lZc.onScroll(absListView, i, i2, i3);
        }
        if (this.lYW != null && this.lZf != null) {
            this.lYW.dN(this.lZf.drX());
        }
        this.mai.lDo = i;
        this.mai.headerCount = this.lZa.getHeaderViewsCount();
        this.mai.mbs = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.mai));
        vB(b(absListView, i));
        a(this.mai.mbs, false);
        drI();
        if (this.jot.buf() && !this.jot.fiy) {
            if (this.mai != null && this.mai.mbs != null && this.mai.mbs.getView() != null) {
                i4 = this.mai.mbs.getView().getTop() < 0 ? this.mai.mbs.getView().getHeight() : this.mai.mbs.getView().getBottom();
            }
            this.jot.pD(i4);
            this.jot.fiy = true;
        }
    }

    public void dru() {
        if (TbadkCoreApplication.isLogin() && this.lOF != null && this.maA && !this.maz && !this.lZE && this.lZW != null && this.lZW.bnQ() != null && !this.lZW.bnQ().getIsLike() && !this.lZW.bnQ().hadConcerned() && this.mav == null) {
            this.mav = new al(this.lNm);
        }
    }

    public void drv() {
        if (this.lNm != null) {
            if ((this.jgj || this.maP == 17) && com.baidu.tbadk.a.d.bjb()) {
                if (this.lOF != null && this.lOF.getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(this.lOF.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.lNm.getContext()).createNormalCfg(this.lOF.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13853").dR("post_id", this.lOF.getThreadId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", this.lOF.getForum().getId()));
                }
            } else if (this.maA && !this.maz && this.lZW != null && this.lZW.bnQ() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12601").ap("obj_locate", this.lNm.dmp() ? 2 : 1).ap("obj_type", this.maz ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.lNm.getPageContext().getPageActivity(), this.lZW.bnQ().getUserId(), this.lZW.bnQ().getUserName(), this.lNm.dmx().dmq(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z) {
        int measuredHeight;
        if (!this.maz && this.mab != null && this.lYW.dsp() != null) {
            int dmX = this.lZl.dmX();
            if (dmX > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                if (dmX > this.lZa.getFirstVisiblePosition() - this.lZa.getHeaderViewsCount()) {
                    this.mab.setVisibility(4);
                    return;
                }
                this.mab.setVisibility(0);
                vB(false);
                this.lYW.mNavigationBar.hideBottomLine();
                if (this.mab.getParent() != null && ((ViewGroup) this.mab.getParent()).getHeight() <= this.mab.getTop()) {
                    this.mab.getParent().requestLayout();
                }
            } else if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView() == null || pbReplyTitleViewHolder.lYw == null) {
                if (this.lZa.getFirstVisiblePosition() == 0) {
                    this.mab.setVisibility(4);
                    this.lYW.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = pbReplyTitleViewHolder.getView().getTop();
                if (pbReplyTitleViewHolder.getView().getParent() != null) {
                    if (this.mah) {
                        this.mag = top;
                        this.mah = false;
                    }
                    this.mag = top < this.mag ? top : this.mag;
                }
                if (top != 0 || pbReplyTitleViewHolder.getView().isShown()) {
                    if (this.lZk.getY() < 0.0f) {
                        measuredHeight = maf - pbReplyTitleViewHolder.lYw.getMeasuredHeight();
                    } else {
                        measuredHeight = this.lYW.dsp().getMeasuredHeight() - pbReplyTitleViewHolder.lYw.getMeasuredHeight();
                        this.lYW.mNavigationBar.hideBottomLine();
                    }
                    if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.mag) {
                        this.mab.setVisibility(0);
                        vB(false);
                    } else if (top < measuredHeight) {
                        this.mab.setVisibility(0);
                        vB(false);
                    } else {
                        this.mab.setVisibility(4);
                        this.lYW.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.mah = true;
                    }
                }
            }
        }
    }

    public void drw() {
        if (!this.mbe) {
            TiebaStatic.log("c10490");
            this.mbe = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lNm.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(mam, Integer.valueOf(mao));
            aVar.nw(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.lNm.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.bn(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.lNm);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.24
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lNm.getPageContext()).bqx();
        }
    }

    public void PJ(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lNm.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.lNm.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.bn(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(mam, Integer.valueOf(maq));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.lNm);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lNm.getPageContext()).bqx();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b2;
        if (i > 0 && (b2 = b(fVar, z)) != null && b2.bnQ() != null) {
            MetaData bnQ = b2.bnQ();
            bnQ.setGiftNum(bnQ.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        a(fVar, z, i, i2);
        this.lZf.onChangeSkinType(i2);
    }

    public PbInterviewStatusView drx() {
        return this.lZZ;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlg() != null && fVar.dlg().boZ() && this.lZZ == null) {
            this.lZZ = (PbInterviewStatusView) this.lZY.inflate();
            this.lZZ.setOnClickListener(this.jjj);
            this.lZZ.setCallback(this.lNm.dnY());
            this.lZZ.setData(this.lNm, fVar);
        }
    }

    public RelativeLayout dry() {
        return this.lZk;
    }

    public View drz() {
        return this.bLj;
    }

    public boolean drA() {
        return this.maU;
    }

    public void uO(boolean z) {
        this.lZf.uO(z);
    }

    public void PK(String str) {
        if (this.lYX != null) {
            this.lYX.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int vM(boolean z) {
        if (this.lZZ == null || this.lZZ.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void drB() {
        if (this.lZZ != null && this.lZZ.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lZZ.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.lZZ.setLayoutParams(layoutParams);
        }
    }

    public boolean dnt() {
        return false;
    }

    public void PL(String str) {
        this.kpu.performClick();
        if (!StringUtils.isNull(str) && this.lNm.dnm() != null && this.lNm.dnm().bBN() != null && this.lNm.dnm().bBN().getInputView() != null) {
            EditText inputView = this.lNm.dnm().bBN().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            drk();
            if (configuration.orientation == 2) {
                drt();
                dqo();
            } else {
                dqs();
            }
            if (this.mau != null) {
                this.mau.dnh();
            }
            this.lNm.cDc();
            this.lZk.setVisibility(8);
            this.lYW.vZ(false);
            this.lNm.ve(false);
            if (this.lZc != null) {
                if (configuration.orientation == 1) {
                    dry().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.lZa.setIsLandscape(true);
                    this.lZa.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.lZa.setIsLandscape(false);
                    if (this.mLastScrollY > 0) {
                        this.lZa.smoothScrollBy(this.mLastScrollY, 0);
                    }
                }
                this.lZc.onConfigurationChanged(configuration);
                this.maa.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void vN(boolean z) {
        if (this.lZc != null) {
            this.lZc.vN(z);
        }
    }

    public boolean drC() {
        return this.lZc != null && this.lZc.drC();
    }

    public void drD() {
        if (this.lZc != null) {
            this.lZc.drD();
        }
    }

    public void uS(boolean z) {
        this.lZl.uS(z);
    }

    public void dM(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.lZK.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.lNm.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.maF = new TextView(this.lNm.getContext());
            this.maF.setText(R.string.connection_tips);
            this.maF.setGravity(17);
            this.maF.setPadding(com.baidu.adp.lib.util.l.getDimens(this.lNm.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.lNm.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lNm.getContext(), R.dimen.ds60);
            if (this.maF.getParent() == null) {
                frameLayout.addView(this.maF, layoutParams);
            }
            this.maE = new PopupWindow(this.lNm.getContext());
            this.maE.setContentView(frameLayout);
            this.maE.setHeight(-2);
            this.maE.setWidth(-2);
            this.maE.setFocusable(true);
            this.maE.setOutsideTouchable(false);
            this.maE.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.lZa.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.26
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ap.this.maE.showAsDropDown(ap.this.lZK, view.getLeft(), -ap.this.lZK.getHeight());
                    } else {
                        ap.this.maE.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void vO(boolean z) {
        this.maK = z;
    }

    public boolean drE() {
        return this.maK;
    }

    public PbThreadPostView drF() {
        return this.lZb;
    }

    private void z(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlg() != null && !fVar.dlg().bmv()) {
            boolean z = fVar.dlg().bnM() == 1;
            boolean z2 = fVar.dlg().bnL() == 1;
            if (this.lZf != null) {
                this.lZf.c(fVar, z, z2);
            }
            if (this.lZl != null && this.lZl.dnc() != null) {
                this.lZl.dnc().b(fVar, z, z2);
            }
        }
    }

    public void vP(boolean z) {
        this.jgj = z;
    }

    public void FW(int i) {
        this.maP = i;
    }

    public void drG() {
        if (this.lZa != null) {
            this.lZa.setForbidDragListener(true);
        }
    }

    public boolean dos() {
        if (this.lZa == null) {
            return false;
        }
        return this.lZa.dos();
    }

    public boolean drH() {
        if (this.jot == null || TextUtils.isEmpty(this.jot.getEndText())) {
            return false;
        }
        return this.jot.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }

    private boolean A(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dlg() == null) {
            return false;
        }
        SpannableStringBuilder boz = fVar.dlg().boz();
        if (boz != null) {
            return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(boz.toString());
        }
        return true;
    }

    public void drI() {
        boolean z;
        if (this.maS != null) {
            if (((this.maS.getView() == null || this.maS.getView().getParent() == null) ? -1 : this.lZa.getPositionForView(this.maS.getView())) != -1) {
                if (this.maS.getView().getTop() + maQ <= this.mab.getBottom()) {
                    this.maR = 1;
                    z = true;
                } else {
                    this.maR = 0;
                    z = false;
                }
            } else {
                z = this.maR == 1;
            }
            this.mae.vx(this.maR == 1);
            this.maS.setScrollable(z);
        }
    }

    public LinearLayout drJ() {
        return this.lZL;
    }
}
