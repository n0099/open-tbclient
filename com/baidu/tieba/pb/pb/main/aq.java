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
/* loaded from: classes7.dex */
public class aq {
    private EditorTools Fv;
    private View axK;
    private RelativeLayout ayz;
    private View azg;
    private g.c dcC;
    private com.baidu.tieba.pb.a.c dmA;
    private View dyM;
    private List<CustomBlueCheckRadioButton> fJv;
    private NoNetworkView fSu;
    private NavigationBarCoverTip gLo;
    private com.baidu.tieba.NEGFeedBack.e gOh;
    private View.OnClickListener gon;
    private PbListView gsK;
    private TextView heK;
    private PbFragment iCe;
    private View.OnClickListener iDj;
    private com.baidu.tieba.pb.data.f iDs;
    private PbFakeFloorModel iFs;
    PbFragment.c iHa;
    private TextView iMA;
    private TextView iMB;
    private ObservedChangeRelativeLayout iMC;
    private f iMD;
    private View iMJ;
    private View iMY;
    public int iMm;
    public final com.baidu.tieba.pb.pb.main.view.c iMo;
    public com.baidu.tieba.pb.pb.main.view.b iMp;
    private ViewStub iMq;
    private ViewStub iMr;
    private PbLandscapeListView iMs;
    private PbThreadPostView iMt;
    private com.baidu.tieba.pb.pb.main.a.e iMu;
    private com.baidu.tieba.pb.pb.main.a.a iMv;
    private com.baidu.tieba.pb.pb.main.a.c iMw;
    private com.baidu.tieba.pb.pb.main.a.d iMx;
    private com.baidu.tieba.pb.pb.main.a.b iMy;
    private LinearLayout iMz;
    private int iND;
    private Runnable iNE;
    private t iNF;
    private an iNG;
    private int iNM;
    private PbTopTipView iNN;
    private PopupWindow iNO;
    private TextView iNP;
    private List<String> iNQ;
    private com.baidu.tieba.pb.pb.main.emotion.c iNR;
    private com.baidu.tieba.pb.pb.godreply.a iNS;
    private PbLandscapeListView.b iNT;
    private ad iNV;
    private String iNW;
    private long iNX;
    private boolean iNZ;
    private View iNa;
    private View iNb;
    private ImageView iNc;
    private ImageView iNd;
    private ImageView iNe;
    private TextView iNf;
    private int iNh;
    private int iNi;
    private PostData iNj;
    private ViewStub iNl;
    private PbInterviewStatusView iNm;
    private FrameLayout iNn;
    private View iNo;
    private View iNp;
    private am iNq;
    private PbEmotionBar iNv;
    private Runnable iOd;
    private PbFragment.b iOf;
    public int iOj;
    private boolean isLandscape;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int iNr = UtilHelper.getLightStatusBarHeight();
    public static int iNx = 3;
    public static int iNy = 0;
    public static int iNz = 3;
    public static int iNA = 4;
    public static int iNB = 5;
    public static int iNC = 6;
    private static a.InterfaceC0602a iNY = new a.InterfaceC0602a() { // from class: com.baidu.tieba.pb.pb.main.aq.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0602a
        public void onRefresh() {
        }
    };
    private int iMn = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a iME = null;
    private com.baidu.tbadk.core.dialog.b gom = null;
    private View iMF = null;
    private EditText iMG = null;
    private com.baidu.tieba.pb.view.c iMH = null;
    private com.baidu.tieba.pb.view.a iMI = null;
    private b.a hBt = null;
    private TbRichTextView.i dIr = null;
    private NoNetworkView.a gjI = null;
    private com.baidu.tbadk.core.dialog.i iMK = null;
    private com.baidu.tbadk.core.dialog.a iML = null;
    private Dialog iMM = null;
    private Dialog iMN = null;
    private View iMO = null;
    private LinearLayout iMP = null;
    private CompoundButton.OnCheckedChangeListener fJw = null;
    private TextView iMQ = null;
    private TextView iMR = null;
    private String iMS = null;
    private com.baidu.tbadk.core.dialog.i iGc = null;
    private com.baidu.tbadk.core.dialog.i iMT = null;
    private boolean iMU = false;
    private boolean iMV = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView iMW = null;
    private boolean iMX = false;
    private Button iMZ = null;
    private boolean iNg = true;
    private com.baidu.tbadk.core.view.a fNy = null;
    private boolean iDb = false;
    private int mSkinType = 3;
    private boolean iNk = false;
    private int iNs = 0;
    private boolean iNt = true;
    public a iNu = new a();
    private int iNw = 0;
    private boolean iNH = false;
    private int iNI = 0;
    private boolean iNJ = false;
    private boolean iNK = false;
    private boolean iNL = false;
    private boolean iNU = false;
    private String iOa = null;
    private CustomMessageListener iOb = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.aq.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                aq.this.iOa = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && aq.this.iMD != null) {
                aq.this.iMD.notifyDataSetChanged();
            }
        }
    };
    private Handler iOc = new Handler();
    private CustomMessageListener iOe = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.aq.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                aq.this.iNg = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean iOg = true;
    View.OnClickListener iOh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || aq.this.iDs == null || aq.this.iDs.ciS() == null || aq.this.iDs.ciS().azX() == null || aq.this.iDs.ciS().azX().getAlaUserData() == null || aq.this.iDs.ciS().azX().getAlaUserData().live_status != 1 || aq.this.iDs.ciS().azX().getAlaUserData().live_id <= 0) {
                if (aq.this.iNJ) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").Z("obj_id", 2));
                }
                if (!aq.this.iNJ && aq.this.iDs != null && aq.this.iDs.ciS() != null && aq.this.iDs.ciS().azX() != null && aq.this.iDs.ciS().azX().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").Z("obj_locate", 1));
                }
                if (aq.this.iCe.clM() != null) {
                    aq.this.iCe.clM().iCz.gOU.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c11851");
            anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(anVar);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = aq.this.iDs.ciS().azX().getAlaUserData().live_id;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(aq.this.iCe.clM(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
        }
    };
    private boolean eCM = false;
    String userId = null;
    private final List<TbImageView> iOi = new ArrayList();
    private boolean iOk = false;

    /* loaded from: classes7.dex */
    public static class a {
        public int headerCount;
        public am iOy;
        public int iuX;
    }

    public void qc(boolean z) {
        this.iNH = z;
        if (this.iMs != null) {
            this.iNI = this.iMs.getHeaderViewsCount();
        }
    }

    public void cnL() {
        if (this.iMs != null) {
            int headerViewsCount = this.iMs.getHeaderViewsCount() - this.iNI;
            final int firstVisiblePosition = (this.iMs.getFirstVisiblePosition() == 0 || this.iMs.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.iMs.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.iMs.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.iNu.iOy = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iNu));
            final am amVar = this.iNu.iOy;
            final int h = h(amVar);
            final int y = ((int) this.iMC.getY()) + this.iMC.getMeasuredHeight();
            final boolean z = this.iNo.getVisibility() == 0;
            boolean z2 = this.iMC.getY() < 0.0f;
            if ((z && amVar != null) || firstVisiblePosition >= this.iMD.ckE() + this.iMs.getHeaderViewsCount()) {
                int measuredHeight = amVar != null ? amVar.iLO.getMeasuredHeight() : 0;
                if (z2) {
                    this.iMs.setSelectionFromTop(this.iMD.ckE() + this.iMs.getHeaderViewsCount(), iNr - measuredHeight);
                } else {
                    this.iMs.setSelectionFromTop(this.iMD.ckE() + this.iMs.getHeaderViewsCount(), this.iMo.cpE().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.iMs.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.iNJ && this.iMu != null) {
                this.iMs.setSelectionFromTop(this.iMD.ckE() + this.iMs.getHeaderViewsCount(), this.iMu.cpr());
            } else if (this.mType == 6) {
                this.iMs.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.aq.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void clW() {
                        ViewGroup.LayoutParams layoutParams;
                        if (h >= 0 && h <= aq.this.ayz.getMeasuredHeight()) {
                            int h2 = aq.this.h(amVar);
                            int i = h2 - h;
                            if (z && i != 0 && h <= y) {
                                i = h2 - y;
                            }
                            if (aq.this.azg != null && (layoutParams = aq.this.azg.getLayoutParams()) != null) {
                                if (i == 0 || i > aq.this.ayz.getMeasuredHeight() || h2 >= aq.this.ayz.getMeasuredHeight()) {
                                    layoutParams.height = aq.this.iND;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > aq.this.ayz.getMeasuredHeight()) {
                                    layoutParams.height = aq.this.iND;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    aq.this.iMs.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                aq.this.azg.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (aq.this.azg != null && aq.this.azg.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = aq.this.azg.getLayoutParams();
                                            layoutParams2.height = aq.this.iND;
                                            aq.this.azg.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        aq.this.iMs.setOnLayoutListener(null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(am amVar) {
        if (amVar == null || amVar.getView() == null) {
            return 0;
        }
        if (amVar.getView().getTop() != 0 || amVar.getView().isShown()) {
            return amVar.getView().getBottom();
        }
        return 0;
    }

    public NoNetworkView cnM() {
        return this.fSu;
    }

    public void cnN() {
        if (this.Fv != null) {
            this.Fv.hide();
            if (this.iNR != null) {
                this.iNR.bxp();
            }
        }
    }

    public PbFakeFloorModel cnO() {
        return this.iFs;
    }

    public t cnP() {
        return this.iNF;
    }

    public com.baidu.tieba.pb.pb.main.a.e cnQ() {
        return this.iMu;
    }

    public void cnR() {
        reset();
        cnN();
        this.iNF.ckN();
        qo(false);
    }

    private void reset() {
        if (this.iCe != null && this.iCe.ckS() != null && this.Fv != null) {
            com.baidu.tbadk.editortools.pb.a.aMr().setStatus(0);
            com.baidu.tbadk.editortools.pb.e ckS = this.iCe.ckS();
            ckS.aML();
            ckS.aMf();
            if (ckS.getWriteImagesInfo() != null) {
                ckS.getWriteImagesInfo().setMaxImagesAllowed(ckS.isBJH ? 1 : 9);
            }
            ckS.md(SendView.ALL);
            ckS.me(SendView.ALL);
            com.baidu.tbadk.editortools.g lU = this.Fv.lU(23);
            com.baidu.tbadk.editortools.g lU2 = this.Fv.lU(2);
            com.baidu.tbadk.editortools.g lU3 = this.Fv.lU(5);
            if (lU2 != null) {
                lU2.display();
            }
            if (lU3 != null) {
                lU3.display();
            }
            if (lU != null) {
                lU.hide();
            }
            this.Fv.invalidate();
        }
    }

    public boolean cnS() {
        return this.iNg;
    }

    public void qd(boolean z) {
        if (this.iNb != null && this.heK != null) {
            this.heK.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iNb.startAnimation(alphaAnimation);
            }
            this.iNa.setVisibility(0);
            this.iNb.setVisibility(0);
            this.iNg = true;
            if (this.iNv != null && !this.iNS.isActive()) {
                this.iNv.setVisibility(0);
                qi(true);
            }
        }
    }

    public void qe(boolean z) {
        if (this.iNb != null && this.heK != null) {
            this.heK.setText(cnT());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iNb.startAnimation(alphaAnimation);
            }
            this.iNa.setVisibility(0);
            this.iNb.setVisibility(0);
            this.iNg = true;
            if (this.iNv != null && !this.iNS.isActive()) {
                this.iNv.setVisibility(0);
                qi(true);
            }
        }
    }

    public String cnT() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.iNW)) {
            return this.iNW;
        }
        if (this.iCe != null) {
            this.iNW = TbadkCoreApplication.getInst().getResources().getString(ap.cnI());
        }
        return this.iNW;
    }

    public PostData cnU() {
        int i = 0;
        if (this.iMs == null) {
            return null;
        }
        int cnV = cnV() - this.iMs.getHeaderViewsCount();
        if (cnV < 0) {
            cnV = 0;
        }
        if (this.iMD.yz(cnV) != null && this.iMD.yz(cnV) != PostData.kfl) {
            i = cnV + 1;
        }
        return this.iMD.getItem(i) instanceof PostData ? (PostData) this.iMD.getItem(i) : null;
    }

    public int cnV() {
        int i;
        View childAt;
        if (this.iMs == null) {
            return 0;
        }
        int firstVisiblePosition = this.iMs.getFirstVisiblePosition();
        int lastVisiblePosition = this.iMs.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.iMs.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.iMs.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int cnW() {
        return this.iMs.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.iDs != null && this.iDs.ciU() != null && !this.iDs.ciU().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.iDs.ciU().size() && (postData = this.iDs.ciU().get(i)) != null && postData.azX() != null && !StringUtils.isNull(postData.azX().getUserId()); i++) {
                if (this.iDs.ciU().get(i).azX().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.iNS != null && this.iNS.isActive()) {
                        qo(false);
                    }
                    if (this.iNv != null) {
                        this.iNv.qx(true);
                    }
                    this.iOa = postData.azX().getName_show();
                    return;
                }
            }
        }
    }

    public aq(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.iCe = null;
        this.ayz = null;
        this.axK = null;
        this.iMs = null;
        this.iMD = null;
        this.gsK = null;
        this.dyM = null;
        this.gon = null;
        this.iDj = null;
        this.iNb = null;
        this.heK = null;
        this.iNl = null;
        this.iNM = 0;
        this.iNX = 0L;
        this.iNX = System.currentTimeMillis();
        this.iCe = pbFragment;
        this.gon = onClickListener;
        this.dmA = cVar;
        this.iNM = com.baidu.adp.lib.util.l.getEquipmentWidth(this.iCe.getContext()) / 2;
        this.ayz = (RelativeLayout) LayoutInflater.from(this.iCe.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.ayz.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.iMY = this.ayz.findViewById(R.id.bottom_shadow);
        this.gLo = (NavigationBarCoverTip) this.ayz.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.axK = this.ayz.findViewById(R.id.statebar_view);
        this.iMC = (ObservedChangeRelativeLayout) this.ayz.findViewById(R.id.title_wrapper);
        this.fSu = (NoNetworkView) this.ayz.findViewById(R.id.view_no_network);
        this.iMs = (PbLandscapeListView) this.ayz.findViewById(R.id.new_pb_list);
        this.iNn = (FrameLayout) this.ayz.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.iCe.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.iCe.getActivity(), R.dimen.ds88));
        this.iMs.addHeaderView(this.textView, 0);
        this.iMs.setTextViewAdded(true);
        this.iND = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.azg = new View(this.iCe.getPageContext().getPageActivity());
        this.azg.setLayoutParams(new AbsListView.LayoutParams(-1, this.iND));
        this.azg.setVisibility(4);
        this.iMs.addFooterView(this.azg);
        this.iMs.setOnTouchListener(this.iCe.dnp);
        this.iMo = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.ayz);
        if (this.iCe.clw()) {
            this.iMq = (ViewStub) this.ayz.findViewById(R.id.manga_view_stub);
            this.iMq.setVisibility(0);
            this.iMp = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.iMp.show();
            this.iMo.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.iCe.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.iMo.cpE().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0561a() { // from class: com.baidu.tieba.pb.pb.main.aq.25
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0561a
            public void cjL() {
                if (aq.this.iMs != null) {
                    if (aq.this.iMu != null) {
                        aq.this.iMu.cpq();
                    }
                    aq.this.iMs.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0561a
            public void cjM() {
                aq.this.iCe.bCG();
            }
        }));
        this.iNa = this.ayz.findViewById(R.id.view_comment_top_line);
        this.iNb = this.ayz.findViewById(R.id.pb_editor_tool_comment);
        this.iNh = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iNi = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.heK = (TextView) this.ayz.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.heK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aq.this.iCe.clc();
                if (aq.this.iCe != null && aq.this.iCe.ckc() != null && aq.this.iCe.ckc().getPbData() != null && aq.this.iCe.ckc().getPbData().ciS() != null && aq.this.iCe.ckc().getPbData().ciS().azX() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cp("tid", aq.this.iCe.ckc().iIx).cp("fid", aq.this.iCe.ckc().getPbData().getForumId()).Z("obj_locate", 1).cp("uid", aq.this.iCe.ckc().getPbData().ciS().azX().getUserId()));
                }
            }
        });
        this.iNc = (ImageView) this.ayz.findViewById(R.id.pb_editor_tool_comment_icon);
        this.iNc.setOnClickListener(this.gon);
        boolean booleanExtra = this.iCe.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.iNd = (ImageView) this.ayz.findViewById(R.id.pb_editor_tool_collection);
        this.iNd.setOnClickListener(this.gon);
        if (booleanExtra) {
            this.iNd.setVisibility(8);
        } else {
            this.iNd.setVisibility(0);
        }
        this.iNe = (ImageView) this.ayz.findViewById(R.id.pb_editor_tool_share);
        this.iNe.setOnClickListener(this.gon);
        this.iNf = (TextView) this.ayz.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.iNl = (ViewStub) this.ayz.findViewById(R.id.interview_status_stub);
        this.iMv = new com.baidu.tieba.pb.pb.main.a.a(this.iCe, cVar);
        this.iMx = new com.baidu.tieba.pb.pb.main.a.d(this.iCe, cVar, this.gon);
        this.iMD = new f(this.iCe, this.iMs);
        this.iMD.C(this.gon);
        this.iMD.setTbGestureDetector(this.dmA);
        this.iMD.setOnImageClickListener(this.dIr);
        this.iDj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.27
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
                            aq.this.iCe.b(sparseArray);
                            return;
                        }
                        aq.this.cB(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        aq.this.iCe.b(sparseArray);
                    } else if (booleanValue3) {
                        aq.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.iMD.O(this.iDj);
        cob();
        coc();
        this.iMx.b(this.iMs);
        this.iMw.b(this.iMs);
        this.iMv.b(this.iMs);
        this.gsK = new PbListView(this.iCe.getPageContext().getPageActivity());
        this.dyM = this.gsK.getView().findViewById(R.id.pb_more_view);
        if (this.dyM != null) {
            this.dyM.setOnClickListener(this.gon);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.dyM, R.drawable.pb_foot_more_trans_selector);
        }
        this.gsK.setLineVisible();
        this.gsK.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.gsK.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.iMJ = this.ayz.findViewById(R.id.viewstub_progress);
        this.iCe.registerListener(this.iOe);
        this.iFs = new PbFakeFloorModel(this.iCe.getPageContext());
        this.iNF = new t(this.iCe.getPageContext(), this.iFs, this.ayz);
        this.iNF.a(this.iCe.iGV);
        this.iFs.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.aq.28
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void q(PostData postData) {
                aq.this.iFs.r(postData);
                aq.this.iMD.notifyDataSetChanged();
                aq.this.iNF.ckN();
                aq.this.Fv.aKs();
                aq.this.qo(false);
            }
        });
        if (this.iCe.ckc() != null && !StringUtils.isNull(this.iCe.ckc().cmN())) {
            this.iCe.showToast(this.iCe.ckc().cmN());
        }
        this.iNo = this.ayz.findViewById(R.id.pb_expand_blank_view);
        this.iNp = this.ayz.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iNp.getLayoutParams();
        if (this.iCe.ckc() != null && this.iCe.ckc().cmf()) {
            this.iNo.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.iNp.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = iNr;
            this.iNp.setLayoutParams(layoutParams2);
        }
        this.iNq = new am(this.iCe.getPageContext(), this.ayz.findViewById(R.id.pb_reply_expand_view));
        this.iNq.iLO.setVisibility(8);
        this.iNq.Q(this.gon);
        this.iCe.registerListener(this.mAccountChangedListener);
        this.iCe.registerListener(this.iOb);
        cnX();
        qi(false);
    }

    public void qf(boolean z) {
        this.iMY.setVisibility(z ? 0 : 8);
    }

    public void bNT() {
        if (!this.iCe.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").Z("obj_locate", 2).cp("fid", this.mForumId));
        } else if (this.iCe.cle()) {
            com.baidu.tbadk.editortools.pb.e ckS = this.iCe.ckS();
            if (ckS != null && (ckS.aMI() || ckS.aMJ())) {
                this.iCe.ckS().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Fv != null) {
                coh();
            }
            if (this.Fv != null) {
                this.iNg = false;
                if (this.Fv.lX(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.iCe.getPageContext(), (View) this.Fv.lX(2).dss, false, iNY);
                }
            }
            coO();
        }
    }

    private void cnX() {
        this.iNS = new com.baidu.tieba.pb.pb.godreply.a(this.iCe, this, (ViewStub) this.ayz.findViewById(R.id.more_god_reply_popup));
        this.iNS.x(this.gon);
        this.iNS.O(this.iDj);
        this.iNS.setOnImageClickListener(this.dIr);
        this.iNS.x(this.gon);
        this.iNS.setTbGestureDetector(this.dmA);
    }

    public com.baidu.tieba.pb.pb.godreply.a cnY() {
        return this.iNS;
    }

    public View cnZ() {
        return this.iNo;
    }

    public void coa() {
        if (this.iMs != null) {
            this.iMw.c(this.iMs);
            this.iMx.c(this.iMs);
            this.iMy.c(this.iMs);
            this.iMv.c(this.iMs);
        }
    }

    private void cob() {
        if (this.iMy == null) {
            this.iMy = new com.baidu.tieba.pb.pb.main.a.b(this.iCe, this.gon);
        }
    }

    private void coc() {
        if (this.iMw == null) {
            this.iMw = new com.baidu.tieba.pb.pb.main.a.c(this.iCe, this.dmA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cod() {
        if (this.iCe.clw()) {
            this.iMr = (ViewStub) this.ayz.findViewById(R.id.manga_mention_controller_view_stub);
            this.iMr.setVisibility(0);
            if (this.iMz == null) {
                this.iMz = (LinearLayout) this.ayz.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.q.a.a(this.iCe.getPageContext(), this.iMz);
            }
            if (this.iMA == null) {
                this.iMA = (TextView) this.iMz.findViewById(R.id.manga_prev_btn);
            }
            if (this.iMB == null) {
                this.iMB = (TextView) this.iMz.findViewById(R.id.manga_next_btn);
            }
            this.iMA.setOnClickListener(this.gon);
            this.iMB.setOnClickListener(this.gon);
        }
    }

    private void coe() {
        if (this.iCe.clw()) {
            if (this.iCe.clz() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iMA, R.color.cp_cont_e, 1);
            }
            if (this.iCe.clA() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iMB, R.color.cp_cont_e, 1);
            }
        }
    }

    public void cof() {
        if (this.iMz == null) {
            cod();
        }
        this.iMr.setVisibility(8);
        if (this.iOc != null && this.iOd != null) {
            this.iOc.removeCallbacks(this.iOd);
        }
    }

    public void cog() {
        if (this.iOc != null) {
            if (this.iOd != null) {
                this.iOc.removeCallbacks(this.iOd);
            }
            this.iOd = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.3
                @Override // java.lang.Runnable
                public void run() {
                    if (aq.this.iMz == null) {
                        aq.this.cod();
                    }
                    aq.this.iMr.setVisibility(0);
                }
            };
            this.iOc.postDelayed(this.iOd, 2000L);
        }
    }

    public void qg(boolean z) {
        this.iMo.qg(z);
        if (z && this.iNk) {
            this.gsK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.iMs.setNextPage(this.gsK);
            this.iMn = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Fv = editorTools;
        this.Fv.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Fv.getParent() == null) {
            this.ayz.addView(this.Fv, layoutParams);
        }
        this.Fv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.Fv.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.aq.5
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.p) {
                    if (((com.baidu.tbadk.coreExtra.data.p) aVar.data).aHc() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.p) aVar.data).aHc() == EmotionGroupType.USER_COLLECT) {
                        if (aq.this.mPermissionJudgePolicy == null) {
                            aq.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                        }
                        aq.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        aq.this.mPermissionJudgePolicy.appendRequestPermission(aq.this.iCe.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aq.this.mPermissionJudgePolicy.startRequestPermission(aq.this.iCe.getBaseFragmentActivity())) {
                            aq.this.iCe.ckS().c((com.baidu.tbadk.coreExtra.data.p) aVar.data);
                            aq.this.iCe.ckS().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cnN();
        this.iCe.ckS().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.aq.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (aq.this.Fv != null && aq.this.Fv.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (aq.this.iNR == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, aq.this.Fv.getId());
                            aq.this.iNR = new com.baidu.tieba.pb.pb.main.emotion.c(aq.this.iCe.getPageContext(), aq.this.ayz, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.isEmpty(aq.this.iNQ)) {
                                aq.this.iNR.setData(aq.this.iNQ);
                            }
                            aq.this.iNR.b(aq.this.Fv);
                        }
                        aq.this.iNR.FV(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (aq.this.iCe.iGb != null && aq.this.iCe.iGb.cpd() != null) {
                    if (!aq.this.iCe.iGb.cpd().cSN()) {
                        aq.this.iCe.iGb.qt(false);
                    }
                    aq.this.iCe.iGb.cpd().tD(false);
                }
            }
        });
    }

    public void coh() {
        if (this.iCe != null && this.Fv != null) {
            this.Fv.display();
            if (this.iCe.ckS() != null) {
                this.iCe.ckS().aMy();
            }
            coO();
        }
    }

    public void qh(boolean z) {
        if (this.iMs != null && this.textView != null && this.axK != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.axK.setVisibility(0);
                } else {
                    this.axK.setVisibility(8);
                    this.iMs.removeHeaderView(this.textView);
                    this.iMs.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = iNr;
                    this.textView.setLayoutParams(layoutParams);
                }
                cov();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + qq(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            cov();
            coW();
        }
    }

    public f coi() {
        return this.iMD;
    }

    public void a(PbFragment.c cVar) {
        this.iHa = cVar;
    }

    public void cB(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iCe.getContext());
        kVar.setTitleText(this.iCe.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.7
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.iMK.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            aq.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (aq.this.iOf != null) {
                                aq.this.iOf.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            aq.this.iCe.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.iCe.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.iCe.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !coV()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.iCe.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.iCe.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.iCe.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.az(arrayList);
        if (this.iMK == null) {
            this.iMK = new com.baidu.tbadk.core.dialog.i(this.iCe.getPageContext(), kVar);
        } else {
            this.iMK.a(kVar);
        }
        this.iMK.showDialog();
    }

    public void a(PbFragment.b bVar) {
        this.iOf = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.iCe != null && aVar != null) {
            if (this.gOh == null && this.iMv != null) {
                this.gOh = new com.baidu.tieba.NEGFeedBack.e(this.iCe.getPageContext(), this.iMv.cpn());
            }
            AntiData bBu = this.iCe.bBu();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bBu != null && bBu.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bBu.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.setFeedBackReasonMap(sparseArray);
            this.gOh.setDefaultReasonArray(new String[]{this.iCe.getString(R.string.delete_thread_reason_1), this.iCe.getString(R.string.delete_thread_reason_2), this.iCe.getString(R.string.delete_thread_reason_3), this.iCe.getString(R.string.delete_thread_reason_4), this.iCe.getString(R.string.delete_thread_reason_5)});
            this.gOh.setData(alVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.gOh.vS(str);
            this.gOh.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.aq.8
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    aq.this.iCe.a(aVar, jSONArray);
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
        sparseArray.put(iNy, Integer.valueOf(iNz));
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
        this.iML = new com.baidu.tbadk.core.dialog.a(this.iCe.getActivity());
        if (StringUtils.isNull(str2)) {
            this.iML.jF(i3);
        } else {
            this.iML.setOnlyMessageShowCenter(false);
            this.iML.sC(str2);
        }
        this.iML.setYesButtonTag(sparseArray);
        this.iML.a(R.string.dialog_ok, this.iCe);
        this.iML.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iML.fz(true);
        this.iML.b(this.iCe.getPageContext());
        if (z) {
            this.iML.aCp();
        } else {
            a(this.iML, i);
        }
    }

    public void aM(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.iMO == null) {
            this.iMO = LayoutInflater.from(this.iCe.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.iCe.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iMO);
        if (this.iMN == null) {
            this.iMN = new Dialog(this.iCe.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iMN.setCanceledOnTouchOutside(true);
            this.iMN.setCancelable(true);
            this.iMW = (ScrollView) this.iMO.findViewById(R.id.good_scroll);
            this.iMN.setContentView(this.iMO);
            WindowManager.LayoutParams attributes = this.iMN.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.iMN.getWindow().setAttributes(attributes);
            this.fJw = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.aq.10
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        aq.this.iMS = (String) compoundButton.getTag();
                        if (aq.this.fJv != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : aq.this.fJv) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && aq.this.iMS != null && !str.equals(aq.this.iMS)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.iMP = (LinearLayout) this.iMO.findViewById(R.id.good_class_group);
            this.iMR = (TextView) this.iMO.findViewById(R.id.dialog_button_cancel);
            this.iMR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (aq.this.iMN instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(aq.this.iMN, aq.this.iCe.getPageContext());
                    }
                }
            });
            this.iMQ = (TextView) this.iMO.findViewById(R.id.dialog_button_ok);
            this.iMQ.setOnClickListener(this.gon);
        }
        this.iMP.removeAllViews();
        this.fJv = new ArrayList();
        CustomBlueCheckRadioButton dW = dW("0", this.iCe.getPageContext().getString(R.string.thread_good_class));
        this.fJv.add(dW);
        dW.setChecked(true);
        this.iMP.addView(dW);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ad adVar = arrayList.get(i2);
                if (adVar != null && !TextUtils.isEmpty(adVar.ayt()) && adVar.ayu() > 0) {
                    CustomBlueCheckRadioButton dW2 = dW(String.valueOf(adVar.ayu()), adVar.ayt());
                    this.fJv.add(dW2);
                    View view = new View(this.iCe.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.iMP.addView(view);
                    this.iMP.addView(dW2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.iMW.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iCe.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iCe.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iCe.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.iMW.setLayoutParams(layoutParams2);
            this.iMW.removeAllViews();
            if (this.iMP != null && this.iMP.getParent() == null) {
                this.iMW.addView(this.iMP);
            }
        }
        com.baidu.adp.lib.f.g.a(this.iMN, this.iCe.getPageContext());
    }

    private CustomBlueCheckRadioButton dW(String str, String str2) {
        Activity pageActivity = this.iCe.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.fJw);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void coj() {
        this.iCe.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.iCe.hideProgressBar();
        if (z && z2) {
            this.iCe.showToast(this.iCe.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.iCe.showToast(str);
        }
    }

    public void bUP() {
        this.iMJ.setVisibility(0);
    }

    public void bUO() {
        this.iMJ.setVisibility(8);
    }

    public View cok() {
        if (this.iMO != null) {
            return this.iMO.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String col() {
        return this.iMS;
    }

    public View getView() {
        return this.ayz;
    }

    public void com() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.iCe.getPageContext().getPageActivity(), this.iCe.getBaseFragmentActivity().getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.iCe.hideProgressBar();
        if (z) {
            coF();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            coG();
        } else {
            coF();
        }
    }

    public void con() {
        this.gsK.setLineVisible();
        this.gsK.startLoadData();
    }

    public void coo() {
        this.iCe.hideProgressBar();
        endLoadData();
        this.iMs.completePullRefreshPostDelayed(0L);
        coA();
    }

    public void cop() {
        this.iMs.completePullRefreshPostDelayed(0L);
        coA();
    }

    private void qi(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.iMx.b(onLongClickListener);
        this.iMD.setOnLongClickListener(onLongClickListener);
        if (this.iNS != null) {
            this.iNS.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.iGc != null) {
            this.iGc.dismiss();
            this.iGc = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iCe.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.iCe.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iCe.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iCe.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iCe.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.az(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.iMT.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iMT = new com.baidu.tbadk.core.dialog.i(this.iCe.getPageContext(), kVar);
        this.iMT.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.iMT != null) {
            this.iMT.dismiss();
            this.iMT = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iCe.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.iDs != null && this.iDs.ciS() != null && !this.iDs.ciS().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.iCe.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iCe.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.az(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.aq.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                aq.this.iMT.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iMT = new com.baidu.tbadk.core.dialog.i(this.iCe.getPageContext(), kVar);
        this.iMT.showDialog();
    }

    public int coq() {
        return yX(this.iMs.getFirstVisiblePosition());
    }

    private int yX(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.iMs.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.d)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.iMs.getAdapter() == null || !(this.iMs.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.iMs.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int cor() {
        int lastVisiblePosition = this.iMs.getLastVisiblePosition();
        if (this.iMu != null) {
            if (lastVisiblePosition == this.iMs.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return yX(lastVisiblePosition);
    }

    public void yY(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.iMs != null) {
            if (this.iMo == null || this.iMo.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.iMo.mNavigationBar.getFixedNavHeight();
                if (this.iCe.clm() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.iNp != null && (layoutParams = (LinearLayout.LayoutParams) this.iNp.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.iNp.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.iMs.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.iMs.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.iMs.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.iMG.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void o(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.iMD.a(fVar, false);
        this.iMD.notifyDataSetChanged();
        coA();
        if (this.iNS != null) {
            this.iNS.cjY();
        }
        ArrayList<PostData> ciU = fVar.ciU();
        if (fVar.getPage().ayR() == 0 || ciU == null || ciU.size() < fVar.getPage().ayQ()) {
            if (com.baidu.tbadk.core.util.v.getCount(ciU) == 0 || (com.baidu.tbadk.core.util.v.getCount(ciU) == 1 && ciU.get(0) != null && ciU.get(0).cJx() == 1)) {
                if (this.iNu == null || this.iNu.iOy == null || this.iNu.iOy.getView() == null) {
                    i = 0;
                } else {
                    i = this.iNu.iOy.getView().getTop() < 0 ? this.iNu.iOy.getView().getHeight() : this.iNu.iOy.getView().getBottom();
                }
                if (this.iCe.clG()) {
                    this.gsK.ad(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.gsK.ad(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().ayR() == 0) {
                    this.gsK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.gsK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.gsK.aFt();
            }
        }
        q(fVar);
    }

    public void p(com.baidu.tieba.pb.data.f fVar) {
        if (this.iMv != null) {
            this.iMv.e(fVar, this.iDb);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.cjc() != null) {
            return fVar.cjc();
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(fVar.ciU())) {
            Iterator<PostData> it = fVar.ciU().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cJx() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.ciZ();
        }
        if (!p(postData)) {
            postData = a(fVar);
        }
        if (postData != null && postData.azX() != null && postData.azX().getUserTbVipInfoData() != null && postData.azX().getUserTbVipInfoData().getvipIntro() != null) {
            postData.azX().getGodUserData().setIntro(postData.azX().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean p(PostData postData) {
        if (postData == null || postData.azX() == null) {
            return false;
        }
        MetaData azX = postData.azX();
        return (TextUtils.isEmpty(azX.getUserId()) && TextUtils.isEmpty(azX.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.ciS() == null || fVar.ciS().azX() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData azX = fVar.ciS().azX();
        String userId = azX.getUserId();
        HashMap<String, MetaData> userMap = fVar.ciS().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = azX;
        }
        postData.Cq(1);
        postData.setId(fVar.ciS().aAn());
        postData.setTitle(fVar.ciS().getTitle());
        postData.setTime(fVar.ciS().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.ciS() != null) {
            if (this.iCe.cjR()) {
                if (fVar.ciR() != null) {
                    this.mForumName = fVar.ciR().getForumName();
                    this.mForumId = fVar.ciR().getForumId();
                }
                if (this.mForumName == null && this.iCe.ckc() != null && this.iCe.ckc().cjS() != null) {
                    this.mForumName = this.iCe.ckc().cjS();
                }
            }
            PostData b = b(fVar, z);
            a(b, fVar);
            this.iMx.setVisibility(8);
            if (fVar.cjp()) {
                this.iNJ = true;
                this.iMo.qE(true);
                this.iMo.mNavigationBar.hideBottomLine();
                if (this.iMu == null) {
                    this.iMu = new com.baidu.tieba.pb.pb.main.a.e(this.iCe);
                }
                this.iMu.a(fVar, b, this.iMs, this.iMx, this.iNn, this.iMo, this.mForumName, this.iNX);
                this.iMu.R(this.iOh);
                cov();
            } else {
                this.iNJ = false;
                this.iMo.qE(this.iNJ);
                if (this.iMu != null) {
                    this.iMu.c(this.iMs);
                }
            }
            if (this.iCe.ckV() != null) {
                this.iCe.ckV().qy(this.iNJ);
            }
            if (b != null) {
                this.iNj = b;
                this.iMx.setVisibility(0);
                SparseArray<Object> cpp = this.iMx.cpp();
                cpp.put(R.id.tag_clip_board, b);
                cpp.put(R.id.tag_is_subpb, false);
                this.iMy.a(fVar, this.iMs);
                this.iMw.v(fVar);
                this.iMv.e(fVar, this.iDb);
                this.iMv.u(fVar);
                this.iMx.a(this.mSkinType, this.iDs, b, this.iOh);
                if (this.iNq != null) {
                    if (fVar.cjs()) {
                        this.iNq.getView().setVisibility(8);
                    } else {
                        this.iNq.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k(com.baidu.tieba.pb.data.k.iAI);
                        if (fVar.ciS() != null) {
                            kVar.iAK = fVar.ciS().azO();
                        }
                        kVar.isNew = !this.iDb;
                        kVar.sortType = fVar.izK;
                        kVar.iAM = fVar.cjt();
                        kVar.iAN = this.iCe.clG();
                        this.iNq.a(kVar);
                    }
                }
                if (fVar != null && fVar.ciS() != null) {
                    ad(fVar.ciS().azT() == 1, fVar.ciS().azS() == 1);
                }
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (aq.this.iMD != null && aq.this.iMo != null && aq.this.iMo.iSu != null && aq.this.iDs != null && aq.this.iDs.ciS() != null && !aq.this.iDs.ciS().aAX() && !aq.this.coz() && aq.this.iDs.getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(aq.this.iDs.getForum().getName())) {
                            if (aq.this.iMD.ckI() == null || !aq.this.iMD.ckI().isShown()) {
                                aq.this.iMo.iSu.setVisibility(0);
                                if (aq.this.iCe != null && aq.this.iCe.ckc() != null) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13400");
                                    anVar.cp("tid", aq.this.iCe.ckc().cmc());
                                    anVar.cp("fid", aq.this.iCe.ckc().getForumId());
                                    anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(anVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void qj(boolean z) {
        if (z) {
            cos();
        } else {
            bxc();
        }
        this.iNu.iOy = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iNu));
        a(this.iNu.iOy, false);
    }

    public void cos() {
        if (this.iMo != null && !this.iNL) {
            this.iMo.qF(!StringUtils.isNull(this.iCe.cli()));
            this.iNL = true;
        }
    }

    public void bxc() {
        if (this.iMo != null) {
            this.iMo.cpN();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.iMx.a(postData, fVar);
    }

    public void cot() {
        if (this.iMu != null) {
            this.iMu.d(this.iMs);
        }
    }

    public boolean cou() {
        return this.eCM;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aF(bj bjVar) {
        if (bjVar == null || bjVar.azX() == null) {
            return false;
        }
        PostData b = b(this.iDs, false);
        String str = "";
        if (b != null && b.azX() != null) {
            str = b.azX().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            this.iMo.cpL();
            if (!StringUtils.isNull(eVar.forumName)) {
                this.iMo.DD(eVar.forumName);
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.thread_delete_by);
            String str = "";
            switch (com.baidu.adp.lib.f.b.toInt(eVar.source, 0)) {
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
            final String str2 = eVar.izC;
            this.iCe.showNetRefreshView(this.ayz, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        ba.aEt().b(aq.this.iCe.getPageContext(), new String[]{str2});
                        aq.this.iCe.finish();
                        return;
                    }
                    aq.this.iCe.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable cny;
        Parcelable cny2;
        if (fVar != null && this.iMs != null) {
            this.iDs = fVar;
            this.mType = i;
            if (fVar.ciS() != null) {
                this.iNw = fVar.ciS().azE();
                if (fVar.ciS().getAnchorLevel() != 0) {
                    this.eCM = true;
                }
                this.iMV = aF(fVar.ciS());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            t(fVar);
            this.iNk = false;
            this.iDb = z;
            coo();
            if (fVar.izL != null && fVar.izL.cjx()) {
                if (this.iMt == null) {
                    this.iMt = new PbThreadPostView(this.iCe.getContext());
                    this.iMs.addHeaderView(this.iMt, 1);
                    this.iMt.setData(fVar);
                    this.iMt.setChildOnClickLinstener(this.gon);
                }
            } else if (this.iMt != null && this.iMs != null) {
                this.iMs.removeHeaderView(this.iMt);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            r(fVar);
            if (this.iNV == null) {
                this.iNV = new ad(this.iCe.getPageContext(), this.gLo);
            }
            this.iNV.FL(fVar.ciX());
            if (this.iCe.clw()) {
                if (this.iMH == null) {
                    this.iMH = new com.baidu.tieba.pb.view.c(this.iCe.getPageContext());
                    this.iMH.createView();
                    this.iMH.setListPullRefreshListener(this.dcC);
                }
                this.iMs.setPullRefresh(this.iMH);
                cov();
                if (this.iMH != null) {
                    this.iMH.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().ayS() == 0 && z) {
                this.iMs.setPullRefresh(null);
            } else {
                if (this.iMH == null) {
                    this.iMH = new com.baidu.tieba.pb.view.c(this.iCe.getPageContext());
                    this.iMH.createView();
                    this.iMH.setListPullRefreshListener(this.dcC);
                }
                this.iMs.setPullRefresh(this.iMH);
                cov();
                if (this.iMH != null) {
                    this.iMH.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                boJ();
            }
            coA();
            this.iMD.pu(this.iDb);
            this.iMD.pv(false);
            this.iMD.pz(i == 5);
            this.iMD.pA(i == 6);
            this.iMD.pB(z2 && this.iOg);
            this.iMD.a(fVar, false);
            this.iMD.notifyDataSetChanged();
            this.iMx.a(b(fVar, z), fVar.cjs());
            if (fVar.ciS() != null && fVar.ciS().azI() != null && this.iMm != -1) {
                fVar.ciS().azI().setIsLike(this.iMm);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.iMs.setNextPage(this.gsK);
                this.iMn = 2;
                boJ();
            } else {
                this.iNk = true;
                if (fVar.getPage().ayR() == 1) {
                    if (this.iMI == null) {
                        this.iMI = new com.baidu.tieba.pb.view.a(this.iCe, this.iCe);
                    }
                    this.iMs.setNextPage(this.iMI);
                } else {
                    this.iMs.setNextPage(this.gsK);
                }
                this.iMn = 3;
            }
            ArrayList<PostData> ciU = fVar.ciU();
            if (fVar.getPage().ayR() == 0 || ciU == null || ciU.size() < fVar.getPage().ayQ()) {
                if (com.baidu.tbadk.core.util.v.getCount(ciU) == 0 || (com.baidu.tbadk.core.util.v.getCount(ciU) == 1 && ciU.get(0) != null && ciU.get(0).cJx() == 1)) {
                    if (this.iNu == null || this.iNu.iOy == null || this.iNu.iOy.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.iNu.iOy.getView().getTop() < 0 ? this.iNu.iOy.getView().getHeight() : this.iNu.iOy.getView().getBottom();
                    }
                    if (this.iCe.clG()) {
                        this.gsK.ad(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.gsK.ad(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.iCe.ckV() != null && !this.iCe.ckV().cpy()) {
                        this.iCe.ckV().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().ayR() == 0) {
                        this.gsK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.gsK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.gsK.aFt();
                }
                if (fVar.getPage().ayR() == 0 || ciU == null) {
                    coJ();
                }
            } else {
                if (z2) {
                    if (this.iOg) {
                        endLoadData();
                        if (fVar.getPage().ayR() != 0) {
                            this.gsK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.gsK.setLineVisible();
                        this.gsK.showLoading();
                    }
                } else {
                    this.gsK.setLineVisible();
                    this.gsK.showLoading();
                }
                this.gsK.aFt();
            }
            switch (i) {
                case 2:
                    this.iMs.setSelection(i2 > 1 ? (((this.iMs.getData() == null && fVar.ciU() == null) ? 0 : (this.iMs.getData().size() - fVar.ciU().size()) + this.iMs.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (cny2 = ak.cnx().cny()) != null && !(cny2 instanceof RecyclerView.SavedState)) {
                        this.iMs.onRestoreInstanceState(cny2);
                        if (com.baidu.tbadk.core.util.v.getCount(ciU) > 1 && fVar.getPage().ayR() > 0) {
                            this.gsK.endLoadData();
                            this.gsK.setText(this.iCe.getString(R.string.pb_load_more_without_point));
                            this.gsK.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.iOg = false;
                    break;
                case 5:
                    this.iMs.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (cny = ak.cnx().cny()) != null && !(cny instanceof RecyclerView.SavedState)) {
                        this.iMs.onRestoreInstanceState(cny);
                        break;
                    } else {
                        this.iMs.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.iMu != null && this.iMu.bat() != null) {
                            if (this.iCe.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.iMs.setSelectionFromTop((this.iMD.ckD() + this.iMs.getHeaderViewsCount()) - 1, this.iMu.cpr() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.iCe.getPageContext().getPageActivity()));
                            } else {
                                this.iMs.setSelectionFromTop((this.iMD.ckD() + this.iMs.getHeaderViewsCount()) - 1, this.iMu.cpr());
                            }
                        } else {
                            this.iMs.setSelection(this.iMD.ckD() + this.iMs.getHeaderViewsCount());
                        }
                    } else {
                        this.iMs.setSelection(i2 > 0 ? ((this.iMs.getData() == null && fVar.ciU() == null) ? 0 : (this.iMs.getData().size() - fVar.ciU().size()) + this.iMs.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.gsK.endLoadData();
                    this.gsK.setText(this.iCe.getString(R.string.pb_load_more_without_point));
                    this.gsK.setLineGone();
                    break;
            }
            if (this.iNw == iNx && isHost()) {
                coR();
            }
            if (this.iNH) {
                cnL();
                this.iNH = false;
                if (i3 == 0) {
                    qc(true);
                }
            }
            if (fVar.izH == 1 || fVar.izI == 1) {
                if (this.iNN == null) {
                    this.iNN = new PbTopTipView(this.iCe.getContext());
                }
                if (fVar.izI == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.iCe.getStType())) {
                    this.iNN.setText(this.iCe.getString(R.string.pb_read_strategy_add_experience));
                    this.iNN.a(this.ayz, this.mSkinType);
                } else if (fVar.izH == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.iCe.getStType())) {
                    this.iNN.setText(this.iCe.getString(R.string.pb_read_news_add_experience));
                    this.iNN.a(this.ayz, this.mSkinType);
                }
            }
            q(fVar);
        }
    }

    private void q(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.ciS() != null) {
            if (fVar.aww()) {
                SvgManager.aEp().a(this.iNd, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aEp().a(this.iNd, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iNf.setText(yZ(fVar.ciS().azO()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.ciS()));
        }
    }

    private String yZ(int i) {
        if (i == 0) {
            return this.iCe.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void cov() {
        if (this.iMu != null) {
            this.iMu.a(this.iMs, this.textView, this.mType);
        }
    }

    public void qk(boolean z) {
        this.iMU = z;
    }

    public void endLoadData() {
        if (this.gsK != null) {
            this.gsK.setLineGone();
            this.gsK.endLoadData();
        }
        boJ();
    }

    public void bem() {
        this.iMs.setVisibility(0);
    }

    public void cow() {
        if (this.iMs != null) {
            this.iMs.setVisibility(8);
        }
        if (this.iMs != null) {
            this.iNn.setVisibility(8);
        }
        if (this.iMo != null && this.iMo.iSr != null) {
            this.iMo.iSr.setVisibility(8);
        }
    }

    public void cox() {
        if (this.iMs != null) {
            this.iMs.setVisibility(0);
        }
        if (this.iNn != null) {
            this.iNn.setVisibility(0);
        }
        if (this.iMo != null && this.iMo.iSr != null) {
            this.iMo.iSr.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void r(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.iNj != null && this.iNj.azX() != null && this.iMo != null) {
            this.iNK = !this.iNJ;
            this.iMo.qA(this.iNK);
            if (this.iCe.ckV() != null) {
                this.iCe.ckV().qz(this.iNK);
            }
            coy();
            if (this.iCe != null && !this.iCe.cjR() && !com.baidu.tbadk.core.util.v.isEmpty(fVar.cjm())) {
                bf bfVar = fVar.cjm().get(0);
                if (bfVar != null) {
                    this.iMo.dX(bfVar.getForumName(), bfVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.iMo.dX(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.iNK) {
                this.iMx.a(fVar, this.iNj, this.iMV);
                if (this.iNp != null) {
                    this.iNp.setVisibility(8);
                }
                if (this.iNT == null) {
                    this.iNT = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.aq.18
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (aq.this.iCe != null && aq.this.iCe.isAdded()) {
                                if (i < 0 && f > aq.this.iNM) {
                                    aq.this.coQ();
                                }
                                aq.this.cop();
                            }
                        }
                    };
                }
                this.iMs.setListViewDragListener(this.iNT);
                return;
            }
            if (this.iNp != null) {
                this.iNp.setVisibility(0);
            }
            this.iMx.a(fVar, this.iNj, this.iMV);
            this.iNT = null;
            this.iMs.setListViewDragListener(null);
        }
    }

    private void coy() {
        this.iMx.a(this.iDs, this.iNj, this.iNK, this.iNJ);
    }

    public boolean coz() {
        return this.iDs == null || this.iDs.getForum() == null || "0".equals(this.iDs.getForum().getId()) || "me0407".equals(this.iDs.getForum().getName());
    }

    private boolean coA() {
        return this.iMv.qv(this.iDb);
    }

    private boolean s(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.ciS() == null) {
            return false;
        }
        if (fVar.ciS().azU() == 1 || fVar.ciS().getThreadType() == 33) {
            return true;
        }
        return !(fVar.ciS().azW() == null || fVar.ciS().azW().aCg() == 0) || fVar.ciS().azS() == 1 || fVar.ciS().azT() == 1 || fVar.ciS().aAI() || fVar.ciS().aBd() || fVar.ciS().aAW() || fVar.ciS().aAj() != null || !com.baidu.tbadk.core.util.aq.isEmpty(fVar.ciS().getCategory()) || fVar.ciS().aAa() || fVar.ciS().azZ();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.iMw != null) {
                if (fVar.ciS() != null && fVar.ciS().aAm() == 0 && !fVar.ciS().aAX() && !this.iNZ) {
                    if (fVar.ciS() != null) {
                        bj ciS = fVar.ciS();
                        ciS.p(true, s(fVar));
                        ciS.jr(3);
                        ciS.so("2");
                    }
                    if (fVar.ciS().ayL()) {
                        this.iMx.c(this.iMs);
                        this.iMw.c(this.iMs);
                        this.iMw.b(this.iMs);
                        this.iMx.b(this.iMs);
                        this.iMx.A(this.iDs);
                        this.iMw.w(fVar);
                    } else {
                        this.iMx.A(this.iDs);
                        this.iMw.y(fVar);
                    }
                } else if (fVar.ciS().aAm() == 1) {
                    if (fVar.ciS() != null) {
                        this.iMw.c(this.iMs);
                        this.iMx.A(this.iDs);
                    }
                } else {
                    this.iMw.c(this.iMs);
                    this.iMx.A(this.iDs);
                }
            }
            if (fVar.ciS() != null) {
                ac(fVar.ciS().azT() == 1, fVar.ciS().azS() == 1);
            }
            this.iDb = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            coA();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.w wVar;
        StringBuilder sb = null;
        if (fVar != null && (b = b(fVar, z)) != null) {
            String userId = b.azX().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cje()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.azX() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.azX().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.azX().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.azX().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cje()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bf> cjm = fVar.cjm();
                if (com.baidu.tbadk.core.util.v.getCount(cjm) > 0) {
                    sb = new StringBuilder();
                    for (bf bfVar : cjm) {
                        if (bfVar != null && !StringUtils.isNull(bfVar.getForumName()) && (wVar = bfVar.cML) != null && wVar.cKF && !wVar.cKG && (wVar.type == 1 || wVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bfVar.getForumName(), 12)).append(this.iCe.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.iCe.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View coB() {
        return this.dyM;
    }

    public boolean coC() {
        if (this.azg == null || this.azg.getParent() == null || this.gsK.isLoading()) {
            return false;
        }
        int bottom = this.azg.getBottom();
        Rect rect = new Rect();
        this.azg.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void FN(String str) {
        if (this.gsK != null) {
            this.gsK.setText(str);
        }
    }

    public void FO(String str) {
        if (this.gsK != null) {
            int i = 0;
            if (this.iNu != null && this.iNu.iOy != null && this.iNu.iOy.getView() != null) {
                i = this.iNu.iOy.getView().getTop() < 0 ? this.iNu.iOy.getView().getHeight() : this.iNu.iOy.getView().getBottom();
            }
            this.gsK.ad(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.iMs;
    }

    public int coD() {
        return R.id.richText;
    }

    public TextView ckn() {
        return this.iMx.ckn();
    }

    public void d(BdListView.e eVar) {
        this.iMs.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.dcC = cVar;
        if (this.iMH != null) {
            this.iMH.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ap apVar, a.b bVar) {
        if (apVar != null) {
            int ayP = apVar.ayP();
            int ayM = apVar.ayM();
            if (this.iME != null) {
                this.iME.aCp();
            } else {
                this.iME = new com.baidu.tbadk.core.dialog.a(this.iCe.getPageContext().getPageActivity());
                this.iMF = LayoutInflater.from(this.iCe.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.iME.aO(this.iMF);
                this.iME.a(R.string.dialog_ok, bVar);
                this.iME.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.19
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aq.this.coF();
                        aVar.dismiss();
                    }
                });
                this.iME.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.aq.20
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (aq.this.iNE == null) {
                            aq.this.iNE = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.20.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aq.this.iCe.HidenSoftKeyPad((InputMethodManager) aq.this.iCe.getBaseFragmentActivity().getSystemService("input_method"), aq.this.ayz);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.gx().postDelayed(aq.this.iNE, 150L);
                    }
                });
                this.iME.b(this.iCe.getPageContext()).aCp();
            }
            this.iMG = (EditText) this.iMF.findViewById(R.id.input_page_number);
            this.iMG.setText("");
            TextView textView = (TextView) this.iMF.findViewById(R.id.current_page_number);
            if (ayP <= 0) {
                ayP = 1;
            }
            if (ayM <= 0) {
                ayM = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(ayP), Integer.valueOf(ayM)));
            this.iCe.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.iMG, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.iMs.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.iCe.showToast(str);
    }

    public boolean ql(boolean z) {
        if (this.Fv == null || !this.Fv.aLX()) {
            return false;
        }
        this.Fv.aKs();
        return true;
    }

    public void coE() {
        if (this.iOi != null) {
            while (this.iOi.size() > 0) {
                TbImageView remove = this.iOi.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        coE();
        this.iMD.yA(1);
        if (this.iMu != null) {
            this.iMu.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.iMD.yA(2);
        if (this.iMu != null) {
            this.iMu.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.iCe.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.iCe.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.iNG != null) {
            this.iNG.destroy();
        }
        if (this.iNV != null) {
            this.iNV.onDestory();
        }
        if (this.iNN != null) {
            this.iNN.hide();
        }
        this.iCe.hideProgressBar();
        if (this.fSu != null && this.gjI != null) {
            this.fSu.b(this.gjI);
        }
        coF();
        endLoadData();
        if (this.iNE != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iNE);
        }
        if (this.iNm != null) {
            this.iNm.clearStatus();
        }
        this.iOc = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.iMD.yA(3);
        if (this.axK != null) {
            this.axK.setBackgroundDrawable(null);
        }
        if (this.iMu != null) {
            this.iMu.destroy();
        }
        if (this.iMD != null) {
            this.iMD.onDestroy();
        }
        this.iMs.setOnLayoutListener(null);
        if (this.iNR != null) {
            this.iNR.bER();
        }
        if (this.iNv != null) {
            this.iNv.onDestroy();
        }
        if (this.iMx != null) {
            this.iMx.onDestroy();
        }
    }

    public boolean za(int i) {
        if (this.iMu != null) {
            return this.iMu.za(i);
        }
        return false;
    }

    public void coF() {
        this.iMo.apF();
        if (this.iMx != null) {
            this.iMx.coF();
        }
        if (this.iCe != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.iCe.getContext(), this.iMG);
        }
        cnN();
        if (this.iGc != null) {
            this.iGc.dismiss();
        }
        coH();
        if (this.iME != null) {
            this.iME.dismiss();
        }
        if (this.gom != null) {
            this.gom.dismiss();
        }
    }

    public void coG() {
        this.iMo.apF();
        if (this.iMx != null) {
            this.iMx.coF();
        }
        if (this.iGc != null) {
            this.iGc.dismiss();
        }
        coH();
        if (this.iME != null) {
            this.iME.dismiss();
        }
        if (this.gom != null) {
            this.gom.dismiss();
        }
    }

    public void dL(List<String> list) {
        this.iNQ = list;
        if (this.iNR != null) {
            this.iNR.setData(list);
        }
    }

    public void pt(boolean z) {
        this.iMD.pt(z);
    }

    public void qm(boolean z) {
        this.iMX = z;
    }

    public void coH() {
        if (this.iML != null) {
            this.iML.dismiss();
        }
        if (this.iMM != null) {
            com.baidu.adp.lib.f.g.b(this.iMM, this.iCe.getPageContext());
        }
        if (this.iMN != null) {
            com.baidu.adp.lib.f.g.b(this.iMN, this.iCe.getPageContext());
        }
        if (this.iMK != null) {
            this.iMK.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.iDs, this.iDb);
            b(this.iDs, this.iDb, this.mType, i);
            this.iCe.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.iCe.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.ayz);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.ayz, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.iMY, R.drawable.personalize_tab_shadow);
            if (this.iMu != null) {
                this.iMu.onChangeSkinType(i);
            }
            if (this.iMy != null) {
                this.iMy.onChangeSkinType(i);
            }
            if (this.iMv != null) {
                this.iMv.onChangeSkinType(i);
            }
            if (this.iMw != null) {
                this.iMw.onChangeSkinType(i);
            }
            if (this.iMx != null) {
                this.iMx.onChangeSkinType(i);
            }
            if (this.gsK != null) {
                this.gsK.changeSkin(i);
                if (this.dyM != null) {
                    this.iCe.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.dyM);
                    com.baidu.tbadk.core.util.am.setBackgroundResource(this.dyM, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.iME != null) {
                this.iME.c(this.iCe.getPageContext());
            }
            qk(this.iMU);
            this.iMD.notifyDataSetChanged();
            if (this.iMH != null) {
                this.iMH.changeSkin(i);
            }
            if (this.Fv != null) {
                this.Fv.onChangeSkinType(i);
            }
            if (this.iMI != null) {
                this.iMI.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.fJv)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.fJv) {
                    customBlueCheckRadioButton.aFg();
                }
            }
            coe();
            UtilHelper.setStatusBarBackground(this.axK, i);
            UtilHelper.setStatusBarBackground(this.iNp, i);
            if (this.iMz != null) {
                com.baidu.tbadk.q.a.a(this.iCe.getPageContext(), this.iMz);
            }
            if (this.iNF != null) {
                this.iNF.onChangeSkinType(i);
            }
            if (this.iMo != null) {
                if (this.iMu != null) {
                    this.iMu.zb(i);
                } else {
                    this.iMo.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.heK != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.heK, (int) R.color.cp_cont_d);
                this.heK.setBackgroundDrawable(com.baidu.tbadk.core.util.am.ay(com.baidu.adp.lib.util.l.getDimens(this.iCe.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_j)));
            }
            if (this.iNd != null && this.iDs != null) {
                if (this.iDs.aww()) {
                    SvgManager.aEp().a(this.iNd, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.aEp().a(this.iNd, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            if (this.iNe != null) {
                SvgManager.aEp().a(this.iNe, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.iNc != null) {
                SvgManager.aEp().a(this.iNc, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.iNa != null) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iNa, R.drawable.bottom_shadow);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iNf, (int) R.color.cp_cont_b);
            if (this.iNS != null) {
                this.iNS.onChangeSkinType(i);
            }
            if (this.iNv != null) {
                this.iNv.onChangeSkinType();
            }
            if (this.iNP != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iNP, (int) R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iNb, R.color.cp_bg_line_h);
            if (this.iMt != null) {
                this.iMt.oU(i);
            }
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dIr = iVar;
        this.iMD.setOnImageClickListener(this.dIr);
        this.iNS.setOnImageClickListener(this.dIr);
    }

    public void g(NoNetworkView.a aVar) {
        this.gjI = aVar;
        if (this.fSu != null) {
            this.fSu.a(this.gjI);
        }
    }

    public void qn(boolean z) {
        this.iMD.setIsFromCDN(z);
    }

    public Button coI() {
        return this.iMZ;
    }

    public void coJ() {
        if (this.iMn != 2) {
            this.iMs.setNextPage(this.gsK);
            this.iMn = 2;
        }
    }

    public void coK() {
        if (com.baidu.tbadk.n.m.aOT().aOU()) {
            int lastVisiblePosition = this.iMs.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.iMs.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.dzs = true;
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
                        perfLog2.dzs = true;
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

    public boolean coL() {
        return this.Fv != null && this.Fv.getVisibility() == 0;
    }

    public boolean coM() {
        return this.Fv != null && this.Fv.aLX();
    }

    public void coN() {
        if (this.Fv != null) {
            this.Fv.aKs();
        }
    }

    public void qo(boolean z) {
        if (this.iNb != null) {
            qm(this.iCe.ckS().aMB());
            if (this.iMX) {
                qd(z);
            } else {
                qe(z);
            }
        }
    }

    public void coO() {
        if (this.iNb != null) {
            this.iNa.setVisibility(8);
            this.iNb.setVisibility(8);
            this.iNg = false;
            if (this.iNv != null) {
                this.iNv.setVisibility(8);
                qi(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.fNy == null) {
            this.fNy = new com.baidu.tbadk.core.view.a(this.iCe.getPageContext());
        }
        this.fNy.setDialogVisiable(true);
    }

    public void boJ() {
        if (this.fNy != null) {
            this.fNy.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.iMs.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.iMs.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.iMu != null) {
            this.iMu.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.iOj = getScrollY();
            this.iNu.iOy = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iNu));
            a(this.iNu.iOy, true);
        }
    }

    public void qp(boolean z) {
        if (this.iMu != null) {
            this.iMu.qp(z);
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
        if (this.iMu != null) {
            this.iMu.onScroll(absListView, i, i2, i3);
        }
        if (this.iMo != null && this.iMD != null) {
            this.iMo.cD(this.iMD.ckI());
        }
        this.iNu.iuX = i;
        this.iNu.headerCount = this.iMs.getHeaderViewsCount();
        this.iNu.iOy = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iNu));
        qf(b(absListView, i));
        a(this.iNu.iOy, false);
        if (this.gsK.aFu() && !this.gsK.dcv) {
            if (this.iNu != null && this.iNu.iOy != null && this.iNu.iOy.getView() != null) {
                i4 = this.iNu.iOy.getView().getTop() < 0 ? this.iNu.iOy.getView().getHeight() : this.iNu.iOy.getView().getBottom();
            }
            this.gsK.kT(i4);
            this.gsK.dcv = true;
        }
    }

    public void coP() {
        if (TbadkCoreApplication.isLogin() && this.iDs != null && this.iNK && !this.iNJ && !this.iMV && this.iNj != null && this.iNj.azX() != null && !this.iNj.azX().getIsLike() && !this.iNj.azX().hadConcerned() && this.iNG == null) {
            this.iNG = new an(this.iCe);
        }
    }

    public void coQ() {
        if (this.iNK && !this.iNJ && this.iNj != null && this.iNj.azX() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").Z("obj_locate", this.iCe.cjR() ? 2 : 1).Z("obj_type", this.iNJ ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.iCe.getPageContext().getPageActivity(), this.iNj.azX().getUserId(), this.iNj.azX().getUserName(), this.iCe.ckc().cjS(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(am amVar, boolean z) {
        int measuredHeight;
        if (!this.iNJ && this.iNo != null && this.iMo.cpE() != null) {
            int ckE = this.iMD.ckE();
            if (ckE > 0 && (amVar == null || amVar.getView().getParent() == null)) {
                if (ckE > this.iMs.getFirstVisiblePosition() - this.iMs.getHeaderViewsCount()) {
                    this.iNo.setVisibility(8);
                    return;
                }
                this.iNo.setVisibility(0);
                qf(false);
                this.iMo.mNavigationBar.hideBottomLine();
                if (this.iNo.getParent() != null && ((ViewGroup) this.iNo.getParent()).getHeight() <= this.iNo.getTop()) {
                    this.iNo.getParent().requestLayout();
                }
            } else if (amVar == null || amVar.getView() == null || amVar.iLO == null) {
                if (this.iMs.getFirstVisiblePosition() == 0) {
                    this.iNo.setVisibility(8);
                    this.iMo.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = amVar.getView().getTop();
                if (amVar.getView().getParent() != null) {
                    if (this.iNt) {
                        this.iNs = top;
                        this.iNt = false;
                    }
                    this.iNs = top < this.iNs ? top : this.iNs;
                }
                if (top != 0 || amVar.getView().isShown()) {
                    if (this.iMC.getY() < 0.0f) {
                        measuredHeight = iNr - amVar.iLO.getMeasuredHeight();
                    } else {
                        measuredHeight = this.iMo.cpE().getMeasuredHeight() - amVar.iLO.getMeasuredHeight();
                        this.iMo.mNavigationBar.hideBottomLine();
                    }
                    if (amVar.getView().getParent() == null && top <= this.iNs) {
                        this.iNo.setVisibility(0);
                        qf(false);
                    } else if (top < measuredHeight) {
                        this.iNo.setVisibility(0);
                        qf(false);
                    } else {
                        this.iNo.setVisibility(8);
                        this.iMo.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.iNt = true;
                    }
                }
            }
        }
    }

    public void coR() {
        if (!this.iOk) {
            TiebaStatic.log("c10490");
            this.iOk = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iCe.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(iNy, Integer.valueOf(iNA));
            aVar.jE(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.iCe.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aO(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.iCe);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.21
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iCe.getPageContext()).aCp();
        }
    }

    public void FP(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iCe.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.iCe.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aO(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(iNy, Integer.valueOf(iNB));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.iCe);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iCe.getPageContext()).aCp();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.azX() != null) {
            MetaData azX = b.azX();
            azX.setGiftNum(azX.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        a(fVar, z, i, i2);
        r(fVar);
    }

    public PbInterviewStatusView coS() {
        return this.iNm;
    }

    private void t(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.ciS() != null && fVar.ciS().aBd() && this.iNm == null) {
            this.iNm = (PbInterviewStatusView) this.iNl.inflate();
            this.iNm.setOnClickListener(this.gon);
            this.iNm.setCallback(this.iCe.clE());
            this.iNm.setData(this.iCe, fVar);
        }
    }

    public RelativeLayout coT() {
        return this.iMC;
    }

    public View coU() {
        return this.axK;
    }

    public boolean coV() {
        return this.iNZ;
    }

    public void py(boolean z) {
        this.iMx.py(z);
    }

    public void FQ(String str) {
        if (this.iMp != null) {
            this.iMp.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int qq(boolean z) {
        if (this.iNm == null || this.iNm.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void coW() {
        if (this.iNm != null && this.iNm.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iNm.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.iNm.setLayoutParams(layoutParams);
        }
    }

    public boolean ckY() {
        return false;
    }

    public void FR(String str) {
        this.heK.performClick();
        if (!StringUtils.isNull(str) && this.iCe.ckS() != null && this.iCe.ckS().aMu() != null && this.iCe.ckS().aMu().getInputView() != null) {
            EditText inputView = this.iCe.ckS().aMu().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            coF();
            if (configuration.orientation == 2) {
                coO();
                cnN();
            } else {
                cnR();
            }
            if (this.iNF != null) {
                this.iNF.ckN();
            }
            this.iCe.bCG();
            this.iMC.setVisibility(8);
            this.iMo.qB(false);
            this.iCe.pM(false);
            if (this.iMu != null) {
                if (configuration.orientation == 1) {
                    coT().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.iMs.setIsLandscape(true);
                    this.iMs.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.iMs.setIsLandscape(false);
                    if (this.iOj > 0) {
                        this.iMs.smoothScrollBy(this.iOj, 0);
                    }
                }
                this.iMu.onConfigurationChanged(configuration);
                this.iNn.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void qr(boolean z) {
        if (this.iMu != null) {
            this.iMu.qr(z);
        }
    }

    public boolean coX() {
        return this.iMu != null && this.iMu.coX();
    }

    public void coY() {
        if (this.iMu != null) {
            this.iMu.coY();
        }
    }

    public void pC(boolean z) {
        this.iMD.pC(z);
    }

    public void cC(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.iNb.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.iCe.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.iNP = new TextView(this.iCe.getContext());
            this.iNP.setText(R.string.connection_tips);
            this.iNP.setGravity(17);
            this.iNP.setPadding(com.baidu.adp.lib.util.l.getDimens(this.iCe.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.iCe.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.iCe.getContext(), R.dimen.ds60);
            if (this.iNP.getParent() == null) {
                frameLayout.addView(this.iNP, layoutParams);
            }
            this.iNO = new PopupWindow(this.iCe.getContext());
            this.iNO.setContentView(frameLayout);
            this.iNO.setHeight(-2);
            this.iNO.setWidth(-2);
            this.iNO.setFocusable(true);
            this.iNO.setOutsideTouchable(false);
            this.iNO.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.iMs.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aq.24
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        aq.this.iNO.showAsDropDown(aq.this.iNb, view.getLeft(), -aq.this.iNb.getHeight());
                    } else {
                        aq.this.iNO.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void qs(boolean z) {
        this.iNU = z;
    }

    public boolean coZ() {
        return this.iNU;
    }

    public PbThreadPostView cpa() {
        return this.iMt;
    }

    private void ac(boolean z, boolean z2) {
        ad(z, z2);
        if (this.iDs != null && this.iDs.ciS() != null && this.iDs.ciS().aAm() == 0 && !this.iDs.ciS().aAX()) {
            ae(z, z2);
        } else if (this.iMD != null && this.iMD.ckJ() != null) {
            this.iMD.ckJ().b(this.iDs, z, z2);
        }
    }

    private void ad(boolean z, boolean z2) {
        this.iMx.d(this.iDs, z, z2);
    }

    private void ae(boolean z, boolean z2) {
        this.iMw.c(this.iDs, z, z2);
    }
}
