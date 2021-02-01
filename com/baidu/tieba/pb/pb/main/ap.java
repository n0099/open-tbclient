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
    private NoNetworkView gxW;
    private boolean isLandscape;
    private List<CustomBlueCheckRadioButton> izt;
    private NavigationBarCoverTip jMg;
    private com.baidu.tieba.NEGFeedBack.f jQU;
    private boolean jfV;
    private View.OnClickListener jiV;
    private PbListView jof;
    private TextView kpg;
    private PbFragment lMX;
    private View.OnClickListener lOd;
    private com.baidu.tieba.pb.data.f lOq;
    private MaskView lPR;
    private com.baidu.tieba.pb.pb.main.a.d lPS;
    private PbFakeFloorModel lQO;
    PbFragment.c lSI;
    public int lYF;
    public final com.baidu.tieba.pb.pb.main.view.c lYH;
    public com.baidu.tieba.pb.pb.main.view.b lYI;
    private ViewStub lYJ;
    private ViewStub lYK;
    private PbLandscapeListView lYL;
    private PbThreadPostView lYM;
    private com.baidu.tieba.pb.pb.main.a.f lYN;
    private com.baidu.tieba.pb.pb.main.a.a lYO;
    private com.baidu.tieba.pb.pb.main.a.c lYP;
    private com.baidu.tieba.pb.pb.main.a.e lYQ;
    private com.baidu.tieba.pb.pb.main.a.b lYR;
    private LinearLayout lYS;
    private TextView lYT;
    private TextView lYU;
    private ObservedChangeRelativeLayout lYV;
    private g lYW;
    private ImageView lZA;
    private com.baidu.tieba.pb.view.d lZB;
    private TextView lZC;
    private TextView lZD;
    private int lZF;
    private int lZG;
    private PostData lZH;
    private ViewStub lZJ;
    private PbInterviewStatusView lZK;
    private FrameLayout lZL;
    private View lZM;
    private View lZN;
    private PbReplyTitleViewHolder lZO;
    private PbEmotionBar lZT;
    private View lZc;
    private View lZs;
    private View lZu;
    private View lZv;
    private LinearLayout lZw;
    private HeadImageView lZx;
    private ImageView lZy;
    private ImageView lZz;
    public int mLastScrollY;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private int maA;
    private com.baidu.tieba.pb.view.c maD;
    private boolean maF;
    private Runnable maJ;
    private PbFragment.b maL;
    private int mab;
    private Runnable mad;
    private r mae;
    private al maf;
    private int mal;
    private PbTopTipView mam;
    private PopupWindow man;
    private TextView mao;
    private List<String> maq;
    private com.baidu.tieba.pb.pb.main.emotion.c mar;
    private com.baidu.tieba.pb.pb.godreply.a mas;
    private PbLandscapeListView.b mat;
    private ae mav;
    private com.baidu.tieba.NEGFeedBack.i maw;
    private String may;
    private long maz;
    private TextView textView;
    private static final int lZP = UtilHelper.getLightStatusBarHeight();
    public static int lZV = 3;
    public static int lZW = 0;
    public static int lZX = 3;
    public static int lZY = 4;
    public static int lZZ = 5;
    public static int maa = 6;
    private static final int maB = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
    private static a.InterfaceC0870a maE = new a.InterfaceC0870a() { // from class: com.baidu.tieba.pb.pb.main.ap.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0870a
        public void onRefresh() {
        }
    };
    private int lYG = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a lYX = null;
    private com.baidu.tbadk.core.dialog.b jiU = null;
    private View lYY = null;
    private EditText lYZ = null;
    private com.baidu.tieba.pb.view.e lZa = null;
    private com.baidu.tieba.pb.view.a lZb = null;
    private b.InterfaceC0558b lZd = null;
    private TbRichTextView.i fUw = null;
    private NoNetworkView.a jdt = null;
    private com.baidu.tbadk.core.dialog.i lZe = null;
    private com.baidu.tbadk.core.dialog.a lZf = null;
    private Dialog lZg = null;
    private Dialog lZh = null;
    private View lZi = null;
    private LinearLayout lZj = null;
    private CompoundButton.OnCheckedChangeListener izu = null;
    private TextView lZk = null;
    private TextView lZl = null;
    private String lZm = null;
    private com.baidu.tbadk.core.dialog.i lRH = null;
    private com.baidu.tbadk.core.dialog.i lZn = null;
    private boolean lZo = false;
    private boolean lZp = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView lZq = null;
    private boolean lZr = false;
    private Button lZt = null;
    private boolean lZE = true;
    private com.baidu.tbadk.core.view.a iDG = null;
    private boolean lNV = false;
    private int mSkinType = 3;
    private boolean lZI = false;
    private int lZQ = 0;
    private boolean lZR = true;
    public a lZS = new a();
    private int lZU = 0;
    private boolean mag = false;
    private int mah = 0;
    private boolean mai = false;
    private boolean maj = false;
    private boolean mak = false;
    private boolean mau = false;
    private int maC = 0;
    private String maG = null;
    private CustomMessageListener maH = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.ap.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                ap.this.maG = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.ap.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && ap.this.lYW != null) {
                ap.this.lYW.notifyDataSetChanged();
            }
        }
    };
    private Handler maI = new Handler();
    private CustomMessageListener maK = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.ap.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ap.this.lZE = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean maM = true;
    View.OnClickListener maN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || ap.this.lOq == null || ap.this.lOq.dkZ() == null || ap.this.lOq.dkZ().bnQ() == null || ap.this.lOq.dkZ().bnQ().getAlaInfo() == null || ap.this.lOq.dkZ().bnQ().getAlaInfo().live_status != 1) {
                if (ap.this.mai) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11923").ap("obj_id", 2));
                }
                if (!ap.this.mai && ap.this.lOq != null && ap.this.lOq.dkZ() != null && ap.this.lOq.dkZ().bnQ() != null && ap.this.lOq.dkZ().bnQ().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12151").ap("obj_locate", 1));
                }
                if (ap.this.lMX.doa() != null) {
                    ap.this.lMX.doa().lNj.iPF.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c11851");
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(arVar);
            if (ap.this.lOq.dkZ().bnQ().getAlaInfo() == null || !ap.this.lOq.dkZ().bnQ().getAlaInfo().isChushou) {
                if (ap.this.lOq.dkZ().bnQ().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = ap.this.lOq.dkZ().bnQ().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ap.this.lMX.doa(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            bf.bsV().b(ap.this.lMX.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + ap.this.lOq.dkZ().bnQ().getAlaInfo().thirdRoomId + "&livetype=" + ap.this.lOq.dkZ().bnQ().getAlaInfo().thirdLiveType});
        }
    };
    private boolean bje = false;
    String userId = null;
    private final List<TbImageView> maO = new ArrayList();
    private boolean maP = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int headerCount;
        public int lDa;
        public PbReplyTitleViewHolder mbd;
    }

    public void vy(boolean z) {
        this.mag = z;
        if (this.lYL != null) {
            this.mah = this.lYL.getHeaderViewsCount();
        }
    }

    public void dqf() {
        if (this.lYL != null) {
            int headerViewsCount = this.lYL.getHeaderViewsCount() - this.mah;
            final int firstVisiblePosition = (this.lYL.getFirstVisiblePosition() == 0 || this.lYL.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.lYL.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.lYL.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.lZS.mbd = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lZS));
            final PbReplyTitleViewHolder pbReplyTitleViewHolder = this.lZS.mbd;
            final int g = g(pbReplyTitleViewHolder);
            final int y = ((int) this.lYV.getY()) + this.lYV.getMeasuredHeight();
            final boolean z = this.lZM.getVisibility() == 0;
            boolean z2 = this.lYV.getY() < 0.0f;
            if ((z && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.lYW.dmQ() + this.lYL.getHeaderViewsCount()) {
                int measuredHeight = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.lYh.getMeasuredHeight() : 0;
                if (z2) {
                    this.lYL.setSelectionFromTop(this.lYW.dmQ() + this.lYL.getHeaderViewsCount(), lZP - measuredHeight);
                } else {
                    this.lYL.setSelectionFromTop(this.lYW.dmQ() + this.lYL.getHeaderViewsCount(), this.lYH.dsi().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.lYL.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.mai && this.lYN != null) {
                this.lYL.setSelectionFromTop(this.lYW.dmQ() + this.lYL.getHeaderViewsCount(), this.lYN.drU());
            } else if (this.mType == 6) {
                this.lYL.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.ap.1
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
                                    layoutParams.height = ap.this.mab;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > ap.this.bMd.getMeasuredHeight()) {
                                    layoutParams.height = ap.this.mab;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    ap.this.lYL.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                ap.this.bMM.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (ap.this.bMM != null && ap.this.bMM.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = ap.this.bMM.getLayoutParams();
                                            layoutParams2.height = ap.this.mab;
                                            ap.this.bMM.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        ap.this.lYL.setOnLayoutListener(null);
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

    public NoNetworkView dqg() {
        return this.gxW;
    }

    public void dqh() {
        if (this.acR != null) {
            this.acR.hide();
            if (this.mar != null) {
                this.mar.drW();
            }
        }
    }

    public PbFakeFloorModel dqi() {
        return this.lQO;
    }

    public r dqj() {
        return this.mae;
    }

    public com.baidu.tieba.pb.pb.main.a.f dqk() {
        return this.lYN;
    }

    public void dql() {
        reset();
        dqh();
        this.mae.dna();
        vK(false);
    }

    private void reset() {
        if (this.lMX != null && this.lMX.dnf() != null && this.acR != null) {
            com.baidu.tbadk.editortools.pb.a.bBK().setStatus(0);
            com.baidu.tbadk.editortools.pb.e dnf = this.lMX.dnf();
            dnf.bCf();
            dnf.bBu();
            if (dnf.getWriteImagesInfo() != null) {
                dnf.getWriteImagesInfo().setMaxImagesAllowed(dnf.isBJH ? 1 : 9);
            }
            dnf.re(SendView.ALL);
            dnf.rf(SendView.ALL);
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

    public boolean dqm() {
        return this.lZE;
    }

    public void vz(boolean z) {
        if (this.lZv != null && this.kpg != null) {
            this.kpg.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lZv.startAnimation(alphaAnimation);
            }
            this.lZu.setVisibility(0);
            this.lZv.setVisibility(0);
            this.lZE = true;
            if (this.lZT != null && !this.mas.isActive()) {
                this.lZT.setVisibility(0);
                vE(true);
            }
        }
    }

    public void vA(boolean z) {
        if (this.lZv != null && this.kpg != null) {
            this.kpg.setText(dqn());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lZv.startAnimation(alphaAnimation);
            }
            this.lZu.setVisibility(0);
            this.lZv.setVisibility(0);
            this.lZE = true;
            if (this.lZT != null && !this.mas.isActive()) {
                this.lZT.setVisibility(0);
                vE(true);
            }
        }
    }

    public String dqn() {
        if (!com.baidu.tbadk.core.util.au.isEmpty(this.may)) {
            return this.may;
        }
        if (this.lMX != null) {
            this.may = TbadkCoreApplication.getInst().getResources().getString(ao.dqd());
        }
        return this.may;
    }

    public PostData dqo() {
        int i = 0;
        if (this.lYL == null) {
            return null;
        }
        int dqp = dqp() - this.lYL.getHeaderViewsCount();
        if (dqp < 0) {
            dqp = 0;
        }
        if (this.lYW.FA(dqp) != null && this.lYW.FA(dqp) != PostData.nwx) {
            i = dqp + 1;
        }
        return this.lYW.getItem(i) instanceof PostData ? (PostData) this.lYW.getItem(i) : null;
    }

    public int dqp() {
        int i;
        View childAt;
        if (this.lYL == null) {
            return 0;
        }
        int firstVisiblePosition = this.lYL.getFirstVisiblePosition();
        int lastVisiblePosition = this.lYL.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.lYL.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.lYL.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int dqq() {
        return this.lYL.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.lOq != null && this.lOq.dlb() != null && !this.lOq.dlb().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.lOq.dlb().size() && (postData = this.lOq.dlb().get(i)) != null && postData.bnQ() != null && !StringUtils.isNull(postData.bnQ().getUserId()); i++) {
                if (this.lOq.dlb().get(i).bnQ().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.mas != null && this.mas.isActive()) {
                        vK(false);
                    }
                    if (this.lZT != null) {
                        this.lZT.vV(true);
                    }
                    this.maG = postData.bnQ().getName_show();
                    return;
                }
            }
        }
    }

    public ap(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.lMX = null;
        this.bMd = null;
        this.bLj = null;
        this.lYL = null;
        this.lYW = null;
        this.jof = null;
        this.fIC = null;
        this.jiV = null;
        this.lOd = null;
        this.lZv = null;
        this.kpg = null;
        this.lZJ = null;
        this.mal = 0;
        this.maz = 0L;
        this.maz = System.currentTimeMillis();
        this.lMX = pbFragment;
        this.jiV = onClickListener;
        this.fvK = cVar;
        this.mal = com.baidu.adp.lib.util.l.getEquipmentWidth(this.lMX.getContext()) / 8;
        this.bMd = (RelativeLayout) LayoutInflater.from(this.lMX.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bMd.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.lZs = this.bMd.findViewById(R.id.bottom_shadow);
        this.jMg = (NavigationBarCoverTip) this.bMd.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.bLj = this.bMd.findViewById(R.id.statebar_view);
        this.lYV = (ObservedChangeRelativeLayout) this.bMd.findViewById(R.id.title_wrapper);
        this.gxW = (NoNetworkView) this.bMd.findViewById(R.id.view_no_network);
        this.lYL = (PbLandscapeListView) this.bMd.findViewById(R.id.new_pb_list);
        this.lZL = (FrameLayout) this.bMd.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.lMX.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.lMX.getActivity(), R.dimen.ds88));
        this.lYL.addHeaderView(this.textView, 0);
        this.lYL.setTextViewAdded(true);
        this.mab = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bMM = new View(this.lMX.getPageContext().getPageActivity());
        this.bMM.setLayoutParams(new AbsListView.LayoutParams(-1, this.mab));
        this.bMM.setVisibility(4);
        this.lYL.addFooterView(this.bMM);
        this.lYL.setOnTouchListener(this.lMX.bST);
        this.lYH = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bMd);
        if (this.lMX.dnJ()) {
            this.lYJ = (ViewStub) this.bMd.findViewById(R.id.manga_view_stub);
            this.lYJ.setVisibility(0);
            this.lYI = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.lYI.show();
            this.lYH.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lMX.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.lYH.dsi().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0826a() { // from class: com.baidu.tieba.pb.pb.main.ap.27
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0826a
            public void dmc() {
                if (ap.this.lYL != null) {
                    if (ap.this.lYN != null) {
                        ap.this.lYN.drT();
                    }
                    ap.this.lYL.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0826a
            public void dmd() {
                ap.this.lMX.cCV();
            }
        }));
        this.lZu = this.bMd.findViewById(R.id.view_comment_top_line);
        this.lZv = this.bMd.findViewById(R.id.pb_editor_tool_comment);
        this.lZF = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lZG = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lZx = (HeadImageView) this.bMd.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lZx.setVisibility(0);
        this.lZx.setIsRound(true);
        this.lZx.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.lMX.getContext(), R.dimen.L_X01));
        this.lZx.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0401));
        this.lZx.setPlaceHolder(0);
        dqr();
        this.kpg = (TextView) this.bMd.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lZw = (LinearLayout) this.bMd.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lZw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(ap.this.lMX.getActivity(), "pb_huitie"))) {
                    ap.this.lMX.dnq();
                    if (ap.this.lMX != null && ap.this.lMX.dmq() != null && ap.this.lMX.dmq().getPbData() != null && ap.this.lMX.dmq().getPbData().dkZ() != null && ap.this.lMX.dmq().getPbData().dkZ().bnQ() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13701").dR("tid", ap.this.lMX.dmq().dou()).dR("fid", ap.this.lMX.dmq().getPbData().getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", ap.this.lMX.dmq().lUN).dR("fid", ap.this.lMX.dmq().getPbData().getForumId()).ap("obj_locate", 1).dR("uid", ap.this.lMX.dmq().getPbData().dkZ().bnQ().getUserId()));
                    }
                }
            }
        });
        this.lZy = (ImageView) this.bMd.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lPR = (MaskView) this.bMd.findViewById(R.id.mask_view);
        this.lZy.setOnClickListener(this.jiV);
        boolean booleanExtra = this.lMX.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lZz = (ImageView) this.bMd.findViewById(R.id.pb_editor_tool_collection);
        this.lZz.setOnClickListener(this.jiV);
        if (booleanExtra) {
            this.lZz.setVisibility(8);
        } else {
            this.lZz.setVisibility(0);
        }
        this.lZA = (ImageView) this.bMd.findViewById(R.id.pb_editor_tool_share);
        this.lZA.setOnClickListener(this.jiV);
        this.lZB = new com.baidu.tieba.pb.view.d(this.lZA);
        this.lZB.dvx();
        this.lZC = (TextView) this.bMd.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lZC.setVisibility(0);
        this.lZJ = (ViewStub) this.bMd.findViewById(R.id.interview_status_stub);
        this.lYO = new com.baidu.tieba.pb.pb.main.a.a(this.lMX, cVar);
        this.lYQ = new com.baidu.tieba.pb.pb.main.a.e(this.lMX, cVar, this.jiV);
        this.lYW = new g(this.lMX, this.lYL);
        this.lYW.H(this.jiV);
        this.lYW.setTbGestureDetector(this.fvK);
        this.lYW.setOnImageClickListener(this.fUw);
        this.lYW.setOnSwitchChangeListener(this.lMX.lSB);
        this.lOd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.29
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
                            ap.this.lMX.f(sparseArray);
                            return;
                        }
                        ap.this.dL(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        ap.this.lMX.f(sparseArray);
                    } else if (booleanValue3) {
                        ap.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.lYW.U(this.lOd);
        dqw();
        dqx();
        this.lPS = new com.baidu.tieba.pb.pb.main.a.d(this.lMX);
        this.lPS.fvb = 2;
        this.lYP.b(this.lYL);
        this.lYQ.b(this.lYL);
        this.lYO.b(this.lYL);
        this.jof = new PbListView(this.lMX.getPageContext().getPageActivity());
        this.fIC = this.jof.getView().findViewById(R.id.pb_more_view);
        if (this.fIC != null) {
            this.fIC.setOnClickListener(this.jiV);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.fIC, R.drawable.pb_foot_more_trans_selector);
        }
        this.jof.setLineVisible();
        this.jof.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.jof.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.lZc = this.bMd.findViewById(R.id.viewstub_progress);
        this.lMX.registerListener(this.maK);
        this.lQO = new PbFakeFloorModel(this.lMX.getPageContext());
        this.mae = new r(this.lMX.getPageContext(), this.lQO, this.bMd);
        this.mae.V(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.dql();
            }
        });
        this.mae.a(this.lMX.lSD);
        this.lQO.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.ap.31
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                ap.this.lQO.u(postData);
                ap.this.lYW.notifyDataSetChanged();
                ap.this.mae.dna();
                ap.this.acR.bzD();
                ap.this.vK(false);
            }
        });
        if (this.lMX.dmq() != null && !StringUtils.isNull(this.lMX.dmq().dpd())) {
            this.lMX.showToast(this.lMX.dmq().dpd());
        }
        this.lZM = this.bMd.findViewById(R.id.pb_expand_blank_view);
        this.lZN = this.bMd.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lZN.getLayoutParams();
        if (this.lMX.dmq() != null && this.lMX.dmq().dox()) {
            this.lZM.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.lZN.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = lZP;
            this.lZN.setLayoutParams(layoutParams2);
        }
        this.lZO = new PbReplyTitleViewHolder(this.lMX.getPageContext(), this.bMd.findViewById(R.id.pb_reply_expand_view));
        this.lZO.w(pbFragment.lRw);
        this.lZO.lYh.setVisibility(8);
        this.lZO.W(this.jiV);
        this.lZO.setOnSwitchChangeListener(this.lMX.lSB);
        this.lMX.registerListener(this.mAccountChangedListener);
        this.lMX.registerListener(this.maH);
        dqs();
        vE(false);
        this.maD = new com.baidu.tieba.pb.view.c(this.lMX.getPageContext());
    }

    private void dqr() {
        if (this.lZx != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lZx.setImageResource(0);
            this.lZx.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.lZx.setImageResource(R.drawable.transparent_bg);
    }

    public void vB(boolean z) {
        this.lZs.setVisibility(z ? 0 : 8);
    }

    public void cSm() {
        if (!this.lMX.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").ap("obj_locate", 2).dR("fid", this.mForumId));
        } else if (this.lMX.dnt()) {
            com.baidu.tbadk.editortools.pb.e dnf = this.lMX.dnf();
            if (dnf != null && (dnf.bCc() || dnf.bCd())) {
                this.lMX.dnf().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.acR != null) {
                dqC();
            }
            if (this.acR != null) {
                this.lZE = false;
                if (this.acR.qU(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.lMX.getPageContext(), (View) this.acR.qU(2).fBo, false, maE);
                }
            }
            drm();
        }
    }

    private void dqs() {
        this.mas = new com.baidu.tieba.pb.pb.godreply.a(this.lMX, this, (ViewStub) this.bMd.findViewById(R.id.more_god_reply_popup));
        this.mas.C(this.jiV);
        this.mas.U(this.lOd);
        this.mas.setOnImageClickListener(this.fUw);
        this.mas.C(this.jiV);
        this.mas.setTbGestureDetector(this.fvK);
    }

    public com.baidu.tieba.pb.pb.godreply.a dqt() {
        return this.mas;
    }

    public View dqu() {
        return this.lZM;
    }

    public void dqv() {
        if (this.lYL != null) {
            this.lYP.c(this.lYL);
            this.lYQ.c(this.lYL);
            this.lYR.c(this.lYL);
            this.lYO.c(this.lYL);
        }
    }

    private void dqw() {
        if (this.lYR == null) {
            this.lYR = new com.baidu.tieba.pb.pb.main.a.b(this.lMX, this.jiV);
        }
    }

    private void dqx() {
        if (this.lYP == null) {
            this.lYP = new com.baidu.tieba.pb.pb.main.a.c(this.lMX, this.fvK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqy() {
        if (this.lMX.dnJ()) {
            this.lYK = (ViewStub) this.bMd.findViewById(R.id.manga_mention_controller_view_stub);
            this.lYK.setVisibility(0);
            if (this.lYS == null) {
                this.lYS = (LinearLayout) this.bMd.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.lMX.getPageContext(), this.lYS);
            }
            if (this.lYT == null) {
                this.lYT = (TextView) this.lYS.findViewById(R.id.manga_prev_btn);
            }
            if (this.lYU == null) {
                this.lYU = (TextView) this.lYS.findViewById(R.id.manga_next_btn);
            }
            this.lYT.setOnClickListener(this.jiV);
            this.lYU.setOnClickListener(this.jiV);
        }
    }

    private void dqz() {
        if (this.lMX.dnJ()) {
            if (this.lMX.dnM() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYT, R.color.CAM_X0110, 1);
            }
            if (this.lMX.dnN() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYU, R.color.CAM_X0110, 1);
            }
        }
    }

    public void dqA() {
        if (this.lYS == null) {
            dqy();
        }
        this.lYK.setVisibility(8);
        if (this.maI != null && this.maJ != null) {
            this.maI.removeCallbacks(this.maJ);
        }
    }

    public void dqB() {
        if (this.maI != null) {
            if (this.maJ != null) {
                this.maI.removeCallbacks(this.maJ);
            }
            this.maJ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ap.this.lYS == null) {
                        ap.this.dqy();
                    }
                    ap.this.lYK.setVisibility(0);
                }
            };
            this.maI.postDelayed(this.maJ, 2000L);
        }
    }

    public void vC(boolean z) {
        this.lYH.vC(z);
        if (z && this.lZI) {
            this.jof.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.lYL.setNextPage(this.jof);
            this.lYG = 2;
        }
        dqr();
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acR = editorTools;
        this.acR.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ap.this.dql();
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
                        ap.this.mPermissionJudgePolicy.appendRequestPermission(ap.this.lMX.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ap.this.mPermissionJudgePolicy.startRequestPermission(ap.this.lMX.getBaseFragmentActivity())) {
                            ap.this.lMX.dnf().c((com.baidu.tbadk.coreExtra.data.u) aVar.data);
                            ap.this.lMX.dnf().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dqh();
        this.lMX.dnf().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.ap.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ap.this.acR != null && ap.this.acR.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (ap.this.mar == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, ap.this.acR.getId());
                            ap.this.mar = new com.baidu.tieba.pb.pb.main.emotion.c(ap.this.lMX.getPageContext(), ap.this.bMd, layoutParams2);
                            if (!com.baidu.tbadk.core.util.y.isEmpty(ap.this.maq)) {
                                ap.this.mar.setData(ap.this.maq);
                            }
                            ap.this.mar.c(ap.this.acR);
                        }
                        ap.this.mar.PO(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ap.this.lMX.kWo != null && ap.this.lMX.kWo.drF() != null) {
                    if (!ap.this.lMX.kWo.drF().dWq()) {
                        ap.this.lMX.kWo.vQ(false);
                    }
                    ap.this.lMX.kWo.drF().zu(false);
                }
            }
        });
    }

    public void dqC() {
        if (this.lMX != null && this.acR != null) {
            this.acR.display();
            if (this.lMX.dnf() != null) {
                this.lMX.dnf().bBS();
            }
            drm();
        }
    }

    public void vD(boolean z) {
        if (this.lYL != null && this.textView != null && this.bLj != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bLj.setVisibility(0);
                } else {
                    this.bLj.setVisibility(8);
                    this.lYL.removeHeaderView(this.textView);
                    this.lYL.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = lZP;
                    this.textView.setLayoutParams(layoutParams);
                }
                dqT();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + vM(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            dqT();
            dru();
        }
    }

    public g dqD() {
        return this.lYW;
    }

    public void a(PbFragment.c cVar) {
        this.lSI = cVar;
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
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lMX.getContext());
        kVar.setTitleText(this.lMX.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.lZe.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 10:
                            ap.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 11:
                            if (ap.this.maL != null) {
                                ap.this.maL.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 12:
                            ap.this.lMX.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.lMX.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.lMX.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eVl.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !drt()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(11, this.lMX.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.lMX.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.lMX.getString(R.string.mute), kVar);
            }
            gVar.eVl.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.k(com.baidu.tieba.pb.pb.main.d.a.fq(arrayList), true);
        this.lZe = new com.baidu.tbadk.core.dialog.i(this.lMX.getPageContext(), kVar);
        this.lZe.QE();
    }

    public void a(PbFragment.b bVar) {
        this.maL = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.lMX != null && aVar != null) {
            if (this.jQU == null && this.lYO != null) {
                this.jQU = new com.baidu.tieba.NEGFeedBack.f(this.lMX.getPageContext(), this.lYO.drP());
            }
            AntiData cBs = this.lMX.cBs();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBs != null && cBs.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBs.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            this.jQU.setDefaultReasonArray(new String[]{this.lMX.getString(R.string.delete_thread_reason_1), this.lMX.getString(R.string.delete_thread_reason_2), this.lMX.getString(R.string.delete_thread_reason_3), this.lMX.getString(R.string.delete_thread_reason_4), this.lMX.getString(R.string.delete_thread_reason_5)});
            this.jQU.setData(avVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jQU.Et(str);
            this.jQU.a(new f.b() { // from class: com.baidu.tieba.pb.pb.main.ap.9
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void W(JSONArray jSONArray) {
                    ap.this.lMX.a(aVar, jSONArray);
                }
            });
        }
    }

    private boolean dqE() {
        if (this.lMX == null || this.lMX.dmq().getPbData().getForum().getDeletedReasonInfo() == null) {
            return false;
        }
        return 1 == this.lMX.dmq().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i, com.baidu.tieba.NEGFeedBack.h hVar, UserData userData) {
        String str;
        if (this.lMX != null && aVar != null) {
            if (this.maw == null && this.lYO != null) {
                this.maw = new com.baidu.tieba.NEGFeedBack.i(this.lMX.getPageContext(), this.lYO.drP(), hVar, userData);
            }
            AntiData cBs = this.lMX.cBs();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBs != null && cBs.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBs.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            this.maw.setDefaultReasonArray(new String[]{this.lMX.getString(R.string.delete_thread_reason_1), this.lMX.getString(R.string.delete_thread_reason_2), this.lMX.getString(R.string.delete_thread_reason_3), this.lMX.getString(R.string.delete_thread_reason_4), this.lMX.getString(R.string.delete_thread_reason_5)});
            this.maw.setData(avVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.maw.Et(str);
            this.maw.a(new i.b() { // from class: com.baidu.tieba.pb.pb.main.ap.10
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void W(JSONArray jSONArray) {
                    ap.this.lMX.a(aVar, jSONArray);
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
        sparseArray.put(lZW, Integer.valueOf(lZX));
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
        this.lZf = new com.baidu.tbadk.core.dialog.a(this.lMX.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lZf.nx(i3);
        } else {
            this.lZf.setOnlyMessageShowCenter(false);
            this.lZf.Au(str2);
        }
        this.lZf.setYesButtonTag(sparseArray);
        this.lZf.a(R.string.dialog_ok, this.lMX);
        this.lZf.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lZf.jF(true);
        this.lZf.b(this.lMX.getPageContext());
        if (z) {
            this.lZf.bqx();
        } else if (dqE()) {
            com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(this.lMX.dmq().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.lMX.dmq().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.lMX.dmq().getPbData().dlI().has_forum_rule.intValue());
            hVar.eg(this.lMX.dmq().getPbData().getForum().getId(), this.lMX.dmq().getPbData().getForum().getName());
            hVar.setForumHeadUrl(this.lMX.dmq().getPbData().getForum().getImage_url());
            hVar.setUserLevel(this.lMX.dmq().getPbData().getForum().getUser_level());
            a(this.lZf, i, hVar, this.lMX.dmq().getPbData().getUserData());
        } else {
            a(this.lZf, i);
        }
    }

    public void aZ(ArrayList<com.baidu.tbadk.core.data.al> arrayList) {
        if (this.lZi == null) {
            this.lZi = LayoutInflater.from(this.lMX.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.lMX.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lZi);
        if (this.lZh == null) {
            this.lZh = new Dialog(this.lMX.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lZh.setCanceledOnTouchOutside(true);
            this.lZh.setCancelable(true);
            this.lZq = (ScrollView) this.lZi.findViewById(R.id.good_scroll);
            this.lZh.setContentView(this.lZi);
            WindowManager.LayoutParams attributes = this.lZh.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lZh.getWindow().setAttributes(attributes);
            this.izu = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ap.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        ap.this.lZm = (String) compoundButton.getTag();
                        if (ap.this.izt != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : ap.this.izt) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && ap.this.lZm != null && !str.equals(ap.this.lZm)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lZj = (LinearLayout) this.lZi.findViewById(R.id.good_class_group);
            this.lZl = (TextView) this.lZi.findViewById(R.id.dialog_button_cancel);
            this.lZl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ap.this.lZh instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(ap.this.lZh, ap.this.lMX.getPageContext());
                    }
                }
            });
            this.lZk = (TextView) this.lZi.findViewById(R.id.dialog_button_ok);
            this.lZk.setOnClickListener(this.jiV);
        }
        this.lZj.removeAllViews();
        this.izt = new ArrayList();
        CustomBlueCheckRadioButton fU = fU("0", this.lMX.getPageContext().getString(R.string.thread_good_class));
        this.izt.add(fU);
        fU.setChecked(true);
        this.lZj.addView(fU);
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
                    this.izt.add(fU2);
                    View view = new View(this.lMX.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ap.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.lZj.addView(view);
                    this.lZj.addView(fU2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lZq.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lMX.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lMX.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lMX.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lZq.setLayoutParams(layoutParams2);
            this.lZq.removeAllViews();
            if (this.lZj != null && this.lZj.getParent() == null) {
                this.lZq.addView(this.lZj);
            }
        }
        com.baidu.adp.lib.f.g.a(this.lZh, this.lMX.getPageContext());
    }

    private CustomBlueCheckRadioButton fU(String str, String str2) {
        Activity pageActivity = this.lMX.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.izu);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void dqF() {
        this.lMX.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.lMX.hideProgressBar();
        if (z && z2) {
            this.lMX.showToast(this.lMX.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.lMX.showToast(str);
        }
    }

    public void dqG() {
        this.lZc.setVisibility(0);
    }

    public void dqH() {
        this.lZc.setVisibility(8);
    }

    public View dqI() {
        if (this.lZi != null) {
            return this.lZi.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String dqJ() {
        return this.lZm;
    }

    public View getView() {
        return this.bMd;
    }

    public void dqK() {
        if (this.lMX != null && this.lMX.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lMX.getPageContext().getPageActivity(), this.lMX.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.lMX.hideProgressBar();
        if (z) {
            drd();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            dre();
        } else {
            drd();
        }
    }

    public void dqL() {
        this.jof.setLineVisible();
        this.jof.startLoadData();
    }

    public void dqM() {
        this.lMX.hideProgressBar();
        endLoadData();
        this.lYL.completePullRefreshPostDelayed(0L);
        dqY();
    }

    public void dqN() {
        this.lYL.completePullRefreshPostDelayed(0L);
        dqY();
    }

    private void vE(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.lYQ.b(onLongClickListener);
        this.lYW.setOnLongClickListener(onLongClickListener);
        if (this.mas != null) {
            this.mas.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0558b interfaceC0558b, boolean z, boolean z2) {
        if (this.lRH != null) {
            this.lRH.dismiss();
            this.lRH = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lMX.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lMX.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lMX.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lMX.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lMX.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.bw(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.lZn.dismiss();
                interfaceC0558b.a(null, i, view);
            }
        });
        this.lZn = new com.baidu.tbadk.core.dialog.i(this.lMX.getPageContext(), kVar);
        this.lZn.QE();
    }

    public void a(final b.InterfaceC0558b interfaceC0558b, boolean z) {
        if (this.lZn != null) {
            this.lZn.dismiss();
            this.lZn = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lMX.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.lOq != null && this.lOq.dkZ() != null && !this.lOq.dkZ().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lMX.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lMX.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bw(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.ap.16
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                ap.this.lZn.dismiss();
                interfaceC0558b.a(null, i, view);
            }
        });
        this.lZn = new com.baidu.tbadk.core.dialog.i(this.lMX.getPageContext(), kVar);
        this.lZn.QE();
    }

    public int dqO() {
        return Gb(this.lYL.getFirstVisiblePosition());
    }

    private int Gb(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.lYL.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.lYL.getAdapter() == null || !(this.lYL.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.lYL.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int dqP() {
        int lastVisiblePosition = this.lYL.getLastVisiblePosition();
        if (this.lYN != null) {
            if (lastVisiblePosition == this.lYL.getCount() - 1) {
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
        if (this.lYL != null) {
            if (this.lYH == null || this.lYH.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.lYH.mNavigationBar.getFixedNavHeight();
                if (this.lMX.dnz() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.lZN != null && (layoutParams = (LinearLayout.LayoutParams) this.lZN.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.lZN.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.lYL.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.lYL.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.lYL.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.lYZ.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.lYW.a(fVar, false);
        this.lYW.notifyDataSetChanged();
        dqY();
        if (this.mas != null) {
            this.mas.bOT();
        }
        ArrayList<PostData> dlb = fVar.dlb();
        if (fVar.getPage().bmF() == 0 || dlb == null || dlb.size() < fVar.getPage().bmE()) {
            if (com.baidu.tbadk.core.util.y.getCount(dlb) == 0 || (com.baidu.tbadk.core.util.y.getCount(dlb) == 1 && dlb.get(0) != null && dlb.get(0).dNx() == 1)) {
                if (this.lZS == null || this.lZS.mbd == null || this.lZS.mbd.getView() == null) {
                    i = 0;
                } else {
                    i = this.lZS.mbd.getView().getTop() < 0 ? this.lZS.mbd.getView().getHeight() : this.lZS.mbd.getView().getBottom();
                }
                if (this.lMX.dnT()) {
                    this.jof.at(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.jof.at(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().bmF() == 0) {
                    this.jof.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.jof.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.jof.bue();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.lYO != null) {
            this.lYO.e(fVar, this.lNV);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dlm() != null) {
            return fVar.dlm();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dlb())) {
            Iterator<PostData> it = fVar.dlb().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dNx() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dli();
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
        if (fVar == null || fVar.dkZ() == null || fVar.dkZ().bnQ() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bnQ = fVar.dkZ().bnQ();
        String userId = bnQ.getUserId();
        HashMap<String, MetaData> userMap = fVar.dkZ().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bnQ;
        }
        postData.JE(1);
        postData.setId(fVar.dkZ().bog());
        postData.setTitle(fVar.dkZ().getTitle());
        postData.setTime(fVar.dkZ().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.dkZ() != null) {
            if (this.lMX.dmi()) {
                if (fVar.dkY() != null) {
                    this.mForumName = fVar.dkY().getForumName();
                    this.mForumId = fVar.dkY().getForumId();
                }
                if (this.mForumName == null && this.lMX.dmq() != null && this.lMX.dmq().dmj() != null) {
                    this.mForumName = this.lMX.dmq().dmj();
                }
            }
            PostData b2 = b(fVar, z);
            a(b2, fVar);
            this.lYQ.setVisibility(8);
            if (fVar.dlz()) {
                this.mai = true;
                this.lYH.wc(true);
                this.lYH.mNavigationBar.hideBottomLine();
                if (this.lYN == null) {
                    this.lYN = new com.baidu.tieba.pb.pb.main.a.f(this.lMX);
                }
                this.lYN.a(fVar, b2, this.lYL, this.lYQ, this.lZL, this.lYH, this.mForumName, this.maz);
                this.lYN.X(this.maN);
                dqT();
            } else {
                this.mai = false;
                this.lYH.wc(this.mai);
                if (this.lYN != null) {
                    this.lYN.c(this.lYL);
                }
            }
            if (this.lMX.dni() != null) {
                this.lMX.dni().vW(this.mai);
            }
            if (b2 != null) {
                this.lZH = b2;
                this.lYQ.setVisibility(0);
                SparseArray<Object> drS = this.lYQ.drS();
                drS.put(R.id.tag_clip_board, b2);
                drS.put(R.id.tag_is_subpb, false);
                this.lYR.a(fVar, this.lYL);
                this.lYP.C(fVar);
                this.lYO.e(fVar, this.lNV);
                this.lYO.B(fVar);
                this.lYQ.a(this.mSkinType, this.lOq, b2, this.maN);
                if (this.lZO != null) {
                    if (fVar.dlC()) {
                        this.lZO.getView().setVisibility(8);
                    } else {
                        this.lZO.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.o oVar = new com.baidu.tieba.pb.data.o(com.baidu.tieba.pb.data.o.lLq);
                        if (fVar.dkZ() != null) {
                            oVar.lLs = fVar.dkZ().bnH();
                        }
                        oVar.isNew = !this.lNV;
                        oVar.sortType = fVar.lJZ;
                        oVar.lLu = fVar.dlD();
                        oVar.lLv = this.lMX.dnT();
                        oVar.lLw = fVar.lJY;
                        this.lZO.a(oVar);
                    }
                }
                z(fVar);
                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ap.this.lYW != null && ap.this.lYH != null && ap.this.lYH.mfp != null && ap.this.lOq != null && ap.this.lOq.dkZ() != null && !ap.this.lOq.dkZ().bmv() && !ap.this.dqX() && ap.this.lOq.getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(ap.this.lOq.getForum().getName())) {
                            if ((ap.this.lYW.dmU() == null || !ap.this.lYW.dmU().isShown()) && ap.this.lYH.mfp != null) {
                                ap.this.lYH.mfp.setVisibility(0);
                                if (ap.this.lMX != null && ap.this.lMX.dmq() != null) {
                                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13400");
                                    arVar.dR("tid", ap.this.lMX.dmq().dot());
                                    arVar.dR("fid", ap.this.lMX.dmq().getForumId());
                                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(arVar);
                                }
                            }
                        }
                    }
                });
                this.lPS.c(this.lYL);
                if (b2.nxk) {
                    this.lPS.setPostId(b2.getId());
                    this.lPS.a(this.lYL, this.lYL.getHeaderViewsCount() > 1 ? 1 : 0);
                }
                if (this.lYW != null && this.lYW.dmT() != null) {
                    this.lYW.dmT().vS(b2.nxk);
                }
                if (this.lYW != null) {
                    this.lYW.uT(b2.nxk);
                }
                this.lPR.setVisibility(b2.nxk ? 0 : 8);
            }
        }
    }

    public void vF(boolean z) {
        if (z) {
            dqQ();
        } else {
            cws();
        }
        this.lZS.mbd = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lZS));
        a(this.lZS.mbd, false);
    }

    public void dqQ() {
        if (this.lYH != null && !this.mak) {
            this.lYH.dqQ();
            this.mak = true;
        }
    }

    public void cws() {
        if (this.lYH != null) {
            this.lYH.dsr();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.lYQ.a(postData, fVar);
    }

    public void dqR() {
        if (this.lYN != null) {
            this.lYN.d(this.lYL);
        }
    }

    public boolean dqS() {
        return this.bje;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aO(cb cbVar) {
        if (cbVar == null || cbVar.bnQ() == null) {
            return false;
        }
        PostData b2 = b(this.lOq, false);
        String str = "";
        if (b2 != null && b2.bnQ() != null) {
            str = b2.bnQ().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.lYH.dso();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.lYH.KF(dVar.forumName);
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
            final String str2 = dVar.lJQ;
            this.lMX.showNetRefreshView(this.bMd, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ap.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        bf.bsV().b(ap.this.lMX.getPageContext(), new String[]{str2});
                        ap.this.lMX.finish();
                        return;
                    }
                    ap.this.lMX.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable dpT;
        Parcelable dpT2;
        if (fVar != null && this.lYL != null) {
            this.lOq = fVar;
            this.mType = i;
            if (fVar.dkZ() != null) {
                this.lZU = fVar.dkZ().bnx();
                if (fVar.dkZ().getAnchorLevel() != 0) {
                    this.bje = true;
                }
                this.lZp = aO(fVar.dkZ());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.lZI = false;
            this.lNV = z;
            dqM();
            if (fVar.lKa != null && fVar.lKa.dlK()) {
                if (this.lYM == null) {
                    this.lYM = new PbThreadPostView(this.lMX.getContext());
                    this.lYL.addHeaderView(this.lYM, 1);
                    this.lYM.setData(fVar);
                    this.lYM.setChildOnClickLinstener(this.jiV);
                }
            } else if (this.lYM != null && this.lYL != null) {
                this.lYL.removeHeaderView(this.lYM);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.mav == null) {
                this.mav = new ae(this.lMX.getPageContext(), this.jMg);
            }
            this.mav.PE(fVar.dlg());
            if (this.lMX.dnJ()) {
                if (this.lZa == null) {
                    this.lZa = new com.baidu.tieba.pb.view.e(this.lMX.getPageContext());
                    this.lZa.createView();
                    this.lZa.setListPullRefreshListener(this.fjz);
                }
                this.lYL.setPullRefresh(this.lZa);
                dqT();
                if (this.lZa != null) {
                    this.lZa.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().bmG() == 0 && z) {
                this.lYL.setPullRefresh(null);
            } else {
                if (this.lZa == null) {
                    this.lZa = new com.baidu.tieba.pb.view.e(this.lMX.getPageContext());
                    this.lZa.createView();
                    this.lZa.setListPullRefreshListener(this.fjz);
                }
                this.lYL.setPullRefresh(this.lZa);
                dqT();
                if (this.lZa != null) {
                    this.lZa.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                ckq();
            }
            dqY();
            this.lYW.uK(this.lNV);
            this.lYW.uL(false);
            this.lYW.uP(i == 5);
            this.lYW.uQ(i == 6);
            this.lYW.uR(z2 && this.maM && i != 2);
            this.lYW.a(fVar, false);
            this.lYW.notifyDataSetChanged();
            this.lYQ.b(b(fVar, z), fVar.dlC());
            if (fVar.dkZ() != null && fVar.dkZ().bnB() != null && this.lYF != -1) {
                fVar.dkZ().bnB().setIsLike(this.lYF);
            }
            this.lYL.removeFooterView(this.bMM);
            this.lYL.addFooterView(this.bMM);
            if (TbadkCoreApplication.isLogin()) {
                this.lYL.setNextPage(this.jof);
                this.lYG = 2;
                ckq();
            } else {
                this.lZI = true;
                if (fVar.getPage().bmF() == 1) {
                    if (this.lZb == null) {
                        this.lZb = new com.baidu.tieba.pb.view.a(this.lMX, this.lMX);
                    }
                    this.lYL.setNextPage(this.lZb);
                } else {
                    this.lYL.setNextPage(this.jof);
                }
                this.lYG = 3;
            }
            ArrayList<PostData> dlb = fVar.dlb();
            if (fVar.getPage().bmF() == 0 || dlb == null || dlb.size() < fVar.getPage().bmE()) {
                if (com.baidu.tbadk.core.util.y.getCount(dlb) == 0 || (com.baidu.tbadk.core.util.y.getCount(dlb) == 1 && dlb.get(0) != null && dlb.get(0).dNx() == 1)) {
                    if (this.lZS == null || this.lZS.mbd == null || this.lZS.mbd.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.lZS.mbd.getView().getTop() < 0 ? this.lZS.mbd.getView().getHeight() : this.lZS.mbd.getView().getBottom();
                    }
                    if (this.lMX.dnT()) {
                        this.jof.at(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.jof.at(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.lMX.dni() != null && !this.lMX.dni().dsc()) {
                        this.lMX.dni().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().bmF() == 0) {
                        this.jof.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jof.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jof.bue();
                }
                if (fVar.getPage().bmF() == 0 || dlb == null) {
                    dri();
                }
            } else {
                if (z2) {
                    if (this.maM) {
                        endLoadData();
                        if (fVar.getPage().bmF() != 0) {
                            this.jof.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.jof.setLineVisible();
                        this.jof.showLoading();
                    }
                } else {
                    this.jof.setLineVisible();
                    this.jof.showLoading();
                }
                this.jof.bue();
            }
            switch (i) {
                case 2:
                    this.lYL.setSelection(i2 > 1 ? (((this.lYL.getData() == null && fVar.dlb() == null) ? 0 : (this.lYL.getData().size() - fVar.dlb().size()) + this.lYL.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (dpT2 = aj.dpS().dpT()) != null && !(dpT2 instanceof RecyclerView.SavedState)) {
                        this.lYL.onRestoreInstanceState(dpT2);
                        if (com.baidu.tbadk.core.util.y.getCount(dlb) > 1 && fVar.getPage().bmF() > 0) {
                            this.jof.endLoadData();
                            this.jof.setText(this.lMX.getString(R.string.pb_load_more_without_point));
                            this.jof.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.maM = false;
                    break;
                case 5:
                    this.lYL.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (dpT = aj.dpS().dpT()) != null && !(dpT instanceof RecyclerView.SavedState)) {
                        this.lYL.onRestoreInstanceState(dpT);
                        break;
                    } else {
                        this.lYL.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.lYN != null && this.lYN.getContainerView() != null) {
                            if (this.lMX.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.lYL.setSelectionFromTop((this.lYW.dmP() + this.lYL.getHeaderViewsCount()) - 1, this.lYN.drU() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.lMX.getPageContext().getPageActivity()));
                            } else {
                                this.lYL.setSelectionFromTop((this.lYW.dmP() + this.lYL.getHeaderViewsCount()) - 1, this.lYN.drU());
                            }
                        } else {
                            this.lYL.setSelection(this.lYW.dmP() + this.lYL.getHeaderViewsCount());
                        }
                    } else {
                        this.lYL.setSelection(i2 > 0 ? ((this.lYL.getData() == null && fVar.dlb() == null) ? 0 : (this.lYL.getData().size() - fVar.dlb().size()) + this.lYL.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.jof.endLoadData();
                    this.jof.setText(this.lMX.getString(R.string.pb_load_more_without_point));
                    this.jof.setLineGone();
                    break;
            }
            if (this.lZU == lZV && isHost()) {
                drp();
            }
            if (this.mag) {
                dqf();
                this.mag = false;
                if (i3 == 0) {
                    vy(true);
                }
            }
            if (fVar.lJW == 1 || fVar.lJX == 1) {
                if (this.mam == null) {
                    this.mam = new PbTopTipView(this.lMX.getContext());
                }
                if (fVar.lJX == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.lMX.getStType())) {
                    this.mam.setText(this.lMX.getString(R.string.pb_read_strategy_add_experience));
                    this.mam.a(this.bMd, this.mSkinType);
                } else if (fVar.lJW == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.lMX.getStType())) {
                    this.mam.setText(this.lMX.getString(R.string.pb_read_news_add_experience));
                    this.mam.a(this.bMd, this.mSkinType);
                }
            }
            this.lYL.removeFooterView(this.maD.getView());
            if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dlH()) && fVar.getPage().bmF() == 0) {
                this.lYL.removeFooterView(this.bMM);
                this.maD.GB(Math.max(this.lZv.getMeasuredHeight(), this.lZG / 2));
                this.lYL.addFooterView(this.maD.getView());
                this.maD.H(fVar);
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dkZ() != null) {
            x(fVar);
            if (fVar.bjZ()) {
                WebPManager.a(this.lZz, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lZz, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String Gd = Gd(fVar.dkZ().bnH());
            if (this.lZC != null) {
                this.lZC.setText(Gd);
            }
            if (this.lZD != null) {
                this.lZD.setText(Gd);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dkZ()));
        }
    }

    private String Gd(int i) {
        if (i == 0) {
            return this.lMX.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void dqT() {
        if (this.lYN != null) {
            this.lYN.a(this.lYL, this.textView, this.mType);
        }
    }

    public void vG(boolean z) {
        this.lZo = z;
    }

    public void endLoadData() {
        if (this.jof != null) {
            this.jof.setLineGone();
            this.jof.endLoadData();
        }
        ckq();
    }

    public void bYh() {
        this.lYL.setVisibility(0);
    }

    public void dqU() {
        if (this.lYL != null) {
            this.lYL.setVisibility(8);
        }
        if (this.lYL != null) {
            this.lZL.setVisibility(8);
        }
        if (this.lYH != null && this.lYH.jwO != null) {
            this.lYH.jwO.setVisibility(8);
        }
    }

    public void dqV() {
        if (this.lYL != null) {
            this.lYL.setVisibility(0);
        }
        if (this.lZL != null) {
            this.lZL.setVisibility(0);
        }
        if (this.lYH != null && this.lYH.jwO != null) {
            this.lYH.jwO.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.lZH != null && this.lZH.bnQ() != null && this.lYH != null) {
            this.maj = !this.mai;
            this.lYH.vY(this.maj);
            if (this.lMX.dni() != null) {
                this.lMX.dni().vX(this.maj);
            }
            dqW();
            if (this.lMX != null && !this.lMX.dmi() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dlw())) {
                bx bxVar = fVar.dlw().get(0);
                if (bxVar != null) {
                    this.lYH.fV(bxVar.getForumName(), bxVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.lYH.fV(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.maj) {
                this.lYQ.a(fVar, this.lZH, this.lZp);
                if (this.lZN != null) {
                    this.lZN.setVisibility(8);
                }
                if (this.mat == null) {
                    this.mat = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.ap.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (ap.this.lMX != null && ap.this.lMX.isAdded()) {
                                if (i < 0 && f > ap.this.mal) {
                                    ap.this.drd();
                                    ap.this.dro();
                                }
                                ap.this.dqN();
                            }
                        }
                    };
                }
                this.lYL.setListViewDragListener(this.mat);
                return;
            }
            if (this.lZN != null) {
                this.lZN.setVisibility(0);
            }
            this.lYQ.a(fVar, this.lZH, this.lZp);
            this.mat = null;
            this.lYL.setListViewDragListener(null);
        }
    }

    private void dqW() {
        this.lYQ.a(this.lOq, this.lZH, this.maj, this.mai);
    }

    public boolean dqX() {
        return this.lOq == null || this.lOq.getForum() == null || "0".equals(this.lOq.getForum().getId()) || "me0407".equals(this.lOq.getForum().getName());
    }

    private boolean dqY() {
        return this.lYO.vT(this.lNV);
    }

    private boolean w(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dkZ() == null) {
            return false;
        }
        if (fVar.dkZ().bnN() == 1 || fVar.dkZ().getThreadType() == 33) {
            return true;
        }
        return !(fVar.dkZ().bnP() == null || fVar.dkZ().bnP().bqj() == 0) || fVar.dkZ().bnL() == 1 || fVar.dkZ().bnM() == 1 || fVar.dkZ().boD() || fVar.dkZ().boZ() || fVar.dkZ().boS() || fVar.dkZ().bob() != null || !com.baidu.tbadk.core.util.au.isEmpty(fVar.dkZ().getCategory()) || fVar.dkZ().bnT() || fVar.dkZ().bnS();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.lYP != null) {
                if (fVar.dkZ() != null && fVar.dkZ().boe() == 0 && !fVar.dkZ().bmv() && !this.maF) {
                    if (fVar.dkZ() != null) {
                        cb dkZ = fVar.dkZ();
                        dkZ.y(true, w(fVar));
                        dkZ.nj(3);
                        dkZ.Ah("2");
                    }
                    if (fVar.dkZ().bmx()) {
                        this.lYQ.c(this.lYL);
                        this.lYP.c(this.lYL);
                        this.lYP.b(this.lYL);
                        this.lYQ.b(this.lYL);
                        this.lYQ.G(this.lOq);
                        if (A(fVar)) {
                            this.lYP.c(this.lYL);
                        } else {
                            this.lYP.D(fVar);
                        }
                    } else {
                        this.lYQ.G(this.lOq);
                        if (A(fVar)) {
                            this.lYP.c(this.lYL);
                        } else {
                            this.lYP.F(fVar);
                        }
                    }
                } else if (fVar.dkZ().boe() == 1) {
                    if (fVar.dkZ() != null) {
                        this.lYP.c(this.lYL);
                        this.lYQ.G(this.lOq);
                    }
                } else {
                    this.lYP.c(this.lYL);
                    this.lYQ.G(this.lOq);
                }
            }
            z(fVar);
            this.lNV = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            dqY();
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dlo()));
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dlo()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bx> dlw = fVar.dlw();
                if (com.baidu.tbadk.core.util.y.getCount(dlw) > 0) {
                    sb = new StringBuilder();
                    for (bx bxVar : dlw) {
                        if (bxVar != null && !StringUtils.isNull(bxVar.getForumName()) && (adVar = bxVar.ePM) != null && adVar.eNw && !adVar.eNx && (adVar.type == 1 || adVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bxVar.getForumName(), 12)).append(this.lMX.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.lMX.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View dqZ() {
        return this.fIC;
    }

    public boolean dra() {
        if (this.bMM == null || this.bMM.getParent() == null || this.jof.isLoading()) {
            return false;
        }
        int bottom = this.bMM.getBottom();
        Rect rect = new Rect();
        this.bMM.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void PG(String str) {
        if (this.jof != null) {
            this.jof.setText(str);
        }
    }

    public void PH(String str) {
        if (this.jof != null) {
            int i = 0;
            if (this.lZS != null && this.lZS.mbd != null && this.lZS.mbd.getView() != null) {
                i = this.lZS.mbd.getView().getTop() < 0 ? this.lZS.mbd.getView().getHeight() : this.lZS.mbd.getView().getBottom();
            }
            this.jof.at(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.lYL;
    }

    public int drb() {
        return R.id.richText;
    }

    public TextView dmA() {
        return this.lYQ.dmA();
    }

    public void d(BdListView.e eVar) {
        this.lYL.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.fjz = cVar;
        if (this.lZa != null) {
            this.lZa.setListPullRefreshListener(cVar);
        }
    }

    public void a(az azVar, a.b bVar) {
        if (azVar != null) {
            int bmD = azVar.bmD();
            int bmA = azVar.bmA();
            if (this.lYX != null) {
                this.lYX.bqx();
            } else {
                this.lYX = new com.baidu.tbadk.core.dialog.a(this.lMX.getPageContext().getPageActivity());
                this.lYY = LayoutInflater.from(this.lMX.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.lYX.bn(this.lYY);
                this.lYX.a(R.string.dialog_ok, bVar);
                this.lYX.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        ap.this.drd();
                        aVar.dismiss();
                    }
                });
                this.lYX.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.ap.23
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ap.this.mad == null) {
                            ap.this.mad = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.23.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ap.this.lMX.HidenSoftKeyPad((InputMethodManager) ap.this.lMX.getBaseFragmentActivity().getSystemService("input_method"), ap.this.bMd);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.mA().postDelayed(ap.this.mad, 150L);
                    }
                });
                this.lYX.b(this.lMX.getPageContext()).bqx();
            }
            this.lYZ = (EditText) this.lYY.findViewById(R.id.input_page_number);
            this.lYZ.setText("");
            TextView textView = (TextView) this.lYY.findViewById(R.id.current_page_number);
            if (bmD <= 0) {
                bmD = 1;
            }
            if (bmA <= 0) {
                bmA = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(bmD), Integer.valueOf(bmA)));
            this.lMX.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.lYZ, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.lYL.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.lMX.showToast(str);
    }

    public boolean vH(boolean z) {
        if (this.acR == null || !this.acR.bBl()) {
            return false;
        }
        this.acR.bzD();
        return true;
    }

    public void drc() {
        if (this.maO != null) {
            while (this.maO.size() > 0) {
                TbImageView remove = this.maO.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        drc();
        this.lYW.FB(1);
        if (this.lYN != null) {
            this.lYN.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.lYW.FB(2);
        if (this.lYN != null) {
            this.lYN.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.lMX.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lMX.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.lZB != null) {
            this.lZB.onDestroy();
        }
        if (this.maf != null) {
            this.maf.destroy();
        }
        if (this.mav != null) {
            this.mav.onDestory();
        }
        if (this.mam != null) {
            this.mam.hide();
        }
        this.lMX.hideProgressBar();
        if (this.gxW != null && this.jdt != null) {
            this.gxW.b(this.jdt);
        }
        drd();
        endLoadData();
        if (this.mad != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mad);
        }
        if (this.lZK != null) {
            this.lZK.clearStatus();
        }
        this.maI = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.lYW.FB(3);
        if (this.bLj != null) {
            this.bLj.setBackgroundDrawable(null);
        }
        if (this.lYN != null) {
            this.lYN.destroy();
        }
        if (this.lYW != null) {
            this.lYW.onDestroy();
        }
        this.lYL.setOnLayoutListener(null);
        if (this.mar != null) {
            this.mar.cFx();
        }
        if (this.lZT != null) {
            this.lZT.onDestroy();
        }
        if (this.lYQ != null) {
            this.lYQ.onDestroy();
        }
    }

    public boolean Ge(int i) {
        if (this.lYN != null) {
            return this.lYN.Ge(i);
        }
        return false;
    }

    public void drd() {
        this.lYH.baM();
        if (this.lYQ != null) {
            this.lYQ.drd();
        }
        if (this.lMX != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lMX.getContext(), this.lYZ);
        }
        dqh();
        if (this.lRH != null) {
            this.lRH.dismiss();
        }
        drf();
        if (this.lYX != null) {
            this.lYX.dismiss();
        }
        if (this.jiU != null) {
            this.jiU.dismiss();
        }
    }

    public void dre() {
        this.lYH.baM();
        if (this.lYQ != null) {
            this.lYQ.drd();
        }
        if (this.lRH != null) {
            this.lRH.dismiss();
        }
        drf();
        if (this.lYX != null) {
            this.lYX.dismiss();
        }
        if (this.jiU != null) {
            this.jiU.dismiss();
        }
    }

    public void fn(List<String> list) {
        this.maq = list;
        if (this.mar != null) {
            this.mar.setData(list);
        }
    }

    public void uJ(boolean z) {
        this.lYW.uJ(z);
    }

    public void vI(boolean z) {
        this.lZr = z;
    }

    public void drf() {
        if (this.lZf != null) {
            this.lZf.dismiss();
        }
        if (this.lZg != null) {
            com.baidu.adp.lib.f.g.b(this.lZg, this.lMX.getPageContext());
        }
        if (this.lZh != null) {
            com.baidu.adp.lib.f.g.b(this.lZh, this.lMX.getPageContext());
        }
        if (this.lZe != null) {
            this.lZe.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            d(this.lOq, this.lNV);
            b(this.lOq, this.lNV, this.mType, i);
            this.lMX.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.lMX.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bMd);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bMd, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lZs, R.color.CAM_X0203);
            if (this.lYN != null) {
                this.lYN.onChangeSkinType(i);
            }
            if (this.lYR != null) {
                this.lYR.onChangeSkinType(i);
            }
            if (this.lYO != null) {
                this.lYO.onChangeSkinType(i);
            }
            if (this.lYP != null) {
                this.lYP.onChangeSkinType(i);
            }
            if (this.lYQ != null) {
                this.lYQ.onChangeSkinType(i);
            }
            if (this.lPS != null) {
                this.lPS.onChangeSkinType();
            }
            if (this.lPR != null) {
                this.lPR.bzn();
            }
            if (this.jof != null) {
                this.jof.changeSkin(i);
            }
            if (this.fIC != null) {
                this.lMX.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fIC);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.fIC, R.drawable.pb_foot_more_trans_selector);
            }
            if (this.lYX != null) {
                this.lYX.c(this.lMX.getPageContext());
            }
            vG(this.lZo);
            this.lYW.notifyDataSetChanged();
            if (this.lZa != null) {
                this.lZa.changeSkin(i);
            }
            if (this.acR != null) {
                this.acR.onChangeSkinType(i);
            }
            if (this.lZb != null) {
                this.lZb.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.izt)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.izt) {
                    customBlueCheckRadioButton.btO();
                }
            }
            dqz();
            UtilHelper.setStatusBarBackground(this.bLj, i);
            UtilHelper.setStatusBarBackground(this.lZN, i);
            if (this.lYS != null) {
                com.baidu.tbadk.r.a.a(this.lMX.getPageContext(), this.lYS);
            }
            if (this.mae != null) {
                this.mae.onChangeSkinType(i);
            }
            if (this.lYH != null) {
                if (this.lYN != null) {
                    this.lYN.Gf(i);
                } else {
                    this.lYH.onChangeSkinType(i);
                }
            }
            if (this.lZx != null) {
                this.lZx.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0401));
            }
            if (this.lZw != null) {
                this.lZw.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aL(com.baidu.adp.lib.util.l.getDimens(this.lMX.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0209)));
            }
            if (this.lOq != null && this.lOq.bjZ()) {
                WebPManager.a(this.lZz, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lZz, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.a(this.lZy, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            x(this.lOq);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lZv, R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lZu, R.color.CAM_X0203);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mao, R.color.cp_cont_n);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kpg, R.color.CAM_X0109);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lZD, R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lZC, R.color.CAM_X0107);
            com.baidu.tbadk.core.util.ap.d(this.lZC, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (this.mas != null) {
                this.mas.onChangeSkinType(i);
            }
            if (this.lZT != null) {
                this.lZT.onChangeSkinType();
            }
            if (this.lYM != null) {
                this.lYM.uu(i);
            }
            if (this.lZB != null) {
                this.lZB.onChangeSkinType();
            }
            if (this.maD != null) {
                this.maD.onChangeSkinType();
            }
        }
    }

    public void drg() {
        if (this.lZB != null) {
            this.lZB.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bd(fVar.dkZ())) {
            if (this.lZB != null) {
                this.lZB.setEnable(false);
                this.lZB.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.lZA.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.lZA.setLayoutParams(layoutParams);
            WebPManager.a(this.lZA, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.lZB == null || !this.lZB.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.lZA.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.lZA.setLayoutParams(layoutParams2);
            WebPManager.a(this.lZA, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fUw = iVar;
        this.lYW.setOnImageClickListener(this.fUw);
        this.mas.setOnImageClickListener(this.fUw);
    }

    public void g(NoNetworkView.a aVar) {
        this.jdt = aVar;
        if (this.gxW != null) {
            this.gxW.a(this.jdt);
        }
    }

    public void vJ(boolean z) {
        this.lYW.setIsFromCDN(z);
    }

    public Button drh() {
        return this.lZt;
    }

    public void dri() {
        if (this.lYG != 2) {
            this.lYL.setNextPage(this.jof);
            this.lYG = 2;
        }
    }

    public boolean drj() {
        return this.acR != null && this.acR.getVisibility() == 0;
    }

    public boolean drk() {
        return this.acR != null && this.acR.bBl();
    }

    public void drl() {
        if (this.acR != null) {
            this.acR.bzD();
        }
    }

    public void vK(boolean z) {
        if (this.lZv != null) {
            vI(this.lMX.dnf().bBV());
            if (this.lZr) {
                vz(z);
            } else {
                vA(z);
            }
        }
    }

    public void drm() {
        if (this.lZv != null) {
            this.lZu.setVisibility(8);
            this.lZv.setVisibility(8);
            this.lZE = false;
            if (this.lZT != null) {
                this.lZT.setVisibility(8);
                vE(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.iDG == null) {
            this.iDG = new com.baidu.tbadk.core.view.a(this.lMX.getPageContext());
        }
        this.iDG.setDialogVisiable(true);
    }

    public void ckq() {
        if (this.iDG != null) {
            this.iDG.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.lYL.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.lYL.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lYN != null) {
            this.lYN.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.mLastScrollY = getScrollY();
            this.lZS.mbd = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lZS));
            a(this.lZS.mbd, true);
            drB();
        }
    }

    public void vL(boolean z) {
        if (this.lYN != null) {
            this.lYN.vL(z);
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
        if (this.lYN != null) {
            this.lYN.onScroll(absListView, i, i2, i3);
        }
        if (this.lYH != null && this.lYQ != null) {
            this.lYH.dN(this.lYQ.drQ());
        }
        this.lZS.lDa = i;
        this.lZS.headerCount = this.lYL.getHeaderViewsCount();
        this.lZS.mbd = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lZS));
        vB(b(absListView, i));
        a(this.lZS.mbd, false);
        drB();
        if (this.jof.buf() && !this.jof.fiy) {
            if (this.lZS != null && this.lZS.mbd != null && this.lZS.mbd.getView() != null) {
                i4 = this.lZS.mbd.getView().getTop() < 0 ? this.lZS.mbd.getView().getHeight() : this.lZS.mbd.getView().getBottom();
            }
            this.jof.pD(i4);
            this.jof.fiy = true;
        }
    }

    public void drn() {
        if (TbadkCoreApplication.isLogin() && this.lOq != null && this.maj && !this.mai && !this.lZp && this.lZH != null && this.lZH.bnQ() != null && !this.lZH.bnQ().getIsLike() && !this.lZH.bnQ().hadConcerned() && this.maf == null) {
            this.maf = new al(this.lMX);
        }
    }

    public void dro() {
        if (this.lMX != null) {
            if ((this.jfV || this.maA == 17) && com.baidu.tbadk.a.d.bjb()) {
                if (this.lOq != null && this.lOq.getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(this.lOq.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.lMX.getContext()).createNormalCfg(this.lOq.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13853").dR("post_id", this.lOq.getThreadId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", this.lOq.getForum().getId()));
                }
            } else if (this.maj && !this.mai && this.lZH != null && this.lZH.bnQ() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12601").ap("obj_locate", this.lMX.dmi() ? 2 : 1).ap("obj_type", this.mai ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.lMX.getPageContext().getPageActivity(), this.lZH.bnQ().getUserId(), this.lZH.bnQ().getUserName(), this.lMX.dmq().dmj(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z) {
        int measuredHeight;
        if (!this.mai && this.lZM != null && this.lYH.dsi() != null) {
            int dmQ = this.lYW.dmQ();
            if (dmQ > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                if (dmQ > this.lYL.getFirstVisiblePosition() - this.lYL.getHeaderViewsCount()) {
                    this.lZM.setVisibility(4);
                    return;
                }
                this.lZM.setVisibility(0);
                vB(false);
                this.lYH.mNavigationBar.hideBottomLine();
                if (this.lZM.getParent() != null && ((ViewGroup) this.lZM.getParent()).getHeight() <= this.lZM.getTop()) {
                    this.lZM.getParent().requestLayout();
                }
            } else if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView() == null || pbReplyTitleViewHolder.lYh == null) {
                if (this.lYL.getFirstVisiblePosition() == 0) {
                    this.lZM.setVisibility(4);
                    this.lYH.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = pbReplyTitleViewHolder.getView().getTop();
                if (pbReplyTitleViewHolder.getView().getParent() != null) {
                    if (this.lZR) {
                        this.lZQ = top;
                        this.lZR = false;
                    }
                    this.lZQ = top < this.lZQ ? top : this.lZQ;
                }
                if (top != 0 || pbReplyTitleViewHolder.getView().isShown()) {
                    if (this.lYV.getY() < 0.0f) {
                        measuredHeight = lZP - pbReplyTitleViewHolder.lYh.getMeasuredHeight();
                    } else {
                        measuredHeight = this.lYH.dsi().getMeasuredHeight() - pbReplyTitleViewHolder.lYh.getMeasuredHeight();
                        this.lYH.mNavigationBar.hideBottomLine();
                    }
                    if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.lZQ) {
                        this.lZM.setVisibility(0);
                        vB(false);
                    } else if (top < measuredHeight) {
                        this.lZM.setVisibility(0);
                        vB(false);
                    } else {
                        this.lZM.setVisibility(4);
                        this.lYH.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.lZR = true;
                    }
                }
            }
        }
    }

    public void drp() {
        if (!this.maP) {
            TiebaStatic.log("c10490");
            this.maP = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lMX.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(lZW, Integer.valueOf(lZY));
            aVar.nw(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.lMX.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.bn(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.lMX);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.24
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lMX.getPageContext()).bqx();
        }
    }

    public void PI(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lMX.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.lMX.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.bn(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(lZW, Integer.valueOf(lZZ));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.lMX);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ap.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lMX.getPageContext()).bqx();
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
        this.lYQ.onChangeSkinType(i2);
    }

    public PbInterviewStatusView drq() {
        return this.lZK;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dkZ() != null && fVar.dkZ().boZ() && this.lZK == null) {
            this.lZK = (PbInterviewStatusView) this.lZJ.inflate();
            this.lZK.setOnClickListener(this.jiV);
            this.lZK.setCallback(this.lMX.dnR());
            this.lZK.setData(this.lMX, fVar);
        }
    }

    public RelativeLayout drr() {
        return this.lYV;
    }

    public View drs() {
        return this.bLj;
    }

    public boolean drt() {
        return this.maF;
    }

    public void uO(boolean z) {
        this.lYQ.uO(z);
    }

    public void PJ(String str) {
        if (this.lYI != null) {
            this.lYI.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int vM(boolean z) {
        if (this.lZK == null || this.lZK.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void dru() {
        if (this.lZK != null && this.lZK.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lZK.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.lZK.setLayoutParams(layoutParams);
        }
    }

    public boolean dnl() {
        return false;
    }

    public void PK(String str) {
        this.kpg.performClick();
        if (!StringUtils.isNull(str) && this.lMX.dnf() != null && this.lMX.dnf().bBN() != null && this.lMX.dnf().bBN().getInputView() != null) {
            EditText inputView = this.lMX.dnf().bBN().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            drd();
            if (configuration.orientation == 2) {
                drm();
                dqh();
            } else {
                dql();
            }
            if (this.mae != null) {
                this.mae.dna();
            }
            this.lMX.cCV();
            this.lYV.setVisibility(8);
            this.lYH.vZ(false);
            this.lMX.ve(false);
            if (this.lYN != null) {
                if (configuration.orientation == 1) {
                    drr().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.lYL.setIsLandscape(true);
                    this.lYL.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.lYL.setIsLandscape(false);
                    if (this.mLastScrollY > 0) {
                        this.lYL.smoothScrollBy(this.mLastScrollY, 0);
                    }
                }
                this.lYN.onConfigurationChanged(configuration);
                this.lZL.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void vN(boolean z) {
        if (this.lYN != null) {
            this.lYN.vN(z);
        }
    }

    public boolean drv() {
        return this.lYN != null && this.lYN.drv();
    }

    public void drw() {
        if (this.lYN != null) {
            this.lYN.drw();
        }
    }

    public void uS(boolean z) {
        this.lYW.uS(z);
    }

    public void dM(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.lZv.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.lMX.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.mao = new TextView(this.lMX.getContext());
            this.mao.setText(R.string.connection_tips);
            this.mao.setGravity(17);
            this.mao.setPadding(com.baidu.adp.lib.util.l.getDimens(this.lMX.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.lMX.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lMX.getContext(), R.dimen.ds60);
            if (this.mao.getParent() == null) {
                frameLayout.addView(this.mao, layoutParams);
            }
            this.man = new PopupWindow(this.lMX.getContext());
            this.man.setContentView(frameLayout);
            this.man.setHeight(-2);
            this.man.setWidth(-2);
            this.man.setFocusable(true);
            this.man.setOutsideTouchable(false);
            this.man.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.lYL.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.ap.26
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        ap.this.man.showAsDropDown(ap.this.lZv, view.getLeft(), -ap.this.lZv.getHeight());
                    } else {
                        ap.this.man.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void vO(boolean z) {
        this.mau = z;
    }

    public boolean drx() {
        return this.mau;
    }

    public PbThreadPostView dry() {
        return this.lYM;
    }

    private void z(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dkZ() != null && !fVar.dkZ().bmv()) {
            boolean z = fVar.dkZ().bnM() == 1;
            boolean z2 = fVar.dkZ().bnL() == 1;
            if (this.lYQ != null) {
                this.lYQ.c(fVar, z, z2);
            }
            if (this.lYW != null && this.lYW.dmV() != null) {
                this.lYW.dmV().b(fVar, z, z2);
            }
        }
    }

    public void vP(boolean z) {
        this.jfV = z;
    }

    public void FW(int i) {
        this.maA = i;
    }

    public void drz() {
        if (this.lYL != null) {
            this.lYL.setForbidDragListener(true);
        }
    }

    public boolean dol() {
        if (this.lYL == null) {
            return false;
        }
        return this.lYL.dol();
    }

    public boolean drA() {
        if (this.jof == null || TextUtils.isEmpty(this.jof.getEndText())) {
            return false;
        }
        return this.jof.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }

    private boolean A(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dkZ() == null) {
            return false;
        }
        SpannableStringBuilder boz = fVar.dkZ().boz();
        if (boz != null) {
            return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(boz.toString());
        }
        return true;
    }

    public void drB() {
        boolean z;
        if (this.maD != null) {
            if (((this.maD.getView() == null || this.maD.getView().getParent() == null) ? -1 : this.lYL.getPositionForView(this.maD.getView())) != -1) {
                if (this.maD.getView().getTop() + maB <= this.lZM.getBottom()) {
                    this.maC = 1;
                    z = true;
                } else {
                    this.maC = 0;
                    z = false;
                }
            } else {
                z = this.maC == 1;
            }
            this.lZO.vx(this.maC == 1);
            this.maD.setScrollable(z);
        }
    }

    public LinearLayout drC() {
        return this.lZw;
    }
}
