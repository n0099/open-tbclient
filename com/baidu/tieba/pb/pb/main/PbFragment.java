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
import com.baidu.tieba.a05;
import com.baidu.tieba.aiapps.TbAiappsLaunchUtil;
import com.baidu.tieba.ax9;
import com.baidu.tieba.bp5;
import com.baidu.tieba.bsa;
import com.baidu.tieba.bt5;
import com.baidu.tieba.bta;
import com.baidu.tieba.c55;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cd5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cu9;
import com.baidu.tieba.d0a;
import com.baidu.tieba.d1a;
import com.baidu.tieba.dp5;
import com.baidu.tieba.es9;
import com.baidu.tieba.ey4;
import com.baidu.tieba.f05;
import com.baidu.tieba.f0a;
import com.baidu.tieba.fr4;
import com.baidu.tieba.fs9;
import com.baidu.tieba.g55;
import com.baidu.tieba.g78;
import com.baidu.tieba.go5;
import com.baidu.tieba.gu4;
import com.baidu.tieba.gw9;
import com.baidu.tieba.gy4;
import com.baidu.tieba.h05;
import com.baidu.tieba.h1a;
import com.baidu.tieba.h95;
import com.baidu.tieba.hba;
import com.baidu.tieba.hd5;
import com.baidu.tieba.he5;
import com.baidu.tieba.hp5;
import com.baidu.tieba.hw4;
import com.baidu.tieba.i05;
import com.baidu.tieba.ih5;
import com.baidu.tieba.ix9;
import com.baidu.tieba.iz9;
import com.baidu.tieba.j05;
import com.baidu.tieba.j0a;
import com.baidu.tieba.j0b;
import com.baidu.tieba.jh5;
import com.baidu.tieba.jx9;
import com.baidu.tieba.jy5;
import com.baidu.tieba.kd5;
import com.baidu.tieba.ke5;
import com.baidu.tieba.kh5;
import com.baidu.tieba.ko4;
import com.baidu.tieba.kq9;
import com.baidu.tieba.ku9;
import com.baidu.tieba.le5;
import com.baidu.tieba.lo4;
import com.baidu.tieba.lo5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.lra;
import com.baidu.tieba.lv4;
import com.baidu.tieba.lv6;
import com.baidu.tieba.lz4;
import com.baidu.tieba.lz9;
import com.baidu.tieba.m0b;
import com.baidu.tieba.me5;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mq9;
import com.baidu.tieba.mv6;
import com.baidu.tieba.mv9;
import com.baidu.tieba.mx9;
import com.baidu.tieba.my5;
import com.baidu.tieba.mz9;
import com.baidu.tieba.n45;
import com.baidu.tieba.nb5;
import com.baidu.tieba.nq6;
import com.baidu.tieba.ob;
import com.baidu.tieba.oi;
import com.baidu.tieba.ot9;
import com.baidu.tieba.ox4;
import com.baidu.tieba.ox9;
import com.baidu.tieba.oy9;
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
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.px9;
import com.baidu.tieba.py4;
import com.baidu.tieba.pz9;
import com.baidu.tieba.q1a;
import com.baidu.tieba.qb5;
import com.baidu.tieba.qd;
import com.baidu.tieba.qo5;
import com.baidu.tieba.qw9;
import com.baidu.tieba.qz5;
import com.baidu.tieba.qz9;
import com.baidu.tieba.r65;
import com.baidu.tieba.r95;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.tieba.rg5;
import com.baidu.tieba.rv9;
import com.baidu.tieba.ry9;
import com.baidu.tieba.rz9;
import com.baidu.tieba.s05;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.sg5;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.si;
import com.baidu.tieba.sw9;
import com.baidu.tieba.sz9;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.to5;
import com.baidu.tieba.ty9;
import com.baidu.tieba.u8b;
import com.baidu.tieba.ug5;
import com.baidu.tieba.ura;
import com.baidu.tieba.us9;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.uy9;
import com.baidu.tieba.vg5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vra;
import com.baidu.tieba.vs9;
import com.baidu.tieba.w4;
import com.baidu.tieba.wc5;
import com.baidu.tieba.wg5;
import com.baidu.tieba.wv4;
import com.baidu.tieba.xk6;
import com.baidu.tieba.xpa;
import com.baidu.tieba.xs9;
import com.baidu.tieba.xv9;
import com.baidu.tieba.xw4;
import com.baidu.tieba.yd5;
import com.baidu.tieba.yg5;
import com.baidu.tieba.yi5;
import com.baidu.tieba.yt9;
import com.baidu.tieba.yw9;
import com.baidu.tieba.zja;
import com.baidu.tieba.zt9;
import com.baidu.tieba.zz4;
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
public class PbFragment extends BaseFragment implements my5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, zz4.e, TbRichTextView.t, TbPageContextSupport, h1a, q1a.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k T2;
    public static final mv6.b U2;
    public transient /* synthetic */ FieldHolder $fh;
    public ob<ImageView> A;
    public gu4.d A0;
    public CustomMessageListener A1;
    public boolean A2;
    public ob<View> B;
    public PbModel B0;
    public CustomMessageListener B1;
    public final BdListView.p B2;
    public ob<TiebaPlusRecommendCard> C;
    public j0a C0;
    public CustomMessageListener C1;
    public final TbRichTextView.z C2;
    public ob<LinearLayout> D;
    public fr4 D0;
    public CustomMessageListener D1;
    public vra D2;
    public ob<RelativeLayout> E;
    public ForumManageModel E0;
    public CustomMessageListener E1;
    public final a05.c E2;
    public ob<ItemCardView> F;
    public xs9 F0;
    public final CustomMessageListener F1;
    public final a05.c F2;
    @NonNull
    public PbGodGuideController G;
    public PollingModel G0;
    public CustomMessageListener G1;
    public final AdapterView.OnItemClickListener G2;
    public ob<FestivalTipView> H;
    public ShareSuccessReplyToServerModel H0;
    public CustomMessageListener H1;
    public final View.OnLongClickListener H2;
    public boolean I;
    public jx9 I0;
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
    public ob<GifView> L;
    public boolean L0;
    public CustomMessageListener L1;
    public View.OnTouchListener L2;
    public String M;
    public mx9 M0;
    public CustomMessageListener M1;
    public lv6.b M2;
    public boolean N;
    public h05 N0;
    public CustomMessageListener N1;
    public final xv9.b N2;
    public boolean O;
    public j05 O0;
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
    public xw4 R2;
    public View S;
    public boolean S0;
    public uy9.h S1;
    public int S2;

    /* renamed from: T  reason: collision with root package name */
    public View f1142T;
    public String T0;
    public CustomMessageListener T1;
    public View U;
    public boolean U0;
    public ResponsedEventListener U1;
    public String V;
    public boolean V0;
    public ResponsedEventListener V1;
    public int W;
    public lra W0;
    public CheckRealNameModel.b W1;
    public boolean X;
    public wg5 X0;
    public zt9 X1;
    public int[] Y;
    public vg5 Y0;
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
    public rz9 b1;
    public CustomMessageListener b2;
    public boolean c;
    public py4 c0;
    public sg5 c1;
    public CustomMessageListener c2;
    public mv6 d;
    public BdUniqueId d0;
    public rg5 d1;
    public CustomMessageListener d2;
    public uy9 e;
    public n45 e0;
    public rg5 e1;
    public CustomMessageListener e2;
    public boolean f;
    public boolean f0;
    public int f1;
    public ot9 f2;
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
    public c55 i1;
    public zz4.e i2;
    public int j;
    public nb5 j0;
    public BdUniqueId j1;
    public i3 j2;
    public a05 k;
    public Runnable k1;
    public j05.f k2;
    public long l;
    public ox9 l1;
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
    public bp5 s;
    public boolean s0;
    public int s1;
    public final PbModel.h s2;
    public long t;
    @NonNull
    public TiePlusEventController.g t0;
    public List<g3> t1;
    public CustomMessageListener t2;
    public boolean u;
    public iz9 u0;
    public int u1;
    public HttpMessageListener u2;
    public long v;
    public PushPermissionController v0;
    public xk6 v1;
    public final fr4.a v2;
    public int w;
    public boolean w0;
    public final g3 w1;
    public final AbsListView.OnScrollListener w2;
    public String x;
    public PbInterviewStatusView.f x0;
    public final qw9.b x1;
    public final w4 x2;
    public ob<TextView> y;
    public final Handler y0;
    public final CustomMessageListener y1;
    public final g55.g y2;
    public ob<TbImageView> z;
    public gu4.d z0;
    public CustomMessageListener z1;
    public final View.OnClickListener z2;

    /* loaded from: classes7.dex */
    public interface g3 {
        boolean onBackPressed();
    }

    /* loaded from: classes7.dex */
    public interface i3 {
        void callback(Object obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView J1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.my5
    public void M1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.h1a
    public AbsVideoPbFragment e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return null;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h1a
    public PbFragment j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048755, this, view2, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.my5
    public void s0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048769, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048778, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class n2 implements ShareSuccessReplyToServerModel.b {
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
            public final /* synthetic */ n2 b;

            public a(n2 n2Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {n2Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = n2Var;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    cu9.a(this.b.a.getPageContext(), this.a).show();
                }
            }
        }

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

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                SafeHandler.getInst().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v1 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ v1 b;

            public a(v1 v1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {v1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = v1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.I0 != null && this.a != null) {
                    this.b.a.I0.d3(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements zz4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(v1 v1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {v1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                    zz4Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements zz4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ v1 a;

            public c(v1 v1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {v1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = v1Var;
            }

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                    zz4Var.dismiss();
                    qz9.a(this.a.a.getPageContext());
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h95 h95Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, h95Var, writeData, antiData}) == null) {
                if (!qd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.B0.t1() != null) {
                        statisticItem.param("fid", this.a.B0.t1().l());
                    }
                    statisticItem.param("tid", this.a.B0.N1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (qd.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.U8();
                this.a.I0.S3(z, postWriteCallBackData);
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
                        if (qd.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        zz4 zz4Var = new zz4(this.a.getActivity());
                        if (qd.isEmpty(postWriteCallBackData.getErrorString())) {
                            zz4Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            zz4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d3, new b(this));
                        zz4Var.setPositiveButton(R.string.open_now, new c(this));
                        zz4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (h95Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.C8(i, antiData, str);
                        return;
                    }
                }
                this.a.N8(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.D8(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData != null && writeData.getType() == 2) {
                    if (floor != null) {
                        this.a.I0.h2(this.a.B0.t1());
                    }
                } else if (this.a.B0.W0()) {
                    es9 t1 = this.a.B0.t1();
                    if (t1 != null && t1.O() != null && t1.O().getAuthor() != null && (userId = t1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.B0.k3()) {
                        this.a.I0.U3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.B0.k3()) {
                    this.a.I0.U3();
                }
                if (this.a.B0.a1()) {
                    d1a.t("c10369", this.a.B0.N1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.B0 != null) {
                    Context context = this.a.getContext();
                    es9 t12 = this.a.B0.t1();
                    String forumId = this.a.B0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    ix9.b(context, t12, forumId, z2, this.a.B0.z1(), this.a.B0.C1(), this.a.B0.B1(), this.a.B0.A1(), this.a.B0.G1(), this.a.B0.H1());
                }
                if (writeData != null) {
                    r65.b(writeData.getContent(), "1");
                }
                if (this.a.p7()) {
                    this.a.b9();
                }
                this.a.K8();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w1 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ w1 b;

            public a(w1 w1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {w1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = w1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.I0 != null && this.a != null) {
                    this.b.a.I0.d3(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements zz4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(w1 w1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {w1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                    zz4Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements zz4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ w1 a;

            public c(w1 w1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {w1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = w1Var;
            }

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                    zz4Var.dismiss();
                    qz9.a(this.a.a.getPageContext());
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h95 h95Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, h95Var, writeData, antiData}) == null) {
                if (!qd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.B0 != null && this.a.B0.t1() != null) {
                        statisticItem.param("fid", this.a.B0.t1().l());
                    }
                    if (this.a.B0 != null) {
                        statisticItem.param("tid", this.a.B0.N1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.N6()) {
                        this.a.v8(false);
                        kq9.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14c1));
                    }
                    mx9 mx9Var = this.a.M0;
                    if (mx9Var != null) {
                        mx9Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        qb5.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        r65.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.p7()) {
                        this.a.b9();
                    }
                    this.a.K8();
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
                    if (qd.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                    } else {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    zz4 zz4Var = new zz4(this.a.getActivity());
                    if (qd.isEmpty(postWriteCallBackData.getErrorString())) {
                        zz4Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        zz4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d3, new b(this));
                    zz4Var.setPositiveButton(R.string.open_now, new c(this));
                    zz4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbFragment pbFragment = this.a;
                    if (pbFragment.M0 != null) {
                        if (pbFragment.I0 != null && this.a.I0.x1() != null && this.a.I0.x1().f() != null && this.a.I0.x1().f().A()) {
                            this.a.I0.x1().f().x(postWriteCallBackData);
                        }
                        this.a.M0.l(postWriteCallBackData);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements ItemCardHelper.c {
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
    public class a0 implements View.OnClickListener {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.j1) {
                this.a.I0.O1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                es9 t1 = this.a.B0.t1();
                if (t1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    t1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.i1.d(this.a.h1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.h1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.P8(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (qd.isEmpty(errorString2)) {
                        errorString2 = this.a.h1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.i1.c(errorString2);
                } else {
                    this.a.H8();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a2 implements gu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.gu4.d
        @NonNull
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "pbPage.botFeedbackSubmit" : (String) invokeV.objValue;
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

        @Override // com.baidu.tieba.gu4.c
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
                    if (this.a.D2 != null && TextUtils.equals(this.a.D2.T(), optString)) {
                        if (this.a.D2.s() != null) {
                            BdToastHelper.toast(u8b.a(this.a.D2.s().feedback_toast));
                        }
                    }
                } finally {
                    this.a.D2 = null;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a3 implements a05.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.baidu.tieba.a05.c
        public void a(a05 a05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, a05Var, i, view2) == null) {
                if (a05Var != null) {
                    a05Var.e();
                }
                if (this.a.m1 != null && !TextUtils.isEmpty(this.a.n1)) {
                    if (i == 0) {
                        if (this.a.p1 != null) {
                            yi5.a aVar = new yi5.a();
                            aVar.a = this.a.n1;
                            String str = "";
                            if (this.a.p1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.p1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        } else {
                            this.a.Y5();
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
                            pbFragment.l1 = new ox9(pbFragment.getPageContext());
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
    public class b implements NoNetworkView.b {
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

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void m(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.f && z && !this.a.B0.i1()) {
                    this.a.k8();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ox4)) {
                ox4 ox4Var = (ox4) customResponsedMessage.getData();
                gy4.a aVar = new gy4.a();
                int i = ox4Var.a;
                String str = ox4Var.b;
                aVar.a = ox4Var.d;
                es9 t1 = this.a.B0.t1();
                if (t1 == null) {
                    return;
                }
                if (this.a.B0.V0() != null && this.a.B0.V0().getUserIdLong() == ox4Var.p) {
                    this.a.I0.k3(ox4Var.l, this.a.B0.t1(), this.a.B0.M1(), this.a.B0.E1());
                }
                if (t1.F() != null && t1.F().size() >= 1 && t1.F().get(0) != null) {
                    long j = JavaTypesHelper.toLong(t1.F().get(0).T(), 0L);
                    long j2 = JavaTypesHelper.toLong(this.a.B0.N1(), 0L);
                    if (j == ox4Var.n && j2 == ox4Var.m) {
                        gy4 R = t1.F().get(0).R();
                        if (R == null) {
                            R = new gy4();
                        }
                        ArrayList<gy4.a> a = R.a();
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        a.add(0, aVar);
                        R.e(R.b() + ox4Var.l);
                        R.d(a);
                        t1.F().get(0).b1(R);
                        this.a.I0.T0().f0();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b1(PbFragment pbFragment, int i) {
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
                this.a.I0.O1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.i1.d(this.a.h1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (qd.isEmpty(muteMessage)) {
                    muteMessage = this.a.h1.getResources().getString(R.string.un_mute_fail);
                }
                this.a.i1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b2 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b2(PbFragment pbFragment, int i, boolean z) {
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
                    pbFragment.hideLoadingView(pbFragment.I0.G1());
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
                    this.a.z8(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e61);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                new BdTopToast(this.a.getContext()).setIcon(false).setContent(errorString).show((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b3 implements AdapterView.OnItemClickListener {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.B0 == null || this.a.B0.D1() == i + 1) {
                return;
            }
            this.a.t8(ix9.r(i));
        }
    }

    /* loaded from: classes7.dex */
    public class c implements pb<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
        }

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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pb
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pb
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pb
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
        @Override // com.baidu.tieba.pb
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
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof qz5)) {
                qz5 qz5Var = (qz5) customResponsedMessage.getData();
                es9 t1 = this.a.B0.t1();
                if (t1 == null) {
                    return;
                }
                if (this.a.B0.t1() != null && this.a.B0.t1().X().t() != null && this.a.B0.t1().X().t().getPortrait() != null && this.a.B0.t1().X().t().getPortrait().equals(qz5Var.a)) {
                    if (this.a.B0.t1().X().t().getUserWorldCupData() != null) {
                        this.a.B0.t1().X().t().getUserWorldCupData().c(qz5Var.b);
                    }
                    this.a.I0.l3(this.a.B0.t1(), this.a.B0.M1(), this.a.B0.E1(), this.a.I0.B1());
                }
                if (t1.F() != null && t1.F().size() >= 0) {
                    Iterator<vra> it = t1.F().iterator();
                    while (it.hasNext()) {
                        vra next = it.next();
                        if (next != null && next.t() != null && next.t().getPortrait() != null && next.t().getPortrait().equals(qz5Var.a) && next.t().getUserWorldCupData() != null) {
                            next.t().getUserWorldCupData().c(qz5Var.b);
                        }
                    }
                    this.a.I0.T0().f0();
                }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!this.a.p7() || this.a.a == null || this.a.a.F1() == null || !str.equals(this.a.a.F1().getTopicId())) {
                    return;
                }
                this.a.c9(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c2 implements fr4.a {
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

        @Override // com.baidu.tieba.fr4.a
        public void a(boolean z, boolean z2, String str, @Nullable String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2}) == null) {
                this.a.I0.T3();
                if (z) {
                    if (this.a.D0 != null) {
                        this.a.D0.h(z2);
                    }
                    this.a.B0.j3(z2);
                    if (!this.a.B0.e1()) {
                        this.a.I0.h2(this.a.B0.t1());
                    } else {
                        this.a.E7();
                    }
                    if (z2) {
                        boolean p0 = this.a.B0.t1().p0();
                        if (this.a.D0 != null && !p0) {
                            if (this.a.D0.f() != null && this.a.B0 != null && this.a.B0.t1() != null && this.a.B0.t1().O() != null && this.a.B0.t1().O().getAuthor() != null) {
                                MarkData f = this.a.D0.f();
                                MetaData author = this.a.B0.t1().O().getAuthor();
                                if (f != null && author != null) {
                                    if (str2 == null) {
                                        str2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f00ff);
                                    }
                                    BdUtilHelper.showToast(str2, 2000, true);
                                    this.a.L8();
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
                        this.a.W5();
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
    public class c3 implements j05.d {
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

        @Override // com.baidu.tieba.j05.d
        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.O0 != null) {
                this.a.O0.s(lz9.h(this.a.D2));
                ArrayList arrayList = new ArrayList();
                for (i05 i05Var : this.a.O0.h()) {
                    if (i05Var instanceof f05) {
                        arrayList.add((f05) i05Var);
                    }
                }
                lz9.f(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnTouchListener {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.B0 != null && this.a.B0.t1() != null) {
                this.a.B0.t1().a();
                this.a.B0.Y1();
                if (this.a.I0.T0() != null) {
                    this.a.I0.h2(this.a.B0.t1());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m0b) && customResponsedMessage.getOrginalMessage().getTag() == this.a.j1) {
                m0b m0bVar = (m0b) customResponsedMessage.getData();
                this.a.I0.O1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.g1;
                DataRes dataRes = m0bVar.a;
                boolean z = false;
                if (m0bVar.c == 0 && dataRes != null) {
                    int i = JavaTypesHelper.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (i == 1) {
                        z = true;
                    }
                    if (qd.isEmpty(str)) {
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
                        this.a.I0.Z2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.I8(z, sparseArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d2 implements AbsListView.OnScrollListener {
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

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<vra> F;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.B0 != null && this.a.B0.t1() != null && this.a.I0 != null && this.a.I0.T0() != null) {
                this.a.I0.S2(absListView, i, i2, i3);
                if (this.a.e != null) {
                    this.a.e.q(absListView, i, i2, i3);
                }
                if (this.a.B0.i2() && (F = this.a.B0.t1().F()) != null && !F.isEmpty()) {
                    int y = ((i + i2) - this.a.I0.T0().y()) - 1;
                    es9 t1 = this.a.B0.t1();
                    if (t1 == null) {
                        return;
                    }
                    if (t1.C() != null && t1.C().F1()) {
                        y--;
                    }
                    if (t1.D() != null && t1.D().F1()) {
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
                if (!ix9.C(this.a.f1) && ix9.C(i)) {
                    if (this.a.I0 != null) {
                        this.a.r0 = true;
                        this.a.I0.F0();
                        if (this.a.Y0 != null && !this.a.I0.j2()) {
                            this.a.I0.z3(this.a.Y0.C());
                        }
                        if (!this.a.J) {
                            this.a.r0 = true;
                            this.a.I0.r3();
                        }
                    }
                    if (!this.a.r) {
                        this.a.r = true;
                    }
                }
                if (this.a.I0 != null) {
                    this.a.I0.T2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.s == null) {
                    this.a.s = new bp5();
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
                    xpa.g().h(this.a.getUniqueId(), true);
                    this.a.e6(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d3 implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                PbFragment pbFragment = this.a;
                pbFragment.b = true;
                return pbFragment.n6(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements lv6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.lv6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.lv6.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
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
            this.b = pbFragment;
            this.a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070282);
        }

        @Override // com.baidu.tieba.lv6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.I0 != null && this.b.e != null) {
                this.b.e.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.e.l();
                }
                if (this.b.M6()) {
                    this.b.I0.P1();
                    this.b.I0.s3();
                }
            }
        }

        @Override // com.baidu.tieba.lv6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.I0 != null && this.b.e != null) {
                this.b.I0.C4();
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
            ura k;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.B0 != null && this.a.B0.t1() != null) {
                String str = (String) customResponsedMessage.getData();
                ura uraVar = null;
                if (!TextUtils.isEmpty(str) && this.a.B0.t1().F() != null) {
                    ArrayList<vra> F = this.a.B0.t1().F();
                    Iterator<vra> it = F.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        vra next = it.next();
                        if (next instanceof ura) {
                            ura uraVar2 = (ura) next;
                            if (str.equals(uraVar2.G1())) {
                                uraVar = uraVar2;
                                break;
                            }
                        }
                    }
                    if (uraVar != null) {
                        F.remove(uraVar);
                    }
                }
                if (this.a.I0.T0() != null && !ListUtils.isEmpty(this.a.I0.T0().v())) {
                    ArrayList<oi> v = this.a.I0.T0().v();
                    if (uraVar != null) {
                        k = uraVar;
                    } else {
                        k = ix9.k(this.a.B0.t1(), str);
                    }
                    ix9.f(v, k);
                }
                if (this.a.I0.m1() != null && !ListUtils.isEmpty(this.a.I0.m1().getData())) {
                    List<oi> data = this.a.I0.m1().getData();
                    if (uraVar == null) {
                        uraVar = ix9.k(this.a.B0.t1(), str);
                    }
                    ix9.f(data, uraVar);
                }
                this.a.p6(str);
                this.a.B0.Y1();
                if (this.a.I0.T0() != null) {
                    this.a.I0.T0().f0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e1() {
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
        public void onNavigationButtonClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e2 implements Comparator<AdverSegmentData> {
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
    public class e3 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ItemCardHelper.l(this.a.getContext(), this.a.getUniqueId(), view2, (ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements mv6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
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

        @Override // com.baidu.tieba.mv6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    yt9.d();
                } else {
                    yt9.c();
                }
            }
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
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.q6();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.I0.j2() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.v6((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    /* loaded from: classes7.dex */
    public class f2 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f3 implements rg5 {
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

        @Override // com.baidu.tieba.rg5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                mx9 mx9Var = this.a.M0;
                if (mx9Var != null && mx9Var.g() != null && this.a.M0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.M0.g().c());
                    if (this.a.I0 != null && this.a.I0.x1() != null && this.a.I0.x1().f() != null && this.a.I0.x1().f().A()) {
                        this.a.I0.x1().f().x(this.a.M0.h());
                    }
                    this.a.M0.b(true);
                    return true;
                }
                return !this.a.j6(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements xv9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.xv9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f17c3);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e61);
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
    public class g0 implements SuggestEmotionModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public g0(PbFragment pbFragment) {
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
        public void a(ry9 ry9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, ry9Var) != null) || ry9Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, ry9Var.a()));
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
    public class g1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g1(PbFragment pbFragment, int i) {
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
                    this.a.I0.E2(agreeMessageData);
                }
                if (agreeData.agreeType == 2 && this.a.I0 != null && !sz9.g(this.a.B0.b)) {
                    this.a.I0.H4();
                    sz9.a(this.a.B0.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g2 extends w4 {
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
                        this.a.B0.Y1();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.B6(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
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
                        pbFragment.C6(pbFragment.E0.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        this.a.I0.O0(this.a.E0.getLoadDataMode(), gVar.a, gVar.b, false);
                        this.a.I0.U2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.I0.O0(this.a.E0.getLoadDataMode(), false, null, false);
        }
    }

    /* loaded from: classes7.dex */
    public class h implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    zz4Var.dismiss();
                    ((TbPageContext) this.a.h1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                zz4Var.dismiss();
                qz9.a(this.a.getPageContext());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!this.a.r0) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        this.a.S7();
                        return;
                    } else {
                        this.a.p8();
                        return;
                    }
                }
                this.a.r0 = false;
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.W6() != null) {
                this.a.W6().O2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h2 implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) && zz4Var != null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class h3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<jx9> a;
        public WeakReference<PbFragment> b;

        public h3(jx9 jx9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(jx9Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                jx9 jx9Var = this.a.get();
                if (jx9Var != null) {
                    jx9Var.O1();
                }
                PbFragment pbFragment = this.b.get();
                if (pbFragment != null && CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        pbFragment.O8(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        g78.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0e61);
                        }
                        pbFragment.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i0 implements PbInterviewStatusView.f {
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

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.I0.J4(!this.a.N);
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
    public class i2 implements g55.g {
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

        @Override // com.baidu.tieba.g55.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.M6()) {
                    this.a.a.finish();
                }
                if (this.a.B0.s2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.I0.N0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 implements GetSugMatchWordsModel.b {
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

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onSuccess(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && !ListUtils.isEmpty(list) && this.a.I0 != null) {
                this.a.I0.Z3(list);
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
    public class j1 implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                this.a.h7();
                ey4 r1 = this.a.B0.r1();
                int u1 = this.a.I0.u1();
                if (u1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f1029);
                } else if (r1 != null && u1 > r1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f1029);
                } else {
                    this.a.I0.F0();
                    this.a.U8();
                    this.a.I0.U3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.B0.h3(this.a.I0.u1());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e61);
                    }
                    zz4Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j2 implements sg5 {
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

        @Override // com.baidu.tieba.sg5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements g3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.g3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.I0 != null && this.a.I0.x1() != null) {
                    gw9 x1 = this.a.I0.x1();
                    if (x1.j()) {
                        x1.h();
                        return true;
                    }
                }
                if (this.a.I0 != null && this.a.I0.y2()) {
                    this.a.I0.S1();
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k0 implements PraiseModel.b {
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
        public void h(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || this.a.R1 == null) {
                return;
            }
            es9 t1 = this.a.B0.t1();
            if (t1.O().getPraise().getIsLike() == 1) {
                this.a.g9(0);
            } else {
                this.a.g9(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, t1.O()));
        }
    }

    /* loaded from: classes7.dex */
    public class k1 implements i3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.i3
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
                String valueOf = String.valueOf(this.a.B0.t1().V().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.B0.t1().k().getId(), this.a.B0.t1().k().getName(), this.a.B0.t1().O().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k2 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.M6()) {
                    this.a.a.finish();
                }
                if (this.a.B0.s2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.I0.N0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ PbFragment b;

        public l(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                this.b.I0.u4();
                MessageManager.getInstance().sendMessage(this.a);
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 implements uy9.h {
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

        @Override // com.baidu.tieba.uy9.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.x8(z);
                if (this.a.I0.j1() != null && z) {
                    this.a.I0.J4(false);
                }
                this.a.I0.L2(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l1 implements j05.f {
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

        @Override // com.baidu.tieba.j05.f
        public void F0(j05 j05Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, j05Var, i, view2) == null) {
                if (this.a.N0 != null) {
                    this.a.N0.dismiss();
                }
                this.a.d9(i);
                if (i != -4) {
                    if (i != -3) {
                        if (i != -2) {
                            if (i != -1) {
                                if (i != 13) {
                                    switch (i) {
                                        case 1:
                                            if (this.a.m1 != null && !TextUtils.isEmpty(this.a.n1)) {
                                                if (this.a.p1 != null) {
                                                    yi5.a aVar = new yi5.a();
                                                    aVar.a = this.a.n1;
                                                    String str = "";
                                                    if (this.a.p1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.p1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.Y5();
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
                                                    pbFragment.l1 = new ox9(pbFragment.getPageContext());
                                                }
                                                this.a.l1.b(this.a.n1, this.a.m1.getImageByte());
                                                this.a.m1 = null;
                                                this.a.n1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            vra vraVar = this.a.D2;
                                            if (vraVar != null) {
                                                vraVar.T0();
                                                this.a.D2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.I7(view2);
                                            if (this.a.B0.t1().O() != null && this.a.B0.t1().O().getAuthor() != null && this.a.B0.t1().O().getAuthor().getUserId() != null && this.a.D0 != null) {
                                                d1a.E(2, ix9.w(this.a.B0.t1()), !this.a.D0.e(), this.a.B0);
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
                                                this.a.e7((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray2.put(R.id.tag_from, 0);
                                                    sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                    this.a.g6(sparseArray2);
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
                                                boolean X = this.a.r0().X(TbadkCoreApplication.getCurrentAccount());
                                                if (X) {
                                                    if (booleanValue2) {
                                                        this.a.I0.X2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, X);
                                                        return;
                                                    } else {
                                                        this.a.E8(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.I0.V2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                                    return;
                                                } else {
                                                    this.a.E8(sparseArray3, intValue, booleanValue);
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
                                                    this.a.g6(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                }
                                                this.a.I0.a3(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.I0.V2(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            vra vraVar2 = (vra) sparseArray.get(R.id.tag_clip_board);
                                            if (vraVar2.p() == null) {
                                                return;
                                            }
                                            this.a.k6(vraVar2.p());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.B0 != null && this.a.B0.t1() != null) {
                                                this.a.a.U1(j0b.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.B0 != null && this.a.B0.t1() != null) {
                                    this.a.I0.c5(true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            if (view3 == null) {
                                return;
                            }
                            this.a.g8(view3);
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
                            this.a.g8(view4);
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
                    this.a.g8(view5);
                    if (view5 != null) {
                        if (sparseArray5 != null && (sparseArray5.get(R.id.tag_is_top_question) instanceof Boolean)) {
                            this.a.v8(((Boolean) sparseArray5.get(R.id.tag_is_top_question)).booleanValue());
                        }
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.g8(view6);
                if (view6 != null) {
                    view6.performClick();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l2 implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.A2 && this.a.M6()) {
                    this.a.z7();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (this.a.I0 != null) {
                    this.a.I0.t3();
                }
                if (!this.a.f0 && this.a.I0 != null && this.a.I0.v0() && this.a.B0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.B0.N1());
                    statisticItem.param("fid", this.a.B0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.B0.Y0()) {
                        i = 4;
                    } else if (this.a.B0.Z0()) {
                        i = 3;
                    } else if (this.a.B0.b1()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.f0 = true;
                }
                if (this.a.B0.q2(false)) {
                    this.a.I0.V3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (this.a.B0.t1() != null) {
                    this.a.I0.n3();
                }
                this.a.A2 = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements j05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ PbFragment e;

        public m0(PbFragment pbFragment, SparseArray sparseArray, boolean z, String str, String str2) {
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

        @Override // com.baidu.tieba.j05.f
        public void F0(j05 j05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, j05Var, i, view2) == null) {
                if (this.e.N0 != null) {
                    this.e.N0.dismiss();
                }
                if (i == 0) {
                    this.e.I0.V2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.j1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.j1);
                    this.e.Q8(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m1 implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PbFragment d;

        public m1(PbFragment pbFragment, SparseArray sparseArray, int i, boolean z) {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                if (zz4Var != null) {
                    zz4Var.dismiss();
                }
                this.d.t6(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m2 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.B0 != null) {
                this.a.B0.loadData();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements TextWatcher {
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

        public n(PbFragment pbFragment) {
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
            mx9 mx9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (mx9Var = this.a.M0) != null && mx9Var.g() != null) {
                if (!this.a.M0.g().e()) {
                    this.a.M0.b(false);
                }
                this.a.M0.g().l(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(PbFragment pbFragment, int i) {
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
                    if (this.a.H6().t() != null && this.a.H6().t().getGodUserData() != null) {
                        this.a.H6().t().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.B0 != null && this.a.B0.t1() != null && this.a.B0.t1().O() != null && this.a.B0.t1().O().getAuthor() != null) {
                        this.a.B0.t1().O().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
                if (updateAttentionMessage.isAttention()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921760, 10));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n1 implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements qw9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.qw9.b
        public void onSuccess(List<vra> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }

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

        @Override // com.baidu.tieba.qw9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.I0.N4(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o0 extends ResponsedEventListener<TipEvent> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.dm5
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
    public class o1 implements SortSwitchButton.f {
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

        public o1(PbFragment pbFragment) {
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
                if (this.a.B0 != null && !this.a.B0.isLoading) {
                    this.a.U8();
                    this.a.I0.U3();
                    z = true;
                    if (this.a.B0.t1() != null && this.a.B0.t1().f != null && this.a.B0.t1().f.size() > i) {
                        int intValue = this.a.B0.t1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.B0.O1()).param("fid", this.a.B0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.B0.n3(intValue)) {
                            this.a.h = true;
                            this.a.I0.J3(true);
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class o2 implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ zz4 c;
        public final /* synthetic */ PbFragment d;

        public o2(PbFragment pbFragment, MarkData markData, MarkData markData2, zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, zz4Var};
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
            this.c = zz4Var;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
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
                this.d.V8();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.B0 != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.Y0 != null) {
                    this.a.I0.z3(this.a.Y0.C());
                }
                this.a.I0.r3();
                this.a.I0.F0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p0 extends ResponsedEventListener<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.dm5
        /* renamed from: g */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                if (this.a.I0 != null && topToastEvent != null) {
                    new BdTopToast(this.a.getContext()).setIcon(topToastEvent.isSuccess()).setContent(topToastEvent.getContent()).show(this.a.I0.G1());
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class p1 implements gu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.gu4.d
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "pbPage.novelPaySuccess" : (String) invokeV.objValue;
        }

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

        @Override // com.baidu.tieba.gu4.c
        public void a(@NonNull String str) {
            vra X;
            wc5 a0;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("PbFragment", "收到H5通知，更新Pb数据：" + str);
                if (this.a.B0 == null) {
                    return;
                }
                this.a.B0.loadData();
                es9 t1 = this.a.B0.t1();
                if (t1 != null && (X = t1.X()) != null && (a0 = X.a0()) != null && !a0.n()) {
                    go5 go5Var = new go5();
                    go5Var.t(a0);
                    String Q = t1.Q();
                    String l = t1.l();
                    if (t1.O() != null) {
                        i = t1.O().getThreadType();
                    } else {
                        i = 0;
                    }
                    go5Var.v(Q, l, i, this.a.B0.M0(), this.a.B0.y1(), a0.d());
                    String x = go5Var.x(a0.e());
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(NovelWebViewActivityConfig.KEY_IS_SHOW_TOAST_TIP, true);
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_ID, String.valueOf(a0.h()));
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_TID, go5Var.i());
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_FID, go5Var.e());
                    BrowserHelper.startWebActivity(this.a.getContext(), "", x, true, true, true, bundle);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921658, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p2 implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ zz4 b;
        public final /* synthetic */ PbFragment c;

        public p2(PbFragment pbFragment, MarkData markData, zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, zz4Var};
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
            this.b = zz4Var;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.V8();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData)) {
                return;
            }
            this.a.B0.q3((UserPendantData) customResponsedMessage.getData());
            if (this.a.I0 != null && this.a.B0 != null) {
                this.a.I0.l3(this.a.B0.t1(), this.a.B0.M1(), this.a.B0.E1(), this.a.I0.B1());
            }
            if (this.a.I0 != null && this.a.I0.T0() != null) {
                this.a.I0.T0().f0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;
        public final /* synthetic */ PbFragment b;

        public q0(PbFragment pbFragment, Intent intent) {
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
            jx9 jx9Var = this.b.I0;
            jx9Var.X3("@" + this.a.getStringExtra("big_pic_type") + " ");
        }
    }

    /* loaded from: classes7.dex */
    public class q1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        public q1(PbFragment pbFragment, String str, String str2) {
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
            this.c.M8(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class q2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ zz4 b;
        public final /* synthetic */ PbFragment c;

        public q2(PbFragment pbFragment, MarkData markData, zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, zz4Var};
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
            this.b = zz4Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.I0 != null && this.c.I0.G1() != null) {
                    this.c.I0.G1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.a.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.V8();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.I0 == null) {
                    return;
                }
                if (booleanValue) {
                    this.a.I0.E4();
                } else {
                    this.a.I0.Q1();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r0 implements Function0<ArrayList<oi>> {
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
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public ArrayList<oi> invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.I0 != null && this.a.I0.T0() != null) {
                    return this.a.I0.T0().v();
                }
                return null;
            }
            return (ArrayList) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class r1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        public r1(PbFragment pbFragment, String str, String str2) {
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
            this.c.M8(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class r2 implements pb<ImageView> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pb
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pb
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pb
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
                    if (lv4.c().g()) {
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
        @Override // com.baidu.tieba.pb
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = lv4.c().g();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.Y0 != null) {
                this.a.I0.z3(this.a.Y0.C());
            }
            this.a.I0.m4(false);
        }
    }

    /* loaded from: classes7.dex */
    public class s0 implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public s0(PbFragment pbFragment) {
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
                if (this.a.I0 != null && this.a.I0.T0() != null) {
                    this.a.I0.T0().f0();
                    return null;
                }
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s1 implements j05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h05 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ PbFragment c;

        public s1(PbFragment pbFragment, h05 h05Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, h05Var, view2};
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
            this.a = h05Var;
            this.b = view2;
        }

        @Override // com.baidu.tieba.j05.f
        public void F0(j05 j05Var, int i, View view2) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, j05Var, i, view2) == null) {
                this.a.dismiss();
                PbModel pbModel = this.c.B0;
                if (this.b.getId() == R.id.obfuscated_res_0x7f091bbc) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                d1a.K(i, pbModel, i2);
                if (this.c.B0.t1().f != null && this.c.B0.t1().f.size() > i) {
                    i = this.c.B0.t1().f.get(i).sort_type.intValue();
                }
                boolean n3 = this.c.B0.n3(i);
                this.b.setTag(Integer.valueOf(this.c.B0.K1()));
                if (!n3) {
                    return;
                }
                this.c.h = true;
                this.c.I0.J3(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s2 implements pb<GifView> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pb
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pb
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pb
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
                gifView.l();
                gifView.h();
                gifView.setImageDrawable(null);
                gifView.m();
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
                if (lv4.c().g()) {
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
        @Override // com.baidu.tieba.pb
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = lv4.c().g();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                mq9 mq9Var = (mq9) customResponsedMessage.getData();
                int b = mq9Var.b();
                if (b != 0) {
                    if (b != 1) {
                        if (b == 2) {
                            if (mq9Var.a() == null) {
                                this.a.i8(false, null);
                                return;
                            } else {
                                this.a.i8(true, (MarkData) mq9Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.B6((ForumManageModel.b) mq9Var.a(), false);
                    return;
                }
                this.a.j8((vs9) mq9Var.a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t0 implements Handler.Callback {
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

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.a.B0 != null && this.a.B0.e1()) {
                    this.a.E7();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class t1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public t1(PbFragment pbFragment) {
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
                if (this.a.s0 && (view2 == this.a.I0.k.e || view2 == this.a.I0.k.f || view2.getId() == R.id.obfuscated_res_0x7f091b98 || view2.getId() == R.id.obfuscated_res_0x7f090bab || view2.getId() == R.id.obfuscated_res_0x7f091f5a || view2.getId() == R.id.obfuscated_res_0x7f091b30)) {
                    return;
                }
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.I0.q1()) {
                        this.a.K7();
                    }
                } else {
                    this.a.o8(view2);
                }
                if (view2 == this.a.I0.s1()) {
                    if (this.a.h || !this.a.B0.q2(true)) {
                        return;
                    }
                    this.a.h = true;
                    this.a.I0.V3();
                } else if (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().F()) {
                    if (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().x()) {
                        if (view2 == this.a.I0.k.h) {
                            if (!this.a.I0.u0(this.a.B0.g1())) {
                                BdUtilHelper.hideSoftKeyPad(this.a.a, this.a.I0.k.h);
                                this.a.a.finish();
                                return;
                            }
                            this.a.U8();
                            return;
                        } else if (view2 != this.a.I0.X0() && (this.a.I0.k.i() == null || (view2 != this.a.I0.k.i().G() && view2 != this.a.I0.k.i().H()))) {
                            if (view2 == this.a.I0.f1()) {
                                if (this.a.B0 != null) {
                                    BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), this.a.B0.t1().O().getTopicData().b());
                                    return;
                                }
                                return;
                            } else if (view2 != this.a.I0.k.e) {
                                if (view2 != this.a.I0.k.f) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f091b57) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091b2b) {
                                            if ((this.a.I0.k.i() == null || view2 != this.a.I0.k.i().D()) && view2.getId() != R.id.obfuscated_res_0x7f090bab && view2.getId() != R.id.obfuscated_res_0x7f091f5a) {
                                                if (this.a.I0.k.i() != null && view2 == this.a.I0.k.i().y()) {
                                                    this.a.I0.k.f();
                                                    return;
                                                } else if (view2.getId() == R.id.share_num_container) {
                                                    if (!ix9.d(this.a.getPageContext(), 11009)) {
                                                        return;
                                                    }
                                                    ix9.x(this.a.getContext(), 3, this.a.G6(), this.a.B0);
                                                    return;
                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f091b30 && view2.getId() != R.id.share_more_container) {
                                                    if (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().E()) {
                                                        if (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().L()) {
                                                            if (this.a.I0.k.i() != null && view2 == this.a.I0.k.i().K()) {
                                                                if (this.a.B0 != null && this.a.B0.t1() != null && this.a.B0.t1().O() != null) {
                                                                    this.a.I0.k.f();
                                                                    TiebaStatic.log(new StatisticItem("c13062"));
                                                                    PbFragment pbFragment = this.a;
                                                                    pbFragment.e7(pbFragment.B0.t1().O().getFirstPostId());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().I()) {
                                                                if (this.a.I0.j1() != view2) {
                                                                    if (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().A()) {
                                                                        if (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().g()) {
                                                                            if (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().z()) {
                                                                                if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f092362 && view2.getId() != R.id.obfuscated_res_0x7f091b43 && view2.getId() != R.id.obfuscated_res_0x7f0919bc) {
                                                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091bae) {
                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091bac && view2.getId() != R.id.obfuscated_res_0x7f091d78 && view2.getId() != R.id.obfuscated_res_0x7f091b3d) {
                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091b41) {
                                                                                                if (view2 != this.a.I0.h1()) {
                                                                                                    if (this.a.I0.k.i() != null && view2 == this.a.I0.k.i().J()) {
                                                                                                        this.a.I0.k.g();
                                                                                                        this.a.I0.B4(this.a.G2);
                                                                                                        return;
                                                                                                    } else if (this.a.I0.k.i() == null || view2 != this.a.I0.k.i().C()) {
                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f09089f && view2.getId() != R.id.obfuscated_res_0x7f090ba7) {
                                                                                                            if (view2.getId() != R.id.pb_u9_text_view) {
                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f091f5f && view2.getId() != R.id.cover_reply_content && view2.getId() != R.id.replybtn_top_right && view2.getId() != R.id.cover_reply_content_top_right) {
                                                                                                                    if (view2.getId() != R.id.pb_act_btn) {
                                                                                                                        if (view2.getId() != R.id.lottery_tail) {
                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091b71 && view2.getId() != R.id.obfuscated_res_0x7f091b38) {
                                                                                                                                if (view2.getId() != R.id.join_vote_tv) {
                                                                                                                                    if (view2.getId() != R.id.look_all_tv) {
                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f09172d) {
                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f09172c) {
                                                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f0927ce) {
                                                                                                                                                    if (view2.getId() == R.id.qq_share_container) {
                                                                                                                                                        if (!ix9.d(this.a.getPageContext(), 11009)) {
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        ix9.x(this.a.getContext(), 8, this.a.G6(), this.a.B0);
                                                                                                                                                        return;
                                                                                                                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f0919bc) {
                                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091b2d) {
                                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091b98) {
                                                                                                                                                                if (view2.getId() != R.id.forum_name_text && view2.getId() != R.id.forum_enter_button_one && view2.getId() != R.id.forum_enter_button_two && view2.getId() != R.id.forum_enter_button_three) {
                                                                                                                                                                    if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                                                                                                                        d1a.I(2, this.a.B0);
                                                                                                                                                                        return;
                                                                                                                                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f091bc0) {
                                                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091bda) {
                                                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091075) {
                                                                                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f091072) {
                                                                                                                                                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091b45 && view2.getId() != R.id.obfuscated_res_0x7f091ba6) {
                                                                                                                                                                                        if (view2.getId() == R.id.obfuscated_res_0x7f0922fa) {
                                                                                                                                                                                            Object tag = view2.getTag();
                                                                                                                                                                                            if (tag instanceof SpriteMemeInfo) {
                                                                                                                                                                                                this.a.I0.P2((SpriteMemeInfo) tag);
                                                                                                                                                                                                return;
                                                                                                                                                                                            }
                                                                                                                                                                                            return;
                                                                                                                                                                                        }
                                                                                                                                                                                        return;
                                                                                                                                                                                    }
                                                                                                                                                                                    this.a.a9(view2);
                                                                                                                                                                                    return;
                                                                                                                                                                                }
                                                                                                                                                                                this.a.b6(view2);
                                                                                                                                                                                return;
                                                                                                                                                                            }
                                                                                                                                                                            this.a.c6(view2);
                                                                                                                                                                            return;
                                                                                                                                                                        }
                                                                                                                                                                        this.a.h9(view2);
                                                                                                                                                                        return;
                                                                                                                                                                    } else {
                                                                                                                                                                        this.a.Y8();
                                                                                                                                                                        return;
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                this.a.y6(view2);
                                                                                                                                                                return;
                                                                                                                                                            }
                                                                                                                                                            this.a.Z8();
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        this.a.w6();
                                                                                                                                                        return;
                                                                                                                                                    } else {
                                                                                                                                                        this.a.w7(view2);
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                this.a.X7();
                                                                                                                                                return;
                                                                                                                                            }
                                                                                                                                            this.a.z7();
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        this.a.B7();
                                                                                                                                        return;
                                                                                                                                    }
                                                                                                                                    this.a.u7(view2);
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                                this.a.s7(view2);
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            this.a.X8(view2);
                                                                                                                            return;
                                                                                                                        }
                                                                                                                        this.a.D7(view2);
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    this.a.t7();
                                                                                                                    return;
                                                                                                                }
                                                                                                                this.a.W7(view2);
                                                                                                                return;
                                                                                                            }
                                                                                                            this.a.Z7(view2);
                                                                                                            return;
                                                                                                        }
                                                                                                        this.a.Y7(view2);
                                                                                                        return;
                                                                                                    } else {
                                                                                                        this.a.g7();
                                                                                                        return;
                                                                                                    }
                                                                                                }
                                                                                                this.a.j7();
                                                                                                return;
                                                                                            }
                                                                                            this.a.U7(view2);
                                                                                            return;
                                                                                        }
                                                                                        this.a.V7(view2);
                                                                                        return;
                                                                                    }
                                                                                    this.a.A6(view2);
                                                                                    return;
                                                                                }
                                                                                this.a.z6(view2);
                                                                                return;
                                                                            }
                                                                            this.a.u6();
                                                                            return;
                                                                        }
                                                                        this.a.a6();
                                                                        return;
                                                                    }
                                                                    this.a.E6();
                                                                    return;
                                                                }
                                                                this.a.b8();
                                                                return;
                                                            } else {
                                                                this.a.m6();
                                                                return;
                                                            }
                                                        }
                                                        this.a.m8(view2);
                                                        return;
                                                    }
                                                    this.a.v7();
                                                    return;
                                                } else {
                                                    this.a.T7(view2);
                                                    return;
                                                }
                                            }
                                            this.a.n8(view2);
                                            return;
                                        }
                                        this.a.x6(view2);
                                        return;
                                    }
                                    this.a.a7();
                                    return;
                                }
                                this.a.M7();
                                return;
                            } else {
                                this.a.L7();
                                return;
                            }
                        } else {
                            this.a.F7(view2);
                            return;
                        }
                    }
                    this.a.d6();
                } else {
                    this.a.y7();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t2 implements pb<TiebaPlusRecommendCard> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pb
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pb
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard c(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            h(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        public TiebaPlusRecommendCard e(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tiebaPlusRecommendCard)) == null) {
                tiebaPlusRecommendCard.m();
                return tiebaPlusRecommendCard;
            }
            return (TiebaPlusRecommendCard) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pb
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
        @Override // com.baidu.tieba.pb
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.I0 != null && this.a.I0.T0() != null) {
                this.a.I0.T0().f0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
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

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    if (this.a.Y0 != null) {
                        this.a.Y0.K(null, null);
                    }
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.I0 != null && this.a.I0.x1() != null && this.a.I0.x1().f() != null) {
                    this.a.I0.x1().f().J();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u1(PbFragment pbFragment, int i) {
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
            this.a.N8((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes7.dex */
    public class u2 implements rg5 {
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

        @Override // com.baidu.tieba.rg5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                mx9 mx9Var = this.a.M0;
                if (mx9Var != null && mx9Var.e() != null && this.a.M0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.M0.e().c());
                    if (this.a.Y0 != null && (this.a.Y0.B() || this.a.Y0.D())) {
                        this.a.Y0.z(false, this.a.M0.h());
                    }
                    this.a.M0.a(true);
                    return true;
                }
                return !this.a.j6(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            return invokeV.booleanValue;
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
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof jy5.a)) {
                jy5.a aVar = (jy5.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.b7(aVar.b);
                }
                if (!StringUtils.isNull(aVar.e)) {
                    str = aVar.e;
                } else {
                    str = aVar.b;
                }
                jy5.c(this.a.getPageContext(), this.a, aVar.a, str, aVar.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v0 extends w4 {
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

        @Override // com.baidu.tieba.w4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v2 implements pb<View> {
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
        @Override // com.baidu.tieba.pb
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pb
        public /* bridge */ /* synthetic */ View c(View view2) {
            View view3 = view2;
            h(view3);
            return view3;
        }

        public View e(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
                ((PlayVoiceBntNew) view2).m();
                return view2;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pb
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).l();
            }
        }

        public View h(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
                ((PlayVoiceBntNew) view2).l();
                return view2;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pb
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.X0());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.f) {
                return;
            }
            this.a.R8();
        }
    }

    /* loaded from: classes7.dex */
    public class w0 implements PbFirstFloorDoubleClickAnimation.d {
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

        @Override // com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w2 implements pb<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pb
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pb
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pb
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pb
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
    public class x implements TiePlusEventController.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public x(PbFragment pbFragment) {
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
    public class x0 implements zt9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.zt9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

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

        @Override // com.baidu.tieba.zt9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091f80) {
                        if (this.a.q8(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090170) {
                        if (motionEvent != null && motionEvent.getAction() == 1) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof vra)) {
                                return false;
                            }
                            vra vraVar = (vra) obj;
                            if (vraVar.getType() != vra.a1 && !TextUtils.isEmpty(vraVar.v()) && lv4.c().g()) {
                                return this.a.N7(vraVar);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091b42) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.S8((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.I0.n2() && view2.getId() == R.id.obfuscated_res_0x7f091b64) {
                            if (view2.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.tag_user_id)));
                            }
                            if (this.a.h1() != null && this.a.h1().b != null) {
                                this.a.h1().b.onClick(view2);
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
                        this.a.S8(sparseArray);
                    }
                }
                if (this.a.Y0 != null) {
                    this.a.I0.z3(this.a.Y0.C());
                }
                this.a.I0.r3();
                this.a.I0.F0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.zt9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                this.a.v6((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class x1 extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x1(PbFragment pbFragment, int i, int i2) {
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
            PbThreadPostView D1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null && (responsedMessage instanceof ThreadPublishHttpResMeesage) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                    if (this.a.I0 != null && (D1 = this.a.I0.D1()) != null && this.a.I0.m1() != null) {
                        this.a.I0.m1().removeHeaderView(D1);
                        return;
                    }
                    return;
                }
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x2 implements pb<ItemCardView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pb
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
        }

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
        @Override // com.baidu.tieba.pb
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pb
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
        @Override // com.baidu.tieba.pb
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getResultData() instanceof String)) {
                new BdTopToast(this.a.getContext()).setIcon(false).setContent((String) customResponsedMessage.getResultData()).show((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y0 implements a05.c {
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

        @Override // com.baidu.tieba.a05.c
        public void a(a05 a05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, a05Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.P0 = pbFragment.P0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.P0);
                    new mv9(this.a.B0.N1(), this.a.P0, "1").start();
                    a05Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.P0 = pbFragment2.P0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.P0);
                    new mv9(this.a.B0.N1(), this.a.P0, "2").start();
                    a05Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.P0 = pbFragment3.P0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.P0);
                    a05Var.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y1 implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, es9 es9Var, String str, int i4, boolean z2) {
            he5 t;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), es9Var, str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
                if (this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907db));
                }
                if (!z || es9Var == null || es9Var.Y() != null || ListUtils.getCount(es9Var.F()) >= 1) {
                    if (this.a.g0) {
                        if (this.a.i0() != null) {
                            this.a.i0().A0();
                        }
                    } else {
                        this.a.g0 = true;
                    }
                    this.a.g = true;
                    if (this.a.I0 == null) {
                        return;
                    }
                    this.a.I0.T3();
                    if (es9Var == null || !es9Var.s0()) {
                        PbFragment pbFragment = this.a;
                        pbFragment.hideLoadingView(pbFragment.I0.G1());
                    }
                    this.a.I0.Q1();
                    if (this.a.J) {
                        this.a.I0.J1();
                    } else if (!this.a.I0.m2()) {
                        this.a.I0.m4(false);
                    }
                    if (this.a.h) {
                        this.a.h = false;
                    }
                    if (i4 == 0 && es9Var != null) {
                        this.a.Q0 = true;
                    }
                    if (es9Var != null) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.hideNetRefreshView(pbFragment2.I0.G1());
                        this.a.I0.f4();
                    }
                    String str2 = null;
                    if (z && es9Var != null) {
                        ThreadData O = es9Var.O();
                        if (O != null && O.isUgcThreadType()) {
                            d();
                        } else {
                            PbFragment pbFragment3 = this.a;
                            pbFragment3.y8(pbFragment3.X0);
                        }
                        this.a.I0.x1().r(es9Var);
                        this.a.I0.t4();
                        if (O != null && O.getCartoonThreadData() != null) {
                            this.a.f9(O.getCartoonThreadData());
                        }
                        if (this.a.Y0 != null) {
                            this.a.I0.z3(this.a.Y0.C());
                        }
                        TbadkCoreApplication.getInst().setDefaultBubble(es9Var.V().getBimg_url());
                        TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(es9Var.V().getDynamicUrl());
                        TbadkCoreApplication.getInst().setDefaultBubbleEndTime(es9Var.V().getBimg_end_time());
                        if (es9Var.F() == null || es9Var.F().size() < 1 || es9Var.F().get(0) == null) {
                            if (es9Var.Y() != null) {
                                this.a.B0.T2(es9Var.Y().T());
                            }
                        } else {
                            this.a.B0.T2(es9Var.F().get(0).T());
                        }
                        if (this.a.Y0 != null) {
                            this.a.Y0.L(es9Var.c());
                            this.a.Y0.M(es9Var.k(), es9Var.V());
                            this.a.Y0.o0(O);
                            this.a.Y0.N(this.a.B0.V0(), this.a.B0.N1(), this.a.B0.R0());
                            if (O != null) {
                                this.a.Y0.d0(O.isMutiForumThread());
                            }
                        }
                        if (this.a.D0 != null) {
                            this.a.D0.h(es9Var.q());
                        }
                        this.a.q = es9Var.r() == 1;
                        if (es9Var.j0()) {
                            this.a.q = true;
                        }
                        this.a.I0.A3(this.a.q);
                        if (this.a.u0.f.size() > 0) {
                            es9Var.T0(this.a.u0.f);
                        }
                        this.a.I0.x4(es9Var, i2, i3, this.a.B0.M1(), i4, this.a.B0.c1());
                        this.a.I0.M4(es9Var, this.a.B0.M1());
                        this.a.I0.U4(this.a.B0.W0());
                        AntiData c = es9Var.c();
                        if (c != null) {
                            this.a.x = c.getVoice_message();
                            if (!StringUtils.isNull(this.a.x) && this.a.Y0 != null && this.a.Y0.a() != null && (t = this.a.Y0.a().t(6)) != null && !TextUtils.isEmpty(this.a.x)) {
                                ((View) t).setOnClickListener(this.a.I1);
                            }
                        }
                        if (!z2 && !this.a.X && !ListUtils.isEmpty(this.a.B0.t1().F()) && !this.a.B0.h2()) {
                            this.a.X = true;
                            this.a.e6(false);
                        }
                        if (!TextUtils.isEmpty(this.a.T0)) {
                            PbFragment pbFragment4 = this.a;
                            ix9.I(pbFragment4, pbFragment4.B0.s1(), this.a.T0);
                            this.a.T0 = null;
                        } else if (this.a.S0) {
                            this.a.S0 = false;
                            if (this.a.W6() != null && this.a.W6().o1() != null && this.a.W6().o1().getVisibility() == 0 && this.a.W6().o1().getPlayerHeight() > 0) {
                                PbFragment pbFragment5 = this.a;
                                ix9.G(pbFragment5, pbFragment5.W6().o1().getPlayerHeight());
                            } else {
                                ix9.G(this.a, 0);
                            }
                        } else if (this.a.U0) {
                            this.a.U0 = false;
                            oy9.k(this.a.getListView());
                        } else if (!TextUtils.isEmpty(this.a.B0.j1())) {
                            oy9.f(this.a.getListView(), this.a.B0.j1());
                            this.a.B0.o2();
                        } else {
                            this.a.I0.s4();
                        }
                        this.a.B0.p2(es9Var.k(), this.a.O1);
                        this.a.B0.t2(this.a.Q1);
                        if (this.a.a1 != null && O != null && O.getAuthor() != null) {
                            AttentionHostData attentionHostData = new AttentionHostData();
                            attentionHostData.parserWithMetaData(O.getAuthor());
                            this.a.a1.setLikeUserData(attentionHostData);
                        }
                        if (this.a.B0 != null && this.a.B0.d2()) {
                            str2 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                        } else if (this.a.I0 != null) {
                            str2 = this.a.I0.y1();
                        }
                        if (this.a.Y0 != null && !StringUtils.isNull(str2)) {
                            this.a.Y0.g0(TbSingleton.getInstance().getAdVertiComment(es9Var.q0(), es9Var.r0(), str2));
                        }
                        if (!this.a.Q0 && ((i2 == 1 || i2 == 2) && this.a.I0 != null)) {
                            this.a.I0.Q0();
                        }
                    } else if (str != null) {
                        if (this.a.Q0 || i4 != 1) {
                            this.a.showToast(str);
                        } else if (i2 == 3 || i2 == 4 || i2 == 6 || i2 == 9) {
                            if (i != 4) {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.I0.G1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                zja.a("pb", false);
                                if (this.a.r0() != null) {
                                    to5.a.a(this.a.r0().getUniqueId(), new Pair<>(PushMessageHelper.ERROR_TYPE, "pb_page"), new Pair<>("error_info", "pb page net error2"));
                                }
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
                            } else if (this.a.B0.I0() == null || StringUtils.isNull(this.a.B0.I0().c)) {
                                PbFragment pbFragment8 = this.a;
                                pbFragment8.showNetRefreshView(pbFragment8.I0.G1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                zja.a("pb", false);
                                if (this.a.r0() != null) {
                                    to5.a.a(this.a.r0().getUniqueId(), new Pair<>(PushMessageHelper.ERROR_TYPE, "pb_page"), new Pair<>("error_info", "pb page net error1"));
                                }
                                PbFragment pbFragment9 = this.a;
                                pbFragment9.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment9.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
                            } else {
                                this.a.I0.W4(this.a.B0.I0());
                            }
                            this.a.I0.J1();
                            this.a.I0.I1();
                        }
                        if (i == 4 || i == 350008) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tid", this.a.B0.N1());
                                jSONObject.put("fid", this.a.B0.getForumId());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                            nq6.b().c(new r95(this.a.B0.N1()));
                        }
                        if (i != 0) {
                            EnterForePvThread enterForePvThread = new EnterForePvThread();
                            enterForePvThread.setOpType("2");
                            enterForePvThread.start();
                        }
                        if (i != -1) {
                            ArrayList<vra> F = (this.a.B0 == null || this.a.B0.t1() == null) ? null : this.a.B0.t1().F();
                            if (ListUtils.getCount(F) == 0 || (ListUtils.getCount(F) == 1 && F.get(0) != null && F.get(0).J() == 1)) {
                                if (this.a.r7()) {
                                    this.a.I0.w3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1026));
                                } else {
                                    this.a.I0.w3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1027));
                                }
                                this.a.I0.h2(this.a.B0.t1());
                            } else {
                                this.a.I0.v3(this.a.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            this.a.I0.v3("");
                        }
                        this.a.I0.M0();
                    }
                    if (es9Var != null && es9Var.m && this.a.m == 0) {
                        this.a.m = System.currentTimeMillis() - this.a.l;
                    }
                    if (this.a.a instanceof PbActivity) {
                        ((PbActivity) this.a.a).f2(es9Var != null ? es9Var.f() : 0, this.a.I0);
                    }
                    if (this.a.B0 == null || this.a.B0.t1() == null) {
                        return;
                    }
                    this.a.B0.t1();
                    return;
                }
                this.a.B0.h3(1);
                if (this.a.e != null) {
                    this.a.e.x();
                }
                if (this.a.I0 != null) {
                    this.a.I0.F4();
                }
            }
        }

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

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(es9 es9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, es9Var) == null) {
                this.a.I0.h2(es9Var);
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
            hp5 hp5Var = new hp5(i, z, responsedMessage, this.a.p, this.a.o, this.a.m, z2, 0L, 0L, j4);
            this.a.o = 0L;
            this.a.p = 0L;
            hp5Var.c();
            if (z2) {
                j3 = j4;
                hp5Var.B = j3;
                hp5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.B0 != null && this.a.B0.t1() != null && this.a.B0.t1().O() != null) {
                int threadType = this.a.B0.t1().O().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.M, "from_personalize")) {
                        dp5 dp5Var = new dp5();
                        dp5Var.F = 1;
                        dp5Var.a(1005);
                        dp5Var.D = j3;
                        dp5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.M, "from_frs")) {
                        hp5 hp5Var2 = new hp5();
                        hp5Var2.a(1000);
                        hp5Var2.D = j3;
                        hp5Var2.d(threadType);
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
            ug5 ug5Var = new ug5();
            this.a.y8(ug5Var);
            PbFragment pbFragment = this.a;
            pbFragment.Y0 = (vg5) ug5Var.a(pbFragment.getContext());
            this.a.Y0.a0(this.a.a.getPageContext());
            this.a.Y0.j0(this.a.o2);
            this.a.Y0.k0(this.a.c1);
            vg5 vg5Var = this.a.Y0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
            if (this.a.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.a.getIntent().getExtras();
            }
            vg5Var.E(pageContext, extras);
            this.a.Y0.a().M(true);
            this.a.I0.u3(this.a.Y0.a());
            if (!this.a.B0.g1()) {
                this.a.Y0.t(this.a.B0.N1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.Y0.g0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.B0.d2()) {
                this.a.Y0.g0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.I0 != null) {
                this.a.Y0.g0(this.a.I0.y1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y2 implements TbRichTextView.z {
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

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            int d;
            rv9 T0;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.I0.I2((TbRichText) view2.getTag());
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
                    d1a.J(3, i2, this.a.B0);
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
                    yw9.e(this.a.B0, str, i, eVar);
                    if (this.a.B0.G.j0()) {
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
                        this.a.D6(rect);
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.setData(arrayList).setIndex(i3).setIsCDN(false).setPostId(eVar.f).setIsReserve(this.a.B0.F1()).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false).setIsSeeHost(this.a.r7()).setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.B0 != null) {
                            builder.setFromForumId(this.a.B0.getFromForumId());
                            if (this.a.B0.t1() != null) {
                                builder.setThreadData(this.a.B0.t1().O());
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
                        builder2.setData(arrayList2).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.a.get(0)).setIsReserve(this.a.B0.F1()).setAssistUrls(concurrentHashMap2).setNeedBroadCaset(false).setIsSeeHost(this.a.r7()).setPostId(eVar.f).setBjhPostId(eVar.f).setIsCanDrag(false);
                        if (this.a.B0 != null) {
                            builder2.setFromForumId(this.a.B0.getFromForumId());
                            if (this.a.B0.t1() != null) {
                                builder2.setThreadData(this.a.B0.t1().O());
                            }
                        }
                        ImageViewerConfig bulid2 = builder2.bulid(this.a.getPageContext().getPageActivity());
                        bulid2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, bulid2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText f = yw9.f(this.a.B0, str, i);
                        if (f != null && (d = yw9.d()) >= 0 && d < f.Q().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = fs9.a(f.Q().get(d));
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
                            if (f.getPostId() != 0 && (T0 = this.a.I0.T0()) != null) {
                                ArrayList<oi> v = T0.v();
                                if (ListUtils.getCount(v) > 0) {
                                    Iterator<oi> it = v.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        oi next = it.next();
                                        if ((next instanceof vra) && f.getPostId() == JavaTypesHelper.toLong(((vra) next).T(), 0L)) {
                                            int i9 = 8;
                                            if (f.getPostId() == JavaTypesHelper.toLong(this.a.B0.R0(), 0L)) {
                                                i9 = 1;
                                            }
                                            d1a.b(this.a.B0.t1(), (vra) next, ((vra) next).g0, i9, 3);
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
                            this.a.D6(rect2);
                            ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                            builder3.setData(arrayList3).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.i).setIsReserve(this.a.B0.F1()).setAssistUrls(concurrentHashMap3).setNeedBroadCaset(false).setIsSeeHost(this.a.r7()).setPostId(eVar.f).setBjhPostId(eVar.f).setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.B0 != null) {
                                builder3.setFromForumId(this.a.B0.getFromForumId());
                                if (this.a.B0.t1() != null) {
                                    builder3.setThreadData(this.a.B0.t1().O());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921658) {
                int error = customResponsedMessage.getError();
                if (!(customResponsedMessage.getData() instanceof Boolean)) {
                    return;
                }
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (error != 0 || !booleanValue || !TbadkCoreApplication.isLogin() || this.a.D0 == null || this.a.D0.e()) {
                    return;
                }
                this.a.H7();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z1(PbFragment pbFragment, int i) {
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
            this.a.e9();
        }
    }

    /* loaded from: classes7.dex */
    public class z2 implements a05.c {
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

        @Override // com.baidu.tieba.a05.c
        public void a(a05 a05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, a05Var, i, view2) == null) {
                if (a05Var != null) {
                    a05Var.e();
                }
                PbFragment pbFragment = this.a;
                vra vraVar = pbFragment.D2;
                if (vraVar != null) {
                    if (i == 0) {
                        vraVar.T0();
                        this.a.D2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.J7(pbFragment2.D2);
                    }
                }
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
        T2 = new e1();
        U2 = new f();
    }

    public static PbFragment O7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65598, null)) == null) {
            return new PbFragment();
        }
        return (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.my5
    public ob<TextView> C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.y == null) {
                this.y = TbRichTextView.H(getContext(), 8);
            }
            return this.y;
        }
        return (ob) invokeV.objValue;
    }

    public final void E7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            es9 t12 = this.B0.t1();
            this.B0.j3(true);
            fr4 fr4Var = this.D0;
            if (fr4Var != null) {
                t12.L0(fr4Var.g());
            }
            this.I0.h2(t12);
        }
    }

    public AntiData F6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.t1() != null) {
                return this.B0.t1().c();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    public void G7() {
        jx9 jx9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (jx9Var = this.I0) == null) {
            return;
        }
        jx9Var.B2();
    }

    public vra H6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            es9 es9Var = this.B0.G;
            if (es9Var != null) {
                return es9Var.X();
            }
            return null;
        }
        return (vra) invokeV.objValue;
    }

    public int I6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.S2;
        }
        return invokeV.intValue;
    }

    public String J6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.M;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.my5
    public ob<ItemCardView> K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.F == null) {
                this.F = new ob<>(new x2(this), 10, 0);
            }
            return this.F;
        }
        return (ob) invokeV.objValue;
    }

    @Override // com.baidu.tieba.my5
    public ob<GifView> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.L == null) {
                this.L = new ob<>(new s2(this), 20, 0);
            }
            return this.L;
        }
        return (ob) invokeV.objValue;
    }

    public PbInterviewStatusView.f L6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.x0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    public boolean M6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (!this.c && this.O2 == -1 && this.P2 == -1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean N6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.p2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean O6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.my5
    public ob<LinearLayout> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.D == null) {
                this.D = new ob<>(new c(this), 15, 0);
            }
            return this.D;
        }
        return (ob) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.my5
    /* renamed from: P6 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            jx9 jx9Var = this.I0;
            if (jx9Var == null) {
                return null;
            }
            return jx9Var.m1();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public int Q6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.P2;
        }
        return invokeV.intValue;
    }

    public int R6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.O2;
        }
        return invokeV.intValue;
    }

    @Nullable
    public final es9 S6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                return pbModel.t1();
            }
            return null;
        }
        return (es9) invokeV.objValue;
    }

    public void S7() {
        nb5 nb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048638, this) == null) && (nb5Var = this.j0) != null) {
            nb5Var.q();
        }
    }

    @Override // com.baidu.tieba.my5
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            jx9 jx9Var = this.I0;
            if (jx9Var == null) {
                return 0;
            }
            return jx9Var.A1();
        }
        return invokeV.intValue;
    }

    public vg5 T6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.Y0;
        }
        return (vg5) invokeV.objValue;
    }

    public uy9 U6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.e;
        }
        return (uy9) invokeV.objValue;
    }

    public final void U8() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048647, this) == null) && (voiceManager = this.i) != null) {
            voiceManager.stopPlay();
        }
    }

    public iz9 V6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.u0;
        }
        return (iz9) invokeV.objValue;
    }

    public final void V8() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048651, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.V1();
        }
    }

    public jx9 W6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.I0;
        }
        return (jx9) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.i;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.m2();
        }
        return invokeV.booleanValue;
    }

    public String Y6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.V;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ob<TbImageView> a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            if (this.z == null) {
                this.z = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.z;
        }
        return (ob) invokeV.objValue;
    }

    public void c8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            d8(null);
        }
    }

    public boolean f8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            nb5 nb5Var = this.j0;
            if (nb5Var != null && nb5Var.t()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ty9 h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            return this.a.h1();
        }
        return (ty9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h1a
    public PbModel i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            return this.B0;
        }
        return (PbModel) invokeV.objValue;
    }

    public void i7() {
        jx9 jx9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048712, this) == null) && (jx9Var = this.I0) != null) {
            jx9Var.L1();
            h7();
        }
    }

    @Override // com.baidu.tieba.my5
    public ob<RelativeLayout> k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            ob<RelativeLayout> obVar = new ob<>(new w2(this), 10, 0);
            this.E = obVar;
            return obVar;
        }
        return (ob) invokeV.objValue;
    }

    public final void k8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            hideNetRefreshView(this.I0.G1());
            J8();
            if (this.B0.u2()) {
                this.I0.U3();
            }
            this.I0.f4();
        }
    }

    public final void l7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.Q = likeModel;
            likeModel.setLoadDataCallBack(new v0(this));
        }
    }

    @Override // com.baidu.tieba.h1a
    public PbModel.h m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) {
            return this.s2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public final void m7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            rz9 rz9Var = new rz9(getPageContext());
            rz9Var.m();
            this.b1 = rz9Var;
        }
    }

    @Override // com.baidu.tieba.my5
    public ob<FestivalTipView> n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) {
            if (this.H == null) {
                this.H = TbRichTextView.G(getContext(), R.dimen.M_H_X004);
            }
            return this.H;
        }
        return (ob) invokeV.objValue;
    }

    public boolean o7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                return pbModel.Y0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048745, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.d0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public si onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (si) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
            k8();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tieba.my5
    public ob<ImageView> p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            if (this.A == null) {
                this.A = new ob<>(new r2(this), 8, 0);
            }
            return this.A;
        }
        return (ob) invokeV.objValue;
    }

    public final boolean p7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null && absPbActivity.F1() != null && this.a.F1().s1() == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void p8() {
        nb5 nb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048760, this) == null) && (nb5Var = this.j0) != null) {
            nb5Var.x();
        }
    }

    @Override // com.baidu.tieba.my5
    public ob<View> q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) {
            if (this.B == null) {
                this.B = new ob<>(new v2(this), 8, 0);
            }
            return this.B;
        }
        return (ob) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h1a
    public AbsPbActivity r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public boolean r7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                return pbModel.W0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.my5
    public ob<TiebaPlusRecommendCard> t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048774, this)) == null) {
            if (this.C == null) {
                this.C = new ob<>(new t2(this), 5, 0);
            }
            return this.C;
        }
        return (ob) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048779, this) == null) && (pbModel = this.B0) != null && !qd.isEmpty(pbModel.N1())) {
            super.taskStart();
        }
    }

    public boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048780, this)) == null) {
            return this.s0;
        }
        return invokeV.booleanValue;
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
        this.t0 = new x(this);
        this.w0 = false;
        this.x0 = new i0(this);
        this.y0 = new Handler(new t0(this));
        this.z0 = new p1(this);
        this.A0 = new a2(this);
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
        this.c1 = new j2(this);
        this.d1 = new u2(this);
        this.e1 = new f3(this);
        this.f1 = 0;
        this.q1 = false;
        this.r1 = 0;
        this.s1 = -1;
        this.u1 = 0;
        this.w1 = new k(this);
        this.x1 = new o(this);
        this.y1 = new p(this, 2004016);
        this.z1 = new q(this, 2016485);
        this.A1 = new r(this, 2001269);
        this.B1 = new s(this, 2004008);
        this.C1 = new t(this, 2004007);
        this.D1 = new u(this, 2004005);
        this.E1 = new v(this, 2001332);
        this.F1 = new w(this, 2921391);
        this.G1 = new y(this, 2921606);
        this.H1 = new z(this, 2921658);
        this.I1 = new a0(this);
        this.J1 = new b0(this, 2001369);
        this.K1 = new c0(this, 2921787);
        this.L1 = new d0(this, 2016488);
        this.M1 = new e0(this, 2016331);
        this.N1 = new f0(this, 2921746);
        this.O1 = new g0(this);
        this.P1 = new h0(this, 2010045);
        this.Q1 = new j0(this);
        this.R1 = new PraiseModel(getPageContext(), new k0(this));
        this.S1 = new l0(this);
        this.T1 = new n0(this, 2001115);
        this.U1 = new o0(this);
        this.V1 = new p0(this);
        this.X1 = new zt9(new x0(this));
        this.Y1 = new z0(this);
        this.Z1 = new a1(this, 2001427);
        this.a2 = new b1(this, 2001428);
        this.b2 = new c1(this, 2921634);
        this.c2 = new d1(this, 2001426);
        this.d2 = new f1(this, 2004021);
        this.e2 = new g1(this, 2016528);
        this.g2 = new h1(this, 2921724);
        this.h2 = new i1(this, 2921033);
        this.i2 = new j1(this);
        this.j2 = new k1(this);
        this.k2 = new l1(this);
        this.l2 = new o1(this);
        this.m2 = new t1(this);
        this.n2 = new u1(this, 2921480);
        this.o2 = new v1(this);
        this.p2 = Boolean.FALSE;
        this.q2 = new w1(this);
        this.r2 = new x1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.s2 = new y1(this);
        this.t2 = new z1(this, 2016450);
        this.u2 = new b2(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.v2 = new c2(this);
        this.w2 = new d2(this);
        this.x2 = new g2(this);
        this.y2 = new i2(this);
        this.z2 = new k2(this);
        this.B2 = new l2(this);
        this.C2 = new y2(this);
        this.D2 = null;
        this.E2 = new z2(this);
        this.F2 = new a3(this);
        this.G2 = new b3(this);
        this.H2 = new d3(this);
        this.I2 = new e3(this);
        this.J2 = new a(this);
        this.K2 = new b(this);
        this.L2 = new d(this);
        this.M2 = new e(this);
        this.N2 = new g(this);
        this.O2 = -1;
        this.P2 = -1;
        this.S2 = 0;
    }

    @Override // com.baidu.tieba.h1a
    public void finish() {
        jx9 jx9Var;
        boolean z3;
        CardHListViewData p3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            jx9 jx9Var2 = this.I0;
            if (jx9Var2 != null) {
                jx9Var2.F0();
            }
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.t1() != null && !this.B0.t1().j0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.B0.t1().O().getId();
                if (this.B0.isShareThread() && this.B0.t1().O().originalThreadData != null) {
                    historyMessage.threadName = this.B0.t1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.B0.t1().O().getTitle();
                }
                if (this.B0.isShareThread() && !Y0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.B0.t1().k().getName();
                }
                ArrayList<vra> F = this.B0.t1().F();
                jx9 jx9Var3 = this.I0;
                if (jx9Var3 != null) {
                    i4 = jx9Var3.d1();
                } else {
                    i4 = 0;
                }
                if (F != null && i4 >= 0 && i4 < F.size()) {
                    historyMessage.postID = F.get(i4).T();
                }
                historyMessage.isHostOnly = this.B0.W0();
                historyMessage.isSquence = this.B0.M1();
                historyMessage.isShareThread = this.B0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            if (this.V0) {
                nq6.b().c(new ih5(this.B0.N1()));
            }
            PbModel pbModel2 = this.B0;
            if (pbModel2 != null && (pbModel2.Y0() || this.B0.b1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.B0.N1());
                if (this.J0) {
                    if (this.L0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.B0.h1());
                    }
                    if (this.K0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.B0.d1());
                    }
                }
                if (this.B0.b1() && this.B0.t1() != null && this.B0.t1().O() != null) {
                    nq6.b().c(new jh5(this.B0.R()));
                }
                if (this.B0.t1() != null && System.currentTimeMillis() - this.n >= 40000 && (p3 = this.B0.t1().p()) != null && !ListUtils.isEmpty(p3.getDataList())) {
                    intent.putExtra("guess_like_data", p3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.s1);
                }
                this.a.setResult(-1, intent);
            }
            if (W8()) {
                if (this.B0 != null && (jx9Var = this.I0) != null && jx9Var.m1() != null) {
                    es9 t12 = this.B0.t1();
                    if (t12 != null) {
                        if (t12.V() != null) {
                            t12.V().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            t12.V().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!t12.s0() && !this.I && t12.h == null) {
                            ax9 b4 = ax9.b();
                            es9 u12 = this.B0.u1();
                            Parcelable onSaveInstanceState = this.I0.m1().onSaveInstanceState();
                            boolean M1 = this.B0.M1();
                            boolean W0 = this.B0.W0();
                            if (this.I0.v1() != null && this.I0.v1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.l(u12, onSaveInstanceState, M1, W0, z3);
                            if (this.r1 >= 0 || this.B0.P1() != null) {
                                ax9.b().o(this.B0.P1());
                                ax9.b().p(this.B0.Q1());
                                ax9.b().m(this.B0.m1());
                            }
                        }
                    }
                } else {
                    ax9.b().k();
                }
                V8();
            }
            rz9 rz9Var = this.b1;
            if (rz9Var != null && !rz9Var.o() && h6() && this.B0.b1() && !TextUtils.isEmpty(this.B0.R())) {
                this.b1.n(this.B0.t1().g().l, this.B0.R());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e3, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0159, code lost:
        if ((r7.h1.a.getView().getTop() - r11.I0.k.a.getBottom()) < (r11.I0.h1.a.g.getHeight() + 10)) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void w6() {
        PbModel pbModel;
        int top;
        boolean z3;
        boolean z4;
        jx9.g1 g1Var;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        d0a d0aVar;
        PbReplyTitleViewHolder pbReplyTitleViewHolder2;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048787, this) == null) && this.I0.m1() != null && (pbModel = this.B0) != null && pbModel.t1() != null) {
            int firstVisiblePosition = this.I0.m1().getFirstVisiblePosition();
            int i4 = 0;
            View childAt = this.I0.m1().getChildAt(0);
            if (childAt == null) {
                top = 0;
            } else {
                top = childAt.getTop();
            }
            boolean x02 = this.B0.t1().x0();
            boolean s22 = this.I0.s2();
            if (firstVisiblePosition == 0 && top == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            ix9.g(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.B0.t1());
            if ((this.B0.t1().O() != null && this.B0.t1().O().getReply_num() <= 0) || (s22 && z3)) {
                d1a.N(1, 1);
                if (!checkUpIsLogin()) {
                    d1a.N(2, 1);
                    return;
                }
                c8();
                if (this.B0.t1().O().getAuthor() != null) {
                    d1a.x(2, this.B0);
                }
            } else {
                int equipmentHeight = (int) (BdUtilHelper.getEquipmentHeight(getContext()) * 0.6d);
                if (x02) {
                    jx9.g1 g1Var2 = this.I0.h1;
                    if (g1Var2 != null) {
                        PbReplyTitleViewHolder pbReplyTitleViewHolder3 = g1Var2.a;
                        if (pbReplyTitleViewHolder3 != null && pbReplyTitleViewHolder3.getView() != null) {
                            if (this.I0.h1.a.getView().getParent() != null) {
                            }
                        }
                    }
                    z4 = false;
                } else {
                    if (this.I0.v1() != null) {
                        if (this.I0.v1().getVisibility() == 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z4 && (g1Var = this.I0.h1) != null && (pbReplyTitleViewHolder = g1Var.a) != null && pbReplyTitleViewHolder.getView() != null && this.I0.h1.a.getView().getParent() != null && (d0aVar = (r7 = this.I0).k) != null && d0aVar.a != null) {
                        }
                    }
                    z4 = false;
                }
                if (!z4 && !s22) {
                    if (this.a0 > 0) {
                        if (this.I0.m1().getChildAt(this.a0) != null) {
                            this.I0.m1().D(this.a0, this.b0, 200);
                        } else {
                            this.I0.m1().setSelectionFromTop(this.a0, this.b0 + equipmentHeight);
                            this.I0.m1().smoothScrollBy(equipmentHeight, 500);
                        }
                    } else {
                        int d4 = oy9.d(getListView());
                        if (oy9.e(getListView()) != -1) {
                            d4--;
                        }
                        int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds100);
                        if (d4 < 0) {
                            d4 = (ListUtils.getCount(this.I0.m1().getData()) - 1) + this.I0.m1().getHeaderViewsCount();
                        } else {
                            i4 = dimens;
                        }
                        d0a d0aVar2 = this.I0.k;
                        if (d0aVar2 != null && (navigationBar = d0aVar2.a) != null) {
                            i4 += navigationBar.getFixedNavHeight() - 10;
                        }
                        jx9.g1 g1Var3 = this.I0.h1;
                        if (g1Var3 != null && (pbReplyTitleViewHolder2 = g1Var3.a) != null && pbReplyTitleViewHolder2.getView() != null && this.I0.h1.a.getView().getParent() != null) {
                            this.I0.m1().D(d4, i4, 200);
                        } else {
                            this.I0.m1().setSelectionFromTop(d4, i4 + equipmentHeight);
                            this.I0.m1().smoothScrollBy(equipmentHeight, 500);
                        }
                    }
                } else {
                    this.a0 = firstVisiblePosition;
                    this.b0 = top;
                    if (firstVisiblePosition <= 3 && (firstVisiblePosition != 3 || top >= (-equipmentHeight))) {
                        this.I0.m1().D(0, 0, 500);
                    } else {
                        int i5 = -equipmentHeight;
                        this.I0.m1().setSelectionFromTop(0, i5);
                        this.I0.m1().smoothScrollBy(i5, 500);
                    }
                }
            }
            if (this.B0.t1().O() != null && this.B0.t1().O().getAuthor() != null) {
                d1a.x(2, this.B0);
            }
        }
    }

    @Override // com.baidu.tieba.my5
    public void E0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, context, str) == null) {
            this.u = true;
        }
    }

    @Override // com.baidu.tieba.my5
    public void b0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048677, this, context, str) == null) {
            px9.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.u = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        jx9 jx9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048747, this, i4, keyEvent)) == null) {
            if (keyEvent != null && (jx9Var = this.I0) != null) {
                return jx9Var.J2(i4);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void A8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z3) == null) {
            this.K = z3;
        }
    }

    public final void B8(boolean z3) {
        vg5 vg5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z3) != null) || (vg5Var = this.Y0) == null) {
            return;
        }
        vg5Var.b0(z3);
        this.Y0.e0(z3);
        this.Y0.m0(z3);
    }

    public void F8(View view2) {
        es9 S6;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, view2) == null) && (S6 = S6()) != null) {
            mz9.d(getContext(), view2, S6);
        }
    }

    public final void I7(View view2) {
        SparseArray sparseArray;
        vra vraVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (vraVar = (vra) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            J7(vraVar);
        }
    }

    public final void O8(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i4) == null) {
            sz9.i(this, G6(), i4);
        }
    }

    @Override // com.baidu.tieba.q1a.b
    public void Q1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z3) == null) {
            this.R0 = z3;
        }
    }

    public void U5(g3 g3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048644, this, g3Var) == null) && g3Var != null) {
            if (this.t1 == null) {
                this.t1 = new ArrayList();
            }
            if (!this.t1.contains(g3Var)) {
                this.t1.add(g3Var);
            }
        }
    }

    public void V5(g3 g3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048648, this, g3Var) == null) && g3Var != null) {
            if (this.t1 == null) {
                this.t1 = new ArrayList();
            }
            if (!this.t1.contains(g3Var)) {
                this.t1.add(0, g3Var);
            }
        }
    }

    public final void f7(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, intent) == null) {
            sz9.f(this, intent);
        }
    }

    public final void f9(xw4 xw4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048698, this, xw4Var) == null) && xw4Var != null) {
            this.R2 = xw4Var;
            this.c = true;
            this.I0.p3();
            this.I0.I3(this.Q2);
        }
    }

    public void l8(g3 g3Var) {
        List<g3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048724, this, g3Var) == null) && g3Var != null && (list = this.t1) != null) {
            list.remove(g3Var);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048738, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tieba.zz4.e
    public void onClick(zz4 zz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048740, this, zz4Var) == null) {
            s6(zz4Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.z4
    public void onPreLoad(si siVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048750, this, siVar) == null) {
            PreLoadImageHelper.load(siVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(siVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.B0.P2(bundle);
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            vg5 vg5Var = this.Y0;
            if (vg5Var != null) {
                vg5Var.J(bundle);
            }
        }
    }

    public final void t8(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048777, this, i4) == null) && this.B0 != null) {
            J8();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i4);
            privacySettingMessage.setTid(this.B0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void u8(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048783, this, i4) == null) {
            this.S2 = i4;
        }
    }

    public void v8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048786, this, z3) == null) {
            this.p2 = Boolean.valueOf(z3);
        }
    }

    public final void w7(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048788, this, view2) == null) {
            if (view2.getTag() instanceof SparseArray) {
                sparseArray = (SparseArray) view2.getTag();
            } else {
                sparseArray = null;
            }
            if (sparseArray == null) {
                return;
            }
            S8(sparseArray);
        }
    }

    public void w8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048789, this, z3) == null) {
            this.s0 = z3;
        }
    }

    public final void x7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048791, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            BrowserHelper.startWebActivity(getContext(), "", str, false, true, true, bundle);
        }
    }

    public void x8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048792, this, z3) == null) {
            this.N = z3;
        }
    }

    public final void A6(View view2) {
        PbModel pbModel;
        int i4;
        es9 es9Var;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (pbModel = this.B0) == null) {
            return;
        }
        d1a.I(5, pbModel);
        if (view2.getId() == R.id.obfuscated_res_0x7f091bae && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
            this.S = view2;
        } else if (!checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
        } else {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof vra)) {
                return;
            }
            vra vraVar = (vra) sparseArray.get(R.id.tag_load_sub_data);
            StatisticItem statisticItem = vraVar.h0;
            if (statisticItem != null) {
                StatisticItem copy = statisticItem.copy();
                copy.delete("obj_locate");
                copy.param("obj_locate", 8);
                TiebaStatic.log(copy);
            }
            PbModel pbModel2 = this.B0;
            if (pbModel2 != null && pbModel2.t1() != null) {
                String N1 = this.B0.N1();
                String T3 = vraVar.T();
                if (this.B0.t1() != null) {
                    i4 = this.B0.t1().W();
                } else {
                    i4 = 0;
                }
                AbsPbActivity.e e8 = e8(T3);
                if (e8 == null) {
                    return;
                }
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(N1, T3, "pb", true, false, null, false, null, i4, vraVar.m0(), this.B0.t1().c(), false, vraVar.t().getIconInfo(), 5).addBigImageData(e8.a, e8.b, e8.g, e8.j);
                addBigImageData.setKeyPageStartFrom(this.B0.s1());
                addBigImageData.setFromFrsForumId(this.B0.getFromForumId());
                addBigImageData.setWorksInfoData(this.B0.S1());
                addBigImageData.setKeyFromForumId(this.B0.getForumId());
                addBigImageData.setTiebaPlusData(this.B0.X(), this.B0.T(), this.B0.U(), this.B0.S(), this.B0.Y());
                addBigImageData.setBjhData(this.B0.K0());
                if (this.B0.t1().n() != null) {
                    addBigImageData.setHasForumRule(this.B0.t1().n().has_forum_rule.intValue());
                }
                if (this.B0.t1().V() != null) {
                    addBigImageData.setIsManager(this.B0.t1().V().getIs_manager());
                }
                if (this.B0.t1().k().getDeletedReasonInfo() != null) {
                    addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.B0.t1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                    addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.B0.t1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                }
                if (this.B0.t1().k() != null) {
                    addBigImageData.setForumHeadUrl(this.B0.t1().k().getImage_url());
                    addBigImageData.setUserLevel(this.B0.t1().k().getUser_level());
                }
                if (this.I0 != null && (es9Var = this.B0.G) != null) {
                    if (!es9Var.X().f1175T && !vraVar.f1175T) {
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

    public final void A7(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            PbModel F1 = this.a.F1();
            this.B0 = F1;
            if (F1 != null) {
                if (F1.O0() != null) {
                    this.B0.O0().c(this.N2);
                }
                if (this.B0.p1() != null) {
                    this.B0.p1().f(this.x1);
                }
                if (StringUtils.isNull(this.B0.N1())) {
                    this.a.finish();
                } else if ("from_tieba_kuang".equals(this.M) && this.M != null) {
                    this.B0.a3(6);
                }
            }
        }
    }

    public final void Z7(View view2) {
        lz4 lz4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048669, this, view2) == null) && checkUpIsLogin() && (lz4Var = (lz4) view2.getTag()) != null && !StringUtils.isNull(lz4Var.F1())) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{lz4Var.F1()});
        }
    }

    public void a8(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048675, this, animatorListener) == null) && this.I0 != null && (pbModel = this.B0) != null && pbModel.t1() != null && this.B0.t1().S() != null && checkUpIsLogin() && this.I0.T0() != null && this.I0.T0().B() != null) {
            this.I0.T0().B().V(animatorListener);
        }
    }

    public final void c6(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048682, this, view2) != null) || !(view2.getTag() instanceof ThreadData)) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
        createNormalCfg.setCallFrom(14);
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        d1a.H(threadData, 9, 9);
    }

    public final void c9(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048685, this, z3) == null) && (absPbActivity = this.a) != null && absPbActivity.F1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.F1().N1()).param("topic_id", this.a.F1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.F1().R1()));
        }
    }

    public void g6(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048700, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.I0.u4();
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

    public boolean j6(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048715, this, i4)) == null) {
            if (this.a1 != null && this.B0.t1() != null && !ThreadCardUtils.isSelf(this.B0.t1().O()) && this.B0.t1().c() != null) {
                return this.a1.checkPrivacyBeforeSend(this.B0.t1().c().replyPrivateFlag, i4);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z3;
        jx9 jx9Var;
        d0a d0aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (UtilHelper.isFoldScreen() && (jx9Var = this.I0) != null && (d0aVar = jx9Var.k) != null && d0aVar.n()) {
                this.I0.k.g();
                R7();
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
            jx9 jx9Var2 = this.I0;
            if (jx9Var2 != null) {
                jx9Var2.G2(configuration);
            }
            h05 h05Var = this.N0;
            if (h05Var != null) {
                h05Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public final void s7(View view2) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048771, this, view2) == null) && view2 != null) {
            BrowserHelper.startWebActivity(getActivity(), StringUtils.string(view2.getTag()));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (G6() == 1 && (pbModel = this.B0) != null && pbModel.t1() != null) {
                d1a.D("c10397", this.B0.t1().l(), this.B0.t1().Q(), currentAccount);
            }
        }
    }

    public final void u7(View view2) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048782, this, view2) == null) && view2 != null) {
            String string = StringUtils.string(view2.getTag());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            BrowserHelper.startWebActivity(getActivity(), string);
            if (G6() == 1 && (pbModel = this.B0) != null && pbModel.t1() != null) {
                d1a.D("c10507", this.B0.t1().l(), this.B0.t1().Q(), currentAccount);
            }
        }
    }

    public final void y8(wg5 wg5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048795, this, wg5Var) == null) && wg5Var != null && (pbModel = this.B0) != null) {
            wg5Var.p(pbModel.S0());
            if (this.B0.t1() != null && this.B0.t1().k() != null) {
                wg5Var.o(this.B0.t1().k());
            }
            wg5Var.q("pb");
            wg5Var.r(this.B0);
            wg5Var.s(PbNewEditorTool.InputShowType.REPLY);
        }
    }

    public final void z8(int i4) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048799, this, i4) != null) || (pbModel = this.B0) == null) {
            return;
        }
        int D1 = pbModel.D1();
        if (i4 != 5) {
            if (i4 != 6) {
                if (i4 != 7) {
                    this.B0.d3(1);
                } else {
                    this.B0.d3(4);
                }
            } else {
                this.B0.d3(3);
            }
        } else {
            this.B0.d3(2);
        }
        int D12 = this.B0.D1();
        if (D1 == 4 || D12 == 4) {
            Q7();
        }
    }

    public final void B6(ForumManageModel.b bVar, boolean z3) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048579, this, bVar, z3) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i4 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                zz4 zz4Var = new zz4(getPageContext().getPageActivity());
                zz4Var.setMessage(string);
                zz4Var.setPositiveButton(R.string.dialog_known, new h2(this));
                zz4Var.setCancelable(true);
                zz4Var.create(getPageContext());
                zz4Var.show();
            } else if (bVar.d != 0) {
                this.I0.O0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i5 = bVar.d;
                if (i5 == 1) {
                    ArrayList<vra> F = this.B0.t1().F();
                    int size = F.size();
                    while (true) {
                        if (i4 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i4).T())) {
                            F.remove(i4);
                            break;
                        } else {
                            i4++;
                        }
                    }
                    this.B0.t1().O().setReply_num(this.B0.t1().O().getReply_num() - 1);
                    this.I0.h2(this.B0.t1());
                } else if (i5 == 0) {
                    l6();
                } else if (i5 == 2) {
                    ArrayList<vra> F2 = this.B0.t1().F();
                    int size2 = F2.size();
                    boolean z4 = false;
                    for (int i6 = 0; i6 < size2 && !z4; i6++) {
                        int i7 = 0;
                        while (true) {
                            if (i7 >= F2.get(i6).j0().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i6).j0().get(i7).T())) {
                                F2.get(i6).j0().remove(i7);
                                F2.get(i6).h();
                                z4 = true;
                                break;
                            } else {
                                i7++;
                            }
                        }
                        F2.get(i6).i(bVar.g);
                    }
                    if (z4) {
                        this.I0.h2(this.B0.t1());
                    }
                    o6(bVar, this.I0);
                }
            }
        }
    }

    public final void M8(String str, String str2) {
        int i4;
        int dimens;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, str, str2) == null) {
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
            jx9 jx9Var = this.I0;
            if (jx9Var != null && jx9Var.m1() != null) {
                this.I0.m1().smoothScrollBy(i6, 50);
            }
            if (W6().x1() != null) {
                vg5 vg5Var = this.Y0;
                if (vg5Var != null) {
                    vg5Var.a().setVisibility(8);
                }
                PbModel pbModel2 = this.B0;
                W6().x1().t(str, str2, W6().y1(), (pbModel2 == null || pbModel2.t1() == null || this.B0.t1().O() == null || !this.B0.t1().O().isBjh()) ? false : false);
                yg5 f4 = W6().x1().f();
                if (f4 != null && (pbModel = this.B0) != null && pbModel.t1() != null) {
                    f4.K(this.B0.t1().c());
                    f4.g0(this.B0.t1().O());
                }
                if (this.M0.f() == null && W6().x1().f().v() != null) {
                    W6().x1().f().v().i(new n(this));
                    this.M0.n(W6().x1().f().v().k());
                    W6().x1().f().Q(this.e1);
                }
            }
            W6().J1();
        }
    }

    public final void c7(int i4, Intent intent) {
        me5 me5Var;
        me5 me5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048683, this, i4, intent) == null) {
            if (i4 == 0) {
                this.I0.L1();
                this.I0.x1().g();
                this.I0.m4(false);
            }
            this.I0.r3();
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
                if (editorType == 1 && this.I0.x1() != null && this.I0.x1().f() != null) {
                    yg5 f4 = this.I0.x1().f();
                    f4.g0(this.B0.t1().O());
                    f4.E(writeData);
                    f4.h0(pbEditorData.getVoiceModel());
                    le5 u3 = f4.a().u(6);
                    if (u3 != null && (me5Var2 = u3.m) != null) {
                        me5Var2.S(new yd5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i4 == -1) {
                        f4.J();
                        return;
                    }
                    return;
                }
                return;
            }
            vg5 vg5Var = this.Y0;
            if (vg5Var != null) {
                vg5Var.P();
                this.Y0.q0(pbEditorData.getVoiceModel());
                this.Y0.F(writeData);
                le5 u4 = this.Y0.a().u(6);
                if (u4 != null && (me5Var = u4.m) != null) {
                    me5Var.S(new yd5(52, 0, pbEditorData.getVoiceModel()));
                }
                this.Y0.l0(pbEditorData.isShowCustomFigure());
                le5 u5 = this.Y0.a().u(41);
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

    public final void B7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.R2 != null) {
            if (this.O2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f1024);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.R2.a(), this.O2, 0)));
                this.a.finish();
            }
        }
    }

    public final void H8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            zz4 zz4Var = new zz4(getPageContext().getPageActivity());
            zz4Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            zz4Var.setPositiveButton(R.string.open_now, new h(this));
            zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d3, new i(this));
            zz4Var.create(this.h1).show();
        }
    }

    public final void J8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            showLoadingView(this.I0.G1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d5));
            View attachedView = getLoadingView().getAttachedView();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
            layoutParams.addRule(3, this.I0.F1().getId());
            attachedView.setLayoutParams(layoutParams);
        }
    }

    public final void K7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && getPageContext().getPageActivity() != null && this.B0 != null) {
            sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(getPageContext().getPageActivity(), this.B0.N1(), this.B0.f2(), this.B0.e2())));
            d1a.C(this.B0);
        }
    }

    public final void X6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            if (this.G0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.G0 = pollingModel;
                pollingModel.setDialogTime(s05.e);
            }
            this.G0.getData(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            SafeHandler.getInst().postDelayed(this.Y1, 10000L);
        }
    }

    public final void X7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048659, this) == null) && this.r1 >= 0) {
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                pbModel.O2();
            }
            if (this.B0 != null && this.I0.T0() != null) {
                this.I0.T0().n0(this.B0.t1(), false);
            }
            this.r1 = 0;
            if (this.B0 != null) {
                if (this.I0.m1() != null) {
                    this.I0.m1().setSelection(this.B0.m1());
                }
                this.B0.S2(0, 0);
            }
        }
    }

    public final void Y5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            if (this.o1 != null) {
                yi5.b bVar = new yi5.b();
                bVar.a = this.o1.S();
                bVar.b = this.o1.Q();
                bVar.c = String.valueOf(this.o1.T());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.n1));
        }
    }

    public final void Y8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048665, this) == null) && (pbModel = this.B0) != null && pbModel.t1() != null) {
            es9 t12 = this.B0.t1();
            if (this.F0 == null) {
                this.F0 = new xs9(getPageContext());
            }
            long j3 = JavaTypesHelper.toLong(t12.Q(), 0L);
            long j4 = JavaTypesHelper.toLong(t12.l(), 0L);
            d1a.M("c13446", j4);
            registerListener(this.r2);
            this.F0.a(j3, j4);
        }
    }

    public final void a7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.I0.F3(true);
            this.I0.r3();
            if (this.h) {
                return;
            }
            this.h = true;
            this.I0.E4();
            U8();
            this.I0.U3();
            this.B0.l3(K6());
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
        }
    }

    public final void b9() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048681, this) == null) && (absPbActivity = this.a) != null && absPbActivity.F1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.F1().N1()).param("topic_id", this.a.F1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.F1().R1()));
        }
    }

    public final void e9() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048694, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.T(this.B0.getForumId()) && this.B0.t1() != null && this.B0.t1().k() != null) {
            boolean z3 = true;
            if (this.B0.t1().k().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.B0.G0().S(this.B0.getForumId(), this.B0.N1());
            }
        }
    }

    public final boolean f6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel == null || pbModel.t1() == null) {
                return false;
            }
            ThreadData O = this.B0.t1().O();
            AntiData c4 = this.B0.t1().c();
            if (!AntiHelper.b(getPageContext(), O) && !AntiHelper.d(getPageContext(), c4)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean i6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            if ((this.B0.t1() != null && (this.B0.t1().j0() || ThreadCardUtils.isSelf(this.B0.t1().O()))) || this.a1 == null || this.B0.t1() == null || this.B0.t1().c() == null) {
                return true;
            }
            return this.a1.checkPrivacyBeforeInvokeEditor(this.B0.t1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void l6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            if (this.B0.Y0() || this.B0.b1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.B0.N1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.B0.N1()));
            if (W8()) {
                this.a.finish();
            }
        }
    }

    public final void m6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048726, this) == null) {
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
            this.I0.k.g();
        }
    }

    public final boolean q7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) {
            vra c4 = fs9.c(this.B0.t1(), this.B0.M1(), this.B0.E1());
            if (c4 != null && c4.t() != null && c4.t().getGodUserData() != null && c4.t().getGodUserData().getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void v7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048785, this) == null) {
            this.I0.F0();
            if (i0().t1().g == 2) {
                showToast(R.string.hot_sort_jump_hint);
                return;
            }
            if (this.B0.r1() != null) {
                this.I0.I4(this.B0.r1(), this.i2);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
        }
    }

    public final void y7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048794, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.I0.F0();
            U8();
            this.I0.U3();
            this.I0.u4();
            if (this.I0.v1() != null) {
                this.I0.v1().setVisibility(8);
            }
            this.B0.h3(1);
            uy9 uy9Var = this.e;
            if (uy9Var != null) {
                uy9Var.x();
            }
        }
    }

    public final void z7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048798, this) == null) && this.R2 != null) {
            if (this.P2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f1023);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.R2.a(), this.P2, 0)));
                this.a.finish();
            }
        }
    }

    public final void C6(int i4, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048583, this, i4, gVar) != null) || gVar == null) {
            return;
        }
        this.I0.O0(this.E0.getLoadDataMode(), gVar.a, gVar.b, false);
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
                this.B0.t1().O().setIs_good(1);
                this.B0.W2(1);
            } else if (i4 == 3) {
                this.B0.t1().O().setIs_good(0);
                this.B0.W2(0);
            } else if (i4 == 4) {
                this.B0.t1().O().setIs_top(1);
                this.B0.X2(1);
            } else if (i4 == 5) {
                this.B0.t1().O().setIs_top(0);
                this.B0.X2(0);
            }
            this.I0.a5(this.B0.t1(), this.B0.M1());
            if (i4 == 4 || i4 == 5) {
                nq6.b().c(new kh5(gVar.d));
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

    public final void D8(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (W6() != null) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    String questionMsg = postWriteCallBackData.getQuestionMsg();
                    String questionExp = postWriteCallBackData.getQuestionExp();
                    if (postWriteCallBackData.getIconStampData() != null) {
                        qb5.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            kq9.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            kq9.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            kq9.e(getResources().getString(R.string.obfuscated_res_0x7f0f14c1));
                            return;
                        } else {
                            kq9.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.B0.g1()) {
                antiData.setBlock_forum_name(this.B0.t1().k().getName());
                antiData.setBlock_forum_id(this.B0.t1().k().getId());
                antiData.setUser_name(this.B0.t1().V().getUserName());
                antiData.setUser_id(this.B0.t1().V().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void I8(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048604, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            h05 h05Var = this.N0;
            if (h05Var != null && h05Var.isShowing()) {
                this.N0.dismiss();
                this.N0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            j05 j05Var = new j05(getContext());
            j05Var.r(new m0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i4 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i4 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i4 == 1) {
                arrayList.add(new f05(0, getResources().getString(R.string.obfuscated_res_0x7f0f0553), j05Var));
            }
            if (z3) {
                arrayList.add(new f05(1, getResources().getString(R.string.un_mute), j05Var));
            } else {
                arrayList.add(new f05(1, getResources().getString(R.string.obfuscated_res_0x7f0f0d39), j05Var));
            }
            j05Var.m(arrayList);
            h05 h05Var2 = new h05(getPageContext(), j05Var);
            this.N0 = h05Var2;
            h05Var2.l();
        }
    }

    public final void T8(vra vraVar, boolean z3) {
        PbModel pbModel;
        int i4;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048643, this, vraVar, z3) == null) {
            v8(false);
            if (vraVar == null || (pbModel = this.B0) == null || pbModel.t1() == null || vraVar.J() == 1) {
                return;
            }
            String N1 = this.B0.N1();
            String T3 = vraVar.T();
            if (this.B0.t1() != null) {
                i4 = this.B0.t1().W();
            } else {
                i4 = 0;
            }
            AbsPbActivity.e e8 = e8(T3);
            if (e8 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo m02 = vraVar.m0();
            AntiData c4 = this.B0.t1().c();
            if (vraVar.t() != null) {
                arrayList = vraVar.t().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(N1, T3, "pb", true, false, null, false, null, i4, m02, c4, false, arrayList, 5).addBigImageData(e8.a, e8.b, e8.g, e8.j);
            addBigImageData.setKeyPageStartFrom(this.B0.s1());
            addBigImageData.setFromFrsForumId(this.B0.getFromForumId());
            addBigImageData.setWorksInfoData(this.B0.S1());
            addBigImageData.setKeyFromForumId(this.B0.getForumId());
            addBigImageData.setBjhData(this.B0.K0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public void r6(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048766, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(jx9.o2)).intValue();
            if (intValue == jx9.p2) {
                if (this.E0.h0()) {
                    return;
                }
                this.I0.P4();
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
                this.E0.k0(this.B0.t1().k().getId(), this.B0.t1().k().getName(), this.B0.t1().O().getId(), str, intValue3, intValue2, booleanValue, this.B0.t1().O().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == jx9.q2 || intValue == jx9.s2) {
                PbModel pbModel = this.B0;
                if (pbModel != null && pbModel.O0() != null) {
                    this.B0.O0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == jx9.q2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public void v6(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048784, this, i4, i5) == null) {
            TiebaStatic.log("c12181");
            jx9 jx9Var = this.I0;
            if (jx9Var != null && this.B0 != null) {
                if ((jx9Var == null || jx9Var.j2()) && this.B0.t1() != null && this.B0.t1().S() != null) {
                    jx9 jx9Var2 = this.I0;
                    if (jx9Var2 != null && jx9Var2.b1() != null && this.I0.b1().t()) {
                        return;
                    }
                    us9 S = this.B0.t1().S();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!S.d() || S.a() != 2) && this.I0.T0() != null && this.I0.T0().B() != null) {
                        this.I0.T0().B().L(this.B0.N1(), this.B0.getFromForumId());
                    }
                    if (i4 > -1 && i5 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        PbFirstFloorDoubleClickAnimation pbFirstFloorDoubleClickAnimation = new PbFirstFloorDoubleClickAnimation(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.B0;
                        pbFirstFloorDoubleClickAnimation.show(findViewById, i4, i5, pbModel.b, pbModel.getForumId());
                        pbFirstFloorDoubleClickAnimation.setOnPraiseAnimatorListener(new w0(this));
                    } else if (System.currentTimeMillis() - this.v > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.v = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public final void C7(View view2, String str, String str2, vra vraVar) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, str, str2, vraVar) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (f6()) {
                    d1a.N(3, 2);
                    return;
                } else if (!i6()) {
                    d1a.N(8, 2);
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.Y);
                        this.Z = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (W6().x1() != null && vraVar != null) {
                        if (vraVar.e0() != null) {
                            str3 = vraVar.e0().toString();
                        } else {
                            str3 = "";
                        }
                        W6().x1().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), vraVar.t().getName_show(), str3));
                    }
                    if (this.B0.t1() != null && this.B0.t1().j0()) {
                        SafeHandler.getInst().postDelayed(new q1(this, str, str2), 0L);
                        return;
                    } else {
                        SafeHandler.getInst().postDelayed(new r1(this, str, str2), 200L);
                        return;
                    }
                }
            }
            d1a.N(20, 2);
        }
    }

    public final void C8(int i4, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i4, antiData, str) == null) {
            if (AntiHelper.m(i4, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i4, new f2(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i4 == 230277) {
                P8(str);
            } else {
                this.I0.N4(str);
            }
        }
    }

    @Override // com.baidu.tieba.my5
    public void z0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048796, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.P0 = str;
            if (this.k == null) {
                n7();
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

    public final void D6(Rect rect) {
        jx9 jx9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, rect) == null) && rect != null && (jx9Var = this.I0) != null && jx9Var.F1() != null && rect.top <= this.I0.F1().getHeight()) {
            rect.top += this.I0.F1().getHeight() - rect.top;
        }
    }

    public final void P8(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            if (str == null) {
                str = "";
            }
            BdPageContext bdPageContext = this.h1;
            if (bdPageContext == null) {
                return;
            }
            zz4 zz4Var = new zz4(bdPageContext.getPageActivity());
            zz4Var.setMessage(str);
            zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b79, new j(this));
            zz4Var.create(this.h1).show();
        }
    }

    public final void S8(SparseArray<Object> sparseArray) {
        vra vraVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048639, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof vra) || (vraVar = (vra) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        T8(vraVar, false);
    }

    public final void a9(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048676, this, view2) != null) || this.s0) {
            return;
        }
        d1a.I(7, this.B0);
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray != null && (sparseArray.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_is_top_question)).booleanValue()) {
            d1a.v(6);
        }
        this.b = false;
        n6(view2);
    }

    public final void b6(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048678, this, view2) != null) || !(view2.getTag() instanceof ThreadData) || !checkUpIsLogin()) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        LikeModel likeModel = this.Q;
        if (likeModel != null) {
            likeModel.g0(threadData.getForum_name(), String.valueOf(threadData.getFid()));
        }
        d1a.H(threadData, 10, 11);
    }

    public final void b7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 4).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public final void d9(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048689, this, i4) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.B0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(lz9.n(i4))));
        }
    }

    public final void g8(View view2) {
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048702, this, view2) != null) || view2 == null) {
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

    public final void h9(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048709, this, view2) == null) && (view2.getTag() instanceof SmartApp)) {
            SmartApp smartApp = (SmartApp) view2.getTag();
            if (!TbAiappsLaunchUtil.launch(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                if (StringUtils.isNull(smartApp.h5_url)) {
                    return;
                }
                BrowserHelper.startWebActivity(getActivity(), smartApp.h5_url);
            }
            d1a.y(smartApp, this.B0);
        }
    }

    public final void k7(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, bundle) == null) {
            fr4 c4 = fr4.c(this.a);
            this.D0 = c4;
            if (c4 != null) {
                c4.j(this.v2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.E0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.x2);
            getPageContext();
            X6();
            this.R1.setUniqueId(getUniqueId());
            this.R1.registerListener();
            m7();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048756, this, z3) == null) {
            super.onUserChanged(z3);
            this.I0.V4(z3);
            h05 h05Var = this.N0;
            if (h05Var != null) {
                h05Var.dismiss();
            }
            if (z3 && this.R0) {
                this.I0.V3();
                this.B0.q2(true);
            }
            if (this.I0.T0() != null) {
                this.I0.T0().j0(z3);
            }
        }
    }

    public final void D7(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view2) == null) && (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String)) {
            String string = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
            TiebaStatic.log(new StatisticItem("c10912").param("fid", this.B0.t1().l()).param("tid", this.B0.t1().Q()).param("lotterytail", StringUtils.string(string, "_", TbadkCoreApplication.getCurrentAccount())));
            if (this.B0.t1().Q().equals(string)) {
                this.I0.Y3(0);
            } else {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getActivity()).createNormalCfg(string, (String) null, (String) null, (String) null)));
            }
        }
    }

    public final void Y7(View view2) {
        SparseArray sparseArray;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048664, this, view2) == null) && (sparseArray = (SparseArray) view2.getTag()) != null && (sparseArray.get(R.id.tag_load_sub_data) instanceof vra)) {
            vra vraVar = (vra) sparseArray.get(R.id.tag_load_sub_data);
            View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
            if (vraVar != null && view3 != null) {
                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0908a0);
                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f0908a1);
                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090ba7);
                boolean z3 = false;
                if (vraVar.D0()) {
                    vraVar.k1(false);
                    pz9.e(vraVar);
                } else {
                    if (i0() != null) {
                        z3 = pz9.c(i0().t1(), vraVar);
                    }
                    if (z3) {
                        vraVar.k1(true);
                    }
                }
                if (vraVar.D0()) {
                    i4 = R.color.CAM_X0201;
                } else {
                    i4 = R.color.transparent;
                }
                SkinManager.setBackgroundColor(findViewById, i4);
                boolean D0 = vraVar.D0();
                int i7 = R.color.CAM_X0304;
                if (D0) {
                    i5 = R.color.CAM_X0304;
                } else {
                    i5 = R.color.CAM_X0107;
                }
                SkinManager.setViewTextColor(eMTextView, i5);
                if (vraVar.D0()) {
                    i6 = R.drawable.icon_pure_pb_del_select;
                } else {
                    i6 = R.drawable.icon_pure_pb_del_normal;
                }
                if (!vraVar.D0()) {
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
    public final void k6(AgreeData agreeData) {
        lo5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048719, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.e0 == null) {
            this.e0 = new n45();
        }
        if (this.i0 == null) {
            AgreeMessageData agreeMessageData = new AgreeMessageData();
            this.i0 = agreeMessageData;
            agreeMessageData.uniqueId = getUniqueId();
        }
        hw4 hw4Var = new hw4();
        hw4Var.b = 5;
        hw4Var.h = 8;
        hw4Var.g = 2;
        if (i0() != null) {
            hw4Var.f = i0().s1();
        }
        hw4Var.a = 2;
        int i4 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                hw4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.e0.c(agreeData, i4, getUniqueId(), false);
                this.e0.d(agreeData, this.i0);
                pbModel = this.B0;
                if (pbModel == null && pbModel.t1() != null) {
                    this.e0.b(r0(), hw4Var, agreeData, this.B0.t1().O());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            hw4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            hw4Var.i = 1;
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

    public final void n8(View view2) {
        boolean l3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048732, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                view2.setTag(Boolean.FALSE);
                return;
            }
            this.I0.F0();
            if (this.I0.k.i() != null && view2 == this.I0.k.i().D()) {
                this.I0.r3();
            }
            if (this.h) {
                view2.setTag(Boolean.FALSE);
                return;
            }
            U8();
            this.I0.U3();
            if (view2.getId() == R.id.obfuscated_res_0x7f090bab) {
                l3 = this.B0.m3(true, K6());
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f5a) {
                l3 = this.B0.m3(false, K6());
            } else {
                l3 = this.B0.l3(K6());
            }
            view2.setTag(Boolean.valueOf(l3));
            if (l3) {
                this.I0.F3(true);
                this.I0.E4();
                this.h = true;
                this.I0.J3(true);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
        }
    }

    public final void E6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.I0.F0();
            SparseArray<Object> n12 = this.I0.n1(this.B0.t1(), this.B0.M1(), 1);
            if (n12 == null) {
                return;
            }
            sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(getPageContext().getPageActivity(), this.B0.t1().k().getId(), this.B0.t1().k().getName(), this.B0.t1().O().getId(), StringUtils.string(this.B0.t1().V().getUserId()), StringUtils.string(n12.get(R.id.tag_forbid_user_name)), StringUtils.string(n12.get(R.id.tag_forbid_user_name_show)), StringUtils.string(n12.get(R.id.tag_forbid_user_post_id)), StringUtils.string(n12.get(R.id.tag_forbid_user_portrait)))));
        }
    }

    public final String K6() {
        InterceptResult invokeV;
        ArrayList<vra> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel == null || pbModel.t1() == null || this.B0.t1().F() == null || (count = ListUtils.getCount((F = this.B0.t1().F()))) == 0) {
                return "";
            }
            if (this.B0.F1()) {
                Iterator<vra> it = F.iterator();
                while (it.hasNext()) {
                    vra next = it.next();
                    if (next != null && next.J() == 1) {
                        return next.T();
                    }
                }
            }
            int d12 = this.I0.d1();
            vra vraVar = (vra) ListUtils.getItem(F, d12);
            if (vraVar != null && vraVar.t() != null) {
                if (this.B0.n2(vraVar.t().getUserId())) {
                    return vraVar.T();
                }
                for (int i4 = d12 - 1; i4 != 0; i4--) {
                    vra vraVar2 = (vra) ListUtils.getItem(F, i4);
                    if (vraVar2 == null || vraVar2.t() == null || vraVar2.t().getUserId() == null) {
                        break;
                    } else if (this.B0.n2(vraVar2.t().getUserId())) {
                        return vraVar2.T();
                    }
                }
                for (int i5 = d12 + 1; i5 < count; i5++) {
                    vra vraVar3 = (vra) ListUtils.getItem(F, i5);
                    if (vraVar3 == null || vraVar3.t() == null || vraVar3.t().getUserId() == null) {
                        break;
                    } else if (this.B0.n2(vraVar3.t().getUserId())) {
                        return vraVar3.T();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void L7() {
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
            if (this.B0.t1() != null && this.B0.t1().O() != null && this.B0.t1().O().isVideoThreadType() && this.B0.t1().O().getThreadVideoInfo() != null) {
                TiebaStatic.log(new StatisticItem("c11922"));
            }
            if (this.B0.getErrorNo() == 4) {
                if (StringUtils.isNull(this.B0.S0()) && this.B0.I0() != null) {
                    name = this.B0.I0().b;
                } else {
                    this.a.finish();
                    return;
                }
            } else {
                name = this.B0.t1().k().getName();
            }
            if (StringUtils.isNull(name)) {
                this.a.finish();
                return;
            }
            String S0 = this.B0.S0();
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
            if (this.B0.Y0() && S0 != null && S0.equals(name)) {
                this.a.finish();
            } else {
                sendMessage(new CustomMessage(2003000, createNormalCfg));
            }
        }
    }

    public final boolean W8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.t1() != null && this.B0.t1().j0()) {
                return true;
            }
            if (this.B0.e1()) {
                MarkData P0 = this.B0.P0();
                if (P0 == null || !this.B0.c1()) {
                    return true;
                }
                MarkData J0 = this.B0.J0(this.I0.d1());
                if (J0 == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", P0);
                    this.a.setResult(-1, intent);
                    return true;
                } else if (J0.getPostId() != null && !J0.getPostId().equals(P0.getPostId())) {
                    zz4 zz4Var = new zz4(getPageContext().getPageActivity());
                    zz4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f029b));
                    zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04ca, new o2(this, J0, P0, zz4Var));
                    zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d3, new p2(this, P0, zz4Var));
                    zz4Var.setOnCalcelListener(new q2(this, P0, zz4Var));
                    zz4Var.create(getPageContext());
                    zz4Var.show();
                    return false;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", P0);
                    this.a.setResult(-1, intent2);
                    return true;
                }
            }
            if (this.B0.t1() != null && this.B0.t1().F() != null && this.B0.t1().F().size() > 0 && this.B0.c1()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void Z6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            if (this.f) {
                this.O = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.B0.t1() != null && this.B0.t1().O() != null && this.B0.t1().O().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.B0.t1().O().getTaskInfoData().k(), this.B0.t1().O().getTaskInfoData().h(), this.B0.t1().O().getTaskInfoData().c(), this.B0.t1().O().getTaskInfoData().d(), this.B0.t1().O().getIs_top(), this.B0.t1().O().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void Z8() {
        PbModel pbModel;
        String name;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048670, this) == null) && (pbModel = this.B0) != null && pbModel.t1() != null && this.B0.t1().k() != null && !qd.isEmpty(this.B0.t1().k().getName())) {
            if (this.B0.getErrorNo() == 4) {
                if (StringUtils.isNull(this.B0.S0()) && this.B0.I0() != null) {
                    name = this.B0.I0().b;
                } else {
                    this.a.finish();
                    return;
                }
            } else {
                name = this.B0.t1().k().getName();
            }
            if (StringUtils.isNull(name)) {
                this.a.finish();
                return;
            }
            String S0 = this.B0.S0();
            if (this.B0.Y0() && S0 != null && S0.equals(name)) {
                this.a.finish();
            } else {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(this.B0.t1().k().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            }
            d1a.A(this.B0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048751, this) == null) {
            this.f = false;
            super.onResume();
            if (this.O) {
                this.O = false;
                Z6();
            }
            if (q7()) {
                this.t = System.currentTimeMillis();
            } else {
                this.t = -1L;
            }
            jx9 jx9Var = this.I0;
            if (jx9Var != null && jx9Var.G1() != null) {
                if (!this.g) {
                    J8();
                } else {
                    hideLoadingView(this.I0.G1());
                }
                this.I0.Q2();
            }
            if (this.j == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            jx9 jx9Var2 = this.I0;
            if (jx9Var2 != null) {
                noNetworkView = jx9Var2.a();
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
            s8();
            registerListener(this.Z1);
            registerListener(this.a2);
            registerListener(this.c2);
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.q1) {
                k8();
                this.q1 = false;
            }
            R8();
            ItemCardHelper.w(this.J2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                kd5.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048754, this) == null) {
            super.onStop();
            if (this.t > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.t;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.t = 0L;
            }
            if (W6().x1() != null) {
                W6().x1().n();
            }
            d0a d0aVar = this.I0.k;
            if (d0aVar != null && !d0aVar.n()) {
                this.I0.k.r();
            }
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.t1() != null && this.B0.t1().k() != null && this.B0.t1().O() != null) {
                hd5.j().x(getPageContext().getPageActivity(), "pb", this.B0.t1().k().getId(), JavaTypesHelper.toLong(this.B0.t1().O().getId(), 0L));
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            xpa.g().h(getUniqueId(), false);
        }
    }

    public final void q6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048762, this) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.t1() != null) {
                ura z3 = this.B0.t1().z();
                if (z3 != null) {
                    if (z3.getAdvertAppInfo() != null) {
                        z3.getAdvertAppInfo().h = null;
                    }
                    this.B0.t1().b();
                }
                if (this.B0.L0() != null) {
                    this.B0.y0();
                }
                this.B0.Y1();
            }
            if (this.B0.t1().F() != null) {
                Iterator<vra> it = this.B0.t1().F().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof ura) {
                        it.remove();
                    }
                }
            }
            if (this.I0.T0() != null && !ListUtils.isEmpty(this.I0.T0().v())) {
                ix9.e(this.I0.T0().v());
            }
            if (this.I0.m1() != null && !ListUtils.isEmpty(this.I0.m1().getData())) {
                ix9.e(this.I0.m1().getData());
            }
            if (this.I0.T0() != null) {
                this.I0.T0().f0();
            }
        }
    }

    public final void E8(SparseArray<Object> sparseArray, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{sparseArray, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            lz9.e(getActivity(), getPageContext(), new m1(this, sparseArray, i4, z3), new n1(this));
        }
    }

    public final void F7(View view2) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.B0.t1() == null || this.E0.h0()) {
            } else {
                this.I0.F0();
                if (this.I0.k.i() != null && view2 == this.I0.k.i().H()) {
                    if (this.B0.t1().O().getIs_top() == 1) {
                        i4 = 5;
                    } else {
                        i4 = 4;
                    }
                } else if (this.I0.k.i() != null && view2 == this.I0.k.i().G()) {
                    if (this.B0.t1().O().getIs_good() == 1) {
                        i4 = 3;
                    } else {
                        i4 = 6;
                    }
                } else if (view2 == this.I0.X0()) {
                    i4 = 2;
                } else {
                    i4 = 0;
                }
                ForumData k3 = this.B0.t1().k();
                String name = k3.getName();
                String id = k3.getId();
                String id2 = this.B0.t1().O().getId();
                this.I0.P4();
                this.E0.l0(id, name, id2, i4, this.I0.Y0());
            }
        }
    }

    public final boolean N7(vra vraVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, vraVar)) == null) {
            if (vraVar == null) {
                return false;
            }
            String T3 = vraVar.T();
            if (StringUtils.isNull(T3) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String string = SharedPrefHelper.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = vraVar.o0().getJumpUrl();
            int packageId = vraVar.o0().getPackageId();
            int propsId = vraVar.o0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                BrowserHelper.startWebActivity(getPageContext().getPageActivity(), bta.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
                return true;
            } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            } else {
                BrowserHelper.startWebActivity(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + T3, true, true, true);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void e6(boolean z3) {
        jx9 jx9Var;
        int i4;
        int y3;
        vra vraVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048691, this, z3) == null) && (jx9Var = this.I0) != null && jx9Var.m1() != null) {
            int firstVisiblePosition = this.I0.m1().getFirstVisiblePosition();
            int lastVisiblePosition = this.I0.m1().getLastVisiblePosition();
            rv9 T0 = this.I0.T0();
            if (T0 != null && this.B0.t1() != null) {
                if (lastVisiblePosition <= T0.y()) {
                    i4 = 0;
                    y3 = 1;
                } else {
                    if (firstVisiblePosition > T0.y()) {
                        i4 = firstVisiblePosition - T0.y();
                    } else {
                        i4 = 0;
                    }
                    y3 = (lastVisiblePosition - T0.y()) + 1;
                }
                ArrayList arrayList = new ArrayList();
                if (y3 > i4) {
                    while (i4 < y3) {
                        if (this.I0.m1().G(i4) != null && (this.I0.m1().G(i4) instanceof vra) && (vraVar = (vra) this.I0.m1().G(i4)) != null) {
                            vra vraVar2 = (vra) ListUtils.getItem(this.B0.t1().F(), vraVar.J() - 1);
                            if (vraVar.o() == null && vraVar2 != null) {
                                vraVar.P0(vraVar2.o());
                            }
                            if (vraVar.o() != null) {
                                vraVar.o().setFloonumber(vraVar.J());
                                arrayList.add(vraVar.o());
                            }
                        }
                        i4++;
                    }
                }
                if (ListUtils.getItem(arrayList, 0) != null) {
                    Collections.sort(arrayList, new e2(this));
                    AdverSegmentData adverSegmentData = (AdverSegmentData) ListUtils.getItem(arrayList, 0);
                    if (adverSegmentData != null && adverSegmentData.getFloonumber() == 1) {
                        if (!z3) {
                            this.I0.d3(adverSegmentData, 0);
                            return;
                        }
                        return;
                    }
                    this.I0.d3(adverSegmentData, 1);
                }
            }
        }
    }

    public final AbsPbActivity.e e8(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048693, this, str)) == null) {
            String str2 = null;
            if (this.B0.t1() != null && this.B0.t1().F() != null && this.B0.t1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i4 = 0;
                while (true) {
                    if (i4 < this.B0.t1().F().size()) {
                        if (str.equals(this.B0.t1().F().get(i4).T())) {
                            break;
                        }
                        i4++;
                    } else {
                        i4 = 0;
                        break;
                    }
                }
                vra vraVar = this.B0.t1().F().get(i4);
                if (vraVar.e0() != null && vraVar.e0().Q() != null) {
                    Iterator<TbRichTextData> it = vraVar.e0().Q().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.W() != null) {
                                str2 = next.W().Q();
                            }
                        }
                    }
                    yw9.e(this.B0, str2, 0, eVar);
                    fs9.b(vraVar, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void g9(int i4) {
        PbModel pbModel;
        ThreadData O;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048703, this, i4) != null) || (pbModel = this.B0) == null || pbModel.t1() == null || (O = this.B0.t1().O()) == null) {
            return;
        }
        if (i4 == 1) {
            PraiseData praise = O.getPraise();
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
                    O.setPraise(praiseData);
                } else {
                    O.getPraise().getUser().add(0, metaData);
                    O.getPraise().setNum(O.getPraise().getNum() + 1);
                    O.getPraise().setIsLike(i4);
                }
            }
        } else if (O.getPraise() != null) {
            O.getPraise().setIsLike(i4);
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
        if (this.B0.M1()) {
            this.I0.T0().f0();
        } else {
            this.I0.d5(this.B0.t1());
        }
    }

    public void j8(vs9 vs9Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048717, this, vs9Var) != null) || vs9Var.g() == null) {
            return;
        }
        String T3 = vs9Var.g().T();
        ArrayList<vra> F = this.B0.t1().F();
        int i4 = 0;
        while (true) {
            z3 = true;
            if (i4 >= F.size()) {
                break;
            }
            vra vraVar = F.get(i4);
            if (vraVar.T() != null && vraVar.T().equals(T3)) {
                ArrayList<vra> i5 = vs9Var.i();
                vraVar.s1(vs9Var.k());
                if (vraVar.j0() != null && i5 != null) {
                    Iterator<vra> it = i5.iterator();
                    while (it.hasNext()) {
                        vra next = it.next();
                        if (vraVar.s0() != null && next != null && next.t() != null && (metaData = vraVar.s0().get(next.t().getUserId())) != null) {
                            next.Q0(metaData);
                            next.h1(true);
                            next.C1(getPageContext(), this.B0.n2(metaData.getUserId()));
                        }
                    }
                    if (i5.size() == vraVar.j0().size()) {
                        z3 = false;
                    }
                    if (!vraVar.z0(false)) {
                        vraVar.j0().clear();
                        vraVar.j0().addAll(i5);
                    }
                }
                if (vraVar.D() != null) {
                    vraVar.O0();
                }
            } else {
                i4++;
            }
        }
        if (!this.B0.c1() && z3) {
            this.I0.h2(this.B0.t1());
        }
        if (z3) {
            h8(vs9Var);
        }
    }

    public final void m8(View view2) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048728, this, view2) == null) {
            this.I0.F0();
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.h) {
                view2.setTag(Integer.valueOf(this.B0.K1()));
            } else {
                U8();
                this.I0.U3();
                h05 h05Var = new h05(getPageContext());
                if (this.B0.t1().f == null || this.B0.t1().f.size() <= 0) {
                    strArr = new String[]{getResources().getString(R.string.sort_type_new), getResources().getString(R.string.sort_type_old)};
                } else {
                    strArr = new String[this.B0.t1().f.size()];
                    for (int i4 = 0; i4 < this.B0.t1().f.size(); i4++) {
                        strArr[i4] = this.B0.t1().f.get(i4).sort_name + getResources().getString(R.string.sort_static);
                    }
                }
                h05Var.i(null, strArr, new s1(this, h05Var, view2));
                h05Var.l();
            }
        }
    }

    public final boolean q8(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048764, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof vra)) {
                return false;
            }
            vra vraVar = (vra) obj;
            if (vraVar.getType() != vra.a1 && !TextUtils.isEmpty(vraVar.v()) && lv4.c().g()) {
                return N7(vraVar);
            }
            if (!checkUpIsLogin()) {
                d1a.N(2, 2);
                return true;
            }
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.t1() != null) {
                if (W6().x1() != null) {
                    W6().x1().g();
                }
                vs9 vs9Var = new vs9();
                vs9Var.v(this.B0.t1().k());
                vs9Var.z(this.B0.t1().O());
                vs9Var.x(vraVar);
                W6().w1().k0(vs9Var);
                W6().w1().setPostId(vraVar.T());
                C7(view2, vraVar.t().getUserId(), "", vraVar);
                TiebaStatic.log("c11743");
                vg5 vg5Var = this.Y0;
                if (vg5Var != null) {
                    this.I0.z3(vg5Var.C());
                }
                return true;
            }
            d1a.N(20, 2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void x6(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048790, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.I0.F0();
            if (view2.getId() == R.id.obfuscated_res_0x7f091b2b && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                this.U = view2;
            } else if (!ix9.d(getPageContext(), 11009) || this.B0.J0(this.I0.l1()) == null) {
            } else {
                H7();
                if (this.B0.t1() != null && this.B0.t1().O() != null && this.B0.t1().O().getAuthor() != null) {
                    d1a.x(3, this.B0);
                }
                if (this.B0.t1().O() != null && this.B0.t1().O().getAuthor() != null && this.B0.t1().O().getAuthor().getUserId() != null && this.D0 != null) {
                    d1a.E(1, ix9.w(this.B0.t1()), !this.D0.e(), this.B0);
                }
            }
        }
    }

    public final int G6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.B0.t1() != null && this.B0.t1().O() != null) {
                return this.B0.t1().O().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final boolean G8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel == null || !pbModel.M1()) {
                return false;
            }
            if (this.B0.r1() != null && this.B0.r1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void K8() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && f0a.b() && !this.I0.c3()) {
            nb5 showPushOpenView = PushOpenUtil.showPushOpenView(getPageContext(), "reply_pb", 0L);
            this.j0 = showPushOpenView;
            if (showPushOpenView != null) {
                hba.e().h("reply_pb");
            }
        }
    }

    public final void L8() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && f0a.a() && !this.I0.c3()) {
            nb5 showPushOpenView = PushOpenUtil.showPushOpenView(getPageContext(), "collect", 0L);
            this.j0 = showPushOpenView;
            if (showPushOpenView != null) {
                hba.e().h("collect");
            }
        }
    }

    public void P7() {
        List<g3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (list = this.t1) != null && !list.isEmpty()) {
            int size = this.t1.size();
            while (true) {
                size--;
                if (size <= -1 || this.t1.get(size).onBackPressed()) {
                    return;
                }
            }
        }
    }

    public final void Q7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.I0.F0();
            if (this.h) {
                return;
            }
            U8();
            this.I0.U3();
            if (this.B0.loadData()) {
                this.I0.E4();
            }
        }
    }

    public final void R8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && (pbModel = this.B0) != null && !qd.isEmpty(pbModel.N1())) {
            lo4.w().Q(ko4.Z, JavaTypesHelper.toLong(this.B0.N1(), 0L));
        }
    }

    public final void g7() {
        TiebaPlusConfigData tiebaPlusConfigData;
        String jumpUrlWithTid;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048701, this) == null) && (tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData()) != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.B0.N1())) != null) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{jumpUrlWithTid});
            this.I0.k.f();
            TiebaPlusConfigData.addClickStatsForFireLink(3);
        }
    }

    public final boolean h6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.t1() != null && this.B0.t1().g() != null && !TextUtils.isEmpty(this.B0.t1().g().l)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048707, this) == null) && this.a != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.a.getCurrentFocus() != null) {
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final void r8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048768, this) == null) && (pbModel = this.B0) != null && pbModel.t1() != null && this.B0.t1().O() != null && this.B0.t1().O().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void s8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048772, this) == null) && (pbModel = this.B0) != null && pbModel.t1() != null && this.B0.t1().O() != null && this.B0.t1().O().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public final void H7() {
        MarkData J0;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.D0 != null) {
            if (this.B0.t1() != null && this.B0.t1().j0()) {
                J0 = this.B0.J0(0);
            } else {
                J0 = this.B0.J0(this.I0.l1());
            }
            if (J0 == null) {
                return;
            }
            if (J0.isApp() && (J0 = this.B0.J0(this.I0.l1() + 1)) == null) {
                return;
            }
            this.I0.U3();
            this.D0.i(J0);
            if (!this.D0.e()) {
                if (this.I0 != null && (pbModel = this.B0) != null && !sz9.g(pbModel.b)) {
                    this.I0.H4();
                    sz9.a(this.B0.b);
                }
                this.D0.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.D0.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final void W5() {
        PbModel pbModel;
        es9 es9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048652, this) == null) && (pbModel = this.B0) != null && (es9Var = pbModel.G) != null && es9Var.O() != null) {
            ThreadData O = this.B0.G.O();
            O.mRecomAbTag = this.B0.z1();
            O.mRecomWeight = this.B0.C1();
            O.mRecomSource = this.B0.B1();
            O.mRecomExtra = this.B0.A1();
            O.isSubPb = this.B0.g1();
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(this.B0.getForumId(), 0L));
            }
            StatisticItem i4 = qo5.i(getContext(), O, "c13562");
            TbPageTag l3 = qo5.l(getContext());
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

    public final void a6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            SparseArray<Object> n12 = this.I0.n1(this.B0.t1(), this.B0.M1(), 1);
            if (n12 != null) {
                this.I0.Y2(((Integer) n12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(n12.get(R.id.tag_del_post_id)), ((Integer) n12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n12.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            this.I0.k.f();
            if (i0() != null && i0().t1() != null && i0().t1().O() != null) {
                d1a.G(i0().t1().O());
            }
        }
    }

    public final void d6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            this.I0.k.g();
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                this.v1.f(pbModel.N1());
            }
            int i4 = 1;
            PbModel pbModel2 = this.B0;
            if (pbModel2 != null && pbModel2.isPrivacy()) {
                showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (i0() != null && i0().t1() != null) {
                    this.v1.d(3, 3, i0().t1().Q());
                    return;
                }
                return;
            }
            this.v1.b();
            if (!TbSingleton.getInstance().mCanCallFans && i0() != null && i0().t1() != null && i0().t1().Q() != null && i0().t1().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
                i4 = 2;
            }
            if (i0() != null && i0().t1() != null) {
                this.v1.d(3, i4, i0().t1().Q());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048749, this) == null) {
            this.f = true;
            super.onPause();
            pz9.a();
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
            jx9 jx9Var = this.I0;
            if (jx9Var != null) {
                jx9Var.M2();
            }
            if (this.Y0 != null && !this.B0.g1()) {
                this.Y0.R(this.B0.N1());
            }
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                pbModel.w2();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            lo4.w().E();
            MessageManager.getInstance().unRegisterListener(this.E1);
            r8();
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            nb5 nb5Var = this.j0;
            if (nb5Var != null) {
                nb5Var.q();
                this.j0.p();
            }
        }
    }

    public final void t7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048776, this) == null) && this.B0.t1() != null && this.B0.t1().O() != null && this.B0.t1().O().getActUrl() != null) {
            BrowserHelper.startWebActivity(getActivity(), this.B0.t1().O().getActUrl());
            if (this.B0.t1().O().getActInfoType() == 1) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
            } else if (this.B0.t1().O().getActInfoType() == 2) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
            }
        }
    }

    public final void u6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048781, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            SparseArray<Object> n12 = this.I0.n1(this.B0.t1(), this.B0.M1(), 1);
            if (n12 != null) {
                if (StringUtils.isNull((String) n12.get(R.id.tag_del_multi_forum))) {
                    this.I0.V2(((Integer) n12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(n12.get(R.id.tag_del_post_id)), ((Integer) n12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n12.get(R.id.tag_del_post_is_self)).booleanValue());
                } else {
                    this.I0.W2(((Integer) n12.get(R.id.tag_del_post_type)).intValue(), (String) n12.get(R.id.tag_del_post_id), ((Integer) n12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n12.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(n12.get(R.id.tag_del_multi_forum)));
                }
            }
            this.I0.k.f();
        }
    }

    public void J7(vra vraVar) {
        boolean z3;
        vra H6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, vraVar) != null) || vraVar == null) {
            return;
        }
        if (vraVar.T() != null && vraVar.T().equals(this.B0.o1())) {
            z3 = true;
        } else {
            z3 = false;
        }
        MarkData n12 = this.B0.n1(vraVar);
        if (this.B0.t1() != null && this.B0.t1().j0() && (H6 = H6()) != null) {
            n12 = this.B0.n1(H6);
        }
        if (n12 == null) {
            return;
        }
        this.I0.U3();
        fr4 fr4Var = this.D0;
        if (fr4Var != null) {
            fr4Var.i(n12);
            if (!z3) {
                this.D0.a();
            } else {
                this.D0.d();
            }
        }
    }

    public final void N8(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && i0() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                i0().B0(postWriteCallBackData.getPostId());
                int Z0 = this.I0.Z0();
                this.r1 = Z0;
                this.B0.S2(Z0, this.I0.g1());
            }
            this.I0.F0();
            this.M0.c();
            vg5 vg5Var = this.Y0;
            if (vg5Var != null) {
                this.I0.z3(vg5Var.C());
            }
            this.I0.L1();
            this.I0.m4(true);
            this.B0.Y1();
        }
    }

    public final void X8(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048660, this, view2) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
            String string2 = SharedPrefHelper.getInstance().getString("tail_link", "");
            String string3 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
            if (!StringUtils.isNull(string2)) {
                TiebaStatic.log("c10056");
                Context context = view2.getContext();
                BrowserHelper.startWebActivity(context, string, UtilHelper.urlAddParam(string2, "page_from=1&tailSkinId=" + string3), true, true, true);
            }
            this.I0.r3();
            TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string3));
        }
    }

    public void d8(@Nullable SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, spriteMemeInfo) == null) {
            if (!checkUpIsLogin()) {
                d1a.N(2, 1);
                return;
            }
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.t1() != null && this.B0.t1().k() != null) {
                if (f6()) {
                    d1a.N(3, 1);
                    return;
                } else if (this.B0.t1().j0()) {
                    d1a.N(7, 1);
                    this.I0.w0(spriteMemeInfo);
                    return;
                } else {
                    vg5 vg5Var = this.Y0;
                    if (vg5Var != null && vg5Var.a() != null) {
                        this.Y0.a().K(new yd5(45, 27, null));
                    }
                    this.I0.w0(spriteMemeInfo);
                    return;
                }
            }
            d1a.N(20, 1);
        }
    }

    public final void e7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, str) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.t1() != null && this.B0.t1().j0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.B0.N1(), str);
                ThreadData O = this.B0.t1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                x7(format);
                return;
            }
            this.C0.a(str);
        }
    }

    public void h8(vs9 vs9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, vs9Var) == null) {
            String T3 = vs9Var.g().T();
            List<vra> list = this.B0.t1().T().a;
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                vra vraVar = list.get(i4);
                if (vraVar.T() != null && vraVar.T().equals(T3)) {
                    ArrayList<vra> i5 = vs9Var.i();
                    vraVar.s1(vs9Var.k());
                    if (vraVar.j0() != null) {
                        vraVar.j0().clear();
                        vraVar.j0().addAll(i5);
                    }
                } else {
                    i4++;
                }
            }
            if (!this.B0.c1()) {
                this.I0.h2(this.B0.t1());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        es9 t12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048736, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (W6() != null && ix9.E(this)) {
                W6().O4();
            }
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907db));
            PbModel pbModel = this.B0;
            if (pbModel != null && (t12 = pbModel.t1()) != null) {
                this.s2.c(true, 0, 3, 0, t12, "", 1, true);
            }
            this.a.K1().k(this.t0);
            PbModel pbModel2 = this.B0;
            if (pbModel2 != null) {
                this.G.b(pbModel2.G, getContext(), this.a.findViewById(this.I0.U0()), this.B0.getForumId(), this.B0.N1());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048739, this, i4) != null) || this.W == i4) {
            return;
        }
        super.onChangeSkinType(i4);
        this.I0.F2(i4);
        vg5 vg5Var = this.Y0;
        if (vg5Var != null && vg5Var.a() != null) {
            this.Y0.a().F(i4);
        }
        if (this.I0.a() != null) {
            this.I0.a().onChangeSkinType(getPageContext(), i4);
        }
        this.M0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i4, getResources(), R.color.CAM_X0201), true);
        this.W = i4;
        U8();
        nb5 nb5Var = this.j0;
        if (nb5Var != null) {
            nb5Var.w();
        }
    }

    public final void p6(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048758, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.B0) != null && pbModel.t1() != null) {
            ura z3 = this.B0.t1().z();
            if (z3 != null && str.equals(z3.G1())) {
                if (z3.getAdvertAppInfo() != null) {
                    z3.getAdvertAppInfo().h = null;
                }
                this.B0.t1().b();
            }
            ura L0 = this.B0.L0();
            if (L0 != null && str.equals(L0.G1())) {
                this.B0.y0();
            }
        }
    }

    public final void y6(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048793, this, view2) != null) || !(view2.getTag() instanceof ThreadData)) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        if (this.B0.s1() == 3 && Y0() && this.B0.t1() != null && ListUtils.isEmpty(this.B0.t1().o())) {
            this.a.finish();
        } else {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
        d1a.z(threadData);
    }

    public final void M7() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048619, this) != null) || bt5.a()) {
            return;
        }
        PbModel pbModel = this.B0;
        if (pbModel != null && pbModel.t1() != null) {
            ArrayList<vra> F = this.B0.t1().F();
            if ((F == null || F.size() <= 0) && this.B0.M1()) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1025));
                return;
            }
            d1a.F(this.B0);
            this.I0.r3();
            R7();
            return;
        }
        BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1025));
    }

    public final void b8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            if (this.I0.j1().getIndicateStatus()) {
                es9 t12 = this.B0.t1();
                if (t12 != null && t12.O() != null && t12.O().getTaskInfoData() != null) {
                    String e4 = t12.O().getTaskInfoData().e();
                    if (StringUtils.isNull(e4)) {
                        e4 = t12.O().getTaskInfoData().h();
                    }
                    TiebaStatic.log(new StatisticItem("c11107").param("obj_id", e4));
                }
            } else {
                bsa.d("c10725", null);
            }
            Z6();
        }
    }

    public final void j7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048716, this) == null) && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            long j3 = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
            sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(getPageContext().getPageActivity(), 24008, JavaTypesHelper.toLong(this.B0.t1().l(), 0L), JavaTypesHelper.toLong(this.B0.N1(), 0L), j3, this.B0.t1().O().getPushStatusData())));
        }
    }

    public final void n7() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048731, this) != null) || this.k != null) {
            return;
        }
        this.k = new a05(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        a05 a05Var = this.k;
        a05Var.j(strArr, new y0(this));
        a05Var.g(a05.b.a);
        a05Var.h(17);
        a05Var.c(getPageContext());
    }

    public final void Q8(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.I0.u4();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            zz4 zz4Var = new zz4(this.h1.getPageActivity());
            if (!qd.isEmpty(str)) {
                zz4Var.setMessage(str);
            } else {
                zz4Var.setMessage(this.h1.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04ca, new l(this, userMuteAddAndDelCustomMessage));
            zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d3, new m(this));
            zz4Var.create(this.h1).show();
        }
    }

    public void R7() {
        PbModel pbModel;
        es9 t12;
        ThreadData O;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        es9 es9Var;
        boolean z8;
        boolean z9;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && (pbModel = this.B0) != null && pbModel.t1() != null && (O = (t12 = this.B0.t1()).O()) != null && O.getAuthor() != null) {
            this.I0.L1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
            sw9 sw9Var = new sw9();
            int W = this.B0.t1().W();
            if (W != 1 && W != 3) {
                sw9Var.g = false;
            } else {
                sw9Var.g = true;
                if (O.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                sw9Var.s = z3;
            }
            if (ix9.A(this.B0.t1(), W)) {
                sw9Var.h = true;
                if (O.getIs_good() == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                sw9Var.r = z9;
            } else {
                sw9Var.h = false;
            }
            if (W == 1002 && !equals) {
                sw9Var.u = true;
            }
            sw9Var.n = ix9.M(O.isBlocked(), t12.n0(), equals, W, O.isWorksInfo(), O.isScoreThread());
            sw9Var.e = ix9.K(t12, equals, t12.n0(), this.B0.W());
            sw9Var.i = G8();
            sw9Var.f = ix9.L(this.B0.t1(), equals, this.B0.W());
            if (equals && t12.V() != null && t12.V().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            sw9Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                sw9Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            sw9Var.t = equals;
            sw9Var.q = this.B0.M1();
            sw9Var.b = true;
            sw9Var.a = ix9.D(this.B0.t1(), equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            sw9Var.p = z5;
            sw9Var.j = true;
            sw9Var.o = this.B0.W0();
            sw9Var.d = true;
            if (O.getThreadVideoInfo() == null) {
                z6 = true;
            } else {
                z6 = false;
            }
            sw9Var.c = z6;
            if (t12.j0()) {
                sw9Var.b = false;
                sw9Var.d = false;
                sw9Var.c = false;
                sw9Var.g = false;
                sw9Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !t12.j0()) {
                z7 = true;
            } else {
                z7 = false;
            }
            sw9Var.v = z7;
            if (this.I0 != null && (es9Var = this.B0.G) != null) {
                vra X = es9Var.X();
                if (X != null) {
                    z8 = X.f1175T;
                } else {
                    z8 = false;
                }
                sw9Var.w = z8;
            }
            sw9Var.m = true;
            if (O.isBlocked()) {
                sw9Var.n = false;
                sw9Var.g = false;
                sw9Var.h = false;
            }
            this.I0.k.x(sw9Var);
        }
    }

    public final void T7(View view2) {
        es9 t12;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, view2) == null) {
            if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (t12 = this.B0.t1()) == null) {
                return;
            }
            ThreadData O = t12.O();
            if (O != null && O.getAuthor() != null) {
                d1a.x(4, this.B0);
            }
            PbModel pbModel = this.B0;
            AbsPbActivity r02 = r0();
            jx9 jx9Var = this.I0;
            int i5 = 6;
            if (view2.getId() == R.id.share_num_container) {
                i4 = 5;
            } else {
                i4 = 6;
            }
            d1a.O(pbModel, r02, jx9Var, i4);
            if (!BdUtilHelper.isNetOk()) {
                showToast(R.string.obfuscated_res_0x7f0f0e61);
            } else if (t12 == null) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1025));
            } else {
                ArrayList<vra> F = this.B0.t1().F();
                if ((F == null || F.size() <= 0) && this.B0.M1()) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1025));
                    return;
                }
                this.I0.F0();
                U8();
                if (t12.A() != null && !StringUtils.isNull(t12.A().a(), true)) {
                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.B0.t1().l()));
                }
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), O)) {
                    return;
                }
                jx9 jx9Var2 = this.I0;
                if (jx9Var2 != null) {
                    jx9Var2.H0();
                    this.I0.Z4(t12);
                }
                if (ShareSwitch.isOn()) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091b30) {
                        i5 = 2;
                    } else if (view2.getId() == R.id.share_num_container) {
                        i5 = 1;
                    }
                    if (this.I0.x2() && !t12.p0()) {
                        O8(i5);
                        return;
                    } else {
                        O8(i5);
                        return;
                    }
                }
                this.I0.u4();
                this.B0.N0().Q(CheckRealNameModel.TYPE_PB_SHARE, 6);
            }
        }
    }

    public final void U7(View view2) {
        SparseArray<Object> sparseArray;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, view2) == null) {
            String str = null;
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            vra vraVar = (vra) sparseArray.get(R.id.tag_clip_board);
            if (vraVar == null) {
                return;
            }
            if (this.O0 == null) {
                j05 j05Var = new j05(getContext());
                this.O0 = j05Var;
                j05Var.r(this.k2);
            }
            ArrayList arrayList = new ArrayList();
            if (i0().t1() != null && i0().t1().j0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (view2 != null && sparseArray != null) {
                if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    z4 = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                } else {
                    z4 = false;
                }
                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z5 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                } else {
                    z5 = false;
                }
                if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                    z6 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                } else {
                    z6 = false;
                }
                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z7 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                } else {
                    z7 = false;
                }
                if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                    z8 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                } else {
                    z8 = false;
                }
                if (sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String) {
                    str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                }
                String str2 = str;
                if (sparseArray.get(R.id.tag_is_self_post) instanceof Boolean) {
                    z9 = ((Boolean) sparseArray.get(R.id.tag_is_self_post)).booleanValue();
                } else {
                    z9 = false;
                }
                if (vraVar.p() != null) {
                    boolean z10 = vraVar.p().hasAgree;
                    int q3 = vraVar.q();
                    if (z10 && q3 == 5) {
                        string = getString(R.string.action_cancel_dislike);
                    } else {
                        string = getString(R.string.action_dislike);
                    }
                    f05 f05Var = new f05(8, string, this.O0);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, vraVar);
                    f05Var.d.setTag(sparseArray2);
                    arrayList.add(f05Var);
                }
                if (this.mIsLogin) {
                    Z5(z6, z5, sparseArray, arrayList, z4, z3, str2);
                    X5(sparseArray, arrayList, z4, z6, z7, z8, z9, str2);
                }
                this.O0.m(arrayList);
                h05 h05Var = new h05(getPageContext(), this.O0);
                this.N0 = h05Var;
                h05Var.l();
            }
        }
    }

    public final void V7(View view2) {
        StatisticItem statisticItem;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048650, this, view2) != null) || this.B0 == null) {
            return;
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f091bac) {
            d1a.I(6, this.B0);
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f091d78) {
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                this.f1142T = view2;
                return;
            }
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091bac && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
            this.f1142T = view2;
            return;
        }
        if (!checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof vra)) {
            return;
        }
        vra vraVar = (vra) sparseArray.get(R.id.tag_load_sub_data);
        if (view2.getId() == R.id.obfuscated_res_0x7f091bac && (statisticItem = vraVar.h0) != null) {
            StatisticItem copy = statisticItem.copy();
            copy.delete("obj_locate");
            copy.param("obj_locate", 8);
            TiebaStatic.log(copy);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091d78 || view2.getId() == R.id.obfuscated_res_0x7f091b3d) {
            d1a.B(this.B0, vraVar);
        }
        PbModel pbModel = this.B0;
        if (pbModel != null && pbModel.t1() != null && W6().w1() != null && vraVar.t() != null && vraVar.J() != 1) {
            if (W6().x1() != null) {
                W6().x1().g();
            }
            vs9 vs9Var = new vs9();
            vs9Var.v(this.B0.t1().k());
            vs9Var.z(this.B0.t1().O());
            vs9Var.x(vraVar);
            W6().w1().k0(vs9Var);
            W6().w1().setPostId(vraVar.T());
            C7(view2, vraVar.t().getUserId(), "", vraVar);
            vg5 vg5Var = this.Y0;
            if (vg5Var != null) {
                this.I0.z3(vg5Var.C());
            }
        }
    }

    public final void o8(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048735, this, view2) != null) || this.s0) {
            return;
        }
        d1a.I(1, this.B0);
        SparseArray sparseArray = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
        if (sparseArray != null && (sparseArray.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_is_top_question)).booleanValue()) {
            d1a.v(2);
        }
        d1a.N(1, 2);
        if (this.u) {
            this.u = false;
            d1a.N(20, 2);
            return;
        }
        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
        if (!(tbRichTextView.getTag() instanceof SparseArray)) {
            d1a.N(20, 2);
            return;
        }
        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
        if (!(obj instanceof vra)) {
            d1a.N(20, 2);
            return;
        }
        vra vraVar = (vra) obj;
        PbModel pbModel = this.B0;
        if (pbModel != null && pbModel.t1() != null && W6().w1() != null && vraVar.t() != null && vraVar.J() != 1) {
            if (!checkUpIsLogin()) {
                d1a.N(2, 2);
                return;
            } else if (vraVar.B0()) {
                return;
            } else {
                if (W6().x1() != null) {
                    W6().x1().g();
                }
                vs9 vs9Var = new vs9();
                vs9Var.v(this.B0.t1().k());
                vs9Var.z(this.B0.t1().O());
                vs9Var.x(vraVar);
                W6().w1().k0(vs9Var);
                W6().w1().setPostId(vraVar.T());
                C7(view2, vraVar.t().getUserId(), "", vraVar);
                TiebaStatic.log("c11743");
                d1a.b(this.B0.t1(), vraVar, vraVar.g0, 8, 1);
                vg5 vg5Var = this.Y0;
                if (vg5Var != null) {
                    this.I0.z3(vg5Var.C());
                    return;
                }
                return;
            }
        }
        d1a.N(20, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void W7(View view2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        f05 f05Var;
        boolean z11;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048654, this, view2) != null) || !checkUpIsLogin()) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c11740"));
        if (view2 != null && view2.getTag() != null) {
            SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
            vra vraVar = (vra) sparseArray.get(R.id.tag_load_sub_data);
            if (view2.getId() != R.id.replybtn_top_right && view2.getId() != R.id.cover_reply_content_top_right) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                TiebaStatic.log(new StatisticItem("c12006").param("tid", this.B0.b));
            }
            if (this.O0 == null) {
                j05 j05Var = new j05(getContext());
                this.O0 = j05Var;
                j05Var.r(this.k2);
            }
            ArrayList arrayList = new ArrayList();
            String str = null;
            if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                z4 = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
            } else {
                z4 = false;
            }
            if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                z5 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
            } else {
                z5 = false;
            }
            if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                z6 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
            } else {
                z6 = false;
            }
            if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                z7 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
            } else {
                z7 = false;
            }
            if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                z8 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
            } else {
                z8 = false;
            }
            if (sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String) {
                str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
            }
            String str2 = str;
            if (sparseArray.get(R.id.tag_is_self_post) instanceof Boolean) {
                z9 = ((Boolean) sparseArray.get(R.id.tag_is_self_post)).booleanValue();
            } else {
                z9 = false;
            }
            if (vraVar != null) {
                if (vraVar.e0() != null && vraVar.e0().toString().length() > 0) {
                    f05 f05Var2 = new f05(3, getString(R.string.obfuscated_res_0x7f0f04ed), this.O0);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, vraVar);
                    f05Var2.d.setTag(sparseArray2);
                    arrayList.add(f05Var2);
                }
                this.D2 = vraVar;
            }
            if (this.B0.t1().q()) {
                String u3 = this.B0.t1().u();
                if (vraVar != null && !qd.isEmpty(u3) && u3.equals(vraVar.T())) {
                    z10 = true;
                    if (!z10) {
                        f05Var = new f05(4, getString(R.string.remove_mark), this.O0);
                    } else {
                        f05Var = new f05(4, getString(R.string.obfuscated_res_0x7f0f0c7b), this.O0);
                    }
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.D2);
                    sparseArray3.put(R.id.tag_is_subpb, Boolean.FALSE);
                    f05Var.d.setTag(sparseArray3);
                    arrayList.add(f05Var);
                    if (this.mIsLogin) {
                        if (!lz9.j(this.B0) && !z6 && z5) {
                            f05 f05Var3 = new f05(5, getString(R.string.obfuscated_res_0x7f0f0d3d), this.O0);
                            SparseArray sparseArray4 = new SparseArray();
                            sparseArray4.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                            sparseArray4.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                            sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                            f05Var.d.setTag(sparseArray4);
                            arrayList.add(f05Var3);
                        } else {
                            if (ix9.D(this.B0.t1(), z4) && TbadkCoreApplication.isLogin()) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z11) {
                                f05 f05Var4 = new f05(5, getString(R.string.report_text), this.O0);
                                f05Var4.d.setTag(str2);
                                arrayList.add(f05Var4);
                            }
                        }
                        X5(sparseArray, arrayList, z4, z6, z7, z8, z9, str2);
                    }
                    this.O0.m(arrayList);
                    h05 h05Var = new h05(getPageContext(), this.O0);
                    this.N0 = h05Var;
                    h05Var.l();
                }
            }
            z10 = false;
            if (!z10) {
            }
            SparseArray sparseArray32 = new SparseArray();
            sparseArray32.put(R.id.tag_clip_board, this.D2);
            sparseArray32.put(R.id.tag_is_subpb, Boolean.FALSE);
            f05Var.d.setTag(sparseArray32);
            arrayList.add(f05Var);
            if (this.mIsLogin) {
            }
            this.O0.m(arrayList);
            h05 h05Var2 = new h05(getPageContext(), this.O0);
            this.N0 = h05Var2;
            h05Var2.l();
        }
    }

    public final void z6(View view2) {
        String str;
        int i4;
        PbModel pbModel;
        es9 es9Var;
        vra X;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048797, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f0919bc) {
                d1a.I(4, this.B0);
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f091b43 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                this.S = view2;
            } else if (!checkUpIsLogin()) {
                d1a.u("c10517", this.B0.t1().l(), 3);
            } else {
                PbModel pbModel2 = this.B0;
                if (pbModel2 != null && pbModel2.t1() != null) {
                    this.I0.F0();
                    SparseArray sparseArray = (SparseArray) view2.getTag();
                    vra vraVar = (vra) sparseArray.get(R.id.tag_load_sub_data);
                    vra vraVar2 = (vra) sparseArray.get(R.id.tag_load_sub_reply_data);
                    View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
                    if (vraVar != null && view3 != null) {
                        boolean z3 = true;
                        if (vraVar.O() == 1) {
                            TiebaStatic.log(new StatisticItem("c12630"));
                        }
                        StatisticItem statisticItem = vraVar.h0;
                        if (statisticItem != null) {
                            StatisticItem copy = statisticItem.copy();
                            copy.delete("obj_locate");
                            if (view2.getId() == R.id.obfuscated_res_0x7f0919bc) {
                                copy.param("obj_locate", 6);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091b43) {
                                copy.param("obj_locate", 8);
                            }
                            TiebaStatic.log(copy);
                        }
                        String N1 = this.B0.N1();
                        String T3 = vraVar.T();
                        if (vraVar2 != null) {
                            str = vraVar2.T();
                        } else {
                            str = "";
                        }
                        if (this.B0.t1() != null) {
                            i4 = this.B0.t1().W();
                        } else {
                            i4 = 0;
                        }
                        U8();
                        if (view2.getId() == R.id.obfuscated_res_0x7f091f5f) {
                            AbsPbActivity.e e8 = e8(T3);
                            PbModel pbModel3 = this.B0;
                            if (pbModel3 != null && pbModel3.t1() != null && e8 != null) {
                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(N1, T3, "pb", true, false, null, true, null, i4, vraVar.m0(), this.B0.t1().c(), false, vraVar.t().getIconInfo(), 5).addBigImageData(e8.a, e8.b, e8.g, e8.j);
                                addBigImageData.setKeyPageStartFrom(this.B0.s1());
                                addBigImageData.setFromFrsForumId(this.B0.getFromForumId());
                                addBigImageData.setWorksInfoData(this.B0.S1());
                                addBigImageData.setKeyFromForumId(this.B0.getForumId());
                                addBigImageData.setBjhData(this.B0.K0());
                                addBigImageData.setTiebaPlusData(this.B0.X(), this.B0.T(), this.B0.U(), this.B0.S(), this.B0.Y());
                                sendMessage(new CustomMessage(2002001, addBigImageData));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log("c11742");
                        AbsPbActivity.e e82 = e8(T3);
                        if (vraVar != null && (pbModel = this.B0) != null && pbModel.t1() != null && e82 != null) {
                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(N1, T3, "pb", true, false, null, false, str, i4, vraVar.m0(), this.B0.t1().c(), false, vraVar.t().getIconInfo(), 5).addBigImageData(e82.a, e82.b, e82.g, e82.j);
                            if (!qd.isEmpty(str)) {
                                addBigImageData2.setHighLightPostId(str);
                                addBigImageData2.setKeyIsUseSpid(true);
                            }
                            addBigImageData2.setKeyFromForumId(this.B0.getForumId());
                            addBigImageData2.setTiebaPlusData(this.B0.X(), this.B0.T(), this.B0.U(), this.B0.S(), this.B0.Y());
                            addBigImageData2.setBjhData(this.B0.K0());
                            addBigImageData2.setKeyPageStartFrom(this.B0.s1());
                            addBigImageData2.setFromFrsForumId(this.B0.getFromForumId());
                            addBigImageData2.setWorksInfoData(this.B0.S1());
                            if (this.I0 != null && (es9Var = this.B0.G) != null && (X = es9Var.X()) != null) {
                                if (!X.f1175T && !vraVar.f1175T) {
                                    z3 = false;
                                }
                                addBigImageData2.setMainPostMaskVisibly(z3);
                            }
                            if (this.B0.t1() != null && this.B0.t1().n() != null) {
                                addBigImageData2.setHasForumRule(this.B0.t1().n().has_forum_rule.intValue());
                            }
                            sendMessage(new CustomMessage(2002001, addBigImageData2));
                        }
                    }
                }
            }
        }
    }

    public final void X5(SparseArray<Object> sparseArray, List<f05> list, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str) {
        f05 f05Var;
        f05 f05Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048657, this, new Object[]{sparseArray, list, Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z7), str}) == null) {
            f05 f05Var3 = null;
            if (z4) {
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray2.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray2.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray2.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray2.put(R.id.tag_forbid_user_post_id, str);
                if (z5) {
                    sparseArray2.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray2.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                    sparseArray2.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                    sparseArray2.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                    sparseArray2.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                    sparseArray2.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                    sparseArray2.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                } else {
                    sparseArray2.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (z6) {
                    sparseArray2.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                    sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                    sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                    sparseArray2.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                    if (z7) {
                        f05 f05Var4 = new f05(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0553), this.O0);
                        f05Var4.d.setTag(sparseArray2);
                        f05Var3 = f05Var4;
                    }
                } else {
                    sparseArray2.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                f05Var = new f05(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0326), this.O0);
                f05Var.d.setTag(sparseArray2);
            } else if (z6) {
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                sparseArray3.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                sparseArray3.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray3.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                if (this.B0.t1().W() == 1002 && !z3) {
                    f05Var2 = new f05(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.O0);
                } else {
                    f05Var2 = new f05(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0553), this.O0);
                }
                f05Var2.d.setTag(sparseArray3);
                f05Var3 = f05Var2;
                f05Var = null;
            } else {
                f05Var = null;
            }
            if (f05Var3 != null) {
                list.add(f05Var3);
            }
            if (f05Var != null) {
                list.add(f05Var);
            }
        }
    }

    @Override // com.baidu.tieba.my5
    public void Z(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048666, this, context, str) == null) {
            if (!StringUtils.isNull(str) && !TextUtils.isDigitsOnly(str) && ku9.a(str)) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("TargetSchemeInterceptHelper", "jump targetScheme: " + str);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            }
            this.u = true;
        }
    }

    public void s6(zz4 zz4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048770, this, zz4Var, jSONArray) == null) {
            zz4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(zz4Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                r6((SparseArray) zz4Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final void Z5(boolean z3, boolean z4, SparseArray<Object> sparseArray, List<f05> list, boolean z5, boolean z6, String str) {
        boolean z7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048667, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4), sparseArray, list, Boolean.valueOf(z5), Boolean.valueOf(z6), str}) == null) {
            if (!lz9.j(this.B0) && !z3 && z4) {
                f05 f05Var = new f05(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0d3d), this.O0);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                sparseArray2.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                sparseArray2.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                sparseArray2.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                sparseArray2.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                sparseArray2.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                f05Var.d.setTag(sparseArray2);
                list.add(f05Var);
                return;
            }
            if (ix9.D(this.B0.t1(), z5) && TbadkCoreApplication.isLogin()) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 && !z6) {
                f05 f05Var2 = new f05(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.O0);
                f05Var2.d.setTag(str);
                list.add(f05Var2);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void a1(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048672, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (jy5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), jy5.class);
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (px9.c(objArr[i4].g()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    @Override // com.baidu.tieba.my5
    public void t0(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048773, this, context, str, z3) == null) {
            if (px9.c(str) && (pbModel = this.B0) != null && pbModel.N1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.B0.N1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    cd5 cd5Var = new cd5();
                    cd5Var.a = str;
                    cd5Var.b = 3;
                    cd5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, cd5Var));
                }
            } else {
                px9.a().e(getPageContext(), str);
            }
            this.u = true;
        }
    }

    public void d7(boolean z3, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048687, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
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
            Q8(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void i8(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048713, this, z3, markData) == null) {
            this.I0.T3();
            this.B0.j3(z3);
            fr4 fr4Var = this.D0;
            if (fr4Var != null) {
                fr4Var.h(z3);
                if (markData != null) {
                    this.D0.i(markData);
                }
            }
            if (this.B0.e1()) {
                E7();
            } else {
                this.I0.h2(this.B0.t1());
            }
        }
    }

    public final boolean n6(View view2) {
        InterceptResult invokeL;
        SparseArray<Object> sparseArray;
        fr4 fr4Var;
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
        int i4;
        f05 f05Var;
        f05 f05Var2;
        f05 f05Var3;
        f05 f05Var4;
        f05 f05Var5;
        f05 f05Var6;
        BdImage bdImage;
        SparseArray<Object> sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048730, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext())) {
                return true;
            }
            jx9 jx9Var = this.I0;
            if (jx9Var != null) {
                if (jx9Var.l2()) {
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
                if (ix9.z(view2)) {
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
                        this.I0.z4(this.F2, this.m1.isGif());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            SparseArray<Object> sparseArray3 = sparseArray;
            vra vraVar = (vra) sparseArray3.get(R.id.tag_clip_board);
            this.D2 = vraVar;
            if (vraVar == null) {
                return true;
            }
            if (vraVar.J() == 1 && ix9.z(view2)) {
                this.I0.z4(this.F2, this.m1.isGif());
                return true;
            } else if (this.D2.B0() || (fr4Var = this.D0) == null) {
                return true;
            } else {
                if (fr4Var.e() && this.D2.T() != null && this.D2.T().equals(this.B0.o1())) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (i0().t1() != null && i0().t1().j0()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (i0().t1() != null && i0().t1().p0()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (i0().t1() != null && i0().t1().o0()) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (this.D2.J() == 1) {
                    if (!z4) {
                        this.I0.A4(this.E2, z3, false, z5, z6);
                    }
                    return true;
                }
                if (this.O0 == null) {
                    j05 j05Var = new j05(getContext());
                    this.O0 = j05Var;
                    j05Var.r(this.k2);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 != null && sparseArray3 != null) {
                    if (ix9.z(view2) && !z4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (ix9.z(view2) && (bdImage = this.m1) != null && !bdImage.isGif()) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (sparseArray3.get(R.id.tag_is_subpb) instanceof Boolean) {
                        z9 = ((Boolean) sparseArray3.get(R.id.tag_is_subpb)).booleanValue();
                    } else {
                        z9 = false;
                    }
                    if (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                        z10 = ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue();
                    } else {
                        z10 = false;
                    }
                    if (sparseArray3.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                        z11 = ((Boolean) sparseArray3.get(R.id.tag_user_mute_visible)).booleanValue();
                    } else {
                        z11 = false;
                    }
                    if (sparseArray3.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                        z12 = ((Boolean) sparseArray3.get(R.id.tag_should_manage_visible)).booleanValue();
                    } else {
                        z12 = false;
                    }
                    if (sparseArray3.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                        z13 = ((Boolean) sparseArray3.get(R.id.tag_user_mute_visible)).booleanValue();
                    } else {
                        z13 = false;
                    }
                    if (sparseArray3.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                        z14 = ((Boolean) sparseArray3.get(R.id.tag_should_delete_visible)).booleanValue();
                    } else {
                        z14 = false;
                    }
                    if (sparseArray3.get(R.id.tag_forbid_user_post_id) instanceof String) {
                        str = (String) sparseArray3.get(R.id.tag_forbid_user_post_id);
                    } else {
                        str = null;
                    }
                    if (sparseArray3.get(R.id.tag_is_self_post) instanceof Boolean) {
                        z15 = ((Boolean) sparseArray3.get(R.id.tag_is_self_post)).booleanValue();
                    } else {
                        z15 = false;
                    }
                    if (sparseArray3.get(R.id.tag_mul_del_post_type) instanceof Boolean) {
                        z16 = ((Boolean) sparseArray3.get(R.id.tag_mul_del_post_type)).booleanValue();
                    } else {
                        z16 = false;
                    }
                    if (z7) {
                        arrayList.add(new f05(1, getString(R.string.save_to_emotion), this.O0));
                    }
                    if (z8) {
                        arrayList.add(new f05(2, getString(R.string.save_to_local), this.O0));
                    }
                    if (!z7 && !z8) {
                        f05 f05Var7 = new f05(3, getString(R.string.obfuscated_res_0x7f0f04ed), this.O0);
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_clip_board, this.D2);
                        f05Var7.d.setTag(sparseArray4);
                        arrayList.add(f05Var7);
                    }
                    if (!z9 && !z4) {
                        if (z3) {
                            f05Var6 = new f05(4, getString(R.string.remove_mark), this.O0);
                        } else {
                            f05Var6 = new f05(4, getString(R.string.obfuscated_res_0x7f0f0c7b), this.O0);
                        }
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.tag_clip_board, this.D2);
                        sparseArray5.put(R.id.tag_is_subpb, Boolean.FALSE);
                        f05Var6.d.setTag(sparseArray5);
                        arrayList.add(f05Var6);
                    }
                    if (this.mIsLogin) {
                        String str2 = str;
                        Z5(z12, z11, sparseArray3, arrayList, z10, z4, str2);
                        if (z12) {
                            SparseArray sparseArray6 = new SparseArray();
                            sparseArray6.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                            sparseArray6.put(R.id.tag_manage_user_identity, sparseArray3.get(R.id.tag_manage_user_identity));
                            sparseArray6.put(R.id.tag_forbid_user_name, sparseArray3.get(R.id.tag_forbid_user_name));
                            sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray3.get(R.id.tag_forbid_user_name_show));
                            sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray3.get(R.id.tag_forbid_user_portrait));
                            sparseArray6.put(R.id.tag_forbid_user_post_id, str2);
                            sparseArray6.put(R.id.tag_mul_del_post_type, sparseArray3.get(R.id.tag_mul_del_post_type));
                            if (!lz9.j(this.B0) && z13) {
                                sparseArray6.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                                sparseArray6.put(R.id.tag_is_mem, sparseArray3.get(R.id.tag_is_mem));
                                sparseArray6.put(R.id.tag_user_mute_mute_userid, sparseArray3.get(R.id.tag_user_mute_mute_userid));
                                sparseArray6.put(R.id.tag_user_mute_mute_username, sparseArray3.get(R.id.tag_user_mute_mute_username));
                                sparseArray6.put(R.id.tag_user_mute_mute_nameshow, sparseArray3.get(R.id.tag_user_mute_mute_nameshow));
                                sparseArray6.put(R.id.tag_user_mute_post_id, sparseArray3.get(R.id.tag_user_mute_post_id));
                                sparseArray6.put(R.id.tag_user_mute_thread_id, sparseArray3.get(R.id.tag_user_mute_thread_id));
                            } else {
                                sparseArray6.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                            }
                            if (z14) {
                                sparseArray6.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                                sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                                sparseArray6.put(R.id.tag_del_post_id, sparseArray3.get(R.id.tag_del_post_id));
                                sparseArray6.put(R.id.tag_del_post_type, sparseArray3.get(R.id.tag_del_post_type));
                                sparseArray6.put(R.id.tag_has_sub_post, sparseArray3.get(R.id.tag_has_sub_post));
                                sparseArray6.put(R.id.tag_is_self_post, Boolean.valueOf(z15));
                                if (z15) {
                                    f05Var5 = new f05(6, getString(R.string.obfuscated_res_0x7f0f0553), this.O0);
                                    f05Var5.d.setTag(sparseArray6);
                                    f05 f05Var8 = new f05(7, getString(R.string.obfuscated_res_0x7f0f0326), this.O0);
                                    f05Var8.d.setTag(sparseArray6);
                                    f05Var3 = f05Var5;
                                    f05Var2 = f05Var8;
                                    f05Var = null;
                                }
                            } else {
                                sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                            }
                            f05Var5 = null;
                            f05 f05Var82 = new f05(7, getString(R.string.obfuscated_res_0x7f0f0326), this.O0);
                            f05Var82.d.setTag(sparseArray6);
                            f05Var3 = f05Var5;
                            f05Var2 = f05Var82;
                            f05Var = null;
                        } else if (z14) {
                            SparseArray sparseArray7 = new SparseArray();
                            sparseArray7.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                            sparseArray7.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                            sparseArray7.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                            sparseArray7.put(R.id.tag_manage_user_identity, sparseArray3.get(R.id.tag_manage_user_identity));
                            sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                            sparseArray7.put(R.id.tag_del_post_id, sparseArray3.get(R.id.tag_del_post_id));
                            sparseArray7.put(R.id.tag_del_post_type, sparseArray3.get(R.id.tag_del_post_type));
                            sparseArray7.put(R.id.tag_has_sub_post, sparseArray3.get(R.id.tag_has_sub_post));
                            if (this.B0.t1().W() == 1002 && !z10) {
                                f05Var4 = new f05(6, getString(R.string.report_text), this.O0);
                            } else {
                                f05Var4 = new f05(6, getString(R.string.obfuscated_res_0x7f0f0553), this.O0);
                            }
                            f05Var4.d.setTag(sparseArray7);
                            if (z16) {
                                f05Var = new f05(13, getString(R.string.multi_delete), this.O0);
                                f05Var3 = f05Var4;
                            } else {
                                f05Var3 = f05Var4;
                                f05Var = null;
                            }
                            f05Var2 = null;
                        } else {
                            f05Var = null;
                            f05Var2 = null;
                            f05Var3 = null;
                        }
                        if (f05Var3 != null) {
                            arrayList.add(f05Var3);
                        }
                        if (f05Var != null) {
                            arrayList.add(f05Var);
                        }
                        if (f05Var2 != null) {
                            arrayList.add(f05Var2);
                        }
                        lz9.b(arrayList, this.O0, this.D2, this.B0);
                    }
                    List<f05> d4 = lz9.d(arrayList, this.D2.p(), sparseArray3, this.O0, this.D2.s());
                    lz9.m(d4, this.b);
                    lz9.f(d4);
                    this.O0.s(lz9.h(this.D2));
                    this.O0.n(d4, true);
                    this.N0 = new h05(getPageContext(), this.O0);
                    this.O0.q(new c3(this));
                    this.N0.l();
                    StatisticItem param = new StatisticItem("c13272").param("tid", this.B0.b).param("fid", this.B0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.B0.Q());
                    if (z9) {
                        i4 = 2;
                    } else {
                        i4 = 1;
                    }
                    TiebaStatic.log(param.param("obj_source", i4));
                    return true;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void o6(ForumManageModel.b bVar, jx9 jx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048733, this, bVar, jx9Var) == null) {
            List<vra> list = this.B0.t1().T().a;
            int size = list.size();
            boolean z3 = false;
            for (int i4 = 0; i4 < size; i4++) {
                int i5 = 0;
                while (true) {
                    if (i5 >= list.get(i4).j0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i4).j0().get(i5).T())) {
                        list.get(i4).j0().remove(i5);
                        list.get(i4).h();
                        z3 = true;
                        break;
                    } else {
                        i5++;
                    }
                }
                list.get(i4).i(bVar.g);
            }
            if (z3) {
                jx9Var.h2(this.B0.t1());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048737, this, i4, i5, intent) == null) {
            super.onActivityResult(i4, i5, intent);
            vg5 vg5Var = this.Y0;
            if (vg5Var != null) {
                vg5Var.G(i4, i5, intent);
            }
            if (W6().x1() != null) {
                W6().x1().k(i4, i5, intent);
            }
            if (i4 == 25035) {
                c7(i5, intent);
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
                                                    View view3 = this.f1142T;
                                                    if (view3 != null) {
                                                        view3.performClick();
                                                        return;
                                                    }
                                                    return;
                                                case 25057:
                                                    jx9 jx9Var = this.I0;
                                                    if (jx9Var != null && jx9Var.W0() != null) {
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
                                        this.I0.W3(false);
                                        if (this.B0.t1() != null && this.B0.t1().O() != null && this.B0.t1().O().getPushStatusData() != null) {
                                            this.B0.t1().O().getPushStatusData().setStatus(2);
                                            return;
                                        }
                                        return;
                                    }
                                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                        RateManager.getInstance().notifyShare(getPageContext());
                                        e9();
                                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.H0;
                                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.linkUrl) != null) {
                                            shareSuccessReplyToServerModel.O(str, intExtra, new n2(this));
                                        }
                                        if (p7()) {
                                            c9(true);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                View view5 = this.R;
                                if (view5 != null) {
                                    this.I0.r4(view5);
                                    return;
                                }
                                return;
                            }
                            f7(intent);
                            return;
                        }
                        RateManager.getInstance().notifyShare(getPageContext());
                        return;
                    }
                    ax9.b().k();
                    this.y0.postDelayed(new m2(this), 1000L);
                    return;
                }
                H7();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        jx9 jx9Var;
        jx9 jx9Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, bundle) == null) {
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
                if (M6()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P = stringExtra;
                if (qd.isEmpty(stringExtra)) {
                    str = "";
                } else {
                    str = this.P;
                }
                this.P = str;
                this.s1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                py4 py4Var = new py4();
                this.c0 = py4Var;
                py4Var.a(intent);
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
            A7(bundle);
            if (this.B0.t1() != null) {
                this.B0.t1().V0(this.P);
                if (this.V0 && this.B0.t1().O() != null) {
                    this.B0.t1().O().setIs_top(1);
                }
            }
            l7();
            if (intent != null && (jx9Var2 = this.I0) != null) {
                jx9Var2.e = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.k1 == null) {
                        this.k1 = new q0(this, intent);
                    }
                    SafeHandler.getInst().postDelayed(this.k1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.B0.t1() != null) {
                    this.B0.b3(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.i = voiceManager;
            voiceManager.onCreate(getPageContext());
            k7(bundle);
            wg5 wg5Var = new wg5();
            this.X0 = wg5Var;
            y8(wg5Var);
            vg5 vg5Var = (vg5) this.X0.a(getActivity());
            this.Y0 = vg5Var;
            vg5Var.a0(this.a.getPageContext());
            this.Y0.j0(this.o2);
            this.Y0.k0(this.c1);
            this.Y0.c0(1);
            this.Y0.E(this.a.getPageContext(), bundle);
            this.Y0.a().c(new ke5(getActivity()));
            this.Y0.a().M(true);
            B8(true);
            this.Y0.N(this.B0.V0(), this.B0.N1(), this.B0.R0());
            registerListener(this.B1);
            if (!this.B0.g1()) {
                this.Y0.t(this.B0.N1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.Y0.g0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.B0.d2()) {
                this.Y0.g0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                jx9 jx9Var3 = this.I0;
                if (jx9Var3 != null) {
                    this.Y0.g0(jx9Var3.y1());
                }
            }
            ot9 ot9Var = new ot9(this.a.getUniqueId(), new r0(this), new s0(this));
            this.f2 = ot9Var;
            registerListener(ot9Var.d());
            this.G = new PbGodGuideController();
            getLifecycle().addObserver(this.G);
            gu4.a().c(this.z0);
            gu4.a().c(this.A0);
            registerListener(this.A1);
            registerListener(this.C1);
            registerListener(this.D1);
            registerListener(this.z1);
            registerListener(this.d2);
            registerListener(this.e2);
            registerListener(this.u2);
            registerListener(this.y1);
            lra lraVar = new lra("pb", lra.d);
            this.W0 = lraVar;
            lraVar.d();
            registerListener(this.J1);
            registerListener(this.T1);
            this.B0.x2();
            registerListener(this.t2);
            registerListener(this.h2);
            registerListener(this.n2);
            registerListener(this.P1);
            registerListener(this.g2);
            registerListener(this.K1);
            jx9 jx9Var4 = this.I0;
            if (jx9Var4 != null && jx9Var4.F1() != null && this.I0.C1() != null) {
                uy9 uy9Var = new uy9(getActivity(), this.I0.F1(), this.I0.C1(), this.I0.v1());
                this.e = uy9Var;
                uy9Var.t(this.S1);
            }
            if (this.c && (jx9Var = this.I0) != null && jx9Var.C1() != null) {
                this.I0.C1().setVisibility(8);
            }
            c55 c55Var = new c55();
            this.i1 = c55Var;
            c55Var.a = 1000L;
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
            this.W1 = new h3(this.I0, this);
            this.B0.N0().S(this.W1);
            this.M0 = new mx9();
            if (this.Y0.v() != null) {
                this.M0.m(this.Y0.v().k());
            }
            this.Y0.Z(this.d1);
            this.H0 = new ShareSuccessReplyToServerModel();
            U5(this.w1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.a1 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new u0(this));
            j0a j0aVar = new j0a(getContext());
            this.C0 = j0aVar;
            j0aVar.b(getUniqueId());
            xpa.g().i(getUniqueId());
            wv4.b().l("3", "");
            this.v1 = new xk6(getPageContext());
            this.u0 = new iz9(this, getUniqueId(), this.I0, this.B0);
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048743, this, layoutInflater, viewGroup, bundle)) == null) {
            this.I0 = new jx9(this, this.m2, this.X1, this.l2);
            mv6 mv6Var = new mv6(getActivity());
            this.d = mv6Var;
            mv6Var.i(U2);
            this.d.d(this.M2);
            this.I0.N3(this.w2);
            this.I0.M3(this.B2);
            this.I0.G3(this.y2);
            this.I0.H3(this.z2);
            this.I0.E3(lv4.c().g());
            this.I0.K3(this.C2);
            this.I0.Q3(this.H2);
            this.I0.O3(this.I2);
            this.I0.L3(this.K2);
            this.I0.V4(this.mIsLogin);
            this.I0.C3(this.B0.b2());
            if (this.a.getIntent() != null) {
                this.I0.D3(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.I0.w1().setFromForumId(this.B0.getFromForumId());
            vg5 vg5Var = this.Y0;
            if (vg5Var != null) {
                this.I0.u3(vg5Var.a());
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.Y0.g0(TbSingleton.getInstance().getAdVertiComment());
                } else {
                    this.Y0.g0(this.I0.y1());
                }
            }
            this.I0.y3(this.j2);
            this.I0.B3(this.B0.b1());
            this.I0.P3(this.B0.s1());
            this.u0.f(this.I0, this.B0);
            if ("1".equals(i0().showReplyPanel)) {
                this.I0.O2();
            }
            return this.I0.G1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d0a d0aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048744, this) == null) {
            xpa.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!qd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.B0.t1().l());
                statisticItem.param("tid", this.B0.N1());
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
                if (this.B0.p1() != null) {
                    this.B0.p1().d();
                }
            }
            vg5 vg5Var = this.Y0;
            if (vg5Var != null) {
                vg5Var.H();
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
            jx9 jx9Var = this.I0;
            if (jx9Var != null) {
                jx9Var.H2();
                d0a d0aVar2 = this.I0.k;
                if (d0aVar2 != null) {
                    d0aVar2.r();
                }
            }
            bp5 bp5Var = this.s;
            if (bp5Var != null) {
                bp5Var.c();
            }
            uy9 uy9Var = this.e;
            if (uy9Var != null) {
                uy9Var.k();
            }
            ob<TextView> obVar = this.y;
            if (obVar != null) {
                obVar.c();
            }
            ob<FestivalTipView> obVar2 = this.H;
            if (obVar2 != null) {
                obVar2.c();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            jx9 jx9Var2 = this.I0;
            if (jx9Var2 != null) {
                jx9Var2.F0();
            }
            if (this.Y1 != null) {
                SafeHandler.getInst().removeCallbacks(this.Y1);
            }
            if (this.f2 != null) {
                MessageManager.getInstance().unRegisterListener(this.f2.d());
            }
            gu4.a().e(this.z0);
            gu4.a().e(this.A0);
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
            jx9 jx9Var3 = this.I0;
            if (jx9Var3 != null && (d0aVar = jx9Var3.k) != null) {
                d0aVar.k();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.H0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            mx9 mx9Var = this.M0;
            if (mx9Var != null) {
                mx9Var.j();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.B0;
            if (pbModel2 != null && pbModel2.G0() != null) {
                this.B0.G0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.a1;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            jx9 jx9Var4 = this.I0;
            if (jx9Var4 != null) {
                jx9Var4.S4();
            }
            iz9 iz9Var = this.u0;
            if (iz9Var != null) {
                iz9Var.e();
            }
        }
    }

    public void t6(int i4, String str, int i5, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048775, this, new Object[]{Integer.valueOf(i4), str, Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i5));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(jx9.o2, Integer.valueOf(jx9.p2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                r6(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }
}
