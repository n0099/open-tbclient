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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class az {
    private EditorTools abp;
    private View bCq;
    private View bDS;
    private RelativeLayout bDi;
    private f.c eUM;
    private com.baidu.tieba.pb.a.c fgS;
    private View ftG;
    private NoNetworkView ghk;
    private boolean iHR;
    private View.OnClickListener iKO;
    private PbListView iPZ;
    private List<CustomBlueCheckRadioButton> iaX;
    private boolean isLandscape;
    private TextView jKO;
    private NavigationBarCoverTip jle;
    private com.baidu.tieba.NEGFeedBack.e jox;
    private LinearLayout lBA;
    private TextView lBB;
    private TextView lBC;
    private ObservedChangeRelativeLayout lBD;
    private g lBE;
    private View lBK;
    private View lBZ;
    public int lBn;
    public final com.baidu.tieba.pb.pb.main.view.c lBp;
    public com.baidu.tieba.pb.pb.main.view.b lBq;
    private ViewStub lBr;
    private ViewStub lBs;
    private PbLandscapeListView lBt;
    private PbThreadPostView lBu;
    private com.baidu.tieba.pb.pb.main.a.e lBv;
    private com.baidu.tieba.pb.pb.main.a.a lBw;
    private com.baidu.tieba.pb.pb.main.a.c lBx;
    private com.baidu.tieba.pb.pb.main.a.d lBy;
    private com.baidu.tieba.pb.pb.main.a.b lBz;
    private PbEmotionBar lCA;
    private int lCI;
    private Runnable lCJ;
    private v lCK;
    private av lCL;
    private int lCR;
    private PbTopTipView lCS;
    private PopupWindow lCT;
    private TextView lCU;
    private List<String> lCV;
    private com.baidu.tieba.pb.pb.main.emotion.c lCW;
    private com.baidu.tieba.pb.pb.godreply.a lCX;
    private PbLandscapeListView.b lCY;
    private View lCb;
    private View lCc;
    private LinearLayout lCd;
    private HeadImageView lCe;
    private ImageView lCf;
    private ImageView lCg;
    private ImageView lCh;
    private com.baidu.tieba.pb.view.c lCi;
    private TextView lCj;
    private TextView lCk;
    private int lCm;
    private int lCn;
    private PostData lCo;
    private ViewStub lCq;
    private PbInterviewStatusView lCr;
    private FrameLayout lCs;
    private View lCt;
    private View lCu;
    private au lCv;
    private al lDa;
    private String lDb;
    private long lDc;
    private int lDd;
    private boolean lDf;
    private Runnable lDj;
    private PbFragment.b lDl;
    public int lDp;
    private PbFragment lpX;
    private View.OnClickListener lqU;
    private com.baidu.tieba.pb.data.f lre;
    private PbFakeFloorModel ltx;
    PbFragment.c lvm;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int lCw = UtilHelper.getLightStatusBarHeight();
    public static int lCC = 3;
    public static int lCD = 0;
    public static int lCE = 3;
    public static int lCF = 4;
    public static int lCG = 5;
    public static int lCH = 6;
    private static a.InterfaceC0853a lDe = new a.InterfaceC0853a() { // from class: com.baidu.tieba.pb.pb.main.az.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0853a
        public void onRefresh() {
        }
    };
    private int lBo = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a lBF = null;
    private com.baidu.tbadk.core.dialog.b iKN = null;
    private View lBG = null;
    private EditText lBH = null;
    private com.baidu.tieba.pb.view.d lBI = null;
    private com.baidu.tieba.pb.view.a lBJ = null;
    private b.InterfaceC0574b kjx = null;
    private TbRichTextView.i fFy = null;
    private NoNetworkView.a iFn = null;
    private com.baidu.tbadk.core.dialog.i lBL = null;
    private com.baidu.tbadk.core.dialog.a lBM = null;
    private Dialog lBN = null;
    private Dialog lBO = null;
    private View lBP = null;
    private LinearLayout lBQ = null;
    private CompoundButton.OnCheckedChangeListener iaY = null;
    private TextView lBR = null;
    private TextView lBS = null;
    private String lBT = null;
    private com.baidu.tbadk.core.dialog.i lul = null;
    private com.baidu.tbadk.core.dialog.i lBU = null;
    private boolean lBV = false;
    private boolean lBW = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView lBX = null;
    private boolean lBY = false;
    private Button lCa = null;
    private boolean lCl = true;
    private com.baidu.tbadk.core.view.a ifn = null;
    private boolean lqM = false;
    private int mSkinType = 3;
    private boolean lCp = false;
    private int lCx = 0;
    private boolean lCy = true;
    public a lCz = new a();
    private int lCB = 0;
    private boolean lCM = false;
    private int lCN = 0;
    private boolean lCO = false;
    private boolean lCP = false;
    private boolean lCQ = false;
    private boolean lCZ = false;
    private String lDg = null;
    private CustomMessageListener lDh = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.az.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                az.this.lDg = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.az.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && az.this.lBE != null) {
                az.this.lBE.notifyDataSetChanged();
            }
        }
    };
    private Handler lDi = new Handler();
    private CustomMessageListener lDk = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.az.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                az.this.lCl = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean lDm = true;
    View.OnClickListener lDn = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || az.this.lre == null || az.this.lre.dhH() == null || az.this.lre.dhH().blC() == null || az.this.lre.dhH().blC().getAlaInfo() == null || az.this.lre.dhH().blC().getAlaInfo().live_status != 1) {
                if (az.this.lCO) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11923").ak("obj_id", 2));
                }
                if (!az.this.lCO && az.this.lre != null && az.this.lre.dhH() != null && az.this.lre.dhH().blC() != null && az.this.lre.dhH().blC().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12151").ak("obj_locate", 1));
                }
                if (az.this.lpX.dkB() != null) {
                    az.this.lpX.dkB().lqj.iry.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c11851");
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(arVar);
            if (az.this.lre.dhH().blC().getAlaInfo() == null || !az.this.lre.dhH().blC().getAlaInfo().isChushou) {
                if (az.this.lre.dhH().blC().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = az.this.lre.dhH().blC().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(az.this.lpX.dkB(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            bf.bqF().b(az.this.lpX.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + az.this.lre.dhH().blC().getAlaInfo().thirdRoomId + "&livetype=" + az.this.lre.dhH().blC().getAlaInfo().thirdLiveType});
        }
    };
    private boolean beP = false;
    String userId = null;
    private final List<TbImageView> lDo = new ArrayList();
    private boolean lDq = false;

    /* loaded from: classes21.dex */
    public static class a {
        public int headerCount;
        public au lDE;
        public int lgS;
    }

    public void uJ(boolean z) {
        this.lCM = z;
        if (this.lBt != null) {
            this.lCN = this.lBt.getHeaderViewsCount();
        }
    }

    public void dmE() {
        if (this.lBt != null) {
            int headerViewsCount = this.lBt.getHeaderViewsCount() - this.lCN;
            final int firstVisiblePosition = (this.lBt.getFirstVisiblePosition() == 0 || this.lBt.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.lBt.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.lBt.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.lCz.lDE = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lCz));
            final au auVar = this.lCz.lDE;
            final int g = g(auVar);
            final int y = ((int) this.lBD.getY()) + this.lBD.getMeasuredHeight();
            final boolean z = this.lCt.getVisibility() == 0;
            boolean z2 = this.lBD.getY() < 0.0f;
            if ((z && auVar != null) || firstVisiblePosition >= this.lBE.djt() + this.lBt.getHeaderViewsCount()) {
                int measuredHeight = auVar != null ? auVar.lAO.getMeasuredHeight() : 0;
                if (z2) {
                    this.lBt.setSelectionFromTop(this.lBE.djt() + this.lBt.getHeaderViewsCount(), lCw - measuredHeight);
                } else {
                    this.lBt.setSelectionFromTop(this.lBE.djt() + this.lBt.getHeaderViewsCount(), this.lBp.doE().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.lBt.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.lCO && this.lBv != null) {
                this.lBt.setSelectionFromTop(this.lBE.djt() + this.lBt.getHeaderViewsCount(), this.lBv.doq());
            } else if (this.mType == 6) {
                this.lBt.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.az.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void onLayout() {
                        ViewGroup.LayoutParams layoutParams;
                        if (g >= 0 && g <= az.this.bDi.getMeasuredHeight()) {
                            int g2 = az.this.g(auVar);
                            int i = g2 - g;
                            if (z && i != 0 && g <= y) {
                                i = g2 - y;
                            }
                            if (az.this.bDS != null && (layoutParams = az.this.bDS.getLayoutParams()) != null) {
                                if (i == 0 || i > az.this.bDi.getMeasuredHeight() || g2 >= az.this.bDi.getMeasuredHeight()) {
                                    layoutParams.height = az.this.lCI;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > az.this.bDi.getMeasuredHeight()) {
                                    layoutParams.height = az.this.lCI;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    az.this.lBt.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                az.this.bDS.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (az.this.bDS != null && az.this.bDS.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = az.this.bDS.getLayoutParams();
                                            layoutParams2.height = az.this.lCI;
                                            az.this.bDS.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        az.this.lBt.setOnLayoutListener(null);
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

    public NoNetworkView dmF() {
        return this.ghk;
    }

    public void dmG() {
        if (this.abp != null) {
            this.abp.hide();
            if (this.lCW != null) {
                this.lCW.dos();
            }
        }
    }

    public PbFakeFloorModel dmH() {
        return this.ltx;
    }

    public v dmI() {
        return this.lCK;
    }

    public com.baidu.tieba.pb.pb.main.a.e dmJ() {
        return this.lBv;
    }

    public void dmK() {
        reset();
        dmG();
        this.lCK.djC();
        uV(false);
    }

    private void reset() {
        if (this.lpX != null && this.lpX.djH() != null && this.abp != null) {
            com.baidu.tbadk.editortools.pb.a.bzq().setStatus(0);
            com.baidu.tbadk.editortools.pb.e djH = this.lpX.djH();
            djH.bzL();
            djH.bza();
            if (djH.getWriteImagesInfo() != null) {
                djH.getWriteImagesInfo().setMaxImagesAllowed(djH.isBJH ? 1 : 9);
            }
            djH.rS(SendView.ALL);
            djH.rT(SendView.ALL);
            com.baidu.tbadk.editortools.h rF = this.abp.rF(23);
            com.baidu.tbadk.editortools.h rF2 = this.abp.rF(2);
            com.baidu.tbadk.editortools.h rF3 = this.abp.rF(5);
            if (rF2 != null) {
                rF2.display();
            }
            if (rF3 != null) {
                rF3.display();
            }
            if (rF != null) {
                rF.hide();
            }
            this.abp.invalidate();
        }
    }

    public boolean dmL() {
        return this.lCl;
    }

    public void uK(boolean z) {
        if (this.lCc != null && this.jKO != null) {
            this.jKO.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lCc.startAnimation(alphaAnimation);
            }
            this.lCb.setVisibility(0);
            this.lCc.setVisibility(0);
            this.lCl = true;
            if (this.lCA != null && !this.lCX.isActive()) {
                this.lCA.setVisibility(0);
                uP(true);
            }
        }
    }

    public void uL(boolean z) {
        if (this.lCc != null && this.jKO != null) {
            this.jKO.setText(dmM());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lCc.startAnimation(alphaAnimation);
            }
            this.lCb.setVisibility(0);
            this.lCc.setVisibility(0);
            this.lCl = true;
            if (this.lCA != null && !this.lCX.isActive()) {
                this.lCA.setVisibility(0);
                uP(true);
            }
        }
    }

    public String dmM() {
        if (!com.baidu.tbadk.core.util.au.isEmpty(this.lDb)) {
            return this.lDb;
        }
        if (this.lpX != null) {
            this.lDb = TbadkCoreApplication.getInst().getResources().getString(ay.dmC());
        }
        return this.lDb;
    }

    public PostData dmN() {
        int i = 0;
        if (this.lBt == null) {
            return null;
        }
        int dmO = dmO() - this.lBt.getHeaderViewsCount();
        if (dmO < 0) {
            dmO = 0;
        }
        if (this.lBE.Gg(dmO) != null && this.lBE.Gg(dmO) != PostData.mXI) {
            i = dmO + 1;
        }
        return this.lBE.getItem(i) instanceof PostData ? (PostData) this.lBE.getItem(i) : null;
    }

    public int dmO() {
        int i;
        View childAt;
        if (this.lBt == null) {
            return 0;
        }
        int firstVisiblePosition = this.lBt.getFirstVisiblePosition();
        int lastVisiblePosition = this.lBt.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.lBt.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.lBt.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int dmP() {
        return this.lBt.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.lre != null && this.lre.dhJ() != null && !this.lre.dhJ().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.lre.dhJ().size() && (postData = this.lre.dhJ().get(i)) != null && postData.blC() != null && !StringUtils.isNull(postData.blC().getUserId()); i++) {
                if (this.lre.dhJ().get(i).blC().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.lCX != null && this.lCX.isActive()) {
                        uV(false);
                    }
                    if (this.lCA != null) {
                        this.lCA.vf(true);
                    }
                    this.lDg = postData.blC().getName_show();
                    return;
                }
            }
        }
    }

    public az(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.lpX = null;
        this.bDi = null;
        this.bCq = null;
        this.lBt = null;
        this.lBE = null;
        this.iPZ = null;
        this.ftG = null;
        this.iKO = null;
        this.lqU = null;
        this.lCc = null;
        this.jKO = null;
        this.lCq = null;
        this.lCR = 0;
        this.lDc = 0L;
        this.lDc = System.currentTimeMillis();
        this.lpX = pbFragment;
        this.iKO = onClickListener;
        this.fgS = cVar;
        this.lCR = com.baidu.adp.lib.util.l.getEquipmentWidth(this.lpX.getContext()) / 8;
        this.bDi = (RelativeLayout) LayoutInflater.from(this.lpX.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bDi.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.lBZ = this.bDi.findViewById(R.id.bottom_shadow);
        this.jle = (NavigationBarCoverTip) this.bDi.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.bCq = this.bDi.findViewById(R.id.statebar_view);
        this.lBD = (ObservedChangeRelativeLayout) this.bDi.findViewById(R.id.title_wrapper);
        this.ghk = (NoNetworkView) this.bDi.findViewById(R.id.view_no_network);
        this.lBt = (PbLandscapeListView) this.bDi.findViewById(R.id.new_pb_list);
        this.lCs = (FrameLayout) this.bDi.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.lpX.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.lpX.getActivity(), R.dimen.ds88));
        this.lBt.addHeaderView(this.textView, 0);
        this.lBt.setTextViewAdded(true);
        this.lCI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bDS = new View(this.lpX.getPageContext().getPageActivity());
        this.bDS.setLayoutParams(new AbsListView.LayoutParams(-1, this.lCI));
        this.bDS.setVisibility(4);
        this.lBt.addFooterView(this.bDS);
        this.lBt.setOnTouchListener(this.lpX.fyo);
        this.lBp = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bDi);
        if (this.lpX.dkk()) {
            this.lBr = (ViewStub) this.bDi.findViewById(R.id.manga_view_stub);
            this.lBr.setVisibility(0);
            this.lBq = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.lBq.show();
            this.lBp.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lpX.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.lBp.doE().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0808a() { // from class: com.baidu.tieba.pb.pb.main.az.26
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0808a
            public void diH() {
                if (az.this.lBt != null) {
                    if (az.this.lBv != null) {
                        az.this.lBv.dop();
                    }
                    az.this.lBt.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0808a
            public void diI() {
                az.this.lpX.cyo();
            }
        }));
        this.lCb = this.bDi.findViewById(R.id.view_comment_top_line);
        this.lCc = this.bDi.findViewById(R.id.pb_editor_tool_comment);
        this.lCm = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lCn = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lCe = (HeadImageView) this.bDi.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lCe.setVisibility(0);
        this.lCe.setIsRound(true);
        this.lCe.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.lpX.getContext(), R.dimen.L_X01));
        this.lCe.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0401));
        this.lCe.setPlaceHolder(0);
        dmQ();
        this.jKO = (TextView) this.bDi.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lCd = (LinearLayout) this.bDi.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lCd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.lpX.djS();
                if (az.this.lpX != null && az.this.lpX.diV() != null && az.this.lpX.diV().getPbData() != null && az.this.lpX.diV().getPbData().dhH() != null && az.this.lpX.diV().getPbData().dhH().blC() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13701").dR("tid", az.this.lpX.diV().dkV()).dR("fid", az.this.lpX.diV().getPbData().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", az.this.lpX.diV().lxu).dR("fid", az.this.lpX.diV().getPbData().getForumId()).ak("obj_locate", 1).dR("uid", az.this.lpX.diV().getPbData().dhH().blC().getUserId()));
                }
            }
        });
        this.lCf = (ImageView) this.bDi.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lCf.setOnClickListener(this.iKO);
        boolean booleanExtra = this.lpX.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lCg = (ImageView) this.bDi.findViewById(R.id.pb_editor_tool_collection);
        this.lCg.setOnClickListener(this.iKO);
        if (booleanExtra) {
            this.lCg.setVisibility(8);
        } else {
            this.lCg.setVisibility(0);
        }
        this.lCh = (ImageView) this.bDi.findViewById(R.id.pb_editor_tool_share);
        this.lCh.setOnClickListener(this.iKO);
        this.lCi = new com.baidu.tieba.pb.view.c(this.lCh);
        this.lCi.drX();
        this.lCj = (TextView) this.bDi.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lCj.setVisibility(0);
        this.lCq = (ViewStub) this.bDi.findViewById(R.id.interview_status_stub);
        this.lBw = new com.baidu.tieba.pb.pb.main.a.a(this.lpX, cVar);
        this.lBy = new com.baidu.tieba.pb.pb.main.a.d(this.lpX, cVar, this.iKO);
        this.lBE = new g(this.lpX, this.lBt);
        this.lBE.F(this.iKO);
        this.lBE.setTbGestureDetector(this.fgS);
        this.lBE.setOnImageClickListener(this.fFy);
        this.lBE.setOnSwitchChangeListener(this.lpX.lvf);
        this.lqU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.28
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
                            az.this.lpX.c(sparseArray);
                            return;
                        }
                        az.this.dt(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        az.this.lpX.c(sparseArray);
                    } else if (booleanValue3) {
                        az.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.lBE.S(this.lqU);
        dmV();
        dmW();
        this.lBx.b(this.lBt);
        this.lBy.b(this.lBt);
        this.lBw.b(this.lBt);
        this.iPZ = new PbListView(this.lpX.getPageContext().getPageActivity());
        this.ftG = this.iPZ.getView().findViewById(R.id.pb_more_view);
        if (this.ftG != null) {
            this.ftG.setOnClickListener(this.iKO);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.ftG, R.drawable.pb_foot_more_trans_selector);
        }
        this.iPZ.setLineVisible();
        this.iPZ.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.iPZ.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.lBK = this.bDi.findViewById(R.id.viewstub_progress);
        this.lpX.registerListener(this.lDk);
        this.ltx = new PbFakeFloorModel(this.lpX.getPageContext());
        this.lCK = new v(this.lpX.getPageContext(), this.ltx, this.bDi);
        this.lCK.T(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.dmK();
            }
        });
        this.lCK.a(this.lpX.lvh);
        this.ltx.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.az.30
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                az.this.ltx.t(postData);
                az.this.lBE.notifyDataSetChanged();
                az.this.lCK.djC();
                az.this.abp.bxk();
                az.this.uV(false);
            }
        });
        if (this.lpX.diV() != null && !StringUtils.isNull(this.lpX.diV().dlD())) {
            this.lpX.showToast(this.lpX.diV().dlD());
        }
        this.lCt = this.bDi.findViewById(R.id.pb_expand_blank_view);
        this.lCu = this.bDi.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lCu.getLayoutParams();
        if (this.lpX.diV() != null && this.lpX.diV().dkY()) {
            this.lCt.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.lCu.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = lCw;
            this.lCu.setLayoutParams(layoutParams2);
        }
        this.lCv = new au(this.lpX.getPageContext(), this.bDi.findViewById(R.id.pb_reply_expand_view));
        this.lCv.v(pbFragment.lub);
        this.lCv.lAO.setVisibility(8);
        this.lCv.U(this.iKO);
        this.lCv.setOnSwitchChangeListener(this.lpX.lvf);
        this.lpX.registerListener(this.mAccountChangedListener);
        this.lpX.registerListener(this.lDh);
        dmR();
        uP(false);
    }

    private void dmQ() {
        if (this.lCe != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lCe.setImageResource(0);
            this.lCe.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.lCe.setImageResource(R.drawable.transparent_bg);
    }

    public void uM(boolean z) {
        this.lBZ.setVisibility(z ? 0 : 8);
    }

    public void cLJ() {
        if (!this.lpX.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").ak("obj_locate", 2).dR("fid", this.mForumId));
        } else if (this.lpX.djU()) {
            com.baidu.tbadk.editortools.pb.e djH = this.lpX.djH();
            if (djH != null && (djH.bzI() || djH.bzJ())) {
                this.lpX.djH().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.abp != null) {
                dnb();
            }
            if (this.abp != null) {
                this.lCl = false;
                if (this.abp.rI(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.lpX.getPageContext(), (View) this.abp.rI(2).fmx, false, lDe);
                }
            }
            dnK();
        }
    }

    private void dmR() {
        this.lCX = new com.baidu.tieba.pb.pb.godreply.a(this.lpX, this, (ViewStub) this.bDi.findViewById(R.id.more_god_reply_popup));
        this.lCX.B(this.iKO);
        this.lCX.S(this.lqU);
        this.lCX.setOnImageClickListener(this.fFy);
        this.lCX.B(this.iKO);
        this.lCX.setTbGestureDetector(this.fgS);
    }

    public com.baidu.tieba.pb.pb.godreply.a dmS() {
        return this.lCX;
    }

    public View dmT() {
        return this.lCt;
    }

    public void dmU() {
        if (this.lBt != null) {
            this.lBx.c(this.lBt);
            this.lBy.c(this.lBt);
            this.lBz.c(this.lBt);
            this.lBw.c(this.lBt);
        }
    }

    private void dmV() {
        if (this.lBz == null) {
            this.lBz = new com.baidu.tieba.pb.pb.main.a.b(this.lpX, this.iKO);
        }
    }

    private void dmW() {
        if (this.lBx == null) {
            this.lBx = new com.baidu.tieba.pb.pb.main.a.c(this.lpX, this.fgS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmX() {
        if (this.lpX.dkk()) {
            this.lBs = (ViewStub) this.bDi.findViewById(R.id.manga_mention_controller_view_stub);
            this.lBs.setVisibility(0);
            if (this.lBA == null) {
                this.lBA = (LinearLayout) this.bDi.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.lpX.getPageContext(), this.lBA);
            }
            if (this.lBB == null) {
                this.lBB = (TextView) this.lBA.findViewById(R.id.manga_prev_btn);
            }
            if (this.lBC == null) {
                this.lBC = (TextView) this.lBA.findViewById(R.id.manga_next_btn);
            }
            this.lBB.setOnClickListener(this.iKO);
            this.lBC.setOnClickListener(this.iKO);
        }
    }

    private void dmY() {
        if (this.lpX.dkk()) {
            if (this.lpX.dkn() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lBB, R.color.CAM_X0110, 1);
            }
            if (this.lpX.dko() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lBC, R.color.CAM_X0110, 1);
            }
        }
    }

    public void dmZ() {
        if (this.lBA == null) {
            dmX();
        }
        this.lBs.setVisibility(8);
        if (this.lDi != null && this.lDj != null) {
            this.lDi.removeCallbacks(this.lDj);
        }
    }

    public void dna() {
        if (this.lDi != null) {
            if (this.lDj != null) {
                this.lDi.removeCallbacks(this.lDj);
            }
            this.lDj = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.3
                @Override // java.lang.Runnable
                public void run() {
                    if (az.this.lBA == null) {
                        az.this.dmX();
                    }
                    az.this.lBs.setVisibility(0);
                }
            };
            this.lDi.postDelayed(this.lDj, 2000L);
        }
    }

    public void uN(boolean z) {
        this.lBp.uN(z);
        if (z && this.lCp) {
            this.iPZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.lBt.setNextPage(this.iPZ);
            this.lBo = 2;
        }
        dmQ();
    }

    public void setEditorTools(EditorTools editorTools) {
        this.abp = editorTools;
        this.abp.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.dmK();
            }
        });
        this.abp.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.abp.getParent() == null) {
            this.bDi.addView(this.abp, layoutParams);
        }
        this.abp.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.abp.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.az.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                    if (((com.baidu.tbadk.coreExtra.data.u) aVar.data).buc() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.u) aVar.data).buc() == EmotionGroupType.USER_COLLECT) {
                        if (az.this.mPermissionJudgePolicy == null) {
                            az.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        az.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        az.this.mPermissionJudgePolicy.appendRequestPermission(az.this.lpX.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!az.this.mPermissionJudgePolicy.startRequestPermission(az.this.lpX.getBaseFragmentActivity())) {
                            az.this.lpX.djH().c((com.baidu.tbadk.coreExtra.data.u) aVar.data);
                            az.this.lpX.djH().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dmG();
        this.lpX.djH().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.az.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (az.this.abp != null && az.this.abp.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (az.this.lCW == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, az.this.abp.getId());
                            az.this.lCW = new com.baidu.tieba.pb.pb.main.emotion.c(az.this.lpX.getPageContext(), az.this.bDi, layoutParams2);
                            if (!com.baidu.tbadk.core.util.y.isEmpty(az.this.lCV)) {
                                az.this.lCW.setData(az.this.lCV);
                            }
                            az.this.lCW.c(az.this.abp);
                        }
                        az.this.lCW.Pr(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (az.this.lpX.kzS != null && az.this.lpX.kzS.dob() != null) {
                    if (!az.this.lpX.kzS.dob().dSV()) {
                        az.this.lpX.kzS.vb(false);
                    }
                    az.this.lpX.kzS.dob().yx(false);
                }
            }
        });
    }

    public void dnb() {
        if (this.lpX != null && this.abp != null) {
            this.abp.display();
            if (this.lpX.djH() != null) {
                this.lpX.djH().bzy();
            }
            dnK();
        }
    }

    public void uO(boolean z) {
        if (this.lBt != null && this.textView != null && this.bCq != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bCq.setVisibility(0);
                } else {
                    this.bCq.setVisibility(8);
                    this.lBt.removeHeaderView(this.textView);
                    this.lBt.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = lCw;
                    this.textView.setLayoutParams(layoutParams);
                }
                dnp();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + uX(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            dnp();
            dnS();
        }
    }

    public g dnc() {
        return this.lBE;
    }

    public void a(PbFragment.c cVar) {
        this.lvm = cVar;
    }

    public void dt(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lpX.getContext());
        kVar.setTitleText(this.lpX.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.lBL.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            az.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (az.this.lDl != null) {
                                az.this.lDl.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            az.this.lpX.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.lpX.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(0, this.lpX.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eGH.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !dnR()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(1, this.lpX.getString(R.string.forbidden_person), kVar);
            gVar3.eGH.setTag(sparseArray3);
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
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.lpX.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(2, this.lpX.getString(R.string.mute), kVar);
            }
            gVar.eGH.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.br(arrayList);
        this.lBL = new com.baidu.tbadk.core.dialog.i(this.lpX.getPageContext(), kVar);
        this.lBL.PA();
    }

    public void a(PbFragment.b bVar) {
        this.lDl = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.lpX != null && aVar != null) {
            if (this.jox == null && this.lBw != null) {
                this.jox = new com.baidu.tieba.NEGFeedBack.e(this.lpX.getPageContext(), this.lBw.dol());
            }
            AntiData cwP = this.lpX.cwP();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cwP != null && cwP.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cwP.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.as asVar = new com.baidu.tbadk.core.data.as();
            asVar.setFeedBackReasonMap(sparseArray);
            this.jox.setDefaultReasonArray(new String[]{this.lpX.getString(R.string.delete_thread_reason_1), this.lpX.getString(R.string.delete_thread_reason_2), this.lpX.getString(R.string.delete_thread_reason_3), this.lpX.getString(R.string.delete_thread_reason_4), this.lpX.getString(R.string.delete_thread_reason_5)});
            this.jox.setData(asVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jox.Ev(str);
            this.jox.a(new e.b() { // from class: com.baidu.tieba.pb.pb.main.az.9
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    az.this.lpX.a(aVar, jSONArray);
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
        sparseArray.put(lCD, Integer.valueOf(lCE));
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
        this.lBM = new com.baidu.tbadk.core.dialog.a(this.lpX.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lBM.os(i3);
        } else {
            this.lBM.setOnlyMessageShowCenter(false);
            this.lBM.AJ(str2);
        }
        this.lBM.setYesButtonTag(sparseArray);
        this.lBM.a(R.string.dialog_ok, this.lpX);
        this.lBM.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lBM.iW(true);
        this.lBM.b(this.lpX.getPageContext());
        if (z) {
            this.lBM.bog();
        } else {
            a(this.lBM, i);
        }
    }

    public void bd(ArrayList<com.baidu.tbadk.core.data.ak> arrayList) {
        if (this.lBP == null) {
            this.lBP = LayoutInflater.from(this.lpX.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.lpX.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lBP);
        if (this.lBO == null) {
            this.lBO = new Dialog(this.lpX.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lBO.setCanceledOnTouchOutside(true);
            this.lBO.setCancelable(true);
            this.lBX = (ScrollView) this.lBP.findViewById(R.id.good_scroll);
            this.lBO.setContentView(this.lBP);
            WindowManager.LayoutParams attributes = this.lBO.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lBO.getWindow().setAttributes(attributes);
            this.iaY = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.az.12
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        az.this.lBT = (String) compoundButton.getTag();
                        if (az.this.iaX != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : az.this.iaX) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && az.this.lBT != null && !str.equals(az.this.lBT)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lBQ = (LinearLayout) this.lBP.findViewById(R.id.good_class_group);
            this.lBS = (TextView) this.lBP.findViewById(R.id.dialog_button_cancel);
            this.lBS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (az.this.lBO instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(az.this.lBO, az.this.lpX.getPageContext());
                    }
                }
            });
            this.lBR = (TextView) this.lBP.findViewById(R.id.dialog_button_ok);
            this.lBR.setOnClickListener(this.iKO);
        }
        this.lBQ.removeAllViews();
        this.iaX = new ArrayList();
        CustomBlueCheckRadioButton fT = fT("0", this.lpX.getPageContext().getString(R.string.thread_good_class));
        this.iaX.add(fT);
        fT.setChecked(true);
        this.lBQ.addView(fT);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ak akVar = arrayList.get(i2);
                if (akVar != null && !TextUtils.isEmpty(akVar.bjQ()) && akVar.bjR() > 0) {
                    CustomBlueCheckRadioButton fT2 = fT(String.valueOf(akVar.bjR()), akVar.bjQ());
                    this.iaX.add(fT2);
                    View view = new View(this.lpX.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ap.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.lBQ.addView(view);
                    this.lBQ.addView(fT2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lBX.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lpX.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lpX.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lpX.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lBX.setLayoutParams(layoutParams2);
            this.lBX.removeAllViews();
            if (this.lBQ != null && this.lBQ.getParent() == null) {
                this.lBX.addView(this.lBQ);
            }
        }
        com.baidu.adp.lib.f.g.a(this.lBO, this.lpX.getPageContext());
    }

    private CustomBlueCheckRadioButton fT(String str, String str2) {
        Activity pageActivity = this.lpX.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.iaY);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void dnd() {
        this.lpX.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.lpX.hideProgressBar();
        if (z && z2) {
            this.lpX.showToast(this.lpX.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.lpX.showToast(str);
        }
    }

    public void cTa() {
        this.lBK.setVisibility(0);
    }

    public void cSZ() {
        this.lBK.setVisibility(8);
    }

    public View dne() {
        if (this.lBP != null) {
            return this.lBP.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String dnf() {
        return this.lBT;
    }

    public View getView() {
        return this.bDi;
    }

    public void dng() {
        if (this.lpX != null && this.lpX.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lpX.getPageContext().getPageActivity(), this.lpX.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.lpX.hideProgressBar();
        if (z) {
            dnA();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            dnB();
        } else {
            dnA();
        }
    }

    public void dnh() {
        this.iPZ.setLineVisible();
        this.iPZ.startLoadData();
    }

    public void dni() {
        this.lpX.hideProgressBar();
        endLoadData();
        this.lBt.completePullRefreshPostDelayed(0L);
        dnv();
    }

    public void dnj() {
        this.lBt.completePullRefreshPostDelayed(0L);
        dnv();
    }

    private void uP(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.lBy.b(onLongClickListener);
        this.lBE.setOnLongClickListener(onLongClickListener);
        if (this.lCX != null) {
            this.lCX.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0574b interfaceC0574b, boolean z, boolean z2) {
        if (this.lul != null) {
            this.lul.dismiss();
            this.lul = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lpX.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lpX.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lpX.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lpX.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lpX.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.br(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.lBU.dismiss();
                interfaceC0574b.a(null, i, view);
            }
        });
        this.lBU = new com.baidu.tbadk.core.dialog.i(this.lpX.getPageContext(), kVar);
        this.lBU.PA();
    }

    public void a(final b.InterfaceC0574b interfaceC0574b, boolean z) {
        if (this.lBU != null) {
            this.lBU.dismiss();
            this.lBU = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lpX.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.lre != null && this.lre.dhH() != null && !this.lre.dhH().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lpX.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lpX.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.br(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.lBU.dismiss();
                interfaceC0574b.a(null, i, view);
            }
        });
        this.lBU = new com.baidu.tbadk.core.dialog.i(this.lpX.getPageContext(), kVar);
        this.lBU.PA();
    }

    public int dnk() {
        return GF(this.lBt.getFirstVisiblePosition());
    }

    private int GF(int i) {
        com.baidu.adp.widget.ListView.f adapter = this.lBt.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.lBt.getAdapter() == null || !(this.lBt.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) ? 0 : this.lBt.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int dnl() {
        int lastVisiblePosition = this.lBt.getLastVisiblePosition();
        if (this.lBv != null) {
            if (lastVisiblePosition == this.lBt.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return GF(lastVisiblePosition);
    }

    public void GG(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.lBt != null) {
            if (this.lBp == null || this.lBp.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.lBp.mNavigationBar.getFixedNavHeight();
                if (this.lpX.dka() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.lCu != null && (layoutParams = (LinearLayout.LayoutParams) this.lCu.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.lCu.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.lBt.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.lBt.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.lBt.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.lBH.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.lBE.a(fVar, false);
        this.lBE.notifyDataSetChanged();
        dnv();
        if (this.lCX != null) {
            this.lCX.bLW();
        }
        ArrayList<PostData> dhJ = fVar.dhJ();
        if (fVar.getPage().bks() == 0 || dhJ == null || dhJ.size() < fVar.getPage().bkr()) {
            if (com.baidu.tbadk.core.util.y.getCount(dhJ) == 0 || (com.baidu.tbadk.core.util.y.getCount(dhJ) == 1 && dhJ.get(0) != null && dhJ.get(0).dJQ() == 1)) {
                if (this.lCz == null || this.lCz.lDE == null || this.lCz.lDE.getView() == null) {
                    i = 0;
                } else {
                    i = this.lCz.lDE.getView().getTop() < 0 ? this.lCz.lDE.getView().getHeight() : this.lCz.lDE.getView().getBottom();
                }
                if (this.lpX.dku()) {
                    this.iPZ.ao(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.iPZ.ao(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().bks() == 0) {
                    this.iPZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.iPZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.iPZ.brJ();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.lBw != null) {
            this.lBw.e(fVar, this.lqM);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dhU() != null) {
            return fVar.dhU();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dhJ())) {
            Iterator<PostData> it = fVar.dhJ().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dJQ() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dhQ();
        }
        if (!r(postData)) {
            postData = a(fVar);
        }
        if (postData != null && postData.blC() != null && postData.blC().getUserTbVipInfoData() != null && postData.blC().getUserTbVipInfoData().getvipIntro() != null) {
            postData.blC().getGodUserData().setIntro(postData.blC().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean r(PostData postData) {
        if (postData == null || postData.blC() == null) {
            return false;
        }
        MetaData blC = postData.blC();
        return (TextUtils.isEmpty(blC.getUserId()) && TextUtils.isEmpty(blC.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dhH() == null || fVar.dhH().blC() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData blC = fVar.dhH().blC();
        String userId = blC.getUserId();
        HashMap<String, MetaData> userMap = fVar.dhH().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = blC;
        }
        postData.Kf(1);
        postData.setId(fVar.dhH().blT());
        postData.setTitle(fVar.dhH().getTitle());
        postData.setTime(fVar.dhH().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.dhH() != null) {
            if (this.lpX.diN()) {
                if (fVar.dhG() != null) {
                    this.mForumName = fVar.dhG().getForumName();
                    this.mForumId = fVar.dhG().getForumId();
                }
                if (this.mForumName == null && this.lpX.diV() != null && this.lpX.diV().diO() != null) {
                    this.mForumName = this.lpX.diV().diO();
                }
            }
            PostData b = b(fVar, z);
            a(b, fVar);
            this.lBy.setVisibility(8);
            if (fVar.dih()) {
                this.lCO = true;
                this.lBp.vm(true);
                this.lBp.mNavigationBar.hideBottomLine();
                if (this.lBv == null) {
                    this.lBv = new com.baidu.tieba.pb.pb.main.a.e(this.lpX);
                }
                this.lBv.a(fVar, b, this.lBt, this.lBy, this.lCs, this.lBp, this.mForumName, this.lDc);
                this.lBv.V(this.lDn);
                dnp();
            } else {
                this.lCO = false;
                this.lBp.vm(this.lCO);
                if (this.lBv != null) {
                    this.lBv.c(this.lBt);
                }
            }
            if (this.lpX.djK() != null) {
                this.lpX.djK().vg(this.lCO);
            }
            if (b != null) {
                this.lCo = b;
                this.lBy.setVisibility(0);
                SparseArray<Object> doo = this.lBy.doo();
                doo.put(R.id.tag_clip_board, b);
                doo.put(R.id.tag_is_subpb, false);
                this.lBz.a(fVar, this.lBt);
                this.lBx.C(fVar);
                this.lBw.e(fVar, this.lqM);
                this.lBw.B(fVar);
                this.lBy.a(this.mSkinType, this.lre, b, this.lDn);
                if (this.lCv != null) {
                    if (fVar.dik()) {
                        this.lCv.getView().setVisibility(8);
                    } else {
                        this.lCv.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.loE);
                        if (fVar.dhH() != null) {
                            nVar.loG = fVar.dhH().blt();
                        }
                        nVar.isNew = !this.lqM;
                        nVar.sortType = fVar.lnl;
                        nVar.loI = fVar.dil();
                        nVar.loJ = this.lpX.dku();
                        nVar.loK = fVar.lnk;
                        this.lCv.a(nVar);
                    }
                }
                z(fVar);
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.17
                    @Override // java.lang.Runnable
                    public void run() {
                        if (az.this.lBE != null && az.this.lBp != null && az.this.lBp.lHH != null && az.this.lre != null && az.this.lre.dhH() != null && !az.this.lre.dhH().bki() && !az.this.dnu() && az.this.lre.getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(az.this.lre.getForum().getName())) {
                            if ((az.this.lBE.djx() == null || !az.this.lBE.djx().isShown()) && az.this.lBp.lHH != null) {
                                az.this.lBp.lHH.setVisibility(0);
                                if (az.this.lpX != null && az.this.lpX.diV() != null) {
                                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13400");
                                    arVar.dR("tid", az.this.lpX.diV().dkU());
                                    arVar.dR("fid", az.this.lpX.diV().getForumId());
                                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(arVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void uQ(boolean z) {
        if (z) {
            dnm();
        } else {
            crO();
        }
        this.lCz.lDE = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lCz));
        a(this.lCz.lDE, false);
    }

    public void dnm() {
        if (this.lBp != null && !this.lCQ) {
            this.lBp.dnm();
            this.lCQ = true;
        }
    }

    public void crO() {
        if (this.lBp != null) {
            this.lBp.doN();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.lBy.a(postData, fVar);
    }

    public void dnn() {
        if (this.lBv != null) {
            this.lBv.d(this.lBt);
        }
    }

    public boolean dno() {
        return this.beP;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aM(bx bxVar) {
        if (bxVar == null || bxVar.blC() == null) {
            return false;
        }
        PostData b = b(this.lre, false);
        String str = "";
        if (b != null && b.blC() != null) {
            str = b.blC().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.lBp.doK();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.lBp.Nd(dVar.forumName);
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
            final String str2 = dVar.lnb;
            this.lpX.showNetRefreshView(this.bDi, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        bf.bqF().b(az.this.lpX.getPageContext(), new String[]{str2});
                        az.this.lpX.finish();
                        return;
                    }
                    az.this.lpX.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable dms;
        Parcelable dms2;
        if (fVar != null && this.lBt != null) {
            this.lre = fVar;
            this.mType = i;
            if (fVar.dhH() != null) {
                this.lCB = fVar.dhH().blj();
                if (fVar.dhH().getAnchorLevel() != 0) {
                    this.beP = true;
                }
                this.lBW = aM(fVar.dhH());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.lCp = false;
            this.lqM = z;
            dni();
            if (fVar.lnm != null && fVar.lnm.diq()) {
                if (this.lBu == null) {
                    this.lBu = new PbThreadPostView(this.lpX.getContext());
                    this.lBt.addHeaderView(this.lBu, 1);
                    this.lBu.setData(fVar);
                    this.lBu.setChildOnClickLinstener(this.iKO);
                }
            } else if (this.lBu != null && this.lBt != null) {
                this.lBt.removeHeaderView(this.lBu);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.lDa == null) {
                this.lDa = new al(this.lpX.getPageContext(), this.jle);
            }
            this.lDa.Ph(fVar.dhO());
            if (this.lpX.dkk()) {
                if (this.lBI == null) {
                    this.lBI = new com.baidu.tieba.pb.view.d(this.lpX.getPageContext());
                    this.lBI.createView();
                    this.lBI.setListPullRefreshListener(this.eUM);
                }
                this.lBt.setPullRefresh(this.lBI);
                dnp();
                if (this.lBI != null) {
                    this.lBI.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().bkt() == 0 && z) {
                this.lBt.setPullRefresh(null);
            } else {
                if (this.lBI == null) {
                    this.lBI = new com.baidu.tieba.pb.view.d(this.lpX.getPageContext());
                    this.lBI.createView();
                    this.lBI.setListPullRefreshListener(this.eUM);
                }
                this.lBt.setPullRefresh(this.lBI);
                dnp();
                if (this.lBI != null) {
                    this.lBI.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                cgz();
            }
            dnv();
            this.lBE.tX(this.lqM);
            this.lBE.tY(false);
            this.lBE.uc(i == 5);
            this.lBE.ud(i == 6);
            this.lBE.ue(z2 && this.lDm && i != 2);
            this.lBE.a(fVar, false);
            this.lBE.notifyDataSetChanged();
            this.lBy.b(b(fVar, z), fVar.dik());
            if (fVar.dhH() != null && fVar.dhH().bln() != null && this.lBn != -1) {
                fVar.dhH().bln().setIsLike(this.lBn);
            }
            if (TbadkCoreApplication.isLogin()) {
                this.lBt.setNextPage(this.iPZ);
                this.lBo = 2;
                cgz();
            } else {
                this.lCp = true;
                if (fVar.getPage().bks() == 1) {
                    if (this.lBJ == null) {
                        this.lBJ = new com.baidu.tieba.pb.view.a(this.lpX, this.lpX);
                    }
                    this.lBt.setNextPage(this.lBJ);
                } else {
                    this.lBt.setNextPage(this.iPZ);
                }
                this.lBo = 3;
            }
            ArrayList<PostData> dhJ = fVar.dhJ();
            if (fVar.getPage().bks() == 0 || dhJ == null || dhJ.size() < fVar.getPage().bkr()) {
                if (com.baidu.tbadk.core.util.y.getCount(dhJ) == 0 || (com.baidu.tbadk.core.util.y.getCount(dhJ) == 1 && dhJ.get(0) != null && dhJ.get(0).dJQ() == 1)) {
                    if (this.lCz == null || this.lCz.lDE == null || this.lCz.lDE.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.lCz.lDE.getView().getTop() < 0 ? this.lCz.lDE.getView().getHeight() : this.lCz.lDE.getView().getBottom();
                    }
                    if (this.lpX.dku()) {
                        this.iPZ.ao(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.iPZ.ao(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.lpX.djK() != null && !this.lpX.djK().doy()) {
                        this.lpX.djK().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().bks() == 0) {
                        this.iPZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.iPZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.iPZ.brJ();
                }
                if (fVar.getPage().bks() == 0 || dhJ == null) {
                    dnF();
                }
            } else {
                if (z2) {
                    if (this.lDm) {
                        endLoadData();
                        if (fVar.getPage().bks() != 0) {
                            this.iPZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.iPZ.setLineVisible();
                        this.iPZ.showLoading();
                    }
                } else {
                    this.iPZ.setLineVisible();
                    this.iPZ.showLoading();
                }
                this.iPZ.brJ();
            }
            switch (i) {
                case 2:
                    this.lBt.setSelection(i2 > 1 ? (((this.lBt.getData() == null && fVar.dhJ() == null) ? 0 : (this.lBt.getData().size() - fVar.dhJ().size()) + this.lBt.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (dms2 = as.dmr().dms()) != null && !(dms2 instanceof RecyclerView.SavedState)) {
                        this.lBt.onRestoreInstanceState(dms2);
                        if (com.baidu.tbadk.core.util.y.getCount(dhJ) > 1 && fVar.getPage().bks() > 0) {
                            this.iPZ.endLoadData();
                            this.iPZ.setText(this.lpX.getString(R.string.pb_load_more_without_point));
                            this.iPZ.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.lDm = false;
                    break;
                case 5:
                    this.lBt.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (dms = as.dmr().dms()) != null && !(dms instanceof RecyclerView.SavedState)) {
                        this.lBt.onRestoreInstanceState(dms);
                        break;
                    } else {
                        this.lBt.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.lBv != null && this.lBv.bOH() != null) {
                            if (this.lpX.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.lBt.setSelectionFromTop((this.lBE.djs() + this.lBt.getHeaderViewsCount()) - 1, this.lBv.doq() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.lpX.getPageContext().getPageActivity()));
                            } else {
                                this.lBt.setSelectionFromTop((this.lBE.djs() + this.lBt.getHeaderViewsCount()) - 1, this.lBv.doq());
                            }
                        } else {
                            this.lBt.setSelection(this.lBE.djs() + this.lBt.getHeaderViewsCount());
                        }
                    } else {
                        this.lBt.setSelection(i2 > 0 ? ((this.lBt.getData() == null && fVar.dhJ() == null) ? 0 : (this.lBt.getData().size() - fVar.dhJ().size()) + this.lBt.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.iPZ.endLoadData();
                    this.iPZ.setText(this.lpX.getString(R.string.pb_load_more_without_point));
                    this.iPZ.setLineGone();
                    break;
            }
            if (this.lCB == lCC && isHost()) {
                dnN();
            }
            if (this.lCM) {
                dmE();
                this.lCM = false;
                if (i3 == 0) {
                    uJ(true);
                }
            }
            if (fVar.lni == 1 || fVar.lnj == 1) {
                if (this.lCS == null) {
                    this.lCS = new PbTopTipView(this.lpX.getContext());
                }
                if (fVar.lnj == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.lpX.getStType())) {
                    this.lCS.setText(this.lpX.getString(R.string.pb_read_strategy_add_experience));
                    this.lCS.a(this.bDi, this.mSkinType);
                } else if (fVar.lni == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.lpX.getStType())) {
                    this.lCS.setText(this.lpX.getString(R.string.pb_read_news_add_experience));
                    this.lCS.a(this.bDi, this.mSkinType);
                }
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dhH() != null) {
            x(fVar);
            if (fVar.bhP()) {
                WebPManager.a(this.lCg, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lCg, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String GH = GH(fVar.dhH().blt());
            if (this.lCj != null) {
                this.lCj.setText(GH);
            }
            if (this.lCk != null) {
                this.lCk.setText(GH);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dhH()));
        }
    }

    private String GH(int i) {
        if (i == 0) {
            return this.lpX.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void dnp() {
        if (this.lBv != null) {
            this.lBv.a(this.lBt, this.textView, this.mType);
        }
    }

    public void uR(boolean z) {
        this.lBV = z;
    }

    public void endLoadData() {
        if (this.iPZ != null) {
            this.iPZ.setLineGone();
            this.iPZ.endLoadData();
        }
        cgz();
    }

    public void bUJ() {
        this.lBt.setVisibility(0);
    }

    public void dnq() {
        if (this.lBt != null) {
            this.lBt.setVisibility(8);
        }
        if (this.lBt != null) {
            this.lCs.setVisibility(8);
        }
        if (this.lBp != null && this.lBp.lHG != null) {
            this.lBp.lHG.setVisibility(8);
        }
    }

    public void dnr() {
        if (this.lBt != null) {
            this.lBt.setVisibility(0);
        }
        if (this.lCs != null) {
            this.lCs.setVisibility(0);
        }
        if (this.lBp != null && this.lBp.lHG != null) {
            this.lBp.lHG.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.lCo != null && this.lCo.blC() != null && this.lBp != null) {
            this.lCP = !this.lCO;
            this.lBp.vi(this.lCP);
            if (this.lpX.djK() != null) {
                this.lpX.djK().vh(this.lCP);
            }
            dnt();
            if (this.lpX != null && !this.lpX.diN() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.die())) {
                bt btVar = fVar.die().get(0);
                if (btVar != null) {
                    this.lBp.fU(btVar.getForumName(), btVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.lBp.fU(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.lCP) {
                this.lBy.a(fVar, this.lCo, this.lBW);
                if (this.lCu != null) {
                    this.lCu.setVisibility(8);
                }
                if (this.lCY == null) {
                    this.lCY = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.az.19
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (az.this.lpX != null && az.this.lpX.isAdded()) {
                                if (i < 0 && f > az.this.lCR) {
                                    az.this.dnA();
                                    az.this.dnM();
                                }
                                az.this.dnj();
                            }
                        }
                    };
                }
                this.lBt.setListViewDragListener(this.lCY);
                return;
            }
            if (this.lCu != null) {
                this.lCu.setVisibility(0);
            }
            this.lBy.a(fVar, this.lCo, this.lBW);
            this.lCY = null;
            this.lBt.setListViewDragListener(null);
        }
    }

    private void dnt() {
        this.lBy.a(this.lre, this.lCo, this.lCP, this.lCO);
    }

    public boolean dnu() {
        return this.lre == null || this.lre.getForum() == null || "0".equals(this.lre.getForum().getId()) || "me0407".equals(this.lre.getForum().getName());
    }

    private boolean dnv() {
        return this.lBw.vd(this.lqM);
    }

    private boolean w(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dhH() == null) {
            return false;
        }
        if (fVar.dhH().blz() == 1 || fVar.dhH().getThreadType() == 33) {
            return true;
        }
        return !(fVar.dhH().blB() == null || fVar.dhH().blB().bnT() == 0) || fVar.dhH().blx() == 1 || fVar.dhH().bly() == 1 || fVar.dhH().bmq() || fVar.dhH().bmM() || fVar.dhH().bmF() || fVar.dhH().blN() != null || !com.baidu.tbadk.core.util.au.isEmpty(fVar.dhH().getCategory()) || fVar.dhH().blF() || fVar.dhH().blE();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.lBx != null) {
                if (fVar.dhH() != null && fVar.dhH().blQ() == 0 && !fVar.dhH().bki() && !this.lDf) {
                    if (fVar.dhH() != null) {
                        bx dhH = fVar.dhH();
                        dhH.z(true, w(fVar));
                        dhH.oe(3);
                        dhH.Aw("2");
                    }
                    if (fVar.dhH().bkk()) {
                        this.lBy.c(this.lBt);
                        this.lBx.c(this.lBt);
                        this.lBx.b(this.lBt);
                        this.lBy.b(this.lBt);
                        this.lBy.G(this.lre);
                        if (A(fVar)) {
                            this.lBx.c(this.lBt);
                        } else {
                            this.lBx.D(fVar);
                        }
                    } else {
                        this.lBy.G(this.lre);
                        if (A(fVar)) {
                            this.lBx.c(this.lBt);
                        } else {
                            this.lBx.F(fVar);
                        }
                    }
                } else if (fVar.dhH().blQ() == 1) {
                    if (fVar.dhH() != null) {
                        this.lBx.c(this.lBt);
                        this.lBy.G(this.lre);
                    }
                } else {
                    this.lBx.c(this.lBt);
                    this.lBy.G(this.lre);
                }
            }
            z(fVar);
            this.lqM = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            dnv();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.ac acVar;
        StringBuilder sb = null;
        if (fVar != null && (b = b(fVar, z)) != null) {
            String userId = b.blC().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dhW()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.blC() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.blC().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.blC().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.blC().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dhW()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bt> die = fVar.die();
                if (com.baidu.tbadk.core.util.y.getCount(die) > 0) {
                    sb = new StringBuilder();
                    for (bt btVar : die) {
                        if (btVar != null && !StringUtils.isNull(btVar.getForumName()) && (acVar = btVar.eBt) != null && acVar.ezg && !acVar.ezh && (acVar.type == 1 || acVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(btVar.getForumName(), 12)).append(this.lpX.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.lpX.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View dnw() {
        return this.ftG;
    }

    public boolean dnx() {
        if (this.bDS == null || this.bDS.getParent() == null || this.iPZ.isLoading()) {
            return false;
        }
        int bottom = this.bDS.getBottom();
        Rect rect = new Rect();
        this.bDS.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Pj(String str) {
        if (this.iPZ != null) {
            this.iPZ.setText(str);
        }
    }

    public void Pk(String str) {
        if (this.iPZ != null) {
            int i = 0;
            if (this.lCz != null && this.lCz.lDE != null && this.lCz.lDE.getView() != null) {
                i = this.lCz.lDE.getView().getTop() < 0 ? this.lCz.lDE.getView().getHeight() : this.lCz.lDE.getView().getBottom();
            }
            this.iPZ.ao(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.lBt;
    }

    public int dny() {
        return R.id.richText;
    }

    public TextView djf() {
        return this.lBy.djf();
    }

    public void d(BdListView.e eVar) {
        this.lBt.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.eUM = cVar;
        if (this.lBI != null) {
            this.lBI.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.aw awVar, a.b bVar) {
        if (awVar != null) {
            int bkq = awVar.bkq();
            int bkn = awVar.bkn();
            if (this.lBF != null) {
                this.lBF.bog();
            } else {
                this.lBF = new com.baidu.tbadk.core.dialog.a(this.lpX.getPageContext().getPageActivity());
                this.lBG = LayoutInflater.from(this.lpX.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.lBF.bg(this.lBG);
                this.lBF.a(R.string.dialog_ok, bVar);
                this.lBF.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        az.this.dnA();
                        aVar.dismiss();
                    }
                });
                this.lBF.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.az.21
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (az.this.lCJ == null) {
                            az.this.lCJ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.21.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    az.this.lpX.HidenSoftKeyPad((InputMethodManager) az.this.lpX.getBaseFragmentActivity().getSystemService("input_method"), az.this.bDi);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.mY().postDelayed(az.this.lCJ, 150L);
                    }
                });
                this.lBF.b(this.lpX.getPageContext()).bog();
            }
            this.lBH = (EditText) this.lBG.findViewById(R.id.input_page_number);
            this.lBH.setText("");
            TextView textView = (TextView) this.lBG.findViewById(R.id.current_page_number);
            if (bkq <= 0) {
                bkq = 1;
            }
            if (bkn <= 0) {
                bkn = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(bkq), Integer.valueOf(bkn)));
            this.lpX.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.lBH, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.lBt.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.lpX.showToast(str);
    }

    public boolean uS(boolean z) {
        if (this.abp == null || !this.abp.byR()) {
            return false;
        }
        this.abp.bxk();
        return true;
    }

    public void dnz() {
        if (this.lDo != null) {
            while (this.lDo.size() > 0) {
                TbImageView remove = this.lDo.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        dnz();
        this.lBE.Gh(1);
        if (this.lBv != null) {
            this.lBv.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.lBE.Gh(2);
        if (this.lBv != null) {
            this.lBv.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.lpX.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lpX.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.lCi != null) {
            this.lCi.onDestroy();
        }
        if (this.lCL != null) {
            this.lCL.destroy();
        }
        if (this.lDa != null) {
            this.lDa.onDestory();
        }
        if (this.lCS != null) {
            this.lCS.hide();
        }
        this.lpX.hideProgressBar();
        if (this.ghk != null && this.iFn != null) {
            this.ghk.b(this.iFn);
        }
        dnA();
        endLoadData();
        if (this.lCJ != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lCJ);
        }
        if (this.lCr != null) {
            this.lCr.clearStatus();
        }
        this.lDi = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.lBE.Gh(3);
        if (this.bCq != null) {
            this.bCq.setBackgroundDrawable(null);
        }
        if (this.lBv != null) {
            this.lBv.destroy();
        }
        if (this.lBE != null) {
            this.lBE.onDestroy();
        }
        this.lBt.setOnLayoutListener(null);
        if (this.lCW != null) {
            this.lCW.cAQ();
        }
        if (this.lCA != null) {
            this.lCA.onDestroy();
        }
        if (this.lBy != null) {
            this.lBy.onDestroy();
        }
    }

    public boolean GI(int i) {
        if (this.lBv != null) {
            return this.lBv.GI(i);
        }
        return false;
    }

    public void dnA() {
        this.lBp.aYV();
        if (this.lBy != null) {
            this.lBy.dnA();
        }
        if (this.lpX != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lpX.getContext(), this.lBH);
        }
        dmG();
        if (this.lul != null) {
            this.lul.dismiss();
        }
        dnC();
        if (this.lBF != null) {
            this.lBF.dismiss();
        }
        if (this.iKN != null) {
            this.iKN.dismiss();
        }
    }

    public void dnB() {
        this.lBp.aYV();
        if (this.lBy != null) {
            this.lBy.dnA();
        }
        if (this.lul != null) {
            this.lul.dismiss();
        }
        dnC();
        if (this.lBF != null) {
            this.lBF.dismiss();
        }
        if (this.iKN != null) {
            this.iKN.dismiss();
        }
    }

    public void fe(List<String> list) {
        this.lCV = list;
        if (this.lCW != null) {
            this.lCW.setData(list);
        }
    }

    public void tW(boolean z) {
        this.lBE.tW(z);
    }

    public void uT(boolean z) {
        this.lBY = z;
    }

    public void dnC() {
        if (this.lBM != null) {
            this.lBM.dismiss();
        }
        if (this.lBN != null) {
            com.baidu.adp.lib.f.g.b(this.lBN, this.lpX.getPageContext());
        }
        if (this.lBO != null) {
            com.baidu.adp.lib.f.g.b(this.lBO, this.lpX.getPageContext());
        }
        if (this.lBL != null) {
            this.lBL.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            d(this.lre, this.lqM);
            b(this.lre, this.lqM, this.mType, i);
            this.lpX.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.lpX.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bDi);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bDi, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lBZ, R.color.CAM_X0203);
            if (this.lBv != null) {
                this.lBv.onChangeSkinType(i);
            }
            if (this.lBz != null) {
                this.lBz.onChangeSkinType(i);
            }
            if (this.lBw != null) {
                this.lBw.onChangeSkinType(i);
            }
            if (this.lBx != null) {
                this.lBx.onChangeSkinType(i);
            }
            if (this.lBy != null) {
                this.lBy.onChangeSkinType(i);
            }
            if (this.iPZ != null) {
                this.iPZ.changeSkin(i);
            }
            if (this.ftG != null) {
                this.lpX.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.ftG);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.ftG, R.drawable.pb_foot_more_trans_selector);
            }
            if (this.lBF != null) {
                this.lBF.c(this.lpX.getPageContext());
            }
            uR(this.lBV);
            this.lBE.notifyDataSetChanged();
            if (this.lBI != null) {
                this.lBI.changeSkin(i);
            }
            if (this.abp != null) {
                this.abp.onChangeSkinType(i);
            }
            if (this.lBJ != null) {
                this.lBJ.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.iaX)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.iaX) {
                    customBlueCheckRadioButton.brv();
                }
            }
            dmY();
            UtilHelper.setStatusBarBackground(this.bCq, i);
            UtilHelper.setStatusBarBackground(this.lCu, i);
            if (this.lBA != null) {
                com.baidu.tbadk.r.a.a(this.lpX.getPageContext(), this.lBA);
            }
            if (this.lCK != null) {
                this.lCK.onChangeSkinType(i);
            }
            if (this.lBp != null) {
                if (this.lBv != null) {
                    this.lBv.GJ(i);
                } else {
                    this.lBp.onChangeSkinType(i);
                }
            }
            if (this.lCe != null) {
                this.lCe.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0401));
            }
            if (this.lCd != null) {
                this.lCd.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aP(com.baidu.adp.lib.util.l.getDimens(this.lpX.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0209)));
            }
            if (this.lre != null && this.lre.bhP()) {
                WebPManager.a(this.lCg, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lCg, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.a(this.lCf, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            x(this.lre);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lCc, R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lCb, R.color.CAM_X0203);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lCU, R.color.cp_cont_n);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jKO, R.color.CAM_X0109);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lCk, R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lCj, R.color.CAM_X0107);
            com.baidu.tbadk.core.util.ap.c(this.lCj, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (this.lCX != null) {
                this.lCX.onChangeSkinType(i);
            }
            if (this.lCA != null) {
                this.lCA.onChangeSkinType();
            }
            if (this.lBu != null) {
                this.lBu.vc(i);
            }
            if (this.lCi != null) {
                this.lCi.onChangeSkinType();
            }
        }
    }

    public void dnD() {
        if (this.lCi != null) {
            this.lCi.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bb(fVar.dhH())) {
            if (this.lCi != null) {
                this.lCi.setEnable(false);
                this.lCi.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.lCh.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.lCh.setLayoutParams(layoutParams);
            WebPManager.a(this.lCh, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.lCi == null || !this.lCi.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.lCh.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.lCh.setLayoutParams(layoutParams2);
            WebPManager.a(this.lCh, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFy = iVar;
        this.lBE.setOnImageClickListener(this.fFy);
        this.lCX.setOnImageClickListener(this.fFy);
    }

    public void g(NoNetworkView.a aVar) {
        this.iFn = aVar;
        if (this.ghk != null) {
            this.ghk.a(this.iFn);
        }
    }

    public void uU(boolean z) {
        this.lBE.setIsFromCDN(z);
    }

    public Button dnE() {
        return this.lCa;
    }

    public void dnF() {
        if (this.lBo != 2) {
            this.lBt.setNextPage(this.iPZ);
            this.lBo = 2;
        }
    }

    public void dnG() {
        if (com.baidu.tbadk.n.m.bBK().isSmallFlow()) {
            int lastVisiblePosition = this.lBt.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.lBt.getChildAt(i);
                if (childAt != null) {
                    TbRichTextView tbRichTextView = (TbRichTextView) childAt.findViewById(R.id.richText);
                    if (tbRichTextView != null) {
                        for (int i2 = 0; i2 < tbRichTextView.getChildCount(); i2++) {
                            View childAt2 = tbRichTextView.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog = tbImageView.getPerfLog();
                                perfLog.setSubType(1001);
                                perfLog.fup = true;
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
                        perfLog2.fup = true;
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

    public boolean dnH() {
        return this.abp != null && this.abp.getVisibility() == 0;
    }

    public boolean dnI() {
        return this.abp != null && this.abp.byR();
    }

    public void dnJ() {
        if (this.abp != null) {
            this.abp.bxk();
        }
    }

    public void uV(boolean z) {
        if (this.lCc != null) {
            uT(this.lpX.djH().bzB());
            if (this.lBY) {
                uK(z);
            } else {
                uL(z);
            }
        }
    }

    public void dnK() {
        if (this.lCc != null) {
            this.lCb.setVisibility(8);
            this.lCc.setVisibility(8);
            this.lCl = false;
            if (this.lCA != null) {
                this.lCA.setVisibility(8);
                uP(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.ifn == null) {
            this.ifn = new com.baidu.tbadk.core.view.a(this.lpX.getPageContext());
        }
        this.ifn.setDialogVisiable(true);
    }

    public void cgz() {
        if (this.ifn != null) {
            this.ifn.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.lBt.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.lBt.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lBv != null) {
            this.lBv.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.lDp = getScrollY();
            this.lCz.lDE = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lCz));
            a(this.lCz.lDE, true);
        }
    }

    public void uW(boolean z) {
        if (this.lBv != null) {
            this.lBv.uW(z);
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
        if (this.lBv != null) {
            this.lBv.onScroll(absListView, i, i2, i3);
        }
        if (this.lBp != null && this.lBy != null) {
            this.lBp.dv(this.lBy.dom());
        }
        this.lCz.lgS = i;
        this.lCz.headerCount = this.lBt.getHeaderViewsCount();
        this.lCz.lDE = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lCz));
        uM(b(absListView, i));
        a(this.lCz.lDE, false);
        if (this.iPZ.brK() && !this.iPZ.eTP) {
            if (this.lCz != null && this.lCz.lDE != null && this.lCz.lDE.getView() != null) {
                i4 = this.lCz.lDE.getView().getTop() < 0 ? this.lCz.lDE.getView().getHeight() : this.lCz.lDE.getView().getBottom();
            }
            this.iPZ.qs(i4);
            this.iPZ.eTP = true;
        }
    }

    public void dnL() {
        if (TbadkCoreApplication.isLogin() && this.lre != null && this.lCP && !this.lCO && !this.lBW && this.lCo != null && this.lCo.blC() != null && !this.lCo.blC().getIsLike() && !this.lCo.blC().hadConcerned() && this.lCL == null) {
            this.lCL = new av(this.lpX);
        }
    }

    public void dnM() {
        if (this.lpX != null) {
            if ((this.iHR || this.lDd == 17) && com.baidu.tbadk.a.d.bhq()) {
                if (this.lre != null && this.lre.getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(this.lre.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.lpX.getContext()).createNormalCfg(this.lre.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13853").dR("post_id", this.lre.getThreadId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fid", this.lre.getForum().getId()));
                }
            } else if (this.lCP && !this.lCO && this.lCo != null && this.lCo.blC() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12601").ak("obj_locate", this.lpX.diN() ? 2 : 1).ak("obj_type", this.lCO ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.lpX.getPageContext().getPageActivity(), this.lCo.blC().getUserId(), this.lCo.blC().getUserName(), this.lpX.diV().diO(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(au auVar, boolean z) {
        int measuredHeight;
        if (!this.lCO && this.lCt != null && this.lBp.doE() != null) {
            int djt = this.lBE.djt();
            if (djt > 0 && (auVar == null || auVar.getView().getParent() == null)) {
                if (djt > this.lBt.getFirstVisiblePosition() - this.lBt.getHeaderViewsCount()) {
                    this.lCt.setVisibility(4);
                    return;
                }
                this.lCt.setVisibility(0);
                uM(false);
                this.lBp.mNavigationBar.hideBottomLine();
                if (this.lCt.getParent() != null && ((ViewGroup) this.lCt.getParent()).getHeight() <= this.lCt.getTop()) {
                    this.lCt.getParent().requestLayout();
                }
            } else if (auVar == null || auVar.getView() == null || auVar.lAO == null) {
                if (this.lBt.getFirstVisiblePosition() == 0) {
                    this.lCt.setVisibility(4);
                    this.lBp.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = auVar.getView().getTop();
                if (auVar.getView().getParent() != null) {
                    if (this.lCy) {
                        this.lCx = top;
                        this.lCy = false;
                    }
                    this.lCx = top < this.lCx ? top : this.lCx;
                }
                if (top != 0 || auVar.getView().isShown()) {
                    if (this.lBD.getY() < 0.0f) {
                        measuredHeight = lCw - auVar.lAO.getMeasuredHeight();
                    } else {
                        measuredHeight = this.lBp.doE().getMeasuredHeight() - auVar.lAO.getMeasuredHeight();
                        this.lBp.mNavigationBar.hideBottomLine();
                    }
                    if (auVar.getView().getParent() == null && top <= this.lCx) {
                        this.lCt.setVisibility(0);
                        uM(false);
                    } else if (top < measuredHeight) {
                        this.lCt.setVisibility(0);
                        uM(false);
                    } else {
                        this.lCt.setVisibility(4);
                        this.lBp.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.lCy = true;
                    }
                }
            }
        }
    }

    public void dnN() {
        if (!this.lDq) {
            TiebaStatic.log("c10490");
            this.lDq = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lpX.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(lCD, Integer.valueOf(lCF));
            aVar.or(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.lpX.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.bg(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.lpX);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.23
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lpX.getPageContext()).bog();
        }
    }

    public void Pl(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lpX.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.lpX.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.bg(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(lCD, Integer.valueOf(lCG));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.lpX);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lpX.getPageContext()).bog();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.blC() != null) {
            MetaData blC = b.blC();
            blC.setGiftNum(blC.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        a(fVar, z, i, i2);
        this.lBy.onChangeSkinType(i2);
    }

    public PbInterviewStatusView dnO() {
        return this.lCr;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dhH() != null && fVar.dhH().bmM() && this.lCr == null) {
            this.lCr = (PbInterviewStatusView) this.lCq.inflate();
            this.lCr.setOnClickListener(this.iKO);
            this.lCr.setCallback(this.lpX.dks());
            this.lCr.setData(this.lpX, fVar);
        }
    }

    public RelativeLayout dnP() {
        return this.lBD;
    }

    public View dnQ() {
        return this.bCq;
    }

    public boolean dnR() {
        return this.lDf;
    }

    public void ub(boolean z) {
        this.lBy.ub(z);
    }

    public void Pm(String str) {
        if (this.lBq != null) {
            this.lBq.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int uX(boolean z) {
        if (this.lCr == null || this.lCr.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void dnS() {
        if (this.lCr != null && this.lCr.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lCr.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.lCr.setLayoutParams(layoutParams);
        }
    }

    public boolean djN() {
        return false;
    }

    public void Pn(String str) {
        this.jKO.performClick();
        if (!StringUtils.isNull(str) && this.lpX.djH() != null && this.lpX.djH().bzt() != null && this.lpX.djH().bzt().getInputView() != null) {
            EditText inputView = this.lpX.djH().bzt().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            dnA();
            if (configuration.orientation == 2) {
                dnK();
                dmG();
            } else {
                dmK();
            }
            if (this.lCK != null) {
                this.lCK.djC();
            }
            this.lpX.cyo();
            this.lBD.setVisibility(8);
            this.lBp.vj(false);
            this.lpX.uq(false);
            if (this.lBv != null) {
                if (configuration.orientation == 1) {
                    dnP().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.lBt.setIsLandscape(true);
                    this.lBt.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.lBt.setIsLandscape(false);
                    if (this.lDp > 0) {
                        this.lBt.smoothScrollBy(this.lDp, 0);
                    }
                }
                this.lBv.onConfigurationChanged(configuration);
                this.lCs.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void uY(boolean z) {
        if (this.lBv != null) {
            this.lBv.uY(z);
        }
    }

    public boolean dnT() {
        return this.lBv != null && this.lBv.dnT();
    }

    public void dnU() {
        if (this.lBv != null) {
            this.lBv.dnU();
        }
    }

    public void uf(boolean z) {
        this.lBE.uf(z);
    }

    public void du(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.lCc.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.lpX.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.lCU = new TextView(this.lpX.getContext());
            this.lCU.setText(R.string.connection_tips);
            this.lCU.setGravity(17);
            this.lCU.setPadding(com.baidu.adp.lib.util.l.getDimens(this.lpX.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.lpX.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lpX.getContext(), R.dimen.ds60);
            if (this.lCU.getParent() == null) {
                frameLayout.addView(this.lCU, layoutParams);
            }
            this.lCT = new PopupWindow(this.lpX.getContext());
            this.lCT.setContentView(frameLayout);
            this.lCT.setHeight(-2);
            this.lCT.setWidth(-2);
            this.lCT.setFocusable(true);
            this.lCT.setOutsideTouchable(false);
            this.lCT.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.lBt.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.25
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        az.this.lCT.showAsDropDown(az.this.lCc, view.getLeft(), -az.this.lCc.getHeight());
                    } else {
                        az.this.lCT.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void uZ(boolean z) {
        this.lCZ = z;
    }

    public boolean dnV() {
        return this.lCZ;
    }

    public PbThreadPostView dnW() {
        return this.lBu;
    }

    private void z(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dhH() != null && !fVar.dhH().bki()) {
            boolean z = fVar.dhH().bly() == 1;
            boolean z2 = fVar.dhH().blx() == 1;
            if (this.lBy != null) {
                this.lBy.c(fVar, z, z2);
            }
            if (this.lBE != null && this.lBE.djy() != null) {
                this.lBE.djy().b(fVar, z, z2);
            }
        }
    }

    public void va(boolean z) {
        this.iHR = z;
    }

    public void GA(int i) {
        this.lDd = i;
    }

    public void dnX() {
        if (this.lBt != null) {
            this.lBt.setForbidDragListener(true);
        }
    }

    public boolean dkM() {
        if (this.lBt == null) {
            return false;
        }
        return this.lBt.dkM();
    }

    public boolean dnY() {
        if (this.iPZ == null || TextUtils.isEmpty(this.iPZ.getEndText())) {
            return false;
        }
        return this.iPZ.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }

    private boolean A(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dhH() == null) {
            return false;
        }
        SpannableStringBuilder bmm = fVar.dhH().bmm();
        if (bmm != null) {
            return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(bmm.toString());
        }
        return true;
    }
}
