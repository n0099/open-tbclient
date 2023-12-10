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
import com.baidu.tbadk.core.util.BdToastHelper;
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
import com.baidu.tbadk.core.view.NavigationBar;
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
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.PbNewEditorTool;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.mutiprocess.ResponsedEventListener;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
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
import com.baidu.tieba.a3a;
import com.baidu.tieba.a75;
import com.baidu.tieba.ah5;
import com.baidu.tieba.aiapps.TbAiappsLaunchUtil;
import com.baidu.tieba.aw4;
import com.baidu.tieba.aw6;
import com.baidu.tieba.aw9;
import com.baidu.tieba.b06;
import com.baidu.tieba.b0a;
import com.baidu.tieba.b3a;
import com.baidu.tieba.bh5;
import com.baidu.tieba.br6;
import com.baidu.tieba.bw9;
import com.baidu.tieba.c6a;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cp5;
import com.baidu.tieba.cx4;
import com.baidu.tieba.d1a;
import com.baidu.tieba.d4a;
import com.baidu.tieba.dga;
import com.baidu.tieba.dh5;
import com.baidu.tieba.e5a;
import com.baidu.tieba.e5b;
import com.baidu.tieba.eh5;
import com.baidu.tieba.ewa;
import com.baidu.tieba.f05;
import com.baidu.tieba.f1a;
import com.baidu.tieba.f4a;
import com.baidu.tieba.fa8;
import com.baidu.tieba.fd5;
import com.baidu.tieba.fh5;
import com.baidu.tieba.fp5;
import com.baidu.tieba.fu9;
import com.baidu.tieba.fy9;
import com.baidu.tieba.g05;
import com.baidu.tieba.g4a;
import com.baidu.tieba.h5b;
import com.baidu.tieba.he5;
import com.baidu.tieba.hh5;
import com.baidu.tieba.hj5;
import com.baidu.tieba.hu9;
import com.baidu.tieba.i5a;
import com.baidu.tieba.i6a;
import com.baidu.tieba.j4a;
import com.baidu.tieba.jr4;
import com.baidu.tieba.jx9;
import com.baidu.tieba.jy4;
import com.baidu.tieba.k4a;
import com.baidu.tieba.l05;
import com.baidu.tieba.l0a;
import com.baidu.tieba.l55;
import com.baidu.tieba.ld5;
import com.baidu.tieba.ll6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.lu4;
import com.baidu.tieba.lw4;
import com.baidu.tieba.ly4;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mwa;
import com.baidu.tieba.n05;
import com.baidu.tieba.n1a;
import com.baidu.tieba.np5;
import com.baidu.tieba.nt5;
import com.baidu.tieba.nwa;
import com.baidu.tieba.o05;
import com.baidu.tieba.o1a;
import com.baidu.tieba.o95;
import com.baidu.tieba.oo4;
import com.baidu.tieba.p05;
import com.baidu.tieba.p4a;
import com.baidu.tieba.p55;
import com.baidu.tieba.pb;
import com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.controller.PbGodGuideController;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.push.PbReplyPushGuide;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pi;
import com.baidu.tieba.po4;
import com.baidu.tieba.pp5;
import com.baidu.tieba.push.PushGuideManager;
import com.baidu.tieba.pw9;
import com.baidu.tieba.q3a;
import com.baidu.tieba.q4a;
import com.baidu.tieba.qb;
import com.baidu.tieba.qd5;
import com.baidu.tieba.qdb;
import com.baidu.tieba.qe5;
import com.baidu.tieba.qua;
import com.baidu.tieba.qv4;
import com.baidu.tieba.qw9;
import com.baidu.tieba.qz9;
import com.baidu.tieba.r1a;
import com.baidu.tieba.r4a;
import com.baidu.tieba.r6a;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.rd;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.tieba.rh5;
import com.baidu.tieba.rz4;
import com.baidu.tieba.s4a;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.sh5;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.so5;
import com.baidu.tieba.sw9;
import com.baidu.tieba.t1a;
import com.baidu.tieba.t4a;
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
import com.baidu.tieba.te5;
import com.baidu.tieba.th5;
import com.baidu.tieba.ti;
import com.baidu.tieba.tp5;
import com.baidu.tieba.twa;
import com.baidu.tieba.tx4;
import com.baidu.tieba.tx9;
import com.baidu.tieba.u1a;
import com.baidu.tieba.u2a;
import com.baidu.tieba.u45;
import com.baidu.tieba.ue5;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.ux9;
import com.baidu.tieba.uxa;
import com.baidu.tieba.uy4;
import com.baidu.tieba.uy5;
import com.baidu.tieba.v0a;
import com.baidu.tieba.v2a;
import com.baidu.tieba.vb5;
import com.baidu.tieba.ve5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vz9;
import com.baidu.tieba.w4;
import com.baidu.tieba.x0a;
import com.baidu.tieba.xo5;
import com.baidu.tieba.xoa;
import com.baidu.tieba.xx9;
import com.baidu.tieba.xy5;
import com.baidu.tieba.y05;
import com.baidu.tieba.y2a;
import com.baidu.tieba.y95;
import com.baidu.tieba.yb5;
import com.baidu.tieba.z95;
import com.baidu.tieba.zv6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.SmartApp;
import tbclient.SpriteMemeInfo;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class PbFragment extends BaseFragment implements xy5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, f05.e, TbRichTextView.t, TbPageContextSupport, i6a, r6a.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k T2;
    public static final aw6.b U2;
    public transient /* synthetic */ FieldHolder $fh;
    public pb<ImageView> A;
    public lu4.d A0;
    public CustomMessageListener A1;
    public boolean A2;
    public pb<View> B;
    public PbModel B0;
    public CustomMessageListener B1;
    public final BdListView.p B2;
    public pb<TiebaPlusRecommendCard> C;
    public i5a C0;
    public CustomMessageListener C1;
    public final TbRichTextView.z C2;
    public pb<LinearLayout> D;
    public jr4 D0;
    public CustomMessageListener D1;
    public nwa D2;
    public pb<RelativeLayout> E;
    public ForumManageModel E0;
    public CustomMessageListener E1;
    public final g05.c E2;
    public pb<ItemCardView> F;
    public sw9 F0;
    public final CustomMessageListener F1;
    public final g05.c F2;
    @NonNull
    public PbGodGuideController G;
    public PollingModel G0;
    public CustomMessageListener G1;
    public final AdapterView.OnItemClickListener G2;
    public pb<FestivalTipView> H;
    public ShareSuccessReplyToServerModel H0;
    public CustomMessageListener H1;
    public final View.OnLongClickListener H2;
    public boolean I;
    public o1a I0;
    public View.OnClickListener I1;
    public final View.OnClickListener I2;
    public boolean J;
    public boolean J0;
    public CustomMessageListener J1;
    public final ItemCardHelper.c J2;
    public boolean K;
    public boolean K0;
    public CustomMessageListener K1;
    public final NoNetworkView.b K2;
    public pb<GifView> L;
    public boolean L0;
    public CustomMessageListener L1;
    public View.OnTouchListener L2;
    public String M;
    public r1a M0;
    public CustomMessageListener M1;
    public zv6.b M2;
    public boolean N;
    public n05 N0;
    public CustomMessageListener N1;
    public final b0a.b N2;
    public boolean O;
    public p05 O0;
    public SuggestEmotionModel.c O1;
    public int O2;
    public String P;
    public String P0;
    public CustomMessageListener P1;
    public int P2;
    public LikeModel Q;
    public boolean Q0;
    public GetSugMatchWordsModel.b Q1;
    public String Q2;
    public View R;
    public boolean R0;
    public PraiseModel R1;
    public cx4 R2;
    public View S;
    public boolean S0;
    public b3a.h S1;
    public int S2;

    /* renamed from: T  reason: collision with root package name */
    public View f1134T;
    public String T0;
    public CustomMessageListener T1;
    public View U;
    public boolean U0;
    public ResponsedEventListener U1;
    public String V;
    public boolean V0;
    public ResponsedEventListener V1;
    public int W;
    public ewa W0;
    public CheckRealNameModel.b W1;
    public boolean X;
    public fh5 X0;
    public ux9 X1;
    public int[] Y;
    public eh5 Y0;
    public final Runnable Y1;
    public int Z;
    public PermissionJudgePolicy Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public int a0;
    public ReplyPrivacyCheckController a1;
    public CustomMessageListener a2;
    public boolean b;
    public int b0;
    public s4a b1;
    public CustomMessageListener b2;
    public boolean c;
    public uy4 c0;
    public bh5 c1;
    public CustomMessageListener c2;
    public aw6 d;
    public BdUniqueId d0;
    public ah5 d1;
    public CustomMessageListener d2;
    public b3a e;
    public u45 e0;
    public ah5 e1;
    public CustomMessageListener e2;
    public boolean f;
    public boolean f0;
    public int f1;
    public jx9 f2;
    public boolean g;
    public boolean g0;
    public Object g1;
    public CustomMessageListener g2;
    public boolean h;
    public Object h0;
    public BdPageContext h1;
    public CustomMessageListener h2;
    public VoiceManager i;
    public AgreeMessageData i0;
    public l55 i1;
    public f05.e i2;
    public int j;
    public vb5 j0;
    public BdUniqueId j1;
    public k3 j2;
    public g05 k;
    public Runnable k1;
    public p05.f k2;
    public long l;
    public t1a l1;
    public final SortSwitchButton.f l2;
    public long m;
    public BdImage m1;
    public final View.OnClickListener m2;
    public long n;
    public String n1;
    public CustomMessageListener n2;
    public long o;
    public TbRichTextImageInfo o1;
    public final NewWriteModel.d o2;
    public long p;
    public TbRichTextMemeInfo p1;
    public Boolean p2;
    public boolean q;
    public boolean q1;
    public NewWriteModel.d q2;
    public boolean r;
    public boolean r0;
    public int r1;
    public NetMessageListener r2;
    public np5 s;
    public boolean s0;
    public int s1;
    public final PbModel.h s2;
    public long t;
    @NonNull
    public TiePlusEventController.g t0;
    public List<i3> t1;
    public CustomMessageListener t2;
    public boolean u;
    public q3a u0;
    public int u1;
    public HttpMessageListener u2;
    public long v;
    public PushPermissionController v0;
    public ll6 v1;
    public final jr4.a v2;
    public int w;
    public boolean w0;
    public final i3 w1;
    public final AbsListView.OnScrollListener w2;
    public String x;
    public PbInterviewStatusView.f x0;
    public final v0a.b x1;
    public final w4 x2;
    public pb<TextView> y;
    public final Handler y0;
    public final CustomMessageListener y1;
    public final p55.g y2;
    public pb<TbImageView> z;
    public lu4.d z0;
    public CustomMessageListener z1;
    public final View.OnClickListener z2;

    /* loaded from: classes7.dex */
    public interface i3 {
        boolean onBackPressed();
    }

    /* loaded from: classes7.dex */
    public interface k3 {
        void callback(Object obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView V1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public void Y1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048658, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.i6a
    public AbsVideoPbFragment h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return null;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048748, this, view2, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048773, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i6a
    public PbFragment v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048781, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public void w0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048786, this, context, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a2 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ a2 b;

            public a(a2 a2Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a2Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = a2Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.I0 != null && this.a != null) {
                    this.b.a.I0.S2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements f05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(a2 a2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements f05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a2 a;

            public c(a2 a2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = a2Var;
            }

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                    r4a.a(this.a.a.getPageContext());
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, o95 o95Var, WriteData writeData, AntiData antiData) {
            aw9 s1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, o95Var, writeData, antiData}) == null) {
                if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.B0 != null && this.a.B0.s1() != null) {
                        statisticItem.param("fid", this.a.B0.s1().o());
                    }
                    if (this.a.B0 != null) {
                        statisticItem.param("tid", this.a.B0.M1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                ForumData forumData = null;
                if (z) {
                    if (this.a.Z6()) {
                        this.a.J8(false);
                        fu9.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14d2));
                    }
                    r1a r1aVar = this.a.M0;
                    if (r1aVar != null) {
                        r1aVar.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        yb5.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        a75.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.D7()) {
                        this.a.p9();
                    }
                    if (this.a.B0 != null && (s1 = this.a.B0.s1()) != null) {
                        forumData = s1.n();
                    }
                    this.a.Y8(new PbReplyPushGuide.Extra(writeData, forumData));
                    return;
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                }
                if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.a1;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (rd.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                    } else {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    f05 f05Var = new f05(this.a.getActivity());
                    if (rd.isEmpty(postWriteCallBackData.getErrorString())) {
                        f05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        f05Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new b(this));
                    f05Var.setPositiveButton(R.string.open_now, new c(this));
                    f05Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbFragment pbFragment = this.a;
                    if (pbFragment.M0 != null) {
                        if (pbFragment.I0 != null && this.a.I0.k1() != null && this.a.I0.k1().f() != null && this.a.I0.k1().f().A()) {
                            this.a.I0.k1().f().x(postWriteCallBackData);
                        }
                        this.a.M0.l(postWriteCallBackData);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r2 implements ShareSuccessReplyToServerModel.b {
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
            public final /* synthetic */ r2 b;

            public a(r2 r2Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r2Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = r2Var;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    xx9.a(this.b.a.getPageContext(), this.a).show();
                }
            }
        }

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

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                SafeHandler.getInst().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x1 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ x1 b;

            public a(x1 x1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {x1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = x1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.I0 != null && this.a != null) {
                    this.b.a.I0.S2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements f05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(x1 x1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {x1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements f05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ x1 a;

            public c(x1 x1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {x1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = x1Var;
            }

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                    r4a.a(this.a.a.getPageContext());
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, o95 o95Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            aw9 s1;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, o95Var, writeData, antiData}) == null) {
                if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.B0.s1() != null) {
                        statisticItem.param("fid", this.a.B0.s1().o());
                    }
                    statisticItem.param("tid", this.a.B0.M1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (rd.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.i9();
                this.a.I0.H3(z, postWriteCallBackData);
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
                    SafeHandler.getInst().postDelayed(this.a.Y1, 300000L);
                }
                ForumData forumData = null;
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.Y0 != null && (this.a.Y0.B() || this.a.Y0.D())) {
                            this.a.Y0.z(false, postWriteCallBackData);
                        }
                        this.a.M0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.a1;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (rd.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        f05 f05Var = new f05(this.a.getActivity());
                        if (rd.isEmpty(postWriteCallBackData.getErrorString())) {
                            f05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            f05Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new b(this));
                        f05Var.setPositiveButton(R.string.open_now, new c(this));
                        f05Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (o95Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.Q8(i, antiData, str);
                        return;
                    }
                }
                this.a.b9(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.R8(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData != null && writeData.getType() == 2) {
                    if (floor != null) {
                        this.a.I0.Y1(this.a.B0.s1());
                    }
                } else if (this.a.B0.V0()) {
                    aw9 s12 = this.a.B0.s1();
                    if (s12 != null && s12.R() != null && s12.R().getAuthor() != null && (userId = s12.R().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.B0.h3()) {
                        this.a.I0.J3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.B0.h3()) {
                    this.a.I0.J3();
                }
                if (this.a.B0.Z0()) {
                    c6a.t("c10369", this.a.B0.M1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.B0 != null) {
                    Context context = this.a.getContext();
                    aw9 s13 = this.a.B0.s1();
                    String forumId = this.a.B0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    n1a.a(context, s13, forumId, z2, this.a.B0.y1(), this.a.B0.B1(), this.a.B0.A1(), this.a.B0.z1(), this.a.B0.F1(), this.a.B0.G1());
                }
                if (writeData != null) {
                    a75.b(writeData.getContent(), "1");
                }
                if (this.a.D7()) {
                    this.a.p9();
                }
                if (this.a.B0 != null && (s1 = this.a.B0.s1()) != null) {
                    forumData = s1.n();
                }
                this.a.Y8(new PbReplyPushGuide.Extra(writeData, forumData));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y1 implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dga a;
        public final /* synthetic */ PbFragment b;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ y1 a;

            public a(y1 y1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {y1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = y1Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    new dga.b(this.a.b.getPageContext(), this.a.a).a();
                    this.a.b.g8();
                }
            }
        }

        public y1(PbFragment pbFragment, dga dgaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, dgaVar};
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
            this.a = dgaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbFragment pbFragment = this.b;
                pbFragment.j0 = PushOpenUtil.showPushOpenView(pbFragment.getPageContext(), this.a.h(), 0L);
                if (this.b.j0 != null) {
                    this.b.j0.v(new a(this));
                    this.a.g();
                    return null;
                }
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class z1 implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dga a;
        public final /* synthetic */ PbFragment b;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ z1 a;

            public a(z1 z1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {z1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = z1Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    new dga.b(this.a.b.getPageContext(), this.a.a).a();
                    this.a.b.g8();
                }
            }
        }

        public z1(PbFragment pbFragment, dga dgaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, dgaVar};
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
            this.a = dgaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbFragment pbFragment = this.b;
                pbFragment.j0 = PushOpenUtil.showPushOpenView(pbFragment.getPageContext(), this.a.h(), 0L);
                if (this.b.j0 != null) {
                    this.b.j0.v(new a(this));
                    this.a.g();
                    return null;
                }
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                PbFragment pbFragment = this.a;
                pbFragment.b = true;
                return pbFragment.z6(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getResultData() instanceof String)) {
                new BdTopToast(this.a.getContext()).setIcon(false).setContent((String) customResponsedMessage.getResultData()).show((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a1 implements g05.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public a1(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.g05.c
        public void a(g05 g05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, g05Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.P0 = pbFragment.P0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.P0);
                    new qz9(this.a.B0.M1(), this.a.P0, "1").start();
                    g05Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.P0 = pbFragment2.P0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.P0);
                    new qz9(this.a.B0.M1(), this.a.P0, "2").start();
                    g05Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.P0 = pbFragment3.P0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.P0);
                    g05Var.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a3 implements qb<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
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
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
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
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public b(PbFragment pbFragment) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921658) {
                int error = customResponsedMessage.getError();
                if (!(customResponsedMessage.getData() instanceof Boolean)) {
                    return;
                }
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (error != 0 || !booleanValue || !TbadkCoreApplication.isLogin() || this.a.D0 == null || this.a.D0.e()) {
                    return;
                }
                this.a.V7();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b1 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b2 extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b2(PbFragment pbFragment, int i, int i2) {
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
            PbThreadPostView r1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null && (responsedMessage instanceof ThreadPublishHttpResMeesage) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                    if (this.a.I0 != null && (r1 = this.a.I0.r1()) != null && this.a.I0.Z0() != null) {
                        this.a.I0.Z0().removeHeaderView(r1);
                        return;
                    }
                    return;
                }
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b3 implements qb<ItemCardView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
        }

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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ ItemCardView c(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            h(itemCardView2);
            return itemCardView2;
        }

        public ItemCardView e(ItemCardView itemCardView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, itemCardView)) == null) {
                itemCardView.M();
                return itemCardView;
            }
            return (ItemCardView) invokeL.objValue;
        }

        public ItemCardView h(ItemCardView itemCardView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, itemCardView)) == null) {
                itemCardView.N();
                return itemCardView;
            }
            return (ItemCardView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
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
    public class c implements ItemCardHelper.c {
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
    public class c0 implements View.OnClickListener {
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
    public class c1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c1(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.j1) {
                this.a.I0.C1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                aw9 s1 = this.a.B0.s1();
                if (s1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    s1.y().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.i1.d(this.a.h1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.h1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.d9(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (rd.isEmpty(errorString2)) {
                        errorString2 = this.a.h1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.i1.c(errorString2);
                } else {
                    this.a.V8();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c2 implements lu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.lu4.d
        @NonNull
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "pbPage.botFeedbackSubmit" : (String) invokeV.objValue;
        }

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

        @Override // com.baidu.tieba.lu4.c
        public void a(@NonNull String str) {
            String optString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("PbFragment", "收到H5通知，bot正负反馈浮窗提交监听：" + str);
                try {
                    try {
                        optString = new JSONObject(str).optString("postId", str);
                    } catch (Exception e) {
                        TbLog defaultLog2 = DefaultLog.getInstance();
                        defaultLog2.i("PbFragment", "bot正负反馈浮窗提交解析失败" + e);
                    }
                    if (this.a.D2 != null && TextUtils.equals(this.a.D2.U(), optString)) {
                        if (this.a.D2.t() != null) {
                            BdToastHelper.toast(qdb.a(this.a.D2.t().feedback_toast));
                        }
                    }
                } finally {
                    this.a.D2 = null;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c3 implements TbRichTextView.z {
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

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            int d;
            vz9 G0;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.I0.x2((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    if (z2) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    c6a.J(3, i2, this.a.B0);
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
                    d1a.e(this.a.B0, str, i, eVar);
                    if (this.a.B0.G.a()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view2.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view2.getParent();
                        } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                        }
                        int i5 = -1;
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().S() != null) {
                            ArrayList<TbRichTextImageInfo> S = tbRichTextView.getRichText().S();
                            int i6 = 0;
                            int i7 = -1;
                            while (i6 < S.size()) {
                                if (S.get(i6) != null) {
                                    arrayList.add(S.get(i6).U());
                                    if (i7 == i5 && str != null && (str.equals(S.get(i6).U()) || str.equals(S.get(i6).Q()) || str.equals(S.get(i6).O()) || str.equals(S.get(i6).P()) || str.equals(S.get(i6).S()))) {
                                        i7 = i6;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    String U = S.get(i6).U();
                                    imageUrlData.imageUrl = U;
                                    imageUrlData.imageThumbUrl = U;
                                    if (this.a.q) {
                                        i4 = 17;
                                    } else {
                                        i4 = 18;
                                    }
                                    imageUrlData.urlThumbType = i4;
                                    imageUrlData.originalUrl = S.get(i6).U();
                                    imageUrlData.isLongPic = S.get(i6).X();
                                    concurrentHashMap.put(S.get(i6).U(), imageUrlData);
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
                        this.a.P6(rect);
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.setData(arrayList).setIndex(i3).setIsCDN(false).setPostId(eVar.f).setIsReserve(this.a.B0.E1()).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false).setIsSeeHost(this.a.F7()).setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.B0 != null) {
                            builder.setFromForumId(this.a.B0.getFromForumId());
                            if (this.a.B0.s1() != null) {
                                builder.setThreadData(this.a.B0.s1().R());
                            }
                        }
                        ImageViewerConfig bulid = builder.bulid(this.a.getPageContext().getPageActivity());
                        bulid.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, bulid));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else if (!eVar.h) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        arrayList2.add((String) ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!ListUtils.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, eVar.b.get(str2));
                        }
                        ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                        builder2.setData(arrayList2).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.a.get(0)).setIsReserve(this.a.B0.E1()).setAssistUrls(concurrentHashMap2).setNeedBroadCaset(false).setIsSeeHost(this.a.F7()).setPostId(eVar.f).setBjhPostId(eVar.f).setIsCanDrag(false);
                        if (this.a.B0 != null) {
                            builder2.setFromForumId(this.a.B0.getFromForumId());
                            if (this.a.B0.s1() != null) {
                                builder2.setThreadData(this.a.B0.s1().R());
                            }
                        }
                        ImageViewerConfig bulid2 = builder2.bulid(this.a.getPageContext().getPageActivity());
                        bulid2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, bulid2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText f = d1a.f(this.a.B0, str, i);
                        if (f != null && (d = d1a.d()) >= 0 && d < f.Q().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = bw9.a(f.Q().get(d));
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
                            if (f.getPostId() != 0 && (G0 = this.a.I0.G0()) != null) {
                                ArrayList<pi> l = G0.l();
                                if (ListUtils.getCount(l) > 0) {
                                    Iterator<pi> it = l.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        pi next = it.next();
                                        if ((next instanceof nwa) && f.getPostId() == JavaTypesHelper.toLong(((nwa) next).U(), 0L)) {
                                            int i9 = 8;
                                            if (f.getPostId() == JavaTypesHelper.toLong(this.a.B0.Q0(), 0L)) {
                                                i9 = 1;
                                            }
                                            c6a.b(this.a.B0.s1(), (nwa) next, ((nwa) next).h0, i9, 3);
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
                            this.a.P6(rect2);
                            ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                            builder3.setData(arrayList3).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.i).setIsReserve(this.a.B0.E1()).setAssistUrls(concurrentHashMap3).setNeedBroadCaset(false).setIsSeeHost(this.a.F7()).setPostId(eVar.f).setBjhPostId(eVar.f).setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.B0 != null) {
                                builder3.setFromForumId(this.a.B0.getFromForumId());
                                if (this.a.B0.s1() != null) {
                                    builder3.setThreadData(this.a.B0.s1().R());
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
    public class d implements NoNetworkView.b {
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

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void p(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.f && z && !this.a.B0.h1()) {
                    this.a.y8();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0703c9));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof tx4)) {
                tx4 tx4Var = (tx4) customResponsedMessage.getData();
                ly4.a aVar = new ly4.a();
                int i = tx4Var.a;
                String str = tx4Var.b;
                aVar.a = tx4Var.d;
                aw9 s1 = this.a.B0.s1();
                if (s1 == null) {
                    return;
                }
                if (this.a.B0.U0() != null && this.a.B0.U0().getUserIdLong() == tx4Var.p) {
                    this.a.I0.Z2(tx4Var.l, this.a.B0.s1(), this.a.B0.L1(), this.a.B0.D1());
                }
                if (s1.I() != null && s1.I().size() >= 1 && s1.I().get(0) != null) {
                    long j = JavaTypesHelper.toLong(s1.I().get(0).U(), 0L);
                    long j2 = JavaTypesHelper.toLong(this.a.B0.M1(), 0L);
                    if (j == tx4Var.n && j2 == tx4Var.m) {
                        ly4 S = s1.I().get(0).S();
                        if (S == null) {
                            S = new ly4();
                        }
                        ArrayList<ly4.a> a = S.a();
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        a.add(0, aVar);
                        S.e(S.b() + tx4Var.l);
                        S.d(a);
                        s1.I().get(0).d1(S);
                        this.a.I0.G0().v();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d1(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.j1) {
                this.a.I0.C1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.i1.d(this.a.h1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (rd.isEmpty(muteMessage)) {
                    muteMessage = this.a.h1.getResources().getString(R.string.un_mute_fail);
                }
                this.a.i1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d2 implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, aw9 aw9Var, String str, int i4, boolean z2) {
            qe5 t;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), aw9Var, str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
                if (this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907f7));
                }
                if (!z || aw9Var == null || aw9Var.b0() != null || ListUtils.getCount(aw9Var.I()) >= 1) {
                    if (this.a.g0) {
                        if (this.a.l0() != null) {
                            this.a.l0().A0();
                        }
                    } else {
                        this.a.g0 = true;
                    }
                    this.a.g = true;
                    if (this.a.I0 == null) {
                        return;
                    }
                    this.a.I0.I3();
                    if (aw9Var == null || !aw9Var.t0()) {
                        PbFragment pbFragment = this.a;
                        pbFragment.hideLoadingView(pbFragment.I0.u1());
                    }
                    this.a.I0.E1();
                    if (this.a.J) {
                        this.a.I0.x1();
                    } else if (!this.a.I0.d2()) {
                        this.a.I0.X3(false);
                    }
                    if (this.a.h) {
                        this.a.h = false;
                    }
                    if (i4 == 0 && aw9Var != null) {
                        this.a.Q0 = true;
                    }
                    if (aw9Var != null) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.hideNetRefreshView(pbFragment2.I0.u1());
                        this.a.I0.U3();
                    }
                    String str2 = null;
                    if (z && aw9Var != null) {
                        ThreadData R = aw9Var.R();
                        if (R != null && R.isUgcThreadType()) {
                            d();
                        } else {
                            PbFragment pbFragment3 = this.a;
                            pbFragment3.M8(pbFragment3.X0);
                        }
                        this.a.I0.k1().r(aw9Var);
                        this.a.I0.d4();
                        if (R != null && R.getCartoonThreadData() != null) {
                            this.a.t9(R.getCartoonThreadData());
                        }
                        if (this.a.Y0 != null) {
                            this.a.I0.p3(this.a.Y0.C());
                        }
                        TbadkCoreApplication.getInst().setDefaultBubble(aw9Var.Y().getBimg_url());
                        TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(aw9Var.Y().getDynamicUrl());
                        TbadkCoreApplication.getInst().setDefaultBubbleEndTime(aw9Var.Y().getBimg_end_time());
                        if (aw9Var.I() == null || aw9Var.I().size() < 1 || aw9Var.I().get(0) == null) {
                            if (aw9Var.b0() != null) {
                                this.a.B0.Q2(aw9Var.b0().U());
                            }
                        } else {
                            this.a.B0.Q2(aw9Var.I().get(0).U());
                        }
                        if (this.a.Y0 != null) {
                            this.a.Y0.L(aw9Var.f());
                            this.a.Y0.M(aw9Var.n(), aw9Var.Y());
                            this.a.Y0.o0(R);
                            this.a.Y0.N(this.a.B0.U0(), this.a.B0.M1(), this.a.B0.Q0());
                            if (R != null) {
                                this.a.Y0.d0(R.isMutiForumThread());
                            }
                        }
                        if (this.a.D0 != null) {
                            this.a.D0.h(aw9Var.t());
                        }
                        this.a.q = aw9Var.u() == 1;
                        if (aw9Var.a()) {
                            this.a.q = true;
                        }
                        this.a.I0.q3(this.a.q);
                        if (this.a.u0.f.size() > 0) {
                            aw9Var.U0(this.a.u0.f);
                        }
                        this.a.I0.g4(aw9Var, i2, i3, this.a.B0.L1(), i4, this.a.B0.b1());
                        this.a.I0.u4(aw9Var, this.a.B0.L1());
                        this.a.I0.A4(this.a.B0.V0());
                        AntiData f = aw9Var.f();
                        if (f != null) {
                            this.a.x = f.getVoice_message();
                            if (!StringUtils.isNull(this.a.x) && this.a.Y0 != null && this.a.Y0.a() != null && (t = this.a.Y0.a().t(6)) != null && !TextUtils.isEmpty(this.a.x)) {
                                ((View) t).setOnClickListener(this.a.I1);
                            }
                        }
                        if (!z2 && !this.a.X && !ListUtils.isEmpty(this.a.B0.s1().I()) && !this.a.B0.h2()) {
                            this.a.X = true;
                            this.a.q6(false);
                        }
                        if (!TextUtils.isEmpty(this.a.T0)) {
                            PbFragment pbFragment4 = this.a;
                            n1a.B(pbFragment4, v2a.a(pbFragment4.B0), this.a.T0);
                            this.a.T0 = null;
                        } else if (this.a.S0) {
                            this.a.S0 = false;
                            if (this.a.i7() != null && this.a.i7().b1() != null && this.a.i7().b1().getVisibility() == 0 && this.a.i7().b1().getPlayerHeight() > 0) {
                                PbFragment pbFragment5 = this.a;
                                d4a.f(pbFragment5, pbFragment5.i7().b1().getPlayerHeight());
                            } else {
                                d4a.f(this.a, 0);
                            }
                        } else if (this.a.U0) {
                            this.a.U0 = false;
                            u2a.k(this.a.getListView());
                        } else if (!TextUtils.isEmpty(this.a.B0.i1())) {
                            u2a.f(this.a.getListView(), this.a.B0.i1());
                            this.a.B0.o2();
                        } else {
                            this.a.I0.c4();
                        }
                        this.a.B0.p2(aw9Var.n(), this.a.O1);
                        this.a.B0.t2(this.a.Q1);
                        if (this.a.a1 != null && R != null && R.getAuthor() != null) {
                            AttentionHostData attentionHostData = new AttentionHostData();
                            attentionHostData.parserWithMetaData(R.getAuthor());
                            this.a.a1.setLikeUserData(attentionHostData);
                        }
                        if (this.a.B0 != null && this.a.B0.d2()) {
                            str2 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                        } else if (this.a.I0 != null) {
                            str2 = this.a.I0.m1();
                        }
                        if (this.a.Y0 != null && !StringUtils.isNull(str2)) {
                            this.a.Y0.g0(TbSingleton.getInstance().getAdVertiComment(aw9Var.r0(), aw9Var.s0(), str2));
                        }
                        if (!this.a.Q0 && ((i2 == 1 || i2 == 2) && this.a.I0 != null)) {
                            this.a.I0.D0();
                        }
                    } else if (str != null) {
                        if (this.a.Q0 || i4 != 1) {
                            this.a.showToast(str);
                        } else if (i2 == 3 || i2 == 4 || i2 == 6 || i2 == 9) {
                            if (i != 4) {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.I0.u1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                xoa.a("pb", false);
                                if (this.a.u0() != null) {
                                    fp5.a.a(this.a.u0().getUniqueId(), new Pair<>(PushMessageHelper.ERROR_TYPE, "pb_page"), new Pair<>("error_info", "pb page net error2"));
                                }
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0703c9));
                            } else if (this.a.B0.H0() == null || StringUtils.isNull(this.a.B0.H0().c)) {
                                PbFragment pbFragment8 = this.a;
                                pbFragment8.showNetRefreshView(pbFragment8.I0.u1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                xoa.a("pb", false);
                                if (this.a.u0() != null) {
                                    fp5.a.a(this.a.u0().getUniqueId(), new Pair<>(PushMessageHelper.ERROR_TYPE, "pb_page"), new Pair<>("error_info", "pb page net error1"));
                                }
                                PbFragment pbFragment9 = this.a;
                                pbFragment9.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment9.getContext(), R.dimen.obfuscated_res_0x7f0703c9));
                            } else {
                                this.a.I0.C4(this.a.B0.H0());
                            }
                            this.a.I0.x1();
                            this.a.I0.w1();
                        }
                        if (i == 4 || i == 350008) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tid", this.a.B0.M1());
                                jSONObject.put("fid", this.a.B0.getForumId());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                            br6.b().c(new z95(this.a.B0.M1()));
                        }
                        if (i != 0) {
                            EnterForePvThread enterForePvThread = new EnterForePvThread();
                            enterForePvThread.setOpType("2");
                            enterForePvThread.start();
                        }
                        if (i != -1) {
                            ArrayList<nwa> I = (this.a.B0 == null || this.a.B0.s1() == null) ? null : this.a.B0.s1().I();
                            if (ListUtils.getCount(I) == 0 || (ListUtils.getCount(I) == 1 && I.get(0) != null && I.get(0).L() == 1)) {
                                if (this.a.F7()) {
                                    this.a.I0.m3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1037));
                                } else {
                                    this.a.I0.m3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1038));
                                }
                                this.a.I0.Y1(this.a.B0.s1());
                            } else {
                                this.a.I0.l3(this.a.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            this.a.I0.l3("");
                        }
                        this.a.I0.z0();
                    }
                    if (aw9Var != null && aw9Var.m && this.a.m == 0) {
                        this.a.m = System.currentTimeMillis() - this.a.l;
                    }
                    if (this.a.a instanceof PbActivity) {
                        ((PbActivity) this.a.a).c2(aw9Var != null ? aw9Var.i() : 0, this.a.I0);
                    }
                    if (this.a.B0 == null || this.a.B0.s1() == null) {
                        return;
                    }
                    this.a.B0.s1();
                    return;
                }
                this.a.B0.e3(1);
                if (this.a.e != null) {
                    this.a.e.x();
                }
                if (this.a.I0 != null) {
                    this.a.I0.n4();
                }
            }
        }

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

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(aw9 aw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aw9Var) == null) {
                this.a.I0.Y1(aw9Var);
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
            tp5 tp5Var = new tp5(i, z, responsedMessage, this.a.p, this.a.o, this.a.m, z2, 0L, 0L, j4);
            this.a.o = 0L;
            this.a.p = 0L;
            tp5Var.c();
            if (z2) {
                j3 = j4;
                tp5Var.B = j3;
                tp5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.B0 != null && this.a.B0.s1() != null && this.a.B0.s1().R() != null) {
                int threadType = this.a.B0.s1().R().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.M, "from_personalize")) {
                        pp5 pp5Var = new pp5();
                        pp5Var.F = 1;
                        pp5Var.a(1005);
                        pp5Var.D = j3;
                        pp5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.M, "from_frs")) {
                        tp5 tp5Var2 = new tp5();
                        tp5Var2.a(1000);
                        tp5Var2.D = j3;
                        tp5Var2.d(threadType);
                    }
                }
            }
        }

        public final void d() {
            Bundle extras;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.a.B0 == null) {
                return;
            }
            if (this.a.Y0 != null && this.a.Y0.t) {
                return;
            }
            dh5 dh5Var = new dh5();
            this.a.M8(dh5Var);
            PbFragment pbFragment = this.a;
            pbFragment.Y0 = (eh5) dh5Var.a(pbFragment.getContext());
            this.a.Y0.a0(this.a.a.getPageContext());
            this.a.Y0.j0(this.a.o2);
            this.a.Y0.k0(this.a.c1);
            eh5 eh5Var = this.a.Y0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
            if (this.a.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.a.getIntent().getExtras();
            }
            eh5Var.E(pageContext, extras);
            this.a.Y0.a().M(true);
            this.a.I0.k3(this.a.Y0.a());
            if (!this.a.B0.f1()) {
                this.a.Y0.t(this.a.B0.M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.Y0.g0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.B0.d2()) {
                this.a.Y0.g0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.I0 != null) {
                this.a.Y0.g0(this.a.I0.m1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d3 implements g05.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public d3(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.g05.c
        public void a(g05 g05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, g05Var, i, view2) == null) {
                if (g05Var != null) {
                    g05Var.e();
                }
                PbFragment pbFragment = this.a;
                nwa nwaVar = pbFragment.D2;
                if (nwaVar != null) {
                    if (i == 0) {
                        nwaVar.V0();
                        this.a.D2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.X7(pbFragment2.D2);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements qb<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
        }

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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
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
        @Override // com.baidu.tieba.qb
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
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b06)) {
                b06 b06Var = (b06) customResponsedMessage.getData();
                aw9 s1 = this.a.B0.s1();
                if (s1 == null) {
                    return;
                }
                if (this.a.B0.s1() != null && this.a.B0.s1().a0().u() != null && this.a.B0.s1().a0().u().getPortrait() != null && this.a.B0.s1().a0().u().getPortrait().equals(b06Var.a)) {
                    if (this.a.B0.s1().a0().u().getUserWorldCupData() != null) {
                        this.a.B0.s1().a0().u().getUserWorldCupData().c(b06Var.b);
                    }
                    this.a.I0.a3(this.a.B0.s1(), this.a.B0.L1(), this.a.B0.D1(), this.a.I0.p1());
                }
                if (s1.I() != null && s1.I().size() >= 0) {
                    Iterator<nwa> it = s1.I().iterator();
                    while (it.hasNext()) {
                        nwa next = it.next();
                        if (next != null && next.u() != null && next.u().getPortrait() != null && next.u().getPortrait().equals(b06Var.a) && next.u().getUserWorldCupData() != null) {
                            next.u().getUserWorldCupData().c(b06Var.b);
                        }
                    }
                    this.a.I0.G0().v();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e1(PbFragment pbFragment, int i) {
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
                if (!this.a.D7() || this.a.a == null || this.a.a.B1() == null || !str.equals(this.a.a.B1().getTopicId())) {
                    return;
                }
                this.a.q9(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e2 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e2(PbFragment pbFragment, int i) {
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
            this.a.s9();
        }
    }

    /* loaded from: classes7.dex */
    public class e3 implements g05.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public e3(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.g05.c
        public void a(g05 g05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, g05Var, i, view2) == null) {
                if (g05Var != null) {
                    g05Var.e();
                }
                if (this.a.m1 != null && !TextUtils.isEmpty(this.a.n1)) {
                    if (i == 0) {
                        if (this.a.p1 != null) {
                            hj5.a aVar = new hj5.a();
                            aVar.a = this.a.n1;
                            String str = "";
                            if (this.a.p1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.p1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        } else {
                            this.a.l6();
                        }
                    } else if (i == 1) {
                        if (this.a.Z0 == null) {
                            this.a.Z0 = new PermissionJudgePolicy();
                        }
                        this.a.Z0.clearRequestPermissionList();
                        this.a.Z0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.Z0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.l1 == null) {
                            PbFragment pbFragment = this.a;
                            pbFragment.l1 = new t1a(pbFragment.getPageContext());
                        }
                        this.a.l1.b(this.a.n1, this.a.m1.getImageByte());
                    }
                    this.a.m1 = null;
                    this.a.n1 = null;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnTouchListener {
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
    public class f0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.B0 != null && this.a.B0.s1() != null) {
                this.a.B0.s1().c();
                this.a.B0.X1();
                if (this.a.I0.G0() != null) {
                    this.a.I0.Y1(this.a.B0.s1());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f1(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof h5b) && customResponsedMessage.getOrginalMessage().getTag() == this.a.j1) {
                h5b h5bVar = (h5b) customResponsedMessage.getData();
                this.a.I0.C1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.g1;
                DataRes dataRes = h5bVar.a;
                boolean z = false;
                if (h5bVar.c == 0 && dataRes != null) {
                    int i = JavaTypesHelper.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (i == 1) {
                        z = true;
                    }
                    if (rd.isEmpty(str)) {
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
                        this.a.I0.O2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.W8(z, sparseArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f2 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f2(PbFragment pbFragment, int i, boolean z) {
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
                    pbFragment.hideLoadingView(pbFragment.I0.u1());
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
                    this.a.N8(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e70);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                new BdTopToast(this.a.getContext()).setIcon(false).setContent(errorString).show((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f3 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public f3(PbFragment pbFragment) {
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
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.B0 == null || this.a.B0.C1() == i + 1) {
                return;
            }
            this.a.H8(n1a.m(i));
        }
    }

    /* loaded from: classes7.dex */
    public class g implements zv6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.zv6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.zv6.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

        public g(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.zv6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.I0 != null && this.b.e != null) {
                this.b.e.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.e.l();
                }
                if (this.b.Y6()) {
                    this.b.I0.D1();
                    this.b.I0.i3();
                }
            }
        }

        @Override // com.baidu.tieba.zv6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.I0 != null && this.b.e != null) {
                this.b.I0.l4();
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
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(PbFragment pbFragment, int i) {
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
            mwa f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.B0 != null && this.a.B0.s1() != null) {
                String str = (String) customResponsedMessage.getData();
                mwa mwaVar = null;
                if (!TextUtils.isEmpty(str) && this.a.B0.s1().I() != null) {
                    ArrayList<nwa> I = this.a.B0.s1().I();
                    Iterator<nwa> it = I.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        nwa next = it.next();
                        if (next instanceof mwa) {
                            mwa mwaVar2 = (mwa) next;
                            if (str.equals(mwaVar2.I1())) {
                                mwaVar = mwaVar2;
                                break;
                            }
                        }
                    }
                    if (mwaVar != null) {
                        I.remove(mwaVar);
                    }
                }
                if (this.a.I0.G0() != null && !ListUtils.isEmpty(this.a.I0.G0().l())) {
                    ArrayList<pi> l = this.a.I0.G0().l();
                    if (mwaVar != null) {
                        f = mwaVar;
                    } else {
                        f = n1a.f(this.a.B0.s1(), str);
                    }
                    d4a.c(l, f);
                }
                if (this.a.I0.Z0() != null && !ListUtils.isEmpty(this.a.I0.Z0().getData())) {
                    List<pi> data = this.a.I0.Z0().getData();
                    if (mwaVar == null) {
                        mwaVar = n1a.f(this.a.B0.s1(), str);
                    }
                    d4a.c(data, mwaVar);
                }
                this.a.B6(str);
                this.a.B0.X1();
                if (this.a.I0.G0() != null) {
                    this.a.I0.G0().v();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g1() {
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
        public void onNavigationButtonClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g2 implements jr4.a {
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

        @Override // com.baidu.tieba.jr4.a
        public void a(boolean z, boolean z2, String str, @Nullable String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2}) == null) {
                this.a.I0.I3();
                if (z) {
                    if (this.a.D0 != null) {
                        this.a.D0.h(z2);
                    }
                    this.a.B0.g3(z2);
                    if (!this.a.B0.d1()) {
                        this.a.I0.Y1(this.a.B0.s1());
                    } else {
                        this.a.S7();
                    }
                    if (z2) {
                        boolean q0 = this.a.B0.s1().q0();
                        if (this.a.D0 != null && !q0) {
                            if (this.a.D0.f() != null && this.a.B0 != null && this.a.B0.s1() != null && this.a.B0.s1().R() != null && this.a.B0.s1().R().getAuthor() != null) {
                                MarkData f = this.a.D0.f();
                                MetaData author = this.a.B0.s1().R().getAuthor();
                                if (f != null && author != null) {
                                    if (str2 == null) {
                                        str2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0100);
                                    }
                                    BdUtilHelper.showToast(str2, 2000, true);
                                    this.a.Z8(this.a.B0.s1().R());
                                } else {
                                    if (str2 == null) {
                                        str2 = this.a.getPageContext().getString(R.string.add_mark);
                                    }
                                    BdUtilHelper.showToast(str2, 2000, true);
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.k6();
                        return;
                    }
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                PbFragment pbFragment2 = this.a;
                pbFragment2.showToast(pbFragment2.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g3 implements p05.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public g3(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.p05.d
        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.O0 != null) {
                this.a.O0.s(j4a.f(this.a.D2));
                ArrayList arrayList = new ArrayList();
                for (o05 o05Var : this.a.O0.h()) {
                    if (o05Var instanceof l05) {
                        arrayList.add((l05) o05Var);
                    }
                }
                j4a.d(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements aw6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
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

        @Override // com.baidu.tieba.aw6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    tx9.d();
                } else {
                    tx9.c();
                }
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
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.C6();
        }
    }

    /* loaded from: classes7.dex */
    public class h1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h1(PbFragment pbFragment, int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.I0.a2() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.H6((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    /* loaded from: classes7.dex */
    public class h2 implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public h2(PbFragment pbFragment) {
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
            ArrayList<nwa> I;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.B0 != null && this.a.B0.s1() != null && this.a.I0 != null && this.a.I0.G0() != null) {
                this.a.I0.H2(absListView, i, i2, i3);
                if (this.a.e != null) {
                    this.a.e.q(absListView, i, i2, i3);
                }
                if (this.a.B0.i2() && (I = this.a.B0.s1().I()) != null && !I.isEmpty()) {
                    int m = ((i + i2) - this.a.I0.G0().m()) - 1;
                    aw9 s1 = this.a.B0.s1();
                    if (s1 == null) {
                        return;
                    }
                    if (s1.F() != null && s1.F().H1()) {
                        m--;
                    }
                    if (s1.G() != null && s1.G().H1()) {
                        m--;
                    }
                    int size = I.size();
                    if (m < 0 || m >= size) {
                    }
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                if (!n1a.x(this.a.f1) && n1a.x(i)) {
                    if (this.a.I0 != null) {
                        this.a.r0 = true;
                        this.a.I0.s0();
                        if (this.a.Y0 != null && !this.a.I0.a2()) {
                            this.a.I0.p3(this.a.Y0.C());
                        }
                        if (!this.a.J) {
                            this.a.r0 = true;
                            this.a.I0.h3();
                        }
                    }
                    if (!this.a.r) {
                        this.a.r = true;
                    }
                }
                if (this.a.I0 != null) {
                    this.a.I0.I2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.s == null) {
                    this.a.s = new np5();
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
                this.a.f1 = i;
                if (i == 0) {
                    qua.g().h(this.a.getUniqueId(), true);
                    this.a.q6(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h3 implements ah5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public h3(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.ah5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                r1a r1aVar = this.a.M0;
                if (r1aVar != null && r1aVar.g() != null && this.a.M0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.M0.g().c());
                    if (this.a.I0 != null && this.a.I0.k1() != null && this.a.I0.k1().f() != null && this.a.I0.k1().f().A()) {
                        this.a.I0.k1().f().x(this.a.M0.h());
                    }
                    this.a.M0.b(true);
                    return true;
                }
                return !this.a.v6(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i implements b0a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.baidu.tieba.b0a.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f17d4);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e70);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.I0.q0(str);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i0 implements SuggestEmotionModel.c {
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

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void a(y2a y2aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, y2aVar) != null) || y2aVar == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, y2aVar.a()));
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
    public class i1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i1(PbFragment pbFragment, int i) {
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
                    this.a.I0.t2(agreeMessageData);
                }
                if (agreeData.agreeType == 2 && this.a.I0 != null && !t4a.g(this.a.B0.b)) {
                    this.a.I0.p4();
                    t4a.a(this.a.B0.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i2 implements Comparator<AdverSegmentData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public i2(PbFragment pbFragment) {
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
    public class j implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public j(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    f05Var.dismiss();
                    ((TbPageContext) this.a.h1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                f05Var.dismiss();
                r4a.a(this.a.getPageContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j0(PbFragment pbFragment, int i) {
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
                        this.a.g8();
                        return;
                    } else {
                        this.a.D8();
                        return;
                    }
                }
                this.a.r0 = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j1(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.i7() != null) {
                this.a.i7().D2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j2 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public j2(PbFragment pbFragment) {
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
        public void onNavigationButtonClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class j3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<o1a> a;
        public WeakReference<PbFragment> b;

        public j3(o1a o1aVar, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o1aVar, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(o1aVar);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                o1a o1aVar = this.a.get();
                if (o1aVar != null) {
                    o1aVar.C1();
                }
                PbFragment pbFragment = this.b.get();
                if (pbFragment != null && CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        pbFragment.c9(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        fa8.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0e70);
                        }
                        pbFragment.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements i3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public k(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.i3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.I0 != null && this.a.I0.k1() != null) {
                    l0a k1 = this.a.I0.k1();
                    if (k1.j()) {
                        k1.h();
                        return true;
                    }
                }
                if (this.a.I0 != null && this.a.I0.o2()) {
                    this.a.I0.G1();
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k0 implements PbInterviewStatusView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public k0(PbFragment pbFragment) {
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
                this.a.I0.r4(!this.a.N);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k1(PbFragment pbFragment, int i) {
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
                this.a.q1 = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k2 extends w4 {
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

        @Override // com.baidu.tieba.w4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, obj) != null) || !this.a.isAdded()) {
                return;
            }
            boolean z = false;
            if (obj != null) {
                switch (this.a.E0.getLoadDataMode()) {
                    case 0:
                        this.a.B0.X1();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.N6(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.I0.B0(1, dVar.a, dVar.b, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbFragment pbFragment = this.a;
                        pbFragment.O6(pbFragment.E0.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        this.a.I0.B0(this.a.E0.getLoadDataMode(), gVar.a, gVar.b, false);
                        this.a.I0.J2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.I0.B0(this.a.E0.getLoadDataMode(), false, null, false);
        }
    }

    /* loaded from: classes7.dex */
    public class l implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public l(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 implements GetSugMatchWordsModel.b {
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

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onSuccess(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && !ListUtils.isEmpty(list) && this.a.I0 != null) {
                this.a.I0.P3(list);
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
    public class l1 implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public l1(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                this.a.t7();
                jy4 q1 = this.a.B0.q1();
                int h1 = this.a.I0.h1();
                if (h1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f103a);
                } else if (q1 != null && h1 > q1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f103a);
                } else {
                    this.a.I0.s0();
                    this.a.i9();
                    this.a.I0.J3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.B0.e3(this.a.I0.h1());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e70);
                    }
                    f05Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l2 implements bh5 {
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

        @Override // com.baidu.tieba.bh5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public m(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements PraiseModel.b {
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

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.R1 != null && str != null) {
                if (AntiHelper.m(i, str)) {
                    AntiHelper.u(this.a.getPageContext().getPageActivity(), str);
                } else {
                    this.a.showToast(str);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void f(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || this.a.R1 == null) {
                return;
            }
            aw9 s1 = this.a.B0.s1();
            if (s1.R().getPraise().getIsLike() == 1) {
                this.a.u9(0);
            } else {
                this.a.u9(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, s1.R()));
        }
    }

    /* loaded from: classes7.dex */
    public class m1 implements k3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.k3
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
                String valueOf = String.valueOf(this.a.B0.s1().Y().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.B0.s1().n().getId(), this.a.B0.s1().n().getName(), this.a.B0.s1().R().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m2 implements f05.e {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) && f05Var != null) {
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ PbFragment b;

        public n(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                this.b.I0.e4();
                MessageManager.getInstance().sendMessage(this.a);
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements b3a.h {
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

        @Override // com.baidu.tieba.b3a.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.L8(z);
                if (this.a.I0.W0() != null && z) {
                    this.a.I0.r4(false);
                }
                this.a.I0.A2(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n1 implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                if (this.a.N0 != null) {
                    this.a.N0.dismiss();
                }
                this.a.r9(i);
                if (i != -4) {
                    if (i != -3) {
                        if (i != -2) {
                            if (i != -1) {
                                if (i != 13) {
                                    switch (i) {
                                        case 1:
                                            if (this.a.m1 != null && !TextUtils.isEmpty(this.a.n1)) {
                                                if (this.a.p1 != null) {
                                                    hj5.a aVar = new hj5.a();
                                                    aVar.a = this.a.n1;
                                                    String str = "";
                                                    if (this.a.p1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.p1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.l6();
                                                }
                                                this.a.m1 = null;
                                                this.a.n1 = null;
                                                return;
                                            }
                                            return;
                                        case 2:
                                            if (this.a.m1 != null && !TextUtils.isEmpty(this.a.n1)) {
                                                if (this.a.Z0 == null) {
                                                    this.a.Z0 = new PermissionJudgePolicy();
                                                }
                                                this.a.Z0.clearRequestPermissionList();
                                                this.a.Z0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                if (this.a.Z0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                                    return;
                                                }
                                                if (this.a.l1 == null) {
                                                    PbFragment pbFragment = this.a;
                                                    pbFragment.l1 = new t1a(pbFragment.getPageContext());
                                                }
                                                this.a.l1.b(this.a.n1, this.a.m1.getImageByte());
                                                this.a.m1 = null;
                                                this.a.n1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            nwa nwaVar = this.a.D2;
                                            if (nwaVar != null) {
                                                nwaVar.V0();
                                                this.a.D2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.W7(view2);
                                            if (this.a.B0.s1().R() != null && this.a.B0.s1().R().getAuthor() != null && this.a.B0.s1().R().getAuthor().getUserId() != null && this.a.D0 != null) {
                                                c6a.E(2, n1a.r(this.a.B0.s1()), !this.a.D0.e(), this.a.B0);
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
                                                this.a.q7((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray2.put(R.id.tag_from, 0);
                                                    sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                    this.a.s6(sparseArray2);
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
                                                boolean Z = this.a.u0().Z(TbadkCoreApplication.getCurrentAccount());
                                                if (Z) {
                                                    if (booleanValue2) {
                                                        this.a.I0.M2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, Z);
                                                        return;
                                                    } else {
                                                        this.a.S8(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.I0.K2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                                    return;
                                                } else {
                                                    this.a.S8(sparseArray3, intValue, booleanValue);
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
                                                    this.a.s6(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                }
                                                this.a.I0.P2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.I0.K2(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            nwa nwaVar2 = (nwa) sparseArray.get(R.id.tag_clip_board);
                                            if (nwaVar2.p() == null) {
                                                return;
                                            }
                                            this.a.w6(nwaVar2.p());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.B0 != null && this.a.B0.s1() != null) {
                                                this.a.a.P1(e5b.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.B0 != null && this.a.B0.s1() != null) {
                                    this.a.I0.H4(true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            if (view3 == null) {
                                return;
                            }
                            this.a.u8(view3);
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
                            this.a.u8(view4);
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
                    this.a.u8(view5);
                    if (view5 != null) {
                        if (sparseArray5 != null && (sparseArray5.get(R.id.tag_is_top_question) instanceof Boolean)) {
                            this.a.J8(((Boolean) sparseArray5.get(R.id.tag_is_top_question)).booleanValue());
                        }
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.u8(view6);
                if (view6 != null) {
                    view6.performClick();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n2 implements p55.g {
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

        @Override // com.baidu.tieba.p55.g
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.Y6()) {
                    this.a.a.finish();
                }
                if (this.a.B0.s2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.I0.A0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public o(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o0 implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ PbFragment e;

        public o0(PbFragment pbFragment, SparseArray sparseArray, boolean z, String str, String str2) {
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

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                if (this.e.N0 != null) {
                    this.e.N0.dismiss();
                }
                if (i == 0) {
                    this.e.I0.K2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.j1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.j1);
                    this.e.e9(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o1 implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PbFragment d;

        public o1(PbFragment pbFragment, SparseArray sparseArray, int i, boolean z) {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                if (f05Var != null) {
                    f05Var.dismiss();
                }
                this.d.F6(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o2 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.Y6()) {
                    this.a.a.finish();
                }
                if (this.a.B0.s2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.I0.A0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        public p(PbFragment pbFragment) {
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

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            r1a r1aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (r1aVar = this.a.M0) != null && r1aVar.g() != null) {
                if (!this.a.M0.g().e()) {
                    this.a.M0.b(false);
                }
                this.a.M0.g().l(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(PbFragment pbFragment, int i) {
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
                    if (this.a.T6().u() != null && this.a.T6().u().getGodUserData() != null) {
                        this.a.T6().u().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.B0 != null && this.a.B0.s1() != null && this.a.B0.s1().R() != null && this.a.B0.s1().R().getAuthor() != null) {
                        this.a.B0.s1().R().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
                if (updateAttentionMessage.isAttention()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921760, 10));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p1 implements f05.e {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p2 implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.A2 && this.a.Y6()) {
                    this.a.N7();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (this.a.I0 != null) {
                    this.a.I0.j3();
                }
                if (!this.a.f0 && this.a.I0 != null && this.a.I0.i0() && this.a.B0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.B0.M1());
                    statisticItem.param("fid", this.a.B0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.B0.X0()) {
                        i = 4;
                    } else if (this.a.B0.Y0()) {
                        i = 3;
                    } else if (this.a.B0.a1()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.f0 = true;
                }
                if (this.a.B0.q2(false)) {
                    this.a.I0.K3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (this.a.B0.s1() != null) {
                    this.a.I0.c3();
                }
                this.a.A2 = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements v0a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.v0a.b
        public void onSuccess(List<nwa> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }

        public q(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.v0a.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.I0.v4(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q0 extends ResponsedEventListener<TipEvent> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.om5
        /* renamed from: g */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId > 0 && this.a.a.getPageId() == tipEvent.pageId) {
                    DefaultNavigationBarCoverTip.q(this.a.getActivity(), tipEvent.message, tipEvent.linkUrl).s();
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class q1 implements SortSwitchButton.f {
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

        public q1(PbFragment pbFragment) {
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
                this.a.I0.s0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.B0 != null && !this.a.B0.isLoading) {
                    this.a.i9();
                    this.a.I0.J3();
                    z = true;
                    if (this.a.B0.s1() != null && this.a.B0.s1().f != null && this.a.B0.s1().f.size() > i) {
                        int intValue = this.a.B0.s1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.B0.N1()).param("fid", this.a.B0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.B0.k3(intValue)) {
                            this.a.h = true;
                            this.a.I0.y3(true);
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class q2 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.B0 != null) {
                this.a.B0.loadData();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.B0 != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.Y0 != null) {
                    this.a.I0.p3(this.a.Y0.C());
                }
                this.a.I0.h3();
                this.a.I0.s0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r0 extends ResponsedEventListener<TopToastEvent> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.om5
        /* renamed from: g */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                if (this.a.I0 != null && topToastEvent != null) {
                    new BdTopToast(this.a.getContext()).setIcon(topToastEvent.isSuccess()).setContent(topToastEvent.getContent()).show(this.a.I0.u1());
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class r1 implements lu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.lu4.d
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "pbPage.novelPaySuccess" : (String) invokeV.objValue;
        }

        public r1(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.lu4.c
        public void a(@NonNull String str) {
            nwa a0;
            fd5 b0;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("PbFragment", "收到H5通知，更新Pb数据：" + str);
                if (this.a.B0 == null) {
                    return;
                }
                this.a.B0.loadData();
                aw9 s1 = this.a.B0.s1();
                if (s1 != null && (a0 = s1.a0()) != null && (b0 = a0.b0()) != null && !b0.n()) {
                    so5 so5Var = new so5();
                    so5Var.t(b0);
                    String T2 = s1.T();
                    String o = s1.o();
                    if (s1.R() != null) {
                        i = s1.R().getThreadType();
                    } else {
                        i = 0;
                    }
                    so5Var.v(T2, o, i, this.a.B0.L0(), this.a.B0.x1(), b0.d());
                    String x = so5Var.x(b0.e());
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(NovelWebViewActivityConfig.KEY_IS_SHOW_TOAST_TIP, true);
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_ID, String.valueOf(b0.h()));
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_TID, so5Var.i());
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_FID, so5Var.e());
                    BrowserHelper.startWebActivity(this.a.getContext(), "", x, true, true, true, bundle);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921658, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(PbFragment pbFragment, int i) {
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
            this.a.B0.n3((UserPendantData) customResponsedMessage.getData());
            if (this.a.I0 != null && this.a.B0 != null) {
                this.a.I0.a3(this.a.B0.s1(), this.a.B0.L1(), this.a.B0.D1(), this.a.I0.p1());
            }
            if (this.a.I0 != null && this.a.I0.G0() != null) {
                this.a.I0.G0().v();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;
        public final /* synthetic */ PbFragment b;

        public s0(PbFragment pbFragment, Intent intent) {
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
            o1a o1aVar = this.b.I0;
            o1aVar.M3("@" + this.a.getStringExtra("big_pic_type") + " ");
        }
    }

    /* loaded from: classes7.dex */
    public class s1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        public s1(PbFragment pbFragment, String str, String str2) {
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
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.a9(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class s2 implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ f05 c;
        public final /* synthetic */ PbFragment d;

        public s2(PbFragment pbFragment, MarkData markData, MarkData markData2, f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, f05Var};
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
            this.c = f05Var;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
                if (this.d.D0 != null) {
                    if (this.d.D0.e()) {
                        this.d.D0.d();
                        this.d.D0.h(false);
                    }
                    this.d.D0.i(this.a);
                    this.d.D0.h(true);
                    this.d.D0.a();
                }
                this.b.setPostId(this.a.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.b);
                this.d.a.setResult(-1, intent);
                this.c.dismiss();
                this.d.j9();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.I0 == null) {
                    return;
                }
                if (booleanValue) {
                    this.a.I0.m4();
                } else {
                    this.a.I0.E1();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t0 implements Function0<ArrayList<pi>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public t0(PbFragment pbFragment) {
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
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public ArrayList<pi> invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.I0 != null && this.a.I0.G0() != null) {
                    return this.a.I0.G0().l();
                }
                return null;
            }
            return (ArrayList) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class t1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        public t1(PbFragment pbFragment, String str, String str2) {
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
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.a9(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class t2 implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ f05 b;
        public final /* synthetic */ PbFragment c;

        public t2(PbFragment pbFragment, MarkData markData, f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, f05Var};
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
            this.b = f05Var;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.j9();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(PbFragment pbFragment, int i) {
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
            if (this.a.Y0 != null) {
                this.a.I0.p3(this.a.Y0.C());
            }
            this.a.I0.X3(false);
        }
    }

    /* loaded from: classes7.dex */
    public class u0 implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public u0(PbFragment pbFragment) {
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
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.I0 != null && this.a.I0.G0() != null) {
                    this.a.I0.G0().v();
                    return null;
                }
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class u1 implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n05 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ PbFragment c;

        public u1(PbFragment pbFragment, n05 n05Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, n05Var, view2};
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
            this.a = n05Var;
            this.b = view2;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                this.a.dismiss();
                PbModel pbModel = this.c.B0;
                if (this.b.getId() == R.id.obfuscated_res_0x7f091c33) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                c6a.K(i, pbModel, i2);
                if (this.c.B0.s1().f != null && this.c.B0.s1().f.size() > i) {
                    i = this.c.B0.s1().f.get(i).sort_type.intValue();
                }
                boolean k3 = this.c.B0.k3(i);
                this.b.setTag(Integer.valueOf(this.c.B0.J1()));
                if (!k3) {
                    return;
                }
                this.c.h = true;
                this.c.I0.y3(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ f05 b;
        public final /* synthetic */ PbFragment c;

        public u2(PbFragment pbFragment, MarkData markData, f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, f05Var};
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
            this.b = f05Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.I0 != null && this.c.I0.u1() != null) {
                    this.c.I0.u1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.a.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.j9();
                }
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                hu9 hu9Var = (hu9) customResponsedMessage.getData();
                int b = hu9Var.b();
                if (b != 0) {
                    if (b != 1) {
                        if (b == 2) {
                            if (hu9Var.a() == null) {
                                this.a.w8(false, null);
                                return;
                            } else {
                                this.a.w8(true, (MarkData) hu9Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.N6((ForumManageModel.b) hu9Var.a(), false);
                    return;
                }
                this.a.x8((qw9) hu9Var.a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v0 implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public v0(PbFragment pbFragment) {
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
                if (message.what == 2 && this.a.B0 != null && this.a.B0.d1()) {
                    this.a.S7();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class v1 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (this.a.s0 && (view2 == this.a.I0.j.e || view2 == this.a.I0.j.f || view2.getId() == R.id.obfuscated_res_0x7f091c0f || view2.getId() == R.id.obfuscated_res_0x7f090bcb || view2.getId() == R.id.obfuscated_res_0x7f091fd4 || view2.getId() == R.id.obfuscated_res_0x7f091ba7)) {
                    return;
                }
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.I0.d1()) {
                        this.a.Y7();
                    }
                } else {
                    this.a.C8(view2);
                }
                if (view2 == this.a.I0.f1()) {
                    if (this.a.h || !this.a.B0.q2(true)) {
                        return;
                    }
                    this.a.h = true;
                    this.a.I0.K3();
                } else if (this.a.I0.j.i() == null || view2 != this.a.I0.j.i().F()) {
                    if (this.a.I0.j.i() == null || view2 != this.a.I0.j.i().x()) {
                        if (view2 == this.a.I0.j.h) {
                            if (!this.a.I0.h0(this.a.B0.f1())) {
                                BdUtilHelper.hideSoftKeyPad(this.a.a, this.a.I0.j.h);
                                this.a.a.finish();
                                return;
                            }
                            this.a.i9();
                            return;
                        } else if (view2 != this.a.I0.K0() && (this.a.I0.j.i() == null || (view2 != this.a.I0.j.i().G() && view2 != this.a.I0.j.i().H()))) {
                            if (view2 == this.a.I0.S0()) {
                                if (this.a.B0 != null) {
                                    BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), this.a.B0.s1().R().getTopicData().b());
                                    return;
                                }
                                return;
                            } else if (view2 != this.a.I0.j.e) {
                                if (view2 != this.a.I0.j.f) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f091bce) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091ba2) {
                                            if ((this.a.I0.j.i() == null || view2 != this.a.I0.j.i().D()) && view2.getId() != R.id.obfuscated_res_0x7f090bcb && view2.getId() != R.id.obfuscated_res_0x7f091fd4) {
                                                if (this.a.I0.j.i() != null && view2 == this.a.I0.j.i().y()) {
                                                    this.a.I0.j.f();
                                                    return;
                                                } else if (view2.getId() == R.id.share_num_container) {
                                                    if (!n1a.b(this.a.getPageContext(), 11009)) {
                                                        return;
                                                    }
                                                    n1a.s(this.a.getContext(), 3, this.a.S6(), this.a.B0);
                                                    return;
                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f091ba7 && view2.getId() != R.id.share_more_container) {
                                                    if (this.a.I0.j.i() == null || view2 != this.a.I0.j.i().E()) {
                                                        if (this.a.I0.j.i() == null || view2 != this.a.I0.j.i().L()) {
                                                            if (this.a.I0.j.i() != null && view2 == this.a.I0.j.i().K()) {
                                                                if (this.a.B0 != null && this.a.B0.s1() != null && this.a.B0.s1().R() != null) {
                                                                    this.a.I0.j.f();
                                                                    TiebaStatic.log(new StatisticItem("c13062"));
                                                                    PbFragment pbFragment = this.a;
                                                                    pbFragment.q7(pbFragment.B0.s1().R().getFirstPostId());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (this.a.I0.j.i() == null || view2 != this.a.I0.j.i().I()) {
                                                                if (this.a.I0.W0() != view2) {
                                                                    if (this.a.I0.j.i() == null || view2 != this.a.I0.j.i().A()) {
                                                                        if (this.a.I0.j.i() == null || view2 != this.a.I0.j.i().g()) {
                                                                            if (this.a.I0.j.i() == null || view2 != this.a.I0.j.i().z()) {
                                                                                if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f0923e6 && view2.getId() != R.id.obfuscated_res_0x7f091bba && view2.getId() != R.id.obfuscated_res_0x7f091a31) {
                                                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091c25) {
                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091c23 && view2.getId() != R.id.obfuscated_res_0x7f091df0 && view2.getId() != R.id.obfuscated_res_0x7f091bb4) {
                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091bb8) {
                                                                                                if (view2 != this.a.I0.U0()) {
                                                                                                    if (this.a.I0.j.i() != null && view2 == this.a.I0.j.i().J()) {
                                                                                                        this.a.I0.j.g();
                                                                                                        this.a.I0.k4(this.a.G2);
                                                                                                        return;
                                                                                                    } else if (this.a.I0.j.i() == null || view2 != this.a.I0.j.i().C()) {
                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f0908bc && view2.getId() != R.id.obfuscated_res_0x7f090bc7) {
                                                                                                            if (view2.getId() != R.id.pb_u9_text_view) {
                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f091fd9 && view2.getId() != R.id.cover_reply_content && view2.getId() != R.id.replybtn_top_right && view2.getId() != R.id.cover_reply_content_top_right) {
                                                                                                                    if (view2.getId() != R.id.pb_act_btn) {
                                                                                                                        if (view2.getId() != R.id.lottery_tail) {
                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091be8 && view2.getId() != R.id.obfuscated_res_0x7f091baf) {
                                                                                                                                if (view2.getId() != R.id.join_vote_tv) {
                                                                                                                                    if (view2.getId() != R.id.look_all_tv) {
                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f09179f) {
                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f09179e) {
                                                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f092854) {
                                                                                                                                                    if (view2.getId() == R.id.qq_share_container) {
                                                                                                                                                        if (!n1a.b(this.a.getPageContext(), 11009)) {
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        n1a.s(this.a.getContext(), 8, this.a.S6(), this.a.B0);
                                                                                                                                                        return;
                                                                                                                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f091a31) {
                                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091ba4) {
                                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091c0f) {
                                                                                                                                                                if (view2.getId() != R.id.forum_name_text && view2.getId() != R.id.forum_enter_button_one && view2.getId() != R.id.forum_enter_button_two && view2.getId() != R.id.forum_enter_button_three) {
                                                                                                                                                                    if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                                                                                                                        c6a.I(2, this.a.B0);
                                                                                                                                                                        return;
                                                                                                                                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f091c37) {
                                                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091c51) {
                                                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f09109d) {
                                                                                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f09109a) {
                                                                                                                                                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091bbc && view2.getId() != R.id.obfuscated_res_0x7f091c1d) {
                                                                                                                                                                                        if (view2.getId() == R.id.obfuscated_res_0x7f09237e) {
                                                                                                                                                                                            Object tag = view2.getTag();
                                                                                                                                                                                            if (tag instanceof SpriteMemeInfo) {
                                                                                                                                                                                                this.a.I0.E2((SpriteMemeInfo) tag);
                                                                                                                                                                                                return;
                                                                                                                                                                                            }
                                                                                                                                                                                            return;
                                                                                                                                                                                        }
                                                                                                                                                                                        return;
                                                                                                                                                                                    }
                                                                                                                                                                                    this.a.o9(view2);
                                                                                                                                                                                    return;
                                                                                                                                                                                }
                                                                                                                                                                                this.a.n6(view2);
                                                                                                                                                                                return;
                                                                                                                                                                            }
                                                                                                                                                                            this.a.o6(view2);
                                                                                                                                                                            return;
                                                                                                                                                                        }
                                                                                                                                                                        this.a.v9(view2);
                                                                                                                                                                        return;
                                                                                                                                                                    } else {
                                                                                                                                                                        this.a.m9();
                                                                                                                                                                        return;
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                this.a.K6(view2);
                                                                                                                                                                return;
                                                                                                                                                            }
                                                                                                                                                            this.a.n9();
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        this.a.I6();
                                                                                                                                                        return;
                                                                                                                                                    } else {
                                                                                                                                                        this.a.K7(view2);
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                this.a.l8();
                                                                                                                                                return;
                                                                                                                                            }
                                                                                                                                            this.a.N7();
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        this.a.P7();
                                                                                                                                        return;
                                                                                                                                    }
                                                                                                                                    this.a.I7(view2);
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                                this.a.G7(view2);
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            this.a.l9(view2);
                                                                                                                            return;
                                                                                                                        }
                                                                                                                        this.a.R7(view2);
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    this.a.H7();
                                                                                                                    return;
                                                                                                                }
                                                                                                                this.a.k8(view2);
                                                                                                                return;
                                                                                                            }
                                                                                                            this.a.n8(view2);
                                                                                                            return;
                                                                                                        }
                                                                                                        this.a.m8(view2);
                                                                                                        return;
                                                                                                    } else {
                                                                                                        this.a.s7();
                                                                                                        return;
                                                                                                    }
                                                                                                }
                                                                                                this.a.v7();
                                                                                                return;
                                                                                            }
                                                                                            this.a.i8(view2);
                                                                                            return;
                                                                                        }
                                                                                        this.a.j8(view2);
                                                                                        return;
                                                                                    }
                                                                                    this.a.M6(view2);
                                                                                    return;
                                                                                }
                                                                                this.a.L6(view2);
                                                                                return;
                                                                            }
                                                                            this.a.G6();
                                                                            return;
                                                                        }
                                                                        this.a.m6();
                                                                        return;
                                                                    }
                                                                    this.a.Q6();
                                                                    return;
                                                                }
                                                                this.a.p8();
                                                                return;
                                                            } else {
                                                                this.a.y6();
                                                                return;
                                                            }
                                                        }
                                                        this.a.A8(view2);
                                                        return;
                                                    }
                                                    this.a.J7();
                                                    return;
                                                } else {
                                                    this.a.h8(view2);
                                                    return;
                                                }
                                            }
                                            this.a.B8(view2);
                                            return;
                                        }
                                        this.a.J6(view2);
                                        return;
                                    }
                                    this.a.m7();
                                    return;
                                }
                                this.a.a8();
                                return;
                            } else {
                                this.a.Z7();
                                return;
                            }
                        } else {
                            this.a.T7(view2);
                            return;
                        }
                    }
                    this.a.p6();
                } else {
                    this.a.M7();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v2 implements qb<ImageView> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
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
                    if (qv4.c().g()) {
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
        @Override // com.baidu.tieba.qb
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = qv4.c().g();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.I0 != null && this.a.I0.G0() != null) {
                this.a.I0.G0().v();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public w0(PbFragment pbFragment) {
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
                    if (this.a.Y0 != null) {
                        this.a.Y0.K(null, null);
                    }
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.I0 != null && this.a.I0.k1() != null && this.a.I0.k1().f() != null) {
                    this.a.I0.k1().f().J();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w1(PbFragment pbFragment, int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || this.a.B0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.B0.b)) {
                return;
            }
            this.a.b9((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes7.dex */
    public class w2 implements ah5 {
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

        @Override // com.baidu.tieba.ah5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                r1a r1aVar = this.a.M0;
                if (r1aVar != null && r1aVar.e() != null && this.a.M0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.M0.e().c());
                    if (this.a.Y0 != null && (this.a.Y0.B() || this.a.Y0.D())) {
                        this.a.Y0.z(false, this.a.M0.h());
                    }
                    this.a.M0.a(true);
                    return true;
                }
                return !this.a.v6(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            return invokeV.booleanValue;
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
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof uy5.a)) {
                uy5.a aVar = (uy5.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.n7(aVar.b);
                }
                if (!StringUtils.isNull(aVar.e)) {
                    str = aVar.e;
                } else {
                    str = aVar.b;
                }
                uy5.c(this.a.getPageContext(), this.a, aVar.a, str, aVar.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x0 extends w4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public x0(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.w4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x2 implements qb<GifView> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.h();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.k();
                gifView.h();
                gifView.setImageDrawable(null);
                gifView.l();
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
                if (qv4.c().g()) {
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
        @Override // com.baidu.tieba.qb
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = qv4.c().g();
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
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.f) {
                return;
            }
            this.a.f9();
        }
    }

    /* loaded from: classes7.dex */
    public class y0 implements PbFirstFloorDoubleClickAnimation.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public y0(PbFragment pbFragment) {
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
    public class y2 implements qb<TiebaPlusRecommendCard> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
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
        @Override // com.baidu.tieba.qb
        /* renamed from: f */
        public void b(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tiebaPlusRecommendCard) == null) {
                tiebaPlusRecommendCard.n();
            }
        }

        public TiebaPlusRecommendCard h(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tiebaPlusRecommendCard)) == null) {
                tiebaPlusRecommendCard.n();
                return tiebaPlusRecommendCard;
            }
            return (TiebaPlusRecommendCard) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
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
    public class z implements TiePlusEventController.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public z(PbFragment pbFragment) {
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
    public class z0 implements ux9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.ux9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public z0(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.ux9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091ffa) {
                        if (this.a.E8(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090170) {
                        if (motionEvent != null && motionEvent.getAction() == 1) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof nwa)) {
                                return false;
                            }
                            nwa nwaVar = (nwa) obj;
                            if (nwaVar.getType() != nwa.c1 && !TextUtils.isEmpty(nwaVar.x()) && qv4.c().g()) {
                                return this.a.b8(nwaVar);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091bb9) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.g9((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.I0.e2() && view2.getId() == R.id.obfuscated_res_0x7f091bdb) {
                            if (view2.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.tag_user_id)));
                            }
                            if (this.a.o1() != null && this.a.o1().b != null) {
                                this.a.o1().b.onClick(view2);
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
                        this.a.g9(sparseArray);
                    }
                }
                if (this.a.Y0 != null) {
                    this.a.I0.p3(this.a.Y0.C());
                }
                this.a.I0.h3();
                this.a.I0.s0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.ux9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                this.a.H6((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class z2 implements qb<View> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
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
        @Override // com.baidu.tieba.qb
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
        @Override // com.baidu.tieba.qb
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.d1());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
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
        T2 = new g1();
        U2 = new h();
    }

    public static PbFragment c8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65647, null)) == null) {
            return new PbFragment();
        }
        return (PbFragment) invokeV.objValue;
    }

    public boolean B7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel == null) {
                return false;
            }
            return p4a.d(pbModel.s1());
        }
        return invokeV.booleanValue;
    }

    public boolean C7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                return pbModel.X0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean D7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null && absPbActivity.B1() != null && this.a.B1().r1() == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void D8() {
        vb5 vb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (vb5Var = this.j0) != null) {
            vb5Var.w();
        }
    }

    @Override // com.baidu.tieba.xy5
    public pb<TiebaPlusRecommendCard> F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.C == null) {
                this.C = new pb<>(new y2(this), 5, 0);
            }
            return this.C;
        }
        return (pb) invokeV.objValue;
    }

    public boolean F7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                return pbModel.V0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.s0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xy5
    public pb<GifView> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.L == null) {
                this.L = new pb<>(new x2(this), 20, 0);
            }
            return this.L;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public pb<TextView> N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.y == null) {
                this.y = TbRichTextView.H(TbadkCoreApplication.getInst(), 8);
            }
            return this.y;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public pb<ItemCardView> P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (this.F == null) {
                this.F = new pb<>(new b3(this), 10, 0);
            }
            return this.F;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public pb<LinearLayout> Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (this.D == null) {
                this.D = new pb<>(new e(this), 15, 0);
            }
            return this.D;
        }
        return (pb) invokeV.objValue;
    }

    public AntiData R6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.s1() != null) {
                return this.B0.s1().f();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    public final void S7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            aw9 s12 = this.B0.s1();
            this.B0.g3(true);
            jr4 jr4Var = this.D0;
            if (jr4Var != null) {
                s12.M0(jr4Var.g());
            }
            this.I0.Y1(s12);
        }
    }

    public nwa T6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            aw9 aw9Var = this.B0.G;
            if (aw9Var != null) {
                return aw9Var.a0();
            }
            return null;
        }
        return (nwa) invokeV.objValue;
    }

    public int U6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.S2;
        }
        return invokeV.intValue;
    }

    public void U7() {
        o1a o1aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048645, this) != null) || (o1aVar = this.I0) == null) {
            return;
        }
        o1aVar.q2();
    }

    @Override // com.baidu.tieba.xy5
    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            o1a o1aVar = this.I0;
            if (o1aVar == null) {
                return 0;
            }
            return o1aVar.o1();
        }
        return invokeV.intValue;
    }

    public String V6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.M;
        }
        return (String) invokeV.objValue;
    }

    public PbInterviewStatusView.f X6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.x0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    public boolean Y6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            if (!this.c && this.O2 == -1 && this.P2 == -1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean Z6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.p2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean a7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xy5
    /* renamed from: b7 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            o1a o1aVar = this.I0;
            if (o1aVar == null) {
                return null;
            }
            return o1aVar.Z0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public pb<TbImageView> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if (this.z == null) {
                this.z = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.z;
        }
        return (pb) invokeV.objValue;
    }

    public int c7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.P2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return this.i;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public int d7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.O2;
        }
        return invokeV.intValue;
    }

    public boolean e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.m2();
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public final aw9 e7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                return pbModel.s1();
            }
            return null;
        }
        return (aw9) invokeV.objValue;
    }

    public eh5 f7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.Y0;
        }
        return (eh5) invokeV.objValue;
    }

    public b3a g7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.e;
        }
        return (b3a) invokeV.objValue;
    }

    public void g8() {
        vb5 vb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048690, this) == null) && (vb5Var = this.j0) != null) {
            vb5Var.o();
        }
    }

    public q3a h7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return this.u0;
        }
        return (q3a) invokeV.objValue;
    }

    public o1a i7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            return this.I0;
        }
        return (o1a) invokeV.objValue;
    }

    public final void i9() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048701, this) == null) && (voiceManager = this.i) != null) {
            voiceManager.stopPlay();
        }
    }

    public final void j9() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048705, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.Q1();
        }
    }

    public String k7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            return this.V;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i6a
    public PbModel l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            return this.B0;
        }
        return (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public pb<RelativeLayout> n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            pb<RelativeLayout> pbVar = new pb<>(new a3(this), 10, 0);
            this.E = pbVar;
            return pbVar;
        }
        return (pb) invokeV.objValue;
    }

    public a3a o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            return this.a.o1();
        }
        return (a3a) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.d0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ti onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (ti) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            y8();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tieba.xy5
    public pb<FestivalTipView> q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            if (this.H == null) {
                this.H = TbRichTextView.G(getContext(), R.dimen.M_H_X004);
            }
            return this.H;
        }
        return (pb) invokeV.objValue;
    }

    public void q8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            r8(null);
        }
    }

    @Override // com.baidu.tieba.xy5
    public pb<ImageView> r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) {
            if (this.A == null) {
                this.A = new pb<>(new v2(this), 8, 0);
            }
            return this.A;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xy5
    public pb<View> t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) {
            if (this.B == null) {
                this.B = new pb<>(new z2(this), 8, 0);
            }
            return this.B;
        }
        return (pb) invokeV.objValue;
    }

    public boolean t8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) {
            vb5 vb5Var = this.j0;
            if (vb5Var != null && vb5Var.r()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048774, this) == null) && (pbModel = this.B0) != null && !rd.isEmpty(pbModel.M1())) {
            super.taskStart();
        }
    }

    @Override // com.baidu.tieba.i6a
    public AbsPbActivity u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public void u7() {
        o1a o1aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048777, this) == null) && (o1aVar = this.I0) != null) {
            o1aVar.z1();
            t7();
        }
    }

    @Override // com.baidu.tieba.i6a
    public PbModel.h v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048780, this)) == null) {
            return this.s2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public final void w7() {
        CheckRealNameModel M0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048788, this) == null) {
            this.W1 = new j3(this.I0, this);
            PbModel pbModel = this.B0;
            if (pbModel == null || (M0 = pbModel.M0()) == null) {
                return;
            }
            M0.S(this.W1);
        }
    }

    public final void y7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048795, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.Q = likeModel;
            likeModel.setLoadDataCallBack(new x0(this));
        }
    }

    public final void y8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048796, this) == null) {
            hideNetRefreshView(this.I0.u1());
            X8();
            if (this.B0.u2()) {
                this.I0.J3();
            }
            this.I0.U3();
        }
    }

    public final void z7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048798, this) == null) {
            s4a s4aVar = new s4a(getPageContext());
            s4aVar.m();
            this.b1 = s4aVar;
        }
    }

    public PbFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        BdUniqueId.gen();
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
        this.t0 = new z(this);
        this.w0 = false;
        this.x0 = new k0(this);
        this.y0 = new Handler(new v0(this));
        this.z0 = new r1(this);
        this.A0 = new c2(this);
        this.B0 = null;
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
        this.V0 = false;
        this.b1 = null;
        this.c1 = new l2(this);
        this.d1 = new w2(this);
        this.e1 = new h3(this);
        this.f1 = 0;
        this.q1 = false;
        this.r1 = 0;
        this.s1 = -1;
        this.u1 = 0;
        this.w1 = new k(this);
        this.x1 = new q(this);
        this.y1 = new r(this, 2004016);
        this.z1 = new s(this, 2016485);
        this.A1 = new t(this, 2001269);
        this.B1 = new u(this, 2004008);
        this.C1 = new v(this, 2004007);
        this.D1 = new w(this, 2004005);
        this.E1 = new x(this, 2001332);
        this.F1 = new y(this, 2921391);
        this.G1 = new a0(this, 2921606);
        this.H1 = new b0(this, 2921658);
        this.I1 = new c0(this);
        this.J1 = new d0(this, 2001369);
        this.K1 = new e0(this, 2921787);
        this.L1 = new f0(this, 2016488);
        this.M1 = new g0(this, 2016331);
        this.N1 = new h0(this, 2921746);
        this.O1 = new i0(this);
        this.P1 = new j0(this, 2010045);
        this.Q1 = new l0(this);
        this.R1 = new PraiseModel(getPageContext(), new m0(this));
        this.S1 = new n0(this);
        this.T1 = new p0(this, 2001115);
        this.U1 = new q0(this);
        this.V1 = new r0(this);
        this.X1 = new ux9(new z0(this));
        this.Y1 = new b1(this);
        this.Z1 = new c1(this, 2001427);
        this.a2 = new d1(this, 2001428);
        this.b2 = new e1(this, 2921634);
        this.c2 = new f1(this, 2001426);
        this.d2 = new h1(this, 2004021);
        this.e2 = new i1(this, 2016528);
        this.g2 = new j1(this, 2921724);
        this.h2 = new k1(this, 2921033);
        this.i2 = new l1(this);
        this.j2 = new m1(this);
        this.k2 = new n1(this);
        this.l2 = new q1(this);
        this.m2 = new v1(this);
        this.n2 = new w1(this, 2921480);
        this.o2 = new x1(this);
        this.p2 = Boolean.FALSE;
        this.q2 = new a2(this);
        this.r2 = new b2(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.s2 = new d2(this);
        this.t2 = new e2(this, 2016450);
        this.u2 = new f2(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.v2 = new g2(this);
        this.w2 = new h2(this);
        this.x2 = new k2(this);
        this.y2 = new n2(this);
        this.z2 = new o2(this);
        this.B2 = new p2(this);
        this.C2 = new c3(this);
        this.D2 = null;
        this.E2 = new d3(this);
        this.F2 = new e3(this);
        this.G2 = new f3(this);
        this.H2 = new a(this);
        this.I2 = new b(this);
        this.J2 = new c(this);
        this.K2 = new d(this);
        this.L2 = new f(this);
        this.M2 = new g(this);
        this.N2 = new i(this);
        this.O2 = -1;
        this.P2 = -1;
        this.S2 = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e3, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0159, code lost:
        if ((r7.e1.a.getView().getTop() - r11.I0.j.a.getBottom()) < (r11.I0.e1.a.g.getHeight() + 10)) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I6() {
        PbModel pbModel;
        int top;
        boolean z3;
        boolean z4;
        o1a.v0 v0Var;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        e5a e5aVar;
        PbReplyTitleViewHolder pbReplyTitleViewHolder2;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.I0.Z0() != null && (pbModel = this.B0) != null && pbModel.s1() != null) {
            int firstVisiblePosition = this.I0.Z0().getFirstVisiblePosition();
            int i4 = 0;
            View childAt = this.I0.Z0().getChildAt(0);
            if (childAt == null) {
                top = 0;
            } else {
                top = childAt.getTop();
            }
            boolean y02 = this.B0.s1().y0();
            boolean j22 = this.I0.j2();
            if (firstVisiblePosition == 0 && top == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            n1a.c(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.B0.s1());
            if ((this.B0.s1().R() != null && this.B0.s1().R().getReply_num() <= 0) || (j22 && z3)) {
                c6a.N(1, 1);
                if (!checkUpIsLogin()) {
                    c6a.N(2, 1);
                    return;
                }
                q8();
                if (this.B0.s1().R().getAuthor() != null) {
                    c6a.x(2, this.B0);
                }
            } else {
                int equipmentHeight = (int) (BdUtilHelper.getEquipmentHeight(getContext()) * 0.6d);
                if (y02) {
                    o1a.v0 v0Var2 = this.I0.e1;
                    if (v0Var2 != null) {
                        PbReplyTitleViewHolder pbReplyTitleViewHolder3 = v0Var2.a;
                        if (pbReplyTitleViewHolder3 != null && pbReplyTitleViewHolder3.getView() != null) {
                            if (this.I0.e1.a.getView().getParent() != null) {
                            }
                        }
                    }
                    z4 = false;
                } else {
                    if (this.I0.i1() != null) {
                        if (this.I0.i1().getVisibility() == 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z4 && (v0Var = this.I0.e1) != null && (pbReplyTitleViewHolder = v0Var.a) != null && pbReplyTitleViewHolder.getView() != null && this.I0.e1.a.getView().getParent() != null && (e5aVar = (r7 = this.I0).j) != null && e5aVar.a != null) {
                        }
                    }
                    z4 = false;
                }
                if (!z4 && !j22) {
                    if (this.a0 > 0) {
                        if (this.I0.Z0().getChildAt(this.a0) != null) {
                            this.I0.Z0().D(this.a0, this.b0, 200);
                        } else {
                            this.I0.Z0().setSelectionFromTop(this.a0, this.b0 + equipmentHeight);
                            this.I0.Z0().smoothScrollBy(equipmentHeight, 500);
                        }
                    } else {
                        int d4 = u2a.d(getListView());
                        if (u2a.e(getListView()) != -1) {
                            d4--;
                        }
                        int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds100);
                        if (d4 < 0) {
                            d4 = (ListUtils.getCount(this.I0.Z0().getData()) - 1) + this.I0.Z0().getHeaderViewsCount();
                        } else {
                            i4 = dimens;
                        }
                        e5a e5aVar2 = this.I0.j;
                        if (e5aVar2 != null && (navigationBar = e5aVar2.a) != null) {
                            i4 += navigationBar.getFixedNavHeight() - 10;
                        }
                        o1a.v0 v0Var3 = this.I0.e1;
                        if (v0Var3 != null && (pbReplyTitleViewHolder2 = v0Var3.a) != null && pbReplyTitleViewHolder2.getView() != null && this.I0.e1.a.getView().getParent() != null) {
                            this.I0.Z0().D(d4, i4, 200);
                        } else {
                            this.I0.Z0().setSelectionFromTop(d4, i4 + equipmentHeight);
                            this.I0.Z0().smoothScrollBy(equipmentHeight, 500);
                        }
                    }
                } else {
                    this.a0 = firstVisiblePosition;
                    this.b0 = top;
                    if (firstVisiblePosition <= 3 && (firstVisiblePosition != 3 || top >= (-equipmentHeight))) {
                        this.I0.Z0().D(0, 0, 500);
                    } else {
                        int i5 = -equipmentHeight;
                        this.I0.Z0().setSelectionFromTop(0, i5);
                        this.I0.Z0().smoothScrollBy(i5, 500);
                    }
                }
            }
            if (this.B0.s1().R() != null && this.B0.s1().R().getAuthor() != null) {
                c6a.x(2, this.B0);
            }
        }
    }

    @Override // com.baidu.tieba.i6a
    public void finish() {
        o1a o1aVar;
        boolean z3;
        CardHListViewData s3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            o1a o1aVar2 = this.I0;
            if (o1aVar2 != null) {
                o1aVar2.s0();
            }
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.s1() != null && !this.B0.s1().a()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.B0.s1().R().getId();
                if (this.B0.isShareThread() && this.B0.s1().R().originalThreadData != null) {
                    historyMessage.threadName = this.B0.s1().R().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.B0.s1().R().getTitle();
                }
                if (this.B0.isShareThread() && !e1()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.B0.s1().n().getName();
                }
                ArrayList<nwa> I = this.B0.s1().I();
                o1a o1aVar3 = this.I0;
                if (o1aVar3 != null) {
                    i4 = o1aVar3.Q0();
                } else {
                    i4 = 0;
                }
                if (I != null && i4 >= 0 && i4 < I.size()) {
                    historyMessage.postID = I.get(i4).U();
                }
                historyMessage.isHostOnly = this.B0.V0();
                historyMessage.isSquence = this.B0.L1();
                historyMessage.isShareThread = this.B0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            if (this.V0) {
                br6.b().c(new rh5(this.B0.M1()));
            }
            PbModel pbModel2 = this.B0;
            if (pbModel2 != null && (pbModel2.X0() || this.B0.a1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.B0.M1());
                if (this.J0) {
                    if (this.L0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.B0.g1());
                    }
                    if (this.K0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.B0.c1());
                    }
                }
                if (this.B0.a1() && this.B0.s1() != null && this.B0.s1().R() != null) {
                    br6.b().c(new sh5(this.B0.R()));
                }
                if (this.B0.s1() != null && System.currentTimeMillis() - this.n >= 40000 && (s3 = this.B0.s1().s()) != null && !ListUtils.isEmpty(s3.getDataList())) {
                    intent.putExtra("guess_like_data", s3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.s1);
                }
                this.a.setResult(-1, intent);
            }
            if (k9()) {
                if (this.B0 != null && (o1aVar = this.I0) != null && o1aVar.Z0() != null) {
                    aw9 s12 = this.B0.s1();
                    if (s12 != null) {
                        if (s12.Y() != null) {
                            s12.Y().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            s12.Y().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!s12.t0() && !this.I && s12.h == null) {
                            f1a b4 = f1a.b();
                            aw9 t12 = this.B0.t1();
                            Parcelable onSaveInstanceState = this.I0.Z0().onSaveInstanceState();
                            boolean L1 = this.B0.L1();
                            boolean V0 = this.B0.V0();
                            if (this.I0.i1() != null && this.I0.i1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.l(t12, onSaveInstanceState, L1, V0, z3);
                            if (this.r1 >= 0 || this.B0.O1() != null) {
                                f1a.b().o(this.B0.O1());
                                f1a.b().p(this.B0.P1());
                                f1a.b().m(this.B0.l1());
                            }
                        }
                    }
                } else {
                    f1a.b().k();
                }
                j9();
            }
            if (this.b1 != null && !PushGuideManager.d() && t6() && this.B0.a1() && !TextUtils.isEmpty(this.B0.R())) {
                this.b1.n(this.B0.s1().j().l, this.B0.R());
            }
        }
    }

    @Override // com.baidu.tieba.xy5
    public void J0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) {
            this.u = true;
        }
    }

    @Override // com.baidu.tieba.xy5
    public void d0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048676, this, context, str) == null) {
            u1a.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.u = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        o1a o1aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048740, this, i4, keyEvent)) == null) {
            if (keyEvent != null && (o1aVar = this.I0) != null) {
                return o1aVar.y2(i4);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void H8(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i4) == null) && this.B0 != null) {
            X8();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i4);
            privacySettingMessage.setTid(this.B0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void I8(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i4) == null) {
            this.S2 = i4;
        }
    }

    public void J8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z3) == null) {
            this.p2 = Boolean.valueOf(z3);
        }
    }

    public final void K7(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, view2) == null) {
            if (view2.getTag() instanceof SparseArray) {
                sparseArray = (SparseArray) view2.getTag();
            } else {
                sparseArray = null;
            }
            if (sparseArray == null) {
                return;
            }
            g9(sparseArray);
        }
    }

    public void K8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z3) == null) {
            this.s0 = z3;
        }
    }

    public final void L7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            BrowserHelper.startWebActivity(getContext(), "", str, false, true, true, bundle);
        }
    }

    public void L8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z3) == null) {
            this.N = z3;
        }
    }

    public void O8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z3) == null) {
            this.K = z3;
        }
    }

    public final void P8(boolean z3) {
        eh5 eh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048630, this, z3) != null) || (eh5Var = this.Y0) == null) {
            return;
        }
        eh5Var.b0(z3);
        this.Y0.e0(z3);
        this.Y0.m0(z3);
    }

    public void T8(View view2) {
        aw9 e7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048643, this, view2) == null) && (e7 = e7()) != null) {
            k4a.d(getContext(), view2, e7);
        }
    }

    public final void W7(View view2) {
        SparseArray sparseArray;
        nwa nwaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (nwaVar = (nwa) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            X7(nwaVar);
        }
    }

    public final void Y8(@Nullable PbReplyPushGuide.Extra extra) {
        dga j4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048661, this, extra) == null) && (j4 = PushGuideManager.j("reply_pb")) != null && !this.I0.R2()) {
            j4.e(extra);
            j4.k(getPageContext(), new y1(this, j4));
        }
    }

    public final void Z8(@Nullable ThreadData threadData) {
        dga j4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048664, this, threadData) == null) && (j4 = PushGuideManager.j("collect")) != null && !this.I0.R2()) {
            j4.e(threadData);
            j4.k(getPageContext(), new z1(this, j4));
        }
    }

    @Override // com.baidu.tieba.r6a.b
    public void c2(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z3) == null) {
            this.R0 = z3;
        }
    }

    public final void c9(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048675, this, i4) == null) {
            t4a.i(this, S6(), i4);
        }
    }

    public void i6(i3 i3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048698, this, i3Var) == null) && i3Var != null) {
            if (this.t1 == null) {
                this.t1 = new ArrayList();
            }
            if (!this.t1.contains(i3Var)) {
                this.t1.add(i3Var);
            }
        }
    }

    public void j6(i3 i3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048702, this, i3Var) == null) && i3Var != null) {
            if (this.t1 == null) {
                this.t1 = new ArrayList();
            }
            if (!this.t1.contains(i3Var)) {
                this.t1.add(0, i3Var);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tieba.f05.e
    public void onClick(f05 f05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048733, this, f05Var) == null) {
            E6(f05Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.z4
    public void onPreLoad(ti tiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, tiVar) == null) {
            PreLoadImageHelper.load(tiVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(tiVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048745, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.B0.M2(bundle);
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            eh5 eh5Var = this.Y0;
            if (eh5Var != null) {
                eh5Var.J(bundle);
            }
        }
    }

    public final void r7(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, intent) == null) {
            t4a.f(this, intent);
        }
    }

    public final void t9(cx4 cx4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048772, this, cx4Var) == null) && cx4Var != null) {
            this.R2 = cx4Var;
            this.c = true;
            this.I0.f3();
            this.I0.x3(this.Q2);
        }
    }

    public void z8(i3 i3Var) {
        List<i3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048799, this, i3Var) == null) && i3Var != null && (list = this.t1) != null) {
            list.remove(i3Var);
        }
    }

    public void A6(ForumManageModel.b bVar, o1a o1aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, o1aVar) == null) {
            List<nwa> list = this.B0.s1().W().a;
            int size = list.size();
            boolean z3 = false;
            for (int i4 = 0; i4 < size; i4++) {
                int i5 = 0;
                while (true) {
                    if (i5 >= list.get(i4).k0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i4).k0().get(i5).U())) {
                        list.get(i4).k0().remove(i5);
                        list.get(i4).h();
                        z3 = true;
                        break;
                    } else {
                        i5++;
                    }
                }
                list.get(i4).k(bVar.g);
            }
            if (z3) {
                o1aVar.Y1(this.B0.s1());
            }
        }
    }

    public final void A7() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.k != null) {
            return;
        }
        this.k = new g05(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        g05 g05Var = this.k;
        g05Var.j(strArr, new a1(this));
        g05Var.g(g05.b.a);
        g05Var.h(17);
        g05Var.c(getPageContext());
    }

    public final void a8() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048666, this) != null) || nt5.a()) {
            return;
        }
        PbModel pbModel = this.B0;
        if (pbModel != null && pbModel.s1() != null) {
            ArrayList<nwa> I = this.B0.s1().I();
            if ((I == null || I.size() <= 0) && this.B0.L1()) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1036));
                return;
            }
            c6a.F(this.B0);
            this.I0.h3();
            f8();
            return;
        }
        BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1036));
    }

    public final void p8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            if (this.I0.W0().getIndicateStatus()) {
                aw9 s12 = this.B0.s1();
                if (s12 != null && s12.R() != null && s12.R().getTaskInfoData() != null) {
                    String e4 = s12.R().getTaskInfoData().e();
                    if (StringUtils.isNull(e4)) {
                        e4 = s12.R().getTaskInfoData().h();
                    }
                    TiebaStatic.log(new StatisticItem("c11107").param("obj_id", e4));
                }
            } else {
                twa.d("c10725", null);
            }
            l7();
        }
    }

    public final void v7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048783, this) == null) && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            long j4 = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
            sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(getPageContext().getPageActivity(), 24008, JavaTypesHelper.toLong(this.B0.s1().o(), 0L), JavaTypesHelper.toLong(this.B0.M1(), 0L), j4, this.B0.s1().R().getPushStatusData())));
        }
    }

    public final void A8(View view2) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            this.I0.s0();
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.h) {
                view2.setTag(Integer.valueOf(this.B0.J1()));
            } else {
                i9();
                this.I0.J3();
                n05 n05Var = new n05(getPageContext());
                if (this.B0.s1().f == null || this.B0.s1().f.size() <= 0) {
                    strArr = new String[]{getResources().getString(R.string.sort_type_new), getResources().getString(R.string.sort_type_old)};
                } else {
                    strArr = new String[this.B0.s1().f.size()];
                    for (int i4 = 0; i4 < this.B0.s1().f.size(); i4++) {
                        strArr[i4] = this.B0.s1().f.get(i4).sort_name + getResources().getString(R.string.sort_static);
                    }
                }
                n05Var.i(null, strArr, new u1(this, n05Var, view2));
                n05Var.l();
            }
        }
    }

    public final boolean E8(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof nwa)) {
                return false;
            }
            nwa nwaVar = (nwa) obj;
            if (nwaVar.getType() != nwa.c1 && !TextUtils.isEmpty(nwaVar.x()) && qv4.c().g()) {
                return b8(nwaVar);
            }
            if (!checkUpIsLogin()) {
                c6a.N(2, 2);
                return true;
            }
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.s1() != null) {
                if (i7().k1() != null) {
                    i7().k1().g();
                }
                qw9 qw9Var = new qw9();
                qw9Var.v(this.B0.s1().n());
                qw9Var.z(this.B0.s1().R());
                qw9Var.x(nwaVar);
                i7().j1().k0(qw9Var);
                i7().j1().setPostId(nwaVar.U());
                Q7(view2, nwaVar.u().getUserId(), "", nwaVar);
                TiebaStatic.log("c11743");
                eh5 eh5Var = this.Y0;
                if (eh5Var != null) {
                    this.I0.p3(eh5Var.C());
                }
                return true;
            }
            c6a.N(20, 2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void J6(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.I0.s0();
            if (view2.getId() == R.id.obfuscated_res_0x7f091ba2 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                this.U = view2;
            } else if (!n1a.b(getPageContext(), 11009) || this.B0.I0(this.I0.Y0()) == null) {
            } else {
                V7();
                if (this.B0.s1() != null && this.B0.s1().R() != null && this.B0.s1().R().getAuthor() != null) {
                    c6a.x(3, this.B0);
                }
                if (this.B0.s1().R() != null && this.B0.s1().R().getAuthor() != null && this.B0.s1().R().getAuthor().getUserId() != null && this.D0 != null) {
                    c6a.E(1, n1a.r(this.B0.s1()), !this.D0.e(), this.B0);
                }
            }
        }
    }

    public final void T7(View view2) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.B0.s1() == null || this.E0.h0()) {
            } else {
                this.I0.s0();
                if (this.I0.j.i() != null && view2 == this.I0.j.i().H()) {
                    if (this.B0.s1().R().getIs_top() == 1) {
                        i4 = 5;
                    } else {
                        i4 = 4;
                    }
                } else if (this.I0.j.i() != null && view2 == this.I0.j.i().G()) {
                    if (this.B0.s1().R().getIs_good() == 1) {
                        i4 = 3;
                    } else {
                        i4 = 6;
                    }
                } else if (view2 == this.I0.K0()) {
                    i4 = 2;
                } else {
                    i4 = 0;
                }
                ForumData n3 = this.B0.s1().n();
                String name = n3.getName();
                String id = n3.getId();
                String id2 = this.B0.s1().R().getId();
                this.I0.x4();
                this.E0.l0(id, name, id2, i4, this.I0.L0());
            }
        }
    }

    public final boolean b8(nwa nwaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048670, this, nwaVar)) == null) {
            if (nwaVar == null) {
                return false;
            }
            String U = nwaVar.U();
            if (StringUtils.isNull(U) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String string = SharedPrefHelper.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = nwaVar.p0().getJumpUrl();
            int packageId = nwaVar.p0().getPackageId();
            int propsId = nwaVar.p0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                BrowserHelper.startWebActivity(getPageContext().getPageActivity(), uxa.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
                return true;
            } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            } else {
                BrowserHelper.startWebActivity(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + U, true, true, true);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void q6(boolean z3) {
        o1a o1aVar;
        int i4;
        int m3;
        nwa nwaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048755, this, z3) == null) && (o1aVar = this.I0) != null && o1aVar.Z0() != null) {
            int firstVisiblePosition = this.I0.Z0().getFirstVisiblePosition();
            int lastVisiblePosition = this.I0.Z0().getLastVisiblePosition();
            vz9 G0 = this.I0.G0();
            if (G0 != null && this.B0.s1() != null) {
                if (lastVisiblePosition <= G0.m()) {
                    i4 = 0;
                    m3 = 1;
                } else {
                    if (firstVisiblePosition > G0.m()) {
                        i4 = firstVisiblePosition - G0.m();
                    } else {
                        i4 = 0;
                    }
                    m3 = (lastVisiblePosition - G0.m()) + 1;
                }
                ArrayList arrayList = new ArrayList();
                if (m3 > i4) {
                    while (i4 < m3) {
                        if (this.I0.Z0().G(i4) != null && (this.I0.Z0().G(i4) instanceof nwa) && (nwaVar = (nwa) this.I0.Z0().G(i4)) != null) {
                            nwa nwaVar2 = (nwa) ListUtils.getItem(this.B0.s1().I(), nwaVar.L() - 1);
                            if (nwaVar.o() == null && nwaVar2 != null) {
                                nwaVar.S0(nwaVar2.o());
                            }
                            if (nwaVar.o() != null) {
                                nwaVar.o().setFloonumber(nwaVar.L());
                                arrayList.add(nwaVar.o());
                            }
                        }
                        i4++;
                    }
                }
                if (ListUtils.getItem(arrayList, 0) != null) {
                    Collections.sort(arrayList, new i2(this));
                    AdverSegmentData adverSegmentData = (AdverSegmentData) ListUtils.getItem(arrayList, 0);
                    if (adverSegmentData != null && adverSegmentData.getFloonumber() == 1) {
                        if (!z3) {
                            this.I0.S2(adverSegmentData, 0);
                            return;
                        }
                        return;
                    }
                    this.I0.S2(adverSegmentData, 1);
                }
            }
        }
    }

    public final AbsPbActivity.e s8(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048766, this, str)) == null) {
            String str2 = null;
            if (this.B0.s1() != null && this.B0.s1().I() != null && this.B0.s1().I().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i4 = 0;
                while (true) {
                    if (i4 < this.B0.s1().I().size()) {
                        if (str.equals(this.B0.s1().I().get(i4).U())) {
                            break;
                        }
                        i4++;
                    } else {
                        i4 = 0;
                        break;
                    }
                }
                nwa nwaVar = this.B0.s1().I().get(i4);
                if (nwaVar.f0() != null && nwaVar.f0().Q() != null) {
                    Iterator<TbRichTextData> it = nwaVar.f0().Q().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.V() != null) {
                                str2 = next.V().Q();
                            }
                        }
                    }
                    d1a.e(this.B0, str2, 0, eVar);
                    bw9.c(nwaVar, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void u9(int i4) {
        PbModel pbModel;
        ThreadData R;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048779, this, i4) != null) || (pbModel = this.B0) == null || pbModel.s1() == null || (R = this.B0.s1().R()) == null) {
            return;
        }
        if (i4 == 1) {
            PraiseData praise = R.getPraise();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (praise == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i4);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    R.setPraise(praiseData);
                } else {
                    R.getPraise().getUser().add(0, metaData);
                    R.getPraise().setNum(R.getPraise().getNum() + 1);
                    R.getPraise().setIsLike(i4);
                }
            }
        } else if (R.getPraise() != null) {
            R.getPraise().setIsLike(i4);
            R.getPraise().setNum(R.getPraise().getNum() - 1);
            ArrayList<MetaData> user = R.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        R.getPraise().getUser().remove(next);
                        break;
                    }
                }
            }
        }
        if (this.B0.L1()) {
            this.I0.G0().v();
        } else {
            this.I0.I4(this.B0.s1());
        }
    }

    public void x8(qw9 qw9Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048793, this, qw9Var) != null) || qw9Var.i() == null) {
            return;
        }
        String U = qw9Var.i().U();
        ArrayList<nwa> I = this.B0.s1().I();
        int i4 = 0;
        while (true) {
            z3 = true;
            if (i4 >= I.size()) {
                break;
            }
            nwa nwaVar = I.get(i4);
            if (nwaVar.U() != null && nwaVar.U().equals(U)) {
                ArrayList<nwa> k4 = qw9Var.k();
                nwaVar.u1(qw9Var.m());
                if (nwaVar.k0() != null && k4 != null) {
                    Iterator<nwa> it = k4.iterator();
                    while (it.hasNext()) {
                        nwa next = it.next();
                        if (nwaVar.t0() != null && next != null && next.u() != null && (metaData = nwaVar.t0().get(next.u().getUserId())) != null) {
                            next.T0(metaData);
                            next.j1(true);
                            next.E1(getPageContext(), this.B0.n2(metaData.getUserId()));
                        }
                    }
                    if (k4.size() == nwaVar.k0().size()) {
                        z3 = false;
                    }
                    if (!nwaVar.A0(false)) {
                        nwaVar.k0().clear();
                        nwaVar.k0().addAll(k4);
                    }
                }
                if (nwaVar.E() != null) {
                    nwaVar.R0();
                }
            } else {
                i4++;
            }
        }
        if (!this.B0.b1() && z3) {
            this.I0.Y1(this.B0.s1());
        }
        if (z3) {
            v8(qw9Var);
        }
    }

    public final void B6(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.B0) != null && pbModel.s1() != null) {
            mwa C = this.B0.s1().C();
            if (C != null && str.equals(C.I1())) {
                if (C.getAdvertAppInfo() != null) {
                    C.getAdvertAppInfo().h = null;
                }
                this.B0.s1().d();
            }
            mwa K0 = this.B0.K0();
            if (K0 != null && str.equals(K0.I1())) {
                this.B0.y0();
            }
        }
    }

    public final void K6(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, view2) != null) || !(view2.getTag() instanceof ThreadData)) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        if (this.B0.r1() == 3 && e1() && this.B0.s1() != null && ListUtils.isEmpty(this.B0.s1().r())) {
            this.a.finish();
        } else {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
        c6a.z(threadData);
    }

    public void X7(nwa nwaVar) {
        boolean z3;
        nwa T6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048656, this, nwaVar) != null) || nwaVar == null) {
            return;
        }
        if (nwaVar.U() != null && nwaVar.U().equals(this.B0.n1())) {
            z3 = true;
        } else {
            z3 = false;
        }
        MarkData m12 = this.B0.m1(nwaVar);
        if (this.B0.s1() != null && this.B0.s1().a() && (T6 = T6()) != null) {
            m12 = this.B0.m1(T6);
        }
        if (m12 == null) {
            return;
        }
        this.I0.J3();
        jr4 jr4Var = this.D0;
        if (jr4Var != null) {
            jr4Var.i(m12);
            if (!z3) {
                this.D0.a();
            } else {
                this.D0.d();
            }
        }
    }

    public final void b9(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && l0() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                l0().B0(postWriteCallBackData.getPostId());
                int M0 = this.I0.M0();
                this.r1 = M0;
                this.B0.P2(M0, this.I0.T0());
            }
            this.I0.s0();
            this.M0.c();
            eh5 eh5Var = this.Y0;
            if (eh5Var != null) {
                this.I0.p3(eh5Var.C());
            }
            this.I0.z1();
            this.I0.X3(true);
            this.B0.X1();
        }
    }

    public final void l9(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048714, this, view2) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
            String string2 = SharedPrefHelper.getInstance().getString("tail_link", "");
            String string3 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
            if (!StringUtils.isNull(string2)) {
                TiebaStatic.log("c10056");
                Context context = view2.getContext();
                BrowserHelper.startWebActivity(context, string, UtilHelper.urlAddParam(string2, "page_from=1&tailSkinId=" + string3), true, true, true);
            }
            this.I0.h3();
            TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        aw9 s12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (i7() != null && n1a.z(this)) {
                i7().w4();
            }
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907f7));
            PbModel pbModel = this.B0;
            if (pbModel != null && (s12 = pbModel.s1()) != null) {
                this.s2.c(true, 0, 3, 0, s12, "", 1, true);
            }
            this.a.E1().j(this.t0);
            PbModel pbModel2 = this.B0;
            if (pbModel2 != null) {
                this.G.b(pbModel2.G, getContext(), this.a.findViewById(this.I0.H0()), this.B0.getForumId(), this.B0.M1());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048732, this, i4) != null) || this.W == i4) {
            return;
        }
        super.onChangeSkinType(i4);
        this.I0.u2(i4);
        eh5 eh5Var = this.Y0;
        if (eh5Var != null && eh5Var.a() != null) {
            this.Y0.a().F(i4);
        }
        if (this.I0.a() != null) {
            this.I0.a().onChangeSkinType(getPageContext(), i4);
        }
        this.M0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i4, getResources(), R.color.CAM_X0201), true);
        this.W = i4;
        i9();
        vb5 vb5Var = this.j0;
        if (vb5Var != null) {
            vb5Var.u();
        }
    }

    public final void q7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048756, this, str) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.s1() != null && this.B0.s1().a()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.B0.M1(), str);
                ThreadData R = this.B0.s1().R();
                if (R.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (R.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (R.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                L7(format);
                return;
            }
            this.C0.a(str);
        }
    }

    public void r8(@Nullable SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048762, this, spriteMemeInfo) == null) {
            if (!checkUpIsLogin()) {
                c6a.N(2, 1);
                return;
            }
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.s1() != null && this.B0.s1().n() != null) {
                if (r6()) {
                    c6a.N(3, 1);
                    return;
                } else if (this.B0.s1().a()) {
                    c6a.N(7, 1);
                    this.I0.j0(spriteMemeInfo);
                    return;
                } else {
                    eh5 eh5Var = this.Y0;
                    if (eh5Var != null && eh5Var.a() != null) {
                        this.Y0.a().K(new he5(45, 27, null));
                    }
                    this.I0.j0(spriteMemeInfo);
                    return;
                }
            }
            c6a.N(20, 1);
        }
    }

    public void v8(qw9 qw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048784, this, qw9Var) == null) {
            String U = qw9Var.i().U();
            List<nwa> list = this.B0.s1().W().a;
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                nwa nwaVar = list.get(i4);
                if (nwaVar.U() != null && nwaVar.U().equals(U)) {
                    ArrayList<nwa> k4 = qw9Var.k();
                    nwaVar.u1(qw9Var.m());
                    if (nwaVar.k0() != null) {
                        nwaVar.k0().clear();
                        nwaVar.k0().addAll(k4);
                    }
                } else {
                    i4++;
                }
            }
            if (!this.B0.b1()) {
                this.I0.Y1(this.B0.s1());
            }
        }
    }

    public final void B8(View view2) {
        boolean i32;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                view2.setTag(Boolean.FALSE);
                return;
            }
            this.I0.s0();
            if (this.I0.j.i() != null && view2 == this.I0.j.i().D()) {
                this.I0.h3();
            }
            if (this.h) {
                view2.setTag(Boolean.FALSE);
                return;
            }
            i9();
            this.I0.J3();
            if (view2.getId() == R.id.obfuscated_res_0x7f090bcb) {
                i32 = this.B0.j3(true, W6());
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091fd4) {
                i32 = this.B0.j3(false, W6());
            } else {
                i32 = this.B0.i3(W6());
            }
            view2.setTag(Boolean.valueOf(i32));
            if (i32) {
                this.I0.u3(true);
                this.I0.m4();
                this.h = true;
                this.I0.y3(true);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
        }
    }

    public final void R7(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, view2) == null) && (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String)) {
            String string = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
            TiebaStatic.log(new StatisticItem("c10912").param("fid", this.B0.s1().o()).param("tid", this.B0.s1().T()).param("lotterytail", StringUtils.string(string, "_", TbadkCoreApplication.getCurrentAccount())));
            if (this.B0.s1().T().equals(string)) {
                this.I0.N3(0);
            } else {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getActivity()).createNormalCfg(string, (String) null, (String) null, (String) null)));
            }
        }
    }

    public final void m8(View view2) {
        SparseArray sparseArray;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048717, this, view2) == null) && (sparseArray = (SparseArray) view2.getTag()) != null && (sparseArray.get(R.id.tag_load_sub_data) instanceof nwa)) {
            nwa nwaVar = (nwa) sparseArray.get(R.id.tag_load_sub_data);
            View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
            if (nwaVar != null && view3 != null) {
                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0908bd);
                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f0908be);
                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090bc7);
                boolean z3 = false;
                if (nwaVar.G0()) {
                    nwaVar.m1(false);
                    q4a.e(nwaVar);
                } else {
                    if (l0() != null) {
                        z3 = q4a.c(l0().s1(), nwaVar);
                    }
                    if (z3) {
                        nwaVar.m1(true);
                    }
                }
                if (nwaVar.G0()) {
                    i4 = R.color.CAM_X0201;
                } else {
                    i4 = R.color.transparent;
                }
                SkinManager.setBackgroundColor(findViewById, i4);
                boolean G0 = nwaVar.G0();
                int i7 = R.color.CAM_X0304;
                if (G0) {
                    i5 = R.color.CAM_X0304;
                } else {
                    i5 = R.color.CAM_X0107;
                }
                SkinManager.setViewTextColor(eMTextView, i5);
                if (nwaVar.G0()) {
                    i6 = R.drawable.icon_pure_pb_del_select;
                } else {
                    i6 = R.drawable.icon_pure_pb_del_normal;
                }
                if (!nwaVar.G0()) {
                    i7 = R.color.CAM_X0107;
                }
                WebPManager.setPureDrawable(imageView, i6, i7, null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void w6(AgreeData agreeData) {
        xo5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048787, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.e0 == null) {
            this.e0 = new u45();
        }
        if (this.i0 == null) {
            AgreeMessageData agreeMessageData = new AgreeMessageData();
            this.i0 = agreeMessageData;
            agreeMessageData.uniqueId = getUniqueId();
        }
        lw4 lw4Var = new lw4();
        lw4Var.b = 5;
        lw4Var.h = 8;
        lw4Var.g = 2;
        if (l0() != null) {
            lw4Var.f = l0().r1();
        }
        lw4Var.a = 2;
        int i4 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                lw4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.e0.c(agreeData, i4, getUniqueId(), false);
                this.e0.d(agreeData, this.i0);
                pbModel = this.B0;
                if (pbModel == null && pbModel.s1() != null) {
                    this.e0.b(u0(), lw4Var, agreeData, this.B0.s1().R());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            lw4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            lw4Var.i = 1;
        }
        i4 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
        if (currentVisiblePageExtra != null) {
        }
        this.e0.c(agreeData, i4, getUniqueId(), false);
        this.e0.d(agreeData, this.i0);
        pbModel = this.B0;
        if (pbModel == null) {
        }
    }

    public final void C6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.s1() != null) {
                mwa C = this.B0.s1().C();
                if (C != null) {
                    if (C.getAdvertAppInfo() != null) {
                        C.getAdvertAppInfo().h = null;
                    }
                    this.B0.s1().d();
                }
                if (this.B0.K0() != null) {
                    this.B0.y0();
                }
                this.B0.X1();
            }
            if (this.B0.s1().I() != null) {
                Iterator<nwa> it = this.B0.s1().I().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof mwa) {
                        it.remove();
                    }
                }
            }
            if (this.I0.G0() != null && !ListUtils.isEmpty(this.I0.G0().l())) {
                d4a.b(this.I0.G0().l());
            }
            if (this.I0.Z0() != null && !ListUtils.isEmpty(this.I0.Z0().getData())) {
                d4a.b(this.I0.Z0().getData());
            }
            if (this.I0.G0() != null) {
                this.I0.G0().v();
            }
        }
    }

    public final void Q6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.I0.s0();
            SparseArray<Object> a12 = this.I0.a1(this.B0.s1(), this.B0.L1(), 1);
            if (a12 == null) {
                return;
            }
            sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(getPageContext().getPageActivity(), this.B0.s1().n().getId(), this.B0.s1().n().getName(), this.B0.s1().R().getId(), StringUtils.string(this.B0.s1().Y().getUserId()), StringUtils.string(a12.get(R.id.tag_forbid_user_name)), StringUtils.string(a12.get(R.id.tag_forbid_user_name_show)), StringUtils.string(a12.get(R.id.tag_forbid_user_post_id)), StringUtils.string(a12.get(R.id.tag_forbid_user_portrait)))));
        }
    }

    public final String W6() {
        InterceptResult invokeV;
        ArrayList<nwa> I;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel == null || pbModel.s1() == null || this.B0.s1().I() == null || (count = ListUtils.getCount((I = this.B0.s1().I()))) == 0) {
                return "";
            }
            if (this.B0.E1()) {
                Iterator<nwa> it = I.iterator();
                while (it.hasNext()) {
                    nwa next = it.next();
                    if (next != null && next.L() == 1) {
                        return next.U();
                    }
                }
            }
            int Q0 = this.I0.Q0();
            nwa nwaVar = (nwa) ListUtils.getItem(I, Q0);
            if (nwaVar != null && nwaVar.u() != null) {
                if (this.B0.n2(nwaVar.u().getUserId())) {
                    return nwaVar.U();
                }
                for (int i4 = Q0 - 1; i4 != 0; i4--) {
                    nwa nwaVar2 = (nwa) ListUtils.getItem(I, i4);
                    if (nwaVar2 == null || nwaVar2.u() == null || nwaVar2.u().getUserId() == null) {
                        break;
                    } else if (this.B0.n2(nwaVar2.u().getUserId())) {
                        return nwaVar2.U();
                    }
                }
                for (int i5 = Q0 + 1; i5 < count; i5++) {
                    nwa nwaVar3 = (nwa) ListUtils.getItem(I, i5);
                    if (nwaVar3 == null || nwaVar3.u() == null || nwaVar3.u().getUserId() == null) {
                        break;
                    } else if (this.B0.n2(nwaVar3.u().getUserId())) {
                        return nwaVar3.U();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final boolean k9() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.s1() != null && this.B0.s1().a()) {
                return true;
            }
            if (this.B0.d1()) {
                MarkData O0 = this.B0.O0();
                if (O0 == null || !this.B0.b1()) {
                    return true;
                }
                MarkData I0 = this.B0.I0(this.I0.Q0());
                if (I0 == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", O0);
                    this.a.setResult(-1, intent);
                    return true;
                } else if (I0.getPostId() != null && !I0.getPostId().equals(O0.getPostId())) {
                    f05 f05Var = new f05(getPageContext().getPageActivity());
                    f05Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f02a4));
                    f05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04d2, new s2(this, I0, O0, f05Var));
                    f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new t2(this, O0, f05Var));
                    f05Var.setOnCalcelListener(new u2(this, O0, f05Var));
                    f05Var.create(getPageContext());
                    f05Var.show();
                    return false;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", O0);
                    this.a.setResult(-1, intent2);
                    return true;
                }
            }
            if (this.B0.s1() != null && this.B0.s1().I() != null && this.B0.s1().I().size() > 0 && this.B0.b1()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void l7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048712, this) == null) {
            if (this.f) {
                this.O = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.B0.s1() != null && this.B0.s1().R() != null && this.B0.s1().R().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.B0.s1().R().getTaskInfoData().k(), this.B0.s1().R().getTaskInfoData().h(), this.B0.s1().R().getTaskInfoData().c(), this.B0.s1().R().getTaskInfoData().d(), this.B0.s1().R().getIs_top(), this.B0.s1().R().getIs_good())));
                this.a.finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048744, this) == null) {
            this.f = false;
            super.onResume();
            if (this.O) {
                this.O = false;
                l7();
            }
            if (E7()) {
                this.t = System.currentTimeMillis();
            } else {
                this.t = -1L;
            }
            o1a o1aVar = this.I0;
            if (o1aVar != null && o1aVar.u1() != null) {
                if (!this.g) {
                    X8();
                } else {
                    hideLoadingView(this.I0.u1());
                }
                this.I0.F2();
            }
            if (this.j == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            o1a o1aVar2 = this.I0;
            if (o1aVar2 != null) {
                noNetworkView = o1aVar2.a();
            }
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.update(false);
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.E1);
            this.R0 = false;
            G8();
            registerListener(this.Z1);
            registerListener(this.a2);
            registerListener(this.c2);
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.q1) {
                y8();
                this.q1 = false;
            }
            f9();
            ItemCardHelper.w(this.J2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                td5.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048747, this) == null) {
            super.onStop();
            if (this.t > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.t;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.t = 0L;
            }
            if (i7().k1() != null) {
                i7().k1().n();
            }
            e5a e5aVar = this.I0.j;
            if (e5aVar != null && !e5aVar.n()) {
                this.I0.j.r();
            }
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.s1() != null && this.B0.s1().n() != null && this.B0.s1().R() != null) {
                qd5.j().x(getPageContext().getPageActivity(), "pb", this.B0.s1().n().getId(), JavaTypesHelper.toLong(this.B0.s1().R().getId(), 0L));
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            qua.g().h(getUniqueId(), false);
        }
    }

    public final void C8(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) != null) || this.s0) {
            return;
        }
        c6a.I(1, this.B0);
        SparseArray sparseArray = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
        if (sparseArray != null && (sparseArray.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_is_top_question)).booleanValue()) {
            c6a.v(2);
        }
        c6a.N(1, 2);
        if (this.u) {
            this.u = false;
            c6a.N(20, 2);
            return;
        }
        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
        if (!(tbRichTextView.getTag() instanceof SparseArray)) {
            c6a.N(20, 2);
            return;
        }
        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
        if (!(obj instanceof nwa)) {
            c6a.N(20, 2);
            return;
        }
        nwa nwaVar = (nwa) obj;
        PbModel pbModel = this.B0;
        if (pbModel != null && pbModel.s1() != null && i7().j1() != null && nwaVar.u() != null && nwaVar.L() != 1) {
            if (!checkUpIsLogin()) {
                c6a.N(2, 2);
                return;
            } else if (nwaVar.E0()) {
                return;
            } else {
                if (i7().k1() != null) {
                    i7().k1().g();
                }
                qw9 qw9Var = new qw9();
                qw9Var.v(this.B0.s1().n());
                qw9Var.z(this.B0.s1().R());
                qw9Var.x(nwaVar);
                i7().j1().k0(qw9Var);
                i7().j1().setPostId(nwaVar.U());
                Q7(view2, nwaVar.u().getUserId(), "", nwaVar);
                TiebaStatic.log("c11743");
                c6a.b(this.B0.s1(), nwaVar, nwaVar.h0, 8, 1);
                eh5 eh5Var = this.Y0;
                if (eh5Var != null) {
                    this.I0.p3(eh5Var.C());
                    return;
                }
                return;
            }
        }
        c6a.N(20, 2);
    }

    public final void h8(View view2) {
        aw9 s12;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, view2) == null) {
            if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (s12 = this.B0.s1()) == null) {
                return;
            }
            ThreadData R = s12.R();
            if (R != null && R.getAuthor() != null) {
                c6a.x(4, this.B0);
            }
            PbModel pbModel = this.B0;
            AbsPbActivity u02 = u0();
            o1a o1aVar = this.I0;
            int i5 = 6;
            if (view2.getId() == R.id.share_num_container) {
                i4 = 5;
            } else {
                i4 = 6;
            }
            c6a.O(pbModel, u02, o1aVar, i4);
            if (!BdUtilHelper.isNetOk()) {
                showToast(R.string.obfuscated_res_0x7f0f0e70);
            } else if (s12 == null) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1036));
            } else {
                ArrayList<nwa> I = this.B0.s1().I();
                if ((I == null || I.size() <= 0) && this.B0.L1()) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1036));
                    return;
                }
                this.I0.s0();
                i9();
                if (s12.D() != null && !StringUtils.isNull(s12.D().a(), true)) {
                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.B0.s1().o()));
                }
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), R)) {
                    return;
                }
                o1a o1aVar2 = this.I0;
                if (o1aVar2 != null) {
                    o1aVar2.u0();
                    this.I0.E4(s12);
                }
                if (ShareSwitch.isOn()) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091ba7) {
                        i5 = 2;
                    } else if (view2.getId() == R.id.share_num_container) {
                        i5 = 1;
                    }
                    if (this.I0.n2() && !s12.q0()) {
                        c9(i5);
                        return;
                    } else {
                        c9(i5);
                        return;
                    }
                }
                this.I0.e4();
                this.B0.M0().Q(CheckRealNameModel.TYPE_PB_SHARE, 6);
            }
        }
    }

    public final void i8(View view2) {
        SparseArray sparseArray;
        boolean z3;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048700, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            nwa nwaVar = (nwa) sparseArray.get(R.id.tag_clip_board);
            if (nwaVar == null) {
                return;
            }
            if (this.O0 == null) {
                p05 p05Var = new p05(getContext());
                this.O0 = p05Var;
                p05Var.r(this.k2);
            }
            ArrayList arrayList = new ArrayList();
            if (l0().s1() != null && l0().s1().a()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (view2 != null && sparseArray != null) {
                boolean b4 = p4a.b(sparseArray, R.id.tag_del_post_is_self, false);
                boolean b5 = p4a.b(sparseArray, R.id.tag_user_mute_visible, false);
                boolean b6 = p4a.b(sparseArray, R.id.tag_should_manage_visible, false);
                boolean b7 = p4a.b(sparseArray, R.id.tag_user_mute_visible, false);
                boolean b8 = p4a.b(sparseArray, R.id.tag_should_delete_visible, false);
                boolean b9 = p4a.b(sparseArray, R.id.tag_is_self_post, false);
                String c4 = p4a.c(sparseArray, R.id.tag_forbid_user_post_id, "");
                if (nwaVar.p() != null) {
                    boolean z4 = nwaVar.p().hasAgree;
                    int q3 = nwaVar.q();
                    if (z4 && q3 == 5) {
                        string = getString(R.string.action_cancel_dislike);
                    } else {
                        string = getString(R.string.action_dislike);
                    }
                    l05 l05Var = new l05(8, string, this.O0);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, nwaVar);
                    l05Var.d.setTag(sparseArray2);
                    arrayList.add(l05Var);
                }
                g4a.d(this.O0, b6, b5, sparseArray, arrayList, this.mIsLogin, B7());
                g4a.e(this.O0, b6, b5, arrayList, z3, c4, this.mIsLogin, B7(), n1a.y(this.B0.s1(), b4));
                g4a.b(this.O0, sparseArray, arrayList, b4, b6, b7, b8, b9, c4, this.mIsLogin, B7());
                g4a.a(this.O0, sparseArray, arrayList, b4, b6, b7, b8, b9, c4, this.mIsLogin, B7(), this.B0.s1().Z());
                this.O0.m(arrayList);
                n05 n05Var = new n05(getPageContext(), this.O0);
                this.N0 = n05Var;
                n05Var.l();
            }
        }
    }

    public final void j8(View view2) {
        StatisticItem statisticItem;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048704, this, view2) != null) || this.B0 == null) {
            return;
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f091c23) {
            c6a.I(6, this.B0);
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f091df0) {
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                this.f1134T = view2;
                return;
            }
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091c23 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
            this.f1134T = view2;
            return;
        }
        if (!checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof nwa)) {
            return;
        }
        nwa nwaVar = (nwa) sparseArray.get(R.id.tag_load_sub_data);
        if (view2.getId() == R.id.obfuscated_res_0x7f091c23 && (statisticItem = nwaVar.i0) != null) {
            StatisticItem copy = statisticItem.copy();
            copy.delete("obj_locate");
            copy.param("obj_locate", 8);
            TiebaStatic.log(copy);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091df0 || view2.getId() == R.id.obfuscated_res_0x7f091bb4) {
            c6a.B(this.B0, nwaVar);
        }
        PbModel pbModel = this.B0;
        if (pbModel != null && pbModel.s1() != null && i7().j1() != null && nwaVar.u() != null && nwaVar.L() != 1) {
            if (i7().k1() != null) {
                i7().k1().g();
            }
            qw9 qw9Var = new qw9();
            qw9Var.v(this.B0.s1().n());
            qw9Var.z(this.B0.s1().R());
            qw9Var.x(nwaVar);
            i7().j1().k0(qw9Var);
            i7().j1().setPostId(nwaVar.U());
            Q7(view2, nwaVar.u().getUserId(), "", nwaVar);
            eh5 eh5Var = this.Y0;
            if (eh5Var != null) {
                this.I0.p3(eh5Var.C());
            }
        }
    }

    @Override // com.baidu.tieba.xy5
    public void D0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.P0 = str;
            if (this.k == null) {
                A7();
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

    public final void Q8(int i4, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048634, this, i4, antiData, str) == null) {
            if (AntiHelper.m(i4, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i4, new j2(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i4 == 230277) {
                d9(str);
            } else {
                this.I0.v4(str);
            }
        }
    }

    public void D6(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(o1a.i2)).intValue();
            if (intValue == o1a.j2) {
                if (this.E0.h0()) {
                    return;
                }
                this.I0.x4();
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
                    this.E0.j0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.E0.k0(this.B0.s1().n().getId(), this.B0.s1().n().getName(), this.B0.s1().R().getId(), str, intValue3, intValue2, booleanValue, this.B0.s1().R().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                br6.b().c(new y95(this.B0.M1()));
            } else if (intValue == o1a.k2 || intValue == o1a.m2) {
                PbModel pbModel = this.B0;
                if (pbModel != null && pbModel.N0() != null) {
                    this.B0.N0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == o1a.k2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public void H6(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i4, i5) == null) {
            TiebaStatic.log("c12181");
            o1a o1aVar = this.I0;
            if (o1aVar != null && this.B0 != null) {
                if ((o1aVar == null || o1aVar.a2()) && this.B0.s1() != null && this.B0.s1().V() != null) {
                    o1a o1aVar2 = this.I0;
                    if (o1aVar2 != null && o1aVar2.O0() != null && this.I0.O0().r()) {
                        return;
                    }
                    pw9 V = this.B0.s1().V();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!V.e() || V.a() != 2) && this.I0.G0() != null && this.I0.G0().p() != null) {
                        this.I0.G0().p().L(this.B0.M1(), this.B0.getFromForumId());
                    }
                    if (i4 > -1 && i5 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        PbFirstFloorDoubleClickAnimation pbFirstFloorDoubleClickAnimation = new PbFirstFloorDoubleClickAnimation(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.B0;
                        pbFirstFloorDoubleClickAnimation.show(findViewById, i4, i5, pbModel.b, pbModel.getForumId());
                        pbFirstFloorDoubleClickAnimation.setOnPraiseAnimatorListener(new y0(this));
                    } else if (System.currentTimeMillis() - this.v > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.v = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public final void O6(int i4, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048624, this, i4, gVar) != null) || gVar == null) {
            return;
        }
        this.I0.B0(this.E0.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.J0 = true;
            if (i4 != 2 && i4 != 3) {
                if (i4 == 4 || i4 == 5) {
                    this.K0 = false;
                    this.L0 = true;
                }
            } else {
                this.K0 = true;
                this.L0 = false;
            }
            if (i4 == 2) {
                this.B0.s1().R().setIs_good(1);
                this.B0.T2(1);
            } else if (i4 == 3) {
                this.B0.s1().R().setIs_good(0);
                this.B0.T2(0);
            } else if (i4 == 4) {
                this.B0.s1().R().setIs_top(1);
                this.B0.U2(1);
            } else if (i4 == 5) {
                this.B0.s1().R().setIs_top(0);
                this.B0.U2(0);
            }
            this.I0.F4(this.B0.s1(), this.B0.L1());
            if (i4 == 4 || i4 == 5) {
                br6.b().c(new th5(gVar.d));
                return;
            }
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.operation_failed);
        }
        BdUtilHelper.showToast(getPageContext().getPageActivity(), string);
    }

    public final void R8(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048637, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (i7() != null) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    String questionMsg = postWriteCallBackData.getQuestionMsg();
                    String questionExp = postWriteCallBackData.getQuestionExp();
                    if (postWriteCallBackData.getIconStampData() != null) {
                        yb5.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            fu9.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            fu9.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            fu9.e(getResources().getString(R.string.obfuscated_res_0x7f0f14d2));
                            return;
                        } else {
                            fu9.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.B0.f1()) {
                antiData.setBlock_forum_name(this.B0.s1().n().getName());
                antiData.setBlock_forum_id(this.B0.s1().n().getId());
                antiData.setUser_name(this.B0.s1().Y().getUserName());
                antiData.setUser_id(this.B0.s1().Y().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void W8(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048654, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            n05 n05Var = this.N0;
            if (n05Var != null && n05Var.isShowing()) {
                this.N0.dismiss();
                this.N0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            p05 p05Var = new p05(getContext());
            p05Var.r(new o0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i4 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i4 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i4 == 1) {
                arrayList.add(new l05(0, getResources().getString(R.string.obfuscated_res_0x7f0f055b), p05Var));
            }
            if (z3) {
                arrayList.add(new l05(1, getResources().getString(R.string.un_mute), p05Var));
            } else {
                arrayList.add(new l05(1, getResources().getString(R.string.obfuscated_res_0x7f0f0d47), p05Var));
            }
            p05Var.m(arrayList);
            n05 n05Var2 = new n05(getPageContext(), p05Var);
            this.N0 = n05Var2;
            n05Var2.l();
        }
    }

    public final void h9(nwa nwaVar, boolean z3) {
        PbModel pbModel;
        int i4;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048697, this, nwaVar, z3) == null) {
            J8(false);
            if (nwaVar == null || (pbModel = this.B0) == null || pbModel.s1() == null || nwaVar.L() == 1) {
                return;
            }
            String M1 = this.B0.M1();
            String U = nwaVar.U();
            if (this.B0.s1() != null) {
                i4 = this.B0.s1().Z();
            } else {
                i4 = 0;
            }
            AbsPbActivity.e s8 = s8(U);
            if (s8 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo n02 = nwaVar.n0();
            AntiData f4 = this.B0.s1().f();
            if (nwaVar.u() != null) {
                arrayList = nwaVar.u().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(M1, U, "pb", true, false, null, false, null, i4, n02, f4, false, arrayList, 5).addBigImageData(s8.a, s8.b, s8.g, s8.j);
            addBigImageData.setKeyPageStartFrom(this.B0.r1());
            addBigImageData.setFromFrsForumId(this.B0.getFromForumId());
            addBigImageData.setWorksInfoData(this.B0.R1());
            addBigImageData.setKeyFromForumId(this.B0.getForumId());
            addBigImageData.setBjhData(this.B0.J0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public void E6(f05 f05Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, f05Var, jSONArray) == null) {
            f05Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(f05Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                D6((SparseArray) f05Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    @Override // com.baidu.tieba.xy5
    public void b0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048668, this, context, str) == null) {
            if (!StringUtils.isNull(str) && !TextUtils.isDigitsOnly(str) && fy9.a(str)) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("TargetSchemeInterceptHelper", "jump targetScheme: " + str);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            }
            this.u = true;
        }
    }

    public final boolean E7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            nwa d4 = bw9.d(this.B0.s1(), this.B0.L1(), this.B0.D1());
            if (d4 != null && d4.u() != null && d4.u().getGodUserData() != null && d4.u().getGodUserData().getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void J7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.I0.s0();
            if (l0().s1().g == 2) {
                showToast(R.string.hot_sort_jump_hint);
                return;
            }
            if (this.B0.q1() != null) {
                this.I0.q4(this.B0.q1(), this.i2);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
        }
    }

    public final void M7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.I0.s0();
            i9();
            this.I0.J3();
            this.I0.e4();
            if (this.I0.i1() != null) {
                this.I0.i1().setVisibility(8);
            }
            this.B0.e3(1);
            b3a b3aVar = this.e;
            if (b3aVar != null) {
                b3aVar.x();
            }
        }
    }

    public final void N7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && this.R2 != null) {
            if (this.P2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f1034);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.R2.a(), this.P2, 0)));
                this.a.finish();
            }
        }
    }

    public final void P7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048629, this) == null) && this.R2 != null) {
            if (this.O2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f1035);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.R2.a(), this.O2, 0)));
                this.a.finish();
            }
        }
    }

    public final void V8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            f05 f05Var = new f05(getPageContext().getPageActivity());
            f05Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            f05Var.setPositiveButton(R.string.open_now, new j(this));
            f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new l(this));
            f05Var.create(this.h1).show();
        }
    }

    public final void X8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            showLoadingView(this.I0.u1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d6));
            View attachedView = getLoadingView().getAttachedView();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
            layoutParams.addRule(3, this.I0.t1().getId());
            attachedView.setLayoutParams(layoutParams);
        }
    }

    public final void Y7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048660, this) == null) && getPageContext().getPageActivity() != null && this.B0 != null) {
            sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(getPageContext().getPageActivity(), this.B0.M1(), this.B0.f2(), this.B0.e2())));
            c6a.C(this.B0);
        }
    }

    public final void j7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048703, this) == null) {
            if (this.G0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.G0 = pollingModel;
                pollingModel.setDialogTime(y05.e);
            }
            this.G0.getData(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            SafeHandler.getInst().postDelayed(this.Y1, 10000L);
        }
    }

    public final void l6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048711, this) == null) {
            if (this.o1 != null) {
                hj5.b bVar = new hj5.b();
                bVar.a = this.o1.S();
                bVar.b = this.o1.Q();
                bVar.c = String.valueOf(this.o1.T());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.n1));
        }
    }

    public final void l8() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048713, this) == null) && this.r1 >= 0) {
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                pbModel.L2();
            }
            if (this.B0 != null && this.I0.G0() != null) {
                this.I0.G0().D(this.B0.s1(), false);
            }
            this.r1 = 0;
            if (this.B0 != null) {
                if (this.I0.Z0() != null) {
                    this.I0.Z0().setSelection(this.B0.l1());
                }
                this.B0.P2(0, 0);
            }
        }
    }

    public final void m7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.I0.u3(true);
            this.I0.h3();
            if (this.h) {
                return;
            }
            this.h = true;
            this.I0.m4();
            i9();
            this.I0.J3();
            this.B0.i3(W6());
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
        }
    }

    public final void m9() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048718, this) == null) && (pbModel = this.B0) != null && pbModel.s1() != null) {
            aw9 s12 = this.B0.s1();
            if (this.F0 == null) {
                this.F0 = new sw9(getPageContext());
            }
            long j4 = JavaTypesHelper.toLong(s12.T(), 0L);
            long j5 = JavaTypesHelper.toLong(s12.o(), 0L);
            c6a.M("c13446", j5);
            registerListener(this.r2);
            this.F0.a(j4, j5);
        }
    }

    public final void p9() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048753, this) == null) && (absPbActivity = this.a) != null && absPbActivity.B1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.B1().M1()).param("topic_id", this.a.B1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.B1().Q1()));
        }
    }

    public final boolean r6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel == null || pbModel.s1() == null) {
                return false;
            }
            ThreadData R = this.B0.s1().R();
            AntiData f4 = this.B0.s1().f();
            if (!AntiHelper.b(getPageContext(), R) && !AntiHelper.d(getPageContext(), f4)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void s9() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048767, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.T(this.B0.getForumId()) && this.B0.s1() != null && this.B0.s1().n() != null) {
            boolean z3 = true;
            if (this.B0.s1().n().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.B0.F0().S(this.B0.getForumId(), this.B0.M1());
            }
        }
    }

    public boolean u6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) {
            if ((this.B0.s1() != null && (this.B0.s1().a() || ThreadCardUtils.isSelf(this.B0.s1().R()))) || this.a1 == null || this.B0.s1() == null || this.B0.s1().f() == null) {
                return true;
            }
            return this.a1.checkPrivacyBeforeInvokeEditor(this.B0.s1().f().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void x6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048791, this) == null) {
            if (this.B0.X0() || this.B0.a1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.B0.M1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.B0.M1()));
            if (k9()) {
                this.a.finish();
            }
        }
    }

    public final void y6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048794, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            UtilHelper.showSkinChangeAnimation(getActivity());
            onChangeSkinType(skinType);
            UtilHelper.setNavigationBarBackground(getActivity(), getResources().getColor(R.color.CAM_X0201_2));
            if (skinType == 0) {
                TbadkCoreApplication.getInst().setSkinType(4);
            } else {
                SharedPrefHelper.getInstance().putBoolean("key_is_follow_system_mode", false);
                SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
            }
            this.I0.j.g();
        }
    }

    public void F6(int i4, String str, int i5, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i4), str, Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i5));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(o1a.i2, Integer.valueOf(o1a.j2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                D6(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void F8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (pbModel = this.B0) != null && pbModel.s1() != null && this.B0.s1().R() != null && this.B0.s1().R().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void G8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (pbModel = this.B0) != null && pbModel.s1() != null && this.B0.s1().R() != null && this.B0.s1().R().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public final int S6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (this.B0.s1() != null && this.B0.s1().R() != null) {
                return this.B0.s1().R().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final boolean U8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel == null || !pbModel.L1()) {
                return false;
            }
            if (this.B0.q1() != null && this.B0.q1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void d8() {
        List<i3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048679, this) == null) && (list = this.t1) != null && !list.isEmpty()) {
            int size = this.t1.size();
            while (true) {
                size--;
                if (size <= -1 || this.t1.get(size).onBackPressed()) {
                    return;
                }
            }
        }
    }

    public final void e8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.I0.s0();
            if (this.h) {
                return;
            }
            i9();
            this.I0.J3();
            if (this.B0.loadData()) {
                this.I0.m4();
            }
        }
    }

    public final void f9() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048687, this) == null) && (pbModel = this.B0) != null && !rd.isEmpty(pbModel.M1())) {
            po4.w().Q(oo4.Z, JavaTypesHelper.toLong(this.B0.M1(), 0L));
        }
    }

    public final void s7() {
        TiebaPlusConfigData tiebaPlusConfigData;
        String jumpUrlWithTid;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048765, this) == null) && (tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData()) != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.B0.M1())) != null) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{jumpUrlWithTid});
            this.I0.j.f();
            TiebaPlusConfigData.addClickStatsForFireLink(3);
        }
    }

    public final boolean t6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.s1() != null && this.B0.s1().j() != null && !TextUtils.isEmpty(this.B0.s1().j().l)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void t7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048770, this) == null) && this.a != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.a.getCurrentFocus() != null) {
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final void G6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            SparseArray<Object> a12 = this.I0.a1(this.B0.s1(), this.B0.L1(), 1);
            if (a12 != null) {
                if (StringUtils.isNull((String) a12.get(R.id.tag_del_multi_forum))) {
                    this.I0.K2(((Integer) a12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(a12.get(R.id.tag_del_post_id)), ((Integer) a12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) a12.get(R.id.tag_del_post_is_self)).booleanValue());
                } else {
                    this.I0.L2(((Integer) a12.get(R.id.tag_del_post_type)).intValue(), (String) a12.get(R.id.tag_del_post_id), ((Integer) a12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) a12.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(a12.get(R.id.tag_del_multi_forum)));
                }
            }
            this.I0.j.f();
        }
    }

    public final void H7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.B0.s1() != null && this.B0.s1().R() != null && this.B0.s1().R().getActUrl() != null) {
            BrowserHelper.startWebActivity(getActivity(), this.B0.s1().R().getActUrl());
            if (this.B0.s1().R().getActInfoType() == 1) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
            } else if (this.B0.s1().R().getActInfoType() == 2) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
            }
        }
    }

    public final void V7() {
        MarkData I0;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && this.D0 != null) {
            if (this.B0.s1() != null && this.B0.s1().a()) {
                I0 = this.B0.I0(0);
            } else {
                I0 = this.B0.I0(this.I0.Y0());
            }
            if (I0 == null) {
                return;
            }
            if (I0.isApp() && (I0 = this.B0.I0(this.I0.Y0() + 1)) == null) {
                return;
            }
            this.I0.J3();
            this.D0.i(I0);
            if (!this.D0.e()) {
                if (this.I0 != null && (pbModel = this.B0) != null && !t4a.g(pbModel.b)) {
                    this.I0.p4();
                    t4a.a(this.B0.b);
                }
                this.D0.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.D0.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final void Z7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
            if (this.B0.s1() != null && this.B0.s1().R() != null && this.B0.s1().R().isVideoThreadType() && this.B0.s1().R().getThreadVideoInfo() != null) {
                TiebaStatic.log(new StatisticItem("c11922"));
            }
            String a4 = f4a.a(this.B0);
            if (StringUtils.isNull(a4)) {
                this.a.finish();
                return;
            }
            String R0 = this.B0.R0();
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(a4, FrsActivityConfig.FRS_FROM_PB);
            if (this.B0.X0() && R0 != null && R0.equals(a4)) {
                this.a.finish();
            } else {
                sendMessage(new CustomMessage(2003000, createNormalCfg));
            }
        }
    }

    public final void k6() {
        PbModel pbModel;
        aw9 aw9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048706, this) == null) && (pbModel = this.B0) != null && (aw9Var = pbModel.G) != null && aw9Var.R() != null) {
            ThreadData R = this.B0.G.R();
            R.mRecomAbTag = this.B0.y1();
            R.mRecomWeight = this.B0.B1();
            R.mRecomSource = this.B0.A1();
            R.mRecomExtra = this.B0.z1();
            R.isSubPb = this.B0.f1();
            if (R.getFid() == 0) {
                R.setFid(JavaTypesHelper.toLong(this.B0.getForumId(), 0L));
            }
            StatisticItem i4 = cp5.i(getContext(), R, "c13562");
            TbPageTag l3 = cp5.l(getContext());
            if (l3 != null && "a008".equals(l3.locatePage)) {
                i4.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i4.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a008");
            }
            if (l3 != null && "a002".equals(l3.locatePage)) {
                i4.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i4.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            if (i4 != null) {
                TiebaStatic.log(i4);
            }
        }
    }

    public final void m6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            SparseArray<Object> a12 = this.I0.a1(this.B0.s1(), this.B0.L1(), 1);
            if (a12 != null) {
                this.I0.N2(((Integer) a12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(a12.get(R.id.tag_del_post_id)), ((Integer) a12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) a12.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            this.I0.j.f();
            if (l0() != null && l0().s1() != null && l0().s1().R() != null) {
                c6a.G(l0().s1().R());
            }
        }
    }

    public final void n9() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048723, this) == null) && (pbModel = this.B0) != null && pbModel.s1() != null && this.B0.s1().n() != null && !rd.isEmpty(this.B0.s1().n().getName())) {
            String a4 = f4a.a(this.B0);
            if (StringUtils.isNull(a4)) {
                this.a.finish();
                return;
            }
            String R0 = this.B0.R0();
            if (this.B0.X0() && R0 != null && R0.equals(a4)) {
                this.a.finish();
            } else {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(this.B0.s1().n().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            }
            c6a.A(this.B0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048742, this) == null) {
            this.f = true;
            super.onPause();
            q4a.a();
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
            o1a o1aVar = this.I0;
            if (o1aVar != null) {
                o1aVar.B2();
            }
            if (this.Y0 != null && !this.B0.f1()) {
                this.Y0.R(this.B0.M1());
            }
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                pbModel.w2();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            po4.w().E();
            MessageManager.getInstance().unRegisterListener(this.E1);
            F8();
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            vb5 vb5Var = this.j0;
            if (vb5Var != null) {
                vb5Var.o();
                this.j0.n();
            }
        }
    }

    public final void p6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048750, this) == null) {
            this.I0.j.g();
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                this.v1.f(pbModel.M1());
            }
            int i4 = 1;
            PbModel pbModel2 = this.B0;
            if (pbModel2 != null && pbModel2.isPrivacy()) {
                showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (l0() != null && l0().s1() != null) {
                    this.v1.d(3, 3, l0().s1().T());
                    return;
                }
                return;
            }
            this.v1.b();
            if (!TbSingleton.getInstance().mCanCallFans && l0() != null && l0().s1() != null && l0().s1().T() != null && l0().s1().T().equals(TbSingleton.getInstance().mCallFansTid)) {
                i4 = 2;
            }
            if (l0() != null && l0().s1() != null) {
                this.v1.d(3, i4, l0().s1().T());
            }
        }
    }

    public final void G7(View view2) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, view2) == null) && view2 != null) {
            BrowserHelper.startWebActivity(getActivity(), StringUtils.string(view2.getTag()));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (S6() == 1 && (pbModel = this.B0) != null && pbModel.s1() != null) {
                c6a.D("c10397", this.B0.s1().o(), this.B0.s1().T(), currentAccount);
            }
        }
    }

    public final void I7(View view2) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, view2) == null) && view2 != null) {
            String string = StringUtils.string(view2.getTag());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            BrowserHelper.startWebActivity(getActivity(), string);
            if (S6() == 1 && (pbModel = this.B0) != null && pbModel.s1() != null) {
                c6a.D("c10507", this.B0.s1().o(), this.B0.s1().T(), currentAccount);
            }
        }
    }

    public final void M8(fh5 fh5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, fh5Var) == null) && fh5Var != null && (pbModel = this.B0) != null) {
            fh5Var.p(pbModel.R0());
            if (this.B0.s1() != null && this.B0.s1().n() != null) {
                fh5Var.o(this.B0.s1().n());
            }
            fh5Var.q("pb");
            fh5Var.r(this.B0);
            fh5Var.s(PbNewEditorTool.InputShowType.REPLY);
        }
    }

    public final void N8(int i4) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048623, this, i4) != null) || (pbModel = this.B0) == null) {
            return;
        }
        int C1 = pbModel.C1();
        if (i4 != 5) {
            if (i4 != 6) {
                if (i4 != 7) {
                    this.B0.a3(1);
                } else {
                    this.B0.a3(4);
                }
            } else {
                this.B0.a3(3);
            }
        } else {
            this.B0.a3(2);
        }
        int C12 = this.B0.C1();
        if (C1 == 4 || C12 == 4) {
            e8();
        }
    }

    public final void O7(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bundle) == null) {
            PbModel B1 = this.a.B1();
            this.B0 = B1;
            if (B1 != null) {
                if (B1.N0() != null) {
                    this.B0.N0().c(this.N2);
                }
                if (this.B0.o1() != null) {
                    this.B0.o1().f(this.x1);
                }
                if (StringUtils.isNull(this.B0.M1())) {
                    this.a.finish();
                } else if ("from_tieba_kuang".equals(this.M) && this.M != null) {
                    this.B0.X2(6);
                }
            }
        }
    }

    public final void n8(View view2) {
        rz4 rz4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048722, this, view2) == null) && checkUpIsLogin() && (rz4Var = (rz4) view2.getTag()) != null && !StringUtils.isNull(rz4Var.H1())) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{rz4Var.H1()});
        }
    }

    public final void o6(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048725, this, view2) != null) || !(view2.getTag() instanceof ThreadData)) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
        createNormalCfg.setCallFrom(14);
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        c6a.H(threadData, 9, 9);
    }

    public void o8(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048727, this, animatorListener) == null) && this.I0 != null && (pbModel = this.B0) != null && pbModel.s1() != null && this.B0.s1().V() != null && checkUpIsLogin() && this.I0.G0() != null && this.I0.G0().p() != null) {
            this.I0.G0().p().V(animatorListener);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z3;
        o1a o1aVar;
        e5a e5aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048734, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (UtilHelper.isFoldScreen() && (o1aVar = this.I0) != null && (e5aVar = o1aVar.j) != null && e5aVar.n()) {
                this.I0.j.g();
                f8();
            }
            int i4 = configuration.orientation;
            if (i4 == this.w) {
                return;
            }
            this.w = i4;
            if (i4 == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.J = z3;
            o1a o1aVar2 = this.I0;
            if (o1aVar2 != null) {
                o1aVar2.v2(configuration);
            }
            n05 n05Var = this.N0;
            if (n05Var != null) {
                n05Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public final void q9(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048758, this, z3) == null) && (absPbActivity = this.a) != null && absPbActivity.B1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.B1().M1()).param("topic_id", this.a.B1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.B1().Q1()));
        }
    }

    public void s6(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048764, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.I0.e4();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = JavaTypesHelper.toLong(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = JavaTypesHelper.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.j1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.g1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean v6(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048782, this, i4)) == null) {
            if (this.a1 != null && this.B0.s1() != null && !ThreadCardUtils.isSelf(this.B0.s1().R()) && this.B0.s1().f() != null) {
                return this.a1.checkPrivacyBeforeSend(this.B0.s1().f().replyPrivateFlag, i4);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void L6(View view2) {
        String str;
        int i4;
        PbModel pbModel;
        aw9 aw9Var;
        nwa a02;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091a31) {
                c6a.I(4, this.B0);
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f091bba && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                this.S = view2;
            } else if (!checkUpIsLogin()) {
                c6a.u("c10517", this.B0.s1().o(), 3);
            } else {
                PbModel pbModel2 = this.B0;
                if (pbModel2 != null && pbModel2.s1() != null) {
                    this.I0.s0();
                    SparseArray sparseArray = (SparseArray) view2.getTag();
                    nwa nwaVar = (nwa) sparseArray.get(R.id.tag_load_sub_data);
                    nwa nwaVar2 = (nwa) sparseArray.get(R.id.tag_load_sub_reply_data);
                    View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
                    if (nwaVar != null && view3 != null) {
                        boolean z3 = true;
                        if (nwaVar.P() == 1) {
                            TiebaStatic.log(new StatisticItem("c12630"));
                        }
                        StatisticItem statisticItem = nwaVar.i0;
                        if (statisticItem != null) {
                            StatisticItem copy = statisticItem.copy();
                            copy.delete("obj_locate");
                            if (view2.getId() == R.id.obfuscated_res_0x7f091a31) {
                                copy.param("obj_locate", 6);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091bba) {
                                copy.param("obj_locate", 8);
                            }
                            TiebaStatic.log(copy);
                        }
                        String M1 = this.B0.M1();
                        String U = nwaVar.U();
                        if (nwaVar2 != null) {
                            str = nwaVar2.U();
                        } else {
                            str = "";
                        }
                        if (this.B0.s1() != null) {
                            i4 = this.B0.s1().Z();
                        } else {
                            i4 = 0;
                        }
                        i9();
                        if (view2.getId() == R.id.obfuscated_res_0x7f091fd9) {
                            AbsPbActivity.e s8 = s8(U);
                            PbModel pbModel3 = this.B0;
                            if (pbModel3 != null && pbModel3.s1() != null && s8 != null) {
                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(M1, U, "pb", true, false, null, true, null, i4, nwaVar.n0(), this.B0.s1().f(), false, nwaVar.u().getIconInfo(), 5).addBigImageData(s8.a, s8.b, s8.g, s8.j);
                                addBigImageData.setKeyPageStartFrom(this.B0.r1());
                                addBigImageData.setFromFrsForumId(this.B0.getFromForumId());
                                addBigImageData.setWorksInfoData(this.B0.R1());
                                addBigImageData.setKeyFromForumId(this.B0.getForumId());
                                addBigImageData.setBjhData(this.B0.J0());
                                addBigImageData.setTiebaPlusData(this.B0.X(), this.B0.T(), this.B0.U(), this.B0.S(), this.B0.Y());
                                sendMessage(new CustomMessage(2002001, addBigImageData));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log("c11742");
                        AbsPbActivity.e s82 = s8(U);
                        if (nwaVar != null && (pbModel = this.B0) != null && pbModel.s1() != null && s82 != null) {
                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(M1, U, "pb", true, false, null, false, str, i4, nwaVar.n0(), this.B0.s1().f(), false, nwaVar.u().getIconInfo(), 5).addBigImageData(s82.a, s82.b, s82.g, s82.j);
                            if (!rd.isEmpty(str)) {
                                addBigImageData2.setHighLightPostId(str);
                                addBigImageData2.setKeyIsUseSpid(true);
                            }
                            addBigImageData2.setKeyFromForumId(this.B0.getForumId());
                            addBigImageData2.setTiebaPlusData(this.B0.X(), this.B0.T(), this.B0.U(), this.B0.S(), this.B0.Y());
                            addBigImageData2.setBjhData(this.B0.J0());
                            addBigImageData2.setKeyPageStartFrom(this.B0.r1());
                            addBigImageData2.setFromFrsForumId(this.B0.getFromForumId());
                            addBigImageData2.setWorksInfoData(this.B0.R1());
                            if (this.I0 != null && (aw9Var = this.B0.G) != null && (a02 = aw9Var.a0()) != null) {
                                if (!a02.f1129T && !nwaVar.f1129T) {
                                    z3 = false;
                                }
                                addBigImageData2.setMainPostMaskVisibly(z3);
                            }
                            if (this.B0.s1() != null && this.B0.s1().q() != null) {
                                addBigImageData2.setHasForumRule(this.B0.s1().q().has_forum_rule.intValue());
                            }
                            sendMessage(new CustomMessage(2002001, addBigImageData2));
                        }
                    }
                }
            }
        }
    }

    public final void M6(View view2) {
        PbModel pbModel;
        int i4;
        aw9 aw9Var;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048617, this, view2) != null) || (pbModel = this.B0) == null) {
            return;
        }
        c6a.I(5, pbModel);
        if (view2.getId() == R.id.obfuscated_res_0x7f091c25 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
            this.S = view2;
        } else if (!checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
        } else {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof nwa)) {
                return;
            }
            nwa nwaVar = (nwa) sparseArray.get(R.id.tag_load_sub_data);
            StatisticItem statisticItem = nwaVar.i0;
            if (statisticItem != null) {
                StatisticItem copy = statisticItem.copy();
                copy.delete("obj_locate");
                copy.param("obj_locate", 8);
                TiebaStatic.log(copy);
            }
            PbModel pbModel2 = this.B0;
            if (pbModel2 != null && pbModel2.s1() != null) {
                String M1 = this.B0.M1();
                String U = nwaVar.U();
                if (this.B0.s1() != null) {
                    i4 = this.B0.s1().Z();
                } else {
                    i4 = 0;
                }
                AbsPbActivity.e s8 = s8(U);
                if (s8 == null) {
                    return;
                }
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(M1, U, "pb", true, false, null, false, null, i4, nwaVar.n0(), this.B0.s1().f(), false, nwaVar.u().getIconInfo(), 5).addBigImageData(s8.a, s8.b, s8.g, s8.j);
                addBigImageData.setKeyPageStartFrom(this.B0.r1());
                addBigImageData.setFromFrsForumId(this.B0.getFromForumId());
                addBigImageData.setWorksInfoData(this.B0.R1());
                addBigImageData.setKeyFromForumId(this.B0.getForumId());
                addBigImageData.setTiebaPlusData(this.B0.X(), this.B0.T(), this.B0.U(), this.B0.S(), this.B0.Y());
                addBigImageData.setBjhData(this.B0.J0());
                if (this.B0.s1().q() != null) {
                    addBigImageData.setHasForumRule(this.B0.s1().q().has_forum_rule.intValue());
                }
                if (this.B0.s1().Y() != null) {
                    addBigImageData.setIsManager(this.B0.s1().Y().getIs_manager());
                }
                if (this.B0.s1().n().getDeletedReasonInfo() != null) {
                    addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.B0.s1().n().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                    addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.B0.s1().n().getDeletedReasonInfo().is_boomgrow.intValue());
                }
                if (this.B0.s1().n() != null) {
                    addBigImageData.setForumHeadUrl(this.B0.s1().n().getImage_url());
                    addBigImageData.setUserLevel(this.B0.s1().n().getUser_level());
                }
                if (this.I0 != null && (aw9Var = this.B0.G) != null) {
                    if (!aw9Var.a0().f1129T && !nwaVar.f1129T) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    addBigImageData.setMainPostMaskVisibly(z3);
                }
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0105, code lost:
        if (r4.equals(r2.U()) != false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k8(View view2) {
        boolean z3;
        l05 l05Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048708, this, view2) != null) || !checkUpIsLogin()) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c11740"));
        if (view2 != null && view2.getTag() != null) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            nwa nwaVar = (nwa) sparseArray.get(R.id.tag_load_sub_data);
            boolean z4 = true;
            if (view2.getId() != R.id.replybtn_top_right && view2.getId() != R.id.cover_reply_content_top_right) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                TiebaStatic.log(new StatisticItem("c12006").param("tid", this.B0.b));
            }
            if (this.O0 == null) {
                p05 p05Var = new p05(getContext());
                this.O0 = p05Var;
                p05Var.r(this.k2);
            }
            ArrayList arrayList = new ArrayList();
            boolean b4 = p4a.b(sparseArray, R.id.tag_del_post_is_self, false);
            boolean b5 = p4a.b(sparseArray, R.id.tag_user_mute_visible, false);
            boolean b6 = p4a.b(sparseArray, R.id.tag_should_manage_visible, false);
            boolean b7 = p4a.b(sparseArray, R.id.tag_user_mute_visible, false);
            boolean b8 = p4a.b(sparseArray, R.id.tag_should_delete_visible, false);
            boolean b9 = p4a.b(sparseArray, R.id.tag_is_self_post, false);
            String c4 = p4a.c(sparseArray, R.id.tag_forbid_user_post_id, "");
            if (nwaVar != null) {
                if (nwaVar.f0() != null && nwaVar.f0().toString().length() > 0) {
                    l05 l05Var2 = new l05(3, getString(R.string.obfuscated_res_0x7f0f04f5), this.O0);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, nwaVar);
                    l05Var2.d.setTag(sparseArray2);
                    arrayList.add(l05Var2);
                }
                this.D2 = nwaVar;
            }
            if (this.B0.s1().t()) {
                String x3 = this.B0.s1().x();
                if (nwaVar != null) {
                    if (!rd.isEmpty(x3)) {
                    }
                }
            }
            z4 = false;
            if (z4) {
                l05Var = new l05(4, getString(R.string.remove_mark), this.O0);
            } else {
                l05Var = new l05(4, getString(R.string.obfuscated_res_0x7f0f0c89), this.O0);
            }
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_clip_board, this.D2);
            sparseArray3.put(R.id.tag_is_subpb, Boolean.FALSE);
            l05Var.d.setTag(sparseArray3);
            arrayList.add(l05Var);
            g4a.d(this.O0, b6, b5, sparseArray, arrayList, this.mIsLogin, B7());
            g4a.e(this.O0, b6, b5, arrayList, false, c4, this.mIsLogin, B7(), n1a.y(this.B0.s1(), b4));
            g4a.b(this.O0, sparseArray, arrayList, b4, b6, b7, b8, b9, c4, this.mIsLogin, B7());
            g4a.a(this.O0, sparseArray, arrayList, b4, b6, b7, b8, b9, c4, this.mIsLogin, B7(), this.B0.s1().Z());
            this.O0.m(arrayList);
            n05 n05Var = new n05(getPageContext(), this.O0);
            this.N0 = n05Var;
            n05Var.l();
        }
    }

    public final void N6(ForumManageModel.b bVar, boolean z3) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048621, this, bVar, z3) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i4 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                f05 f05Var = new f05(getPageContext().getPageActivity());
                f05Var.setMessage(string);
                f05Var.setPositiveButton(R.string.dialog_known, new m2(this));
                f05Var.setCancelable(true);
                f05Var.create(getPageContext());
                f05Var.show();
            } else if (bVar.d != 0) {
                this.I0.B0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i5 = bVar.d;
                if (i5 == 1) {
                    ArrayList<nwa> I = this.B0.s1().I();
                    int size = I.size();
                    while (true) {
                        if (i4 >= size) {
                            break;
                        } else if (bVar.g.equals(I.get(i4).U())) {
                            I.remove(i4);
                            break;
                        } else {
                            i4++;
                        }
                    }
                    this.B0.s1().R().setReply_num(this.B0.s1().R().getReply_num() - 1);
                    this.I0.Y1(this.B0.s1());
                } else if (i5 == 0) {
                    x6();
                } else if (i5 == 2) {
                    ArrayList<nwa> I2 = this.B0.s1().I();
                    int size2 = I2.size();
                    boolean z4 = false;
                    for (int i6 = 0; i6 < size2 && !z4; i6++) {
                        int i7 = 0;
                        while (true) {
                            if (i7 >= I2.get(i6).k0().size()) {
                                break;
                            } else if (bVar.g.equals(I2.get(i6).k0().get(i7).U())) {
                                I2.get(i6).k0().remove(i7);
                                I2.get(i6).h();
                                z4 = true;
                                break;
                            } else {
                                i7++;
                            }
                        }
                        I2.get(i6).k(bVar.g);
                    }
                    if (z4) {
                        this.I0.Y1(this.B0.s1());
                    }
                    A6(bVar, this.I0);
                }
            }
        }
    }

    public final void a9(String str, String str2) {
        int i4;
        int dimens;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048667, this, str, str2) == null) {
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(getContext());
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                i4 = TbadkCoreApplication.getInst().getKeyboardHeight();
                dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
            } else {
                i4 = equipmentHeight / 2;
                dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds410);
            }
            int i5 = equipmentHeight - (i4 + dimens);
            boolean z3 = true;
            int i6 = (this.Y[1] + this.Z) - i5;
            o1a o1aVar = this.I0;
            if (o1aVar != null && o1aVar.Z0() != null) {
                this.I0.Z0().smoothScrollBy(i6, 50);
            }
            if (i7().k1() != null) {
                eh5 eh5Var = this.Y0;
                if (eh5Var != null) {
                    eh5Var.a().setVisibility(8);
                }
                PbModel pbModel2 = this.B0;
                i7().k1().t(str, str2, i7().m1(), (pbModel2 == null || pbModel2.s1() == null || this.B0.s1().R() == null || !this.B0.s1().R().isBjh()) ? false : false);
                hh5 f4 = i7().k1().f();
                if (f4 != null && (pbModel = this.B0) != null && pbModel.s1() != null) {
                    f4.K(this.B0.s1().f());
                    f4.g0(this.B0.s1().R());
                }
                if (this.M0.f() == null && i7().k1().f().v() != null) {
                    i7().k1().f().v().i(new p(this));
                    this.M0.n(i7().k1().f().v().k());
                    i7().k1().f().Q(this.e1);
                }
            }
            i7().x1();
        }
    }

    public final void o7(int i4, Intent intent) {
        ve5 ve5Var;
        ve5 ve5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048726, this, i4, intent) == null) {
            if (i4 == 0) {
                this.I0.z1();
                this.I0.k1().g();
                this.I0.X3(false);
            }
            this.I0.h3();
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
                if (editorType == 1 && this.I0.k1() != null && this.I0.k1().f() != null) {
                    hh5 f4 = this.I0.k1().f();
                    f4.g0(this.B0.s1().R());
                    f4.E(writeData);
                    f4.h0(pbEditorData.getVoiceModel());
                    ue5 u3 = f4.a().u(6);
                    if (u3 != null && (ve5Var2 = u3.m) != null) {
                        ve5Var2.U(new he5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i4 == -1) {
                        f4.J();
                        return;
                    }
                    return;
                }
                return;
            }
            eh5 eh5Var = this.Y0;
            if (eh5Var != null) {
                eh5Var.P();
                this.Y0.q0(pbEditorData.getVoiceModel());
                this.Y0.F(writeData);
                ue5 u4 = this.Y0.a().u(6);
                if (u4 != null && (ve5Var = u4.m) != null) {
                    ve5Var.U(new he5(52, 0, pbEditorData.getVoiceModel()));
                }
                this.Y0.l0(pbEditorData.isShowCustomFigure());
                ue5 u5 = this.Y0.a().u(41);
                if (u5 != null) {
                    u5.h();
                    DLauncher dLauncher = (DLauncher) this.Y0.a().t(41);
                    if (dLauncher != null) {
                        dLauncher.setIcon();
                    }
                }
                if (i4 == -1) {
                    if (StringUtils.isNotNull(pbEditorData.getMemeQuery()) || pbEditorData.getMemeId() != 0) {
                        this.Y0.G = true;
                        if (StringUtils.isNotNull(pbEditorData.getMemeQuery())) {
                            this.Y0.H = pbEditorData.getMemeQuery();
                        }
                        if (pbEditorData.getMemeId() != 0) {
                            this.Y0.I = pbEditorData.getMemeId();
                        }
                    }
                    this.Y0.K(null, null);
                }
            }
        }
    }

    public final void P6(Rect rect) {
        o1a o1aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, rect) == null) && rect != null && (o1aVar = this.I0) != null && o1aVar.t1() != null && rect.top <= this.I0.t1().getHeight()) {
            rect.top += this.I0.t1().getHeight() - rect.top;
        }
    }

    public final void d9(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, str) == null) {
            if (str == null) {
                str = "";
            }
            BdPageContext bdPageContext = this.h1;
            if (bdPageContext == null) {
                return;
            }
            f05 f05Var = new f05(bdPageContext.getPageActivity());
            f05Var.setMessage(str);
            f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b86, new m(this));
            f05Var.create(this.h1).show();
        }
    }

    public final void g9(SparseArray<Object> sparseArray) {
        nwa nwaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048691, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof nwa) || (nwaVar = (nwa) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        h9(nwaVar, false);
    }

    public final void n6(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048720, this, view2) != null) || !(view2.getTag() instanceof ThreadData) || !checkUpIsLogin()) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        LikeModel likeModel = this.Q;
        if (likeModel != null) {
            likeModel.g0(threadData.getForum_name(), String.valueOf(threadData.getFid()));
        }
        c6a.H(threadData, 10, 11);
    }

    public final void n7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 4).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public final void o9(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048728, this, view2) != null) || this.s0) {
            return;
        }
        c6a.I(7, this.B0);
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray != null && (sparseArray.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_is_top_question)).booleanValue()) {
            c6a.v(6);
        }
        this.b = false;
        z6(view2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048749, this, z3) == null) {
            super.onUserChanged(z3);
            this.I0.B4(z3);
            n05 n05Var = this.N0;
            if (n05Var != null) {
                n05Var.dismiss();
            }
            if (z3 && this.R0) {
                this.I0.K3();
                this.B0.q2(true);
            }
            if (this.I0.G0() != null) {
                this.I0.G0().z(z3);
            }
        }
    }

    public final void r9(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048763, this, i4) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.B0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(j4a.j(i4))));
        }
    }

    public final void u8(View view2) {
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048778, this, view2) != null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        if (this.b) {
            i4 = 2;
        } else {
            i4 = 3;
        }
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(i4));
        view2.setTag(sparseArray);
    }

    public final void v9(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048785, this, view2) == null) && (view2.getTag() instanceof SmartApp)) {
            SmartApp smartApp = (SmartApp) view2.getTag();
            if (!TbAiappsLaunchUtil.launch(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                if (StringUtils.isNull(smartApp.h5_url)) {
                    return;
                }
                BrowserHelper.startWebActivity(getActivity(), smartApp.h5_url);
            }
            c6a.y(smartApp, this.B0);
        }
    }

    public final void x7(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048792, this, bundle) == null) {
            jr4 c4 = jr4.c(this.a);
            this.D0 = c4;
            if (c4 != null) {
                c4.j(this.v2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.E0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.x2);
            getPageContext();
            j7();
            this.R1.setUniqueId(getUniqueId());
            this.R1.registerListener();
            z7();
        }
    }

    public final void Q7(View view2, String str, String str2, nwa nwaVar) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048633, this, view2, str, str2, nwaVar) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (r6()) {
                    c6a.N(3, 2);
                    return;
                } else if (!u6()) {
                    c6a.N(8, 2);
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.Y);
                        this.Z = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (i7().k1() != null && nwaVar != null) {
                        if (nwaVar.f0() != null) {
                            str3 = nwaVar.f0().toString();
                        } else {
                            str3 = "";
                        }
                        i7().k1().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), nwaVar.u().getName_show(), str3));
                    }
                    if (this.B0.s1() != null && this.B0.s1().a()) {
                        SafeHandler.getInst().postDelayed(new s1(this, str, str2), 0L);
                        return;
                    } else {
                        SafeHandler.getInst().postDelayed(new t1(this, str, str2), 200L);
                        return;
                    }
                }
            }
            c6a.N(20, 2);
        }
    }

    public final void S8(SparseArray<Object> sparseArray, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{sparseArray, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            j4a.c(getActivity(), getPageContext(), new o1(this, sparseArray, i4, z3), new p1(this));
        }
    }

    public final void e9(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048684, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.I0.e4();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            f05 f05Var = new f05(this.h1.getPageActivity());
            if (!rd.isEmpty(str)) {
                f05Var.setMessage(str);
            } else {
                f05Var.setMessage(this.h1.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            f05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04d2, new n(this, userMuteAddAndDelCustomMessage));
            f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new o(this));
            f05Var.create(this.h1).show();
        }
    }

    public void f8() {
        PbModel pbModel;
        aw9 s12;
        ThreadData R;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        aw9 aw9Var;
        boolean z8;
        boolean z9;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048686, this) == null) && (pbModel = this.B0) != null && pbModel.s1() != null && (R = (s12 = this.B0.s1()).R()) != null && R.getAuthor() != null) {
            this.I0.z1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), R.getAuthor().getUserId());
            x0a x0aVar = new x0a();
            int Z = this.B0.s1().Z();
            if (Z != 1 && Z != 3) {
                x0aVar.g = false;
            } else {
                x0aVar.g = true;
                if (R.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                x0aVar.s = z3;
            }
            if (n1a.v(this.B0.s1(), Z)) {
                x0aVar.h = true;
                if (R.getIs_good() == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                x0aVar.r = z9;
            } else {
                x0aVar.h = false;
            }
            if (Z == 1002 && !equals) {
                x0aVar.u = true;
            }
            x0aVar.n = n1a.F(R.isBlocked(), s12.o0(), equals, Z, R.isWorksInfo(), R.isScoreThread());
            x0aVar.e = n1a.D(s12, equals, s12.o0(), this.B0.W());
            x0aVar.i = U8();
            x0aVar.f = n1a.E(this.B0.s1(), equals, this.B0.W());
            if (equals && s12.Y() != null && s12.Y().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            x0aVar.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                x0aVar.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            x0aVar.t = equals;
            x0aVar.q = this.B0.L1();
            x0aVar.b = true;
            x0aVar.a = n1a.y(this.B0.s1(), equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            x0aVar.p = z5;
            x0aVar.j = true;
            x0aVar.o = this.B0.V0();
            x0aVar.d = true;
            if (R.getThreadVideoInfo() == null) {
                z6 = true;
            } else {
                z6 = false;
            }
            x0aVar.c = z6;
            if (s12.a()) {
                x0aVar.b = false;
                x0aVar.d = false;
                x0aVar.c = false;
                x0aVar.g = false;
                x0aVar.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !s12.a()) {
                z7 = true;
            } else {
                z7 = false;
            }
            x0aVar.v = z7;
            if (this.I0 != null && (aw9Var = this.B0.G) != null) {
                nwa a02 = aw9Var.a0();
                if (a02 != null) {
                    z8 = a02.f1129T;
                } else {
                    z8 = false;
                }
                x0aVar.w = z8;
            }
            x0aVar.m = true;
            if (R.isBlocked()) {
                x0aVar.n = false;
                x0aVar.g = false;
                x0aVar.h = false;
            }
            this.I0.j.x(x0aVar);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void h1(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048694, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (uy5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), uy5.class);
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (u1a.c(objArr[i4].g()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new VCenterTextSpan(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i4], spannableStringBuilder.getSpanStart(objArr[i4]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.xy5
    public void x0(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048790, this, context, str, z3) == null) {
            if (u1a.c(str) && (pbModel = this.B0) != null && pbModel.M1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.B0.M1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    ld5 ld5Var = new ld5();
                    ld5Var.a = str;
                    ld5Var.b = 3;
                    ld5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, ld5Var));
                }
            } else {
                u1a.a().e(getPageContext(), str);
            }
            this.u = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048730, this, i4, i5, intent) == null) {
            super.onActivityResult(i4, i5, intent);
            eh5 eh5Var = this.Y0;
            if (eh5Var != null) {
                eh5Var.G(i4, i5, intent);
            }
            if (i7().k1() != null) {
                i7().k1().k(i4, i5, intent);
            }
            if (i4 == 25035) {
                o7(i5, intent);
            }
            if (i5 == -1) {
                if (i4 != 11009) {
                    if (i4 != 13008) {
                        if (i4 != 13011) {
                            if (i4 != 23007) {
                                if (i4 != 25033) {
                                    if (i4 != 24007) {
                                        if (i4 != 24008) {
                                            switch (i4) {
                                                case 25055:
                                                    View view2 = this.S;
                                                    if (view2 != null) {
                                                        view2.performClick();
                                                        return;
                                                    }
                                                    return;
                                                case 25056:
                                                    View view3 = this.f1134T;
                                                    if (view3 != null) {
                                                        view3.performClick();
                                                        return;
                                                    }
                                                    return;
                                                case 25057:
                                                    o1a o1aVar = this.I0;
                                                    if (o1aVar != null && o1aVar.J0() != null) {
                                                        this.I0.J0().performClick();
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
                                        this.I0.L3(false);
                                        if (this.B0.s1() != null && this.B0.s1().R() != null && this.B0.s1().R().getPushStatusData() != null) {
                                            this.B0.s1().R().getPushStatusData().setStatus(2);
                                            return;
                                        }
                                        return;
                                    }
                                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                        RateManager.getInstance().notifyShare(getPageContext());
                                        s9();
                                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.H0;
                                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.linkUrl) != null) {
                                            shareSuccessReplyToServerModel.O(str, intExtra, new r2(this));
                                        }
                                        if (D7()) {
                                            q9(true);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                View view5 = this.R;
                                if (view5 != null) {
                                    this.I0.b4(view5);
                                    return;
                                }
                                return;
                            }
                            r7(intent);
                            return;
                        }
                        RateManager.getInstance().notifyShare(getPageContext());
                        return;
                    }
                    f1a.b().k();
                    this.y0.postDelayed(new q2(this), 1000L);
                    return;
                }
                V7();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048736, this, layoutInflater, viewGroup, bundle)) == null) {
            this.I0 = new o1a(this, this.m2, this.X1, this.l2);
            aw6 aw6Var = new aw6(getActivity());
            this.d = aw6Var;
            aw6Var.i(U2);
            this.d.d(this.M2);
            this.I0.C3(this.w2);
            this.I0.B3(this.B2);
            this.I0.v3(this.y2);
            this.I0.w3(this.z2);
            this.I0.t3(qv4.c().g());
            this.I0.z3(this.C2);
            this.I0.F3(this.H2);
            this.I0.D3(this.I2);
            this.I0.A3(this.K2);
            this.I0.B4(this.mIsLogin);
            this.I0.O3(v2a.a(this.B0));
            if (this.a.getIntent() != null) {
                this.I0.s3(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.I0.j1().setFromForumId(this.B0.getFromForumId());
            eh5 eh5Var = this.Y0;
            if (eh5Var != null) {
                this.I0.k3(eh5Var.a());
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.Y0.g0(TbSingleton.getInstance().getAdVertiComment());
                } else {
                    this.Y0.g0(this.I0.m1());
                }
            }
            this.I0.o3(this.j2);
            this.I0.r3(this.B0.a1());
            this.I0.E3(this.B0.r1());
            this.u0.f(this.I0, this.B0);
            if ("1".equals(l0().showReplyPanel)) {
                this.I0.D2();
            }
            w7();
            return this.I0.u1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        o1a o1aVar;
        o1a o1aVar2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, bundle) == null) {
            this.n = System.currentTimeMillis();
            this.h1 = getPageContext();
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
                this.V0 = intent.getBooleanExtra("frs_top_thread_type", false);
                if (Y6()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P = stringExtra;
                if (rd.isEmpty(stringExtra)) {
                    str = "";
                } else {
                    str = this.P;
                }
                this.P = str;
                this.s1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                uy4 uy4Var = new uy4();
                this.c0 = uy4Var;
                uy4Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.u1 = intExtra;
                if (intExtra == 0) {
                    this.u1 = intent.getIntExtra("key_start_from", 0);
                }
                this.S2 = intent.getIntExtra(PbActivityConfig.KEY_FROM_CARD_TYPE, 0);
            } else {
                this.l = System.currentTimeMillis();
            }
            this.p = this.n - this.l;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.j = 0;
            O7(bundle);
            if (this.B0.s1() != null) {
                this.B0.s1().W0(this.P);
                if (this.V0 && this.B0.s1().R() != null) {
                    this.B0.s1().R().setIs_top(1);
                }
            }
            y7();
            if (intent != null && (o1aVar2 = this.I0) != null) {
                o1aVar2.d = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.k1 == null) {
                        this.k1 = new s0(this, intent);
                    }
                    SafeHandler.getInst().postDelayed(this.k1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.B0.s1() != null) {
                    this.B0.Y2(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.i = voiceManager;
            voiceManager.onCreate(getPageContext());
            x7(bundle);
            fh5 fh5Var = new fh5();
            this.X0 = fh5Var;
            M8(fh5Var);
            eh5 eh5Var = (eh5) this.X0.a(getActivity());
            this.Y0 = eh5Var;
            eh5Var.a0(this.a.getPageContext());
            this.Y0.j0(this.o2);
            this.Y0.k0(this.c1);
            this.Y0.c0(1);
            this.Y0.E(this.a.getPageContext(), bundle);
            this.Y0.a().c(new te5(getActivity()));
            this.Y0.a().M(true);
            P8(true);
            this.Y0.N(this.B0.U0(), this.B0.M1(), this.B0.Q0());
            registerListener(this.B1);
            if (!this.B0.f1()) {
                this.Y0.t(this.B0.M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.Y0.g0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.B0.d2()) {
                this.Y0.g0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                o1a o1aVar3 = this.I0;
                if (o1aVar3 != null) {
                    this.Y0.g0(o1aVar3.m1());
                }
            }
            jx9 jx9Var = new jx9(this.a.getUniqueId(), new t0(this), new u0(this));
            this.f2 = jx9Var;
            registerListener(jx9Var.d());
            this.G = new PbGodGuideController();
            getLifecycle().addObserver(this.G);
            lu4.a().c(this.z0);
            lu4.a().c(this.A0);
            registerListener(this.A1);
            registerListener(this.C1);
            registerListener(this.D1);
            registerListener(this.z1);
            registerListener(this.d2);
            registerListener(this.e2);
            registerListener(this.u2);
            registerListener(this.y1);
            ewa ewaVar = new ewa("pb", ewa.d);
            this.W0 = ewaVar;
            ewaVar.d();
            registerListener(this.J1);
            registerListener(this.T1);
            this.B0.x2();
            registerListener(this.t2);
            registerListener(this.h2);
            registerListener(this.n2);
            registerListener(this.P1);
            registerListener(this.g2);
            registerListener(this.K1);
            o1a o1aVar4 = this.I0;
            if (o1aVar4 != null && o1aVar4.t1() != null && this.I0.q1() != null) {
                b3a b3aVar = new b3a(getActivity(), this.I0.t1(), this.I0.q1(), this.I0.i1());
                this.e = b3aVar;
                b3aVar.t(this.S1);
            }
            if (this.c && (o1aVar = this.I0) != null && o1aVar.q1() != null) {
                this.I0.q1().setVisibility(8);
            }
            l55 l55Var = new l55();
            this.i1 = l55Var;
            l55Var.a = 1000L;
            registerListener(this.c2);
            registerListener(this.b2);
            registerListener(this.Z1);
            registerListener(this.a2);
            registerListener(this.M1);
            registerListener(this.N1);
            registerListener(this.F1);
            registerListener(this.G1);
            registerListener(this.H1);
            this.L1.setSelfListener(true);
            this.L1.setTag(this.a.getUniqueId());
            this.L1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.L1);
            registerResponsedEventListener(TipEvent.class, this.U1);
            registerResponsedEventListener(TopToastEvent.class, this.V1);
            this.j1 = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.j1;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.j1;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            this.M0 = new r1a();
            if (this.Y0.v() != null) {
                this.M0.m(this.Y0.v().k());
            }
            this.Y0.Z(this.d1);
            this.H0 = new ShareSuccessReplyToServerModel();
            i6(this.w1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.a1 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new w0(this));
            i5a i5aVar = new i5a(getContext());
            this.C0 = i5aVar;
            i5aVar.b(getUniqueId());
            qua.g().i(getUniqueId());
            aw4.b().l("3", "");
            this.v1 = new ll6(getPageContext());
            this.u0 = new q3a(this, getUniqueId(), this.I0, this.B0);
            this.v0 = new PushPermissionController(getActivity(), getPageContext());
            if (!TbSingleton.getInstance().hasDownloadEmotion() && BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.o = System.currentTimeMillis() - this.n;
        }
    }

    public final boolean z6(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        jr4 jr4Var;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i4;
        l05 l05Var;
        BdImage bdImage;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048797, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext())) {
                return true;
            }
            o1a o1aVar = this.I0;
            if (o1aVar != null) {
                if (o1aVar.c2()) {
                    return true;
                }
                this.I0.C0();
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (n1a.u(view2)) {
                    if (view2 instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view2;
                        this.m1 = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.n1 = url;
                        if (this.m1 == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view2.getTag(R.id.tag_rich_text_image_info) != null && (view2.getTag(R.id.tag_rich_text_image_info) instanceof TbRichTextImageInfo)) {
                            this.o1 = (TbRichTextImageInfo) view2.getTag(R.id.tag_rich_text_image_info);
                        } else {
                            this.o1 = null;
                        }
                        if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.p1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.p1 = null;
                        }
                    } else if (view2 instanceof GifView) {
                        GifView gifView = (GifView) view2;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.m1 = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().getUrl())) {
                            this.n1 = gifView.getBdImage().getUrl();
                        }
                        if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.p1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.p1 = null;
                        }
                    } else if (view2 instanceof TbMemeImageView) {
                        TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                        if (tbMemeImageView.getBdImage() != null) {
                            this.m1 = tbMemeImageView.getBdImage();
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().getUrl())) {
                                this.n1 = tbMemeImageView.getBdImage().getUrl();
                            }
                            if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.p1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.p1 = null;
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
                        this.I0.i4(this.F2, this.m1.isGif());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            nwa nwaVar = (nwa) sparseArray.get(R.id.tag_clip_board);
            this.D2 = nwaVar;
            if (nwaVar == null) {
                return true;
            }
            if (nwaVar.L() == 1 && n1a.u(view2)) {
                this.I0.i4(this.F2, this.m1.isGif());
                return true;
            } else if (this.D2.E0() || (jr4Var = this.D0) == null) {
                return true;
            } else {
                if (jr4Var.e() && this.D2.U() != null && this.D2.U().equals(this.B0.n1())) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (l0().s1() != null && l0().s1().a()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (l0().s1() != null && l0().s1().q0()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (l0().s1() != null && l0().s1().p0()) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (this.D2.L() == 1) {
                    if (!z4) {
                        this.I0.j4(this.E2, z3, false, z5, z6);
                    }
                    return true;
                }
                if (this.O0 == null) {
                    p05 p05Var = new p05(getContext());
                    this.O0 = p05Var;
                    p05Var.r(this.k2);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 != null && sparseArray != null) {
                    if (n1a.u(view2) && !z4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (n1a.u(view2) && (bdImage = this.m1) != null && !bdImage.isGif()) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    boolean b4 = p4a.b(sparseArray, R.id.tag_is_subpb, false);
                    boolean b5 = p4a.b(sparseArray, R.id.tag_del_post_is_self, false);
                    boolean b6 = p4a.b(sparseArray, R.id.tag_user_mute_visible, false);
                    boolean b7 = p4a.b(sparseArray, R.id.tag_should_manage_visible, false);
                    boolean b8 = p4a.b(sparseArray, R.id.tag_user_mute_visible, false);
                    boolean b9 = p4a.b(sparseArray, R.id.tag_should_delete_visible, false);
                    boolean b10 = p4a.b(sparseArray, R.id.tag_is_self_post, false);
                    boolean b11 = p4a.b(sparseArray, R.id.tag_mul_del_post_type, false);
                    String c4 = p4a.c(sparseArray, R.id.tag_forbid_user_post_id, "");
                    if (z7) {
                        arrayList.add(new l05(1, getString(R.string.save_to_emotion), this.O0));
                    }
                    if (z8) {
                        arrayList.add(new l05(2, getString(R.string.save_to_local), this.O0));
                    }
                    if (!z7 && !z8) {
                        l05 l05Var2 = new l05(3, getString(R.string.obfuscated_res_0x7f0f04f5), this.O0);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.tag_clip_board, this.D2);
                        l05Var2.d.setTag(sparseArray3);
                        arrayList.add(l05Var2);
                    }
                    if (!b4 && !z4) {
                        if (z3) {
                            l05Var = new l05(4, getString(R.string.remove_mark), this.O0);
                        } else {
                            l05Var = new l05(4, getString(R.string.obfuscated_res_0x7f0f0c89), this.O0);
                        }
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_clip_board, this.D2);
                        sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                        l05Var.d.setTag(sparseArray4);
                        arrayList.add(l05Var);
                    }
                    g4a.d(this.O0, b7, b6, sparseArray, arrayList, this.mIsLogin, B7());
                    g4a.e(this.O0, b7, b6, arrayList, z4, c4, this.mIsLogin, B7(), n1a.y(this.B0.s1(), b5));
                    SparseArray sparseArray5 = sparseArray;
                    g4a.b(this.O0, sparseArray5, arrayList, b5, b7, b8, b9, b10, c4, this.mIsLogin, B7());
                    g4a.a(this.O0, sparseArray5, arrayList, b5, b7, b8, b9, b10, c4, this.mIsLogin, B7(), this.B0.s1().Z());
                    g4a.c(this.O0, arrayList, b7, b9, b11, this.mIsLogin);
                    p4a.a(arrayList, this.O0, this.D2, this.B0.s1(), TbadkCoreApplication.isLogin());
                    List<l05> b12 = j4a.b(arrayList, this.D2.p(), sparseArray, this.O0, this.D2.t());
                    j4a.i(b12, this.b);
                    j4a.d(b12);
                    this.O0.s(j4a.f(this.D2));
                    this.O0.n(b12, true);
                    this.N0 = new n05(getPageContext(), this.O0);
                    this.O0.q(new g3(this));
                    this.N0.l();
                    StatisticItem param = new StatisticItem("c13272").param("tid", this.B0.b).param("fid", this.B0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.B0.Q());
                    if (b4) {
                        i4 = 2;
                    } else {
                        i4 = 1;
                    }
                    TiebaStatic.log(param.param("obj_source", i4));
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        e5a e5aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048737, this) == null) {
            qua.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.B0.s1().o());
                statisticItem.param("tid", this.B0.M1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.r && this.I0 != null) {
                this.r = true;
            }
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.B0.destory();
                if (this.B0.o1() != null) {
                    this.B0.o1().d();
                }
            }
            eh5 eh5Var = this.Y0;
            if (eh5Var != null) {
                eh5Var.H();
                this.Y0 = null;
            }
            ForumManageModel forumManageModel = this.E0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.Q;
            if (likeModel != null) {
                likeModel.c0();
            }
            o1a o1aVar = this.I0;
            if (o1aVar != null) {
                o1aVar.w2();
                e5a e5aVar2 = this.I0.j;
                if (e5aVar2 != null) {
                    e5aVar2.r();
                }
            }
            np5 np5Var = this.s;
            if (np5Var != null) {
                np5Var.c();
            }
            b3a b3aVar = this.e;
            if (b3aVar != null) {
                b3aVar.k();
            }
            pb<TextView> pbVar = this.y;
            if (pbVar != null) {
                pbVar.c();
            }
            pb<FestivalTipView> pbVar2 = this.H;
            if (pbVar2 != null) {
                pbVar2.c();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            o1a o1aVar2 = this.I0;
            if (o1aVar2 != null) {
                o1aVar2.s0();
            }
            if (this.Y1 != null) {
                SafeHandler.getInst().removeCallbacks(this.Y1);
            }
            if (this.f2 != null) {
                MessageManager.getInstance().unRegisterListener(this.f2.d());
            }
            lu4.a().e(this.z0);
            lu4.a().e(this.A0);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().unRegisterListener(this.j1);
            MessageManager.getInstance().unRegisterListener(this.d2);
            MessageManager.getInstance().unRegisterListener(this.e2);
            MessageManager.getInstance().unRegisterListener(this.h2);
            MessageManager.getInstance().unRegisterListener(this.M1);
            MessageManager.getInstance().unRegisterListener(this.N1);
            MessageManager.getInstance().unRegisterListener(this.r2);
            MessageManager.getInstance().unRegisterListener(this.L1);
            MessageManager.getInstance().unRegisterListener(this.P1);
            MessageManager.getInstance().unRegisterListener(this.G1);
            MessageManager.getInstance().unRegisterListener(this.H1);
            MessageManager.getInstance().unRegisterListener(this.g2);
            this.h1 = null;
            this.i1 = null;
            LocationCacheData.getInstance().saveAspShowInfoInSharePref();
            if (this.k1 != null) {
                SafeHandler.getInst().removeCallbacks(this.k1);
            }
            o1a o1aVar3 = this.I0;
            if (o1aVar3 != null && (e5aVar = o1aVar3.j) != null) {
                e5aVar.k();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.H0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            r1a r1aVar = this.M0;
            if (r1aVar != null) {
                r1aVar.j();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.B0;
            if (pbModel2 != null && pbModel2.F0() != null) {
                this.B0.F0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.a1;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            o1a o1aVar4 = this.I0;
            if (o1aVar4 != null) {
                o1aVar4.y4();
            }
            q3a q3aVar = this.u0;
            if (q3aVar != null) {
                q3aVar.e();
            }
        }
    }

    public void p7(boolean z3, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048751, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
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
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.j1);
            userMuteAddAndDelCustomMessage.setTag(this.j1);
            e9(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void w8(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048789, this, z3, markData) == null) {
            this.I0.I3();
            this.B0.g3(z3);
            jr4 jr4Var = this.D0;
            if (jr4Var != null) {
                jr4Var.h(z3);
                if (markData != null) {
                    this.D0.i(markData);
                }
            }
            if (this.B0.d1()) {
                S7();
            } else {
                this.I0.Y1(this.B0.s1());
            }
        }
    }
}
