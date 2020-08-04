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
    private PbListView hMG;
    private TextView iEW;
    private NavigationBarCoverTip ihD;
    private com.baidu.tieba.NEGFeedBack.e ikW;
    private boolean isLandscape;
    private View.OnClickListener kkY;
    private PbFragment kkb;
    private com.baidu.tieba.pb.data.f kli;
    private PbFakeFloorModel knz;
    PbFragment.c kpm;
    public int kuW;
    public final com.baidu.tieba.pb.pb.main.view.c kuY;
    public com.baidu.tieba.pb.pb.main.view.b kuZ;
    private View kvI;
    private View kvK;
    private View kvL;
    private LinearLayout kvM;
    private HeadImageView kvN;
    private ImageView kvO;
    private ImageView kvP;
    private ImageView kvQ;
    private com.baidu.tieba.pb.view.c kvR;
    private TextView kvS;
    private TextView kvT;
    private int kvV;
    private int kvW;
    private PostData kvX;
    private ViewStub kvZ;
    private ViewStub kva;
    private ViewStub kvb;
    private PbLandscapeListView kvc;
    private PbThreadPostView kvd;
    private com.baidu.tieba.pb.pb.main.a.e kve;
    private com.baidu.tieba.pb.pb.main.a.a kvf;
    private com.baidu.tieba.pb.pb.main.a.c kvg;
    private com.baidu.tieba.pb.pb.main.a.d kvh;
    private com.baidu.tieba.pb.pb.main.a.b kvi;
    private LinearLayout kvj;
    private TextView kvk;
    private TextView kvl;
    private ObservedChangeRelativeLayout kvm;
    private g kvn;
    private View kvt;
    private int kwA;
    private PbTopTipView kwB;
    private PopupWindow kwC;
    private TextView kwD;
    private List<String> kwE;
    private com.baidu.tieba.pb.pb.main.emotion.c kwF;
    private com.baidu.tieba.pb.pb.godreply.a kwG;
    private PbLandscapeListView.b kwH;
    private al kwJ;
    private String kwK;
    private long kwL;
    private int kwM;
    private boolean kwO;
    private Runnable kwS;
    private PbFragment.b kwU;
    public int kwY;
    private PbInterviewStatusView kwa;
    private FrameLayout kwb;
    private View kwc;
    private View kwd;
    private au kwe;
    private PbEmotionBar kwj;
    private int kwr;
    private Runnable kws;
    private v kwt;
    private av kwu;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int kwf = UtilHelper.getLightStatusBarHeight();
    public static int kwl = 3;
    public static int kwm = 0;
    public static int kwn = 3;
    public static int kwo = 4;
    public static int kwp = 5;
    public static int kwq = 6;
    private static a.InterfaceC0753a kwN = new a.InterfaceC0753a() { // from class: com.baidu.tieba.pb.pb.main.az.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0753a
        public void onRefresh() {
        }
    };
    private int kuX = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a kvo = null;
    private com.baidu.tbadk.core.dialog.b hIk = null;
    private View kvp = null;
    private EditText kvq = null;
    private com.baidu.tieba.pb.view.d kvr = null;
    private com.baidu.tieba.pb.view.a kvs = null;
    private b.InterfaceC0492b jdL = null;
    private TbRichTextView.i eRR = null;
    private NoNetworkView.a hCK = null;
    private com.baidu.tbadk.core.dialog.i kvu = null;
    private com.baidu.tbadk.core.dialog.a kvv = null;
    private Dialog kvw = null;
    private Dialog kvx = null;
    private View kvy = null;
    private LinearLayout kvz = null;
    private CompoundButton.OnCheckedChangeListener gZi = null;
    private TextView kvA = null;
    private TextView kvB = null;
    private String kvC = null;
    private com.baidu.tbadk.core.dialog.i kom = null;
    private com.baidu.tbadk.core.dialog.i kvD = null;
    private boolean kvE = false;
    private boolean kvF = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView kvG = null;
    private boolean kvH = false;
    private Button kvJ = null;
    private boolean kvU = true;
    private com.baidu.tbadk.core.view.a hdc = null;
    private boolean kkQ = false;
    private int mSkinType = 3;
    private boolean kvY = false;
    private int kwg = 0;
    private boolean kwh = true;
    public a kwi = new a();
    private int kwk = 0;
    private boolean kwv = false;
    private int kww = 0;
    private boolean kwx = false;
    private boolean kwy = false;
    private boolean kwz = false;
    private boolean kwI = false;
    private String kwP = null;
    private CustomMessageListener kwQ = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.az.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                az.this.kwP = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.az.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && az.this.kvn != null) {
                az.this.kvn.notifyDataSetChanged();
            }
        }
    };
    private Handler kwR = new Handler();
    private CustomMessageListener kwT = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.az.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                az.this.kvU = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean kwV = true;
    View.OnClickListener kwW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || az.this.kli == null || az.this.kli.cKx() == null || az.this.kli.cKx().aWl() == null || az.this.kli.cKx().aWl().getAlaInfo() == null || az.this.kli.cKx().aWl().getAlaInfo().live_status != 1) {
                if (az.this.kwx) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11923").ah("obj_id", 2));
                }
                if (!az.this.kwx && az.this.kli != null && az.this.kli.cKx() != null && az.this.kli.cKx().aWl() != null && az.this.kli.cKx().aWl().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12151").ah("obj_locate", 1));
                }
                if (az.this.kkb.cNt() != null) {
                    az.this.kkb.cNt().kkn.hps.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c11851");
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(apVar);
            if (az.this.kli.cKx().aWl().getAlaInfo() == null || !az.this.kli.cKx().aWl().getAlaInfo().isChushou) {
                if (az.this.kli.cKx().aWl().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = az.this.kli.cKx().aWl().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(az.this.kkb.cNt(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.bd.baV().b(az.this.kkb.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + az.this.kli.cKx().aWl().getAlaInfo().thirdRoomId + "&livetype=" + az.this.kli.cKx().aWl().getAlaInfo().thirdLiveType});
        }
    };
    private boolean aSJ = false;
    String userId = null;
    private final List<TbImageView> kwX = new ArrayList();
    private boolean kwZ = false;

    /* loaded from: classes16.dex */
    public static class a {
        public int headerCount;
        public int kaT;
        public au kxn;
    }

    public void sH(boolean z) {
        this.kwv = z;
        if (this.kvc != null) {
            this.kww = this.kvc.getHeaderViewsCount();
        }
    }

    public void cPu() {
        if (this.kvc != null) {
            int headerViewsCount = this.kvc.getHeaderViewsCount() - this.kww;
            final int firstVisiblePosition = (this.kvc.getFirstVisiblePosition() == 0 || this.kvc.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.kvc.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.kvc.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.kwi.kxn = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kwi));
            final au auVar = this.kwi.kxn;
            final int g = g(auVar);
            final int y = ((int) this.kvm.getY()) + this.kvm.getMeasuredHeight();
            final boolean z = this.kwc.getVisibility() == 0;
            boolean z2 = this.kvm.getY() < 0.0f;
            if ((z && auVar != null) || firstVisiblePosition >= this.kvn.cMn() + this.kvc.getHeaderViewsCount()) {
                int measuredHeight = auVar != null ? auVar.kux.getMeasuredHeight() : 0;
                if (z2) {
                    this.kvc.setSelectionFromTop(this.kvn.cMn() + this.kvc.getHeaderViewsCount(), kwf - measuredHeight);
                } else {
                    this.kvc.setSelectionFromTop(this.kvn.cMn() + this.kvc.getHeaderViewsCount(), this.kuY.cRr().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.kvc.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.kwx && this.kve != null) {
                this.kvc.setSelectionFromTop(this.kvn.cMn() + this.kvc.getHeaderViewsCount(), this.kve.cRd());
            } else if (this.mType == 6) {
                this.kvc.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.az.1
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
                                    layoutParams.height = az.this.kwr;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > az.this.bjP.getMeasuredHeight()) {
                                    layoutParams.height = az.this.kwr;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    az.this.kvc.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                az.this.bkz.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (az.this.bkz != null && az.this.bkz.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = az.this.bkz.getLayoutParams();
                                            layoutParams2.height = az.this.kwr;
                                            az.this.bkz.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        az.this.kvc.setOnLayoutListener(null);
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
            if (this.kwF != null) {
                this.kwF.cRf();
            }
        }
    }

    public PbFakeFloorModel cPx() {
        return this.knz;
    }

    public v cPy() {
        return this.kwt;
    }

    public com.baidu.tieba.pb.pb.main.a.e cPz() {
        return this.kve;
    }

    public void cPA() {
        reset();
        cPw();
        this.kwt.cMv();
        sT(false);
    }

    private void reset() {
        if (this.kkb != null && this.kkb.cMA() != null && this.ZS != null) {
            com.baidu.tbadk.editortools.pb.a.bjh().setStatus(0);
            com.baidu.tbadk.editortools.pb.e cMA = this.kkb.cMA();
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
        return this.kvU;
    }

    public void sI(boolean z) {
        if (this.kvL != null && this.iEW != null) {
            this.iEW.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kvL.startAnimation(alphaAnimation);
            }
            this.kvK.setVisibility(0);
            this.kvL.setVisibility(0);
            this.kvU = true;
            if (this.kwj != null && !this.kwG.isActive()) {
                this.kwj.setVisibility(0);
                sN(true);
            }
        }
    }

    public void sJ(boolean z) {
        if (this.kvL != null && this.iEW != null) {
            this.iEW.setText(cPC());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kvL.startAnimation(alphaAnimation);
            }
            this.kvK.setVisibility(0);
            this.kvL.setVisibility(0);
            this.kvU = true;
            if (this.kwj != null && !this.kwG.isActive()) {
                this.kwj.setVisibility(0);
                sN(true);
            }
        }
    }

    public String cPC() {
        if (!com.baidu.tbadk.core.util.as.isEmpty(this.kwK)) {
            return this.kwK;
        }
        if (this.kkb != null) {
            this.kwK = TbadkCoreApplication.getInst().getResources().getString(ay.cPr());
        }
        return this.kwK;
    }

    public PostData cPD() {
        int i = 0;
        if (this.kvc == null) {
            return null;
        }
        int cPE = cPE() - this.kvc.getHeaderViewsCount();
        if (cPE < 0) {
            cPE = 0;
        }
        if (this.kvn.BC(cPE) != null && this.kvn.BC(cPE) != PostData.lNc) {
            i = cPE + 1;
        }
        return this.kvn.getItem(i) instanceof PostData ? (PostData) this.kvn.getItem(i) : null;
    }

    public int cPE() {
        int i;
        View childAt;
        if (this.kvc == null) {
            return 0;
        }
        int firstVisiblePosition = this.kvc.getFirstVisiblePosition();
        int lastVisiblePosition = this.kvc.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.kvc.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.kvc.getChildAt(i3 - firstVisiblePosition)) != null) {
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
        return this.kvc.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.kli != null && this.kli.cKz() != null && !this.kli.cKz().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.kli.cKz().size() && (postData = this.kli.cKz().get(i)) != null && postData.aWl() != null && !StringUtils.isNull(postData.aWl().getUserId()); i++) {
                if (this.kli.cKz().get(i).aWl().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.kwG != null && this.kwG.isActive()) {
                        sT(false);
                    }
                    if (this.kwj != null) {
                        this.kwj.td(true);
                    }
                    this.kwP = postData.aWl().getName_show();
                    return;
                }
            }
        }
    }

    public az(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.kkb = null;
        this.bjP = null;
        this.biX = null;
        this.kvc = null;
        this.kvn = null;
        this.hMG = null;
        this.eGt = null;
        this.hIl = null;
        this.kkY = null;
        this.kvL = null;
        this.iEW = null;
        this.kvZ = null;
        this.kwA = 0;
        this.kwL = 0L;
        this.kwL = System.currentTimeMillis();
        this.kkb = pbFragment;
        this.hIl = onClickListener;
        this.euG = cVar;
        this.kwA = com.baidu.adp.lib.util.l.getEquipmentWidth(this.kkb.getContext()) / 10;
        this.bjP = (RelativeLayout) LayoutInflater.from(this.kkb.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bjP.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.kvI = this.bjP.findViewById(R.id.bottom_shadow);
        this.ihD = (NavigationBarCoverTip) this.bjP.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.biX = this.bjP.findViewById(R.id.statebar_view);
        this.kvm = (ObservedChangeRelativeLayout) this.bjP.findViewById(R.id.title_wrapper);
        this.fqQ = (NoNetworkView) this.bjP.findViewById(R.id.view_no_network);
        this.kvc = (PbLandscapeListView) this.bjP.findViewById(R.id.new_pb_list);
        this.kwb = (FrameLayout) this.bjP.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.kkb.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.kkb.getActivity(), R.dimen.ds88));
        this.kvc.addHeaderView(this.textView, 0);
        this.kvc.setTextViewAdded(true);
        this.kwr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bkz = new View(this.kkb.getPageContext().getPageActivity());
        this.bkz.setLayoutParams(new AbsListView.LayoutParams(-1, this.kwr));
        this.bkz.setVisibility(4);
        this.kvc.addFooterView(this.bkz);
        this.kvc.setOnTouchListener(this.kkb.eKY);
        this.kuY = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bjP);
        if (this.kkb.cNd()) {
            this.kva = (ViewStub) this.bjP.findViewById(R.id.manga_view_stub);
            this.kva.setVisibility(0);
            this.kuZ = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.kuZ.show();
            this.kuY.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.kkb.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.kuY.cRr().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0710a() { // from class: com.baidu.tieba.pb.pb.main.az.26
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0710a
            public void cLz() {
                if (az.this.kvc != null) {
                    if (az.this.kve != null) {
                        az.this.kve.cRc();
                    }
                    az.this.kvc.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0710a
            public void cLA() {
                az.this.kkb.cbV();
            }
        }));
        this.kvK = this.bjP.findViewById(R.id.view_comment_top_line);
        this.kvL = this.bjP.findViewById(R.id.pb_editor_tool_comment);
        this.kvV = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.kvW = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.kvN = (HeadImageView) this.bjP.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.kvN.setVisibility(0);
        this.kvN.setIsRound(true);
        this.kvN.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.kkb.getContext(), R.dimen.tbds1));
        this.kvN.setBorderColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_border_a));
        this.kvN.setPlaceHolder(1);
        this.kvN.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.kvN.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        this.iEW = (TextView) this.bjP.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.kvM = (LinearLayout) this.bjP.findViewById(R.id.pb_editer_tool_comment_layout);
        this.kvM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.kkb.cML();
                if (az.this.kkb != null && az.this.kkb.cLP() != null && az.this.kkb.cLP().getPbData() != null && az.this.kkb.cLP().getPbData().cKx() != null && az.this.kkb.cLP().getPbData().cKx().aWl() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13701").dn("tid", az.this.kkb.cLP().cNM()).dn("fid", az.this.kkb.cLP().getPbData().getForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13402").dn("tid", az.this.kkb.cLP().krf).dn("fid", az.this.kkb.cLP().getPbData().getForumId()).ah("obj_locate", 1).dn("uid", az.this.kkb.cLP().getPbData().cKx().aWl().getUserId()));
                }
            }
        });
        this.kvO = (ImageView) this.bjP.findViewById(R.id.pb_editor_tool_comment_icon);
        this.kvO.setOnClickListener(this.hIl);
        boolean booleanExtra = this.kkb.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.kvP = (ImageView) this.bjP.findViewById(R.id.pb_editor_tool_collection);
        this.kvP.setOnClickListener(this.hIl);
        if (booleanExtra) {
            this.kvP.setVisibility(8);
        } else {
            this.kvP.setVisibility(0);
        }
        this.kvQ = (ImageView) this.bjP.findViewById(R.id.pb_editor_tool_share);
        this.kvQ.setOnClickListener(this.hIl);
        this.kvR = new com.baidu.tieba.pb.view.c(this.kvQ);
        this.kvR.cUD();
        this.kvS = (TextView) this.bjP.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.kvS.setVisibility(0);
        this.kvZ = (ViewStub) this.bjP.findViewById(R.id.interview_status_stub);
        this.kvf = new com.baidu.tieba.pb.pb.main.a.a(this.kkb, cVar);
        this.kvh = new com.baidu.tieba.pb.pb.main.a.d(this.kkb, cVar, this.hIl);
        this.kvn = new g(this.kkb, this.kvc);
        this.kvn.E(this.hIl);
        this.kvn.setTbGestureDetector(this.euG);
        this.kvn.setOnImageClickListener(this.eRR);
        this.kvn.setOnSwitchChangeListener(this.kkb.kpg);
        this.kkY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.28
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
                            az.this.kkb.c(sparseArray);
                            return;
                        }
                        az.this.cP(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        az.this.kkb.c(sparseArray);
                    } else if (booleanValue3) {
                        az.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.kvn.R(this.kkY);
        cPK();
        cPL();
        this.kvh.b(this.kvc);
        this.kvg.b(this.kvc);
        this.kvf.b(this.kvc);
        this.hMG = new PbListView(this.kkb.getPageContext().getPageActivity());
        this.eGt = this.hMG.getView().findViewById(R.id.pb_more_view);
        if (this.eGt != null) {
            this.eGt.setOnClickListener(this.hIl);
            com.baidu.tbadk.core.util.ao.setBackgroundResource(this.eGt, R.drawable.pb_foot_more_trans_selector);
        }
        this.hMG.setLineVisible();
        this.hMG.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.hMG.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.kvt = this.bjP.findViewById(R.id.viewstub_progress);
        this.kkb.registerListener(this.kwT);
        this.knz = new PbFakeFloorModel(this.kkb.getPageContext());
        this.kwt = new v(this.kkb.getPageContext(), this.knz, this.bjP);
        this.kwt.S(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.cPA();
            }
        });
        this.kwt.a(this.kkb.kph);
        this.knz.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.az.30
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                az.this.knz.t(postData);
                az.this.kvn.notifyDataSetChanged();
                az.this.kwt.cMv();
                az.this.ZS.bhl();
                az.this.sT(false);
            }
        });
        if (this.kkb.cLP() != null && !StringUtils.isNull(this.kkb.cLP().cOu())) {
            this.kkb.showToast(this.kkb.cLP().cOu());
        }
        this.kwc = this.bjP.findViewById(R.id.pb_expand_blank_view);
        this.kwd = this.bjP.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kwd.getLayoutParams();
        if (this.kkb.cLP() != null && this.kkb.cLP().cNP()) {
            this.kwc.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.kwd.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = kwf;
            this.kwd.setLayoutParams(layoutParams2);
        }
        this.kwe = new au(this.kkb.getPageContext(), this.bjP.findViewById(R.id.pb_reply_expand_view));
        this.kwe.w(pbFragment.koc);
        this.kwe.kux.setVisibility(8);
        this.kwe.T(this.hIl);
        this.kwe.setOnSwitchChangeListener(this.kkb.kpg);
        this.kkb.registerListener(this.mAccountChangedListener);
        this.kkb.registerListener(this.kwQ);
        cPG();
        sN(false);
    }

    public void sK(boolean z) {
        this.kvI.setVisibility(z ? 0 : 8);
    }

    public void cok() {
        if (!this.kkb.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10517").ah("obj_locate", 2).dn("fid", this.mForumId));
        } else if (this.kkb.cMN()) {
            com.baidu.tbadk.editortools.pb.e cMA = this.kkb.cMA();
            if (cMA != null && (cMA.bjz() || cMA.bjA())) {
                this.kkb.cMA().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.ZS != null) {
                cPQ();
            }
            if (this.ZS != null) {
                this.kvU = false;
                if (this.ZS.nT(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.kkb.getPageContext(), (View) this.ZS.nT(2).ezZ, false, kwN);
                }
            }
            cQy();
        }
    }

    private void cPG() {
        this.kwG = new com.baidu.tieba.pb.pb.godreply.a(this.kkb, this, (ViewStub) this.bjP.findViewById(R.id.more_god_reply_popup));
        this.kwG.z(this.hIl);
        this.kwG.R(this.kkY);
        this.kwG.setOnImageClickListener(this.eRR);
        this.kwG.z(this.hIl);
        this.kwG.setTbGestureDetector(this.euG);
    }

    public com.baidu.tieba.pb.pb.godreply.a cPH() {
        return this.kwG;
    }

    public View cPI() {
        return this.kwc;
    }

    public void cPJ() {
        if (this.kvc != null) {
            this.kvg.c(this.kvc);
            this.kvh.c(this.kvc);
            this.kvi.c(this.kvc);
            this.kvf.c(this.kvc);
        }
    }

    private void cPK() {
        if (this.kvi == null) {
            this.kvi = new com.baidu.tieba.pb.pb.main.a.b(this.kkb, this.hIl);
        }
    }

    private void cPL() {
        if (this.kvg == null) {
            this.kvg = new com.baidu.tieba.pb.pb.main.a.c(this.kkb, this.euG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPM() {
        if (this.kkb.cNd()) {
            this.kvb = (ViewStub) this.bjP.findViewById(R.id.manga_mention_controller_view_stub);
            this.kvb.setVisibility(0);
            if (this.kvj == null) {
                this.kvj = (LinearLayout) this.bjP.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.kkb.getPageContext(), this.kvj);
            }
            if (this.kvk == null) {
                this.kvk = (TextView) this.kvj.findViewById(R.id.manga_prev_btn);
            }
            if (this.kvl == null) {
                this.kvl = (TextView) this.kvj.findViewById(R.id.manga_next_btn);
            }
            this.kvk.setOnClickListener(this.hIl);
            this.kvl.setOnClickListener(this.hIl);
        }
    }

    private void cPN() {
        if (this.kkb.cNd()) {
            if (this.kkb.cNg() == -1) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kvk, R.color.cp_cont_e, 1);
            }
            if (this.kkb.cNh() == -1) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kvl, R.color.cp_cont_e, 1);
            }
        }
    }

    public void cPO() {
        if (this.kvj == null) {
            cPM();
        }
        this.kvb.setVisibility(8);
        if (this.kwR != null && this.kwS != null) {
            this.kwR.removeCallbacks(this.kwS);
        }
    }

    public void cPP() {
        if (this.kwR != null) {
            if (this.kwS != null) {
                this.kwR.removeCallbacks(this.kwS);
            }
            this.kwS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.3
                @Override // java.lang.Runnable
                public void run() {
                    if (az.this.kvj == null) {
                        az.this.cPM();
                    }
                    az.this.kvb.setVisibility(0);
                }
            };
            this.kwR.postDelayed(this.kwS, 2000L);
        }
    }

    public void sL(boolean z) {
        this.kuY.sL(z);
        if (z && this.kvY) {
            this.hMG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.kvc.setNextPage(this.hMG);
            this.kuX = 2;
        }
        if (this.kvN != null) {
            this.kvN.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
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
                        az.this.mPermissionJudgePolicy.appendRequestPermission(az.this.kkb.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!az.this.mPermissionJudgePolicy.startRequestPermission(az.this.kkb.getBaseFragmentActivity())) {
                            az.this.kkb.cMA().c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            az.this.kkb.cMA().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cPw();
        this.kkb.cMA().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.az.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (az.this.ZS != null && az.this.ZS.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (az.this.kwF == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, az.this.ZS.getId());
                            az.this.kwF = new com.baidu.tieba.pb.pb.main.emotion.c(az.this.kkb.getPageContext(), az.this.bjP, layoutParams2);
                            if (!com.baidu.tbadk.core.util.x.isEmpty(az.this.kwE)) {
                                az.this.kwF.setData(az.this.kwE);
                            }
                            az.this.kwF.c(az.this.ZS);
                        }
                        az.this.kwF.KW(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (az.this.kkb.kol != null && az.this.kkb.kol.cQO() != null) {
                    if (!az.this.kkb.kol.cQO().duc()) {
                        az.this.kkb.kol.sZ(false);
                    }
                    az.this.kkb.kol.cQO().wj(false);
                }
            }
        });
    }

    public void cPQ() {
        if (this.kkb != null && this.ZS != null) {
            this.ZS.display();
            if (this.kkb.cMA() != null) {
                this.kkb.cMA().bjp();
            }
            cQy();
        }
    }

    public void sM(boolean z) {
        if (this.kvc != null && this.textView != null && this.biX != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.biX.setVisibility(0);
                } else {
                    this.biX.setVisibility(8);
                    this.kvc.removeHeaderView(this.textView);
                    this.kvc.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = kwf;
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
        return this.kvn;
    }

    public void a(PbFragment.c cVar) {
        this.kpm = cVar;
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
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kkb.getContext());
        kVar.setTitleText(this.kkb.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.kvu.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            az.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (az.this.kwU != null) {
                                az.this.kwU.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            az.this.kkb.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.kkb.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.kkb.getString(R.string.delete), kVar);
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
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.kkb.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.kkb.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.kkb.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aS(arrayList);
        if (this.kvu == null) {
            this.kvu = new com.baidu.tbadk.core.dialog.i(this.kkb.getPageContext(), kVar);
        } else {
            this.kvu.a(kVar);
        }
        this.kvu.showDialog();
    }

    public void a(PbFragment.b bVar) {
        this.kwU = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.kkb != null && aVar != null) {
            if (this.ikW == null && this.kvf != null) {
                this.ikW = new com.baidu.tieba.NEGFeedBack.e(this.kkb.getPageContext(), this.kvf.cQY());
            }
            AntiData cax = this.kkb.cax();
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
            this.ikW.setDefaultReasonArray(new String[]{this.kkb.getString(R.string.delete_thread_reason_1), this.kkb.getString(R.string.delete_thread_reason_2), this.kkb.getString(R.string.delete_thread_reason_3), this.kkb.getString(R.string.delete_thread_reason_4), this.kkb.getString(R.string.delete_thread_reason_5)});
            this.ikW.setData(aqVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.ikW.AK(str);
            this.ikW.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.az.9
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void U(JSONArray jSONArray) {
                    az.this.kkb.a(aVar, jSONArray);
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
        sparseArray.put(kwm, Integer.valueOf(kwn));
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
        this.kvv = new com.baidu.tbadk.core.dialog.a(this.kkb.getActivity());
        if (StringUtils.isNull(str2)) {
            this.kvv.ln(i3);
        } else {
            this.kvv.setOnlyMessageShowCenter(false);
            this.kvv.xl(str2);
        }
        this.kvv.setYesButtonTag(sparseArray);
        this.kvv.a(R.string.dialog_ok, this.kkb);
        this.kvv.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kvv.hJ(true);
        this.kvv.b(this.kkb.getPageContext());
        if (z) {
            this.kvv.aYL();
        } else {
            a(this.kvv, i);
        }
    }

    public void aR(ArrayList<com.baidu.tbadk.core.data.ai> arrayList) {
        if (this.kvy == null) {
            this.kvy = LayoutInflater.from(this.kkb.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.kkb.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kvy);
        if (this.kvx == null) {
            this.kvx = new Dialog(this.kkb.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.kvx.setCanceledOnTouchOutside(true);
            this.kvx.setCancelable(true);
            this.kvG = (ScrollView) this.kvy.findViewById(R.id.good_scroll);
            this.kvx.setContentView(this.kvy);
            WindowManager.LayoutParams attributes = this.kvx.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.kvx.getWindow().setAttributes(attributes);
            this.gZi = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.az.12
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        az.this.kvC = (String) compoundButton.getTag();
                        if (az.this.gZh != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : az.this.gZh) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && az.this.kvC != null && !str.equals(az.this.kvC)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.kvz = (LinearLayout) this.kvy.findViewById(R.id.good_class_group);
            this.kvB = (TextView) this.kvy.findViewById(R.id.dialog_button_cancel);
            this.kvB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (az.this.kvx instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(az.this.kvx, az.this.kkb.getPageContext());
                    }
                }
            });
            this.kvA = (TextView) this.kvy.findViewById(R.id.dialog_button_ok);
            this.kvA.setOnClickListener(this.hIl);
        }
        this.kvz.removeAllViews();
        this.gZh = new ArrayList();
        CustomBlueCheckRadioButton fc = fc("0", this.kkb.getPageContext().getString(R.string.thread_good_class));
        this.gZh.add(fc);
        fc.setChecked(true);
        this.kvz.addView(fc);
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
                    View view = new View(this.kkb.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ao.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.kvz.addView(view);
                    this.kvz.addView(fc2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.kvG.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kkb.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kkb.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.kkb.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.kvG.setLayoutParams(layoutParams2);
            this.kvG.removeAllViews();
            if (this.kvz != null && this.kvz.getParent() == null) {
                this.kvG.addView(this.kvz);
            }
        }
        com.baidu.adp.lib.f.g.a(this.kvx, this.kkb.getPageContext());
    }

    private CustomBlueCheckRadioButton fc(String str, String str2) {
        Activity pageActivity = this.kkb.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.gZi);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void cPS() {
        this.kkb.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.kkb.hideProgressBar();
        if (z && z2) {
            this.kkb.showToast(this.kkb.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.as.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.kkb.showToast(str);
        }
    }

    public void cvF() {
        this.kvt.setVisibility(0);
    }

    public void cvE() {
        this.kvt.setVisibility(8);
    }

    public View cPT() {
        if (this.kvy != null) {
            return this.kvy.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String cPU() {
        return this.kvC;
    }

    public View getView() {
        return this.bjP;
    }

    public void cPV() {
        if (this.kkb != null && this.kkb.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.kkb.getPageContext().getPageActivity(), this.kkb.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.kkb.hideProgressBar();
        if (z) {
            cQo();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            cQp();
        } else {
            cQo();
        }
    }

    public void cPW() {
        this.hMG.setLineVisible();
        this.hMG.startLoadData();
    }

    public void cPX() {
        this.kkb.hideProgressBar();
        endLoadData();
        this.kvc.completePullRefreshPostDelayed(0L);
        cQj();
    }

    public void cPY() {
        this.kvc.completePullRefreshPostDelayed(0L);
        cQj();
    }

    private void sN(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.kvh.b(onLongClickListener);
        this.kvn.setOnLongClickListener(onLongClickListener);
        if (this.kwG != null) {
            this.kwG.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0492b interfaceC0492b, boolean z, boolean z2) {
        if (this.kom != null) {
            this.kom.dismiss();
            this.kom = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kkb.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.kkb.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kkb.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kkb.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kkb.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.aS(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.kvD.dismiss();
                interfaceC0492b.a(null, i, view);
            }
        });
        this.kvD = new com.baidu.tbadk.core.dialog.i(this.kkb.getPageContext(), kVar);
        this.kvD.showDialog();
    }

    public void a(final b.InterfaceC0492b interfaceC0492b, boolean z) {
        if (this.kvD != null) {
            this.kvD.dismiss();
            this.kvD = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.kkb.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.kli != null && this.kli.cKx() != null && !this.kli.cKx().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.kkb.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.kkb.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aS(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.kvD.dismiss();
                interfaceC0492b.a(null, i, view);
            }
        });
        this.kvD = new com.baidu.tbadk.core.dialog.i(this.kkb.getPageContext(), kVar);
        this.kvD.showDialog();
    }

    public int cPZ() {
        return Ca(this.kvc.getFirstVisiblePosition());
    }

    private int Ca(int i) {
        com.baidu.adp.widget.ListView.f adapter = this.kvc.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.kvc.getAdapter() == null || !(this.kvc.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) ? 0 : this.kvc.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int cQa() {
        int lastVisiblePosition = this.kvc.getLastVisiblePosition();
        if (this.kve != null) {
            if (lastVisiblePosition == this.kvc.getCount() - 1) {
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
        if (this.kvc != null) {
            if (this.kuY == null || this.kuY.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.kuY.mNavigationBar.getFixedNavHeight();
                if (this.kkb.cMT() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.kwd != null && (layoutParams = (LinearLayout.LayoutParams) this.kwd.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.kwd.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.kvc.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.kvc.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.kvc.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.kvq.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.kvn.a(fVar, false);
        this.kvn.notifyDataSetChanged();
        cQj();
        if (this.kwG != null) {
            this.kwG.cLL();
        }
        ArrayList<PostData> cKz = fVar.cKz();
        if (fVar.getPage().aVb() == 0 || cKz == null || cKz.size() < fVar.getPage().aVa()) {
            if (com.baidu.tbadk.core.util.x.getCount(cKz) == 0 || (com.baidu.tbadk.core.util.x.getCount(cKz) == 1 && cKz.get(0) != null && cKz.get(0).dli() == 1)) {
                if (this.kwi == null || this.kwi.kxn == null || this.kwi.kxn.getView() == null) {
                    i = 0;
                } else {
                    i = this.kwi.kxn.getView().getTop() < 0 ? this.kwi.kxn.getView().getHeight() : this.kwi.kxn.getView().getBottom();
                }
                if (this.kkb.cNn()) {
                    this.hMG.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.hMG.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().aVb() == 0) {
                    this.hMG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.hMG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.hMG.bca();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.kvf != null) {
            this.kvf.e(fVar, this.kkQ);
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
                if (postData != null && postData.dli() == 1) {
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
            if (this.kkb.cLF()) {
                if (fVar.cKw() != null) {
                    this.mForumName = fVar.cKw().getForumName();
                    this.mForumId = fVar.cKw().getForumId();
                }
                if (this.mForumName == null && this.kkb.cLP() != null && this.kkb.cLP().cLG() != null) {
                    this.mForumName = this.kkb.cLP().cLG();
                }
            }
            PostData b = b(fVar, z);
            a(b, fVar);
            this.kvh.setVisibility(8);
            if (fVar.cKX()) {
                this.kwx = true;
                this.kuY.rU(true);
                this.kuY.mNavigationBar.hideBottomLine();
                if (this.kve == null) {
                    this.kve = new com.baidu.tieba.pb.pb.main.a.e(this.kkb);
                }
                this.kve.a(fVar, b, this.kvc, this.kvh, this.kwb, this.kuY, this.mForumName, this.kwL);
                this.kve.U(this.kwW);
                cQe();
            } else {
                this.kwx = false;
                this.kuY.rU(this.kwx);
                if (this.kve != null) {
                    this.kve.c(this.kvc);
                }
            }
            if (this.kkb.cMD() != null) {
                this.kkb.cMD().te(this.kwx);
            }
            if (b != null) {
                this.kvX = b;
                this.kvh.setVisibility(0);
                SparseArray<Object> cRb = this.kvh.cRb();
                cRb.put(R.id.tag_clip_board, b);
                cRb.put(R.id.tag_is_subpb, false);
                this.kvi.a(fVar, this.kvc);
                this.kvg.A(fVar);
                this.kvf.e(fVar, this.kkQ);
                this.kvf.z(fVar);
                this.kvh.a(this.mSkinType, this.kli, b, this.kwW);
                if (this.kwe != null) {
                    if (fVar.cLa()) {
                        this.kwe.getView().setVisibility(8);
                    } else {
                        this.kwe.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kiG);
                        if (fVar.cKx() != null) {
                            nVar.kiI = fVar.cKx().aWc();
                        }
                        nVar.isNew = !this.kkQ;
                        nVar.sortType = fVar.khp;
                        nVar.kiK = fVar.cLb();
                        nVar.kiL = this.kkb.cNn();
                        nVar.kiM = fVar.kho;
                        this.kwe.a(nVar);
                    }
                }
                if (fVar != null && fVar.cKx() != null) {
                    al(fVar.cKx().aWh() == 1, fVar.cKx().aWg() == 1);
                }
                com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.17
                    @Override // java.lang.Runnable
                    public void run() {
                        if (az.this.kvn != null && az.this.kuY != null && az.this.kuY.kBo != null && az.this.kli != null && az.this.kli.cKx() != null && !az.this.kli.cKx().aUR() && !az.this.cQi() && az.this.kli.getForum() != null && !com.baidu.tbadk.core.util.as.isEmpty(az.this.kli.getForum().getName())) {
                            if ((az.this.kvn.cMr() == null || !az.this.kvn.cMr().isShown()) && az.this.kuY.kBo != null) {
                                az.this.kuY.kBo.setVisibility(0);
                                if (az.this.kkb != null && az.this.kkb.cLP() != null) {
                                    com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c13400");
                                    apVar.dn("tid", az.this.kkb.cLP().cNL());
                                    apVar.dn("fid", az.this.kkb.cLP().getForumId());
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
        this.kwi.kxn = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kwi));
        a(this.kwi.kxn, false);
    }

    public void cQb() {
        if (this.kuY != null && !this.kwz) {
            this.kuY.cQb();
            this.kwz = true;
        }
    }

    public void bVC() {
        if (this.kuY != null) {
            this.kuY.cRz();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.kvh.a(postData, fVar);
    }

    public void cQc() {
        if (this.kve != null) {
            this.kve.d(this.kvc);
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
        PostData b = b(this.kli, false);
        String str = "";
        if (b != null && b.aWl() != null) {
            str = b.aWl().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.kuY.cRx();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.kuY.IG(dVar.forumName);
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
            final String str2 = dVar.khg;
            this.kkb.showNetRefreshView(this.bjP, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        com.baidu.tbadk.core.util.bd.baV().b(az.this.kkb.getPageContext(), new String[]{str2});
                        az.this.kkb.finish();
                        return;
                    }
                    az.this.kkb.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable cPh;
        Parcelable cPh2;
        if (fVar != null && this.kvc != null) {
            this.kli = fVar;
            this.mType = i;
            if (fVar.cKx() != null) {
                this.kwk = fVar.cKx().aVS();
                if (fVar.cKx().getAnchorLevel() != 0) {
                    this.aSJ = true;
                }
                this.kvF = aI(fVar.cKx());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.kvY = false;
            this.kkQ = z;
            cPX();
            if (fVar.khq != null && fVar.khq.cLg()) {
                if (this.kvd == null) {
                    this.kvd = new PbThreadPostView(this.kkb.getContext());
                    this.kvc.addHeaderView(this.kvd, 1);
                    this.kvd.setData(fVar);
                    this.kvd.setChildOnClickLinstener(this.hIl);
                }
            } else if (this.kvd != null && this.kvc != null) {
                this.kvc.removeHeaderView(this.kvd);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.kwJ == null) {
                this.kwJ = new al(this.kkb.getPageContext(), this.ihD);
            }
            this.kwJ.KM(fVar.cKE());
            if (this.kkb.cNd()) {
                if (this.kvr == null) {
                    this.kvr = new com.baidu.tieba.pb.view.d(this.kkb.getPageContext());
                    this.kvr.createView();
                    this.kvr.setListPullRefreshListener(this.ejc);
                }
                this.kvc.setPullRefresh(this.kvr);
                cQe();
                if (this.kvr != null) {
                    this.kvr.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().aVc() == 0 && z) {
                this.kvc.setPullRefresh(null);
            } else {
                if (this.kvr == null) {
                    this.kvr = new com.baidu.tieba.pb.view.d(this.kkb.getPageContext());
                    this.kvr.createView();
                    this.kvr.setListPullRefreshListener(this.ejc);
                }
                this.kvc.setPullRefresh(this.kvr);
                cQe();
                if (this.kvr != null) {
                    this.kvr.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                bMt();
            }
            cQj();
            this.kvn.rX(this.kkQ);
            this.kvn.rY(false);
            this.kvn.sc(i == 5);
            this.kvn.sd(i == 6);
            this.kvn.se(z2 && this.kwV && i != 2);
            this.kvn.a(fVar, false);
            this.kvn.notifyDataSetChanged();
            this.kvh.b(b(fVar, z), fVar.cLa());
            if (fVar.cKx() != null && fVar.cKx().aVW() != null && this.kuW != -1) {
                fVar.cKx().aVW().setIsLike(this.kuW);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.kvc.setNextPage(this.hMG);
                this.kuX = 2;
                bMt();
            } else {
                this.kvY = true;
                if (fVar.getPage().aVb() == 1) {
                    if (this.kvs == null) {
                        this.kvs = new com.baidu.tieba.pb.view.a(this.kkb, this.kkb);
                    }
                    this.kvc.setNextPage(this.kvs);
                } else {
                    this.kvc.setNextPage(this.hMG);
                }
                this.kuX = 3;
            }
            ArrayList<PostData> cKz = fVar.cKz();
            if (fVar.getPage().aVb() == 0 || cKz == null || cKz.size() < fVar.getPage().aVa()) {
                if (com.baidu.tbadk.core.util.x.getCount(cKz) == 0 || (com.baidu.tbadk.core.util.x.getCount(cKz) == 1 && cKz.get(0) != null && cKz.get(0).dli() == 1)) {
                    if (this.kwi == null || this.kwi.kxn == null || this.kwi.kxn.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.kwi.kxn.getView().getTop() < 0 ? this.kwi.kxn.getView().getHeight() : this.kwi.kxn.getView().getBottom();
                    }
                    if (this.kkb.cNn()) {
                        this.hMG.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.hMG.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.kkb.cMD() != null && !this.kkb.cMD().cRl()) {
                        this.kkb.cMD().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().aVb() == 0) {
                        this.hMG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.hMG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.hMG.bca();
                }
                if (fVar.getPage().aVb() == 0 || cKz == null) {
                    cQt();
                }
            } else {
                if (z2) {
                    if (this.kwV) {
                        endLoadData();
                        if (fVar.getPage().aVb() != 0) {
                            this.hMG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.hMG.setLineVisible();
                        this.hMG.showLoading();
                    }
                } else {
                    this.hMG.setLineVisible();
                    this.hMG.showLoading();
                }
                this.hMG.bca();
            }
            switch (i) {
                case 2:
                    this.kvc.setSelection(i2 > 1 ? (((this.kvc.getData() == null && fVar.cKz() == null) ? 0 : (this.kvc.getData().size() - fVar.cKz().size()) + this.kvc.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (cPh2 = as.cPg().cPh()) != null && !(cPh2 instanceof RecyclerView.SavedState)) {
                        this.kvc.onRestoreInstanceState(cPh2);
                        if (com.baidu.tbadk.core.util.x.getCount(cKz) > 1 && fVar.getPage().aVb() > 0) {
                            this.hMG.endLoadData();
                            this.hMG.setText(this.kkb.getString(R.string.pb_load_more_without_point));
                            this.hMG.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.kwV = false;
                    break;
                case 5:
                    this.kvc.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (cPh = as.cPg().cPh()) != null && !(cPh instanceof RecyclerView.SavedState)) {
                        this.kvc.onRestoreInstanceState(cPh);
                        break;
                    } else {
                        this.kvc.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.kve != null && this.kve.bxk() != null) {
                            if (this.kkb.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.kvc.setSelectionFromTop((this.kvn.cMm() + this.kvc.getHeaderViewsCount()) - 1, this.kve.cRd() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.kkb.getPageContext().getPageActivity()));
                            } else {
                                this.kvc.setSelectionFromTop((this.kvn.cMm() + this.kvc.getHeaderViewsCount()) - 1, this.kve.cRd());
                            }
                        } else {
                            this.kvc.setSelection(this.kvn.cMm() + this.kvc.getHeaderViewsCount());
                        }
                    } else {
                        this.kvc.setSelection(i2 > 0 ? ((this.kvc.getData() == null && fVar.cKz() == null) ? 0 : (this.kvc.getData().size() - fVar.cKz().size()) + this.kvc.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.hMG.endLoadData();
                    this.hMG.setText(this.kkb.getString(R.string.pb_load_more_without_point));
                    this.hMG.setLineGone();
                    break;
            }
            if (this.kwk == kwl && isHost()) {
                cQB();
            }
            if (this.kwv) {
                cPu();
                this.kwv = false;
                if (i3 == 0) {
                    sH(true);
                }
            }
            if (fVar.khm == 1 || fVar.khn == 1) {
                if (this.kwB == null) {
                    this.kwB = new PbTopTipView(this.kkb.getContext());
                }
                if (fVar.khn == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.kkb.getStType())) {
                    this.kwB.setText(this.kkb.getString(R.string.pb_read_strategy_add_experience));
                    this.kwB.a(this.bjP, this.mSkinType);
                } else if (fVar.khm == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.kkb.getStType())) {
                    this.kwB.setText(this.kkb.getString(R.string.pb_read_news_add_experience));
                    this.kwB.a(this.bjP, this.mSkinType);
                }
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cKx() != null) {
            x(fVar);
            if (fVar.aSj()) {
                SvgManager.baR().a(this.kvP, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.baR().a(this.kvP, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String Cc = Cc(fVar.cKx().aWc());
            if (this.kvS != null) {
                this.kvS.setText(Cc);
            }
            if (this.kvT != null) {
                this.kvT.setText(Cc);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.cKx()));
        }
    }

    private String Cc(int i) {
        if (i == 0) {
            return this.kkb.getString(R.string.pb_comment_red_dot_no_reply);
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
        if (this.kve != null) {
            this.kve.a(this.kvc, this.textView, this.mType);
        }
    }

    public void sP(boolean z) {
        this.kvE = z;
    }

    public void endLoadData() {
        if (this.hMG != null) {
            this.hMG.setLineGone();
            this.hMG.endLoadData();
        }
        bMt();
    }

    public void bBY() {
        this.kvc.setVisibility(0);
    }

    public void cQf() {
        if (this.kvc != null) {
            this.kvc.setVisibility(8);
        }
        if (this.kvc != null) {
            this.kwb.setVisibility(8);
        }
        if (this.kuY != null && this.kuY.kBn != null) {
            this.kuY.kBn.setVisibility(8);
        }
    }

    public void cQg() {
        if (this.kvc != null) {
            this.kvc.setVisibility(0);
        }
        if (this.kwb != null) {
            this.kwb.setVisibility(0);
        }
        if (this.kuY != null && this.kuY.kBn != null) {
            this.kuY.kBn.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.kvX != null && this.kvX.aWl() != null && this.kuY != null) {
            this.kwy = !this.kwx;
            this.kuY.tg(this.kwy);
            if (this.kkb.cMD() != null) {
                this.kkb.cMD().tf(this.kwy);
            }
            cQh();
            if (this.kkb != null && !this.kkb.cLF() && !com.baidu.tbadk.core.util.x.isEmpty(fVar.cKU())) {
                br brVar = fVar.cKU().get(0);
                if (brVar != null) {
                    this.kuY.fd(brVar.getForumName(), brVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.kuY.fd(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.kwy) {
                this.kvh.a(fVar, this.kvX, this.kvF);
                if (this.kwd != null) {
                    this.kwd.setVisibility(8);
                }
                if (this.kwH == null) {
                    this.kwH = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.az.19
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (az.this.kkb != null && az.this.kkb.isAdded()) {
                                if (i < 0 && f > az.this.kwA) {
                                    az.this.cQo();
                                    az.this.cQA();
                                }
                                az.this.cPY();
                            }
                        }
                    };
                }
                this.kvc.setListViewDragListener(this.kwH);
                return;
            }
            if (this.kwd != null) {
                this.kwd.setVisibility(0);
            }
            this.kvh.a(fVar, this.kvX, this.kvF);
            this.kwH = null;
            this.kvc.setListViewDragListener(null);
        }
    }

    private void cQh() {
        this.kvh.a(this.kli, this.kvX, this.kwy, this.kwx);
    }

    public boolean cQi() {
        return this.kli == null || this.kli.getForum() == null || "0".equals(this.kli.getForum().getId()) || "me0407".equals(this.kli.getForum().getName());
    }

    private boolean cQj() {
        return this.kvf.tb(this.kkQ);
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
            if (this.kvg != null) {
                if (fVar.cKx() != null && fVar.cKx().aWz() == 0 && !fVar.cKx().aUR() && !this.kwO) {
                    if (fVar.cKx() != null) {
                        bv cKx = fVar.cKx();
                        cKx.w(true, w(fVar));
                        cKx.kZ(3);
                        cKx.wY("2");
                    }
                    if (fVar.cKx().aUT()) {
                        this.kvh.c(this.kvc);
                        this.kvg.c(this.kvc);
                        this.kvg.b(this.kvc);
                        this.kvh.b(this.kvc);
                        this.kvh.E(this.kli);
                        this.kvg.B(fVar);
                    } else {
                        this.kvh.E(this.kli);
                        this.kvg.D(fVar);
                    }
                } else if (fVar.cKx().aWz() == 1) {
                    if (fVar.cKx() != null) {
                        this.kvg.c(this.kvc);
                        this.kvh.E(this.kli);
                    }
                } else {
                    this.kvg.c(this.kvc);
                    this.kvh.E(this.kli);
                }
            }
            if (fVar.cKx() != null) {
                ak(fVar.cKx().aWh() == 1, fVar.cKx().aWg() == 1);
            }
            this.kkQ = z;
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
                            sb.append(com.baidu.adp.lib.util.k.cutString(brVar.getForumName(), 12)).append(this.kkb.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.kkb.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
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
        if (this.bkz == null || this.bkz.getParent() == null || this.hMG.isLoading()) {
            return false;
        }
        int bottom = this.bkz.getBottom();
        Rect rect = new Rect();
        this.bkz.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void KO(String str) {
        if (this.hMG != null) {
            this.hMG.setText(str);
        }
    }

    public void KP(String str) {
        if (this.hMG != null) {
            int i = 0;
            if (this.kwi != null && this.kwi.kxn != null && this.kwi.kxn.getView() != null) {
                i = this.kwi.kxn.getView().getTop() < 0 ? this.kwi.kxn.getView().getHeight() : this.kwi.kxn.getView().getBottom();
            }
            this.hMG.al(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.kvc;
    }

    public int cQm() {
        return R.id.richText;
    }

    public TextView cLZ() {
        return this.kvh.cLZ();
    }

    public void d(BdListView.e eVar) {
        this.kvc.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.ejc = cVar;
        if (this.kvr != null) {
            this.kvr.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.au auVar, a.b bVar) {
        if (auVar != null) {
            int aUZ = auVar.aUZ();
            int aUW = auVar.aUW();
            if (this.kvo != null) {
                this.kvo.aYL();
            } else {
                this.kvo = new com.baidu.tbadk.core.dialog.a(this.kkb.getPageContext().getPageActivity());
                this.kvp = LayoutInflater.from(this.kkb.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.kvo.aV(this.kvp);
                this.kvo.a(R.string.dialog_ok, bVar);
                this.kvo.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        az.this.cQo();
                        aVar.dismiss();
                    }
                });
                this.kvo.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.az.21
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (az.this.kws == null) {
                            az.this.kws = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.21.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    az.this.kkb.HidenSoftKeyPad((InputMethodManager) az.this.kkb.getBaseFragmentActivity().getSystemService("input_method"), az.this.bjP);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.lt().postDelayed(az.this.kws, 150L);
                    }
                });
                this.kvo.b(this.kkb.getPageContext()).aYL();
            }
            this.kvq = (EditText) this.kvp.findViewById(R.id.input_page_number);
            this.kvq.setText("");
            TextView textView = (TextView) this.kvp.findViewById(R.id.current_page_number);
            if (aUZ <= 0) {
                aUZ = 1;
            }
            if (aUW <= 0) {
                aUW = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(aUZ), Integer.valueOf(aUW)));
            this.kkb.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.kvq, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.kvc.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.kkb.showToast(str);
    }

    public boolean sQ(boolean z) {
        if (this.ZS == null || !this.ZS.biL()) {
            return false;
        }
        this.ZS.bhl();
        return true;
    }

    public void cQn() {
        if (this.kwX != null) {
            while (this.kwX.size() > 0) {
                TbImageView remove = this.kwX.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        cQn();
        this.kvn.BD(1);
        if (this.kve != null) {
            this.kve.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.kvn.BD(2);
        if (this.kve != null) {
            this.kve.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.kkb.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.kkb.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.kvR != null) {
            this.kvR.onDestroy();
        }
        if (this.kwu != null) {
            this.kwu.destroy();
        }
        if (this.kwJ != null) {
            this.kwJ.onDestory();
        }
        if (this.kwB != null) {
            this.kwB.hide();
        }
        this.kkb.hideProgressBar();
        if (this.fqQ != null && this.hCK != null) {
            this.fqQ.b(this.hCK);
        }
        cQo();
        endLoadData();
        if (this.kws != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kws);
        }
        if (this.kwa != null) {
            this.kwa.clearStatus();
        }
        this.kwR = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.kvn.BD(3);
        if (this.biX != null) {
            this.biX.setBackgroundDrawable(null);
        }
        if (this.kve != null) {
            this.kve.destroy();
        }
        if (this.kvn != null) {
            this.kvn.onDestroy();
        }
        this.kvc.setOnLayoutListener(null);
        if (this.kwF != null) {
            this.kwF.ceq();
        }
        if (this.kwj != null) {
            this.kwj.onDestroy();
        }
        if (this.kvh != null) {
            this.kvh.onDestroy();
        }
    }

    public boolean Cd(int i) {
        if (this.kve != null) {
            return this.kve.Cd(i);
        }
        return false;
    }

    public void cQo() {
        this.kuY.aIX();
        if (this.kvh != null) {
            this.kvh.cQo();
        }
        if (this.kkb != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.kkb.getContext(), this.kvq);
        }
        cPw();
        if (this.kom != null) {
            this.kom.dismiss();
        }
        cQq();
        if (this.kvo != null) {
            this.kvo.dismiss();
        }
        if (this.hIk != null) {
            this.hIk.dismiss();
        }
    }

    public void cQp() {
        this.kuY.aIX();
        if (this.kvh != null) {
            this.kvh.cQo();
        }
        if (this.kom != null) {
            this.kom.dismiss();
        }
        cQq();
        if (this.kvo != null) {
            this.kvo.dismiss();
        }
        if (this.hIk != null) {
            this.hIk.dismiss();
        }
    }

    public void eu(List<String> list) {
        this.kwE = list;
        if (this.kwF != null) {
            this.kwF.setData(list);
        }
    }

    public void rW(boolean z) {
        this.kvn.rW(z);
    }

    public void sR(boolean z) {
        this.kvH = z;
    }

    public void cQq() {
        if (this.kvv != null) {
            this.kvv.dismiss();
        }
        if (this.kvw != null) {
            com.baidu.adp.lib.f.g.b(this.kvw, this.kkb.getPageContext());
        }
        if (this.kvx != null) {
            com.baidu.adp.lib.f.g.b(this.kvx, this.kkb.getPageContext());
        }
        if (this.kvu != null) {
            this.kvu.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.kli, this.kkQ);
            b(this.kli, this.kkQ, this.mType, i);
            this.kkb.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.kkb.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bjP);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.bjP, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.ao.setBackgroundResource(this.kvI, R.drawable.personalize_tab_shadow);
            if (this.kve != null) {
                this.kve.onChangeSkinType(i);
            }
            if (this.kvi != null) {
                this.kvi.onChangeSkinType(i);
            }
            if (this.kvf != null) {
                this.kvf.onChangeSkinType(i);
            }
            if (this.kvg != null) {
                this.kvg.onChangeSkinType(i);
            }
            if (this.kvh != null) {
                this.kvh.onChangeSkinType(i);
            }
            if (this.hMG != null) {
                this.hMG.changeSkin(i);
                if (this.eGt != null) {
                    this.kkb.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.eGt);
                    com.baidu.tbadk.core.util.ao.setBackgroundResource(this.eGt, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.kvo != null) {
                this.kvo.c(this.kkb.getPageContext());
            }
            sP(this.kvE);
            this.kvn.notifyDataSetChanged();
            if (this.kvr != null) {
                this.kvr.changeSkin(i);
            }
            if (this.ZS != null) {
                this.ZS.onChangeSkinType(i);
            }
            if (this.kvs != null) {
                this.kvs.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.gZh)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.gZh) {
                    customBlueCheckRadioButton.bbN();
                }
            }
            cPN();
            UtilHelper.setStatusBarBackground(this.biX, i);
            UtilHelper.setStatusBarBackground(this.kwd, i);
            if (this.kvj != null) {
                com.baidu.tbadk.r.a.a(this.kkb.getPageContext(), this.kvj);
            }
            if (this.kwt != null) {
                this.kwt.onChangeSkinType(i);
            }
            if (this.kuY != null) {
                if (this.kve != null) {
                    this.kve.Ce(i);
                } else {
                    this.kuY.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.iEW != null) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.iEW, R.color.cp_cont_d);
            }
            if (this.kvN != null) {
                this.kvN.setBorderColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_border_a));
            }
            if (this.kvM != null) {
                this.kvM.setBackgroundDrawable(com.baidu.tbadk.core.util.ao.aH(com.baidu.adp.lib.util.l.getDimens(this.kkb.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ao.getColor(R.color.cp_bg_line_j)));
            }
            if (this.kvP != null && this.kli != null) {
                if (this.kli.aSj()) {
                    SvgManager.baR().a(this.kvP, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.baR().a(this.kvP, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            x(this.kli);
            if (this.kvO != null) {
                SvgManager.baR().a(this.kvO, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.kvK != null) {
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.kvK, R.drawable.bottom_shadow);
            }
            if (this.kvS != null) {
                com.baidu.tbadk.core.util.ao.c(this.kvS, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_cont_h, R.color.cp_cont_h);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kvS, R.color.cp_cont_a);
            }
            if (this.kvT != null) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kvT, R.color.cp_cont_b);
            }
            if (this.kwG != null) {
                this.kwG.onChangeSkinType(i);
            }
            if (this.kwj != null) {
                this.kwj.onChangeSkinType();
            }
            if (this.kwD != null) {
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.kwD, R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kvL, R.color.cp_bg_line_h);
            if (this.kvd != null) {
                this.kvd.qZ(i);
            }
            if (this.kvR != null) {
                this.kvR.onChangeSkinType();
            }
        }
    }

    public void cQr() {
        if (this.kvR != null) {
            this.kvR.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.aX(fVar.cKx())) {
            if (this.kvR != null) {
                this.kvR.setEnable(false);
                this.kvR.onDestroy();
            }
            SvgManager.baR().a(this.kvQ, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.kvR == null || !this.kvR.isEnable()) {
            SvgManager.baR().a(this.kvQ, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eRR = iVar;
        this.kvn.setOnImageClickListener(this.eRR);
        this.kwG.setOnImageClickListener(this.eRR);
    }

    public void g(NoNetworkView.a aVar) {
        this.hCK = aVar;
        if (this.fqQ != null) {
            this.fqQ.a(this.hCK);
        }
    }

    public void sS(boolean z) {
        this.kvn.setIsFromCDN(z);
    }

    public Button cQs() {
        return this.kvJ;
    }

    public void cQt() {
        if (this.kuX != 2) {
            this.kvc.setNextPage(this.hMG);
            this.kuX = 2;
        }
    }

    public void cQu() {
        if (com.baidu.tbadk.n.m.blA().blB()) {
            int lastVisiblePosition = this.kvc.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.kvc.getChildAt(i);
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
        if (this.kvL != null) {
            sR(this.kkb.cMA().bjs());
            if (this.kvH) {
                sI(z);
            } else {
                sJ(z);
            }
        }
    }

    public void cQy() {
        if (this.kvL != null) {
            this.kvK.setVisibility(8);
            this.kvL.setVisibility(8);
            this.kvU = false;
            if (this.kwj != null) {
                this.kwj.setVisibility(8);
                sN(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.hdc == null) {
            this.hdc = new com.baidu.tbadk.core.view.a(this.kkb.getPageContext());
        }
        this.hdc.setDialogVisiable(true);
    }

    public void bMt() {
        if (this.hdc != null) {
            this.hdc.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.kvc.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.kvc.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.kve != null) {
            this.kve.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.kwY = getScrollY();
            this.kwi.kxn = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kwi));
            a(this.kwi.kxn, true);
        }
    }

    public void sU(boolean z) {
        if (this.kve != null) {
            this.kve.sU(z);
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
        if (this.kve != null) {
            this.kve.onScroll(absListView, i, i2, i3);
        }
        if (this.kuY != null && this.kvh != null) {
            this.kuY.cS(this.kvh.cQZ());
        }
        this.kwi.kaT = i;
        this.kwi.headerCount = this.kvc.getHeaderViewsCount();
        this.kwi.kxn = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.kwi));
        sK(b(absListView, i));
        a(this.kwi.kxn, false);
        if (this.hMG.bcb() && !this.hMG.eim) {
            if (this.kwi != null && this.kwi.kxn != null && this.kwi.kxn.getView() != null) {
                i4 = this.kwi.kxn.getView().getTop() < 0 ? this.kwi.kxn.getView().getHeight() : this.kwi.kxn.getView().getBottom();
            }
            this.hMG.mJ(i4);
            this.hMG.eim = true;
        }
    }

    public void cQz() {
        if (TbadkCoreApplication.isLogin() && this.kli != null && this.kwy && !this.kwx && !this.kvF && this.kvX != null && this.kvX.aWl() != null && !this.kvX.aWl().getIsLike() && !this.kvX.aWl().hadConcerned() && this.kwu == null) {
            this.kwu = new av(this.kkb);
        }
    }

    public void cQA() {
        if (this.kkb != null) {
            if ((this.hFn || this.kwM == 17) && com.baidu.tbadk.a.d.aRR()) {
                if (this.kli != null && this.kli.getForum() != null && !com.baidu.tbadk.core.util.as.isEmpty(this.kli.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.kkb.getContext()).createNormalCfg(this.kli.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13853").dn("post_id", this.kli.getThreadId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("fid", this.kli.getForum().getId()));
                }
            } else if (this.kwy && !this.kwx && this.kvX != null && this.kvX.aWl() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12601").ah("obj_locate", this.kkb.cLF() ? 2 : 1).ah("obj_type", this.kwx ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.kkb.getPageContext().getPageActivity(), this.kvX.aWl().getUserId(), this.kvX.aWl().getUserName(), this.kkb.cLP().cLG(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(au auVar, boolean z) {
        int measuredHeight;
        if (!this.kwx && this.kwc != null && this.kuY.cRr() != null) {
            int cMn = this.kvn.cMn();
            if (cMn > 0 && (auVar == null || auVar.getView().getParent() == null)) {
                if (cMn > this.kvc.getFirstVisiblePosition() - this.kvc.getHeaderViewsCount()) {
                    this.kwc.setVisibility(4);
                    return;
                }
                this.kwc.setVisibility(0);
                sK(false);
                this.kuY.mNavigationBar.hideBottomLine();
                if (this.kwc.getParent() != null && ((ViewGroup) this.kwc.getParent()).getHeight() <= this.kwc.getTop()) {
                    this.kwc.getParent().requestLayout();
                }
            } else if (auVar == null || auVar.getView() == null || auVar.kux == null) {
                if (this.kvc.getFirstVisiblePosition() == 0) {
                    this.kwc.setVisibility(4);
                    this.kuY.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = auVar.getView().getTop();
                if (auVar.getView().getParent() != null) {
                    if (this.kwh) {
                        this.kwg = top;
                        this.kwh = false;
                    }
                    this.kwg = top < this.kwg ? top : this.kwg;
                }
                if (top != 0 || auVar.getView().isShown()) {
                    if (this.kvm.getY() < 0.0f) {
                        measuredHeight = kwf - auVar.kux.getMeasuredHeight();
                    } else {
                        measuredHeight = this.kuY.cRr().getMeasuredHeight() - auVar.kux.getMeasuredHeight();
                        this.kuY.mNavigationBar.hideBottomLine();
                    }
                    if (auVar.getView().getParent() == null && top <= this.kwg) {
                        this.kwc.setVisibility(0);
                        sK(false);
                    } else if (top < measuredHeight) {
                        this.kwc.setVisibility(0);
                        sK(false);
                    } else {
                        this.kwc.setVisibility(4);
                        this.kuY.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.kwh = true;
                    }
                }
            }
        }
    }

    public void cQB() {
        if (!this.kwZ) {
            TiebaStatic.log("c10490");
            this.kwZ = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kkb.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(kwm, Integer.valueOf(kwo));
            aVar.lm(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.kkb.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aV(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.kkb);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.23
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.kkb.getPageContext()).aYL();
        }
    }

    public void KQ(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kkb.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.kkb.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aV(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(kwm, Integer.valueOf(kwp));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.kkb);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kkb.getPageContext()).aYL();
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
        this.kvh.onChangeSkinType(i2);
    }

    public PbInterviewStatusView cQC() {
        return this.kwa;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cKx() != null && fVar.cKx().aXt() && this.kwa == null) {
            this.kwa = (PbInterviewStatusView) this.kvZ.inflate();
            this.kwa.setOnClickListener(this.hIl);
            this.kwa.setCallback(this.kkb.cNl());
            this.kwa.setData(this.kkb, fVar);
        }
    }

    public RelativeLayout cQD() {
        return this.kvm;
    }

    public View cQE() {
        return this.biX;
    }

    public boolean cQF() {
        return this.kwO;
    }

    public void sb(boolean z) {
        this.kvh.sb(z);
    }

    public void KR(String str) {
        if (this.kuZ != null) {
            this.kuZ.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int sV(boolean z) {
        if (this.kwa == null || this.kwa.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void cQG() {
        if (this.kwa != null && this.kwa.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kwa.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.kwa.setLayoutParams(layoutParams);
        }
    }

    public boolean cMG() {
        return false;
    }

    public void KS(String str) {
        this.iEW.performClick();
        if (!StringUtils.isNull(str) && this.kkb.cMA() != null && this.kkb.cMA().bjk() != null && this.kkb.cMA().bjk().getInputView() != null) {
            EditText inputView = this.kkb.cMA().bjk().getInputView();
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
            if (this.kwt != null) {
                this.kwt.cMv();
            }
            this.kkb.cbV();
            this.kvm.setVisibility(8);
            this.kuY.th(false);
            this.kkb.sq(false);
            if (this.kve != null) {
                if (configuration.orientation == 1) {
                    cQD().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.kvc.setIsLandscape(true);
                    this.kvc.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.kvc.setIsLandscape(false);
                    if (this.kwY > 0) {
                        this.kvc.smoothScrollBy(this.kwY, 0);
                    }
                }
                this.kve.onConfigurationChanged(configuration);
                this.kwb.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void sW(boolean z) {
        if (this.kve != null) {
            this.kve.sW(z);
        }
    }

    public boolean cQH() {
        return this.kve != null && this.kve.cQH();
    }

    public void cQI() {
        if (this.kve != null) {
            this.kve.cQI();
        }
    }

    public void sf(boolean z) {
        this.kvn.sf(z);
    }

    public void cQ(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.kvL.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.kkb.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.kwD = new TextView(this.kkb.getContext());
            this.kwD.setText(R.string.connection_tips);
            this.kwD.setGravity(17);
            this.kwD.setPadding(com.baidu.adp.lib.util.l.getDimens(this.kkb.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.kkb.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.kkb.getContext(), R.dimen.ds60);
            if (this.kwD.getParent() == null) {
                frameLayout.addView(this.kwD, layoutParams);
            }
            this.kwC = new PopupWindow(this.kkb.getContext());
            this.kwC.setContentView(frameLayout);
            this.kwC.setHeight(-2);
            this.kwC.setWidth(-2);
            this.kwC.setFocusable(true);
            this.kwC.setOutsideTouchable(false);
            this.kwC.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.kvc.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.25
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        az.this.kwC.showAsDropDown(az.this.kvL, view.getLeft(), -az.this.kvL.getHeight());
                    } else {
                        az.this.kwC.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void sX(boolean z) {
        this.kwI = z;
    }

    public boolean cQJ() {
        return this.kwI;
    }

    public PbThreadPostView cQK() {
        return this.kvd;
    }

    private void ak(boolean z, boolean z2) {
        al(z, z2);
        if (this.kli != null && this.kli.cKx() != null && this.kli.cKx().aWz() == 0 && !this.kli.cKx().aUR()) {
            am(z, z2);
        } else if (this.kvn != null && this.kvn.cMs() != null) {
            this.kvn.cMs().b(this.kli, z, z2);
        }
    }

    private void al(boolean z, boolean z2) {
        this.kvh.d(this.kli, z, z2);
    }

    private void am(boolean z, boolean z2) {
        this.kvg.c(this.kli, z, z2);
    }

    public void sY(boolean z) {
        this.hFn = z;
    }

    public void BV(int i) {
        this.kwM = i;
    }

    public void cQL() {
        if (this.kvc != null) {
            this.kvc.setForbidDragListener(true);
        }
    }

    public boolean cNE() {
        if (this.kvc == null) {
            return false;
        }
        return this.kvc.cNE();
    }
}
