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
import com.baidu.tieba.ac9;
import com.baidu.tieba.ag;
import com.baidu.tieba.ai9;
import com.baidu.tieba.aiapps.TbAiappsLaunchUtil;
import com.baidu.tieba.aka;
import com.baidu.tieba.ar5;
import com.baidu.tieba.b05;
import com.baidu.tieba.bg;
import com.baidu.tieba.bh5;
import com.baidu.tieba.bi;
import com.baidu.tieba.bi9;
import com.baidu.tieba.bm6;
import com.baidu.tieba.bw4;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cf9;
import com.baidu.tieba.cj9;
import com.baidu.tieba.ck9;
import com.baidu.tieba.cn;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d25;
import com.baidu.tieba.dk5;
import com.baidu.tieba.dk9;
import com.baidu.tieba.dka;
import com.baidu.tieba.dm9;
import com.baidu.tieba.dt4;
import com.baidu.tieba.e35;
import com.baidu.tieba.e95;
import com.baidu.tieba.eh5;
import com.baidu.tieba.ei9;
import com.baidu.tieba.ek9;
import com.baidu.tieba.et4;
import com.baidu.tieba.fe5;
import com.baidu.tieba.fg9;
import com.baidu.tieba.fj9;
import com.baidu.tieba.fk9;
import com.baidu.tieba.fr5;
import com.baidu.tieba.gi9;
import com.baidu.tieba.h55;
import com.baidu.tieba.h9;
import com.baidu.tieba.hba;
import com.baidu.tieba.hi9;
import com.baidu.tieba.hj9;
import com.baidu.tieba.i95;
import com.baidu.tieba.ie9;
import com.baidu.tieba.ij9;
import com.baidu.tieba.jd5;
import com.baidu.tieba.je9;
import com.baidu.tieba.jh9;
import com.baidu.tieba.jv5;
import com.baidu.tieba.kf5;
import com.baidu.tieba.kg9;
import com.baidu.tieba.l05;
import com.baidu.tieba.le9;
import com.baidu.tieba.lh5;
import com.baidu.tieba.lh9;
import com.baidu.tieba.m15;
import com.baidu.tieba.m45;
import com.baidu.tieba.mj5;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mw6;
import com.baidu.tieba.n45;
import com.baidu.tieba.nf5;
import com.baidu.tieba.nj5;
import com.baidu.tieba.nr5;
import com.baidu.tieba.nw6;
import com.baidu.tieba.o06;
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
import com.baidu.tieba.pba;
import com.baidu.tieba.pj5;
import com.baidu.tieba.pr5;
import com.baidu.tieba.qba;
import com.baidu.tieba.qg9;
import com.baidu.tieba.qj5;
import com.baidu.tieba.qk9;
import com.baidu.tieba.ql9;
import com.baidu.tieba.r06;
import com.baidu.tieba.r85;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.tieba.rj5;
import com.baidu.tieba.rl5;
import com.baidu.tieba.rr6;
import com.baidu.tieba.rw7;
import com.baidu.tieba.s45;
import com.baidu.tieba.sd9;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.sh9;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.sk9;
import com.baidu.tieba.t25;
import com.baidu.tieba.t9a;
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
import com.baidu.tieba.tj5;
import com.baidu.tieba.tr5;
import com.baidu.tieba.tv9;
import com.baidu.tieba.u45;
import com.baidu.tieba.ul9;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.v16;
import com.baidu.tieba.v25;
import com.baidu.tieba.v45;
import com.baidu.tieba.vb9;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.w05;
import com.baidu.tieba.w45;
import com.baidu.tieba.wba;
import com.baidu.tieba.wca;
import com.baidu.tieba.wg5;
import com.baidu.tieba.wh5;
import com.baidu.tieba.wj9;
import com.baidu.tieba.wk9;
import com.baidu.tieba.xh5;
import com.baidu.tieba.y3a;
import com.baidu.tieba.yb9;
import com.baidu.tieba.ye9;
import com.baidu.tieba.yh5;
import com.baidu.tieba.yj9;
import com.baidu.tieba.ym;
import com.baidu.tieba.ze9;
import com.baidu.tieba.zg9;
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
public class PbFragment extends BaseFragment implements r06, VoiceManager.i, UserIconBox.c, View.OnTouchListener, m45.e, TbRichTextView.t, TbPageContextSupport, ul9, dm9.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k S2;
    public static final nw6.b T2;
    public transient /* synthetic */ FieldHolder $fh;
    public ag<ImageView> A;
    public wk9 A0;
    public CustomMessageListener A1;
    public final TbRichTextView.z A2;
    public ag<View> B;
    public bw4 B0;
    public CustomMessageListener B1;
    public boolean B2;
    public ag<TiebaPlusRecommendCard> C;
    public ForumManageModel C0;
    public CustomMessageListener C1;
    public qba C2;
    public ag<LinearLayout> D;
    public fe5 D0;
    public final CustomMessageListener D1;
    public final n45.c D2;
    public ag<RelativeLayout> E;
    public le9 E0;
    public CustomMessageListener E1;
    public final n45.c E2;
    public ag<ItemCardView> F;
    public PollingModel F0;
    public CustomMessageListener F1;
    public final AdapterView.OnItemClickListener F2;
    @NonNull
    public PbGodGuideController G;
    public ShareSuccessReplyToServerModel G0;
    public View.OnClickListener G1;
    public final View.OnLongClickListener G2;
    public ag<FestivalTipView> H;
    public bi9 H0;
    public CustomMessageListener H1;
    public final View.OnClickListener H2;
    public boolean I;
    public boolean I0;
    public CustomMessageListener I1;
    public final ItemCardHelper.c I2;
    public boolean J;
    public boolean J0;
    public CustomMessageListener J1;
    public final NoNetworkView.b J2;
    public boolean K;
    public boolean K0;
    public CustomMessageListener K1;
    public View.OnTouchListener K2;
    public ag<GifView> L;
    public ei9 L0;
    public CustomMessageListener L1;
    public mw6.b L2;
    public String M;
    public u45 M0;
    public SuggestEmotionModel.c M1;
    public final qg9.b M2;
    public boolean N;
    public w45 N0;
    public CustomMessageListener N1;
    public int N2;
    public boolean O;
    public String O0;
    public GetSugMatchWordsModel.b O1;
    public int O2;
    public String P;
    public boolean P0;
    public PraiseModel P1;
    public String P2;
    public LikeModel Q;
    public boolean Q0;
    public ij9.h Q1;
    public m15 Q2;
    public View R;
    public boolean R0;
    public CustomMessageListener R1;
    public int R2;
    public View S;
    public String S0;
    public ResponsedEventListener S1;

    /* renamed from: T  reason: collision with root package name */
    public View f1141T;
    public boolean T0;
    public ResponsedEventListener T1;
    public View U;
    public hba U0;
    public CheckRealNameModel.b U1;
    public String V;
    public rj5 V0;
    public ze9 V1;
    public int W;
    public qj5 W0;
    public final Runnable W1;
    public boolean X;
    public PermissionJudgePolicy X0;
    public CustomMessageListener X1;
    public int[] Y;
    public ReplyPrivacyCheckController Y0;
    public CustomMessageListener Y1;
    public int Z;
    public ek9 Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public int a0;
    public nj5 a1;
    public CustomMessageListener a2;
    public boolean b;
    public int b0;
    public mj5 b1;
    public CustomMessageListener b2;
    public boolean c;
    public e35 c0;
    public mj5 c1;
    public CustomMessageListener c2;
    public nw6 d;
    public BdUniqueId d0;
    public int d1;
    public CustomMessageListener d2;
    public ij9 e;
    public r85 e0;
    public Object e1;
    public CustomMessageListener e2;
    public boolean f;
    public boolean f0;
    public BdPageContext f1;
    public m45.e f2;
    public boolean g;
    public boolean g0;
    public e95 g1;
    public e3 g2;
    public boolean h;
    public Object h0;
    public BdUniqueId h1;
    public w45.f h2;
    public VoiceManager i;
    public AgreeMessageData i0;
    public Runnable i1;
    public final SortSwitchButton.f i2;
    public int j;
    public kf5 j0;
    public gi9 j1;
    public final View.OnClickListener j2;
    public n45 k;
    public BdImage k1;
    public CustomMessageListener k2;
    public long l;
    public String l1;
    public final NewWriteModel.d l2;
    public long m;
    public TbRichTextImageInfo m1;
    public Boolean m2;
    public long n;
    public TbRichTextMemeInfo n1;
    public NewWriteModel.d n2;
    public long o;
    public boolean o1;
    public NetMessageListener o2;
    public long p;
    public int p1;
    public final PbModel.h p2;
    public boolean q;
    public int q1;
    public CustomMessageListener q2;
    public boolean r;
    public boolean r0;
    public List<c3> r1;
    public HttpMessageListener r2;
    public nr5 s;
    public boolean s0;
    public int s1;
    public final bw4.a s2;
    public long t;
    @NonNull
    public TiePlusEventController.g t0;
    public bm6 t1;
    public final AbsListView.OnScrollListener t2;
    public boolean u;
    public wj9 u0;
    public final c3 u1;
    public final h9 u2;
    public long v;
    public PushPermissionController v0;
    public final jh9.b v1;
    public final i95.g v2;
    public int w;
    public boolean w0;
    public final CustomMessageListener w1;
    public final View.OnClickListener w2;
    public String x;
    public PbInterviewStatusView.f x0;
    public CustomMessageListener x1;
    public boolean x2;
    public ag<TextView> y;
    public final Handler y0;
    public CustomMessageListener y1;
    public final BdListView.p y2;
    public ag<TbImageView> z;
    public PbModel z0;
    public CustomMessageListener z1;
    public int z2;

    /* loaded from: classes7.dex */
    public interface c3 {
        boolean onBackPressed();
    }

    /* loaded from: classes7.dex */
    public interface e3 {
        void callback(Object obj);
    }

    @Override // com.baidu.tieba.ul9
    public PbFragment A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul9
    public AbsVideoPbFragment O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return null;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r06
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

    @Override // com.baidu.tieba.r06
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
    public class d2 implements ShareSuccessReplyToServerModel.b {
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
            public final /* synthetic */ d2 b;

            public a(d2 d2Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {d2Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = d2Var;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    cf9.a(this.b.a.getPageContext(), this.a).show();
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

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                SafeHandler.getInst().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes7.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f1 a;

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

            public a(f1 f1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {f1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = f1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ei9 ei9Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ei9Var = this.a.c.L0) != null && ei9Var.g() != null) {
                    if (!this.a.c.L0.g().e()) {
                        this.a.c.L0.b(false);
                    }
                    this.a.c.L0.g().l(false);
                }
            }
        }

        public f1(PbFragment pbFragment, String str, String str2) {
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
                if (pbFragment.H0 != null && this.c.H0.m1() != null) {
                    this.c.H0.m1().smoothScrollBy(i3, 50);
                }
                if (this.c.M5().w1() != null) {
                    if (this.c.W0 != null) {
                        this.c.W0.b().setVisibility(8);
                    }
                    this.c.M5().w1().t(this.a, this.b, this.c.M5().x1(), (this.c.z0 == null || this.c.z0.r1() == null || this.c.z0.r1().O() == null || !this.c.z0.r1().O().isBjh()) ? false : false);
                    tj5 f = this.c.M5().w1().f();
                    if (f != null && this.c.z0 != null && this.c.z0.r1() != null) {
                        f.J(this.c.z0.r1().c());
                        f.f0(this.c.z0.r1().O());
                    }
                    if (this.c.L0.f() == null && this.c.M5().w1().f().u() != null) {
                        this.c.M5().w1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.L0.n(pbFragment2.M5().w1().f().u().i());
                        this.c.M5().w1().f().P(this.c.c1);
                    }
                }
                this.c.M5().G1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes7.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g1 a;

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

            public a(g1 g1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {g1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = g1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ei9 ei9Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ei9Var = this.a.c.L0) != null && ei9Var.g() != null) {
                    if (!this.a.c.L0.g().e()) {
                        this.a.c.L0.b(false);
                    }
                    this.a.c.L0.g().l(false);
                }
            }
        }

        public g1(PbFragment pbFragment, String str, String str2) {
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
                if (pbFragment.H0 != null && this.c.H0.m1() != null) {
                    this.c.H0.m1().smoothScrollBy(i3, 50);
                }
                if (this.c.M5().w1() != null) {
                    if (this.c.W0 != null) {
                        this.c.W0.b().setVisibility(8);
                    }
                    this.c.M5().w1().t(this.a, this.b, this.c.M5().x1(), (this.c.z0 == null || this.c.z0.r1() == null || this.c.z0.r1().O() == null || !this.c.z0.r1().O().isBjh()) ? false : false);
                    tj5 f = this.c.M5().w1().f();
                    if (f != null && this.c.z0 != null && this.c.z0.r1() != null) {
                        f.J(this.c.z0.r1().c());
                        f.f0(this.c.z0.r1().O());
                    }
                    if (this.c.L0.f() == null && this.c.M5().w1().f().u() != null) {
                        this.c.M5().w1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.L0.n(pbFragment2.M5().w1().f().u().i());
                        this.c.M5().w1().f().P(this.c.c1);
                    }
                }
                this.c.M5().G1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: Code restructure failed: missing block: B:762:0x1e09, code lost:
            r4 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:786:0x1ebd, code lost:
            if ((r32.a.H0.h1.a.getView().getTop() - r32.a.H0.k.a.getBottom()) < (r32.a.H0.h1.a.g.getHeight() + 10)) goto L762;
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
            sd9 r1;
            int i;
            int i2;
            qba X;
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
            if (this.a.s0 && (view2 == this.a.H0.k.e || view2 == this.a.H0.k.f || view2.getId() == R.id.obfuscated_res_0x7f091afa || view2.getId() == R.id.obfuscated_res_0x7f090b73 || view2.getId() == R.id.obfuscated_res_0x7f091ed8 || view2.getId() == R.id.obfuscated_res_0x7f091a91)) {
                return;
            }
            if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                if (view2 == this.a.H0.p1() && this.a.getPageContext().getPageActivity() != null && this.a.z0 != null) {
                    this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.z0.K1(), this.a.z0.c2(), this.a.z0.b2())));
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("fid", this.a.z0.getForumId());
                    statisticItem2.param("fname", this.a.z0.Q0());
                    statisticItem2.param("tid", this.a.z0.K1());
                    TiebaStatic.log(statisticItem2);
                }
                if (view2 == this.a.H0.r1()) {
                    if (!this.a.h && this.a.z0.n2(true)) {
                        this.a.h = true;
                        this.a.H0.N3();
                    }
                } else if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().G()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.showToast(R.string.network_not_available);
                        return;
                    }
                    this.a.H0.F0();
                    this.a.m7();
                    this.a.H0.M3();
                    this.a.H0.k4();
                    if (this.a.H0.u1() != null) {
                        this.a.H0.u1().setVisibility(8);
                    }
                    this.a.z0.d3(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                } else if (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().x()) {
                    if (view2 == this.a.H0.k.h) {
                        if (this.a.H0.u0(this.a.z0.e1())) {
                            this.a.m7();
                            return;
                        }
                        BdUtilHelper.hideSoftKeyPad(this.a.a, this.a.H0.k.h);
                        this.a.a.finish();
                    } else if (view2 == this.a.H0.X0() || (this.a.H0.k.i() != null && (view2 == this.a.H0.k.i().H() || view2 == this.a.H0.k.i().I()))) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                        } else if (this.a.z0.r1() != null && !this.a.C0.g0()) {
                            this.a.H0.F0();
                            int i7 = (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().I()) ? (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().H()) ? view2 == this.a.H0.X0() ? 2 : 0 : this.a.z0.r1().O().getIs_good() == 1 ? 3 : 6 : this.a.z0.r1().O().getIs_top() == 1 ? 5 : 4;
                            ForumData k = this.a.z0.r1().k();
                            String name3 = k.getName();
                            String id = k.getId();
                            String id2 = this.a.z0.r1().O().getId();
                            this.a.H0.F4();
                            this.a.C0.k0(id, name3, id2, i7, this.a.H0.Y0());
                        }
                    } else if (view2 == this.a.H0.f1()) {
                        if (this.a.z0 != null) {
                            BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), this.a.z0.r1().O().getTopicData().b());
                        }
                    } else if (view2 == this.a.H0.k.e) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                        if (this.a.z0.r1() != null && this.a.z0.r1().O() != null && this.a.z0.r1().O().isVideoThreadType() && this.a.z0.r1().O().getThreadVideoInfo() != null) {
                            TiebaStatic.log(new StatisticItem("c11922"));
                        }
                        if (this.a.z0.getErrorNo() == 4) {
                            if (!StringUtils.isNull(this.a.z0.Q0()) || this.a.z0.H0() == null) {
                                this.a.a.finish();
                                return;
                            }
                            name2 = this.a.z0.H0().b;
                        } else {
                            name2 = this.a.z0.r1().k().getName();
                        }
                        if (StringUtils.isNull(name2)) {
                            this.a.a.finish();
                            return;
                        }
                        String Q0 = this.a.z0.Q0();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                        if (!this.a.z0.W0() || Q0 == null || !Q0.equals(name2)) {
                            this.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
                        } else {
                            this.a.a.finish();
                        }
                    } else if (view2 == this.a.H0.k.f) {
                        if (jv5.a()) {
                            return;
                        }
                        if (this.a.z0 == null || this.a.z0.r1() == null) {
                            BdUtilHelper.showToast(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fe3));
                            return;
                        }
                        ArrayList<qba> F = this.a.z0.r1().F();
                        if ((F == null || F.size() <= 0) && this.a.z0.J1()) {
                            BdUtilHelper.showToast(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fe3));
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.z0.K1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.z0.getForumId()));
                        this.a.H0.j3();
                        this.a.u6();
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091ab9) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.H0.x3(true);
                        this.a.H0.j3();
                        if (this.a.h) {
                            return;
                        }
                        this.a.h = true;
                        this.a.H0.u4();
                        this.a.m7();
                        this.a.H0.M3();
                        this.a.z0.h3(this.a.y5());
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091a8c) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.H0.F0();
                        if (view2.getId() != R.id.obfuscated_res_0x7f091a8c || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                            if (ai9.c(this.a.getPageContext(), 11009) && this.a.z0.I0(this.a.H0.l1()) != null) {
                                this.a.n6();
                                if (this.a.z0.r1() != null && this.a.z0.r1().O() != null && this.a.z0.r1().O().getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.z0.b).param("fid", this.a.z0.r1().l()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                }
                                if (this.a.z0.r1().O() == null || this.a.z0.r1().O().getAuthor() == null || this.a.z0.r1().O().getAuthor().getUserId() == null || this.a.B0 == null) {
                                    return;
                                }
                                int v = ai9.v(this.a.z0.r1());
                                ThreadData O = this.a.z0.r1().O();
                                if (O.isBJHArticleThreadType()) {
                                    i6 = 2;
                                } else if (O.isBJHVideoThreadType()) {
                                    i6 = 3;
                                } else if (O.isBJHNormalThreadType()) {
                                    i6 = 4;
                                } else {
                                    i6 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.z0.b).param("obj_locate", 1).param("obj_id", this.a.z0.r1().O().getAuthor().getUserId()).param("obj_type", !this.a.B0.e()).param("obj_source", v).param("obj_param1", i6));
                                return;
                            }
                            return;
                        }
                        this.a.U = view2;
                    } else if ((this.a.H0.k.i() != null && view2 == this.a.H0.k.i().E()) || view2.getId() == R.id.obfuscated_res_0x7f090b73 || view2.getId() == R.id.obfuscated_res_0x7f091ed8) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            view2.setTag(Boolean.FALSE);
                            return;
                        }
                        this.a.H0.F0();
                        if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().E()) {
                            this.a.H0.j3();
                        }
                        if (this.a.h) {
                            view2.setTag(Boolean.FALSE);
                            return;
                        }
                        this.a.m7();
                        this.a.H0.M3();
                        boolean i32 = view2.getId() == R.id.obfuscated_res_0x7f090b73 ? this.a.z0.i3(true, this.a.y5()) : view2.getId() == R.id.obfuscated_res_0x7f091ed8 ? this.a.z0.i3(false, this.a.y5()) : this.a.z0.h3(this.a.y5());
                        view2.setTag(Boolean.valueOf(i32));
                        if (i32) {
                            i5 = 1;
                            this.a.H0.x3(true);
                            this.a.H0.u4();
                            this.a.h = true;
                            this.a.H0.B3(true);
                        } else {
                            i5 = 1;
                        }
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i5, new Object[0]);
                    } else if (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().y()) {
                        if (view2.getId() == R.id.share_num_container) {
                            if (ai9.c(this.a.getPageContext(), 11009)) {
                                ai9.w(this.a.getContext(), 3, this.a.u5(), this.a.z0);
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091a91 || view2.getId() == R.id.share_more_container) {
                            if ((!ShareSwitch.isOn() && !this.a.checkUpIsLogin()) || (r1 = this.a.z0.r1()) == null) {
                                return;
                            }
                            ThreadData O2 = r1.O();
                            if (O2 != null && O2.getAuthor() != null) {
                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.z0.b).param("fid", r1.l()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
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
                                statisticItem3.param("tid", this.a.z0.K1());
                                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem3.param("fid", this.a.z0.getForumId());
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
                                    fr5.e(this.a.Y(), statisticItem3);
                                }
                                if (this.a.H0 != null) {
                                    statisticItem3.param("obj_param1", this.a.H0.i1());
                                }
                                TiebaStatic.log(statisticItem3);
                                if (BdUtilHelper.isNetOk()) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e21);
                                    return;
                                } else if (r1 == null) {
                                    BdUtilHelper.showToast(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fe3));
                                    return;
                                } else {
                                    ArrayList<qba> F2 = this.a.z0.r1().F();
                                    if ((F2 == null || F2.size() <= 0) && this.a.z0.J1()) {
                                        BdUtilHelper.showToast(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fe3));
                                        return;
                                    }
                                    this.a.H0.F0();
                                    this.a.m7();
                                    if (r1.A() != null && !StringUtils.isNull(r1.A().a(), true)) {
                                        TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.z0.r1().l()));
                                    }
                                    TiebaStatic.log(new StatisticItem("c11939"));
                                    if (AntiHelper.e(this.a.getContext(), O2)) {
                                        return;
                                    }
                                    if (this.a.H0 != null) {
                                        this.a.H0.H0();
                                        this.a.H0.P4(r1);
                                    }
                                    if (ShareSwitch.isOn()) {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091a91) {
                                            i2 = 2;
                                        } else {
                                            i2 = view2.getId() == R.id.share_num_container ? 1 : 6;
                                        }
                                        if (!this.a.H0.q2() || r1.p0()) {
                                            this.a.g7(i2);
                                            return;
                                        } else {
                                            this.a.g7(i2);
                                            return;
                                        }
                                    }
                                    this.a.H0.k4();
                                    this.a.z0.L0().P(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                    return;
                                }
                            }
                            i = 1;
                            StatisticItem statisticItem32 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                            statisticItem32.param("tid", this.a.z0.K1());
                            statisticItem32.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem32.param("fid", this.a.z0.getForumId());
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
                            if (this.a.H0 != null) {
                            }
                            TiebaStatic.log(statisticItem32);
                            if (BdUtilHelper.isNetOk()) {
                            }
                        } else if (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().F()) {
                            if (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().N()) {
                                if (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().M()) {
                                    if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().J()) {
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
                                        this.a.H0.k.g();
                                        return;
                                    } else if (this.a.H0.j1() == view2) {
                                        if (!this.a.H0.j1().getIndicateStatus()) {
                                            wba.d("c10725", null);
                                        } else {
                                            sd9 r12 = this.a.z0.r1();
                                            if (r12 != null && r12.O() != null && r12.O().getTaskInfoData() != null) {
                                                String e = r12.O().getTaskInfoData().e();
                                                if (StringUtils.isNull(e)) {
                                                    e = r12.O().getTaskInfoData().h();
                                                }
                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", e));
                                            }
                                        }
                                        this.a.P5();
                                        return;
                                    } else if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().A()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        this.a.H0.F0();
                                        SparseArray<Object> n1 = this.a.H0.n1(this.a.z0.r1(), this.a.z0.J1(), 1);
                                        if (n1 == null) {
                                            return;
                                        }
                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.z0.r1().k().getId(), this.a.z0.r1().k().getName(), this.a.z0.r1().O().getId(), StringUtils.string(this.a.z0.r1().V().getUserId()), StringUtils.string(n1.get(R.id.tag_forbid_user_name)), StringUtils.string(n1.get(R.id.tag_forbid_user_name_show)), StringUtils.string(n1.get(R.id.tag_forbid_user_post_id)), StringUtils.string(n1.get(R.id.tag_forbid_user_portrait)))));
                                        return;
                                    } else if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().u()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        SparseArray<Object> n12 = this.a.H0.n1(this.a.z0.r1(), this.a.z0.J1(), 1);
                                        if (n12 != null) {
                                            this.a.H0.Q2(((Integer) n12.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(n12.get(R.id.tag_del_post_id)), ((Integer) n12.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n12.get(R.id.tag_del_post_is_self)).booleanValue());
                                        }
                                        this.a.H0.k.f();
                                        if (this.a.R() == null || this.a.R().r1() == null || this.a.R().r1().O() == null) {
                                            return;
                                        }
                                        ThreadData O3 = this.a.R().r1().O();
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
                                    } else if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().z()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        SparseArray<Object> n13 = this.a.H0.n1(this.a.z0.r1(), this.a.z0.J1(), 1);
                                        if (n13 != null) {
                                            if (StringUtils.isNull((String) n13.get(R.id.tag_del_multi_forum))) {
                                                this.a.H0.N2(((Integer) n13.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(n13.get(R.id.tag_del_post_id)), ((Integer) n13.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n13.get(R.id.tag_del_post_is_self)).booleanValue());
                                            } else {
                                                this.a.H0.O2(((Integer) n13.get(R.id.tag_del_post_type)).intValue(), (String) n13.get(R.id.tag_del_post_id), ((Integer) n13.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) n13.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(n13.get(R.id.tag_del_multi_forum)));
                                            }
                                        }
                                        this.a.H0.k.f();
                                        return;
                                    } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f0922ca && view2.getId() != R.id.obfuscated_res_0x7f091aa5 && view2.getId() != R.id.obfuscated_res_0x7f091923) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091b10) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091b0e && view2.getId() != R.id.obfuscated_res_0x7f091cf2 && view2.getId() != R.id.obfuscated_res_0x7f091a9f) {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091aa3) {
                                                    try {
                                                        sparseArray = (SparseArray) view2.getTag();
                                                    } catch (ClassCastException e2) {
                                                        e2.printStackTrace();
                                                        sparseArray = null;
                                                    }
                                                    qba qbaVar = (qba) sparseArray.get(R.id.tag_clip_board);
                                                    if (qbaVar == null) {
                                                        return;
                                                    }
                                                    if (this.a.N0 == null) {
                                                        PbFragment pbFragment = this.a;
                                                        pbFragment.N0 = new w45(pbFragment.getContext());
                                                        this.a.N0.q(this.a.h2);
                                                    }
                                                    ArrayList arrayList = new ArrayList();
                                                    boolean z3 = this.a.R().r1() != null && this.a.R().r1().j0();
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
                                                    if (qbaVar.o() != null) {
                                                        boolean z4 = qbaVar.o().hasAgree;
                                                        int q = qbaVar.q();
                                                        if (z4 && q == 5) {
                                                            string = this.a.getString(R.string.action_cancel_dislike);
                                                        } else {
                                                            string = this.a.getString(R.string.action_dislike);
                                                        }
                                                        s45 s45Var8 = new s45(8, string, this.a.N0);
                                                        SparseArray sparseArray2 = new SparseArray();
                                                        sparseArray2.put(R.id.tag_clip_board, qbaVar);
                                                        s45Var8.d.setTag(sparseArray2);
                                                        arrayList.add(s45Var8);
                                                    }
                                                    if (this.a.mIsLogin) {
                                                        if (!yj9.i(this.a.z0) && !booleanValue3 && booleanValue2) {
                                                            s45 s45Var9 = new s45(5, this.a.getString(R.string.obfuscated_res_0x7f0f0cfd), this.a.N0);
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
                                                        } else if ((ai9.C(this.a.z0.r1(), booleanValue) && TbadkCoreApplication.isLogin()) && !z3) {
                                                            s45 s45Var10 = new s45(5, this.a.getString(R.string.report_text), this.a.N0);
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
                                                                    s45 s45Var11 = new s45(6, this.a.getString(R.string.obfuscated_res_0x7f0f0546), this.a.N0);
                                                                    s45Var11.d.setTag(sparseArray4);
                                                                    s45Var2 = s45Var11;
                                                                    s45Var = new s45(7, this.a.getString(R.string.obfuscated_res_0x7f0f0322), this.a.N0);
                                                                    s45Var.d.setTag(sparseArray4);
                                                                }
                                                            } else {
                                                                sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                            }
                                                            s45Var2 = null;
                                                            s45Var = new s45(7, this.a.getString(R.string.obfuscated_res_0x7f0f0322), this.a.N0);
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
                                                            if (this.a.z0.r1().W() == 1002 && !booleanValue) {
                                                                s45Var3 = new s45(6, this.a.getString(R.string.report_text), this.a.N0);
                                                            } else {
                                                                s45Var3 = new s45(6, this.a.getString(R.string.obfuscated_res_0x7f0f0546), this.a.N0);
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
                                                    this.a.N0.l(arrayList);
                                                    this.a.M0 = new u45(this.a.getPageContext(), this.a.N0);
                                                    this.a.M0.l();
                                                    return;
                                                } else if (view2 == this.a.H0.h1()) {
                                                    if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                        this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, JavaTypesHelper.toLong(this.a.z0.r1().l(), 0L), JavaTypesHelper.toLong(this.a.z0.K1(), 0L), JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.z0.r1().O().getPushStatusData())));
                                                        return;
                                                    }
                                                    return;
                                                } else if (this.a.H0.k.i() == null || view2 != this.a.H0.k.i().K()) {
                                                    if (this.a.H0.k.i() != null && view2 == this.a.H0.k.i().D()) {
                                                        TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                        if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.z0.K1())) == null) {
                                                            return;
                                                        }
                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                        this.a.H0.k.f();
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
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091edd || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                            if (this.a.checkUpIsLogin()) {
                                                                TiebaStatic.log(new StatisticItem("c11740"));
                                                                if (view2 == null || view2.getTag() == null) {
                                                                    return;
                                                                }
                                                                SparseArray sparseArray6 = (SparseArray) view2.getTag();
                                                                qba qbaVar2 = (qba) sparseArray6.get(R.id.tag_load_sub_data);
                                                                if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                    TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.z0.b));
                                                                }
                                                                if (this.a.N0 == null) {
                                                                    PbFragment pbFragment2 = this.a;
                                                                    pbFragment2.N0 = new w45(pbFragment2.getContext());
                                                                    this.a.N0.q(this.a.h2);
                                                                }
                                                                ArrayList arrayList2 = new ArrayList();
                                                                boolean booleanValue7 = sparseArray6.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                                                                boolean booleanValue8 = sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                boolean booleanValue9 = sparseArray6.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                                                                boolean booleanValue10 = sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                boolean booleanValue11 = sparseArray6.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                                                                String str2 = sparseArray6.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray6.get(R.id.tag_forbid_user_post_id) : null;
                                                                boolean booleanValue12 = sparseArray6.get(R.id.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_is_self_post)).booleanValue() : false;
                                                                if (qbaVar2 != null) {
                                                                    if (qbaVar2.e0() != null && qbaVar2.e0().toString().length() > 0) {
                                                                        s45 s45Var12 = new s45(3, this.a.getString(R.string.obfuscated_res_0x7f0f04e1), this.a.N0);
                                                                        SparseArray sparseArray7 = new SparseArray();
                                                                        sparseArray7.put(R.id.tag_clip_board, qbaVar2);
                                                                        s45Var12.d.setTag(sparseArray7);
                                                                        arrayList2.add(s45Var12);
                                                                    }
                                                                    this.a.C2 = qbaVar2;
                                                                }
                                                                if (this.a.z0.r1().q()) {
                                                                    String u = this.a.z0.r1().u();
                                                                    if (qbaVar2 != null && !bi.isEmpty(u) && u.equals(qbaVar2.S())) {
                                                                        z = true;
                                                                        if (!z) {
                                                                            s45Var4 = new s45(4, this.a.getString(R.string.remove_mark), this.a.N0);
                                                                        } else {
                                                                            s45Var4 = new s45(4, this.a.getString(R.string.obfuscated_res_0x7f0f0c3d), this.a.N0);
                                                                        }
                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                        sparseArray8.put(R.id.tag_clip_board, this.a.C2);
                                                                        sparseArray8.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                        s45Var4.d.setTag(sparseArray8);
                                                                        arrayList2.add(s45Var4);
                                                                        if (this.a.mIsLogin) {
                                                                            if (!yj9.i(this.a.z0) && !booleanValue9 && booleanValue8) {
                                                                                s45 s45Var13 = new s45(5, this.a.getString(R.string.obfuscated_res_0x7f0f0cfd), this.a.N0);
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
                                                                            } else if (ai9.C(this.a.z0.r1(), booleanValue7) && TbadkCoreApplication.isLogin()) {
                                                                                s45 s45Var14 = new s45(5, this.a.getString(R.string.report_text), this.a.N0);
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
                                                                                        s45 s45Var15 = new s45(6, this.a.getString(R.string.obfuscated_res_0x7f0f0546), this.a.N0);
                                                                                        s45Var15.d.setTag(sparseArray10);
                                                                                        s45Var6 = s45Var15;
                                                                                        s45Var5 = new s45(7, this.a.getString(R.string.obfuscated_res_0x7f0f0322), this.a.N0);
                                                                                        s45Var5.d.setTag(sparseArray10);
                                                                                    }
                                                                                } else {
                                                                                    sparseArray10.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                }
                                                                                s45Var6 = null;
                                                                                s45Var5 = new s45(7, this.a.getString(R.string.obfuscated_res_0x7f0f0322), this.a.N0);
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
                                                                                if (this.a.z0.r1().W() == 1002 && !booleanValue7) {
                                                                                    s45Var7 = new s45(6, this.a.getString(R.string.report_text), this.a.N0);
                                                                                } else {
                                                                                    s45Var7 = new s45(6, this.a.getString(R.string.obfuscated_res_0x7f0f0546), this.a.N0);
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
                                                                        this.a.N0.l(arrayList2);
                                                                        this.a.M0 = new u45(this.a.getPageContext(), this.a.N0);
                                                                        this.a.M0.l();
                                                                        return;
                                                                    }
                                                                }
                                                                z = false;
                                                                if (!z) {
                                                                }
                                                                SparseArray sparseArray82 = new SparseArray();
                                                                sparseArray82.put(R.id.tag_clip_board, this.a.C2);
                                                                sparseArray82.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                s45Var4.d.setTag(sparseArray82);
                                                                arrayList2.add(s45Var4);
                                                                if (this.a.mIsLogin) {
                                                                }
                                                                this.a.N0.l(arrayList2);
                                                                this.a.M0 = new u45(this.a.getPageContext(), this.a.N0);
                                                                this.a.M0.l();
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.pb_act_btn) {
                                                            if (this.a.z0.r1() == null || this.a.z0.r1().O() == null || this.a.z0.r1().O().getActUrl() == null) {
                                                                return;
                                                            }
                                                            BrowserHelper.startWebActivity(this.a.getActivity(), this.a.z0.r1().O().getActUrl());
                                                            if (this.a.z0.r1().O().getActInfoType() == 1) {
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                return;
                                                            } else if (this.a.z0.r1().O().getActInfoType() == 2) {
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (id3 == R.id.lottery_tail) {
                                                            if (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                String string2 = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
                                                                TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.z0.r1().l()).param("tid", this.a.z0.r1().Q()).param("lotterytail", StringUtils.string(string2, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                if (!this.a.z0.r1().Q().equals(string2)) {
                                                                    this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(string2, (String) null, (String) null, (String) null)));
                                                                    return;
                                                                } else {
                                                                    this.a.H0.Q3(0);
                                                                    return;
                                                                }
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091ad3 || id3 == R.id.obfuscated_res_0x7f091a99) {
                                                            if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                String string3 = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                String string4 = SharedPrefHelper.getInstance().getString("tail_link", "");
                                                                String string5 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
                                                                if (!StringUtils.isNull(string4)) {
                                                                    TiebaStatic.log("c10056");
                                                                    BrowserHelper.startWebActivity(view2.getContext(), string3, UtilHelper.urlAddParam(string4, "page_from=1&tailSkinId=" + string5), true, true, true);
                                                                }
                                                                this.a.H0.j3();
                                                                TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string5));
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.join_vote_tv) {
                                                            if (view2 != null) {
                                                                BrowserHelper.startWebActivity(this.a.getActivity(), StringUtils.string(view2.getTag()));
                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                if (this.a.u5() != 1 || this.a.z0 == null || this.a.z0.r1() == null) {
                                                                    return;
                                                                }
                                                                ql9.w("c10397", this.a.z0.r1().l(), this.a.z0.r1().Q(), currentAccount);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.look_all_tv) {
                                                            if (view2 != null) {
                                                                String string6 = StringUtils.string(view2.getTag());
                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                BrowserHelper.startWebActivity(this.a.getActivity(), string6);
                                                                if (this.a.u5() != 1 || this.a.z0 == null || this.a.z0.r1() == null) {
                                                                    return;
                                                                }
                                                                ql9.w("c10507", this.a.z0.r1().l(), this.a.z0.r1().Q(), currentAccount2);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f0916c9) {
                                                            this.a.j6();
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f0916c8) {
                                                            this.a.h6();
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f092744) {
                                                            if (this.a.p1 >= 0) {
                                                                if (this.a.z0 != null) {
                                                                    this.a.z0.K2();
                                                                }
                                                                if (this.a.z0 == null || this.a.H0.T0() == null) {
                                                                    i4 = 0;
                                                                } else {
                                                                    i4 = 0;
                                                                    this.a.H0.T0().n0(this.a.z0.r1(), false);
                                                                }
                                                                this.a.p1 = i4;
                                                                if (this.a.z0 != null) {
                                                                    if (this.a.H0.m1() != null) {
                                                                        this.a.H0.m1().setSelection(this.a.z0.k1());
                                                                    }
                                                                    this.a.z0.O2(0, 0);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.qq_share_container) {
                                                            if (ai9.c(this.a.getPageContext(), 11009)) {
                                                                ai9.w(this.a.getContext(), 8, this.a.u5(), this.a.z0);
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
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091a8e) {
                                                            if (this.a.H0.m1() == null || this.a.z0 == null || this.a.z0.r1() == null) {
                                                                return;
                                                            }
                                                            int firstVisiblePosition = this.a.H0.m1().getFirstVisiblePosition();
                                                            View childAt = this.a.H0.m1().getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            boolean x0 = this.a.z0.r1().x0();
                                                            boolean m2 = this.a.H0.m2();
                                                            boolean z5 = firstVisiblePosition == 0 && top == 0;
                                                            ai9.f(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.a.z0.r1());
                                                            if ((this.a.z0.r1().O() != null && this.a.z0.r1().O().getReply_num() <= 0) || (m2 && z5)) {
                                                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                if (!this.a.checkUpIsLogin()) {
                                                                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                    return;
                                                                }
                                                                this.a.y6();
                                                                if (this.a.z0.r1().O().getAuthor() != null) {
                                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.z0.b).param("fid", this.a.z0.r1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                                }
                                                            } else {
                                                                int equipmentHeight = (int) (BdUtilHelper.getEquipmentHeight(this.a.getContext()) * 0.6d);
                                                                if (x0) {
                                                                    if (this.a.H0.h1 != null) {
                                                                        if (this.a.H0.h1.a != null && this.a.H0.h1.a.getView() != null) {
                                                                            if (this.a.H0.h1.a.getView().getParent() != null) {
                                                                            }
                                                                        }
                                                                    }
                                                                    z2 = false;
                                                                } else {
                                                                    if (this.a.H0.u1() != null) {
                                                                        z2 = this.a.H0.u1().getVisibility() == 0;
                                                                        if (!z2 && this.a.H0.h1 != null && this.a.H0.h1.a != null && this.a.H0.h1.a.getView() != null && this.a.H0.h1.a.getView().getParent() != null && this.a.H0.k != null && this.a.H0.k.a != null) {
                                                                        }
                                                                    }
                                                                    z2 = false;
                                                                }
                                                                if (z2 || m2) {
                                                                    this.a.a0 = firstVisiblePosition;
                                                                    this.a.b0 = top;
                                                                    if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-equipmentHeight))) {
                                                                        int i9 = -equipmentHeight;
                                                                        this.a.H0.m1().setSelectionFromTop(0, i9);
                                                                        this.a.H0.m1().smoothScrollBy(i9, 500);
                                                                    } else {
                                                                        this.a.H0.m1().D(0, 0, 500);
                                                                    }
                                                                } else if (this.a.a0 <= 0) {
                                                                    int d = cj9.d(this.a.getListView());
                                                                    if (cj9.e(this.a.getListView()) != -1) {
                                                                        d--;
                                                                    }
                                                                    int dimens = BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds100);
                                                                    if (d < 0) {
                                                                        d = (ListUtils.getCount(this.a.H0.m1().getData()) - 1) + this.a.H0.m1().getHeaderViewsCount();
                                                                        i3 = 0;
                                                                    } else {
                                                                        i3 = dimens;
                                                                    }
                                                                    if (this.a.H0.k != null && this.a.H0.k.a != null) {
                                                                        i3 += this.a.H0.k.a.getFixedNavHeight() - 10;
                                                                    }
                                                                    if (this.a.H0.h1 == null || this.a.H0.h1.a == null || this.a.H0.h1.a.getView() == null || this.a.H0.h1.a.getView().getParent() == null) {
                                                                        this.a.H0.m1().setSelectionFromTop(d, i3 + equipmentHeight);
                                                                        this.a.H0.m1().smoothScrollBy(equipmentHeight, 500);
                                                                    } else {
                                                                        this.a.H0.m1().D(d, i3, 200);
                                                                    }
                                                                } else if (this.a.H0.m1().getChildAt(this.a.a0) == null) {
                                                                    this.a.H0.m1().setSelectionFromTop(this.a.a0, this.a.b0 + equipmentHeight);
                                                                    this.a.H0.m1().smoothScrollBy(equipmentHeight, 500);
                                                                } else {
                                                                    this.a.H0.m1().D(this.a.a0, this.a.b0, 200);
                                                                }
                                                            }
                                                            if (this.a.z0.r1().O() == null || this.a.z0.r1().O().getAuthor() == null) {
                                                                return;
                                                            }
                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.z0.b).param("fid", this.a.z0.r1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091afa) {
                                                            if (this.a.z0 == null || this.a.z0.r1() == null || this.a.z0.r1().k() == null || bi.isEmpty(this.a.z0.r1().k().getName())) {
                                                                return;
                                                            }
                                                            if (this.a.z0.getErrorNo() == 4) {
                                                                if (!StringUtils.isNull(this.a.z0.Q0()) || this.a.z0.H0() == null) {
                                                                    this.a.a.finish();
                                                                    return;
                                                                }
                                                                name = this.a.z0.H0().b;
                                                            } else {
                                                                name = this.a.z0.r1().k().getName();
                                                            }
                                                            if (StringUtils.isNull(name)) {
                                                                this.a.a.finish();
                                                                return;
                                                            }
                                                            String Q02 = this.a.z0.Q0();
                                                            if (!this.a.z0.W0() || Q02 == null || !Q02.equals(name)) {
                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.z0.r1().k().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                createNormalCfg2.setCallFrom(2);
                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                            } else {
                                                                this.a.a.finish();
                                                            }
                                                            StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                            statisticItem6.param("tid", this.a.z0.K1());
                                                            statisticItem6.param("fid", this.a.z0.getForumId());
                                                            statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            if (this.a.z0.r1().O() != null) {
                                                                statisticItem6.param("nid", this.a.z0.r1().O().getNid());
                                                            }
                                                            TiebaStatic.log(statisticItem6);
                                                            return;
                                                        } else if (id3 != R.id.forum_name_text && id3 != R.id.forum_enter_button_one && id3 != R.id.forum_enter_button_two && id3 != R.id.forum_enter_button_three) {
                                                            if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                if (this.a.z0 == null) {
                                                                    return;
                                                                }
                                                                StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                statisticItem7.param("tid", this.a.z0.K1());
                                                                statisticItem7.param("fid", this.a.z0.getForumId());
                                                                statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem7.param("obj_locate", 2);
                                                                TiebaStatic.log(statisticItem7);
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091b22) {
                                                                if (this.a.z0 == null || this.a.z0.r1() == null) {
                                                                    return;
                                                                }
                                                                sd9 r13 = this.a.z0.r1();
                                                                if (this.a.E0 == null) {
                                                                    PbFragment pbFragment3 = this.a;
                                                                    pbFragment3.E0 = new le9(pbFragment3.getPageContext());
                                                                }
                                                                long j = JavaTypesHelper.toLong(r13.Q(), 0L);
                                                                long j2 = JavaTypesHelper.toLong(r13.l(), 0L);
                                                                ql9.y("c13446", j2);
                                                                PbFragment pbFragment4 = this.a;
                                                                pbFragment4.registerListener(pbFragment4.o2);
                                                                this.a.E0.a(j, j2);
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091b3c) {
                                                                if (view2.getTag() instanceof SmartApp) {
                                                                    SmartApp smartApp = (SmartApp) view2.getTag();
                                                                    if (!TbAiappsLaunchUtil.launch(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                        if (StringUtils.isNull(smartApp.h5_url)) {
                                                                            return;
                                                                        }
                                                                        BrowserHelper.startWebActivity(this.a.getActivity(), smartApp.h5_url);
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.z0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.naws_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.z0.K1()).param("obj_param1", smartApp.is_game.intValue()));
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
                                                            } else if (id3 != R.id.obfuscated_res_0x7f091aa7 && id3 != R.id.obfuscated_res_0x7f091b08) {
                                                                if (id3 == R.id.obfuscated_res_0x7f092762) {
                                                                    if (view2.getTag(R.id.tag_is_top_question) instanceof Boolean) {
                                                                        ql9.u(5);
                                                                    }
                                                                    this.a.N6(false);
                                                                    this.a.l7((qba) view2.getTag(R.id.tag_pb_top_replay_more), false);
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (this.a.s0) {
                                                                return;
                                                            } else {
                                                                StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                statisticItem8.param("tid", this.a.z0.K1());
                                                                statisticItem8.param("fid", this.a.z0.getForumId());
                                                                statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem8.param("obj_locate", 7);
                                                                TiebaStatic.log(statisticItem8);
                                                                SparseArray sparseArray13 = (SparseArray) view2.getTag();
                                                                if (sparseArray13 != null && (sparseArray13.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray13.get(R.id.tag_is_top_question)).booleanValue()) {
                                                                    ql9.u(6);
                                                                }
                                                                PbFragment pbFragment5 = this.a;
                                                                pbFragment5.b = false;
                                                                pbFragment5.i5(view2);
                                                                return;
                                                            }
                                                        } else if (view2.getTag() instanceof ThreadData) {
                                                            ThreadData threadData3 = (ThreadData) view2.getTag();
                                                            if (this.a.z0.q1() != 3 || !this.a.A0() || this.a.z0.r1() == null || !ListUtils.isEmpty(this.a.z0.r1().o())) {
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
                                                        if (sparseArray14 == null || !(sparseArray14.get(R.id.tag_load_sub_data) instanceof qba)) {
                                                            return;
                                                        }
                                                        qba qbaVar3 = (qba) sparseArray14.get(R.id.tag_load_sub_data);
                                                        View view3 = (View) sparseArray14.get(R.id.tag_load_sub_view);
                                                        if (qbaVar3 == null || view3 == null) {
                                                            return;
                                                        }
                                                        ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090871);
                                                        EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090872);
                                                        View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b70);
                                                        if (qbaVar3.C0()) {
                                                            qbaVar3.f1(false);
                                                            ck9.e(qbaVar3);
                                                        } else if (this.a.R() != null ? ck9.c(this.a.R().r1(), qbaVar3) : false) {
                                                            qbaVar3.f1(true);
                                                        }
                                                        SkinManager.setBackgroundColor(findViewById, qbaVar3.C0() ? R.color.CAM_X0201 : R.color.transparent);
                                                        SkinManager.setViewTextColor(eMTextView, qbaVar3.C0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                        WebPManager.setPureDrawable(imageView, qbaVar3.C0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, qbaVar3.C0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                        return;
                                                    }
                                                } else {
                                                    this.a.H0.k.g();
                                                    this.a.H0.r4(this.a.F2);
                                                    return;
                                                }
                                            } else if (this.a.z0 == null) {
                                                return;
                                            } else {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091b0e) {
                                                    StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                    statisticItem10.param("tid", this.a.z0.K1());
                                                    statisticItem10.param("fid", this.a.z0.getForumId());
                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem10.param("obj_locate", 6);
                                                    TiebaStatic.log(statisticItem10);
                                                }
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091cf2) {
                                                    if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                        this.a.f1141T = view2;
                                                        return;
                                                    }
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091b0e && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                    this.a.f1141T = view2;
                                                    return;
                                                }
                                                if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray15 = (SparseArray) view2.getTag();
                                                    if (sparseArray15.get(R.id.tag_load_sub_data) instanceof qba) {
                                                        qba qbaVar4 = (qba) sparseArray15.get(R.id.tag_load_sub_data);
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f091b0e && (statisticItem = qbaVar4.f0) != null) {
                                                            StatisticItem copy = statisticItem.copy();
                                                            copy.delete("obj_locate");
                                                            copy.param("obj_locate", 8);
                                                            TiebaStatic.log(copy);
                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091cf2 || view2.getId() == R.id.obfuscated_res_0x7f091a9f) {
                                                            TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.z0.L1()).param("fid", this.a.z0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", qbaVar4.S()).param("obj_source", 1).param("obj_type", 3));
                                                        }
                                                        if (this.a.z0 == null || this.a.z0.r1() == null || this.a.M5().v1() == null || qbaVar4.r() == null || qbaVar4.I() == 1) {
                                                            return;
                                                        }
                                                        if (this.a.M5().w1() != null) {
                                                            this.a.M5().w1().g();
                                                        }
                                                        je9 je9Var = new je9();
                                                        je9Var.v(this.a.z0.r1().k());
                                                        je9Var.z(this.a.z0.r1().O());
                                                        je9Var.x(qbaVar4);
                                                        this.a.M5().v1().j0(je9Var);
                                                        this.a.M5().v1().setPostId(qbaVar4.S());
                                                        this.a.k6(view2, qbaVar4.r().getUserId(), "", qbaVar4);
                                                        if (this.a.W0 != null) {
                                                            this.a.H0.r3(this.a.W0.z());
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        } else if (this.a.z0 == null) {
                                            return;
                                        } else {
                                            StatisticItem statisticItem11 = new StatisticItem("c13398");
                                            statisticItem11.param("tid", this.a.z0.K1());
                                            statisticItem11.param("fid", this.a.z0.getForumId());
                                            statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem11.param("obj_locate", 5);
                                            TiebaStatic.log(statisticItem11);
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091b10 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray16 = (SparseArray) view2.getTag();
                                                    if (sparseArray16.get(R.id.tag_load_sub_data) instanceof qba) {
                                                        qba qbaVar5 = (qba) sparseArray16.get(R.id.tag_load_sub_data);
                                                        StatisticItem statisticItem12 = qbaVar5.f0;
                                                        if (statisticItem12 != null) {
                                                            StatisticItem copy2 = statisticItem12.copy();
                                                            copy2.delete("obj_locate");
                                                            copy2.param("obj_locate", 8);
                                                            TiebaStatic.log(copy2);
                                                        }
                                                        if (this.a.z0 == null || this.a.z0.r1() == null) {
                                                            return;
                                                        }
                                                        String K1 = this.a.z0.K1();
                                                        String S = qbaVar5.S();
                                                        int W = this.a.z0.r1() != null ? this.a.z0.r1().W() : 0;
                                                        AbsPbActivity.e z6 = this.a.z6(S);
                                                        if (z6 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(K1, S, "pb", true, false, null, false, null, W, qbaVar5.l0(), this.a.z0.r1().c(), false, qbaVar5.r().getIconInfo(), 5).addBigImageData(z6.a, z6.b, z6.g, z6.j);
                                                        addBigImageData.setKeyPageStartFrom(this.a.z0.q1());
                                                        addBigImageData.setFromFrsForumId(this.a.z0.getFromForumId());
                                                        addBigImageData.setWorksInfoData(this.a.z0.P1());
                                                        addBigImageData.setKeyFromForumId(this.a.z0.getForumId());
                                                        addBigImageData.setTiebaPlusData(this.a.z0.W(), this.a.z0.S(), this.a.z0.T(), this.a.z0.R(), this.a.z0.X());
                                                        addBigImageData.setBjhData(this.a.z0.J0());
                                                        if (this.a.z0.r1().n() != null) {
                                                            addBigImageData.setHasForumRule(this.a.z0.r1().n().has_forum_rule.intValue());
                                                        }
                                                        if (this.a.z0.r1().V() != null) {
                                                            addBigImageData.setIsManager(this.a.z0.r1().V().getIs_manager());
                                                        }
                                                        if (this.a.z0.r1().k().getDeletedReasonInfo() != null) {
                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.z0.r1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.z0.r1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                                                        }
                                                        if (this.a.z0.r1().k() != null) {
                                                            addBigImageData.setForumHeadUrl(this.a.z0.r1().k().getImage_url());
                                                            addBigImageData.setUserLevel(this.a.z0.r1().k().getUser_level());
                                                        }
                                                        if (this.a.H0 != null && this.a.z0.G != null) {
                                                            addBigImageData.setMainPostMaskVisibly(this.a.z0.G.X().f1152T || qbaVar5.f1152T);
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
                                            statisticItem13.param("tid", this.a.z0.K1());
                                            statisticItem13.param("fid", this.a.z0.getForumId());
                                            statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem13.param("obj_locate", 4);
                                            TiebaStatic.log(statisticItem13);
                                        }
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091aa5 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                            if (!this.a.checkUpIsLogin()) {
                                                ql9.t("c10517", this.a.z0.r1().l(), 3);
                                                return;
                                            } else if (this.a.z0 == null || this.a.z0.r1() == null) {
                                                return;
                                            } else {
                                                this.a.H0.F0();
                                                SparseArray sparseArray17 = (SparseArray) view2.getTag();
                                                qba qbaVar6 = (qba) sparseArray17.get(R.id.tag_load_sub_data);
                                                qba qbaVar7 = (qba) sparseArray17.get(R.id.tag_load_sub_reply_data);
                                                View view4 = (View) sparseArray17.get(R.id.tag_load_sub_view);
                                                if (qbaVar6 == null || view4 == null) {
                                                    return;
                                                }
                                                if (qbaVar6.N() == 1) {
                                                    TiebaStatic.log(new StatisticItem("c12630"));
                                                }
                                                StatisticItem statisticItem14 = qbaVar6.f0;
                                                if (statisticItem14 != null) {
                                                    StatisticItem copy3 = statisticItem14.copy();
                                                    copy3.delete("obj_locate");
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091923) {
                                                        copy3.param("obj_locate", 6);
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091aa5) {
                                                        copy3.param("obj_locate", 8);
                                                    }
                                                    TiebaStatic.log(copy3);
                                                }
                                                String K12 = this.a.z0.K1();
                                                String S2 = qbaVar6.S();
                                                String S3 = qbaVar7 != null ? qbaVar7.S() : "";
                                                int W2 = this.a.z0.r1() != null ? this.a.z0.r1().W() : 0;
                                                this.a.m7();
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091edd) {
                                                    TiebaStatic.log("c11742");
                                                    AbsPbActivity.e z62 = this.a.z6(S2);
                                                    if (qbaVar6 == null || this.a.z0 == null || this.a.z0.r1() == null || z62 == null) {
                                                        return;
                                                    }
                                                    SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(K12, S2, "pb", true, false, null, false, S3, W2, qbaVar6.l0(), this.a.z0.r1().c(), false, qbaVar6.r().getIconInfo(), 5).addBigImageData(z62.a, z62.b, z62.g, z62.j);
                                                    if (!bi.isEmpty(S3)) {
                                                        addBigImageData2.setHighLightPostId(S3);
                                                        addBigImageData2.setKeyIsUseSpid(true);
                                                    }
                                                    addBigImageData2.setKeyFromForumId(this.a.z0.getForumId());
                                                    addBigImageData2.setTiebaPlusData(this.a.z0.W(), this.a.z0.S(), this.a.z0.T(), this.a.z0.R(), this.a.z0.X());
                                                    addBigImageData2.setBjhData(this.a.z0.J0());
                                                    addBigImageData2.setKeyPageStartFrom(this.a.z0.q1());
                                                    addBigImageData2.setFromFrsForumId(this.a.z0.getFromForumId());
                                                    addBigImageData2.setWorksInfoData(this.a.z0.P1());
                                                    if (this.a.H0 != null && this.a.z0.G != null && (X = this.a.z0.G.X()) != null) {
                                                        addBigImageData2.setMainPostMaskVisibly(X.f1152T || qbaVar6.f1152T);
                                                    }
                                                    if (this.a.z0.r1() != null && this.a.z0.r1().n() != null) {
                                                        addBigImageData2.setHasForumRule(this.a.z0.r1().n().has_forum_rule.intValue());
                                                    }
                                                    this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                    return;
                                                }
                                                AbsPbActivity.e z63 = this.a.z6(S2);
                                                if (this.a.z0 == null || this.a.z0.r1() == null || z63 == null) {
                                                    return;
                                                }
                                                SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(K12, S2, "pb", true, false, null, true, null, W2, qbaVar6.l0(), this.a.z0.r1().c(), false, qbaVar6.r().getIconInfo(), 5).addBigImageData(z63.a, z63.b, z63.g, z63.j);
                                                addBigImageData3.setKeyPageStartFrom(this.a.z0.q1());
                                                addBigImageData3.setFromFrsForumId(this.a.z0.getFromForumId());
                                                addBigImageData3.setWorksInfoData(this.a.z0.P1());
                                                addBigImageData3.setKeyFromForumId(this.a.z0.getForumId());
                                                addBigImageData3.setBjhData(this.a.z0.J0());
                                                addBigImageData3.setTiebaPlusData(this.a.z0.W(), this.a.z0.S(), this.a.z0.T(), this.a.z0.R(), this.a.z0.X());
                                                this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                return;
                                            }
                                        }
                                        this.a.S = view2;
                                        return;
                                    }
                                } else if (this.a.z0 == null || this.a.z0.r1() == null || this.a.z0.r1().O() == null) {
                                    return;
                                } else {
                                    this.a.H0.k.f();
                                    TiebaStatic.log(new StatisticItem("c13062"));
                                    PbFragment pbFragment6 = this.a;
                                    pbFragment6.T5(pbFragment6.z0.r1().O().getFirstPostId());
                                    return;
                                }
                            }
                            this.a.H0.F0();
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                            } else if (this.a.h) {
                                view2.setTag(Integer.valueOf(this.a.z0.H1()));
                            } else {
                                this.a.m7();
                                this.a.H0.M3();
                                u45 u45Var = new u45(this.a.getPageContext());
                                if (this.a.z0.r1().f == null || this.a.z0.r1().f.size() <= 0) {
                                    strArr = new String[]{this.a.getResources().getString(R.string.sort_type_new), this.a.getResources().getString(R.string.sort_type_old)};
                                } else {
                                    strArr = new String[this.a.z0.r1().f.size()];
                                    for (int i10 = 0; i10 < this.a.z0.r1().f.size(); i10++) {
                                        strArr[i10] = this.a.z0.r1().f.get(i10).sort_name + this.a.getResources().getString(R.string.sort_static);
                                    }
                                }
                                u45Var.i(null, strArr, new a(this, u45Var, view2));
                                u45Var.l();
                            }
                        } else {
                            this.a.H0.F0();
                            if (this.a.R().r1().g == 2) {
                                this.a.showToast(R.string.hot_sort_jump_hint);
                                return;
                            }
                            if (this.a.z0.p1() != null) {
                                this.a.H0.y4(this.a.z0.p1(), this.a.f2);
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                        }
                    } else {
                        this.a.H0.k.f();
                    }
                } else {
                    this.a.H0.k.g();
                    if (this.a.z0 != null) {
                        this.a.t1.f(this.a.z0.K1());
                    }
                    if (this.a.z0 != null && this.a.z0.isPrivacy()) {
                        this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                        if (this.a.R() == null || this.a.R().r1() == null) {
                            return;
                        }
                        this.a.t1.d(3, 3, this.a.R().r1().Q());
                        return;
                    }
                    this.a.t1.b();
                    int i11 = (TbSingleton.getInstance().mCanCallFans || this.a.R() == null || this.a.R().r1() == null || this.a.R().r1().Q() == null || !this.a.R().r1().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                    if (this.a.R() == null || this.a.R().r1() == null) {
                        return;
                    }
                    this.a.t1.d(3, i11, this.a.R().r1().Q());
                }
            } else if (!this.a.s0) {
                StatisticItem statisticItem15 = new StatisticItem("c13398");
                statisticItem15.param("tid", this.a.z0.K1());
                statisticItem15.param("fid", this.a.z0.getForumId());
                statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem15.param("obj_locate", 1);
                TiebaStatic.log(statisticItem15);
                SparseArray sparseArray18 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                if (sparseArray18 != null && (sparseArray18.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray18.get(R.id.tag_is_top_question)).booleanValue()) {
                    ql9.u(2);
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!this.a.u) {
                    TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                    if (!(tbRichTextView.getTag() instanceof SparseArray)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (!(obj instanceof qba)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    qba qbaVar8 = (qba) obj;
                    if (this.a.z0 != null && this.a.z0.r1() != null && this.a.M5().v1() != null && qbaVar8.r() != null && qbaVar8.I() != 1) {
                        if (!this.a.checkUpIsLogin()) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        } else if (qbaVar8.A0()) {
                            return;
                        } else {
                            if (this.a.M5().w1() != null) {
                                this.a.M5().w1().g();
                            }
                            je9 je9Var2 = new je9();
                            je9Var2.v(this.a.z0.r1().k());
                            je9Var2.z(this.a.z0.r1().O());
                            je9Var2.x(qbaVar8);
                            this.a.M5().v1().j0(je9Var2);
                            this.a.M5().v1().setPostId(qbaVar8.S());
                            this.a.k6(view2, qbaVar8.r().getUserId(), "", qbaVar8);
                            TiebaStatic.log("c11743");
                            ql9.b(this.a.z0.r1(), qbaVar8, qbaVar8.e0, 8, 1);
                            if (this.a.W0 != null) {
                                this.a.H0.r3(this.a.W0.z());
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
            public final /* synthetic */ h1 c;

            public a(h1 h1Var, u45 u45Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {h1Var, u45Var, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = h1Var;
                this.a = u45Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.z0.I1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.tieba.w45.f
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void K0(w45 w45Var, int i, View view2) {
                boolean j3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, w45Var, i, view2) == null) {
                    this.a.dismiss();
                    int i2 = 3;
                    int i3 = 0;
                    if (this.c.a.z0.I1() != 1 || i != 1) {
                        if (this.c.a.z0.I1() == 2 && i == 0) {
                            i2 = 1;
                        } else if (this.c.a.z0.I1() == 3 && i != 2) {
                            i2 = 2;
                        } else if (i == 2) {
                        }
                        TiebaStatic.log("c12097");
                        StatisticItem statisticItem = new StatisticItem("c12097");
                        if (this.b.getId() != R.id.obfuscated_res_0x7f091b1e) {
                            i3 = 1;
                        }
                        TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                        if (this.c.a.z0.r1().f != null && this.c.a.z0.r1().f.size() > i) {
                            i = this.c.a.z0.r1().f.get(i).sort_type.intValue();
                        }
                        j3 = this.c.a.z0.j3(i);
                        this.b.setTag(Integer.valueOf(this.c.a.z0.H1()));
                        if (j3) {
                            return;
                        }
                        this.c.a.h = true;
                        this.c.a.H0.B3(true);
                        return;
                    }
                    i2 = 0;
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem2 = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f091b1e) {
                    }
                    TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.z0.r1().f != null) {
                        i = this.c.a.z0.r1().f.get(i).sort_type.intValue();
                    }
                    j3 = this.c.a.z0.j3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.z0.H1()));
                    if (j3) {
                    }
                }
            }
        }

        public h1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
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
    public class k1 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ k1 b;

            public a(k1 k1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = k1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.H0 != null && this.a != null) {
                    this.b.a.H0.V2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements m45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(k1 k1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k1Var};
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
            public final /* synthetic */ k1 a;

            public c(k1 k1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {k1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = k1Var;
            }

            @Override // com.baidu.tieba.m45.e
            public void onClick(m45 m45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                    m45Var.dismiss();
                    dk9.a(this.a.a.getPageContext());
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
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
                    if (this.a.z0.r1() != null) {
                        statisticItem.param("fid", this.a.z0.r1().l());
                    }
                    statisticItem.param("tid", this.a.z0.K1());
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
                this.a.H0.K3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (this.a.F0 != null) {
                    this.a.F0.getData(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    SafeHandler.getInst().postDelayed(this.a.W1, 300000L);
                }
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.W0 != null && (this.a.W0.y() || this.a.W0.A())) {
                            this.a.W0.w(false, postWriteCallBackData);
                        }
                        this.a.L0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.Y0;
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
                        this.a.H0.d2(this.a.z0.r1());
                    }
                } else if (this.a.z0.U0()) {
                    sd9 r1 = this.a.z0.r1();
                    if (r1 != null && r1.O() != null && r1.O().getAuthor() != null && (userId = r1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.z0.g3()) {
                        this.a.H0.M3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.z0.g3()) {
                    this.a.H0.M3();
                }
                if (this.a.z0.Y0()) {
                    ql9.r("c10369", this.a.z0.K1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    SafeHandler.getInst().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.z0 != null) {
                    Context context = this.a.getContext();
                    sd9 r12 = this.a.z0.r1();
                    String forumId = this.a.z0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    ai9.a(context, r12, forumId, z2, this.a.z0.w1(), this.a.z0.z1(), this.a.z0.y1(), this.a.z0.x1(), this.a.z0.D1(), this.a.z0.E1());
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
    public class l1 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ l1 b;

            public a(l1 l1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = l1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.H0 != null && this.a != null) {
                    this.b.a.H0.V2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements m45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(l1 l1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l1Var};
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
            public final /* synthetic */ l1 a;

            public c(l1 l1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = l1Var;
            }

            @Override // com.baidu.tieba.m45.e
            public void onClick(m45 m45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                    m45Var.dismiss();
                    dk9.a(this.a.a.getPageContext());
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, jd5 jd5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, jd5Var, writeData, antiData}) == null) {
                if (!bi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.z0 != null && this.a.z0.r1() != null) {
                        statisticItem.param("fid", this.a.z0.r1().l());
                    }
                    if (this.a.z0 != null) {
                        statisticItem.param("tid", this.a.z0.K1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.D5()) {
                        this.a.N6(false);
                        yb9.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f146f));
                    }
                    ei9 ei9Var = this.a.L0;
                    if (ei9Var != null) {
                        ei9Var.d();
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
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.Y0;
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
                    if (pbFragment.L0 != null) {
                        if (pbFragment.H0 != null && this.a.H0.w1() != null && this.a.H0.w1().f() != null && this.a.H0.w1().f().z()) {
                            this.a.H0.w1().f().w(postWriteCallBackData);
                        }
                        this.a.L0.l(postWriteCallBackData);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements nw6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.tieba.nw6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    ye9.d();
                } else {
                    ye9.c();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements GetSugMatchWordsModel.b {
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

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.b
        public void onSuccess(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && !ListUtils.isEmpty(list) && this.a.H0 != null) {
                this.a.H0.R3(list);
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
    public class a1 implements e3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.e3
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
                String valueOf = String.valueOf(this.a.z0.r1().V().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.z0.r1().k().getId(), this.a.z0.r1().k().getName(), this.a.z0.r1().O().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a2 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.C5()) {
                    this.a.a.finish();
                }
                if (this.a.z0.p2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.H0.N0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a3 implements mw6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.mw6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.mw6.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
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
            this.b = pbFragment;
            this.a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070282);
        }

        @Override // com.baidu.tieba.mw6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.H0 != null && this.b.e != null) {
                this.b.e.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.e.l();
                }
                if (this.b.C5()) {
                    this.b.H0.L1();
                    this.b.H0.k3();
                }
            }
        }

        @Override // com.baidu.tieba.mw6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.H0 != null && this.b.e != null) {
                this.b.H0.s4();
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
    public class b implements qg9.b {
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

        @Override // com.baidu.tieba.qg9.b
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
                    this.a.H0.D0(str);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 implements PraiseModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public b0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
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
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.P1 != null && str != null) {
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
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || this.a.P1 == null) {
                return;
            }
            sd9 r1 = this.a.z0.r1();
            if (r1.O().getPraise().getIsLike() == 1) {
                this.a.u7(0);
            } else {
                this.a.u7(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, r1.O()));
        }
    }

    /* loaded from: classes7.dex */
    public class b1 implements w45.f {
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

        @Override // com.baidu.tieba.w45.f
        public void K0(w45 w45Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, w45Var, i, view2) == null) {
                if (this.a.M0 != null) {
                    this.a.M0.dismiss();
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
                                            if (this.a.k1 != null && !TextUtils.isEmpty(this.a.l1)) {
                                                if (this.a.n1 != null) {
                                                    rl5.a aVar = new rl5.a();
                                                    aVar.a = this.a.l1;
                                                    String str = "";
                                                    if (this.a.n1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.n1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.Y4();
                                                }
                                                this.a.k1 = null;
                                                this.a.l1 = null;
                                                return;
                                            }
                                            return;
                                        case 2:
                                            if (this.a.k1 != null && !TextUtils.isEmpty(this.a.l1)) {
                                                if (this.a.X0 == null) {
                                                    this.a.X0 = new PermissionJudgePolicy();
                                                }
                                                this.a.X0.clearRequestPermissionList();
                                                this.a.X0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                if (this.a.X0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                                    return;
                                                }
                                                if (this.a.j1 == null) {
                                                    PbFragment pbFragment = this.a;
                                                    pbFragment.j1 = new gi9(pbFragment.getPageContext());
                                                }
                                                this.a.j1.b(this.a.l1, this.a.k1.getImageByte());
                                                this.a.k1 = null;
                                                this.a.l1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            qba qbaVar = this.a.C2;
                                            if (qbaVar != null) {
                                                qbaVar.P0();
                                                this.a.C2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.o6(view2);
                                            if (this.a.z0.r1().O() != null && this.a.z0.r1().O().getAuthor() != null && this.a.z0.r1().O().getAuthor().getUserId() != null && this.a.B0 != null) {
                                                int v = ai9.v(this.a.z0.r1());
                                                ThreadData O = this.a.z0.r1().O();
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
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.z0.b).param("obj_locate", 2).param("obj_id", this.a.z0.r1().O().getAuthor().getUserId()).param("obj_type", !this.a.B0.e()).param("obj_source", v).param("obj_param1", i2));
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
                                                        this.a.H0.P2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, G);
                                                        return;
                                                    } else {
                                                        this.a.W6(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.H0.N2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
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
                                                this.a.H0.S2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.H0.N2(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            qba qbaVar2 = (qba) sparseArray.get(R.id.tag_clip_board);
                                            if (qbaVar2.o() == null) {
                                                return;
                                            }
                                            this.a.g5(qbaVar2.o());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.z0 != null && this.a.z0.r1() != null) {
                                                this.a.a.T1(aka.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.z0 != null && this.a.z0.r1() != null) {
                                    this.a.H0.S4(true);
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
    public class b2 implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.x2 && this.a.C5()) {
                    this.a.h6();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (this.a.H0 != null) {
                    this.a.H0.l3();
                }
                if (!this.a.f0 && this.a.H0 != null && this.a.H0.v0() && this.a.z0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.z0.K1());
                    statisticItem.param("fid", this.a.z0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.z0.W0()) {
                        i = 4;
                    } else if (this.a.z0.X0()) {
                        i = 3;
                    } else if (this.a.z0.Z0()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.f0 = true;
                }
                if (this.a.z0.n2(false)) {
                    this.a.H0.N3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (this.a.z0.r1() != null) {
                    this.a.H0.f3();
                }
                this.a.x2 = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b3 implements jh9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.jh9.b
        public void onSuccess(List<qba> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
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

        @Override // com.baidu.tieba.jh9.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.H0.D4(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements m45.e {
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

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    m45Var.dismiss();
                    ((TbPageContext) this.a.f1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                m45Var.dismiss();
                dk9.a(this.a.getPageContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements PbInterviewStatusView.f {
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

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void callback(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.H0.z4(!this.a.N);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c1 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PbFragment d;

        public c1(PbFragment pbFragment, SparseArray sparseArray, int i, boolean z) {
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
    public class c2 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.z0 != null) {
                this.a.z0.loadData();
            }
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
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements ij9.h {
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

        @Override // com.baidu.tieba.ij9.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.P6(z);
                if (this.a.H0.j1() != null && z) {
                    this.a.H0.z4(false);
                }
                this.a.H0.E2(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d1 implements m45.e {
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

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<bi9> a;
        public WeakReference<PbFragment> b;

        public d3(bi9 bi9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(bi9Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                bi9 bi9Var = this.a.get();
                if (bi9Var != null) {
                    bi9Var.K1();
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
                        rw7.d();
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
    public class e0 implements w45.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ PbFragment e;

        public e0(PbFragment pbFragment, SparseArray sparseArray, boolean z, String str, String str2) {
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
                if (this.e.M0 != null) {
                    this.e.M0.dismiss();
                }
                if (i == 0) {
                    this.e.H0.N2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.h1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.h1);
                    this.e.i7(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e1 implements SortSwitchButton.f {
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

        public e1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
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
                this.a.H0.F0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.z0 != null && !this.a.z0.isLoading) {
                    this.a.m7();
                    this.a.H0.M3();
                    z = true;
                    if (this.a.z0.r1() != null && this.a.z0.r1().f != null && this.a.z0.r1().f.size() > i) {
                        int intValue = this.a.z0.r1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.z0.L1()).param("fid", this.a.z0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.z0.j3(intValue)) {
                            this.a.h = true;
                            this.a.H0.B3(true);
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e2 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ m45 c;
        public final /* synthetic */ PbFragment d;

        public e2(PbFragment pbFragment, MarkData markData, MarkData markData2, m45 m45Var) {
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
                if (this.d.B0 != null) {
                    if (this.d.B0.e()) {
                        this.d.B0.d();
                        this.d.B0.h(false);
                    }
                    this.d.B0.i(this.a);
                    this.d.B0.h(true);
                    this.d.B0.a();
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
    public class f implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ PbFragment b;

        public f(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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
                this.b.H0.k4();
                MessageManager.getInstance().sendMessage(this.a);
                m45Var.dismiss();
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                if (updateAttentionMessage.getData().blockData != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() == this.a.getUniqueId() && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().blockData, PbFragment.S2) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                        return;
                    }
                    return;
                }
                if (updateAttentionMessage.getData().isSucc) {
                    if (this.a.v5().r() != null && this.a.v5().r().getGodUserData() != null) {
                        this.a.v5().r().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.z0 != null && this.a.z0.r1() != null && this.a.z0.r1().O() != null && this.a.z0.r1().O().getAuthor() != null) {
                        this.a.z0.r1().O().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
                if (updateAttentionMessage.isAttention()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921760, 10));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f2 implements mj5 {
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

        @Override // com.baidu.tieba.mj5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ei9 ei9Var = this.a.L0;
                if (ei9Var != null && ei9Var.g() != null && this.a.L0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.L0.g().c());
                    if (this.a.H0 != null && this.a.H0.w1() != null && this.a.H0.w1().f() != null && this.a.H0.w1().f().z()) {
                        this.a.H0.w1().f().w(this.a.L0.h());
                    }
                    this.a.L0.b(true);
                    return true;
                }
                return !this.a.f5(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements m45.e {
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

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g0 extends ResponsedEventListener<TipEvent> {
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
    public class g2 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ m45 b;
        public final /* synthetic */ PbFragment c;

        public g2(PbFragment pbFragment, MarkData markData, m45 m45Var) {
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
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.z0 != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.W0 != null) {
                    this.a.H0.r3(this.a.W0.z());
                }
                this.a.H0.j3();
                this.a.H0.F0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h0 extends ResponsedEventListener<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public h0(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
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
                if (this.a.H0 != null && topToastEvent != null) {
                    new BdTopToast(this.a.getContext()).setIcon(topToastEvent.isSuccess()).setContent(topToastEvent.getContent()).show(this.a.H0.E1());
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ m45 b;
        public final /* synthetic */ PbFragment c;

        public h2(PbFragment pbFragment, MarkData markData, m45 m45Var) {
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
                if (this.c.H0 != null && this.c.H0.E1() != null) {
                    this.c.H0.E1().getLocationOnScreen(iArr);
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
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PbFragment pbFragment, int i) {
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
            this.a.z0.m3((UserPendantData) customResponsedMessage.getData());
            if (this.a.H0 != null && this.a.z0 != null) {
                this.a.H0.d3(this.a.z0.r1(), this.a.z0.J1(), this.a.z0.B1(), this.a.H0.A1());
            }
            if (this.a.H0 != null && this.a.H0.T0() != null) {
                this.a.H0.T0().f0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;
        public final /* synthetic */ PbFragment b;

        public i0(PbFragment pbFragment, Intent intent) {
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
            bi9 bi9Var = this.b.H0;
            bi9Var.P3("@" + this.a.getStringExtra("big_pic_type") + " ");
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || this.a.z0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.z0.b)) {
                return;
            }
            this.a.f7((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes7.dex */
    public class i2 implements bg<ImageView> {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.H0 == null) {
                    return;
                }
                if (booleanValue) {
                    this.a.H0.u4();
                } else {
                    this.a.H0.M1();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
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

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    if (this.a.W0 != null) {
                        this.a.W0.H(null, null);
                    }
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.H0 != null && this.a.H0.w1() != null && this.a.H0.w1().f() != null) {
                    this.a.H0.w1().f().I();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j1 implements nj5 {
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

        @Override // com.baidu.tieba.nj5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j2 implements bg<GifView> {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.W0 != null) {
                this.a.H0.r3(this.a.W0.z());
            }
            this.a.H0.c4(false);
        }
    }

    /* loaded from: classes7.dex */
    public class k0 extends h9 {
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

        @Override // com.baidu.tieba.h9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k2 implements bg<TiebaPlusRecommendCard> {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                ac9 ac9Var = (ac9) customResponsedMessage.getData();
                int type = ac9Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (ac9Var.a() == null) {
                                this.a.D6(false, null);
                                return;
                            } else {
                                this.a.D6(true, (MarkData) ac9Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.q5((ForumManageModel.b) ac9Var.a(), false);
                    return;
                }
                this.a.E6((je9) ac9Var.a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 implements PbFirstFloorDoubleClickAnimation.d {
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

        @Override // com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l2 implements bg<View> {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.H0 != null && this.a.H0.T0() != null) {
                this.a.H0.T0().f0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements ze9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.ze9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

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

        @Override // com.baidu.tieba.ze9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091efe) {
                        if (this.a.I6(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09015c) {
                        if (motionEvent != null && motionEvent.getAction() == 1) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof qba)) {
                                return false;
                            }
                            qba qbaVar = (qba) obj;
                            if (qbaVar.getType() != qba.Z0 && !TextUtils.isEmpty(qbaVar.u()) && b05.c().g()) {
                                return this.a.q6(qbaVar);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091aa4) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.k7((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.H0.i2() && view2.getId() == R.id.obfuscated_res_0x7f091ac6) {
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
                if (this.a.W0 != null) {
                    this.a.H0.r3(this.a.W0.z());
                }
                this.a.H0.j3();
                this.a.H0.F0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.ze9.a
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
    public class m1 extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m1(PbFragment pbFragment, int i, int i2) {
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
                        if (this.a.H0 != null && (C1 = this.a.H0.C1()) != null && this.a.H0.m1() != null) {
                            this.a.H0.m1().removeHeaderView(C1);
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
    public class m2 implements bg<RelativeLayout> {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof o06.a)) {
                o06.a aVar = (o06.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.Q5(aVar.b);
                }
                o06.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements Handler.Callback {
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

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.a.z0 != null && this.a.z0.c1()) {
                    this.a.l6();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class n1 implements PbModel.h {
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

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(sd9 sd9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sd9Var) == null) {
                this.a.H0.d2(sd9Var);
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
            tr5 tr5Var = new tr5(i, z, responsedMessage, this.a.p, this.a.o, this.a.m, z2, 0L, 0L, j4);
            this.a.o = 0L;
            this.a.p = 0L;
            tr5Var.c();
            if (z2) {
                j3 = j4;
                tr5Var.B = j3;
                tr5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.z0 != null && this.a.z0.r1() != null && this.a.z0.r1().O() != null) {
                int threadType = this.a.z0.r1().O().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.M, "from_personalize")) {
                        pr5 pr5Var = new pr5();
                        pr5Var.F = 1;
                        pr5Var.a(1005);
                        pr5Var.D = j3;
                        pr5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.M, "from_frs")) {
                        tr5 tr5Var2 = new tr5();
                        tr5Var2.a(1000);
                        tr5Var2.D = j3;
                        tr5Var2.d(threadType);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, sd9 sd9Var, String str, int i4) {
            boolean z2;
            th5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), sd9Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907b1));
                }
                if (z && sd9Var != null && sd9Var.Y() == null && ListUtils.getCount(sd9Var.F()) < 1) {
                    this.a.z0.d3(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                    if (this.a.H0 != null) {
                        this.a.H0.v4();
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
                if (this.a.H0 == null) {
                    return;
                }
                this.a.H0.L3();
                if (sd9Var == null || !sd9Var.s0()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.H0.E1());
                }
                this.a.H0.M1();
                int i5 = 0;
                if (this.a.J) {
                    this.a.H0.G1();
                } else if (!this.a.H0.h2()) {
                    this.a.H0.c4(false);
                }
                if (this.a.h) {
                    this.a.h = false;
                }
                if (i4 == 0 && sd9Var != null) {
                    this.a.P0 = true;
                }
                if (sd9Var != null) {
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.hideNetRefreshView(pbFragment2.H0.E1());
                    this.a.H0.V3();
                }
                ArrayList<qba> arrayList = null;
                String x1 = null;
                arrayList = null;
                if (z && sd9Var != null) {
                    ThreadData O = sd9Var.O();
                    if (O != null && O.isUgcThreadType()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = this.a;
                        pbFragment3.Q6(pbFragment3.V0);
                    }
                    this.a.H0.w1().r(sd9Var);
                    this.a.H0.j4();
                    if (O != null && O.getCartoonThreadData() != null) {
                        this.a.t7(O.getCartoonThreadData());
                    }
                    if (this.a.W0 != null) {
                        this.a.H0.r3(this.a.W0.z());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(sd9Var.V().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(sd9Var.V().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(sd9Var.V().getBimg_end_time());
                    if (sd9Var.F() != null && sd9Var.F().size() >= 1 && sd9Var.F().get(0) != null) {
                        this.a.z0.P2(sd9Var.F().get(0).S());
                    } else if (sd9Var.Y() != null) {
                        this.a.z0.P2(sd9Var.Y().S());
                    }
                    if (this.a.W0 != null) {
                        this.a.W0.I(sd9Var.c());
                        this.a.W0.J(sd9Var.k(), sd9Var.V());
                        this.a.W0.l0(O);
                        this.a.W0.K(this.a.z0.T0(), this.a.z0.K1(), this.a.z0.P0());
                        if (O != null) {
                            this.a.W0.a0(O.isMutiForumThread());
                        }
                    }
                    if (this.a.B0 != null) {
                        this.a.B0.h(sd9Var.q());
                    }
                    PbFragment pbFragment4 = this.a;
                    if (sd9Var.r() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    pbFragment4.q = z2;
                    if (sd9Var.j0()) {
                        this.a.q = true;
                    }
                    this.a.H0.s3(this.a.q);
                    if (this.a.u0.f.size() > 0) {
                        sd9Var.S0(this.a.u0.f);
                    }
                    this.a.H0.n4(sd9Var, i2, i3, this.a.z0.J1(), i4, this.a.z0.a1());
                    this.a.H0.C4(sd9Var, this.a.z0.J1());
                    this.a.H0.K4(this.a.z0.U0());
                    AntiData c = sd9Var.c();
                    if (c != null) {
                        this.a.x = c.getVoice_message();
                        if (!StringUtils.isNull(this.a.x) && this.a.W0 != null && this.a.W0.b() != null && (o = this.a.W0.b().o(6)) != null && !TextUtils.isEmpty(this.a.x)) {
                            ((View) o).setOnClickListener(this.a.G1);
                        }
                    }
                    if (!this.a.X && !ListUtils.isEmpty(this.a.z0.r1().F()) && !this.a.z0.e2()) {
                        this.a.X = true;
                        this.a.a5(false);
                    }
                    if (!TextUtils.isEmpty(this.a.S0)) {
                        PbFragment pbFragment5 = this.a;
                        ai9.G(pbFragment5, pbFragment5.z0.q1(), this.a.S0);
                        this.a.S0 = null;
                    } else if (this.a.R0) {
                        this.a.R0 = false;
                        ai9.F(this.a);
                    } else if (this.a.T0) {
                        this.a.T0 = false;
                        cj9.j(this.a.getListView());
                    } else if (!TextUtils.isEmpty(this.a.z0.h1())) {
                        cj9.f(this.a.getListView(), this.a.z0.h1());
                        this.a.z0.l2();
                    } else {
                        this.a.H0.i4();
                    }
                    this.a.z0.m2(sd9Var.k(), this.a.M1);
                    this.a.z0.q2(this.a.O1);
                    if (this.a.Y0 != null && O != null && O.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(O.getAuthor());
                        this.a.Y0.setLikeUserData(attentionHostData);
                    }
                    if (this.a.z0 != null && this.a.z0.a2()) {
                        x1 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.H0 != null) {
                        x1 = this.a.H0.x1();
                    }
                    if (this.a.W0 != null && !StringUtils.isNull(x1)) {
                        this.a.W0.d0(TbSingleton.getInstance().getAdVertiComment(sd9Var.q0(), sd9Var.r0(), x1));
                    }
                    if (!this.a.P0 && ((i2 == 1 || i2 == 2) && this.a.H0 != null)) {
                        this.a.H0.Q0();
                    }
                } else if (str != null) {
                    if (!this.a.P0 && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6 || i2 == 9) {
                            if (i == 4) {
                                if (this.a.z0.H0() != null && !StringUtils.isNull(this.a.z0.H0().c)) {
                                    this.a.H0.M4(this.a.z0.H0());
                                } else {
                                    PbFragment pbFragment6 = this.a;
                                    pbFragment6.showNetRefreshView(pbFragment6.H0.E1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    y3a.a("pb", false);
                                    PbFragment pbFragment7 = this.a;
                                    pbFragment7.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
                                }
                            } else {
                                PbFragment pbFragment8 = this.a;
                                pbFragment8.showNetRefreshView(pbFragment8.H0.E1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                y3a.a("pb", false);
                                PbFragment pbFragment9 = this.a;
                                pbFragment9.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment9.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
                            }
                            this.a.H0.G1();
                            this.a.H0.F1();
                        }
                    } else {
                        this.a.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.z0.K1());
                            jSONObject.put("fid", this.a.z0.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                        rr6.b().b(new td5(this.a.z0.K1()));
                    }
                    if (i != 0) {
                        EnterForePvThread enterForePvThread = new EnterForePvThread();
                        enterForePvThread.setOpType("2");
                        enterForePvThread.start();
                    }
                    if (i != -1) {
                        if (this.a.z0 != null && this.a.z0.r1() != null) {
                            arrayList = this.a.z0.r1().F();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).I() != 1)) {
                            this.a.H0.n3(this.a.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (this.a.e6()) {
                                this.a.H0.o3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fe4));
                            } else {
                                this.a.H0.o3(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fe5));
                            }
                            this.a.H0.d2(this.a.z0.r1());
                        }
                    } else {
                        this.a.H0.n3("");
                    }
                    this.a.H0.M0();
                }
                if (sd9Var != null && sd9Var.m && this.a.m == 0) {
                    this.a.m = System.currentTimeMillis() - this.a.l;
                }
                if (this.a.a instanceof PbActivity) {
                    PbActivity pbActivity = (PbActivity) this.a.a;
                    if (sd9Var != null) {
                        i5 = sd9Var.f();
                    }
                    pbActivity.d2(i5, this.a.H0);
                }
                if (this.a.z0 != null && this.a.z0.r1() != null) {
                    this.a.z0.r1();
                }
            }
        }

        public final void d() {
            Bundle extras;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.a.z0 == null) {
                return;
            }
            if (this.a.W0 != null && this.a.W0.t) {
                return;
            }
            pj5 pj5Var = new pj5();
            this.a.Q6(pj5Var);
            PbFragment pbFragment = this.a;
            pbFragment.W0 = (qj5) pj5Var.a(pbFragment.getContext());
            this.a.W0.X(this.a.a.getPageContext());
            this.a.W0.g0(this.a.l2);
            this.a.W0.h0(this.a.a1);
            qj5 qj5Var = this.a.W0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
            if (this.a.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.a.getIntent().getExtras();
            }
            qj5Var.B(pageContext, extras);
            this.a.W0.b().F(true);
            this.a.H0.m3(this.a.W0.b());
            if (!this.a.z0.e1()) {
                this.a.W0.q(this.a.z0.K1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.W0.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.z0.a2()) {
                this.a.W0.d0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.H0 != null) {
                this.a.W0.d0(this.a.H0.x1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n2 implements bg<ItemCardView> {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.f) {
                return;
            }
            this.a.j7();
        }
    }

    /* loaded from: classes7.dex */
    public class o0 implements n45.c {
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

        @Override // com.baidu.tieba.n45.c
        public void a(n45 n45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n45Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.O0 = pbFragment.O0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.O0);
                    new fg9(this.a.z0.K1(), this.a.O0, "1").start();
                    n45Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.O0 = pbFragment2.O0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.O0);
                    new fg9(this.a.z0.K1(), this.a.O0, "2").start();
                    n45Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.O0 = pbFragment3.O0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.O0);
                    n45Var.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o1(PbFragment pbFragment, int i) {
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
    public class o2 implements TbRichTextView.z {
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v24, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            kg9 T0;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.H0.B2((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.z0.K1());
                    statisticItem.param("fid", this.a.z0.getForumId());
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
                    if (this.a.z0.G.j0()) {
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
                        builder.setData(arrayList).setIndex(i3).setIsCDN(false).setPostId(eVar.f).setIsReserve(this.a.z0.C1()).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false).setIsSeeHost(this.a.e6()).setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.z0 != null) {
                            builder.setFromForumId(this.a.z0.getFromForumId());
                            if (this.a.z0.r1() != null) {
                                builder.setThreadData(this.a.z0.r1().O());
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
                        builder2.setData(arrayList2).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.a.get(0)).setIsReserve(this.a.z0.C1()).setAssistUrls(concurrentHashMap2).setNeedBroadCaset(false).setIsSeeHost(this.a.e6()).setPostId(eVar.f).setBjhPostId(eVar.f).setIsCanDrag(false);
                        if (this.a.z0 != null) {
                            builder2.setFromForumId(this.a.z0.getFromForumId());
                            if (this.a.z0.r1() != null) {
                                builder2.setThreadData(this.a.z0.r1().O());
                            }
                        }
                        ImageViewerConfig bulid2 = builder2.bulid(this.a.getPageContext().getPageActivity());
                        bulid2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, bulid2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText v7 = this.a.v7(str, i);
                        if (v7 != null && this.a.z2 >= 0 && this.a.z2 < v7.P().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = td9.a(v7.P().get(this.a.z2));
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
                            if (v7.getPostId() != 0 && (T0 = this.a.H0.T0()) != null) {
                                ArrayList<ym> v = T0.v();
                                if (ListUtils.getCount(v) > 0) {
                                    Iterator<ym> it = v.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        ym next = it.next();
                                        if ((next instanceof qba) && v7.getPostId() == JavaTypesHelper.toLong(((qba) next).S(), 0L)) {
                                            int i9 = 8;
                                            if (v7.getPostId() == JavaTypesHelper.toLong(this.a.z0.P0(), 0L)) {
                                                i9 = 1;
                                            }
                                            ql9.b(this.a.z0.r1(), (qba) next, ((qba) next).e0, i9, 3);
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
                            builder3.setData(arrayList3).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.i).setIsReserve(this.a.z0.C1()).setAssistUrls(concurrentHashMap3).setNeedBroadCaset(false).setIsSeeHost(this.a.e6()).setPostId(eVar.f).setBjhPostId(eVar.f).setSrcRectInScreen(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.z0 != null) {
                                builder3.setFromForumId(this.a.z0.getFromForumId());
                                if (this.a.z0.r1() != null) {
                                    builder3.setThreadData(this.a.z0.r1().O());
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                new BdTopToast(this.a.getContext()).setIcon(false).setContent(this.a.getString(R.string.novel_thread_mask_click_tip)).show((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p1(PbFragment pbFragment, int i, boolean z) {
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
                if (this.a.H0 != null) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.H0.E1());
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
    public class p2 implements n45.c {
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

        @Override // com.baidu.tieba.n45.c
        public void a(n45 n45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n45Var, i, view2) == null) {
                if (n45Var != null) {
                    n45Var.e();
                }
                PbFragment pbFragment = this.a;
                qba qbaVar = pbFragment.C2;
                if (qbaVar != null) {
                    if (i == 0) {
                        qbaVar.P0();
                        this.a.C2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.p6(pbFragment2.C2);
                    }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921658) {
                int error = customResponsedMessage.getError();
                if (!(customResponsedMessage.getData() instanceof Boolean)) {
                    return;
                }
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (error != 0 || !booleanValue || !TbadkCoreApplication.isLogin() || this.a.B0 == null || this.a.B0.e()) {
                    return;
                }
                this.a.n6();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q0(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.h1) {
                this.a.H0.K1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                sd9 r1 = this.a.z0.r1();
                if (r1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    r1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.g1.d(this.a.f1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.f1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.h7(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (bi.isEmpty(errorString2)) {
                        errorString2 = this.a.f1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.g1.c(errorString2);
                } else {
                    this.a.a7();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q1 implements bw4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.baidu.tieba.bw4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.H0.L3();
                if (z) {
                    if (this.a.B0 != null) {
                        this.a.B0.h(z2);
                    }
                    this.a.z0.f3(z2);
                    if (!this.a.z0.c1()) {
                        this.a.H0.d2(this.a.z0.r1());
                    } else {
                        this.a.l6();
                    }
                    if (z2) {
                        boolean p0 = this.a.z0.r1().p0();
                        if (this.a.B0 != null && !p0) {
                            if (this.a.B0.f() != null && this.a.z0 != null && this.a.z0.r1() != null && this.a.z0.r1().O() != null && this.a.z0.r1().O().getAuthor() != null) {
                                MarkData f = this.a.B0.f();
                                MetaData author = this.a.z0.r1().O().getAuthor();
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
    public class q2 implements c3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.c3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.H0 != null && this.a.H0.w1() != null) {
                    zg9 w1 = this.a.H0.w1();
                    if (w1.j()) {
                        w1.h();
                        return true;
                    }
                }
                if (this.a.H0 != null && this.a.H0.r2()) {
                    this.a.H0.O1();
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class r implements TiePlusEventController.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public r(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
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
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r0(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.h1) {
                this.a.H0.K1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.g1.d(this.a.f1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (bi.isEmpty(muteMessage)) {
                    muteMessage = this.a.f1.getResources().getString(R.string.un_mute_fail);
                }
                this.a.g1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r1 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public r1(PbFragment pbFragment, MetaData metaData) {
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
    public class r2 implements n45.c {
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

        @Override // com.baidu.tieba.n45.c
        public void a(n45 n45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n45Var, i, view2) == null) {
                if (n45Var != null) {
                    n45Var.e();
                }
                if (this.a.k1 != null && !TextUtils.isEmpty(this.a.l1)) {
                    if (i == 0) {
                        if (this.a.n1 != null) {
                            rl5.a aVar = new rl5.a();
                            aVar.a = this.a.l1;
                            String str = "";
                            if (this.a.n1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.n1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        } else {
                            this.a.Y4();
                        }
                    } else if (i == 1) {
                        if (this.a.X0 == null) {
                            this.a.X0 = new PermissionJudgePolicy();
                        }
                        this.a.X0.clearRequestPermissionList();
                        this.a.X0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.X0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.j1 == null) {
                            PbFragment pbFragment = this.a;
                            pbFragment.j1 = new gi9(pbFragment.getPageContext());
                        }
                        this.a.j1.b(this.a.l1, this.a.k1.getImageByte());
                    }
                    this.a.k1 = null;
                    this.a.l1 = null;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements View.OnClickListener {
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
    public class s1 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public s1(PbFragment pbFragment, MetaData metaData) {
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
                this.b.D0.i(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.z0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s2 implements AdapterView.OnItemClickListener {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.z0 == null || this.a.z0.A1() == i + 1) {
                return;
            }
            this.a.L6(ai9.p(i));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d25)) {
                d25 d25Var = (d25) customResponsedMessage.getData();
                v25.a aVar = new v25.a();
                int i = d25Var.a;
                String str = d25Var.b;
                aVar.a = d25Var.d;
                sd9 r1 = this.a.z0.r1();
                if (r1 == null) {
                    return;
                }
                if (this.a.z0.T0() != null && this.a.z0.T0().getUserIdLong() == d25Var.p) {
                    this.a.H0.c3(d25Var.l, this.a.z0.r1(), this.a.z0.J1(), this.a.z0.B1());
                }
                if (r1.F() != null && r1.F().size() >= 1 && r1.F().get(0) != null) {
                    long j = JavaTypesHelper.toLong(r1.F().get(0).S(), 0L);
                    long j2 = JavaTypesHelper.toLong(this.a.z0.K1(), 0L);
                    if (j == d25Var.n && j2 == d25Var.m) {
                        v25 Q = r1.F().get(0).Q();
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
                        r1.F().get(0).W0(Q);
                        this.a.H0.T0().f0();
                    }
                }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof dka) && customResponsedMessage.getOrginalMessage().getTag() == this.a.h1) {
                dka dkaVar = (dka) customResponsedMessage.getData();
                this.a.H0.K1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.e1;
                DataRes dataRes = dkaVar.a;
                boolean z = false;
                if (dkaVar.c == 0 && dataRes != null) {
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
                        this.a.H0.R2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.b7(z, sparseArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t1 implements AbsListView.OnScrollListener {
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

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<qba> F;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.z0 != null && this.a.z0.r1() != null && this.a.H0 != null && this.a.H0.T0() != null) {
                this.a.H0.K2(absListView, i, i2, i3);
                if (this.a.e != null) {
                    this.a.e.q(absListView, i, i2, i3);
                }
                if (this.a.z0.f2() && (F = this.a.z0.r1().F()) != null && !F.isEmpty()) {
                    int y = ((i + i2) - this.a.H0.T0().y()) - 1;
                    sd9 r1 = this.a.z0.r1();
                    if (r1 == null) {
                        return;
                    }
                    if (r1.C() != null && r1.C().z1()) {
                        y--;
                    }
                    if (r1.D() != null && r1.D().z1()) {
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
                if (!ai9.B(this.a.d1) && ai9.B(i)) {
                    if (this.a.H0 != null) {
                        this.a.r0 = true;
                        this.a.H0.F0();
                        if (this.a.W0 != null && !this.a.H0.e2()) {
                            this.a.H0.r3(this.a.W0.z());
                        }
                        if (!this.a.J) {
                            this.a.r0 = true;
                            this.a.H0.j3();
                        }
                    }
                    if (!this.a.r) {
                        this.a.r = true;
                    }
                }
                if (this.a.H0 != null) {
                    this.a.H0.L2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.s == null) {
                    this.a.s = new nr5();
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
                this.a.d1 = i;
                if (i == 0) {
                    t9a.g().h(this.a.getUniqueId(), true);
                    this.a.a5(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t2 implements w45.d {
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

        @Override // com.baidu.tieba.w45.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.N0 != null) {
                this.a.N0.r(yj9.g(this.a.C2));
                ArrayList arrayList = new ArrayList();
                for (v45 v45Var : this.a.N0.g()) {
                    if (v45Var instanceof s45) {
                        arrayList.add((s45) v45Var);
                    }
                }
                yj9.e(arrayList);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof v16)) {
                v16 v16Var = (v16) customResponsedMessage.getData();
                sd9 r1 = this.a.z0.r1();
                if (r1 == null) {
                    return;
                }
                if (this.a.z0.r1() != null && this.a.z0.r1().X().r() != null && this.a.z0.r1().X().r().getPortrait() != null && this.a.z0.r1().X().r().getPortrait().equals(v16Var.a)) {
                    if (this.a.z0.r1().X().r().getUserWorldCupData() != null) {
                        this.a.z0.r1().X().r().getUserWorldCupData().d(v16Var.b);
                    }
                    this.a.H0.d3(this.a.z0.r1(), this.a.z0.J1(), this.a.z0.B1(), this.a.H0.A1());
                }
                if (r1.F() != null && r1.F().size() >= 0) {
                    Iterator<qba> it = r1.F().iterator();
                    while (it.hasNext()) {
                        qba next = it.next();
                        if (next != null && next.r() != null && next.r().getPortrait() != null && next.r().getPortrait().equals(v16Var.a) && next.r().getUserWorldCupData() != null) {
                            next.r().getUserWorldCupData().d(v16Var.b);
                        }
                    }
                    this.a.H0.T0().f0();
                }
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.H0.e2() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.p5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    /* loaded from: classes7.dex */
    public class u1 implements mj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public u1(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
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
                ei9 ei9Var = this.a.L0;
                if (ei9Var != null && ei9Var.e() != null && this.a.L0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.L0.e().c());
                    if (this.a.W0 != null && (this.a.W0.y() || this.a.W0.A())) {
                        this.a.W0.w(false, this.a.L0.h());
                    }
                    this.a.L0.a(true);
                    return true;
                }
                return !this.a.f5(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class u2 implements View.OnLongClickListener {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.z0 != null && this.a.z0.r1() != null) {
                this.a.z0.r1().a();
                this.a.z0.V1();
                if (this.a.H0.T0() != null) {
                    this.a.H0.d2(this.a.z0.r1());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
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
            AgreeMessageData agreeMessageData;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof AgreeMessageData) && (agreeMessageData = (AgreeMessageData) customResponsedMessage.getData()) != null && (agreeData = agreeMessageData.agreeData) != null) {
                if (this.a.H0 != null) {
                    this.a.H0.x2(agreeMessageData);
                }
                if (agreeData.agreeType == 2 && this.a.H0 != null && !fk9.h(this.a.z0.b)) {
                    this.a.H0.x4();
                    fk9.b(this.a.z0.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v1 implements Comparator<AdverSegmentData> {
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
    public class v2 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ItemCardHelper.l(this.a.getContext(), this.a.getUniqueId(), view2, (ViewGroup) this.a.getView());
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
            pba i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.z0 != null && this.a.z0.r1() != null) {
                String str = (String) customResponsedMessage.getData();
                pba pbaVar = null;
                if (!TextUtils.isEmpty(str) && this.a.z0.r1().F() != null) {
                    ArrayList<qba> F = this.a.z0.r1().F();
                    Iterator<qba> it = F.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        qba next = it.next();
                        if (next instanceof pba) {
                            pba pbaVar2 = (pba) next;
                            if (str.equals(pbaVar2.A1())) {
                                pbaVar = pbaVar2;
                                break;
                            }
                        }
                    }
                    if (pbaVar != null) {
                        F.remove(pbaVar);
                    }
                }
                if (this.a.H0.T0() != null && !ListUtils.isEmpty(this.a.H0.T0().v())) {
                    ArrayList<ym> v = this.a.H0.T0().v();
                    if (pbaVar != null) {
                        i = pbaVar;
                    } else {
                        i = ai9.i(this.a.z0.r1(), str);
                    }
                    ai9.e(v, i);
                }
                if (this.a.H0.m1() != null && !ListUtils.isEmpty(this.a.H0.m1().getData())) {
                    List<ym> data = this.a.H0.m1().getData();
                    if (pbaVar == null) {
                        pbaVar = ai9.i(this.a.z0.r1(), str);
                    }
                    ai9.e(data, pbaVar);
                }
                this.a.k5(str);
                this.a.z0.V1();
                if (this.a.H0.T0() != null) {
                    this.a.H0.T0().f0();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.M5() != null) {
                this.a.M5().H2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w1 implements AntiHelper.k {
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
    public class w2 implements ItemCardHelper.c {
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
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.l5();
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                    return;
                }
                this.a.o1 = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x1 extends h9 {
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

        @Override // com.baidu.tieba.h9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, obj) != null) || !this.a.isAdded()) {
                return;
            }
            boolean z = false;
            if (obj != null) {
                switch (this.a.C0.getLoadDataMode()) {
                    case 0:
                        this.a.z0.V1();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.q5(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.H0.O0(1, dVar.a, dVar.b, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbFragment pbFragment = this.a;
                        pbFragment.r5(pbFragment.C0.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        this.a.H0.O0(this.a.C0.getLoadDataMode(), gVar.a, gVar.b, false);
                        this.a.H0.M2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.H0.O0(this.a.C0.getLoadDataMode(), false, null, false);
        }
    }

    /* loaded from: classes7.dex */
    public class x2 implements NoNetworkView.b {
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

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void k(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.f && z && !this.a.z0.g1()) {
                    this.a.F6();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0703c8));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements SuggestEmotionModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public y(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
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
        public void a(fj9 fj9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, fj9Var) != null) || fj9Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, fj9Var.a()));
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
    public static class y0 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public y0() {
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
    public class y1 implements m45.e {
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

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) && m45Var != null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y2 implements bg<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
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
    public class z0 implements m45.e {
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

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.a.V5();
                t25 p1 = this.a.z0.p1();
                int t1 = this.a.H0.t1();
                if (t1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0fe7);
                } else if (p1 != null && t1 > p1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0fe7);
                } else {
                    this.a.H0.F0();
                    this.a.m7();
                    this.a.H0.M3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.z0.d3(this.a.H0.t1());
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
    public class z1 implements i95.g {
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

        @Override // com.baidu.tieba.i95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.C5()) {
                    this.a.a.finish();
                }
                if (this.a.z0.p2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.H0.N0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z2 implements View.OnTouchListener {
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
        S2 = new y0();
        T2 = new a();
    }

    public static PbFragment r6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65682, null)) == null) {
            return new PbFragment();
        }
        return (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r06
    public ag<LinearLayout> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.D == null) {
                this.D = new ag<>(new y2(this), 15, 0);
            }
            return this.D;
        }
        return (ag) invokeV.objValue;
    }

    public boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.j2();
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
            if (!this.c && this.N2 == -1 && this.O2 == -1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.r06
    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            bi9 bi9Var = this.H0;
            if (bi9Var == null) {
                return 0;
            }
            return bi9Var.z1();
        }
        return invokeV.intValue;
    }

    public boolean D5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.m2.booleanValue();
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
    @Override // com.baidu.tieba.r06
    /* renamed from: F5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            bi9 bi9Var = this.H0;
            if (bi9Var == null) {
                return null;
            }
            return bi9Var.m1();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public final void F6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            hideNetRefreshView(this.H0.E1());
            c7();
            if (this.z0.r2()) {
                this.H0.M3();
            }
            this.H0.V3();
        }
    }

    public int G5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.O2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.r06
    public ag<TiebaPlusRecommendCard> H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.C == null) {
                this.C = new ag<>(new k2(this), 5, 0);
            }
            return this.C;
        }
        return (ag) invokeV.objValue;
    }

    public int H5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.N2;
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
    public final sd9 I5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel != null) {
                return pbModel.r1();
            }
            return null;
        }
        return (sd9) invokeV.objValue;
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

    public hj9 J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.a.J0();
        }
        return (hj9) invokeV.objValue;
    }

    public qj5 J5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.W0;
        }
        return (qj5) invokeV.objValue;
    }

    public ij9 K5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.e;
        }
        return (ij9) invokeV.objValue;
    }

    public wj9 L5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.u0;
        }
        return (wj9) invokeV.objValue;
    }

    public bi9 M5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.H0;
        }
        return (bi9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul9
    public PbModel.h N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.p2;
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

    @Override // com.baidu.tieba.ul9
    public PbModel R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.z0;
        }
        return (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r06
    public ag<RelativeLayout> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            ag<RelativeLayout> agVar = new ag<>(new m2(this), 10, 0);
            this.E = agVar;
            return agVar;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r06
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

    @Override // com.baidu.tieba.r06
    public ag<ImageView> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            if (this.A == null) {
                this.A = new ag<>(new i2(this), 8, 0);
            }
            return this.A;
        }
        return (ag) invokeV.objValue;
    }

    public void W5() {
        bi9 bi9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048639, this) == null) && (bi9Var = this.H0) != null) {
            bi9Var.I1();
            V5();
        }
    }

    @Override // com.baidu.tieba.r06
    public ag<View> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            if (this.B == null) {
                this.B = new ag<>(new l2(this), 8, 0);
            }
            return this.B;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul9
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
            likeModel.setLoadDataCallBack(new k0(this));
        }
    }

    public final void Z5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            ek9 ek9Var = new ek9(getPageContext());
            ek9Var.m();
            this.Z0 = ek9Var;
        }
    }

    @Override // com.baidu.tieba.r06
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
            PbModel pbModel = this.z0;
            if (pbModel != null) {
                return pbModel.W0();
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
            if (absPbActivity != null && absPbActivity.J1() != null && this.a.J1().q1() == 17) {
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
            PbModel pbModel = this.z0;
            if (pbModel != null) {
                return pbModel.U0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            sd9 r12 = this.z0.r1();
            this.z0.f3(true);
            bw4 bw4Var = this.B0;
            if (bw4Var != null) {
                r12.K0(bw4Var.g());
            }
            this.H0.d2(r12);
        }
    }

    public void m6() {
        bi9 bi9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048699, this) != null) || (bi9Var = this.H0) == null) {
            return;
        }
        bi9Var.u2();
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

    @Override // com.baidu.tieba.r06
    public ag<ItemCardView> o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            if (this.F == null) {
                this.F = new ag<>(new n2(this), 10, 0);
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
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.r1() != null) {
                return this.z0.r1().c();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048744, this) == null) && (pbModel = this.z0) != null && !bi.isEmpty(pbModel.K1())) {
            super.taskStart();
        }
    }

    public qba v5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            sd9 sd9Var = this.z0.G;
            if (sd9Var != null) {
                return sd9Var.X();
            }
            return null;
        }
        return (qba) invokeV.objValue;
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
            return this.R2;
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

    @Override // com.baidu.tieba.r06
    public ag<GifView> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            if (this.L == null) {
                this.L = new ag<>(new j2(this), 20, 0);
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
        this.t0 = new r(this);
        this.w0 = false;
        this.x0 = new c0(this);
        this.y0 = new Handler(new n0(this));
        this.z0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.F0 = null;
        this.G0 = null;
        this.H0 = null;
        this.I0 = false;
        this.J0 = false;
        this.K0 = false;
        this.P0 = false;
        this.R0 = false;
        this.T0 = false;
        this.Z0 = null;
        this.a1 = new j1(this);
        this.b1 = new u1(this);
        this.c1 = new f2(this);
        this.d1 = 0;
        this.o1 = false;
        this.p1 = 0;
        this.q1 = -1;
        this.s1 = 0;
        this.u1 = new q2(this);
        this.v1 = new b3(this);
        this.w1 = new h(this, 2004016);
        this.x1 = new i(this, 2016485);
        this.y1 = new j(this, 2001269);
        this.z1 = new k(this, 2004008);
        this.A1 = new l(this, 2004007);
        this.B1 = new m(this, 2004005);
        this.C1 = new n(this, 2001332);
        this.D1 = new o(this, 2921391);
        this.E1 = new p(this, 2921606);
        this.F1 = new q(this, 2921658);
        this.G1 = new s(this);
        this.H1 = new t(this, 2001369);
        this.I1 = new u(this, 2921787);
        this.J1 = new v(this, 2016488);
        this.K1 = new w(this, 2016331);
        this.L1 = new x(this, 2921746);
        this.M1 = new y(this);
        this.N1 = new z(this, 2010045);
        this.O1 = new a0(this);
        this.P1 = new PraiseModel(getPageContext(), new b0(this));
        this.Q1 = new d0(this);
        this.R1 = new f0(this, 2001115);
        this.S1 = new g0(this);
        this.T1 = new h0(this);
        this.V1 = new ze9(new m0(this));
        this.W1 = new p0(this);
        this.X1 = new q0(this, 2001427);
        this.Y1 = new r0(this, 2001428);
        this.Z1 = new s0(this, 2921634);
        this.a2 = new t0(this, 2001426);
        this.b2 = new u0(this, 2004021);
        this.c2 = new v0(this, 2016528);
        this.d2 = new w0(this, 2921724);
        this.e2 = new x0(this, 2921033);
        this.f2 = new z0(this);
        this.g2 = new a1(this);
        this.h2 = new b1(this);
        this.i2 = new e1(this);
        this.j2 = new h1(this);
        this.k2 = new i1(this, 2921480);
        this.l2 = new k1(this);
        this.m2 = Boolean.FALSE;
        this.n2 = new l1(this);
        this.o2 = new m1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.p2 = new n1(this);
        this.q2 = new o1(this, 2016450);
        this.r2 = new p1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.s2 = new q1(this);
        this.t2 = new t1(this);
        this.u2 = new x1(this);
        this.v2 = new z1(this);
        this.w2 = new a2(this);
        this.y2 = new b2(this);
        this.z2 = 0;
        this.A2 = new o2(this);
        this.B2 = false;
        this.C2 = null;
        this.D2 = new p2(this);
        this.E2 = new r2(this);
        this.F2 = new s2(this);
        this.G2 = new u2(this);
        this.H2 = new v2(this);
        this.I2 = new w2(this);
        this.J2 = new x2(this);
        this.K2 = new z2(this);
        this.L2 = new a3(this);
        this.M2 = new b(this);
        this.N2 = -1;
        this.O2 = -1;
        this.R2 = 0;
    }

    @Override // com.baidu.tieba.ul9
    public void finish() {
        bi9 bi9Var;
        boolean z3;
        CardHListViewData p3;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            bi9 bi9Var2 = this.H0;
            if (bi9Var2 != null) {
                bi9Var2.F0();
            }
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.r1() != null && !this.z0.r1().j0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.z0.r1().O().getId();
                if (this.z0.isShareThread() && this.z0.r1().O().originalThreadData != null) {
                    historyMessage.threadName = this.z0.r1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.z0.r1().O().getTitle();
                }
                if (this.z0.isShareThread() && !A0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.z0.r1().k().getName();
                }
                ArrayList<qba> F = this.z0.r1().F();
                bi9 bi9Var3 = this.H0;
                if (bi9Var3 != null) {
                    i3 = bi9Var3.d1();
                } else {
                    i3 = 0;
                }
                if (F != null && i3 >= 0 && i3 < F.size()) {
                    historyMessage.postID = F.get(i3).S();
                }
                historyMessage.isHostOnly = this.z0.U0();
                historyMessage.isSquence = this.z0.J1();
                historyMessage.isShareThread = this.z0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            PbModel pbModel2 = this.z0;
            if (pbModel2 != null && (pbModel2.W0() || this.z0.Z0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.z0.K1());
                if (this.I0) {
                    if (this.K0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.z0.f1());
                    }
                    if (this.J0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.z0.b1());
                    }
                }
                if (this.z0.Z0() && this.z0.r1() != null && this.z0.r1().O() != null) {
                    rr6.b().b(new dk5(this.z0.Q()));
                }
                if (this.z0.r1() != null && System.currentTimeMillis() - this.n >= 40000 && (p3 = this.z0.r1().p()) != null && !ListUtils.isEmpty(p3.getDataList())) {
                    intent.putExtra("guess_like_data", p3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.q1);
                }
                this.a.setResult(-1, intent);
            }
            if (o7()) {
                if (this.z0 != null && (bi9Var = this.H0) != null && bi9Var.m1() != null) {
                    sd9 r12 = this.z0.r1();
                    if (r12 != null) {
                        if (r12.V() != null) {
                            r12.V().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            r12.V().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!r12.s0() && !this.I && r12.h == null) {
                            sh9 b4 = sh9.b();
                            sd9 s12 = this.z0.s1();
                            Parcelable onSaveInstanceState = this.H0.m1().onSaveInstanceState();
                            boolean J1 = this.z0.J1();
                            boolean U0 = this.z0.U0();
                            if (this.H0.u1() != null && this.H0.u1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.l(s12, onSaveInstanceState, J1, U0, z3);
                            if (this.p1 >= 0 || this.z0.M1() != null) {
                                sh9.b().o(this.z0.M1());
                                sh9.b().p(this.z0.N1());
                                sh9.b().m(this.z0.k1());
                            }
                        }
                    }
                } else {
                    sh9.b().k();
                }
                n7();
            }
            ek9 ek9Var = this.Z0;
            if (ek9Var != null && !ek9Var.o() && d5() && this.z0.Z0() && !TextUtils.isEmpty(this.z0.Q())) {
                this.Z0.n(this.z0.r1().g().l, this.z0.Q());
            }
        }
    }

    @Override // com.baidu.tieba.r06
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.u = true;
        }
    }

    @Override // com.baidu.tieba.r06
    public void K(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) {
            hi9.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.u = true;
        }
    }

    @Override // com.baidu.tieba.r06
    public void i0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048683, this, context, str) == null) {
            this.u = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        bi9 bi9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048719, this, i3, keyEvent)) == null) {
            if (keyEvent != null && (bi9Var = this.H0) != null) {
                return bi9Var.C2(i3);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void G6(c3 c3Var) {
        List<c3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, c3Var) == null) && c3Var != null && (list = this.r1) != null) {
            list.remove(c3Var);
        }
    }

    public final void L6(int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048610, this, i3) == null) && this.z0 != null) {
            c7();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
            privacySettingMessage.setTid(this.z0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void M6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i3) == null) {
            this.R2 = i3;
        }
    }

    public void N6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z3) == null) {
            this.m2 = Boolean.valueOf(z3);
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
        if ((interceptable != null && interceptable.invokeZ(1048630, this, z3) != null) || (qj5Var = this.W0) == null) {
            return;
        }
        qj5Var.Y(z3);
        this.W0.b0(z3);
        this.W0.j0(z3);
    }

    public final void U5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, intent) == null) {
            fk9.g(this, intent);
        }
    }

    public void V4(c3 c3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, c3Var) == null) && c3Var != null) {
            if (this.r1 == null) {
                this.r1 = new ArrayList();
            }
            if (!this.r1.contains(c3Var)) {
                this.r1.add(c3Var);
            }
        }
    }

    public void W4(c3 c3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048638, this, c3Var) == null) && c3Var != null) {
            if (this.r1 == null) {
                this.r1 = new ArrayList();
            }
            if (!this.r1.contains(c3Var)) {
                this.r1.add(0, c3Var);
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
            fk9.j(this, u5(), i3);
        }
    }

    @Override // com.baidu.tieba.dm9.b
    public void m1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048697, this, z3) == null) {
            this.Q0 = z3;
        }
    }

    public final void o6(View view2) {
        SparseArray sparseArray;
        qba qbaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (qbaVar = (qba) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            p6(qbaVar);
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
            this.z0.L2(bundle);
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            qj5 qj5Var = this.W0;
            if (qj5Var != null) {
                qj5Var.G(bundle);
            }
        }
    }

    public final void t7(m15 m15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048742, this, m15Var) == null) && m15Var != null) {
            this.Q2 = m15Var;
            this.c = true;
            this.H0.h3();
            this.H0.A3(this.P2);
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
                this.B2 = true;
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
                                String a4 = td9.a(tbRichTextData);
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
                                        imageUrlData.originalUrl = ai9.n(tbRichTextData);
                                        imageUrlData.originalSize = ai9.o(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = ai9.k(tbRichTextData);
                                        imageUrlData.isLongPic = ai9.j(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = JavaTypesHelper.toLong(this.z0.K1(), -1L);
                                        imageUrlData.mIsReserver = this.z0.C1();
                                        imageUrlData.mIsSeeHost = this.z0.U0();
                                        if (concurrentHashMap != null) {
                                            concurrentHashMap.put(a4, imageUrlData);
                                        }
                                    }
                                }
                                if (!this.B2) {
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
            BdPageContext bdPageContext = this.f1;
            if (bdPageContext == null) {
                return;
            }
            m45 m45Var = new m45(bdPageContext.getPageActivity());
            m45Var.setMessage(str);
            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b3e, new e(this));
            m45Var.create(this.f1).show();
        }
    }

    public final void k7(SparseArray<Object> sparseArray) {
        qba qbaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048693, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof qba) || (qbaVar = (qba) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        l7(qbaVar, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048728, this, z3) == null) {
            super.onUserChanged(z3);
            this.H0.L4(z3);
            u45 u45Var = this.M0;
            if (u45Var != null) {
                u45Var.dismiss();
            }
            if (z3 && this.Q0) {
                this.H0.N3();
                this.z0.n2(true);
            }
            if (this.H0.T0() != null) {
                this.H0.T0().j0(z3);
            }
        }
    }

    public final void r7(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048736, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.z0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(yj9.m(i3))));
        }
    }

    public final void s5(Rect rect) {
        bi9 bi9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048737, this, rect) == null) && rect != null && (bi9Var = this.H0) != null && bi9Var.D1() != null && rect.top <= this.H0.D1().getHeight()) {
            rect.top += this.H0.D1().getHeight() - rect.top;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.t
    public void C0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048583, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (o06[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), o06.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (hi9.c(objArr[i3].g()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    @Override // com.baidu.tieba.r06
    public void a0(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048653, this, context, str, z3) == null) {
            if (hi9.c(str) && (pbModel = this.z0) != null && pbModel.K1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.z0.K1()));
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
                hi9.a().e(getPageContext(), str);
            }
            this.u = true;
        }
    }

    public void C6(je9 je9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, je9Var) == null) {
            String S = je9Var.g().S();
            List<qba> list = this.z0.r1().T().a;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                qba qbaVar = list.get(i3);
                if (qbaVar.S() != null && qbaVar.S().equals(S)) {
                    ArrayList<qba> i4 = je9Var.i();
                    qbaVar.m1(je9Var.k());
                    if (qbaVar.i0() != null) {
                        qbaVar.i0().clear();
                        qbaVar.i0().addAll(i4);
                    }
                } else {
                    i3++;
                }
            }
            if (!this.z0.a1()) {
                this.H0.d2(this.z0.r1());
            }
        }
    }

    public final void T5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.r1() != null && this.z0.r1().j0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.z0.K1(), str);
                ThreadData O = this.z0.r1().O();
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
            this.A0.a(str);
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
        m45Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0c41), new r1(this, metaData));
        m45Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0c42), new s1(this, metaData));
        m45Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void f7(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && R() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                R().A0(postWriteCallBackData.getPostId());
                int Z0 = this.H0.Z0();
                this.p1 = Z0;
                this.z0.O2(Z0, this.H0.g1());
            }
            this.H0.F0();
            this.L0.c();
            qj5 qj5Var = this.W0;
            if (qj5Var != null) {
                this.H0.r3(qj5Var.z());
            }
            this.H0.I1();
            this.H0.c4(true);
            this.z0.V1();
        }
    }

    public final void k5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048691, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.z0) != null && pbModel.r1() != null) {
            pba z3 = this.z0.r1().z();
            if (z3 != null && str.equals(z3.A1())) {
                if (z3.getAdvertAppInfo() != null) {
                    z3.getAdvertAppInfo().h = null;
                }
                this.z0.r1().b();
            }
            pba K0 = this.z0.K0();
            if (K0 != null && str.equals(K0.A1())) {
                this.z0.x0();
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
        this.H0.y2(i3);
        qj5 qj5Var = this.W0;
        if (qj5Var != null && qj5Var.b() != null) {
            this.W0.b().z(i3);
        }
        if (this.H0.a() != null) {
            this.H0.a().onChangeSkinType(getPageContext(), i3);
        }
        this.L0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201), true);
        this.W = i3;
        m7();
        kf5 kf5Var = this.j0;
        if (kf5Var != null) {
            kf5Var.w();
        }
    }

    public void p6(qba qbaVar) {
        boolean z3;
        qba v5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048730, this, qbaVar) != null) || qbaVar == null) {
            return;
        }
        if (qbaVar.S() != null && qbaVar.S().equals(this.z0.m1())) {
            z3 = true;
        } else {
            z3 = false;
        }
        MarkData l12 = this.z0.l1(qbaVar);
        if (this.z0.r1() != null && this.z0.r1().j0() && (v5 = v5()) != null) {
            l12 = this.z0.l1(v5);
        }
        if (l12 == null) {
            return;
        }
        this.H0.M3();
        bw4 bw4Var = this.B0;
        if (bw4Var != null) {
            bw4Var.i(l12);
            if (!z3) {
                this.B0.a();
            } else {
                this.B0.d();
            }
        }
    }

    public void D6(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z3, markData) == null) {
            this.H0.L3();
            this.z0.f3(z3);
            bw4 bw4Var = this.B0;
            if (bw4Var != null) {
                bw4Var.h(z3);
                if (markData != null) {
                    this.B0.i(markData);
                }
            }
            if (this.z0.c1()) {
                l6();
            } else {
                this.H0.d2(this.z0.r1());
            }
        }
    }

    public void E6(je9 je9Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, je9Var) != null) || je9Var.g() == null) {
            return;
        }
        String S = je9Var.g().S();
        ArrayList<qba> F = this.z0.r1().F();
        int i3 = 0;
        while (true) {
            z3 = true;
            if (i3 >= F.size()) {
                break;
            }
            qba qbaVar = F.get(i3);
            if (qbaVar.S() != null && qbaVar.S().equals(S)) {
                ArrayList<qba> i4 = je9Var.i();
                qbaVar.m1(je9Var.k());
                if (qbaVar.i0() != null && i4 != null) {
                    Iterator<qba> it = i4.iterator();
                    while (it.hasNext()) {
                        qba next = it.next();
                        if (qbaVar.r0() != null && next != null && next.r() != null && (metaData = qbaVar.r0().get(next.r().getUserId())) != null) {
                            next.N0(metaData);
                            next.c1(true);
                            next.w1(getPageContext(), this.z0.k2(metaData.getUserId()));
                        }
                    }
                    if (i4.size() == qbaVar.i0().size()) {
                        z3 = false;
                    }
                    if (!qbaVar.y0(false)) {
                        qbaVar.i0().clear();
                        qbaVar.i0().addAll(i4);
                    }
                }
                if (qbaVar.D() != null) {
                    qbaVar.L0();
                }
            } else {
                i3++;
            }
        }
        if (!this.z0.a1() && z3) {
            this.H0.d2(this.z0.r1());
        }
        if (z3) {
            C6(je9Var);
        }
    }

    public void a5(boolean z3) {
        bi9 bi9Var;
        int i3;
        int y3;
        qba qbaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048655, this, z3) == null) && (bi9Var = this.H0) != null && bi9Var.m1() != null) {
            int firstVisiblePosition = this.H0.m1().getFirstVisiblePosition();
            int lastVisiblePosition = this.H0.m1().getLastVisiblePosition();
            kg9 T0 = this.H0.T0();
            if (T0 != null && this.z0.r1() != null) {
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
                        if (this.H0.m1().G(i3) != null && (this.H0.m1().G(i3) instanceof qba) && (qbaVar = (qba) this.H0.m1().G(i3)) != null) {
                            qba qbaVar2 = (qba) ListUtils.getItem(this.z0.r1().F(), qbaVar.I() - 1);
                            if (qbaVar.n() == null && qbaVar2 != null) {
                                qbaVar.M0(qbaVar2.n());
                            }
                            if (qbaVar.n() != null) {
                                qbaVar.n().setFloonumber(qbaVar.I());
                                arrayList.add(qbaVar.n());
                            }
                        }
                        i3++;
                    }
                }
                if (ListUtils.getItem(arrayList, 0) != null) {
                    Collections.sort(arrayList, new v1(this));
                    AdverSegmentData adverSegmentData = (AdverSegmentData) ListUtils.getItem(arrayList, 0);
                    if (adverSegmentData != null && adverSegmentData.getFloonumber() == 1) {
                        if (!z3) {
                            this.H0.V2(adverSegmentData, 0);
                            return;
                        }
                        return;
                    }
                    this.H0.V2(adverSegmentData, 1);
                }
            }
        }
    }

    public final boolean q6(qba qbaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048733, this, qbaVar)) == null) {
            if (qbaVar == null) {
                return false;
            }
            String S = qbaVar.S();
            if (StringUtils.isNull(S) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String string = SharedPrefHelper.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = qbaVar.n0().getJumpUrl();
            int packageId = qbaVar.n0().getPackageId();
            int propsId = qbaVar.n0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                BrowserHelper.startWebActivity(getPageContext().getPageActivity(), wca.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
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
        if ((interceptable != null && interceptable.invokeI(1048747, this, i3) != null) || (pbModel = this.z0) == null || pbModel.r1() == null || (O = this.z0.r1().O()) == null) {
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
        if (this.z0.J1()) {
            this.H0.T0().f0();
        } else {
            this.H0.T4(this.z0.r1());
        }
    }

    public final AbsPbActivity.e z6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048760, this, str)) == null) {
            String str2 = null;
            if (this.z0.r1() != null && this.z0.r1().F() != null && this.z0.r1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 < this.z0.r1().F().size()) {
                        if (str.equals(this.z0.r1().F().get(i3).S())) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = 0;
                        break;
                    }
                }
                qba qbaVar = this.z0.r1().F().get(i3);
                if (qbaVar.e0() != null && qbaVar.e0().P() != null) {
                    Iterator<TbRichTextData> it = qbaVar.e0().P().iterator();
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
                    td9.b(qbaVar, eVar);
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
            if (!(obj instanceof qba)) {
                return false;
            }
            qba qbaVar = (qba) obj;
            if (qbaVar.getType() != qba.Z0 && !TextUtils.isEmpty(qbaVar.u()) && b05.c().g()) {
                return q6(qbaVar);
            }
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return true;
            }
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.r1() != null) {
                if (M5().w1() != null) {
                    M5().w1().g();
                }
                je9 je9Var = new je9();
                je9Var.v(this.z0.r1().k());
                je9Var.z(this.z0.r1().O());
                je9Var.x(qbaVar);
                M5().v1().j0(je9Var);
                M5().v1().setPostId(qbaVar.S());
                k6(view2, qbaVar.r().getUserId(), "", qbaVar);
                TiebaStatic.log("c11743");
                qj5 qj5Var = this.W0;
                if (qj5Var != null) {
                    this.H0.r3(qj5Var.z());
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
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (pbModel = this.z0) != null && pbModel.r1() != null && this.z0.r1().O() != null && this.z0.r1().O().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void K6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (pbModel = this.z0) != null && pbModel.r1() != null && this.z0.r1().O() != null && this.z0.r1().O().isVideoThreadType()) {
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
            PbModel pbModel = this.z0;
            if (pbModel == null || !pbModel.J1()) {
                return false;
            }
            if (this.z0.p1() != null && this.z0.p1().c() == 0) {
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
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.r1() != null && this.z0.r1().g() != null && !TextUtils.isEmpty(this.z0.r1().g().l)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048666, this) == null) && sk9.b() && !this.H0.U2()) {
            kf5 showPushOpenView = PushOpenUtil.showPushOpenView(getPageContext(), "reply_pb", 0L);
            this.j0 = showPushOpenView;
            if (showPushOpenView != null) {
                tv9.e().h("reply_pb");
            }
        }
    }

    public final void e7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048669, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && sk9.a() && !this.H0.U2()) {
            kf5 showPushOpenView = PushOpenUtil.showPushOpenView(getPageContext(), "collect", 0L);
            this.j0 = showPushOpenView;
            if (showPushOpenView != null) {
                tv9.e().h("collect");
            }
        }
    }

    public final boolean f6() {
        InterceptResult invokeV;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if (vb9.c() && (pbModel = this.z0) != null && pbModel.r1() != null && this.z0.r1().i() != null && this.z0.r1().i().x() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048690, this) == null) && (pbModel = this.z0) != null && !bi.isEmpty(pbModel.K1())) {
            et4.w().Q(dt4.Z, JavaTypesHelper.toLong(this.z0.K1(), 0L));
        }
    }

    public void s6() {
        List<c3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048738, this) == null) && (list = this.r1) != null && !list.isEmpty()) {
            int size = this.r1.size();
            while (true) {
                size--;
                if (size <= -1 || this.r1.get(size).onBackPressed()) {
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
            this.H0.F0();
            if (this.h) {
                return;
            }
            m7();
            this.H0.M3();
            if (this.z0.loadData()) {
                this.H0.u4();
            }
        }
    }

    public final int u5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            if (this.z0.r1() != null && this.z0.r1().O() != null) {
                return this.z0.r1().O().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void N5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (this.F0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.F0 = pollingModel;
                pollingModel.setDialogTime(h55.e);
            }
            this.F0.getData(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            SafeHandler.getInst().postDelayed(this.W1, 10000L);
        }
    }

    public final void Y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            if (this.m1 != null) {
                rl5.b bVar = new rl5.b();
                bVar.a = this.m1.Q();
                bVar.b = this.m1.O();
                bVar.c = String.valueOf(this.m1.R());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.l1));
        }
    }

    public final void a7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            m45 m45Var = new m45(getPageContext().getPageActivity());
            m45Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            m45Var.setPositiveButton(R.string.open_now, new c(this));
            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new d(this));
            m45Var.create(this.f1).show();
        }
    }

    public final boolean b5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel == null || pbModel.r1() == null) {
                return false;
            }
            ThreadData O = this.z0.r1().O();
            AntiData c4 = this.z0.r1().c();
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
            showLoadingView(this.H0.E1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d5));
            View attachedView = getLoadingView().getAttachedView();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) attachedView.getLayoutParams();
            layoutParams.addRule(3, this.H0.D1().getId());
            attachedView.setLayoutParams(layoutParams);
        }
    }

    public final boolean d6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            qba c4 = td9.c(this.z0.r1(), this.z0.J1(), this.z0.B1());
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
            if ((this.z0.r1() != null && (this.z0.r1().j0() || ThreadCardUtils.isSelf(this.z0.r1().O()))) || this.Y0 == null || this.z0.r1() == null || this.z0.r1().c() == null) {
                return true;
            }
            return this.Y0.checkPrivacyBeforeInvokeEditor(this.z0.r1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void h5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            if (this.z0.W0() || this.z0.Z0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.z0.K1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.z0.K1()));
            if (o7()) {
                this.a.finish();
            }
        }
    }

    public final void h6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048681, this) == null) && this.Q2 != null) {
            if (this.O2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0fe1);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.Q2.a(), this.O2, 0)));
                this.a.finish();
            }
        }
    }

    public final void j6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048689, this) == null) && this.Q2 != null) {
            if (this.N2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0fe2);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.Q2.a(), this.N2, 0)));
                this.a.finish();
            }
        }
    }

    public final void p7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048731, this) == null) && (absPbActivity = this.a) != null && absPbActivity.J1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.J1().K1()).param("topic_id", this.a.J1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.J1().O1()));
        }
    }

    public final void s7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048739, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.S(this.z0.getForumId()) && this.z0.r1() != null && this.z0.r1().k() != null) {
            boolean z3 = true;
            if (this.z0.r1().k().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.z0.F0().R(this.z0.getForumId(), this.z0.K1());
            }
        }
    }

    public void P5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (this.f) {
                this.O = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.z0.r1() != null && this.z0.r1().O() != null && this.z0.r1().O().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.z0.r1().O().getTaskInfoData().k(), this.z0.r1().O().getTaskInfoData().h(), this.z0.r1().O().getTaskInfoData().c(), this.z0.r1().O().getTaskInfoData().d(), this.z0.r1().O().getIs_top(), this.z0.r1().O().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void l5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.r1() != null) {
                pba z3 = this.z0.r1().z();
                if (z3 != null) {
                    if (z3.getAdvertAppInfo() != null) {
                        z3.getAdvertAppInfo().h = null;
                    }
                    this.z0.r1().b();
                }
                if (this.z0.K0() != null) {
                    this.z0.x0();
                }
                this.z0.V1();
            }
            if (this.z0.r1().F() != null) {
                Iterator<qba> it = this.z0.r1().F().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof pba) {
                        it.remove();
                    }
                }
            }
            if (this.H0.T0() != null && !ListUtils.isEmpty(this.H0.T0().v())) {
                ai9.d(this.H0.T0().v());
            }
            if (this.H0.m1() != null && !ListUtils.isEmpty(this.H0.m1().getData())) {
                ai9.d(this.H0.m1().getData());
            }
            if (this.H0.T0() != null) {
                this.H0.T0().f0();
            }
        }
    }

    public final boolean o7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.r1() != null && this.z0.r1().j0()) {
                return true;
            }
            if (this.z0.c1()) {
                MarkData N0 = this.z0.N0();
                if (N0 == null || !this.z0.a1()) {
                    return true;
                }
                MarkData I0 = this.z0.I0(this.H0.d1());
                if (I0 == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", N0);
                    this.a.setResult(-1, intent);
                    return true;
                } else if (I0.getPostId() != null && !I0.getPostId().equals(N0.getPostId())) {
                    m45 m45Var = new m45(getPageContext().getPageActivity());
                    m45Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0298));
                    m45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c1, new e2(this, I0, N0, m45Var));
                    m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new g2(this, N0, m45Var));
                    m45Var.setOnCalcelListener(new h2(this, N0, m45Var));
                    m45Var.create(getPageContext());
                    m45Var.show();
                    return false;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", N0);
                    this.a.setResult(-1, intent2);
                    return true;
                }
            }
            if (this.z0.r1() != null && this.z0.r1().F() != null && this.z0.r1().F().size() > 0 && this.z0.a1()) {
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
            bi9 bi9Var = this.H0;
            if (bi9Var != null && bi9Var.E1() != null) {
                if (!this.g) {
                    c7();
                } else {
                    hideLoadingView(this.H0.E1());
                }
                this.H0.I2();
            }
            if (this.j == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            bi9 bi9Var2 = this.H0;
            if (bi9Var2 != null) {
                noNetworkView = bi9Var2.a();
            }
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.update(false);
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.C1);
            this.Q0 = false;
            K6();
            registerListener(this.X1);
            registerListener(this.Y1);
            registerListener(this.a2);
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.o1) {
                F6();
                this.o1 = false;
            }
            j7();
            ItemCardHelper.w(this.I2);
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
            qk9 qk9Var = this.H0.k;
            if (qk9Var != null && !qk9Var.n()) {
                this.H0.k.r();
            }
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.r1() != null && this.z0.r1().k() != null && this.z0.r1().O() != null) {
                bh5.j().x(getPageContext().getPageActivity(), "pb", this.z0.r1().k().getId(), JavaTypesHelper.toLong(this.z0.r1().O().getId(), 0L));
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            t9a.g().h(getUniqueId(), false);
        }
    }

    public final String y5() {
        InterceptResult invokeV;
        ArrayList<qba> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            PbModel pbModel = this.z0;
            if (pbModel == null || pbModel.r1() == null || this.z0.r1().F() == null || (count = ListUtils.getCount((F = this.z0.r1().F()))) == 0) {
                return "";
            }
            if (this.z0.C1()) {
                Iterator<qba> it = F.iterator();
                while (it.hasNext()) {
                    qba next = it.next();
                    if (next != null && next.I() == 1) {
                        return next.S();
                    }
                }
            }
            int d12 = this.H0.d1();
            qba qbaVar = (qba) ListUtils.getItem(F, d12);
            if (qbaVar != null && qbaVar.r() != null) {
                if (this.z0.k2(qbaVar.r().getUserId())) {
                    return qbaVar.S();
                }
                for (int i3 = d12 - 1; i3 != 0; i3--) {
                    qba qbaVar2 = (qba) ListUtils.getItem(F, i3);
                    if (qbaVar2 == null || qbaVar2.r() == null || qbaVar2.r().getUserId() == null) {
                        break;
                    } else if (this.z0.k2(qbaVar2.r().getUserId())) {
                        return qbaVar2.S();
                    }
                }
                for (int i4 = d12 + 1; i4 < count; i4++) {
                    qba qbaVar3 = (qba) ListUtils.getItem(F, i4);
                    if (qbaVar3 == null || qbaVar3.r() == null || qbaVar3.r().getUserId() == null) {
                        break;
                    } else if (this.z0.k2(qbaVar3.r().getUserId())) {
                        return qbaVar3.S();
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
            PbModel pbModel = this.z0;
            if (pbModel != null && pbModel.r1() != null && this.z0.r1().k() != null) {
                if (b5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.z0.r1().j0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.H0.w0();
                    return;
                } else {
                    qj5 qj5Var = this.W0;
                    if (qj5Var != null && qj5Var.b() != null) {
                        this.W0.b().D(new lh5(45, 27, null));
                    }
                    this.H0.w0();
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void Q6(rj5 rj5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, rj5Var) == null) && rj5Var != null && (pbModel = this.z0) != null) {
            rj5Var.p(pbModel.Q0());
            if (this.z0.r1() != null && this.z0.r1().k() != null) {
                rj5Var.o(this.z0.r1().k());
            }
            rj5Var.q("pb");
            rj5Var.r(this.z0);
            rj5Var.s(PbNewEditorTool.InputShowType.REPLY);
        }
    }

    public final void R6(int i3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048625, this, i3) != null) || (pbModel = this.z0) == null) {
            return;
        }
        int A1 = pbModel.A1();
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    this.z0.Z2(1);
                } else {
                    this.z0.Z2(4);
                }
            } else {
                this.z0.Z2(3);
            }
        } else {
            this.z0.Z2(2);
        }
        int A12 = this.z0.A1();
        if (A1 == 4 || A12 == 4) {
            t6();
        }
    }

    public final void X5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, bundle) == null) {
            bw4 c4 = bw4.c(this.a);
            this.B0 = c4;
            if (c4 != null) {
                c4.j(this.s2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.C0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.u2);
            this.D0 = new fe5(getPageContext());
            N5();
            this.P1.setUniqueId(getUniqueId());
            this.P1.registerListener();
            Z5();
        }
    }

    public void X6(View view2) {
        sd9 I5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, view2) == null) {
            int i3 = SharedPrefHelper.getInstance().getInt(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb"), 0);
            AbsPbActivity absPbActivity = this.a;
            if ((absPbActivity == null || absPbActivity.getIntent() == null || !this.a.getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) || (i3 != 1 && i3 != 2 && i3 != 3)) && (I5 = I5()) != null) {
                zj9.d(getContext(), view2, I5);
            }
        }
    }

    public void c5(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.H0.k4();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = JavaTypesHelper.toLong(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = JavaTypesHelper.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.h1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.e1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean f5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048671, this, i3)) == null) {
            if (this.Y0 != null && this.z0.r1() != null && !ThreadCardUtils.isSelf(this.z0.r1().O()) && this.z0.r1().c() != null) {
                return this.Y0.checkPrivacyBeforeSend(this.z0.r1().c().replyPrivateFlag, i3);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void i6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, bundle) == null) {
            PbModel J1 = this.a.J1();
            this.z0 = J1;
            if (J1 != null) {
                if (J1.M0() != null) {
                    this.z0.M0().c(this.M2);
                }
                if (this.z0.n1() != null) {
                    this.z0.n1().f(this.v1);
                }
                if (StringUtils.isNull(this.z0.K1())) {
                    this.a.finish();
                } else if ("from_tieba_kuang".equals(this.M) && this.M != null) {
                    this.z0.W2(6);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z3;
        bi9 bi9Var;
        qk9 qk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (UtilHelper.isFoldScreen() && (bi9Var = this.H0) != null && (qk9Var = bi9Var.k) != null && qk9Var.n()) {
                this.H0.k.g();
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
            bi9 bi9Var2 = this.H0;
            if (bi9Var2 != null) {
                bi9Var2.z2(configuration);
            }
            u45 u45Var = this.M0;
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
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.J1().K1()).param("topic_id", this.a.J1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.J1().O1()));
        }
    }

    public void w6(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048752, this, animatorListener) == null) && this.H0 != null && (pbModel = this.z0) != null && pbModel.r1() != null && this.z0.r1().S() != null && checkUpIsLogin() && this.H0.T0() != null && this.H0.T0().B() != null) {
            this.H0.T0().B().V(animatorListener);
        }
    }

    public final void R5(int i3, Intent intent) {
        yh5 yh5Var;
        yh5 yh5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048624, this, i3, intent) == null) {
            if (i3 == 0) {
                this.H0.I1();
                this.H0.w1().g();
                this.H0.c4(false);
            }
            this.H0.j3();
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
                if (editorType == 1 && this.H0.w1() != null && this.H0.w1().f() != null) {
                    tj5 f3 = this.H0.w1().f();
                    f3.f0(this.z0.r1().O());
                    f3.D(writeData);
                    f3.g0(pbEditorData.getVoiceModel());
                    xh5 p3 = f3.b().p(6);
                    if (p3 != null && (yh5Var2 = p3.m) != null) {
                        yh5Var2.B(new lh5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        f3.I();
                        return;
                    }
                    return;
                }
                return;
            }
            qj5 qj5Var = this.W0;
            if (qj5Var != null) {
                qj5Var.M();
                this.W0.n0(pbEditorData.getVoiceModel());
                this.W0.C(writeData);
                xh5 p4 = this.W0.b().p(6);
                if (p4 != null && (yh5Var = p4.m) != null) {
                    yh5Var.B(new lh5(52, 0, pbEditorData.getVoiceModel()));
                }
                this.W0.i0(pbEditorData.isShowCustomFigure());
                if (i3 == -1) {
                    this.W0.H(null, null);
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
                            yb9.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            yb9.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            yb9.e(getResources().getString(R.string.obfuscated_res_0x7f0f146f));
                            return;
                        } else {
                            yb9.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.z0.e1()) {
                antiData.setBlock_forum_name(this.z0.r1().k().getName());
                antiData.setBlock_forum_id(this.z0.r1().k().getId());
                antiData.setUser_name(this.z0.r1().V().getUserName());
                antiData.setUser_id(this.z0.r1().V().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void b7(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048660, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            u45 u45Var = this.M0;
            if (u45Var != null && u45Var.isShowing()) {
                this.M0.dismiss();
                this.M0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            w45 w45Var = new w45(getContext());
            w45Var.q(new e0(this, sparseArray, z3, str2, str));
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
            this.M0 = u45Var2;
            u45Var2.l();
        }
    }

    public final void l7(qba qbaVar, boolean z3) {
        PbModel pbModel;
        int i3;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048696, this, qbaVar, z3) == null) {
            N6(false);
            if (qbaVar == null || (pbModel = this.z0) == null || pbModel.r1() == null || qbaVar.I() == 1) {
                return;
            }
            String K1 = this.z0.K1();
            String S = qbaVar.S();
            if (this.z0.r1() != null) {
                i3 = this.z0.r1().W();
            } else {
                i3 = 0;
            }
            AbsPbActivity.e z6 = z6(S);
            if (z6 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo l02 = qbaVar.l0();
            AntiData c4 = this.z0.r1().c();
            if (qbaVar.r() != null) {
                arrayList = qbaVar.r().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(K1, S, "pb", true, false, null, false, null, i3, l02, c4, false, arrayList, 5).addBigImageData(z6.a, z6.b, z6.g, z6.j);
            addBigImageData.setKeyPageStartFrom(this.z0.q1());
            addBigImageData.setFromFrsForumId(this.z0.getFromForumId());
            addBigImageData.setWorksInfoData(this.z0.P1());
            addBigImageData.setKeyFromForumId(this.z0.getForumId());
            addBigImageData.setBjhData(this.z0.J0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public void m5(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048698, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(bi9.o2)).intValue();
            if (intValue == bi9.p2) {
                if (this.C0.g0()) {
                    return;
                }
                this.H0.F4();
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
                    this.C0.i0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.C0.j0(this.z0.r1().k().getId(), this.z0.r1().k().getName(), this.z0.r1().O().getId(), str, intValue3, intValue2, booleanValue, this.z0.r1().O().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == bi9.q2 || intValue == bi9.s2) {
                PbModel pbModel = this.z0;
                if (pbModel != null && pbModel.M0() != null) {
                    this.z0.M0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == bi9.q2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public void p5(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048729, this, i3, i4) == null) {
            TiebaStatic.log("c12181");
            bi9 bi9Var = this.H0;
            if (bi9Var != null && this.z0 != null) {
                if ((bi9Var == null || bi9Var.e2()) && this.z0.r1() != null && this.z0.r1().S() != null) {
                    bi9 bi9Var2 = this.H0;
                    if (bi9Var2 != null && bi9Var2.b1() != null && this.H0.b1().t()) {
                        return;
                    }
                    ie9 S = this.z0.r1().S();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!S.d() || S.a() != 2) && this.H0.T0() != null && this.H0.T0().B() != null) {
                        this.H0.T0().B().K(this.z0.K1(), this.z0.getFromForumId());
                    }
                    if (i3 > -1 && i4 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        PbFirstFloorDoubleClickAnimation pbFirstFloorDoubleClickAnimation = new PbFirstFloorDoubleClickAnimation(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.z0;
                        pbFirstFloorDoubleClickAnimation.show(findViewById, i3, i4, pbModel.b, pbModel.getForumId());
                        pbFirstFloorDoubleClickAnimation.setOnPraiseAnimatorListener(new l0(this));
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
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.h1);
            userMuteAddAndDelCustomMessage.setTag(this.h1);
            i7(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void U6(int i3, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048632, this, i3, antiData, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new w1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                h7(str);
            } else {
                this.H0.D4(str);
            }
        }
    }

    @Override // com.baidu.tieba.r06
    public void f0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048670, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.O0 = str;
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
            yj9.d(getActivity(), getPageContext(), new c1(this, sparseArray, i3, z3), new d1(this));
        }
    }

    public final void X4() {
        PbModel pbModel;
        sd9 sd9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (pbModel = this.z0) != null && (sd9Var = pbModel.G) != null && sd9Var.O() != null) {
            ThreadData O = this.z0.G.O();
            O.mRecomAbTag = this.z0.w1();
            O.mRecomWeight = this.z0.z1();
            O.mRecomSource = this.z0.y1();
            O.mRecomExtra = this.z0.x1();
            O.isSubPb = this.z0.e1();
            if (O.getFid() == 0) {
                O.setFid(JavaTypesHelper.toLong(this.z0.getForumId(), 0L));
            }
            StatisticItem i3 = fr5.i(getContext(), O, "c13562");
            TbPageTag l3 = fr5.l(getContext());
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
        if ((interceptable == null || interceptable.invokeV(1048702, this) == null) && this.B0 != null) {
            if (this.z0.r1() != null && this.z0.r1().j0()) {
                I0 = this.z0.I0(0);
            } else {
                I0 = this.z0.I0(this.H0.l1());
            }
            if (I0 == null) {
                return;
            }
            if (I0.isApp() && (I0 = this.z0.I0(this.H0.l1() + 1)) == null) {
                return;
            }
            this.H0.M3();
            this.B0.i(I0);
            if (!this.B0.e()) {
                if (this.H0 != null && (pbModel = this.z0) != null && !fk9.h(pbModel.b)) {
                    this.H0.x4();
                    fk9.b(this.z0.b);
                }
                this.B0.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.B0.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            this.f = true;
            super.onPause();
            ck9.a();
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
            bi9 bi9Var = this.H0;
            if (bi9Var != null) {
                bi9Var.F2();
            }
            if (this.W0 != null && !this.z0.e1()) {
                this.W0.O(this.z0.K1());
            }
            PbModel pbModel = this.z0;
            if (pbModel != null) {
                pbModel.t2();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            et4.w().E();
            MessageManager.getInstance().unRegisterListener(this.C1);
            J6();
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            kf5 kf5Var = this.j0;
            if (kf5Var != null) {
                kf5Var.q();
                this.j0.p();
            }
        }
    }

    public final void Z4(sd9 sd9Var, ArrayList<qba> arrayList) {
        List<qba> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048650, this, sd9Var, arrayList) == null) && sd9Var != null && sd9Var.T() != null && sd9Var.T().a != null && (list = sd9Var.T().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<qba> it = arrayList.iterator();
                while (it.hasNext()) {
                    qba next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            qba qbaVar = (qba) it2.next();
                            if (qbaVar != null && !TextUtils.isEmpty(next.S()) && !TextUtils.isEmpty(qbaVar.S()) && next.S().equals(qbaVar.S())) {
                                arrayList2.add(qbaVar);
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
        this.H0.O0(this.C0.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.I0 = true;
            if (i3 != 2 && i3 != 3) {
                if (i3 == 4 || i3 == 5) {
                    this.J0 = false;
                    this.K0 = true;
                }
            } else {
                this.J0 = true;
                this.K0 = false;
            }
            if (i3 == 2) {
                this.z0.r1().O().setIs_good(1);
                this.z0.S2(1);
            } else if (i3 == 3) {
                this.z0.r1().O().setIs_good(0);
                this.z0.S2(0);
            } else if (i3 == 4) {
                this.z0.r1().O().setIs_top(1);
                this.z0.T2(1);
            } else if (i3 == 5) {
                this.z0.r1().O().setIs_top(0);
                this.z0.T2(0);
            }
            this.H0.Q4(this.z0.r1(), this.z0.J1());
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
        n45Var.j(strArr, new o0(this));
        n45Var.g(n45.b.a);
        n45Var.h(17);
        n45Var.c(getPageContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g5(AgreeData agreeData) {
        ar5 currentVisiblePageExtra;
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
            w05Var.f = R().q1();
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
                pbModel = this.z0;
                if (pbModel == null && pbModel.r1() != null) {
                    this.e0.b(Y(), w05Var, agreeData, this.z0.r1().O());
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
        pbModel = this.z0;
        if (pbModel == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        sd9 r12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (M5() != null && ai9.D(this)) {
                M5().E4();
            }
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0907b1));
            PbModel pbModel = this.z0;
            if (pbModel != null && (r12 = pbModel.r1()) != null) {
                this.p2.c(true, 0, 3, 0, r12, "", 1);
            }
            this.a.L1().k(this.t0);
            if (f6()) {
                AbsPbActivity absPbActivity = this.a;
                if (absPbActivity instanceof PbActivity) {
                    ((PbActivity) absPbActivity).e2();
                }
            }
            PbModel pbModel2 = this.z0;
            if (pbModel2 != null && this.G.c(pbModel2.G, getContext(), this.a.findViewById(this.H0.U0()), this.z0.getForumId(), this.z0.K1())) {
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
            bi9 bi9Var = this.H0;
            if (bi9Var != null) {
                if (bi9Var.g2()) {
                    return true;
                }
                this.H0.P0();
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (ai9.y(view2)) {
                    if (view2 instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view2;
                        this.k1 = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.l1 = url;
                        if (this.k1 == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view2.getTag(R.id.tag_rich_text_image_info) != null && (view2.getTag(R.id.tag_rich_text_image_info) instanceof TbRichTextImageInfo)) {
                            this.m1 = (TbRichTextImageInfo) view2.getTag(R.id.tag_rich_text_image_info);
                        } else {
                            this.m1 = null;
                        }
                        if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.n1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.n1 = null;
                        }
                    } else if (view2 instanceof GifView) {
                        GifView gifView = (GifView) view2;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.k1 = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().getUrl())) {
                            this.l1 = gifView.getBdImage().getUrl();
                        }
                        if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.n1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.n1 = null;
                        }
                    } else if (view2 instanceof TbMemeImageView) {
                        TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                        if (tbMemeImageView.getBdImage() != null) {
                            this.k1 = tbMemeImageView.getBdImage();
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().getUrl())) {
                                this.l1 = tbMemeImageView.getBdImage().getUrl();
                            }
                            if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.n1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.n1 = null;
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
                        this.H0.p4(this.E2, this.k1.isGif());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            qba qbaVar = (qba) sparseArray.get(R.id.tag_clip_board);
            this.C2 = qbaVar;
            if (qbaVar == null) {
                return true;
            }
            if (qbaVar.I() == 1 && ai9.y(view2)) {
                this.H0.p4(this.E2, this.k1.isGif());
                return true;
            } else if (this.C2.A0() || (bw4Var = this.B0) == null) {
                return true;
            } else {
                if (bw4Var.e() && this.C2.S() != null && this.C2.S().equals(this.z0.m1())) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (R().r1() != null && R().r1().j0()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (R().r1() != null && R().r1().p0()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (R().r1() != null && R().r1().o0()) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (this.C2.I() == 1) {
                    if (!z4) {
                        this.H0.q4(this.D2, z3, false, z5, z6);
                    }
                    return true;
                }
                if (this.N0 == null) {
                    w45 w45Var = new w45(getContext());
                    this.N0 = w45Var;
                    w45Var.q(this.h2);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 != null && sparseArray != null) {
                    if (ai9.y(view2) && !z4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (ai9.y(view2) && (bdImage = this.k1) != null && !bdImage.isGif()) {
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
                        arrayList.add(new s45(1, getString(R.string.save_to_emotion), this.N0));
                    } else {
                        z17 = z16;
                        z18 = z13;
                        z19 = z14;
                    }
                    if (z8) {
                        arrayList.add(new s45(2, getString(R.string.save_to_local), this.N0));
                    }
                    if (!z7 && !z8) {
                        s45 s45Var7 = new s45(3, getString(R.string.obfuscated_res_0x7f0f04e1), this.N0);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.tag_clip_board, this.C2);
                        s45Var7.d.setTag(sparseArray3);
                        arrayList.add(s45Var7);
                    }
                    if (!z9 && !z4) {
                        if (z3) {
                            s45Var6 = new s45(4, getString(R.string.remove_mark), this.N0);
                        } else {
                            s45Var6 = new s45(4, getString(R.string.obfuscated_res_0x7f0f0c3d), this.N0);
                        }
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_clip_board, this.C2);
                        sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                        s45Var6.d.setTag(sparseArray4);
                        arrayList.add(s45Var6);
                    }
                    if (this.mIsLogin) {
                        if (!yj9.i(this.z0) && !z12 && z11) {
                            s45 s45Var8 = new s45(5, getString(R.string.obfuscated_res_0x7f0f0cfd), this.N0);
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
                            if (ai9.C(this.z0.r1(), z10) && TbadkCoreApplication.isLogin()) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            if (z20 && !z4) {
                                s45 s45Var9 = new s45(5, getString(R.string.report_text), this.N0);
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
                            if (!yj9.i(this.z0) && z18) {
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
                                    s45Var5 = new s45(6, getString(R.string.obfuscated_res_0x7f0f0546), this.N0);
                                    s45Var5.d.setTag(sparseArray6);
                                    s45Var2 = new s45(7, getString(R.string.obfuscated_res_0x7f0f0322), this.N0);
                                    s45Var2.d.setTag(sparseArray6);
                                    s45Var3 = s45Var5;
                                    s45Var = null;
                                }
                            } else {
                                sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                            }
                            s45Var5 = null;
                            s45Var2 = new s45(7, getString(R.string.obfuscated_res_0x7f0f0322), this.N0);
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
                            if (this.z0.r1().W() == 1002 && !z10) {
                                s45Var4 = new s45(6, getString(R.string.report_text), this.N0);
                            } else {
                                s45Var4 = new s45(6, getString(R.string.obfuscated_res_0x7f0f0546), this.N0);
                            }
                            s45Var4.d.setTag(sparseArray7);
                            if (z17) {
                                s45Var = new s45(13, getString(R.string.multi_delete), this.N0);
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
                        yj9.b(arrayList, this.N0, this.C2, this.z0);
                    }
                    List<s45> c4 = yj9.c(arrayList, this.C2.o(), sparseArray, this.N0);
                    yj9.l(c4, this.b);
                    yj9.e(c4);
                    this.N0.r(yj9.g(this.C2));
                    this.N0.m(c4, true);
                    this.M0 = new u45(getPageContext(), this.N0);
                    this.N0.p(new t2(this));
                    this.M0.l();
                    StatisticItem param = new StatisticItem("c13272").param("tid", this.z0.b).param("fid", this.z0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.z0.P());
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
                this.H0.k4();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            m45 m45Var = new m45(this.f1.getPageActivity());
            if (!bi.isEmpty(str)) {
                m45Var.setMessage(str);
            } else {
                m45Var.setMessage(this.f1.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            m45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c1, new f(this, userMuteAddAndDelCustomMessage));
            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new g(this));
            m45Var.create(this.f1).show();
        }
    }

    public void j5(ForumManageModel.b bVar, bi9 bi9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048688, this, bVar, bi9Var) == null) {
            List<qba> list = this.z0.r1().T().a;
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
                bi9Var.d2(this.z0.r1());
            }
        }
    }

    public final void k6(View view2, String str, String str2, qba qbaVar) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048692, this, view2, str, str2, qbaVar) == null) {
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
                    if (M5().w1() != null && qbaVar != null) {
                        if (qbaVar.e0() != null) {
                            str3 = qbaVar.e0().toString();
                        } else {
                            str3 = "";
                        }
                        M5().w1().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), qbaVar.r().getName_show(), str3));
                    }
                    if (this.z0.r1() != null && this.z0.r1().j0()) {
                        SafeHandler.getInst().postDelayed(new f1(this, str, str2), 0L);
                        return;
                    } else {
                        SafeHandler.getInst().postDelayed(new g1(this, str, str2), 200L);
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
            PbModel pbModel = this.z0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.r1() == null || str == null || i3 < 0) {
                return null;
            }
            sd9 r12 = this.z0.r1();
            if (r12.i() != null) {
                ArrayList<qba> arrayList = new ArrayList<>();
                arrayList.add(r12.i());
                tbRichText = z5(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<qba> F = r12.F();
                Z4(r12, F);
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
            sparseArray.put(bi9.o2, Integer.valueOf(bi9.p2));
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
            qj5 qj5Var = this.W0;
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
                                                    View view3 = this.f1141T;
                                                    if (view3 != null) {
                                                        view3.performClick();
                                                        return;
                                                    }
                                                    return;
                                                case 25057:
                                                    bi9 bi9Var = this.H0;
                                                    if (bi9Var != null && bi9Var.W0() != null) {
                                                        this.H0.W0().performClick();
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
                                        this.H0.O3(false);
                                        if (this.z0.r1() != null && this.z0.r1().O() != null && this.z0.r1().O().getPushStatusData() != null) {
                                            this.z0.r1().O().getPushStatusData().setStatus(2);
                                            return;
                                        }
                                        return;
                                    }
                                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                        RateManager.getInstance().notifyShare(getPageContext());
                                        s7();
                                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.G0;
                                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.linkUrl) != null) {
                                            shareSuccessReplyToServerModel.N(str, intExtra, new d2(this));
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
                                    this.H0.h4(view5);
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
                    sh9.b().k();
                    this.y0.postDelayed(new c2(this), 1000L);
                    return;
                }
                n6();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        bi9 bi9Var;
        bi9 bi9Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, bundle) == null) {
            this.n = System.currentTimeMillis();
            this.f1 = getPageContext();
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
                this.N2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.O2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.P2 = intent.getStringExtra("key_manga_title");
                this.R0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.S0 = intent.getStringExtra("high_light_post_id");
                this.T0 = intent.getBooleanExtra("key_jump_to_top", false);
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
                this.q1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                e35 e35Var = new e35();
                this.c0 = e35Var;
                e35Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.s1 = intExtra;
                if (intExtra == 0) {
                    this.s1 = intent.getIntExtra("key_start_from", 0);
                }
                this.R2 = intent.getIntExtra(PbActivityConfig.KEY_FROM_CARD_TYPE, 0);
            } else {
                this.l = System.currentTimeMillis();
            }
            this.p = this.n - this.l;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.j = 0;
            i6(bundle);
            if (this.z0.r1() != null) {
                this.z0.r1().U0(this.P);
            }
            Y5();
            if (intent != null && (bi9Var2 = this.H0) != null) {
                bi9Var2.e = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.i1 == null) {
                        this.i1 = new i0(this, intent);
                    }
                    SafeHandler.getInst().postDelayed(this.i1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.z0.r1() != null) {
                    this.z0.X2(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.i = voiceManager;
            voiceManager.onCreate(getPageContext());
            X5(bundle);
            rj5 rj5Var = new rj5();
            this.V0 = rj5Var;
            Q6(rj5Var);
            qj5 qj5Var = (qj5) this.V0.a(getActivity());
            this.W0 = qj5Var;
            qj5Var.X(this.a.getPageContext());
            this.W0.g0(this.l2);
            this.W0.h0(this.a1);
            this.W0.Z(1);
            this.W0.B(this.a.getPageContext(), bundle);
            this.W0.b().b(new wh5(getActivity()));
            this.W0.b().F(true);
            T6(true);
            this.W0.K(this.z0.T0(), this.z0.K1(), this.z0.P0());
            registerListener(this.z1);
            if (!this.z0.e1()) {
                this.W0.q(this.z0.K1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.W0.d0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.z0.a2()) {
                this.W0.d0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                bi9 bi9Var3 = this.H0;
                if (bi9Var3 != null) {
                    this.W0.d0(bi9Var3.x1());
                }
            }
            this.G = new PbGodGuideController();
            getLifecycle().addObserver(this.G);
            registerListener(this.y1);
            registerListener(this.A1);
            registerListener(this.B1);
            registerListener(this.x1);
            registerListener(this.b2);
            registerListener(this.c2);
            registerListener(this.r2);
            registerListener(this.w1);
            hba hbaVar = new hba("pb", hba.d);
            this.U0 = hbaVar;
            hbaVar.d();
            registerListener(this.H1);
            registerListener(this.R1);
            this.z0.u2();
            registerListener(this.q2);
            registerListener(this.e2);
            registerListener(this.k2);
            registerListener(this.N1);
            registerListener(this.d2);
            registerListener(this.I1);
            bi9 bi9Var4 = this.H0;
            if (bi9Var4 != null && bi9Var4.D1() != null && this.H0.B1() != null) {
                ij9 ij9Var = new ij9(getActivity(), this.H0.D1(), this.H0.B1(), this.H0.u1());
                this.e = ij9Var;
                ij9Var.t(this.Q1);
            }
            if (this.c && (bi9Var = this.H0) != null && bi9Var.B1() != null) {
                this.H0.B1().setVisibility(8);
            }
            e95 e95Var = new e95();
            this.g1 = e95Var;
            e95Var.a = 1000L;
            registerListener(this.a2);
            registerListener(this.Z1);
            registerListener(this.X1);
            registerListener(this.Y1);
            registerListener(this.K1);
            registerListener(this.L1);
            registerListener(this.D1);
            registerListener(this.E1);
            registerListener(this.F1);
            this.J1.setSelfListener(true);
            this.J1.setTag(this.a.getUniqueId());
            this.J1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.J1);
            registerResponsedEventListener(TipEvent.class, this.S1);
            registerResponsedEventListener(TopToastEvent.class, this.T1);
            this.h1 = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.h1;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.h1;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            this.U1 = new d3(this.H0, this);
            this.z0.L0().R(this.U1);
            this.L0 = new ei9();
            if (this.W0.s() != null) {
                this.L0.m(this.W0.s().i());
            }
            this.W0.W(this.b1);
            this.G0 = new ShareSuccessReplyToServerModel();
            V4(this.u1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.Y0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new j0(this));
            wk9 wk9Var = new wk9(getContext());
            this.A0 = wk9Var;
            wk9Var.b(getUniqueId());
            t9a.g().i(getUniqueId());
            l05.b().l("3", "");
            this.t1 = new bm6(getPageContext());
            this.u0 = new wj9(this, getUniqueId(), this.H0, this.z0);
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
            this.H0 = new bi9(this, this.j2, this.V1, this.i2);
            nw6 nw6Var = new nw6(getActivity());
            this.d = nw6Var;
            nw6Var.i(T2);
            this.d.d(this.L2);
            this.H0.F3(this.t2);
            this.H0.E3(this.y2);
            this.H0.y3(this.v2);
            this.H0.z3(this.w2);
            this.H0.w3(b05.c().g());
            this.H0.C3(this.A2);
            this.H0.I3(this.G2);
            this.H0.G3(this.H2);
            this.H0.D3(this.J2);
            this.H0.L4(this.mIsLogin);
            this.H0.u3(this.z0.Y1());
            if (this.a.getIntent() != null) {
                this.H0.v3(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.H0.v1().setFromForumId(this.z0.getFromForumId());
            qj5 qj5Var = this.W0;
            if (qj5Var != null) {
                this.H0.m3(qj5Var.b());
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.W0.d0(TbSingleton.getInstance().getAdVertiComment());
                } else {
                    this.W0.d0(this.H0.x1());
                }
            }
            this.H0.q3(this.g2);
            this.H0.t3(this.z0.Z0());
            this.H0.H3(this.z0.q1());
            this.u0.f(this.H0, this.z0);
            if ("1".equals(R().showReplyPanel)) {
                this.H0.H2();
            }
            return this.H0.E1();
        }
        return (View) invokeLLL.objValue;
    }

    public final TbRichText z5(ArrayList<qba> arrayList, String str, int i3) {
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
                                    this.z2 = i6;
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
        qk9 qk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            t9a.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!bi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.z0.r1().l());
                statisticItem.param("tid", this.z0.K1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.r && this.H0 != null) {
                this.r = true;
            }
            PbModel pbModel = this.z0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.z0.destory();
                if (this.z0.n1() != null) {
                    this.z0.n1().d();
                }
            }
            qj5 qj5Var = this.W0;
            if (qj5Var != null) {
                qj5Var.E();
                this.W0 = null;
            }
            ForumManageModel forumManageModel = this.C0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.Q;
            if (likeModel != null) {
                likeModel.b0();
            }
            bi9 bi9Var = this.H0;
            if (bi9Var != null) {
                bi9Var.A2();
                qk9 qk9Var2 = this.H0.k;
                if (qk9Var2 != null) {
                    qk9Var2.r();
                }
            }
            nr5 nr5Var = this.s;
            if (nr5Var != null) {
                nr5Var.c();
            }
            ij9 ij9Var = this.e;
            if (ij9Var != null) {
                ij9Var.k();
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
            bi9 bi9Var2 = this.H0;
            if (bi9Var2 != null) {
                bi9Var2.F0();
            }
            if (this.W1 != null) {
                SafeHandler.getInst().removeCallbacks(this.W1);
            }
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.h1);
            MessageManager.getInstance().unRegisterListener(this.b2);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().unRegisterListener(this.e2);
            MessageManager.getInstance().unRegisterListener(this.K1);
            MessageManager.getInstance().unRegisterListener(this.L1);
            MessageManager.getInstance().unRegisterListener(this.o2);
            MessageManager.getInstance().unRegisterListener(this.J1);
            MessageManager.getInstance().unRegisterListener(this.N1);
            MessageManager.getInstance().unRegisterListener(this.E1);
            MessageManager.getInstance().unRegisterListener(this.F1);
            MessageManager.getInstance().unRegisterListener(this.d2);
            this.f1 = null;
            this.g1 = null;
            LocationCacheData.getInstance().saveAspShowInfoInSharePref();
            if (this.i1 != null) {
                SafeHandler.getInst().removeCallbacks(this.i1);
            }
            bi9 bi9Var3 = this.H0;
            if (bi9Var3 != null && (qk9Var = bi9Var3.k) != null) {
                qk9Var.k();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.G0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            ei9 ei9Var = this.L0;
            if (ei9Var != null) {
                ei9Var.j();
            }
            PushPermissionController pushPermissionController = this.v0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.z0;
            if (pbModel2 != null && pbModel2.F0() != null) {
                this.z0.F0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.Y0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            bi9 bi9Var4 = this.H0;
            if (bi9Var4 != null) {
                bi9Var4.I4();
            }
            wj9 wj9Var = this.u0;
            if (wj9Var != null) {
                wj9Var.e();
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
                m45Var.setPositiveButton(R.string.dialog_known, new y1(this));
                m45Var.setCancelable(true);
                m45Var.create(getPageContext());
                m45Var.show();
            } else if (bVar.d != 0) {
                this.H0.O0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i4 = bVar.d;
                if (i4 == 1) {
                    ArrayList<qba> F = this.z0.r1().F();
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
                    this.z0.r1().O().setReply_num(this.z0.r1().O().getReply_num() - 1);
                    this.H0.d2(this.z0.r1());
                } else if (i4 == 0) {
                    h5();
                } else if (i4 == 2) {
                    ArrayList<qba> F2 = this.z0.r1().F();
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
                        this.H0.d2(this.z0.r1());
                    }
                    j5(bVar, this.H0);
                }
            }
        }
    }

    public void u6() {
        PbModel pbModel;
        sd9 r12;
        ThreadData O;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        sd9 sd9Var;
        boolean z8;
        boolean z9;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048746, this) == null) && (pbModel = this.z0) != null && pbModel.r1() != null && (O = (r12 = this.z0.r1()).O()) != null && O.getAuthor() != null) {
            this.H0.I1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
            lh9 lh9Var = new lh9();
            int W = this.z0.r1().W();
            if (W != 1 && W != 3) {
                lh9Var.g = false;
            } else {
                lh9Var.g = true;
                if (O.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                lh9Var.s = z3;
            }
            if (ai9.z(this.z0.r1(), W)) {
                lh9Var.h = true;
                if (O.getIs_good() == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                lh9Var.r = z9;
            } else {
                lh9Var.h = false;
            }
            if (W == 1002 && !equals) {
                lh9Var.u = true;
            }
            lh9Var.n = ai9.K(O.isBlocked(), r12.n0(), equals, W, O.isWorksInfo(), O.isScoreThread());
            lh9Var.e = ai9.I(r12, equals, r12.n0(), this.z0.V());
            lh9Var.i = Y6();
            lh9Var.f = ai9.J(this.z0.r1(), equals, this.z0.V());
            if (equals && r12.V() != null && r12.V().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            lh9Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                lh9Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            lh9Var.t = equals;
            lh9Var.q = this.z0.J1();
            lh9Var.b = true;
            lh9Var.a = ai9.C(this.z0.r1(), equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            lh9Var.p = z5;
            lh9Var.j = true;
            lh9Var.o = this.z0.U0();
            lh9Var.d = true;
            if (O.getThreadVideoInfo() == null) {
                z6 = true;
            } else {
                z6 = false;
            }
            lh9Var.c = z6;
            if (r12.j0()) {
                lh9Var.b = false;
                lh9Var.d = false;
                lh9Var.c = false;
                lh9Var.g = false;
                lh9Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !r12.j0()) {
                z7 = true;
            } else {
                z7 = false;
            }
            lh9Var.v = z7;
            if (this.H0 != null && (sd9Var = this.z0.G) != null) {
                qba X = sd9Var.X();
                if (X != null) {
                    z8 = X.f1152T;
                } else {
                    z8 = false;
                }
                lh9Var.w = z8;
            }
            lh9Var.m = true;
            if (O.isBlocked()) {
                lh9Var.n = false;
                lh9Var.g = false;
                lh9Var.h = false;
            }
            this.H0.k.x(lh9Var);
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
        sd9 r12 = this.z0.r1();
        TbRichText v7 = v7(str, i3);
        if (v7 == null || (tbRichTextData = v7.P().get(this.z2)) == null) {
            return;
        }
        eVar.f = String.valueOf(v7.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z3 = false;
        if (!tbRichTextData.V().T()) {
            eVar.h = false;
            String a4 = td9.a(tbRichTextData);
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
            imageUrlData.originalUrl = ai9.n(tbRichTextData);
            imageUrlData.originalUrl = ai9.n(tbRichTextData);
            imageUrlData.originalSize = ai9.o(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = ai9.k(tbRichTextData);
            imageUrlData.isLongPic = ai9.j(tbRichTextData);
            imageUrlData.postId = v7.getPostId();
            imageUrlData.mIsReserver = this.z0.C1();
            imageUrlData.mIsSeeHost = this.z0.U0();
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
        this.B2 = false;
        eVar.j = -1;
        if (r12.i() != null) {
            i4 = A5(r12.i().e0(), v7, i3, i3, eVar.a, eVar.b);
        } else {
            i4 = i3;
        }
        int i6 = i4;
        for (int i7 = 0; i7 < size; i7++) {
            qba qbaVar = r12.F().get(i7);
            if (qbaVar.S() == null || r12.i() == null || r12.i().S() == null || !qbaVar.S().equals(r12.i().S())) {
                i6 = A5(qbaVar.e0(), v7, i6, i3, eVar.a, eVar.b);
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
        eVar.j = i6;
    }
}
