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
import android.support.media.ExifInterface;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
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
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
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
/* loaded from: classes9.dex */
public class av {
    private EditorTools ZX;
    private View biD;
    private RelativeLayout bjv;
    private View bkf;
    private View eAd;
    private f.c ecS;
    private com.baidu.tieba.pb.a.c eor;
    private NoNetworkView flI;
    private List<CustomBlueCheckRadioButton> gTC;
    private View.OnClickListener hCn;
    private PbListView hGJ;
    private NavigationBarCoverTip ibz;
    private com.baidu.tieba.NEGFeedBack.e ieU;
    private boolean isLandscape;
    private TextView iyQ;
    private PbFragment kbv;
    private com.baidu.tieba.pb.data.e kcE;
    private View.OnClickListener kcu;
    private PbFakeFloorModel keK;
    PbFragment.c kgt;
    public int klX;
    public final com.baidu.tieba.pb.pb.main.view.c klZ;
    private View kmJ;
    private View kmL;
    private View kmM;
    private LinearLayout kmN;
    private HeadImageView kmO;
    private ImageView kmP;
    private ImageView kmQ;
    private ImageView kmR;
    private com.baidu.tieba.pb.view.c kmS;
    private TextView kmT;
    private TextView kmU;
    private int kmW;
    private int kmX;
    private PostData kmY;
    public com.baidu.tieba.pb.pb.main.view.b kma;
    private ViewStub kmb;
    private ViewStub kmc;
    private PbLandscapeListView kmd;
    private PbThreadPostView kme;
    private com.baidu.tieba.pb.pb.main.a.e kmf;
    private com.baidu.tieba.pb.pb.main.a.a kmg;
    private com.baidu.tieba.pb.pb.main.a.c kmh;
    private com.baidu.tieba.pb.pb.main.a.d kmi;
    private com.baidu.tieba.pb.pb.main.a.b kmj;
    private LinearLayout kmk;
    private TextView kml;
    private TextView kmm;
    private ObservedChangeRelativeLayout kmn;
    private g kmo;
    private View kmu;
    private int knB;
    private PbTopTipView knC;
    private PopupWindow knD;
    private TextView knE;
    private List<String> knF;
    private com.baidu.tieba.pb.pb.main.emotion.c knG;
    private com.baidu.tieba.pb.pb.godreply.a knH;
    private PbLandscapeListView.b knI;
    private ah knK;
    private String knL;
    private long knM;
    private boolean knO;
    private Runnable knS;
    private PbFragment.b knU;
    public int knY;
    private ViewStub kna;
    private PbInterviewStatusView knb;
    private FrameLayout knc;
    private View knd;
    private View kne;
    private aq knf;
    private PbEmotionBar knk;
    private int kns;
    private Runnable knt;
    private t knu;
    private ar knv;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int kng = UtilHelper.getLightStatusBarHeight();
    public static int knm = 3;
    public static int knn = 0;
    public static int kno = 3;
    public static int knp = 4;
    public static int knq = 5;
    public static int knr = 6;
    private static a.InterfaceC0743a knN = new a.InterfaceC0743a() { // from class: com.baidu.tieba.pb.pb.main.av.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0743a
        public void onRefresh() {
        }
    };
    private int klY = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a kmp = null;
    private com.baidu.tbadk.core.dialog.b hCm = null;
    private View kmq = null;
    private EditText kmr = null;
    private com.baidu.tieba.pb.view.d kms = null;
    private com.baidu.tieba.pb.view.a kmt = null;
    private b.a iVz = null;
    private TbRichTextView.i eLw = null;
    private NoNetworkView.a hwW = null;
    private com.baidu.tbadk.core.dialog.i kmv = null;
    private com.baidu.tbadk.core.dialog.a kmw = null;
    private Dialog kmx = null;
    private Dialog kmy = null;
    private View kmz = null;
    private LinearLayout kmA = null;
    private CompoundButton.OnCheckedChangeListener gTD = null;
    private TextView kmB = null;
    private TextView kmC = null;
    private String kmD = null;
    private com.baidu.tbadk.core.dialog.i kfv = null;
    private com.baidu.tbadk.core.dialog.i kmE = null;
    private boolean kmF = false;
    private boolean kmG = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView kmH = null;
    private boolean kmI = false;
    private Button kmK = null;
    private boolean kmV = true;
    private com.baidu.tbadk.core.view.a gXx = null;
    private boolean kcm = false;
    private int mSkinType = 3;
    private boolean kmZ = false;
    private int knh = 0;
    private boolean kni = true;
    public a knj = new a();
    private int knl = 0;
    private boolean knw = false;
    private int knx = 0;
    private boolean kny = false;
    private boolean knz = false;
    private boolean knA = false;
    private boolean knJ = false;
    private String knP = null;
    private CustomMessageListener knQ = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.av.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                av.this.knP = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.av.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && av.this.kmo != null) {
                av.this.kmo.notifyDataSetChanged();
            }
        }
    };
    private Handler knR = new Handler();
    private CustomMessageListener knT = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.av.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                av.this.kmV = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean knV = true;
    View.OnClickListener knW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.av.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || av.this.kcE == null || av.this.kcE.cGN() == null || av.this.kcE.cGN().aSp() == null || av.this.kcE.cGN().aSp().getAlaInfo() == null || av.this.kcE.cGN().aSp().getAlaInfo().live_status != 1) {
                if (av.this.kny) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11923").ag("obj_id", 2));
                }
                if (!av.this.kny && av.this.kcE != null && av.this.kcE.cGN() != null && av.this.kcE.cGN().aSp() != null && av.this.kcE.cGN().aSp().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12151").ag("obj_locate", 1));
                }
                if (av.this.kbv.cJI() != null) {
                    av.this.kbv.cJI().kbH.hjK.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c11851");
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aoVar);
            if (av.this.kcE.cGN().aSp().getAlaInfo() == null || !av.this.kcE.cGN().aSp().getAlaInfo().isChushou) {
                if (av.this.kcE.cGN().aSp().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = av.this.kcE.cGN().aSp().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(av.this.kbv.cJI(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            bc.aWU().b(av.this.kbv.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + av.this.kcE.cGN().aSp().getAlaInfo().thirdRoomId + "&livetype=" + av.this.kcE.cGN().aSp().getAlaInfo().thirdLiveType});
        }
    };
    private boolean aRq = false;
    String userId = null;
    private final List<TbImageView> knX = new ArrayList();
    private boolean knZ = false;

    /* loaded from: classes9.dex */
    public static class a {
        public int headerCount;
        public int jSs;
        public aq kon;
    }

    public void sc(boolean z) {
        this.knw = z;
        if (this.kmd != null) {
            this.knx = this.kmd.getHeaderViewsCount();
        }
    }

    public void cLH() {
        if (this.kmd != null) {
            int headerViewsCount = this.kmd.getHeaderViewsCount() - this.knx;
            final int firstVisiblePosition = (this.kmd.getFirstVisiblePosition() == 0 || this.kmd.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.kmd.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.kmd.getChildAt(0);
            final int top2 = childAt != null ? childAt.getTop() : -1;
            this.knj.kon = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.knj));
            final aq aqVar = this.knj.kon;
            final int g = g(aqVar);
            final int y = ((int) this.kmn.getY()) + this.kmn.getMeasuredHeight();
            final boolean z = this.knd.getVisibility() == 0;
            boolean z2 = this.kmn.getY() < 0.0f;
            if ((z && aqVar != null) || firstVisiblePosition >= this.kmo.cIC() + this.kmd.getHeaderViewsCount()) {
                int measuredHeight = aqVar != null ? aqVar.klx.getMeasuredHeight() : 0;
                if (z2) {
                    this.kmd.setSelectionFromTop(this.kmo.cIC() + this.kmd.getHeaderViewsCount(), kng - measuredHeight);
                } else {
                    this.kmd.setSelectionFromTop(this.kmo.cIC() + this.kmd.getHeaderViewsCount(), this.klZ.cND().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.kmd.setSelectionFromTop(firstVisiblePosition, top2);
            }
            if (this.kny && this.kmf != null) {
                this.kmd.setSelectionFromTop(this.kmo.cIC() + this.kmd.getHeaderViewsCount(), this.kmf.cNp());
            } else if (this.mType == 6) {
                this.kmd.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.av.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void cJT() {
                        ViewGroup.LayoutParams layoutParams;
                        if (g >= 0 && g <= av.this.bjv.getMeasuredHeight()) {
                            int g2 = av.this.g(aqVar);
                            int i = g2 - g;
                            if (z && i != 0 && g <= y) {
                                i = g2 - y;
                            }
                            if (av.this.bkf != null && (layoutParams = av.this.bkf.getLayoutParams()) != null) {
                                if (i == 0 || i > av.this.bjv.getMeasuredHeight() || g2 >= av.this.bjv.getMeasuredHeight()) {
                                    layoutParams.height = av.this.kns;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > av.this.bjv.getMeasuredHeight()) {
                                    layoutParams.height = av.this.kns;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    av.this.kmd.setSelectionFromTop(firstVisiblePosition, top2);
                                }
                                av.this.bkf.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.av.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (av.this.bkf != null && av.this.bkf.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = av.this.bkf.getLayoutParams();
                                            layoutParams2.height = av.this.kns;
                                            av.this.bkf.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        av.this.kmd.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(aq aqVar) {
        if (aqVar == null || aqVar.getView() == null) {
            return 0;
        }
        if (aqVar.getView().getTop() != 0 || aqVar.getView().isShown()) {
            return aqVar.getView().getBottom();
        }
        return 0;
    }

    public NoNetworkView cLI() {
        return this.flI;
    }

    public void cLJ() {
        if (this.ZX != null) {
            this.ZX.hide();
            if (this.knG != null) {
                this.knG.cNr();
            }
        }
    }

    public PbFakeFloorModel cLK() {
        return this.keK;
    }

    public t cLL() {
        return this.knu;
    }

    public com.baidu.tieba.pb.pb.main.a.e cLM() {
        return this.kmf;
    }

    public void cLN() {
        reset();
        cLJ();
        this.knu.cIK();
        so(false);
    }

    private void reset() {
        if (this.kbv != null && this.kbv.cIP() != null && this.ZX != null) {
            com.baidu.tbadk.editortools.pb.a.bfx().setStatus(0);
            com.baidu.tbadk.editortools.pb.e cIP = this.kbv.cIP();
            cIP.bfS();
            cIP.bfk();
            if (cIP.getWriteImagesInfo() != null) {
                cIP.getWriteImagesInfo().setMaxImagesAllowed(cIP.isBJH ? 1 : 9);
            }
            cIP.nH(SendView.ALL);
            cIP.nI(SendView.ALL);
            com.baidu.tbadk.editortools.g ny = this.ZX.ny(23);
            com.baidu.tbadk.editortools.g ny2 = this.ZX.ny(2);
            com.baidu.tbadk.editortools.g ny3 = this.ZX.ny(5);
            if (ny2 != null) {
                ny2.display();
            }
            if (ny3 != null) {
                ny3.display();
            }
            if (ny != null) {
                ny.hide();
            }
            this.ZX.invalidate();
        }
    }

    public boolean cLO() {
        return this.kmV;
    }

    public void sd(boolean z) {
        if (this.kmM != null && this.iyQ != null) {
            this.iyQ.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kmM.startAnimation(alphaAnimation);
            }
            this.kmL.setVisibility(0);
            this.kmM.setVisibility(0);
            this.kmV = true;
            if (this.knk != null && !this.knH.isActive()) {
                this.knk.setVisibility(0);
                si(true);
            }
        }
    }

    public void se(boolean z) {
        if (this.kmM != null && this.iyQ != null) {
            this.iyQ.setText(cLP());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kmM.startAnimation(alphaAnimation);
            }
            this.kmL.setVisibility(0);
            this.kmM.setVisibility(0);
            this.kmV = true;
            if (this.knk != null && !this.knH.isActive()) {
                this.knk.setVisibility(0);
                si(true);
            }
        }
    }

    public String cLP() {
        if (!com.baidu.tbadk.core.util.ar.isEmpty(this.knL)) {
            return this.knL;
        }
        if (this.kbv != null) {
            this.knL = TbadkCoreApplication.getInst().getResources().getString(au.cLE());
        }
        return this.knL;
    }

    public PostData cLQ() {
        int i = 0;
        if (this.kmd == null) {
            return null;
        }
        int cLR = cLR() - this.kmd.getHeaderViewsCount();
        if (cLR < 0) {
            cLR = 0;
        }
        if (this.kmo.Bd(cLR) != null && this.kmo.Bd(cLR) != PostData.lFL) {
            i = cLR + 1;
        }
        return this.kmo.getItem(i) instanceof PostData ? (PostData) this.kmo.getItem(i) : null;
    }

    public int cLR() {
        int i;
        View childAt;
        if (this.kmd == null) {
            return 0;
        }
        int firstVisiblePosition = this.kmd.getFirstVisiblePosition();
        int lastVisiblePosition = this.kmd.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.kmd.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.kmd.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int cLS() {
        return this.kmd.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.kcE != null && this.kcE.cGP() != null && !this.kcE.cGP().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.kcE.cGP().size() && (postData = this.kcE.cGP().get(i)) != null && postData.aSp() != null && !StringUtils.isNull(postData.aSp().getUserId()); i++) {
                if (this.kcE.cGP().get(i).aSp().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.knH != null && this.knH.isActive()) {
                        so(false);
                    }
                    if (this.knk != null) {
                        this.knk.sx(true);
                    }
                    this.knP = postData.aSp().getName_show();
                    return;
                }
            }
        }
    }

    public av(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.kbv = null;
        this.bjv = null;
        this.biD = null;
        this.kmd = null;
        this.kmo = null;
        this.hGJ = null;
        this.eAd = null;
        this.hCn = null;
        this.kcu = null;
        this.kmM = null;
        this.iyQ = null;
        this.kna = null;
        this.knB = 0;
        this.knM = 0L;
        this.knM = System.currentTimeMillis();
        this.kbv = pbFragment;
        this.hCn = onClickListener;
        this.eor = cVar;
        this.knB = com.baidu.adp.lib.util.l.getEquipmentWidth(this.kbv.getContext()) / 2;
        this.bjv = (RelativeLayout) LayoutInflater.from(this.kbv.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bjv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.kmJ = this.bjv.findViewById(R.id.bottom_shadow);
        this.ibz = (NavigationBarCoverTip) this.bjv.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.biD = this.bjv.findViewById(R.id.statebar_view);
        this.kmn = (ObservedChangeRelativeLayout) this.bjv.findViewById(R.id.title_wrapper);
        this.flI = (NoNetworkView) this.bjv.findViewById(R.id.view_no_network);
        this.kmd = (PbLandscapeListView) this.bjv.findViewById(R.id.new_pb_list);
        this.knc = (FrameLayout) this.bjv.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.kbv.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.kbv.getActivity(), R.dimen.ds88));
        this.kmd.addHeaderView(this.textView, 0);
        this.kmd.setTextViewAdded(true);
        this.kns = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bkf = new View(this.kbv.getPageContext().getPageActivity());
        this.bkf.setLayoutParams(new AbsListView.LayoutParams(-1, this.kns));
        this.bkf.setVisibility(4);
        this.kmd.addFooterView(this.bkf);
        this.kmd.setOnTouchListener(this.kbv.eEC);
        this.klZ = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bjv);
        if (this.kbv.cJs()) {
            this.kmb = (ViewStub) this.bjv.findViewById(R.id.manga_view_stub);
            this.kmb.setVisibility(0);
            this.kma = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.kma.show();
            this.klZ.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.kbv.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.klZ.cND().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0698a() { // from class: com.baidu.tieba.pb.pb.main.av.25
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0698a
            public void cHO() {
                if (av.this.kmd != null) {
                    if (av.this.kmf != null) {
                        av.this.kmf.cNo();
                    }
                    av.this.kmd.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0698a
            public void cHP() {
                av.this.kbv.bYx();
            }
        }));
        this.kmL = this.bjv.findViewById(R.id.view_comment_top_line);
        this.kmM = this.bjv.findViewById(R.id.pb_editor_tool_comment);
        this.kmW = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.kmX = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.kmO = (HeadImageView) this.bjv.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.kmO.setVisibility(com.baidu.tbadk.a.d.aNW() ? 0 : 8);
        if (com.baidu.tbadk.a.d.aNW()) {
            this.kmO.setIsRound(true);
            this.kmO.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.kbv.getContext(), R.dimen.tbds1));
            this.kmO.setBorderColor(com.baidu.tbadk.core.util.an.getColor(R.color.cp_border_a));
            this.kmO.setPlaceHolder(1);
            this.kmO.setDefaultResource(R.color.cp_bg_line_e);
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.kmO.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            }
        }
        this.iyQ = (TextView) this.bjv.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.kmN = (LinearLayout) this.bjv.findViewById(R.id.pb_editer_tool_comment_layout);
        this.kmN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.av.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                av.this.kbv.cJa();
                if (av.this.kbv != null && av.this.kbv.cIe() != null && av.this.kbv.cIe().getPbData() != null && av.this.kbv.cIe().getPbData().cGN() != null && av.this.kbv.cIe().getPbData().cGN().aSp() != null) {
                    if (com.baidu.tbadk.a.d.aNW()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13701").dk("tid", av.this.kbv.cIe().cKa()).dk("fid", av.this.kbv.cIe().getPbData().getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13402").dk("tid", av.this.kbv.cIe().kig).dk("fid", av.this.kbv.cIe().getPbData().getForumId()).ag("obj_locate", 1).dk("uid", av.this.kbv.cIe().getPbData().cGN().aSp().getUserId()));
                }
            }
        });
        this.kmP = (ImageView) this.bjv.findViewById(R.id.pb_editor_tool_comment_icon);
        this.kmP.setOnClickListener(this.hCn);
        boolean booleanExtra = this.kbv.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.kmQ = (ImageView) this.bjv.findViewById(R.id.pb_editor_tool_collection);
        this.kmQ.setOnClickListener(this.hCn);
        if (booleanExtra) {
            this.kmQ.setVisibility(8);
        } else {
            this.kmQ.setVisibility(0);
        }
        this.kmR = (ImageView) this.bjv.findViewById(R.id.pb_editor_tool_share);
        this.kmR.setOnClickListener(this.hCn);
        this.kmS = new com.baidu.tieba.pb.view.c(this.kmR);
        this.kmS.cQM();
        if (com.baidu.tbadk.a.d.aNW()) {
            this.kmT = (TextView) this.bjv.findViewById(R.id.pb_editor_tool_comment_red_dot);
            this.kmT.setVisibility(0);
        } else {
            this.kmU = (TextView) this.bjv.findViewById(R.id.pb_editor_tool_comment_number);
            this.kmU.setVisibility(0);
        }
        this.kna = (ViewStub) this.bjv.findViewById(R.id.interview_status_stub);
        this.kmg = new com.baidu.tieba.pb.pb.main.a.a(this.kbv, cVar);
        this.kmi = new com.baidu.tieba.pb.pb.main.a.d(this.kbv, cVar, this.hCn);
        this.kmo = new g(this.kbv, this.kmd);
        this.kmo.E(this.hCn);
        this.kmo.setTbGestureDetector(this.eor);
        this.kmo.setOnImageClickListener(this.eLw);
        this.kmo.setOnSwitchChangeListener(this.kbv.kgn);
        this.kcu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.av.27
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
                            av.this.kbv.c(sparseArray);
                            return;
                        }
                        av.this.cJ(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        av.this.kbv.c(sparseArray);
                    } else if (booleanValue3) {
                        av.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.kmo.R(this.kcu);
        cLX();
        cLY();
        this.kmi.b(this.kmd);
        this.kmh.b(this.kmd);
        this.kmg.b(this.kmd);
        this.hGJ = new PbListView(this.kbv.getPageContext().getPageActivity());
        this.eAd = this.hGJ.getView().findViewById(R.id.pb_more_view);
        if (this.eAd != null) {
            this.eAd.setOnClickListener(this.hCn);
            com.baidu.tbadk.core.util.an.setBackgroundResource(this.eAd, R.drawable.pb_foot_more_trans_selector);
        }
        this.hGJ.setLineVisible();
        this.hGJ.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.hGJ.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.kmu = this.bjv.findViewById(R.id.viewstub_progress);
        this.kbv.registerListener(this.knT);
        this.keK = new PbFakeFloorModel(this.kbv.getPageContext());
        this.knu = new t(this.kbv.getPageContext(), this.keK, this.bjv);
        this.knu.a(this.kbv.kgo);
        this.keK.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.av.28
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                av.this.keK.t(postData);
                av.this.kmo.notifyDataSetChanged();
                av.this.knu.cIK();
                av.this.ZX.bdC();
                av.this.so(false);
            }
        });
        if (this.kbv.cIe() != null && !StringUtils.isNull(this.kbv.cIe().cKI())) {
            this.kbv.showToast(this.kbv.cIe().cKI());
        }
        this.knd = this.bjv.findViewById(R.id.pb_expand_blank_view);
        this.kne = this.bjv.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kne.getLayoutParams();
        if (this.kbv.cIe() != null && this.kbv.cIe().cKd()) {
            this.knd.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.kne.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = kng;
            this.kne.setLayoutParams(layoutParams2);
        }
        this.knf = new aq(this.kbv.getPageContext(), this.bjv.findViewById(R.id.pb_reply_expand_view));
        this.knf.v(pbFragment.kfl);
        this.knf.klx.setVisibility(8);
        this.knf.S(this.hCn);
        this.knf.setOnSwitchChangeListener(this.kbv.kgn);
        this.kbv.registerListener(this.mAccountChangedListener);
        this.kbv.registerListener(this.knQ);
        cLT();
        si(false);
    }

    public void sf(boolean z) {
        this.kmJ.setVisibility(z ? 0 : 8);
    }

    public void ckJ() {
        if (!this.kbv.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10517").ag("obj_locate", 2).dk("fid", this.mForumId));
        } else if (this.kbv.cJc()) {
            com.baidu.tbadk.editortools.pb.e cIP = this.kbv.cIP();
            if (cIP != null && (cIP.bfP() || cIP.bfQ())) {
                this.kbv.cIP().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.ZX != null) {
                cMd();
            }
            if (this.ZX != null) {
                this.kmV = false;
                if (this.ZX.nB(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.kbv.getPageContext(), (View) this.ZX.nB(2).etH, false, knN);
                }
            }
            cML();
        }
    }

    private void cLT() {
        this.knH = new com.baidu.tieba.pb.pb.godreply.a(this.kbv, this, (ViewStub) this.bjv.findViewById(R.id.more_god_reply_popup));
        this.knH.z(this.hCn);
        this.knH.R(this.kcu);
        this.knH.setOnImageClickListener(this.eLw);
        this.knH.z(this.hCn);
        this.knH.setTbGestureDetector(this.eor);
    }

    public com.baidu.tieba.pb.pb.godreply.a cLU() {
        return this.knH;
    }

    public View cLV() {
        return this.knd;
    }

    public void cLW() {
        if (this.kmd != null) {
            this.kmh.c(this.kmd);
            this.kmi.c(this.kmd);
            this.kmj.c(this.kmd);
            this.kmg.c(this.kmd);
        }
    }

    private void cLX() {
        if (this.kmj == null) {
            this.kmj = new com.baidu.tieba.pb.pb.main.a.b(this.kbv, this.hCn);
        }
    }

    private void cLY() {
        if (this.kmh == null) {
            this.kmh = new com.baidu.tieba.pb.pb.main.a.c(this.kbv, this.eor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLZ() {
        if (this.kbv.cJs()) {
            this.kmc = (ViewStub) this.bjv.findViewById(R.id.manga_mention_controller_view_stub);
            this.kmc.setVisibility(0);
            if (this.kmk == null) {
                this.kmk = (LinearLayout) this.bjv.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.kbv.getPageContext(), this.kmk);
            }
            if (this.kml == null) {
                this.kml = (TextView) this.kmk.findViewById(R.id.manga_prev_btn);
            }
            if (this.kmm == null) {
                this.kmm = (TextView) this.kmk.findViewById(R.id.manga_next_btn);
            }
            this.kml.setOnClickListener(this.hCn);
            this.kmm.setOnClickListener(this.hCn);
        }
    }

    private void cMa() {
        if (this.kbv.cJs()) {
            if (this.kbv.cJv() == -1) {
                com.baidu.tbadk.core.util.an.setViewTextColor(this.kml, R.color.cp_cont_e, 1);
            }
            if (this.kbv.cJw() == -1) {
                com.baidu.tbadk.core.util.an.setViewTextColor(this.kmm, R.color.cp_cont_e, 1);
            }
        }
    }

    public void cMb() {
        if (this.kmk == null) {
            cLZ();
        }
        this.kmc.setVisibility(8);
        if (this.knR != null && this.knS != null) {
            this.knR.removeCallbacks(this.knS);
        }
    }

    public void cMc() {
        if (this.knR != null) {
            if (this.knS != null) {
                this.knR.removeCallbacks(this.knS);
            }
            this.knS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.av.3
                @Override // java.lang.Runnable
                public void run() {
                    if (av.this.kmk == null) {
                        av.this.cLZ();
                    }
                    av.this.kmc.setVisibility(0);
                }
            };
            this.knR.postDelayed(this.knS, 2000L);
        }
    }

    public void sg(boolean z) {
        this.klZ.sg(z);
        if (z && this.kmZ) {
            this.hGJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.kmd.setNextPage(this.hGJ);
            this.klY = 2;
        }
        if (com.baidu.tbadk.a.d.aNW() && this.kmO != null) {
            this.kmO.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.ZX = editorTools;
        this.ZX.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.ZX.getParent() == null) {
            this.bjv.addView(this.ZX, layoutParams);
        }
        this.ZX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.ZX.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.av.5
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).bai() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).bai() == EmotionGroupType.USER_COLLECT) {
                        if (av.this.mPermissionJudgePolicy == null) {
                            av.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        av.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        av.this.mPermissionJudgePolicy.appendRequestPermission(av.this.kbv.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!av.this.mPermissionJudgePolicy.startRequestPermission(av.this.kbv.getBaseFragmentActivity())) {
                            av.this.kbv.cIP().c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            av.this.kbv.cIP().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cLJ();
        this.kbv.cIP().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.av.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (av.this.ZX != null && av.this.ZX.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (av.this.knG == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, av.this.ZX.getId());
                            av.this.knG = new com.baidu.tieba.pb.pb.main.emotion.c(av.this.kbv.getPageContext(), av.this.bjv, layoutParams2);
                            if (!com.baidu.tbadk.core.util.w.isEmpty(av.this.knF)) {
                                av.this.knG.setData(av.this.knF);
                            }
                            av.this.knG.b(av.this.ZX);
                        }
                        av.this.knG.Kj(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (av.this.kbv.kfu != null && av.this.kbv.kfu.cNa() != null) {
                    if (!av.this.kbv.kfu.cNa().dqL()) {
                        av.this.kbv.kfu.st(false);
                    }
                    av.this.kbv.kfu.cNa().vF(false);
                }
            }
        });
    }

    public void cMd() {
        if (this.kbv != null && this.ZX != null) {
            this.ZX.display();
            if (this.kbv.cIP() != null) {
                this.kbv.cIP().bfF();
            }
            cML();
        }
    }

    public void sh(boolean z) {
        if (this.kmd != null && this.textView != null && this.biD != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.biD.setVisibility(0);
                } else {
                    this.biD.setVisibility(8);
                    this.kmd.removeHeaderView(this.textView);
                    this.kmd.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = kng;
                    this.textView.setLayoutParams(layoutParams);
                }
                cMr();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + sq(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            cMr();
            cMT();
        }
    }

    public g cMe() {
        return this.kmo;
    }

    public void a(PbFragment.c cVar) {
        this.kgt = cVar;
    }

    public void cJ(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kbv.getContext());
        kVar.setTitleText(this.kbv.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.av.7
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                av.this.kmv.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            av.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (av.this.knU != null) {
                                av.this.knU.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            av.this.kbv.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        int i = -1;
        if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
            i = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
        }
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && i != 2) {
            int i2 = -1;
            if (sparseArray.get(R.id.tag_del_post_type) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
            }
            if (i2 == 0) {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.kbv.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.kbv.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !cMS()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.kbv.getString(R.string.forbidden_person), kVar);
            gVar3.mTextView.setTag(sparseArray3);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.kbv.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.kbv.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aL(arrayList);
        if (this.kmv == null) {
            this.kmv = new com.baidu.tbadk.core.dialog.i(this.kbv.getPageContext(), kVar);
        } else {
            this.kmv.a(kVar);
        }
        this.kmv.showDialog();
    }

    public void a(PbFragment.b bVar) {
        this.knU = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.kbv != null && aVar != null) {
            if (this.ieU == null && this.kmg != null) {
                this.ieU = new com.baidu.tieba.NEGFeedBack.e(this.kbv.getPageContext(), this.kmg.cNk());
            }
            AntiData bXd = this.kbv.bXd();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bXd != null && bXd.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bXd.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ap apVar = new com.baidu.tbadk.core.data.ap();
            apVar.setFeedBackReasonMap(sparseArray);
            this.ieU.setDefaultReasonArray(new String[]{this.kbv.getString(R.string.delete_thread_reason_1), this.kbv.getString(R.string.delete_thread_reason_2), this.kbv.getString(R.string.delete_thread_reason_3), this.kbv.getString(R.string.delete_thread_reason_4), this.kbv.getString(R.string.delete_thread_reason_5)});
            this.ieU.setData(apVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.ieU.zC(str);
            this.ieU.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.av.8
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void T(JSONArray jSONArray) {
                    av.this.kbv.a(aVar, jSONArray);
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
        sparseArray.put(knn, Integer.valueOf(kno));
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
        this.kmw = new com.baidu.tbadk.core.dialog.a(this.kbv.getActivity());
        if (StringUtils.isNull(str2)) {
            this.kmw.kT(i3);
        } else {
            this.kmw.setOnlyMessageShowCenter(false);
            this.kmw.we(str2);
        }
        this.kmw.setYesButtonTag(sparseArray);
        this.kmw.a(R.string.dialog_ok, this.kbv);
        this.kmw.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.av.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kmw.hf(true);
        this.kmw.b(this.kbv.getPageContext());
        if (z) {
            this.kmw.aUN();
        } else {
            a(this.kmw, i);
        }
    }

    public void aQ(ArrayList<com.baidu.tbadk.core.data.ah> arrayList) {
        if (this.kmz == null) {
            this.kmz = LayoutInflater.from(this.kbv.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.kbv.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kmz);
        if (this.kmy == null) {
            this.kmy = new Dialog(this.kbv.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.kmy.setCanceledOnTouchOutside(true);
            this.kmy.setCancelable(true);
            this.kmH = (ScrollView) this.kmz.findViewById(R.id.good_scroll);
            this.kmy.setContentView(this.kmz);
            WindowManager.LayoutParams attributes = this.kmy.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.kmy.getWindow().setAttributes(attributes);
            this.gTD = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.av.10
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        av.this.kmD = (String) compoundButton.getTag();
                        if (av.this.gTC != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : av.this.gTC) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && av.this.kmD != null && !str.equals(av.this.kmD)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.kmA = (LinearLayout) this.kmz.findViewById(R.id.good_class_group);
            this.kmC = (TextView) this.kmz.findViewById(R.id.dialog_button_cancel);
            this.kmC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.av.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (av.this.kmy instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(av.this.kmy, av.this.kbv.getPageContext());
                    }
                }
            });
            this.kmB = (TextView) this.kmz.findViewById(R.id.dialog_button_ok);
            this.kmB.setOnClickListener(this.hCn);
        }
        this.kmA.removeAllViews();
        this.gTC = new ArrayList();
        CustomBlueCheckRadioButton fa = fa("0", this.kbv.getPageContext().getString(R.string.thread_good_class));
        this.gTC.add(fa);
        fa.setChecked(true);
        this.kmA.addView(fa);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ah ahVar = arrayList.get(i2);
                if (ahVar != null && !TextUtils.isEmpty(ahVar.aQD()) && ahVar.aQE() > 0) {
                    CustomBlueCheckRadioButton fa2 = fa(String.valueOf(ahVar.aQE()), ahVar.aQD());
                    this.gTC.add(fa2);
                    View view = new View(this.kbv.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.an.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.kmA.addView(view);
                    this.kmA.addView(fa2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.kmH.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kbv.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kbv.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kbv.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.kmH.setLayoutParams(layoutParams2);
            this.kmH.removeAllViews();
            if (this.kmA != null && this.kmA.getParent() == null) {
                this.kmH.addView(this.kmA);
            }
        }
        com.baidu.adp.lib.f.g.a(this.kmy, this.kbv.getPageContext());
    }

    private CustomBlueCheckRadioButton fa(String str, String str2) {
        Activity pageActivity = this.kbv.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.gTD);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void cMf() {
        this.kbv.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.kbv.hideProgressBar();
        if (z && z2) {
            this.kbv.showToast(this.kbv.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.ar.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.kbv.showToast(str);
        }
    }

    public void crG() {
        this.kmu.setVisibility(0);
    }

    public void crF() {
        this.kmu.setVisibility(8);
    }

    public View cMg() {
        if (this.kmz != null) {
            return this.kmz.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String cMh() {
        return this.kmD;
    }

    public View getView() {
        return this.bjv;
    }

    public void cMi() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.kbv.getPageContext().getPageActivity(), this.kbv.getBaseFragmentActivity().getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.kbv.hideProgressBar();
        if (z) {
            cMB();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            cMC();
        } else {
            cMB();
        }
    }

    public void cMj() {
        this.hGJ.setLineVisible();
        this.hGJ.startLoadData();
    }

    public void cMk() {
        this.kbv.hideProgressBar();
        endLoadData();
        this.kmd.completePullRefreshPostDelayed(0L);
        cMw();
    }

    public void cMl() {
        this.kmd.completePullRefreshPostDelayed(0L);
        cMw();
    }

    private void si(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.kmi.b(onLongClickListener);
        this.kmo.setOnLongClickListener(onLongClickListener);
        if (this.knH != null) {
            this.knH.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.kfv != null) {
            this.kfv.dismiss();
            this.kfv = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kbv.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.kbv.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kbv.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kbv.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kbv.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.aL(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.av.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                av.this.kmE.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.kmE = new com.baidu.tbadk.core.dialog.i(this.kbv.getPageContext(), kVar);
        this.kmE.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.kmE != null) {
            this.kmE.dismiss();
            this.kmE = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kbv.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.kcE != null && this.kcE.cGN() != null && !this.kcE.cGN().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.kbv.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kbv.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aL(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.av.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                av.this.kmE.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.kmE = new com.baidu.tbadk.core.dialog.i(this.kbv.getPageContext(), kVar);
        this.kmE.showDialog();
    }

    public int cMm() {
        return BB(this.kmd.getFirstVisiblePosition());
    }

    private int BB(int i) {
        com.baidu.adp.widget.ListView.f adapter = this.kmd.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.kmd.getAdapter() == null || !(this.kmd.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) ? 0 : this.kmd.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int cMn() {
        int lastVisiblePosition = this.kmd.getLastVisiblePosition();
        if (this.kmf != null) {
            if (lastVisiblePosition == this.kmd.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return BB(lastVisiblePosition);
    }

    public void BC(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.kmd != null) {
            if (this.klZ == null || this.klZ.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.klZ.mNavigationBar.getFixedNavHeight();
                if (this.kbv.cJi() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.kne != null && (layoutParams = (LinearLayout.LayoutParams) this.kne.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.kne.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.kmd.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.kmd.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.kmd.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.kmr.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.e eVar) {
        int i;
        this.kmo.a(eVar, false);
        this.kmo.notifyDataSetChanged();
        cMw();
        if (this.knH != null) {
            this.knH.cIa();
        }
        ArrayList<PostData> cGP = eVar.cGP();
        if (eVar.getPage().aRf() == 0 || cGP == null || cGP.size() < eVar.getPage().aRe()) {
            if (com.baidu.tbadk.core.util.w.getCount(cGP) == 0 || (com.baidu.tbadk.core.util.w.getCount(cGP) == 1 && cGP.get(0) != null && cGP.get(0).dhY() == 1)) {
                if (this.knj == null || this.knj.kon == null || this.knj.kon.getView() == null) {
                    i = 0;
                } else {
                    i = this.knj.kon.getView().getTop() < 0 ? this.knj.kon.getView().getHeight() : this.knj.kon.getView().getBottom();
                }
                if (this.kbv.cJC()) {
                    this.hGJ.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.hGJ.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (eVar.getPage().aRf() == 0) {
                    this.hGJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.hGJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.hGJ.aYa();
            }
        }
        u(eVar);
    }

    public void t(com.baidu.tieba.pb.data.e eVar) {
        if (this.kmg != null) {
            this.kmg.e(eVar, this.kcm);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.e eVar, boolean z) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.cHa() != null) {
            return eVar.cHa();
        }
        if (!com.baidu.tbadk.core.util.w.isEmpty(eVar.cGP())) {
            Iterator<PostData> it = eVar.cGP().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dhY() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.cGW();
        }
        if (!r(postData)) {
            postData = a(eVar);
        }
        if (postData != null && postData.aSp() != null && postData.aSp().getUserTbVipInfoData() != null && postData.aSp().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aSp().getGodUserData().setIntro(postData.aSp().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean r(PostData postData) {
        if (postData == null || postData.aSp() == null) {
            return false;
        }
        MetaData aSp = postData.aSp();
        return (TextUtils.isEmpty(aSp.getUserId()) && TextUtils.isEmpty(aSp.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cGN() == null || eVar.cGN().aSp() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aSp = eVar.cGN().aSp();
        String userId = aSp.getUserId();
        HashMap<String, MetaData> userMap = eVar.cGN().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aSp;
        }
        postData.EW(1);
        postData.setId(eVar.cGN().aSG());
        postData.setTitle(eVar.cGN().getTitle());
        postData.setTime(eVar.cGN().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.e eVar, boolean z, int i, int i2) {
        if (eVar != null && eVar.cGN() != null) {
            if (this.kbv.cHU()) {
                if (eVar.cGM() != null) {
                    this.mForumName = eVar.cGM().getForumName();
                    this.mForumId = eVar.cGM().getForumId();
                }
                if (this.mForumName == null && this.kbv.cIe() != null && this.kbv.cIe().cHV() != null) {
                    this.mForumName = this.kbv.cIe().cHV();
                }
            }
            PostData b = b(eVar, z);
            a(b, eVar);
            this.kmi.setVisibility(8);
            if (eVar.cHm()) {
                this.kny = true;
                this.klZ.rp(true);
                this.klZ.mNavigationBar.hideBottomLine();
                if (this.kmf == null) {
                    this.kmf = new com.baidu.tieba.pb.pb.main.a.e(this.kbv);
                }
                this.kmf.a(eVar, b, this.kmd, this.kmi, this.knc, this.klZ, this.mForumName, this.knM);
                this.kmf.T(this.knW);
                cMr();
            } else {
                this.kny = false;
                this.klZ.rp(this.kny);
                if (this.kmf != null) {
                    this.kmf.c(this.kmd);
                }
            }
            if (this.kbv.cIS() != null) {
                this.kbv.cIS().sy(this.kny);
            }
            if (b != null) {
                this.kmY = b;
                this.kmi.setVisibility(0);
                SparseArray<Object> cNn = this.kmi.cNn();
                cNn.put(R.id.tag_clip_board, b);
                cNn.put(R.id.tag_is_subpb, false);
                this.kmj.a(eVar, this.kmd);
                this.kmh.A(eVar);
                this.kmg.e(eVar, this.kcm);
                this.kmg.z(eVar);
                this.kmi.a(this.mSkinType, this.kcE, b, this.knW);
                if (this.knf != null) {
                    if (eVar.cHp()) {
                        this.knf.getView().setVisibility(8);
                    } else {
                        this.knf.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l(com.baidu.tieba.pb.data.l.jZY);
                        if (eVar.cGN() != null) {
                            lVar.kaa = eVar.cGN().aSg();
                        }
                        lVar.isNew = !this.kcm;
                        lVar.sortType = eVar.jYM;
                        lVar.kac = eVar.cHq();
                        lVar.kad = this.kbv.cJC();
                        lVar.kae = eVar.jYL;
                        this.knf.a(lVar);
                    }
                }
                if (eVar != null && eVar.cGN() != null) {
                    ak(eVar.cGN().aSl() == 1, eVar.cGN().aSk() == 1);
                }
                com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.av.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (av.this.kmo != null && av.this.klZ != null && av.this.klZ.ksx != null && av.this.kcE != null && av.this.kcE.cGN() != null && !av.this.kcE.cGN().aQV() && !av.this.cMv() && av.this.kcE.getForum() != null && !com.baidu.tbadk.core.util.ar.isEmpty(av.this.kcE.getForum().getName())) {
                            if ((av.this.kmo.cIG() == null || !av.this.kmo.cIG().isShown()) && av.this.klZ.ksx != null) {
                                av.this.klZ.ksx.setVisibility(0);
                                if (av.this.kbv != null && av.this.kbv.cIe() != null) {
                                    com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c13400");
                                    aoVar.dk("tid", av.this.kbv.cIe().cJZ());
                                    aoVar.dk("fid", av.this.kbv.cIe().getForumId());
                                    aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(aoVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void sj(boolean z) {
        if (z) {
            cMo();
        } else {
            bSk();
        }
        this.knj.kon = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.knj));
        a(this.knj.kon, false);
    }

    public void cMo() {
        if (this.klZ != null && !this.knA) {
            this.klZ.cMo();
            this.knA = true;
        }
    }

    public void bSk() {
        if (this.klZ != null) {
            this.klZ.cNL();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        this.kmi.a(postData, eVar);
    }

    public void cMp() {
        if (this.kmf != null) {
            this.kmf.d(this.kmd);
        }
    }

    public boolean cMq() {
        return this.aRq;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aL(bu buVar) {
        if (buVar == null || buVar.aSp() == null) {
            return false;
        }
        PostData b = b(this.kcE, false);
        String str = "";
        if (b != null && b.aSp() != null) {
            str = b.aSp().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.klZ.cNJ();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.klZ.HR(dVar.forumName);
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
            final String str2 = dVar.jYE;
            this.kbv.showNetRefreshView(this.bjv, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.av.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        bc.aWU().b(av.this.kbv.getPageContext(), new String[]{str2});
                        av.this.kbv.finish();
                        return;
                    }
                    av.this.kbv.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable cLu;
        Parcelable cLu2;
        if (eVar != null && this.kmd != null) {
            this.kcE = eVar;
            this.mType = i;
            if (eVar.cGN() != null) {
                this.knl = eVar.cGN().aRW();
                if (eVar.cGN().getAnchorLevel() != 0) {
                    this.aRq = true;
                }
                this.kmG = aL(eVar.cGN());
            }
            if (eVar.getUserData() != null) {
                this.userId = eVar.getUserData().getUserId();
            }
            y(eVar);
            this.kmZ = false;
            this.kcm = z;
            cMk();
            if (eVar.jYN != null && eVar.jYN.cHv()) {
                if (this.kme == null) {
                    this.kme = new PbThreadPostView(this.kbv.getContext());
                    this.kmd.addHeaderView(this.kme, 1);
                    this.kme.setData(eVar);
                    this.kme.setChildOnClickLinstener(this.hCn);
                }
            } else if (this.kme != null && this.kmd != null) {
                this.kmd.removeHeaderView(this.kme);
            }
            a(eVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(eVar);
            if (this.knK == null) {
                this.knK = new ah(this.kbv.getPageContext(), this.ibz);
            }
            this.knK.JZ(eVar.cGU());
            if (this.kbv.cJs()) {
                if (this.kms == null) {
                    this.kms = new com.baidu.tieba.pb.view.d(this.kbv.getPageContext());
                    this.kms.createView();
                    this.kms.setListPullRefreshListener(this.ecS);
                }
                this.kmd.setPullRefresh(this.kms);
                cMr();
                if (this.kms != null) {
                    this.kms.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (eVar.getPage().aRg() == 0 && z) {
                this.kmd.setPullRefresh(null);
            } else {
                if (this.kms == null) {
                    this.kms = new com.baidu.tieba.pb.view.d(this.kbv.getPageContext());
                    this.kms.createView();
                    this.kms.setListPullRefreshListener(this.ecS);
                }
                this.kmd.setPullRefresh(this.kms);
                cMr();
                if (this.kms != null) {
                    this.kms.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                bJm();
            }
            cMw();
            this.kmo.rs(this.kcm);
            this.kmo.rt(false);
            this.kmo.rx(i == 5);
            this.kmo.ry(i == 6);
            this.kmo.rz(z2 && this.knV && i != 2);
            this.kmo.a(eVar, false);
            this.kmo.notifyDataSetChanged();
            this.kmi.a(b(eVar, z), eVar.cHp());
            if (eVar.cGN() != null && eVar.cGN().aSa() != null && this.klX != -1) {
                eVar.cGN().aSa().setIsLike(this.klX);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.kmd.setNextPage(this.hGJ);
                this.klY = 2;
                bJm();
            } else {
                this.kmZ = true;
                if (eVar.getPage().aRf() == 1) {
                    if (this.kmt == null) {
                        this.kmt = new com.baidu.tieba.pb.view.a(this.kbv, this.kbv);
                    }
                    this.kmd.setNextPage(this.kmt);
                } else {
                    this.kmd.setNextPage(this.hGJ);
                }
                this.klY = 3;
            }
            ArrayList<PostData> cGP = eVar.cGP();
            if (eVar.getPage().aRf() == 0 || cGP == null || cGP.size() < eVar.getPage().aRe()) {
                if (com.baidu.tbadk.core.util.w.getCount(cGP) == 0 || (com.baidu.tbadk.core.util.w.getCount(cGP) == 1 && cGP.get(0) != null && cGP.get(0).dhY() == 1)) {
                    if (this.knj == null || this.knj.kon == null || this.knj.kon.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.knj.kon.getView().getTop() < 0 ? this.knj.kon.getView().getHeight() : this.knj.kon.getView().getBottom();
                    }
                    if (this.kbv.cJC()) {
                        this.hGJ.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.hGJ.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.kbv.cIS() != null && !this.kbv.cIS().cNx()) {
                        this.kbv.cIS().showFloatingView();
                    }
                } else {
                    if (eVar.getPage().aRf() == 0) {
                        this.hGJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.hGJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.hGJ.aYa();
                }
                if (eVar.getPage().aRf() == 0 || cGP == null) {
                    cMG();
                }
            } else {
                if (z2) {
                    if (this.knV) {
                        endLoadData();
                        if (eVar.getPage().aRf() != 0) {
                            this.hGJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.hGJ.setLineVisible();
                        this.hGJ.showLoading();
                    }
                } else {
                    this.hGJ.setLineVisible();
                    this.hGJ.showLoading();
                }
                this.hGJ.aYa();
            }
            switch (i) {
                case 2:
                    this.kmd.setSelection(i2 > 1 ? (((this.kmd.getData() == null && eVar.cGP() == null) ? 0 : (this.kmd.getData().size() - eVar.cGP().size()) + this.kmd.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (cLu2 = ao.cLt().cLu()) != null && !(cLu2 instanceof RecyclerView.SavedState)) {
                        this.kmd.onRestoreInstanceState(cLu2);
                        if (com.baidu.tbadk.core.util.w.getCount(cGP) > 1 && eVar.getPage().aRf() > 0) {
                            this.hGJ.endLoadData();
                            this.hGJ.setText(this.kbv.getString(R.string.pb_load_more_without_point));
                            this.hGJ.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.knV = false;
                    break;
                case 5:
                    this.kmd.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (cLu = ao.cLt().cLu()) != null && !(cLu instanceof RecyclerView.SavedState)) {
                        this.kmd.onRestoreInstanceState(cLu);
                        break;
                    } else {
                        this.kmd.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.kmf != null && this.kmf.bua() != null) {
                            if (this.kbv.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.kmd.setSelectionFromTop((this.kmo.cIB() + this.kmd.getHeaderViewsCount()) - 1, this.kmf.cNp() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.kbv.getPageContext().getPageActivity()));
                            } else {
                                this.kmd.setSelectionFromTop((this.kmo.cIB() + this.kmd.getHeaderViewsCount()) - 1, this.kmf.cNp());
                            }
                        } else {
                            this.kmd.setSelection(this.kmo.cIB() + this.kmd.getHeaderViewsCount());
                        }
                    } else {
                        this.kmd.setSelection(i2 > 0 ? ((this.kmd.getData() == null && eVar.cGP() == null) ? 0 : (this.kmd.getData().size() - eVar.cGP().size()) + this.kmd.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.hGJ.endLoadData();
                    this.hGJ.setText(this.kbv.getString(R.string.pb_load_more_without_point));
                    this.hGJ.setLineGone();
                    break;
            }
            if (this.knl == knm && isHost()) {
                cMO();
            }
            if (this.knw) {
                cLH();
                this.knw = false;
                if (i3 == 0) {
                    sc(true);
                }
            }
            if (eVar.jYJ == 1 || eVar.jYK == 1) {
                if (this.knC == null) {
                    this.knC = new PbTopTipView(this.kbv.getContext());
                }
                if (eVar.jYK == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.kbv.getStType())) {
                    this.knC.setText(this.kbv.getString(R.string.pb_read_strategy_add_experience));
                    this.knC.a(this.bjv, this.mSkinType);
                } else if (eVar.jYJ == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.kbv.getStType())) {
                    this.knC.setText(this.kbv.getString(R.string.pb_read_news_add_experience));
                    this.knC.a(this.bjv, this.mSkinType);
                }
            }
            u(eVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cGN() != null) {
            x(eVar);
            if (eVar.aOo()) {
                SvgManager.aWQ().a(this.kmQ, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aWQ().a(this.kmQ, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String BD = BD(eVar.cGN().aSg());
            if (this.kmT != null) {
                this.kmT.setText(BD);
            }
            if (this.kmU != null) {
                this.kmU.setText(BD);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.cGN()));
        }
    }

    private String BD(int i) {
        if (i == 0) {
            return this.kbv.getString(R.string.pb_comment_red_dot_no_reply);
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (i > 9990000) {
            return "· · ·";
        }
        if (i >= 1000000) {
            numberFormat.setMaximumFractionDigits(0);
            return numberFormat.format(i / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else if (i >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else {
            return "" + i;
        }
    }

    private void cMr() {
        if (this.kmf != null) {
            this.kmf.a(this.kmd, this.textView, this.mType);
        }
    }

    public void sk(boolean z) {
        this.kmF = z;
    }

    public void endLoadData() {
        if (this.hGJ != null) {
            this.hGJ.setLineGone();
            this.hGJ.endLoadData();
        }
        bJm();
    }

    public void byJ() {
        this.kmd.setVisibility(0);
    }

    public void cMs() {
        if (this.kmd != null) {
            this.kmd.setVisibility(8);
        }
        if (this.kmd != null) {
            this.knc.setVisibility(8);
        }
        if (this.klZ != null && this.klZ.ksu != null) {
            this.klZ.ksu.setVisibility(8);
        }
    }

    public void cMt() {
        if (this.kmd != null) {
            this.kmd.setVisibility(0);
        }
        if (this.knc != null) {
            this.knc.setVisibility(0);
        }
        if (this.klZ != null && this.klZ.ksu != null) {
            this.klZ.ksu.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && this.kmY != null && this.kmY.aSp() != null && this.klZ != null) {
            this.knz = !this.kny;
            this.klZ.sA(this.knz);
            if (this.kbv.cIS() != null) {
                this.kbv.cIS().sz(this.knz);
            }
            cMu();
            if (this.kbv != null && !this.kbv.cHU() && !com.baidu.tbadk.core.util.w.isEmpty(eVar.cHj())) {
                bq bqVar = eVar.cHj().get(0);
                if (bqVar != null) {
                    this.klZ.fb(bqVar.getForumName(), bqVar.getAvatar());
                }
            } else if (eVar.getForum() != null) {
                this.klZ.fb(eVar.getForum().getName(), eVar.getForum().getImage_url());
            }
            this.klZ.b(eVar, this.kmY, this.kmG);
            if (this.knz) {
                this.kmi.a(eVar, this.kmY, this.kmG);
                if (this.kne != null) {
                    this.kne.setVisibility(8);
                }
                if (this.knI == null) {
                    this.knI = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.av.18
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (av.this.kbv != null && av.this.kbv.isAdded()) {
                                if (i < 0 && f > av.this.knB) {
                                    av.this.cMN();
                                }
                                av.this.cMl();
                            }
                        }
                    };
                }
                this.kmd.setListViewDragListener(this.knI);
                return;
            }
            if (this.kne != null) {
                this.kne.setVisibility(0);
            }
            this.kmi.a(eVar, this.kmY, this.kmG);
            this.knI = null;
            this.kmd.setListViewDragListener(null);
        }
    }

    private void cMu() {
        this.kmi.a(this.kcE, this.kmY, this.knz, this.kny);
    }

    public boolean cMv() {
        return this.kcE == null || this.kcE.getForum() == null || "0".equals(this.kcE.getForum().getId()) || "me0407".equals(this.kcE.getForum().getName());
    }

    private boolean cMw() {
        return this.kmg.sv(this.kcm);
    }

    private boolean w(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cGN() == null) {
            return false;
        }
        if (eVar.cGN().aSm() == 1 || eVar.cGN().getThreadType() == 33) {
            return true;
        }
        return !(eVar.cGN().aSo() == null || eVar.cGN().aSo().aUE() == 0) || eVar.cGN().aSk() == 1 || eVar.cGN().aSl() == 1 || eVar.cGN().aTd() || eVar.cGN().aTx() || eVar.cGN().aTq() || eVar.cGN().aSA() != null || !com.baidu.tbadk.core.util.ar.isEmpty(eVar.cGN().getCategory()) || eVar.cGN().aSs() || eVar.cGN().aSr();
    }

    public boolean c(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            if (this.kmh != null) {
                if (eVar.cGN() != null && eVar.cGN().aSD() == 0 && !eVar.cGN().aQV() && !this.knO) {
                    if (eVar.cGN() != null) {
                        bu cGN = eVar.cGN();
                        cGN.v(true, w(eVar));
                        cGN.kF(3);
                        cGN.vR("2");
                    }
                    if (eVar.cGN().aQX()) {
                        this.kmi.c(this.kmd);
                        this.kmh.c(this.kmd);
                        this.kmh.b(this.kmd);
                        this.kmi.b(this.kmd);
                        this.kmi.E(this.kcE);
                        this.kmh.B(eVar);
                    } else {
                        this.kmi.E(this.kcE);
                        this.kmh.D(eVar);
                    }
                } else if (eVar.cGN().aSD() == 1) {
                    if (eVar.cGN() != null) {
                        this.kmh.c(this.kmd);
                        this.kmi.E(this.kcE);
                    }
                } else {
                    this.kmh.c(this.kmd);
                    this.kmi.E(this.kcE);
                }
            }
            if (eVar.cGN() != null) {
                aj(eVar.cGN().aSl() == 1, eVar.cGN().aSk() == 1);
            }
            this.kcm = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            c(eVar, z);
            cMw();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.z zVar;
        StringBuilder sb = null;
        if (eVar != null && (b = b(eVar, z)) != null) {
            String userId = b.aSp().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cHc()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.aSp() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.aSp().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.aSp().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.aSp().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cHc()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bq> cHj = eVar.cHj();
                if (com.baidu.tbadk.core.util.w.getCount(cHj) > 0) {
                    sb = new StringBuilder();
                    for (bq bqVar : cHj) {
                        if (bqVar != null && !StringUtils.isNull(bqVar.getForumName()) && (zVar = bqVar.dKO) != null && zVar.dIC && !zVar.dID && (zVar.type == 1 || zVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bqVar.getForumName(), 12)).append(this.kbv.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.kbv.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View cMx() {
        return this.eAd;
    }

    public boolean cMy() {
        if (this.bkf == null || this.bkf.getParent() == null || this.hGJ.isLoading()) {
            return false;
        }
        int bottom = this.bkf.getBottom();
        Rect rect = new Rect();
        this.bkf.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Kb(String str) {
        if (this.hGJ != null) {
            this.hGJ.setText(str);
        }
    }

    public void Kc(String str) {
        if (this.hGJ != null) {
            int i = 0;
            if (this.knj != null && this.knj.kon != null && this.knj.kon.getView() != null) {
                i = this.knj.kon.getView().getTop() < 0 ? this.knj.kon.getView().getHeight() : this.knj.kon.getView().getBottom();
            }
            this.hGJ.ak(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.kmd;
    }

    public int cMz() {
        return R.id.richText;
    }

    public TextView cIo() {
        return this.kmi.cIo();
    }

    public void d(BdListView.e eVar) {
        this.kmd.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.ecS = cVar;
        if (this.kms != null) {
            this.kms.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.at atVar, a.b bVar) {
        if (atVar != null) {
            int aRd = atVar.aRd();
            int aRa = atVar.aRa();
            if (this.kmp != null) {
                this.kmp.aUN();
            } else {
                this.kmp = new com.baidu.tbadk.core.dialog.a(this.kbv.getPageContext().getPageActivity());
                this.kmq = LayoutInflater.from(this.kbv.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.kmp.aP(this.kmq);
                this.kmp.a(R.string.dialog_ok, bVar);
                this.kmp.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.av.19
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        av.this.cMB();
                        aVar.dismiss();
                    }
                });
                this.kmp.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.av.20
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (av.this.knt == null) {
                            av.this.knt = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.av.20.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    av.this.kbv.HidenSoftKeyPad((InputMethodManager) av.this.kbv.getBaseFragmentActivity().getSystemService("input_method"), av.this.bjv);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.lt().postDelayed(av.this.knt, 150L);
                    }
                });
                this.kmp.b(this.kbv.getPageContext()).aUN();
            }
            this.kmr = (EditText) this.kmq.findViewById(R.id.input_page_number);
            this.kmr.setText("");
            TextView textView = (TextView) this.kmq.findViewById(R.id.current_page_number);
            if (aRd <= 0) {
                aRd = 1;
            }
            if (aRa <= 0) {
                aRa = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(aRd), Integer.valueOf(aRa)));
            this.kbv.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.kmr, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.kmd.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.kbv.showToast(str);
    }

    public boolean sl(boolean z) {
        if (this.ZX == null || !this.ZX.bfc()) {
            return false;
        }
        this.ZX.bdC();
        return true;
    }

    public void cMA() {
        if (this.knX != null) {
            while (this.knX.size() > 0) {
                TbImageView remove = this.knX.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        cMA();
        this.kmo.Be(1);
        if (this.kmf != null) {
            this.kmf.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.kmo.Be(2);
        if (this.kmf != null) {
            this.kmf.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.kbv.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.kbv.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.kmS != null) {
            this.kmS.onDestroy();
        }
        if (this.knv != null) {
            this.knv.destroy();
        }
        if (this.knK != null) {
            this.knK.onDestory();
        }
        if (this.knC != null) {
            this.knC.hide();
        }
        this.kbv.hideProgressBar();
        if (this.flI != null && this.hwW != null) {
            this.flI.b(this.hwW);
        }
        cMB();
        endLoadData();
        if (this.knt != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.knt);
        }
        if (this.knb != null) {
            this.knb.clearStatus();
        }
        this.knR = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.kmo.Be(3);
        if (this.biD != null) {
            this.biD.setBackgroundDrawable(null);
        }
        if (this.kmf != null) {
            this.kmf.destroy();
        }
        if (this.kmo != null) {
            this.kmo.onDestroy();
        }
        this.kmd.setOnLayoutListener(null);
        if (this.knG != null) {
            this.knG.caR();
        }
        if (this.knk != null) {
            this.knk.onDestroy();
        }
        if (this.kmi != null) {
            this.kmi.onDestroy();
        }
    }

    public boolean BE(int i) {
        if (this.kmf != null) {
            return this.kmf.BE(i);
        }
        return false;
    }

    public void cMB() {
        this.klZ.aFg();
        if (this.kmi != null) {
            this.kmi.cMB();
        }
        if (this.kbv != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.kbv.getContext(), this.kmr);
        }
        cLJ();
        if (this.kfv != null) {
            this.kfv.dismiss();
        }
        cMD();
        if (this.kmp != null) {
            this.kmp.dismiss();
        }
        if (this.hCm != null) {
            this.hCm.dismiss();
        }
    }

    public void cMC() {
        this.klZ.aFg();
        if (this.kmi != null) {
            this.kmi.cMB();
        }
        if (this.kfv != null) {
            this.kfv.dismiss();
        }
        cMD();
        if (this.kmp != null) {
            this.kmp.dismiss();
        }
        if (this.hCm != null) {
            this.hCm.dismiss();
        }
    }

    public void eo(List<String> list) {
        this.knF = list;
        if (this.knG != null) {
            this.knG.setData(list);
        }
    }

    public void rr(boolean z) {
        this.kmo.rr(z);
    }

    public void sm(boolean z) {
        this.kmI = z;
    }

    public void cMD() {
        if (this.kmw != null) {
            this.kmw.dismiss();
        }
        if (this.kmx != null) {
            com.baidu.adp.lib.f.g.b(this.kmx, this.kbv.getPageContext());
        }
        if (this.kmy != null) {
            com.baidu.adp.lib.f.g.b(this.kmy, this.kbv.getPageContext());
        }
        if (this.kmv != null) {
            this.kmv.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.kcE, this.kcm);
            b(this.kcE, this.kcm, this.mType, i);
            this.kbv.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.kbv.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bjv);
            com.baidu.tbadk.core.util.an.setBackgroundColor(this.bjv, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.an.setBackgroundResource(this.kmJ, R.drawable.personalize_tab_shadow);
            if (this.kmf != null) {
                this.kmf.onChangeSkinType(i);
            }
            if (this.kmj != null) {
                this.kmj.onChangeSkinType(i);
            }
            if (this.kmg != null) {
                this.kmg.onChangeSkinType(i);
            }
            if (this.kmh != null) {
                this.kmh.onChangeSkinType(i);
            }
            if (this.kmi != null) {
                this.kmi.onChangeSkinType(i);
            }
            if (this.hGJ != null) {
                this.hGJ.changeSkin(i);
                if (this.eAd != null) {
                    this.kbv.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.eAd);
                    com.baidu.tbadk.core.util.an.setBackgroundResource(this.eAd, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.kmp != null) {
                this.kmp.c(this.kbv.getPageContext());
            }
            sk(this.kmF);
            this.kmo.notifyDataSetChanged();
            if (this.kms != null) {
                this.kms.changeSkin(i);
            }
            if (this.ZX != null) {
                this.ZX.onChangeSkinType(i);
            }
            if (this.kmt != null) {
                this.kmt.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.w.isEmpty(this.gTC)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.gTC) {
                    customBlueCheckRadioButton.aXN();
                }
            }
            cMa();
            UtilHelper.setStatusBarBackground(this.biD, i);
            UtilHelper.setStatusBarBackground(this.kne, i);
            if (this.kmk != null) {
                com.baidu.tbadk.r.a.a(this.kbv.getPageContext(), this.kmk);
            }
            if (this.knu != null) {
                this.knu.onChangeSkinType(i);
            }
            if (this.klZ != null) {
                if (this.kmf != null) {
                    this.kmf.BF(i);
                } else {
                    this.klZ.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.iyQ != null) {
                com.baidu.tbadk.core.util.an.setViewTextColor(this.iyQ, (int) R.color.cp_cont_d);
            }
            if (this.kmO != null) {
                this.kmO.setBorderColor(com.baidu.tbadk.core.util.an.getColor(R.color.cp_border_a));
            }
            if (this.kmN != null) {
                this.kmN.setBackgroundDrawable(com.baidu.tbadk.core.util.an.aG(com.baidu.adp.lib.util.l.getDimens(this.kbv.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.an.getColor(R.color.cp_bg_line_j)));
            }
            if (this.kmQ != null && this.kcE != null) {
                if (this.kcE.aOo()) {
                    SvgManager.aWQ().a(this.kmQ, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.aWQ().a(this.kmQ, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            x(this.kcE);
            if (this.kmP != null) {
                SvgManager.aWQ().a(this.kmP, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.kmL != null) {
                com.baidu.tbadk.core.util.an.setBackgroundResource(this.kmL, R.drawable.bottom_shadow);
            }
            if (this.kmT != null) {
                com.baidu.tbadk.core.util.an.c(this.kmT, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_cont_h, R.color.cp_cont_h);
                com.baidu.tbadk.core.util.an.setViewTextColor(this.kmT, (int) R.color.cp_cont_a);
            }
            if (this.kmU != null) {
                com.baidu.tbadk.core.util.an.setViewTextColor(this.kmU, (int) R.color.cp_cont_b);
            }
            if (this.knH != null) {
                this.knH.onChangeSkinType(i);
            }
            if (this.knk != null) {
                this.knk.onChangeSkinType();
            }
            if (this.knE != null) {
                com.baidu.tbadk.core.util.an.setViewTextColor(this.knE, (int) R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.an.setBackgroundColor(this.kmM, R.color.cp_bg_line_h);
            if (this.kme != null) {
                this.kme.qJ(i);
            }
            if (this.kmS != null) {
                this.kmS.onChangeSkinType();
            }
        }
    }

    public void cME() {
        if (this.kmS != null) {
            this.kmS.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.ba(eVar.cGN())) {
            if (this.kmS != null) {
                this.kmS.setEnable(false);
                this.kmS.onDestroy();
            }
            SvgManager.aWQ().a(this.kmR, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.kmS == null || !this.kmS.isEnable()) {
            SvgManager.aWQ().a(this.kmR, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eLw = iVar;
        this.kmo.setOnImageClickListener(this.eLw);
        this.knH.setOnImageClickListener(this.eLw);
    }

    public void g(NoNetworkView.a aVar) {
        this.hwW = aVar;
        if (this.flI != null) {
            this.flI.a(this.hwW);
        }
    }

    public void sn(boolean z) {
        this.kmo.setIsFromCDN(z);
    }

    public Button cMF() {
        return this.kmK;
    }

    public void cMG() {
        if (this.klY != 2) {
            this.kmd.setNextPage(this.hGJ);
            this.klY = 2;
        }
    }

    public void cMH() {
        if (com.baidu.tbadk.n.m.bhP().bhQ()) {
            int lastVisiblePosition = this.kmd.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.kmd.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.eAN = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr = new int[2];
                                    tbRichTextView.getLocationOnScreen(iArr);
                                    if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                    HeadImageView headImageView = (HeadImageView) childAt.findViewById(R.id.photo);
                    if (headImageView != null) {
                        com.baidu.tbadk.n.h perfLog2 = headImageView.getPerfLog();
                        perfLog2.setSubType(1001);
                        perfLog2.eAN = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr2 = new int[2];
                            headImageView.getLocationOnScreen(iArr2);
                            if (iArr2[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        headImageView.startLogPerf();
                    }
                }
            }
        }
    }

    public boolean cMI() {
        return this.ZX != null && this.ZX.getVisibility() == 0;
    }

    public boolean cMJ() {
        return this.ZX != null && this.ZX.bfc();
    }

    public void cMK() {
        if (this.ZX != null) {
            this.ZX.bdC();
        }
    }

    public void so(boolean z) {
        if (this.kmM != null) {
            sm(this.kbv.cIP().bfI());
            if (this.kmI) {
                sd(z);
            } else {
                se(z);
            }
        }
    }

    public void cML() {
        if (this.kmM != null) {
            this.kmL.setVisibility(8);
            this.kmM.setVisibility(8);
            this.kmV = false;
            if (this.knk != null) {
                this.knk.setVisibility(8);
                si(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.gXx == null) {
            this.gXx = new com.baidu.tbadk.core.view.a(this.kbv.getPageContext());
        }
        this.gXx.setDialogVisiable(true);
    }

    public void bJm() {
        if (this.gXx != null) {
            this.gXx.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.kmd.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.kmd.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.kmf != null) {
            this.kmf.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.knY = getScrollY();
            this.knj.kon = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.knj));
            a(this.knj.kon, true);
        }
    }

    public void sp(boolean z) {
        if (this.kmf != null) {
            this.kmf.sp(z);
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
        if (this.kmf != null) {
            this.kmf.onScroll(absListView, i, i2, i3);
        }
        if (this.klZ != null && this.kmi != null) {
            this.klZ.cM(this.kmi.cNl());
        }
        this.knj.jSs = i;
        this.knj.headerCount = this.kmd.getHeaderViewsCount();
        this.knj.kon = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.knj));
        sf(b(absListView, i));
        a(this.knj.kon, false);
        if (this.hGJ.aYb() && !this.hGJ.ecc) {
            if (this.knj != null && this.knj.kon != null && this.knj.kon.getView() != null) {
                i4 = this.knj.kon.getView().getTop() < 0 ? this.knj.kon.getView().getHeight() : this.knj.kon.getView().getBottom();
            }
            this.hGJ.mq(i4);
            this.hGJ.ecc = true;
        }
    }

    public void cMM() {
        if (TbadkCoreApplication.isLogin() && this.kcE != null && this.knz && !this.kny && !this.kmG && this.kmY != null && this.kmY.aSp() != null && !this.kmY.aSp().getIsLike() && !this.kmY.aSp().hadConcerned() && this.knv == null) {
            this.knv = new ar(this.kbv);
        }
    }

    public void cMN() {
        if (this.knz && !this.kny && this.kmY != null && this.kmY.aSp() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12601").ag("obj_locate", this.kbv.cHU() ? 2 : 1).ag("obj_type", this.kny ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.kbv.getPageContext().getPageActivity(), this.kmY.aSp().getUserId(), this.kmY.aSp().getUserName(), this.kbv.cIe().cHV(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(aq aqVar, boolean z) {
        int measuredHeight;
        if (!this.kny && this.knd != null && this.klZ.cND() != null) {
            int cIC = this.kmo.cIC();
            if (cIC > 0 && (aqVar == null || aqVar.getView().getParent() == null)) {
                if (cIC > this.kmd.getFirstVisiblePosition() - this.kmd.getHeaderViewsCount()) {
                    this.knd.setVisibility(4);
                    return;
                }
                this.knd.setVisibility(0);
                sf(false);
                this.klZ.mNavigationBar.hideBottomLine();
                if (this.knd.getParent() != null && ((ViewGroup) this.knd.getParent()).getHeight() <= this.knd.getTop()) {
                    this.knd.getParent().requestLayout();
                }
            } else if (aqVar == null || aqVar.getView() == null || aqVar.klx == null) {
                if (this.kmd.getFirstVisiblePosition() == 0) {
                    this.knd.setVisibility(4);
                    this.klZ.mNavigationBar.hideBottomLine();
                }
            } else {
                int top2 = aqVar.getView().getTop();
                if (aqVar.getView().getParent() != null) {
                    if (this.kni) {
                        this.knh = top2;
                        this.kni = false;
                    }
                    this.knh = top2 < this.knh ? top2 : this.knh;
                }
                if (top2 != 0 || aqVar.getView().isShown()) {
                    if (this.kmn.getY() < 0.0f) {
                        measuredHeight = kng - aqVar.klx.getMeasuredHeight();
                    } else {
                        measuredHeight = this.klZ.cND().getMeasuredHeight() - aqVar.klx.getMeasuredHeight();
                        this.klZ.mNavigationBar.hideBottomLine();
                    }
                    if (aqVar.getView().getParent() == null && top2 <= this.knh) {
                        this.knd.setVisibility(0);
                        sf(false);
                    } else if (top2 < measuredHeight) {
                        this.knd.setVisibility(0);
                        sf(false);
                    } else {
                        this.knd.setVisibility(4);
                        this.klZ.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.kni = true;
                    }
                }
            }
        }
    }

    public void cMO() {
        if (!this.knZ) {
            TiebaStatic.log("c10490");
            this.knZ = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kbv.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(knn, Integer.valueOf(knp));
            aVar.kS(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.kbv.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aP(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.kbv);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.av.21
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.kbv.getPageContext()).aUN();
        }
    }

    public void Kd(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kbv.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.kbv.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aP(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(knn, Integer.valueOf(knq));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.kbv);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.av.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kbv.getPageContext()).aUN();
    }

    public void a(int i, com.baidu.tieba.pb.data.e eVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(eVar, z)) != null && b.aSp() != null) {
            MetaData aSp = b.aSp();
            aSp.setGiftNum(aSp.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, int i, int i2) {
        a(eVar, z, i, i2);
        this.kmi.onChangeSkinType(i2);
    }

    public PbInterviewStatusView cMP() {
        return this.knb;
    }

    private void y(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cGN() != null && eVar.cGN().aTx() && this.knb == null) {
            this.knb = (PbInterviewStatusView) this.kna.inflate();
            this.knb.setOnClickListener(this.hCn);
            this.knb.setCallback(this.kbv.cJA());
            this.knb.setData(this.kbv, eVar);
        }
    }

    public RelativeLayout cMQ() {
        return this.kmn;
    }

    public View cMR() {
        return this.biD;
    }

    public boolean cMS() {
        return this.knO;
    }

    public void rw(boolean z) {
        this.kmi.rw(z);
    }

    public void Ke(String str) {
        if (this.kma != null) {
            this.kma.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int sq(boolean z) {
        if (this.knb == null || this.knb.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void cMT() {
        if (this.knb != null && this.knb.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.knb.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.knb.setLayoutParams(layoutParams);
        }
    }

    public boolean cIV() {
        return false;
    }

    public void Kf(String str) {
        this.iyQ.performClick();
        if (!StringUtils.isNull(str) && this.kbv.cIP() != null && this.kbv.cIP().bfA() != null && this.kbv.cIP().bfA().getInputView() != null) {
            EditText inputView = this.kbv.cIP().bfA().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            cMB();
            if (configuration.orientation == 2) {
                cML();
                cLJ();
            } else {
                cLN();
            }
            if (this.knu != null) {
                this.knu.cIK();
            }
            this.kbv.bYx();
            this.kmn.setVisibility(8);
            this.klZ.sB(false);
            this.kbv.rL(false);
            if (this.kmf != null) {
                if (configuration.orientation == 1) {
                    cMQ().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.kmd.setIsLandscape(true);
                    this.kmd.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.kmd.setIsLandscape(false);
                    if (this.knY > 0) {
                        this.kmd.smoothScrollBy(this.knY, 0);
                    }
                }
                this.kmf.onConfigurationChanged(configuration);
                this.knc.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void sr(boolean z) {
        if (this.kmf != null) {
            this.kmf.sr(z);
        }
    }

    public boolean cMU() {
        return this.kmf != null && this.kmf.cMU();
    }

    public void cMV() {
        if (this.kmf != null) {
            this.kmf.cMV();
        }
    }

    public void rA(boolean z) {
        this.kmo.rA(z);
    }

    public void cK(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.kmM.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.kbv.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.knE = new TextView(this.kbv.getContext());
            this.knE.setText(R.string.connection_tips);
            this.knE.setGravity(17);
            this.knE.setPadding(com.baidu.adp.lib.util.l.getDimens(this.kbv.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.kbv.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.kbv.getContext(), R.dimen.ds60);
            if (this.knE.getParent() == null) {
                frameLayout.addView(this.knE, layoutParams);
            }
            this.knD = new PopupWindow(this.kbv.getContext());
            this.knD.setContentView(frameLayout);
            this.knD.setHeight(-2);
            this.knD.setWidth(-2);
            this.knD.setFocusable(true);
            this.knD.setOutsideTouchable(false);
            this.knD.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.kmd.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.av.24
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        av.this.knD.showAsDropDown(av.this.kmM, view.getLeft(), -av.this.kmM.getHeight());
                    } else {
                        av.this.knD.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void ss(boolean z) {
        this.knJ = z;
    }

    public boolean cMW() {
        return this.knJ;
    }

    public PbThreadPostView cMX() {
        return this.kme;
    }

    private void aj(boolean z, boolean z2) {
        ak(z, z2);
        if (this.kcE != null && this.kcE.cGN() != null && this.kcE.cGN().aSD() == 0 && !this.kcE.cGN().aQV()) {
            al(z, z2);
        } else if (this.kmo != null && this.kmo.cIH() != null) {
            this.kmo.cIH().b(this.kcE, z, z2);
        }
    }

    private void ak(boolean z, boolean z2) {
        this.kmi.d(this.kcE, z, z2);
    }

    private void al(boolean z, boolean z2) {
        this.kmh.c(this.kcE, z, z2);
    }
}
