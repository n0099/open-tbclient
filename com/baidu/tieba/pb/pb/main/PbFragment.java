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
import com.baidu.tieba.a55;
import com.baidu.tieba.ag;
import com.baidu.tieba.ai5;
import com.baidu.tieba.aiapps.TbAiappsLaunchUtil;
import com.baidu.tieba.al5;
import com.baidu.tieba.ar9;
import com.baidu.tieba.at5;
import com.baidu.tieba.bg;
import com.baidu.tieba.bia;
import com.baidu.tieba.bl5;
import com.baidu.tieba.bl9;
import com.baidu.tieba.bn;
import com.baidu.tieba.br9;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cl5;
import com.baidu.tieba.cl9;
import com.baidu.tieba.cn5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.ct5;
import com.baidu.tieba.da5;
import com.baidu.tieba.dca;
import com.baidu.tieba.di;
import com.baidu.tieba.e35;
import com.baidu.tieba.ee5;
import com.baidu.tieba.ej5;
import com.baidu.tieba.el5;
import com.baidu.tieba.el9;
import com.baidu.tieba.eo9;
import com.baidu.tieba.f26;
import com.baidu.tieba.f55;
import com.baidu.tieba.fi5;
import com.baidu.tieba.fka;
import com.baidu.tieba.fla;
import com.baidu.tieba.fm9;
import com.baidu.tieba.fn;
import com.baidu.tieba.fp9;
import com.baidu.tieba.g35;
import com.baidu.tieba.gm9;
import com.baidu.tieba.gt5;
import com.baidu.tieba.gw4;
import com.baidu.tieba.h15;
import com.baidu.tieba.h55;
import com.baidu.tieba.hj5;
import com.baidu.tieba.hp9;
import com.baidu.tieba.hz4;
import com.baidu.tieba.i26;
import com.baidu.tieba.i55;
import com.baidu.tieba.i9;
import com.baidu.tieba.ii5;
import com.baidu.tieba.ij5;
import com.baidu.tieba.is5;
import com.baidu.tieba.j55;
import com.baidu.tieba.jj5;
import com.baidu.tieba.jm9;
import com.baidu.tieba.ks9;
import com.baidu.tieba.kt9;
import com.baidu.tieba.l45;
import com.baidu.tieba.l95;
import com.baidu.tieba.lg5;
import com.baidu.tieba.lk9;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.lt4;
import com.baidu.tieba.lz6;
import com.baidu.tieba.m05;
import com.baidu.tieba.m36;
import com.baidu.tieba.mk9;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.ms9;
import com.baidu.tieba.mt4;
import com.baidu.tieba.mz6;
import com.baidu.tieba.no9;
import com.baidu.tieba.ns5;
import com.baidu.tieba.nu6;
import com.baidu.tieba.o25;
import com.baidu.tieba.o3a;
import com.baidu.tieba.ob5;
import com.baidu.tieba.oe5;
import com.baidu.tieba.og5;
import com.baidu.tieba.oi9;
import com.baidu.tieba.ol5;
import com.baidu.tieba.ot9;
import com.baidu.tieba.p35;
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
import com.baidu.tieba.pja;
import com.baidu.tieba.pp9;
import com.baidu.tieba.pr9;
import com.baidu.tieba.psa;
import com.baidu.tieba.qp9;
import com.baidu.tieba.qs9;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.tieba.ri9;
import com.baidu.tieba.ro6;
import com.baidu.tieba.s55;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.sr9;
import com.baidu.tieba.ss5;
import com.baidu.tieba.ssa;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.ti9;
import com.baidu.tieba.tn9;
import com.baidu.tieba.tp9;
import com.baidu.tieba.tr9;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.vh5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vl9;
import com.baidu.tieba.vp9;
import com.baidu.tieba.vq9;
import com.baidu.tieba.w05;
import com.baidu.tieba.wi5;
import com.baidu.tieba.wp9;
import com.baidu.tieba.wr9;
import com.baidu.tieba.wra;
import com.baidu.tieba.x0b;
import com.baidu.tieba.x15;
import com.baidu.tieba.xk5;
import com.baidu.tieba.xo9;
import com.baidu.tieba.xr9;
import com.baidu.tieba.xra;
import com.baidu.tieba.xt9;
import com.baidu.tieba.yja;
import com.baidu.tieba.yk5;
import com.baidu.tieba.yn9;
import com.baidu.tieba.yq9;
import com.baidu.tieba.yr9;
import com.baidu.tieba.yw5;
import com.baidu.tieba.z45;
import com.baidu.tieba.z95;
import com.baidu.tieba.ze5;
import com.baidu.tieba.zja;
import com.baidu.tieba.zo9;
import com.baidu.tieba.zr9;
import com.baidu.tieba.zz7;
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
import tbclient.UserMuteCheck.DataRes;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class PbFragment extends BaseFragment implements i26, VoiceManager.j, UserIconBox.c, View.OnTouchListener, z45.e, TbRichTextView.t, TbPageContextSupport, ot9, xt9.b, xra {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k U2;
    public static final mz6.b V2;
    public transient /* synthetic */ FieldHolder $fh;
    public ag<TbImageView> A;
    public hz4.d A0;
    public CustomMessageListener A1;
    public final View.OnClickListener A2;
    public ag<ImageView> B;
    public hz4.d B0;
    public CustomMessageListener B1;
    public boolean B2;
    public ag<View> C;
    public PbModel C0;
    public CustomMessageListener C1;
    public final BdListView.p C2;
    public ag<TiebaPlusRecommendCard> D;
    public qs9 D0;
    public CustomMessageListener D1;
    public final TbRichTextView.z D2;
    public ag<LinearLayout> E;
    public gw4 E0;
    public CustomMessageListener E1;
    public zja E2;
    public ag<RelativeLayout> F;
    public ForumManageModel F0;
    public CustomMessageListener F1;
    public final a55.c F2;
    public ag<ItemCardView> G;
    public ze5 G0;
    public final CustomMessageListener G1;
    public final a55.c G2;
    @NonNull
    public PbGodGuideController H;
    public el9 H0;
    public CustomMessageListener H1;
    public final AdapterView.OnItemClickListener H2;
    public ag<FestivalTipView> I;
    public PollingModel I0;
    public CustomMessageListener I1;
    public final View.OnLongClickListener I2;
    public boolean J;
    public ShareSuccessReplyToServerModel J0;
    public View.OnClickListener J1;
    public final View.OnClickListener J2;
    public boolean K;
    public qp9 K0;
    public CustomMessageListener K1;
    public final ItemCardHelper.c K2;
    public boolean L;
    public boolean L0;
    public CustomMessageListener L1;
    public final NoNetworkView.b L2;
    public ag<GifView> M;
    public boolean M0;
    public CustomMessageListener M1;
    public View.OnTouchListener M2;
    public String N;
    public boolean N0;
    public CustomMessageListener N1;
    public lz6.b N2;
    public boolean O;
    public tp9 O0;
    public CustomMessageListener O1;
    public final eo9.b O2;
    public boolean P;
    public h55 P0;
    public SuggestEmotionModel.c P1;
    public int P2;
    public String Q;
    public j55 Q0;
    public CustomMessageListener Q1;
    public int Q2;
    public LikeModel R;
    public String R0;
    public GetSugMatchWordsModel.b R1;
    public String R2;
    public View S;
    public boolean S0;
    public PraiseModel S1;
    public x15 S2;

    /* renamed from: T  reason: collision with root package name */
    public View f1136T;
    public boolean T0;
    public br9.h T1;
    public int T2;
    public View U;
    public boolean U0;
    public CustomMessageListener U1;
    public View V;
    public String V0;
    public ResponsedEventListener V1;
    public String W;
    public boolean W0;
    public ResponsedEventListener W1;
    public int X;
    public pja X0;
    public CheckRealNameModel.b X1;
    public boolean Y;
    public cl5 Y0;
    public gm9 Y1;
    public int[] Z;
    public bl5 Z0;
    public final Runnable Z1;
    public final BdUniqueId a;
    public int a0;
    public PermissionJudgePolicy a1;
    public CustomMessageListener a2;
    public AbsPbActivity b;
    public int b0;
    public ReplyPrivacyCheckController b1;
    public CustomMessageListener b2;
    public boolean c;
    public int c0;
    public yr9 c1;
    public CustomMessageListener c2;
    public boolean d;
    public p35 d0;
    public yk5 d1;
    public CustomMessageListener d2;
    public mz6 e;
    public BdUniqueId e0;
    public xk5 e1;
    public CustomMessageListener e2;
    public br9 f;
    public l95 f0;
    public xk5 f1;
    public CustomMessageListener f2;
    public boolean g;
    public boolean g0;
    public int g1;
    public vl9 g2;
    public boolean h;
    public boolean h0;
    public Object h1;
    public CustomMessageListener h2;
    public boolean i;
    public Object i0;
    public BdPageContext i1;
    public CustomMessageListener i2;
    public VoiceManager j;
    public AgreeMessageData j0;
    public z95 j1;
    public z45.e j2;
    public int k;
    public BdUniqueId k1;
    public k3 k2;
    public a55 l;
    public Runnable l1;
    public j55.f l2;
    public long m;
    public vp9 m1;
    public final SortSwitchButton.f m2;
    public long n;
    public BdImage n1;
    public final View.OnClickListener n2;
    public long o;
    public String o1;
    public CustomMessageListener o2;
    public long p;
    public TbRichTextImageInfo p1;
    public final NewWriteModel.d p2;
    public long q;
    public TbRichTextMemeInfo q1;
    public Boolean q2;
    public boolean r;
    public lg5 r0;
    public boolean r1;
    public NewWriteModel.d r2;
    public boolean s;
    public boolean s0;
    public int s1;
    public NetMessageListener s2;
    public at5 t;
    public boolean t0;
    public int t1;
    public final PbModel.h t2;
    public long u;
    @NonNull
    public TiePlusEventController.g u0;
    public List<i3> u1;
    public CustomMessageListener u2;
    public boolean v;
    public pr9 v0;
    public int v1;
    public HttpMessageListener v2;
    public long w;
    public PushPermissionController w0;
    public ro6 w1;
    public final gw4.a w2;
    public int x;
    public boolean x0;
    public final i3 x1;
    public final AbsListView.OnScrollListener x2;
    public String y;
    public PbInterviewStatusView.f y0;
    public final xo9.b y1;
    public final i9 y2;
    public ag<TextView> z;
    public final Handler z0;
    public final CustomMessageListener z1;
    public final da5.g z2;

    /* loaded from: classes7.dex */
    public interface i3 {
        boolean onBackPressed();
    }

    /* loaded from: classes7.dex */
    public interface k3 {
        void callback(Object obj);
    }

    @Override // com.baidu.tieba.ot9
    public PbFragment S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xra
    @NonNull
    public String V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? "pb_page" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ot9
    public AbsVideoPbFragment b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            return null;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i26
    public void n0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048736, this, context, str) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048763, this, view2, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048782, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView w1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048790, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.i26
    public void y1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048798, this, context, str) == null) {
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
                    jm9.a(this.b.a.getPageContext(), this.a).show();
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.K0 != null && this.a != null) {
                    this.b.a.K0.b3(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements z45.e {
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

            @Override // com.baidu.tieba.z45.e
            public void onClick(z45 z45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                    z45Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements z45.e {
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

            @Override // com.baidu.tieba.z45.e
            public void onClick(z45 z45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                    z45Var.dismiss();
                    xr9.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ee5 ee5Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ee5Var, writeData, antiData}) == null) {
                if (!di.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.C0.r1() != null) {
                        statisticItem.param("fid", this.a.C0.r1().l());
                    }
                    statisticItem.param("tid", this.a.C0.L1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (di.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.F8();
                this.a.K0.Q3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (this.a.I0 != null) {
                    this.a.I0.getData(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    SafeHandler.getInst().postDelayed(this.a.Z1, 300000L);
                }
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.Z0 != null && (this.a.Z0.y() || this.a.Z0.A())) {
                            this.a.Z0.w(false, postWriteCallBackData);
                        }
                        this.a.O0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.b1;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (di.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        z45 z45Var = new z45(this.a.getActivity());
                        if (di.isEmpty(postWriteCallBackData.getErrorString())) {
                            z45Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            z45Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        z45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new b(this));
                        z45Var.setPositiveButton(R.string.open_now, new c(this));
                        z45Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (ee5Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.m8(i, antiData, str);
                        return;
                    }
                }
                this.a.y8(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.n8(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData != null && writeData.getType() == 2) {
                    if (floor != null) {
                        this.a.K0.g2(this.a.C0.r1());
                    }
                } else if (this.a.C0.U0()) {
                    lk9 r1 = this.a.C0.r1();
                    if (r1 != null && r1.O() != null && r1.O().getAuthor() != null && (userId = r1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.C0.i3()) {
                        this.a.K0.S3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.C0.i3()) {
                    this.a.K0.S3();
                }
                if (this.a.C0.Y0()) {
                    kt9.t("c10369", this.a.C0.L1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.C0 != null) {
                    Context context = this.a.getContext();
                    lk9 r12 = this.a.C0.r1();
                    String forumId = this.a.C0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    pp9.b(context, r12, forumId, z2, this.a.C0.x1(), this.a.C0.A1(), this.a.C0.z1(), this.a.C0.y1(), this.a.C0.E1(), this.a.C0.F1());
                }
                if (writeData != null) {
                    ob5.b(writeData.getContent(), "1");
                }
                if (this.a.Z6()) {
                    this.a.M8();
                }
                this.a.v8();
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.K0 != null && this.a != null) {
                    this.b.a.K0.b3(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements z45.e {
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

            @Override // com.baidu.tieba.z45.e
            public void onClick(z45 z45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                    z45Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements z45.e {
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

            @Override // com.baidu.tieba.z45.e
            public void onClick(z45 z45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                    z45Var.dismiss();
                    xr9.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ee5 ee5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ee5Var, writeData, antiData}) == null) {
                if (!di.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.C0 != null && this.a.C0.r1() != null) {
                        statisticItem.param("fid", this.a.C0.r1().l());
                    }
                    if (this.a.C0 != null) {
                        statisticItem.param("tid", this.a.C0.L1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.x6()) {
                        this.a.f8(false);
                        ri9.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1499));
                    }
                    tp9 tp9Var = this.a.O0;
                    if (tp9Var != null) {
                        tp9Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        og5.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        ob5.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.Z6()) {
                        this.a.M8();
                    }
                    this.a.v8();
                    return;
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                }
                if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.b1;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (di.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                    } else {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    z45 z45Var = new z45(this.a.getActivity());
                    if (di.isEmpty(postWriteCallBackData.getErrorString())) {
                        z45Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        z45Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    z45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new b(this));
                    z45Var.setPositiveButton(R.string.open_now, new c(this));
                    z45Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbFragment pbFragment = this.a;
                    if (pbFragment.O0 != null) {
                        if (pbFragment.K0 != null && this.a.K0.x1() != null && this.a.K0.x1().f() != null && this.a.K0.x1().f().z()) {
                            this.a.K0.x1().f().w(postWriteCallBackData);
                        }
                        this.a.O0.l(postWriteCallBackData);
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
                pbFragment.showToast(pbFragment.y);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.k1) {
                this.a.K0.N1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                lk9 r1 = this.a.C0.r1();
                if (r1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    r1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.j1.d(this.a.i1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.i1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.A8(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (di.isEmpty(errorString2)) {
                        errorString2 = this.a.i1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.j1.c(errorString2);
                } else {
                    this.a.s8();
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
                    if (this.a.E2 != null && TextUtils.equals(this.a.E2.U(), optString)) {
                        if (this.a.E2.s() != null) {
                            BdToastHelper.toast(x0b.a(this.a.E2.s().feedback_toast));
                        }
                    }
                } finally {
                    this.a.E2 = null;
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
            int d;
            yn9 T0;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.K0.H2((TbRichText) view2.getTag());
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
                    kt9.K(3, i2, this.a.C0);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && (view2 instanceof TbImageView)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        boolean isGif = ((TbImageView) view2).isGif();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                        }
                        this.a.S = view2;
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    fp9.e(this.a.C0, str, i, eVar);
                    if (this.a.C0.G.j0()) {
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
                                    arrayList.add(Q.get(i6).S());
                                    if (i7 == i5 && str != null && (str.equals(Q.get(i6).S()) || str.equals(Q.get(i6).O()) || str.equals(Q.get(i6).M()) || str.equals(Q.get(i6).N()) || str.equals(Q.get(i6).Q()))) {
                                        i7 = i6;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    String S = Q.get(i6).S();
                                    imageUrlData.imageUrl = S;
                                    imageUrlData.imageThumbUrl = S;
                                    if (this.a.r) {
                                        i4 = 17;
                                    } else {
                                        i4 = 18;
                                    }
                                    imageUrlData.urlThumbType = i4;
                                    imageUrlData.originalUrl = Q.get(i6).S();
                                    imageUrlData.isLongPic = Q.get(i6).V();
                                    concurrentHashMap.put(Q.get(i6).S(), imageUrlData);
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
                        this.a.n6(rect);
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.setData(arrayList).setIndex(i3).setIsCDN(false).setPostId(eVar.f).setIsReserve(this.a.C0.D1()).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false).setIsSeeHost(this.a.b7()).setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.C0 != null) {
                            builder.setFromForumId(this.a.C0.getFromForumId());
                            if (this.a.C0.r1() != null) {
                                builder.setThreadData(this.a.C0.r1().O());
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
                        builder2.setData(arrayList2).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.a.get(0)).setIsReserve(this.a.C0.D1()).setAssistUrls(concurrentHashMap2).setNeedBroadCaset(false).setIsSeeHost(this.a.b7()).setPostId(eVar.f).setBjhPostId(eVar.f).setIsCanDrag(false);
                        if (this.a.C0 != null) {
                            builder2.setFromForumId(this.a.C0.getFromForumId());
                            if (this.a.C0.r1() != null) {
                                builder2.setThreadData(this.a.C0.r1().O());
                            }
                        }
                        ImageViewerConfig bulid2 = builder2.bulid(this.a.getPageContext().getPageActivity());
                        bulid2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, bulid2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText f = fp9.f(this.a.C0, str, i);
                        if (f != null && (d = fp9.d()) >= 0 && d < f.O().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = mk9.a(f.O().get(d));
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
                            if (f.getPostId() != 0 && (T0 = this.a.K0.T0()) != null) {
                                ArrayList<bn> v = T0.v();
                                if (ListUtils.getCount(v) > 0) {
                                    Iterator<bn> it = v.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        bn next = it.next();
                                        if ((next instanceof zja) && f.getPostId() == JavaTypesHelper.toLong(((zja) next).U(), 0L)) {
                                            int i9 = 8;
                                            if (f.getPostId() == JavaTypesHelper.toLong(this.a.C0.P0(), 0L)) {
                                                i9 = 1;
                                            }
                                            kt9.b(this.a.C0.r1(), (zja) next, ((zja) next).f0, i9, 3);
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
                            this.a.n6(rect2);
                            ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                            builder3.setData(arrayList3).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.i).setIsReserve(this.a.C0.D1()).setAssistUrls(concurrentHashMap3).setNeedBroadCaset(false).setIsSeeHost(this.a.b7()).setPostId(eVar.f).setBjhPostId(eVar.f).setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.C0 != null) {
                                builder3.setFromForumId(this.a.C0.getFromForumId());
                                if (this.a.C0.r1() != null) {
                                    builder3.setThreadData(this.a.C0.r1().O());
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
                if (!this.a.g && z && !this.a.C0.g1()) {
                    this.a.U7();
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
                lk9 r1 = this.a.C0.r1();
                if (r1 == null) {
                    return;
                }
                if (this.a.C0.T0() != null && this.a.C0.T0().getUserIdLong() == o25Var.p) {
                    this.a.K0.i3(o25Var.l, this.a.C0.r1(), this.a.C0.K1(), this.a.C0.C1());
                }
                if (r1.F() != null && r1.F().size() >= 1 && r1.F().get(0) != null) {
                    long j = JavaTypesHelper.toLong(r1.F().get(0).U(), 0L);
                    long j2 = JavaTypesHelper.toLong(this.a.C0.L1(), 0L);
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
                        this.a.K0.T0().f0();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.k1) {
                this.a.K0.N1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.j1.d(this.a.i1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (di.isEmpty(muteMessage)) {
                    muteMessage = this.a.i1.getResources().getString(R.string.un_mute_fail);
                }
                this.a.j1.c(muteMessage);
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
                if (this.a.K0 != null) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.K0.G1());
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
                    this.a.j8(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e42);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                new BdTopToast(this.a.getContext()).setIcon(false).setContent(errorString).show((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b3 implements a55.c {
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

        @Override // com.baidu.tieba.a55.c
        public void a(a55 a55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, a55Var, i, view2) == null) {
                if (a55Var != null) {
                    a55Var.e();
                }
                PbFragment pbFragment = this.a;
                zja zjaVar = pbFragment.E2;
                if (zjaVar != null) {
                    if (i == 0) {
                        zjaVar.S0();
                        this.a.E2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.u7(pbFragment2.E2);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements bg<LinearLayout> {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m36)) {
                m36 m36Var = (m36) customResponsedMessage.getData();
                lk9 r1 = this.a.C0.r1();
                if (r1 == null) {
                    return;
                }
                if (this.a.C0.r1() != null && this.a.C0.r1().X().t() != null && this.a.C0.r1().X().t().getPortrait() != null && this.a.C0.r1().X().t().getPortrait().equals(m36Var.a)) {
                    if (this.a.C0.r1().X().t().getUserWorldCupData() != null) {
                        this.a.C0.r1().X().t().getUserWorldCupData().c(m36Var.b);
                    }
                    this.a.K0.j3(this.a.C0.r1(), this.a.C0.K1(), this.a.C0.C1(), this.a.K0.B1());
                }
                if (r1.F() != null && r1.F().size() >= 0) {
                    Iterator<zja> it = r1.F().iterator();
                    while (it.hasNext()) {
                        zja next = it.next();
                        if (next != null && next.t() != null && next.t().getPortrait() != null && next.t().getPortrait().equals(m36Var.a) && next.t().getUserWorldCupData() != null) {
                            next.t().getUserWorldCupData().c(m36Var.b);
                        }
                    }
                    this.a.K0.T0().f0();
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
                if (!this.a.Z6() || this.a.b == null || this.a.b.J1() == null || !str.equals(this.a.b.J1().getTopicId())) {
                    return;
                }
                this.a.N8(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c2 implements gw4.a {
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

        @Override // com.baidu.tieba.gw4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.K0.R3();
                if (z) {
                    if (this.a.E0 != null) {
                        this.a.E0.h(z2);
                    }
                    this.a.C0.h3(z2);
                    if (!this.a.C0.c1()) {
                        this.a.K0.g2(this.a.C0.r1());
                    } else {
                        this.a.p7();
                    }
                    if (z2) {
                        boolean p0 = this.a.C0.r1().p0();
                        if (this.a.E0 != null && !p0) {
                            if (this.a.E0.f() != null && this.a.C0 != null && this.a.C0.r1() != null && this.a.C0.r1().O() != null && this.a.C0.r1().O().getAuthor() != null) {
                                MarkData f = this.a.E0.f();
                                MetaData author = this.a.C0.r1().O().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00ff);
                                        this.a.w8();
                                    } else {
                                        this.a.r8(author);
                                    }
                                } else {
                                    PbFragment pbFragment = this.a;
                                    pbFragment.showToast(pbFragment.getPageContext().getString(R.string.add_mark));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.G5();
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
    public class c3 implements a55.c {
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

        @Override // com.baidu.tieba.a55.c
        public void a(a55 a55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, a55Var, i, view2) == null) {
                if (a55Var != null) {
                    a55Var.e();
                }
                if (this.a.n1 != null && !TextUtils.isEmpty(this.a.o1)) {
                    if (i == 0) {
                        if (this.a.q1 != null) {
                            cn5.a aVar = new cn5.a();
                            aVar.a = this.a.o1;
                            String str = "";
                            if (this.a.q1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.q1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        } else {
                            this.a.I5();
                        }
                    } else if (i == 1) {
                        if (this.a.a1 == null) {
                            this.a.a1 = new PermissionJudgePolicy();
                        }
                        this.a.a1.clearRequestPermissionList();
                        this.a.a1.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.a1.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.m1 == null) {
                            PbFragment pbFragment = this.a;
                            pbFragment.m1 = new vp9(pbFragment.getPageContext());
                        }
                        this.a.m1.b(this.a.o1, this.a.n1.getImageByte());
                    }
                    this.a.n1 = null;
                    this.a.o1 = null;
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
                this.a.e.c(motionEvent);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.C0 != null && this.a.C0.r1() != null) {
                this.a.C0.r1().a();
                this.a.C0.W1();
                if (this.a.K0.T0() != null) {
                    this.a.K0.g2(this.a.C0.r1());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ssa) && customResponsedMessage.getOrginalMessage().getTag() == this.a.k1) {
                ssa ssaVar = (ssa) customResponsedMessage.getData();
                this.a.K0.N1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.h1;
                DataRes dataRes = ssaVar.a;
                boolean z = false;
                if (ssaVar.c == 0 && dataRes != null) {
                    int i = JavaTypesHelper.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (i == 1) {
                        z = true;
                    }
                    if (di.isEmpty(str)) {
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
                        this.a.K0.X2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.t8(z, sparseArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d2 implements z45.e {
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

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                z45Var.dismiss();
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
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.C0 == null || this.a.C0.B1() == i + 1) {
                return;
            }
            this.a.d8(pp9.q(i));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements lz6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.lz6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.lz6.b
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

        @Override // com.baidu.tieba.lz6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.K0 != null && this.b.f != null) {
                this.b.f.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.f.l();
                }
                if (this.b.w6()) {
                    this.b.K0.O1();
                    this.b.K0.q3();
                }
            }
        }

        @Override // com.baidu.tieba.lz6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.K0 != null && this.b.f != null) {
                this.b.K0.A4();
                this.b.f.u(false);
                this.b.f.x();
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
            yja j;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.C0 != null && this.a.C0.r1() != null) {
                String str = (String) customResponsedMessage.getData();
                yja yjaVar = null;
                if (!TextUtils.isEmpty(str) && this.a.C0.r1().F() != null) {
                    ArrayList<zja> F = this.a.C0.r1().F();
                    Iterator<zja> it = F.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        zja next = it.next();
                        if (next instanceof yja) {
                            yja yjaVar2 = (yja) next;
                            if (str.equals(yjaVar2.E1())) {
                                yjaVar = yjaVar2;
                                break;
                            }
                        }
                    }
                    if (yjaVar != null) {
                        F.remove(yjaVar);
                    }
                }
                if (this.a.K0.T0() != null && !ListUtils.isEmpty(this.a.K0.T0().v())) {
                    ArrayList<bn> v = this.a.K0.T0().v();
                    if (yjaVar != null) {
                        j = yjaVar;
                    } else {
                        j = pp9.j(this.a.C0.r1(), str);
                    }
                    pp9.f(v, j);
                }
                if (this.a.K0.m1() != null && !ListUtils.isEmpty(this.a.K0.m1().getData())) {
                    List<bn> data = this.a.K0.m1().getData();
                    if (yjaVar == null) {
                        yjaVar = pp9.j(this.a.C0.r1(), str);
                    }
                    pp9.f(data, yjaVar);
                }
                this.a.Z5(str);
                this.a.C0.W1();
                if (this.a.K0.T0() != null) {
                    this.a.K0.T0().f0();
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
        public void onNavigationButtonClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e2 implements z45.e {
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

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                z45Var.dismiss();
                this.b.G0.i(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.C0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e3 implements j55.d {
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

        @Override // com.baidu.tieba.j55.d
        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.Q0 != null) {
                this.a.Q0.r(sr9.h(this.a.E2));
                ArrayList arrayList = new ArrayList();
                for (i55 i55Var : this.a.Q0.g()) {
                    if (i55Var instanceof f55) {
                        arrayList.add((f55) i55Var);
                    }
                }
                sr9.f(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements mz6.b {
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

        @Override // com.baidu.tieba.mz6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    fm9.d();
                } else {
                    fm9.c();
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
            this.a.a6();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.K0.i2() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.f6((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
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
            ArrayList<zja> F;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.C0 != null && this.a.C0.r1() != null && this.a.K0 != null && this.a.K0.T0() != null) {
                this.a.K0.Q2(absListView, i, i2, i3);
                if (this.a.f != null) {
                    this.a.f.q(absListView, i, i2, i3);
                }
                if (this.a.C0.g2() && (F = this.a.C0.r1().F()) != null && !F.isEmpty()) {
                    int y = ((i + i2) - this.a.K0.T0().y()) - 1;
                    lk9 r1 = this.a.C0.r1();
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
                if (!pp9.B(this.a.g1) && pp9.B(i)) {
                    if (this.a.K0 != null) {
                        this.a.s0 = true;
                        this.a.K0.F0();
                        if (this.a.Z0 != null && !this.a.K0.i2()) {
                            this.a.K0.x3(this.a.Z0.z());
                        }
                        if (!this.a.K) {
                            this.a.s0 = true;
                            this.a.K0.p3();
                        }
                    }
                    if (!this.a.s) {
                        this.a.s = true;
                    }
                }
                if (this.a.K0 != null) {
                    this.a.K0.R2(absListView, i);
                }
                if (this.a.f != null) {
                    this.a.f.r(absListView, i);
                }
                if (this.a.t == null) {
                    this.a.t = new at5();
                    this.a.t.a(1001);
                }
                if (i == 0) {
                    this.a.t.e();
                    if (this.a.i0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.a.i0);
                        this.a.i0 = null;
                    }
                } else {
                    if (this.a.i0 == null) {
                        this.a.i0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("pb", "1", "scroll");
                    }
                    this.a.t.d();
                }
                this.a.g1 = i;
                if (i == 0) {
                    bia.g().h(this.a.getUniqueId(), true);
                    this.a.O5(true);
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
                pbFragment.c = true;
                return pbFragment.X5(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements eo9.b {
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

        @Override // com.baidu.tieba.eo9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f17cf);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e42);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.K0.D0(str);
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
        public void a(yq9 yq9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, yq9Var) != null) || yq9Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, yq9Var.a()));
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
                if (this.a.K0 != null) {
                    this.a.K0.D2(agreeMessageData);
                }
                if (agreeData.agreeType == 2 && this.a.K0 != null && !zr9.g(this.a.C0.b)) {
                    this.a.K0.F4();
                    zr9.a(this.a.C0.b);
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
    public class h implements z45.e {
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

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    z45Var.dismiss();
                    ((TbPageContext) this.a.i1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                z45Var.dismiss();
                xr9.a(this.a.getPageContext());
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
                if (!this.a.s0) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        this.a.D7();
                        return;
                    } else {
                        this.a.Z7();
                        return;
                    }
                }
                this.a.s0 = false;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.G6() != null) {
                this.a.G6().N2();
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
        public void onNavigationButtonClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h3 implements xk5 {
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

        @Override // com.baidu.tieba.xk5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                tp9 tp9Var = this.a.O0;
                if (tp9Var != null && tp9Var.g() != null && this.a.O0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.O0.g().c());
                    if (this.a.K0 != null && this.a.K0.x1() != null && this.a.K0.x1().f() != null && this.a.K0.x1().f().z()) {
                        this.a.K0.x1().f().w(this.a.O0.h());
                    }
                    this.a.O0.b(true);
                    return true;
                }
                return !this.a.T5(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i implements z45.e {
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

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                z45Var.dismiss();
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
                this.a.K0.H4(!this.a.O);
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
                this.a.r1 = true;
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
                switch (this.a.F0.getLoadDataMode()) {
                    case 0:
                        this.a.C0.W1();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.l6(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.K0.O0(1, dVar.a, dVar.b, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbFragment pbFragment = this.a;
                        pbFragment.m6(pbFragment.F0.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        this.a.K0.O0(this.a.F0.getLoadDataMode(), gVar.a, gVar.b, false);
                        this.a.K0.S2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.K0.O0(this.a.F0.getLoadDataMode(), false, null, false);
        }
    }

    /* loaded from: classes7.dex */
    public class j implements z45.e {
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

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                z45Var.dismiss();
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
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && !ListUtils.isEmpty(list) && this.a.K0 != null) {
                this.a.K0.X3(list);
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
    public class j1 implements z45.e {
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

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                this.a.R6();
                e35 p1 = this.a.C0.p1();
                int u1 = this.a.K0.u1();
                if (u1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f100a);
                } else if (p1 != null && u1 > p1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f100a);
                } else {
                    this.a.K0.F0();
                    this.a.F8();
                    this.a.K0.S3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.C0.f3(this.a.K0.u1());
                        if (this.a.f != null) {
                            this.a.f.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e42);
                    }
                    z45Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j2 implements z45.e {
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

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) && z45Var != null) {
                z45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class j3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<qp9> a;
        public WeakReference<PbFragment> b;

        public j3(qp9 qp9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qp9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(qp9Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                qp9 qp9Var = this.a.get();
                if (qp9Var != null) {
                    qp9Var.N1();
                }
                PbFragment pbFragment = this.b.get();
                if (pbFragment != null && CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        pbFragment.z8(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        zz7.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0e42);
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
                if (this.a.K0 != null && this.a.K0.x1() != null) {
                    no9 x1 = this.a.K0.x1();
                    if (x1.j()) {
                        x1.h();
                        return true;
                    }
                }
                if (this.a.K0 != null && this.a.K0.x2()) {
                    this.a.K0.R1();
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
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.S1 != null && str != null) {
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
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || this.a.S1 == null) {
                return;
            }
            lk9 r1 = this.a.C0.r1();
            if (r1.O().getPraise().getIsLike() == 1) {
                this.a.R8(0);
            } else {
                this.a.R8(1);
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
                String valueOf = String.valueOf(this.a.C0.r1().V().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.C0.r1().k().getId(), this.a.C0.r1().k().getName(), this.a.C0.r1().O().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k2 implements da5.g {
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

        @Override // com.baidu.tieba.da5.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.w6()) {
                    this.a.b.finish();
                }
                if (this.a.C0.q2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.K0.N0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements z45.e {
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

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                this.b.K0.s4();
                MessageManager.getInstance().sendMessage(this.a);
                z45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 implements br9.h {
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

        @Override // com.baidu.tieba.br9.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.h8(z);
                if (this.a.K0.j1() != null && z) {
                    this.a.K0.H4(false);
                }
                this.a.K0.K2(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l1 implements j55.f {
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

        @Override // com.baidu.tieba.j55.f
        public void G0(j55 j55Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, j55Var, i, view2) == null) {
                if (this.a.P0 != null) {
                    this.a.P0.dismiss();
                }
                this.a.O8(i);
                if (i != -4) {
                    if (i != -3) {
                        if (i != -2) {
                            if (i != -1) {
                                if (i != 13) {
                                    switch (i) {
                                        case 1:
                                            if (this.a.n1 != null && !TextUtils.isEmpty(this.a.o1)) {
                                                if (this.a.q1 != null) {
                                                    cn5.a aVar = new cn5.a();
                                                    aVar.a = this.a.o1;
                                                    String str = "";
                                                    if (this.a.q1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.q1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.I5();
                                                }
                                                this.a.n1 = null;
                                                this.a.o1 = null;
                                                return;
                                            }
                                            return;
                                        case 2:
                                            if (this.a.n1 != null && !TextUtils.isEmpty(this.a.o1)) {
                                                if (this.a.a1 == null) {
                                                    this.a.a1 = new PermissionJudgePolicy();
                                                }
                                                this.a.a1.clearRequestPermissionList();
                                                this.a.a1.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                if (this.a.a1.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                                    return;
                                                }
                                                if (this.a.m1 == null) {
                                                    PbFragment pbFragment = this.a;
                                                    pbFragment.m1 = new vp9(pbFragment.getPageContext());
                                                }
                                                this.a.m1.b(this.a.o1, this.a.n1.getImageByte());
                                                this.a.n1 = null;
                                                this.a.o1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            zja zjaVar = this.a.E2;
                                            if (zjaVar != null) {
                                                zjaVar.S0();
                                                this.a.E2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.t7(view2);
                                            if (this.a.C0.r1().O() != null && this.a.C0.r1().O().getAuthor() != null && this.a.C0.r1().O().getAuthor().getUserId() != null && this.a.E0 != null) {
                                                kt9.F(2, pp9.v(this.a.C0.r1()), !this.a.E0.e(), this.a.C0);
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
                                                this.a.O6((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray2.put(R.id.tag_from, 0);
                                                    sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                    this.a.Q5(sparseArray2);
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
                                                boolean S = this.a.m0().S(TbadkCoreApplication.getCurrentAccount());
                                                if (S) {
                                                    if (booleanValue2) {
                                                        this.a.K0.V2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, S);
                                                        return;
                                                    } else {
                                                        this.a.o8(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.K0.T2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                                    return;
                                                } else {
                                                    this.a.o8(sparseArray3, intValue, booleanValue);
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
                                                    this.a.Q5(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                }
                                                this.a.K0.Y2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.K0.T2(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            zja zjaVar2 = (zja) sparseArray.get(R.id.tag_clip_board);
                                            if (zjaVar2.p() == null) {
                                                return;
                                            }
                                            this.a.U5(zjaVar2.p());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.C0 != null && this.a.C0.r1() != null) {
                                                this.a.b.T1(psa.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.C0 != null && this.a.C0.r1() != null) {
                                    this.a.K0.a5(true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            if (view3 == null) {
                                return;
                            }
                            this.a.Q7(view3);
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
                            this.a.Q7(view4);
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
                    this.a.Q7(view5);
                    if (view5 != null) {
                        if (sparseArray5 != null && (sparseArray5.get(R.id.tag_is_top_question) instanceof Boolean)) {
                            this.a.f8(((Boolean) sparseArray5.get(R.id.tag_is_top_question)).booleanValue());
                        }
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.Q7(view6);
                if (view6 != null) {
                    view6.performClick();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l2 implements yk5 {
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

        @Override // com.baidu.tieba.yk5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements z45.e {
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

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                z45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements j55.f {
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

        @Override // com.baidu.tieba.j55.f
        public void G0(j55 j55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, j55Var, i, view2) == null) {
                if (this.e.P0 != null) {
                    this.e.P0.dismiss();
                }
                if (i == 0) {
                    this.e.K0.T2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.k1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.k1);
                    this.e.B8(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m1 implements z45.e {
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

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                if (z45Var != null) {
                    z45Var.dismiss();
                }
                this.d.d6(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
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
                if (this.a.w6()) {
                    this.a.b.finish();
                }
                if (this.a.C0.q2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.K0.N0();
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
            tp9 tp9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (tp9Var = this.a.O0) != null && tp9Var.g() != null) {
                if (!this.a.O0.g().e()) {
                    this.a.O0.b(false);
                }
                this.a.O0.g().l(false);
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
                    if (updateAttentionMessage.getOrginalMessage().getTag() == this.a.getUniqueId() && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().blockData, PbFragment.U2) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                        return;
                    }
                    return;
                }
                if (updateAttentionMessage.getData().isSucc) {
                    if (this.a.r6().t() != null && this.a.r6().t().getGodUserData() != null) {
                        this.a.r6().t().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.C0 != null && this.a.C0.r1() != null && this.a.C0.r1().O() != null && this.a.C0.r1().O().getAuthor() != null) {
                        this.a.C0.r1().O().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
                if (updateAttentionMessage.isAttention()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921760, 10));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n1 implements z45.e {
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

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                z45Var.dismiss();
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
                if (this.a.B2 && this.a.w6()) {
                    this.a.k7();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (this.a.K0 != null) {
                    this.a.K0.r3();
                }
                if (!this.a.g0 && this.a.K0 != null && this.a.K0.v0() && this.a.C0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.C0.L1());
                    statisticItem.param("fid", this.a.C0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.C0.W0()) {
                        i = 4;
                    } else if (this.a.C0.X0()) {
                        i = 3;
                    } else if (this.a.C0.Z0()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.g0 = true;
                }
                if (this.a.C0.o2(false)) {
                    this.a.K0.T3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (this.a.C0.r1() != null) {
                    this.a.K0.l3();
                }
                this.a.B2 = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements xo9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.xo9.b
        public void onSuccess(List<zja> list) {
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

        @Override // com.baidu.tieba.xo9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.K0.L4(str);
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
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.fq5
        /* renamed from: g */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId > 0 && this.a.b.getPageId() == tipEvent.pageId) {
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
                this.a.K0.F0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.C0 != null && !this.a.C0.isLoading) {
                    this.a.F8();
                    this.a.K0.S3();
                    z = true;
                    if (this.a.C0.r1() != null && this.a.C0.r1().f != null && this.a.C0.r1().f.size() > i) {
                        int intValue = this.a.C0.r1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.C0.M1()).param("fid", this.a.C0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.C0.l3(intValue)) {
                            this.a.i = true;
                            this.a.K0.H3(true);
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.C0 != null) {
                this.a.C0.loadData();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.C0 != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.Z0 != null) {
                    this.a.K0.x3(this.a.Z0.z());
                }
                this.a.K0.p3();
                this.a.K0.F0();
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
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.fq5
        /* renamed from: g */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                if (this.a.K0 != null && topToastEvent != null) {
                    new BdTopToast(this.a.getContext()).setIcon(topToastEvent.isSuccess()).setContent(topToastEvent.getContent()).show(this.a.K0.G1());
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
            zja X;
            vh5 b0;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("PbFragment", "收到H5通知，更新Pb数据：" + str);
                if (this.a.C0 == null) {
                    return;
                }
                this.a.C0.loadData();
                lk9 r1 = this.a.C0.r1();
                if (r1 != null && (X = r1.X()) != null && (b0 = X.b0()) != null && !b0.n()) {
                    is5 is5Var = new is5();
                    is5Var.t(b0);
                    String Q = r1.Q();
                    String l = r1.l();
                    if (r1.O() != null) {
                        i = r1.O().getThreadType();
                    } else {
                        i = 0;
                    }
                    is5Var.v(Q, l, i, this.a.C0.K0(), this.a.C0.w1(), b0.d());
                    String x = is5Var.x(b0.e());
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(NovelWebViewActivityConfig.KEY_IS_SHOW_TOAST_TIP, true);
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_ID, String.valueOf(b0.h()));
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_TID, is5Var.i());
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_FID, is5Var.e());
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
            this.a.C0.o3((UserPendantData) customResponsedMessage.getData());
            if (this.a.K0 != null && this.a.C0 != null) {
                this.a.K0.j3(this.a.C0.r1(), this.a.C0.K1(), this.a.C0.C1(), this.a.K0.B1());
            }
            if (this.a.K0 != null && this.a.K0.T0() != null) {
                this.a.K0.T0().f0();
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
            qp9 qp9Var = this.b.K0;
            qp9Var.V3("@" + this.a.getStringExtra("big_pic_type") + " ");
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
            this.c.x8(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class q2 implements z45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ z45 c;
        public final /* synthetic */ PbFragment d;

        public q2(PbFragment pbFragment, MarkData markData, MarkData markData2, z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, z45Var};
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
            this.c = z45Var;
        }

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                z45Var.dismiss();
                if (this.d.E0 != null) {
                    if (this.d.E0.e()) {
                        this.d.E0.d();
                        this.d.E0.h(false);
                    }
                    this.d.E0.i(this.a);
                    this.d.E0.h(true);
                    this.d.E0.a();
                }
                this.b.setPostId(this.a.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.b);
                this.d.b.setResult(-1, intent);
                this.c.dismiss();
                this.d.G8();
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
                if (this.a.K0 == null) {
                    return;
                }
                if (booleanValue) {
                    this.a.K0.C4();
                } else {
                    this.a.K0.P1();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r0 implements Function0<ArrayList<bn>> {
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
        public ArrayList<bn> invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.K0 != null && this.a.K0.T0() != null) {
                    return this.a.K0.T0().v();
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
            this.c.x8(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class r2 implements z45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ z45 b;
        public final /* synthetic */ PbFragment c;

        public r2(PbFragment pbFragment, MarkData markData, z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, z45Var};
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
            this.b = z45Var;
        }

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                z45Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.b.setResult(-1, intent);
                this.b.dismiss();
                this.c.G8();
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
            if (this.a.Z0 != null) {
                this.a.K0.x3(this.a.Z0.z());
            }
            this.a.K0.k4(false);
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
                if (this.a.K0 != null && this.a.K0.T0() != null) {
                    this.a.K0.T0().f0();
                    return null;
                }
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s1 implements j55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h55 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ PbFragment c;

        public s1(PbFragment pbFragment, h55 h55Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, h55Var, view2};
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
            this.a = h55Var;
            this.b = view2;
        }

        @Override // com.baidu.tieba.j55.f
        public void G0(j55 j55Var, int i, View view2) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, j55Var, i, view2) == null) {
                this.a.dismiss();
                PbModel pbModel = this.c.C0;
                if (this.b.getId() == R.id.obfuscated_res_0x7f091b4c) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                kt9.L(i, pbModel, i2);
                if (this.c.C0.r1().f != null && this.c.C0.r1().f.size() > i) {
                    i = this.c.C0.r1().f.get(i).sort_type.intValue();
                }
                boolean l3 = this.c.C0.l3(i);
                this.b.setTag(Integer.valueOf(this.c.C0.I1()));
                if (!l3) {
                    return;
                }
                this.c.i = true;
                this.c.K0.H3(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ z45 b;
        public final /* synthetic */ PbFragment c;

        public s2(PbFragment pbFragment, MarkData markData, z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, z45Var};
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
            this.b = z45Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.K0 != null && this.c.K0.G1() != null) {
                    this.c.K0.G1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.b.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.G8();
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
                ti9 ti9Var = (ti9) customResponsedMessage.getData();
                int type = ti9Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (ti9Var.a() == null) {
                                this.a.S7(false, null);
                                return;
                            } else {
                                this.a.S7(true, (MarkData) ti9Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.l6((ForumManageModel.b) ti9Var.a(), false);
                    return;
                }
                this.a.T7((cl9) ti9Var.a());
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
                if (message.what == 2 && this.a.C0 != null && this.a.C0.c1()) {
                    this.a.p7();
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
                if (this.a.t0 && (view2 == this.a.K0.k.e || view2 == this.a.K0.k.f || view2.getId() == R.id.obfuscated_res_0x7f091b28 || view2.getId() == R.id.obfuscated_res_0x7f090b6e || view2.getId() == R.id.obfuscated_res_0x7f091ef3 || view2.getId() == R.id.obfuscated_res_0x7f091ac0)) {
                    return;
                }
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.K0.q1()) {
                        this.a.v7();
                    }
                } else {
                    this.a.Y7(view2);
                }
                if (view2 == this.a.K0.s1()) {
                    if (this.a.i || !this.a.C0.o2(true)) {
                        return;
                    }
                    this.a.i = true;
                    this.a.K0.T3();
                } else if (this.a.K0.k.i() == null || view2 != this.a.K0.k.i().z()) {
                    if (this.a.K0.k.i() == null || view2 != this.a.K0.k.i().g()) {
                        if (view2 == this.a.K0.k.h) {
                            if (!this.a.K0.u0(this.a.C0.e1())) {
                                BdUtilHelper.hideSoftKeyPad(this.a.b, this.a.K0.k.h);
                                this.a.b.finish();
                                return;
                            }
                            this.a.F8();
                            return;
                        } else if (view2 != this.a.K0.X0() && (this.a.K0.k.i() == null || (view2 != this.a.K0.k.i().B() && view2 != this.a.K0.k.i().C()))) {
                            if (view2 == this.a.K0.f1()) {
                                if (this.a.C0 != null) {
                                    BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), this.a.C0.r1().O().getTopicData().b());
                                    return;
                                }
                                return;
                            } else if (view2 != this.a.K0.k.e) {
                                if (view2 != this.a.K0.k.f) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f091ae7) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091abb) {
                                            if ((this.a.K0.k.i() == null || view2 != this.a.K0.k.i().x()) && view2.getId() != R.id.obfuscated_res_0x7f090b6e && view2.getId() != R.id.obfuscated_res_0x7f091ef3) {
                                                if (this.a.K0.k.i() != null && view2 == this.a.K0.k.i().h()) {
                                                    this.a.K0.k.f();
                                                    return;
                                                } else if (view2.getId() == R.id.share_num_container) {
                                                    if (!pp9.d(this.a.getPageContext(), 11009)) {
                                                        return;
                                                    }
                                                    pp9.w(this.a.getContext(), 3, this.a.q6(), this.a.C0);
                                                    return;
                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f091ac0 && view2.getId() != R.id.share_more_container) {
                                                    if (this.a.K0.k.i() == null || view2 != this.a.K0.k.i().y()) {
                                                        if (this.a.K0.k.i() == null || view2 != this.a.K0.k.i().G()) {
                                                            if (this.a.K0.k.i() != null && view2 == this.a.K0.k.i().F()) {
                                                                if (this.a.C0 != null && this.a.C0.r1() != null && this.a.C0.r1().O() != null) {
                                                                    this.a.K0.k.f();
                                                                    TiebaStatic.log(new StatisticItem("c13062"));
                                                                    PbFragment pbFragment = this.a;
                                                                    pbFragment.O6(pbFragment.C0.r1().O().getFirstPostId());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (this.a.K0.k.i() == null || view2 != this.a.K0.k.i().D()) {
                                                                if (this.a.K0.j1() != view2) {
                                                                    if (this.a.K0.k.i() == null || view2 != this.a.K0.k.i().t()) {
                                                                        if (this.a.K0.k.i() == null || view2 != this.a.K0.k.i().f()) {
                                                                            if (this.a.K0.k.i() == null || view2 != this.a.K0.k.i().s()) {
                                                                                if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f092302 && view2.getId() != R.id.obfuscated_res_0x7f091ad3 && view2.getId() != R.id.obfuscated_res_0x7f09194c) {
                                                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091b3e) {
                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091b3c && view2.getId() != R.id.obfuscated_res_0x7f091d09 && view2.getId() != R.id.obfuscated_res_0x7f091acd) {
                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091ad1) {
                                                                                                if (view2 != this.a.K0.h1()) {
                                                                                                    if (this.a.K0.k.i() != null && view2 == this.a.K0.k.i().E()) {
                                                                                                        this.a.K0.k.g();
                                                                                                        this.a.K0.z4(this.a.H2);
                                                                                                        return;
                                                                                                    } else if (this.a.K0.k.i() == null || view2 != this.a.K0.k.i().u()) {
                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f090863 && view2.getId() != R.id.obfuscated_res_0x7f090b6a) {
                                                                                                            if (view2.getId() != R.id.pb_u9_text_view) {
                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f091ef8 && view2.getId() != R.id.cover_reply_content && view2.getId() != R.id.replybtn_top_right && view2.getId() != R.id.cover_reply_content_top_right) {
                                                                                                                    if (view2.getId() != R.id.pb_act_btn) {
                                                                                                                        if (view2.getId() != R.id.lottery_tail) {
                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091b01 && view2.getId() != R.id.obfuscated_res_0x7f091ac8) {
                                                                                                                                if (view2.getId() != R.id.join_vote_tv) {
                                                                                                                                    if (view2.getId() != R.id.look_all_tv) {
                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f0916d2) {
                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f0916d1) {
                                                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f092778) {
                                                                                                                                                    if (view2.getId() == R.id.qq_share_container) {
                                                                                                                                                        if (!pp9.d(this.a.getPageContext(), 11009)) {
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        pp9.w(this.a.getContext(), 8, this.a.q6(), this.a.C0);
                                                                                                                                                        return;
                                                                                                                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f09194c) {
                                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091abd) {
                                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091b28) {
                                                                                                                                                                if (view2.getId() != R.id.forum_name_text && view2.getId() != R.id.forum_enter_button_one && view2.getId() != R.id.forum_enter_button_two && view2.getId() != R.id.forum_enter_button_three) {
                                                                                                                                                                    if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                                                                                                                        kt9.J(2, this.a.C0);
                                                                                                                                                                        return;
                                                                                                                                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f091b50) {
                                                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091b6a) {
                                                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091023) {
                                                                                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f091020) {
                                                                                                                                                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091ad5 && view2.getId() != R.id.obfuscated_res_0x7f091b36) {
                                                                                                                                                                                        return;
                                                                                                                                                                                    }
                                                                                                                                                                                    this.a.L8(view2);
                                                                                                                                                                                    return;
                                                                                                                                                                                }
                                                                                                                                                                                this.a.L5(view2);
                                                                                                                                                                                return;
                                                                                                                                                                            }
                                                                                                                                                                            this.a.M5(view2);
                                                                                                                                                                            return;
                                                                                                                                                                        }
                                                                                                                                                                        this.a.S8(view2);
                                                                                                                                                                        return;
                                                                                                                                                                    } else {
                                                                                                                                                                        this.a.J8();
                                                                                                                                                                        return;
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                this.a.i6(view2);
                                                                                                                                                                return;
                                                                                                                                                            }
                                                                                                                                                            this.a.K8();
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        this.a.g6();
                                                                                                                                                        return;
                                                                                                                                                    } else {
                                                                                                                                                        this.a.h7(view2);
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                this.a.I7();
                                                                                                                                                return;
                                                                                                                                            }
                                                                                                                                            this.a.k7();
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        this.a.m7();
                                                                                                                                        return;
                                                                                                                                    }
                                                                                                                                    this.a.f7(view2);
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                                this.a.d7(view2);
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            this.a.I8(view2);
                                                                                                                            return;
                                                                                                                        }
                                                                                                                        this.a.o7(view2);
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    this.a.e7();
                                                                                                                    return;
                                                                                                                }
                                                                                                                this.a.H7(view2);
                                                                                                                return;
                                                                                                            }
                                                                                                            this.a.K7(view2);
                                                                                                            return;
                                                                                                        }
                                                                                                        this.a.J7(view2);
                                                                                                        return;
                                                                                                    } else {
                                                                                                        this.a.Q6();
                                                                                                        return;
                                                                                                    }
                                                                                                }
                                                                                                this.a.T6();
                                                                                                return;
                                                                                            }
                                                                                            this.a.F7(view2);
                                                                                            return;
                                                                                        }
                                                                                        this.a.G7(view2);
                                                                                        return;
                                                                                    }
                                                                                    this.a.k6(view2);
                                                                                    return;
                                                                                }
                                                                                this.a.j6(view2);
                                                                                return;
                                                                            }
                                                                            this.a.e6();
                                                                            return;
                                                                        }
                                                                        this.a.K5();
                                                                        return;
                                                                    }
                                                                    this.a.o6();
                                                                    return;
                                                                }
                                                                this.a.M7();
                                                                return;
                                                            } else {
                                                                this.a.W5();
                                                                return;
                                                            }
                                                        }
                                                        this.a.W7(view2);
                                                        return;
                                                    }
                                                    this.a.g7();
                                                    return;
                                                } else {
                                                    this.a.E7(view2);
                                                    return;
                                                }
                                            }
                                            this.a.X7(view2);
                                            return;
                                        }
                                        this.a.h6(view2);
                                        return;
                                    }
                                    this.a.K6();
                                    return;
                                }
                                this.a.x7();
                                return;
                            } else {
                                this.a.w7();
                                return;
                            }
                        } else {
                            this.a.q7(view2);
                            return;
                        }
                    }
                    this.a.N5();
                } else {
                    this.a.j7();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t2 implements bg<ImageView> {
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
        @Override // com.baidu.tieba.bg
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.K0 != null && this.a.K0.T0() != null) {
                this.a.K0.T0().f0();
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
                    if (this.a.Z0 != null) {
                        this.a.Z0.H(null, null);
                    }
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.K0 != null && this.a.K0.x1() != null && this.a.K0.x1().f() != null) {
                    this.a.K0.x1().f().I();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || this.a.C0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.C0.b)) {
                return;
            }
            this.a.y8((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes7.dex */
    public class u2 implements bg<GifView> {
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
        @Override // com.baidu.tieba.bg
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f26.a)) {
                f26.a aVar = (f26.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.L6(aVar.b);
                }
                f26.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
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
    public class v2 implements bg<TiebaPlusRecommendCard> {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.g) {
                return;
            }
            this.a.C8();
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
    public class w2 implements xk5 {
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

        @Override // com.baidu.tieba.xk5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                tp9 tp9Var = this.a.O0;
                if (tp9Var != null && tp9Var.e() != null && this.a.O0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.O0.e().c());
                    if (this.a.Z0 != null && (this.a.Z0.y() || this.a.Z0.A())) {
                        this.a.Z0.w(false, this.a.O0.h());
                    }
                    this.a.O0.a(true);
                    return true;
                }
                return !this.a.T5(ReplyPrivacyCheckController.TYPE_THREAD);
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
            this.a.v = true;
        }
    }

    /* loaded from: classes7.dex */
    public class x0 implements gm9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.gm9.a
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

        @Override // com.baidu.tieba.gm9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091f19) {
                        if (this.a.a8(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09015a) {
                        if (motionEvent != null && motionEvent.getAction() == 1) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof zja)) {
                                return false;
                            }
                            zja zjaVar = (zja) obj;
                            if (zjaVar.getType() != zja.a1 && !TextUtils.isEmpty(zjaVar.v()) && m05.c().g()) {
                                return this.a.y7(zjaVar);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091ad2) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.D8((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.K0.m2() && view2.getId() == R.id.obfuscated_res_0x7f091af4) {
                            if (view2.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.tag_user_id)));
                            }
                            if (this.a.Y0() != null && this.a.Y0().b != null) {
                                this.a.Y0().b.onClick(view2);
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
                        this.a.D8(sparseArray);
                    }
                }
                if (this.a.Z0 != null) {
                    this.a.K0.x3(this.a.Z0.z());
                }
                this.a.K0.p3();
                this.a.K0.F0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.gm9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                this.a.f6((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null && (responsedMessage instanceof ThreadPublishHttpResMeesage) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.b.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                    if (this.a.K0 != null && (D1 = this.a.K0.D1()) != null && this.a.K0.m1() != null) {
                        this.a.K0.m1().removeHeaderView(D1);
                        return;
                    }
                    return;
                }
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x2 implements bg<View> {
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
                playVoiceBntNew.setVoiceManager(this.a.P0());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getResultData() instanceof String)) {
                new BdTopToast(this.a.getContext()).setIcon(false).setContent((String) customResponsedMessage.getResultData()).show((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y0 implements a55.c {
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

        @Override // com.baidu.tieba.a55.c
        public void a(a55 a55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, a55Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.R0 = pbFragment.R0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.R0);
                    new tn9(this.a.C0.L1(), this.a.R0, "1").start();
                    a55Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.R0 = pbFragment2.R0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.R0);
                    new tn9(this.a.C0.L1(), this.a.R0, "2").start();
                    a55Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.R0 = pbFragment3.R0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.R0);
                    a55Var.e();
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
        public void b(lk9 lk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lk9Var) == null) {
                this.a.K0.g2(lk9Var);
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
                j2 = System.currentTimeMillis() - this.a.m;
            } else {
                j2 = j;
            }
            if (this.a.n == 0) {
                this.a.n = j2;
            }
            long j4 = j2;
            gt5 gt5Var = new gt5(i, z, responsedMessage, this.a.q, this.a.p, this.a.n, z2, 0L, 0L, j4);
            this.a.p = 0L;
            this.a.q = 0L;
            gt5Var.c();
            if (z2) {
                j3 = j4;
                gt5Var.B = j3;
                gt5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.C0 != null && this.a.C0.r1() != null && this.a.C0.r1().O() != null) {
                int threadType = this.a.C0.r1().O().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.N, "from_personalize")) {
                        ct5 ct5Var = new ct5();
                        ct5Var.F = 1;
                        ct5Var.a(1005);
                        ct5Var.D = j3;
                        ct5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.N, "from_frs")) {
                        gt5 gt5Var2 = new gt5();
                        gt5Var2.a(1000);
                        gt5Var2.D = j3;
                        gt5Var2.d(threadType);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, lk9 lk9Var, String str, int i4) {
            boolean z2;
            ej5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), lk9Var, str, Integer.valueOf(i4)}) == null) {
                if (this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907a0));
                }
                if (z && lk9Var != null && lk9Var.Y() == null && ListUtils.getCount(lk9Var.F()) < 1) {
                    this.a.C0.f3(1);
                    if (this.a.f != null) {
                        this.a.f.x();
                    }
                    if (this.a.K0 != null) {
                        this.a.K0.D4();
                        return;
                    }
                    return;
                }
                if (this.a.h0) {
                    if (this.a.f0() != null) {
                        this.a.f0().y0();
                    }
                } else {
                    this.a.h0 = true;
                }
                this.a.h = true;
                if (this.a.K0 == null) {
                    return;
                }
                this.a.K0.R3();
                if (lk9Var == null || !lk9Var.s0()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.K0.G1());
                }
                this.a.K0.P1();
                int i5 = 0;
                if (this.a.K) {
                    this.a.K0.J1();
                } else if (!this.a.K0.l2()) {
                    this.a.K0.k4(false);
                }
                if (this.a.i) {
                    this.a.i = false;
                }
                if (i4 == 0 && lk9Var != null) {
                    this.a.S0 = true;
                }
                if (lk9Var != null) {
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.hideNetRefreshView(pbFragment2.K0.G1());
                    this.a.K0.d4();
                }
                ArrayList<zja> arrayList = null;
                String y1 = null;
                arrayList = null;
                if (z && lk9Var != null) {
                    ThreadData O = lk9Var.O();
                    if (O != null && O.isUgcThreadType()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = this.a;
                        pbFragment3.i8(pbFragment3.Y0);
                    }
                    this.a.K0.x1().r(lk9Var);
                    this.a.K0.r4();
                    if (O != null && O.getCartoonThreadData() != null) {
                        this.a.Q8(O.getCartoonThreadData());
                    }
                    if (this.a.Z0 != null) {
                        this.a.K0.x3(this.a.Z0.z());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(lk9Var.V().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(lk9Var.V().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(lk9Var.V().getBimg_end_time());
                    if (lk9Var.F() != null && lk9Var.F().size() >= 1 && lk9Var.F().get(0) != null) {
                        this.a.C0.R2(lk9Var.F().get(0).U());
                    } else if (lk9Var.Y() != null) {
                        this.a.C0.R2(lk9Var.Y().U());
                    }
                    if (this.a.Z0 != null) {
                        this.a.Z0.I(lk9Var.c());
                        this.a.Z0.J(lk9Var.k(), lk9Var.V());
                        this.a.Z0.l0(O);
                        this.a.Z0.K(this.a.C0.T0(), this.a.C0.L1(), this.a.C0.P0());
                        if (O != null) {
                            this.a.Z0.a0(O.isMutiForumThread());
                        }
                    }
                    if (this.a.E0 != null) {
                        this.a.E0.h(lk9Var.q());
                    }
                    PbFragment pbFragment4 = this.a;
                    if (lk9Var.r() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    pbFragment4.r = z2;
                    if (lk9Var.j0()) {
                        this.a.r = true;
                    }
                    this.a.K0.y3(this.a.r);
                    if (this.a.v0.f.size() > 0) {
                        lk9Var.T0(this.a.v0.f);
                    }
                    this.a.K0.v4(lk9Var, i2, i3, this.a.C0.K1(), i4, this.a.C0.a1());
                    this.a.K0.K4(lk9Var, this.a.C0.K1());
                    this.a.K0.S4(this.a.C0.U0());
                    AntiData c = lk9Var.c();
                    if (c != null) {
                        this.a.y = c.getVoice_message();
                        if (!StringUtils.isNull(this.a.y) && this.a.Z0 != null && this.a.Z0.a() != null && (o = this.a.Z0.a().o(6)) != null && !TextUtils.isEmpty(this.a.y)) {
                            ((View) o).setOnClickListener(this.a.J1);
                        }
                    }
                    if (!this.a.Y && !ListUtils.isEmpty(this.a.C0.r1().F()) && !this.a.C0.f2()) {
                        this.a.Y = true;
                        this.a.O5(false);
                    }
                    if (!TextUtils.isEmpty(this.a.V0)) {
                        PbFragment pbFragment5 = this.a;
                        pp9.H(pbFragment5, pbFragment5.C0.q1(), this.a.V0);
                        this.a.V0 = null;
                    } else if (!this.a.U0) {
                        if (!this.a.W0) {
                            if (!TextUtils.isEmpty(this.a.C0.h1())) {
                                vq9.f(this.a.getListView(), this.a.C0.h1());
                                this.a.C0.m2();
                            } else {
                                this.a.K0.q4();
                            }
                        } else {
                            this.a.W0 = false;
                            vq9.k(this.a.getListView());
                        }
                    } else {
                        this.a.U0 = false;
                        if (this.a.G6() != null && this.a.G6().o1() != null && this.a.G6().o1().getVisibility() == 0 && this.a.G6().o1().getPlayerHeight() > 0) {
                            PbFragment pbFragment6 = this.a;
                            pp9.F(pbFragment6, pbFragment6.G6().o1().getPlayerHeight());
                        } else {
                            pp9.F(this.a, 0);
                        }
                    }
                    this.a.C0.n2(lk9Var.k(), this.a.P1);
                    this.a.C0.r2(this.a.R1);
                    if (this.a.b1 != null && O != null && O.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(O.getAuthor());
                        this.a.b1.setLikeUserData(attentionHostData);
                    }
                    if (this.a.C0 != null && this.a.C0.b2()) {
                        y1 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.K0 != null) {
                        y1 = this.a.K0.y1();
                    }
                    if (this.a.Z0 != null && !StringUtils.isNull(y1)) {
                        this.a.Z0.d0(TbSingleton.getInstance().getAdVertiComment(lk9Var.q0(), lk9Var.r0(), y1));
                    }
                    if (!this.a.S0 && ((i2 == 1 || i2 == 2) && this.a.K0 != null)) {
                        this.a.K0.Q0();
                    }
                    wra.c(this.a, new Pair[0]);
                } else if (str != null) {
                    wra.a(this.a, new Pair(PushMessageHelper.ERROR_TYPE, Integer.toString(i)), new Pair("error_info", str));
                    if (!this.a.S0 && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6 || i2 == 9) {
                            if (i == 4) {
                                if (this.a.C0.G0() != null && !StringUtils.isNull(this.a.C0.G0().c)) {
                                    this.a.K0.U4(this.a.C0.G0());
                                } else {
                                    PbFragment pbFragment7 = this.a;
                                    pbFragment7.showNetRefreshView(pbFragment7.K0.G1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    dca.a("pb", false);
                                    PbFragment pbFragment8 = this.a;
                                    pbFragment8.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment8.getContext(), R.dimen.obfuscated_res_0x7f0703cc));
                                }
                            } else {
                                PbFragment pbFragment9 = this.a;
                                pbFragment9.showNetRefreshView(pbFragment9.K0.G1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                dca.a("pb", false);
                                PbFragment pbFragment10 = this.a;
                                pbFragment10.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment10.getContext(), R.dimen.obfuscated_res_0x7f0703cc));
                            }
                            this.a.K0.J1();
                            this.a.K0.I1();
                        }
                    } else {
                        this.a.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.C0.L1());
                            jSONObject.put("fid", this.a.C0.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                        nu6.b().b(new oe5(this.a.C0.L1()));
                    }
                    if (i != 0) {
                        EnterForePvThread enterForePvThread = new EnterForePvThread();
                        enterForePvThread.setOpType("2");
                        enterForePvThread.start();
                    }
                    if (i != -1) {
                        if (this.a.C0 != null && this.a.C0.r1() != null) {
                            arrayList = this.a.C0.r1().F();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).L() != 1)) {
                            this.a.K0.t3(this.a.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (this.a.b7()) {
                                this.a.K0.u3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1007));
                            } else {
                                this.a.K0.u3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1008));
                            }
                            this.a.K0.g2(this.a.C0.r1());
                        }
                    } else {
                        this.a.K0.t3("");
                    }
                    this.a.K0.M0();
                }
                if (lk9Var != null && lk9Var.m && this.a.n == 0) {
                    this.a.n = System.currentTimeMillis() - this.a.m;
                }
                if (this.a.b instanceof PbActivity) {
                    PbActivity pbActivity = (PbActivity) this.a.b;
                    if (lk9Var != null) {
                        i5 = lk9Var.f();
                    }
                    pbActivity.f2(i5, this.a.K0);
                }
                if (this.a.C0 != null && this.a.C0.r1() != null) {
                    this.a.C0.r1();
                }
            }
        }

        public final void d() {
            Bundle extras;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.a.C0 == null) {
                return;
            }
            if (this.a.Z0 != null && this.a.Z0.t) {
                return;
            }
            al5 al5Var = new al5();
            this.a.i8(al5Var);
            PbFragment pbFragment = this.a;
            pbFragment.Z0 = (bl5) al5Var.a(pbFragment.getContext());
            this.a.Z0.X(this.a.b.getPageContext());
            this.a.Z0.g0(this.a.p2);
            this.a.Z0.h0(this.a.d1);
            bl5 bl5Var = this.a.Z0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.b.getPageContext();
            if (this.a.b.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.b.getIntent().getExtras();
            }
            bl5Var.B(pageContext, extras);
            this.a.Z0.a().F(true);
            this.a.K0.s3(this.a.Z0.a());
            if (!this.a.C0.e1()) {
                this.a.Z0.q(this.a.C0.L1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.Z0.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.C0.b2()) {
                this.a.Z0.d0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.K0 != null) {
                this.a.Z0.d0(this.a.K0.y1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y2 implements bg<RelativeLayout> {
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
                if (error != 0 || !booleanValue || !TbadkCoreApplication.isLogin() || this.a.E0 == null || this.a.E0.e()) {
                    return;
                }
                this.a.s7();
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
            this.a.P8();
        }
    }

    /* loaded from: classes7.dex */
    public class z2 implements bg<ItemCardView> {
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
        U2 = new e1();
        V2 = new f();
    }

    public static PbFragment z7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65721, null)) == null) {
            return new PbFragment();
        }
        return (PbFragment) invokeV.objValue;
    }

    public int A6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.Q2;
        }
        return invokeV.intValue;
    }

    public int B6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.P2;
        }
        return invokeV.intValue;
    }

    @Nullable
    public final lk9 C6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                return pbModel.r1();
            }
            return null;
        }
        return (lk9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i26
    public ag<ItemCardView> D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.G == null) {
                this.G = new ag<>(new z2(this), 10, 0);
            }
            return this.G;
        }
        return (ag) invokeV.objValue;
    }

    public bl5 D6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.Z0;
        }
        return (bl5) invokeV.objValue;
    }

    public void D7() {
        lg5 lg5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (lg5Var = this.r0) != null) {
            lg5Var.q();
        }
    }

    public br9 E6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.f;
        }
        return (br9) invokeV.objValue;
    }

    public pr9 F6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.v0;
        }
        return (pr9) invokeV.objValue;
    }

    public final void F8() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (voiceManager = this.j) != null) {
            voiceManager.stopPlay();
        }
    }

    @Override // com.baidu.tieba.i26
    public ag<GifView> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.M == null) {
                this.M = new ag<>(new u2(this), 20, 0);
            }
            return this.M;
        }
        return (ag) invokeV.objValue;
    }

    public qp9 G6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.K0;
        }
        return (qp9) invokeV.objValue;
    }

    public final void G8() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (absPbActivity = this.b) != null) {
            absPbActivity.V1();
        }
    }

    public String I6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.W;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i26
    public ag<LinearLayout> K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (this.E == null) {
                this.E = new ag<>(new c(this), 15, 0);
            }
            return this.E;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xra
    @NonNull
    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            String t6 = t6();
            if (TextUtils.isEmpty(t6)) {
                return "unknown";
            }
            return t6;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i26
    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            qp9 qp9Var = this.K0;
            if (qp9Var == null) {
                return 0;
            }
            return qp9Var.A1();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.j;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public boolean P7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            lg5 lg5Var = this.r0;
            if (lg5Var != null && lg5Var.t()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.k2();
        }
        return invokeV.booleanValue;
    }

    public void S6() {
        qp9 qp9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048655, this) == null) && (qp9Var = this.K0) != null) {
            qp9Var.L1();
            R6();
        }
    }

    public final void U7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            hideNetRefreshView(this.K0.G1());
            u8();
            if (this.C0.s2()) {
                this.K0.S3();
            }
            this.K0.d4();
        }
    }

    public final void V6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.R = likeModel;
            likeModel.setLoadDataCallBack(new v0(this));
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ag<TbImageView> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            if (this.A == null) {
                this.A = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (ag) invokeV.objValue;
    }

    public final void W6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            yr9 yr9Var = new yr9(getPageContext());
            yr9Var.m();
            this.c1 = yr9Var;
        }
    }

    public ar9 Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return this.b.Y0();
        }
        return (ar9) invokeV.objValue;
    }

    public boolean Y6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                return pbModel.W0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean Z6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            AbsPbActivity absPbActivity = this.b;
            if (absPbActivity != null && absPbActivity.J1() != null && this.b.J1().q1() == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void Z7() {
        lg5 lg5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048683, this) == null) && (lg5Var = this.r0) != null) {
            lg5Var.x();
        }
    }

    @Override // com.baidu.tieba.i26
    public ag<TiebaPlusRecommendCard> b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            if (this.D == null) {
                this.D = new ag<>(new v2(this), 5, 0);
            }
            return this.D;
        }
        return (ag) invokeV.objValue;
    }

    public boolean b7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                return pbModel.U0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ot9
    public PbModel.h c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.t2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return this.t0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ot9
    public PbModel f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            return this.C0;
        }
        return (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i26
    public ag<RelativeLayout> g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            ag<RelativeLayout> agVar = new ag<>(new y2(this), 10, 0);
            this.F = agVar;
            return agVar;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xra
    @NonNull
    public String getTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) {
            return Integer.toString(this.a.getId());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i26
    public ag<FestivalTipView> j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) {
            if (this.I == null) {
                this.I = TbRichTextView.G(getContext(), R.dimen.M_H_X004);
            }
            return this.I;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i26
    public ag<ImageView> k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            if (this.B == null) {
                this.B = new ag<>(new t2(this), 8, 0);
            }
            return this.B;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i26
    public ag<View> l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            if (this.C == null) {
                this.C = new ag<>(new x2(this), 8, 0);
            }
            return this.C;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ot9
    public AbsPbActivity m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            return this.b;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.e0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public fn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (fn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048756, this) == null) {
            U7();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048761, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    public AntiData p6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.r1() != null) {
                return this.C0.r1().c();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    public final void p7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048766, this) == null) {
            lk9 r12 = this.C0.r1();
            this.C0.h3(true);
            gw4 gw4Var = this.E0;
            if (gw4Var != null) {
                r12.L0(gw4Var.g());
            }
            this.K0.g2(r12);
        }
    }

    @Override // com.baidu.tieba.i26
    public ag<TextView> q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) {
            if (this.z == null) {
                this.z = TbRichTextView.H(getContext(), 8);
            }
            return this.z;
        }
        return (ag) invokeV.objValue;
    }

    public zja r6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048772, this)) == null) {
            lk9 lk9Var = this.C0.G;
            if (lk9Var != null) {
                return lk9Var.X();
            }
            return null;
        }
        return (zja) invokeV.objValue;
    }

    public void r7() {
        qp9 qp9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048773, this) != null) || (qp9Var = this.K0) == null) {
            return;
        }
        qp9Var.A2();
    }

    public int s6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) {
            return this.T2;
        }
        return invokeV.intValue;
    }

    public String t6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048779, this)) == null) {
            return this.N;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048783, this) == null) && (pbModel = this.C0) != null && !di.isEmpty(pbModel.L1())) {
            super.taskStart();
        }
    }

    public PbInterviewStatusView.f v6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048787, this)) == null) {
            return this.y0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    public boolean w6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048791, this)) == null) {
            if (!this.d && this.P2 == -1 && this.Q2 == -1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean x6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048795, this)) == null) {
            return this.q2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean y6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048799, this)) == null) {
            return this.L;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i26
    /* renamed from: z6 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048802, this)) == null) {
            qp9 qp9Var = this.K0;
            if (qp9Var == null) {
                return null;
            }
            return qp9Var.m1();
        }
        return (BdTypeListView) invokeV.objValue;
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
        this.a = BdUniqueId.gen();
        this.c = true;
        this.d = false;
        this.g = false;
        this.h = false;
        this.k = 0;
        this.l = null;
        this.m = -1L;
        this.n = 0L;
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        this.s = false;
        this.t = null;
        this.u = 0L;
        this.v = false;
        this.w = 0L;
        this.x = 1;
        this.y = null;
        this.J = false;
        this.K = false;
        this.L = false;
        this.N = "";
        this.O = true;
        this.P = false;
        this.Q = "";
        this.X = 3;
        this.Z = new int[2];
        this.b0 = -1;
        this.c0 = -1;
        this.e0 = BdUniqueId.gen();
        this.g0 = false;
        this.u0 = new x(this);
        this.x0 = false;
        this.y0 = new i0(this);
        this.z0 = new Handler(new t0(this));
        this.A0 = new p1(this);
        this.B0 = new a2(this);
        this.C0 = null;
        this.E0 = null;
        this.F0 = null;
        this.G0 = null;
        this.H0 = null;
        this.I0 = null;
        this.J0 = null;
        this.K0 = null;
        this.L0 = false;
        this.M0 = false;
        this.N0 = false;
        this.S0 = false;
        this.U0 = false;
        this.W0 = false;
        this.c1 = null;
        this.d1 = new l2(this);
        this.e1 = new w2(this);
        this.f1 = new h3(this);
        this.g1 = 0;
        this.r1 = false;
        this.s1 = 0;
        this.t1 = -1;
        this.v1 = 0;
        this.x1 = new k(this);
        this.y1 = new o(this);
        this.z1 = new p(this, 2004016);
        this.A1 = new q(this, 2016485);
        this.B1 = new r(this, 2001269);
        this.C1 = new s(this, 2004008);
        this.D1 = new t(this, 2004007);
        this.E1 = new u(this, 2004005);
        this.F1 = new v(this, 2001332);
        this.G1 = new w(this, 2921391);
        this.H1 = new y(this, 2921606);
        this.I1 = new z(this, 2921658);
        this.J1 = new a0(this);
        this.K1 = new b0(this, 2001369);
        this.L1 = new c0(this, 2921787);
        this.M1 = new d0(this, 2016488);
        this.N1 = new e0(this, 2016331);
        this.O1 = new f0(this, 2921746);
        this.P1 = new g0(this);
        this.Q1 = new h0(this, 2010045);
        this.R1 = new j0(this);
        this.S1 = new PraiseModel(getPageContext(), new k0(this));
        this.T1 = new l0(this);
        this.U1 = new n0(this, 2001115);
        this.V1 = new o0(this);
        this.W1 = new p0(this);
        this.Y1 = new gm9(new x0(this));
        this.Z1 = new z0(this);
        this.a2 = new a1(this, 2001427);
        this.b2 = new b1(this, 2001428);
        this.c2 = new c1(this, 2921634);
        this.d2 = new d1(this, 2001426);
        this.e2 = new f1(this, 2004021);
        this.f2 = new g1(this, 2016528);
        this.h2 = new h1(this, 2921724);
        this.i2 = new i1(this, 2921033);
        this.j2 = new j1(this);
        this.k2 = new k1(this);
        this.l2 = new l1(this);
        this.m2 = new o1(this);
        this.n2 = new t1(this);
        this.o2 = new u1(this, 2921480);
        this.p2 = new v1(this);
        this.q2 = Boolean.FALSE;
        this.r2 = new w1(this);
        this.s2 = new x1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.t2 = new y1(this);
        this.u2 = new z1(this, 2016450);
        this.v2 = new b2(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.w2 = new c2(this);
        this.x2 = new f2(this);
        this.y2 = new i2(this);
        this.z2 = new k2(this);
        this.A2 = new m2(this);
        this.C2 = new n2(this);
        this.D2 = new a3(this);
        this.E2 = null;
        this.F2 = new b3(this);
        this.G2 = new c3(this);
        this.H2 = new d3(this);
        this.I2 = new f3(this);
        this.J2 = new g3(this);
        this.K2 = new a(this);
        this.L2 = new b(this);
        this.M2 = new d(this);
        this.N2 = new e(this);
        this.O2 = new g(this);
        this.P2 = -1;
        this.Q2 = -1;
        this.T2 = 0;
    }

    @Override // com.baidu.tieba.ot9
    public void finish() {
        qp9 qp9Var;
        boolean z3;
        CardHListViewData p3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            qp9 qp9Var2 = this.K0;
            if (qp9Var2 != null) {
                qp9Var2.F0();
            }
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.r1() != null && !this.C0.r1().j0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.C0.r1().O().getId();
                if (this.C0.isShareThread() && this.C0.r1().O().originalThreadData != null) {
                    historyMessage.threadName = this.C0.r1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.C0.r1().O().getTitle();
                }
                if (this.C0.isShareThread() && !Q0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.C0.r1().k().getName();
                }
                ArrayList<zja> F = this.C0.r1().F();
                qp9 qp9Var3 = this.K0;
                if (qp9Var3 != null) {
                    i4 = qp9Var3.d1();
                } else {
                    i4 = 0;
                }
                if (F != null && i4 >= 0 && i4 < F.size()) {
                    historyMessage.postID = F.get(i4).U();
                }
                historyMessage.isHostOnly = this.C0.U0();
                historyMessage.isSquence = this.C0.K1();
                historyMessage.isShareThread = this.C0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            PbModel pbModel2 = this.C0;
            if (pbModel2 != null && (pbModel2.W0() || this.C0.Z0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.C0.L1());
                if (this.L0) {
                    if (this.N0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.C0.f1());
                    }
                    if (this.M0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.C0.b1());
                    }
                }
                if (this.C0.Z0() && this.C0.r1() != null && this.C0.r1().O() != null) {
                    nu6.b().b(new ol5(this.C0.P()));
                }
                if (this.C0.r1() != null && System.currentTimeMillis() - this.o >= 40000 && (p3 = this.C0.r1().p()) != null && !ListUtils.isEmpty(p3.getDataList())) {
                    intent.putExtra("guess_like_data", p3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.t1);
                }
                this.b.setResult(-1, intent);
            }
            if (H8()) {
                if (this.C0 != null && (qp9Var = this.K0) != null && qp9Var.m1() != null) {
                    lk9 r12 = this.C0.r1();
                    if (r12 != null) {
                        if (r12.V() != null) {
                            r12.V().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            r12.V().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!r12.s0() && !this.J && r12.h == null) {
                            hp9 b4 = hp9.b();
                            lk9 s12 = this.C0.s1();
                            Parcelable onSaveInstanceState = this.K0.m1().onSaveInstanceState();
                            boolean K1 = this.C0.K1();
                            boolean U0 = this.C0.U0();
                            if (this.K0.v1() != null && this.K0.v1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.l(s12, onSaveInstanceState, K1, U0, z3);
                            if (this.s1 >= 0 || this.C0.N1() != null) {
                                hp9.b().o(this.C0.N1());
                                hp9.b().p(this.C0.O1());
                                hp9.b().m(this.C0.k1());
                            }
                        }
                    }
                } else {
                    hp9.b().k();
                }
                G8();
            }
            yr9 yr9Var = this.c1;
            if (yr9Var != null && !yr9Var.o() && R5() && this.C0.Z0() && !TextUtils.isEmpty(this.C0.P())) {
                this.c1.n(this.C0.r1().g().l, this.C0.P());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e3, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0159, code lost:
        if ((r7.h1.a.getView().getTop() - r11.K0.k.a.getBottom()) < (r11.K0.h1.a.g.getHeight() + 10)) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g6() {
        PbModel pbModel;
        int top;
        boolean z3;
        boolean z4;
        qp9.g1 g1Var;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        ks9 ks9Var;
        PbReplyTitleViewHolder pbReplyTitleViewHolder2;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048709, this) == null) && this.K0.m1() != null && (pbModel = this.C0) != null && pbModel.r1() != null) {
            int firstVisiblePosition = this.K0.m1().getFirstVisiblePosition();
            int i4 = 0;
            View childAt = this.K0.m1().getChildAt(0);
            if (childAt == null) {
                top = 0;
            } else {
                top = childAt.getTop();
            }
            boolean x02 = this.C0.r1().x0();
            boolean r22 = this.K0.r2();
            if (firstVisiblePosition == 0 && top == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            pp9.g(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.C0.r1());
            if ((this.C0.r1().O() != null && this.C0.r1().O().getReply_num() <= 0) || (r22 && z3)) {
                kt9.O(1, 1);
                if (!checkUpIsLogin()) {
                    kt9.O(2, 1);
                    return;
                }
                N7();
                if (this.C0.r1().O().getAuthor() != null) {
                    kt9.y(2, this.C0);
                }
            } else {
                int equipmentHeight = (int) (BdUtilHelper.getEquipmentHeight(getContext()) * 0.6d);
                if (x02) {
                    qp9.g1 g1Var2 = this.K0.h1;
                    if (g1Var2 != null) {
                        PbReplyTitleViewHolder pbReplyTitleViewHolder3 = g1Var2.a;
                        if (pbReplyTitleViewHolder3 != null && pbReplyTitleViewHolder3.getView() != null) {
                            if (this.K0.h1.a.getView().getParent() != null) {
                            }
                        }
                    }
                    z4 = false;
                } else {
                    if (this.K0.v1() != null) {
                        if (this.K0.v1().getVisibility() == 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z4 && (g1Var = this.K0.h1) != null && (pbReplyTitleViewHolder = g1Var.a) != null && pbReplyTitleViewHolder.getView() != null && this.K0.h1.a.getView().getParent() != null && (ks9Var = (r7 = this.K0).k) != null && ks9Var.a != null) {
                        }
                    }
                    z4 = false;
                }
                if (!z4 && !r22) {
                    if (this.b0 > 0) {
                        if (this.K0.m1().getChildAt(this.b0) != null) {
                            this.K0.m1().D(this.b0, this.c0, 200);
                        } else {
                            this.K0.m1().setSelectionFromTop(this.b0, this.c0 + equipmentHeight);
                            this.K0.m1().smoothScrollBy(equipmentHeight, 500);
                        }
                    } else {
                        int d4 = vq9.d(getListView());
                        if (vq9.e(getListView()) != -1) {
                            d4--;
                        }
                        int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds100);
                        if (d4 < 0) {
                            d4 = (ListUtils.getCount(this.K0.m1().getData()) - 1) + this.K0.m1().getHeaderViewsCount();
                        } else {
                            i4 = dimens;
                        }
                        ks9 ks9Var2 = this.K0.k;
                        if (ks9Var2 != null && (navigationBar = ks9Var2.a) != null) {
                            i4 += navigationBar.getFixedNavHeight() - 10;
                        }
                        qp9.g1 g1Var3 = this.K0.h1;
                        if (g1Var3 != null && (pbReplyTitleViewHolder2 = g1Var3.a) != null && pbReplyTitleViewHolder2.getView() != null && this.K0.h1.a.getView().getParent() != null) {
                            this.K0.m1().D(d4, i4, 200);
                        } else {
                            this.K0.m1().setSelectionFromTop(d4, i4 + equipmentHeight);
                            this.K0.m1().smoothScrollBy(equipmentHeight, 500);
                        }
                    }
                } else {
                    this.b0 = firstVisiblePosition;
                    this.c0 = top;
                    if (firstVisiblePosition <= 3 && (firstVisiblePosition != 3 || top >= (-equipmentHeight))) {
                        this.K0.m1().D(0, 0, 500);
                    } else {
                        int i5 = -equipmentHeight;
                        this.K0.m1().setSelectionFromTop(0, i5);
                        this.K0.m1().smoothScrollBy(i5, 500);
                    }
                }
            }
            if (this.C0.r1().O() != null && this.C0.r1().O().getAuthor() != null) {
                kt9.y(2, this.C0);
            }
        }
    }

    @Override // com.baidu.tieba.xt9.b
    public void C1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z3) == null) {
            this.T0 = z3;
        }
    }

    public void E5(i3 i3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, i3Var) == null) && i3Var != null) {
            if (this.u1 == null) {
                this.u1 = new ArrayList();
            }
            if (!this.u1.contains(i3Var)) {
                this.u1.add(i3Var);
            }
        }
    }

    public void F5(i3 i3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, i3Var) == null) && i3Var != null) {
            if (this.u1 == null) {
                this.u1 = new ArrayList();
            }
            if (!this.u1.contains(i3Var)) {
                this.u1.add(0, i3Var);
            }
        }
    }

    public final void P6(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, intent) == null) {
            zr9.f(this, intent);
        }
    }

    public final void Q8(x15 x15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048647, this, x15Var) == null) && x15Var != null) {
            this.S2 = x15Var;
            this.d = true;
            this.K0.n3();
            this.K0.G3(this.R2);
        }
    }

    public void V7(i3 i3Var) {
        List<i3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048668, this, i3Var) == null) && i3Var != null && (list = this.u1) != null) {
            list.remove(i3Var);
        }
    }

    public final void d8(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048699, this, i4) == null) && this.C0 != null) {
            u8();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i4);
            privacySettingMessage.setTid(this.C0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void e8(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048702, this, i4) == null) {
            this.T2 = i4;
        }
    }

    public void f8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048706, this, z3) == null) {
            this.q2 = Boolean.valueOf(z3);
        }
    }

    public void g8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048711, this, z3) == null) {
            this.t0 = z3;
        }
    }

    public final void h7(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, view2) == null) {
            if (view2.getTag() instanceof SparseArray) {
                sparseArray = (SparseArray) view2.getTag();
            } else {
                sparseArray = null;
            }
            if (sparseArray == null) {
                return;
            }
            D8(sparseArray);
        }
    }

    public void h8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048716, this, z3) == null) {
            this.O = z3;
        }
    }

    public final void i7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            BrowserHelper.startWebActivity(getContext(), "", str, false, true, true, bundle);
        }
    }

    public void k8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048727, this, z3) == null) {
            this.L = z3;
        }
    }

    public final void l8(boolean z3) {
        bl5 bl5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048731, this, z3) != null) || (bl5Var = this.Z0) == null) {
            return;
        }
        bl5Var.Y(z3);
        this.Z0.b0(z3);
        this.Z0.j0(z3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048746, this, context) == null) {
            super.onAttach(context);
            this.b = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tieba.z45.e
    public void onClick(z45 z45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048748, this, z45Var) == null) {
            c6(z45Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.l9
    public void onPreLoad(fn fnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, fnVar) == null) {
            PreLoadImageHelper.load(fnVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(fnVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048760, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.C0.N2(bundle);
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            bl5 bl5Var = this.Z0;
            if (bl5Var != null) {
                bl5Var.G(bundle);
            }
        }
    }

    public final void t7(View view2) {
        SparseArray sparseArray;
        zja zjaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048780, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (zjaVar = (zja) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            u7(zjaVar);
        }
    }

    public final void z8(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048803, this, i4) == null) {
            zr9.i(this, q6(), i4);
        }
    }

    @Override // com.baidu.tieba.i26
    public void U(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048661, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.v = true;
        }
    }

    @Override // com.baidu.tieba.i26
    public void X(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048673, this, context, str) == null) {
            wp9.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.v = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        qp9 qp9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048755, this, i4, keyEvent)) == null) {
            if (keyEvent != null && (qp9Var = this.K0) != null) {
                return qp9Var.I2(i4);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.i26
    public void x0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048794, this, context, str) == null) {
            this.v = true;
        }
    }

    public void A7() {
        List<i3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (list = this.u1) != null && !list.isEmpty()) {
            int size = this.u1.size();
            while (true) {
                size--;
                if (size <= -1 || this.u1.get(size).onBackPressed()) {
                    return;
                }
            }
        }
    }

    public final void B7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.K0.F0();
            if (this.i) {
                return;
            }
            F8();
            this.K0.S3();
            if (this.C0.loadData()) {
                this.K0.C4();
            }
        }
    }

    public final void C8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (pbModel = this.C0) != null && !di.isEmpty(pbModel.L1())) {
            mt4.w().Q(lt4.Z, JavaTypesHelper.toLong(this.C0.L1(), 0L));
        }
    }

    public final void Q6() {
        TiebaPlusConfigData tiebaPlusConfigData;
        String jumpUrlWithTid;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && (tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData()) != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.C0.L1())) != null) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{jumpUrlWithTid});
            this.K0.k.f();
            TiebaPlusConfigData.addClickStatsForFireLink(3);
        }
    }

    public final boolean R5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.r1() != null && this.C0.r1().g() != null && !TextUtils.isEmpty(this.C0.r1().g().l)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void R6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048649, this) == null) && this.b != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.b.getCurrentFocus() != null) {
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), this.b.getCurrentFocus());
        }
    }

    public final void b8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048691, this) == null) && (pbModel = this.C0) != null && pbModel.r1() != null && this.C0.r1().O() != null && this.C0.r1().O().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final boolean c7() {
        InterceptResult invokeV;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            if (oi9.c() && (pbModel = this.C0) != null && pbModel.r1() != null && this.C0.r1().i() != null && this.C0.r1().i().y() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048696, this) == null) && (pbModel = this.C0) != null && pbModel.r1() != null && this.C0.r1().O() != null && this.C0.r1().O().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public final int q6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) {
            if (this.C0.r1() != null && this.C0.r1().O() != null) {
                return this.C0.r1().O().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final boolean q8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel == null || !pbModel.K1()) {
                return false;
            }
            if (this.C0.p1() != null && this.C0.p1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void v8() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048789, this) == null) && ms9.b() && !this.K0.a3()) {
            lg5 showPushOpenView = PushOpenUtil.showPushOpenView(getPageContext(), "reply_pb", 0L);
            this.r0 = showPushOpenView;
            if (showPushOpenView != null) {
                o3a.e().h("reply_pb");
            }
        }
    }

    public final void w8() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048793, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && ms9.a() && !this.K0.a3()) {
            lg5 showPushOpenView = PushOpenUtil.showPushOpenView(getPageContext(), "collect", 0L);
            this.r0 = showPushOpenView;
            if (showPushOpenView != null) {
                o3a.e().h("collect");
            }
        }
    }

    public final void A8(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (str == null) {
                str = "";
            }
            BdPageContext bdPageContext = this.i1;
            if (bdPageContext == null) {
                return;
            }
            z45 z45Var = new z45(bdPageContext.getPageActivity());
            z45Var.setMessage(str);
            z45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b5b, new j(this));
            z45Var.create(this.i1).show();
        }
    }

    public final void D8(SparseArray<Object> sparseArray) {
        zja zjaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof zja) || (zjaVar = (zja) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        E8(zjaVar, false);
    }

    public final void L5(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048621, this, view2) != null) || !(view2.getTag() instanceof ThreadData) || !checkUpIsLogin()) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        LikeModel likeModel = this.R;
        if (likeModel != null) {
            likeModel.e0(threadData.getForum_name(), String.valueOf(threadData.getFid()));
        }
        kt9.I(threadData, 10, 11);
    }

    public final void L6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 4).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public final void L8(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048624, this, view2) != null) || this.t0) {
            return;
        }
        kt9.J(7, this.C0);
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray != null && (sparseArray.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_is_top_question)).booleanValue()) {
            kt9.w(6);
        }
        this.c = false;
        X5(view2);
    }

    public final void O8(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i4) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.C0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(sr9.n(i4))));
        }
    }

    public final void Q7(View view2) {
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048646, this, view2) != null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        if (this.c) {
            i4 = 2;
        } else {
            i4 = 3;
        }
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(i4));
        view2.setTag(sparseArray);
    }

    public final void S8(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048657, this, view2) == null) && (view2.getTag() instanceof SmartApp)) {
            SmartApp smartApp = (SmartApp) view2.getTag();
            if (!TbAiappsLaunchUtil.launch(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                if (StringUtils.isNull(smartApp.h5_url)) {
                    return;
                }
                BrowserHelper.startWebActivity(getActivity(), smartApp.h5_url);
            }
            kt9.z(smartApp, this.C0);
        }
    }

    public final void n6(Rect rect) {
        qp9 qp9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048737, this, rect) == null) && rect != null && (qp9Var = this.K0) != null && qp9Var.F1() != null && rect.top <= this.K0.F1().getHeight()) {
            rect.top += this.K0.F1().getHeight() - rect.top;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048764, this, z3) == null) {
            super.onUserChanged(z3);
            this.K0.T4(z3);
            h55 h55Var = this.P0;
            if (h55Var != null) {
                h55Var.dismiss();
            }
            if (z3 && this.T0) {
                this.K0.T3();
                this.C0.o2(true);
            }
            if (this.K0.T0() != null) {
                this.K0.T0().j0(z3);
            }
        }
    }

    public final void B8(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.K0.s4();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            z45 z45Var = new z45(this.i1.getPageActivity());
            if (!di.isEmpty(str)) {
                z45Var.setMessage(str);
            } else {
                z45Var.setMessage(this.i1.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            z45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c4, new l(this, userMuteAddAndDelCustomMessage));
            z45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new m(this));
            z45Var.create(this.i1).show();
        }
    }

    public void C7() {
        PbModel pbModel;
        lk9 r12;
        ThreadData O;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        lk9 lk9Var;
        boolean z8;
        boolean z9;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (pbModel = this.C0) != null && pbModel.r1() != null && (O = (r12 = this.C0.r1()).O()) != null && O.getAuthor() != null) {
            this.K0.L1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
            zo9 zo9Var = new zo9();
            int W = this.C0.r1().W();
            if (W != 1 && W != 3) {
                zo9Var.g = false;
            } else {
                zo9Var.g = true;
                if (O.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zo9Var.s = z3;
            }
            if (pp9.z(this.C0.r1(), W)) {
                zo9Var.h = true;
                if (O.getIs_good() == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                zo9Var.r = z9;
            } else {
                zo9Var.h = false;
            }
            if (W == 1002 && !equals) {
                zo9Var.u = true;
            }
            zo9Var.n = pp9.L(O.isBlocked(), r12.n0(), equals, W, O.isWorksInfo(), O.isScoreThread());
            zo9Var.e = pp9.J(r12, equals, r12.n0(), this.C0.U());
            zo9Var.i = q8();
            zo9Var.f = pp9.K(this.C0.r1(), equals, this.C0.U());
            if (equals && r12.V() != null && r12.V().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            zo9Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                zo9Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            zo9Var.t = equals;
            zo9Var.q = this.C0.K1();
            zo9Var.b = true;
            zo9Var.a = pp9.C(this.C0.r1(), equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            zo9Var.p = z5;
            zo9Var.j = true;
            zo9Var.o = this.C0.U0();
            zo9Var.d = true;
            if (O.getThreadVideoInfo() == null) {
                z6 = true;
            } else {
                z6 = false;
            }
            zo9Var.c = z6;
            if (r12.j0()) {
                zo9Var.b = false;
                zo9Var.d = false;
                zo9Var.c = false;
                zo9Var.g = false;
                zo9Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !r12.j0()) {
                z7 = true;
            } else {
                z7 = false;
            }
            zo9Var.v = z7;
            if (this.K0 != null && (lk9Var = this.C0.G) != null) {
                zja X = lk9Var.X();
                if (X != null) {
                    z8 = X.f1184T;
                } else {
                    z8 = false;
                }
                zo9Var.w = z8;
            }
            zo9Var.m = true;
            if (O.isBlocked()) {
                zo9Var.n = false;
                zo9Var.g = false;
                zo9Var.h = false;
            }
            this.K0.k.x(zo9Var);
        }
    }

    public final void E7(View view2) {
        lk9 r12;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
            if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (r12 = this.C0.r1()) == null) {
                return;
            }
            ThreadData O = r12.O();
            if (O != null && O.getAuthor() != null) {
                kt9.y(4, this.C0);
            }
            PbModel pbModel = this.C0;
            AbsPbActivity m02 = m0();
            qp9 qp9Var = this.K0;
            int i5 = 6;
            if (view2.getId() == R.id.share_num_container) {
                i4 = 5;
            } else {
                i4 = 6;
            }
            kt9.P(pbModel, m02, qp9Var, i4);
            if (!BdUtilHelper.isNetOk()) {
                showToast(R.string.obfuscated_res_0x7f0f0e42);
            } else if (r12 == null) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1006));
            } else {
                ArrayList<zja> F = this.C0.r1().F();
                if ((F == null || F.size() <= 0) && this.C0.K1()) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1006));
                    return;
                }
                this.K0.F0();
                F8();
                if (r12.A() != null && !StringUtils.isNull(r12.A().a(), true)) {
                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.C0.r1().l()));
                }
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), O)) {
                    return;
                }
                qp9 qp9Var2 = this.K0;
                if (qp9Var2 != null) {
                    qp9Var2.H0();
                    this.K0.X4(r12);
                }
                if (ShareSwitch.isOn()) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091ac0) {
                        i5 = 2;
                    } else if (view2.getId() == R.id.share_num_container) {
                        i5 = 1;
                    }
                    if (this.K0.w2() && !r12.p0()) {
                        z8(i5);
                        return;
                    } else {
                        z8(i5);
                        return;
                    }
                }
                this.K0.s4();
                this.C0.L0().O(CheckRealNameModel.TYPE_PB_SHARE, 6);
            }
        }
    }

    public final void F7(View view2) {
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
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            String str = null;
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            zja zjaVar = (zja) sparseArray.get(R.id.tag_clip_board);
            if (zjaVar == null) {
                return;
            }
            if (this.Q0 == null) {
                j55 j55Var = new j55(getContext());
                this.Q0 = j55Var;
                j55Var.q(this.l2);
            }
            ArrayList arrayList = new ArrayList();
            if (f0().r1() != null && f0().r1().j0()) {
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
                if (zjaVar.p() != null) {
                    boolean z10 = zjaVar.p().hasAgree;
                    int q3 = zjaVar.q();
                    if (z10 && q3 == 5) {
                        string = getString(R.string.action_cancel_dislike);
                    } else {
                        string = getString(R.string.action_dislike);
                    }
                    f55 f55Var = new f55(8, string, this.Q0);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, zjaVar);
                    f55Var.d.setTag(sparseArray2);
                    arrayList.add(f55Var);
                }
                if (this.mIsLogin) {
                    J5(z6, z5, sparseArray, arrayList, z4, z3, str2);
                    H5(sparseArray, arrayList, z4, z6, z7, z8, z9, str2);
                }
                this.Q0.l(arrayList);
                h55 h55Var = new h55(getPageContext(), this.Q0);
                this.P0 = h55Var;
                h55Var.l();
            }
        }
    }

    public final void G7(View view2) {
        StatisticItem statisticItem;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, view2) != null) || this.C0 == null) {
            return;
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f091b3c) {
            kt9.J(6, this.C0);
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f091d09) {
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                this.U = view2;
                return;
            }
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091b3c && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
            this.U = view2;
            return;
        }
        if (!checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof zja)) {
            return;
        }
        zja zjaVar = (zja) sparseArray.get(R.id.tag_load_sub_data);
        if (view2.getId() == R.id.obfuscated_res_0x7f091b3c && (statisticItem = zjaVar.g0) != null) {
            StatisticItem copy = statisticItem.copy();
            copy.delete("obj_locate");
            copy.param("obj_locate", 8);
            TiebaStatic.log(copy);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091d09 || view2.getId() == R.id.obfuscated_res_0x7f091acd) {
            kt9.C(this.C0, zjaVar);
        }
        PbModel pbModel = this.C0;
        if (pbModel != null && pbModel.r1() != null && G6().w1() != null && zjaVar.t() != null && zjaVar.L() != 1) {
            if (G6().x1() != null) {
                G6().x1().g();
            }
            cl9 cl9Var = new cl9();
            cl9Var.v(this.C0.r1().k());
            cl9Var.z(this.C0.r1().O());
            cl9Var.x(zjaVar);
            G6().w1().i0(cl9Var);
            G6().w1().setPostId(zjaVar.U());
            n7(view2, zjaVar.t().getUserId(), "", zjaVar);
            bl5 bl5Var = this.Z0;
            if (bl5Var != null) {
                this.K0.x3(bl5Var.z());
            }
        }
    }

    public final void Y7(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048680, this, view2) != null) || this.t0) {
            return;
        }
        kt9.J(1, this.C0);
        SparseArray sparseArray = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
        if (sparseArray != null && (sparseArray.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_is_top_question)).booleanValue()) {
            kt9.w(2);
        }
        kt9.O(1, 2);
        if (this.v) {
            this.v = false;
            kt9.O(20, 2);
            return;
        }
        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
        if (!(tbRichTextView.getTag() instanceof SparseArray)) {
            kt9.O(20, 2);
            return;
        }
        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
        if (!(obj instanceof zja)) {
            kt9.O(20, 2);
            return;
        }
        zja zjaVar = (zja) obj;
        PbModel pbModel = this.C0;
        if (pbModel != null && pbModel.r1() != null && G6().w1() != null && zjaVar.t() != null && zjaVar.L() != 1) {
            if (!checkUpIsLogin()) {
                kt9.O(2, 2);
                return;
            } else if (zjaVar.B0()) {
                return;
            } else {
                if (G6().x1() != null) {
                    G6().x1().g();
                }
                cl9 cl9Var = new cl9();
                cl9Var.v(this.C0.r1().k());
                cl9Var.z(this.C0.r1().O());
                cl9Var.x(zjaVar);
                G6().w1().i0(cl9Var);
                G6().w1().setPostId(zjaVar.U());
                n7(view2, zjaVar.t().getUserId(), "", zjaVar);
                TiebaStatic.log("c11743");
                kt9.b(this.C0.r1(), zjaVar, zjaVar.f0, 8, 1);
                bl5 bl5Var = this.Z0;
                if (bl5Var != null) {
                    this.K0.x3(bl5Var.z());
                    return;
                }
                return;
            }
        }
        kt9.O(20, 2);
    }

    public final void E8(zja zjaVar, boolean z3) {
        PbModel pbModel;
        int i4;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, zjaVar, z3) == null) {
            f8(false);
            if (zjaVar == null || (pbModel = this.C0) == null || pbModel.r1() == null || zjaVar.L() == 1) {
                return;
            }
            String L1 = this.C0.L1();
            String U = zjaVar.U();
            if (this.C0.r1() != null) {
                i4 = this.C0.r1().W();
            } else {
                i4 = 0;
            }
            AbsPbActivity.e O7 = O7(U);
            if (O7 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo m02 = zjaVar.m0();
            AntiData c4 = this.C0.r1().c();
            if (zjaVar.t() != null) {
                arrayList = zjaVar.t().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(L1, U, "pb", true, false, null, false, null, i4, m02, c4, false, arrayList, 5).addBigImageData(O7.a, O7.b, O7.g, O7.j);
            addBigImageData.setKeyPageStartFrom(this.C0.q1());
            addBigImageData.setFromFrsForumId(this.C0.getFromForumId());
            addBigImageData.setWorksInfoData(this.C0.Q1());
            addBigImageData.setKeyFromForumId(this.C0.getForumId());
            addBigImageData.setBjhData(this.C0.I0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public final void M6(int i4, Intent intent) {
        jj5 jj5Var;
        jj5 jj5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048626, this, i4, intent) == null) {
            if (i4 == 0) {
                this.K0.L1();
                this.K0.x1().g();
                this.K0.k4(false);
            }
            this.K0.p3();
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
                if (editorType == 1 && this.K0.x1() != null && this.K0.x1().f() != null) {
                    el5 f4 = this.K0.x1().f();
                    f4.f0(this.C0.r1().O());
                    f4.D(writeData);
                    f4.g0(pbEditorData.getVoiceModel());
                    ij5 p3 = f4.a().p(6);
                    if (p3 != null && (jj5Var2 = p3.m) != null) {
                        jj5Var2.O(new wi5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i4 == -1) {
                        f4.I();
                        return;
                    }
                    return;
                }
                return;
            }
            bl5 bl5Var = this.Z0;
            if (bl5Var != null) {
                bl5Var.M();
                this.Z0.n0(pbEditorData.getVoiceModel());
                this.Z0.C(writeData);
                ij5 p4 = this.Z0.a().p(6);
                if (p4 != null && (jj5Var = p4.m) != null) {
                    jj5Var.O(new wi5(52, 0, pbEditorData.getVoiceModel()));
                }
                this.Z0.i0(pbEditorData.isShowCustomFigure());
                if (i4 == -1) {
                    this.Z0.H(null, null);
                }
            }
        }
    }

    public void b6(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048689, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(qp9.p2)).intValue();
            if (intValue == qp9.q2) {
                if (this.F0.f0()) {
                    return;
                }
                this.K0.N4();
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
                    this.F0.h0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.F0.i0(this.C0.r1().k().getId(), this.C0.r1().k().getName(), this.C0.r1().O().getId(), str, intValue3, intValue2, booleanValue, this.C0.r1().O().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == qp9.r2 || intValue == qp9.t2) {
                PbModel pbModel = this.C0;
                if (pbModel != null && pbModel.M0() != null) {
                    this.C0.M0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == qp9.r2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public void f6(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048704, this, i4, i5) == null) {
            TiebaStatic.log("c12181");
            qp9 qp9Var = this.K0;
            if (qp9Var != null && this.C0 != null) {
                if ((qp9Var == null || qp9Var.i2()) && this.C0.r1() != null && this.C0.r1().S() != null) {
                    qp9 qp9Var2 = this.K0;
                    if (qp9Var2 != null && qp9Var2.b1() != null && this.K0.b1().t()) {
                        return;
                    }
                    bl9 S = this.C0.r1().S();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!S.d() || S.a() != 2) && this.K0.T0() != null && this.K0.T0().B() != null) {
                        this.K0.T0().B().K(this.C0.L1(), this.C0.getFromForumId());
                    }
                    if (i4 > -1 && i5 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        PbFirstFloorDoubleClickAnimation pbFirstFloorDoubleClickAnimation = new PbFirstFloorDoubleClickAnimation(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.C0;
                        pbFirstFloorDoubleClickAnimation.show(findViewById, i4, i5, pbModel.b, pbModel.getForumId());
                        pbFirstFloorDoubleClickAnimation.setOnPraiseAnimatorListener(new w0(this));
                    } else if (System.currentTimeMillis() - this.w > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.w = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public final void n8(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048739, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (G6() != null) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    String questionMsg = postWriteCallBackData.getQuestionMsg();
                    String questionExp = postWriteCallBackData.getQuestionExp();
                    if (postWriteCallBackData.getIconStampData() != null) {
                        og5.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            ri9.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            ri9.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            ri9.e(getResources().getString(R.string.obfuscated_res_0x7f0f1499));
                            return;
                        } else {
                            ri9.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.C0.e1()) {
                antiData.setBlock_forum_name(this.C0.r1().k().getName());
                antiData.setBlock_forum_id(this.C0.r1().k().getId());
                antiData.setUser_name(this.C0.r1().V().getUserName());
                antiData.setUser_id(this.C0.r1().V().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void t8(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048781, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            h55 h55Var = this.P0;
            if (h55Var != null && h55Var.isShowing()) {
                this.P0.dismiss();
                this.P0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            j55 j55Var = new j55(getContext());
            j55Var.q(new m0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i4 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i4 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i4 == 1) {
                arrayList.add(new f55(0, getResources().getString(R.string.obfuscated_res_0x7f0f054b), j55Var));
            }
            if (z3) {
                arrayList.add(new f55(1, getResources().getString(R.string.un_mute), j55Var));
            } else {
                arrayList.add(new f55(1, getResources().getString(R.string.obfuscated_res_0x7f0f0d1a), j55Var));
            }
            j55Var.l(arrayList);
            h55 h55Var2 = new h55(getPageContext(), j55Var);
            this.P0 = h55Var2;
            h55Var2.l();
        }
    }

    public final void G5() {
        PbModel pbModel;
        lk9 lk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (pbModel = this.C0) != null && (lk9Var = pbModel.G) != null && lk9Var.O() != null) {
            ThreadData O = this.C0.G.O();
            O.mRecomAbTag = this.C0.x1();
            O.mRecomWeight = this.C0.A1();
            O.mRecomSource = this.C0.z1();
            O.mRecomExtra = this.C0.y1();
            O.isSubPb = this.C0.e1();
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(this.C0.getForumId(), 0L));
            }
            StatisticItem i4 = ss5.i(getContext(), O, "c13562");
            TbPageTag l3 = ss5.l(getContext());
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

    public final void K5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            SparseArray<Object> n12 = this.K0.n1(this.C0.r1(), this.C0.K1(), 1);
            if (n12 != null) {
                this.K0.W2(((Integer) n12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(n12.get(R.id.tag_del_post_id)), ((Integer) n12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n12.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            this.K0.k.f();
            if (f0() != null && f0().r1() != null && f0().r1().O() != null) {
                kt9.H(f0().r1().O());
            }
        }
    }

    public final void N5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.K0.k.g();
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                this.w1.f(pbModel.L1());
            }
            int i4 = 1;
            PbModel pbModel2 = this.C0;
            if (pbModel2 != null && pbModel2.isPrivacy()) {
                showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (f0() != null && f0().r1() != null) {
                    this.w1.d(3, 3, f0().r1().Q());
                    return;
                }
                return;
            }
            this.w1.b();
            if (!TbSingleton.getInstance().mCanCallFans && f0() != null && f0().r1() != null && f0().r1().Q() != null && f0().r1().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
                i4 = 2;
            }
            if (f0() != null && f0().r1() != null) {
                this.w1.d(3, i4, f0().r1().Q());
            }
        }
    }

    public final void e6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            SparseArray<Object> n12 = this.K0.n1(this.C0.r1(), this.C0.K1(), 1);
            if (n12 != null) {
                if (StringUtils.isNull((String) n12.get(R.id.tag_del_multi_forum))) {
                    this.K0.T2(((Integer) n12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(n12.get(R.id.tag_del_post_id)), ((Integer) n12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n12.get(R.id.tag_del_post_is_self)).booleanValue());
                } else {
                    this.K0.U2(((Integer) n12.get(R.id.tag_del_post_type)).intValue(), (String) n12.get(R.id.tag_del_post_id), ((Integer) n12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n12.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(n12.get(R.id.tag_del_multi_forum)));
                }
            }
            this.K0.k.f();
        }
    }

    public final void e7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048701, this) == null) && this.C0.r1() != null && this.C0.r1().O() != null && this.C0.r1().O().getActUrl() != null) {
            BrowserHelper.startWebActivity(getActivity(), this.C0.r1().O().getActUrl());
            if (this.C0.r1().O().getActInfoType() == 1) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
            } else if (this.C0.r1().O().getActInfoType() == 2) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            this.g = true;
            super.onPause();
            wr9.a();
            BdTypeListView listView = getListView();
            int viewLayer = CompatibleUtile.getInstance().getViewLayer(listView);
            this.k = viewLayer;
            if (viewLayer == 1) {
                CompatibleUtile.getInstance().noneViewGpu(listView);
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            qp9 qp9Var = this.K0;
            if (qp9Var != null) {
                qp9Var.L2();
            }
            if (this.Z0 != null && !this.C0.e1()) {
                this.Z0.O(this.C0.L1());
            }
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                pbModel.u2();
            }
            PushPermissionController pushPermissionController = this.w0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            mt4.w().E();
            MessageManager.getInstance().unRegisterListener(this.F1);
            b8();
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.b2);
            MessageManager.getInstance().unRegisterListener(this.d2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            lg5 lg5Var = this.r0;
            if (lg5Var != null) {
                lg5Var.q();
                this.r0.p();
            }
        }
    }

    public final void s7() {
        MarkData H0;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048776, this) == null) && this.E0 != null) {
            if (this.C0.r1() != null && this.C0.r1().j0()) {
                H0 = this.C0.H0(0);
            } else {
                H0 = this.C0.H0(this.K0.l1());
            }
            if (H0 == null) {
                return;
            }
            if (H0.isApp() && (H0 = this.C0.H0(this.K0.l1() + 1)) == null) {
                return;
            }
            this.K0.S3();
            this.E0.i(H0);
            if (!this.E0.e()) {
                if (this.K0 != null && (pbModel = this.C0) != null && !zr9.g(pbModel.b)) {
                    this.K0.F4();
                    zr9.a(this.C0.b);
                }
                this.E0.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.E0.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final void H5(SparseArray<Object> sparseArray, List<f55> list, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str) {
        f55 f55Var;
        f55 f55Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{sparseArray, list, Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z7), str}) == null) {
            f55 f55Var3 = null;
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
                        f55 f55Var4 = new f55(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f054b), this.Q0);
                        f55Var4.d.setTag(sparseArray2);
                        f55Var3 = f55Var4;
                    }
                } else {
                    sparseArray2.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                f55Var = new f55(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0324), this.Q0);
                f55Var.d.setTag(sparseArray2);
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
                if (this.C0.r1().W() == 1002 && !z3) {
                    f55Var2 = new f55(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.Q0);
                } else {
                    f55Var2 = new f55(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f054b), this.Q0);
                }
                f55Var2.d.setTag(sparseArray3);
                f55Var3 = f55Var2;
                f55Var = null;
            } else {
                f55Var = null;
            }
            if (f55Var3 != null) {
                list.add(f55Var3);
            }
            if (f55Var != null) {
                list.add(f55Var);
            }
        }
    }

    public final void H6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.I0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.I0 = pollingModel;
                pollingModel.setDialogTime(s55.e);
            }
            this.I0.getData(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            SafeHandler.getInst().postDelayed(this.Z1, 10000L);
        }
    }

    public final void I5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (this.p1 != null) {
                cn5.b bVar = new cn5.b();
                bVar.a = this.p1.Q();
                bVar.b = this.p1.O();
                bVar.c = String.valueOf(this.p1.R());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.o1));
        }
    }

    public final void I7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && this.s1 >= 0) {
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                pbModel.M2();
            }
            if (this.C0 != null && this.K0.T0() != null) {
                this.K0.T0().n0(this.C0.r1(), false);
            }
            this.s1 = 0;
            if (this.C0 != null) {
                if (this.K0.m1() != null) {
                    this.K0.m1().setSelection(this.C0.k1());
                }
                this.C0.Q2(0, 0);
            }
        }
    }

    public final void J8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (pbModel = this.C0) != null && pbModel.r1() != null) {
            lk9 r12 = this.C0.r1();
            if (this.H0 == null) {
                this.H0 = new el9(getPageContext());
            }
            long j4 = JavaTypesHelper.toLong(r12.Q(), 0L);
            long j5 = JavaTypesHelper.toLong(r12.l(), 0L);
            kt9.N("c13446", j5);
            registerListener(this.s2);
            this.H0.a(j4, j5);
        }
    }

    public final void K6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.K0.D3(true);
            this.K0.p3();
            if (this.i) {
                return;
            }
            this.i = true;
            this.K0.C4();
            F8();
            this.K0.S3();
            this.C0.j3(u6());
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
        }
    }

    public final void M8() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (absPbActivity = this.b) != null && absPbActivity.J1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.b.J1().L1()).param("topic_id", this.b.J1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.b.J1().P1()));
        }
    }

    public final boolean P5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel == null || pbModel.r1() == null) {
                return false;
            }
            ThreadData O = this.C0.r1().O();
            AntiData c4 = this.C0.r1().c();
            if (!AntiHelper.b(getPageContext(), O) && !AntiHelper.d(getPageContext(), c4)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void P8() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.R(this.C0.getForumId()) && this.C0.r1() != null && this.C0.r1().k() != null) {
            boolean z3 = true;
            if (this.C0.r1().k().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.C0.E0().Q(this.C0.getForumId(), this.C0.L1());
            }
        }
    }

    public boolean S5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            if ((this.C0.r1() != null && (this.C0.r1().j0() || ThreadCardUtils.isSelf(this.C0.r1().O()))) || this.b1 == null || this.C0.r1() == null || this.C0.r1().c() == null) {
                return true;
            }
            return this.b1.checkPrivacyBeforeInvokeEditor(this.C0.r1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void V5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            if (this.C0.W0() || this.C0.Z0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.C0.L1());
                this.b.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.C0.L1()));
            if (H8()) {
                this.b.finish();
            }
        }
    }

    public final void W5() {
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
            this.K0.k.g();
        }
    }

    public final boolean a7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            zja c4 = mk9.c(this.C0.r1(), this.C0.K1(), this.C0.C1());
            if (c4 != null && c4.t() != null && c4.t().getGodUserData() != null && c4.t().getGodUserData().getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void g7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            this.K0.F0();
            if (f0().r1().g == 2) {
                showToast(R.string.hot_sort_jump_hint);
                return;
            }
            if (this.C0.p1() != null) {
                this.K0.G4(this.C0.p1(), this.j2);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
        }
    }

    public final void j7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.K0.F0();
            F8();
            this.K0.S3();
            this.K0.s4();
            if (this.K0.v1() != null) {
                this.K0.v1().setVisibility(8);
            }
            this.C0.f3(1);
            br9 br9Var = this.f;
            if (br9Var != null) {
                br9Var.x();
            }
        }
    }

    public final void k7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048726, this) == null) && this.S2 != null) {
            if (this.Q2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f1004);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.S2.a(), this.Q2, 0)));
                this.b.finish();
            }
        }
    }

    public final void m7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048734, this) == null) && this.S2 != null) {
            if (this.P2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f1005);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.S2.a(), this.P2, 0)));
                this.b.finish();
            }
        }
    }

    public final void s8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048777, this) == null) {
            z45 z45Var = new z45(getPageContext().getPageActivity());
            z45Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            z45Var.setPositiveButton(R.string.open_now, new h(this));
            z45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new i(this));
            z45Var.create(this.i1).show();
        }
    }

    public final void u8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048786, this) == null) {
            showLoadingView(this.K0.G1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d9));
            View attachedView = getLoadingView().getAttachedView();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
            layoutParams.addRule(3, this.K0.F1().getId());
            attachedView.setLayoutParams(layoutParams);
        }
    }

    public final void v7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048788, this) == null) && getPageContext().getPageActivity() != null && this.C0 != null) {
            sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(getPageContext().getPageActivity(), this.C0.L1(), this.C0.d2(), this.C0.c2())));
            kt9.D(this.C0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void H7(View view2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        f55 f55Var;
        boolean z11;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, view2) != null) || !checkUpIsLogin()) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c11740"));
        if (view2 != null && view2.getTag() != null) {
            SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
            zja zjaVar = (zja) sparseArray.get(R.id.tag_load_sub_data);
            if (view2.getId() != R.id.replybtn_top_right && view2.getId() != R.id.cover_reply_content_top_right) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                TiebaStatic.log(new StatisticItem("c12006").param("tid", this.C0.b));
            }
            if (this.Q0 == null) {
                j55 j55Var = new j55(getContext());
                this.Q0 = j55Var;
                j55Var.q(this.l2);
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
            if (zjaVar != null) {
                if (zjaVar.f0() != null && zjaVar.f0().toString().length() > 0) {
                    f55 f55Var2 = new f55(3, getString(R.string.obfuscated_res_0x7f0f04e5), this.Q0);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, zjaVar);
                    f55Var2.d.setTag(sparseArray2);
                    arrayList.add(f55Var2);
                }
                this.E2 = zjaVar;
            }
            if (this.C0.r1().q()) {
                String u3 = this.C0.r1().u();
                if (zjaVar != null && !di.isEmpty(u3) && u3.equals(zjaVar.U())) {
                    z10 = true;
                    if (!z10) {
                        f55Var = new f55(4, getString(R.string.remove_mark), this.Q0);
                    } else {
                        f55Var = new f55(4, getString(R.string.obfuscated_res_0x7f0f0c5c), this.Q0);
                    }
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.E2);
                    sparseArray3.put(R.id.tag_is_subpb, Boolean.FALSE);
                    f55Var.d.setTag(sparseArray3);
                    arrayList.add(f55Var);
                    if (this.mIsLogin) {
                        if (!sr9.j(this.C0) && !z6 && z5) {
                            f55 f55Var3 = new f55(5, getString(R.string.obfuscated_res_0x7f0f0d1e), this.Q0);
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
                            f55Var.d.setTag(sparseArray4);
                            arrayList.add(f55Var3);
                        } else {
                            if (pp9.C(this.C0.r1(), z4) && TbadkCoreApplication.isLogin()) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z11) {
                                f55 f55Var4 = new f55(5, getString(R.string.report_text), this.Q0);
                                f55Var4.d.setTag(str2);
                                arrayList.add(f55Var4);
                            }
                        }
                        H5(sparseArray, arrayList, z4, z6, z7, z8, z9, str2);
                    }
                    this.Q0.l(arrayList);
                    h55 h55Var = new h55(getPageContext(), this.Q0);
                    this.P0 = h55Var;
                    h55Var.l();
                }
            }
            z10 = false;
            if (!z10) {
            }
            SparseArray sparseArray32 = new SparseArray();
            sparseArray32.put(R.id.tag_clip_board, this.E2);
            sparseArray32.put(R.id.tag_is_subpb, Boolean.FALSE);
            f55Var.d.setTag(sparseArray32);
            arrayList.add(f55Var);
            if (this.mIsLogin) {
            }
            this.Q0.l(arrayList);
            h55 h55Var2 = new h55(getPageContext(), this.Q0);
            this.P0 = h55Var2;
            h55Var2.l();
        }
    }

    public final void j6(View view2) {
        String str;
        int i4;
        PbModel pbModel;
        lk9 lk9Var;
        zja X;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f09194c) {
                kt9.J(4, this.C0);
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f091ad3 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                this.f1136T = view2;
            } else if (!checkUpIsLogin()) {
                kt9.v("c10517", this.C0.r1().l(), 3);
            } else {
                PbModel pbModel2 = this.C0;
                if (pbModel2 != null && pbModel2.r1() != null) {
                    this.K0.F0();
                    SparseArray sparseArray = (SparseArray) view2.getTag();
                    zja zjaVar = (zja) sparseArray.get(R.id.tag_load_sub_data);
                    zja zjaVar2 = (zja) sparseArray.get(R.id.tag_load_sub_reply_data);
                    View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
                    if (zjaVar != null && view3 != null) {
                        boolean z3 = true;
                        if (zjaVar.P() == 1) {
                            TiebaStatic.log(new StatisticItem("c12630"));
                        }
                        StatisticItem statisticItem = zjaVar.g0;
                        if (statisticItem != null) {
                            StatisticItem copy = statisticItem.copy();
                            copy.delete("obj_locate");
                            if (view2.getId() == R.id.obfuscated_res_0x7f09194c) {
                                copy.param("obj_locate", 6);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091ad3) {
                                copy.param("obj_locate", 8);
                            }
                            TiebaStatic.log(copy);
                        }
                        String L1 = this.C0.L1();
                        String U = zjaVar.U();
                        if (zjaVar2 != null) {
                            str = zjaVar2.U();
                        } else {
                            str = "";
                        }
                        if (this.C0.r1() != null) {
                            i4 = this.C0.r1().W();
                        } else {
                            i4 = 0;
                        }
                        F8();
                        if (view2.getId() == R.id.obfuscated_res_0x7f091ef8) {
                            AbsPbActivity.e O7 = O7(U);
                            PbModel pbModel3 = this.C0;
                            if (pbModel3 != null && pbModel3.r1() != null && O7 != null) {
                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(L1, U, "pb", true, false, null, true, null, i4, zjaVar.m0(), this.C0.r1().c(), false, zjaVar.t().getIconInfo(), 5).addBigImageData(O7.a, O7.b, O7.g, O7.j);
                                addBigImageData.setKeyPageStartFrom(this.C0.q1());
                                addBigImageData.setFromFrsForumId(this.C0.getFromForumId());
                                addBigImageData.setWorksInfoData(this.C0.Q1());
                                addBigImageData.setKeyFromForumId(this.C0.getForumId());
                                addBigImageData.setBjhData(this.C0.I0());
                                addBigImageData.setTiebaPlusData(this.C0.V(), this.C0.R(), this.C0.S(), this.C0.Q(), this.C0.W());
                                sendMessage(new CustomMessage(2002001, addBigImageData));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log("c11742");
                        AbsPbActivity.e O72 = O7(U);
                        if (zjaVar != null && (pbModel = this.C0) != null && pbModel.r1() != null && O72 != null) {
                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(L1, U, "pb", true, false, null, false, str, i4, zjaVar.m0(), this.C0.r1().c(), false, zjaVar.t().getIconInfo(), 5).addBigImageData(O72.a, O72.b, O72.g, O72.j);
                            if (!di.isEmpty(str)) {
                                addBigImageData2.setHighLightPostId(str);
                                addBigImageData2.setKeyIsUseSpid(true);
                            }
                            addBigImageData2.setKeyFromForumId(this.C0.getForumId());
                            addBigImageData2.setTiebaPlusData(this.C0.V(), this.C0.R(), this.C0.S(), this.C0.Q(), this.C0.W());
                            addBigImageData2.setBjhData(this.C0.I0());
                            addBigImageData2.setKeyPageStartFrom(this.C0.q1());
                            addBigImageData2.setFromFrsForumId(this.C0.getFromForumId());
                            addBigImageData2.setWorksInfoData(this.C0.Q1());
                            if (this.K0 != null && (lk9Var = this.C0.G) != null && (X = lk9Var.X()) != null) {
                                if (!X.f1184T && !zjaVar.f1184T) {
                                    z3 = false;
                                }
                                addBigImageData2.setMainPostMaskVisibly(z3);
                            }
                            if (this.C0.r1() != null && this.C0.r1().n() != null) {
                                addBigImageData2.setHasForumRule(this.C0.r1().n().has_forum_rule.intValue());
                            }
                            sendMessage(new CustomMessage(2002001, addBigImageData2));
                        }
                    }
                }
            }
        }
    }

    public final boolean H8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.r1() != null && this.C0.r1().j0()) {
                return true;
            }
            if (this.C0.c1()) {
                MarkData N0 = this.C0.N0();
                if (N0 == null || !this.C0.a1()) {
                    return true;
                }
                MarkData H0 = this.C0.H0(this.K0.d1());
                if (H0 == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", N0);
                    this.b.setResult(-1, intent);
                    return true;
                } else if (H0.getPostId() != null && !H0.getPostId().equals(N0.getPostId())) {
                    z45 z45Var = new z45(getPageContext().getPageActivity());
                    z45Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0299));
                    z45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c4, new q2(this, H0, N0, z45Var));
                    z45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new r2(this, N0, z45Var));
                    z45Var.setOnCalcelListener(new s2(this, N0, z45Var));
                    z45Var.create(getPageContext());
                    z45Var.show();
                    return false;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", N0);
                    this.b.setResult(-1, intent2);
                    return true;
                }
            }
            if (this.C0.r1() != null && this.C0.r1().F() != null && this.C0.r1().F().size() > 0 && this.C0.a1()) {
                this.b.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void J6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (this.g) {
                this.P = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.C0.r1() != null && this.C0.r1().O() != null && this.C0.r1().O().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.C0.r1().O().getTaskInfoData().k(), this.C0.r1().O().getTaskInfoData().h(), this.C0.r1().O().getTaskInfoData().c(), this.C0.r1().O().getTaskInfoData().d(), this.C0.r1().O().getIs_top(), this.C0.r1().O().getIs_good())));
                this.b.finish();
            }
        }
    }

    public final void K8() {
        PbModel pbModel;
        String name;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (pbModel = this.C0) != null && pbModel.r1() != null && this.C0.r1().k() != null && !di.isEmpty(this.C0.r1().k().getName())) {
            if (this.C0.getErrorNo() == 4) {
                if (StringUtils.isNull(this.C0.Q0()) && this.C0.G0() != null) {
                    name = this.C0.G0().b;
                } else {
                    this.b.finish();
                    return;
                }
            } else {
                name = this.C0.r1().k().getName();
            }
            if (StringUtils.isNull(name)) {
                this.b.finish();
                return;
            }
            String Q0 = this.C0.Q0();
            if (this.C0.W0() && Q0 != null && Q0.equals(name)) {
                this.b.finish();
            } else {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(this.C0.r1().k().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            }
            kt9.B(this.C0);
        }
    }

    public final void a6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.r1() != null) {
                yja z3 = this.C0.r1().z();
                if (z3 != null) {
                    if (z3.getAdvertAppInfo() != null) {
                        z3.getAdvertAppInfo().h = null;
                    }
                    this.C0.r1().b();
                }
                if (this.C0.J0() != null) {
                    this.C0.w0();
                }
                this.C0.W1();
            }
            if (this.C0.r1().F() != null) {
                Iterator<zja> it = this.C0.r1().F().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof yja) {
                        it.remove();
                    }
                }
            }
            if (this.K0.T0() != null && !ListUtils.isEmpty(this.K0.T0().v())) {
                pp9.e(this.K0.T0().v());
            }
            if (this.K0.m1() != null && !ListUtils.isEmpty(this.K0.m1().getData())) {
                pp9.e(this.K0.m1().getData());
            }
            if (this.K0.T0() != null) {
                this.K0.T0().f0();
            }
        }
    }

    public final void o6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.K0.F0();
            SparseArray<Object> n12 = this.K0.n1(this.C0.r1(), this.C0.K1(), 1);
            if (n12 == null) {
                return;
            }
            sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(getPageContext().getPageActivity(), this.C0.r1().k().getId(), this.C0.r1().k().getName(), this.C0.r1().O().getId(), StringUtils.string(this.C0.r1().V().getUserId()), StringUtils.string(n12.get(R.id.tag_forbid_user_name)), StringUtils.string(n12.get(R.id.tag_forbid_user_name_show)), StringUtils.string(n12.get(R.id.tag_forbid_user_post_id)), StringUtils.string(n12.get(R.id.tag_forbid_user_portrait)))));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            this.g = false;
            super.onResume();
            if (this.P) {
                this.P = false;
                J6();
            }
            if (a7()) {
                this.u = System.currentTimeMillis();
            } else {
                this.u = -1L;
            }
            qp9 qp9Var = this.K0;
            if (qp9Var != null && qp9Var.G1() != null) {
                if (!this.h) {
                    u8();
                } else {
                    hideLoadingView(this.K0.G1());
                }
                this.K0.O2();
            }
            if (this.k == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            qp9 qp9Var2 = this.K0;
            if (qp9Var2 != null) {
                noNetworkView = qp9Var2.a();
            }
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.update(false);
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.F1);
            this.T0 = false;
            c8();
            registerListener(this.a2);
            registerListener(this.b2);
            registerListener(this.d2);
            PushPermissionController pushPermissionController = this.w0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.r1) {
                U7();
                this.r1 = false;
            }
            C8();
            ItemCardHelper.w(this.K2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                ii5.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048762, this) == null) {
            super.onStop();
            if (this.u > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.u;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.u = 0L;
            }
            if (G6().x1() != null) {
                G6().x1().n();
            }
            ks9 ks9Var = this.K0.k;
            if (ks9Var != null && !ks9Var.n()) {
                this.K0.k.r();
            }
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.r1() != null && this.C0.r1().k() != null && this.C0.r1().O() != null) {
                fi5.j().x(getPageContext().getPageActivity(), "pb", this.C0.r1().k().getId(), JavaTypesHelper.toLong(this.C0.r1().O().getId(), 0L));
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            bia.g().h(getUniqueId(), false);
        }
    }

    public final String u6() {
        InterceptResult invokeV;
        ArrayList<zja> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048784, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel == null || pbModel.r1() == null || this.C0.r1().F() == null || (count = ListUtils.getCount((F = this.C0.r1().F()))) == 0) {
                return "";
            }
            if (this.C0.D1()) {
                Iterator<zja> it = F.iterator();
                while (it.hasNext()) {
                    zja next = it.next();
                    if (next != null && next.L() == 1) {
                        return next.U();
                    }
                }
            }
            int d12 = this.K0.d1();
            zja zjaVar = (zja) ListUtils.getItem(F, d12);
            if (zjaVar != null && zjaVar.t() != null) {
                if (this.C0.l2(zjaVar.t().getUserId())) {
                    return zjaVar.U();
                }
                for (int i4 = d12 - 1; i4 != 0; i4--) {
                    zja zjaVar2 = (zja) ListUtils.getItem(F, i4);
                    if (zjaVar2 == null || zjaVar2.t() == null || zjaVar2.t().getUserId() == null) {
                        break;
                    } else if (this.C0.l2(zjaVar2.t().getUserId())) {
                        return zjaVar2.U();
                    }
                }
                for (int i5 = d12 + 1; i5 < count; i5++) {
                    zja zjaVar3 = (zja) ListUtils.getItem(F, i5);
                    if (zjaVar3 == null || zjaVar3.t() == null || zjaVar3.t().getUserId() == null) {
                        break;
                    } else if (this.C0.l2(zjaVar3.t().getUserId())) {
                        return zjaVar3.U();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void w7() {
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048792, this) == null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
            if (this.C0.r1() != null && this.C0.r1().O() != null && this.C0.r1().O().isVideoThreadType() && this.C0.r1().O().getThreadVideoInfo() != null) {
                TiebaStatic.log(new StatisticItem("c11922"));
            }
            if (this.C0.getErrorNo() == 4) {
                if (StringUtils.isNull(this.C0.Q0()) && this.C0.G0() != null) {
                    name = this.C0.G0().b;
                } else {
                    this.b.finish();
                    return;
                }
            } else {
                name = this.C0.r1().k().getName();
            }
            if (StringUtils.isNull(name)) {
                this.b.finish();
                return;
            }
            String Q0 = this.C0.Q0();
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
            if (this.C0.W0() && Q0 != null && Q0.equals(name)) {
                this.b.finish();
            } else {
                sendMessage(new CustomMessage(2003000, createNormalCfg));
            }
        }
    }

    public final void I8(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, view2) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
            String string2 = SharedPrefHelper.getInstance().getString("tail_link", "");
            String string3 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
            if (!StringUtils.isNull(string2)) {
                TiebaStatic.log("c10056");
                Context context = view2.getContext();
                BrowserHelper.startWebActivity(context, string, UtilHelper.urlAddParam(string2, "page_from=1&tailSkinId=" + string3), true, true, true);
            }
            this.K0.p3();
            TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string3));
        }
    }

    public final void O6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.r1() != null && this.C0.r1().j0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.C0.L1(), str);
                ThreadData O = this.C0.r1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                i7(format);
                return;
            }
            this.D0.a(str);
        }
    }

    public void R7(cl9 cl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, cl9Var) == null) {
            String U = cl9Var.g().U();
            List<zja> list = this.C0.r1().T().a;
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                zja zjaVar = list.get(i4);
                if (zjaVar.U() != null && zjaVar.U().equals(U)) {
                    ArrayList<zja> i5 = cl9Var.i();
                    zjaVar.q1(cl9Var.k());
                    if (zjaVar.j0() != null) {
                        zjaVar.j0().clear();
                        zjaVar.j0().addAll(i5);
                    }
                } else {
                    i4++;
                }
            }
            if (!this.C0.a1()) {
                this.K0.g2(this.C0.r1());
            }
        }
    }

    public final void Z5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048681, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.C0) != null && pbModel.r1() != null) {
            yja z3 = this.C0.r1().z();
            if (z3 != null && str.equals(z3.E1())) {
                if (z3.getAdvertAppInfo() != null) {
                    z3.getAdvertAppInfo().h = null;
                }
                this.C0.r1().b();
            }
            yja J0 = this.C0.J0();
            if (J0 != null && str.equals(J0.E1())) {
                this.C0.w0();
            }
        }
    }

    public final void i6(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048717, this, view2) != null) || !(view2.getTag() instanceof ThreadData)) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        if (this.C0.q1() == 3 && Q0() && this.C0.r1() != null && ListUtils.isEmpty(this.C0.r1().o())) {
            this.b.finish();
        } else {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
        kt9.A(threadData);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048747, this, i4) != null) || this.X == i4) {
            return;
        }
        super.onChangeSkinType(i4);
        this.K0.E2(i4);
        bl5 bl5Var = this.Z0;
        if (bl5Var != null && bl5Var.a() != null) {
            this.Z0.a().z(i4);
        }
        if (this.K0.a() != null) {
            this.K0.a().onChangeSkinType(getPageContext(), i4);
        }
        this.O0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i4, getResources(), R.color.CAM_X0201), true);
        this.X = i4;
        F8();
        lg5 lg5Var = this.r0;
        if (lg5Var != null) {
            lg5Var.w();
        }
    }

    public final void r8(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048774, this, metaData) != null) || metaData == null) {
            return;
        }
        z45 z45Var = new z45(getActivity());
        z45Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0c5e));
        z45Var.setTitleShowCenter(true);
        z45Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0c5f));
        z45Var.setMessageShowCenter(true);
        z45Var.setCancelable(false);
        z45Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0c60), new d2(this, metaData));
        z45Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0c61), new e2(this, metaData));
        z45Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void u7(zja zjaVar) {
        boolean z3;
        zja r6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048785, this, zjaVar) != null) || zjaVar == null) {
            return;
        }
        if (zjaVar.U() != null && zjaVar.U().equals(this.C0.m1())) {
            z3 = true;
        } else {
            z3 = false;
        }
        MarkData l12 = this.C0.l1(zjaVar);
        if (this.C0.r1() != null && this.C0.r1().j0() && (r6 = r6()) != null) {
            l12 = this.C0.l1(r6);
        }
        if (l12 == null) {
            return;
        }
        this.K0.S3();
        gw4 gw4Var = this.E0;
        if (gw4Var != null) {
            gw4Var.i(l12);
            if (!z3) {
                this.E0.a();
            } else {
                this.E0.d();
            }
        }
    }

    public final void y8(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048801, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && f0() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                f0().z0(postWriteCallBackData.getPostId());
                int Z0 = this.K0.Z0();
                this.s1 = Z0;
                this.C0.Q2(Z0, this.K0.g1());
            }
            this.K0.F0();
            this.O0.c();
            bl5 bl5Var = this.Z0;
            if (bl5Var != null) {
                this.K0.x3(bl5Var.z());
            }
            this.K0.L1();
            this.K0.k4(true);
            this.C0.W1();
        }
    }

    public final void J5(boolean z3, boolean z4, SparseArray<Object> sparseArray, List<f55> list, boolean z5, boolean z6, String str) {
        boolean z7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4), sparseArray, list, Boolean.valueOf(z5), Boolean.valueOf(z6), str}) == null) {
            if (!sr9.j(this.C0) && !z3 && z4) {
                f55 f55Var = new f55(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0d1e), this.Q0);
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
                f55Var.d.setTag(sparseArray2);
                list.add(f55Var);
                return;
            }
            if (pp9.C(this.C0.r1(), z5) && TbadkCoreApplication.isLogin()) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 && !z6) {
                f55 f55Var2 = new f55(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.Q0);
                f55Var2.d.setTag(str);
                list.add(f55Var2);
            }
        }
    }

    public final void J7(View view2) {
        SparseArray sparseArray;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, view2) == null) && (sparseArray = (SparseArray) view2.getTag()) != null && (sparseArray.get(R.id.tag_load_sub_data) instanceof zja)) {
            zja zjaVar = (zja) sparseArray.get(R.id.tag_load_sub_data);
            View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
            if (zjaVar != null && view3 != null) {
                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090864);
                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090865);
                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b6a);
                boolean z3 = false;
                if (zjaVar.D0()) {
                    zjaVar.j1(false);
                    wr9.e(zjaVar);
                } else {
                    if (f0() != null) {
                        z3 = wr9.c(f0().r1(), zjaVar);
                    }
                    if (z3) {
                        zjaVar.j1(true);
                    }
                }
                if (zjaVar.D0()) {
                    i4 = R.color.CAM_X0201;
                } else {
                    i4 = R.color.transparent;
                }
                SkinManager.setBackgroundColor(findViewById, i4);
                boolean D0 = zjaVar.D0();
                int i7 = R.color.CAM_X0304;
                if (D0) {
                    i5 = R.color.CAM_X0304;
                } else {
                    i5 = R.color.CAM_X0107;
                }
                SkinManager.setViewTextColor(eMTextView, i5);
                if (zjaVar.D0()) {
                    i6 = R.drawable.icon_pure_pb_del_select;
                } else {
                    i6 = R.drawable.icon_pure_pb_del_normal;
                }
                if (!zjaVar.D0()) {
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
    public final void U5(AgreeData agreeData) {
        ns5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048662, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.f0 == null) {
            this.f0 = new l95();
        }
        if (this.j0 == null) {
            AgreeMessageData agreeMessageData = new AgreeMessageData();
            this.j0 = agreeMessageData;
            agreeMessageData.uniqueId = getUniqueId();
        }
        h15 h15Var = new h15();
        h15Var.b = 5;
        h15Var.h = 8;
        h15Var.g = 2;
        if (f0() != null) {
            h15Var.f = f0().q1();
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
                this.f0.c(agreeData, i4, getUniqueId(), false);
                this.f0.d(agreeData, this.j0);
                pbModel = this.C0;
                if (pbModel == null && pbModel.r1() != null) {
                    this.f0.b(m0(), h15Var, agreeData, this.C0.r1().O());
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
        this.f0.c(agreeData, i4, getUniqueId(), false);
        this.f0.d(agreeData, this.j0);
        pbModel = this.C0;
        if (pbModel == null) {
        }
    }

    public final void X7(View view2) {
        boolean j32;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                view2.setTag(Boolean.FALSE);
                return;
            }
            this.K0.F0();
            if (this.K0.k.i() != null && view2 == this.K0.k.i().x()) {
                this.K0.p3();
            }
            if (this.i) {
                view2.setTag(Boolean.FALSE);
                return;
            }
            F8();
            this.K0.S3();
            if (view2.getId() == R.id.obfuscated_res_0x7f090b6e) {
                j32 = this.C0.k3(true, u6());
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091ef3) {
                j32 = this.C0.k3(false, u6());
            } else {
                j32 = this.C0.j3(u6());
            }
            view2.setTag(Boolean.valueOf(j32));
            if (j32) {
                this.K0.D3(true);
                this.K0.C4();
                this.i = true;
                this.K0.H3(true);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
        }
    }

    public final void o7(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048742, this, view2) == null) && (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String)) {
            String string = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
            TiebaStatic.log(new StatisticItem("c10912").param("fid", this.C0.r1().l()).param("tid", this.C0.r1().Q()).param("lotterytail", StringUtils.string(string, "_", TbadkCoreApplication.getCurrentAccount())));
            if (this.C0.r1().Q().equals(string)) {
                this.K0.W3(0);
            } else {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getActivity()).createNormalCfg(string, (String) null, (String) null, (String) null)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        lk9 r12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (G6() != null && pp9.D(this)) {
                G6().M4();
            }
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907a0));
            PbModel pbModel = this.C0;
            if (pbModel != null && (r12 = pbModel.r1()) != null) {
                this.t2.c(true, 0, 3, 0, r12, "", 1);
            }
            this.b.L1().k(this.u0);
            if (c7()) {
                AbsPbActivity absPbActivity = this.b;
                if (absPbActivity instanceof PbActivity) {
                    ((PbActivity) absPbActivity).g2();
                }
            }
            PbModel pbModel2 = this.C0;
            if (pbModel2 != null && this.H.b(pbModel2.G, getContext(), this.b.findViewById(this.K0.U0()), this.C0.getForumId(), this.C0.L1())) {
                AbsPbActivity absPbActivity2 = this.b;
                if (absPbActivity2 instanceof PbActivity) {
                    ((PbActivity) absPbActivity2).g2();
                }
            }
        }
    }

    public final void K7(View view2) {
        l45 l45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, view2) == null) && checkUpIsLogin() && (l45Var = (l45) view2.getTag()) != null && !StringUtils.isNull(l45Var.D1())) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{l45Var.D1()});
        }
    }

    public void L7(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, animatorListener) == null) && this.K0 != null && (pbModel = this.C0) != null && pbModel.r1() != null && this.C0.r1().S() != null && checkUpIsLogin() && this.K0.T0() != null && this.K0.T0().B() != null) {
            this.K0.T0().B().U(animatorListener);
        }
    }

    public final void M5(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048625, this, view2) != null) || !(view2.getTag() instanceof ThreadData)) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
        createNormalCfg.setCallFrom(14);
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        kt9.I(threadData, 9, 9);
    }

    public final void N8(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048632, this, z3) == null) && (absPbActivity = this.b) != null && absPbActivity.J1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.b.J1().L1()).param("topic_id", this.b.J1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.b.J1().P1()));
        }
    }

    public void Q5(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.K0.s4();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = JavaTypesHelper.toLong(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = JavaTypesHelper.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.k1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.h1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean T5(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048658, this, i4)) == null) {
            if (this.b1 != null && this.C0.r1() != null && !ThreadCardUtils.isSelf(this.C0.r1().O()) && this.C0.r1().c() != null) {
                return this.b1.checkPrivacyBeforeSend(this.C0.r1().c().replyPrivateFlag, i4);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void U6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, bundle) == null) {
            gw4 c4 = gw4.c(this.b);
            this.E0 = c4;
            if (c4 != null) {
                c4.j(this.w2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.b);
            this.F0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.y2);
            this.G0 = new ze5(getPageContext());
            H6();
            this.S1.setUniqueId(getUniqueId());
            this.S1.registerListener();
            W6();
        }
    }

    public final void d7(View view2) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048698, this, view2) == null) && view2 != null) {
            BrowserHelper.startWebActivity(getActivity(), StringUtils.string(view2.getTag()));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (q6() == 1 && (pbModel = this.C0) != null && pbModel.r1() != null) {
                kt9.E("c10397", this.C0.r1().l(), this.C0.r1().Q(), currentAccount);
            }
        }
    }

    public final void f7(View view2) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048705, this, view2) == null) && view2 != null) {
            String string = StringUtils.string(view2.getTag());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            BrowserHelper.startWebActivity(getActivity(), string);
            if (q6() == 1 && (pbModel = this.C0) != null && pbModel.r1() != null) {
                kt9.E("c10507", this.C0.r1().l(), this.C0.r1().Q(), currentAccount);
            }
        }
    }

    public final void i8(cl5 cl5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048719, this, cl5Var) == null) && cl5Var != null && (pbModel = this.C0) != null) {
            cl5Var.p(pbModel.Q0());
            if (this.C0.r1() != null && this.C0.r1().k() != null) {
                cl5Var.o(this.C0.r1().k());
            }
            cl5Var.q("pb");
            cl5Var.r(this.C0);
            cl5Var.s(PbNewEditorTool.InputShowType.REPLY);
        }
    }

    public final void j8(int i4) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048723, this, i4) != null) || (pbModel = this.C0) == null) {
            return;
        }
        int B1 = pbModel.B1();
        if (i4 != 5) {
            if (i4 != 6) {
                if (i4 != 7) {
                    this.C0.b3(1);
                } else {
                    this.C0.b3(4);
                }
            } else {
                this.C0.b3(3);
            }
        } else {
            this.C0.b3(2);
        }
        int B12 = this.C0.B1();
        if (B1 == 4 || B12 == 4) {
            B7();
        }
    }

    public final void l7(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, bundle) == null) {
            PbModel J1 = this.b.J1();
            this.C0 = J1;
            if (J1 != null) {
                if (J1.M0() != null) {
                    this.C0.M0().c(this.O2);
                }
                if (this.C0.n1() != null) {
                    this.C0.n1().f(this.y1);
                }
                if (StringUtils.isNull(this.C0.L1())) {
                    this.b.finish();
                } else if ("from_tieba_kuang".equals(this.N) && this.N != null) {
                    this.C0.Y2(6);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z3;
        qp9 qp9Var;
        ks9 ks9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (UtilHelper.isFoldScreen() && (qp9Var = this.K0) != null && (ks9Var = qp9Var.k) != null && ks9Var.n()) {
                this.K0.k.g();
                C7();
            }
            int i4 = configuration.orientation;
            if (i4 == this.x) {
                return;
            }
            this.x = i4;
            if (i4 == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.K = z3;
            qp9 qp9Var2 = this.K0;
            if (qp9Var2 != null) {
                qp9Var2.F2(configuration);
            }
            h55 h55Var = this.P0;
            if (h55Var != null) {
                h55Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public void p8(View view2) {
        lk9 C6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048767, this, view2) == null) {
            int i4 = SharedPrefHelper.getInstance().getInt(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb"), 0);
            AbsPbActivity absPbActivity = this.b;
            if ((absPbActivity == null || absPbActivity.getIntent() == null || !this.b.getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) || (i4 != 1 && i4 != 2 && i4 != 3)) && (C6 = C6()) != null) {
                tr9.d(getContext(), view2, C6);
            }
        }
    }

    public final void M7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            if (this.K0.j1().getIndicateStatus()) {
                lk9 r12 = this.C0.r1();
                if (r12 != null && r12.O() != null && r12.O().getTaskInfoData() != null) {
                    String e4 = r12.O().getTaskInfoData().e();
                    if (StringUtils.isNull(e4)) {
                        e4 = r12.O().getTaskInfoData().h();
                    }
                    TiebaStatic.log(new StatisticItem("c11107").param("obj_id", e4));
                }
            } else {
                fka.d("c10725", null);
            }
            J6();
        }
    }

    public void N7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            if (!checkUpIsLogin()) {
                kt9.O(2, 1);
                return;
            }
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.r1() != null && this.C0.r1().k() != null) {
                if (P5()) {
                    kt9.O(3, 1);
                    return;
                } else if (this.C0.r1().j0()) {
                    kt9.O(7, 1);
                    this.K0.w0();
                    return;
                } else {
                    bl5 bl5Var = this.Z0;
                    if (bl5Var != null && bl5Var.a() != null) {
                        this.Z0.a().D(new wi5(45, 27, null));
                    }
                    this.K0.w0();
                    return;
                }
            }
            kt9.O(20, 1);
        }
    }

    public final void T6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048659, this) == null) && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            long j4 = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
            sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(getPageContext().getPageActivity(), 24008, JavaTypesHelper.toLong(this.C0.r1().l(), 0L), JavaTypesHelper.toLong(this.C0.L1(), 0L), j4, this.C0.r1().O().getPushStatusData())));
        }
    }

    public final void X6() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048675, this) != null) || this.l != null) {
            return;
        }
        this.l = new a55(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        a55 a55Var = this.l;
        a55Var.j(strArr, new y0(this));
        a55Var.g(a55.b.a);
        a55Var.h(17);
        a55Var.c(getPageContext());
    }

    public final void x7() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048796, this) != null) || yw5.a()) {
            return;
        }
        PbModel pbModel = this.C0;
        if (pbModel != null && pbModel.r1() != null) {
            ArrayList<zja> F = this.C0.r1().F();
            if ((F == null || F.size() <= 0) && this.C0.K1()) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1006));
                return;
            }
            kt9.G(this.C0);
            this.K0.p3();
            C7();
            return;
        }
        BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1006));
    }

    public void N6(boolean z3, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
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
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.k1);
            userMuteAddAndDelCustomMessage.setTag(this.k1);
            B8(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void O5(boolean z3) {
        qp9 qp9Var;
        int i4;
        int y3;
        zja zjaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048633, this, z3) == null) && (qp9Var = this.K0) != null && qp9Var.m1() != null) {
            int firstVisiblePosition = this.K0.m1().getFirstVisiblePosition();
            int lastVisiblePosition = this.K0.m1().getLastVisiblePosition();
            yn9 T0 = this.K0.T0();
            if (T0 != null && this.C0.r1() != null) {
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
                        if (this.K0.m1().G(i4) != null && (this.K0.m1().G(i4) instanceof zja) && (zjaVar = (zja) this.K0.m1().G(i4)) != null) {
                            zja zjaVar2 = (zja) ListUtils.getItem(this.C0.r1().F(), zjaVar.L() - 1);
                            if (zjaVar.o() == null && zjaVar2 != null) {
                                zjaVar.O0(zjaVar2.o());
                            }
                            if (zjaVar.o() != null) {
                                zjaVar.o().setFloonumber(zjaVar.L());
                                arrayList.add(zjaVar.o());
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
                            this.K0.b3(adverSegmentData, 0);
                            return;
                        }
                        return;
                    }
                    this.K0.b3(adverSegmentData, 1);
                }
            }
        }
    }

    public final AbsPbActivity.e O7(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) {
            String str2 = null;
            if (this.C0.r1() != null && this.C0.r1().F() != null && this.C0.r1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i4 = 0;
                while (true) {
                    if (i4 < this.C0.r1().F().size()) {
                        if (str.equals(this.C0.r1().F().get(i4).U())) {
                            break;
                        }
                        i4++;
                    } else {
                        i4 = 0;
                        break;
                    }
                }
                zja zjaVar = this.C0.r1().F().get(i4);
                if (zjaVar.f0() != null && zjaVar.f0().O() != null) {
                    Iterator<TbRichTextData> it = zjaVar.f0().O().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.U() != null) {
                                str2 = next.U().O();
                            }
                        }
                    }
                    fp9.e(this.C0, str2, 0, eVar);
                    mk9.b(zjaVar, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void R8(int i4) {
        PbModel pbModel;
        ThreadData O;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048651, this, i4) != null) || (pbModel = this.C0) == null || pbModel.r1() == null || (O = this.C0.r1().O()) == null) {
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
        if (this.C0.K1()) {
            this.K0.T0().f0();
        } else {
            this.K0.b5(this.C0.r1());
        }
    }

    public void T7(cl9 cl9Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048660, this, cl9Var) != null) || cl9Var.g() == null) {
            return;
        }
        String U = cl9Var.g().U();
        ArrayList<zja> F = this.C0.r1().F();
        int i4 = 0;
        while (true) {
            z3 = true;
            if (i4 >= F.size()) {
                break;
            }
            zja zjaVar = F.get(i4);
            if (zjaVar.U() != null && zjaVar.U().equals(U)) {
                ArrayList<zja> i5 = cl9Var.i();
                zjaVar.q1(cl9Var.k());
                if (zjaVar.j0() != null && i5 != null) {
                    Iterator<zja> it = i5.iterator();
                    while (it.hasNext()) {
                        zja next = it.next();
                        if (zjaVar.s0() != null && next != null && next.t() != null && (metaData = zjaVar.s0().get(next.t().getUserId())) != null) {
                            next.P0(metaData);
                            next.g1(true);
                            next.A1(getPageContext(), this.C0.l2(metaData.getUserId()));
                        }
                    }
                    if (i5.size() == zjaVar.j0().size()) {
                        z3 = false;
                    }
                    if (!zjaVar.z0(false)) {
                        zjaVar.j0().clear();
                        zjaVar.j0().addAll(i5);
                    }
                }
                if (zjaVar.E() != null) {
                    zjaVar.N0();
                }
            } else {
                i4++;
            }
        }
        if (!this.C0.a1() && z3) {
            this.K0.g2(this.C0.r1());
        }
        if (z3) {
            R7(cl9Var);
        }
    }

    public final void W7(View view2) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, view2) == null) {
            this.K0.F0();
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.i) {
                view2.setTag(Integer.valueOf(this.C0.I1()));
            } else {
                F8();
                this.K0.S3();
                h55 h55Var = new h55(getPageContext());
                if (this.C0.r1().f == null || this.C0.r1().f.size() <= 0) {
                    strArr = new String[]{getResources().getString(R.string.sort_type_new), getResources().getString(R.string.sort_type_old)};
                } else {
                    strArr = new String[this.C0.r1().f.size()];
                    for (int i4 = 0; i4 < this.C0.r1().f.size(); i4++) {
                        strArr[i4] = this.C0.r1().f.get(i4).sort_name + getResources().getString(R.string.sort_static);
                    }
                }
                h55Var.i(null, strArr, new s1(this, h55Var, view2));
                h55Var.l();
            }
        }
    }

    public final boolean a8(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048686, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof zja)) {
                return false;
            }
            zja zjaVar = (zja) obj;
            if (zjaVar.getType() != zja.a1 && !TextUtils.isEmpty(zjaVar.v()) && m05.c().g()) {
                return y7(zjaVar);
            }
            if (!checkUpIsLogin()) {
                kt9.O(2, 2);
                return true;
            }
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.r1() != null) {
                if (G6().x1() != null) {
                    G6().x1().g();
                }
                cl9 cl9Var = new cl9();
                cl9Var.v(this.C0.r1().k());
                cl9Var.z(this.C0.r1().O());
                cl9Var.x(zjaVar);
                G6().w1().i0(cl9Var);
                G6().w1().setPostId(zjaVar.U());
                n7(view2, zjaVar.t().getUserId(), "", zjaVar);
                TiebaStatic.log("c11743");
                bl5 bl5Var = this.Z0;
                if (bl5Var != null) {
                    this.K0.x3(bl5Var.z());
                }
                return true;
            }
            kt9.O(20, 2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void h6(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.K0.F0();
            if (view2.getId() == R.id.obfuscated_res_0x7f091abb && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                this.V = view2;
            } else if (!pp9.d(getPageContext(), 11009) || this.C0.H0(this.K0.l1()) == null) {
            } else {
                s7();
                if (this.C0.r1() != null && this.C0.r1().O() != null && this.C0.r1().O().getAuthor() != null) {
                    kt9.y(3, this.C0);
                }
                if (this.C0.r1().O() != null && this.C0.r1().O().getAuthor() != null && this.C0.r1().O().getAuthor().getUserId() != null && this.E0 != null) {
                    kt9.F(1, pp9.v(this.C0.r1()), !this.E0.e(), this.C0);
                }
            }
        }
    }

    public final void q7(View view2) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048770, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.C0.r1() == null || this.F0.f0()) {
            } else {
                this.K0.F0();
                if (this.K0.k.i() != null && view2 == this.K0.k.i().C()) {
                    if (this.C0.r1().O().getIs_top() == 1) {
                        i4 = 5;
                    } else {
                        i4 = 4;
                    }
                } else if (this.K0.k.i() != null && view2 == this.K0.k.i().B()) {
                    if (this.C0.r1().O().getIs_good() == 1) {
                        i4 = 3;
                    } else {
                        i4 = 6;
                    }
                } else if (view2 == this.K0.X0()) {
                    i4 = 2;
                } else {
                    i4 = 0;
                }
                ForumData k4 = this.C0.r1().k();
                String name = k4.getName();
                String id = k4.getId();
                String id2 = this.C0.r1().O().getId();
                this.K0.N4();
                this.F0.j0(id, name, id2, i4, this.K0.Y0());
            }
        }
    }

    public final boolean y7(zja zjaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048800, this, zjaVar)) == null) {
            if (zjaVar == null) {
                return false;
            }
            String U = zjaVar.U();
            if (StringUtils.isNull(U) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String string = SharedPrefHelper.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = zjaVar.o0().getJumpUrl();
            int packageId = zjaVar.o0().getPackageId();
            int propsId = zjaVar.o0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                BrowserHelper.startWebActivity(getPageContext().getPageActivity(), fla.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
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

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void S0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048652, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (f26[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), f26.class);
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (wp9.c(objArr[i4].g()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    @Override // com.baidu.tieba.i26
    public void o0(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048740, this, context, str, z3) == null) {
            if (wp9.c(str) && (pbModel = this.C0) != null && pbModel.L1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.C0.L1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    ai5 ai5Var = new ai5();
                    ai5Var.a = str;
                    ai5Var.b = 3;
                    ai5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, ai5Var));
                }
            } else {
                wp9.a().e(getPageContext(), str);
            }
            this.v = true;
        }
    }

    public void S7(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048656, this, z3, markData) == null) {
            this.K0.R3();
            this.C0.h3(z3);
            gw4 gw4Var = this.E0;
            if (gw4Var != null) {
                gw4Var.h(z3);
                if (markData != null) {
                    this.E0.i(markData);
                }
            }
            if (this.C0.c1()) {
                p7();
            } else {
                this.K0.g2(this.C0.r1());
            }
        }
    }

    public final boolean X5(View view2) {
        InterceptResult invokeL;
        SparseArray<Object> sparseArray;
        gw4 gw4Var;
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
        f55 f55Var;
        f55 f55Var2;
        f55 f55Var3;
        f55 f55Var4;
        f55 f55Var5;
        f55 f55Var6;
        BdImage bdImage;
        SparseArray<Object> sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048674, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext())) {
                return true;
            }
            qp9 qp9Var = this.K0;
            if (qp9Var != null) {
                if (qp9Var.k2()) {
                    return true;
                }
                this.K0.P0();
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (pp9.y(view2)) {
                    if (view2 instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view2;
                        this.n1 = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.o1 = url;
                        if (this.n1 == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view2.getTag(R.id.tag_rich_text_image_info) != null && (view2.getTag(R.id.tag_rich_text_image_info) instanceof TbRichTextImageInfo)) {
                            this.p1 = (TbRichTextImageInfo) view2.getTag(R.id.tag_rich_text_image_info);
                        } else {
                            this.p1 = null;
                        }
                        if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.q1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.q1 = null;
                        }
                    } else if (view2 instanceof GifView) {
                        GifView gifView = (GifView) view2;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.n1 = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().getUrl())) {
                            this.o1 = gifView.getBdImage().getUrl();
                        }
                        if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.q1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.q1 = null;
                        }
                    } else if (view2 instanceof TbMemeImageView) {
                        TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                        if (tbMemeImageView.getBdImage() != null) {
                            this.n1 = tbMemeImageView.getBdImage();
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().getUrl())) {
                                this.o1 = tbMemeImageView.getBdImage().getUrl();
                            }
                            if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.q1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.q1 = null;
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
                        this.K0.x4(this.G2, this.n1.isGif());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            SparseArray<Object> sparseArray3 = sparseArray;
            zja zjaVar = (zja) sparseArray3.get(R.id.tag_clip_board);
            this.E2 = zjaVar;
            if (zjaVar == null) {
                return true;
            }
            if (zjaVar.L() == 1 && pp9.y(view2)) {
                this.K0.x4(this.G2, this.n1.isGif());
                return true;
            } else if (this.E2.B0() || (gw4Var = this.E0) == null) {
                return true;
            } else {
                if (gw4Var.e() && this.E2.U() != null && this.E2.U().equals(this.C0.m1())) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (f0().r1() != null && f0().r1().j0()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (f0().r1() != null && f0().r1().p0()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (f0().r1() != null && f0().r1().o0()) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (this.E2.L() == 1) {
                    if (!z4) {
                        this.K0.y4(this.F2, z3, false, z5, z6);
                    }
                    return true;
                }
                if (this.Q0 == null) {
                    j55 j55Var = new j55(getContext());
                    this.Q0 = j55Var;
                    j55Var.q(this.l2);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 != null && sparseArray3 != null) {
                    if (pp9.y(view2) && !z4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (pp9.y(view2) && (bdImage = this.n1) != null && !bdImage.isGif()) {
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
                        arrayList.add(new f55(1, getString(R.string.save_to_emotion), this.Q0));
                    }
                    if (z8) {
                        arrayList.add(new f55(2, getString(R.string.save_to_local), this.Q0));
                    }
                    if (!z7 && !z8) {
                        f55 f55Var7 = new f55(3, getString(R.string.obfuscated_res_0x7f0f04e5), this.Q0);
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_clip_board, this.E2);
                        f55Var7.d.setTag(sparseArray4);
                        arrayList.add(f55Var7);
                    }
                    if (!z9 && !z4) {
                        if (z3) {
                            f55Var6 = new f55(4, getString(R.string.remove_mark), this.Q0);
                        } else {
                            f55Var6 = new f55(4, getString(R.string.obfuscated_res_0x7f0f0c5c), this.Q0);
                        }
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.tag_clip_board, this.E2);
                        sparseArray5.put(R.id.tag_is_subpb, Boolean.FALSE);
                        f55Var6.d.setTag(sparseArray5);
                        arrayList.add(f55Var6);
                    }
                    if (this.mIsLogin) {
                        String str2 = str;
                        J5(z12, z11, sparseArray3, arrayList, z10, z4, str2);
                        if (z12) {
                            SparseArray sparseArray6 = new SparseArray();
                            sparseArray6.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                            sparseArray6.put(R.id.tag_manage_user_identity, sparseArray3.get(R.id.tag_manage_user_identity));
                            sparseArray6.put(R.id.tag_forbid_user_name, sparseArray3.get(R.id.tag_forbid_user_name));
                            sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray3.get(R.id.tag_forbid_user_name_show));
                            sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray3.get(R.id.tag_forbid_user_portrait));
                            sparseArray6.put(R.id.tag_forbid_user_post_id, str2);
                            sparseArray6.put(R.id.tag_mul_del_post_type, sparseArray3.get(R.id.tag_mul_del_post_type));
                            if (!sr9.j(this.C0) && z13) {
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
                                    f55Var5 = new f55(6, getString(R.string.obfuscated_res_0x7f0f054b), this.Q0);
                                    f55Var5.d.setTag(sparseArray6);
                                    f55 f55Var8 = new f55(7, getString(R.string.obfuscated_res_0x7f0f0324), this.Q0);
                                    f55Var8.d.setTag(sparseArray6);
                                    f55Var3 = f55Var5;
                                    f55Var2 = f55Var8;
                                    f55Var = null;
                                }
                            } else {
                                sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                            }
                            f55Var5 = null;
                            f55 f55Var82 = new f55(7, getString(R.string.obfuscated_res_0x7f0f0324), this.Q0);
                            f55Var82.d.setTag(sparseArray6);
                            f55Var3 = f55Var5;
                            f55Var2 = f55Var82;
                            f55Var = null;
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
                            if (this.C0.r1().W() == 1002 && !z10) {
                                f55Var4 = new f55(6, getString(R.string.report_text), this.Q0);
                            } else {
                                f55Var4 = new f55(6, getString(R.string.obfuscated_res_0x7f0f054b), this.Q0);
                            }
                            f55Var4.d.setTag(sparseArray7);
                            if (z16) {
                                f55Var = new f55(13, getString(R.string.multi_delete), this.Q0);
                                f55Var3 = f55Var4;
                            } else {
                                f55Var3 = f55Var4;
                                f55Var = null;
                            }
                            f55Var2 = null;
                        } else {
                            f55Var = null;
                            f55Var2 = null;
                            f55Var3 = null;
                        }
                        if (f55Var3 != null) {
                            arrayList.add(f55Var3);
                        }
                        if (f55Var != null) {
                            arrayList.add(f55Var);
                        }
                        if (f55Var2 != null) {
                            arrayList.add(f55Var2);
                        }
                        sr9.b(arrayList, this.Q0, this.E2, this.C0);
                    }
                    List<f55> d4 = sr9.d(arrayList, this.E2.p(), sparseArray3, this.Q0, this.E2.s());
                    sr9.m(d4, this.c);
                    sr9.f(d4);
                    this.Q0.r(sr9.h(this.E2));
                    this.Q0.m(d4, true);
                    this.P0 = new h55(getPageContext(), this.Q0);
                    this.Q0.p(new e3(this));
                    this.P0.l();
                    StatisticItem param = new StatisticItem("c13272").param("tid", this.C0.b).param("fid", this.C0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.C0.O());
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

    public void Y5(ForumManageModel.b bVar, qp9 qp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048678, this, bVar, qp9Var) == null) {
            List<zja> list = this.C0.r1().T().a;
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
                qp9Var.g2(this.C0.r1());
            }
        }
    }

    public void c6(z45 z45Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048694, this, z45Var, jSONArray) == null) {
            z45Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(z45Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                b6((SparseArray) z45Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public void d6(int i4, String str, int i5, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048697, this, new Object[]{Integer.valueOf(i4), str, Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i5));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(qp9.p2, Integer.valueOf(qp9.q2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                b6(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void k6(View view2) {
        PbModel pbModel;
        int i4;
        lk9 lk9Var;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048725, this, view2) != null) || (pbModel = this.C0) == null) {
            return;
        }
        kt9.J(5, pbModel);
        if (view2.getId() == R.id.obfuscated_res_0x7f091b3e && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
            this.f1136T = view2;
        } else if (!checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
        } else {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof zja)) {
                return;
            }
            zja zjaVar = (zja) sparseArray.get(R.id.tag_load_sub_data);
            StatisticItem statisticItem = zjaVar.g0;
            if (statisticItem != null) {
                StatisticItem copy = statisticItem.copy();
                copy.delete("obj_locate");
                copy.param("obj_locate", 8);
                TiebaStatic.log(copy);
            }
            PbModel pbModel2 = this.C0;
            if (pbModel2 != null && pbModel2.r1() != null) {
                String L1 = this.C0.L1();
                String U = zjaVar.U();
                if (this.C0.r1() != null) {
                    i4 = this.C0.r1().W();
                } else {
                    i4 = 0;
                }
                AbsPbActivity.e O7 = O7(U);
                if (O7 == null) {
                    return;
                }
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(L1, U, "pb", true, false, null, false, null, i4, zjaVar.m0(), this.C0.r1().c(), false, zjaVar.t().getIconInfo(), 5).addBigImageData(O7.a, O7.b, O7.g, O7.j);
                addBigImageData.setKeyPageStartFrom(this.C0.q1());
                addBigImageData.setFromFrsForumId(this.C0.getFromForumId());
                addBigImageData.setWorksInfoData(this.C0.Q1());
                addBigImageData.setKeyFromForumId(this.C0.getForumId());
                addBigImageData.setTiebaPlusData(this.C0.V(), this.C0.R(), this.C0.S(), this.C0.Q(), this.C0.W());
                addBigImageData.setBjhData(this.C0.I0());
                if (this.C0.r1().n() != null) {
                    addBigImageData.setHasForumRule(this.C0.r1().n().has_forum_rule.intValue());
                }
                if (this.C0.r1().V() != null) {
                    addBigImageData.setIsManager(this.C0.r1().V().getIs_manager());
                }
                if (this.C0.r1().k().getDeletedReasonInfo() != null) {
                    addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.C0.r1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                    addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.C0.r1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                }
                if (this.C0.r1().k() != null) {
                    addBigImageData.setForumHeadUrl(this.C0.r1().k().getImage_url());
                    addBigImageData.setUserLevel(this.C0.r1().k().getUser_level());
                }
                if (this.K0 != null && (lk9Var = this.C0.G) != null) {
                    if (!lk9Var.X().f1184T && !zjaVar.f1184T) {
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

    public final void l6(ForumManageModel.b bVar, boolean z3) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048729, this, bVar, z3) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i4 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                z45 z45Var = new z45(getPageContext().getPageActivity());
                z45Var.setMessage(string);
                z45Var.setPositiveButton(R.string.dialog_known, new j2(this));
                z45Var.setCancelable(true);
                z45Var.create(getPageContext());
                z45Var.show();
            } else if (bVar.d != 0) {
                this.K0.O0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i5 = bVar.d;
                if (i5 == 1) {
                    ArrayList<zja> F = this.C0.r1().F();
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
                    this.C0.r1().O().setReply_num(this.C0.r1().O().getReply_num() - 1);
                    this.K0.g2(this.C0.r1());
                } else if (i5 == 0) {
                    V5();
                } else if (i5 == 2) {
                    ArrayList<zja> F2 = this.C0.r1().F();
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
                        this.K0.g2(this.C0.r1());
                    }
                    Y5(bVar, this.K0);
                }
            }
        }
    }

    public final void x8(String str, String str2) {
        int i4;
        int dimens;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048797, this, str, str2) == null) {
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
            int i6 = (this.Z[1] + this.a0) - i5;
            qp9 qp9Var = this.K0;
            if (qp9Var != null && qp9Var.m1() != null) {
                this.K0.m1().smoothScrollBy(i6, 50);
            }
            if (G6().x1() != null) {
                bl5 bl5Var = this.Z0;
                if (bl5Var != null) {
                    bl5Var.a().setVisibility(8);
                }
                PbModel pbModel2 = this.C0;
                G6().x1().t(str, str2, G6().y1(), (pbModel2 == null || pbModel2.r1() == null || this.C0.r1().O() == null || !this.C0.r1().O().isBjh()) ? false : false);
                el5 f4 = G6().x1().f();
                if (f4 != null && (pbModel = this.C0) != null && pbModel.r1() != null) {
                    f4.J(this.C0.r1().c());
                    f4.f0(this.C0.r1().O());
                }
                if (this.O0.f() == null && G6().x1().f().u() != null) {
                    G6().x1().f().u().g(new n(this));
                    this.O0.n(G6().x1().f().u().i());
                    G6().x1().f().P(this.f1);
                }
            }
            G6().J1();
        }
    }

    public final void m6(int i4, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048733, this, i4, gVar) != null) || gVar == null) {
            return;
        }
        this.K0.O0(this.F0.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.L0 = true;
            if (i4 != 2 && i4 != 3) {
                if (i4 == 4 || i4 == 5) {
                    this.M0 = false;
                    this.N0 = true;
                }
            } else {
                this.M0 = true;
                this.N0 = false;
            }
            if (i4 == 2) {
                this.C0.r1().O().setIs_good(1);
                this.C0.U2(1);
            } else if (i4 == 3) {
                this.C0.r1().O().setIs_good(0);
                this.C0.U2(0);
            } else if (i4 == 4) {
                this.C0.r1().O().setIs_top(1);
                this.C0.V2(1);
            } else if (i4 == 5) {
                this.C0.r1().O().setIs_top(0);
                this.C0.V2(0);
            }
            this.K0.Y4(this.C0.r1(), this.C0.K1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.operation_failed);
        }
        BdUtilHelper.showToast(getPageContext().getPageActivity(), string);
    }

    public final void m8(int i4, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048735, this, i4, antiData, str) == null) {
            if (AntiHelper.m(i4, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i4, new h2(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i4 == 230277) {
                A8(str);
            } else {
                this.K0.L4(str);
            }
        }
    }

    @Override // com.baidu.tieba.i26
    public void t0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048778, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.R0 = str;
            if (this.l == null) {
                X6();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                this.l.f(1).setVisibility(8);
            } else {
                this.l.f(1).setVisibility(0);
            }
            this.l.m();
            this.v = true;
        }
    }

    public final void n7(View view2, String str, String str2, zja zjaVar) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048738, this, view2, str, str2, zjaVar) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (P5()) {
                    kt9.O(3, 2);
                    return;
                } else if (!S5()) {
                    kt9.O(8, 2);
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.Z);
                        this.a0 = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (G6().x1() != null && zjaVar != null) {
                        if (zjaVar.f0() != null) {
                            str3 = zjaVar.f0().toString();
                        } else {
                            str3 = "";
                        }
                        G6().x1().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), zjaVar.t().getName_show(), str3));
                    }
                    if (this.C0.r1() != null && this.C0.r1().j0()) {
                        SafeHandler.getInst().postDelayed(new q1(this, str, str2), 0L);
                        return;
                    } else {
                        SafeHandler.getInst().postDelayed(new r1(this, str, str2), 200L);
                        return;
                    }
                }
            }
            kt9.O(20, 2);
        }
    }

    public final void o8(SparseArray<Object> sparseArray, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048743, this, new Object[]{sparseArray, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            sr9.e(getActivity(), getPageContext(), new m1(this, sparseArray, i4, z3), new n1(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048745, this, i4, i5, intent) == null) {
            super.onActivityResult(i4, i5, intent);
            bl5 bl5Var = this.Z0;
            if (bl5Var != null) {
                bl5Var.D(i4, i5, intent);
            }
            if (G6().x1() != null) {
                G6().x1().k(i4, i5, intent);
            }
            if (i4 == 25035) {
                M6(i5, intent);
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
                                                    View view2 = this.f1136T;
                                                    if (view2 != null) {
                                                        view2.performClick();
                                                        return;
                                                    }
                                                    return;
                                                case 25056:
                                                    View view3 = this.U;
                                                    if (view3 != null) {
                                                        view3.performClick();
                                                        return;
                                                    }
                                                    return;
                                                case 25057:
                                                    qp9 qp9Var = this.K0;
                                                    if (qp9Var != null && qp9Var.W0() != null) {
                                                        this.K0.W0().performClick();
                                                        return;
                                                    }
                                                    return;
                                                case 25058:
                                                    View view4 = this.V;
                                                    if (view4 != null) {
                                                        view4.performClick();
                                                        return;
                                                    }
                                                    return;
                                                default:
                                                    return;
                                            }
                                        }
                                        this.K0.U3(false);
                                        if (this.C0.r1() != null && this.C0.r1().O() != null && this.C0.r1().O().getPushStatusData() != null) {
                                            this.C0.r1().O().getPushStatusData().setStatus(2);
                                            return;
                                        }
                                        return;
                                    }
                                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                        RateManager.getInstance().notifyShare(getPageContext());
                                        P8();
                                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.J0;
                                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.linkUrl) != null) {
                                            shareSuccessReplyToServerModel.M(str, intExtra, new p2(this));
                                        }
                                        if (Z6()) {
                                            N8(true);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                View view5 = this.S;
                                if (view5 != null) {
                                    this.K0.p4(view5);
                                    return;
                                }
                                return;
                            }
                            P6(intent);
                            return;
                        }
                        RateManager.getInstance().notifyShare(getPageContext());
                        return;
                    }
                    hp9.b().k();
                    this.z0.postDelayed(new o2(this), 1000L);
                    return;
                }
                s7();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048751, this, layoutInflater, viewGroup, bundle)) == null) {
            wra.b(this, new Pair[0]);
            this.K0 = new qp9(this, this.n2, this.Y1, this.m2);
            mz6 mz6Var = new mz6(getActivity());
            this.e = mz6Var;
            mz6Var.i(V2);
            this.e.d(this.N2);
            this.K0.L3(this.x2);
            this.K0.K3(this.C2);
            this.K0.E3(this.z2);
            this.K0.F3(this.A2);
            this.K0.C3(m05.c().g());
            this.K0.I3(this.D2);
            this.K0.O3(this.I2);
            this.K0.M3(this.J2);
            this.K0.J3(this.L2);
            this.K0.T4(this.mIsLogin);
            this.K0.A3(this.C0.Z1());
            if (this.b.getIntent() != null) {
                this.K0.B3(this.b.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.K0.w1().setFromForumId(this.C0.getFromForumId());
            bl5 bl5Var = this.Z0;
            if (bl5Var != null) {
                this.K0.s3(bl5Var.a());
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.Z0.d0(TbSingleton.getInstance().getAdVertiComment());
                } else {
                    this.Z0.d0(this.K0.y1());
                }
            }
            this.K0.w3(this.k2);
            this.K0.z3(this.C0.Z0());
            this.K0.N3(this.C0.q1());
            this.v0.f(this.K0, this.C0);
            if ("1".equals(f0().showReplyPanel)) {
                this.K0.N2();
            }
            return this.K0.G1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        qp9 qp9Var;
        qp9 qp9Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048750, this, bundle) == null) {
            this.o = System.currentTimeMillis();
            this.i1 = getPageContext();
            Intent intent = this.b.getIntent();
            if (intent != null) {
                this.m = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                this.N = intent.getStringExtra("from");
                if (intent.getData() != null) {
                    Uri data = intent.getData();
                    if (StringUtils.isNull(this.N)) {
                        this.N = data.getQueryParameter("from");
                    }
                }
                this.W = intent.getStringExtra("st_type");
                this.P2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.Q2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.R2 = intent.getStringExtra("key_manga_title");
                this.U0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.V0 = intent.getStringExtra("high_light_post_id");
                this.W0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (w6()) {
                    this.b.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.Q = stringExtra;
                if (di.isEmpty(stringExtra)) {
                    str = "";
                } else {
                    str = this.Q;
                }
                this.Q = str;
                this.t1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                p35 p35Var = new p35();
                this.d0 = p35Var;
                p35Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.v1 = intExtra;
                if (intExtra == 0) {
                    this.v1 = intent.getIntExtra("key_start_from", 0);
                }
                this.T2 = intent.getIntExtra(PbActivityConfig.KEY_FROM_CARD_TYPE, 0);
            } else {
                this.m = System.currentTimeMillis();
            }
            this.q = this.o - this.m;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.k = 0;
            l7(bundle);
            if (this.C0.r1() != null) {
                this.C0.r1().V0(this.Q);
            }
            V6();
            if (intent != null && (qp9Var2 = this.K0) != null) {
                qp9Var2.e = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.l1 == null) {
                        this.l1 = new q0(this, intent);
                    }
                    SafeHandler.getInst().postDelayed(this.l1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.C0.r1() != null) {
                    this.C0.Z2(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.j = voiceManager;
            voiceManager.onCreate(getPageContext());
            U6(bundle);
            cl5 cl5Var = new cl5();
            this.Y0 = cl5Var;
            i8(cl5Var);
            bl5 bl5Var = (bl5) this.Y0.a(getActivity());
            this.Z0 = bl5Var;
            bl5Var.X(this.b.getPageContext());
            this.Z0.g0(this.p2);
            this.Z0.h0(this.d1);
            this.Z0.Z(1);
            this.Z0.B(this.b.getPageContext(), bundle);
            this.Z0.a().b(new hj5(getActivity()));
            this.Z0.a().F(true);
            l8(true);
            this.Z0.K(this.C0.T0(), this.C0.L1(), this.C0.P0());
            registerListener(this.C1);
            if (!this.C0.e1()) {
                this.Z0.q(this.C0.L1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.Z0.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.C0.b2()) {
                this.Z0.d0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                qp9 qp9Var3 = this.K0;
                if (qp9Var3 != null) {
                    this.Z0.d0(qp9Var3.y1());
                }
            }
            vl9 vl9Var = new vl9(this.b.getUniqueId(), new r0(this), new s0(this));
            this.g2 = vl9Var;
            registerListener(vl9Var.d());
            this.H = new PbGodGuideController();
            getLifecycle().addObserver(this.H);
            hz4.a().c(this.A0);
            hz4.a().c(this.B0);
            registerListener(this.B1);
            registerListener(this.D1);
            registerListener(this.E1);
            registerListener(this.A1);
            registerListener(this.e2);
            registerListener(this.f2);
            registerListener(this.v2);
            registerListener(this.z1);
            pja pjaVar = new pja("pb", pja.d);
            this.X0 = pjaVar;
            pjaVar.d();
            registerListener(this.K1);
            registerListener(this.U1);
            this.C0.v2();
            registerListener(this.u2);
            registerListener(this.i2);
            registerListener(this.o2);
            registerListener(this.Q1);
            registerListener(this.h2);
            registerListener(this.L1);
            qp9 qp9Var4 = this.K0;
            if (qp9Var4 != null && qp9Var4.F1() != null && this.K0.C1() != null) {
                br9 br9Var = new br9(getActivity(), this.K0.F1(), this.K0.C1(), this.K0.v1());
                this.f = br9Var;
                br9Var.t(this.T1);
            }
            if (this.d && (qp9Var = this.K0) != null && qp9Var.C1() != null) {
                this.K0.C1().setVisibility(8);
            }
            z95 z95Var = new z95();
            this.j1 = z95Var;
            z95Var.a = 1000L;
            registerListener(this.d2);
            registerListener(this.c2);
            registerListener(this.a2);
            registerListener(this.b2);
            registerListener(this.N1);
            registerListener(this.O1);
            registerListener(this.G1);
            registerListener(this.H1);
            registerListener(this.I1);
            this.M1.setSelfListener(true);
            this.M1.setTag(this.b.getUniqueId());
            this.M1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.M1);
            registerResponsedEventListener(TipEvent.class, this.V1);
            registerResponsedEventListener(TopToastEvent.class, this.W1);
            this.k1 = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.k1;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.k1;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            this.X1 = new j3(this.K0, this);
            this.C0.L0().Q(this.X1);
            this.O0 = new tp9();
            if (this.Z0.s() != null) {
                this.O0.m(this.Z0.s().i());
            }
            this.Z0.W(this.e1);
            this.J0 = new ShareSuccessReplyToServerModel();
            E5(this.x1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.b1 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new u0(this));
            qs9 qs9Var = new qs9(getContext());
            this.D0 = qs9Var;
            qs9Var.b(getUniqueId());
            bia.g().i(getUniqueId());
            w05.b().l("3", "");
            this.w1 = new ro6(getPageContext());
            this.v0 = new pr9(this, getUniqueId(), this.K0, this.C0);
            this.w0 = new PushPermissionController(getActivity(), getPageContext());
            if (!TbSingleton.getInstance().hasDownloadEmotion() && BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.p = System.currentTimeMillis() - this.o;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        ks9 ks9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            bia.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!di.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.C0.r1().l());
                statisticItem.param("tid", this.C0.L1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.s && this.K0 != null) {
                this.s = true;
            }
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.C0.destory();
                if (this.C0.n1() != null) {
                    this.C0.n1().d();
                }
            }
            bl5 bl5Var = this.Z0;
            if (bl5Var != null) {
                bl5Var.E();
                this.Z0 = null;
            }
            ForumManageModel forumManageModel = this.F0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.R;
            if (likeModel != null) {
                likeModel.a0();
            }
            qp9 qp9Var = this.K0;
            if (qp9Var != null) {
                qp9Var.G2();
                ks9 ks9Var2 = this.K0.k;
                if (ks9Var2 != null) {
                    ks9Var2.r();
                }
            }
            at5 at5Var = this.t;
            if (at5Var != null) {
                at5Var.c();
            }
            br9 br9Var = this.f;
            if (br9Var != null) {
                br9Var.k();
            }
            ag<TextView> agVar = this.z;
            if (agVar != null) {
                agVar.c();
            }
            ag<FestivalTipView> agVar2 = this.I;
            if (agVar2 != null) {
                agVar2.c();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            qp9 qp9Var2 = this.K0;
            if (qp9Var2 != null) {
                qp9Var2.F0();
            }
            if (this.Z1 != null) {
                SafeHandler.getInst().removeCallbacks(this.Z1);
            }
            if (this.g2 != null) {
                MessageManager.getInstance().unRegisterListener(this.g2.d());
            }
            hz4.a().e(this.A0);
            hz4.a().e(this.B0);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.b2);
            MessageManager.getInstance().unRegisterListener(this.d2);
            MessageManager.getInstance().unRegisterListener(this.k1);
            MessageManager.getInstance().unRegisterListener(this.e2);
            MessageManager.getInstance().unRegisterListener(this.f2);
            MessageManager.getInstance().unRegisterListener(this.i2);
            MessageManager.getInstance().unRegisterListener(this.N1);
            MessageManager.getInstance().unRegisterListener(this.O1);
            MessageManager.getInstance().unRegisterListener(this.s2);
            MessageManager.getInstance().unRegisterListener(this.M1);
            MessageManager.getInstance().unRegisterListener(this.Q1);
            MessageManager.getInstance().unRegisterListener(this.H1);
            MessageManager.getInstance().unRegisterListener(this.I1);
            MessageManager.getInstance().unRegisterListener(this.h2);
            this.i1 = null;
            this.j1 = null;
            LocationCacheData.getInstance().saveAspShowInfoInSharePref();
            if (this.l1 != null) {
                SafeHandler.getInst().removeCallbacks(this.l1);
            }
            qp9 qp9Var3 = this.K0;
            if (qp9Var3 != null && (ks9Var = qp9Var3.k) != null) {
                ks9Var.k();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.J0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            tp9 tp9Var = this.O0;
            if (tp9Var != null) {
                tp9Var.j();
            }
            PushPermissionController pushPermissionController = this.w0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.C0;
            if (pbModel2 != null && pbModel2.E0() != null) {
                this.C0.E0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.b1;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            qp9 qp9Var4 = this.K0;
            if (qp9Var4 != null) {
                qp9Var4.Q4();
            }
            pr9 pr9Var = this.v0;
            if (pr9Var != null) {
                pr9Var.e();
            }
        }
    }
}
