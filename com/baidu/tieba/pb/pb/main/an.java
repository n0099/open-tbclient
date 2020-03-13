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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
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
public class an {
    private EditorTools FO;
    private RelativeLayout aCR;
    private View aCc;
    private View aDy;
    private View dDa;
    private g.c dgV;
    private com.baidu.tieba.pb.a.c dqX;
    private List<CustomBlueCheckRadioButton> fMh;
    private NoNetworkView fVd;
    private NavigationBarCoverTip gNB;
    private com.baidu.tieba.NEGFeedBack.e gQv;
    private View.OnClickListener gqD;
    private PbListView guZ;
    private TextView hgY;
    private PbFragment iEk;
    private View.OnClickListener iFe;
    private com.baidu.tieba.pb.data.e iFn;
    private PbFakeFloorModel iHk;
    PbFragment.c iIR;
    public int iNU;
    public final com.baidu.tieba.pb.pb.main.view.c iNW;
    public com.baidu.tieba.pb.pb.main.view.b iNX;
    private ViewStub iNY;
    private ViewStub iNZ;
    private View iOG;
    private View iOI;
    private View iOJ;
    private ImageView iOK;
    private ImageView iOL;
    private ImageView iOM;
    private com.baidu.tieba.pb.view.c iON;
    private TextView iOO;
    private int iOQ;
    private int iOR;
    private PostData iOS;
    private ViewStub iOU;
    private PbInterviewStatusView iOV;
    private FrameLayout iOW;
    private View iOX;
    private View iOY;
    private aj iOZ;
    private PbLandscapeListView iOa;
    private PbThreadPostView iOb;
    private com.baidu.tieba.pb.pb.main.a.e iOc;
    private com.baidu.tieba.pb.pb.main.a.a iOd;
    private com.baidu.tieba.pb.pb.main.a.c iOe;
    private com.baidu.tieba.pb.pb.main.a.d iOf;
    private com.baidu.tieba.pb.pb.main.a.b iOg;
    private LinearLayout iOh;
    private TextView iOi;
    private TextView iOj;
    private ObservedChangeRelativeLayout iOk;
    private f iOl;
    private View iOr;
    private com.baidu.tieba.pb.pb.main.emotion.c iPA;
    private com.baidu.tieba.pb.pb.godreply.a iPB;
    private PbLandscapeListView.b iPC;
    private aa iPE;
    private String iPF;
    private long iPG;
    private boolean iPI;
    private Runnable iPM;
    private PbFragment.b iPO;
    public int iPS;
    private PbEmotionBar iPe;
    private int iPm;
    private Runnable iPn;
    private s iPo;
    private ak iPp;
    private int iPv;
    private PbTopTipView iPw;
    private PopupWindow iPx;
    private TextView iPy;
    private List<String> iPz;
    private boolean isLandscape;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int iPa = UtilHelper.getLightStatusBarHeight();
    public static int iPg = 3;
    public static int iPh = 0;
    public static int iPi = 3;
    public static int iPj = 4;
    public static int iPk = 5;
    public static int iPl = 6;
    private static a.InterfaceC0610a iPH = new a.InterfaceC0610a() { // from class: com.baidu.tieba.pb.pb.main.an.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0610a
        public void onRefresh() {
        }
    };
    private int iNV = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a iOm = null;
    private com.baidu.tbadk.core.dialog.b gqC = null;
    private View iOn = null;
    private EditText iOo = null;
    private com.baidu.tieba.pb.view.d iOp = null;
    private com.baidu.tieba.pb.view.a iOq = null;
    private b.a hDG = null;
    private TbRichTextView.i dMK = null;
    private NoNetworkView.a glY = null;
    private com.baidu.tbadk.core.dialog.i iOs = null;
    private com.baidu.tbadk.core.dialog.a iOt = null;
    private Dialog iOu = null;
    private Dialog iOv = null;
    private View iOw = null;
    private LinearLayout iOx = null;
    private CompoundButton.OnCheckedChangeListener fMi = null;
    private TextView iOy = null;
    private TextView iOz = null;
    private String iOA = null;
    private com.baidu.tbadk.core.dialog.i iHU = null;
    private com.baidu.tbadk.core.dialog.i iOB = null;
    private boolean iOC = false;
    private boolean iOD = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView iOE = null;
    private boolean iOF = false;
    private Button iOH = null;
    private boolean iOP = true;
    private com.baidu.tbadk.core.view.a fQi = null;
    private boolean iEW = false;
    private int mSkinType = 3;
    private boolean iOT = false;
    private int iPb = 0;
    private boolean iPc = true;
    public a iPd = new a();
    private int iPf = 0;
    private boolean iPq = false;
    private int iPr = 0;
    private boolean iPs = false;
    private boolean iPt = false;
    private boolean iPu = false;
    private boolean iPD = false;
    private String iPJ = null;
    private CustomMessageListener iPK = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.an.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                an.this.iPJ = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.an.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && an.this.iOl != null) {
                an.this.iOl.notifyDataSetChanged();
            }
        }
    };
    private Handler iPL = new Handler();
    private CustomMessageListener iPN = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.an.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                an.this.iOP = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean iPP = true;
    View.OnClickListener iPQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || an.this.iFn == null || an.this.iFn.ckv() == null || an.this.iFn.ckv().aCo() == null || an.this.iFn.ckv().aCo().getAlaUserData() == null || an.this.iFn.ckv().aCo().getAlaUserData().live_status != 1 || an.this.iFn.ckv().aCo().getAlaUserData().live_id <= 0) {
                if (an.this.iPs) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").X("obj_id", 2));
                }
                if (!an.this.iPs && an.this.iFn != null && an.this.iFn.ckv() != null && an.this.iFn.ckv().aCo() != null && an.this.iFn.ckv().aCo().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").X("obj_locate", 1));
                }
                if (an.this.iEk.cnj() != null) {
                    an.this.iEk.cnj().iEw.gRi.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c11851");
            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(anVar);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = an.this.iFn.ckv().aCo().getAlaUserData().live_id;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(an.this.iEk.cnj(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
        }
    };
    private boolean aqc = false;
    String userId = null;
    private final List<TbImageView> iPR = new ArrayList();
    private boolean iPT = false;

    /* loaded from: classes9.dex */
    public static class a {
        public int headerCount;
        public aj iQh;
        public int ixg;
    }

    public void qf(boolean z) {
        this.iPq = z;
        if (this.iOa != null) {
            this.iPr = this.iOa.getHeaderViewsCount();
        }
    }

    public void cpf() {
        if (this.iOa != null) {
            int headerViewsCount = this.iOa.getHeaderViewsCount() - this.iPr;
            final int firstVisiblePosition = (this.iOa.getFirstVisiblePosition() == 0 || this.iOa.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.iOa.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.iOa.getChildAt(0);
            final int top2 = childAt != null ? childAt.getTop() : -1;
            this.iPd.iQh = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iPd));
            final aj ajVar = this.iPd.iQh;
            final int f = f(ajVar);
            final int y = ((int) this.iOk.getY()) + this.iOk.getMeasuredHeight();
            final boolean z = this.iOX.getVisibility() == 0;
            boolean z2 = this.iOk.getY() < 0.0f;
            if ((z && ajVar != null) || firstVisiblePosition >= this.iOl.cmc() + this.iOa.getHeaderViewsCount()) {
                int measuredHeight = ajVar != null ? ajVar.iNx.getMeasuredHeight() : 0;
                if (z2) {
                    this.iOa.setSelectionFromTop(this.iOl.cmc() + this.iOa.getHeaderViewsCount(), iPa - measuredHeight);
                } else {
                    this.iOa.setSelectionFromTop(this.iOl.cmc() + this.iOa.getHeaderViewsCount(), this.iNW.cra().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.iOa.setSelectionFromTop(firstVisiblePosition, top2);
            }
            if (this.iPs && this.iOc != null) {
                this.iOa.setSelectionFromTop(this.iOl.cmc() + this.iOa.getHeaderViewsCount(), this.iOc.cqM());
            } else if (this.mType == 6) {
                this.iOa.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.an.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void cnt() {
                        ViewGroup.LayoutParams layoutParams;
                        if (f >= 0 && f <= an.this.aCR.getMeasuredHeight()) {
                            int f2 = an.this.f(ajVar);
                            int i = f2 - f;
                            if (z && i != 0 && f <= y) {
                                i = f2 - y;
                            }
                            if (an.this.aDy != null && (layoutParams = an.this.aDy.getLayoutParams()) != null) {
                                if (i == 0 || i > an.this.aCR.getMeasuredHeight() || f2 >= an.this.aCR.getMeasuredHeight()) {
                                    layoutParams.height = an.this.iPm;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > an.this.aCR.getMeasuredHeight()) {
                                    layoutParams.height = an.this.iPm;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    an.this.iOa.setSelectionFromTop(firstVisiblePosition, top2);
                                }
                                an.this.aDy.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (an.this.aDy != null && an.this.aDy.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = an.this.aDy.getLayoutParams();
                                            layoutParams2.height = an.this.iPm;
                                            an.this.aDy.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        an.this.iOa.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(aj ajVar) {
        if (ajVar == null || ajVar.getView() == null) {
            return 0;
        }
        if (ajVar.getView().getTop() != 0 || ajVar.getView().isShown()) {
            return ajVar.getView().getBottom();
        }
        return 0;
    }

    public NoNetworkView cpg() {
        return this.fVd;
    }

    public void cph() {
        if (this.FO != null) {
            this.FO.hide();
            if (this.iPA != null) {
                this.iPA.cqO();
            }
        }
    }

    public PbFakeFloorModel cpi() {
        return this.iHk;
    }

    public s cpj() {
        return this.iPo;
    }

    public com.baidu.tieba.pb.pb.main.a.e cpk() {
        return this.iOc;
    }

    public void cpl() {
        reset();
        cph();
        this.iPo.cmk();
        qr(false);
    }

    private void reset() {
        if (this.iEk != null && this.iEk.cmp() != null && this.FO != null) {
            com.baidu.tbadk.editortools.pb.a.aOQ().setStatus(0);
            com.baidu.tbadk.editortools.pb.e cmp = this.iEk.cmp();
            cmp.aPk();
            cmp.aOE();
            if (cmp.getWriteImagesInfo() != null) {
                cmp.getWriteImagesInfo().setMaxImagesAllowed(cmp.isBJH ? 1 : 9);
            }
            cmp.mv(SendView.ALL);
            cmp.mw(SendView.ALL);
            com.baidu.tbadk.editortools.g mm = this.FO.mm(23);
            com.baidu.tbadk.editortools.g mm2 = this.FO.mm(2);
            com.baidu.tbadk.editortools.g mm3 = this.FO.mm(5);
            if (mm2 != null) {
                mm2.display();
            }
            if (mm3 != null) {
                mm3.display();
            }
            if (mm != null) {
                mm.hide();
            }
            this.FO.invalidate();
        }
    }

    public boolean cpm() {
        return this.iOP;
    }

    public void qg(boolean z) {
        if (this.iOJ != null && this.hgY != null) {
            this.hgY.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iOJ.startAnimation(alphaAnimation);
            }
            this.iOI.setVisibility(0);
            this.iOJ.setVisibility(0);
            this.iOP = true;
            if (this.iPe != null && !this.iPB.isActive()) {
                this.iPe.setVisibility(0);
                ql(true);
            }
        }
    }

    public void qh(boolean z) {
        if (this.iOJ != null && this.hgY != null) {
            this.hgY.setText(cpn());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iOJ.startAnimation(alphaAnimation);
            }
            this.iOI.setVisibility(0);
            this.iOJ.setVisibility(0);
            this.iOP = true;
            if (this.iPe != null && !this.iPB.isActive()) {
                this.iPe.setVisibility(0);
                ql(true);
            }
        }
    }

    public String cpn() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.iPF)) {
            return this.iPF;
        }
        if (this.iEk != null) {
            this.iPF = TbadkCoreApplication.getInst().getResources().getString(am.cpc());
        }
        return this.iPF;
    }

    public PostData cpo() {
        int i = 0;
        if (this.iOa == null) {
            return null;
        }
        int cpp = cpp() - this.iOa.getHeaderViewsCount();
        if (cpp < 0) {
            cpp = 0;
        }
        if (this.iOl.yG(cpp) != null && this.iOl.yG(cpp) != PostData.kgE) {
            i = cpp + 1;
        }
        return this.iOl.getItem(i) instanceof PostData ? (PostData) this.iOl.getItem(i) : null;
    }

    public int cpp() {
        int i;
        View childAt;
        if (this.iOa == null) {
            return 0;
        }
        int firstVisiblePosition = this.iOa.getFirstVisiblePosition();
        int lastVisiblePosition = this.iOa.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.iOa.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.iOa.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int cpq() {
        return this.iOa.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.iFn != null && this.iFn.ckx() != null && !this.iFn.ckx().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.iFn.ckx().size() && (postData = this.iFn.ckx().get(i)) != null && postData.aCo() != null && !StringUtils.isNull(postData.aCo().getUserId()); i++) {
                if (this.iFn.ckx().get(i).aCo().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.iPB != null && this.iPB.isActive()) {
                        qr(false);
                    }
                    if (this.iPe != null) {
                        this.iPe.qA(true);
                    }
                    this.iPJ = postData.aCo().getName_show();
                    return;
                }
            }
        }
    }

    public an(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.iEk = null;
        this.aCR = null;
        this.aCc = null;
        this.iOa = null;
        this.iOl = null;
        this.guZ = null;
        this.dDa = null;
        this.gqD = null;
        this.iFe = null;
        this.iOJ = null;
        this.hgY = null;
        this.iOU = null;
        this.iPv = 0;
        this.iPG = 0L;
        this.iPG = System.currentTimeMillis();
        this.iEk = pbFragment;
        this.gqD = onClickListener;
        this.dqX = cVar;
        this.iPv = com.baidu.adp.lib.util.l.getEquipmentWidth(this.iEk.getContext()) / 2;
        this.aCR = (RelativeLayout) LayoutInflater.from(this.iEk.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.aCR.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.iOG = this.aCR.findViewById(R.id.bottom_shadow);
        this.gNB = (NavigationBarCoverTip) this.aCR.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.aCc = this.aCR.findViewById(R.id.statebar_view);
        this.iOk = (ObservedChangeRelativeLayout) this.aCR.findViewById(R.id.title_wrapper);
        this.fVd = (NoNetworkView) this.aCR.findViewById(R.id.view_no_network);
        this.iOa = (PbLandscapeListView) this.aCR.findViewById(R.id.new_pb_list);
        this.iOW = (FrameLayout) this.aCR.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.iEk.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.iEk.getActivity(), R.dimen.ds88));
        this.iOa.addHeaderView(this.textView, 0);
        this.iOa.setTextViewAdded(true);
        this.iPm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.aDy = new View(this.iEk.getPageContext().getPageActivity());
        this.aDy.setLayoutParams(new AbsListView.LayoutParams(-1, this.iPm));
        this.aDy.setVisibility(4);
        this.iOa.addFooterView(this.aDy);
        this.iOa.setOnTouchListener(this.iEk.drN);
        this.iNW = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.aCR);
        if (this.iEk.cmT()) {
            this.iNY = (ViewStub) this.aCR.findViewById(R.id.manga_view_stub);
            this.iNY.setVisibility(0);
            this.iNX = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.iNX.show();
            this.iNW.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.iEk.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.iNW.cra().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0568a() { // from class: com.baidu.tieba.pb.pb.main.an.25
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0568a
            public void clm() {
                if (an.this.iOa != null) {
                    if (an.this.iOc != null) {
                        an.this.iOc.cqL();
                    }
                    an.this.iOa.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0568a
            public void cln() {
                an.this.iEk.bEm();
            }
        }));
        this.iOI = this.aCR.findViewById(R.id.view_comment_top_line);
        this.iOJ = this.aCR.findViewById(R.id.pb_editor_tool_comment);
        this.iOQ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iOR = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.hgY = (TextView) this.aCR.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.hgY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                an.this.iEk.cmA();
                if (an.this.iEk != null && an.this.iEk.clC() != null && an.this.iEk.clC().getPbData() != null && an.this.iEk.clC().getPbData().ckv() != null && an.this.iEk.clC().getPbData().ckv().aCo() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cy("tid", an.this.iEk.clC().iKi).cy("fid", an.this.iEk.clC().getPbData().getForumId()).X("obj_locate", 1).cy("uid", an.this.iEk.clC().getPbData().ckv().aCo().getUserId()));
                }
            }
        });
        this.iOK = (ImageView) this.aCR.findViewById(R.id.pb_editor_tool_comment_icon);
        this.iOK.setOnClickListener(this.gqD);
        boolean booleanExtra = this.iEk.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.iOL = (ImageView) this.aCR.findViewById(R.id.pb_editor_tool_collection);
        this.iOL.setOnClickListener(this.gqD);
        if (booleanExtra) {
            this.iOL.setVisibility(8);
        } else {
            this.iOL.setVisibility(0);
        }
        this.iOM = (ImageView) this.aCR.findViewById(R.id.pb_editor_tool_share);
        this.iOM.setOnClickListener(this.gqD);
        this.iON = new com.baidu.tieba.pb.view.c(this.iOM);
        this.iON.cuk();
        this.iOO = (TextView) this.aCR.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.iOU = (ViewStub) this.aCR.findViewById(R.id.interview_status_stub);
        this.iOd = new com.baidu.tieba.pb.pb.main.a.a(this.iEk, cVar);
        this.iOf = new com.baidu.tieba.pb.pb.main.a.d(this.iEk, cVar, this.gqD);
        this.iOl = new f(this.iEk, this.iOa);
        this.iOl.D(this.gqD);
        this.iOl.setTbGestureDetector(this.dqX);
        this.iOl.setOnImageClickListener(this.dMK);
        this.iFe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.27
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
                            an.this.iEk.b(sparseArray);
                            return;
                        }
                        an.this.cA(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        an.this.iEk.b(sparseArray);
                    } else if (booleanValue3) {
                        an.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.iOl.P(this.iFe);
        cpv();
        cpw();
        this.iOf.b(this.iOa);
        this.iOe.b(this.iOa);
        this.iOd.b(this.iOa);
        this.guZ = new PbListView(this.iEk.getPageContext().getPageActivity());
        this.dDa = this.guZ.getView().findViewById(R.id.pb_more_view);
        if (this.dDa != null) {
            this.dDa.setOnClickListener(this.gqD);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.dDa, R.drawable.pb_foot_more_trans_selector);
        }
        this.guZ.setLineVisible();
        this.guZ.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.guZ.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.iOr = this.aCR.findViewById(R.id.viewstub_progress);
        this.iEk.registerListener(this.iPN);
        this.iHk = new PbFakeFloorModel(this.iEk.getPageContext());
        this.iPo = new s(this.iEk.getPageContext(), this.iHk, this.aCR);
        this.iPo.a(this.iEk.iIM);
        this.iHk.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.an.28
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                an.this.iHk.q(postData);
                an.this.iOl.notifyDataSetChanged();
                an.this.iPo.cmk();
                an.this.FO.aMR();
                an.this.qr(false);
            }
        });
        if (this.iEk.clC() != null && !StringUtils.isNull(this.iEk.clC().coh())) {
            this.iEk.showToast(this.iEk.clC().coh());
        }
        this.iOX = this.aCR.findViewById(R.id.pb_expand_blank_view);
        this.iOY = this.aCR.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iOY.getLayoutParams();
        if (this.iEk.clC() != null && this.iEk.clC().cnC()) {
            this.iOX.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.iOY.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = iPa;
            this.iOY.setLayoutParams(layoutParams2);
        }
        this.iOZ = new aj(this.iEk.getPageContext(), this.aCR.findViewById(R.id.pb_reply_expand_view));
        this.iOZ.iNx.setVisibility(8);
        this.iOZ.Q(this.gqD);
        this.iEk.registerListener(this.mAccountChangedListener);
        this.iEk.registerListener(this.iPK);
        cpr();
        ql(false);
    }

    public void qi(boolean z) {
        this.iOG.setVisibility(z ? 0 : 8);
    }

    public void bPy() {
        if (!this.iEk.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").X("obj_locate", 2).cy("fid", this.mForumId));
        } else if (this.iEk.cmC()) {
            com.baidu.tbadk.editortools.pb.e cmp = this.iEk.cmp();
            if (cmp != null && (cmp.aPh() || cmp.aPi())) {
                this.iEk.cmp().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.FO != null) {
                cpB();
            }
            if (this.FO != null) {
                this.iOP = false;
                if (this.FO.mp(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.iEk.getPageContext(), (View) this.FO.mp(2).dwN, false, iPH);
                }
            }
            cqj();
        }
    }

    private void cpr() {
        this.iPB = new com.baidu.tieba.pb.pb.godreply.a(this.iEk, this, (ViewStub) this.aCR.findViewById(R.id.more_god_reply_popup));
        this.iPB.y(this.gqD);
        this.iPB.P(this.iFe);
        this.iPB.setOnImageClickListener(this.dMK);
        this.iPB.y(this.gqD);
        this.iPB.setTbGestureDetector(this.dqX);
    }

    public com.baidu.tieba.pb.pb.godreply.a cps() {
        return this.iPB;
    }

    public View cpt() {
        return this.iOX;
    }

    public void cpu() {
        if (this.iOa != null) {
            this.iOe.c(this.iOa);
            this.iOf.c(this.iOa);
            this.iOg.c(this.iOa);
            this.iOd.c(this.iOa);
        }
    }

    private void cpv() {
        if (this.iOg == null) {
            this.iOg = new com.baidu.tieba.pb.pb.main.a.b(this.iEk, this.gqD);
        }
    }

    private void cpw() {
        if (this.iOe == null) {
            this.iOe = new com.baidu.tieba.pb.pb.main.a.c(this.iEk, this.dqX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpx() {
        if (this.iEk.cmT()) {
            this.iNZ = (ViewStub) this.aCR.findViewById(R.id.manga_mention_controller_view_stub);
            this.iNZ.setVisibility(0);
            if (this.iOh == null) {
                this.iOh = (LinearLayout) this.aCR.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.q.a.a(this.iEk.getPageContext(), this.iOh);
            }
            if (this.iOi == null) {
                this.iOi = (TextView) this.iOh.findViewById(R.id.manga_prev_btn);
            }
            if (this.iOj == null) {
                this.iOj = (TextView) this.iOh.findViewById(R.id.manga_next_btn);
            }
            this.iOi.setOnClickListener(this.gqD);
            this.iOj.setOnClickListener(this.gqD);
        }
    }

    private void cpy() {
        if (this.iEk.cmT()) {
            if (this.iEk.cmW() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iOi, R.color.cp_cont_e, 1);
            }
            if (this.iEk.cmX() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iOj, R.color.cp_cont_e, 1);
            }
        }
    }

    public void cpz() {
        if (this.iOh == null) {
            cpx();
        }
        this.iNZ.setVisibility(8);
        if (this.iPL != null && this.iPM != null) {
            this.iPL.removeCallbacks(this.iPM);
        }
    }

    public void cpA() {
        if (this.iPL != null) {
            if (this.iPM != null) {
                this.iPL.removeCallbacks(this.iPM);
            }
            this.iPM = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.3
                @Override // java.lang.Runnable
                public void run() {
                    if (an.this.iOh == null) {
                        an.this.cpx();
                    }
                    an.this.iNZ.setVisibility(0);
                }
            };
            this.iPL.postDelayed(this.iPM, 2000L);
        }
    }

    public void qj(boolean z) {
        this.iNW.qj(z);
        if (z && this.iOT) {
            this.guZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.iOa.setNextPage(this.guZ);
            this.iNV = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
        this.FO.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.FO.getParent() == null) {
            this.aCR.addView(this.FO, layoutParams);
        }
        this.FO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.FO.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.an.5
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).aJx() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).aJx() == EmotionGroupType.USER_COLLECT) {
                        if (an.this.mPermissionJudgePolicy == null) {
                            an.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        an.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        an.this.mPermissionJudgePolicy.appendRequestPermission(an.this.iEk.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!an.this.mPermissionJudgePolicy.startRequestPermission(an.this.iEk.getBaseFragmentActivity())) {
                            an.this.iEk.cmp().c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            an.this.iEk.cmp().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cph();
        this.iEk.cmp().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.an.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (an.this.FO != null && an.this.FO.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (an.this.iPA == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, an.this.FO.getId());
                            an.this.iPA = new com.baidu.tieba.pb.pb.main.emotion.c(an.this.iEk.getPageContext(), an.this.aCR, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.isEmpty(an.this.iPz)) {
                                an.this.iPA.setData(an.this.iPz);
                            }
                            an.this.iPA.b(an.this.FO);
                        }
                        an.this.iPA.Gl(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (an.this.iEk.iHT != null && an.this.iEk.iHT.cqy() != null) {
                    if (!an.this.iEk.iHT.cqy().cUg()) {
                        an.this.iEk.iHT.qw(false);
                    }
                    an.this.iEk.iHT.cqy().tH(false);
                }
            }
        });
    }

    public void cpB() {
        if (this.iEk != null && this.FO != null) {
            this.FO.display();
            if (this.iEk.cmp() != null) {
                this.iEk.cmp().aOX();
            }
            cqj();
        }
    }

    public void qk(boolean z) {
        if (this.iOa != null && this.textView != null && this.aCc != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.aCc.setVisibility(0);
                } else {
                    this.aCc.setVisibility(8);
                    this.iOa.removeHeaderView(this.textView);
                    this.iOa.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = iPa;
                    this.textView.setLayoutParams(layoutParams);
                }
                cpP();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + qt(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            cpP();
            cqr();
        }
    }

    public f cpC() {
        return this.iOl;
    }

    public void a(PbFragment.c cVar) {
        this.iIR = cVar;
    }

    public void cA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iEk.getContext());
        kVar.setTitleText(this.iEk.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.7
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.iOs.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            an.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (an.this.iPO != null) {
                                an.this.iPO.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            an.this.iEk.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.iEk.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.iEk.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !cqq()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.iEk.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.iEk.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.iEk.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.az(arrayList);
        if (this.iOs == null) {
            this.iOs = new com.baidu.tbadk.core.dialog.i(this.iEk.getPageContext(), kVar);
        } else {
            this.iOs.a(kVar);
        }
        this.iOs.showDialog();
    }

    public void a(PbFragment.b bVar) {
        this.iPO = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.iEk != null && aVar != null) {
            if (this.gQv == null && this.iOd != null) {
                this.gQv = new com.baidu.tieba.NEGFeedBack.e(this.iEk.getPageContext(), this.iOd.cqI());
            }
            AntiData bCZ = this.iEk.bCZ();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bCZ != null && bCZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bCZ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.setFeedBackReasonMap(sparseArray);
            this.gQv.setDefaultReasonArray(new String[]{this.iEk.getString(R.string.delete_thread_reason_1), this.iEk.getString(R.string.delete_thread_reason_2), this.iEk.getString(R.string.delete_thread_reason_3), this.iEk.getString(R.string.delete_thread_reason_4), this.iEk.getString(R.string.delete_thread_reason_5)});
            this.gQv.setData(alVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.gQv.wn(str);
            this.gQv.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.an.8
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    an.this.iEk.a(aVar, jSONArray);
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
        sparseArray.put(iPh, Integer.valueOf(iPi));
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
        this.iOt = new com.baidu.tbadk.core.dialog.a(this.iEk.getActivity());
        if (StringUtils.isNull(str2)) {
            this.iOt.jW(i3);
        } else {
            this.iOt.setOnlyMessageShowCenter(false);
            this.iOt.sS(str2);
        }
        this.iOt.setYesButtonTag(sparseArray);
        this.iOt.a(R.string.dialog_ok, this.iEk);
        this.iOt.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iOt.fG(true);
        this.iOt.b(this.iEk.getPageContext());
        if (z) {
            this.iOt.aEC();
        } else {
            a(this.iOt, i);
        }
    }

    public void aM(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.iOw == null) {
            this.iOw = LayoutInflater.from(this.iEk.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.iEk.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iOw);
        if (this.iOv == null) {
            this.iOv = new Dialog(this.iEk.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iOv.setCanceledOnTouchOutside(true);
            this.iOv.setCancelable(true);
            this.iOE = (ScrollView) this.iOw.findViewById(R.id.good_scroll);
            this.iOv.setContentView(this.iOw);
            WindowManager.LayoutParams attributes = this.iOv.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.iOv.getWindow().setAttributes(attributes);
            this.fMi = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.an.10
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        an.this.iOA = (String) compoundButton.getTag();
                        if (an.this.fMh != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : an.this.fMh) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && an.this.iOA != null && !str.equals(an.this.iOA)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.iOx = (LinearLayout) this.iOw.findViewById(R.id.good_class_group);
            this.iOz = (TextView) this.iOw.findViewById(R.id.dialog_button_cancel);
            this.iOz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.iOv instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(an.this.iOv, an.this.iEk.getPageContext());
                    }
                }
            });
            this.iOy = (TextView) this.iOw.findViewById(R.id.dialog_button_ok);
            this.iOy.setOnClickListener(this.gqD);
        }
        this.iOx.removeAllViews();
        this.fMh = new ArrayList();
        CustomBlueCheckRadioButton ef = ef("0", this.iEk.getPageContext().getString(R.string.thread_good_class));
        this.fMh.add(ef);
        ef.setChecked(true);
        this.iOx.addView(ef);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ad adVar = arrayList.get(i2);
                if (adVar != null && !TextUtils.isEmpty(adVar.aAJ()) && adVar.aAK() > 0) {
                    CustomBlueCheckRadioButton ef2 = ef(String.valueOf(adVar.aAK()), adVar.aAJ());
                    this.fMh.add(ef2);
                    View view = new View(this.iEk.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.iOx.addView(view);
                    this.iOx.addView(ef2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.iOE.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iEk.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iEk.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iEk.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.iOE.setLayoutParams(layoutParams2);
            this.iOE.removeAllViews();
            if (this.iOx != null && this.iOx.getParent() == null) {
                this.iOE.addView(this.iOx);
            }
        }
        com.baidu.adp.lib.f.g.a(this.iOv, this.iEk.getPageContext());
    }

    private CustomBlueCheckRadioButton ef(String str, String str2) {
        Activity pageActivity = this.iEk.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.fMi);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void cpD() {
        this.iEk.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.iEk.hideProgressBar();
        if (z && z2) {
            this.iEk.showToast(this.iEk.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.iEk.showToast(str);
        }
    }

    public void bWt() {
        this.iOr.setVisibility(0);
    }

    public void bWs() {
        this.iOr.setVisibility(8);
    }

    public View cpE() {
        if (this.iOw != null) {
            return this.iOw.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String cpF() {
        return this.iOA;
    }

    public View getView() {
        return this.aCR;
    }

    public void cpG() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.iEk.getPageContext().getPageActivity(), this.iEk.getBaseFragmentActivity().getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.iEk.hideProgressBar();
        if (z) {
            cpZ();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            cqa();
        } else {
            cpZ();
        }
    }

    public void cpH() {
        this.guZ.setLineVisible();
        this.guZ.startLoadData();
    }

    public void cpI() {
        this.iEk.hideProgressBar();
        endLoadData();
        this.iOa.completePullRefreshPostDelayed(0L);
        cpU();
    }

    public void cpJ() {
        this.iOa.completePullRefreshPostDelayed(0L);
        cpU();
    }

    private void ql(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.iOf.b(onLongClickListener);
        this.iOl.setOnLongClickListener(onLongClickListener);
        if (this.iPB != null) {
            this.iPB.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.iHU != null) {
            this.iHU.dismiss();
            this.iHU = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iEk.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.iEk.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iEk.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iEk.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iEk.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.az(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.iOB.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iOB = new com.baidu.tbadk.core.dialog.i(this.iEk.getPageContext(), kVar);
        this.iOB.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.iOB != null) {
            this.iOB.dismiss();
            this.iOB = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iEk.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.iFn != null && this.iFn.ckv() != null && !this.iFn.ckv().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.iEk.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iEk.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.az(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.iOB.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iOB = new com.baidu.tbadk.core.dialog.i(this.iEk.getPageContext(), kVar);
        this.iOB.showDialog();
    }

    public int cpK() {
        return zd(this.iOa.getFirstVisiblePosition());
    }

    private int zd(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.iOa.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.iOa.getAdapter() == null || !(this.iOa.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.iOa.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int cpL() {
        int lastVisiblePosition = this.iOa.getLastVisiblePosition();
        if (this.iOc != null) {
            if (lastVisiblePosition == this.iOa.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return zd(lastVisiblePosition);
    }

    public void ze(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.iOa != null) {
            if (this.iNW == null || this.iNW.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.iNW.mNavigationBar.getFixedNavHeight();
                if (this.iEk.cmJ() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.iOY != null && (layoutParams = (LinearLayout.LayoutParams) this.iOY.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.iOY.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.iOa.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.iOa.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.iOa.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.iOo.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void o(com.baidu.tieba.pb.data.e eVar) {
        int i;
        this.iOl.a(eVar, false);
        this.iOl.notifyDataSetChanged();
        cpU();
        if (this.iPB != null) {
            this.iPB.cly();
        }
        ArrayList<PostData> ckx = eVar.ckx();
        if (eVar.getPage().aBk() == 0 || ckx == null || ckx.size() < eVar.getPage().aBj()) {
            if (com.baidu.tbadk.core.util.v.getCount(ckx) == 0 || (com.baidu.tbadk.core.util.v.getCount(ckx) == 1 && ckx.get(0) != null && ckx.get(0).cLb() == 1)) {
                if (this.iPd == null || this.iPd.iQh == null || this.iPd.iQh.getView() == null) {
                    i = 0;
                } else {
                    i = this.iPd.iQh.getView().getTop() < 0 ? this.iPd.iQh.getView().getHeight() : this.iPd.iQh.getView().getBottom();
                }
                if (this.iEk.cnd()) {
                    this.guZ.ab(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.guZ.ab(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (eVar.getPage().aBk() == 0) {
                    this.guZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.guZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.guZ.aHI();
            }
        }
        q(eVar);
    }

    public void p(com.baidu.tieba.pb.data.e eVar) {
        if (this.iOd != null) {
            this.iOd.e(eVar, this.iEW);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.e eVar, boolean z) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.ckF() != null) {
            return eVar.ckF();
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.ckx())) {
            Iterator<PostData> it = eVar.ckx().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cLb() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.ckC();
        }
        if (!o(postData)) {
            postData = a(eVar);
        }
        if (postData != null && postData.aCo() != null && postData.aCo().getUserTbVipInfoData() != null && postData.aCo().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aCo().getGodUserData().setIntro(postData.aCo().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean o(PostData postData) {
        if (postData == null || postData.aCo() == null) {
            return false;
        }
        MetaData aCo = postData.aCo();
        return (TextUtils.isEmpty(aCo.getUserId()) && TextUtils.isEmpty(aCo.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.ckv() == null || eVar.ckv().aCo() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aCo = eVar.ckv().aCo();
        String userId = aCo.getUserId();
        HashMap<String, MetaData> userMap = eVar.ckv().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aCo;
        }
        postData.Cw(1);
        postData.setId(eVar.ckv().aCE());
        postData.setTitle(eVar.ckv().getTitle());
        postData.setTime(eVar.ckv().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.e eVar, boolean z, int i, int i2) {
        if (eVar != null && eVar.ckv() != null) {
            if (this.iEk.cls()) {
                if (eVar.cku() != null) {
                    this.mForumName = eVar.cku().getForumName();
                    this.mForumId = eVar.cku().getForumId();
                }
                if (this.mForumName == null && this.iEk.clC() != null && this.iEk.clC().clt() != null) {
                    this.mForumName = this.iEk.clC().clt();
                }
            }
            PostData b = b(eVar, z);
            a(b, eVar);
            this.iOf.setVisibility(8);
            if (eVar.aHL()) {
                this.iPs = true;
                this.iNW.qH(true);
                this.iNW.mNavigationBar.hideBottomLine();
                if (this.iOc == null) {
                    this.iOc = new com.baidu.tieba.pb.pb.main.a.e(this.iEk);
                }
                this.iOc.a(eVar, b, this.iOa, this.iOf, this.iOW, this.iNW, this.mForumName, this.iPG);
                this.iOc.R(this.iPQ);
                cpP();
            } else {
                this.iPs = false;
                this.iNW.qH(this.iPs);
                if (this.iOc != null) {
                    this.iOc.c(this.iOa);
                }
            }
            if (this.iEk.cms() != null) {
                this.iEk.cms().qB(this.iPs);
            }
            if (b != null) {
                this.iOS = b;
                this.iOf.setVisibility(0);
                SparseArray<Object> cqK = this.iOf.cqK();
                cqK.put(R.id.tag_clip_board, b);
                cqK.put(R.id.tag_is_subpb, false);
                this.iOg.a(eVar, this.iOa);
                this.iOe.w(eVar);
                this.iOd.e(eVar, this.iEW);
                this.iOd.v(eVar);
                this.iOf.a(this.mSkinType, this.iFn, b, this.iPQ);
                if (this.iOZ != null) {
                    if (eVar.ckT()) {
                        this.iOZ.getView().setVisibility(8);
                    } else {
                        this.iOZ.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.iCP);
                        if (eVar.ckv() != null) {
                            jVar.iCR = eVar.ckv().aCf();
                        }
                        jVar.isNew = !this.iEW;
                        jVar.sortType = eVar.iBQ;
                        jVar.iCT = eVar.ckU();
                        jVar.iCU = this.iEk.cnd();
                        this.iOZ.a(jVar);
                    }
                }
                if (eVar != null && eVar.ckv() != null) {
                    af(eVar.ckv().aCk() == 1, eVar.ckv().aCj() == 1);
                }
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (an.this.iOl != null && an.this.iNW != null && an.this.iNW.iUd != null && an.this.iFn != null && an.this.iFn.ckv() != null && !an.this.iFn.ckv().aBb() && !an.this.cpT() && an.this.iFn.getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(an.this.iFn.getForum().getName())) {
                            if (an.this.iOl.cmg() == null || !an.this.iOl.cmg().isShown()) {
                                an.this.iNW.iUd.setVisibility(0);
                                if (an.this.iEk != null && an.this.iEk.clC() != null) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13400");
                                    anVar.cy("tid", an.this.iEk.clC().cnz());
                                    anVar.cy("fid", an.this.iEk.clC().getForumId());
                                    anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void qm(boolean z) {
        if (z) {
            cpM();
        } else {
            byK();
        }
        this.iPd.iQh = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iPd));
        a(this.iPd.iQh, false);
    }

    public void cpM() {
        if (this.iNW != null && !this.iPu) {
            this.iNW.cpM();
            this.iPu = true;
        }
    }

    public void byK() {
        if (this.iNW != null) {
            this.iNW.cri();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        this.iOf.a(postData, eVar);
    }

    public void cpN() {
        if (this.iOc != null) {
            this.iOc.d(this.iOa);
        }
    }

    public boolean cpO() {
        return this.aqc;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aI(bj bjVar) {
        if (bjVar == null || bjVar.aCo() == null) {
            return false;
        }
        PostData b = b(this.iFn, false);
        String str = "";
        if (b != null && b.aCo() != null) {
            str = b.aCo().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.iNW.crg();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.iNW.DU(dVar.forumName);
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
            final String str2 = dVar.iBI;
            this.iEk.showNetRefreshView(this.aCR, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        ba.aGG().b(an.this.iEk.getPageContext(), new String[]{str2});
                        an.this.iEk.finish();
                        return;
                    }
                    an.this.iEk.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable coS;
        Parcelable coS2;
        if (eVar != null && this.iOa != null) {
            this.iFn = eVar;
            this.mType = i;
            if (eVar.ckv() != null) {
                this.iPf = eVar.ckv().aBV();
                if (eVar.ckv().getAnchorLevel() != 0) {
                    this.aqc = true;
                }
                this.iOD = aI(eVar.ckv());
            }
            if (eVar.getUserData() != null) {
                this.userId = eVar.getUserData().getUserId();
            }
            u(eVar);
            this.iOT = false;
            this.iEW = z;
            cpI();
            if (eVar.iBR != null && eVar.iBR.ckY()) {
                if (this.iOb == null) {
                    this.iOb = new PbThreadPostView(this.iEk.getContext());
                    this.iOa.addHeaderView(this.iOb, 1);
                    this.iOb.setData(eVar);
                    this.iOb.setChildOnClickLinstener(this.gqD);
                }
            } else if (this.iOb != null && this.iOa != null) {
                this.iOa.removeHeaderView(this.iOb);
            }
            a(eVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            r(eVar);
            if (this.iPE == null) {
                this.iPE = new aa(this.iEk.getPageContext(), this.gNB);
            }
            this.iPE.Gb(eVar.ckA());
            if (this.iEk.cmT()) {
                if (this.iOp == null) {
                    this.iOp = new com.baidu.tieba.pb.view.d(this.iEk.getPageContext());
                    this.iOp.createView();
                    this.iOp.setListPullRefreshListener(this.dgV);
                }
                this.iOa.setPullRefresh(this.iOp);
                cpP();
                if (this.iOp != null) {
                    this.iOp.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (eVar.getPage().aBl() == 0 && z) {
                this.iOa.setPullRefresh(null);
            } else {
                if (this.iOp == null) {
                    this.iOp = new com.baidu.tieba.pb.view.d(this.iEk.getPageContext());
                    this.iOp.createView();
                    this.iOp.setListPullRefreshListener(this.dgV);
                }
                this.iOa.setPullRefresh(this.iOp);
                cpP();
                if (this.iOp != null) {
                    this.iOp.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                bqs();
            }
            cpU();
            this.iOl.px(this.iEW);
            this.iOl.py(false);
            this.iOl.pC(i == 5);
            this.iOl.pD(i == 6);
            this.iOl.pE(z2 && this.iPP);
            this.iOl.a(eVar, false);
            this.iOl.notifyDataSetChanged();
            this.iOf.a(b(eVar, z), eVar.ckT());
            if (eVar.ckv() != null && eVar.ckv().aBZ() != null && this.iNU != -1) {
                eVar.ckv().aBZ().setIsLike(this.iNU);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.iOa.setNextPage(this.guZ);
                this.iNV = 2;
                bqs();
            } else {
                this.iOT = true;
                if (eVar.getPage().aBk() == 1) {
                    if (this.iOq == null) {
                        this.iOq = new com.baidu.tieba.pb.view.a(this.iEk, this.iEk);
                    }
                    this.iOa.setNextPage(this.iOq);
                } else {
                    this.iOa.setNextPage(this.guZ);
                }
                this.iNV = 3;
            }
            ArrayList<PostData> ckx = eVar.ckx();
            if (eVar.getPage().aBk() == 0 || ckx == null || ckx.size() < eVar.getPage().aBj()) {
                if (com.baidu.tbadk.core.util.v.getCount(ckx) == 0 || (com.baidu.tbadk.core.util.v.getCount(ckx) == 1 && ckx.get(0) != null && ckx.get(0).cLb() == 1)) {
                    if (this.iPd == null || this.iPd.iQh == null || this.iPd.iQh.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.iPd.iQh.getView().getTop() < 0 ? this.iPd.iQh.getView().getHeight() : this.iPd.iQh.getView().getBottom();
                    }
                    if (this.iEk.cnd()) {
                        this.guZ.ab(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.guZ.ab(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.iEk.cms() != null && !this.iEk.cms().cqU()) {
                        this.iEk.cms().showFloatingView();
                    }
                } else {
                    if (eVar.getPage().aBk() == 0) {
                        this.guZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.guZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.guZ.aHI();
                }
                if (eVar.getPage().aBk() == 0 || ckx == null) {
                    cqe();
                }
            } else {
                if (z2) {
                    if (this.iPP) {
                        endLoadData();
                        if (eVar.getPage().aBk() != 0) {
                            this.guZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.guZ.setLineVisible();
                        this.guZ.showLoading();
                    }
                } else {
                    this.guZ.setLineVisible();
                    this.guZ.showLoading();
                }
                this.guZ.aHI();
            }
            switch (i) {
                case 2:
                    this.iOa.setSelection(i2 > 1 ? (((this.iOa.getData() == null && eVar.ckx() == null) ? 0 : (this.iOa.getData().size() - eVar.ckx().size()) + this.iOa.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (coS2 = ah.coR().coS()) != null && !(coS2 instanceof RecyclerView.SavedState)) {
                        this.iOa.onRestoreInstanceState(coS2);
                        if (com.baidu.tbadk.core.util.v.getCount(ckx) > 1 && eVar.getPage().aBk() > 0) {
                            this.guZ.endLoadData();
                            this.guZ.setText(this.iEk.getString(R.string.pb_load_more_without_point));
                            this.guZ.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.iPP = false;
                    break;
                case 5:
                    this.iOa.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (coS = ah.coR().coS()) != null && !(coS instanceof RecyclerView.SavedState)) {
                        this.iOa.onRestoreInstanceState(coS);
                        break;
                    } else {
                        this.iOa.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.iOc != null && this.iOc.bcL() != null) {
                            if (this.iEk.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.iOa.setSelectionFromTop((this.iOl.cmb() + this.iOa.getHeaderViewsCount()) - 1, this.iOc.cqM() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.iEk.getPageContext().getPageActivity()));
                            } else {
                                this.iOa.setSelectionFromTop((this.iOl.cmb() + this.iOa.getHeaderViewsCount()) - 1, this.iOc.cqM());
                            }
                        } else {
                            this.iOa.setSelection(this.iOl.cmb() + this.iOa.getHeaderViewsCount());
                        }
                    } else {
                        this.iOa.setSelection(i2 > 0 ? ((this.iOa.getData() == null && eVar.ckx() == null) ? 0 : (this.iOa.getData().size() - eVar.ckx().size()) + this.iOa.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.guZ.endLoadData();
                    this.guZ.setText(this.iEk.getString(R.string.pb_load_more_without_point));
                    this.guZ.setLineGone();
                    break;
            }
            if (this.iPf == iPg && isHost()) {
                cqm();
            }
            if (this.iPq) {
                cpf();
                this.iPq = false;
                if (i3 == 0) {
                    qf(true);
                }
            }
            if (eVar.iBN == 1 || eVar.iBO == 1) {
                if (this.iPw == null) {
                    this.iPw = new PbTopTipView(this.iEk.getContext());
                }
                if (eVar.iBO == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.iEk.getStType())) {
                    this.iPw.setText(this.iEk.getString(R.string.pb_read_strategy_add_experience));
                    this.iPw.a(this.aCR, this.mSkinType);
                } else if (eVar.iBN == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.iEk.getStType())) {
                    this.iPw.setText(this.iEk.getString(R.string.pb_read_news_add_experience));
                    this.iPw.a(this.aCR, this.mSkinType);
                }
            }
            q(eVar);
        }
    }

    private void q(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckv() != null) {
            t(eVar);
            if (eVar.ayL()) {
                SvgManager.aGC().a(this.iOL, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aGC().a(this.iOL, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iOO.setText(zf(eVar.ckv().aCf()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.ckv()));
        }
    }

    private String zf(int i) {
        if (i == 0) {
            return this.iEk.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void cpP() {
        if (this.iOc != null) {
            this.iOc.a(this.iOa, this.textView, this.mType);
        }
    }

    public void qn(boolean z) {
        this.iOC = z;
    }

    public void endLoadData() {
        if (this.guZ != null) {
            this.guZ.setLineGone();
            this.guZ.endLoadData();
        }
        bqs();
    }

    public void bgz() {
        this.iOa.setVisibility(0);
    }

    public void cpQ() {
        if (this.iOa != null) {
            this.iOa.setVisibility(8);
        }
        if (this.iOa != null) {
            this.iOW.setVisibility(8);
        }
        if (this.iNW != null && this.iNW.iUa != null) {
            this.iNW.iUa.setVisibility(8);
        }
    }

    public void cpR() {
        if (this.iOa != null) {
            this.iOa.setVisibility(0);
        }
        if (this.iOW != null) {
            this.iOW.setVisibility(0);
        }
        if (this.iNW != null && this.iNW.iUa != null) {
            this.iNW.iUa.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void r(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && this.iOS != null && this.iOS.aCo() != null && this.iNW != null) {
            this.iPt = !this.iPs;
            this.iNW.qD(this.iPt);
            if (this.iEk.cms() != null) {
                this.iEk.cms().qC(this.iPt);
            }
            cpS();
            if (this.iEk != null && !this.iEk.cls() && !com.baidu.tbadk.core.util.v.isEmpty(eVar.ckO())) {
                bf bfVar = eVar.ckO().get(0);
                if (bfVar != null) {
                    this.iNW.eg(bfVar.getForumName(), bfVar.getAvatar());
                }
            } else if (eVar.getForum() != null) {
                this.iNW.eg(eVar.getForum().getName(), eVar.getForum().getImage_url());
            }
            if (this.iPt) {
                this.iOf.a(eVar, this.iOS, this.iOD);
                if (this.iOY != null) {
                    this.iOY.setVisibility(8);
                }
                if (this.iPC == null) {
                    this.iPC = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.an.18
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (an.this.iEk != null && an.this.iEk.isAdded()) {
                                if (i < 0 && f > an.this.iPv) {
                                    an.this.cql();
                                }
                                an.this.cpJ();
                            }
                        }
                    };
                }
                this.iOa.setListViewDragListener(this.iPC);
                return;
            }
            if (this.iOY != null) {
                this.iOY.setVisibility(0);
            }
            this.iOf.a(eVar, this.iOS, this.iOD);
            this.iPC = null;
            this.iOa.setListViewDragListener(null);
        }
    }

    private void cpS() {
        this.iOf.a(this.iFn, this.iOS, this.iPt, this.iPs);
    }

    public boolean cpT() {
        return this.iFn == null || this.iFn.getForum() == null || "0".equals(this.iFn.getForum().getId()) || "me0407".equals(this.iFn.getForum().getName());
    }

    private boolean cpU() {
        return this.iOd.qy(this.iEW);
    }

    private boolean s(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.ckv() == null) {
            return false;
        }
        if (eVar.ckv().aCl() == 1 || eVar.ckv().getThreadType() == 33) {
            return true;
        }
        return !(eVar.ckv().aCn() == null || eVar.ckv().aCn().aEt() == 0) || eVar.ckv().aCj() == 1 || eVar.ckv().aCk() == 1 || eVar.ckv().aCZ() || eVar.ckv().aDs() || eVar.ckv().aDm() || eVar.ckv().aCA() != null || !com.baidu.tbadk.core.util.aq.isEmpty(eVar.ckv().getCategory()) || eVar.ckv().aCr() || eVar.ckv().aCq();
    }

    public boolean c(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            if (this.iOe != null) {
                if (eVar.ckv() != null && eVar.ckv().aCD() == 0 && !eVar.ckv().aBb() && !this.iPI) {
                    if (eVar.ckv() != null) {
                        bj ckv = eVar.ckv();
                        ckv.t(true, s(eVar));
                        ckv.jI(3);
                        ckv.sF("2");
                    }
                    if (eVar.ckv().aBd()) {
                        this.iOf.c(this.iOa);
                        this.iOe.c(this.iOa);
                        this.iOe.b(this.iOa);
                        this.iOf.b(this.iOa);
                        this.iOf.B(this.iFn);
                        this.iOe.x(eVar);
                    } else {
                        this.iOf.B(this.iFn);
                        this.iOe.z(eVar);
                    }
                } else if (eVar.ckv().aCD() == 1) {
                    if (eVar.ckv() != null) {
                        this.iOe.c(this.iOa);
                        this.iOf.B(this.iFn);
                    }
                } else {
                    this.iOe.c(this.iOa);
                    this.iOf.B(this.iFn);
                }
            }
            if (eVar.ckv() != null) {
                ae(eVar.ckv().aCk() == 1, eVar.ckv().aCj() == 1);
            }
            this.iEW = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            c(eVar, z);
            cpU();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.w wVar;
        StringBuilder sb = null;
        if (eVar != null && (b = b(eVar, z)) != null) {
            String userId = b.aCo().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.ckH()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.aCo() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.aCo().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.aCo().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.aCo().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.ckH()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bf> ckO = eVar.ckO();
                if (com.baidu.tbadk.core.util.v.getCount(ckO) > 0) {
                    sb = new StringBuilder();
                    for (bf bfVar : ckO) {
                        if (bfVar != null && !StringUtils.isNull(bfVar.getForumName()) && (wVar = bfVar.cQQ) != null && wVar.cOK && !wVar.cOL && (wVar.type == 1 || wVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bfVar.getForumName(), 12)).append(this.iEk.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.iEk.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View cpV() {
        return this.dDa;
    }

    public boolean cpW() {
        if (this.aDy == null || this.aDy.getParent() == null || this.guZ.isLoading()) {
            return false;
        }
        int bottom = this.aDy.getBottom();
        Rect rect = new Rect();
        this.aDy.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Gd(String str) {
        if (this.guZ != null) {
            this.guZ.setText(str);
        }
    }

    public void Ge(String str) {
        if (this.guZ != null) {
            int i = 0;
            if (this.iPd != null && this.iPd.iQh != null && this.iPd.iQh.getView() != null) {
                i = this.iPd.iQh.getView().getTop() < 0 ? this.iPd.iQh.getView().getHeight() : this.iPd.iQh.getView().getBottom();
            }
            this.guZ.ab(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.iOa;
    }

    public int cpX() {
        return R.id.richText;
    }

    public TextView clM() {
        return this.iOf.clM();
    }

    public void d(BdListView.e eVar) {
        this.iOa.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.dgV = cVar;
        if (this.iOp != null) {
            this.iOp.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ap apVar, a.b bVar) {
        if (apVar != null) {
            int aBi = apVar.aBi();
            int aBf = apVar.aBf();
            if (this.iOm != null) {
                this.iOm.aEC();
            } else {
                this.iOm = new com.baidu.tbadk.core.dialog.a(this.iEk.getPageContext().getPageActivity());
                this.iOn = LayoutInflater.from(this.iEk.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.iOm.aO(this.iOn);
                this.iOm.a(R.string.dialog_ok, bVar);
                this.iOm.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.19
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        an.this.cpZ();
                        aVar.dismiss();
                    }
                });
                this.iOm.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.an.20
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (an.this.iPn == null) {
                            an.this.iPn = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.20.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    an.this.iEk.HidenSoftKeyPad((InputMethodManager) an.this.iEk.getBaseFragmentActivity().getSystemService("input_method"), an.this.aCR);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.gx().postDelayed(an.this.iPn, 150L);
                    }
                });
                this.iOm.b(this.iEk.getPageContext()).aEC();
            }
            this.iOo = (EditText) this.iOn.findViewById(R.id.input_page_number);
            this.iOo.setText("");
            TextView textView = (TextView) this.iOn.findViewById(R.id.current_page_number);
            if (aBi <= 0) {
                aBi = 1;
            }
            if (aBf <= 0) {
                aBf = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(aBi), Integer.valueOf(aBf)));
            this.iEk.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.iOo, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.iOa.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.iEk.showToast(str);
    }

    public boolean qo(boolean z) {
        if (this.FO == null || !this.FO.aOw()) {
            return false;
        }
        this.FO.aMR();
        return true;
    }

    public void cpY() {
        if (this.iPR != null) {
            while (this.iPR.size() > 0) {
                TbImageView remove = this.iPR.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        cpY();
        this.iOl.yH(1);
        if (this.iOc != null) {
            this.iOc.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.iOl.yH(2);
        if (this.iOc != null) {
            this.iOc.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.iEk.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.iEk.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.iON != null) {
            this.iON.onDestroy();
        }
        if (this.iPp != null) {
            this.iPp.destroy();
        }
        if (this.iPE != null) {
            this.iPE.onDestory();
        }
        if (this.iPw != null) {
            this.iPw.hide();
        }
        this.iEk.hideProgressBar();
        if (this.fVd != null && this.glY != null) {
            this.fVd.b(this.glY);
        }
        cpZ();
        endLoadData();
        if (this.iPn != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iPn);
        }
        if (this.iOV != null) {
            this.iOV.clearStatus();
        }
        this.iPL = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.iOl.yH(3);
        if (this.aCc != null) {
            this.aCc.setBackgroundDrawable(null);
        }
        if (this.iOc != null) {
            this.iOc.destroy();
        }
        if (this.iOl != null) {
            this.iOl.onDestroy();
        }
        this.iOa.setOnLayoutListener(null);
        if (this.iPA != null) {
            this.iPA.bGw();
        }
        if (this.iPe != null) {
            this.iPe.onDestroy();
        }
        if (this.iOf != null) {
            this.iOf.onDestroy();
        }
    }

    public boolean zg(int i) {
        if (this.iOc != null) {
            return this.iOc.zg(i);
        }
        return false;
    }

    public void cpZ() {
        this.iNW.arU();
        if (this.iOf != null) {
            this.iOf.cpZ();
        }
        if (this.iEk != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.iEk.getContext(), this.iOo);
        }
        cph();
        if (this.iHU != null) {
            this.iHU.dismiss();
        }
        cqb();
        if (this.iOm != null) {
            this.iOm.dismiss();
        }
        if (this.gqC != null) {
            this.gqC.dismiss();
        }
    }

    public void cqa() {
        this.iNW.arU();
        if (this.iOf != null) {
            this.iOf.cpZ();
        }
        if (this.iHU != null) {
            this.iHU.dismiss();
        }
        cqb();
        if (this.iOm != null) {
            this.iOm.dismiss();
        }
        if (this.gqC != null) {
            this.gqC.dismiss();
        }
    }

    public void dH(List<String> list) {
        this.iPz = list;
        if (this.iPA != null) {
            this.iPA.setData(list);
        }
    }

    public void pw(boolean z) {
        this.iOl.pw(z);
    }

    public void qp(boolean z) {
        this.iOF = z;
    }

    public void cqb() {
        if (this.iOt != null) {
            this.iOt.dismiss();
        }
        if (this.iOu != null) {
            com.baidu.adp.lib.f.g.b(this.iOu, this.iEk.getPageContext());
        }
        if (this.iOv != null) {
            com.baidu.adp.lib.f.g.b(this.iOv, this.iEk.getPageContext());
        }
        if (this.iOs != null) {
            this.iOs.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.iFn, this.iEW);
            b(this.iFn, this.iEW, this.mType, i);
            this.iEk.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.iEk.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.aCR);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.aCR, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.iOG, R.drawable.personalize_tab_shadow);
            if (this.iOc != null) {
                this.iOc.onChangeSkinType(i);
            }
            if (this.iOg != null) {
                this.iOg.onChangeSkinType(i);
            }
            if (this.iOd != null) {
                this.iOd.onChangeSkinType(i);
            }
            if (this.iOe != null) {
                this.iOe.onChangeSkinType(i);
            }
            if (this.iOf != null) {
                this.iOf.onChangeSkinType(i);
            }
            if (this.guZ != null) {
                this.guZ.changeSkin(i);
                if (this.dDa != null) {
                    this.iEk.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.dDa);
                    com.baidu.tbadk.core.util.am.setBackgroundResource(this.dDa, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.iOm != null) {
                this.iOm.c(this.iEk.getPageContext());
            }
            qn(this.iOC);
            this.iOl.notifyDataSetChanged();
            if (this.iOp != null) {
                this.iOp.changeSkin(i);
            }
            if (this.FO != null) {
                this.FO.onChangeSkinType(i);
            }
            if (this.iOq != null) {
                this.iOq.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.fMh)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.fMh) {
                    customBlueCheckRadioButton.aHv();
                }
            }
            cpy();
            UtilHelper.setStatusBarBackground(this.aCc, i);
            UtilHelper.setStatusBarBackground(this.iOY, i);
            if (this.iOh != null) {
                com.baidu.tbadk.q.a.a(this.iEk.getPageContext(), this.iOh);
            }
            if (this.iPo != null) {
                this.iPo.onChangeSkinType(i);
            }
            if (this.iNW != null) {
                if (this.iOc != null) {
                    this.iOc.zh(i);
                } else {
                    this.iNW.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.hgY != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hgY, (int) R.color.cp_cont_d);
                this.hgY.setBackgroundDrawable(com.baidu.tbadk.core.util.am.ay(com.baidu.adp.lib.util.l.getDimens(this.iEk.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_j)));
            }
            if (this.iOL != null && this.iFn != null) {
                if (this.iFn.ayL()) {
                    SvgManager.aGC().a(this.iOL, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.aGC().a(this.iOL, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            t(this.iFn);
            if (this.iOK != null) {
                SvgManager.aGC().a(this.iOK, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.iOI != null) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iOI, R.drawable.bottom_shadow);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iOO, (int) R.color.cp_cont_b);
            if (this.iPB != null) {
                this.iPB.onChangeSkinType(i);
            }
            if (this.iPe != null) {
                this.iPe.onChangeSkinType();
            }
            if (this.iPy != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iPy, (int) R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iOJ, R.color.cp_bg_line_h);
            if (this.iOb != null) {
                this.iOb.pk(i);
            }
        }
    }

    public void cqc() {
        if (this.iON != null) {
            this.iON.setEnable(false);
        }
    }

    public void t(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.aY(eVar.ckv())) {
            if (this.iON != null) {
                this.iON.setEnable(false);
                this.iON.onDestroy();
            }
            SvgManager.aGC().a(this.iOM, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.iON == null || !this.iON.isEnable()) {
            SvgManager.aGC().a(this.iOM, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMK = iVar;
        this.iOl.setOnImageClickListener(this.dMK);
        this.iPB.setOnImageClickListener(this.dMK);
    }

    public void g(NoNetworkView.a aVar) {
        this.glY = aVar;
        if (this.fVd != null) {
            this.fVd.a(this.glY);
        }
    }

    public void qq(boolean z) {
        this.iOl.setIsFromCDN(z);
    }

    public Button cqd() {
        return this.iOH;
    }

    public void cqe() {
        if (this.iNV != 2) {
            this.iOa.setNextPage(this.guZ);
            this.iNV = 2;
        }
    }

    public void cqf() {
        if (com.baidu.tbadk.n.m.aRm().aRn()) {
            int lastVisiblePosition = this.iOa.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.iOa.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.dDI = true;
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
                        perfLog2.dDI = true;
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

    public boolean cqg() {
        return this.FO != null && this.FO.getVisibility() == 0;
    }

    public boolean cqh() {
        return this.FO != null && this.FO.aOw();
    }

    public void cqi() {
        if (this.FO != null) {
            this.FO.aMR();
        }
    }

    public void qr(boolean z) {
        if (this.iOJ != null) {
            qp(this.iEk.cmp().aPa());
            if (this.iOF) {
                qg(z);
            } else {
                qh(z);
            }
        }
    }

    public void cqj() {
        if (this.iOJ != null) {
            this.iOI.setVisibility(8);
            this.iOJ.setVisibility(8);
            this.iOP = false;
            if (this.iPe != null) {
                this.iPe.setVisibility(8);
                ql(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.fQi == null) {
            this.fQi = new com.baidu.tbadk.core.view.a(this.iEk.getPageContext());
        }
        this.fQi.setDialogVisiable(true);
    }

    public void bqs() {
        if (this.fQi != null) {
            this.fQi.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.iOa.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.iOa.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.iOc != null) {
            this.iOc.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.iPS = getScrollY();
            this.iPd.iQh = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iPd));
            a(this.iPd.iQh, true);
        }
    }

    public void qs(boolean z) {
        if (this.iOc != null) {
            this.iOc.qs(z);
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
        if (this.iOc != null) {
            this.iOc.onScroll(absListView, i, i2, i3);
        }
        if (this.iNW != null && this.iOl != null) {
            this.iNW.cC(this.iOl.cmg());
        }
        this.iPd.ixg = i;
        this.iPd.headerCount = this.iOa.getHeaderViewsCount();
        this.iPd.iQh = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iPd));
        qi(b(absListView, i));
        a(this.iPd.iQh, false);
        if (this.guZ.aHJ() && !this.guZ.dgN) {
            if (this.iPd != null && this.iPd.iQh != null && this.iPd.iQh.getView() != null) {
                i4 = this.iPd.iQh.getView().getTop() < 0 ? this.iPd.iQh.getView().getHeight() : this.iPd.iQh.getView().getBottom();
            }
            this.guZ.lk(i4);
            this.guZ.dgN = true;
        }
    }

    public void cqk() {
        if (TbadkCoreApplication.isLogin() && this.iFn != null && this.iPt && !this.iPs && !this.iOD && this.iOS != null && this.iOS.aCo() != null && !this.iOS.aCo().getIsLike() && !this.iOS.aCo().hadConcerned() && this.iPp == null) {
            this.iPp = new ak(this.iEk);
        }
    }

    public void cql() {
        if (this.iPt && !this.iPs && this.iOS != null && this.iOS.aCo() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").X("obj_locate", this.iEk.cls() ? 2 : 1).X("obj_type", this.iPs ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.iEk.getPageContext().getPageActivity(), this.iOS.aCo().getUserId(), this.iOS.aCo().getUserName(), this.iEk.clC().clt(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(aj ajVar, boolean z) {
        int measuredHeight;
        if (!this.iPs && this.iOX != null && this.iNW.cra() != null) {
            int cmc = this.iOl.cmc();
            if (cmc > 0 && (ajVar == null || ajVar.getView().getParent() == null)) {
                if (cmc > this.iOa.getFirstVisiblePosition() - this.iOa.getHeaderViewsCount()) {
                    this.iOX.setVisibility(8);
                    return;
                }
                this.iOX.setVisibility(0);
                qi(false);
                this.iNW.mNavigationBar.hideBottomLine();
                if (this.iOX.getParent() != null && ((ViewGroup) this.iOX.getParent()).getHeight() <= this.iOX.getTop()) {
                    this.iOX.getParent().requestLayout();
                }
            } else if (ajVar == null || ajVar.getView() == null || ajVar.iNx == null) {
                if (this.iOa.getFirstVisiblePosition() == 0) {
                    this.iOX.setVisibility(8);
                    this.iNW.mNavigationBar.hideBottomLine();
                }
            } else {
                int top2 = ajVar.getView().getTop();
                if (ajVar.getView().getParent() != null) {
                    if (this.iPc) {
                        this.iPb = top2;
                        this.iPc = false;
                    }
                    this.iPb = top2 < this.iPb ? top2 : this.iPb;
                }
                if (top2 != 0 || ajVar.getView().isShown()) {
                    if (this.iOk.getY() < 0.0f) {
                        measuredHeight = iPa - ajVar.iNx.getMeasuredHeight();
                    } else {
                        measuredHeight = this.iNW.cra().getMeasuredHeight() - ajVar.iNx.getMeasuredHeight();
                        this.iNW.mNavigationBar.hideBottomLine();
                    }
                    if (ajVar.getView().getParent() == null && top2 <= this.iPb) {
                        this.iOX.setVisibility(0);
                        qi(false);
                    } else if (top2 < measuredHeight) {
                        this.iOX.setVisibility(0);
                        qi(false);
                    } else {
                        this.iOX.setVisibility(8);
                        this.iNW.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.iPc = true;
                    }
                }
            }
        }
    }

    public void cqm() {
        if (!this.iPT) {
            TiebaStatic.log("c10490");
            this.iPT = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iEk.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(iPh, Integer.valueOf(iPj));
            aVar.jV(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.iEk.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aO(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.iEk);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.21
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iEk.getPageContext()).aEC();
        }
    }

    public void Gf(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iEk.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.iEk.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aO(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(iPh, Integer.valueOf(iPk));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.iEk);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iEk.getPageContext()).aEC();
    }

    public void a(int i, com.baidu.tieba.pb.data.e eVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(eVar, z)) != null && b.aCo() != null) {
            MetaData aCo = b.aCo();
            aCo.setGiftNum(aCo.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, int i, int i2) {
        a(eVar, z, i, i2);
        r(eVar);
    }

    public PbInterviewStatusView cqn() {
        return this.iOV;
    }

    private void u(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckv() != null && eVar.ckv().aDs() && this.iOV == null) {
            this.iOV = (PbInterviewStatusView) this.iOU.inflate();
            this.iOV.setOnClickListener(this.gqD);
            this.iOV.setCallback(this.iEk.cnb());
            this.iOV.setData(this.iEk, eVar);
        }
    }

    public RelativeLayout cqo() {
        return this.iOk;
    }

    public View cqp() {
        return this.aCc;
    }

    public boolean cqq() {
        return this.iPI;
    }

    public void pB(boolean z) {
        this.iOf.pB(z);
    }

    public void Gg(String str) {
        if (this.iNX != null) {
            this.iNX.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int qt(boolean z) {
        if (this.iOV == null || this.iOV.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void cqr() {
        if (this.iOV != null && this.iOV.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iOV.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.iOV.setLayoutParams(layoutParams);
        }
    }

    public boolean cmv() {
        return false;
    }

    public void Gh(String str) {
        this.hgY.performClick();
        if (!StringUtils.isNull(str) && this.iEk.cmp() != null && this.iEk.cmp().aOT() != null && this.iEk.cmp().aOT().getInputView() != null) {
            EditText inputView = this.iEk.cmp().aOT().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            cpZ();
            if (configuration.orientation == 2) {
                cqj();
                cph();
            } else {
                cpl();
            }
            if (this.iPo != null) {
                this.iPo.cmk();
            }
            this.iEk.bEm();
            this.iOk.setVisibility(8);
            this.iNW.qE(false);
            this.iEk.pP(false);
            if (this.iOc != null) {
                if (configuration.orientation == 1) {
                    cqo().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.iOa.setIsLandscape(true);
                    this.iOa.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.iOa.setIsLandscape(false);
                    if (this.iPS > 0) {
                        this.iOa.smoothScrollBy(this.iPS, 0);
                    }
                }
                this.iOc.onConfigurationChanged(configuration);
                this.iOW.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void qu(boolean z) {
        if (this.iOc != null) {
            this.iOc.qu(z);
        }
    }

    public boolean cqs() {
        return this.iOc != null && this.iOc.cqs();
    }

    public void cqt() {
        if (this.iOc != null) {
            this.iOc.cqt();
        }
    }

    public void pF(boolean z) {
        this.iOl.pF(z);
    }

    public void cB(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.iOJ.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.iEk.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.iPy = new TextView(this.iEk.getContext());
            this.iPy.setText(R.string.connection_tips);
            this.iPy.setGravity(17);
            this.iPy.setPadding(com.baidu.adp.lib.util.l.getDimens(this.iEk.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.iEk.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.iEk.getContext(), R.dimen.ds60);
            if (this.iPy.getParent() == null) {
                frameLayout.addView(this.iPy, layoutParams);
            }
            this.iPx = new PopupWindow(this.iEk.getContext());
            this.iPx.setContentView(frameLayout);
            this.iPx.setHeight(-2);
            this.iPx.setWidth(-2);
            this.iPx.setFocusable(true);
            this.iPx.setOutsideTouchable(false);
            this.iPx.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.iOa.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.24
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        an.this.iPx.showAsDropDown(an.this.iOJ, view.getLeft(), -an.this.iOJ.getHeight());
                    } else {
                        an.this.iPx.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void qv(boolean z) {
        this.iPD = z;
    }

    public boolean cqu() {
        return this.iPD;
    }

    public PbThreadPostView cqv() {
        return this.iOb;
    }

    private void ae(boolean z, boolean z2) {
        af(z, z2);
        if (this.iFn != null && this.iFn.ckv() != null && this.iFn.ckv().aCD() == 0 && !this.iFn.ckv().aBb()) {
            ag(z, z2);
        } else if (this.iOl != null && this.iOl.cmh() != null) {
            this.iOl.cmh().b(this.iFn, z, z2);
        }
    }

    private void af(boolean z, boolean z2) {
        this.iOf.d(this.iFn, z, z2);
    }

    private void ag(boolean z, boolean z2) {
        this.iOe.c(this.iFn, z, z2);
    }
}
