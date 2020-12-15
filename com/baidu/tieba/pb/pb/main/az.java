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
    private NoNetworkView gpw;
    private boolean iSL;
    private View.OnClickListener iVJ;
    private List<CustomBlueCheckRadioButton> ilV;
    private boolean isLandscape;
    private com.baidu.tieba.NEGFeedBack.f jCb;
    private TextView jYt;
    private PbListView jaS;
    private NavigationBarCoverTip jyJ;
    private PbFragment lDI;
    private View.OnClickListener lEF;
    private com.baidu.tieba.pb.data.f lEP;
    private PbFakeFloorModel lHk;
    PbFragment.c lJb;
    private View lPO;
    private View lPQ;
    private View lPR;
    private LinearLayout lPS;
    private HeadImageView lPT;
    private ImageView lPU;
    private ImageView lPV;
    private ImageView lPW;
    private com.baidu.tieba.pb.view.d lPX;
    private TextView lPY;
    private TextView lPZ;
    public int lPc;
    public final com.baidu.tieba.pb.pb.main.view.c lPe;
    public com.baidu.tieba.pb.pb.main.view.b lPf;
    private ViewStub lPg;
    private ViewStub lPh;
    private PbLandscapeListView lPi;
    private PbThreadPostView lPj;
    private com.baidu.tieba.pb.pb.main.a.e lPk;
    private com.baidu.tieba.pb.pb.main.a.a lPl;
    private com.baidu.tieba.pb.pb.main.a.c lPm;
    private com.baidu.tieba.pb.pb.main.a.d lPn;
    private com.baidu.tieba.pb.pb.main.a.b lPo;
    private LinearLayout lPp;
    private TextView lPq;
    private TextView lPr;
    private ObservedChangeRelativeLayout lPs;
    private g lPt;
    private View lPz;
    private av lQA;
    private int lQG;
    private PbTopTipView lQH;
    private PopupWindow lQI;
    private TextView lQJ;
    private List<String> lQK;
    private com.baidu.tieba.pb.pb.main.emotion.c lQL;
    private com.baidu.tieba.pb.pb.godreply.a lQM;
    private PbLandscapeListView.b lQN;
    private al lQP;
    private com.baidu.tieba.NEGFeedBack.i lQQ;
    private String lQR;
    private long lQS;
    private int lQT;
    private com.baidu.tieba.pb.view.c lQW;
    private boolean lQY;
    private int lQb;
    private int lQc;
    private PostData lQd;
    private ViewStub lQf;
    private PbInterviewStatusView lQg;
    private FrameLayout lQh;
    private View lQi;
    private View lQj;
    private au lQk;
    private PbEmotionBar lQp;
    private int lQx;
    private Runnable lQy;
    private v lQz;
    private Runnable lRc;
    private PbFragment.b lRe;
    public int lRi;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private int mType;
    private TextView textView;
    private static final int lQl = UtilHelper.getLightStatusBarHeight();
    public static int lQr = 3;
    public static int lQs = 0;
    public static int lQt = 3;
    public static int lQu = 4;
    public static int lQv = 5;
    public static int lQw = 6;
    private static final int lQU = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
    private static a.InterfaceC0868a lQX = new a.InterfaceC0868a() { // from class: com.baidu.tieba.pb.pb.main.az.11
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0868a
        public void onRefresh() {
        }
    };
    private int lPd = 0;
    private final Handler mHandler = new Handler();
    private com.baidu.tbadk.core.dialog.a lPu = null;
    private com.baidu.tbadk.core.dialog.b iVI = null;
    private View lPv = null;
    private EditText lPw = null;
    private com.baidu.tieba.pb.view.e lPx = null;
    private com.baidu.tieba.pb.view.a lPy = null;
    private b.InterfaceC0586b kwV = null;
    private TbRichTextView.i fNk = null;
    private NoNetworkView.a iQh = null;
    private com.baidu.tbadk.core.dialog.i lPA = null;
    private com.baidu.tbadk.core.dialog.a lPB = null;
    private Dialog lPC = null;
    private Dialog lPD = null;
    private View lPE = null;
    private LinearLayout lPF = null;
    private CompoundButton.OnCheckedChangeListener ilW = null;
    private TextView lPG = null;
    private TextView lPH = null;
    private String lPI = null;
    private com.baidu.tbadk.core.dialog.i lIa = null;
    private com.baidu.tbadk.core.dialog.i lPJ = null;
    private boolean lPK = false;
    private boolean lPL = false;
    private String mForumName = null;
    private String mForumId = null;
    private ScrollView lPM = null;
    private boolean lPN = false;
    private Button lPP = null;
    private boolean lQa = true;
    private com.baidu.tbadk.core.view.a iqj = null;
    private boolean lEx = false;
    private int mSkinType = 3;
    private boolean lQe = false;
    private int lQm = 0;
    private boolean lQn = true;
    public a lQo = new a();
    private int lQq = 0;
    private boolean lQB = false;
    private int lQC = 0;
    private boolean lQD = false;
    private boolean lQE = false;
    private boolean lQF = false;
    private boolean lQO = false;
    private int lQV = 0;
    private String lQZ = null;
    private CustomMessageListener lRa = new CustomMessageListener(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL) { // from class: com.baidu.tieba.pb.pb.main.az.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                az.this.lQZ = null;
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.az.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && az.this.lPt != null) {
                az.this.lPt.notifyDataSetChanged();
            }
        }
    };
    private Handler lRb = new Handler();
    private CustomMessageListener lRd = new CustomMessageListener(CmdConfigCustom.PB_SHOW_MULTIIAMGETOOL) { // from class: com.baidu.tieba.pb.pb.main.az.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                az.this.lQa = false;
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = null;
    private boolean lRf = true;
    View.OnClickListener lRg = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof HeadImageView) || az.this.lEP == null || az.this.lEP.dmU() == null || az.this.lEP.dmU().boP() == null || az.this.lEP.dmU().boP().getAlaInfo() == null || az.this.lEP.dmU().boP().getAlaInfo().live_status != 1) {
                if (az.this.lQD) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11923").al("obj_id", 2));
                }
                if (!az.this.lQD && az.this.lEP != null && az.this.lEP.dmU() != null && az.this.lEP.dmU().boP() != null && az.this.lEP.dmU().boP().isBigV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12151").al("obj_locate", 1));
                }
                if (az.this.lDI.dpR() != null) {
                    az.this.lDI.dpR().lDU.iCs.onClick(view);
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c11851");
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(arVar);
            if (az.this.lEP.dmU().boP().getAlaInfo() == null || !az.this.lEP.dmU().boP().getAlaInfo().isChushou) {
                if (az.this.lEP.dmU().boP().getAlaInfo().live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = az.this.lEP.dmU().boP().getAlaInfo().live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(az.this.lDI.dpR(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PB_USER_ICON_LIVE, null, false, "")));
                    return;
                }
                return;
            }
            bf.bua().b(az.this.lDI.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + az.this.lEP.dmU().boP().getAlaInfo().thirdRoomId + "&livetype=" + az.this.lEP.dmU().boP().getAlaInfo().thirdLiveType});
        }
    };
    private boolean bjg = false;
    String userId = null;
    private final List<TbImageView> lRh = new ArrayList();
    private boolean lRj = false;

    /* loaded from: classes22.dex */
    public static class a {
        public int headerCount;
        public au lRx;
        public int luu;
    }

    public void vm(boolean z) {
        this.lQB = z;
        if (this.lPi != null) {
            this.lQC = this.lPi.getHeaderViewsCount();
        }
    }

    public void drW() {
        if (this.lPi != null) {
            int headerViewsCount = this.lPi.getHeaderViewsCount() - this.lQC;
            final int firstVisiblePosition = (this.lPi.getFirstVisiblePosition() == 0 || this.lPi.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.lPi.getFirstVisiblePosition() + headerViewsCount;
            View childAt = this.lPi.getChildAt(0);
            final int top = childAt != null ? childAt.getTop() : -1;
            this.lQo.lRx = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lQo));
            final au auVar = this.lQo.lRx;
            final int g = g(auVar);
            final int y = ((int) this.lPs.getY()) + this.lPs.getMeasuredHeight();
            final boolean z = this.lQi.getVisibility() == 0;
            boolean z2 = this.lPs.getY() < 0.0f;
            if ((z && auVar != null) || firstVisiblePosition >= this.lPt.doJ() + this.lPi.getHeaderViewsCount()) {
                int measuredHeight = auVar != null ? auVar.lOD.getMeasuredHeight() : 0;
                if (z2) {
                    this.lPi.setSelectionFromTop(this.lPt.doJ() + this.lPi.getHeaderViewsCount(), lQl - measuredHeight);
                } else {
                    this.lPi.setSelectionFromTop(this.lPt.doJ() + this.lPi.getHeaderViewsCount(), this.lPe.dtW().getMeasuredHeight() - measuredHeight);
                }
            } else {
                this.lPi.setSelectionFromTop(firstVisiblePosition, top);
            }
            if (this.lQD && this.lPk != null) {
                this.lPi.setSelectionFromTop(this.lPt.doJ() + this.lPi.getHeaderViewsCount(), this.lPk.dtI());
            } else if (this.mType == 6) {
                this.lPi.setOnLayoutListener(new PbLandscapeListView.a() { // from class: com.baidu.tieba.pb.pb.main.az.1
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
                                    layoutParams.height = az.this.lQx;
                                } else if (layoutParams == null || layoutParams.height + i <= 0 || layoutParams.height + i > az.this.bIq.getMeasuredHeight()) {
                                    layoutParams.height = az.this.lQx;
                                } else {
                                    layoutParams.height = i + layoutParams.height;
                                    az.this.lPi.setSelectionFromTop(firstVisiblePosition, top);
                                }
                                az.this.bJa.setLayoutParams(layoutParams);
                                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (az.this.bJa != null && az.this.bJa.getLayoutParams() != null) {
                                            ViewGroup.LayoutParams layoutParams2 = az.this.bJa.getLayoutParams();
                                            layoutParams2.height = az.this.lQx;
                                            az.this.bJa.setLayoutParams(layoutParams2);
                                        }
                                    }
                                });
                            } else {
                                return;
                            }
                        }
                        az.this.lPi.setOnLayoutListener(null);
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

    public NoNetworkView drX() {
        return this.gpw;
    }

    public void drY() {
        if (this.acn != null) {
            this.acn.hide();
            if (this.lQL != null) {
                this.lQL.dtK();
            }
        }
    }

    public PbFakeFloorModel drZ() {
        return this.lHk;
    }

    public v dsa() {
        return this.lQz;
    }

    public com.baidu.tieba.pb.pb.main.a.e dsb() {
        return this.lPk;
    }

    public void dsc() {
        reset();
        drY();
        this.lQz.doS();
        vy(false);
    }

    private void reset() {
        if (this.lDI != null && this.lDI.doX() != null && this.acn != null) {
            com.baidu.tbadk.editortools.pb.a.bCQ().setStatus(0);
            com.baidu.tbadk.editortools.pb.e doX = this.lDI.doX();
            doX.bDl();
            doX.bCA();
            if (doX.getWriteImagesInfo() != null) {
                doX.getWriteImagesInfo().setMaxImagesAllowed(doX.isBJH ? 1 : 9);
            }
            doX.st(SendView.ALL);
            doX.su(SendView.ALL);
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

    public boolean dsd() {
        return this.lQa;
    }

    public void vn(boolean z) {
        if (this.lPR != null && this.jYt != null) {
            this.jYt.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lPR.startAnimation(alphaAnimation);
            }
            this.lPQ.setVisibility(0);
            this.lPR.setVisibility(0);
            this.lQa = true;
            if (this.lQp != null && !this.lQM.isActive()) {
                this.lQp.setVisibility(0);
                vs(true);
            }
        }
    }

    public void vo(boolean z) {
        if (this.lPR != null && this.jYt != null) {
            this.jYt.setText(dse());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.lPR.startAnimation(alphaAnimation);
            }
            this.lPQ.setVisibility(0);
            this.lPR.setVisibility(0);
            this.lQa = true;
            if (this.lQp != null && !this.lQM.isActive()) {
                this.lQp.setVisibility(0);
                vs(true);
            }
        }
    }

    public String dse() {
        if (!com.baidu.tbadk.core.util.au.isEmpty(this.lQR)) {
            return this.lQR;
        }
        if (this.lDI != null) {
            this.lQR = TbadkCoreApplication.getInst().getResources().getString(ay.drU());
        }
        return this.lQR;
    }

    public PostData dsf() {
        int i = 0;
        if (this.lPi == null) {
            return null;
        }
        int dsg = dsg() - this.lPi.getHeaderViewsCount();
        if (dsg < 0) {
            dsg = 0;
        }
        if (this.lPt.GV(dsg) != null && this.lPt.GV(dsg) != PostData.nlI) {
            i = dsg + 1;
        }
        return this.lPt.getItem(i) instanceof PostData ? (PostData) this.lPt.getItem(i) : null;
    }

    public int dsg() {
        int i;
        View childAt;
        if (this.lPi == null) {
            return 0;
        }
        int firstVisiblePosition = this.lPi.getFirstVisiblePosition();
        int lastVisiblePosition = this.lPi.getLastVisiblePosition();
        if (lastVisiblePosition > firstVisiblePosition) {
            int[] iArr = new int[(lastVisiblePosition - firstVisiblePosition) + 1];
            Rect rect = new Rect();
            int childCount = this.lPi.getChildCount();
            int i2 = 0;
            for (int i3 = firstVisiblePosition; i3 <= lastVisiblePosition; i3++) {
                if (i3 - firstVisiblePosition < childCount && (childAt = this.lPi.getChildAt(i3 - firstVisiblePosition)) != null) {
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

    public int dsh() {
        return this.lPi.getHeaderViewsCount();
    }

    public void b(TbRichText tbRichText) {
        PostData postData;
        if (this.lEP != null && this.lEP.dmW() != null && !this.lEP.dmW().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i = 0; i < this.lEP.dmW().size() && (postData = this.lEP.dmW().get(i)) != null && postData.boP() != null && !StringUtils.isNull(postData.boP().getUserId()); i++) {
                if (this.lEP.dmW().get(i).boP().getUserId().equals(tbRichText.getAuthorId())) {
                    if (this.lQM != null && this.lQM.isActive()) {
                        vy(false);
                    }
                    if (this.lQp != null) {
                        this.lQp.vI(true);
                    }
                    this.lQZ = postData.boP().getName_show();
                    return;
                }
            }
        }
    }

    public az(PbFragment pbFragment, View.OnClickListener onClickListener, com.baidu.tieba.pb.a.c cVar) {
        this.lDI = null;
        this.bIq = null;
        this.bHy = null;
        this.lPi = null;
        this.lPt = null;
        this.jaS = null;
        this.fBr = null;
        this.iVJ = null;
        this.lEF = null;
        this.lPR = null;
        this.jYt = null;
        this.lQf = null;
        this.lQG = 0;
        this.lQS = 0L;
        this.lQS = System.currentTimeMillis();
        this.lDI = pbFragment;
        this.iVJ = onClickListener;
        this.fos = cVar;
        this.lQG = com.baidu.adp.lib.util.l.getEquipmentWidth(this.lDI.getContext()) / 8;
        this.bIq = (RelativeLayout) LayoutInflater.from(this.lDI.getPageContext().getPageActivity()).inflate(R.layout.new_pb_activity, (ViewGroup) null);
        this.bIq.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.lPO = this.bIq.findViewById(R.id.bottom_shadow);
        this.jyJ = (NavigationBarCoverTip) this.bIq.findViewById(R.id.pb_multi_forum_del_tip_view);
        this.bHy = this.bIq.findViewById(R.id.statebar_view);
        this.lPs = (ObservedChangeRelativeLayout) this.bIq.findViewById(R.id.title_wrapper);
        this.gpw = (NoNetworkView) this.bIq.findViewById(R.id.view_no_network);
        this.lPi = (PbLandscapeListView) this.bIq.findViewById(R.id.new_pb_list);
        this.lQh = (FrameLayout) this.bIq.findViewById(R.id.root_float_header);
        this.textView = new TextView(this.lDI.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.lDI.getActivity(), R.dimen.ds88));
        this.lPi.addHeaderView(this.textView, 0);
        this.lPi.setTextViewAdded(true);
        this.lQx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.bJa = new View(this.lDI.getPageContext().getPageActivity());
        this.bJa.setLayoutParams(new AbsListView.LayoutParams(-1, this.lQx));
        this.bJa.setVisibility(4);
        this.lPi.addFooterView(this.bJa);
        this.lPi.setOnTouchListener(this.lDI.fGd);
        this.lPe = new com.baidu.tieba.pb.pb.main.view.c(pbFragment, this.bIq);
        if (this.lDI.dpA()) {
            this.lPg = (ViewStub) this.bIq.findViewById(R.id.manga_view_stub);
            this.lPg.setVisibility(0);
            this.lPf = new com.baidu.tieba.pb.pb.main.view.b(pbFragment);
            this.lPf.show();
            this.lPe.mNavigationBar.setVisibility(8);
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lDI.getActivity(), R.dimen.ds120);
        }
        this.textView.setLayoutParams(layoutParams);
        this.lPe.dtW().setOnTouchListener(new com.baidu.tieba.pb.a.a(new a.InterfaceC0824a() { // from class: com.baidu.tieba.pb.pb.main.az.27
            @Override // com.baidu.tieba.pb.a.a.InterfaceC0824a
            public void dnX() {
                if (az.this.lPi != null) {
                    if (az.this.lPk != null) {
                        az.this.lPk.dtH();
                    }
                    az.this.lPi.setSelection(0);
                }
            }

            @Override // com.baidu.tieba.pb.a.a.InterfaceC0824a
            public void dnY() {
                az.this.lDI.cCG();
            }
        }));
        this.lPQ = this.bIq.findViewById(R.id.view_comment_top_line);
        this.lPR = this.bIq.findViewById(R.id.pb_editor_tool_comment);
        this.lQb = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lQc = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.lPT = (HeadImageView) this.bIq.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lPT.setVisibility(0);
        this.lPT.setIsRound(true);
        this.lPT.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(this.lDI.getContext(), R.dimen.L_X01));
        this.lPT.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0401));
        this.lPT.setPlaceHolder(0);
        dsi();
        this.jYt = (TextView) this.bIq.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.lPS = (LinearLayout) this.bIq.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lPS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.lDI.dpi();
                if (az.this.lDI != null && az.this.lDI.dol() != null && az.this.lDI.dol().getPbData() != null && az.this.lDI.dol().getPbData().dmU() != null && az.this.lDI.dol().getPbData().dmU().boP() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13701").dY("tid", az.this.lDI.dol().dql()).dY("fid", az.this.lDI.dol().getPbData().getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dY("tid", az.this.lDI.dol().lLj).dY("fid", az.this.lDI.dol().getPbData().getForumId()).al("obj_locate", 1).dY("uid", az.this.lDI.dol().getPbData().dmU().boP().getUserId()));
                }
            }
        });
        this.lPU = (ImageView) this.bIq.findViewById(R.id.pb_editor_tool_comment_icon);
        this.lPU.setOnClickListener(this.iVJ);
        boolean booleanExtra = this.lDI.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.lPV = (ImageView) this.bIq.findViewById(R.id.pb_editor_tool_collection);
        this.lPV.setOnClickListener(this.iVJ);
        if (booleanExtra) {
            this.lPV.setVisibility(8);
        } else {
            this.lPV.setVisibility(0);
        }
        this.lPW = (ImageView) this.bIq.findViewById(R.id.pb_editor_tool_share);
        this.lPW.setOnClickListener(this.iVJ);
        this.lPX = new com.baidu.tieba.pb.view.d(this.lPW);
        this.lPX.dxq();
        this.lPY = (TextView) this.bIq.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.lPY.setVisibility(0);
        this.lQf = (ViewStub) this.bIq.findViewById(R.id.interview_status_stub);
        this.lPl = new com.baidu.tieba.pb.pb.main.a.a(this.lDI, cVar);
        this.lPn = new com.baidu.tieba.pb.pb.main.a.d(this.lDI, cVar, this.iVJ);
        this.lPt = new g(this.lDI, this.lPi);
        this.lPt.F(this.iVJ);
        this.lPt.setTbGestureDetector(this.fos);
        this.lPt.setOnImageClickListener(this.fNk);
        this.lPt.setOnSwitchChangeListener(this.lDI.lIU);
        this.lEF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.29
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
                            az.this.lDI.c(sparseArray);
                            return;
                        }
                        az.this.dD(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        az.this.lDI.c(sparseArray);
                    } else if (booleanValue3) {
                        az.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        };
        this.lPt.S(this.lEF);
        dsn();
        dso();
        this.lPm.b(this.lPi);
        this.lPn.b(this.lPi);
        this.lPl.b(this.lPi);
        this.jaS = new PbListView(this.lDI.getPageContext().getPageActivity());
        this.fBr = this.jaS.getView().findViewById(R.id.pb_more_view);
        if (this.fBr != null) {
            this.fBr.setOnClickListener(this.iVJ);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.fBr, R.drawable.pb_foot_more_trans_selector);
        }
        this.jaS.setLineVisible();
        this.jaS.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.jaS.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.lPz = this.bIq.findViewById(R.id.viewstub_progress);
        this.lDI.registerListener(this.lRd);
        this.lHk = new PbFakeFloorModel(this.lDI.getPageContext());
        this.lQz = new v(this.lDI.getPageContext(), this.lHk, this.bIq);
        this.lQz.T(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.dsc();
            }
        });
        this.lQz.a(this.lDI.lIW);
        this.lHk.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.main.az.31
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                az.this.lHk.u(postData);
                az.this.lPt.notifyDataSetChanged();
                az.this.lQz.doS();
                az.this.acn.bAK();
                az.this.vy(false);
            }
        });
        if (this.lDI.dol() != null && !StringUtils.isNull(this.lDI.dol().dqU())) {
            this.lDI.showToast(this.lDI.dol().dqU());
        }
        this.lQi = this.bIq.findViewById(R.id.pb_expand_blank_view);
        this.lQj = this.bIq.findViewById(R.id.sticky_view);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lQj.getLayoutParams();
        if (this.lDI.dol() != null && this.lDI.dol().dqo()) {
            this.lQi.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.lQj.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = lQl;
            this.lQj.setLayoutParams(layoutParams2);
        }
        this.lQk = new au(this.lDI.getPageContext(), this.bIq.findViewById(R.id.pb_reply_expand_view));
        this.lQk.v(pbFragment.lHP);
        this.lQk.lOD.setVisibility(8);
        this.lQk.U(this.iVJ);
        this.lQk.setOnSwitchChangeListener(this.lDI.lIU);
        this.lDI.registerListener(this.mAccountChangedListener);
        this.lDI.registerListener(this.lRa);
        dsj();
        vs(false);
        this.lQW = new com.baidu.tieba.pb.view.c(this.lDI.getPageContext());
    }

    private void dsi() {
        if (this.lPT != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lPT.setImageResource(0);
            this.lPT.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.lPT.setImageResource(R.drawable.transparent_bg);
    }

    public void vp(boolean z) {
        this.lPO.setVisibility(z ? 0 : 8);
    }

    public void cQY() {
        if (!this.lDI.checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").al("obj_locate", 2).dY("fid", this.mForumId));
        } else if (this.lDI.dpk()) {
            com.baidu.tbadk.editortools.pb.e doX = this.lDI.doX();
            if (doX != null && (doX.bDi() || doX.bDj())) {
                this.lDI.doX().a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.acn != null) {
                dst();
            }
            if (this.acn != null) {
                this.lQa = false;
                if (this.acn.sj(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(this.lDI.getPageContext(), (View) this.acn.sj(2).fub, false, lQX);
                }
            }
            dtb();
        }
    }

    private void dsj() {
        this.lQM = new com.baidu.tieba.pb.pb.godreply.a(this.lDI, this, (ViewStub) this.bIq.findViewById(R.id.more_god_reply_popup));
        this.lQM.B(this.iVJ);
        this.lQM.S(this.lEF);
        this.lQM.setOnImageClickListener(this.fNk);
        this.lQM.B(this.iVJ);
        this.lQM.setTbGestureDetector(this.fos);
    }

    public com.baidu.tieba.pb.pb.godreply.a dsk() {
        return this.lQM;
    }

    public View dsl() {
        return this.lQi;
    }

    public void dsm() {
        if (this.lPi != null) {
            this.lPm.c(this.lPi);
            this.lPn.c(this.lPi);
            this.lPo.c(this.lPi);
            this.lPl.c(this.lPi);
        }
    }

    private void dsn() {
        if (this.lPo == null) {
            this.lPo = new com.baidu.tieba.pb.pb.main.a.b(this.lDI, this.iVJ);
        }
    }

    private void dso() {
        if (this.lPm == null) {
            this.lPm = new com.baidu.tieba.pb.pb.main.a.c(this.lDI, this.fos);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsp() {
        if (this.lDI.dpA()) {
            this.lPh = (ViewStub) this.bIq.findViewById(R.id.manga_mention_controller_view_stub);
            this.lPh.setVisibility(0);
            if (this.lPp == null) {
                this.lPp = (LinearLayout) this.bIq.findViewById(R.id.manga_controller_layout);
                com.baidu.tbadk.r.a.a(this.lDI.getPageContext(), this.lPp);
            }
            if (this.lPq == null) {
                this.lPq = (TextView) this.lPp.findViewById(R.id.manga_prev_btn);
            }
            if (this.lPr == null) {
                this.lPr = (TextView) this.lPp.findViewById(R.id.manga_next_btn);
            }
            this.lPq.setOnClickListener(this.iVJ);
            this.lPr.setOnClickListener(this.iVJ);
        }
    }

    private void dsq() {
        if (this.lDI.dpA()) {
            if (this.lDI.dpD() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lPq, R.color.CAM_X0110, 1);
            }
            if (this.lDI.dpE() == -1) {
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lPr, R.color.CAM_X0110, 1);
            }
        }
    }

    public void dsr() {
        if (this.lPp == null) {
            dsp();
        }
        this.lPh.setVisibility(8);
        if (this.lRb != null && this.lRc != null) {
            this.lRb.removeCallbacks(this.lRc);
        }
    }

    public void dss() {
        if (this.lRb != null) {
            if (this.lRc != null) {
                this.lRb.removeCallbacks(this.lRc);
            }
            this.lRc = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.3
                @Override // java.lang.Runnable
                public void run() {
                    if (az.this.lPp == null) {
                        az.this.dsp();
                    }
                    az.this.lPh.setVisibility(0);
                }
            };
            this.lRb.postDelayed(this.lRc, 2000L);
        }
    }

    public void vq(boolean z) {
        this.lPe.vq(z);
        if (z && this.lQe) {
            this.jaS.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.lPi.setNextPage(this.jaS);
            this.lPd = 2;
        }
        dsi();
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acn = editorTools;
        this.acn.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                az.this.dsc();
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
                        az.this.mPermissionJudgePolicy.appendRequestPermission(az.this.lDI.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!az.this.mPermissionJudgePolicy.startRequestPermission(az.this.lDI.getBaseFragmentActivity())) {
                            az.this.lDI.doX().c((com.baidu.tbadk.coreExtra.data.u) aVar.data);
                            az.this.lDI.doX().a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        drY();
        this.lDI.doX().a(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.az.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (az.this.acn != null && az.this.acn.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if (!TextUtils.isEmpty(substring)) {
                        if (az.this.lQL == null) {
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams2.addRule(11);
                            layoutParams2.addRule(2, az.this.acn.getId());
                            az.this.lQL = new com.baidu.tieba.pb.pb.main.emotion.c(az.this.lDI.getPageContext(), az.this.bIq, layoutParams2);
                            if (!com.baidu.tbadk.core.util.y.isEmpty(az.this.lQK)) {
                                az.this.lQL.setData(az.this.lQK);
                            }
                            az.this.lQL.c(az.this.acn);
                        }
                        az.this.lQL.Qz(substring);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (az.this.lDI.kNm != null && az.this.lDI.kNm.dtt() != null) {
                    if (!az.this.lDI.kNm.dtt().dYq()) {
                        az.this.lDI.kNm.vE(false);
                    }
                    az.this.lDI.kNm.dtt().zc(false);
                }
            }
        });
    }

    public void dst() {
        if (this.lDI != null && this.acn != null) {
            this.acn.su();
            if (this.lDI.doX() != null) {
                this.lDI.doX().bCY();
            }
            dtb();
        }
    }

    public void vr(boolean z) {
        if (this.lPi != null && this.textView != null && this.bHy != null) {
            if (z) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bHy.setVisibility(0);
                } else {
                    this.bHy.setVisibility(8);
                    this.lPi.removeHeaderView(this.textView);
                    this.lPi.setTextViewAdded(false);
                }
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.textView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = lQl;
                    this.textView.setLayoutParams(layoutParams);
                }
                dsI();
                return;
            }
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.textView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + vA(true);
                this.textView.setLayoutParams(layoutParams2);
            }
            dsI();
            dtj();
        }
    }

    public g dsu() {
        return this.lPt;
    }

    public void a(PbFragment.c cVar) {
        this.lJb = cVar;
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
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lDI.getContext());
        kVar.setTitleText(this.lDI.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.lPA.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 10:
                            az.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 11:
                            if (az.this.lRe != null) {
                                az.this.lRe.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 12:
                            az.this.lDI.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.lDI.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.lDI.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eNK.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !dti()) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(11, this.lDI.getString(R.string.forbidden_person), kVar);
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
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.lDI.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.lDI.getString(R.string.mute), kVar);
            }
            gVar.eNK.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.k(com.baidu.tieba.pb.pb.main.d.a.fs(arrayList), true);
        this.lPA = new com.baidu.tbadk.core.dialog.i(this.lDI.getPageContext(), kVar);
        this.lPA.RU();
    }

    public void a(PbFragment.b bVar) {
        this.lRe = bVar;
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, null);
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.lDI != null && aVar != null) {
            if (this.jCb == null && this.lPl != null) {
                this.jCb = new com.baidu.tieba.NEGFeedBack.f(this.lDI.getPageContext(), this.lPl.dtD());
            }
            AntiData cBf = this.lDI.cBf();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBf != null && cBf.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBf.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.jCb.setDefaultReasonArray(new String[]{this.lDI.getString(R.string.delete_thread_reason_1), this.lDI.getString(R.string.delete_thread_reason_2), this.lDI.getString(R.string.delete_thread_reason_3), this.lDI.getString(R.string.delete_thread_reason_4), this.lDI.getString(R.string.delete_thread_reason_5)});
            this.jCb.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jCb.Fj(str);
            this.jCb.a(new f.b() { // from class: com.baidu.tieba.pb.pb.main.az.9
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void X(JSONArray jSONArray) {
                    az.this.lDI.a(aVar, jSONArray);
                }
            });
        }
    }

    private boolean dsv() {
        if (this.lDI == null || this.lDI.dol().getPbData().getForum().getDeletedReasonInfo() == null) {
            return false;
        }
        return 1 == this.lDI.dol().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i, com.baidu.tieba.NEGFeedBack.h hVar, UserData userData) {
        String str;
        if (this.lDI != null && aVar != null) {
            if (this.lQQ == null && this.lPl != null) {
                this.lQQ = new com.baidu.tieba.NEGFeedBack.i(this.lDI.getPageContext(), this.lPl.dtD(), hVar, userData);
            }
            AntiData cBf = this.lDI.cBf();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBf != null && cBf.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBf.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.lQQ.setDefaultReasonArray(new String[]{this.lDI.getString(R.string.delete_thread_reason_1), this.lDI.getString(R.string.delete_thread_reason_2), this.lDI.getString(R.string.delete_thread_reason_3), this.lDI.getString(R.string.delete_thread_reason_4), this.lDI.getString(R.string.delete_thread_reason_5)});
            this.lQQ.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.lQQ.Fj(str);
            this.lQQ.a(new i.b() { // from class: com.baidu.tieba.pb.pb.main.az.10
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void X(JSONArray jSONArray) {
                    az.this.lDI.a(aVar, jSONArray);
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
        sparseArray.put(lQs, Integer.valueOf(lQt));
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
        this.lPB = new com.baidu.tbadk.core.dialog.a(this.lDI.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lPB.oQ(i3);
        } else {
            this.lPB.setOnlyMessageShowCenter(false);
            this.lPB.Bq(str2);
        }
        this.lPB.setYesButtonTag(sparseArray);
        this.lPB.a(R.string.dialog_ok, this.lDI);
        this.lPB.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lPB.jl(true);
        this.lPB.b(this.lDI.getPageContext());
        if (z) {
            this.lPB.brv();
        } else if (dsv()) {
            com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(this.lDI.dol().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.lDI.dol().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.lDI.dol().getPbData().dnE().has_forum_rule.intValue());
            hVar.ek(this.lDI.dol().getPbData().getForum().getId(), this.lDI.dol().getPbData().getForum().getName());
            hVar.setForumHeadUrl(this.lDI.dol().getPbData().getForum().getImage_url());
            hVar.setUserLevel(this.lDI.dol().getPbData().getForum().getUser_level());
            a(this.lPB, i, hVar, this.lDI.dol().getPbData().getUserData());
        } else {
            a(this.lPB, i);
        }
    }

    public void bf(ArrayList<com.baidu.tbadk.core.data.ak> arrayList) {
        if (this.lPE == null) {
            this.lPE = LayoutInflater.from(this.lDI.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.lDI.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lPE);
        if (this.lPD == null) {
            this.lPD = new Dialog(this.lDI.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lPD.setCanceledOnTouchOutside(true);
            this.lPD.setCancelable(true);
            this.lPM = (ScrollView) this.lPE.findViewById(R.id.good_scroll);
            this.lPD.setContentView(this.lPE);
            WindowManager.LayoutParams attributes = this.lPD.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lPD.getWindow().setAttributes(attributes);
            this.ilW = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.pb.main.az.13
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        az.this.lPI = (String) compoundButton.getTag();
                        if (az.this.ilV != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : az.this.ilV) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && az.this.lPI != null && !str.equals(az.this.lPI)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lPF = (LinearLayout) this.lPE.findViewById(R.id.good_class_group);
            this.lPH = (TextView) this.lPE.findViewById(R.id.dialog_button_cancel);
            this.lPH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (az.this.lPD instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(az.this.lPD, az.this.lDI.getPageContext());
                    }
                }
            });
            this.lPG = (TextView) this.lPE.findViewById(R.id.dialog_button_ok);
            this.lPG.setOnClickListener(this.iVJ);
        }
        this.lPF.removeAllViews();
        this.ilV = new ArrayList();
        CustomBlueCheckRadioButton fY = fY("0", this.lDI.getPageContext().getString(R.string.thread_good_class));
        this.ilV.add(fY);
        fY.setChecked(true);
        this.lPF.addView(fY);
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
                    this.ilV.add(fY2);
                    View view = new View(this.lDI.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    com.baidu.tbadk.core.util.ap.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.lPF.addView(view);
                    this.lPF.addView(fY2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lPM.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lDI.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lDI.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = com.baidu.adp.lib.util.l.dip2px(this.lDI.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lPM.setLayoutParams(layoutParams2);
            this.lPM.removeAllViews();
            if (this.lPF != null && this.lPF.getParent() == null) {
                this.lPM.addView(this.lPF);
            }
        }
        com.baidu.adp.lib.f.g.a(this.lPD, this.lDI.getPageContext());
    }

    private CustomBlueCheckRadioButton fY(String str, String str2) {
        Activity pageActivity = this.lDI.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.ilW);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public void dsw() {
        this.lDI.showProgressBar();
    }

    public void a(int i, boolean z, String str, boolean z2) {
        this.lDI.hideProgressBar();
        if (z && z2) {
            this.lDI.showToast(this.lDI.getPageContext().getString(R.string.success));
        } else if (z2) {
            if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            this.lDI.showToast(str);
        }
    }

    public void cYn() {
        this.lPz.setVisibility(0);
    }

    public void cYm() {
        this.lPz.setVisibility(8);
    }

    public View dsx() {
        if (this.lPE != null) {
            return this.lPE.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String dsy() {
        return this.lPI;
    }

    public View getView() {
        return this.bIq;
    }

    public void dsz() {
        if (this.lDI != null && this.lDI.getBaseFragmentActivity() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lDI.getPageContext().getPageActivity(), this.lDI.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        this.lDI.hideProgressBar();
        if (z) {
            dsS();
        } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
            dsT();
        } else {
            dsS();
        }
    }

    public void dsA() {
        this.jaS.setLineVisible();
        this.jaS.startLoadData();
    }

    public void dsB() {
        this.lDI.hideProgressBar();
        endLoadData();
        this.lPi.completePullRefreshPostDelayed(0L);
        dsN();
    }

    public void dsC() {
        this.lPi.completePullRefreshPostDelayed(0L);
        dsN();
    }

    private void vs(boolean z) {
    }

    public void b(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        this.lPn.b(onLongClickListener);
        this.lPt.setOnLongClickListener(onLongClickListener);
        if (this.lQM != null) {
            this.lQM.setOnLongClickListener(onLongClickListener);
        }
    }

    public void a(final b.InterfaceC0586b interfaceC0586b, boolean z, boolean z2) {
        if (this.lIa != null) {
            this.lIa.dismiss();
            this.lIa = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lDI.getContext());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lDI.getPageContext().getString(R.string.copy), kVar));
        if (z2) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lDI.getPageContext().getString(R.string.report_text), kVar));
        } else if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lDI.getPageContext().getString(R.string.mark), kVar));
        } else {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lDI.getPageContext().getString(R.string.remove_mark), kVar));
        }
        kVar.bu(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.15
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.lPJ.dismiss();
                interfaceC0586b.a(null, i, view);
            }
        });
        this.lPJ = new com.baidu.tbadk.core.dialog.i(this.lDI.getPageContext(), kVar);
        this.lPJ.RU();
    }

    public void a(final b.InterfaceC0586b interfaceC0586b, boolean z) {
        if (this.lPJ != null) {
            this.lPJ.dismiss();
            this.lPJ = null;
        }
        com.baidu.tbadk.core.dialog.k kVar = new com.baidu.tbadk.core.dialog.k(this.lDI.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.lEP != null && this.lEP.dmU() != null && !this.lEP.dmU().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.lDI.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.lDI.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bu(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.pb.main.az.16
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar2, int i, View view) {
                az.this.lPJ.dismiss();
                interfaceC0586b.a(null, i, view);
            }
        });
        this.lPJ = new com.baidu.tbadk.core.dialog.i(this.lDI.getPageContext(), kVar);
        this.lPJ.RU();
    }

    public int dsD() {
        return Hv(this.lPi.getFirstVisiblePosition());
    }

    private int Hv(int i) {
        com.baidu.adp.widget.ListView.f adapter = this.lPi.getAdapter();
        if (adapter != null) {
            if (i < adapter.getCount() && i >= 0 && (adapter.getItem(i) instanceof com.baidu.tieba.pb.data.c)) {
                i++;
            }
            int headerViewsCount = (adapter.getHeaderViewsCount() + adapter.getWrappedCount()) - 1;
            if (i > headerViewsCount) {
                i = headerViewsCount;
            }
            int headersCount = (this.lPi.getAdapter() == null || !(this.lPi.getAdapter() instanceof com.baidu.adp.widget.ListView.f)) ? 0 : this.lPi.getAdapter().getHeadersCount();
            return i > headersCount ? i - headersCount : 0;
        }
        return i;
    }

    public int dsE() {
        int lastVisiblePosition = this.lPi.getLastVisiblePosition();
        if (this.lPk != null) {
            if (lastVisiblePosition == this.lPi.getCount() - 1) {
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
        if (this.lPi != null) {
            if (this.lPe == null || this.lPe.mNavigationBar == null) {
                i2 = 0;
            } else {
                int fixedNavHeight = this.lPe.mNavigationBar.getFixedNavHeight();
                if (this.lDI.dpq() != -1) {
                    i2 = fixedNavHeight;
                } else {
                    if (this.lQj != null && (layoutParams = (LinearLayout.LayoutParams) this.lQj.getLayoutParams()) != null) {
                        layoutParams.height = 0;
                        this.lQj.setLayoutParams(layoutParams);
                    }
                    i--;
                    i2 = fixedNavHeight;
                }
            }
            this.lPi.setSelectionFromTop(i, i2);
        }
    }

    public void setSelection(int i) {
        this.lPi.setSelection(i);
    }

    public void setSelectionFromTop(int i, int i2) {
        this.lPi.setSelectionFromTop(i, i2);
    }

    public int getPageNum() {
        try {
            return Integer.parseInt(this.lPw.getText().toString(), 10);
        } catch (Exception e) {
            return -1;
        }
    }

    public void s(com.baidu.tieba.pb.data.f fVar) {
        int i;
        this.lPt.a(fVar, false);
        this.lPt.notifyDataSetChanged();
        dsN();
        if (this.lQM != null) {
            this.lQM.bPG();
        }
        ArrayList<PostData> dmW = fVar.dmW();
        if (fVar.getPage().bnF() == 0 || dmW == null || dmW.size() < fVar.getPage().bnE()) {
            if (com.baidu.tbadk.core.util.y.getCount(dmW) == 0 || (com.baidu.tbadk.core.util.y.getCount(dmW) == 1 && dmW.get(0) != null && dmW.get(0).dPh() == 1)) {
                if (this.lQo == null || this.lQo.lRx == null || this.lQo.lRx.getView() == null) {
                    i = 0;
                } else {
                    i = this.lQo.lRx.getView().getTop() < 0 ? this.lQo.lRx.getView().getHeight() : this.lQo.lRx.getView().getBottom();
                }
                if (this.lDI.dpK()) {
                    this.jaS.ap(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i);
                } else {
                    this.jaS.ap(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i);
                }
            } else {
                if (fVar.getPage().bnF() == 0) {
                    this.jaS.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.jaS.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.jaS.bvi();
            }
        }
        u(fVar);
    }

    public void t(com.baidu.tieba.pb.data.f fVar) {
        if (this.lPl != null) {
            this.lPl.e(fVar, this.lEx);
        }
    }

    public PostData b(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dnh() != null) {
            return fVar.dnh();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dmW())) {
            Iterator<PostData> it = fVar.dmW().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dPh() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dnd();
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
        if (fVar == null || fVar.dmU() == null || fVar.dmU().boP() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData boP = fVar.dmU().boP();
        String userId = boP.getUserId();
        HashMap<String, MetaData> userMap = fVar.dmU().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = boP;
        }
        postData.KV(1);
        postData.setId(fVar.dmU().bpg());
        postData.setTitle(fVar.dmU().getTitle());
        postData.setTime(fVar.dmU().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(com.baidu.tieba.pb.data.f fVar, boolean z, int i, int i2) {
        if (fVar != null && fVar.dmU() != null) {
            if (this.lDI.dod()) {
                if (fVar.dmT() != null) {
                    this.mForumName = fVar.dmT().getForumName();
                    this.mForumId = fVar.dmT().getForumId();
                }
                if (this.mForumName == null && this.lDI.dol() != null && this.lDI.dol().doe() != null) {
                    this.mForumName = this.lDI.dol().doe();
                }
            }
            PostData b = b(fVar, z);
            a(b, fVar);
            this.lPn.setVisibility(8);
            if (fVar.dnv()) {
                this.lQD = true;
                this.lPe.vP(true);
                this.lPe.mNavigationBar.hideBottomLine();
                if (this.lPk == null) {
                    this.lPk = new com.baidu.tieba.pb.pb.main.a.e(this.lDI);
                }
                this.lPk.a(fVar, b, this.lPi, this.lPn, this.lQh, this.lPe, this.mForumName, this.lQS);
                this.lPk.V(this.lRg);
                dsI();
            } else {
                this.lQD = false;
                this.lPe.vP(this.lQD);
                if (this.lPk != null) {
                    this.lPk.c(this.lPi);
                }
            }
            if (this.lDI.dpa() != null) {
                this.lDI.dpa().vJ(this.lQD);
            }
            if (b != null) {
                this.lQd = b;
                this.lPn.setVisibility(0);
                SparseArray<Object> dtG = this.lPn.dtG();
                dtG.put(R.id.tag_clip_board, b);
                dtG.put(R.id.tag_is_subpb, false);
                this.lPo.a(fVar, this.lPi);
                this.lPm.C(fVar);
                this.lPl.e(fVar, this.lEx);
                this.lPl.B(fVar);
                this.lPn.a(this.mSkinType, this.lEP, b, this.lRg);
                if (this.lQk != null) {
                    if (fVar.dny()) {
                        this.lQk.getView().setVisibility(8);
                    } else {
                        this.lQk.getView().setVisibility(0);
                        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lCc);
                        if (fVar.dmU() != null) {
                            nVar.lCe = fVar.dmU().boG();
                        }
                        nVar.isNew = !this.lEx;
                        nVar.sortType = fVar.lAM;
                        nVar.lCg = fVar.dnz();
                        nVar.lCh = this.lDI.dpK();
                        nVar.lCi = fVar.lAL;
                        this.lQk.a(nVar);
                    }
                }
                z(fVar);
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (az.this.lPt != null && az.this.lPe != null && az.this.lPe.lVD != null && az.this.lEP != null && az.this.lEP.dmU() != null && !az.this.lEP.dmU().bnv() && !az.this.dsM() && az.this.lEP.getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(az.this.lEP.getForum().getName())) {
                            if ((az.this.lPt.doN() == null || !az.this.lPt.doN().isShown()) && az.this.lPe.lVD != null) {
                                az.this.lPe.lVD.setVisibility(0);
                                if (az.this.lDI != null && az.this.lDI.dol() != null) {
                                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13400");
                                    arVar.dY("tid", az.this.lDI.dol().dqk());
                                    arVar.dY("fid", az.this.lDI.dol().getForumId());
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
            dsF();
        } else {
            cwe();
        }
        this.lQo.lRx = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lQo));
        a(this.lQo.lRx, false);
    }

    public void dsF() {
        if (this.lPe != null && !this.lQF) {
            this.lPe.dsF();
            this.lQF = true;
        }
    }

    public void cwe() {
        if (this.lPe != null) {
            this.lPe.duf();
        }
    }

    private void a(PostData postData, com.baidu.tieba.pb.data.f fVar) {
        this.lPn.a(postData, fVar);
    }

    public void dsG() {
        if (this.lPk != null) {
            this.lPk.d(this.lPi);
        }
    }

    public boolean dsH() {
        return this.bjg;
    }

    private boolean isHost() {
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.userId);
    }

    private boolean aM(by byVar) {
        if (byVar == null || byVar.boP() == null) {
            return false;
        }
        PostData b = b(this.lEP, false);
        String str = "";
        if (b != null && b.boP() != null) {
            str = b.boP().getUserId();
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
    }

    public void a(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            this.lPe.duc();
            if (!StringUtils.isNull(dVar.forumName)) {
                this.lPe.Lf(dVar.forumName);
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
            final String str2 = dVar.lAD;
            this.lDI.showNetRefreshView(this.bIq, format, null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.az.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.adp.lib.util.l.isNetOk()) {
                        bf.bua().b(az.this.lDI.getPageContext(), new String[]{str2});
                        az.this.lDI.finish();
                        return;
                    }
                    az.this.lDI.showToast(R.string.neterror);
                }
            });
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, int i2, boolean z, int i3, boolean z2) {
        int i4;
        Parcelable drK;
        Parcelable drK2;
        if (fVar != null && this.lPi != null) {
            this.lEP = fVar;
            this.mType = i;
            if (fVar.dmU() != null) {
                this.lQq = fVar.dmU().bow();
                if (fVar.dmU().getAnchorLevel() != 0) {
                    this.bjg = true;
                }
                this.lPL = aM(fVar.dmU());
            }
            if (fVar.getUserData() != null) {
                this.userId = fVar.getUserData().getUserId();
            }
            y(fVar);
            this.lQe = false;
            this.lEx = z;
            dsB();
            if (fVar.lAN != null && fVar.lAN.dnG()) {
                if (this.lPj == null) {
                    this.lPj = new PbThreadPostView(this.lDI.getContext());
                    this.lPi.addHeaderView(this.lPj, 1);
                    this.lPj.setData(fVar);
                    this.lPj.setChildOnClickLinstener(this.iVJ);
                }
            } else if (this.lPj != null && this.lPi != null) {
                this.lPi.removeHeaderView(this.lPj);
            }
            a(fVar, z, i, TbadkCoreApplication.getInst().getSkinType());
            v(fVar);
            if (this.lQP == null) {
                this.lQP = new al(this.lDI.getPageContext(), this.jyJ);
            }
            this.lQP.Qp(fVar.dnb());
            if (this.lDI.dpA()) {
                if (this.lPx == null) {
                    this.lPx = new com.baidu.tieba.pb.view.e(this.lDI.getPageContext());
                    this.lPx.createView();
                    this.lPx.setListPullRefreshListener(this.fci);
                }
                this.lPi.setPullRefresh(this.lPx);
                dsI();
                if (this.lPx != null) {
                    this.lPx.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (fVar.getPage().bnG() == 0 && z) {
                this.lPi.setPullRefresh(null);
            } else {
                if (this.lPx == null) {
                    this.lPx = new com.baidu.tieba.pb.view.e(this.lDI.getPageContext());
                    this.lPx.createView();
                    this.lPx.setListPullRefreshListener(this.fci);
                }
                this.lPi.setPullRefresh(this.lPx);
                dsI();
                if (this.lPx != null) {
                    this.lPx.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
                cku();
            }
            dsN();
            this.lPt.uz(this.lEx);
            this.lPt.uA(false);
            this.lPt.uE(i == 5);
            this.lPt.uF(i == 6);
            this.lPt.uG(z2 && this.lRf && i != 2);
            this.lPt.a(fVar, false);
            this.lPt.notifyDataSetChanged();
            this.lPn.b(b(fVar, z), fVar.dny());
            if (fVar.dmU() != null && fVar.dmU().boA() != null && this.lPc != -1) {
                fVar.dmU().boA().setIsLike(this.lPc);
            }
            this.lPi.removeFooterView(this.bJa);
            this.lPi.addFooterView(this.bJa);
            if (TbadkCoreApplication.isLogin()) {
                this.lPi.setNextPage(this.jaS);
                this.lPd = 2;
                cku();
            } else {
                this.lQe = true;
                if (fVar.getPage().bnF() == 1) {
                    if (this.lPy == null) {
                        this.lPy = new com.baidu.tieba.pb.view.a(this.lDI, this.lDI);
                    }
                    this.lPi.setNextPage(this.lPy);
                } else {
                    this.lPi.setNextPage(this.jaS);
                }
                this.lPd = 3;
            }
            ArrayList<PostData> dmW = fVar.dmW();
            if (fVar.getPage().bnF() == 0 || dmW == null || dmW.size() < fVar.getPage().bnE()) {
                if (com.baidu.tbadk.core.util.y.getCount(dmW) == 0 || (com.baidu.tbadk.core.util.y.getCount(dmW) == 1 && dmW.get(0) != null && dmW.get(0).dPh() == 1)) {
                    if (this.lQo == null || this.lQo.lRx == null || this.lQo.lRx.getView() == null) {
                        i4 = 0;
                    } else {
                        i4 = this.lQo.lRx.getView().getTop() < 0 ? this.lQo.lRx.getView().getHeight() : this.lQo.lRx.getView().getBottom();
                    }
                    if (this.lDI.dpK()) {
                        this.jaS.ap(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), i4);
                    } else {
                        this.jaS.ap(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), i4);
                    }
                    if (this.lDI.dpa() != null && !this.lDI.dpa().dtQ()) {
                        this.lDI.dpa().showFloatingView();
                    }
                } else {
                    if (fVar.getPage().bnF() == 0) {
                        this.jaS.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jaS.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jaS.bvi();
                }
                if (fVar.getPage().bnF() == 0 || dmW == null) {
                    dsX();
                }
            } else {
                if (z2) {
                    if (this.lRf) {
                        endLoadData();
                        if (fVar.getPage().bnF() != 0) {
                            this.jaS.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.jaS.setLineVisible();
                        this.jaS.showLoading();
                    }
                } else {
                    this.jaS.setLineVisible();
                    this.jaS.showLoading();
                }
                this.jaS.bvi();
            }
            switch (i) {
                case 2:
                    this.lPi.setSelection(i2 > 1 ? (((this.lPi.getData() == null && fVar.dmW() == null) ? 0 : (this.lPi.getData().size() - fVar.dmW().size()) + this.lPi.getHeaderViewsCount()) + i2) - 2 : 0);
                    break;
                case 3:
                    if (i3 == 1 && (drK2 = as.drJ().drK()) != null && !(drK2 instanceof RecyclerView.SavedState)) {
                        this.lPi.onRestoreInstanceState(drK2);
                        if (com.baidu.tbadk.core.util.y.getCount(dmW) > 1 && fVar.getPage().bnF() > 0) {
                            this.jaS.endLoadData();
                            this.jaS.setText(this.lDI.getString(R.string.pb_load_more_without_point));
                            this.jaS.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.lRf = false;
                    break;
                case 5:
                    this.lPi.setSelection(0);
                    break;
                case 6:
                    if (i3 == 1 && (drK = as.drJ().drK()) != null && !(drK instanceof RecyclerView.SavedState)) {
                        this.lPi.onRestoreInstanceState(drK);
                        break;
                    } else {
                        this.lPi.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i2 == 0) {
                        if (this.lPk != null && this.lPk.bSt() != null) {
                            if (this.lDI.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.lPi.setSelectionFromTop((this.lPt.doI() + this.lPi.getHeaderViewsCount()) - 1, this.lPk.dtI() - com.baidu.adp.lib.util.l.getStatusBarHeight(this.lDI.getPageContext().getPageActivity()));
                            } else {
                                this.lPi.setSelectionFromTop((this.lPt.doI() + this.lPi.getHeaderViewsCount()) - 1, this.lPk.dtI());
                            }
                        } else {
                            this.lPi.setSelection(this.lPt.doI() + this.lPi.getHeaderViewsCount());
                        }
                    } else {
                        this.lPi.setSelection(i2 > 0 ? ((this.lPi.getData() == null && fVar.dmW() == null) ? 0 : (this.lPi.getData().size() - fVar.dmW().size()) + this.lPi.getHeaderViewsCount()) + i2 : 0);
                    }
                    this.jaS.endLoadData();
                    this.jaS.setText(this.lDI.getString(R.string.pb_load_more_without_point));
                    this.jaS.setLineGone();
                    break;
            }
            if (this.lQq == lQr && isHost()) {
                dte();
            }
            if (this.lQB) {
                drW();
                this.lQB = false;
                if (i3 == 0) {
                    vm(true);
                }
            }
            if (fVar.lAJ == 1 || fVar.lAK == 1) {
                if (this.lQH == null) {
                    this.lQH = new PbTopTipView(this.lDI.getContext());
                }
                if (fVar.lAK == 1 && PbActivityConfig.KEY_FROM_GUIDE.equals(this.lDI.getStType())) {
                    this.lQH.setText(this.lDI.getString(R.string.pb_read_strategy_add_experience));
                    this.lQH.a(this.bIq, this.mSkinType);
                } else if (fVar.lAJ == 1 && PbActivityConfig.KEY_FROM_NEWS.equals(this.lDI.getStType())) {
                    this.lQH.setText(this.lDI.getString(R.string.pb_read_news_add_experience));
                    this.lQH.a(this.bIq, this.mSkinType);
                }
            }
            this.lPi.removeFooterView(this.lQW.getView());
            if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dnD()) && fVar.getPage().bnF() == 0) {
                this.lPi.removeFooterView(this.bJa);
                this.lQW.HW(Math.max(this.lPR.getMeasuredHeight(), this.lQc / 2));
                this.lPi.addFooterView(this.lQW.getView());
                this.lQW.H(fVar);
            }
            u(fVar);
        }
    }

    private void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmU() != null) {
            x(fVar);
            if (fVar.bkY()) {
                WebPManager.a(this.lPV, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lPV, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String Hx = Hx(fVar.dmU().boG());
            if (this.lPY != null) {
                this.lPY.setText(Hx);
            }
            if (this.lPZ != null) {
                this.lPZ.setText(Hx);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dmU()));
        }
    }

    private String Hx(int i) {
        if (i == 0) {
            return this.lDI.getString(R.string.pb_comment_red_dot_no_reply);
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

    private void dsI() {
        if (this.lPk != null) {
            this.lPk.a(this.lPi, this.textView, this.mType);
        }
    }

    public void vu(boolean z) {
        this.lPK = z;
    }

    public void endLoadData() {
        if (this.jaS != null) {
            this.jaS.setLineGone();
            this.jaS.endLoadData();
        }
        cku();
    }

    public void bYt() {
        this.lPi.setVisibility(0);
    }

    public void dsJ() {
        if (this.lPi != null) {
            this.lPi.setVisibility(8);
        }
        if (this.lPi != null) {
            this.lQh.setVisibility(8);
        }
        if (this.lPe != null && this.lPe.jjp != null) {
            this.lPe.jjp.setVisibility(8);
        }
    }

    public void dsK() {
        if (this.lPi != null) {
            this.lPi.setVisibility(0);
        }
        if (this.lQh != null) {
            this.lQh.setVisibility(0);
        }
        if (this.lPe != null && this.lPe.jjp != null) {
            this.lPe.jjp.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void v(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && this.lQd != null && this.lQd.boP() != null && this.lPe != null) {
            this.lQE = !this.lQD;
            this.lPe.vL(this.lQE);
            if (this.lDI.dpa() != null) {
                this.lDI.dpa().vK(this.lQE);
            }
            dsL();
            if (this.lDI != null && !this.lDI.dod() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dnr())) {
                bu buVar = fVar.dnr().get(0);
                if (buVar != null) {
                    this.lPe.fZ(buVar.getForumName(), buVar.getAvatar());
                }
            } else if (fVar.getForum() != null) {
                this.lPe.fZ(fVar.getForum().getName(), fVar.getForum().getImage_url());
            }
            if (this.lQE) {
                this.lPn.a(fVar, this.lQd, this.lPL);
                if (this.lQj != null) {
                    this.lQj.setVisibility(8);
                }
                if (this.lQN == null) {
                    this.lQN = new PbLandscapeListView.b() { // from class: com.baidu.tieba.pb.pb.main.az.20
                        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
                        public void b(int i, int i2, float f, float f2, float f3, float f4) {
                            if (az.this.lDI != null && az.this.lDI.isAdded()) {
                                if (i < 0 && f > az.this.lQG) {
                                    az.this.dsS();
                                    az.this.dtd();
                                }
                                az.this.dsC();
                            }
                        }
                    };
                }
                this.lPi.setListViewDragListener(this.lQN);
                return;
            }
            if (this.lQj != null) {
                this.lQj.setVisibility(0);
            }
            this.lPn.a(fVar, this.lQd, this.lPL);
            this.lQN = null;
            this.lPi.setListViewDragListener(null);
        }
    }

    private void dsL() {
        this.lPn.a(this.lEP, this.lQd, this.lQE, this.lQD);
    }

    public boolean dsM() {
        return this.lEP == null || this.lEP.getForum() == null || "0".equals(this.lEP.getForum().getId()) || "me0407".equals(this.lEP.getForum().getName());
    }

    private boolean dsN() {
        return this.lPl.vG(this.lEx);
    }

    private boolean w(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dmU() == null) {
            return false;
        }
        if (fVar.dmU().boM() == 1 || fVar.dmU().getThreadType() == 33) {
            return true;
        }
        return !(fVar.dmU().boO() == null || fVar.dmU().boO().bri() == 0) || fVar.dmU().boK() == 1 || fVar.dmU().boL() == 1 || fVar.dmU().bpD() || fVar.dmU().bpZ() || fVar.dmU().bpS() || fVar.dmU().bpa() != null || !com.baidu.tbadk.core.util.au.isEmpty(fVar.dmU().getCategory()) || fVar.dmU().boS() || fVar.dmU().boR();
    }

    public boolean c(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            if (this.lPm != null) {
                if (fVar.dmU() != null && fVar.dmU().bpd() == 0 && !fVar.dmU().bnv() && !this.lQY) {
                    if (fVar.dmU() != null) {
                        by dmU = fVar.dmU();
                        dmU.z(true, w(fVar));
                        dmU.oC(3);
                        dmU.Bd("2");
                    }
                    if (fVar.dmU().bnx()) {
                        this.lPn.c(this.lPi);
                        this.lPm.c(this.lPi);
                        this.lPm.b(this.lPi);
                        this.lPn.b(this.lPi);
                        this.lPn.G(this.lEP);
                        if (A(fVar)) {
                            this.lPm.c(this.lPi);
                        } else {
                            this.lPm.D(fVar);
                        }
                    } else {
                        this.lPn.G(this.lEP);
                        if (A(fVar)) {
                            this.lPm.c(this.lPi);
                        } else {
                            this.lPm.F(fVar);
                        }
                    }
                } else if (fVar.dmU().bpd() == 1) {
                    if (fVar.dmU() != null) {
                        this.lPm.c(this.lPi);
                        this.lPn.G(this.lEP);
                    }
                } else {
                    this.lPm.c(this.lPi);
                    this.lPn.G(this.lEP);
                }
            }
            z(fVar);
            this.lEx = z;
        }
        return false;
    }

    @SuppressLint({"CutPasteId"})
    public void d(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (fVar != null) {
            c(fVar, z);
            dsN();
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dnj()));
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dnj()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bu> dnr = fVar.dnr();
                if (com.baidu.tbadk.core.util.y.getCount(dnr) > 0) {
                    sb = new StringBuilder();
                    for (bu buVar : dnr) {
                        if (buVar != null && !StringUtils.isNull(buVar.getForumName()) && (acVar = buVar.eIt) != null && acVar.eGf && !acVar.eGg && (acVar.type == 1 || acVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(buVar.getForumName(), 12)).append(this.lDI.getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.lDI.getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    public View dsO() {
        return this.fBr;
    }

    public boolean dsP() {
        if (this.bJa == null || this.bJa.getParent() == null || this.jaS.isLoading()) {
            return false;
        }
        int bottom = this.bJa.getBottom();
        Rect rect = new Rect();
        this.bJa.getWindowVisibleDisplayFrame(rect);
        return bottom > 0 && bottom <= rect.bottom;
    }

    public void Qr(String str) {
        if (this.jaS != null) {
            this.jaS.setText(str);
        }
    }

    public void Qs(String str) {
        if (this.jaS != null) {
            int i = 0;
            if (this.lQo != null && this.lQo.lRx != null && this.lQo.lRx.getView() != null) {
                i = this.lQo.lRx.getView().getTop() < 0 ? this.lQo.lRx.getView().getHeight() : this.lQo.lRx.getView().getBottom();
            }
            this.jaS.ap(str, i);
        }
    }

    public BdTypeListView getListView() {
        return this.lPi;
    }

    public int dsQ() {
        return R.id.richText;
    }

    public TextView dov() {
        return this.lPn.dov();
    }

    public void d(BdListView.e eVar) {
        this.lPi.setOnSrollToBottomListener(eVar);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.fci = cVar;
        if (this.lPx != null) {
            this.lPx.setListPullRefreshListener(cVar);
        }
    }

    public void a(com.baidu.tbadk.core.data.ax axVar, a.b bVar) {
        if (axVar != null) {
            int bnD = axVar.bnD();
            int bnA = axVar.bnA();
            if (this.lPu != null) {
                this.lPu.brv();
            } else {
                this.lPu = new com.baidu.tbadk.core.dialog.a(this.lDI.getPageContext().getPageActivity());
                this.lPv = LayoutInflater.from(this.lDI.getPageContext().getPageActivity()).inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                this.lPu.bi(this.lPv);
                this.lPu.a(R.string.dialog_ok, bVar);
                this.lPu.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        az.this.dsS();
                        aVar.dismiss();
                    }
                });
                this.lPu.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.main.az.23
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (az.this.lQy == null) {
                            az.this.lQy = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.23.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    az.this.lDI.HidenSoftKeyPad((InputMethodManager) az.this.lDI.getBaseFragmentActivity().getSystemService("input_method"), az.this.bIq);
                                }
                            };
                        }
                        com.baidu.adp.lib.f.e.mY().postDelayed(az.this.lQy, 150L);
                    }
                });
                this.lPu.b(this.lDI.getPageContext()).brv();
            }
            this.lPw = (EditText) this.lPv.findViewById(R.id.input_page_number);
            this.lPw.setText("");
            TextView textView = (TextView) this.lPv.findViewById(R.id.current_page_number);
            if (bnD <= 0) {
                bnD = 1;
            }
            if (bnA <= 0) {
                bnA = 1;
            }
            textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(bnD), Integer.valueOf(bnA)));
            this.lDI.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.lPw, 150);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.lPi.setOnScrollListener(onScrollListener);
    }

    public void showToast(String str) {
        this.lDI.showToast(str);
    }

    public boolean vv(boolean z) {
        if (this.acn == null || !this.acn.bCr()) {
            return false;
        }
        this.acn.bAK();
        return true;
    }

    public void dsR() {
        if (this.lRh != null) {
            while (this.lRh.size() > 0) {
                TbImageView remove = this.lRh.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void onPause() {
        dsR();
        this.lPt.GW(1);
        if (this.lPk != null) {
            this.lPk.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        this.lPt.GW(2);
        if (this.lPk != null) {
            this.lPk.onResume();
            if (!TbSingleton.getInstance().isNotchScreen(this.lDI.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.lDI.getFragmentActivity())) {
                getView().setSystemUiVisibility(4);
            }
        }
    }

    public void onDestroy() {
        if (this.lPX != null) {
            this.lPX.onDestroy();
        }
        if (this.lQA != null) {
            this.lQA.destroy();
        }
        if (this.lQP != null) {
            this.lQP.onDestory();
        }
        if (this.lQH != null) {
            this.lQH.hide();
        }
        this.lDI.hideProgressBar();
        if (this.gpw != null && this.iQh != null) {
            this.gpw.b(this.iQh);
        }
        dsS();
        endLoadData();
        if (this.lQy != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lQy);
        }
        if (this.lQg != null) {
            this.lQg.clearStatus();
        }
        this.lRb = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.lPt.GW(3);
        if (this.bHy != null) {
            this.bHy.setBackgroundDrawable(null);
        }
        if (this.lPk != null) {
            this.lPk.destroy();
        }
        if (this.lPt != null) {
            this.lPt.onDestroy();
        }
        this.lPi.setOnLayoutListener(null);
        if (this.lQL != null) {
            this.lQL.cFh();
        }
        if (this.lQp != null) {
            this.lQp.onDestroy();
        }
        if (this.lPn != null) {
            this.lPn.onDestroy();
        }
    }

    public boolean Hy(int i) {
        if (this.lPk != null) {
            return this.lPk.Hy(i);
        }
        return false;
    }

    public void dsS() {
        this.lPe.bca();
        if (this.lPn != null) {
            this.lPn.dsS();
        }
        if (this.lDI != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(this.lDI.getContext(), this.lPw);
        }
        drY();
        if (this.lIa != null) {
            this.lIa.dismiss();
        }
        dsU();
        if (this.lPu != null) {
            this.lPu.dismiss();
        }
        if (this.iVI != null) {
            this.iVI.dismiss();
        }
    }

    public void dsT() {
        this.lPe.bca();
        if (this.lPn != null) {
            this.lPn.dsS();
        }
        if (this.lIa != null) {
            this.lIa.dismiss();
        }
        dsU();
        if (this.lPu != null) {
            this.lPu.dismiss();
        }
        if (this.iVI != null) {
            this.iVI.dismiss();
        }
    }

    public void fp(List<String> list) {
        this.lQK = list;
        if (this.lQL != null) {
            this.lQL.setData(list);
        }
    }

    public void uy(boolean z) {
        this.lPt.uy(z);
    }

    public void vw(boolean z) {
        this.lPN = z;
    }

    public void dsU() {
        if (this.lPB != null) {
            this.lPB.dismiss();
        }
        if (this.lPC != null) {
            com.baidu.adp.lib.f.g.b(this.lPC, this.lDI.getPageContext());
        }
        if (this.lPD != null) {
            com.baidu.adp.lib.f.g.b(this.lPD, this.lDI.getPageContext());
        }
        if (this.lPA != null) {
            this.lPA.dismiss();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            d(this.lEP, this.lEx);
            b(this.lEP, this.lEx, this.mType, i);
            this.lDI.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
            this.lDI.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bIq);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bIq, R.color.CAM_X0201);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lPO, R.color.CAM_X0203);
            if (this.lPk != null) {
                this.lPk.onChangeSkinType(i);
            }
            if (this.lPo != null) {
                this.lPo.onChangeSkinType(i);
            }
            if (this.lPl != null) {
                this.lPl.onChangeSkinType(i);
            }
            if (this.lPm != null) {
                this.lPm.onChangeSkinType(i);
            }
            if (this.lPn != null) {
                this.lPn.onChangeSkinType(i);
            }
            if (this.jaS != null) {
                this.jaS.changeSkin(i);
            }
            if (this.fBr != null) {
                this.lDI.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fBr);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.fBr, R.drawable.pb_foot_more_trans_selector);
            }
            if (this.lPu != null) {
                this.lPu.c(this.lDI.getPageContext());
            }
            vu(this.lPK);
            this.lPt.notifyDataSetChanged();
            if (this.lPx != null) {
                this.lPx.changeSkin(i);
            }
            if (this.acn != null) {
                this.acn.onChangeSkinType(i);
            }
            if (this.lPy != null) {
                this.lPy.changeSkin(i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.ilV)) {
                for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.ilV) {
                    customBlueCheckRadioButton.buS();
                }
            }
            dsq();
            UtilHelper.setStatusBarBackground(this.bHy, i);
            UtilHelper.setStatusBarBackground(this.lQj, i);
            if (this.lPp != null) {
                com.baidu.tbadk.r.a.a(this.lDI.getPageContext(), this.lPp);
            }
            if (this.lQz != null) {
                this.lQz.onChangeSkinType(i);
            }
            if (this.lPe != null) {
                if (this.lPk != null) {
                    this.lPk.Hz(i);
                } else {
                    this.lPe.onChangeSkinType(i);
                }
            }
            if (this.lPT != null) {
                this.lPT.setBorderColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0401));
            }
            if (this.lPS != null) {
                this.lPS.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aR(com.baidu.adp.lib.util.l.getDimens(this.lDI.getContext(), R.dimen.tbds47), com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0209)));
            }
            if (this.lEP != null && this.lEP.bkY()) {
                WebPManager.a(this.lPV, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.lPV, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.a(this.lPU, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            x(this.lEP);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lPR, R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lPQ, R.color.CAM_X0203);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lQJ, R.color.cp_cont_n);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jYt, R.color.CAM_X0109);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lPZ, R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lPY, R.color.CAM_X0107);
            com.baidu.tbadk.core.util.ap.d(this.lPY, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (this.lQM != null) {
                this.lQM.onChangeSkinType(i);
            }
            if (this.lQp != null) {
                this.lQp.onChangeSkinType();
            }
            if (this.lPj != null) {
                this.lPj.vJ(i);
            }
            if (this.lPX != null) {
                this.lPX.onChangeSkinType();
            }
            if (this.lQW != null) {
                this.lQW.onChangeSkinType();
            }
        }
    }

    public void dsV() {
        if (this.lPX != null) {
            this.lPX.setEnable(false);
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bb(fVar.dmU())) {
            if (this.lPX != null) {
                this.lPX.setEnable(false);
                this.lPX.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.lPW.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.lPW.setLayoutParams(layoutParams);
            WebPManager.a(this.lPW, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.lPX == null || !this.lPX.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.lPW.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.lPW.setLayoutParams(layoutParams2);
            WebPManager.a(this.lPW, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fNk = iVar;
        this.lPt.setOnImageClickListener(this.fNk);
        this.lQM.setOnImageClickListener(this.fNk);
    }

    public void g(NoNetworkView.a aVar) {
        this.iQh = aVar;
        if (this.gpw != null) {
            this.gpw.a(this.iQh);
        }
    }

    public void vx(boolean z) {
        this.lPt.setIsFromCDN(z);
    }

    public Button dsW() {
        return this.lPP;
    }

    public void dsX() {
        if (this.lPd != 2) {
            this.lPi.setNextPage(this.jaS);
            this.lPd = 2;
        }
    }

    public boolean dsY() {
        return this.acn != null && this.acn.getVisibility() == 0;
    }

    public boolean dsZ() {
        return this.acn != null && this.acn.bCr();
    }

    public void dta() {
        if (this.acn != null) {
            this.acn.bAK();
        }
    }

    public void vy(boolean z) {
        if (this.lPR != null) {
            vw(this.lDI.doX().bDb());
            if (this.lPN) {
                vn(z);
            } else {
                vo(z);
            }
        }
    }

    public void dtb() {
        if (this.lPR != null) {
            this.lPQ.setVisibility(8);
            this.lPR.setVisibility(8);
            this.lQa = false;
            if (this.lQp != null) {
                this.lQp.setVisibility(8);
                vs(false);
            }
        }
    }

    public void showLoadingDialog() {
        if (this.iqj == null) {
            this.iqj = new com.baidu.tbadk.core.view.a(this.lDI.getPageContext());
        }
        this.iqj.setDialogVisiable(true);
    }

    public void cku() {
        if (this.iqj != null) {
            this.iqj.setDialogVisiable(false);
        }
    }

    private int getScrollY() {
        View childAt = this.lPi.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (this.lPi.getFirstVisiblePosition() * childAt.getHeight()) + (-childAt.getTop());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.lPk != null) {
            this.lPk.onScrollStateChanged(absListView, i);
        }
        if (!this.isLandscape && i == 0) {
            this.lRi = getScrollY();
            this.lQo.lRx = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lQo));
            a(this.lQo.lRx, true);
            dtq();
        }
    }

    public void vz(boolean z) {
        if (this.lPk != null) {
            this.lPk.vz(z);
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
        if (this.lPk != null) {
            this.lPk.onScroll(absListView, i, i2, i3);
        }
        if (this.lPe != null && this.lPn != null) {
            this.lPe.dF(this.lPn.dtE());
        }
        this.lQo.luu = i;
        this.lQo.headerCount = this.lPi.getHeaderViewsCount();
        this.lQo.lRx = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL, this.lQo));
        vp(b(absListView, i));
        a(this.lQo.lRx, false);
        dtq();
        if (this.jaS.bvj() && !this.jaS.fbm) {
            if (this.lQo != null && this.lQo.lRx != null && this.lQo.lRx.getView() != null) {
                i4 = this.lQo.lRx.getView().getTop() < 0 ? this.lQo.lRx.getView().getHeight() : this.lQo.lRx.getView().getBottom();
            }
            this.jaS.qT(i4);
            this.jaS.fbm = true;
        }
    }

    public void dtc() {
        if (TbadkCoreApplication.isLogin() && this.lEP != null && this.lQE && !this.lQD && !this.lPL && this.lQd != null && this.lQd.boP() != null && !this.lQd.boP().getIsLike() && !this.lQd.boP().hadConcerned() && this.lQA == null) {
            this.lQA = new av(this.lDI);
        }
    }

    public void dtd() {
        if (this.lDI != null) {
            if ((this.iSL || this.lQT == 17) && com.baidu.tbadk.a.d.bku()) {
                if (this.lEP != null && this.lEP.getForum() != null && !com.baidu.tbadk.core.util.au.isEmpty(this.lEP.getForum().getName())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.lDI.getContext()).createNormalCfg(this.lEP.getForum().getName(), null)));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13853").dY("post_id", this.lEP.getThreadId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("fid", this.lEP.getForum().getId()));
                }
            } else if (this.lQE && !this.lQD && this.lQd != null && this.lQd.boP() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12601").al("obj_locate", this.lDI.dod() ? 2 : 1).al("obj_type", this.lQD ? 2 : 1));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.lDI.getPageContext().getPageActivity(), this.lQd.boP().getUserId(), this.lQd.boP().getUserName(), this.lDI.dol().doe(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    }

    private void a(au auVar, boolean z) {
        int measuredHeight;
        if (!this.lQD && this.lQi != null && this.lPe.dtW() != null) {
            int doJ = this.lPt.doJ();
            if (doJ > 0 && (auVar == null || auVar.getView().getParent() == null)) {
                if (doJ > this.lPi.getFirstVisiblePosition() - this.lPi.getHeaderViewsCount()) {
                    this.lQi.setVisibility(4);
                    return;
                }
                this.lQi.setVisibility(0);
                vp(false);
                this.lPe.mNavigationBar.hideBottomLine();
                if (this.lQi.getParent() != null && ((ViewGroup) this.lQi.getParent()).getHeight() <= this.lQi.getTop()) {
                    this.lQi.getParent().requestLayout();
                }
            } else if (auVar == null || auVar.getView() == null || auVar.lOD == null) {
                if (this.lPi.getFirstVisiblePosition() == 0) {
                    this.lQi.setVisibility(4);
                    this.lPe.mNavigationBar.hideBottomLine();
                }
            } else {
                int top = auVar.getView().getTop();
                if (auVar.getView().getParent() != null) {
                    if (this.lQn) {
                        this.lQm = top;
                        this.lQn = false;
                    }
                    this.lQm = top < this.lQm ? top : this.lQm;
                }
                if (top != 0 || auVar.getView().isShown()) {
                    if (this.lPs.getY() < 0.0f) {
                        measuredHeight = lQl - auVar.lOD.getMeasuredHeight();
                    } else {
                        measuredHeight = this.lPe.dtW().getMeasuredHeight() - auVar.lOD.getMeasuredHeight();
                        this.lPe.mNavigationBar.hideBottomLine();
                    }
                    if (auVar.getView().getParent() == null && top <= this.lQm) {
                        this.lQi.setVisibility(0);
                        vp(false);
                    } else if (top < measuredHeight) {
                        this.lQi.setVisibility(0);
                        vp(false);
                    } else {
                        this.lQi.setVisibility(4);
                        this.lPe.mNavigationBar.hideBottomLine();
                    }
                    if (z) {
                        this.lQn = true;
                    }
                }
            }
        }
    }

    public void dte() {
        if (!this.lRj) {
            TiebaStatic.log("c10490");
            this.lRj = true;
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lDI.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(lQs, Integer.valueOf(lQu));
            aVar.oP(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.lDI.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            aVar.bi(inflate);
            aVar.setYesButtonTag(sparseArray);
            aVar.a(R.string.grade_button_tips, this.lDI);
            aVar.b(R.string.look_again, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.24
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lDI.getPageContext()).brv();
        }
    }

    public void Qt(String str) {
        if (str.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            str = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, "\n");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lDI.getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(this.lDI.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.title_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(3);
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
        aVar.bi(inflate);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(lQs, Integer.valueOf(lQv));
        aVar.setYesButtonTag(sparseArray);
        aVar.a(R.string.view, this.lDI);
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.az.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lDI.getPageContext()).brv();
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
        this.lPn.onChangeSkinType(i2);
    }

    public PbInterviewStatusView dtf() {
        return this.lQg;
    }

    private void y(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmU() != null && fVar.dmU().bpZ() && this.lQg == null) {
            this.lQg = (PbInterviewStatusView) this.lQf.inflate();
            this.lQg.setOnClickListener(this.iVJ);
            this.lQg.setCallback(this.lDI.dpI());
            this.lQg.setData(this.lDI, fVar);
        }
    }

    public RelativeLayout dtg() {
        return this.lPs;
    }

    public View dth() {
        return this.bHy;
    }

    public boolean dti() {
        return this.lQY;
    }

    public void uD(boolean z) {
        this.lPn.uD(z);
    }

    public void Qu(String str) {
        if (this.lPf != null) {
            this.lPf.setTitle(str);
        }
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    private int vA(boolean z) {
        if (this.lQg == null || this.lQg.getVisibility() != 0 || !z) {
            return 0;
        }
        return 0 + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds72);
    }

    private void dtj() {
        if (this.lQg != null && this.lQg.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lQg.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.lQg.setLayoutParams(layoutParams);
        }
    }

    public boolean dpd() {
        return false;
    }

    public void Qv(String str) {
        this.jYt.performClick();
        if (!StringUtils.isNull(str) && this.lDI.doX() != null && this.lDI.doX().bCT() != null && this.lDI.doX().bCT().getInputView() != null) {
            EditText inputView = this.lDI.doX().bCT().getInputView();
            inputView.setText(str);
            inputView.setSelection(str.length());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            dsS();
            if (configuration.orientation == 2) {
                dtb();
                drY();
            } else {
                dsc();
            }
            if (this.lQz != null) {
                this.lQz.doS();
            }
            this.lDI.cCG();
            this.lPs.setVisibility(8);
            this.lPe.vM(false);
            this.lDI.uS(false);
            if (this.lPk != null) {
                if (configuration.orientation == 1) {
                    dtg().setVisibility(0);
                }
                if (configuration.orientation == 2) {
                    this.isLandscape = true;
                    this.lPi.setIsLandscape(true);
                    this.lPi.smoothScrollToPosition(0);
                } else {
                    this.isLandscape = false;
                    this.lPi.setIsLandscape(false);
                    if (this.lRi > 0) {
                        this.lPi.smoothScrollBy(this.lRi, 0);
                    }
                }
                this.lPk.onConfigurationChanged(configuration);
                this.lQh.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void vB(boolean z) {
        if (this.lPk != null) {
            this.lPk.vB(z);
        }
    }

    public boolean dtk() {
        return this.lPk != null && this.lPk.dtk();
    }

    public void dtl() {
        if (this.lPk != null) {
            this.lPk.dtl();
        }
    }

    public void uH(boolean z) {
        this.lPt.uH(z);
    }

    public void dE(final View view) {
        if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, false)) {
            Rect rect = new Rect();
            this.lPR.getGlobalVisibleRect(rect);
            final int i = rect.bottom;
            final int i2 = rect.top;
            view.getGlobalVisibleRect(rect);
            final int i3 = rect.bottom;
            FrameLayout frameLayout = new FrameLayout(this.lDI.getContext());
            frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
            this.lQJ = new TextView(this.lDI.getContext());
            this.lQJ.setText(R.string.connection_tips);
            this.lQJ.setGravity(17);
            this.lQJ.setPadding(com.baidu.adp.lib.util.l.getDimens(this.lDI.getContext(), R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(this.lDI.getContext(), R.dimen.ds24), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.height = com.baidu.adp.lib.util.l.getDimens(this.lDI.getContext(), R.dimen.ds60);
            if (this.lQJ.getParent() == null) {
                frameLayout.addView(this.lQJ, layoutParams);
            }
            this.lQI = new PopupWindow(this.lDI.getContext());
            this.lQI.setContentView(frameLayout);
            this.lQI.setHeight(-2);
            this.lQI.setWidth(-2);
            this.lQI.setFocusable(true);
            this.lQI.setOutsideTouchable(false);
            this.lQI.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
            this.lPi.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.az.26
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == i || i3 - i2 >= 0) {
                        az.this.lQI.showAsDropDown(az.this.lPR, view.getLeft(), -az.this.lPR.getHeight());
                    } else {
                        az.this.lQI.showAsDropDown(view);
                    }
                }
            }, 100L);
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.SHOW_LONG_PRESS_COLLECTION_TIPS, true);
        }
    }

    public void vC(boolean z) {
        this.lQO = z;
    }

    public boolean dtm() {
        return this.lQO;
    }

    public PbThreadPostView dtn() {
        return this.lPj;
    }

    private void z(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmU() != null && !fVar.dmU().bnv()) {
            boolean z = fVar.dmU().boL() == 1;
            boolean z2 = fVar.dmU().boK() == 1;
            if (this.lPn != null) {
                this.lPn.c(fVar, z, z2);
            }
            if (this.lPt != null && this.lPt.doO() != null) {
                this.lPt.doO().b(fVar, z, z2);
            }
        }
    }

    public void vD(boolean z) {
        this.iSL = z;
    }

    public void Hq(int i) {
        this.lQT = i;
    }

    public void dto() {
        if (this.lPi != null) {
            this.lPi.setForbidDragListener(true);
        }
    }

    public boolean dqc() {
        if (this.lPi == null) {
            return false;
        }
        return this.lPi.dqc();
    }

    public boolean dtp() {
        if (this.jaS == null || TextUtils.isEmpty(this.jaS.getEndText())) {
            return false;
        }
        return this.jaS.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }

    private boolean A(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dmU() == null) {
            return false;
        }
        SpannableStringBuilder bpz = fVar.dmU().bpz();
        if (bpz != null) {
            return TbadkApplication.getInst().getResources().getString(R.string.pb_default_share_tie_title).equals(bpz.toString());
        }
        return true;
    }

    public void dtq() {
        boolean z;
        if (this.lQW != null) {
            if (((this.lQW.getView() == null || this.lQW.getView().getParent() == null) ? -1 : this.lPi.getPositionForView(this.lQW.getView())) != -1) {
                if (this.lQW.getView().getTop() + lQU <= this.lQi.getBottom()) {
                    this.lQV = 1;
                    z = true;
                } else {
                    this.lQV = 0;
                    z = false;
                }
            } else {
                z = this.lQV == 1;
            }
            this.lQk.vl(this.lQV == 1);
            this.lQW.setScrollable(z);
        }
    }
}
