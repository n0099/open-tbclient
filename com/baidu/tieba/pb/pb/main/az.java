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
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
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
/* loaded from: classes22.dex */
public class az {
    private EditorTools abk;
    private RelativeLayout bET;
    private View bEb;
    private View bFD;
    private f.c eVA;
    private com.baidu.tieba.pb.a.c fhK;
    private View fuw;
    private NoNetworkView ghD;
    private boolean iHd;
    private View.OnClickListener iKb;
    private PbListView iPm;
    private List<CustomBlueCheckRadioButton> iav;
    private boolean isLandscape;
    private TextView jKd;
    private NavigationBarCoverTip jku;
    private com.baidu.tieba.NEGFeedBack.e jnL;
    public int lAV;
    public final com.baidu.tieba.pb.pb.main.view.c lAX;
    public com.baidu.tieba.pb.pb.main.view.b lAY;
    private ViewStub lAZ;
    private View lBH;
    private View lBJ;
    private View lBK;
    private LinearLayout lBL;
    private HeadImageView lBM;
    private ImageView lBN;
    private ImageView lBO;
    private ImageView lBP;
    private com.baidu.tieba.pb.view.c lBQ;
    private TextView lBR;
    private TextView lBS;
    private int lBU;
    private int lBV;
    private PostData lBW;
    private ViewStub lBY;
    private PbInterviewStatusView lBZ;
    private ViewStub lBa;
    private PbLandscapeListView lBb;
    private PbThreadPostView lBc;
    private com.baidu.tieba.pb.pb.main.a.e lBd;
    private com.baidu.tieba.pb.pb.main.a.a lBe;
    private com.baidu.tieba.pb.pb.main.a.c lBf;
    private com.baidu.tieba.pb.pb.main.a.d lBg;
    private com.baidu.tieba.pb.pb.main.a.b lBh;
    private LinearLayout lBi;
    private TextView lBj;
    private TextView lBk;
    private ObservedChangeRelativeLayout lBl;
    private g lBm;
    private View lBs;
    private PbTopTipView lCA;
    private PopupWindow lCB;
    private TextView lCC;
    private List<String> lCD;
    private com.baidu.tieba.pb.pb.main.emotion.c lCE;
    private com.baidu.tieba.pb.pb.godreply.a lCF;
    private PbLandscapeListView.b lCG;
    private al lCI;
    private String lCJ;
    private long lCK;
    private int lCL;
    private boolean lCN;
    private Runnable lCR;
    private PbFragment.b lCT;
    public int lCX;
    private FrameLayout lCa;
    private View lCb;
    private View lCc;
    private au lCd;
    private PbEmotionBar lCi;
    private int lCq;
    private Runnable lCr;
    private v lCs;
    private av lCt;
    private int lCz;
    private PbFragment lpI;
    private View.OnClickListener lqF;
    private com.baidu.tieba.pb.data.f lqP;
    private PbFakeFloorModel ltg;
    PbFragment.c luW;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int lCe = UtilHelper.getLightStatusBarHeight();
    public static int lCk = 3;
    public static int lCl = 0;
    public static int lCm = 3;
    public static int lCn = 4;
    public static int lCo = 5;
    public static int lCp = 6;
    private static a.InterfaceC0851a lCM = new a.InterfaceC0851a() { // from class: com.baidu.tieba.pb.pb.main.az.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0851a
        public void onRefresh() {
        }
    };
    private int lAW = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a lBn = null;
    private com.baidu.tbadk.core.dialog.b iKa = null;
    private View lBo = null;
    private EditText lBp = null;
    private com.baidu.tieba.pb.view.d lBq = null;
    private com.baidu.tieba.pb.view.a lBr = null;
    private b.InterfaceC0576b kiN = null;
    private TbRichTextView.i fFW = null;
    private NoNetworkView.a iEz = null;
    private com.baidu.tbadk.core.dialog.i lBt = null;
    private com.baidu.tbadk.core.dialog.a lBu = null;
    private Dialog lBv = null;
    private Dialog lBw = null;
    private View lBx = null;
    private LinearLayout lBy = null;
    private CompoundButton.OnCheckedChangeListener iaw = null;
    private TextView lBz = null;
    private TextView lBA = null;
    private String lBB = null;
    private com.baidu.tbadk.core.dialog.i ltV = null;
    private com.baidu.tbadk.core.dialog.i lBC = null;
    private boolean lBD = false;
    private boolean lBE = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView lBF = null;
    private boolean lBG = false;
    private Button lBI = null;
    private boolean lBT = true;
    private com.baidu.tbadk.core.view.a iey = null;
    private boolean lqx = false;
    private int mSkinType = 3;
    private boolean lBX = false;
    private int lCf = 0;
    private boolean lCg = true;
    public a lCh = new a();
    private int lCj = 0;
    private boolean lCu = false;
    private int lCv = 0;
    private boolean lCw = false;
    private boolean lCx = false;
    private boolean lCy = false;
    private boolean lCH = false;
    private String lCO = null;
    private CustomMessageListener lCP = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.az.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                az.this.lCO = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.az.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && az.this.lBm != null) {
                az.this.lBm.notifyDataSetChanged();
            }
        }
    };
    private Handler lCQ = new Handler();
    private CustomMessageListener lCS = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.az.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                az.this.lBT = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean lCU = true;
    View.OnClickListener lCV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || az.this.lqP == null || az.this.lqP.dik() == null || az.this.lqP.dik().bmA() == null || az.this.lqP.dik().bmA().getAlaInfo() == null || az.this.lqP.dik().bmA().getAlaInfo().live_status != 1) {
                if (az.this.lCw) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11923").al("obj_id", 2));
                }
                if (!az.this.lCw && az.this.lqP != null && az.this.lqP.dik() != null && az.this.lqP.dik().bmA() != null && az.this.lqP.dik().bmA().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12151").al("obj_locate", 1));
                }
                if (az.this.lpI.dle() != null) {
                    az.this.lpI.dle().lpU.iqL.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c11851");
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
            if (az.this.lqP.dik().bmA().getAlaInfo() == null || !az.this.lqP.dik().bmA().getAlaInfo().isChushou) {
                if (az.this.lqP.dik().bmA().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = az.this.lqP.dik().bmA().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(az.this.lpI.dle(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.be.brr().b(az.this.lpI.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + az.this.lqP.dik().bmA().getAlaInfo().thirdRoomId + "&livetype=" + az.this.lqP.dik().bmA().getAlaInfo().thirdLiveType});
        }
    };
    private boolean bgD = false;
    String userId = null;
    private final List<TbImageView> lCW = new ArrayList();
    private boolean lCY = false;

    /* loaded from: classes22.dex */
    public static class a {
        public int headerCount;
        public au lDm;
        public int lgB;
    }

    public void uG(boolean z) {
        this.lCu = z;
        if (this.lBb != null) {
            this.lCv = this.lBb.getHeaderViewsCount();
        }
    }

    public void dng() {
        if (this.lBb != null) {
            int headerViewsCount = this.lBb.getHeaderViewsCount() - this.lCv;
            final int firstVisiblePosition = (this.lBb.getFirstVisiblePosition() == 0 || this.lBb.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.lBb.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.lBb.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.lCh.lDm = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lCh));
            final au auVar = this.lCh.lDm;
            final int g = g(auVar);
            final int y = ((int) this.lBl.getY()) + this.lBl.getMeasuredHeight();
            final boolean z = this.lCb.getVisibility() == 0;
            boolean z2 = this.lBl.getY() < 0.0f;
            if ((z && auVar != null) || firstVisiblePosition >= this.lBm.djX() + this.lBb.getHeaderViewsCount()) {
                int measuredHeight = auVar != null ? auVar.lAw.getMeasuredHeight() : 0;
                if (z2) {
                    this.lBb.setSelectionFromTop(this.lBm.djX() + this.lBb.getHeaderViewsCount(), lCe - measuredHeight);
                } else {
                    this.lBb.setSelectionFromTop(this.lBm.djX() + this.lBb.getHeaderViewsCount(), this.lAX.dpf().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.lBb.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.lCw && this.lBd != null) {
                this.lBb.setSelectionFromTop(this.lBm.djX() + this.lBb.getHeaderViewsCount(), this.lBd.doR());
            } else if (this.mType == 6) {
                this.lBb.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.az.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void onLayout() {
                        ViewGroup.LayoutParams layoutParams;
                        if (g >= 0 && g <= az.this.bET.getMeasuredHeight()) {
                            int g2 = az.this.g(auVar);
                            int i = g2 - g;
                            if (z && i != 0 && g <= y) {
                                i = g2 - y;
                            }
                            if (az.this.bFD != null && (layoutParams = az.this.bFD.getLayoutParams()) != null) {
                                if (i == 0 || i > az.this.bET.getMeasuredHeight() || g2 >= az.this.bET.getMeasuredHeight()) {
                                    layoutParams.height = az.this.lCq;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > az.this.bET.getMeasuredHeight()) {
                                    layoutParams.height = az.this.lCq;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    az.this.lBb.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                az.this.bFD.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (az.this.bFD != null && az.this.bFD.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = az.this.bFD.getLayoutParams();
                                            layoutParams2.height = az.this.lCq;
                                            az.this.bFD.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        az.this.lBb.setOnLayoutListener(null);
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

    public NoNetworkView dnh() {
        return this.ghD;
    }

    public void dni() {
        if (this.abk != null) {
            this.abk.hide();
            if (this.lCE != null) {
                this.lCE.doT();
            }
        }
    }

    public PbFakeFloorModel dnj() {
        return this.ltg;
    }

    public v dnk() {
        return this.lCs;
    }

    public com.baidu.tieba.pb.pb.main.a.e dnl() {
        return this.lBd;
    }

    public void dnm() {
        reset();
        dni();
        this.lCs.dkf();
        uS(false);
    }

    private void reset() {
        if (this.lpI != null && this.lpI.dkk() != null && this.abk != null) {
            com.baidu.tbadk.editortools.pb.a.bAa().setStatus(0);
            com.baidu.tbadk.editortools.pb.e dkk = this.lpI.dkk();
            dkk.bAv();
            dkk.bzK();
            if (dkk.getWriteImagesInfo() != null) {
                dkk.getWriteImagesInfo().setMaxImagesAllowed(dkk.isBJH ? 1 : 9);
            }
            dkk.ru(SendView.ALL);
            dkk.rv(SendView.ALL);
            com.baidu.tbadk.editortools.h rh = this.abk.rh(23);
            com.baidu.tbadk.editortools.h rh2 = this.abk.rh(2);
            com.baidu.tbadk.editortools.h rh3 = this.abk.rh(5);
            if (rh2 != null) {
                rh2.display();
            }
            if (rh3 != null) {
                rh3.display();
            }
            if (rh != null) {
                rh.hide();
            }
            this.abk.invalidate();
        }
    }

    public boolean dnn() {
        return this.lBT;
    }

    public void uH(boolean z) {
        if (this.lBK != null && this.jKd != null) {
            this.jKd.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lBK.startAnimation(alphaAnimation);
            }
            this.lBJ.setVisibility(0);
            this.lBK.setVisibility(0);
            this.lBT = true;
            if (this.lCi != null && !this.lCF.isActive()) {
                this.lCi.setVisibility(0);
                uM(true);
            }
        }
    }

    public void uI(boolean z) {
        if (this.lBK != null && this.jKd != null) {
            this.jKd.setText(dno());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lBK.startAnimation(alphaAnimation);
            }
            this.lBJ.setVisibility(0);
            this.lBK.setVisibility(0);
            this.lBT = true;
            if (this.lCi != null && !this.lCF.isActive()) {
                this.lCi.setVisibility(0);
                uM(true);
            }
        }
    }

    public String dno() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.lCJ)) {
            return this.lCJ;
        }
        if (this.lpI != null) {
            this.lCJ = TbadkCoreApplication.getInst().getResources().getString(ay.dnd());
        }
        return this.lCJ;
    }

    public PostData dnp() {
        int i = 0;
        if (this.lBb == null) {
            return null;
        }
        int dnq = dnq() - this.lBb.getHeaderViewsCount();
        if (dnq < 0) {
            dnq = 0;
        }
        if (this.lBm.FI(dnq) != null && this.lBm.FI(dnq) != PostData.mWQ) {
            i = dnq + 1;
        }
        return this.lBm.getItem(i) instanceof PostData ? (PostData) this.lBm.getItem(i) : null;
    }

    public int dnq() {
        int i;
        View childAt;
        if (this.lBb == null) {
            return 0;
        }
        int firstVisiblePosition = this.lBb.getFirstVisiblePosition();
        int lastVisiblePosition = this.lBb.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.lBb.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.lBb.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int dnr() {
        return this.lBb.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.lqP != null && this.lqP.dim() != null && !this.lqP.dim().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.lqP.dim().size() && (postData = this.lqP.dim().get(i)) != null && postData.bmA() != null && !StringUtils.isNull(postData.bmA().getUserId()); i++) {
                if (this.lqP.dim().get(i).bmA().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.lCF != null && this.lCF.isActive()) {
                        uS(false);
                    }
                    if (this.lCi != null) {
                        this.lCi.vc(true);
                    }
                    this.lCO = postData.bmA().getName_show();
                    return;
                }
            }
        }
    }

    public az(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.lpI = null;
        this.bET = null;
        this.bEb = null;
        this.lBb = null;
        this.lBm = null;
        this.iPm = null;
        this.fuw = null;
        this.iKb = null;
        this.lqF = null;
        this.lBK = null;
        this.jKd = null;
        this.lBY = null;
        this.lCz = 0;
        this.lCK = 0L;
        this.lCK = System.currentTimeMillis();
        this.lpI = pbFragment;
        this.iKb = onClickListener;
        this.fhK = cVar;
        this.lCz = com.baidu.adp.lib.util.l.getEquipmentWidth(this.lpI.getContext()) / 8;
        this.bET = (RelativeLayout) LayoutInflater.from(this.lpI.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bET.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.lBH = this.bET.findViewById(R.id.bottom_shadow);
        this.jku = (NavigationBarCoverTip) this.bET.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.bEb = this.bET.findViewById(R.id.statebar_view);
        this.lBl = (ObservedChangeRelativeLayout) this.bET.findViewById(R.id.title_wrapper);
        this.ghD = (NoNetworkView) this.bET.findViewById(R.id.view_no_network);
        this.lBb = (PbLandscapeListView) this.bET.findViewById(R.id.new_pb_list);
        this.lCa = (FrameLayout) this.bET.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.lpI.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.lpI.getActivity(), R.dimen.ds88));
        this.lBb.addHeaderView(this.textView, 0);
        this.lBb.setTextViewAdded(true);
        this.lCq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bFD = new View(this.lpI.getPageContext().getPageActivity());
        this.bFD.setLayoutParams(new AbsListView.LayoutParams(-1, this.lCq));
        this.bFD.setVisibility(4);
        this.lBb.addFooterView(this.bFD);
        this.lBb.setOnTouchListener(this.lpI.fzb);
        this.lAX = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bET);
        if (this.lpI.dkN()) {
            this.lAZ = (ViewStub) this.bET.findViewById(R.id.manga_view_stub);
            this.lAZ.setVisibility(0);
            this.lAY = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.lAY.show();
            this.lAX.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lpI.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.lAX.dpf().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0806a() { // from class: com.baidu.tieba.pb.pb.main.az.26
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0806a
            public void djk() {
                if (az.this.lBb != null) {
                    if (az.this.lBd != null) {
                        az.this.lBd.doQ();
                    }
                    az.this.lBb.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0806a
            public void djl() {
                az.this.lpI.cyL();
            }
        }));
        this.lBJ = this.bET.findViewById(R.id.view_comment_top_line);
        this.lBK = this.bET.findViewById(R.id.pb_editor_tool_comment);
        this.lBU = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lBV = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lBM = (HeadImageView) this.bET.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lBM.setVisibility(0);
        this.lBM.setIsRound(true);
        this.lBM.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.lpI.getContext(), R.dimen.tbds1));
        this.lBM.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_border_a));
        this.lBM.setPlaceHolder(1);
        this.lBM.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lBM.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        this.jKd = (TextView) this.bET.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lBL = (LinearLayout) this.bET.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lBL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.lpI.dkv();
                if (az.this.lpI != null && az.this.lpI.djz() != null && az.this.lpI.djz().getPbData() != null && az.this.lpI.djz().getPbData().dik() != null && az.this.lpI.djz().getPbData().dik().bmA() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13701").dR("tid", az.this.lpI.djz().dly()).dR("fid", az.this.lpI.djz().getPbData().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13402").dR("tid", az.this.lpI.djz().lxd).dR("fid", az.this.lpI.djz().getPbData().getForumId()).al("obj_locate", 1).dR("uid", az.this.lpI.djz().getPbData().dik().bmA().getUserId()));
                }
            }
        });
        this.lBN = (ImageView) this.bET.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lBN.setOnClickListener(this.iKb);
        boolean booleanExtra = this.lpI.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lBO = (ImageView) this.bET.findViewById(R.id.pb_editor_tool_collection);
        this.lBO.setOnClickListener(this.iKb);
        if (booleanExtra) {
            this.lBO.setVisibility(8);
        } else {
            this.lBO.setVisibility(0);
        }
        this.lBP = (ImageView) this.bET.findViewById(R.id.pb_editor_tool_share);
        this.lBP.setOnClickListener(this.iKb);
        this.lBQ = new com.baidu.tieba.pb.view.c(this.lBP);
        this.lBQ.dsx();
        this.lBR = (TextView) this.bET.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lBR.setVisibility(0);
        this.lBY = (ViewStub) this.bET.findViewById(R.id.interview_status_stub);
        this.lBe = new com.baidu.tieba.pb.pb.main.a.a(this.lpI, cVar);
        this.lBg = new com.baidu.tieba.pb.pb.main.a.d(this.lpI, cVar, this.iKb);
        this.lBm = new g(this.lpI, this.lBb);
        this.lBm.G(this.iKb);
        this.lBm.setTbGestureDetector(this.fhK);
        this.lBm.setOnImageClickListener(this.fFW);
        this.lBm.setOnSwitchChangeListener(this.lpI.luP);
        this.lqF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.28
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
                            az.this.lpI.c(sparseArray);
                            return;
                        }
                        az.this.dp(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        az.this.lpI.c(sparseArray);
                    } else if (booleanValue3) {
                        az.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.lBm.T(this.lqF);
        dnx();
        dny();
        this.lBg.b(this.lBb);
        this.lBf.b(this.lBb);
        this.lBe.b(this.lBb);
        this.iPm = new PbListView(this.lpI.getPageContext().getPageActivity());
        this.fuw = this.iPm.getView().findViewById(R.id.pb_more_view);
        if (this.fuw != null) {
            this.fuw.setOnClickListener(this.iKb);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.fuw, R.drawable.pb_foot_more_trans_selector);
        }
        this.iPm.setLineVisible();
        this.iPm.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.iPm.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.lBs = this.bET.findViewById(R.id.viewstub_progress);
        this.lpI.registerListener(this.lCS);
        this.ltg = new PbFakeFloorModel(this.lpI.getPageContext());
        this.lCs = new v(this.lpI.getPageContext(), this.ltg, this.bET);
        this.lCs.U(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.dnm();
            }
        });
        this.lCs.a(this.lpI.luR);
        this.ltg.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.az.30
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                az.this.ltg.t(postData);
                az.this.lBm.notifyDataSetChanged();
                az.this.lCs.dkf();
                az.this.abk.bxU();
                az.this.uS(false);
            }
        });
        if (this.lpI.djz() != null && !StringUtils.isNull(this.lpI.djz().dmg())) {
            this.lpI.showToast(this.lpI.djz().dmg());
        }
        this.lCb = this.bET.findViewById(R.id.pb_expand_blank_view);
        this.lCc = this.bET.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lCc.getLayoutParams();
        if (this.lpI.djz() != null && this.lpI.djz().dlB()) {
            this.lCb.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.lCc.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = lCe;
            this.lCc.setLayoutParams(layoutParams2);
        }
        this.lCd = new au(this.lpI.getPageContext(), this.bET.findViewById(R.id.pb_reply_expand_view));
        this.lCd.v(pbFragment.ltL);
        this.lCd.lAw.setVisibility(8);
        this.lCd.V(this.iKb);
        this.lCd.setOnSwitchChangeListener(this.lpI.luP);
        this.lpI.registerListener(this.mAccountChangedListener);
        this.lpI.registerListener(this.lCP);
        dnt();
        uM(false);
    }

    public void uJ(boolean z) {
        this.lBH.setVisibility(z ? 0 : 8);
    }

    public void cMc() {
        if (!this.lpI.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10517").al("obj_locate", 2).dR("fid", this.mForumId));
        } else if (this.lpI.dkx()) {
            com.baidu.tbadk.editortools.pb.e dkk = this.lpI.dkk();
            if (dkk != null && (dkk.bAs() || dkk.bAt())) {
                this.lpI.dkk().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.abk != null) {
                dnD();
            }
            if (this.abk != null) {
                this.lBT = false;
                if (this.abk.rk(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.lpI.getPageContext(), (View) this.abk.rk(2).fnp, false, lCM);
                }
            }
            dol();
        }
    }

    private void dnt() {
        this.lCF = new com.baidu.tieba.pb.pb.godreply.a(this.lpI, this, (ViewStub) this.bET.findViewById(R.id.more_god_reply_popup));
        this.lCF.B(this.iKb);
        this.lCF.T(this.lqF);
        this.lCF.setOnImageClickListener(this.fFW);
        this.lCF.B(this.iKb);
        this.lCF.setTbGestureDetector(this.fhK);
    }

    public com.baidu.tieba.pb.pb.godreply.a dnu() {
        return this.lCF;
    }

    public View dnv() {
        return this.lCb;
    }

    public void dnw() {
        if (this.lBb != null) {
            this.lBf.c(this.lBb);
            this.lBg.c(this.lBb);
            this.lBh.c(this.lBb);
            this.lBe.c(this.lBb);
        }
    }

    private void dnx() {
        if (this.lBh == null) {
            this.lBh = new com.baidu.tieba.pb.pb.main.a.b(this.lpI, this.iKb);
        }
    }

    private void dny() {
        if (this.lBf == null) {
            this.lBf = new com.baidu.tieba.pb.pb.main.a.c(this.lpI, this.fhK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnz() {
        if (this.lpI.dkN()) {
            this.lBa = (ViewStub) this.bET.findViewById(R.id.manga_mention_controller_view_stub);
            this.lBa.setVisibility(0);
            if (this.lBi == null) {
                this.lBi = (LinearLayout) this.bET.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.lpI.getPageContext(), this.lBi);
            }
            if (this.lBj == null) {
                this.lBj = (TextView) this.lBi.findViewById(R.id.manga_prev_btn);
            }
            if (this.lBk == null) {
                this.lBk = (TextView) this.lBi.findViewById(R.id.manga_next_btn);
            }
            this.lBj.setOnClickListener(this.iKb);
            this.lBk.setOnClickListener(this.iKb);
        }
    }

    private void dnA() {
        if (this.lpI.dkN()) {
            if (this.lpI.dkQ() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lBj, R.color.cp_cont_e, 1);
            }
            if (this.lpI.dkR() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lBk, R.color.cp_cont_e, 1);
            }
        }
    }

    public void dnB() {
        if (this.lBi == null) {
            dnz();
        }
        this.lBa.setVisibility(8);
        if (this.lCQ != null && this.lCR != null) {
            this.lCQ.removeCallbacks(this.lCR);
        }
    }

    public void dnC() {
        if (this.lCQ != null) {
            if (this.lCR != null) {
                this.lCQ.removeCallbacks(this.lCR);
            }
            this.lCR = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.3
                @Override // java.lang.Runnable
                public void run() {
                    if (az.this.lBi == null) {
                        az.this.dnz();
                    }
                    az.this.lBa.setVisibility(0);
                }
            };
            this.lCQ.postDelayed(this.lCR, 2000L);
        }
    }

    public void uK(boolean z) {
        this.lAX.uK(z);
        if (z && this.lBX) {
            this.iPm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.lBb.setNextPage(this.iPm);
            this.lAW = 2;
        }
        if (this.lBM != null) {
            this.lBM.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.abk = editorTools;
        this.abk.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.dnm();
            }
        });
        this.abk.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.abk.getParent() == null) {
            this.bET.addView(this.abk, layoutParams);
        }
        this.abk.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.abk.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.az.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                    if (((com.baidu.tbadk.coreExtra.data.u) aVar.data).buM() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.u) aVar.data).buM() == EmotionGroupType.USER_COLLECT) {
                        if (az.this.mPermissionJudgePolicy == null) {
                            az.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        az.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        az.this.mPermissionJudgePolicy.appendRequestPermission(az.this.lpI.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!az.this.mPermissionJudgePolicy.startRequestPermission(az.this.lpI.getBaseFragmentActivity())) {
                            az.this.lpI.dkk().c((com.baidu.tbadk.coreExtra.data.u) aVar.data);
                            az.this.lpI.dkk().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dni();
        this.lpI.dkk().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.az.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (az.this.abk != null && az.this.abk.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (az.this.lCE == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, az.this.abk.getId());
                            az.this.lCE = new com.baidu.tieba.pb.pb.main.emotion.c(az.this.lpI.getPageContext(), az.this.bET, layoutParams2);
                            if (!com.baidu.tbadk.core.util.y.isEmpty(az.this.lCD)) {
                                az.this.lCE.setData(az.this.lCD);
                            }
                            az.this.lCE.c(az.this.abk);
                        }
                        az.this.lCE.PV(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (az.this.lpI.kzD != null && az.this.lpI.kzD.doC() != null) {
                    if (!az.this.lpI.kzD.doC().dSW()) {
                        az.this.lpI.kzD.uY(false);
                    }
                    az.this.lpI.kzD.doC().yq(false);
                }
            }
        });
    }

    public void dnD() {
        if (this.lpI != null && this.abk != null) {
            this.abk.display();
            if (this.lpI.dkk() != null) {
                this.lpI.dkk().bAi();
            }
            dol();
        }
    }

    public void uL(boolean z) {
        if (this.lBb != null && this.textView != null && this.bEb != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bEb.setVisibility(0);
                } else {
                    this.bEb.setVisibility(8);
                    this.lBb.removeHeaderView(this.textView);
                    this.lBb.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = lCe;
                    this.textView.setLayoutParams(layoutParams);
                }
                dnR();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + uU(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            dnR();
            dot();
        }
    }

    public g dnE() {
        return this.lBm;
    }

    public void a(PbFragment.c cVar) {
        this.luW = cVar;
    }

    public void dp(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lpI.getContext());
        kVar.setTitleText(this.lpI.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.lBt.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            az.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (az.this.lCT != null) {
                                az.this.lCT.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            az.this.lpI.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.lpI.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.lpI.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !dos()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.lpI.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.lpI.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.lpI.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.br(arrayList);
        this.lBt = new com.baidu.tbadk.core.dialog.i(this.lpI.getPageContext(), kVar);
        this.lBt.Qj();
    }

    public void a(PbFragment.b bVar) {
        this.lCT = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.lpI != null && aVar != null) {
            if (this.jnL == null && this.lBe != null) {
                this.jnL = new com.baidu.tieba.NEGFeedBack.e(this.lpI.getPageContext(), this.lBe.doM());
            }
            AntiData cxn = this.lpI.cxn();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cxn != null && cxn.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cxn.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.ar arVar = new com.baidu.tbadk.core.data.ar();
            arVar.setFeedBackReasonMap(sparseArray);
            this.jnL.setDefaultReasonArray(new String[]{this.lpI.getString(R.string.delete_thread_reason_1), this.lpI.getString(R.string.delete_thread_reason_2), this.lpI.getString(R.string.delete_thread_reason_3), this.lpI.getString(R.string.delete_thread_reason_4), this.lpI.getString(R.string.delete_thread_reason_5)});
            this.jnL.setData(arVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jnL.EU(str);
            this.jnL.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.az.9
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    az.this.lpI.a(aVar, jSONArray);
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
        sparseArray.put(lCl, Integer.valueOf(lCm));
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
        this.lBu = new com.baidu.tbadk.core.dialog.a(this.lpI.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lBu.ow(i3);
        } else {
            this.lBu.setOnlyMessageShowCenter(false);
            this.lBu.Bo(str2);
        }
        this.lBu.setYesButtonTag(sparseArray);
        this.lBu.a(R.string.dialog_ok, this.lpI);
        this.lBu.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lBu.iV(true);
        this.lBu.b(this.lpI.getPageContext());
        if (z) {
            this.lBu.bpc();
        } else {
            a(this.lBu, i);
        }
    }

    public void bc(ArrayList<com.baidu.tbadk.core.data.aj> arrayList) {
        if (this.lBx == null) {
            this.lBx = LayoutInflater.from(this.lpI.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.lpI.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lBx);
        if (this.lBw == null) {
            this.lBw = new Dialog(this.lpI.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lBw.setCanceledOnTouchOutside(true);
            this.lBw.setCancelable(true);
            this.lBF = (ScrollView) this.lBx.findViewById(R.id.good_scroll);
            this.lBw.setContentView(this.lBx);
            WindowManager.LayoutParams attributes = this.lBw.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lBw.getWindow().setAttributes(attributes);
            this.iaw = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.az.12
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        az.this.lBB = (String) compoundButton.getTag();
                        if (az.this.iav != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : az.this.iav) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && az.this.lBB != null && !str.equals(az.this.lBB)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lBy = (LinearLayout) this.lBx.findViewById(R.id.good_class_group);
            this.lBA = (TextView) this.lBx.findViewById(R.id.dialog_button_cancel);
            this.lBA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (az.this.lBw instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(az.this.lBw, az.this.lpI.getPageContext());
                    }
                }
            });
            this.lBz = (TextView) this.lBx.findViewById(R.id.dialog_button_ok);
            this.lBz.setOnClickListener(this.iKb);
        }
        this.lBy.removeAllViews();
        this.iav = new ArrayList();
        CustomBlueCheckRadioButton fT = fT("0", this.lpI.getPageContext().getString(R.string.thread_good_class));
        this.iav.add(fT);
        fT.setChecked(true);
        this.lBy.addView(fT);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aj ajVar = arrayList.get(i2);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bkO()) && ajVar.bkP() > 0) {
                    CustomBlueCheckRadioButton fT2 = fT(String.valueOf(ajVar.bkP()), ajVar.bkO());
                    this.iav.add(fT2);
                    View view = new View(this.lpI.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.lBy.addView(view);
                    this.lBy.addView(fT2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lBF.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lpI.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lpI.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lpI.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lBF.setLayoutParams(layoutParams2);
            this.lBF.removeAllViews();
            if (this.lBy != null && this.lBy.getParent() == null) {
                this.lBF.addView(this.lBy);
            }
        }
        com.baidu.adp.lib.f.g.a(this.lBw, this.lpI.getPageContext());
    }

    private CustomBlueCheckRadioButton fT(String str, String str2) {
        Activity pageActivity = this.lpI.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.iaw);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void dnF() {
        this.lpI.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.lpI.hideProgressBar();
        if (z && z2) {
            this.lpI.showToast(this.lpI.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.lpI.showToast(str);
        }
    }

    public void cTu() {
        this.lBs.setVisibility(0);
    }

    public void cTt() {
        this.lBs.setVisibility(8);
    }

    public View dnG() {
        if (this.lBx != null) {
            return this.lBx.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String dnH() {
        return this.lBB;
    }

    public View getView() {
        return this.bET;
    }

    public void dnI() {
        if (this.lpI != null && this.lpI.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lpI.getPageContext().getPageActivity(), this.lpI.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.lpI.hideProgressBar();
        if (z) {
            dob();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            doc();
        } else {
            dob();
        }
    }

    public void dnJ() {
        this.iPm.setLineVisible();
        this.iPm.startLoadData();
    }

    public void dnK() {
        this.lpI.hideProgressBar();
        endLoadData();
        this.lBb.completePullRefreshPostDelayed(0L);
        dnW();
    }

    public void dnL() {
        this.lBb.completePullRefreshPostDelayed(0L);
        dnW();
    }

    private void uM(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.lBg.b(onLongClickListener);
        this.lBm.setOnLongClickListener(onLongClickListener);
        if (this.lCF != null) {
            this.lCF.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0576b interfaceC0576b, boolean z, boolean z2) {
        if (this.ltV != null) {
            this.ltV.dismiss();
            this.ltV = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lpI.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lpI.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lpI.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lpI.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lpI.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.br(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.lBC.dismiss();
                interfaceC0576b.a(null, i, view);
            }
        });
        this.lBC = new com.baidu.tbadk.core.dialog.i(this.lpI.getPageContext(), kVar);
        this.lBC.Qj();
    }

    public void a(final b.InterfaceC0576b interfaceC0576b, boolean z) {
        if (this.lBC != null) {
            this.lBC.dismiss();
            this.lBC = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lpI.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.lqP != null && this.lqP.dik() != null && !this.lqP.dik().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lpI.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lpI.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.br(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.lBC.dismiss();
                interfaceC0576b.a(null, i, view);
            }
        });
        this.lBC = new com.baidu.tbadk.core.dialog.i(this.lpI.getPageContext(), kVar);
        this.lBC.Qj();
    }

    public int dnM() {
        return Gh(this.lBb.getFirstVisiblePosition());
    }

    private int Gh(int i) {
        com.baidu.adp.widget.ListView.f adapter = this.lBb.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.lBb.getAdapter() == null || !(this.lBb.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) ? 0 : this.lBb.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int dnN() {
        int lastVisiblePosition = this.lBb.getLastVisiblePosition();
        if (this.lBd != null) {
            if (lastVisiblePosition == this.lBb.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return Gh(lastVisiblePosition);
    }

    public void Gi(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.lBb != null) {
            if (this.lAX == null || this.lAX.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.lAX.mNavigationBar.getFixedNavHeight();
                if (this.lpI.dkD() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.lCc != null && (layoutParams = (LinearLayout.LayoutParams) this.lCc.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.lCc.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.lBb.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.lBb.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.lBb.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.lBp.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.lBm.a(fVar, false);
        this.lBm.notifyDataSetChanged();
        dnW();
        if (this.lCF != null) {
            this.lCF.bMD();
        }
        ArrayList<PostData> dim = fVar.dim();
        if (fVar.getPage().blq() == 0 || dim == null || dim.size() < fVar.getPage().blp()) {
            if (com.baidu.tbadk.core.util.y.getCount(dim) == 0 || (com.baidu.tbadk.core.util.y.getCount(dim) == 1 && dim.get(0) != null && dim.get(0).dJZ() == 1)) {
                if (this.lCh == null || this.lCh.lDm == null || this.lCh.lDm.getView() == null) {
                    i = 0;
                } else {
                    i = this.lCh.lDm.getView().getTop() < 0 ? this.lCh.lDm.getView().getHeight() : this.lCh.lDm.getView().getBottom();
                }
                if (this.lpI.dkX()) {
                    this.iPm.ap(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.iPm.ap(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().blq() == 0) {
                    this.iPm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.iPm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.iPm.bsu();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.lBe != null) {
            this.lBe.e(fVar, this.lqx);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dix() != null) {
            return fVar.dix();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dim())) {
            Iterator<PostData> it = fVar.dim().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dJZ() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dit();
        }
        if (!r(postData)) {
            postData = a(fVar);
        }
        if (postData != null && postData.bmA() != null && postData.bmA().getUserTbVipInfoData() != null && postData.bmA().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bmA().getGodUserData().setIntro(postData.bmA().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean r(PostData postData) {
        if (postData == null || postData.bmA() == null) {
            return false;
        }
        MetaData bmA = postData.bmA();
        return (TextUtils.isEmpty(bmA.getUserId()) && TextUtils.isEmpty(bmA.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dik() == null || fVar.dik().bmA() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bmA = fVar.dik().bmA();
        String userId = bmA.getUserId();
        HashMap<String, MetaData> userMap = fVar.dik().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bmA;
        }
        postData.JD(1);
        postData.setId(fVar.dik().bmR());
        postData.setTitle(fVar.dik().getTitle());
        postData.setTime(fVar.dik().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.dik() != null) {
            if (this.lpI.djq()) {
                if (fVar.dij() != null) {
                    this.mForumName = fVar.dij().getForumName();
                    this.mForumId = fVar.dij().getForumId();
                }
                if (this.mForumName == null && this.lpI.djz() != null && this.lpI.djz().djr() != null) {
                    this.mForumName = this.lpI.djz().djr();
                }
            }
            PostData b = b(fVar, z);
            a(b, fVar);
            this.lBg.setVisibility(8);
            if (fVar.diK()) {
                this.lCw = true;
                this.lAX.vj(true);
                this.lAX.mNavigationBar.hideBottomLine();
                if (this.lBd == null) {
                    this.lBd = new com.baidu.tieba.pb.pb.main.a.e(this.lpI);
                }
                this.lBd.a(fVar, b, this.lBb, this.lBg, this.lCa, this.lAX, this.mForumName, this.lCK);
                this.lBd.W(this.lCV);
                dnR();
            } else {
                this.lCw = false;
                this.lAX.vj(this.lCw);
                if (this.lBd != null) {
                    this.lBd.c(this.lBb);
                }
            }
            if (this.lpI.dkn() != null) {
                this.lpI.dkn().vd(this.lCw);
            }
            if (b != null) {
                this.lBW = b;
                this.lBg.setVisibility(0);
                SparseArray<Object> doP = this.lBg.doP();
                doP.put(R.id.tag_clip_board, b);
                doP.put(R.id.tag_is_subpb, false);
                this.lBh.a(fVar, this.lBb);
                this.lBf.A(fVar);
                this.lBe.e(fVar, this.lqx);
                this.lBe.z(fVar);
                this.lBg.a(this.mSkinType, this.lqP, b, this.lCV);
                if (this.lCd != null) {
                    if (fVar.diN()) {
                        this.lCd.getView().setVisibility(8);
                    } else {
                        this.lCd.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lol);
                        if (fVar.dik() != null) {
                            nVar.loo = fVar.dik().bmr();
                        }
                        nVar.isNew = !this.lqx;
                        nVar.sortType = fVar.lmU;
                        nVar.loq = fVar.diO();
                        nVar.lor = this.lpI.dkX();
                        nVar.los = fVar.lmT;
                        this.lCd.a(nVar);
                    }
                }
                if (fVar != null && fVar.dik() != null) {
                    at(fVar.dik().bmw() == 1, fVar.dik().bmv() == 1);
                }
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.17
                    @Override // java.lang.Runnable
                    public void run() {
                        if (az.this.lBm != null && az.this.lAX != null && az.this.lAX.lHp != null && az.this.lqP != null && az.this.lqP.dik() != null && !az.this.lqP.dik().blg() && !az.this.dnV() && az.this.lqP.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(az.this.lqP.getForum().getName())) {
                            if ((az.this.lBm.dkb() == null || !az.this.lBm.dkb().isShown()) && az.this.lAX.lHp != null) {
                                az.this.lAX.lHp.setVisibility(0);
                                if (az.this.lpI != null && az.this.lpI.djz() != null) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13400");
                                    aqVar.dR("tid", az.this.lpI.djz().dlx());
                                    aqVar.dR("fid", az.this.lpI.djz().getForumId());
                                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void uN(boolean z) {
        if (z) {
            dnO();
        } else {
            csl();
        }
        this.lCh.lDm = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lCh));
        a(this.lCh.lDm, false);
    }

    public void dnO() {
        if (this.lAX != null && !this.lCy) {
            this.lAX.dnO();
            this.lCy = true;
        }
    }

    public void csl() {
        if (this.lAX != null) {
            this.lAX.dpn();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.lBg.a(postData, fVar);
    }

    public void dnP() {
        if (this.lBd != null) {
            this.lBd.d(this.lBb);
        }
    }

    public boolean dnQ() {
        return this.bgD;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aK(bw bwVar) {
        if (bwVar == null || bwVar.bmA() == null) {
            return false;
        }
        PostData b = b(this.lqP, false);
        String str = "";
        if (b != null && b.bmA() != null) {
            str = b.bmA().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.lAX.dpl();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.lAX.NF(dVar.forumName);
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
            final String str2 = dVar.lmL;
            this.lpI.showNetRefreshView(this.bET, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        com.baidu.tbadk.core.util.be.brr().b(az.this.lpI.getPageContext(), new String[]{str2});
                        az.this.lpI.finish();
                        return;
                    }
                    az.this.lpI.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable dmT;
        Parcelable dmT2;
        if (fVar != null && this.lBb != null) {
            this.lqP = fVar;
            this.mType = i;
            if (fVar.dik() != null) {
                this.lCj = fVar.dik().bmh();
                if (fVar.dik().getAnchorLevel() != 0) {
                    this.bgD = true;
                }
                this.lBE = aK(fVar.dik());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.lBX = false;
            this.lqx = z;
            dnK();
            if (fVar.lmV != null && fVar.lmV.diT()) {
                if (this.lBc == null) {
                    this.lBc = new PbThreadPostView(this.lpI.getContext());
                    this.lBb.addHeaderView(this.lBc, 1);
                    this.lBc.setData(fVar);
                    this.lBc.setChildOnClickLinstener(this.iKb);
                }
            } else if (this.lBc != null && this.lBb != null) {
                this.lBb.removeHeaderView(this.lBc);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.lCI == null) {
                this.lCI = new al(this.lpI.getPageContext(), this.jku);
            }
            this.lCI.PL(fVar.dir());
            if (this.lpI.dkN()) {
                if (this.lBq == null) {
                    this.lBq = new com.baidu.tieba.pb.view.d(this.lpI.getPageContext());
                    this.lBq.createView();
                    this.lBq.setListPullRefreshListener(this.eVA);
                }
                this.lBb.setPullRefresh(this.lBq);
                dnR();
                if (this.lBq != null) {
                    this.lBq.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().blr() == 0 && z) {
                this.lBb.setPullRefresh(null);
            } else {
                if (this.lBq == null) {
                    this.lBq = new com.baidu.tieba.pb.view.d(this.lpI.getPageContext());
                    this.lBq.createView();
                    this.lBq.setListPullRefreshListener(this.eVA);
                }
                this.lBb.setPullRefresh(this.lBq);
                dnR();
                if (this.lBq != null) {
                    this.lBq.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                chg();
            }
            dnW();
            this.lBm.tU(this.lqx);
            this.lBm.tV(false);
            this.lBm.tZ(i == 5);
            this.lBm.ua(i == 6);
            this.lBm.ub(z2 && this.lCU && i != 2);
            this.lBm.a(fVar, false);
            this.lBm.notifyDataSetChanged();
            this.lBg.b(b(fVar, z), fVar.diN());
            if (fVar.dik() != null && fVar.dik().bml() != null && this.lAV != -1) {
                fVar.dik().bml().setIsLike(this.lAV);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.lBb.setNextPage(this.iPm);
                this.lAW = 2;
                chg();
            } else {
                this.lBX = true;
                if (fVar.getPage().blq() == 1) {
                    if (this.lBr == null) {
                        this.lBr = new com.baidu.tieba.pb.view.a(this.lpI, this.lpI);
                    }
                    this.lBb.setNextPage(this.lBr);
                } else {
                    this.lBb.setNextPage(this.iPm);
                }
                this.lAW = 3;
            }
            ArrayList<PostData> dim = fVar.dim();
            if (fVar.getPage().blq() == 0 || dim == null || dim.size() < fVar.getPage().blp()) {
                if (com.baidu.tbadk.core.util.y.getCount(dim) == 0 || (com.baidu.tbadk.core.util.y.getCount(dim) == 1 && dim.get(0) != null && dim.get(0).dJZ() == 1)) {
                    if (this.lCh == null || this.lCh.lDm == null || this.lCh.lDm.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.lCh.lDm.getView().getTop() < 0 ? this.lCh.lDm.getView().getHeight() : this.lCh.lDm.getView().getBottom();
                    }
                    if (this.lpI.dkX()) {
                        this.iPm.ap(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.iPm.ap(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.lpI.dkn() != null && !this.lpI.dkn().doZ()) {
                        this.lpI.dkn().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().blq() == 0) {
                        this.iPm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.iPm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.iPm.bsu();
                }
                if (fVar.getPage().blq() == 0 || dim == null) {
                    dog();
                }
            } else {
                if (z2) {
                    if (this.lCU) {
                        endLoadData();
                        if (fVar.getPage().blq() != 0) {
                            this.iPm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.iPm.setLineVisible();
                        this.iPm.showLoading();
                    }
                } else {
                    this.iPm.setLineVisible();
                    this.iPm.showLoading();
                }
                this.iPm.bsu();
            }
            switch (i) {
                case 2:
                    this.lBb.setSelection(i2 > 1 ? (((this.lBb.getData() == null && fVar.dim() == null) ? 0 : (this.lBb.getData().size() - fVar.dim().size()) + this.lBb.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (dmT2 = as.dmS().dmT()) != null && !(dmT2 instanceof RecyclerView.SavedState)) {
                        this.lBb.onRestoreInstanceState(dmT2);
                        if (com.baidu.tbadk.core.util.y.getCount(dim) > 1 && fVar.getPage().blq() > 0) {
                            this.iPm.endLoadData();
                            this.iPm.setText(this.lpI.getString(R.string.pb_load_more_without_point));
                            this.iPm.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.lCU = false;
                    break;
                case 5:
                    this.lBb.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (dmT = as.dmS().dmT()) != null && !(dmT instanceof RecyclerView.SavedState)) {
                        this.lBb.onRestoreInstanceState(dmT);
                        break;
                    } else {
                        this.lBb.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.lBd != null && this.lBd.bPo() != null) {
                            if (this.lpI.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.lBb.setSelectionFromTop((this.lBm.djW() + this.lBb.getHeaderViewsCount()) - 1, this.lBd.doR() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.lpI.getPageContext().getPageActivity()));
                            } else {
                                this.lBb.setSelectionFromTop((this.lBm.djW() + this.lBb.getHeaderViewsCount()) - 1, this.lBd.doR());
                            }
                        } else {
                            this.lBb.setSelection(this.lBm.djW() + this.lBb.getHeaderViewsCount());
                        }
                    } else {
                        this.lBb.setSelection(i2 > 0 ? ((this.lBb.getData() == null && fVar.dim() == null) ? 0 : (this.lBb.getData().size() - fVar.dim().size()) + this.lBb.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.iPm.endLoadData();
                    this.iPm.setText(this.lpI.getString(R.string.pb_load_more_without_point));
                    this.iPm.setLineGone();
                    break;
            }
            if (this.lCj == lCk && isHost()) {
                doo();
            }
            if (this.lCu) {
                dng();
                this.lCu = false;
                if (i3 == 0) {
                    uG(true);
                }
            }
            if (fVar.lmR == 1 || fVar.lmS == 1) {
                if (this.lCA == null) {
                    this.lCA = new PbTopTipView(this.lpI.getContext());
                }
                if (fVar.lmS == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.lpI.getStType())) {
                    this.lCA.setText(this.lpI.getString(R.string.pb_read_strategy_add_experience));
                    this.lCA.a(this.bET, this.mSkinType);
                } else if (fVar.lmR == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.lpI.getStType())) {
                    this.lCA.setText(this.lpI.getString(R.string.pb_read_news_add_experience));
                    this.lCA.a(this.bET, this.mSkinType);
                }
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dik() != null) {
            x(fVar);
            if (fVar.biv()) {
                SvgManager.brn().a(this.lBO, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.brn().a(this.lBO, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String Gj = Gj(fVar.dik().bmr());
            if (this.lBR != null) {
                this.lBR.setText(Gj);
            }
            if (this.lBS != null) {
                this.lBS.setText(Gj);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dik()));
        }
    }

    private String Gj(int i) {
        if (i == 0) {
            return this.lpI.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void dnR() {
        if (this.lBd != null) {
            this.lBd.a(this.lBb, this.textView, this.mType);
        }
    }

    public void uO(boolean z) {
        this.lBD = z;
    }

    public void endLoadData() {
        if (this.iPm != null) {
            this.iPm.setLineGone();
            this.iPm.endLoadData();
        }
        chg();
    }

    public void bVq() {
        this.lBb.setVisibility(0);
    }

    public void dnS() {
        if (this.lBb != null) {
            this.lBb.setVisibility(8);
        }
        if (this.lBb != null) {
            this.lCa.setVisibility(8);
        }
        if (this.lAX != null && this.lAX.lHo != null) {
            this.lAX.lHo.setVisibility(8);
        }
    }

    public void dnT() {
        if (this.lBb != null) {
            this.lBb.setVisibility(0);
        }
        if (this.lCa != null) {
            this.lCa.setVisibility(0);
        }
        if (this.lAX != null && this.lAX.lHo != null) {
            this.lAX.lHo.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.lBW != null && this.lBW.bmA() != null && this.lAX != null) {
            this.lCx = !this.lCw;
            this.lAX.vf(this.lCx);
            if (this.lpI.dkn() != null) {
                this.lpI.dkn().ve(this.lCx);
            }
            dnU();
            if (this.lpI != null && !this.lpI.djq() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.diH())) {
                bs bsVar = fVar.diH().get(0);
                if (bsVar != null) {
                    this.lAX.fU(bsVar.getForumName(), bsVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.lAX.fU(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.lCx) {
                this.lBg.a(fVar, this.lBW, this.lBE);
                if (this.lCc != null) {
                    this.lCc.setVisibility(8);
                }
                if (this.lCG == null) {
                    this.lCG = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.az.19
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (az.this.lpI != null && az.this.lpI.isAdded()) {
                                if (i < 0 && f > az.this.lCz) {
                                    az.this.dob();
                                    az.this.don();
                                }
                                az.this.dnL();
                            }
                        }
                    };
                }
                this.lBb.setListViewDragListener(this.lCG);
                return;
            }
            if (this.lCc != null) {
                this.lCc.setVisibility(0);
            }
            this.lBg.a(fVar, this.lBW, this.lBE);
            this.lCG = null;
            this.lBb.setListViewDragListener(null);
        }
    }

    private void dnU() {
        this.lBg.a(this.lqP, this.lBW, this.lCx, this.lCw);
    }

    public boolean dnV() {
        return this.lqP == null || this.lqP.getForum() == null || "0".equals(this.lqP.getForum().getId()) || "me0407".equals(this.lqP.getForum().getName());
    }

    private boolean dnW() {
        return this.lBe.va(this.lqx);
    }

    private boolean w(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dik() == null) {
            return false;
        }
        if (fVar.dik().bmx() == 1 || fVar.dik().getThreadType() == 33) {
            return true;
        }
        return !(fVar.dik().bmz() == null || fVar.dik().bmz().boP() == 0) || fVar.dik().bmv() == 1 || fVar.dik().bmw() == 1 || fVar.dik().bno() || fVar.dik().bnI() || fVar.dik().bnB() || fVar.dik().bmL() != null || !com.baidu.tbadk.core.util.at.isEmpty(fVar.dik().getCategory()) || fVar.dik().bmD() || fVar.dik().bmC();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.lBf != null) {
                if (fVar.dik() != null && fVar.dik().bmO() == 0 && !fVar.dik().blg() && !this.lCN) {
                    if (fVar.dik() != null) {
                        bw dik = fVar.dik();
                        dik.z(true, w(fVar));
                        dik.oi(3);
                        dik.Bb("2");
                    }
                    if (fVar.dik().bli()) {
                        this.lBg.c(this.lBb);
                        this.lBf.c(this.lBb);
                        this.lBf.b(this.lBb);
                        this.lBg.b(this.lBb);
                        this.lBg.E(this.lqP);
                        this.lBf.B(fVar);
                    } else {
                        this.lBg.E(this.lqP);
                        this.lBf.D(fVar);
                    }
                } else if (fVar.dik().bmO() == 1) {
                    if (fVar.dik() != null) {
                        this.lBf.c(this.lBb);
                        this.lBg.E(this.lqP);
                    }
                } else {
                    this.lBf.c(this.lBb);
                    this.lBg.E(this.lqP);
                }
            }
            if (fVar.dik() != null) {
                as(fVar.dik().bmw() == 1, fVar.dik().bmv() == 1);
            }
            this.lqx = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            dnW();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.ab abVar;
        StringBuilder sb = null;
        if (fVar != null && (b = b(fVar, z)) != null) {
            String userId = b.bmA().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.diz()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.bmA() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.bmA().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.bmA().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.bmA().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.diz()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bs> diH = fVar.diH();
                if (com.baidu.tbadk.core.util.y.getCount(diH) > 0) {
                    sb = new StringBuilder();
                    for (bs bsVar : diH) {
                        if (bsVar != null && !StringUtils.isNull(bsVar.getForumName()) && (abVar = bsVar.eDc) != null && abVar.eAP && !abVar.eAQ && (abVar.type == 1 || abVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bsVar.getForumName(), 12)).append(this.lpI.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.lpI.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View dnX() {
        return this.fuw;
    }

    public boolean dnY() {
        if (this.bFD == null || this.bFD.getParent() == null || this.iPm.isLoading()) {
            return false;
        }
        int bottom = this.bFD.getBottom();
        Rect rect = new Rect();
        this.bFD.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void PN(String str) {
        if (this.iPm != null) {
            this.iPm.setText(str);
        }
    }

    public void PO(String str) {
        if (this.iPm != null) {
            int i = 0;
            if (this.lCh != null && this.lCh.lDm != null && this.lCh.lDm.getView() != null) {
                i = this.lCh.lDm.getView().getTop() < 0 ? this.lCh.lDm.getView().getHeight() : this.lCh.lDm.getView().getBottom();
            }
            this.iPm.ap(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.lBb;
    }

    public int dnZ() {
        return R.id.richText;
    }

    public TextView djJ() {
        return this.lBg.djJ();
    }

    public void d(BdListView.e eVar) {
        this.lBb.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.eVA = cVar;
        if (this.lBq != null) {
            this.lBq.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.av avVar, a.b bVar) {
        if (avVar != null) {
            int blo = avVar.blo();
            int bll = avVar.bll();
            if (this.lBn != null) {
                this.lBn.bpc();
            } else {
                this.lBn = new com.baidu.tbadk.core.dialog.a(this.lpI.getPageContext().getPageActivity());
                this.lBo = LayoutInflater.from(this.lpI.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.lBn.bf(this.lBo);
                this.lBn.a(R.string.dialog_ok, bVar);
                this.lBn.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        az.this.dob();
                        aVar.dismiss();
                    }
                });
                this.lBn.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.az.21
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (az.this.lCr == null) {
                            az.this.lCr = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.21.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    az.this.lpI.HidenSoftKeyPad((InputMethodManager) az.this.lpI.getBaseFragmentActivity().getSystemService("input_method"), az.this.bET);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.mY().postDelayed(az.this.lCr, 150L);
                    }
                });
                this.lBn.b(this.lpI.getPageContext()).bpc();
            }
            this.lBp = (EditText) this.lBo.findViewById(R.id.input_page_number);
            this.lBp.setText("");
            TextView textView = (TextView) this.lBo.findViewById(R.id.current_page_number);
            if (blo <= 0) {
                blo = 1;
            }
            if (bll <= 0) {
                bll = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(blo), Integer.valueOf(bll)));
            this.lpI.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.lBp, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.lBb.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.lpI.showToast(str);
    }

    public boolean uP(boolean z) {
        if (this.abk == null || !this.abk.bzB()) {
            return false;
        }
        this.abk.bxU();
        return true;
    }

    public void doa() {
        if (this.lCW != null) {
            while (this.lCW.size() > 0) {
                TbImageView remove = this.lCW.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        doa();
        this.lBm.FJ(1);
        if (this.lBd != null) {
            this.lBd.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.lBm.FJ(2);
        if (this.lBd != null) {
            this.lBd.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.lpI.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lpI.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.lBQ != null) {
            this.lBQ.onDestroy();
        }
        if (this.lCt != null) {
            this.lCt.destroy();
        }
        if (this.lCI != null) {
            this.lCI.onDestory();
        }
        if (this.lCA != null) {
            this.lCA.hide();
        }
        this.lpI.hideProgressBar();
        if (this.ghD != null && this.iEz != null) {
            this.ghD.b(this.iEz);
        }
        dob();
        endLoadData();
        if (this.lCr != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lCr);
        }
        if (this.lBZ != null) {
            this.lBZ.clearStatus();
        }
        this.lCQ = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.lBm.FJ(3);
        if (this.bEb != null) {
            this.bEb.setBackgroundDrawable(null);
        }
        if (this.lBd != null) {
            this.lBd.destroy();
        }
        if (this.lBm != null) {
            this.lBm.onDestroy();
        }
        this.lBb.setOnLayoutListener(null);
        if (this.lCE != null) {
            this.lCE.cBn();
        }
        if (this.lCi != null) {
            this.lCi.onDestroy();
        }
        if (this.lBg != null) {
            this.lBg.onDestroy();
        }
    }

    public boolean Gk(int i) {
        if (this.lBd != null) {
            return this.lBd.Gk(i);
        }
        return false;
    }

    public void dob() {
        this.lAX.aZC();
        if (this.lBg != null) {
            this.lBg.dob();
        }
        if (this.lpI != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lpI.getContext(), this.lBp);
        }
        dni();
        if (this.ltV != null) {
            this.ltV.dismiss();
        }
        dod();
        if (this.lBn != null) {
            this.lBn.dismiss();
        }
        if (this.iKa != null) {
            this.iKa.dismiss();
        }
    }

    public void doc() {
        this.lAX.aZC();
        if (this.lBg != null) {
            this.lBg.dob();
        }
        if (this.ltV != null) {
            this.ltV.dismiss();
        }
        dod();
        if (this.lBn != null) {
            this.lBn.dismiss();
        }
        if (this.iKa != null) {
            this.iKa.dismiss();
        }
    }

    public void fe(List<String> list) {
        this.lCD = list;
        if (this.lCE != null) {
            this.lCE.setData(list);
        }
    }

    public void tT(boolean z) {
        this.lBm.tT(z);
    }

    public void uQ(boolean z) {
        this.lBG = z;
    }

    public void dod() {
        if (this.lBu != null) {
            this.lBu.dismiss();
        }
        if (this.lBv != null) {
            com.baidu.adp.lib.f.g.b(this.lBv, this.lpI.getPageContext());
        }
        if (this.lBw != null) {
            com.baidu.adp.lib.f.g.b(this.lBw, this.lpI.getPageContext());
        }
        if (this.lBt != null) {
            this.lBt.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            d(this.lqP, this.lqx);
            b(this.lqP, this.lqx, this.mType, i);
            this.lpI.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.lpI.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bET);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bET, R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lBH, R.drawable.personalize_tab_shadow);
            if (this.lBd != null) {
                this.lBd.onChangeSkinType(i);
            }
            if (this.lBh != null) {
                this.lBh.onChangeSkinType(i);
            }
            if (this.lBe != null) {
                this.lBe.onChangeSkinType(i);
            }
            if (this.lBf != null) {
                this.lBf.onChangeSkinType(i);
            }
            if (this.lBg != null) {
                this.lBg.onChangeSkinType(i);
            }
            if (this.iPm != null) {
                this.iPm.changeSkin(i);
                if (this.fuw != null) {
                    this.lpI.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fuw);
                    com.baidu.tbadk.core.util.ap.setBackgroundResource(this.fuw, R.drawable.pb_foot_more_trans_selector);
                }
            }
            if (this.lBn != null) {
                this.lBn.c(this.lpI.getPageContext());
            }
            uO(this.lBD);
            this.lBm.notifyDataSetChanged();
            if (this.lBq != null) {
                this.lBq.changeSkin(i);
            }
            if (this.abk != null) {
                this.abk.onChangeSkinType(i);
            }
            if (this.lBr != null) {
                this.lBr.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.iav)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.iav) {
                    customBlueCheckRadioButton.bsh();
                }
            }
            dnA();
            UtilHelper.setStatusBarBackground(this.bEb, i);
            UtilHelper.setStatusBarBackground(this.lCc, i);
            if (this.lBi != null) {
                com.baidu.tbadk.r.a.a(this.lpI.getPageContext(), this.lBi);
            }
            if (this.lCs != null) {
                this.lCs.onChangeSkinType(i);
            }
            if (this.lAX != null) {
                if (this.lBd != null) {
                    this.lBd.Gl(i);
                } else {
                    this.lAX.onChangeSkinType(i);
                }
            }
            this.mSkinType = i;
            if (this.jKd != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.jKd, R.color.cp_cont_d);
            }
            if (this.lBM != null) {
                this.lBM.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_border_a));
            }
            if (this.lBL != null) {
                this.lBL.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aO(com.baidu.adp.lib.util.l.getDimens(this.lpI.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ap.getColor(R.color.cp_bg_line_j)));
            }
            if (this.lBO != null && this.lqP != null) {
                if (this.lqP.biv()) {
                    SvgManager.brn().a(this.lBO, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.brn().a(this.lBO, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            x(this.lqP);
            if (this.lBN != null) {
                SvgManager.brn().a(this.lBN, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.lBJ != null) {
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lBJ, R.drawable.bottom_shadow);
            }
            if (this.lBR != null) {
                com.baidu.tbadk.core.util.ap.c(this.lBR, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_bg_line_h, R.color.cp_bg_line_h);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lBR, R.color.cp_cont_j);
            }
            if (this.lBS != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lBS, R.color.cp_cont_b);
            }
            if (this.lCF != null) {
                this.lCF.onChangeSkinType(i);
            }
            if (this.lCi != null) {
                this.lCi.onChangeSkinType();
            }
            if (this.lCC != null) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lCC, R.color.cp_cont_n);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lBK, R.color.cp_bg_line_h);
            if (this.lBc != null) {
                this.lBc.uE(i);
            }
            if (this.lBQ != null) {
                this.lBQ.onChangeSkinType();
            }
        }
    }

    public void doe() {
        if (this.lBQ != null) {
            this.lBQ.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.aZ(fVar.dik())) {
            if (this.lBQ != null) {
                this.lBQ.setEnable(false);
                this.lBQ.onDestroy();
            }
            SvgManager.brn().a(this.lBP, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.lBQ == null || !this.lBQ.isEnable()) {
            SvgManager.brn().a(this.lBP, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFW = iVar;
        this.lBm.setOnImageClickListener(this.fFW);
        this.lCF.setOnImageClickListener(this.fFW);
    }

    public void g(NoNetworkView.a aVar) {
        this.iEz = aVar;
        if (this.ghD != null) {
            this.ghD.a(this.iEz);
        }
    }

    public void uR(boolean z) {
        this.lBm.setIsFromCDN(z);
    }

    public Button dof() {
        return this.lBI;
    }

    public void dog() {
        if (this.lAW != 2) {
            this.lBb.setNextPage(this.iPm);
            this.lAW = 2;
        }
    }

    public void doh() {
        if (com.baidu.tbadk.n.m.bCu().bCv()) {
            int lastVisiblePosition = this.lBb.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.lBb.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.fvf = true;
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
                        perfLog2.fvf = true;
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

    public boolean doi() {
        return this.abk != null && this.abk.getVisibility() == 0;
    }

    public boolean doj() {
        return this.abk != null && this.abk.bzB();
    }

    public void dok() {
        if (this.abk != null) {
            this.abk.bxU();
        }
    }

    public void uS(boolean z) {
        if (this.lBK != null) {
            uQ(this.lpI.dkk().bAl());
            if (this.lBG) {
                uH(z);
            } else {
                uI(z);
            }
        }
    }

    public void dol() {
        if (this.lBK != null) {
            this.lBJ.setVisibility(8);
            this.lBK.setVisibility(8);
            this.lBT = false;
            if (this.lCi != null) {
                this.lCi.setVisibility(8);
                uM(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.iey == null) {
            this.iey = new com.baidu.tbadk.core.view.a(this.lpI.getPageContext());
        }
        this.iey.setDialogVisiable(true);
    }

    public void chg() {
        if (this.iey != null) {
            this.iey.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.lBb.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.lBb.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lBd != null) {
            this.lBd.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.lCX = getScrollY();
            this.lCh.lDm = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lCh));
            a(this.lCh.lDm, true);
        }
    }

    public void uT(boolean z) {
        if (this.lBd != null) {
            this.lBd.uT(z);
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
        if (this.lBd != null) {
            this.lBd.onScroll(absListView, i, i2, i3);
        }
        if (this.lAX != null && this.lBg != null) {
            this.lAX.dr(this.lBg.doN());
        }
        this.lCh.lgB = i;
        this.lCh.headerCount = this.lBb.getHeaderViewsCount();
        this.lCh.lDm = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lCh));
        uJ(b(absListView, i));
        a(this.lCh.lDm, false);
        if (this.iPm.bsv() && !this.iPm.eUH) {
            if (this.lCh != null && this.lCh.lDm != null && this.lCh.lDm.getView() != null) {
                i4 = this.lCh.lDm.getView().getTop() < 0 ? this.lCh.lDm.getView().getHeight() : this.lCh.lDm.getView().getBottom();
            }
            this.iPm.pU(i4);
            this.iPm.eUH = true;
        }
    }

    public void dom() {
        if (TbadkCoreApplication.isLogin() && this.lqP != null && this.lCx && !this.lCw && !this.lBE && this.lBW != null && this.lBW.bmA() != null && !this.lBW.bmA().getIsLike() && !this.lBW.bmA().hadConcerned() && this.lCt == null) {
            this.lCt = new av(this.lpI);
        }
    }

    public void don() {
        if (this.lpI != null) {
            if ((this.iHd || this.lCL == 17) && com.baidu.tbadk.a.d.bhY()) {
                if (this.lqP != null && this.lqP.getForum() != null && !com.baidu.tbadk.core.util.at.isEmpty(this.lqP.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.lpI.getContext()).createNormalCfg(this.lqP.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13853").dR("post_id", this.lqP.getThreadId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", this.lqP.getForum().getId()));
                }
            } else if (this.lCx && !this.lCw && this.lBW != null && this.lBW.bmA() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12601").al("obj_locate", this.lpI.djq() ? 2 : 1).al("obj_type", this.lCw ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.lpI.getPageContext().getPageActivity(), this.lBW.bmA().getUserId(), this.lBW.bmA().getUserName(), this.lpI.djz().djr(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(au auVar, boolean z) {
        int measuredHeight;
        if (!this.lCw && this.lCb != null && this.lAX.dpf() != null) {
            int djX = this.lBm.djX();
            if (djX > 0 && (auVar == null || auVar.getView().getParent() == null)) {
                if (djX > this.lBb.getFirstVisiblePosition() - this.lBb.getHeaderViewsCount()) {
                    this.lCb.setVisibility(4);
                    return;
                }
                this.lCb.setVisibility(0);
                uJ(false);
                this.lAX.mNavigationBar.hideBottomLine();
                if (this.lCb.getParent() != null && ((ViewGroup) this.lCb.getParent()).getHeight() <= this.lCb.getTop()) {
                    this.lCb.getParent().requestLayout();
                }
            } else if (auVar == null || auVar.getView() == null || auVar.lAw == null) {
                if (this.lBb.getFirstVisiblePosition() == 0) {
                    this.lCb.setVisibility(4);
                    this.lAX.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = auVar.getView().getTop();
                if (auVar.getView().getParent() != null) {
                    if (this.lCg) {
                        this.lCf = top;
                        this.lCg = false;
                    }
                    this.lCf = top < this.lCf ? top : this.lCf;
                }
                if (top != 0 || auVar.getView().isShown()) {
                    if (this.lBl.getY() < 0.0f) {
                        measuredHeight = lCe - auVar.lAw.getMeasuredHeight();
                    } else {
                        measuredHeight = this.lAX.dpf().getMeasuredHeight() - auVar.lAw.getMeasuredHeight();
                        this.lAX.mNavigationBar.hideBottomLine();
                    }
                    if (auVar.getView().getParent() == null && top <= this.lCf) {
                        this.lCb.setVisibility(0);
                        uJ(false);
                    } else if (top < measuredHeight) {
                        this.lCb.setVisibility(0);
                        uJ(false);
                    } else {
                        this.lCb.setVisibility(4);
                        this.lAX.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.lCg = true;
                    }
                }
            }
        }
    }

    public void doo() {
        if (!this.lCY) {
            TiebaStatic.log("c10490");
            this.lCY = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lpI.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(lCl, Integer.valueOf(lCn));
            aVar.ov(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.lpI.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.bf(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.lpI);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.23
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lpI.getPageContext()).bpc();
        }
    }

    public void PP(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lpI.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.lpI.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.bf(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(lCl, Integer.valueOf(lCo));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.lpI);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lpI.getPageContext()).bpc();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.bmA() != null) {
            MetaData bmA = b.bmA();
            bmA.setGiftNum(bmA.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        a(fVar, z, i, i2);
        this.lBg.onChangeSkinType(i2);
    }

    public PbInterviewStatusView dop() {
        return this.lBZ;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dik() != null && fVar.dik().bnI() && this.lBZ == null) {
            this.lBZ = (PbInterviewStatusView) this.lBY.inflate();
            this.lBZ.setOnClickListener(this.iKb);
            this.lBZ.setCallback(this.lpI.dkV());
            this.lBZ.setData(this.lpI, fVar);
        }
    }

    public RelativeLayout doq() {
        return this.lBl;
    }

    public View dor() {
        return this.bEb;
    }

    public boolean dos() {
        return this.lCN;
    }

    public void tY(boolean z) {
        this.lBg.tY(z);
    }

    public void PQ(String str) {
        if (this.lAY != null) {
            this.lAY.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int uU(boolean z) {
        if (this.lBZ == null || this.lBZ.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void dot() {
        if (this.lBZ != null && this.lBZ.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lBZ.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.lBZ.setLayoutParams(layoutParams);
        }
    }

    public boolean dkq() {
        return false;
    }

    public void PR(String str) {
        this.jKd.performClick();
        if (!StringUtils.isNull(str) && this.lpI.dkk() != null && this.lpI.dkk().bAd() != null && this.lpI.dkk().bAd().getInputView() != null) {
            EditText inputView = this.lpI.dkk().bAd().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            dob();
            if (configuration.orientation == 2) {
                dol();
                dni();
            } else {
                dnm();
            }
            if (this.lCs != null) {
                this.lCs.dkf();
            }
            this.lpI.cyL();
            this.lBl.setVisibility(8);
            this.lAX.vg(false);
            this.lpI.un(false);
            if (this.lBd != null) {
                if (configuration.orientation == 1) {
                    doq().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.lBb.setIsLandscape(true);
                    this.lBb.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.lBb.setIsLandscape(false);
                    if (this.lCX > 0) {
                        this.lBb.smoothScrollBy(this.lCX, 0);
                    }
                }
                this.lBd.onConfigurationChanged(configuration);
                this.lCa.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void uV(boolean z) {
        if (this.lBd != null) {
            this.lBd.uV(z);
        }
    }

    public boolean dou() {
        return this.lBd != null && this.lBd.dou();
    }

    public void dov() {
        if (this.lBd != null) {
            this.lBd.dov();
        }
    }

    public void uc(boolean z) {
        this.lBm.uc(z);
    }

    public void dq(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.lBK.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.lpI.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.lCC = new TextView(this.lpI.getContext());
            this.lCC.setText(R.string.connection_tips);
            this.lCC.setGravity(17);
            this.lCC.setPadding(com.baidu.adp.lib.util.l.getDimens(this.lpI.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.lpI.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lpI.getContext(), R.dimen.ds60);
            if (this.lCC.getParent() == null) {
                frameLayout.addView(this.lCC, layoutParams);
            }
            this.lCB = new PopupWindow(this.lpI.getContext());
            this.lCB.setContentView(frameLayout);
            this.lCB.setHeight(-2);
            this.lCB.setWidth(-2);
            this.lCB.setFocusable(true);
            this.lCB.setOutsideTouchable(false);
            this.lCB.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.lBb.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.25
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        az.this.lCB.showAsDropDown(az.this.lBK, view.getLeft(), -az.this.lBK.getHeight());
                    } else {
                        az.this.lCB.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void uW(boolean z) {
        this.lCH = z;
    }

    public boolean dow() {
        return this.lCH;
    }

    public PbThreadPostView dox() {
        return this.lBc;
    }

    private void as(boolean z, boolean z2) {
        at(z, z2);
        if (this.lqP != null && this.lqP.dik() != null && this.lqP.dik().bmO() == 0 && !this.lqP.dik().blg()) {
            au(z, z2);
        } else if (this.lBm != null && this.lBm.dkc() != null) {
            this.lBm.dkc().b(this.lqP, z, z2);
        }
    }

    private void at(boolean z, boolean z2) {
        this.lBg.d(this.lqP, z, z2);
    }

    private void au(boolean z, boolean z2) {
        this.lBf.c(this.lqP, z, z2);
    }

    public void uX(boolean z) {
        this.iHd = z;
    }

    public void Gc(int i) {
        this.lCL = i;
    }

    public void doy() {
        if (this.lBb != null) {
            this.lBb.setForbidDragListener(true);
        }
    }

    public boolean dlp() {
        if (this.lBb == null) {
            return false;
        }
        return this.lBb.dlp();
    }

    public boolean doz() {
        if (this.iPm == null || TextUtils.isEmpty(this.iPm.getEndText())) {
            return false;
        }
        return this.iPm.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
