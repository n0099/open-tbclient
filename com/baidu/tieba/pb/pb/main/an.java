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
    private static final int iOO = UtilHelper.getLightStatusBarHeight();
    public static int iOU = 3;
    public static int iOV = 0;
    public static int iOW = 3;
    public static int iOX = 4;
    public static int iOY = 5;
    public static int iOZ = 6;
    private static a.InterfaceC0610a iPv = new a.InterfaceC0610a() { // from class: com.baidu.tieba.pb.pb.main.an.12
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0610a
        public void onRefresh() {
        }
    };
    private EditorTools FO;
    private RelativeLayout aCQ;
    private View aCb;
    private View aDx;
    private View dCN;
    private g.c dgI;
    private com.baidu.tieba.pb.a.c dqK;
    private List<CustomBlueCheckRadioButton> fLU;
    private NoNetworkView fUQ;
    private NavigationBarCoverTip gNp;
    private com.baidu.tieba.NEGFeedBack.e gQj;
    private View.OnClickListener gqq;
    private PbListView guN;
    private TextView hgM;
    private PbFragment iDY;
    private View.OnClickListener iES;
    private com.baidu.tieba.pb.data.e iFb;
    private PbFakeFloorModel iGY;
    PbFragment.c iIF;
    public int iNI;
    public final com.baidu.tieba.pb.pb.main.view.c iNK;
    public com.baidu.tieba.pb.pb.main.view.b iNL;
    private ViewStub iNM;
    private ViewStub iNN;
    private PbLandscapeListView iNO;
    private PbThreadPostView iNP;
    private com.baidu.tieba.pb.pb.main.a.e iNQ;
    private com.baidu.tieba.pb.pb.main.a.a iNR;
    private com.baidu.tieba.pb.pb.main.a.c iNS;
    private com.baidu.tieba.pb.pb.main.a.d iNT;
    private com.baidu.tieba.pb.pb.main.a.b iNU;
    private LinearLayout iNV;
    private TextView iNW;
    private TextView iNX;
    private ObservedChangeRelativeLayout iNY;
    private f iNZ;
    private ImageView iOA;
    private com.baidu.tieba.pb.view.c iOB;
    private TextView iOC;
    private int iOE;
    private int iOF;
    private PostData iOG;
    private ViewStub iOI;
    private PbInterviewStatusView iOJ;
    private FrameLayout iOK;
    private View iOL;
    private View iOM;
    private aj iON;
    private PbEmotionBar iOS;
    private View iOf;
    private View iOu;
    private View iOw;
    private View iOx;
    private ImageView iOy;
    private ImageView iOz;
    private Runnable iPA;
    private PbFragment.b iPC;
    public int iPG;
    private int iPa;
    private Runnable iPb;
    private s iPc;
    private ak iPd;
    private int iPj;
    private PbTopTipView iPk;
    private PopupWindow iPl;
    private TextView iPm;
    private List<String> iPn;
    private com.baidu.tieba.pb.pb.main.emotion.c iPo;
    private com.baidu.tieba.pb.pb.godreply.a iPp;
    private PbLandscapeListView.b iPq;
    private aa iPs;
    private String iPt;
    private long iPu;
    private boolean iPw;
    private boolean isLandscape;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private int iNJ = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a iOa = null;
    private com.baidu.tbadk.core.dialog.b gqp = null;
    private View iOb = null;
    private EditText iOc = null;
    private com.baidu.tieba.pb.view.d iOd = null;
    private com.baidu.tieba.pb.view.a iOe = null;
    private b.a hDu = null;
    private TbRichTextView.i dMx = null;
    private NoNetworkView.a glL = null;
    private com.baidu.tbadk.core.dialog.i iOg = null;
    private com.baidu.tbadk.core.dialog.a iOh = null;
    private Dialog iOi = null;
    private Dialog iOj = null;
    private View iOk = null;
    private LinearLayout iOl = null;
    private CompoundButton.OnCheckedChangeListener fLV = null;
    private TextView iOm = null;
    private TextView iOn = null;
    private String iOo = null;
    private com.baidu.tbadk.core.dialog.i iHI = null;
    private com.baidu.tbadk.core.dialog.i iOp = null;
    private boolean iOq = false;
    private boolean iOr = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView iOs = null;
    private boolean iOt = false;
    private Button iOv = null;
    private boolean iOD = true;
    private com.baidu.tbadk.core.view.a fPV = null;
    private boolean iEK = false;
    private int mSkinType = 3;
    private boolean iOH = false;
    private int iOP = 0;
    private boolean iOQ = true;
    public a iOR = new a();
    private int iOT = 0;
    private boolean iPe = false;
    private int iPf = 0;
    private boolean iPg = false;
    private boolean iPh = false;
    private boolean iPi = false;
    private boolean iPr = false;
    private String iPx = null;
    private CustomMessageListener iPy = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.an.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                an.this.iPx = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.an.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && an.this.iNZ != null) {
                an.this.iNZ.notifyDataSetChanged();
            }
        }
    };
    private Handler iPz = new Handler();
    private CustomMessageListener iPB = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.an.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                an.this.iOD = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean iPD = true;
    View.OnClickListener iPE = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || an.this.iFb == null || an.this.iFb.cku() == null || an.this.iFb.cku().aCo() == null || an.this.iFb.cku().aCo().getAlaUserData() == null || an.this.iFb.cku().aCo().getAlaUserData().live_status != 1 || an.this.iFb.cku().aCo().getAlaUserData().live_id <= 0) {
                if (an.this.iPg) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11923").X("obj_id", 2));
                }
                if (!an.this.iPg && an.this.iFb != null && an.this.iFb.cku() != null && an.this.iFb.cku().aCo() != null && an.this.iFb.cku().aCo().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12151").X("obj_locate", 1));
                }
                if (an.this.iDY.cni() != null) {
                    an.this.iDY.cni().iEk.gQW.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c11851");
            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(anVar);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = an.this.iFb.cku().aCo().getAlaUserData().live_id;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(an.this.iDY.cni(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
        }
    };
    private boolean aqb = false;
    String userId = null;
    private final List<TbImageView> iPF = new ArrayList();
    private boolean iPH = false;

    /* loaded from: classes9.dex */
    public static class a {
        public int headerCount;
        public aj iPV;
        public int iwU;
    }

    public void qf(boolean z) {
        this.iPe = z;
        if (this.iNO != null) {
            this.iPf = this.iNO.getHeaderViewsCount();
        }
    }

    public void cpe() {
        if (this.iNO != null) {
            int headerViewsCount = this.iNO.getHeaderViewsCount() - this.iPf;
            final int firstVisiblePosition = (this.iNO.getFirstVisiblePosition() == 0 || this.iNO.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.iNO.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.iNO.getChildAt(0);
            final int top2 = childAt != null ? childAt.getTop() : -1;
            this.iOR.iPV = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iOR));
            final aj ajVar = this.iOR.iPV;
            final int f = f(ajVar);
            final int y = ((int) this.iNY.getY()) + this.iNY.getMeasuredHeight();
            final boolean z = this.iOL.getVisibility() == 0;
            boolean z2 = this.iNY.getY() < 0.0f;
            if ((z && ajVar != null) || firstVisiblePosition >= this.iNZ.cmb() + this.iNO.getHeaderViewsCount()) {
                int measuredHeight = ajVar != null ? ajVar.iNl.getMeasuredHeight() : 0;
                if (z2) {
                    this.iNO.setSelectionFromTop(this.iNZ.cmb() + this.iNO.getHeaderViewsCount(), iOO - measuredHeight);
                } else {
                    this.iNO.setSelectionFromTop(this.iNZ.cmb() + this.iNO.getHeaderViewsCount(), this.iNK.cqZ().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.iNO.setSelectionFromTop(firstVisiblePosition, top2);
            }
            if (this.iPg && this.iNQ != null) {
                this.iNO.setSelectionFromTop(this.iNZ.cmb() + this.iNO.getHeaderViewsCount(), this.iNQ.cqL());
            } else if (this.mType == 6) {
                this.iNO.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.an.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void cns() {
                        ViewGroup.LayoutParams layoutParams;
                        if (f >= 0 && f <= an.this.aCQ.getMeasuredHeight()) {
                            int f2 = an.this.f(ajVar);
                            int i = f2 - f;
                            if (z && i != 0 && f <= y) {
                                i = f2 - y;
                            }
                            if (an.this.aDx != null && (layoutParams = an.this.aDx.getLayoutParams()) != null) {
                                if (i == 0 || i > an.this.aCQ.getMeasuredHeight() || f2 >= an.this.aCQ.getMeasuredHeight()) {
                                    layoutParams.height = an.this.iPa;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > an.this.aCQ.getMeasuredHeight()) {
                                    layoutParams.height = an.this.iPa;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    an.this.iNO.setSelectionFromTop(firstVisiblePosition, top2);
                                }
                                an.this.aDx.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (an.this.aDx != null && an.this.aDx.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = an.this.aDx.getLayoutParams();
                                            layoutParams2.height = an.this.iPa;
                                            an.this.aDx.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        an.this.iNO.setOnLayoutListener(null);
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

    public NoNetworkView cpf() {
        return this.fUQ;
    }

    public void cpg() {
        if (this.FO != null) {
            this.FO.hide();
            if (this.iPo != null) {
                this.iPo.cqN();
            }
        }
    }

    public PbFakeFloorModel cph() {
        return this.iGY;
    }

    public s cpi() {
        return this.iPc;
    }

    public com.baidu.tieba.pb.pb.main.a.e cpj() {
        return this.iNQ;
    }

    public void cpk() {
        reset();
        cpg();
        this.iPc.cmj();
        qr(false);
    }

    private void reset() {
        if (this.iDY != null && this.iDY.cmo() != null && this.FO != null) {
            com.baidu.tbadk.editortools.pb.a.aOP().setStatus(0);
            com.baidu.tbadk.editortools.pb.e cmo = this.iDY.cmo();
            cmo.aPj();
            cmo.aOD();
            if (cmo.getWriteImagesInfo() != null) {
                cmo.getWriteImagesInfo().setMaxImagesAllowed(cmo.isBJH ? 1 : 9);
            }
            cmo.mv(SendView.ALL);
            cmo.mw(SendView.ALL);
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

    public boolean cpl() {
        return this.iOD;
    }

    public void qg(boolean z) {
        if (this.iOx != null && this.hgM != null) {
            this.hgM.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iOx.startAnimation(alphaAnimation);
            }
            this.iOw.setVisibility(0);
            this.iOx.setVisibility(0);
            this.iOD = true;
            if (this.iOS != null && !this.iPp.isActive()) {
                this.iOS.setVisibility(0);
                ql(true);
            }
        }
    }

    public void qh(boolean z) {
        if (this.iOx != null && this.hgM != null) {
            this.hgM.setText(cpm());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.iOx.startAnimation(alphaAnimation);
            }
            this.iOw.setVisibility(0);
            this.iOx.setVisibility(0);
            this.iOD = true;
            if (this.iOS != null && !this.iPp.isActive()) {
                this.iOS.setVisibility(0);
                ql(true);
            }
        }
    }

    public String cpm() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.iPt)) {
            return this.iPt;
        }
        if (this.iDY != null) {
            this.iPt = TbadkCoreApplication.getInst().getResources().getString(am.cpb());
        }
        return this.iPt;
    }

    public PostData cpn() {
        int i = 0;
        if (this.iNO == null) {
            return null;
        }
        int cpo = cpo() - this.iNO.getHeaderViewsCount();
        if (cpo < 0) {
            cpo = 0;
        }
        if (this.iNZ.yG(cpo) != null && this.iNZ.yG(cpo) != PostData.kgs) {
            i = cpo + 1;
        }
        return this.iNZ.getItem(i) instanceof PostData ? (PostData) this.iNZ.getItem(i) : null;
    }

    public int cpo() {
        int i;
        View childAt;
        if (this.iNO == null) {
            return 0;
        }
        int firstVisiblePosition = this.iNO.getFirstVisiblePosition();
        int lastVisiblePosition = this.iNO.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.iNO.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.iNO.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int cpp() {
        return this.iNO.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.iFb != null && this.iFb.ckw() != null && !this.iFb.ckw().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.iFb.ckw().size() && (postData = this.iFb.ckw().get(i)) != null && postData.aCo() != null && !StringUtils.isNull(postData.aCo().getUserId()); i++) {
                if (this.iFb.ckw().get(i).aCo().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.iPp != null && this.iPp.isActive()) {
                        qr(false);
                    }
                    if (this.iOS != null) {
                        this.iOS.qA(true);
                    }
                    this.iPx = postData.aCo().getName_show();
                    return;
                }
            }
        }
    }

    public an(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.iDY = null;
        this.aCQ = null;
        this.aCb = null;
        this.iNO = null;
        this.iNZ = null;
        this.guN = null;
        this.dCN = null;
        this.gqq = null;
        this.iES = null;
        this.iOx = null;
        this.hgM = null;
        this.iOI = null;
        this.iPj = 0;
        this.iPu = 0L;
        this.iPu = System.currentTimeMillis();
        this.iDY = pbFragment;
        this.gqq = onClickListener;
        this.dqK = cVar;
        this.iPj = com.baidu.adp.lib.util.l.getEquipmentWidth(this.iDY.getContext()) / 2;
        this.aCQ = (RelativeLayout) LayoutInflater.from(this.iDY.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.aCQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.iOu = this.aCQ.findViewById(R.id.bottom_shadow);
        this.gNp = (NavigationBarCoverTip) this.aCQ.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.aCb = this.aCQ.findViewById(R.id.statebar_view);
        this.iNY = (ObservedChangeRelativeLayout) this.aCQ.findViewById(R.id.title_wrapper);
        this.fUQ = (NoNetworkView) this.aCQ.findViewById(R.id.view_no_network);
        this.iNO = (PbLandscapeListView) this.aCQ.findViewById(R.id.new_pb_list);
        this.iOK = (FrameLayout) this.aCQ.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.iDY.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.iDY.getActivity(), R.dimen.ds88));
        this.iNO.addHeaderView(this.textView, 0);
        this.iNO.setTextViewAdded(true);
        this.iPa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.aDx = new View(this.iDY.getPageContext().getPageActivity());
        this.aDx.setLayoutParams(new AbsListView.LayoutParams(-1, this.iPa));
        this.aDx.setVisibility(4);
        this.iNO.addFooterView(this.aDx);
        this.iNO.setOnTouchListener(this.iDY.drA);
        this.iNK = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.aCQ);
        if (this.iDY.cmS()) {
            this.iNM = (ViewStub) this.aCQ.findViewById(R.id.manga_view_stub);
            this.iNM.setVisibility(0);
            this.iNL = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.iNL.show();
            this.iNK.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.iDY.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.iNK.cqZ().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0568a() { // from class: com.baidu.tieba.pb.pb.main.an.25
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0568a
            public void cll() {
                if (an.this.iNO != null) {
                    if (an.this.iNQ != null) {
                        an.this.iNQ.cqK();
                    }
                    an.this.iNO.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0568a
            public void clm() {
                an.this.iDY.bEl();
            }
        }));
        this.iOw = this.aCQ.findViewById(R.id.view_comment_top_line);
        this.iOx = this.aCQ.findViewById(R.id.pb_editor_tool_comment);
        this.iOE = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iOF = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.hgM = (TextView) this.aCQ.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.hgM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                an.this.iDY.cmz();
                if (an.this.iDY != null && an.this.iDY.clB() != null && an.this.iDY.clB().getPbData() != null && an.this.iDY.clB().getPbData().cku() != null && an.this.iDY.clB().getPbData().cku().aCo() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13402").cy("tid", an.this.iDY.clB().iJW).cy("fid", an.this.iDY.clB().getPbData().getForumId()).X("obj_locate", 1).cy("uid", an.this.iDY.clB().getPbData().cku().aCo().getUserId()));
                }
            }
        });
        this.iOy = (ImageView) this.aCQ.findViewById(R.id.pb_editor_tool_comment_icon);
        this.iOy.setOnClickListener(this.gqq);
        boolean booleanExtra = this.iDY.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.iOz = (ImageView) this.aCQ.findViewById(R.id.pb_editor_tool_collection);
        this.iOz.setOnClickListener(this.gqq);
        if (booleanExtra) {
            this.iOz.setVisibility(8);
        } else {
            this.iOz.setVisibility(0);
        }
        this.iOA = (ImageView) this.aCQ.findViewById(R.id.pb_editor_tool_share);
        this.iOA.setOnClickListener(this.gqq);
        this.iOB = new com.baidu.tieba.pb.view.c(this.iOA);
        this.iOB.cuj();
        this.iOC = (TextView) this.aCQ.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.iOI = (ViewStub) this.aCQ.findViewById(R.id.interview_status_stub);
        this.iNR = new com.baidu.tieba.pb.pb.main.a.a(this.iDY, cVar);
        this.iNT = new com.baidu.tieba.pb.pb.main.a.d(this.iDY, cVar, this.gqq);
        this.iNZ = new f(this.iDY, this.iNO);
        this.iNZ.D(this.gqq);
        this.iNZ.setTbGestureDetector(this.dqK);
        this.iNZ.setOnImageClickListener(this.dMx);
        this.iES = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.27
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
                            an.this.iDY.b(sparseArray);
                            return;
                        }
                        an.this.cA(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        an.this.iDY.b(sparseArray);
                    } else if (booleanValue3) {
                        an.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.iNZ.P(this.iES);
        cpu();
        cpv();
        this.iNT.b(this.iNO);
        this.iNS.b(this.iNO);
        this.iNR.b(this.iNO);
        this.guN = new PbListView(this.iDY.getPageContext().getPageActivity());
        this.dCN = this.guN.getView().findViewById(R.id.pb_more_view);
        if (this.dCN != null) {
            this.dCN.setOnClickListener(this.gqq);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.dCN, R.drawable.pb_foot_more_trans_selector);
        }
        this.guN.setLineVisible();
        this.guN.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.guN.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.iOf = this.aCQ.findViewById(R.id.viewstub_progress);
        this.iDY.registerListener(this.iPB);
        this.iGY = new PbFakeFloorModel(this.iDY.getPageContext());
        this.iPc = new s(this.iDY.getPageContext(), this.iGY, this.aCQ);
        this.iPc.a(this.iDY.iIA);
        this.iGY.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.an.28
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                an.this.iGY.q(postData);
                an.this.iNZ.notifyDataSetChanged();
                an.this.iPc.cmj();
                an.this.FO.aMQ();
                an.this.qr(false);
            }
        });
        if (this.iDY.clB() != null && !StringUtils.isNull(this.iDY.clB().cog())) {
            this.iDY.showToast(this.iDY.clB().cog());
        }
        this.iOL = this.aCQ.findViewById(R.id.pb_expand_blank_view);
        this.iOM = this.aCQ.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iOM.getLayoutParams();
        if (this.iDY.clB() != null && this.iDY.clB().cnB()) {
            this.iOL.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.iOM.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = iOO;
            this.iOM.setLayoutParams(layoutParams2);
        }
        this.iON = new aj(this.iDY.getPageContext(), this.aCQ.findViewById(R.id.pb_reply_expand_view));
        this.iON.iNl.setVisibility(8);
        this.iON.Q(this.gqq);
        this.iDY.registerListener(this.mAccountChangedListener);
        this.iDY.registerListener(this.iPy);
        cpq();
        ql(false);
    }

    public void qi(boolean z) {
        this.iOu.setVisibility(z ? 0 : 8);
    }

    public void bPx() {
        if (!this.iDY.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10517").X("obj_locate", 2).cy("fid", this.mForumId));
        } else if (this.iDY.cmB()) {
            com.baidu.tbadk.editortools.pb.e cmo = this.iDY.cmo();
            if (cmo != null && (cmo.aPg() || cmo.aPh())) {
                this.iDY.cmo().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.FO != null) {
                cpA();
            }
            if (this.FO != null) {
                this.iOD = false;
                if (this.FO.mp(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.iDY.getPageContext(), (View) this.FO.mp(2).dwA, false, iPv);
                }
            }
            cqi();
        }
    }

    private void cpq() {
        this.iPp = new com.baidu.tieba.pb.pb.godreply.a(this.iDY, this, (ViewStub) this.aCQ.findViewById(R.id.more_god_reply_popup));
        this.iPp.y(this.gqq);
        this.iPp.P(this.iES);
        this.iPp.setOnImageClickListener(this.dMx);
        this.iPp.y(this.gqq);
        this.iPp.setTbGestureDetector(this.dqK);
    }

    public com.baidu.tieba.pb.pb.godreply.a cpr() {
        return this.iPp;
    }

    public View cps() {
        return this.iOL;
    }

    public void cpt() {
        if (this.iNO != null) {
            this.iNS.c(this.iNO);
            this.iNT.c(this.iNO);
            this.iNU.c(this.iNO);
            this.iNR.c(this.iNO);
        }
    }

    private void cpu() {
        if (this.iNU == null) {
            this.iNU = new com.baidu.tieba.pb.pb.main.a.b(this.iDY, this.gqq);
        }
    }

    private void cpv() {
        if (this.iNS == null) {
            this.iNS = new com.baidu.tieba.pb.pb.main.a.c(this.iDY, this.dqK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpw() {
        if (this.iDY.cmS()) {
            this.iNN = (ViewStub) this.aCQ.findViewById(R.id.manga_mention_controller_view_stub);
            this.iNN.setVisibility(0);
            if (this.iNV == null) {
                this.iNV = (LinearLayout) this.aCQ.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.q.a.a(this.iDY.getPageContext(), this.iNV);
            }
            if (this.iNW == null) {
                this.iNW = (TextView) this.iNV.findViewById(R.id.manga_prev_btn);
            }
            if (this.iNX == null) {
                this.iNX = (TextView) this.iNV.findViewById(R.id.manga_next_btn);
            }
            this.iNW.setOnClickListener(this.gqq);
            this.iNX.setOnClickListener(this.gqq);
        }
    }

    private void cpx() {
        if (this.iDY.cmS()) {
            if (this.iDY.cmV() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iNW, R.color.cp_cont_e, 1);
            }
            if (this.iDY.cmW() == -1) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iNX, R.color.cp_cont_e, 1);
            }
        }
    }

    public void cpy() {
        if (this.iNV == null) {
            cpw();
        }
        this.iNN.setVisibility(8);
        if (this.iPz != null && this.iPA != null) {
            this.iPz.removeCallbacks(this.iPA);
        }
    }

    public void cpz() {
        if (this.iPz != null) {
            if (this.iPA != null) {
                this.iPz.removeCallbacks(this.iPA);
            }
            this.iPA = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.3
                @Override // java.lang.Runnable
                public void run() {
                    if (an.this.iNV == null) {
                        an.this.cpw();
                    }
                    an.this.iNN.setVisibility(0);
                }
            };
            this.iPz.postDelayed(this.iPA, 2000L);
        }
    }

    public void qj(boolean z) {
        this.iNK.qj(z);
        if (z && this.iOH) {
            this.guN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.iNO.setNextPage(this.guN);
            this.iNJ = 2;
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
        this.FO.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.FO.getParent() == null) {
            this.aCQ.addView(this.FO, layoutParams);
        }
        this.FO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.FO.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.an.5
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).aJw() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).aJw() == EmotionGroupType.USER_COLLECT) {
                        if (an.this.mPermissionJudgePolicy == null) {
                            an.this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
                        }
                        an.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        an.this.mPermissionJudgePolicy.appendRequestPermission(an.this.iDY.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!an.this.mPermissionJudgePolicy.startRequestPermission(an.this.iDY.getBaseFragmentActivity())) {
                            an.this.iDY.cmo().c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            an.this.iDY.cmo().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cpg();
        this.iDY.cmo().b(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.an.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (an.this.FO != null && an.this.FO.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (an.this.iPo == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, an.this.FO.getId());
                            an.this.iPo = new com.baidu.tieba.pb.pb.main.emotion.c(an.this.iDY.getPageContext(), an.this.aCQ, layoutParams2);
                            if (!com.baidu.tbadk.core.util.v.isEmpty(an.this.iPn)) {
                                an.this.iPo.setData(an.this.iPn);
                            }
                            an.this.iPo.b(an.this.FO);
                        }
                        an.this.iPo.Gk(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (an.this.iDY.iHH != null && an.this.iDY.iHH.cqx() != null) {
                    if (!an.this.iDY.iHH.cqx().cUf()) {
                        an.this.iDY.iHH.qw(false);
                    }
                    an.this.iDY.iHH.cqx().tH(false);
                }
            }
        });
    }

    public void cpA() {
        if (this.iDY != null && this.FO != null) {
            this.FO.display();
            if (this.iDY.cmo() != null) {
                this.iDY.cmo().aOW();
            }
            cqi();
        }
    }

    public void qk(boolean z) {
        if (this.iNO != null && this.textView != null && this.aCb != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.aCb.setVisibility(0);
                } else {
                    this.aCb.setVisibility(8);
                    this.iNO.removeHeaderView(this.textView);
                    this.iNO.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = iOO;
                    this.textView.setLayoutParams(layoutParams);
                }
                cpO();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + qt(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            cpO();
            cqq();
        }
    }

    public f cpB() {
        return this.iNZ;
    }

    public void a(PbFragment.c cVar) {
        this.iIF = cVar;
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
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iDY.getContext());
        kVar.setTitleText(this.iDY.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.7
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.iOg.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            an.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (an.this.iPC != null) {
                                an.this.iPC.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            an.this.iDY.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.iDY.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.iDY.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !cqp()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.iDY.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.iDY.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.iDY.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.az(arrayList);
        if (this.iOg == null) {
            this.iOg = new com.baidu.tbadk.core.dialog.i(this.iDY.getPageContext(), kVar);
        } else {
            this.iOg.a(kVar);
        }
        this.iOg.showDialog();
    }

    public void a(PbFragment.b bVar) {
        this.iPC = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.iDY != null && aVar != null) {
            if (this.gQj == null && this.iNR != null) {
                this.gQj = new com.baidu.tieba.NEGFeedBack.e(this.iDY.getPageContext(), this.iNR.cqH());
            }
            AntiData bCY = this.iDY.bCY();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bCY != null && bCY.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bCY.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
            alVar.setFeedBackReasonMap(sparseArray);
            this.gQj.setDefaultReasonArray(new String[]{this.iDY.getString(R.string.delete_thread_reason_1), this.iDY.getString(R.string.delete_thread_reason_2), this.iDY.getString(R.string.delete_thread_reason_3), this.iDY.getString(R.string.delete_thread_reason_4), this.iDY.getString(R.string.delete_thread_reason_5)});
            this.gQj.setData(alVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.gQj.wm(str);
            this.gQj.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.an.8
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    an.this.iDY.a(aVar, jSONArray);
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
        sparseArray.put(iOV, Integer.valueOf(iOW));
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
        this.iOh = new com.baidu.tbadk.core.dialog.a(this.iDY.getActivity());
        if (StringUtils.isNull(str2)) {
            this.iOh.jW(i3);
        } else {
            this.iOh.setOnlyMessageShowCenter(false);
            this.iOh.sS(str2);
        }
        this.iOh.setYesButtonTag(sparseArray);
        this.iOh.a(R.string.dialog_ok, this.iDY);
        this.iOh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iOh.fG(true);
        this.iOh.b(this.iDY.getPageContext());
        if (z) {
            this.iOh.aEC();
        } else {
            a(this.iOh, i);
        }
    }

    public void aM(ArrayList<com.baidu.tbadk.core.data.ad> arrayList) {
        if (this.iOk == null) {
            this.iOk = LayoutInflater.from(this.iDY.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.iDY.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iOk);
        if (this.iOj == null) {
            this.iOj = new Dialog(this.iDY.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iOj.setCanceledOnTouchOutside(true);
            this.iOj.setCancelable(true);
            this.iOs = (ScrollView) this.iOk.findViewById(R.id.good_scroll);
            this.iOj.setContentView(this.iOk);
            WindowManager.LayoutParams attributes = this.iOj.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.iOj.getWindow().setAttributes(attributes);
            this.fLV = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.an.10
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        an.this.iOo = (String) compoundButton.getTag();
                        if (an.this.fLU != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : an.this.fLU) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && an.this.iOo != null && !str.equals(an.this.iOo)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.iOl = (LinearLayout) this.iOk.findViewById(R.id.good_class_group);
            this.iOn = (TextView) this.iOk.findViewById(R.id.dialog_button_cancel);
            this.iOn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (an.this.iOj instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(an.this.iOj, an.this.iDY.getPageContext());
                    }
                }
            });
            this.iOm = (TextView) this.iOk.findViewById(R.id.dialog_button_ok);
            this.iOm.setOnClickListener(this.gqq);
        }
        this.iOl.removeAllViews();
        this.fLU = new ArrayList();
        CustomBlueCheckRadioButton ef = ef("0", this.iDY.getPageContext().getString(R.string.thread_good_class));
        this.fLU.add(ef);
        ef.setChecked(true);
        this.iOl.addView(ef);
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
                    this.fLU.add(ef2);
                    View view = new View(this.iDY.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.iOl.addView(view);
                    this.iOl.addView(ef2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.iOs.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iDY.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iDY.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.iDY.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.iOs.setLayoutParams(layoutParams2);
            this.iOs.removeAllViews();
            if (this.iOl != null && this.iOl.getParent() == null) {
                this.iOs.addView(this.iOl);
            }
        }
        com.baidu.adp.lib.f.g.a(this.iOj, this.iDY.getPageContext());
    }

    private CustomBlueCheckRadioButton ef(String str, String str2) {
        Activity pageActivity = this.iDY.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.fLV);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void cpC() {
        this.iDY.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.iDY.hideProgressBar();
        if (z && z2) {
            this.iDY.showToast(this.iDY.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.iDY.showToast(str);
        }
    }

    public void bWs() {
        this.iOf.setVisibility(0);
    }

    public void bWr() {
        this.iOf.setVisibility(8);
    }

    public View cpD() {
        if (this.iOk != null) {
            return this.iOk.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String cpE() {
        return this.iOo;
    }

    public View getView() {
        return this.aCQ;
    }

    public void cpF() {
        com.baidu.adp.lib.util.l.hideSoftKeyPad(this.iDY.getPageContext().getPageActivity(), this.iDY.getBaseFragmentActivity().getCurrentFocus());
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.iDY.hideProgressBar();
        if (z) {
            cpY();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            cpZ();
        } else {
            cpY();
        }
    }

    public void cpG() {
        this.guN.setLineVisible();
        this.guN.startLoadData();
    }

    public void cpH() {
        this.iDY.hideProgressBar();
        endLoadData();
        this.iNO.completePullRefreshPostDelayed(0L);
        cpT();
    }

    public void cpI() {
        this.iNO.completePullRefreshPostDelayed(0L);
        cpT();
    }

    private void ql(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.iNT.b(onLongClickListener);
        this.iNZ.setOnLongClickListener(onLongClickListener);
        if (this.iPp != null) {
            this.iPp.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.a aVar, boolean z, boolean z2) {
        if (this.iHI != null) {
            this.iHI.dismiss();
            this.iHI = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iDY.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.iDY.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iDY.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iDY.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iDY.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.az(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.iOp.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iOp = new com.baidu.tbadk.core.dialog.i(this.iDY.getPageContext(), kVar);
        this.iOp.showDialog();
    }

    public void a(final b.a aVar, boolean z) {
        if (this.iOp != null) {
            this.iOp.dismiss();
            this.iOp = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.iDY.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.iFb != null && this.iFb.cku() != null && !this.iFb.cku().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.iDY.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.iDY.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.az(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.an.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                an.this.iOp.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iOp = new com.baidu.tbadk.core.dialog.i(this.iDY.getPageContext(), kVar);
        this.iOp.showDialog();
    }

    public int cpJ() {
        return zd(this.iNO.getFirstVisiblePosition());
    }

    private int zd(int i) {
        com.baidu.adp.widget.ListView.e adapter = this.iNO.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.iNO.getAdapter() == null || !(this.iNO.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) ? 0 : this.iNO.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int cpK() {
        int lastVisiblePosition = this.iNO.getLastVisiblePosition();
        if (this.iNQ != null) {
            if (lastVisiblePosition == this.iNO.getCount() - 1) {
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
        if (this.iNO != null) {
            if (this.iNK == null || this.iNK.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.iNK.mNavigationBar.getFixedNavHeight();
                if (this.iDY.cmI() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.iOM != null && (layoutParams = (LinearLayout.LayoutParams) this.iOM.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.iOM.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.iNO.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.iNO.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.iNO.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.iOc.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void o(com.baidu.tieba.pb.data.e eVar) {
        int i;
        this.iNZ.a(eVar, false);
        this.iNZ.notifyDataSetChanged();
        cpT();
        if (this.iPp != null) {
            this.iPp.clx();
        }
        ArrayList<PostData> ckw = eVar.ckw();
        if (eVar.getPage().aBk() == 0 || ckw == null || ckw.size() < eVar.getPage().aBj()) {
            if (com.baidu.tbadk.core.util.v.getCount(ckw) == 0 || (com.baidu.tbadk.core.util.v.getCount(ckw) == 1 && ckw.get(0) != null && ckw.get(0).cLa() == 1)) {
                if (this.iOR == null || this.iOR.iPV == null || this.iOR.iPV.getView() == null) {
                    i = 0;
                } else {
                    i = this.iOR.iPV.getView().getTop() < 0 ? this.iOR.iPV.getView().getHeight() : this.iOR.iPV.getView().getBottom();
                }
                if (this.iDY.cnc()) {
                    this.guN.ab(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.guN.ab(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (eVar.getPage().aBk() == 0) {
                    this.guN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.guN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.guN.aHH();
            }
        }
        q(eVar);
    }

    public void p(com.baidu.tieba.pb.data.e eVar) {
        if (this.iNR != null) {
            this.iNR.e(eVar, this.iEK);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.e eVar, boolean z) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.ckE() != null) {
            return eVar.ckE();
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.ckw())) {
            Iterator<PostData> it = eVar.ckw().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cLa() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.ckB();
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
        if (eVar == null || eVar.cku() == null || eVar.cku().aCo() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aCo = eVar.cku().aCo();
        String userId = aCo.getUserId();
        HashMap<String, MetaData> userMap = eVar.cku().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aCo;
        }
        postData.Cw(1);
        postData.setId(eVar.cku().aCE());
        postData.setTitle(eVar.cku().getTitle());
        postData.setTime(eVar.cku().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.e eVar, boolean z, int i, int i2) {
        if (eVar != null && eVar.cku() != null) {
            if (this.iDY.clr()) {
                if (eVar.ckt() != null) {
                    this.mForumName = eVar.ckt().getForumName();
                    this.mForumId = eVar.ckt().getForumId();
                }
                if (this.mForumName == null && this.iDY.clB() != null && this.iDY.clB().cls() != null) {
                    this.mForumName = this.iDY.clB().cls();
                }
            }
            PostData b = b(eVar, z);
            a(b, eVar);
            this.iNT.setVisibility(8);
            if (eVar.aHK()) {
                this.iPg = true;
                this.iNK.qH(true);
                this.iNK.mNavigationBar.hideBottomLine();
                if (this.iNQ == null) {
                    this.iNQ = new com.baidu.tieba.pb.pb.main.a.e(this.iDY);
                }
                this.iNQ.a(eVar, b, this.iNO, this.iNT, this.iOK, this.iNK, this.mForumName, this.iPu);
                this.iNQ.R(this.iPE);
                cpO();
            } else {
                this.iPg = false;
                this.iNK.qH(this.iPg);
                if (this.iNQ != null) {
                    this.iNQ.c(this.iNO);
                }
            }
            if (this.iDY.cmr() != null) {
                this.iDY.cmr().qB(this.iPg);
            }
            if (b != null) {
                this.iOG = b;
                this.iNT.setVisibility(0);
                SparseArray<Object> cqJ = this.iNT.cqJ();
                cqJ.put(R.id.tag_clip_board, b);
                cqJ.put(R.id.tag_is_subpb, false);
                this.iNU.a(eVar, this.iNO);
                this.iNS.w(eVar);
                this.iNR.e(eVar, this.iEK);
                this.iNR.v(eVar);
                this.iNT.a(this.mSkinType, this.iFb, b, this.iPE);
                if (this.iON != null) {
                    if (eVar.ckS()) {
                        this.iON.getView().setVisibility(8);
                    } else {
                        this.iON.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.iCD);
                        if (eVar.cku() != null) {
                            jVar.iCF = eVar.cku().aCf();
                        }
                        jVar.isNew = !this.iEK;
                        jVar.sortType = eVar.iBE;
                        jVar.iCH = eVar.ckT();
                        jVar.iCI = this.iDY.cnc();
                        this.iON.a(jVar);
                    }
                }
                if (eVar != null && eVar.cku() != null) {
                    af(eVar.cku().aCk() == 1, eVar.cku().aCj() == 1);
                }
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (an.this.iNZ != null && an.this.iNK != null && an.this.iNK.iTR != null && an.this.iFb != null && an.this.iFb.cku() != null && !an.this.iFb.cku().aBb() && !an.this.cpS() && an.this.iFb.getForum() != null && !com.baidu.tbadk.core.util.aq.isEmpty(an.this.iFb.getForum().getName())) {
                            if (an.this.iNZ.cmf() == null || !an.this.iNZ.cmf().isShown()) {
                                an.this.iNK.iTR.setVisibility(0);
                                if (an.this.iDY != null && an.this.iDY.clB() != null) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13400");
                                    anVar.cy("tid", an.this.iDY.clB().cny());
                                    anVar.cy("fid", an.this.iDY.clB().getForumId());
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
            cpL();
        } else {
            byJ();
        }
        this.iOR.iPV = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iOR));
        a(this.iOR.iPV, false);
    }

    public void cpL() {
        if (this.iNK != null && !this.iPi) {
            this.iNK.cpL();
            this.iPi = true;
        }
    }

    public void byJ() {
        if (this.iNK != null) {
            this.iNK.crh();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.e eVar) {
        this.iNT.a(postData, eVar);
    }

    public void cpM() {
        if (this.iNQ != null) {
            this.iNQ.d(this.iNO);
        }
    }

    public boolean cpN() {
        return this.aqb;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aI(bj bjVar) {
        if (bjVar == null || bjVar.aCo() == null) {
            return false;
        }
        PostData b = b(this.iFb, false);
        String str = "";
        if (b != null && b.aCo() != null) {
            str = b.aCo().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.iNK.crf();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.iNK.DT(dVar.forumName);
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
            final String str2 = dVar.iBw;
            this.iDY.showNetRefreshView(this.aCQ, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        ba.aGG().b(an.this.iDY.getPageContext(), new String[]{str2});
                        an.this.iDY.finish();
                        return;
                    }
                    an.this.iDY.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable coR;
        Parcelable coR2;
        if (eVar != null && this.iNO != null) {
            this.iFb = eVar;
            this.mType = i;
            if (eVar.cku() != null) {
                this.iOT = eVar.cku().aBV();
                if (eVar.cku().getAnchorLevel() != 0) {
                    this.aqb = true;
                }
                this.iOr = aI(eVar.cku());
            }
            if (eVar.getUserData() != null) {
                this.userId = eVar.getUserData().getUserId();
            }
            u(eVar);
            this.iOH = false;
            this.iEK = z;
            cpH();
            if (eVar.iBF != null && eVar.iBF.ckX()) {
                if (this.iNP == null) {
                    this.iNP = new PbThreadPostView(this.iDY.getContext());
                    this.iNO.addHeaderView(this.iNP, 1);
                    this.iNP.setData(eVar);
                    this.iNP.setChildOnClickLinstener(this.gqq);
                }
            } else if (this.iNP != null && this.iNO != null) {
                this.iNO.removeHeaderView(this.iNP);
            }
            a(eVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            r(eVar);
            if (this.iPs == null) {
                this.iPs = new aa(this.iDY.getPageContext(), this.gNp);
            }
            this.iPs.Ga(eVar.ckz());
            if (this.iDY.cmS()) {
                if (this.iOd == null) {
                    this.iOd = new com.baidu.tieba.pb.view.d(this.iDY.getPageContext());
                    this.iOd.createView();
                    this.iOd.setListPullRefreshListener(this.dgI);
                }
                this.iNO.setPullRefresh(this.iOd);
                cpO();
                if (this.iOd != null) {
                    this.iOd.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (eVar.getPage().aBl() == 0 && z) {
                this.iNO.setPullRefresh(null);
            } else {
                if (this.iOd == null) {
                    this.iOd = new com.baidu.tieba.pb.view.d(this.iDY.getPageContext());
                    this.iOd.createView();
                    this.iOd.setListPullRefreshListener(this.dgI);
                }
                this.iNO.setPullRefresh(this.iOd);
                cpO();
                if (this.iOd != null) {
                    this.iOd.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                bqr();
            }
            cpT();
            this.iNZ.px(this.iEK);
            this.iNZ.py(false);
            this.iNZ.pC(i == 5);
            this.iNZ.pD(i == 6);
            this.iNZ.pE(z2 && this.iPD);
            this.iNZ.a(eVar, false);
            this.iNZ.notifyDataSetChanged();
            this.iNT.a(b(eVar, z), eVar.ckS());
            if (eVar.cku() != null && eVar.cku().aBZ() != null && this.iNI != -1) {
                eVar.cku().aBZ().setIsLike(this.iNI);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.iNO.setNextPage(this.guN);
                this.iNJ = 2;
                bqr();
            } else {
                this.iOH = true;
                if (eVar.getPage().aBk() == 1) {
                    if (this.iOe == null) {
                        this.iOe = new com.baidu.tieba.pb.view.a(this.iDY, this.iDY);
                    }
                    this.iNO.setNextPage(this.iOe);
                } else {
                    this.iNO.setNextPage(this.guN);
                }
                this.iNJ = 3;
            }
            ArrayList<PostData> ckw = eVar.ckw();
            if (eVar.getPage().aBk() == 0 || ckw == null || ckw.size() < eVar.getPage().aBj()) {
                if (com.baidu.tbadk.core.util.v.getCount(ckw) == 0 || (com.baidu.tbadk.core.util.v.getCount(ckw) == 1 && ckw.get(0) != null && ckw.get(0).cLa() == 1)) {
                    if (this.iOR == null || this.iOR.iPV == null || this.iOR.iPV.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.iOR.iPV.getView().getTop() < 0 ? this.iOR.iPV.getView().getHeight() : this.iOR.iPV.getView().getBottom();
                    }
                    if (this.iDY.cnc()) {
                        this.guN.ab(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.guN.ab(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.iDY.cmr() != null && !this.iDY.cmr().cqT()) {
                        this.iDY.cmr().showFloatingView();
                    }
                } else {
                    if (eVar.getPage().aBk() == 0) {
                        this.guN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.guN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.guN.aHH();
                }
                if (eVar.getPage().aBk() == 0 || ckw == null) {
                    cqd();
                }
            } else {
                if (z2) {
                    if (this.iPD) {
                        endLoadData();
                        if (eVar.getPage().aBk() != 0) {
                            this.guN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.guN.setLineVisible();
                        this.guN.showLoading();
                    }
                } else {
                    this.guN.setLineVisible();
                    this.guN.showLoading();
                }
                this.guN.aHH();
            }
            switch (i) {
                case 2:
                    this.iNO.setSelection(i2 > 1 ? (((this.iNO.getData() == null && eVar.ckw() == null) ? 0 : (this.iNO.getData().size() - eVar.ckw().size()) + this.iNO.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (coR2 = ah.coQ().coR()) != null && !(coR2 instanceof RecyclerView.SavedState)) {
                        this.iNO.onRestoreInstanceState(coR2);
                        if (com.baidu.tbadk.core.util.v.getCount(ckw) > 1 && eVar.getPage().aBk() > 0) {
                            this.guN.endLoadData();
                            this.guN.setText(this.iDY.getString(R.string.pb_load_more_without_point));
                            this.guN.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.iPD = false;
                    break;
                case 5:
                    this.iNO.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (coR = ah.coQ().coR()) != null && !(coR instanceof RecyclerView.SavedState)) {
                        this.iNO.onRestoreInstanceState(coR);
                        break;
                    } else {
                        this.iNO.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.iNQ != null && this.iNQ.bcK() != null) {
                            if (this.iDY.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.iNO.setSelectionFromTop((this.iNZ.cma() + this.iNO.getHeaderViewsCount()) - 1, this.iNQ.cqL() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.iDY.getPageContext().getPageActivity()));
                            } else {
                                this.iNO.setSelectionFromTop((this.iNZ.cma() + this.iNO.getHeaderViewsCount()) - 1, this.iNQ.cqL());
                            }
                        } else {
                            this.iNO.setSelection(this.iNZ.cma() + this.iNO.getHeaderViewsCount());
                        }
                    } else {
                        this.iNO.setSelection(i2 > 0 ? ((this.iNO.getData() == null && eVar.ckw() == null) ? 0 : (this.iNO.getData().size() - eVar.ckw().size()) + this.iNO.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.guN.endLoadData();
                    this.guN.setText(this.iDY.getString(R.string.pb_load_more_without_point));
                    this.guN.setLineGone();
                    break;
            }
            if (this.iOT == iOU && isHost()) {
                cql();
            }
            if (this.iPe) {
                cpe();
                this.iPe = false;
                if (i3 == 0) {
                    qf(true);
                }
            }
            if (eVar.iBB == 1 || eVar.iBC == 1) {
                if (this.iPk == null) {
                    this.iPk = new PbTopTipView(this.iDY.getContext());
                }
                if (eVar.iBC == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.iDY.getStType())) {
                    this.iPk.setText(this.iDY.getString(R.string.pb_read_strategy_add_experience));
                    this.iPk.a(this.aCQ, this.mSkinType);
                } else if (eVar.iBB == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.iDY.getStType())) {
                    this.iPk.setText(this.iDY.getString(R.string.pb_read_news_add_experience));
                    this.iPk.a(this.aCQ, this.mSkinType);
                }
            }
            q(eVar);
        }
    }

    private void q(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cku() != null) {
            t(eVar);
            if (eVar.ayL()) {
                SvgManager.aGC().a(this.iOz, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aGC().a(this.iOz, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.iOC.setText(zf(eVar.cku().aCf()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.cku()));
        }
    }

    private String zf(int i) {
        if (i == 0) {
            return this.iDY.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void cpO() {
        if (this.iNQ != null) {
            this.iNQ.a(this.iNO, this.textView, this.mType);
        }
    }

    public void qn(boolean z) {
        this.iOq = z;
    }

    public void endLoadData() {
        if (this.guN != null) {
            this.guN.setLineGone();
            this.guN.endLoadData();
        }
        bqr();
    }

    public void bgy() {
        this.iNO.setVisibility(0);
    }

    public void cpP() {
        if (this.iNO != null) {
            this.iNO.setVisibility(8);
        }
        if (this.iNO != null) {
            this.iOK.setVisibility(8);
        }
        if (this.iNK != null && this.iNK.iTO != null) {
            this.iNK.iTO.setVisibility(8);
        }
    }

    public void cpQ() {
        if (this.iNO != null) {
            this.iNO.setVisibility(0);
        }
        if (this.iOK != null) {
            this.iOK.setVisibility(0);
        }
        if (this.iNK != null && this.iNK.iTO != null) {
            this.iNK.iTO.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void r(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && this.iOG != null && this.iOG.aCo() != null && this.iNK != null) {
            this.iPh = !this.iPg;
            this.iNK.qD(this.iPh);
            if (this.iDY.cmr() != null) {
                this.iDY.cmr().qC(this.iPh);
            }
            cpR();
            if (this.iDY != null && !this.iDY.clr() && !com.baidu.tbadk.core.util.v.isEmpty(eVar.ckN())) {
                bf bfVar = eVar.ckN().get(0);
                if (bfVar != null) {
                    this.iNK.eg(bfVar.getForumName(), bfVar.getAvatar());
                }
            } else if (eVar.getForum() != null) {
                this.iNK.eg(eVar.getForum().getName(), eVar.getForum().getImage_url());
            }
            if (this.iPh) {
                this.iNT.a(eVar, this.iOG, this.iOr);
                if (this.iOM != null) {
                    this.iOM.setVisibility(8);
                }
                if (this.iPq == null) {
                    this.iPq = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.an.18
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (an.this.iDY != null && an.this.iDY.isAdded()) {
                                if (i < 0 && f > an.this.iPj) {
                                    an.this.cqk();
                                }
                                an.this.cpI();
                            }
                        }
                    };
                }
                this.iNO.setListViewDragListener(this.iPq);
                return;
            }
            if (this.iOM != null) {
                this.iOM.setVisibility(0);
            }
            this.iNT.a(eVar, this.iOG, this.iOr);
            this.iPq = null;
            this.iNO.setListViewDragListener(null);
        }
    }

    private void cpR() {
        this.iNT.a(this.iFb, this.iOG, this.iPh, this.iPg);
    }

    public boolean cpS() {
        return this.iFb == null || this.iFb.getForum() == null || "0".equals(this.iFb.getForum().getId()) || "me0407".equals(this.iFb.getForum().getName());
    }

    private boolean cpT() {
        return this.iNR.qy(this.iEK);
    }

    private boolean s(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cku() == null) {
            return false;
        }
        if (eVar.cku().aCl() == 1 || eVar.cku().getThreadType() == 33) {
            return true;
        }
        return !(eVar.cku().aCn() == null || eVar.cku().aCn().aEt() == 0) || eVar.cku().aCj() == 1 || eVar.cku().aCk() == 1 || eVar.cku().aCZ() || eVar.cku().aDs() || eVar.cku().aDm() || eVar.cku().aCA() != null || !com.baidu.tbadk.core.util.aq.isEmpty(eVar.cku().getCategory()) || eVar.cku().aCr() || eVar.cku().aCq();
    }

    public boolean c(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            if (this.iNS != null) {
                if (eVar.cku() != null && eVar.cku().aCD() == 0 && !eVar.cku().aBb() && !this.iPw) {
                    if (eVar.cku() != null) {
                        bj cku = eVar.cku();
                        cku.s(true, s(eVar));
                        cku.jI(3);
                        cku.sF("2");
                    }
                    if (eVar.cku().aBd()) {
                        this.iNT.c(this.iNO);
                        this.iNS.c(this.iNO);
                        this.iNS.b(this.iNO);
                        this.iNT.b(this.iNO);
                        this.iNT.B(this.iFb);
                        this.iNS.x(eVar);
                    } else {
                        this.iNT.B(this.iFb);
                        this.iNS.z(eVar);
                    }
                } else if (eVar.cku().aCD() == 1) {
                    if (eVar.cku() != null) {
                        this.iNS.c(this.iNO);
                        this.iNT.B(this.iFb);
                    }
                } else {
                    this.iNS.c(this.iNO);
                    this.iNT.B(this.iFb);
                }
            }
            if (eVar.cku() != null) {
                ae(eVar.cku().aCk() == 1, eVar.cku().aCj() == 1);
            }
            this.iEK = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.e eVar, boolean z) {
        if (eVar != null) {
            c(eVar, z);
            cpT();
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.ckG()));
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.ckG()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bf> ckN = eVar.ckN();
                if (com.baidu.tbadk.core.util.v.getCount(ckN) > 0) {
                    sb = new StringBuilder();
                    for (bf bfVar : ckN) {
                        if (bfVar != null && !StringUtils.isNull(bfVar.getForumName()) && (wVar = bfVar.cQP) != null && wVar.cOJ && !wVar.cOK && (wVar.type == 1 || wVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bfVar.getForumName(), 12)).append(this.iDY.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.iDY.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View cpU() {
        return this.dCN;
    }

    public boolean cpV() {
        if (this.aDx == null || this.aDx.getParent() == null || this.guN.isLoading()) {
            return false;
        }
        int bottom = this.aDx.getBottom();
        Rect rect = new Rect();
        this.aDx.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Gc(String str) {
        if (this.guN != null) {
            this.guN.setText(str);
        }
    }

    public void Gd(String str) {
        if (this.guN != null) {
            int i = 0;
            if (this.iOR != null && this.iOR.iPV != null && this.iOR.iPV.getView() != null) {
                i = this.iOR.iPV.getView().getTop() < 0 ? this.iOR.iPV.getView().getHeight() : this.iOR.iPV.getView().getBottom();
            }
            this.guN.ab(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.iNO;
    }

    public int cpW() {
        return R.id.richText;
    }

    public TextView clL() {
        return this.iNT.clL();
    }

    public void d(BdListView.e eVar) {
        this.iNO.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.dgI = cVar;
        if (this.iOd != null) {
            this.iOd.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ap apVar, a.b bVar) {
        if (apVar != null) {
            int aBi = apVar.aBi();
            int aBf = apVar.aBf();
            if (this.iOa != null) {
                this.iOa.aEC();
            } else {
                this.iOa = new com.baidu.tbadk.core.dialog.a(this.iDY.getPageContext().getPageActivity());
                this.iOb = LayoutInflater.from(this.iDY.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.iOa.aO(this.iOb);
                this.iOa.a(R.string.dialog_ok, bVar);
                this.iOa.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.19
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        an.this.cpY();
                        aVar.dismiss();
                    }
                });
                this.iOa.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.an.20
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (an.this.iPb == null) {
                            an.this.iPb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.20.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    an.this.iDY.HidenSoftKeyPad((InputMethodManager) an.this.iDY.getBaseFragmentActivity().getSystemService("input_method"), an.this.aCQ);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.gx().postDelayed(an.this.iPb, 150L);
                    }
                });
                this.iOa.b(this.iDY.getPageContext()).aEC();
            }
            this.iOc = (EditText) this.iOb.findViewById(R.id.input_page_number);
            this.iOc.setText("");
            TextView textView = (TextView) this.iOb.findViewById(R.id.current_page_number);
            if (aBi <= 0) {
                aBi = 1;
            }
            if (aBf <= 0) {
                aBf = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(aBi), Integer.valueOf(aBf)));
            this.iDY.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.iOc, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.iNO.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.iDY.showToast(str);
    }

    public boolean qo(boolean z) {
        if (this.FO == null || !this.FO.aOv()) {
            return false;
        }
        this.FO.aMQ();
        return true;
    }

    public void cpX() {
        if (this.iPF != null) {
            while (this.iPF.size() > 0) {
                TbImageView remove = this.iPF.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        cpX();
        this.iNZ.yH(1);
        if (this.iNQ != null) {
            this.iNQ.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.iNZ.yH(2);
        if (this.iNQ != null) {
            this.iNQ.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.iDY.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.iDY.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.iOB != null) {
            this.iOB.onDestroy();
        }
        if (this.iPd != null) {
            this.iPd.destroy();
        }
        if (this.iPs != null) {
            this.iPs.onDestory();
        }
        if (this.iPk != null) {
            this.iPk.hide();
        }
        this.iDY.hideProgressBar();
        if (this.fUQ != null && this.glL != null) {
            this.fUQ.b(this.glL);
        }
        cpY();
        endLoadData();
        if (this.iPb != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iPb);
        }
        if (this.iOJ != null) {
            this.iOJ.clearStatus();
        }
        this.iPz = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.iNZ.yH(3);
        if (this.aCb != null) {
            this.aCb.setBackgroundDrawable(null);
        }
        if (this.iNQ != null) {
            this.iNQ.destroy();
        }
        if (this.iNZ != null) {
            this.iNZ.onDestroy();
        }
        this.iNO.setOnLayoutListener(null);
        if (this.iPo != null) {
            this.iPo.bGv();
        }
        if (this.iOS != null) {
            this.iOS.onDestroy();
        }
        if (this.iNT != null) {
            this.iNT.onDestroy();
        }
    }

    public boolean zg(int i) {
        if (this.iNQ != null) {
            return this.iNQ.zg(i);
        }
        return false;
    }

    public void cpY() {
        this.iNK.arU();
        if (this.iNT != null) {
            this.iNT.cpY();
        }
        if (this.iDY != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.iDY.getContext(), this.iOc);
        }
        cpg();
        if (this.iHI != null) {
            this.iHI.dismiss();
        }
        cqa();
        if (this.iOa != null) {
            this.iOa.dismiss();
        }
        if (this.gqp != null) {
            this.gqp.dismiss();
        }
    }

    public void cpZ() {
        this.iNK.arU();
        if (this.iNT != null) {
            this.iNT.cpY();
        }
        if (this.iHI != null) {
            this.iHI.dismiss();
        }
        cqa();
        if (this.iOa != null) {
            this.iOa.dismiss();
        }
        if (this.gqp != null) {
            this.gqp.dismiss();
        }
    }

    public void dH(List<String> list) {
        this.iPn = list;
        if (this.iPo != null) {
            this.iPo.setData(list);
        }
    }

    public void pw(boolean z) {
        this.iNZ.pw(z);
    }

    public void qp(boolean z) {
        this.iOt = z;
    }

    public void cqa() {
        if (this.iOh != null) {
            this.iOh.dismiss();
        }
        if (this.iOi != null) {
            com.baidu.adp.lib.f.g.b(this.iOi, this.iDY.getPageContext());
        }
        if (this.iOj != null) {
            com.baidu.adp.lib.f.g.b(this.iOj, this.iDY.getPageContext());
        }
        if (this.iOg != null) {
            this.iOg.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.iFb, this.iEK);
            b(this.iFb, this.iEK, this.mType, i);
            this.iDY.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.iDY.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.aCQ);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.aCQ, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.iOu, R.drawable.personalize_tab_shadow);
            if (this.iNQ != null) {
                this.iNQ.onChangeSkinType(i);
            }
            if (this.iNU != null) {
                this.iNU.onChangeSkinType(i);
            }
            if (this.iNR != null) {
                this.iNR.onChangeSkinType(i);
            }
            if (this.iNS != null) {
                this.iNS.onChangeSkinType(i);
            }
            if (this.iNT != null) {
                this.iNT.onChangeSkinType(i);
            }
            if (this.guN != null) {
                this.guN.changeSkin(i);
                if (this.dCN != null) {
                    this.iDY.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.dCN);
                    com.baidu.tbadk.core.util.am.setBackgroundResource(this.dCN, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.iOa != null) {
                this.iOa.c(this.iDY.getPageContext());
            }
            qn(this.iOq);
            this.iNZ.notifyDataSetChanged();
            if (this.iOd != null) {
                this.iOd.changeSkin(i);
            }
            if (this.FO != null) {
                this.FO.onChangeSkinType(i);
            }
            if (this.iOe != null) {
                this.iOe.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.fLU)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.fLU) {
                    customBlueCheckRadioButton.aHu();
                }
            }
            cpx();
            UtilHelper.setStatusBarBackground(this.aCb, i);
            UtilHelper.setStatusBarBackground(this.iOM, i);
            if (this.iNV != null) {
                com.baidu.tbadk.q.a.a(this.iDY.getPageContext(), this.iNV);
            }
            if (this.iPc != null) {
                this.iPc.onChangeSkinType(i);
            }
            if (this.iNK != null) {
                if (this.iNQ != null) {
                    this.iNQ.zh(i);
                } else {
                    this.iNK.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.hgM != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hgM, (int) R.color.cp_cont_d);
                this.hgM.setBackgroundDrawable(com.baidu.tbadk.core.util.am.ay(com.baidu.adp.lib.util.l.getDimens(this.iDY.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_j)));
            }
            if (this.iOz != null && this.iFb != null) {
                if (this.iFb.ayL()) {
                    SvgManager.aGC().a(this.iOz, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.aGC().a(this.iOz, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            t(this.iFb);
            if (this.iOy != null) {
                SvgManager.aGC().a(this.iOy, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.iOw != null) {
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iOw, R.drawable.bottom_shadow);
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iOC, (int) R.color.cp_cont_b);
            if (this.iPp != null) {
                this.iPp.onChangeSkinType(i);
            }
            if (this.iOS != null) {
                this.iOS.onChangeSkinType();
            }
            if (this.iPm != null) {
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iPm, (int) R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.iOx, R.color.cp_bg_line_h);
            if (this.iNP != null) {
                this.iNP.pk(i);
            }
        }
    }

    public void cqb() {
        if (this.iOB != null) {
            this.iOB.setEnable(false);
        }
    }

    public void t(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.aY(eVar.cku())) {
            if (this.iOB != null) {
                this.iOB.setEnable(false);
                this.iOB.onDestroy();
            }
            SvgManager.aGC().a(this.iOA, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.iOB == null || !this.iOB.isEnable()) {
            SvgManager.aGC().a(this.iOA, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMx = iVar;
        this.iNZ.setOnImageClickListener(this.dMx);
        this.iPp.setOnImageClickListener(this.dMx);
    }

    public void g(NoNetworkView.a aVar) {
        this.glL = aVar;
        if (this.fUQ != null) {
            this.fUQ.a(this.glL);
        }
    }

    public void qq(boolean z) {
        this.iNZ.setIsFromCDN(z);
    }

    public Button cqc() {
        return this.iOv;
    }

    public void cqd() {
        if (this.iNJ != 2) {
            this.iNO.setNextPage(this.guN);
            this.iNJ = 2;
        }
    }

    public void cqe() {
        if (com.baidu.tbadk.n.m.aRl().aRm()) {
            int lastVisiblePosition = this.iNO.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.iNO.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.dDv = true;
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
                        perfLog2.dDv = true;
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

    public boolean cqf() {
        return this.FO != null && this.FO.getVisibility() == 0;
    }

    public boolean cqg() {
        return this.FO != null && this.FO.aOv();
    }

    public void cqh() {
        if (this.FO != null) {
            this.FO.aMQ();
        }
    }

    public void qr(boolean z) {
        if (this.iOx != null) {
            qp(this.iDY.cmo().aOZ());
            if (this.iOt) {
                qg(z);
            } else {
                qh(z);
            }
        }
    }

    public void cqi() {
        if (this.iOx != null) {
            this.iOw.setVisibility(8);
            this.iOx.setVisibility(8);
            this.iOD = false;
            if (this.iOS != null) {
                this.iOS.setVisibility(8);
                ql(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.fPV == null) {
            this.fPV = new com.baidu.tbadk.core.view.a(this.iDY.getPageContext());
        }
        this.fPV.setDialogVisiable(true);
    }

    public void bqr() {
        if (this.fPV != null) {
            this.fPV.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.iNO.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.iNO.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.iNQ != null) {
            this.iNQ.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.iPG = getScrollY();
            this.iOR.iPV = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iOR));
            a(this.iOR.iPV, true);
        }
    }

    public void qs(boolean z) {
        if (this.iNQ != null) {
            this.iNQ.qs(z);
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
        if (this.iNQ != null) {
            this.iNQ.onScroll(absListView, i, i2, i3);
        }
        if (this.iNK != null && this.iNZ != null) {
            this.iNK.cC(this.iNZ.cmf());
        }
        this.iOR.iwU = i;
        this.iOR.headerCount = this.iNO.getHeaderViewsCount();
        this.iOR.iPV = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.iOR));
        qi(b(absListView, i));
        a(this.iOR.iPV, false);
        if (this.guN.aHI() && !this.guN.dgA) {
            if (this.iOR != null && this.iOR.iPV != null && this.iOR.iPV.getView() != null) {
                i4 = this.iOR.iPV.getView().getTop() < 0 ? this.iOR.iPV.getView().getHeight() : this.iOR.iPV.getView().getBottom();
            }
            this.guN.lk(i4);
            this.guN.dgA = true;
        }
    }

    public void cqj() {
        if (TbadkCoreApplication.isLogin() && this.iFb != null && this.iPh && !this.iPg && !this.iOr && this.iOG != null && this.iOG.aCo() != null && !this.iOG.aCo().getIsLike() && !this.iOG.aCo().hadConcerned() && this.iPd == null) {
            this.iPd = new ak(this.iDY);
        }
    }

    public void cqk() {
        if (this.iPh && !this.iPg && this.iOG != null && this.iOG.aCo() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12601").X("obj_locate", this.iDY.clr() ? 2 : 1).X("obj_type", this.iPg ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.iDY.getPageContext().getPageActivity(), this.iOG.aCo().getUserId(), this.iOG.aCo().getUserName(), this.iDY.clB().cls(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    private void a(aj ajVar, boolean z) {
        int measuredHeight;
        if (!this.iPg && this.iOL != null && this.iNK.cqZ() != null) {
            int cmb = this.iNZ.cmb();
            if (cmb > 0 && (ajVar == null || ajVar.getView().getParent() == null)) {
                if (cmb > this.iNO.getFirstVisiblePosition() - this.iNO.getHeaderViewsCount()) {
                    this.iOL.setVisibility(8);
                    return;
                }
                this.iOL.setVisibility(0);
                qi(false);
                this.iNK.mNavigationBar.hideBottomLine();
                if (this.iOL.getParent() != null && ((ViewGroup) this.iOL.getParent()).getHeight() <= this.iOL.getTop()) {
                    this.iOL.getParent().requestLayout();
                }
            } else if (ajVar == null || ajVar.getView() == null || ajVar.iNl == null) {
                if (this.iNO.getFirstVisiblePosition() == 0) {
                    this.iOL.setVisibility(8);
                    this.iNK.mNavigationBar.hideBottomLine();
                }
            } else {
                int top2 = ajVar.getView().getTop();
                if (ajVar.getView().getParent() != null) {
                    if (this.iOQ) {
                        this.iOP = top2;
                        this.iOQ = false;
                    }
                    this.iOP = top2 < this.iOP ? top2 : this.iOP;
                }
                if (top2 != 0 || ajVar.getView().isShown()) {
                    if (this.iNY.getY() < 0.0f) {
                        measuredHeight = iOO - ajVar.iNl.getMeasuredHeight();
                    } else {
                        measuredHeight = this.iNK.cqZ().getMeasuredHeight() - ajVar.iNl.getMeasuredHeight();
                        this.iNK.mNavigationBar.hideBottomLine();
                    }
                    if (ajVar.getView().getParent() == null && top2 <= this.iOP) {
                        this.iOL.setVisibility(0);
                        qi(false);
                    } else if (top2 < measuredHeight) {
                        this.iOL.setVisibility(0);
                        qi(false);
                    } else {
                        this.iOL.setVisibility(8);
                        this.iNK.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.iOQ = true;
                    }
                }
            }
        }
    }

    public void cql() {
        if (!this.iPH) {
            TiebaStatic.log("c10490");
            this.iPH = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iDY.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(iOV, Integer.valueOf(iOX));
            aVar.jV(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.iDY.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.aO(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.iDY);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.21
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iDY.getPageContext()).aEC();
        }
    }

    public void Ge(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iDY.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.iDY.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.aO(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(iOV, Integer.valueOf(iOY));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.iDY);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.an.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.iDY.getPageContext()).aEC();
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

    public PbInterviewStatusView cqm() {
        return this.iOJ;
    }

    private void u(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cku() != null && eVar.cku().aDs() && this.iOJ == null) {
            this.iOJ = (PbInterviewStatusView) this.iOI.inflate();
            this.iOJ.setOnClickListener(this.gqq);
            this.iOJ.setCallback(this.iDY.cna());
            this.iOJ.setData(this.iDY, eVar);
        }
    }

    public RelativeLayout cqn() {
        return this.iNY;
    }

    public View cqo() {
        return this.aCb;
    }

    public boolean cqp() {
        return this.iPw;
    }

    public void pB(boolean z) {
        this.iNT.pB(z);
    }

    public void Gf(String str) {
        if (this.iNL != null) {
            this.iNL.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int qt(boolean z) {
        if (this.iOJ == null || this.iOJ.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void cqq() {
        if (this.iOJ != null && this.iOJ.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iOJ.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.iOJ.setLayoutParams(layoutParams);
        }
    }

    public boolean cmu() {
        return false;
    }

    public void Gg(String str) {
        this.hgM.performClick();
        if (!StringUtils.isNull(str) && this.iDY.cmo() != null && this.iDY.cmo().aOS() != null && this.iDY.cmo().aOS().getInputView() != null) {
            EditText inputView = this.iDY.cmo().aOS().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            cpY();
            if (configuration.orientation == 2) {
                cqi();
                cpg();
            } else {
                cpk();
            }
            if (this.iPc != null) {
                this.iPc.cmj();
            }
            this.iDY.bEl();
            this.iNY.setVisibility(8);
            this.iNK.qE(false);
            this.iDY.pP(false);
            if (this.iNQ != null) {
                if (configuration.orientation == 1) {
                    cqn().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.iNO.setIsLandscape(true);
                    this.iNO.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.iNO.setIsLandscape(false);
                    if (this.iPG > 0) {
                        this.iNO.smoothScrollBy(this.iPG, 0);
                    }
                }
                this.iNQ.onConfigurationChanged(configuration);
                this.iOK.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void qu(boolean z) {
        if (this.iNQ != null) {
            this.iNQ.qu(z);
        }
    }

    public boolean cqr() {
        return this.iNQ != null && this.iNQ.cqr();
    }

    public void cqs() {
        if (this.iNQ != null) {
            this.iNQ.cqs();
        }
    }

    public void pF(boolean z) {
        this.iNZ.pF(z);
    }

    public void cB(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.iOx.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.iDY.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.iPm = new TextView(this.iDY.getContext());
            this.iPm.setText(R.string.connection_tips);
            this.iPm.setGravity(17);
            this.iPm.setPadding(com.baidu.adp.lib.util.l.getDimens(this.iDY.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.iDY.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.iDY.getContext(), R.dimen.ds60);
            if (this.iPm.getParent() == null) {
                frameLayout.addView(this.iPm, layoutParams);
            }
            this.iPl = new PopupWindow(this.iDY.getContext());
            this.iPl.setContentView(frameLayout);
            this.iPl.setHeight(-2);
            this.iPl.setWidth(-2);
            this.iPl.setFocusable(true);
            this.iPl.setOutsideTouchable(false);
            this.iPl.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.iNO.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.an.24
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        an.this.iPl.showAsDropDown(an.this.iOx, view.getLeft(), -an.this.iOx.getHeight());
                    } else {
                        an.this.iPl.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void qv(boolean z) {
        this.iPr = z;
    }

    public boolean cqt() {
        return this.iPr;
    }

    public PbThreadPostView cqu() {
        return this.iNP;
    }

    private void ae(boolean z, boolean z2) {
        af(z, z2);
        if (this.iFb != null && this.iFb.cku() != null && this.iFb.cku().aCD() == 0 && !this.iFb.cku().aBb()) {
            ag(z, z2);
        } else if (this.iNZ != null && this.iNZ.cmg() != null) {
            this.iNZ.cmg().b(this.iFb, z, z2);
        }
    }

    private void af(boolean z, boolean z2) {
        this.iNT.d(this.iFb, z, z2);
    }

    private void ag(boolean z, boolean z2) {
        this.iNS.c(this.iFb, z, z2);
    }
}
