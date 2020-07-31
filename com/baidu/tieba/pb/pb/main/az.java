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
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
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
/* loaded from: classes16.dex */
public class az {
    private EditorTools ZS;
    private View biX;
    private RelativeLayout bjP;
    private View bkz;
    private View eGt;
    private f.c ejc;
    private com.baidu.tieba.pb.a.c euG;
    private NoNetworkView fqQ;
    private List<CustomBlueCheckRadioButton> gZh;
    private boolean hFn;
    private View.OnClickListener hIl;
    private PbListView hME;
    private TextView iEU;
    private NavigationBarCoverTip ihB;
    private com.baidu.tieba.NEGFeedBack.e ikU;
    private boolean isLandscape;
    private PbFragment kjZ;
    private View.OnClickListener kkW;
    private com.baidu.tieba.pb.data.f klg;
    private PbFakeFloorModel knx;
    PbFragment.c kpk;
    public int kuU;
    public final com.baidu.tieba.pb.pb.main.view.c kuW;
    public com.baidu.tieba.pb.pb.main.view.b kuX;
    private ViewStub kuY;
    private ViewStub kuZ;
    private View kvG;
    private View kvI;
    private View kvJ;
    private LinearLayout kvK;
    private HeadImageView kvL;
    private ImageView kvM;
    private ImageView kvN;
    private ImageView kvO;
    private com.baidu.tieba.pb.view.c kvP;
    private TextView kvQ;
    private TextView kvR;
    private int kvT;
    private int kvU;
    private PostData kvV;
    private ViewStub kvX;
    private PbInterviewStatusView kvY;
    private FrameLayout kvZ;
    private PbLandscapeListView kva;
    private PbThreadPostView kvb;
    private com.baidu.tieba.pb.pb.main.a.e kvc;
    private com.baidu.tieba.pb.pb.main.a.a kvd;
    private com.baidu.tieba.pb.pb.main.a.c kve;
    private com.baidu.tieba.pb.pb.main.a.d kvf;
    private com.baidu.tieba.pb.pb.main.a.b kvg;
    private LinearLayout kvh;
    private TextView kvi;
    private TextView kvj;
    private ObservedChangeRelativeLayout kvk;
    private g kvl;
    private View kvr;
    private PopupWindow kwA;
    private TextView kwB;
    private List<String> kwC;
    private com.baidu.tieba.pb.pb.main.emotion.c kwD;
    private com.baidu.tieba.pb.pb.godreply.a kwE;
    private PbLandscapeListView.b kwF;
    private al kwH;
    private String kwI;
    private long kwJ;
    private int kwK;
    private boolean kwM;
    private Runnable kwQ;
    private PbFragment.b kwS;
    public int kwW;
    private View kwa;
    private View kwb;
    private au kwc;
    private PbEmotionBar kwh;
    private int kwp;
    private Runnable kwq;
    private v kwr;
    private av kws;
    private int kwy;
    private PbTopTipView kwz;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int kwd = UtilHelper.getLightStatusBarHeight();
    public static int kwj = 3;
    public static int kwk = 0;
    public static int kwl = 3;
    public static int kwm = 4;
    public static int kwn = 5;
    public static int kwo = 6;
    private static a.InterfaceC0753a kwL = new a.InterfaceC0753a() { // from class: com.baidu.tieba.pb.pb.main.az.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0753a
        public void onRefresh() {
        }
    };
    private int kuV = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a kvm = null;
    private com.baidu.tbadk.core.dialog.b hIk = null;
    private View kvn = null;
    private EditText kvo = null;
    private com.baidu.tieba.pb.view.d kvp = null;
    private com.baidu.tieba.pb.view.a kvq = null;
    private b.InterfaceC0492b jdJ = null;
    private TbRichTextView.i eRR = null;
    private NoNetworkView.a hCK = null;
    private com.baidu.tbadk.core.dialog.i kvs = null;
    private com.baidu.tbadk.core.dialog.a kvt = null;
    private Dialog kvu = null;
    private Dialog kvv = null;
    private View kvw = null;
    private LinearLayout kvx = null;
    private CompoundButton.OnCheckedChangeListener gZi = null;
    private TextView kvy = null;
    private TextView kvz = null;
    private String kvA = null;
    private com.baidu.tbadk.core.dialog.i kok = null;
    private com.baidu.tbadk.core.dialog.i kvB = null;
    private boolean kvC = false;
    private boolean kvD = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView kvE = null;
    private boolean kvF = false;
    private Button kvH = null;
    private boolean kvS = true;
    private com.baidu.tbadk.core.view.a hdc = null;
    private boolean kkO = false;
    private int mSkinType = 3;
    private boolean kvW = false;
    private int kwe = 0;
    private boolean kwf = true;
    public a kwg = new a();
    private int kwi = 0;
    private boolean kwt = false;
    private int kwu = 0;
    private boolean kwv = false;
    private boolean kww = false;
    private boolean kwx = false;
    private boolean kwG = false;
    private String kwN = null;
    private CustomMessageListener kwO = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.az.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                az.this.kwN = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.az.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && az.this.kvl != null) {
                az.this.kvl.notifyDataSetChanged();
            }
        }
    };
    private Handler kwP = new Handler();
    private CustomMessageListener kwR = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.az.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                az.this.kvS = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean kwT = true;
    View.OnClickListener kwU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || az.this.klg == null || az.this.klg.cKx() == null || az.this.klg.cKx().aWl() == null || az.this.klg.cKx().aWl().getAlaInfo() == null || az.this.klg.cKx().aWl().getAlaInfo().live_status != 1) {
                if (az.this.kwv) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11923").ah("obj_id", 2));
                }
                if (!az.this.kwv && az.this.klg != null && az.this.klg.cKx() != null && az.this.klg.cKx().aWl() != null && az.this.klg.cKx().aWl().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12151").ah("obj_locate", 1));
                }
                if (az.this.kjZ.cNt() != null) {
                    az.this.kjZ.cNt().kkl.hps.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c11851");
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(apVar);
            if (az.this.klg.cKx().aWl().getAlaInfo() == null || !az.this.klg.cKx().aWl().getAlaInfo().isChushou) {
                if (az.this.klg.cKx().aWl().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = az.this.klg.cKx().aWl().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(az.this.kjZ.cNt(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.bd.baV().b(az.this.kjZ.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + az.this.klg.cKx().aWl().getAlaInfo().thirdRoomId + "&livetype=" + az.this.klg.cKx().aWl().getAlaInfo().thirdLiveType});
        }
    };
    private boolean aSJ = false;
    String userId = null;
    private final List<TbImageView> kwV = new ArrayList();
    private boolean kwX = false;

    /* loaded from: classes16.dex */
    public static class a {
        public int headerCount;
        public int kaR;
        public au kxl;
    }

    public void sH(boolean z) {
        this.kwt = z;
        if (this.kva != null) {
            this.kwu = this.kva.getHeaderViewsCount();
        }
    }

    public void cPu() {
        if (this.kva != null) {
            int headerViewsCount = this.kva.getHeaderViewsCount() - this.kwu;
            final int firstVisiblePosition = (this.kva.getFirstVisiblePosition() == 0 || this.kva.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.kva.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.kva.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.kwg.kxl = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kwg));
            final au auVar = this.kwg.kxl;
            final int g = g(auVar);
            final int y = ((int) this.kvk.getY()) + this.kvk.getMeasuredHeight();
            final boolean z = this.kwa.getVisibility() == 0;
            boolean z2 = this.kvk.getY() < 0.0f;
            if ((z && auVar != null) || firstVisiblePosition >= this.kvl.cMn() + this.kva.getHeaderViewsCount()) {
                int measuredHeight = auVar != null ? auVar.kuv.getMeasuredHeight() : 0;
                if (z2) {
                    this.kva.setSelectionFromTop(this.kvl.cMn() + this.kva.getHeaderViewsCount(), kwd - measuredHeight);
                } else {
                    this.kva.setSelectionFromTop(this.kvl.cMn() + this.kva.getHeaderViewsCount(), this.kuW.cRr().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.kva.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.kwv && this.kvc != null) {
                this.kva.setSelectionFromTop(this.kvl.cMn() + this.kva.getHeaderViewsCount(), this.kvc.cRd());
            } else if (this.mType == 6) {
                this.kva.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.az.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void cNF() {
                        ViewGroup.LayoutParams layoutParams;
                        if (g >= 0 && g <= az.this.bjP.getMeasuredHeight()) {
                            int g2 = az.this.g(auVar);
                            int i = g2 - g;
                            if (z && i != 0 && g <= y) {
                                i = g2 - y;
                            }
                            if (az.this.bkz != null && (layoutParams = az.this.bkz.getLayoutParams()) != null) {
                                if (i == 0 || i > az.this.bjP.getMeasuredHeight() || g2 >= az.this.bjP.getMeasuredHeight()) {
                                    layoutParams.height = az.this.kwp;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > az.this.bjP.getMeasuredHeight()) {
                                    layoutParams.height = az.this.kwp;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    az.this.kva.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                az.this.bkz.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (az.this.bkz != null && az.this.bkz.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = az.this.bkz.getLayoutParams();
                                            layoutParams2.height = az.this.kwp;
                                            az.this.bkz.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        az.this.kva.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(au auVar) {
        if (auVar == null || auVar.getView() == null) {
            return 0;
        }
        if (auVar.getView().getTop() != 0 || auVar.getView().isShown()) {
            return auVar.getView().getBottom();
        }
        return 0;
    }

    public NoNetworkView cPv() {
        return this.fqQ;
    }

    public void cPw() {
        if (this.ZS != null) {
            this.ZS.hide();
            if (this.kwD != null) {
                this.kwD.cRf();
            }
        }
    }

    public PbFakeFloorModel cPx() {
        return this.knx;
    }

    public v cPy() {
        return this.kwr;
    }

    public com.baidu.tieba.pb.pb.main.a.e cPz() {
        return this.kvc;
    }

    public void cPA() {
        reset();
        cPw();
        this.kwr.cMv();
        sT(false);
    }

    private void reset() {
        if (this.kjZ != null && this.kjZ.cMA() != null && this.ZS != null) {
            com.baidu.tbadk.editortools.pb.a.bjh().setStatus(0);
            com.baidu.tbadk.editortools.pb.e cMA = this.kjZ.cMA();
            cMA.bjC();
            cMA.biU();
            if (cMA.getWriteImagesInfo() != null) {
                cMA.getWriteImagesInfo().setMaxImagesAllowed(cMA.isBJH ? 1 : 9);
            }
            cMA.nZ(SendView.ALL);
            cMA.oa(SendView.ALL);
            com.baidu.tbadk.editortools.g nQ = this.ZS.nQ(23);
            com.baidu.tbadk.editortools.g nQ2 = this.ZS.nQ(2);
            com.baidu.tbadk.editortools.g nQ3 = this.ZS.nQ(5);
            if (nQ2 != null) {
                nQ2.display();
            }
            if (nQ3 != null) {
                nQ3.display();
            }
            if (nQ != null) {
                nQ.hide();
            }
            this.ZS.invalidate();
        }
    }

    public boolean cPB() {
        return this.kvS;
    }

    public void sI(boolean z) {
        if (this.kvJ != null && this.iEU != null) {
            this.iEU.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kvJ.startAnimation(alphaAnimation);
            }
            this.kvI.setVisibility(0);
            this.kvJ.setVisibility(0);
            this.kvS = true;
            if (this.kwh != null && !this.kwE.isActive()) {
                this.kwh.setVisibility(0);
                sN(true);
            }
        }
    }

    public void sJ(boolean z) {
        if (this.kvJ != null && this.iEU != null) {
            this.iEU.setText(cPC());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kvJ.startAnimation(alphaAnimation);
            }
            this.kvI.setVisibility(0);
            this.kvJ.setVisibility(0);
            this.kvS = true;
            if (this.kwh != null && !this.kwE.isActive()) {
                this.kwh.setVisibility(0);
                sN(true);
            }
        }
    }

    public String cPC() {
        if (!com.baidu.tbadk.core.util.as.isEmpty(this.kwI)) {
            return this.kwI;
        }
        if (this.kjZ != null) {
            this.kwI = TbadkCoreApplication.getInst().getResources().getString(ay.cPr());
        }
        return this.kwI;
    }

    public PostData cPD() {
        int i = 0;
        if (this.kva == null) {
            return null;
        }
        int cPE = cPE() - this.kva.getHeaderViewsCount();
        if (cPE < 0) {
            cPE = 0;
        }
        if (this.kvl.BC(cPE) != null && this.kvl.BC(cPE) != PostData.lNa) {
            i = cPE + 1;
        }
        return this.kvl.getItem(i) instanceof PostData ? (PostData) this.kvl.getItem(i) : null;
    }

    public int cPE() {
        int i;
        View childAt;
        if (this.kva == null) {
            return 0;
        }
        int firstVisiblePosition = this.kva.getFirstVisiblePosition();
        int lastVisiblePosition = this.kva.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.kva.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.kva.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int cPF() {
        return this.kva.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.klg != null && this.klg.cKz() != null && !this.klg.cKz().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.klg.cKz().size() && (postData = this.klg.cKz().get(i)) != null && postData.aWl() != null && !StringUtils.isNull(postData.aWl().getUserId()); i++) {
                if (this.klg.cKz().get(i).aWl().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.kwE != null && this.kwE.isActive()) {
                        sT(false);
                    }
                    if (this.kwh != null) {
                        this.kwh.td(true);
                    }
                    this.kwN = postData.aWl().getName_show();
                    return;
                }
            }
        }
    }

    public az(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.kjZ = null;
        this.bjP = null;
        this.biX = null;
        this.kva = null;
        this.kvl = null;
        this.hME = null;
        this.eGt = null;
        this.hIl = null;
        this.kkW = null;
        this.kvJ = null;
        this.iEU = null;
        this.kvX = null;
        this.kwy = 0;
        this.kwJ = 0L;
        this.kwJ = System.currentTimeMillis();
        this.kjZ = pbFragment;
        this.hIl = onClickListener;
        this.euG = cVar;
        this.kwy = com.baidu.adp.lib.util.l.getEquipmentWidth(this.kjZ.getContext()) / 32;
        this.bjP = (RelativeLayout) LayoutInflater.from(this.kjZ.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bjP.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.kvG = this.bjP.findViewById(R.id.bottom_shadow);
        this.ihB = (NavigationBarCoverTip) this.bjP.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.biX = this.bjP.findViewById(R.id.statebar_view);
        this.kvk = (ObservedChangeRelativeLayout) this.bjP.findViewById(R.id.title_wrapper);
        this.fqQ = (NoNetworkView) this.bjP.findViewById(R.id.view_no_network);
        this.kva = (PbLandscapeListView) this.bjP.findViewById(R.id.new_pb_list);
        this.kvZ = (FrameLayout) this.bjP.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.kjZ.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.kjZ.getActivity(), R.dimen.ds88));
        this.kva.addHeaderView(this.textView, 0);
        this.kva.setTextViewAdded(true);
        this.kwp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bkz = new View(this.kjZ.getPageContext().getPageActivity());
        this.bkz.setLayoutParams(new AbsListView.LayoutParams(-1, this.kwp));
        this.bkz.setVisibility(4);
        this.kva.addFooterView(this.bkz);
        this.kva.setOnTouchListener(this.kjZ.eKY);
        this.kuW = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bjP);
        if (this.kjZ.cNd()) {
            this.kuY = (ViewStub) this.bjP.findViewById(R.id.manga_view_stub);
            this.kuY.setVisibility(0);
            this.kuX = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.kuX.show();
            this.kuW.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.kjZ.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.kuW.cRr().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0710a() { // from class: com.baidu.tieba.pb.pb.main.az.26
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0710a
            public void cLz() {
                if (az.this.kva != null) {
                    if (az.this.kvc != null) {
                        az.this.kvc.cRc();
                    }
                    az.this.kva.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0710a
            public void cLA() {
                az.this.kjZ.cbV();
            }
        }));
        this.kvI = this.bjP.findViewById(R.id.view_comment_top_line);
        this.kvJ = this.bjP.findViewById(R.id.pb_editor_tool_comment);
        this.kvT = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.kvU = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.kvL = (HeadImageView) this.bjP.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.kvL.setVisibility(0);
        this.kvL.setIsRound(true);
        this.kvL.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.kjZ.getContext(), R.dimen.tbds1));
        this.kvL.setBorderColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_border_a));
        this.kvL.setPlaceHolder(1);
        this.kvL.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.kvL.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        this.iEU = (TextView) this.bjP.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.kvK = (LinearLayout) this.bjP.findViewById(R.id.pb_editer_tool_comment_layout);
        this.kvK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.kjZ.cML();
                if (az.this.kjZ != null && az.this.kjZ.cLP() != null && az.this.kjZ.cLP().getPbData() != null && az.this.kjZ.cLP().getPbData().cKx() != null && az.this.kjZ.cLP().getPbData().cKx().aWl() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13701").dn("tid", az.this.kjZ.cLP().cNM()).dn("fid", az.this.kjZ.cLP().getPbData().getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13402").dn("tid", az.this.kjZ.cLP().krd).dn("fid", az.this.kjZ.cLP().getPbData().getForumId()).ah("obj_locate", 1).dn("uid", az.this.kjZ.cLP().getPbData().cKx().aWl().getUserId()));
                }
            }
        });
        this.kvM = (ImageView) this.bjP.findViewById(R.id.pb_editor_tool_comment_icon);
        this.kvM.setOnClickListener(this.hIl);
        boolean booleanExtra = this.kjZ.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.kvN = (ImageView) this.bjP.findViewById(R.id.pb_editor_tool_collection);
        this.kvN.setOnClickListener(this.hIl);
        if (booleanExtra) {
            this.kvN.setVisibility(8);
        } else {
            this.kvN.setVisibility(0);
        }
        this.kvO = (ImageView) this.bjP.findViewById(R.id.pb_editor_tool_share);
        this.kvO.setOnClickListener(this.hIl);
        this.kvP = new com.baidu.tieba.pb.view.c(this.kvO);
        this.kvP.cUD();
        this.kvQ = (TextView) this.bjP.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.kvQ.setVisibility(0);
        this.kvX = (ViewStub) this.bjP.findViewById(R.id.interview_status_stub);
        this.kvd = new com.baidu.tieba.pb.pb.main.a.a(this.kjZ, cVar);
        this.kvf = new com.baidu.tieba.pb.pb.main.a.d(this.kjZ, cVar, this.hIl);
        this.kvl = new g(this.kjZ, this.kva);
        this.kvl.E(this.hIl);
        this.kvl.setTbGestureDetector(this.euG);
        this.kvl.setOnImageClickListener(this.eRR);
        this.kvl.setOnSwitchChangeListener(this.kjZ.kpe);
        this.kkW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.28
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
                            az.this.kjZ.c(sparseArray);
                            return;
                        }
                        az.this.cP(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        az.this.kjZ.c(sparseArray);
                    } else if (booleanValue3) {
                        az.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.kvl.R(this.kkW);
        cPK();
        cPL();
        this.kvf.b(this.kva);
        this.kve.b(this.kva);
        this.kvd.b(this.kva);
        this.hME = new PbListView(this.kjZ.getPageContext().getPageActivity());
        this.eGt = this.hME.getView().findViewById(R.id.pb_more_view);
        if (this.eGt != null) {
            this.eGt.setOnClickListener(this.hIl);
            com.baidu.tbadk.core.util.ao.setBackgroundResource(this.eGt, R.drawable.pb_foot_more_trans_selector);
        }
        this.hME.setLineVisible();
        this.hME.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.hME.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.kvr = this.bjP.findViewById(R.id.viewstub_progress);
        this.kjZ.registerListener(this.kwR);
        this.knx = new PbFakeFloorModel(this.kjZ.getPageContext());
        this.kwr = new v(this.kjZ.getPageContext(), this.knx, this.bjP);
        this.kwr.S(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.cPA();
            }
        });
        this.kwr.a(this.kjZ.kpf);
        this.knx.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.az.30
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                az.this.knx.t(postData);
                az.this.kvl.notifyDataSetChanged();
                az.this.kwr.cMv();
                az.this.ZS.bhl();
                az.this.sT(false);
            }
        });
        if (this.kjZ.cLP() != null && !StringUtils.isNull(this.kjZ.cLP().cOu())) {
            this.kjZ.showToast(this.kjZ.cLP().cOu());
        }
        this.kwa = this.bjP.findViewById(R.id.pb_expand_blank_view);
        this.kwb = this.bjP.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kwb.getLayoutParams();
        if (this.kjZ.cLP() != null && this.kjZ.cLP().cNP()) {
            this.kwa.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.kwb.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = kwd;
            this.kwb.setLayoutParams(layoutParams2);
        }
        this.kwc = new au(this.kjZ.getPageContext(), this.bjP.findViewById(R.id.pb_reply_expand_view));
        this.kwc.w(pbFragment.koa);
        this.kwc.kuv.setVisibility(8);
        this.kwc.T(this.hIl);
        this.kwc.setOnSwitchChangeListener(this.kjZ.kpe);
        this.kjZ.registerListener(this.mAccountChangedListener);
        this.kjZ.registerListener(this.kwO);
        cPG();
        sN(false);
    }

    public void sK(boolean z) {
        this.kvG.setVisibility(z ? 0 : 8);
    }

    public void cok() {
        if (!this.kjZ.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10517").ah("obj_locate", 2).dn("fid", this.mForumId));
        } else if (this.kjZ.cMN()) {
            com.baidu.tbadk.editortools.pb.e cMA = this.kjZ.cMA();
            if (cMA != null && (cMA.bjz() || cMA.bjA())) {
                this.kjZ.cMA().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.ZS != null) {
                cPQ();
            }
            if (this.ZS != null) {
                this.kvS = false;
                if (this.ZS.nT(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.kjZ.getPageContext(), (View) this.ZS.nT(2).ezZ, false, kwL);
                }
            }
            cQy();
        }
    }

    private void cPG() {
        this.kwE = new com.baidu.tieba.pb.pb.godreply.a(this.kjZ, this, (ViewStub) this.bjP.findViewById(R.id.more_god_reply_popup));
        this.kwE.z(this.hIl);
        this.kwE.R(this.kkW);
        this.kwE.setOnImageClickListener(this.eRR);
        this.kwE.z(this.hIl);
        this.kwE.setTbGestureDetector(this.euG);
    }

    public com.baidu.tieba.pb.pb.godreply.a cPH() {
        return this.kwE;
    }

    public View cPI() {
        return this.kwa;
    }

    public void cPJ() {
        if (this.kva != null) {
            this.kve.c(this.kva);
            this.kvf.c(this.kva);
            this.kvg.c(this.kva);
            this.kvd.c(this.kva);
        }
    }

    private void cPK() {
        if (this.kvg == null) {
            this.kvg = new com.baidu.tieba.pb.pb.main.a.b(this.kjZ, this.hIl);
        }
    }

    private void cPL() {
        if (this.kve == null) {
            this.kve = new com.baidu.tieba.pb.pb.main.a.c(this.kjZ, this.euG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPM() {
        if (this.kjZ.cNd()) {
            this.kuZ = (ViewStub) this.bjP.findViewById(R.id.manga_mention_controller_view_stub);
            this.kuZ.setVisibility(0);
            if (this.kvh == null) {
                this.kvh = (LinearLayout) this.bjP.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.kjZ.getPageContext(), this.kvh);
            }
            if (this.kvi == null) {
                this.kvi = (TextView) this.kvh.findViewById(R.id.manga_prev_btn);
            }
            if (this.kvj == null) {
                this.kvj = (TextView) this.kvh.findViewById(R.id.manga_next_btn);
            }
            this.kvi.setOnClickListener(this.hIl);
            this.kvj.setOnClickListener(this.hIl);
        }
    }

    private void cPN() {
        if (this.kjZ.cNd()) {
            if (this.kjZ.cNg() == -1) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kvi, R.color.cp_cont_e, 1);
            }
            if (this.kjZ.cNh() == -1) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kvj, R.color.cp_cont_e, 1);
            }
        }
    }

    public void cPO() {
        if (this.kvh == null) {
            cPM();
        }
        this.kuZ.setVisibility(8);
        if (this.kwP != null && this.kwQ != null) {
            this.kwP.removeCallbacks(this.kwQ);
        }
    }

    public void cPP() {
        if (this.kwP != null) {
            if (this.kwQ != null) {
                this.kwP.removeCallbacks(this.kwQ);
            }
            this.kwQ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.3
                @Override // java.lang.Runnable
                public void run() {
                    if (az.this.kvh == null) {
                        az.this.cPM();
                    }
                    az.this.kuZ.setVisibility(0);
                }
            };
            this.kwP.postDelayed(this.kwQ, 2000L);
        }
    }

    public void sL(boolean z) {
        this.kuW.sL(z);
        if (z && this.kvW) {
            this.hME.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.kva.setNextPage(this.hME);
            this.kuV = 2;
        }
        if (this.kvL != null) {
            this.kvL.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.ZS = editorTools;
        this.ZS.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.cPA();
            }
        });
        this.ZS.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.ZS.getParent() == null) {
            this.bjP.addView(this.ZS, layoutParams);
        }
        this.ZS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.ZS.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.az.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).bef() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).bef() == EmotionGroupType.USER_COLLECT) {
                        if (az.this.mPermissionJudgePolicy == null) {
                            az.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        az.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        az.this.mPermissionJudgePolicy.appendRequestPermission(az.this.kjZ.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!az.this.mPermissionJudgePolicy.startRequestPermission(az.this.kjZ.getBaseFragmentActivity())) {
                            az.this.kjZ.cMA().c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            az.this.kjZ.cMA().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cPw();
        this.kjZ.cMA().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.az.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (az.this.ZS != null && az.this.ZS.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (az.this.kwD == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, az.this.ZS.getId());
                            az.this.kwD = new com.baidu.tieba.pb.pb.main.emotion.c(az.this.kjZ.getPageContext(), az.this.bjP, layoutParams2);
                            if (!com.baidu.tbadk.core.util.x.isEmpty(az.this.kwC)) {
                                az.this.kwD.setData(az.this.kwC);
                            }
                            az.this.kwD.c(az.this.ZS);
                        }
                        az.this.kwD.KW(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (az.this.kjZ.koj != null && az.this.kjZ.koj.cQO() != null) {
                    if (!az.this.kjZ.koj.cQO().dub()) {
                        az.this.kjZ.koj.sZ(false);
                    }
                    az.this.kjZ.koj.cQO().wj(false);
                }
            }
        });
    }

    public void cPQ() {
        if (this.kjZ != null && this.ZS != null) {
            this.ZS.display();
            if (this.kjZ.cMA() != null) {
                this.kjZ.cMA().bjp();
            }
            cQy();
        }
    }

    public void sM(boolean z) {
        if (this.kva != null && this.textView != null && this.biX != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.biX.setVisibility(0);
                } else {
                    this.biX.setVisibility(8);
                    this.kva.removeHeaderView(this.textView);
                    this.kva.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = kwd;
                    this.textView.setLayoutParams(layoutParams);
                }
                cQe();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + sV(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            cQe();
            cQG();
        }
    }

    public g cPR() {
        return this.kvl;
    }

    public void a(PbFragment.c cVar) {
        this.kpk = cVar;
    }

    public void cP(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kjZ.getContext());
        kVar.setTitleText(this.kjZ.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.kvs.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            az.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (az.this.kwS != null) {
                                az.this.kwS.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            az.this.kjZ.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.kjZ.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.kjZ.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !cQF()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.kjZ.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.kjZ.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.kjZ.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aS(arrayList);
        if (this.kvs == null) {
            this.kvs = new com.baidu.tbadk.core.dialog.i(this.kjZ.getPageContext(), kVar);
        } else {
            this.kvs.a(kVar);
        }
        this.kvs.showDialog();
    }

    public void a(PbFragment.b bVar) {
        this.kwS = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.kjZ != null && aVar != null) {
            if (this.ikU == null && this.kvd != null) {
                this.ikU = new com.baidu.tieba.NEGFeedBack.e(this.kjZ.getPageContext(), this.kvd.cQY());
            }
            AntiData cax = this.kjZ.cax();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cax != null && cax.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cax.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.aq aqVar = new com.baidu.tbadk.core.data.aq();
            aqVar.setFeedBackReasonMap(sparseArray);
            this.ikU.setDefaultReasonArray(new String[]{this.kjZ.getString(R.string.delete_thread_reason_1), this.kjZ.getString(R.string.delete_thread_reason_2), this.kjZ.getString(R.string.delete_thread_reason_3), this.kjZ.getString(R.string.delete_thread_reason_4), this.kjZ.getString(R.string.delete_thread_reason_5)});
            this.ikU.setData(aqVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.ikU.AK(str);
            this.ikU.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.az.9
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void U(JSONArray jSONArray) {
                    az.this.kjZ.a(aVar, jSONArray);
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
        sparseArray.put(kwk, Integer.valueOf(kwl));
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
        this.kvt = new com.baidu.tbadk.core.dialog.a(this.kjZ.getActivity());
        if (StringUtils.isNull(str2)) {
            this.kvt.ln(i3);
        } else {
            this.kvt.setOnlyMessageShowCenter(false);
            this.kvt.xl(str2);
        }
        this.kvt.setYesButtonTag(sparseArray);
        this.kvt.a(R.string.dialog_ok, this.kjZ);
        this.kvt.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kvt.hJ(true);
        this.kvt.b(this.kjZ.getPageContext());
        if (z) {
            this.kvt.aYL();
        } else {
            a(this.kvt, i);
        }
    }

    public void aR(ArrayList<com.baidu.tbadk.core.data.ai> arrayList) {
        if (this.kvw == null) {
            this.kvw = LayoutInflater.from(this.kjZ.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.kjZ.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kvw);
        if (this.kvv == null) {
            this.kvv = new Dialog(this.kjZ.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.kvv.setCanceledOnTouchOutside(true);
            this.kvv.setCancelable(true);
            this.kvE = (ScrollView) this.kvw.findViewById(R.id.good_scroll);
            this.kvv.setContentView(this.kvw);
            WindowManager.LayoutParams attributes = this.kvv.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.kvv.getWindow().setAttributes(attributes);
            this.gZi = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.az.12
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        az.this.kvA = (String) compoundButton.getTag();
                        if (az.this.gZh != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : az.this.gZh) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && az.this.kvA != null && !str.equals(az.this.kvA)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.kvx = (LinearLayout) this.kvw.findViewById(R.id.good_class_group);
            this.kvz = (TextView) this.kvw.findViewById(R.id.dialog_button_cancel);
            this.kvz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (az.this.kvv instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(az.this.kvv, az.this.kjZ.getPageContext());
                    }
                }
            });
            this.kvy = (TextView) this.kvw.findViewById(R.id.dialog_button_ok);
            this.kvy.setOnClickListener(this.hIl);
        }
        this.kvx.removeAllViews();
        this.gZh = new ArrayList();
        CustomBlueCheckRadioButton fc = fc("0", this.kjZ.getPageContext().getString(R.string.thread_good_class));
        this.gZh.add(fc);
        fc.setChecked(true);
        this.kvx.addView(fc);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ai aiVar = arrayList.get(i2);
                if (aiVar != null && !TextUtils.isEmpty(aiVar.aUz()) && aiVar.aUA() > 0) {
                    CustomBlueCheckRadioButton fc2 = fc(String.valueOf(aiVar.aUA()), aiVar.aUz());
                    this.gZh.add(fc2);
                    View view = new View(this.kjZ.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ao.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.kvx.addView(view);
                    this.kvx.addView(fc2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.kvE.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kjZ.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kjZ.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kjZ.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.kvE.setLayoutParams(layoutParams2);
            this.kvE.removeAllViews();
            if (this.kvx != null && this.kvx.getParent() == null) {
                this.kvE.addView(this.kvx);
            }
        }
        com.baidu.adp.lib.f.g.a(this.kvv, this.kjZ.getPageContext());
    }

    private CustomBlueCheckRadioButton fc(String str, String str2) {
        Activity pageActivity = this.kjZ.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.gZi);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void cPS() {
        this.kjZ.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.kjZ.hideProgressBar();
        if (z && z2) {
            this.kjZ.showToast(this.kjZ.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.as.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.kjZ.showToast(str);
        }
    }

    public void cvF() {
        this.kvr.setVisibility(0);
    }

    public void cvE() {
        this.kvr.setVisibility(8);
    }

    public View cPT() {
        if (this.kvw != null) {
            return this.kvw.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String cPU() {
        return this.kvA;
    }

    public View getView() {
        return this.bjP;
    }

    public void cPV() {
        if (this.kjZ != null && this.kjZ.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.kjZ.getPageContext().getPageActivity(), this.kjZ.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.kjZ.hideProgressBar();
        if (z) {
            cQo();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            cQp();
        } else {
            cQo();
        }
    }

    public void cPW() {
        this.hME.setLineVisible();
        this.hME.startLoadData();
    }

    public void cPX() {
        this.kjZ.hideProgressBar();
        endLoadData();
        this.kva.completePullRefreshPostDelayed(0L);
        cQj();
    }

    public void cPY() {
        this.kva.completePullRefreshPostDelayed(0L);
        cQj();
    }

    private void sN(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.kvf.b(onLongClickListener);
        this.kvl.setOnLongClickListener(onLongClickListener);
        if (this.kwE != null) {
            this.kwE.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0492b interfaceC0492b, boolean z, boolean z2) {
        if (this.kok != null) {
            this.kok.dismiss();
            this.kok = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kjZ.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.kjZ.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kjZ.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kjZ.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kjZ.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.aS(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.kvB.dismiss();
                interfaceC0492b.a(null, i, view);
            }
        });
        this.kvB = new com.baidu.tbadk.core.dialog.i(this.kjZ.getPageContext(), kVar);
        this.kvB.showDialog();
    }

    public void a(final b.InterfaceC0492b interfaceC0492b, boolean z) {
        if (this.kvB != null) {
            this.kvB.dismiss();
            this.kvB = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kjZ.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.klg != null && this.klg.cKx() != null && !this.klg.cKx().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.kjZ.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kjZ.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aS(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.kvB.dismiss();
                interfaceC0492b.a(null, i, view);
            }
        });
        this.kvB = new com.baidu.tbadk.core.dialog.i(this.kjZ.getPageContext(), kVar);
        this.kvB.showDialog();
    }

    public int cPZ() {
        return Ca(this.kva.getFirstVisiblePosition());
    }

    private int Ca(int i) {
        com.baidu.adp.widget.ListView.f adapter = this.kva.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.kva.getAdapter() == null || !(this.kva.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) ? 0 : this.kva.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int cQa() {
        int lastVisiblePosition = this.kva.getLastVisiblePosition();
        if (this.kvc != null) {
            if (lastVisiblePosition == this.kva.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return Ca(lastVisiblePosition);
    }

    public void Cb(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.kva != null) {
            if (this.kuW == null || this.kuW.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.kuW.mNavigationBar.getFixedNavHeight();
                if (this.kjZ.cMT() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.kwb != null && (layoutParams = (LinearLayout.LayoutParams) this.kwb.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.kwb.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.kva.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.kva.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.kva.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.kvo.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.kvl.a(fVar, false);
        this.kvl.notifyDataSetChanged();
        cQj();
        if (this.kwE != null) {
            this.kwE.cLL();
        }
        ArrayList<PostData> cKz = fVar.cKz();
        if (fVar.getPage().aVb() == 0 || cKz == null || cKz.size() < fVar.getPage().aVa()) {
            if (com.baidu.tbadk.core.util.x.getCount(cKz) == 0 || (com.baidu.tbadk.core.util.x.getCount(cKz) == 1 && cKz.get(0) != null && cKz.get(0).dlh() == 1)) {
                if (this.kwg == null || this.kwg.kxl == null || this.kwg.kxl.getView() == null) {
                    i = 0;
                } else {
                    i = this.kwg.kxl.getView().getTop() < 0 ? this.kwg.kxl.getView().getHeight() : this.kwg.kxl.getView().getBottom();
                }
                if (this.kjZ.cNn()) {
                    this.hME.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.hME.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().aVb() == 0) {
                    this.hME.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.hME.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.hME.bca();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.kvd != null) {
            this.kvd.e(fVar, this.kkO);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.cKK() != null) {
            return fVar.cKK();
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(fVar.cKz())) {
            Iterator<PostData> it = fVar.cKz().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dlh() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.cKG();
        }
        if (!r(postData)) {
            postData = a(fVar);
        }
        if (postData != null && postData.aWl() != null && postData.aWl().getUserTbVipInfoData() != null && postData.aWl().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aWl().getGodUserData().setIntro(postData.aWl().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean r(PostData postData) {
        if (postData == null || postData.aWl() == null) {
            return false;
        }
        MetaData aWl = postData.aWl();
        return (TextUtils.isEmpty(aWl.getUserId()) && TextUtils.isEmpty(aWl.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.cKx() == null || fVar.cKx().aWl() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aWl = fVar.cKx().aWl();
        String userId = aWl.getUserId();
        HashMap<String, MetaData> userMap = fVar.cKx().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aWl;
        }
        postData.Fs(1);
        postData.setId(fVar.cKx().aWC());
        postData.setTitle(fVar.cKx().getTitle());
        postData.setTime(fVar.cKx().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.cKx() != null) {
            if (this.kjZ.cLF()) {
                if (fVar.cKw() != null) {
                    this.mForumName = fVar.cKw().getForumName();
                    this.mForumId = fVar.cKw().getForumId();
                }
                if (this.mForumName == null && this.kjZ.cLP() != null && this.kjZ.cLP().cLG() != null) {
                    this.mForumName = this.kjZ.cLP().cLG();
                }
            }
            PostData b = b(fVar, z);
            a(b, fVar);
            this.kvf.setVisibility(8);
            if (fVar.cKX()) {
                this.kwv = true;
                this.kuW.rU(true);
                this.kuW.mNavigationBar.hideBottomLine();
                if (this.kvc == null) {
                    this.kvc = new com.baidu.tieba.pb.pb.main.a.e(this.kjZ);
                }
                this.kvc.a(fVar, b, this.kva, this.kvf, this.kvZ, this.kuW, this.mForumName, this.kwJ);
                this.kvc.U(this.kwU);
                cQe();
            } else {
                this.kwv = false;
                this.kuW.rU(this.kwv);
                if (this.kvc != null) {
                    this.kvc.c(this.kva);
                }
            }
            if (this.kjZ.cMD() != null) {
                this.kjZ.cMD().te(this.kwv);
            }
            if (b != null) {
                this.kvV = b;
                this.kvf.setVisibility(0);
                SparseArray<Object> cRb = this.kvf.cRb();
                cRb.put(R.id.tag_clip_board, b);
                cRb.put(R.id.tag_is_subpb, false);
                this.kvg.a(fVar, this.kva);
                this.kve.A(fVar);
                this.kvd.e(fVar, this.kkO);
                this.kvd.z(fVar);
                this.kvf.a(this.mSkinType, this.klg, b, this.kwU);
                if (this.kwc != null) {
                    if (fVar.cLa()) {
                        this.kwc.getView().setVisibility(8);
                    } else {
                        this.kwc.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kiE);
                        if (fVar.cKx() != null) {
                            nVar.kiG = fVar.cKx().aWc();
                        }
                        nVar.isNew = !this.kkO;
                        nVar.sortType = fVar.khn;
                        nVar.kiI = fVar.cLb();
                        nVar.kiJ = this.kjZ.cNn();
                        nVar.kiK = fVar.khm;
                        this.kwc.a(nVar);
                    }
                }
                if (fVar != null && fVar.cKx() != null) {
                    al(fVar.cKx().aWh() == 1, fVar.cKx().aWg() == 1);
                }
                com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.17
                    @Override // java.lang.Runnable
                    public void run() {
                        if (az.this.kvl != null && az.this.kuW != null && az.this.kuW.kBm != null && az.this.klg != null && az.this.klg.cKx() != null && !az.this.klg.cKx().aUR() && !az.this.cQi() && az.this.klg.getForum() != null && !com.baidu.tbadk.core.util.as.isEmpty(az.this.klg.getForum().getName())) {
                            if ((az.this.kvl.cMr() == null || !az.this.kvl.cMr().isShown()) && az.this.kuW.kBm != null) {
                                az.this.kuW.kBm.setVisibility(0);
                                if (az.this.kjZ != null && az.this.kjZ.cLP() != null) {
                                    com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c13400");
                                    apVar.dn("tid", az.this.kjZ.cLP().cNL());
                                    apVar.dn("fid", az.this.kjZ.cLP().getForumId());
                                    apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(apVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void sO(boolean z) {
        if (z) {
            cQb();
        } else {
            bVC();
        }
        this.kwg.kxl = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kwg));
        a(this.kwg.kxl, false);
    }

    public void cQb() {
        if (this.kuW != null && !this.kwx) {
            this.kuW.cQb();
            this.kwx = true;
        }
    }

    public void bVC() {
        if (this.kuW != null) {
            this.kuW.cRz();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.kvf.a(postData, fVar);
    }

    public void cQc() {
        if (this.kvc != null) {
            this.kvc.d(this.kva);
        }
    }

    public boolean cQd() {
        return this.aSJ;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aI(bv bvVar) {
        if (bvVar == null || bvVar.aWl() == null) {
            return false;
        }
        PostData b = b(this.klg, false);
        String str = "";
        if (b != null && b.aWl() != null) {
            str = b.aWl().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.kuW.cRx();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.kuW.IG(dVar.forumName);
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
            final String str2 = dVar.khe;
            this.kjZ.showNetRefreshView(this.bjP, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        com.baidu.tbadk.core.util.bd.baV().b(az.this.kjZ.getPageContext(), new String[]{str2});
                        az.this.kjZ.finish();
                        return;
                    }
                    az.this.kjZ.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable cPh;
        Parcelable cPh2;
        if (fVar != null && this.kva != null) {
            this.klg = fVar;
            this.mType = i;
            if (fVar.cKx() != null) {
                this.kwi = fVar.cKx().aVS();
                if (fVar.cKx().getAnchorLevel() != 0) {
                    this.aSJ = true;
                }
                this.kvD = aI(fVar.cKx());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.kvW = false;
            this.kkO = z;
            cPX();
            if (fVar.kho != null && fVar.kho.cLg()) {
                if (this.kvb == null) {
                    this.kvb = new PbThreadPostView(this.kjZ.getContext());
                    this.kva.addHeaderView(this.kvb, 1);
                    this.kvb.setData(fVar);
                    this.kvb.setChildOnClickLinstener(this.hIl);
                }
            } else if (this.kvb != null && this.kva != null) {
                this.kva.removeHeaderView(this.kvb);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.kwH == null) {
                this.kwH = new al(this.kjZ.getPageContext(), this.ihB);
            }
            this.kwH.KM(fVar.cKE());
            if (this.kjZ.cNd()) {
                if (this.kvp == null) {
                    this.kvp = new com.baidu.tieba.pb.view.d(this.kjZ.getPageContext());
                    this.kvp.createView();
                    this.kvp.setListPullRefreshListener(this.ejc);
                }
                this.kva.setPullRefresh(this.kvp);
                cQe();
                if (this.kvp != null) {
                    this.kvp.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().aVc() == 0 && z) {
                this.kva.setPullRefresh(null);
            } else {
                if (this.kvp == null) {
                    this.kvp = new com.baidu.tieba.pb.view.d(this.kjZ.getPageContext());
                    this.kvp.createView();
                    this.kvp.setListPullRefreshListener(this.ejc);
                }
                this.kva.setPullRefresh(this.kvp);
                cQe();
                if (this.kvp != null) {
                    this.kvp.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                bMt();
            }
            cQj();
            this.kvl.rX(this.kkO);
            this.kvl.rY(false);
            this.kvl.sc(i == 5);
            this.kvl.sd(i == 6);
            this.kvl.se(z2 && this.kwT && i != 2);
            this.kvl.a(fVar, false);
            this.kvl.notifyDataSetChanged();
            this.kvf.b(b(fVar, z), fVar.cLa());
            if (fVar.cKx() != null && fVar.cKx().aVW() != null && this.kuU != -1) {
                fVar.cKx().aVW().setIsLike(this.kuU);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.kva.setNextPage(this.hME);
                this.kuV = 2;
                bMt();
            } else {
                this.kvW = true;
                if (fVar.getPage().aVb() == 1) {
                    if (this.kvq == null) {
                        this.kvq = new com.baidu.tieba.pb.view.a(this.kjZ, this.kjZ);
                    }
                    this.kva.setNextPage(this.kvq);
                } else {
                    this.kva.setNextPage(this.hME);
                }
                this.kuV = 3;
            }
            ArrayList<PostData> cKz = fVar.cKz();
            if (fVar.getPage().aVb() == 0 || cKz == null || cKz.size() < fVar.getPage().aVa()) {
                if (com.baidu.tbadk.core.util.x.getCount(cKz) == 0 || (com.baidu.tbadk.core.util.x.getCount(cKz) == 1 && cKz.get(0) != null && cKz.get(0).dlh() == 1)) {
                    if (this.kwg == null || this.kwg.kxl == null || this.kwg.kxl.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.kwg.kxl.getView().getTop() < 0 ? this.kwg.kxl.getView().getHeight() : this.kwg.kxl.getView().getBottom();
                    }
                    if (this.kjZ.cNn()) {
                        this.hME.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.hME.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.kjZ.cMD() != null && !this.kjZ.cMD().cRl()) {
                        this.kjZ.cMD().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().aVb() == 0) {
                        this.hME.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.hME.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.hME.bca();
                }
                if (fVar.getPage().aVb() == 0 || cKz == null) {
                    cQt();
                }
            } else {
                if (z2) {
                    if (this.kwT) {
                        endLoadData();
                        if (fVar.getPage().aVb() != 0) {
                            this.hME.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.hME.setLineVisible();
                        this.hME.showLoading();
                    }
                } else {
                    this.hME.setLineVisible();
                    this.hME.showLoading();
                }
                this.hME.bca();
            }
            switch (i) {
                case 2:
                    this.kva.setSelection(i2 > 1 ? (((this.kva.getData() == null && fVar.cKz() == null) ? 0 : (this.kva.getData().size() - fVar.cKz().size()) + this.kva.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (cPh2 = as.cPg().cPh()) != null && !(cPh2 instanceof RecyclerView.SavedState)) {
                        this.kva.onRestoreInstanceState(cPh2);
                        if (com.baidu.tbadk.core.util.x.getCount(cKz) > 1 && fVar.getPage().aVb() > 0) {
                            this.hME.endLoadData();
                            this.hME.setText(this.kjZ.getString(R.string.pb_load_more_without_point));
                            this.hME.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.kwT = false;
                    break;
                case 5:
                    this.kva.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (cPh = as.cPg().cPh()) != null && !(cPh instanceof RecyclerView.SavedState)) {
                        this.kva.onRestoreInstanceState(cPh);
                        break;
                    } else {
                        this.kva.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.kvc != null && this.kvc.bxk() != null) {
                            if (this.kjZ.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.kva.setSelectionFromTop((this.kvl.cMm() + this.kva.getHeaderViewsCount()) - 1, this.kvc.cRd() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.kjZ.getPageContext().getPageActivity()));
                            } else {
                                this.kva.setSelectionFromTop((this.kvl.cMm() + this.kva.getHeaderViewsCount()) - 1, this.kvc.cRd());
                            }
                        } else {
                            this.kva.setSelection(this.kvl.cMm() + this.kva.getHeaderViewsCount());
                        }
                    } else {
                        this.kva.setSelection(i2 > 0 ? ((this.kva.getData() == null && fVar.cKz() == null) ? 0 : (this.kva.getData().size() - fVar.cKz().size()) + this.kva.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.hME.endLoadData();
                    this.hME.setText(this.kjZ.getString(R.string.pb_load_more_without_point));
                    this.hME.setLineGone();
                    break;
            }
            if (this.kwi == kwj && isHost()) {
                cQB();
            }
            if (this.kwt) {
                cPu();
                this.kwt = false;
                if (i3 == 0) {
                    sH(true);
                }
            }
            if (fVar.khk == 1 || fVar.khl == 1) {
                if (this.kwz == null) {
                    this.kwz = new PbTopTipView(this.kjZ.getContext());
                }
                if (fVar.khl == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.kjZ.getStType())) {
                    this.kwz.setText(this.kjZ.getString(R.string.pb_read_strategy_add_experience));
                    this.kwz.a(this.bjP, this.mSkinType);
                } else if (fVar.khk == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.kjZ.getStType())) {
                    this.kwz.setText(this.kjZ.getString(R.string.pb_read_news_add_experience));
                    this.kwz.a(this.bjP, this.mSkinType);
                }
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cKx() != null) {
            x(fVar);
            if (fVar.aSj()) {
                SvgManager.baR().a(this.kvN, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.baR().a(this.kvN, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String Cc = Cc(fVar.cKx().aWc());
            if (this.kvQ != null) {
                this.kvQ.setText(Cc);
            }
            if (this.kvR != null) {
                this.kvR.setText(Cc);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.cKx()));
        }
    }

    private String Cc(int i) {
        if (i == 0) {
            return this.kjZ.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void cQe() {
        if (this.kvc != null) {
            this.kvc.a(this.kva, this.textView, this.mType);
        }
    }

    public void sP(boolean z) {
        this.kvC = z;
    }

    public void endLoadData() {
        if (this.hME != null) {
            this.hME.setLineGone();
            this.hME.endLoadData();
        }
        bMt();
    }

    public void bBY() {
        this.kva.setVisibility(0);
    }

    public void cQf() {
        if (this.kva != null) {
            this.kva.setVisibility(8);
        }
        if (this.kva != null) {
            this.kvZ.setVisibility(8);
        }
        if (this.kuW != null && this.kuW.kBl != null) {
            this.kuW.kBl.setVisibility(8);
        }
    }

    public void cQg() {
        if (this.kva != null) {
            this.kva.setVisibility(0);
        }
        if (this.kvZ != null) {
            this.kvZ.setVisibility(0);
        }
        if (this.kuW != null && this.kuW.kBl != null) {
            this.kuW.kBl.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.kvV != null && this.kvV.aWl() != null && this.kuW != null) {
            this.kww = !this.kwv;
            this.kuW.tg(this.kww);
            if (this.kjZ.cMD() != null) {
                this.kjZ.cMD().tf(this.kww);
            }
            cQh();
            if (this.kjZ != null && !this.kjZ.cLF() && !com.baidu.tbadk.core.util.x.isEmpty(fVar.cKU())) {
                br brVar = fVar.cKU().get(0);
                if (brVar != null) {
                    this.kuW.fd(brVar.getForumName(), brVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.kuW.fd(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.kww) {
                this.kvf.a(fVar, this.kvV, this.kvD);
                if (this.kwb != null) {
                    this.kwb.setVisibility(8);
                }
                if (this.kwF == null) {
                    this.kwF = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.az.19
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (az.this.kjZ != null && az.this.kjZ.isAdded()) {
                                if (i < 0 && f > az.this.kwy) {
                                    az.this.cQo();
                                    az.this.cQA();
                                }
                                az.this.cPY();
                            }
                        }
                    };
                }
                this.kva.setListViewDragListener(this.kwF);
                return;
            }
            if (this.kwb != null) {
                this.kwb.setVisibility(0);
            }
            this.kvf.a(fVar, this.kvV, this.kvD);
            this.kwF = null;
            this.kva.setListViewDragListener(null);
        }
    }

    private void cQh() {
        this.kvf.a(this.klg, this.kvV, this.kww, this.kwv);
    }

    public boolean cQi() {
        return this.klg == null || this.klg.getForum() == null || "0".equals(this.klg.getForum().getId()) || "me0407".equals(this.klg.getForum().getName());
    }

    private boolean cQj() {
        return this.kvd.tb(this.kkO);
    }

    private boolean w(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.cKx() == null) {
            return false;
        }
        if (fVar.cKx().aWi() == 1 || fVar.cKx().getThreadType() == 33) {
            return true;
        }
        return !(fVar.cKx().aWk() == null || fVar.cKx().aWk().aYy() == 0) || fVar.cKx().aWg() == 1 || fVar.cKx().aWh() == 1 || fVar.cKx().aWZ() || fVar.cKx().aXt() || fVar.cKx().aXm() || fVar.cKx().aWw() != null || !com.baidu.tbadk.core.util.as.isEmpty(fVar.cKx().getCategory()) || fVar.cKx().aWo() || fVar.cKx().aWn();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.kve != null) {
                if (fVar.cKx() != null && fVar.cKx().aWz() == 0 && !fVar.cKx().aUR() && !this.kwM) {
                    if (fVar.cKx() != null) {
                        bv cKx = fVar.cKx();
                        cKx.w(true, w(fVar));
                        cKx.kZ(3);
                        cKx.wY("2");
                    }
                    if (fVar.cKx().aUT()) {
                        this.kvf.c(this.kva);
                        this.kve.c(this.kva);
                        this.kve.b(this.kva);
                        this.kvf.b(this.kva);
                        this.kvf.E(this.klg);
                        this.kve.B(fVar);
                    } else {
                        this.kvf.E(this.klg);
                        this.kve.D(fVar);
                    }
                } else if (fVar.cKx().aWz() == 1) {
                    if (fVar.cKx() != null) {
                        this.kve.c(this.kva);
                        this.kvf.E(this.klg);
                    }
                } else {
                    this.kve.c(this.kva);
                    this.kvf.E(this.klg);
                }
            }
            if (fVar.cKx() != null) {
                ak(fVar.cKx().aWh() == 1, fVar.cKx().aWg() == 1);
            }
            this.kkO = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            cQj();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.aa aaVar;
        StringBuilder sb = null;
        if (fVar != null && (b = b(fVar, z)) != null) {
            String userId = b.aWl().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cKM()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.aWl() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.aWl().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.aWl().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.aWl().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cKM()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<br> cKU = fVar.cKU();
                if (com.baidu.tbadk.core.util.x.getCount(cKU) > 0) {
                    sb = new StringBuilder();
                    for (br brVar : cKU) {
                        if (brVar != null && !StringUtils.isNull(brVar.getForumName()) && (aaVar = brVar.dRa) != null && aaVar.dON && !aaVar.dOO && (aaVar.type == 1 || aaVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(brVar.getForumName(), 12)).append(this.kjZ.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.kjZ.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View cQk() {
        return this.eGt;
    }

    public boolean cQl() {
        if (this.bkz == null || this.bkz.getParent() == null || this.hME.isLoading()) {
            return false;
        }
        int bottom = this.bkz.getBottom();
        Rect rect = new Rect();
        this.bkz.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void KO(String str) {
        if (this.hME != null) {
            this.hME.setText(str);
        }
    }

    public void KP(String str) {
        if (this.hME != null) {
            int i = 0;
            if (this.kwg != null && this.kwg.kxl != null && this.kwg.kxl.getView() != null) {
                i = this.kwg.kxl.getView().getTop() < 0 ? this.kwg.kxl.getView().getHeight() : this.kwg.kxl.getView().getBottom();
            }
            this.hME.al(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.kva;
    }

    public int cQm() {
        return R.id.richText;
    }

    public TextView cLZ() {
        return this.kvf.cLZ();
    }

    public void d(BdListView.e eVar) {
        this.kva.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.ejc = cVar;
        if (this.kvp != null) {
            this.kvp.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.au auVar, a.b bVar) {
        if (auVar != null) {
            int aUZ = auVar.aUZ();
            int aUW = auVar.aUW();
            if (this.kvm != null) {
                this.kvm.aYL();
            } else {
                this.kvm = new com.baidu.tbadk.core.dialog.a(this.kjZ.getPageContext().getPageActivity());
                this.kvn = LayoutInflater.from(this.kjZ.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.kvm.aV(this.kvn);
                this.kvm.a(R.string.dialog_ok, bVar);
                this.kvm.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        az.this.cQo();
                        aVar.dismiss();
                    }
                });
                this.kvm.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.az.21
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (az.this.kwq == null) {
                            az.this.kwq = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.21.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    az.this.kjZ.HidenSoftKeyPad((InputMethodManager) az.this.kjZ.getBaseFragmentActivity().getSystemService("input_method"), az.this.bjP);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.lt().postDelayed(az.this.kwq, 150L);
                    }
                });
                this.kvm.b(this.kjZ.getPageContext()).aYL();
            }
            this.kvo = (EditText) this.kvn.findViewById(R.id.input_page_number);
            this.kvo.setText("");
            TextView textView = (TextView) this.kvn.findViewById(R.id.current_page_number);
            if (aUZ <= 0) {
                aUZ = 1;
            }
            if (aUW <= 0) {
                aUW = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(aUZ), Integer.valueOf(aUW)));
            this.kjZ.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.kvo, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.kva.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.kjZ.showToast(str);
    }

    public boolean sQ(boolean z) {
        if (this.ZS == null || !this.ZS.biL()) {
            return false;
        }
        this.ZS.bhl();
        return true;
    }

    public void cQn() {
        if (this.kwV != null) {
            while (this.kwV.size() > 0) {
                TbImageView remove = this.kwV.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        cQn();
        this.kvl.BD(1);
        if (this.kvc != null) {
            this.kvc.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.kvl.BD(2);
        if (this.kvc != null) {
            this.kvc.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.kjZ.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.kjZ.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.kvP != null) {
            this.kvP.onDestroy();
        }
        if (this.kws != null) {
            this.kws.destroy();
        }
        if (this.kwH != null) {
            this.kwH.onDestory();
        }
        if (this.kwz != null) {
            this.kwz.hide();
        }
        this.kjZ.hideProgressBar();
        if (this.fqQ != null && this.hCK != null) {
            this.fqQ.b(this.hCK);
        }
        cQo();
        endLoadData();
        if (this.kwq != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kwq);
        }
        if (this.kvY != null) {
            this.kvY.clearStatus();
        }
        this.kwP = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.kvl.BD(3);
        if (this.biX != null) {
            this.biX.setBackgroundDrawable(null);
        }
        if (this.kvc != null) {
            this.kvc.destroy();
        }
        if (this.kvl != null) {
            this.kvl.onDestroy();
        }
        this.kva.setOnLayoutListener(null);
        if (this.kwD != null) {
            this.kwD.ceq();
        }
        if (this.kwh != null) {
            this.kwh.onDestroy();
        }
        if (this.kvf != null) {
            this.kvf.onDestroy();
        }
    }

    public boolean Cd(int i) {
        if (this.kvc != null) {
            return this.kvc.Cd(i);
        }
        return false;
    }

    public void cQo() {
        this.kuW.aIX();
        if (this.kvf != null) {
            this.kvf.cQo();
        }
        if (this.kjZ != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.kjZ.getContext(), this.kvo);
        }
        cPw();
        if (this.kok != null) {
            this.kok.dismiss();
        }
        cQq();
        if (this.kvm != null) {
            this.kvm.dismiss();
        }
        if (this.hIk != null) {
            this.hIk.dismiss();
        }
    }

    public void cQp() {
        this.kuW.aIX();
        if (this.kvf != null) {
            this.kvf.cQo();
        }
        if (this.kok != null) {
            this.kok.dismiss();
        }
        cQq();
        if (this.kvm != null) {
            this.kvm.dismiss();
        }
        if (this.hIk != null) {
            this.hIk.dismiss();
        }
    }

    public void eu(List<String> list) {
        this.kwC = list;
        if (this.kwD != null) {
            this.kwD.setData(list);
        }
    }

    public void rW(boolean z) {
        this.kvl.rW(z);
    }

    public void sR(boolean z) {
        this.kvF = z;
    }

    public void cQq() {
        if (this.kvt != null) {
            this.kvt.dismiss();
        }
        if (this.kvu != null) {
            com.baidu.adp.lib.f.g.b(this.kvu, this.kjZ.getPageContext());
        }
        if (this.kvv != null) {
            com.baidu.adp.lib.f.g.b(this.kvv, this.kjZ.getPageContext());
        }
        if (this.kvs != null) {
            this.kvs.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.klg, this.kkO);
            b(this.klg, this.kkO, this.mType, i);
            this.kjZ.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.kjZ.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bjP);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.bjP, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.ao.setBackgroundResource(this.kvG, R.drawable.personalize_tab_shadow);
            if (this.kvc != null) {
                this.kvc.onChangeSkinType(i);
            }
            if (this.kvg != null) {
                this.kvg.onChangeSkinType(i);
            }
            if (this.kvd != null) {
                this.kvd.onChangeSkinType(i);
            }
            if (this.kve != null) {
                this.kve.onChangeSkinType(i);
            }
            if (this.kvf != null) {
                this.kvf.onChangeSkinType(i);
            }
            if (this.hME != null) {
                this.hME.changeSkin(i);
                if (this.eGt != null) {
                    this.kjZ.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.eGt);
                    com.baidu.tbadk.core.util.ao.setBackgroundResource(this.eGt, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.kvm != null) {
                this.kvm.c(this.kjZ.getPageContext());
            }
            sP(this.kvC);
            this.kvl.notifyDataSetChanged();
            if (this.kvp != null) {
                this.kvp.changeSkin(i);
            }
            if (this.ZS != null) {
                this.ZS.onChangeSkinType(i);
            }
            if (this.kvq != null) {
                this.kvq.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.gZh)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.gZh) {
                    customBlueCheckRadioButton.bbN();
                }
            }
            cPN();
            UtilHelper.setStatusBarBackground(this.biX, i);
            UtilHelper.setStatusBarBackground(this.kwb, i);
            if (this.kvh != null) {
                com.baidu.tbadk.r.a.a(this.kjZ.getPageContext(), this.kvh);
            }
            if (this.kwr != null) {
                this.kwr.onChangeSkinType(i);
            }
            if (this.kuW != null) {
                if (this.kvc != null) {
                    this.kvc.Ce(i);
                } else {
                    this.kuW.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.iEU != null) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.iEU, R.color.cp_cont_d);
            }
            if (this.kvL != null) {
                this.kvL.setBorderColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_border_a));
            }
            if (this.kvK != null) {
                this.kvK.setBackgroundDrawable(com.baidu.tbadk.core.util.ao.aH(com.baidu.adp.lib.util.l.getDimens(this.kjZ.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ao.getColor(R.color.cp_bg_line_j)));
            }
            if (this.kvN != null && this.klg != null) {
                if (this.klg.aSj()) {
                    SvgManager.baR().a(this.kvN, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.baR().a(this.kvN, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            x(this.klg);
            if (this.kvM != null) {
                SvgManager.baR().a(this.kvM, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.kvI != null) {
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.kvI, R.drawable.bottom_shadow);
            }
            if (this.kvQ != null) {
                com.baidu.tbadk.core.util.ao.c(this.kvQ, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_cont_h, R.color.cp_cont_h);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kvQ, R.color.cp_cont_a);
            }
            if (this.kvR != null) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kvR, R.color.cp_cont_b);
            }
            if (this.kwE != null) {
                this.kwE.onChangeSkinType(i);
            }
            if (this.kwh != null) {
                this.kwh.onChangeSkinType();
            }
            if (this.kwB != null) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kwB, R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kvJ, R.color.cp_bg_line_h);
            if (this.kvb != null) {
                this.kvb.qZ(i);
            }
            if (this.kvP != null) {
                this.kvP.onChangeSkinType();
            }
        }
    }

    public void cQr() {
        if (this.kvP != null) {
            this.kvP.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.aX(fVar.cKx())) {
            if (this.kvP != null) {
                this.kvP.setEnable(false);
                this.kvP.onDestroy();
            }
            SvgManager.baR().a(this.kvO, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.kvP == null || !this.kvP.isEnable()) {
            SvgManager.baR().a(this.kvO, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eRR = iVar;
        this.kvl.setOnImageClickListener(this.eRR);
        this.kwE.setOnImageClickListener(this.eRR);
    }

    public void g(NoNetworkView.a aVar) {
        this.hCK = aVar;
        if (this.fqQ != null) {
            this.fqQ.a(this.hCK);
        }
    }

    public void sS(boolean z) {
        this.kvl.setIsFromCDN(z);
    }

    public Button cQs() {
        return this.kvH;
    }

    public void cQt() {
        if (this.kuV != 2) {
            this.kva.setNextPage(this.hME);
            this.kuV = 2;
        }
    }

    public void cQu() {
        if (com.baidu.tbadk.n.m.blA().blB()) {
            int lastVisiblePosition = this.kva.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.kva.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.eHc = true;
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
                        perfLog2.eHc = true;
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

    public boolean cQv() {
        return this.ZS != null && this.ZS.getVisibility() == 0;
    }

    public boolean cQw() {
        return this.ZS != null && this.ZS.biL();
    }

    public void cQx() {
        if (this.ZS != null) {
            this.ZS.bhl();
        }
    }

    public void sT(boolean z) {
        if (this.kvJ != null) {
            sR(this.kjZ.cMA().bjs());
            if (this.kvF) {
                sI(z);
            } else {
                sJ(z);
            }
        }
    }

    public void cQy() {
        if (this.kvJ != null) {
            this.kvI.setVisibility(8);
            this.kvJ.setVisibility(8);
            this.kvS = false;
            if (this.kwh != null) {
                this.kwh.setVisibility(8);
                sN(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.hdc == null) {
            this.hdc = new com.baidu.tbadk.core.view.a(this.kjZ.getPageContext());
        }
        this.hdc.setDialogVisiable(true);
    }

    public void bMt() {
        if (this.hdc != null) {
            this.hdc.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.kva.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.kva.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.kvc != null) {
            this.kvc.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.kwW = getScrollY();
            this.kwg.kxl = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kwg));
            a(this.kwg.kxl, true);
        }
    }

    public void sU(boolean z) {
        if (this.kvc != null) {
            this.kvc.sU(z);
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
        if (this.kvc != null) {
            this.kvc.onScroll(absListView, i, i2, i3);
        }
        if (this.kuW != null && this.kvf != null) {
            this.kuW.cS(this.kvf.cQZ());
        }
        this.kwg.kaR = i;
        this.kwg.headerCount = this.kva.getHeaderViewsCount();
        this.kwg.kxl = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kwg));
        sK(b(absListView, i));
        a(this.kwg.kxl, false);
        if (this.hME.bcb() && !this.hME.eim) {
            if (this.kwg != null && this.kwg.kxl != null && this.kwg.kxl.getView() != null) {
                i4 = this.kwg.kxl.getView().getTop() < 0 ? this.kwg.kxl.getView().getHeight() : this.kwg.kxl.getView().getBottom();
            }
            this.hME.mJ(i4);
            this.hME.eim = true;
        }
    }

    public void cQz() {
        if (TbadkCoreApplication.isLogin() && this.klg != null && this.kww && !this.kwv && !this.kvD && this.kvV != null && this.kvV.aWl() != null && !this.kvV.aWl().getIsLike() && !this.kvV.aWl().hadConcerned() && this.kws == null) {
            this.kws = new av(this.kjZ);
        }
    }

    public void cQA() {
        if (this.kjZ != null) {
            if ((this.hFn || this.kwK == 17) && com.baidu.tbadk.a.d.aRR()) {
                if (this.klg != null && this.klg.getForum() != null && !com.baidu.tbadk.core.util.as.isEmpty(this.klg.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.kjZ.getContext()).createNormalCfg(this.klg.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13853").dn("post_id", this.klg.getThreadId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("fid", this.klg.getForum().getId()));
                }
            } else if (this.kww && !this.kwv && this.kvV != null && this.kvV.aWl() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12601").ah("obj_locate", this.kjZ.cLF() ? 2 : 1).ah("obj_type", this.kwv ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.kjZ.getPageContext().getPageActivity(), this.kvV.aWl().getUserId(), this.kvV.aWl().getUserName(), this.kjZ.cLP().cLG(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(au auVar, boolean z) {
        int measuredHeight;
        if (!this.kwv && this.kwa != null && this.kuW.cRr() != null) {
            int cMn = this.kvl.cMn();
            if (cMn > 0 && (auVar == null || auVar.getView().getParent() == null)) {
                if (cMn > this.kva.getFirstVisiblePosition() - this.kva.getHeaderViewsCount()) {
                    this.kwa.setVisibility(4);
                    return;
                }
                this.kwa.setVisibility(0);
                sK(false);
                this.kuW.mNavigationBar.hideBottomLine();
                if (this.kwa.getParent() != null && ((ViewGroup) this.kwa.getParent()).getHeight() <= this.kwa.getTop()) {
                    this.kwa.getParent().requestLayout();
                }
            } else if (auVar == null || auVar.getView() == null || auVar.kuv == null) {
                if (this.kva.getFirstVisiblePosition() == 0) {
                    this.kwa.setVisibility(4);
                    this.kuW.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = auVar.getView().getTop();
                if (auVar.getView().getParent() != null) {
                    if (this.kwf) {
                        this.kwe = top;
                        this.kwf = false;
                    }
                    this.kwe = top < this.kwe ? top : this.kwe;
                }
                if (top != 0 || auVar.getView().isShown()) {
                    if (this.kvk.getY() < 0.0f) {
                        measuredHeight = kwd - auVar.kuv.getMeasuredHeight();
                    } else {
                        measuredHeight = this.kuW.cRr().getMeasuredHeight() - auVar.kuv.getMeasuredHeight();
                        this.kuW.mNavigationBar.hideBottomLine();
                    }
                    if (auVar.getView().getParent() == null && top <= this.kwe) {
                        this.kwa.setVisibility(0);
                        sK(false);
                    } else if (top < measuredHeight) {
                        this.kwa.setVisibility(0);
                        sK(false);
                    } else {
                        this.kwa.setVisibility(4);
                        this.kuW.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.kwf = true;
                    }
                }
            }
        }
    }

    public void cQB() {
        if (!this.kwX) {
            TiebaStatic.log("c10490");
            this.kwX = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kjZ.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(kwk, Integer.valueOf(kwm));
            aVar.lm(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.kjZ.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aV(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.kjZ);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.23
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.kjZ.getPageContext()).aYL();
        }
    }

    public void KQ(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kjZ.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.kjZ.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aV(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(kwk, Integer.valueOf(kwn));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.kjZ);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kjZ.getPageContext()).aYL();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.aWl() != null) {
            MetaData aWl = b.aWl();
            aWl.setGiftNum(aWl.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        a(fVar, z, i, i2);
        this.kvf.onChangeSkinType(i2);
    }

    public PbInterviewStatusView cQC() {
        return this.kvY;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cKx() != null && fVar.cKx().aXt() && this.kvY == null) {
            this.kvY = (PbInterviewStatusView) this.kvX.inflate();
            this.kvY.setOnClickListener(this.hIl);
            this.kvY.setCallback(this.kjZ.cNl());
            this.kvY.setData(this.kjZ, fVar);
        }
    }

    public RelativeLayout cQD() {
        return this.kvk;
    }

    public View cQE() {
        return this.biX;
    }

    public boolean cQF() {
        return this.kwM;
    }

    public void sb(boolean z) {
        this.kvf.sb(z);
    }

    public void KR(String str) {
        if (this.kuX != null) {
            this.kuX.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int sV(boolean z) {
        if (this.kvY == null || this.kvY.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void cQG() {
        if (this.kvY != null && this.kvY.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kvY.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.kvY.setLayoutParams(layoutParams);
        }
    }

    public boolean cMG() {
        return false;
    }

    public void KS(String str) {
        this.iEU.performClick();
        if (!StringUtils.isNull(str) && this.kjZ.cMA() != null && this.kjZ.cMA().bjk() != null && this.kjZ.cMA().bjk().getInputView() != null) {
            EditText inputView = this.kjZ.cMA().bjk().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            cQo();
            if (configuration.orientation == 2) {
                cQy();
                cPw();
            } else {
                cPA();
            }
            if (this.kwr != null) {
                this.kwr.cMv();
            }
            this.kjZ.cbV();
            this.kvk.setVisibility(8);
            this.kuW.th(false);
            this.kjZ.sq(false);
            if (this.kvc != null) {
                if (configuration.orientation == 1) {
                    cQD().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.kva.setIsLandscape(true);
                    this.kva.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.kva.setIsLandscape(false);
                    if (this.kwW > 0) {
                        this.kva.smoothScrollBy(this.kwW, 0);
                    }
                }
                this.kvc.onConfigurationChanged(configuration);
                this.kvZ.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void sW(boolean z) {
        if (this.kvc != null) {
            this.kvc.sW(z);
        }
    }

    public boolean cQH() {
        return this.kvc != null && this.kvc.cQH();
    }

    public void cQI() {
        if (this.kvc != null) {
            this.kvc.cQI();
        }
    }

    public void sf(boolean z) {
        this.kvl.sf(z);
    }

    public void cQ(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.kvJ.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.kjZ.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.kwB = new TextView(this.kjZ.getContext());
            this.kwB.setText(R.string.connection_tips);
            this.kwB.setGravity(17);
            this.kwB.setPadding(com.baidu.adp.lib.util.l.getDimens(this.kjZ.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.kjZ.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.kjZ.getContext(), R.dimen.ds60);
            if (this.kwB.getParent() == null) {
                frameLayout.addView(this.kwB, layoutParams);
            }
            this.kwA = new PopupWindow(this.kjZ.getContext());
            this.kwA.setContentView(frameLayout);
            this.kwA.setHeight(-2);
            this.kwA.setWidth(-2);
            this.kwA.setFocusable(true);
            this.kwA.setOutsideTouchable(false);
            this.kwA.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.kva.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.25
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        az.this.kwA.showAsDropDown(az.this.kvJ, view.getLeft(), -az.this.kvJ.getHeight());
                    } else {
                        az.this.kwA.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void sX(boolean z) {
        this.kwG = z;
    }

    public boolean cQJ() {
        return this.kwG;
    }

    public PbThreadPostView cQK() {
        return this.kvb;
    }

    private void ak(boolean z, boolean z2) {
        al(z, z2);
        if (this.klg != null && this.klg.cKx() != null && this.klg.cKx().aWz() == 0 && !this.klg.cKx().aUR()) {
            am(z, z2);
        } else if (this.kvl != null && this.kvl.cMs() != null) {
            this.kvl.cMs().b(this.klg, z, z2);
        }
    }

    private void al(boolean z, boolean z2) {
        this.kvf.d(this.klg, z, z2);
    }

    private void am(boolean z, boolean z2) {
        this.kve.c(this.klg, z, z2);
    }

    public void sY(boolean z) {
        this.hFn = z;
    }

    public void BV(int i) {
        this.kwK = i;
    }

    public void cQL() {
        if (this.kva != null) {
            this.kva.setForbidDragListener(true);
        }
    }

    public boolean cNE() {
        if (this.kva == null) {
            return false;
        }
        return this.kva.cNE();
    }
}
