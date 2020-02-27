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
    private static final int iOM = UtilHelper.getLightStatusBarHeight();
    public static int iOS = 3;
    public static int iOT = 0;
    public static int iOU = 3;
    public static int iOV = 4;
    public static int iOW = 5;
    public static int iOX = 6;
    private static a.InterfaceC0610a iPt = new a.InterfaceC0610a() { // from class: com.baidu.tieba.pb.pb.main.an.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0610a
        public void onRefresh() {
        }
    };
    private EditorTools FO;
    private RelativeLayout aCP;
    private View aCa;
    private View aDw;
    private View dCM;
    private g.c dgH;
    private com.baidu.tieba.pb.a.c dqJ;
    private List<CustomBlueCheckRadioButton> fLS;
    private NoNetworkView fUO;
    private NavigationBarCoverTip gNn;
    private com.baidu.tieba.NEGFeedBack.e gQh;
    private View.OnClickListener gqo;
    private PbListView guL;
    private TextView hgK;
    private PbFragment iDW;
    private View.OnClickListener iEQ;
    private com.baidu.tieba.pb.data.e iEZ;
    private PbFakeFloorModel iGW;
    PbFragment.c iID;
    public int iNG;
    public final com.baidu.tieba.pb.pb.main.view.c iNI;
    public com.baidu.tieba.pb.pb.main.view.b iNJ;
    private ViewStub iNK;
    private ViewStub iNL;
    private PbLandscapeListView iNM;
    private PbThreadPostView iNN;
    private com.baidu.tieba.pb.pb.main.a.e iNO;
    private com.baidu.tieba.pb.pb.main.a.a iNP;
    private com.baidu.tieba.pb.pb.main.a.c iNQ;
    private com.baidu.tieba.pb.pb.main.a.d iNR;
    private com.baidu.tieba.pb.pb.main.a.b iNS;
    private LinearLayout iNT;
    private TextView iNU;
    private TextView iNV;
    private ObservedChangeRelativeLayout iNW;
    private f iNX;
    private TextView iOA;
    private int iOC;
    private int iOD;
    private PostData iOE;
    private ViewStub iOG;
    private PbInterviewStatusView iOH;
    private FrameLayout iOI;
    private View iOJ;
    private View iOK;
    private aj iOL;
    private PbEmotionBar iOQ;
    private int iOY;
    private Runnable iOZ;
    private View iOd;
    private View iOs;
    private View iOu;
    private View iOv;
    private ImageView iOw;
    private ImageView iOx;
    private ImageView iOy;
    private com.baidu.tieba.pb.view.c iOz;
    private PbFragment.b iPA;
    public int iPE;
    private s iPa;
    private ak iPb;
    private int iPh;
    private PbTopTipView iPi;
    private PopupWindow iPj;
    private TextView iPk;
    private List<String> iPl;
    private com.baidu.tieba.pb.pb.main.emotion.c iPm;
    private com.baidu.tieba.pb.pb.godreply.a iPn;
    private PbLandscapeListView.b iPo;
    private aa iPq;
    private String iPr;
    private long iPs;
    private boolean iPu;
    private Runnable iPy;
    private boolean isLandscape;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private int iNH = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a iNY = null;
    private com.baidu.tbadk.core.dialog.b gqn = null;
    private View iNZ = null;
    private EditText iOa = null;
    private com.baidu.tieba.pb.view.d iOb = null;
    private com.baidu.tieba.pb.view.a iOc = null;
    private b.a hDs = null;
    private TbRichTextView.i dMw = null;
    private NoNetworkView.a glJ = null;
    private com.baidu.tbadk.core.dialog.i iOe = null;
    private com.baidu.tbadk.core.dialog.a iOf = null;
    private Dialog iOg = null;
    private Dialog iOh = null;
    private View iOi = null;
    private LinearLayout iOj = null;
    private CompoundButton.OnCheckedChangeListener fLT = null;
    private TextView iOk = null;
    private TextView iOl = null;
    private String iOm = null;
    private com.baidu.tbadk.core.dialog.i iHG = null;
    private com.baidu.tbadk.core.dialog.i iOn = null;
    private boolean iOo = false;
    private boolean iOp = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView iOq = null;
    private boolean iOr = false;
    private Button iOt = null;
    private boolean iOB = true;
    private com.baidu.tbadk.core.view.a fPT = null;
    private boolean iEI = false;
    private int mSkinType = 3;
    private boolean iOF = false;
    private int iON = 0;
    private boolean iOO = true;
    public a iOP = new a();
    private int iOR = 0;
    private boolean iPc = false;
    private int iPd = 0;
    private boolean iPe = false;
    private boolean iPf = false;
    private boolean iPg = false;
    private boolean iPp = false;
    private String iPv = null;
    private CustomMessageListener iPw = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.an.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                an.this.iPv = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.an.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && an.this.iNX != null) {
                an.this.iNX.notifyDataSetChanged();
            }
        }
    };
    private Handler iPx = new Handler();
    private CustomMessageListener iPz = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.an.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                an.this.iOB = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean iPB = true;
    View.OnClickListener iPC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || an.this.iEZ == null || an.this.iEZ.cks() == null || an.this.iEZ.cks().aCm() == null || an.this.iEZ.cks().aCm().getAlaUserData() == null || an.this.iEZ.cks().aCm().getAlaUserData().live_status != 1 || an.this.iEZ.cks().aCm().getAlaUserData().live_id <= 0) {
                if (an.this.iPe) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").X("obj_id", 2));
                }
                if (!an.this.iPe && an.this.iEZ != null && an.this.iEZ.cks() != null && an.this.iEZ.cks().aCm() != null && an.this.iEZ.cks().aCm().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").X("obj_locate", 1));
                }
                if (an.this.iDW.cng() != null) {
                    an.this.iDW.cng().iEi.gQU.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c11851");
            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(anVar);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = an.this.iEZ.cks().aCm().getAlaUserData().live_id;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(an.this.iDW.cng(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
        }
    };
    private boolean aqb = false;
    String userId = null;
    private final List<TbImageView> iPD = new ArrayList();
    private boolean iPF = false;

    /* loaded from: classes9.dex */
    public static class a {
        public int headerCount;
        public aj iPT;
        public int iwS;
    }

    public void qf(boolean z) {
        this.iPc = z;
        if (this.iNM != null) {
            this.iPd = this.iNM.getHeaderViewsCount();
        }
    }

    public void cpc() {
        if (this.iNM != null) {
            int headerViewsCount = this.iNM.getHeaderViewsCount() - this.iPd;
            final int firstVisiblePosition = (this.iNM.getFirstVisiblePosition() == 0 || this.iNM.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.iNM.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.iNM.getChildAt(0);
            final int top2 = childAt != null ? childAt.getTop() : -1;
            this.iOP.iPT = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iOP));
            final aj ajVar = this.iOP.iPT;
            final int f = f(ajVar);
            final int y = ((int) this.iNW.getY()) + this.iNW.getMeasuredHeight();
            final boolean z = this.iOJ.getVisibility() == 0;
            boolean z2 = this.iNW.getY() < 0.0f;
            if ((z && ajVar != null) || firstVisiblePosition >= this.iNX.clZ() + this.iNM.getHeaderViewsCount()) {
                int measuredHeight = ajVar != null ? ajVar.iNj.getMeasuredHeight() : 0;
                if (z2) {
                    this.iNM.setSelectionFromTop(this.iNX.clZ() + this.iNM.getHeaderViewsCount(), iOM - measuredHeight);
                } else {
                    this.iNM.setSelectionFromTop(this.iNX.clZ() + this.iNM.getHeaderViewsCount(), this.iNI.cqX().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.iNM.setSelectionFromTop(firstVisiblePosition, top2);
            }
            if (this.iPe && this.iNO != null) {
                this.iNM.setSelectionFromTop(this.iNX.clZ() + this.iNM.getHeaderViewsCount(), this.iNO.cqJ());
            } else if (this.mType == 6) {
                this.iNM.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.an.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void cnq() {
                        ViewGroup.LayoutParams layoutParams;
                        if (f >= 0 && f <= an.this.aCP.getMeasuredHeight()) {
                            int f2 = an.this.f(ajVar);
                            int i = f2 - f;
                            if (z && i != 0 && f <= y) {
                                i = f2 - y;
                            }
                            if (an.this.aDw != null && (layoutParams = an.this.aDw.getLayoutParams()) != null) {
                                if (i == 0 || i > an.this.aCP.getMeasuredHeight() || f2 >= an.this.aCP.getMeasuredHeight()) {
                                    layoutParams.height = an.this.iOY;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > an.this.aCP.getMeasuredHeight()) {
                                    layoutParams.height = an.this.iOY;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    an.this.iNM.setSelectionFromTop(firstVisiblePosition, top2);
                                }
                                an.this.aDw.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (an.this.aDw != null && an.this.aDw.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = an.this.aDw.getLayoutParams();
                                            layoutParams2.height = an.this.iOY;
                                            an.this.aDw.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        an.this.iNM.setOnLayoutListener(null);
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

    public NoNetworkView cpd() {
        return this.fUO;
    }

    public void cpe() {
        if (this.FO != null) {
            this.FO.hide();
            if (this.iPm != null) {
                this.iPm.cqL();
            }
        }
    }

    public PbFakeFloorModel cpf() {
        return this.iGW;
    }

    public s cpg() {
        return this.iPa;
    }

    public com.baidu.tieba.pb.pb.main.a.e cph() {
        return this.iNO;
    }

    public void cpi() {
        reset();
        cpe();
        this.iPa.cmh();
        qr(false);
    }

    private void reset() {
        if (this.iDW != null && this.iDW.cmm() != null && this.FO != null) {
            com.baidu.tbadk.editortools.pb.a.aON().setStatus(0);
            com.baidu.tbadk.editortools.pb.e cmm = this.iDW.cmm();
            cmm.aPh();
            cmm.aOB();
            if (cmm.getWriteImagesInfo() != null) {
                cmm.getWriteImagesInfo().setMaxImagesAllowed(cmm.isBJH ? 1 : 9);
            }
            cmm.mv(SendView.ALL);
            cmm.mw(SendView.ALL);
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

    public boolean cpj() {
        return this.iOB;
    }

    public void qg(boolean z) {
        if (this.iOv != null && this.hgK != null) {
            this.hgK.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iOv.startAnimation(alphaAnimation);
            }
            this.iOu.setVisibility(0);
            this.iOv.setVisibility(0);
            this.iOB = true;
            if (this.iOQ != null && !this.iPn.isActive()) {
                this.iOQ.setVisibility(0);
                ql(true);
            }
        }
    }

    public void qh(boolean z) {
        if (this.iOv != null && this.hgK != null) {
            this.hgK.setText(cpk());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iOv.startAnimation(alphaAnimation);
            }
            this.iOu.setVisibility(0);
            this.iOv.setVisibility(0);
            this.iOB = true;
            if (this.iOQ != null && !this.iPn.isActive()) {
                this.iOQ.setVisibility(0);
                ql(true);
            }
        }
    }

    public String cpk() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.iPr)) {
            return this.iPr;
        }
        if (this.iDW != null) {
            this.iPr = TbadkCoreApplication.getInst().getResources().getString(am.coZ());
        }
        return this.iPr;
    }

    public PostData cpl() {
        int i = 0;
        if (this.iNM == null) {
            return null;
        }
        int cpm = cpm() - this.iNM.getHeaderViewsCount();
        if (cpm < 0) {
            cpm = 0;
        }
        if (this.iNX.yG(cpm) != null && this.iNX.yG(cpm) != PostData.kgq) {
            i = cpm + 1;
        }
        return this.iNX.getItem(i) instanceof PostData ? (PostData) this.iNX.getItem(i) : null;
    }

    public int cpm() {
        int i;
        View childAt;
        if (this.iNM == null) {
            return 0;
        }
        int firstVisiblePosition = this.iNM.getFirstVisiblePosition();
        int lastVisiblePosition = this.iNM.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.iNM.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.iNM.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int cpn() {
        return this.iNM.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.iEZ != null && this.iEZ.cku() != null && !this.iEZ.cku().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.iEZ.cku().size() && (postData = this.iEZ.cku().get(i)) != null && postData.aCm() != null && !StringUtils.isNull(postData.aCm().getUserId()); i++) {
                if (this.iEZ.cku().get(i).aCm().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.iPn != null && this.iPn.isActive()) {
                        qr(false);
                    }
                    if (this.iOQ != null) {
                        this.iOQ.qA(true);
                    }
                    this.iPv = postData.aCm().getName_show();
                    return;
                }
            }
        }
    }

    public an(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.iDW = null;
        this.aCP = null;
        this.aCa = null;
        this.iNM = null;
        this.iNX = null;
        this.guL = null;
        this.dCM = null;
        this.gqo = null;
        this.iEQ = null;
        this.iOv = null;
        this.hgK = null;
        this.iOG = null;
        this.iPh = 0;
        this.iPs = 0L;
        this.iPs = System.currentTimeMillis();
        this.iDW = pbFragment;
        this.gqo = onClickListener;
        this.dqJ = cVar;
        this.iPh = com.baidu.adp.lib.util.l.getEquipmentWidth(this.iDW.getContext()) / 2;
        this.aCP = (RelativeLayout) LayoutInflater.from(this.iDW.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.aCP.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.iOs = this.aCP.findViewById(R.id.bottom_shadow);
        this.gNn = (NavigationBarCoverTip) this.aCP.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.aCa = this.aCP.findViewById(R.id.statebar_view);
        this.iNW = (ObservedChangeRelativeLayout) this.aCP.findViewById(R.id.title_wrapper);
        this.fUO = (NoNetworkView) this.aCP.findViewById(R.id.view_no_network);
        this.iNM = (PbLandscapeListView) this.aCP.findViewById(R.id.new_pb_list);
        this.iOI = (FrameLayout) this.aCP.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.iDW.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.iDW.getActivity(), R.dimen.ds88));
        this.iNM.addHeaderView(this.textView, 0);
        this.iNM.setTextViewAdded(true);
        this.iOY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.aDw = new View(this.iDW.getPageContext().getPageActivity());
        this.aDw.setLayoutParams(new AbsListView.LayoutParams(-1, this.iOY));
        this.aDw.setVisibility(4);
        this.iNM.addFooterView(this.aDw);
        this.iNM.setOnTouchListener(this.iDW.drz);
        this.iNI = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.aCP);
        if (this.iDW.cmQ()) {
            this.iNK = (ViewStub) this.aCP.findViewById(R.id.manga_view_stub);
            this.iNK.setVisibility(0);
            this.iNJ = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.iNJ.show();
            this.iNI.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.iDW.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.iNI.cqX().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0568a() { // from class: com.baidu.tieba.pb.pb.main.an.25
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0568a
            public void clj() {
                if (an.this.iNM != null) {
                    if (an.this.iNO != null) {
                        an.this.iNO.cqI();
                    }
                    an.this.iNM.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0568a
            public void clk() {
                an.this.iDW.bEj();
            }
        }));
        this.iOu = this.aCP.findViewById(R.id.view_comment_top_line);
        this.iOv = this.aCP.findViewById(R.id.pb_editor_tool_comment);
        this.iOC = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iOD = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.hgK = (TextView) this.aCP.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.hgK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                an.this.iDW.cmx();
                if (an.this.iDW != null && an.this.iDW.clz() != null && an.this.iDW.clz().getPbData() != null && an.this.iDW.clz().getPbData().cks() != null && an.this.iDW.clz().getPbData().cks().aCm() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cy("tid", an.this.iDW.clz().iJU).cy("fid", an.this.iDW.clz().getPbData().getForumId()).X("obj_locate", 1).cy("uid", an.this.iDW.clz().getPbData().cks().aCm().getUserId()));
                }
            }
        });
        this.iOw = (ImageView) this.aCP.findViewById(R.id.pb_editor_tool_comment_icon);
        this.iOw.setOnClickListener(this.gqo);
        boolean booleanExtra = this.iDW.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.iOx = (ImageView) this.aCP.findViewById(R.id.pb_editor_tool_collection);
        this.iOx.setOnClickListener(this.gqo);
        if (booleanExtra) {
            this.iOx.setVisibility(8);
        } else {
            this.iOx.setVisibility(0);
        }
        this.iOy = (ImageView) this.aCP.findViewById(R.id.pb_editor_tool_share);
        this.iOy.setOnClickListener(this.gqo);
        this.iOz = new com.baidu.tieba.pb.view.c(this.iOy);
        this.iOz.cuh();
        this.iOA = (TextView) this.aCP.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.iOG = (ViewStub) this.aCP.findViewById(R.id.interview_status_stub);
        this.iNP = new com.baidu.tieba.pb.pb.main.a.a(this.iDW, cVar);
        this.iNR = new com.baidu.tieba.pb.pb.main.a.d(this.iDW, cVar, this.gqo);
        this.iNX = new f(this.iDW, this.iNM);
        this.iNX.D(this.gqo);
        this.iNX.setTbGestureDetector(this.dqJ);
        this.iNX.setOnImageClickListener(this.dMw);
        this.iEQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.27
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
                            an.this.iDW.b(sparseArray);
                            return;
                        }
                        an.this.cA(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        an.this.iDW.b(sparseArray);
                    } else if (booleanValue3) {
                        an.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.iNX.P(this.iEQ);
        cps();
        cpt();
        this.iNR.b(this.iNM);
        this.iNQ.b(this.iNM);
        this.iNP.b(this.iNM);
        this.guL = new PbListView(this.iDW.getPageContext().getPageActivity());
        this.dCM = this.guL.getView().findViewById(R.id.pb_more_view);
        if (this.dCM != null) {
            this.dCM.setOnClickListener(this.gqo);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.dCM, R.drawable.pb_foot_more_trans_selector);
        }
        this.guL.setLineVisible();
        this.guL.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.guL.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.iOd = this.aCP.findViewById(R.id.viewstub_progress);
        this.iDW.registerListener(this.iPz);
        this.iGW = new PbFakeFloorModel(this.iDW.getPageContext());
        this.iPa = new s(this.iDW.getPageContext(), this.iGW, this.aCP);
        this.iPa.a(this.iDW.iIy);
        this.iGW.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.an.28
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                an.this.iGW.q(postData);
                an.this.iNX.notifyDataSetChanged();
                an.this.iPa.cmh();
                an.this.FO.aMO();
                an.this.qr(false);
            }
        });
        if (this.iDW.clz() != null && !StringUtils.isNull(this.iDW.clz().coe())) {
            this.iDW.showToast(this.iDW.clz().coe());
        }
        this.iOJ = this.aCP.findViewById(R.id.pb_expand_blank_view);
        this.iOK = this.aCP.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iOK.getLayoutParams();
        if (this.iDW.clz() != null && this.iDW.clz().cnz()) {
            this.iOJ.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.iOK.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = iOM;
            this.iOK.setLayoutParams(layoutParams2);
        }
        this.iOL = new aj(this.iDW.getPageContext(), this.aCP.findViewById(R.id.pb_reply_expand_view));
        this.iOL.iNj.setVisibility(8);
        this.iOL.Q(this.gqo);
        this.iDW.registerListener(this.mAccountChangedListener);
        this.iDW.registerListener(this.iPw);
        cpo();
        ql(false);
    }

    public void qi(boolean z) {
        this.iOs.setVisibility(z ? 0 : 8);
    }

    public void bPv() {
        if (!this.iDW.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").X("obj_locate", 2).cy("fid", this.mForumId));
        } else if (this.iDW.cmz()) {
            com.baidu.tbadk.editortools.pb.e cmm = this.iDW.cmm();
            if (cmm != null && (cmm.aPe() || cmm.aPf())) {
                this.iDW.cmm().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.FO != null) {
                cpy();
            }
            if (this.FO != null) {
                this.iOB = false;
                if (this.FO.mp(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.iDW.getPageContext(), (View) this.FO.mp(2).dwz, false, iPt);
                }
            }
            cqg();
        }
    }

    private void cpo() {
        this.iPn = new com.baidu.tieba.pb.pb.godreply.a(this.iDW, this, (ViewStub) this.aCP.findViewById(R.id.more_god_reply_popup));
        this.iPn.y(this.gqo);
        this.iPn.P(this.iEQ);
        this.iPn.setOnImageClickListener(this.dMw);
        this.iPn.y(this.gqo);
        this.iPn.setTbGestureDetector(this.dqJ);
    }

    public com.baidu.tieba.pb.pb.godreply.a cpp() {
        return this.iPn;
    }

    public View cpq() {
        return this.iOJ;
    }

    public void cpr() {
        if (this.iNM != null) {
            this.iNQ.c(this.iNM);
            this.iNR.c(this.iNM);
            this.iNS.c(this.iNM);
            this.iNP.c(this.iNM);
        }
    }

    private void cps() {
        if (this.iNS == null) {
            this.iNS = new com.baidu.tieba.pb.pb.main.a.b(this.iDW, this.gqo);
        }
    }

    private void cpt() {
        if (this.iNQ == null) {
            this.iNQ = new com.baidu.tieba.pb.pb.main.a.c(this.iDW, this.dqJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpu() {
        if (this.iDW.cmQ()) {
            this.iNL = (ViewStub) this.aCP.findViewById(R.id.manga_mention_controller_view_stub);
            this.iNL.setVisibility(0);
            if (this.iNT == null) {
                this.iNT = (LinearLayout) this.aCP.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.q.a.a(this.iDW.getPageContext(), this.iNT);
            }
            if (this.iNU == null) {
                this.iNU = (TextView) this.iNT.findViewById(R.id.manga_prev_btn);
            }
            if (this.iNV == null) {
                this.iNV = (TextView) this.iNT.findViewById(R.id.manga_next_btn);
            }
            this.iNU.setOnClickListener(this.gqo);
            this.iNV.setOnClickListener(this.gqo);
        }
    }

    private void cpv() {
        if (this.iDW.cmQ()) {
            if (this.iDW.cmT() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iNU, R.color.cp_cont_e, 1);
            }
            if (this.iDW.cmU() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iNV, R.color.cp_cont_e, 1);
            }
        }
    }

    public void cpw() {
        if (this.iNT == null) {
            cpu();
        }
        this.iNL.setVisibility(8);
        if (this.iPx != null && this.iPy != null) {
            this.iPx.removeCallbacks(this.iPy);
        }
    }

    public void cpx() {
        if (this.iPx != null) {
            if (this.iPy != null) {
                this.iPx.removeCallbacks(this.iPy);
            }
            this.iPy = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.3
                @Override // java.lang.Runnable
                public void run() {
                    if (an.this.iNT == null) {
                        an.this.cpu();
                    }
                    an.this.iNL.setVisibility(0);
                }
            };
            this.iPx.postDelayed(this.iPy, 2000L);
        }
    }

    public void qj(boolean z) {
        this.iNI.qj(z);
        if (z && this.iOF) {
            this.guL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.iNM.setNextPage(this.guL);
            this.iNH = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
        this.FO.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.FO.getParent() == null) {
            this.aCP.addView(this.FO, layoutParams);
        }
        this.FO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.FO.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.an.5
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).aJu() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).aJu() == EmotionGroupType.USER_COLLECT) {
                        if (an.this.mPermissionJudgePolicy == null) {
                            an.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                        }
                        an.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        an.this.mPermissionJudgePolicy.appendRequestPermission(an.this.iDW.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!an.this.mPermissionJudgePolicy.startRequestPermission(an.this.iDW.getBaseFragmentActivity())) {
                            an.this.iDW.cmm().c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            an.this.iDW.cmm().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cpe();
        this.iDW.cmm().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.an.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (an.this.FO != null && an.this.FO.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (an.this.iPm == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, an.this.FO.getId());
                            an.this.iPm = new com.baidu.tieba.pb.pb.main.emotion.c(an.this.iDW.getPageContext(), an.this.aCP, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.isEmpty(an.this.iPl)) {
                                an.this.iPm.setData(an.this.iPl);
                            }
                            an.this.iPm.b(an.this.FO);
                        }
                        an.this.iPm.Gk(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (an.this.iDW.iHF != null && an.this.iDW.iHF.cqv() != null) {
                    if (!an.this.iDW.iHF.cqv().cUd()) {
                        an.this.iDW.iHF.qw(false);
                    }
                    an.this.iDW.iHF.cqv().tH(false);
                }
            }
        });
    }

    public void cpy() {
        if (this.iDW != null && this.FO != null) {
            this.FO.display();
            if (this.iDW.cmm() != null) {
                this.iDW.cmm().aOU();
            }
            cqg();
        }
    }

    public void qk(boolean z) {
        if (this.iNM != null && this.textView != null && this.aCa != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.aCa.setVisibility(0);
                } else {
                    this.aCa.setVisibility(8);
                    this.iNM.removeHeaderView(this.textView);
                    this.iNM.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = iOM;
                    this.textView.setLayoutParams(layoutParams);
                }
                cpM();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + qt(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            cpM();
            cqo();
        }
    }

    public f cpz() {
        return this.iNX;
    }

    public void a(PbFragment.c cVar) {
        this.iID = cVar;
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
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iDW.getContext());
        kVar.setTitleText(this.iDW.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.7
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.iOe.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            an.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (an.this.iPA != null) {
                                an.this.iPA.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            an.this.iDW.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.iDW.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.iDW.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !cqn()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.iDW.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.iDW.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.iDW.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.az(arrayList);
        if (this.iOe == null) {
            this.iOe = new com.baidu.tbadk.core.dialog.i(this.iDW.getPageContext(), kVar);
        } else {
            this.iOe.a(kVar);
        }
        this.iOe.showDialog();
    }

    public void a(PbFragment.b bVar) {
        this.iPA = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.iDW != null && aVar != null) {
            if (this.gQh == null && this.iNP != null) {
                this.gQh = new com.baidu.tieba.NEGFeedBack.e(this.iDW.getPageContext(), this.iNP.cqF());
            }
            AntiData bCW = this.iDW.bCW();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bCW != null && bCW.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bCW.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.setFeedBackReasonMap(sparseArray);
            this.gQh.setDefaultReasonArray(new String[]{this.iDW.getString(R.string.delete_thread_reason_1), this.iDW.getString(R.string.delete_thread_reason_2), this.iDW.getString(R.string.delete_thread_reason_3), this.iDW.getString(R.string.delete_thread_reason_4), this.iDW.getString(R.string.delete_thread_reason_5)});
            this.gQh.setData(alVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.gQh.wm(str);
            this.gQh.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.an.8
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    an.this.iDW.a(aVar, jSONArray);
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
        sparseArray.put(iOT, Integer.valueOf(iOU));
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
        this.iOf = new com.baidu.tbadk.core.dialog.a(this.iDW.getActivity());
        if (StringUtils.isNull(str2)) {
            this.iOf.jW(i3);
        } else {
            this.iOf.setOnlyMessageShowCenter(false);
            this.iOf.sS(str2);
        }
        this.iOf.setYesButtonTag(sparseArray);
        this.iOf.a(R.string.dialog_ok, this.iDW);
        this.iOf.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iOf.fG(true);
        this.iOf.b(this.iDW.getPageContext());
        if (z) {
            this.iOf.aEA();
        } else {
            a(this.iOf, i);
        }
    }

    public void aM(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.iOi == null) {
            this.iOi = LayoutInflater.from(this.iDW.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.iDW.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iOi);
        if (this.iOh == null) {
            this.iOh = new Dialog(this.iDW.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iOh.setCanceledOnTouchOutside(true);
            this.iOh.setCancelable(true);
            this.iOq = (ScrollView) this.iOi.findViewById(R.id.good_scroll);
            this.iOh.setContentView(this.iOi);
            WindowManager.LayoutParams attributes = this.iOh.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.iOh.getWindow().setAttributes(attributes);
            this.fLT = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.an.10
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        an.this.iOm = (String) compoundButton.getTag();
                        if (an.this.fLS != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : an.this.fLS) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && an.this.iOm != null && !str.equals(an.this.iOm)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.iOj = (LinearLayout) this.iOi.findViewById(R.id.good_class_group);
            this.iOl = (TextView) this.iOi.findViewById(R.id.dialog_button_cancel);
            this.iOl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.iOh instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(an.this.iOh, an.this.iDW.getPageContext());
                    }
                }
            });
            this.iOk = (TextView) this.iOi.findViewById(R.id.dialog_button_ok);
            this.iOk.setOnClickListener(this.gqo);
        }
        this.iOj.removeAllViews();
        this.fLS = new ArrayList();
        CustomBlueCheckRadioButton ef = ef("0", this.iDW.getPageContext().getString(R.string.thread_good_class));
        this.fLS.add(ef);
        ef.setChecked(true);
        this.iOj.addView(ef);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ad adVar = arrayList.get(i2);
                if (adVar != null && !TextUtils.isEmpty(adVar.aAH()) && adVar.aAI() > 0) {
                    CustomBlueCheckRadioButton ef2 = ef(String.valueOf(adVar.aAI()), adVar.aAH());
                    this.fLS.add(ef2);
                    View view = new View(this.iDW.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.iOj.addView(view);
                    this.iOj.addView(ef2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.iOq.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iDW.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iDW.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iDW.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.iOq.setLayoutParams(layoutParams2);
            this.iOq.removeAllViews();
            if (this.iOj != null && this.iOj.getParent() == null) {
                this.iOq.addView(this.iOj);
            }
        }
        com.baidu.adp.lib.f.g.a(this.iOh, this.iDW.getPageContext());
    }

    private CustomBlueCheckRadioButton ef(String str, String str2) {
        Activity pageActivity = this.iDW.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.fLT);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void cpA() {
        this.iDW.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.iDW.hideProgressBar();
        if (z && z2) {
            this.iDW.showToast(this.iDW.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.iDW.showToast(str);
        }
    }

    public void bWq() {
        this.iOd.setVisibility(0);
    }

    public void bWp() {
        this.iOd.setVisibility(8);
    }

    public View cpB() {
        if (this.iOi != null) {
            return this.iOi.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String cpC() {
        return this.iOm;
    }

    public View getView() {
        return this.aCP;
    }

    public void cpD() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.iDW.getPageContext().getPageActivity(), this.iDW.getBaseFragmentActivity().getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.iDW.hideProgressBar();
        if (z) {
            cpW();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            cpX();
        } else {
            cpW();
        }
    }

    public void cpE() {
        this.guL.setLineVisible();
        this.guL.startLoadData();
    }

    public void cpF() {
        this.iDW.hideProgressBar();
        endLoadData();
        this.iNM.completePullRefreshPostDelayed(0L);
        cpR();
    }

    public void cpG() {
        this.iNM.completePullRefreshPostDelayed(0L);
        cpR();
    }

    private void ql(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.iNR.b(onLongClickListener);
        this.iNX.setOnLongClickListener(onLongClickListener);
        if (this.iPn != null) {
            this.iPn.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.iHG != null) {
            this.iHG.dismiss();
            this.iHG = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iDW.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.iDW.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iDW.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iDW.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iDW.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.az(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.iOn.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iOn = new com.baidu.tbadk.core.dialog.i(this.iDW.getPageContext(), kVar);
        this.iOn.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.iOn != null) {
            this.iOn.dismiss();
            this.iOn = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iDW.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.iEZ != null && this.iEZ.cks() != null && !this.iEZ.cks().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.iDW.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iDW.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.az(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.iOn.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iOn = new com.baidu.tbadk.core.dialog.i(this.iDW.getPageContext(), kVar);
        this.iOn.showDialog();
    }

    public int cpH() {
        return zd(this.iNM.getFirstVisiblePosition());
    }

    private int zd(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.iNM.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.iNM.getAdapter() == null || !(this.iNM.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.iNM.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int cpI() {
        int lastVisiblePosition = this.iNM.getLastVisiblePosition();
        if (this.iNO != null) {
            if (lastVisiblePosition == this.iNM.getCount() - 1) {
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
        if (this.iNM != null) {
            if (this.iNI == null || this.iNI.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.iNI.mNavigationBar.getFixedNavHeight();
                if (this.iDW.cmG() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.iOK != null && (layoutParams = (LinearLayout.LayoutParams) this.iOK.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.iOK.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.iNM.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.iNM.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.iNM.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.iOa.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void o(com.baidu.tieba.pb.data.e eVar) {
        int i;
        this.iNX.a(eVar, false);
        this.iNX.notifyDataSetChanged();
        cpR();
        if (this.iPn != null) {
            this.iPn.clv();
        }
        ArrayList<PostData> cku = eVar.cku();
        if (eVar.getPage().aBi() == 0 || cku == null || cku.size() < eVar.getPage().aBh()) {
            if (com.baidu.tbadk.core.util.v.getCount(cku) == 0 || (com.baidu.tbadk.core.util.v.getCount(cku) == 1 && cku.get(0) != null && cku.get(0).cKY() == 1)) {
                if (this.iOP == null || this.iOP.iPT == null || this.iOP.iPT.getView() == null) {
                    i = 0;
                } else {
                    i = this.iOP.iPT.getView().getTop() < 0 ? this.iOP.iPT.getView().getHeight() : this.iOP.iPT.getView().getBottom();
                }
                if (this.iDW.cna()) {
                    this.guL.ab(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.guL.ab(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (eVar.getPage().aBi() == 0) {
                    this.guL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.guL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.guL.aHF();
            }
        }
        q(eVar);
    }

    public void p(com.baidu.tieba.pb.data.e eVar) {
        if (this.iNP != null) {
            this.iNP.e(eVar, this.iEI);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.e eVar, boolean z) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.ckC() != null) {
            return eVar.ckC();
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.cku())) {
            Iterator<PostData> it = eVar.cku().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cKY() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.ckz();
        }
        if (!o(postData)) {
            postData = a(eVar);
        }
        if (postData != null && postData.aCm() != null && postData.aCm().getUserTbVipInfoData() != null && postData.aCm().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aCm().getGodUserData().setIntro(postData.aCm().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean o(PostData postData) {
        if (postData == null || postData.aCm() == null) {
            return false;
        }
        MetaData aCm = postData.aCm();
        return (TextUtils.isEmpty(aCm.getUserId()) && TextUtils.isEmpty(aCm.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cks() == null || eVar.cks().aCm() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aCm = eVar.cks().aCm();
        String userId = aCm.getUserId();
        HashMap<String, MetaData> userMap = eVar.cks().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aCm;
        }
        postData.Cw(1);
        postData.setId(eVar.cks().aCC());
        postData.setTitle(eVar.cks().getTitle());
        postData.setTime(eVar.cks().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.e eVar, boolean z, int i, int i2) {
        if (eVar != null && eVar.cks() != null) {
            if (this.iDW.clp()) {
                if (eVar.ckr() != null) {
                    this.mForumName = eVar.ckr().getForumName();
                    this.mForumId = eVar.ckr().getForumId();
                }
                if (this.mForumName == null && this.iDW.clz() != null && this.iDW.clz().clq() != null) {
                    this.mForumName = this.iDW.clz().clq();
                }
            }
            PostData b = b(eVar, z);
            a(b, eVar);
            this.iNR.setVisibility(8);
            if (eVar.aHI()) {
                this.iPe = true;
                this.iNI.qH(true);
                this.iNI.mNavigationBar.hideBottomLine();
                if (this.iNO == null) {
                    this.iNO = new com.baidu.tieba.pb.pb.main.a.e(this.iDW);
                }
                this.iNO.a(eVar, b, this.iNM, this.iNR, this.iOI, this.iNI, this.mForumName, this.iPs);
                this.iNO.R(this.iPC);
                cpM();
            } else {
                this.iPe = false;
                this.iNI.qH(this.iPe);
                if (this.iNO != null) {
                    this.iNO.c(this.iNM);
                }
            }
            if (this.iDW.cmp() != null) {
                this.iDW.cmp().qB(this.iPe);
            }
            if (b != null) {
                this.iOE = b;
                this.iNR.setVisibility(0);
                SparseArray<Object> cqH = this.iNR.cqH();
                cqH.put(R.id.tag_clip_board, b);
                cqH.put(R.id.tag_is_subpb, false);
                this.iNS.a(eVar, this.iNM);
                this.iNQ.w(eVar);
                this.iNP.e(eVar, this.iEI);
                this.iNP.v(eVar);
                this.iNR.a(this.mSkinType, this.iEZ, b, this.iPC);
                if (this.iOL != null) {
                    if (eVar.ckQ()) {
                        this.iOL.getView().setVisibility(8);
                    } else {
                        this.iOL.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.iCB);
                        if (eVar.cks() != null) {
                            jVar.iCD = eVar.cks().aCd();
                        }
                        jVar.isNew = !this.iEI;
                        jVar.sortType = eVar.iBC;
                        jVar.iCF = eVar.ckR();
                        jVar.iCG = this.iDW.cna();
                        this.iOL.a(jVar);
                    }
                }
                if (eVar != null && eVar.cks() != null) {
                    af(eVar.cks().aCi() == 1, eVar.cks().aCh() == 1);
                }
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (an.this.iNX != null && an.this.iNI != null && an.this.iNI.iTP != null && an.this.iEZ != null && an.this.iEZ.cks() != null && !an.this.iEZ.cks().aAZ() && !an.this.cpQ() && an.this.iEZ.getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(an.this.iEZ.getForum().getName())) {
                            if (an.this.iNX.cmd() == null || !an.this.iNX.cmd().isShown()) {
                                an.this.iNI.iTP.setVisibility(0);
                                if (an.this.iDW != null && an.this.iDW.clz() != null) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13400");
                                    anVar.cy("tid", an.this.iDW.clz().cnw());
                                    anVar.cy("fid", an.this.iDW.clz().getForumId());
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
            cpJ();
        } else {
            byH();
        }
        this.iOP.iPT = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iOP));
        a(this.iOP.iPT, false);
    }

    public void cpJ() {
        if (this.iNI != null && !this.iPg) {
            this.iNI.cpJ();
            this.iPg = true;
        }
    }

    public void byH() {
        if (this.iNI != null) {
            this.iNI.crf();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        this.iNR.a(postData, eVar);
    }

    public void cpK() {
        if (this.iNO != null) {
            this.iNO.d(this.iNM);
        }
    }

    public boolean cpL() {
        return this.aqb;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aI(bj bjVar) {
        if (bjVar == null || bjVar.aCm() == null) {
            return false;
        }
        PostData b = b(this.iEZ, false);
        String str = "";
        if (b != null && b.aCm() != null) {
            str = b.aCm().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.iNI.crd();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.iNI.DT(dVar.forumName);
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
            final String str2 = dVar.iBu;
            this.iDW.showNetRefreshView(this.aCP, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        ba.aGE().b(an.this.iDW.getPageContext(), new String[]{str2});
                        an.this.iDW.finish();
                        return;
                    }
                    an.this.iDW.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable coP;
        Parcelable coP2;
        if (eVar != null && this.iNM != null) {
            this.iEZ = eVar;
            this.mType = i;
            if (eVar.cks() != null) {
                this.iOR = eVar.cks().aBT();
                if (eVar.cks().getAnchorLevel() != 0) {
                    this.aqb = true;
                }
                this.iOp = aI(eVar.cks());
            }
            if (eVar.getUserData() != null) {
                this.userId = eVar.getUserData().getUserId();
            }
            u(eVar);
            this.iOF = false;
            this.iEI = z;
            cpF();
            if (eVar.iBD != null && eVar.iBD.ckV()) {
                if (this.iNN == null) {
                    this.iNN = new PbThreadPostView(this.iDW.getContext());
                    this.iNM.addHeaderView(this.iNN, 1);
                    this.iNN.setData(eVar);
                    this.iNN.setChildOnClickLinstener(this.gqo);
                }
            } else if (this.iNN != null && this.iNM != null) {
                this.iNM.removeHeaderView(this.iNN);
            }
            a(eVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            r(eVar);
            if (this.iPq == null) {
                this.iPq = new aa(this.iDW.getPageContext(), this.gNn);
            }
            this.iPq.Ga(eVar.ckx());
            if (this.iDW.cmQ()) {
                if (this.iOb == null) {
                    this.iOb = new com.baidu.tieba.pb.view.d(this.iDW.getPageContext());
                    this.iOb.createView();
                    this.iOb.setListPullRefreshListener(this.dgH);
                }
                this.iNM.setPullRefresh(this.iOb);
                cpM();
                if (this.iOb != null) {
                    this.iOb.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (eVar.getPage().aBj() == 0 && z) {
                this.iNM.setPullRefresh(null);
            } else {
                if (this.iOb == null) {
                    this.iOb = new com.baidu.tieba.pb.view.d(this.iDW.getPageContext());
                    this.iOb.createView();
                    this.iOb.setListPullRefreshListener(this.dgH);
                }
                this.iNM.setPullRefresh(this.iOb);
                cpM();
                if (this.iOb != null) {
                    this.iOb.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                bqp();
            }
            cpR();
            this.iNX.px(this.iEI);
            this.iNX.py(false);
            this.iNX.pC(i == 5);
            this.iNX.pD(i == 6);
            this.iNX.pE(z2 && this.iPB);
            this.iNX.a(eVar, false);
            this.iNX.notifyDataSetChanged();
            this.iNR.a(b(eVar, z), eVar.ckQ());
            if (eVar.cks() != null && eVar.cks().aBX() != null && this.iNG != -1) {
                eVar.cks().aBX().setIsLike(this.iNG);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.iNM.setNextPage(this.guL);
                this.iNH = 2;
                bqp();
            } else {
                this.iOF = true;
                if (eVar.getPage().aBi() == 1) {
                    if (this.iOc == null) {
                        this.iOc = new com.baidu.tieba.pb.view.a(this.iDW, this.iDW);
                    }
                    this.iNM.setNextPage(this.iOc);
                } else {
                    this.iNM.setNextPage(this.guL);
                }
                this.iNH = 3;
            }
            ArrayList<PostData> cku = eVar.cku();
            if (eVar.getPage().aBi() == 0 || cku == null || cku.size() < eVar.getPage().aBh()) {
                if (com.baidu.tbadk.core.util.v.getCount(cku) == 0 || (com.baidu.tbadk.core.util.v.getCount(cku) == 1 && cku.get(0) != null && cku.get(0).cKY() == 1)) {
                    if (this.iOP == null || this.iOP.iPT == null || this.iOP.iPT.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.iOP.iPT.getView().getTop() < 0 ? this.iOP.iPT.getView().getHeight() : this.iOP.iPT.getView().getBottom();
                    }
                    if (this.iDW.cna()) {
                        this.guL.ab(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.guL.ab(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.iDW.cmp() != null && !this.iDW.cmp().cqR()) {
                        this.iDW.cmp().showFloatingView();
                    }
                } else {
                    if (eVar.getPage().aBi() == 0) {
                        this.guL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.guL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.guL.aHF();
                }
                if (eVar.getPage().aBi() == 0 || cku == null) {
                    cqb();
                }
            } else {
                if (z2) {
                    if (this.iPB) {
                        endLoadData();
                        if (eVar.getPage().aBi() != 0) {
                            this.guL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.guL.setLineVisible();
                        this.guL.showLoading();
                    }
                } else {
                    this.guL.setLineVisible();
                    this.guL.showLoading();
                }
                this.guL.aHF();
            }
            switch (i) {
                case 2:
                    this.iNM.setSelection(i2 > 1 ? (((this.iNM.getData() == null && eVar.cku() == null) ? 0 : (this.iNM.getData().size() - eVar.cku().size()) + this.iNM.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (coP2 = ah.coO().coP()) != null && !(coP2 instanceof RecyclerView.SavedState)) {
                        this.iNM.onRestoreInstanceState(coP2);
                        if (com.baidu.tbadk.core.util.v.getCount(cku) > 1 && eVar.getPage().aBi() > 0) {
                            this.guL.endLoadData();
                            this.guL.setText(this.iDW.getString(R.string.pb_load_more_without_point));
                            this.guL.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.iPB = false;
                    break;
                case 5:
                    this.iNM.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (coP = ah.coO().coP()) != null && !(coP instanceof RecyclerView.SavedState)) {
                        this.iNM.onRestoreInstanceState(coP);
                        break;
                    } else {
                        this.iNM.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.iNO != null && this.iNO.bcI() != null) {
                            if (this.iDW.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.iNM.setSelectionFromTop((this.iNX.clY() + this.iNM.getHeaderViewsCount()) - 1, this.iNO.cqJ() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.iDW.getPageContext().getPageActivity()));
                            } else {
                                this.iNM.setSelectionFromTop((this.iNX.clY() + this.iNM.getHeaderViewsCount()) - 1, this.iNO.cqJ());
                            }
                        } else {
                            this.iNM.setSelection(this.iNX.clY() + this.iNM.getHeaderViewsCount());
                        }
                    } else {
                        this.iNM.setSelection(i2 > 0 ? ((this.iNM.getData() == null && eVar.cku() == null) ? 0 : (this.iNM.getData().size() - eVar.cku().size()) + this.iNM.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.guL.endLoadData();
                    this.guL.setText(this.iDW.getString(R.string.pb_load_more_without_point));
                    this.guL.setLineGone();
                    break;
            }
            if (this.iOR == iOS && isHost()) {
                cqj();
            }
            if (this.iPc) {
                cpc();
                this.iPc = false;
                if (i3 == 0) {
                    qf(true);
                }
            }
            if (eVar.iBz == 1 || eVar.iBA == 1) {
                if (this.iPi == null) {
                    this.iPi = new PbTopTipView(this.iDW.getContext());
                }
                if (eVar.iBA == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.iDW.getStType())) {
                    this.iPi.setText(this.iDW.getString(R.string.pb_read_strategy_add_experience));
                    this.iPi.a(this.aCP, this.mSkinType);
                } else if (eVar.iBz == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.iDW.getStType())) {
                    this.iPi.setText(this.iDW.getString(R.string.pb_read_news_add_experience));
                    this.iPi.a(this.aCP, this.mSkinType);
                }
            }
            q(eVar);
        }
    }

    private void q(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cks() != null) {
            t(eVar);
            if (eVar.ayJ()) {
                SvgManager.aGA().a(this.iOx, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aGA().a(this.iOx, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iOA.setText(zf(eVar.cks().aCd()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.cks()));
        }
    }

    private String zf(int i) {
        if (i == 0) {
            return this.iDW.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void cpM() {
        if (this.iNO != null) {
            this.iNO.a(this.iNM, this.textView, this.mType);
        }
    }

    public void qn(boolean z) {
        this.iOo = z;
    }

    public void endLoadData() {
        if (this.guL != null) {
            this.guL.setLineGone();
            this.guL.endLoadData();
        }
        bqp();
    }

    public void bgw() {
        this.iNM.setVisibility(0);
    }

    public void cpN() {
        if (this.iNM != null) {
            this.iNM.setVisibility(8);
        }
        if (this.iNM != null) {
            this.iOI.setVisibility(8);
        }
        if (this.iNI != null && this.iNI.iTM != null) {
            this.iNI.iTM.setVisibility(8);
        }
    }

    public void cpO() {
        if (this.iNM != null) {
            this.iNM.setVisibility(0);
        }
        if (this.iOI != null) {
            this.iOI.setVisibility(0);
        }
        if (this.iNI != null && this.iNI.iTM != null) {
            this.iNI.iTM.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void r(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && this.iOE != null && this.iOE.aCm() != null && this.iNI != null) {
            this.iPf = !this.iPe;
            this.iNI.qD(this.iPf);
            if (this.iDW.cmp() != null) {
                this.iDW.cmp().qC(this.iPf);
            }
            cpP();
            if (this.iDW != null && !this.iDW.clp() && !com.baidu.tbadk.core.util.v.isEmpty(eVar.ckL())) {
                bf bfVar = eVar.ckL().get(0);
                if (bfVar != null) {
                    this.iNI.eg(bfVar.getForumName(), bfVar.getAvatar());
                }
            } else if (eVar.getForum() != null) {
                this.iNI.eg(eVar.getForum().getName(), eVar.getForum().getImage_url());
            }
            if (this.iPf) {
                this.iNR.a(eVar, this.iOE, this.iOp);
                if (this.iOK != null) {
                    this.iOK.setVisibility(8);
                }
                if (this.iPo == null) {
                    this.iPo = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.an.18
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (an.this.iDW != null && an.this.iDW.isAdded()) {
                                if (i < 0 && f > an.this.iPh) {
                                    an.this.cqi();
                                }
                                an.this.cpG();
                            }
                        }
                    };
                }
                this.iNM.setListViewDragListener(this.iPo);
                return;
            }
            if (this.iOK != null) {
                this.iOK.setVisibility(0);
            }
            this.iNR.a(eVar, this.iOE, this.iOp);
            this.iPo = null;
            this.iNM.setListViewDragListener(null);
        }
    }

    private void cpP() {
        this.iNR.a(this.iEZ, this.iOE, this.iPf, this.iPe);
    }

    public boolean cpQ() {
        return this.iEZ == null || this.iEZ.getForum() == null || "0".equals(this.iEZ.getForum().getId()) || "me0407".equals(this.iEZ.getForum().getName());
    }

    private boolean cpR() {
        return this.iNP.qy(this.iEI);
    }

    private boolean s(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cks() == null) {
            return false;
        }
        if (eVar.cks().aCj() == 1 || eVar.cks().getThreadType() == 33) {
            return true;
        }
        return !(eVar.cks().aCl() == null || eVar.cks().aCl().aEr() == 0) || eVar.cks().aCh() == 1 || eVar.cks().aCi() == 1 || eVar.cks().aCX() || eVar.cks().aDq() || eVar.cks().aDk() || eVar.cks().aCy() != null || !com.baidu.tbadk.core.util.aq.isEmpty(eVar.cks().getCategory()) || eVar.cks().aCp() || eVar.cks().aCo();
    }

    public boolean c(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            if (this.iNQ != null) {
                if (eVar.cks() != null && eVar.cks().aCB() == 0 && !eVar.cks().aAZ() && !this.iPu) {
                    if (eVar.cks() != null) {
                        bj cks = eVar.cks();
                        cks.s(true, s(eVar));
                        cks.jI(3);
                        cks.sF("2");
                    }
                    if (eVar.cks().aBb()) {
                        this.iNR.c(this.iNM);
                        this.iNQ.c(this.iNM);
                        this.iNQ.b(this.iNM);
                        this.iNR.b(this.iNM);
                        this.iNR.B(this.iEZ);
                        this.iNQ.x(eVar);
                    } else {
                        this.iNR.B(this.iEZ);
                        this.iNQ.z(eVar);
                    }
                } else if (eVar.cks().aCB() == 1) {
                    if (eVar.cks() != null) {
                        this.iNQ.c(this.iNM);
                        this.iNR.B(this.iEZ);
                    }
                } else {
                    this.iNQ.c(this.iNM);
                    this.iNR.B(this.iEZ);
                }
            }
            if (eVar.cks() != null) {
                ae(eVar.cks().aCi() == 1, eVar.cks().aCh() == 1);
            }
            this.iEI = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            c(eVar, z);
            cpR();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.w wVar;
        StringBuilder sb = null;
        if (eVar != null && (b = b(eVar, z)) != null) {
            String userId = b.aCm().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.ckE()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.aCm() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.aCm().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.aCm().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.aCm().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.ckE()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bf> ckL = eVar.ckL();
                if (com.baidu.tbadk.core.util.v.getCount(ckL) > 0) {
                    sb = new StringBuilder();
                    for (bf bfVar : ckL) {
                        if (bfVar != null && !StringUtils.isNull(bfVar.getForumName()) && (wVar = bfVar.cQO) != null && wVar.cOI && !wVar.cOJ && (wVar.type == 1 || wVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bfVar.getForumName(), 12)).append(this.iDW.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.iDW.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View cpS() {
        return this.dCM;
    }

    public boolean cpT() {
        if (this.aDw == null || this.aDw.getParent() == null || this.guL.isLoading()) {
            return false;
        }
        int bottom = this.aDw.getBottom();
        Rect rect = new Rect();
        this.aDw.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Gc(String str) {
        if (this.guL != null) {
            this.guL.setText(str);
        }
    }

    public void Gd(String str) {
        if (this.guL != null) {
            int i = 0;
            if (this.iOP != null && this.iOP.iPT != null && this.iOP.iPT.getView() != null) {
                i = this.iOP.iPT.getView().getTop() < 0 ? this.iOP.iPT.getView().getHeight() : this.iOP.iPT.getView().getBottom();
            }
            this.guL.ab(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.iNM;
    }

    public int cpU() {
        return R.id.richText;
    }

    public TextView clJ() {
        return this.iNR.clJ();
    }

    public void d(BdListView.e eVar) {
        this.iNM.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.dgH = cVar;
        if (this.iOb != null) {
            this.iOb.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ap apVar, a.b bVar) {
        if (apVar != null) {
            int aBg = apVar.aBg();
            int aBd = apVar.aBd();
            if (this.iNY != null) {
                this.iNY.aEA();
            } else {
                this.iNY = new com.baidu.tbadk.core.dialog.a(this.iDW.getPageContext().getPageActivity());
                this.iNZ = LayoutInflater.from(this.iDW.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.iNY.aO(this.iNZ);
                this.iNY.a(R.string.dialog_ok, bVar);
                this.iNY.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.19
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        an.this.cpW();
                        aVar.dismiss();
                    }
                });
                this.iNY.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.an.20
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (an.this.iOZ == null) {
                            an.this.iOZ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.20.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    an.this.iDW.HidenSoftKeyPad((InputMethodManager) an.this.iDW.getBaseFragmentActivity().getSystemService("input_method"), an.this.aCP);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.gx().postDelayed(an.this.iOZ, 150L);
                    }
                });
                this.iNY.b(this.iDW.getPageContext()).aEA();
            }
            this.iOa = (EditText) this.iNZ.findViewById(R.id.input_page_number);
            this.iOa.setText("");
            TextView textView = (TextView) this.iNZ.findViewById(R.id.current_page_number);
            if (aBg <= 0) {
                aBg = 1;
            }
            if (aBd <= 0) {
                aBd = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(aBg), Integer.valueOf(aBd)));
            this.iDW.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.iOa, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.iNM.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.iDW.showToast(str);
    }

    public boolean qo(boolean z) {
        if (this.FO == null || !this.FO.aOt()) {
            return false;
        }
        this.FO.aMO();
        return true;
    }

    public void cpV() {
        if (this.iPD != null) {
            while (this.iPD.size() > 0) {
                TbImageView remove = this.iPD.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        cpV();
        this.iNX.yH(1);
        if (this.iNO != null) {
            this.iNO.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.iNX.yH(2);
        if (this.iNO != null) {
            this.iNO.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.iDW.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.iDW.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.iOz != null) {
            this.iOz.onDestroy();
        }
        if (this.iPb != null) {
            this.iPb.destroy();
        }
        if (this.iPq != null) {
            this.iPq.onDestory();
        }
        if (this.iPi != null) {
            this.iPi.hide();
        }
        this.iDW.hideProgressBar();
        if (this.fUO != null && this.glJ != null) {
            this.fUO.b(this.glJ);
        }
        cpW();
        endLoadData();
        if (this.iOZ != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iOZ);
        }
        if (this.iOH != null) {
            this.iOH.clearStatus();
        }
        this.iPx = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.iNX.yH(3);
        if (this.aCa != null) {
            this.aCa.setBackgroundDrawable(null);
        }
        if (this.iNO != null) {
            this.iNO.destroy();
        }
        if (this.iNX != null) {
            this.iNX.onDestroy();
        }
        this.iNM.setOnLayoutListener(null);
        if (this.iPm != null) {
            this.iPm.bGt();
        }
        if (this.iOQ != null) {
            this.iOQ.onDestroy();
        }
        if (this.iNR != null) {
            this.iNR.onDestroy();
        }
    }

    public boolean zg(int i) {
        if (this.iNO != null) {
            return this.iNO.zg(i);
        }
        return false;
    }

    public void cpW() {
        this.iNI.arS();
        if (this.iNR != null) {
            this.iNR.cpW();
        }
        if (this.iDW != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.iDW.getContext(), this.iOa);
        }
        cpe();
        if (this.iHG != null) {
            this.iHG.dismiss();
        }
        cpY();
        if (this.iNY != null) {
            this.iNY.dismiss();
        }
        if (this.gqn != null) {
            this.gqn.dismiss();
        }
    }

    public void cpX() {
        this.iNI.arS();
        if (this.iNR != null) {
            this.iNR.cpW();
        }
        if (this.iHG != null) {
            this.iHG.dismiss();
        }
        cpY();
        if (this.iNY != null) {
            this.iNY.dismiss();
        }
        if (this.gqn != null) {
            this.gqn.dismiss();
        }
    }

    public void dH(List<String> list) {
        this.iPl = list;
        if (this.iPm != null) {
            this.iPm.setData(list);
        }
    }

    public void pw(boolean z) {
        this.iNX.pw(z);
    }

    public void qp(boolean z) {
        this.iOr = z;
    }

    public void cpY() {
        if (this.iOf != null) {
            this.iOf.dismiss();
        }
        if (this.iOg != null) {
            com.baidu.adp.lib.f.g.b(this.iOg, this.iDW.getPageContext());
        }
        if (this.iOh != null) {
            com.baidu.adp.lib.f.g.b(this.iOh, this.iDW.getPageContext());
        }
        if (this.iOe != null) {
            this.iOe.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.iEZ, this.iEI);
            b(this.iEZ, this.iEI, this.mType, i);
            this.iDW.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.iDW.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.aCP);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.aCP, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.iOs, R.drawable.personalize_tab_shadow);
            if (this.iNO != null) {
                this.iNO.onChangeSkinType(i);
            }
            if (this.iNS != null) {
                this.iNS.onChangeSkinType(i);
            }
            if (this.iNP != null) {
                this.iNP.onChangeSkinType(i);
            }
            if (this.iNQ != null) {
                this.iNQ.onChangeSkinType(i);
            }
            if (this.iNR != null) {
                this.iNR.onChangeSkinType(i);
            }
            if (this.guL != null) {
                this.guL.changeSkin(i);
                if (this.dCM != null) {
                    this.iDW.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.dCM);
                    com.baidu.tbadk.core.util.am.setBackgroundResource(this.dCM, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.iNY != null) {
                this.iNY.c(this.iDW.getPageContext());
            }
            qn(this.iOo);
            this.iNX.notifyDataSetChanged();
            if (this.iOb != null) {
                this.iOb.changeSkin(i);
            }
            if (this.FO != null) {
                this.FO.onChangeSkinType(i);
            }
            if (this.iOc != null) {
                this.iOc.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.fLS)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.fLS) {
                    customBlueCheckRadioButton.aHs();
                }
            }
            cpv();
            UtilHelper.setStatusBarBackground(this.aCa, i);
            UtilHelper.setStatusBarBackground(this.iOK, i);
            if (this.iNT != null) {
                com.baidu.tbadk.q.a.a(this.iDW.getPageContext(), this.iNT);
            }
            if (this.iPa != null) {
                this.iPa.onChangeSkinType(i);
            }
            if (this.iNI != null) {
                if (this.iNO != null) {
                    this.iNO.zh(i);
                } else {
                    this.iNI.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.hgK != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hgK, (int) R.color.cp_cont_d);
                this.hgK.setBackgroundDrawable(com.baidu.tbadk.core.util.am.ay(com.baidu.adp.lib.util.l.getDimens(this.iDW.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_j)));
            }
            if (this.iOx != null && this.iEZ != null) {
                if (this.iEZ.ayJ()) {
                    SvgManager.aGA().a(this.iOx, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.aGA().a(this.iOx, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            t(this.iEZ);
            if (this.iOw != null) {
                SvgManager.aGA().a(this.iOw, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.iOu != null) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iOu, R.drawable.bottom_shadow);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iOA, (int) R.color.cp_cont_b);
            if (this.iPn != null) {
                this.iPn.onChangeSkinType(i);
            }
            if (this.iOQ != null) {
                this.iOQ.onChangeSkinType();
            }
            if (this.iPk != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iPk, (int) R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iOv, R.color.cp_bg_line_h);
            if (this.iNN != null) {
                this.iNN.pk(i);
            }
        }
    }

    public void cpZ() {
        if (this.iOz != null) {
            this.iOz.setEnable(false);
        }
    }

    public void t(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.aY(eVar.cks())) {
            if (this.iOz != null) {
                this.iOz.setEnable(false);
                this.iOz.onDestroy();
            }
            SvgManager.aGA().a(this.iOy, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.iOz == null || !this.iOz.isEnable()) {
            SvgManager.aGA().a(this.iOy, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMw = iVar;
        this.iNX.setOnImageClickListener(this.dMw);
        this.iPn.setOnImageClickListener(this.dMw);
    }

    public void g(NoNetworkView.a aVar) {
        this.glJ = aVar;
        if (this.fUO != null) {
            this.fUO.a(this.glJ);
        }
    }

    public void qq(boolean z) {
        this.iNX.setIsFromCDN(z);
    }

    public Button cqa() {
        return this.iOt;
    }

    public void cqb() {
        if (this.iNH != 2) {
            this.iNM.setNextPage(this.guL);
            this.iNH = 2;
        }
    }

    public void cqc() {
        if (com.baidu.tbadk.n.m.aRj().aRk()) {
            int lastVisiblePosition = this.iNM.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.iNM.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.dDu = true;
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
                        perfLog2.dDu = true;
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

    public boolean cqd() {
        return this.FO != null && this.FO.getVisibility() == 0;
    }

    public boolean cqe() {
        return this.FO != null && this.FO.aOt();
    }

    public void cqf() {
        if (this.FO != null) {
            this.FO.aMO();
        }
    }

    public void qr(boolean z) {
        if (this.iOv != null) {
            qp(this.iDW.cmm().aOX());
            if (this.iOr) {
                qg(z);
            } else {
                qh(z);
            }
        }
    }

    public void cqg() {
        if (this.iOv != null) {
            this.iOu.setVisibility(8);
            this.iOv.setVisibility(8);
            this.iOB = false;
            if (this.iOQ != null) {
                this.iOQ.setVisibility(8);
                ql(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.fPT == null) {
            this.fPT = new com.baidu.tbadk.core.view.a(this.iDW.getPageContext());
        }
        this.fPT.setDialogVisiable(true);
    }

    public void bqp() {
        if (this.fPT != null) {
            this.fPT.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.iNM.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.iNM.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.iNO != null) {
            this.iNO.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.iPE = getScrollY();
            this.iOP.iPT = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iOP));
            a(this.iOP.iPT, true);
        }
    }

    public void qs(boolean z) {
        if (this.iNO != null) {
            this.iNO.qs(z);
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
        if (this.iNO != null) {
            this.iNO.onScroll(absListView, i, i2, i3);
        }
        if (this.iNI != null && this.iNX != null) {
            this.iNI.cC(this.iNX.cmd());
        }
        this.iOP.iwS = i;
        this.iOP.headerCount = this.iNM.getHeaderViewsCount();
        this.iOP.iPT = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iOP));
        qi(b(absListView, i));
        a(this.iOP.iPT, false);
        if (this.guL.aHG() && !this.guL.dgz) {
            if (this.iOP != null && this.iOP.iPT != null && this.iOP.iPT.getView() != null) {
                i4 = this.iOP.iPT.getView().getTop() < 0 ? this.iOP.iPT.getView().getHeight() : this.iOP.iPT.getView().getBottom();
            }
            this.guL.lk(i4);
            this.guL.dgz = true;
        }
    }

    public void cqh() {
        if (TbadkCoreApplication.isLogin() && this.iEZ != null && this.iPf && !this.iPe && !this.iOp && this.iOE != null && this.iOE.aCm() != null && !this.iOE.aCm().getIsLike() && !this.iOE.aCm().hadConcerned() && this.iPb == null) {
            this.iPb = new ak(this.iDW);
        }
    }

    public void cqi() {
        if (this.iPf && !this.iPe && this.iOE != null && this.iOE.aCm() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").X("obj_locate", this.iDW.clp() ? 2 : 1).X("obj_type", this.iPe ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.iDW.getPageContext().getPageActivity(), this.iOE.aCm().getUserId(), this.iOE.aCm().getUserName(), this.iDW.clz().clq(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(aj ajVar, boolean z) {
        int measuredHeight;
        if (!this.iPe && this.iOJ != null && this.iNI.cqX() != null) {
            int clZ = this.iNX.clZ();
            if (clZ > 0 && (ajVar == null || ajVar.getView().getParent() == null)) {
                if (clZ > this.iNM.getFirstVisiblePosition() - this.iNM.getHeaderViewsCount()) {
                    this.iOJ.setVisibility(8);
                    return;
                }
                this.iOJ.setVisibility(0);
                qi(false);
                this.iNI.mNavigationBar.hideBottomLine();
                if (this.iOJ.getParent() != null && ((ViewGroup) this.iOJ.getParent()).getHeight() <= this.iOJ.getTop()) {
                    this.iOJ.getParent().requestLayout();
                }
            } else if (ajVar == null || ajVar.getView() == null || ajVar.iNj == null) {
                if (this.iNM.getFirstVisiblePosition() == 0) {
                    this.iOJ.setVisibility(8);
                    this.iNI.mNavigationBar.hideBottomLine();
                }
            } else {
                int top2 = ajVar.getView().getTop();
                if (ajVar.getView().getParent() != null) {
                    if (this.iOO) {
                        this.iON = top2;
                        this.iOO = false;
                    }
                    this.iON = top2 < this.iON ? top2 : this.iON;
                }
                if (top2 != 0 || ajVar.getView().isShown()) {
                    if (this.iNW.getY() < 0.0f) {
                        measuredHeight = iOM - ajVar.iNj.getMeasuredHeight();
                    } else {
                        measuredHeight = this.iNI.cqX().getMeasuredHeight() - ajVar.iNj.getMeasuredHeight();
                        this.iNI.mNavigationBar.hideBottomLine();
                    }
                    if (ajVar.getView().getParent() == null && top2 <= this.iON) {
                        this.iOJ.setVisibility(0);
                        qi(false);
                    } else if (top2 < measuredHeight) {
                        this.iOJ.setVisibility(0);
                        qi(false);
                    } else {
                        this.iOJ.setVisibility(8);
                        this.iNI.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.iOO = true;
                    }
                }
            }
        }
    }

    public void cqj() {
        if (!this.iPF) {
            TiebaStatic.log("c10490");
            this.iPF = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iDW.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(iOT, Integer.valueOf(iOV));
            aVar.jV(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.iDW.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aO(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.iDW);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.21
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iDW.getPageContext()).aEA();
        }
    }

    public void Ge(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iDW.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.iDW.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aO(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(iOT, Integer.valueOf(iOW));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.iDW);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iDW.getPageContext()).aEA();
    }

    public void a(int i, com.baidu.tieba.pb.data.e eVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(eVar, z)) != null && b.aCm() != null) {
            MetaData aCm = b.aCm();
            aCm.setGiftNum(aCm.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, int i, int i2) {
        a(eVar, z, i, i2);
        r(eVar);
    }

    public PbInterviewStatusView cqk() {
        return this.iOH;
    }

    private void u(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cks() != null && eVar.cks().aDq() && this.iOH == null) {
            this.iOH = (PbInterviewStatusView) this.iOG.inflate();
            this.iOH.setOnClickListener(this.gqo);
            this.iOH.setCallback(this.iDW.cmY());
            this.iOH.setData(this.iDW, eVar);
        }
    }

    public RelativeLayout cql() {
        return this.iNW;
    }

    public View cqm() {
        return this.aCa;
    }

    public boolean cqn() {
        return this.iPu;
    }

    public void pB(boolean z) {
        this.iNR.pB(z);
    }

    public void Gf(String str) {
        if (this.iNJ != null) {
            this.iNJ.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int qt(boolean z) {
        if (this.iOH == null || this.iOH.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void cqo() {
        if (this.iOH != null && this.iOH.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iOH.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.iOH.setLayoutParams(layoutParams);
        }
    }

    public boolean cms() {
        return false;
    }

    public void Gg(String str) {
        this.hgK.performClick();
        if (!StringUtils.isNull(str) && this.iDW.cmm() != null && this.iDW.cmm().aOQ() != null && this.iDW.cmm().aOQ().getInputView() != null) {
            EditText inputView = this.iDW.cmm().aOQ().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            cpW();
            if (configuration.orientation == 2) {
                cqg();
                cpe();
            } else {
                cpi();
            }
            if (this.iPa != null) {
                this.iPa.cmh();
            }
            this.iDW.bEj();
            this.iNW.setVisibility(8);
            this.iNI.qE(false);
            this.iDW.pP(false);
            if (this.iNO != null) {
                if (configuration.orientation == 1) {
                    cql().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.iNM.setIsLandscape(true);
                    this.iNM.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.iNM.setIsLandscape(false);
                    if (this.iPE > 0) {
                        this.iNM.smoothScrollBy(this.iPE, 0);
                    }
                }
                this.iNO.onConfigurationChanged(configuration);
                this.iOI.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void qu(boolean z) {
        if (this.iNO != null) {
            this.iNO.qu(z);
        }
    }

    public boolean cqp() {
        return this.iNO != null && this.iNO.cqp();
    }

    public void cqq() {
        if (this.iNO != null) {
            this.iNO.cqq();
        }
    }

    public void pF(boolean z) {
        this.iNX.pF(z);
    }

    public void cB(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.iOv.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.iDW.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.iPk = new TextView(this.iDW.getContext());
            this.iPk.setText(R.string.connection_tips);
            this.iPk.setGravity(17);
            this.iPk.setPadding(com.baidu.adp.lib.util.l.getDimens(this.iDW.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.iDW.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.iDW.getContext(), R.dimen.ds60);
            if (this.iPk.getParent() == null) {
                frameLayout.addView(this.iPk, layoutParams);
            }
            this.iPj = new PopupWindow(this.iDW.getContext());
            this.iPj.setContentView(frameLayout);
            this.iPj.setHeight(-2);
            this.iPj.setWidth(-2);
            this.iPj.setFocusable(true);
            this.iPj.setOutsideTouchable(false);
            this.iPj.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.iNM.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.24
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        an.this.iPj.showAsDropDown(an.this.iOv, view.getLeft(), -an.this.iOv.getHeight());
                    } else {
                        an.this.iPj.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void qv(boolean z) {
        this.iPp = z;
    }

    public boolean cqr() {
        return this.iPp;
    }

    public PbThreadPostView cqs() {
        return this.iNN;
    }

    private void ae(boolean z, boolean z2) {
        af(z, z2);
        if (this.iEZ != null && this.iEZ.cks() != null && this.iEZ.cks().aCB() == 0 && !this.iEZ.cks().aAZ()) {
            ag(z, z2);
        } else if (this.iNX != null && this.iNX.cme() != null) {
            this.iNX.cme().b(this.iEZ, z, z2);
        }
    }

    private void af(boolean z, boolean z2) {
        this.iNR.d(this.iEZ, z, z2);
    }

    private void ag(boolean z, boolean z2) {
        this.iNQ.c(this.iEZ, z, z2);
    }
}
