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
import com.baidu.tbadk.editortools.meme.pan.SpriteMemePanController;
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
import com.baidu.tieba.a1a;
import com.baidu.tieba.a4a;
import com.baidu.tieba.aa8;
import com.baidu.tieba.ah5;
import com.baidu.tieba.aiapps.TbAiappsLaunchUtil;
import com.baidu.tieba.au9;
import com.baidu.tieba.ay9;
import com.baidu.tieba.b4a;
import com.baidu.tieba.bh5;
import com.baidu.tieba.bp5;
import com.baidu.tieba.c05;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cd5;
import com.baidu.tieba.ch5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cu9;
import com.baidu.tieba.d05;
import com.baidu.tieba.d5a;
import com.baidu.tieba.d6a;
import com.baidu.tieba.e4a;
import com.baidu.tieba.e5b;
import com.baidu.tieba.ee5;
import com.baidu.tieba.eh5;
import com.baidu.tieba.ej5;
import com.baidu.tieba.ewa;
import com.baidu.tieba.ex9;
import com.baidu.tieba.f4a;
import com.baidu.tieba.g0a;
import com.baidu.tieba.gr4;
import com.baidu.tieba.gy4;
import com.baidu.tieba.h5b;
import com.baidu.tieba.hl6;
import com.baidu.tieba.i05;
import com.baidu.tieba.i1a;
import com.baidu.tieba.i55;
import com.baidu.tieba.id5;
import com.baidu.tieba.iu4;
import com.baidu.tieba.iw4;
import com.baidu.tieba.iy4;
import com.baidu.tieba.j1a;
import com.baidu.tieba.jp5;
import com.baidu.tieba.jt5;
import com.baidu.tieba.k05;
import com.baidu.tieba.k4a;
import com.baidu.tieba.kw9;
import com.baidu.tieba.l05;
import com.baidu.tieba.l3a;
import com.baidu.tieba.l4a;
import com.baidu.tieba.l95;
import com.baidu.tieba.lo4;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.lp5;
import com.baidu.tieba.lw9;
import com.baidu.tieba.lz9;
import com.baidu.tieba.m05;
import com.baidu.tieba.m1a;
import com.baidu.tieba.m4a;
import com.baidu.tieba.m4b;
import com.baidu.tieba.m55;
import com.baidu.tieba.m6a;
import com.baidu.tieba.mo4;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mwa;
import com.baidu.tieba.n4a;
import com.baidu.tieba.nd5;
import com.baidu.tieba.ne5;
import com.baidu.tieba.nv4;
import com.baidu.tieba.nw9;
import com.baidu.tieba.nwa;
import com.baidu.tieba.o1a;
import com.baidu.tieba.o4a;
import com.baidu.tieba.oh5;
import com.baidu.tieba.oo5;
import com.baidu.tieba.ox9;
import com.baidu.tieba.oz4;
import com.baidu.tieba.p1a;
import com.baidu.tieba.p2a;
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
import com.baidu.tieba.ph5;
import com.baidu.tieba.pi;
import com.baidu.tieba.pp5;
import com.baidu.tieba.push.PushGuideManager;
import com.baidu.tieba.px9;
import com.baidu.tieba.q0a;
import com.baidu.tieba.q2a;
import com.baidu.tieba.qb;
import com.baidu.tieba.qd5;
import com.baidu.tieba.qdb;
import com.baidu.tieba.qe5;
import com.baidu.tieba.qh5;
import com.baidu.tieba.qua;
import com.baidu.tieba.qx4;
import com.baidu.tieba.qy5;
import com.baidu.tieba.qz9;
import com.baidu.tieba.r45;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.rd;
import com.baidu.tieba.re5;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.tieba.ry4;
import com.baidu.tieba.s0a;
import com.baidu.tieba.sb5;
import com.baidu.tieba.se5;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.soa;
import com.baidu.tieba.sx9;
import com.baidu.tieba.t2a;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.ti;
import com.baidu.tieba.to5;
import com.baidu.tieba.twa;
import com.baidu.tieba.ty5;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.uxa;
import com.baidu.tieba.v05;
import com.baidu.tieba.v2a;
import com.baidu.tieba.v95;
import com.baidu.tieba.vb5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vv6;
import com.baidu.tieba.vv9;
import com.baidu.tieba.w2a;
import com.baidu.tieba.w4;
import com.baidu.tieba.w95;
import com.baidu.tieba.wv6;
import com.baidu.tieba.wv9;
import com.baidu.tieba.wz9;
import com.baidu.tieba.x5a;
import com.baidu.tieba.x65;
import com.baidu.tieba.xg5;
import com.baidu.tieba.xq6;
import com.baidu.tieba.xv4;
import com.baidu.tieba.xz5;
import com.baidu.tieba.y0a;
import com.baidu.tieba.y3a;
import com.baidu.tieba.yfa;
import com.baidu.tieba.yg5;
import com.baidu.tieba.yo5;
import com.baidu.tieba.z4a;
import com.baidu.tieba.zw4;
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
public class PbFragment extends BaseFragment implements ty5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, c05.e, TbRichTextView.t, TbPageContextSupport, d6a, m6a.b, m4b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k U2;
    public static final wv6.b V2;
    public transient /* synthetic */ FieldHolder $fh;
    public pb<TbImageView> A;
    public iu4.d A0;
    public CustomMessageListener A1;
    public final View.OnClickListener A2;
    public pb<ImageView> B;
    public iu4.d B0;
    public CustomMessageListener B1;
    public boolean B2;
    public pb<View> C;
    public PbModel C0;
    public CustomMessageListener C1;
    public final BdListView.p C2;
    public pb<TiebaPlusRecommendCard> D;
    public d5a D0;
    public CustomMessageListener D1;
    public final TbRichTextView.z D2;
    public pb<LinearLayout> E;
    public gr4 E0;
    public CustomMessageListener E1;
    public nwa E2;
    public pb<RelativeLayout> F;
    public ForumManageModel F0;
    public CustomMessageListener F1;
    public final d05.c F2;
    public pb<ItemCardView> G;
    public nw9 G0;
    public final CustomMessageListener G1;
    public final d05.c G2;
    @NonNull
    public PbGodGuideController H;
    public PollingModel H0;
    public CustomMessageListener H1;
    public final AdapterView.OnItemClickListener H2;
    public pb<FestivalTipView> I;
    public ShareSuccessReplyToServerModel I0;
    public CustomMessageListener I1;
    public final View.OnLongClickListener I2;
    public boolean J;
    public j1a J0;
    public View.OnClickListener J1;
    public final View.OnClickListener J2;
    public boolean K;
    public boolean K0;
    public CustomMessageListener K1;
    public final ItemCardHelper.c K2;
    public boolean L;
    public boolean L0;
    public CustomMessageListener L1;
    public final NoNetworkView.b L2;
    public pb<GifView> M;
    public boolean M0;
    public CustomMessageListener M1;
    public View.OnTouchListener M2;
    public String N;
    public m1a N0;
    public CustomMessageListener N1;
    public vv6.b N2;
    public boolean O;
    public k05 O0;
    public CustomMessageListener O1;
    public final wz9.b O2;
    public boolean P;
    public m05 P0;
    public SuggestEmotionModel.c P1;
    public int P2;
    public String Q;
    public String Q0;
    public CustomMessageListener Q1;
    public int Q2;
    public LikeModel R;
    public boolean R0;
    public GetSugMatchWordsModel.b R1;
    public String R2;
    public View S;
    public boolean S0;
    public PraiseModel S1;
    public zw4 S2;

    /* renamed from: T  reason: collision with root package name */
    public View f1138T;
    public boolean T0;
    public w2a.h T1;
    public int T2;
    public View U;
    public String U0;
    public CustomMessageListener U1;
    public View V;
    public boolean V0;
    public ResponsedEventListener V1;
    public String W;
    public boolean W0;
    public ResponsedEventListener W1;
    public int X;
    public ewa X0;
    public CheckRealNameModel.b X1;
    public boolean Y;
    public ch5 Y0;
    public px9 Y1;
    public int[] Z;
    public bh5 Z0;
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
    public n4a c1;
    public CustomMessageListener c2;
    public boolean d;
    public ry4 d0;
    public yg5 d1;
    public CustomMessageListener d2;
    public wv6 e;
    public BdUniqueId e0;
    public xg5 e1;
    public CustomMessageListener e2;
    public w2a f;
    public r45 f0;
    public xg5 f1;
    public CustomMessageListener f2;
    public boolean g;
    public boolean g0;
    public int g1;
    public ex9 g2;
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
    public i55 j1;
    public c05.e j2;
    public int k;
    public BdUniqueId k1;
    public k3 k2;
    public d05 l;
    public Runnable l1;
    public m05.f l2;
    public long m;
    public o1a m1;
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
    public sb5 r0;
    public boolean r1;
    public NewWriteModel.d r2;
    public boolean s;
    public boolean s0;
    public int s1;
    public NetMessageListener s2;
    public jp5 t;
    public boolean t0;
    public int t1;
    public final PbModel.h t2;
    public long u;
    @NonNull
    public TiePlusEventController.g u0;
    public List<i3> u1;
    public CustomMessageListener u2;
    public boolean v;
    public l3a v0;
    public int v1;
    public HttpMessageListener v2;
    public long w;
    public PushPermissionController w0;
    public hl6 w1;
    public final gr4.a w2;
    public int x;
    public boolean x0;
    public final i3 x1;
    public final AbsListView.OnScrollListener x2;
    public String y;
    public PbInterviewStatusView.f y0;
    public final q0a.b y1;
    public final w4 y2;
    public pb<TextView> z;
    public final Handler z0;
    public final CustomMessageListener z1;
    public final m55.g z2;

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

    @Override // com.baidu.tieba.ty5
    public void Y1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048658, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.d6a
    public AbsVideoPbFragment h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return null;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m4b
    @NonNull
    public String l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) ? "pb_landing_page" : (String) invokeV.objValue;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048750, this, view2, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d6a
    public PbFragment v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048783, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty5
    public void w0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048788, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.m4b
    @NonNull
    public String z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048799, this)) == null) ? "pb" : (String) invokeV.objValue;
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.J0 != null && this.a != null) {
                    this.b.a.J0.S2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements c05.e {
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

            @Override // com.baidu.tieba.c05.e
            public void onClick(c05 c05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                    c05Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements c05.e {
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

            @Override // com.baidu.tieba.c05.e
            public void onClick(c05 c05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                    c05Var.dismiss();
                    m4a.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l95 l95Var, WriteData writeData, AntiData antiData) {
            vv9 s1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l95Var, writeData, antiData}) == null) {
                if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.C0 != null && this.a.C0.s1() != null) {
                        statisticItem.param("fid", this.a.C0.s1().o());
                    }
                    if (this.a.C0 != null) {
                        statisticItem.param("tid", this.a.C0.M1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                ForumData forumData = null;
                if (z) {
                    if (this.a.Z6()) {
                        this.a.J8(false);
                        au9.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14d1));
                    }
                    m1a m1aVar = this.a.N0;
                    if (m1aVar != null) {
                        m1aVar.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        vb5.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        x65.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.D7()) {
                        this.a.p9();
                    }
                    if (this.a.C0 != null && (s1 = this.a.C0.s1()) != null) {
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
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.b1;
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
                    c05 c05Var = new c05(this.a.getActivity());
                    if (rd.isEmpty(postWriteCallBackData.getErrorString())) {
                        c05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        c05Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    c05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new b(this));
                    c05Var.setPositiveButton(R.string.open_now, new c(this));
                    c05Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbFragment pbFragment = this.a;
                    if (pbFragment.N0 != null) {
                        if (pbFragment.J0 != null && this.a.J0.k1() != null && this.a.J0.k1().f() != null && this.a.J0.k1().f().A()) {
                            this.a.J0.k1().f().x(postWriteCallBackData);
                        }
                        this.a.N0.l(postWriteCallBackData);
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
                    sx9.a(this.b.a.getPageContext(), this.a).show();
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.J0 != null && this.a != null) {
                    this.b.a.J0.S2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements c05.e {
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

            @Override // com.baidu.tieba.c05.e
            public void onClick(c05 c05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                    c05Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements c05.e {
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

            @Override // com.baidu.tieba.c05.e
            public void onClick(c05 c05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                    c05Var.dismiss();
                    m4a.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l95 l95Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            vv9 s1;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l95Var, writeData, antiData}) == null) {
                if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.C0.s1() != null) {
                        statisticItem.param("fid", this.a.C0.s1().o());
                    }
                    statisticItem.param("tid", this.a.C0.M1());
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
                this.a.J0.H3(z, postWriteCallBackData);
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
                    SafeHandler.getInst().postDelayed(this.a.Z1, 300000L);
                }
                ForumData forumData = null;
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.Z0 != null && (this.a.Z0.B() || this.a.Z0.D())) {
                            this.a.Z0.z(false, postWriteCallBackData);
                        }
                        this.a.N0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.b1;
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
                        c05 c05Var = new c05(this.a.getActivity());
                        if (rd.isEmpty(postWriteCallBackData.getErrorString())) {
                            c05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            c05Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        c05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new b(this));
                        c05Var.setPositiveButton(R.string.open_now, new c(this));
                        c05Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (l95Var != null || i == 227001) {
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
                        this.a.J0.Y1(this.a.C0.s1());
                    }
                } else if (this.a.C0.V0()) {
                    vv9 s12 = this.a.C0.s1();
                    if (s12 != null && s12.R() != null && s12.R().getAuthor() != null && (userId = s12.R().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.C0.h3()) {
                        this.a.J0.J3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.C0.h3()) {
                    this.a.J0.J3();
                }
                if (this.a.C0.Z0()) {
                    x5a.t("c10369", this.a.C0.M1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.C0 != null) {
                    Context context = this.a.getContext();
                    vv9 s13 = this.a.C0.s1();
                    String forumId = this.a.C0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    i1a.a(context, s13, forumId, z2, this.a.C0.y1(), this.a.C0.B1(), this.a.C0.A1(), this.a.C0.z1(), this.a.C0.F1(), this.a.C0.G1());
                }
                if (writeData != null) {
                    x65.b(writeData.getContent(), "1");
                }
                if (this.a.D7()) {
                    this.a.p9();
                }
                if (this.a.C0 != null && (s1 = this.a.C0.s1()) != null) {
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
        public final /* synthetic */ yfa a;
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
                    new yfa.b(this.a.b.getPageContext(), this.a.a).a();
                    this.a.b.g8();
                }
            }
        }

        public y1(PbFragment pbFragment, yfa yfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, yfaVar};
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
            this.a = yfaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbFragment pbFragment = this.b;
                pbFragment.r0 = PushOpenUtil.showPushOpenView(pbFragment.getPageContext(), this.a.h(), 0L);
                if (this.b.r0 != null) {
                    this.b.r0.v(new a(this));
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
        public final /* synthetic */ yfa a;
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
                    new yfa.b(this.a.b.getPageContext(), this.a.a).a();
                    this.a.b.g8();
                }
            }
        }

        public z1(PbFragment pbFragment, yfa yfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, yfaVar};
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
            this.a = yfaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbFragment pbFragment = this.b;
                pbFragment.r0 = PushOpenUtil.showPushOpenView(pbFragment.getPageContext(), this.a.h(), 0L);
                if (this.b.r0 != null) {
                    this.b.r0.v(new a(this));
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
                pbFragment.c = true;
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
    public class a1 implements d05.c {
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

        @Override // com.baidu.tieba.d05.c
        public void a(d05 d05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, d05Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.Q0 = pbFragment.Q0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.Q0);
                    new lz9(this.a.C0.M1(), this.a.Q0, "1").start();
                    d05Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.Q0 = pbFragment2.Q0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.Q0);
                    new lz9(this.a.C0.M1(), this.a.Q0, "2").start();
                    d05Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.Q0 = pbFragment3.Q0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.Q0);
                    d05Var.e();
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
                if (error != 0 || !booleanValue || !TbadkCoreApplication.isLogin() || this.a.E0 == null || this.a.E0.e()) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null && (responsedMessage instanceof ThreadPublishHttpResMeesage) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.b.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.thread_distribute_success);
                    if (this.a.J0 != null && (r1 = this.a.J0.r1()) != null && this.a.J0.Z0() != null) {
                        this.a.J0.Z0().removeHeaderView(r1);
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
                pbFragment.showToast(pbFragment.y);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.k1) {
                this.a.J0.C1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                vv9 s1 = this.a.C0.s1();
                if (s1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    s1.y().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.j1.d(this.a.i1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.i1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.d9(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (rd.isEmpty(errorString2)) {
                        errorString2 = this.a.i1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.j1.c(errorString2);
                } else {
                    this.a.V8();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c2 implements iu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.iu4.d
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

        @Override // com.baidu.tieba.iu4.c
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
                        if (this.a.E2.t() != null) {
                            BdToastHelper.toast(qdb.a(this.a.E2.t().feedback_toast));
                        }
                    }
                } finally {
                    this.a.E2 = null;
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
            qz9 G0;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.J0.x2((TbRichText) view2.getTag());
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
                    x5a.J(3, i2, this.a.C0);
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
                    y0a.e(this.a.C0, str, i, eVar);
                    if (this.a.C0.G.a()) {
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
                                    if (this.a.r) {
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
                        builder.setData(arrayList).setIndex(i3).setIsCDN(false).setPostId(eVar.f).setIsReserve(this.a.C0.E1()).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false).setIsSeeHost(this.a.F7()).setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.C0 != null) {
                            builder.setFromForumId(this.a.C0.getFromForumId());
                            if (this.a.C0.s1() != null) {
                                builder.setThreadData(this.a.C0.s1().R());
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
                        builder2.setData(arrayList2).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.a.get(0)).setIsReserve(this.a.C0.E1()).setAssistUrls(concurrentHashMap2).setNeedBroadCaset(false).setIsSeeHost(this.a.F7()).setPostId(eVar.f).setBjhPostId(eVar.f).setIsCanDrag(false);
                        if (this.a.C0 != null) {
                            builder2.setFromForumId(this.a.C0.getFromForumId());
                            if (this.a.C0.s1() != null) {
                                builder2.setThreadData(this.a.C0.s1().R());
                            }
                        }
                        ImageViewerConfig bulid2 = builder2.bulid(this.a.getPageContext().getPageActivity());
                        bulid2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, bulid2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText f = y0a.f(this.a.C0, str, i);
                        if (f != null && (d = y0a.d()) >= 0 && d < f.Q().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = wv9.a(f.Q().get(d));
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
                            if (f.getPostId() != 0 && (G0 = this.a.J0.G0()) != null) {
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
                                            if (f.getPostId() == JavaTypesHelper.toLong(this.a.C0.Q0(), 0L)) {
                                                i9 = 1;
                                            }
                                            x5a.b(this.a.C0.s1(), (nwa) next, ((nwa) next).h0, i9, 3);
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
                            builder3.setData(arrayList3).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.i).setIsReserve(this.a.C0.E1()).setAssistUrls(concurrentHashMap3).setNeedBroadCaset(false).setIsSeeHost(this.a.F7()).setPostId(eVar.f).setBjhPostId(eVar.f).setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.C0 != null) {
                                builder3.setFromForumId(this.a.C0.getFromForumId());
                                if (this.a.C0.s1() != null) {
                                    builder3.setThreadData(this.a.C0.s1().R());
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
                if (!this.a.g && z && !this.a.C0.h1()) {
                    this.a.y8();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof qx4)) {
                qx4 qx4Var = (qx4) customResponsedMessage.getData();
                iy4.a aVar = new iy4.a();
                int i = qx4Var.a;
                String str = qx4Var.b;
                aVar.a = qx4Var.d;
                vv9 s1 = this.a.C0.s1();
                if (s1 == null) {
                    return;
                }
                if (this.a.C0.U0() != null && this.a.C0.U0().getUserIdLong() == qx4Var.p) {
                    this.a.J0.Z2(qx4Var.l, this.a.C0.s1(), this.a.C0.L1(), this.a.C0.D1());
                }
                if (s1.I() != null && s1.I().size() >= 1 && s1.I().get(0) != null) {
                    long j = JavaTypesHelper.toLong(s1.I().get(0).U(), 0L);
                    long j2 = JavaTypesHelper.toLong(this.a.C0.M1(), 0L);
                    if (j == qx4Var.n && j2 == qx4Var.m) {
                        iy4 S = s1.I().get(0).S();
                        if (S == null) {
                            S = new iy4();
                        }
                        ArrayList<iy4.a> a = S.a();
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        a.add(0, aVar);
                        S.e(S.b() + qx4Var.l);
                        S.d(a);
                        s1.I().get(0).d1(S);
                        this.a.J0.G0().v();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.k1) {
                this.a.J0.C1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.j1.d(this.a.i1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (rd.isEmpty(muteMessage)) {
                    muteMessage = this.a.i1.getResources().getString(R.string.un_mute_fail);
                }
                this.a.j1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d2 implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, vv9 vv9Var, String str, int i4, boolean z2) {
            ne5 t;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), vv9Var, str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
                if (this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907f7));
                }
                if (!z || vv9Var == null || vv9Var.b0() != null || ListUtils.getCount(vv9Var.I()) >= 1) {
                    if (this.a.h0) {
                        if (this.a.l0() != null) {
                            this.a.l0().A0();
                        }
                    } else {
                        this.a.h0 = true;
                    }
                    this.a.h = true;
                    if (this.a.J0 == null) {
                        return;
                    }
                    this.a.J0.I3();
                    if (vv9Var == null || !vv9Var.t0()) {
                        PbFragment pbFragment = this.a;
                        pbFragment.hideLoadingView(pbFragment.J0.u1());
                    }
                    this.a.J0.E1();
                    if (this.a.K) {
                        this.a.J0.x1();
                    } else if (!this.a.J0.d2()) {
                        this.a.J0.X3(false);
                    }
                    if (this.a.i) {
                        this.a.i = false;
                    }
                    if (i4 == 0 && vv9Var != null) {
                        this.a.R0 = true;
                    }
                    if (vv9Var != null) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.hideNetRefreshView(pbFragment2.J0.u1());
                        this.a.J0.U3();
                    }
                    String str2 = null;
                    if (z && vv9Var != null) {
                        ThreadData R = vv9Var.R();
                        if (R != null && R.isUgcThreadType()) {
                            d();
                        } else {
                            PbFragment pbFragment3 = this.a;
                            pbFragment3.M8(pbFragment3.Y0);
                        }
                        this.a.J0.k1().r(vv9Var);
                        this.a.J0.d4();
                        if (R != null && R.getCartoonThreadData() != null) {
                            this.a.t9(R.getCartoonThreadData());
                        }
                        if (this.a.Z0 != null) {
                            this.a.J0.p3(this.a.Z0.C());
                        }
                        TbadkCoreApplication.getInst().setDefaultBubble(vv9Var.Y().getBimg_url());
                        TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(vv9Var.Y().getDynamicUrl());
                        TbadkCoreApplication.getInst().setDefaultBubbleEndTime(vv9Var.Y().getBimg_end_time());
                        if (vv9Var.I() == null || vv9Var.I().size() < 1 || vv9Var.I().get(0) == null) {
                            if (vv9Var.b0() != null) {
                                this.a.C0.Q2(vv9Var.b0().U());
                            }
                        } else {
                            this.a.C0.Q2(vv9Var.I().get(0).U());
                        }
                        if (this.a.Z0 != null) {
                            this.a.Z0.L(vv9Var.f());
                            this.a.Z0.M(vv9Var.n(), vv9Var.Y());
                            this.a.Z0.o0(R);
                            this.a.Z0.N(this.a.C0.U0(), this.a.C0.M1(), this.a.C0.Q0());
                            if (R != null) {
                                this.a.Z0.d0(R.isMutiForumThread());
                            }
                        }
                        if (this.a.E0 != null) {
                            this.a.E0.h(vv9Var.t());
                        }
                        this.a.r = vv9Var.u() == 1;
                        if (vv9Var.a()) {
                            this.a.r = true;
                        }
                        this.a.J0.q3(this.a.r);
                        if (this.a.v0.f.size() > 0) {
                            vv9Var.U0(this.a.v0.f);
                        }
                        this.a.J0.g4(vv9Var, i2, i3, this.a.C0.L1(), i4, this.a.C0.b1());
                        this.a.J0.u4(vv9Var, this.a.C0.L1());
                        this.a.J0.A4(this.a.C0.V0());
                        AntiData f = vv9Var.f();
                        if (f != null) {
                            this.a.y = f.getVoice_message();
                            if (!StringUtils.isNull(this.a.y) && this.a.Z0 != null && this.a.Z0.a() != null && (t = this.a.Z0.a().t(6)) != null && !TextUtils.isEmpty(this.a.y)) {
                                ((View) t).setOnClickListener(this.a.J1);
                            }
                        }
                        if (!z2 && !this.a.Y && !ListUtils.isEmpty(this.a.C0.s1().I()) && !this.a.C0.h2()) {
                            this.a.Y = true;
                            this.a.q6(false);
                        }
                        if (!TextUtils.isEmpty(this.a.U0)) {
                            PbFragment pbFragment4 = this.a;
                            i1a.B(pbFragment4, q2a.a(pbFragment4.C0), this.a.U0);
                            this.a.U0 = null;
                        } else if (this.a.T0) {
                            this.a.T0 = false;
                            if (this.a.i7() != null && this.a.i7().b1() != null && this.a.i7().b1().getVisibility() == 0 && this.a.i7().b1().getPlayerHeight() > 0) {
                                PbFragment pbFragment5 = this.a;
                                y3a.f(pbFragment5, pbFragment5.i7().b1().getPlayerHeight());
                            } else {
                                y3a.f(this.a, 0);
                            }
                        } else if (this.a.V0) {
                            this.a.V0 = false;
                            p2a.k(this.a.getListView());
                        } else if (!TextUtils.isEmpty(this.a.C0.i1())) {
                            p2a.f(this.a.getListView(), this.a.C0.i1());
                            this.a.C0.o2();
                        } else {
                            this.a.J0.c4();
                        }
                        this.a.C0.p2(vv9Var.n(), this.a.P1);
                        this.a.C0.t2(this.a.R1);
                        if (this.a.b1 != null && R != null && R.getAuthor() != null) {
                            AttentionHostData attentionHostData = new AttentionHostData();
                            attentionHostData.parserWithMetaData(R.getAuthor());
                            this.a.b1.setLikeUserData(attentionHostData);
                        }
                        if (this.a.C0 != null && this.a.C0.d2()) {
                            str2 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                        } else if (this.a.J0 != null) {
                            str2 = this.a.J0.m1();
                        }
                        if (this.a.Z0 != null && !StringUtils.isNull(str2)) {
                            this.a.Z0.g0(TbSingleton.getInstance().getAdVertiComment(vv9Var.r0(), vv9Var.s0(), str2));
                        }
                        if (!this.a.R0 && ((i2 == 1 || i2 == 2) && this.a.J0 != null)) {
                            this.a.J0.D0();
                        }
                    } else if (str != null) {
                        if (this.a.R0 || i4 != 1) {
                            this.a.showToast(str);
                        } else if (i2 == 3 || i2 == 4 || i2 == 6 || i2 == 9) {
                            if (i != 4) {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.J0.u1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                soa.a("pb", false);
                                bp5.a.a(this.a.getUniqueId(), new Pair<>(PushMessageHelper.ERROR_TYPE, "pb_page"), new Pair<>("error_info", "pb page net error2"));
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
                            } else if (this.a.C0.H0() == null || StringUtils.isNull(this.a.C0.H0().c)) {
                                PbFragment pbFragment8 = this.a;
                                pbFragment8.showNetRefreshView(pbFragment8.J0.u1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                soa.a("pb", false);
                                bp5.a.a(this.a.getUniqueId(), new Pair<>(PushMessageHelper.ERROR_TYPE, "pb_page"), new Pair<>("error_info", "pb page net error1"));
                                PbFragment pbFragment9 = this.a;
                                pbFragment9.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment9.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
                            } else {
                                this.a.J0.C4(this.a.C0.H0());
                            }
                            this.a.J0.x1();
                            this.a.J0.w1();
                        }
                        if (i == 4 || i == 350008) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tid", this.a.C0.M1());
                                jSONObject.put("fid", this.a.C0.getForumId());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                            xq6.b().c(new w95(this.a.C0.M1()));
                        }
                        if (i != 0) {
                            EnterForePvThread enterForePvThread = new EnterForePvThread();
                            enterForePvThread.setOpType("2");
                            enterForePvThread.start();
                        }
                        if (i != -1) {
                            ArrayList<nwa> I = (this.a.C0 == null || this.a.C0.s1() == null) ? null : this.a.C0.s1().I();
                            if (ListUtils.getCount(I) == 0 || (ListUtils.getCount(I) == 1 && I.get(0) != null && I.get(0).L() == 1)) {
                                if (this.a.F7()) {
                                    this.a.J0.m3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1036));
                                } else {
                                    this.a.J0.m3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1037));
                                }
                                this.a.J0.Y1(this.a.C0.s1());
                            } else {
                                this.a.J0.l3(this.a.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            this.a.J0.l3("");
                        }
                        this.a.J0.z0();
                    }
                    if (vv9Var != null && vv9Var.m && this.a.n == 0) {
                        this.a.n = System.currentTimeMillis() - this.a.m;
                    }
                    if (this.a.b instanceof PbActivity) {
                        ((PbActivity) this.a.b).c2(vv9Var != null ? vv9Var.i() : 0, this.a.J0);
                    }
                    if (this.a.C0 == null || this.a.C0.s1() == null) {
                        return;
                    }
                    this.a.C0.s1();
                    return;
                }
                this.a.C0.e3(1);
                if (this.a.f != null) {
                    this.a.f.x();
                }
                if (this.a.J0 != null) {
                    this.a.J0.n4();
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
        public void b(vv9 vv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vv9Var) == null) {
                this.a.J0.Y1(vv9Var);
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
            pp5 pp5Var = new pp5(i, z, responsedMessage, this.a.q, this.a.p, this.a.n, z2, 0L, 0L, j4);
            this.a.p = 0L;
            this.a.q = 0L;
            pp5Var.c();
            if (z2) {
                j3 = j4;
                pp5Var.B = j3;
                pp5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.C0 != null && this.a.C0.s1() != null && this.a.C0.s1().R() != null) {
                int threadType = this.a.C0.s1().R().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.N, "from_personalize")) {
                        lp5 lp5Var = new lp5();
                        lp5Var.F = 1;
                        lp5Var.a(1005);
                        lp5Var.D = j3;
                        lp5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.N, "from_frs")) {
                        pp5 pp5Var2 = new pp5();
                        pp5Var2.a(1000);
                        pp5Var2.D = j3;
                        pp5Var2.d(threadType);
                    }
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
            ah5 ah5Var = new ah5();
            this.a.M8(ah5Var);
            PbFragment pbFragment = this.a;
            pbFragment.Z0 = (bh5) ah5Var.a(pbFragment.getContext());
            this.a.Z0.a0(this.a.b.getPageContext());
            this.a.Z0.j0(this.a.p2);
            this.a.Z0.k0(this.a.d1);
            bh5 bh5Var = this.a.Z0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.b.getPageContext();
            if (this.a.b.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.b.getIntent().getExtras();
            }
            bh5Var.E(pageContext, extras);
            this.a.Z0.a().M(true);
            this.a.J0.k3(this.a.Z0.a());
            if (!this.a.C0.f1()) {
                this.a.Z0.t(this.a.C0.M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.Z0.g0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.C0.d2()) {
                this.a.Z0.g0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.J0 != null) {
                this.a.Z0.g0(this.a.J0.m1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d3 implements d05.c {
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

        @Override // com.baidu.tieba.d05.c
        public void a(d05 d05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, d05Var, i, view2) == null) {
                if (d05Var != null) {
                    d05Var.e();
                }
                PbFragment pbFragment = this.a;
                nwa nwaVar = pbFragment.E2;
                if (nwaVar != null) {
                    if (i == 0) {
                        nwaVar.V0();
                        this.a.E2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.X7(pbFragment2.E2);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof xz5)) {
                xz5 xz5Var = (xz5) customResponsedMessage.getData();
                vv9 s1 = this.a.C0.s1();
                if (s1 == null) {
                    return;
                }
                if (this.a.C0.s1() != null && this.a.C0.s1().a0().u() != null && this.a.C0.s1().a0().u().getPortrait() != null && this.a.C0.s1().a0().u().getPortrait().equals(xz5Var.a)) {
                    if (this.a.C0.s1().a0().u().getUserWorldCupData() != null) {
                        this.a.C0.s1().a0().u().getUserWorldCupData().c(xz5Var.b);
                    }
                    this.a.J0.a3(this.a.C0.s1(), this.a.C0.L1(), this.a.C0.D1(), this.a.J0.p1());
                }
                if (s1.I() != null && s1.I().size() >= 0) {
                    Iterator<nwa> it = s1.I().iterator();
                    while (it.hasNext()) {
                        nwa next = it.next();
                        if (next != null && next.u() != null && next.u().getPortrait() != null && next.u().getPortrait().equals(xz5Var.a) && next.u().getUserWorldCupData() != null) {
                            next.u().getUserWorldCupData().c(xz5Var.b);
                        }
                    }
                    this.a.J0.G0().v();
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
                if (!this.a.D7() || this.a.b == null || this.a.b.B1() == null || !str.equals(this.a.b.B1().getTopicId())) {
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
    public class e3 implements d05.c {
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

        @Override // com.baidu.tieba.d05.c
        public void a(d05 d05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, d05Var, i, view2) == null) {
                if (d05Var != null) {
                    d05Var.e();
                }
                if (this.a.n1 != null && !TextUtils.isEmpty(this.a.o1)) {
                    if (i == 0) {
                        if (this.a.q1 != null) {
                            ej5.a aVar = new ej5.a();
                            aVar.a = this.a.o1;
                            String str = "";
                            if (this.a.q1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.q1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        } else {
                            this.a.l6();
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
                            pbFragment.m1 = new o1a(pbFragment.getPageContext());
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
                this.a.e.c(motionEvent);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.C0 != null && this.a.C0.s1() != null) {
                this.a.C0.s1().c();
                this.a.C0.X1();
                if (this.a.J0.G0() != null) {
                    this.a.J0.Y1(this.a.C0.s1());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof h5b) && customResponsedMessage.getOrginalMessage().getTag() == this.a.k1) {
                h5b h5bVar = (h5b) customResponsedMessage.getData();
                this.a.J0.C1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.h1;
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
                        this.a.J0.O2(sparseArray, z);
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
                if (this.a.J0 != null) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.J0.u1());
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
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e6f);
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
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.C0 == null || this.a.C0.C1() == i + 1) {
                return;
            }
            this.a.H8(i1a.m(i));
        }
    }

    /* loaded from: classes7.dex */
    public class g implements vv6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.vv6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.vv6.b
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

        @Override // com.baidu.tieba.vv6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.J0 != null && this.b.f != null) {
                this.b.f.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.f.l();
                }
                if (this.b.Y6()) {
                    this.b.J0.D1();
                    this.b.J0.i3();
                }
            }
        }

        @Override // com.baidu.tieba.vv6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.J0 != null && this.b.f != null) {
                this.b.J0.l4();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.C0 != null && this.a.C0.s1() != null) {
                String str = (String) customResponsedMessage.getData();
                mwa mwaVar = null;
                if (!TextUtils.isEmpty(str) && this.a.C0.s1().I() != null) {
                    ArrayList<nwa> I = this.a.C0.s1().I();
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
                if (this.a.J0.G0() != null && !ListUtils.isEmpty(this.a.J0.G0().l())) {
                    ArrayList<pi> l = this.a.J0.G0().l();
                    if (mwaVar != null) {
                        f = mwaVar;
                    } else {
                        f = i1a.f(this.a.C0.s1(), str);
                    }
                    y3a.c(l, f);
                }
                if (this.a.J0.Z0() != null && !ListUtils.isEmpty(this.a.J0.Z0().getData())) {
                    List<pi> data = this.a.J0.Z0().getData();
                    if (mwaVar == null) {
                        mwaVar = i1a.f(this.a.C0.s1(), str);
                    }
                    y3a.c(data, mwaVar);
                }
                this.a.B6(str);
                this.a.C0.X1();
                if (this.a.J0.G0() != null) {
                    this.a.J0.G0().v();
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
        public void onNavigationButtonClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g2 implements gr4.a {
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

        @Override // com.baidu.tieba.gr4.a
        public void a(boolean z, boolean z2, String str, @Nullable String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2}) == null) {
                this.a.J0.I3();
                if (z) {
                    if (this.a.E0 != null) {
                        this.a.E0.h(z2);
                    }
                    this.a.C0.g3(z2);
                    if (!this.a.C0.d1()) {
                        this.a.J0.Y1(this.a.C0.s1());
                    } else {
                        this.a.S7();
                    }
                    if (z2) {
                        boolean q0 = this.a.C0.s1().q0();
                        if (this.a.E0 != null && !q0) {
                            if (this.a.E0.f() != null && this.a.C0 != null && this.a.C0.s1() != null && this.a.C0.s1().R() != null && this.a.C0.s1().R().getAuthor() != null) {
                                MarkData f = this.a.E0.f();
                                MetaData author = this.a.C0.s1().R().getAuthor();
                                if (f != null && author != null) {
                                    if (str2 == null) {
                                        str2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0100);
                                    }
                                    BdUtilHelper.showToast(str2, 2000, true);
                                    this.a.Z8(this.a.C0.s1().R());
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
    public class g3 implements m05.d {
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

        @Override // com.baidu.tieba.m05.d
        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.P0 != null) {
                this.a.P0.s(e4a.f(this.a.E2));
                ArrayList arrayList = new ArrayList();
                for (l05 l05Var : this.a.P0.h()) {
                    if (l05Var instanceof i05) {
                        arrayList.add((i05) l05Var);
                    }
                }
                e4a.d(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements wv6.b {
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

        @Override // com.baidu.tieba.wv6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    ox9.d();
                } else {
                    ox9.c();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.J0.a2() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
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
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.C0 != null && this.a.C0.s1() != null && this.a.J0 != null && this.a.J0.G0() != null) {
                this.a.J0.H2(absListView, i, i2, i3);
                if (this.a.f != null) {
                    this.a.f.q(absListView, i, i2, i3);
                }
                if (this.a.C0.i2() && (I = this.a.C0.s1().I()) != null && !I.isEmpty()) {
                    int m = ((i + i2) - this.a.J0.G0().m()) - 1;
                    vv9 s1 = this.a.C0.s1();
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
                if (!i1a.x(this.a.g1) && i1a.x(i)) {
                    if (this.a.J0 != null) {
                        this.a.s0 = true;
                        this.a.J0.s0();
                        if (this.a.Z0 != null && !this.a.J0.a2()) {
                            this.a.J0.p3(this.a.Z0.C());
                        }
                        if (!this.a.K) {
                            this.a.s0 = true;
                            this.a.J0.h3();
                        }
                    }
                    if (!this.a.s) {
                        this.a.s = true;
                    }
                }
                if (this.a.J0 != null) {
                    this.a.J0.I2(absListView, i);
                }
                if (this.a.f != null) {
                    this.a.f.r(absListView, i);
                }
                if (this.a.t == null) {
                    this.a.t = new jp5();
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
                    qua.g().h(this.a.getUniqueId(), true);
                    this.a.q6(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h3 implements xg5 {
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

        @Override // com.baidu.tieba.xg5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                m1a m1aVar = this.a.N0;
                if (m1aVar != null && m1aVar.g() != null && this.a.N0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.N0.g().c());
                    if (this.a.J0 != null && this.a.J0.k1() != null && this.a.J0.k1().f() != null && this.a.J0.k1().f().A()) {
                        this.a.J0.k1().f().x(this.a.N0.h());
                    }
                    this.a.N0.b(true);
                    return true;
                }
                return !this.a.v6(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i implements wz9.b {
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

        @Override // com.baidu.tieba.wz9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f17d3);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e6f);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.J0.q0(str);
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
        public void a(t2a t2aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, t2aVar) != null) || t2aVar == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, t2aVar.a()));
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
                if (this.a.J0 != null) {
                    this.a.J0.t2(agreeMessageData);
                }
                if (agreeData.agreeType == 2 && this.a.J0 != null && !o4a.g(this.a.C0.b)) {
                    this.a.J0.p4();
                    o4a.a(this.a.C0.b);
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
    public class j implements c05.e {
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

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    c05Var.dismiss();
                    ((TbPageContext) this.a.i1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                c05Var.dismiss();
                m4a.a(this.a.getPageContext());
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
                if (!this.a.s0) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        this.a.g8();
                        return;
                    } else {
                        this.a.D8();
                        return;
                    }
                }
                this.a.s0 = false;
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
        public void onNavigationButtonClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class j3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<j1a> a;
        public WeakReference<PbFragment> b;

        public j3(j1a j1aVar, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j1aVar, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(j1aVar);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                j1a j1aVar = this.a.get();
                if (j1aVar != null) {
                    j1aVar.C1();
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
                        aa8.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0e6f);
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
                if (this.a.J0 != null && this.a.J0.k1() != null) {
                    g0a k1 = this.a.J0.k1();
                    if (k1.j()) {
                        k1.h();
                        return true;
                    }
                }
                if (this.a.J0 != null && this.a.J0.o2()) {
                    this.a.J0.G1();
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
                this.a.J0.r4(!this.a.O);
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
                this.a.r1 = true;
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
                switch (this.a.F0.getLoadDataMode()) {
                    case 0:
                        this.a.C0.X1();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.N6(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.J0.B0(1, dVar.a, dVar.b, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbFragment pbFragment = this.a;
                        pbFragment.O6(pbFragment.F0.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        this.a.J0.B0(this.a.F0.getLoadDataMode(), gVar.a, gVar.b, false);
                        this.a.J0.J2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.J0.B0(this.a.F0.getLoadDataMode(), false, null, false);
        }
    }

    /* loaded from: classes7.dex */
    public class l implements c05.e {
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

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                c05Var.dismiss();
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
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && !ListUtils.isEmpty(list) && this.a.J0 != null) {
                this.a.J0.P3(list);
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
    public class l1 implements c05.e {
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

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                this.a.t7();
                gy4 q1 = this.a.C0.q1();
                int h1 = this.a.J0.h1();
                if (h1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f1039);
                } else if (q1 != null && h1 > q1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f1039);
                } else {
                    this.a.J0.s0();
                    this.a.i9();
                    this.a.J0.J3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.C0.e3(this.a.J0.h1());
                        if (this.a.f != null) {
                            this.a.f.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e6f);
                    }
                    c05Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l2 implements yg5 {
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

        @Override // com.baidu.tieba.yg5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements c05.e {
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

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                c05Var.dismiss();
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
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.S1 != null && str != null) {
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
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || this.a.S1 == null) {
                return;
            }
            vv9 s1 = this.a.C0.s1();
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
                String valueOf = String.valueOf(this.a.C0.s1().Y().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.C0.s1().n().getId(), this.a.C0.s1().n().getName(), this.a.C0.s1().R().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m2 implements c05.e {
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

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) && c05Var != null) {
                c05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements c05.e {
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

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                this.b.J0.e4();
                MessageManager.getInstance().sendMessage(this.a);
                c05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements w2a.h {
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

        @Override // com.baidu.tieba.w2a.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.L8(z);
                if (this.a.J0.W0() != null && z) {
                    this.a.J0.r4(false);
                }
                this.a.J0.A2(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n1 implements m05.f {
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

        @Override // com.baidu.tieba.m05.f
        public void E0(m05 m05Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, m05Var, i, view2) == null) {
                if (this.a.O0 != null) {
                    this.a.O0.dismiss();
                }
                this.a.r9(i);
                if (i != -4) {
                    if (i != -3) {
                        if (i != -2) {
                            if (i != -1) {
                                if (i != 13) {
                                    switch (i) {
                                        case 1:
                                            if (this.a.n1 != null && !TextUtils.isEmpty(this.a.o1)) {
                                                if (this.a.q1 != null) {
                                                    ej5.a aVar = new ej5.a();
                                                    aVar.a = this.a.o1;
                                                    String str = "";
                                                    if (this.a.q1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.q1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.l6();
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
                                                    pbFragment.m1 = new o1a(pbFragment.getPageContext());
                                                }
                                                this.a.m1.b(this.a.o1, this.a.n1.getImageByte());
                                                this.a.n1 = null;
                                                this.a.o1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            nwa nwaVar = this.a.E2;
                                            if (nwaVar != null) {
                                                nwaVar.V0();
                                                this.a.E2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.W7(view2);
                                            if (this.a.C0.s1().R() != null && this.a.C0.s1().R().getAuthor() != null && this.a.C0.s1().R().getAuthor().getUserId() != null && this.a.E0 != null) {
                                                x5a.E(2, i1a.r(this.a.C0.s1()), !this.a.E0.e(), this.a.C0);
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
                                                        this.a.J0.M2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, Z);
                                                        return;
                                                    } else {
                                                        this.a.S8(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.J0.K2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
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
                                                this.a.J0.P2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.J0.K2(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                            if (this.a.checkUpIsLogin() && this.a.C0 != null && this.a.C0.s1() != null) {
                                                this.a.b.P1(e5b.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.C0 != null && this.a.C0.s1() != null) {
                                    this.a.J0.H4(true);
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
    public class n2 implements m55.g {
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

        @Override // com.baidu.tieba.m55.g
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.Y6()) {
                    this.a.b.finish();
                }
                if (this.a.C0.s2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.J0.A0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements c05.e {
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

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                c05Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o0 implements m05.f {
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

        @Override // com.baidu.tieba.m05.f
        public void E0(m05 m05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, m05Var, i, view2) == null) {
                if (this.e.O0 != null) {
                    this.e.O0.dismiss();
                }
                if (i == 0) {
                    this.e.J0.K2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.k1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.k1);
                    this.e.e9(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o1 implements c05.e {
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

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                if (c05Var != null) {
                    c05Var.dismiss();
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
                    this.a.b.finish();
                }
                if (this.a.C0.s2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.J0.A0();
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
            m1a m1aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (m1aVar = this.a.N0) != null && m1aVar.g() != null) {
                if (!this.a.N0.g().e()) {
                    this.a.N0.b(false);
                }
                this.a.N0.g().l(false);
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
                    if (updateAttentionMessage.getOrginalMessage().getTag() == this.a.getUniqueId() && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().blockData, PbFragment.U2) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                        return;
                    }
                    return;
                }
                if (updateAttentionMessage.getData().isSucc) {
                    if (this.a.T6().u() != null && this.a.T6().u().getGodUserData() != null) {
                        this.a.T6().u().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.C0 != null && this.a.C0.s1() != null && this.a.C0.s1().R() != null && this.a.C0.s1().R().getAuthor() != null) {
                        this.a.C0.s1().R().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
                if (updateAttentionMessage.isAttention()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921760, 10));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p1 implements c05.e {
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

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                c05Var.dismiss();
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
                if (this.a.B2 && this.a.Y6()) {
                    this.a.N7();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (this.a.J0 != null) {
                    this.a.J0.j3();
                }
                if (!this.a.g0 && this.a.J0 != null && this.a.J0.i0() && this.a.C0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.C0.M1());
                    statisticItem.param("fid", this.a.C0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.C0.X0()) {
                        i = 4;
                    } else if (this.a.C0.Y0()) {
                        i = 3;
                    } else if (this.a.C0.a1()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.g0 = true;
                }
                if (this.a.C0.q2(false)) {
                    this.a.J0.K3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (this.a.C0.s1() != null) {
                    this.a.J0.c3();
                }
                this.a.B2 = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements q0a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.q0a.b
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

        @Override // com.baidu.tieba.q0a.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.J0.v4(str);
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
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.lm5
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
                this.a.J0.s0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.C0 != null && !this.a.C0.isLoading) {
                    this.a.i9();
                    this.a.J0.J3();
                    z = true;
                    if (this.a.C0.s1() != null && this.a.C0.s1().f != null && this.a.C0.s1().f.size() > i) {
                        int intValue = this.a.C0.s1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.C0.N1()).param("fid", this.a.C0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.C0.k3(intValue)) {
                            this.a.i = true;
                            this.a.J0.y3(true);
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.C0 != null) {
                this.a.C0.loadData();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.C0 != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.Z0 != null) {
                    this.a.J0.p3(this.a.Z0.C());
                }
                this.a.J0.h3();
                this.a.J0.s0();
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
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.lm5
        /* renamed from: g */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                if (this.a.J0 != null && topToastEvent != null) {
                    new BdTopToast(this.a.getContext()).setIcon(topToastEvent.isSuccess()).setContent(topToastEvent.getContent()).show(this.a.J0.u1());
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class r1 implements iu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.iu4.d
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

        @Override // com.baidu.tieba.iu4.c
        public void a(@NonNull String str) {
            nwa a0;
            cd5 b0;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("PbFragment", "收到H5通知，更新Pb数据：" + str);
                if (this.a.C0 == null) {
                    return;
                }
                this.a.C0.loadData();
                vv9 s1 = this.a.C0.s1();
                if (s1 != null && (a0 = s1.a0()) != null && (b0 = a0.b0()) != null && !b0.n()) {
                    oo5 oo5Var = new oo5();
                    oo5Var.t(b0);
                    String T2 = s1.T();
                    String o = s1.o();
                    if (s1.R() != null) {
                        i = s1.R().getThreadType();
                    } else {
                        i = 0;
                    }
                    oo5Var.v(T2, o, i, this.a.C0.L0(), this.a.C0.x1(), b0.d());
                    String x = oo5Var.x(b0.e());
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(NovelWebViewActivityConfig.KEY_IS_SHOW_TOAST_TIP, true);
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_ID, String.valueOf(b0.h()));
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_TID, oo5Var.i());
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_FID, oo5Var.e());
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
            this.a.C0.n3((UserPendantData) customResponsedMessage.getData());
            if (this.a.J0 != null && this.a.C0 != null) {
                this.a.J0.a3(this.a.C0.s1(), this.a.C0.L1(), this.a.C0.D1(), this.a.J0.p1());
            }
            if (this.a.J0 != null && this.a.J0.G0() != null) {
                this.a.J0.G0().v();
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
            j1a j1aVar = this.b.J0;
            j1aVar.M3("@" + this.a.getStringExtra("big_pic_type") + " ");
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
    public class s2 implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ c05 c;
        public final /* synthetic */ PbFragment d;

        public s2(PbFragment pbFragment, MarkData markData, MarkData markData2, c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, c05Var};
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
            this.c = c05Var;
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                c05Var.dismiss();
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
                if (this.a.J0 == null) {
                    return;
                }
                if (booleanValue) {
                    this.a.J0.m4();
                } else {
                    this.a.J0.E1();
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
                if (this.a.J0 != null && this.a.J0.G0() != null) {
                    return this.a.J0.G0().l();
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
    public class t2 implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ c05 b;
        public final /* synthetic */ PbFragment c;

        public t2(PbFragment pbFragment, MarkData markData, c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, c05Var};
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
            this.b = c05Var;
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                c05Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.b.setResult(-1, intent);
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
            if (this.a.Z0 != null) {
                this.a.J0.p3(this.a.Z0.C());
            }
            this.a.J0.X3(false);
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
                if (this.a.J0 != null && this.a.J0.G0() != null) {
                    this.a.J0.G0().v();
                    return null;
                }
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class u1 implements m05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k05 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ PbFragment c;

        public u1(PbFragment pbFragment, k05 k05Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, k05Var, view2};
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
            this.a = k05Var;
            this.b = view2;
        }

        @Override // com.baidu.tieba.m05.f
        public void E0(m05 m05Var, int i, View view2) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, m05Var, i, view2) == null) {
                this.a.dismiss();
                PbModel pbModel = this.c.C0;
                if (this.b.getId() == R.id.obfuscated_res_0x7f091c31) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                x5a.K(i, pbModel, i2);
                if (this.c.C0.s1().f != null && this.c.C0.s1().f.size() > i) {
                    i = this.c.C0.s1().f.get(i).sort_type.intValue();
                }
                boolean k3 = this.c.C0.k3(i);
                this.b.setTag(Integer.valueOf(this.c.C0.J1()));
                if (!k3) {
                    return;
                }
                this.c.i = true;
                this.c.J0.y3(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ c05 b;
        public final /* synthetic */ PbFragment c;

        public u2(PbFragment pbFragment, MarkData markData, c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, c05Var};
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
            this.b = c05Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.J0 != null && this.c.J0.u1() != null) {
                    this.c.J0.u1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.b.setResult(-1, intent);
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
                cu9 cu9Var = (cu9) customResponsedMessage.getData();
                int b = cu9Var.b();
                if (b != 0) {
                    if (b != 1) {
                        if (b == 2) {
                            if (cu9Var.a() == null) {
                                this.a.w8(false, null);
                                return;
                            } else {
                                this.a.w8(true, (MarkData) cu9Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.N6((ForumManageModel.b) cu9Var.a(), false);
                    return;
                }
                this.a.x8((lw9) cu9Var.a());
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
                if (message.what == 2 && this.a.C0 != null && this.a.C0.d1()) {
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
                if (this.a.t0 && (view2 == this.a.J0.j.e || view2 == this.a.J0.j.f || view2.getId() == R.id.obfuscated_res_0x7f091c0d || view2.getId() == R.id.obfuscated_res_0x7f090bca || view2.getId() == R.id.obfuscated_res_0x7f091fd2 || view2.getId() == R.id.obfuscated_res_0x7f091ba5)) {
                    return;
                }
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.J0.d1()) {
                        this.a.Y7();
                    }
                } else {
                    this.a.C8(view2);
                }
                if (view2 == this.a.J0.f1()) {
                    if (this.a.i || !this.a.C0.q2(true)) {
                        return;
                    }
                    this.a.i = true;
                    this.a.J0.K3();
                } else if (this.a.J0.j.i() == null || view2 != this.a.J0.j.i().F()) {
                    if (this.a.J0.j.i() == null || view2 != this.a.J0.j.i().x()) {
                        if (view2 == this.a.J0.j.h) {
                            if (!this.a.J0.h0(this.a.C0.f1())) {
                                BdUtilHelper.hideSoftKeyPad(this.a.b, this.a.J0.j.h);
                                this.a.b.finish();
                                return;
                            }
                            this.a.i9();
                            return;
                        } else if (view2 != this.a.J0.K0() && (this.a.J0.j.i() == null || (view2 != this.a.J0.j.i().G() && view2 != this.a.J0.j.i().H()))) {
                            if (view2 == this.a.J0.S0()) {
                                if (this.a.C0 != null) {
                                    BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), this.a.C0.s1().R().getTopicData().b());
                                    return;
                                }
                                return;
                            } else if (view2 != this.a.J0.j.e) {
                                if (view2 != this.a.J0.j.f) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f091bcc) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091ba0) {
                                            if ((this.a.J0.j.i() == null || view2 != this.a.J0.j.i().D()) && view2.getId() != R.id.obfuscated_res_0x7f090bca && view2.getId() != R.id.obfuscated_res_0x7f091fd2) {
                                                if (this.a.J0.j.i() != null && view2 == this.a.J0.j.i().y()) {
                                                    this.a.J0.j.f();
                                                    return;
                                                } else if (view2.getId() == R.id.share_num_container) {
                                                    if (!i1a.b(this.a.getPageContext(), 11009)) {
                                                        return;
                                                    }
                                                    i1a.s(this.a.getContext(), 3, this.a.S6(), this.a.C0);
                                                    return;
                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f091ba5 && view2.getId() != R.id.share_more_container) {
                                                    if (this.a.J0.j.i() == null || view2 != this.a.J0.j.i().E()) {
                                                        if (this.a.J0.j.i() == null || view2 != this.a.J0.j.i().L()) {
                                                            if (this.a.J0.j.i() != null && view2 == this.a.J0.j.i().K()) {
                                                                if (this.a.C0 != null && this.a.C0.s1() != null && this.a.C0.s1().R() != null) {
                                                                    this.a.J0.j.f();
                                                                    TiebaStatic.log(new StatisticItem("c13062"));
                                                                    PbFragment pbFragment = this.a;
                                                                    pbFragment.q7(pbFragment.C0.s1().R().getFirstPostId());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (this.a.J0.j.i() == null || view2 != this.a.J0.j.i().I()) {
                                                                if (this.a.J0.W0() != view2) {
                                                                    if (this.a.J0.j.i() == null || view2 != this.a.J0.j.i().A()) {
                                                                        if (this.a.J0.j.i() == null || view2 != this.a.J0.j.i().g()) {
                                                                            if (this.a.J0.j.i() == null || view2 != this.a.J0.j.i().z()) {
                                                                                if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f0923e4 && view2.getId() != R.id.obfuscated_res_0x7f091bb8 && view2.getId() != R.id.obfuscated_res_0x7f091a2f) {
                                                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091c23) {
                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091c21 && view2.getId() != R.id.obfuscated_res_0x7f091dee && view2.getId() != R.id.obfuscated_res_0x7f091bb2) {
                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091bb6) {
                                                                                                if (view2 != this.a.J0.U0()) {
                                                                                                    if (this.a.J0.j.i() != null && view2 == this.a.J0.j.i().J()) {
                                                                                                        this.a.J0.j.g();
                                                                                                        this.a.J0.k4(this.a.H2);
                                                                                                        return;
                                                                                                    } else if (this.a.J0.j.i() == null || view2 != this.a.J0.j.i().C()) {
                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f0908bb && view2.getId() != R.id.obfuscated_res_0x7f090bc6) {
                                                                                                            if (view2.getId() != R.id.pb_u9_text_view) {
                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f091fd7 && view2.getId() != R.id.cover_reply_content && view2.getId() != R.id.replybtn_top_right && view2.getId() != R.id.cover_reply_content_top_right) {
                                                                                                                    if (view2.getId() != R.id.pb_act_btn) {
                                                                                                                        if (view2.getId() != R.id.lottery_tail) {
                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091be6 && view2.getId() != R.id.obfuscated_res_0x7f091bad) {
                                                                                                                                if (view2.getId() != R.id.join_vote_tv) {
                                                                                                                                    if (view2.getId() != R.id.look_all_tv) {
                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f09179e) {
                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f09179d) {
                                                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f092851) {
                                                                                                                                                    if (view2.getId() == R.id.qq_share_container) {
                                                                                                                                                        if (!i1a.b(this.a.getPageContext(), 11009)) {
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        i1a.s(this.a.getContext(), 8, this.a.S6(), this.a.C0);
                                                                                                                                                        return;
                                                                                                                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f091a2f) {
                                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091ba2) {
                                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091c0d) {
                                                                                                                                                                if (view2.getId() != R.id.forum_name_text && view2.getId() != R.id.forum_enter_button_one && view2.getId() != R.id.forum_enter_button_two && view2.getId() != R.id.forum_enter_button_three) {
                                                                                                                                                                    if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                                                                                                                        x5a.I(2, this.a.C0);
                                                                                                                                                                        return;
                                                                                                                                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f091c35) {
                                                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091c4f) {
                                                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f09109c) {
                                                                                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f091099) {
                                                                                                                                                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091bba && view2.getId() != R.id.obfuscated_res_0x7f091c1b) {
                                                                                                                                                                                        if (view2.getId() == R.id.obfuscated_res_0x7f09237c) {
                                                                                                                                                                                            Object tag = view2.getTag();
                                                                                                                                                                                            if (tag instanceof SpriteMemeInfo) {
                                                                                                                                                                                                this.a.J0.E2((SpriteMemeInfo) tag);
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
                    if (nv4.c().g()) {
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
                boolean g = nv4.c().g();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.J0 != null && this.a.J0.G0() != null) {
                this.a.J0.G0().v();
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
                    if (this.a.Z0 != null) {
                        this.a.Z0.K(null, null);
                    }
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.J0 != null && this.a.J0.k1() != null && this.a.J0.k1().f() != null) {
                    this.a.J0.k1().f().J();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || this.a.C0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.C0.b)) {
                return;
            }
            this.a.b9((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes7.dex */
    public class w2 implements xg5 {
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

        @Override // com.baidu.tieba.xg5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                m1a m1aVar = this.a.N0;
                if (m1aVar != null && m1aVar.e() != null && this.a.N0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.N0.e().c());
                    if (this.a.Z0 != null && (this.a.Z0.B() || this.a.Z0.D())) {
                        this.a.Z0.z(false, this.a.N0.h());
                    }
                    this.a.N0.a(true);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof qy5.a)) {
                qy5.a aVar = (qy5.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.n7(aVar.b);
                }
                if (!StringUtils.isNull(aVar.e)) {
                    str = aVar.e;
                } else {
                    str = aVar.b;
                }
                qy5.c(this.a.getPageContext(), this.a, aVar.a, str, aVar.c);
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
                if (nv4.c().g()) {
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
                boolean g = nv4.c().g();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.g) {
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
            this.a.v = true;
        }
    }

    /* loaded from: classes7.dex */
    public class z0 implements px9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.px9.a
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

        @Override // com.baidu.tieba.px9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091ff8) {
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
                            if (nwaVar.getType() != nwa.c1 && !TextUtils.isEmpty(nwaVar.x()) && nv4.c().g()) {
                                return this.a.b8(nwaVar);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091bb7) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.g9((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.J0.e2() && view2.getId() == R.id.obfuscated_res_0x7f091bd9) {
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
                if (this.a.Z0 != null) {
                    this.a.J0.p3(this.a.Z0.C());
                }
                this.a.J0.h3();
                this.a.J0.s0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.px9.a
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
        U2 = new g1();
        V2 = new h();
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
            PbModel pbModel = this.C0;
            if (pbModel == null) {
                return false;
            }
            return k4a.d(pbModel.s1());
        }
        return invokeV.booleanValue;
    }

    public boolean C7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            PbModel pbModel = this.C0;
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
            AbsPbActivity absPbActivity = this.b;
            if (absPbActivity != null && absPbActivity.B1() != null && this.b.B1().r1() == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void D8() {
        sb5 sb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (sb5Var = this.r0) != null) {
            sb5Var.w();
        }
    }

    @Override // com.baidu.tieba.ty5
    public pb<TiebaPlusRecommendCard> F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.D == null) {
                this.D = new pb<>(new y2(this), 5, 0);
            }
            return this.D;
        }
        return (pb) invokeV.objValue;
    }

    public boolean F7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            PbModel pbModel = this.C0;
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
            return this.t0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ty5
    public pb<GifView> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.M == null) {
                this.M = new pb<>(new x2(this), 20, 0);
            }
            return this.M;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty5
    public pb<TextView> N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.z == null) {
                this.z = TbRichTextView.H(TbadkCoreApplication.getInst(), 8);
            }
            return this.z;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty5
    public pb<ItemCardView> P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (this.G == null) {
                this.G = new pb<>(new b3(this), 10, 0);
            }
            return this.G;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty5
    public pb<LinearLayout> Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (this.E == null) {
                this.E = new pb<>(new e(this), 15, 0);
            }
            return this.E;
        }
        return (pb) invokeV.objValue;
    }

    public AntiData R6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.s1() != null) {
                return this.C0.s1().f();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    public final void S7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            vv9 s12 = this.C0.s1();
            this.C0.g3(true);
            gr4 gr4Var = this.E0;
            if (gr4Var != null) {
                s12.M0(gr4Var.g());
            }
            this.J0.Y1(s12);
        }
    }

    public nwa T6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            vv9 vv9Var = this.C0.G;
            if (vv9Var != null) {
                return vv9Var.a0();
            }
            return null;
        }
        return (nwa) invokeV.objValue;
    }

    public int U6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.T2;
        }
        return invokeV.intValue;
    }

    public void U7() {
        j1a j1aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048645, this) != null) || (j1aVar = this.J0) == null) {
            return;
        }
        j1aVar.q2();
    }

    @Override // com.baidu.tieba.ty5
    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            j1a j1aVar = this.J0;
            if (j1aVar == null) {
                return 0;
            }
            return j1aVar.o1();
        }
        return invokeV.intValue;
    }

    public String V6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.N;
        }
        return (String) invokeV.objValue;
    }

    public PbInterviewStatusView.f X6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.y0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    public boolean Y6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            if (!this.d && this.P2 == -1 && this.Q2 == -1) {
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
            return this.q2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean a7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.L;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ty5
    /* renamed from: b7 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            j1a j1aVar = this.J0;
            if (j1aVar == null) {
                return null;
            }
            return j1aVar.Z0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public pb<TbImageView> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if (this.A == null) {
                this.A = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (pb) invokeV.objValue;
    }

    public int c7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.Q2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return this.j;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public int d7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.P2;
        }
        return invokeV.intValue;
    }

    public boolean e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.m2();
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public final vv9 e7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                return pbModel.s1();
            }
            return null;
        }
        return (vv9) invokeV.objValue;
    }

    public bh5 f7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.Z0;
        }
        return (bh5) invokeV.objValue;
    }

    public w2a g7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.f;
        }
        return (w2a) invokeV.objValue;
    }

    public void g8() {
        sb5 sb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048690, this) == null) && (sb5Var = this.r0) != null) {
            sb5Var.o();
        }
    }

    @Override // com.baidu.tieba.m4b
    @NonNull
    public String getTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return Integer.toString(this.a.getId());
        }
        return (String) invokeV.objValue;
    }

    public l3a h7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            return this.v0;
        }
        return (l3a) invokeV.objValue;
    }

    public j1a i7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            return this.J0;
        }
        return (j1a) invokeV.objValue;
    }

    public final void i9() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048702, this) == null) && (voiceManager = this.j) != null) {
            voiceManager.stopPlay();
        }
    }

    public final void j9() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048706, this) == null) && (absPbActivity = this.b) != null) {
            absPbActivity.Q1();
        }
    }

    public String k7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            return this.W;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d6a
    public PbModel l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            return this.C0;
        }
        return (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty5
    public pb<RelativeLayout> n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) {
            pb<RelativeLayout> pbVar = new pb<>(new a3(this), 10, 0);
            this.F = pbVar;
            return pbVar;
        }
        return (pb) invokeV.objValue;
    }

    public v2a o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            return this.b.o1();
        }
        return (v2a) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.e0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ti onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048743, this) == null) {
            y8();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tieba.ty5
    public pb<FestivalTipView> q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            if (this.I == null) {
                this.I = TbRichTextView.G(getContext(), R.dimen.M_H_X004);
            }
            return this.I;
        }
        return (pb) invokeV.objValue;
    }

    public void q8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            r8(null);
        }
    }

    @Override // com.baidu.tieba.ty5
    public pb<ImageView> r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) {
            if (this.B == null) {
                this.B = new pb<>(new v2(this), 8, 0);
            }
            return this.B;
        }
        return (pb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ty5
    public pb<View> t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048770, this)) == null) {
            if (this.C == null) {
                this.C = new pb<>(new z2(this), 8, 0);
            }
            return this.C;
        }
        return (pb) invokeV.objValue;
    }

    public boolean t8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048773, this)) == null) {
            sb5 sb5Var = this.r0;
            if (sb5Var != null && sb5Var.r()) {
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
        if ((interceptable == null || interceptable.invokeV(1048776, this) == null) && (pbModel = this.C0) != null && !rd.isEmpty(pbModel.M1())) {
            super.taskStart();
        }
    }

    @Override // com.baidu.tieba.d6a
    public AbsPbActivity u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048777, this)) == null) {
            return this.b;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public void u7() {
        j1a j1aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048779, this) == null) && (j1aVar = this.J0) != null) {
            j1aVar.z1();
            t7();
        }
    }

    @Override // com.baidu.tieba.d6a
    public PbModel.h v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048782, this)) == null) {
            return this.t2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public final void w7() {
        CheckRealNameModel M0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048790, this) == null) {
            this.X1 = new j3(this.J0, this);
            PbModel pbModel = this.C0;
            if (pbModel == null || (M0 = pbModel.M0()) == null) {
                return;
            }
            M0.S(this.X1);
        }
    }

    public final void y7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048797, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.R = likeModel;
            likeModel.setLoadDataCallBack(new x0(this));
        }
    }

    public final void y8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048798, this) == null) {
            hideNetRefreshView(this.J0.u1());
            X8();
            if (this.C0.u2()) {
                this.J0.J3();
            }
            this.J0.U3();
        }
    }

    public final void z7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048801, this) == null) {
            n4a n4aVar = new n4a(getPageContext());
            n4aVar.m();
            this.c1 = n4aVar;
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
        this.u0 = new z(this);
        this.x0 = false;
        this.y0 = new k0(this);
        this.z0 = new Handler(new v0(this));
        this.A0 = new r1(this);
        this.B0 = new c2(this);
        this.C0 = null;
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
        this.y1 = new q(this);
        this.z1 = new r(this, 2004016);
        this.A1 = new s(this, 2016485);
        this.B1 = new t(this, 2001269);
        this.C1 = new u(this, 2004008);
        this.D1 = new v(this, 2004007);
        this.E1 = new w(this, 2004005);
        this.F1 = new x(this, 2001332);
        this.G1 = new y(this, 2921391);
        this.H1 = new a0(this, 2921606);
        this.I1 = new b0(this, 2921658);
        this.J1 = new c0(this);
        this.K1 = new d0(this, 2001369);
        this.L1 = new e0(this, 2921787);
        this.M1 = new f0(this, 2016488);
        this.N1 = new g0(this, 2016331);
        this.O1 = new h0(this, 2921746);
        this.P1 = new i0(this);
        this.Q1 = new j0(this, 2010045);
        this.R1 = new l0(this);
        this.S1 = new PraiseModel(getPageContext(), new m0(this));
        this.T1 = new n0(this);
        this.U1 = new p0(this, 2001115);
        this.V1 = new q0(this);
        this.W1 = new r0(this);
        this.Y1 = new px9(new z0(this));
        this.Z1 = new b1(this);
        this.a2 = new c1(this, 2001427);
        this.b2 = new d1(this, 2001428);
        this.c2 = new e1(this, 2921634);
        this.d2 = new f1(this, 2001426);
        this.e2 = new h1(this, 2004021);
        this.f2 = new i1(this, 2016528);
        this.h2 = new j1(this, 2921724);
        this.i2 = new k1(this, 2921033);
        this.j2 = new l1(this);
        this.k2 = new m1(this);
        this.l2 = new n1(this);
        this.m2 = new q1(this);
        this.n2 = new v1(this);
        this.o2 = new w1(this, 2921480);
        this.p2 = new x1(this);
        this.q2 = Boolean.FALSE;
        this.r2 = new a2(this);
        this.s2 = new b2(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.t2 = new d2(this);
        this.u2 = new e2(this, 2016450);
        this.v2 = new f2(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.w2 = new g2(this);
        this.x2 = new h2(this);
        this.y2 = new k2(this);
        this.z2 = new n2(this);
        this.A2 = new o2(this);
        this.C2 = new p2(this);
        this.D2 = new c3(this);
        this.E2 = null;
        this.F2 = new d3(this);
        this.G2 = new e3(this);
        this.H2 = new f3(this);
        this.I2 = new a(this);
        this.J2 = new b(this);
        this.K2 = new c(this);
        this.L2 = new d(this);
        this.M2 = new f(this);
        this.N2 = new g(this);
        this.O2 = new i(this);
        this.P2 = -1;
        this.Q2 = -1;
        this.T2 = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e3, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0159, code lost:
        if ((r7.e1.a.getView().getTop() - r11.J0.j.a.getBottom()) < (r11.J0.e1.a.g.getHeight() + 10)) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I6() {
        PbModel pbModel;
        int top;
        boolean z3;
        boolean z4;
        j1a.v0 v0Var;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        z4a z4aVar;
        PbReplyTitleViewHolder pbReplyTitleViewHolder2;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.J0.Z0() != null && (pbModel = this.C0) != null && pbModel.s1() != null) {
            int firstVisiblePosition = this.J0.Z0().getFirstVisiblePosition();
            int i4 = 0;
            View childAt = this.J0.Z0().getChildAt(0);
            if (childAt == null) {
                top = 0;
            } else {
                top = childAt.getTop();
            }
            boolean y02 = this.C0.s1().y0();
            boolean j22 = this.J0.j2();
            if (firstVisiblePosition == 0 && top == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            i1a.c(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.C0.s1());
            if ((this.C0.s1().R() != null && this.C0.s1().R().getReply_num() <= 0) || (j22 && z3)) {
                x5a.N(1, 1);
                if (!checkUpIsLogin()) {
                    x5a.N(2, 1);
                    return;
                }
                q8();
                if (this.C0.s1().R().getAuthor() != null) {
                    x5a.x(2, this.C0);
                }
            } else {
                int equipmentHeight = (int) (BdUtilHelper.getEquipmentHeight(getContext()) * 0.6d);
                if (y02) {
                    j1a.v0 v0Var2 = this.J0.e1;
                    if (v0Var2 != null) {
                        PbReplyTitleViewHolder pbReplyTitleViewHolder3 = v0Var2.a;
                        if (pbReplyTitleViewHolder3 != null && pbReplyTitleViewHolder3.getView() != null) {
                            if (this.J0.e1.a.getView().getParent() != null) {
                            }
                        }
                    }
                    z4 = false;
                } else {
                    if (this.J0.i1() != null) {
                        if (this.J0.i1().getVisibility() == 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z4 && (v0Var = this.J0.e1) != null && (pbReplyTitleViewHolder = v0Var.a) != null && pbReplyTitleViewHolder.getView() != null && this.J0.e1.a.getView().getParent() != null && (z4aVar = (r7 = this.J0).j) != null && z4aVar.a != null) {
                        }
                    }
                    z4 = false;
                }
                if (!z4 && !j22) {
                    if (this.b0 > 0) {
                        if (this.J0.Z0().getChildAt(this.b0) != null) {
                            this.J0.Z0().D(this.b0, this.c0, 200);
                        } else {
                            this.J0.Z0().setSelectionFromTop(this.b0, this.c0 + equipmentHeight);
                            this.J0.Z0().smoothScrollBy(equipmentHeight, 500);
                        }
                    } else {
                        int d4 = p2a.d(getListView());
                        if (p2a.e(getListView()) != -1) {
                            d4--;
                        }
                        int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds100);
                        if (d4 < 0) {
                            d4 = (ListUtils.getCount(this.J0.Z0().getData()) - 1) + this.J0.Z0().getHeaderViewsCount();
                        } else {
                            i4 = dimens;
                        }
                        z4a z4aVar2 = this.J0.j;
                        if (z4aVar2 != null && (navigationBar = z4aVar2.a) != null) {
                            i4 += navigationBar.getFixedNavHeight() - 10;
                        }
                        j1a.v0 v0Var3 = this.J0.e1;
                        if (v0Var3 != null && (pbReplyTitleViewHolder2 = v0Var3.a) != null && pbReplyTitleViewHolder2.getView() != null && this.J0.e1.a.getView().getParent() != null) {
                            this.J0.Z0().D(d4, i4, 200);
                        } else {
                            this.J0.Z0().setSelectionFromTop(d4, i4 + equipmentHeight);
                            this.J0.Z0().smoothScrollBy(equipmentHeight, 500);
                        }
                    }
                } else {
                    this.b0 = firstVisiblePosition;
                    this.c0 = top;
                    if (firstVisiblePosition <= 3 && (firstVisiblePosition != 3 || top >= (-equipmentHeight))) {
                        this.J0.Z0().D(0, 0, 500);
                    } else {
                        int i5 = -equipmentHeight;
                        this.J0.Z0().setSelectionFromTop(0, i5);
                        this.J0.Z0().smoothScrollBy(i5, 500);
                    }
                }
            }
            if (this.C0.s1().R() != null && this.C0.s1().R().getAuthor() != null) {
                x5a.x(2, this.C0);
            }
        }
    }

    @Override // com.baidu.tieba.d6a
    public void finish() {
        j1a j1aVar;
        boolean z3;
        CardHListViewData s3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            j1a j1aVar2 = this.J0;
            if (j1aVar2 != null) {
                j1aVar2.s0();
            }
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.s1() != null && !this.C0.s1().a()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.C0.s1().R().getId();
                if (this.C0.isShareThread() && this.C0.s1().R().originalThreadData != null) {
                    historyMessage.threadName = this.C0.s1().R().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.C0.s1().R().getTitle();
                }
                if (this.C0.isShareThread() && !e1()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.C0.s1().n().getName();
                }
                ArrayList<nwa> I = this.C0.s1().I();
                j1a j1aVar3 = this.J0;
                if (j1aVar3 != null) {
                    i4 = j1aVar3.Q0();
                } else {
                    i4 = 0;
                }
                if (I != null && i4 >= 0 && i4 < I.size()) {
                    historyMessage.postID = I.get(i4).U();
                }
                historyMessage.isHostOnly = this.C0.V0();
                historyMessage.isSquence = this.C0.L1();
                historyMessage.isShareThread = this.C0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            if (this.W0) {
                xq6.b().c(new oh5(this.C0.M1()));
            }
            PbModel pbModel2 = this.C0;
            if (pbModel2 != null && (pbModel2.X0() || this.C0.a1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.C0.M1());
                if (this.K0) {
                    if (this.M0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.C0.g1());
                    }
                    if (this.L0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.C0.c1());
                    }
                }
                if (this.C0.a1() && this.C0.s1() != null && this.C0.s1().R() != null) {
                    xq6.b().c(new ph5(this.C0.R()));
                }
                if (this.C0.s1() != null && System.currentTimeMillis() - this.o >= 40000 && (s3 = this.C0.s1().s()) != null && !ListUtils.isEmpty(s3.getDataList())) {
                    intent.putExtra("guess_like_data", s3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.t1);
                }
                this.b.setResult(-1, intent);
            }
            if (k9()) {
                if (this.C0 != null && (j1aVar = this.J0) != null && j1aVar.Z0() != null) {
                    vv9 s12 = this.C0.s1();
                    if (s12 != null) {
                        if (s12.Y() != null) {
                            s12.Y().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            s12.Y().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!s12.t0() && !this.J && s12.h == null) {
                            a1a b4 = a1a.b();
                            vv9 t12 = this.C0.t1();
                            Parcelable onSaveInstanceState = this.J0.Z0().onSaveInstanceState();
                            boolean L1 = this.C0.L1();
                            boolean V0 = this.C0.V0();
                            if (this.J0.i1() != null && this.J0.i1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.l(t12, onSaveInstanceState, L1, V0, z3);
                            if (this.s1 >= 0 || this.C0.O1() != null) {
                                a1a.b().o(this.C0.O1());
                                a1a.b().p(this.C0.P1());
                                a1a.b().m(this.C0.l1());
                            }
                        }
                    }
                } else {
                    a1a.b().k();
                }
                j9();
            }
            if (this.c1 != null && !PushGuideManager.d() && t6() && this.C0.a1() && !TextUtils.isEmpty(this.C0.R())) {
                this.c1.n(this.C0.s1().j().l, this.C0.R());
            }
        }
    }

    @Override // com.baidu.tieba.ty5
    public void J0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) {
            this.v = true;
        }
    }

    @Override // com.baidu.tieba.ty5
    public void d0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048676, this, context, str) == null) {
            p1a.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.v = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        j1a j1aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048742, this, i4, keyEvent)) == null) {
            if (keyEvent != null && (j1aVar = this.J0) != null) {
                return j1aVar.y2(i4);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void H8(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i4) == null) && this.C0 != null) {
            X8();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i4);
            privacySettingMessage.setTid(this.C0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void I8(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i4) == null) {
            this.T2 = i4;
        }
    }

    public void J8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z3) == null) {
            this.q2 = Boolean.valueOf(z3);
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
            this.t0 = z3;
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
            this.O = z3;
        }
    }

    public void O8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z3) == null) {
            this.L = z3;
        }
    }

    public final void P8(boolean z3) {
        bh5 bh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048630, this, z3) != null) || (bh5Var = this.Z0) == null) {
            return;
        }
        bh5Var.b0(z3);
        this.Z0.e0(z3);
        this.Z0.m0(z3);
    }

    public void T8(View view2) {
        vv9 e7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048643, this, view2) == null) && (e7 = e7()) != null) {
            f4a.d(getContext(), view2, e7);
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
        yfa j4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048661, this, extra) == null) && (j4 = PushGuideManager.j("reply_pb")) != null && !this.J0.R2()) {
            j4.e(extra);
            j4.k(getPageContext(), new y1(this, j4));
        }
    }

    public final void Z8(@Nullable ThreadData threadData) {
        yfa j4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048664, this, threadData) == null) && (j4 = PushGuideManager.j("collect")) != null && !this.J0.R2()) {
            j4.e(threadData);
            j4.k(getPageContext(), new z1(this, j4));
        }
    }

    @Override // com.baidu.tieba.m6a.b
    public void c2(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z3) == null) {
            this.S0 = z3;
        }
    }

    public final void c9(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048675, this, i4) == null) {
            o4a.i(this, S6(), i4);
        }
    }

    public void i6(i3 i3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048699, this, i3Var) == null) && i3Var != null) {
            if (this.u1 == null) {
                this.u1 = new ArrayList();
            }
            if (!this.u1.contains(i3Var)) {
                this.u1.add(i3Var);
            }
        }
    }

    public void j6(i3 i3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048703, this, i3Var) == null) && i3Var != null) {
            if (this.u1 == null) {
                this.u1 = new ArrayList();
            }
            if (!this.u1.contains(i3Var)) {
                this.u1.add(0, i3Var);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048733, this, context) == null) {
            super.onAttach(context);
            this.b = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tieba.c05.e
    public void onClick(c05 c05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, c05Var) == null) {
            E6(c05Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.z4
    public void onPreLoad(ti tiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048745, this, tiVar) == null) {
            PreLoadImageHelper.load(tiVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(tiVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.C0.M2(bundle);
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            bh5 bh5Var = this.Z0;
            if (bh5Var != null) {
                bh5Var.J(bundle);
            }
        }
    }

    public final void r7(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048763, this, intent) == null) {
            o4a.f(this, intent);
        }
    }

    public final void t9(zw4 zw4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048774, this, zw4Var) == null) && zw4Var != null) {
            this.S2 = zw4Var;
            this.d = true;
            this.J0.f3();
            this.J0.x3(this.R2);
        }
    }

    public void z8(i3 i3Var) {
        List<i3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048802, this, i3Var) == null) && i3Var != null && (list = this.u1) != null) {
            list.remove(i3Var);
        }
    }

    public void A6(ForumManageModel.b bVar, j1a j1aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, j1aVar) == null) {
            List<nwa> list = this.C0.s1().W().a;
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
                j1aVar.Y1(this.C0.s1());
            }
        }
    }

    public final void A7() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.l != null) {
            return;
        }
        this.l = new d05(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        d05 d05Var = this.l;
        d05Var.j(strArr, new a1(this));
        d05Var.g(d05.b.a);
        d05Var.h(17);
        d05Var.c(getPageContext());
    }

    public final void a8() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048666, this) != null) || jt5.a()) {
            return;
        }
        PbModel pbModel = this.C0;
        if (pbModel != null && pbModel.s1() != null) {
            ArrayList<nwa> I = this.C0.s1().I();
            if ((I == null || I.size() <= 0) && this.C0.L1()) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1035));
                return;
            }
            x5a.F(this.C0);
            this.J0.h3();
            f8();
            return;
        }
        BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1035));
    }

    public final void p8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048754, this) == null) {
            if (this.J0.W0().getIndicateStatus()) {
                vv9 s12 = this.C0.s1();
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
        if ((interceptable == null || interceptable.invokeV(1048785, this) == null) && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            long j4 = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
            sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(getPageContext().getPageActivity(), 24008, JavaTypesHelper.toLong(this.C0.s1().o(), 0L), JavaTypesHelper.toLong(this.C0.M1(), 0L), j4, this.C0.s1().R().getPushStatusData())));
        }
    }

    public final void A8(View view2) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            this.J0.s0();
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.i) {
                view2.setTag(Integer.valueOf(this.C0.J1()));
            } else {
                i9();
                this.J0.J3();
                k05 k05Var = new k05(getPageContext());
                if (this.C0.s1().f == null || this.C0.s1().f.size() <= 0) {
                    strArr = new String[]{getResources().getString(R.string.sort_type_new), getResources().getString(R.string.sort_type_old)};
                } else {
                    strArr = new String[this.C0.s1().f.size()];
                    for (int i4 = 0; i4 < this.C0.s1().f.size(); i4++) {
                        strArr[i4] = this.C0.s1().f.get(i4).sort_name + getResources().getString(R.string.sort_static);
                    }
                }
                k05Var.i(null, strArr, new u1(this, k05Var, view2));
                k05Var.l();
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
            if (nwaVar.getType() != nwa.c1 && !TextUtils.isEmpty(nwaVar.x()) && nv4.c().g()) {
                return b8(nwaVar);
            }
            if (!checkUpIsLogin()) {
                x5a.N(2, 2);
                return true;
            }
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.s1() != null) {
                if (i7().k1() != null) {
                    i7().k1().g();
                }
                lw9 lw9Var = new lw9();
                lw9Var.v(this.C0.s1().n());
                lw9Var.z(this.C0.s1().R());
                lw9Var.x(nwaVar);
                i7().j1().k0(lw9Var);
                i7().j1().setPostId(nwaVar.U());
                Q7(view2, nwaVar.u().getUserId(), "", nwaVar);
                TiebaStatic.log("c11743");
                bh5 bh5Var = this.Z0;
                if (bh5Var != null) {
                    this.J0.p3(bh5Var.C());
                }
                return true;
            }
            x5a.N(20, 2);
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
            this.J0.s0();
            if (view2.getId() == R.id.obfuscated_res_0x7f091ba0 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                this.V = view2;
            } else if (!i1a.b(getPageContext(), 11009) || this.C0.I0(this.J0.Y0()) == null) {
            } else {
                V7();
                if (this.C0.s1() != null && this.C0.s1().R() != null && this.C0.s1().R().getAuthor() != null) {
                    x5a.x(3, this.C0);
                }
                if (this.C0.s1().R() != null && this.C0.s1().R().getAuthor() != null && this.C0.s1().R().getAuthor().getUserId() != null && this.E0 != null) {
                    x5a.E(1, i1a.r(this.C0.s1()), !this.E0.e(), this.C0);
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
            } else if (this.C0.s1() == null || this.F0.h0()) {
            } else {
                this.J0.s0();
                if (this.J0.j.i() != null && view2 == this.J0.j.i().H()) {
                    if (this.C0.s1().R().getIs_top() == 1) {
                        i4 = 5;
                    } else {
                        i4 = 4;
                    }
                } else if (this.J0.j.i() != null && view2 == this.J0.j.i().G()) {
                    if (this.C0.s1().R().getIs_good() == 1) {
                        i4 = 3;
                    } else {
                        i4 = 6;
                    }
                } else if (view2 == this.J0.K0()) {
                    i4 = 2;
                } else {
                    i4 = 0;
                }
                ForumData n3 = this.C0.s1().n();
                String name = n3.getName();
                String id = n3.getId();
                String id2 = this.C0.s1().R().getId();
                this.J0.x4();
                this.F0.l0(id, name, id2, i4, this.J0.L0());
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
        j1a j1aVar;
        int i4;
        int m3;
        nwa nwaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048757, this, z3) == null) && (j1aVar = this.J0) != null && j1aVar.Z0() != null) {
            int firstVisiblePosition = this.J0.Z0().getFirstVisiblePosition();
            int lastVisiblePosition = this.J0.Z0().getLastVisiblePosition();
            qz9 G0 = this.J0.G0();
            if (G0 != null && this.C0.s1() != null) {
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
                        if (this.J0.Z0().G(i4) != null && (this.J0.Z0().G(i4) instanceof nwa) && (nwaVar = (nwa) this.J0.Z0().G(i4)) != null) {
                            nwa nwaVar2 = (nwa) ListUtils.getItem(this.C0.s1().I(), nwaVar.L() - 1);
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
                            this.J0.S2(adverSegmentData, 0);
                            return;
                        }
                        return;
                    }
                    this.J0.S2(adverSegmentData, 1);
                }
            }
        }
    }

    public final AbsPbActivity.e s8(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048768, this, str)) == null) {
            String str2 = null;
            if (this.C0.s1() != null && this.C0.s1().I() != null && this.C0.s1().I().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i4 = 0;
                while (true) {
                    if (i4 < this.C0.s1().I().size()) {
                        if (str.equals(this.C0.s1().I().get(i4).U())) {
                            break;
                        }
                        i4++;
                    } else {
                        i4 = 0;
                        break;
                    }
                }
                nwa nwaVar = this.C0.s1().I().get(i4);
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
                    y0a.e(this.C0, str2, 0, eVar);
                    wv9.c(nwaVar, eVar);
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
        if ((interceptable != null && interceptable.invokeI(1048781, this, i4) != null) || (pbModel = this.C0) == null || pbModel.s1() == null || (R = this.C0.s1().R()) == null) {
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
        if (this.C0.L1()) {
            this.J0.G0().v();
        } else {
            this.J0.I4(this.C0.s1());
        }
    }

    public void x8(lw9 lw9Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048795, this, lw9Var) != null) || lw9Var.i() == null) {
            return;
        }
        String U = lw9Var.i().U();
        ArrayList<nwa> I = this.C0.s1().I();
        int i4 = 0;
        while (true) {
            z3 = true;
            if (i4 >= I.size()) {
                break;
            }
            nwa nwaVar = I.get(i4);
            if (nwaVar.U() != null && nwaVar.U().equals(U)) {
                ArrayList<nwa> k4 = lw9Var.k();
                nwaVar.u1(lw9Var.m());
                if (nwaVar.k0() != null && k4 != null) {
                    Iterator<nwa> it = k4.iterator();
                    while (it.hasNext()) {
                        nwa next = it.next();
                        if (nwaVar.t0() != null && next != null && next.u() != null && (metaData = nwaVar.t0().get(next.u().getUserId())) != null) {
                            next.T0(metaData);
                            next.j1(true);
                            next.E1(getPageContext(), this.C0.n2(metaData.getUserId()));
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
        if (!this.C0.b1() && z3) {
            this.J0.Y1(this.C0.s1());
        }
        if (z3) {
            v8(lw9Var);
        }
    }

    public final void B6(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.C0) != null && pbModel.s1() != null) {
            mwa C = this.C0.s1().C();
            if (C != null && str.equals(C.I1())) {
                if (C.getAdvertAppInfo() != null) {
                    C.getAdvertAppInfo().h = null;
                }
                this.C0.s1().d();
            }
            mwa K0 = this.C0.K0();
            if (K0 != null && str.equals(K0.I1())) {
                this.C0.y0();
            }
        }
    }

    public final void K6(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, view2) != null) || !(view2.getTag() instanceof ThreadData)) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        if (this.C0.r1() == 3 && e1() && this.C0.s1() != null && ListUtils.isEmpty(this.C0.s1().r())) {
            this.b.finish();
        } else {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
        x5a.z(threadData);
    }

    public void X7(nwa nwaVar) {
        boolean z3;
        nwa T6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048656, this, nwaVar) != null) || nwaVar == null) {
            return;
        }
        if (nwaVar.U() != null && nwaVar.U().equals(this.C0.n1())) {
            z3 = true;
        } else {
            z3 = false;
        }
        MarkData m12 = this.C0.m1(nwaVar);
        if (this.C0.s1() != null && this.C0.s1().a() && (T6 = T6()) != null) {
            m12 = this.C0.m1(T6);
        }
        if (m12 == null) {
            return;
        }
        this.J0.J3();
        gr4 gr4Var = this.E0;
        if (gr4Var != null) {
            gr4Var.i(m12);
            if (!z3) {
                this.E0.a();
            } else {
                this.E0.d();
            }
        }
    }

    public final void b9(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && l0() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                l0().B0(postWriteCallBackData.getPostId());
                int M0 = this.J0.M0();
                this.s1 = M0;
                this.C0.P2(M0, this.J0.T0());
            }
            this.J0.s0();
            this.N0.c();
            bh5 bh5Var = this.Z0;
            if (bh5Var != null) {
                this.J0.p3(bh5Var.C());
            }
            this.J0.z1();
            this.J0.X3(true);
            this.C0.X1();
        }
    }

    public final void l9(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048716, this, view2) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
            String string2 = SharedPrefHelper.getInstance().getString("tail_link", "");
            String string3 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
            if (!StringUtils.isNull(string2)) {
                TiebaStatic.log("c10056");
                Context context = view2.getContext();
                BrowserHelper.startWebActivity(context, string, UtilHelper.urlAddParam(string2, "page_from=1&tailSkinId=" + string3), true, true, true);
            }
            this.J0.h3();
            TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string3));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        vv9 s12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (i7() != null && i1a.z(this)) {
                i7().w4();
            }
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907f7));
            PbModel pbModel = this.C0;
            if (pbModel != null && (s12 = pbModel.s1()) != null) {
                this.t2.c(true, 0, 3, 0, s12, "", 1, true);
            }
            this.b.E1().j(this.u0);
            PbModel pbModel2 = this.C0;
            if (pbModel2 != null) {
                this.H.b(pbModel2.G, getContext(), this.b.findViewById(this.J0.H0()), this.C0.getForumId(), this.C0.M1());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048734, this, i4) != null) || this.X == i4) {
            return;
        }
        super.onChangeSkinType(i4);
        this.J0.u2(i4);
        bh5 bh5Var = this.Z0;
        if (bh5Var != null && bh5Var.a() != null) {
            this.Z0.a().F(i4);
        }
        if (this.J0.a() != null) {
            this.J0.a().onChangeSkinType(getPageContext(), i4);
        }
        this.N0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i4, getResources(), R.color.CAM_X0201), true);
        this.X = i4;
        i9();
        sb5 sb5Var = this.r0;
        if (sb5Var != null) {
            sb5Var.u();
        }
    }

    public final void q7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, str) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.s1() != null && this.C0.s1().a()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.C0.M1(), str);
                ThreadData R = this.C0.s1().R();
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
            this.D0.a(str);
        }
    }

    public void r8(@Nullable SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048764, this, spriteMemeInfo) == null) {
            if (!checkUpIsLogin()) {
                x5a.N(2, 1);
                return;
            }
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.s1() != null && this.C0.s1().n() != null) {
                if (r6()) {
                    x5a.N(3, 1);
                    return;
                } else if (this.C0.s1().a()) {
                    x5a.N(7, 1);
                    this.J0.j0(spriteMemeInfo);
                    return;
                } else {
                    bh5 bh5Var = this.Z0;
                    if (bh5Var != null && bh5Var.a() != null) {
                        this.Z0.a().K(new ee5(45, 27, null));
                    }
                    this.J0.j0(spriteMemeInfo);
                    return;
                }
            }
            x5a.N(20, 1);
        }
    }

    public void v8(lw9 lw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048786, this, lw9Var) == null) {
            String U = lw9Var.i().U();
            List<nwa> list = this.C0.s1().W().a;
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                nwa nwaVar = list.get(i4);
                if (nwaVar.U() != null && nwaVar.U().equals(U)) {
                    ArrayList<nwa> k4 = lw9Var.k();
                    nwaVar.u1(lw9Var.m());
                    if (nwaVar.k0() != null) {
                        nwaVar.k0().clear();
                        nwaVar.k0().addAll(k4);
                    }
                } else {
                    i4++;
                }
            }
            if (!this.C0.b1()) {
                this.J0.Y1(this.C0.s1());
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
            this.J0.s0();
            if (this.J0.j.i() != null && view2 == this.J0.j.i().D()) {
                this.J0.h3();
            }
            if (this.i) {
                view2.setTag(Boolean.FALSE);
                return;
            }
            i9();
            this.J0.J3();
            if (view2.getId() == R.id.obfuscated_res_0x7f090bca) {
                i32 = this.C0.j3(true, W6());
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091fd2) {
                i32 = this.C0.j3(false, W6());
            } else {
                i32 = this.C0.i3(W6());
            }
            view2.setTag(Boolean.valueOf(i32));
            if (i32) {
                this.J0.u3(true);
                this.J0.m4();
                this.i = true;
                this.J0.y3(true);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
        }
    }

    public final void R7(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, view2) == null) && (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String)) {
            String string = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
            TiebaStatic.log(new StatisticItem("c10912").param("fid", this.C0.s1().o()).param("tid", this.C0.s1().T()).param("lotterytail", StringUtils.string(string, "_", TbadkCoreApplication.getCurrentAccount())));
            if (this.C0.s1().T().equals(string)) {
                this.J0.N3(0);
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
        if ((interceptable == null || interceptable.invokeL(1048719, this, view2) == null) && (sparseArray = (SparseArray) view2.getTag()) != null && (sparseArray.get(R.id.tag_load_sub_data) instanceof nwa)) {
            nwa nwaVar = (nwa) sparseArray.get(R.id.tag_load_sub_data);
            View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
            if (nwaVar != null && view3 != null) {
                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0908bc);
                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f0908bd);
                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090bc6);
                boolean z3 = false;
                if (nwaVar.G0()) {
                    nwaVar.m1(false);
                    l4a.e(nwaVar);
                } else {
                    if (l0() != null) {
                        z3 = l4a.c(l0().s1(), nwaVar);
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
        to5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048789, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.f0 == null) {
            this.f0 = new r45();
        }
        if (this.j0 == null) {
            AgreeMessageData agreeMessageData = new AgreeMessageData();
            this.j0 = agreeMessageData;
            agreeMessageData.uniqueId = getUniqueId();
        }
        iw4 iw4Var = new iw4();
        iw4Var.b = 5;
        iw4Var.h = 8;
        iw4Var.g = 2;
        if (l0() != null) {
            iw4Var.f = l0().r1();
        }
        iw4Var.a = 2;
        int i4 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                iw4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.f0.c(agreeData, i4, getUniqueId(), false);
                this.f0.d(agreeData, this.j0);
                pbModel = this.C0;
                if (pbModel == null && pbModel.s1() != null) {
                    this.f0.b(u0(), iw4Var, agreeData, this.C0.s1().R());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            iw4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            iw4Var.i = 1;
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

    public final void C6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.s1() != null) {
                mwa C = this.C0.s1().C();
                if (C != null) {
                    if (C.getAdvertAppInfo() != null) {
                        C.getAdvertAppInfo().h = null;
                    }
                    this.C0.s1().d();
                }
                if (this.C0.K0() != null) {
                    this.C0.y0();
                }
                this.C0.X1();
            }
            if (this.C0.s1().I() != null) {
                Iterator<nwa> it = this.C0.s1().I().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof mwa) {
                        it.remove();
                    }
                }
            }
            if (this.J0.G0() != null && !ListUtils.isEmpty(this.J0.G0().l())) {
                y3a.b(this.J0.G0().l());
            }
            if (this.J0.Z0() != null && !ListUtils.isEmpty(this.J0.Z0().getData())) {
                y3a.b(this.J0.Z0().getData());
            }
            if (this.J0.G0() != null) {
                this.J0.G0().v();
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
            this.J0.s0();
            SparseArray<Object> a12 = this.J0.a1(this.C0.s1(), this.C0.L1(), 1);
            if (a12 == null) {
                return;
            }
            sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(getPageContext().getPageActivity(), this.C0.s1().n().getId(), this.C0.s1().n().getName(), this.C0.s1().R().getId(), StringUtils.string(this.C0.s1().Y().getUserId()), StringUtils.string(a12.get(R.id.tag_forbid_user_name)), StringUtils.string(a12.get(R.id.tag_forbid_user_name_show)), StringUtils.string(a12.get(R.id.tag_forbid_user_post_id)), StringUtils.string(a12.get(R.id.tag_forbid_user_portrait)))));
        }
    }

    public final String W6() {
        InterceptResult invokeV;
        ArrayList<nwa> I;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel == null || pbModel.s1() == null || this.C0.s1().I() == null || (count = ListUtils.getCount((I = this.C0.s1().I()))) == 0) {
                return "";
            }
            if (this.C0.E1()) {
                Iterator<nwa> it = I.iterator();
                while (it.hasNext()) {
                    nwa next = it.next();
                    if (next != null && next.L() == 1) {
                        return next.U();
                    }
                }
            }
            int Q0 = this.J0.Q0();
            nwa nwaVar = (nwa) ListUtils.getItem(I, Q0);
            if (nwaVar != null && nwaVar.u() != null) {
                if (this.C0.n2(nwaVar.u().getUserId())) {
                    return nwaVar.U();
                }
                for (int i4 = Q0 - 1; i4 != 0; i4--) {
                    nwa nwaVar2 = (nwa) ListUtils.getItem(I, i4);
                    if (nwaVar2 == null || nwaVar2.u() == null || nwaVar2.u().getUserId() == null) {
                        break;
                    } else if (this.C0.n2(nwaVar2.u().getUserId())) {
                        return nwaVar2.U();
                    }
                }
                for (int i5 = Q0 + 1; i5 < count; i5++) {
                    nwa nwaVar3 = (nwa) ListUtils.getItem(I, i5);
                    if (nwaVar3 == null || nwaVar3.u() == null || nwaVar3.u().getUserId() == null) {
                        break;
                    } else if (this.C0.n2(nwaVar3.u().getUserId())) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.s1() != null && this.C0.s1().a()) {
                return true;
            }
            if (this.C0.d1()) {
                MarkData O0 = this.C0.O0();
                if (O0 == null || !this.C0.b1()) {
                    return true;
                }
                MarkData I0 = this.C0.I0(this.J0.Q0());
                if (I0 == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", O0);
                    this.b.setResult(-1, intent);
                    return true;
                } else if (I0.getPostId() != null && !I0.getPostId().equals(O0.getPostId())) {
                    c05 c05Var = new c05(getPageContext().getPageActivity());
                    c05Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f02a4));
                    c05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04d2, new s2(this, I0, O0, c05Var));
                    c05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new t2(this, O0, c05Var));
                    c05Var.setOnCalcelListener(new u2(this, O0, c05Var));
                    c05Var.create(getPageContext());
                    c05Var.show();
                    return false;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", O0);
                    this.b.setResult(-1, intent2);
                    return true;
                }
            }
            if (this.C0.s1() != null && this.C0.s1().I() != null && this.C0.s1().I().size() > 0 && this.C0.b1()) {
                this.b.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void l7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            if (this.g) {
                this.P = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.C0.s1() != null && this.C0.s1().R() != null && this.C0.s1().R().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.C0.s1().R().getTaskInfoData().k(), this.C0.s1().R().getTaskInfoData().h(), this.C0.s1().R().getTaskInfoData().c(), this.C0.s1().R().getTaskInfoData().d(), this.C0.s1().R().getIs_top(), this.C0.s1().R().getIs_good())));
                this.b.finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            this.g = false;
            super.onResume();
            if (this.P) {
                this.P = false;
                l7();
            }
            if (E7()) {
                this.u = System.currentTimeMillis();
            } else {
                this.u = -1L;
            }
            j1a j1aVar = this.J0;
            if (j1aVar != null && j1aVar.u1() != null) {
                if (!this.h) {
                    X8();
                } else {
                    hideLoadingView(this.J0.u1());
                }
                this.J0.F2();
            }
            if (this.k == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            j1a j1aVar2 = this.J0;
            if (j1aVar2 != null) {
                noNetworkView = j1aVar2.a();
            }
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.update(false);
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.F1);
            this.S0 = false;
            G8();
            registerListener(this.a2);
            registerListener(this.b2);
            registerListener(this.d2);
            PushPermissionController pushPermissionController = this.w0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.r1) {
                y8();
                this.r1 = false;
            }
            f9();
            ItemCardHelper.w(this.K2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                qd5.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048749, this) == null) {
            super.onStop();
            if (this.u > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.u;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.u = 0L;
            }
            if (i7().k1() != null) {
                i7().k1().n();
            }
            z4a z4aVar = this.J0.j;
            if (z4aVar != null && !z4aVar.n()) {
                this.J0.j.r();
            }
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.s1() != null && this.C0.s1().n() != null && this.C0.s1().R() != null) {
                nd5.j().x(getPageContext().getPageActivity(), "pb", this.C0.s1().n().getId(), JavaTypesHelper.toLong(this.C0.s1().R().getId(), 0L));
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            qua.g().h(getUniqueId(), false);
        }
    }

    public final void C8(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) != null) || this.t0) {
            return;
        }
        x5a.I(1, this.C0);
        SparseArray sparseArray = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
        if (sparseArray != null && (sparseArray.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_is_top_question)).booleanValue()) {
            x5a.v(2);
        }
        x5a.N(1, 2);
        if (this.v) {
            this.v = false;
            x5a.N(20, 2);
            return;
        }
        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
        if (!(tbRichTextView.getTag() instanceof SparseArray)) {
            x5a.N(20, 2);
            return;
        }
        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
        if (!(obj instanceof nwa)) {
            x5a.N(20, 2);
            return;
        }
        nwa nwaVar = (nwa) obj;
        PbModel pbModel = this.C0;
        if (pbModel != null && pbModel.s1() != null && i7().j1() != null && nwaVar.u() != null && nwaVar.L() != 1) {
            if (!checkUpIsLogin()) {
                x5a.N(2, 2);
                return;
            } else if (nwaVar.E0()) {
                return;
            } else {
                if (i7().k1() != null) {
                    i7().k1().g();
                }
                lw9 lw9Var = new lw9();
                lw9Var.v(this.C0.s1().n());
                lw9Var.z(this.C0.s1().R());
                lw9Var.x(nwaVar);
                i7().j1().k0(lw9Var);
                i7().j1().setPostId(nwaVar.U());
                Q7(view2, nwaVar.u().getUserId(), "", nwaVar);
                TiebaStatic.log("c11743");
                x5a.b(this.C0.s1(), nwaVar, nwaVar.h0, 8, 1);
                bh5 bh5Var = this.Z0;
                if (bh5Var != null) {
                    this.J0.p3(bh5Var.C());
                    return;
                }
                return;
            }
        }
        x5a.N(20, 2);
    }

    public final void h8(View view2) {
        vv9 s12;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, view2) == null) {
            if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (s12 = this.C0.s1()) == null) {
                return;
            }
            ThreadData R = s12.R();
            if (R != null && R.getAuthor() != null) {
                x5a.x(4, this.C0);
            }
            PbModel pbModel = this.C0;
            AbsPbActivity u02 = u0();
            j1a j1aVar = this.J0;
            int i5 = 6;
            if (view2.getId() == R.id.share_num_container) {
                i4 = 5;
            } else {
                i4 = 6;
            }
            x5a.O(pbModel, u02, j1aVar, i4);
            if (!BdUtilHelper.isNetOk()) {
                showToast(R.string.obfuscated_res_0x7f0f0e6f);
            } else if (s12 == null) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1035));
            } else {
                ArrayList<nwa> I = this.C0.s1().I();
                if ((I == null || I.size() <= 0) && this.C0.L1()) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1035));
                    return;
                }
                this.J0.s0();
                i9();
                if (s12.D() != null && !StringUtils.isNull(s12.D().a(), true)) {
                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.C0.s1().o()));
                }
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), R)) {
                    return;
                }
                j1a j1aVar2 = this.J0;
                if (j1aVar2 != null) {
                    j1aVar2.u0();
                    this.J0.E4(s12);
                }
                if (ShareSwitch.isOn()) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091ba5) {
                        i5 = 2;
                    } else if (view2.getId() == R.id.share_num_container) {
                        i5 = 1;
                    }
                    if (this.J0.n2() && !s12.q0()) {
                        c9(i5);
                        return;
                    } else {
                        c9(i5);
                        return;
                    }
                }
                this.J0.e4();
                this.C0.M0().Q(CheckRealNameModel.TYPE_PB_SHARE, 6);
            }
        }
    }

    public final void i8(View view2) {
        SparseArray sparseArray;
        boolean z3;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, view2) == null) {
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
            if (this.P0 == null) {
                m05 m05Var = new m05(getContext());
                this.P0 = m05Var;
                m05Var.r(this.l2);
            }
            ArrayList arrayList = new ArrayList();
            if (l0().s1() != null && l0().s1().a()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (view2 != null && sparseArray != null) {
                boolean b4 = k4a.b(sparseArray, R.id.tag_del_post_is_self, false);
                boolean b5 = k4a.b(sparseArray, R.id.tag_user_mute_visible, false);
                boolean b6 = k4a.b(sparseArray, R.id.tag_should_manage_visible, false);
                boolean b7 = k4a.b(sparseArray, R.id.tag_user_mute_visible, false);
                boolean b8 = k4a.b(sparseArray, R.id.tag_should_delete_visible, false);
                boolean b9 = k4a.b(sparseArray, R.id.tag_is_self_post, false);
                String c4 = k4a.c(sparseArray, R.id.tag_forbid_user_post_id, "");
                if (nwaVar.p() != null) {
                    boolean z4 = nwaVar.p().hasAgree;
                    int q3 = nwaVar.q();
                    if (z4 && q3 == 5) {
                        string = getString(R.string.action_cancel_dislike);
                    } else {
                        string = getString(R.string.action_dislike);
                    }
                    i05 i05Var = new i05(8, string, this.P0);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, nwaVar);
                    i05Var.d.setTag(sparseArray2);
                    arrayList.add(i05Var);
                }
                b4a.d(this.P0, b6, b5, sparseArray, arrayList, this.mIsLogin, B7());
                b4a.e(this.P0, b6, b5, arrayList, z3, c4, this.mIsLogin, B7(), i1a.y(this.C0.s1(), b4));
                b4a.b(this.P0, sparseArray, arrayList, b4, b6, b7, b8, b9, c4, this.mIsLogin, B7());
                b4a.a(this.P0, sparseArray, arrayList, b4, b6, b7, b8, b9, c4, this.mIsLogin, B7(), this.C0.s1().Z());
                this.P0.m(arrayList);
                k05 k05Var = new k05(getPageContext(), this.P0);
                this.O0 = k05Var;
                k05Var.l();
            }
        }
    }

    public final void j8(View view2) {
        StatisticItem statisticItem;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048705, this, view2) != null) || this.C0 == null) {
            return;
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f091c21) {
            x5a.I(6, this.C0);
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f091dee) {
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                this.U = view2;
                return;
            }
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091c21 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
            this.U = view2;
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
        if (view2.getId() == R.id.obfuscated_res_0x7f091c21 && (statisticItem = nwaVar.i0) != null) {
            StatisticItem copy = statisticItem.copy();
            copy.delete("obj_locate");
            copy.param("obj_locate", 8);
            TiebaStatic.log(copy);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091dee || view2.getId() == R.id.obfuscated_res_0x7f091bb2) {
            x5a.B(this.C0, nwaVar);
        }
        PbModel pbModel = this.C0;
        if (pbModel != null && pbModel.s1() != null && i7().j1() != null && nwaVar.u() != null && nwaVar.L() != 1) {
            if (i7().k1() != null) {
                i7().k1().g();
            }
            lw9 lw9Var = new lw9();
            lw9Var.v(this.C0.s1().n());
            lw9Var.z(this.C0.s1().R());
            lw9Var.x(nwaVar);
            i7().j1().k0(lw9Var);
            i7().j1().setPostId(nwaVar.U());
            Q7(view2, nwaVar.u().getUserId(), "", nwaVar);
            bh5 bh5Var = this.Z0;
            if (bh5Var != null) {
                this.J0.p3(bh5Var.C());
            }
        }
    }

    @Override // com.baidu.tieba.ty5
    public void D0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.Q0 = str;
            if (this.l == null) {
                A7();
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
                this.J0.v4(str);
            }
        }
    }

    public void D6(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(j1a.i2)).intValue();
            if (intValue == j1a.j2) {
                if (this.F0.h0()) {
                    return;
                }
                this.J0.x4();
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
                    this.F0.j0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.F0.k0(this.C0.s1().n().getId(), this.C0.s1().n().getName(), this.C0.s1().R().getId(), str, intValue3, intValue2, booleanValue, this.C0.s1().R().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                xq6.b().c(new v95(this.C0.M1()));
            } else if (intValue == j1a.k2 || intValue == j1a.m2) {
                PbModel pbModel = this.C0;
                if (pbModel != null && pbModel.N0() != null) {
                    this.C0.N0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == j1a.k2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public void H6(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i4, i5) == null) {
            TiebaStatic.log("c12181");
            j1a j1aVar = this.J0;
            if (j1aVar != null && this.C0 != null) {
                if ((j1aVar == null || j1aVar.a2()) && this.C0.s1() != null && this.C0.s1().V() != null) {
                    j1a j1aVar2 = this.J0;
                    if (j1aVar2 != null && j1aVar2.O0() != null && this.J0.O0().r()) {
                        return;
                    }
                    kw9 V = this.C0.s1().V();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!V.e() || V.a() != 2) && this.J0.G0() != null && this.J0.G0().p() != null) {
                        this.J0.G0().p().L(this.C0.M1(), this.C0.getFromForumId());
                    }
                    if (i4 > -1 && i5 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        PbFirstFloorDoubleClickAnimation pbFirstFloorDoubleClickAnimation = new PbFirstFloorDoubleClickAnimation(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.C0;
                        pbFirstFloorDoubleClickAnimation.show(findViewById, i4, i5, pbModel.b, pbModel.getForumId());
                        pbFirstFloorDoubleClickAnimation.setOnPraiseAnimatorListener(new y0(this));
                    } else if (System.currentTimeMillis() - this.w > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.w = System.currentTimeMillis();
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
        this.J0.B0(this.F0.getLoadDataMode(), gVar.a, gVar.b, false);
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
                this.C0.s1().R().setIs_good(1);
                this.C0.T2(1);
            } else if (i4 == 3) {
                this.C0.s1().R().setIs_good(0);
                this.C0.T2(0);
            } else if (i4 == 4) {
                this.C0.s1().R().setIs_top(1);
                this.C0.U2(1);
            } else if (i4 == 5) {
                this.C0.s1().R().setIs_top(0);
                this.C0.U2(0);
            }
            this.J0.F4(this.C0.s1(), this.C0.L1());
            if (i4 == 4 || i4 == 5) {
                xq6.b().c(new qh5(gVar.d));
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
                        vb5.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            au9.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            au9.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            au9.e(getResources().getString(R.string.obfuscated_res_0x7f0f14d1));
                            return;
                        } else {
                            au9.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.C0.f1()) {
                antiData.setBlock_forum_name(this.C0.s1().n().getName());
                antiData.setBlock_forum_id(this.C0.s1().n().getId());
                antiData.setUser_name(this.C0.s1().Y().getUserName());
                antiData.setUser_id(this.C0.s1().Y().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void W8(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048654, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            k05 k05Var = this.O0;
            if (k05Var != null && k05Var.isShowing()) {
                this.O0.dismiss();
                this.O0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            m05 m05Var = new m05(getContext());
            m05Var.r(new o0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i4 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i4 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i4 == 1) {
                arrayList.add(new i05(0, getResources().getString(R.string.obfuscated_res_0x7f0f055b), m05Var));
            }
            if (z3) {
                arrayList.add(new i05(1, getResources().getString(R.string.un_mute), m05Var));
            } else {
                arrayList.add(new i05(1, getResources().getString(R.string.obfuscated_res_0x7f0f0d47), m05Var));
            }
            m05Var.m(arrayList);
            k05 k05Var2 = new k05(getPageContext(), m05Var);
            this.O0 = k05Var2;
            k05Var2.l();
        }
    }

    public final void h9(nwa nwaVar, boolean z3) {
        PbModel pbModel;
        int i4;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048698, this, nwaVar, z3) == null) {
            J8(false);
            if (nwaVar == null || (pbModel = this.C0) == null || pbModel.s1() == null || nwaVar.L() == 1) {
                return;
            }
            String M1 = this.C0.M1();
            String U = nwaVar.U();
            if (this.C0.s1() != null) {
                i4 = this.C0.s1().Z();
            } else {
                i4 = 0;
            }
            AbsPbActivity.e s8 = s8(U);
            if (s8 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo n02 = nwaVar.n0();
            AntiData f4 = this.C0.s1().f();
            if (nwaVar.u() != null) {
                arrayList = nwaVar.u().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(M1, U, "pb", true, false, null, false, null, i4, n02, f4, false, arrayList, 5).addBigImageData(s8.a, s8.b, s8.g, s8.j);
            addBigImageData.setKeyPageStartFrom(this.C0.r1());
            addBigImageData.setFromFrsForumId(this.C0.getFromForumId());
            addBigImageData.setWorksInfoData(this.C0.R1());
            addBigImageData.setKeyFromForumId(this.C0.getForumId());
            addBigImageData.setBjhData(this.C0.J0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public void E6(c05 c05Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, c05Var, jSONArray) == null) {
            c05Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(c05Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                D6((SparseArray) c05Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    @Override // com.baidu.tieba.ty5
    public void b0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048668, this, context, str) == null) {
            if (!StringUtils.isNull(str) && !TextUtils.isDigitsOnly(str) && ay9.a(str)) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("TargetSchemeInterceptHelper", "jump targetScheme: " + str);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            }
            this.v = true;
        }
    }

    public final boolean E7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            nwa d4 = wv9.d(this.C0.s1(), this.C0.L1(), this.C0.D1());
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
            this.J0.s0();
            if (l0().s1().g == 2) {
                showToast(R.string.hot_sort_jump_hint);
                return;
            }
            if (this.C0.q1() != null) {
                this.J0.q4(this.C0.q1(), this.j2);
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
            this.J0.s0();
            i9();
            this.J0.J3();
            this.J0.e4();
            if (this.J0.i1() != null) {
                this.J0.i1().setVisibility(8);
            }
            this.C0.e3(1);
            w2a w2aVar = this.f;
            if (w2aVar != null) {
                w2aVar.x();
            }
        }
    }

    public final void N7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && this.S2 != null) {
            if (this.Q2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f1033);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.S2.a(), this.Q2, 0)));
                this.b.finish();
            }
        }
    }

    public final void P7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048629, this) == null) && this.S2 != null) {
            if (this.P2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f1034);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.S2.a(), this.P2, 0)));
                this.b.finish();
            }
        }
    }

    public final void V8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            c05 c05Var = new c05(getPageContext().getPageActivity());
            c05Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            c05Var.setPositiveButton(R.string.open_now, new j(this));
            c05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new l(this));
            c05Var.create(this.i1).show();
        }
    }

    public final void X8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            showLoadingView(this.J0.u1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d5));
            View attachedView = getLoadingView().getAttachedView();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
            layoutParams.addRule(3, this.J0.t1().getId());
            attachedView.setLayoutParams(layoutParams);
        }
    }

    public final void Y7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048660, this) == null) && getPageContext().getPageActivity() != null && this.C0 != null) {
            sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(getPageContext().getPageActivity(), this.C0.M1(), this.C0.f2(), this.C0.e2())));
            x5a.C(this.C0);
        }
    }

    public final void j7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048704, this) == null) {
            if (this.H0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.H0 = pollingModel;
                pollingModel.setDialogTime(v05.e);
            }
            this.H0.getData(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            SafeHandler.getInst().postDelayed(this.Z1, 10000L);
        }
    }

    public final void l6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            if (this.p1 != null) {
                ej5.b bVar = new ej5.b();
                bVar.a = this.p1.S();
                bVar.b = this.p1.Q();
                bVar.c = String.valueOf(this.p1.T());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.o1));
        }
    }

    public final void l8() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048715, this) == null) && this.s1 >= 0) {
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                pbModel.L2();
            }
            if (this.C0 != null && this.J0.G0() != null) {
                this.J0.G0().D(this.C0.s1(), false);
            }
            this.s1 = 0;
            if (this.C0 != null) {
                if (this.J0.Z0() != null) {
                    this.J0.Z0().setSelection(this.C0.l1());
                }
                this.C0.P2(0, 0);
            }
        }
    }

    public final void m7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.J0.u3(true);
            this.J0.h3();
            if (this.i) {
                return;
            }
            this.i = true;
            this.J0.m4();
            i9();
            this.J0.J3();
            this.C0.i3(W6());
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
        }
    }

    public final void m9() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048720, this) == null) && (pbModel = this.C0) != null && pbModel.s1() != null) {
            vv9 s12 = this.C0.s1();
            if (this.G0 == null) {
                this.G0 = new nw9(getPageContext());
            }
            long j4 = JavaTypesHelper.toLong(s12.T(), 0L);
            long j5 = JavaTypesHelper.toLong(s12.o(), 0L);
            x5a.M("c13446", j5);
            registerListener(this.s2);
            this.G0.a(j4, j5);
        }
    }

    public final void p9() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048755, this) == null) && (absPbActivity = this.b) != null && absPbActivity.B1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.b.B1().M1()).param("topic_id", this.b.B1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.b.B1().Q1()));
        }
    }

    public final boolean r6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel == null || pbModel.s1() == null) {
                return false;
            }
            ThreadData R = this.C0.s1().R();
            AntiData f4 = this.C0.s1().f();
            if (!AntiHelper.b(getPageContext(), R) && !AntiHelper.d(getPageContext(), f4)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void s9() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048769, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.T(this.C0.getForumId()) && this.C0.s1() != null && this.C0.s1().n() != null) {
            boolean z3 = true;
            if (this.C0.s1().n().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.C0.F0().S(this.C0.getForumId(), this.C0.M1());
            }
        }
    }

    public boolean u6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048778, this)) == null) {
            if ((this.C0.s1() != null && (this.C0.s1().a() || ThreadCardUtils.isSelf(this.C0.s1().R()))) || this.b1 == null || this.C0.s1() == null || this.C0.s1().f() == null) {
                return true;
            }
            return this.b1.checkPrivacyBeforeInvokeEditor(this.C0.s1().f().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void x6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048793, this) == null) {
            if (this.C0.X0() || this.C0.a1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.C0.M1());
                this.b.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.C0.M1()));
            if (k9()) {
                this.b.finish();
            }
        }
    }

    public final void y6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048796, this) == null) {
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
            this.J0.j.g();
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
            sparseArray.put(j1a.i2, Integer.valueOf(j1a.j2));
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
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (pbModel = this.C0) != null && pbModel.s1() != null && this.C0.s1().R() != null && this.C0.s1().R().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void G8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (pbModel = this.C0) != null && pbModel.s1() != null && this.C0.s1().R() != null && this.C0.s1().R().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public final int S6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (this.C0.s1() != null && this.C0.s1().R() != null) {
                return this.C0.s1().R().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final boolean U8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel == null || !pbModel.L1()) {
                return false;
            }
            if (this.C0.q1() != null && this.C0.q1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void d8() {
        List<i3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048679, this) == null) && (list = this.u1) != null && !list.isEmpty()) {
            int size = this.u1.size();
            while (true) {
                size--;
                if (size <= -1 || this.u1.get(size).onBackPressed()) {
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
            this.J0.s0();
            if (this.i) {
                return;
            }
            i9();
            this.J0.J3();
            if (this.C0.loadData()) {
                this.J0.m4();
            }
        }
    }

    public final void f9() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048687, this) == null) && (pbModel = this.C0) != null && !rd.isEmpty(pbModel.M1())) {
            mo4.w().Q(lo4.Z, JavaTypesHelper.toLong(this.C0.M1(), 0L));
        }
    }

    public final void s7() {
        TiebaPlusConfigData tiebaPlusConfigData;
        String jumpUrlWithTid;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048767, this) == null) && (tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData()) != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.C0.M1())) != null) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{jumpUrlWithTid});
            this.J0.j.f();
            TiebaPlusConfigData.addClickStatsForFireLink(3);
        }
    }

    public final boolean t6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.s1() != null && this.C0.s1().j() != null && !TextUtils.isEmpty(this.C0.s1().j().l)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void t7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048772, this) == null) && this.b != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.b.getCurrentFocus() != null) {
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), this.b.getCurrentFocus());
        }
    }

    public final void G6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            SparseArray<Object> a12 = this.J0.a1(this.C0.s1(), this.C0.L1(), 1);
            if (a12 != null) {
                if (StringUtils.isNull((String) a12.get(R.id.tag_del_multi_forum))) {
                    this.J0.K2(((Integer) a12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(a12.get(R.id.tag_del_post_id)), ((Integer) a12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) a12.get(R.id.tag_del_post_is_self)).booleanValue());
                } else {
                    this.J0.L2(((Integer) a12.get(R.id.tag_del_post_type)).intValue(), (String) a12.get(R.id.tag_del_post_id), ((Integer) a12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) a12.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(a12.get(R.id.tag_del_multi_forum)));
                }
            }
            this.J0.j.f();
        }
    }

    public final void H7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.C0.s1() != null && this.C0.s1().R() != null && this.C0.s1().R().getActUrl() != null) {
            BrowserHelper.startWebActivity(getActivity(), this.C0.s1().R().getActUrl());
            if (this.C0.s1().R().getActInfoType() == 1) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
            } else if (this.C0.s1().R().getActInfoType() == 2) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
            }
        }
    }

    public final void V7() {
        MarkData I0;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && this.E0 != null) {
            if (this.C0.s1() != null && this.C0.s1().a()) {
                I0 = this.C0.I0(0);
            } else {
                I0 = this.C0.I0(this.J0.Y0());
            }
            if (I0 == null) {
                return;
            }
            if (I0.isApp() && (I0 = this.C0.I0(this.J0.Y0() + 1)) == null) {
                return;
            }
            this.J0.J3();
            this.E0.i(I0);
            if (!this.E0.e()) {
                if (this.J0 != null && (pbModel = this.C0) != null && !o4a.g(pbModel.b)) {
                    this.J0.p4();
                    o4a.a(this.C0.b);
                }
                this.E0.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.E0.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final void Z7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
            if (this.C0.s1() != null && this.C0.s1().R() != null && this.C0.s1().R().isVideoThreadType() && this.C0.s1().R().getThreadVideoInfo() != null) {
                TiebaStatic.log(new StatisticItem("c11922"));
            }
            String a4 = a4a.a(this.C0);
            if (StringUtils.isNull(a4)) {
                this.b.finish();
                return;
            }
            String R0 = this.C0.R0();
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(a4, FrsActivityConfig.FRS_FROM_PB);
            if (this.C0.X0() && R0 != null && R0.equals(a4)) {
                this.b.finish();
            } else {
                sendMessage(new CustomMessage(2003000, createNormalCfg));
            }
        }
    }

    public final void k6() {
        PbModel pbModel;
        vv9 vv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048707, this) == null) && (pbModel = this.C0) != null && (vv9Var = pbModel.G) != null && vv9Var.R() != null) {
            ThreadData R = this.C0.G.R();
            R.mRecomAbTag = this.C0.y1();
            R.mRecomWeight = this.C0.B1();
            R.mRecomSource = this.C0.A1();
            R.mRecomExtra = this.C0.z1();
            R.isSubPb = this.C0.f1();
            if (R.getFid() == 0) {
                R.setFid(JavaTypesHelper.toLong(this.C0.getForumId(), 0L));
            }
            StatisticItem i4 = yo5.i(getContext(), R, "c13562");
            TbPageTag l3 = yo5.l(getContext());
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
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            SparseArray<Object> a12 = this.J0.a1(this.C0.s1(), this.C0.L1(), 1);
            if (a12 != null) {
                this.J0.N2(((Integer) a12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(a12.get(R.id.tag_del_post_id)), ((Integer) a12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) a12.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            this.J0.j.f();
            if (l0() != null && l0().s1() != null && l0().s1().R() != null) {
                x5a.G(l0().s1().R());
            }
        }
    }

    public final void n9() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048725, this) == null) && (pbModel = this.C0) != null && pbModel.s1() != null && this.C0.s1().n() != null && !rd.isEmpty(this.C0.s1().n().getName())) {
            String a4 = a4a.a(this.C0);
            if (StringUtils.isNull(a4)) {
                this.b.finish();
                return;
            }
            String R0 = this.C0.R0();
            if (this.C0.X0() && R0 != null && R0.equals(a4)) {
                this.b.finish();
            } else {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(this.C0.s1().n().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            }
            x5a.A(this.C0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048744, this) == null) {
            this.g = true;
            super.onPause();
            l4a.a();
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
            j1a j1aVar = this.J0;
            if (j1aVar != null) {
                j1aVar.B2();
            }
            if (this.Z0 != null && !this.C0.f1()) {
                this.Z0.R(this.C0.M1());
            }
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                pbModel.w2();
            }
            PushPermissionController pushPermissionController = this.w0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            mo4.w().E();
            MessageManager.getInstance().unRegisterListener(this.F1);
            F8();
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.b2);
            MessageManager.getInstance().unRegisterListener(this.d2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            sb5 sb5Var = this.r0;
            if (sb5Var != null) {
                sb5Var.o();
                this.r0.n();
            }
        }
    }

    public final void p6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            this.J0.j.g();
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                this.w1.f(pbModel.M1());
            }
            int i4 = 1;
            PbModel pbModel2 = this.C0;
            if (pbModel2 != null && pbModel2.isPrivacy()) {
                showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (l0() != null && l0().s1() != null) {
                    this.w1.d(3, 3, l0().s1().T());
                    return;
                }
                return;
            }
            this.w1.b();
            if (!TbSingleton.getInstance().mCanCallFans && l0() != null && l0().s1() != null && l0().s1().T() != null && l0().s1().T().equals(TbSingleton.getInstance().mCallFansTid)) {
                i4 = 2;
            }
            if (l0() != null && l0().s1() != null) {
                this.w1.d(3, i4, l0().s1().T());
            }
        }
    }

    public final void G7(View view2) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, view2) == null) && view2 != null) {
            BrowserHelper.startWebActivity(getActivity(), StringUtils.string(view2.getTag()));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (S6() == 1 && (pbModel = this.C0) != null && pbModel.s1() != null) {
                x5a.D("c10397", this.C0.s1().o(), this.C0.s1().T(), currentAccount);
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
            if (S6() == 1 && (pbModel = this.C0) != null && pbModel.s1() != null) {
                x5a.D("c10507", this.C0.s1().o(), this.C0.s1().T(), currentAccount);
            }
        }
    }

    public final void M8(ch5 ch5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, ch5Var) == null) && ch5Var != null && (pbModel = this.C0) != null) {
            ch5Var.p(pbModel.R0());
            if (this.C0.s1() != null && this.C0.s1().n() != null) {
                ch5Var.o(this.C0.s1().n());
            }
            ch5Var.q("pb");
            ch5Var.r(this.C0);
            ch5Var.s(PbNewEditorTool.InputShowType.REPLY);
        }
    }

    public final void N8(int i4) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048623, this, i4) != null) || (pbModel = this.C0) == null) {
            return;
        }
        int C1 = pbModel.C1();
        if (i4 != 5) {
            if (i4 != 6) {
                if (i4 != 7) {
                    this.C0.a3(1);
                } else {
                    this.C0.a3(4);
                }
            } else {
                this.C0.a3(3);
            }
        } else {
            this.C0.a3(2);
        }
        int C12 = this.C0.C1();
        if (C1 == 4 || C12 == 4) {
            e8();
        }
    }

    public final void O7(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bundle) == null) {
            PbModel B1 = this.b.B1();
            this.C0 = B1;
            if (B1 != null) {
                if (B1.N0() != null) {
                    this.C0.N0().c(this.O2);
                }
                if (this.C0.o1() != null) {
                    this.C0.o1().f(this.y1);
                }
                if (StringUtils.isNull(this.C0.M1())) {
                    this.b.finish();
                } else if ("from_tieba_kuang".equals(this.N) && this.N != null) {
                    this.C0.X2(6);
                }
            }
        }
    }

    public final void n8(View view2) {
        oz4 oz4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048724, this, view2) == null) && checkUpIsLogin() && (oz4Var = (oz4) view2.getTag()) != null && !StringUtils.isNull(oz4Var.H1())) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{oz4Var.H1()});
        }
    }

    public final void o6(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048727, this, view2) != null) || !(view2.getTag() instanceof ThreadData)) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
        createNormalCfg.setCallFrom(14);
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        x5a.H(threadData, 9, 9);
    }

    public void o8(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048729, this, animatorListener) == null) && this.J0 != null && (pbModel = this.C0) != null && pbModel.s1() != null && this.C0.s1().V() != null && checkUpIsLogin() && this.J0.G0() != null && this.J0.G0().p() != null) {
            this.J0.G0().p().V(animatorListener);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z3;
        j1a j1aVar;
        z4a z4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048736, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (UtilHelper.isFoldScreen() && (j1aVar = this.J0) != null && (z4aVar = j1aVar.j) != null && z4aVar.n()) {
                this.J0.j.g();
                f8();
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
            j1a j1aVar2 = this.J0;
            if (j1aVar2 != null) {
                j1aVar2.v2(configuration);
            }
            k05 k05Var = this.O0;
            if (k05Var != null) {
                k05Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public final void q9(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048760, this, z3) == null) && (absPbActivity = this.b) != null && absPbActivity.B1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.b.B1().M1()).param("topic_id", this.b.B1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.b.B1().Q1()));
        }
    }

    public void s6(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048766, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.J0.e4();
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

    public boolean v6(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048784, this, i4)) == null) {
            if (this.b1 != null && this.C0.s1() != null && !ThreadCardUtils.isSelf(this.C0.s1().R()) && this.C0.s1().f() != null) {
                return this.b1.checkPrivacyBeforeSend(this.C0.s1().f().replyPrivateFlag, i4);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void L6(View view2) {
        String str;
        int i4;
        PbModel pbModel;
        vv9 vv9Var;
        nwa a02;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091a2f) {
                x5a.I(4, this.C0);
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f091bb8 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                this.f1138T = view2;
            } else if (!checkUpIsLogin()) {
                x5a.u("c10517", this.C0.s1().o(), 3);
            } else {
                PbModel pbModel2 = this.C0;
                if (pbModel2 != null && pbModel2.s1() != null) {
                    this.J0.s0();
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
                            if (view2.getId() == R.id.obfuscated_res_0x7f091a2f) {
                                copy.param("obj_locate", 6);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091bb8) {
                                copy.param("obj_locate", 8);
                            }
                            TiebaStatic.log(copy);
                        }
                        String M1 = this.C0.M1();
                        String U = nwaVar.U();
                        if (nwaVar2 != null) {
                            str = nwaVar2.U();
                        } else {
                            str = "";
                        }
                        if (this.C0.s1() != null) {
                            i4 = this.C0.s1().Z();
                        } else {
                            i4 = 0;
                        }
                        i9();
                        if (view2.getId() == R.id.obfuscated_res_0x7f091fd7) {
                            AbsPbActivity.e s8 = s8(U);
                            PbModel pbModel3 = this.C0;
                            if (pbModel3 != null && pbModel3.s1() != null && s8 != null) {
                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(M1, U, "pb", true, false, null, true, null, i4, nwaVar.n0(), this.C0.s1().f(), false, nwaVar.u().getIconInfo(), 5).addBigImageData(s8.a, s8.b, s8.g, s8.j);
                                addBigImageData.setKeyPageStartFrom(this.C0.r1());
                                addBigImageData.setFromFrsForumId(this.C0.getFromForumId());
                                addBigImageData.setWorksInfoData(this.C0.R1());
                                addBigImageData.setKeyFromForumId(this.C0.getForumId());
                                addBigImageData.setBjhData(this.C0.J0());
                                addBigImageData.setTiebaPlusData(this.C0.X(), this.C0.T(), this.C0.U(), this.C0.S(), this.C0.Y());
                                sendMessage(new CustomMessage(2002001, addBigImageData));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log("c11742");
                        AbsPbActivity.e s82 = s8(U);
                        if (nwaVar != null && (pbModel = this.C0) != null && pbModel.s1() != null && s82 != null) {
                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(M1, U, "pb", true, false, null, false, str, i4, nwaVar.n0(), this.C0.s1().f(), false, nwaVar.u().getIconInfo(), 5).addBigImageData(s82.a, s82.b, s82.g, s82.j);
                            if (!rd.isEmpty(str)) {
                                addBigImageData2.setHighLightPostId(str);
                                addBigImageData2.setKeyIsUseSpid(true);
                            }
                            addBigImageData2.setKeyFromForumId(this.C0.getForumId());
                            addBigImageData2.setTiebaPlusData(this.C0.X(), this.C0.T(), this.C0.U(), this.C0.S(), this.C0.Y());
                            addBigImageData2.setBjhData(this.C0.J0());
                            addBigImageData2.setKeyPageStartFrom(this.C0.r1());
                            addBigImageData2.setFromFrsForumId(this.C0.getFromForumId());
                            addBigImageData2.setWorksInfoData(this.C0.R1());
                            if (this.J0 != null && (vv9Var = this.C0.G) != null && (a02 = vv9Var.a0()) != null) {
                                if (!a02.f1135T && !nwaVar.f1135T) {
                                    z3 = false;
                                }
                                addBigImageData2.setMainPostMaskVisibly(z3);
                            }
                            if (this.C0.s1() != null && this.C0.s1().q() != null) {
                                addBigImageData2.setHasForumRule(this.C0.s1().q().has_forum_rule.intValue());
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
        vv9 vv9Var;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048617, this, view2) != null) || (pbModel = this.C0) == null) {
            return;
        }
        x5a.I(5, pbModel);
        if (view2.getId() == R.id.obfuscated_res_0x7f091c23 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
            this.f1138T = view2;
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
            PbModel pbModel2 = this.C0;
            if (pbModel2 != null && pbModel2.s1() != null) {
                String M1 = this.C0.M1();
                String U = nwaVar.U();
                if (this.C0.s1() != null) {
                    i4 = this.C0.s1().Z();
                } else {
                    i4 = 0;
                }
                AbsPbActivity.e s8 = s8(U);
                if (s8 == null) {
                    return;
                }
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(M1, U, "pb", true, false, null, false, null, i4, nwaVar.n0(), this.C0.s1().f(), false, nwaVar.u().getIconInfo(), 5).addBigImageData(s8.a, s8.b, s8.g, s8.j);
                addBigImageData.setKeyPageStartFrom(this.C0.r1());
                addBigImageData.setFromFrsForumId(this.C0.getFromForumId());
                addBigImageData.setWorksInfoData(this.C0.R1());
                addBigImageData.setKeyFromForumId(this.C0.getForumId());
                addBigImageData.setTiebaPlusData(this.C0.X(), this.C0.T(), this.C0.U(), this.C0.S(), this.C0.Y());
                addBigImageData.setBjhData(this.C0.J0());
                if (this.C0.s1().q() != null) {
                    addBigImageData.setHasForumRule(this.C0.s1().q().has_forum_rule.intValue());
                }
                if (this.C0.s1().Y() != null) {
                    addBigImageData.setIsManager(this.C0.s1().Y().getIs_manager());
                }
                if (this.C0.s1().n().getDeletedReasonInfo() != null) {
                    addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.C0.s1().n().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                    addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.C0.s1().n().getDeletedReasonInfo().is_boomgrow.intValue());
                }
                if (this.C0.s1().n() != null) {
                    addBigImageData.setForumHeadUrl(this.C0.s1().n().getImage_url());
                    addBigImageData.setUserLevel(this.C0.s1().n().getUser_level());
                }
                if (this.J0 != null && (vv9Var = this.C0.G) != null) {
                    if (!vv9Var.a0().f1135T && !nwaVar.f1135T) {
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
        i05 i05Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048709, this, view2) != null) || !checkUpIsLogin()) {
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
                TiebaStatic.log(new StatisticItem("c12006").param("tid", this.C0.b));
            }
            if (this.P0 == null) {
                m05 m05Var = new m05(getContext());
                this.P0 = m05Var;
                m05Var.r(this.l2);
            }
            ArrayList arrayList = new ArrayList();
            boolean b4 = k4a.b(sparseArray, R.id.tag_del_post_is_self, false);
            boolean b5 = k4a.b(sparseArray, R.id.tag_user_mute_visible, false);
            boolean b6 = k4a.b(sparseArray, R.id.tag_should_manage_visible, false);
            boolean b7 = k4a.b(sparseArray, R.id.tag_user_mute_visible, false);
            boolean b8 = k4a.b(sparseArray, R.id.tag_should_delete_visible, false);
            boolean b9 = k4a.b(sparseArray, R.id.tag_is_self_post, false);
            String c4 = k4a.c(sparseArray, R.id.tag_forbid_user_post_id, "");
            if (nwaVar != null) {
                if (nwaVar.f0() != null && nwaVar.f0().toString().length() > 0) {
                    i05 i05Var2 = new i05(3, getString(R.string.obfuscated_res_0x7f0f04f5), this.P0);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, nwaVar);
                    i05Var2.d.setTag(sparseArray2);
                    arrayList.add(i05Var2);
                }
                this.E2 = nwaVar;
            }
            if (this.C0.s1().t()) {
                String x3 = this.C0.s1().x();
                if (nwaVar != null) {
                    if (!rd.isEmpty(x3)) {
                    }
                }
            }
            z4 = false;
            if (z4) {
                i05Var = new i05(4, getString(R.string.remove_mark), this.P0);
            } else {
                i05Var = new i05(4, getString(R.string.obfuscated_res_0x7f0f0c89), this.P0);
            }
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_clip_board, this.E2);
            sparseArray3.put(R.id.tag_is_subpb, Boolean.FALSE);
            i05Var.d.setTag(sparseArray3);
            arrayList.add(i05Var);
            b4a.d(this.P0, b6, b5, sparseArray, arrayList, this.mIsLogin, B7());
            b4a.e(this.P0, b6, b5, arrayList, false, c4, this.mIsLogin, B7(), i1a.y(this.C0.s1(), b4));
            b4a.b(this.P0, sparseArray, arrayList, b4, b6, b7, b8, b9, c4, this.mIsLogin, B7());
            b4a.a(this.P0, sparseArray, arrayList, b4, b6, b7, b8, b9, c4, this.mIsLogin, B7(), this.C0.s1().Z());
            this.P0.m(arrayList);
            k05 k05Var = new k05(getPageContext(), this.P0);
            this.O0 = k05Var;
            k05Var.l();
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
                c05 c05Var = new c05(getPageContext().getPageActivity());
                c05Var.setMessage(string);
                c05Var.setPositiveButton(R.string.dialog_known, new m2(this));
                c05Var.setCancelable(true);
                c05Var.create(getPageContext());
                c05Var.show();
            } else if (bVar.d != 0) {
                this.J0.B0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i5 = bVar.d;
                if (i5 == 1) {
                    ArrayList<nwa> I = this.C0.s1().I();
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
                    this.C0.s1().R().setReply_num(this.C0.s1().R().getReply_num() - 1);
                    this.J0.Y1(this.C0.s1());
                } else if (i5 == 0) {
                    x6();
                } else if (i5 == 2) {
                    ArrayList<nwa> I2 = this.C0.s1().I();
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
                        this.J0.Y1(this.C0.s1());
                    }
                    A6(bVar, this.J0);
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
            int i6 = (this.Z[1] + this.a0) - i5;
            j1a j1aVar = this.J0;
            if (j1aVar != null && j1aVar.Z0() != null) {
                this.J0.Z0().smoothScrollBy(i6, 50);
            }
            if (i7().k1() != null) {
                bh5 bh5Var = this.Z0;
                if (bh5Var != null) {
                    bh5Var.a().setVisibility(8);
                }
                PbModel pbModel2 = this.C0;
                i7().k1().t(str, str2, i7().m1(), (pbModel2 == null || pbModel2.s1() == null || this.C0.s1().R() == null || !this.C0.s1().R().isBjh()) ? false : false);
                eh5 f4 = i7().k1().f();
                if (f4 != null && (pbModel = this.C0) != null && pbModel.s1() != null) {
                    f4.K(this.C0.s1().f());
                    f4.g0(this.C0.s1().R());
                }
                if (this.N0.f() == null && i7().k1().f().v() != null) {
                    i7().k1().f().v().i(new p(this));
                    this.N0.n(i7().k1().f().v().k());
                    i7().k1().f().Q(this.f1);
                }
            }
            i7().x1();
        }
    }

    public final void o7(int i4, Intent intent) {
        se5 se5Var;
        se5 se5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048728, this, i4, intent) == null) {
            if (i4 == 0) {
                this.J0.z1();
                this.J0.k1().g();
                this.J0.X3(false);
            }
            this.J0.h3();
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
                if (editorType == 1 && this.J0.k1() != null && this.J0.k1().f() != null) {
                    eh5 f4 = this.J0.k1().f();
                    f4.g0(this.C0.s1().R());
                    f4.E(writeData);
                    f4.h0(pbEditorData.getVoiceModel());
                    re5 u3 = f4.a().u(6);
                    if (u3 != null && (se5Var2 = u3.m) != null) {
                        se5Var2.U(new ee5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i4 == -1) {
                        f4.J();
                        return;
                    }
                    return;
                }
                return;
            }
            bh5 bh5Var = this.Z0;
            if (bh5Var != null) {
                bh5Var.P();
                this.Z0.q0(pbEditorData.getVoiceModel());
                this.Z0.F(writeData);
                re5 u4 = this.Z0.a().u(6);
                if (u4 != null && (se5Var = u4.m) != null) {
                    se5Var.U(new ee5(52, 0, pbEditorData.getVoiceModel()));
                }
                this.Z0.l0(pbEditorData.isShowCustomFigure());
                re5 u5 = this.Z0.a().u(41);
                if (u5 != null) {
                    u5.h();
                    DLauncher dLauncher = (DLauncher) this.Z0.a().t(41);
                    if (dLauncher != null) {
                        dLauncher.setIcon();
                    }
                }
                if (i4 == -1) {
                    if (StringUtils.isNotNull(pbEditorData.getMemeQuery()) || pbEditorData.getMemeId() != 0) {
                        this.Z0.G = true;
                        if (StringUtils.isNotNull(pbEditorData.getMemeQuery())) {
                            this.Z0.H = pbEditorData.getMemeQuery();
                        }
                        if (pbEditorData.getMemeId() != 0) {
                            this.Z0.I = pbEditorData.getMemeId();
                        }
                    }
                    this.Z0.K(null, null);
                }
            }
        }
    }

    public final void P6(Rect rect) {
        j1a j1aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, rect) == null) && rect != null && (j1aVar = this.J0) != null && j1aVar.t1() != null && rect.top <= this.J0.t1().getHeight()) {
            rect.top += this.J0.t1().getHeight() - rect.top;
        }
    }

    public final void d9(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, str) == null) {
            if (str == null) {
                str = "";
            }
            BdPageContext bdPageContext = this.i1;
            if (bdPageContext == null) {
                return;
            }
            c05 c05Var = new c05(bdPageContext.getPageActivity());
            c05Var.setMessage(str);
            c05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b86, new m(this));
            c05Var.create(this.i1).show();
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
        if ((interceptable != null && interceptable.invokeL(1048722, this, view2) != null) || !(view2.getTag() instanceof ThreadData) || !checkUpIsLogin()) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        LikeModel likeModel = this.R;
        if (likeModel != null) {
            likeModel.g0(threadData.getForum_name(), String.valueOf(threadData.getFid()));
        }
        x5a.H(threadData, 10, 11);
    }

    public final void n7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 4).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public final void o9(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048730, this, view2) != null) || this.t0) {
            return;
        }
        x5a.I(7, this.C0);
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray != null && (sparseArray.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_is_top_question)).booleanValue()) {
            x5a.v(6);
        }
        this.c = false;
        z6(view2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048751, this, z3) == null) {
            super.onUserChanged(z3);
            this.J0.B4(z3);
            k05 k05Var = this.O0;
            if (k05Var != null) {
                k05Var.dismiss();
            }
            if (z3 && this.S0) {
                this.J0.K3();
                this.C0.q2(true);
            }
            if (this.J0.G0() != null) {
                this.J0.G0().z(z3);
            }
        }
    }

    public final void r9(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048765, this, i4) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.C0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(e4a.j(i4))));
        }
    }

    public final void u8(View view2) {
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048780, this, view2) != null) || view2 == null) {
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

    public final void v9(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048787, this, view2) == null) && (view2.getTag() instanceof SmartApp)) {
            SmartApp smartApp = (SmartApp) view2.getTag();
            if (!TbAiappsLaunchUtil.launch(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                if (StringUtils.isNull(smartApp.h5_url)) {
                    return;
                }
                BrowserHelper.startWebActivity(getActivity(), smartApp.h5_url);
            }
            x5a.y(smartApp, this.C0);
        }
    }

    public final void x7(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048794, this, bundle) == null) {
            gr4 c4 = gr4.c(this.b);
            this.E0 = c4;
            if (c4 != null) {
                c4.j(this.w2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.b);
            this.F0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.y2);
            getPageContext();
            j7();
            this.S1.setUniqueId(getUniqueId());
            this.S1.registerListener();
            z7();
        }
    }

    public final void Q7(View view2, String str, String str2, nwa nwaVar) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048633, this, view2, str, str2, nwaVar) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (r6()) {
                    x5a.N(3, 2);
                    return;
                } else if (!u6()) {
                    x5a.N(8, 2);
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.Z);
                        this.a0 = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (i7().k1() != null && nwaVar != null) {
                        if (nwaVar.f0() != null) {
                            str3 = nwaVar.f0().toString();
                        } else {
                            str3 = "";
                        }
                        i7().k1().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), nwaVar.u().getName_show(), str3));
                    }
                    if (this.C0.s1() != null && this.C0.s1().a()) {
                        SafeHandler.getInst().postDelayed(new s1(this, str, str2), 0L);
                        return;
                    } else {
                        SafeHandler.getInst().postDelayed(new t1(this, str, str2), 200L);
                        return;
                    }
                }
            }
            x5a.N(20, 2);
        }
    }

    public final void S8(SparseArray<Object> sparseArray, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{sparseArray, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            e4a.c(getActivity(), getPageContext(), new o1(this, sparseArray, i4, z3), new p1(this));
        }
    }

    public final void e9(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048684, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.J0.e4();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            c05 c05Var = new c05(this.i1.getPageActivity());
            if (!rd.isEmpty(str)) {
                c05Var.setMessage(str);
            } else {
                c05Var.setMessage(this.i1.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            c05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04d2, new n(this, userMuteAddAndDelCustomMessage));
            c05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new o(this));
            c05Var.create(this.i1).show();
        }
    }

    public void f8() {
        PbModel pbModel;
        vv9 s12;
        ThreadData R;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        vv9 vv9Var;
        boolean z8;
        boolean z9;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048686, this) == null) && (pbModel = this.C0) != null && pbModel.s1() != null && (R = (s12 = this.C0.s1()).R()) != null && R.getAuthor() != null) {
            this.J0.z1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), R.getAuthor().getUserId());
            s0a s0aVar = new s0a();
            int Z = this.C0.s1().Z();
            if (Z != 1 && Z != 3) {
                s0aVar.g = false;
            } else {
                s0aVar.g = true;
                if (R.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                s0aVar.s = z3;
            }
            if (i1a.v(this.C0.s1(), Z)) {
                s0aVar.h = true;
                if (R.getIs_good() == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                s0aVar.r = z9;
            } else {
                s0aVar.h = false;
            }
            if (Z == 1002 && !equals) {
                s0aVar.u = true;
            }
            s0aVar.n = i1a.F(R.isBlocked(), s12.o0(), equals, Z, R.isWorksInfo(), R.isScoreThread());
            s0aVar.e = i1a.D(s12, equals, s12.o0(), this.C0.W());
            s0aVar.i = U8();
            s0aVar.f = i1a.E(this.C0.s1(), equals, this.C0.W());
            if (equals && s12.Y() != null && s12.Y().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            s0aVar.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                s0aVar.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            s0aVar.t = equals;
            s0aVar.q = this.C0.L1();
            s0aVar.b = true;
            s0aVar.a = i1a.y(this.C0.s1(), equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            s0aVar.p = z5;
            s0aVar.j = true;
            s0aVar.o = this.C0.V0();
            s0aVar.d = true;
            if (R.getThreadVideoInfo() == null) {
                z6 = true;
            } else {
                z6 = false;
            }
            s0aVar.c = z6;
            if (s12.a()) {
                s0aVar.b = false;
                s0aVar.d = false;
                s0aVar.c = false;
                s0aVar.g = false;
                s0aVar.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !s12.a()) {
                z7 = true;
            } else {
                z7 = false;
            }
            s0aVar.v = z7;
            if (this.J0 != null && (vv9Var = this.C0.G) != null) {
                nwa a02 = vv9Var.a0();
                if (a02 != null) {
                    z8 = a02.f1135T;
                } else {
                    z8 = false;
                }
                s0aVar.w = z8;
            }
            s0aVar.m = true;
            if (R.isBlocked()) {
                s0aVar.n = false;
                s0aVar.g = false;
                s0aVar.h = false;
            }
            this.J0.j.x(s0aVar);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void h1(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048695, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (qy5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), qy5.class);
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (p1a.c(objArr[i4].g()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    @Override // com.baidu.tieba.ty5
    public void x0(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048792, this, context, str, z3) == null) {
            if (p1a.c(str) && (pbModel = this.C0) != null && pbModel.M1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.C0.M1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    id5 id5Var = new id5();
                    id5Var.a = str;
                    id5Var.b = 3;
                    id5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, id5Var));
                }
            } else {
                p1a.a().e(getPageContext(), str);
            }
            this.v = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048732, this, i4, i5, intent) == null) {
            super.onActivityResult(i4, i5, intent);
            bh5 bh5Var = this.Z0;
            if (bh5Var != null) {
                bh5Var.G(i4, i5, intent);
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
                                                    View view2 = this.f1138T;
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
                                                    j1a j1aVar = this.J0;
                                                    if (j1aVar != null && j1aVar.J0() != null) {
                                                        this.J0.J0().performClick();
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
                                        this.J0.L3(false);
                                        if (this.C0.s1() != null && this.C0.s1().R() != null && this.C0.s1().R().getPushStatusData() != null) {
                                            this.C0.s1().R().getPushStatusData().setStatus(2);
                                            return;
                                        }
                                        return;
                                    }
                                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                        RateManager.getInstance().notifyShare(getPageContext());
                                        s9();
                                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.I0;
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
                                View view5 = this.S;
                                if (view5 != null) {
                                    this.J0.b4(view5);
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
                    a1a.b().k();
                    this.z0.postDelayed(new q2(this), 1000L);
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048738, this, layoutInflater, viewGroup, bundle)) == null) {
            this.J0 = new j1a(this, this.n2, this.Y1, this.m2);
            wv6 wv6Var = new wv6(getActivity());
            this.e = wv6Var;
            wv6Var.i(V2);
            this.e.d(this.N2);
            this.J0.C3(this.x2);
            this.J0.B3(this.C2);
            this.J0.v3(this.z2);
            this.J0.w3(this.A2);
            this.J0.t3(nv4.c().g());
            this.J0.z3(this.D2);
            this.J0.F3(this.I2);
            this.J0.D3(this.J2);
            this.J0.A3(this.L2);
            this.J0.B4(this.mIsLogin);
            this.J0.O3(q2a.a(this.C0));
            if (this.b.getIntent() != null) {
                this.J0.s3(this.b.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.J0.j1().setFromForumId(this.C0.getFromForumId());
            bh5 bh5Var = this.Z0;
            if (bh5Var != null) {
                this.J0.k3(bh5Var.a());
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.Z0.g0(TbSingleton.getInstance().getAdVertiComment());
                } else {
                    this.Z0.g0(this.J0.m1());
                }
            }
            this.J0.o3(this.k2);
            this.J0.r3(this.C0.a1());
            this.J0.E3(this.C0.r1());
            this.v0.f(this.J0, this.C0);
            if ("1".equals(l0().showReplyPanel)) {
                this.J0.D2();
            }
            w7();
            return this.J0.u1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        j1a j1aVar;
        j1a j1aVar2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048737, this, bundle) == null) {
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
                this.T0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.U0 = intent.getStringExtra("high_light_post_id");
                this.V0 = intent.getBooleanExtra("key_jump_to_top", false);
                this.W0 = intent.getBooleanExtra("frs_top_thread_type", false);
                if (Y6()) {
                    this.b.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.Q = stringExtra;
                if (rd.isEmpty(stringExtra)) {
                    str = "";
                } else {
                    str = this.Q;
                }
                this.Q = str;
                this.t1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                ry4 ry4Var = new ry4();
                this.d0 = ry4Var;
                ry4Var.a(intent);
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
            O7(bundle);
            if (this.C0.s1() != null) {
                this.C0.s1().W0(this.Q);
                if (this.W0 && this.C0.s1().R() != null) {
                    this.C0.s1().R().setIs_top(1);
                }
            }
            y7();
            if (intent != null && (j1aVar2 = this.J0) != null) {
                j1aVar2.d = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.l1 == null) {
                        this.l1 = new s0(this, intent);
                    }
                    SafeHandler.getInst().postDelayed(this.l1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.C0.s1() != null) {
                    this.C0.Y2(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.j = voiceManager;
            voiceManager.onCreate(getPageContext());
            x7(bundle);
            ch5 ch5Var = new ch5();
            this.Y0 = ch5Var;
            M8(ch5Var);
            bh5 bh5Var = (bh5) this.Y0.a(getActivity());
            this.Z0 = bh5Var;
            bh5Var.a0(this.b.getPageContext());
            this.Z0.j0(this.p2);
            this.Z0.k0(this.d1);
            this.Z0.c0(1);
            this.Z0.E(this.b.getPageContext(), bundle);
            this.Z0.a().c(new qe5(getActivity()));
            this.Z0.a().M(true);
            P8(true);
            this.Z0.N(this.C0.U0(), this.C0.M1(), this.C0.Q0());
            registerListener(this.C1);
            if (!this.C0.f1()) {
                this.Z0.t(this.C0.M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.Z0.g0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.C0.d2()) {
                this.Z0.g0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                j1a j1aVar3 = this.J0;
                if (j1aVar3 != null) {
                    this.Z0.g0(j1aVar3.m1());
                }
            }
            ex9 ex9Var = new ex9(this.b.getUniqueId(), new t0(this), new u0(this));
            this.g2 = ex9Var;
            registerListener(ex9Var.d());
            this.H = new PbGodGuideController();
            getLifecycle().addObserver(this.H);
            iu4.a().c(this.A0);
            iu4.a().c(this.B0);
            registerListener(this.B1);
            registerListener(this.D1);
            registerListener(this.E1);
            registerListener(this.A1);
            registerListener(this.e2);
            registerListener(this.f2);
            registerListener(this.v2);
            registerListener(this.z1);
            ewa ewaVar = new ewa("pb", ewa.d);
            this.X0 = ewaVar;
            ewaVar.d();
            registerListener(this.K1);
            registerListener(this.U1);
            this.C0.x2();
            registerListener(this.u2);
            registerListener(this.i2);
            registerListener(this.o2);
            registerListener(this.Q1);
            registerListener(this.h2);
            registerListener(this.L1);
            j1a j1aVar4 = this.J0;
            if (j1aVar4 != null && j1aVar4.t1() != null && this.J0.q1() != null) {
                w2a w2aVar = new w2a(getActivity(), this.J0.t1(), this.J0.q1(), this.J0.i1());
                this.f = w2aVar;
                w2aVar.t(this.T1);
            }
            if (this.d && (j1aVar = this.J0) != null && j1aVar.q1() != null) {
                this.J0.q1().setVisibility(8);
            }
            i55 i55Var = new i55();
            this.j1 = i55Var;
            i55Var.a = 1000L;
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
            this.N0 = new m1a();
            if (this.Z0.v() != null) {
                this.N0.m(this.Z0.v().k());
            }
            this.Z0.Z(this.e1);
            this.I0 = new ShareSuccessReplyToServerModel();
            i6(this.x1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.b1 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new w0(this));
            d5a d5aVar = new d5a(getContext());
            this.D0 = d5aVar;
            d5aVar.b(getUniqueId());
            qua.g().i(getUniqueId());
            xv4.b().l("3", "");
            this.w1 = new hl6(getPageContext());
            this.v0 = new l3a(this, getUniqueId(), this.J0, this.C0);
            this.w0 = new PushPermissionController(getActivity(), getPageContext());
            if (!TbSingleton.getInstance().hasDownloadEmotion() && BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.p = System.currentTimeMillis() - this.o;
            bp5.a.e(getUniqueId(), this);
            bp5.a.g(getUniqueId());
        }
    }

    public final boolean z6(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        gr4 gr4Var;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i4;
        i05 i05Var;
        BdImage bdImage;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048800, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext())) {
                return true;
            }
            j1a j1aVar = this.J0;
            if (j1aVar != null) {
                if (j1aVar.c2()) {
                    return true;
                }
                this.J0.C0();
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (i1a.u(view2)) {
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
                        this.J0.i4(this.G2, this.n1.isGif());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            nwa nwaVar = (nwa) sparseArray.get(R.id.tag_clip_board);
            this.E2 = nwaVar;
            if (nwaVar == null) {
                return true;
            }
            if (nwaVar.L() == 1 && i1a.u(view2)) {
                this.J0.i4(this.G2, this.n1.isGif());
                return true;
            } else if (this.E2.E0() || (gr4Var = this.E0) == null) {
                return true;
            } else {
                if (gr4Var.e() && this.E2.U() != null && this.E2.U().equals(this.C0.n1())) {
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
                if (this.E2.L() == 1) {
                    if (!z4) {
                        this.J0.j4(this.F2, z3, false, z5, z6);
                    }
                    return true;
                }
                if (this.P0 == null) {
                    m05 m05Var = new m05(getContext());
                    this.P0 = m05Var;
                    m05Var.r(this.l2);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 != null && sparseArray != null) {
                    if (i1a.u(view2) && !z4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (i1a.u(view2) && (bdImage = this.n1) != null && !bdImage.isGif()) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    boolean b4 = k4a.b(sparseArray, R.id.tag_is_subpb, false);
                    boolean b5 = k4a.b(sparseArray, R.id.tag_del_post_is_self, false);
                    boolean b6 = k4a.b(sparseArray, R.id.tag_user_mute_visible, false);
                    boolean b7 = k4a.b(sparseArray, R.id.tag_should_manage_visible, false);
                    boolean b8 = k4a.b(sparseArray, R.id.tag_user_mute_visible, false);
                    boolean b9 = k4a.b(sparseArray, R.id.tag_should_delete_visible, false);
                    boolean b10 = k4a.b(sparseArray, R.id.tag_is_self_post, false);
                    boolean b11 = k4a.b(sparseArray, R.id.tag_mul_del_post_type, false);
                    String c4 = k4a.c(sparseArray, R.id.tag_forbid_user_post_id, "");
                    if (z7) {
                        arrayList.add(new i05(1, getString(R.string.save_to_emotion), this.P0));
                    }
                    if (z8) {
                        arrayList.add(new i05(2, getString(R.string.save_to_local), this.P0));
                    }
                    if (!z7 && !z8) {
                        i05 i05Var2 = new i05(3, getString(R.string.obfuscated_res_0x7f0f04f5), this.P0);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.tag_clip_board, this.E2);
                        i05Var2.d.setTag(sparseArray3);
                        arrayList.add(i05Var2);
                    }
                    if (!b4 && !z4) {
                        if (z3) {
                            i05Var = new i05(4, getString(R.string.remove_mark), this.P0);
                        } else {
                            i05Var = new i05(4, getString(R.string.obfuscated_res_0x7f0f0c89), this.P0);
                        }
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_clip_board, this.E2);
                        sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                        i05Var.d.setTag(sparseArray4);
                        arrayList.add(i05Var);
                    }
                    b4a.d(this.P0, b7, b6, sparseArray, arrayList, this.mIsLogin, B7());
                    b4a.e(this.P0, b7, b6, arrayList, z4, c4, this.mIsLogin, B7(), i1a.y(this.C0.s1(), b5));
                    SparseArray sparseArray5 = sparseArray;
                    b4a.b(this.P0, sparseArray5, arrayList, b5, b7, b8, b9, b10, c4, this.mIsLogin, B7());
                    b4a.a(this.P0, sparseArray5, arrayList, b5, b7, b8, b9, b10, c4, this.mIsLogin, B7(), this.C0.s1().Z());
                    b4a.c(this.P0, arrayList, b7, b9, b11, this.mIsLogin);
                    k4a.a(arrayList, this.P0, this.E2, this.C0.s1(), TbadkCoreApplication.isLogin());
                    List<i05> b12 = e4a.b(arrayList, this.E2.p(), sparseArray, this.P0, this.E2.t());
                    e4a.i(b12, this.c);
                    e4a.d(b12);
                    this.P0.s(e4a.f(this.E2));
                    this.P0.n(b12, true);
                    this.O0 = new k05(getPageContext(), this.P0);
                    this.P0.q(new g3(this));
                    this.O0.l();
                    StatisticItem param = new StatisticItem("c13272").param("tid", this.C0.b).param("fid", this.C0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.C0.Q());
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
        z4a z4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048739, this) == null) {
            qua.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.C0.s1().o());
                statisticItem.param("tid", this.C0.M1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.s && this.J0 != null) {
                this.s = true;
            }
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.C0.destory();
                if (this.C0.o1() != null) {
                    this.C0.o1().d();
                }
            }
            bh5 bh5Var = this.Z0;
            if (bh5Var != null) {
                bh5Var.H();
                this.Z0 = null;
            }
            ForumManageModel forumManageModel = this.F0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.R;
            if (likeModel != null) {
                likeModel.c0();
            }
            j1a j1aVar = this.J0;
            if (j1aVar != null) {
                j1aVar.w2();
                z4a z4aVar2 = this.J0.j;
                if (z4aVar2 != null) {
                    z4aVar2.r();
                }
            }
            jp5 jp5Var = this.t;
            if (jp5Var != null) {
                jp5Var.c();
            }
            w2a w2aVar = this.f;
            if (w2aVar != null) {
                w2aVar.k();
            }
            pb<TextView> pbVar = this.z;
            if (pbVar != null) {
                pbVar.c();
            }
            pb<FestivalTipView> pbVar2 = this.I;
            if (pbVar2 != null) {
                pbVar2.c();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            j1a j1aVar2 = this.J0;
            if (j1aVar2 != null) {
                j1aVar2.s0();
            }
            if (this.Z1 != null) {
                SafeHandler.getInst().removeCallbacks(this.Z1);
            }
            if (this.g2 != null) {
                MessageManager.getInstance().unRegisterListener(this.g2.d());
            }
            iu4.a().e(this.A0);
            iu4.a().e(this.B0);
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
            j1a j1aVar3 = this.J0;
            if (j1aVar3 != null && (z4aVar = j1aVar3.j) != null) {
                z4aVar.k();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.I0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            m1a m1aVar = this.N0;
            if (m1aVar != null) {
                m1aVar.j();
            }
            PushPermissionController pushPermissionController = this.w0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.C0;
            if (pbModel2 != null && pbModel2.F0() != null) {
                this.C0.F0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.b1;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            j1a j1aVar4 = this.J0;
            if (j1aVar4 != null) {
                j1aVar4.y4();
            }
            l3a l3aVar = this.v0;
            if (l3aVar != null) {
                l3aVar.e();
            }
            bp5.a.a(getUniqueId(), new Pair<>(PushMessageHelper.ERROR_TYPE, "pb_page"), new Pair<>("error_info", "pb page unfinished destroy"));
            SpriteMemePanController.d();
        }
    }

    public void p7(boolean z3, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048753, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
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
            e9(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void w8(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048791, this, z3, markData) == null) {
            this.J0.I3();
            this.C0.g3(z3);
            gr4 gr4Var = this.E0;
            if (gr4Var != null) {
                gr4Var.h(z3);
                if (markData != null) {
                    this.E0.i(markData);
                }
            }
            if (this.C0.d1()) {
                S7();
            } else {
                this.J0.Y1(this.C0.s1());
            }
        }
    }
}
