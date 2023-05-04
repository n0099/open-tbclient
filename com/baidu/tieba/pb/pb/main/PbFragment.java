package com.baidu.tieba.pb.pb.main;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
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
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.baseEditMark.MarkData;
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
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
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
import com.baidu.tbadk.core.view.breathetip.BreatheTipWidget;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.util.PushPermissionController;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
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
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.a29;
import com.baidu.tieba.a9;
import com.baidu.tieba.az8;
import com.baidu.tieba.b15;
import com.baidu.tieba.b29;
import com.baidu.tieba.b55;
import com.baidu.tieba.b75;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cd5;
import com.baidu.tieba.cd9;
import com.baidu.tieba.cn5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cq4;
import com.baidu.tieba.ct4;
import com.baidu.tieba.cw5;
import com.baidu.tieba.cz4;
import com.baidu.tieba.cz8;
import com.baidu.tieba.d15;
import com.baidu.tieba.dq4;
import com.baidu.tieba.dt5;
import com.baidu.tieba.e15;
import com.baidu.tieba.em5;
import com.baidu.tieba.en7;
import com.baidu.tieba.ey8;
import com.baidu.tieba.ez4;
import com.baidu.tieba.f15;
import com.baidu.tieba.f55;
import com.baidu.tieba.fb5;
import com.baidu.tieba.fp9;
import com.baidu.tieba.fw5;
import com.baidu.tieba.fw8;
import com.baidu.tieba.gb5;
import com.baidu.tieba.gg;
import com.baidu.tieba.gp9;
import com.baidu.tieba.gw8;
import com.baidu.tieba.gx4;
import com.baidu.tieba.hb5;
import com.baidu.tieba.hi;
import com.baidu.tieba.hq6;
import com.baidu.tieba.hx9;
import com.baidu.tieba.i39;
import com.baidu.tieba.if5;
import com.baidu.tieba.ih6;
import com.baidu.tieba.ii;
import com.baidu.tieba.in;
import com.baidu.tieba.iq6;
import com.baidu.tieba.iw4;
import com.baidu.tieba.iw8;
import com.baidu.tieba.j05;
import com.baidu.tieba.ja5;
import com.baidu.tieba.jd5;
import com.baidu.tieba.jf5;
import com.baidu.tieba.jg;
import com.baidu.tieba.jz8;
import com.baidu.tieba.kb5;
import com.baidu.tieba.kf9;
import com.baidu.tieba.ki9;
import com.baidu.tieba.kx9;
import com.baidu.tieba.ky8;
import com.baidu.tieba.l19;
import com.baidu.tieba.l55;
import com.baidu.tieba.lf5;
import com.baidu.tieba.lg5;
import com.baidu.tieba.lx5;
import com.baidu.tieba.ly4;
import com.baidu.tieba.mf5;
import com.baidu.tieba.mn;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.n19;
import com.baidu.tieba.nz4;
import com.baidu.tieba.of5;
import com.baidu.tieba.op9;
import com.baidu.tieba.p19;
import com.baidu.tieba.p55;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pp9;
import com.baidu.tieba.pt4;
import com.baidu.tieba.py8;
import com.baidu.tieba.q15;
import com.baidu.tieba.q19;
import com.baidu.tieba.qd5;
import com.baidu.tieba.qf5;
import com.baidu.tieba.qv8;
import com.baidu.tieba.rn9;
import com.baidu.tieba.rv8;
import com.baidu.tieba.s09;
import com.baidu.tieba.s95;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.sz8;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.td5;
import com.baidu.tieba.tm;
import com.baidu.tieba.tq9;
import com.baidu.tieba.tw8;
import com.baidu.tieba.tz8;
import com.baidu.tieba.u05;
import com.baidu.tieba.uc5;
import com.baidu.tieba.ud5;
import com.baidu.tieba.uq5;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.uu8;
import com.baidu.tieba.uw8;
import com.baidu.tieba.v09;
import com.baidu.tieba.v26;
import com.baidu.tieba.v29;
import com.baidu.tieba.vd5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vp9;
import com.baidu.tieba.vr5;
import com.baidu.tieba.vw4;
import com.baidu.tieba.vx4;
import com.baidu.tieba.w05;
import com.baidu.tieba.wj5;
import com.baidu.tieba.wm5;
import com.baidu.tieba.wu8;
import com.baidu.tieba.wz8;
import com.baidu.tieba.x09;
import com.baidu.tieba.x55;
import com.baidu.tieba.xf;
import com.baidu.tieba.xw8;
import com.baidu.tieba.y09;
import com.baidu.tieba.y55;
import com.baidu.tieba.yb5;
import com.baidu.tieba.yf;
import com.baidu.tieba.ym5;
import com.baidu.tieba.yu8;
import com.baidu.tieba.yz8;
import com.baidu.tieba.z29;
import com.baidu.tieba.z8;
import com.baidu.tieba.za;
import com.baidu.tieba.za5;
import com.baidu.tieba.zc5;
import com.baidu.tieba.zl5;
import com.baidu.tieba.zq5;
import com.baidu.tieba.zr5;
import com.baidu.tieba.zx8;
import com.baidu.tieba.zz8;
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
/* loaded from: classes5.dex */
public class PbFragment extends BaseFragment implements fw5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, u05.e, TbRichTextView.u, TbPageContextSupport, z29, i39.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k Q2;
    public static final iq6.b R2;
    public transient /* synthetic */ FieldHolder $fh;
    public xf<ImageView> A;
    public ct4 A0;
    public CustomMessageListener A1;
    public pp9 A2;
    public xf<View> B;
    public ForumManageModel B0;
    public final CustomMessageListener B1;
    public final w05.c B2;
    public xf<TiebaPlusRecommendCard> C;
    public ja5 C0;
    public CustomMessageListener C1;
    public final w05.c C2;
    public xf<LinearLayout> D;
    public iw8 D0;
    public CustomMessageListener D1;
    public final AdapterView.OnItemClickListener D2;
    public xf<RelativeLayout> E;
    public PollingModel E0;
    public View.OnClickListener E1;
    public final View.OnLongClickListener E2;
    public xf<ItemCardView> F;
    public ShareSuccessReplyToServerModel F0;
    public CustomMessageListener F1;
    public final View.OnClickListener F2;
    public xf<FestivalTipView> G;
    public tz8 G0;
    public CustomMessageListener G1;
    public final ItemCardHelper.c G2;
    public boolean H;
    public boolean H0;
    public CustomMessageListener H1;
    public final NoNetworkView.b H2;
    public boolean I;
    public boolean I0;
    public CustomMessageListener I1;
    public View.OnTouchListener I2;
    public boolean J;
    public boolean J0;
    public CustomMessageListener J1;
    public hq6.b J2;
    public xf<GifView> K;
    public wz8 K0;
    public SuggestEmotionModel.c K1;
    public final ky8.b K2;
    public String L;
    public d15 L0;
    public CustomMessageListener L1;
    public int L2;
    public boolean M;
    public f15 M0;
    public GetSugMatchWordsModel.b M1;
    public int M2;
    public boolean N;
    public String N0;
    public PraiseModel N1;
    public String N2;
    public String O;
    public boolean O0;
    public y09.h O1;
    public vx4 O2;
    public LikeModel P;
    public boolean P0;
    public CustomMessageListener P1;
    public int P2;
    public View Q;
    public boolean Q0;
    public wj5 Q1;
    public View R;
    public String R0;
    public wj5 R1;
    public View S;
    public boolean S0;
    public CheckRealNameModel.b S1;
    public View T;
    public gp9 T0;
    public uw8 T1;
    public String U;
    public of5 U0;
    public final Runnable U1;
    public int V;
    public mf5 V0;
    public CustomMessageListener V1;
    public boolean W;
    public PermissionJudgePolicy W0;
    public CustomMessageListener W1;
    public int[] X;
    public ReplyPrivacyCheckController X0;
    public CustomMessageListener X1;
    public int Y;
    public jf5 Y0;
    public CustomMessageListener Y1;
    public int Z;
    public if5 Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public int a0;
    public if5 a1;
    public CustomMessageListener a2;
    public boolean b;
    public nz4 b0;
    public int b1;
    public CustomMessageListener b2;
    public boolean c;
    public BdUniqueId c0;
    public Object c1;
    public CustomMessageListener c2;
    public iq6 d;
    public b55 d0;
    public a9 d1;
    public u05.e d2;
    public y09 e;
    public boolean e0;
    public l55 e1;
    public g3 e2;
    public boolean f;
    public boolean f0;
    public BdUniqueId f1;
    public f15.f f2;
    public boolean g;
    public Object g0;
    public Runnable g1;
    public final SortSwitchButton.f g2;
    public boolean h;
    public fp9 h0;
    public yz8 h1;
    public final View.OnClickListener h2;
    public VoiceManager i;
    public gb5 i0;
    public tm i1;
    public CustomMessageListener i2;
    public int j;
    public boolean j0;
    public String j1;
    public final NewWriteModel.d j2;
    public w05 k;
    public TbRichTextImageInfo k1;
    public Boolean k2;
    public long l;
    public TbRichTextMemeInfo l1;
    public NewWriteModel.d l2;
    public long m;
    public boolean m1;
    public za m2;
    public long n;
    public int n1;
    public final PbModel.h n2;
    public long o;
    public int o1;
    public CustomMessageListener o2;
    public long p;
    public List<e3> p1;
    public HttpMessageListener p2;
    public boolean q;
    public int q1;
    public final ct4.a q2;
    public boolean r;
    public boolean r0;
    public ih6 r1;
    public final AbsListView.OnScrollListener r2;
    public wm5 s;
    @NonNull
    public TiePlusEventController.g s0;
    public final e3 s1;
    public final z8 s2;
    public long t;
    public l19 t0;
    public final az8.b t1;
    public final p55.g t2;
    public boolean u;
    public PushPermissionController u0;
    public final CustomMessageListener u1;
    public final View.OnClickListener u2;
    public long v;
    public boolean v0;
    public CustomMessageListener v1;
    public boolean v2;
    public int w;
    public PbInterviewStatusView.f w0;
    public CustomMessageListener w1;
    public final BdListView.p w2;
    public String x;
    public final Handler x0;
    public CustomMessageListener x1;
    public int x2;
    public xf<TextView> y;
    public PbModel y0;
    public CustomMessageListener y1;
    public final TbRichTextView.a0 y2;
    public xf<TbImageView> z;
    public b29 z0;
    public CustomMessageListener z1;
    public boolean z2;

    /* loaded from: classes5.dex */
    public interface e3 {
        boolean onBackPressed();
    }

    /* loaded from: classes5.dex */
    public interface g3 {
        void a(Object obj);
    }

    @Override // com.baidu.tieba.z29
    public AbsVideoPbFragment N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return null;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fw5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048647, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i d1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048664, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fw5
    public void g1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048676, this, context, str) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048725, this, view2, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z29
    public PbFragment x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
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
                    xw8.a(this.b.a.getPageContext(), this.a).show();
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
                jg.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes5.dex */
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
                wz8 wz8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (wz8Var = this.a.c.K0) != null && wz8Var.g() != null) {
                    if (!this.a.c.K0.g().e()) {
                        this.a.c.K0.b(false);
                    }
                    this.a.c.K0.g().l(false);
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
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int j = ii.j(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = ii.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = j / 2;
                    g = ii.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = j - (i + g);
                PbFragment pbFragment = this.c;
                boolean z = true;
                int i3 = (pbFragment.X[1] + pbFragment.Y) - i2;
                if (pbFragment.G0 != null && this.c.G0.W0() != null) {
                    this.c.G0.W0().smoothScrollBy(i3, 50);
                }
                if (this.c.I5().g1() != null) {
                    if (this.c.V0 != null) {
                        this.c.V0.b().setVisibility(8);
                    }
                    this.c.I5().g1().t(this.a, this.b, this.c.I5().h1(), (this.c.y0 == null || this.c.y0.z1() == null || this.c.y0.z1().M() == null || !this.c.y0.z1().M().isBjh()) ? false : false);
                    qf5 f = this.c.I5().g1().f();
                    if (f != null && this.c.y0 != null && this.c.y0.z1() != null) {
                        f.H(this.c.y0.z1().c());
                        f.d0(this.c.y0.z1().M());
                    }
                    if (this.c.K0.f() == null && this.c.I5().g1().f().u() != null) {
                        this.c.I5().g1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.K0.n(pbFragment2.I5().g1().f().u().i());
                        this.c.I5().g1().f().N(this.c.a1);
                    }
                }
                this.c.I5().q1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes5.dex */
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
                wz8 wz8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (wz8Var = this.a.c.K0) != null && wz8Var.g() != null) {
                    if (!this.a.c.K0.g().e()) {
                        this.a.c.K0.b(false);
                    }
                    this.a.c.K0.g().l(false);
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
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int j = ii.j(this.c.getContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                } else {
                    i = j / 2;
                    g = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                }
                int i2 = j - (i + g);
                PbFragment pbFragment = this.c;
                boolean z = true;
                int i3 = (pbFragment.X[1] + pbFragment.Y) - i2;
                if (pbFragment.G0 != null && this.c.G0.W0() != null) {
                    this.c.G0.W0().smoothScrollBy(i3, 50);
                }
                if (this.c.I5().g1() != null) {
                    if (this.c.V0 != null) {
                        this.c.V0.b().setVisibility(8);
                    }
                    this.c.I5().g1().t(this.a, this.b, this.c.I5().h1(), (this.c.y0 == null || this.c.y0.z1() == null || this.c.y0.z1().M() == null || !this.c.y0.z1().M().isBjh()) ? false : false);
                    qf5 f = this.c.I5().g1().f();
                    if (f != null && this.c.y0 != null && this.c.y0.z1() != null) {
                        f.H(this.c.y0.z1().c());
                        f.d0(this.c.y0.z1().M());
                    }
                    if (this.c.K0.f() == null && this.c.I5().g1().f().u() != null) {
                        this.c.I5().g1().f().u().g(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.K0.n(pbFragment2.I5().g1().f().u().i());
                        this.c.I5().g1().f().N(this.c.a1);
                    }
                }
                this.c.I5().q1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: Code restructure failed: missing block: B:759:0x1e02, code lost:
            r4 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:783:0x1eb6, code lost:
            if ((r32.a.G0.b1.a.getView().getTop() - r32.a.G0.h.a.getBottom()) < (r32.a.G0.b1.a.g.getHeight() + 10)) goto L759;
         */
        /* JADX WARN: Removed duplicated region for block: B:1036:0x27c3  */
        /* JADX WARN: Removed duplicated region for block: B:1037:0x27d9  */
        /* JADX WARN: Removed duplicated region for block: B:1040:0x2815  */
        /* JADX WARN: Removed duplicated region for block: B:1282:0x31bc  */
        /* JADX WARN: Removed duplicated region for block: B:1283:0x31c1  */
        /* JADX WARN: Removed duplicated region for block: B:1286:0x31d0  */
        /* JADX WARN: Removed duplicated region for block: B:1320:0x327e  */
        /* JADX WARN: Removed duplicated region for block: B:1323:0x328d  */
        /* JADX WARN: Removed duplicated region for block: B:1326:0x32a0  */
        /* JADX WARN: Removed duplicated region for block: B:1329:0x32b1  */
        /* JADX WARN: Removed duplicated region for block: B:1332:0x32c7  */
        /* JADX WARN: Removed duplicated region for block: B:1334:0x32d0  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view2) {
            qv8 z1;
            int i;
            int i2;
            pp9 V;
            StatisticItem statisticItem;
            SparseArray sparseArray;
            b15 b15Var;
            b15 b15Var2;
            b15 b15Var3;
            String string;
            boolean z;
            b15 b15Var4;
            b15 b15Var5;
            b15 b15Var6;
            b15 b15Var7;
            String name;
            boolean z2;
            int i3;
            int i4;
            j05 j05Var;
            String jumpUrlWithTid;
            String[] strArr;
            int i5;
            int i6;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null || !this.a.isAdded()) {
                return;
            }
            if (this.a.r0 && (view2 == this.a.G0.h.e || view2 == this.a.G0.h.f || view2.getId() == R.id.obfuscated_res_0x7f0919f4 || view2.getId() == R.id.obfuscated_res_0x7f090b12 || view2.getId() == R.id.obfuscated_res_0x7f091da5 || view2.getId() == R.id.obfuscated_res_0x7f091991)) {
                return;
            }
            if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                if (view2 == this.a.G0.Z0() && this.a.getPageContext().getPageActivity() != null && this.a.y0 != null) {
                    this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.y0.S1(), this.a.y0.k2(), this.a.y0.j2())));
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("fid", this.a.y0.getForumId());
                    statisticItem2.param("fname", this.a.y0.Y0());
                    statisticItem2.param("tid", this.a.y0.S1());
                    TiebaStatic.log(statisticItem2);
                }
                if (view2 == this.a.G0.b1()) {
                    if (!this.a.h && this.a.y0.v2(true)) {
                        this.a.h = true;
                        this.a.G0.p3();
                    }
                } else if (this.a.G0.h.h() != null && view2 == this.a.G0.h.h().E()) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.showToast(R.string.network_not_available);
                        return;
                    }
                    this.a.G0.t0();
                    this.a.g7();
                    this.a.G0.o3();
                    this.a.G0.J3();
                    if (this.a.G0.e1() != null) {
                        this.a.G0.e1().setVisibility(8);
                    }
                    this.a.y0.l3(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                } else if (this.a.G0.h.h() == null || view2 != this.a.G0.h.h().x()) {
                    if (view2 == this.a.G0.h.h) {
                        if (this.a.G0.h0(this.a.y0.m1())) {
                            this.a.g7();
                            return;
                        }
                        ii.z(this.a.a, this.a.G0.h.h);
                        this.a.a.finish();
                    } else if (view2 == this.a.G0.I0() || (this.a.G0.h.h() != null && (view2 == this.a.G0.h.h().F() || view2 == this.a.G0.h.h().G()))) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                        } else if (this.a.y0.z1() != null && !this.a.B0.o0()) {
                            this.a.G0.t0();
                            int i7 = (this.a.G0.h.h() == null || view2 != this.a.G0.h.h().G()) ? (this.a.G0.h.h() == null || view2 != this.a.G0.h.h().F()) ? view2 == this.a.G0.I0() ? 2 : 0 : this.a.y0.z1().M().getIs_good() == 1 ? 3 : 6 : this.a.y0.z1().M().getIs_top() == 1 ? 5 : 4;
                            ForumData k = this.a.y0.z1().k();
                            String name3 = k.getName();
                            String id = k.getId();
                            String id2 = this.a.y0.z1().M().getId();
                            this.a.G0.e4();
                            this.a.B0.s0(id, name3, id2, i7, this.a.G0.J0());
                        }
                    } else if (view2 == this.a.G0.P0()) {
                        if (this.a.y0 != null) {
                            pt4.s(this.a.getPageContext().getPageActivity(), this.a.y0.z1().M().getTopicData().b());
                        }
                    } else if (view2 == this.a.G0.h.e) {
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                        if (this.a.y0.z1() != null && this.a.y0.z1().M() != null && this.a.y0.z1().M().isVideoThreadType() && this.a.y0.z1().M().getThreadVideoInfo() != null) {
                            TiebaStatic.log(new StatisticItem("c11922"));
                        }
                        if (this.a.y0.getErrorNo() == 4) {
                            if (!StringUtils.isNull(this.a.y0.Y0()) || this.a.y0.P0() == null) {
                                this.a.a.finish();
                                return;
                            }
                            name2 = this.a.y0.P0().b;
                        } else {
                            name2 = this.a.y0.z1().k().getName();
                        }
                        if (StringUtils.isNull(name2)) {
                            this.a.a.finish();
                            return;
                        }
                        String Y0 = this.a.y0.Y0();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                        if (!this.a.y0.e1() || Y0 == null || !Y0.equals(name2)) {
                            this.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
                        } else {
                            this.a.a.finish();
                        }
                    } else if (view2 == this.a.G0.h.f) {
                        if (uq5.a()) {
                            return;
                        }
                        if (this.a.y0 == null || this.a.y0.z1() == null) {
                            ii.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ed9));
                            return;
                        }
                        ArrayList<pp9> F = this.a.y0.z1().F();
                        if ((F == null || F.size() <= 0) && this.a.y0.R1()) {
                            ii.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ed9));
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.y0.S1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.y0.getForumId()));
                        this.a.G0.M2();
                        this.a.p6();
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0919b5) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.G0.Z2(true);
                        this.a.G0.M2();
                        if (this.a.h) {
                            return;
                        }
                        this.a.h = true;
                        this.a.G0.T3();
                        this.a.g7();
                        this.a.G0.o3();
                        this.a.y0.p3(this.a.v5());
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09198c) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            return;
                        }
                        this.a.G0.t0();
                        if (view2.getId() != R.id.obfuscated_res_0x7f09198c || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                            if (sz8.b(this.a.getPageContext(), 11009) && this.a.y0.Q0(this.a.G0.V0()) != null) {
                                this.a.i6();
                                if (this.a.y0.z1() != null && this.a.y0.z1().M() != null && this.a.y0.z1().M().getAuthor() != null) {
                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", this.a.y0.z1().l()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                }
                                if (this.a.y0.z1().M() == null || this.a.y0.z1().M().getAuthor() == null || this.a.y0.z1().M().getAuthor().getUserId() == null || this.a.A0 == null) {
                                    return;
                                }
                                int u = sz8.u(this.a.y0.z1());
                                ThreadData M = this.a.y0.z1().M();
                                if (M.isBJHArticleThreadType()) {
                                    i6 = 2;
                                } else if (M.isBJHVideoThreadType()) {
                                    i6 = 3;
                                } else if (M.isBJHNormalThreadType()) {
                                    i6 = 4;
                                } else {
                                    i6 = M.isBJHVideoDynamicThreadType() ? 5 : 1;
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.y0.b).param("obj_locate", 1).param("obj_id", this.a.y0.z1().M().getAuthor().getUserId()).param("obj_type", !this.a.A0.e()).param("obj_source", u).param("obj_param1", i6));
                                return;
                            }
                            return;
                        }
                        this.a.T = view2;
                    } else if ((this.a.G0.h.h() != null && view2 == this.a.G0.h.h().C()) || view2.getId() == R.id.obfuscated_res_0x7f090b12 || view2.getId() == R.id.obfuscated_res_0x7f091da5) {
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            view2.setTag(Boolean.FALSE);
                            return;
                        }
                        this.a.G0.t0();
                        if (this.a.G0.h.h() != null && view2 == this.a.G0.h.h().C()) {
                            this.a.G0.M2();
                        }
                        if (this.a.h) {
                            view2.setTag(Boolean.FALSE);
                            return;
                        }
                        this.a.g7();
                        this.a.G0.o3();
                        boolean q3 = view2.getId() == R.id.obfuscated_res_0x7f090b12 ? this.a.y0.q3(true, this.a.v5()) : view2.getId() == R.id.obfuscated_res_0x7f091da5 ? this.a.y0.q3(false, this.a.v5()) : this.a.y0.p3(this.a.v5());
                        view2.setTag(Boolean.valueOf(q3));
                        if (q3) {
                            i5 = 1;
                            this.a.G0.Z2(true);
                            this.a.G0.T3();
                            this.a.h = true;
                            this.a.G0.d3(true);
                        } else {
                            i5 = 1;
                        }
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i5, new Object[0]);
                    } else if (this.a.G0.h.h() == null || view2 != this.a.G0.h.h().y()) {
                        if (view2.getId() == R.id.share_num_container) {
                            if (sz8.b(this.a.getPageContext(), 11009)) {
                                sz8.v(this.a.getContext(), 3, this.a.r5(), this.a.y0);
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091991 || view2.getId() == R.id.share_more_container) {
                            if ((!ShareSwitch.isOn() && !this.a.checkUpIsLogin()) || (z1 = this.a.y0.z1()) == null) {
                                return;
                            }
                            ThreadData M2 = z1.M();
                            if (M2 != null && M2.getAuthor() != null) {
                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", z1.l()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
                            }
                            if (M2 != null) {
                                if (M2.isBJHArticleThreadType()) {
                                    i = 2;
                                } else if (M2.isBJHVideoThreadType()) {
                                    i = 3;
                                } else if (M2.isBJHNormalThreadType()) {
                                    i = 4;
                                } else if (M2.isBJHVideoDynamicThreadType()) {
                                    i = 5;
                                }
                                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                statisticItem3.param("tid", this.a.y0.S1());
                                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem3.param("fid", this.a.y0.getForumId());
                                if (view2.getId() != R.id.share_num_container) {
                                    statisticItem3.param("obj_locate", 5);
                                } else {
                                    statisticItem3.param("obj_locate", 6);
                                }
                                statisticItem3.param("obj_name", i);
                                statisticItem3.param("obj_type", 1);
                                if (M2 != null) {
                                    if (M2.isBJHArticleThreadType()) {
                                        statisticItem3.param("obj_type", 10);
                                    } else if (M2.isBJHVideoThreadType()) {
                                        statisticItem3.param("obj_type", 9);
                                    } else if (M2.isBJHVideoDynamicThreadType()) {
                                        statisticItem3.param("obj_type", 8);
                                    } else if (M2.isBJHNormalThreadType()) {
                                        statisticItem3.param("obj_type", 7);
                                    } else if (M2.isShareThread) {
                                        statisticItem3.param("obj_type", 6);
                                    } else {
                                        int i8 = M2.threadType;
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
                                            statisticItem3.param("card_type", M2.getRecomCardType());
                                            statisticItem3.param("recom_source", M2.mRecomSource);
                                            statisticItem3.param("ab_tag", M2.mRecomAbTag);
                                            statisticItem3.param("weight", M2.mRecomWeight);
                                            statisticItem3.param("extra", M2.mRecomExtra);
                                            statisticItem3.param("nid", M2.getNid());
                                            if (M2.getBaijiahaoData() != null && !hi.isEmpty(M2.getBaijiahaoData().oriUgcVid)) {
                                                statisticItem3.param(TiebaStatic.Params.OBJ_PARAM6, M2.getBaijiahaoData().oriUgcVid);
                                            }
                                        }
                                    }
                                    statisticItem3.param("card_type", M2.getRecomCardType());
                                    statisticItem3.param("recom_source", M2.mRecomSource);
                                    statisticItem3.param("ab_tag", M2.mRecomAbTag);
                                    statisticItem3.param("weight", M2.mRecomWeight);
                                    statisticItem3.param("extra", M2.mRecomExtra);
                                    statisticItem3.param("nid", M2.getNid());
                                    if (M2.getBaijiahaoData() != null) {
                                        statisticItem3.param(TiebaStatic.Params.OBJ_PARAM6, M2.getBaijiahaoData().oriUgcVid);
                                    }
                                }
                                if (!hi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                }
                                if (this.a.R() != null) {
                                    em5.e(this.a.R(), statisticItem3);
                                }
                                if (this.a.G0 != null) {
                                    statisticItem3.param("obj_param1", this.a.G0.S0());
                                }
                                TiebaStatic.log(statisticItem3);
                                if (ii.F()) {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d30);
                                    return;
                                } else if (z1 == null) {
                                    ii.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ed9));
                                    return;
                                } else {
                                    ArrayList<pp9> F2 = this.a.y0.z1().F();
                                    if ((F2 == null || F2.size() <= 0) && this.a.y0.R1()) {
                                        ii.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ed9));
                                        return;
                                    }
                                    this.a.G0.t0();
                                    this.a.g7();
                                    if (z1.A() != null && !StringUtils.isNull(z1.A().a(), true)) {
                                        TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.y0.z1().l()));
                                    }
                                    TiebaStatic.log(new StatisticItem("c11939"));
                                    if (AntiHelper.e(this.a.getContext(), M2)) {
                                        return;
                                    }
                                    if (this.a.G0 != null) {
                                        this.a.G0.v0();
                                        this.a.G0.l4(z1);
                                    }
                                    if (ShareSwitch.isOn()) {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091991) {
                                            i2 = 2;
                                        } else {
                                            i2 = view2.getId() == R.id.share_num_container ? 1 : 6;
                                        }
                                        if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.a.G0.U1() && !z1.n0()) {
                                            if (!UbsABTestHelper.isPbSharePathTestA()) {
                                                if (za5.c() > 0) {
                                                    sz8.H(this.a.getContext(), this.a.y0.z1());
                                                    return;
                                                }
                                                int S0 = this.a.G0.S0();
                                                this.a.G0.g0();
                                                this.a.T5(za5.a(), S0);
                                                return;
                                            }
                                            this.a.a7(i2);
                                            return;
                                        }
                                        this.a.a7(i2);
                                        return;
                                    }
                                    this.a.G0.J3();
                                    this.a.y0.T0().X(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                    return;
                                }
                            }
                            i = 1;
                            StatisticItem statisticItem32 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                            statisticItem32.param("tid", this.a.y0.S1());
                            statisticItem32.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem32.param("fid", this.a.y0.getForumId());
                            if (view2.getId() != R.id.share_num_container) {
                            }
                            statisticItem32.param("obj_name", i);
                            statisticItem32.param("obj_type", 1);
                            if (M2 != null) {
                            }
                            if (!hi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            }
                            if (this.a.R() != null) {
                            }
                            if (this.a.G0 != null) {
                            }
                            TiebaStatic.log(statisticItem32);
                            if (ii.F()) {
                            }
                        } else if (this.a.G0.h.h() == null || view2 != this.a.G0.h.h().D()) {
                            if (this.a.G0.h.h() == null || view2 != this.a.G0.h.h().K()) {
                                if (this.a.G0.h.h() == null || view2 != this.a.G0.h.h().J()) {
                                    if (this.a.G0.h.h() != null && view2 == this.a.G0.h.h().H()) {
                                        int skinType = TbadkCoreApplication.getInst().getSkinType();
                                        UtilHelper.showSkinChangeAnimation(this.a.getActivity());
                                        this.a.onChangeSkinType(skinType);
                                        UtilHelper.setNavigationBarBackground(this.a.getActivity(), this.a.getResources().getColor(R.color.CAM_X0201_2));
                                        if (skinType == 0) {
                                            TbadkCoreApplication.getInst().setSkinType(4);
                                        } else {
                                            f55.m().w("key_is_follow_system_mode", false);
                                            SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                        }
                                        this.a.G0.h.f();
                                        return;
                                    } else if (this.a.G0.T0() == view2) {
                                        if (!this.a.G0.T0().getIndicateStatus()) {
                                            vp9.d("c10725", null);
                                        } else {
                                            qv8 z12 = this.a.y0.z1();
                                            if (z12 != null && z12.M() != null && z12.M().getTaskInfoData() != null) {
                                                String e = z12.M().getTaskInfoData().e();
                                                if (StringUtils.isNull(e)) {
                                                    e = z12.M().getTaskInfoData().h();
                                                }
                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", e));
                                            }
                                        }
                                        this.a.L5();
                                        return;
                                    } else if (this.a.G0.h.h() != null && view2 == this.a.G0.h.h().A()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        this.a.G0.t0();
                                        SparseArray<Object> X0 = this.a.G0.X0(this.a.y0.z1(), this.a.y0.R1(), 1);
                                        if (X0 == null) {
                                            return;
                                        }
                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.y0.z1().k().getId(), this.a.y0.z1().k().getName(), this.a.y0.z1().M().getId(), StringUtils.string(this.a.y0.z1().T().getUserId()), StringUtils.string(X0.get(R.id.tag_forbid_user_name)), StringUtils.string(X0.get(R.id.tag_forbid_user_name_show)), StringUtils.string(X0.get(R.id.tag_forbid_user_post_id)), StringUtils.string(X0.get(R.id.tag_forbid_user_portrait)))));
                                        return;
                                    } else if (this.a.G0.h.h() != null && view2 == this.a.G0.h.h().u()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        SparseArray<Object> X02 = this.a.G0.X0(this.a.y0.z1(), this.a.y0.R1(), 1);
                                        if (X02 != null) {
                                            this.a.G0.t2(((Integer) X02.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(X02.get(R.id.tag_del_post_id)), ((Integer) X02.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) X02.get(R.id.tag_del_post_is_self)).booleanValue());
                                        }
                                        this.a.G0.h.e();
                                        if (this.a.Q() == null || this.a.Q().z1() == null || this.a.Q().z1().M() == null) {
                                            return;
                                        }
                                        ThreadData M3 = this.a.Q().z1().M();
                                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                        statisticItem4.param("tid", M3.getId());
                                        statisticItem4.param("fid", M3.getFid());
                                        statisticItem4.param("fname", M3.getForum_name());
                                        TiebaStatic.log(statisticItem4);
                                        StatisticItem statisticItem5 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                        statisticItem5.param("tid", M3.getId());
                                        statisticItem5.param("fid", M3.getFid());
                                        statisticItem5.param("fname", M3.getForum_name());
                                        statisticItem5.param("obj_source", 3);
                                        TiebaStatic.log(statisticItem5);
                                        return;
                                    } else if (this.a.G0.h.h() != null && view2 == this.a.G0.h.h().z()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        SparseArray<Object> X03 = this.a.G0.X0(this.a.y0.z1(), this.a.y0.R1(), 1);
                                        if (X03 != null) {
                                            if (StringUtils.isNull((String) X03.get(R.id.tag_del_multi_forum))) {
                                                this.a.G0.q2(((Integer) X03.get(R.id.tag_del_post_type)).intValue(), StringUtils.string(X03.get(R.id.tag_del_post_id)), ((Integer) X03.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) X03.get(R.id.tag_del_post_is_self)).booleanValue());
                                            } else {
                                                this.a.G0.r2(((Integer) X03.get(R.id.tag_del_post_type)).intValue(), (String) X03.get(R.id.tag_del_post_id), ((Integer) X03.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) X03.get(R.id.tag_del_post_is_self)).booleanValue(), StringUtils.string(X03.get(R.id.tag_del_multi_forum)));
                                            }
                                        }
                                        this.a.G0.h.e();
                                        return;
                                    } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f09217e && view2.getId() != R.id.obfuscated_res_0x7f0919a5 && view2.getId() != R.id.obfuscated_res_0x7f091835) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091a07) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091a05 && view2.getId() != R.id.obfuscated_res_0x7f091bdd && view2.getId() != R.id.obfuscated_res_0x7f09199f) {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f0919a3) {
                                                    try {
                                                        sparseArray = (SparseArray) view2.getTag();
                                                    } catch (ClassCastException e2) {
                                                        e2.printStackTrace();
                                                        sparseArray = null;
                                                    }
                                                    pp9 pp9Var = (pp9) sparseArray.get(R.id.tag_clip_board);
                                                    if (pp9Var == null) {
                                                        return;
                                                    }
                                                    if (this.a.M0 == null) {
                                                        PbFragment pbFragment = this.a;
                                                        pbFragment.M0 = new f15(pbFragment.getContext());
                                                        this.a.M0.p(this.a.f2);
                                                    }
                                                    ArrayList arrayList = new ArrayList();
                                                    boolean z3 = this.a.Q().z1() != null && this.a.Q().z1().h0();
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
                                                    if (pp9Var.n() != null) {
                                                        boolean z4 = pp9Var.n().hasAgree;
                                                        int o = pp9Var.o();
                                                        if (z4 && o == 5) {
                                                            string = this.a.getString(R.string.action_cancel_dislike);
                                                        } else {
                                                            string = this.a.getString(R.string.action_dislike);
                                                        }
                                                        b15 b15Var8 = new b15(8, string, this.a.M0);
                                                        SparseArray sparseArray2 = new SparseArray();
                                                        sparseArray2.put(R.id.tag_clip_board, pp9Var);
                                                        b15Var8.d.setTag(sparseArray2);
                                                        arrayList.add(b15Var8);
                                                    }
                                                    if (this.a.mIsLogin) {
                                                        if (!n19.j(this.a.y0) && !booleanValue3 && booleanValue2) {
                                                            b15 b15Var9 = new b15(5, this.a.getString(R.string.obfuscated_res_0x7f0f0c11), this.a.M0);
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
                                                            b15Var9.d.setTag(sparseArray3);
                                                            arrayList.add(b15Var9);
                                                        } else if ((sz8.A(this.a.y0.z1(), booleanValue) && TbadkCoreApplication.isLogin()) && !z3) {
                                                            b15 b15Var10 = new b15(5, this.a.getString(R.string.report_text), this.a.M0);
                                                            b15Var10.d.setTag(str);
                                                            arrayList.add(b15Var10);
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
                                                                    b15 b15Var11 = new b15(6, this.a.getString(R.string.obfuscated_res_0x7f0f04e3), this.a.M0);
                                                                    b15Var11.d.setTag(sparseArray4);
                                                                    b15Var2 = b15Var11;
                                                                    b15Var = new b15(7, this.a.getString(R.string.obfuscated_res_0x7f0f02ef), this.a.M0);
                                                                    b15Var.d.setTag(sparseArray4);
                                                                }
                                                            } else {
                                                                sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                            }
                                                            b15Var2 = null;
                                                            b15Var = new b15(7, this.a.getString(R.string.obfuscated_res_0x7f0f02ef), this.a.M0);
                                                            b15Var.d.setTag(sparseArray4);
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
                                                            if (this.a.y0.z1().U() == 1002 && !booleanValue) {
                                                                b15Var3 = new b15(6, this.a.getString(R.string.report_text), this.a.M0);
                                                            } else {
                                                                b15Var3 = new b15(6, this.a.getString(R.string.obfuscated_res_0x7f0f04e3), this.a.M0);
                                                            }
                                                            b15Var3.d.setTag(sparseArray5);
                                                            b15Var2 = b15Var3;
                                                            b15Var = null;
                                                        } else {
                                                            b15Var = null;
                                                            b15Var2 = null;
                                                        }
                                                        if (b15Var2 != null) {
                                                            arrayList.add(b15Var2);
                                                        }
                                                        if (b15Var != null) {
                                                            arrayList.add(b15Var);
                                                        }
                                                    }
                                                    this.a.M0.k(arrayList);
                                                    this.a.L0 = new d15(this.a.getPageContext(), this.a.M0);
                                                    this.a.L0.k();
                                                    return;
                                                } else if (view2 == this.a.G0.R0()) {
                                                    if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                        this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, gg.g(this.a.y0.z1().l(), 0L), gg.g(this.a.y0.S1(), 0L), gg.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.y0.z1().M().getPushStatusData())));
                                                        return;
                                                    }
                                                    return;
                                                } else if (this.a.G0.h.h() == null || view2 != this.a.G0.h.h().I()) {
                                                    if (this.a.G0.h.h() != null && view2 == this.a.G0.h.h().B()) {
                                                        TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                        if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.y0.S1())) == null) {
                                                            return;
                                                        }
                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                        this.a.G0.h.e();
                                                        TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                        return;
                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f090834 && view2.getId() != R.id.obfuscated_res_0x7f090b0f) {
                                                        int id3 = view2.getId();
                                                        if (id3 == R.id.pb_u9_text_view) {
                                                            if (!this.a.checkUpIsLogin() || (j05Var = (j05) view2.getTag()) == null || StringUtils.isNull(j05Var.s1())) {
                                                                return;
                                                            }
                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{j05Var.s1()});
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091da8 || id3 == R.id.cover_reply_content || id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                            if (this.a.checkUpIsLogin()) {
                                                                TiebaStatic.log(new StatisticItem("c11740"));
                                                                if (view2 == null || view2.getTag() == null) {
                                                                    return;
                                                                }
                                                                SparseArray sparseArray6 = (SparseArray) view2.getTag();
                                                                pp9 pp9Var2 = (pp9) sparseArray6.get(R.id.tag_load_sub_data);
                                                                if (id3 == R.id.replybtn_top_right || id3 == R.id.cover_reply_content_top_right) {
                                                                    TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.y0.b));
                                                                }
                                                                if (this.a.M0 == null) {
                                                                    PbFragment pbFragment2 = this.a;
                                                                    pbFragment2.M0 = new f15(pbFragment2.getContext());
                                                                    this.a.M0.p(this.a.f2);
                                                                }
                                                                ArrayList arrayList2 = new ArrayList();
                                                                boolean booleanValue7 = sparseArray6.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue() : false;
                                                                boolean booleanValue8 = sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                boolean booleanValue9 = sparseArray6.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                                                                boolean booleanValue10 = sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                                                                boolean booleanValue11 = sparseArray6.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                                                                String str2 = sparseArray6.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray6.get(R.id.tag_forbid_user_post_id) : null;
                                                                boolean booleanValue12 = sparseArray6.get(R.id.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.tag_is_self_post)).booleanValue() : false;
                                                                if (pp9Var2 != null) {
                                                                    if (pp9Var2.a0() != null && pp9Var2.a0().toString().length() > 0) {
                                                                        b15 b15Var12 = new b15(3, this.a.getString(R.string.obfuscated_res_0x7f0f0481), this.a.M0);
                                                                        SparseArray sparseArray7 = new SparseArray();
                                                                        sparseArray7.put(R.id.tag_clip_board, pp9Var2);
                                                                        b15Var12.d.setTag(sparseArray7);
                                                                        arrayList2.add(b15Var12);
                                                                    }
                                                                    this.a.A2 = pp9Var2;
                                                                }
                                                                if (this.a.y0.z1().q()) {
                                                                    String u2 = this.a.y0.z1().u();
                                                                    if (pp9Var2 != null && !hi.isEmpty(u2) && u2.equals(pp9Var2.N())) {
                                                                        z = true;
                                                                        if (!z) {
                                                                            b15Var4 = new b15(4, this.a.getString(R.string.remove_mark), this.a.M0);
                                                                        } else {
                                                                            b15Var4 = new b15(4, this.a.getString(R.string.obfuscated_res_0x7f0f0b6d), this.a.M0);
                                                                        }
                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                        sparseArray8.put(R.id.tag_clip_board, this.a.A2);
                                                                        sparseArray8.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                        b15Var4.d.setTag(sparseArray8);
                                                                        arrayList2.add(b15Var4);
                                                                        if (this.a.mIsLogin) {
                                                                            if (!n19.j(this.a.y0) && !booleanValue9 && booleanValue8) {
                                                                                b15 b15Var13 = new b15(5, this.a.getString(R.string.obfuscated_res_0x7f0f0c11), this.a.M0);
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
                                                                                b15Var4.d.setTag(sparseArray9);
                                                                                arrayList2.add(b15Var13);
                                                                            } else if (sz8.A(this.a.y0.z1(), booleanValue7) && TbadkCoreApplication.isLogin()) {
                                                                                b15 b15Var14 = new b15(5, this.a.getString(R.string.report_text), this.a.M0);
                                                                                b15Var14.d.setTag(str2);
                                                                                arrayList2.add(b15Var14);
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
                                                                                        b15 b15Var15 = new b15(6, this.a.getString(R.string.obfuscated_res_0x7f0f04e3), this.a.M0);
                                                                                        b15Var15.d.setTag(sparseArray10);
                                                                                        b15Var6 = b15Var15;
                                                                                        b15Var5 = new b15(7, this.a.getString(R.string.obfuscated_res_0x7f0f02ef), this.a.M0);
                                                                                        b15Var5.d.setTag(sparseArray10);
                                                                                    }
                                                                                } else {
                                                                                    sparseArray10.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                }
                                                                                b15Var6 = null;
                                                                                b15Var5 = new b15(7, this.a.getString(R.string.obfuscated_res_0x7f0f02ef), this.a.M0);
                                                                                b15Var5.d.setTag(sparseArray10);
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
                                                                                if (this.a.y0.z1().U() == 1002 && !booleanValue7) {
                                                                                    b15Var7 = new b15(6, this.a.getString(R.string.report_text), this.a.M0);
                                                                                } else {
                                                                                    b15Var7 = new b15(6, this.a.getString(R.string.obfuscated_res_0x7f0f04e3), this.a.M0);
                                                                                }
                                                                                b15Var7.d.setTag(sparseArray11);
                                                                                b15Var6 = b15Var7;
                                                                                b15Var5 = null;
                                                                            } else {
                                                                                b15Var5 = null;
                                                                                b15Var6 = null;
                                                                            }
                                                                            if (b15Var6 != null) {
                                                                                arrayList2.add(b15Var6);
                                                                            }
                                                                            if (b15Var5 != null) {
                                                                                arrayList2.add(b15Var5);
                                                                            }
                                                                        }
                                                                        this.a.M0.k(arrayList2);
                                                                        this.a.L0 = new d15(this.a.getPageContext(), this.a.M0);
                                                                        this.a.L0.k();
                                                                        return;
                                                                    }
                                                                }
                                                                z = false;
                                                                if (!z) {
                                                                }
                                                                SparseArray sparseArray82 = new SparseArray();
                                                                sparseArray82.put(R.id.tag_clip_board, this.a.A2);
                                                                sparseArray82.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                b15Var4.d.setTag(sparseArray82);
                                                                arrayList2.add(b15Var4);
                                                                if (this.a.mIsLogin) {
                                                                }
                                                                this.a.M0.k(arrayList2);
                                                                this.a.L0 = new d15(this.a.getPageContext(), this.a.M0);
                                                                this.a.L0.k();
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.pb_act_btn) {
                                                            if (this.a.y0.z1() == null || this.a.y0.z1().M() == null || this.a.y0.z1().M().getActUrl() == null) {
                                                                return;
                                                            }
                                                            pt4.s(this.a.getActivity(), this.a.y0.z1().M().getActUrl());
                                                            if (this.a.y0.z1().M().getActInfoType() == 1) {
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                return;
                                                            } else if (this.a.y0.z1().M().getActInfoType() == 2) {
                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (id3 == R.id.lottery_tail) {
                                                            if (view2.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                String string2 = StringUtils.string(view2.getTag(R.id.tag_pb_lottery_tail_link));
                                                                TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.y0.z1().l()).param("tid", this.a.y0.z1().O()).param("lotterytail", StringUtils.string(string2, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                if (!this.a.y0.z1().O().equals(string2)) {
                                                                    this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(string2, (String) null, (String) null, (String) null)));
                                                                    return;
                                                                } else {
                                                                    this.a.G0.s3(0);
                                                                    return;
                                                                }
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f0919cf || id3 == R.id.obfuscated_res_0x7f091999) {
                                                            if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                String string3 = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                String s = f55.m().s("tail_link", "");
                                                                String string4 = StringUtils.string(view2.getTag(R.id.tag_pb_small_tail_theme_id));
                                                                if (!StringUtils.isNull(s)) {
                                                                    TiebaStatic.log("c10056");
                                                                    pt4.x(view2.getContext(), string3, UtilHelper.urlAddParam(s, "page_from=1&tailSkinId=" + string4), true, true, true);
                                                                }
                                                                this.a.G0.M2();
                                                                TiebaStatic.log(new StatisticItem("c15027").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", string4));
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.join_vote_tv) {
                                                            if (view2 != null) {
                                                                pt4.s(this.a.getActivity(), StringUtils.string(view2.getTag()));
                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                if (this.a.r5() != 1 || this.a.y0 == null || this.a.y0.z1() == null) {
                                                                    return;
                                                                }
                                                                v29.u("c10397", this.a.y0.z1().l(), this.a.y0.z1().O(), currentAccount);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.look_all_tv) {
                                                            if (view2 != null) {
                                                                String string5 = StringUtils.string(view2.getTag());
                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                pt4.s(this.a.getActivity(), string5);
                                                                if (this.a.r5() != 1 || this.a.y0 == null || this.a.y0.z1() == null) {
                                                                    return;
                                                                }
                                                                v29.u("c10507", this.a.y0.z1().l(), this.a.y0.z1().O(), currentAccount2);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091627) {
                                                            this.a.e6();
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091626) {
                                                            this.a.c6();
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f0925e4) {
                                                            if (this.a.n1 >= 0) {
                                                                if (this.a.y0 != null) {
                                                                    this.a.y0.S2();
                                                                }
                                                                if (this.a.y0 == null || this.a.G0.G0() == null) {
                                                                    i4 = 0;
                                                                } else {
                                                                    i4 = 0;
                                                                    this.a.G0.G0().l0(this.a.y0.z1(), false);
                                                                }
                                                                this.a.n1 = i4;
                                                                if (this.a.y0 != null) {
                                                                    if (this.a.G0.W0() != null) {
                                                                        this.a.G0.W0().setSelection(this.a.y0.s1());
                                                                    }
                                                                    this.a.y0.W2(0, 0);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.qq_share_container) {
                                                            if (sz8.b(this.a.getPageContext(), 11009)) {
                                                                sz8.v(this.a.getContext(), 8, this.a.r5(), this.a.y0);
                                                                return;
                                                            }
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f091835) {
                                                            SparseArray sparseArray12 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                            if (sparseArray12 == null) {
                                                                return;
                                                            }
                                                            this.a.e7(sparseArray12);
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f09198e) {
                                                            if (this.a.G0.W0() == null || this.a.y0 == null || this.a.y0.z1() == null) {
                                                                return;
                                                            }
                                                            int firstVisiblePosition = this.a.G0.W0().getFirstVisiblePosition();
                                                            View childAt = this.a.G0.W0().getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            boolean v0 = this.a.y0.z1().v0();
                                                            boolean S1 = this.a.G0.S1();
                                                            boolean z5 = firstVisiblePosition == 0 && top == 0;
                                                            sz8.e(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK, this.a.y0.z1());
                                                            if ((this.a.y0.z1().M() != null && this.a.y0.z1().M().getReply_num() <= 0) || (S1 && z5)) {
                                                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                if (!this.a.checkUpIsLogin()) {
                                                                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                    return;
                                                                }
                                                                this.a.t6();
                                                                if (this.a.y0.z1().M().getAuthor() != null) {
                                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", this.a.y0.z1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                                }
                                                            } else {
                                                                int j = (int) (ii.j(this.a.getContext()) * 0.6d);
                                                                if (v0) {
                                                                    if (this.a.G0.b1 != null) {
                                                                        if (this.a.G0.b1.a != null && this.a.G0.b1.a.getView() != null) {
                                                                            if (this.a.G0.b1.a.getView().getParent() != null) {
                                                                            }
                                                                        }
                                                                    }
                                                                    z2 = false;
                                                                } else {
                                                                    if (this.a.G0.e1() != null) {
                                                                        z2 = this.a.G0.e1().getVisibility() == 0;
                                                                        if (!z2 && this.a.G0.b1 != null && this.a.G0.b1.a != null && this.a.G0.b1.a.getView() != null && this.a.G0.b1.a.getView().getParent() != null && this.a.G0.h != null && this.a.G0.h.a != null) {
                                                                        }
                                                                    }
                                                                    z2 = false;
                                                                }
                                                                if (z2 || S1) {
                                                                    this.a.Z = firstVisiblePosition;
                                                                    this.a.a0 = top;
                                                                    if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-j))) {
                                                                        int i9 = -j;
                                                                        this.a.G0.W0().setSelectionFromTop(0, i9);
                                                                        this.a.G0.W0().smoothScrollBy(i9, 500);
                                                                    } else {
                                                                        this.a.G0.W0().D(0, 0, 500);
                                                                    }
                                                                } else if (this.a.Z <= 0) {
                                                                    int d = s09.d(this.a.getListView());
                                                                    if (s09.e(this.a.getListView()) != -1) {
                                                                        d--;
                                                                    }
                                                                    int g = ii.g(this.a.getContext(), R.dimen.tbds100);
                                                                    if (d < 0) {
                                                                        d = (ListUtils.getCount(this.a.G0.W0().getData()) - 1) + this.a.G0.W0().getHeaderViewsCount();
                                                                        i3 = 0;
                                                                    } else {
                                                                        i3 = g;
                                                                    }
                                                                    if (this.a.G0.h != null && this.a.G0.h.a != null) {
                                                                        i3 += this.a.G0.h.a.getFixedNavHeight() - 10;
                                                                    }
                                                                    if (this.a.G0.b1 == null || this.a.G0.b1.a == null || this.a.G0.b1.a.getView() == null || this.a.G0.b1.a.getView().getParent() == null) {
                                                                        this.a.G0.W0().setSelectionFromTop(d, i3 + j);
                                                                        this.a.G0.W0().smoothScrollBy(j, 500);
                                                                    } else {
                                                                        this.a.G0.W0().D(d, i3, 200);
                                                                    }
                                                                } else if (this.a.G0.W0().getChildAt(this.a.Z) == null) {
                                                                    this.a.G0.W0().setSelectionFromTop(this.a.Z, this.a.a0 + j);
                                                                    this.a.G0.W0().smoothScrollBy(j, 500);
                                                                } else {
                                                                    this.a.G0.W0().D(this.a.Z, this.a.a0, 200);
                                                                }
                                                            }
                                                            if (this.a.y0.z1().M() == null || this.a.y0.z1().M().getAuthor() == null) {
                                                                return;
                                                            }
                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", this.a.y0.z1().l()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                            return;
                                                        } else if (id3 == R.id.obfuscated_res_0x7f0919f3 || id3 == R.id.obfuscated_res_0x7f0919f4) {
                                                            if (this.a.y0 == null || this.a.y0.z1() == null || this.a.y0.z1().k() == null || hi.isEmpty(this.a.y0.z1().k().getName())) {
                                                                return;
                                                            }
                                                            if (this.a.y0.getErrorNo() == 4) {
                                                                if (!StringUtils.isNull(this.a.y0.Y0()) || this.a.y0.P0() == null) {
                                                                    this.a.a.finish();
                                                                    return;
                                                                }
                                                                name = this.a.y0.P0().b;
                                                            } else {
                                                                name = this.a.y0.z1().k().getName();
                                                            }
                                                            if (StringUtils.isNull(name)) {
                                                                this.a.a.finish();
                                                                return;
                                                            }
                                                            String Y02 = this.a.y0.Y0();
                                                            if (!this.a.y0.e1() || Y02 == null || !Y02.equals(name)) {
                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.y0.z1().k().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                            } else {
                                                                this.a.a.finish();
                                                            }
                                                            StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                            statisticItem6.param("tid", this.a.y0.S1());
                                                            statisticItem6.param("fid", this.a.y0.getForumId());
                                                            statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            if (this.a.y0.z1().M() != null) {
                                                                statisticItem6.param("nid", this.a.y0.z1().M().getNid());
                                                            }
                                                            TiebaStatic.log(statisticItem6);
                                                            return;
                                                        } else if (id3 != R.id.forum_name_text && id3 != R.id.forum_enter_button_one && id3 != R.id.forum_enter_button_two && id3 != R.id.forum_enter_button_three) {
                                                            if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                if (this.a.y0 == null) {
                                                                    return;
                                                                }
                                                                StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                statisticItem7.param("tid", this.a.y0.S1());
                                                                statisticItem7.param("fid", this.a.y0.getForumId());
                                                                statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem7.param("obj_locate", 2);
                                                                TiebaStatic.log(statisticItem7);
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091a19) {
                                                                if (this.a.y0 == null || this.a.y0.z1() == null) {
                                                                    return;
                                                                }
                                                                qv8 z13 = this.a.y0.z1();
                                                                if (this.a.D0 == null) {
                                                                    PbFragment pbFragment3 = this.a;
                                                                    pbFragment3.D0 = new iw8(pbFragment3.getPageContext());
                                                                }
                                                                long g2 = gg.g(z13.O(), 0L);
                                                                long g3 = gg.g(z13.l(), 0L);
                                                                v29.w("c13446", g3);
                                                                PbFragment pbFragment4 = this.a;
                                                                pbFragment4.registerListener(pbFragment4.m2);
                                                                this.a.D0.a(g2, g3);
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f091a33) {
                                                                if (view2.getTag() instanceof SmartApp) {
                                                                    SmartApp smartApp = (SmartApp) view2.getTag();
                                                                    if (!v26.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                        if (StringUtils.isNull(smartApp.h5_url)) {
                                                                            return;
                                                                        }
                                                                        pt4.s(this.a.getActivity(), smartApp.h5_url);
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.naws_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.y0.S1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f090fa6) {
                                                                if (view2.getTag() instanceof ThreadData) {
                                                                    ThreadData threadData = (ThreadData) view2.getTag();
                                                                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                    createNormalCfg2.setCallFrom(14);
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 == R.id.obfuscated_res_0x7f090fa3) {
                                                                if ((view2.getTag() instanceof ThreadData) && this.a.checkUpIsLogin()) {
                                                                    ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                    if (this.a.P != null) {
                                                                        this.a.P.n0(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                    }
                                                                    TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (id3 != R.id.obfuscated_res_0x7f0919a7 && id3 != R.id.obfuscated_res_0x7f0919ff) {
                                                                if (id3 == R.id.obfuscated_res_0x7f092602) {
                                                                    if (view2.getTag(R.id.tag_is_top_question) instanceof Boolean) {
                                                                        v29.s(5);
                                                                    }
                                                                    this.a.I6(false);
                                                                    this.a.f7((pp9) view2.getTag(R.id.tag_pb_top_replay_more), false);
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (this.a.r0) {
                                                                return;
                                                            } else {
                                                                StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                statisticItem8.param("tid", this.a.y0.S1());
                                                                statisticItem8.param("fid", this.a.y0.getForumId());
                                                                statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem8.param("obj_locate", 7);
                                                                TiebaStatic.log(statisticItem8);
                                                                SparseArray sparseArray13 = (SparseArray) view2.getTag();
                                                                if (sparseArray13 != null && (sparseArray13.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray13.get(R.id.tag_is_top_question)).booleanValue()) {
                                                                    v29.s(6);
                                                                }
                                                                PbFragment pbFragment5 = this.a;
                                                                pbFragment5.b = false;
                                                                pbFragment5.f5(view2);
                                                                return;
                                                            }
                                                        } else if (view2.getTag() instanceof ThreadData) {
                                                            ThreadData threadData3 = (ThreadData) view2.getTag();
                                                            if (this.a.y0.y1() != 3 || !this.a.z0() || this.a.y0.z1() == null || !ListUtils.isEmpty(this.a.y0.z1().o())) {
                                                                FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData3.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                createNormalCfg3.setCallFrom(14);
                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg3));
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
                                                        if (sparseArray14 == null || !(sparseArray14.get(R.id.tag_load_sub_data) instanceof pp9)) {
                                                            return;
                                                        }
                                                        pp9 pp9Var3 = (pp9) sparseArray14.get(R.id.tag_load_sub_data);
                                                        View view3 = (View) sparseArray14.get(R.id.tag_load_sub_view);
                                                        if (pp9Var3 == null || view3 == null) {
                                                            return;
                                                        }
                                                        ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090835);
                                                        EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090836);
                                                        View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b0f);
                                                        if (pp9Var3.x0()) {
                                                            pp9Var3.Y0(false);
                                                            p19.e(pp9Var3);
                                                        } else if (this.a.Q() != null ? p19.c(this.a.Q().z1(), pp9Var3) : false) {
                                                            pp9Var3.Y0(true);
                                                        }
                                                        SkinManager.setBackgroundColor(findViewById, pp9Var3.x0() ? R.color.CAM_X0201 : R.color.transparent);
                                                        SkinManager.setViewTextColor(eMTextView, pp9Var3.x0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                        WebPManager.setPureDrawable(imageView, pp9Var3.x0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, pp9Var3.x0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                        return;
                                                    }
                                                } else {
                                                    this.a.G0.h.f();
                                                    this.a.G0.Q3(this.a.D2);
                                                    return;
                                                }
                                            } else if (this.a.y0 == null) {
                                                return;
                                            } else {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091a05) {
                                                    StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                    statisticItem10.param("tid", this.a.y0.S1());
                                                    statisticItem10.param("fid", this.a.y0.getForumId());
                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem10.param("obj_locate", 6);
                                                    TiebaStatic.log(statisticItem10);
                                                }
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091bdd) {
                                                    if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                        this.a.S = view2;
                                                        return;
                                                    }
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091a05 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                    this.a.S = view2;
                                                    return;
                                                }
                                                if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray15 = (SparseArray) view2.getTag();
                                                    if (sparseArray15.get(R.id.tag_load_sub_data) instanceof pp9) {
                                                        pp9 pp9Var4 = (pp9) sparseArray15.get(R.id.tag_load_sub_data);
                                                        if (view2.getId() == R.id.obfuscated_res_0x7f091a05 && (statisticItem = pp9Var4.e0) != null) {
                                                            StatisticItem copy = statisticItem.copy();
                                                            copy.delete("obj_locate");
                                                            copy.param("obj_locate", 8);
                                                            TiebaStatic.log(copy);
                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091bdd || view2.getId() == R.id.obfuscated_res_0x7f09199f) {
                                                            TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.y0.T1()).param("fid", this.a.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", pp9Var4.N()).param("obj_source", 1).param("obj_type", 3));
                                                        }
                                                        if (this.a.y0 == null || this.a.y0.z1() == null || this.a.I5().f1() == null || pp9Var4.p() == null || pp9Var4.D() == 1) {
                                                            return;
                                                        }
                                                        if (this.a.I5().g1() != null) {
                                                            this.a.I5().g1().g();
                                                        }
                                                        gw8 gw8Var = new gw8();
                                                        gw8Var.v(this.a.y0.z1().k());
                                                        gw8Var.z(this.a.y0.z1().M());
                                                        gw8Var.x(pp9Var4);
                                                        this.a.I5().f1().r0(gw8Var);
                                                        this.a.I5().f1().setPostId(pp9Var4.N());
                                                        this.a.f6(view2, pp9Var4.p().getUserId(), "", pp9Var4);
                                                        if (this.a.V0 != null) {
                                                            this.a.G0.T2(this.a.V0.y());
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        } else if (this.a.y0 == null) {
                                            return;
                                        } else {
                                            StatisticItem statisticItem11 = new StatisticItem("c13398");
                                            statisticItem11.param("tid", this.a.y0.S1());
                                            statisticItem11.param("fid", this.a.y0.getForumId());
                                            statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem11.param("obj_locate", 5);
                                            TiebaStatic.log(statisticItem11);
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091a07 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray16 = (SparseArray) view2.getTag();
                                                    if (sparseArray16.get(R.id.tag_load_sub_data) instanceof pp9) {
                                                        pp9 pp9Var5 = (pp9) sparseArray16.get(R.id.tag_load_sub_data);
                                                        StatisticItem statisticItem12 = pp9Var5.e0;
                                                        if (statisticItem12 != null) {
                                                            StatisticItem copy2 = statisticItem12.copy();
                                                            copy2.delete("obj_locate");
                                                            copy2.param("obj_locate", 8);
                                                            TiebaStatic.log(copy2);
                                                        }
                                                        if (this.a.y0 == null || this.a.y0.z1() == null) {
                                                            return;
                                                        }
                                                        String S12 = this.a.y0.S1();
                                                        String N = pp9Var5.N();
                                                        int U = this.a.y0.z1() != null ? this.a.y0.z1().U() : 0;
                                                        AbsPbActivity.e u6 = this.a.u6(N);
                                                        if (u6 == null) {
                                                            return;
                                                        }
                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(S12, N, "pb", true, false, null, false, null, U, pp9Var5.h0(), this.a.y0.z1().c(), false, pp9Var5.p().getIconInfo(), 5).addBigImageData(u6.a, u6.b, u6.g, u6.j);
                                                        addBigImageData.setKeyPageStartFrom(this.a.y0.y1());
                                                        addBigImageData.setFromFrsForumId(this.a.y0.getFromForumId());
                                                        addBigImageData.setWorksInfoData(this.a.y0.X1());
                                                        addBigImageData.setKeyFromForumId(this.a.y0.getForumId());
                                                        addBigImageData.setTiebaPlusData(this.a.y0.e0(), this.a.y0.a0(), this.a.y0.b0(), this.a.y0.Z(), this.a.y0.f0());
                                                        addBigImageData.setBjhData(this.a.y0.R0());
                                                        if (this.a.y0.z1().n() != null) {
                                                            addBigImageData.setHasForumRule(this.a.y0.z1().n().has_forum_rule.intValue());
                                                        }
                                                        if (this.a.y0.z1().T() != null) {
                                                            addBigImageData.setIsManager(this.a.y0.z1().T().getIs_manager());
                                                        }
                                                        if (this.a.y0.z1().k().getDeletedReasonInfo() != null) {
                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.y0.z1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.y0.z1().k().getDeletedReasonInfo().is_boomgrow.intValue());
                                                        }
                                                        if (this.a.y0.z1().k() != null) {
                                                            addBigImageData.setForumHeadUrl(this.a.y0.z1().k().getImage_url());
                                                            addBigImageData.setUserLevel(this.a.y0.z1().k().getUser_level());
                                                        }
                                                        if (this.a.G0 != null && this.a.y0.G != null) {
                                                            addBigImageData.setMainPostMaskVisibly(this.a.y0.G.V().S || pp9Var5.S);
                                                        }
                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            this.a.R = view2;
                                            return;
                                        }
                                    } else {
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091835) {
                                            StatisticItem statisticItem13 = new StatisticItem("c13398");
                                            statisticItem13.param("tid", this.a.y0.S1());
                                            statisticItem13.param("fid", this.a.y0.getForumId());
                                            statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem13.param("obj_locate", 4);
                                            TiebaStatic.log(statisticItem13);
                                        }
                                        if (view2.getId() != R.id.obfuscated_res_0x7f0919a5 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                            if (!this.a.checkUpIsLogin()) {
                                                v29.r("c10517", this.a.y0.z1().l(), 3);
                                                return;
                                            } else if (this.a.y0 == null || this.a.y0.z1() == null) {
                                                return;
                                            } else {
                                                this.a.G0.t0();
                                                SparseArray sparseArray17 = (SparseArray) view2.getTag();
                                                pp9 pp9Var6 = (pp9) sparseArray17.get(R.id.tag_load_sub_data);
                                                pp9 pp9Var7 = (pp9) sparseArray17.get(R.id.tag_load_sub_reply_data);
                                                View view4 = (View) sparseArray17.get(R.id.tag_load_sub_view);
                                                if (pp9Var6 == null || view4 == null) {
                                                    return;
                                                }
                                                if (pp9Var6.I() == 1) {
                                                    TiebaStatic.log(new StatisticItem("c12630"));
                                                }
                                                StatisticItem statisticItem14 = pp9Var6.e0;
                                                if (statisticItem14 != null) {
                                                    StatisticItem copy3 = statisticItem14.copy();
                                                    copy3.delete("obj_locate");
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091835) {
                                                        copy3.param("obj_locate", 6);
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0919a5) {
                                                        copy3.param("obj_locate", 8);
                                                    }
                                                    TiebaStatic.log(copy3);
                                                }
                                                String S13 = this.a.y0.S1();
                                                String N2 = pp9Var6.N();
                                                String N3 = pp9Var7 != null ? pp9Var7.N() : "";
                                                int U2 = this.a.y0.z1() != null ? this.a.y0.z1().U() : 0;
                                                this.a.g7();
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091da8) {
                                                    TiebaStatic.log("c11742");
                                                    AbsPbActivity.e u62 = this.a.u6(N2);
                                                    if (pp9Var6 == null || this.a.y0 == null || this.a.y0.z1() == null || u62 == null) {
                                                        return;
                                                    }
                                                    SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(S13, N2, "pb", true, false, null, false, N3, U2, pp9Var6.h0(), this.a.y0.z1().c(), false, pp9Var6.p().getIconInfo(), 5).addBigImageData(u62.a, u62.b, u62.g, u62.j);
                                                    if (!hi.isEmpty(N3)) {
                                                        addBigImageData2.setHighLightPostId(N3);
                                                        addBigImageData2.setKeyIsUseSpid(true);
                                                    }
                                                    addBigImageData2.setKeyFromForumId(this.a.y0.getForumId());
                                                    addBigImageData2.setTiebaPlusData(this.a.y0.e0(), this.a.y0.a0(), this.a.y0.b0(), this.a.y0.Z(), this.a.y0.f0());
                                                    addBigImageData2.setBjhData(this.a.y0.R0());
                                                    addBigImageData2.setKeyPageStartFrom(this.a.y0.y1());
                                                    addBigImageData2.setFromFrsForumId(this.a.y0.getFromForumId());
                                                    addBigImageData2.setWorksInfoData(this.a.y0.X1());
                                                    if (this.a.G0 != null && this.a.y0.G != null && (V = this.a.y0.G.V()) != null) {
                                                        addBigImageData2.setMainPostMaskVisibly(V.S || pp9Var6.S);
                                                    }
                                                    if (this.a.y0.z1() != null && this.a.y0.z1().n() != null) {
                                                        addBigImageData2.setHasForumRule(this.a.y0.z1().n().has_forum_rule.intValue());
                                                    }
                                                    this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                    return;
                                                }
                                                AbsPbActivity.e u63 = this.a.u6(N2);
                                                if (this.a.y0 == null || this.a.y0.z1() == null || u63 == null) {
                                                    return;
                                                }
                                                SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(S13, N2, "pb", true, false, null, true, null, U2, pp9Var6.h0(), this.a.y0.z1().c(), false, pp9Var6.p().getIconInfo(), 5).addBigImageData(u63.a, u63.b, u63.g, u63.j);
                                                addBigImageData3.setKeyPageStartFrom(this.a.y0.y1());
                                                addBigImageData3.setFromFrsForumId(this.a.y0.getFromForumId());
                                                addBigImageData3.setWorksInfoData(this.a.y0.X1());
                                                addBigImageData3.setKeyFromForumId(this.a.y0.getForumId());
                                                addBigImageData3.setBjhData(this.a.y0.R0());
                                                addBigImageData3.setTiebaPlusData(this.a.y0.e0(), this.a.y0.a0(), this.a.y0.b0(), this.a.y0.Z(), this.a.y0.f0());
                                                this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                return;
                                            }
                                        }
                                        this.a.R = view2;
                                        return;
                                    }
                                } else if (this.a.y0 == null || this.a.y0.z1() == null || this.a.y0.z1().M() == null) {
                                    return;
                                } else {
                                    this.a.G0.h.e();
                                    TiebaStatic.log(new StatisticItem("c13062"));
                                    PbFragment pbFragment6 = this.a;
                                    pbFragment6.P5(pbFragment6.y0.z1().M().getFirstPostId());
                                    return;
                                }
                            }
                            this.a.G0.t0();
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.showToast(R.string.network_not_available);
                            } else if (this.a.h) {
                                view2.setTag(Integer.valueOf(this.a.y0.P1()));
                            } else {
                                this.a.g7();
                                this.a.G0.o3();
                                d15 d15Var = new d15(this.a.getPageContext());
                                if (this.a.y0.z1().f == null || this.a.y0.z1().f.size() <= 0) {
                                    strArr = new String[]{this.a.getResources().getString(R.string.sort_type_new), this.a.getResources().getString(R.string.sort_type_old)};
                                } else {
                                    strArr = new String[this.a.y0.z1().f.size()];
                                    for (int i10 = 0; i10 < this.a.y0.z1().f.size(); i10++) {
                                        strArr[i10] = this.a.y0.z1().f.get(i10).sort_name + this.a.getResources().getString(R.string.sort_static);
                                    }
                                }
                                d15Var.i(null, strArr, new a(this, d15Var, view2));
                                d15Var.k();
                            }
                        } else {
                            this.a.G0.t0();
                            if (this.a.Q().z1().g == 2) {
                                this.a.showToast(R.string.hot_sort_jump_hint);
                                return;
                            }
                            if (this.a.y0.x1() != null) {
                                this.a.G0.X3(this.a.y0.x1(), this.a.d2);
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                        }
                    } else {
                        this.a.G0.h.e();
                    }
                } else {
                    this.a.G0.h.f();
                    if (this.a.y0 != null) {
                        this.a.r1.f(this.a.y0.S1());
                    }
                    if (this.a.y0 != null && this.a.y0.isPrivacy()) {
                        this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                        if (this.a.Q() == null || this.a.Q().z1() == null) {
                            return;
                        }
                        this.a.r1.d(3, 3, this.a.Q().z1().O());
                        return;
                    }
                    this.a.r1.b();
                    int i11 = (TbSingleton.getInstance().mCanCallFans || this.a.Q() == null || this.a.Q().z1() == null || this.a.Q().z1().O() == null || !this.a.Q().z1().O().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                    if (this.a.Q() == null || this.a.Q().z1() == null) {
                        return;
                    }
                    this.a.r1.d(3, i11, this.a.Q().z1().O());
                }
            } else if (!this.a.r0) {
                StatisticItem statisticItem15 = new StatisticItem("c13398");
                statisticItem15.param("tid", this.a.y0.S1());
                statisticItem15.param("fid", this.a.y0.getForumId());
                statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem15.param("obj_locate", 1);
                TiebaStatic.log(statisticItem15);
                SparseArray sparseArray18 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                if (sparseArray18 != null && (sparseArray18.get(R.id.tag_is_top_question) instanceof Boolean) && ((Boolean) sparseArray18.get(R.id.tag_is_top_question)).booleanValue()) {
                    v29.s(2);
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!this.a.u) {
                    TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                    if (!(tbRichTextView.getTag() instanceof SparseArray)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (!(obj instanceof pp9)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    pp9 pp9Var8 = (pp9) obj;
                    if (this.a.y0 != null && this.a.y0.z1() != null && this.a.I5().f1() != null && pp9Var8.p() != null && pp9Var8.D() != 1) {
                        if (!this.a.checkUpIsLogin()) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        }
                        if (this.a.I5().g1() != null) {
                            this.a.I5().g1().g();
                        }
                        gw8 gw8Var2 = new gw8();
                        gw8Var2.v(this.a.y0.z1().k());
                        gw8Var2.z(this.a.y0.z1().M());
                        gw8Var2.x(pp9Var8);
                        this.a.I5().f1().r0(gw8Var2);
                        this.a.I5().f1().setPostId(pp9Var8.N());
                        this.a.f6(view2, pp9Var8.p().getUserId(), "", pp9Var8);
                        TiebaStatic.log("c11743");
                        v29.b(this.a.y0.z1(), pp9Var8, pp9Var8.d0, 8, 1);
                        if (this.a.V0 != null) {
                            this.a.G0.T2(this.a.V0.y());
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                }
                this.a.u = false;
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            }
        }

        /* loaded from: classes5.dex */
        public class a implements f15.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d15 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ j1 c;

            public a(j1 j1Var, d15 d15Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {j1Var, d15Var, view2};
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
                this.a = d15Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.y0.Q1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.tieba.f15.f
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void N0(f15 f15Var, int i, View view2) {
                boolean r3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048576, this, f15Var, i, view2) == null) {
                    this.a.dismiss();
                    int i2 = 3;
                    int i3 = 0;
                    if (this.c.a.y0.Q1() != 1 || i != 1) {
                        if (this.c.a.y0.Q1() == 2 && i == 0) {
                            i2 = 1;
                        } else if (this.c.a.y0.Q1() == 3 && i != 2) {
                            i2 = 2;
                        } else if (i == 2) {
                        }
                        TiebaStatic.log("c12097");
                        StatisticItem statisticItem = new StatisticItem("c12097");
                        if (this.b.getId() != R.id.obfuscated_res_0x7f091a15) {
                            i3 = 1;
                        }
                        TiebaStatic.log(statisticItem.param("obj_source", i3).param("obj_type", i2));
                        if (this.c.a.y0.z1().f != null && this.c.a.y0.z1().f.size() > i) {
                            i = this.c.a.y0.z1().f.get(i).sort_type.intValue();
                        }
                        r3 = this.c.a.y0.r3(i);
                        this.b.setTag(Integer.valueOf(this.c.a.y0.P1()));
                        if (r3) {
                            return;
                        }
                        this.c.a.h = true;
                        this.c.a.G0.d3(true);
                        return;
                    }
                    i2 = 0;
                    TiebaStatic.log("c12097");
                    StatisticItem statisticItem2 = new StatisticItem("c12097");
                    if (this.b.getId() != R.id.obfuscated_res_0x7f091a15) {
                    }
                    TiebaStatic.log(statisticItem2.param("obj_source", i3).param("obj_type", i2));
                    if (this.c.a.y0.z1().f != null) {
                        i = this.c.a.y0.z1().f.get(i).sort_type.intValue();
                    }
                    r3 = this.c.a.y0.r3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.y0.P1()));
                    if (r3) {
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

    /* loaded from: classes5.dex */
    public class m1 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.G0 != null && this.a != null) {
                    this.b.a.G0.y2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements u05.e {
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

            @Override // com.baidu.tieba.u05.e
            public void onClick(u05 u05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                    u05Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements u05.e {
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

            @Override // com.baidu.tieba.u05.e
            public void onClick(u05 u05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                    u05Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s95 s95Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, s95Var, writeData, antiData}) == null) {
                if (!hi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.y0.z1() != null) {
                        statisticItem.param("fid", this.a.y0.z1().l());
                    }
                    statisticItem.param("tid", this.a.y0.S1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (hi.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.g7();
                this.a.G0.m3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (this.a.E0 != null) {
                    this.a.E0.C0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    jg.a().postDelayed(this.a.U1, 300000L);
                }
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.V0 != null && (this.a.V0.x() || this.a.V0.z())) {
                            this.a.V0.w(false, postWriteCallBackData);
                        }
                        this.a.K0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.X0;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (hi.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        u05 u05Var = new u05(this.a.getActivity());
                        if (hi.isEmpty(postWriteCallBackData.getErrorString())) {
                            u05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                        } else {
                            u05Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        u05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new b(this));
                        u05Var.setPositiveButton(R.string.open_now, new c(this));
                        u05Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (s95Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.P6(i, antiData, str);
                        return;
                    }
                }
                this.a.Z6(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.Q6(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData != null && writeData.getType() == 2) {
                    if (floor != null) {
                        this.a.G0.J1(this.a.y0.z1());
                    }
                } else if (this.a.y0.c1()) {
                    qv8 z1 = this.a.y0.z1();
                    if (z1 != null && z1.M() != null && z1.M().getAuthor() != null && (userId = z1.M().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.y0.o3()) {
                        this.a.G0.o3();
                    }
                } else if (!PbReplySwitch.getInOn() && this.a.y0.o3()) {
                    this.a.G0.o3();
                }
                if (this.a.y0.g1()) {
                    v29.p("c10369", this.a.y0.S1(), null);
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    jg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                if (this.a.y0 != null) {
                    Context context = this.a.getContext();
                    qv8 z12 = this.a.y0.z1();
                    String forumId = this.a.y0.getForumId();
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    sz8.a(context, z12, forumId, z2, this.a.y0.E1(), this.a.y0.H1(), this.a.y0.G1(), this.a.y0.F1(), this.a.y0.L1(), this.a.y0.M1());
                }
                if (writeData != null) {
                    b75.b(writeData.getContent(), "1");
                }
                if (this.a.Y5()) {
                    this.a.j7();
                }
                this.a.X6();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n1 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.G0 != null && this.a != null) {
                    this.b.a.G0.y2(this.a.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements u05.e {
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

            @Override // com.baidu.tieba.u05.e
            public void onClick(u05 u05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                    u05Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements u05.e {
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

            @Override // com.baidu.tieba.u05.e
            public void onClick(u05 u05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                    u05Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s95 s95Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, s95Var, writeData, antiData}) == null) {
                if (!hi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.y0 != null && this.a.y0.z1() != null) {
                        statisticItem.param("fid", this.a.y0.z1().l());
                    }
                    if (this.a.y0 != null) {
                        statisticItem.param("tid", this.a.y0.S1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.A5()) {
                        this.a.I6(false);
                        wu8.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1310));
                    }
                    wz8 wz8Var = this.a.K0;
                    if (wz8Var != null) {
                        wz8Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        kb5.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        b75.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        jg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.Y5()) {
                        this.a.j7();
                    }
                    this.a.X6();
                    return;
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                }
                if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.X0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (hi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    u05 u05Var = new u05(this.a.getActivity());
                    if (hi.isEmpty(postWriteCallBackData.getErrorString())) {
                        u05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        u05Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    u05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new b(this));
                    u05Var.setPositiveButton(R.string.open_now, new c(this));
                    u05Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    PbFragment pbFragment = this.a;
                    if (pbFragment.K0 != null) {
                        if (pbFragment.G0 != null && this.a.G0.g1() != null && this.a.G0.g1().f() != null && this.a.G0.g1().f().y()) {
                            this.a.G0.g1().f().w(postWriteCallBackData);
                        }
                        this.a.K0.l(postWriteCallBackData);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p1 implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p1 a;

            public a(p1 p1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {p1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = p1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || BreatheTipWidget.e() || this.a.a.getContext() == null) {
                    return;
                }
                x55 x55Var = new x55();
                x55Var.b = R.raw.lottie_bubble_breath_tip;
                x55Var.a = BreatheTipWidget.PointType.LOTTIE;
                x55Var.c = ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                y55 y55Var = new y55();
                y55Var.a = this.a.a.getString(R.string.obfuscated_res_0x7f0f053f);
                y55Var.b = this.a.a.getString(R.string.agree_tip_content);
                y55Var.e = R.drawable.pic_guidecard;
                y55Var.f = ii.g(this.a.a.getContext(), R.dimen.tbds156);
                y55Var.g = ii.g(this.a.a.getContext(), R.dimen.tbds489);
                y55Var.h = ii.g(this.a.a.getContext(), R.dimen.tbds286);
                if (this.a.a.a.findViewById(this.a.a.G0.j1()) == null) {
                    return;
                }
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a.a.getContext());
                breatheTipWidget.g(this.a.a.a.findViewById(this.a.a.G0.j1()));
                breatheTipWidget.f(y55Var, x55Var);
                if (breatheTipWidget.h((Activity) this.a.a.getContext())) {
                    f55 m = f55.m();
                    m.w("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                    fb5.a("c14828");
                }
            }
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

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(qv8 qv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qv8Var) == null) {
                this.a.G0.J1(qv8Var);
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
            cn5 cn5Var = new cn5(i, z, responsedMessage, this.a.p, this.a.o, this.a.m, z2, 0L, 0L, j4);
            this.a.o = 0L;
            this.a.p = 0L;
            cn5Var.c();
            if (z2) {
                j3 = j4;
                cn5Var.B = j3;
                cn5Var.e(true);
            } else {
                j3 = j4;
            }
            if (!z2 && this.a.y0 != null && this.a.y0.z1() != null && this.a.y0.z1().M() != null) {
                int threadType = this.a.y0.z1().M().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (StringHelper.equals(this.a.L, "from_personalize")) {
                        ym5 ym5Var = new ym5();
                        ym5Var.F = 1;
                        ym5Var.a(1005);
                        ym5Var.D = j3;
                        ym5Var.d(threadType);
                    } else if (StringHelper.equals(this.a.L, "from_frs")) {
                        cn5 cn5Var2 = new cn5();
                        cn5Var2.a(1000);
                        cn5Var2.D = j3;
                        cn5Var2.d(threadType);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, qv8 qv8Var, String str, int i4) {
            ArrayList<pp9> arrayList;
            int i5;
            boolean z2;
            qd5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), qv8Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f090775));
                }
                if (z && qv8Var != null && qv8Var.W() == null && ListUtils.getCount(qv8Var.F()) < 1) {
                    this.a.y0.l3(1);
                    if (this.a.e != null) {
                        this.a.e.x();
                    }
                    if (this.a.G0 != null) {
                        this.a.G0.U3();
                        return;
                    }
                    return;
                }
                if (this.a.f0) {
                    if (this.a.Q() != null) {
                        this.a.Q().H0();
                    }
                } else {
                    this.a.f0 = true;
                }
                this.a.g = true;
                if (this.a.G0 == null) {
                    return;
                }
                this.a.G0.n3();
                if (qv8Var == null || !qv8Var.q0()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.G0.o1());
                }
                this.a.G0.w1();
                if (this.a.I) {
                    this.a.G0.q1();
                } else if (!this.a.G0.N1()) {
                    this.a.G0.B3(false);
                }
                if (this.a.h) {
                    this.a.h = false;
                }
                if (i4 == 0 && qv8Var != null) {
                    this.a.O0 = true;
                }
                if (qv8Var != null) {
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.hideNetRefreshView(pbFragment2.G0.o1());
                    this.a.G0.x3();
                }
                String str2 = null;
                if (z && qv8Var != null) {
                    ThreadData M = qv8Var.M();
                    if (M != null && M.isUgcThreadType()) {
                        d();
                    } else {
                        PbFragment pbFragment3 = this.a;
                        pbFragment3.L6(pbFragment3.U0);
                    }
                    this.a.G0.g1().r(qv8Var);
                    this.a.G0.I3();
                    if (M != null && M.getCartoonThreadData() != null) {
                        this.a.n7(M.getCartoonThreadData());
                    }
                    if (this.a.V0 != null) {
                        this.a.G0.T2(this.a.V0.y());
                    }
                    TbadkCoreApplication.getInst().setDefaultBubble(qv8Var.T().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(qv8Var.T().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(qv8Var.T().getBimg_end_time());
                    if (qv8Var.F() != null && qv8Var.F().size() >= 1 && qv8Var.F().get(0) != null) {
                        this.a.y0.X2(qv8Var.F().get(0).N());
                    } else if (qv8Var.W() != null) {
                        this.a.y0.X2(qv8Var.W().N());
                    }
                    if (this.a.V0 != null) {
                        this.a.V0.H(qv8Var.c());
                        this.a.V0.I(qv8Var.k(), qv8Var.T());
                        this.a.V0.k0(M);
                        this.a.V0.J(this.a.y0.b1(), this.a.y0.S1(), this.a.y0.X0());
                        if (M != null) {
                            this.a.V0.Z(M.isMutiForumThread());
                        }
                    }
                    if (this.a.A0 != null) {
                        this.a.A0.h(qv8Var.q());
                    }
                    PbFragment pbFragment4 = this.a;
                    if (qv8Var.r() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    pbFragment4.q = z2;
                    if (qv8Var.h0()) {
                        this.a.q = true;
                    }
                    this.a.G0.U2(this.a.q);
                    if (this.a.t0.f.size() > 0) {
                        qv8Var.P0(this.a.t0.f);
                    }
                    this.a.G0.M3(qv8Var, i2, i3, this.a.y0.R1(), i4, this.a.y0.i1());
                    this.a.G0.b4(qv8Var, this.a.y0.R1());
                    this.a.G0.h4(this.a.y0.c1());
                    AntiData c = qv8Var.c();
                    if (c != null) {
                        this.a.x = c.getVoice_message();
                        if (!StringUtils.isNull(this.a.x) && this.a.V0 != null && this.a.V0.b() != null && (o = this.a.V0.b().o(6)) != null && !TextUtils.isEmpty(this.a.x)) {
                            ((View) o).setOnClickListener(this.a.E1);
                        }
                    }
                    if (!this.a.W && !ListUtils.isEmpty(this.a.y0.z1().F()) && !this.a.y0.m2()) {
                        this.a.W = true;
                        this.a.Y4(false);
                    }
                    if (!TextUtils.isEmpty(this.a.R0)) {
                        PbFragment pbFragment5 = this.a;
                        sz8.E(pbFragment5, pbFragment5.y0.y1(), this.a.R0);
                        this.a.R0 = null;
                    } else if (!this.a.Q0) {
                        if (!this.a.S0) {
                            if (!TextUtils.isEmpty(this.a.y0.p1())) {
                                s09.f(this.a.getListView(), this.a.y0.p1());
                                this.a.y0.t2();
                            } else {
                                this.a.G0.H3();
                            }
                        } else {
                            this.a.S0 = false;
                            s09.j(this.a.getListView());
                        }
                    } else {
                        this.a.Q0 = false;
                        sz8.D(this.a);
                    }
                    this.a.y0.u2(qv8Var.k(), this.a.K1);
                    this.a.y0.y2(this.a.M1);
                    if (this.a.X0 != null && M != null && M.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(M.getAuthor());
                        this.a.X0.setLikeUserData(attentionHostData);
                    }
                    if (this.a.y0 != null && this.a.y0.i2()) {
                        str2 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else if (this.a.G0 != null) {
                        str2 = this.a.G0.h1();
                    }
                    if (this.a.V0 != null && !StringUtils.isNull(str2)) {
                        this.a.V0.c0(TbSingleton.getInstance().getAdVertiComment(qv8Var.o0(), qv8Var.p0(), str2));
                    }
                } else if (str != null) {
                    if (!this.a.O0 && i4 == 1) {
                        if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.y0.P0() != null && !StringUtils.isNull(this.a.y0.P0().c)) {
                                    this.a.G0.j4(this.a.y0.P0());
                                } else {
                                    PbFragment pbFragment6 = this.a;
                                    pbFragment6.showNetRefreshView(pbFragment6.G0.o1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                    ki9.a("pb", false);
                                    PbFragment pbFragment7 = this.a;
                                    pbFragment7.setNetRefreshViewEmotionMarginTop(ii.g(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0702ab));
                                }
                            } else {
                                PbFragment pbFragment8 = this.a;
                                pbFragment8.showNetRefreshView(pbFragment8.G0.o1(), this.a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i)), true);
                                ki9.a("pb", false);
                                PbFragment pbFragment9 = this.a;
                                pbFragment9.setNetRefreshViewEmotionMarginTop(ii.g(pbFragment9.getContext(), R.dimen.obfuscated_res_0x7f0702ab));
                            }
                            this.a.G0.q1();
                            this.a.G0.p1();
                        }
                    } else {
                        this.a.showToast(str);
                    }
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.y0.S1());
                            jSONObject.put("fid", this.a.y0.getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                    }
                    if (i != 0) {
                        EnterForePvThread enterForePvThread = new EnterForePvThread();
                        enterForePvThread.setOpType("2");
                        enterForePvThread.start();
                    }
                    if (i != -1) {
                        if (this.a.y0 != null && this.a.y0.z1() != null) {
                            arrayList = this.a.y0.z1().F();
                        } else {
                            arrayList = null;
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).D() != 1)) {
                            this.a.G0.P2(this.a.getResources().getString(R.string.list_no_more_new));
                        } else {
                            if (this.a.a6()) {
                                this.a.G0.Q2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0eda));
                            } else {
                                this.a.G0.Q2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0edb));
                            }
                            this.a.G0.J1(this.a.y0.z1());
                        }
                    } else {
                        this.a.G0.P2("");
                    }
                    this.a.G0.A0();
                }
                if (qv8Var != null && qv8Var.m && this.a.m == 0) {
                    this.a.m = System.currentTimeMillis() - this.a.l;
                }
                if (this.a.a instanceof PbActivity) {
                    PbActivity pbActivity = (PbActivity) this.a.a;
                    if (qv8Var != null) {
                        i5 = qv8Var.f();
                    } else {
                        i5 = 0;
                    }
                    pbActivity.d2(i5, this.a.G0);
                }
                int n = f55.m().n(f55.q("key_reaction_guide_show_number_pb"), 0);
                if (this.a.a != null && this.a.a.getIntent() != null && this.a.a.getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false)) {
                    if (n != 1 && n != 2 && n != 3) {
                        e();
                        return;
                    }
                    return;
                }
                e();
            }
        }

        public final void d() {
            Bundle extras;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.a.y0 == null) {
                return;
            }
            if (this.a.V0 != null && this.a.V0.t) {
                return;
            }
            lf5 lf5Var = new lf5();
            this.a.L6(lf5Var);
            PbFragment pbFragment = this.a;
            pbFragment.V0 = (mf5) lf5Var.a(pbFragment.getContext());
            this.a.V0.W(this.a.a.getPageContext());
            this.a.V0.f0(this.a.j2);
            this.a.V0.g0(this.a.Y0);
            mf5 mf5Var = this.a.V0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
            if (this.a.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.a.getIntent().getExtras();
            }
            mf5Var.A(pageContext, extras);
            this.a.V0.b().E(true);
            this.a.G0.O2(this.a.V0.b());
            if (!this.a.y0.m1()) {
                this.a.V0.q(this.a.y0.S1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.a.V0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.y0.i2()) {
                this.a.V0.c0(this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else if (this.a.G0 != null) {
                this.a.V0.c0(this.a.G0.h1());
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                f55 m = f55.m();
                if (!m.i("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
                    jg.a().postDelayed(new a(this), 500L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements iq6.b {
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

        @Override // com.baidu.tieba.iq6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    tw8.d();
                } else {
                    tw8.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void a(v09 v09Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, v09Var) != null) || v09Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, v09Var.a()));
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                BdLog.e(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class a1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a1() {
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
        public void onNavigationButtonClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a2 implements u05.e {
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

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) && u05Var != null) {
                u05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a3 implements yf<LinearLayout> {
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
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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
        @Override // com.baidu.tieba.yf
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

    /* loaded from: classes5.dex */
    public class b implements ky8.b {
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

        @Override // com.baidu.tieba.ky8.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f161f);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0d30);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.G0.r0(str);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (!this.a.j0) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        this.a.q6();
                        return;
                    } else {
                        this.a.C6();
                        return;
                    }
                }
                this.a.j0 = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b1 implements u05.e {
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

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                this.a.R5();
                cz4 x1 = this.a.y0.x1();
                int d1 = this.a.G0.d1();
                if (d1 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0edd);
                } else if (x1 != null && d1 > x1.h()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0edd);
                } else {
                    this.a.G0.t0();
                    this.a.g7();
                    this.a.G0.o3();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.y0.l3(this.a.G0.d1());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0d30);
                    }
                    u05Var.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b2 implements p55.g {
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

        @Override // com.baidu.tieba.p55.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.z5()) {
                    this.a.a.finish();
                }
                if (this.a.y0.x2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.G0.B0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class c implements u05.e {
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

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    u05Var.dismiss();
                    ((TbPageContext) this.a.d1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                u05Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.d1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && !ListUtils.isEmpty(list) && this.a.G0 != null) {
                this.a.G0.t3(list);
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

    /* loaded from: classes5.dex */
    public class c1 implements g3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.g3
        public void a(Object obj) {
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
                String valueOf = String.valueOf(this.a.y0.z1().T().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.y0.z1().k().getId(), this.a.y0.z1().k().getName(), this.a.y0.z1().M().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (this.a.z5()) {
                    this.a.a.finish();
                }
                if (this.a.y0.x2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.G0.B0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c3 implements hq6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

        @Override // com.baidu.tieba.hq6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.hq6.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

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
            this.b = pbFragment;
            this.a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070282);
        }

        @Override // com.baidu.tieba.hq6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && e(i2) && this.b.G0 != null && this.b.e != null) {
                this.b.e.u(true);
                if (Math.abs(i2) > this.a) {
                    this.b.e.l();
                }
                if (this.b.z5()) {
                    this.b.G0.v1();
                    this.b.G0.N2();
                }
            }
        }

        @Override // com.baidu.tieba.hq6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && e(i2) && this.b.G0 != null && this.b.e != null) {
                this.b.G0.R3();
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

    /* loaded from: classes5.dex */
    public class d implements u05.e {
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

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                u05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements PraiseModel.b {
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

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && this.a.N1 != null && str != null) {
                if (AntiHelper.m(i, str)) {
                    AntiHelper.u(this.a.getPageContext().getPageActivity(), str);
                } else {
                    this.a.showToast(str);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void j(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || this.a.N1 == null) {
                return;
            }
            qv8 z1 = this.a.y0.z1();
            if (z1.M().getPraise().getIsLike() == 1) {
                this.a.o7(0);
            } else {
                this.a.o7(1);
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, z1.M()));
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements f15.f {
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

        @Override // com.baidu.tieba.f15.f
        public void N0(f15 f15Var, int i, View view2) {
            boolean z;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, f15Var, i, view2) == null) {
                if (this.a.L0 != null) {
                    this.a.L0.dismiss();
                }
                this.a.l7(i);
                if (i != -4) {
                    if (i != -3) {
                        if (i != -2) {
                            if (i != -1) {
                                if (i != 13) {
                                    int i2 = 4;
                                    switch (i) {
                                        case 1:
                                            if (this.a.i1 != null && !TextUtils.isEmpty(this.a.j1)) {
                                                if (this.a.l1 != null) {
                                                    lg5.a aVar = new lg5.a();
                                                    aVar.a = this.a.j1;
                                                    String str = "";
                                                    if (this.a.l1.memeInfo.pck_id.intValue() >= 0) {
                                                        str = "" + this.a.l1.memeInfo.pck_id;
                                                    }
                                                    aVar.b = str;
                                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                } else {
                                                    this.a.W4();
                                                }
                                                this.a.i1 = null;
                                                this.a.j1 = null;
                                                return;
                                            }
                                            return;
                                        case 2:
                                            if (this.a.i1 != null && !TextUtils.isEmpty(this.a.j1)) {
                                                if (this.a.W0 == null) {
                                                    this.a.W0 = new PermissionJudgePolicy();
                                                }
                                                this.a.W0.clearRequestPermissionList();
                                                this.a.W0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                if (this.a.W0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                                    return;
                                                }
                                                if (this.a.h1 == null) {
                                                    PbFragment pbFragment = this.a;
                                                    pbFragment.h1 = new yz8(pbFragment.getPageContext());
                                                }
                                                this.a.h1.b(this.a.j1, this.a.i1.n());
                                                this.a.i1 = null;
                                                this.a.j1 = null;
                                                return;
                                            }
                                            return;
                                        case 3:
                                            pp9 pp9Var = this.a.A2;
                                            if (pp9Var != null) {
                                                pp9Var.J0();
                                                this.a.A2 = null;
                                                return;
                                            }
                                            return;
                                        case 4:
                                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                            if (!this.a.checkUpIsLogin()) {
                                                return;
                                            }
                                            this.a.j6(view2);
                                            if (this.a.y0.z1().M() != null && this.a.y0.z1().M().getAuthor() != null && this.a.y0.z1().M().getAuthor().getUserId() != null && this.a.A0 != null) {
                                                int u = sz8.u(this.a.y0.z1());
                                                ThreadData M = this.a.y0.z1().M();
                                                if (M.isBJHArticleThreadType()) {
                                                    i2 = 2;
                                                } else if (M.isBJHVideoThreadType()) {
                                                    i2 = 3;
                                                } else if (!M.isBJHNormalThreadType()) {
                                                    if (M.isBJHVideoDynamicThreadType()) {
                                                        i2 = 5;
                                                    } else {
                                                        i2 = 1;
                                                    }
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.y0.b).param("obj_locate", 2).param("obj_id", this.a.y0.z1().M().getAuthor().getUserId()).param("obj_type", !this.a.A0.e()).param("obj_source", u).param("obj_param1", i2));
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
                                                this.a.P5((String) tag);
                                                return;
                                            } else if (tag instanceof SparseArray) {
                                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                                SparseArray<Object> sparseArray2 = (SparseArray) tag;
                                                if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray2.put(R.id.tag_from, 0);
                                                    sparseArray2.put(R.id.tag_check_mute_from, 2);
                                                    this.a.a5(sparseArray2);
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
                                                boolean G = this.a.R().G(TbadkCoreApplication.getCurrentAccount());
                                                if (G) {
                                                    if (booleanValue2) {
                                                        this.a.G0.s2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, G);
                                                        return;
                                                    } else {
                                                        this.a.R6(sparseArray3, intValue, booleanValue);
                                                        return;
                                                    }
                                                } else if (!booleanValue || booleanValue2) {
                                                    this.a.G0.q2(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                                    return;
                                                } else {
                                                    this.a.R6(sparseArray3, intValue, booleanValue);
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
                                                    this.a.a5(sparseArray4);
                                                    return;
                                                }
                                                if (z) {
                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                }
                                                this.a.G0.v2(view2);
                                                return;
                                            } else if (booleanValue4) {
                                                this.a.G0.q2(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                return;
                                            } else {
                                                return;
                                            }
                                        case 8:
                                            if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                                                return;
                                            }
                                            pp9 pp9Var2 = (pp9) sparseArray.get(R.id.tag_clip_board);
                                            if (pp9Var2.n() == null) {
                                                return;
                                            }
                                            this.a.d5(pp9Var2.n());
                                            return;
                                        case 9:
                                            if (this.a.checkUpIsLogin() && this.a.y0 != null && this.a.y0.z1() != null) {
                                                this.a.a.U1(hx9.c(view2));
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                } else if (this.a.checkUpIsLogin() && this.a.y0 != null && this.a.y0.z1() != null) {
                                    this.a.G0.o4(true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_2);
                            if (view3 == null) {
                                return;
                            }
                            this.a.w6(view3);
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
                            this.a.w6(view4);
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
                    this.a.w6(view5);
                    if (view5 != null) {
                        if (sparseArray5 != null && (sparseArray5.get(R.id.tag_is_top_question) instanceof Boolean)) {
                            this.a.I6(((Boolean) sparseArray5.get(R.id.tag_is_top_question)).booleanValue());
                        }
                        view5.performClick();
                        return;
                    }
                    return;
                }
                View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_share);
                this.a.w6(view6);
                if (view6 != null) {
                    view6.performClick();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (this.a.v2 && this.a.z5()) {
                    this.a.c6();
                }
                if (!this.a.mIsLogin) {
                    return;
                }
                if (!this.a.e0 && this.a.G0 != null && this.a.G0.i0() && this.a.y0 != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.a.y0.S1());
                    statisticItem.param("fid", this.a.y0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    int i = 5;
                    if (this.a.y0.e1()) {
                        i = 4;
                    } else if (this.a.y0.f1()) {
                        i = 3;
                    } else if (this.a.y0.h1()) {
                        i = 1;
                    }
                    statisticItem.param("obj_type", i);
                    TiebaStatic.log(statisticItem);
                    this.a.e0 = true;
                }
                if (this.a.y0.v2(false)) {
                    this.a.G0.p3();
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (this.a.y0.z1() != null) {
                    this.a.G0.I2();
                }
                this.a.v2 = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d3 implements az8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.az8.b
        public void onSuccess(List<pp9> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }

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

        @Override // com.baidu.tieba.az8.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && !StringUtils.isNull(str)) {
                this.a.G0.c4(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements u05.e {
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

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                u05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements PbInterviewStatusView.f {
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

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.G0.Y3(!this.a.M);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements u05.e {
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

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                if (u05Var != null) {
                    u05Var.dismiss();
                }
                this.d.l5(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.y0 != null) {
                this.a.y0.loadData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements u05.e {
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

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                this.b.G0.J3();
                MessageManager.getInstance().sendMessage(this.a);
                u05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements y09.h {
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

        @Override // com.baidu.tieba.y09.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.K6(z);
                if (this.a.G0.T0() != null && z) {
                    this.a.G0.Y3(false);
                }
                this.a.G0.h2(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements u05.e {
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

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                u05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f3 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<tz8> a;
        public WeakReference<PbFragment> b;

        public f3(tz8 tz8Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz8Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(tz8Var);
            this.b = new WeakReference<>(pbFragment);
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                tz8 tz8Var = this.a.get();
                if (tz8Var != null) {
                    tz8Var.u1();
                }
                PbFragment pbFragment = this.b.get();
                if (pbFragment != null && CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        pbFragment.a7(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        en7.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = pbFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0d30);
                        }
                        pbFragment.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements u05.e {
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

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                u05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements f15.f {
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

        @Override // com.baidu.tieba.f15.f
        public void N0(f15 f15Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, f15Var, i, view2) == null) {
                if (this.e.L0 != null) {
                    this.e.L0.dismiss();
                }
                if (i == 0) {
                    this.e.G0.q2(((Integer) this.a.get(R.id.tag_del_post_type)).intValue(), (String) this.a.get(R.id.tag_del_post_id), ((Integer) this.a.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.a.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.f1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.f1);
                    this.e.c7(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.G0.t0();
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.y0 != null && !this.a.y0.isLoading) {
                    this.a.g7();
                    this.a.G0.o3();
                    z = true;
                    if (this.a.y0.z1() != null && this.a.y0.z1().f != null && this.a.y0.z1().f.size() > i) {
                        int intValue = this.a.y0.z1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.y0.T1()).param("fid", this.a.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.y0.r3(intValue)) {
                            this.a.h = true;
                            this.a.G0.d3(true);
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g2 implements u05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ u05 c;
        public final /* synthetic */ PbFragment d;

        public g2(PbFragment pbFragment, MarkData markData, MarkData markData2, u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, u05Var};
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
            this.c = u05Var;
        }

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                u05Var.dismiss();
                if (this.d.A0 != null) {
                    if (this.d.A0.e()) {
                        this.d.A0.d();
                        this.d.A0.h(false);
                    }
                    this.d.A0.i(this.a);
                    this.d.A0.h(true);
                    this.d.A0.a();
                }
                this.b.setPostId(this.a.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.b);
                this.d.a.setResult(-1, intent);
                this.c.dismiss();
                this.d.h7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends vr5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbFragment b;

        public h(PbFragment pbFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFragment;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vr5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel Q = this.b.Q();
                if (Q != null) {
                    Q.Z2(this.a);
                }
                return q19.c(this.b.r5(), 2, Q);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().c != null) {
                if (updateAttentionMessage.getData().i != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() == this.a.getUniqueId() && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().i, PbFragment.Q2) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                        return;
                    }
                    return;
                }
                if (updateAttentionMessage.getData().a) {
                    if (this.a.s5().p() != null && this.a.s5().p().getGodUserData() != null) {
                        this.a.s5().p().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.y0 != null && this.a.y0.z1() != null && this.a.y0.z1().M() != null && this.a.y0.z1().M().getAuthor() != null) {
                        this.a.y0.z1().M().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                    }
                }
                if (updateAttentionMessage.isAttention()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921760, 10));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h2 implements if5 {
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

        @Override // com.baidu.tieba.if5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                wz8 wz8Var = this.a.K0;
                if (wz8Var != null && wz8Var.g() != null && this.a.K0.g().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.K0.g().c());
                    if (this.a.G0 != null && this.a.G0.g1() != null && this.a.G0.g1().f() != null && this.a.G0.g1().f().y()) {
                        this.a.G0.g1().f().w(this.a.K0.h());
                    }
                    this.a.K0.b(true);
                    return true;
                }
                return !this.a.c5(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i implements zq5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ PbFragment c;

        public i(PbFragment pbFragment, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pbFragment;
            this.a = i;
            this.b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zq5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                bundle.putInt("obj_param1", this.a);
                shareItem.l(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.c.getContext(), this.b, shareItem, false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 extends wj5<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment c;

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
            this.c = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pj5
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId > 0 && this.c.a.getPageId() == tipEvent.pageId) {
                    DefaultNavigationBarCoverTip.t(this.c.getActivity(), tipEvent.message, tipEvent.linkUrl).v();
                    return true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i2 implements u05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ u05 b;
        public final /* synthetic */ PbFragment c;

        public i2(PbFragment pbFragment, MarkData markData, u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, u05Var};
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
            this.b = u05Var;
        }

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                u05Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.h7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.y0 != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.V0 != null) {
                    this.a.G0.T2(this.a.V0.y());
                }
                this.a.G0.M2();
                this.a.G0.t0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j0 extends wj5<TopToastEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment c;

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
            this.c = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pj5
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topToastEvent)) == null) {
                if (this.c.G0 != null && topToastEvent != null) {
                    BdTopToast bdTopToast = new BdTopToast(this.c.getContext());
                    bdTopToast.h(topToastEvent.isSuccess());
                    bdTopToast.g(topToastEvent.getContent());
                    bdTopToast.i(this.c.G0.o1());
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ u05 b;
        public final /* synthetic */ PbFragment c;

        public j2(PbFragment pbFragment, MarkData markData, u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, u05Var};
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
            this.b = u05Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.c.G0 != null && this.c.G0.o1() != null) {
                    this.c.G0.o1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.a.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.h7();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            this.a.y0.t3((UserPendantData) customResponsedMessage.getData());
            if (this.a.G0 != null && this.a.y0 != null) {
                this.a.G0.G2(this.a.y0.z1(), this.a.y0.R1(), this.a.y0.J1(), this.a.G0.k1());
            }
            if (this.a.G0 != null && this.a.G0.G0() != null) {
                this.a.G0.G0().d0();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            tz8 tz8Var = this.b.G0;
            tz8Var.r3("@" + this.a.getStringExtra("big_pic_type") + " ");
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || this.a.y0 == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || !StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.y0.b)) {
                return;
            }
            this.a.Z6((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class k2 implements yf<ImageView> {
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
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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
                    foreDrawableImageView.R();
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
                    if (iw4.c().g()) {
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
                    foreDrawableImageView.R();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.H();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = iw4.c().g();
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

    /* loaded from: classes5.dex */
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
                if (this.a.G0 == null) {
                    return;
                }
                if (booleanValue) {
                    this.a.G0.T3();
                } else {
                    this.a.G0.w1();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                    if (this.a.V0 != null) {
                        this.a.V0.G(null, null);
                    }
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.G0 != null && this.a.G0.g1() != null && this.a.G0.g1().f() != null) {
                    this.a.G0.g1().f().G();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l1 implements jf5 {
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

        @Override // com.baidu.tieba.jf5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l2 implements yf<GifView> {
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
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.e0();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.h0();
                gifView.e0();
                gifView.setImageDrawable(null);
                gifView.i0();
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
                if (iw4.c().g()) {
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
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = iw4.c().g();
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

    /* loaded from: classes5.dex */
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
            if (this.a.V0 != null) {
                this.a.G0.T2(this.a.V0.y());
            }
            this.a.G0.B3(false);
        }
    }

    /* loaded from: classes5.dex */
    public class m0 extends z8 {
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

        @Override // com.baidu.tieba.z8
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m2 implements yf<TiebaPlusRecommendCard> {
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
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard c(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            h(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        public TiebaPlusRecommendCard e(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tiebaPlusRecommendCard)) == null) {
                tiebaPlusRecommendCard.o();
                return tiebaPlusRecommendCard;
            }
            return (TiebaPlusRecommendCard) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: f */
        public void b(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tiebaPlusRecommendCard) == null) {
                tiebaPlusRecommendCard.p();
            }
        }

        public TiebaPlusRecommendCard h(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tiebaPlusRecommendCard)) == null) {
                tiebaPlusRecommendCard.p();
                return tiebaPlusRecommendCard;
            }
            return (TiebaPlusRecommendCard) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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

    /* loaded from: classes5.dex */
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
                yu8 yu8Var = (yu8) customResponsedMessage.getData();
                int type = yu8Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (yu8Var.a() == null) {
                                this.a.y6(false, null);
                                return;
                            } else {
                                this.a.y6(true, (MarkData) yu8Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.n5((ForumManageModel.b) yu8Var.a(), false);
                    return;
                }
                this.a.z6((gw8) yu8Var.a());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements uu8.d {
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

        @Override // com.baidu.tieba.uu8.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n2 implements yf<View> {
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
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ View c(View view2) {
            View view3 = view2;
            h(view3);
            return view3;
        }

        public View e(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
                ((PlayVoiceBntNew) view2).o();
                return view2;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).n();
            }
        }

        public View h(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
                ((PlayVoiceBntNew) view2).n();
                return view2;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.y0());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.G0 != null && this.a.G0.G0() != null) {
                this.a.G0.G0().d0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements uw8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        @Override // com.baidu.tieba.uw8.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

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

        @Override // com.baidu.tieba.uw8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091dc6) {
                        if (this.a.D6(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09014e) {
                        if (motionEvent != null && motionEvent.getAction() == 1) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof pp9)) {
                                return false;
                            }
                            pp9 pp9Var = (pp9) obj;
                            if (pp9Var.getType() != pp9.V0 && !TextUtils.isEmpty(pp9Var.r()) && iw4.c().g()) {
                                return this.a.l6(pp9Var);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0919a4) {
                        if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                            this.a.e7((SparseArray) view2.getTag(R.id.tag_from));
                        }
                    } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.pb_post_header_layout) {
                        if (this.a.G0.O1() && view2.getId() == R.id.obfuscated_res_0x7f0919c3) {
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
                        this.a.e7(sparseArray);
                    }
                }
                if (this.a.V0 != null) {
                    this.a.G0.T2(this.a.V0.y());
                }
                this.a.G0.M2();
                this.a.G0.t0();
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.uw8.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (!this.a.isAdded()) {
                    return true;
                }
                this.a.m5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class o1 extends za {
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

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView m1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                    if (responsedMessage.getError() == 0) {
                        ii.P(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                        if (this.a.G0 != null && (m1 = this.a.G0.m1()) != null && this.a.G0.W0() != null) {
                            this.a.G0.W0().removeHeaderView(m1);
                            return;
                        }
                        return;
                    }
                    ii.Q(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o2 implements yf<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof cw5.a)) {
                cw5.a aVar = (cw5.a) customResponsedMessage.getData();
                if (aVar.a == 2 && aVar.d == 5) {
                    this.a.M5(aVar.b);
                }
                cw5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements Handler.Callback {
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

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.a.y0 != null && this.a.y0.k1()) {
                    this.a.g6();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class p2 implements yf<ItemCardView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
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
        @Override // com.baidu.tieba.yf
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

    /* loaded from: classes5.dex */
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
            this.a.d7();
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements w05.c {
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

        @Override // com.baidu.tieba.w05.c
        public void a(w05 w05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, w05Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.N0 = pbFragment.N0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.N0);
                    new zx8(this.a.y0.S1(), this.a.N0, "1").start();
                    w05Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.N0 = pbFragment2.N0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.N0);
                    new zx8(this.a.y0.S1(), this.a.N0, "2").start();
                    w05Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.N0 = pbFragment3.N0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.N0);
                    w05Var.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            this.a.m7();
        }
    }

    /* loaded from: classes5.dex */
    public class q2 implements TbRichTextView.a0 {
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v20, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.a0
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            ey8 G0;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.G0.e2((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.y0.S1());
                    statisticItem.param("fid", this.a.y0.getForumId());
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
                        boolean y = ((TbImageView) view2).y();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, y)));
                        }
                        this.a.Q = view2;
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.s6(str, i, eVar);
                    if (this.a.y0.G.h0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view2.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view2.getParent();
                        } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                        }
                        int i5 = -1;
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().Z() != null) {
                            ArrayList<TbRichTextImageInfo> Z = tbRichTextView.getRichText().Z();
                            int i6 = 0;
                            int i7 = -1;
                            while (i6 < Z.size()) {
                                if (Z.get(i6) != null) {
                                    arrayList.add(Z.get(i6).getSrc());
                                    if (i7 == i5 && str != null && (str.equals(Z.get(i6).getSrc()) || str.equals(Z.get(i6).W()) || str.equals(Z.get(i6).V()) || str.equals(Z.get(i6).getBigSrc()) || str.equals(Z.get(i6).Y()))) {
                                        i7 = i6;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    String src = Z.get(i6).getSrc();
                                    imageUrlData.imageUrl = src;
                                    imageUrlData.imageThumbUrl = src;
                                    if (this.a.q) {
                                        i4 = 17;
                                    } else {
                                        i4 = 18;
                                    }
                                    imageUrlData.urlThumbType = i4;
                                    imageUrlData.originalUrl = Z.get(i6).getSrc();
                                    imageUrlData.isLongPic = Z.get(i6).c0();
                                    concurrentHashMap.put(Z.get(i6).getSrc(), imageUrlData);
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
                        this.a.p5(rect);
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.A(arrayList);
                        builder.E(i3);
                        builder.F(false);
                        builder.O(eVar.f);
                        builder.I(this.a.y0.K1());
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(this.a.a6());
                        builder.P(rect, UtilHelper.fixedDrawableRect(rect, view2));
                        if (this.a.y0 != null) {
                            builder.D(this.a.y0.getFromForumId());
                            if (this.a.y0.z1() != null) {
                                builder.Q(this.a.y0.z1().M());
                            }
                        }
                        ImageViewerConfig x = builder.x(this.a.getPageContext().getPageActivity());
                        x.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else if (!eVar.h) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList2)) {
                            String str2 = (String) arrayList2.get(0);
                            concurrentHashMap2.put(str2, eVar.b.get(str2));
                        }
                        ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                        builder2.A(arrayList2);
                        builder2.C(eVar.c);
                        builder2.B(eVar.d);
                        builder2.R(eVar.e);
                        builder2.F(eVar.g);
                        builder2.K(true);
                        builder2.M(eVar.a.get(0));
                        builder2.I(this.a.y0.K1());
                        builder2.y(concurrentHashMap2);
                        builder2.N(false);
                        builder2.J(this.a.a6());
                        builder2.O(eVar.f);
                        builder2.z(eVar.f);
                        builder2.G(false);
                        if (this.a.y0 != null) {
                            builder2.D(this.a.y0.getFromForumId());
                            if (this.a.y0.z1() != null) {
                                builder2.Q(this.a.y0.z1().M());
                            }
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText p7 = this.a.p7(str, i);
                        if (p7 != null && this.a.x2 >= 0 && this.a.x2 < p7.X().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = rv8.a(p7.X().get(this.a.x2));
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
                            if (p7.getPostId() != 0 && (G0 = this.a.G0.G0()) != null) {
                                ArrayList<in> v = G0.v();
                                if (ListUtils.getCount(v) > 0) {
                                    Iterator<in> it = v.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        in next = it.next();
                                        if ((next instanceof pp9) && p7.getPostId() == gg.g(((pp9) next).N(), 0L)) {
                                            int i9 = 8;
                                            if (p7.getPostId() == gg.g(this.a.y0.X0(), 0L)) {
                                                i9 = 1;
                                            }
                                            v29.b(this.a.y0.z1(), (pp9) next, ((pp9) next).d0, i9, 3);
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
                            this.a.p5(rect2);
                            ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                            builder3.A(arrayList3);
                            builder3.C(eVar.c);
                            builder3.B(eVar.d);
                            builder3.R(eVar.e);
                            builder3.F(eVar.g);
                            builder3.K(true);
                            builder3.M(eVar.i);
                            builder3.I(this.a.y0.K1());
                            builder3.y(concurrentHashMap3);
                            builder3.N(false);
                            builder3.J(this.a.a6());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            builder3.P(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                            if (this.a.y0 != null) {
                                builder3.D(this.a.y0.getFromForumId());
                                if (this.a.y0.z1() != null) {
                                    builder3.Q(this.a.y0.z1().M());
                                }
                            }
                            ImageViewerConfig x3 = builder3.x(this.a.getPageContext().getPageActivity());
                            x3.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, x3));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.h(false);
                bdTopToast.g(this.a.getString(R.string.novel_thread_mask_click_tip));
                bdTopToast.i((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
                if (this.a.G0 != null) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.G0.o1());
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
                    BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                    bdTopToast.h(true);
                    bdTopToast.g(this.a.getString(R.string.block_user_success));
                    bdTopToast.i((ViewGroup) this.a.getView());
                    this.a.M6(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d30);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                bdTopToast2.h(false);
                bdTopToast2.g(errorString);
                bdTopToast2.i((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r2 implements w05.c {
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

        @Override // com.baidu.tieba.w05.c
        public void a(w05 w05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, w05Var, i, view2) == null) {
                if (w05Var != null) {
                    w05Var.e();
                }
                PbFragment pbFragment = this.a;
                pp9 pp9Var = pbFragment.A2;
                if (pp9Var != null) {
                    if (i == 0) {
                        pp9Var.J0();
                        this.a.A2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.k6(pbFragment2.A2);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921658) {
                int error = customResponsedMessage.getError();
                if (!(customResponsedMessage.getData() instanceof Boolean)) {
                    return;
                }
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (error != 0 || !booleanValue || !TbadkCoreApplication.isLogin() || this.a.A0 == null || this.a.A0.e()) {
                    return;
                }
                this.a.i6();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.f1) {
                this.a.G0.u1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                qv8 z1 = this.a.y0.z1();
                if (z1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    z1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.e1.d(this.a.d1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.d1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.b7(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (hi.isEmpty(errorString2)) {
                        errorString2 = this.a.d1.getResources().getString(R.string.mute_fail);
                    }
                    this.a.e1.c(errorString2);
                } else {
                    this.a.U6();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s1 implements ct4.a {
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

        @Override // com.baidu.tieba.ct4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.G0.n3();
                if (z) {
                    if (this.a.A0 != null) {
                        this.a.A0.h(z2);
                    }
                    this.a.y0.n3(z2);
                    if (!this.a.y0.k1()) {
                        this.a.G0.J1(this.a.y0.z1());
                    } else {
                        this.a.g6();
                    }
                    if (z2) {
                        boolean n0 = this.a.y0.z1().n0();
                        if (this.a.A0 != null && !n0) {
                            if (this.a.A0.f() != null && this.a.y0 != null && this.a.y0.z1() != null && this.a.y0.z1().M() != null && this.a.y0.z1().M().getAuthor() != null) {
                                MarkData f = this.a.A0.f();
                                MetaData author = this.a.y0.z1().M().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00d3);
                                        this.a.Y6();
                                    } else {
                                        this.a.T6(author);
                                    }
                                } else {
                                    PbFragment pbFragment = this.a;
                                    pbFragment.showToast(pbFragment.getPageContext().getString(R.string.add_mark));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.V4();
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

    /* loaded from: classes5.dex */
    public class s2 implements e3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.e3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.G0 != null && this.a.G0.g1() != null) {
                    py8 g1 = this.a.G0.g1();
                    if (g1.j()) {
                        g1.h();
                        return true;
                    }
                }
                if (this.a.G0 != null && this.a.G0.V1()) {
                    this.a.G0.y1();
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class t implements TiePlusEventController.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public t(PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
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

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.f1) {
                this.a.G0.u1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.e1.d(this.a.d1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (hi.isEmpty(muteMessage)) {
                    muteMessage = this.a.d1.getResources().getString(R.string.un_mute_fail);
                }
                this.a.e1.c(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t1 implements u05.e {
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

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                u05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t2 implements w05.c {
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

        @Override // com.baidu.tieba.w05.c
        public void a(w05 w05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, w05Var, i, view2) == null) {
                if (w05Var != null) {
                    w05Var.e();
                }
                if (this.a.i1 != null && !TextUtils.isEmpty(this.a.j1)) {
                    if (i == 0) {
                        if (this.a.l1 != null) {
                            lg5.a aVar = new lg5.a();
                            aVar.a = this.a.j1;
                            String str = "";
                            if (this.a.l1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.l1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        } else {
                            this.a.W4();
                        }
                    } else if (i == 1) {
                        if (this.a.W0 == null) {
                            this.a.W0 = new PermissionJudgePolicy();
                        }
                        this.a.W0.clearRequestPermissionList();
                        this.a.W0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.W0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.h1 == null) {
                            PbFragment pbFragment = this.a;
                            pbFragment.h1 = new yz8(pbFragment.getPageContext());
                        }
                        this.a.h1.b(this.a.j1, this.a.i1.n());
                    }
                    this.a.i1 = null;
                    this.a.j1 = null;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
                if (!this.a.Y5() || this.a.a == null || this.a.a.K1() == null || !str.equals(this.a.a.K1().getTopicId())) {
                    return;
                }
                this.a.k7(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements u05.e {
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

        @Override // com.baidu.tieba.u05.e
        public void onClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                u05Var.dismiss();
                this.b.C0.i(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.y0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.y0 == null || this.a.y0.I1() == i + 1) {
                return;
            }
            this.a.G6(sz8.o(i));
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ly4)) {
                ly4 ly4Var = (ly4) customResponsedMessage.getData();
                ez4.a aVar = new ez4.a();
                int i = ly4Var.a;
                String str = ly4Var.b;
                aVar.a = ly4Var.d;
                qv8 z1 = this.a.y0.z1();
                if (z1 == null) {
                    return;
                }
                if (this.a.y0.b1() != null && this.a.y0.b1().getUserIdLong() == ly4Var.p) {
                    this.a.G0.F2(ly4Var.l, this.a.y0.z1(), this.a.y0.R1(), this.a.y0.J1());
                }
                if (z1.F() != null && z1.F().size() >= 1 && z1.F().get(0) != null) {
                    long g = gg.g(z1.F().get(0).N(), 0L);
                    long g2 = gg.g(this.a.y0.S1(), 0L);
                    if (g == ly4Var.n && g2 == ly4Var.m) {
                        ez4 L = z1.F().get(0).L();
                        if (L == null) {
                            L = new ez4();
                        }
                        ArrayList<ez4.a> a = L.a();
                        if (a == null) {
                            a = new ArrayList<>();
                        }
                        a.add(0, aVar);
                        L.e(L.b() + ly4Var.l);
                        L.d(a);
                        z1.F().get(0).P0(L);
                        this.a.G0.G0().d0();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof kx9) && customResponsedMessage.getOrginalMessage().getTag() == this.a.f1) {
                kx9 kx9Var = (kx9) customResponsedMessage.getData();
                this.a.G0.u1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.c1;
                DataRes dataRes = kx9Var.a;
                boolean z = false;
                if (kx9Var.c == 0 && dataRes != null) {
                    int e = gg.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (e == 1) {
                        z = true;
                    }
                    if (hi.isEmpty(str)) {
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
                        this.a.G0.u2(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.V6(z, sparseArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements AbsListView.OnScrollListener {
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

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<pp9> F;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.y0 != null && this.a.y0.z1() != null && this.a.G0 != null && this.a.G0.G0() != null) {
                this.a.G0.n2(absListView, i, i2, i3);
                if (this.a.e != null) {
                    this.a.e.q(absListView, i, i2, i3);
                }
                if (this.a.y0.n2() && (F = this.a.y0.z1().F()) != null && !F.isEmpty()) {
                    int y = ((i + i2) - this.a.G0.G0().y()) - 1;
                    qv8 z1 = this.a.y0.z1();
                    if (z1 == null) {
                        return;
                    }
                    if (z1.C() != null && z1.C().s1()) {
                        y--;
                    }
                    if (z1.D() != null && z1.D().s1()) {
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
                if (!sz8.z(this.a.b1) && sz8.z(i)) {
                    if (this.a.G0 != null) {
                        this.a.j0 = true;
                        this.a.G0.t0();
                        if (this.a.V0 != null && !this.a.G0.K1()) {
                            this.a.G0.T2(this.a.V0.y());
                        }
                        if (!this.a.I) {
                            this.a.j0 = true;
                            this.a.G0.M2();
                        }
                    }
                    if (!this.a.r) {
                        this.a.r = true;
                    }
                }
                if (this.a.G0 != null) {
                    this.a.G0.o2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.s == null) {
                    this.a.s = new wm5();
                    this.a.s.a(1001);
                }
                if (i == 0) {
                    this.a.s.e();
                    if (this.a.g0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.a.g0);
                        this.a.g0 = null;
                    }
                } else {
                    if (this.a.g0 == null) {
                        this.a.g0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("pb", "1", "scroll");
                    }
                    this.a.s.d();
                }
                this.a.b1 = i;
                if (i == 0) {
                    rn9.g().h(this.a.getUniqueId(), true);
                    this.a.Y4(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v2 implements f15.d {
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

        @Override // com.baidu.tieba.f15.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.M0 != null) {
                this.a.M0.q(n19.h(this.a.A2));
                ArrayList arrayList = new ArrayList();
                for (e15 e15Var : this.a.M0.g()) {
                    if (e15Var instanceof b15) {
                        arrayList.add((b15) e15Var);
                    }
                }
                n19.f(arrayList);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof lx5)) {
                lx5 lx5Var = (lx5) customResponsedMessage.getData();
                qv8 z1 = this.a.y0.z1();
                if (z1 == null) {
                    return;
                }
                if (this.a.y0.z1() != null && this.a.y0.z1().V().p() != null && this.a.y0.z1().V().p().getPortrait() != null && this.a.y0.z1().V().p().getPortrait().equals(lx5Var.a)) {
                    if (this.a.y0.z1().V().p().getUserWorldCupData() != null) {
                        this.a.y0.z1().V().p().getUserWorldCupData().d(lx5Var.b);
                    }
                    this.a.G0.G2(this.a.y0.z1(), this.a.y0.R1(), this.a.y0.J1(), this.a.G0.k1());
                }
                if (z1.F() != null && z1.F().size() >= 0) {
                    Iterator<pp9> it = z1.F().iterator();
                    while (it.hasNext()) {
                        pp9 next = it.next();
                        if (next != null && next.p() != null && next.p().getPortrait() != null && next.p().getPortrait().equals(lx5Var.a) && next.p().getUserWorldCupData() != null) {
                            next.p().getUserWorldCupData().d(lx5Var.b);
                        }
                    }
                    this.a.G0.G0().d0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !this.a.G0.K1() || !(customResponsedMessage.getData() instanceof MotionEvent)) {
                return;
            }
            MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
            this.a.m5((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements if5 {
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

        @Override // com.baidu.tieba.if5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                wz8 wz8Var = this.a.K0;
                if (wz8Var != null && wz8Var.e() != null && this.a.K0.e().d()) {
                    PbFragment pbFragment = this.a;
                    pbFragment.showToast(pbFragment.K0.e().c());
                    if (this.a.V0 != null && (this.a.V0.x() || this.a.V0.z())) {
                        this.a.V0.w(false, this.a.K0.h());
                    }
                    this.a.K0.a(true);
                    return true;
                }
                return !this.a.c5(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
                return pbFragment.f5(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.y0 != null && this.a.y0.z1() != null) {
                this.a.y0.z1().a();
                this.a.y0.d2();
                if (this.a.G0.G0() != null) {
                    this.a.G0.J1(this.a.y0.z1());
                }
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            fp9 fp9Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof fp9) && (fp9Var = (fp9) customResponsedMessage.getData()) != null && (agreeData = fp9Var.b) != null) {
                if (this.a.G0 != null) {
                    this.a.G0.a2(fp9Var);
                }
                if (agreeData.agreeType == 2 && this.a.G0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !q19.h(this.a.y0.b)) {
                    this.a.G0.W3();
                    q19.b(this.a.y0.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements Comparator<yb5> {
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
        public int compare(yb5 yb5Var, yb5 yb5Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, yb5Var, yb5Var2)) == null) {
                return yb5Var.compareTo(yb5Var2);
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
            op9 h;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.y0 != null && this.a.y0.z1() != null) {
                String str = (String) customResponsedMessage.getData();
                op9 op9Var = null;
                if (!TextUtils.isEmpty(str) && this.a.y0.z1().F() != null) {
                    ArrayList<pp9> F = this.a.y0.z1().F();
                    Iterator<pp9> it = F.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        pp9 next = it.next();
                        if (next instanceof op9) {
                            op9 op9Var2 = (op9) next;
                            if (str.equals(op9Var2.t1())) {
                                op9Var = op9Var2;
                                break;
                            }
                        }
                    }
                    if (op9Var != null) {
                        F.remove(op9Var);
                    }
                }
                if (this.a.G0.G0() != null && !ListUtils.isEmpty(this.a.G0.G0().v())) {
                    ArrayList<in> v = this.a.G0.G0().v();
                    if (op9Var != null) {
                        h = op9Var;
                    } else {
                        h = sz8.h(this.a.y0.z1(), str);
                    }
                    sz8.d(v, h);
                }
                if (this.a.G0.W0() != null && !ListUtils.isEmpty(this.a.G0.W0().getData())) {
                    List<in> data = this.a.G0.W0().getData();
                    if (op9Var == null) {
                        op9Var = sz8.h(this.a.y0.z1(), str);
                    }
                    sz8.d(data, op9Var);
                }
                this.a.h5(str);
                this.a.y0.d2();
                if (this.a.G0.G0() != null) {
                    this.a.G0.G0().d0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.I5() != null) {
                this.a.I5().k2();
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void onNavigationButtonClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(u05 u05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
            this.a.i5();
        }
    }

    /* loaded from: classes5.dex */
    public class z0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z0(PbFragment pbFragment, int i) {
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
                this.a.m1 = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z1 extends z8 {
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

        @Override // com.baidu.tieba.z8
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, obj) != null) || !this.a.isAdded()) {
                return;
            }
            boolean z = false;
            if (obj != null) {
                switch (this.a.B0.getLoadDataMode()) {
                    case 0:
                        this.a.y0.d2();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.n5(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.G0.C0(1, dVar.a, dVar.b, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        PbFragment pbFragment = this.a;
                        pbFragment.o5(pbFragment.B0.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        this.a.G0.C0(this.a.B0.getLoadDataMode(), gVar.a, gVar.b, false);
                        this.a.G0.p2(gVar.c);
                        return;
                    default:
                        return;
                }
            }
            this.a.G0.C0(this.a.B0.getLoadDataMode(), false, null, false);
        }
    }

    /* loaded from: classes5.dex */
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
        public void i(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.f && z && !this.a.y0.o1()) {
                    this.a.A6();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(ii.g(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0702ab));
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
        Q2 = new a1();
        R2 = new a();
    }

    public static PbFragment m6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65668, null)) == null) {
            return new PbFragment();
        }
        return (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fw5
    public xf<LinearLayout> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.D == null) {
                this.D = new xf<>(new a3(this), 15, 0);
            }
            return this.D;
        }
        return (xf) invokeV.objValue;
    }

    public boolean A5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.k2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final void A6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            hideNetRefreshView(this.G0.o1());
            W6();
            if (this.y0.z2()) {
                this.G0.o3();
            }
            this.G0.x3();
        }
    }

    public boolean B5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.J;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fw5
    /* renamed from: C5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            tz8 tz8Var = this.G0;
            if (tz8Var == null) {
                return null;
            }
            return tz8Var.W0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public void C6() {
        gb5 gb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (gb5Var = this.i0) != null) {
            gb5Var.x();
        }
    }

    public int D5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.M2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.fw5
    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            tz8 tz8Var = this.G0;
            if (tz8Var == null) {
                return 0;
            }
            return tz8Var.j1();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.fw5
    public xf<TiebaPlusRecommendCard> E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.C == null) {
                this.C = new xf<>(new m2(this), 5, 0);
            }
            return this.C;
        }
        return (xf) invokeV.objValue;
    }

    public int E5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.L2;
        }
        return invokeV.intValue;
    }

    public boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.r0;
        }
        return invokeV.booleanValue;
    }

    public mf5 F5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.V0;
        }
        return (mf5) invokeV.objValue;
    }

    public y09 G5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.e;
        }
        return (y09) invokeV.objValue;
    }

    public l19 H5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.t0;
        }
        return (l19) invokeV.objValue;
    }

    public tz8 I5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.G0;
        }
        return (tz8) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public xf<TbImageView> J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.z == null) {
                this.z = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.z;
        }
        return (xf) invokeV.objValue;
    }

    public x09 J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.a.J0();
        }
        return (x09) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z29
    public PbModel.h K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.n2;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public String K5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.U;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z29
    public PbModel Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.y0;
        }
        return (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z29
    public AbsPbActivity R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fw5
    public xf<RelativeLayout> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            xf<RelativeLayout> xfVar = new xf<>(new o2(this), 10, 0);
            this.E = xfVar;
            return xfVar;
        }
        return (xf) invokeV.objValue;
    }

    public void S5() {
        tz8 tz8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && (tz8Var = this.G0) != null) {
            tz8Var.s1();
            R5();
        }
    }

    @Override // com.baidu.tieba.fw5
    public xf<FestivalTipView> U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (this.G == null) {
                this.G = TbRichTextView.G(getPageContext().getPageActivity(), R.dimen.M_H_X004);
            }
            return this.G;
        }
        return (xf) invokeV.objValue;
    }

    public final void V5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.P = likeModel;
            likeModel.setLoadDataCallBack(new m0(this));
        }
    }

    @Override // com.baidu.tieba.fw5
    public xf<ImageView> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (this.A == null) {
                this.A = new xf<>(new k2(this), 8, 0);
            }
            return this.A;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fw5
    public xf<View> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (this.B == null) {
                this.B = new xf<>(new n2(this), 8, 0);
            }
            return this.B;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fw5
    public xf<TextView> X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (this.y == null) {
                this.y = TbRichTextView.H(getContext(), 8);
            }
            return this.y;
        }
        return (xf) invokeV.objValue;
    }

    public boolean X5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                return pbModel.e1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void X6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048646, this) == null) && hb5.g(TbadkCoreApplication.getInst(), 0) && !this.G0.x2()) {
            this.i0 = hb5.i(getPageContext(), "reply_pb", 0L);
        }
    }

    public final boolean Y5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null && absPbActivity.K1() != null && this.a.K1().y1() == 17) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean a6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                return pbModel.c1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void g6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            qv8 z12 = this.y0.z1();
            this.y0.n3(true);
            ct4 ct4Var = this.A0;
            if (ct4Var != null) {
                z12.I0(ct4Var.g());
            }
            this.G0.J1(z12);
        }
    }

    public final void g7() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048679, this) == null) && (voiceManager = this.i) != null) {
            voiceManager.stopPlay();
        }
    }

    public void h6() {
        tz8 tz8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048682, this) != null) || (tz8Var = this.G0) == null) {
            return;
        }
        tz8Var.X1();
    }

    public final void h7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048683, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.V1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.c0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public mn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (mn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            A6();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tieba.fw5
    public xf<ItemCardView> p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            if (this.F == null) {
                this.F = new xf<>(new p2(this), 10, 0);
            }
            return this.F;
        }
        return (xf) invokeV.objValue;
    }

    public AntiData q5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.z1() != null) {
                return this.y0.z1().c();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    public void q6() {
        gb5 gb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048732, this) == null) && (gb5Var = this.i0) != null) {
            gb5Var.q();
        }
    }

    public pp9 s5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            qv8 qv8Var = this.y0.G;
            if (qv8Var != null) {
                return qv8Var.V();
            }
            return null;
        }
        return (pp9) invokeV.objValue;
    }

    public int t5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            return this.P2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048740, this) == null) && (pbModel = this.y0) != null && !hi.isEmpty(pbModel.S1())) {
            super.taskStart();
        }
    }

    public String u5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) {
            return this.L;
        }
        return (String) invokeV.objValue;
    }

    public boolean v6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            gb5 gb5Var = this.i0;
            if (gb5Var != null && gb5Var.t()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fw5
    public xf<GifView> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            if (this.K == null) {
                this.K = new xf<>(new l2(this), 20, 0);
            }
            return this.K;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            return this.i;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public PbInterviewStatusView.f y5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            return this.w0;
        }
        return (PbInterviewStatusView.f) invokeV.objValue;
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.r2();
        }
        return invokeV.booleanValue;
    }

    public boolean z5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            if (!this.c && this.L2 == -1 && this.M2 == -1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
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
        this.H = false;
        this.I = false;
        this.J = false;
        this.L = "";
        this.M = true;
        this.N = false;
        this.O = "";
        this.V = 3;
        this.X = new int[2];
        this.Z = -1;
        this.a0 = -1;
        this.c0 = BdUniqueId.gen();
        this.e0 = false;
        this.s0 = new t(this);
        this.v0 = false;
        this.w0 = new e0(this);
        this.x0 = new Handler(new p0(this));
        this.y0 = null;
        this.A0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.F0 = null;
        this.G0 = null;
        this.H0 = false;
        this.I0 = false;
        this.J0 = false;
        this.O0 = false;
        this.Q0 = false;
        this.S0 = false;
        this.Y0 = new l1(this);
        this.Z0 = new w1(this);
        this.a1 = new h2(this);
        this.b1 = 0;
        this.m1 = false;
        this.n1 = 0;
        this.o1 = -1;
        this.q1 = 0;
        this.s1 = new s2(this);
        this.t1 = new d3(this);
        this.u1 = new j(this, 2004016);
        this.v1 = new k(this, 2016485);
        this.w1 = new l(this, 2001269);
        this.x1 = new m(this, 2004008);
        this.y1 = new n(this, 2004007);
        this.z1 = new o(this, 2004005);
        this.A1 = new p(this, 2001332);
        this.B1 = new q(this, 2921391);
        this.C1 = new r(this, 2921606);
        this.D1 = new s(this, 2921658);
        this.E1 = new u(this);
        this.F1 = new v(this, 2001369);
        this.G1 = new w(this, 2921787);
        this.H1 = new x(this, 2016488);
        this.I1 = new y(this, 2016331);
        this.J1 = new z(this, 2921746);
        this.K1 = new a0(this);
        this.L1 = new b0(this, 2010045);
        this.M1 = new c0(this);
        this.N1 = new PraiseModel(getPageContext(), new d0(this));
        this.O1 = new f0(this);
        this.P1 = new h0(this, 2001115);
        this.Q1 = new i0(this);
        this.R1 = new j0(this);
        this.T1 = new uw8(new o0(this));
        this.U1 = new r0(this);
        this.V1 = new s0(this, 2001427);
        this.W1 = new t0(this, 2001428);
        this.X1 = new u0(this, 2921634);
        this.Y1 = new v0(this, 2001426);
        this.Z1 = new w0(this, 2004021);
        this.a2 = new x0(this, 2016528);
        this.b2 = new y0(this, 2921724);
        this.c2 = new z0(this, 2921033);
        this.d2 = new b1(this);
        this.e2 = new c1(this);
        this.f2 = new d1(this);
        this.g2 = new g1(this);
        this.h2 = new j1(this);
        this.i2 = new k1(this, 2921480);
        this.j2 = new m1(this);
        this.k2 = Boolean.FALSE;
        this.l2 = new n1(this);
        this.m2 = new o1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.n2 = new p1(this);
        this.o2 = new q1(this, 2016450);
        this.p2 = new r1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.q2 = new s1(this);
        this.r2 = new v1(this);
        this.s2 = new z1(this);
        this.t2 = new b2(this);
        this.u2 = new c2(this);
        this.w2 = new d2(this);
        this.x2 = 0;
        this.y2 = new q2(this);
        this.z2 = false;
        this.A2 = null;
        this.B2 = new r2(this);
        this.C2 = new t2(this);
        this.D2 = new u2(this);
        this.E2 = new w2(this);
        this.F2 = new x2(this);
        this.G2 = new y2(this);
        this.H2 = new z2(this);
        this.I2 = new b3(this);
        this.J2 = new c3(this);
        this.K2 = new b(this);
        this.L2 = -1;
        this.M2 = -1;
        this.P2 = 0;
    }

    @Override // com.baidu.tieba.fw5
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.u = true;
        }
    }

    @Override // com.baidu.tieba.fw5
    public void K(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, str) == null) {
            zz8.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.u = true;
        }
    }

    public final void T5(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048629, this, i3, i4) == null) {
            zr5.b(new h(this, i4), new i(this, i4, i3));
        }
    }

    @Override // com.baidu.tieba.fw5
    public void k0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048691, this, context, str) == null) {
            this.u = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        tz8 tz8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048717, this, i3, keyEvent)) == null) {
            if (keyEvent != null && (tz8Var = this.G0) != null) {
                return tz8Var.f2(i3);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void B6(e3 e3Var) {
        List<e3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, e3Var) == null) && e3Var != null && (list = this.p1) != null) {
            list.remove(e3Var);
        }
    }

    public final void G6(int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i3) == null) && this.y0 != null) {
            W6();
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
            privacySettingMessage.setTid(this.y0.b);
            sendMessage(privacySettingMessage);
        }
    }

    public void H6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i3) == null) {
            this.P2 = i3;
        }
    }

    public void I6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z3) == null) {
            this.k2 = Boolean.valueOf(z3);
        }
    }

    public void J6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z3) == null) {
            this.r0 = z3;
        }
    }

    public void K6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z3) == null) {
            this.M = z3;
        }
    }

    public void N6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z3) == null) {
            this.J = z3;
        }
    }

    public final void O6(boolean z3) {
        mf5 mf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048616, this, z3) != null) || (mf5Var = this.V0) == null) {
            return;
        }
        mf5Var.X(z3);
        this.V0.a0(z3);
        this.V0.i0(z3);
    }

    public final void Q5(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, intent) == null) {
            q19.g(this, intent);
        }
    }

    public void T4(e3 e3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, e3Var) == null) && e3Var != null) {
            if (this.p1 == null) {
                this.p1 = new ArrayList();
            }
            if (!this.p1.contains(e3Var)) {
                this.p1.add(e3Var);
            }
        }
    }

    public void U4(e3 e3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, e3Var) == null) && e3Var != null) {
            if (this.p1 == null) {
                this.p1 = new ArrayList();
            }
            if (!this.p1.contains(e3Var)) {
                this.p1.add(0, e3Var);
            }
        }
    }

    public final void a7(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i3) == null) {
            q19.j(this, r5(), i3);
        }
    }

    public final void b6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            pt4.y(getContext(), "", str, false, true, true, bundle);
        }
    }

    @Override // com.baidu.tieba.i39.b
    public void j1(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048687, this, z3) == null) {
            this.P0 = z3;
        }
    }

    public final void j6(View view2) {
        SparseArray sparseArray;
        pp9 pp9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (pp9Var = (pp9) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            k6(pp9Var);
        }
    }

    public final void n7(vx4 vx4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048702, this, vx4Var) == null) && vx4Var != null) {
            this.O2 = vx4Var;
            this.c = true;
            this.G0.K2();
            this.G0.c3(this.N2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tieba.u05.e
    public void onClick(u05 u05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, u05Var) == null) {
            k5(u05Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.f9
    public void onPreLoad(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, mnVar) == null) {
            PreLoadImageHelper.load(mnVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(mnVar, getUniqueId(), this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.y0.T2(bundle);
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            mf5 mf5Var = this.V0;
            if (mf5Var != null) {
                mf5Var.F(bundle);
            }
        }
    }

    public final boolean D6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof pp9)) {
                return false;
            }
            pp9 pp9Var = (pp9) obj;
            if (pp9Var.getType() != pp9.V0 && !TextUtils.isEmpty(pp9Var.r()) && iw4.c().g()) {
                return l6(pp9Var);
            }
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return true;
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.z1() != null) {
                if (I5().g1() != null) {
                    I5().g1().g();
                }
                gw8 gw8Var = new gw8();
                gw8Var.v(this.y0.z1().k());
                gw8Var.z(this.y0.z1().M());
                gw8Var.x(pp9Var);
                I5().f1().r0(gw8Var);
                I5().f1().setPostId(pp9Var.N());
                f6(view2, pp9Var.p().getUserId(), "", pp9Var);
                TiebaStatic.log("c11743");
                mf5 mf5Var = this.V0;
                if (mf5Var != null) {
                    this.G0.T2(mf5Var.y());
                }
                return true;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.u
    public void E0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048586, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (cw5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), cw5.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (zz8.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new dt5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.fw5
    public void Z(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048651, this, context, str, z3) == null) {
            if (zz8.c(str) && (pbModel = this.y0) != null && pbModel.S1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.y0.S1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    uc5 uc5Var = new uc5();
                    uc5Var.a = str;
                    uc5Var.b = 3;
                    uc5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, uc5Var));
                }
            } else {
                zz8.a().e(getPageContext(), str);
            }
            this.u = true;
        }
    }

    public final void E6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (pbModel = this.y0) != null && pbModel.z1() != null && this.y0.z1().M() != null && this.y0.z1().M().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        }
    }

    public final void F6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (pbModel = this.y0) != null && pbModel.z1() != null && this.y0.z1().M() != null && this.y0.z1().M().isVideoThreadType()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
        }
    }

    public void R5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && this.a != null && getPageContext() != null && getPageContext().getPageActivity() != null && this.a.getCurrentFocus() != null) {
            ii.z(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public final boolean S6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || !pbModel.R1()) {
                return false;
            }
            if (this.y0.x1() != null && this.y0.x1().c() == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void Y6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && !NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() && hb5.g(TbadkCoreApplication.getInst(), 0) && !this.G0.x2()) {
            this.i0 = hb5.i(getPageContext(), "collect", 0L);
        }
    }

    public final void d7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048667, this) == null) && (pbModel = this.y0) != null && !hi.isEmpty(pbModel.S1())) {
            dq4.w().Q(cq4.Z, gg.g(this.y0.S1(), 0L));
        }
    }

    public void n6() {
        List<e3> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048701, this) == null) && (list = this.p1) != null && !list.isEmpty()) {
            int size = this.p1.size();
            while (true) {
                size--;
                if (size <= -1 || this.p1.get(size).onBackPressed()) {
                    return;
                }
            }
        }
    }

    public final void o6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048704, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.G0.t0();
            if (this.h) {
                return;
            }
            g7();
            this.G0.o3();
            if (this.y0.loadData()) {
                this.G0.T3();
            }
        }
    }

    public final int r5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            if (this.y0.z1() != null && this.y0.z1().M() != null) {
                return this.y0.z1().M().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void J5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (this.E0 == null) {
                PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
                this.E0 = pollingModel;
                pollingModel.M0(q15.e);
            }
            this.E0.C0(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            jg.a().postDelayed(this.U1, 10000L);
        }
    }

    public final void U6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            u05 u05Var = new u05(getPageContext().getPageActivity());
            u05Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            u05Var.setPositiveButton(R.string.open_now, new c(this));
            u05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new d(this));
            u05Var.create(this.d1).show();
        }
    }

    public final void W4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            if (this.k1 != null) {
                lg5.b bVar = new lg5.b();
                bVar.a = this.k1.Y();
                bVar.b = this.k1.W();
                bVar.c = String.valueOf(this.k1.Z());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, bVar));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.j1));
        }
    }

    public final void W6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            showLoadingView(this.G0.o1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702bc));
            View j3 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j3.getLayoutParams();
            layoutParams.addRule(3, this.G0.n1().getId());
            j3.setLayoutParams(layoutParams);
        }
    }

    public final boolean Z4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.z1() == null) {
                return false;
            }
            ThreadData M = this.y0.z1().M();
            AntiData c4 = this.y0.z1().c();
            if (!AntiHelper.b(getPageContext(), M) && !AntiHelper.d(getPageContext(), c4)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean Z5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            pp9 c4 = rv8.c(this.y0.z1(), this.y0.R1(), this.y0.J1());
            if (c4 != null && c4.p() != null && c4.p().getGodUserData() != null && c4.p().getGodUserData().getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean b5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            if ((this.y0.z1() != null && (this.y0.z1().h0() || ThreadCardUtils.isSelf(this.y0.z1().M()))) || this.X0 == null || this.y0.z1() == null || this.y0.z1().c() == null) {
                return true;
            }
            return this.X0.checkPrivacyBeforeInvokeEditor(this.y0.z1().c().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void c6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048662, this) == null) && this.O2 != null) {
            if (this.M2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0ed7);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.O2.a(), this.M2, 0)));
                this.a.finish();
            }
        }
    }

    public final void e5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            if (this.y0.e1() || this.y0.h1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.y0.S1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.y0.S1()));
            if (i7()) {
                this.a.finish();
            }
        }
    }

    public final void e6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048669, this) == null) && this.O2 != null) {
            if (this.L2 == -1) {
                showToast(R.string.obfuscated_res_0x7f0f0ed8);
            } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ViewHelper.skipToLoginActivity(getActivity());
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.O2.a(), this.L2, 0)));
                this.a.finish();
            }
        }
    }

    public final void j7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048690, this) == null) && (absPbActivity = this.a) != null && absPbActivity.K1() != null) {
            TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.K1().S1()).param("topic_id", this.a.K1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.K1().W1()));
        }
    }

    public final void m7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048699, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.a0(this.y0.getForumId()) && this.y0.z1() != null && this.y0.z1().k() != null) {
            boolean z3 = true;
            if (this.y0.z1().k().isLike() != 1) {
                z3 = false;
            }
            if (z3) {
                this.y0.N0().Z(this.y0.getForumId(), this.y0.S1());
            }
        }
    }

    public void L5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (this.f) {
                this.N = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null && this.y0.z1() != null && this.y0.z1().M() != null && this.y0.z1().M().getTaskInfoData() != null) {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.y0.z1().M().getTaskInfoData().k(), this.y0.z1().M().getTaskInfoData().h(), this.y0.z1().M().getTaskInfoData().c(), this.y0.z1().M().getTaskInfoData().d(), this.y0.z1().M().getIs_top(), this.y0.z1().M().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void i5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.z1() != null) {
                op9 z3 = this.y0.z1().z();
                if (z3 != null) {
                    if (z3.getAdvertAppInfo() != null) {
                        z3.getAdvertAppInfo().h = null;
                    }
                    this.y0.z1().b();
                }
                if (this.y0.S0() != null) {
                    this.y0.F0();
                }
                this.y0.d2();
            }
            if (this.y0.z1().F() != null) {
                Iterator<pp9> it = this.y0.z1().F().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof op9) {
                        it.remove();
                    }
                }
            }
            if (this.G0.G0() != null && !ListUtils.isEmpty(this.G0.G0().v())) {
                sz8.c(this.G0.G0().v());
            }
            if (this.G0.W0() != null && !ListUtils.isEmpty(this.G0.W0().getData())) {
                sz8.c(this.G0.W0().getData());
            }
            if (this.G0.G0() != null) {
                this.G0.G0().d0();
            }
        }
    }

    public final boolean i7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.z1() != null && this.y0.z1().h0()) {
                return true;
            }
            if (this.y0.k1()) {
                MarkData V0 = this.y0.V0();
                if (V0 == null || !this.y0.i1()) {
                    return true;
                }
                MarkData Q0 = this.y0.Q0(this.G0.N0());
                if (Q0 == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", V0);
                    this.a.setResult(-1, intent);
                    return true;
                } else if (Q0.getPostId() != null && !Q0.getPostId().equals(V0.getPostId())) {
                    u05 u05Var = new u05(getPageContext().getPageActivity());
                    u05Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f026c));
                    u05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0465, new g2(this, Q0, V0, u05Var));
                    u05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new i2(this, V0, u05Var));
                    u05Var.setOnCalcelListener(new j2(this, V0, u05Var));
                    u05Var.create(getPageContext());
                    u05Var.show();
                    return false;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", V0);
                    this.a.setResult(-1, intent2);
                    return true;
                }
            }
            if (this.y0.z1() != null && this.y0.z1().F() != null && this.y0.z1().F().size() > 0 && this.y0.i1()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            this.f = false;
            super.onResume();
            if (this.N) {
                this.N = false;
                L5();
            }
            if (Z5()) {
                this.t = System.currentTimeMillis();
            } else {
                this.t = -1L;
            }
            tz8 tz8Var = this.G0;
            if (tz8Var != null && tz8Var.o1() != null) {
                if (!this.g) {
                    W6();
                } else {
                    hideLoadingView(this.G0.o1());
                }
                this.G0.l2();
            }
            if (this.j == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            NoNetworkView noNetworkView = null;
            tz8 tz8Var2 = this.G0;
            if (tz8Var2 != null) {
                noNetworkView = tz8Var2.a();
            }
            if (noNetworkView != null && noNetworkView.getVisibility() == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.update(false);
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.A1);
            this.P0 = false;
            F6();
            registerListener(this.V1);
            registerListener(this.W1);
            registerListener(this.Y1);
            PushPermissionController pushPermissionController = this.u0;
            if (pushPermissionController != null) {
                pushPermissionController.registerListener(2921760);
            }
            if (this.m1) {
                A6();
                this.m1 = false;
            }
            d7();
            ItemCardHelper.w(this.G2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                cd5.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            super.onStop();
            if (this.t > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.t;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.t = 0L;
            }
            if (I5().g1() != null) {
                I5().g1().n();
            }
            a29 a29Var = this.G0.h;
            if (a29Var != null && !a29Var.m()) {
                this.G0.h.q();
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.z1() != null && this.y0.z1().k() != null && this.y0.z1().M() != null) {
                zc5.j().x(getPageContext().getPageActivity(), "pb", this.y0.z1().k().getId(), gg.g(this.y0.z1().M().getId(), 0L));
            }
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            rn9.g().h(getUniqueId(), false);
        }
    }

    public void t6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.z1() != null && this.y0.z1().k() != null) {
                if (Z4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.y0.z1().h0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.G0.k0();
                    return;
                } else {
                    mf5 mf5Var = this.V0;
                    if (mf5Var != null && mf5Var.b() != null) {
                        this.V0.b().C(new jd5(45, 27, null));
                    }
                    this.G0.k0();
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final String v5() {
        InterceptResult invokeV;
        ArrayList<pp9> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.z1() == null || this.y0.z1().F() == null || (count = ListUtils.getCount((F = this.y0.z1().F()))) == 0) {
                return "";
            }
            if (this.y0.K1()) {
                Iterator<pp9> it = F.iterator();
                while (it.hasNext()) {
                    pp9 next = it.next();
                    if (next != null && next.D() == 1) {
                        return next.N();
                    }
                }
            }
            int N0 = this.G0.N0();
            pp9 pp9Var = (pp9) ListUtils.getItem(F, N0);
            if (pp9Var != null && pp9Var.p() != null) {
                if (this.y0.s2(pp9Var.p().getUserId())) {
                    return pp9Var.N();
                }
                for (int i3 = N0 - 1; i3 != 0; i3--) {
                    pp9 pp9Var2 = (pp9) ListUtils.getItem(F, i3);
                    if (pp9Var2 == null || pp9Var2.p() == null || pp9Var2.p().getUserId() == null) {
                        break;
                    } else if (this.y0.s2(pp9Var2.p().getUserId())) {
                        return pp9Var2.N();
                    }
                }
                for (int i4 = N0 + 1; i4 < count; i4++) {
                    pp9 pp9Var3 = (pp9) ListUtils.getItem(F, i4);
                    if (pp9Var3 == null || pp9Var3.p() == null || pp9Var3.p().getUserId() == null) {
                        break;
                    } else if (this.y0.s2(pp9Var3.p().getUserId())) {
                        return pp9Var3.N();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void L6(of5 of5Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, of5Var) == null) && of5Var != null && (pbModel = this.y0) != null) {
            of5Var.p(pbModel.Y0());
            if (this.y0.z1() != null && this.y0.z1().k() != null) {
                of5Var.o(this.y0.z1().k());
            }
            of5Var.q("pb");
            of5Var.r(this.y0);
        }
    }

    public final void M6(int i3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048611, this, i3) != null) || (pbModel = this.y0) == null) {
            return;
        }
        int I1 = pbModel.I1();
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    this.y0.h3(1);
                } else {
                    this.y0.h3(4);
                }
            } else {
                this.y0.h3(3);
            }
        } else {
            this.y0.h3(2);
        }
        int I12 = this.y0.I1();
        if (I1 == 4 || I12 == 4) {
            o6();
        }
    }

    public final void U5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, bundle) == null) {
            ct4 c4 = ct4.c(this.a);
            this.A0 = c4;
            if (c4 != null) {
                c4.j(this.q2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.B0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.s2);
            this.C0 = new ja5(getPageContext());
            J5();
            this.N1.setUniqueId(getUniqueId());
            this.N1.registerListener();
        }
    }

    public void a5(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.G0.J3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = gg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = gg.g((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.f1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.c1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean c5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048661, this, i3)) == null) {
            if (this.X0 != null && this.y0.z1() != null && !ThreadCardUtils.isSelf(this.y0.z1().M()) && this.y0.z1().c() != null) {
                return this.X0.checkPrivacyBeforeSend(this.y0.z1().c().replyPrivateFlag, i3);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void d6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, bundle) == null) {
            PbModel K1 = this.a.K1();
            this.y0 = K1;
            if (K1 != null) {
                if (K1.U0() != null) {
                    this.y0.U0().c(this.K2);
                }
                if (this.y0.v1() != null) {
                    this.y0.v1().f(this.t1);
                }
                if (StringUtils.isNull(this.y0.S1())) {
                    this.a.finish();
                } else if ("from_tieba_kuang".equals(this.L) && this.L != null) {
                    this.y0.e3(6);
                }
            }
        }
    }

    public final void k7(boolean z3) {
        AbsPbActivity absPbActivity;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048694, this, z3) == null) && (absPbActivity = this.a) != null && absPbActivity.K1() != null) {
            if (!z3) {
                str = "c14397";
            } else {
                str = "c14398";
            }
            TiebaStatic.log(new StatisticItem(str).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.K1().S1()).param("topic_id", this.a.K1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.K1().W1()));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        qv8 z12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (I5() != null && sz8.B(this)) {
                I5().d4();
            }
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f090775));
            PbModel pbModel = this.y0;
            if (pbModel != null && (z12 = pbModel.z1()) != null) {
                this.n2.c(true, 0, 3, 0, z12, "", 1);
            }
            this.a.M1().l(this.s0);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z3;
        tz8 tz8Var;
        a29 a29Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (UtilHelper.isFoldScreen() && (tz8Var = this.G0) != null && (a29Var = tz8Var.h) != null && a29Var.m()) {
                this.G0.h.f();
                p6();
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
            this.I = z3;
            tz8 tz8Var2 = this.G0;
            if (tz8Var2 != null) {
                tz8Var2.c2(configuration);
            }
            d15 d15Var = this.L0;
            if (d15Var != null) {
                d15Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    public void r6(Animator.AnimatorListener animatorListener) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048734, this, animatorListener) == null) && this.G0 != null && (pbModel = this.y0) != null && pbModel.z1() != null && this.y0.z1().Q() != null && checkUpIsLogin() && this.G0.G0() != null && this.G0.G0().B() != null) {
            this.G0.G0().B().H(animatorListener);
        }
    }

    public final void M5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 4).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
        }
    }

    public final void b7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            if (str == null) {
                str = "";
            }
            a9 a9Var = this.d1;
            if (a9Var == null) {
                return;
            }
            u05 u05Var = new u05(a9Var.getPageActivity());
            u05Var.setMessage(str);
            u05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a77, new e(this));
            u05Var.create(this.d1).show();
        }
    }

    public final void e7(SparseArray<Object> sparseArray) {
        pp9 pp9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048670, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof pp9) || (pp9Var = (pp9) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        f7(pp9Var, false);
    }

    public final void l7(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048697, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.y0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(n19.n(i3))));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048726, this, z3) == null) {
            super.onUserChanged(z3);
            this.G0.i4(z3);
            d15 d15Var = this.L0;
            if (d15Var != null) {
                d15Var.dismiss();
            }
            if (z3 && this.P0) {
                this.G0.p3();
                this.y0.v2(true);
            }
            if (this.G0.G0() != null) {
                this.G0.G0().h0(z3);
            }
        }
    }

    public final void p5(Rect rect) {
        tz8 tz8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048728, this, rect) == null) && rect != null && (tz8Var = this.G0) != null && tz8Var.n1() != null && rect.top <= this.G0.n1().getHeight()) {
            rect.top += this.G0.n1().getHeight() - rect.top;
        }
    }

    public final void w6(View view2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048746, this, view2) != null) || view2 == null) {
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

    public final void N5(int i3, Intent intent) {
        vd5 vd5Var;
        vd5 vd5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048613, this, i3, intent) == null) {
            if (i3 == 0) {
                this.G0.s1();
                this.G0.g1().g();
                this.G0.B3(false);
            }
            this.G0.M2();
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
                if (editorType == 1 && this.G0.g1() != null && this.G0.g1().f() != null) {
                    qf5 f4 = this.G0.g1().f();
                    f4.d0(this.y0.z1().M());
                    f4.C(writeData);
                    f4.e0(pbEditorData.getVoiceModel());
                    ud5 p3 = f4.b().p(6);
                    if (p3 != null && (vd5Var2 = p3.m) != null) {
                        vd5Var2.C(new jd5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        f4.G();
                        return;
                    }
                    return;
                }
                return;
            }
            mf5 mf5Var = this.V0;
            if (mf5Var != null) {
                mf5Var.L();
                this.V0.m0(pbEditorData.getVoiceModel());
                this.V0.B(writeData);
                ud5 p4 = this.V0.b().p(6);
                if (p4 != null && (vd5Var = p4.m) != null) {
                    vd5Var.C(new jd5(52, 0, pbEditorData.getVoiceModel()));
                }
                this.V0.h0(pbEditorData.isShowCustomFigure());
                if (i3 == -1) {
                    this.V0.G(null, null);
                }
            }
        }
    }

    public final void Q6(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048621, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (I5() != null) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    String questionMsg = postWriteCallBackData.getQuestionMsg();
                    String questionExp = postWriteCallBackData.getQuestionExp();
                    if (postWriteCallBackData.getIconStampData() != null) {
                        kb5.c(getPageContext(), postWriteCallBackData, 2);
                        return;
                    } else if (postWriteCallBackData.getToast() != null) {
                        return;
                    } else {
                        if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                            wu8.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                            return;
                        } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                            wu8.f(errorString + " " + preMsg, colorMsg);
                            return;
                        } else if (StringUtils.isNull(errorString)) {
                            wu8.e(getResources().getString(R.string.obfuscated_res_0x7f0f1310));
                            return;
                        } else {
                            wu8.e(errorString);
                            return;
                        }
                    }
                }
                return;
            }
            if (!this.y0.m1()) {
                antiData.setBlock_forum_name(this.y0.z1().k().getName());
                antiData.setBlock_forum_id(this.y0.z1().k().getId());
                antiData.setUser_name(this.y0.z1().T().getUserName());
                antiData.setUser_id(this.y0.z1().T().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void V6(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048637, this, z3, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            d15 d15Var = this.L0;
            if (d15Var != null && d15Var.isShowing()) {
                this.L0.dismiss();
                this.L0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            f15 f15Var = new f15(getContext());
            f15Var.p(new g0(this, sparseArray, z3, str2, str));
            ArrayList arrayList = new ArrayList();
            int i3 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i3 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            }
            if (i3 == 1) {
                arrayList.add(new b15(0, getResources().getString(R.string.obfuscated_res_0x7f0f04e3), f15Var));
            }
            if (z3) {
                arrayList.add(new b15(1, getResources().getString(R.string.un_mute), f15Var));
            } else {
                arrayList.add(new b15(1, getResources().getString(R.string.obfuscated_res_0x7f0f0c0d), f15Var));
            }
            f15Var.k(arrayList);
            d15 d15Var2 = new d15(getPageContext(), f15Var);
            this.L0 = d15Var2;
            d15Var2.k();
        }
    }

    public final void f7(pp9 pp9Var, boolean z3) {
        PbModel pbModel;
        int i3;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048674, this, pp9Var, z3) == null) {
            I6(false);
            if (pp9Var == null || (pbModel = this.y0) == null || pbModel.z1() == null || pp9Var.D() == 1) {
                return;
            }
            String S1 = this.y0.S1();
            String N = pp9Var.N();
            if (this.y0.z1() != null) {
                i3 = this.y0.z1().U();
            } else {
                i3 = 0;
            }
            AbsPbActivity.e u6 = u6(N);
            if (u6 == null) {
                return;
            }
            SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(getPageContext().getPageActivity());
            SmallTailInfo h02 = pp9Var.h0();
            AntiData c4 = this.y0.z1().c();
            if (pp9Var.p() != null) {
                arrayList = pp9Var.p().getIconInfo();
            } else {
                arrayList = null;
            }
            SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(S1, N, "pb", true, false, null, false, null, i3, h02, c4, false, arrayList, 5).addBigImageData(u6.a, u6.b, u6.g, u6.j);
            addBigImageData.setKeyPageStartFrom(this.y0.y1());
            addBigImageData.setFromFrsForumId(this.y0.getFromForumId());
            addBigImageData.setWorksInfoData(this.y0.X1());
            addBigImageData.setKeyFromForumId(this.y0.getForumId());
            addBigImageData.setBjhData(this.y0.R0());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public void j5(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048688, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(tz8.e2)).intValue();
            if (intValue == tz8.f2) {
                if (this.B0.o0()) {
                    return;
                }
                this.G0.e4();
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
                    this.B0.q0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.B0.r0(this.y0.z1().k().getId(), this.y0.z1().k().getName(), this.y0.z1().M().getId(), str, intValue3, intValue2, booleanValue, this.y0.z1().M().getBaijiahaoData(), z3);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == tz8.g2 || intValue == tz8.i2) {
                PbModel pbModel = this.y0;
                if (pbModel != null && pbModel.U0() != null) {
                    this.y0.U0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == tz8.g2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public void m5(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048698, this, i3, i4) == null) {
            TiebaStatic.log("c12181");
            tz8 tz8Var = this.G0;
            if (tz8Var != null && this.y0 != null) {
                if ((tz8Var == null || tz8Var.K1()) && this.y0.z1() != null && this.y0.z1().Q() != null) {
                    tz8 tz8Var2 = this.G0;
                    if (tz8Var2 != null && tz8Var2.M0() != null && this.G0.M0().t()) {
                        return;
                    }
                    fw8 Q = this.y0.z1().Q();
                    if (!checkUpIsLogin()) {
                        return;
                    }
                    if ((!Q.d() || Q.a() != 2) && this.G0.G0() != null && this.G0.G0().B() != null) {
                        this.G0.G0().B().x(this.y0.S1(), this.y0.getFromForumId());
                    }
                    if (i3 > -1 && i4 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        uu8 uu8Var = new uu8(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.y0;
                        uu8Var.m(findViewById, i3, i4, pbModel.b, pbModel.getForumId());
                        uu8Var.l(new n0(this));
                    } else if (System.currentTimeMillis() - this.v > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.v = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public void O5(boolean z3, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
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
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.f1);
            userMuteAddAndDelCustomMessage.setTag(this.f1);
            c7(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void P5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.z1() != null && this.y0.z1().h0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.y0.S1(), str);
                ThreadData M = this.y0.z1().M();
                if (M.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (M.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (M.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                b6(format);
                return;
            }
            this.z0.a(str);
        }
    }

    public final void T6(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048630, this, metaData) != null) || metaData == null) {
            return;
        }
        u05 u05Var = new u05(getActivity());
        u05Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0b6f));
        u05Var.setTitleShowCenter(true);
        u05Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b70));
        u05Var.setMessageShowCenter(true);
        u05Var.setCancelable(false);
        u05Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0b71), new t1(this, metaData));
        u05Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0b72), new u1(this, metaData));
        u05Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final void Z6(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && Q() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                Q().I0(postWriteCallBackData.getPostId());
                int K0 = this.G0.K0();
                this.n1 = K0;
                this.y0.W2(K0, this.G0.Q0());
            }
            this.G0.t0();
            this.K0.c();
            mf5 mf5Var = this.V0;
            if (mf5Var != null) {
                this.G0.T2(mf5Var.y());
            }
            this.G0.s1();
            this.G0.B3(true);
            this.y0.d2();
        }
    }

    public final void h5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048681, this, str) == null) && !TextUtils.isEmpty(str) && (pbModel = this.y0) != null && pbModel.z1() != null) {
            op9 z3 = this.y0.z1().z();
            if (z3 != null && str.equals(z3.t1())) {
                if (z3.getAdvertAppInfo() != null) {
                    z3.getAdvertAppInfo().h = null;
                }
                this.y0.z1().b();
            }
            op9 S0 = this.y0.S0();
            if (S0 != null && str.equals(S0.t1())) {
                this.y0.F0();
            }
        }
    }

    public void k6(pp9 pp9Var) {
        boolean z3;
        pp9 s5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048693, this, pp9Var) != null) || pp9Var == null) {
            return;
        }
        if (pp9Var.N() != null && pp9Var.N().equals(this.y0.u1())) {
            z3 = true;
        } else {
            z3 = false;
        }
        MarkData t12 = this.y0.t1(pp9Var);
        if (this.y0.z1() != null && this.y0.z1().h0() && (s5 = s5()) != null) {
            t12 = this.y0.t1(s5);
        }
        if (t12 == null) {
            return;
        }
        this.G0.o3();
        ct4 ct4Var = this.A0;
        if (ct4Var != null) {
            ct4Var.i(t12);
            if (!z3) {
                this.A0.a();
            } else {
                this.A0.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048709, this, i3) != null) || this.V == i3) {
            return;
        }
        super.onChangeSkinType(i3);
        this.G0.b2(i3);
        mf5 mf5Var = this.V0;
        if (mf5Var != null && mf5Var.b() != null) {
            this.V0.b().y(i3);
        }
        if (this.G0.a() != null) {
            this.G0.a().d(getPageContext(), i3);
        }
        this.K0.i();
        UtilHelper.setNavigationBarBackground(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201), true);
        this.V = i3;
        g7();
        gb5 gb5Var = this.i0;
        if (gb5Var != null) {
            gb5Var.w();
        }
    }

    public void x6(gw8 gw8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048750, this, gw8Var) == null) {
            String N = gw8Var.g().N();
            List<pp9> list = this.y0.z1().R().a;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                pp9 pp9Var = list.get(i3);
                if (pp9Var.N() != null && pp9Var.N().equals(N)) {
                    ArrayList<pp9> i4 = gw8Var.i();
                    pp9Var.f1(gw8Var.k());
                    if (pp9Var.e0() != null) {
                        pp9Var.e0().clear();
                        pp9Var.e0().addAll(i4);
                    }
                } else {
                    i3++;
                }
            }
            if (!this.y0.i1()) {
                this.G0.J1(this.y0.z1());
            }
        }
    }

    public final void P6(int i3, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048618, this, i3, antiData, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new y1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                b7(str);
            } else {
                this.G0.c4(str);
            }
        }
    }

    @Override // com.baidu.tieba.fw5
    public void f0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048671, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.N0 = str;
            if (this.k == null) {
                W5();
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

    public final void R6(SparseArray<Object> sparseArray, int i3, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{sparseArray, Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) {
            n19.e(getActivity(), getPageContext(), new e1(this, sparseArray, i3, z3), new f1(this));
        }
    }

    public final void V4() {
        PbModel pbModel;
        qv8 qv8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && (pbModel = this.y0) != null && (qv8Var = pbModel.G) != null && qv8Var.M() != null) {
            ThreadData M = this.y0.G.M();
            M.mRecomAbTag = this.y0.E1();
            M.mRecomWeight = this.y0.H1();
            M.mRecomSource = this.y0.G1();
            M.mRecomExtra = this.y0.F1();
            M.isSubPb = this.y0.m1();
            if (M.getFid() == 0) {
                M.setFid(gg.g(this.y0.getForumId(), 0L));
            }
            StatisticItem i3 = em5.i(getContext(), M, "c13562");
            TbPageTag l3 = em5.l(getContext());
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

    public final void i6() {
        MarkData Q0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048685, this) == null) && this.A0 != null) {
            if (this.y0.z1() != null && this.y0.z1().h0()) {
                Q0 = this.y0.Q0(0);
            } else {
                Q0 = this.y0.Q0(this.G0.V0());
            }
            if (Q0 == null) {
                return;
            }
            if (Q0.isApp() && (Q0 = this.y0.Q0(this.G0.V0() + 1)) == null) {
                return;
            }
            this.G0.o3();
            this.A0.i(Q0);
            if (!this.A0.e()) {
                if (this.G0 != null && this.y0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !q19.h(this.y0.b)) {
                    this.G0.W3();
                    q19.b(this.y0.b);
                }
                this.A0.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.A0.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            this.f = true;
            super.onPause();
            p19.a();
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
            tz8 tz8Var = this.G0;
            if (tz8Var != null) {
                tz8Var.i2();
            }
            if (this.V0 != null && !this.y0.m1()) {
                this.V0.N(this.y0.S1());
            }
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                pbModel.B2();
            }
            PushPermissionController pushPermissionController = this.u0;
            if (pushPermissionController != null) {
                pushPermissionController.unregisterListener();
            }
            dq4.w().E();
            MessageManager.getInstance().unRegisterListener(this.A1);
            E6();
            MessageManager.getInstance().unRegisterListener(this.V1);
            MessageManager.getInstance().unRegisterListener(this.W1);
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.w(null);
            gb5 gb5Var = this.i0;
            if (gb5Var != null) {
                gb5Var.q();
                this.i0.p();
            }
        }
    }

    public final void W5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048640, this) != null) || this.k != null) {
            return;
        }
        this.k = new w05(getPageContext().getPageActivity());
        String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
        w05 w05Var = this.k;
        w05Var.j(strArr, new q0(this));
        w05Var.g(w05.b.a);
        w05Var.h(17);
        w05Var.c(getPageContext());
    }

    public final void X4(qv8 qv8Var, ArrayList<pp9> arrayList) {
        List<pp9> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048644, this, qv8Var, arrayList) == null) && qv8Var != null && qv8Var.R() != null && qv8Var.R().a != null && (list = qv8Var.R().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<pp9> it = arrayList.iterator();
                while (it.hasNext()) {
                    pp9 next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            pp9 pp9Var = (pp9) it2.next();
                            if (pp9Var != null && !TextUtils.isEmpty(next.N()) && !TextUtils.isEmpty(pp9Var.N()) && next.N().equals(pp9Var.N())) {
                                arrayList2.add(pp9Var);
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

    public final void o5(int i3, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048703, this, i3, gVar) != null) || gVar == null) {
            return;
        }
        this.G0.C0(this.B0.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.H0 = true;
            if (i3 != 2 && i3 != 3) {
                if (i3 == 4 || i3 == 5) {
                    this.I0 = false;
                    this.J0 = true;
                }
            } else {
                this.I0 = true;
                this.J0 = false;
            }
            if (i3 == 2) {
                this.y0.z1().M().setIs_good(1);
                this.y0.a3(1);
            } else if (i3 == 3) {
                this.y0.z1().M().setIs_good(0);
                this.y0.a3(0);
            } else if (i3 == 4) {
                this.y0.z1().M().setIs_top(1);
                this.y0.b3(1);
            } else if (i3 == 5) {
                this.y0.z1().M().setIs_top(0);
                this.y0.b3(0);
            }
            this.G0.m4(this.y0.z1(), this.y0.R1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.operation_failed);
        }
        ii.Q(getPageContext().getPageActivity(), string);
    }

    public void Y4(boolean z3) {
        tz8 tz8Var;
        int i3;
        int y3;
        pp9 pp9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048648, this, z3) == null) && (tz8Var = this.G0) != null && tz8Var.W0() != null) {
            int firstVisiblePosition = this.G0.W0().getFirstVisiblePosition();
            int lastVisiblePosition = this.G0.W0().getLastVisiblePosition();
            ey8 G0 = this.G0.G0();
            if (G0 != null && this.y0.z1() != null) {
                if (lastVisiblePosition <= G0.y()) {
                    i3 = 0;
                    y3 = 1;
                } else {
                    if (firstVisiblePosition > G0.y()) {
                        i3 = firstVisiblePosition - G0.y();
                    } else {
                        i3 = 0;
                    }
                    y3 = (lastVisiblePosition - G0.y()) + 1;
                }
                ArrayList arrayList = new ArrayList();
                if (y3 > i3) {
                    while (i3 < y3) {
                        if (this.G0.W0().G(i3) != null && (this.G0.W0().G(i3) instanceof pp9) && (pp9Var = (pp9) this.G0.W0().G(i3)) != null) {
                            pp9 pp9Var2 = (pp9) ListUtils.getItem(this.y0.z1().F(), pp9Var.D() - 1);
                            if (pp9Var.m() == null && pp9Var2 != null) {
                                pp9Var.H0(pp9Var2.m());
                            }
                            if (pp9Var.m() != null) {
                                pp9Var.m().r(pp9Var.D());
                                arrayList.add(pp9Var.m());
                            }
                        }
                        i3++;
                    }
                }
                if (ListUtils.getItem(arrayList, 0) != null) {
                    Collections.sort(arrayList, new x1(this));
                    yb5 yb5Var = (yb5) ListUtils.getItem(arrayList, 0);
                    if (yb5Var != null && yb5Var.e() == 1) {
                        if (!z3) {
                            this.G0.y2(yb5Var, 0);
                            return;
                        }
                        return;
                    }
                    this.G0.y2(yb5Var, 1);
                }
            }
        }
    }

    public final boolean l6(pp9 pp9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048696, this, pp9Var)) == null) {
            if (pp9Var == null) {
                return false;
            }
            String N = pp9Var.N();
            if (StringUtils.isNull(N) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String s3 = f55.m().s("bubble_link", "");
            if (StringUtils.isNull(s3)) {
                return false;
            }
            TiebaStatic.log("c10051");
            String jumpUrl = pp9Var.j0().getJumpUrl();
            int packageId = pp9Var.j0().getPackageId();
            int propsId = pp9Var.j0().getPropsId();
            if (!StringUtils.isNull(jumpUrl)) {
                pt4.s(getPageContext().getPageActivity(), tq9.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
                return true;
            } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            } else {
                pt4.x(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), s3 + "?props_id=" + N, true, true, true);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void o7(int i3) {
        PbModel pbModel;
        ThreadData M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048705, this, i3) != null) || (pbModel = this.y0) == null || pbModel.z1() == null || (M = this.y0.z1().M()) == null) {
            return;
        }
        if (i3 == 1) {
            PraiseData praise = M.getPraise();
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
                    M.setPraise(praiseData);
                } else {
                    M.getPraise().getUser().add(0, metaData);
                    M.getPraise().setNum(M.getPraise().getNum() + 1);
                    M.getPraise().setIsLike(i3);
                }
            }
        } else if (M.getPraise() != null) {
            M.getPraise().setIsLike(i3);
            M.getPraise().setNum(M.getPraise().getNum() - 1);
            ArrayList<MetaData> user = M.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        M.getPraise().getUser().remove(next);
                        break;
                    }
                }
            }
        }
        if (this.y0.R1()) {
            this.G0.G0().d0();
        } else {
            this.G0.p4(this.y0.z1());
        }
    }

    public final AbsPbActivity.e u6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048742, this, str)) == null) {
            String str2 = null;
            if (this.y0.z1() != null && this.y0.z1().F() != null && this.y0.z1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 < this.y0.z1().F().size()) {
                        if (str.equals(this.y0.z1().F().get(i3).N())) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = 0;
                        break;
                    }
                }
                pp9 pp9Var = this.y0.z1().F().get(i3);
                if (pp9Var.a0() != null && pp9Var.a0().X() != null) {
                    Iterator<TbRichTextData> it = pp9Var.a0().X().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.d0() != null) {
                                str2 = next.d0().W();
                            }
                        }
                    }
                    s6(str2, 0, eVar);
                    rv8.b(pp9Var, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public void z6(gw8 gw8Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048756, this, gw8Var) != null) || gw8Var.g() == null) {
            return;
        }
        String N = gw8Var.g().N();
        ArrayList<pp9> F = this.y0.z1().F();
        int i3 = 0;
        while (true) {
            z3 = true;
            if (i3 >= F.size()) {
                break;
            }
            pp9 pp9Var = F.get(i3);
            if (pp9Var.N() != null && pp9Var.N().equals(N)) {
                ArrayList<pp9> i4 = gw8Var.i();
                pp9Var.f1(gw8Var.k());
                if (pp9Var.e0() != null && i4 != null) {
                    Iterator<pp9> it = i4.iterator();
                    while (it.hasNext()) {
                        pp9 next = it.next();
                        if (pp9Var.n0() != null && next != null && next.p() != null && (metaData = pp9Var.n0().get(next.p().getUserId())) != null) {
                            next.I0(metaData);
                            next.V0(true);
                            next.p1(getPageContext(), this.y0.s2(metaData.getUserId()));
                        }
                    }
                    if (i4.size() == pp9Var.e0().size()) {
                        z3 = false;
                    }
                    if (!pp9Var.u0(false)) {
                        pp9Var.e0().clear();
                        pp9Var.e0().addAll(i4);
                    }
                }
                if (pp9Var.y() != null) {
                    pp9Var.G0();
                }
            } else {
                i3++;
            }
        }
        if (!this.y0.i1() && z3) {
            this.G0.J1(this.y0.z1());
        }
        if (z3) {
            x6(gw8Var);
        }
    }

    public final void c7(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048663, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.G0.J3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            u05 u05Var = new u05(this.d1.getPageActivity());
            if (!hi.isEmpty(str)) {
                u05Var.setMessage(str);
            } else {
                u05Var.setMessage(this.d1.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            u05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0465, new f(this, userMuteAddAndDelCustomMessage));
            u05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038b, new g(this));
            u05Var.create(this.d1).show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d5(AgreeData agreeData) {
        zl5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048665, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.d0 == null) {
            this.d0 = new b55();
        }
        if (this.h0 == null) {
            fp9 fp9Var = new fp9();
            this.h0 = fp9Var;
            fp9Var.a = getUniqueId();
        }
        gx4 gx4Var = new gx4();
        gx4Var.b = 5;
        gx4Var.h = 8;
        gx4Var.g = 2;
        if (Q() != null) {
            gx4Var.f = Q().y1();
        }
        gx4Var.a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                gx4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.d0.c(agreeData, i3, getUniqueId(), false);
                this.d0.d(agreeData, this.h0);
                pbModel = this.y0;
                if (pbModel == null && pbModel.z1() != null) {
                    this.d0.b(R(), gx4Var, agreeData, this.y0.z1().M());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            gx4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            gx4Var.i = 1;
        }
        i3 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
        if (currentVisiblePageExtra != null) {
        }
        this.d0.c(agreeData, i3, getUniqueId(), false);
        this.d0.d(agreeData, this.h0);
        pbModel = this.y0;
        if (pbModel == null) {
        }
    }

    public final boolean f5(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
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
        List<b15> c4;
        int i3;
        boolean z20;
        b15 b15Var;
        b15 b15Var2;
        b15 b15Var3;
        b15 b15Var4;
        b15 b15Var5;
        b15 b15Var6;
        tm tmVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048672, this, view2)) == null) {
            if (!isAdded() || FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext())) {
                return true;
            }
            tz8 tz8Var = this.G0;
            if (tz8Var != null) {
                if (tz8Var.M1()) {
                    return true;
                }
                this.G0.D0();
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (sz8.w(view2)) {
                    if (view2 instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view2;
                        this.i1 = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.j1 = url;
                        if (this.i1 == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view2.getTag(R.id.tag_rich_text_image_info) != null && (view2.getTag(R.id.tag_rich_text_image_info) instanceof TbRichTextImageInfo)) {
                            this.k1 = (TbRichTextImageInfo) view2.getTag(R.id.tag_rich_text_image_info);
                        } else {
                            this.k1 = null;
                        }
                        if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.l1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.l1 = null;
                        }
                    } else if (view2 instanceof GifView) {
                        GifView gifView = (GifView) view2;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.i1 = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                            this.j1 = gifView.getBdImage().q();
                        }
                        if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.l1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.l1 = null;
                        }
                    } else if (view2 instanceof TbMemeImageView) {
                        TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                        if (tbMemeImageView.getBdImage() != null) {
                            this.i1 = tbMemeImageView.getBdImage();
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                this.j1 = tbMemeImageView.getBdImage().q();
                            }
                            if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.l1 = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.l1 = null;
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
                        this.G0.O3(this.C2, this.i1.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            pp9 pp9Var = (pp9) sparseArray.get(R.id.tag_clip_board);
            this.A2 = pp9Var;
            if (pp9Var == null) {
                return true;
            }
            if (pp9Var.D() == 1 && sz8.w(view2)) {
                this.G0.O3(this.C2, this.i1.t());
                return true;
            }
            ct4 ct4Var = this.A0;
            if (ct4Var == null) {
                return true;
            }
            if (ct4Var.e() && this.A2.N() != null && this.A2.N().equals(this.y0.u1())) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (Q().z1() != null && Q().z1().h0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (Q().z1() != null && Q().z1().n0()) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (Q().z1() != null && Q().z1().m0()) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (this.A2.D() == 1) {
                if (!z4) {
                    this.G0.P3(this.B2, z3, false, z5, z6);
                }
                return true;
            }
            if (this.M0 == null) {
                f15 f15Var = new f15(getContext());
                this.M0 = f15Var;
                f15Var.p(this.f2);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 != null && sparseArray != null) {
                if (sz8.w(view2) && !z4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (sz8.w(view2) && (tmVar = this.i1) != null && !tmVar.t()) {
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
                    arrayList.add(new b15(1, getString(R.string.save_to_emotion), this.M0));
                } else {
                    z17 = z16;
                    z18 = z13;
                    z19 = z14;
                }
                if (z8) {
                    arrayList.add(new b15(2, getString(R.string.save_to_local), this.M0));
                }
                if (!z7 && !z8) {
                    b15 b15Var7 = new b15(3, getString(R.string.obfuscated_res_0x7f0f0481), this.M0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.A2);
                    b15Var7.d.setTag(sparseArray3);
                    arrayList.add(b15Var7);
                }
                if (!z9 && !z4) {
                    if (z3) {
                        b15Var6 = new b15(4, getString(R.string.remove_mark), this.M0);
                    } else {
                        b15Var6 = new b15(4, getString(R.string.obfuscated_res_0x7f0f0b6d), this.M0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.A2);
                    sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                    b15Var6.d.setTag(sparseArray4);
                    arrayList.add(b15Var6);
                }
                if (this.mIsLogin) {
                    if (!n19.j(this.y0) && !z12 && z11) {
                        b15 b15Var8 = new b15(5, getString(R.string.obfuscated_res_0x7f0f0c11), this.M0);
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
                        b15Var8.d.setTag(sparseArray5);
                        arrayList.add(b15Var8);
                    } else {
                        if (sz8.A(this.y0.z1(), z10) && TbadkCoreApplication.isLogin()) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        if (z20 && !z4) {
                            b15 b15Var9 = new b15(5, getString(R.string.report_text), this.M0);
                            b15Var9.d.setTag(str);
                            arrayList.add(b15Var9);
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
                        if (!n19.j(this.y0) && z18) {
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
                                b15Var5 = new b15(6, getString(R.string.obfuscated_res_0x7f0f04e3), this.M0);
                                b15Var5.d.setTag(sparseArray6);
                                b15Var2 = new b15(7, getString(R.string.obfuscated_res_0x7f0f02ef), this.M0);
                                b15Var2.d.setTag(sparseArray6);
                                b15Var3 = b15Var5;
                                b15Var = null;
                            }
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        }
                        b15Var5 = null;
                        b15Var2 = new b15(7, getString(R.string.obfuscated_res_0x7f0f02ef), this.M0);
                        b15Var2.d.setTag(sparseArray6);
                        b15Var3 = b15Var5;
                        b15Var = null;
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
                        if (this.y0.z1().U() == 1002 && !z10) {
                            b15Var4 = new b15(6, getString(R.string.report_text), this.M0);
                        } else {
                            b15Var4 = new b15(6, getString(R.string.obfuscated_res_0x7f0f04e3), this.M0);
                        }
                        b15Var4.d.setTag(sparseArray7);
                        if (z17) {
                            b15Var = new b15(13, getString(R.string.multi_delete), this.M0);
                            b15Var3 = b15Var4;
                        } else {
                            b15Var3 = b15Var4;
                            b15Var = null;
                        }
                        b15Var2 = null;
                    } else {
                        b15Var = null;
                        b15Var2 = null;
                        b15Var3 = null;
                    }
                    if (b15Var3 != null) {
                        arrayList.add(b15Var3);
                    }
                    if (b15Var != null) {
                        arrayList.add(b15Var);
                    }
                    if (b15Var2 != null) {
                        arrayList.add(b15Var2);
                    }
                    n19.b(arrayList, this.M0, this.A2, this.y0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    c4 = n19.d(arrayList, this.A2.n(), sparseArray, this.M0);
                } else {
                    c4 = n19.c(arrayList, this.A2.n(), sparseArray, this.M0);
                }
                n19.m(c4, this.b);
                n19.f(c4);
                this.M0.q(n19.h(this.A2));
                this.M0.l(c4, !UbsABTestHelper.isPBPlanA());
                this.L0 = new d15(getPageContext(), this.M0);
                this.M0.o(new v2(this));
                this.L0.k();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.y0.b).param("fid", this.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.y0.X());
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
        return invokeL.booleanValue;
    }

    public final void f6(View view2, String str, String str2, pp9 pp9Var) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048673, this, view2, str, str2, pp9Var) == null) {
            if (view2 != null && str != null && str2 != null) {
                if (Z4()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (!b5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else {
                    if (view2.getParent() instanceof View) {
                        ((View) view2.getParent()).getLocationOnScreen(this.X);
                        this.Y = ((View) view2.getParent()).getMeasuredHeight();
                    }
                    if (I5().g1() != null && pp9Var != null) {
                        if (pp9Var.a0() != null) {
                            str3 = pp9Var.a0().toString();
                        } else {
                            str3 = "";
                        }
                        I5().g1().o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), pp9Var.p().getName_show(), str3));
                    }
                    if (this.y0.z1() != null && this.y0.z1().h0()) {
                        jg.a().postDelayed(new h1(this, str, str2), 0L);
                        return;
                    } else {
                        jg.a().postDelayed(new i1(this, str, str2), 200L);
                        return;
                    }
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    @Override // com.baidu.tieba.z29
    public void finish() {
        tz8 tz8Var;
        boolean z3;
        CardHListViewData p3;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            tz8 tz8Var2 = this.G0;
            if (tz8Var2 != null) {
                tz8Var2.t0();
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.z1() != null && !this.y0.z1().h0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.y0.z1().M().getId();
                if (this.y0.isShareThread() && this.y0.z1().M().originalThreadData != null) {
                    historyMessage.threadName = this.y0.z1().M().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.y0.z1().M().getTitle();
                }
                if (this.y0.isShareThread() && !z0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.y0.z1().k().getName();
                }
                ArrayList<pp9> F = this.y0.z1().F();
                tz8 tz8Var3 = this.G0;
                if (tz8Var3 != null) {
                    i3 = tz8Var3.N0();
                } else {
                    i3 = 0;
                }
                if (F != null && i3 >= 0 && i3 < F.size()) {
                    historyMessage.postID = F.get(i3).N();
                }
                historyMessage.isHostOnly = this.y0.c1();
                historyMessage.isSquence = this.y0.R1();
                historyMessage.isShareThread = this.y0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            mf5 mf5Var = this.V0;
            if (mf5Var != null) {
                mf5Var.D();
                this.V0 = null;
            }
            PbModel pbModel2 = this.y0;
            if (pbModel2 != null && (pbModel2.e1() || this.y0.h1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.y0.S1());
                if (this.H0) {
                    if (this.J0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.y0.n1());
                    }
                    if (this.I0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.y0.j1());
                    }
                }
                if (this.y0.z1() != null && System.currentTimeMillis() - this.n >= 40000 && (p3 = this.y0.z1().p()) != null && !ListUtils.isEmpty(p3.getDataList())) {
                    intent.putExtra("guess_like_data", p3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.o1);
                }
                this.a.setResult(-1, intent);
            }
            if (i7()) {
                if (this.y0 != null && (tz8Var = this.G0) != null && tz8Var.W0() != null) {
                    qv8 z12 = this.y0.z1();
                    if (z12 != null) {
                        if (z12.T() != null) {
                            z12.T().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            z12.T().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!z12.q0() && !this.H && z12.h == null) {
                            jz8 b4 = jz8.b();
                            qv8 A1 = this.y0.A1();
                            Parcelable onSaveInstanceState = this.G0.W0().onSaveInstanceState();
                            boolean R1 = this.y0.R1();
                            boolean c12 = this.y0.c1();
                            if (this.G0.e1() != null && this.G0.e1().getVisibility() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            b4.l(A1, onSaveInstanceState, R1, c12, z3);
                            if (this.n1 >= 0 || this.y0.U1() != null) {
                                jz8.b().o(this.y0.U1());
                                jz8.b().p(this.y0.V1());
                                jz8.b().m(this.y0.s1());
                            }
                        }
                    }
                } else {
                    jz8.b().k();
                }
                h7();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        a29 a29Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            rn9.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!hi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.y0.z1().l());
                statisticItem.param("tid", this.y0.S1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.r && this.G0 != null) {
                this.r = true;
            }
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.y0.destory();
                if (this.y0.v1() != null) {
                    this.y0.v1().d();
                }
            }
            mf5 mf5Var = this.V0;
            if (mf5Var != null) {
                mf5Var.D();
                this.V0 = null;
            }
            ForumManageModel forumManageModel = this.B0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.P;
            if (likeModel != null) {
                likeModel.j0();
            }
            tz8 tz8Var = this.G0;
            if (tz8Var != null) {
                tz8Var.d2();
                a29 a29Var2 = this.G0.h;
                if (a29Var2 != null) {
                    a29Var2.q();
                }
            }
            wm5 wm5Var = this.s;
            if (wm5Var != null) {
                wm5Var.c();
            }
            y09 y09Var = this.e;
            if (y09Var != null) {
                y09Var.k();
            }
            xf<TextView> xfVar = this.y;
            if (xfVar != null) {
                xfVar.c();
            }
            xf<FestivalTipView> xfVar2 = this.G;
            if (xfVar2 != null) {
                xfVar2.c();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            tz8 tz8Var2 = this.G0;
            if (tz8Var2 != null) {
                tz8Var2.t0();
            }
            if (this.U1 != null) {
                jg.a().removeCallbacks(this.U1);
            }
            MessageManager.getInstance().unRegisterListener(this.V1);
            MessageManager.getInstance().unRegisterListener(this.W1);
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.f1);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().unRegisterListener(this.I1);
            MessageManager.getInstance().unRegisterListener(this.J1);
            MessageManager.getInstance().unRegisterListener(this.m2);
            MessageManager.getInstance().unRegisterListener(this.H1);
            MessageManager.getInstance().unRegisterListener(this.L1);
            MessageManager.getInstance().unRegisterListener(this.C1);
            MessageManager.getInstance().unRegisterListener(this.D1);
            MessageManager.getInstance().unRegisterListener(this.b2);
            this.d1 = null;
            this.e1 = null;
            kf9.e().g();
            if (this.g1 != null) {
                jg.a().removeCallbacks(this.g1);
            }
            tz8 tz8Var3 = this.G0;
            if (tz8Var3 != null && (a29Var = tz8Var3.h) != null) {
                a29Var.j();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.F0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            wz8 wz8Var = this.K0;
            if (wz8Var != null) {
                wz8Var.j();
            }
            PushPermissionController pushPermissionController = this.u0;
            if (pushPermissionController != null) {
                pushPermissionController.onDestroy();
            }
            PbModel pbModel2 = this.y0;
            if (pbModel2 != null && pbModel2.N0() != null) {
                this.y0.N0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.X0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            tz8 tz8Var4 = this.G0;
            if (tz8Var4 != null) {
                tz8Var4.f4();
            }
            l19 l19Var = this.t0;
            if (l19Var != null) {
                l19Var.e();
            }
        }
    }

    public void g5(ForumManageModel.b bVar, tz8 tz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048677, this, bVar, tz8Var) == null) {
            List<pp9> list = this.y0.z1().R().a;
            int size = list.size();
            boolean z3 = false;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.get(i3).e0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i3).e0().get(i4).N())) {
                        list.get(i3).e0().remove(i4);
                        list.get(i3).h();
                        z3 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                list.get(i3).j(bVar.g);
            }
            if (z3) {
                tz8Var.J1(this.y0.z1());
            }
        }
    }

    public void k5(u05 u05Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048692, this, u05Var, jSONArray) == null) {
            u05Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(u05Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                j5((SparseArray) u05Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final TbRichText p7(String str, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048730, this, str, i3)) == null) {
            PbModel pbModel = this.y0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.z1() == null || str == null || i3 < 0) {
                return null;
            }
            qv8 z12 = this.y0.z1();
            if (z12.i() != null) {
                ArrayList<pp9> arrayList = new ArrayList<>();
                arrayList.add(z12.i());
                tbRichText = w5(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<pp9> F = z12.F();
                X4(z12, F);
                return w5(F, str, i3);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void l5(int i3, String str, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048695, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(tz8.e2, Integer.valueOf(tz8.f2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                j5(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void n5(ForumManageModel.b bVar, boolean z3) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048700, this, bVar, z3) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i3 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                u05 u05Var = new u05(getPageContext().getPageActivity());
                u05Var.setMessage(string);
                u05Var.setPositiveButton(R.string.dialog_known, new a2(this));
                u05Var.setCancelable(true);
                u05Var.create(getPageContext());
                u05Var.show();
            } else if (bVar.d != 0) {
                this.G0.C0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i4 = bVar.d;
                if (i4 == 1) {
                    ArrayList<pp9> F = this.y0.z1().F();
                    int size = F.size();
                    while (true) {
                        if (i3 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i3).N())) {
                            F.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                    this.y0.z1().M().setReply_num(this.y0.z1().M().getReply_num() - 1);
                    this.G0.J1(this.y0.z1());
                } else if (i4 == 0) {
                    e5();
                } else if (i4 == 2) {
                    ArrayList<pp9> F2 = this.y0.z1().F();
                    int size2 = F2.size();
                    boolean z4 = false;
                    for (int i5 = 0; i5 < size2 && !z4; i5++) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= F2.get(i5).e0().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i5).e0().get(i6).N())) {
                                F2.get(i5).e0().remove(i6);
                                F2.get(i5).h();
                                z4 = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                        F2.get(i5).j(bVar.g);
                    }
                    if (z4) {
                        this.G0.J1(this.y0.z1());
                    }
                    g5(bVar, this.G0);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048707, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            mf5 mf5Var = this.V0;
            if (mf5Var != null) {
                mf5Var.C(i3, i4, intent);
            }
            if (I5().g1() != null) {
                I5().g1().k(i3, i4, intent);
            }
            if (i3 == 25035) {
                N5(i4, intent);
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
                                                    View view2 = this.R;
                                                    if (view2 != null) {
                                                        view2.performClick();
                                                        return;
                                                    }
                                                    return;
                                                case 25056:
                                                    View view3 = this.S;
                                                    if (view3 != null) {
                                                        view3.performClick();
                                                        return;
                                                    }
                                                    return;
                                                case 25057:
                                                    tz8 tz8Var = this.G0;
                                                    if (tz8Var != null && tz8Var.H0() != null) {
                                                        this.G0.H0().performClick();
                                                        return;
                                                    }
                                                    return;
                                                case 25058:
                                                    View view4 = this.T;
                                                    if (view4 != null) {
                                                        view4.performClick();
                                                        return;
                                                    }
                                                    return;
                                                default:
                                                    return;
                                            }
                                        }
                                        this.G0.q3(false);
                                        if (this.y0.z1() != null && this.y0.z1().M() != null && this.y0.z1().M().getPushStatusData() != null) {
                                            this.y0.z1().M().getPushStatusData().setStatus(2);
                                            return;
                                        }
                                        return;
                                    }
                                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                        cd9.g().m(getPageContext());
                                        m7();
                                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.F0;
                                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.x) != null) {
                                            shareSuccessReplyToServerModel.V(str, intExtra, new f2(this));
                                        }
                                        if (Y5()) {
                                            k7(true);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                View view5 = this.Q;
                                if (view5 != null) {
                                    this.G0.G3(view5);
                                    return;
                                }
                                return;
                            }
                            Q5(intent);
                            return;
                        }
                        cd9.g().m(getPageContext());
                        return;
                    }
                    jz8.b().k();
                    this.x0.postDelayed(new e2(this), 1000L);
                    return;
                }
                i6();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        tz8 tz8Var;
        tz8 tz8Var2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, bundle) == null) {
            this.n = System.currentTimeMillis();
            this.d1 = getPageContext();
            Intent intent = this.a.getIntent();
            if (intent != null) {
                this.l = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
                this.L = intent.getStringExtra("from");
                if (intent.getData() != null) {
                    Uri data = intent.getData();
                    if (StringUtils.isNull(this.L)) {
                        this.L = data.getQueryParameter("from");
                    }
                }
                this.U = intent.getStringExtra("st_type");
                this.L2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.M2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.N2 = intent.getStringExtra("key_manga_title");
                this.Q0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.R0 = intent.getStringExtra("high_light_post_id");
                this.S0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (z5()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.O = stringExtra;
                if (hi.isEmpty(stringExtra)) {
                    str = "";
                } else {
                    str = this.O;
                }
                this.O = str;
                this.o1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                nz4 nz4Var = new nz4();
                this.b0 = nz4Var;
                nz4Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.q1 = intExtra;
                if (intExtra == 0) {
                    this.q1 = intent.getIntExtra("key_start_from", 0);
                }
                this.P2 = intent.getIntExtra(PbActivityConfig.KEY_FROM_CARD_TYPE, 0);
            } else {
                this.l = System.currentTimeMillis();
            }
            this.p = this.n - this.l;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.j = 0;
            d6(bundle);
            if (this.y0.z1() != null) {
                this.y0.z1().R0(this.O);
            }
            V5();
            if (intent != null && (tz8Var2 = this.G0) != null) {
                tz8Var2.b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.g1 == null) {
                        this.g1 = new k0(this, intent);
                    }
                    jg.a().postDelayed(this.g1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.y0.z1() != null) {
                    this.y0.f3(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.i = voiceManager;
            voiceManager.onCreate(getPageContext());
            U5(bundle);
            of5 of5Var = new of5();
            this.U0 = of5Var;
            L6(of5Var);
            mf5 mf5Var = (mf5) this.U0.a(getActivity());
            this.V0 = mf5Var;
            mf5Var.W(this.a.getPageContext());
            this.V0.f0(this.j2);
            this.V0.g0(this.Y0);
            this.V0.Y(1);
            this.V0.A(this.a.getPageContext(), bundle);
            this.V0.b().b(new td5(getActivity()));
            this.V0.b().E(true);
            O6(true);
            this.V0.J(this.y0.b1(), this.y0.S1(), this.y0.X0());
            registerListener(this.x1);
            if (!this.y0.m1()) {
                this.V0.q(this.y0.S1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.V0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.y0.i2()) {
                this.V0.c0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                tz8 tz8Var3 = this.G0;
                if (tz8Var3 != null) {
                    this.V0.c0(tz8Var3.h1());
                }
            }
            registerListener(this.w1);
            registerListener(this.y1);
            registerListener(this.z1);
            registerListener(this.v1);
            registerListener(this.Z1);
            registerListener(this.a2);
            registerListener(this.p2);
            registerListener(this.u1);
            gp9 gp9Var = new gp9("pb", gp9.d);
            this.T0 = gp9Var;
            gp9Var.d();
            registerListener(this.F1);
            registerListener(this.P1);
            this.y0.C2();
            registerListener(this.o2);
            registerListener(this.c2);
            registerListener(this.i2);
            registerListener(this.L1);
            registerListener(this.b2);
            registerListener(this.G1);
            tz8 tz8Var4 = this.G0;
            if (tz8Var4 != null && tz8Var4.n1() != null && this.G0.l1() != null) {
                y09 y09Var = new y09(getActivity(), this.G0.n1(), this.G0.l1(), this.G0.e1());
                this.e = y09Var;
                y09Var.t(this.O1);
            }
            if (this.c && (tz8Var = this.G0) != null && tz8Var.l1() != null) {
                this.G0.l1().setVisibility(8);
            }
            l55 l55Var = new l55();
            this.e1 = l55Var;
            l55Var.a = 1000L;
            registerListener(this.Y1);
            registerListener(this.X1);
            registerListener(this.V1);
            registerListener(this.W1);
            registerListener(this.I1);
            registerListener(this.J1);
            registerListener(this.B1);
            registerListener(this.C1);
            registerListener(this.D1);
            this.H1.setSelfListener(true);
            this.H1.setTag(this.a.getUniqueId());
            this.H1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.H1);
            registerResponsedEventListener(TipEvent.class, this.Q1);
            registerResponsedEventListener(TopToastEvent.class, this.R1);
            this.f1 = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.f1;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.f1;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            this.S1 = new f3(this.G0, this);
            this.y0.T0().Z(this.S1);
            this.K0 = new wz8();
            if (this.V0.s() != null) {
                this.K0.m(this.V0.s().i());
            }
            this.V0.V(this.Z0);
            this.F0 = new ShareSuccessReplyToServerModel();
            T4(this.s1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.X0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new l0(this));
            b29 b29Var = new b29(getContext());
            this.z0 = b29Var;
            b29Var.b(getUniqueId());
            rn9.g().i(getUniqueId());
            vw4.b().l("3", "");
            this.r1 = new ih6(getPageContext());
            this.t0 = new l19(this, getUniqueId(), this.G0, this.y0);
            this.u0 = new PushPermissionController(getActivity(), getPageContext());
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048713, this, layoutInflater, viewGroup, bundle)) == null) {
            this.G0 = new tz8(this, this.h2, this.T1, this.g2);
            iq6 iq6Var = new iq6(getActivity());
            this.d = iq6Var;
            iq6Var.i(R2);
            this.d.d(this.J2);
            this.G0.h3(this.r2);
            this.G0.g3(this.w2);
            this.G0.a3(this.t2);
            this.G0.b3(this.u2);
            this.G0.Y2(iw4.c().g());
            this.G0.e3(this.y2);
            this.G0.k3(this.E2);
            this.G0.i3(this.F2);
            this.G0.f3(this.H2);
            this.G0.i4(this.mIsLogin);
            this.G0.W2(this.y0.g2());
            if (this.a.getIntent() != null) {
                this.G0.X2(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.G0.f1().setFromForumId(this.y0.getFromForumId());
            mf5 mf5Var = this.V0;
            if (mf5Var != null) {
                this.G0.O2(mf5Var.b());
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.V0.c0(TbSingleton.getInstance().getAdVertiComment());
                } else {
                    this.V0.c0(this.G0.h1());
                }
            }
            this.G0.S2(this.e2);
            this.G0.V2(this.y0.h1());
            this.G0.j3(this.y0.y1());
            this.t0.f(this.G0, this.y0);
            if ("1".equals(Q().showReplyPanel)) {
                this.G0.k2();
            }
            return this.G0.o1();
        }
        return (View) invokeLLL.objValue;
    }

    public final TbRichText w5(ArrayList<pp9> arrayList, String str, int i3) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> X;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048745, this, arrayList, str, i3)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    TbRichText a02 = arrayList.get(i4).a0();
                    if (a02 != null && (X = a02.X()) != null) {
                        int size = X.size();
                        int i5 = -1;
                        for (int i6 = 0; i6 < size; i6++) {
                            if (X.get(i6) != null && X.get(i6).getType() == 8) {
                                i5++;
                                if (!X.get(i6).d0().W().equals(str) && !X.get(i6).d0().X().equals(str)) {
                                    if (i5 > i3) {
                                        break;
                                    }
                                } else {
                                    int i7 = (int) ii.i(TbadkCoreApplication.getInst());
                                    int width = X.get(i6).d0().getWidth() * i7;
                                    int height = X.get(i6).d0().getHeight() * i7;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.x2 = i6;
                                    return a02;
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

    public void p6() {
        PbModel pbModel;
        qv8 z12;
        ThreadData M;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        qv8 qv8Var;
        boolean z8;
        boolean z9;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048729, this) == null) && (pbModel = this.y0) != null && pbModel.z1() != null && (M = (z12 = this.y0.z1()).M()) != null && M.getAuthor() != null) {
            this.G0.s1();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), M.getAuthor().getUserId());
            cz8 cz8Var = new cz8();
            int U = this.y0.z1().U();
            if (U != 1 && U != 3) {
                cz8Var.g = false;
            } else {
                cz8Var.g = true;
                if (M.getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                cz8Var.s = z3;
            }
            if (sz8.x(this.y0.z1(), U)) {
                cz8Var.h = true;
                if (M.getIs_good() == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                cz8Var.r = z9;
            } else {
                cz8Var.h = false;
            }
            if (U == 1002 && !equals) {
                cz8Var.u = true;
            }
            cz8Var.n = sz8.K(M.isBlocked(), z12.l0(), equals, U, M.isWorksInfo(), M.isScoreThread());
            cz8Var.e = sz8.I(z12, equals, z12.l0(), this.y0.d0());
            cz8Var.i = S6();
            cz8Var.f = sz8.J(this.y0.z1(), equals, this.y0.d0());
            if (equals && z12.T() != null && z12.T().showPbPrivate()) {
                z4 = true;
            } else {
                z4 = false;
            }
            cz8Var.k = z4;
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
                cz8Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
            }
            cz8Var.t = equals;
            cz8Var.q = this.y0.R1();
            cz8Var.b = true;
            cz8Var.a = sz8.A(this.y0.z1(), equals);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            cz8Var.p = z5;
            cz8Var.j = true;
            cz8Var.o = this.y0.c1();
            cz8Var.d = true;
            if (M.getThreadVideoInfo() == null) {
                z6 = true;
            } else {
                z6 = false;
            }
            cz8Var.c = z6;
            if (z12.h0()) {
                cz8Var.b = false;
                cz8Var.d = false;
                cz8Var.c = false;
                cz8Var.g = false;
                cz8Var.h = false;
            }
            if (TbSingleton.getInstance().mShowCallFans && equals && !z12.h0()) {
                z7 = true;
            } else {
                z7 = false;
            }
            cz8Var.v = z7;
            if (this.G0 != null && (qv8Var = this.y0.G) != null) {
                pp9 V = qv8Var.V();
                if (V != null) {
                    z8 = V.S;
                } else {
                    z8 = false;
                }
                cz8Var.w = z8;
            }
            cz8Var.m = true;
            if (M.isBlocked()) {
                cz8Var.n = false;
                cz8Var.g = false;
                cz8Var.h = false;
            }
            this.G0.h.w(cz8Var);
        }
    }

    public final void s6(String str, int i3, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048736, this, str, i3, eVar) != null) || eVar == null) {
            return;
        }
        qv8 z12 = this.y0.z1();
        TbRichText p7 = p7(str, i3);
        if (p7 == null || (tbRichTextData = p7.X().get(this.x2)) == null) {
            return;
        }
        eVar.f = String.valueOf(p7.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z3 = false;
        if (!tbRichTextData.d0().b0()) {
            eVar.h = false;
            String a4 = rv8.a(tbRichTextData);
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
            imageUrlData.originalUrl = sz8.m(tbRichTextData);
            imageUrlData.originalUrl = sz8.m(tbRichTextData);
            imageUrlData.originalSize = sz8.n(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = sz8.j(tbRichTextData);
            imageUrlData.isLongPic = sz8.i(tbRichTextData);
            imageUrlData.postId = p7.getPostId();
            imageUrlData.mIsReserver = this.y0.K1();
            imageUrlData.mIsSeeHost = this.y0.c1();
            eVar.b.put(a4, imageUrlData);
            if (z12 != null) {
                if (z12.k() != null) {
                    eVar.c = z12.k().getName();
                    eVar.d = z12.k().getId();
                }
                if (z12.M() != null) {
                    eVar.e = z12.M().getId();
                }
                if (z12.r() == 1) {
                    z3 = true;
                }
                eVar.g = z3;
            }
            imageUrlData.threadId = gg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = z12.F().size();
        this.z2 = false;
        eVar.j = -1;
        if (z12.i() != null) {
            i4 = x5(z12.i().a0(), p7, i3, i3, eVar.a, eVar.b);
        } else {
            i4 = i3;
        }
        int i6 = i4;
        for (int i7 = 0; i7 < size; i7++) {
            pp9 pp9Var = z12.F().get(i7);
            if (pp9Var.N() == null || z12.i() == null || z12.i().N() == null || !pp9Var.N().equals(z12.i().N())) {
                i6 = x5(pp9Var.a0(), p7, i6, i3, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (z12 != null) {
            if (z12.k() != null) {
                eVar.c = z12.k().getName();
                eVar.d = z12.k().getId();
            }
            if (z12.M() != null) {
                eVar.e = z12.M().getId();
            }
            if (z12.r() == 1) {
                z3 = true;
            }
            eVar.g = z3;
        }
        eVar.j = i6;
    }

    public final int x5(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z3;
        TbRichTextImageInfo d02;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048749, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i3), Integer.valueOf(i4), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.z2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.X().size();
                int i6 = i3;
                int i7 = -1;
                for (int i8 = 0; i8 < size; i8++) {
                    TbRichTextData tbRichTextData = tbRichText.X().get(i8);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i7++;
                        int i9 = (int) ii.i(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.d0().getWidth() * i9;
                        int height = tbRichTextData.d0().getHeight() * i9;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3 && tbRichTextData.d0().b0()) {
                            if (tbRichTextData.getType() != 20) {
                                String a4 = rv8.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a4)) {
                                    arrayList.add(a4);
                                    if (tbRichTextData != null && (d02 = tbRichTextData.d0()) != null) {
                                        String W = d02.W();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            W = d02.X();
                                        } else {
                                            if (this.q) {
                                                i5 = 17;
                                            } else {
                                                i5 = 18;
                                            }
                                            imageUrlData.urlType = i5;
                                        }
                                        imageUrlData.imageUrl = W;
                                        imageUrlData.imageThumbUrl = W;
                                        imageUrlData.urlThumbType = imageUrlData.urlType;
                                        imageUrlData.originalUrl = sz8.m(tbRichTextData);
                                        imageUrlData.originalSize = sz8.n(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = sz8.j(tbRichTextData);
                                        imageUrlData.isLongPic = sz8.i(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = gg.g(this.y0.S1(), -1L);
                                        imageUrlData.mIsReserver = this.y0.K1();
                                        imageUrlData.mIsSeeHost = this.y0.c1();
                                        if (concurrentHashMap != null) {
                                            concurrentHashMap.put(a4, imageUrlData);
                                        }
                                    }
                                }
                                if (!this.z2) {
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

    public void y6(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048753, this, z3, markData) == null) {
            this.G0.n3();
            this.y0.n3(z3);
            ct4 ct4Var = this.A0;
            if (ct4Var != null) {
                ct4Var.h(z3);
                if (markData != null) {
                    this.A0.i(markData);
                }
            }
            if (this.y0.k1()) {
                g6();
            } else {
                this.G0.J1(this.y0.z1());
            }
        }
    }
}
