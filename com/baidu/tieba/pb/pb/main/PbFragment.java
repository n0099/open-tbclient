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
import com.baidu.tieba.a05;
import com.baidu.tieba.ad;
import com.baidu.tieba.aiapps.TbAiappsLaunchUtil;
import com.baidu.tieba.aj6;
import com.baidu.tieba.aj9;
import com.baidu.tieba.bc5;
import com.baidu.tieba.bd9;
import com.baidu.tieba.bo9;
import com.baidu.tieba.by9;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cd5;
import com.baidu.tieba.ci;
import com.baidu.tieba.ck9;
import com.baidu.tieba.cm9;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.df5;
import com.baidu.tieba.dk9;
import com.baidu.tieba.dn9;
import com.baidu.tieba.ed9;
import com.baidu.tieba.ef5;
import com.baidu.tieba.eh9;
import com.baidu.tieba.ev4;
import com.baidu.tieba.fea;
import com.baidu.tieba.fm9;
import com.baidu.tieba.fw4;
import com.baidu.tieba.g4;
import com.baidu.tieba.gc5;
import com.baidu.tieba.gd9;
import com.baidu.tieba.gf5;
import com.baidu.tieba.gi9;
import com.baidu.tieba.gk9;
import com.baidu.tieba.gm9;
import com.baidu.tieba.gn5;
import com.baidu.tieba.gr5;
import com.baidu.tieba.h45;
import com.baidu.tieba.hf5;
import com.baidu.tieba.hna;
import com.baidu.tieba.hz4;
import com.baidu.tieba.if5;
import com.baidu.tieba.ig9;
import com.baidu.tieba.ih5;
import com.baidu.tieba.ik9;
import com.baidu.tieba.il9;
import com.baidu.tieba.in5;
import com.baidu.tieba.iz4;
import com.baidu.tieba.jk9;
import com.baidu.tieba.jm9;
import com.baidu.tieba.kd5;
import com.baidu.tieba.kf5;
import com.baidu.tieba.kj9;
import com.baidu.tieba.km9;
import com.baidu.tieba.kna;
import com.baidu.tieba.ko9;
import com.baidu.tieba.ku7;
import com.baidu.tieba.l45;
import com.baidu.tieba.lc5;
import com.baidu.tieba.li9;
import com.baidu.tieba.ll9;
import com.baidu.tieba.lm9;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.m85;
import com.baidu.tieba.mj9;
import com.baidu.tieba.mm9;
import com.baidu.tieba.mn5;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mx4;
import com.baidu.tieba.nd5;
import com.baidu.tieba.nl9;
import com.baidu.tieba.nz4;
import com.baidu.tieba.oc5;
import com.baidu.tieba.od5;
import com.baidu.tieba.oea;
import com.baidu.tieba.of9;
import com.baidu.tieba.ol9;
import com.baidu.tieba.om5;
import com.baidu.tieba.oma;
import com.baidu.tieba.oq4;
import com.baidu.tieba.ow5;
import com.baidu.tieba.ox4;
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
import com.baidu.tieba.pd5;
import com.baidu.tieba.pea;
import com.baidu.tieba.pf9;
import com.baidu.tieba.pma;
import com.baidu.tieba.pt4;
import com.baidu.tieba.pv4;
import com.baidu.tieba.pz4;
import com.baidu.tieba.qz4;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.rca;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.tieba.rf9;
import com.baidu.tieba.ri9;
import com.baidu.tieba.rw5;
import com.baidu.tieba.rz4;
import com.baidu.tieba.sa5;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.sg9;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.sj9;
import com.baidu.tieba.sva;
import com.baidu.tieba.t35;
import com.baidu.tieba.t6a;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tg9;
import com.baidu.tieba.tm5;
import com.baidu.tieba.tn4;
import com.baidu.tieba.ty4;
import com.baidu.tieba.uf5;
import com.baidu.tieba.uj9;
import com.baidu.tieba.un4;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.ut6;
import com.baidu.tieba.uu4;
import com.baidu.tieba.va5;
import com.baidu.tieba.vea;
import com.baidu.tieba.vfa;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vt6;
import com.baidu.tieba.vx5;
import com.baidu.tieba.w55;
import com.baidu.tieba.w85;
import com.baidu.tieba.wg9;
import com.baidu.tieba.wo6;
import com.baidu.tieba.ww4;
import com.baidu.tieba.xm9;
import com.baidu.tieba.xn9;
import com.baidu.tieba.xx4;
import com.baidu.tieba.ya;
import com.baidu.tieba.ye9;
import com.baidu.tieba.yh;
import com.baidu.tieba.ym5;
import com.baidu.tieba.za;
import com.baidu.tieba.ze9;
import com.baidu.tieba.zm9;
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
public class PbFragment extends BaseFragment implements rw5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, hz4.e, TbRichTextView.t, TbPageContextSupport, bo9, ko9.b, pma {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k T2;
    public static final vt6.b U2;
    public transient /* synthetic */ FieldHolder $fh;
    public ya<TbImageView> A;
    public pt4.d A0;
    public CustomMessageListener A1;
    public boolean A2;
    public ya<ImageView> B;
    public pt4.d B0;
    public CustomMessageListener B1;
    public final BdListView.p B2;
    public ya<View> C;
    public PbModel C0;
    public CustomMessageListener C1;
    public final TbRichTextView.z C2;
    public ya<TiebaPlusRecommendCard> D;
    public dn9 D0;
    public CustomMessageListener D1;
    public pea D2;
    public ya<LinearLayout> E;
    public oq4 E0;
    public CustomMessageListener E1;
    public final iz4.c E2;
    public ya<RelativeLayout> F;
    public ForumManageModel F0;
    public final CustomMessageListener F1;
    public final iz4.c F2;
    public ya<ItemCardView> G;
    public rf9 G0;
    public CustomMessageListener G1;
    public final AdapterView.OnItemClickListener G2;
    @NonNull
    public PbGodGuideController H;
    public PollingModel H0;
    public CustomMessageListener H1;
    public final View.OnLongClickListener H2;
    public ya<FestivalTipView> I;
    public ShareSuccessReplyToServerModel I0;
    public View.OnClickListener I1;
    public final View.OnClickListener I2;
    public boolean J;
    public dk9 J0;
    public CustomMessageListener J1;
    public final ItemCardHelper.c J2;
    public boolean K;
    public boolean K0;
    public CustomMessageListener K1;
    public final NoNetworkView.b K2;
    public boolean L;
    public boolean L0;
    public CustomMessageListener L1;
    public View.OnTouchListener L2;
    public ya<GifView> M;
    public boolean M0;
    public CustomMessageListener M1;
    public ut6.b M2;
    public String N;
    public gk9 N0;
    public CustomMessageListener N1;
    public final ri9.b N2;
    public boolean O;
    public pz4 O0;
    public SuggestEmotionModel.c O1;
    public int O2;
    public boolean P;
    public rz4 P0;
    public CustomMessageListener P1;
    public int P2;
    public String Q;
    public String Q0;
    public GetSugMatchWordsModel.b Q1;
    public String Q2;
    public LikeModel R;
    public boolean R0;
    public PraiseModel R1;
    public fw4 R2;
    public View S;
    public boolean S0;
    public ol9.h S1;
    public int S2;

    /* renamed from: T  reason: collision with root package name */
    public View f1142T;
    public boolean T0;
    public CustomMessageListener T1;
    public View U;
    public String U0;
    public ResponsedEventListener U1;
    public View V;
    public boolean V0;
    public ResponsedEventListener V1;
    public String W;
    public fea W0;
    public CheckRealNameModel.b W1;
    public int X;
    public if5 X0;
    public tg9 X1;
    public boolean Y;
    public hf5 Y0;
    public final Runnable Y1;
    public int[] Z;
    public PermissionJudgePolicy Z0;
    public CustomMessageListener Z1;
    public final BdUniqueId a;
    public int a0;
    public ReplyPrivacyCheckController a1;
    public CustomMessageListener a2;
    public AbsPbActivity b;
    public int b0;
    public lm9 b1;
    public CustomMessageListener b2;
    public boolean c;
    public int c0;
    public ef5 c1;
    public CustomMessageListener c2;
    public boolean d;
    public xx4 d0;
    public df5 d1;
    public CustomMessageListener d2;
    public vt6 e;
    public BdUniqueId e0;
    public df5 e1;
    public CustomMessageListener e2;
    public ol9 f;
    public t35 f0;
    public int f1;
    public ig9 f2;
    public boolean g;
    public boolean g0;
    public Object g1;
    public CustomMessageListener g2;
    public boolean h;
    public boolean h0;
    public BdPageContext h1;
    public CustomMessageListener h2;
    public boolean i;
    public Object i0;
    public h45 i1;
    public hz4.e i2;
    public VoiceManager j;
    public AgreeMessageData j0;
    public BdUniqueId j1;
    public i3 j2;
    public int k;
    public Runnable k1;
    public rz4.f k2;
    public iz4 l;
    public ik9 l1;
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
    public long q;
    public boolean q1;
    public NewWriteModel.d q2;
    public boolean r;
    public sa5 r0;
    public int r1;
    public NetMessageListener r2;
    public boolean s;
    public boolean s0;
    public int s1;
    public final PbModel.h s2;
    public gn5 t;
    public boolean t0;
    public List<g3> t1;
    public CustomMessageListener t2;
    public long u;
    @NonNull
    public TiePlusEventController.g u0;
    public int u1;
    public HttpMessageListener u2;
    public boolean v;
    public cm9 v0;
    public aj6 v1;
    public final oq4.a v2;
    public long w;
    public PushPermissionController w0;
    public final g3 w1;
    public final AbsListView.OnScrollListener w2;
    public int x;
    public boolean x0;
    public final kj9.b x1;
    public final g4 x2;
    public String y;
    public PbInterviewStatusView.f y0;
    public final CustomMessageListener y1;
    public final l45.g y2;
    public ya<TextView> z;
    public final Handler z0;
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

    @Override // com.baidu.tieba.pma
    @NonNull
    public String I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? "pd_landing_page" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bo9
    public PbFragment S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pma
    @NonNull
    public String V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? "pb" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bo9
    public AbsVideoPbFragment a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return null;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public void m0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048732, this, context, str) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048762, this, view2, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048781, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView v1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048786, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public void x1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048794, this, context, str) == null) {
        }
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
                    wg9.a(this.b.a.getPageContext(), this.a).show();
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.J0 != null && this.a != null) {
                    this.b.a.J0.b3(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements hz4.e {
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

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                    hz4Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements hz4.e {
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

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                    hz4Var.dismiss();
                    km9.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m85 m85Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m85Var, writeData, antiData}) == null) {
                if (!ad.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.C0.s1() != null) {
                        statisticItem.param("fid", this.a.C0.s1().l());
                    }
                    statisticItem.param("tid", this.a.C0.M1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (ad.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.C8();
                this.a.J0.Q3(z, postWriteCallBackData);
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
                        if (this.a.Y0 != null && (this.a.Y0.z() || this.a.Y0.B())) {
                            this.a.Y0.x(false, postWriteCallBackData);
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
                        if (ad.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        hz4 hz4Var = new hz4(this.a.getActivity());
                        if (ad.isEmpty(postWriteCallBackData.getErrorString())) {
                            hz4Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            hz4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new b(this));
                        hz4Var.setPositiveButton(R.string.open_now, new c(this));
                        hz4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (m85Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.k8(i, antiData, str);
                        return;
                    }
                }
                this.a.v8(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.l8(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData != null && writeData.getType() == 2) {
                    if (floor != null) {
                        this.a.J0.g2(this.a.C0.s1());
                    }
                } else if (this.a.C0.V0()) {
                    ye9 s1 = this.a.C0.s1();
                    if (s1 != null && s1.O() != null && s1.O().getAuthor() != null && (userId = s1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.C0.j3()) {
                        this.a.J0.S3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.C0.j3()) {
                    this.a.J0.S3();
                }
                if (this.a.C0.Z0()) {
                    xn9.t("c10369", this.a.C0.M1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.C0 != null) {
                    Context context = this.a.getContext();
                    ye9 s12 = this.a.C0.s1();
                    String forumId = this.a.C0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    ck9.b(context, s12, forumId, z2, this.a.C0.y1(), this.a.C0.B1(), this.a.C0.A1(), this.a.C0.z1(), this.a.C0.F1(), this.a.C0.G1());
                }
                if (writeData != null) {
                    w55.b(writeData.getContent(), "1");
                }
                if (this.a.X6()) {
                    this.a.J8();
                }
                this.a.s8();
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
                    this.b.a.J0.b3(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements hz4.e {
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

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                    hz4Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements hz4.e {
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

            @Override // com.baidu.tieba.hz4.e
            public void onClick(hz4 hz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                    hz4Var.dismiss();
                    km9.a(this.a.a.getPageContext());
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m85 m85Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m85Var, writeData, antiData}) == null) {
                if (!ad.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.C0 != null && this.a.C0.s1() != null) {
                        statisticItem.param("fid", this.a.C0.s1().l());
                    }
                    if (this.a.C0 != null) {
                        statisticItem.param("tid", this.a.C0.M1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.v6()) {
                        this.a.d8(false);
                        ed9.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14aa));
                    }
                    gk9 gk9Var = this.a.N0;
                    if (gk9Var != null) {
                        gk9Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        va5.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        w55.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.X6()) {
                        this.a.J8();
                    }
                    this.a.s8();
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
                    if (ad.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                    } else {
                        DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    hz4 hz4Var = new hz4(this.a.getActivity());
                    if (ad.isEmpty(postWriteCallBackData.getErrorString())) {
                        hz4Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        hz4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new b(this));
                    hz4Var.setPositiveButton(R.string.open_now, new c(this));
                    hz4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbFragment pbFragment = this.a;
                    if (pbFragment.N0 != null) {
                        if (pbFragment.J0 != null && this.a.J0.x1() != null && this.a.J0.x1().f() != null && this.a.J0.x1().f().A()) {
                            this.a.J0.x1().f().x(postWriteCallBackData);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.j1) {
                this.a.J0.N1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                ye9 s1 = this.a.C0.s1();
                if (s1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    s1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.i1.d(this.a.h1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.h1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.x8(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ad.isEmpty(errorString2)) {
                        errorString2 = this.a.h1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.i1.c(errorString2);
                } else {
                    this.a.p8();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a2 implements pt4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.pt4.d
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

        @Override // com.baidu.tieba.pt4.c
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
                        if (this.a.D2.r() != null) {
                            BdToastHelper.toast(sva.a(this.a.D2.r().feedback_toast));
                        }
                    }
                } finally {
                    this.a.D2 = null;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a3 implements iz4.c {
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

        @Override // com.baidu.tieba.iz4.c
        public void a(iz4 iz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iz4Var, i, view2) == null) {
                if (iz4Var != null) {
                    iz4Var.e();
                }
                if (this.a.m1 != null && !TextUtils.isEmpty(this.a.n1)) {
                    if (i == 0) {
                        if (this.a.p1 != null) {
                            ih5.a aVar = new ih5.a();
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
                            pbFragment.l1 = new ik9(pbFragment.getPageContext());
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
        public void l(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.g && z && !this.a.C0.h1()) {
                    this.a.S7();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ww4)) {
                ww4 ww4Var = (ww4) customResponsedMessage.getData();
                ox4.a aVar = new ox4.a();
                int i = ww4Var.a;
                String str = ww4Var.b;
                aVar.a = ww4Var.d;
                ye9 s1 = this.a.C0.s1();
                if (s1 == null) {
                    return;
                }
                if (this.a.C0.U0() != null && this.a.C0.U0().getUserIdLong() == ww4Var.p) {
                    this.a.J0.i3(ww4Var.l, this.a.C0.s1(), this.a.C0.L1(), this.a.C0.D1());
                }
                if (s1.F() != null && s1.F().size() >= 1 && s1.F().get(0) != null) {
                    long j = JavaTypesHelper.toLong(s1.F().get(0).U(), 0L);
                    long j2 = JavaTypesHelper.toLong(this.a.C0.M1(), 0L);
                    if (j == ww4Var.n && j2 == ww4Var.m) {
                        ox4 S = s1.F().get(0).S();
                        if (S == null) {
                            S = new ox4();
                        }
                        ArrayList<ox4.a> a = S.a();
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        a.add(0, aVar);
                        S.e(S.b() + ww4Var.l);
                        S.d(a);
                        s1.F().get(0).a1(S);
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
                this.a.J0.N1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.i1.d(this.a.h1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ad.isEmpty(muteMessage)) {
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
                    pbFragment.hideLoadingView(pbFragment.J0.G1());
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
                    this.a.h8(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e4f);
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
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.C0 == null || this.a.C0.C1() == i + 1) {
                return;
            }
            this.a.b8(ck9.q(i));
        }
    }

    /* loaded from: classes7.dex */
    public class c implements za<LinearLayout> {
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
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
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
        @Override // com.baidu.tieba.za
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof vx5)) {
                vx5 vx5Var = (vx5) customResponsedMessage.getData();
                ye9 s1 = this.a.C0.s1();
                if (s1 == null) {
                    return;
                }
                if (this.a.C0.s1() != null && this.a.C0.s1().X().t() != null && this.a.C0.s1().X().t().getPortrait() != null && this.a.C0.s1().X().t().getPortrait().equals(vx5Var.a)) {
                    if (this.a.C0.s1().X().t().getUserWorldCupData() != null) {
                        this.a.C0.s1().X().t().getUserWorldCupData().c(vx5Var.b);
                    }
                    this.a.J0.j3(this.a.C0.s1(), this.a.C0.L1(), this.a.C0.D1(), this.a.J0.B1());
                }
                if (s1.F() != null && s1.F().size() >= 0) {
                    Iterator<pea> it = s1.F().iterator();
                    while (it.hasNext()) {
                        pea next = it.next();
                        if (next != null && next.t() != null && next.t().getPortrait() != null && next.t().getPortrait().equals(vx5Var.a) && next.t().getUserWorldCupData() != null) {
                            next.t().getUserWorldCupData().c(vx5Var.b);
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
                if (!this.a.X6() || this.a.b == null || this.a.b.J1() == null || !str.equals(this.a.b.J1().getTopicId())) {
                    return;
                }
                this.a.K8(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c2 implements oq4.a {
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

        @Override // com.baidu.tieba.oq4.a
        public void a(boolean z, boolean z2, String str, @Nullable String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2}) == null) {
                this.a.J0.R3();
                if (z) {
                    if (this.a.E0 != null) {
                        this.a.E0.h(z2);
                    }
                    this.a.C0.i3(z2);
                    if (!this.a.C0.d1()) {
                        this.a.J0.g2(this.a.C0.s1());
                    } else {
                        this.a.n7();
                    }
                    if (z2) {
                        boolean p0 = this.a.C0.s1().p0();
                        if (this.a.E0 != null && !p0) {
                            if (this.a.E0.f() != null && this.a.C0 != null && this.a.C0.s1() != null && this.a.C0.s1().O() != null && this.a.C0.s1().O().getAuthor() != null) {
                                MarkData f = this.a.E0.f();
                                MetaData author = this.a.C0.s1().O().getAuthor();
                                if (f != null && author != null) {
                                    if (str2 == null) {
                                        str2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f00ff);
                                    }
                                    BdUtilHelper.showToast(str2, 2000, true);
                                    this.a.t8();
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
                        this.a.E5();
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
    public class c3 implements rz4.d {
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

        @Override // com.baidu.tieba.rz4.d
        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.P0 != null) {
                this.a.P0.s(fm9.h(this.a.D2));
                ArrayList arrayList = new ArrayList();
                for (qz4 qz4Var : this.a.P0.h()) {
                    if (qz4Var instanceof nz4) {
                        arrayList.add((nz4) qz4Var);
                    }
                }
                fm9.f(arrayList);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.C0 != null && this.a.C0.s1() != null) {
                this.a.C0.s1().a();
                this.a.C0.X1();
                if (this.a.J0.T0() != null) {
                    this.a.J0.g2(this.a.C0.s1());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof kna) && customResponsedMessage.getOrginalMessage().getTag() == this.a.j1) {
                kna knaVar = (kna) customResponsedMessage.getData();
                this.a.J0.N1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.g1;
                DataRes dataRes = knaVar.a;
                boolean z = false;
                if (knaVar.c == 0 && dataRes != null) {
                    int i = JavaTypesHelper.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (i == 1) {
                        z = true;
                    }
                    if (ad.isEmpty(str)) {
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
                        this.a.J0.X2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.q8(z, sparseArray);
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
            ArrayList<pea> F;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.C0 != null && this.a.C0.s1() != null && this.a.J0 != null && this.a.J0.T0() != null) {
                this.a.J0.Q2(absListView, i, i2, i3);
                if (this.a.f != null) {
                    this.a.f.q(absListView, i, i2, i3);
                }
                if (this.a.C0.h2() && (F = this.a.C0.s1().F()) != null && !F.isEmpty()) {
                    int y = ((i + i2) - this.a.J0.T0().y()) - 1;
                    ye9 s1 = this.a.C0.s1();
                    if (s1 == null) {
                        return;
                    }
                    if (s1.C() != null && s1.C().D1()) {
                        y--;
                    }
                    if (s1.D() != null && s1.D().D1()) {
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
                if (!ck9.B(this.a.f1) && ck9.B(i)) {
                    if (this.a.J0 != null) {
                        this.a.s0 = true;
                        this.a.J0.F0();
                        if (this.a.Y0 != null && !this.a.J0.i2()) {
                            this.a.J0.x3(this.a.Y0.A());
                        }
                        if (!this.a.K) {
                            this.a.s0 = true;
                            this.a.J0.p3();
                        }
                    }
                    if (!this.a.s) {
                        this.a.s = true;
                    }
                }
                if (this.a.J0 != null) {
                    this.a.J0.R2(absListView, i);
                }
                if (this.a.f != null) {
                    this.a.f.r(absListView, i);
                }
                if (this.a.t == null) {
                    this.a.t = new gn5();
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
                this.a.f1 = i;
                if (i == 0) {
                    rca.g().h(this.a.getUniqueId(), true);
                    this.a.M5(true);
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
                pbFragment.c = true;
                return pbFragment.V5(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ut6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.ut6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.ut6.b
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

        @Override // com.baidu.tieba.ut6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.J0 != null && this.b.f != null) {
                this.b.f.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.f.l();
                }
                if (this.b.u6()) {
                    this.b.J0.O1();
                    this.b.J0.q3();
                }
            }
        }

        @Override // com.baidu.tieba.ut6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.J0 != null && this.b.f != null) {
                this.b.J0.A4();
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
            oea j;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.C0 != null && this.a.C0.s1() != null) {
                String str = (String) customResponsedMessage.getData();
                oea oeaVar = null;
                if (!TextUtils.isEmpty(str) && this.a.C0.s1().F() != null) {
                    ArrayList<pea> F = this.a.C0.s1().F();
                    Iterator<pea> it = F.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        pea next = it.next();
                        if (next instanceof oea) {
                            oea oeaVar2 = (oea) next;
                            if (str.equals(oeaVar2.E1())) {
                                oeaVar = oeaVar2;
                                break;
                            }
                        }
                    }
                    if (oeaVar != null) {
                        F.remove(oeaVar);
                    }
                }
                if (this.a.J0.T0() != null && !ListUtils.isEmpty(this.a.J0.T0().v())) {
                    ArrayList<yh> v = this.a.J0.T0().v();
                    if (oeaVar != null) {
                        j = oeaVar;
                    } else {
                        j = ck9.j(this.a.C0.s1(), str);
                    }
                    ck9.f(v, j);
                }
                if (this.a.J0.m1() != null && !ListUtils.isEmpty(this.a.J0.m1().getData())) {
                    List<yh> data = this.a.J0.m1().getData();
                    if (oeaVar == null) {
                        oeaVar = ck9.j(this.a.C0.s1(), str);
                    }
                    ck9.f(data, oeaVar);
                }
                this.a.X5(str);
                this.a.C0.X1();
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
        public void onNavigationButtonClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hz4Var) == null) {
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
    public class f implements vt6.b {
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

        @Override // com.baidu.tieba.vt6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    sg9.d();
                } else {
                    sg9.c();
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
            this.a.Y5();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.J0.i2() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.d6((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
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
        public void onNavigationButtonClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f3 implements df5 {
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

        @Override // com.baidu.tieba.df5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                gk9 gk9Var = this.a.N0;
                if (gk9Var != null && gk9Var.g() != null && this.a.N0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.N0.g().c());
                    if (this.a.J0 != null && this.a.J0.x1() != null && this.a.J0.x1().f() != null && this.a.J0.x1().f().A()) {
                        this.a.J0.x1().f().x(this.a.N0.h());
                    }
                    this.a.N0.b(true);
                    return true;
                }
                return !this.a.R5(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements ri9.b {
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

        @Override // com.baidu.tieba.ri9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f17ab);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e4f);
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
        public void a(ll9 ll9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, ll9Var) != null) || ll9Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, ll9Var.a()));
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
                    this.a.J0.D2(agreeMessageData);
                }
                if (agreeData.agreeType == 2 && this.a.J0 != null && !mm9.g(this.a.C0.b)) {
                    this.a.J0.F4();
                    mm9.a(this.a.C0.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g2 extends g4 {
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

        @Override // com.baidu.tieba.g4
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
                        this.a.j6(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
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
                        pbFragment.k6(pbFragment.F0.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        this.a.J0.O0(this.a.F0.getLoadDataMode(), gVar.a, gVar.b, false);
                        this.a.J0.S2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.J0.O0(this.a.F0.getLoadDataMode(), false, null, false);
        }
    }

    /* loaded from: classes7.dex */
    public class h implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    hz4Var.dismiss();
                    ((TbPageContext) this.a.h1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                hz4Var.dismiss();
                km9.a(this.a.getPageContext());
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
                        this.a.B7();
                        return;
                    } else {
                        this.a.X7();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.E6() != null) {
                this.a.E6().N2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h2 implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) && hz4Var != null) {
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class h3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<dk9> a;
        public WeakReference<PbFragment> b;

        public h3(dk9 dk9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(dk9Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                dk9 dk9Var = this.a.get();
                if (dk9Var != null) {
                    dk9Var.N1();
                }
                PbFragment pbFragment = this.b.get();
                if (pbFragment != null && CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        pbFragment.w8(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        ku7.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0e4f);
                        }
                        pbFragment.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
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
                this.a.J0.H4(!this.a.O);
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
    public class i2 implements l45.g {
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

        @Override // com.baidu.tieba.l45.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.u6()) {
                    this.a.b.finish();
                }
                if (this.a.C0.r2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.J0.N0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
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
                this.a.J0.X3(list);
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
    public class j1 implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                this.a.P6();
                mx4 q1 = this.a.C0.q1();
                int u1 = this.a.J0.u1();
                if (u1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f1017);
                } else if (q1 != null && u1 > q1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f1017);
                } else {
                    this.a.J0.F0();
                    this.a.C8();
                    this.a.J0.S3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.C0.g3(this.a.J0.u1());
                        if (this.a.f != null) {
                            this.a.f.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e4f);
                    }
                    hz4Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j2 implements ef5 {
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

        @Override // com.baidu.tieba.ef5
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
                if (this.a.J0 != null && this.a.J0.x1() != null) {
                    aj9 x1 = this.a.J0.x1();
                    if (x1.j()) {
                        x1.h();
                        return true;
                    }
                }
                if (this.a.J0 != null && this.a.J0.x2()) {
                    this.a.J0.R1();
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
            ye9 s1 = this.a.C0.s1();
            if (s1.O().getPraise().getIsLike() == 1) {
                this.a.O8(0);
            } else {
                this.a.O8(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, s1.O()));
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
                String valueOf = String.valueOf(this.a.C0.s1().V().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.C0.s1().k().getId(), this.a.C0.s1().k().getName(), this.a.C0.s1().O().getId(), valueOf, str, str3, str2, str4)));
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
                if (this.a.u6()) {
                    this.a.b.finish();
                }
                if (this.a.C0.r2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.J0.N0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                this.b.J0.s4();
                MessageManager.getInstance().sendMessage(this.a);
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 implements ol9.h {
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

        @Override // com.baidu.tieba.ol9.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.f8(z);
                if (this.a.J0.j1() != null && z) {
                    this.a.J0.H4(false);
                }
                this.a.J0.K2(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l1 implements rz4.f {
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

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
                if (this.a.O0 != null) {
                    this.a.O0.dismiss();
                }
                this.a.L8(i);
                if (i != -4) {
                    if (i != -3) {
                        if (i != -2) {
                            if (i != -1) {
                                if (i != 13) {
                                    switch (i) {
                                        case 1:
                                            if (this.a.m1 != null && !TextUtils.isEmpty(this.a.n1)) {
                                                if (this.a.p1 != null) {
                                                    ih5.a aVar = new ih5.a();
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
                                                    pbFragment.l1 = new ik9(pbFragment.getPageContext());
                                                }
                                                this.a.l1.b(this.a.n1, this.a.m1.getImageByte());
                                                this.a.m1 = null;
                                                this.a.n1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            pea peaVar = this.a.D2;
                                            if (peaVar != null) {
                                                peaVar.S0();
                                                this.a.D2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.r7(view2);
                                            if (this.a.C0.s1().O() != null && this.a.C0.s1().O().getAuthor() != null && this.a.C0.s1().O().getAuthor().getUserId() != null && this.a.E0 != null) {
                                                xn9.E(2, ck9.v(this.a.C0.s1()), !this.a.E0.e(), this.a.C0);
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
                                                this.a.M6((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray2.put(R.id.tag_from, 0);
                                                    sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                    this.a.O5(sparseArray2);
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
                                                boolean S = this.a.l0().S(TbadkCoreApplication.getCurrentAccount());
                                                if (S) {
                                                    if (booleanValue2) {
                                                        this.a.J0.V2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, S);
                                                        return;
                                                    } else {
                                                        this.a.m8(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.J0.T2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                                    return;
                                                } else {
                                                    this.a.m8(sparseArray3, intValue, booleanValue);
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
                                                    this.a.O5(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                }
                                                this.a.J0.Y2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.J0.T2(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            pea peaVar2 = (pea) sparseArray.get(R.id.tag_clip_board);
                                            if (peaVar2.p() == null) {
                                                return;
                                            }
                                            this.a.S5(peaVar2.p());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.C0 != null && this.a.C0.s1() != null) {
                                                this.a.b.T1(hna.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.C0 != null && this.a.C0.s1() != null) {
                                    this.a.J0.a5(true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            if (view3 == null) {
                                return;
                            }
                            this.a.O7(view3);
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
                            this.a.O7(view4);
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
                    this.a.O7(view5);
                    if (view5 != null) {
                        if (sparseArray5 != null && (sparseArray5.get(R.id.tag_is_top_question) instanceof Boolean)) {
                            this.a.d8(((Boolean) sparseArray5.get(R.id.tag_is_top_question)).booleanValue());
                        }
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.O7(view6);
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
                if (this.a.A2 && this.a.u6()) {
                    this.a.i7();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (this.a.J0 != null) {
                    this.a.J0.r3();
                }
                if (!this.a.g0 && this.a.J0 != null && this.a.J0.v0() && this.a.C0 != null) {
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
                if (this.a.C0.p2(false)) {
                    this.a.J0.T3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (this.a.C0.s1() != null) {
                    this.a.J0.l3();
                }
                this.a.A2 = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements rz4.f {
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

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
                if (this.e.O0 != null) {
                    this.e.O0.dismiss();
                }
                if (i == 0) {
                    this.e.J0.T2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.j1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.j1);
                    this.e.y8(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m1 implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                if (hz4Var != null) {
                    hz4Var.dismiss();
                }
                this.d.b6(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.C0 != null) {
                this.a.C0.loadData();
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
            gk9 gk9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (gk9Var = this.a.N0) != null && gk9Var.g() != null) {
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
                    if (updateAttentionMessage.getOrginalMessage().getTag() == this.a.getUniqueId() && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().blockData, PbFragment.T2) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                        return;
                    }
                    return;
                }
                if (updateAttentionMessage.getData().isSucc) {
                    if (this.a.p6().t() != null && this.a.p6().t().getGodUserData() != null) {
                        this.a.p6().t().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.C0 != null && this.a.C0.s1() != null && this.a.C0.s1().O() != null && this.a.C0.s1().O().getAuthor() != null) {
                        this.a.C0.s1().O().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
                if (updateAttentionMessage.isAttention()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921760, 10));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n1 implements hz4.e {
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

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements kj9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.kj9.b
        public void onSuccess(List<pea> list) {
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

        @Override // com.baidu.tieba.kj9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.J0.L4(str);
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
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.lk5
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
                this.a.J0.F0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.C0 != null && !this.a.C0.isLoading) {
                    this.a.C8();
                    this.a.J0.S3();
                    z = true;
                    if (this.a.C0.s1() != null && this.a.C0.s1().f != null && this.a.C0.s1().f.size() > i) {
                        int intValue = this.a.C0.s1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.C0.N1()).param("fid", this.a.C0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.C0.m3(intValue)) {
                            this.a.i = true;
                            this.a.J0.H3(true);
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class o2 implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ hz4 c;
        public final /* synthetic */ PbFragment d;

        public o2(PbFragment pbFragment, MarkData markData, MarkData markData2, hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, hz4Var};
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
            this.c = hz4Var;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
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
                this.d.D8();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.C0 != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.Y0 != null) {
                    this.a.J0.x3(this.a.Y0.A());
                }
                this.a.J0.p3();
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
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.lk5
        /* renamed from: g */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                if (this.a.J0 != null && topToastEvent != null) {
                    new BdTopToast(this.a.getContext()).setIcon(topToastEvent.isSuccess()).setContent(topToastEvent.getContent()).show(this.a.J0.G1());
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class p1 implements pt4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.pt4.d
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

        @Override // com.baidu.tieba.pt4.c
        public void a(@NonNull String str) {
            pea X;
            bc5 b0;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("PbFragment", "收到H5通知，更新Pb数据：" + str);
                if (this.a.C0 == null) {
                    return;
                }
                this.a.C0.loadData();
                ye9 s1 = this.a.C0.s1();
                if (s1 != null && (X = s1.X()) != null && (b0 = X.b0()) != null && !b0.n()) {
                    om5 om5Var = new om5();
                    om5Var.t(b0);
                    String Q = s1.Q();
                    String l = s1.l();
                    if (s1.O() != null) {
                        i = s1.O().getThreadType();
                    } else {
                        i = 0;
                    }
                    om5Var.v(Q, l, i, this.a.C0.L0(), this.a.C0.x1(), b0.d());
                    String x = om5Var.x(b0.e());
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(NovelWebViewActivityConfig.KEY_IS_SHOW_TOAST_TIP, true);
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_ID, String.valueOf(b0.h()));
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_TID, om5Var.i());
                    bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_FID, om5Var.e());
                    BrowserHelper.startWebActivity(this.a.getContext(), "", x, true, true, true, bundle);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921658, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p2 implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ hz4 b;
        public final /* synthetic */ PbFragment c;

        public p2(PbFragment pbFragment, MarkData markData, hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, hz4Var};
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
            this.b = hz4Var;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.b.setResult(-1, intent);
                this.b.dismiss();
                this.c.D8();
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
            this.a.C0.p3((UserPendantData) customResponsedMessage.getData());
            if (this.a.J0 != null && this.a.C0 != null) {
                this.a.J0.j3(this.a.C0.s1(), this.a.C0.L1(), this.a.C0.D1(), this.a.J0.B1());
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
            dk9 dk9Var = this.b.J0;
            dk9Var.V3("@" + this.a.getStringExtra("big_pic_type") + " ");
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
            this.c.u8(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class q2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ hz4 b;
        public final /* synthetic */ PbFragment c;

        public q2(PbFragment pbFragment, MarkData markData, hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, hz4Var};
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
            this.b = hz4Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.J0 != null && this.c.J0.G1() != null) {
                    this.c.J0.G1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.b.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.D8();
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
                if (this.a.J0 == null) {
                    return;
                }
                if (booleanValue) {
                    this.a.J0.C4();
                } else {
                    this.a.J0.P1();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r0 implements Function0<ArrayList<yh>> {
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
        public ArrayList<yh> invoke() {
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
            this.c.u8(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class r2 implements za<ImageView> {
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
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
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
                    if (uu4.c().g()) {
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
        @Override // com.baidu.tieba.za
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = uu4.c().g();
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
                this.a.J0.x3(this.a.Y0.A());
            }
            this.a.J0.k4(false);
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
    public class s1 implements rz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz4 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ PbFragment c;

        public s1(PbFragment pbFragment, pz4 pz4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, pz4Var, view2};
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
            this.a = pz4Var;
            this.b = view2;
        }

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
                this.a.dismiss();
                PbModel pbModel = this.c.C0;
                if (this.b.getId() == R.id.obfuscated_res_0x7f091b75) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                xn9.K(i, pbModel, i2);
                if (this.c.C0.s1().f != null && this.c.C0.s1().f.size() > i) {
                    i = this.c.C0.s1().f.get(i).sort_type.intValue();
                }
                boolean m3 = this.c.C0.m3(i);
                this.b.setTag(Integer.valueOf(this.c.C0.J1()));
                if (!m3) {
                    return;
                }
                this.c.i = true;
                this.c.J0.H3(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s2 implements za<GifView> {
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
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
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
                if (uu4.c().g()) {
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
        @Override // com.baidu.tieba.za
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = uu4.c().g();
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
                gd9 gd9Var = (gd9) customResponsedMessage.getData();
                int b = gd9Var.b();
                if (b != 0) {
                    if (b != 1) {
                        if (b == 2) {
                            if (gd9Var.a() == null) {
                                this.a.Q7(false, null);
                                return;
                            } else {
                                this.a.Q7(true, (MarkData) gd9Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.j6((ForumManageModel.b) gd9Var.a(), false);
                    return;
                }
                this.a.R7((pf9) gd9Var.a());
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
                if (message.what == 2 && this.a.C0 != null && this.a.C0.d1()) {
                    this.a.n7();
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
                if (this.a.t0 && (view2 == this.a.J0.k.e || view2 == this.a.J0.k.f || view2.getId() == R.id.obfuscated_res_0x7f091b51 || view2.getId() == R.id.obfuscated_res_0x7f090b89 || view2.getId() == R.id.obfuscated_res_0x7f091f13 || view2.getId() == R.id.obfuscated_res_0x7f091ae9)) {
                    return;
                }
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.J0.q1()) {
                        this.a.t7();
                    }
                } else {
                    this.a.W7(view2);
                }
                if (view2 == this.a.J0.s1()) {
                    if (this.a.i || !this.a.C0.p2(true)) {
                        return;
                    }
                    this.a.i = true;
                    this.a.J0.T3();
                } else if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().B()) {
                    if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().g()) {
                        if (view2 == this.a.J0.k.h) {
                            if (!this.a.J0.u0(this.a.C0.f1())) {
                                BdUtilHelper.hideSoftKeyPad(this.a.b, this.a.J0.k.h);
                                this.a.b.finish();
                                return;
                            }
                            this.a.C8();
                            return;
                        } else if (view2 != this.a.J0.X0() && (this.a.J0.k.i() == null || (view2 != this.a.J0.k.i().C() && view2 != this.a.J0.k.i().D()))) {
                            if (view2 == this.a.J0.f1()) {
                                if (this.a.C0 != null) {
                                    BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), this.a.C0.s1().O().getTopicData().b());
                                    return;
                                }
                                return;
                            } else if (view2 != this.a.J0.k.e) {
                                if (view2 != this.a.J0.k.f) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f091b10) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091ae4) {
                                            if ((this.a.J0.k.i() == null || view2 != this.a.J0.k.i().z()) && view2.getId() != R.id.obfuscated_res_0x7f090b89 && view2.getId() != R.id.obfuscated_res_0x7f091f13) {
                                                if (this.a.J0.k.i() != null && view2 == this.a.J0.k.i().t()) {
                                                    this.a.J0.k.f();
                                                    return;
                                                } else if (view2.getId() == R.id.share_num_container) {
                                                    if (!ck9.d(this.a.getPageContext(), 11009)) {
                                                        return;
                                                    }
                                                    ck9.w(this.a.getContext(), 3, this.a.o6(), this.a.C0);
                                                    return;
                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f091ae9 && view2.getId() != R.id.share_more_container) {
                                                    if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().A()) {
                                                        if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().H()) {
                                                            if (this.a.J0.k.i() != null && view2 == this.a.J0.k.i().G()) {
                                                                if (this.a.C0 != null && this.a.C0.s1() != null && this.a.C0.s1().O() != null) {
                                                                    this.a.J0.k.f();
                                                                    TiebaStatic.log(new StatisticItem("c13062"));
                                                                    PbFragment pbFragment = this.a;
                                                                    pbFragment.M6(pbFragment.C0.s1().O().getFirstPostId());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().E()) {
                                                                if (this.a.J0.j1() != view2) {
                                                                    if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().x()) {
                                                                        if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().f()) {
                                                                            if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().u()) {
                                                                                if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f09230c && view2.getId() != R.id.obfuscated_res_0x7f091afc && view2.getId() != R.id.obfuscated_res_0x7f091975) {
                                                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091b67) {
                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091b65 && view2.getId() != R.id.obfuscated_res_0x7f091d31 && view2.getId() != R.id.obfuscated_res_0x7f091af6) {
                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091afa) {
                                                                                                if (view2 != this.a.J0.h1()) {
                                                                                                    if (this.a.J0.k.i() != null && view2 == this.a.J0.k.i().F()) {
                                                                                                        this.a.J0.k.g();
                                                                                                        this.a.J0.z4(this.a.G2);
                                                                                                        return;
                                                                                                    } else if (this.a.J0.k.i() == null || view2 != this.a.J0.k.i().y()) {
                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f09087e && view2.getId() != R.id.obfuscated_res_0x7f090b85) {
                                                                                                            if (view2.getId() != R.id.pb_u9_text_view) {
                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f091f18 && view2.getId() != R.id.cover_reply_content && view2.getId() != R.id.replybtn_top_right && view2.getId() != R.id.cover_reply_content_top_right) {
                                                                                                                    if (view2.getId() != R.id.pb_act_btn) {
                                                                                                                        if (view2.getId() != R.id.lottery_tail) {
                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091b2a && view2.getId() != R.id.obfuscated_res_0x7f091af1) {
                                                                                                                                if (view2.getId() != R.id.join_vote_tv) {
                                                                                                                                    if (view2.getId() != R.id.look_all_tv) {
                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f0916ec) {
                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f0916eb) {
                                                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f09276f) {
                                                                                                                                                    if (view2.getId() == R.id.qq_share_container) {
                                                                                                                                                        if (!ck9.d(this.a.getPageContext(), 11009)) {
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        ck9.w(this.a.getContext(), 8, this.a.o6(), this.a.C0);
                                                                                                                                                        return;
                                                                                                                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f091975) {
                                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091ae6) {
                                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f091b51) {
                                                                                                                                                                if (view2.getId() != R.id.forum_name_text && view2.getId() != R.id.forum_enter_button_one && view2.getId() != R.id.forum_enter_button_two && view2.getId() != R.id.forum_enter_button_three) {
                                                                                                                                                                    if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                                                                                                                        xn9.I(2, this.a.C0);
                                                                                                                                                                        return;
                                                                                                                                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f091b79) {
                                                                                                                                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091b93) {
                                                                                                                                                                            if (view2.getId() != R.id.obfuscated_res_0x7f09103d) {
                                                                                                                                                                                if (view2.getId() != R.id.obfuscated_res_0x7f09103a) {
                                                                                                                                                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091afe && view2.getId() != R.id.obfuscated_res_0x7f091b5f) {
                                                                                                                                                                                        return;
                                                                                                                                                                                    }
                                                                                                                                                                                    this.a.I8(view2);
                                                                                                                                                                                    return;
                                                                                                                                                                                }
                                                                                                                                                                                this.a.J5(view2);
                                                                                                                                                                                return;
                                                                                                                                                                            }
                                                                                                                                                                            this.a.K5(view2);
                                                                                                                                                                            return;
                                                                                                                                                                        }
                                                                                                                                                                        this.a.P8(view2);
                                                                                                                                                                        return;
                                                                                                                                                                    } else {
                                                                                                                                                                        this.a.G8();
                                                                                                                                                                        return;
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                this.a.g6(view2);
                                                                                                                                                                return;
                                                                                                                                                            }
                                                                                                                                                            this.a.H8();
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        this.a.e6();
                                                                                                                                                        return;
                                                                                                                                                    } else {
                                                                                                                                                        this.a.f7(view2);
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                this.a.G7();
                                                                                                                                                return;
                                                                                                                                            }
                                                                                                                                            this.a.i7();
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                        this.a.k7();
                                                                                                                                        return;
                                                                                                                                    }
                                                                                                                                    this.a.d7(view2);
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                                this.a.b7(view2);
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            this.a.F8(view2);
                                                                                                                            return;
                                                                                                                        }
                                                                                                                        this.a.m7(view2);
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    this.a.c7();
                                                                                                                    return;
                                                                                                                }
                                                                                                                this.a.F7(view2);
                                                                                                                return;
                                                                                                            }
                                                                                                            this.a.I7(view2);
                                                                                                            return;
                                                                                                        }
                                                                                                        this.a.H7(view2);
                                                                                                        return;
                                                                                                    } else {
                                                                                                        this.a.O6();
                                                                                                        return;
                                                                                                    }
                                                                                                }
                                                                                                this.a.R6();
                                                                                                return;
                                                                                            }
                                                                                            this.a.D7(view2);
                                                                                            return;
                                                                                        }
                                                                                        this.a.E7(view2);
                                                                                        return;
                                                                                    }
                                                                                    this.a.i6(view2);
                                                                                    return;
                                                                                }
                                                                                this.a.h6(view2);
                                                                                return;
                                                                            }
                                                                            this.a.c6();
                                                                            return;
                                                                        }
                                                                        this.a.I5();
                                                                        return;
                                                                    }
                                                                    this.a.m6();
                                                                    return;
                                                                }
                                                                this.a.K7();
                                                                return;
                                                            } else {
                                                                this.a.U5();
                                                                return;
                                                            }
                                                        }
                                                        this.a.U7(view2);
                                                        return;
                                                    }
                                                    this.a.e7();
                                                    return;
                                                } else {
                                                    this.a.C7(view2);
                                                    return;
                                                }
                                            }
                                            this.a.V7(view2);
                                            return;
                                        }
                                        this.a.f6(view2);
                                        return;
                                    }
                                    this.a.I6();
                                    return;
                                }
                                this.a.v7();
                                return;
                            } else {
                                this.a.u7();
                                return;
                            }
                        } else {
                            this.a.o7(view2);
                            return;
                        }
                    }
                    this.a.L5();
                } else {
                    this.a.h7();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t2 implements za<TiebaPlusRecommendCard> {
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
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
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
        @Override // com.baidu.tieba.za
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
        @Override // com.baidu.tieba.za
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
                        this.a.Y0.I(null, null);
                    }
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.J0 != null && this.a.J0.x1() != null && this.a.J0.x1().f() != null) {
                    this.a.J0.x1().f().J();
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
            this.a.v8((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes7.dex */
    public class u2 implements df5 {
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

        @Override // com.baidu.tieba.df5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                gk9 gk9Var = this.a.N0;
                if (gk9Var != null && gk9Var.e() != null && this.a.N0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.N0.e().c());
                    if (this.a.Y0 != null && (this.a.Y0.z() || this.a.Y0.B())) {
                        this.a.Y0.x(false, this.a.N0.h());
                    }
                    this.a.N0.a(true);
                    return true;
                }
                return !this.a.R5(ReplyPrivacyCheckController.TYPE_THREAD);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ow5.a)) {
                ow5.a aVar = (ow5.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.J6(aVar.b);
                }
                if (!StringUtils.isNull(aVar.e)) {
                    str = aVar.e;
                } else {
                    str = aVar.b;
                }
                ow5.c(this.a.getPageContext(), this.a, aVar.a, str, aVar.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v0 extends g4 {
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

        @Override // com.baidu.tieba.g4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v2 implements za<View> {
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
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
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
        @Override // com.baidu.tieba.za
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
        @Override // com.baidu.tieba.za
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.O0());
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.g) {
                return;
            }
            this.a.z8();
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
    public class w2 implements za<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
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
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
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
            this.a.v = true;
        }
    }

    /* loaded from: classes7.dex */
    public class x0 implements tg9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.tg9.a
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

        @Override // com.baidu.tieba.tg9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091f39) {
                        if (this.a.Y7(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09015d) {
                        if (motionEvent != null && motionEvent.getAction() == 1) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof pea)) {
                                return false;
                            }
                            pea peaVar = (pea) obj;
                            if (peaVar.getType() != pea.a1 && !TextUtils.isEmpty(peaVar.v()) && uu4.c().g()) {
                                return this.a.w7(peaVar);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091afb) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.A8((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.J0.m2() && view2.getId() == R.id.obfuscated_res_0x7f091b1d) {
                            if (view2.getTag(R.id.tag_user_id) instanceof String) {
                                TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.tag_user_id)));
                            }
                            if (this.a.X0() != null && this.a.X0().b != null) {
                                this.a.X0().b.onClick(view2);
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
                        this.a.A8(sparseArray);
                    }
                }
                if (this.a.Y0 != null) {
                    this.a.J0.x3(this.a.Y0.A());
                }
                this.a.J0.p3();
                this.a.J0.F0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.tg9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                this.a.d6((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
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
                    if (this.a.J0 != null && (D1 = this.a.J0.D1()) != null && this.a.J0.m1() != null) {
                        this.a.J0.m1().removeHeaderView(D1);
                        return;
                    }
                    return;
                }
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x2 implements za<ItemCardView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
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
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
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
        @Override // com.baidu.tieba.za
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
    public class y0 implements iz4.c {
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

        @Override // com.baidu.tieba.iz4.c
        public void a(iz4 iz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iz4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.Q0 = pbFragment.Q0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.Q0);
                    new gi9(this.a.C0.M1(), this.a.Q0, "1").start();
                    iz4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.Q0 = pbFragment2.Q0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.Q0);
                    new gi9(this.a.C0.M1(), this.a.Q0, "2").start();
                    iz4Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.Q0 = pbFragment3.Q0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.Q0);
                    iz4Var.e();
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
        public void b(ye9 ye9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ye9Var) == null) {
                this.a.J0.g2(ye9Var);
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
            mn5 mn5Var = new mn5(i, z, responsedMessage, this.a.q, this.a.p, this.a.n, z2, 0L, 0L, j4);
            this.a.p = 0L;
            this.a.q = 0L;
            mn5Var.c();
            if (z2) {
                j3 = j4;
                mn5Var.B = j3;
                mn5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.C0 != null && this.a.C0.s1() != null && this.a.C0.s1().O() != null) {
                int threadType = this.a.C0.s1().O().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.N, "from_personalize")) {
                        in5 in5Var = new in5();
                        in5Var.F = 1;
                        in5Var.a(1005);
                        in5Var.D = j3;
                        in5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.N, "from_frs")) {
                        mn5 mn5Var2 = new mn5();
                        mn5Var2.a(1000);
                        mn5Var2.D = j3;
                        mn5Var2.d(threadType);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, ye9 ye9Var, String str, int i4, boolean z2) {
            boolean z3;
            kd5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ye9Var, str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
                if (this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907bc));
                }
                if (z && ye9Var != null && ye9Var.Y() == null && ListUtils.getCount(ye9Var.F()) < 1) {
                    this.a.C0.g3(1);
                    if (this.a.f != null) {
                        this.a.f.x();
                    }
                    if (this.a.J0 != null) {
                        this.a.J0.D4();
                        return;
                    }
                    return;
                }
                if (this.a.h0) {
                    if (this.a.e0() != null) {
                        this.a.e0().z0();
                    }
                } else {
                    this.a.h0 = true;
                }
                this.a.h = true;
                if (this.a.J0 == null) {
                    return;
                }
                this.a.J0.R3();
                if (ye9Var == null || !ye9Var.s0()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.J0.G1());
                }
                this.a.J0.P1();
                int i5 = 0;
                if (this.a.K) {
                    this.a.J0.J1();
                } else if (!this.a.J0.l2()) {
                    this.a.J0.k4(false);
                }
                if (this.a.i) {
                    this.a.i = false;
                }
                if (i4 == 0 && ye9Var != null) {
                    this.a.R0 = true;
                }
                if (ye9Var != null) {
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.hideNetRefreshView(pbFragment2.J0.G1());
                    this.a.J0.d4();
                }
                ArrayList<pea> arrayList = null;
                String y1 = null;
                arrayList = null;
                if (z && ye9Var != null) {
                    ThreadData O = ye9Var.O();
                    if (O != null && O.isUgcThreadType()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = this.a;
                        pbFragment3.g8(pbFragment3.X0);
                    }
                    this.a.J0.x1().r(ye9Var);
                    this.a.J0.r4();
                    if (O != null && O.getCartoonThreadData() != null) {
                        this.a.N8(O.getCartoonThreadData());
                    }
                    if (this.a.Y0 != null) {
                        this.a.J0.x3(this.a.Y0.A());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(ye9Var.V().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(ye9Var.V().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(ye9Var.V().getBimg_end_time());
                    if (ye9Var.F() != null && ye9Var.F().size() >= 1 && ye9Var.F().get(0) != null) {
                        this.a.C0.S2(ye9Var.F().get(0).U());
                    } else if (ye9Var.Y() != null) {
                        this.a.C0.S2(ye9Var.Y().U());
                    }
                    if (this.a.Y0 != null) {
                        this.a.Y0.J(ye9Var.c());
                        this.a.Y0.K(ye9Var.k(), ye9Var.V());
                        this.a.Y0.m0(O);
                        this.a.Y0.L(this.a.C0.U0(), this.a.C0.M1(), this.a.C0.Q0());
                        if (O != null) {
                            this.a.Y0.b0(O.isMutiForumThread());
                        }
                    }
                    if (this.a.E0 != null) {
                        this.a.E0.h(ye9Var.q());
                    }
                    PbFragment pbFragment4 = this.a;
                    if (ye9Var.r() == 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    pbFragment4.r = z3;
                    if (ye9Var.j0()) {
                        this.a.r = true;
                    }
                    this.a.J0.y3(this.a.r);
                    if (this.a.v0.f.size() > 0) {
                        ye9Var.T0(this.a.v0.f);
                    }
                    this.a.J0.v4(ye9Var, i2, i3, this.a.C0.L1(), i4, this.a.C0.b1());
                    this.a.J0.K4(ye9Var, this.a.C0.L1());
                    this.a.J0.S4(this.a.C0.V0());
                    AntiData c = ye9Var.c();
                    if (c != null) {
                        this.a.y = c.getVoice_message();
                        if (!StringUtils.isNull(this.a.y) && this.a.Y0 != null && this.a.Y0.a() != null && (o = this.a.Y0.a().o(6)) != null && !TextUtils.isEmpty(this.a.y)) {
                            ((View) o).setOnClickListener(this.a.I1);
                        }
                    }
                    if (!z2 && !this.a.Y && !ListUtils.isEmpty(this.a.C0.s1().F()) && !this.a.C0.g2()) {
                        this.a.Y = true;
                        this.a.M5(false);
                    }
                    if (!TextUtils.isEmpty(this.a.U0)) {
                        PbFragment pbFragment5 = this.a;
                        ck9.H(pbFragment5, pbFragment5.C0.r1(), this.a.U0);
                        this.a.U0 = null;
                    } else if (!this.a.T0) {
                        if (!this.a.V0) {
                            if (!TextUtils.isEmpty(this.a.C0.i1())) {
                                il9.f(this.a.getListView(), this.a.C0.i1());
                                this.a.C0.n2();
                            } else {
                                this.a.J0.q4();
                            }
                        } else {
                            this.a.V0 = false;
                            il9.k(this.a.getListView());
                        }
                    } else {
                        this.a.T0 = false;
                        if (this.a.E6() != null && this.a.E6().o1() != null && this.a.E6().o1().getVisibility() == 0 && this.a.E6().o1().getPlayerHeight() > 0) {
                            PbFragment pbFragment6 = this.a;
                            ck9.F(pbFragment6, pbFragment6.E6().o1().getPlayerHeight());
                        } else {
                            ck9.F(this.a, 0);
                        }
                    }
                    this.a.C0.o2(ye9Var.k(), this.a.O1);
                    this.a.C0.s2(this.a.Q1);
                    if (this.a.a1 != null && O != null && O.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(O.getAuthor());
                        this.a.a1.setLikeUserData(attentionHostData);
                    }
                    if (this.a.C0 != null && this.a.C0.c2()) {
                        y1 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.J0 != null) {
                        y1 = this.a.J0.y1();
                    }
                    if (this.a.Y0 != null && !StringUtils.isNull(y1)) {
                        this.a.Y0.e0(TbSingleton.getInstance().getAdVertiComment(ye9Var.q0(), ye9Var.r0(), y1));
                    }
                    if (!this.a.R0 && ((i2 == 1 || i2 == 2) && this.a.J0 != null)) {
                        this.a.J0.Q0();
                    }
                    oma.c(this.a, new Pair[0]);
                } else if (str != null) {
                    oma.a(this.a, new Pair(PushMessageHelper.ERROR_TYPE, Integer.toString(i)), new Pair("error_info", str));
                    if (!this.a.R0 && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6 || i2 == 9) {
                            if (i == 4) {
                                if (this.a.C0.H0() != null && !StringUtils.isNull(this.a.C0.H0().c)) {
                                    this.a.J0.U4(this.a.C0.H0());
                                } else {
                                    PbFragment pbFragment7 = this.a;
                                    pbFragment7.showNetRefreshView(pbFragment7.J0.G1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    t6a.a("pb", false);
                                    PbFragment pbFragment8 = this.a;
                                    pbFragment8.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment8.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
                                }
                            } else {
                                PbFragment pbFragment9 = this.a;
                                pbFragment9.showNetRefreshView(pbFragment9.J0.G1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                t6a.a("pb", false);
                                PbFragment pbFragment10 = this.a;
                                pbFragment10.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment10.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
                            }
                            this.a.J0.J1();
                            this.a.J0.I1();
                        }
                    } else {
                        this.a.showToast(str);
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
                        wo6.b().c(new w85(this.a.C0.M1()));
                    }
                    if (i != 0) {
                        EnterForePvThread enterForePvThread = new EnterForePvThread();
                        enterForePvThread.setOpType("2");
                        enterForePvThread.start();
                    }
                    if (i != -1) {
                        if (this.a.C0 != null && this.a.C0.s1() != null) {
                            arrayList = this.a.C0.s1().F();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).L() != 1)) {
                            this.a.J0.t3(this.a.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (this.a.Z6()) {
                                this.a.J0.u3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1014));
                            } else {
                                this.a.J0.u3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1015));
                            }
                            this.a.J0.g2(this.a.C0.s1());
                        }
                    } else {
                        this.a.J0.t3("");
                    }
                    this.a.J0.M0();
                }
                if (ye9Var != null && ye9Var.m && this.a.n == 0) {
                    this.a.n = System.currentTimeMillis() - this.a.m;
                }
                if (this.a.b instanceof PbActivity) {
                    PbActivity pbActivity = (PbActivity) this.a.b;
                    if (ye9Var != null) {
                        i5 = ye9Var.f();
                    }
                    pbActivity.f2(i5, this.a.J0);
                }
                if (this.a.C0 != null && this.a.C0.s1() != null) {
                    this.a.C0.s1();
                }
            }
        }

        public final void d() {
            Bundle extras;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.a.C0 == null) {
                return;
            }
            if (this.a.Y0 != null && this.a.Y0.t) {
                return;
            }
            gf5 gf5Var = new gf5();
            this.a.g8(gf5Var);
            PbFragment pbFragment = this.a;
            pbFragment.Y0 = (hf5) gf5Var.a(pbFragment.getContext());
            this.a.Y0.Y(this.a.b.getPageContext());
            this.a.Y0.h0(this.a.o2);
            this.a.Y0.i0(this.a.c1);
            hf5 hf5Var = this.a.Y0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.b.getPageContext();
            if (this.a.b.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.b.getIntent().getExtras();
            }
            hf5Var.C(pageContext, extras);
            this.a.Y0.a().F(true);
            this.a.J0.s3(this.a.Y0.a());
            if (!this.a.C0.f1()) {
                this.a.Y0.r(this.a.C0.M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.Y0.e0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.C0.c2()) {
                this.a.Y0.e0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.J0 != null) {
                this.a.Y0.e0(this.a.J0.y1());
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
            li9 T0;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.J0.H2((TbRichText) view2.getTag());
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
                    xn9.J(3, i2, this.a.C0);
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
                    sj9.e(this.a.C0, str, i, eVar);
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
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().R() != null) {
                            ArrayList<TbRichTextImageInfo> R = tbRichTextView.getRichText().R();
                            int i6 = 0;
                            int i7 = -1;
                            while (i6 < R.size()) {
                                if (R.get(i6) != null) {
                                    arrayList.add(R.get(i6).T());
                                    if (i7 == i5 && str != null && (str.equals(R.get(i6).T()) || str.equals(R.get(i6).P()) || str.equals(R.get(i6).N()) || str.equals(R.get(i6).O()) || str.equals(R.get(i6).R()))) {
                                        i7 = i6;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    String T2 = R.get(i6).T();
                                    imageUrlData.imageUrl = T2;
                                    imageUrlData.imageThumbUrl = T2;
                                    if (this.a.r) {
                                        i4 = 17;
                                    } else {
                                        i4 = 18;
                                    }
                                    imageUrlData.urlThumbType = i4;
                                    imageUrlData.originalUrl = R.get(i6).T();
                                    imageUrlData.isLongPic = R.get(i6).W();
                                    concurrentHashMap.put(R.get(i6).T(), imageUrlData);
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
                        this.a.l6(rect);
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.setData(arrayList).setIndex(i3).setIsCDN(false).setPostId(eVar.f).setIsReserve(this.a.C0.E1()).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false).setIsSeeHost(this.a.Z6()).setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.C0 != null) {
                            builder.setFromForumId(this.a.C0.getFromForumId());
                            if (this.a.C0.s1() != null) {
                                builder.setThreadData(this.a.C0.s1().O());
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
                        builder2.setData(arrayList2).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.a.get(0)).setIsReserve(this.a.C0.E1()).setAssistUrls(concurrentHashMap2).setNeedBroadCaset(false).setIsSeeHost(this.a.Z6()).setPostId(eVar.f).setBjhPostId(eVar.f).setIsCanDrag(false);
                        if (this.a.C0 != null) {
                            builder2.setFromForumId(this.a.C0.getFromForumId());
                            if (this.a.C0.s1() != null) {
                                builder2.setThreadData(this.a.C0.s1().O());
                            }
                        }
                        ImageViewerConfig bulid2 = builder2.bulid(this.a.getPageContext().getPageActivity());
                        bulid2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, bulid2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText f = sj9.f(this.a.C0, str, i);
                        if (f != null && (d = sj9.d()) >= 0 && d < f.P().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = ze9.a(f.P().get(d));
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
                            if (f.getPostId() != 0 && (T0 = this.a.J0.T0()) != null) {
                                ArrayList<yh> v = T0.v();
                                if (ListUtils.getCount(v) > 0) {
                                    Iterator<yh> it = v.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        yh next = it.next();
                                        if ((next instanceof pea) && f.getPostId() == JavaTypesHelper.toLong(((pea) next).U(), 0L)) {
                                            int i9 = 8;
                                            if (f.getPostId() == JavaTypesHelper.toLong(this.a.C0.Q0(), 0L)) {
                                                i9 = 1;
                                            }
                                            xn9.b(this.a.C0.s1(), (pea) next, ((pea) next).f0, i9, 3);
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
                            this.a.l6(rect2);
                            ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                            builder3.setData(arrayList3).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.i).setIsReserve(this.a.C0.E1()).setAssistUrls(concurrentHashMap3).setNeedBroadCaset(false).setIsSeeHost(this.a.Z6()).setPostId(eVar.f).setBjhPostId(eVar.f).setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.C0 != null) {
                                builder3.setFromForumId(this.a.C0.getFromForumId());
                                if (this.a.C0.s1() != null) {
                                    builder3.setThreadData(this.a.C0.s1().O());
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
                if (error != 0 || !booleanValue || !TbadkCoreApplication.isLogin() || this.a.E0 == null || this.a.E0.e()) {
                    return;
                }
                this.a.q7();
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
            this.a.M8();
        }
    }

    /* loaded from: classes7.dex */
    public class z2 implements iz4.c {
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

        @Override // com.baidu.tieba.iz4.c
        public void a(iz4 iz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iz4Var, i, view2) == null) {
                if (iz4Var != null) {
                    iz4Var.e();
                }
                PbFragment pbFragment = this.a;
                pea peaVar = pbFragment.D2;
                if (peaVar != null) {
                    if (i == 0) {
                        peaVar.S0();
                        this.a.D2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.s7(pbFragment2.D2);
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

    public static PbFragment x7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65711, null)) == null) {
            return new PbFragment();
        }
        return (PbFragment) invokeV.objValue;
    }

    @Nullable
    public final ye9 A6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                return pbModel.s1();
            }
            return null;
        }
        return (ye9) invokeV.objValue;
    }

    public hf5 B6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.Y0;
        }
        return (hf5) invokeV.objValue;
    }

    public void B7() {
        sa5 sa5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (sa5Var = this.r0) != null) {
            sa5Var.q();
        }
    }

    @Override // com.baidu.tieba.rw5
    public ya<ItemCardView> C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.G == null) {
                this.G = new ya<>(new x2(this), 10, 0);
            }
            return this.G;
        }
        return (ya) invokeV.objValue;
    }

    public ol9 C6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f;
        }
        return (ol9) invokeV.objValue;
    }

    public final void C8() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (voiceManager = this.j) != null) {
            voiceManager.stopPlay();
        }
    }

    public cm9 D6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.v0;
        }
        return (cm9) invokeV.objValue;
    }

    public final void D8() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (absPbActivity = this.b) != null) {
            absPbActivity.V1();
        }
    }

    public dk9 E6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.J0;
        }
        return (dk9) invokeV.objValue;
    }

    public String G6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.W;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public ya<GifView> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.M == null) {
                this.M = new ya<>(new s2(this), 20, 0);
            }
            return this.M;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public ya<LinearLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.E == null) {
                this.E = new ya<>(new c(this), 15, 0);
            }
            return this.E;
        }
        return (ya) invokeV.objValue;
    }

    public boolean N7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            sa5 sa5Var = this.r0;
            if (sa5Var != null && sa5Var.t()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.j;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            dk9 dk9Var = this.J0;
            if (dk9Var == null) {
                return 0;
            }
            return dk9Var.A1();
        }
        return invokeV.intValue;
    }

    public boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.l2();
        }
        return invokeV.booleanValue;
    }

    public void Q6() {
        dk9 dk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048647, this) == null) && (dk9Var = this.J0) != null) {
            dk9Var.L1();
            P6();
        }
    }

    public final void S7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            hideNetRefreshView(this.J0.G1());
            r8();
            if (this.C0.t2()) {
                this.J0.S3();
            }
            this.J0.d4();
        }
    }

    public final void T6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.R = likeModel;
            likeModel.setLoadDataCallBack(new v0(this));
        }
    }

    public final void U6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            lm9 lm9Var = new lm9(getPageContext());
            lm9Var.m();
            this.b1 = lm9Var;
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ya<TbImageView> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            if (this.A == null) {
                this.A = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (ya) invokeV.objValue;
    }

    public boolean W6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                return pbModel.X0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public nl9 X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.b.X0();
        }
        return (nl9) invokeV.objValue;
    }

    public final boolean X6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            AbsPbActivity absPbActivity = this.b;
            if (absPbActivity != null && absPbActivity.J1() != null && this.b.J1().r1() == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void X7() {
        sa5 sa5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048676, this) == null) && (sa5Var = this.r0) != null) {
            sa5Var.x();
        }
    }

    public boolean Z6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                return pbModel.V0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bo9
    public PbModel.h b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            return this.s2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public ya<TiebaPlusRecommendCard> b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            if (this.D == null) {
                this.D = new ya<>(new t2(this), 5, 0);
            }
            return this.D;
        }
        return (ya) invokeV.objValue;
    }

    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.t0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bo9
    public PbModel e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            return this.C0;
        }
        return (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public ya<RelativeLayout> f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            ya<RelativeLayout> yaVar = new ya<>(new w2(this), 10, 0);
            this.F = yaVar;
            return yaVar;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pma
    @NonNull
    public String getTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            return Integer.toString(this.a.getId());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public ya<FestivalTipView> i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            if (this.I == null) {
                this.I = TbRichTextView.G(getContext(), R.dimen.M_H_X004);
            }
            return this.I;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public ya<ImageView> j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) {
            if (this.B == null) {
                this.B = new ya<>(new r2(this), 8, 0);
            }
            return this.B;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw5
    public ya<View> k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            if (this.C == null) {
                this.C = new ya<>(new v2(this), 8, 0);
            }
            return this.C;
        }
        return (ya) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bo9
    public AbsPbActivity l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            return this.b;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public AntiData n6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.s1() != null) {
                return this.C0.s1().c();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    public final void n7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            ye9 s12 = this.C0.s1();
            this.C0.i3(true);
            oq4 oq4Var = this.E0;
            if (oq4Var != null) {
                s12.L0(oq4Var.g());
            }
            this.J0.g2(s12);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.e0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ci onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (ci) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048755, this) == null) {
            S7();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tieba.rw5
    public ya<TextView> p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) {
            if (this.z == null) {
                this.z = TbRichTextView.H(getContext(), 8);
            }
            return this.z;
        }
        return (ya) invokeV.objValue;
    }

    public pea p6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) {
            ye9 ye9Var = this.C0.G;
            if (ye9Var != null) {
                return ye9Var.X();
            }
            return null;
        }
        return (pea) invokeV.objValue;
    }

    public void p7() {
        dk9 dk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048766, this) != null) || (dk9Var = this.J0) == null) {
            return;
        }
        dk9Var.A2();
    }

    public int q6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) {
            return this.S2;
        }
        return invokeV.intValue;
    }

    public String r6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) {
            return this.N;
        }
        return (String) invokeV.objValue;
    }

    public PbInterviewStatusView.f t6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048778, this)) == null) {
            return this.y0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048782, this) == null) && (pbModel = this.C0) != null && !ad.isEmpty(pbModel.M1())) {
            super.taskStart();
        }
    }

    public boolean u6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048783, this)) == null) {
            if (!this.d && this.O2 == -1 && this.P2 == -1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean v6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048787, this)) == null) {
            return this.p2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean w6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048791, this)) == null) {
            return this.L;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rw5
    /* renamed from: x6 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048795, this)) == null) {
            dk9 dk9Var = this.J0;
            if (dk9Var == null) {
                return null;
            }
            return dk9Var.m1();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public int y6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048797, this)) == null) {
            return this.P2;
        }
        return invokeV.intValue;
    }

    public int z6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048800, this)) == null) {
            return this.O2;
        }
        return invokeV.intValue;
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
        this.K0 = false;
        this.L0 = false;
        this.M0 = false;
        this.R0 = false;
        this.T0 = false;
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
        this.X1 = new tg9(new x0(this));
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

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e3, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0159, code lost:
        if ((r7.h1.a.getView().getTop() - r11.J0.k.a.getBottom()) < (r11.J0.h1.a.g.getHeight() + 10)) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e6() {
        PbModel pbModel;
        int top;
        boolean z3;
        boolean z4;
        dk9.g1 g1Var;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        xm9 xm9Var;
        PbReplyTitleViewHolder pbReplyTitleViewHolder2;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048700, this) == null) && this.J0.m1() != null && (pbModel = this.C0) != null && pbModel.s1() != null) {
            int firstVisiblePosition = this.J0.m1().getFirstVisiblePosition();
            int i4 = 0;
            View childAt = this.J0.m1().getChildAt(0);
            if (childAt == null) {
                top = 0;
            } else {
                top = childAt.getTop();
            }
            boolean x02 = this.C0.s1().x0();
            boolean r22 = this.J0.r2();
            if (firstVisiblePosition == 0 && top == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            ck9.g(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.C0.s1());
            if ((this.C0.s1().O() != null && this.C0.s1().O().getReply_num() <= 0) || (r22 && z3)) {
                xn9.N(1, 1);
                if (!checkUpIsLogin()) {
                    xn9.N(2, 1);
                    return;
                }
                L7();
                if (this.C0.s1().O().getAuthor() != null) {
                    xn9.x(2, this.C0);
                }
            } else {
                int equipmentHeight = (int) (BdUtilHelper.getEquipmentHeight(getContext()) * 0.6d);
                if (x02) {
                    dk9.g1 g1Var2 = this.J0.h1;
                    if (g1Var2 != null) {
                        PbReplyTitleViewHolder pbReplyTitleViewHolder3 = g1Var2.a;
                        if (pbReplyTitleViewHolder3 != null && pbReplyTitleViewHolder3.getView() != null) {
                            if (this.J0.h1.a.getView().getParent() != null) {
                            }
                        }
                    }
                    z4 = false;
                } else {
                    if (this.J0.v1() != null) {
                        if (this.J0.v1().getVisibility() == 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z4 && (g1Var = this.J0.h1) != null && (pbReplyTitleViewHolder = g1Var.a) != null && pbReplyTitleViewHolder.getView() != null && this.J0.h1.a.getView().getParent() != null && (xm9Var = (r7 = this.J0).k) != null && xm9Var.a != null) {
                        }
                    }
                    z4 = false;
                }
                if (!z4 && !r22) {
                    if (this.b0 > 0) {
                        if (this.J0.m1().getChildAt(this.b0) != null) {
                            this.J0.m1().D(this.b0, this.c0, 200);
                        } else {
                            this.J0.m1().setSelectionFromTop(this.b0, this.c0 + equipmentHeight);
                            this.J0.m1().smoothScrollBy(equipmentHeight, 500);
                        }
                    } else {
                        int d4 = il9.d(getListView());
                        if (il9.e(getListView()) != -1) {
                            d4--;
                        }
                        int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds100);
                        if (d4 < 0) {
                            d4 = (ListUtils.getCount(this.J0.m1().getData()) - 1) + this.J0.m1().getHeaderViewsCount();
                        } else {
                            i4 = dimens;
                        }
                        xm9 xm9Var2 = this.J0.k;
                        if (xm9Var2 != null && (navigationBar = xm9Var2.a) != null) {
                            i4 += navigationBar.getFixedNavHeight() - 10;
                        }
                        dk9.g1 g1Var3 = this.J0.h1;
                        if (g1Var3 != null && (pbReplyTitleViewHolder2 = g1Var3.a) != null && pbReplyTitleViewHolder2.getView() != null && this.J0.h1.a.getView().getParent() != null) {
                            this.J0.m1().D(d4, i4, 200);
                        } else {
                            this.J0.m1().setSelectionFromTop(d4, i4 + equipmentHeight);
                            this.J0.m1().smoothScrollBy(equipmentHeight, 500);
                        }
                    }
                } else {
                    this.b0 = firstVisiblePosition;
                    this.c0 = top;
                    if (firstVisiblePosition <= 3 && (firstVisiblePosition != 3 || top >= (-equipmentHeight))) {
                        this.J0.m1().D(0, 0, 500);
                    } else {
                        int i5 = -equipmentHeight;
                        this.J0.m1().setSelectionFromTop(0, i5);
                        this.J0.m1().smoothScrollBy(i5, 500);
                    }
                }
            }
            if (this.C0.s1().O() != null && this.C0.s1().O().getAuthor() != null) {
                xn9.x(2, this.C0);
            }
        }
    }

    @Override // com.baidu.tieba.bo9
    public void finish() {
        dk9 dk9Var;
        boolean z3;
        CardHListViewData p3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            dk9 dk9Var2 = this.J0;
            if (dk9Var2 != null) {
                dk9Var2.F0();
            }
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.s1() != null && !this.C0.s1().j0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.C0.s1().O().getId();
                if (this.C0.isShareThread() && this.C0.s1().O().originalThreadData != null) {
                    historyMessage.threadName = this.C0.s1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.C0.s1().O().getTitle();
                }
                if (this.C0.isShareThread() && !P0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.C0.s1().k().getName();
                }
                ArrayList<pea> F = this.C0.s1().F();
                dk9 dk9Var3 = this.J0;
                if (dk9Var3 != null) {
                    i4 = dk9Var3.d1();
                } else {
                    i4 = 0;
                }
                if (F != null && i4 >= 0 && i4 < F.size()) {
                    historyMessage.postID = F.get(i4).U();
                }
                historyMessage.isHostOnly = this.C0.V0();
                historyMessage.isSquence = this.C0.L1();
                historyMessage.isShareThread = this.C0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
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
                if (this.C0.a1() && this.C0.s1() != null && this.C0.s1().O() != null) {
                    wo6.b().c(new uf5(this.C0.Q()));
                }
                if (this.C0.s1() != null && System.currentTimeMillis() - this.o >= 40000 && (p3 = this.C0.s1().p()) != null && !ListUtils.isEmpty(p3.getDataList())) {
                    intent.putExtra("guess_like_data", p3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.s1);
                }
                this.b.setResult(-1, intent);
            }
            if (E8()) {
                if (this.C0 != null && (dk9Var = this.J0) != null && dk9Var.m1() != null) {
                    ye9 s12 = this.C0.s1();
                    if (s12 != null) {
                        if (s12.V() != null) {
                            s12.V().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            s12.V().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!s12.s0() && !this.J && s12.h == null) {
                            uj9 b4 = uj9.b();
                            ye9 t12 = this.C0.t1();
                            Parcelable onSaveInstanceState = this.J0.m1().onSaveInstanceState();
                            boolean L1 = this.C0.L1();
                            boolean V0 = this.C0.V0();
                            if (this.J0.v1() != null && this.J0.v1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.l(t12, onSaveInstanceState, L1, V0, z3);
                            if (this.r1 >= 0 || this.C0.O1() != null) {
                                uj9.b().o(this.C0.O1());
                                uj9.b().p(this.C0.P1());
                                uj9.b().m(this.C0.l1());
                            }
                        }
                    }
                } else {
                    uj9.b().k();
                }
                D8();
            }
            lm9 lm9Var = this.b1;
            if (lm9Var != null && !lm9Var.o() && P5() && this.C0.a1() && !TextUtils.isEmpty(this.C0.Q())) {
                this.b1.n(this.C0.s1().g().l, this.C0.Q());
            }
        }
    }

    @Override // com.baidu.tieba.ko9.b
    public void B1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z3) == null) {
            this.S0 = z3;
        }
    }

    public void C5(g3 g3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, g3Var) == null) && g3Var != null) {
            if (this.t1 == null) {
                this.t1 = new ArrayList();
            }
            if (!this.t1.contains(g3Var)) {
                this.t1.add(g3Var);
            }
        }
    }

    public void D5(g3 g3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, g3Var) == null) && g3Var != null) {
            if (this.t1 == null) {
                this.t1 = new ArrayList();
            }
            if (!this.t1.contains(g3Var)) {
                this.t1.add(0, g3Var);
            }
        }
    }

    public final void N6(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, intent) == null) {
            mm9.f(this, intent);
        }
    }

    public final void N8(fw4 fw4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, fw4Var) == null) && fw4Var != null) {
            this.R2 = fw4Var;
            this.d = true;
            this.J0.n3();
            this.J0.G3(this.Q2);
        }
    }

    public void T7(g3 g3Var) {
        List<g3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048659, this, g3Var) == null) && g3Var != null && (list = this.t1) != null) {
            list.remove(g3Var);
        }
    }

    public final void b8(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048691, this, i4) == null) && this.C0 != null) {
            r8();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i4);
            privacySettingMessage.setTid(this.C0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void c8(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048695, this, i4) == null) {
            this.S2 = i4;
        }
    }

    public void d8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048698, this, z3) == null) {
            this.p2 = Boolean.valueOf(z3);
        }
    }

    public void e8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048702, this, z3) == null) {
            this.t0 = z3;
        }
    }

    public final void f7(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, view2) == null) {
            if (view2.getTag() instanceof SparseArray) {
                sparseArray = (SparseArray) view2.getTag();
            } else {
                sparseArray = null;
            }
            if (sparseArray == null) {
                return;
            }
            A8(sparseArray);
        }
    }

    public void f8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048706, this, z3) == null) {
            this.O = z3;
        }
    }

    public final void g7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            BrowserHelper.startWebActivity(getContext(), "", str, false, true, true, bundle);
        }
    }

    public void i8(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048719, this, z3) == null) {
            this.L = z3;
        }
    }

    public final void j8(boolean z3) {
        hf5 hf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048723, this, z3) != null) || (hf5Var = this.Y0) == null) {
            return;
        }
        hf5Var.Z(z3);
        this.Y0.c0(z3);
        this.Y0.k0(z3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048745, this, context) == null) {
            super.onAttach(context);
            this.b = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tieba.hz4.e
    public void onClick(hz4 hz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, hz4Var) == null) {
            a6(hz4Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.j4
    public void onPreLoad(ci ciVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048757, this, ciVar) == null) {
            PreLoadImageHelper.load(ciVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(ciVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.C0.O2(bundle);
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            hf5 hf5Var = this.Y0;
            if (hf5Var != null) {
                hf5Var.H(bundle);
            }
        }
    }

    public final void r7(View view2) {
        SparseArray sparseArray;
        pea peaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048772, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (peaVar = (pea) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            s7(peaVar);
        }
    }

    public final void w8(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048793, this, i4) == null) {
            mm9.i(this, o6(), i4);
        }
    }

    @Override // com.baidu.tieba.rw5
    public void W(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048669, this, context, str) == null) {
            jk9.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.v = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        dk9 dk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048754, this, i4, keyEvent)) == null) {
            if (keyEvent != null && (dk9Var = this.J0) != null) {
                return dk9Var.I2(i4);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.rw5
    public void w0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048790, this, context, str) == null) {
            this.v = true;
        }
    }

    public void A7() {
        PbModel pbModel;
        ye9 s12;
        ThreadData O;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        ye9 ye9Var;
        boolean z8;
        boolean z9;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (pbModel = this.C0) != null && pbModel.s1() != null && (O = (s12 = this.C0.s1()).O()) != null && O.getAuthor() != null) {
            this.J0.L1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
            mj9 mj9Var = new mj9();
            int W = this.C0.s1().W();
            if (W != 1 && W != 3) {
                mj9Var.g = false;
            } else {
                mj9Var.g = true;
                if (O.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                mj9Var.s = z3;
            }
            if (ck9.z(this.C0.s1(), W)) {
                mj9Var.h = true;
                if (O.getIs_good() == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                mj9Var.r = z9;
            } else {
                mj9Var.h = false;
            }
            if (W == 1002 && !equals) {
                mj9Var.u = true;
            }
            mj9Var.n = ck9.L(O.isBlocked(), s12.n0(), equals, W, O.isWorksInfo(), O.isScoreThread());
            mj9Var.e = ck9.J(s12, equals, s12.n0(), this.C0.V());
            mj9Var.i = o8();
            mj9Var.f = ck9.K(this.C0.s1(), equals, this.C0.V());
            if (equals && s12.V() != null && s12.V().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            mj9Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                mj9Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            mj9Var.t = equals;
            mj9Var.q = this.C0.L1();
            mj9Var.b = true;
            mj9Var.a = ck9.C(this.C0.s1(), equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            mj9Var.p = z5;
            mj9Var.j = true;
            mj9Var.o = this.C0.V0();
            mj9Var.d = true;
            if (O.getThreadVideoInfo() == null) {
                z6 = true;
            } else {
                z6 = false;
            }
            mj9Var.c = z6;
            if (s12.j0()) {
                mj9Var.b = false;
                mj9Var.d = false;
                mj9Var.c = false;
                mj9Var.g = false;
                mj9Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !s12.j0()) {
                z7 = true;
            } else {
                z7 = false;
            }
            mj9Var.v = z7;
            if (this.J0 != null && (ye9Var = this.C0.G) != null) {
                pea X = ye9Var.X();
                if (X != null) {
                    z8 = X.f1148T;
                } else {
                    z8 = false;
                }
                mj9Var.w = z8;
            }
            mj9Var.m = true;
            if (O.isBlocked()) {
                mj9Var.n = false;
                mj9Var.g = false;
                mj9Var.h = false;
            }
            this.J0.k.x(mj9Var);
        }
    }

    public final void A8(SparseArray<Object> sparseArray) {
        pea peaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof pea) || (peaVar = (pea) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        B8(peaVar, false);
    }

    public final void I8(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048613, this, view2) != null) || this.t0) {
            return;
        }
        xn9.I(7, this.C0);
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray != null && (sparseArray.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_is_top_question)).booleanValue()) {
            xn9.v(6);
        }
        this.c = false;
        V5(view2);
    }

    public final void J5(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, view2) != null) || !(view2.getTag() instanceof ThreadData) || !checkUpIsLogin()) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        LikeModel likeModel = this.R;
        if (likeModel != null) {
            likeModel.f0(threadData.getForum_name(), String.valueOf(threadData.getFid()));
        }
        xn9.H(threadData, 10, 11);
    }

    public final void J6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 4).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public final void L8(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i4) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.C0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(fm9.n(i4))));
        }
    }

    public final void O7(View view2) {
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048638, this, view2) != null) || view2 == null) {
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

    public final void P8(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048645, this, view2) == null) && (view2.getTag() instanceof SmartApp)) {
            SmartApp smartApp = (SmartApp) view2.getTag();
            if (!TbAiappsLaunchUtil.launch(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                if (StringUtils.isNull(smartApp.h5_url)) {
                    return;
                }
                BrowserHelper.startWebActivity(getActivity(), smartApp.h5_url);
            }
            xn9.y(smartApp, this.C0);
        }
    }

    public final void S6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, bundle) == null) {
            oq4 c4 = oq4.c(this.b);
            this.E0 = c4;
            if (c4 != null) {
                c4.j(this.v2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.b);
            this.F0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.x2);
            getPageContext();
            F6();
            this.R1.setUniqueId(getUniqueId());
            this.R1.registerListener();
            U6();
        }
    }

    public final void l6(Rect rect) {
        dk9 dk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048729, this, rect) == null) && rect != null && (dk9Var = this.J0) != null && dk9Var.F1() != null && rect.top <= this.J0.F1().getHeight()) {
            rect.top += this.J0.F1().getHeight() - rect.top;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048763, this, z3) == null) {
            super.onUserChanged(z3);
            this.J0.T4(z3);
            pz4 pz4Var = this.O0;
            if (pz4Var != null) {
                pz4Var.dismiss();
            }
            if (z3 && this.S0) {
                this.J0.T3();
                this.C0.p2(true);
            }
            if (this.J0.T0() != null) {
                this.J0.T0().j0(z3);
            }
        }
    }

    public final void x8(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048796, this, str) == null) {
            if (str == null) {
                str = "";
            }
            BdPageContext bdPageContext = this.h1;
            if (bdPageContext == null) {
                return;
            }
            hz4 hz4Var = new hz4(bdPageContext.getPageActivity());
            hz4Var.setMessage(str);
            hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b68, new j(this));
            hz4Var.create(this.h1).show();
        }
    }

    public final void B8(pea peaVar, boolean z3) {
        PbModel pbModel;
        int i4;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, peaVar, z3) == null) {
            d8(false);
            if (peaVar == null || (pbModel = this.C0) == null || pbModel.s1() == null || peaVar.L() == 1) {
                return;
            }
            String M1 = this.C0.M1();
            String U = peaVar.U();
            if (this.C0.s1() != null) {
                i4 = this.C0.s1().W();
            } else {
                i4 = 0;
            }
            AbsPbActivity.e M7 = M7(U);
            if (M7 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo m02 = peaVar.m0();
            AntiData c4 = this.C0.s1().c();
            if (peaVar.t() != null) {
                arrayList = peaVar.t().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(M1, U, "pb", true, false, null, false, null, i4, m02, c4, false, arrayList, 5).addBigImageData(M7.a, M7.b, M7.g, M7.j);
            addBigImageData.setKeyPageStartFrom(this.C0.r1());
            addBigImageData.setFromFrsForumId(this.C0.getFromForumId());
            addBigImageData.setWorksInfoData(this.C0.R1());
            addBigImageData.setKeyFromForumId(this.C0.getForumId());
            addBigImageData.setBjhData(this.C0.J0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public final void K6(int i4, Intent intent) {
        pd5 pd5Var;
        pd5 pd5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048619, this, i4, intent) == null) {
            if (i4 == 0) {
                this.J0.L1();
                this.J0.x1().g();
                this.J0.k4(false);
            }
            this.J0.p3();
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
                if (editorType == 1 && this.J0.x1() != null && this.J0.x1().f() != null) {
                    kf5 f4 = this.J0.x1().f();
                    f4.g0(this.C0.s1().O());
                    f4.E(writeData);
                    f4.h0(pbEditorData.getVoiceModel());
                    od5 p3 = f4.a().p(6);
                    if (p3 != null && (pd5Var2 = p3.m) != null) {
                        pd5Var2.O(new cd5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i4 == -1) {
                        f4.J();
                        return;
                    }
                    return;
                }
                return;
            }
            hf5 hf5Var = this.Y0;
            if (hf5Var != null) {
                hf5Var.N();
                this.Y0.o0(pbEditorData.getVoiceModel());
                this.Y0.D(writeData);
                od5 p4 = this.Y0.a().p(6);
                if (p4 != null && (pd5Var = p4.m) != null) {
                    pd5Var.O(new cd5(52, 0, pbEditorData.getVoiceModel()));
                }
                this.Y0.j0(pbEditorData.isShowCustomFigure());
                if (i4 == -1) {
                    this.Y0.I(null, null);
                }
            }
        }
    }

    public void Z5(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048680, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(dk9.o2)).intValue();
            if (intValue == dk9.p2) {
                if (this.F0.g0()) {
                    return;
                }
                this.J0.N4();
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
                    this.F0.i0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.F0.j0(this.C0.s1().k().getId(), this.C0.s1().k().getName(), this.C0.s1().O().getId(), str, intValue3, intValue2, booleanValue, this.C0.s1().O().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == dk9.q2 || intValue == dk9.s2) {
                PbModel pbModel = this.C0;
                if (pbModel != null && pbModel.N0() != null) {
                    this.C0.N0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == dk9.q2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public void d6(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048696, this, i4, i5) == null) {
            TiebaStatic.log("c12181");
            dk9 dk9Var = this.J0;
            if (dk9Var != null && this.C0 != null) {
                if ((dk9Var == null || dk9Var.i2()) && this.C0.s1() != null && this.C0.s1().S() != null) {
                    dk9 dk9Var2 = this.J0;
                    if (dk9Var2 != null && dk9Var2.b1() != null && this.J0.b1().t()) {
                        return;
                    }
                    of9 S = this.C0.s1().S();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!S.d() || S.a() != 2) && this.J0.T0() != null && this.J0.T0().B() != null) {
                        this.J0.T0().B().K(this.C0.M1(), this.C0.getFromForumId());
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

    public final void l8(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048731, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (E6() != null) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    String questionMsg = postWriteCallBackData.getQuestionMsg();
                    String questionExp = postWriteCallBackData.getQuestionExp();
                    if (postWriteCallBackData.getIconStampData() != null) {
                        va5.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            ed9.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            ed9.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            ed9.e(getResources().getString(R.string.obfuscated_res_0x7f0f14aa));
                            return;
                        } else {
                            ed9.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.C0.f1()) {
                antiData.setBlock_forum_name(this.C0.s1().k().getName());
                antiData.setBlock_forum_id(this.C0.s1().k().getId());
                antiData.setUser_name(this.C0.s1().V().getUserName());
                antiData.setUser_id(this.C0.s1().V().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void q8(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048770, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            pz4 pz4Var = this.O0;
            if (pz4Var != null && pz4Var.isShowing()) {
                this.O0.dismiss();
                this.O0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            rz4 rz4Var = new rz4(getContext());
            rz4Var.r(new m0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i4 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i4 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i4 == 1) {
                arrayList.add(new nz4(0, getResources().getString(R.string.obfuscated_res_0x7f0f0551), rz4Var));
            }
            if (z3) {
                arrayList.add(new nz4(1, getResources().getString(R.string.un_mute), rz4Var));
            } else {
                arrayList.add(new nz4(1, getResources().getString(R.string.obfuscated_res_0x7f0f0d27), rz4Var));
            }
            rz4Var.m(arrayList);
            pz4 pz4Var2 = new pz4(getPageContext(), rz4Var);
            this.O0 = pz4Var2;
            pz4Var2.l();
        }
    }

    public final void C7(View view2) {
        ye9 s12;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (s12 = this.C0.s1()) == null) {
                return;
            }
            ThreadData O = s12.O();
            if (O != null && O.getAuthor() != null) {
                xn9.x(4, this.C0);
            }
            PbModel pbModel = this.C0;
            AbsPbActivity l02 = l0();
            dk9 dk9Var = this.J0;
            int i5 = 6;
            if (view2.getId() == R.id.share_num_container) {
                i4 = 5;
            } else {
                i4 = 6;
            }
            xn9.O(pbModel, l02, dk9Var, i4);
            if (!BdUtilHelper.isNetOk()) {
                showToast(R.string.obfuscated_res_0x7f0f0e4f);
            } else if (s12 == null) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1013));
            } else {
                ArrayList<pea> F = this.C0.s1().F();
                if ((F == null || F.size() <= 0) && this.C0.L1()) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1013));
                    return;
                }
                this.J0.F0();
                C8();
                if (s12.A() != null && !StringUtils.isNull(s12.A().a(), true)) {
                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.C0.s1().l()));
                }
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), O)) {
                    return;
                }
                dk9 dk9Var2 = this.J0;
                if (dk9Var2 != null) {
                    dk9Var2.H0();
                    this.J0.X4(s12);
                }
                if (ShareSwitch.isOn()) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091ae9) {
                        i5 = 2;
                    } else if (view2.getId() == R.id.share_num_container) {
                        i5 = 1;
                    }
                    if (this.J0.w2() && !s12.p0()) {
                        w8(i5);
                        return;
                    } else {
                        w8(i5);
                        return;
                    }
                }
                this.J0.s4();
                this.C0.M0().P(CheckRealNameModel.TYPE_PB_SHARE, 6);
            }
        }
    }

    public final void D7(View view2) {
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
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            String str = null;
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            pea peaVar = (pea) sparseArray.get(R.id.tag_clip_board);
            if (peaVar == null) {
                return;
            }
            if (this.P0 == null) {
                rz4 rz4Var = new rz4(getContext());
                this.P0 = rz4Var;
                rz4Var.r(this.k2);
            }
            ArrayList arrayList = new ArrayList();
            if (e0().s1() != null && e0().s1().j0()) {
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
                if (peaVar.p() != null) {
                    boolean z10 = peaVar.p().hasAgree;
                    int q3 = peaVar.q();
                    if (z10 && q3 == 5) {
                        string = getString(R.string.action_cancel_dislike);
                    } else {
                        string = getString(R.string.action_dislike);
                    }
                    nz4 nz4Var = new nz4(8, string, this.P0);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, peaVar);
                    nz4Var.d.setTag(sparseArray2);
                    arrayList.add(nz4Var);
                }
                if (this.mIsLogin) {
                    H5(z6, z5, sparseArray, arrayList, z4, z3, str2);
                    F5(sparseArray, arrayList, z4, z6, z7, z8, z9, str2);
                }
                this.P0.m(arrayList);
                pz4 pz4Var = new pz4(getPageContext(), this.P0);
                this.O0 = pz4Var;
                pz4Var.l();
            }
        }
    }

    public final void E7(View view2) {
        StatisticItem statisticItem;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, view2) != null) || this.C0 == null) {
            return;
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f091b65) {
            xn9.I(6, this.C0);
        }
        if (view2.getId() == R.id.obfuscated_res_0x7f091d31) {
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                this.U = view2;
                return;
            }
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091b65 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
            this.U = view2;
            return;
        }
        if (!checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof pea)) {
            return;
        }
        pea peaVar = (pea) sparseArray.get(R.id.tag_load_sub_data);
        if (view2.getId() == R.id.obfuscated_res_0x7f091b65 && (statisticItem = peaVar.g0) != null) {
            StatisticItem copy = statisticItem.copy();
            copy.delete("obj_locate");
            copy.param("obj_locate", 8);
            TiebaStatic.log(copy);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091d31 || view2.getId() == R.id.obfuscated_res_0x7f091af6) {
            xn9.B(this.C0, peaVar);
        }
        PbModel pbModel = this.C0;
        if (pbModel != null && pbModel.s1() != null && E6().w1() != null && peaVar.t() != null && peaVar.L() != 1) {
            if (E6().x1() != null) {
                E6().x1().g();
            }
            pf9 pf9Var = new pf9();
            pf9Var.v(this.C0.s1().k());
            pf9Var.z(this.C0.s1().O());
            pf9Var.x(peaVar);
            E6().w1().j0(pf9Var);
            E6().w1().setPostId(peaVar.U());
            l7(view2, peaVar.t().getUserId(), "", peaVar);
            hf5 hf5Var = this.Y0;
            if (hf5Var != null) {
                this.J0.x3(hf5Var.A());
            }
        }
    }

    public final void W7(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048672, this, view2) != null) || this.t0) {
            return;
        }
        xn9.I(1, this.C0);
        SparseArray sparseArray = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
        if (sparseArray != null && (sparseArray.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_is_top_question)).booleanValue()) {
            xn9.v(2);
        }
        xn9.N(1, 2);
        if (this.v) {
            this.v = false;
            xn9.N(20, 2);
            return;
        }
        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
        if (!(tbRichTextView.getTag() instanceof SparseArray)) {
            xn9.N(20, 2);
            return;
        }
        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
        if (!(obj instanceof pea)) {
            xn9.N(20, 2);
            return;
        }
        pea peaVar = (pea) obj;
        PbModel pbModel = this.C0;
        if (pbModel != null && pbModel.s1() != null && E6().w1() != null && peaVar.t() != null && peaVar.L() != 1) {
            if (!checkUpIsLogin()) {
                xn9.N(2, 2);
                return;
            } else if (peaVar.B0()) {
                return;
            } else {
                if (E6().x1() != null) {
                    E6().x1().g();
                }
                pf9 pf9Var = new pf9();
                pf9Var.v(this.C0.s1().k());
                pf9Var.z(this.C0.s1().O());
                pf9Var.x(peaVar);
                E6().w1().j0(pf9Var);
                E6().w1().setPostId(peaVar.U());
                l7(view2, peaVar.t().getUserId(), "", peaVar);
                TiebaStatic.log("c11743");
                xn9.b(this.C0.s1(), peaVar, peaVar.f0, 8, 1);
                hf5 hf5Var = this.Y0;
                if (hf5Var != null) {
                    this.J0.x3(hf5Var.A());
                    return;
                }
                return;
            }
        }
        xn9.N(20, 2);
    }

    public final void E5() {
        PbModel pbModel;
        ye9 ye9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (pbModel = this.C0) != null && (ye9Var = pbModel.G) != null && ye9Var.O() != null) {
            ThreadData O = this.C0.G.O();
            O.mRecomAbTag = this.C0.y1();
            O.mRecomWeight = this.C0.B1();
            O.mRecomSource = this.C0.A1();
            O.mRecomExtra = this.C0.z1();
            O.isSubPb = this.C0.f1();
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(this.C0.getForumId(), 0L));
            }
            StatisticItem i4 = ym5.i(getContext(), O, "c13562");
            TbPageTag l3 = ym5.l(getContext());
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

    public final void I5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            SparseArray<Object> n12 = this.J0.n1(this.C0.s1(), this.C0.L1(), 1);
            if (n12 != null) {
                this.J0.W2(((Integer) n12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(n12.get(R.id.tag_del_post_id)), ((Integer) n12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n12.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            this.J0.k.f();
            if (e0() != null && e0().s1() != null && e0().s1().O() != null) {
                xn9.G(e0().s1().O());
            }
        }
    }

    public final void L5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.J0.k.g();
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                this.v1.f(pbModel.M1());
            }
            int i4 = 1;
            PbModel pbModel2 = this.C0;
            if (pbModel2 != null && pbModel2.isPrivacy()) {
                showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (e0() != null && e0().s1() != null) {
                    this.v1.d(3, 3, e0().s1().Q());
                    return;
                }
                return;
            }
            this.v1.b();
            if (!TbSingleton.getInstance().mCanCallFans && e0() != null && e0().s1() != null && e0().s1().Q() != null && e0().s1().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
                i4 = 2;
            }
            if (e0() != null && e0().s1() != null) {
                this.v1.d(3, i4, e0().s1().Q());
            }
        }
    }

    public final void c6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            SparseArray<Object> n12 = this.J0.n1(this.C0.s1(), this.C0.L1(), 1);
            if (n12 != null) {
                if (StringUtils.isNull((String) n12.get(R.id.tag_del_multi_forum))) {
                    this.J0.T2(((Integer) n12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(n12.get(R.id.tag_del_post_id)), ((Integer) n12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n12.get(R.id.tag_del_post_is_self)).booleanValue());
                } else {
                    this.J0.U2(((Integer) n12.get(R.id.tag_del_post_type)).intValue(), (String) n12.get(R.id.tag_del_post_id), ((Integer) n12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n12.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(n12.get(R.id.tag_del_multi_forum)));
                }
            }
            this.J0.k.f();
        }
    }

    public final void c7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048694, this) == null) && this.C0.s1() != null && this.C0.s1().O() != null && this.C0.s1().O().getActUrl() != null) {
            BrowserHelper.startWebActivity(getActivity(), this.C0.s1().O().getActUrl());
            if (this.C0.s1().O().getActInfoType() == 1) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
            } else if (this.C0.s1().O().getActInfoType() == 2) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048756, this) == null) {
            this.g = true;
            super.onPause();
            jm9.a();
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
            dk9 dk9Var = this.J0;
            if (dk9Var != null) {
                dk9Var.L2();
            }
            if (this.Y0 != null && !this.C0.f1()) {
                this.Y0.P(this.C0.M1());
            }
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                pbModel.v2();
            }
            PushPermissionController pushPermissionController = this.w0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            un4.w().E();
            MessageManager.getInstance().unRegisterListener(this.E1);
            Z7();
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            sa5 sa5Var = this.r0;
            if (sa5Var != null) {
                sa5Var.q();
                this.r0.p();
            }
        }
    }

    public final void q7() {
        MarkData I0;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048769, this) == null) && this.E0 != null) {
            if (this.C0.s1() != null && this.C0.s1().j0()) {
                I0 = this.C0.I0(0);
            } else {
                I0 = this.C0.I0(this.J0.l1());
            }
            if (I0 == null) {
                return;
            }
            if (I0.isApp() && (I0 = this.C0.I0(this.J0.l1() + 1)) == null) {
                return;
            }
            this.J0.S3();
            this.E0.i(I0);
            if (!this.E0.e()) {
                if (this.J0 != null && (pbModel = this.C0) != null && !mm9.g(pbModel.b)) {
                    this.J0.F4();
                    mm9.a(this.C0.b);
                }
                this.E0.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.E0.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final boolean E8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.s1() != null && this.C0.s1().j0()) {
                return true;
            }
            if (this.C0.d1()) {
                MarkData O0 = this.C0.O0();
                if (O0 == null || !this.C0.b1()) {
                    return true;
                }
                MarkData I0 = this.C0.I0(this.J0.d1());
                if (I0 == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", O0);
                    this.b.setResult(-1, intent);
                    return true;
                } else if (I0.getPostId() != null && !I0.getPostId().equals(O0.getPostId())) {
                    hz4 hz4Var = new hz4(getPageContext().getPageActivity());
                    hz4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f029b));
                    hz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c8, new o2(this, I0, O0, hz4Var));
                    hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new p2(this, O0, hz4Var));
                    hz4Var.setOnCalcelListener(new q2(this, O0, hz4Var));
                    hz4Var.create(getPageContext());
                    hz4Var.show();
                    return false;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", O0);
                    this.b.setResult(-1, intent2);
                    return true;
                }
            }
            if (this.C0.s1() != null && this.C0.s1().F() != null && this.C0.s1().F().size() > 0 && this.C0.b1()) {
                this.b.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void H6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (this.g) {
                this.P = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.C0.s1() != null && this.C0.s1().O() != null && this.C0.s1().O().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.C0.s1().O().getTaskInfoData().k(), this.C0.s1().O().getTaskInfoData().h(), this.C0.s1().O().getTaskInfoData().c(), this.C0.s1().O().getTaskInfoData().d(), this.C0.s1().O().getIs_top(), this.C0.s1().O().getIs_good())));
                this.b.finish();
            }
        }
    }

    public final void H8() {
        PbModel pbModel;
        String name;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (pbModel = this.C0) != null && pbModel.s1() != null && this.C0.s1().k() != null && !ad.isEmpty(this.C0.s1().k().getName())) {
            if (this.C0.getErrorNo() == 4) {
                if (StringUtils.isNull(this.C0.R0()) && this.C0.H0() != null) {
                    name = this.C0.H0().b;
                } else {
                    this.b.finish();
                    return;
                }
            } else {
                name = this.C0.s1().k().getName();
            }
            if (StringUtils.isNull(name)) {
                this.b.finish();
                return;
            }
            String R0 = this.C0.R0();
            if (this.C0.X0() && R0 != null && R0.equals(name)) {
                this.b.finish();
            } else {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(this.C0.s1().k().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            }
            xn9.A(this.C0);
        }
    }

    public final void Y5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.s1() != null) {
                oea z3 = this.C0.s1().z();
                if (z3 != null) {
                    if (z3.getAdvertAppInfo() != null) {
                        z3.getAdvertAppInfo().h = null;
                    }
                    this.C0.s1().b();
                }
                if (this.C0.K0() != null) {
                    this.C0.x0();
                }
                this.C0.X1();
            }
            if (this.C0.s1().F() != null) {
                Iterator<pea> it = this.C0.s1().F().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof oea) {
                        it.remove();
                    }
                }
            }
            if (this.J0.T0() != null && !ListUtils.isEmpty(this.J0.T0().v())) {
                ck9.e(this.J0.T0().v());
            }
            if (this.J0.m1() != null && !ListUtils.isEmpty(this.J0.m1().getData())) {
                ck9.e(this.J0.m1().getData());
            }
            if (this.J0.T0() != null) {
                this.J0.T0().f0();
            }
        }
    }

    public final void m6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048733, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.J0.F0();
            SparseArray<Object> n12 = this.J0.n1(this.C0.s1(), this.C0.L1(), 1);
            if (n12 == null) {
                return;
            }
            sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(getPageContext().getPageActivity(), this.C0.s1().k().getId(), this.C0.s1().k().getName(), this.C0.s1().O().getId(), StringUtils.string(this.C0.s1().V().getUserId()), StringUtils.string(n12.get(R.id.tag_forbid_user_name)), StringUtils.string(n12.get(R.id.tag_forbid_user_name_show)), StringUtils.string(n12.get(R.id.tag_forbid_user_post_id)), StringUtils.string(n12.get(R.id.tag_forbid_user_portrait)))));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            this.g = false;
            super.onResume();
            if (this.P) {
                this.P = false;
                H6();
            }
            if (Y6()) {
                this.u = System.currentTimeMillis();
            } else {
                this.u = -1L;
            }
            dk9 dk9Var = this.J0;
            if (dk9Var != null && dk9Var.G1() != null) {
                if (!this.h) {
                    r8();
                } else {
                    hideLoadingView(this.J0.G1());
                }
                this.J0.O2();
            }
            if (this.k == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            dk9 dk9Var2 = this.J0;
            if (dk9Var2 != null) {
                noNetworkView = dk9Var2.a();
            }
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.update(false);
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.E1);
            this.S0 = false;
            a8();
            registerListener(this.Z1);
            registerListener(this.a2);
            registerListener(this.c2);
            PushPermissionController pushPermissionController = this.w0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.q1) {
                S7();
                this.q1 = false;
            }
            z8();
            ItemCardHelper.w(this.J2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                oc5.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048761, this) == null) {
            super.onStop();
            if (this.u > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.u;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.u = 0L;
            }
            if (E6().x1() != null) {
                E6().x1().n();
            }
            xm9 xm9Var = this.J0.k;
            if (xm9Var != null && !xm9Var.n()) {
                this.J0.k.r();
            }
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.s1() != null && this.C0.s1().k() != null && this.C0.s1().O() != null) {
                lc5.j().x(getPageContext().getPageActivity(), "pb", this.C0.s1().k().getId(), JavaTypesHelper.toLong(this.C0.s1().O().getId(), 0L));
            }
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            rca.g().h(getUniqueId(), false);
        }
    }

    public final String s6() {
        InterceptResult invokeV;
        ArrayList<pea> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel == null || pbModel.s1() == null || this.C0.s1().F() == null || (count = ListUtils.getCount((F = this.C0.s1().F()))) == 0) {
                return "";
            }
            if (this.C0.E1()) {
                Iterator<pea> it = F.iterator();
                while (it.hasNext()) {
                    pea next = it.next();
                    if (next != null && next.L() == 1) {
                        return next.U();
                    }
                }
            }
            int d12 = this.J0.d1();
            pea peaVar = (pea) ListUtils.getItem(F, d12);
            if (peaVar != null && peaVar.t() != null) {
                if (this.C0.m2(peaVar.t().getUserId())) {
                    return peaVar.U();
                }
                for (int i4 = d12 - 1; i4 != 0; i4--) {
                    pea peaVar2 = (pea) ListUtils.getItem(F, i4);
                    if (peaVar2 == null || peaVar2.t() == null || peaVar2.t().getUserId() == null) {
                        break;
                    } else if (this.C0.m2(peaVar2.t().getUserId())) {
                        return peaVar2.U();
                    }
                }
                for (int i5 = d12 + 1; i5 < count; i5++) {
                    pea peaVar3 = (pea) ListUtils.getItem(F, i5);
                    if (peaVar3 == null || peaVar3.t() == null || peaVar3.t().getUserId() == null) {
                        break;
                    } else if (this.C0.m2(peaVar3.t().getUserId())) {
                        return peaVar3.U();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void u7() {
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048784, this) == null) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
            if (this.C0.s1() != null && this.C0.s1().O() != null && this.C0.s1().O().isVideoThreadType() && this.C0.s1().O().getThreadVideoInfo() != null) {
                TiebaStatic.log(new StatisticItem("c11922"));
            }
            if (this.C0.getErrorNo() == 4) {
                if (StringUtils.isNull(this.C0.R0()) && this.C0.H0() != null) {
                    name = this.C0.H0().b;
                } else {
                    this.b.finish();
                    return;
                }
            } else {
                name = this.C0.s1().k().getName();
            }
            if (StringUtils.isNull(name)) {
                this.b.finish();
                return;
            }
            String R0 = this.C0.R0();
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getPageContext().getPageActivity()).createNormalCfg(name, FrsActivityConfig.FRS_FROM_PB);
            if (this.C0.X0() && R0 != null && R0.equals(name)) {
                this.b.finish();
            } else {
                sendMessage(new CustomMessage(2003000, createNormalCfg));
            }
        }
    }

    public final void F5(SparseArray<Object> sparseArray, List<nz4> list, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str) {
        nz4 nz4Var;
        nz4 nz4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{sparseArray, list, Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z7), str}) == null) {
            nz4 nz4Var3 = null;
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
                        nz4 nz4Var4 = new nz4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0551), this.P0);
                        nz4Var4.d.setTag(sparseArray2);
                        nz4Var3 = nz4Var4;
                    }
                } else {
                    sparseArray2.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                nz4Var = new nz4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0326), this.P0);
                nz4Var.d.setTag(sparseArray2);
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
                if (this.C0.s1().W() == 1002 && !z3) {
                    nz4Var2 = new nz4(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.P0);
                } else {
                    nz4Var2 = new nz4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0551), this.P0);
                }
                nz4Var2.d.setTag(sparseArray3);
                nz4Var3 = nz4Var2;
                nz4Var = null;
            } else {
                nz4Var = null;
            }
            if (nz4Var3 != null) {
                list.add(nz4Var3);
            }
            if (nz4Var != null) {
                list.add(nz4Var);
            }
        }
    }

    public final void F6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.H0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.H0 = pollingModel;
                pollingModel.setDialogTime(a05.e);
            }
            this.H0.getData(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            SafeHandler.getInst().postDelayed(this.Y1, 10000L);
        }
    }

    public final void G5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.o1 != null) {
                ih5.b bVar = new ih5.b();
                bVar.a = this.o1.R();
                bVar.b = this.o1.P();
                bVar.c = String.valueOf(this.o1.S());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.n1));
        }
    }

    public final void G7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.r1 >= 0) {
            PbModel pbModel = this.C0;
            if (pbModel != null) {
                pbModel.N2();
            }
            if (this.C0 != null && this.J0.T0() != null) {
                this.J0.T0().n0(this.C0.s1(), false);
            }
            this.r1 = 0;
            if (this.C0 != null) {
                if (this.J0.m1() != null) {
                    this.J0.m1().setSelection(this.C0.l1());
                }
                this.C0.R2(0, 0);
            }
        }
    }

    public final void G8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (pbModel = this.C0) != null && pbModel.s1() != null) {
            ye9 s12 = this.C0.s1();
            if (this.G0 == null) {
                this.G0 = new rf9(getPageContext());
            }
            long j3 = JavaTypesHelper.toLong(s12.Q(), 0L);
            long j4 = JavaTypesHelper.toLong(s12.l(), 0L);
            xn9.M("c13446", j4);
            registerListener(this.r2);
            this.G0.a(j3, j4);
        }
    }

    public final void I6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.J0.D3(true);
            this.J0.p3();
            if (this.i) {
                return;
            }
            this.i = true;
            this.J0.C4();
            C8();
            this.J0.S3();
            this.C0.k3(s6());
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
        }
    }

    public final void J8() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (absPbActivity = this.b) != null && absPbActivity.J1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.b.J1().M1()).param("topic_id", this.b.J1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.b.J1().Q1()));
        }
    }

    public final void M8() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.S(this.C0.getForumId()) && this.C0.s1() != null && this.C0.s1().k() != null) {
            boolean z3 = true;
            if (this.C0.s1().k().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.C0.F0().R(this.C0.getForumId(), this.C0.M1());
            }
        }
    }

    public final boolean N5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel == null || pbModel.s1() == null) {
                return false;
            }
            ThreadData O = this.C0.s1().O();
            AntiData c4 = this.C0.s1().c();
            if (!AntiHelper.b(getPageContext(), O) && !AntiHelper.d(getPageContext(), c4)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean Q5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            if ((this.C0.s1() != null && (this.C0.s1().j0() || ThreadCardUtils.isSelf(this.C0.s1().O()))) || this.a1 == null || this.C0.s1() == null || this.C0.s1().c() == null) {
                return true;
            }
            return this.a1.checkPrivacyBeforeInvokeEditor(this.C0.s1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void T5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            if (this.C0.X0() || this.C0.a1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.C0.M1());
                this.b.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.C0.M1()));
            if (E8()) {
                this.b.finish();
            }
        }
    }

    public final void U5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
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

    public final boolean Y6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            pea c4 = ze9.c(this.C0.s1(), this.C0.L1(), this.C0.D1());
            if (c4 != null && c4.t() != null && c4.t().getGodUserData() != null && c4.t().getGodUserData().getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void e7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048701, this) == null) {
            this.J0.F0();
            if (e0().s1().g == 2) {
                showToast(R.string.hot_sort_jump_hint);
                return;
            }
            if (this.C0.q1() != null) {
                this.J0.G4(this.C0.q1(), this.i2);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
        }
    }

    public final void h7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.J0.F0();
            C8();
            this.J0.S3();
            this.J0.s4();
            if (this.J0.v1() != null) {
                this.J0.v1().setVisibility(8);
            }
            this.C0.g3(1);
            ol9 ol9Var = this.f;
            if (ol9Var != null) {
                ol9Var.x();
            }
        }
    }

    public final void i7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048718, this) == null) && this.R2 != null) {
            if (this.P2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f1011);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.R2.a(), this.P2, 0)));
                this.b.finish();
            }
        }
    }

    public final void k7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048726, this) == null) && this.R2 != null) {
            if (this.O2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f1012);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.R2.a(), this.O2, 0)));
                this.b.finish();
            }
        }
    }

    public final void p8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048767, this) == null) {
            hz4 hz4Var = new hz4(getPageContext().getPageActivity());
            hz4Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            hz4Var.setPositiveButton(R.string.open_now, new h(this));
            hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new i(this));
            hz4Var.create(this.h1).show();
        }
    }

    public final void r8() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048773, this) == null) {
            showLoadingView(this.J0.G1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d5));
            View attachedView = getLoadingView().getAttachedView();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
            layoutParams.addRule(3, this.J0.F1().getId());
            attachedView.setLayoutParams(layoutParams);
        }
    }

    public final void t7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048779, this) == null) && getPageContext().getPageActivity() != null && this.C0 != null) {
            sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(getPageContext().getPageActivity(), this.C0.M1(), this.C0.e2(), this.C0.d2())));
            xn9.C(this.C0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void F7(View view2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        nz4 nz4Var;
        boolean z11;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, view2) != null) || !checkUpIsLogin()) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c11740"));
        if (view2 != null && view2.getTag() != null) {
            SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
            pea peaVar = (pea) sparseArray.get(R.id.tag_load_sub_data);
            if (view2.getId() != R.id.replybtn_top_right && view2.getId() != R.id.cover_reply_content_top_right) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                TiebaStatic.log(new StatisticItem("c12006").param("tid", this.C0.b));
            }
            if (this.P0 == null) {
                rz4 rz4Var = new rz4(getContext());
                this.P0 = rz4Var;
                rz4Var.r(this.k2);
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
            if (peaVar != null) {
                if (peaVar.f0() != null && peaVar.f0().toString().length() > 0) {
                    nz4 nz4Var2 = new nz4(3, getString(R.string.obfuscated_res_0x7f0f04eb), this.P0);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, peaVar);
                    nz4Var2.d.setTag(sparseArray2);
                    arrayList.add(nz4Var2);
                }
                this.D2 = peaVar;
            }
            if (this.C0.s1().q()) {
                String u3 = this.C0.s1().u();
                if (peaVar != null && !ad.isEmpty(u3) && u3.equals(peaVar.U())) {
                    z10 = true;
                    if (!z10) {
                        nz4Var = new nz4(4, getString(R.string.remove_mark), this.P0);
                    } else {
                        nz4Var = new nz4(4, getString(R.string.obfuscated_res_0x7f0f0c69), this.P0);
                    }
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.D2);
                    sparseArray3.put(R.id.tag_is_subpb, Boolean.FALSE);
                    nz4Var.d.setTag(sparseArray3);
                    arrayList.add(nz4Var);
                    if (this.mIsLogin) {
                        if (!fm9.j(this.C0) && !z6 && z5) {
                            nz4 nz4Var3 = new nz4(5, getString(R.string.obfuscated_res_0x7f0f0d2b), this.P0);
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
                            nz4Var.d.setTag(sparseArray4);
                            arrayList.add(nz4Var3);
                        } else {
                            if (ck9.C(this.C0.s1(), z4) && TbadkCoreApplication.isLogin()) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z11) {
                                nz4 nz4Var4 = new nz4(5, getString(R.string.report_text), this.P0);
                                nz4Var4.d.setTag(str2);
                                arrayList.add(nz4Var4);
                            }
                        }
                        F5(sparseArray, arrayList, z4, z6, z7, z8, z9, str2);
                    }
                    this.P0.m(arrayList);
                    pz4 pz4Var = new pz4(getPageContext(), this.P0);
                    this.O0 = pz4Var;
                    pz4Var.l();
                }
            }
            z10 = false;
            if (!z10) {
            }
            SparseArray sparseArray32 = new SparseArray();
            sparseArray32.put(R.id.tag_clip_board, this.D2);
            sparseArray32.put(R.id.tag_is_subpb, Boolean.FALSE);
            nz4Var.d.setTag(sparseArray32);
            arrayList.add(nz4Var);
            if (this.mIsLogin) {
            }
            this.P0.m(arrayList);
            pz4 pz4Var2 = new pz4(getPageContext(), this.P0);
            this.O0 = pz4Var2;
            pz4Var2.l();
        }
    }

    public final void h6(View view2) {
        String str;
        int i4;
        PbModel pbModel;
        ye9 ye9Var;
        pea X;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091975) {
                xn9.I(4, this.C0);
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f091afc && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                this.f1142T = view2;
            } else if (!checkUpIsLogin()) {
                xn9.u("c10517", this.C0.s1().l(), 3);
            } else {
                PbModel pbModel2 = this.C0;
                if (pbModel2 != null && pbModel2.s1() != null) {
                    this.J0.F0();
                    SparseArray sparseArray = (SparseArray) view2.getTag();
                    pea peaVar = (pea) sparseArray.get(R.id.tag_load_sub_data);
                    pea peaVar2 = (pea) sparseArray.get(R.id.tag_load_sub_reply_data);
                    View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
                    if (peaVar != null && view3 != null) {
                        boolean z3 = true;
                        if (peaVar.P() == 1) {
                            TiebaStatic.log(new StatisticItem("c12630"));
                        }
                        StatisticItem statisticItem = peaVar.g0;
                        if (statisticItem != null) {
                            StatisticItem copy = statisticItem.copy();
                            copy.delete("obj_locate");
                            if (view2.getId() == R.id.obfuscated_res_0x7f091975) {
                                copy.param("obj_locate", 6);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091afc) {
                                copy.param("obj_locate", 8);
                            }
                            TiebaStatic.log(copy);
                        }
                        String M1 = this.C0.M1();
                        String U = peaVar.U();
                        if (peaVar2 != null) {
                            str = peaVar2.U();
                        } else {
                            str = "";
                        }
                        if (this.C0.s1() != null) {
                            i4 = this.C0.s1().W();
                        } else {
                            i4 = 0;
                        }
                        C8();
                        if (view2.getId() == R.id.obfuscated_res_0x7f091f18) {
                            AbsPbActivity.e M7 = M7(U);
                            PbModel pbModel3 = this.C0;
                            if (pbModel3 != null && pbModel3.s1() != null && M7 != null) {
                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(M1, U, "pb", true, false, null, true, null, i4, peaVar.m0(), this.C0.s1().c(), false, peaVar.t().getIconInfo(), 5).addBigImageData(M7.a, M7.b, M7.g, M7.j);
                                addBigImageData.setKeyPageStartFrom(this.C0.r1());
                                addBigImageData.setFromFrsForumId(this.C0.getFromForumId());
                                addBigImageData.setWorksInfoData(this.C0.R1());
                                addBigImageData.setKeyFromForumId(this.C0.getForumId());
                                addBigImageData.setBjhData(this.C0.J0());
                                addBigImageData.setTiebaPlusData(this.C0.W(), this.C0.S(), this.C0.T(), this.C0.R(), this.C0.X());
                                sendMessage(new CustomMessage(2002001, addBigImageData));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log("c11742");
                        AbsPbActivity.e M72 = M7(U);
                        if (peaVar != null && (pbModel = this.C0) != null && pbModel.s1() != null && M72 != null) {
                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(M1, U, "pb", true, false, null, false, str, i4, peaVar.m0(), this.C0.s1().c(), false, peaVar.t().getIconInfo(), 5).addBigImageData(M72.a, M72.b, M72.g, M72.j);
                            if (!ad.isEmpty(str)) {
                                addBigImageData2.setHighLightPostId(str);
                                addBigImageData2.setKeyIsUseSpid(true);
                            }
                            addBigImageData2.setKeyFromForumId(this.C0.getForumId());
                            addBigImageData2.setTiebaPlusData(this.C0.W(), this.C0.S(), this.C0.T(), this.C0.R(), this.C0.X());
                            addBigImageData2.setBjhData(this.C0.J0());
                            addBigImageData2.setKeyPageStartFrom(this.C0.r1());
                            addBigImageData2.setFromFrsForumId(this.C0.getFromForumId());
                            addBigImageData2.setWorksInfoData(this.C0.R1());
                            if (this.J0 != null && (ye9Var = this.C0.G) != null && (X = ye9Var.X()) != null) {
                                if (!X.f1148T && !peaVar.f1148T) {
                                    z3 = false;
                                }
                                addBigImageData2.setMainPostMaskVisibly(z3);
                            }
                            if (this.C0.s1() != null && this.C0.s1().n() != null) {
                                addBigImageData2.setHasForumRule(this.C0.s1().n().has_forum_rule.intValue());
                            }
                            sendMessage(new CustomMessage(2002001, addBigImageData2));
                        }
                    }
                }
            }
        }
    }

    public final void F8(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, view2) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
            String string2 = SharedPrefHelper.getInstance().getString("tail_link", "");
            String string3 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
            if (!StringUtils.isNull(string2)) {
                TiebaStatic.log("c10056");
                Context context = view2.getContext();
                BrowserHelper.startWebActivity(context, string, UtilHelper.urlAddParam(string2, "page_from=1&tailSkinId=" + string3), true, true, true);
            }
            this.J0.p3();
            TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string3));
        }
    }

    public final void M6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.s1() != null && this.C0.s1().j0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.C0.M1(), str);
                ThreadData O = this.C0.s1().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                g7(format);
                return;
            }
            this.D0.a(str);
        }
    }

    public void P7(pf9 pf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, pf9Var) == null) {
            String U = pf9Var.g().U();
            List<pea> list = this.C0.s1().T().a;
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                pea peaVar = list.get(i4);
                if (peaVar.U() != null && peaVar.U().equals(U)) {
                    ArrayList<pea> i5 = pf9Var.i();
                    peaVar.q1(pf9Var.k());
                    if (peaVar.j0() != null) {
                        peaVar.j0().clear();
                        peaVar.j0().addAll(i5);
                    }
                } else {
                    i4++;
                }
            }
            if (!this.C0.b1()) {
                this.J0.g2(this.C0.s1());
            }
        }
    }

    public final void X5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048674, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.C0) != null && pbModel.s1() != null) {
            oea z3 = this.C0.s1().z();
            if (z3 != null && str.equals(z3.E1())) {
                if (z3.getAdvertAppInfo() != null) {
                    z3.getAdvertAppInfo().h = null;
                }
                this.C0.s1().b();
            }
            oea K0 = this.C0.K0();
            if (K0 != null && str.equals(K0.E1())) {
                this.C0.x0();
            }
        }
    }

    public final void g6(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048708, this, view2) != null) || !(view2.getTag() instanceof ThreadData)) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        if (this.C0.r1() == 3 && P0() && this.C0.s1() != null && ListUtils.isEmpty(this.C0.s1().o())) {
            this.b.finish();
        } else {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
        xn9.z(threadData);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048746, this, i4) != null) || this.X == i4) {
            return;
        }
        super.onChangeSkinType(i4);
        this.J0.E2(i4);
        hf5 hf5Var = this.Y0;
        if (hf5Var != null && hf5Var.a() != null) {
            this.Y0.a().z(i4);
        }
        if (this.J0.a() != null) {
            this.J0.a().onChangeSkinType(getPageContext(), i4);
        }
        this.N0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i4, getResources(), R.color.CAM_X0201), true);
        this.X = i4;
        C8();
        sa5 sa5Var = this.r0;
        if (sa5Var != null) {
            sa5Var.w();
        }
    }

    public void s7(pea peaVar) {
        boolean z3;
        pea p6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048776, this, peaVar) != null) || peaVar == null) {
            return;
        }
        if (peaVar.U() != null && peaVar.U().equals(this.C0.n1())) {
            z3 = true;
        } else {
            z3 = false;
        }
        MarkData m12 = this.C0.m1(peaVar);
        if (this.C0.s1() != null && this.C0.s1().j0() && (p6 = p6()) != null) {
            m12 = this.C0.m1(p6);
        }
        if (m12 == null) {
            return;
        }
        this.J0.S3();
        oq4 oq4Var = this.E0;
        if (oq4Var != null) {
            oq4Var.i(m12);
            if (!z3) {
                this.E0.a();
            } else {
                this.E0.d();
            }
        }
    }

    public final void v8(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048789, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && e0() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                e0().A0(postWriteCallBackData.getPostId());
                int Z0 = this.J0.Z0();
                this.r1 = Z0;
                this.C0.R2(Z0, this.J0.g1());
            }
            this.J0.F0();
            this.N0.c();
            hf5 hf5Var = this.Y0;
            if (hf5Var != null) {
                this.J0.x3(hf5Var.A());
            }
            this.J0.L1();
            this.J0.k4(true);
            this.C0.X1();
        }
    }

    public final void H5(boolean z3, boolean z4, SparseArray<Object> sparseArray, List<nz4> list, boolean z5, boolean z6, String str) {
        boolean z7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4), sparseArray, list, Boolean.valueOf(z5), Boolean.valueOf(z6), str}) == null) {
            if (!fm9.j(this.C0) && !z3 && z4) {
                nz4 nz4Var = new nz4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0d2b), this.P0);
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
                nz4Var.d.setTag(sparseArray2);
                list.add(nz4Var);
                return;
            }
            if (ck9.C(this.C0.s1(), z5) && TbadkCoreApplication.isLogin()) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 && !z6) {
                nz4 nz4Var2 = new nz4(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.P0);
                nz4Var2.d.setTag(str);
                list.add(nz4Var2);
            }
        }
    }

    public final void H7(View view2) {
        SparseArray sparseArray;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, view2) == null) && (sparseArray = (SparseArray) view2.getTag()) != null && (sparseArray.get(R.id.tag_load_sub_data) instanceof pea)) {
            pea peaVar = (pea) sparseArray.get(R.id.tag_load_sub_data);
            View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
            if (peaVar != null && view3 != null) {
                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09087f);
                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090880);
                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b85);
                boolean z3 = false;
                if (peaVar.D0()) {
                    peaVar.j1(false);
                    jm9.e(peaVar);
                } else {
                    if (e0() != null) {
                        z3 = jm9.c(e0().s1(), peaVar);
                    }
                    if (z3) {
                        peaVar.j1(true);
                    }
                }
                if (peaVar.D0()) {
                    i4 = R.color.CAM_X0201;
                } else {
                    i4 = R.color.transparent;
                }
                SkinManager.setBackgroundColor(findViewById, i4);
                boolean D0 = peaVar.D0();
                int i7 = R.color.CAM_X0304;
                if (D0) {
                    i5 = R.color.CAM_X0304;
                } else {
                    i5 = R.color.CAM_X0107;
                }
                SkinManager.setViewTextColor(eMTextView, i5);
                if (peaVar.D0()) {
                    i6 = R.drawable.icon_pure_pb_del_select;
                } else {
                    i6 = R.drawable.icon_pure_pb_del_normal;
                }
                if (!peaVar.D0()) {
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
    public final void S5(AgreeData agreeData) {
        tm5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048654, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.f0 == null) {
            this.f0 = new t35();
        }
        if (this.j0 == null) {
            AgreeMessageData agreeMessageData = new AgreeMessageData();
            this.j0 = agreeMessageData;
            agreeMessageData.uniqueId = getUniqueId();
        }
        pv4 pv4Var = new pv4();
        pv4Var.b = 5;
        pv4Var.h = 8;
        pv4Var.g = 2;
        if (e0() != null) {
            pv4Var.f = e0().r1();
        }
        pv4Var.a = 2;
        int i4 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                pv4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.f0.c(agreeData, i4, getUniqueId(), false);
                this.f0.d(agreeData, this.j0);
                pbModel = this.C0;
                if (pbModel == null && pbModel.s1() != null) {
                    this.f0.b(l0(), pv4Var, agreeData, this.C0.s1().O());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            pv4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            pv4Var.i = 1;
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

    public final void V7(View view2) {
        boolean k3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                view2.setTag(Boolean.FALSE);
                return;
            }
            this.J0.F0();
            if (this.J0.k.i() != null && view2 == this.J0.k.i().z()) {
                this.J0.p3();
            }
            if (this.i) {
                view2.setTag(Boolean.FALSE);
                return;
            }
            C8();
            this.J0.S3();
            if (view2.getId() == R.id.obfuscated_res_0x7f090b89) {
                k3 = this.C0.l3(true, s6());
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091f13) {
                k3 = this.C0.l3(false, s6());
            } else {
                k3 = this.C0.k3(s6());
            }
            view2.setTag(Boolean.valueOf(k3));
            if (k3) {
                this.J0.D3(true);
                this.J0.C4();
                this.i = true;
                this.J0.H3(true);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
        }
    }

    public final void m7(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048734, this, view2) == null) && (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String)) {
            String string = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
            TiebaStatic.log(new StatisticItem("c10912").param("fid", this.C0.s1().l()).param("tid", this.C0.s1().Q()).param("lotterytail", StringUtils.string(string, "_", TbadkCoreApplication.getCurrentAccount())));
            if (this.C0.s1().Q().equals(string)) {
                this.J0.W3(0);
            } else {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getActivity()).createNormalCfg(string, (String) null, (String) null, (String) null)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ye9 s12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (E6() != null && ck9.D(this)) {
                E6().M4();
            }
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907bc));
            PbModel pbModel = this.C0;
            if (pbModel != null && (s12 = pbModel.s1()) != null) {
                this.s2.c(true, 0, 3, 0, s12, "", 1, true);
            }
            this.b.L1().k(this.u0);
            if (a7()) {
                AbsPbActivity absPbActivity = this.b;
                if (absPbActivity instanceof PbActivity) {
                    ((PbActivity) absPbActivity).g2();
                }
            }
            PbModel pbModel2 = this.C0;
            if (pbModel2 != null && this.H.b(pbModel2.G, getContext(), this.b.findViewById(this.J0.U0()), this.C0.getForumId(), this.C0.M1())) {
                AbsPbActivity absPbActivity2 = this.b;
                if (absPbActivity2 instanceof PbActivity) {
                    ((PbActivity) absPbActivity2).g2();
                }
            }
        }
    }

    public final void I7(View view2) {
        ty4 ty4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, view2) == null) && checkUpIsLogin() && (ty4Var = (ty4) view2.getTag()) != null && !StringUtils.isNull(ty4Var.D1())) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{ty4Var.D1()});
        }
    }

    public void J7(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, animatorListener) == null) && this.J0 != null && (pbModel = this.C0) != null && pbModel.s1() != null && this.C0.s1().S() != null && checkUpIsLogin() && this.J0.T0() != null && this.J0.T0().B() != null) {
            this.J0.T0().B().U(animatorListener);
        }
    }

    public final void K5(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048618, this, view2) != null) || !(view2.getTag() instanceof ThreadData)) {
            return;
        }
        ThreadData threadData = (ThreadData) view2.getTag();
        FrsActivityConfig createNormalCfg = new FrsActivityConfig(getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
        createNormalCfg.setCallFrom(14);
        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        xn9.H(threadData, 9, 9);
    }

    public final void K8(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048621, this, z3) == null) && (absPbActivity = this.b) != null && absPbActivity.J1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.b.J1().M1()).param("topic_id", this.b.J1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.b.J1().Q1()));
        }
    }

    public void O5(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.J0.s4();
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

    public boolean R5(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048650, this, i4)) == null) {
            if (this.a1 != null && this.C0.s1() != null && !ThreadCardUtils.isSelf(this.C0.s1().O()) && this.C0.s1().c() != null) {
                return this.a1.checkPrivacyBeforeSend(this.C0.s1().c().replyPrivateFlag, i4);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void b7(View view2) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048690, this, view2) == null) && view2 != null) {
            BrowserHelper.startWebActivity(getActivity(), StringUtils.string(view2.getTag()));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (o6() == 1 && (pbModel = this.C0) != null && pbModel.s1() != null) {
                xn9.D("c10397", this.C0.s1().l(), this.C0.s1().Q(), currentAccount);
            }
        }
    }

    public final void d7(View view2) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048697, this, view2) == null) && view2 != null) {
            String string = StringUtils.string(view2.getTag());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            BrowserHelper.startWebActivity(getActivity(), string);
            if (o6() == 1 && (pbModel = this.C0) != null && pbModel.s1() != null) {
                xn9.D("c10507", this.C0.s1().l(), this.C0.s1().Q(), currentAccount);
            }
        }
    }

    public final void g8(if5 if5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048710, this, if5Var) == null) && if5Var != null && (pbModel = this.C0) != null) {
            if5Var.p(pbModel.R0());
            if (this.C0.s1() != null && this.C0.s1().k() != null) {
                if5Var.o(this.C0.s1().k());
            }
            if5Var.q("pb");
            if5Var.r(this.C0);
            if5Var.s(PbNewEditorTool.InputShowType.REPLY);
        }
    }

    public final void h8(int i4) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048715, this, i4) != null) || (pbModel = this.C0) == null) {
            return;
        }
        int C1 = pbModel.C1();
        if (i4 != 5) {
            if (i4 != 6) {
                if (i4 != 7) {
                    this.C0.c3(1);
                } else {
                    this.C0.c3(4);
                }
            } else {
                this.C0.c3(3);
            }
        } else {
            this.C0.c3(2);
        }
        int C12 = this.C0.C1();
        if (C1 == 4 || C12 == 4) {
            z7();
        }
    }

    public final void j7(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, bundle) == null) {
            PbModel J1 = this.b.J1();
            this.C0 = J1;
            if (J1 != null) {
                if (J1.N0() != null) {
                    this.C0.N0().c(this.N2);
                }
                if (this.C0.o1() != null) {
                    this.C0.o1().f(this.x1);
                }
                if (StringUtils.isNull(this.C0.M1())) {
                    this.b.finish();
                } else if ("from_tieba_kuang".equals(this.N) && this.N != null) {
                    this.C0.Z2(6);
                }
            }
        }
    }

    public void n8(View view2) {
        ye9 A6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048739, this, view2) == null) {
            int i4 = SharedPrefHelper.getInstance().getInt(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb"), 0);
            AbsPbActivity absPbActivity = this.b;
            if ((absPbActivity == null || absPbActivity.getIntent() == null || !this.b.getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) || (i4 != 1 && i4 != 2 && i4 != 3)) && (A6 = A6()) != null) {
                gm9.d(getContext(), view2, A6);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z3;
        dk9 dk9Var;
        xm9 xm9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048748, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (UtilHelper.isFoldScreen() && (dk9Var = this.J0) != null && (xm9Var = dk9Var.k) != null && xm9Var.n()) {
                this.J0.k.g();
                A7();
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
            dk9 dk9Var2 = this.J0;
            if (dk9Var2 != null) {
                dk9Var2.F2(configuration);
            }
            pz4 pz4Var = this.O0;
            if (pz4Var != null) {
                pz4Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public final void K7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (this.J0.j1().getIndicateStatus()) {
                ye9 s12 = this.C0.s1();
                if (s12 != null && s12.O() != null && s12.O().getTaskInfoData() != null) {
                    String e4 = s12.O().getTaskInfoData().e();
                    if (StringUtils.isNull(e4)) {
                        e4 = s12.O().getTaskInfoData().h();
                    }
                    TiebaStatic.log(new StatisticItem("c11107").param("obj_id", e4));
                }
            } else {
                vea.d("c10725", null);
            }
            H6();
        }
    }

    public void L7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            if (!checkUpIsLogin()) {
                xn9.N(2, 1);
                return;
            }
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.s1() != null && this.C0.s1().k() != null) {
                if (N5()) {
                    xn9.N(3, 1);
                    return;
                } else if (this.C0.s1().j0()) {
                    xn9.N(7, 1);
                    this.J0.w0();
                    return;
                } else {
                    hf5 hf5Var = this.Y0;
                    if (hf5Var != null && hf5Var.a() != null) {
                        this.Y0.a().D(new cd5(45, 27, null));
                    }
                    this.J0.w0();
                    return;
                }
            }
            xn9.N(20, 1);
        }
    }

    public final void R6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048651, this) == null) && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            long j3 = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L);
            sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(getPageContext().getPageActivity(), 24008, JavaTypesHelper.toLong(this.C0.s1().l(), 0L), JavaTypesHelper.toLong(this.C0.M1(), 0L), j3, this.C0.s1().O().getPushStatusData())));
        }
    }

    public final void V6() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048667, this) != null) || this.l != null) {
            return;
        }
        this.l = new iz4(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        iz4 iz4Var = this.l;
        iz4Var.j(strArr, new y0(this));
        iz4Var.g(iz4.b.a);
        iz4Var.h(17);
        iz4Var.c(getPageContext());
    }

    public final void v7() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048788, this) != null) || gr5.a()) {
            return;
        }
        PbModel pbModel = this.C0;
        if (pbModel != null && pbModel.s1() != null) {
            ArrayList<pea> F = this.C0.s1().F();
            if ((F == null || F.size() <= 0) && this.C0.L1()) {
                BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1013));
                return;
            }
            xn9.F(this.C0);
            this.J0.p3();
            A7();
            return;
        }
        BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f1013));
    }

    public void L6(boolean z3, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
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
            y8(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void M5(boolean z3) {
        dk9 dk9Var;
        int i4;
        int y3;
        pea peaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048627, this, z3) == null) && (dk9Var = this.J0) != null && dk9Var.m1() != null) {
            int firstVisiblePosition = this.J0.m1().getFirstVisiblePosition();
            int lastVisiblePosition = this.J0.m1().getLastVisiblePosition();
            li9 T0 = this.J0.T0();
            if (T0 != null && this.C0.s1() != null) {
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
                        if (this.J0.m1().G(i4) != null && (this.J0.m1().G(i4) instanceof pea) && (peaVar = (pea) this.J0.m1().G(i4)) != null) {
                            pea peaVar2 = (pea) ListUtils.getItem(this.C0.s1().F(), peaVar.L() - 1);
                            if (peaVar.o() == null && peaVar2 != null) {
                                peaVar.O0(peaVar2.o());
                            }
                            if (peaVar.o() != null) {
                                peaVar.o().setFloonumber(peaVar.L());
                                arrayList.add(peaVar.o());
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
                            this.J0.b3(adverSegmentData, 0);
                            return;
                        }
                        return;
                    }
                    this.J0.b3(adverSegmentData, 1);
                }
            }
        }
    }

    public final AbsPbActivity.e M7(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
            String str2 = null;
            if (this.C0.s1() != null && this.C0.s1().F() != null && this.C0.s1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i4 = 0;
                while (true) {
                    if (i4 < this.C0.s1().F().size()) {
                        if (str.equals(this.C0.s1().F().get(i4).U())) {
                            break;
                        }
                        i4++;
                    } else {
                        i4 = 0;
                        break;
                    }
                }
                pea peaVar = this.C0.s1().F().get(i4);
                if (peaVar.f0() != null && peaVar.f0().P() != null) {
                    Iterator<TbRichTextData> it = peaVar.f0().P().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.V() != null) {
                                str2 = next.V().P();
                            }
                        }
                    }
                    sj9.e(this.C0, str2, 0, eVar);
                    ze9.b(peaVar, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void O8(int i4) {
        PbModel pbModel;
        ThreadData O;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048639, this, i4) != null) || (pbModel = this.C0) == null || pbModel.s1() == null || (O = this.C0.s1().O()) == null) {
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
        if (this.C0.L1()) {
            this.J0.T0().f0();
        } else {
            this.J0.b5(this.C0.s1());
        }
    }

    public void R7(pf9 pf9Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048652, this, pf9Var) != null) || pf9Var.g() == null) {
            return;
        }
        String U = pf9Var.g().U();
        ArrayList<pea> F = this.C0.s1().F();
        int i4 = 0;
        while (true) {
            z3 = true;
            if (i4 >= F.size()) {
                break;
            }
            pea peaVar = F.get(i4);
            if (peaVar.U() != null && peaVar.U().equals(U)) {
                ArrayList<pea> i5 = pf9Var.i();
                peaVar.q1(pf9Var.k());
                if (peaVar.j0() != null && i5 != null) {
                    Iterator<pea> it = i5.iterator();
                    while (it.hasNext()) {
                        pea next = it.next();
                        if (peaVar.s0() != null && next != null && next.t() != null && (metaData = peaVar.s0().get(next.t().getUserId())) != null) {
                            next.P0(metaData);
                            next.g1(true);
                            next.A1(getPageContext(), this.C0.m2(metaData.getUserId()));
                        }
                    }
                    if (i5.size() == peaVar.j0().size()) {
                        z3 = false;
                    }
                    if (!peaVar.z0(false)) {
                        peaVar.j0().clear();
                        peaVar.j0().addAll(i5);
                    }
                }
                if (peaVar.E() != null) {
                    peaVar.N0();
                }
            } else {
                i4++;
            }
        }
        if (!this.C0.b1() && z3) {
            this.J0.g2(this.C0.s1());
        }
        if (z3) {
            P7(pf9Var);
        }
    }

    public final void U7(View view2) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, view2) == null) {
            this.J0.F0();
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.i) {
                view2.setTag(Integer.valueOf(this.C0.J1()));
            } else {
                C8();
                this.J0.S3();
                pz4 pz4Var = new pz4(getPageContext());
                if (this.C0.s1().f == null || this.C0.s1().f.size() <= 0) {
                    strArr = new String[]{getResources().getString(R.string.sort_type_new), getResources().getString(R.string.sort_type_old)};
                } else {
                    strArr = new String[this.C0.s1().f.size()];
                    for (int i4 = 0; i4 < this.C0.s1().f.size(); i4++) {
                        strArr[i4] = this.C0.s1().f.get(i4).sort_name + getResources().getString(R.string.sort_static);
                    }
                }
                pz4Var.i(null, strArr, new s1(this, pz4Var, view2));
                pz4Var.l();
            }
        }
    }

    public final boolean Y7(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048679, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof pea)) {
                return false;
            }
            pea peaVar = (pea) obj;
            if (peaVar.getType() != pea.a1 && !TextUtils.isEmpty(peaVar.v()) && uu4.c().g()) {
                return w7(peaVar);
            }
            if (!checkUpIsLogin()) {
                xn9.N(2, 2);
                return true;
            }
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.s1() != null) {
                if (E6().x1() != null) {
                    E6().x1().g();
                }
                pf9 pf9Var = new pf9();
                pf9Var.v(this.C0.s1().k());
                pf9Var.z(this.C0.s1().O());
                pf9Var.x(peaVar);
                E6().w1().j0(pf9Var);
                E6().w1().setPostId(peaVar.U());
                l7(view2, peaVar.t().getUserId(), "", peaVar);
                TiebaStatic.log("c11743");
                hf5 hf5Var = this.Y0;
                if (hf5Var != null) {
                    this.J0.x3(hf5Var.A());
                }
                return true;
            }
            xn9.N(20, 2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void f6(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.J0.F0();
            if (view2.getId() == R.id.obfuscated_res_0x7f091ae4 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                this.V = view2;
            } else if (!ck9.d(getPageContext(), 11009) || this.C0.I0(this.J0.l1()) == null) {
            } else {
                q7();
                if (this.C0.s1() != null && this.C0.s1().O() != null && this.C0.s1().O().getAuthor() != null) {
                    xn9.x(3, this.C0);
                }
                if (this.C0.s1().O() != null && this.C0.s1().O().getAuthor() != null && this.C0.s1().O().getAuthor().getUserId() != null && this.E0 != null) {
                    xn9.E(1, ck9.v(this.C0.s1()), !this.E0.e(), this.C0);
                }
            }
        }
    }

    public final void o7(View view2) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.C0.s1() == null || this.F0.g0()) {
            } else {
                this.J0.F0();
                if (this.J0.k.i() != null && view2 == this.J0.k.i().D()) {
                    if (this.C0.s1().O().getIs_top() == 1) {
                        i4 = 5;
                    } else {
                        i4 = 4;
                    }
                } else if (this.J0.k.i() != null && view2 == this.J0.k.i().C()) {
                    if (this.C0.s1().O().getIs_good() == 1) {
                        i4 = 3;
                    } else {
                        i4 = 6;
                    }
                } else if (view2 == this.J0.X0()) {
                    i4 = 2;
                } else {
                    i4 = 0;
                }
                ForumData k3 = this.C0.s1().k();
                String name = k3.getName();
                String id = k3.getId();
                String id2 = this.C0.s1().O().getId();
                this.J0.N4();
                this.F0.k0(id, name, id2, i4, this.J0.Y0());
            }
        }
    }

    public final boolean w7(pea peaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048792, this, peaVar)) == null) {
            if (peaVar == null) {
                return false;
            }
            String U = peaVar.U();
            if (StringUtils.isNull(U) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String string = SharedPrefHelper.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = peaVar.o0().getJumpUrl();
            int packageId = peaVar.o0().getPackageId();
            int propsId = peaVar.o0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                BrowserHelper.startWebActivity(getPageContext().getPageActivity(), vfa.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
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

    public final void O6() {
        TiebaPlusConfigData tiebaPlusConfigData;
        String jumpUrlWithTid;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && (tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData()) != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.C0.M1())) != null) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{jumpUrlWithTid});
            this.J0.k.f();
            TiebaPlusConfigData.addClickStatsForFireLink(3);
        }
    }

    public final boolean P5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            PbModel pbModel = this.C0;
            if (pbModel != null && pbModel.s1() != null && this.C0.s1().g() != null && !TextUtils.isEmpty(this.C0.s1().g().l)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void P6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048643, this) == null) && this.b != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.b.getCurrentFocus() != null) {
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), this.b.getCurrentFocus());
        }
    }

    public final void Z7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048682, this) == null) && (pbModel = this.C0) != null && pbModel.s1() != null && this.C0.s1().O() != null && this.C0.s1().O().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final boolean a7() {
        InterceptResult invokeV;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            if (bd9.c() && (pbModel = this.C0) != null && pbModel.s1() != null && this.C0.s1().i() != null && this.C0.s1().i().y() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void a8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048686, this) == null) && (pbModel = this.C0) != null && pbModel.s1() != null && this.C0.s1().O() != null && this.C0.s1().O().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public final int o6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) {
            if (this.C0.s1() != null && this.C0.s1().O() != null) {
                return this.C0.s1().O().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final boolean o8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
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

    public final void s8() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048777, this) == null) && zm9.b() && !this.J0.a3()) {
            sa5 showPushOpenView = PushOpenUtil.showPushOpenView(getPageContext(), "reply_pb", 0L);
            this.r0 = showPushOpenView;
            if (showPushOpenView != null) {
                by9.e().h("reply_pb");
            }
        }
    }

    public final void t8() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048780, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && zm9.a() && !this.J0.a3()) {
            sa5 showPushOpenView = PushOpenUtil.showPushOpenView(getPageContext(), "collect", 0L);
            this.r0 = showPushOpenView;
            if (showPushOpenView != null) {
                by9.e().h("collect");
            }
        }
    }

    public void y7() {
        List<g3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048798, this) == null) && (list = this.t1) != null && !list.isEmpty()) {
            int size = this.t1.size();
            while (true) {
                size--;
                if (size <= -1 || this.t1.get(size).onBackPressed()) {
                    return;
                }
            }
        }
    }

    public final void z7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048801, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.J0.F0();
            if (this.i) {
                return;
            }
            C8();
            this.J0.S3();
            if (this.C0.loadData()) {
                this.J0.C4();
            }
        }
    }

    public final void z8() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048802, this) == null) && (pbModel = this.C0) != null && !ad.isEmpty(pbModel.M1())) {
            un4.w().Q(tn4.Z, JavaTypesHelper.toLong(this.C0.M1(), 0L));
        }
    }

    public void Q7(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048648, this, z3, markData) == null) {
            this.J0.R3();
            this.C0.i3(z3);
            oq4 oq4Var = this.E0;
            if (oq4Var != null) {
                oq4Var.h(z3);
                if (markData != null) {
                    this.E0.i(markData);
                }
            }
            if (this.C0.d1()) {
                n7();
            } else {
                this.J0.g2(this.C0.s1());
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void R0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048649, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (ow5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ow5.class);
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (jk9.c(objArr[i4].g()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    @Override // com.baidu.tieba.rw5
    public void n0(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048736, this, context, str, z3) == null) {
            if (jk9.c(str) && (pbModel = this.C0) != null && pbModel.M1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.C0.M1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    gc5 gc5Var = new gc5();
                    gc5Var.a = str;
                    gc5Var.b = 3;
                    gc5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, gc5Var));
                }
            } else {
                jk9.a().e(getPageContext(), str);
            }
            this.v = true;
        }
    }

    @Override // com.baidu.tieba.rw5
    public void U(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048660, this, context, str) == null) {
            if (!StringUtils.isNull(str) && !TextUtils.isDigitsOnly(str) && eh9.a(str)) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("TargetSchemeInterceptHelper", "jump targetScheme: " + str);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            }
            this.v = true;
        }
    }

    public void a6(hz4 hz4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048684, this, hz4Var, jSONArray) == null) {
            hz4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(hz4Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                Z5((SparseArray) hz4Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final boolean V5(View view2) {
        InterceptResult invokeL;
        SparseArray<Object> sparseArray;
        oq4 oq4Var;
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
        nz4 nz4Var;
        nz4 nz4Var2;
        nz4 nz4Var3;
        nz4 nz4Var4;
        nz4 nz4Var5;
        nz4 nz4Var6;
        BdImage bdImage;
        SparseArray<Object> sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048666, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext())) {
                return true;
            }
            dk9 dk9Var = this.J0;
            if (dk9Var != null) {
                if (dk9Var.k2()) {
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
                if (ck9.y(view2)) {
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
                        this.J0.x4(this.F2, this.m1.isGif());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            SparseArray<Object> sparseArray3 = sparseArray;
            pea peaVar = (pea) sparseArray3.get(R.id.tag_clip_board);
            this.D2 = peaVar;
            if (peaVar == null) {
                return true;
            }
            if (peaVar.L() == 1 && ck9.y(view2)) {
                this.J0.x4(this.F2, this.m1.isGif());
                return true;
            } else if (this.D2.B0() || (oq4Var = this.E0) == null) {
                return true;
            } else {
                if (oq4Var.e() && this.D2.U() != null && this.D2.U().equals(this.C0.n1())) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (e0().s1() != null && e0().s1().j0()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (e0().s1() != null && e0().s1().p0()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (e0().s1() != null && e0().s1().o0()) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (this.D2.L() == 1) {
                    if (!z4) {
                        this.J0.y4(this.E2, z3, false, z5, z6);
                    }
                    return true;
                }
                if (this.P0 == null) {
                    rz4 rz4Var = new rz4(getContext());
                    this.P0 = rz4Var;
                    rz4Var.r(this.k2);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 != null && sparseArray3 != null) {
                    if (ck9.y(view2) && !z4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (ck9.y(view2) && (bdImage = this.m1) != null && !bdImage.isGif()) {
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
                        arrayList.add(new nz4(1, getString(R.string.save_to_emotion), this.P0));
                    }
                    if (z8) {
                        arrayList.add(new nz4(2, getString(R.string.save_to_local), this.P0));
                    }
                    if (!z7 && !z8) {
                        nz4 nz4Var7 = new nz4(3, getString(R.string.obfuscated_res_0x7f0f04eb), this.P0);
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_clip_board, this.D2);
                        nz4Var7.d.setTag(sparseArray4);
                        arrayList.add(nz4Var7);
                    }
                    if (!z9 && !z4) {
                        if (z3) {
                            nz4Var6 = new nz4(4, getString(R.string.remove_mark), this.P0);
                        } else {
                            nz4Var6 = new nz4(4, getString(R.string.obfuscated_res_0x7f0f0c69), this.P0);
                        }
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.tag_clip_board, this.D2);
                        sparseArray5.put(R.id.tag_is_subpb, Boolean.FALSE);
                        nz4Var6.d.setTag(sparseArray5);
                        arrayList.add(nz4Var6);
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
                            if (!fm9.j(this.C0) && z13) {
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
                                    nz4Var5 = new nz4(6, getString(R.string.obfuscated_res_0x7f0f0551), this.P0);
                                    nz4Var5.d.setTag(sparseArray6);
                                    nz4 nz4Var8 = new nz4(7, getString(R.string.obfuscated_res_0x7f0f0326), this.P0);
                                    nz4Var8.d.setTag(sparseArray6);
                                    nz4Var3 = nz4Var5;
                                    nz4Var2 = nz4Var8;
                                    nz4Var = null;
                                }
                            } else {
                                sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                            }
                            nz4Var5 = null;
                            nz4 nz4Var82 = new nz4(7, getString(R.string.obfuscated_res_0x7f0f0326), this.P0);
                            nz4Var82.d.setTag(sparseArray6);
                            nz4Var3 = nz4Var5;
                            nz4Var2 = nz4Var82;
                            nz4Var = null;
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
                            if (this.C0.s1().W() == 1002 && !z10) {
                                nz4Var4 = new nz4(6, getString(R.string.report_text), this.P0);
                            } else {
                                nz4Var4 = new nz4(6, getString(R.string.obfuscated_res_0x7f0f0551), this.P0);
                            }
                            nz4Var4.d.setTag(sparseArray7);
                            if (z16) {
                                nz4Var = new nz4(13, getString(R.string.multi_delete), this.P0);
                                nz4Var3 = nz4Var4;
                            } else {
                                nz4Var3 = nz4Var4;
                                nz4Var = null;
                            }
                            nz4Var2 = null;
                        } else {
                            nz4Var = null;
                            nz4Var2 = null;
                            nz4Var3 = null;
                        }
                        if (nz4Var3 != null) {
                            arrayList.add(nz4Var3);
                        }
                        if (nz4Var != null) {
                            arrayList.add(nz4Var);
                        }
                        if (nz4Var2 != null) {
                            arrayList.add(nz4Var2);
                        }
                        fm9.b(arrayList, this.P0, this.D2, this.C0);
                    }
                    List<nz4> d4 = fm9.d(arrayList, this.D2.p(), sparseArray3, this.P0, this.D2.r());
                    fm9.m(d4, this.c);
                    fm9.f(d4);
                    this.P0.s(fm9.h(this.D2));
                    this.P0.n(d4, true);
                    this.O0 = new pz4(getPageContext(), this.P0);
                    this.P0.q(new c3(this));
                    this.O0.l();
                    StatisticItem param = new StatisticItem("c13272").param("tid", this.C0.b).param("fid", this.C0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.C0.P());
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

    public void W5(ForumManageModel.b bVar, dk9 dk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048670, this, bVar, dk9Var) == null) {
            List<pea> list = this.C0.s1().T().a;
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
                dk9Var.g2(this.C0.s1());
            }
        }
    }

    public void b6(int i4, String str, int i5, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048689, this, new Object[]{Integer.valueOf(i4), str, Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i5));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(dk9.o2, Integer.valueOf(dk9.p2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                Z5(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void i6(View view2) {
        PbModel pbModel;
        int i4;
        ye9 ye9Var;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048717, this, view2) != null) || (pbModel = this.C0) == null) {
            return;
        }
        xn9.I(5, pbModel);
        if (view2.getId() == R.id.obfuscated_res_0x7f091b67 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
            this.f1142T = view2;
        } else if (!checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
        } else {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof pea)) {
                return;
            }
            pea peaVar = (pea) sparseArray.get(R.id.tag_load_sub_data);
            StatisticItem statisticItem = peaVar.g0;
            if (statisticItem != null) {
                StatisticItem copy = statisticItem.copy();
                copy.delete("obj_locate");
                copy.param("obj_locate", 8);
                TiebaStatic.log(copy);
            }
            PbModel pbModel2 = this.C0;
            if (pbModel2 != null && pbModel2.s1() != null) {
                String M1 = this.C0.M1();
                String U = peaVar.U();
                if (this.C0.s1() != null) {
                    i4 = this.C0.s1().W();
                } else {
                    i4 = 0;
                }
                AbsPbActivity.e M7 = M7(U);
                if (M7 == null) {
                    return;
                }
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(M1, U, "pb", true, false, null, false, null, i4, peaVar.m0(), this.C0.s1().c(), false, peaVar.t().getIconInfo(), 5).addBigImageData(M7.a, M7.b, M7.g, M7.j);
                addBigImageData.setKeyPageStartFrom(this.C0.r1());
                addBigImageData.setFromFrsForumId(this.C0.getFromForumId());
                addBigImageData.setWorksInfoData(this.C0.R1());
                addBigImageData.setKeyFromForumId(this.C0.getForumId());
                addBigImageData.setTiebaPlusData(this.C0.W(), this.C0.S(), this.C0.T(), this.C0.R(), this.C0.X());
                addBigImageData.setBjhData(this.C0.J0());
                if (this.C0.s1().n() != null) {
                    addBigImageData.setHasForumRule(this.C0.s1().n().has_forum_rule.intValue());
                }
                if (this.C0.s1().V() != null) {
                    addBigImageData.setIsManager(this.C0.s1().V().getIs_manager());
                }
                if (this.C0.s1().k().getDeletedReasonInfo() != null) {
                    addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.C0.s1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                    addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.C0.s1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                }
                if (this.C0.s1().k() != null) {
                    addBigImageData.setForumHeadUrl(this.C0.s1().k().getImage_url());
                    addBigImageData.setUserLevel(this.C0.s1().k().getUser_level());
                }
                if (this.J0 != null && (ye9Var = this.C0.G) != null) {
                    if (!ye9Var.X().f1148T && !peaVar.f1148T) {
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

    public final void j6(ForumManageModel.b bVar, boolean z3) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048721, this, bVar, z3) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i4 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                hz4 hz4Var = new hz4(getPageContext().getPageActivity());
                hz4Var.setMessage(string);
                hz4Var.setPositiveButton(R.string.dialog_known, new h2(this));
                hz4Var.setCancelable(true);
                hz4Var.create(getPageContext());
                hz4Var.show();
            } else if (bVar.d != 0) {
                this.J0.O0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i5 = bVar.d;
                if (i5 == 1) {
                    ArrayList<pea> F = this.C0.s1().F();
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
                    this.C0.s1().O().setReply_num(this.C0.s1().O().getReply_num() - 1);
                    this.J0.g2(this.C0.s1());
                } else if (i5 == 0) {
                    T5();
                } else if (i5 == 2) {
                    ArrayList<pea> F2 = this.C0.s1().F();
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
                        this.J0.g2(this.C0.s1());
                    }
                    W5(bVar, this.J0);
                }
            }
        }
    }

    public final void u8(String str, String str2) {
        int i4;
        int dimens;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048785, this, str, str2) == null) {
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
            dk9 dk9Var = this.J0;
            if (dk9Var != null && dk9Var.m1() != null) {
                this.J0.m1().smoothScrollBy(i6, 50);
            }
            if (E6().x1() != null) {
                hf5 hf5Var = this.Y0;
                if (hf5Var != null) {
                    hf5Var.a().setVisibility(8);
                }
                PbModel pbModel2 = this.C0;
                E6().x1().t(str, str2, E6().y1(), (pbModel2 == null || pbModel2.s1() == null || this.C0.s1().O() == null || !this.C0.s1().O().isBjh()) ? false : false);
                kf5 f4 = E6().x1().f();
                if (f4 != null && (pbModel = this.C0) != null && pbModel.s1() != null) {
                    f4.K(this.C0.s1().c());
                    f4.g0(this.C0.s1().O());
                }
                if (this.N0.f() == null && E6().x1().f().v() != null) {
                    E6().x1().f().v().h(new n(this));
                    this.N0.n(E6().x1().f().v().j());
                    E6().x1().f().Q(this.e1);
                }
            }
            E6().J1();
        }
    }

    public final void k6(int i4, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048725, this, i4, gVar) != null) || gVar == null) {
            return;
        }
        this.J0.O0(this.F0.getLoadDataMode(), gVar.a, gVar.b, false);
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
                this.C0.s1().O().setIs_good(1);
                this.C0.V2(1);
            } else if (i4 == 3) {
                this.C0.s1().O().setIs_good(0);
                this.C0.V2(0);
            } else if (i4 == 4) {
                this.C0.s1().O().setIs_top(1);
                this.C0.W2(1);
            } else if (i4 == 5) {
                this.C0.s1().O().setIs_top(0);
                this.C0.W2(0);
            }
            this.J0.Y4(this.C0.s1(), this.C0.L1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.operation_failed);
        }
        BdUtilHelper.showToast(getPageContext().getPageActivity(), string);
    }

    public final void k8(int i4, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048727, this, i4, antiData, str) == null) {
            if (AntiHelper.m(i4, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i4, new f2(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i4 == 230277) {
                x8(str);
            } else {
                this.J0.L4(str);
            }
        }
    }

    @Override // com.baidu.tieba.rw5
    public void s0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048774, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.Q0 = str;
            if (this.l == null) {
                V6();
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

    public final void l7(View view2, String str, String str2, pea peaVar) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048730, this, view2, str, str2, peaVar) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (N5()) {
                    xn9.N(3, 2);
                    return;
                } else if (!Q5()) {
                    xn9.N(8, 2);
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.Z);
                        this.a0 = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (E6().x1() != null && peaVar != null) {
                        if (peaVar.f0() != null) {
                            str3 = peaVar.f0().toString();
                        } else {
                            str3 = "";
                        }
                        E6().x1().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), peaVar.t().getName_show(), str3));
                    }
                    if (this.C0.s1() != null && this.C0.s1().j0()) {
                        SafeHandler.getInst().postDelayed(new q1(this, str, str2), 0L);
                        return;
                    } else {
                        SafeHandler.getInst().postDelayed(new r1(this, str, str2), 200L);
                        return;
                    }
                }
            }
            xn9.N(20, 2);
        }
    }

    public final void m8(SparseArray<Object> sparseArray, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048735, this, new Object[]{sparseArray, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            fm9.e(getActivity(), getPageContext(), new m1(this, sparseArray, i4, z3), new n1(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048744, this, i4, i5, intent) == null) {
            super.onActivityResult(i4, i5, intent);
            hf5 hf5Var = this.Y0;
            if (hf5Var != null) {
                hf5Var.E(i4, i5, intent);
            }
            if (E6().x1() != null) {
                E6().x1().k(i4, i5, intent);
            }
            if (i4 == 25035) {
                K6(i5, intent);
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
                                                    View view2 = this.f1142T;
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
                                                    dk9 dk9Var = this.J0;
                                                    if (dk9Var != null && dk9Var.W0() != null) {
                                                        this.J0.W0().performClick();
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
                                        this.J0.U3(false);
                                        if (this.C0.s1() != null && this.C0.s1().O() != null && this.C0.s1().O().getPushStatusData() != null) {
                                            this.C0.s1().O().getPushStatusData().setStatus(2);
                                            return;
                                        }
                                        return;
                                    }
                                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                        RateManager.getInstance().notifyShare(getPageContext());
                                        M8();
                                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.I0;
                                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.linkUrl) != null) {
                                            shareSuccessReplyToServerModel.N(str, intExtra, new n2(this));
                                        }
                                        if (X6()) {
                                            K8(true);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                View view5 = this.S;
                                if (view5 != null) {
                                    this.J0.p4(view5);
                                    return;
                                }
                                return;
                            }
                            N6(intent);
                            return;
                        }
                        RateManager.getInstance().notifyShare(getPageContext());
                        return;
                    }
                    uj9.b().k();
                    this.z0.postDelayed(new m2(this), 1000L);
                    return;
                }
                q7();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048750, this, layoutInflater, viewGroup, bundle)) == null) {
            oma.b(this, new Pair[0]);
            this.J0 = new dk9(this, this.m2, this.X1, this.l2);
            vt6 vt6Var = new vt6(getActivity());
            this.e = vt6Var;
            vt6Var.i(U2);
            this.e.d(this.M2);
            this.J0.L3(this.w2);
            this.J0.K3(this.B2);
            this.J0.E3(this.y2);
            this.J0.F3(this.z2);
            this.J0.C3(uu4.c().g());
            this.J0.I3(this.C2);
            this.J0.O3(this.H2);
            this.J0.M3(this.I2);
            this.J0.J3(this.K2);
            this.J0.T4(this.mIsLogin);
            this.J0.A3(this.C0.a2());
            if (this.b.getIntent() != null) {
                this.J0.B3(this.b.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.J0.w1().setFromForumId(this.C0.getFromForumId());
            hf5 hf5Var = this.Y0;
            if (hf5Var != null) {
                this.J0.s3(hf5Var.a());
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.Y0.e0(TbSingleton.getInstance().getAdVertiComment());
                } else {
                    this.Y0.e0(this.J0.y1());
                }
            }
            this.J0.w3(this.j2);
            this.J0.z3(this.C0.a1());
            this.J0.N3(this.C0.r1());
            this.v0.f(this.J0, this.C0);
            if ("1".equals(e0().showReplyPanel)) {
                this.J0.N2();
            }
            return this.J0.G1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        dk9 dk9Var;
        dk9 dk9Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, bundle) == null) {
            this.o = System.currentTimeMillis();
            this.h1 = getPageContext();
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
                this.O2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.P2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.Q2 = intent.getStringExtra("key_manga_title");
                this.T0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.U0 = intent.getStringExtra("high_light_post_id");
                this.V0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (u6()) {
                    this.b.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.Q = stringExtra;
                if (ad.isEmpty(stringExtra)) {
                    str = "";
                } else {
                    str = this.Q;
                }
                this.Q = str;
                this.s1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                xx4 xx4Var = new xx4();
                this.d0 = xx4Var;
                xx4Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.u1 = intExtra;
                if (intExtra == 0) {
                    this.u1 = intent.getIntExtra("key_start_from", 0);
                }
                this.S2 = intent.getIntExtra(PbActivityConfig.KEY_FROM_CARD_TYPE, 0);
            } else {
                this.m = System.currentTimeMillis();
            }
            this.q = this.o - this.m;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.k = 0;
            j7(bundle);
            if (this.C0.s1() != null) {
                this.C0.s1().V0(this.Q);
            }
            T6();
            if (intent != null && (dk9Var2 = this.J0) != null) {
                dk9Var2.e = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.k1 == null) {
                        this.k1 = new q0(this, intent);
                    }
                    SafeHandler.getInst().postDelayed(this.k1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.C0.s1() != null) {
                    this.C0.a3(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.j = voiceManager;
            voiceManager.onCreate(getPageContext());
            S6(bundle);
            if5 if5Var = new if5();
            this.X0 = if5Var;
            g8(if5Var);
            hf5 hf5Var = (hf5) this.X0.a(getActivity());
            this.Y0 = hf5Var;
            hf5Var.Y(this.b.getPageContext());
            this.Y0.h0(this.o2);
            this.Y0.i0(this.c1);
            this.Y0.a0(1);
            this.Y0.C(this.b.getPageContext(), bundle);
            this.Y0.a().b(new nd5(getActivity()));
            this.Y0.a().F(true);
            j8(true);
            this.Y0.L(this.C0.U0(), this.C0.M1(), this.C0.Q0());
            registerListener(this.B1);
            if (!this.C0.f1()) {
                this.Y0.r(this.C0.M1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.Y0.e0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.C0.c2()) {
                this.Y0.e0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                dk9 dk9Var3 = this.J0;
                if (dk9Var3 != null) {
                    this.Y0.e0(dk9Var3.y1());
                }
            }
            ig9 ig9Var = new ig9(this.b.getUniqueId(), new r0(this), new s0(this));
            this.f2 = ig9Var;
            registerListener(ig9Var.d());
            this.H = new PbGodGuideController();
            getLifecycle().addObserver(this.H);
            pt4.a().c(this.A0);
            pt4.a().c(this.B0);
            registerListener(this.A1);
            registerListener(this.C1);
            registerListener(this.D1);
            registerListener(this.z1);
            registerListener(this.d2);
            registerListener(this.e2);
            registerListener(this.u2);
            registerListener(this.y1);
            fea feaVar = new fea("pb", fea.d);
            this.W0 = feaVar;
            feaVar.d();
            registerListener(this.J1);
            registerListener(this.T1);
            this.C0.w2();
            registerListener(this.t2);
            registerListener(this.h2);
            registerListener(this.n2);
            registerListener(this.P1);
            registerListener(this.g2);
            registerListener(this.K1);
            dk9 dk9Var4 = this.J0;
            if (dk9Var4 != null && dk9Var4.F1() != null && this.J0.C1() != null) {
                ol9 ol9Var = new ol9(getActivity(), this.J0.F1(), this.J0.C1(), this.J0.v1());
                this.f = ol9Var;
                ol9Var.t(this.S1);
            }
            if (this.d && (dk9Var = this.J0) != null && dk9Var.C1() != null) {
                this.J0.C1().setVisibility(8);
            }
            h45 h45Var = new h45();
            this.i1 = h45Var;
            h45Var.a = 1000L;
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
            this.L1.setTag(this.b.getUniqueId());
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
            this.W1 = new h3(this.J0, this);
            this.C0.M0().R(this.W1);
            this.N0 = new gk9();
            if (this.Y0.t() != null) {
                this.N0.m(this.Y0.t().j());
            }
            this.Y0.X(this.d1);
            this.I0 = new ShareSuccessReplyToServerModel();
            C5(this.w1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.a1 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new u0(this));
            dn9 dn9Var = new dn9(getContext());
            this.D0 = dn9Var;
            dn9Var.b(getUniqueId());
            rca.g().i(getUniqueId());
            ev4.b().l("3", "");
            this.v1 = new aj6(getPageContext());
            this.v0 = new cm9(this, getUniqueId(), this.J0, this.C0);
            this.w0 = new PushPermissionController(getActivity(), getPageContext());
            if (!TbSingleton.getInstance().hasDownloadEmotion() && BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.p = System.currentTimeMillis() - this.o;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        xm9 xm9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048751, this) == null) {
            rca.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!ad.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.C0.s1().l());
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
            hf5 hf5Var = this.Y0;
            if (hf5Var != null) {
                hf5Var.F();
                this.Y0 = null;
            }
            ForumManageModel forumManageModel = this.F0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.R;
            if (likeModel != null) {
                likeModel.b0();
            }
            dk9 dk9Var = this.J0;
            if (dk9Var != null) {
                dk9Var.G2();
                xm9 xm9Var2 = this.J0.k;
                if (xm9Var2 != null) {
                    xm9Var2.r();
                }
            }
            gn5 gn5Var = this.t;
            if (gn5Var != null) {
                gn5Var.c();
            }
            ol9 ol9Var = this.f;
            if (ol9Var != null) {
                ol9Var.k();
            }
            ya<TextView> yaVar = this.z;
            if (yaVar != null) {
                yaVar.c();
            }
            ya<FestivalTipView> yaVar2 = this.I;
            if (yaVar2 != null) {
                yaVar2.c();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.j;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            dk9 dk9Var2 = this.J0;
            if (dk9Var2 != null) {
                dk9Var2.F0();
            }
            if (this.Y1 != null) {
                SafeHandler.getInst().removeCallbacks(this.Y1);
            }
            if (this.f2 != null) {
                MessageManager.getInstance().unRegisterListener(this.f2.d());
            }
            pt4.a().e(this.A0);
            pt4.a().e(this.B0);
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
            dk9 dk9Var3 = this.J0;
            if (dk9Var3 != null && (xm9Var = dk9Var3.k) != null) {
                xm9Var.k();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.I0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            gk9 gk9Var = this.N0;
            if (gk9Var != null) {
                gk9Var.j();
            }
            PushPermissionController pushPermissionController = this.w0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.C0;
            if (pbModel2 != null && pbModel2.F0() != null) {
                this.C0.F0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.a1;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            dk9 dk9Var4 = this.J0;
            if (dk9Var4 != null) {
                dk9Var4.Q4();
            }
            cm9 cm9Var = this.v0;
            if (cm9Var != null) {
                cm9Var.e();
            }
        }
    }

    public final void y8(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048799, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.J0.s4();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            hz4 hz4Var = new hz4(this.h1.getPageActivity());
            if (!ad.isEmpty(str)) {
                hz4Var.setMessage(str);
            } else {
                hz4Var.setMessage(this.h1.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            hz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c8, new l(this, userMuteAddAndDelCustomMessage));
            hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new m(this));
            hz4Var.create(this.h1).show();
        }
    }
}
