package com.baidu.tieba.pb.pb.main;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FoldCommentActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.NovelWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.EnterForePvThread;
import com.baidu.tbadk.core.util.FirstPraiseToast;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.GroupChatEntranceStatisticUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageHelper;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.util.PushOpenUtil;
import com.baidu.tbadk.coreExtra.util.PushPermissionController;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.AdverSegmentData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.PbNewEditorTool;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.mutiprocess.ResponsedEventListener;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tbadk.switchs.PbLoadingViewOptimizeSwitch;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.VCenterTextSpan;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.a45;
import com.baidu.tieba.af9;
import com.baidu.tieba.ag;
import com.baidu.tieba.ah9;
import com.baidu.tieba.aiapps.TbAiappsLaunchUtil;
import com.baidu.tieba.ak9;
import com.baidu.tieba.b05;
import com.baidu.tieba.bc9;
import com.baidu.tieba.bg;
import com.baidu.tieba.bh5;
import com.baidu.tieba.bi;
import com.baidu.tieba.bi9;
import com.baidu.tieba.bka;
import com.baidu.tieba.br5;
import com.baidu.tieba.bw4;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.ci9;
import com.baidu.tieba.cm6;
import com.baidu.tieba.cn;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d25;
import com.baidu.tieba.df9;
import com.baidu.tieba.dj9;
import com.baidu.tieba.dk5;
import com.baidu.tieba.dk9;
import com.baidu.tieba.dt4;
import com.baidu.tieba.e35;
import com.baidu.tieba.e95;
import com.baidu.tieba.eh5;
import com.baidu.tieba.ek9;
import com.baidu.tieba.eka;
import com.baidu.tieba.em9;
import com.baidu.tieba.et4;
import com.baidu.tieba.fe5;
import com.baidu.tieba.fi9;
import com.baidu.tieba.fk9;
import com.baidu.tieba.gg9;
import com.baidu.tieba.gj9;
import com.baidu.tieba.gk9;
import com.baidu.tieba.gr5;
import com.baidu.tieba.h55;
import com.baidu.tieba.h9;
import com.baidu.tieba.hi9;
import com.baidu.tieba.i95;
import com.baidu.tieba.iba;
import com.baidu.tieba.ii9;
import com.baidu.tieba.ij9;
import com.baidu.tieba.jd5;
import com.baidu.tieba.je9;
import com.baidu.tieba.jj9;
import com.baidu.tieba.ke9;
import com.baidu.tieba.kf5;
import com.baidu.tieba.kh9;
import com.baidu.tieba.kv5;
import com.baidu.tieba.l05;
import com.baidu.tieba.lg9;
import com.baidu.tieba.lh5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.m15;
import com.baidu.tieba.m45;
import com.baidu.tieba.me9;
import com.baidu.tieba.mh9;
import com.baidu.tieba.mj5;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.n45;
import com.baidu.tieba.nf5;
import com.baidu.tieba.nj5;
import com.baidu.tieba.nw6;
import com.baidu.tieba.or5;
import com.baidu.tieba.ow6;
import com.baidu.tieba.p06;
import com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.controller.PbGodGuideController;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pj5;
import com.baidu.tieba.qba;
import com.baidu.tieba.qj5;
import com.baidu.tieba.qr5;
import com.baidu.tieba.r85;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.rba;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.tieba.rg5;
import com.baidu.tieba.rg9;
import com.baidu.tieba.rj5;
import com.baidu.tieba.rk9;
import com.baidu.tieba.rl5;
import com.baidu.tieba.rl9;
import com.baidu.tieba.s06;
import com.baidu.tieba.s45;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.sr6;
import com.baidu.tieba.sw7;
import com.baidu.tieba.t25;
import com.baidu.tieba.ta5;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.td5;
import com.baidu.tieba.td9;
import com.baidu.tieba.th5;
import com.baidu.tieba.th9;
import com.baidu.tieba.tj5;
import com.baidu.tieba.tk9;
import com.baidu.tieba.u45;
import com.baidu.tieba.u9a;
import com.baidu.tieba.ud9;
import com.baidu.tieba.ur5;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.uv9;
import com.baidu.tieba.v25;
import com.baidu.tieba.v45;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vl9;
import com.baidu.tieba.w05;
import com.baidu.tieba.w16;
import com.baidu.tieba.w45;
import com.baidu.tieba.wb9;
import com.baidu.tieba.wg5;
import com.baidu.tieba.wh5;
import com.baidu.tieba.wq5;
import com.baidu.tieba.xba;
import com.baidu.tieba.xca;
import com.baidu.tieba.xh5;
import com.baidu.tieba.xj9;
import com.baidu.tieba.xk9;
import com.baidu.tieba.yh5;
import com.baidu.tieba.ym;
import com.baidu.tieba.yy4;
import com.baidu.tieba.z3a;
import com.baidu.tieba.zb9;
import com.baidu.tieba.ze9;
import com.baidu.tieba.zj9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.SmartApp;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class PbFragment extends BaseFragment implements s06, VoiceManager.i, UserIconBox.c, View.OnTouchListener, m45.e, TbRichTextView.t, TbPageContextSupport, vl9, em9.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k T2;
    public static final ow6.b U2;
    public transient /* synthetic */ FieldHolder $fh;
    public ag<ImageView> A;
    public PbModel A0;
    public CustomMessageListener A1;
    public int A2;
    public ag<View> B;
    public xk9 B0;
    public CustomMessageListener B1;
    public final TbRichTextView.z B2;
    public ag<TiebaPlusRecommendCard> C;
    public bw4 C0;
    public CustomMessageListener C1;
    public boolean C2;
    public ag<LinearLayout> D;
    public ForumManageModel D0;
    public CustomMessageListener D1;
    public rba D2;
    public ag<RelativeLayout> E;
    public fe5 E0;
    public final CustomMessageListener E1;
    public final n45.c E2;
    public ag<ItemCardView> F;
    public me9 F0;
    public CustomMessageListener F1;
    public final n45.c F2;
    @NonNull
    public PbGodGuideController G;
    public PollingModel G0;
    public CustomMessageListener G1;
    public final AdapterView.OnItemClickListener G2;
    public ag<FestivalTipView> H;
    public ShareSuccessReplyToServerModel H0;
    public View.OnClickListener H1;
    public final View.OnLongClickListener H2;
    public boolean I;
    public ci9 I0;
    public CustomMessageListener I1;
    public final View.OnClickListener I2;
    public boolean J;
    public boolean J0;
    public CustomMessageListener J1;
    public final ItemCardHelper.c J2;
    public boolean K;
    public boolean K0;
    public CustomMessageListener K1;
    public final NoNetworkView.b K2;
    public ag<GifView> L;
    public boolean L0;
    public CustomMessageListener L1;
    public View.OnTouchListener L2;
    public String M;
    public fi9 M0;
    public CustomMessageListener M1;
    public nw6.b M2;
    public boolean N;
    public u45 N0;
    public SuggestEmotionModel.c N1;
    public final rg9.b N2;
    public boolean O;
    public w45 O0;
    public CustomMessageListener O1;
    public int O2;
    public String P;
    public String P0;
    public GetSugMatchWordsModel.b P1;
    public int P2;
    public LikeModel Q;
    public boolean Q0;
    public PraiseModel Q1;
    public String Q2;
    public View R;
    public boolean R0;
    public jj9.h R1;
    public m15 R2;
    public View S;
    public boolean S0;
    public CustomMessageListener S1;
    public int S2;

    /* renamed from: T  reason: collision with root package name */
    public View f1144T;
    public String T0;
    public ResponsedEventListener T1;
    public View U;
    public boolean U0;
    public ResponsedEventListener U1;
    public String V;
    public iba V0;
    public CheckRealNameModel.b V1;
    public int W;
    public rj5 W0;
    public af9 W1;
    public boolean X;
    public qj5 X0;
    public final Runnable X1;
    public int[] Y;
    public PermissionJudgePolicy Y0;
    public CustomMessageListener Y1;
    public int Z;
    public ReplyPrivacyCheckController Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public int a0;
    public fk9 a1;
    public CustomMessageListener a2;
    public boolean b;
    public int b0;
    public nj5 b1;
    public CustomMessageListener b2;
    public boolean c;
    public e35 c0;
    public mj5 c1;
    public CustomMessageListener c2;
    public ow6 d;
    public BdUniqueId d0;
    public mj5 d1;
    public CustomMessageListener d2;
    public jj9 e;
    public r85 e0;
    public int e1;
    public CustomMessageListener e2;
    public boolean f;
    public boolean f0;
    public Object f1;
    public CustomMessageListener f2;
    public boolean g;
    public boolean g0;
    public BdPageContext g1;
    public m45.e g2;
    public boolean h;
    public Object h0;
    public e95 h1;
    public f3 h2;
    public VoiceManager i;
    public AgreeMessageData i0;
    public BdUniqueId i1;
    public w45.f i2;
    public int j;
    public kf5 j0;
    public Runnable j1;
    public final SortSwitchButton.f j2;
    public n45 k;
    public hi9 k1;
    public final View.OnClickListener k2;
    public long l;
    public BdImage l1;
    public CustomMessageListener l2;
    public long m;
    public String m1;
    public final NewWriteModel.d m2;
    public long n;
    public TbRichTextImageInfo n1;
    public Boolean n2;
    public long o;
    public TbRichTextMemeInfo o1;
    public NewWriteModel.d o2;
    public long p;
    public boolean p1;
    public NetMessageListener p2;
    public boolean q;
    public int q1;
    public final PbModel.h q2;
    public boolean r;
    public boolean r0;
    public int r1;
    public CustomMessageListener r2;
    public or5 s;
    public boolean s0;
    public List<d3> s1;
    public HttpMessageListener s2;
    public long t;
    @NonNull
    public TiePlusEventController.g t0;
    public int t1;
    public final bw4.a t2;
    public boolean u;
    public xj9 u0;
    public cm6 u1;
    public final AbsListView.OnScrollListener u2;
    public long v;
    public PushPermissionController v0;
    public final d3 v1;
    public final h9 v2;
    public int w;
    public boolean w0;
    public final kh9.b w1;
    public final i95.g w2;
    public String x;
    public PbInterviewStatusView.f x0;
    public final CustomMessageListener x1;
    public final View.OnClickListener x2;
    public ag<TextView> y;
    public final Handler y0;
    public CustomMessageListener y1;
    public boolean y2;
    public ag<TbImageView> z;
    public yy4.c z0;
    public CustomMessageListener z1;
    public final BdListView.p z2;

    /* loaded from: classes7.dex */
    public interface d3 {
        boolean onBackPressed();
    }

    /* loaded from: classes7.dex */
    public interface f3 {
        void callback(Object obj);
    }

    @Override // com.baidu.tieba.vl9
    public PbFragment A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vl9
    public AbsVideoPbFragment O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return null;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s06
    public void Z(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048649, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.IPlayView g1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048675, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s06
    public void j1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048687, this, context, str) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048727, this, view2, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class f2 implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ f2 b;

            public a(f2 f2Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {f2Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = f2Var;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    df9.a(this.b.a.getPageContext(), this.a).show();
                }
            }
        }

        public f2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                SafeHandler.getInst().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes7.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h1 a;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                }
            }

            public a(h1 h1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {h1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = h1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                fi9 fi9Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (fi9Var = this.a.c.M0) != null && fi9Var.g() != null) {
                    if (!this.a.c.M0.g().e()) {
                        this.a.c.M0.b(false);
                    }
                    this.a.c.M0.g().l(false);
                }
            }
        }

        public h1(PbFragment pbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pbFragment;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int dimens;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    dimens = BdUtilHelper.getDimens(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = equipmentHeight / 2;
                    dimens = BdUtilHelper.getDimens(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = equipmentHeight - (i + dimens);
                PbFragment pbFragment = this.c;
                boolean z = true;
                int i3 = (pbFragment.Y[1] + pbFragment.Z) - i2;
                if (pbFragment.I0 != null && this.c.I0.m1() != null) {
                    this.c.I0.m1().smoothScrollBy(i3, 50);
                }
                if (this.c.M5().w1() != null) {
                    if (this.c.X0 != null) {
                        this.c.X0.b().setVisibility(8);
                    }
                    this.c.M5().w1().t(this.a, this.b, this.c.M5().x1(), (this.c.A0 == null || this.c.A0.s1() == null || this.c.A0.s1().O() == null || !this.c.A0.s1().O().isBjh()) ? false : false);
                    tj5 f = this.c.M5().w1().f();
                    if (f != null && this.c.A0 != null && this.c.A0.s1() != null) {
                        f.J(this.c.A0.s1().c());
                        f.f0(this.c.A0.s1().O());
                    }
                    if (this.c.M0.f() == null && this.c.M5().w1().f().u() != null) {
                        this.c.M5().w1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.M0.n(pbFragment2.M5().w1().f().u().i());
                        this.c.M5().w1().f().P(this.c.d1);
                    }
                }
                this.c.M5().G1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes7.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i1 a;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                }
            }

            public a(i1 i1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {i1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = i1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                fi9 fi9Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (fi9Var = this.a.c.M0) != null && fi9Var.g() != null) {
                    if (!this.a.c.M0.g().e()) {
                        this.a.c.M0.b(false);
                    }
                    this.a.c.M0.g().l(false);
                }
            }
        }

        public i1(PbFragment pbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pbFragment;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int dimens;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(this.c.getContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                } else {
                    i = equipmentHeight / 2;
                    dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                }
                int i2 = equipmentHeight - (i + dimens);
                PbFragment pbFragment = this.c;
                boolean z = true;
                int i3 = (pbFragment.Y[1] + pbFragment.Z) - i2;
                if (pbFragment.I0 != null && this.c.I0.m1() != null) {
                    this.c.I0.m1().smoothScrollBy(i3, 50);
                }
                if (this.c.M5().w1() != null) {
                    if (this.c.X0 != null) {
                        this.c.X0.b().setVisibility(8);
                    }
                    this.c.M5().w1().t(this.a, this.b, this.c.M5().x1(), (this.c.A0 == null || this.c.A0.s1() == null || this.c.A0.s1().O() == null || !this.c.A0.s1().O().isBjh()) ? false : false);
                    tj5 f = this.c.M5().w1().f();
                    if (f != null && this.c.A0 != null && this.c.A0.s1() != null) {
                        f.J(this.c.A0.s1().c());
                        f.f0(this.c.A0.s1().O());
                    }
                    if (this.c.M0.f() == null && this.c.M5().w1().f().u() != null) {
                        this.c.M5().w1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.M0.n(pbFragment2.M5().w1().f().u().i());
                        this.c.M5().w1().f().P(this.c.d1);
                    }
                }
                this.c.M5().G1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: Code restructure failed: missing block: B:762:0x1e09, code lost:
            r4 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:786:0x1ebd, code lost:
            if ((r32.a.I0.h1.a.getView().getTop() - r32.a.I0.k.a.getBottom()) < (r32.a.I0.h1.a.g.getHeight() + 10)) goto L762;
         */
        /* JADX WARN: Removed duplicated region for block: B:1036:0x27c7  */
        /* JADX WARN: Removed duplicated region for block: B:1037:0x27dd  */
        /* JADX WARN: Removed duplicated region for block: B:1040:0x2819  */
        /* JADX WARN: Removed duplicated region for block: B:1282:0x31c0  */
        /* JADX WARN: Removed duplicated region for block: B:1283:0x31c5  */
        /* JADX WARN: Removed duplicated region for block: B:1286:0x31d4  */
        /* JADX WARN: Removed duplicated region for block: B:1320:0x3282  */
        /* JADX WARN: Removed duplicated region for block: B:1323:0x3291  */
        /* JADX WARN: Removed duplicated region for block: B:1326:0x32a4  */
        /* JADX WARN: Removed duplicated region for block: B:1329:0x32b5  */
        /* JADX WARN: Removed duplicated region for block: B:1332:0x32cb  */
        /* JADX WARN: Removed duplicated region for block: B:1334:0x32d4  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view2) {
            td9 s1;
            int i;
            int i2;
            rba X;
            StatisticItem statisticItem;
            SparseArray sparseArray;
            s45 s45Var;
            s45 s45Var2;
            s45 s45Var3;
            String string;
            boolean z;
            s45 s45Var4;
            s45 s45Var5;
            s45 s45Var6;
            s45 s45Var7;
            String name;
            boolean z2;
            int i3;
            int i4;
            a45 a45Var;
            String jumpUrlWithTid;
            String[] strArr;
            int i5;
            int i6;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null || !this.a.isAdded()) {
                return;
            }
            if (this.a.s0 && (view2 == this.a.I0.k.e || view2 == this.a.I0.k.f || view2.getId() == R.id.obfuscated_res_0x7f091b00 || view2.getId() == R.id.obfuscated_res_0x7f090b73 || view2.getId() == R.id.obfuscated_res_0x7f091ede || view2.getId() == R.id.obfuscated_res_0x7f091a97)) {
                return;
            }
            if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                if (view2 == this.a.I0.p1() && this.a.getPageContext().getPageActivity() != null && this.a.A0 != null) {
                    this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.A0.M1(), this.a.A0.e2(), this.a.A0.d2())));
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("fid", this.a.A0.getForumId());
                    statisticItem2.param("fname", this.a.A0.R0());
                    statisticItem2.param("tid", this.a.A0.M1());
                    TiebaStatic.log(statisticItem2);
                }
                if (view2 == this.a.I0.r1()) {
                    if (!this.a.h && this.a.A0.p2(true)) {
                        this.a.h = true;
                        this.a.I0.N3();
                    }
                } else if (this.a.I0.k.i() != null && view2 == this.a.I0.k.i().G()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.showToast(R.string.network_not_available);
                        return;
                    }
                    this.a.I0.F0();
                    this.a.m7();
                    this.a.I0.M3();
                    this.a.I0.k4();
                    if (this.a.I0.u1() != null) {
                        this.a.I0.u1().setVisibility(8);
                    }
                    this.a.A0.g3(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                } else if (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().x()) {
                    if (view2 == this.a.I0.k.h) {
                        if (this.a.I0.u0(this.a.A0.f1())) {
                            this.a.m7();
                            return;
                        }
                        BdUtilHelper.hideSoftKeyPad(this.a.a, this.a.I0.k.h);
                        this.a.a.finish();
                    } else if (view2 == this.a.I0.X0() || (this.a.I0.k.i() != null && (view2 == this.a.I0.k.i().H() || view2 == this.a.I0.k.i().I()))) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                        } else if (this.a.A0.s1() != null && !this.a.D0.g0()) {
                            this.a.I0.F0();
                            int i7 = (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().I()) ? (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().H()) ? view2 == this.a.I0.X0() ? 2 : 0 : this.a.A0.s1().O().getIs_good() == 1 ? 3 : 6 : this.a.A0.s1().O().getIs_top() == 1 ? 5 : 4;
                            ForumData k = this.a.A0.s1().k();
                            String name3 = k.getName();
                            String id = k.getId();
                            String id2 = this.a.A0.s1().O().getId();
                            this.a.I0.F4();
                            this.a.D0.k0(id, name3, id2, i7, this.a.I0.Y0());
                        }
                    } else if (view2 == this.a.I0.f1()) {
                        if (this.a.A0 != null) {
                            BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), this.a.A0.s1().O().getTopicData().b());
                        }
                    } else if (view2 == this.a.I0.k.e) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                        if (this.a.A0.s1() != null && this.a.A0.s1().O() != null && this.a.A0.s1().O().isVideoThreadType() && this.a.A0.s1().O().getThreadVideoInfo() != null) {
                            TiebaStatic.log(new StatisticItem("c11922"));
                        }
                        if (this.a.A0.getErrorNo() == 4) {
                            if (!StringUtils.isNull(this.a.A0.R0()) || this.a.A0.H0() == null) {
                                this.a.a.finish();
                                return;
                            }
                            name2 = this.a.A0.H0().b;
                        } else {
                            name2 = this.a.A0.s1().k().getName();
                        }
                        if (StringUtils.isNull(name2)) {
                            this.a.a.finish();
                            return;
                        }
                        String R0 = this.a.A0.R0();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                        if (!this.a.A0.X0() || R0 == null || !R0.equals(name2)) {
                            this.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
                        } else {
                            this.a.a.finish();
                        }
                    } else if (view2 == this.a.I0.k.f) {
                        if (kv5.a()) {
                            return;
                        }
                        if (this.a.A0 == null || this.a.A0.s1() == null) {
                            BdUtilHelper.showToast(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fe3));
                            return;
                        }
                        ArrayList<rba> F = this.a.A0.s1().F();
                        if ((F == null || F.size() <= 0) && this.a.A0.L1()) {
                            BdUtilHelper.showToast(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fe3));
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.A0.M1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.A0.getForumId()));
                        this.a.I0.j3();
                        this.a.u6();
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091abf) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.I0.x3(true);
                        this.a.I0.j3();
                        if (this.a.h) {
                            return;
                        }
                        this.a.h = true;
                        this.a.I0.u4();
                        this.a.m7();
                        this.a.I0.M3();
                        this.a.A0.k3(this.a.y5());
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091a92) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.I0.F0();
                        if (view2.getId() != R.id.obfuscated_res_0x7f091a92 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                            if (bi9.c(this.a.getPageContext(), 11009) && this.a.A0.I0(this.a.I0.l1()) != null) {
                                this.a.n6();
                                if (this.a.A0.s1() != null && this.a.A0.s1().O() != null && this.a.A0.s1().O().getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.A0.b).param("fid", this.a.A0.s1().l()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                }
                                if (this.a.A0.s1().O() == null || this.a.A0.s1().O().getAuthor() == null || this.a.A0.s1().O().getAuthor().getUserId() == null || this.a.C0 == null) {
                                    return;
                                }
                                int v = bi9.v(this.a.A0.s1());
                                ThreadData O = this.a.A0.s1().O();
                                if (O.isBJHArticleThreadType()) {
                                    i6 = 2;
                                } else if (O.isBJHVideoThreadType()) {
                                    i6 = 3;
                                } else if (O.isBJHNormalThreadType()) {
                                    i6 = 4;
                                } else {
                                    i6 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.A0.b).param("obj_locate", 1).param("obj_id", this.a.A0.s1().O().getAuthor().getUserId()).param("obj_type", !this.a.C0.e()).param("obj_source", v).param("obj_param1", i6));
                                return;
                            }
                            return;
                        }
                        this.a.U = view2;
                    } else if ((this.a.I0.k.i() != null && view2 == this.a.I0.k.i().E()) || view2.getId() == R.id.obfuscated_res_0x7f090b73 || view2.getId() == R.id.obfuscated_res_0x7f091ede) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            view2.setTag(Boolean.FALSE);
                            return;
                        }
                        this.a.I0.F0();
                        if (this.a.I0.k.i() != null && view2 == this.a.I0.k.i().E()) {
                            this.a.I0.j3();
                        }
                        if (this.a.h) {
                            view2.setTag(Boolean.FALSE);
                            return;
                        }
                        this.a.m7();
                        this.a.I0.M3();
                        boolean l3 = view2.getId() == R.id.obfuscated_res_0x7f090b73 ? this.a.A0.l3(true, this.a.y5()) : view2.getId() == R.id.obfuscated_res_0x7f091ede ? this.a.A0.l3(false, this.a.y5()) : this.a.A0.k3(this.a.y5());
                        view2.setTag(Boolean.valueOf(l3));
                        if (l3) {
                            i5 = 1;
                            this.a.I0.x3(true);
                            this.a.I0.u4();
                            this.a.h = true;
                            this.a.I0.B3(true);
                        } else {
                            i5 = 1;
                        }
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i5, new Object[0]);
                    } else if (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().y()) {
                        if (view2.getId() == R.id.share_num_container) {
                            if (bi9.c(this.a.getPageContext(), 11009)) {
                                bi9.w(this.a.getContext(), 3, this.a.u5(), this.a.A0);
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091a97 || view2.getId() == R.id.share_more_container) {
                            if ((!ShareSwitch.isOn() && !this.a.checkUpIsLogin()) || (s1 = this.a.A0.s1()) == null) {
                                return;
                            }
                            ThreadData O2 = s1.O();
                            if (O2 != null && O2.getAuthor() != null) {
                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.A0.b).param("fid", s1.l()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                            if (O2 != null) {
                                if (O2.isBJHArticleThreadType()) {
                                    i = 2;
                                } else if (O2.isBJHVideoThreadType()) {
                                    i = 3;
                                } else if (O2.isBJHNormalThreadType()) {
                                    i = 4;
                                } else if (O2.isBJHVideoDynamicThreadType()) {
                                    i = 5;
                                }
                                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                statisticItem3.param("tid", this.a.A0.M1());
                                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem3.param("fid", this.a.A0.getForumId());
                                if (view2.getId() != R.id.share_num_container) {
                                    statisticItem3.param("obj_locate", 5);
                                } else {
                                    statisticItem3.param("obj_locate", 6);
                                }
                                statisticItem3.param("obj_name", i);
                                statisticItem3.param("obj_type", 1);
                                if (O2 != null) {
                                    if (O2.isBJHArticleThreadType()) {
                                        statisticItem3.param("obj_type", 10);
                                    } else if (O2.isBJHVideoThreadType()) {
                                        statisticItem3.param("obj_type", 9);
                                    } else if (O2.isBJHVideoDynamicThreadType()) {
                                        statisticItem3.param("obj_type", 8);
                                    } else if (O2.isBJHNormalThreadType()) {
                                        statisticItem3.param("obj_type", 7);
                                    } else if (O2.isShareThread) {
                                        statisticItem3.param("obj_type", 6);
                                    } else {
                                        int i8 = O2.threadType;
                                        if (i8 == 0) {
                                            statisticItem3.param("obj_type", 1);
                                        } else {
                                            if (i8 == 40) {
                                                statisticItem3.param("obj_type", 2);
                                            } else if (i8 == 49) {
                                                statisticItem3.param("obj_type", 3);
                                            } else if (i8 == 54) {
                                                statisticItem3.param("obj_type", 4);
                                            } else {
                                                statisticItem3.param("obj_type", 5);
                                            }
                                            statisticItem3.param("card_type", O2.getRecomCardType());
                                            statisticItem3.param("recom_source", O2.mRecomSource);
                                            statisticItem3.param("ab_tag", O2.mRecomAbTag);
                                            statisticItem3.param("weight", O2.mRecomWeight);
                                            statisticItem3.param("extra", O2.mRecomExtra);
                                            statisticItem3.param("nid", O2.getNid());
                                            if (O2.getBaijiahaoData() != null && !bi.isEmpty(O2.getBaijiahaoData().oriUgcVid)) {
                                                statisticItem3.param(TiebaStatic.Params.OBJ_PARAM6, O2.getBaijiahaoData().oriUgcVid);
                                            }
                                        }
                                    }
                                    statisticItem3.param("card_type", O2.getRecomCardType());
                                    statisticItem3.param("recom_source", O2.mRecomSource);
                                    statisticItem3.param("ab_tag", O2.mRecomAbTag);
                                    statisticItem3.param("weight", O2.mRecomWeight);
                                    statisticItem3.param("extra", O2.mRecomExtra);
                                    statisticItem3.param("nid", O2.getNid());
                                    if (O2.getBaijiahaoData() != null) {
                                        statisticItem3.param(TiebaStatic.Params.OBJ_PARAM6, O2.getBaijiahaoData().oriUgcVid);
                                    }
                                }
                                if (!bi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                }
                                if (this.a.Y() != null) {
                                    gr5.e(this.a.Y(), statisticItem3);
                                }
                                if (this.a.I0 != null) {
                                    statisticItem3.param("obj_param1", this.a.I0.i1());
                                }
                                TiebaStatic.log(statisticItem3);
                                if (BdUtilHelper.isNetOk()) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e21);
                                    return;
                                } else if (s1 == null) {
                                    BdUtilHelper.showToast(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fe3));
                                    return;
                                } else {
                                    ArrayList<rba> F2 = this.a.A0.s1().F();
                                    if ((F2 == null || F2.size() <= 0) && this.a.A0.L1()) {
                                        BdUtilHelper.showToast(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fe3));
                                        return;
                                    }
                                    this.a.I0.F0();
                                    this.a.m7();
                                    if (s1.A() != null && !StringUtils.isNull(s1.A().a(), true)) {
                                        TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.A0.s1().l()));
                                    }
                                    TiebaStatic.log(new StatisticItem("c11939"));
                                    if (AntiHelper.e(this.a.getContext(), O2)) {
                                        return;
                                    }
                                    if (this.a.I0 != null) {
                                        this.a.I0.H0();
                                        this.a.I0.P4(s1);
                                    }
                                    if (ShareSwitch.isOn()) {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091a97) {
                                            i2 = 2;
                                        } else {
                                            i2 = view2.getId() == R.id.share_num_container ? 1 : 6;
                                        }
                                        if (!this.a.I0.q2() || s1.p0()) {
                                            this.a.g7(i2);
                                            return;
                                        } else {
                                            this.a.g7(i2);
                                            return;
                                        }
                                    }
                                    this.a.I0.k4();
                                    this.a.A0.M0().P(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                    return;
                                }
                            }
                            i = 1;
                            StatisticItem statisticItem32 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                            statisticItem32.param("tid", this.a.A0.M1());
                            statisticItem32.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem32.param("fid", this.a.A0.getForumId());
                            if (view2.getId() != R.id.share_num_container) {
                            }
                            statisticItem32.param("obj_name", i);
                            statisticItem32.param("obj_type", 1);
                            if (O2 != null) {
                            }
                            if (!bi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            }
                            if (this.a.Y() != null) {
                            }
                            if (this.a.I0 != null) {
                            }
                            TiebaStatic.log(statisticItem32);
                            if (BdUtilHelper.isNetOk()) {
                            }
                        } else if (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().F()) {
                            if (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().N()) {
                                if (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().M()) {
                                    if (this.a.I0.k.i() != null && view2 == this.a.I0.k.i().J()) {
                                        int skinType = TbadkCoreApplication.getInst().getSkinType();
                                        UtilHelper.showSkinChangeAnimation(this.a.getActivity());
                                        this.a.onChangeSkinType(skinType);
                                        UtilHelper.setNavigationBarBackground(this.a.getActivity(), this.a.getResources().getColor(R.color.CAM_X0201_2));
                                        if (skinType == 0) {
                                            TbadkCoreApplication.getInst().setSkinType(4);
                                        } else {
                                            SharedPrefHelper.getInstance().putBoolean("key_is_follow_system_mode", false);
                                            SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                        }
                                        this.a.I0.k.g();
                                        return;
                                    } else if (this.a.I0.j1() == view2) {
                                        if (!this.a.I0.j1().getIndicateStatus()) {
                                            xba.d("c10725", null);
                                        } else {
                                            td9 s12 = this.a.A0.s1();
                                            if (s12 != null && s12.O() != null && s12.O().getTaskInfoData() != null) {
                                                String e = s12.O().getTaskInfoData().e();
                                                if (StringUtils.isNull(e)) {
                                                    e = s12.O().getTaskInfoData().h();
                                                }
                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", e));
                                            }
                                        }
                                        this.a.P5();
                                        return;
                                    } else if (this.a.I0.k.i() != null && view2 == this.a.I0.k.i().A()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        this.a.I0.F0();
                                        SparseArray<Object> n1 = this.a.I0.n1(this.a.A0.s1(), this.a.A0.L1(), 1);
                                        if (n1 == null) {
                                            return;
                                        }
                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.A0.s1().k().getId(), this.a.A0.s1().k().getName(), this.a.A0.s1().O().getId(), StringUtils.string(this.a.A0.s1().V().getUserId()), StringUtils.string(n1.get(R.id.tag_forbid_user_name)), StringUtils.string(n1.get(R.id.tag_forbid_user_name_show)), StringUtils.string(n1.get(R.id.tag_forbid_user_post_id)), StringUtils.string(n1.get(R.id.tag_forbid_user_portrait)))));
                                        return;
                                    } else if (this.a.I0.k.i() != null && view2 == this.a.I0.k.i().u()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        SparseArray<Object> n12 = this.a.I0.n1(this.a.A0.s1(), this.a.A0.L1(), 1);
                                        if (n12 != null) {
                                            this.a.I0.Q2(((Integer) n12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(n12.get(R.id.tag_del_post_id)), ((Integer) n12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n12.get(R.id.tag_del_post_is_self)).booleanValue());
                                        }
                                        this.a.I0.k.f();
                                        if (this.a.R() == null || this.a.R().s1() == null || this.a.R().s1().O() == null) {
                                            return;
                                        }
                                        ThreadData O3 = this.a.R().s1().O();
                                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                        statisticItem4.param("tid", O3.getId());
                                        statisticItem4.param("fid", O3.getFid());
                                        statisticItem4.param("fname", O3.getForum_name());
                                        TiebaStatic.log(statisticItem4);
                                        StatisticItem statisticItem5 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                        statisticItem5.param("tid", O3.getId());
                                        statisticItem5.param("fid", O3.getFid());
                                        statisticItem5.param("fname", O3.getForum_name());
                                        statisticItem5.param("obj_source", 3);
                                        TiebaStatic.log(statisticItem5);
                                        return;
                                    } else if (this.a.I0.k.i() != null && view2 == this.a.I0.k.i().z()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        SparseArray<Object> n13 = this.a.I0.n1(this.a.A0.s1(), this.a.A0.L1(), 1);
                                        if (n13 != null) {
                                            if (StringUtils.isNull((String) n13.get(R.id.tag_del_multi_forum))) {
                                                this.a.I0.N2(((Integer) n13.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(n13.get(R.id.tag_del_post_id)), ((Integer) n13.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n13.get(R.id.tag_del_post_is_self)).booleanValue());
                                            } else {
                                                this.a.I0.O2(((Integer) n13.get(R.id.tag_del_post_type)).intValue(), (String) n13.get(R.id.tag_del_post_id), ((Integer) n13.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n13.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(n13.get(R.id.tag_del_multi_forum)));
                                            }
                                        }
                                        this.a.I0.k.f();
                                        return;
                                    } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f0922d0 && view2.getId() != R.id.obfuscated_res_0x7f091aab && view2.getId() != R.id.obfuscated_res_0x7f091923) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091b16) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091b14 && view2.getId() != R.id.obfuscated_res_0x7f091cf8 && view2.getId() != R.id.obfuscated_res_0x7f091aa5) {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091aa9) {
                                                    try {
                                                        sparseArray = (SparseArray) view2.getTag();
                                                    } catch (ClassCastException e2) {
                                                        e2.printStackTrace();
                                                        sparseArray = null;
                                                    }
                                                    rba rbaVar = (rba) sparseArray.get(R.id.tag_clip_board);
                                                    if (rbaVar == null) {
                                                        return;
                                                    }
                                                    if (this.a.O0 == null) {
                                                        PbFragment pbFragment = this.a;
                                                        pbFragment.O0 = new w45(pbFragment.getContext());
                                                        this.a.O0.q(this.a.i2);
                                                    }
                                                    ArrayList arrayList = new ArrayList();
                                                    boolean z3 = this.a.R().s1() != null && this.a.R().s1().j0();
                                                    if (view2 == null || sparseArray == null) {
                                                        return;
                                                    }
                                                    boolean booleanValue = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                                                    boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                    boolean booleanValue3 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                                                    boolean booleanValue4 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                    boolean booleanValue5 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                                                    String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
                                                    boolean booleanValue6 = sparseArray.get(R.id.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_self_post)).booleanValue() : false;
                                                    if (rbaVar.o() != null) {
                                                        boolean z4 = rbaVar.o().hasAgree;
                                                        int q = rbaVar.q();
                                                        if (z4 && q == 5) {
                                                            string = this.a.getString(R.string.action_cancel_dislike);
                                                        } else {
                                                            string = this.a.getString(R.string.action_dislike);
                                                        }
                                                        s45 s45Var8 = new s45(8, string, this.a.O0);
                                                        SparseArray sparseArray2 = new SparseArray();
                                                        sparseArray2.put(R.id.tag_clip_board, rbaVar);
                                                        s45Var8.d.setTag(sparseArray2);
                                                        arrayList.add(s45Var8);
                                                    }
                                                    if (this.a.mIsLogin) {
                                                        if (!zj9.i(this.a.A0) && !booleanValue3 && booleanValue2) {
                                                            s45 s45Var9 = new s45(5, this.a.getString(R.string.obfuscated_res_0x7f0f0cfd), this.a.O0);
                                                            SparseArray sparseArray3 = new SparseArray();
                                                            sparseArray3.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                                            sparseArray3.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                                                            sparseArray3.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                                                            sparseArray3.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                                                            sparseArray3.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                                                            sparseArray3.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                                                            sparseArray3.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                                                            sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                                                            sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                                            sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                                            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                                                            s45Var9.d.setTag(sparseArray3);
                                                            arrayList.add(s45Var9);
                                                        } else if ((bi9.C(this.a.A0.s1(), booleanValue) && TbadkCoreApplication.isLogin()) && !z3) {
                                                            s45 s45Var10 = new s45(5, this.a.getString(R.string.report_text), this.a.O0);
                                                            s45Var10.d.setTag(str);
                                                            arrayList.add(s45Var10);
                                                        }
                                                        if (booleanValue3) {
                                                            SparseArray sparseArray4 = new SparseArray();
                                                            sparseArray4.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                                                            sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                                                            sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                                                            sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                                                            sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                                                            sparseArray4.put(R.id.tag_forbid_user_post_id, str);
                                                            if (booleanValue4) {
                                                                sparseArray4.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                                                sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                                                                sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                                                                sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                                                                sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                                                                sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                                                                sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                                                            } else {
                                                                sparseArray4.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                                                            }
                                                            if (booleanValue5) {
                                                                sparseArray4.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                                                sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                                                                sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                                                sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                                                sparseArray4.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                                                                if (booleanValue6) {
                                                                    s45 s45Var11 = new s45(6, this.a.getString(R.string.obfuscated_res_0x7f0f0546), this.a.O0);
                                                                    s45Var11.d.setTag(sparseArray4);
                                                                    s45Var2 = s45Var11;
                                                                    s45Var = new s45(7, this.a.getString(R.string.obfuscated_res_0x7f0f0322), this.a.O0);
                                                                    s45Var.d.setTag(sparseArray4);
                                                                }
                                                            } else {
                                                                sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                            }
                                                            s45Var2 = null;
                                                            s45Var = new s45(7, this.a.getString(R.string.obfuscated_res_0x7f0f0322), this.a.O0);
                                                            s45Var.d.setTag(sparseArray4);
                                                        } else if (booleanValue5) {
                                                            SparseArray sparseArray5 = new SparseArray();
                                                            sparseArray5.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                                                            sparseArray5.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                                                            sparseArray5.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                                            sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                                                            sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                                                            sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                                            sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                                            sparseArray5.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                                                            if (this.a.A0.s1().W() == 1002 && !booleanValue) {
                                                                s45Var3 = new s45(6, this.a.getString(R.string.report_text), this.a.O0);
                                                            } else {
                                                                s45Var3 = new s45(6, this.a.getString(R.string.obfuscated_res_0x7f0f0546), this.a.O0);
                                                            }
                                                            s45Var3.d.setTag(sparseArray5);
                                                            s45Var2 = s45Var3;
                                                            s45Var = null;
                                                        } else {
                                                            s45Var = null;
                                                            s45Var2 = null;
                                                        }
                                                        if (s45Var2 != null) {
                                                            arrayList.add(s45Var2);
                                                        }
                                                        if (s45Var != null) {
                                                            arrayList.add(s45Var);
                                                        }
                                                    }
                                                    this.a.O0.l(arrayList);
                                                    this.a.N0 = new u45(this.a.getPageContext(), this.a.O0);
                                                    this.a.N0.l();
                                                    return;
                                                } else if (view2 == this.a.I0.h1()) {
                                                    if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                        this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, JavaTypesHelper.toLong(this.a.A0.s1().l(), 0L), JavaTypesHelper.toLong(this.a.A0.M1(), 0L), JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.A0.s1().O().getPushStatusData())));
                                                        return;
                                                    }
                                                    return;
                                                } else if (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().K()) {
                                                    if (this.a.I0.k.i() != null && view2 == this.a.I0.k.i().D()) {
                                                        TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                        if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.A0.M1())) == null) {
                                                            return;
                                                        }
                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                        this.a.I0.k.f();
                                                        TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                        return;
                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f090870 && view2.getId() != R.id.obfuscated_res_0x7f090b70) {
                                                        int id3 = view2.getId();
                                                        if (id3 == R.id.pb_u9_text_view) {
                                                            if (!this.a.checkUpIsLogin() || (a45Var = (a45) view2.getTag()) == null || StringUtils.isNull(a45Var.z1())) {
                                                                return;
                                                            }
                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{a45Var.z1()});
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091ee3 || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                            if (this.a.checkUpIsLogin()) {
                                                                TiebaStatic.log(new StatisticItem("c11740"));
                                                                if (view2 == null || view2.getTag() == null) {
                                                                    return;
                                                                }
                                                                SparseArray sparseArray6 = (SparseArray) view2.getTag();
                                                                rba rbaVar2 = (rba) sparseArray6.get(R.id.tag_load_sub_data);
                                                                if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                    TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.A0.b));
                                                                }
                                                                if (this.a.O0 == null) {
                                                                    PbFragment pbFragment2 = this.a;
                                                                    pbFragment2.O0 = new w45(pbFragment2.getContext());
                                                                    this.a.O0.q(this.a.i2);
                                                                }
                                                                ArrayList arrayList2 = new ArrayList();
                                                                boolean booleanValue7 = sparseArray6.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                                                                boolean booleanValue8 = sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                boolean booleanValue9 = sparseArray6.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                                                                boolean booleanValue10 = sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                boolean booleanValue11 = sparseArray6.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                                                                String str2 = sparseArray6.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray6.get(R.id.tag_forbid_user_post_id) : null;
                                                                boolean booleanValue12 = sparseArray6.get(R.id.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_is_self_post)).booleanValue() : false;
                                                                if (rbaVar2 != null) {
                                                                    if (rbaVar2.e0() != null && rbaVar2.e0().toString().length() > 0) {
                                                                        s45 s45Var12 = new s45(3, this.a.getString(R.string.obfuscated_res_0x7f0f04e1), this.a.O0);
                                                                        SparseArray sparseArray7 = new SparseArray();
                                                                        sparseArray7.put(R.id.tag_clip_board, rbaVar2);
                                                                        s45Var12.d.setTag(sparseArray7);
                                                                        arrayList2.add(s45Var12);
                                                                    }
                                                                    this.a.D2 = rbaVar2;
                                                                }
                                                                if (this.a.A0.s1().q()) {
                                                                    String u = this.a.A0.s1().u();
                                                                    if (rbaVar2 != null && !bi.isEmpty(u) && u.equals(rbaVar2.S())) {
                                                                        z = true;
                                                                        if (!z) {
                                                                            s45Var4 = new s45(4, this.a.getString(R.string.remove_mark), this.a.O0);
                                                                        } else {
                                                                            s45Var4 = new s45(4, this.a.getString(R.string.obfuscated_res_0x7f0f0c3d), this.a.O0);
                                                                        }
                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                        sparseArray8.put(R.id.tag_clip_board, this.a.D2);
                                                                        sparseArray8.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                        s45Var4.d.setTag(sparseArray8);
                                                                        arrayList2.add(s45Var4);
                                                                        if (this.a.mIsLogin) {
                                                                            if (!zj9.i(this.a.A0) && !booleanValue9 && booleanValue8) {
                                                                                s45 s45Var13 = new s45(5, this.a.getString(R.string.obfuscated_res_0x7f0f0cfd), this.a.O0);
                                                                                SparseArray sparseArray9 = new SparseArray();
                                                                                sparseArray9.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                                                                sparseArray9.put(R.id.tag_is_mem, sparseArray6.get(R.id.tag_is_mem));
                                                                                sparseArray9.put(R.id.tag_user_mute_mute_userid, sparseArray6.get(R.id.tag_user_mute_mute_userid));
                                                                                sparseArray9.put(R.id.tag_user_mute_mute_username, sparseArray6.get(R.id.tag_user_mute_mute_username));
                                                                                sparseArray9.put(R.id.tag_user_mute_mute_nameshow, sparseArray6.get(R.id.tag_user_mute_mute_nameshow));
                                                                                sparseArray9.put(R.id.tag_user_mute_post_id, sparseArray6.get(R.id.tag_user_mute_post_id));
                                                                                sparseArray9.put(R.id.tag_user_mute_thread_id, sparseArray6.get(R.id.tag_user_mute_thread_id));
                                                                                sparseArray9.put(R.id.tag_del_post_is_self, sparseArray6.get(R.id.tag_del_post_is_self));
                                                                                sparseArray9.put(R.id.tag_del_post_type, sparseArray6.get(R.id.tag_del_post_type));
                                                                                sparseArray9.put(R.id.tag_del_post_id, sparseArray6.get(R.id.tag_del_post_id));
                                                                                sparseArray9.put(R.id.tag_manage_user_identity, sparseArray6.get(R.id.tag_manage_user_identity));
                                                                                s45Var4.d.setTag(sparseArray9);
                                                                                arrayList2.add(s45Var13);
                                                                            } else if (bi9.C(this.a.A0.s1(), booleanValue7) && TbadkCoreApplication.isLogin()) {
                                                                                s45 s45Var14 = new s45(5, this.a.getString(R.string.report_text), this.a.O0);
                                                                                s45Var14.d.setTag(str2);
                                                                                arrayList2.add(s45Var14);
                                                                            }
                                                                            if (booleanValue9) {
                                                                                SparseArray sparseArray10 = new SparseArray();
                                                                                sparseArray10.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                                                                                sparseArray10.put(R.id.tag_manage_user_identity, sparseArray6.get(R.id.tag_manage_user_identity));
                                                                                sparseArray10.put(R.id.tag_forbid_user_name, sparseArray6.get(R.id.tag_forbid_user_name));
                                                                                sparseArray10.put(R.id.tag_forbid_user_name_show, sparseArray6.get(R.id.tag_forbid_user_name_show));
                                                                                sparseArray10.put(R.id.tag_forbid_user_portrait, sparseArray6.get(R.id.tag_forbid_user_portrait));
                                                                                sparseArray10.put(R.id.tag_forbid_user_post_id, str2);
                                                                                if (booleanValue10) {
                                                                                    sparseArray10.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                                                                    sparseArray10.put(R.id.tag_is_mem, sparseArray6.get(R.id.tag_is_mem));
                                                                                    sparseArray10.put(R.id.tag_user_mute_mute_userid, sparseArray6.get(R.id.tag_user_mute_mute_userid));
                                                                                    sparseArray10.put(R.id.tag_user_mute_mute_username, sparseArray6.get(R.id.tag_user_mute_mute_username));
                                                                                    sparseArray10.put(R.id.tag_user_mute_mute_nameshow, sparseArray6.get(R.id.tag_user_mute_mute_nameshow));
                                                                                    sparseArray10.put(R.id.tag_user_mute_post_id, sparseArray6.get(R.id.tag_user_mute_post_id));
                                                                                    sparseArray10.put(R.id.tag_user_mute_thread_id, sparseArray6.get(R.id.tag_user_mute_thread_id));
                                                                                } else {
                                                                                    sparseArray10.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                                                                                }
                                                                                if (booleanValue11) {
                                                                                    sparseArray10.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                                                                    sparseArray10.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue7));
                                                                                    sparseArray10.put(R.id.tag_del_post_id, sparseArray6.get(R.id.tag_del_post_id));
                                                                                    sparseArray10.put(R.id.tag_del_post_type, sparseArray6.get(R.id.tag_del_post_type));
                                                                                    sparseArray10.put(R.id.tag_has_sub_post, sparseArray6.get(R.id.tag_has_sub_post));
                                                                                    if (booleanValue12) {
                                                                                        s45 s45Var15 = new s45(6, this.a.getString(R.string.obfuscated_res_0x7f0f0546), this.a.O0);
                                                                                        s45Var15.d.setTag(sparseArray10);
                                                                                        s45Var6 = s45Var15;
                                                                                        s45Var5 = new s45(7, this.a.getString(R.string.obfuscated_res_0x7f0f0322), this.a.O0);
                                                                                        s45Var5.d.setTag(sparseArray10);
                                                                                    }
                                                                                } else {
                                                                                    sparseArray10.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                }
                                                                                s45Var6 = null;
                                                                                s45Var5 = new s45(7, this.a.getString(R.string.obfuscated_res_0x7f0f0322), this.a.O0);
                                                                                s45Var5.d.setTag(sparseArray10);
                                                                            } else if (booleanValue11) {
                                                                                SparseArray sparseArray11 = new SparseArray();
                                                                                sparseArray11.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                                                                                sparseArray11.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                                                                                sparseArray11.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                                                                sparseArray11.put(R.id.tag_manage_user_identity, sparseArray6.get(R.id.tag_manage_user_identity));
                                                                                sparseArray11.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue7));
                                                                                sparseArray11.put(R.id.tag_del_post_id, sparseArray6.get(R.id.tag_del_post_id));
                                                                                sparseArray11.put(R.id.tag_del_post_type, sparseArray6.get(R.id.tag_del_post_type));
                                                                                sparseArray11.put(R.id.tag_has_sub_post, sparseArray6.get(R.id.tag_has_sub_post));
                                                                                if (this.a.A0.s1().W() == 1002 && !booleanValue7) {
                                                                                    s45Var7 = new s45(6, this.a.getString(R.string.report_text), this.a.O0);
                                                                                } else {
                                                                                    s45Var7 = new s45(6, this.a.getString(R.string.obfuscated_res_0x7f0f0546), this.a.O0);
                                                                                }
                                                                                s45Var7.d.setTag(sparseArray11);
                                                                                s45Var6 = s45Var7;
                                                                                s45Var5 = null;
                                                                            } else {
                                                                                s45Var5 = null;
                                                                                s45Var6 = null;
                                                                            }
                                                                            if (s45Var6 != null) {
                                                                                arrayList2.add(s45Var6);
                                                                            }
                                                                            if (s45Var5 != null) {
                                                                                arrayList2.add(s45Var5);
                                                                            }
                                                                        }
                                                                        this.a.O0.l(arrayList2);
                                                                        this.a.N0 = new u45(this.a.getPageContext(), this.a.O0);
                                                                        this.a.N0.l();
                                                                        return;
                                                                    }
                                                                }
                                                                z = false;
                                                                if (!z) {
                                                                }
                                                                SparseArray sparseArray82 = new SparseArray();
                                                                sparseArray82.put(R.id.tag_clip_board, this.a.D2);
                                                                sparseArray82.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                s45Var4.d.setTag(sparseArray82);
                                                                arrayList2.add(s45Var4);
                                                                if (this.a.mIsLogin) {
                                                                }
                                                                this.a.O0.l(arrayList2);
                                                                this.a.N0 = new u45(this.a.getPageContext(), this.a.O0);
                                                                this.a.N0.l();
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.pb_act_btn) {
                                                            if (this.a.A0.s1() == null || this.a.A0.s1().O() == null || this.a.A0.s1().O().getActUrl() == null) {
                                                                return;
                                                            }
                                                            BrowserHelper.startWebActivity(this.a.getActivity(), this.a.A0.s1().O().getActUrl());
                                                            if (this.a.A0.s1().O().getActInfoType() == 1) {
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                return;
                                                            } else if (this.a.A0.s1().O().getActInfoType() == 2) {
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (id3 == R.id.lottery_tail) {
                                                            if (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                String string2 = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
                                                                TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.A0.s1().l()).param("tid", this.a.A0.s1().Q()).param("lotterytail", StringUtils.string(string2, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                if (!this.a.A0.s1().Q().equals(string2)) {
                                                                    this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(string2, (String) null, (String) null, (String) null)));
                                                                    return;
                                                                } else {
                                                                    this.a.I0.Q3(0);
                                                                    return;
                                                                }
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091ad9 || id3 == R.id.obfuscated_res_0x7f091a9f) {
                                                            if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                String string3 = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                String string4 = SharedPrefHelper.getInstance().getString("tail_link", "");
                                                                String string5 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
                                                                if (!StringUtils.isNull(string4)) {
                                                                    TiebaStatic.log("c10056");
                                                                    BrowserHelper.startWebActivity(view2.getContext(), string3, UtilHelper.urlAddParam(string4, "page_from=1&tailSkinId=" + string5), true, true, true);
                                                                }
                                                                this.a.I0.j3();
                                                                TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string5));
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.join_vote_tv) {
                                                            if (view2 != null) {
                                                                BrowserHelper.startWebActivity(this.a.getActivity(), StringUtils.string(view2.getTag()));
                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                if (this.a.u5() != 1 || this.a.A0 == null || this.a.A0.s1() == null) {
                                                                    return;
                                                                }
                                                                rl9.y("c10397", this.a.A0.s1().l(), this.a.A0.s1().Q(), currentAccount);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.look_all_tv) {
                                                            if (view2 != null) {
                                                                String string6 = StringUtils.string(view2.getTag());
                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                BrowserHelper.startWebActivity(this.a.getActivity(), string6);
                                                                if (this.a.u5() != 1 || this.a.A0 == null || this.a.A0.s1() == null) {
                                                                    return;
                                                                }
                                                                rl9.y("c10507", this.a.A0.s1().l(), this.a.A0.s1().Q(), currentAccount2);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f0916c9) {
                                                            this.a.j6();
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f0916c8) {
                                                            this.a.h6();
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f09274a) {
                                                            if (this.a.q1 >= 0) {
                                                                if (this.a.A0 != null) {
                                                                    this.a.A0.N2();
                                                                }
                                                                if (this.a.A0 == null || this.a.I0.T0() == null) {
                                                                    i4 = 0;
                                                                } else {
                                                                    i4 = 0;
                                                                    this.a.I0.T0().n0(this.a.A0.s1(), false);
                                                                }
                                                                this.a.q1 = i4;
                                                                if (this.a.A0 != null) {
                                                                    if (this.a.I0.m1() != null) {
                                                                        this.a.I0.m1().setSelection(this.a.A0.l1());
                                                                    }
                                                                    this.a.A0.R2(0, 0);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.qq_share_container) {
                                                            if (bi9.c(this.a.getPageContext(), 11009)) {
                                                                bi9.w(this.a.getContext(), 8, this.a.u5(), this.a.A0);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091923) {
                                                            SparseArray sparseArray12 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                            if (sparseArray12 == null) {
                                                                return;
                                                            }
                                                            this.a.k7(sparseArray12);
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091a94) {
                                                            if (this.a.I0.m1() == null || this.a.A0 == null || this.a.A0.s1() == null) {
                                                                return;
                                                            }
                                                            int firstVisiblePosition = this.a.I0.m1().getFirstVisiblePosition();
                                                            View childAt = this.a.I0.m1().getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            boolean x0 = this.a.A0.s1().x0();
                                                            boolean m2 = this.a.I0.m2();
                                                            boolean z5 = firstVisiblePosition == 0 && top == 0;
                                                            bi9.f(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.a.A0.s1());
                                                            if ((this.a.A0.s1().O() != null && this.a.A0.s1().O().getReply_num() <= 0) || (m2 && z5)) {
                                                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                if (!this.a.checkUpIsLogin()) {
                                                                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                    return;
                                                                }
                                                                this.a.y6();
                                                                if (this.a.A0.s1().O().getAuthor() != null) {
                                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.A0.b).param("fid", this.a.A0.s1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                                }
                                                            } else {
                                                                int equipmentHeight = (int) (BdUtilHelper.getEquipmentHeight(this.a.getContext()) * 0.6d);
                                                                if (x0) {
                                                                    if (this.a.I0.h1 != null) {
                                                                        if (this.a.I0.h1.a != null && this.a.I0.h1.a.getView() != null) {
                                                                            if (this.a.I0.h1.a.getView().getParent() != null) {
                                                                            }
                                                                        }
                                                                    }
                                                                    z2 = false;
                                                                } else {
                                                                    if (this.a.I0.u1() != null) {
                                                                        z2 = this.a.I0.u1().getVisibility() == 0;
                                                                        if (!z2 && this.a.I0.h1 != null && this.a.I0.h1.a != null && this.a.I0.h1.a.getView() != null && this.a.I0.h1.a.getView().getParent() != null && this.a.I0.k != null && this.a.I0.k.a != null) {
                                                                        }
                                                                    }
                                                                    z2 = false;
                                                                }
                                                                if (z2 || m2) {
                                                                    this.a.a0 = firstVisiblePosition;
                                                                    this.a.b0 = top;
                                                                    if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                        int i9 = -equipmentHeight;
                                                                        this.a.I0.m1().setSelectionFromTop(0, i9);
                                                                        this.a.I0.m1().smoothScrollBy(i9, 500);
                                                                    } else {
                                                                        this.a.I0.m1().D(0, 0, 500);
                                                                    }
                                                                } else if (this.a.a0 <= 0) {
                                                                    int d = dj9.d(this.a.getListView());
                                                                    if (dj9.e(this.a.getListView()) != -1) {
                                                                        d--;
                                                                    }
                                                                    int dimens = BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds100);
                                                                    if (d < 0) {
                                                                        d = (ListUtils.getCount(this.a.I0.m1().getData()) - 1) + this.a.I0.m1().getHeaderViewsCount();
                                                                        i3 = 0;
                                                                    } else {
                                                                        i3 = dimens;
                                                                    }
                                                                    if (this.a.I0.k != null && this.a.I0.k.a != null) {
                                                                        i3 += this.a.I0.k.a.getFixedNavHeight() - 10;
                                                                    }
                                                                    if (this.a.I0.h1 == null || this.a.I0.h1.a == null || this.a.I0.h1.a.getView() == null || this.a.I0.h1.a.getView().getParent() == null) {
                                                                        this.a.I0.m1().setSelectionFromTop(d, i3 + equipmentHeight);
                                                                        this.a.I0.m1().smoothScrollBy(equipmentHeight, 500);
                                                                    } else {
                                                                        this.a.I0.m1().D(d, i3, 200);
                                                                    }
                                                                } else if (this.a.I0.m1().getChildAt(this.a.a0) == null) {
                                                                    this.a.I0.m1().setSelectionFromTop(this.a.a0, this.a.b0 + equipmentHeight);
                                                                    this.a.I0.m1().smoothScrollBy(equipmentHeight, 500);
                                                                } else {
                                                                    this.a.I0.m1().D(this.a.a0, this.a.b0, 200);
                                                                }
                                                            }
                                                            if (this.a.A0.s1().O() == null || this.a.A0.s1().O().getAuthor() == null) {
                                                                return;
                                                            }
                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.A0.b).param("fid", this.a.A0.s1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091b00) {
                                                            if (this.a.A0 == null || this.a.A0.s1() == null || this.a.A0.s1().k() == null || bi.isEmpty(this.a.A0.s1().k().getName())) {
                                                                return;
                                                            }
                                                            if (this.a.A0.getErrorNo() == 4) {
                                                                if (!StringUtils.isNull(this.a.A0.R0()) || this.a.A0.H0() == null) {
                                                                    this.a.a.finish();
                                                                    return;
                                                                }
                                                                name = this.a.A0.H0().b;
                                                            } else {
                                                                name = this.a.A0.s1().k().getName();
                                                            }
                                                            if (StringUtils.isNull(name)) {
                                                                this.a.a.finish();
                                                                return;
                                                            }
                                                            String R02 = this.a.A0.R0();
                                                            if (!this.a.A0.X0() || R02 == null || !R02.equals(name)) {
                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.A0.s1().k().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                createNormalCfg2.setCallFrom(2);
                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                            } else {
                                                                this.a.a.finish();
                                                            }
                                                            StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                            statisticItem6.param("tid", this.a.A0.M1());
                                                            statisticItem6.param("fid", this.a.A0.getForumId());
                                                            statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            if (this.a.A0.s1().O() != null) {
                                                                statisticItem6.param("nid", this.a.A0.s1().O().getNid());
                                                            }
                                                            TiebaStatic.log(statisticItem6);
                                                            return;
                                                        } else if (id3 != R.id.forum_name_text && id3 != R.id.forum_enter_button_one && id3 != R.id.forum_enter_button_two && id3 != R.id.forum_enter_button_three) {
                                                            if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                if (this.a.A0 == null) {
                                                                    return;
                                                                }
                                                                StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                statisticItem7.param("tid", this.a.A0.M1());
                                                                statisticItem7.param("fid", this.a.A0.getForumId());
                                                                statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem7.param("obj_locate", 2);
                                                                TiebaStatic.log(statisticItem7);
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091b28) {
                                                                if (this.a.A0 == null || this.a.A0.s1() == null) {
                                                                    return;
                                                                }
                                                                td9 s13 = this.a.A0.s1();
                                                                if (this.a.F0 == null) {
                                                                    PbFragment pbFragment3 = this.a;
                                                                    pbFragment3.F0 = new me9(pbFragment3.getPageContext());
                                                                }
                                                                long j = JavaTypesHelper.toLong(s13.Q(), 0L);
                                                                long j2 = JavaTypesHelper.toLong(s13.l(), 0L);
                                                                rl9.A("c13446", j2);
                                                                PbFragment pbFragment4 = this.a;
                                                                pbFragment4.registerListener(pbFragment4.p2);
                                                                this.a.F0.a(j, j2);
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091b42) {
                                                                if (view2.getTag() instanceof SmartApp) {
                                                                    SmartApp smartApp = (SmartApp) view2.getTag();
                                                                    if (!TbAiappsLaunchUtil.launch(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                        if (StringUtils.isNull(smartApp.h5_url)) {
                                                                            return;
                                                                        }
                                                                        BrowserHelper.startWebActivity(this.a.getActivity(), smartApp.h5_url);
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.A0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.naws_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.A0.M1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091020) {
                                                                if (view2.getTag() instanceof ThreadData) {
                                                                    ThreadData threadData = (ThreadData) view2.getTag();
                                                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                    createNormalCfg3.setCallFrom(14);
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f09101d) {
                                                                if ((view2.getTag() instanceof ThreadData) && this.a.checkUpIsLogin()) {
                                                                    ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                    if (this.a.Q != null) {
                                                                        this.a.Q.f0(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 != R.id.obfuscated_res_0x7f091aad && id3 != R.id.obfuscated_res_0x7f091b0e) {
                                                                if (id3 == R.id.obfuscated_res_0x7f092768) {
                                                                    if (view2.getTag(R.id.tag_is_top_question) instanceof Boolean) {
                                                                        rl9.w(5);
                                                                    }
                                                                    this.a.N6(false);
                                                                    this.a.l7((rba) view2.getTag(R.id.tag_pb_top_replay_more), false);
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (this.a.s0) {
                                                                return;
                                                            } else {
                                                                StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                statisticItem8.param("tid", this.a.A0.M1());
                                                                statisticItem8.param("fid", this.a.A0.getForumId());
                                                                statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem8.param("obj_locate", 7);
                                                                TiebaStatic.log(statisticItem8);
                                                                SparseArray sparseArray13 = (SparseArray) view2.getTag();
                                                                if (sparseArray13 != null && (sparseArray13.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray13.get(R.id.tag_is_top_question)).booleanValue()) {
                                                                    rl9.w(6);
                                                                }
                                                                PbFragment pbFragment5 = this.a;
                                                                pbFragment5.b = false;
                                                                pbFragment5.i5(view2);
                                                                return;
                                                            }
                                                        } else if (view2.getTag() instanceof ThreadData) {
                                                            ThreadData threadData3 = (ThreadData) view2.getTag();
                                                            if (this.a.A0.r1() != 3 || !this.a.A0() || this.a.A0.s1() == null || !ListUtils.isEmpty(this.a.A0.s1().o())) {
                                                                FrsActivityConfig createNormalCfg4 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData3.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                createNormalCfg4.setCallFrom(14);
                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg4));
                                                            } else {
                                                                this.a.a.finish();
                                                            }
                                                            StatisticItem statisticItem9 = new StatisticItem("c13399");
                                                            statisticItem9.param("tid", threadData3.getId());
                                                            statisticItem9.param("fid", threadData3.getFid());
                                                            statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem9.param("nid", threadData3.getNid());
                                                            TiebaStatic.log(statisticItem9);
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        SparseArray sparseArray14 = (SparseArray) view2.getTag();
                                                        if (sparseArray14 == null || !(sparseArray14.get(R.id.tag_load_sub_data) instanceof rba)) {
                                                            return;
                                                        }
                                                        rba rbaVar3 = (rba) sparseArray14.get(R.id.tag_load_sub_data);
                                                        View view3 = (View) sparseArray14.get(R.id.tag_load_sub_view);
                                                        if (rbaVar3 == null || view3 == null) {
                                                            return;
                                                        }
                                                        ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090871);
                                                        EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090872);
                                                        View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b70);
                                                        if (rbaVar3.C0()) {
                                                            rbaVar3.f1(false);
                                                            dk9.e(rbaVar3);
                                                        } else if (this.a.R() != null ? dk9.c(this.a.R().s1(), rbaVar3) : false) {
                                                            rbaVar3.f1(true);
                                                        }
                                                        SkinManager.setBackgroundColor(findViewById, rbaVar3.C0() ? R.color.CAM_X0201 : R.color.transparent);
                                                        SkinManager.setViewTextColor(eMTextView, rbaVar3.C0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                        WebPManager.setPureDrawable(imageView, rbaVar3.C0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, rbaVar3.C0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                        return;
                                                    }
                                                } else {
                                                    this.a.I0.k.g();
                                                    this.a.I0.r4(this.a.G2);
                                                    return;
                                                }
                                            } else if (this.a.A0 == null) {
                                                return;
                                            } else {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091b14) {
                                                    StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                    statisticItem10.param("tid", this.a.A0.M1());
                                                    statisticItem10.param("fid", this.a.A0.getForumId());
                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem10.param("obj_locate", 6);
                                                    TiebaStatic.log(statisticItem10);
                                                }
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091cf8) {
                                                    if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                        this.a.f1144T = view2;
                                                        return;
                                                    }
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091b14 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                    this.a.f1144T = view2;
                                                    return;
                                                }
                                                if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray15 = (SparseArray) view2.getTag();
                                                    if (sparseArray15.get(R.id.tag_load_sub_data) instanceof rba) {
                                                        rba rbaVar4 = (rba) sparseArray15.get(R.id.tag_load_sub_data);
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f091b14 && (statisticItem = rbaVar4.f0) != null) {
                                                            StatisticItem copy = statisticItem.copy();
                                                            copy.delete("obj_locate");
                                                            copy.param("obj_locate", 8);
                                                            TiebaStatic.log(copy);
                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091cf8 || view2.getId() == R.id.obfuscated_res_0x7f091aa5) {
                                                            TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.A0.N1()).param("fid", this.a.A0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", rbaVar4.S()).param("obj_source", 1).param("obj_type", 3));
                                                        }
                                                        if (this.a.A0 == null || this.a.A0.s1() == null || this.a.M5().v1() == null || rbaVar4.r() == null || rbaVar4.I() == 1) {
                                                            return;
                                                        }
                                                        if (this.a.M5().w1() != null) {
                                                            this.a.M5().w1().g();
                                                        }
                                                        ke9 ke9Var = new ke9();
                                                        ke9Var.v(this.a.A0.s1().k());
                                                        ke9Var.z(this.a.A0.s1().O());
                                                        ke9Var.x(rbaVar4);
                                                        this.a.M5().v1().j0(ke9Var);
                                                        this.a.M5().v1().setPostId(rbaVar4.S());
                                                        this.a.k6(view2, rbaVar4.r().getUserId(), "", rbaVar4);
                                                        if (this.a.X0 != null) {
                                                            this.a.I0.r3(this.a.X0.z());
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        } else if (this.a.A0 == null) {
                                            return;
                                        } else {
                                            StatisticItem statisticItem11 = new StatisticItem("c13398");
                                            statisticItem11.param("tid", this.a.A0.M1());
                                            statisticItem11.param("fid", this.a.A0.getForumId());
                                            statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem11.param("obj_locate", 5);
                                            TiebaStatic.log(statisticItem11);
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091b16 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray16 = (SparseArray) view2.getTag();
                                                    if (sparseArray16.get(R.id.tag_load_sub_data) instanceof rba) {
                                                        rba rbaVar5 = (rba) sparseArray16.get(R.id.tag_load_sub_data);
                                                        StatisticItem statisticItem12 = rbaVar5.f0;
                                                        if (statisticItem12 != null) {
                                                            StatisticItem copy2 = statisticItem12.copy();
                                                            copy2.delete("obj_locate");
                                                            copy2.param("obj_locate", 8);
                                                            TiebaStatic.log(copy2);
                                                        }
                                                        if (this.a.A0 == null || this.a.A0.s1() == null) {
                                                            return;
                                                        }
                                                        String M1 = this.a.A0.M1();
                                                        String S = rbaVar5.S();
                                                        int W = this.a.A0.s1() != null ? this.a.A0.s1().W() : 0;
                                                        AbsPbActivity.e z6 = this.a.z6(S);
                                                        if (z6 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(M1, S, "pb", true, false, null, false, null, W, rbaVar5.l0(), this.a.A0.s1().c(), false, rbaVar5.r().getIconInfo(), 5).addBigImageData(z6.a, z6.b, z6.g, z6.j);
                                                        addBigImageData.setKeyPageStartFrom(this.a.A0.r1());
                                                        addBigImageData.setFromFrsForumId(this.a.A0.getFromForumId());
                                                        addBigImageData.setWorksInfoData(this.a.A0.R1());
                                                        addBigImageData.setKeyFromForumId(this.a.A0.getForumId());
                                                        addBigImageData.setTiebaPlusData(this.a.A0.W(), this.a.A0.S(), this.a.A0.T(), this.a.A0.R(), this.a.A0.X());
                                                        addBigImageData.setBjhData(this.a.A0.J0());
                                                        if (this.a.A0.s1().n() != null) {
                                                            addBigImageData.setHasForumRule(this.a.A0.s1().n().has_forum_rule.intValue());
                                                        }
                                                        if (this.a.A0.s1().V() != null) {
                                                            addBigImageData.setIsManager(this.a.A0.s1().V().getIs_manager());
                                                        }
                                                        if (this.a.A0.s1().k().getDeletedReasonInfo() != null) {
                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.A0.s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.A0.s1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                                                        }
                                                        if (this.a.A0.s1().k() != null) {
                                                            addBigImageData.setForumHeadUrl(this.a.A0.s1().k().getImage_url());
                                                            addBigImageData.setUserLevel(this.a.A0.s1().k().getUser_level());
                                                        }
                                                        if (this.a.I0 != null && this.a.A0.G != null) {
                                                            addBigImageData.setMainPostMaskVisibly(this.a.A0.G.X().f1156T || rbaVar5.f1156T);
                                                        }
                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            this.a.S = view2;
                                            return;
                                        }
                                    } else {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091923) {
                                            StatisticItem statisticItem13 = new StatisticItem("c13398");
                                            statisticItem13.param("tid", this.a.A0.M1());
                                            statisticItem13.param("fid", this.a.A0.getForumId());
                                            statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem13.param("obj_locate", 4);
                                            TiebaStatic.log(statisticItem13);
                                        }
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091aab || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                            if (!this.a.checkUpIsLogin()) {
                                                rl9.v("c10517", this.a.A0.s1().l(), 3);
                                                return;
                                            } else if (this.a.A0 == null || this.a.A0.s1() == null) {
                                                return;
                                            } else {
                                                this.a.I0.F0();
                                                SparseArray sparseArray17 = (SparseArray) view2.getTag();
                                                rba rbaVar6 = (rba) sparseArray17.get(R.id.tag_load_sub_data);
                                                rba rbaVar7 = (rba) sparseArray17.get(R.id.tag_load_sub_reply_data);
                                                View view4 = (View) sparseArray17.get(R.id.tag_load_sub_view);
                                                if (rbaVar6 == null || view4 == null) {
                                                    return;
                                                }
                                                if (rbaVar6.N() == 1) {
                                                    TiebaStatic.log(new StatisticItem("c12630"));
                                                }
                                                StatisticItem statisticItem14 = rbaVar6.f0;
                                                if (statisticItem14 != null) {
                                                    StatisticItem copy3 = statisticItem14.copy();
                                                    copy3.delete("obj_locate");
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091923) {
                                                        copy3.param("obj_locate", 6);
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091aab) {
                                                        copy3.param("obj_locate", 8);
                                                    }
                                                    TiebaStatic.log(copy3);
                                                }
                                                String M12 = this.a.A0.M1();
                                                String S2 = rbaVar6.S();
                                                String S3 = rbaVar7 != null ? rbaVar7.S() : "";
                                                int W2 = this.a.A0.s1() != null ? this.a.A0.s1().W() : 0;
                                                this.a.m7();
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091ee3) {
                                                    TiebaStatic.log("c11742");
                                                    AbsPbActivity.e z62 = this.a.z6(S2);
                                                    if (rbaVar6 == null || this.a.A0 == null || this.a.A0.s1() == null || z62 == null) {
                                                        return;
                                                    }
                                                    SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(M12, S2, "pb", true, false, null, false, S3, W2, rbaVar6.l0(), this.a.A0.s1().c(), false, rbaVar6.r().getIconInfo(), 5).addBigImageData(z62.a, z62.b, z62.g, z62.j);
                                                    if (!bi.isEmpty(S3)) {
                                                        addBigImageData2.setHighLightPostId(S3);
                                                        addBigImageData2.setKeyIsUseSpid(true);
                                                    }
                                                    addBigImageData2.setKeyFromForumId(this.a.A0.getForumId());
                                                    addBigImageData2.setTiebaPlusData(this.a.A0.W(), this.a.A0.S(), this.a.A0.T(), this.a.A0.R(), this.a.A0.X());
                                                    addBigImageData2.setBjhData(this.a.A0.J0());
                                                    addBigImageData2.setKeyPageStartFrom(this.a.A0.r1());
                                                    addBigImageData2.setFromFrsForumId(this.a.A0.getFromForumId());
                                                    addBigImageData2.setWorksInfoData(this.a.A0.R1());
                                                    if (this.a.I0 != null && this.a.A0.G != null && (X = this.a.A0.G.X()) != null) {
                                                        addBigImageData2.setMainPostMaskVisibly(X.f1156T || rbaVar6.f1156T);
                                                    }
                                                    if (this.a.A0.s1() != null && this.a.A0.s1().n() != null) {
                                                        addBigImageData2.setHasForumRule(this.a.A0.s1().n().has_forum_rule.intValue());
                                                    }
                                                    this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                    return;
                                                }
                                                AbsPbActivity.e z63 = this.a.z6(S2);
                                                if (this.a.A0 == null || this.a.A0.s1() == null || z63 == null) {
                                                    return;
                                                }
                                                SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(M12, S2, "pb", true, false, null, true, null, W2, rbaVar6.l0(), this.a.A0.s1().c(), false, rbaVar6.r().getIconInfo(), 5).addBigImageData(z63.a, z63.b, z63.g, z63.j);
                                                addBigImageData3.setKeyPageStartFrom(this.a.A0.r1());
                                                addBigImageData3.setFromFrsForumId(this.a.A0.getFromForumId());
                                                addBigImageData3.setWorksInfoData(this.a.A0.R1());
                                                addBigImageData3.setKeyFromForumId(this.a.A0.getForumId());
                                                addBigImageData3.setBjhData(this.a.A0.J0());
                                                addBigImageData3.setTiebaPlusData(this.a.A0.W(), this.a.A0.S(), this.a.A0.T(), this.a.A0.R(), this.a.A0.X());
                                                this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                return;
                                            }
                                        }
                                        this.a.S = view2;
                                        return;
                                    }
                                } else if (this.a.A0 == null || this.a.A0.s1() == null || this.a.A0.s1().O() == null) {
                                    return;
                                } else {
                                    this.a.I0.k.f();
                                    TiebaStatic.log(new StatisticItem("c13062"));
                                    PbFragment pbFragment6 = this.a;
                                    pbFragment6.T5(pbFragment6.A0.s1().O().getFirstPostId());
                                    return;
                                }
                            }
                            this.a.I0.F0();
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                            } else if (this.a.h) {
                                view2.setTag(Integer.valueOf(this.a.A0.J1()));
                            } else {
                                this.a.m7();
                                this.a.I0.M3();
                                u45 u45Var = new u45(this.a.getPageContext());
                                if (this.a.A0.s1().f == null || this.a.A0.s1().f.size() <= 0) {
                                    strArr = new String[]{this.a.getResources().getString(R.string.sort_type_new), this.a.getResources().getString(R.string.sort_type_old)};
                                } else {
                                    strArr = new String[this.a.A0.s1().f.size()];
                                    for (int i10 = 0; i10 < this.a.A0.s1().f.size(); i10++) {
                                        strArr[i10] = this.a.A0.s1().f.get(i10).sort_name + this.a.getResources().getString(R.string.sort_static);
                                    }
                                }
                                u45Var.i(null, strArr, new a(this, u45Var, view2));
                                u45Var.l();
                            }
                        } else {
                            this.a.I0.F0();
                            if (this.a.R().s1().g == 2) {
                                this.a.showToast(R.string.hot_sort_jump_hint);
                                return;
                            }
                            if (this.a.A0.q1() != null) {
                                this.a.I0.y4(this.a.A0.q1(), this.a.g2);
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                        }
                    } else {
                        this.a.I0.k.f();
                    }
                } else {
                    this.a.I0.k.g();
                    if (this.a.A0 != null) {
                        this.a.u1.f(this.a.A0.M1());
                    }
                    if (this.a.A0 != null && this.a.A0.isPrivacy()) {
                        this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                        if (this.a.R() == null || this.a.R().s1() == null) {
                            return;
                        }
                        this.a.u1.d(3, 3, this.a.R().s1().Q());
                        return;
                    }
                    this.a.u1.b();
                    int i11 = (TbSingleton.getInstance().mCanCallFans || this.a.R() == null || this.a.R().s1() == null || this.a.R().s1().Q() == null || !this.a.R().s1().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                    if (this.a.R() == null || this.a.R().s1() == null) {
                        return;
                    }
                    this.a.u1.d(3, i11, this.a.R().s1().Q());
                }
            } else if (!this.a.s0) {
                StatisticItem statisticItem15 = new StatisticItem("c13398");
                statisticItem15.param("tid", this.a.A0.M1());
                statisticItem15.param("fid", this.a.A0.getForumId());
                statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem15.param("obj_locate", 1);
                TiebaStatic.log(statisticItem15);
                SparseArray sparseArray18 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                if (sparseArray18 != null && (sparseArray18.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray18.get(R.id.tag_is_top_question)).booleanValue()) {
                    rl9.w(2);
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!this.a.u) {
                    TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                    if (!(tbRichTextView.getTag() instanceof SparseArray)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (!(obj instanceof rba)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    rba rbaVar8 = (rba) obj;
                    if (this.a.A0 != null && this.a.A0.s1() != null && this.a.M5().v1() != null && rbaVar8.r() != null && rbaVar8.I() != 1) {
                        if (!this.a.checkUpIsLogin()) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        } else if (rbaVar8.A0()) {
                            return;
                        } else {
                            if (this.a.M5().w1() != null) {
                                this.a.M5().w1().g();
                            }
                            ke9 ke9Var2 = new ke9();
                            ke9Var2.v(this.a.A0.s1().k());
                            ke9Var2.z(this.a.A0.s1().O());
                            ke9Var2.x(rbaVar8);
                            this.a.M5().v1().j0(ke9Var2);
                            this.a.M5().v1().setPostId(rbaVar8.S());
                            this.a.k6(view2, rbaVar8.r().getUserId(), "", rbaVar8);
                            TiebaStatic.log("c11743");
                            rl9.b(this.a.A0.s1(), rbaVar8, rbaVar8.e0, 8, 1);
                            if (this.a.X0 != null) {
                                this.a.I0.r3(this.a.X0.z());
                                return;
                            }
                            return;
                        }
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                }
                this.a.u = false;
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            }
        }

        /* loaded from: classes7.dex */
        public class a implements w45.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ u45 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ j1 c;

            public a(j1 j1Var, u45 u45Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {j1Var, u45Var, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = j1Var;
                this.a = u45Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.A0.K1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.tieba.w45.f
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void K0(w45 w45Var, int i, View view2) {
                boolean m3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, w45Var, i, view2) == null) {
                    this.a.dismiss();
                    int i2 = 3;
                    int i3 = 0;
                    if (this.c.a.A0.K1() != 1 || i != 1) {
                        if (this.c.a.A0.K1() == 2 && i == 0) {
                            i2 = 1;
                        } else if (this.c.a.A0.K1() == 3 && i != 2) {
                            i2 = 2;
                        } else if (i == 2) {
                        }
                        TiebaStatic.log("c12097");
                        StatisticItem statisticItem = new StatisticItem("c12097");
                        if (this.b.getId() != R.id.obfuscated_res_0x7f091b24) {
                            i3 = 1;
                        }
                        TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                        if (this.c.a.A0.s1().f != null && this.c.a.A0.s1().f.size() > i) {
                            i = this.c.a.A0.s1().f.get(i).sort_type.intValue();
                        }
                        m3 = this.c.a.A0.m3(i);
                        this.b.setTag(Integer.valueOf(this.c.a.A0.J1()));
                        if (m3) {
                            return;
                        }
                        this.c.a.h = true;
                        this.c.a.I0.B3(true);
                        return;
                    }
                    i2 = 0;
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem2 = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f091b24) {
                    }
                    TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.A0.s1().f != null) {
                        i = this.c.a.A0.s1().f.get(i).sort_type.intValue();
                    }
                    m3 = this.c.a.A0.m3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.A0.J1()));
                    if (m3) {
                    }
                }
            }
        }

        public j1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }
    }

    /* loaded from: classes7.dex */
    public class m1 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ m1 b;

            public a(m1 m1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = m1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.I0 != null && this.a != null) {
                    this.b.a.I0.V2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements m45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(m1 m1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.m45.e
            public void onClick(m45 m45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                    m45Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements m45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m1 a;

            public c(m1 m1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = m1Var;
            }

            @Override // com.baidu.tieba.m45.e
            public void onClick(m45 m45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                    m45Var.dismiss();
                    ek9.a(this.a.a.getPageContext());
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public m1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, jd5 jd5Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, jd5Var, writeData, antiData}) == null) {
                if (!bi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.A0.s1() != null) {
                        statisticItem.param("fid", this.a.A0.s1().l());
                    }
                    statisticItem.param("tid", this.a.A0.M1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (bi.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.m7();
                this.a.I0.K3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (this.a.G0 != null) {
                    this.a.G0.getData(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    SafeHandler.getInst().postDelayed(this.a.X1, 300000L);
                }
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.X0 != null && (this.a.X0.y() || this.a.X0.A())) {
                            this.a.X0.w(false, postWriteCallBackData);
                        }
                        this.a.M0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.Z0;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (bi.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        m45 m45Var = new m45(this.a.getActivity());
                        if (bi.isEmpty(postWriteCallBackData.getErrorString())) {
                            m45Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            m45Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new b(this));
                        m45Var.setPositiveButton(R.string.open_now, new c(this));
                        m45Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (jd5Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.U6(i, antiData, str);
                        return;
                    }
                }
                this.a.f7(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.V6(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData != null && writeData.getType() == 2) {
                    if (floor != null) {
                        this.a.I0.d2(this.a.A0.s1());
                    }
                } else if (this.a.A0.V0()) {
                    td9 s1 = this.a.A0.s1();
                    if (s1 != null && s1.O() != null && s1.O().getAuthor() != null && (userId = s1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.A0.j3()) {
                        this.a.I0.M3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.A0.j3()) {
                    this.a.I0.M3();
                }
                if (this.a.A0.Z0()) {
                    rl9.t("c10369", this.a.A0.M1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.A0 != null) {
                    Context context = this.a.getContext();
                    td9 s12 = this.a.A0.s1();
                    String forumId = this.a.A0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    bi9.a(context, s12, forumId, z2, this.a.A0.y1(), this.a.A0.B1(), this.a.A0.A1(), this.a.A0.z1(), this.a.A0.F1(), this.a.A0.G1());
                }
                if (writeData != null) {
                    ta5.b(writeData.getContent(), "1");
                }
                if (this.a.c6()) {
                    this.a.p7();
                }
                this.a.d7();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n1 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ n1 b;

            public a(n1 n1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {n1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = n1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.I0 != null && this.a != null) {
                    this.b.a.I0.V2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements m45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(n1 n1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {n1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.m45.e
            public void onClick(m45 m45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                    m45Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements m45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n1 a;

            public c(n1 n1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {n1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = n1Var;
            }

            @Override // com.baidu.tieba.m45.e
            public void onClick(m45 m45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                    m45Var.dismiss();
                    ek9.a(this.a.a.getPageContext());
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public n1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, jd5 jd5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, jd5Var, writeData, antiData}) == null) {
                if (!bi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.A0 != null && this.a.A0.s1() != null) {
                        statisticItem.param("fid", this.a.A0.s1().l());
                    }
                    if (this.a.A0 != null) {
                        statisticItem.param("tid", this.a.A0.M1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.D5()) {
                        this.a.N6(false);
                        zb9.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f146f));
                    }
                    fi9 fi9Var = this.a.M0;
                    if (fi9Var != null) {
                        fi9Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        nf5.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        ta5.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.c6()) {
                        this.a.p7();
                    }
                    this.a.d7();
                    return;
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                }
                if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.Z0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (bi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    m45 m45Var = new m45(this.a.getActivity());
                    if (bi.isEmpty(postWriteCallBackData.getErrorString())) {
                        m45Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        m45Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new b(this));
                    m45Var.setPositiveButton(R.string.open_now, new c(this));
                    m45Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbFragment pbFragment = this.a;
                    if (pbFragment.M0 != null) {
                        if (pbFragment.I0 != null && this.a.I0.w1() != null && this.a.I0.w1().f() != null && this.a.I0.w1().f().z()) {
                            this.a.I0.w1().f().w(postWriteCallBackData);
                        }
                        this.a.M0.l(postWriteCallBackData);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements nw6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.nw6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.nw6.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

        public a(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFragment;
            this.a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070282);
        }

        @Override // com.baidu.tieba.nw6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.I0 != null && this.b.e != null) {
                this.b.e.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.e.l();
                }
                if (this.b.C5()) {
                    this.b.I0.L1();
                    this.b.I0.k3();
                }
            }
        }

        @Override // com.baidu.tieba.nw6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.I0 != null && this.b.e != null) {
                this.b.I0.s4();
                this.b.e.u(false);
                this.b.e.x();
            }
        }

        public final boolean e(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f)) == null) {
                if (Math.abs(f) >= 1.0f) {
                    return true;
                }
                return false;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements SuggestEmotionModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public a0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void a(gj9 gj9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, gj9Var) != null) || gj9Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, gj9Var.a()));
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                BdLog.e(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a1(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                    return;
                }
                this.a.p1 = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a2 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public a2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) && m45Var != null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a3 implements bg<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
        }

        public a3(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        public LinearLayout h(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, linearLayout)) == null) {
                linearLayout.removeAllViews();
                return linearLayout;
            }
            return (LinearLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.pb_text_voice_layout);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.setGravity(16);
                linearLayout.setBaselineAligned(true);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(layoutParams);
                return linearLayout;
            }
            return (LinearLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements ow6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ow6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    ze9.d();
                } else {
                    ze9.c();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!this.a.r0) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        this.a.v6();
                        return;
                    } else {
                        this.a.H6();
                        return;
                    }
                }
                this.a.r0 = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b1 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public b1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.a.V5();
                t25 q1 = this.a.A0.q1();
                int t1 = this.a.I0.t1();
                if (t1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0fe7);
                } else if (q1 != null && t1 > q1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0fe7);
                } else {
                    this.a.I0.F0();
                    this.a.m7();
                    this.a.I0.M3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.A0.g3(this.a.I0.t1());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e21);
                    }
                    m45Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b2 implements i95.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public b2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.i95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.C5()) {
                    this.a.a.finish();
                }
                if (this.a.A0.r2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.I0.N0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b3 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public b3(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                FrameLayout frameLayout = (FrameLayout) this.a.getPageContext().getPageActivity().getWindow().getDecorView();
                for (int i = 0; i < frameLayout.getChildCount(); i++) {
                    View childAt = frameLayout.getChildAt(i);
                    if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                        break;
                    }
                }
                this.a.d.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements rg9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public c(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.rg9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f179f);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e21);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.I0.D0(str);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements GetSugMatchWordsModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public c0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onSuccess(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && !ListUtils.isEmpty(list) && this.a.I0 != null) {
                this.a.I0.R3(list);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                BdLog.e(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c1 implements f3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public c1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.f3
        public void callback(Object obj) {
            String str;
            String str2;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(this.a.A0.s1().V().getUserId());
                if (objArr.length <= 1) {
                    str = "";
                } else {
                    str = String.valueOf(objArr[1]);
                }
                if (objArr.length <= 2) {
                    str2 = "";
                } else {
                    str2 = String.valueOf(objArr[2]);
                }
                if (objArr.length <= 3) {
                    str3 = "";
                } else {
                    str3 = String.valueOf(objArr[3]);
                }
                if (objArr.length <= 4) {
                    str4 = "";
                } else {
                    str4 = String.valueOf(objArr[4]);
                }
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.A0.s1().k().getId(), this.a.A0.s1().k().getName(), this.a.A0.s1().O().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c2 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public c2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.C5()) {
                    this.a.a.finish();
                }
                if (this.a.A0.r2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.I0.N0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c3 implements d3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public c3(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.d3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.I0 != null && this.a.I0.w1() != null) {
                    ah9 w1 = this.a.I0.w1();
                    if (w1.j()) {
                        w1.h();
                        return true;
                    }
                }
                if (this.a.I0 != null && this.a.I0.r2()) {
                    this.a.I0.O1();
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public d(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    m45Var.dismiss();
                    ((TbPageContext) this.a.g1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                m45Var.dismiss();
                ek9.a(this.a.getPageContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements PbInterviewStatusView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public d0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.I0.z4(!this.a.N);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d1 implements w45.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public d1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.w45.f
        public void K0(w45 w45Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, w45Var, i, view2) == null) {
                if (this.a.N0 != null) {
                    this.a.N0.dismiss();
                }
                this.a.r7(i);
                if (i != -4) {
                    if (i != -3) {
                        if (i != -2) {
                            if (i != -1) {
                                if (i != 13) {
                                    int i2 = 4;
                                    switch (i) {
                                        case 1:
                                            if (this.a.l1 != null && !TextUtils.isEmpty(this.a.m1)) {
                                                if (this.a.o1 != null) {
                                                    rl5.a aVar = new rl5.a();
                                                    aVar.a = this.a.m1;
                                                    String str = "";
                                                    if (this.a.o1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.o1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.Y4();
                                                }
                                                this.a.l1 = null;
                                                this.a.m1 = null;
                                                return;
                                            }
                                            return;
                                        case 2:
                                            if (this.a.l1 != null && !TextUtils.isEmpty(this.a.m1)) {
                                                if (this.a.Y0 == null) {
                                                    this.a.Y0 = new PermissionJudgePolicy();
                                                }
                                                this.a.Y0.clearRequestPermissionList();
                                                this.a.Y0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                if (this.a.Y0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                                    return;
                                                }
                                                if (this.a.k1 == null) {
                                                    PbFragment pbFragment = this.a;
                                                    pbFragment.k1 = new hi9(pbFragment.getPageContext());
                                                }
                                                this.a.k1.b(this.a.m1, this.a.l1.getImageByte());
                                                this.a.l1 = null;
                                                this.a.m1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            rba rbaVar = this.a.D2;
                                            if (rbaVar != null) {
                                                rbaVar.P0();
                                                this.a.D2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.o6(view2);
                                            if (this.a.A0.s1().O() != null && this.a.A0.s1().O().getAuthor() != null && this.a.A0.s1().O().getAuthor().getUserId() != null && this.a.C0 != null) {
                                                int v = bi9.v(this.a.A0.s1());
                                                ThreadData O = this.a.A0.s1().O();
                                                if (O.isBJHArticleThreadType()) {
                                                    i2 = 2;
                                                } else if (O.isBJHVideoThreadType()) {
                                                    i2 = 3;
                                                } else if (!O.isBJHNormalThreadType()) {
                                                    if (O.isBJHVideoDynamicThreadType()) {
                                                        i2 = 5;
                                                    } else {
                                                        i2 = 1;
                                                    }
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.A0.b).param("obj_locate", 2).param("obj_id", this.a.A0.s1().O().getAuthor().getUserId()).param("obj_type", !this.a.C0.e()).param("obj_source", v).param("obj_param1", i2));
                                                return;
                                            }
                                            return;
                                        case 5:
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag = view2.getTag();
                                            if (tag instanceof String) {
                                                TiebaStatic.log(new StatisticItem("c13079"));
                                                this.a.T5((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray2.put(R.id.tag_from, 0);
                                                    sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                    this.a.c5(sparseArray2);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 6:
                                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                            if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean) && (sparseArray3.get(R.id.tag_has_sub_post) instanceof Boolean)) {
                                                boolean booleanValue = ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue();
                                                int intValue = ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue();
                                                boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.tag_has_sub_post)).booleanValue();
                                                boolean G = this.a.Y().G(TbadkCoreApplication.getCurrentAccount());
                                                if (G) {
                                                    if (booleanValue2) {
                                                        this.a.I0.P2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, G);
                                                        return;
                                                    } else {
                                                        this.a.W6(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.I0.N2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                                    return;
                                                } else {
                                                    this.a.W6(sparseArray3, intValue, booleanValue);
                                                    return;
                                                }
                                            }
                                            return;
                                        case 7:
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                                            if (sparseArray4 == null) {
                                                return;
                                            }
                                            boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                                            boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                                            boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                            if (sparseArray4.get(R.id.tag_is_self_post) instanceof Boolean) {
                                                z = ((Boolean) sparseArray4.get(R.id.tag_is_self_post)).booleanValue();
                                            } else {
                                                z = false;
                                            }
                                            if (booleanValue3) {
                                                if (booleanValue5) {
                                                    sparseArray4.put(R.id.tag_from, 1);
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                    this.a.c5(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                }
                                                this.a.I0.S2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.I0.N2(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            rba rbaVar2 = (rba) sparseArray.get(R.id.tag_clip_board);
                                            if (rbaVar2.o() == null) {
                                                return;
                                            }
                                            this.a.g5(rbaVar2.o());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.A0 != null && this.a.A0.s1() != null) {
                                                this.a.a.T1(bka.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.A0 != null && this.a.A0.s1() != null) {
                                    this.a.I0.S4(true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            if (view3 == null) {
                                return;
                            }
                            this.a.B6(view3);
                            AgreeView agreeView = (AgreeView) view3;
                            if (agreeView.getImgAgree() != null) {
                                agreeView.getImgAgree().performClick();
                                return;
                            }
                            return;
                        }
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                        if (view4 != null) {
                            AgreeView agreeView2 = (AgreeView) view4;
                            this.a.B6(view4);
                            if (agreeView2.getImgDisagree() != null) {
                                agreeView2.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    SparseArray sparseArray5 = (SparseArray) view2.getTag();
                    View view5 = (View) sparseArray5.get(R.id.pb_dialog_item_reply);
                    this.a.B6(view5);
                    if (view5 != null) {
                        if (sparseArray5 != null && (sparseArray5.get(R.id.tag_is_top_question) instanceof Boolean)) {
                            this.a.N6(((Boolean) sparseArray5.get(R.id.tag_is_top_question)).booleanValue());
                        }
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.B6(view6);
                if (view6 != null) {
                    view6.performClick();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d2 implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public d2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.y2 && this.a.C5()) {
                    this.a.h6();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (this.a.I0 != null) {
                    this.a.I0.l3();
                }
                if (!this.a.f0 && this.a.I0 != null && this.a.I0.v0() && this.a.A0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.A0.M1());
                    statisticItem.param("fid", this.a.A0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.A0.X0()) {
                        i = 4;
                    } else if (this.a.A0.Y0()) {
                        i = 3;
                    } else if (this.a.A0.a1()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.f0 = true;
                }
                if (this.a.A0.p2(false)) {
                    this.a.I0.N3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (this.a.A0.s1() != null) {
                    this.a.I0.f3();
                }
                this.a.y2 = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public e(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 implements PraiseModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public e0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.Q1 != null && str != null) {
                if (AntiHelper.m(i, str)) {
                    AntiHelper.u(this.a.getPageContext().getPageActivity(), str);
                } else {
                    this.a.showToast(str);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void i(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || this.a.Q1 == null) {
                return;
            }
            td9 s1 = this.a.A0.s1();
            if (s1.O().getPraise().getIsLike() == 1) {
                this.a.u7(0);
            } else {
                this.a.u7(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, s1.O()));
        }
    }

    /* loaded from: classes7.dex */
    public class e1 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PbFragment d;

        public e1(PbFragment pbFragment, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = pbFragment;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                if (m45Var != null) {
                    m45Var.dismiss();
                }
                this.d.o5(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e2 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public e2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.A0 != null) {
                this.a.A0.loadData();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<ci9> a;
        public WeakReference<PbFragment> b;

        public e3(ci9 ci9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(ci9Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                ci9 ci9Var = this.a.get();
                if (ci9Var != null) {
                    ci9Var.K1();
                }
                PbFragment pbFragment = this.b.get();
                if (pbFragment != null && CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        pbFragment.g7(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        sw7.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0e21);
                        }
                        pbFragment.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public f(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f0 implements jj9.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public f0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.jj9.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.P6(z);
                if (this.a.I0.j1() != null && z) {
                    this.a.I0.z4(false);
                }
                this.a.I0.E2(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f1 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public f1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ PbFragment b;

        public g(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFragment;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.b.I0.k4();
                MessageManager.getInstance().sendMessage(this.a);
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g0 implements w45.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ PbFragment e;

        public g0(PbFragment pbFragment, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = pbFragment;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tieba.w45.f
        public void K0(w45 w45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, w45Var, i, view2) == null) {
                if (this.e.N0 != null) {
                    this.e.N0.dismiss();
                }
                if (i == 0) {
                    this.e.I0.N2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.i1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.i1);
                    this.e.i7(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g1 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public final int b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                if (i == 2) {
                    return 1;
                }
                if (i == 0) {
                    return 2;
                }
                return i == 1 ? 3 : 0;
            }
            return invokeI.intValue;
        }

        public g1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.a.I0.F0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.A0 != null && !this.a.A0.isLoading) {
                    this.a.m7();
                    this.a.I0.M3();
                    z = true;
                    if (this.a.A0.s1() != null && this.a.A0.s1().f != null && this.a.A0.s1().f.size() > i) {
                        int intValue = this.a.A0.s1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.A0.N1()).param("fid", this.a.A0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.A0.m3(intValue)) {
                            this.a.h = true;
                            this.a.I0.B3(true);
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g2 implements mj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public g2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.mj5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                fi9 fi9Var = this.a.M0;
                if (fi9Var != null && fi9Var.e() != null && this.a.M0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.M0.e().c());
                    if (this.a.X0 != null && (this.a.X0.y() || this.a.X0.A())) {
                        this.a.X0.w(false, this.a.M0.h());
                    }
                    this.a.M0.a(true);
                    return true;
                }
                return !this.a.f5(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public h(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                if (updateAttentionMessage.getData().blockData != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() == this.a.getUniqueId() && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().blockData, PbFragment.T2) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                        return;
                    }
                    return;
                }
                if (updateAttentionMessage.getData().isSucc) {
                    if (this.a.v5().r() != null && this.a.v5().r().getGodUserData() != null) {
                        this.a.v5().r().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.A0 != null && this.a.A0.s1() != null && this.a.A0.s1().O() != null && this.a.A0.s1().O().getAuthor() != null) {
                        this.a.A0.s1().O().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
                if (updateAttentionMessage.isAttention()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921760, 10));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h2 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ m45 c;
        public final /* synthetic */ PbFragment d;

        public h2(PbFragment pbFragment, MarkData markData, MarkData markData2, m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, m45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = pbFragment;
            this.a = markData;
            this.b = markData2;
            this.c = m45Var;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
                if (this.d.C0 != null) {
                    if (this.d.C0.e()) {
                        this.d.C0.d();
                        this.d.C0.h(false);
                    }
                    this.d.C0.i(this.a);
                    this.d.C0.h(true);
                    this.d.C0.a();
                }
                this.b.setPostId(this.a.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.b);
                this.d.a.setResult(-1, intent);
                this.c.dismiss();
                this.d.n7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements kh9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.kh9.b
        public void onSuccess(List<rba> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }

        public i(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.kh9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.I0.D4(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i0 extends ResponsedEventListener<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public i0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.uo5
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId > 0 && this.a.a.getPageId() == tipEvent.pageId) {
                    DefaultNavigationBarCoverTip.s(this.a.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i2 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ m45 b;
        public final /* synthetic */ PbFragment c;

        public i2(PbFragment pbFragment, MarkData markData, m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, m45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pbFragment;
            this.a = markData;
            this.b = m45Var;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.n7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.A0 != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.X0 != null) {
                    this.a.I0.r3(this.a.X0.z());
                }
                this.a.I0.j3();
                this.a.I0.F0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 extends ResponsedEventListener<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public j0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.uo5
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                if (this.a.I0 != null && topToastEvent != null) {
                    new BdTopToast(this.a.getContext()).setIcon(topToastEvent.isSuccess()).setContent(topToastEvent.getContent()).show(this.a.I0.E1());
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ m45 b;
        public final /* synthetic */ PbFragment c;

        public j2(PbFragment pbFragment, MarkData markData, m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, m45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pbFragment;
            this.a = markData;
            this.b = m45Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.I0 != null && this.c.I0.E1() != null) {
                    this.c.I0.E1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.a.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.n7();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData)) {
                return;
            }
            this.a.A0.p3((UserPendantData) customResponsedMessage.getData());
            if (this.a.I0 != null && this.a.A0 != null) {
                this.a.I0.d3(this.a.A0.s1(), this.a.A0.L1(), this.a.A0.D1(), this.a.I0.A1());
            }
            if (this.a.I0 != null && this.a.I0.T0() != null) {
                this.a.I0.T0().f0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;
        public final /* synthetic */ PbFragment b;

        public k0(PbFragment pbFragment, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFragment;
            this.a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            ci9 ci9Var = this.b.I0;
            ci9Var.P3("@" + this.a.getStringExtra("big_pic_type") + " ");
        }
    }

    /* loaded from: classes7.dex */
    public class k1 implements yy4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.yy4.c
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "pbPage.novelPaySuccess" : (String) invokeV.objValue;
        }

        public k1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.yy4.c
        public void a(@NonNull String str) {
            rba X;
            rg5 a0;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("PbFragment", "收到H5通知，更新Pb数据：" + str);
                if (this.a.A0 == null) {
                    return;
                }
                this.a.A0.loadData();
                td9 s1 = this.a.A0.s1();
                if (s1 != null && (X = s1.X()) != null && (a0 = X.a0()) != null && !a0.n()) {
                    wq5 wq5Var = new wq5();
                    wq5Var.t(a0);
                    String Q = s1.Q();
                    String l = s1.l();
                    if (s1.O() != null) {
                        i = s1.O().getThreadType();
                    } else {
                        i = 0;
                    }
                    wq5Var.w(Q, l, i, this.a.A0.L0(), this.a.A0.x1(), a0.d());
                    String x = wq5Var.x(a0.e());
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(NovelWebViewActivityConfig.KEY_IS_SHOW_TOAST_TIP, true);
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_ID, String.valueOf(a0.h()));
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_TID, wq5Var.i());
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_FID, wq5Var.e());
                    BrowserHelper.startWebActivity(this.a.getContext(), "", x, true, true, true, bundle);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921658, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k2 implements bg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public k2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, imageView) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (b05.c().g()) {
                        tbImageView.setAdjustViewBounds(false);
                        tbImageView.setInterceptOnClick(false);
                    } else {
                        tbImageView.setDefaultResource(R.drawable.icon_click);
                        tbImageView.setAdjustViewBounds(true);
                        tbImageView.setInterceptOnClick(true);
                    }
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        public ImageView h(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imageView)) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.reset();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = b05.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                    foreDrawableImageView.setAdjustViewBounds(true);
                    foreDrawableImageView.setInterceptOnClick(true);
                }
                return foreDrawableImageView;
            }
            return (ImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.I0 == null) {
                    return;
                }
                if (booleanValue) {
                    this.a.I0.u4();
                } else {
                    this.a.I0.M1();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public l0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    if (this.a.X0 != null) {
                        this.a.X0.H(null, null);
                    }
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.I0 != null && this.a.I0.w1() != null && this.a.I0.w1().f() != null) {
                    this.a.I0.w1().f().I();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l1(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || this.a.A0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.A0.b)) {
                return;
            }
            this.a.f7((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes7.dex */
    public class l2 implements bg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public l2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.m();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.p();
                gifView.m();
                gifView.setImageDrawable(null);
                gifView.q();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }

        public GifView e(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) {
                gifView.setTag(null);
                if (b05.c().g()) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = b05.c().g();
                gifView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.X0 != null) {
                this.a.I0.r3(this.a.X0.z());
            }
            this.a.I0.c4(false);
        }
    }

    /* loaded from: classes7.dex */
    public class m0 extends h9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public m0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.h9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m2 implements bg<TiebaPlusRecommendCard> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public m2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard c(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            h(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        public TiebaPlusRecommendCard e(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tiebaPlusRecommendCard)) == null) {
                tiebaPlusRecommendCard.l();
                return tiebaPlusRecommendCard;
            }
            return (TiebaPlusRecommendCard) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tiebaPlusRecommendCard) == null) {
                tiebaPlusRecommendCard.m();
            }
        }

        public TiebaPlusRecommendCard h(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tiebaPlusRecommendCard)) == null) {
                tiebaPlusRecommendCard.m();
                return tiebaPlusRecommendCard;
            }
            return (TiebaPlusRecommendCard) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public TiebaPlusRecommendCard d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new TiebaPlusRecommendCard(this.a.getPageContext().getPageActivity());
            }
            return (TiebaPlusRecommendCard) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                bc9 bc9Var = (bc9) customResponsedMessage.getData();
                int type = bc9Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (bc9Var.a() == null) {
                                this.a.D6(false, null);
                                return;
                            } else {
                                this.a.D6(true, (MarkData) bc9Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.q5((ForumManageModel.b) bc9Var.a(), false);
                    return;
                }
                this.a.E6((ke9) bc9Var.a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements PbFirstFloorDoubleClickAnimation.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public n0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n2 implements bg<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public n2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ View c(View view2) {
            View view3 = view2;
            h(view3);
            return view3;
        }

        public View e(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
                ((PlayVoiceBntNew) view2).l();
                return view2;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).k();
            }
        }

        public View h(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
                ((PlayVoiceBntNew) view2).k();
                return view2;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.z0());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.I0 != null && this.a.I0.T0() != null) {
                this.a.I0.T0().f0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o0 implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public o0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.a.A0 != null && this.a.A0.d1()) {
                    this.a.l6();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class o1 extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o1(PbFragment pbFragment, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView C1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (this.a.I0 != null && (C1 = this.a.I0.C1()) != null && this.a.I0.m1() != null) {
                            this.a.I0.m1().removeHeaderView(C1);
                            return;
                        }
                        return;
                    }
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o2 implements bg<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        public o2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new RelativeLayout(this.a.getPageContext().getPageActivity());
            }
            return (RelativeLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof p06.a)) {
                p06.a aVar = (p06.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.Q5(aVar.b);
                }
                p06.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p0 implements af9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.af9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public p0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.af9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091f04) {
                        if (this.a.I6(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09015c) {
                        if (motionEvent != null && motionEvent.getAction() == 1) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof rba)) {
                                return false;
                            }
                            rba rbaVar = (rba) obj;
                            if (rbaVar.getType() != rba.Z0 && !TextUtils.isEmpty(rbaVar.u()) && b05.c().g()) {
                                return this.a.q6(rbaVar);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091aaa) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.k7((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.I0.i2() && view2.getId() == R.id.obfuscated_res_0x7f091acc) {
                            if (view2.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.tag_user_id)));
                            }
                            if (this.a.J0() != null && this.a.J0().b != null) {
                                this.a.J0().b.onClick(view2);
                            }
                        }
                    } else {
                        SparseArray sparseArray = null;
                        if (view2.getTag() instanceof SparseArray) {
                            sparseArray = (SparseArray) view2.getTag();
                        }
                        if (sparseArray == null) {
                            return false;
                        }
                        this.a.k7(sparseArray);
                    }
                }
                if (this.a.X0 != null) {
                    this.a.I0.r3(this.a.X0.z());
                }
                this.a.I0.j3();
                this.a.I0.F0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.af9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                this.a.p5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class p1 implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public p1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(td9 td9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, td9Var) == null) {
                this.a.I0.d2(td9Var);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            long j2;
            long j3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                return;
            }
            if (!z2) {
                j2 = System.currentTimeMillis() - this.a.l;
            } else {
                j2 = j;
            }
            if (this.a.m == 0) {
                this.a.m = j2;
            }
            long j4 = j2;
            ur5 ur5Var = new ur5(i, z, responsedMessage, this.a.p, this.a.o, this.a.m, z2, 0L, 0L, j4);
            this.a.o = 0L;
            this.a.p = 0L;
            ur5Var.c();
            if (z2) {
                j3 = j4;
                ur5Var.B = j3;
                ur5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.A0 != null && this.a.A0.s1() != null && this.a.A0.s1().O() != null) {
                int threadType = this.a.A0.s1().O().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.M, "from_personalize")) {
                        qr5 qr5Var = new qr5();
                        qr5Var.F = 1;
                        qr5Var.a(1005);
                        qr5Var.D = j3;
                        qr5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.M, "from_frs")) {
                        ur5 ur5Var2 = new ur5();
                        ur5Var2.a(1000);
                        ur5Var2.D = j3;
                        ur5Var2.d(threadType);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, td9 td9Var, String str, int i4) {
            boolean z2;
            th5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), td9Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907b1));
                }
                if (z && td9Var != null && td9Var.Y() == null && ListUtils.getCount(td9Var.F()) < 1) {
                    this.a.A0.g3(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                    if (this.a.I0 != null) {
                        this.a.I0.v4();
                        return;
                    }
                    return;
                }
                if (!this.a.g0) {
                    this.a.g0 = true;
                } else if (this.a.R() != null) {
                    this.a.R().z0();
                }
                this.a.g = true;
                if (this.a.I0 == null) {
                    return;
                }
                this.a.I0.L3();
                if (td9Var == null || !td9Var.s0()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.I0.E1());
                }
                this.a.I0.M1();
                int i5 = 0;
                if (this.a.J) {
                    this.a.I0.G1();
                } else if (!this.a.I0.h2()) {
                    this.a.I0.c4(false);
                }
                if (this.a.h) {
                    this.a.h = false;
                }
                if (i4 == 0 && td9Var != null) {
                    this.a.Q0 = true;
                }
                if (td9Var != null) {
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.hideNetRefreshView(pbFragment2.I0.E1());
                    this.a.I0.V3();
                }
                ArrayList<rba> arrayList = null;
                String x1 = null;
                arrayList = null;
                if (z && td9Var != null) {
                    ThreadData O = td9Var.O();
                    if (O != null && O.isUgcThreadType()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = this.a;
                        pbFragment3.Q6(pbFragment3.W0);
                    }
                    this.a.I0.w1().r(td9Var);
                    this.a.I0.j4();
                    if (O != null && O.getCartoonThreadData() != null) {
                        this.a.t7(O.getCartoonThreadData());
                    }
                    if (this.a.X0 != null) {
                        this.a.I0.r3(this.a.X0.z());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(td9Var.V().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(td9Var.V().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(td9Var.V().getBimg_end_time());
                    if (td9Var.F() != null && td9Var.F().size() >= 1 && td9Var.F().get(0) != null) {
                        this.a.A0.S2(td9Var.F().get(0).S());
                    } else if (td9Var.Y() != null) {
                        this.a.A0.S2(td9Var.Y().S());
                    }
                    if (this.a.X0 != null) {
                        this.a.X0.I(td9Var.c());
                        this.a.X0.J(td9Var.k(), td9Var.V());
                        this.a.X0.l0(O);
                        this.a.X0.K(this.a.A0.U0(), this.a.A0.M1(), this.a.A0.Q0());
                        if (O != null) {
                            this.a.X0.a0(O.isMutiForumThread());
                        }
                    }
                    if (this.a.C0 != null) {
                        this.a.C0.h(td9Var.q());
                    }
                    PbFragment pbFragment4 = this.a;
                    if (td9Var.r() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    pbFragment4.q = z2;
                    if (td9Var.j0()) {
                        this.a.q = true;
                    }
                    this.a.I0.s3(this.a.q);
                    if (this.a.u0.f.size() > 0) {
                        td9Var.S0(this.a.u0.f);
                    }
                    this.a.I0.n4(td9Var, i2, i3, this.a.A0.L1(), i4, this.a.A0.b1());
                    this.a.I0.C4(td9Var, this.a.A0.L1());
                    this.a.I0.K4(this.a.A0.V0());
                    AntiData c = td9Var.c();
                    if (c != null) {
                        this.a.x = c.getVoice_message();
                        if (!StringUtils.isNull(this.a.x) && this.a.X0 != null && this.a.X0.b() != null && (o = this.a.X0.b().o(6)) != null && !TextUtils.isEmpty(this.a.x)) {
                            ((View) o).setOnClickListener(this.a.H1);
                        }
                    }
                    if (!this.a.X && !ListUtils.isEmpty(this.a.A0.s1().F()) && !this.a.A0.g2()) {
                        this.a.X = true;
                        this.a.a5(false);
                    }
                    if (!TextUtils.isEmpty(this.a.T0)) {
                        PbFragment pbFragment5 = this.a;
                        bi9.G(pbFragment5, pbFragment5.A0.r1(), this.a.T0);
                        this.a.T0 = null;
                    } else if (this.a.S0) {
                        this.a.S0 = false;
                        bi9.F(this.a);
                    } else if (this.a.U0) {
                        this.a.U0 = false;
                        dj9.j(this.a.getListView());
                    } else if (!TextUtils.isEmpty(this.a.A0.i1())) {
                        dj9.f(this.a.getListView(), this.a.A0.i1());
                        this.a.A0.n2();
                    } else {
                        this.a.I0.i4();
                    }
                    this.a.A0.o2(td9Var.k(), this.a.N1);
                    this.a.A0.s2(this.a.P1);
                    if (this.a.Z0 != null && O != null && O.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(O.getAuthor());
                        this.a.Z0.setLikeUserData(attentionHostData);
                    }
                    if (this.a.A0 != null && this.a.A0.c2()) {
                        x1 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.I0 != null) {
                        x1 = this.a.I0.x1();
                    }
                    if (this.a.X0 != null && !StringUtils.isNull(x1)) {
                        this.a.X0.d0(TbSingleton.getInstance().getAdVertiComment(td9Var.q0(), td9Var.r0(), x1));
                    }
                    if (!this.a.Q0 && ((i2 == 1 || i2 == 2) && this.a.I0 != null)) {
                        this.a.I0.Q0();
                    }
                } else if (str != null) {
                    if (!this.a.Q0 && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6 || i2 == 9) {
                            if (i == 4) {
                                if (this.a.A0.H0() != null && !StringUtils.isNull(this.a.A0.H0().c)) {
                                    this.a.I0.M4(this.a.A0.H0());
                                } else {
                                    PbFragment pbFragment6 = this.a;
                                    pbFragment6.showNetRefreshView(pbFragment6.I0.E1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    z3a.a("pb", false);
                                    PbFragment pbFragment7 = this.a;
                                    pbFragment7.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
                                }
                            } else {
                                PbFragment pbFragment8 = this.a;
                                pbFragment8.showNetRefreshView(pbFragment8.I0.E1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                z3a.a("pb", false);
                                PbFragment pbFragment9 = this.a;
                                pbFragment9.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment9.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
                            }
                            this.a.I0.G1();
                            this.a.I0.F1();
                        }
                    } else {
                        this.a.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.A0.M1());
                            jSONObject.put("fid", this.a.A0.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                        sr6.b().b(new td5(this.a.A0.M1()));
                    }
                    if (i != 0) {
                        EnterForePvThread enterForePvThread = new EnterForePvThread();
                        enterForePvThread.setOpType("2");
                        enterForePvThread.start();
                    }
                    if (i != -1) {
                        if (this.a.A0 != null && this.a.A0.s1() != null) {
                            arrayList = this.a.A0.s1().F();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).I() != 1)) {
                            this.a.I0.n3(this.a.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (this.a.e6()) {
                                this.a.I0.o3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fe4));
                            } else {
                                this.a.I0.o3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fe5));
                            }
                            this.a.I0.d2(this.a.A0.s1());
                        }
                    } else {
                        this.a.I0.n3("");
                    }
                    this.a.I0.M0();
                }
                if (td9Var != null && td9Var.m && this.a.m == 0) {
                    this.a.m = System.currentTimeMillis() - this.a.l;
                }
                if (this.a.a instanceof PbActivity) {
                    PbActivity pbActivity = (PbActivity) this.a.a;
                    if (td9Var != null) {
                        i5 = td9Var.f();
                    }
                    pbActivity.d2(i5, this.a.I0);
                }
                if (this.a.A0 != null && this.a.A0.s1() != null) {
                    this.a.A0.s1();
                }
            }
        }

        public final void d() {
            Bundle extras;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.a.A0 == null) {
                return;
            }
            if (this.a.X0 != null && this.a.X0.t) {
                return;
            }
            pj5 pj5Var = new pj5();
            this.a.Q6(pj5Var);
            PbFragment pbFragment = this.a;
            pbFragment.X0 = (qj5) pj5Var.a(pbFragment.getContext());
            this.a.X0.X(this.a.a.getPageContext());
            this.a.X0.g0(this.a.m2);
            this.a.X0.h0(this.a.b1);
            qj5 qj5Var = this.a.X0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
            if (this.a.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.a.getIntent().getExtras();
            }
            qj5Var.B(pageContext, extras);
            this.a.X0.b().F(true);
            this.a.I0.m3(this.a.X0.b());
            if (!this.a.A0.f1()) {
                this.a.X0.q(this.a.A0.M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.X0.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.A0.c2()) {
                this.a.X0.d0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.I0 != null) {
                this.a.X0.d0(this.a.I0.x1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p2 implements bg<ItemCardView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
        }

        public p2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ ItemCardView c(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            h(itemCardView2);
            return itemCardView2;
        }

        public ItemCardView e(ItemCardView itemCardView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, itemCardView)) == null) {
                itemCardView.G();
                return itemCardView;
            }
            return (ItemCardView) invokeL.objValue;
        }

        public ItemCardView h(ItemCardView itemCardView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, itemCardView)) == null) {
                itemCardView.H();
                return itemCardView;
            }
            return (ItemCardView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public ItemCardView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new ItemCardView(this.a.getPageContext().getPageActivity());
            }
            return (ItemCardView) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.f) {
                return;
            }
            this.a.j7();
        }
    }

    /* loaded from: classes7.dex */
    public class q0 implements n45.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public q0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.n45.c
        public void a(n45 n45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n45Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.P0 = pbFragment.P0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.P0);
                    new gg9(this.a.A0.M1(), this.a.P0, "1").start();
                    n45Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.P0 = pbFragment2.P0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.P0);
                    new gg9(this.a.A0.M1(), this.a.P0, "2").start();
                    n45Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.P0 = pbFragment3.P0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.P0);
                    n45Var.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q1(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof CustomResponsedMessage) || !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            this.a.s7();
        }
    }

    /* loaded from: classes7.dex */
    public class q2 implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public q2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v24, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            lg9 T0;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.I0.B2((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.A0.M1());
                    statisticItem.param("fid", this.a.A0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    if (z2) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    statisticItem.param("obj_type", i2);
                    TiebaStatic.log(statisticItem);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && (view2 instanceof TbImageView)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        boolean isGif = ((TbImageView) view2).isGif();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                        }
                        this.a.R = view2;
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.x6(str, i, eVar);
                    if (this.a.A0.G.j0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view2.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view2.getParent();
                        } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                        }
                        int i5 = -1;
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().R() != null) {
                            ArrayList<TbRichTextImageInfo> R = tbRichTextView.getRichText().R();
                            int i6 = 0;
                            int i7 = -1;
                            while (i6 < R.size()) {
                                if (R.get(i6) != null) {
                                    arrayList.add(R.get(i6).getSrc());
                                    if (i7 == i5 && str != null && (str.equals(R.get(i6).getSrc()) || str.equals(R.get(i6).O()) || str.equals(R.get(i6).N()) || str.equals(R.get(i6).getBigSrc()) || str.equals(R.get(i6).Q()))) {
                                        i7 = i6;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    String src = R.get(i6).getSrc();
                                    imageUrlData.imageUrl = src;
                                    imageUrlData.imageThumbUrl = src;
                                    if (this.a.q) {
                                        i4 = 17;
                                    } else {
                                        i4 = 18;
                                    }
                                    imageUrlData.urlThumbType = i4;
                                    imageUrlData.originalUrl = R.get(i6).getSrc();
                                    imageUrlData.isLongPic = R.get(i6).U();
                                    concurrentHashMap.put(R.get(i6).getSrc(), imageUrlData);
                                }
                                i6++;
                                i5 = -1;
                            }
                            i3 = i7;
                        } else {
                            i3 = -1;
                        }
                        Rect rect = new Rect();
                        view2.getGlobalVisibleRect(rect);
                        this.a.s5(rect);
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.setData(arrayList).setIndex(i3).setIsCDN(false).setPostId(eVar.f).setIsReserve(this.a.A0.E1()).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false).setIsSeeHost(this.a.e6()).setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.A0 != null) {
                            builder.setFromForumId(this.a.A0.getFromForumId());
                            if (this.a.A0.s1() != null) {
                                builder.setThreadData(this.a.A0.s1().O());
                            }
                        }
                        ImageViewerConfig bulid = builder.bulid(this.a.getPageContext().getPageActivity());
                        bulid.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, bulid));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else if (!eVar.h) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!ListUtils.isEmpty(arrayList2)) {
                            String str2 = (String) arrayList2.get(0);
                            concurrentHashMap2.put(str2, eVar.b.get(str2));
                        }
                        ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                        builder2.setData(arrayList2).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.a.get(0)).setIsReserve(this.a.A0.E1()).setAssistUrls(concurrentHashMap2).setNeedBroadCaset(false).setIsSeeHost(this.a.e6()).setPostId(eVar.f).setBjhPostId(eVar.f).setIsCanDrag(false);
                        if (this.a.A0 != null) {
                            builder2.setFromForumId(this.a.A0.getFromForumId());
                            if (this.a.A0.s1() != null) {
                                builder2.setThreadData(this.a.A0.s1().O());
                            }
                        }
                        ImageViewerConfig bulid2 = builder2.bulid(this.a.getPageContext().getPageActivity());
                        bulid2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, bulid2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText v7 = this.a.v7(str, i);
                        if (v7 != null && this.a.A2 >= 0 && this.a.A2 < v7.P().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = ud9.a(v7.P().get(this.a.A2));
                            int i8 = 0;
                            while (true) {
                                if (i8 >= eVar.a.size()) {
                                    break;
                                } else if (eVar.a.get(i8).equals(a)) {
                                    eVar.j = i8;
                                    arrayList3.add(a);
                                    break;
                                } else {
                                    i8++;
                                }
                            }
                            if (v7.getPostId() != 0 && (T0 = this.a.I0.T0()) != null) {
                                ArrayList<ym> v = T0.v();
                                if (ListUtils.getCount(v) > 0) {
                                    Iterator<ym> it = v.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        ym next = it.next();
                                        if ((next instanceof rba) && v7.getPostId() == JavaTypesHelper.toLong(((rba) next).S(), 0L)) {
                                            int i9 = 8;
                                            if (v7.getPostId() == JavaTypesHelper.toLong(this.a.A0.Q0(), 0L)) {
                                                i9 = 1;
                                            }
                                            rl9.b(this.a.A0.s1(), (rba) next, ((rba) next).e0, i9, 3);
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!ListUtils.isEmpty(arrayList3)) {
                                String str3 = arrayList3.get(0);
                                concurrentHashMap3.put(str3, eVar.b.get(str3));
                            }
                            Rect rect2 = new Rect();
                            view2.getGlobalVisibleRect(rect2);
                            this.a.s5(rect2);
                            ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                            builder3.setData(arrayList3).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.i).setIsReserve(this.a.A0.E1()).setAssistUrls(concurrentHashMap3).setNeedBroadCaset(false).setIsSeeHost(this.a.e6()).setPostId(eVar.f).setBjhPostId(eVar.f).setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.A0 != null) {
                                builder3.setFromForumId(this.a.A0.getFromForumId());
                                if (this.a.A0.s1() != null) {
                                    builder3.setThreadData(this.a.A0.s1().O());
                                }
                            }
                            ImageViewerConfig bulid3 = builder3.bulid(this.a.getPageContext().getPageActivity());
                            bulid3.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, bulid3));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                new BdTopToast(this.a.getContext()).setIcon(false).setContent(this.a.getString(R.string.novel_thread_mask_click_tip)).show((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public r0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r1(PbFragment pbFragment, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.a.I0 != null) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.I0.E1());
                    this.a.hideProgressBar();
                }
                if (httpResponsedMessage == null || !(httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    return;
                }
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                if (!TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                    return;
                }
                int type = privacySettingMessage.getType();
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    new BdTopToast(this.a.getContext()).setIcon(true).setContent(this.a.getString(R.string.block_user_success)).show((ViewGroup) this.a.getView());
                    this.a.R6(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e21);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                new BdTopToast(this.a.getContext()).setIcon(false).setContent(errorString).show((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r2 implements mj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public r2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.mj5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                fi9 fi9Var = this.a.M0;
                if (fi9Var != null && fi9Var.g() != null && this.a.M0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.M0.g().c());
                    if (this.a.I0 != null && this.a.I0.w1() != null && this.a.I0.w1().f() != null && this.a.I0.w1().f().z()) {
                        this.a.I0.w1().f().w(this.a.M0.h());
                    }
                    this.a.M0.b(true);
                    return true;
                }
                return !this.a.f5(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s implements TiePlusEventController.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public s(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.g
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.u = true;
        }
    }

    /* loaded from: classes7.dex */
    public class s0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.i1) {
                this.a.I0.K1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                td9 s1 = this.a.A0.s1();
                if (s1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    s1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.h1.d(this.a.g1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.g1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.h7(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (bi.isEmpty(errorString2)) {
                        errorString2 = this.a.g1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.h1.c(errorString2);
                } else {
                    this.a.a7();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s1 implements bw4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public s1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.bw4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.I0.L3();
                if (z) {
                    if (this.a.C0 != null) {
                        this.a.C0.h(z2);
                    }
                    this.a.A0.i3(z2);
                    if (!this.a.A0.d1()) {
                        this.a.I0.d2(this.a.A0.s1());
                    } else {
                        this.a.l6();
                    }
                    if (z2) {
                        boolean p0 = this.a.A0.s1().p0();
                        if (this.a.C0 != null && !p0) {
                            if (this.a.C0.f() != null && this.a.A0 != null && this.a.A0.s1() != null && this.a.A0.s1().O() != null && this.a.A0.s1().O().getAuthor() != null) {
                                MarkData f = this.a.C0.f();
                                MetaData author = this.a.A0.s1().O().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00ff);
                                        this.a.e7();
                                    } else {
                                        this.a.Z6(author);
                                    }
                                } else {
                                    PbFragment pbFragment = this.a;
                                    pbFragment.showToast(pbFragment.getPageContext().getString(R.string.add_mark));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.X4();
                        return;
                    }
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.showToast(pbFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                PbFragment pbFragment3 = this.a;
                pbFragment3.showToast(pbFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s2 implements n45.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public s2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.n45.c
        public void a(n45 n45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n45Var, i, view2) == null) {
                if (n45Var != null) {
                    n45Var.e();
                }
                PbFragment pbFragment = this.a;
                rba rbaVar = pbFragment.D2;
                if (rbaVar != null) {
                    if (i == 0) {
                        rbaVar.P0();
                        this.a.D2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.p6(pbFragment2.D2);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921658) {
                int error = customResponsedMessage.getError();
                if (!(customResponsedMessage.getData() instanceof Boolean)) {
                    return;
                }
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (error != 0 || !booleanValue || !TbadkCoreApplication.isLogin() || this.a.C0 == null || this.a.C0.e()) {
                    return;
                }
                this.a.n6();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.i1) {
                this.a.I0.K1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.h1.d(this.a.g1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (bi.isEmpty(muteMessage)) {
                    muteMessage = this.a.g1.getResources().getString(R.string.un_mute_fail);
                }
                this.a.h1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t1 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public t1(PbFragment pbFragment, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFragment;
            this.a = metaData;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t2 implements n45.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public t2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.n45.c
        public void a(n45 n45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n45Var, i, view2) == null) {
                if (n45Var != null) {
                    n45Var.e();
                }
                if (this.a.l1 != null && !TextUtils.isEmpty(this.a.m1)) {
                    if (i == 0) {
                        if (this.a.o1 != null) {
                            rl5.a aVar = new rl5.a();
                            aVar.a = this.a.m1;
                            String str = "";
                            if (this.a.o1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.o1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        } else {
                            this.a.Y4();
                        }
                    } else if (i == 1) {
                        if (this.a.Y0 == null) {
                            this.a.Y0 = new PermissionJudgePolicy();
                        }
                        this.a.Y0.clearRequestPermissionList();
                        this.a.Y0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.Y0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.k1 == null) {
                            PbFragment pbFragment = this.a;
                            pbFragment.k1 = new hi9(pbFragment.getPageContext());
                        }
                        this.a.k1.b(this.a.m1, this.a.l1.getImageByte());
                    }
                    this.a.l1 = null;
                    this.a.m1 = null;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public u(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.x);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!this.a.c6() || this.a.a == null || this.a.a.J1() == null || !str.equals(this.a.a.J1().getTopicId())) {
                    return;
                }
                this.a.q7(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u1 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public u1(PbFragment pbFragment, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFragment;
            this.a = metaData;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                m45Var.dismiss();
                this.b.E0.i(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.A0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u2 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public u2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.A0 == null || this.a.A0.C1() == i + 1) {
                return;
            }
            this.a.L6(bi9.p(i));
        }
    }

    /* loaded from: classes7.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d25)) {
                d25 d25Var = (d25) customResponsedMessage.getData();
                v25.a aVar = new v25.a();
                int i = d25Var.a;
                String str = d25Var.b;
                aVar.a = d25Var.d;
                td9 s1 = this.a.A0.s1();
                if (s1 == null) {
                    return;
                }
                if (this.a.A0.U0() != null && this.a.A0.U0().getUserIdLong() == d25Var.p) {
                    this.a.I0.c3(d25Var.l, this.a.A0.s1(), this.a.A0.L1(), this.a.A0.D1());
                }
                if (s1.F() != null && s1.F().size() >= 1 && s1.F().get(0) != null) {
                    long j = JavaTypesHelper.toLong(s1.F().get(0).S(), 0L);
                    long j2 = JavaTypesHelper.toLong(this.a.A0.M1(), 0L);
                    if (j == d25Var.n && j2 == d25Var.m) {
                        v25 Q = s1.F().get(0).Q();
                        if (Q == null) {
                            Q = new v25();
                        }
                        ArrayList<v25.a> a = Q.a();
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        a.add(0, aVar);
                        Q.e(Q.b() + d25Var.l);
                        Q.d(a);
                        s1.F().get(0).W0(Q);
                        this.a.I0.T0().f0();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof eka) && customResponsedMessage.getOrginalMessage().getTag() == this.a.i1) {
                eka ekaVar = (eka) customResponsedMessage.getData();
                this.a.I0.K1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.f1;
                DataRes dataRes = ekaVar.a;
                boolean z = false;
                if (ekaVar.c == 0 && dataRes != null) {
                    int i = JavaTypesHelper.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (i == 1) {
                        z = true;
                    }
                    if (bi.isEmpty(str)) {
                        sparseArray.put(R.id.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.tag_user_mute_msg, str);
                    }
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.tag_from)).intValue();
                if (intValue != 0) {
                    if (intValue == 1) {
                        this.a.I0.R2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.b7(z, sparseArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v1 implements nj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public v1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.nj5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v2 implements w45.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public v2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.w45.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.O0 != null) {
                this.a.O0.r(zj9.g(this.a.D2));
                ArrayList arrayList = new ArrayList();
                for (v45 v45Var : this.a.O0.g()) {
                    if (v45Var instanceof s45) {
                        arrayList.add((s45) v45Var);
                    }
                }
                zj9.e(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof w16)) {
                w16 w16Var = (w16) customResponsedMessage.getData();
                td9 s1 = this.a.A0.s1();
                if (s1 == null) {
                    return;
                }
                if (this.a.A0.s1() != null && this.a.A0.s1().X().r() != null && this.a.A0.s1().X().r().getPortrait() != null && this.a.A0.s1().X().r().getPortrait().equals(w16Var.a)) {
                    if (this.a.A0.s1().X().r().getUserWorldCupData() != null) {
                        this.a.A0.s1().X().r().getUserWorldCupData().d(w16Var.b);
                    }
                    this.a.I0.d3(this.a.A0.s1(), this.a.A0.L1(), this.a.A0.D1(), this.a.I0.A1());
                }
                if (s1.F() != null && s1.F().size() >= 0) {
                    Iterator<rba> it = s1.F().iterator();
                    while (it.hasNext()) {
                        rba next = it.next();
                        if (next != null && next.r() != null && next.r().getPortrait() != null && next.r().getPortrait().equals(w16Var.a) && next.r().getUserWorldCupData() != null) {
                            next.r().getUserWorldCupData().d(w16Var.b);
                        }
                    }
                    this.a.I0.T0().f0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.I0.e2() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.p5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    /* loaded from: classes7.dex */
    public class w1 implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public w1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<rba> F;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.A0 != null && this.a.A0.s1() != null && this.a.I0 != null && this.a.I0.T0() != null) {
                this.a.I0.K2(absListView, i, i2, i3);
                if (this.a.e != null) {
                    this.a.e.q(absListView, i, i2, i3);
                }
                if (this.a.A0.h2() && (F = this.a.A0.s1().F()) != null && !F.isEmpty()) {
                    int y = ((i + i2) - this.a.I0.T0().y()) - 1;
                    td9 s1 = this.a.A0.s1();
                    if (s1 == null) {
                        return;
                    }
                    if (s1.C() != null && s1.C().z1()) {
                        y--;
                    }
                    if (s1.D() != null && s1.D().z1()) {
                        y--;
                    }
                    int size = F.size();
                    if (y < 0 || y >= size) {
                    }
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                if (!bi9.B(this.a.e1) && bi9.B(i)) {
                    if (this.a.I0 != null) {
                        this.a.r0 = true;
                        this.a.I0.F0();
                        if (this.a.X0 != null && !this.a.I0.e2()) {
                            this.a.I0.r3(this.a.X0.z());
                        }
                        if (!this.a.J) {
                            this.a.r0 = true;
                            this.a.I0.j3();
                        }
                    }
                    if (!this.a.r) {
                        this.a.r = true;
                    }
                }
                if (this.a.I0 != null) {
                    this.a.I0.L2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.s == null) {
                    this.a.s = new or5();
                    this.a.s.a(1001);
                }
                if (i == 0) {
                    this.a.s.e();
                    if (this.a.h0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.a.h0);
                        this.a.h0 = null;
                    }
                } else {
                    if (this.a.h0 == null) {
                        this.a.h0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("pb", "1", "scroll");
                    }
                    this.a.s.d();
                }
                this.a.e1 = i;
                if (i == 0) {
                    u9a.g().h(this.a.getUniqueId(), true);
                    this.a.a5(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w2 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public w2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                PbFragment pbFragment = this.a;
                pbFragment.b = true;
                return pbFragment.i5(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.A0 != null && this.a.A0.s1() != null) {
                this.a.A0.s1().a();
                this.a.A0.X1();
                if (this.a.I0.T0() != null) {
                    this.a.I0.d2(this.a.A0.s1());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeMessageData agreeMessageData;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof AgreeMessageData) && (agreeMessageData = (AgreeMessageData) customResponsedMessage.getData()) != null && (agreeData = agreeMessageData.agreeData) != null) {
                if (this.a.I0 != null) {
                    this.a.I0.x2(agreeMessageData);
                }
                if (agreeData.agreeType == 2 && this.a.I0 != null && !gk9.h(this.a.A0.b)) {
                    this.a.I0.x4();
                    gk9.b(this.a.A0.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x1 implements Comparator<AdverSegmentData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public x1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(AdverSegmentData adverSegmentData, AdverSegmentData adverSegmentData2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, adverSegmentData, adverSegmentData2)) == null) {
                return adverSegmentData.compareTo(adverSegmentData2);
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class x2 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public x2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ItemCardHelper.l(this.a.getContext(), this.a.getUniqueId(), view2, (ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            qba i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.A0 != null && this.a.A0.s1() != null) {
                String str = (String) customResponsedMessage.getData();
                qba qbaVar = null;
                if (!TextUtils.isEmpty(str) && this.a.A0.s1().F() != null) {
                    ArrayList<rba> F = this.a.A0.s1().F();
                    Iterator<rba> it = F.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        rba next = it.next();
                        if (next instanceof qba) {
                            qba qbaVar2 = (qba) next;
                            if (str.equals(qbaVar2.A1())) {
                                qbaVar = qbaVar2;
                                break;
                            }
                        }
                    }
                    if (qbaVar != null) {
                        F.remove(qbaVar);
                    }
                }
                if (this.a.I0.T0() != null && !ListUtils.isEmpty(this.a.I0.T0().v())) {
                    ArrayList<ym> v = this.a.I0.T0().v();
                    if (qbaVar != null) {
                        i = qbaVar;
                    } else {
                        i = bi9.i(this.a.A0.s1(), str);
                    }
                    bi9.e(v, i);
                }
                if (this.a.I0.m1() != null && !ListUtils.isEmpty(this.a.I0.m1().getData())) {
                    List<ym> data = this.a.I0.m1().getData();
                    if (qbaVar == null) {
                        qbaVar = bi9.i(this.a.A0.s1(), str);
                    }
                    bi9.e(data, qbaVar);
                }
                this.a.k5(str);
                this.a.A0.X1();
                if (this.a.I0.T0() != null) {
                    this.a.I0.T0().f0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y0(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.M5() != null) {
                this.a.M5().H2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public y1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y2 implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public y2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.y(this.a.getContext(), ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.a.getView(), 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.y(this.a.getContext(), ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.a.getView(), j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(PbFragment pbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.l5();
        }
    }

    /* loaded from: classes7.dex */
    public static class z0 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z1 extends h9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public z1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.h9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, obj) != null) || !this.a.isAdded()) {
                return;
            }
            boolean z = false;
            if (obj != null) {
                switch (this.a.D0.getLoadDataMode()) {
                    case 0:
                        this.a.A0.X1();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.q5(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.I0.O0(1, dVar.a, dVar.b, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbFragment pbFragment = this.a;
                        pbFragment.r5(pbFragment.D0.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        this.a.I0.O0(this.a.D0.getLoadDataMode(), gVar.a, gVar.b, false);
                        this.a.I0.M2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.I0.O0(this.a.D0.getLoadDataMode(), false, null, false);
        }
    }

    /* loaded from: classes7.dex */
    public class z2 implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public z2(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void k(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.f && z && !this.a.A0.h1()) {
                    this.a.F6();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1073013551, "Lcom/baidu/tieba/pb/pb/main/PbFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1073013551, "Lcom/baidu/tieba/pb/pb/main/PbFragment;");
                return;
            }
        }
        T2 = new z0();
        U2 = new b();
    }

    public static PbFragment r6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65682, null)) == null) {
            return new PbFragment();
        }
        return (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s06
    public ag<LinearLayout> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.D == null) {
                this.D = new ag<>(new a3(this), 15, 0);
            }
            return this.D;
        }
        return (ag) invokeV.objValue;
    }

    public boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbModel pbModel = this.A0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.l2();
        }
        return invokeV.booleanValue;
    }

    public boolean A6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            kf5 kf5Var = this.j0;
            if (kf5Var != null && kf5Var.t()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public PbInterviewStatusView.f B5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.x0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    public boolean C5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!this.c && this.O2 == -1 && this.P2 == -1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s06
    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ci9 ci9Var = this.I0;
            if (ci9Var == null) {
                return 0;
            }
            return ci9Var.z1();
        }
        return invokeV.intValue;
    }

    public boolean D5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.n2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean E5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s06
    /* renamed from: F5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ci9 ci9Var = this.I0;
            if (ci9Var == null) {
                return null;
            }
            return ci9Var.m1();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public final void F6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            hideNetRefreshView(this.I0.E1());
            c7();
            if (this.A0.t2()) {
                this.I0.M3();
            }
            this.I0.V3();
        }
    }

    public int G5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.P2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.s06
    public ag<TiebaPlusRecommendCard> H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.C == null) {
                this.C = new ag<>(new m2(this), 5, 0);
            }
            return this.C;
        }
        return (ag) invokeV.objValue;
    }

    public int H5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.O2;
        }
        return invokeV.intValue;
    }

    public void H6() {
        kf5 kf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (kf5Var = this.j0) != null) {
            kf5Var.x();
        }
    }

    public boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.s0;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public final td9 I5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            PbModel pbModel = this.A0;
            if (pbModel != null) {
                return pbModel.s1();
            }
            return null;
        }
        return (td9) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ag<TbImageView> J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.z == null) {
                this.z = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.z;
        }
        return (ag) invokeV.objValue;
    }

    public ij9 J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.a.J0();
        }
        return (ij9) invokeV.objValue;
    }

    public qj5 J5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.X0;
        }
        return (qj5) invokeV.objValue;
    }

    public jj9 K5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.e;
        }
        return (jj9) invokeV.objValue;
    }

    public xj9 L5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.u0;
        }
        return (xj9) invokeV.objValue;
    }

    public ci9 M5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.I0;
        }
        return (ci9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vl9
    public PbModel.h N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.q2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public String O5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.V;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vl9
    public PbModel R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.A0;
        }
        return (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s06
    public ag<RelativeLayout> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            ag<RelativeLayout> agVar = new ag<>(new o2(this), 10, 0);
            this.E = agVar;
            return agVar;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s06
    public ag<FestivalTipView> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            if (this.H == null) {
                this.H = TbRichTextView.G(getContext(), R.dimen.M_H_X004);
            }
            return this.H;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s06
    public ag<ImageView> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            if (this.A == null) {
                this.A = new ag<>(new k2(this), 8, 0);
            }
            return this.A;
        }
        return (ag) invokeV.objValue;
    }

    public void W5() {
        ci9 ci9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048639, this) == null) && (ci9Var = this.I0) != null) {
            ci9Var.I1();
            V5();
        }
    }

    @Override // com.baidu.tieba.s06
    public ag<View> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            if (this.B == null) {
                this.B = new ag<>(new n2(this), 8, 0);
            }
            return this.B;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vl9
    public AbsPbActivity Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public final void Y5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.Q = likeModel;
            likeModel.setLoadDataCallBack(new m0(this));
        }
    }

    public final void Z5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            fk9 fk9Var = new fk9(getPageContext());
            fk9Var.m();
            this.a1 = fk9Var;
        }
    }

    @Override // com.baidu.tieba.s06
    public ag<TextView> a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            if (this.y == null) {
                this.y = TbRichTextView.H(getContext(), 8);
            }
            return this.y;
        }
        return (ag) invokeV.objValue;
    }

    public boolean b6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            PbModel pbModel = this.A0;
            if (pbModel != null) {
                return pbModel.X0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean c6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null && absPbActivity.J1() != null && this.a.J1().r1() == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean e6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            PbModel pbModel = this.A0;
            if (pbModel != null) {
                return pbModel.V0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            td9 s12 = this.A0.s1();
            this.A0.i3(true);
            bw4 bw4Var = this.C0;
            if (bw4Var != null) {
                s12.K0(bw4Var.g());
            }
            this.I0.d2(s12);
        }
    }

    public void m6() {
        ci9 ci9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048699, this) != null) || (ci9Var = this.I0) == null) {
            return;
        }
        ci9Var.u2();
    }

    public final void m7() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048700, this) == null) && (voiceManager = this.i) != null) {
            voiceManager.stopPlay();
        }
    }

    public final void n7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048703, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.U1();
        }
    }

    @Override // com.baidu.tieba.s06
    public ag<ItemCardView> o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            if (this.F == null) {
                this.F = new ag<>(new p2(this), 10, 0);
            }
            return this.F;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.d0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public cn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (cn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            F6();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    public AntiData t5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) {
            PbModel pbModel = this.A0;
            if (pbModel != null && pbModel.s1() != null) {
                return this.A0.s1().c();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048744, this) == null) && (pbModel = this.A0) != null && !bi.isEmpty(pbModel.M1())) {
            super.taskStart();
        }
    }

    public rba v5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            td9 td9Var = this.A0.G;
            if (td9Var != null) {
                return td9Var.X();
            }
            return null;
        }
        return (rba) invokeV.objValue;
    }

    public void v6() {
        kf5 kf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048749, this) == null) && (kf5Var = this.j0) != null) {
            kf5Var.q();
        }
    }

    public int w5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            return this.S2;
        }
        return invokeV.intValue;
    }

    public String x5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) {
            return this.M;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s06
    public ag<GifView> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            if (this.L == null) {
                this.L = new ag<>(new l2(this), 20, 0);
            }
            return this.L;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
            return this.i;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public PbFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = true;
        this.c = false;
        this.f = false;
        this.g = false;
        this.j = 0;
        this.k = null;
        this.l = -1L;
        this.m = 0L;
        this.n = 0L;
        this.o = 0L;
        this.p = 0L;
        this.r = false;
        this.s = null;
        this.t = 0L;
        this.u = false;
        this.v = 0L;
        this.w = 1;
        this.x = null;
        this.I = false;
        this.J = false;
        this.K = false;
        this.M = "";
        this.N = true;
        this.O = false;
        this.P = "";
        this.W = 3;
        this.Y = new int[2];
        this.a0 = -1;
        this.b0 = -1;
        this.d0 = BdUniqueId.gen();
        this.f0 = false;
        this.t0 = new s(this);
        this.w0 = false;
        this.x0 = new d0(this);
        this.y0 = new Handler(new o0(this));
        this.z0 = new k1(this);
        this.A0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.F0 = null;
        this.G0 = null;
        this.H0 = null;
        this.I0 = null;
        this.J0 = false;
        this.K0 = false;
        this.L0 = false;
        this.Q0 = false;
        this.S0 = false;
        this.U0 = false;
        this.a1 = null;
        this.b1 = new v1(this);
        this.c1 = new g2(this);
        this.d1 = new r2(this);
        this.e1 = 0;
        this.p1 = false;
        this.q1 = 0;
        this.r1 = -1;
        this.t1 = 0;
        this.v1 = new c3(this);
        this.w1 = new i(this);
        this.x1 = new j(this, 2004016);
        this.y1 = new k(this, 2016485);
        this.z1 = new l(this, 2001269);
        this.A1 = new m(this, 2004008);
        this.B1 = new n(this, 2004007);
        this.C1 = new o(this, 2004005);
        this.D1 = new p(this, 2001332);
        this.E1 = new q(this, 2921391);
        this.F1 = new r(this, 2921606);
        this.G1 = new t(this, 2921658);
        this.H1 = new u(this);
        this.I1 = new v(this, 2001369);
        this.J1 = new w(this, 2921787);
        this.K1 = new x(this, 2016488);
        this.L1 = new y(this, 2016331);
        this.M1 = new z(this, 2921746);
        this.N1 = new a0(this);
        this.O1 = new b0(this, 2010045);
        this.P1 = new c0(this);
        this.Q1 = new PraiseModel(getPageContext(), new e0(this));
        this.R1 = new f0(this);
        this.S1 = new h0(this, 2001115);
        this.T1 = new i0(this);
        this.U1 = new j0(this);
        this.W1 = new af9(new p0(this));
        this.X1 = new r0(this);
        this.Y1 = new s0(this, 2001427);
        this.Z1 = new t0(this, 2001428);
        this.a2 = new u0(this, 2921634);
        this.b2 = new v0(this, 2001426);
        this.c2 = new w0(this, 2004021);
        this.d2 = new x0(this, 2016528);
        this.e2 = new y0(this, 2921724);
        this.f2 = new a1(this, 2921033);
        this.g2 = new b1(this);
        this.h2 = new c1(this);
        this.i2 = new d1(this);
        this.j2 = new g1(this);
        this.k2 = new j1(this);
        this.l2 = new l1(this, 2921480);
        this.m2 = new m1(this);
        this.n2 = Boolean.FALSE;
        this.o2 = new n1(this);
        this.p2 = new o1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.q2 = new p1(this);
        this.r2 = new q1(this, 2016450);
        this.s2 = new r1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.t2 = new s1(this);
        this.u2 = new w1(this);
        this.v2 = new z1(this);
        this.w2 = new b2(this);
        this.x2 = new c2(this);
        this.z2 = new d2(this);
        this.A2 = 0;
        this.B2 = new q2(this);
        this.C2 = false;
        this.D2 = null;
        this.E2 = new s2(this);
        this.F2 = new t2(this);
        this.G2 = new u2(this);
        this.H2 = new w2(this);
        this.I2 = new x2(this);
        this.J2 = new y2(this);
        this.K2 = new z2(this);
        this.L2 = new b3(this);
        this.M2 = new a(this);
        this.N2 = new c(this);
        this.O2 = -1;
        this.P2 = -1;
        this.S2 = 0;
    }

    @Override // com.baidu.tieba.vl9
    public void finish() {
        ci9 ci9Var;
        boolean z3;
        CardHListViewData p3;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            ci9 ci9Var2 = this.I0;
            if (ci9Var2 != null) {
                ci9Var2.F0();
            }
            PbModel pbModel = this.A0;
            if (pbModel != null && pbModel.s1() != null && !this.A0.s1().j0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.A0.s1().O().getId();
                if (this.A0.isShareThread() && this.A0.s1().O().originalThreadData != null) {
                    historyMessage.threadName = this.A0.s1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.A0.s1().O().getTitle();
                }
                if (this.A0.isShareThread() && !A0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.A0.s1().k().getName();
                }
                ArrayList<rba> F = this.A0.s1().F();
                ci9 ci9Var3 = this.I0;
                if (ci9Var3 != null) {
                    i3 = ci9Var3.d1();
                } else {
                    i3 = 0;
                }
                if (F != null && i3 >= 0 && i3 < F.size()) {
                    historyMessage.postID = F.get(i3).S();
                }
                historyMessage.isHostOnly = this.A0.V0();
                historyMessage.isSquence = this.A0.L1();
                historyMessage.isShareThread = this.A0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            PbModel pbModel2 = this.A0;
            if (pbModel2 != null && (pbModel2.X0() || this.A0.a1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.A0.M1());
                if (this.J0) {
                    if (this.L0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.A0.g1());
                    }
                    if (this.K0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.A0.c1());
                    }
                }
                if (this.A0.a1() && this.A0.s1() != null && this.A0.s1().O() != null) {
                    sr6.b().b(new dk5(this.A0.Q()));
                }
                if (this.A0.s1() != null && System.currentTimeMillis() - this.n >= 40000 && (p3 = this.A0.s1().p()) != null && !ListUtils.isEmpty(p3.getDataList())) {
                    intent.putExtra("guess_like_data", p3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.r1);
                }
                this.a.setResult(-1, intent);
            }
            if (o7()) {
                if (this.A0 != null && (ci9Var = this.I0) != null && ci9Var.m1() != null) {
                    td9 s12 = this.A0.s1();
                    if (s12 != null) {
                        if (s12.V() != null) {
                            s12.V().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            s12.V().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!s12.s0() && !this.I && s12.h == null) {
                            th9 b4 = th9.b();
                            td9 t12 = this.A0.t1();
                            Parcelable onSaveInstanceState = this.I0.m1().onSaveInstanceState();
                            boolean L1 = this.A0.L1();
                            boolean V0 = this.A0.V0();
                            if (this.I0.u1() != null && this.I0.u1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.l(t12, onSaveInstanceState, L1, V0, z3);
                            if (this.q1 >= 0 || this.A0.O1() != null) {
                                th9.b().o(this.A0.O1());
                                th9.b().p(this.A0.P1());
                                th9.b().m(this.A0.l1());
                            }
                        }
                    }
                } else {
                    th9.b().k();
                }
                n7();
            }
            fk9 fk9Var = this.a1;
            if (fk9Var != null && !fk9Var.o() && d5() && this.A0.a1() && !TextUtils.isEmpty(this.A0.Q())) {
                this.a1.n(this.A0.s1().g().l, this.A0.Q());
            }
        }
    }

    @Override // com.baidu.tieba.s06
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.u = true;
        }
    }

    @Override // com.baidu.tieba.s06
    public void K(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) {
            ii9.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.u = true;
        }
    }

    @Override // com.baidu.tieba.s06
    public void i0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048683, this, context, str) == null) {
            this.u = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        ci9 ci9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048719, this, i3, keyEvent)) == null) {
            if (keyEvent != null && (ci9Var = this.I0) != null) {
                return ci9Var.C2(i3);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void G6(d3 d3Var) {
        List<d3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, d3Var) == null) && d3Var != null && (list = this.s1) != null) {
            list.remove(d3Var);
        }
    }

    public final void L6(int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048610, this, i3) == null) && this.A0 != null) {
            c7();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
            privacySettingMessage.setTid(this.A0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void M6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i3) == null) {
            this.S2 = i3;
        }
    }

    public void N6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z3) == null) {
            this.n2 = Boolean.valueOf(z3);
        }
    }

    public void O6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z3) == null) {
            this.s0 = z3;
        }
    }

    public void P6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z3) == null) {
            this.N = z3;
        }
    }

    public void S6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z3) == null) {
            this.K = z3;
        }
    }

    public final void T6(boolean z3) {
        qj5 qj5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048630, this, z3) != null) || (qj5Var = this.X0) == null) {
            return;
        }
        qj5Var.Y(z3);
        this.X0.b0(z3);
        this.X0.j0(z3);
    }

    public final void U5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, intent) == null) {
            gk9.g(this, intent);
        }
    }

    public void V4(d3 d3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, d3Var) == null) && d3Var != null) {
            if (this.s1 == null) {
                this.s1 = new ArrayList();
            }
            if (!this.s1.contains(d3Var)) {
                this.s1.add(d3Var);
            }
        }
    }

    public void W4(d3 d3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048638, this, d3Var) == null) && d3Var != null) {
            if (this.s1 == null) {
                this.s1 = new ArrayList();
            }
            if (!this.s1.contains(d3Var)) {
                this.s1.add(0, d3Var);
            }
        }
    }

    public final void g6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            BrowserHelper.startWebActivity(getContext(), "", str, false, true, true, bundle);
        }
    }

    public final void g7(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048678, this, i3) == null) {
            gk9.j(this, u5(), i3);
        }
    }

    @Override // com.baidu.tieba.em9.b
    public void m1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048697, this, z3) == null) {
            this.R0 = z3;
        }
    }

    public final void o6(View view2) {
        SparseArray sparseArray;
        rba rbaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (rbaVar = (rba) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            p6(rbaVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tieba.m45.e
    public void onClick(m45 m45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, m45Var) == null) {
            n5(m45Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.k9
    public void onPreLoad(cn cnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, cnVar) == null) {
            PreLoadImageHelper.load(cnVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(cnVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.A0.O2(bundle);
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            qj5 qj5Var = this.X0;
            if (qj5Var != null) {
                qj5Var.G(bundle);
            }
        }
    }

    public final void t7(m15 m15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048742, this, m15Var) == null) && m15Var != null) {
            this.R2 = m15Var;
            this.c = true;
            this.I0.h3();
            this.I0.A3(this.Q2);
        }
    }

    public final int A5(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z3;
        TbRichTextImageInfo V;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i3), Integer.valueOf(i4), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.C2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.P().size();
                int i6 = i3;
                int i7 = -1;
                for (int i8 = 0; i8 < size; i8++) {
                    TbRichTextData tbRichTextData = tbRichText.P().get(i8);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i7++;
                        int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.V().getWidth() * equipmentDensity;
                        int height = tbRichTextData.V().getHeight() * equipmentDensity;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3 && tbRichTextData.V().T()) {
                            if (tbRichTextData.getType() != 20) {
                                String a4 = ud9.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a4)) {
                                    arrayList.add(a4);
                                    if (tbRichTextData != null && (V = tbRichTextData.V()) != null) {
                                        String O = V.O();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            O = V.P();
                                        } else {
                                            if (this.q) {
                                                i5 = 17;
                                            } else {
                                                i5 = 18;
                                            }
                                            imageUrlData.urlType = i5;
                                        }
                                        imageUrlData.imageUrl = O;
                                        imageUrlData.imageThumbUrl = O;
                                        imageUrlData.urlThumbType = imageUrlData.urlType;
                                        imageUrlData.originalUrl = bi9.n(tbRichTextData);
                                        imageUrlData.originalSize = bi9.o(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = bi9.k(tbRichTextData);
                                        imageUrlData.isLongPic = bi9.j(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = JavaTypesHelper.toLong(this.A0.M1(), -1L);
                                        imageUrlData.mIsReserver = this.A0.E1();
                                        imageUrlData.mIsSeeHost = this.A0.V0();
                                        if (concurrentHashMap != null) {
                                            concurrentHashMap.put(a4, imageUrlData);
                                        }
                                    }
                                }
                                if (!this.C2) {
                                    i6++;
                                }
                            }
                        } else if (tbRichText == tbRichText2) {
                            if (i7 <= i4) {
                                i6--;
                            }
                        }
                    }
                }
                return i6;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public final void B6(View view2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, view2) != null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        if (this.b) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(i3));
        view2.setTag(sparseArray);
    }

    public final void Q5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 4).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public final void h7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, str) == null) {
            if (str == null) {
                str = "";
            }
            BdPageContext bdPageContext = this.g1;
            if (bdPageContext == null) {
                return;
            }
            m45 m45Var = new m45(bdPageContext.getPageActivity());
            m45Var.setMessage(str);
            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b3e, new f(this));
            m45Var.create(this.g1).show();
        }
    }

    public final void k7(SparseArray<Object> sparseArray) {
        rba rbaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048693, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof rba) || (rbaVar = (rba) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        l7(rbaVar, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048728, this, z3) == null) {
            super.onUserChanged(z3);
            this.I0.L4(z3);
            u45 u45Var = this.N0;
            if (u45Var != null) {
                u45Var.dismiss();
            }
            if (z3 && this.R0) {
                this.I0.N3();
                this.A0.p2(true);
            }
            if (this.I0.T0() != null) {
                this.I0.T0().j0(z3);
            }
        }
    }

    public final void r7(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048736, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.A0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(zj9.m(i3))));
        }
    }

    public final void s5(Rect rect) {
        ci9 ci9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048737, this, rect) == null) && rect != null && (ci9Var = this.I0) != null && ci9Var.D1() != null && rect.top <= this.I0.D1().getHeight()) {
            rect.top += this.I0.D1().getHeight() - rect.top;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void C0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048583, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (p06[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), p06.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (ii9.c(objArr[i3].g()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new VCenterTextSpan(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.s06
    public void a0(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048653, this, context, str, z3) == null) {
            if (ii9.c(str) && (pbModel = this.A0) != null && pbModel.M1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.A0.M1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    wg5 wg5Var = new wg5();
                    wg5Var.a = str;
                    wg5Var.b = 3;
                    wg5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, wg5Var));
                }
            } else {
                ii9.a().e(getPageContext(), str);
            }
            this.u = true;
        }
    }

    public void C6(ke9 ke9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ke9Var) == null) {
            String S = ke9Var.g().S();
            List<rba> list = this.A0.s1().T().a;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                rba rbaVar = list.get(i3);
                if (rbaVar.S() != null && rbaVar.S().equals(S)) {
                    ArrayList<rba> i4 = ke9Var.i();
                    rbaVar.m1(ke9Var.k());
                    if (rbaVar.i0() != null) {
                        rbaVar.i0().clear();
                        rbaVar.i0().addAll(i4);
                    }
                } else {
                    i3++;
                }
            }
            if (!this.A0.b1()) {
                this.I0.d2(this.A0.s1());
            }
        }
    }

    public final void T5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            PbModel pbModel = this.A0;
            if (pbModel != null && pbModel.s1() != null && this.A0.s1().j0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.A0.M1(), str);
                ThreadData O = this.A0.s1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                g6(format);
                return;
            }
            this.B0.a(str);
        }
    }

    public final void Z6(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048652, this, metaData) != null) || metaData == null) {
            return;
        }
        m45 m45Var = new m45(getActivity());
        m45Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0c3f));
        m45Var.setTitleShowCenter(true);
        m45Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0c40));
        m45Var.setMessageShowCenter(true);
        m45Var.setCancelable(false);
        m45Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0c41), new t1(this, metaData));
        m45Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0c42), new u1(this, metaData));
        m45Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void f7(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && R() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                R().A0(postWriteCallBackData.getPostId());
                int Z0 = this.I0.Z0();
                this.q1 = Z0;
                this.A0.R2(Z0, this.I0.g1());
            }
            this.I0.F0();
            this.M0.c();
            qj5 qj5Var = this.X0;
            if (qj5Var != null) {
                this.I0.r3(qj5Var.z());
            }
            this.I0.I1();
            this.I0.c4(true);
            this.A0.X1();
        }
    }

    public final void k5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048691, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.A0) != null && pbModel.s1() != null) {
            qba z3 = this.A0.s1().z();
            if (z3 != null && str.equals(z3.A1())) {
                if (z3.getAdvertAppInfo() != null) {
                    z3.getAdvertAppInfo().h = null;
                }
                this.A0.s1().b();
            }
            qba K0 = this.A0.K0();
            if (K0 != null && str.equals(K0.A1())) {
                this.A0.x0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048711, this, i3) != null) || this.W == i3) {
            return;
        }
        super.onChangeSkinType(i3);
        this.I0.y2(i3);
        qj5 qj5Var = this.X0;
        if (qj5Var != null && qj5Var.b() != null) {
            this.X0.b().z(i3);
        }
        if (this.I0.a() != null) {
            this.I0.a().onChangeSkinType(getPageContext(), i3);
        }
        this.M0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201), true);
        this.W = i3;
        m7();
        kf5 kf5Var = this.j0;
        if (kf5Var != null) {
            kf5Var.w();
        }
    }

    public void p6(rba rbaVar) {
        boolean z3;
        rba v5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048730, this, rbaVar) != null) || rbaVar == null) {
            return;
        }
        if (rbaVar.S() != null && rbaVar.S().equals(this.A0.n1())) {
            z3 = true;
        } else {
            z3 = false;
        }
        MarkData m12 = this.A0.m1(rbaVar);
        if (this.A0.s1() != null && this.A0.s1().j0() && (v5 = v5()) != null) {
            m12 = this.A0.m1(v5);
        }
        if (m12 == null) {
            return;
        }
        this.I0.M3();
        bw4 bw4Var = this.C0;
        if (bw4Var != null) {
            bw4Var.i(m12);
            if (!z3) {
                this.C0.a();
            } else {
                this.C0.d();
            }
        }
    }

    public void D6(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z3, markData) == null) {
            this.I0.L3();
            this.A0.i3(z3);
            bw4 bw4Var = this.C0;
            if (bw4Var != null) {
                bw4Var.h(z3);
                if (markData != null) {
                    this.C0.i(markData);
                }
            }
            if (this.A0.d1()) {
                l6();
            } else {
                this.I0.d2(this.A0.s1());
            }
        }
    }

    public void E6(ke9 ke9Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, ke9Var) != null) || ke9Var.g() == null) {
            return;
        }
        String S = ke9Var.g().S();
        ArrayList<rba> F = this.A0.s1().F();
        int i3 = 0;
        while (true) {
            z3 = true;
            if (i3 >= F.size()) {
                break;
            }
            rba rbaVar = F.get(i3);
            if (rbaVar.S() != null && rbaVar.S().equals(S)) {
                ArrayList<rba> i4 = ke9Var.i();
                rbaVar.m1(ke9Var.k());
                if (rbaVar.i0() != null && i4 != null) {
                    Iterator<rba> it = i4.iterator();
                    while (it.hasNext()) {
                        rba next = it.next();
                        if (rbaVar.r0() != null && next != null && next.r() != null && (metaData = rbaVar.r0().get(next.r().getUserId())) != null) {
                            next.N0(metaData);
                            next.c1(true);
                            next.w1(getPageContext(), this.A0.m2(metaData.getUserId()));
                        }
                    }
                    if (i4.size() == rbaVar.i0().size()) {
                        z3 = false;
                    }
                    if (!rbaVar.y0(false)) {
                        rbaVar.i0().clear();
                        rbaVar.i0().addAll(i4);
                    }
                }
                if (rbaVar.D() != null) {
                    rbaVar.L0();
                }
            } else {
                i3++;
            }
        }
        if (!this.A0.b1() && z3) {
            this.I0.d2(this.A0.s1());
        }
        if (z3) {
            C6(ke9Var);
        }
    }

    public void a5(boolean z3) {
        ci9 ci9Var;
        int i3;
        int y3;
        rba rbaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048655, this, z3) == null) && (ci9Var = this.I0) != null && ci9Var.m1() != null) {
            int firstVisiblePosition = this.I0.m1().getFirstVisiblePosition();
            int lastVisiblePosition = this.I0.m1().getLastVisiblePosition();
            lg9 T0 = this.I0.T0();
            if (T0 != null && this.A0.s1() != null) {
                if (lastVisiblePosition <= T0.y()) {
                    i3 = 0;
                    y3 = 1;
                } else {
                    if (firstVisiblePosition > T0.y()) {
                        i3 = firstVisiblePosition - T0.y();
                    } else {
                        i3 = 0;
                    }
                    y3 = (lastVisiblePosition - T0.y()) + 1;
                }
                ArrayList arrayList = new ArrayList();
                if (y3 > i3) {
                    while (i3 < y3) {
                        if (this.I0.m1().G(i3) != null && (this.I0.m1().G(i3) instanceof rba) && (rbaVar = (rba) this.I0.m1().G(i3)) != null) {
                            rba rbaVar2 = (rba) ListUtils.getItem(this.A0.s1().F(), rbaVar.I() - 1);
                            if (rbaVar.n() == null && rbaVar2 != null) {
                                rbaVar.M0(rbaVar2.n());
                            }
                            if (rbaVar.n() != null) {
                                rbaVar.n().setFloonumber(rbaVar.I());
                                arrayList.add(rbaVar.n());
                            }
                        }
                        i3++;
                    }
                }
                if (ListUtils.getItem(arrayList, 0) != null) {
                    Collections.sort(arrayList, new x1(this));
                    AdverSegmentData adverSegmentData = (AdverSegmentData) ListUtils.getItem(arrayList, 0);
                    if (adverSegmentData != null && adverSegmentData.getFloonumber() == 1) {
                        if (!z3) {
                            this.I0.V2(adverSegmentData, 0);
                            return;
                        }
                        return;
                    }
                    this.I0.V2(adverSegmentData, 1);
                }
            }
        }
    }

    public final boolean q6(rba rbaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048733, this, rbaVar)) == null) {
            if (rbaVar == null) {
                return false;
            }
            String S = rbaVar.S();
            if (StringUtils.isNull(S) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String string = SharedPrefHelper.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = rbaVar.n0().getJumpUrl();
            int packageId = rbaVar.n0().getPackageId();
            int propsId = rbaVar.n0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                BrowserHelper.startWebActivity(getPageContext().getPageActivity(), xca.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
                return true;
            } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            } else {
                BrowserHelper.startWebActivity(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + S, true, true, true);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void u7(int i3) {
        PbModel pbModel;
        ThreadData O;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048747, this, i3) != null) || (pbModel = this.A0) == null || pbModel.s1() == null || (O = this.A0.s1().O()) == null) {
            return;
        }
        if (i3 == 1) {
            PraiseData praise = O.getPraise();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (praise == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i3);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    O.setPraise(praiseData);
                } else {
                    O.getPraise().getUser().add(0, metaData);
                    O.getPraise().setNum(O.getPraise().getNum() + 1);
                    O.getPraise().setIsLike(i3);
                }
            }
        } else if (O.getPraise() != null) {
            O.getPraise().setIsLike(i3);
            O.getPraise().setNum(O.getPraise().getNum() - 1);
            ArrayList<MetaData> user = O.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        O.getPraise().getUser().remove(next);
                        break;
                    }
                }
            }
        }
        if (this.A0.L1()) {
            this.I0.T0().f0();
        } else {
            this.I0.T4(this.A0.s1());
        }
    }

    public final AbsPbActivity.e z6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048760, this, str)) == null) {
            String str2 = null;
            if (this.A0.s1() != null && this.A0.s1().F() != null && this.A0.s1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 < this.A0.s1().F().size()) {
                        if (str.equals(this.A0.s1().F().get(i3).S())) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = 0;
                        break;
                    }
                }
                rba rbaVar = this.A0.s1().F().get(i3);
                if (rbaVar.e0() != null && rbaVar.e0().P() != null) {
                    Iterator<TbRichTextData> it = rbaVar.e0().P().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.V() != null) {
                                str2 = next.V().O();
                            }
                        }
                    }
                    x6(str2, 0, eVar);
                    ud9.b(rbaVar, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final boolean I6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof rba)) {
                return false;
            }
            rba rbaVar = (rba) obj;
            if (rbaVar.getType() != rba.Z0 && !TextUtils.isEmpty(rbaVar.u()) && b05.c().g()) {
                return q6(rbaVar);
            }
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return true;
            }
            PbModel pbModel = this.A0;
            if (pbModel != null && pbModel.s1() != null) {
                if (M5().w1() != null) {
                    M5().w1().g();
                }
                ke9 ke9Var = new ke9();
                ke9Var.v(this.A0.s1().k());
                ke9Var.z(this.A0.s1().O());
                ke9Var.x(rbaVar);
                M5().v1().j0(ke9Var);
                M5().v1().setPostId(rbaVar.S());
                k6(view2, rbaVar.r().getUserId(), "", rbaVar);
                TiebaStatic.log("c11743");
                qj5 qj5Var = this.X0;
                if (qj5Var != null) {
                    this.I0.r3(qj5Var.z());
                }
                return true;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void J6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (pbModel = this.A0) != null && pbModel.s1() != null && this.A0.s1().O() != null && this.A0.s1().O().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void K6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (pbModel = this.A0) != null && pbModel.s1() != null && this.A0.s1().O() != null && this.A0.s1().O().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void V5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && this.a != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.a.getCurrentFocus() != null) {
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final boolean Y6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            PbModel pbModel = this.A0;
            if (pbModel == null || !pbModel.L1()) {
                return false;
            }
            if (this.A0.q1() != null && this.A0.q1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean d5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            PbModel pbModel = this.A0;
            if (pbModel != null && pbModel.s1() != null && this.A0.s1().g() != null && !TextUtils.isEmpty(this.A0.s1().g().l)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048666, this) == null) && tk9.b() && !this.I0.U2()) {
            kf5 showPushOpenView = PushOpenUtil.showPushOpenView(getPageContext(), "reply_pb", 0L);
            this.j0 = showPushOpenView;
            if (showPushOpenView != null) {
                uv9.e().h("reply_pb");
            }
        }
    }

    public final void e7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048669, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && tk9.a() && !this.I0.U2()) {
            kf5 showPushOpenView = PushOpenUtil.showPushOpenView(getPageContext(), "collect", 0L);
            this.j0 = showPushOpenView;
            if (showPushOpenView != null) {
                uv9.e().h("collect");
            }
        }
    }

    public final boolean f6() {
        InterceptResult invokeV;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if (wb9.c() && (pbModel = this.A0) != null && pbModel.s1() != null && this.A0.s1().i() != null && this.A0.s1().i().x() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048690, this) == null) && (pbModel = this.A0) != null && !bi.isEmpty(pbModel.M1())) {
            et4.w().Q(dt4.Z, JavaTypesHelper.toLong(this.A0.M1(), 0L));
        }
    }

    public void s6() {
        List<d3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048738, this) == null) && (list = this.s1) != null && !list.isEmpty()) {
            int size = this.s1.size();
            while (true) {
                size--;
                if (size <= -1 || this.s1.get(size).onBackPressed()) {
                    return;
                }
            }
        }
    }

    public final void t6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.I0.F0();
            if (this.h) {
                return;
            }
            m7();
            this.I0.M3();
            if (this.A0.loadData()) {
                this.I0.u4();
            }
        }
    }

    public final int u5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            if (this.A0.s1() != null && this.A0.s1().O() != null) {
                return this.A0.s1().O().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void N5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (this.G0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.G0 = pollingModel;
                pollingModel.setDialogTime(h55.e);
            }
            this.G0.getData(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            SafeHandler.getInst().postDelayed(this.X1, 10000L);
        }
    }

    public final void Y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            if (this.n1 != null) {
                rl5.b bVar = new rl5.b();
                bVar.a = this.n1.Q();
                bVar.b = this.n1.O();
                bVar.c = String.valueOf(this.n1.R());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.m1));
        }
    }

    public final void a7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            m45 m45Var = new m45(getPageContext().getPageActivity());
            m45Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            m45Var.setPositiveButton(R.string.open_now, new d(this));
            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new e(this));
            m45Var.create(this.g1).show();
        }
    }

    public final boolean b5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            PbModel pbModel = this.A0;
            if (pbModel == null || pbModel.s1() == null) {
                return false;
            }
            ThreadData O = this.A0.s1().O();
            AntiData c4 = this.A0.s1().c();
            if (!AntiHelper.b(getPageContext(), O) && !AntiHelper.d(getPageContext(), c4)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void c7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            showLoadingView(this.I0.E1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d5));
            View attachedView = getLoadingView().getAttachedView();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
            layoutParams.addRule(3, this.I0.D1().getId());
            attachedView.setLayoutParams(layoutParams);
        }
    }

    public final boolean d6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            rba c4 = ud9.c(this.A0.s1(), this.A0.L1(), this.A0.D1());
            if (c4 != null && c4.r() != null && c4.r().getGodUserData() != null && c4.r().getGodUserData().getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean e5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            if ((this.A0.s1() != null && (this.A0.s1().j0() || ThreadCardUtils.isSelf(this.A0.s1().O()))) || this.Z0 == null || this.A0.s1() == null || this.A0.s1().c() == null) {
                return true;
            }
            return this.Z0.checkPrivacyBeforeInvokeEditor(this.A0.s1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void h5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            if (this.A0.X0() || this.A0.a1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.A0.M1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.A0.M1()));
            if (o7()) {
                this.a.finish();
            }
        }
    }

    public final void h6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048681, this) == null) && this.R2 != null) {
            if (this.P2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0fe1);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.R2.a(), this.P2, 0)));
                this.a.finish();
            }
        }
    }

    public final void j6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048689, this) == null) && this.R2 != null) {
            if (this.O2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0fe2);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.R2.a(), this.O2, 0)));
                this.a.finish();
            }
        }
    }

    public final void p7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048731, this) == null) && (absPbActivity = this.a) != null && absPbActivity.J1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.J1().M1()).param("topic_id", this.a.J1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.J1().Q1()));
        }
    }

    public final void s7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048739, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.S(this.A0.getForumId()) && this.A0.s1() != null && this.A0.s1().k() != null) {
            boolean z3 = true;
            if (this.A0.s1().k().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.A0.F0().R(this.A0.getForumId(), this.A0.M1());
            }
        }
    }

    public void P5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (this.f) {
                this.O = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.A0.s1() != null && this.A0.s1().O() != null && this.A0.s1().O().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.A0.s1().O().getTaskInfoData().k(), this.A0.s1().O().getTaskInfoData().h(), this.A0.s1().O().getTaskInfoData().c(), this.A0.s1().O().getTaskInfoData().d(), this.A0.s1().O().getIs_top(), this.A0.s1().O().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void l5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            PbModel pbModel = this.A0;
            if (pbModel != null && pbModel.s1() != null) {
                qba z3 = this.A0.s1().z();
                if (z3 != null) {
                    if (z3.getAdvertAppInfo() != null) {
                        z3.getAdvertAppInfo().h = null;
                    }
                    this.A0.s1().b();
                }
                if (this.A0.K0() != null) {
                    this.A0.x0();
                }
                this.A0.X1();
            }
            if (this.A0.s1().F() != null) {
                Iterator<rba> it = this.A0.s1().F().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof qba) {
                        it.remove();
                    }
                }
            }
            if (this.I0.T0() != null && !ListUtils.isEmpty(this.I0.T0().v())) {
                bi9.d(this.I0.T0().v());
            }
            if (this.I0.m1() != null && !ListUtils.isEmpty(this.I0.m1().getData())) {
                bi9.d(this.I0.m1().getData());
            }
            if (this.I0.T0() != null) {
                this.I0.T0().f0();
            }
        }
    }

    public final boolean o7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            PbModel pbModel = this.A0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.s1() != null && this.A0.s1().j0()) {
                return true;
            }
            if (this.A0.d1()) {
                MarkData O0 = this.A0.O0();
                if (O0 == null || !this.A0.b1()) {
                    return true;
                }
                MarkData I0 = this.A0.I0(this.I0.d1());
                if (I0 == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", O0);
                    this.a.setResult(-1, intent);
                    return true;
                } else if (I0.getPostId() != null && !I0.getPostId().equals(O0.getPostId())) {
                    m45 m45Var = new m45(getPageContext().getPageActivity());
                    m45Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0298));
                    m45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c1, new h2(this, I0, O0, m45Var));
                    m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new i2(this, O0, m45Var));
                    m45Var.setOnCalcelListener(new j2(this, O0, m45Var));
                    m45Var.create(getPageContext());
                    m45Var.show();
                    return false;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", O0);
                    this.a.setResult(-1, intent2);
                    return true;
                }
            }
            if (this.A0.s1() != null && this.A0.s1().F() != null && this.A0.s1().F().size() > 0 && this.A0.b1()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            this.f = false;
            super.onResume();
            if (this.O) {
                this.O = false;
                P5();
            }
            if (d6()) {
                this.t = System.currentTimeMillis();
            } else {
                this.t = -1L;
            }
            ci9 ci9Var = this.I0;
            if (ci9Var != null && ci9Var.E1() != null) {
                if (!this.g) {
                    c7();
                } else {
                    hideLoadingView(this.I0.E1());
                }
                this.I0.I2();
            }
            if (this.j == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            ci9 ci9Var2 = this.I0;
            if (ci9Var2 != null) {
                noNetworkView = ci9Var2.a();
            }
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.update(false);
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.D1);
            this.R0 = false;
            K6();
            registerListener(this.Y1);
            registerListener(this.Z1);
            registerListener(this.b2);
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.p1) {
                F6();
                this.p1 = false;
            }
            j7();
            ItemCardHelper.w(this.J2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                eh5.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048726, this) == null) {
            super.onStop();
            if (this.t > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.t;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.t = 0L;
            }
            if (M5().w1() != null) {
                M5().w1().n();
            }
            rk9 rk9Var = this.I0.k;
            if (rk9Var != null && !rk9Var.n()) {
                this.I0.k.r();
            }
            PbModel pbModel = this.A0;
            if (pbModel != null && pbModel.s1() != null && this.A0.s1().k() != null && this.A0.s1().O() != null) {
                bh5.j().x(getPageContext().getPageActivity(), "pb", this.A0.s1().k().getId(), JavaTypesHelper.toLong(this.A0.s1().O().getId(), 0L));
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            u9a.g().h(getUniqueId(), false);
        }
    }

    public final String y5() {
        InterceptResult invokeV;
        ArrayList<rba> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            PbModel pbModel = this.A0;
            if (pbModel == null || pbModel.s1() == null || this.A0.s1().F() == null || (count = ListUtils.getCount((F = this.A0.s1().F()))) == 0) {
                return "";
            }
            if (this.A0.E1()) {
                Iterator<rba> it = F.iterator();
                while (it.hasNext()) {
                    rba next = it.next();
                    if (next != null && next.I() == 1) {
                        return next.S();
                    }
                }
            }
            int d12 = this.I0.d1();
            rba rbaVar = (rba) ListUtils.getItem(F, d12);
            if (rbaVar != null && rbaVar.r() != null) {
                if (this.A0.m2(rbaVar.r().getUserId())) {
                    return rbaVar.S();
                }
                for (int i3 = d12 - 1; i3 != 0; i3--) {
                    rba rbaVar2 = (rba) ListUtils.getItem(F, i3);
                    if (rbaVar2 == null || rbaVar2.r() == null || rbaVar2.r().getUserId() == null) {
                        break;
                    } else if (this.A0.m2(rbaVar2.r().getUserId())) {
                        return rbaVar2.S();
                    }
                }
                for (int i4 = d12 + 1; i4 < count; i4++) {
                    rba rbaVar3 = (rba) ListUtils.getItem(F, i4);
                    if (rbaVar3 == null || rbaVar3.r() == null || rbaVar3.r().getUserId() == null) {
                        break;
                    } else if (this.A0.m2(rbaVar3.r().getUserId())) {
                        return rbaVar3.S();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void y6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            PbModel pbModel = this.A0;
            if (pbModel != null && pbModel.s1() != null && this.A0.s1().k() != null) {
                if (b5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.A0.s1().j0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.I0.w0();
                    return;
                } else {
                    qj5 qj5Var = this.X0;
                    if (qj5Var != null && qj5Var.b() != null) {
                        this.X0.b().D(new lh5(45, 27, null));
                    }
                    this.I0.w0();
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void Q6(rj5 rj5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, rj5Var) == null) && rj5Var != null && (pbModel = this.A0) != null) {
            rj5Var.p(pbModel.R0());
            if (this.A0.s1() != null && this.A0.s1().k() != null) {
                rj5Var.o(this.A0.s1().k());
            }
            rj5Var.q("pb");
            rj5Var.r(this.A0);
            rj5Var.s(PbNewEditorTool.InputShowType.REPLY);
        }
    }

    public final void R6(int i3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048625, this, i3) != null) || (pbModel = this.A0) == null) {
            return;
        }
        int C1 = pbModel.C1();
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    this.A0.c3(1);
                } else {
                    this.A0.c3(4);
                }
            } else {
                this.A0.c3(3);
            }
        } else {
            this.A0.c3(2);
        }
        int C12 = this.A0.C1();
        if (C1 == 4 || C12 == 4) {
            t6();
        }
    }

    public final void X5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, bundle) == null) {
            bw4 c4 = bw4.c(this.a);
            this.C0 = c4;
            if (c4 != null) {
                c4.j(this.t2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.D0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.v2);
            this.E0 = new fe5(getPageContext());
            N5();
            this.Q1.setUniqueId(getUniqueId());
            this.Q1.registerListener();
            Z5();
        }
    }

    public void X6(View view2) {
        td9 I5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, view2) == null) {
            int i3 = SharedPrefHelper.getInstance().getInt(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb"), 0);
            AbsPbActivity absPbActivity = this.a;
            if ((absPbActivity == null || absPbActivity.getIntent() == null || !this.a.getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) || (i3 != 1 && i3 != 2 && i3 != 3)) && (I5 = I5()) != null) {
                ak9.d(getContext(), view2, I5);
            }
        }
    }

    public void c5(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.I0.k4();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = JavaTypesHelper.toLong(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = JavaTypesHelper.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.i1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.f1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean f5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048671, this, i3)) == null) {
            if (this.Z0 != null && this.A0.s1() != null && !ThreadCardUtils.isSelf(this.A0.s1().O()) && this.A0.s1().c() != null) {
                return this.Z0.checkPrivacyBeforeSend(this.A0.s1().c().replyPrivateFlag, i3);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void i6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, bundle) == null) {
            PbModel J1 = this.a.J1();
            this.A0 = J1;
            if (J1 != null) {
                if (J1.N0() != null) {
                    this.A0.N0().c(this.N2);
                }
                if (this.A0.o1() != null) {
                    this.A0.o1().f(this.w1);
                }
                if (StringUtils.isNull(this.A0.M1())) {
                    this.a.finish();
                } else if ("from_tieba_kuang".equals(this.M) && this.M != null) {
                    this.A0.Z2(6);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z3;
        ci9 ci9Var;
        rk9 rk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (UtilHelper.isFoldScreen() && (ci9Var = this.I0) != null && (rk9Var = ci9Var.k) != null && rk9Var.n()) {
                this.I0.k.g();
                u6();
            }
            int i3 = configuration.orientation;
            if (i3 == this.w) {
                return;
            }
            this.w = i3;
            if (i3 == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.J = z3;
            ci9 ci9Var2 = this.I0;
            if (ci9Var2 != null) {
                ci9Var2.z2(configuration);
            }
            u45 u45Var = this.N0;
            if (u45Var != null) {
                u45Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public final void q7(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048734, this, z3) == null) && (absPbActivity = this.a) != null && absPbActivity.J1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.J1().M1()).param("topic_id", this.a.J1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.J1().Q1()));
        }
    }

    public void w6(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048752, this, animatorListener) == null) && this.I0 != null && (pbModel = this.A0) != null && pbModel.s1() != null && this.A0.s1().S() != null && checkUpIsLogin() && this.I0.T0() != null && this.I0.T0().B() != null) {
            this.I0.T0().B().V(animatorListener);
        }
    }

    public final void R5(int i3, Intent intent) {
        yh5 yh5Var;
        yh5 yh5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048624, this, i3, intent) == null) {
            if (i3 == 0) {
                this.I0.I1();
                this.I0.w1().g();
                this.I0.c4(false);
            }
            this.I0.j3();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (!(serializableExtra instanceof PbEditorData)) {
                return;
            }
            PbEditorData pbEditorData = (PbEditorData) serializableExtra;
            WriteData writeData = new WriteData();
            writeData.setContent(pbEditorData.getContent());
            writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
            writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
            int editorType = pbEditorData.getEditorType();
            if (editorType != 0) {
                if (editorType == 1 && this.I0.w1() != null && this.I0.w1().f() != null) {
                    tj5 f4 = this.I0.w1().f();
                    f4.f0(this.A0.s1().O());
                    f4.D(writeData);
                    f4.g0(pbEditorData.getVoiceModel());
                    xh5 p3 = f4.b().p(6);
                    if (p3 != null && (yh5Var2 = p3.m) != null) {
                        yh5Var2.B(new lh5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        f4.I();
                        return;
                    }
                    return;
                }
                return;
            }
            qj5 qj5Var = this.X0;
            if (qj5Var != null) {
                qj5Var.M();
                this.X0.n0(pbEditorData.getVoiceModel());
                this.X0.C(writeData);
                xh5 p4 = this.X0.b().p(6);
                if (p4 != null && (yh5Var = p4.m) != null) {
                    yh5Var.B(new lh5(52, 0, pbEditorData.getVoiceModel()));
                }
                this.X0.i0(pbEditorData.isShowCustomFigure());
                if (i3 == -1) {
                    this.X0.H(null, null);
                }
            }
        }
    }

    public final void V6(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048636, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (M5() != null) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    String questionMsg = postWriteCallBackData.getQuestionMsg();
                    String questionExp = postWriteCallBackData.getQuestionExp();
                    if (postWriteCallBackData.getIconStampData() != null) {
                        nf5.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            zb9.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            zb9.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            zb9.e(getResources().getString(R.string.obfuscated_res_0x7f0f146f));
                            return;
                        } else {
                            zb9.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.A0.f1()) {
                antiData.setBlock_forum_name(this.A0.s1().k().getName());
                antiData.setBlock_forum_id(this.A0.s1().k().getId());
                antiData.setUser_name(this.A0.s1().V().getUserName());
                antiData.setUser_id(this.A0.s1().V().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void b7(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048660, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            u45 u45Var = this.N0;
            if (u45Var != null && u45Var.isShowing()) {
                this.N0.dismiss();
                this.N0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            w45 w45Var = new w45(getContext());
            w45Var.q(new g0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i3 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i3 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i3 == 1) {
                arrayList.add(new s45(0, getResources().getString(R.string.obfuscated_res_0x7f0f0546), w45Var));
            }
            if (z3) {
                arrayList.add(new s45(1, getResources().getString(R.string.un_mute), w45Var));
            } else {
                arrayList.add(new s45(1, getResources().getString(R.string.obfuscated_res_0x7f0f0cf9), w45Var));
            }
            w45Var.l(arrayList);
            u45 u45Var2 = new u45(getPageContext(), w45Var);
            this.N0 = u45Var2;
            u45Var2.l();
        }
    }

    public final void l7(rba rbaVar, boolean z3) {
        PbModel pbModel;
        int i3;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048696, this, rbaVar, z3) == null) {
            N6(false);
            if (rbaVar == null || (pbModel = this.A0) == null || pbModel.s1() == null || rbaVar.I() == 1) {
                return;
            }
            String M1 = this.A0.M1();
            String S = rbaVar.S();
            if (this.A0.s1() != null) {
                i3 = this.A0.s1().W();
            } else {
                i3 = 0;
            }
            AbsPbActivity.e z6 = z6(S);
            if (z6 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo l02 = rbaVar.l0();
            AntiData c4 = this.A0.s1().c();
            if (rbaVar.r() != null) {
                arrayList = rbaVar.r().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(M1, S, "pb", true, false, null, false, null, i3, l02, c4, false, arrayList, 5).addBigImageData(z6.a, z6.b, z6.g, z6.j);
            addBigImageData.setKeyPageStartFrom(this.A0.r1());
            addBigImageData.setFromFrsForumId(this.A0.getFromForumId());
            addBigImageData.setWorksInfoData(this.A0.R1());
            addBigImageData.setKeyFromForumId(this.A0.getForumId());
            addBigImageData.setBjhData(this.A0.J0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public void m5(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048698, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(ci9.o2)).intValue();
            if (intValue == ci9.p2) {
                if (this.D0.g0()) {
                    return;
                }
                this.I0.F4();
                String str = (String) sparseArray.get(R.id.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                if (sparseArray.get(R.id.tag_is_block_thread) != null) {
                    z3 = ((Boolean) sparseArray.get(R.id.tag_is_block_thread)).booleanValue();
                } else {
                    z3 = false;
                }
                if (jSONArray != null) {
                    this.D0.i0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.D0.j0(this.A0.s1().k().getId(), this.A0.s1().k().getName(), this.A0.s1().O().getId(), str, intValue3, intValue2, booleanValue, this.A0.s1().O().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == ci9.q2 || intValue == ci9.s2) {
                PbModel pbModel = this.A0;
                if (pbModel != null && pbModel.N0() != null) {
                    this.A0.N0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == ci9.q2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public void p5(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048729, this, i3, i4) == null) {
            TiebaStatic.log("c12181");
            ci9 ci9Var = this.I0;
            if (ci9Var != null && this.A0 != null) {
                if ((ci9Var == null || ci9Var.e2()) && this.A0.s1() != null && this.A0.s1().S() != null) {
                    ci9 ci9Var2 = this.I0;
                    if (ci9Var2 != null && ci9Var2.b1() != null && this.I0.b1().t()) {
                        return;
                    }
                    je9 S = this.A0.s1().S();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!S.d() || S.a() != 2) && this.I0.T0() != null && this.I0.T0().B() != null) {
                        this.I0.T0().B().K(this.A0.M1(), this.A0.getFromForumId());
                    }
                    if (i3 > -1 && i4 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        PbFirstFloorDoubleClickAnimation pbFirstFloorDoubleClickAnimation = new PbFirstFloorDoubleClickAnimation(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.A0;
                        pbFirstFloorDoubleClickAnimation.show(findViewById, i3, i4, pbModel.b, pbModel.getForumId());
                        pbFirstFloorDoubleClickAnimation.setOnPraiseAnimatorListener(new n0(this));
                    } else if (System.currentTimeMillis() - this.v > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.v = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public void S5(boolean z3, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
            String str6 = "";
            if (!(sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String)) {
                str2 = "";
            } else {
                str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
            }
            if (!(sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String)) {
                str3 = "";
            } else {
                str3 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
            }
            if (!(sparseArray.get(R.id.tag_user_mute_post_id) instanceof String)) {
                str4 = "";
            } else {
                str4 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
            }
            if (!(sparseArray.get(R.id.tag_user_mute_msg) instanceof String)) {
                str5 = "";
            } else {
                str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
            }
            if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
                str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
            }
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.i1);
            userMuteAddAndDelCustomMessage.setTag(this.i1);
            i7(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void U6(int i3, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048632, this, i3, antiData, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new y1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                h7(str);
            } else {
                this.I0.D4(str);
            }
        }
    }

    @Override // com.baidu.tieba.s06
    public void f0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048670, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.P0 = str;
            if (this.k == null) {
                a6();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.k.f(1).setVisibility(8);
            } else {
                this.k.f(1).setVisibility(0);
            }
            this.k.m();
            this.u = true;
        }
    }

    public final void W6(SparseArray<Object> sparseArray, int i3, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{sparseArray, Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) {
            zj9.d(getActivity(), getPageContext(), new e1(this, sparseArray, i3, z3), new f1(this));
        }
    }

    public final void X4() {
        PbModel pbModel;
        td9 td9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (pbModel = this.A0) != null && (td9Var = pbModel.G) != null && td9Var.O() != null) {
            ThreadData O = this.A0.G.O();
            O.mRecomAbTag = this.A0.y1();
            O.mRecomWeight = this.A0.B1();
            O.mRecomSource = this.A0.A1();
            O.mRecomExtra = this.A0.z1();
            O.isSubPb = this.A0.f1();
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(this.A0.getForumId(), 0L));
            }
            StatisticItem i3 = gr5.i(getContext(), O, "c13562");
            TbPageTag l3 = gr5.l(getContext());
            if (l3 != null && "a008".equals(l3.locatePage)) {
                i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a008");
            }
            if (l3 != null && "a002".equals(l3.locatePage)) {
                i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            if (i3 != null) {
                TiebaStatic.log(i3);
            }
        }
    }

    public final void n6() {
        MarkData I0;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048702, this) == null) && this.C0 != null) {
            if (this.A0.s1() != null && this.A0.s1().j0()) {
                I0 = this.A0.I0(0);
            } else {
                I0 = this.A0.I0(this.I0.l1());
            }
            if (I0 == null) {
                return;
            }
            if (I0.isApp() && (I0 = this.A0.I0(this.I0.l1() + 1)) == null) {
                return;
            }
            this.I0.M3();
            this.C0.i(I0);
            if (!this.C0.e()) {
                if (this.I0 != null && (pbModel = this.A0) != null && !gk9.h(pbModel.b)) {
                    this.I0.x4();
                    gk9.b(this.A0.b);
                }
                this.C0.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.C0.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            this.f = true;
            super.onPause();
            dk9.a();
            BdTypeListView listView = getListView();
            int viewLayer = CompatibleUtile.getInstance().getViewLayer(listView);
            this.j = viewLayer;
            if (viewLayer == 1) {
                CompatibleUtile.getInstance().noneViewGpu(listView);
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            ci9 ci9Var = this.I0;
            if (ci9Var != null) {
                ci9Var.F2();
            }
            if (this.X0 != null && !this.A0.f1()) {
                this.X0.O(this.A0.M1());
            }
            PbModel pbModel = this.A0;
            if (pbModel != null) {
                pbModel.v2();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            et4.w().E();
            MessageManager.getInstance().unRegisterListener(this.D1);
            J6();
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.b2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            kf5 kf5Var = this.j0;
            if (kf5Var != null) {
                kf5Var.q();
                this.j0.p();
            }
        }
    }

    public final void Z4(td9 td9Var, ArrayList<rba> arrayList) {
        List<rba> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048650, this, td9Var, arrayList) == null) && td9Var != null && td9Var.T() != null && td9Var.T().a != null && (list = td9Var.T().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<rba> it = arrayList.iterator();
                while (it.hasNext()) {
                    rba next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            rba rbaVar = (rba) it2.next();
                            if (rbaVar != null && !TextUtils.isEmpty(next.S()) && !TextUtils.isEmpty(rbaVar.S()) && next.S().equals(rbaVar.S())) {
                                arrayList2.add(rbaVar);
                            }
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    arrayList3.removeAll(arrayList2);
                }
                if (arrayList3.size() > 0) {
                    arrayList.addAll(arrayList3);
                }
            }
        }
    }

    public final void r5(int i3, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048735, this, i3, gVar) != null) || gVar == null) {
            return;
        }
        this.I0.O0(this.D0.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.J0 = true;
            if (i3 != 2 && i3 != 3) {
                if (i3 == 4 || i3 == 5) {
                    this.K0 = false;
                    this.L0 = true;
                }
            } else {
                this.K0 = true;
                this.L0 = false;
            }
            if (i3 == 2) {
                this.A0.s1().O().setIs_good(1);
                this.A0.V2(1);
            } else if (i3 == 3) {
                this.A0.s1().O().setIs_good(0);
                this.A0.V2(0);
            } else if (i3 == 4) {
                this.A0.s1().O().setIs_top(1);
                this.A0.W2(1);
            } else if (i3 == 5) {
                this.A0.s1().O().setIs_top(0);
                this.A0.W2(0);
            }
            this.I0.Q4(this.A0.s1(), this.A0.L1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.operation_failed);
        }
        BdUtilHelper.showToast(getPageContext().getPageActivity(), string);
    }

    public final void a6() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048656, this) != null) || this.k != null) {
            return;
        }
        this.k = new n45(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        n45 n45Var = this.k;
        n45Var.j(strArr, new q0(this));
        n45Var.g(n45.b.a);
        n45Var.h(17);
        n45Var.c(getPageContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g5(AgreeData agreeData) {
        br5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048676, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.e0 == null) {
            this.e0 = new r85();
        }
        if (this.i0 == null) {
            AgreeMessageData agreeMessageData = new AgreeMessageData();
            this.i0 = agreeMessageData;
            agreeMessageData.uniqueId = getUniqueId();
        }
        w05 w05Var = new w05();
        w05Var.b = 5;
        w05Var.h = 8;
        w05Var.g = 2;
        if (R() != null) {
            w05Var.f = R().r1();
        }
        w05Var.a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                w05Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.e0.c(agreeData, i3, getUniqueId(), false);
                this.e0.d(agreeData, this.i0);
                pbModel = this.A0;
                if (pbModel == null && pbModel.s1() != null) {
                    this.e0.b(Y(), w05Var, agreeData, this.A0.s1().O());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            w05Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            w05Var.i = 1;
        }
        i3 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
        if (currentVisiblePageExtra != null) {
        }
        this.e0.c(agreeData, i3, getUniqueId(), false);
        this.e0.d(agreeData, this.i0);
        pbModel = this.A0;
        if (pbModel == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        td9 s12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (M5() != null && bi9.D(this)) {
                M5().E4();
            }
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907b1));
            PbModel pbModel = this.A0;
            if (pbModel != null && (s12 = pbModel.s1()) != null) {
                this.q2.c(true, 0, 3, 0, s12, "", 1);
            }
            this.a.L1().k(this.t0);
            if (f6()) {
                AbsPbActivity absPbActivity = this.a;
                if (absPbActivity instanceof PbActivity) {
                    ((PbActivity) absPbActivity).e2();
                }
            }
            PbModel pbModel2 = this.A0;
            if (pbModel2 != null && this.G.c(pbModel2.G, getContext(), this.a.findViewById(this.I0.U0()), this.A0.getForumId(), this.A0.M1())) {
                AbsPbActivity absPbActivity2 = this.a;
                if (absPbActivity2 instanceof PbActivity) {
                    ((PbActivity) absPbActivity2).e2();
                }
            }
        }
    }

    public final boolean i5(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        bw4 bw4Var;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        String str;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int i3;
        boolean z20;
        s45 s45Var;
        s45 s45Var2;
        s45 s45Var3;
        s45 s45Var4;
        s45 s45Var5;
        s45 s45Var6;
        BdImage bdImage;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048684, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext())) {
                return true;
            }
            ci9 ci9Var = this.I0;
            if (ci9Var != null) {
                if (ci9Var.g2()) {
                    return true;
                }
                this.I0.P0();
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (bi9.y(view2)) {
                    if (view2 instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view2;
                        this.l1 = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.m1 = url;
                        if (this.l1 == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view2.getTag(R.id.tag_rich_text_image_info) != null && (view2.getTag(R.id.tag_rich_text_image_info) instanceof TbRichTextImageInfo)) {
                            this.n1 = (TbRichTextImageInfo) view2.getTag(R.id.tag_rich_text_image_info);
                        } else {
                            this.n1 = null;
                        }
                        if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.o1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.o1 = null;
                        }
                    } else if (view2 instanceof GifView) {
                        GifView gifView = (GifView) view2;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.l1 = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().getUrl())) {
                            this.m1 = gifView.getBdImage().getUrl();
                        }
                        if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.o1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.o1 = null;
                        }
                    } else if (view2 instanceof TbMemeImageView) {
                        TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                        if (tbMemeImageView.getBdImage() != null) {
                            this.l1 = tbMemeImageView.getBdImage();
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().getUrl())) {
                                this.m1 = tbMemeImageView.getBdImage().getUrl();
                            }
                            if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.o1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.o1 = null;
                            }
                        }
                    }
                    if (view2.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                        } catch (ClassCastException e5) {
                            e5.printStackTrace();
                        }
                    } else if (view2.getParent().getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view2.getParent().getParent()).getTag();
                        } catch (ClassCastException e6) {
                            e6.printStackTrace();
                        }
                    } else {
                        this.I0.p4(this.F2, this.l1.isGif());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            rba rbaVar = (rba) sparseArray.get(R.id.tag_clip_board);
            this.D2 = rbaVar;
            if (rbaVar == null) {
                return true;
            }
            if (rbaVar.I() == 1 && bi9.y(view2)) {
                this.I0.p4(this.F2, this.l1.isGif());
                return true;
            } else if (this.D2.A0() || (bw4Var = this.C0) == null) {
                return true;
            } else {
                if (bw4Var.e() && this.D2.S() != null && this.D2.S().equals(this.A0.n1())) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (R().s1() != null && R().s1().j0()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (R().s1() != null && R().s1().p0()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (R().s1() != null && R().s1().o0()) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (this.D2.I() == 1) {
                    if (!z4) {
                        this.I0.q4(this.E2, z3, false, z5, z6);
                    }
                    return true;
                }
                if (this.O0 == null) {
                    w45 w45Var = new w45(getContext());
                    this.O0 = w45Var;
                    w45Var.q(this.i2);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 != null && sparseArray != null) {
                    if (bi9.y(view2) && !z4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (bi9.y(view2) && (bdImage = this.l1) != null && !bdImage.isGif()) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (sparseArray.get(R.id.tag_is_subpb) instanceof Boolean) {
                        z9 = ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue();
                    } else {
                        z9 = false;
                    }
                    if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                        z10 = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                    } else {
                        z10 = false;
                    }
                    if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                        z11 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                    } else {
                        z11 = false;
                    }
                    if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                        z12 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                    } else {
                        z12 = false;
                    }
                    if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                        z13 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                    } else {
                        z13 = false;
                    }
                    if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                        z14 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                    } else {
                        z14 = false;
                    }
                    if (sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String) {
                        str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                    } else {
                        str = null;
                    }
                    if (sparseArray.get(R.id.tag_is_self_post) instanceof Boolean) {
                        z15 = ((Boolean) sparseArray.get(R.id.tag_is_self_post)).booleanValue();
                    } else {
                        z15 = false;
                    }
                    boolean z21 = z15;
                    if (sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) {
                        z16 = ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue();
                    } else {
                        z16 = false;
                    }
                    if (z7) {
                        z17 = z16;
                        z19 = z14;
                        z18 = z13;
                        arrayList.add(new s45(1, getString(R.string.save_to_emotion), this.O0));
                    } else {
                        z17 = z16;
                        z18 = z13;
                        z19 = z14;
                    }
                    if (z8) {
                        arrayList.add(new s45(2, getString(R.string.save_to_local), this.O0));
                    }
                    if (!z7 && !z8) {
                        s45 s45Var7 = new s45(3, getString(R.string.obfuscated_res_0x7f0f04e1), this.O0);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.tag_clip_board, this.D2);
                        s45Var7.d.setTag(sparseArray3);
                        arrayList.add(s45Var7);
                    }
                    if (!z9 && !z4) {
                        if (z3) {
                            s45Var6 = new s45(4, getString(R.string.remove_mark), this.O0);
                        } else {
                            s45Var6 = new s45(4, getString(R.string.obfuscated_res_0x7f0f0c3d), this.O0);
                        }
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_clip_board, this.D2);
                        sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                        s45Var6.d.setTag(sparseArray4);
                        arrayList.add(s45Var6);
                    }
                    if (this.mIsLogin) {
                        if (!zj9.i(this.A0) && !z12 && z11) {
                            s45 s45Var8 = new s45(5, getString(R.string.obfuscated_res_0x7f0f0cfd), this.O0);
                            SparseArray sparseArray5 = new SparseArray();
                            sparseArray5.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                            sparseArray5.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                            sparseArray5.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                            sparseArray5.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                            sparseArray5.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                            sparseArray5.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                            sparseArray5.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                            sparseArray5.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                            sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                            s45Var8.d.setTag(sparseArray5);
                            arrayList.add(s45Var8);
                        } else {
                            if (bi9.C(this.A0.s1(), z10) && TbadkCoreApplication.isLogin()) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (z20 && !z4) {
                                s45 s45Var9 = new s45(5, getString(R.string.report_text), this.O0);
                                s45Var9.d.setTag(str);
                                arrayList.add(s45Var9);
                            }
                        }
                        if (z12) {
                            SparseArray sparseArray6 = new SparseArray();
                            sparseArray6.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                            sparseArray6.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                            sparseArray6.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                            sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                            sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                            sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                            sparseArray6.put(R.id.tag_mul_del_post_type, sparseArray.get(R.id.tag_mul_del_post_type));
                            if (!zj9.i(this.A0) && z18) {
                                sparseArray6.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                sparseArray6.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                                sparseArray6.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                                sparseArray6.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                                sparseArray6.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                                sparseArray6.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                                sparseArray6.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                            } else {
                                sparseArray6.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                            }
                            if (z19) {
                                sparseArray6.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                                sparseArray6.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                                sparseArray6.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                                sparseArray6.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                                sparseArray6.put(R.id.tag_is_self_post, Boolean.valueOf(z21));
                                if (z21) {
                                    s45Var5 = new s45(6, getString(R.string.obfuscated_res_0x7f0f0546), this.O0);
                                    s45Var5.d.setTag(sparseArray6);
                                    s45Var2 = new s45(7, getString(R.string.obfuscated_res_0x7f0f0322), this.O0);
                                    s45Var2.d.setTag(sparseArray6);
                                    s45Var3 = s45Var5;
                                    s45Var = null;
                                }
                            } else {
                                sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                            }
                            s45Var5 = null;
                            s45Var2 = new s45(7, getString(R.string.obfuscated_res_0x7f0f0322), this.O0);
                            s45Var2.d.setTag(sparseArray6);
                            s45Var3 = s45Var5;
                            s45Var = null;
                        } else if (z19) {
                            SparseArray sparseArray7 = new SparseArray();
                            sparseArray7.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                            sparseArray7.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                            sparseArray7.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                            sparseArray7.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                            sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                            sparseArray7.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray7.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            sparseArray7.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                            if (this.A0.s1().W() == 1002 && !z10) {
                                s45Var4 = new s45(6, getString(R.string.report_text), this.O0);
                            } else {
                                s45Var4 = new s45(6, getString(R.string.obfuscated_res_0x7f0f0546), this.O0);
                            }
                            s45Var4.d.setTag(sparseArray7);
                            if (z17) {
                                s45Var = new s45(13, getString(R.string.multi_delete), this.O0);
                                s45Var3 = s45Var4;
                            } else {
                                s45Var3 = s45Var4;
                                s45Var = null;
                            }
                            s45Var2 = null;
                        } else {
                            s45Var = null;
                            s45Var2 = null;
                            s45Var3 = null;
                        }
                        if (s45Var3 != null) {
                            arrayList.add(s45Var3);
                        }
                        if (s45Var != null) {
                            arrayList.add(s45Var);
                        }
                        if (s45Var2 != null) {
                            arrayList.add(s45Var2);
                        }
                        zj9.b(arrayList, this.O0, this.D2, this.A0);
                    }
                    List<s45> c4 = zj9.c(arrayList, this.D2.o(), sparseArray, this.O0);
                    zj9.l(c4, this.b);
                    zj9.e(c4);
                    this.O0.r(zj9.g(this.D2));
                    this.O0.m(c4, true);
                    this.N0 = new u45(getPageContext(), this.O0);
                    this.O0.p(new v2(this));
                    this.N0.l();
                    StatisticItem param = new StatisticItem("c13272").param("tid", this.A0.b).param("fid", this.A0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.A0.P());
                    if (z9) {
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    TiebaStatic.log(param.param("obj_source", i3));
                    return true;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void i7(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048686, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.I0.k4();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            m45 m45Var = new m45(this.g1.getPageActivity());
            if (!bi.isEmpty(str)) {
                m45Var.setMessage(str);
            } else {
                m45Var.setMessage(this.g1.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            m45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c1, new g(this, userMuteAddAndDelCustomMessage));
            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new h(this));
            m45Var.create(this.g1).show();
        }
    }

    public void j5(ForumManageModel.b bVar, ci9 ci9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048688, this, bVar, ci9Var) == null) {
            List<rba> list = this.A0.s1().T().a;
            int size = list.size();
            boolean z3 = false;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.get(i3).i0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i3).i0().get(i4).S())) {
                        list.get(i3).i0().remove(i4);
                        list.get(i3).h();
                        z3 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                list.get(i3).i(bVar.g);
            }
            if (z3) {
                ci9Var.d2(this.A0.s1());
            }
        }
    }

    public final void k6(View view2, String str, String str2, rba rbaVar) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048692, this, view2, str, str2, rbaVar) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (b5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (!e5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.Y);
                        this.Z = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (M5().w1() != null && rbaVar != null) {
                        if (rbaVar.e0() != null) {
                            str3 = rbaVar.e0().toString();
                        } else {
                            str3 = "";
                        }
                        M5().w1().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), rbaVar.r().getName_show(), str3));
                    }
                    if (this.A0.s1() != null && this.A0.s1().j0()) {
                        SafeHandler.getInst().postDelayed(new h1(this, str, str2), 0L);
                        return;
                    } else {
                        SafeHandler.getInst().postDelayed(new i1(this, str, str2), 200L);
                        return;
                    }
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public void n5(m45 m45Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048701, this, m45Var, jSONArray) == null) {
            m45Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(m45Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                m5((SparseArray) m45Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final TbRichText v7(String str, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048750, this, str, i3)) == null) {
            PbModel pbModel = this.A0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.s1() == null || str == null || i3 < 0) {
                return null;
            }
            td9 s12 = this.A0.s1();
            if (s12.i() != null) {
                ArrayList<rba> arrayList = new ArrayList<>();
                arrayList.add(s12.i());
                tbRichText = z5(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<rba> F = s12.F();
                Z4(s12, F);
                return z5(F, str, i3);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void o5(int i3, String str, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048705, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(ci9.o2, Integer.valueOf(ci9.p2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                m5(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048709, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            qj5 qj5Var = this.X0;
            if (qj5Var != null) {
                qj5Var.D(i3, i4, intent);
            }
            if (M5().w1() != null) {
                M5().w1().k(i3, i4, intent);
            }
            if (i3 == 25035) {
                R5(i4, intent);
            }
            if (i4 == -1) {
                if (i3 != 11009) {
                    if (i3 != 13008) {
                        if (i3 != 13011) {
                            if (i3 != 23007) {
                                if (i3 != 25033) {
                                    if (i3 != 24007) {
                                        if (i3 != 24008) {
                                            switch (i3) {
                                                case 25055:
                                                    View view2 = this.S;
                                                    if (view2 != null) {
                                                        view2.performClick();
                                                        return;
                                                    }
                                                    return;
                                                case 25056:
                                                    View view3 = this.f1144T;
                                                    if (view3 != null) {
                                                        view3.performClick();
                                                        return;
                                                    }
                                                    return;
                                                case 25057:
                                                    ci9 ci9Var = this.I0;
                                                    if (ci9Var != null && ci9Var.W0() != null) {
                                                        this.I0.W0().performClick();
                                                        return;
                                                    }
                                                    return;
                                                case 25058:
                                                    View view4 = this.U;
                                                    if (view4 != null) {
                                                        view4.performClick();
                                                        return;
                                                    }
                                                    return;
                                                default:
                                                    return;
                                            }
                                        }
                                        this.I0.O3(false);
                                        if (this.A0.s1() != null && this.A0.s1().O() != null && this.A0.s1().O().getPushStatusData() != null) {
                                            this.A0.s1().O().getPushStatusData().setStatus(2);
                                            return;
                                        }
                                        return;
                                    }
                                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                        RateManager.getInstance().notifyShare(getPageContext());
                                        s7();
                                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.H0;
                                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.linkUrl) != null) {
                                            shareSuccessReplyToServerModel.N(str, intExtra, new f2(this));
                                        }
                                        if (c6()) {
                                            q7(true);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                View view5 = this.R;
                                if (view5 != null) {
                                    this.I0.h4(view5);
                                    return;
                                }
                                return;
                            }
                            U5(intent);
                            return;
                        }
                        RateManager.getInstance().notifyShare(getPageContext());
                        return;
                    }
                    th9.b().k();
                    this.y0.postDelayed(new e2(this), 1000L);
                    return;
                }
                n6();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        ci9 ci9Var;
        ci9 ci9Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, bundle) == null) {
            this.n = System.currentTimeMillis();
            this.g1 = getPageContext();
            Intent intent = this.a.getIntent();
            if (intent != null) {
                this.l = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                this.M = intent.getStringExtra("from");
                if (intent.getData() != null) {
                    Uri data = intent.getData();
                    if (StringUtils.isNull(this.M)) {
                        this.M = data.getQueryParameter("from");
                    }
                }
                this.V = intent.getStringExtra("st_type");
                this.O2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.P2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.Q2 = intent.getStringExtra("key_manga_title");
                this.S0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.T0 = intent.getStringExtra("high_light_post_id");
                this.U0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (C5()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P = stringExtra;
                if (bi.isEmpty(stringExtra)) {
                    str = "";
                } else {
                    str = this.P;
                }
                this.P = str;
                this.r1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                e35 e35Var = new e35();
                this.c0 = e35Var;
                e35Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.t1 = intExtra;
                if (intExtra == 0) {
                    this.t1 = intent.getIntExtra("key_start_from", 0);
                }
                this.S2 = intent.getIntExtra(PbActivityConfig.KEY_FROM_CARD_TYPE, 0);
            } else {
                this.l = System.currentTimeMillis();
            }
            this.p = this.n - this.l;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.j = 0;
            i6(bundle);
            if (this.A0.s1() != null) {
                this.A0.s1().U0(this.P);
            }
            Y5();
            if (intent != null && (ci9Var2 = this.I0) != null) {
                ci9Var2.e = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.j1 == null) {
                        this.j1 = new k0(this, intent);
                    }
                    SafeHandler.getInst().postDelayed(this.j1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.A0.s1() != null) {
                    this.A0.a3(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.i = voiceManager;
            voiceManager.onCreate(getPageContext());
            X5(bundle);
            rj5 rj5Var = new rj5();
            this.W0 = rj5Var;
            Q6(rj5Var);
            qj5 qj5Var = (qj5) this.W0.a(getActivity());
            this.X0 = qj5Var;
            qj5Var.X(this.a.getPageContext());
            this.X0.g0(this.m2);
            this.X0.h0(this.b1);
            this.X0.Z(1);
            this.X0.B(this.a.getPageContext(), bundle);
            this.X0.b().b(new wh5(getActivity()));
            this.X0.b().F(true);
            T6(true);
            this.X0.K(this.A0.U0(), this.A0.M1(), this.A0.Q0());
            registerListener(this.A1);
            if (!this.A0.f1()) {
                this.X0.q(this.A0.M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.X0.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.A0.c2()) {
                this.X0.d0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                ci9 ci9Var3 = this.I0;
                if (ci9Var3 != null) {
                    this.X0.d0(ci9Var3.x1());
                }
            }
            this.G = new PbGodGuideController();
            getLifecycle().addObserver(this.G);
            yy4.a().c(this.z0);
            registerListener(this.z1);
            registerListener(this.B1);
            registerListener(this.C1);
            registerListener(this.y1);
            registerListener(this.c2);
            registerListener(this.d2);
            registerListener(this.s2);
            registerListener(this.x1);
            iba ibaVar = new iba("pb", iba.d);
            this.V0 = ibaVar;
            ibaVar.d();
            registerListener(this.I1);
            registerListener(this.S1);
            this.A0.w2();
            registerListener(this.r2);
            registerListener(this.f2);
            registerListener(this.l2);
            registerListener(this.O1);
            registerListener(this.e2);
            registerListener(this.J1);
            ci9 ci9Var4 = this.I0;
            if (ci9Var4 != null && ci9Var4.D1() != null && this.I0.B1() != null) {
                jj9 jj9Var = new jj9(getActivity(), this.I0.D1(), this.I0.B1(), this.I0.u1());
                this.e = jj9Var;
                jj9Var.t(this.R1);
            }
            if (this.c && (ci9Var = this.I0) != null && ci9Var.B1() != null) {
                this.I0.B1().setVisibility(8);
            }
            e95 e95Var = new e95();
            this.h1 = e95Var;
            e95Var.a = 1000L;
            registerListener(this.b2);
            registerListener(this.a2);
            registerListener(this.Y1);
            registerListener(this.Z1);
            registerListener(this.L1);
            registerListener(this.M1);
            registerListener(this.E1);
            registerListener(this.F1);
            registerListener(this.G1);
            this.K1.setSelfListener(true);
            this.K1.setTag(this.a.getUniqueId());
            this.K1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.K1);
            registerResponsedEventListener(TipEvent.class, this.T1);
            registerResponsedEventListener(TopToastEvent.class, this.U1);
            this.i1 = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.i1;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.i1;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            this.V1 = new e3(this.I0, this);
            this.A0.M0().R(this.V1);
            this.M0 = new fi9();
            if (this.X0.s() != null) {
                this.M0.m(this.X0.s().i());
            }
            this.X0.W(this.c1);
            this.H0 = new ShareSuccessReplyToServerModel();
            V4(this.v1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.Z0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new l0(this));
            xk9 xk9Var = new xk9(getContext());
            this.B0 = xk9Var;
            xk9Var.b(getUniqueId());
            u9a.g().i(getUniqueId());
            l05.b().l("3", "");
            this.u1 = new cm6(getPageContext());
            this.u0 = new xj9(this, getUniqueId(), this.I0, this.A0);
            this.v0 = new PushPermissionController(getActivity(), getPageContext());
            if (!TbSingleton.getInstance().hasDownloadEmotion() && BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.o = System.currentTimeMillis() - this.n;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048715, this, layoutInflater, viewGroup, bundle)) == null) {
            this.I0 = new ci9(this, this.k2, this.W1, this.j2);
            ow6 ow6Var = new ow6(getActivity());
            this.d = ow6Var;
            ow6Var.i(U2);
            this.d.d(this.M2);
            this.I0.F3(this.u2);
            this.I0.E3(this.z2);
            this.I0.y3(this.w2);
            this.I0.z3(this.x2);
            this.I0.w3(b05.c().g());
            this.I0.C3(this.B2);
            this.I0.I3(this.H2);
            this.I0.G3(this.I2);
            this.I0.D3(this.K2);
            this.I0.L4(this.mIsLogin);
            this.I0.u3(this.A0.a2());
            if (this.a.getIntent() != null) {
                this.I0.v3(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.I0.v1().setFromForumId(this.A0.getFromForumId());
            qj5 qj5Var = this.X0;
            if (qj5Var != null) {
                this.I0.m3(qj5Var.b());
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.X0.d0(TbSingleton.getInstance().getAdVertiComment());
                } else {
                    this.X0.d0(this.I0.x1());
                }
            }
            this.I0.q3(this.h2);
            this.I0.t3(this.A0.a1());
            this.I0.H3(this.A0.r1());
            this.u0.f(this.I0, this.A0);
            if ("1".equals(R().showReplyPanel)) {
                this.I0.H2();
            }
            return this.I0.E1();
        }
        return (View) invokeLLL.objValue;
    }

    public final TbRichText z5(ArrayList<rba> arrayList, String str, int i3) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048759, this, arrayList, str, i3)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    TbRichText e02 = arrayList.get(i4).e0();
                    if (e02 != null && (P = e02.P()) != null) {
                        int size = P.size();
                        int i5 = -1;
                        for (int i6 = 0; i6 < size; i6++) {
                            if (P.get(i6) != null && P.get(i6).getType() == 8) {
                                i5++;
                                if (!P.get(i6).V().O().equals(str) && !P.get(i6).V().P().equals(str)) {
                                    if (i5 > i3) {
                                        break;
                                    }
                                } else {
                                    int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                                    int width = P.get(i6).V().getWidth() * equipmentDensity;
                                    int height = P.get(i6).V().getHeight() * equipmentDensity;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.A2 = i6;
                                    return e02;
                                }
                            }
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return (TbRichText) invokeLLI.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        rk9 rk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            u9a.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!bi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.A0.s1().l());
                statisticItem.param("tid", this.A0.M1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.r && this.I0 != null) {
                this.r = true;
            }
            PbModel pbModel = this.A0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.A0.destory();
                if (this.A0.o1() != null) {
                    this.A0.o1().d();
                }
            }
            qj5 qj5Var = this.X0;
            if (qj5Var != null) {
                qj5Var.E();
                this.X0 = null;
            }
            ForumManageModel forumManageModel = this.D0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.Q;
            if (likeModel != null) {
                likeModel.b0();
            }
            ci9 ci9Var = this.I0;
            if (ci9Var != null) {
                ci9Var.A2();
                rk9 rk9Var2 = this.I0.k;
                if (rk9Var2 != null) {
                    rk9Var2.r();
                }
            }
            or5 or5Var = this.s;
            if (or5Var != null) {
                or5Var.c();
            }
            jj9 jj9Var = this.e;
            if (jj9Var != null) {
                jj9Var.k();
            }
            ag<TextView> agVar = this.y;
            if (agVar != null) {
                agVar.c();
            }
            ag<FestivalTipView> agVar2 = this.H;
            if (agVar2 != null) {
                agVar2.c();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            ci9 ci9Var2 = this.I0;
            if (ci9Var2 != null) {
                ci9Var2.F0();
            }
            if (this.X1 != null) {
                SafeHandler.getInst().removeCallbacks(this.X1);
            }
            yy4.a().d(this.z0);
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.b2);
            MessageManager.getInstance().unRegisterListener(this.i1);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().unRegisterListener(this.d2);
            MessageManager.getInstance().unRegisterListener(this.f2);
            MessageManager.getInstance().unRegisterListener(this.L1);
            MessageManager.getInstance().unRegisterListener(this.M1);
            MessageManager.getInstance().unRegisterListener(this.p2);
            MessageManager.getInstance().unRegisterListener(this.K1);
            MessageManager.getInstance().unRegisterListener(this.O1);
            MessageManager.getInstance().unRegisterListener(this.F1);
            MessageManager.getInstance().unRegisterListener(this.G1);
            MessageManager.getInstance().unRegisterListener(this.e2);
            this.g1 = null;
            this.h1 = null;
            LocationCacheData.getInstance().saveAspShowInfoInSharePref();
            if (this.j1 != null) {
                SafeHandler.getInst().removeCallbacks(this.j1);
            }
            ci9 ci9Var3 = this.I0;
            if (ci9Var3 != null && (rk9Var = ci9Var3.k) != null) {
                rk9Var.k();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.H0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            fi9 fi9Var = this.M0;
            if (fi9Var != null) {
                fi9Var.j();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.A0;
            if (pbModel2 != null && pbModel2.F0() != null) {
                this.A0.F0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.Z0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            ci9 ci9Var4 = this.I0;
            if (ci9Var4 != null) {
                ci9Var4.I4();
            }
            xj9 xj9Var = this.u0;
            if (xj9Var != null) {
                xj9Var.e();
            }
        }
    }

    public final void q5(ForumManageModel.b bVar, boolean z3) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048732, this, bVar, z3) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i3 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                m45 m45Var = new m45(getPageContext().getPageActivity());
                m45Var.setMessage(string);
                m45Var.setPositiveButton(R.string.dialog_known, new a2(this));
                m45Var.setCancelable(true);
                m45Var.create(getPageContext());
                m45Var.show();
            } else if (bVar.d != 0) {
                this.I0.O0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i4 = bVar.d;
                if (i4 == 1) {
                    ArrayList<rba> F = this.A0.s1().F();
                    int size = F.size();
                    while (true) {
                        if (i3 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i3).S())) {
                            F.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                    this.A0.s1().O().setReply_num(this.A0.s1().O().getReply_num() - 1);
                    this.I0.d2(this.A0.s1());
                } else if (i4 == 0) {
                    h5();
                } else if (i4 == 2) {
                    ArrayList<rba> F2 = this.A0.s1().F();
                    int size2 = F2.size();
                    boolean z4 = false;
                    for (int i5 = 0; i5 < size2 && !z4; i5++) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= F2.get(i5).i0().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i5).i0().get(i6).S())) {
                                F2.get(i5).i0().remove(i6);
                                F2.get(i5).h();
                                z4 = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                        F2.get(i5).i(bVar.g);
                    }
                    if (z4) {
                        this.I0.d2(this.A0.s1());
                    }
                    j5(bVar, this.I0);
                }
            }
        }
    }

    public void u6() {
        PbModel pbModel;
        td9 s12;
        ThreadData O;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        td9 td9Var;
        boolean z8;
        boolean z9;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048746, this) == null) && (pbModel = this.A0) != null && pbModel.s1() != null && (O = (s12 = this.A0.s1()).O()) != null && O.getAuthor() != null) {
            this.I0.I1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
            mh9 mh9Var = new mh9();
            int W = this.A0.s1().W();
            if (W != 1 && W != 3) {
                mh9Var.g = false;
            } else {
                mh9Var.g = true;
                if (O.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                mh9Var.s = z3;
            }
            if (bi9.z(this.A0.s1(), W)) {
                mh9Var.h = true;
                if (O.getIs_good() == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                mh9Var.r = z9;
            } else {
                mh9Var.h = false;
            }
            if (W == 1002 && !equals) {
                mh9Var.u = true;
            }
            mh9Var.n = bi9.K(O.isBlocked(), s12.n0(), equals, W, O.isWorksInfo(), O.isScoreThread());
            mh9Var.e = bi9.I(s12, equals, s12.n0(), this.A0.V());
            mh9Var.i = Y6();
            mh9Var.f = bi9.J(this.A0.s1(), equals, this.A0.V());
            if (equals && s12.V() != null && s12.V().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            mh9Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                mh9Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            mh9Var.t = equals;
            mh9Var.q = this.A0.L1();
            mh9Var.b = true;
            mh9Var.a = bi9.C(this.A0.s1(), equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            mh9Var.p = z5;
            mh9Var.j = true;
            mh9Var.o = this.A0.V0();
            mh9Var.d = true;
            if (O.getThreadVideoInfo() == null) {
                z6 = true;
            } else {
                z6 = false;
            }
            mh9Var.c = z6;
            if (s12.j0()) {
                mh9Var.b = false;
                mh9Var.d = false;
                mh9Var.c = false;
                mh9Var.g = false;
                mh9Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !s12.j0()) {
                z7 = true;
            } else {
                z7 = false;
            }
            mh9Var.v = z7;
            if (this.I0 != null && (td9Var = this.A0.G) != null) {
                rba X = td9Var.X();
                if (X != null) {
                    z8 = X.f1156T;
                } else {
                    z8 = false;
                }
                mh9Var.w = z8;
            }
            mh9Var.m = true;
            if (O.isBlocked()) {
                mh9Var.n = false;
                mh9Var.g = false;
                mh9Var.h = false;
            }
            this.I0.k.x(mh9Var);
        }
    }

    public final void x6(String str, int i3, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048754, this, str, i3, eVar) != null) || eVar == null) {
            return;
        }
        td9 s12 = this.A0.s1();
        TbRichText v7 = v7(str, i3);
        if (v7 == null || (tbRichTextData = v7.P().get(this.A2)) == null) {
            return;
        }
        eVar.f = String.valueOf(v7.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z3 = false;
        if (!tbRichTextData.V().T()) {
            eVar.h = false;
            String a4 = ud9.a(tbRichTextData);
            eVar.a.add(a4);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                if (this.q) {
                    i5 = 17;
                } else {
                    i5 = 18;
                }
                imageUrlData.urlType = i5;
            }
            imageUrlData.urlThumbType = imageUrlData.urlType;
            imageUrlData.imageThumbUrl = imageUrlData.imageUrl;
            imageUrlData.originalUrl = bi9.n(tbRichTextData);
            imageUrlData.originalUrl = bi9.n(tbRichTextData);
            imageUrlData.originalSize = bi9.o(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = bi9.k(tbRichTextData);
            imageUrlData.isLongPic = bi9.j(tbRichTextData);
            imageUrlData.postId = v7.getPostId();
            imageUrlData.mIsReserver = this.A0.E1();
            imageUrlData.mIsSeeHost = this.A0.V0();
            eVar.b.put(a4, imageUrlData);
            if (s12 != null) {
                if (s12.k() != null) {
                    eVar.c = s12.k().getName();
                    eVar.d = s12.k().getId();
                }
                if (s12.O() != null) {
                    eVar.e = s12.O().getId();
                }
                if (s12.r() == 1) {
                    z3 = true;
                }
                eVar.g = z3;
            }
            imageUrlData.threadId = JavaTypesHelper.toLong(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = s12.F().size();
        this.C2 = false;
        eVar.j = -1;
        if (s12.i() != null) {
            i4 = A5(s12.i().e0(), v7, i3, i3, eVar.a, eVar.b);
        } else {
            i4 = i3;
        }
        int i6 = i4;
        for (int i7 = 0; i7 < size; i7++) {
            rba rbaVar = s12.F().get(i7);
            if (rbaVar.S() == null || s12.i() == null || s12.i().S() == null || !rbaVar.S().equals(s12.i().S())) {
                i6 = A5(rbaVar.e0(), v7, i6, i3, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (s12 != null) {
            if (s12.k() != null) {
                eVar.c = s12.k().getName();
                eVar.d = s12.k().getId();
            }
            if (s12.O() != null) {
                eVar.e = s12.O().getId();
            }
            if (s12.r() == 1) {
                z3 = true;
            }
            eVar.g = z3;
        }
        eVar.j = i6;
    }
}
