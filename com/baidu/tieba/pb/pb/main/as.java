package com.baidu.tieba.pb.pb.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.FloatingLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.a;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.e;
import com.baidu.tieba.pb.pb.main.emotion.b.a;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.xiaomi.mipush.sdk.Constants;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpStatus;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class as {
    private static final int fQn = UtilHelper.getLightStatusBarHeight();
    public static int fQt = 3;
    public static int fQu = 0;
    public static int fQv = 3;
    public static int fQw = 4;
    public static int fQx = 5;
    public static int fQy = 6;
    private com.baidu.tbadk.editortools.i axO;
    private com.baidu.tieba.pb.a.c bJy;
    private i.b baS;
    private TextView bmg;
    private View bwW;
    private List<com.baidu.tieba.pb.pb.main.view.a> cRE;
    private View cVP;
    private PbListView dBm;
    private NavigationBarCoverTip dNM;
    private NoNetworkView dhH;
    private RelativeLayout dhJ;
    private TextView djB;
    private View.OnClickListener dyk;
    private View dyx;
    private View.OnClickListener fDA;
    private PbActivity fHW;
    PbActivity.d fHb;
    private UserIconBox fJd;
    private UserIconBox fJe;
    private PbFakeFloorModel fKa;
    private com.baidu.tieba.pb.data.f fLg;
    public int fOA;
    private com.baidu.tieba.pb.video.i fOB;
    private long fOC;
    private com.baidu.tieba.pb.video.h fOD;
    private com.baidu.tieba.d.b fOE;
    public final com.baidu.tieba.pb.pb.main.view.c fOH;
    public com.baidu.tieba.pb.pb.main.view.b fOI;
    private ViewStub fOJ;
    private ViewStub fOK;
    private PbLandscapeListView fOL;
    private View fOM;
    private LinearLayout fOP;
    private f fOQ;
    private ColumnLayout fOR;
    private ThreadSkinView fOS;
    private TextView fOT;
    private TextView fOU;
    private ImageView fOV;
    private HeadPendantView fOW;
    private FrameLayout fOX;
    private HeadImageView fOY;
    private View fOZ;
    private View fPS;
    private TextView fPT;
    private ImageView fPU;
    private ImageView fPV;
    private TextView fPW;
    private boolean fPY;
    private int fPZ;
    private FloatingLayout fPa;
    private PbFirstFloorUserLikeButton fPd;
    private aq fPe;
    private aq fPf;
    private TextView fPg;
    private TextView fPh;
    private TextView fPi;
    private View fPj;
    private View fPk;
    private LinearLayout fPl;
    private TextView fPm;
    private TextView fPn;
    private View fPo;
    private View fPp;
    private ObservedChangeLinearLayout fPr;
    private h fPs;
    private View fPy;
    private Runnable fQA;
    private s fQB;
    private an fQC;
    private int fQI;
    private PbTopTipView fQK;
    private PopupWindow fQL;
    private PopupWindow fQM;
    private TextView fQN;
    private List<String> fQO;
    private com.baidu.tieba.pb.pb.main.emotion.c fQP;
    private com.baidu.tieba.pb.pb.godreply.a fQQ;
    private PbLandscapeListView.b fQR;
    private ac fQT;
    private boolean fQV;
    private e fQW;
    private com.baidu.tbadk.core.view.userLike.c fQX;
    private com.baidu.tbadk.core.view.userLike.c fQY;
    private int fQa;
    private PostData fQb;
    private View fQd;
    private TextView fQe;
    private ViewStub fQf;
    private PbInterviewStatusView fQg;
    private ViewGroup fQh;
    private TextView fQi;
    private FrameLayout fQj;
    private View fQk;
    private View fQl;
    private al fQm;
    private com.baidu.tieba.pb.pb.main.emotion.b.a fQr;
    private int fQz;
    private Runnable fRd;
    private PbActivity.b fRf;
    private int fgd;
    private boolean isLandscape;
    private int mType;
    private boolean fOF = false;
    private int fOG = 0;
    private final Handler mHandler = new Handler();
    private LinearLayout fON = null;
    private TextView fOO = null;
    public FrsPraiseView fPb = null;
    private ClickableHeaderImageView fPc = null;
    private View fPq = null;
    private com.baidu.tbadk.core.dialog.a fPt = null;
    private com.baidu.tbadk.core.dialog.b dyj = null;
    private View fPu = null;
    private EditText fPv = null;
    private com.baidu.tieba.pb.view.i fPw = null;
    private com.baidu.tieba.pb.view.b fPx = null;
    private com.baidu.tbadk.core.dialog.a fPz = null;
    private b.InterfaceC0074b eAJ = null;
    private TbRichTextView.h bJx = null;
    private NoNetworkView.a duP = null;
    private Dialog fPA = null;
    private View fPB = null;
    private com.baidu.tbadk.core.dialog.a fPC = null;
    private Dialog fPD = null;
    private Dialog fPE = null;
    private View fPF = null;
    private LinearLayout fPG = null;
    private CompoundButton.OnCheckedChangeListener cRF = null;
    private TextView fPH = null;
    private TextView fPI = null;
    private View fPJ = null;
    private String fPK = null;
    private com.baidu.tbadk.core.dialog.b fPL = null;
    private com.baidu.tbadk.core.dialog.b fPM = null;
    private boolean fPN = false;
    private boolean fPO = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView fPP = null;
    private boolean fPQ = false;
    private Button fPR = null;
    private boolean fPX = true;
    private com.baidu.tbadk.core.view.b cYR = null;
    private boolean fDw = false;
    private int mSkinType = 3;
    private boolean fQc = false;
    private int fQo = 0;
    private boolean fQp = true;
    private a fQq = new a();
    private int fQs = 0;
    private boolean fQD = false;
    private int fQE = 0;
    private boolean fQF = false;
    private boolean fQG = false;
    private boolean fQH = false;
    private int fQJ = 0;
    private boolean fQS = false;
    private a.InterfaceC0153a fQU = new a.InterfaceC0153a() { // from class: com.baidu.tieba.pb.pb.main.as.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0153a
        public void onRefresh() {
        }
    };
    private String fQZ = null;
    private CustomMessageListener fRa = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.as.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                as.this.fQZ = null;
            }
        }
    };
    private CustomMessageListener dJy = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.as.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && as.this.fPs != null) {
                as.this.fPs.notifyDataSetChanged();
            }
        }
    };
    private CustomMessageListener fRb = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.pb.main.as.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (as.this.fOO != null) {
                as.this.fOO.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            }
        }
    };
    private Handler fRc = new Handler();
    private CustomMessageListener fRe = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.as.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                as.this.fPX = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean fRg = true;
    View.OnClickListener fRh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.18
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (as.this.fQF) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11923").s("obj_id", 2));
            }
            if (view == as.this.fOH.fTK) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12506").s("obj_locate", 2));
            }
            if (as.this.fHW.fGa.fSS != null) {
                if (!as.this.fQF && as.this.fLg != null && as.this.fLg.aYA() != null && as.this.fLg.aYA().yX() != null && as.this.fLg.aYA().yX().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12151").s("obj_locate", 1));
                }
                as.this.fHW.fGa.fSS.onClick(view);
            }
        }
    };
    private boolean fRi = false;
    String userId = null;
    private final List<TbImageView> fRj = new ArrayList();
    private boolean fRk = false;

    /* loaded from: classes2.dex */
    public static class a {
        public int fRy;
        public al fRz;
        public int fxv;
    }

    public void km(boolean z) {
        this.fQD = z;
        if (this.fOL != null) {
            this.fQE = this.fOL.getHeaderViewsCount();
        }
    }

    public void bcV() {
        if (this.fOL != null) {
            int headerViewsCount = this.fOL.getHeaderViewsCount() - this.fQE;
            final int firstVisiblePosition = (this.fOL.getFirstVisiblePosition() == 0 || this.fOL.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.fOL.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.fOL.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.fQq.fRz = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fQq));
            final al alVar = this.fQq.fRz;
            final int f = f(alVar);
            final int y = ((int) this.fPr.getY()) + this.fPr.getMeasuredHeight();
            final boolean z = this.fQk.getVisibility() == 0;
            boolean z2 = this.fPr.getY() < 0.0f;
            if ((z && alVar != null) || firstVisiblePosition >= this.fPs.bbf() + this.fOL.getHeaderViewsCount()) {
                int measuredHeight = alVar != null ? alVar.fNX.getMeasuredHeight() : 0;
                if (z2) {
                    this.fOL.setSelectionFromTop(this.fPs.bbf() + this.fOL.getHeaderViewsCount(), fQn - measuredHeight);
                } else {
                    this.fOL.setSelectionFromTop(this.fPs.bbf() + this.fOL.getHeaderViewsCount(), this.fOH.bey().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.fOL.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.fQF) {
                this.fOL.setSelectionFromTop(this.fPs.bbf() + this.fOL.getHeaderViewsCount(), this.fOB.bfQ().getMeasuredHeight());
            } else if (this.mType == 6) {
                this.fOL.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.as.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void bbx() {
                        if (f >= 0 && f <= as.this.dhJ.getMeasuredHeight()) {
                            int f2 = as.this.f(alVar);
                            int i = f2 - f;
                            if (z && i != 0 && f <= y) {
                                i = f2 - y;
                            }
                            ViewGroup.LayoutParams layoutParams = as.this.cVP.getLayoutParams();
                            if (i == 0 || i > as.this.dhJ.getMeasuredHeight() || f2 >= as.this.dhJ.getMeasuredHeight()) {
                                layoutParams.height = as.this.fQz;
                            } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > as.this.dhJ.getMeasuredHeight()) {
                                layoutParams.height = as.this.fQz;
                            } else {
                                layoutParams.height = i + layoutParams.height;
                                as.this.fOL.setSelectionFromTop(firstVisiblePosition, top);
                            }
                            as.this.cVP.setLayoutParams(layoutParams);
                        }
                        as.this.fOL.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(al alVar) {
        if (alVar == null || alVar.getView() == null) {
            return 0;
        }
        if (alVar.getView().getTop() != 0 || alVar.getView().isShown()) {
            return alVar.getView().getBottom();
        }
        return 0;
    }

    public e bcW() {
        return this.fQW;
    }

    public NoNetworkView bcX() {
        return this.dhH;
    }

    public void bcY() {
        if (this.axO != null) {
            this.axO.hide();
            if (this.fQP != null) {
                this.fQP.VC();
            }
        }
    }

    public PbFakeFloorModel bcZ() {
        return this.fKa;
    }

    public s bda() {
        return this.fQB;
    }

    public void bdb() {
        reset();
        bcY();
        this.fQB.bbm();
        ky(false);
    }

    private void reset() {
        if (this.fHW != null && this.fHW.aZY() != null && this.axO != null) {
            com.baidu.tbadk.editortools.pb.a.La().setStatus(0);
            com.baidu.tbadk.editortools.pb.d aZY = this.fHW.aZY();
            aZY.Lt();
            aZY.KP();
            if (aZY.getWriteImagesInfo() != null) {
                aZY.getWriteImagesInfo().setMaxImagesAllowed(10);
            }
            aZY.hT(SendView.ALL);
            aZY.hU(SendView.ALL);
            com.baidu.tbadk.editortools.l hL = this.axO.hL(23);
            com.baidu.tbadk.editortools.l hL2 = this.axO.hL(2);
            com.baidu.tbadk.editortools.l hL3 = this.axO.hL(5);
            if (hL2 != null) {
                hL2.th();
            }
            if (hL3 != null) {
                hL3.th();
            }
            if (hL != null) {
                hL.hide();
            }
            this.axO.invalidate();
        }
    }

    public boolean bdc() {
        return this.fPX;
    }

    public void kn(boolean z) {
        if (this.fPS != null && this.fPT != null) {
            this.fPT.setText(d.j.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fPS.startAnimation(alphaAnimation);
            }
            this.fPS.setVisibility(0);
            this.fPX = true;
            if (this.fQr != null && !this.fQQ.isActive()) {
                this.fQr.setVisibility(0);
                ks(true);
            }
        }
    }

    public void ko(boolean z) {
        if (this.fPS != null && this.fPT != null) {
            this.fPT.setText(d.j.reply_floor_host);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.fPS.startAnimation(alphaAnimation);
            }
            this.fPS.setVisibility(0);
            this.fPX = true;
            if (this.fQr != null && !this.fQQ.isActive()) {
                this.fQr.setVisibility(0);
                ks(true);
            }
        }
    }

    public PostData bdd() {
        int i = 0;
        if (this.fOL == null) {
            return null;
        }
        int bde = bde() - this.fOL.getHeaderViewsCount();
        if (bde < 0) {
            bde = 0;
        }
        if (this.fPs.sP(bde) != null && this.fPs.sP(bde) != PostData.hiF) {
            i = bde + 1;
        }
        return this.fPs.getItem(i) instanceof PostData ? (PostData) this.fPs.getItem(i) : null;
    }

    public int bde() {
        int i;
        View childAt;
        if (this.fOL == null) {
            return 0;
        }
        int firstVisiblePosition = this.fOL.getFirstVisiblePosition();
        int lastVisiblePosition = this.fOL.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.fOL.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.fOL.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int bdf() {
        return this.fOL.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.fLg != null && this.fLg.aYC() != null && !this.fLg.aYC().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.fLg.aYC().size() && (postData = this.fLg.aYC().get(i)) != null && postData.yX() != null && !StringUtils.isNull(postData.yX().getUserId()); i++) {
                if (this.fLg.aYC().get(i).yX().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.fQQ != null && this.fQQ.isActive()) {
                        ky(false);
                    }
                    if (this.fQr != null) {
                        this.fQr.kF(true);
                    }
                    this.fQZ = postData.yX().getName_show();
                    return;
                }
            }
        }
    }

    public as(PbActivity pbActivity, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.fHW = null;
        this.dhJ = null;
        this.dyx = null;
        this.fOC = 0L;
        this.fOL = null;
        this.fOM = null;
        this.fOP = null;
        this.fOR = null;
        this.fOT = null;
        this.fOU = null;
        this.fOX = null;
        this.fOY = null;
        this.fOZ = null;
        this.fPd = null;
        this.fPg = null;
        this.fPh = null;
        this.fPi = null;
        this.fPj = null;
        this.fPo = null;
        this.fPp = null;
        this.fPs = null;
        this.dBm = null;
        this.bwW = null;
        this.dyk = null;
        this.fDA = null;
        this.fPS = null;
        this.fPT = null;
        this.fPU = null;
        this.fPV = null;
        this.fPW = null;
        this.fQd = null;
        this.fQe = null;
        this.fQf = null;
        this.fQI = 0;
        this.fOC = System.currentTimeMillis();
        this.fHW = pbActivity;
        this.dyk = onClickListener;
        this.bJy = cVar;
        this.fQI = com.baidu.adp.lib.util.l.ao(this.fHW) / 2;
        this.dhJ = (RelativeLayout) LayoutInflater.from(this.fHW.getPageContext().getPageActivity()).inflate(d.h.new_pb_activity, (ViewGroup) null);
        this.fHW.addContentView(this.dhJ, new FrameLayout.LayoutParams(-1, -1));
        this.dNM = (NavigationBarCoverTip) this.fHW.findViewById(d.g.pb_multi_forum_del_tip_view);
        this.dyx = this.fHW.findViewById(d.g.statebar_view);
        this.fPr = (ObservedChangeLinearLayout) this.fHW.findViewById(d.g.title_wrapper);
        this.dhH = (NoNetworkView) this.fHW.findViewById(d.g.view_no_network);
        this.fOL = (PbLandscapeListView) this.fHW.findViewById(d.g.new_pb_list);
        this.fQj = (FrameLayout) this.fHW.findViewById(d.g.root_float_header);
        this.bmg = new TextView(this.fHW.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.s(this.fHW.getActivity(), d.e.ds88));
        this.fOL.addHeaderView(this.bmg, 0);
        this.fQz = this.fHW.getResources().getDimensionPixelSize(d.e.tbds134);
        this.cVP = new View(this.fHW.getPageContext().getPageActivity());
        this.cVP.setLayoutParams(new AbsListView.LayoutParams(-1, this.fQz));
        this.cVP.setVisibility(4);
        this.fOL.addFooterView(this.cVP);
        this.fOL.setOnTouchListener(this.fHW.bBc);
        this.fOH = new com.baidu.tieba.pb.pb.main.view.c(pbActivity);
        if (this.fHW.baB()) {
            this.fOJ = (ViewStub) this.fHW.findViewById(d.g.manga_view_stub);
            this.fOJ.setVisibility(0);
            this.fOI = new com.baidu.tieba.pb.pb.main.view.b(pbActivity);
            this.fOI.show();
            this.fOH.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.s(this.fHW.getActivity(), d.e.ds120);
        }
        this.bmg.setLayoutParams(layoutParams);
        this.fOH.bey().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0137a() { // from class: com.baidu.tieba.pb.pb.main.as.30
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0137a
            public void atY() {
                if (as.this.fOL != null) {
                    if (as.this.fOB != null) {
                        as.this.fOB.bfR();
                    }
                    as.this.fOL.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0137a
            public void atX() {
                as.this.fHW.atl();
            }
        }));
        this.fPS = this.fHW.findViewById(d.g.pb_editor_tool_comment);
        this.fPZ = com.baidu.adp.lib.util.l.s(this.fHW.getPageContext().getPageActivity(), d.e.ds90);
        this.fQa = com.baidu.adp.lib.util.l.s(this.fHW.getPageContext().getPageActivity(), d.e.ds242);
        this.fPT = (TextView) this.fHW.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_reply_text);
        this.fPV = (ImageView) this.fHW.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_more_img);
        this.fPU = (ImageView) this.fHW.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_emotion_img);
        this.fPW = (TextView) this.fHW.getPageContext().getPageActivity().findViewById(d.g.pb_editor_tool_comment_praise_icon);
        this.fPW.setVisibility(8);
        this.fPT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                as.this.beh();
                if (!as.this.fHW.checkUpIsLogin()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10517").s("obj_locate", 2).ab(ImageViewerConfig.FORUM_ID, as.this.mForumId));
                    return;
                }
                com.baidu.tbadk.editortools.pb.d aZY = as.this.fHW.aZY();
                if (aZY == null || (!aZY.Lq() && !aZY.Lr())) {
                    if (as.this.axO != null) {
                        as.this.bdp();
                    }
                    if (as.this.axO != null) {
                        as.this.fPX = false;
                        if (as.this.axO.hN(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.fHW, (View) as.this.axO.hN(2).bpR, false, as.this.fQU);
                        }
                    }
                    as.this.bdT();
                    return;
                }
                as.this.fHW.aZY().a(false, (PostWriteCallBackData) null);
            }
        });
        this.fPU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                as.this.beh();
                if (as.this.fHW.checkUpIsLogin()) {
                    if (as.this.axO != null) {
                        as.this.bdp();
                        as.this.axO.bf((View) as.this.axO.hL(5));
                    }
                    if (as.this.axO != null) {
                        as.this.fPX = false;
                        if (as.this.axO.hN(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.fHW, (View) as.this.axO.hN(2).bpR, false, as.this.fQU);
                        }
                    }
                    as.this.bdT();
                }
            }
        });
        this.fPV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                as.this.beh();
                if (as.this.fHW.checkUpIsLogin()) {
                    if (as.this.axO != null) {
                        as.this.bdp();
                        as.this.axO.bf((View) as.this.axO.hL(2));
                    }
                    if (as.this.axO != null) {
                        as.this.fPX = false;
                        if (as.this.axO.hN(2) != null) {
                            com.baidu.tieba.tbadkCore.b.a.a(as.this.fHW, (View) as.this.axO.hN(2).bpR, false, as.this.fQU);
                        }
                    }
                    as.this.bdT();
                }
            }
        });
        this.fPW.setOnClickListener(this.dyk);
        this.fPW.setOnTouchListener(this.fHW);
        this.fOM = LayoutInflater.from(this.fHW.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_item, (ViewGroup) null);
        this.fOP = (LinearLayout) LayoutInflater.from(this.fHW.getPageContext().getPageActivity()).inflate(d.h.new_pb_header_user_item, (ViewGroup) null);
        com.baidu.tbadk.core.util.aj.s(this.fOP, d.C0108d.cp_bg_line_d);
        this.fOQ = new f(this.fHW, this.fOP);
        this.fOQ.init();
        this.fOQ.a(this.fOQ.aZX(), this.dyk);
        this.fOR = (ColumnLayout) this.fOP.findViewById(d.g.pb_head_owner_root);
        this.fOS = (ThreadSkinView) this.fOP.findViewById(d.g.pb_thread_skin);
        this.fOR.setOnLongClickListener(this.onLongClickListener);
        this.fOR.setOnTouchListener(this.bJy);
        this.fOR.setVisibility(8);
        this.fOM.setOnTouchListener(this.bJy);
        this.fQd = this.fOM.findViewById(d.g.pb_head_activity_join_number_container);
        this.fQd.setVisibility(8);
        this.fQe = (TextView) this.fOM.findViewById(d.g.pb_head_activity_join_number);
        this.fOT = (TextView) this.fOR.findViewById(d.g.pb_head_owner_info_user_name);
        this.fOU = (TextView) this.fOR.findViewById(d.g.floor_owner);
        this.fOV = (ImageView) this.fOR.findViewById(d.g.icon_forum_level);
        this.fOX = (FrameLayout) this.fOR.findViewById(d.g.pb_head_headImage_container);
        this.fOY = (HeadImageView) this.fOR.findViewById(d.g.pb_head_owner_photo);
        this.fOW = (HeadPendantView) this.fOR.findViewById(d.g.pb_pendant_head_owner_photo);
        this.fOW.DG();
        if (this.fOW.getHeadView() != null) {
            this.fOW.getHeadView().setIsRound(true);
            this.fOW.getHeadView().setDrawBorder(false);
        }
        this.fJd = (UserIconBox) this.fOR.findViewById(d.g.show_icon_vip);
        this.fJe = (UserIconBox) this.fOR.findViewById(d.g.show_icon_yinji);
        this.fPa = (FloatingLayout) this.fOP.findViewById(d.g.pb_head_owner_info_root);
        this.fPd = (PbFirstFloorUserLikeButton) this.fOR.findViewById(d.g.pb_like_button);
        this.fPg = (TextView) this.fOR.findViewById(d.g.pb_views);
        this.djB = (TextView) this.fOR.findViewById(d.g.view_forum_name);
        this.fPk = this.fOR.findViewById(d.g.line_right_forum_name);
        this.fPh = (TextView) this.fOR.findViewById(d.g.pb_item_first_floor_reply_time);
        this.fPi = (TextView) this.fOR.findViewById(d.g.pb_item_first_floor_location_address);
        this.fPj = this.fOR.findViewById(d.g.line_between_time_and_locate);
        this.fQX = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fQY = new com.baidu.tbadk.core.view.userLike.c(pbActivity.getPageContext());
        this.fPo = this.fOM.findViewById(d.g.new_pb_header_item_line_above_livepost);
        this.fPp = this.fOM.findViewById(d.g.new_pb_header_item_line_below_livepost);
        this.fOM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.34
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        this.fQf = (ViewStub) this.dhJ.findViewById(d.g.interview_status_stub);
        this.fPs = new h(this.fHW, this.fOL);
        this.fPs.q(this.dyk);
        this.fPs.setTbGestureDetector(this.bJy);
        this.fPs.setOnImageClickListener(this.bJx);
        this.fDA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    boolean booleanValue = sparseArray.get(d.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_manage_visible)).booleanValue() : false;
                    boolean booleanValue2 = sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue() : false;
                    boolean booleanValue3 = sparseArray.get(d.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(d.g.tag_should_delete_visible)).booleanValue() : false;
                    if (booleanValue) {
                        if (!com.baidu.tieba.c.a.aiU() || !com.baidu.tieba.c.a.b(as.this.fHW.getBaseContext(), as.this.fHW.aZK().bbB(), (String) sparseArray.get(d.g.tag_subpb_main_floor_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue())) {
                            if (booleanValue2) {
                                sparseArray.put(d.g.tag_from, 1);
                                as.this.fHW.c(sparseArray);
                                return;
                            }
                            as.this.cx(view);
                        }
                    } else if (booleanValue2) {
                        sparseArray.put(d.g.tag_from, 0);
                        sparseArray.put(d.g.tag_check_mute_from, 1);
                        as.this.fHW.c(sparseArray);
                    } else if (booleanValue3) {
                        as.this.a(((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray.get(d.g.tag_del_post_id), ((Integer) sparseArray.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.fPs.D(this.fDA);
        bdk();
        this.fOL.addHeaderView(this.fON);
        this.fOL.addHeaderView(this.fOP);
        this.fOL.addHeaderView(this.fOM);
        this.dBm = new PbListView(this.fHW.getPageContext().getPageActivity());
        this.bwW = this.dBm.getView().findViewById(d.g.pb_more_view);
        if (this.bwW != null) {
            this.bwW.setOnClickListener(this.dyk);
            com.baidu.tbadk.core.util.aj.s(this.bwW, d.f.pb_foot_more_trans_selector);
        }
        this.dBm.DP();
        this.dBm.gv(d.f.pb_foot_more_trans_selector);
        this.dBm.gx(d.f.pb_foot_more_trans_selector);
        this.fPy = this.fHW.findViewById(d.g.viewstub_progress);
        this.fHW.registerListener(this.fRe);
        this.fOZ = com.baidu.tbadk.ala.b.uY().t(this.fHW.getActivity(), 2);
        if (this.fOZ != null) {
            this.fOZ.setVisibility(8);
            FloatingLayout.a aVar = new FloatingLayout.a(-2, -2);
            aVar.topMargin = this.fHW.getResources().getDimensionPixelSize(d.e.ds10);
            this.fPa.addView(this.fOZ, aVar);
        }
        this.fKa = new PbFakeFloorModel(this.fHW.getPageContext());
        this.fQB = new s(this.fHW.getPageContext(), this.fKa, this.dhJ);
        this.fQB.a(this.fHW.fGX);
        this.fKa.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.as.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                as.this.fKa.m(postData);
                as.this.fPs.notifyDataSetChanged();
                as.this.fQB.bbm();
                as.this.axO.IP();
                as.this.ky(false);
            }
        });
        if (this.fHW.aZK() != null && !StringUtils.isNull(this.fHW.aZK().bcg())) {
            this.fHW.showToast(this.fHW.aZK().bcg());
        }
        this.fQk = this.fHW.findViewById(d.g.pb_expand_blank_view);
        this.fQl = this.fHW.findViewById(d.g.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fQl.getLayoutParams();
        if (this.fHW.aZK() != null && this.fHW.aZK().bbE()) {
            this.fQk.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.fQl.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = fQn;
            this.fQl.setLayoutParams(layoutParams2);
        }
        this.fQm = new al(this.fHW.getPageContext(), this.fHW.findViewById(d.g.pb_reply_expand_view));
        this.fQm.fNX.setVisibility(8);
        this.fQm.F(this.dyk);
        this.fHW.registerListener(this.dJy);
        this.fHW.registerListener(this.fRa);
        this.fHW.registerListener(this.fRb);
        bdg();
        ks(false);
    }

    private void bdg() {
        this.fQQ = new com.baidu.tieba.pb.pb.godreply.a(this.fHW, this, (ViewStub) this.dhJ.findViewById(d.g.more_god_reply_popup));
        this.fQQ.setCommonClickListener(this.dyk);
        this.fQQ.D(this.fDA);
        this.fQQ.setOnImageClickListener(this.bJx);
        this.fQQ.setCommonClickListener(this.dyk);
        this.fQQ.setTbGestureDetector(this.bJy);
    }

    public com.baidu.tieba.pb.pb.godreply.a bdh() {
        return this.fQQ;
    }

    public View bdi() {
        return this.fQk;
    }

    public void bdj() {
        if (this.fOL != null) {
            this.fOL.removeHeaderView(this.fON);
            this.fOL.removeHeaderView(this.fOP);
            this.fOL.removeHeaderView(this.fOM);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, final com.baidu.tieba.pb.pb.main.emotion.a aVar2) {
        if (this.fQr == null) {
            this.fQr = new com.baidu.tieba.pb.pb.main.emotion.b.a(this.fHW.getPageContext().getPageActivity());
            ks(true);
            this.fQr.a(this.dhJ, aVar, this.fPS.getVisibility() == 0);
            this.fQr.setOnEmotionClickListener(new a.InterfaceC0142a() { // from class: com.baidu.tieba.pb.pb.main.as.3
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0142a
                public void b(EmotionImageData emotionImageData, boolean z) {
                    if (!StringUtils.isNull(as.this.fQZ)) {
                        emotionImageData.setAuthorNameShow(as.this.fQZ);
                    }
                    if (aVar2 != null) {
                        aVar2.a(emotionImageData, z);
                    }
                }

                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.InterfaceC0142a
                public void a(String str, List<String> list, List<String> list2) {
                    as.this.fHW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbSearchEmotionActivityConfig(as.this.fHW.getPageContext().getPageActivity(), 25016, str, list, as.this.fQZ, list2)));
                }
            });
            this.fQr.setOnMoveListener(new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.4
                @Override // com.baidu.tieba.pb.pb.main.emotion.b.a.b
                public void onMove(float f) {
                    as.this.beh();
                    if (as.this.fPS != null) {
                        ViewGroup.LayoutParams layoutParams = as.this.fPS.getLayoutParams();
                        layoutParams.height = (int) (((as.this.fQa - as.this.fPZ) * f) + as.this.fPZ);
                        as.this.fPT.setAlpha(1.0f - f);
                        as.this.fPV.setAlpha(1.0f - f);
                        as.this.fPU.setAlpha(1.0f - f);
                        as.this.fPS.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    private void bdk() {
        if (this.fON == null) {
            int s = com.baidu.adp.lib.util.l.s(this.fHW.getPageContext().getPageActivity(), d.e.tbds44);
            this.fON = new LinearLayout(this.fHW.getPageContext().getPageActivity());
            this.fON.setOrientation(1);
            this.fON.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fON.setPadding(s, com.baidu.adp.lib.util.l.s(this.fHW.getPageContext().getPageActivity(), d.e.tbds30), s, com.baidu.adp.lib.util.l.s(this.fHW.getPageContext().getPageActivity(), d.e.tbds40));
            this.fON.setGravity(17);
            this.fOO = new TextView(this.fHW.getPageContext().getPageActivity());
            this.fOO.setGravity(3);
            this.fOO.setMaxLines(2);
            this.fOO.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_link_tip_c));
            this.fOO.setPadding(0, 0, 0, 0);
            this.fOO.setLineSpacing(com.baidu.adp.lib.util.l.s(this.fHW.getPageContext().getPageActivity(), d.e.tbds22), 1.0f);
            com.baidu.tbadk.core.util.aj.r(this.fOO, d.C0108d.cp_cont_b);
            this.fOO.setTextSize(0, TbConfig.getContentSizeOfPostTitle());
            this.fOO.setVisibility(8);
            this.fON.addView(this.fOO);
            this.fON.setOnTouchListener(this.bJy);
            this.fON.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.7
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdl() {
        if (this.fHW.baB()) {
            this.fOK = (ViewStub) this.fHW.findViewById(d.g.manga_mention_controller_view_stub);
            this.fOK.setVisibility(0);
            if (this.fPl == null) {
                this.fPl = (LinearLayout) this.fHW.findViewById(d.g.manga_controller_layout);
                com.baidu.tbadk.n.a.a(this.fHW.getPageContext(), this.fPl);
            }
            if (this.fPm == null) {
                this.fPm = (TextView) this.fPl.findViewById(d.g.manga_prev_btn);
            }
            if (this.fPn == null) {
                this.fPn = (TextView) this.fPl.findViewById(d.g.manga_next_btn);
            }
            this.fPm.setOnClickListener(this.dyk);
            this.fPn.setOnClickListener(this.dyk);
        }
    }

    private void bdm() {
        if (this.fHW.baB()) {
            if (this.fHW.baE() == -1) {
                com.baidu.tbadk.core.util.aj.e(this.fPm, d.C0108d.cp_cont_e, 1);
            }
            if (this.fHW.baF() == -1) {
                com.baidu.tbadk.core.util.aj.e(this.fPn, d.C0108d.cp_cont_e, 1);
            }
        }
    }

    public void bdn() {
        if (this.fPl == null) {
            bdl();
        }
        this.fOK.setVisibility(8);
        if (this.fRc != null && this.fRd != null) {
            this.fRc.removeCallbacks(this.fRd);
        }
    }

    public void bdo() {
        if (this.fRc != null) {
            if (this.fRd != null) {
                this.fRc.removeCallbacks(this.fRd);
            }
            this.fRd = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.8
                @Override // java.lang.Runnable
                public void run() {
                    if (as.this.fPl == null) {
                        as.this.bdl();
                    }
                    as.this.fOK.setVisibility(0);
                }
            };
            this.fRc.postDelayed(this.fRd, 2000L);
        }
    }

    public void kp(boolean z) {
        this.fOH.kp(z);
        if (z && this.fQc) {
            this.dBm.setText(this.fHW.getResources().getString(d.j.click_load_more));
            this.fOL.setNextPage(this.dBm);
            this.fOG = 2;
        }
    }

    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.axO = iVar;
        this.axO.setId(d.g.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.dhJ.addView(this.axO, layoutParams);
        this.axO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bcY();
        this.fHW.aZY().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.as.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (as.this.axO != null && as.this.axO.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (as.this.fQP == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, as.this.axO.getId());
                            as.this.fQP = new com.baidu.tieba.pb.pb.main.emotion.c(as.this.fHW.getPageContext(), as.this.dhJ, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.G(as.this.fQO)) {
                                as.this.fQP.setData(as.this.fQO);
                            }
                            as.this.fQP.b(as.this.axO);
                        }
                        as.this.fQP.ql(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (as.this.fHW.fGe != null && as.this.fHW.fGe.bek() != null) {
                    if (!as.this.fHW.fGe.bek().bLp()) {
                        as.this.fHW.fGe.kC(false);
                    }
                    as.this.fHW.fGe.bek().oo(false);
                }
            }
        });
    }

    public void bdp() {
        if (this.fHW != null && this.axO != null) {
            this.axO.th();
            bdT();
        }
    }

    public void S(String str, boolean z) {
        this.fPY = z;
        kq(TbadkCoreApplication.getInst().getSkinType() == 1);
    }

    private void kq(boolean z) {
        if (this.fPW != null) {
            if (this.fPY) {
                com.baidu.tbadk.core.util.aj.s(this.fPW, d.f.pb_praise_already_click_selector);
                this.fPW.setContentDescription(this.fHW.getResources().getString(d.j.cancel_praise));
                return;
            }
            com.baidu.tbadk.core.util.aj.s(this.fPW, d.f.pb_praise_normal_click_selector);
            this.fPW.setContentDescription(this.fHW.getResources().getString(d.j.zan));
        }
    }

    public TextView bdq() {
        return this.fPW;
    }

    public void kr(boolean z) {
        if (this.fOL != null && this.bmg != null && this.dyx != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dyx.setVisibility(0);
                } else {
                    this.dyx.setVisibility(8);
                    this.fOL.removeHeaderView(this.bmg);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.bmg.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fQn;
                    this.bmg.setLayoutParams(layoutParams);
                }
                bdF();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.bmg.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + kA(true);
                this.bmg.setLayoutParams(layoutParams2);
            }
            bdF();
            bed();
        }
    }

    public h bdr() {
        return this.fPs;
    }

    public void a(PbActivity.d dVar) {
        this.fHb = dVar;
    }

    public void cx(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        SparseArray sparseArray2;
        if (this.fPB == null) {
            this.fPB = LayoutInflater.from(this.fHW.getPageContext().getPageActivity()).inflate(d.h.forum_manage_dialog, (ViewGroup) null);
        }
        this.fHW.getLayoutMode().aM(this.fPB);
        if (this.fPA == null) {
            this.fPA = new Dialog(this.fHW.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fPA.setCanceledOnTouchOutside(true);
            this.fPA.setCancelable(true);
            this.fPA.setContentView(this.fPB);
            WindowManager.LayoutParams attributes = this.fPA.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.ao(this.fHW.getPageContext().getPageActivity()) * 0.9d);
            this.fPA.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.fPA.findViewById(d.g.del_post_btn);
        TextView textView2 = (TextView) this.fPA.findViewById(d.g.forbid_user_btn);
        TextView textView3 = (TextView) this.fPA.findViewById(d.g.disable_reply_btn);
        int intValue = sparseArray.get(d.g.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_check_mute_from)).intValue() : -1;
        if ("".equals(sparseArray.get(d.g.tag_del_post_id)) || intValue == 2) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                textView.setTag(sparseArray4);
                sparseArray2 = sparseArray4;
            } else {
                sparseArray2 = sparseArray3;
            }
            textView.setVisibility(0);
            if ((sparseArray.get(d.g.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(d.g.tag_del_post_type)).intValue() : -1) != 0) {
                textView.setText(d.j.delete);
            } else {
                textView.setText(d.j.delete_post);
            }
            sparseArray2.put(d.g.tag_del_post_id, sparseArray.get(d.g.tag_del_post_id));
            sparseArray2.put(d.g.tag_del_post_type, sparseArray.get(d.g.tag_del_post_type));
            sparseArray2.put(d.g.tag_del_post_is_self, sparseArray.get(d.g.tag_del_post_is_self));
            sparseArray2.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (as.this.fPA != null && (as.this.fPA instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.fPA, as.this.fHW.getPageContext());
                    }
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        as.this.a(((Integer) sparseArray5.get(d.g.tag_del_post_type)).intValue(), (String) sparseArray5.get(d.g.tag_del_post_id), ((Integer) sparseArray5.get(d.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(d.g.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(d.g.tag_forbid_user_name)) || bea()) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray5 = (SparseArray) textView2.getTag();
            if (sparseArray5 == null) {
                sparseArray5 = new SparseArray();
                textView2.setTag(sparseArray5);
            }
            textView2.setVisibility(0);
            sparseArray5.put(d.g.tag_forbid_user_name, sparseArray.get(d.g.tag_forbid_user_name));
            sparseArray5.put(d.g.tag_manage_user_identity, sparseArray.get(d.g.tag_manage_user_identity));
            sparseArray5.put(d.g.tag_forbid_user_post_id, sparseArray.get(d.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (as.this.fPA != null && (as.this.fPA instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.fPA, as.this.fHW.getPageContext());
                    }
                    SparseArray sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null && as.this.fRf != null) {
                        as.this.fRf.ak(new Object[]{sparseArray6.get(d.g.tag_manage_user_identity), sparseArray6.get(d.g.tag_forbid_user_name), sparseArray6.get(d.g.tag_forbid_user_post_id)});
                    }
                }
            });
        }
        if (!((sparseArray.get(d.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(d.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray6 = (SparseArray) textView3.getTag();
            if (sparseArray6 == null) {
                sparseArray6 = new SparseArray();
                textView3.setTag(sparseArray6);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(d.j.un_mute);
            } else {
                textView3.setText(d.j.mute);
            }
            sparseArray6.put(d.g.tag_is_mem, sparseArray.get(d.g.tag_is_mem));
            sparseArray6.put(d.g.tag_user_mute_mute_userid, sparseArray.get(d.g.tag_user_mute_mute_userid));
            sparseArray6.put(d.g.tag_user_mute_mute_username, sparseArray.get(d.g.tag_user_mute_mute_username));
            sparseArray6.put(d.g.tag_user_mute_post_id, sparseArray.get(d.g.tag_user_mute_post_id));
            sparseArray6.put(d.g.tag_user_mute_thread_id, sparseArray.get(d.g.tag_user_mute_thread_id));
            sparseArray6.put(d.g.tag_user_mute_msg, sparseArray.get(d.g.tag_user_mute_msg));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (as.this.fPA != null && (as.this.fPA instanceof Dialog)) {
                        com.baidu.adp.lib.g.g.b(as.this.fPA, as.this.fHW.getPageContext());
                    }
                    SparseArray<Object> sparseArray7 = (SparseArray) view.getTag();
                    if (sparseArray7 != null) {
                        as.this.fHW.a(z, (String) sparseArray7.get(d.g.tag_user_mute_mute_userid), sparseArray7);
                    }
                }
            });
        }
        com.baidu.adp.lib.g.g.a(this.fPA, this.fHW.getPageContext());
    }

    public void a(PbActivity.b bVar) {
        this.fRf = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    public void a(int i, String str, int i2, boolean z, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_del_post_id, str);
        sparseArray.put(d.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(fQu, Integer.valueOf(fQv));
        int i3 = d.j.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = d.j.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = d.j.report_thread_confirm;
            } else {
                i3 = d.j.del_thread_confirm;
            }
        }
        this.fPC = new com.baidu.tbadk.core.dialog.a(this.fHW.getActivity());
        if (StringUtils.isNull(str2)) {
            this.fPC.fd(i3);
        } else {
            this.fPC.ba(false);
            this.fPC.cZ(str2);
        }
        this.fPC.aE(sparseArray);
        this.fPC.a(d.j.dialog_ok, this.fHW);
        this.fPC.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.fPC.aV(true);
        this.fPC.b(this.fHW.getPageContext());
        this.fPC.AI();
    }

    public void am(ArrayList<com.baidu.tbadk.core.data.aa> arrayList) {
        if (this.fPF == null) {
            this.fPF = LayoutInflater.from(this.fHW.getPageContext().getPageActivity()).inflate(d.h.commit_good, (ViewGroup) null);
        }
        this.fHW.getLayoutMode().aM(this.fPF);
        if (this.fPE == null) {
            this.fPE = new Dialog(this.fHW.getPageContext().getPageActivity(), d.k.common_alert_dialog);
            this.fPE.setCanceledOnTouchOutside(true);
            this.fPE.setCancelable(true);
            this.fPP = (ScrollView) this.fPF.findViewById(d.g.good_scroll);
            this.fPE.setContentView(this.fPF);
            WindowManager.LayoutParams attributes = this.fPE.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.s(this.fHW.getPageContext().getPageActivity(), d.e.ds540);
            this.fPE.getWindow().setAttributes(attributes);
            this.cRF = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.as.16
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        as.this.fPK = (String) compoundButton.getTag();
                        if (as.this.cRE != null) {
                            for (com.baidu.tieba.pb.pb.main.view.a aVar : as.this.cRE) {
                                String str = (String) aVar.getTag();
                                if (str != null && as.this.fPK != null && !str.equals(as.this.fPK)) {
                                    aVar.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.fPG = (LinearLayout) this.fPF.findViewById(d.g.good_class_group);
            this.fPI = (TextView) this.fPF.findViewById(d.g.dialog_button_cancel);
            this.fPI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (as.this.fPE instanceof Dialog) {
                        com.baidu.adp.lib.g.g.b(as.this.fPE, as.this.fHW.getPageContext());
                    }
                }
            });
            this.fPH = (TextView) this.fPF.findViewById(d.g.dialog_button_ok);
            this.fPH.setOnClickListener(this.dyk);
        }
        this.fPG.removeAllViews();
        this.cRE = new ArrayList();
        com.baidu.tieba.pb.pb.main.view.a bJ = bJ("0", this.fHW.getPageContext().getString(d.j.def_good_class));
        this.cRE.add(bJ);
        bJ.setChecked(true);
        this.fPG.addView(bJ);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aa aaVar = arrayList.get(i2);
                if (aaVar != null && !TextUtils.isEmpty(aaVar.xy()) && aaVar.xz() > 0) {
                    com.baidu.tieba.pb.pb.main.view.a bJ2 = bJ(String.valueOf(aaVar.xz()), aaVar.xy());
                    this.cRE.add(bJ2);
                    View view = new View(this.fHW.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.s(this.fHW.getPageContext().getPageActivity(), d.e.ds1));
                    com.baidu.tbadk.core.util.aj.t(view, d.C0108d.cp_bg_line_a);
                    view.setLayoutParams(layoutParams);
                    this.fPG.addView(view);
                    this.fPG.addView(bJ2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.fPP.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fHW.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fHW.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.fHW.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.fPP.setLayoutParams(layoutParams2);
            this.fPP.removeAllViews();
            this.fPP.addView(this.fPG);
        }
        com.baidu.adp.lib.g.g.a(this.fPE, this.fHW.getPageContext());
    }

    private com.baidu.tieba.pb.pb.main.view.a bJ(String str, String str2) {
        Activity pageActivity = this.fHW.getPageContext().getPageActivity();
        com.baidu.tieba.pb.pb.main.view.a aVar = new com.baidu.tieba.pb.pb.main.view.a(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.s(pageActivity, d.e.ds100));
        aVar.setOnCheckedChangeListener(this.cRF);
        aVar.setTag(str);
        aVar.setText(str2);
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public void bds() {
        this.fHW.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.fHW.hideProgressBar();
        if (z && z2) {
            this.fHW.showToast(this.fHW.getPageContext().getString(d.j.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.am.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(d.j.neterror);
            }
            this.fHW.showToast(str);
        }
    }

    public void aIx() {
        this.fPy.setVisibility(0);
    }

    public void aIw() {
        this.fPy.setVisibility(8);
    }

    public View bdt() {
        if (this.fPF != null) {
            return this.fPF.findViewById(d.g.dialog_button_ok);
        }
        return null;
    }

    public String bdu() {
        return this.fPK;
    }

    public View getView() {
        return this.dhJ;
    }

    public void bdv() {
        com.baidu.adp.lib.util.l.a(this.fHW.getPageContext().getPageActivity(), this.fHW.getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.fHW.hideProgressBar();
        if (z) {
            bdK();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            bdL();
        } else {
            bdK();
        }
    }

    public void bdw() {
        this.dBm.DP();
        this.dBm.DT();
    }

    public void bdx() {
        this.fHW.hideProgressBar();
        DU();
        this.fOL.completePullRefreshPostDelayed(2000L);
        bdH();
    }

    public void bdy() {
        this.fOL.completePullRefreshPostDelayed(2000L);
        bdH();
    }

    private void ks(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fPT.getLayoutParams();
        marginLayoutParams.rightMargin = z ? this.fHW.getResources().getDimensionPixelSize(d.e.ds130) : this.fHW.getResources().getDimensionPixelSize(d.e.ds34);
        this.fPT.setLayoutParams(marginLayoutParams);
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.fPs.setOnLongClickListener(onLongClickListener);
        if (this.fQQ != null) {
            this.fQQ.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(b.InterfaceC0074b interfaceC0074b, boolean z, boolean z2) {
        if (this.fPL != null) {
            this.fPL.dismiss();
            this.fPL = null;
        }
        this.fPL = new com.baidu.tbadk.core.dialog.b(this.fHW.getPageContext().getPageActivity());
        this.fPL.fg(d.j.operation);
        if (z2) {
            this.fPL.a(new String[]{this.fHW.getPageContext().getString(d.j.copy)}, interfaceC0074b);
        } else if (!z) {
            this.fPL.a(new String[]{this.fHW.getPageContext().getString(d.j.copy), this.fHW.getPageContext().getString(d.j.mark)}, interfaceC0074b);
        } else {
            this.fPL.a(new String[]{this.fHW.getPageContext().getString(d.j.copy), this.fHW.getPageContext().getString(d.j.remove_mark)}, interfaceC0074b);
        }
        this.fPL.d(this.fHW.getPageContext());
        this.fPL.AL();
    }

    public void a(b.InterfaceC0074b interfaceC0074b, boolean z) {
        if (this.fPM != null) {
            this.fPM.dismiss();
            this.fPM = null;
        }
        this.fPM = new com.baidu.tbadk.core.dialog.b(this.fHW.getPageContext().getPageActivity());
        this.fPM.fg(d.j.operation);
        if (z) {
            this.fPM.a(new String[]{this.fHW.getPageContext().getString(d.j.save_to_emotion)}, interfaceC0074b);
        } else {
            this.fPM.a(new String[]{this.fHW.getPageContext().getString(d.j.save_to_emotion), this.fHW.getPageContext().getString(d.j.save_to_local)}, interfaceC0074b);
        }
        this.fPM.d(this.fHW.getPageContext());
        this.fPM.AL();
    }

    public int bdz() {
        return tf(this.fOL.getFirstVisiblePosition());
    }

    private int tf(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.fOL.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.fOL.getAdapter() == null || !(this.fOL.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.fOL.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int bdA() {
        int lastVisiblePosition = this.fOL.getLastVisiblePosition();
        if (this.fOB != null) {
            if (lastVisiblePosition == this.fOL.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return tf(lastVisiblePosition);
    }

    public void tg(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.fOL != null) {
            if (this.fOH == null || this.fOH.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.fOH.mNavigationBar.getFixedNavHeight();
                if (this.fHW.ban() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.fQl != null && (layoutParams = (LinearLayout.LayoutParams) this.fQl.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.fQl.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.fOL.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.fOL.setSelection(i);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.fPv.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void p(com.baidu.tieba.pb.data.f fVar) {
        this.fPs.a(fVar, false);
        this.fPs.notifyDataSetChanged();
        bdH();
        if (this.fQQ != null) {
            this.fQQ.aZG();
        }
    }

    public void q(com.baidu.tieba.pb.data.f fVar) {
        if (this.fPb == null) {
            this.fHW.getLayoutMode().aM(((ViewStub) this.fOM.findViewById(d.g.praise_layout)).inflate());
            this.fPb = (FrsPraiseView) this.fOM.findViewById(d.g.pb_head_praise_view);
            this.fPb.setIsFromPb(true);
            this.fPq = this.fOM.findViewById(d.g.new_pb_header_item_line_above_praise);
            this.fPb.gC(TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fPb != null) {
            boolean bdH = bdH();
            this.fPb.setVisibility(8);
            if (fVar != null && fVar.yb() != null && fVar.yb().xY() == 0 && this.fDw) {
                if (bdH) {
                    this.fPp.setVisibility(0);
                    return;
                } else {
                    this.fPp.setVisibility(8);
                    return;
                }
            }
            this.fPp.setVisibility(8);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.aYL() != null) {
            return fVar.aYL();
        }
        if (!com.baidu.tbadk.core.util.v.G(fVar.aYC())) {
            Iterator<PostData> it = fVar.aYC().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.bCl() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.aYI();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.yX() != null && postData.yX().getUserTbVipInfoData() != null && postData.yX().getUserTbVipInfoData().getvipIntro() != null) {
            postData.yX().getGodUserData().setIntro(postData.yX().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aYA() == null || fVar.aYA().yX() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData yX = fVar.aYA().yX();
        String userId = yX.getUserId();
        HashMap<String, MetaData> userMap = fVar.aYA().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = yX;
        }
        postData.xj(1);
        postData.setId(fVar.aYA().zo());
        postData.setTitle(fVar.aYA().getTitle());
        postData.setTime(fVar.aYA().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x05a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0720  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x031a  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        String e;
        ArrayList<IconData> tShowInfoNew;
        int s;
        com.baidu.tbadk.data.f bCp;
        String portrait;
        if (fVar != null && fVar.aYA() != null) {
            PostData b = b(fVar, z);
            a(b, fVar);
            beb();
            this.fOR.setVisibility(8);
            if (fVar.aYA() != null && fVar.aYA().zK() && fVar.aYA().zp() != null) {
                this.fQF = true;
                this.fOH.kN(this.fQF);
                this.fOH.mNavigationBar.hideBottomLine();
                if (this.fOB == null) {
                    this.fOB = new com.baidu.tieba.pb.video.i(this.fHW, this.fOH, fVar.aYA().zp(), this.fOC);
                    this.fOB.a(fVar.aYA().zp(), fVar.aYA(), fVar.getForumId());
                    this.fOB.startPlay();
                } else if (this.fOF) {
                    this.fOB.a(fVar.aYA().zp(), fVar.aYA(), fVar.getForumId());
                    this.fOB.startPlay();
                } else {
                    this.fOB.qx(fVar.getForumId());
                }
                if (fVar.aYB() != null && fVar.aYB().size() >= 1) {
                    be beVar = fVar.aYB().get(0);
                    this.fOB.ae(beVar);
                    this.fOB.qy(beVar.getTitle());
                }
                this.fOB.b(b, fVar.aYA(), fVar.aYY());
                this.fOF = false;
                this.fOL.removeHeaderView(this.fOB.bfS());
                this.fOL.addHeaderView(this.fOB.bfS(), 0);
                if (this.fOB.bfQ() != null && this.fOB.bfQ().getParent() == null) {
                    this.fQj.addView(this.fOB.bfQ());
                }
                if (this.fOD == null) {
                    this.fOD = new com.baidu.tieba.pb.video.h(this.fHW);
                }
                this.fOD.a(fVar.aYA().Ac(), fVar.aYA(), fVar.aYV());
                this.fOL.removeHeaderView(this.fOD.bfH());
                this.fOL.addHeaderView(this.fOD.bfH(), 1);
                if (fVar.aYA().Ac() != null) {
                    this.fOL.removeHeaderView(this.fOD.bfI());
                    this.fOL.removeHeaderView(this.fOP);
                    this.fOL.addHeaderView(this.fOD.bfI(), 2);
                } else {
                    if (this.fOD.bfI() != null) {
                        this.fOL.removeHeaderView(this.fOD.bfI());
                    }
                    this.fOL.removeHeaderView(this.fOP);
                    this.fOP.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.s(this.fHW, d.e.tbds56));
                    this.fOL.addHeaderView(this.fOP, 2);
                }
                if (this.fOB != null) {
                    this.fOH.kI(false);
                    this.fOH.kK(TbadkCoreApplication.isLogin());
                    this.fOB.tn(TbadkCoreApplication.getInst().getSkinType());
                }
                bdF();
            } else {
                this.fQF = false;
                this.fOH.kN(this.fQF);
                if (this.fOB != null) {
                    this.fOL.removeHeaderView(this.fOB.bfS());
                }
                if (this.fOD != null) {
                    this.fOD.b(this.fOL);
                }
                if (b == null || (b != null && (b.bCo() == null || com.baidu.tbadk.core.util.v.G(b.bCo().QN())))) {
                    this.fOP.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.s(this.fHW, d.e.tbds80));
                } else {
                    this.fOP.setPadding(0, 0, 0, 0);
                }
            }
            if (this.fHW.bac() != null) {
                this.fHW.bac().kG(this.fQF);
            }
            if (this.fOB != null) {
                this.fOB.H(this.fRh);
            }
            if (b != null) {
                this.fQb = b;
                this.fOR.setVisibility(0);
                if (this.fHW.baP()) {
                    if (fVar.aYz() != null) {
                        this.mForumName = fVar.aYz().getForumName();
                        this.mForumId = fVar.aYz().getForumId();
                    }
                    if (this.mForumName == null && this.fHW.aZK() != null && this.fHW.aZK().bbA() != null) {
                        this.mForumName = this.fHW.aZK().bbA();
                    }
                }
                SparseArray sparseArray = (SparseArray) this.fOR.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.fOR.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_clip_board, b);
                sparseArray.put(d.g.tag_is_subpb, false);
                if (!this.fQV) {
                    this.fON.setVisibility(0);
                }
                if (!fVar.aYA().zK() && this.fOO.getText() != null && this.fOO.getText().length() > 0) {
                    this.fOO.setVisibility(0);
                } else {
                    this.fOO.setVisibility(8);
                }
                q(fVar);
                ArrayList<com.baidu.tbadk.core.data.a> zj = fVar.aYA().zj();
                if (zj != null && zj.size() > 0 && !this.fQV) {
                    this.fQe.setText(String.valueOf(zj.get(0).wU()));
                    this.fQd.setVisibility(0);
                } else {
                    this.fQd.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aj.s(this.fQd, d.f.activity_join_num_bg);
                com.baidu.tbadk.core.util.aj.e(this.fQe, d.C0108d.cp_link_tip_d, 1);
                if (b.yX() != null) {
                    String string = b.yX().getName_show() == null ? StringUtils.string(b.yX().getUserName()) : StringUtils.string(b.yX().getName_show());
                    int i2 = 0;
                    if (!StringUtils.isNull(b.yX().getSealPrefix())) {
                        i2 = com.baidu.adp.lib.util.k.aX(b.yX().getSealPrefix()) + 2;
                    }
                    if (i2 > 0) {
                        if (com.baidu.adp.lib.util.k.aX(string) > 12) {
                            e = com.baidu.tbadk.core.util.am.e(string, 12, "...");
                            ArrayList<IconData> iconInfo = b.yX().getIconInfo();
                            tShowInfoNew = b.yX().getTShowInfoNew();
                            if (this.fJe != null) {
                                this.fJe.setTag(d.g.tag_user_id, b.yX().getUserId());
                                this.fJe.setOnClickListener(this.fHW.fGa.fST);
                                this.fJe.a(iconInfo, 4, this.fHW.getResources().getDimensionPixelSize(d.e.tbds36), this.fHW.getResources().getDimensionPixelSize(d.e.tbds36), this.fHW.getResources().getDimensionPixelSize(d.e.tbds12));
                            }
                            if (this.fJd != null) {
                                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                                    this.fJd.setTag(tShowInfoNew.get(0).getUrl());
                                }
                                this.fJd.setOnClickListener(this.fHW.fGa.fSU);
                                this.fJd.a(tShowInfoNew, 3, this.fHW.getResources().getDimensionPixelSize(d.e.tbds36), this.fHW.getResources().getDimensionPixelSize(d.e.tbds36), this.fHW.getResources().getDimensionPixelSize(d.e.ds12), true);
                            }
                            this.fOT.setText(af(b.yX().getSealPrefix(), e));
                            this.fOT.setTag(d.g.tag_user_id, b.yX().getUserId());
                            this.fOT.setTag(d.g.tag_user_name, b.yX().getName_show());
                            if (com.baidu.tbadk.core.util.v.G(tShowInfoNew) || b.yX().isBigV()) {
                                com.baidu.tbadk.core.util.aj.e(this.fOT, d.C0108d.cp_cont_h, 1);
                            } else {
                                com.baidu.tbadk.core.util.aj.e(this.fOT, d.C0108d.cp_cont_f, 1);
                            }
                            this.fOU.setVisibility(8);
                            if (fVar.aYA().yX() != null && fVar.aYA().yX().getAlaUserData() != null && this.fOZ != null) {
                                if (fVar.aYA().yX().getAlaUserData().anchor_live != 0) {
                                    this.fOZ.setVisibility(8);
                                } else {
                                    this.fOZ.setVisibility(0);
                                    if (this.fOE == null) {
                                        this.fOE = new com.baidu.tieba.d.b(this.fHW.getPageContext(), this.fOZ);
                                        this.fOE.lU(1);
                                    }
                                    this.fOE.aK(this.fHW.getResources().getString(d.j.pb_ala_tail_light_guide_tip), com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_video_pb_ala_tail_light_tips"));
                                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                                    aVar.aFJ = fVar.aYA().yX().getAlaUserData();
                                    aVar.type = 2;
                                    this.fOZ.setTag(aVar);
                                }
                            }
                            this.fOY.setUserId(b.yX().getUserId());
                            this.fOY.setUserName(b.yX().getUserName());
                            this.fOY.setImageDrawable(null);
                            this.fOY.setRadius(com.baidu.adp.lib.util.l.s(this.fHW.getActivity(), d.e.ds40));
                            this.fOY.setTag(b.yX().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                                this.fPh.setText(com.baidu.tbadk.core.util.am.A(b.getTime()));
                            } else {
                                this.fPh.setText(com.baidu.tbadk.core.util.am.z(b.getTime()));
                            }
                            s = com.baidu.adp.lib.util.l.s(this.fHW.getActivity(), d.e.ds16);
                            if (!this.fHW.baP() && !StringUtils.isNull(this.mForumName)) {
                                this.djB.setText(this.fHW.getString(d.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedBarText(this.mForumName, 5, true, true)}));
                                this.djB.setVisibility(0);
                                this.fPk.setVisibility(0);
                                this.fPh.setPadding(s, 0, s, 0);
                            } else {
                                this.djB.setVisibility(8);
                                this.fPk.setVisibility(8);
                                this.fPh.setPadding(0, 0, s, 0);
                            }
                            bCp = b.bCp();
                            if (bCp == null && !TextUtils.isEmpty(bCp.getName()) && !TextUtils.isEmpty(bCp.getName().trim())) {
                                final String name = bCp.getName();
                                final String lat = bCp.getLat();
                                final String lng = bCp.getLng();
                                this.fPi.setVisibility(0);
                                this.fPj.setVisibility(0);
                                this.fPi.setText(bCp.getName());
                                this.fPi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.19
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (TbadkCoreApplication.getInst().isLbsWebViewSwitchOn() && !StringUtils.isNull(lat) && !StringUtils.isNull(lng)) {
                                            if (!com.baidu.adp.lib.util.j.oI()) {
                                                as.this.fHW.showToast(d.j.neterror);
                                            } else {
                                                com.baidu.tbadk.browser.a.R(as.this.fHW.getPageContext().getContext(), String.format("http://api.map.baidu.com/marker?location=%1$s&title=%2$s&content=%3$s&output=html&src=%4$s", lat + Constants.ACCEPT_TIME_SEPARATOR_SP + lng, name, name, as.this.fHW.getPageContext().getString(d.j.app_info_for_map)));
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.fPi.setVisibility(8);
                                this.fPj.setVisibility(8);
                            }
                            portrait = b.yX().getPortrait();
                            if (b.yX().getPendantData() == null && !StringUtils.isNull(b.yX().getPendantData().xu())) {
                                UtilHelper.showHeadImageViewBigV(this.fOW.getHeadView(), b.yX());
                                this.fOY.setVisibility(8);
                                this.fOW.setVisibility(0);
                                if (this.fPc != null) {
                                    this.fPc.setVisibility(8);
                                }
                                this.fOT.setOnClickListener(this.fRh);
                                this.fOW.getHeadView().startLoad(portrait, 28, false);
                                this.fOW.getHeadView().setUserId(b.yX().getUserId());
                                this.fOW.getHeadView().setUserName(b.yX().getUserName());
                                this.fOW.getHeadView().setOnClickListener(this.fRh);
                                this.fOW.ez(b.yX().getPendantData().xu());
                            } else {
                                UtilHelper.showHeadImageViewBigV(this.fOY, b.yX());
                                this.fOY.setVisibility(0);
                                this.fOR.setOnClickListener(this.fRh);
                                this.fOT.setOnClickListener(this.fRh);
                                this.fOY.setOnClickListener(this.fRh);
                                this.fOW.setVisibility(8);
                                this.fOY.startLoad(portrait, 28, false);
                            }
                            String name_show = b.yX().getName_show();
                            String userName = b.yX().getUserName();
                            if (com.baidu.tbadk.o.ac.nu() && name_show != null && !name_show.equals(userName)) {
                                this.fOT.setText(com.baidu.tieba.pb.c.am(this.fHW.getPageContext().getPageActivity(), this.fOT.getText().toString()));
                                this.fOT.setGravity(16);
                                this.fOT.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYc());
                                com.baidu.tbadk.core.util.aj.e(this.fOT, d.C0108d.cp_other_e, 1);
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo2 = b.yX().getIconInfo();
                        tShowInfoNew = b.yX().getTShowInfoNew();
                        if (this.fJe != null) {
                        }
                        if (this.fJd != null) {
                        }
                        this.fOT.setText(af(b.yX().getSealPrefix(), e));
                        this.fOT.setTag(d.g.tag_user_id, b.yX().getUserId());
                        this.fOT.setTag(d.g.tag_user_name, b.yX().getName_show());
                        if (com.baidu.tbadk.core.util.v.G(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.e(this.fOT, d.C0108d.cp_cont_h, 1);
                        this.fOU.setVisibility(8);
                        if (fVar.aYA().yX() != null) {
                            if (fVar.aYA().yX().getAlaUserData().anchor_live != 0) {
                            }
                        }
                        this.fOY.setUserId(b.yX().getUserId());
                        this.fOY.setUserName(b.yX().getUserName());
                        this.fOY.setImageDrawable(null);
                        this.fOY.setRadius(com.baidu.adp.lib.util.l.s(this.fHW.getActivity(), d.e.ds40));
                        this.fOY.setTag(b.yX().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        s = com.baidu.adp.lib.util.l.s(this.fHW.getActivity(), d.e.ds16);
                        if (!this.fHW.baP()) {
                        }
                        this.djB.setVisibility(8);
                        this.fPk.setVisibility(8);
                        this.fPh.setPadding(0, 0, s, 0);
                        bCp = b.bCp();
                        if (bCp == null) {
                        }
                        this.fPi.setVisibility(8);
                        this.fPj.setVisibility(8);
                        portrait = b.yX().getPortrait();
                        if (b.yX().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fOY, b.yX());
                        this.fOY.setVisibility(0);
                        this.fOR.setOnClickListener(this.fRh);
                        this.fOT.setOnClickListener(this.fRh);
                        this.fOY.setOnClickListener(this.fRh);
                        this.fOW.setVisibility(8);
                        this.fOY.startLoad(portrait, 28, false);
                        String name_show2 = b.yX().getName_show();
                        String userName2 = b.yX().getUserName();
                        if (com.baidu.tbadk.o.ac.nu()) {
                            this.fOT.setText(com.baidu.tieba.pb.c.am(this.fHW.getPageContext().getPageActivity(), this.fOT.getText().toString()));
                            this.fOT.setGravity(16);
                            this.fOT.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aYc());
                            com.baidu.tbadk.core.util.aj.e(this.fOT, d.C0108d.cp_other_e, 1);
                        }
                    } else {
                        if (com.baidu.adp.lib.util.k.aX(string) > 14) {
                            e = com.baidu.tbadk.core.util.am.e(string, 14, "...");
                            ArrayList<IconData> iconInfo22 = b.yX().getIconInfo();
                            tShowInfoNew = b.yX().getTShowInfoNew();
                            if (this.fJe != null) {
                            }
                            if (this.fJd != null) {
                            }
                            this.fOT.setText(af(b.yX().getSealPrefix(), e));
                            this.fOT.setTag(d.g.tag_user_id, b.yX().getUserId());
                            this.fOT.setTag(d.g.tag_user_name, b.yX().getName_show());
                            if (com.baidu.tbadk.core.util.v.G(tShowInfoNew)) {
                            }
                            com.baidu.tbadk.core.util.aj.e(this.fOT, d.C0108d.cp_cont_h, 1);
                            this.fOU.setVisibility(8);
                            if (fVar.aYA().yX() != null) {
                            }
                            this.fOY.setUserId(b.yX().getUserId());
                            this.fOY.setUserName(b.yX().getUserName());
                            this.fOY.setImageDrawable(null);
                            this.fOY.setRadius(com.baidu.adp.lib.util.l.s(this.fHW.getActivity(), d.e.ds40));
                            this.fOY.setTag(b.yX().getUserId());
                            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                            }
                            s = com.baidu.adp.lib.util.l.s(this.fHW.getActivity(), d.e.ds16);
                            if (!this.fHW.baP()) {
                            }
                            this.djB.setVisibility(8);
                            this.fPk.setVisibility(8);
                            this.fPh.setPadding(0, 0, s, 0);
                            bCp = b.bCp();
                            if (bCp == null) {
                            }
                            this.fPi.setVisibility(8);
                            this.fPj.setVisibility(8);
                            portrait = b.yX().getPortrait();
                            if (b.yX().getPendantData() == null) {
                            }
                            UtilHelper.showHeadImageViewBigV(this.fOY, b.yX());
                            this.fOY.setVisibility(0);
                            this.fOR.setOnClickListener(this.fRh);
                            this.fOT.setOnClickListener(this.fRh);
                            this.fOY.setOnClickListener(this.fRh);
                            this.fOW.setVisibility(8);
                            this.fOY.startLoad(portrait, 28, false);
                            String name_show22 = b.yX().getName_show();
                            String userName22 = b.yX().getUserName();
                            if (com.baidu.tbadk.o.ac.nu()) {
                            }
                        }
                        e = string;
                        ArrayList<IconData> iconInfo222 = b.yX().getIconInfo();
                        tShowInfoNew = b.yX().getTShowInfoNew();
                        if (this.fJe != null) {
                        }
                        if (this.fJd != null) {
                        }
                        this.fOT.setText(af(b.yX().getSealPrefix(), e));
                        this.fOT.setTag(d.g.tag_user_id, b.yX().getUserId());
                        this.fOT.setTag(d.g.tag_user_name, b.yX().getName_show());
                        if (com.baidu.tbadk.core.util.v.G(tShowInfoNew)) {
                        }
                        com.baidu.tbadk.core.util.aj.e(this.fOT, d.C0108d.cp_cont_h, 1);
                        this.fOU.setVisibility(8);
                        if (fVar.aYA().yX() != null) {
                        }
                        this.fOY.setUserId(b.yX().getUserId());
                        this.fOY.setUserName(b.yX().getUserName());
                        this.fOY.setImageDrawable(null);
                        this.fOY.setRadius(com.baidu.adp.lib.util.l.s(this.fHW.getActivity(), d.e.ds40));
                        this.fOY.setTag(b.yX().getUserId());
                        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(b.getTime()), "yyyy"))) {
                        }
                        s = com.baidu.adp.lib.util.l.s(this.fHW.getActivity(), d.e.ds16);
                        if (!this.fHW.baP()) {
                        }
                        this.djB.setVisibility(8);
                        this.fPk.setVisibility(8);
                        this.fPh.setPadding(0, 0, s, 0);
                        bCp = b.bCp();
                        if (bCp == null) {
                        }
                        this.fPi.setVisibility(8);
                        this.fPj.setVisibility(8);
                        portrait = b.yX().getPortrait();
                        if (b.yX().getPendantData() == null) {
                        }
                        UtilHelper.showHeadImageViewBigV(this.fOY, b.yX());
                        this.fOY.setVisibility(0);
                        this.fOR.setOnClickListener(this.fRh);
                        this.fOT.setOnClickListener(this.fRh);
                        this.fOY.setOnClickListener(this.fRh);
                        this.fOW.setVisibility(8);
                        this.fOY.startLoad(portrait, 28, false);
                        String name_show222 = b.yX().getName_show();
                        String userName222 = b.yX().getUserName();
                        if (com.baidu.tbadk.o.ac.nu()) {
                        }
                    }
                }
                if (fVar != null) {
                    this.fOQ.W(fVar.aYA());
                }
                if (this.fQm != null) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.fCA);
                    if (fVar != null && fVar.aYA() != null) {
                        jVar.fCC = fVar.aYA().yP();
                    }
                    jVar.btL = !this.fDw;
                    jVar.fCE = this.fHW.baO();
                    this.fQm.a(jVar);
                }
            }
        }
    }

    public void kt(boolean z) {
        if (z) {
            bdB();
        } else {
            bdC();
        }
        this.fQq.fRz = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fQq));
        a(this.fQq.fRz, false);
    }

    public void bdB() {
        if (this.fOH != null && !this.fQH) {
            this.fOH.kO(!StringUtils.isNull(this.fHW.bak()));
            this.fQH = true;
        }
    }

    public void bdC() {
        if (this.fOH != null) {
            this.fOH.beF();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        if (postData != null && postData.zt() != null) {
            this.fOS.a(this.fHW.getPageContext(), fVar.aYC().get(0).zt(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", fVar.aYy().getId(), fVar.aYy().getName(), fVar.aYA().getId(), this.fHW.baL() ? "FRS" : null));
            this.fOR.setPadding(this.fOR.getPaddingLeft(), (int) this.fHW.getResources().getDimension(d.e.ds20), this.fOR.getPaddingRight(), this.fOR.getPaddingBottom());
            return;
        }
        this.fOS.a(null, null, null);
    }

    public void bdD() {
        if (this.fOB != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11997").s("obj_type", 1));
            this.fOB.bfR();
            this.fOL.smoothScrollToPosition(0);
        }
    }

    public boolean bdE() {
        return this.fRi;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean Y(be beVar) {
        if (beVar == null || beVar.yX() == null || beVar.yX().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), beVar.yX().getUserId());
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.fOH.beD();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.fOH.nP(eVar.forumName);
            }
            String string = this.fHW.getResources().getString(d.j.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.g.b.h(eVar.source, 0)) {
                case 100:
                    str = this.fHW.getResources().getString(d.j.self);
                    break;
                case 300:
                    str = this.fHW.getResources().getString(d.j.bawu);
                    break;
                case HttpStatus.SC_BAD_REQUEST /* 400 */:
                    str = this.fHW.getResources().getString(d.j.system);
                    break;
            }
            String format = String.format(string, str);
            final String str2 = eVar.fBL;
            this.fHW.showNetRefreshView(this.dhJ, format, null, this.fHW.getResources().getString(d.j.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.as.20
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.oZ()) {
                        com.baidu.tbadk.core.util.av.Di().c(as.this.fHW.getPageContext(), new String[]{str2});
                        as.this.fHW.finish();
                        return;
                    }
                    as.this.fHW.showToast(d.j.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        Parcelable bcK;
        Parcelable bcK2;
        String str;
        if (fVar != null) {
            this.fLg = fVar;
            this.mType = i;
            if (fVar.aYA() != null) {
                this.fQs = fVar.aYA().yI();
                if (fVar.aYA().getAnchorLevel() != 0) {
                    this.fRi = true;
                }
                this.fPO = Y(fVar.aYA());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            t(fVar);
            this.fQc = false;
            this.fDw = z;
            bdx();
            b(fVar, z, i);
            r(fVar);
            if (this.fQT == null) {
                this.fQT = new ac(this.fHW.getPageContext(), this.dNM);
            }
            this.fQT.qd(fVar.aYG());
            if (this.fHW.baB()) {
                if (this.fPw == null) {
                    this.fPw = new com.baidu.tieba.pb.view.i(this.fHW.getPageContext());
                    this.fPw.su();
                    this.fPw.a(this.baS);
                }
                this.fOL.setPullRefresh(this.fPw);
                bdF();
                if (this.fPw != null) {
                    this.fPw.gy(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.yb().xY() == 0 && z) {
                this.fOL.setPullRefresh(null);
            } else {
                if (this.fPw == null) {
                    this.fPw = new com.baidu.tieba.pb.view.i(this.fHW.getPageContext());
                    this.fPw.su();
                    this.fPw.a(this.baS);
                }
                this.fOL.setPullRefresh(this.fPw);
                bdF();
                if (this.fPw != null) {
                    this.fPw.gy(TbadkCoreApplication.getInst().getSkinType());
                }
                afk();
            }
            bdH();
            this.fPs.jB(this.fDw);
            this.fPs.jC(false);
            this.fPs.jN(i == 5);
            this.fPs.jO(i == 6);
            this.fPs.jP(z2 && this.fRg);
            this.fPs.a(fVar, false);
            this.fPs.notifyDataSetChanged();
            if (this.fHW.baP()) {
                this.fQJ = 0;
                PostData b = b(fVar, z);
                if (b != null && b.yX() != null) {
                    this.fQJ = b.yX().getLevel_id();
                }
                if (this.fQJ > 0) {
                    this.fOV.setVisibility(0);
                    com.baidu.tbadk.core.util.aj.c(this.fOV, BitmapHelper.getGradeResourceIdInEnterForum(this.fQJ));
                } else {
                    this.fOV.setVisibility(8);
                }
            } else {
                this.fOV.setVisibility(8);
            }
            if (fVar.aYA() != null) {
                if (fVar.aYA().yM() != null) {
                    if (fVar.aYA().yM().getNum() < 1) {
                        str = this.fHW.getResources().getString(d.j.zan);
                    } else {
                        str = fVar.aYA().yM().getNum() + "";
                    }
                    if (this.fOA != -1) {
                        fVar.aYA().yM().setIsLike(this.fOA);
                    }
                    S(str, fVar.aYA().yM().getIsLike() == 1);
                }
                if (fVar.aYA().aPb != null && fVar.aYA().aPb.isDeleted) {
                    this.fOH.kJ(true);
                } else {
                    this.fOH.kJ(false);
                }
            }
            if (this.fHW.isLogin()) {
                this.fOL.setNextPage(this.dBm);
                this.fOG = 2;
                afk();
            } else {
                this.fQc = true;
                if (fVar.yb().xX() == 1) {
                    if (this.fPx == null) {
                        this.fPx = new com.baidu.tieba.pb.view.b(this.fHW.getPageContext());
                    }
                    this.fOL.setNextPage(this.fPx);
                } else {
                    this.fOL.setNextPage(this.dBm);
                }
                this.fOG = 3;
            }
            ArrayList<PostData> aYC = fVar.aYC();
            if (fVar.yb().xX() == 0 || aYC == null || aYC.size() < fVar.yb().xW()) {
                if (com.baidu.tbadk.core.util.v.F(aYC) == 0 || (com.baidu.tbadk.core.util.v.F(aYC) == 1 && aYC.get(0) != null && aYC.get(0).bCl() == 1)) {
                    this.dBm.setText(this.fHW.getResources().getString(d.j.list_no_more_new));
                    if (this.fHW.bac() != null && !this.fHW.bac().beu()) {
                        this.fHW.bac().showFloatingView();
                    }
                } else {
                    this.dBm.setText(this.fHW.getResources().getString(d.j.list_has_no_more));
                }
                if (this.fHW.baB() && this.fOL != null && this.fOL.getData() != null && this.fOL.getData().size() == 1 && (this.fOL.getData().get(0) instanceof com.baidu.tieba.pb.data.i)) {
                    this.dBm.setText("");
                }
                bdO();
            } else if (z2) {
                if (this.fRg) {
                    DU();
                    if (fVar.yb().xX() != 0) {
                        this.dBm.setText(this.fHW.getResources().getString(d.j.pb_load_more));
                    }
                } else {
                    this.dBm.DP();
                    this.dBm.showLoading();
                }
            } else {
                this.dBm.DP();
                this.dBm.showLoading();
            }
            switch (i) {
                case 2:
                    this.fOL.setSelection(i2 > 1 ? (((this.fOL.getData() == null && fVar.aYC() == null) ? 0 : (this.fOL.getData().size() - fVar.aYC().size()) + this.fOL.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (bcK2 = aj.bcJ().bcK()) != null) {
                        this.fOL.onRestoreInstanceState(bcK2);
                        if (com.baidu.tbadk.core.util.v.F(aYC) > 1 && fVar.yb().xX() > 0) {
                            this.dBm.DU();
                            this.dBm.setText(this.fHW.getString(d.j.pb_load_more_without_point));
                            this.dBm.DQ();
                            break;
                        }
                    } else {
                        this.fOL.setSelection(0);
                        break;
                    }
                    break;
                case 4:
                    this.fRg = false;
                    break;
                case 5:
                    this.fOL.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (bcK = aj.bcJ().bcK()) != null) {
                        this.fOL.onRestoreInstanceState(bcK);
                        break;
                    } else {
                        this.fOL.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.fOB != null && this.fOB.bfQ() != null) {
                            if (this.fHW.isUseStyleImmersiveSticky()) {
                                this.fOL.setSelectionFromTop((this.fPs.bbe() + this.fOL.getHeaderViewsCount()) - 1, this.fOB.bfQ().getHeight() - com.baidu.adp.lib.util.l.n(this.fHW.getPageContext().getPageActivity()));
                            } else {
                                this.fOL.setSelectionFromTop((this.fPs.bbe() + this.fOL.getHeaderViewsCount()) - 1, this.fOB.bfQ().getHeight());
                            }
                        } else {
                            this.fOL.setSelection(this.fPs.bbe() + this.fOL.getHeaderViewsCount());
                        }
                    } else {
                        this.fOL.setSelection(i2 > 0 ? ((this.fOL.getData() == null && fVar.aYC() == null) ? 0 : (this.fOL.getData().size() - fVar.aYC().size()) + this.fOL.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.dBm.DU();
                    this.dBm.setText(this.fHW.getString(d.j.pb_load_more_without_point));
                    this.dBm.DQ();
                    break;
            }
            if (this.fQs == fQt && isHost()) {
                bdW();
            }
            if (this.fQD) {
                bcV();
                this.fQD = false;
                if (i3 == 0) {
                    km(true);
                }
            }
            if (this.fOD != null) {
                this.fOD.ad(fVar.aYA());
            }
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar.fCr == 1 || fVar.fCs == 1) {
                if (this.fQK == null) {
                    this.fQK = new PbTopTipView(this.fHW);
                }
                if (fVar.fCs == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.fHW.getStType())) {
                    this.fQK.setText(this.fHW.getString(d.j.pb_read_strategy_add_experience));
                    this.fQK.show(this.dhJ, this.mSkinType);
                } else if (fVar.fCr == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.fHW.getStType())) {
                    this.fQK.setText(this.fHW.getString(d.j.pb_read_news_add_experience));
                    this.fQK.show(this.dhJ, this.mSkinType);
                }
            }
        }
    }

    private void bdF() {
        if (this.fOB != null && this.fOB.bfQ() != null) {
            this.fOL.removeHeaderView(this.bmg);
            if (this.mType != 1) {
                this.fOL.removeHeaderView(this.fOB.bfS());
                this.fOL.addHeaderView(this.fOB.bfS(), 0);
                return;
            }
            return;
        }
        if (this.fOB != null) {
            this.fOL.removeHeaderView(this.fOB.bfS());
        }
        this.fOL.removeHeaderView(this.bmg);
        this.fOL.addHeaderView(this.bmg, 0);
    }

    public void ku(boolean z) {
        this.fPN = z;
    }

    public void DU() {
        if (this.dBm != null) {
            this.dBm.DQ();
            this.dBm.DU();
        }
        afk();
    }

    public void WZ() {
        this.fOL.setVisibility(0);
    }

    public void r(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.fQb != null && this.fQb.yX() != null && this.fOH != null) {
            this.fQG = !this.fQF;
            this.fOH.kI(this.fQG);
            if (this.fHW.bac() != null) {
                this.fHW.bac().kH(this.fQG);
            }
            bdG();
            if (this.fQG) {
                this.fOH.fTI.setVisibility(0);
                if (this.fPO) {
                    this.fOH.fTJ.setVisibility(8);
                    this.fPd.setVisibility(8);
                    this.fPg.setVisibility(0);
                    this.fPg.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.E(fVar.aYX())));
                } else if (!PbNormalLikeButtonSwitchStatic.Ou() || (this.fQb.yX().hadConcerned() && this.fQb.yX().getGodUserData() != null && this.fQb.yX().getGodUserData().getIsFromNetWork())) {
                    this.fOH.fTJ.setVisibility(8);
                }
                if (this.fQl != null) {
                    this.fQl.setVisibility(8);
                }
                this.fOH.a(this.fQb.yX(), this.fRh);
                if (this.fQR == null) {
                    this.fQR = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.as.21
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (i < 0 && f > as.this.fQI) {
                                as.this.bdV();
                            }
                        }
                    };
                }
                this.fOL.setListViewDragListener(this.fQR);
                return;
            }
            if (this.fOH.fTI != null) {
                this.fOH.fTI.setVisibility(8);
            }
            if (this.fQl != null) {
                this.fQl.setVisibility(0);
            }
            if (this.fPO) {
                this.fPd.setVisibility(8);
                this.fPg.setVisibility(0);
                this.fPg.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.person_view_num), com.baidu.tbadk.core.util.am.E(fVar.aYX())));
            } else if (!PbNormalLikeButtonSwitchStatic.Ou() || (this.fQb.yX().hadConcerned() && this.fQb.yX().getGodUserData() != null && this.fQb.yX().getGodUserData().getIsFromNetWork())) {
                this.fPd.setVisibility(8);
                this.fPg.setVisibility(8);
            } else {
                this.fPg.setVisibility(8);
            }
            this.fQR = null;
            this.fOL.setListViewDragListener(null);
        }
    }

    private void bdG() {
        String threadId = this.fLg != null ? this.fLg.getThreadId() : "";
        if (this.fQG) {
            if (this.fPf == null) {
                this.fPf = new aq(this.fHW.getPageContext(), this.fOH.fTJ, 3);
                this.fPf.h(this.fHW.getUniqueId());
            }
            if (this.fQb != null && this.fQb.yX() != null) {
                this.fQb.yX().setIsLike(this.fQb.yX().hadConcerned());
                this.fPf.a(this.fQb.yX());
            }
            this.fPf.cK(threadId);
            this.fPf.fOx = this.fQF;
        }
        if (this.fPe == null) {
            this.fPe = new aq(this.fHW.getPageContext(), this.fPd, 1);
            this.fPe.h(this.fHW.getUniqueId());
            this.fPe.a(new c.a() { // from class: com.baidu.tieba.pb.pb.main.as.22
                @Override // com.baidu.tbadk.core.view.userLike.c.a
                public void bu(boolean z) {
                    if (as.this.fHW != null && z) {
                        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("user_like_success_dialog", 0);
                        if (i >= 2) {
                            com.baidu.adp.lib.util.l.showToast(as.this.fHW, d.j.attention_success);
                            return;
                        }
                        ar.u(as.this.fHW.getPageContext());
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("user_like_success_dialog", i + 1);
                    }
                }
            });
        }
        if (this.fQb != null && this.fQb.yX() != null) {
            this.fQb.yX().setIsLike(this.fQb.yX().hadConcerned());
            this.fPe.a(this.fQb.yX());
            this.fPe.cK(threadId);
        }
        this.fPe.fOx = this.fQF;
    }

    private boolean bdH() {
        boolean z;
        if (this.fPR != null && this.fPR.getVisibility() == 0) {
            if (this.fPo != null) {
                this.fPo.setVisibility(0);
                z = true;
            } else {
                z = true;
            }
        } else {
            if (this.fPo != null) {
                this.fPo.setVisibility(8);
            }
            z = false;
        }
        if ((this.fPq == null || this.fPq.getVisibility() == 8) && z && this.fDw) {
            this.fPp.setVisibility(0);
        } else {
            this.fPp.setVisibility(8);
        }
        return z;
    }

    private boolean s(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aYA() == null) {
            return false;
        }
        if (fVar.aYA().yU() == 1 || fVar.aYA().getThreadType() == 33) {
            return true;
        }
        return !(fVar.aYA().yW() == null || fVar.aYA().yW().Aw() == 0) || fVar.aYA().yS() == 1 || fVar.aYA().yT() == 1 || fVar.aYA().zC() || fVar.aYA().zQ() || fVar.aYA().zJ() || fVar.aYA().zk() != null || fVar.aYA().zR() || fVar.aYA().zR() || !com.baidu.tbadk.core.util.am.isEmpty(fVar.aYA().getCategory()) || fVar.aYA().zb() || fVar.aYA().za();
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new k.a(str));
            return com.baidu.tieba.card.k.a((Context) this.fHW.getActivity(), str2, (ArrayList<k.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.fON != null) {
                if (fVar.aYA() != null && fVar.aYA().zn() == 0 && !fVar.aYA().zK() && !this.fQV) {
                    this.fON.setVisibility(0);
                    if (fVar.aYA() != null) {
                        fVar.aYA().h(true, s(fVar));
                    }
                    SpannableStringBuilder zx = fVar.aYA().zx();
                    this.fOO.setOnTouchListener(new com.baidu.tieba.view.m(zx));
                    if (this.fQS) {
                        this.fOO.setText(fVar.aYA().getTitle());
                    } else {
                        this.fOO.setText(zx);
                    }
                    this.fOO.setVisibility(0);
                } else if (fVar.aYA().zn() == 1) {
                    if (fVar.aYA() != null) {
                        this.fON.setVisibility(8);
                        this.fOL.removeHeaderView(this.fON);
                        if (fVar.aYA() != null && !fVar.aYA().zK()) {
                            this.fOR.setPadding(this.fOR.getPaddingLeft(), com.baidu.adp.lib.util.l.s(this.fHW.getPageContext().getPageActivity(), d.e.tbds36), this.fOR.getPaddingRight(), this.fOR.getPaddingBottom());
                        }
                    }
                } else {
                    this.fON.setVisibility(8);
                    this.fOL.removeHeaderView(this.fON);
                    if (fVar.aYA() != null && fVar.aYA().zK()) {
                        this.fOR.setPadding(this.fOR.getPaddingLeft(), 0, this.fOR.getPaddingRight(), this.fOR.getPaddingBottom());
                    } else {
                        this.fOR.setPadding(this.fOR.getPaddingLeft(), com.baidu.adp.lib.util.l.s(this.fHW.getPageContext().getPageActivity(), d.e.ds48), this.fOR.getPaddingRight(), this.fOR.getPaddingBottom());
                    }
                }
            }
            this.fDw = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            bdH();
        }
    }

    public SparseArray<Object> c(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.t tVar;
        StringBuilder sb = null;
        if (fVar != null && (b = b(fVar, z)) != null) {
            String userId = b.yX().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(fVar.aYN()));
                sparseArray.put(d.g.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.yX() != null) {
                    sparseArray.put(d.g.tag_forbid_user_name, b.yX().getUserName());
                    sparseArray.put(d.g.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(d.g.tag_del_post_id, b.getId());
                sparseArray.put(d.g.tag_del_post_type, 0);
                sparseArray.put(d.g.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(d.g.tag_manage_user_identity, Integer.valueOf(fVar.aYN()));
                sparseArray.put(d.g.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<az> aYW = fVar.aYW();
                if (com.baidu.tbadk.core.util.v.F(aYW) > 0) {
                    sb = new StringBuilder();
                    for (az azVar : aYW) {
                        if (azVar != null && !StringUtils.isNull(azVar.getForumName()) && (tVar = azVar.aMT) != null && tVar.aKY && !tVar.isDeleted && (tVar.type == 1 || tVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.k(azVar.getForumName(), 12)).append(this.fHW.getString(d.j.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(d.g.tag_del_multi_forum, String.format(this.fHW.getString(d.j.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View getNextView() {
        return this.bwW;
    }

    public void qe(String str) {
        if (this.dBm != null) {
            this.dBm.setText(str);
        }
    }

    public BdTypeListView getListView() {
        return this.fOL;
    }

    public int bdI() {
        return d.g.richText;
    }

    public TextView aZX() {
        return this.fOQ.aZX();
    }

    public void d(BdListView.e eVar) {
        this.fOL.setOnSrollToBottomListener(eVar);
    }

    public void a(i.b bVar) {
        this.baS = bVar;
        if (this.fPw != null) {
            this.fPw.a(bVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.am amVar, a.b bVar) {
        if (amVar != null) {
            int xV = amVar.xV();
            int xS = amVar.xS();
            if (this.fPt != null) {
                this.fPt.AI();
            } else {
                this.fPt = new com.baidu.tbadk.core.dialog.a(this.fHW.getPageContext().getPageActivity());
                this.fPu = LayoutInflater.from(this.fHW.getPageContext().getPageActivity()).inflate(d.h.dialog_direct_pager, (ViewGroup) null);
                this.fPt.aO(this.fPu);
                this.fPt.a(d.j.dialog_ok, bVar);
                this.fPt.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.24
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        as.this.bdK();
                        aVar.dismiss();
                    }
                });
                this.fPt.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.as.25
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (as.this.fQA == null) {
                            as.this.fQA = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    as.this.fHW.HidenSoftKeyPad((InputMethodManager) as.this.fHW.getSystemService("input_method"), as.this.dhJ);
                                }
                            };
                        }
                        com.baidu.adp.lib.g.e.nr().postDelayed(as.this.fQA, 150L);
                    }
                });
                this.fPt.b(this.fHW.getPageContext()).AI();
            }
            this.fPv = (EditText) this.fPu.findViewById(d.g.input_page_number);
            this.fPv.setText("");
            TextView textView = (TextView) this.fPu.findViewById(d.g.current_page_number);
            if (xV <= 0) {
                xV = 1;
            }
            if (xS <= 0) {
                xS = 1;
            }
            textView.setText(MessageFormat.format(this.fHW.getApplicationContext().getResources().getString(d.j.current_page), Integer.valueOf(xV), Integer.valueOf(xS)));
            this.fHW.ShowSoftKeyPadDelay(this.fPv, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fOL.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.fHW.showToast(str);
    }

    public boolean kv(boolean z) {
        if (this.axO == null || !this.axO.KI()) {
            return false;
        }
        this.axO.IP();
        return true;
    }

    public void bdJ() {
        if (this.fRj != null) {
            while (this.fRj.size() > 0) {
                TbImageView remove = this.fRj.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        bdJ();
        this.fPs.sQ(1);
        if (this.fOB != null) {
            this.fOB.onPause();
        }
    }

    public void onResume() {
        this.fPs.sQ(2);
        if (this.fOB != null) {
            this.fOB.onResume();
            getView().setSystemUiVisibility(4);
        }
    }

    public void onDestroy() {
        if (this.fQC != null) {
            this.fQC.destroy();
        }
        if (this.fQT != null) {
            this.fQT.onDestory();
        }
        if (this.fQK != null) {
            this.fQK.hide();
        }
        if (this.fOE != null) {
            this.fOE.alo();
        }
        if (this.fOD != null) {
            this.fOD.onDestroy();
        }
        this.fHW.hideProgressBar();
        if (this.dhH != null && this.duP != null) {
            this.dhH.b(this.duP);
        }
        bdK();
        DU();
        if (this.fQA != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.fQA);
        }
        if (this.fOR != null && this.fPc != null) {
            this.fOR.removeView(this.fOX);
            this.fPc = null;
        }
        if (this.fQg != null) {
            this.fQg.clearStatus();
        }
        this.fRc = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.fPs.sQ(3);
        if (this.dyx != null) {
            this.dyx.setBackgroundDrawable(null);
        }
        if (this.fOB != null) {
            this.fOB.destroy();
        }
        if (this.fPs != null) {
            this.fPs.onDestory();
        }
        this.fOL.setOnLayoutListener(null);
        if (this.fQP != null) {
            this.fQP.auK();
        }
        if (this.fQr != null) {
            this.fQr.onDestroy();
        }
        beh();
    }

    public boolean th(int i) {
        if (this.fOB != null) {
            return this.fOB.nb(i);
        }
        return false;
    }

    public void bdK() {
        this.fOH.vU();
        if (this.fOE != null) {
            this.fOE.alo();
        }
        com.baidu.adp.lib.util.l.a(this.fHW.getPageContext().getPageActivity(), this.fPv);
        bcY();
        if (this.fPL != null) {
            this.fPL.dismiss();
        }
        bdM();
        if (this.fOD != null) {
            this.fOD.bfJ();
        }
        if (this.fPt != null) {
            this.fPt.dismiss();
        }
        if (this.dyj != null) {
            this.dyj.dismiss();
        }
    }

    public void bdL() {
        this.fOH.vU();
        if (this.fOE != null) {
            this.fOE.alo();
        }
        if (this.fPL != null) {
            this.fPL.dismiss();
        }
        bdM();
        if (this.fOD != null) {
            this.fOD.bfJ();
        }
        if (this.fPt != null) {
            this.fPt.dismiss();
        }
        if (this.dyj != null) {
            this.dyj.dismiss();
        }
    }

    public void cW(List<String> list) {
        this.fQO = list;
        if (this.fQP != null) {
            this.fQP.setData(list);
        }
    }

    public void jA(boolean z) {
        this.fPs.jA(z);
    }

    public void kw(boolean z) {
        this.fPQ = z;
    }

    public void bdM() {
        if (this.fPC != null) {
            this.fPC.dismiss();
        }
        if (this.fPD != null) {
            com.baidu.adp.lib.g.g.b(this.fPD, this.fHW.getPageContext());
        }
        if (this.fPE != null) {
            com.baidu.adp.lib.g.g.b(this.fPE, this.fHW.getPageContext());
        }
        if (this.fPA != null) {
            com.baidu.adp.lib.g.g.b(this.fPA, this.fHW.getPageContext());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.fLg, this.fDw);
            d(this.fLg, this.fDw, this.mType);
            this.fHW.getLayoutMode().aM(i == 1);
            this.fHW.getLayoutMode().aM(this.dhJ);
            this.fHW.getLayoutMode().aM(this.fOM);
            com.baidu.tbadk.core.util.aj.s(this.fOP, d.C0108d.cp_bg_line_d);
            if (this.fOD != null) {
                this.fOD.onChangeSkinType(i);
            }
            if (this.fOO != null) {
                com.baidu.tbadk.core.util.aj.r(this.fOO, d.C0108d.cp_cont_b);
                this.fOO.setLinkTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_link_tip_c));
            }
            if (this.dBm != null) {
                this.dBm.gy(i);
                if (this.bwW != null) {
                    this.fHW.getLayoutMode().aM(this.bwW);
                    com.baidu.tbadk.core.util.aj.s(this.bwW, d.f.pb_foot_more_trans_selector);
                }
            }
            if (this.fPt != null) {
                this.fPt.c(this.fHW.getPageContext());
            }
            ku(this.fPN);
            this.fPs.notifyDataSetChanged();
            if (this.fPw != null) {
                this.fPw.gy(i);
            }
            if (this.axO != null) {
                this.axO.onChangeSkinType(i);
            }
            if (this.fPb != null) {
                this.fPb.gC(i);
            }
            if (this.fPx != null) {
                this.fPx.gy(i);
            }
            if (!com.baidu.tbadk.core.util.v.G(this.cRE)) {
                for (com.baidu.tieba.pb.pb.main.view.a aVar : this.cRE) {
                    aVar.DD();
                }
            }
            kq(i == 1);
            bdm();
            UtilHelper.setStatusBarBackground(this.dyx, i);
            UtilHelper.setStatusBarBackground(this.fQl, i);
            if (this.fPd != null) {
                this.fPd.onChangeSkinType(i);
            }
            if (this.fPi != null) {
                com.baidu.tbadk.core.util.aj.r(this.fPi, d.C0108d.cp_cont_d);
            }
            if (this.fPh != null) {
                com.baidu.tbadk.core.util.aj.r(this.fPh, d.C0108d.cp_cont_d);
            }
            if (this.fPj != null) {
                com.baidu.tbadk.core.util.aj.s(this.fPj, d.C0108d.cp_cont_e);
            }
            if (this.djB != null) {
                com.baidu.tbadk.core.util.aj.r(this.djB, d.C0108d.cp_cont_d);
            }
            if (this.fPk != null) {
                com.baidu.tbadk.core.util.aj.s(this.fPk, d.C0108d.cp_cont_e);
            }
            if (this.fOU != null) {
                com.baidu.tbadk.core.util.aj.r(this.fOU, d.C0108d.cp_link_tip_a);
            }
            if (this.fPg != null) {
                com.baidu.tbadk.core.util.aj.r(this.fPg, d.C0108d.cp_cont_d);
            }
            if (this.fPl != null) {
                com.baidu.tbadk.n.a.a(this.fHW.getPageContext(), this.fPl);
            }
            if (this.fPJ != null) {
                com.baidu.tbadk.n.a.a(this.fHW.getPageContext(), this.fPJ);
            }
            if (this.fQB != null) {
                this.fQB.onChangeSkinType(i);
            }
            if (this.fOH != null) {
                if (this.fOB != null) {
                    this.fOB.tn(i);
                } else {
                    this.fOH.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.fPT != null) {
                com.baidu.tbadk.core.util.aj.r(this.fPT, d.C0108d.cp_cont_e);
            }
            if (this.fOV != null) {
                com.baidu.tbadk.core.util.aj.c(this.fOV, BitmapHelper.getGradeResourceIdInEnterForum(this.fQJ));
            }
            if (this.fQQ != null) {
                this.fQQ.onChangeSkinType(i);
            }
            if (this.fQr != null) {
                this.fQr.onChangeSkinType();
            }
            if (this.fQN != null) {
                com.baidu.tbadk.core.util.aj.r(this.fQN, d.C0108d.cp_cont_n);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bJx = hVar;
        this.fPs.setOnImageClickListener(this.bJx);
        this.fQQ.setOnImageClickListener(this.bJx);
    }

    public void h(NoNetworkView.a aVar) {
        this.duP = aVar;
        if (this.dhH != null) {
            this.dhH.a(this.duP);
        }
    }

    public void kx(boolean z) {
        this.fPs.setIsFromCDN(z);
    }

    public Button bdN() {
        return this.fPR;
    }

    public void bdO() {
        if (this.fOG != 2) {
            this.fOL.setNextPage(this.dBm);
            this.fOG = 2;
        }
    }

    public void bdP() {
        if (com.baidu.tbadk.k.r.Oa().Ob()) {
            int lastVisiblePosition = this.fOL.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fOL.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(d.g.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog = tbImageView.getPerfLog();
                                perfLog.iq(1001);
                                perfLog.bye = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(d.g.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.k.l perfLog2 = headImageView.getPerfLog();
                        perfLog2.iq(1001);
                        perfLog2.bye = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.startLogPerf();
                    }
                }
            }
        }
    }

    public boolean bdQ() {
        return this.axO != null && this.axO.getVisibility() == 0;
    }

    public boolean bdR() {
        return this.axO != null && this.axO.KI();
    }

    public void bdS() {
        if (this.axO != null) {
            this.axO.IP();
        }
    }

    public void ky(boolean z) {
        if (this.fPS != null) {
            kw(this.fHW.aZY().Lj());
            if (this.fPQ) {
                kn(z);
            } else {
                ko(z);
            }
        }
    }

    public void bdT() {
        if (this.fPS != null) {
            this.fPS.setVisibility(8);
            this.fPX = false;
            if (this.fQr != null) {
                this.fQr.setVisibility(8);
                ks(false);
            }
            beh();
        }
    }

    public void showLoadingDialog() {
        if (this.cYR == null) {
            this.cYR = new com.baidu.tbadk.core.view.b(this.fHW.getPageContext());
        }
        this.cYR.bm(true);
    }

    public void afk() {
        if (this.cYR != null) {
            this.cYR.bm(false);
        }
    }

    private int getScrollY() {
        View childAt = this.fOL.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.fOL.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.fOB != null) {
            this.fOB.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.fgd = getScrollY();
            this.fQq.fRz = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fQq));
            a(this.fQq.fRz, true);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        boolean z;
        if (this.fOB != null) {
            this.fOB.b(absListView, i);
        }
        int headerViewsCount = (i - this.fOL.getHeaderViewsCount()) + 1;
        if (headerViewsCount < 0) {
            headerViewsCount = 0;
        }
        while (true) {
            if (headerViewsCount > i2) {
                z = false;
                break;
            } else if (this.fPs.sP(headerViewsCount) == com.baidu.tieba.pb.data.l.fCH) {
                z = true;
                break;
            } else {
                headerViewsCount++;
            }
        }
        boolean z2 = i < this.fOL.getHeaderViewsCount();
        if (this.fOP != null && this.fOH != null) {
            this.fOH.i(this.fOP.getBottom(), this.fOP.getMeasuredHeight(), z2);
        }
        this.fPs.bbi().m(z, this.fQj != null ? this.fQj.getMeasuredHeight() : 0);
        this.fQq.fxv = i;
        this.fQq.fRy = this.fOL.getHeaderViewsCount();
        this.fQq.fRz = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.fQq));
        a(this.fQq.fRz, false);
    }

    public void bdU() {
        if (this.fHW.isLogin() && this.fLg != null && this.fQG && !this.fQF && !this.fPO && this.fQb != null && this.fQb.yX() != null && !this.fQb.yX().getIsLike() && !this.fQb.yX().hadConcerned()) {
            if (this.fQC == null) {
                this.fQC = new an(this.fHW);
            }
            this.fQC.a(this.fOH.fTI, this.fLg.aZa(), this.fQb.yX().getUserId(), this.fLg.getThreadId());
        }
    }

    public void bdV() {
        if (this.fQG && !this.fQF && this.fQb != null && this.fQb.yX() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12601").s("obj_locate", this.fHW.baP() ? 2 : 1).s("obj_type", this.fQF ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.fHW.getPageContext().getPageActivity(), this.fQb.yX().getUserId(), this.fQb.yX().getUserName(), this.fHW.aZK().bbA(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(al alVar, boolean z) {
        int measuredHeight;
        if (!this.fQF && this.fQk != null && this.fOH.bey() != null) {
            int bbf = this.fPs.bbf();
            if (bbf > 0 && (alVar == null || alVar.getView().getParent() == null)) {
                if (bbf > this.fOL.getFirstVisiblePosition() - this.fOL.getHeaderViewsCount()) {
                    this.fQk.setVisibility(8);
                    return;
                }
                this.fQk.setVisibility(0);
                this.fOH.mNavigationBar.hideBottomLine();
            } else if (alVar == null || alVar.getView() == null || alVar.fNX == null) {
                if (this.fOL.getFirstVisiblePosition() == 0) {
                    this.fQk.setVisibility(8);
                    this.fOH.mNavigationBar.showBottomLine();
                }
            } else {
                int top = alVar.getView().getTop();
                if (alVar.getView().getParent() != null) {
                    if (this.fQp) {
                        this.fQo = top;
                        this.fQp = false;
                    }
                    this.fQo = top < this.fQo ? top : this.fQo;
                }
                if (top != 0 || alVar.getView().isShown()) {
                    if (this.fPr.getY() < 0.0f) {
                        measuredHeight = fQn - alVar.fNX.getMeasuredHeight();
                    } else {
                        measuredHeight = this.fOH.bey().getMeasuredHeight() - alVar.fNX.getMeasuredHeight();
                        this.fOH.mNavigationBar.hideBottomLine();
                    }
                    if (alVar.getView().getParent() == null && top <= this.fQo) {
                        this.fQk.setVisibility(0);
                    } else if (top < measuredHeight) {
                        this.fQk.setVisibility(0);
                    } else {
                        this.fQk.setVisibility(8);
                        this.fOH.mNavigationBar.showBottomLine();
                    }
                    if (z) {
                        this.fQp = true;
                    }
                }
            }
        }
    }

    public void bdW() {
        if (!this.fRk) {
            TiebaStatic.log("c10490");
            this.fRk = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fHW.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(fQu, Integer.valueOf(fQw));
            aVar.fc(d.j.grade_thread_tips);
            View inflate = LayoutInflater.from(this.fHW.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.function_description_view)).setText(d.j.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(d.g.title_view)).setText(d.j.grade_thread_tips);
            aVar.aO(inflate);
            aVar.aE(sparseArray);
            aVar.a(d.j.grade_button_tips, this.fHW);
            aVar.b(d.j.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.fHW.getPageContext()).AI();
        }
    }

    public void qf(String str) {
        if (str.contains("_")) {
            str = str.replace("_", "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fHW.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.fHW.getPageContext().getPageActivity()).inflate(d.h.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(d.g.function_description_view)).setVisibility(8);
        aVar.aO(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(fQu, Integer.valueOf(fQx));
        aVar.aE(sparseArray);
        aVar.a(d.j.view, this.fHW);
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.as.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fHW.getPageContext()).AI();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.yX() != null) {
            MetaData yX = b.yX();
            yX.setGiftNum(yX.getGiftNum() + i);
        }
    }

    public void d(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        b(fVar, z, i);
        r(fVar);
    }

    public PbInterviewStatusView bdX() {
        return this.fQg;
    }

    private void t(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aYA() != null && fVar.aYA().zQ() && this.fQg == null) {
            this.fQg = (PbInterviewStatusView) this.fQf.inflate();
            this.fQg.setOnClickListener(this.dyk);
            this.fQg.setCallback(this.fHW.baK());
            this.fQg.c(this.fHW, fVar);
        }
    }

    public LinearLayout bdY() {
        return this.fPr;
    }

    public View bdZ() {
        return this.dyx;
    }

    public boolean bea() {
        return this.fQV;
    }

    public void jF(boolean z) {
        this.fOQ.jF(z);
    }

    private void beb() {
        if (this.fQV) {
            if (this.fQW == null) {
                e.a aVar = e.fFq.get();
                if (aVar != null) {
                    this.fQW = aVar.a(this.fHW);
                    com.baidu.adp.widget.ListView.e adapter = this.fOL.getAdapter();
                    if (adapter != null) {
                        if (adapter.getView(0, null, null) == this.bmg) {
                            this.fOL.addHeaderView(this.fQW.aZV(), 1);
                        } else {
                            this.fOL.addHeaderView(this.fQW.aZV(), 0);
                        }
                    }
                } else {
                    this.fOP.setVisibility(0);
                    return;
                }
            }
            this.fOP.setVisibility(8);
            this.fOL.removeHeaderView(this.fOP);
            return;
        }
        this.fOP.setVisibility(0);
    }

    public void kz(boolean z) {
        this.fQV = z;
    }

    public void bec() {
        this.fHW.showNetRefreshView(getView(), "");
        View Mt = this.fHW.getRefreshView().Mt();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Mt.getLayoutParams();
        layoutParams.addRule(3, bdY().getId());
        Mt.setLayoutParams(layoutParams);
        this.fHW.hideLoadingView(getView());
        if (this.fQW != null) {
            this.fOL.removeHeaderView(this.fQW.aZV());
            this.fQW = null;
        }
    }

    public void qg(String str) {
        if (this.fOI != null) {
            this.fOI.setTitle(str);
        }
    }

    private int kA(boolean z) {
        if (this.fQg == null || this.fQg.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.s(this.fHW.getPageContext().getPageActivity(), d.e.ds72);
    }

    private void bed() {
        if (this.fQg != null && this.fQg.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fQg.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.fQg.setLayoutParams(layoutParams);
        }
    }

    public boolean bae() {
        return false;
    }

    public void qh(String str) {
        this.fPT.performClick();
        if (!StringUtils.isNull(str) && this.fHW.aZY() != null && this.fHW.aZY().Ld() != null && this.fHW.aZY().Ld().getInputView() != null) {
            EditText inputView = this.fHW.aZY().Ld().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            bdK();
            if (configuration.orientation == 2) {
                bdT();
                bcY();
            } else {
                bdb();
            }
            if (this.fQB != null) {
                this.fQB.bbm();
            }
            this.fHW.atl();
            this.fPr.setVisibility(8);
            this.fOH.setTitleVisibility(false);
            this.fHW.jL(false);
            if (this.fOB != null) {
                if (configuration.orientation == 1) {
                    bdY().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.fOL.setIsLandscape(true);
                    this.fOL.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.fOL.setIsLandscape(false);
                    if (this.fgd > 0) {
                        this.fOL.smoothScrollBy(this.fgd, 0);
                    }
                }
                this.fOB.onConfigurationChanged(configuration);
            }
        }
    }

    public void kB(boolean z) {
        this.fOF = z;
    }

    public boolean bee() {
        return this.fOB != null && this.fOB.bee();
    }

    public void bef() {
        if (this.fOB != null) {
            this.fOB.onPause();
        }
    }

    public void y(long j, int i) {
        if (this.fOD != null) {
            this.fOD.y(j, i);
        }
        if (this.fOB != null) {
            this.fOB.y(j, i);
        }
    }

    public void jQ(boolean z) {
        this.fPs.jQ(z);
    }

    public void beg() {
        if (this.fQh == null) {
            LayoutInflater.from(this.fHW.getActivity()).inflate(d.h.add_experienced_text, (ViewGroup) this.dhJ, true);
            this.fQh = (ViewGroup) this.dhJ.findViewById(d.g.add_experienced_layout);
            this.fQi = (TextView) this.dhJ.findViewById(d.g.add_experienced);
            com.baidu.tbadk.core.util.aj.r(this.fQi, d.C0108d.cp_cont_i);
            String string = this.fHW.getResources().getString(d.j.experienced_add_success);
            String string2 = this.fHW.getResources().getString(d.j.experienced_add_tip);
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, string2, new ForegroundColorSpan(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_cont_h)));
            this.fQi.setText(spannableString);
        }
        this.fQh.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.as.28
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(300L);
                scaleAnimation2.setStartOffset(300L);
                scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.as.28.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        as.this.fQh.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
                as.this.fQi.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fQi.startAnimation(scaleAnimation);
    }

    public void cy(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            Rect rect = new Rect();
            this.fPS.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.fHW);
            frameLayout.setBackgroundResource(d.f.pic_sign_tip);
            this.fQN = new TextView(this.fHW);
            this.fQN.setText(d.j.connection_tips);
            this.fQN.setGravity(17);
            this.fQN.setPadding(com.baidu.adp.lib.util.l.s(this.fHW, d.e.ds24), 0, com.baidu.adp.lib.util.l.s(this.fHW, d.e.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.s(this.fHW, d.e.ds60);
            frameLayout.addView(this.fQN, layoutParams);
            this.fQM = new PopupWindow(this.fHW);
            this.fQM.setContentView(frameLayout);
            this.fQM.setHeight(-2);
            this.fQM.setWidth(-2);
            this.fQM.setFocusable(true);
            this.fQM.setOutsideTouchable(false);
            this.fQM.setBackgroundDrawable(new ColorDrawable(this.fHW.getResources().getColor(d.C0108d.transparent)));
            this.fOL.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.as.29
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        as.this.fQM.showAsDropDown(as.this.fPS, view.getLeft(), -as.this.fPS.getHeight());
                    } else {
                        as.this.fQM.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_press_collection_tips", true);
        }
    }

    public void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar, String str) {
        if (aVar != null && aVar.beq() != null && !StringUtils.isNull(aVar.beq().pkg_id) && !StringUtils.isNull(aVar.beq().cover) && !StringUtils.isNull(str) && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_pb_single_bar_tips", false) && this.fPU != null && this.fPU.getVisibility() == 0) {
            if (this.fQL == null) {
                View inflate = LayoutInflater.from(this.fHW.getPageContext().getPageActivity()).inflate(d.h.tips_blue_left_down, (ViewGroup) null);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.findViewById(d.g.single_bar_tips_arrow).getLayoutParams();
                layoutParams.gravity = 3;
                layoutParams.setMargins(com.baidu.adp.lib.util.l.s(this.fHW.getPageContext().getPageActivity(), d.e.ds64), 0, 0, 0);
                TextView textView = (TextView) inflate.findViewById(d.g.single_bar_tips);
                textView.setText(d.j.pb_see_single_bar_emotion);
                textView.setOnClickListener(this.dyk);
                this.fQL = new PopupWindow(inflate, -2, -2);
            }
            int[] iArr = new int[2];
            this.fPU.getLocationInWindow(iArr);
            this.fQL.showAtLocation(this.fPU, 0, iArr[0] - com.baidu.adp.lib.util.l.s(this.fHW.getPageContext().getPageActivity(), d.e.ds54), (iArr[1] - this.fPU.getHeight()) - com.baidu.adp.lib.util.l.s(this.fHW.getPageContext().getPageActivity(), d.e.ds8));
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_pb_single_bar_tips", true);
        }
    }

    public void beh() {
        com.baidu.adp.lib.g.g.b(this.fQL);
    }

    public void setIsInterviewLive(boolean z) {
        this.fQS = z;
    }

    public boolean getIsInterviewLive() {
        return this.fQS;
    }

    public void cz(View view) {
        this.fPJ = view;
    }
}
