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
import com.baidu.tieba.ae5;
import com.baidu.tieba.aiapps.TbAiappsLaunchUtil;
import com.baidu.tieba.aj5;
import com.baidu.tieba.aj9;
import com.baidu.tieba.al5;
import com.baidu.tieba.ao9;
import com.baidu.tieba.aq9;
import com.baidu.tieba.as9;
import com.baidu.tieba.bg;
import com.baidu.tieba.bi5;
import com.baidu.tieba.bj9;
import com.baidu.tieba.bm9;
import com.baidu.tieba.bq9;
import com.baidu.tieba.bt5;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cg;
import com.baidu.tieba.cn;
import com.baidu.tieba.co9;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cp9;
import com.baidu.tieba.cq9;
import com.baidu.tieba.dh9;
import com.baidu.tieba.dj5;
import com.baidu.tieba.do9;
import com.baidu.tieba.e26;
import com.baidu.tieba.e35;
import com.baidu.tieba.e55;
import com.baidu.tieba.ei;
import com.baidu.tieba.ei5;
import com.baidu.tieba.ej5;
import com.baidu.tieba.ep9;
import com.baidu.tieba.fj5;
import com.baidu.tieba.fn9;
import com.baidu.tieba.fp9;
import com.baidu.tieba.ft5;
import com.baidu.tieba.fz6;
import com.baidu.tieba.fza;
import com.baidu.tieba.g35;
import com.baidu.tieba.g55;
import com.baidu.tieba.gh9;
import com.baidu.tieba.gm9;
import com.baidu.tieba.gn;
import com.baidu.tieba.gz6;
import com.baidu.tieba.h15;
import com.baidu.tieba.h26;
import com.baidu.tieba.h55;
import com.baidu.tieba.h95;
import com.baidu.tieba.hg5;
import com.baidu.tieba.hn9;
import com.baidu.tieba.hs5;
import com.baidu.tieba.hu6;
import com.baidu.tieba.hw4;
import com.baidu.tieba.hz4;
import com.baidu.tieba.i55;
import com.baidu.tieba.i9;
import com.baidu.tieba.ih9;
import com.baidu.tieba.iqa;
import com.baidu.tieba.jha;
import com.baidu.tieba.kb5;
import com.baidu.tieba.ke5;
import com.baidu.tieba.kg5;
import com.baidu.tieba.kk9;
import com.baidu.tieba.kl5;
import com.baidu.tieba.l36;
import com.baidu.tieba.l45;
import com.baidu.tieba.lo6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.lqa;
import com.baidu.tieba.m05;
import com.baidu.tieba.mm9;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.ms5;
import com.baidu.tieba.mt4;
import com.baidu.tieba.nq9;
import com.baidu.tieba.nr9;
import com.baidu.tieba.nt4;
import com.baidu.tieba.o25;
import com.baidu.tieba.on9;
import com.baidu.tieba.p35;
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
import com.baidu.tieba.pq9;
import com.baidu.tieba.q1a;
import com.baidu.tieba.qj9;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.tieba.rh5;
import com.baidu.tieba.rj9;
import com.baidu.tieba.rr9;
import com.baidu.tieba.rs5;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.sha;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.si5;
import com.baidu.tieba.t55;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tha;
import com.baidu.tieba.tj9;
import com.baidu.tieba.tk5;
import com.baidu.tieba.tp9;
import com.baidu.tieba.tq9;
import com.baidu.tieba.uk5;
import com.baidu.tieba.uk9;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.v95;
import com.baidu.tieba.ve5;
import com.baidu.tieba.vfa;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vk9;
import com.baidu.tieba.vm9;
import com.baidu.tieba.vp9;
import com.baidu.tieba.w05;
import com.baidu.tieba.wh5;
import com.baidu.tieba.wk5;
import com.baidu.tieba.wn9;
import com.baidu.tieba.wp9;
import com.baidu.tieba.x15;
import com.baidu.tieba.x9a;
import com.baidu.tieba.xk5;
import com.baidu.tieba.xn9;
import com.baidu.tieba.xw5;
import com.baidu.tieba.xz7;
import com.baidu.tieba.y45;
import com.baidu.tieba.yk5;
import com.baidu.tieba.yk9;
import com.baidu.tieba.ym5;
import com.baidu.tieba.z45;
import com.baidu.tieba.z95;
import com.baidu.tieba.zha;
import com.baidu.tieba.zia;
import com.baidu.tieba.zo9;
import com.baidu.tieba.zp9;
import com.baidu.tieba.zs5;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.SmartApp;
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class PbFragment extends BaseFragment implements h26, VoiceManager.j, UserIconBox.c, View.OnTouchListener, y45.e, TbRichTextView.t, TbPageContextSupport, rr9, as9.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k V2;
    public static final gz6.b W2;
    public transient /* synthetic */ FieldHolder $fh;
    public bg<ImageView> A;
    public hz4.d A0;
    public CustomMessageListener A1;
    public boolean A2;
    public bg<View> B;
    public PbModel B0;
    public CustomMessageListener B1;
    public final BdListView.p B2;
    public bg<TiebaPlusRecommendCard> C;
    public tq9 C0;
    public CustomMessageListener C1;
    public int C2;
    public bg<LinearLayout> D;
    public hw4 D0;
    public CustomMessageListener D1;
    public final TbRichTextView.z D2;
    public bg<RelativeLayout> E;
    public ForumManageModel E0;
    public CustomMessageListener E1;
    public boolean E2;
    public bg<ItemCardView> F;
    public ve5 F0;
    public final CustomMessageListener F1;
    public tha F2;
    @NonNull
    public PbGodGuideController G;
    public tj9 G0;
    public CustomMessageListener G1;
    public final z45.c G2;
    public bg<FestivalTipView> H;
    public PollingModel H0;
    public CustomMessageListener H1;
    public final z45.c H2;
    public boolean I;
    public ShareSuccessReplyToServerModel I0;
    public View.OnClickListener I1;
    public final AdapterView.OnItemClickListener I2;
    public boolean J;
    public xn9 J0;
    public CustomMessageListener J1;
    public final View.OnLongClickListener J2;
    public boolean K;
    public boolean K0;
    public CustomMessageListener K1;
    public final View.OnClickListener K2;
    public bg<GifView> L;
    public boolean L0;
    public CustomMessageListener L1;
    public final ItemCardHelper.c L2;
    public String M;
    public boolean M0;
    public CustomMessageListener M1;
    public final NoNetworkView.b M2;
    public boolean N;
    public ao9 N0;
    public CustomMessageListener N1;
    public View.OnTouchListener N2;
    public boolean O;
    public g55 O0;
    public SuggestEmotionModel.c O1;
    public fz6.b O2;
    public String P;
    public i55 P0;
    public CustomMessageListener P1;
    public final mm9.b P2;
    public LikeModel Q;
    public String Q0;
    public GetSugMatchWordsModel.b Q1;
    public int Q2;
    public View R;
    public boolean R0;
    public PraiseModel R1;
    public int R2;
    public View S;
    public boolean S0;
    public fp9.h S1;
    public String S2;

    /* renamed from: T  reason: collision with root package name */
    public View f1142T;
    public boolean T0;
    public CustomMessageListener T1;
    public x15 T2;
    public View U;
    public String U0;
    public ResponsedEventListener U1;
    public int U2;
    public String V;
    public boolean V0;
    public ResponsedEventListener V1;
    public int W;
    public jha W0;
    public CheckRealNameModel.b W1;
    public boolean X;
    public yk5 X0;
    public vk9 X1;
    public int[] Y;
    public xk5 Y0;
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
    public bq9 b1;
    public CustomMessageListener b2;
    public boolean c;
    public p35 c0;
    public uk5 c1;
    public CustomMessageListener c2;
    public gz6 d;
    public BdUniqueId d0;
    public tk5 d1;
    public CustomMessageListener d2;
    public fp9 e;
    public h95 e0;
    public tk5 e1;
    public CustomMessageListener e2;
    public boolean f;
    public boolean f0;
    public int f1;
    public kk9 f2;
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
    public v95 i1;
    public y45.e i2;
    public int j;
    public hg5 j0;
    public BdUniqueId j1;
    public k3 j2;
    public z45 k;
    public Runnable k1;
    public i55.f k2;
    public long l;
    public co9 l1;
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
    public zs5 s;
    public boolean s0;
    public int s1;
    public final PbModel.h s2;
    public long t;
    @NonNull
    public TiePlusEventController.g t0;
    public List<i3> t1;
    public CustomMessageListener t2;
    public boolean u;
    public tp9 u0;
    public int u1;
    public HttpMessageListener u2;
    public long v;
    public PushPermissionController v0;
    public lo6 v1;
    public final hw4.a v2;
    public int w;
    public boolean w0;
    public final i3 w1;
    public final AbsListView.OnScrollListener w2;
    public String x;
    public PbInterviewStatusView.f x0;
    public final fn9.b x1;
    public final i9 x2;
    public bg<TextView> y;
    public final Handler y0;
    public final CustomMessageListener y1;
    public final z95.g y2;
    public bg<TbImageView> z;
    public hz4.d z0;
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

    @Override // com.baidu.tieba.rr9
    public PbFragment O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr9
    public AbsVideoPbFragment S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return null;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public void f0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048710, this, context, str) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048765, this, view2, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView r1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048774, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048784, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public void u1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048786, this, context, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class p2 implements ShareSuccessReplyToServerModel.b {
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
            public final /* synthetic */ p2 b;

            public a(p2 p2Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {p2Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = p2Var;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    yk9.a(this.b.a.getPageContext(), this.a).show();
                }
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.J0 != null && this.a != null) {
                    this.b.a.J0.V2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements y45.e {
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

            @Override // com.baidu.tieba.y45.e
            public void onClick(y45 y45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                    y45Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements y45.e {
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

            @Override // com.baidu.tieba.y45.e
            public void onClick(y45 y45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                    y45Var.dismiss();
                    aq9.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ae5 ae5Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ae5Var, writeData, antiData}) == null) {
                if (!ei.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.B0.r1() != null) {
                        statisticItem.param("fid", this.a.B0.r1().l());
                    }
                    statisticItem.param("tid", this.a.B0.L1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (ei.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.I8();
                this.a.J0.K3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (this.a.H0 != null) {
                    this.a.H0.getData(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    SafeHandler.getInst().postDelayed(this.a.Y1, 300000L);
                }
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.Y0 != null && (this.a.Y0.y() || this.a.Y0.A())) {
                            this.a.Y0.w(false, postWriteCallBackData);
                        }
                        this.a.N0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.a1;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (ei.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        y45 y45Var = new y45(this.a.getActivity());
                        if (ei.isEmpty(postWriteCallBackData.getErrorString())) {
                            y45Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            y45Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new b(this));
                        y45Var.setPositiveButton(R.string.open_now, new c(this));
                        y45Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (ae5Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.p8(i, antiData, str);
                        return;
                    }
                }
                this.a.B8(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.q8(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData != null && writeData.getType() == 2) {
                    if (floor != null) {
                        this.a.J0.d2(this.a.B0.r1());
                    }
                } else if (this.a.B0.U0()) {
                    aj9 r1 = this.a.B0.r1();
                    if (r1 != null && r1.O() != null && r1.O().getAuthor() != null && (userId = r1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.B0.i3()) {
                        this.a.J0.M3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.B0.i3()) {
                    this.a.J0.M3();
                }
                if (this.a.B0.Y0()) {
                    nr9.t("c10369", this.a.B0.L1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.B0 != null) {
                    Context context = this.a.getContext();
                    aj9 r12 = this.a.B0.r1();
                    String forumId = this.a.B0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    wn9.a(context, r12, forumId, z2, this.a.B0.x1(), this.a.B0.A1(), this.a.B0.z1(), this.a.B0.y1(), this.a.B0.E1(), this.a.B0.F1());
                }
                if (writeData != null) {
                    kb5.b(writeData.getContent(), "1");
                }
                if (this.a.a7()) {
                    this.a.P8();
                }
                this.a.y8();
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.J0 != null && this.a != null) {
                    this.b.a.J0.V2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements y45.e {
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

            @Override // com.baidu.tieba.y45.e
            public void onClick(y45 y45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                    y45Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements y45.e {
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

            @Override // com.baidu.tieba.y45.e
            public void onClick(y45 y45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                    y45Var.dismiss();
                    aq9.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ae5 ae5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ae5Var, writeData, antiData}) == null) {
                if (!ei.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.B0 != null && this.a.B0.r1() != null) {
                        statisticItem.param("fid", this.a.B0.r1().l());
                    }
                    if (this.a.B0 != null) {
                        statisticItem.param("tid", this.a.B0.L1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.y6()) {
                        this.a.i8(false);
                        gh9.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1496));
                    }
                    ao9 ao9Var = this.a.N0;
                    if (ao9Var != null) {
                        ao9Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        kg5.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        kb5.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.a7()) {
                        this.a.P8();
                    }
                    this.a.y8();
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
                    if (ei.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                    } else {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    y45 y45Var = new y45(this.a.getActivity());
                    if (ei.isEmpty(postWriteCallBackData.getErrorString())) {
                        y45Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        y45Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new b(this));
                    y45Var.setPositiveButton(R.string.open_now, new c(this));
                    y45Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbFragment pbFragment = this.a;
                    if (pbFragment.N0 != null) {
                        if (pbFragment.J0 != null && this.a.J0.w1() != null && this.a.J0.w1().f() != null && this.a.J0.w1().f().z()) {
                            this.a.J0.w1().f().w(postWriteCallBackData);
                        }
                        this.a.N0.l(postWriteCallBackData);
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
                this.a.J0.K1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                aj9 r1 = this.a.B0.r1();
                if (r1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    r1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.i1.d(this.a.h1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.h1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.D8(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ei.isEmpty(errorString2)) {
                        errorString2 = this.a.h1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.i1.c(errorString2);
                } else {
                    this.a.v8();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a2 implements hz4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.hz4.d
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

        @Override // com.baidu.tieba.hz4.c
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
                    if (this.a.F2 != null && TextUtils.equals(this.a.F2.U(), optString)) {
                        if (this.a.F2.s() != null) {
                            BdToastHelper.toast(fza.a(this.a.F2.s().feedback_toast));
                        }
                    }
                } finally {
                    this.a.F2 = null;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a3 implements TbRichTextView.z {
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

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            gm9 T0;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.J0.B2((TbRichText) view2.getTag());
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
                    nr9.K(3, i2, this.a.B0);
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
                    this.a.O7(str, i, eVar);
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
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().Q() != null) {
                            ArrayList<TbRichTextImageInfo> Q = tbRichTextView.getRichText().Q();
                            int i6 = 0;
                            int i7 = -1;
                            while (i6 < Q.size()) {
                                if (Q.get(i6) != null) {
                                    arrayList.add(Q.get(i6).getSrc());
                                    if (i7 == i5 && str != null && (str.equals(Q.get(i6).getSrc()) || str.equals(Q.get(i6).N()) || str.equals(Q.get(i6).M()) || str.equals(Q.get(i6).getBigSrc()) || str.equals(Q.get(i6).P()))) {
                                        i7 = i6;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    String src = Q.get(i6).getSrc();
                                    imageUrlData.imageUrl = src;
                                    imageUrlData.imageThumbUrl = src;
                                    if (this.a.q) {
                                        i4 = 17;
                                    } else {
                                        i4 = 18;
                                    }
                                    imageUrlData.urlThumbType = i4;
                                    imageUrlData.originalUrl = Q.get(i6).getSrc();
                                    imageUrlData.isLongPic = Q.get(i6).T();
                                    concurrentHashMap.put(Q.get(i6).getSrc(), imageUrlData);
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
                        this.a.m6(rect);
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.setData(arrayList).setIndex(i3).setIsCDN(false).setPostId(eVar.f).setIsReserve(this.a.B0.D1()).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false).setIsSeeHost(this.a.c7()).setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.B0 != null) {
                            builder.setFromForumId(this.a.B0.getFromForumId());
                            if (this.a.B0.r1() != null) {
                                builder.setThreadData(this.a.B0.r1().O());
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
                        builder2.setData(arrayList2).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.a.get(0)).setIsReserve(this.a.B0.D1()).setAssistUrls(concurrentHashMap2).setNeedBroadCaset(false).setIsSeeHost(this.a.c7()).setPostId(eVar.f).setBjhPostId(eVar.f).setIsCanDrag(false);
                        if (this.a.B0 != null) {
                            builder2.setFromForumId(this.a.B0.getFromForumId());
                            if (this.a.B0.r1() != null) {
                                builder2.setThreadData(this.a.B0.r1().O());
                            }
                        }
                        ImageViewerConfig bulid2 = builder2.bulid(this.a.getPageContext().getPageActivity());
                        bulid2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, bulid2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText V8 = this.a.V8(str, i);
                        if (V8 != null && this.a.C2 >= 0 && this.a.C2 < V8.O().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = bj9.a(V8.O().get(this.a.C2));
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
                            if (V8.getPostId() != 0 && (T0 = this.a.J0.T0()) != null) {
                                ArrayList<cn> v = T0.v();
                                if (ListUtils.getCount(v) > 0) {
                                    Iterator<cn> it = v.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        cn next = it.next();
                                        if ((next instanceof tha) && V8.getPostId() == JavaTypesHelper.toLong(((tha) next).U(), 0L)) {
                                            int i9 = 8;
                                            if (V8.getPostId() == JavaTypesHelper.toLong(this.a.B0.P0(), 0L)) {
                                                i9 = 1;
                                            }
                                            nr9.b(this.a.B0.r1(), (tha) next, ((tha) next).f0, i9, 3);
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
                            this.a.m6(rect2);
                            ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                            builder3.setData(arrayList3).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.i).setIsReserve(this.a.B0.D1()).setAssistUrls(concurrentHashMap3).setNeedBroadCaset(false).setIsSeeHost(this.a.c7()).setPostId(eVar.f).setBjhPostId(eVar.f).setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.B0 != null) {
                                builder3.setFromForumId(this.a.B0.getFromForumId());
                                if (this.a.B0.r1() != null) {
                                    builder3.setThreadData(this.a.B0.r1().O());
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
        public void k(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.f && z && !this.a.B0.g1()) {
                    this.a.W7();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0703cc));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof o25)) {
                o25 o25Var = (o25) customResponsedMessage.getData();
                g35.a aVar = new g35.a();
                int i = o25Var.a;
                String str = o25Var.b;
                aVar.a = o25Var.d;
                aj9 r1 = this.a.B0.r1();
                if (r1 == null) {
                    return;
                }
                if (this.a.B0.T0() != null && this.a.B0.T0().getUserIdLong() == o25Var.p) {
                    this.a.J0.c3(o25Var.l, this.a.B0.r1(), this.a.B0.K1(), this.a.B0.C1());
                }
                if (r1.F() != null && r1.F().size() >= 1 && r1.F().get(0) != null) {
                    long j = JavaTypesHelper.toLong(r1.F().get(0).U(), 0L);
                    long j2 = JavaTypesHelper.toLong(this.a.B0.L1(), 0L);
                    if (j == o25Var.n && j2 == o25Var.m) {
                        g35 S = r1.F().get(0).S();
                        if (S == null) {
                            S = new g35();
                        }
                        ArrayList<g35.a> a = S.a();
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        a.add(0, aVar);
                        S.e(S.b() + o25Var.l);
                        S.d(a);
                        r1.F().get(0).a1(S);
                        this.a.J0.T0().f0();
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
                this.a.J0.K1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.i1.d(this.a.h1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ei.isEmpty(muteMessage)) {
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
                if (this.a.J0 != null) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.J0.E1());
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
                    this.a.m8(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e40);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                new BdTopToast(this.a.getContext()).setIcon(false).setContent(errorString).show((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b3 implements z45.c {
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

        @Override // com.baidu.tieba.z45.c
        public void a(z45 z45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, z45Var, i, view2) == null) {
                if (z45Var != null) {
                    z45Var.e();
                }
                PbFragment pbFragment = this.a;
                tha thaVar = pbFragment.F2;
                if (thaVar != null) {
                    if (i == 0) {
                        thaVar.S0();
                        this.a.F2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.v7(pbFragment2.F2);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements cg<LinearLayout> {
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
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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
        @Override // com.baidu.tieba.cg
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof l36)) {
                l36 l36Var = (l36) customResponsedMessage.getData();
                aj9 r1 = this.a.B0.r1();
                if (r1 == null) {
                    return;
                }
                if (this.a.B0.r1() != null && this.a.B0.r1().X().t() != null && this.a.B0.r1().X().t().getPortrait() != null && this.a.B0.r1().X().t().getPortrait().equals(l36Var.a)) {
                    if (this.a.B0.r1().X().t().getUserWorldCupData() != null) {
                        this.a.B0.r1().X().t().getUserWorldCupData().c(l36Var.b);
                    }
                    this.a.J0.d3(this.a.B0.r1(), this.a.B0.K1(), this.a.B0.C1(), this.a.J0.A1());
                }
                if (r1.F() != null && r1.F().size() >= 0) {
                    Iterator<tha> it = r1.F().iterator();
                    while (it.hasNext()) {
                        tha next = it.next();
                        if (next != null && next.t() != null && next.t().getPortrait() != null && next.t().getPortrait().equals(l36Var.a) && next.t().getUserWorldCupData() != null) {
                            next.t().getUserWorldCupData().c(l36Var.b);
                        }
                    }
                    this.a.J0.T0().f0();
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
                if (!this.a.a7() || this.a.a == null || this.a.a.J1() == null || !str.equals(this.a.a.J1().getTopicId())) {
                    return;
                }
                this.a.Q8(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c2 implements hw4.a {
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

        @Override // com.baidu.tieba.hw4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.J0.L3();
                if (z) {
                    if (this.a.D0 != null) {
                        this.a.D0.h(z2);
                    }
                    this.a.B0.h3(z2);
                    if (!this.a.B0.c1()) {
                        this.a.J0.d2(this.a.B0.r1());
                    } else {
                        this.a.q7();
                    }
                    if (z2) {
                        boolean p0 = this.a.B0.r1().p0();
                        if (this.a.D0 != null && !p0) {
                            if (this.a.D0.f() != null && this.a.B0 != null && this.a.B0.r1() != null && this.a.B0.r1().O() != null && this.a.B0.r1().O().getAuthor() != null) {
                                MarkData f = this.a.D0.f();
                                MetaData author = this.a.B0.r1().O().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00ff);
                                        this.a.z8();
                                    } else {
                                        this.a.u8(author);
                                    }
                                } else {
                                    PbFragment pbFragment = this.a;
                                    pbFragment.showToast(pbFragment.getPageContext().getString(R.string.add_mark));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.E5();
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
    public class c3 implements z45.c {
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

        @Override // com.baidu.tieba.z45.c
        public void a(z45 z45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, z45Var, i, view2) == null) {
                if (z45Var != null) {
                    z45Var.e();
                }
                if (this.a.m1 != null && !TextUtils.isEmpty(this.a.n1)) {
                    if (i == 0) {
                        if (this.a.p1 != null) {
                            ym5.a aVar = new ym5.a();
                            aVar.a = this.a.n1;
                            String str = "";
                            if (this.a.p1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.p1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        } else {
                            this.a.G5();
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
                            pbFragment.l1 = new co9(pbFragment.getPageContext());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.B0 != null && this.a.B0.r1() != null) {
                this.a.B0.r1().a();
                this.a.B0.W1();
                if (this.a.J0.T0() != null) {
                    this.a.J0.d2(this.a.B0.r1());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof lqa) && customResponsedMessage.getOrginalMessage().getTag() == this.a.j1) {
                lqa lqaVar = (lqa) customResponsedMessage.getData();
                this.a.J0.K1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.g1;
                DataRes dataRes = lqaVar.a;
                boolean z = false;
                if (lqaVar.c == 0 && dataRes != null) {
                    int i = JavaTypesHelper.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (i == 1) {
                        z = true;
                    }
                    if (ei.isEmpty(str)) {
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
                        this.a.J0.R2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.w8(z, sparseArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d2 implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public d2(PbFragment pbFragment, MetaData metaData) {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d3 implements AdapterView.OnItemClickListener {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.B0 == null || this.a.B0.B1() == i + 1) {
                return;
            }
            this.a.g8(wn9.p(i));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements fz6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.fz6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.fz6.b
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

        @Override // com.baidu.tieba.fz6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.J0 != null && this.b.e != null) {
                this.b.e.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.e.l();
                }
                if (this.b.x6()) {
                    this.b.J0.L1();
                    this.b.J0.k3();
                }
            }
        }

        @Override // com.baidu.tieba.fz6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.J0 != null && this.b.e != null) {
                this.b.J0.s4();
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
            sha i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.B0 != null && this.a.B0.r1() != null) {
                String str = (String) customResponsedMessage.getData();
                sha shaVar = null;
                if (!TextUtils.isEmpty(str) && this.a.B0.r1().F() != null) {
                    ArrayList<tha> F = this.a.B0.r1().F();
                    Iterator<tha> it = F.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        tha next = it.next();
                        if (next instanceof sha) {
                            sha shaVar2 = (sha) next;
                            if (str.equals(shaVar2.E1())) {
                                shaVar = shaVar2;
                                break;
                            }
                        }
                    }
                    if (shaVar != null) {
                        F.remove(shaVar);
                    }
                }
                if (this.a.J0.T0() != null && !ListUtils.isEmpty(this.a.J0.T0().v())) {
                    ArrayList<cn> v = this.a.J0.T0().v();
                    if (shaVar != null) {
                        i = shaVar;
                    } else {
                        i = wn9.i(this.a.B0.r1(), str);
                    }
                    wn9.e(v, i);
                }
                if (this.a.J0.m1() != null && !ListUtils.isEmpty(this.a.J0.m1().getData())) {
                    List<cn> data = this.a.J0.m1().getData();
                    if (shaVar == null) {
                        shaVar = wn9.i(this.a.B0.r1(), str);
                    }
                    wn9.e(data, shaVar);
                }
                this.a.Y5(str);
                this.a.B0.W1();
                if (this.a.J0.T0() != null) {
                    this.a.J0.T0().f0();
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
        public void onNavigationButtonClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e2 implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public e2(PbFragment pbFragment, MetaData metaData) {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                y45Var.dismiss();
                this.b.F0.i(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.B0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e3 implements i55.d {
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

        @Override // com.baidu.tieba.i55.d
        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.P0 != null) {
                this.a.P0.r(vp9.h(this.a.F2));
                ArrayList arrayList = new ArrayList();
                for (h55 h55Var : this.a.P0.g()) {
                    if (h55Var instanceof e55) {
                        arrayList.add((e55) h55Var);
                    }
                }
                vp9.f(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements gz6.b {
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

        @Override // com.baidu.tieba.gz6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    uk9.d();
                } else {
                    uk9.c();
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
            this.a.Z5();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.J0.e2() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.e6((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    /* loaded from: classes7.dex */
    public class f2 implements AbsListView.OnScrollListener {
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

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<tha> F;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.B0 != null && this.a.B0.r1() != null && this.a.J0 != null && this.a.J0.T0() != null) {
                this.a.J0.K2(absListView, i, i2, i3);
                if (this.a.e != null) {
                    this.a.e.q(absListView, i, i2, i3);
                }
                if (this.a.B0.g2() && (F = this.a.B0.r1().F()) != null && !F.isEmpty()) {
                    int y = ((i + i2) - this.a.J0.T0().y()) - 1;
                    aj9 r1 = this.a.B0.r1();
                    if (r1 == null) {
                        return;
                    }
                    if (r1.C() != null && r1.C().D1()) {
                        y--;
                    }
                    if (r1.D() != null && r1.D().D1()) {
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
                if (!wn9.A(this.a.f1) && wn9.A(i)) {
                    if (this.a.J0 != null) {
                        this.a.r0 = true;
                        this.a.J0.F0();
                        if (this.a.Y0 != null && !this.a.J0.e2()) {
                            this.a.J0.r3(this.a.Y0.z());
                        }
                        if (!this.a.J) {
                            this.a.r0 = true;
                            this.a.J0.j3();
                        }
                    }
                    if (!this.a.r) {
                        this.a.r = true;
                    }
                }
                if (this.a.J0 != null) {
                    this.a.J0.L2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.s == null) {
                    this.a.s = new zs5();
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
                    vfa.g().h(this.a.getUniqueId(), true);
                    this.a.N5(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f3 implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                PbFragment pbFragment = this.a;
                pbFragment.b = true;
                return pbFragment.W5(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements mm9.b {
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

        @Override // com.baidu.tieba.mm9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f17cb);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e40);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.J0.D0(str);
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
        public void a(cp9 cp9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, cp9Var) != null) || cp9Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, cp9Var.a()));
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
                if (this.a.J0 != null) {
                    this.a.J0.x2(agreeMessageData);
                }
                if (agreeData.agreeType == 2 && this.a.J0 != null && !cq9.g(this.a.B0.b)) {
                    this.a.J0.x4();
                    cq9.a(this.a.B0.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g2 implements Comparator<AdverSegmentData> {
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
    public class g3 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ItemCardHelper.l(this.a.getContext(), this.a.getUniqueId(), view2, (ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    y45Var.dismiss();
                    ((TbPageContext) this.a.h1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                y45Var.dismiss();
                aq9.a(this.a.getPageContext());
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
                        this.a.E7();
                        return;
                    } else {
                        this.a.c8();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.H6() != null) {
                this.a.H6().H2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h2 implements AntiHelper.k {
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

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h3 implements tk5 {
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

        @Override // com.baidu.tieba.tk5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ao9 ao9Var = this.a.N0;
                if (ao9Var != null && ao9Var.g() != null && this.a.N0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.N0.g().c());
                    if (this.a.J0 != null && this.a.J0.w1() != null && this.a.J0.w1().f() != null && this.a.J0.w1().f().z()) {
                        this.a.J0.w1().f().w(this.a.N0.h());
                    }
                    this.a.N0.b(true);
                    return true;
                }
                return !this.a.S5(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
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
                this.a.J0.z4(!this.a.N);
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
    public class i2 extends i9 {
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

        @Override // com.baidu.tieba.i9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, obj) != null) || !this.a.isAdded()) {
                return;
            }
            boolean z = false;
            if (obj != null) {
                switch (this.a.E0.getLoadDataMode()) {
                    case 0:
                        this.a.B0.W1();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.k6(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.J0.O0(1, dVar.a, dVar.b, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbFragment pbFragment = this.a;
                        pbFragment.l6(pbFragment.E0.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        this.a.J0.O0(this.a.E0.getLoadDataMode(), gVar.a, gVar.b, false);
                        this.a.J0.M2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.J0.O0(this.a.E0.getLoadDataMode(), false, null, false);
        }
    }

    /* loaded from: classes7.dex */
    public class j implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
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
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && !ListUtils.isEmpty(list) && this.a.J0 != null) {
                this.a.J0.R3(list);
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
    public class j1 implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                this.a.S6();
                e35 p1 = this.a.B0.p1();
                int t1 = this.a.J0.t1();
                if (t1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f1008);
                } else if (p1 != null && t1 > p1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f1008);
                } else {
                    this.a.J0.F0();
                    this.a.I8();
                    this.a.J0.M3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.B0.f3(this.a.J0.t1());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e40);
                    }
                    y45Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j2 implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) && y45Var != null) {
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class j3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<xn9> a;
        public WeakReference<PbFragment> b;

        public j3(xn9 xn9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(xn9Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                xn9 xn9Var = this.a.get();
                if (xn9Var != null) {
                    xn9Var.K1();
                }
                PbFragment pbFragment = this.b.get();
                if (pbFragment != null && CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        pbFragment.C8(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        xz7.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0e40);
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
                if (this.a.J0 != null && this.a.J0.w1() != null) {
                    vm9 w1 = this.a.J0.w1();
                    if (w1.j()) {
                        w1.h();
                        return true;
                    }
                }
                if (this.a.J0 != null && this.a.J0.r2()) {
                    this.a.J0.O1();
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
            aj9 r1 = this.a.B0.r1();
            if (r1.O().getPraise().getIsLike() == 1) {
                this.a.U8(0);
            } else {
                this.a.U8(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, r1.O()));
        }
    }

    /* loaded from: classes7.dex */
    public class k1 implements k3 {
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
                String valueOf = String.valueOf(this.a.B0.r1().V().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.B0.r1().k().getId(), this.a.B0.r1().k().getName(), this.a.B0.r1().O().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k2 implements z95.g {
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

        @Override // com.baidu.tieba.z95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.x6()) {
                    this.a.a.finish();
                }
                if (this.a.B0.q2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.J0.N0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                this.b.J0.k4();
                MessageManager.getInstance().sendMessage(this.a);
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 implements fp9.h {
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

        @Override // com.baidu.tieba.fp9.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.k8(z);
                if (this.a.J0.j1() != null && z) {
                    this.a.J0.z4(false);
                }
                this.a.J0.E2(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l1 implements i55.f {
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

        @Override // com.baidu.tieba.i55.f
        public void G0(i55 i55Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, i55Var, i, view2) == null) {
                if (this.a.O0 != null) {
                    this.a.O0.dismiss();
                }
                this.a.R8(i);
                if (i != -4) {
                    if (i != -3) {
                        if (i != -2) {
                            if (i != -1) {
                                if (i != 13) {
                                    switch (i) {
                                        case 1:
                                            if (this.a.m1 != null && !TextUtils.isEmpty(this.a.n1)) {
                                                if (this.a.p1 != null) {
                                                    ym5.a aVar = new ym5.a();
                                                    aVar.a = this.a.n1;
                                                    String str = "";
                                                    if (this.a.p1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.p1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.G5();
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
                                                    pbFragment.l1 = new co9(pbFragment.getPageContext());
                                                }
                                                this.a.l1.b(this.a.n1, this.a.m1.getImageByte());
                                                this.a.m1 = null;
                                                this.a.n1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            tha thaVar = this.a.F2;
                                            if (thaVar != null) {
                                                thaVar.S0();
                                                this.a.F2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.u7(view2);
                                            if (this.a.B0.r1().O() != null && this.a.B0.r1().O().getAuthor() != null && this.a.B0.r1().O().getAuthor().getUserId() != null && this.a.D0 != null) {
                                                nr9.F(2, wn9.u(this.a.B0.r1()), !this.a.D0.e(), this.a.B0);
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
                                                this.a.P6((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray2.put(R.id.tag_from, 0);
                                                    sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                    this.a.P5(sparseArray2);
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
                                                boolean K = this.a.e0().K(TbadkCoreApplication.getCurrentAccount());
                                                if (K) {
                                                    if (booleanValue2) {
                                                        this.a.J0.P2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, K);
                                                        return;
                                                    } else {
                                                        this.a.r8(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.J0.N2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                                    return;
                                                } else {
                                                    this.a.r8(sparseArray3, intValue, booleanValue);
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
                                                    this.a.P5(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                }
                                                this.a.J0.S2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.J0.N2(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            tha thaVar2 = (tha) sparseArray.get(R.id.tag_clip_board);
                                            if (thaVar2.p() == null) {
                                                return;
                                            }
                                            this.a.T5(thaVar2.p());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.B0 != null && this.a.B0.r1() != null) {
                                                this.a.a.U1(iqa.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.B0 != null && this.a.B0.r1() != null) {
                                    this.a.J0.S4(true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            if (view3 == null) {
                                return;
                            }
                            this.a.S7(view3);
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
                            this.a.S7(view4);
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
                    this.a.S7(view5);
                    if (view5 != null) {
                        if (sparseArray5 != null && (sparseArray5.get(R.id.tag_is_top_question) instanceof Boolean)) {
                            this.a.i8(((Boolean) sparseArray5.get(R.id.tag_is_top_question)).booleanValue());
                        }
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.S7(view6);
                if (view6 != null) {
                    view6.performClick();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l2 implements uk5 {
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

        @Override // com.baidu.tieba.uk5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements i55.f {
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

        @Override // com.baidu.tieba.i55.f
        public void G0(i55 i55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, i55Var, i, view2) == null) {
                if (this.e.O0 != null) {
                    this.e.O0.dismiss();
                }
                if (i == 0) {
                    this.e.J0.N2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.j1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.j1);
                    this.e.E8(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m1 implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                if (y45Var != null) {
                    y45Var.dismiss();
                }
                this.d.c6(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m2 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.x6()) {
                    this.a.a.finish();
                }
                if (this.a.B0.q2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.J0.N0();
                }
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
            ao9 ao9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ao9Var = this.a.N0) != null && ao9Var.g() != null) {
                if (!this.a.N0.g().e()) {
                    this.a.N0.b(false);
                }
                this.a.N0.g().l(false);
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
                    if (updateAttentionMessage.getOrginalMessage().getTag() == this.a.getUniqueId() && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().blockData, PbFragment.V2) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                        return;
                    }
                    return;
                }
                if (updateAttentionMessage.getData().isSucc) {
                    if (this.a.q6().t() != null && this.a.q6().t().getGodUserData() != null) {
                        this.a.q6().t().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.B0 != null && this.a.B0.r1() != null && this.a.B0.r1().O() != null && this.a.B0.r1().O().getAuthor() != null) {
                        this.a.B0.r1().O().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
                if (updateAttentionMessage.isAttention()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921760, 10));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n1 implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n2 implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.A2 && this.a.x6()) {
                    this.a.l7();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (this.a.J0 != null) {
                    this.a.J0.l3();
                }
                if (!this.a.f0 && this.a.J0 != null && this.a.J0.v0() && this.a.B0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.B0.L1());
                    statisticItem.param("fid", this.a.B0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.B0.W0()) {
                        i = 4;
                    } else if (this.a.B0.X0()) {
                        i = 3;
                    } else if (this.a.B0.Z0()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.f0 = true;
                }
                if (this.a.B0.o2(false)) {
                    this.a.J0.N3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (this.a.B0.r1() != null) {
                    this.a.J0.f3();
                }
                this.a.A2 = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements fn9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.fn9.b
        public void onSuccess(List<tha> list) {
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

        @Override // com.baidu.tieba.fn9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.J0.D4(str);
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
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.eq5
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
                this.a.J0.F0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.B0 != null && !this.a.B0.isLoading) {
                    this.a.I8();
                    this.a.J0.M3();
                    z = true;
                    if (this.a.B0.r1() != null && this.a.B0.r1().f != null && this.a.B0.r1().f.size() > i) {
                        int intValue = this.a.B0.r1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.B0.M1()).param("fid", this.a.B0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.B0.l3(intValue)) {
                            this.a.h = true;
                            this.a.J0.B3(true);
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class o2 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.B0 != null) {
                this.a.B0.loadData();
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
                    this.a.J0.r3(this.a.Y0.z());
                }
                this.a.J0.j3();
                this.a.J0.F0();
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
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.eq5
        /* renamed from: g */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                if (this.a.J0 != null && topToastEvent != null) {
                    new BdTopToast(this.a.getContext()).setIcon(topToastEvent.isSuccess()).setContent(topToastEvent.getContent()).show(this.a.J0.E1());
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class p1 implements hz4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.hz4.d
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

        @Override // com.baidu.tieba.hz4.c
        public void a(@NonNull String str) {
            tha X;
            rh5 b0;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("PbFragment", "收到H5通知，更新Pb数据：" + str);
                if (this.a.B0 == null) {
                    return;
                }
                this.a.B0.loadData();
                aj9 r1 = this.a.B0.r1();
                if (r1 != null && (X = r1.X()) != null && (b0 = X.b0()) != null && !b0.n()) {
                    hs5 hs5Var = new hs5();
                    hs5Var.t(b0);
                    String Q = r1.Q();
                    String l = r1.l();
                    if (r1.O() != null) {
                        i = r1.O().getThreadType();
                    } else {
                        i = 0;
                    }
                    hs5Var.w(Q, l, i, this.a.B0.K0(), this.a.B0.w1(), b0.d());
                    String x = hs5Var.x(b0.e());
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(NovelWebViewActivityConfig.KEY_IS_SHOW_TOAST_TIP, true);
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_ID, String.valueOf(b0.h()));
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_TID, hs5Var.i());
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_FID, hs5Var.e());
                    BrowserHelper.startWebActivity(this.a.getContext(), "", x, true, true, true, bundle);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921658, Boolean.TRUE));
                }
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
            this.a.B0.o3((UserPendantData) customResponsedMessage.getData());
            if (this.a.J0 != null && this.a.B0 != null) {
                this.a.J0.d3(this.a.B0.r1(), this.a.B0.K1(), this.a.B0.C1(), this.a.J0.A1());
            }
            if (this.a.J0 != null && this.a.J0.T0() != null) {
                this.a.J0.T0().f0();
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
            xn9 xn9Var = this.b.J0;
            xn9Var.P3("@" + this.a.getStringExtra("big_pic_type") + " ");
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
            this.c.A8(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class q2 implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ y45 c;
        public final /* synthetic */ PbFragment d;

        public q2(PbFragment pbFragment, MarkData markData, MarkData markData2, y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, y45Var};
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
            this.c = y45Var;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
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
                this.d.J8();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
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
                if (this.a.J0 == null) {
                    return;
                }
                if (booleanValue) {
                    this.a.J0.u4();
                } else {
                    this.a.J0.M1();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r0 implements Function0<ArrayList<cn>> {
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
        public ArrayList<cn> invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.J0 != null && this.a.J0.T0() != null) {
                    return this.a.J0.T0().v();
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
            this.c.A8(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class r2 implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ y45 b;
        public final /* synthetic */ PbFragment c;

        public r2(PbFragment pbFragment, MarkData markData, y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, y45Var};
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
            this.b = y45Var;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.J8();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.Y0 != null) {
                this.a.J0.r3(this.a.Y0.z());
            }
            this.a.J0.c4(false);
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
                if (this.a.J0 != null && this.a.J0.T0() != null) {
                    this.a.J0.T0().f0();
                    return null;
                }
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s1 implements i55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g55 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ PbFragment c;

        public s1(PbFragment pbFragment, g55 g55Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, g55Var, view2};
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
            this.a = g55Var;
            this.b = view2;
        }

        @Override // com.baidu.tieba.i55.f
        public void G0(i55 i55Var, int i, View view2) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, i55Var, i, view2) == null) {
                this.a.dismiss();
                PbModel pbModel = this.c.B0;
                if (this.b.getId() == R.id.obfuscated_res_0x7f091b60) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                nr9.L(i, pbModel, i2);
                if (this.c.B0.r1().f != null && this.c.B0.r1().f.size() > i) {
                    i = this.c.B0.r1().f.get(i).sort_type.intValue();
                }
                boolean l3 = this.c.B0.l3(i);
                this.b.setTag(Integer.valueOf(this.c.B0.I1()));
                if (!l3) {
                    return;
                }
                this.c.h = true;
                this.c.J0.B3(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ y45 b;
        public final /* synthetic */ PbFragment c;

        public s2(PbFragment pbFragment, MarkData markData, y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, y45Var};
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
            this.b = y45Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.J0 != null && this.c.J0.E1() != null) {
                    this.c.J0.E1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.a.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.J8();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                ih9 ih9Var = (ih9) customResponsedMessage.getData();
                int type = ih9Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (ih9Var.a() == null) {
                                this.a.U7(false, null);
                                return;
                            } else {
                                this.a.U7(true, (MarkData) ih9Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.k6((ForumManageModel.b) ih9Var.a(), false);
                    return;
                }
                this.a.V7((rj9) ih9Var.a());
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
                if (message.what == 2 && this.a.B0 != null && this.a.B0.c1()) {
                    this.a.q7();
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
                if (this.a.s0 && (view2 == this.a.J0.k.e || view2 == this.a.J0.k.f || view2.getId() == R.id.obfuscated_res_0x7f091b3c || view2.getId() == R.id.obfuscated_res_0x7f090b7b || view2.getId() == R.id.obfuscated_res_0x7f091f2a || view2.getId() == R.id.obfuscated_res_0x7f091ad4)) {
                    return;
                }
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.J0.p1()) {
                        this.a.w7();
                    }
                } else {
                    this.a.b8(view2);
                }
                if (view2 == this.a.J0.r1()) {
                    if (this.a.h || !this.a.B0.o2(true)) {
                        return;
                    }
                    this.a.h = true;
                    this.a.J0.N3();
                } else if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().F()) {
                    if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().u()) {
                        if (view2 == this.a.J0.k.h) {
                            if (!this.a.J0.u0(this.a.B0.e1())) {
                                BdUtilHelper.hideSoftKeyPad(this.a.a, this.a.J0.k.h);
                                this.a.a.finish();
                                return;
                            }
                            this.a.I8();
                            return;
                        } else if (view2 != this.a.J0.X0() && (this.a.J0.k.i() == null || (view2 != this.a.J0.k.i().G() && view2 != this.a.J0.k.i().H()))) {
                            if (view2 == this.a.J0.f1()) {
                                if (this.a.B0 != null) {
                                    BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), this.a.B0.r1().O().getTopicData().b());
                                    return;
                                }
                                return;
                            } else if (view2 != this.a.J0.k.e) {
                                if (view2 != this.a.J0.k.f) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f091afb) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091acf) {
                                            if ((this.a.J0.k.i() == null || view2 != this.a.J0.k.i().D()) && view2.getId() != R.id.obfuscated_res_0x7f090b7b && view2.getId() != R.id.obfuscated_res_0x7f091f2a) {
                                                if (this.a.J0.k.i() != null && view2 == this.a.J0.k.i().x()) {
                                                    this.a.J0.k.f();
                                                    return;
                                                } else if (view2.getId() == R.id.share_num_container) {
                                                    if (!wn9.c(this.a.getPageContext(), 11009)) {
                                                        return;
                                                    }
                                                    wn9.v(this.a.getContext(), 3, this.a.p6(), this.a.B0);
                                                    return;
                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f091ad4 && view2.getId() != R.id.share_more_container) {
                                                    if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().E()) {
                                                        if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().L()) {
                                                            if (this.a.J0.k.i() != null && view2 == this.a.J0.k.i().K()) {
                                                                if (this.a.B0 != null && this.a.B0.r1() != null && this.a.B0.r1().O() != null) {
                                                                    this.a.J0.k.f();
                                                                    TiebaStatic.log(new StatisticItem("c13062"));
                                                                    PbFragment pbFragment = this.a;
                                                                    pbFragment.P6(pbFragment.B0.r1().O().getFirstPostId());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().I()) {
                                                                if (this.a.J0.j1() != view2) {
                                                                    if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().z()) {
                                                                        if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().t()) {
                                                                            if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().y()) {
                                                                                if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f092337 && view2.getId() != R.id.obfuscated_res_0x7f091ae7 && view2.getId() != R.id.obfuscated_res_0x7f091960) {
                                                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091b52) {
                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091b50 && view2.getId() != R.id.obfuscated_res_0x7f091d3b && view2.getId() != R.id.obfuscated_res_0x7f091ae1) {
                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091ae5) {
                                                                                                if (view2 != this.a.J0.h1()) {
                                                                                                    if (this.a.J0.k.i() != null && view2 == this.a.J0.k.i().J()) {
                                                                                                        this.a.J0.k.g();
                                                                                                        this.a.J0.r4(this.a.I2);
                                                                                                        return;
                                                                                                    } else if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().C()) {
                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f09086b && view2.getId() != R.id.obfuscated_res_0x7f090b78) {
                                                                                                            if (view2.getId() != R.id.pb_u9_text_view) {
                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f091f2f && view2.getId() != R.id.cover_reply_content && view2.getId() != R.id.replybtn_top_right && view2.getId() != R.id.cover_reply_content_top_right) {
                                                                                                                    if (view2.getId() != R.id.pb_act_btn) {
                                                                                                                        if (view2.getId() != R.id.lottery_tail) {
                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091b15 && view2.getId() != R.id.obfuscated_res_0x7f091adc) {
                                                                                                                                if (view2.getId() != R.id.join_vote_tv) {
                                                                                                                                    if (view2.getId() != R.id.look_all_tv) {
                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f0916e9) {
                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f0916e8) {
                                                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f0927ad) {
                                                                                                                                                    if (view2.getId() == R.id.qq_share_container) {
                                                                                                                                                        if (!wn9.c(this.a.getPageContext(), 11009)) {
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        wn9.v(this.a.getContext(), 8, this.a.p6(), this.a.B0);
                                                                                                                                                        return;
                                                                                                                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f091960) {
                                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091ad1) {
                                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091b3c) {
                                                                                                                                                                if (view2.getId() != R.id.forum_name_text && view2.getId() != R.id.forum_enter_button_one && view2.getId() != R.id.forum_enter_button_two && view2.getId() != R.id.forum_enter_button_three) {
                                                                                                                                                                    if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                                                                                                                        nr9.J(2, this.a.B0);
                                                                                                                                                                        return;
                                                                                                                                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f091b64) {
                                                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091b7e) {
                                                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091030) {
                                                                                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f09102d) {
                                                                                                                                                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091ae9 && view2.getId() != R.id.obfuscated_res_0x7f091b4a) {
                                                                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f0927cc) {
                                                                                                                                                                                            return;
                                                                                                                                                                                        }
                                                                                                                                                                                        this.a.Y7(view2);
                                                                                                                                                                                        return;
                                                                                                                                                                                    }
                                                                                                                                                                                    this.a.O8(view2);
                                                                                                                                                                                    return;
                                                                                                                                                                                }
                                                                                                                                                                                this.a.K5(view2);
                                                                                                                                                                                return;
                                                                                                                                                                            }
                                                                                                                                                                            this.a.L5(view2);
                                                                                                                                                                            return;
                                                                                                                                                                        }
                                                                                                                                                                        this.a.W8(view2);
                                                                                                                                                                        return;
                                                                                                                                                                    } else {
                                                                                                                                                                        this.a.M8();
                                                                                                                                                                        return;
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                this.a.h6(view2);
                                                                                                                                                                return;
                                                                                                                                                            }
                                                                                                                                                            this.a.N8();
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        this.a.f6();
                                                                                                                                                        return;
                                                                                                                                                    } else {
                                                                                                                                                        this.a.i7(view2);
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                this.a.J7();
                                                                                                                                                return;
                                                                                                                                            }
                                                                                                                                            this.a.l7();
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        this.a.n7();
                                                                                                                                        return;
                                                                                                                                    }
                                                                                                                                    this.a.g7(view2);
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                                this.a.e7(view2);
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            this.a.L8(view2);
                                                                                                                            return;
                                                                                                                        }
                                                                                                                        this.a.p7(view2);
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    this.a.f7();
                                                                                                                    return;
                                                                                                                }
                                                                                                                this.a.I7(view2);
                                                                                                                return;
                                                                                                            }
                                                                                                            this.a.L7(view2);
                                                                                                            return;
                                                                                                        }
                                                                                                        this.a.K7(view2);
                                                                                                        return;
                                                                                                    } else {
                                                                                                        this.a.R6();
                                                                                                        return;
                                                                                                    }
                                                                                                }
                                                                                                this.a.U6();
                                                                                                return;
                                                                                            }
                                                                                            this.a.G7(view2);
                                                                                            return;
                                                                                        }
                                                                                        this.a.H7(view2);
                                                                                        return;
                                                                                    }
                                                                                    this.a.j6(view2);
                                                                                    return;
                                                                                }
                                                                                this.a.i6(view2);
                                                                                return;
                                                                            }
                                                                            this.a.d6();
                                                                            return;
                                                                        }
                                                                        this.a.J5();
                                                                        return;
                                                                    }
                                                                    this.a.n6();
                                                                    return;
                                                                }
                                                                this.a.N7();
                                                                return;
                                                            } else {
                                                                this.a.V5();
                                                                return;
                                                            }
                                                        }
                                                        this.a.Z7(view2);
                                                        return;
                                                    }
                                                    this.a.h7();
                                                    return;
                                                } else {
                                                    this.a.F7(view2);
                                                    return;
                                                }
                                            }
                                            this.a.a8(view2);
                                            return;
                                        }
                                        this.a.g6(view2);
                                        return;
                                    }
                                    this.a.L6();
                                    return;
                                }
                                this.a.y7();
                                return;
                            } else {
                                this.a.x7();
                                return;
                            }
                        } else {
                            this.a.r7(view2);
                            return;
                        }
                    }
                    this.a.M5();
                } else {
                    this.a.k7();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t2 implements cg<ImageView> {
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
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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
                    if (m05.c().g()) {
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
        @Override // com.baidu.tieba.cg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = m05.c().g();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.J0 != null && this.a.J0.T0() != null) {
                this.a.J0.T0().f0();
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
                        this.a.Y0.H(null, null);
                    }
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.J0 != null && this.a.J0.w1() != null && this.a.J0.w1().f() != null) {
                    this.a.J0.w1().f().I();
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
            this.a.B8((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes7.dex */
    public class u2 implements cg<GifView> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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
                if (m05.c().g()) {
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
        @Override // com.baidu.tieba.cg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = m05.c().g();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e26.a)) {
                e26.a aVar = (e26.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.M6(aVar.b);
                }
                e26.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v0 extends i9 {
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

        @Override // com.baidu.tieba.i9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v2 implements cg<TiebaPlusRecommendCard> {
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
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
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
        @Override // com.baidu.tieba.cg
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
        @Override // com.baidu.tieba.cg
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
            this.a.F8();
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
    public class w2 implements tk5 {
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

        @Override // com.baidu.tieba.tk5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ao9 ao9Var = this.a.N0;
                if (ao9Var != null && ao9Var.e() != null && this.a.N0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.N0.e().c());
                    if (this.a.Y0 != null && (this.a.Y0.y() || this.a.Y0.A())) {
                        this.a.Y0.w(false, this.a.N0.h());
                    }
                    this.a.N0.a(true);
                    return true;
                }
                return !this.a.S5(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            return invokeV.booleanValue;
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
    public class x0 implements vk9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.vk9.a
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

        @Override // com.baidu.tieba.vk9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091f50) {
                        if (this.a.d8(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09015a) {
                        if (motionEvent != null && motionEvent.getAction() == 1) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof tha)) {
                                return false;
                            }
                            tha thaVar = (tha) obj;
                            if (thaVar.getType() != tha.a1 && !TextUtils.isEmpty(thaVar.v()) && m05.c().g()) {
                                return this.a.z7(thaVar);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091ae6) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.G8((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.J0.i2() && view2.getId() == R.id.obfuscated_res_0x7f091b08) {
                            if (view2.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.tag_user_id)));
                            }
                            if (this.a.S0() != null && this.a.S0().b != null) {
                                this.a.S0().b.onClick(view2);
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
                        this.a.G8(sparseArray);
                    }
                }
                if (this.a.Y0 != null) {
                    this.a.J0.r3(this.a.Y0.z());
                }
                this.a.J0.j3();
                this.a.J0.F0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.vk9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                this.a.e6((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
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
            PbThreadPostView C1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                        if (this.a.J0 != null && (C1 = this.a.J0.C1()) != null && this.a.J0.m1() != null) {
                            this.a.J0.m1().removeHeaderView(C1);
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
    public class x2 implements cg<View> {
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
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
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
        @Override // com.baidu.tieba.cg
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
        @Override // com.baidu.tieba.cg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.H0());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                new BdTopToast(this.a.getContext()).setIcon(false).setContent(this.a.getString(R.string.novel_thread_mask_click_tip)).show((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y0 implements z45.c {
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

        @Override // com.baidu.tieba.z45.c
        public void a(z45 z45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, z45Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.Q0 = pbFragment.Q0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.Q0);
                    new bm9(this.a.B0.L1(), this.a.Q0, "1").start();
                    z45Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.Q0 = pbFragment2.Q0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.Q0);
                    new bm9(this.a.B0.L1(), this.a.Q0, "2").start();
                    z45Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.Q0 = pbFragment3.Q0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.Q0);
                    z45Var.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y1 implements PbModel.h {
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

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(aj9 aj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aj9Var) == null) {
                this.a.J0.d2(aj9Var);
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
            ft5 ft5Var = new ft5(i, z, responsedMessage, this.a.p, this.a.o, this.a.m, z2, 0L, 0L, j4);
            this.a.o = 0L;
            this.a.p = 0L;
            ft5Var.c();
            if (z2) {
                j3 = j4;
                ft5Var.B = j3;
                ft5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.B0 != null && this.a.B0.r1() != null && this.a.B0.r1().O() != null) {
                int threadType = this.a.B0.r1().O().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.M, "from_personalize")) {
                        bt5 bt5Var = new bt5();
                        bt5Var.F = 1;
                        bt5Var.a(1005);
                        bt5Var.D = j3;
                        bt5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.M, "from_frs")) {
                        ft5 ft5Var2 = new ft5();
                        ft5Var2.a(1000);
                        ft5Var2.D = j3;
                        ft5Var2.d(threadType);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, aj9 aj9Var, String str, int i4) {
            boolean z2;
            aj5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), aj9Var, str, Integer.valueOf(i4)}) == null) {
                if (this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907aa));
                }
                if (z && aj9Var != null && aj9Var.Y() == null && ListUtils.getCount(aj9Var.F()) < 1) {
                    this.a.B0.f3(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                    if (this.a.J0 != null) {
                        this.a.J0.v4();
                        return;
                    }
                    return;
                }
                if (this.a.g0) {
                    if (this.a.X() != null) {
                        this.a.X().y0();
                    }
                } else {
                    this.a.g0 = true;
                }
                this.a.g = true;
                if (this.a.J0 == null) {
                    return;
                }
                this.a.J0.L3();
                if (aj9Var == null || !aj9Var.s0()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.J0.E1());
                }
                this.a.J0.M1();
                int i5 = 0;
                if (this.a.J) {
                    this.a.J0.G1();
                } else if (!this.a.J0.h2()) {
                    this.a.J0.c4(false);
                }
                if (this.a.h) {
                    this.a.h = false;
                }
                if (i4 == 0 && aj9Var != null) {
                    this.a.R0 = true;
                }
                if (aj9Var != null) {
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.hideNetRefreshView(pbFragment2.J0.E1());
                    this.a.J0.V3();
                }
                ArrayList<tha> arrayList = null;
                String x1 = null;
                arrayList = null;
                if (z && aj9Var != null) {
                    ThreadData O = aj9Var.O();
                    if (O != null && O.isUgcThreadType()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = this.a;
                        pbFragment3.l8(pbFragment3.X0);
                    }
                    this.a.J0.w1().r(aj9Var);
                    this.a.J0.j4();
                    if (O != null && O.getCartoonThreadData() != null) {
                        this.a.T8(O.getCartoonThreadData());
                    }
                    if (this.a.Y0 != null) {
                        this.a.J0.r3(this.a.Y0.z());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(aj9Var.V().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(aj9Var.V().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(aj9Var.V().getBimg_end_time());
                    if (aj9Var.F() != null && aj9Var.F().size() >= 1 && aj9Var.F().get(0) != null) {
                        this.a.B0.R2(aj9Var.F().get(0).U());
                    } else if (aj9Var.Y() != null) {
                        this.a.B0.R2(aj9Var.Y().U());
                    }
                    if (this.a.Y0 != null) {
                        this.a.Y0.I(aj9Var.c());
                        this.a.Y0.J(aj9Var.k(), aj9Var.V());
                        this.a.Y0.l0(O);
                        this.a.Y0.K(this.a.B0.T0(), this.a.B0.L1(), this.a.B0.P0());
                        if (O != null) {
                            this.a.Y0.a0(O.isMutiForumThread());
                        }
                    }
                    if (this.a.D0 != null) {
                        this.a.D0.h(aj9Var.q());
                    }
                    PbFragment pbFragment4 = this.a;
                    if (aj9Var.r() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    pbFragment4.q = z2;
                    if (aj9Var.j0()) {
                        this.a.q = true;
                    }
                    this.a.J0.s3(this.a.q);
                    if (this.a.u0.f.size() > 0) {
                        aj9Var.T0(this.a.u0.f);
                    }
                    this.a.J0.n4(aj9Var, i2, i3, this.a.B0.K1(), i4, this.a.B0.a1());
                    this.a.J0.C4(aj9Var, this.a.B0.K1());
                    this.a.J0.K4(this.a.B0.U0());
                    AntiData c = aj9Var.c();
                    if (c != null) {
                        this.a.x = c.getVoice_message();
                        if (!StringUtils.isNull(this.a.x) && this.a.Y0 != null && this.a.Y0.a() != null && (o = this.a.Y0.a().o(6)) != null && !TextUtils.isEmpty(this.a.x)) {
                            ((View) o).setOnClickListener(this.a.I1);
                        }
                    }
                    if (!this.a.X && !ListUtils.isEmpty(this.a.B0.r1().F()) && !this.a.B0.f2()) {
                        this.a.X = true;
                        this.a.N5(false);
                    }
                    if (!TextUtils.isEmpty(this.a.U0)) {
                        PbFragment pbFragment5 = this.a;
                        wn9.F(pbFragment5, pbFragment5.B0.q1(), this.a.U0);
                        this.a.U0 = null;
                    } else if (!this.a.T0) {
                        if (!this.a.V0) {
                            if (!TextUtils.isEmpty(this.a.B0.h1())) {
                                zo9.f(this.a.getListView(), this.a.B0.h1());
                                this.a.B0.m2();
                            } else {
                                this.a.J0.i4();
                            }
                        } else {
                            this.a.V0 = false;
                            zo9.j(this.a.getListView());
                        }
                    } else {
                        this.a.T0 = false;
                        wn9.E(this.a);
                    }
                    this.a.B0.n2(aj9Var.k(), this.a.O1);
                    this.a.B0.r2(this.a.Q1);
                    if (this.a.a1 != null && O != null && O.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(O.getAuthor());
                        this.a.a1.setLikeUserData(attentionHostData);
                    }
                    if (this.a.B0 != null && this.a.B0.b2()) {
                        x1 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.J0 != null) {
                        x1 = this.a.J0.x1();
                    }
                    if (this.a.Y0 != null && !StringUtils.isNull(x1)) {
                        this.a.Y0.d0(TbSingleton.getInstance().getAdVertiComment(aj9Var.q0(), aj9Var.r0(), x1));
                    }
                    if (!this.a.R0 && ((i2 == 1 || i2 == 2) && this.a.J0 != null)) {
                        this.a.J0.Q0();
                    }
                } else if (str != null) {
                    if (!this.a.R0 && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6 || i2 == 9) {
                            if (i == 4) {
                                if (this.a.B0.G0() != null && !StringUtils.isNull(this.a.B0.G0().c)) {
                                    this.a.J0.M4(this.a.B0.G0());
                                } else {
                                    PbFragment pbFragment6 = this.a;
                                    pbFragment6.showNetRefreshView(pbFragment6.J0.E1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    x9a.a("pb", false);
                                    PbFragment pbFragment7 = this.a;
                                    pbFragment7.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0703cc));
                                }
                            } else {
                                PbFragment pbFragment8 = this.a;
                                pbFragment8.showNetRefreshView(pbFragment8.J0.E1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                x9a.a("pb", false);
                                PbFragment pbFragment9 = this.a;
                                pbFragment9.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment9.getContext(), R.dimen.obfuscated_res_0x7f0703cc));
                            }
                            this.a.J0.G1();
                            this.a.J0.F1();
                        }
                    } else {
                        this.a.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.B0.L1());
                            jSONObject.put("fid", this.a.B0.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                        hu6.b().b(new ke5(this.a.B0.L1()));
                    }
                    if (i != 0) {
                        EnterForePvThread enterForePvThread = new EnterForePvThread();
                        enterForePvThread.setOpType("2");
                        enterForePvThread.start();
                    }
                    if (i != -1) {
                        if (this.a.B0 != null && this.a.B0.r1() != null) {
                            arrayList = this.a.B0.r1().F();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).L() != 1)) {
                            this.a.J0.n3(this.a.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (this.a.c7()) {
                                this.a.J0.o3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1005));
                            } else {
                                this.a.J0.o3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1006));
                            }
                            this.a.J0.d2(this.a.B0.r1());
                        }
                    } else {
                        this.a.J0.n3("");
                    }
                    this.a.J0.M0();
                }
                if (aj9Var != null && aj9Var.m && this.a.m == 0) {
                    this.a.m = System.currentTimeMillis() - this.a.l;
                }
                if (this.a.a instanceof PbActivity) {
                    PbActivity pbActivity = (PbActivity) this.a.a;
                    if (aj9Var != null) {
                        i5 = aj9Var.f();
                    }
                    pbActivity.f2(i5, this.a.J0);
                }
                if (this.a.B0 != null && this.a.B0.r1() != null) {
                    this.a.B0.r1();
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
            wk5 wk5Var = new wk5();
            this.a.l8(wk5Var);
            PbFragment pbFragment = this.a;
            pbFragment.Y0 = (xk5) wk5Var.a(pbFragment.getContext());
            this.a.Y0.X(this.a.a.getPageContext());
            this.a.Y0.g0(this.a.o2);
            this.a.Y0.h0(this.a.c1);
            xk5 xk5Var = this.a.Y0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
            if (this.a.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.a.getIntent().getExtras();
            }
            xk5Var.B(pageContext, extras);
            this.a.Y0.a().F(true);
            this.a.J0.m3(this.a.Y0.a());
            if (!this.a.B0.e1()) {
                this.a.Y0.q(this.a.B0.L1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.Y0.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.B0.b2()) {
                this.a.Y0.d0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.J0 != null) {
                this.a.Y0.d0(this.a.J0.x1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y2 implements cg<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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
                this.a.t7();
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
            this.a.S8();
        }
    }

    /* loaded from: classes7.dex */
    public class z2 implements cg<ItemCardView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
        }

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
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
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
        @Override // com.baidu.tieba.cg
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
        V2 = new e1();
        W2 = new f();
    }

    public static PbFragment A7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return new PbFragment();
        }
        return (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public bg<GifView> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.L == null) {
                this.L = new bg<>(new u2(this), 20, 0);
            }
            return this.L;
        }
        return (bg) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h26
    /* renamed from: A6 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            xn9 xn9Var = this.J0;
            if (xn9Var == null) {
                return null;
            }
            return xn9Var.m1();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public int B6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.R2;
        }
        return invokeV.intValue;
    }

    public int C6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.Q2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.h26
    public bg<LinearLayout> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.D == null) {
                this.D = new bg<>(new c(this), 15, 0);
            }
            return this.D;
        }
        return (bg) invokeV.objValue;
    }

    @Nullable
    public final aj9 D6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                return pbModel.r1();
            }
            return null;
        }
        return (aj9) invokeV.objValue;
    }

    public xk5 E6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.Y0;
        }
        return (xk5) invokeV.objValue;
    }

    public void E7() {
        hg5 hg5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (hg5Var = this.j0) != null) {
            hg5Var.q();
        }
    }

    public fp9 F6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.e;
        }
        return (fp9) invokeV.objValue;
    }

    public tp9 G6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.u0;
        }
        return (tp9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            xn9 xn9Var = this.J0;
            if (xn9Var == null) {
                return 0;
            }
            return xn9Var.z1();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.i;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public xn9 H6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.J0;
        }
        return (xn9) invokeV.objValue;
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.k2();
        }
        return invokeV.booleanValue;
    }

    public final void I8() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && (voiceManager = this.i) != null) {
            voiceManager.stopPlay();
        }
    }

    public String J6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.V;
        }
        return (String) invokeV.objValue;
    }

    public final void J8() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.W1();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public bg<TbImageView> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (this.z == null) {
                this.z = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.z;
        }
        return (bg) invokeV.objValue;
    }

    public boolean R7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            hg5 hg5Var = this.j0;
            if (hg5Var != null && hg5Var.t()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ep9 S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.a.S0();
        }
        return (ep9) invokeV.objValue;
    }

    public void T6() {
        xn9 xn9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048662, this) == null) && (xn9Var = this.J0) != null) {
            xn9Var.I1();
            S6();
        }
    }

    @Override // com.baidu.tieba.h26
    public bg<TiebaPlusRecommendCard> V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            if (this.C == null) {
                this.C = new bg<>(new v2(this), 5, 0);
            }
            return this.C;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr9
    public PbModel.h W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.s2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.s0;
        }
        return invokeV.booleanValue;
    }

    public final void W6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.Q = likeModel;
            likeModel.setLoadDataCallBack(new v0(this));
        }
    }

    public final void W7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            hideNetRefreshView(this.J0.E1());
            x8();
            if (this.B0.s2()) {
                this.J0.M3();
            }
            this.J0.V3();
        }
    }

    @Override // com.baidu.tieba.rr9
    public PbModel X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.B0;
        }
        return (PbModel) invokeV.objValue;
    }

    public final void X6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            bq9 bq9Var = new bq9(getPageContext());
            bq9Var.m();
            this.b1 = bq9Var;
        }
    }

    @Override // com.baidu.tieba.h26
    public bg<RelativeLayout> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            bg<RelativeLayout> bgVar = new bg<>(new y2(this), 10, 0);
            this.E = bgVar;
            return bgVar;
        }
        return (bg) invokeV.objValue;
    }

    public boolean Z6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                return pbModel.W0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean a7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null && absPbActivity.J1() != null && this.a.J1().q1() == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h26
    public bg<FestivalTipView> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            if (this.H == null) {
                this.H = TbRichTextView.G(getContext(), R.dimen.M_H_X004);
            }
            return this.H;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public bg<ImageView> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            if (this.A == null) {
                this.A = new bg<>(new t2(this), 8, 0);
            }
            return this.A;
        }
        return (bg) invokeV.objValue;
    }

    public boolean c7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                return pbModel.U0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c8() {
        hg5 hg5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048701, this) == null) && (hg5Var = this.j0) != null) {
            hg5Var.x();
        }
    }

    @Override // com.baidu.tieba.h26
    public bg<View> d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            if (this.B == null) {
                this.B = new bg<>(new x2(this), 8, 0);
            }
            return this.B;
        }
        return (bg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr9
    public AbsPbActivity e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public bg<TextView> j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            if (this.y == null) {
                this.y = TbRichTextView.H(getContext(), 8);
            }
            return this.y;
        }
        return (bg) invokeV.objValue;
    }

    public AntiData o6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.r1() != null) {
                return this.B0.r1().c();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048755, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.d0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public gn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (gn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            W7();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048763, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    public tha q6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) {
            aj9 aj9Var = this.B0.G;
            if (aj9Var != null) {
                return aj9Var.X();
            }
            return null;
        }
        return (tha) invokeV.objValue;
    }

    public final void q7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048772, this) == null) {
            aj9 r12 = this.B0.r1();
            this.B0.h3(true);
            hw4 hw4Var = this.D0;
            if (hw4Var != null) {
                r12.L0(hw4Var.g());
            }
            this.J0.d2(r12);
        }
    }

    public int r6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) {
            return this.U2;
        }
        return invokeV.intValue;
    }

    public String s6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048778, this)) == null) {
            return this.M;
        }
        return (String) invokeV.objValue;
    }

    public void s7() {
        xn9 xn9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048779, this) != null) || (xn9Var = this.J0) == null) {
            return;
        }
        xn9Var.u2();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048785, this) == null) && (pbModel = this.B0) != null && !ei.isEmpty(pbModel.L1())) {
            super.taskStart();
        }
    }

    @Override // com.baidu.tieba.h26
    public bg<ItemCardView> v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048790, this)) == null) {
            if (this.F == null) {
                this.F = new bg<>(new z2(this), 10, 0);
            }
            return this.F;
        }
        return (bg) invokeV.objValue;
    }

    public PbInterviewStatusView.f w6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048794, this)) == null) {
            return this.x0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    public boolean x6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048797, this)) == null) {
            if (!this.c && this.Q2 == -1 && this.R2 == -1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean y6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048801, this)) == null) {
            return this.p2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean z6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048804, this)) == null) {
            return this.K;
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
        this.J0 = null;
        this.K0 = false;
        this.L0 = false;
        this.M0 = false;
        this.R0 = false;
        this.T0 = false;
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
        this.X1 = new vk9(new x0(this));
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
        this.w2 = new f2(this);
        this.x2 = new i2(this);
        this.y2 = new k2(this);
        this.z2 = new m2(this);
        this.B2 = new n2(this);
        this.C2 = 0;
        this.D2 = new a3(this);
        this.E2 = false;
        this.F2 = null;
        this.G2 = new b3(this);
        this.H2 = new c3(this);
        this.I2 = new d3(this);
        this.J2 = new f3(this);
        this.K2 = new g3(this);
        this.L2 = new a(this);
        this.M2 = new b(this);
        this.N2 = new d(this);
        this.O2 = new e(this);
        this.P2 = new g(this);
        this.Q2 = -1;
        this.R2 = -1;
        this.U2 = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e3, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0159, code lost:
        if ((r7.h1.a.getView().getTop() - r11.J0.k.a.getBottom()) < (r11.J0.h1.a.g.getHeight() + 10)) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f6() {
        PbModel pbModel;
        int top;
        boolean z3;
        boolean z4;
        xn9.g1 g1Var;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        nq9 nq9Var;
        PbReplyTitleViewHolder pbReplyTitleViewHolder2;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048711, this) == null) && this.J0.m1() != null && (pbModel = this.B0) != null && pbModel.r1() != null) {
            int firstVisiblePosition = this.J0.m1().getFirstVisiblePosition();
            int i4 = 0;
            View childAt = this.J0.m1().getChildAt(0);
            if (childAt == null) {
                top = 0;
            } else {
                top = childAt.getTop();
            }
            boolean x02 = this.B0.r1().x0();
            boolean m22 = this.J0.m2();
            if (firstVisiblePosition == 0 && top == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            wn9.f(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.B0.r1());
            if ((this.B0.r1().O() != null && this.B0.r1().O().getReply_num() <= 0) || (m22 && z3)) {
                nr9.O(1, 1);
                if (!checkUpIsLogin()) {
                    nr9.O(2, 1);
                    return;
                }
                P7();
                if (this.B0.r1().O().getAuthor() != null) {
                    nr9.y(2, this.B0);
                }
            } else {
                int equipmentHeight = (int) (BdUtilHelper.getEquipmentHeight(getContext()) * 0.6d);
                if (x02) {
                    xn9.g1 g1Var2 = this.J0.h1;
                    if (g1Var2 != null) {
                        PbReplyTitleViewHolder pbReplyTitleViewHolder3 = g1Var2.a;
                        if (pbReplyTitleViewHolder3 != null && pbReplyTitleViewHolder3.getView() != null) {
                            if (this.J0.h1.a.getView().getParent() != null) {
                            }
                        }
                    }
                    z4 = false;
                } else {
                    if (this.J0.u1() != null) {
                        if (this.J0.u1().getVisibility() == 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z4 && (g1Var = this.J0.h1) != null && (pbReplyTitleViewHolder = g1Var.a) != null && pbReplyTitleViewHolder.getView() != null && this.J0.h1.a.getView().getParent() != null && (nq9Var = (r7 = this.J0).k) != null && nq9Var.a != null) {
                        }
                    }
                    z4 = false;
                }
                if (!z4 && !m22) {
                    if (this.a0 > 0) {
                        if (this.J0.m1().getChildAt(this.a0) != null) {
                            this.J0.m1().D(this.a0, this.b0, 200);
                        } else {
                            this.J0.m1().setSelectionFromTop(this.a0, this.b0 + equipmentHeight);
                            this.J0.m1().smoothScrollBy(equipmentHeight, 500);
                        }
                    } else {
                        int d4 = zo9.d(getListView());
                        if (zo9.e(getListView()) != -1) {
                            d4--;
                        }
                        int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds100);
                        if (d4 < 0) {
                            d4 = (ListUtils.getCount(this.J0.m1().getData()) - 1) + this.J0.m1().getHeaderViewsCount();
                        } else {
                            i4 = dimens;
                        }
                        nq9 nq9Var2 = this.J0.k;
                        if (nq9Var2 != null && (navigationBar = nq9Var2.a) != null) {
                            i4 += navigationBar.getFixedNavHeight() - 10;
                        }
                        xn9.g1 g1Var3 = this.J0.h1;
                        if (g1Var3 != null && (pbReplyTitleViewHolder2 = g1Var3.a) != null && pbReplyTitleViewHolder2.getView() != null && this.J0.h1.a.getView().getParent() != null) {
                            this.J0.m1().D(d4, i4, 200);
                        } else {
                            this.J0.m1().setSelectionFromTop(d4, i4 + equipmentHeight);
                            this.J0.m1().smoothScrollBy(equipmentHeight, 500);
                        }
                    }
                } else {
                    this.a0 = firstVisiblePosition;
                    this.b0 = top;
                    if (firstVisiblePosition <= 3 && (firstVisiblePosition != 3 || top >= (-equipmentHeight))) {
                        this.J0.m1().D(0, 0, 500);
                    } else {
                        int i5 = -equipmentHeight;
                        this.J0.m1().setSelectionFromTop(0, i5);
                        this.J0.m1().smoothScrollBy(i5, 500);
                    }
                }
            }
            if (this.B0.r1().O() != null && this.B0.r1().O().getAuthor() != null) {
                nr9.y(2, this.B0);
            }
        }
    }

    @Override // com.baidu.tieba.rr9
    public void finish() {
        xn9 xn9Var;
        boolean z3;
        CardHListViewData p3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            xn9 xn9Var2 = this.J0;
            if (xn9Var2 != null) {
                xn9Var2.F0();
            }
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.r1() != null && !this.B0.r1().j0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.B0.r1().O().getId();
                if (this.B0.isShareThread() && this.B0.r1().O().originalThreadData != null) {
                    historyMessage.threadName = this.B0.r1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.B0.r1().O().getTitle();
                }
                if (this.B0.isShareThread() && !I0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.B0.r1().k().getName();
                }
                ArrayList<tha> F = this.B0.r1().F();
                xn9 xn9Var3 = this.J0;
                if (xn9Var3 != null) {
                    i4 = xn9Var3.d1();
                } else {
                    i4 = 0;
                }
                if (F != null && i4 >= 0 && i4 < F.size()) {
                    historyMessage.postID = F.get(i4).U();
                }
                historyMessage.isHostOnly = this.B0.U0();
                historyMessage.isSquence = this.B0.K1();
                historyMessage.isShareThread = this.B0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            PbModel pbModel2 = this.B0;
            if (pbModel2 != null && (pbModel2.W0() || this.B0.Z0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.B0.L1());
                if (this.K0) {
                    if (this.M0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.B0.f1());
                    }
                    if (this.L0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.B0.b1());
                    }
                }
                if (this.B0.Z0() && this.B0.r1() != null && this.B0.r1().O() != null) {
                    hu6.b().b(new kl5(this.B0.P()));
                }
                if (this.B0.r1() != null && System.currentTimeMillis() - this.n >= 40000 && (p3 = this.B0.r1().p()) != null && !ListUtils.isEmpty(p3.getDataList())) {
                    intent.putExtra("guess_like_data", p3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.s1);
                }
                this.a.setResult(-1, intent);
            }
            if (K8()) {
                if (this.B0 != null && (xn9Var = this.J0) != null && xn9Var.m1() != null) {
                    aj9 r12 = this.B0.r1();
                    if (r12 != null) {
                        if (r12.V() != null) {
                            r12.V().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            r12.V().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!r12.s0() && !this.I && r12.h == null) {
                            on9 b4 = on9.b();
                            aj9 s12 = this.B0.s1();
                            Parcelable onSaveInstanceState = this.J0.m1().onSaveInstanceState();
                            boolean K1 = this.B0.K1();
                            boolean U0 = this.B0.U0();
                            if (this.J0.u1() != null && this.J0.u1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.l(s12, onSaveInstanceState, K1, U0, z3);
                            if (this.r1 >= 0 || this.B0.N1() != null) {
                                on9.b().o(this.B0.N1());
                                on9.b().p(this.B0.O1());
                                on9.b().m(this.B0.k1());
                            }
                        }
                    }
                } else {
                    on9.b().k();
                }
                J8();
            }
            bq9 bq9Var = this.b1;
            if (bq9Var != null && !bq9Var.o() && Q5() && this.B0.Z0() && !TextUtils.isEmpty(this.B0.P())) {
                this.b1.n(this.B0.r1().g().l, this.B0.P());
            }
        }
    }

    public void C5(i3 i3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, i3Var) == null) && i3Var != null) {
            if (this.t1 == null) {
                this.t1 = new ArrayList();
            }
            if (!this.t1.contains(i3Var)) {
                this.t1.add(i3Var);
            }
        }
    }

    public final void C8(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i4) == null) {
            cq9.i(this, p6(), i4);
        }
    }

    public void D5(i3 i3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, i3Var) == null) && i3Var != null) {
            if (this.t1 == null) {
                this.t1 = new ArrayList();
            }
            if (!this.t1.contains(i3Var)) {
                this.t1.add(0, i3Var);
            }
        }
    }

    public final void Q6(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, intent) == null) {
            cq9.f(this, intent);
        }
    }

    public final void T8(x15 x15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048664, this, x15Var) == null) && x15Var != null) {
            this.T2 = x15Var;
            this.c = true;
            this.J0.h3();
            this.J0.A3(this.S2);
        }
    }

    public void X7(i3 i3Var) {
        List<i3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048683, this, i3Var) == null) && i3Var != null && (list = this.t1) != null) {
            list.remove(i3Var);
        }
    }

    public final void Y7(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, view2) == null) {
            if (view2.getTag(R.id.tag_is_top_question) instanceof Boolean) {
                nr9.w(5);
            }
            i8(false);
            H8((tha) view2.getTag(R.id.tag_pb_top_replay_more), false);
        }
    }

    public final void g8(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048717, this, i4) == null) && this.B0 != null) {
            x8();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i4);
            privacySettingMessage.setTid(this.B0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void h8(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048722, this, i4) == null) {
            this.U2 = i4;
        }
    }

    public final void i7(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, view2) == null) {
            if (view2.getTag() instanceof SparseArray) {
                sparseArray = (SparseArray) view2.getTag();
            } else {
                sparseArray = null;
            }
            if (sparseArray == null) {
                return;
            }
            G8(sparseArray);
        }
    }

    public void i8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z3) == null) {
            this.p2 = Boolean.valueOf(z3);
        }
    }

    public final void j7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048728, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            BrowserHelper.startWebActivity(getContext(), "", str, false, true, true, bundle);
        }
    }

    public void j8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048729, this, z3) == null) {
            this.s0 = z3;
        }
    }

    public void k8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048732, this, z3) == null) {
            this.N = z3;
        }
    }

    public void n8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048742, this, z3) == null) {
            this.K = z3;
        }
    }

    public final void o8(boolean z3) {
        xk5 xk5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048745, this, z3) != null) || (xk5Var = this.Y0) == null) {
            return;
        }
        xk5Var.Y(z3);
        this.Y0.b0(z3);
        this.Y0.j0(z3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048748, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tieba.y45.e
    public void onClick(y45 y45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048750, this, y45Var) == null) {
            b6(y45Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.l9
    public void onPreLoad(gn gnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048760, this, gnVar) == null) {
            PreLoadImageHelper.load(gnVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(gnVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048762, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.B0.N2(bundle);
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            xk5 xk5Var = this.Y0;
            if (xk5Var != null) {
                xk5Var.G(bundle);
            }
        }
    }

    public final void u7(View view2) {
        SparseArray sparseArray;
        tha thaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048788, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (thaVar = (tha) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            v7(thaVar);
        }
    }

    @Override // com.baidu.tieba.as9.b
    public void y1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048800, this, z3) == null) {
            this.S0 = z3;
        }
    }

    @Override // com.baidu.tieba.h26
    public void M(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048627, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.u = true;
        }
    }

    @Override // com.baidu.tieba.h26
    public void P(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048642, this, context, str) == null) {
            do9.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.u = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        xn9 xn9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048757, this, i4, keyEvent)) == null) {
            if (keyEvent != null && (xn9Var = this.J0) != null) {
                return xn9Var.C2(i4);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.h26
    public void p0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048767, this, context, str) == null) {
            this.u = true;
        }
    }

    public final void A8(String str, String str2) {
        int i4;
        int dimens;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
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
            xn9 xn9Var = this.J0;
            if (xn9Var != null && xn9Var.m1() != null) {
                this.J0.m1().smoothScrollBy(i6, 50);
            }
            if (H6().w1() != null) {
                xk5 xk5Var = this.Y0;
                if (xk5Var != null) {
                    xk5Var.a().setVisibility(8);
                }
                PbModel pbModel2 = this.B0;
                H6().w1().t(str, str2, H6().x1(), (pbModel2 == null || pbModel2.r1() == null || this.B0.r1().O() == null || !this.B0.r1().O().isBjh()) ? false : false);
                al5 f4 = H6().w1().f();
                if (f4 != null && (pbModel = this.B0) != null && pbModel.r1() != null) {
                    f4.J(this.B0.r1().c());
                    f4.f0(this.B0.r1().O());
                }
                if (this.N0.f() == null && H6().w1().f().u() != null) {
                    H6().w1().f().u().g(new n(this));
                    this.N0.n(H6().w1().f().u().i());
                    H6().w1().f().P(this.e1);
                }
            }
            H6().G1();
        }
    }

    public final void k6(ForumManageModel.b bVar, boolean z3) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048730, this, bVar, z3) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i4 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                y45 y45Var = new y45(getPageContext().getPageActivity());
                y45Var.setMessage(string);
                y45Var.setPositiveButton(R.string.dialog_known, new j2(this));
                y45Var.setCancelable(true);
                y45Var.create(getPageContext());
                y45Var.show();
            } else if (bVar.d != 0) {
                this.J0.O0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i5 = bVar.d;
                if (i5 == 1) {
                    ArrayList<tha> F = this.B0.r1().F();
                    int size = F.size();
                    while (true) {
                        if (i4 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i4).U())) {
                            F.remove(i4);
                            break;
                        } else {
                            i4++;
                        }
                    }
                    this.B0.r1().O().setReply_num(this.B0.r1().O().getReply_num() - 1);
                    this.J0.d2(this.B0.r1());
                } else if (i5 == 0) {
                    U5();
                } else if (i5 == 2) {
                    ArrayList<tha> F2 = this.B0.r1().F();
                    int size2 = F2.size();
                    boolean z4 = false;
                    for (int i6 = 0; i6 < size2 && !z4; i6++) {
                        int i7 = 0;
                        while (true) {
                            if (i7 >= F2.get(i6).j0().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i6).j0().get(i7).U())) {
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
                        this.J0.d2(this.B0.r1());
                    }
                    X5(bVar, this.J0);
                }
            }
        }
    }

    public void B7() {
        List<i3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.t1) != null && !list.isEmpty()) {
            int size = this.t1.size();
            while (true) {
                size--;
                if (size <= -1 || this.t1.get(size).onBackPressed()) {
                    return;
                }
            }
        }
    }

    public final void C7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.J0.F0();
            if (this.h) {
                return;
            }
            I8();
            this.J0.M3();
            if (this.B0.loadData()) {
                this.J0.u4();
            }
        }
    }

    public final void F8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (pbModel = this.B0) != null && !ei.isEmpty(pbModel.L1())) {
            nt4.w().Q(mt4.Z, JavaTypesHelper.toLong(this.B0.L1(), 0L));
        }
    }

    public final boolean Q5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.r1() != null && this.B0.r1().g() != null && !TextUtils.isEmpty(this.B0.r1().g().l)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void R6() {
        TiebaPlusConfigData tiebaPlusConfigData;
        String jumpUrlWithTid;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048652, this) == null) && (tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData()) != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.B0.L1())) != null) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{jumpUrlWithTid});
            this.J0.k.f();
            TiebaPlusConfigData.addClickStatsForFireLink(3);
        }
    }

    public void S6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048658, this) == null) && this.a != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.a.getCurrentFocus() != null) {
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final boolean d7() {
        InterceptResult invokeV;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            if (dh9.c() && (pbModel = this.B0) != null && pbModel.r1() != null && this.B0.r1().i() != null && this.B0.r1().i().y() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void e8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048709, this) == null) && (pbModel = this.B0) != null && pbModel.r1() != null && this.B0.r1().O() != null && this.B0.r1().O().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void f8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048713, this) == null) && (pbModel = this.B0) != null && pbModel.r1() != null && this.B0.r1().O() != null && this.B0.r1().O().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public final int p6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) {
            if (this.B0.r1() != null && this.B0.r1().O() != null) {
                return this.B0.r1().O().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final boolean t8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048783, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel == null || !pbModel.K1()) {
                return false;
            }
            if (this.B0.p1() != null && this.B0.p1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void y8() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048803, this) == null) && pq9.b() && !this.J0.U2()) {
            hg5 showPushOpenView = PushOpenUtil.showPushOpenView(getPageContext(), "reply_pb", 0L);
            this.j0 = showPushOpenView;
            if (showPushOpenView != null) {
                q1a.e().h("reply_pb");
            }
        }
    }

    public final void z8() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048806, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && pq9.a() && !this.J0.U2()) {
            hg5 showPushOpenView = PushOpenUtil.showPushOpenView(getPageContext(), "collect", 0L);
            this.j0 = showPushOpenView;
            if (showPushOpenView != null) {
                q1a.e().h("collect");
            }
        }
    }

    public final void B8(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && X() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                X().z0(postWriteCallBackData.getPostId());
                int Z0 = this.J0.Z0();
                this.r1 = Z0;
                this.B0.Q2(Z0, this.J0.g1());
            }
            this.J0.F0();
            this.N0.c();
            xk5 xk5Var = this.Y0;
            if (xk5Var != null) {
                this.J0.r3(xk5Var.z());
            }
            this.J0.I1();
            this.J0.c4(true);
            this.B0.W1();
        }
    }

    public final void L8(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, view2) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
            String string2 = SharedPrefHelper.getInstance().getString("tail_link", "");
            String string3 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
            if (!StringUtils.isNull(string2)) {
                TiebaStatic.log("c10056");
                Context context = view2.getContext();
                BrowserHelper.startWebActivity(context, string, UtilHelper.urlAddParam(string2, "page_from=1&tailSkinId=" + string3), true, true, true);
            }
            this.J0.j3();
            TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string3));
        }
    }

    public final void P6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.r1() != null && this.B0.r1().j0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.B0.L1(), str);
                ThreadData O = this.B0.r1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                j7(format);
                return;
            }
            this.C0.a(str);
        }
    }

    public void T7(rj9 rj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, rj9Var) == null) {
            String U = rj9Var.g().U();
            List<tha> list = this.B0.r1().T().a;
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                tha thaVar = list.get(i4);
                if (thaVar.U() != null && thaVar.U().equals(U)) {
                    ArrayList<tha> i5 = rj9Var.i();
                    thaVar.q1(rj9Var.k());
                    if (thaVar.j0() != null) {
                        thaVar.j0().clear();
                        thaVar.j0().addAll(i5);
                    }
                } else {
                    i4++;
                }
            }
            if (!this.B0.a1()) {
                this.J0.d2(this.B0.r1());
            }
        }
    }

    public final void Y5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048685, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.B0) != null && pbModel.r1() != null) {
            sha z3 = this.B0.r1().z();
            if (z3 != null && str.equals(z3.E1())) {
                if (z3.getAdvertAppInfo() != null) {
                    z3.getAdvertAppInfo().h = null;
                }
                this.B0.r1().b();
            }
            sha J0 = this.B0.J0();
            if (J0 != null && str.equals(J0.E1())) {
                this.B0.w0();
            }
        }
    }

    public final void h6(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048720, this, view2) != null) || !(view2.getTag() instanceof ThreadData)) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        if (this.B0.q1() == 3 && I0() && this.B0.r1() != null && ListUtils.isEmpty(this.B0.r1().o())) {
            this.a.finish();
        } else {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
        nr9.A(threadData);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048749, this, i4) != null) || this.W == i4) {
            return;
        }
        super.onChangeSkinType(i4);
        this.J0.y2(i4);
        xk5 xk5Var = this.Y0;
        if (xk5Var != null && xk5Var.a() != null) {
            this.Y0.a().z(i4);
        }
        if (this.J0.a() != null) {
            this.J0.a().onChangeSkinType(getPageContext(), i4);
        }
        this.N0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i4, getResources(), R.color.CAM_X0201), true);
        this.W = i4;
        I8();
        hg5 hg5Var = this.j0;
        if (hg5Var != null) {
            hg5Var.w();
        }
    }

    public final void u8(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048789, this, metaData) != null) || metaData == null) {
            return;
        }
        y45 y45Var = new y45(getActivity());
        y45Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0c5c));
        y45Var.setTitleShowCenter(true);
        y45Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0c5d));
        y45Var.setMessageShowCenter(true);
        y45Var.setCancelable(false);
        y45Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0c5e), new d2(this, metaData));
        y45Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0c5f), new e2(this, metaData));
        y45Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void v7(tha thaVar) {
        boolean z3;
        tha q6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048792, this, thaVar) != null) || thaVar == null) {
            return;
        }
        if (thaVar.U() != null && thaVar.U().equals(this.B0.m1())) {
            z3 = true;
        } else {
            z3 = false;
        }
        MarkData l12 = this.B0.l1(thaVar);
        if (this.B0.r1() != null && this.B0.r1().j0() && (q6 = q6()) != null) {
            l12 = this.B0.l1(q6);
        }
        if (l12 == null) {
            return;
        }
        this.J0.M3();
        hw4 hw4Var = this.D0;
        if (hw4Var != null) {
            hw4Var.i(l12);
            if (!z3) {
                this.D0.a();
            } else {
                this.D0.d();
            }
        }
    }

    public void D7() {
        PbModel pbModel;
        aj9 r12;
        ThreadData O;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        aj9 aj9Var;
        boolean z8;
        boolean z9;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (pbModel = this.B0) != null && pbModel.r1() != null && (O = (r12 = this.B0.r1()).O()) != null && O.getAuthor() != null) {
            this.J0.I1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
            hn9 hn9Var = new hn9();
            int W = this.B0.r1().W();
            if (W != 1 && W != 3) {
                hn9Var.g = false;
            } else {
                hn9Var.g = true;
                if (O.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                hn9Var.s = z3;
            }
            if (wn9.y(this.B0.r1(), W)) {
                hn9Var.h = true;
                if (O.getIs_good() == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                hn9Var.r = z9;
            } else {
                hn9Var.h = false;
            }
            if (W == 1002 && !equals) {
                hn9Var.u = true;
            }
            hn9Var.n = wn9.J(O.isBlocked(), r12.n0(), equals, W, O.isWorksInfo(), O.isScoreThread());
            hn9Var.e = wn9.H(r12, equals, r12.n0(), this.B0.U());
            hn9Var.i = t8();
            hn9Var.f = wn9.I(this.B0.r1(), equals, this.B0.U());
            if (equals && r12.V() != null && r12.V().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            hn9Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                hn9Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            hn9Var.t = equals;
            hn9Var.q = this.B0.K1();
            hn9Var.b = true;
            hn9Var.a = wn9.B(this.B0.r1(), equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            hn9Var.p = z5;
            hn9Var.j = true;
            hn9Var.o = this.B0.U0();
            hn9Var.d = true;
            if (O.getThreadVideoInfo() == null) {
                z6 = true;
            } else {
                z6 = false;
            }
            hn9Var.c = z6;
            if (r12.j0()) {
                hn9Var.b = false;
                hn9Var.d = false;
                hn9Var.c = false;
                hn9Var.g = false;
                hn9Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !r12.j0()) {
                z7 = true;
            } else {
                z7 = false;
            }
            hn9Var.v = z7;
            if (this.J0 != null && (aj9Var = this.B0.G) != null) {
                tha X = aj9Var.X();
                if (X != null) {
                    z8 = X.f1164T;
                } else {
                    z8 = false;
                }
                hn9Var.w = z8;
            }
            hn9Var.m = true;
            if (O.isBlocked()) {
                hn9Var.n = false;
                hn9Var.g = false;
                hn9Var.h = false;
            }
            this.J0.k.x(hn9Var);
        }
    }

    public final void D8(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            if (str == null) {
                str = "";
            }
            BdPageContext bdPageContext = this.h1;
            if (bdPageContext == null) {
                return;
            }
            y45 y45Var = new y45(bdPageContext.getPageActivity());
            y45Var.setMessage(str);
            y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b59, new j(this));
            y45Var.create(this.h1).show();
        }
    }

    public final void G8(SparseArray<Object> sparseArray) {
        tha thaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof tha) || (thaVar = (tha) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        H8(thaVar, false);
    }

    public final void K5(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048618, this, view2) != null) || !(view2.getTag() instanceof ThreadData) || !checkUpIsLogin()) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        LikeModel likeModel = this.Q;
        if (likeModel != null) {
            likeModel.e0(threadData.getForum_name(), String.valueOf(threadData.getFid()));
        }
        nr9.I(threadData, 10, 11);
    }

    public final void M6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 4).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public final void O8(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048641, this, view2) != null) || this.s0) {
            return;
        }
        nr9.J(7, this.B0);
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray != null && (sparseArray.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_is_top_question)).booleanValue()) {
            nr9.w(6);
        }
        this.b = false;
        W5(view2);
    }

    public final void R8(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i4) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.B0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(vp9.n(i4))));
        }
    }

    public final void S7(View view2) {
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048659, this, view2) != null) || view2 == null) {
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

    public final void W8(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048679, this, view2) == null) && (view2.getTag() instanceof SmartApp)) {
            SmartApp smartApp = (SmartApp) view2.getTag();
            if (!TbAiappsLaunchUtil.launch(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                if (StringUtils.isNull(smartApp.h5_url)) {
                    return;
                }
                BrowserHelper.startWebActivity(getActivity(), smartApp.h5_url);
            }
            nr9.z(smartApp, this.B0);
        }
    }

    public final void m6(Rect rect) {
        xn9 xn9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048737, this, rect) == null) && rect != null && (xn9Var = this.J0) != null && xn9Var.D1() != null && rect.top <= this.J0.D1().getHeight()) {
            rect.top += this.J0.D1().getHeight() - rect.top;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048766, this, z3) == null) {
            super.onUserChanged(z3);
            this.J0.L4(z3);
            g55 g55Var = this.O0;
            if (g55Var != null) {
                g55Var.dismiss();
            }
            if (z3 && this.S0) {
                this.J0.N3();
                this.B0.o2(true);
            }
            if (this.J0.T0() != null) {
                this.J0.T0().j0(z3);
            }
        }
    }

    public final void E5() {
        PbModel pbModel;
        aj9 aj9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (pbModel = this.B0) != null && (aj9Var = pbModel.G) != null && aj9Var.O() != null) {
            ThreadData O = this.B0.G.O();
            O.mRecomAbTag = this.B0.x1();
            O.mRecomWeight = this.B0.A1();
            O.mRecomSource = this.B0.z1();
            O.mRecomExtra = this.B0.y1();
            O.isSubPb = this.B0.e1();
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(this.B0.getForumId(), 0L));
            }
            StatisticItem i4 = rs5.i(getContext(), O, "c13562");
            TbPageTag l3 = rs5.l(getContext());
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

    public final void J5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            SparseArray<Object> n12 = this.J0.n1(this.B0.r1(), this.B0.K1(), 1);
            if (n12 != null) {
                this.J0.Q2(((Integer) n12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(n12.get(R.id.tag_del_post_id)), ((Integer) n12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n12.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            this.J0.k.f();
            if (X() != null && X().r1() != null && X().r1().O() != null) {
                nr9.H(X().r1().O());
            }
        }
    }

    public final void M5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.J0.k.g();
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                this.v1.f(pbModel.L1());
            }
            int i4 = 1;
            PbModel pbModel2 = this.B0;
            if (pbModel2 != null && pbModel2.isPrivacy()) {
                showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (X() != null && X().r1() != null) {
                    this.v1.d(3, 3, X().r1().Q());
                    return;
                }
                return;
            }
            this.v1.b();
            if (!TbSingleton.getInstance().mCanCallFans && X() != null && X().r1() != null && X().r1().Q() != null && X().r1().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
                i4 = 2;
            }
            if (X() != null && X().r1() != null) {
                this.v1.d(3, i4, X().r1().Q());
            }
        }
    }

    public final void d6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048703, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            SparseArray<Object> n12 = this.J0.n1(this.B0.r1(), this.B0.K1(), 1);
            if (n12 != null) {
                if (StringUtils.isNull((String) n12.get(R.id.tag_del_multi_forum))) {
                    this.J0.N2(((Integer) n12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(n12.get(R.id.tag_del_post_id)), ((Integer) n12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n12.get(R.id.tag_del_post_is_self)).booleanValue());
                } else {
                    this.J0.O2(((Integer) n12.get(R.id.tag_del_post_type)).intValue(), (String) n12.get(R.id.tag_del_post_id), ((Integer) n12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n12.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(n12.get(R.id.tag_del_multi_forum)));
                }
            }
            this.J0.k.f();
        }
    }

    public final void f7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048712, this) == null) && this.B0.r1() != null && this.B0.r1().O() != null && this.B0.r1().O().getActUrl() != null) {
            BrowserHelper.startWebActivity(getActivity(), this.B0.r1().O().getActUrl());
            if (this.B0.r1().O().getActInfoType() == 1) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
            } else if (this.B0.r1().O().getActInfoType() == 2) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            this.f = true;
            super.onPause();
            zp9.a();
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
            xn9 xn9Var = this.J0;
            if (xn9Var != null) {
                xn9Var.F2();
            }
            if (this.Y0 != null && !this.B0.e1()) {
                this.Y0.O(this.B0.L1());
            }
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                pbModel.u2();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            nt4.w().E();
            MessageManager.getInstance().unRegisterListener(this.E1);
            e8();
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            hg5 hg5Var = this.j0;
            if (hg5Var != null) {
                hg5Var.q();
                this.j0.p();
            }
        }
    }

    public final void t7() {
        MarkData H0;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048782, this) == null) && this.D0 != null) {
            if (this.B0.r1() != null && this.B0.r1().j0()) {
                H0 = this.B0.H0(0);
            } else {
                H0 = this.B0.H0(this.J0.l1());
            }
            if (H0 == null) {
                return;
            }
            if (H0.isApp() && (H0 = this.B0.H0(this.J0.l1() + 1)) == null) {
                return;
            }
            this.J0.M3();
            this.D0.i(H0);
            if (!this.D0.e()) {
                if (this.J0 != null && (pbModel = this.B0) != null && !cq9.g(pbModel.b)) {
                    this.J0.x4();
                    cq9.a(this.B0.b);
                }
                this.D0.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.D0.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final void E8(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.J0.k4();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            y45 y45Var = new y45(this.h1.getPageActivity());
            if (!ei.isEmpty(str)) {
                y45Var.setMessage(str);
            } else {
                y45Var.setMessage(this.h1.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            y45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c4, new l(this, userMuteAddAndDelCustomMessage));
            y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new m(this));
            y45Var.create(this.h1).show();
        }
    }

    public final void F5(SparseArray<Object> sparseArray, List<e55> list, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str) {
        e55 e55Var;
        e55 e55Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{sparseArray, list, Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z7), str}) == null) {
            e55 e55Var3 = null;
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
                        e55 e55Var4 = new e55(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f054b), this.P0);
                        e55Var4.d.setTag(sparseArray2);
                        e55Var3 = e55Var4;
                    }
                } else {
                    sparseArray2.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                e55Var = new e55(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0324), this.P0);
                e55Var.d.setTag(sparseArray2);
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
                if (this.B0.r1().W() == 1002 && !z3) {
                    e55Var2 = new e55(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.P0);
                } else {
                    e55Var2 = new e55(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f054b), this.P0);
                }
                e55Var2.d.setTag(sparseArray3);
                e55Var3 = e55Var2;
                e55Var = null;
            } else {
                e55Var = null;
            }
            if (e55Var3 != null) {
                list.add(e55Var3);
            }
            if (e55Var != null) {
                list.add(e55Var);
            }
        }
    }

    public final void F7(View view2) {
        aj9 r12;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (r12 = this.B0.r1()) == null) {
                return;
            }
            ThreadData O = r12.O();
            if (O != null && O.getAuthor() != null) {
                nr9.y(4, this.B0);
            }
            PbModel pbModel = this.B0;
            AbsPbActivity e02 = e0();
            xn9 xn9Var = this.J0;
            int i5 = 6;
            if (view2.getId() == R.id.share_num_container) {
                i4 = 5;
            } else {
                i4 = 6;
            }
            nr9.P(pbModel, e02, xn9Var, i4);
            if (!BdUtilHelper.isNetOk()) {
                showToast(R.string.obfuscated_res_0x7f0f0e40);
            } else if (r12 == null) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1004));
            } else {
                ArrayList<tha> F = this.B0.r1().F();
                if ((F == null || F.size() <= 0) && this.B0.K1()) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1004));
                    return;
                }
                this.J0.F0();
                I8();
                if (r12.A() != null && !StringUtils.isNull(r12.A().a(), true)) {
                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.B0.r1().l()));
                }
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), O)) {
                    return;
                }
                xn9 xn9Var2 = this.J0;
                if (xn9Var2 != null) {
                    xn9Var2.H0();
                    this.J0.P4(r12);
                }
                if (ShareSwitch.isOn()) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091ad4) {
                        i5 = 2;
                    } else if (view2.getId() == R.id.share_num_container) {
                        i5 = 1;
                    }
                    if (this.J0.q2() && !r12.p0()) {
                        C8(i5);
                        return;
                    } else {
                        C8(i5);
                        return;
                    }
                }
                this.J0.k4();
                this.B0.L0().O(CheckRealNameModel.TYPE_PB_SHARE, 6);
            }
        }
    }

    public final void G7(View view2) {
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
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            String str = null;
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            tha thaVar = (tha) sparseArray.get(R.id.tag_clip_board);
            if (thaVar == null) {
                return;
            }
            if (this.P0 == null) {
                i55 i55Var = new i55(getContext());
                this.P0 = i55Var;
                i55Var.q(this.k2);
            }
            ArrayList arrayList = new ArrayList();
            if (X().r1() != null && X().r1().j0()) {
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
                if (thaVar.p() != null) {
                    boolean z10 = thaVar.p().hasAgree;
                    int q3 = thaVar.q();
                    if (z10 && q3 == 5) {
                        string = getString(R.string.action_cancel_dislike);
                    } else {
                        string = getString(R.string.action_dislike);
                    }
                    e55 e55Var = new e55(8, string, this.P0);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, thaVar);
                    e55Var.d.setTag(sparseArray2);
                    arrayList.add(e55Var);
                }
                if (this.mIsLogin) {
                    H5(z6, z5, sparseArray, arrayList, z4, z3, str2);
                    F5(sparseArray, arrayList, z4, z6, z7, z8, z9, str2);
                }
                this.P0.l(arrayList);
                g55 g55Var = new g55(getPageContext(), this.P0);
                this.O0 = g55Var;
                g55Var.l();
            }
        }
    }

    public final void H7(View view2) {
        StatisticItem statisticItem;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, view2) != null) || this.B0 == null) {
            return;
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f091b50) {
            nr9.J(6, this.B0);
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f091d3b) {
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                this.f1142T = view2;
                return;
            }
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091b50 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
            this.f1142T = view2;
            return;
        }
        if (!checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof tha)) {
            return;
        }
        tha thaVar = (tha) sparseArray.get(R.id.tag_load_sub_data);
        if (view2.getId() == R.id.obfuscated_res_0x7f091b50 && (statisticItem = thaVar.g0) != null) {
            StatisticItem copy = statisticItem.copy();
            copy.delete("obj_locate");
            copy.param("obj_locate", 8);
            TiebaStatic.log(copy);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091d3b || view2.getId() == R.id.obfuscated_res_0x7f091ae1) {
            nr9.C(this.B0, thaVar);
        }
        PbModel pbModel = this.B0;
        if (pbModel != null && pbModel.r1() != null && H6().v1() != null && thaVar.t() != null && thaVar.L() != 1) {
            if (H6().w1() != null) {
                H6().w1().g();
            }
            rj9 rj9Var = new rj9();
            rj9Var.v(this.B0.r1().k());
            rj9Var.z(this.B0.r1().O());
            rj9Var.x(thaVar);
            H6().v1().i0(rj9Var);
            H6().v1().setPostId(thaVar.U());
            o7(view2, thaVar.t().getUserId(), "", thaVar);
            xk5 xk5Var = this.Y0;
            if (xk5Var != null) {
                this.J0.r3(xk5Var.z());
            }
        }
    }

    public final void b8(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048697, this, view2) != null) || this.s0) {
            return;
        }
        nr9.J(1, this.B0);
        SparseArray sparseArray = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
        if (sparseArray != null && (sparseArray.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_is_top_question)).booleanValue()) {
            nr9.w(2);
        }
        nr9.O(1, 2);
        if (this.u) {
            this.u = false;
            nr9.O(20, 2);
            return;
        }
        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
        if (!(tbRichTextView.getTag() instanceof SparseArray)) {
            nr9.O(20, 2);
            return;
        }
        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
        if (!(obj instanceof tha)) {
            nr9.O(20, 2);
            return;
        }
        tha thaVar = (tha) obj;
        PbModel pbModel = this.B0;
        if (pbModel != null && pbModel.r1() != null && H6().v1() != null && thaVar.t() != null && thaVar.L() != 1) {
            if (!checkUpIsLogin()) {
                nr9.O(2, 2);
                return;
            } else if (thaVar.B0()) {
                return;
            } else {
                if (H6().w1() != null) {
                    H6().w1().g();
                }
                rj9 rj9Var = new rj9();
                rj9Var.v(this.B0.r1().k());
                rj9Var.z(this.B0.r1().O());
                rj9Var.x(thaVar);
                H6().v1().i0(rj9Var);
                H6().v1().setPostId(thaVar.U());
                o7(view2, thaVar.t().getUserId(), "", thaVar);
                TiebaStatic.log("c11743");
                nr9.b(this.B0.r1(), thaVar, thaVar.f0, 8, 1);
                xk5 xk5Var = this.Y0;
                if (xk5Var != null) {
                    this.J0.r3(xk5Var.z());
                    return;
                }
                return;
            }
        }
        nr9.O(20, 2);
    }

    public final void G5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.o1 != null) {
                ym5.b bVar = new ym5.b();
                bVar.a = this.o1.P();
                bVar.b = this.o1.N();
                bVar.c = String.valueOf(this.o1.Q());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.n1));
        }
    }

    public final void I6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (this.H0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.H0 = pollingModel;
                pollingModel.setDialogTime(t55.e);
            }
            this.H0.getData(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            SafeHandler.getInst().postDelayed(this.Y1, 10000L);
        }
    }

    public final void J7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && this.r1 >= 0) {
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                pbModel.M2();
            }
            if (this.B0 != null && this.J0.T0() != null) {
                this.J0.T0().n0(this.B0.r1(), false);
            }
            this.r1 = 0;
            if (this.B0 != null) {
                if (this.J0.m1() != null) {
                    this.J0.m1().setSelection(this.B0.k1());
                }
                this.B0.Q2(0, 0);
            }
        }
    }

    public final void L6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.J0.x3(true);
            this.J0.j3();
            if (this.h) {
                return;
            }
            this.h = true;
            this.J0.u4();
            I8();
            this.J0.M3();
            this.B0.j3(t6());
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
        }
    }

    public final void M8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048631, this) == null) && (pbModel = this.B0) != null && pbModel.r1() != null) {
            aj9 r12 = this.B0.r1();
            if (this.G0 == null) {
                this.G0 = new tj9(getPageContext());
            }
            long j4 = JavaTypesHelper.toLong(r12.Q(), 0L);
            long j5 = JavaTypesHelper.toLong(r12.l(), 0L);
            nr9.N("c13446", j5);
            registerListener(this.r2);
            this.G0.a(j4, j5);
        }
    }

    public final boolean O5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel == null || pbModel.r1() == null) {
                return false;
            }
            ThreadData O = this.B0.r1().O();
            AntiData c4 = this.B0.r1().c();
            if (!AntiHelper.b(getPageContext(), O) && !AntiHelper.d(getPageContext(), c4)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void P8() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048646, this) == null) && (absPbActivity = this.a) != null && absPbActivity.J1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.J1().L1()).param("topic_id", this.a.J1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.J1().P1()));
        }
    }

    public boolean R5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            if ((this.B0.r1() != null && (this.B0.r1().j0() || ThreadCardUtils.isSelf(this.B0.r1().O()))) || this.a1 == null || this.B0.r1() == null || this.B0.r1().c() == null) {
                return true;
            }
            return this.a1.checkPrivacyBeforeInvokeEditor(this.B0.r1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void S8() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048660, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.R(this.B0.getForumId()) && this.B0.r1() != null && this.B0.r1().k() != null) {
            boolean z3 = true;
            if (this.B0.r1().k().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.B0.E0().Q(this.B0.getForumId(), this.B0.L1());
            }
        }
    }

    public final void U5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            if (this.B0.W0() || this.B0.Z0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.B0.L1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.B0.L1()));
            if (K8()) {
                this.a.finish();
            }
        }
    }

    public final void V5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
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
            this.J0.k.g();
        }
    }

    public final boolean b7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            tha c4 = bj9.c(this.B0.r1(), this.B0.K1(), this.B0.C1());
            if (c4 != null && c4.t() != null && c4.t().getGodUserData() != null && c4.t().getGodUserData().getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            this.J0.F0();
            if (X().r1().g == 2) {
                showToast(R.string.hot_sort_jump_hint);
                return;
            }
            if (this.B0.p1() != null) {
                this.J0.y4(this.B0.p1(), this.i2);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
        }
    }

    public final void k7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.J0.F0();
            I8();
            this.J0.M3();
            this.J0.k4();
            if (this.J0.u1() != null) {
                this.J0.u1().setVisibility(8);
            }
            this.B0.f3(1);
            fp9 fp9Var = this.e;
            if (fp9Var != null) {
                fp9Var.x();
            }
        }
    }

    public final void l7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048734, this) == null) && this.T2 != null) {
            if (this.R2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f1002);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.T2.a(), this.R2, 0)));
                this.a.finish();
            }
        }
    }

    public final void n7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048741, this) == null) && this.T2 != null) {
            if (this.Q2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f1003);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.T2.a(), this.Q2, 0)));
                this.a.finish();
            }
        }
    }

    public final void v8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048793, this) == null) {
            y45 y45Var = new y45(getPageContext().getPageActivity());
            y45Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            y45Var.setPositiveButton(R.string.open_now, new h(this));
            y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new i(this));
            y45Var.create(this.h1).show();
        }
    }

    public final void w7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048795, this) == null) && getPageContext().getPageActivity() != null && this.B0 != null) {
            sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(getPageContext().getPageActivity(), this.B0.L1(), this.B0.d2(), this.B0.c2())));
            nr9.D(this.B0);
        }
    }

    public final void x8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048799, this) == null) {
            showLoadingView(this.J0.E1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d9));
            View attachedView = getLoadingView().getAttachedView();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
            layoutParams.addRule(3, this.J0.D1().getId());
            attachedView.setLayoutParams(layoutParams);
        }
    }

    public final void H5(boolean z3, boolean z4, SparseArray<Object> sparseArray, List<e55> list, boolean z5, boolean z6, String str) {
        boolean z7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4), sparseArray, list, Boolean.valueOf(z5), Boolean.valueOf(z6), str}) == null) {
            if (!vp9.j(this.B0) && !z3 && z4) {
                e55 e55Var = new e55(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0d1c), this.P0);
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
                e55Var.d.setTag(sparseArray2);
                list.add(e55Var);
                return;
            }
            if (wn9.B(this.B0.r1(), z5) && TbadkCoreApplication.isLogin()) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 && !z6) {
                e55 e55Var2 = new e55(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.P0);
                e55Var2.d.setTag(str);
                list.add(e55Var2);
            }
        }
    }

    public final void H8(tha thaVar, boolean z3) {
        PbModel pbModel;
        int i4;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, thaVar, z3) == null) {
            i8(false);
            if (thaVar == null || (pbModel = this.B0) == null || pbModel.r1() == null || thaVar.L() == 1) {
                return;
            }
            String L1 = this.B0.L1();
            String U = thaVar.U();
            if (this.B0.r1() != null) {
                i4 = this.B0.r1().W();
            } else {
                i4 = 0;
            }
            AbsPbActivity.e Q7 = Q7(U);
            if (Q7 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo m02 = thaVar.m0();
            AntiData c4 = this.B0.r1().c();
            if (thaVar.t() != null) {
                arrayList = thaVar.t().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(L1, U, "pb", true, false, null, false, null, i4, m02, c4, false, arrayList, 5).addBigImageData(Q7.a, Q7.b, Q7.g, Q7.j);
            addBigImageData.setKeyPageStartFrom(this.B0.q1());
            addBigImageData.setFromFrsForumId(this.B0.getFromForumId());
            addBigImageData.setWorksInfoData(this.B0.Q1());
            addBigImageData.setKeyFromForumId(this.B0.getForumId());
            addBigImageData.setBjhData(this.B0.I0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public final void N6(int i4, Intent intent) {
        fj5 fj5Var;
        fj5 fj5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048633, this, i4, intent) == null) {
            if (i4 == 0) {
                this.J0.I1();
                this.J0.w1().g();
                this.J0.c4(false);
            }
            this.J0.j3();
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
                if (editorType == 1 && this.J0.w1() != null && this.J0.w1().f() != null) {
                    al5 f4 = this.J0.w1().f();
                    f4.f0(this.B0.r1().O());
                    f4.D(writeData);
                    f4.g0(pbEditorData.getVoiceModel());
                    ej5 p3 = f4.a().p(6);
                    if (p3 != null && (fj5Var2 = p3.m) != null) {
                        fj5Var2.G(new si5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i4 == -1) {
                        f4.I();
                        return;
                    }
                    return;
                }
                return;
            }
            xk5 xk5Var = this.Y0;
            if (xk5Var != null) {
                xk5Var.M();
                this.Y0.n0(pbEditorData.getVoiceModel());
                this.Y0.C(writeData);
                ej5 p4 = this.Y0.a().p(6);
                if (p4 != null && (fj5Var = p4.m) != null) {
                    fj5Var.G(new si5(52, 0, pbEditorData.getVoiceModel()));
                }
                this.Y0.i0(pbEditorData.isShowCustomFigure());
                if (i4 == -1) {
                    this.Y0.H(null, null);
                }
            }
        }
    }

    public void a6(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048691, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(xn9.o2)).intValue();
            if (intValue == xn9.p2) {
                if (this.E0.f0()) {
                    return;
                }
                this.J0.F4();
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
                    this.E0.h0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.E0.i0(this.B0.r1().k().getId(), this.B0.r1().k().getName(), this.B0.r1().O().getId(), str, intValue3, intValue2, booleanValue, this.B0.r1().O().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == xn9.q2 || intValue == xn9.s2) {
                PbModel pbModel = this.B0;
                if (pbModel != null && pbModel.M0() != null) {
                    this.B0.M0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == xn9.q2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public void e6(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048707, this, i4, i5) == null) {
            TiebaStatic.log("c12181");
            xn9 xn9Var = this.J0;
            if (xn9Var != null && this.B0 != null) {
                if ((xn9Var == null || xn9Var.e2()) && this.B0.r1() != null && this.B0.r1().S() != null) {
                    xn9 xn9Var2 = this.J0;
                    if (xn9Var2 != null && xn9Var2.b1() != null && this.J0.b1().t()) {
                        return;
                    }
                    qj9 S = this.B0.r1().S();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!S.d() || S.a() != 2) && this.J0.T0() != null && this.J0.T0().B() != null) {
                        this.J0.T0().B().K(this.B0.L1(), this.B0.getFromForumId());
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

    public final void q8(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048773, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (H6() != null) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    String questionMsg = postWriteCallBackData.getQuestionMsg();
                    String questionExp = postWriteCallBackData.getQuestionExp();
                    if (postWriteCallBackData.getIconStampData() != null) {
                        kg5.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            gh9.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            gh9.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            gh9.e(getResources().getString(R.string.obfuscated_res_0x7f0f1496));
                            return;
                        } else {
                            gh9.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.B0.e1()) {
                antiData.setBlock_forum_name(this.B0.r1().k().getName());
                antiData.setBlock_forum_id(this.B0.r1().k().getId());
                antiData.setUser_name(this.B0.r1().V().getUserName());
                antiData.setUser_id(this.B0.r1().V().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void w8(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048796, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            g55 g55Var = this.O0;
            if (g55Var != null && g55Var.isShowing()) {
                this.O0.dismiss();
                this.O0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            i55 i55Var = new i55(getContext());
            i55Var.q(new m0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i4 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i4 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i4 == 1) {
                arrayList.add(new e55(0, getResources().getString(R.string.obfuscated_res_0x7f0f054b), i55Var));
            }
            if (z3) {
                arrayList.add(new e55(1, getResources().getString(R.string.un_mute), i55Var));
            } else {
                arrayList.add(new e55(1, getResources().getString(R.string.obfuscated_res_0x7f0f0d18), i55Var));
            }
            i55Var.l(arrayList);
            g55 g55Var2 = new g55(getPageContext(), i55Var);
            this.O0 = g55Var2;
            g55Var2.l();
        }
    }

    public final void I5(aj9 aj9Var, ArrayList<tha> arrayList) {
        List<tha> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048610, this, aj9Var, arrayList) == null) && aj9Var != null && aj9Var.T() != null && aj9Var.T().a != null && (list = aj9Var.T().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<tha> it = arrayList.iterator();
                while (it.hasNext()) {
                    tha next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            tha thaVar = (tha) it2.next();
                            if (thaVar != null && !TextUtils.isEmpty(next.U()) && !TextUtils.isEmpty(thaVar.U()) && next.U().equals(thaVar.U())) {
                                arrayList2.add(thaVar);
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

    public final void l6(int i4, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048733, this, i4, gVar) != null) || gVar == null) {
            return;
        }
        this.J0.O0(this.E0.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.K0 = true;
            if (i4 != 2 && i4 != 3) {
                if (i4 == 4 || i4 == 5) {
                    this.L0 = false;
                    this.M0 = true;
                }
            } else {
                this.L0 = true;
                this.M0 = false;
            }
            if (i4 == 2) {
                this.B0.r1().O().setIs_good(1);
                this.B0.U2(1);
            } else if (i4 == 3) {
                this.B0.r1().O().setIs_good(0);
                this.B0.U2(0);
            } else if (i4 == 4) {
                this.B0.r1().O().setIs_top(1);
                this.B0.V2(1);
            } else if (i4 == 5) {
                this.B0.r1().O().setIs_top(0);
                this.B0.V2(0);
            }
            this.J0.Q4(this.B0.r1(), this.B0.K1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.operation_failed);
        }
        BdUtilHelper.showToast(getPageContext().getPageActivity(), string);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I7(View view2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        e55 e55Var;
        boolean z11;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, view2) != null) || !checkUpIsLogin()) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c11740"));
        if (view2 != null && view2.getTag() != null) {
            SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
            tha thaVar = (tha) sparseArray.get(R.id.tag_load_sub_data);
            if (view2.getId() != R.id.replybtn_top_right && view2.getId() != R.id.cover_reply_content_top_right) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                TiebaStatic.log(new StatisticItem("c12006").param("tid", this.B0.b));
            }
            if (this.P0 == null) {
                i55 i55Var = new i55(getContext());
                this.P0 = i55Var;
                i55Var.q(this.k2);
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
            if (thaVar != null) {
                if (thaVar.f0() != null && thaVar.f0().toString().length() > 0) {
                    e55 e55Var2 = new e55(3, getString(R.string.obfuscated_res_0x7f0f04e5), this.P0);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, thaVar);
                    e55Var2.d.setTag(sparseArray2);
                    arrayList.add(e55Var2);
                }
                this.F2 = thaVar;
            }
            if (this.B0.r1().q()) {
                String u3 = this.B0.r1().u();
                if (thaVar != null && !ei.isEmpty(u3) && u3.equals(thaVar.U())) {
                    z10 = true;
                    if (!z10) {
                        e55Var = new e55(4, getString(R.string.remove_mark), this.P0);
                    } else {
                        e55Var = new e55(4, getString(R.string.obfuscated_res_0x7f0f0c5a), this.P0);
                    }
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.F2);
                    sparseArray3.put(R.id.tag_is_subpb, Boolean.FALSE);
                    e55Var.d.setTag(sparseArray3);
                    arrayList.add(e55Var);
                    if (this.mIsLogin) {
                        if (!vp9.j(this.B0) && !z6 && z5) {
                            e55 e55Var3 = new e55(5, getString(R.string.obfuscated_res_0x7f0f0d1c), this.P0);
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
                            e55Var.d.setTag(sparseArray4);
                            arrayList.add(e55Var3);
                        } else {
                            if (wn9.B(this.B0.r1(), z4) && TbadkCoreApplication.isLogin()) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z11) {
                                e55 e55Var4 = new e55(5, getString(R.string.report_text), this.P0);
                                e55Var4.d.setTag(str2);
                                arrayList.add(e55Var4);
                            }
                        }
                        F5(sparseArray, arrayList, z4, z6, z7, z8, z9, str2);
                    }
                    this.P0.l(arrayList);
                    g55 g55Var = new g55(getPageContext(), this.P0);
                    this.O0 = g55Var;
                    g55Var.l();
                }
            }
            z10 = false;
            if (!z10) {
            }
            SparseArray sparseArray32 = new SparseArray();
            sparseArray32.put(R.id.tag_clip_board, this.F2);
            sparseArray32.put(R.id.tag_is_subpb, Boolean.FALSE);
            e55Var.d.setTag(sparseArray32);
            arrayList.add(e55Var);
            if (this.mIsLogin) {
            }
            this.P0.l(arrayList);
            g55 g55Var2 = new g55(getPageContext(), this.P0);
            this.O0 = g55Var2;
            g55Var2.l();
        }
    }

    public final void i6(View view2) {
        String str;
        int i4;
        PbModel pbModel;
        aj9 aj9Var;
        tha X;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091960) {
                nr9.J(4, this.B0);
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f091ae7 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                this.S = view2;
            } else if (!checkUpIsLogin()) {
                nr9.v("c10517", this.B0.r1().l(), 3);
            } else {
                PbModel pbModel2 = this.B0;
                if (pbModel2 != null && pbModel2.r1() != null) {
                    this.J0.F0();
                    SparseArray sparseArray = (SparseArray) view2.getTag();
                    tha thaVar = (tha) sparseArray.get(R.id.tag_load_sub_data);
                    tha thaVar2 = (tha) sparseArray.get(R.id.tag_load_sub_reply_data);
                    View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
                    if (thaVar != null && view3 != null) {
                        boolean z3 = true;
                        if (thaVar.P() == 1) {
                            TiebaStatic.log(new StatisticItem("c12630"));
                        }
                        StatisticItem statisticItem = thaVar.g0;
                        if (statisticItem != null) {
                            StatisticItem copy = statisticItem.copy();
                            copy.delete("obj_locate");
                            if (view2.getId() == R.id.obfuscated_res_0x7f091960) {
                                copy.param("obj_locate", 6);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091ae7) {
                                copy.param("obj_locate", 8);
                            }
                            TiebaStatic.log(copy);
                        }
                        String L1 = this.B0.L1();
                        String U = thaVar.U();
                        if (thaVar2 != null) {
                            str = thaVar2.U();
                        } else {
                            str = "";
                        }
                        if (this.B0.r1() != null) {
                            i4 = this.B0.r1().W();
                        } else {
                            i4 = 0;
                        }
                        I8();
                        if (view2.getId() == R.id.obfuscated_res_0x7f091f2f) {
                            AbsPbActivity.e Q7 = Q7(U);
                            PbModel pbModel3 = this.B0;
                            if (pbModel3 != null && pbModel3.r1() != null && Q7 != null) {
                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(L1, U, "pb", true, false, null, true, null, i4, thaVar.m0(), this.B0.r1().c(), false, thaVar.t().getIconInfo(), 5).addBigImageData(Q7.a, Q7.b, Q7.g, Q7.j);
                                addBigImageData.setKeyPageStartFrom(this.B0.q1());
                                addBigImageData.setFromFrsForumId(this.B0.getFromForumId());
                                addBigImageData.setWorksInfoData(this.B0.Q1());
                                addBigImageData.setKeyFromForumId(this.B0.getForumId());
                                addBigImageData.setBjhData(this.B0.I0());
                                addBigImageData.setTiebaPlusData(this.B0.V(), this.B0.R(), this.B0.S(), this.B0.Q(), this.B0.W());
                                sendMessage(new CustomMessage(2002001, addBigImageData));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log("c11742");
                        AbsPbActivity.e Q72 = Q7(U);
                        if (thaVar != null && (pbModel = this.B0) != null && pbModel.r1() != null && Q72 != null) {
                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(L1, U, "pb", true, false, null, false, str, i4, thaVar.m0(), this.B0.r1().c(), false, thaVar.t().getIconInfo(), 5).addBigImageData(Q72.a, Q72.b, Q72.g, Q72.j);
                            if (!ei.isEmpty(str)) {
                                addBigImageData2.setHighLightPostId(str);
                                addBigImageData2.setKeyIsUseSpid(true);
                            }
                            addBigImageData2.setKeyFromForumId(this.B0.getForumId());
                            addBigImageData2.setTiebaPlusData(this.B0.V(), this.B0.R(), this.B0.S(), this.B0.Q(), this.B0.W());
                            addBigImageData2.setBjhData(this.B0.I0());
                            addBigImageData2.setKeyPageStartFrom(this.B0.q1());
                            addBigImageData2.setFromFrsForumId(this.B0.getFromForumId());
                            addBigImageData2.setWorksInfoData(this.B0.Q1());
                            if (this.J0 != null && (aj9Var = this.B0.G) != null && (X = aj9Var.X()) != null) {
                                if (!X.f1164T && !thaVar.f1164T) {
                                    z3 = false;
                                }
                                addBigImageData2.setMainPostMaskVisibly(z3);
                            }
                            if (this.B0.r1() != null && this.B0.r1().n() != null) {
                                addBigImageData2.setHasForumRule(this.B0.r1().n().has_forum_rule.intValue());
                            }
                            sendMessage(new CustomMessage(2002001, addBigImageData2));
                        }
                    }
                }
            }
        }
    }

    public void K6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (this.f) {
                this.O = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.B0.r1() != null && this.B0.r1().O() != null && this.B0.r1().O().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.B0.r1().O().getTaskInfoData().k(), this.B0.r1().O().getTaskInfoData().h(), this.B0.r1().O().getTaskInfoData().c(), this.B0.r1().O().getTaskInfoData().d(), this.B0.r1().O().getIs_top(), this.B0.r1().O().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final boolean K8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.r1() != null && this.B0.r1().j0()) {
                return true;
            }
            if (this.B0.c1()) {
                MarkData N0 = this.B0.N0();
                if (N0 == null || !this.B0.a1()) {
                    return true;
                }
                MarkData H0 = this.B0.H0(this.J0.d1());
                if (H0 == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", N0);
                    this.a.setResult(-1, intent);
                    return true;
                } else if (H0.getPostId() != null && !H0.getPostId().equals(N0.getPostId())) {
                    y45 y45Var = new y45(getPageContext().getPageActivity());
                    y45Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0299));
                    y45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c4, new q2(this, H0, N0, y45Var));
                    y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new r2(this, N0, y45Var));
                    y45Var.setOnCalcelListener(new s2(this, N0, y45Var));
                    y45Var.create(getPageContext());
                    y45Var.show();
                    return false;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", N0);
                    this.a.setResult(-1, intent2);
                    return true;
                }
            }
            if (this.B0.r1() != null && this.B0.r1().F() != null && this.B0.r1().F().size() > 0 && this.B0.a1()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void N8() {
        PbModel pbModel;
        String name;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && (pbModel = this.B0) != null && pbModel.r1() != null && this.B0.r1().k() != null && !ei.isEmpty(this.B0.r1().k().getName())) {
            if (this.B0.getErrorNo() == 4) {
                if (StringUtils.isNull(this.B0.Q0()) && this.B0.G0() != null) {
                    name = this.B0.G0().b;
                } else {
                    this.a.finish();
                    return;
                }
            } else {
                name = this.B0.r1().k().getName();
            }
            if (StringUtils.isNull(name)) {
                this.a.finish();
                return;
            }
            String Q0 = this.B0.Q0();
            if (this.B0.W0() && Q0 != null && Q0.equals(name)) {
                this.a.finish();
            } else {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(this.B0.r1().k().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            }
            nr9.B(this.B0);
        }
    }

    public final void Z5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.r1() != null) {
                sha z3 = this.B0.r1().z();
                if (z3 != null) {
                    if (z3.getAdvertAppInfo() != null) {
                        z3.getAdvertAppInfo().h = null;
                    }
                    this.B0.r1().b();
                }
                if (this.B0.J0() != null) {
                    this.B0.w0();
                }
                this.B0.W1();
            }
            if (this.B0.r1().F() != null) {
                Iterator<tha> it = this.B0.r1().F().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof sha) {
                        it.remove();
                    }
                }
            }
            if (this.J0.T0() != null && !ListUtils.isEmpty(this.J0.T0().v())) {
                wn9.d(this.J0.T0().v());
            }
            if (this.J0.m1() != null && !ListUtils.isEmpty(this.J0.m1().getData())) {
                wn9.d(this.J0.m1().getData());
            }
            if (this.J0.T0() != null) {
                this.J0.T0().f0();
            }
        }
    }

    public final void n6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.J0.F0();
            SparseArray<Object> n12 = this.J0.n1(this.B0.r1(), this.B0.K1(), 1);
            if (n12 == null) {
                return;
            }
            sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(getPageContext().getPageActivity(), this.B0.r1().k().getId(), this.B0.r1().k().getName(), this.B0.r1().O().getId(), StringUtils.string(this.B0.r1().V().getUserId()), StringUtils.string(n12.get(R.id.tag_forbid_user_name)), StringUtils.string(n12.get(R.id.tag_forbid_user_name_show)), StringUtils.string(n12.get(R.id.tag_forbid_user_post_id)), StringUtils.string(n12.get(R.id.tag_forbid_user_portrait)))));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048761, this) == null) {
            this.f = false;
            super.onResume();
            if (this.O) {
                this.O = false;
                K6();
            }
            if (b7()) {
                this.t = System.currentTimeMillis();
            } else {
                this.t = -1L;
            }
            xn9 xn9Var = this.J0;
            if (xn9Var != null && xn9Var.E1() != null) {
                if (!this.g) {
                    x8();
                } else {
                    hideLoadingView(this.J0.E1());
                }
                this.J0.I2();
            }
            if (this.j == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            xn9 xn9Var2 = this.J0;
            if (xn9Var2 != null) {
                noNetworkView = xn9Var2.a();
            }
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.update(false);
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.E1);
            this.S0 = false;
            f8();
            registerListener(this.Z1);
            registerListener(this.a2);
            registerListener(this.c2);
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.q1) {
                W7();
                this.q1 = false;
            }
            F8();
            ItemCardHelper.w(this.L2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                ei5.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048764, this) == null) {
            super.onStop();
            if (this.t > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.t;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.t = 0L;
            }
            if (H6().w1() != null) {
                H6().w1().n();
            }
            nq9 nq9Var = this.J0.k;
            if (nq9Var != null && !nq9Var.n()) {
                this.J0.k.r();
            }
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.r1() != null && this.B0.r1().k() != null && this.B0.r1().O() != null) {
                bi5.j().x(getPageContext().getPageActivity(), "pb", this.B0.r1().k().getId(), JavaTypesHelper.toLong(this.B0.r1().O().getId(), 0L));
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            vfa.g().h(getUniqueId(), false);
        }
    }

    public final String t6() {
        InterceptResult invokeV;
        ArrayList<tha> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048781, this)) == null) {
            PbModel pbModel = this.B0;
            if (pbModel == null || pbModel.r1() == null || this.B0.r1().F() == null || (count = ListUtils.getCount((F = this.B0.r1().F()))) == 0) {
                return "";
            }
            if (this.B0.D1()) {
                Iterator<tha> it = F.iterator();
                while (it.hasNext()) {
                    tha next = it.next();
                    if (next != null && next.L() == 1) {
                        return next.U();
                    }
                }
            }
            int d12 = this.J0.d1();
            tha thaVar = (tha) ListUtils.getItem(F, d12);
            if (thaVar != null && thaVar.t() != null) {
                if (this.B0.l2(thaVar.t().getUserId())) {
                    return thaVar.U();
                }
                for (int i4 = d12 - 1; i4 != 0; i4--) {
                    tha thaVar2 = (tha) ListUtils.getItem(F, i4);
                    if (thaVar2 == null || thaVar2.t() == null || thaVar2.t().getUserId() == null) {
                        break;
                    } else if (this.B0.l2(thaVar2.t().getUserId())) {
                        return thaVar2.U();
                    }
                }
                for (int i5 = d12 + 1; i5 < count; i5++) {
                    tha thaVar3 = (tha) ListUtils.getItem(F, i5);
                    if (thaVar3 == null || thaVar3.t() == null || thaVar3.t().getUserId() == null) {
                        break;
                    } else if (this.B0.l2(thaVar3.t().getUserId())) {
                        return thaVar3.U();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void x7() {
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048798, this) == null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
            if (this.B0.r1() != null && this.B0.r1().O() != null && this.B0.r1().O().isVideoThreadType() && this.B0.r1().O().getThreadVideoInfo() != null) {
                TiebaStatic.log(new StatisticItem("c11922"));
            }
            if (this.B0.getErrorNo() == 4) {
                if (StringUtils.isNull(this.B0.Q0()) && this.B0.G0() != null) {
                    name = this.B0.G0().b;
                } else {
                    this.a.finish();
                    return;
                }
            } else {
                name = this.B0.r1().k().getName();
            }
            if (StringUtils.isNull(name)) {
                this.a.finish();
                return;
            }
            String Q0 = this.B0.Q0();
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
            if (this.B0.W0() && Q0 != null && Q0.equals(name)) {
                this.a.finish();
            } else {
                sendMessage(new CustomMessage(2003000, createNormalCfg));
            }
        }
    }

    public final void K7(View view2) {
        SparseArray sparseArray;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, view2) == null) && (sparseArray = (SparseArray) view2.getTag()) != null && (sparseArray.get(R.id.tag_load_sub_data) instanceof tha)) {
            tha thaVar = (tha) sparseArray.get(R.id.tag_load_sub_data);
            View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
            if (thaVar != null && view3 != null) {
                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09086c);
                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f09086d);
                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b78);
                boolean z3 = false;
                if (thaVar.D0()) {
                    thaVar.j1(false);
                    zp9.e(thaVar);
                } else {
                    if (X() != null) {
                        z3 = zp9.c(X().r1(), thaVar);
                    }
                    if (z3) {
                        thaVar.j1(true);
                    }
                }
                if (thaVar.D0()) {
                    i4 = R.color.CAM_X0201;
                } else {
                    i4 = R.color.transparent;
                }
                SkinManager.setBackgroundColor(findViewById, i4);
                boolean D0 = thaVar.D0();
                int i7 = R.color.CAM_X0304;
                if (D0) {
                    i5 = R.color.CAM_X0304;
                } else {
                    i5 = R.color.CAM_X0107;
                }
                SkinManager.setViewTextColor(eMTextView, i5);
                if (thaVar.D0()) {
                    i6 = R.drawable.icon_pure_pb_del_select;
                } else {
                    i6 = R.drawable.icon_pure_pb_del_normal;
                }
                if (!thaVar.D0()) {
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
    public final void T5(AgreeData agreeData) {
        ms5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048661, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.e0 == null) {
            this.e0 = new h95();
        }
        if (this.i0 == null) {
            AgreeMessageData agreeMessageData = new AgreeMessageData();
            this.i0 = agreeMessageData;
            agreeMessageData.uniqueId = getUniqueId();
        }
        h15 h15Var = new h15();
        h15Var.b = 5;
        h15Var.h = 8;
        h15Var.g = 2;
        if (X() != null) {
            h15Var.f = X().q1();
        }
        h15Var.a = 2;
        int i4 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                h15Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.e0.c(agreeData, i4, getUniqueId(), false);
                this.e0.d(agreeData, this.i0);
                pbModel = this.B0;
                if (pbModel == null && pbModel.r1() != null) {
                    this.e0.b(e0(), h15Var, agreeData, this.B0.r1().O());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            h15Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            h15Var.i = 1;
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

    public final void a8(View view2) {
        boolean j32;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                view2.setTag(Boolean.FALSE);
                return;
            }
            this.J0.F0();
            if (this.J0.k.i() != null && view2 == this.J0.k.i().D()) {
                this.J0.j3();
            }
            if (this.h) {
                view2.setTag(Boolean.FALSE);
                return;
            }
            I8();
            this.J0.M3();
            if (view2.getId() == R.id.obfuscated_res_0x7f090b7b) {
                j32 = this.B0.k3(true, t6());
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f2a) {
                j32 = this.B0.k3(false, t6());
            } else {
                j32 = this.B0.j3(t6());
            }
            view2.setTag(Boolean.valueOf(j32));
            if (j32) {
                this.J0.x3(true);
                this.J0.u4();
                this.h = true;
                this.J0.B3(true);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        aj9 r12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048746, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (H6() != null && wn9.C(this)) {
                H6().E4();
            }
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907aa));
            PbModel pbModel = this.B0;
            if (pbModel != null && (r12 = pbModel.r1()) != null) {
                this.s2.c(true, 0, 3, 0, r12, "", 1);
            }
            this.a.L1().k(this.t0);
            if (d7()) {
                AbsPbActivity absPbActivity = this.a;
                if (absPbActivity instanceof PbActivity) {
                    ((PbActivity) absPbActivity).g2();
                }
            }
            PbModel pbModel2 = this.B0;
            if (pbModel2 != null && this.G.b(pbModel2.G, getContext(), this.a.findViewById(this.J0.U0()), this.B0.getForumId(), this.B0.L1())) {
                AbsPbActivity absPbActivity2 = this.a;
                if (absPbActivity2 instanceof PbActivity) {
                    ((PbActivity) absPbActivity2).g2();
                }
            }
        }
    }

    public final void p7(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048769, this, view2) == null) && (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String)) {
            String string = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
            TiebaStatic.log(new StatisticItem("c10912").param("fid", this.B0.r1().l()).param("tid", this.B0.r1().Q()).param("lotterytail", StringUtils.string(string, "_", TbadkCoreApplication.getCurrentAccount())));
            if (this.B0.r1().Q().equals(string)) {
                this.J0.Q3(0);
            } else {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getActivity()).createNormalCfg(string, (String) null, (String) null, (String) null)));
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void L0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048622, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (e26[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), e26.class);
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (do9.c(objArr[i4].g()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    @Override // com.baidu.tieba.h26
    public void h0(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048719, this, context, str, z3) == null) {
            if (do9.c(str) && (pbModel = this.B0) != null && pbModel.L1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.B0.L1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    wh5 wh5Var = new wh5();
                    wh5Var.a = str;
                    wh5Var.b = 3;
                    wh5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, wh5Var));
                }
            } else {
                do9.a().e(getPageContext(), str);
            }
            this.u = true;
        }
    }

    public final void L5(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048623, this, view2) != null) || !(view2.getTag() instanceof ThreadData)) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
        createNormalCfg.setCallFrom(14);
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        nr9.I(threadData, 9, 9);
    }

    public final void L7(View view2) {
        l45 l45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, view2) == null) && checkUpIsLogin() && (l45Var = (l45) view2.getTag()) != null && !StringUtils.isNull(l45Var.D1())) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{l45Var.D1()});
        }
    }

    public void M7(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048630, this, animatorListener) == null) && this.J0 != null && (pbModel = this.B0) != null && pbModel.r1() != null && this.B0.r1().S() != null && checkUpIsLogin() && this.J0.T0() != null && this.J0.T0().B() != null) {
            this.J0.T0().B().U(animatorListener);
        }
    }

    public void P5(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.J0.k4();
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

    public final void Q8(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048650, this, z3) == null) && (absPbActivity = this.a) != null && absPbActivity.J1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.J1().L1()).param("topic_id", this.a.J1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.J1().P1()));
        }
    }

    public boolean S5(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048657, this, i4)) == null) {
            if (this.a1 != null && this.B0.r1() != null && !ThreadCardUtils.isSelf(this.B0.r1().O()) && this.B0.r1().c() != null) {
                return this.a1.checkPrivacyBeforeSend(this.B0.r1().c().replyPrivateFlag, i4);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void V6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, bundle) == null) {
            hw4 c4 = hw4.c(this.a);
            this.D0 = c4;
            if (c4 != null) {
                c4.j(this.v2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.E0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.x2);
            this.F0 = new ve5(getPageContext());
            I6();
            this.R1.setUniqueId(getUniqueId());
            this.R1.registerListener();
            X6();
        }
    }

    public final void e7(View view2) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048708, this, view2) == null) && view2 != null) {
            BrowserHelper.startWebActivity(getActivity(), StringUtils.string(view2.getTag()));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (p6() == 1 && (pbModel = this.B0) != null && pbModel.r1() != null) {
                nr9.E("c10397", this.B0.r1().l(), this.B0.r1().Q(), currentAccount);
            }
        }
    }

    public final void g7(View view2) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048716, this, view2) == null) && view2 != null) {
            String string = StringUtils.string(view2.getTag());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            BrowserHelper.startWebActivity(getActivity(), string);
            if (p6() == 1 && (pbModel = this.B0) != null && pbModel.r1() != null) {
                nr9.E("c10507", this.B0.r1().l(), this.B0.r1().Q(), currentAccount);
            }
        }
    }

    public final void l8(yk5 yk5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048735, this, yk5Var) == null) && yk5Var != null && (pbModel = this.B0) != null) {
            yk5Var.p(pbModel.Q0());
            if (this.B0.r1() != null && this.B0.r1().k() != null) {
                yk5Var.o(this.B0.r1().k());
            }
            yk5Var.q("pb");
            yk5Var.r(this.B0);
            yk5Var.s(PbNewEditorTool.InputShowType.REPLY);
        }
    }

    public final void m7(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048738, this, bundle) == null) {
            PbModel J1 = this.a.J1();
            this.B0 = J1;
            if (J1 != null) {
                if (J1.M0() != null) {
                    this.B0.M0().c(this.P2);
                }
                if (this.B0.n1() != null) {
                    this.B0.n1().f(this.x1);
                }
                if (StringUtils.isNull(this.B0.L1())) {
                    this.a.finish();
                } else if ("from_tieba_kuang".equals(this.M) && this.M != null) {
                    this.B0.Y2(6);
                }
            }
        }
    }

    public final void m8(int i4) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048739, this, i4) != null) || (pbModel = this.B0) == null) {
            return;
        }
        int B1 = pbModel.B1();
        if (i4 != 5) {
            if (i4 != 6) {
                if (i4 != 7) {
                    this.B0.b3(1);
                } else {
                    this.B0.b3(4);
                }
            } else {
                this.B0.b3(3);
            }
        } else {
            this.B0.b3(2);
        }
        int B12 = this.B0.B1();
        if (B1 == 4 || B12 == 4) {
            C7();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z3;
        xn9 xn9Var;
        nq9 nq9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048751, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (UtilHelper.isFoldScreen() && (xn9Var = this.J0) != null && (nq9Var = xn9Var.k) != null && nq9Var.n()) {
                this.J0.k.g();
                D7();
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
            xn9 xn9Var2 = this.J0;
            if (xn9Var2 != null) {
                xn9Var2.z2(configuration);
            }
            g55 g55Var = this.O0;
            if (g55Var != null) {
                g55Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public void s8(View view2) {
        aj9 D6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048780, this, view2) == null) {
            int i4 = SharedPrefHelper.getInstance().getInt(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb"), 0);
            AbsPbActivity absPbActivity = this.a;
            if ((absPbActivity == null || absPbActivity.getIntent() == null || !this.a.getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) || (i4 != 1 && i4 != 2 && i4 != 3)) && (D6 = D6()) != null) {
                wp9.d(getContext(), view2, D6);
            }
        }
    }

    public void N5(boolean z3) {
        xn9 xn9Var;
        int i4;
        int y3;
        tha thaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048632, this, z3) == null) && (xn9Var = this.J0) != null && xn9Var.m1() != null) {
            int firstVisiblePosition = this.J0.m1().getFirstVisiblePosition();
            int lastVisiblePosition = this.J0.m1().getLastVisiblePosition();
            gm9 T0 = this.J0.T0();
            if (T0 != null && this.B0.r1() != null) {
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
                        if (this.J0.m1().G(i4) != null && (this.J0.m1().G(i4) instanceof tha) && (thaVar = (tha) this.J0.m1().G(i4)) != null) {
                            tha thaVar2 = (tha) ListUtils.getItem(this.B0.r1().F(), thaVar.L() - 1);
                            if (thaVar.o() == null && thaVar2 != null) {
                                thaVar.O0(thaVar2.o());
                            }
                            if (thaVar.o() != null) {
                                thaVar.o().setFloonumber(thaVar.L());
                                arrayList.add(thaVar.o());
                            }
                        }
                        i4++;
                    }
                }
                if (ListUtils.getItem(arrayList, 0) != null) {
                    Collections.sort(arrayList, new g2(this));
                    AdverSegmentData adverSegmentData = (AdverSegmentData) ListUtils.getItem(arrayList, 0);
                    if (adverSegmentData != null && adverSegmentData.getFloonumber() == 1) {
                        if (!z3) {
                            this.J0.V2(adverSegmentData, 0);
                            return;
                        }
                        return;
                    }
                    this.J0.V2(adverSegmentData, 1);
                }
            }
        }
    }

    public final AbsPbActivity.e Q7(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, str)) == null) {
            String str2 = null;
            if (this.B0.r1() != null && this.B0.r1().F() != null && this.B0.r1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i4 = 0;
                while (true) {
                    if (i4 < this.B0.r1().F().size()) {
                        if (str.equals(this.B0.r1().F().get(i4).U())) {
                            break;
                        }
                        i4++;
                    } else {
                        i4 = 0;
                        break;
                    }
                }
                tha thaVar = this.B0.r1().F().get(i4);
                if (thaVar.f0() != null && thaVar.f0().O() != null) {
                    Iterator<TbRichTextData> it = thaVar.f0().O().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.U() != null) {
                                str2 = next.U().N();
                            }
                        }
                    }
                    O7(str2, 0, eVar);
                    bj9.b(thaVar, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void U8(int i4) {
        PbModel pbModel;
        ThreadData O;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048668, this, i4) != null) || (pbModel = this.B0) == null || pbModel.r1() == null || (O = this.B0.r1().O()) == null) {
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
        if (this.B0.K1()) {
            this.J0.T0().f0();
        } else {
            this.J0.T4(this.B0.r1());
        }
    }

    public void V7(rj9 rj9Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048672, this, rj9Var) != null) || rj9Var.g() == null) {
            return;
        }
        String U = rj9Var.g().U();
        ArrayList<tha> F = this.B0.r1().F();
        int i4 = 0;
        while (true) {
            z3 = true;
            if (i4 >= F.size()) {
                break;
            }
            tha thaVar = F.get(i4);
            if (thaVar.U() != null && thaVar.U().equals(U)) {
                ArrayList<tha> i5 = rj9Var.i();
                thaVar.q1(rj9Var.k());
                if (thaVar.j0() != null && i5 != null) {
                    Iterator<tha> it = i5.iterator();
                    while (it.hasNext()) {
                        tha next = it.next();
                        if (thaVar.s0() != null && next != null && next.t() != null && (metaData = thaVar.s0().get(next.t().getUserId())) != null) {
                            next.P0(metaData);
                            next.g1(true);
                            next.A1(getPageContext(), this.B0.l2(metaData.getUserId()));
                        }
                    }
                    if (i5.size() == thaVar.j0().size()) {
                        z3 = false;
                    }
                    if (!thaVar.z0(false)) {
                        thaVar.j0().clear();
                        thaVar.j0().addAll(i5);
                    }
                }
                if (thaVar.E() != null) {
                    thaVar.N0();
                }
            } else {
                i4++;
            }
        }
        if (!this.B0.a1() && z3) {
            this.J0.d2(this.B0.r1());
        }
        if (z3) {
            T7(rj9Var);
        }
    }

    public final void Z7(View view2) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, view2) == null) {
            this.J0.F0();
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.h) {
                view2.setTag(Integer.valueOf(this.B0.I1()));
            } else {
                I8();
                this.J0.M3();
                g55 g55Var = new g55(getPageContext());
                if (this.B0.r1().f == null || this.B0.r1().f.size() <= 0) {
                    strArr = new String[]{getResources().getString(R.string.sort_type_new), getResources().getString(R.string.sort_type_old)};
                } else {
                    strArr = new String[this.B0.r1().f.size()];
                    for (int i4 = 0; i4 < this.B0.r1().f.size(); i4++) {
                        strArr[i4] = this.B0.r1().f.get(i4).sort_name + getResources().getString(R.string.sort_static);
                    }
                }
                g55Var.i(null, strArr, new s1(this, g55Var, view2));
                g55Var.l();
            }
        }
    }

    public final boolean d8(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048705, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof tha)) {
                return false;
            }
            tha thaVar = (tha) obj;
            if (thaVar.getType() != tha.a1 && !TextUtils.isEmpty(thaVar.v()) && m05.c().g()) {
                return z7(thaVar);
            }
            if (!checkUpIsLogin()) {
                nr9.O(2, 2);
                return true;
            }
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.r1() != null) {
                if (H6().w1() != null) {
                    H6().w1().g();
                }
                rj9 rj9Var = new rj9();
                rj9Var.v(this.B0.r1().k());
                rj9Var.z(this.B0.r1().O());
                rj9Var.x(thaVar);
                H6().v1().i0(rj9Var);
                H6().v1().setPostId(thaVar.U());
                o7(view2, thaVar.t().getUserId(), "", thaVar);
                TiebaStatic.log("c11743");
                xk5 xk5Var = this.Y0;
                if (xk5Var != null) {
                    this.J0.r3(xk5Var.z());
                }
                return true;
            }
            nr9.O(20, 2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void g6(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.J0.F0();
            if (view2.getId() == R.id.obfuscated_res_0x7f091acf && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                this.U = view2;
            } else if (!wn9.c(getPageContext(), 11009) || this.B0.H0(this.J0.l1()) == null) {
            } else {
                t7();
                if (this.B0.r1() != null && this.B0.r1().O() != null && this.B0.r1().O().getAuthor() != null) {
                    nr9.y(3, this.B0);
                }
                if (this.B0.r1().O() != null && this.B0.r1().O().getAuthor() != null && this.B0.r1().O().getAuthor().getUserId() != null && this.D0 != null) {
                    nr9.F(1, wn9.u(this.B0.r1()), !this.D0.e(), this.B0);
                }
            }
        }
    }

    public final void r7(View view2) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048776, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.B0.r1() == null || this.E0.f0()) {
            } else {
                this.J0.F0();
                if (this.J0.k.i() != null && view2 == this.J0.k.i().H()) {
                    if (this.B0.r1().O().getIs_top() == 1) {
                        i4 = 5;
                    } else {
                        i4 = 4;
                    }
                } else if (this.J0.k.i() != null && view2 == this.J0.k.i().G()) {
                    if (this.B0.r1().O().getIs_good() == 1) {
                        i4 = 3;
                    } else {
                        i4 = 6;
                    }
                } else if (view2 == this.J0.X0()) {
                    i4 = 2;
                } else {
                    i4 = 0;
                }
                ForumData k4 = this.B0.r1().k();
                String name = k4.getName();
                String id = k4.getId();
                String id2 = this.B0.r1().O().getId();
                this.J0.F4();
                this.E0.j0(id, name, id2, i4, this.J0.Y0());
            }
        }
    }

    public final boolean z7(tha thaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048805, this, thaVar)) == null) {
            if (thaVar == null) {
                return false;
            }
            String U = thaVar.U();
            if (StringUtils.isNull(U) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String string = SharedPrefHelper.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = thaVar.o0().getJumpUrl();
            int packageId = thaVar.o0().getPackageId();
            int propsId = thaVar.o0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                BrowserHelper.startWebActivity(getPageContext().getPageActivity(), zia.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
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

    public final void N7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (this.J0.j1().getIndicateStatus()) {
                aj9 r12 = this.B0.r1();
                if (r12 != null && r12.O() != null && r12.O().getTaskInfoData() != null) {
                    String e4 = r12.O().getTaskInfoData().e();
                    if (StringUtils.isNull(e4)) {
                        e4 = r12.O().getTaskInfoData().h();
                    }
                    TiebaStatic.log(new StatisticItem("c11107").param("obj_id", e4));
                }
            } else {
                zha.d("c10725", null);
            }
            K6();
        }
    }

    public void P7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            if (!checkUpIsLogin()) {
                nr9.O(2, 1);
                return;
            }
            PbModel pbModel = this.B0;
            if (pbModel != null && pbModel.r1() != null && this.B0.r1().k() != null) {
                if (O5()) {
                    nr9.O(3, 1);
                    return;
                } else if (this.B0.r1().j0()) {
                    nr9.O(7, 1);
                    this.J0.w0();
                    return;
                } else {
                    xk5 xk5Var = this.Y0;
                    if (xk5Var != null && xk5Var.a() != null) {
                        this.Y0.a().D(new si5(45, 27, null));
                    }
                    this.J0.w0();
                    return;
                }
            }
            nr9.O(20, 1);
        }
    }

    public final void U6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048666, this) == null) && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            long j4 = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
            sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(getPageContext().getPageActivity(), 24008, JavaTypesHelper.toLong(this.B0.r1().l(), 0L), JavaTypesHelper.toLong(this.B0.L1(), 0L), j4, this.B0.r1().O().getPushStatusData())));
        }
    }

    public final void Y6() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048686, this) != null) || this.k != null) {
            return;
        }
        this.k = new z45(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        z45 z45Var = this.k;
        z45Var.j(strArr, new y0(this));
        z45Var.g(z45.b.a);
        z45Var.h(17);
        z45Var.c(getPageContext());
    }

    public final void y7() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048802, this) != null) || xw5.a()) {
            return;
        }
        PbModel pbModel = this.B0;
        if (pbModel != null && pbModel.r1() != null) {
            ArrayList<tha> F = this.B0.r1().F();
            if ((F == null || F.size() <= 0) && this.B0.K1()) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1004));
                return;
            }
            nr9.G(this.B0);
            this.J0.j3();
            D7();
            return;
        }
        BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1004));
    }

    public void O6(boolean z3, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
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
            E8(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void O7(String str, int i4, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048640, this, str, i4, eVar) != null) || eVar == null) {
            return;
        }
        aj9 r12 = this.B0.r1();
        TbRichText V8 = V8(str, i4);
        if (V8 == null || (tbRichTextData = V8.O().get(this.C2)) == null) {
            return;
        }
        eVar.f = String.valueOf(V8.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z3 = false;
        if (!tbRichTextData.U().S()) {
            eVar.h = false;
            String a4 = bj9.a(tbRichTextData);
            eVar.a.add(a4);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                if (this.q) {
                    i6 = 17;
                } else {
                    i6 = 18;
                }
                imageUrlData.urlType = i6;
            }
            imageUrlData.urlThumbType = imageUrlData.urlType;
            imageUrlData.imageThumbUrl = imageUrlData.imageUrl;
            imageUrlData.originalUrl = wn9.n(tbRichTextData);
            imageUrlData.originalUrl = wn9.n(tbRichTextData);
            imageUrlData.originalSize = wn9.o(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = wn9.k(tbRichTextData);
            imageUrlData.isLongPic = wn9.j(tbRichTextData);
            imageUrlData.postId = V8.getPostId();
            imageUrlData.mIsReserver = this.B0.D1();
            imageUrlData.mIsSeeHost = this.B0.U0();
            eVar.b.put(a4, imageUrlData);
            if (r12 != null) {
                if (r12.k() != null) {
                    eVar.c = r12.k().getName();
                    eVar.d = r12.k().getId();
                }
                if (r12.O() != null) {
                    eVar.e = r12.O().getId();
                }
                if (r12.r() == 1) {
                    z3 = true;
                }
                eVar.g = z3;
            }
            imageUrlData.threadId = JavaTypesHelper.toLong(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = r12.F().size();
        this.E2 = false;
        eVar.j = -1;
        if (r12.i() != null) {
            i5 = v6(r12.i().f0(), V8, i4, i4, eVar.a, eVar.b);
        } else {
            i5 = i4;
        }
        int i7 = i5;
        for (int i8 = 0; i8 < size; i8++) {
            tha thaVar = r12.F().get(i8);
            if (thaVar.U() == null || r12.i() == null || r12.i().U() == null || !thaVar.U().equals(r12.i().U())) {
                i7 = v6(thaVar.f0(), V8, i7, i4, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (r12 != null) {
            if (r12.k() != null) {
                eVar.c = r12.k().getName();
                eVar.d = r12.k().getId();
            }
            if (r12.O() != null) {
                eVar.e = r12.O().getId();
            }
            if (r12.r() == 1) {
                z3 = true;
            }
            eVar.g = z3;
        }
        eVar.j = i7;
    }

    public void U7(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048667, this, z3, markData) == null) {
            this.J0.L3();
            this.B0.h3(z3);
            hw4 hw4Var = this.D0;
            if (hw4Var != null) {
                hw4Var.h(z3);
                if (markData != null) {
                    this.D0.i(markData);
                }
            }
            if (this.B0.c1()) {
                q7();
            } else {
                this.J0.d2(this.B0.r1());
            }
        }
    }

    public final TbRichText V8(String str, int i4) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048673, this, str, i4)) == null) {
            PbModel pbModel = this.B0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.r1() == null || str == null || i4 < 0) {
                return null;
            }
            aj9 r12 = this.B0.r1();
            if (r12.i() != null) {
                ArrayList<tha> arrayList = new ArrayList<>();
                arrayList.add(r12.i());
                tbRichText = u6(arrayList, str, i4);
            }
            if (tbRichText == null) {
                ArrayList<tha> F = r12.F();
                I5(r12, F);
                return u6(F, str, i4);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void b6(y45 y45Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048695, this, y45Var, jSONArray) == null) {
            y45Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(y45Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                a6((SparseArray) y45Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final boolean W5(View view2) {
        InterceptResult invokeL;
        SparseArray<Object> sparseArray;
        hw4 hw4Var;
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
        e55 e55Var;
        e55 e55Var2;
        e55 e55Var3;
        e55 e55Var4;
        e55 e55Var5;
        e55 e55Var6;
        BdImage bdImage;
        SparseArray<Object> sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext())) {
                return true;
            }
            xn9 xn9Var = this.J0;
            if (xn9Var != null) {
                if (xn9Var.g2()) {
                    return true;
                }
                this.J0.P0();
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (wn9.x(view2)) {
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
                        this.J0.p4(this.H2, this.m1.isGif());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            SparseArray<Object> sparseArray3 = sparseArray;
            tha thaVar = (tha) sparseArray3.get(R.id.tag_clip_board);
            this.F2 = thaVar;
            if (thaVar == null) {
                return true;
            }
            if (thaVar.L() == 1 && wn9.x(view2)) {
                this.J0.p4(this.H2, this.m1.isGif());
                return true;
            } else if (this.F2.B0() || (hw4Var = this.D0) == null) {
                return true;
            } else {
                if (hw4Var.e() && this.F2.U() != null && this.F2.U().equals(this.B0.m1())) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (X().r1() != null && X().r1().j0()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (X().r1() != null && X().r1().p0()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (X().r1() != null && X().r1().o0()) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (this.F2.L() == 1) {
                    if (!z4) {
                        this.J0.q4(this.G2, z3, false, z5, z6);
                    }
                    return true;
                }
                if (this.P0 == null) {
                    i55 i55Var = new i55(getContext());
                    this.P0 = i55Var;
                    i55Var.q(this.k2);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 != null && sparseArray3 != null) {
                    if (wn9.x(view2) && !z4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (wn9.x(view2) && (bdImage = this.m1) != null && !bdImage.isGif()) {
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
                        arrayList.add(new e55(1, getString(R.string.save_to_emotion), this.P0));
                    }
                    if (z8) {
                        arrayList.add(new e55(2, getString(R.string.save_to_local), this.P0));
                    }
                    if (!z7 && !z8) {
                        e55 e55Var7 = new e55(3, getString(R.string.obfuscated_res_0x7f0f04e5), this.P0);
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_clip_board, this.F2);
                        e55Var7.d.setTag(sparseArray4);
                        arrayList.add(e55Var7);
                    }
                    if (!z9 && !z4) {
                        if (z3) {
                            e55Var6 = new e55(4, getString(R.string.remove_mark), this.P0);
                        } else {
                            e55Var6 = new e55(4, getString(R.string.obfuscated_res_0x7f0f0c5a), this.P0);
                        }
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.tag_clip_board, this.F2);
                        sparseArray5.put(R.id.tag_is_subpb, Boolean.FALSE);
                        e55Var6.d.setTag(sparseArray5);
                        arrayList.add(e55Var6);
                    }
                    if (this.mIsLogin) {
                        String str2 = str;
                        H5(z12, z11, sparseArray3, arrayList, z10, z4, str2);
                        if (z12) {
                            SparseArray sparseArray6 = new SparseArray();
                            sparseArray6.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                            sparseArray6.put(R.id.tag_manage_user_identity, sparseArray3.get(R.id.tag_manage_user_identity));
                            sparseArray6.put(R.id.tag_forbid_user_name, sparseArray3.get(R.id.tag_forbid_user_name));
                            sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray3.get(R.id.tag_forbid_user_name_show));
                            sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray3.get(R.id.tag_forbid_user_portrait));
                            sparseArray6.put(R.id.tag_forbid_user_post_id, str2);
                            sparseArray6.put(R.id.tag_mul_del_post_type, sparseArray3.get(R.id.tag_mul_del_post_type));
                            if (!vp9.j(this.B0) && z13) {
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
                                    e55Var5 = new e55(6, getString(R.string.obfuscated_res_0x7f0f054b), this.P0);
                                    e55Var5.d.setTag(sparseArray6);
                                    e55 e55Var8 = new e55(7, getString(R.string.obfuscated_res_0x7f0f0324), this.P0);
                                    e55Var8.d.setTag(sparseArray6);
                                    e55Var3 = e55Var5;
                                    e55Var2 = e55Var8;
                                    e55Var = null;
                                }
                            } else {
                                sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                            }
                            e55Var5 = null;
                            e55 e55Var82 = new e55(7, getString(R.string.obfuscated_res_0x7f0f0324), this.P0);
                            e55Var82.d.setTag(sparseArray6);
                            e55Var3 = e55Var5;
                            e55Var2 = e55Var82;
                            e55Var = null;
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
                            if (this.B0.r1().W() == 1002 && !z10) {
                                e55Var4 = new e55(6, getString(R.string.report_text), this.P0);
                            } else {
                                e55Var4 = new e55(6, getString(R.string.obfuscated_res_0x7f0f054b), this.P0);
                            }
                            e55Var4.d.setTag(sparseArray7);
                            if (z16) {
                                e55Var = new e55(13, getString(R.string.multi_delete), this.P0);
                                e55Var3 = e55Var4;
                            } else {
                                e55Var3 = e55Var4;
                                e55Var = null;
                            }
                            e55Var2 = null;
                        } else {
                            e55Var = null;
                            e55Var2 = null;
                            e55Var3 = null;
                        }
                        if (e55Var3 != null) {
                            arrayList.add(e55Var3);
                        }
                        if (e55Var != null) {
                            arrayList.add(e55Var);
                        }
                        if (e55Var2 != null) {
                            arrayList.add(e55Var2);
                        }
                        vp9.b(arrayList, this.P0, this.F2, this.B0);
                    }
                    List<e55> d4 = vp9.d(arrayList, this.F2.p(), sparseArray3, this.P0, this.F2.s());
                    vp9.m(d4, this.b);
                    vp9.f(d4);
                    this.P0.r(vp9.h(this.F2));
                    this.P0.m(d4, true);
                    this.O0 = new g55(getPageContext(), this.P0);
                    this.P0.p(new e3(this));
                    this.O0.l();
                    StatisticItem param = new StatisticItem("c13272").param("tid", this.B0.b).param("fid", this.B0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.B0.O());
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

    public void X5(ForumManageModel.b bVar, xn9 xn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048681, this, bVar, xn9Var) == null) {
            List<tha> list = this.B0.r1().T().a;
            int size = list.size();
            boolean z3 = false;
            for (int i4 = 0; i4 < size; i4++) {
                int i5 = 0;
                while (true) {
                    if (i5 >= list.get(i4).j0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i4).j0().get(i5).U())) {
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
                xn9Var.d2(this.B0.r1());
            }
        }
    }

    public void c6(int i4, String str, int i5, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048699, this, new Object[]{Integer.valueOf(i4), str, Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i5));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(xn9.o2, Integer.valueOf(xn9.p2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                a6(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void j6(View view2) {
        PbModel pbModel;
        int i4;
        aj9 aj9Var;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048727, this, view2) != null) || (pbModel = this.B0) == null) {
            return;
        }
        nr9.J(5, pbModel);
        if (view2.getId() == R.id.obfuscated_res_0x7f091b52 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
            this.S = view2;
        } else if (!checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
        } else {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof tha)) {
                return;
            }
            tha thaVar = (tha) sparseArray.get(R.id.tag_load_sub_data);
            StatisticItem statisticItem = thaVar.g0;
            if (statisticItem != null) {
                StatisticItem copy = statisticItem.copy();
                copy.delete("obj_locate");
                copy.param("obj_locate", 8);
                TiebaStatic.log(copy);
            }
            PbModel pbModel2 = this.B0;
            if (pbModel2 != null && pbModel2.r1() != null) {
                String L1 = this.B0.L1();
                String U = thaVar.U();
                if (this.B0.r1() != null) {
                    i4 = this.B0.r1().W();
                } else {
                    i4 = 0;
                }
                AbsPbActivity.e Q7 = Q7(U);
                if (Q7 == null) {
                    return;
                }
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(L1, U, "pb", true, false, null, false, null, i4, thaVar.m0(), this.B0.r1().c(), false, thaVar.t().getIconInfo(), 5).addBigImageData(Q7.a, Q7.b, Q7.g, Q7.j);
                addBigImageData.setKeyPageStartFrom(this.B0.q1());
                addBigImageData.setFromFrsForumId(this.B0.getFromForumId());
                addBigImageData.setWorksInfoData(this.B0.Q1());
                addBigImageData.setKeyFromForumId(this.B0.getForumId());
                addBigImageData.setTiebaPlusData(this.B0.V(), this.B0.R(), this.B0.S(), this.B0.Q(), this.B0.W());
                addBigImageData.setBjhData(this.B0.I0());
                if (this.B0.r1().n() != null) {
                    addBigImageData.setHasForumRule(this.B0.r1().n().has_forum_rule.intValue());
                }
                if (this.B0.r1().V() != null) {
                    addBigImageData.setIsManager(this.B0.r1().V().getIs_manager());
                }
                if (this.B0.r1().k().getDeletedReasonInfo() != null) {
                    addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.B0.r1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                    addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.B0.r1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                }
                if (this.B0.r1().k() != null) {
                    addBigImageData.setForumHeadUrl(this.B0.r1().k().getImage_url());
                    addBigImageData.setUserLevel(this.B0.r1().k().getUser_level());
                }
                if (this.J0 != null && (aj9Var = this.B0.G) != null) {
                    if (!aj9Var.X().f1164T && !thaVar.f1164T) {
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

    @Override // com.baidu.tieba.h26
    public void m0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048736, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.Q0 = str;
            if (this.k == null) {
                Y6();
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

    public final void p8(int i4, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048770, this, i4, antiData, str) == null) {
            if (AntiHelper.m(i4, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i4, new h2(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i4 == 230277) {
                D8(str);
            } else {
                this.J0.D4(str);
            }
        }
    }

    public final void o7(View view2, String str, String str2, tha thaVar) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048744, this, view2, str, str2, thaVar) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (O5()) {
                    nr9.O(3, 2);
                    return;
                } else if (!R5()) {
                    nr9.O(8, 2);
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.Y);
                        this.Z = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (H6().w1() != null && thaVar != null) {
                        if (thaVar.f0() != null) {
                            str3 = thaVar.f0().toString();
                        } else {
                            str3 = "";
                        }
                        H6().w1().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), thaVar.t().getName_show(), str3));
                    }
                    if (this.B0.r1() != null && this.B0.r1().j0()) {
                        SafeHandler.getInst().postDelayed(new q1(this, str, str2), 0L);
                        return;
                    } else {
                        SafeHandler.getInst().postDelayed(new r1(this, str, str2), 200L);
                        return;
                    }
                }
            }
            nr9.O(20, 2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048747, this, i4, i5, intent) == null) {
            super.onActivityResult(i4, i5, intent);
            xk5 xk5Var = this.Y0;
            if (xk5Var != null) {
                xk5Var.D(i4, i5, intent);
            }
            if (H6().w1() != null) {
                H6().w1().k(i4, i5, intent);
            }
            if (i4 == 25035) {
                N6(i5, intent);
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
                                                    xn9 xn9Var = this.J0;
                                                    if (xn9Var != null && xn9Var.W0() != null) {
                                                        this.J0.W0().performClick();
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
                                        this.J0.O3(false);
                                        if (this.B0.r1() != null && this.B0.r1().O() != null && this.B0.r1().O().getPushStatusData() != null) {
                                            this.B0.r1().O().getPushStatusData().setStatus(2);
                                            return;
                                        }
                                        return;
                                    }
                                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                        RateManager.getInstance().notifyShare(getPageContext());
                                        S8();
                                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.I0;
                                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.linkUrl) != null) {
                                            shareSuccessReplyToServerModel.M(str, intExtra, new p2(this));
                                        }
                                        if (a7()) {
                                            Q8(true);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                View view5 = this.R;
                                if (view5 != null) {
                                    this.J0.h4(view5);
                                    return;
                                }
                                return;
                            }
                            Q6(intent);
                            return;
                        }
                        RateManager.getInstance().notifyShare(getPageContext());
                        return;
                    }
                    on9.b().k();
                    this.y0.postDelayed(new o2(this), 1000L);
                    return;
                }
                t7();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        xn9 xn9Var;
        xn9 xn9Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, bundle) == null) {
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
                this.Q2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.R2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.S2 = intent.getStringExtra("key_manga_title");
                this.T0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.U0 = intent.getStringExtra("high_light_post_id");
                this.V0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (x6()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P = stringExtra;
                if (ei.isEmpty(stringExtra)) {
                    str = "";
                } else {
                    str = this.P;
                }
                this.P = str;
                this.s1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                p35 p35Var = new p35();
                this.c0 = p35Var;
                p35Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.u1 = intExtra;
                if (intExtra == 0) {
                    this.u1 = intent.getIntExtra("key_start_from", 0);
                }
                this.U2 = intent.getIntExtra(PbActivityConfig.KEY_FROM_CARD_TYPE, 0);
            } else {
                this.l = System.currentTimeMillis();
            }
            this.p = this.n - this.l;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.j = 0;
            m7(bundle);
            if (this.B0.r1() != null) {
                this.B0.r1().V0(this.P);
            }
            W6();
            if (intent != null && (xn9Var2 = this.J0) != null) {
                xn9Var2.e = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.k1 == null) {
                        this.k1 = new q0(this, intent);
                    }
                    SafeHandler.getInst().postDelayed(this.k1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.B0.r1() != null) {
                    this.B0.Z2(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.i = voiceManager;
            voiceManager.onCreate(getPageContext());
            V6(bundle);
            yk5 yk5Var = new yk5();
            this.X0 = yk5Var;
            l8(yk5Var);
            xk5 xk5Var = (xk5) this.X0.a(getActivity());
            this.Y0 = xk5Var;
            xk5Var.X(this.a.getPageContext());
            this.Y0.g0(this.o2);
            this.Y0.h0(this.c1);
            this.Y0.Z(1);
            this.Y0.B(this.a.getPageContext(), bundle);
            this.Y0.a().b(new dj5(getActivity()));
            this.Y0.a().F(true);
            o8(true);
            this.Y0.K(this.B0.T0(), this.B0.L1(), this.B0.P0());
            registerListener(this.B1);
            if (!this.B0.e1()) {
                this.Y0.q(this.B0.L1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.Y0.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.B0.b2()) {
                this.Y0.d0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                xn9 xn9Var3 = this.J0;
                if (xn9Var3 != null) {
                    this.Y0.d0(xn9Var3.x1());
                }
            }
            kk9 kk9Var = new kk9(this.a.getUniqueId(), new r0(this), new s0(this));
            this.f2 = kk9Var;
            registerListener(kk9Var.d());
            this.G = new PbGodGuideController();
            getLifecycle().addObserver(this.G);
            hz4.a().c(this.z0);
            hz4.a().c(this.A0);
            registerListener(this.A1);
            registerListener(this.C1);
            registerListener(this.D1);
            registerListener(this.z1);
            registerListener(this.d2);
            registerListener(this.e2);
            registerListener(this.u2);
            registerListener(this.y1);
            jha jhaVar = new jha("pb", jha.d);
            this.W0 = jhaVar;
            jhaVar.d();
            registerListener(this.J1);
            registerListener(this.T1);
            this.B0.v2();
            registerListener(this.t2);
            registerListener(this.h2);
            registerListener(this.n2);
            registerListener(this.P1);
            registerListener(this.g2);
            registerListener(this.K1);
            xn9 xn9Var4 = this.J0;
            if (xn9Var4 != null && xn9Var4.D1() != null && this.J0.B1() != null) {
                fp9 fp9Var = new fp9(getActivity(), this.J0.D1(), this.J0.B1(), this.J0.u1());
                this.e = fp9Var;
                fp9Var.t(this.S1);
            }
            if (this.c && (xn9Var = this.J0) != null && xn9Var.B1() != null) {
                this.J0.B1().setVisibility(8);
            }
            v95 v95Var = new v95();
            this.i1 = v95Var;
            v95Var.a = 1000L;
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
            this.W1 = new j3(this.J0, this);
            this.B0.L0().Q(this.W1);
            this.N0 = new ao9();
            if (this.Y0.s() != null) {
                this.N0.m(this.Y0.s().i());
            }
            this.Y0.W(this.d1);
            this.I0 = new ShareSuccessReplyToServerModel();
            C5(this.w1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.a1 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new u0(this));
            tq9 tq9Var = new tq9(getContext());
            this.C0 = tq9Var;
            tq9Var.b(getUniqueId());
            vfa.g().i(getUniqueId());
            w05.b().l("3", "");
            this.v1 = new lo6(getPageContext());
            this.u0 = new tp9(this, getUniqueId(), this.J0, this.B0);
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048753, this, layoutInflater, viewGroup, bundle)) == null) {
            this.J0 = new xn9(this, this.m2, this.X1, this.l2);
            gz6 gz6Var = new gz6(getActivity());
            this.d = gz6Var;
            gz6Var.i(W2);
            this.d.d(this.O2);
            this.J0.F3(this.w2);
            this.J0.E3(this.B2);
            this.J0.y3(this.y2);
            this.J0.z3(this.z2);
            this.J0.w3(m05.c().g());
            this.J0.C3(this.D2);
            this.J0.I3(this.J2);
            this.J0.G3(this.K2);
            this.J0.D3(this.M2);
            this.J0.L4(this.mIsLogin);
            this.J0.u3(this.B0.Z1());
            if (this.a.getIntent() != null) {
                this.J0.v3(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.J0.v1().setFromForumId(this.B0.getFromForumId());
            xk5 xk5Var = this.Y0;
            if (xk5Var != null) {
                this.J0.m3(xk5Var.a());
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.Y0.d0(TbSingleton.getInstance().getAdVertiComment());
                } else {
                    this.Y0.d0(this.J0.x1());
                }
            }
            this.J0.q3(this.j2);
            this.J0.t3(this.B0.Z0());
            this.J0.H3(this.B0.q1());
            this.u0.f(this.J0, this.B0);
            if ("1".equals(X().showReplyPanel)) {
                this.J0.H2();
            }
            return this.J0.E1();
        }
        return (View) invokeLLL.objValue;
    }

    public final TbRichText u6(ArrayList<tha> arrayList, String str, int i4) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048787, this, arrayList, str, i4)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    TbRichText f02 = arrayList.get(i5).f0();
                    if (f02 != null && (O = f02.O()) != null) {
                        int size = O.size();
                        int i6 = -1;
                        for (int i7 = 0; i7 < size; i7++) {
                            if (O.get(i7) != null && O.get(i7).getType() == 8) {
                                i6++;
                                if (!O.get(i7).U().N().equals(str) && !O.get(i7).U().O().equals(str)) {
                                    if (i6 > i4) {
                                        break;
                                    }
                                } else {
                                    int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                                    int width = O.get(i7).U().getWidth() * equipmentDensity;
                                    int height = O.get(i7).U().getHeight() * equipmentDensity;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.C2 = i7;
                                    return f02;
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
        nq9 nq9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048754, this) == null) {
            vfa.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!ei.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.B0.r1().l());
                statisticItem.param("tid", this.B0.L1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.r && this.J0 != null) {
                this.r = true;
            }
            PbModel pbModel = this.B0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.B0.destory();
                if (this.B0.n1() != null) {
                    this.B0.n1().d();
                }
            }
            xk5 xk5Var = this.Y0;
            if (xk5Var != null) {
                xk5Var.E();
                this.Y0 = null;
            }
            ForumManageModel forumManageModel = this.E0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.Q;
            if (likeModel != null) {
                likeModel.a0();
            }
            xn9 xn9Var = this.J0;
            if (xn9Var != null) {
                xn9Var.A2();
                nq9 nq9Var2 = this.J0.k;
                if (nq9Var2 != null) {
                    nq9Var2.r();
                }
            }
            zs5 zs5Var = this.s;
            if (zs5Var != null) {
                zs5Var.c();
            }
            fp9 fp9Var = this.e;
            if (fp9Var != null) {
                fp9Var.k();
            }
            bg<TextView> bgVar = this.y;
            if (bgVar != null) {
                bgVar.c();
            }
            bg<FestivalTipView> bgVar2 = this.H;
            if (bgVar2 != null) {
                bgVar2.c();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            xn9 xn9Var2 = this.J0;
            if (xn9Var2 != null) {
                xn9Var2.F0();
            }
            if (this.Y1 != null) {
                SafeHandler.getInst().removeCallbacks(this.Y1);
            }
            if (this.f2 != null) {
                MessageManager.getInstance().unRegisterListener(this.f2.d());
            }
            hz4.a().e(this.z0);
            hz4.a().e(this.A0);
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
            xn9 xn9Var3 = this.J0;
            if (xn9Var3 != null && (nq9Var = xn9Var3.k) != null) {
                nq9Var.k();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.I0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            ao9 ao9Var = this.N0;
            if (ao9Var != null) {
                ao9Var.j();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.B0;
            if (pbModel2 != null && pbModel2.E0() != null) {
                this.B0.E0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.a1;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            xn9 xn9Var4 = this.J0;
            if (xn9Var4 != null) {
                xn9Var4.I4();
            }
            tp9 tp9Var = this.u0;
            if (tp9Var != null) {
                tp9Var.e();
            }
        }
    }

    public final void r8(SparseArray<Object> sparseArray, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048777, this, new Object[]{sparseArray, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            vp9.e(getActivity(), getPageContext(), new m1(this, sparseArray, i4, z3), new n1(this));
        }
    }

    public final int v6(TbRichText tbRichText, TbRichText tbRichText2, int i4, int i5, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z3;
        TbRichTextImageInfo U;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048791, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i4), Integer.valueOf(i5), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.E2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.O().size();
                int i7 = i4;
                int i8 = -1;
                for (int i9 = 0; i9 < size; i9++) {
                    TbRichTextData tbRichTextData = tbRichText.O().get(i9);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i8++;
                        int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.U().getWidth() * equipmentDensity;
                        int height = tbRichTextData.U().getHeight() * equipmentDensity;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3 && tbRichTextData.U().S()) {
                            if (tbRichTextData.getType() != 20) {
                                String a4 = bj9.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a4)) {
                                    arrayList.add(a4);
                                    if (tbRichTextData != null && (U = tbRichTextData.U()) != null) {
                                        String N = U.N();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            N = U.O();
                                        } else {
                                            if (this.q) {
                                                i6 = 17;
                                            } else {
                                                i6 = 18;
                                            }
                                            imageUrlData.urlType = i6;
                                        }
                                        imageUrlData.imageUrl = N;
                                        imageUrlData.imageThumbUrl = N;
                                        imageUrlData.urlThumbType = imageUrlData.urlType;
                                        imageUrlData.originalUrl = wn9.n(tbRichTextData);
                                        imageUrlData.originalSize = wn9.o(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = wn9.k(tbRichTextData);
                                        imageUrlData.isLongPic = wn9.j(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = JavaTypesHelper.toLong(this.B0.L1(), -1L);
                                        imageUrlData.mIsReserver = this.B0.D1();
                                        imageUrlData.mIsSeeHost = this.B0.U0();
                                        if (concurrentHashMap != null) {
                                            concurrentHashMap.put(a4, imageUrlData);
                                        }
                                    }
                                }
                                if (!this.E2) {
                                    i7++;
                                }
                            }
                        } else if (tbRichText == tbRichText2) {
                            if (i8 <= i5) {
                                i7--;
                            }
                        }
                    }
                }
                return i7;
            }
            return i4;
        }
        return invokeCommon.intValue;
    }
}
