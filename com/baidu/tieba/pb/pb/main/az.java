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
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.by;
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
import com.baidu.tieba.NEGFeedBack.f;
import com.baidu.tieba.NEGFeedBack.i;
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
    private EditorTools acn;
    private View bHy;
    private RelativeLayout bIq;
    private View bJa;
    private View fBr;
    private f.c fci;
    private com.baidu.tieba.pb.a.c fos;
    private NoNetworkView gpu;
    private boolean iSJ;
    private View.OnClickListener iVH;
    private List<CustomBlueCheckRadioButton> ilT;
    private boolean isLandscape;
    private com.baidu.tieba.NEGFeedBack.f jBZ;
    private TextView jYr;
    private PbListView jaQ;
    private NavigationBarCoverTip jyH;
    private PbFragment lDG;
    private View.OnClickListener lED;
    private com.baidu.tieba.pb.data.f lEN;
    private PbFakeFloorModel lHi;
    PbFragment.c lIZ;
    private View lPM;
    private View lPO;
    private View lPP;
    private LinearLayout lPQ;
    private HeadImageView lPR;
    private ImageView lPS;
    private ImageView lPT;
    private ImageView lPU;
    private com.baidu.tieba.pb.view.d lPV;
    private TextView lPW;
    private TextView lPX;
    private int lPZ;
    public int lPa;
    public final com.baidu.tieba.pb.pb.main.view.c lPc;
    public com.baidu.tieba.pb.pb.main.view.b lPd;
    private ViewStub lPe;
    private ViewStub lPf;
    private PbLandscapeListView lPg;
    private PbThreadPostView lPh;
    private com.baidu.tieba.pb.pb.main.a.e lPi;
    private com.baidu.tieba.pb.pb.main.a.a lPj;
    private com.baidu.tieba.pb.pb.main.a.c lPk;
    private com.baidu.tieba.pb.pb.main.a.d lPl;
    private com.baidu.tieba.pb.pb.main.a.b lPm;
    private LinearLayout lPn;
    private TextView lPo;
    private TextView lPp;
    private ObservedChangeRelativeLayout lPq;
    private g lPr;
    private View lPx;
    private int lQE;
    private PbTopTipView lQF;
    private PopupWindow lQG;
    private TextView lQH;
    private List<String> lQI;
    private com.baidu.tieba.pb.pb.main.emotion.c lQJ;
    private com.baidu.tieba.pb.pb.godreply.a lQK;
    private PbLandscapeListView.b lQL;
    private al lQN;
    private com.baidu.tieba.NEGFeedBack.i lQO;
    private String lQP;
    private long lQQ;
    private int lQR;
    private com.baidu.tieba.pb.view.c lQU;
    private boolean lQW;
    private int lQa;
    private PostData lQb;
    private ViewStub lQd;
    private PbInterviewStatusView lQe;
    private FrameLayout lQf;
    private View lQg;
    private View lQh;
    private au lQi;
    private PbEmotionBar lQn;
    private int lQv;
    private Runnable lQw;
    private v lQx;
    private av lQy;
    private Runnable lRa;
    private PbFragment.b lRc;
    public int lRg;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int lQj = UtilHelper.getLightStatusBarHeight();
    public static int lQp = 3;
    public static int lQq = 0;
    public static int lQr = 3;
    public static int lQs = 4;
    public static int lQt = 5;
    public static int lQu = 6;
    private static final int lQS = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
    private static a.InterfaceC0868a lQV = new a.InterfaceC0868a() { // from class: com.baidu.tieba.pb.pb.main.az.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0868a
        public void onRefresh() {
        }
    };
    private int lPb = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a lPs = null;
    private com.baidu.tbadk.core.dialog.b iVG = null;
    private View lPt = null;
    private EditText lPu = null;
    private com.baidu.tieba.pb.view.e lPv = null;
    private com.baidu.tieba.pb.view.a lPw = null;
    private b.InterfaceC0586b kwT = null;
    private TbRichTextView.i fNk = null;
    private NoNetworkView.a iQf = null;
    private com.baidu.tbadk.core.dialog.i lPy = null;
    private com.baidu.tbadk.core.dialog.a lPz = null;
    private Dialog lPA = null;
    private Dialog lPB = null;
    private View lPC = null;
    private LinearLayout lPD = null;
    private CompoundButton.OnCheckedChangeListener ilU = null;
    private TextView lPE = null;
    private TextView lPF = null;
    private String lPG = null;
    private com.baidu.tbadk.core.dialog.i lHY = null;
    private com.baidu.tbadk.core.dialog.i lPH = null;
    private boolean lPI = false;
    private boolean lPJ = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView lPK = null;
    private boolean lPL = false;
    private Button lPN = null;
    private boolean lPY = true;
    private com.baidu.tbadk.core.view.a iqh = null;
    private boolean lEv = false;
    private int mSkinType = 3;
    private boolean lQc = false;
    private int lQk = 0;
    private boolean lQl = true;
    public a lQm = new a();
    private int lQo = 0;
    private boolean lQz = false;
    private int lQA = 0;
    private boolean lQB = false;
    private boolean lQC = false;
    private boolean lQD = false;
    private boolean lQM = false;
    private int lQT = 0;
    private String lQX = null;
    private CustomMessageListener lQY = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.az.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                az.this.lQX = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.az.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && az.this.lPr != null) {
                az.this.lPr.notifyDataSetChanged();
            }
        }
    };
    private Handler lQZ = new Handler();
    private CustomMessageListener lRb = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.az.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                az.this.lPY = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean lRd = true;
    View.OnClickListener lRe = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || az.this.lEN == null || az.this.lEN.dmT() == null || az.this.lEN.dmT().boP() == null || az.this.lEN.dmT().boP().getAlaInfo() == null || az.this.lEN.dmT().boP().getAlaInfo().live_status != 1) {
                if (az.this.lQB) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11923").al("obj_id", 2));
                }
                if (!az.this.lQB && az.this.lEN != null && az.this.lEN.dmT() != null && az.this.lEN.dmT().boP() != null && az.this.lEN.dmT().boP().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12151").al("obj_locate", 1));
                }
                if (az.this.lDG.dpQ() != null) {
                    az.this.lDG.dpQ().lDS.iCq.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c11851");
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(arVar);
            if (az.this.lEN.dmT().boP().getAlaInfo() == null || !az.this.lEN.dmT().boP().getAlaInfo().isChushou) {
                if (az.this.lEN.dmT().boP().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = az.this.lEN.dmT().boP().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(az.this.lDG.dpQ(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            bf.bua().b(az.this.lDG.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + az.this.lEN.dmT().boP().getAlaInfo().thirdRoomId + "&livetype=" + az.this.lEN.dmT().boP().getAlaInfo().thirdLiveType});
        }
    };
    private boolean bjg = false;
    String userId = null;
    private final List<TbImageView> lRf = new ArrayList();
    private boolean lRh = false;

    /* loaded from: classes22.dex */
    public static class a {
        public int headerCount;
        public au lRv;
        public int lus;
    }

    public void vm(boolean z) {
        this.lQz = z;
        if (this.lPg != null) {
            this.lQA = this.lPg.getHeaderViewsCount();
        }
    }

    public void drV() {
        if (this.lPg != null) {
            int headerViewsCount = this.lPg.getHeaderViewsCount() - this.lQA;
            final int firstVisiblePosition = (this.lPg.getFirstVisiblePosition() == 0 || this.lPg.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.lPg.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.lPg.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.lQm.lRv = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lQm));
            final au auVar = this.lQm.lRv;
            final int g = g(auVar);
            final int y = ((int) this.lPq.getY()) + this.lPq.getMeasuredHeight();
            final boolean z = this.lQg.getVisibility() == 0;
            boolean z2 = this.lPq.getY() < 0.0f;
            if ((z && auVar != null) || firstVisiblePosition >= this.lPr.doI() + this.lPg.getHeaderViewsCount()) {
                int measuredHeight = auVar != null ? auVar.lOB.getMeasuredHeight() : 0;
                if (z2) {
                    this.lPg.setSelectionFromTop(this.lPr.doI() + this.lPg.getHeaderViewsCount(), lQj - measuredHeight);
                } else {
                    this.lPg.setSelectionFromTop(this.lPr.doI() + this.lPg.getHeaderViewsCount(), this.lPc.dtV().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.lPg.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.lQB && this.lPi != null) {
                this.lPg.setSelectionFromTop(this.lPr.doI() + this.lPg.getHeaderViewsCount(), this.lPi.dtH());
            } else if (this.mType == 6) {
                this.lPg.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.az.1
                    @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.a
                    public void onLayout() {
                        ViewGroup.LayoutParams layoutParams;
                        if (g >= 0 && g <= az.this.bIq.getMeasuredHeight()) {
                            int g2 = az.this.g(auVar);
                            int i = g2 - g;
                            if (z && i != 0 && g <= y) {
                                i = g2 - y;
                            }
                            if (az.this.bJa != null && (layoutParams = az.this.bJa.getLayoutParams()) != null) {
                                if (i == 0 || i > az.this.bIq.getMeasuredHeight() || g2 >= az.this.bIq.getMeasuredHeight()) {
                                    layoutParams.height = az.this.lQv;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > az.this.bIq.getMeasuredHeight()) {
                                    layoutParams.height = az.this.lQv;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    az.this.lPg.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                az.this.bJa.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (az.this.bJa != null && az.this.bJa.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = az.this.bJa.getLayoutParams();
                                            layoutParams2.height = az.this.lQv;
                                            az.this.bJa.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        az.this.lPg.setOnLayoutListener(null);
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

    public NoNetworkView drW() {
        return this.gpu;
    }

    public void drX() {
        if (this.acn != null) {
            this.acn.hide();
            if (this.lQJ != null) {
                this.lQJ.dtJ();
            }
        }
    }

    public PbFakeFloorModel drY() {
        return this.lHi;
    }

    public v drZ() {
        return this.lQx;
    }

    public com.baidu.tieba.pb.pb.main.a.e dsa() {
        return this.lPi;
    }

    public void dsb() {
        reset();
        drX();
        this.lQx.doR();
        vy(false);
    }

    private void reset() {
        if (this.lDG != null && this.lDG.doW() != null && this.acn != null) {
            com.baidu.tbadk.editortools.pb.a.bCQ().setStatus(0);
            com.baidu.tbadk.editortools.pb.e doW = this.lDG.doW();
            doW.bDl();
            doW.bCA();
            if (doW.getWriteImagesInfo() != null) {
                doW.getWriteImagesInfo().setMaxImagesAllowed(doW.isBJH ? 1 : 9);
            }
            doW.st(SendView.ALL);
            doW.su(SendView.ALL);
            com.baidu.tbadk.editortools.h sg = this.acn.sg(23);
            com.baidu.tbadk.editortools.h sg2 = this.acn.sg(2);
            com.baidu.tbadk.editortools.h sg3 = this.acn.sg(5);
            if (sg2 != null) {
                sg2.su();
            }
            if (sg3 != null) {
                sg3.su();
            }
            if (sg != null) {
                sg.hide();
            }
            this.acn.invalidate();
        }
    }

    public boolean dsc() {
        return this.lPY;
    }

    public void vn(boolean z) {
        if (this.lPP != null && this.jYr != null) {
            this.jYr.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lPP.startAnimation(alphaAnimation);
            }
            this.lPO.setVisibility(0);
            this.lPP.setVisibility(0);
            this.lPY = true;
            if (this.lQn != null && !this.lQK.isActive()) {
                this.lQn.setVisibility(0);
                vs(true);
            }
        }
    }

    public void vo(boolean z) {
        if (this.lPP != null && this.jYr != null) {
            this.jYr.setText(dsd());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lPP.startAnimation(alphaAnimation);
            }
            this.lPO.setVisibility(0);
            this.lPP.setVisibility(0);
            this.lPY = true;
            if (this.lQn != null && !this.lQK.isActive()) {
                this.lQn.setVisibility(0);
                vs(true);
            }
        }
    }

    public String dsd() {
        if (!com.baidu.tbadk.core.util.au.isEmpty(this.lQP)) {
            return this.lQP;
        }
        if (this.lDG != null) {
            this.lQP = TbadkCoreApplication.getInst().getResources().getString(ay.drT());
        }
        return this.lQP;
    }

    public PostData dse() {
        int i = 0;
        if (this.lPg == null) {
            return null;
        }
        int dsf = dsf() - this.lPg.getHeaderViewsCount();
        if (dsf < 0) {
            dsf = 0;
        }
        if (this.lPr.GV(dsf) != null && this.lPr.GV(dsf) != PostData.nlG) {
            i = dsf + 1;
        }
        return this.lPr.getItem(i) instanceof PostData ? (PostData) this.lPr.getItem(i) : null;
    }

    public int dsf() {
        int i;
        View childAt;
        if (this.lPg == null) {
            return 0;
        }
        int firstVisiblePosition = this.lPg.getFirstVisiblePosition();
        int lastVisiblePosition = this.lPg.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.lPg.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.lPg.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int dsg() {
        return this.lPg.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.lEN != null && this.lEN.dmV() != null && !this.lEN.dmV().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.lEN.dmV().size() && (postData = this.lEN.dmV().get(i)) != null && postData.boP() != null && !StringUtils.isNull(postData.boP().getUserId()); i++) {
                if (this.lEN.dmV().get(i).boP().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.lQK != null && this.lQK.isActive()) {
                        vy(false);
                    }
                    if (this.lQn != null) {
                        this.lQn.vI(true);
                    }
                    this.lQX = postData.boP().getName_show();
                    return;
                }
            }
        }
    }

    public az(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.lDG = null;
        this.bIq = null;
        this.bHy = null;
        this.lPg = null;
        this.lPr = null;
        this.jaQ = null;
        this.fBr = null;
        this.iVH = null;
        this.lED = null;
        this.lPP = null;
        this.jYr = null;
        this.lQd = null;
        this.lQE = 0;
        this.lQQ = 0L;
        this.lQQ = System.currentTimeMillis();
        this.lDG = pbFragment;
        this.iVH = onClickListener;
        this.fos = cVar;
        this.lQE = com.baidu.adp.lib.util.l.getEquipmentWidth(this.lDG.getContext()) / 8;
        this.bIq = (RelativeLayout) LayoutInflater.from(this.lDG.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bIq.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.lPM = this.bIq.findViewById(R.id.bottom_shadow);
        this.jyH = (NavigationBarCoverTip) this.bIq.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.bHy = this.bIq.findViewById(R.id.statebar_view);
        this.lPq = (ObservedChangeRelativeLayout) this.bIq.findViewById(R.id.title_wrapper);
        this.gpu = (NoNetworkView) this.bIq.findViewById(R.id.view_no_network);
        this.lPg = (PbLandscapeListView) this.bIq.findViewById(R.id.new_pb_list);
        this.lQf = (FrameLayout) this.bIq.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.lDG.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.lDG.getActivity(), R.dimen.ds88));
        this.lPg.addHeaderView(this.textView, 0);
        this.lPg.setTextViewAdded(true);
        this.lQv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bJa = new View(this.lDG.getPageContext().getPageActivity());
        this.bJa.setLayoutParams(new AbsListView.LayoutParams(-1, this.lQv));
        this.bJa.setVisibility(4);
        this.lPg.addFooterView(this.bJa);
        this.lPg.setOnTouchListener(this.lDG.fGd);
        this.lPc = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bIq);
        if (this.lDG.dpz()) {
            this.lPe = (ViewStub) this.bIq.findViewById(R.id.manga_view_stub);
            this.lPe.setVisibility(0);
            this.lPd = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.lPd.show();
            this.lPc.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lDG.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.lPc.dtV().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0824a() { // from class: com.baidu.tieba.pb.pb.main.az.27
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0824a
            public void dnW() {
                if (az.this.lPg != null) {
                    if (az.this.lPi != null) {
                        az.this.lPi.dtG();
                    }
                    az.this.lPg.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0824a
            public void dnX() {
                az.this.lDG.cCF();
            }
        }));
        this.lPO = this.bIq.findViewById(R.id.view_comment_top_line);
        this.lPP = this.bIq.findViewById(R.id.pb_editor_tool_comment);
        this.lPZ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lQa = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lPR = (HeadImageView) this.bIq.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lPR.setVisibility(0);
        this.lPR.setIsRound(true);
        this.lPR.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.lDG.getContext(), R.dimen.L_X01));
        this.lPR.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0401));
        this.lPR.setPlaceHolder(0);
        dsh();
        this.jYr = (TextView) this.bIq.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lPQ = (LinearLayout) this.bIq.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lPQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.lDG.dph();
                if (az.this.lDG != null && az.this.lDG.dok() != null && az.this.lDG.dok().getPbData() != null && az.this.lDG.dok().getPbData().dmT() != null && az.this.lDG.dok().getPbData().dmT().boP() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13701").dY("tid", az.this.lDG.dok().dqk()).dY("fid", az.this.lDG.dok().getPbData().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dY("tid", az.this.lDG.dok().lLh).dY("fid", az.this.lDG.dok().getPbData().getForumId()).al("obj_locate", 1).dY("uid", az.this.lDG.dok().getPbData().dmT().boP().getUserId()));
                }
            }
        });
        this.lPS = (ImageView) this.bIq.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lPS.setOnClickListener(this.iVH);
        boolean booleanExtra = this.lDG.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lPT = (ImageView) this.bIq.findViewById(R.id.pb_editor_tool_collection);
        this.lPT.setOnClickListener(this.iVH);
        if (booleanExtra) {
            this.lPT.setVisibility(8);
        } else {
            this.lPT.setVisibility(0);
        }
        this.lPU = (ImageView) this.bIq.findViewById(R.id.pb_editor_tool_share);
        this.lPU.setOnClickListener(this.iVH);
        this.lPV = new com.baidu.tieba.pb.view.d(this.lPU);
        this.lPV.dxp();
        this.lPW = (TextView) this.bIq.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lPW.setVisibility(0);
        this.lQd = (ViewStub) this.bIq.findViewById(R.id.interview_status_stub);
        this.lPj = new com.baidu.tieba.pb.pb.main.a.a(this.lDG, cVar);
        this.lPl = new com.baidu.tieba.pb.pb.main.a.d(this.lDG, cVar, this.iVH);
        this.lPr = new g(this.lDG, this.lPg);
        this.lPr.F(this.iVH);
        this.lPr.setTbGestureDetector(this.fos);
        this.lPr.setOnImageClickListener(this.fNk);
        this.lPr.setOnSwitchChangeListener(this.lDG.lIS);
        this.lED = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.29
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
                            az.this.lDG.c(sparseArray);
                            return;
                        }
                        az.this.dD(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        az.this.lDG.c(sparseArray);
                    } else if (booleanValue3) {
                        az.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.lPr.S(this.lED);
        dsm();
        dsn();
        this.lPk.b(this.lPg);
        this.lPl.b(this.lPg);
        this.lPj.b(this.lPg);
        this.jaQ = new PbListView(this.lDG.getPageContext().getPageActivity());
        this.fBr = this.jaQ.getView().findViewById(R.id.pb_more_view);
        if (this.fBr != null) {
            this.fBr.setOnClickListener(this.iVH);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.fBr, R.drawable.pb_foot_more_trans_selector);
        }
        this.jaQ.setLineVisible();
        this.jaQ.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.jaQ.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.lPx = this.bIq.findViewById(R.id.viewstub_progress);
        this.lDG.registerListener(this.lRb);
        this.lHi = new PbFakeFloorModel(this.lDG.getPageContext());
        this.lQx = new v(this.lDG.getPageContext(), this.lHi, this.bIq);
        this.lQx.T(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.dsb();
            }
        });
        this.lQx.a(this.lDG.lIU);
        this.lHi.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.az.31
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                az.this.lHi.u(postData);
                az.this.lPr.notifyDataSetChanged();
                az.this.lQx.doR();
                az.this.acn.bAK();
                az.this.vy(false);
            }
        });
        if (this.lDG.dok() != null && !StringUtils.isNull(this.lDG.dok().dqT())) {
            this.lDG.showToast(this.lDG.dok().dqT());
        }
        this.lQg = this.bIq.findViewById(R.id.pb_expand_blank_view);
        this.lQh = this.bIq.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lQh.getLayoutParams();
        if (this.lDG.dok() != null && this.lDG.dok().dqn()) {
            this.lQg.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.lQh.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = lQj;
            this.lQh.setLayoutParams(layoutParams2);
        }
        this.lQi = new au(this.lDG.getPageContext(), this.bIq.findViewById(R.id.pb_reply_expand_view));
        this.lQi.v(pbFragment.lHN);
        this.lQi.lOB.setVisibility(8);
        this.lQi.U(this.iVH);
        this.lQi.setOnSwitchChangeListener(this.lDG.lIS);
        this.lDG.registerListener(this.mAccountChangedListener);
        this.lDG.registerListener(this.lQY);
        dsi();
        vs(false);
        this.lQU = new com.baidu.tieba.pb.view.c(this.lDG.getPageContext());
    }

    private void dsh() {
        if (this.lPR != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lPR.setImageResource(0);
            this.lPR.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.lPR.setImageResource(R.drawable.transparent_bg);
    }

    public void vp(boolean z) {
        this.lPM.setVisibility(z ? 0 : 8);
    }

    public void cQX() {
        if (!this.lDG.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").al("obj_locate", 2).dY("fid", this.mForumId));
        } else if (this.lDG.dpj()) {
            com.baidu.tbadk.editortools.pb.e doW = this.lDG.doW();
            if (doW != null && (doW.bDi() || doW.bDj())) {
                this.lDG.doW().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.acn != null) {
                dss();
            }
            if (this.acn != null) {
                this.lPY = false;
                if (this.acn.sj(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.lDG.getPageContext(), (View) this.acn.sj(2).fub, false, lQV);
                }
            }
            dta();
        }
    }

    private void dsi() {
        this.lQK = new com.baidu.tieba.pb.pb.godreply.a(this.lDG, this, (ViewStub) this.bIq.findViewById(R.id.more_god_reply_popup));
        this.lQK.B(this.iVH);
        this.lQK.S(this.lED);
        this.lQK.setOnImageClickListener(this.fNk);
        this.lQK.B(this.iVH);
        this.lQK.setTbGestureDetector(this.fos);
    }

    public com.baidu.tieba.pb.pb.godreply.a dsj() {
        return this.lQK;
    }

    public View dsk() {
        return this.lQg;
    }

    public void dsl() {
        if (this.lPg != null) {
            this.lPk.c(this.lPg);
            this.lPl.c(this.lPg);
            this.lPm.c(this.lPg);
            this.lPj.c(this.lPg);
        }
    }

    private void dsm() {
        if (this.lPm == null) {
            this.lPm = new com.baidu.tieba.pb.pb.main.a.b(this.lDG, this.iVH);
        }
    }

    private void dsn() {
        if (this.lPk == null) {
            this.lPk = new com.baidu.tieba.pb.pb.main.a.c(this.lDG, this.fos);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dso() {
        if (this.lDG.dpz()) {
            this.lPf = (ViewStub) this.bIq.findViewById(R.id.manga_mention_controller_view_stub);
            this.lPf.setVisibility(0);
            if (this.lPn == null) {
                this.lPn = (LinearLayout) this.bIq.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.lDG.getPageContext(), this.lPn);
            }
            if (this.lPo == null) {
                this.lPo = (TextView) this.lPn.findViewById(R.id.manga_prev_btn);
            }
            if (this.lPp == null) {
                this.lPp = (TextView) this.lPn.findViewById(R.id.manga_next_btn);
            }
            this.lPo.setOnClickListener(this.iVH);
            this.lPp.setOnClickListener(this.iVH);
        }
    }

    private void dsp() {
        if (this.lDG.dpz()) {
            if (this.lDG.dpC() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lPo, R.color.CAM_X0110, 1);
            }
            if (this.lDG.dpD() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lPp, R.color.CAM_X0110, 1);
            }
        }
    }

    public void dsq() {
        if (this.lPn == null) {
            dso();
        }
        this.lPf.setVisibility(8);
        if (this.lQZ != null && this.lRa != null) {
            this.lQZ.removeCallbacks(this.lRa);
        }
    }

    public void dsr() {
        if (this.lQZ != null) {
            if (this.lRa != null) {
                this.lQZ.removeCallbacks(this.lRa);
            }
            this.lRa = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.3
                @Override // java.lang.Runnable
                public void run() {
                    if (az.this.lPn == null) {
                        az.this.dso();
                    }
                    az.this.lPf.setVisibility(0);
                }
            };
            this.lQZ.postDelayed(this.lRa, 2000L);
        }
    }

    public void vq(boolean z) {
        this.lPc.vq(z);
        if (z && this.lQc) {
            this.jaQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.lPg.setNextPage(this.jaQ);
            this.lPb = 2;
        }
        dsh();
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acn = editorTools;
        this.acn.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.dsb();
            }
        });
        this.acn.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.acn.getParent() == null) {
            this.bIq.addView(this.acn, layoutParams);
        }
        this.acn.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.acn.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.az.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u) {
                    if (((com.baidu.tbadk.coreExtra.data.u) aVar.data).bxC() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.u) aVar.data).bxC() == EmotionGroupType.USER_COLLECT) {
                        if (az.this.mPermissionJudgePolicy == null) {
                            az.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        az.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        az.this.mPermissionJudgePolicy.appendRequestPermission(az.this.lDG.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!az.this.mPermissionJudgePolicy.startRequestPermission(az.this.lDG.getBaseFragmentActivity())) {
                            az.this.lDG.doW().c((com.baidu.tbadk.coreExtra.data.u) aVar.data);
                            az.this.lDG.doW().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        drX();
        this.lDG.doW().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.az.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (az.this.acn != null && az.this.acn.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (az.this.lQJ == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, az.this.acn.getId());
                            az.this.lQJ = new com.baidu.tieba.pb.pb.main.emotion.c(az.this.lDG.getPageContext(), az.this.bIq, layoutParams2);
                            if (!com.baidu.tbadk.core.util.y.isEmpty(az.this.lQI)) {
                                az.this.lQJ.setData(az.this.lQI);
                            }
                            az.this.lQJ.c(az.this.acn);
                        }
                        az.this.lQJ.Qz(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (az.this.lDG.kNk != null && az.this.lDG.kNk.dts() != null) {
                    if (!az.this.lDG.kNk.dts().dYp()) {
                        az.this.lDG.kNk.vE(false);
                    }
                    az.this.lDG.kNk.dts().zc(false);
                }
            }
        });
    }

    public void dss() {
        if (this.lDG != null && this.acn != null) {
            this.acn.su();
            if (this.lDG.doW() != null) {
                this.lDG.doW().bCY();
            }
            dta();
        }
    }

    public void vr(boolean z) {
        if (this.lPg != null && this.textView != null && this.bHy != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bHy.setVisibility(0);
                } else {
                    this.bHy.setVisibility(8);
                    this.lPg.removeHeaderView(this.textView);
                    this.lPg.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = lQj;
                    this.textView.setLayoutParams(layoutParams);
                }
                dsH();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + vA(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            dsH();
            dti();
        }
    }

    public g dst() {
        return this.lPr;
    }

    public void a(PbFragment.c cVar) {
        this.lIZ = cVar;
    }

    public void dD(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lDG.getContext());
        kVar.setTitleText(this.lDG.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.lPy.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 10:
                            az.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 11:
                            if (az.this.lRc != null) {
                                az.this.lRc.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 12:
                            az.this.lDG.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.lDG.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.lDG.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eNK.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !dth()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(11, this.lDG.getString(R.string.forbidden_person), kVar);
            gVar3.eNK.setTag(sparseArray3);
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
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.lDG.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.lDG.getString(R.string.mute), kVar);
            }
            gVar.eNK.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.k(com.baidu.tieba.pb.pb.main.d.a.fs(arrayList), true);
        this.lPy = new com.baidu.tbadk.core.dialog.i(this.lDG.getPageContext(), kVar);
        this.lPy.RU();
    }

    public void a(PbFragment.b bVar) {
        this.lRc = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.lDG != null && aVar != null) {
            if (this.jBZ == null && this.lPj != null) {
                this.jBZ = new com.baidu.tieba.NEGFeedBack.f(this.lDG.getPageContext(), this.lPj.dtC());
            }
            AntiData cBe = this.lDG.cBe();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBe != null && cBe.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBe.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.jBZ.setDefaultReasonArray(new String[]{this.lDG.getString(R.string.delete_thread_reason_1), this.lDG.getString(R.string.delete_thread_reason_2), this.lDG.getString(R.string.delete_thread_reason_3), this.lDG.getString(R.string.delete_thread_reason_4), this.lDG.getString(R.string.delete_thread_reason_5)});
            this.jBZ.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jBZ.Fj(str);
            this.jBZ.a(new f.b() { // from class: com.baidu.tieba.pb.pb.main.az.9
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void X(JSONArray jSONArray) {
                    az.this.lDG.a(aVar, jSONArray);
                }
            });
        }
    }

    private boolean dsu() {
        if (this.lDG == null || this.lDG.dok().getPbData().getForum().getDeletedReasonInfo() == null) {
            return false;
        }
        return 1 == this.lDG.dok().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i, com.baidu.tieba.NEGFeedBack.h hVar, UserData userData) {
        String str;
        if (this.lDG != null && aVar != null) {
            if (this.lQO == null && this.lPj != null) {
                this.lQO = new com.baidu.tieba.NEGFeedBack.i(this.lDG.getPageContext(), this.lPj.dtC(), hVar, userData);
            }
            AntiData cBe = this.lDG.cBe();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBe != null && cBe.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBe.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.lQO.setDefaultReasonArray(new String[]{this.lDG.getString(R.string.delete_thread_reason_1), this.lDG.getString(R.string.delete_thread_reason_2), this.lDG.getString(R.string.delete_thread_reason_3), this.lDG.getString(R.string.delete_thread_reason_4), this.lDG.getString(R.string.delete_thread_reason_5)});
            this.lQO.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.lQO.Fj(str);
            this.lQO.a(new i.b() { // from class: com.baidu.tieba.pb.pb.main.az.10
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void X(JSONArray jSONArray) {
                    az.this.lDG.a(aVar, jSONArray);
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
        sparseArray.put(lQq, Integer.valueOf(lQr));
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
        this.lPz = new com.baidu.tbadk.core.dialog.a(this.lDG.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lPz.oQ(i3);
        } else {
            this.lPz.setOnlyMessageShowCenter(false);
            this.lPz.Bq(str2);
        }
        this.lPz.setYesButtonTag(sparseArray);
        this.lPz.a(R.string.dialog_ok, this.lDG);
        this.lPz.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lPz.jl(true);
        this.lPz.b(this.lDG.getPageContext());
        if (z) {
            this.lPz.brv();
        } else if (dsu()) {
            com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(this.lDG.dok().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.lDG.dok().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.lDG.dok().getPbData().dnD().has_forum_rule.intValue());
            hVar.ek(this.lDG.dok().getPbData().getForum().getId(), this.lDG.dok().getPbData().getForum().getName());
            hVar.setForumHeadUrl(this.lDG.dok().getPbData().getForum().getImage_url());
            hVar.setUserLevel(this.lDG.dok().getPbData().getForum().getUser_level());
            a(this.lPz, i, hVar, this.lDG.dok().getPbData().getUserData());
        } else {
            a(this.lPz, i);
        }
    }

    public void bf(ArrayList<com.baidu.tbadk.core.data.ak> arrayList) {
        if (this.lPC == null) {
            this.lPC = LayoutInflater.from(this.lDG.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.lDG.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lPC);
        if (this.lPB == null) {
            this.lPB = new Dialog(this.lDG.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lPB.setCanceledOnTouchOutside(true);
            this.lPB.setCancelable(true);
            this.lPK = (ScrollView) this.lPC.findViewById(R.id.good_scroll);
            this.lPB.setContentView(this.lPC);
            WindowManager.LayoutParams attributes = this.lPB.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lPB.getWindow().setAttributes(attributes);
            this.ilU = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.az.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        az.this.lPG = (String) compoundButton.getTag();
                        if (az.this.ilT != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : az.this.ilT) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && az.this.lPG != null && !str.equals(az.this.lPG)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lPD = (LinearLayout) this.lPC.findViewById(R.id.good_class_group);
            this.lPF = (TextView) this.lPC.findViewById(R.id.dialog_button_cancel);
            this.lPF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (az.this.lPB instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(az.this.lPB, az.this.lDG.getPageContext());
                    }
                }
            });
            this.lPE = (TextView) this.lPC.findViewById(R.id.dialog_button_ok);
            this.lPE.setOnClickListener(this.iVH);
        }
        this.lPD.removeAllViews();
        this.ilT = new ArrayList();
        CustomBlueCheckRadioButton fY = fY("0", this.lDG.getPageContext().getString(R.string.thread_good_class));
        this.ilT.add(fY);
        fY.setChecked(true);
        this.lPD.addView(fY);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ak akVar = arrayList.get(i2);
                if (akVar != null && !TextUtils.isEmpty(akVar.bnd()) && akVar.bne() > 0) {
                    CustomBlueCheckRadioButton fY2 = fY(String.valueOf(akVar.bne()), akVar.bnd());
                    this.ilT.add(fY2);
                    View view = new View(this.lDG.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ap.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.lPD.addView(view);
                    this.lPD.addView(fY2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lPK.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lDG.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lDG.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lDG.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lPK.setLayoutParams(layoutParams2);
            this.lPK.removeAllViews();
            if (this.lPD != null && this.lPD.getParent() == null) {
                this.lPK.addView(this.lPD);
            }
        }
        com.baidu.adp.lib.f.g.a(this.lPB, this.lDG.getPageContext());
    }

    private CustomBlueCheckRadioButton fY(String str, String str2) {
        Activity pageActivity = this.lDG.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.ilU);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void dsv() {
        this.lDG.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.lDG.hideProgressBar();
        if (z && z2) {
            this.lDG.showToast(this.lDG.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.lDG.showToast(str);
        }
    }

    public void cYm() {
        this.lPx.setVisibility(0);
    }

    public void cYl() {
        this.lPx.setVisibility(8);
    }

    public View dsw() {
        if (this.lPC != null) {
            return this.lPC.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String dsx() {
        return this.lPG;
    }

    public View getView() {
        return this.bIq;
    }

    public void dsy() {
        if (this.lDG != null && this.lDG.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lDG.getPageContext().getPageActivity(), this.lDG.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.lDG.hideProgressBar();
        if (z) {
            dsR();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            dsS();
        } else {
            dsR();
        }
    }

    public void dsz() {
        this.jaQ.setLineVisible();
        this.jaQ.startLoadData();
    }

    public void dsA() {
        this.lDG.hideProgressBar();
        endLoadData();
        this.lPg.completePullRefreshPostDelayed(0L);
        dsM();
    }

    public void dsB() {
        this.lPg.completePullRefreshPostDelayed(0L);
        dsM();
    }

    private void vs(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.lPl.b(onLongClickListener);
        this.lPr.setOnLongClickListener(onLongClickListener);
        if (this.lQK != null) {
            this.lQK.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0586b interfaceC0586b, boolean z, boolean z2) {
        if (this.lHY != null) {
            this.lHY.dismiss();
            this.lHY = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lDG.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lDG.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lDG.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lDG.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lDG.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.bu(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.lPH.dismiss();
                interfaceC0586b.a(null, i, view);
            }
        });
        this.lPH = new com.baidu.tbadk.core.dialog.i(this.lDG.getPageContext(), kVar);
        this.lPH.RU();
    }

    public void a(final b.InterfaceC0586b interfaceC0586b, boolean z) {
        if (this.lPH != null) {
            this.lPH.dismiss();
            this.lPH = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lDG.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.lEN != null && this.lEN.dmT() != null && !this.lEN.dmT().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lDG.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lDG.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bu(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.16
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.lPH.dismiss();
                interfaceC0586b.a(null, i, view);
            }
        });
        this.lPH = new com.baidu.tbadk.core.dialog.i(this.lDG.getPageContext(), kVar);
        this.lPH.RU();
    }

    public int dsC() {
        return Hv(this.lPg.getFirstVisiblePosition());
    }

    private int Hv(int i) {
        com.baidu.adp.widget.ListView.f adapter = this.lPg.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.lPg.getAdapter() == null || !(this.lPg.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) ? 0 : this.lPg.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int dsD() {
        int lastVisiblePosition = this.lPg.getLastVisiblePosition();
        if (this.lPi != null) {
            if (lastVisiblePosition == this.lPg.getCount() - 1) {
                lastVisiblePosition--;
            }
            if (lastVisiblePosition < 0) {
                lastVisiblePosition = 0;
            }
        }
        return Hv(lastVisiblePosition);
    }

    public void Hw(int i) {
        int i2;
        LinearLayout.LayoutParams layoutParams;
        if (this.lPg != null) {
            if (this.lPc == null || this.lPc.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.lPc.mNavigationBar.getFixedNavHeight();
                if (this.lDG.dpp() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.lQh != null && (layoutParams = (LinearLayout.LayoutParams) this.lQh.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.lQh.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.lPg.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.lPg.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.lPg.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.lPu.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.lPr.a(fVar, false);
        this.lPr.notifyDataSetChanged();
        dsM();
        if (this.lQK != null) {
            this.lQK.bPF();
        }
        ArrayList<PostData> dmV = fVar.dmV();
        if (fVar.getPage().bnF() == 0 || dmV == null || dmV.size() < fVar.getPage().bnE()) {
            if (com.baidu.tbadk.core.util.y.getCount(dmV) == 0 || (com.baidu.tbadk.core.util.y.getCount(dmV) == 1 && dmV.get(0) != null && dmV.get(0).dPg() == 1)) {
                if (this.lQm == null || this.lQm.lRv == null || this.lQm.lRv.getView() == null) {
                    i = 0;
                } else {
                    i = this.lQm.lRv.getView().getTop() < 0 ? this.lQm.lRv.getView().getHeight() : this.lQm.lRv.getView().getBottom();
                }
                if (this.lDG.dpJ()) {
                    this.jaQ.ap(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.jaQ.ap(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().bnF() == 0) {
                    this.jaQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.jaQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.jaQ.bvi();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.lPj != null) {
            this.lPj.e(fVar, this.lEv);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dng() != null) {
            return fVar.dng();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dmV())) {
            Iterator<PostData> it = fVar.dmV().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dPg() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dnc();
        }
        if (!r(postData)) {
            postData = a(fVar);
        }
        if (postData != null && postData.boP() != null && postData.boP().getUserTbVipInfoData() != null && postData.boP().getUserTbVipInfoData().getvipIntro() != null) {
            postData.boP().getGodUserData().setIntro(postData.boP().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private boolean r(PostData postData) {
        if (postData == null || postData.boP() == null) {
            return false;
        }
        MetaData boP = postData.boP();
        return (TextUtils.isEmpty(boP.getUserId()) && TextUtils.isEmpty(boP.getAvater())) ? false : true;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dmT() == null || fVar.dmT().boP() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData boP = fVar.dmT().boP();
        String userId = boP.getUserId();
        HashMap<String, MetaData> userMap = fVar.dmT().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = boP;
        }
        postData.KV(1);
        postData.setId(fVar.dmT().bpg());
        postData.setTitle(fVar.dmT().getTitle());
        postData.setTime(fVar.dmT().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.dmT() != null) {
            if (this.lDG.doc()) {
                if (fVar.dmS() != null) {
                    this.mForumName = fVar.dmS().getForumName();
                    this.mForumId = fVar.dmS().getForumId();
                }
                if (this.mForumName == null && this.lDG.dok() != null && this.lDG.dok().dod() != null) {
                    this.mForumName = this.lDG.dok().dod();
                }
            }
            PostData b = b(fVar, z);
            a(b, fVar);
            this.lPl.setVisibility(8);
            if (fVar.dnu()) {
                this.lQB = true;
                this.lPc.vP(true);
                this.lPc.mNavigationBar.hideBottomLine();
                if (this.lPi == null) {
                    this.lPi = new com.baidu.tieba.pb.pb.main.a.e(this.lDG);
                }
                this.lPi.a(fVar, b, this.lPg, this.lPl, this.lQf, this.lPc, this.mForumName, this.lQQ);
                this.lPi.V(this.lRe);
                dsH();
            } else {
                this.lQB = false;
                this.lPc.vP(this.lQB);
                if (this.lPi != null) {
                    this.lPi.c(this.lPg);
                }
            }
            if (this.lDG.doZ() != null) {
                this.lDG.doZ().vJ(this.lQB);
            }
            if (b != null) {
                this.lQb = b;
                this.lPl.setVisibility(0);
                SparseArray<Object> dtF = this.lPl.dtF();
                dtF.put(R.id.tag_clip_board, b);
                dtF.put(R.id.tag_is_subpb, false);
                this.lPm.a(fVar, this.lPg);
                this.lPk.C(fVar);
                this.lPj.e(fVar, this.lEv);
                this.lPj.B(fVar);
                this.lPl.a(this.mSkinType, this.lEN, b, this.lRe);
                if (this.lQi != null) {
                    if (fVar.dnx()) {
                        this.lQi.getView().setVisibility(8);
                    } else {
                        this.lQi.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lCa);
                        if (fVar.dmT() != null) {
                            nVar.lCc = fVar.dmT().boG();
                        }
                        nVar.isNew = !this.lEv;
                        nVar.sortType = fVar.lAK;
                        nVar.lCe = fVar.dny();
                        nVar.lCf = this.lDG.dpJ();
                        nVar.lCg = fVar.lAJ;
                        this.lQi.a(nVar);
                    }
                }
                z(fVar);
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (az.this.lPr != null && az.this.lPc != null && az.this.lPc.lVB != null && az.this.lEN != null && az.this.lEN.dmT() != null && !az.this.lEN.dmT().bnv() && !az.this.dsL() && az.this.lEN.getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(az.this.lEN.getForum().getName())) {
                            if ((az.this.lPr.doM() == null || !az.this.lPr.doM().isShown()) && az.this.lPc.lVB != null) {
                                az.this.lPc.lVB.setVisibility(0);
                                if (az.this.lDG != null && az.this.lDG.dok() != null) {
                                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13400");
                                    arVar.dY("tid", az.this.lDG.dok().dqj());
                                    arVar.dY("fid", az.this.lDG.dok().getForumId());
                                    arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                                    TiebaStatic.log(arVar);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void vt(boolean z) {
        if (z) {
            dsE();
        } else {
            cwd();
        }
        this.lQm.lRv = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lQm));
        a(this.lQm.lRv, false);
    }

    public void dsE() {
        if (this.lPc != null && !this.lQD) {
            this.lPc.dsE();
            this.lQD = true;
        }
    }

    public void cwd() {
        if (this.lPc != null) {
            this.lPc.due();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.lPl.a(postData, fVar);
    }

    public void dsF() {
        if (this.lPi != null) {
            this.lPi.d(this.lPg);
        }
    }

    public boolean dsG() {
        return this.bjg;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aM(by byVar) {
        if (byVar == null || byVar.boP() == null) {
            return false;
        }
        PostData b = b(this.lEN, false);
        String str = "";
        if (b != null && b.boP() != null) {
            str = b.boP().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.lPc.dub();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.lPc.Lf(dVar.forumName);
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
            final String str2 = dVar.lAB;
            this.lDG.showNetRefreshView(this.bIq, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        bf.bua().b(az.this.lDG.getPageContext(), new String[]{str2});
                        az.this.lDG.finish();
                        return;
                    }
                    az.this.lDG.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable drJ;
        Parcelable drJ2;
        if (fVar != null && this.lPg != null) {
            this.lEN = fVar;
            this.mType = i;
            if (fVar.dmT() != null) {
                this.lQo = fVar.dmT().bow();
                if (fVar.dmT().getAnchorLevel() != 0) {
                    this.bjg = true;
                }
                this.lPJ = aM(fVar.dmT());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.lQc = false;
            this.lEv = z;
            dsA();
            if (fVar.lAL != null && fVar.lAL.dnF()) {
                if (this.lPh == null) {
                    this.lPh = new PbThreadPostView(this.lDG.getContext());
                    this.lPg.addHeaderView(this.lPh, 1);
                    this.lPh.setData(fVar);
                    this.lPh.setChildOnClickLinstener(this.iVH);
                }
            } else if (this.lPh != null && this.lPg != null) {
                this.lPg.removeHeaderView(this.lPh);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.lQN == null) {
                this.lQN = new al(this.lDG.getPageContext(), this.jyH);
            }
            this.lQN.Qp(fVar.dna());
            if (this.lDG.dpz()) {
                if (this.lPv == null) {
                    this.lPv = new com.baidu.tieba.pb.view.e(this.lDG.getPageContext());
                    this.lPv.createView();
                    this.lPv.setListPullRefreshListener(this.fci);
                }
                this.lPg.setPullRefresh(this.lPv);
                dsH();
                if (this.lPv != null) {
                    this.lPv.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().bnG() == 0 && z) {
                this.lPg.setPullRefresh(null);
            } else {
                if (this.lPv == null) {
                    this.lPv = new com.baidu.tieba.pb.view.e(this.lDG.getPageContext());
                    this.lPv.createView();
                    this.lPv.setListPullRefreshListener(this.fci);
                }
                this.lPg.setPullRefresh(this.lPv);
                dsH();
                if (this.lPv != null) {
                    this.lPv.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                ckt();
            }
            dsM();
            this.lPr.uz(this.lEv);
            this.lPr.uA(false);
            this.lPr.uE(i == 5);
            this.lPr.uF(i == 6);
            this.lPr.uG(z2 && this.lRd && i != 2);
            this.lPr.a(fVar, false);
            this.lPr.notifyDataSetChanged();
            this.lPl.b(b(fVar, z), fVar.dnx());
            if (fVar.dmT() != null && fVar.dmT().boA() != null && this.lPa != -1) {
                fVar.dmT().boA().setIsLike(this.lPa);
            }
            this.lPg.removeFooterView(this.bJa);
            this.lPg.addFooterView(this.bJa);
            if (TbadkCoreApplication.isLogin()) {
                this.lPg.setNextPage(this.jaQ);
                this.lPb = 2;
                ckt();
            } else {
                this.lQc = true;
                if (fVar.getPage().bnF() == 1) {
                    if (this.lPw == null) {
                        this.lPw = new com.baidu.tieba.pb.view.a(this.lDG, this.lDG);
                    }
                    this.lPg.setNextPage(this.lPw);
                } else {
                    this.lPg.setNextPage(this.jaQ);
                }
                this.lPb = 3;
            }
            ArrayList<PostData> dmV = fVar.dmV();
            if (fVar.getPage().bnF() == 0 || dmV == null || dmV.size() < fVar.getPage().bnE()) {
                if (com.baidu.tbadk.core.util.y.getCount(dmV) == 0 || (com.baidu.tbadk.core.util.y.getCount(dmV) == 1 && dmV.get(0) != null && dmV.get(0).dPg() == 1)) {
                    if (this.lQm == null || this.lQm.lRv == null || this.lQm.lRv.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.lQm.lRv.getView().getTop() < 0 ? this.lQm.lRv.getView().getHeight() : this.lQm.lRv.getView().getBottom();
                    }
                    if (this.lDG.dpJ()) {
                        this.jaQ.ap(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.jaQ.ap(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.lDG.doZ() != null && !this.lDG.doZ().dtP()) {
                        this.lDG.doZ().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().bnF() == 0) {
                        this.jaQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jaQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jaQ.bvi();
                }
                if (fVar.getPage().bnF() == 0 || dmV == null) {
                    dsW();
                }
            } else {
                if (z2) {
                    if (this.lRd) {
                        endLoadData();
                        if (fVar.getPage().bnF() != 0) {
                            this.jaQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.jaQ.setLineVisible();
                        this.jaQ.showLoading();
                    }
                } else {
                    this.jaQ.setLineVisible();
                    this.jaQ.showLoading();
                }
                this.jaQ.bvi();
            }
            switch (i) {
                case 2:
                    this.lPg.setSelection(i2 > 1 ? (((this.lPg.getData() == null && fVar.dmV() == null) ? 0 : (this.lPg.getData().size() - fVar.dmV().size()) + this.lPg.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (drJ2 = as.drI().drJ()) != null && !(drJ2 instanceof RecyclerView.SavedState)) {
                        this.lPg.onRestoreInstanceState(drJ2);
                        if (com.baidu.tbadk.core.util.y.getCount(dmV) > 1 && fVar.getPage().bnF() > 0) {
                            this.jaQ.endLoadData();
                            this.jaQ.setText(this.lDG.getString(R.string.pb_load_more_without_point));
                            this.jaQ.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.lRd = false;
                    break;
                case 5:
                    this.lPg.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (drJ = as.drI().drJ()) != null && !(drJ instanceof RecyclerView.SavedState)) {
                        this.lPg.onRestoreInstanceState(drJ);
                        break;
                    } else {
                        this.lPg.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.lPi != null && this.lPi.bSs() != null) {
                            if (this.lDG.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.lPg.setSelectionFromTop((this.lPr.doH() + this.lPg.getHeaderViewsCount()) - 1, this.lPi.dtH() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.lDG.getPageContext().getPageActivity()));
                            } else {
                                this.lPg.setSelectionFromTop((this.lPr.doH() + this.lPg.getHeaderViewsCount()) - 1, this.lPi.dtH());
                            }
                        } else {
                            this.lPg.setSelection(this.lPr.doH() + this.lPg.getHeaderViewsCount());
                        }
                    } else {
                        this.lPg.setSelection(i2 > 0 ? ((this.lPg.getData() == null && fVar.dmV() == null) ? 0 : (this.lPg.getData().size() - fVar.dmV().size()) + this.lPg.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.jaQ.endLoadData();
                    this.jaQ.setText(this.lDG.getString(R.string.pb_load_more_without_point));
                    this.jaQ.setLineGone();
                    break;
            }
            if (this.lQo == lQp && isHost()) {
                dtd();
            }
            if (this.lQz) {
                drV();
                this.lQz = false;
                if (i3 == 0) {
                    vm(true);
                }
            }
            if (fVar.lAH == 1 || fVar.lAI == 1) {
                if (this.lQF == null) {
                    this.lQF = new PbTopTipView(this.lDG.getContext());
                }
                if (fVar.lAI == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.lDG.getStType())) {
                    this.lQF.setText(this.lDG.getString(R.string.pb_read_strategy_add_experience));
                    this.lQF.a(this.bIq, this.mSkinType);
                } else if (fVar.lAH == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.lDG.getStType())) {
                    this.lQF.setText(this.lDG.getString(R.string.pb_read_news_add_experience));
                    this.lQF.a(this.bIq, this.mSkinType);
                }
            }
            this.lPg.removeFooterView(this.lQU.getView());
            if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dnC()) && fVar.getPage().bnF() == 0) {
                this.lPg.removeFooterView(this.bJa);
                this.lQU.HW(Math.max(this.lPP.getMeasuredHeight(), this.lQa / 2));
                this.lPg.addFooterView(this.lQU.getView());
                this.lQU.H(fVar);
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmT() != null) {
            x(fVar);
            if (fVar.bkY()) {
                WebPManager.a(this.lPT, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lPT, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String Hx = Hx(fVar.dmT().boG());
            if (this.lPW != null) {
                this.lPW.setText(Hx);
            }
            if (this.lPX != null) {
                this.lPX.setText(Hx);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dmT()));
        }
    }

    private String Hx(int i) {
        if (i == 0) {
            return this.lDG.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void dsH() {
        if (this.lPi != null) {
            this.lPi.a(this.lPg, this.textView, this.mType);
        }
    }

    public void vu(boolean z) {
        this.lPI = z;
    }

    public void endLoadData() {
        if (this.jaQ != null) {
            this.jaQ.setLineGone();
            this.jaQ.endLoadData();
        }
        ckt();
    }

    public void bYs() {
        this.lPg.setVisibility(0);
    }

    public void dsI() {
        if (this.lPg != null) {
            this.lPg.setVisibility(8);
        }
        if (this.lPg != null) {
            this.lQf.setVisibility(8);
        }
        if (this.lPc != null && this.lPc.jjn != null) {
            this.lPc.jjn.setVisibility(8);
        }
    }

    public void dsJ() {
        if (this.lPg != null) {
            this.lPg.setVisibility(0);
        }
        if (this.lQf != null) {
            this.lQf.setVisibility(0);
        }
        if (this.lPc != null && this.lPc.jjn != null) {
            this.lPc.jjn.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.lQb != null && this.lQb.boP() != null && this.lPc != null) {
            this.lQC = !this.lQB;
            this.lPc.vL(this.lQC);
            if (this.lDG.doZ() != null) {
                this.lDG.doZ().vK(this.lQC);
            }
            dsK();
            if (this.lDG != null && !this.lDG.doc() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dnq())) {
                bu buVar = fVar.dnq().get(0);
                if (buVar != null) {
                    this.lPc.fZ(buVar.getForumName(), buVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.lPc.fZ(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.lQC) {
                this.lPl.a(fVar, this.lQb, this.lPJ);
                if (this.lQh != null) {
                    this.lQh.setVisibility(8);
                }
                if (this.lQL == null) {
                    this.lQL = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.az.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (az.this.lDG != null && az.this.lDG.isAdded()) {
                                if (i < 0 && f > az.this.lQE) {
                                    az.this.dsR();
                                    az.this.dtc();
                                }
                                az.this.dsB();
                            }
                        }
                    };
                }
                this.lPg.setListViewDragListener(this.lQL);
                return;
            }
            if (this.lQh != null) {
                this.lQh.setVisibility(0);
            }
            this.lPl.a(fVar, this.lQb, this.lPJ);
            this.lQL = null;
            this.lPg.setListViewDragListener(null);
        }
    }

    private void dsK() {
        this.lPl.a(this.lEN, this.lQb, this.lQC, this.lQB);
    }

    public boolean dsL() {
        return this.lEN == null || this.lEN.getForum() == null || "0".equals(this.lEN.getForum().getId()) || "me0407".equals(this.lEN.getForum().getName());
    }

    private boolean dsM() {
        return this.lPj.vG(this.lEv);
    }

    private boolean w(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dmT() == null) {
            return false;
        }
        if (fVar.dmT().boM() == 1 || fVar.dmT().getThreadType() == 33) {
            return true;
        }
        return !(fVar.dmT().boO() == null || fVar.dmT().boO().bri() == 0) || fVar.dmT().boK() == 1 || fVar.dmT().boL() == 1 || fVar.dmT().bpD() || fVar.dmT().bpZ() || fVar.dmT().bpS() || fVar.dmT().bpa() != null || !com.baidu.tbadk.core.util.au.isEmpty(fVar.dmT().getCategory()) || fVar.dmT().boS() || fVar.dmT().boR();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.lPk != null) {
                if (fVar.dmT() != null && fVar.dmT().bpd() == 0 && !fVar.dmT().bnv() && !this.lQW) {
                    if (fVar.dmT() != null) {
                        by dmT = fVar.dmT();
                        dmT.z(true, w(fVar));
                        dmT.oC(3);
                        dmT.Bd("2");
                    }
                    if (fVar.dmT().bnx()) {
                        this.lPl.c(this.lPg);
                        this.lPk.c(this.lPg);
                        this.lPk.b(this.lPg);
                        this.lPl.b(this.lPg);
                        this.lPl.G(this.lEN);
                        if (A(fVar)) {
                            this.lPk.c(this.lPg);
                        } else {
                            this.lPk.D(fVar);
                        }
                    } else {
                        this.lPl.G(this.lEN);
                        if (A(fVar)) {
                            this.lPk.c(this.lPg);
                        } else {
                            this.lPk.F(fVar);
                        }
                    }
                } else if (fVar.dmT().bpd() == 1) {
                    if (fVar.dmT() != null) {
                        this.lPk.c(this.lPg);
                        this.lPl.G(this.lEN);
                    }
                } else {
                    this.lPk.c(this.lPg);
                    this.lPl.G(this.lEN);
                }
            }
            z(fVar);
            this.lEv = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            dsM();
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData b;
        com.baidu.tbadk.core.data.ac acVar;
        StringBuilder sb = null;
        if (fVar != null && (b = b(fVar, z)) != null) {
            String userId = b.boP().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dni()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (b.boP() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, b.boP().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, b.boP().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, b.boP().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, b.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, b.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dni()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bu> dnq = fVar.dnq();
                if (com.baidu.tbadk.core.util.y.getCount(dnq) > 0) {
                    sb = new StringBuilder();
                    for (bu buVar : dnq) {
                        if (buVar != null && !StringUtils.isNull(buVar.getForumName()) && (acVar = buVar.eIt) != null && acVar.eGf && !acVar.eGg && (acVar.type == 1 || acVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(buVar.getForumName(), 12)).append(this.lDG.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.lDG.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View dsN() {
        return this.fBr;
    }

    public boolean dsO() {
        if (this.bJa == null || this.bJa.getParent() == null || this.jaQ.isLoading()) {
            return false;
        }
        int bottom = this.bJa.getBottom();
        Rect rect = new Rect();
        this.bJa.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Qr(String str) {
        if (this.jaQ != null) {
            this.jaQ.setText(str);
        }
    }

    public void Qs(String str) {
        if (this.jaQ != null) {
            int i = 0;
            if (this.lQm != null && this.lQm.lRv != null && this.lQm.lRv.getView() != null) {
                i = this.lQm.lRv.getView().getTop() < 0 ? this.lQm.lRv.getView().getHeight() : this.lQm.lRv.getView().getBottom();
            }
            this.jaQ.ap(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.lPg;
    }

    public int dsP() {
        return R.id.richText;
    }

    public TextView dou() {
        return this.lPl.dou();
    }

    public void d(BdListView.e eVar) {
        this.lPg.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.fci = cVar;
        if (this.lPv != null) {
            this.lPv.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ax axVar, a.b bVar) {
        if (axVar != null) {
            int bnD = axVar.bnD();
            int bnA = axVar.bnA();
            if (this.lPs != null) {
                this.lPs.brv();
            } else {
                this.lPs = new com.baidu.tbadk.core.dialog.a(this.lDG.getPageContext().getPageActivity());
                this.lPt = LayoutInflater.from(this.lDG.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.lPs.bi(this.lPt);
                this.lPs.a(R.string.dialog_ok, bVar);
                this.lPs.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        az.this.dsR();
                        aVar.dismiss();
                    }
                });
                this.lPs.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.az.23
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (az.this.lQw == null) {
                            az.this.lQw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.23.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    az.this.lDG.HidenSoftKeyPad((InputMethodManager) az.this.lDG.getBaseFragmentActivity().getSystemService("input_method"), az.this.bIq);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.mY().postDelayed(az.this.lQw, 150L);
                    }
                });
                this.lPs.b(this.lDG.getPageContext()).brv();
            }
            this.lPu = (EditText) this.lPt.findViewById(R.id.input_page_number);
            this.lPu.setText("");
            TextView textView = (TextView) this.lPt.findViewById(R.id.current_page_number);
            if (bnD <= 0) {
                bnD = 1;
            }
            if (bnA <= 0) {
                bnA = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(bnD), Integer.valueOf(bnA)));
            this.lDG.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.lPu, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.lPg.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.lDG.showToast(str);
    }

    public boolean vv(boolean z) {
        if (this.acn == null || !this.acn.bCr()) {
            return false;
        }
        this.acn.bAK();
        return true;
    }

    public void dsQ() {
        if (this.lRf != null) {
            while (this.lRf.size() > 0) {
                TbImageView remove = this.lRf.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        dsQ();
        this.lPr.GW(1);
        if (this.lPi != null) {
            this.lPi.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.lPr.GW(2);
        if (this.lPi != null) {
            this.lPi.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.lDG.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lDG.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.lPV != null) {
            this.lPV.onDestroy();
        }
        if (this.lQy != null) {
            this.lQy.destroy();
        }
        if (this.lQN != null) {
            this.lQN.onDestory();
        }
        if (this.lQF != null) {
            this.lQF.hide();
        }
        this.lDG.hideProgressBar();
        if (this.gpu != null && this.iQf != null) {
            this.gpu.b(this.iQf);
        }
        dsR();
        endLoadData();
        if (this.lQw != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lQw);
        }
        if (this.lQe != null) {
            this.lQe.clearStatus();
        }
        this.lQZ = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.lPr.GW(3);
        if (this.bHy != null) {
            this.bHy.setBackgroundDrawable(null);
        }
        if (this.lPi != null) {
            this.lPi.destroy();
        }
        if (this.lPr != null) {
            this.lPr.onDestroy();
        }
        this.lPg.setOnLayoutListener(null);
        if (this.lQJ != null) {
            this.lQJ.cFg();
        }
        if (this.lQn != null) {
            this.lQn.onDestroy();
        }
        if (this.lPl != null) {
            this.lPl.onDestroy();
        }
    }

    public boolean Hy(int i) {
        if (this.lPi != null) {
            return this.lPi.Hy(i);
        }
        return false;
    }

    public void dsR() {
        this.lPc.bca();
        if (this.lPl != null) {
            this.lPl.dsR();
        }
        if (this.lDG != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lDG.getContext(), this.lPu);
        }
        drX();
        if (this.lHY != null) {
            this.lHY.dismiss();
        }
        dsT();
        if (this.lPs != null) {
            this.lPs.dismiss();
        }
        if (this.iVG != null) {
            this.iVG.dismiss();
        }
    }

    public void dsS() {
        this.lPc.bca();
        if (this.lPl != null) {
            this.lPl.dsR();
        }
        if (this.lHY != null) {
            this.lHY.dismiss();
        }
        dsT();
        if (this.lPs != null) {
            this.lPs.dismiss();
        }
        if (this.iVG != null) {
            this.iVG.dismiss();
        }
    }

    public void fp(List<String> list) {
        this.lQI = list;
        if (this.lQJ != null) {
            this.lQJ.setData(list);
        }
    }

    public void uy(boolean z) {
        this.lPr.uy(z);
    }

    public void vw(boolean z) {
        this.lPL = z;
    }

    public void dsT() {
        if (this.lPz != null) {
            this.lPz.dismiss();
        }
        if (this.lPA != null) {
            com.baidu.adp.lib.f.g.b(this.lPA, this.lDG.getPageContext());
        }
        if (this.lPB != null) {
            com.baidu.adp.lib.f.g.b(this.lPB, this.lDG.getPageContext());
        }
        if (this.lPy != null) {
            this.lPy.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            d(this.lEN, this.lEv);
            b(this.lEN, this.lEv, this.mType, i);
            this.lDG.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.lDG.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bIq);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bIq, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lPM, R.color.CAM_X0203);
            if (this.lPi != null) {
                this.lPi.onChangeSkinType(i);
            }
            if (this.lPm != null) {
                this.lPm.onChangeSkinType(i);
            }
            if (this.lPj != null) {
                this.lPj.onChangeSkinType(i);
            }
            if (this.lPk != null) {
                this.lPk.onChangeSkinType(i);
            }
            if (this.lPl != null) {
                this.lPl.onChangeSkinType(i);
            }
            if (this.jaQ != null) {
                this.jaQ.changeSkin(i);
            }
            if (this.fBr != null) {
                this.lDG.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fBr);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.fBr, R.drawable.pb_foot_more_trans_selector);
            }
            if (this.lPs != null) {
                this.lPs.c(this.lDG.getPageContext());
            }
            vu(this.lPI);
            this.lPr.notifyDataSetChanged();
            if (this.lPv != null) {
                this.lPv.changeSkin(i);
            }
            if (this.acn != null) {
                this.acn.onChangeSkinType(i);
            }
            if (this.lPw != null) {
                this.lPw.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.ilT)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.ilT) {
                    customBlueCheckRadioButton.buS();
                }
            }
            dsp();
            UtilHelper.setStatusBarBackground(this.bHy, i);
            UtilHelper.setStatusBarBackground(this.lQh, i);
            if (this.lPn != null) {
                com.baidu.tbadk.r.a.a(this.lDG.getPageContext(), this.lPn);
            }
            if (this.lQx != null) {
                this.lQx.onChangeSkinType(i);
            }
            if (this.lPc != null) {
                if (this.lPi != null) {
                    this.lPi.Hz(i);
                } else {
                    this.lPc.onChangeSkinType(i);
                }
            }
            if (this.lPR != null) {
                this.lPR.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0401));
            }
            if (this.lPQ != null) {
                this.lPQ.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aR(com.baidu.adp.lib.util.l.getDimens(this.lDG.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0209)));
            }
            if (this.lEN != null && this.lEN.bkY()) {
                WebPManager.a(this.lPT, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lPT, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.a(this.lPS, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            x(this.lEN);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lPP, R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lPO, R.color.CAM_X0203);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lQH, R.color.cp_cont_n);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jYr, R.color.CAM_X0109);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lPX, R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lPW, R.color.CAM_X0107);
            com.baidu.tbadk.core.util.ap.d(this.lPW, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (this.lQK != null) {
                this.lQK.onChangeSkinType(i);
            }
            if (this.lQn != null) {
                this.lQn.onChangeSkinType();
            }
            if (this.lPh != null) {
                this.lPh.vJ(i);
            }
            if (this.lPV != null) {
                this.lPV.onChangeSkinType();
            }
            if (this.lQU != null) {
                this.lQU.onChangeSkinType();
            }
        }
    }

    public void dsU() {
        if (this.lPV != null) {
            this.lPV.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bb(fVar.dmT())) {
            if (this.lPV != null) {
                this.lPV.setEnable(false);
                this.lPV.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.lPU.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.lPU.setLayoutParams(layoutParams);
            WebPManager.a(this.lPU, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.lPV == null || !this.lPV.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.lPU.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.lPU.setLayoutParams(layoutParams2);
            WebPManager.a(this.lPU, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fNk = iVar;
        this.lPr.setOnImageClickListener(this.fNk);
        this.lQK.setOnImageClickListener(this.fNk);
    }

    public void g(NoNetworkView.a aVar) {
        this.iQf = aVar;
        if (this.gpu != null) {
            this.gpu.a(this.iQf);
        }
    }

    public void vx(boolean z) {
        this.lPr.setIsFromCDN(z);
    }

    public Button dsV() {
        return this.lPN;
    }

    public void dsW() {
        if (this.lPb != 2) {
            this.lPg.setNextPage(this.jaQ);
            this.lPb = 2;
        }
    }

    public boolean dsX() {
        return this.acn != null && this.acn.getVisibility() == 0;
    }

    public boolean dsY() {
        return this.acn != null && this.acn.bCr();
    }

    public void dsZ() {
        if (this.acn != null) {
            this.acn.bAK();
        }
    }

    public void vy(boolean z) {
        if (this.lPP != null) {
            vw(this.lDG.doW().bDb());
            if (this.lPL) {
                vn(z);
            } else {
                vo(z);
            }
        }
    }

    public void dta() {
        if (this.lPP != null) {
            this.lPO.setVisibility(8);
            this.lPP.setVisibility(8);
            this.lPY = false;
            if (this.lQn != null) {
                this.lQn.setVisibility(8);
                vs(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.iqh == null) {
            this.iqh = new com.baidu.tbadk.core.view.a(this.lDG.getPageContext());
        }
        this.iqh.setDialogVisiable(true);
    }

    public void ckt() {
        if (this.iqh != null) {
            this.iqh.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.lPg.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.lPg.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lPi != null) {
            this.lPi.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.lRg = getScrollY();
            this.lQm.lRv = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lQm));
            a(this.lQm.lRv, true);
            dtp();
        }
    }

    public void vz(boolean z) {
        if (this.lPi != null) {
            this.lPi.vz(z);
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
        if (this.lPi != null) {
            this.lPi.onScroll(absListView, i, i2, i3);
        }
        if (this.lPc != null && this.lPl != null) {
            this.lPc.dF(this.lPl.dtD());
        }
        this.lQm.lus = i;
        this.lQm.headerCount = this.lPg.getHeaderViewsCount();
        this.lQm.lRv = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lQm));
        vp(b(absListView, i));
        a(this.lQm.lRv, false);
        dtp();
        if (this.jaQ.bvj() && !this.jaQ.fbm) {
            if (this.lQm != null && this.lQm.lRv != null && this.lQm.lRv.getView() != null) {
                i4 = this.lQm.lRv.getView().getTop() < 0 ? this.lQm.lRv.getView().getHeight() : this.lQm.lRv.getView().getBottom();
            }
            this.jaQ.qT(i4);
            this.jaQ.fbm = true;
        }
    }

    public void dtb() {
        if (TbadkCoreApplication.isLogin() && this.lEN != null && this.lQC && !this.lQB && !this.lPJ && this.lQb != null && this.lQb.boP() != null && !this.lQb.boP().getIsLike() && !this.lQb.boP().hadConcerned() && this.lQy == null) {
            this.lQy = new av(this.lDG);
        }
    }

    public void dtc() {
        if (this.lDG != null) {
            if ((this.iSJ || this.lQR == 17) && com.baidu.tbadk.a.d.bku()) {
                if (this.lEN != null && this.lEN.getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(this.lEN.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.lDG.getContext()).createNormalCfg(this.lEN.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13853").dY("post_id", this.lEN.getThreadId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("fid", this.lEN.getForum().getId()));
                }
            } else if (this.lQC && !this.lQB && this.lQb != null && this.lQb.boP() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12601").al("obj_locate", this.lDG.doc() ? 2 : 1).al("obj_type", this.lQB ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.lDG.getPageContext().getPageActivity(), this.lQb.boP().getUserId(), this.lQb.boP().getUserName(), this.lDG.dok().dod(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(au auVar, boolean z) {
        int measuredHeight;
        if (!this.lQB && this.lQg != null && this.lPc.dtV() != null) {
            int doI = this.lPr.doI();
            if (doI > 0 && (auVar == null || auVar.getView().getParent() == null)) {
                if (doI > this.lPg.getFirstVisiblePosition() - this.lPg.getHeaderViewsCount()) {
                    this.lQg.setVisibility(4);
                    return;
                }
                this.lQg.setVisibility(0);
                vp(false);
                this.lPc.mNavigationBar.hideBottomLine();
                if (this.lQg.getParent() != null && ((ViewGroup) this.lQg.getParent()).getHeight() <= this.lQg.getTop()) {
                    this.lQg.getParent().requestLayout();
                }
            } else if (auVar == null || auVar.getView() == null || auVar.lOB == null) {
                if (this.lPg.getFirstVisiblePosition() == 0) {
                    this.lQg.setVisibility(4);
                    this.lPc.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = auVar.getView().getTop();
                if (auVar.getView().getParent() != null) {
                    if (this.lQl) {
                        this.lQk = top;
                        this.lQl = false;
                    }
                    this.lQk = top < this.lQk ? top : this.lQk;
                }
                if (top != 0 || auVar.getView().isShown()) {
                    if (this.lPq.getY() < 0.0f) {
                        measuredHeight = lQj - auVar.lOB.getMeasuredHeight();
                    } else {
                        measuredHeight = this.lPc.dtV().getMeasuredHeight() - auVar.lOB.getMeasuredHeight();
                        this.lPc.mNavigationBar.hideBottomLine();
                    }
                    if (auVar.getView().getParent() == null && top <= this.lQk) {
                        this.lQg.setVisibility(0);
                        vp(false);
                    } else if (top < measuredHeight) {
                        this.lQg.setVisibility(0);
                        vp(false);
                    } else {
                        this.lQg.setVisibility(4);
                        this.lPc.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.lQl = true;
                    }
                }
            }
        }
    }

    public void dtd() {
        if (!this.lRh) {
            TiebaStatic.log("c10490");
            this.lRh = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lDG.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(lQq, Integer.valueOf(lQs));
            aVar.oP(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.lDG.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.bi(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.lDG);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.24
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lDG.getPageContext()).brv();
        }
    }

    public void Qt(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lDG.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.lDG.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.bi(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(lQq, Integer.valueOf(lQt));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.lDG);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lDG.getPageContext()).brv();
    }

    public void a(int i, com.baidu.tieba.pb.data.f fVar, boolean z, int i2) {
        PostData b;
        if (i > 0 && (b = b(fVar, z)) != null && b.boP() != null) {
            MetaData boP = b.boP();
            boP.setGiftNum(boP.getGiftNum() + i);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        a(fVar, z, i, i2);
        this.lPl.onChangeSkinType(i2);
    }

    public PbInterviewStatusView dte() {
        return this.lQe;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmT() != null && fVar.dmT().bpZ() && this.lQe == null) {
            this.lQe = (PbInterviewStatusView) this.lQd.inflate();
            this.lQe.setOnClickListener(this.iVH);
            this.lQe.setCallback(this.lDG.dpH());
            this.lQe.setData(this.lDG, fVar);
        }
    }

    public RelativeLayout dtf() {
        return this.lPq;
    }

    public View dtg() {
        return this.bHy;
    }

    public boolean dth() {
        return this.lQW;
    }

    public void uD(boolean z) {
        this.lPl.uD(z);
    }

    public void Qu(String str) {
        if (this.lPd != null) {
            this.lPd.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int vA(boolean z) {
        if (this.lQe == null || this.lQe.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void dti() {
        if (this.lQe != null && this.lQe.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lQe.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.lQe.setLayoutParams(layoutParams);
        }
    }

    public boolean dpc() {
        return false;
    }

    public void Qv(String str) {
        this.jYr.performClick();
        if (!StringUtils.isNull(str) && this.lDG.doW() != null && this.lDG.doW().bCT() != null && this.lDG.doW().bCT().getInputView() != null) {
            EditText inputView = this.lDG.doW().bCT().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            dsR();
            if (configuration.orientation == 2) {
                dta();
                drX();
            } else {
                dsb();
            }
            if (this.lQx != null) {
                this.lQx.doR();
            }
            this.lDG.cCF();
            this.lPq.setVisibility(8);
            this.lPc.vM(false);
            this.lDG.uS(false);
            if (this.lPi != null) {
                if (configuration.orientation == 1) {
                    dtf().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.lPg.setIsLandscape(true);
                    this.lPg.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.lPg.setIsLandscape(false);
                    if (this.lRg > 0) {
                        this.lPg.smoothScrollBy(this.lRg, 0);
                    }
                }
                this.lPi.onConfigurationChanged(configuration);
                this.lQf.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void vB(boolean z) {
        if (this.lPi != null) {
            this.lPi.vB(z);
        }
    }

    public boolean dtj() {
        return this.lPi != null && this.lPi.dtj();
    }

    public void dtk() {
        if (this.lPi != null) {
            this.lPi.dtk();
        }
    }

    public void uH(boolean z) {
        this.lPr.uH(z);
    }

    public void dE(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.lPP.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.lDG.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.lQH = new TextView(this.lDG.getContext());
            this.lQH.setText(R.string.connection_tips);
            this.lQH.setGravity(17);
            this.lQH.setPadding(com.baidu.adp.lib.util.l.getDimens(this.lDG.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.lDG.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lDG.getContext(), R.dimen.ds60);
            if (this.lQH.getParent() == null) {
                frameLayout.addView(this.lQH, layoutParams);
            }
            this.lQG = new PopupWindow(this.lDG.getContext());
            this.lQG.setContentView(frameLayout);
            this.lQG.setHeight(-2);
            this.lQG.setWidth(-2);
            this.lQG.setFocusable(true);
            this.lQG.setOutsideTouchable(false);
            this.lQG.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.lPg.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.26
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        az.this.lQG.showAsDropDown(az.this.lPP, view.getLeft(), -az.this.lPP.getHeight());
                    } else {
                        az.this.lQG.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void vC(boolean z) {
        this.lQM = z;
    }

    public boolean dtl() {
        return this.lQM;
    }

    public PbThreadPostView dtm() {
        return this.lPh;
    }

    private void z(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmT() != null && !fVar.dmT().bnv()) {
            boolean z = fVar.dmT().boL() == 1;
            boolean z2 = fVar.dmT().boK() == 1;
            if (this.lPl != null) {
                this.lPl.c(fVar, z, z2);
            }
            if (this.lPr != null && this.lPr.doN() != null) {
                this.lPr.doN().b(fVar, z, z2);
            }
        }
    }

    public void vD(boolean z) {
        this.iSJ = z;
    }

    public void Hq(int i) {
        this.lQR = i;
    }

    public void dtn() {
        if (this.lPg != null) {
            this.lPg.setForbidDragListener(true);
        }
    }

    public boolean dqb() {
        if (this.lPg == null) {
            return false;
        }
        return this.lPg.dqb();
    }

    public boolean dto() {
        if (this.jaQ == null || TextUtils.isEmpty(this.jaQ.getEndText())) {
            return false;
        }
        return this.jaQ.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }

    private boolean A(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dmT() == null) {
            return false;
        }
        SpannableStringBuilder bpz = fVar.dmT().bpz();
        if (bpz != null) {
            return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(bpz.toString());
        }
        return true;
    }

    public void dtp() {
        boolean z;
        if (this.lQU != null) {
            if (((this.lQU.getView() == null || this.lQU.getView().getParent() == null) ? -1 : this.lPg.getPositionForView(this.lQU.getView())) != -1) {
                if (this.lQU.getView().getTop() + lQS <= this.lQg.getBottom()) {
                    this.lQT = 1;
                    z = true;
                } else {
                    this.lQT = 0;
                    z = false;
                }
            } else {
                z = this.lQT == 1;
            }
            this.lQi.vl(this.lQT == 1);
            this.lQU.setScrollable(z);
        }
    }
}
